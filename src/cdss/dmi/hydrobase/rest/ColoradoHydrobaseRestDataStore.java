package cdss.dmi.hydrobase.rest;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//import DWR.DMI.HydroBaseDMI.HydroBase_StationView;
//import DWR.DMI.HydroBaseDMI.HydroBase_StructMeasTypeView;
//import DWR.DMI.HydroBaseDMI.HydroBase_Util;
//import DWR.DMI.HydroBaseDMI.HydroBase_WISFormat;
//import DWR.DMI.HydroBaseDMI.HydroBase_WISSheetName;

import riverside.datastore.AbstractWebServiceDataStore;

import RTi.DMI.DMIUtil;
import RTi.TS.DayTS;
import RTi.TS.HourTS;
import RTi.TS.IrregularTS;
import RTi.TS.MinuteTS;
import RTi.TS.MonthTS;
import RTi.TS.TS;
import RTi.TS.TSDataFlagMetadata;
import RTi.TS.TSIdent;
import RTi.TS.TSUtil;
import RTi.TS.YearTS;
import RTi.Util.GUI.InputFilter_JPanel;
import RTi.Util.IO.IOUtil;
import RTi.Util.IO.PropList;
import RTi.Util.IO.ReaderInputStream;
import RTi.Util.Message.Message;
import RTi.Util.String.StringUtil;
import RTi.Util.Time.DateTime;
import RTi.Util.Time.TimeInterval;
import cdss.dmi.hydrobase.rest.dao.DiversionByDay;
import cdss.dmi.hydrobase.rest.dao.DiversionByMonth;
import cdss.dmi.hydrobase.rest.dao.DiversionByYear;
import cdss.dmi.hydrobase.rest.dao.DiversionComment;
import cdss.dmi.hydrobase.rest.dao.DiversionStageVolume;
import cdss.dmi.hydrobase.rest.dao.DiversionWaterClass;
import cdss.dmi.hydrobase.rest.dao.Structure;
import cdss.dmi.hydrobase.rest.dao.TelemetryDecodeSettings;

