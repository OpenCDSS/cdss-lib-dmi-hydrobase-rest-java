package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

public class WaterLevelsWell {
	
	/**
	 * Variables declared in order as returned
	 * by DWR API. For more detail see: 
	 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-groundwater-waterlevels-wells
	 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-groundwater-waterlevels-wells-wellId
	 */
	
	/* Well ID number */
	private int wellId;
	
	/* Well Name */
	private String wellName;
	
	/* Receipt */
	private String receipt;
	
	/* Permit */
	private String permit;
	
	/* Total Depth of Well */
	private int wellDepth;
	
	/* Last Measurement Date */
	private LocalDateTime measurementDate;
	
	/* Water Level Depth */
	private double waterLevelDepth;
	
	/* Water Level Elevation */
	private double waterLevelElevation;
	
	/* Entity Measuring Water */
	private String measurementBy;
	
	/* Date of First Measurement */
	private LocalDateTime porStart;
	
	/* Date of Last Measurement */
	private LocalDateTime porEnd;
	
	/* Number of Measurements Made */
	private int porCount;
	
	/* Publication Name */
	private String publicationName;
	
	/* Water Aquifer(s) */
	private String aquifers;
	
	/* Surface Elevation (Ft above Sea Level) */
	private double elevation;
	
	/* Elevation Accuracy */
	private String elevationAccuracy;
	
	/* Depth to Top of Perforated Casing (ft) */
	private int topPerforatedCasing;
	
	/* Depth to Bottom of Perforated Casing (ft) */
	private int bottomPerforatedCasing;
	
	/* Depth to Base of Grout (ft) */
	private int baseOfGrout;
	
	/* WDID */
	private String wdid;
	
	/* Location Number */
	private String locationNumber;
	
	/* USGS Site ID */
	private String usgsSiteId;
	
	/* Well Contact Information */
	private String contact;
	
	/* Water Division */
	private int division;
	
	/* Water District */
	private int waterDistrict;
	
	/* County */
	private String county;
	
	/* Designated Basin */
	private String designatedBasin;
	
	/* Management District */
	private String managementDistrict;
	
	/* 10 acre quarter section indicator */
	private String q10;
	
	/* 40 acre quarter section inidcator */
	private String q40;
	
	/* 160 acre quarter section indicator */
	private String q160;
	
	/* Section */
	private String section;
	
	/* Township */
	private String township;
	
	/* Range */
	private String range;
	
	/* Principal Meridian */
	private String pm;
	
	/* Distance from east/west section line (feet) */
	private int coordinatesEw;
	
	/* Direction of measurement from east/west section line */
	private String coordinatesEwDir;
	
	/* Distance from north/south section line (feet) */
	private int coordinatesNs;
	
	/* Direction of measurement from north/south section line */
	private String coordinatesNsDir;
	
	/* The x (Easting) component of the Universal Transverse Mercator system. (Zone 12, NAD83 datum) */
	private double utmX;
	
	/* The y (Northing) component of the Universal Transverse Mercator system. (Zone 12, NAD83 datum) */
	private double utmY;
	
	/* Latitude in decimal degrees */
	private double latitude;
	
	/* Longitude in decimal degrees */
	private double longitude;
	
	/* Method used to measure location */
	private String locationAccuracy;
	
	/* Entity Supplying Data */
	private String dataSource;
	
	/* Date record last modified */
	private LocalDateTime modified;
	
	/* Link to additional information */
	private String moreInformation;
	
	private String timeStep;
	
