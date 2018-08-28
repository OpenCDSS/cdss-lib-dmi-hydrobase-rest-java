package cdss.dmi.hydrobase.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import riverside.datastore.AbstractWebServiceDataStore;
import RTi.DMI.DMISelectStatement;
import RTi.DMI.DMIUtil;
import RTi.TS.TS;
import RTi.TS.TSData;
import RTi.TS.TSIdent;
import RTi.TS.TSIterator;
import RTi.TS.TSUtil;
import RTi.Util.GUI.InputFilter;
import RTi.Util.IO.IOUtil;
import RTi.Util.IO.PropList;
import RTi.Util.Message.Message;
import RTi.Util.String.StringUtil;
import RTi.Util.Time.DateTime;
import RTi.Util.Time.TimeInterval;
import cdss.dmi.hydrobase.rest.ui.ColoradoHydroBaseRest_Station_InputFilter_JPanel;
import cdss.dmi.hydrobase.rest.ui.ColoradoHydroBaseRest_Structure_InputFilter_JPanel;
import cdss.dmi.hydrobase.rest.ui.ColoradoHydroBaseRest_TelemetryStation_InputFilter_JPanel;
import cdss.dmi.hydrobase.rest.ui.ColoradoHydroBaseRest_Well_InputFilter_JPanel;
import cdss.dmi.hydrobase.rest.dao.AdministrativeCalls;
import cdss.dmi.hydrobase.rest.dao.DiversionByDay;
import cdss.dmi.hydrobase.rest.dao.DiversionByMonth;
import cdss.dmi.hydrobase.rest.dao.DiversionByYear;
import cdss.dmi.hydrobase.rest.dao.DiversionComments;
import cdss.dmi.hydrobase.rest.dao.DiversionStageVolume;
import cdss.dmi.hydrobase.rest.dao.DiversionWaterClass;
import cdss.dmi.hydrobase.rest.dao.ParcelUseTimeSeries;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesCounty;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesCurrentInUseCodes;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesDesignatedBasin;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesDivRecObservationCodes;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesDivRecTypes;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesDiversionNotUsedCodes;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesGroundwaterPublication;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesManagementDistrict;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesPermitActionName;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesTelemetryParams;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesWaterDistrict;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesWaterDivision;
import cdss.dmi.hydrobase.rest.dao.Station;
import cdss.dmi.hydrobase.rest.dao.Structure;
import cdss.dmi.hydrobase.rest.dao.TelemetryDecodeSettings;
import cdss.dmi.hydrobase.rest.dao.TelemetryDischargeMeasurement;
import cdss.dmi.hydrobase.rest.dao.TelemetryRatingTable;
import cdss.dmi.hydrobase.rest.dao.TelemetryShift;
import cdss.dmi.hydrobase.rest.dao.TelemetryStation;
import cdss.dmi.hydrobase.rest.dao.TelemetryStationDataTypes;
import cdss.dmi.hydrobase.rest.dao.TelemetryTimeSeries;
import cdss.dmi.hydrobase.rest.dao.WaterLevelsWell;
import cdss.dmi.hydrobase.rest.dao.WaterLevelsWellMeasurement;
import cdss.dmi.hydrobase.rest.dao.WaterRightsNetAmount;
import cdss.dmi.hydrobase.rest.dao.WaterRightsTransaction;
import cdss.dmi.hydrobase.rest.dao.WellPermit;
import cdss.dmi.hydrobase.rest.dto.JacksonToolkit;

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
 * Global variables created to store cached data
 */
private List<ReferenceTablesCounty> countyList = null;

private List<ReferenceTablesCurrentInUseCodes> currentInUseCodeList = null;

private List<ReferenceTablesDesignatedBasin> designatedBasinList = null;

private List<ReferenceTablesDiversionNotUsedCodes> diversionNotUsedCodeList = null;

private List<ReferenceTablesDivRecObservationCodes> divRecObservationCodeList = null;

private List<ReferenceTablesDivRecTypes> divRecTypeList = null;

private List<ReferenceTablesGroundwaterPublication> groundwaterPublicationList = null;

private List<ReferenceTablesManagementDistrict> managementDistrictList = null;

private List<ReferenceTablesPermitActionName> permitActionNameList = null;

private List<ReferenceTablesTelemetryParams> telemetryParamsList = null;

private List<ReferenceTablesWaterDistrict> waterDistrictList = null;

private List<ReferenceTablesWaterDivision> waterDivisionList = null;

private List<ParcelUseTimeSeries> parcelUseTSList = null;

/**
 * Returns a JsonNode using the ObjectMapper from the Jackson package given a URL
 * request from the DWR REST API.
 * @param url request to be parsed by ObjectMapper
 * @return ResultList JsonNode from DWR REST API request
 */
/*public static JsonNode getJsonNodeResultsFromURLString(String url){
	String routine = "ColoradoHydroBaseRestDataStore.getJsonNodeResultsFromURLString";
	ObjectMapper mapper = new ObjectMapper();
	JsonNode results = null;
	
	try{
		URL request = new URL(url);
		JsonNode divrecRootNode = mapper.readTree(request);
		int pageCount = divrecRootNode.get("PageCount").asInt();
		if(pageCount > 1){
			results = getJsonNodeResultsFromURLStringMultiplePages(url, pageCount);
			//System.out.println("[ColoradoHydroBaseRestDataStore.getJsonNodeResultsFromURLString] Unable to process multiple pages at this time. Needs updated.");
		}else{
			results = divrecRootNode.path("ResultList");
		}
	}
	catch (JsonParseException e ) { 
		Message.printWarning(1, routine, "Error querying results from (" + e + ")");
		return null;
	}
	catch (JsonMappingException e ) { 
		Message.printWarning(1, routine, "Error querying results from (" + e + ")");
		return null;
	}
	catch (IOException e) { 
		Message.printWarning(1, routine, e);
		return null;
	}
	
	
	return results;
}

public static JsonNode getJsonNodeResultsFromURLStringMultiplePages(String url, int pageCount){
	String routine = "ColoradoHydroBaseRestDataStore.getJsonNodeResultsFromURLStringsMultiplePages";
	//Add page index 1 to url
	String request = url += "&pageIndex=1";
	JsonNode tempNode = null;
	ObjectMapper mapper = new ObjectMapper();
	
	//Set tempNode to be the returned results from the first page 
	try {
		tempNode = mapper.readTree(new URL(request));
	} 
	catch (JsonParseException e ) { 
		Message.printWarning(1, routine, "Error querying results from (" + e + ")");
		return null;
	}
	catch (JsonMappingException e ) { 
		Message.printWarning(1, routine, "Error querying results from (" + e + ")");
		return null;
	}
	catch (IOException e) { 
		Message.printWarning(1, routine, e);
		return null;
	}
	
	//Create an array node that will contain the results from the various pages
	ArrayNode results = (ArrayNode) tempNode.path("ResultList");
	
	try{
		//Set i=2 since the first page is added previous to stepping through the loop
		for(int i = 2; i < (pageCount + 1) ; i++){
			request += "&pageIndex=" + (i); 
			tempNode = mapper.readTree(new URL(request));
			JsonNode values = tempNode.path("ResultList");
			for(int j = 0; j < values.size(); j++){
				results.add(values.get(j));
			}
		}
	}
	catch (JsonParseException e ) { 
		Message.printWarning(1, routine, "Error querying results from (" + e + ")");
		return null;
	}
	catch (JsonMappingException e ) { 
		Message.printWarning(1, routine, "Error querying results from (" + e + ")");
		return null;
	}
	catch (IOException e) { 
		Message.printWarning(1, routine, e);
		return null;
	}
	return (JsonNode)results;
}*/

/*private List<ParcelUseTimeSeries> getParcelUseTSList(int cal_year, int div, int parcel_id,
		String land_use, String irrig_type){	
	List<ParcelUseTimeSeries> parcelUseTSList = new ArrayList<ParcelUseTimeSeries>(); 
	//Create ObjectMapper for Jackson
	ObjectMapper mapper = new ObjectMapper();
	String apiKeyString = ( apiKey == null || apiKey.isEmpty()) ? "" : "&apiKey=" + apiKey;
	if(land_use != null){
		System.out.println("[ColoradoHydroBaseRestDataStore.getParcelUseTSList:344] Currently querying by {land use} is not supported by DWR web services.");
	}
	if(irrig_type != null){
		System.out.println("[ColoradoHydroBaseRestDataStore.getParcelUseTSList:344] Currently querying by {irrig_type} is not supported by DWR web services.");
	}
	if(div > 0){
		System.out.println("[ColoradoHydroBaseRestDataStore.getParcelUseTSList:344] Currently querying by {div} is not supported by DWR web services.");
	}
	
	return null;

}*/

/**
Form the station ID string part of the time series request, something like "Type:ID" (e.g., "GHCN:USC00016643"),
where ID is the station.
@param tsidLocationType the location type part of a time series identifier (station ID network abbreviation).
@param tsidLocation the location part of a time series identifier (station ID).
*/
/*private String readTimeSeries_FormHttpRequestStationID ( String tsidLocationType, String tsidLocation )
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
        
    	return "";
    }
    catch ( NumberFormatException e ) {
        throw new InvalidParameterException ( "Station location \"" + tsidLocation +
        "\" is invalid (should be Type:ID)" );
    }
}*/

//Unused Code:
/**
Return the unique list of data interval strings available for a data type, returning values that
are consistent with TSTool ("Day", rather than "daily").
@param dataType data type string of form "N" or "N - name" or "name", where N is the major number.
*/
/*public List<String> getDataIntervalStringsForDataType ( String dataType )
{   List<String> dataIntervalStrings = new ArrayList<String>();
  // For now a data type should only have one interval because of the uniqueness of the data type.
  //RccAcisVariableTableRecord variable = lookupVariable(dataType);
  //String interval = translateAcisIntervalToInternal(variable.getReportInterval());
  //if ( interval != null ) {
  //    dataIntervalStrings.add(interval);
  //}
  return dataIntervalStrings;
}*/

/**
Return the list of data types that are available.  Currently this returns the major number and optionally
the name.  Duplicates in the table are ignored.
TODO SAM 2011-01-07 It would be good to have the option of using data type abbreviations - work with Bill Noon
on this.
@param includeName whether to include the name
@param includeInterval whether to include the interval as (daily), etc.
*/
/*public List<String> getDataTypeStrings ( boolean includeName, boolean includeInterval )
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
  
  return typeList;
}*/

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

/**
Constructor for web service.
Important, properties other than the default values passed as parameters may be set with a subsequent
call to setProperties().  Consequently, initialization should occur from public called methods to ensure
that information is available for initialization.
*/
public ColoradoHydroBaseRestDataStore ( String name, String description, URI serviceRootURI, String apiKey )
throws URISyntaxException, IOException
{
    setName ( name );
    setDescription ( description );
    setServiceRootURI ( serviceRootURI );
    setApiKey(apiKey);
    // Determine the web service version
    determineAPIVersion();
    // OK to initialize since no properties other than the main properties impact anything
    initialize();
    // Set up local objects to be cached
    readGlobalData();
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
    String apiKey = IOUtil.expandPropertyForEnvironment("apiKey",props.getValue("apiKey"));
    
    // Get the properties and create an instance

    ColoradoHydroBaseRestDataStore ds = new ColoradoHydroBaseRestDataStore( name, description, new URI(serviceRootURI), apiKey);
    ds.setProperties(props);
    return ds;
}

/**
 * Determine the web service API version. This will set 
 * __apiVersion to be the integer of the API service version number 
 * found at the end of the service request URI. 
 * For example: 
 * https://dnrweb.state.co.us/DWR/DwrApiService/api/v2 
 * will return 2.
 */
private void determineAPIVersion()
{   
	String routine = "ColoradoHydroBaseRestDataStore.determineAPIVersion";
	String uriString = getServiceRootURI().toString();
	int indexOf = uriString.lastIndexOf("/");
	int version = Integer.parseInt(uriString.substring(indexOf + 2, uriString.length()));
	Message.printStatus(2, routine, "DWR REST services API version = " + version);
	__apiVersion = version;
}

// NEW CODE IN PROGRESS:
public AdministrativeCalls getAdministrativeCalls(String callId){
	String request = getServiceRootURI() + "/administrativecalls/" + callId + "?format=json";
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request).get(0);
	AdministrativeCalls ac = (AdministrativeCalls)JacksonToolkit.getInstance().treeToValue(results, AdministrativeCalls.class);
	return ac;
}

/**
 * Initialize APIKey from properties list 
 * @return apiKey
 */
private String getApiKeyString(){
	return (getApiKey() == null || getApiKey() == "") ? "" : "&apiKey=" + getApiKey();
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
 * Get the list of counties from global variable
 * @return list of counties
 */
public List<ReferenceTablesCounty> getCounties(){
	if(countyList == null){
		readCounties();
	}
	return countyList;
}

public List<ReferenceTablesCurrentInUseCodes> getCurrentInUseCodes(){
	if(currentInUseCodeList == null){
		readCurrentInUseCodes();
	}
	return currentInUseCodeList;
}

public List<ReferenceTablesDesignatedBasin> getDesignatedBasin(){
	if(designatedBasinList == null){
		readDesignatedBasins();
	}
	return designatedBasinList;
}

public List<DiversionComments> getDivComments(String wdid, String modified, int irrYear){
	//String routine = "ColoradoHydroBaseRestDataStore.getDivComments";
	List<DiversionComments> divComments = new ArrayList<DiversionComments>();
	String request = getServiceRootURI() + "/structures/divrec/comments/" + wdid + "?apiKey=" + getApiKey();
	if(!(modified == null || modified == "")){
		request += "&modified=" + modified;
	}
	if(irrYear > -1){
		request += "&irrYear=" + Integer.toString(irrYear);
	}
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request);
	for(int i = 0; i < results.size(); i++){
		DiversionComments divComment = (DiversionComments)JacksonToolkit.getInstance().treeToValue(results.get(i), DiversionComments.class);
		divComments.add(divComment);
	}
	return divComments;
}