/**
Data store for State of Colorado Division of Water Resources HydroBase REST web services.
This class provides a general interface to the web service, consistent with TSTool conventions.
@author sam
*/
public class ColoradoHydroBaseRestDataStore extends AbstractWebServiceDataStore
{

/**
The web service API version, critical for forming the request URL and parsing the results.
*/
private int __apiVersion = 2; // Default
    
/**
Indicates whether global data store properties have been initialized, set by initialize().
*/
private boolean __initialized = false;

/**
Constructor for web service.
Important, properties other than the default values passed as parameters may be set with a subsequent
call to setProperties().  Consequently, initialization should occur from public called methods to ensure
that information is available for initialization.
*/
public ColoradoHydroBaseRestDataStore ( String name, String description, URI serviceRootURI )
throws URISyntaxException, IOException
{
    setName ( name );
    setDescription ( description );
    setServiceRootURI ( serviceRootURI );
    // Determine the web service version
    determineAPIVersion();
    // OK to initialize since no properties other than the main properties impact anything
    initialize();
}

/**
Factory method to construct a data store connection from a properties file.
@param filename name of file containing property strings
*/
public static ColoradoHydroBaseRestDataStore createFromFile ( String filename )
throws IOException, Exception
{
    // Read the properties from the file
    PropList props = new PropList ("");
    props.setPersistentName ( filename );
    props.readPersistent ( false );
    String name = IOUtil.expandPropertyForEnvironment("Name",props.getValue("Name"));
    String description = IOUtil.expandPropertyForEnvironment("Description",props.getValue("Description"));
    String serviceRootURI = IOUtil.expandPropertyForEnvironment("ServiceRootURI",props.getValue("ServiceRootURI"));
    
    // Get the properties and create an instance

    ColoradoHydroBaseRestDataStore ds = new ColoradoHydroBaseRestDataStore( name, description, new URI(serviceRootURI) );
    ds.setProperties(props);
    return ds;
}

/**
Determine the web service API version.
Will have to edit how version is retrieved from parsing URL - @jurentie
*/
private void determineAPIVersion()
{   String routine = "ColoradoHydrobaseRestDataStore.determineAPIVersion";
    __apiVersion = 2; // Default is most current
    String urlString = "" + getServiceRootURI() + "/version";
    try {
        String resultString = IOUtil.readFromURL(urlString);
        // Format of result is JSON like:  "2.0.0-beta.1"
        // Therefore check the 2nd character
        if ( resultString.length() >= 2 ) {
            if ( resultString.charAt(1) == '1' ) {
                __apiVersion = 1;
            }
            else if ( resultString.charAt(1) != '2' ) {
                String message = "ACIS API version is not supported:  " + resultString;
                Message.printWarning ( 2, routine, message );
                throw new RuntimeException ( message );
            }
        }
    }
    catch ( Exception e ) {
        // Might be disconnected from the internet - usually safe to default to latest version
        Message.printWarning ( 2, routine,
            "Error reading version for web service API using \"" + urlString +
            "\" - possibly due to not being connected to internet.  Assuming version is " + __apiVersion );
    }
}

/**
Return the service API version as determined from determineAPIVersion().
@return the API version
*/
public int getAPIVersion ()
{
    return __apiVersion;
}

/**
Return the unique list of data interval strings available for a data type, returning values that
are consistent with TSTool ("Day", rather than "daily").
@param dataType data type string of form "N" or "N - name" or "name", where N is the major number.
*/
public List<String> getDataIntervalStringsForDataType ( String dataType )
{   List<String> dataIntervalStrings = new ArrayList<String>();
    // For now a data type should only have one interval because of the uniqueness of the data type.
    //RccAcisVariableTableRecord variable = lookupVariable(dataType);
    //String interval = translateAcisIntervalToInternal(variable.getReportInterval());
    //if ( interval != null ) {
    //    dataIntervalStrings.add(interval);
    //}
    return dataIntervalStrings;
}

/**
Return the list of data types that are available.  Currently this returns the major number and optionally
the name.  Duplicates in the table are ignored.
TODO SAM 2011-01-07 It would be good to have the option of using data type abbreviations - work with Bill Noon
on this.
@param includeName whether to include the name
@param includeInterval whether to include the interval as (daily), etc.
*/
public List<String> getDataTypeStrings ( boolean includeName, boolean includeInterval )
{   try {
        initialize();
    }
    catch ( Exception e ) {
        ; // Ignore.
    }
    int version = getAPIVersion();
    List<String> typeList = new Vector<String>();
	/* TODO smalers comment
    RccAcisVariableTableRecord recPrev = null;
    String nameString = "";
    String intervalString = "";
    for ( RccAcisVariableTableRecord rec: __variableTableRecordList ) {
        if ( (typeList.size() > 0) && (rec.getMajor() == recPrev.getMajor()) ) {
            // Same information as previous record so don't add again
            continue;
        }
        nameString = "";
        intervalString = "";
        if ( includeName ) {
            nameString = " - " + rec.getName();
        }
        if ( includeInterval ) {
            intervalString = " (" + rec.getReportInterval() + ")";
        }
        if ( version == 1 ) {
            // Perhaps mistakenly was using the var major for user-facing choices but the
            // abbreviation is used in the REST API so it should be OK to use (do so in version 2+)
            typeList.add( "" + rec.getMajor() + nameString + intervalString );
        }
        else {
            typeList.add( rec.getElem() + nameString + intervalString );
        }
        recPrev = rec;
    }
    */
    return typeList;
}

/**
Initialize internal data store data.
This method should be called from all methods that are likely to be called from external code.
*/
private void initialize ()
throws URISyntaxException, IOException
{
    if ( __initialized ) {
        // Already initialized
        return;
    }
    // Otherwise initialize the global data for the data store
    __initialized = true;
    // Determine the API version from a web request
    if ( getAPIVersion() == 1 ) {
        // Read variables from the HTML file on the website
        //readVariableTableVersion1();
    }
    else {
        // TODO SAM 2012-06-25 where does the list of variables come from for the version 2 API?
        // TODO SAM 2012-07-25 Version 2 documentation lists a few more variables so add below
        // 2012-06-26 Bill Noon pointed to test site (http://scacis.rcc-acis.org/ACIS_Builder.html) but this
        // only shows "Common Element Names" - an API call will be made available
        // Hard-code in order of major variable
        // Elem, major, minor, name, method, measInterval, reportInterval, units, source
        // Version 2 uses the element abbreviation and if VarMajor is not known, use a  negative number
        // All VarMajor need to be unique because duplicates are ignored
        //
        // Precipitation...
    	/* TODO smalers comment
        __variableTableRecordList.add(new RccAcisVariableTableRecord("pcpn", 4, 1, "Precipitation", "sum",
            "daily", "daily", "Inch", ""));
        // Snow...
        __variableTableRecordList.add(new RccAcisVariableTableRecord("snwd", 11, 1, "Snow depth, at obs time", "inst",
            "inst", "daily", "Inch", ""));
        __variableTableRecordList.add(new RccAcisVariableTableRecord("snow", 10, 1, "Snowfall", "sum",
            "daily", "daily", "Inch", ""));
        // Temperature...
        __variableTableRecordList.add(new RccAcisVariableTableRecord("avgt", 43, 1, "Temperature, average", "ave",
            "daily", "daily", "DegF", ""));
        __variableTableRecordList.add(new RccAcisVariableTableRecord("maxt", 1, 1, "Temperature, maximum", "max",
            "daily", "daily", "DegF", ""));
        __variableTableRecordList.add(new RccAcisVariableTableRecord("mint", 2, 1, "Temperature, minimum", "min",
            "daily", "daily", "DegF", ""));
        __variableTableRecordList.add(new RccAcisVariableTableRecord("obst", 3, 1, "Temperature, at obs time", "inst",
            "inst", "daily", "DegF", ""));
        // Degree days based on temperature...
        __variableTableRecordList.add(new RccAcisVariableTableRecord("hdd", 45, 1, "Heating degree days (base 65)", "sum",
            "daily", "daily", "Day", ""));
        __variableTableRecordList.add(new RccAcisVariableTableRecord("cdd", 44, 1, "Cooling degree days (base 65)", "sum",
            "daily", "daily", "Day", ""));
        __variableTableRecordList.add(new RccAcisVariableTableRecord("gdd50", 9990, 1, "Growing degree days (base 50)", "sum",
            "daily", "daily", "Day", ""));
        __variableTableRecordList.add(new RccAcisVariableTableRecord("gdd40", 9991, 1, "Growing degree days (base 40)", "sum",
            "daily", "daily", "Day", ""));
        */
    }
    // Initialize the station types - this may be available as a service at some point but for now inline
    /* TODO smalers
    __stationTypeList.add ( new RccAcisStationType(0,"ACIS","ACIS internal id"));
    __stationTypeList.add ( new RccAcisStationType(1,"WBAN","5-digit WBAN id"));
    __stationTypeList.add ( new RccAcisStationType(2,"COOP","6-digit COOP id"));
    __stationTypeList.add ( new RccAcisStationType(3,"FAA","3-character FAA id"));
    __stationTypeList.add ( new RccAcisStationType(4,"WMO","5-digit WMO id"));
    __stationTypeList.add ( new RccAcisStationType(5,"ICAO","4-character ICAO id"));
    // Note that ACIS documentation calls it GHCN-Daily but daily is the interval so leave out of the station type here
    __stationTypeList.add ( new RccAcisStationType(6,"GHCN","?-character GHCN id"));
    __stationTypeList.add ( new RccAcisStationType(7,"NWSLI","5-character NWSLI"));
    __stationTypeList.add ( new RccAcisStationType(9,"ThreadEx","6-character ThreadEx id"));
    __stationTypeList.add ( new RccAcisStationType(10,"CoCoRaHS","5+ character CoCoRaHS identifier"));
    // AWDN still not officially supported in version 2 (not included in version 2 changelog)?
    __stationTypeList.add ( new RccAcisStationType(16,"AWDN","7-character HPRCC AWDN id"));
    */
}

/**
Look up the station type given the station code (return null if not found).
@param code station code (e.g., 2 for COOP).
*/
/* TODO smalers
public RccAcisStationType lookupStationTypeFromCode ( int code )
{
    for ( RccAcisStationType stationType: __stationTypeList ) {
        if ( stationType.getCode() == code ) {
            return stationType;
        }
    }
    return null;
}
*/

/**
Look up the station type given the station type string (return null if not found).
@param type station type (e.g., "COOP").
*/
/* TODO smalers
public RccAcisStationType lookupStationTypeFromType ( String type )
{   try {
        initialize();
    }
    catch ( Exception e ) {
        // Should not happen
    }
    for ( RccAcisStationType stationType: __stationTypeList ) {
        if ( stationType.getType().equalsIgnoreCase(type) ) {
            return stationType;
        }
    }
    return null;
}
*/

/**
Look up the variable information given the data type, which is a string of the form
"N" or "N - Name" or "Name" where N is the "major" (if an integer, for version 1 API in TSTool) or "elem" if a string
(version 2+ API in TSTool).
@param dataType data type to match in variable data.
@return the ACIS variable that matches the data type.
*/
/* TODO smalers
public RccAcisVariableTableRecord lookupVariable ( String dataType )
{   String elemString = null;
    String name = null;
    int pos = dataType.indexOf("-");
    if ( pos > 0) {
        // Assume that the elem or major variable is specified and also the name
        elemString = dataType.substring(0,pos).trim();
        name = dataType.substring(pos + 1).trim();
    }
    else {
        // Only one piece of information specified, such as the data type from a TSID.
        if ( StringUtil.isInteger(dataType) ) {
            // Actually the varMajor
            elemString = dataType.trim();
        }
        else {
            elemString = dataType.trim();
            name = elemString;
        }
    }
    if ( elemString != null ) {
        if ( StringUtil.isInteger(elemString) ) {
            // Use the major number to look up the variable
            int majorInt = -1;
            try {
                majorInt = Integer.parseInt(elemString);
            }
            catch ( NumberFormatException e ) {
                throw new InvalidParameterException("Data type \"" + dataType + "\" major number is invalid." );
            }
            for ( RccAcisVariableTableRecord variable: __variableTableRecordList ) {
                if ( variable.getMajor() == majorInt ) {
                    return variable;
                }
            }
        }
        else {
            // Use the element to look up the variable
            for ( RccAcisVariableTableRecord variable: __variableTableRecordList ) {
                if ( variable.getElem().equalsIgnoreCase(elemString) ) {
                    return variable;
                }
            }
        }
    }
    else if ( name != null ){
        // Use the variable name to look up the variable
        for ( RccAcisVariableTableRecord variable: __variableTableRecordList ) {
            if ( variable.getName().equalsIgnoreCase(name) ) {
                return variable;
            }
        }
    }
    // No match...
    return null;
}
*/

/**
Read a list of MultiStn data records.
*/
/* TODO smalers
public List<RccAcisStationTimeSeriesMetadata> readStationTimeSeriesMetadataList(
    String dataType, String timeStep, InputFilter_JPanel ifp )
throws IOException, MalformedURLException, URISyntaxException
{   String routine = getClass().getName() + ".readStationTimeSeriesMetadataList";
    // Make sure data store is initialized
    initialize();
    // Look up the metadata for the data types
    RccAcisVariableTableRecord variable = lookupVariable ( dataType );
    int apiVersion = getAPIVersion();
    if ( apiVersion == 1 ) {
        return readStationTimeSeriesMetadataListVersion1 ( dataType, timeStep, ifp );
    }
    // Else, use the current version 2 API, which uses the StnMeta call instead of version 1 MultiStnData call
    // Form the URL - ask for as much metadata as possible
    StringBuffer urlString = new StringBuffer("" + getServiceRootURI() +
        "/StnMeta?meta=sIds,uid,name,state,county,basin,climdiv,cwa,ll,elev,valid_daterange" );
    // Specify constraints from input filter
    // Element being read (currently only one data type per call)...
    urlString.append("&elems="+variable.getElem());
    // Bounding box...
    List<String> bboxList = ifp.getInput(null, "bbox", true, null);
    if ( bboxList.size() > 1 ) {
        throw new IOException ( "<= 1 bounding box filters can be specified." );
    }
    else if ( bboxList.size() == 1 ) {
        String bbox = bboxList.get(0).trim();
        urlString.append("&bbox="+URLEncoder.encode(bbox,"UTF-8"));
    }
    // Climate division (always use newest syntax in filter)...
    List<String> climdivList = ifp.getInput(null, "climdiv", true, null);
    if ( climdivList.size() > 1 ) {
        throw new IOException ( "<= 1 climate division filters can be specified." );
    }
    else if ( climdivList.size() == 1 ) {
        String climdiv = climdivList.get(0).split("-")[0].trim();
        urlString.append("&climdiv="+URLEncoder.encode(climdiv,"UTF-8"));
    }
    // FIPS county...
    List<String> countyList = ifp.getInput(null, "county", true, null);
    if ( countyList.size() > 1 ) {
        throw new IOException ( "<= 1 FIPS county filters can be specified." );
    }
    else if ( countyList.size() == 1 ) {
        String county = countyList.get(0).split("-")[0].trim();
        urlString.append("&county="+URLEncoder.encode(county,"UTF-8"));
    }
    // NWS CWA...
    List<String> cwaList = ifp.getInput(null, "cwa", true, null);
    if ( cwaList.size() > 1 ) {
        throw new IOException ( "<= 1 NWS CWA county filters can be specified." );
    }
    else if ( cwaList.size() == 1 ) {
        String cwa = cwaList.get(0).trim();
        urlString.append("&cwa="+URLEncoder.encode(cwa,"UTF-8"));
    }
    // Drainage basin (HUC)...
    List<String> basinList = ifp.getInput(null, "basin", true, null);
    if ( basinList.size() > 1 ) {
        throw new IOException ( "<= 1 basin filters can be specified." );
    }
    else if ( basinList.size() == 1 ) {
        String basin = basinList.get(0).trim();
        urlString.append("&basin="+URLEncoder.encode(basin,"UTF-8"));
    }
    // State code...
    List<String> stateList = ifp.getInput(null, "state", true, null);
    if ( stateList.size() > 1 ) {
        throw new IOException ( "<= 1 state code filters can be specified." );
    }
    else if ( stateList.size() == 1 ) {
        String state = stateList.get(0).split("-")[0].trim();
        urlString.append("&state="+URLEncoder.encode(state,"UTF-8"));
    }
    // Always want JSON results...
    urlString.append("&output=json");
    Message.printStatus(2, routine, "Performing the following request:  " + urlString );
    String resultString = IOUtil.readFromURL(urlString.toString() );
    if ( Message.isDebugOn ) {
        Message.printDebug(1,routine,"Returned data="+resultString);
    }
    // Check for error in response string...
    if ( resultString.indexOf("error") >= 0 ) {
        throw new IOException ( "Error retrieving data for URL \"" + urlString + "\":  " + resultString );
    }
    else {
        // Parse the JSON
        Gson gson = new Gson();
        RccAcisStationTimeSeriesMetadataList metadataListObject =
            gson.fromJson(resultString, RccAcisStationTimeSeriesMetadataList.class);
        if ( metadataListObject != null ) {
            for ( RccAcisStationTimeSeriesMetadata metadata: metadataListObject.getMeta() ) {
                //Message.printStatus(2,routine,metadata.getName());
                metadata.setVariable(variable);
                metadata.setDataStore ( this );
                // TODO SAM 2011-01-07 Some metadata like HUC do not return so may need to set based
                // on whether the information was entered in the filter
            }
            // Remove records that have no period
            try {
                metadataListObject.cleanupData();
            }
            catch ( Exception e ) {
                Message.printWarning(3, routine, e);
            }
            return metadataListObject.getMeta();
        }
        else {
            // Return an empty list
            List<RccAcisStationTimeSeriesMetadata> data = new Vector<RccAcisStationTimeSeriesMetadata>();
            return data;
        }
    }
}
*/

/* TODO: add all these cases to this method */
public DiversionWaterClass readWaterClassNumForWdid(String wdid, String waterClassReqString,boolean divTotalReq, boolean relTotalReq){

	ObjectMapper mapper = new ObjectMapper();
	
	DiversionWaterClass waterClass = null;
	
	try {
		JsonNode waterClasses = mapper.readTree(new URL(getServiceRootURI() + "/structures/divrec/waterclasses/?wdid=" + wdid));
		JsonNode resultList = waterClasses.path("ResultList");
		for(int i = 0; i < resultList.size(); i++){
			String divrectype = resultList.get(i).get("divrectype").textValue();
			if(divTotalReq){
				if(("DivTotal").equalsIgnoreCase(divrectype)){
					waterClass = mapper.treeToValue(resultList.get(i), DiversionWaterClass.class);
				}
			}else if(relTotalReq){
				if(("RelTotal").equalsIgnoreCase(divrectype)){
					waterClass = mapper.treeToValue(resultList.get(i), DiversionWaterClass.class);
				}
			}else{
				if((waterClassReqString).equals(resultList.get(i).get("wcIdentifier").textValue())){ // Confirm with Steve - wcIdentifier
					waterClass = mapper.treeToValue(resultList.get(i), DiversionWaterClass.class);
				}
			}
		}
	} 
	catch (JsonParseException e ) { e.printStackTrace(); }
	catch (JsonMappingException e ) { e.printStackTrace(); }
	catch (IOException e) { e.printStackTrace(); }
	
	return waterClass;
}

public static void setTimeSeriesProperties ( TS ts, Structure struct )
{   // Use the same names as the database view columns, same order as view
	ts.setProperty("wdid", (struct.getWdid() == null) ? null : new Integer(struct.getWdid()));
	ts.setProperty("structure_name", (struct.getStructureName() == null) ? "" : struct.getStructureName());
	ts.setProperty("associated_akas", (struct.getAssociatedAkas() == null) ? "" : struct.getAssociatedAkas());
	ts.setProperty("ciu_code" , (struct.getCiuCode() == null) ? "" : struct.getCiuCode());
	ts.setProperty("structure_type", (struct.getStructureType() == null) ? "" : struct.getStructureType());
	ts.setProperty("water_source" , (struct.getWaterSource() == null) ? "" : struct.getWaterSource());
	ts.setProperty("gnis_id", (struct.getGnisId() == null) ? "" : struct.getGnisId());
	ts.setProperty("stream_mile", (new Double(struct.getStreamMile()) == null) ? "" : new Double(struct.getStreamMile()));
	ts.setProperty("associated_case_numbers", (struct.getAssociatedCaseNumbers() == null) ? "" : struct.getAssociatedCaseNumbers());
	ts.setProperty("associated_permits", (struct.getAssociatedPermits() == null) ? "" : struct.getAssociatedPermits());
	ts.setProperty("assocaited_meters", (struct.getAssociatedMeters() == null) ? "" : struct.getAssociatedMeters());
	ts.setProperty("associated_contacts", (struct.getAssociatedContacts() == null) ? "" : struct.getAssociatedContacts());
	ts.setProperty("por_start", (struct.getPorStart() == null) ? "" : struct.getPorStart()); // Deal with date time stuff
	ts.setProperty("por_end", (struct.getPorEnd() == null) ? "" : struct.getPorEnd()); // Deal with date time stuff
	ts.setProperty("division", (new Integer(struct.getDivision()) == null) ? "" : new Integer(struct.getDivision()));
	ts.setProperty("water_district", (new Integer(struct.getWaterDistrict()) == null) ? "" : new Integer(struct.getWaterDistrict()));
	ts.setProperty("subdistrict", (struct.getSubdistrict() == null) ? "" : struct.getSubdistrict());
	ts.setProperty("county", (struct.getCounty() == null) ? "" : struct.getCounty());
	ts.setProperty("designated_basin_name", (struct.getDesignatedBasinName() ==null) ? "" : struct.getDesignatedBasinName());
	ts.setProperty("management_district_name", (struct.getManagementDistrictName() == null) ? "" : struct.getManagementDistrictName());
	ts.setProperty("pm", (struct.getPm() == null) ? "" : struct.getPm());
	ts.setProperty("township", (struct.getTownship() == null) ? "" : struct.getTownship());
	ts.setProperty("range", (struct.getRange() == null) ? "" : struct.getRange());
	ts.setProperty("section", (struct.getSection() == null) ? "" : struct.getSection());
	ts.setProperty("q10", (struct.getQ10() == null) ? "" : struct.getQ10());
	ts.setProperty("q40", (struct.getQ40() == null) ? "" : struct.getQ40());
	ts.setProperty("q160", (struct.getQ10() == null) ? "" : struct.getQ160());
	ts.setProperty("coords_ew", (new Integer(struct.getCoordsew()) == null) ? "" : new Integer(struct.getCoordsew()));
	ts.setProperty("coords_ew_dir", (struct.getCoordsewDir() == null) ? "" : struct.getCoordsew());
	ts.setProperty("coords_ns", (new Integer(struct.getCoordsns()) == null) ? "" : new Integer(struct.getCoordsns()));
	ts.setProperty("coords_ns_dir", (struct.getCoordsnsDir() == null) ? "" : struct.getCoordsnsDir());
	ts.setProperty("utmX", (new Double(struct.getUtmX()) == null) ? "" : new Double(struct.getUtmX()));
	ts.setProperty("utmY", (new Double(struct.getUtmY()) == null) ? "" : new Double(struct.getUtmY()));
	ts.setProperty("latdecdeg", (new Double(struct.getLatdecdeg()) == null) ? "" : new Double(struct.getLatdecdeg()));
	ts.setProperty("longdecdeg", (new Double(struct.getLongdecdeg()) == null) ? "" : new Double(struct.getLongdecdeg()));
	ts.setProperty("location_accuracy", (struct.getLocationAccuracy() == null) ? "" : struct.getLocationAccuracy());
	ts.setProperty("modified", (struct.getModified() == null) ? "" : struct.getModified());
}

public JsonNode getJsonNodeResultsFromURL(URL url){
	
	ObjectMapper mapper = new ObjectMapper();
	JsonNode results = null;
	
	try{
		JsonNode divrecRootNode = mapper.readTree(url);
		/*String exampleJsonString = "{\"ResultList\":[{\"wdid\":\"0300503\",\"waterClassNum\":10300503,\"wcIdentifier\":\"0300503 Total (Diversion)\",\"measInterval\":\"Daily\",\"measCount\":26,\"dataMeasDate\":\"2011-06\",\"dataValue\":33.4616,\"measUnits\":\"AF\",\"obsCode\":\"*         \",\"approvalStatus\":\"Approved\",\"modified\":\"2012-05-22T11:11:00\"},{\"wdid\":\"0300503\",\"waterClassNum\":10300503,\"wcIdentifier\":\"0300503 Total (Diversion)\",\"measInterval\":\"Daily\",\"measCount\":6,\"dataMeasDate\":\"2011-07\",\"dataValue\":3.2133,\"measUnits\":\"AF\",\"obsCode\":\"*         \",\"approvalStatus\":\"Approved\",\"modified\":\"2012-05-22T11:11:00\"},{\"wdid\":\"0300503\",\"waterClassNum\":10300503,\"wcIdentifier\":\"0300503 Total (Diversion)\",\"measInterval\":\"Daily\",\"measCount\":4,\"dataMeasDate\":\"2011-08\",\"dataValue\":2.7372,\"measUnits\":\"AF\",\"obsCode\":\"*         \",\"approvalStatus\":\"Approved\",\"modified\":\"2012-05-22T11:11:00\"},{\"wdid\":\"0300503\",\"waterClassNum\":10300503,\"wcIdentifier\":\"0300503 Total (Diversion)\",\"measInterval\":\"Daily\",\"measCount\":17,\"dataMeasDate\":\"2011-09\",\"dataValue\":59.1083,\"measUnits\":\"AF\",\"obsCode\":\"*         \",\"approvalStatus\":\"Approved\",\"modified\":\"2012-05-22T11:11:00\"},{\"wdid\":\"0300503\",\"waterClassNum\":10300503,\"wcIdentifier\":\"0300503 Total (Diversion)\",\"measInterval\":\"Daily\",\"measCount\":1,\"dataMeasDate\":\"2011-10\",\"dataValue\":0,\"measUnits\":\"AF\",\"obsCode\":\"*         \",\"approvalStatus\":\"Approved\",\"modified\":\"2012-05-22T11:11:00\"}]}";
		JsonNode divrecRootNode = mapper.readTree(exampleJsonString);*/
		results = divrecRootNode.path("ResultList");
		//JsonNode results = divrecRootNode;
	}
	catch (JsonParseException e ) { e.printStackTrace(); }
	catch (JsonMappingException e ) { e.printStackTrace(); }
	catch (IOException e) { e.printStackTrace(); }
	
	return results;
}

/**
Read a time series.  Only one element type is read.
@param tsidentString the time series identifier string as per TSTool conventions.  The location should be
LocationType:ID (e.g., COOP:1234).  The data type should be the variable name (might implement abbreviation later but
trying to stay away from opaque variable major).
@param readStart the starting date/time to read, or null to read all data.
@param readEnd the ending date/time to read, or null to read all data.
@param readData if true, read the data; if false, construct the time series and populate properties but do
not read the data
@return the time series read from the ACIS web services
*/
public TS readTimeSeries ( String tsidentString, DateTime readStart, DateTime readEnd, boolean readData )
throws MalformedURLException, Exception
{   
	System.out.println(this.getServiceRootURI());
	
	// Make sure data store is initialized
    initialize();
    TS ts = null;
    String routine = getClass().getName() + ".readTimeSeries";
    
    // 1. Parse the time series identifier (TSID) that was passed in
    TSIdent tsident = TSIdent.parseIdentifier(tsidentString);
	String locid = tsident.getLocation();
    String data_source = tsident.getSource(); // TSID data source
	String data_type = tsident.getType(); // TSID data type 
	String sub_data_type = ""; // Sub-data type.
	
	if(data_type.indexOf("-") > 0){
		// Contains the vax_field or SFUT...
		sub_data_type = StringUtil.getToken ( data_type, "-", 0, 1);
		data_type = StringUtil.getToken ( data_type, "-", 0, 0);
	}
	String interval = tsident.getInterval();

	// 2. Create time series to receive the data.
	ts = TSUtil.newTimeSeries(tsidentString, true);
	int interval_base = ts.getDataIntervalBase();
	
	// 3. TS Configuration:
	ts.setIdentifier(tsidentString);

	// Create ObjectMapper for Jackson 
	ObjectMapper mapper = new ObjectMapper();
	
	String wdid = locid;
	
	// Get Structure
	URL structRequest = new URL(getServiceRootURI() + "/structures/?format=json&wdid=" + wdid);
	JsonNode structRootNode = mapper.readTree(structRequest);
	JsonNode structResults = structRootNode.get("ResultList").get(0);
	
	Structure struct = mapper.treeToValue(structResults, Structure.class);
	
	// Set structure name as TS Description
	ts.setDescription(struct.getStructureName() + " " + data_type);
	
	if(data_type.equalsIgnoreCase("DivTotal") || data_type.equalsIgnoreCase("DivClass")){
		// Diversion records - total through diversion
		// locid is the WDID in this case
		boolean divTotalReq = true;
		boolean relTotalReq = false;
		String waterClassReqString = "";
		
		// Retrieve water class num for given wdid
		DiversionWaterClass waterClassForWdid = readWaterClassNumForWdid(wdid,waterClassReqString,divTotalReq,relTotalReq);
		int waterClassNumForWdid = waterClassForWdid.getWaterclassNum();
		
		URL divRecRequest = null;
		
		if(interval_base == TimeInterval.DAY){
			// Create request URL for web services API
			divRecRequest = new URL(getServiceRootURI() + "/structures/divrec/divrecday/?format=json&wdid=" + wdid + "&waterClassNum=" + waterClassNumForWdid);
			System.out.println(getServiceRootURI() + "/structures/divrec/divrecday/?format=json&wdid=" + wdid + "&waterClassNum=" + waterClassNumForWdid);
		}
		if(interval_base == TimeInterval.MONTH){
			// Create request URL for web services API
			divRecRequest = new URL(getServiceRootURI() + "/structures/divrec/divrecmonth/?format=json&wdid=" + wdid + "&waterClassNum=" + waterClassNumForWdid);
			System.out.println(getServiceRootURI() + "/structures/divrec/divrecmonth/?format=json&wdid=" + wdid + "&waterClassNum=" + waterClassNumForWdid);
			
		}
		if(interval_base == TimeInterval.YEAR){
			// Create request URL for web services API
			divRecRequest = new URL(getServiceRootURI() + "/structures/divrec/divrecyear/?format=json&wdid=" + wdid + "&waterClassNum=" + waterClassNumForWdid);
			System.out.println(getServiceRootURI() + "/structures/divrec/divrecyear/?format=json&wdid=" + wdid + "&waterClassNum=" + waterClassNumForWdid);
		}
		
		// Get JsonNode results give the request URL
		JsonNode results = getJsonNodeResultsFromURL(divRecRequest);
		
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(results));
		
		/* Get first and last date */
		// First Date / Also set ts.setDataUnits() and ts.setDataUnitsOriginal() //
		DateTime firstDate = null;
		if(interval_base == TimeInterval.DAY){ 
			DiversionByDay divRecFirst = mapper.treeToValue(results.get(0), DiversionByDay.class);
			firstDate = new DateTime(DateTime.PRECISION_DAY); 
			firstDate.setYear(divRecFirst.getYear());
			firstDate.setMonth(divRecFirst.getMonth());
			firstDate.setDay(divRecFirst.getDay());
			ts.setDate1Original(firstDate);
			ts.setDataUnits(divRecFirst.getMeasUnits());
			ts.setDataUnitsOriginal(divRecFirst.getMeasUnits());
		}
		if(interval_base == TimeInterval.MONTH){ 
			DiversionByMonth divRecFirst = mapper.treeToValue(results.get(0), DiversionByMonth.class);
			firstDate = new DateTime(DateTime.PRECISION_MONTH); 
			firstDate.setYear(divRecFirst.getYear());
			firstDate.setMonth(divRecFirst.getMonth());
			ts.setDate1Original(firstDate);
			ts.setDataUnits(divRecFirst.getMeasUnits());
			ts.setDataUnitsOriginal(divRecFirst.getMeasUnits());
		}
		if(interval_base == TimeInterval.YEAR){ 
			DiversionByYear divRecFirst = mapper.treeToValue(results.get(0), DiversionByYear.class);
			firstDate = new DateTime(DateTime.PRECISION_YEAR); 
			firstDate.setYear(divRecFirst.getYear());
			ts.setDate1Original(firstDate);
			ts.setDataUnits(divRecFirst.getMeasUnits());
			ts.setDataUnitsOriginal(divRecFirst.getMeasUnits());
		}
		
		// Last Date
		DateTime lastDate = null;
		if(interval_base == TimeInterval.DAY){ 
			DiversionByDay divRecLast = mapper.treeToValue(results.get(results.size() - 1), DiversionByDay.class);
			lastDate = new DateTime(DateTime.PRECISION_DAY); 
			lastDate.setYear(divRecLast.getYear());
			lastDate.setMonth(divRecLast.getMonth());
			lastDate.setDay(divRecLast.getDay());
			ts.setDate2Original(lastDate);
		}
		if(interval_base == TimeInterval.MONTH){ 
			DiversionByMonth divRecLast = mapper.treeToValue(results.get(results.size() - 1), DiversionByMonth.class);
			lastDate = new DateTime(DateTime.PRECISION_MONTH); 
			lastDate.setYear(divRecLast.getYear());
			lastDate.setMonth(divRecLast.getMonth());
			ts.setDate2Original(lastDate);
		}
		if(interval_base == TimeInterval.YEAR){ 
			DiversionByYear divRecLast = mapper.treeToValue(results.get(results.size() - 1), DiversionByYear.class);
			lastDate = new DateTime(DateTime.PRECISION_YEAR); 
			lastDate.setYear(divRecLast.getYear());
			ts.setDate2Original(lastDate);
		}
			
		// Set start and end date
		if(readStart == null){
			ts.setDate1(ts.getDate1Original());
		}else{
			ts.setDate1(readStart);
		}
		if(readEnd == null){
			ts.setDate2(ts.getDate2Original());
		}else{
			ts.setDate2(readEnd);
		}
		
		System.out.println("Date1: " + ts.getDate1());
		System.out.println("Date2: " + ts.getDate2());
		
		System.out.println("Units: " + ts.getDataUnitsOriginal());
			
		// Allocate data space
		ts.allocateDataSpace();
		
		if(interval_base == TimeInterval.DAY){
			ts.setInputName ( "HydroBase daily_amt.amt_*, daily_amt.obs_*");
		}
		if(interval_base == TimeInterval.MONTH){
			ts.setInputName("HydroBase annual_amt.amt_*");
		}
		if(interval_base == TimeInterval.YEAR){
			ts.setInputName ( "HydroBase annual_amt.ann_amt");
		}
		
		ts.setMissing(Double.NaN); // don't need setMissingRange() for now
		
		// 4. Set Properties:
		ts.addToGenesis("read data from web services " + structRequest + " and " + divRecRequest + "."); // might need to add waterclasses URL string
		setTimeSeriesProperties(ts, struct);
		
		// Work out comments:
		
		System.out.println("Genesis: " + ts.getGenesis());
		System.out.println("Properties:\n" + ts.getProperties());
		
		// 5. Read Data: 
		if(readData){
			// Pass Data into TS Object
			if(interval_base == TimeInterval.DAY){
				for(int i = 0; i < results.size(); i++){
					DiversionByDay divRecCurrDay = mapper.treeToValue(results.get(i), DiversionByDay.class);
					
					// Set Date
					DateTime date = new DateTime(DateTime.PRECISION_DAY);
					date.setYear(divRecCurrDay.getYear());
					date.setMonth(divRecCurrDay.getMonth());
					date.setDay(divRecCurrDay.getDay());
					
					// Get Data
					double value = divRecCurrDay.getDataValue();
					
					ts.setDataValue(date, value);
				}
			}
			if(interval_base == TimeInterval.MONTH){
				for(int i = 0; i < results.size(); i++){
					DiversionByMonth divRecCurrMonth = mapper.treeToValue(results.get(i), DiversionByMonth.class);
					
					// Set Date
					DateTime date = new DateTime(DateTime.PRECISION_MONTH);
					date.setYear(divRecCurrMonth.getYear());
					date.setMonth(divRecCurrMonth.getMonth());
					
					// Get Data
					double value = divRecCurrMonth.getDataValue();
					
					ts.setDataValue(date, value);
				}
			}
			if(interval_base == TimeInterval.YEAR){
				for(int i = 0; i < results.size(); i++){
					DiversionByYear divRecCurrYear = mapper.treeToValue(results.get(i), DiversionByYear.class);
					
					// Set Date
					DateTime date = new DateTime(DateTime.PRECISION_YEAR);
					date.setYear(divRecCurrYear.getYear());
					
					// Get Data
					double value = divRecCurrYear.getDataValue();
					
					ts.setDataValue(date, value);
				}
			}
		}
	}
	