	private String dataType;
	
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getTimeStep() {
		return timeStep;
	}
	public void setTimeStep(String timeStep) {
		this.timeStep = timeStep;
	}
	public int getWellId() {
		return wellId;
	}
	public void setWellId(int wellId) {
		this.wellId = wellId;
	}
	public String getWellName() {
		return wellName;
	}
	public void setWellName(String wellName) {
		this.wellName = wellName;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public String getPermit() {
		return permit;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
	public int getWellDepth() {
		return wellDepth;
	}
	public void setWellDepth(int wellDepth) {
		this.wellDepth = wellDepth;
	}
	public LocalDateTime getMeasurementDate() {
		return measurementDate;
	}
	public void setMeasurementDate(String measurementDate) {
		this.measurementDate = LocalDateTime.parse(measurementDate);
	}
	public double getWaterLevelDepth() {
		return waterLevelDepth;
	}
	public void setWaterLevelDepth(double waterLevelDepth) {
		this.waterLevelDepth = waterLevelDepth;
	}
	public double getWaterLevelElevation() {
		return waterLevelElevation;
	}
	public void setWaterLevelElevation(double waterLevelElevation) {
		this.waterLevelElevation = waterLevelElevation;
	}
	public String getMeasurementBy() {
		return measurementBy;
	}
	public void setMeasurementBy(String measurementBy) {
		this.measurementBy = measurementBy;
	}
	public LocalDateTime getPorStart() {
		return porStart;
	}
	public void setPorStart(String porStart) {
		this.porStart = LocalDateTime.parse(porStart);
	}
	public LocalDateTime getPorEnd() {
		return porEnd;
	}
	public void setPorEnd(String porEnd) {
		this.porEnd = LocalDateTime.parse(porEnd);
	}
	public int getPorCount() {
		return porCount;
	}
	public void setPorCount(int porCount) {
		this.porCount = porCount;
	}
	public String getPublicationName() {
		return publicationName;
	}
	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}
	public String getAquifers() {
		return aquifers;
	}
	public void setAquifers(String aquifers) {
		this.aquifers = aquifers;
	}
	public double getElevation() {
		return elevation;
	}
	public void setElevation(double elevation) {
		this.elevation = elevation;
	}
	public String getElevationAccuracy() {
		return elevationAccuracy;
	}
	public void setElevationAccuracy(String elevationAccuracy) {
		this.elevationAccuracy = elevationAccuracy;
	}
	public int getTopPerforatedCasing() {
		return topPerforatedCasing;
	}
	public void setTopPerforatedCasing(int topPerforatedCasing) {
		this.topPerforatedCasing = topPerforatedCasing;
	}
	public int getBottomPerforatedCasing() {
		return bottomPerforatedCasing;
	}
	public void setBottomPerforatedCasing(int bottomPerforatedCasing) {
		this.bottomPerforatedCasing = bottomPerforatedCasing;
	}
	public int getBaseOfGrout() {
		return baseOfGrout;
	}
	public void setBaseOfGrout(int baseOfGrout) {
		this.baseOfGrout = baseOfGrout;
	}
	public String getWdid() {
		return wdid;
	}
	public void setWdid(String wdid) {
		this.wdid = wdid;
	}
	public String getLocationNumber() {
		return locationNumber;
	}
	public void setLocationNumber(String locationNumber) {
		this.locationNumber = locationNumber;
	}
	public String getUsgsSiteId() {
		return usgsSiteId;
	}
	public void setUsgsSiteId(String usgsSiteId) {
		this.usgsSiteId = usgsSiteId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
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
	public String getDesignatedBasin() {
		return designatedBasin;
	}
	public void setDesignatedBasin(String designatedBasin) {
		this.designatedBasin = designatedBasin;
	}
	public String getManagementDistrict() {
		return managementDistrict;
	}
	public void setManagementDistrict(String managementDistrict) {
		this.managementDistrict = managementDistrict;
	}
	public String getQ10() {
		return q10;
	}
	public void setQ10(String q10) {
		this.q10 = q10;
	}
	public String getQ40() {
		return q40;
	}
	public void setQ40(String q40) {
		this.q40 = q40;
	}
	public String getQ160() {
		return q160;
	}
	public void setQ160(String q160) {
		this.q160 = q160;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getTownship() {
		return township;
	}
	public void setTownship(String township) {
		this.township = township;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	public int getCoordinatesEw() {
		return coordinatesEw;
	}
	public void setCoordinatesEw(int coordinatesEw) {
		this.coordinatesEw = coordinatesEw;
	}
	public String getCoordinatesEwDir() {
		return coordinatesEwDir;
	}
	public void setCoordinatesEwDir(String coordinatesEwDir) {
		this.coordinatesEwDir = coordinatesEwDir;
	}
	public int getCoordinatesNs() {
		return coordinatesNs;
	}
	public void setCoordinatesNs(int coordinatesNs) {
		this.coordinatesNs = coordinatesNs;
	}
	public String getCoordinatesNsDir() {
		return coordinatesNsDir;
	}
	public void setCoordinatesNsDir(String coordinatesNsDir) {
		this.coordinatesNsDir = coordinatesNsDir;
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
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public LocalDateTime getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = (modified == null) ? null : LocalDateTime.parse(modified);
	}
	public String getMoreInformation() {
		return moreInformation;
	}
	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}
	
	@Override
	public String toString(){
		return "WaterLevelsWells [ wellId: " + wellId + ", wellName: " + wellName + ", receipt: " + receipt + 
				", permit: " + permit + ", welLDepth: " + wellDepth + ", measurementDate: " + measurementDate +
				", waterLevelDepth: " + waterLevelDepth + ", waterLevelElevation: " + waterLevelElevation + 
				", measurementBy: " + measurementBy + ", porStart: " + porStart + ", porEnd: " + porEnd + 
				", porCount: " + porCount + ", publicationName: " + ", aquifers: " + aquifers + ", elevation: " +
				elevation + ", elevationAccuracy: " + elevationAccuracy + ", topPerforatedCasing: " + topPerforatedCasing +
				", bottomPerforatedCasing: " + bottomPerforatedCasing + ", baseOfGrout:  " + baseOfGrout + 
				", wdid: " + wdid + ", locationNumber: " + locationNumber + ", usgsSiteId: " + usgsSiteId + 
				", contact: " + contact + ", division: " + division + ", waterDistrict: " + waterDistrict + 
				", county: " + county + ", designatedBasin: " + designatedBasin + ", managementDistrict: " + 
				managementDistrict + ", q10: " + q10 + ", q40: " + q40 + ", q160: " + q160 + ", section: " +
				section + ", township: " + township + ", range: " + range + ", pm: " + pm + ", coordinatesEw: " + 
				coordinatesEw + ", coordinatesEwDir: " + coordinatesEwDir + ", coordinatesNs: " + coordinatesNs + 
				", coordinatesNsDir: " + coordinatesNsDir + ", utmX: " + utmX + ", utmY: " + utmY + ", latitude: " +
				latitude + ", longitude: " + longitude + ", locationAccuracy: " + locationAccuracy + ", dataSource: " + 
				dataSource + ", modified: " + modified + ", moreInformation: " + moreInformation; 
	}
}
