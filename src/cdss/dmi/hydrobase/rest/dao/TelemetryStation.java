package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryStation {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrystation
	 */
	
	/* DWR Water Division */
	private int division;
	
	/* DWR Water District */
	private int waterDistrict;
	
	/* County */
	private String county;
	
	/* Station Name */
	private String stationName;
	
	/* Data Source */
	private String dataSourceAbbrev;
	
	/* Full data source description */
	private String dataSource;
	
	/* Water Source */
	private String waterSource;
	
	/* GNIS ID */
	private String gnisId;
	
	/* Stream Mile */
	private double streamMile;
	
	/* Abbreviation */
	private String abbrev;
	
	/* USGS Station ID */
	private String usgsStationId;
	
	/* Station Status */
	private String stationStatus;
	
	/* Station Type */
	private String stationType;
	
	/* Structure Type */
	private String structureType;
	
	/* Measurement Date Time */
	private LocalDateTime measDateTime;
	
	/* Parameter */
	private String parameter;
	
	/* Stage */
	private double stage;
	
	/* Measurement Value */
	private double measValue;
	
	/* Units */
	private String units;
	
	/* Flag A */
	private String flagA;
	
	/* Flag B */
	private String flagB;
	
	/* Contr Area */
	private double contrArea;
	
	/* Drain Area */
	private double drainArea;
	
	/* HUC 10 */
	private String huc10;
	
	/* The x (Easting) component of the Universal Transverse Mercator system (Zone 12, NAD83 datum) */
	private double utmX;
	
	/* The y (Northing) component of the Universal Transverse Mercator system (Zone 12, NAD83 datum) */
	private double utmY;
	
	/* Latitude (decimal degrees) */
	private double latitude;
	
	/* Longitude (decimal degrees) */
	private double longitude;
	
	/* Accuracy of location coordinates */
	private String locationAccuracy;
	
	/* WDID */
	private String wdid;
	
	/* Modified date/time */
	private LocalDateTime modified;
	
	/* Hyperlink to additional details */
	private String moreInformation;

	public int getDivision() {
		return division;
	}

	public void setDivision(int div) {
		this.division = div;
	}

	public int getWaterDistrict() {
		return waterDistrict;
	}

	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	public String getDataSourceAbbrev() {
		return dataSourceAbbrev;
	}

	public void setDataSourceAbbrev(String dataSourceAbbrev) {
		this.dataSourceAbbrev = dataSourceAbbrev;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	
	public String getWaterSource() {
		return waterSource;
	}

	public void setWaterSource(String waterSource) {
		this.waterSource = waterSource;
	}

	public String getGnisId() {
		return gnisId;
	}

	public void setGnisId(String gnisId) {
		this.gnisId = gnisId;
	}

	public double getStreamMile() {
		return streamMile;
	}

	public void setStreamMile(double streamMile) {
		this.streamMile = streamMile;
	}

	public String getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public String getUsgsStationId() {
		return usgsStationId;
	}

	public void setUsgsStationId(String usgsStationId) {
		this.usgsStationId = usgsStationId;
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

	public String getStructureType() {
		return structureType;
	}

	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}

	public LocalDateTime getMeasDateTime() {
		return measDateTime;
	}

	public void setMeasDateTime(String measDateTime) {
		if(measDateTime == null){
			this.measDateTime = null;
		}
		int indexOf = measDateTime.lastIndexOf("-");
		measDateTime = measDateTime.substring(0, indexOf);
		this.measDateTime = LocalDateTime.parse(measDateTime);
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

	public double getMeasValue() {
		return measValue;
	}

	public void setMeasValue(double measValue) {
		this.measValue = measValue;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
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

	public double getContrArea() {
		return contrArea;
	}

	public void setContrArea(double contrArea) {
		this.contrArea = contrArea;
	}

	public double getDrainArea() {
		return drainArea;
	}

	public void setDrainArea(double drainArea) {
		this.drainArea = drainArea;
	}

	public String getHuc10() {
		return huc10;
	}

	public void setHuc10(String huc10) {
		this.huc10 = huc10;
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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getLocationAccuracy() {
		return locationAccuracy;
	}

	public void setLocationAccuracy(String locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
	}

	public String getWdid() {
		return wdid;
	}

	public void setWdid(String wdid) {
		this.wdid = wdid;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(String modified) {
		if(modified == null){
			this.modified = null;
		}
		int indexOf = modified.lastIndexOf("-");
		modified = modified.substring(0, indexOf);
		this.modified = LocalDateTime.parse(modified);
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}
	
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