    // Look up the metadata for the data name
    //TODO smalers comment
    //commented out proceeding line @jurentie
    /*RccAcisVariableTableRecord variable = lookupVariable ( tsident.getType() );
    if ( variable == null ) {
        throw new IllegalArgumentException("Data type is not recognized:  " + tsident.getType() );
    }*/
    //int apiVersion = getAPIVersion();
    
    // The station ID needs to specify the location type...
    /* commentd out by @jurentie */
    /*String stationIDAndStationType = readTimeSeries_FormHttpRequestStationID ( tsident.getLocationType(), tsident.getLocation() ); */
    // The start and end date are required.
    /*String readStartString = "por";
    String readEndString = "por";
    if ( !readData ) {
        // Specify a minimal period to try a query and make sure that the time series is defined.
        // If this period is not valid for the time series, a missing value will come back.
        // TODO SAM 2012-06-28 Evaluate whether this impacts the number of stations returned since not all
        // will be active on the requested day
        readStart = DateTime.parse("2011-01-01");
        readEnd = DateTime.parse("2011-01-01");
    }
    // TODO SAM 2011-01-21 ACIS always seems to want precision to day on request
    if ( readStart != null ) {
        //if ( intervalBase == TimeInterval.DAY ) {
            readStartString = readStart.toString(DateTime.FORMAT_YYYY_MM_DD);
        //}
        //else if ( intervalBase == TimeInterval.MONTH ) {
        //    readStartString = readStart.toString(DateTime.FORMAT_YYYY_MM);
        //}
        //else if ( intervalBase == TimeInterval.HOUR ) {
        //    readStartString = readStart.toString(DateTime.FORMAT_YYYY_MM_DD_HH);
        //} 
        //else {
        //    readStartString = readStart.toString();
        //}
    }
    if ( readEnd != null ) {
        //if ( intervalBase == TimeInterval.DAY ) {
            readEndString = readEnd.toString(DateTime.FORMAT_YYYY_MM_DD);
        //}
        //else if ( intervalBase == TimeInterval.MONTH ) {
        //    readEndString = readEnd.toString(DateTime.FORMAT_YYYY_MM);
        //}
        //else if ( intervalBase == TimeInterval.HOUR ) {
        //    readEndString = readEnd.toString(DateTime.FORMAT_YYYY_MM_DD_HH);
        //}
        //else {
        //    readEndString = readEnd.toString();
        //}
    }*/
   
