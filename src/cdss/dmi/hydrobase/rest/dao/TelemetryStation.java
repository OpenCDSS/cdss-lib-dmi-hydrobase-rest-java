package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrystation
 * @author jurentie
 *
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryStation {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/** 
	 * Abbreviation 
	 */
	private String abbrev;

	/** 
	 * Contributing Area 
	 */
	private double contrArea;

	/** 
	 * County where the well is located 
	 */
	private String county;

	/** 
	 * Full data source description 
	 */
	private String dataSource;

	/**
	 * Primary source/provider of well measurement data
	 */
	private String dataSourceAbbrev;
	
	/** 
	 * DWR Water Division 
	 */
	private int division;
	
	/** 
	 * Drainage Area 
	 */
	private double drainArea;

	/** 
	 * Flag A 
	 */
	private String flagA;

	/** 
	 * Flag B 
	 */
	private String flagB;

	/**
	 * National Hydrographic Dataset stream identifier
	 */
	private String gnisId;

	/** 
	 * HUC 10 
	 */
	private String huc10;

	/** 
	 * Latitude (decimal degrees) 
	 */
	private double latitude;

	/** 
	 * Accuracy of location coordinates 
	 */
	private String locationAccuracy;

	/** 
	 * Longitude (decimal degrees) 
	 */
	private double longitude;

	/** 
	 * Measurement Date Time 
	 */
	private DateTime measDateTime;

	/** 
	 * Measurement Value 
	 */
	private double measValue;

	/**
	 * Last date time that this record was modified in the DWR database
	 */
	private DateTime modified;

	/** 
	 * Hyperlink to additional details 
	 */
	private String moreInformation;

	/** 
	 * Parameter 
	 */
	private String parameter;

	/** 
	 * Recorded stage (feet) 
	 */
	private double stage;

	/** 
	 * Station Name 
	 */
	private String stationName;
	
	/** 
	 * Station Status 
	 */
	private String stationStatus;

	/** 
	 * Station Type 
	 */
	private String stationType;

	/**
	 * Distance in miles to the confluence with the next downstream 
	 * water source (or distance to state line)
	 */
	private double streamMile;

	/** 
	 * Type of structure 
	 */
	private String structureType;
	
	/** 
	 * Units of measure 
	 */
	private String units;

	/** 
	 * USGS Station ID 
	 */
	private String usgsStationId;

	/** 
	 * The x (Easting) component of the Universal Transverse Mercator system 
	 * (Zone 12, NAD83 datum) 
	 */
	private double utmX;
	
	/** 
	 * The y (Northing) component of the Universal Transverse Mercator system 
	 * (Zone 12, NAD83 datum) 
	 */
	private double utmY;
	
	/** 
	 * DWR Water District 
	 */
	private int waterDistrict;

	/** 
	 * Water Source 
	 */
	private String waterSource;

	/** 
	 * DWR unique structure identifier
	 */
	private String wdid;
	
	/**
	 * Getters and setters of defined variables.
	 */
	public String getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public double getContrArea() {
		return contrArea;
	}

	public void setContrArea(double contrArea) {
		this.contrArea = contrArea;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getDataSourceAbbrev() {
		return dataSourceAbbrev;
	}

	public void setDataSourceAbbrev(String dataSourceAbbrev) {
		this.dataSourceAbbrev = dataSourceAbbrev;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int div) {
		this.division = div;
	}

	public double getDrainArea() {
		return drainArea;
	}

	public void setDrainArea(double drainArea) {
		this.drainArea = drainArea;
	}

	public String getFlagA() {
		return flagA;
	}

	public void setFlagA(String flagA) {
		this.flagA = flagA;
	}

	public String getFlagB() {
		return flagB;
	}

	public void setFlagB(String flagB) {
		this.flagB = flagB;
	}

	public String getGnisId() {
		return gnisId;
	}

	public void setGnisId(String gnisId) {
		this.gnisId = gnisId;
	}

	public String getHuc10() {
		return huc10;
	}

	public void setHuc10(String huc10) {
		this.huc10 = huc10;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getLocationAccuracy() {
		return locationAccuracy;
	}

	public void setLocationAccuracy(String locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public DateTime getMeasDateTime() {
		return measDateTime;
	}

	public void setMeasDateTime(String measDateTime) {
		this.measDateTime = TimeToolkit.getInstance().toDateTime(measDateTime, true);
	}

	public double getMeasValue() {
		return measValue;
	}

	public void setMeasValue(double measValue) {
		this.measValue = measValue;
	}

	public DateTime getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, true);
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public double getStage() {
		return stage;
	}

	public void setStage(double stage) {
		this.stage = stage;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	public String getStationStatus() {
		return stationStatus;
	}

	public void setStationStatus(String stationStatus) {
		this.stationStatus = stationStatus;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public double getStreamMile() {
		return streamMile;
	}

	public void setStreamMile(double streamMile) {
		this.streamMile = streamMile;
	}

	public String getStructureType() {
		return structureType;
	}

	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getUsgsStationId() {
		return usgsStationId;
	}

	public void setUsgsStationId(String usgsStationId) {
		this.usgsStationId = usgsStationId;
	}

	public double getUtmX() {
		return utmX;
	}

	public void setUtmX(double utmX) {
		this.utmX = utmX;
	}

	public double getUtmY() {
		return utmY;
	}

	public void setUtmY(double utmY) {
		this.utmY = utmY;
	}

	public int getWaterDistrict() {
		return waterDistrict;
	}

	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}

	public String getWaterSource() {
		return waterSource;
	}

	public void setWaterSource(String waterSource) {
		this.waterSource = waterSource;
	}

	public String getWdid() {
		return wdid;
	}

	public void setWdid(String wdid) {
		this.wdid = wdid;
	}

	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "TelemetryStation: [ div: " + division + ", wd: " + waterDistrict + ", county: " + county + ", stationName: " +
				stationName + ", dataSource: " + dataSource + ", abbrev: " + abbrev + ", usgsStationId: " +
				usgsStationId + ", stationStatus: " + stationStatus + ", stationType: " + stationType + 
				", strcutureType: " + structureType + ", measDateTime: " + measDateTime + ", parameter: " + 
				parameter + ", stage: " + stage + ", measValue: " + measValue + ", units: " + units + ", flagA" + 
				flagA + ", flagB: " + flagB + ", contrArea: " + contrArea + ", drainArea: " + drainArea + 
				", huc10: " + huc10 + ", utmX: " + utmX + ", utmY: " + utmY + ", latitude: " + latitude + 
				", longitude: " + longitude + ", locationAccuracy: " + locationAccuracy + ", wdid: " + wdid + 
				", modified: " + modified + ", moreInformation: " + moreInformation + " ]";
	}


}