public List<ReferenceTablesDiversionNotUsedCodes> getDiversionNotUsedCodes(){
	if(diversionNotUsedCodeList == null){
		readDiversionNotUsedCodes();
	}
	return diversionNotUsedCodeList;
}

public List<DiversionStageVolume> getDiversionStageVolume(String wdid, String dataMeasDate, String modified){
	List<DiversionStageVolume> divStageVolList = new ArrayList<DiversionStageVolume>();
	String request = getServiceRootURI() + "/structures/divrec/stagevolume/" + wdid + "?format=json";
	if(!(modified == null || modified == "")){
		request += "&modified=" + modified;
	}
	if(!(dataMeasDate == null || dataMeasDate == "")){
		try {
			request +="&dataMeasDate=" + URLEncoder.encode(dataMeasDate, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request);
	for(int i = 0; i < results.size(); i++){
		DiversionStageVolume divStageVol = (DiversionStageVolume)JacksonToolkit.getInstance().treeToValue(results.get(i), DiversionStageVolume.class);
		divStageVolList.add(divStageVol);
	}
	return divStageVolList;
}

public List<ReferenceTablesDivRecObservationCodes> getDivRecObservationCodes(){
	if(divRecObservationCodeList == null){
		readDivRecObservationCodes();
	}
	return divRecObservationCodeList;
}

public List<ReferenceTablesDivRecTypes> getDivRecTypes(){
	if(divRecTypeList == null){
		readDivRecTypes();
	}
	return divRecTypeList;
}

public List<ReferenceTablesGroundwaterPublication> getGroundwaterPublication(){
	if(groundwaterPublicationList == null){
		readGroundwaterPublication();
	}
	return groundwaterPublicationList;
}

public List<ReferenceTablesManagementDistrict> getManagementDistrict(){
	if(managementDistrictList == null){
		readManagementDistrict();
	}
	return managementDistrictList;
}

public void getParcelUseTSList(String wdid){	
	String routine = "ColoradoHydroBaseRestDataStore.getParcelUseTSList";
	List<ParcelUseTimeSeries> parcelUseTSList = new ArrayList<ParcelUseTimeSeries>(); 
	String parcelUseRequest = getServiceRootURI() + "/structures/parcelusets/" + wdid + "?apiKey=" + getApiKey();
	JsonNode parcelUseResult = JacksonToolkit.getInstance().getJsonNodeFromWebServices(parcelUseRequest);
	int div = getWaterDivisionFromWaterDistricts(wdid);
	for(int i = 0; i < parcelUseResult.size(); i++){
		ParcelUseTimeSeries parcelUseTS = (ParcelUseTimeSeries)JacksonToolkit.getInstance().treeToValue(parcelUseResult.get(i), ParcelUseTimeSeries.class);
		// Add div to parcelUseTS
		parcelUseTS.setDiv(div);
		parcelUseTSList.add(parcelUseTS);
	}
	Collections.sort(parcelUseTSList, new ColoradoHydroBaseRest_ParcelUseTimeSeries_DivParcelIdCalYear());
	this.parcelUseTSList = parcelUseTSList;
}


public List<ParcelUseTimeSeries> getParcelUseTSListFromParcelId(String wdid, int parcel_id){
	if(parcelUseTSList == null){
		getParcelUseTSList(wdid);
	}
	List<ParcelUseTimeSeries> parcelUseTSList = new ArrayList<ParcelUseTimeSeries>();
	for(int i = 0; i < this.parcelUseTSList.size(); i++){
		ParcelUseTimeSeries parcelUseTS = this.parcelUseTSList.get(i);
		if(parcelUseTS.getParcelId() == parcel_id){
			parcelUseTSList.add(parcelUseTS);
		}
	}
	return parcelUseTSList;
}

public List<ReferenceTablesPermitActionName> getPermitActionName(){
	if(permitActionNameList == null){
		readPermitActionName();
	}
	return permitActionNameList;
}

/**
 * Helper method for methods that generate request strings from
 * input filter. This method takes the operator and the value and
 * returns the appropriately formatted string to append to the 
 * request URL.
 * @param operator
 * @param value
 * @return formatted String
 */
private String getRequestStringHelperMatches(String operator, String value){
	String ret = "";
	switch (operator.toUpperCase()){
		case "MA":  ret += value;
					break;
		case "SW":  ret += value + "*";
					break;
		case "EW":  ret += "*" + value;
					break;
		case "CN":  ret += "*" + value + "*";
					break;
	}
	return ret;
}

/**
Builds an array containing the SPFlex information for a query from an InputFilter.
@param filter the filter for which to build the SPFlex information.
@param op the operator selected for the InputFilter in the panel.
@return a three-element array containing:<p>
<b>0</b> - the field on which to constrain the query<br>
<b>1</b> - the SPFlex operator to apply between the field and the value<br>
<b>2</b> - the value against which to query<br>
<i>null</i> will be returned if no field was selected in the InputFilter.
@throws Exception if an error occurs.
*/
public static String[] getSPFlexParametersTriplet(InputFilter filter, String op) 
throws Exception {
	String[] triplet = new String[3];
	//System.out.println(filter.getWhereLabel());
	// Get the selected filter for the filter group...
	if (filter.getWhereLabel().trim().equals("")) {
		// Blank indicates that the filter should be ignored...
		return null;
	}

	// Get the input type...
	int inputType = filter.getInputType();
	if ( filter.getChoiceTokenType() > 0 ) {
		inputType = filter.getChoiceTokenType();
	}
	
	// Get the internal where.

	// Note:
	// getWhereInternal2() should always be used for stored procedure
	// SPFlex parameter building from InputFilters.  InputFilters can have
	// two where_internal values defined.  Typically, the first one is
	// used for non-stored procedure queries and the second one is used
	// for stored procedure queries.  However, some InputFilters are only
	// used with Stored Procedures, and so they have a where_internal 
	// set, but not a where_internal_2.  getWhereInternal2() handles this
	// by return where_internal_2, unless it is null.  In that case,
	// where_internal will be returned.
	triplet[0] = filter.getWhereInternal2();

	// Get the user input...
	triplet[2] = filter.getInputInternal().trim();

	if (op.equalsIgnoreCase(InputFilter.INPUT_BETWEEN)) {
		// TODO - need to enable in InputFilter_JPanel.
	}
	else if (op.equalsIgnoreCase( InputFilter.INPUT_CONTAINS)) {
		triplet[1] = "CN";
	}
	else if (op.equalsIgnoreCase(InputFilter.INPUT_ENDS_WITH)) {
		triplet[1] = "EW";
	}
	else if (op.equalsIgnoreCase(InputFilter.INPUT_EQUALS)){
		if (inputType == StringUtil.TYPE_STRING) {
			triplet[1] = "MA";
		}
		else {	
			triplet[1] = "EQ";
		}
	}
	else if (op.equalsIgnoreCase(InputFilter.INPUT_GREATER_THAN)) {
		triplet[1] = "GT";
	}
	else if (op.equalsIgnoreCase(InputFilter.INPUT_GREATER_THAN_OR_EQUAL_TO)) {
	    	triplet[1] = "GE";
	}
	else if (op.equalsIgnoreCase(InputFilter.INPUT_LESS_THAN)) {
		triplet[1] = "LT";
	}
	else if (op.equalsIgnoreCase(InputFilter.INPUT_LESS_THAN_OR_EQUAL_TO)) {
		triplet[1] = "LE";
	}
	else if (op.equalsIgnoreCase(InputFilter.INPUT_MATCHES)) {
		triplet[1] = "MA";
	}
	else if (op.equalsIgnoreCase(InputFilter.INPUT_ONE_OF)){
		// TODO - need to enable in InputFilter_JPanel
	}
	else if (op.equalsIgnoreCase(InputFilter.INPUT_STARTS_WITH)) {
		triplet[1] = "SW";
	}
	else {	
		throw new Exception("Unrecognized operator \"" + op + "\"...skipping..." );
	}

	return triplet;
}

//TODO smalers 2018-06-19 the following should return something like StationTimeSeriesCatalog
// but go with Station for now.
//TODO @jurentie 06/27/2018 - this method is not currently being used, but needs written if
// it plans to be.
/**
 * Return the list of station time series, suitable for display in TSTool browse area.
 * @param dataType
 * @param interval
 * @param filterPanel
 * @return
 */
public List<Station> getStationTimeSeriesCatalog ( String dataType, String interval, ColoradoHydroBaseRest_Station_InputFilter_JPanel filterPanel ) {
	List<Station> stationList = new ArrayList<Station>();
	return stationList;
}

//TODO smalers 2018-06-19 the following should return something like StructureTimeSeriesCatalog
//but go with Structure for now.
//TODO @jurentie 06/27/2018 - this method is not currently being used, but needs written if
//it plans to be.
/**
* Return the list of structure time series, suitable for display in TSTool browse area.
* @param dataType
* @param interval
* @param filterPanel
* @return
*/
public List<Structure> getStructureTimeSeriesCatalog ( String dataType, String interval, ColoradoHydroBaseRest_Structure_InputFilter_JPanel filterPanel ) {
	List<Structure> structureList = new ArrayList<Structure>();
	return structureList;
}

/**
 * Using the telemetry data types request string this method gets
 * a list of telemetryStationDataTypes from DWR web services.
 * @param dataType - any of the data types that can be returned from 
 * getTelemetryDataTypesFromWebServices()
 * @param listOfTriplets - input filter values such as 
 * ['County', 'MA', 'mesa'], [argument, operator, value].
 * @return List<TelemeteryStationDataTypes>
 */
public List<TelemetryStationDataTypes> getTelemetryDataTypes(String dataType, String interval, List<String[]> listOfTriplets) {
	String routine = "ColoradoHydroBaseRestDataStore.getTelemetryParams";
	List<TelemetryStationDataTypes> telemetryParams = new ArrayList<>();
	// Create request string
	String tdRequestString = getTelemetryDataTypesRequestString(dataType, listOfTriplets);
	
	JsonNode telemetryParamsNode = JacksonToolkit.getInstance().getJsonNodeFromWebServices(tdRequestString);
	
	//System.out.println(tdRequestString);
	Message.printStatus(1, routine, "Retrieve telemetry params from url request: " + tdRequestString);
	
	for(int i = 0; i < telemetryParamsNode.size(); i++){
		TelemetryStationDataTypes telemetryParam;
		telemetryParam = (TelemetryStationDataTypes) JacksonToolkit.getInstance().treeToValue(telemetryParamsNode.get(i), TelemetryStationDataTypes.class);
		telemetryParam.setTimeStep(interval);
		telemetryParams.add(telemetryParam);
	}
	return telemetryParams;
}

/**
 * Returns a list of parameters specified from
 * api/v2/referencetables/telemetryparams
 * @return a list of telemetry parameters
 */
public String[] getTelemetryDataTypeParametersFromWebServices(){	
	String routine = "ColoradoHydroBaseRestDataStore.getTelemetryDataTypesFromWebServices";
	String telParametersRequest = getServiceRootURI() + "/referencetables/telemetryparams/?apiKey=" + getApiKey();
	JsonNode telemetryDataTypes = JacksonToolkit.getInstance().getJsonNodeFromWebServices(telParametersRequest);

	String[] dataTypes = new String[telemetryDataTypes.size()];
	
	for(int i = 0; i < telemetryDataTypes.size(); i++){
		dataTypes[i] = ((ReferenceTablesTelemetryParams) JacksonToolkit.getInstance().treeToValue(telemetryDataTypes.get(i), ReferenceTablesTelemetryParams.class)).getParameter();
	}
	
	return dataTypes;
}

/**
 * Based on the given dataType, interval, and input filter values
 * will format the request string necessary for retrieving data from 
 * web services.
 * @param dataType - any of the data types that can be returned from 
 * getTelemetryDataTypesFromWebServices()
 * @param listOfTriplets - input filter values such as 
 * ['County', 'MA', 'mesa'], [argument, operator, value].
 * @return a formatted request string for retrieving telemetry data.
 */
public String getTelemetryDataTypesRequestString(String dataType, List<String []> listOfTriplets){
	// All telemetry data is assumed to be 15 minute, not searching by interval
	String tpRequestString = getServiceRootURI() + "/telemetrystations/telemetrystationdatatypes/?format=json&parameter=" + dataType;
	int newVal;
	// Step through all Triplets
	for(int i = 0; i < listOfTriplets.size(); i++){
		// Assign variables based off triplet
		String[] triplet = listOfTriplets.get(i);
		String argumentKey = triplet[0];
		String operator = triplet[1];
		String value = triplet[2];
		//System.out.println("argkey: " + argumentKey + ", op: " + operator + ", val: " + value);
		// Determine what to append to request string for specifiers
		try{
			switch (argumentKey.toUpperCase()){
				case "COUNTY":  
						tpRequestString += "&county=" + URLEncoder.encode(getRequestStringHelperMatches(operator, value), "UTF-8");
						break;
				case "LATITUDE":
						tpRequestString += "&latitude=" + URLEncoder.encode(value, "UTF-8");
						break;
				case "LONGITUDE":
						tpRequestString += "&longitude=" + URLEncoder.encode(value, "UTF-8");
						break;
				case "RADIUS":
						tpRequestString += "&radius=" + URLEncoder.encode(value, "UTF-8");
						break;
				case "UNITS":
						tpRequestString += "&units=" + URLEncoder.encode(value, "UTF-8");
						break;
				case "ABBREV":
						tpRequestString += "&abbrev=" + URLEncoder.encode(getRequestStringHelperMatches(operator, value), "UTF-8");
						break;
				case "STATIONTYPE":
						tpRequestString += "&stationType=" + URLEncoder.encode(getRequestStringHelperMatches(operator, value), "UTF-8");
						break;
				case "USGSSTATIONID":
						tpRequestString += "&usgsStationId=" + URLEncoder.encode(getRequestStringHelperMatches(operator, value), "UTF-8");
						break;
				case "WATERDISTRICT":
						switch (operator.toUpperCase()){
							case "EQ":
								tpRequestString += "&waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "LT":
								newVal = new Integer(value) - 1;
								value = Integer.toString(newVal);
								tpRequestString += "&max-waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "LE":
								tpRequestString += "&max-waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "GT":
								newVal = new Integer(value) + 1;
								value = Integer.toString(newVal);
								tpRequestString += "&min-waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "GE":
								tpRequestString += "&min-waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
						}
						break;
				case "WATERDIVISION":
						switch (operator.toUpperCase()){
							case "EQ":
								tpRequestString += "&division=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "LT":
								newVal = new Integer(value) - 1;
								value = Integer.toString(newVal);
								tpRequestString += "&max-division=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "LE": 
								tpRequestString += "&max-division" + URLEncoder.encode(value, "UTF-8");
								break;
							case "GT":
								newVal = new Integer(value) + 1;
								value = Integer.toString(newVal);
								tpRequestString += "&min-division=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "GE":
								tpRequestString += "&min-division" + URLEncoder.encode(value, "UTF-8");
								break;
						}
						break;
				case "STR_NAME":
						tpRequestString += "&wdid=" + URLEncoder.encode(value, "UTF-8");
						break;
			}
		}catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	tpRequestString += getApiKeyString();
	return tpRequestString;
	
}

public List<TelemetryDecodeSettings> getTelemetryDecodeSettings(String abbrev){
	List<TelemetryDecodeSettings> telDecSettings = new ArrayList<TelemetryDecodeSettings>();
	String request = getServiceRootURI() + "/telemetrystations/telemetrydecodesettings/?format=json" + "&abbrev=" + abbrev;
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request);
	for(int i = 0; i < results.size(); i++){
		telDecSettings.add((TelemetryDecodeSettings)JacksonToolkit.getInstance().treeToValue(results.get(i), TelemetryDecodeSettings.class));

	}
	return telDecSettings;
}

public List<TelemetryDischargeMeasurement> getTelemetryDischargeMeasurement(String abbrev, String county, int waterDivision, int waterDistrict){
	String request = getServiceRootURI() + "/telemetrystations/telemetrydischargemeasurement/" + "?format=json" + "&abbrev=" + abbrev;
	if(!(county == null || county == "")){
		request += "&county=" + county;
	}
	if(waterDistrict > -1){
		request += "&division=" + waterDivision;
	}
	if(waterDistrict > -1){
		request += "&waterDistrict=" + waterDistrict;
	}
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request);
	List<TelemetryDischargeMeasurement> telDischargeMeasurementsList = new ArrayList<TelemetryDischargeMeasurement>();
	for(int i = 0; i < results.size(); i++){
		TelemetryDischargeMeasurement tdm = (TelemetryDischargeMeasurement)JacksonToolkit.getInstance().treeToValue(results.get(i), TelemetryDischargeMeasurement.class);
		telDischargeMeasurementsList.add(tdm);
	}
	return telDischargeMeasurementsList;
}

public List<ReferenceTablesTelemetryParams> getTelemetryParams(){
	if(telemetryParamsList == null){
		readTelemetryParams();
	}
	return telemetryParamsList;
}

public List<TelemetryRatingTable> getTelemetryRatingTable(String ratingTableName){
	String request = getServiceRootURI() + "/telemetrystations/telemetryratingtable/" + "?format=json" + "&ratingTableName=" + ratingTableName;
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request).get(0);
	List<TelemetryRatingTable> telRatingTableList = new ArrayList<TelemetryRatingTable>();
	for(int i = 0; i < results.size(); i++){
		TelemetryRatingTable trt = (TelemetryRatingTable)JacksonToolkit.getInstance().treeToValue(results.get(i), TelemetryRatingTable.class);
		telRatingTableList.add(trt);
	}
	return telRatingTableList;
}