    // Only one data type is requested as per readTimeSeries() conventions
    /*String elems = "";
    if ( apiVersion == 1 ) {
        // Version 1 uses var major number
        // Note this may cause an error if VarMajor is not known, but since the Version 1 API is obsolete
        // this hopefully should not be an issue.
        elems = "" + variable.getMajor();
    }
    else {
        // Version 2 uses element name or var major (but use element name because some data types don't
        // seem to have documented var major)
        elems = "" + variable.getElem();
    }
    // Form the URL - no need to ask for metadata?
    // Always specify the station id type to avoid ambiguity
    boolean requestJSON = true; // JSON more work to parse, CSV is verified to work
    if ( apiVersion == 1 ) {
        // Version 1 worked with CSV so leave it as is
        // For version 2 can focus on new features in JSON
        requestJSON = false;
    }
    StringBuffer urlString = new StringBuffer("" + getServiceRootURI() + "/StnData" );
    if ( requestJSON ) {
        urlString.append("?output=json");
    }
    else {
        // Request CSV
        urlString.append("?output=csv");
    }
    // Only JSON format allows metadata to be requested
    // Version 1 requires sId... whereas version 2 is case-independent
    if ( requestJSON ) {
        urlString.append( "&meta=sIds,uid,name,state,county,basin,climdiv,cwa,ll,elev,valid_daterange" );
    }
    urlString.append( "&sId=" +
         URLEncoder.encode(stationIDAndStationType,"UTF-8") +
         "&elems=" + elems + "&sDate=" + readStartString + "&eDate=" + readEndString );
    String urlStringEncoded = urlString.toString(); //URLEncoder.encode(urlString.toString(),"UTF-8");
    Message.printStatus(2, routine, "Performing the following request:  " + urlStringEncoded );
    String resultString = IOUtil.readFromURL(urlStringEncoded);
    //Message.printStatus(2,routine,"Returned string="+resultString);
    if ( Message.isDebugOn ) {
        Message.printDebug(1,routine,"Returned string="+resultString);
    }
    if ( resultString.indexOf("error") >= 0 ) {
        throw new IOException ( "Error retrieving data for URL \"" + urlStringEncoded +
            "\":  " + resultString );
    }
    else {
        RccAcisStationTimeSeriesMetaAndData metaAndData = null;
        if ( requestJSON ) {
            // Parse the JSON for time series ("meta" and "data)
            Gson gson = new Gson();
            metaAndData = gson.fromJson(resultString, RccAcisStationTimeSeriesMetaAndData.class);
            // Should only be one record since a specific time series is requested
            if ( metaAndData == null ) {
                throw new IOException ( "Expecting metadata for 1 time series, no metadata returned." );
            }
            else {
                metaAndData.getMeta().setVariable(variable);
                metaAndData.getMeta().setDataStore ( this );
            }
        }
        else {
            // No metadata for CSV.  Get the station name from the first line of data
        }
        // Create the time series.
        ts = TSUtil.newTimeSeries(tsidentString, true);
        ts.setIdentifier(tsidentString);
        ts.setMissing(Double.NaN);// Use this instead of legacy default -999
        // Parse the data into short strings
        String [] dataStringsArray = new String[0];
        DateTime dataStart = null; // Determined from data records
        DateTime dataEnd = null;
        DateTime validDataStart = null; // Determined from valid_daterange metadata (only if JSON)
        DateTime validDataEnd = null;
        String stationName = "";
        int mCount = 0;
        int tCount = 0;
        int commaPos = 0; // Position of comma
        // Set the time series properties from returned data
        String [][] data = null;
        int nData = 0; // Number of records to process
        int iFirstData = 0; // Index of first data record to process
        if ( requestJSON ) {
            // Set time series properties from the metadata
            stationName = metaAndData.getMeta().getName();
            data = metaAndData.getData();
            nData = data.length; // Number of rows in 2D array
            iFirstData = 0;
            Message.printStatus(2, routine, "Have " + nData + " data records." );
            if ( nData > 0 ) {
                dataStart = DateTime.parse(data[iFirstData][0]);
                dataEnd = DateTime.parse(data[nData - 1][0]);
            }
            // Also get the valid data start and end from the metadata
            validDataStart = DateTime.parse(metaAndData.getMeta().getValid_daterange()[0][0]);
            validDataEnd = DateTime.parse(metaAndData.getMeta().getValid_daterange()[0][1]);
        }
        else {
            // Used by default with version 1 API...
            // CSV, each newline delimited row has YYYY-MM-DD,valueFlag
            // (Flag character is optional) with the first line being the station name
            dataStringsArray = resultString.split("\n");
            Message.printStatus(2, routine, "Have " + dataStringsArray.length + " data records (first is station name)." );
            nData = dataStringsArray.length;
            iFirstData = 1; // Station name is record 1
            if ( nData > 1 ) {
                stationName = dataStringsArray[0];
                commaPos = dataStringsArray[1].indexOf(",");
                dataStart = DateTime.parse(dataStringsArray[1].substring(0,commaPos));
                commaPos = dataStringsArray[dataStringsArray.length - 1].indexOf(",");
                dataEnd = DateTime.parse(dataStringsArray[dataStringsArray.length - 1].substring(0,commaPos));
                // Since CSV does not have metadata and not doing a round-trip would be a hit, use the same dates
                validDataStart = new DateTime(dataStart);
                validDataEnd = new DateTime(dataEnd);
            }
        }
        ts.setDataUnits(variable.getUnits());
        ts.setDataUnitsOriginal(variable.getUnits());
        ts.setDescription(stationName);
        boolean setPropertiesFromMetadata = true;
        if ( setPropertiesFromMetadata ) {
            // Set time series properties from the station metadata
            if ( metaAndData != null ) {
                // Get metadata from the object and set as properties, using the JSON property names
                RccAcisStationTimeSeriesMetadata meta = metaAndData.getMeta();
                ts.setProperty("uid", (meta.getUid() == null) ? "" : meta.getUid() );
                ts.setProperty("name", (meta.getName() == null) ? "" : meta.getName() );
                ts.setProperty("county", (meta.getCounty() == null) ? "" : meta.getCounty() );
                ts.setProperty("basin", (meta.getBasin() == null) ? "" : meta.getBasin() );
                ts.setProperty("climdiv", (meta.getClimdiv() == null) ? "" : meta.getClimdiv() );
                ts.setProperty("cwa", (meta.getCwa() == null) ? "" : meta.getCwa() );
                ts.setProperty("state", (meta.getState() == null) ? "" : meta.getState() );
                ts.setProperty("elev", new Double(meta.getElev()) );
                double [] ll = meta.getLl();
                if ( (ll != null) && (ll.length == 2) ) {
                    ts.setProperty("longitude", new Double(ll[0]) );
                    ts.setProperty("latitude", new Double(ll[1]) );
                }
                String [] sids = meta.getSids();
                if ( sids != null ) {
                    // Set each identifier for the different station types
                    for ( int i = 0; i < sids.length; i++ ) {
                        // Each string is "ID type"
                        String [] parts = sids[i].split(" ");
                        if ( (parts != null) && (parts.length == 2) ) {
                            // Set a property "ID-type"
                            RccAcisStationType stype = lookupStationTypeFromCode(Integer.parseInt(parts[1]));
                            if ( stype != null ) {
                                ts.setProperty("ID-" + stype.getType(), parts[0] );
                            }
                        }
                    }
                }
                // Also set the preferred identifier with location type so it can be used to read the time series
                ts.setProperty("IDWithLocType", meta.getIDPreferred(true));
                // Valid dates will only have two dates since one element was requested
                String [][] validDates = meta.getValid_daterange();
                if ( validDates.length > 0 ) {
                    if ( validDates[0].length == 2 ) {
                        ts.setProperty("valid_daterange1", validDates[0][0] );
                        ts.setProperty("valid_daterange2", validDates[0][1] );
                    }
                }
            }
        }
        // Since there is no way currently to retrieve the separate periods, set both to what was retrieved.
        ts.setDate1(dataStart);
        ts.setDate2(dataEnd);
        ts.setDate1Original(validDataStart);
        ts.setDate2Original(validDataEnd);
        DateTime date = null;
        String [] dataStringParts = null;
        String dateString = ""; // string containing the date
        String valueString = ""; // string containing value and optionally flag part of data
        String flagString; // string containing flag part of data (split out of "valueString")
        int valueStringLength;
        // Nolan Doesken and Bill Noon indicate that 0 is what people use for trace
        double traceValue = 0.0;
        double missing = ts.getMissing(); // Will be Double.NaN, based on initialization
        if ( readData ) {
            ts.allocateDataSpace();
            // Process each data string.  Trace values result in setting the data flag.
            for ( int i = iFirstData; i < nData; i++ ) {
                try {
                    if ( requestJSON ) {
                        dateString = data[i][0];
                        valueString = data[i][1];
                    }
                    else {
                        // CSV
                        dataStringParts = dataStringsArray[i].split(",");
                        dateString = dataStringParts[0];
                        valueString = dataStringParts[1];
                    }
                    //Message.printStatus(2,routine,"Date="+dateString+", value="+valueString);
                    date = DateTime.parse(dateString);
                    valueStringLength = valueString.length();
                    if ( valueString.equals("M") ) {
                        // No value and missing flag.  Do set a flag since ACIS specific sets a flag
                        ts.setDataValue(date, missing, "M", 0 );
                        ++mCount;
                    }
                    else if ( valueString.equals("T") ) {
                        // No value and trace flag.  Do set a flag since ACIS specific sets a flag
                        ts.setDataValue(date, traceValue, "T", 0 );
                        ++tCount;
                    }
                    // Check for data string form ##F or ##F1 (two one-character flags may occur, with
                    // the second flag possibly being a character or digit)
                    else if ( (valueString.length() > 0) &&
                        Character.isLetter(valueString.charAt(valueStringLength - 1)) ) {
                        flagString = valueString.substring(valueStringLength - 1);
                        valueString = valueString.substring(0,valueStringLength - 1);
                        if ( valueString.length() > 0 ) {
                            ts.setDataValue(date, Double.parseDouble(valueString), flagString, 0 );
                        }
                        else {
                            // Only flag was available
                            ts.setDataValue(date, missing, flagString, 0 );
                        }
                    }
                    else if ( (valueString.length() > 1) &&
                        Character.isLetter(valueString.charAt(valueStringLength - 2)) ) {
                        flagString = valueString.substring(valueStringLength - 2);
                        valueString = valueString.substring(0,valueStringLength - 2);
                        ts.setDataValue(date, Double.parseDouble(valueString), flagString, 0 );
                        if ( valueString.length() > 0 ) {
                            ts.setDataValue(date, Double.parseDouble(valueString), flagString, 0 );
                        }
                        else {
                            // Only flag was available
                            ts.setDataValue(date, missing, flagString, 0 );
                        }
                    }
                    else {
                        // Just the data value
                        ts.setDataValue(date,Double.parseDouble(valueString));
                    }
                }
                catch ( NumberFormatException e ) {
                    Message.printWarning(3,routine,"Error parsing data point date=" + dateString + " valueString=\"" +
                        valueString + "\" (" + e + ") - treating as flagged data.");
                    // TODO SAM 2011-04-04 Have seen data values like "S", "0.20A".  Should these be
                    // considered valid data points or treated as missing because they failed some test?
                    // Submitted an email request to the ACIS contact page to see if I can get an answer.
                    // For now, strip the characters off the end and treat as the flag and use the numerical
                    // part (if present) for the value.
                    int lastDigitPos = -1;
                    for ( int iChar = valueString.length() - 1; iChar >= 0; iChar-- ) {
                        if ( Character.isDigit(valueString.charAt(iChar)) ) {
                            lastDigitPos = iChar;
                            break;
                        }
                    }
                    if ( lastDigitPos >= 0 ) {
                        String number = valueString.substring(0,lastDigitPos);
                        if ( StringUtil.isDouble(number) ) {
                            ts.setDataValue(date,Double.parseDouble(number),
                                valueString.substring(lastDigitPos + 1),0);
                        }
                        else {
                            // Set the entire string as the flag
                            ts.setDataValue(date,ts.getMissing(),valueString,0);
                        }
                    }
                    else {
                        ts.setDataValue(date,ts.getMissing(),valueString,0);
                    }
                }
                catch ( Exception e ) {
                    Message.printWarning(3,routine,"Error parsing data point date=" + dateString + ", valueString=\"" +
                        valueString + "\" (" + e + ").");
                }
            }
        }
        if ( tCount > 0 ) {
            // Add a specific data flag type 
            ts.addDataFlagMetadata(new TSDataFlagMetadata("T", "Trace - value of " + traceValue + " is used."));
        }
        if ( mCount > 0 ) {
            // Add a specific data flag type 
            ts.addDataFlagMetadata(new TSDataFlagMetadata("M", "Missing value."));
        }
    }*/
	
