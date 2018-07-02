package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

public class TelemetryStationDataTypes {
	
	private int division;
	private int waterDistrict;
	private String county;
	private String stationName;
	private String dataSourceAbbrev;
	private String dataSource;
	private String abbrev;
	private String wdid;
	private String usgsStationId;
	private String stationStatus;
	private String stationType;
	private String waterSource;
	private String gnisId;
	private double streamMile;
	private String structureType;
	private String parameter;
	private double contrArea;
	private double drainArea;
	private String huc10;
	private double utmX;
	private double utmY;
	private double latdecdeg;
	private double longdecdeg;
	private String locationAccuracy;
	private LocalDateTime modified;
	private String timeStep;
	public String getTimeStep() {
		return timeStep;
	}
	public void setTimeStep(String timeStep) {
		this.timeStep = timeStep;
	}
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
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
	public String getAbbrev() {
		return abbrev;
	}
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
	public String getWdid() {
		return wdid;
	}
	public void setWdid(String wdid) {
		this.wdid = wdid;
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
	public String getStructureType() {
		return structureType;
	}
	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
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
	public double getLatdecdeg() {
		return latdecdeg;
	}
	public void setLatdecdeg(double latdecdeg) {
		this.latdecdeg = latdecdeg;
	}
	public double getLongdecdeg() {
		return longdecdeg;
	}
	public void setLongdecdeg(double longdecdeg) {
		this.longdecdeg = longdecdeg;
	}
	public String getLocationAccuracy() {
		return locationAccuracy;
	}
	public void setLocationAccuracy(String locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
	}
	public LocalDateTime getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = (modified == null) ? null : LocalDateTime.parse(modified);
	}

}