public List<TelemetryShift> getTelemetryShiftAdjustedRatingTable(String abbrev, String parameter){
	String request = getServiceRootURI() + "/telemetrystations/telemetryshiftadjustedratingtable/" + "?format=json" + "&abbrev=" + abbrev + "&parameter=" + parameter;
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request);
	List<TelemetryShift> telShiftList = new ArrayList<TelemetryShift>();
	for(int i = 0; i < results.size(); i++){
		TelemetryShift ts = (TelemetryShift)JacksonToolkit.getInstance().treeToValue(results.get(i), TelemetryShift.class);
		telShiftList.add(ts);
	}
	return telShiftList;
}

public List<TelemetryShift> getTelemetryShiftCurve(String shiftCurveName){
	String request = getServiceRootURI() + "/telemetrystations/telemetryshiftcurve/" + "?format=json" + "&shiftCurveName=" + shiftCurveName;
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request);
	List<TelemetryShift> telShiftList = new ArrayList<TelemetryShift>();
	for(int i = 0; i < results.size(); i++){
		TelemetryShift ts = (TelemetryShift)JacksonToolkit.getInstance().treeToValue(results.get(i), TelemetryShift.class);
		telShiftList.add(ts);
	}
	return telShiftList;
}


// TODO smalers 2018-06-19 the following should return something like TelemetryStationTimeSeriesCatalog
// but go with Station for now.
/**
 * Return the list of telemetry station time series, suitable for display in TSTool browse area.
 * @param dataType - any of the data types that can be returned from 
 * getTelemetryDataTypesFromWebServices()
 * @param interval - time interval 
 * (telemetry always comes back in 15min intervals regardless)
 * @param filterPanel - values for filtering requested data
 * @return List<TelemetryStationDataTypes>
 */
// TODO @jurentie fix throw catch
public List<TelemetryStationDataTypes> getTelemetryStationTimeSeriesCatalog ( String dataType, String interval, ColoradoHydroBaseRest_TelemetryStation_InputFilter_JPanel filterPanel ) {
	String routine = "ColoradoHydroBaseRestDataStore.getTelemeteryStationTimeSeriesCatalog";
	List<TelemetryStationDataTypes> telemetryList = new ArrayList<>();
	Message.printStatus(1, "", "Getting ColoradoHydroBaseRest telemetry station time series list");
	InputFilter filter = null;
	int nfg = filterPanel.getNumFilterGroups();
	List<String[]> listOfTriplets = new ArrayList<String[]>();
	for(int ifg = 0; ifg < nfg; ifg++){
		filter = filterPanel.getInputFilter(ifg);
		String op = filterPanel.getOperator(ifg);
		String[] triplet;
		try {
			triplet = getSPFlexParametersTriplet(filter, op);
			if(triplet != null){
				listOfTriplets.add(triplet);
			}
		} catch (Exception e) {
			Message.printWarning(1, routine, e);
			e.printStackTrace();
		}
	}
	telemetryList = getTelemetryDataTypes(dataType, interval, listOfTriplets);
	return telemetryList;
}

/**
 * Returns a list of data types that can be displayed in TSTool
 * @param group - if true return the group label in front of the 
 * data types, otherwise just return data types.
 */
public List<String> getTimeSeriesDataTypes(boolean group){
	List<String> dataTypes = new ArrayList<String>();
	if(group){
		dataTypes.add("Structure - DivTotal");
		dataTypes.add("Structure - ResMeasStage");
		dataTypes.add("Structure - ResMeasVolume");
		dataTypes.add("Structure - RelTotal");
		dataTypes.add("Structure - WaterClass");
		// Get list of telemetry data types
		String[] telDataTypes = getTelemetryDataTypeParametersFromWebServices();
		for(int i = 0; i < telDataTypes.length; i++){
			dataTypes.add("Telemetry Station - " + telDataTypes[i]);
		}
		dataTypes.add("Well - WaterLevelDepth");
		dataTypes.add("Well - WaterLevelElev");
	}else{
		dataTypes.add("DivTotal");
		dataTypes.add("RelTotal");
		dataTypes.add("WaterClass");
		// Get list of telemetry data types
		String[] telDataTypes = getTelemetryDataTypeParametersFromWebServices();
		for(int i = 0; i < telDataTypes.length; i++){
			dataTypes.add(telDataTypes[i]);
		}
		dataTypes.add("WaterLevelDepth");
		dataTypes.add("WaterLevelElev");
	}
	return dataTypes;
}

/**
 * Return a list of time steps associated with different
 * data types
 * @param selectedDataType
 * @return List<String> - list of time steps
 */
public List<String> getTimeSeriesTimeSteps(String selectedDataType){
	List<String> timeSteps = new ArrayList<String>();
	if(selectedDataType.equalsIgnoreCase("DivTotal") || 
			selectedDataType.equalsIgnoreCase("RelTotal") || 
			selectedDataType.equalsIgnoreCase("WaterClass")){
		timeSteps.add("Day");
		timeSteps.add("Month");
		timeSteps.add("Year");
	}
	else if(selectedDataType.equalsIgnoreCase("WaterLevelDepth") ||
			selectedDataType.equalsIgnoreCase("WaterLevelElev") ||
			selectedDataType.equalsIgnoreCase("ResMeasStage") ||
			selectedDataType.equalsIgnoreCase("ResMeasVolume")){
		timeSteps.add("Day");
	}
	// Will be Telemetry
	else{ // FIXME @jurentie 06/22/2018 might need a more clever solution for telemetry stations
		timeSteps.add("15Min");
		timeSteps.add("Hour");
		timeSteps.add("Day");
	}
	return timeSteps;
}

/**
 * Using the string request returned from 
 * getWaterClassesRequestString() retrieve a list
 * of DiversionWaterClasses from web services.
 * @param dataType - any of the data types that can be returned from 
 * getWaterClasses()
 * @param interval - day, month, or year
 * @param listOfTriplets - input filter values such as 
 * ['County', 'MA', 'mesa'], [argument, operator, value].
 * @return List<DiversionWaterClass> 
 */
public List<DiversionWaterClass> getWaterClasses(String dataType, String interval, List<String[]> listOfTriplets) {
	String routine = "ColoradoHydroBaseRestDataStore.getWaterClasses";
	List<DiversionWaterClass> waterclasses = new ArrayList<>();

	String request = getWaterClassesRequestString(dataType, interval, listOfTriplets);
	JsonNode waterclassesNode = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request);
	
	//System.out.println(request);
	Message.printStatus(1, routine, "Get water classes from URL request: " + request);
	
	for(int i = 0; i < waterclassesNode.size(); i++){
		DiversionWaterClass waterclass;
		waterclass = (DiversionWaterClass) JacksonToolkit.getInstance().treeToValue(waterclassesNode.get(i), DiversionWaterClass.class);
		waterclass.setTimeStep(interval);
		waterclasses.add(waterclass);
	}
	
	return waterclasses;
}

/**
 * Based on the given dataType, interval, and input filter values
 * will format the request string necessary for retrieving data from 
 * web services.
 * @param dataType - any of the data types that can be returned from 
 * getWaterClasses()
 * @param interval - day, month, or year
 * @param listOfTriplets - input filter values such as 
 * ['County', 'MA', 'mesa'], [argument, operator, value].
 * @return a formatted request string for retrieving water class data.
 */