    System.out.println("return: " + ts);
    return ts;
}

/**
Form the station ID string part of the time series request, something like "Type:ID" (e.g., "GHCN:USC00016643"),
where ID is the station.
@param tsidLocationType the location type part of a time series identifier (station ID network abbreviation).
@param tsidLocation the location part of a time series identifier (station ID).
*/
private String readTimeSeries_FormHttpRequestStationID ( String tsidLocationType, String tsidLocation )
{
    if ( tsidLocationType.length() == 0 ) {
        throw new InvalidParameterException ( "Station location type abbreviation is not specified." );
    }
    try {
    	/* TODO smalers 2018-06-09 comment out
        RccAcisStationType stationType = lookupStationTypeFromType(tsidLocationType.trim());
        if ( stationType == null ) {
            throw new InvalidParameterException ( "Station code from \"" + tsidLocation +
                "\" cannot be determined." );
        }
        else if ( stationType.getCode() == 0 ) {
            // No station type code is expected since the ACIS type, just pass ACIS ID
            return tsidLocation.trim();
        }
        else {
            // Station ID followed by the station type code
            return tsidLocation.trim() + " " + stationType.getCode();
        }
        */
    	return "";
    }
    catch ( NumberFormatException e ) {
        throw new InvalidParameterException ( "Station location \"" + tsidLocation +
        "\" is invalid (should be Type:ID)" );
    }
}


/**
 * Inserting main method for testing purposes:
 * @throws URISyntaxException 
 */
public static void main(String[] args) throws URISyntaxException{
	
	URI uri = new URI("http://dnrweb.state.co.us/DWR/DwrApiService/api/v2");
	
	try {
		ColoradoHydroBaseRestDataStore chrds = new ColoradoHydroBaseRestDataStore("DWR", "Colorado Division of Water Resources Hydrobase", uri);
		
		/* DateTime date1 = new DateTime(DateTime.PRECISION_MONTH);
		date1.setYear(2011);
		date1.setMonth(6);
		
		DateTime date2 = new DateTime(DateTime.PRECISION_MONTH);
		date2.setYear(2016);
		date2.setMonth(9); */
		
		chrds.readTimeSeries("0300503.DWR.DivTotal.Month~ColoradoHydroBaseRest", null, null, true);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}