public String getWaterClassesRequestString(String dataType, String interval, List<String []> listOfTriplets){
	String wcRequestString = getServiceRootURI() + "/structures/divrec/waterclasses/?format=json&divrectype=" + dataType + "&timestep=" + interval;
	int newVal;
	// Step through all Triplets
	for(int i = 0; i < listOfTriplets.size(); i++){
		// Assign variables based off triplet
		String[] triplet = listOfTriplets.get(i);
		String argumentKey = triplet[0];
		String operator = triplet[1];
		String value = triplet[2];
		//System.out.println("argkey: " + argumentKey + ", op: " + operator + ", val: " + value);
		// Determine what to append to request string for specifiers
		try{
			switch (argumentKey.toUpperCase()){
				case "COUNTY":  
						wcRequestString += "&county=" + URLEncoder.encode(getRequestStringHelperMatches(operator, value), "UTF-8");
						break;
				case "LATITUDE":
						wcRequestString += "&latitude=" + URLEncoder.encode(value, "UTF-8");
						break;
				case "LONGITUDE":
						wcRequestString += "&longitude=" + URLEncoder.encode(value, "UTF-8");
						break;
				case "RADIUS":
						wcRequestString += "&radius=" + URLEncoder.encode(value, "UTF-8");
						break;
				case "UNITS":
						wcRequestString += "&units=" + URLEncoder.encode(value, "UTF-8");
						break;
				case "WATERDISTRICT":
						switch (operator.toUpperCase()){
							case "EQ":
								wcRequestString += "&waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "LT":
								newVal = new Integer(value) - 1;
								value = Integer.toString(newVal);
								wcRequestString += "&max-waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "LE":
								wcRequestString += "&max-waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "GT":
								newVal = new Integer(value) + 1;
								value = Integer.toString(newVal);
								wcRequestString += "&min-waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "GE":
								wcRequestString += "&min-waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
						}
						break;
				case "WATERDIVISION":
						switch (operator.toUpperCase()){
							case "EQ":
								wcRequestString += "&division=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "LT":
								newVal = new Integer(value) - 1;
								value = Integer.toString(newVal);
								wcRequestString += "&max-division=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "LE": 
								wcRequestString += "&max-division=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "GT":
								newVal = new Integer(value) + 1;
								value = Integer.toString(newVal);
								wcRequestString += "&min-division=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "GE":
								wcRequestString += "&min-division=" + URLEncoder.encode(value, "UTF-8");
								break;
						}
						break;
				case "WDID":
						wcRequestString += "&wdid=" + URLEncoder.encode(value, "UTF-8");
						break;
			}
		}catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	wcRequestString += "&apiKey=" + getApiKeyString();
		
	return wcRequestString;
}

//TODO smalers 2018-06-19 the following should return something like StructureTimeSeriesCatalog
//but go with Structure for now.
/**
* Return the list of structure time series, suitable for display in TSTool browse area.
* @param dataType
* @param interval
* @param filterPanel
* @return
* @throws Exception // TODO @jurentie 06/21/20  work out throws exceptions
*/
public List<DiversionWaterClass> getWaterClassesTimeSeriesCatalog ( String dataType, String interval, ColoradoHydroBaseRest_Structure_InputFilter_JPanel filterPanel ) {
	String routine = "ColoradyHydroBaseRestDataStore.getWaterClassesTimeSeriesCatalog";
	// Create list for returned water classes
	List<DiversionWaterClass> waterclassList = new ArrayList<>();
	Message.printStatus(1, routine, "Getting ColoradoHydroBaseRest structure time series list");
	// Retrieve input filters
	InputFilter filter = null;
	int nfg = filterPanel.getNumFilterGroups();
	// Create a list to hold input filter data
	List<String[]> listOfTriplets = new ArrayList<String[]>();
	for(int ifg = 0; ifg < nfg; ifg++){
		filter = filterPanel.getInputFilter(ifg);
		String op = filterPanel.getOperator(ifg);
		String[] triplet;
		try {
			triplet = getSPFlexParametersTriplet(filter, op);
			if(triplet != null){
				listOfTriplets.add(triplet);
			}
		} catch (Exception e) {
			Message.printWarning(1, routine, e);
			e.printStackTrace();
		}
	}
	// Pass dataType, Interval, and listOfTriplets (input filters) to getWaterClasses
	waterclassList = getWaterClasses(dataType, interval, listOfTriplets);
	return waterclassList;
}

/**
 * Get list of districts from global variable
 * @return list of districts
 * @throws MalformedURLException
 */
public List<ReferenceTablesWaterDistrict> getWaterDistricts() throws MalformedURLException{
	if(waterDistrictList == null){
		readWaterDistricts();
	}
	return waterDistrictList;
}

public int getWaterDivisionFromWaterDistricts(String wdid){
	String wd = wdid.substring(0, 2);
	List<ReferenceTablesWaterDistrict> waterDistricts;
	int div = 0;
	try {
		waterDistricts = getWaterDistricts();
		for(int i = 0; i < waterDistricts.size(); i++){
			ReferenceTablesWaterDistrict waterDistrict = waterDistricts.get(i);
			int wdFromList = waterDistrict.getWaterDistrict();
			if(Integer.parseInt(wd) == wdFromList){
				div = waterDistrict.getDivision();
			}
		}
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return div;
}

/**
 * Get list of divisions from global variable
 * @return list of divisions
 * @throws MalformedURLException
 */
public List<ReferenceTablesWaterDivision> getWaterDivisions() throws MalformedURLException{
	if(waterDivisionList == null){
		readWaterDivisions();
	}
	return waterDivisionList;
}

//
public List<WaterRightsNetAmount> getWaterRightsNetAmount(String wdid)
throws Exception {
	List<WaterRightsNetAmount> waterRightsList = new ArrayList<WaterRightsNetAmount>();
	String netAmtsRequest = getServiceRootURI() + "/waterrights/netamount/?format=json&wdid=" + wdid + getApiKeyString();
	JsonNode structResult = JacksonToolkit.getInstance().getJsonNodeFromWebServices(netAmtsRequest);
	for(int i = 0; i < structResult.size(); i++){
		WaterRightsNetAmount waterRight = (WaterRightsNetAmount) JacksonToolkit.getInstance().treeToValue(structResult.get(i), WaterRightsNetAmount.class);
		waterRightsList.add(waterRight);
	}
	Collections.sort(waterRightsList, new ColoradoHydroBaseRest_WaterRightsNetAmount_Comparator_AdminNoOrderNo());
	return waterRightsList;
}

public List<WaterRightsTransaction> getWaterRightsTransaction(String wdid){
	String request = getServiceRootURI() + "/waterrights/transaction/" + "?format=json" + "&wdid=" + wdid;
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request);
	List<WaterRightsTransaction> waterRightsTransList = new ArrayList<WaterRightsTransaction>();
	for(int i = 0; i < results.size(); i++){
		WaterRightsTransaction wrt = (WaterRightsTransaction)JacksonToolkit.getInstance().treeToValue(results.get(i), WaterRightsTransaction.class);
		waterRightsTransList.add(wrt);
	}
	return waterRightsTransList;
}

//
private String getWCIdentStringFromDataType(String dataType){
	int indexOf = dataType.indexOf("-");
	return (dataType.charAt(dataType.length()  - 1) == ("'").charAt(0)) ? dataType.substring(indexOf + 1, dataType.length() - 1) : 
						dataType.substring(indexOf + 1, dataType.length());
}

public String getWellRequestString(List<String[]> listOfTriplets){
	String wellRequestString = getServiceRootURI() + "/groundwater/waterlevels/wells?format=json";
	int newVal;
	// Step through all Triplets
	for(int i = 0; i < listOfTriplets.size(); i++){
		// Assign variables based off triplet
		String[] triplet = listOfTriplets.get(i);
		String argumentKey = triplet[0];
		String operator = triplet[1];
		String value = triplet[2];
		//System.out.println("argkey: " + argumentKey.toUpperCase() + ", op: " + operator + ", val: " + value);
		// Determine what to append to request string for specifiers
		try{
		switch (argumentKey.toUpperCase()){
			case "COUNTY":  
						wellRequestString += "&county=" + URLEncoder.encode(getRequestStringHelperMatches(operator, value), "UTF-8");
						break;
			case "DESIGNATEDBASIN":
						wellRequestString += "&designatedBasin=" + URLEncoder.encode(getRequestStringHelperMatches(operator, value), "UTF-8");
						break;
			case "LATITUDE":
						wellRequestString += "&latitude=" + URLEncoder.encode(value, "UTF-8");
						break;
			case "LONGITUDE":
						wellRequestString += "&longitude=" + URLEncoder.encode(value, "UTF-8");
						break;
			case "RADIUS":
						wellRequestString += "&radius=" + URLEncoder.encode(value, "UTF-8");
						break;
			case "UNITS":
						wellRequestString += "&units=" + URLEncoder.encode(value, "UTF-8");
						break;
			case "MANAGEMENTDISTRICT":
						wellRequestString += "&managementDistrict=" + URLEncoder.encode(getRequestStringHelperMatches(operator, value), "UTF-8");
						break;
			case "PUBLICATIONNAME":
						wellRequestString += "&publicationName=" + URLEncoder.encode(getRequestStringHelperMatches(operator, value), "UTF-8");
						break;
			case "WATERDISTRICT":
						switch (operator.toUpperCase()){
							case "EQ":
								wellRequestString += "&waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "LT":
								newVal = new Integer(value) - 1;
								value = Integer.toString(newVal);
								wellRequestString += "&max-waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "LE":
								wellRequestString += "&max-waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "GT":
								newVal = new Integer(value) + 1;
								value = Integer.toString(newVal);
								wellRequestString += "&min-waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "GE":
								wellRequestString += "&min-waterDistrict=" + URLEncoder.encode(value, "UTF-8");
								break;
						}
						break;
			case "WATERDIVISION":
						switch (operator.toUpperCase()){
							case "EQ":
								wellRequestString += "&division=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "LT":
								newVal = new Integer(value) - 1;
								value = Integer.toString(newVal);
								wellRequestString += "&max-division=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "LE": 
								wellRequestString += "&max-division=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "GT":
								newVal = new Integer(value) + 1;
								value = Integer.toString(newVal);
								wellRequestString += "&min-division=" + URLEncoder.encode(value, "UTF-8");
								break;
							case "GE":
								wellRequestString += "&min-division=" + URLEncoder.encode(value, "UTF-8");
								break;
						}
						break;
			case "WELLID":
					switch (operator.toUpperCase()){
						case "EQ":
							wellRequestString += "&wellId=" + URLEncoder.encode(value, "UTF-8");
							break;
						case "LT":
							newVal = new Integer(value) - 1;
							value = Integer.toString(newVal);
							wellRequestString += "&max-wellId=" + URLEncoder.encode(value, "UTF-8");
							break;
						case "LE": 
							wellRequestString += "&max-wellId=" + URLEncoder.encode(value, "UTF-8");
							break;
						case "GT":
							newVal = new Integer(value) + 1;
							value = Integer.toString(newVal);
							wellRequestString += "&min-wellId=" + URLEncoder.encode(value, "UTF-8");
							break;
						case "GE":
							wellRequestString += "&min-wellId=" + URLEncoder.encode(value, "UTF-8");
							break;
					}
					break;
			}
		}catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	wellRequestString += "&apiKey=" + getApiKeyString();
	return wellRequestString;
}

//
public List<WaterLevelsWell> getWells(String dataType, String interval, List<String[]> listOfTriplets){
	String routine = "ColoradoHydroBaseRestDataStore.getWells";
	List<WaterLevelsWell> waterclasses = new ArrayList<>();
	// Create request string
	JsonNode wellsNode = JacksonToolkit.getInstance().getJsonNodeFromWebServices(getWellRequestString(listOfTriplets));
	Message.printStatus(1, routine, "Request Url: " + getWellRequestString(listOfTriplets));
	for(int i = 0; i < wellsNode.size(); i++){
		WaterLevelsWell well = (WaterLevelsWell) JacksonToolkit.getInstance().treeToValue(wellsNode.get(i), WaterLevelsWell.class);
		well.setDataType(dataType);
		well.setTimeStep(interval);
		waterclasses.add(well);
	}
	
	return waterclasses;
}

// TODO smalers 2018-06-19 the following should return something like WellTimeSeriesCatalog
// but go with Station for now.
/**
 * Return the list of well time series, suitable for display in TSTool browse area.
 * @param dataType
 * @param interval
 * @param filterPanel
 * @return
 */
public List<WaterLevelsWell> getWellTimeSeriesCatalog ( String dataType, String interval, ColoradoHydroBaseRest_Well_InputFilter_JPanel filterPanel ) {
	List<WaterLevelsWell> wellsList = new ArrayList<>();
	Message.printStatus(1, "", "Getting ColoradoHydroBaseRest structure time series list");
	InputFilter filter = null;
	int nfg = filterPanel.getNumFilterGroups();
	List<String[]> listOfTriplets = new ArrayList<String[]>();
	try{
		for(int ifg = 0; ifg < nfg; ifg++){
			filter = filterPanel.getInputFilter(ifg);
			String op = filterPanel.getOperator(ifg);
			String[] triplet = getSPFlexParametersTriplet(filter, op);
			if(triplet != null){
				listOfTriplets.add(triplet);
			}
		}
	}
	catch (Exception e) {
		// TODO @jurentie 06/26/2018 - Fix catch
		e.printStackTrace();
	}
	wellsList = getWells(dataType, interval, listOfTriplets);
	return wellsList;
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
 * Indicate whether a time series data type corresponds to a station.
 * @param dataType
 * @return true if data type is for a station, false otherwise
 */
public boolean isStationTimeSeriesDataType ( String dataType ) {
	// TODO smalers 2018-06-20 for now always return false since API is not implemented
	return false;
}

/**
 * Indicate whether a time series data type corresponds to a structure.
 * @param dataType
 * @return true if data type is for a structure, false otherwise
 */
public boolean isStructureTimeSeriesDataType ( String dataType ) {
	String [] dataTypes = { "DIVTOTAL", "RELTOTAL", "WATERCLASS"};
	// Compare the first part of the data type, because water classes data type will be followed by the class string
	for ( int i = 0; i < dataTypes.length; i++ ) {
		if ( dataType.toUpperCase().startsWith(dataTypes[i]) ) {
			return true;
		}
	}
	return false;
}

/**
 * Indicate whether a time series data type corresponds to a telemetry station.
 * @param dataType
 * @return true if data type is for a telemetry station, false otherwise
 */
public boolean isTelemetryStationTimeSeriesDataType ( String dataType ) {
	String[] dataTypes = getTelemetryDataTypeParametersFromWebServices();
	for ( int i = 0; i < dataTypes.length; i++ ) {
		if ( dataType.equalsIgnoreCase(dataTypes[i]) ) {
			return true;
		}
	}
	return false;
}

/**
 * Indicate whether a time series data type corresponds to a well.
 * @param dataType
 * @return true if data type is for a well, false otherwise
 */
public boolean isWellTimeSeriesDataType ( String dataType ) {
	String [] dataTypes = { "WaterLevelDepth", "WaterLevelElev" };
	// TODO smalers 2018-06-20 will need to compare only the first part of the data type for classes
	for ( int i = 0; i < dataTypes.length; i++ ) {
		if ( dataType.equalsIgnoreCase(dataTypes[i]) ) {
			return true;
		}
	}
	return false;
}

/**
 * Read counties from web services
 */
private void readCounties(){
	String countyRequest = getServiceRootURI() + "/referencetables/county/?format=json" + getApiKeyString();
	countyList = new ArrayList<ReferenceTablesCounty>();
	JsonNode resultList = JacksonToolkit.getInstance().getJsonNodeFromWebServices(countyRequest);
	for(int i = 0; i < resultList.size(); i++){
		countyList.add((ReferenceTablesCounty)JacksonToolkit.getInstance().treeToValue(resultList.get(i), ReferenceTablesCounty.class));
	}
} 

/**
 * Read current in use codes from web services
 */
private void readCurrentInUseCodes(){
	String currentInUseCodesRequest = getServiceRootURI() + "/referencetables/currentinusecodes/?format=json" + getApiKeyString();
	currentInUseCodeList = new ArrayList<ReferenceTablesCurrentInUseCodes>();
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(currentInUseCodesRequest);
	for(int i = 0; i < results.size(); i++){
		currentInUseCodeList.add((ReferenceTablesCurrentInUseCodes)JacksonToolkit.getInstance().treeToValue(results.get(i), ReferenceTablesCurrentInUseCodes.class));
	}
}

/**
 * Read Designated Basins from web services
 */
private void readDesignatedBasins(){
	String designatedBasinRequest = getServiceRootURI() + "/referencetables/designatedbasin/?format=json" + getApiKeyString();
	designatedBasinList = new ArrayList<ReferenceTablesDesignatedBasin>();
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(designatedBasinRequest);
	for(int i = 0; i < results.size(); i++){
		designatedBasinList.add((ReferenceTablesDesignatedBasin)JacksonToolkit.getInstance().treeToValue(results.get(i), ReferenceTablesDesignatedBasin.class));
	}
}

/**
 * Read diversion not used codes from web services
 */
private void readDiversionNotUsedCodes(){
	String diversionNotUsedCodesRequest = getServiceRootURI() + "/referencetables/diversionnotusedcodes/?format=json" + getApiKeyString();
	diversionNotUsedCodeList = new ArrayList<ReferenceTablesDiversionNotUsedCodes>();
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(diversionNotUsedCodesRequest);
	for(int i = 0; i < results.size(); i++){
		diversionNotUsedCodeList.add((ReferenceTablesDiversionNotUsedCodes)JacksonToolkit.getInstance().treeToValue(results.get(i), ReferenceTablesDiversionNotUsedCodes.class));
	}
}

/**
 * Read div rec observation codes from web services
 */
private void readDivRecObservationCodes(){
	String divRecObservationCodesRequest = getServiceRootURI() + "/referencetables/divrecobservationcodes/?format=json" + getApiKeyString();
	divRecObservationCodeList = new ArrayList<ReferenceTablesDivRecObservationCodes>();
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(divRecObservationCodesRequest);
	for(int i = 0; i < results.size(); i++){
		divRecObservationCodeList.add((ReferenceTablesDivRecObservationCodes)JacksonToolkit.getInstance().treeToValue(results.get(i), ReferenceTablesDivRecObservationCodes.class));
	}
}

/**
 * Read div rec types from web services
 */
private void readDivRecTypes(){
	String divRecTypeRequest = getServiceRootURI() + "/referencetables/divrectypes/?format=json" + getApiKeyString();
	divRecTypeList = new ArrayList<ReferenceTablesDivRecTypes>();
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(divRecTypeRequest);
	for(int i = 0; i < results.size(); i++){
		divRecTypeList.add((ReferenceTablesDivRecTypes)JacksonToolkit.getInstance().treeToValue(results.get(i), ReferenceTablesDivRecTypes.class));
	}
}

/**
 * Read in data and store in global variables for caching purposes
 * @throws MalformedURLException 
 */
private void readGlobalData() throws MalformedURLException{
	readCounties();
	readCurrentInUseCodes();
	readDiversionNotUsedCodes();
	readDivRecObservationCodes();
	readDivRecTypes();
	readGroundwaterPublication();
	readDesignatedBasins();
	readManagementDistrict();
	readPermitActionName();
	readTelemetryParams();
	readWaterDistricts();
	readWaterDivisions();
}

/**
 * Read groundwater publications from web services
 */
private void readGroundwaterPublication(){
	String groundwaterPublicationRequest = getServiceRootURI() + "/referencetables/groundwaterpublication?format=json" + getApiKeyString();
	groundwaterPublicationList = new ArrayList<ReferenceTablesGroundwaterPublication>();
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(groundwaterPublicationRequest);
	for(int i = 0; i < results.size(); i++){
		groundwaterPublicationList.add((ReferenceTablesGroundwaterPublication)JacksonToolkit.getInstance().treeToValue(results.get(i), ReferenceTablesGroundwaterPublication.class));
	}
}

//TODO @jurentie NOT SURE HOW TO DEAL WITH ANALYSIS SERVICES

/**
 * Read management districts from web services
 */
private void readManagementDistrict(){
	String managementDistrictRequest = getServiceRootURI() + "/referencetables/managementdistrict/?format=json" + getApiKeyString();
	managementDistrictList = new ArrayList<ReferenceTablesManagementDistrict>();
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(managementDistrictRequest);
	for(int i = 0; i < results.size(); i++){
		managementDistrictList.add((ReferenceTablesManagementDistrict)JacksonToolkit.getInstance().treeToValue(results.get(i), ReferenceTablesManagementDistrict.class));
	}
}

/**
 * Read permit action names from web services
 * @throws MalformedURLException 
 */
private void readPermitActionName(){
	String permitActionNameRequest = getServiceRootURI() + "/referencetables/permitactionname/?format=json" + getApiKeyString();
	permitActionNameList = new ArrayList<ReferenceTablesPermitActionName>();
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(permitActionNameRequest);
	for(int i = 0; i < results.size(); i++){
		permitActionNameList.add((ReferenceTablesPermitActionName)JacksonToolkit.getInstance().treeToValue(results.get(i), ReferenceTablesPermitActionName.class));
	}
}

/**
 * Read telemetry params from web services
 */
private void readTelemetryParams(){
	String telemetryParamsRequest = getServiceRootURI() + "/referencetables/telemetryparams/?format=json" + getApiKeyString();
	telemetryParamsList = new ArrayList<ReferenceTablesTelemetryParams>();
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(telemetryParamsRequest);
	for(int i = 0; i < results.size(); i++){
		telemetryParamsList.add((ReferenceTablesTelemetryParams)JacksonToolkit.getInstance().treeToValue(results.get(i), ReferenceTablesTelemetryParams.class));
	}
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
	String routine = "ColoradoHydroBaseRestDataStore.readTimeSeries";
	
	// Make sure data store is initialized
    initialize();
    determineAPIVersion();
    TS ts = null;
    
    // 1. Parse the time series identifier (TSID) that was passed in
    TSIdent tsident = TSIdent.parseIdentifier(tsidentString);
	String locid = tsident.getLocation();
	String data_type = tsident.getType(); // TSID data type
	String data_source = tsident.getSource();
	
	String tsUnits = null;

	// 2. Create time series to receive the data.
	ts = TSUtil.newTimeSeries(tsidentString, true);
	int interval_base = ts.getDataIntervalBase();
	
	// 3. TS Configuration:
	ts.setIdentifier(tsidentString);
	ts.setMissing(Double.NaN); // don't need setMissingRange() for now
	
	//System.out.println(data_type);

	if(data_type.equalsIgnoreCase("DivTotal") || data_type.equalsIgnoreCase("RelTotal") ||
			data_type.startsWith("WaterClass") || data_type.startsWith("'WaterClass")){
		
		String wdid = locid;
		
		// Get Structure
		String structRequest = getServiceRootURI() + "/structures/?format=json&wdid=" + wdid + getApiKeyString();
		JsonNode structResult = JacksonToolkit.getInstance().getJsonNodeFromWebServices(structRequest).get(0);
		// Log structure request for debugging properties
		//System.out.println(structRequest);
		Message.printStatus(2, routine, "Retrieve structure data from DWR REST API request url: " + structRequest);
		// Use jackson to convert structResult into a Structure POJO for easy retrieval of data
		Structure struct = (Structure)JacksonToolkit.getInstance().treeToValue(structResult, Structure.class);
		
		// Set structure name as TS Description
		ts.setDescription(struct.getStructureName());
		
		int waterClassNumForWdid = 0;
		
		if(data_type.equalsIgnoreCase("DivTotal")){
			// Diversion records - total through diversion
			// locid is the WDID in this case
			boolean divTotalReq = true;
			boolean relTotalReq = false;
			String waterClassReqString = "";
			
			// Retrieve water class num for given wdid
			DiversionWaterClass waterClassForWdid = readWaterClassNumForWdid(wdid,waterClassReqString,divTotalReq,relTotalReq);
			waterClassNumForWdid = waterClassForWdid.getWaterclassNum();
		}
		if(data_type.equalsIgnoreCase("RelTotal")){
			// Release records - total through release
			// locid is the WDID in this case
			boolean divTotalReq = false;
			boolean relTotalReq = true;
			String waterClassReqString = "";
					
			// Retrieve water class num for given wdid
			DiversionWaterClass waterClassForWdid = readWaterClassNumForWdid(wdid,waterClassReqString,divTotalReq,relTotalReq);
			waterClassNumForWdid = waterClassForWdid.getWaterclassNum();
		}
		if(data_type.startsWith("WaterClass") || data_type.startsWith("'WaterClass")){
			// Release records - total through release
			// locid is the WDID in this case
			boolean divTotalReq = false;
			boolean relTotalReq = false;
			String waterClassReqString = getWCIdentStringFromDataType(data_type);
			
			//System.out.println("water class: " + waterClassReqString);
								
			// Retrieve water class num for given wdid
			DiversionWaterClass waterClassForWdid = readWaterClassNumForWdid(wdid,waterClassReqString,divTotalReq,relTotalReq);
			waterClassNumForWdid = waterClassForWdid.getWaterclassNum();
		}
		
		/* Get first and last date */
		// First Date / Also set ts.setDataUnits() and ts.setDataUnitsOriginal() //
		DateTime firstDate = null;
		if(interval_base == TimeInterval.DAY){ 
			firstDate = new DateTime(DateTime.PRECISION_DAY); 
			firstDate.setYear(struct.getPorStart().getYear());
			firstDate.setMonth(struct.getPorStart().getMonth());
			firstDate.setDay(struct.getPorStart().getDay());
			ts.setDate1Original(firstDate);
			/*ts.setDataUnits(struct.getU); // TODO @jurentie 06/26/2018: setDataUnits
			ts.setDataUnitsOriginal(divRecFirst.getMeasUnits());*/
		}
		if(interval_base == TimeInterval.MONTH){ 
			firstDate = new DateTime(DateTime.PRECISION_MONTH); 
			firstDate.setYear(struct.getPorStart().getYear());
			firstDate.setMonth(struct.getPorStart().getMonth());
			ts.setDate1Original(firstDate);
		}
		if(interval_base == TimeInterval.YEAR){ 
			firstDate = new DateTime(DateTime.PRECISION_YEAR); 
			firstDate.setYear(struct.getPorStart().getYear());
			ts.setDate1Original(firstDate);
		}
		
		// Last Date
		DateTime lastDate = null;
		if(interval_base == TimeInterval.DAY){ 
			lastDate = new DateTime(DateTime.PRECISION_DAY); 
			lastDate.setYear(struct.getPorEnd().getYear());
			lastDate.setMonth(struct.getPorEnd().getMonth());
			lastDate.setDay(struct.getPorEnd().getDay());
			ts.setDate2Original(lastDate);
			/*ts.setDataUnits(struct.getU); // TODO @jurentie 06/26/2018: setDataUnits
			ts.setDataUnitsOriginal(divRecFirst.getMeasUnits());*/
		}
		if(interval_base == TimeInterval.MONTH){ 
			lastDate = new DateTime(DateTime.PRECISION_MONTH); 
			lastDate.setYear(struct.getPorEnd().getYear());
			lastDate.setMonth(struct.getPorEnd().getMonth());
			ts.setDate2Original(lastDate);
		}
		if(interval_base == TimeInterval.YEAR){ 
			lastDate = new DateTime(DateTime.PRECISION_YEAR); 
			lastDate.setYear(struct.getPorEnd().getYear());
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
		
		TSIterator iterator = ts.iterator();
		
		// 4. Set Properties:
		//FIXME @jurentie 06/26/2018 - move add to genesis elsewhere
		//ts.addToGenesis("read data from web services " + structRequest + " and " + divRecRequest + "."); // might need to add waterclasses URL string
		setTimeSeriesPropertiesStructure(ts, struct);
		
		setCommentsStructure(ts, struct);

		// FIXME @jurentie 06/26/2018 Do not read all data if not within the bounds of the specified dates
		// 5. Read Data: 
		if(readData){
			// Get the data from web services
			String divRecRequest = null;
			if(interval_base == TimeInterval.DAY){
				// Create request URL for web services API
				divRecRequest = getServiceRootURI() + "/structures/divrec/divrecday/?format=json&wdid=" + wdid + "&waterClassNum=" + waterClassNumForWdid + getApiKeyString();
				//System.out.println(divRecRequest);
				Message.printStatus(2, routine, "Retrieve diversion by day data from DWR REST API request url: " + divRecRequest);
			}
			if(interval_base == TimeInterval.MONTH){
				// Create request URL for web services API
				divRecRequest = getServiceRootURI() + "/structures/divrec/divrecmonth/?format=json&wdid=" + wdid + "&waterClassNum=" + waterClassNumForWdid + getApiKeyString();
				//System.out.println(divRecRequest);
				Message.printStatus(2, routine, "Retrieve diversion by month data from DWR REST API request url: " + divRecRequest);
			}
			if(interval_base == TimeInterval.YEAR){
				// Create request URL for web services API
				divRecRequest = getServiceRootURI() + "/structures/divrec/divrecyear/?format=json&wdid=" + wdid + "&waterClassNum=" + waterClassNumForWdid + getApiKeyString();
				//System.out.println(divRecRequest);
				Message.printStatus(2, routine, "Retrieve diversion by day year from DWR REST API request url: " + divRecRequest);
			}
			// Get JsonNode results give the request URL
			JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(divRecRequest);
			
			// Pass Data into TS Object
			if(interval_base == TimeInterval.DAY){
				for(int i = 0; i < results.size(); i++){
					
					DiversionByDay divRecCurrDay = (DiversionByDay)JacksonToolkit.getInstance().treeToValue(results.get(i), DiversionByDay.class);
					
					// 1. Check to see if units have been set
					// if not, set them.
					String units = divRecCurrDay.getMeasUnits();
					if(tsUnits == null){
						tsUnits = units;
						ts.setDataUnits(tsUnits);
						ts.setDataUnitsOriginal(tsUnits);
					}
					
					// 2. Make sure units are the same
					if(!units.equalsIgnoreCase(tsUnits)){
						// TODO ... automatically convert units
						continue;
						// TODO ... decide whether and exception should be thrown?
					}
					
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
					DiversionByMonth divRecCurrMonth = (DiversionByMonth)JacksonToolkit.getInstance().treeToValue(results.get(i), DiversionByMonth.class);
					
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
					DiversionByYear divRecCurrYear = (DiversionByYear)JacksonToolkit.getInstance().treeToValue(results.get(i), DiversionByYear.class);
					
					// Set Date
					DateTime date = new DateTime(DateTime.PRECISION_YEAR);
					date.setYear(divRecCurrYear.getYear());
					
					// Get Data
					double value = divRecCurrYear.getDataValue();
					
					ts.setDataValue(date, value);
				}
			}

			// Diversion Comments
			boolean hasComments = waterclassHasComments(wdid);
			if(hasComments){
				List<DiversionComments> divComments = getDivComments(wdid, null, -1);
				if(divComments != null){
					TSData it;
					for(int i = 0; i < divComments.size(); i++){
						DiversionComments divComment = divComments.get(i);
						int irrYear = divComment.getIrrYear();
						if(irrYear >= ts.getDate1().getYear() &&
								irrYear <= ts.getDate2().getYear()){
							DateTime start;
							DateTime end;
							if(interval_base == TimeInterval.DAY){
								start = new DateTime(DateTime.PRECISION_DAY);
								start.setYear(irrYear);
								start.setMonth(11);
								start.setDay(01);
								end = new DateTime(DateTime.PRECISION_DAY);
								end.setYear(irrYear + 1);
								end.setMonth(10);
								end.setDay(30);
								iterator.setBeginTime(start);
								iterator.setEndTime(end);
								while(iterator.hasNext()){
									it = iterator.next();
									if(ts.isDataMissing(it.getDataValue())){
										ts.setDataValue(it.getDate(), 0, it.getDataFlag(), -1);
									}
								}
							}
							if(interval_base == TimeInterval.MONTH){
								start = new DateTime(DateTime.PRECISION_MONTH);
								start.setYear(irrYear);
								start.setMonth(11);
								end = new DateTime(DateTime.PRECISION_MONTH);
								end.setYear(irrYear);
								end.setMonth(10);
								while(iterator.hasNext()){
									it = iterator.next();
									if(ts.isDataMissing(it.getDataValue())){
										ts.setDataValue(it.getDate(), 0, it.getDataFlag(), -1);
									}
								}
							}
							if(interval_base == TimeInterval.YEAR){
								start = new DateTime(DateTime.PRECISION_YEAR);
								start.setYear(irrYear);
								end = new DateTime(DateTime.PRECISION_YEAR);
								end.setYear(irrYear);
								while(iterator.hasNext()){
									it = iterator.next();
									if(ts.isDataMissing(it.getDataValue())){
										ts.setDataValue(it.getDate(), 0, it.getDataFlag(), -1);
									}
								}
							}
						}
					}
				}
			}
		}
	}
	else if(data_type.equalsIgnoreCase("ResMeasStage") || data_type.equalsIgnoreCase("ResMeasVolume")){
		String wdid = locid;
		
		// Get Structure
		String structRequest = getServiceRootURI() + "/structures/?format=json&wdid=" + wdid + getApiKeyString();
		JsonNode structResult = JacksonToolkit.getInstance().getJsonNodeFromWebServices(structRequest).get(0);
		// Log structure request for debugging properties
		//System.out.println(structRequest);
		Message.printStatus(2, routine, "Retrieve structure data from DWR REST API request url: " + structRequest);
		// Use jackson to convert structResult into a Structure POJO for easy retrieval of data
		Structure struct = (Structure)JacksonToolkit.getInstance().treeToValue(structResult, Structure.class);
		
		// Set structure name as TS Description
		ts.setDescription(struct.getStructureName());
		
		int waterClassNumForWdid = 0;
		
		/* Get first and last date */
		// First Date / Also set ts.setDataUnits() and ts.setDataUnitsOriginal() //
		DateTime firstDate = null;
		firstDate = new DateTime(DateTime.PRECISION_DAY); 
		firstDate.setYear(struct.getPorStart().getYear());
		firstDate.setMonth(struct.getPorStart().getMonth());
		firstDate.setDay(struct.getPorStart().getDay());
		ts.setDate1Original(firstDate);
		/*ts.setDataUnits(struct.getU); // TODO @jurentie 06/26/2018: setDataUnits
		ts.setDataUnitsOriginal(divRecFirst.getMeasUnits());*/
		
		// Last Date
		DateTime lastDate = null;
		lastDate = new DateTime(DateTime.PRECISION_DAY); 
		lastDate.setYear(struct.getPorEnd().getYear());
		lastDate.setMonth(struct.getPorEnd().getMonth());
		lastDate.setDay(struct.getPorEnd().getDay());
		ts.setDate2Original(lastDate);
		/*ts.setDataUnits(struct.getU); // TODO @jurentie 06/26/2018: setDataUnits
		ts.setDataUnitsOriginal(divRecFirst.getMeasUnits());*/
			
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
		
		TSIterator iterator = ts.iterator();
		
		// 4. Set Properties:
		//FIXME @jurentie 06/26/2018 - move add to genesis elsewhere
		//ts.addToGenesis("read data from web services " + structRequest + " and " + divRecRequest + "."); // might need to add waterclasses URL string
		setTimeSeriesPropertiesStructure(ts, struct);
		
		setCommentsStructure(ts, struct);
		
		if(readData){
			// Get the data from web services
			String divRecRequest = null;
			// Create request URL for web services API
			divRecRequest = getServiceRootURI() + "/structures/divrec/stagevolume/" + wdid + "?format=json" + getApiKeyString();
			//System.out.println(divRecRequest);
			// Get JsonNode results give the request URL
			JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(divRecRequest);
				
			for(int i = 0; i < results.size(); i++){
				DiversionStageVolume divStageVol = (DiversionStageVolume)JacksonToolkit.getInstance().treeToValue(results.get(i), DiversionStageVolume.class);
					
				//Set Date
				DateTime date = new DateTime(DateTime.PRECISION_DAY);
				date.setYear(divStageVol.getYear());
				date.setMonth(divStageVol.getMonth());
				date.setDay(divStageVol.getDay());
					
				//Get Data
				double value = 0.0;
				if(data_type.equalsIgnoreCase("ResMeasStage")){
					value = divStageVol.getStage();
				}
				else{
					value = divStageVol.getVolume();
				}
				
				ts.setDataValue(date, value);
			}
			// Diversion Comments
			boolean hasComments = waterclassHasComments(wdid);
			if(hasComments){
				List<DiversionComments> divComments = getDivComments(wdid, null, -1);
				if(divComments != null){
					TSData it;
					for(int i = 0; i < divComments.size(); i++){
						DiversionComments divComment = divComments.get(i);
						int irrYear = divComment.getIrrYear();
						if(irrYear >= ts.getDate1().getYear() &&
								irrYear <= ts.getDate2().getYear()){
							DateTime start;
							DateTime end;
							if(interval_base == TimeInterval.DAY){
								start = new DateTime(DateTime.PRECISION_DAY);
								start.setYear(irrYear);
								start.setMonth(11);
								start.setDay(01);
								end = new DateTime(DateTime.PRECISION_DAY);
								end.setYear(irrYear + 1);
								end.setMonth(10);
								end.setDay(30);
								iterator.setBeginTime(start);
								iterator.setEndTime(end);
								while(iterator.hasNext()){
									it = iterator.next();
									if(ts.isDataMissing(it.getDataValue())){
										ts.setDataValue(it.getDate(), 0, it.getDataFlag(), -1);
									}
								}
							}
							if(interval_base == TimeInterval.MONTH){
								start = new DateTime(DateTime.PRECISION_MONTH);
								start.setYear(irrYear);
								start.setMonth(11);
								end = new DateTime(DateTime.PRECISION_MONTH);
								end.setYear(irrYear);
								end.setMonth(10);
								while(iterator.hasNext()){
									it = iterator.next();
									if(ts.isDataMissing(it.getDataValue())){
										ts.setDataValue(it.getDate(), 0, it.getDataFlag(), -1);
									}
								}
							}
						if(interval_base == TimeInterval.YEAR){
								start = new DateTime(DateTime.PRECISION_YEAR);
								start.setYear(irrYear);
								end = new DateTime(DateTime.PRECISION_YEAR);
								end.setYear(irrYear);
								while(iterator.hasNext()){
									it = iterator.next();
									if(ts.isDataMissing(it.getDataValue())){
										ts.setDataValue(it.getDate(), 0, it.getDataFlag(), -1);
									}
								}
							}
						}
					}
				}
			}			
		}
	}
	else if(isTelemetryStationTimeSeriesDataType(data_type)){
		String abbrev = locid;
		
		// Get Telemetry
		String telemetryRequest = getServiceRootURI() + "/telemetrystations/telemetrystation/?format=json&abbrev=" + abbrev + getApiKeyString();
		JsonNode telemetryResult = JacksonToolkit.getInstance().getJsonNodeFromWebServices(telemetryRequest).get(0);
		
		TelemetryStation telStation = (TelemetryStation)JacksonToolkit.getInstance().treeToValue(telemetryResult, TelemetryStation.class);
		Message.printStatus(2, routine, "Retrieve telemetry stations from DWR REST API request url: " + telemetryRequest);
		
		// Set Description
		ts.setDescription(telStation.getStationName());
		
		// FIXME @jurentie 06/26/2018 - Try to more efficiently get the first and last dates so I can move the following code inside readData() 
		
		String telRequest = null;

		// Retrieve Telemetry based on date interval
		if(interval_base == DateTime.PRECISION_MINUTE){
			telRequest = getServiceRootURI() + "/telemetrystations/telemetrytimeseriesraw/?abbrev=" + abbrev + getApiKeyString();
			//System.out.println(telRequest);
			Message.printStatus(2, routine, "Retrieve telemetry time series 15 min intervals from DWR REST API request url: " + telRequest);
		}
		if(interval_base == DateTime.PRECISION_HOUR){
			telRequest = getServiceRootURI() + "/telemetrystations/telemetrytimeserieshour/?abbrev=" + abbrev + getApiKeyString();
			//System.out.println(telRequest);
			Message.printStatus(2, routine, "Retrieve telemetry time series hourly intervals from DWR REST API request url: " + telRequest);
		}
		if(interval_base == DateTime.PRECISION_DAY){
			telRequest = getServiceRootURI() + "/telemetrystations/telemetrytimeseriesday/?abbrev=" + abbrev + getApiKeyString();
			//System.out.println(telRequest);
			Message.printStatus(2, routine, "Retrieve telemetry time series daily intervals from DWR REST API request url: " + telRequest);
		}
		
		JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(telRequest);
		
		//System.out.println(results);
		
		/* Get first and last date */
		// First Date / Also set ts.setDataUnits() and ts.setDataUnitsOriginal() //
		DateTime firstDate = null;
		if(interval_base == TimeInterval.MINUTE){
			TelemetryTimeSeries telTSMinute = (TelemetryTimeSeries)JacksonToolkit.getInstance().treeToValue(results.get(0), TelemetryTimeSeries.class);
			firstDate = new DateTime(DateTime.PRECISION_MINUTE);
			firstDate.setYear(telTSMinute.getYear());
			firstDate.setMonth(telTSMinute.getMonth());
			firstDate.setDay(telTSMinute.getDay());
			firstDate.setHour(telTSMinute.getHour());
			firstDate.setMinute(telTSMinute.getMinute());
			ts.setDate1Original(firstDate);
			ts.setDataUnits(telStation.getUnits());
			ts.setDataUnitsOriginal(telStation.getUnits());
		}
		if(interval_base == TimeInterval.HOUR){
			TelemetryTimeSeries telTSHour = (TelemetryTimeSeries)JacksonToolkit.getInstance().treeToValue(results.get(0), TelemetryTimeSeries.class);
			firstDate = new DateTime(DateTime.PRECISION_HOUR);
			firstDate.setYear(telTSHour.getYear());
			firstDate.setMonth(telTSHour.getMonth());
			firstDate.setDay(telTSHour.getDay());
			firstDate.setHour(telTSHour.getHour());
			ts.setDate1Original(firstDate);
			ts.setDataUnits(telStation.getUnits());
			ts.setDataUnitsOriginal(telStation.getUnits());
		}
		if(interval_base == TimeInterval.DAY){ 
			TelemetryTimeSeries telTSDay = (TelemetryTimeSeries)JacksonToolkit.getInstance().treeToValue(results.get(0), TelemetryTimeSeries.class);
			firstDate = new DateTime(DateTime.PRECISION_DAY);
			//System.out.println(telTSDay);
			firstDate.setYear(telTSDay.getYear());
			firstDate.setMonth(telTSDay.getMonth());
			firstDate.setDay(telTSDay.getDay());
			ts.setDate1Original(firstDate);
			ts.setDataUnits(telStation.getUnits());
			ts.setDataUnitsOriginal(telStation.getUnits());
		}
		
		// Last Date
		DateTime lastDate = null;
		if(interval_base == TimeInterval.MINUTE){
			TelemetryTimeSeries telTSMinute = (TelemetryTimeSeries)JacksonToolkit.getInstance().treeToValue(results.get(results.size() - 1), TelemetryTimeSeries.class);
			lastDate = new DateTime(DateTime.PRECISION_MINUTE);
			lastDate.setYear(telTSMinute.getYear());
			lastDate.setMonth(telTSMinute.getMonth());
			lastDate.setDay(telTSMinute.getDay());
			lastDate.setHour(telTSMinute.getHour());
			lastDate.setMinute(telTSMinute.getMinute());
			ts.setDate2Original(lastDate);
		}
		if(interval_base == TimeInterval.HOUR){
			TelemetryTimeSeries telTSHour = (TelemetryTimeSeries)JacksonToolkit.getInstance().treeToValue(results.get(results.size() - 1), TelemetryTimeSeries.class);
			lastDate = new DateTime(DateTime.PRECISION_HOUR);
			lastDate.setYear(telTSHour.getYear());
			lastDate.setMonth(telTSHour.getMonth());
			lastDate.setDay(telTSHour.getDay());
			lastDate.setHour(telTSHour.getHour());
			ts.setDate2Original(lastDate);
		}
		if(interval_base == TimeInterval.DAY){ 
			TelemetryTimeSeries telTSDay = (TelemetryTimeSeries)JacksonToolkit.getInstance().treeToValue(results.get(results.size() - 1), TelemetryTimeSeries.class);
			lastDate = new DateTime(DateTime.PRECISION_DAY);
			lastDate.setYear(telTSDay.getYear());
			lastDate.setMonth(telTSDay.getMonth());
			lastDate.setDay(telTSDay.getDay());
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
			
		// Allocate data space
		ts.allocateDataSpace();
		
		// FIXME @jurentie 06/20/2018 change name of telemetryRequest/telRequest
		// Set Properties
		ts.addToGenesis("read data from web services " + telemetryRequest + " and " + telRequest + ".");
		setTimeSeriesPropertiesTelemetry(ts, telStation);
		setCommentsTelemetry(ts, telStation);
		
		// Read Data
		if(readData){
			// Pass Data into TS Object
			if(interval_base == TimeInterval.MINUTE){
				for(int i = 0; i < results.size(); i++){
					TelemetryTimeSeries telTSRaw = (TelemetryTimeSeries)JacksonToolkit.getInstance().treeToValue(results.get(i), TelemetryTimeSeries.class);
					
					// Set Date
					DateTime date = new DateTime(DateTime.PRECISION_MINUTE);
					date.setYear(telTSRaw.getYear());
					date.setMonth(telTSRaw.getMonth());
					date.setDay(telTSRaw.getDay());
					date.setHour(telTSRaw.getHour());
					date.setMinute(telTSRaw.getMinute());
					
					// Get Data
					double value = telTSRaw.getMeasValue();
					ts.setDataValue(date, value);
				}
			}
			if(interval_base == TimeInterval.HOUR){
				for(int i = 0; i < results.size(); i++){
					TelemetryTimeSeries telTSRaw = (TelemetryTimeSeries)JacksonToolkit.getInstance().treeToValue(results.get(i), TelemetryTimeSeries.class);
					
					// Set Date
					DateTime date = new DateTime(DateTime.PRECISION_HOUR);
					date.setYear(telTSRaw.getYear());
					date.setMonth(telTSRaw.getMonth());
					date.setDay(telTSRaw.getDay());
					date.setHour(telTSRaw.getHour());

					// Get Data
					double value = telTSRaw.getMeasValue();
					ts.setDataValue(date, value);
				}
			}
			if(interval_base == TimeInterval.DAY){
				for(int i = 0; i < results.size(); i++){
					TelemetryTimeSeries telTSRaw = (TelemetryTimeSeries)JacksonToolkit.getInstance().treeToValue(results.get(i), TelemetryTimeSeries.class);
					
					// Set Date
					DateTime date = new DateTime(DateTime.PRECISION_DAY);
					date.setYear(telTSRaw.getYear());
					date.setMonth(telTSRaw.getMonth());
					date.setDay(telTSRaw.getDay());

					// Get Data
					double value = telTSRaw.getMeasValue();
					ts.setDataValue(date, value);
				}
			}
		}
		
	}
	else if(data_type.equalsIgnoreCase("WaterLevelDepth") || data_type.equalsIgnoreCase("WaterLevelElev")){
		String wellid = locid;
		
		// Get Well 
		String wellRequest = getServiceRootURI() + "/groundwater/waterlevels/wells?format=json&wellid=" + wellid +  getApiKeyString();
		JsonNode wellResults = JacksonToolkit.getInstance().getJsonNodeFromWebServices(wellRequest).get(0);
		
		//System.out.println(wellRequest);
		Message.printStatus(2, routine, "Get wells from DWR REST API request url: " + wellRequest);
		
		WaterLevelsWell well = (WaterLevelsWell)JacksonToolkit.getInstance().treeToValue(wellResults, WaterLevelsWell.class);
		
		// Set Description
		ts.setDescription(well.getWellName());
		
		/* Get first and last date */
		//TODO @jurentie 06/21/2018 no units in request results
		// First Date = PorStart
		DateTime firstDate = new DateTime(DateTime.PRECISION_DAY);
		firstDate.setYear(well.getPorStart().getYear());
		firstDate.setMonth(well.getPorStart().getMonth());
		firstDate.setDay(well.getPorStart().getDay());
		ts.setDate1Original(firstDate);
		
		// Last Date = PorEnd
		DateTime lastDate = new DateTime(DateTime.PRECISION_DAY);
		lastDate.setYear(well.getPorEnd().getYear());
		lastDate.setMonth(well.getPorEnd().getMonth());
		lastDate.setDay(well.getPorEnd().getDay());
		ts.setDate2Original(lastDate);
			
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
			
		// Allocate data space
		ts.allocateDataSpace();
		
		// Set Properties
		// FIXME @jurentie 06/26/2018 - move add to genesis elsewhere
		//ts.addToGenesis("read data from web services " + wellRequest + " and " + wellMeasurementRequest + ".");
		setTimeSeriesPropertiesWell(ts, well);
		setCommentsWell(ts, well);
		
		// Read Data
		if(readData){
			String wellMeasurementRequest = getServiceRootURI() + "/groundwater/waterlevels/wellmeasurements/" + wellid + "?format=json" + getApiKeyString();
			JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(wellMeasurementRequest);
			//System.out.println(wellMeasurementRequest);
			Message.printStatus(1, routine, "Retrieve well measurements from DWR REST API request url: " + wellMeasurementRequest);
			for(int i = 0; i < results.size(); i++){
				WaterLevelsWellMeasurement wellMeas = (WaterLevelsWellMeasurement)JacksonToolkit.getInstance().treeToValue(results.get(i), WaterLevelsWellMeasurement.class);
				
				// Set Date
				DateTime date = new DateTime(DateTime.PRECISION_DAY);
				date.setYear(wellMeas.getMeasurementDate().getYear());
				date.setMonth(wellMeas.getMeasurementDate().getMonth());
				date.setDay(wellMeas.getMeasurementDate().getDay());

				// Get Data
				// TODO @jurentie 06/26/2018 - depthToWater or depthWaterBelowLandSurface
				double value;
				if(data_type.equalsIgnoreCase("WaterLevelDepth")){
					value = wellMeas.getDepthToWater();
				}else{
					value = wellMeas.getElevationOfWater();
				}
				
				ts.setDataValue(date, value);
			}
		}
		
	}
	
	// Return Time Series Object
    return ts;
}

/* TODO: add all these cases to this method */
public DiversionWaterClass readWaterClassNumForWdid(String wdid, String waterClassReqString,boolean divTotalReq, boolean relTotalReq){
	
	DiversionWaterClass waterClass = null;

	try {
		String request = getServiceRootURI() + "/structures/divrec/waterclasses/?wdid=" + URLEncoder.encode(wdid, "UTF-8") + getApiKeyString();
		request += (divTotalReq) ? "&divrectype=DivTotal" : "";
		request += (relTotalReq) ? "&divrectype=RelTotal" : "";
		if(waterClassReqString != ""){
			request += "&divrectype=WaterClass" + "&wcIdentifier=" + URLEncoder.encode(waterClassReqString, "UTF-8");
		}
		//System.out.println(request);
		JsonNode resultList = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request);
		for(int i = 0; i < resultList.size(); i++){
			waterClass = (DiversionWaterClass)JacksonToolkit.getInstance().treeToValue(resultList.get(i), DiversionWaterClass.class);
		}
	} 
	catch (IOException e) { e.printStackTrace(); }
	
	return waterClass;
}

/**
 * Read districts from web services
 * @throws MalformedURLException 
 */
private void readWaterDistricts(){
	String districtRequest = getServiceRootURI() + "/referencetables/waterdistrict/?format=json" + getApiKeyString();
	waterDistrictList = new ArrayList<ReferenceTablesWaterDistrict>();
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(districtRequest);
	for(int i = 0; i < results.size(); i++){
		waterDistrictList.add((ReferenceTablesWaterDistrict)JacksonToolkit.getInstance().treeToValue(results.get(i), ReferenceTablesWaterDistrict.class));
	}
}

/**
 * Read divisions from web services
 * @throws MalformedURLException 
 */
private void readWaterDivisions(){
	String divisionRequest = getServiceRootURI() + "/referencetables/waterdivision/?format=json" + getApiKeyString();
	waterDivisionList = new ArrayList<ReferenceTablesWaterDivision>();
	JsonNode results = JacksonToolkit.getInstance().getJsonNodeFromWebServices(divisionRequest);
	for(int i = 0; i < results.size(); i++){
		waterDivisionList.add((ReferenceTablesWaterDivision)JacksonToolkit.getInstance().treeToValue(results.get(i), ReferenceTablesWaterDivision.class));
	}
}

//TODO @jurentie work out parameters here
/*public WellPermit getWellPermit(String receipt){
	String request = getServiceRootURI() + "/wellpermits/wellpermit/" + "?format=json" + "&receipt=" + receipt;
	return null;
}*/

//TODO @jurentie wellPermitHistory()

public static void setCommentsStructure ( TS ts, Structure struct )
{   // Use the same names as the database view columns, same order as view
	ts.addToComments("Structure and time series infromation from HydroBaseRest...");
	ts.addToComments("Time Series Identifier          = " + ts.getIdentifier());
	ts.addToComments("Description                     = " + ts.getDescription());
	ts.addToComments("Data Source                     = DWR");
	ts.addToComments("Data Type                       = " + ts.getDataType());
	ts.addToComments("Data Interval                   = " + ts.getIdentifier().getInterval());
	ts.addToComments("Data Units                      = " + ts.getDataUnits());
	ts.addToComments("HydroBase query period          = " + ts.getDate1() + " to " + ts.getDate2());
	ts.addToComments("HydroBase available period      = " + ts.getDate1Original().getYear() + " to " + ts.getDate2Original().getYear());
	ts.addToComments("Located in water div, district  = " + struct.getDivision() + ", " + struct.getWaterDistrict());
	ts.addToComments("Located in county               = " + struct.getCounty());
	ts.addToComments("Latitude, Longitude             = " + struct.getLatdecdeg() + ", " + struct.getLongdecdeg());
}

public static void setCommentsTelemetry (TS ts, TelemetryStation tel)
{
	ts.addToComments("Telemetry and time series information from HydroBaseRest...");
	ts.addToComments("Time Series Identifier          = " + ts.getIdentifier());
	ts.addToComments("Description                     = " + ts.getDescription());
	ts.addToComments("Data Source                     = " + tel.getDataSource());
	ts.addToComments("Data Type                       = " + ts.getDataType());
	ts.addToComments("Data Interval                   = " + ts.getIdentifier().getInterval());
	ts.addToComments("Data Units                      = " + ts.getDataUnits());
	ts.addToComments("HydroBase query period          = " + ts.getDate1() + " to " + ts.getDate2());
	ts.addToComments("HydroBase availabe period       = " + ts.getDate1Original() + " to " + ts.getDate2Original());
	ts.addToComments("Located in water div            = " + tel.getDivision());
	ts.addToComments("Located in county               = " + tel.getCounty());
	ts.addToComments("Latitude, Longitude             = " + tel.getLatitude() + ", " + tel.getLongitude());
}

public static void setCommentsWell (TS ts, WaterLevelsWell well)
{
	ts.addToComments("Telemetry and time series information from HydroBaseRest...");
	ts.addToComments("Time Series Identifier          = " + ts.getIdentifier());
	ts.addToComments("Description                     = " + ts.getDescription());
	ts.addToComments("Data Source                     = " + well.getDataSource());
	ts.addToComments("Data Type                       = " + ts.getDataType());
	ts.addToComments("Data Interval                   = " + ts.getIdentifier().getInterval());
	ts.addToComments("Data Units                      = " + ts.getDataUnits());
	ts.addToComments("HydroBase query period          = " + ts.getDate1() + " to " + ts.getDate2());
	ts.addToComments("HydroBase availabe period       = " + ts.getDate1Original() + " to " + ts.getDate2Original());
	ts.addToComments("Located in water div            = " + well.getDivision());
	ts.addToComments("Located in county               = " + well.getCounty());
	ts.addToComments("Latitude, Longitude             = " + well.getLatitude() + ", " + well.getLongitude());
}

public static void setTimeSeriesPropertiesStructure ( TS ts, Structure struct )
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

public static void setTimeSeriesPropertiesTelemetry (TS ts, TelemetryStation tel)
{
	ts.setProperty("div", (new Integer(tel.getDivision()) == null) ? null : new Integer(tel.getDivision()));
	ts.setProperty("wd", (new Integer(tel.getWaterDistrict()) == null) ? null : new Integer(tel.getWaterDistrict()));
	ts.setProperty("county", (tel.getCounty() == null) ? null : tel.getCounty());
	ts.setProperty("station_name", (tel.getStationName() == null) ? null : tel.getStationName());
	ts.setProperty("data_source", (tel.getDataSource() == null) ? null : tel.getDataSource());
	ts.setProperty("abbrev", (tel.getAbbrev() == null) ? null : tel.getAbbrev());
	ts.setProperty("usgs_station_id", (tel.getUsgsStationId() == null) ? null : tel.getUsgsStationId());
	ts.setProperty("station_status", (tel.getStationStatus() == null) ? null : tel.getStationStatus());
	ts.setProperty("station_type", (tel.getStationType() == null) ? null : tel.getStationType());
	ts.setProperty("structure_type", (tel.getStructureType() == null) ? null : tel.getStructureType());
	ts.setProperty("measDateTime", (tel.getMeasDateTime() == null) ? null : tel.getMeasDateTime());
	ts.setProperty("parameter", (tel.getParameter() == null) ? null : tel.getParameter());
	ts.setProperty("stage", (new Double(tel.getStage()) == null) ? null : tel.getStage());
	ts.setProperty("meas_value", (new Double(tel.getMeasValue()) == null) ? null : new Double(tel.getMeasValue()));
	ts.setProperty("units", (tel.getUnits() == null) ? null : tel.getUnits());
	ts.setProperty("flagA", (tel.getFlagA() == null) ? null : tel.getFlagA());
	ts.setProperty("flagB", (tel.getFlagB() == null) ? null : tel.getFlagB());
	ts.setProperty("contr_area", (new Double(tel.getContrArea()) == null) ? null : new Double(tel.getContrArea()));
	ts.setProperty("drain_area", (new Double(tel.getDrainArea()) == null) ? null : new Double(tel.getDrainArea()));
	ts.setProperty("huc10", (tel.getHuc10() == null) ? null : tel.getHuc10());
	ts.setProperty("utmX", (new Double(tel.getUtmX()) == null) ? null : new Double(tel.getUtmX()));
	ts.setProperty("utmY", (new Double(tel.getUtmY()) == null) ? null : new Double(tel.getUtmY()));
	ts.setProperty("latitude", (new Double(tel.getLatitude()) == null) ? null : new Double(tel.getLatitude()));
	ts.setProperty("longitude", (new Double(tel.getLongitude()) == null) ? null : new Double(tel.getLongitude()));
	ts.setProperty("location_accuracy", (tel.getLocationAccuracy() == null) ? null : tel.getLocationAccuracy());
	ts.setProperty("wdid", (tel.getWdid() == null) ? null : tel.getWdid());
	ts.setProperty("modified", (tel.getModified() == null) ? null : tel.getModified());
	ts.setProperty("moreInformation", (tel.getMoreInformation() == null) ? null : tel.getMoreInformation());
}

public static void setTimeSeriesPropertiesWell ( TS ts, WaterLevelsWell well )
{   // Use the same names as the database view columns, same order as view
	ts.setProperty("well_id", (new Integer(well.getWellId()) == null) ? null : new Integer(well.getWellId()));
	ts.setProperty("well_name", (well.getWellName() == null) ? null : well.getWellName());
	ts.setProperty("receipt", (well.getReceipt() == null) ? null : well.getReceipt());
	ts.setProperty("permit", (well.getPermit() == null) ? null : well.getPermit());
	ts.setProperty("well_depth", (new Integer(well.getWellDepth()) == null) ? null : new Integer(well.getWellDepth()));
	ts.setProperty("measurement_date", (well.getMeasurementDate() == null) ? null : well.getMeasurementDate());
	ts.setProperty("por_start", (well.getPorStart() == null) ? null : well.getPorStart());
	ts.setProperty("por_end", (well.getPorEnd() == null) ? null : well.getPorEnd());
	ts.setProperty("por_count", (new Integer(well.getPorCount()) == null) ? null : new Integer(well.getPorCount()));
	ts.setProperty("publication_name", (well.getPublicationName() == null) ? null : well.getPublicationName());
	ts.setProperty("aquifers", (well.getAquifers() == null) ? null : well.getAquifers());
	ts.setProperty("elevation", (new Double(well.getElevation()) == null) ? null : well.getElevation());
	ts.setProperty("elevation_accuracy", (well.getElevationAccuracy() == null) ? null : well.getElevationAccuracy());
	ts.setProperty("top_perforated_casing", (new Integer(well.getTopPerforatedCasing()) == null) ? null : new Integer(well.getTopPerforatedCasing()));
	ts.setProperty("bottom_perforated_casing", (new Integer(well.getBottomPerforatedCasing()) == null) ? null : new Integer(well.getBottomPerforatedCasing()));
	ts.setProperty("base_of_grout", (new Integer(well.getBaseOfGrout()) == null) ? null : new Integer(well.getBaseOfGrout()));
	ts.setProperty("wdid", (well.getWdid() == null) ? null : well.getWdid());
	ts.setProperty("location_number", (well.getLocationNumber() == null) ? null : well.getLocationNumber());
	ts.setProperty("usgs_site_id", (well.getUsgsSiteId() == null) ? null : well.getUsgsSiteId());
	ts.setProperty("contact", (well.getContact() == null) ? null : well.getContact());
	ts.setProperty("division", (new Integer(well.getDivision()) == null) ? null : well.getDivision());
	ts.setProperty("water_district", (new Integer(well.getWaterDistrict()) == null) ? null : well.getWaterDistrict());
	ts.setProperty("county", (well.getCounty()== null) ? null : well.getCounty());
	ts.setProperty("designated_basin", (well.getDesignatedBasin() == null) ? null : well.getDesignatedBasin());
	ts.setProperty("management_district", (well.getManagementDistrict() == null) ? null : well.getManagementDistrict());
	ts.setProperty("q10", (well.getQ10() == null) ? null : well.getQ10());
	ts.setProperty("q40", (well.getQ40() == null) ? null : well.getQ40());
	ts.setProperty("q160", (well.getQ160() == null) ? null : well.getQ160());
	ts.setProperty("section", (well.getSection() == null) ? null : well.getSection());
	ts.setProperty("township", (well.getTownship() == null) ? null : well.getTownship());
	ts.setProperty("range", (well.getRange() == null) ? null : well.getRange());
	ts.setProperty("pm", (well.getPm() == null) ? null : well.getPm());
	ts.setProperty("coordiantes_ew", (new Integer(well.getCoordinatesEw()) == null) ? null : well.getCoordinatesEw());
	ts.setProperty("coordiantes_ew_dir", (well.getCoordinatesEwDir() == null) ? null : well.getCoordinatesEwDir());
	ts.setProperty("coordinates_ns", (new Integer(well.getCoordinatesNs()) == null) ? null : new Integer(well.getCoordinatesNs()));
	ts.setProperty("coordinates_ns_dir", (well.getCoordinatesNsDir() == null) ? null : well.getCoordinatesNsDir());
	ts.setProperty("utmX", (new Double(well.getUtmX()) == null) ? null : new Double(well.getUtmX()));
	ts.setProperty("utmY", (new Double(well.getUtmY()) == null) ? null : new Double(well.getUtmY()));
	ts.setProperty("latitude", (new Double(well.getLatitude()) == null) ? null : new Double(well.getLatitude()));
	ts.setProperty("longitude", (new Double(well.getLongitude()) == null) ? null : new Double(well.getLongitude()));
	ts.setProperty("location_accuracy", (well.getLocationAccuracy() == null) ? null : well.getLocationAccuracy());
	ts.setProperty("data_source", (well.getDataSource() == null) ? null : well.getDataSource());
	ts.setProperty("modified", (well.getModified() == null) ? null : well.getModified());
	ts.setProperty("more_information", (well.getMoreInformation() == null) ? null : well.getMoreInformation());
}

public boolean waterclassHasComments(String wdid){
	
	DiversionWaterClass waterClass = null;
	
	boolean hasComments = false;

	try {
		String request = getServiceRootURI() + "/structures/divrec/waterclasses/?wdid=" + URLEncoder.encode(wdid, "UTF-8") + getApiKeyString();
		//System.out.println(request);
		JsonNode resultList = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request);
		for(int i = 0; i < resultList.size(); i++){
			waterClass = (DiversionWaterClass)JacksonToolkit.getInstance().treeToValue(resultList.get(i), DiversionWaterClass.class);
			if(waterClass.getDivrectype().equalsIgnoreCase("DIVCOMMENT")){
				hasComments = true;
			}
		}
	} 
	catch (IOException e) { e.printStackTrace(); }
	
	return hasComments;
}

/**
 * Inserting main method for testing purposes:
 * @throws URISyntaxException 
 * @throws IOException 
 */
public static void main(String[] args) throws URISyntaxException, IOException{

	/*String request = "https://dnrweb.state.co.us/DWR/DwrApiService/api/v2/waterrights/netamount/?format=jsonprettyprint&apiKey=ulF7gMR2Wcx9dWm6QeltbJbcwih3/vP4HXqYDO7YVhXNQry7/P1Zww==&wdid=2000511&pageSize=2";
	JsonNode json = JacksonToolkit.getInstance().getJsonNodeFromWebServices(request);
	
	URI uri = new URI("http://dnrweb.state.co.us/DWR/DwrApiService/api/v2");

	ColoradoHydroBaseRestDataStore chrds = new ColoradoHydroBaseRestDataStore("DWR", "Colorado Division of Water Resources Hydrobase", uri, "ulF7gMR2Wcx9dWm6QeltbJbcwih3/vP4HXqYDO7YVhXNQry7/P1Zww==");

	System.out.println();*/

	
	/*URI uri = new URI("http://dnrweb.state.co.us/DWR/DwrApiService/api/v2");
	
	try {
		ColoradoHydroBaseRestDataStore chrds = new ColoradoHydroBaseRestDataStore("DWR", "Colorado Division of Water Resources Hydrobase", uri, "ulF7gMR2Wcx9dWm6QeltbJbcwih3/vP4HXqYDO7YVhXNQry7/P1Zww==");
		//System.out.println(chrds.getAPIVersion());
		
		/*DateTime date1 = new DateTime(DateTime.PRECISION_DAY);
		date1.setYear(2001);
		date1.setMonth(04);
		date1.setDay(10);
		
		DateTime date2 = new DateTime(DateTime.PRECISION_DAY);
		date2.setYear(2005);
		date2.setMonth(12);
		date2.setDay(14);
		
		chrds.readTimeSeries("wdid:8003550.DWR.ResMeasStage.Day~ColoradoHydroBaseRest", null, null, true);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
}

}