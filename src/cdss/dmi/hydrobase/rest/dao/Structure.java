package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

public class Structure {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures
	 */

	/* WDID */
	private String wdid;
	
	/* Name of Structure */
	private String structureName;
	
	/* Associated AKA's */
	private String associatedAkas;
	
	/* Current in use code */
	private String ciuCode;
	
	/* Type of Structure */
	private String structureType;
	
	/* Water Source */
	private String waterSource;
	
	/* GNIS ID */
	private String  gnisId;
	
	/* Stream Mile Number */
	private double streamMile;
	
	/* Associated Case Numbers */
	private String associatedCaseNumbers;
	
	/* Associated Permits */
	private String associatedPermits;
	
	/* Associated Meters */
	private String associatedMeters;
	
	/*Associated Contacts*/
	private String associatedContacts;
	
	/* Start Time */
	private LocalDateTime porStart;
	
	/* End Time */
	private LocalDateTime porEnd;
	
	/* DWR Water Division */
	private int division;
	
	/*DWR Water District */
	private int waterDistrict;
	
	/* Water subdistrict */
	private String subdistrict;
	
	/* County */
	private String county;
	
	/* Designated Basin Name */
	private String designatedBasinName;
	
	/* Management District Name */
	private String managementDistrictName;
	
	/* Principal Meridian */
	private String pm;
	
	/* Township */
	private String township;
	
	/* Range */
	private String range;
	
	/* Section */
	private String section;
	
	/* 10 acre quarter section indicator */
	private String q10;
	
	/* 40 acre quarter section indicator */
	private String q40;
	
	/* 160 acre quarter section indicator */
	private String q160;
	
	/* Distance from east/west section line (feet) */
	private int coordsew;
	
	/* Direction of measurement from east/west section line */
	private String coordsewDir;
	
	/* Distance from north/south section line */
	private int coordsns;
	
	/* Direction of measurement from north/south section line */
	private String coordsnsDir;
	
	/* The x (Easting) component of the Universal Transverse Mercator system. (Zone 12, NAD83 datum) */
	private double utmX;
	
	/* The y (Northing) component of the Universal Transverse Mercator system. (Zone 12, NAD83 datum) */
	private double utmY;
	
	/* Latitude in decimal degrees */
	private double latdecdeg;
	
	/* Longitude in decimal degrees */
	private double longdecdeg;
	
	/*Accuracy of the location */
	private String locationAccuracy;
	
	/* Modified date/time */
	private LocalDateTime modified;
	
	/* Getters and Setters */

	public String getWdid() {
		return wdid;
	}

	public void setWdid(String wdid) {
		this.wdid = wdid;
	}

	public String getStructureName() {
		return structureName;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}

	public String getAssociatedAkas() {
		return associatedAkas;
	}

	public void setAssociatedAkas(String associatedAkas) {
		this.associatedAkas = associatedAkas;
	}

	public String getCiuCode() {
		return ciuCode;
	}

	public void setCiuCode(String ciuCode) {
		this.ciuCode = ciuCode;
	}

	public String getStructureType() {
		return structureType;
	}

	public void setStructureType(String structureType) {
		this.structureType = structureType;
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

	public void setGnisId(String gnisID) {
		this.gnisId = gnisID;
	}

	public double getStreamMile() {
		return streamMile;
	}

	public void setStreamMile(double streamMile) {
		this.streamMile = streamMile;
	}

	public String getAssociatedCaseNumbers() {
		return associatedCaseNumbers;
	}

	public void setAssociatedCaseNumbers(String associatedCaseNumbers) {
		this.associatedCaseNumbers = associatedCaseNumbers;
	}

	public String getAssociatedPermits() {
		return associatedPermits;
	}

	public void setAssociatedPermits(String associatedPermits) {
		this.associatedPermits = associatedPermits;
	}

	public String getAssociatedMeters() {
		return associatedMeters;
	}

	public void setAssociatedMeters(String associatedMeters) {
		this.associatedMeters = associatedMeters;
	}
	
	public String getAssociatedContacts() {
		return associatedContacts;
	}

	public void setAssociatedContacts(String associatedContacts) {
		this.associatedContacts = associatedContacts;
	}

	public LocalDateTime getPorStart() {
		return porStart;
	}

	public void setPorStart(String porStart) {
		this.porStart = (porStart == null) ? null : LocalDateTime.parse(porStart);
	}

	public LocalDateTime getPorEnd() {
		return porEnd;
	}

	public void setPorEnd(String porEnd) {
		this.porEnd = (porEnd == null) ? null : LocalDateTime.parse(porEnd);
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

	public String getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getDesignatedBasinName() {
		return designatedBasinName;
	}

	public void setDesignatedBasinName(String designatedBasinName) {
		this.designatedBasinName = designatedBasinName;
	}

	public String getManagementDistrictName() {
		return managementDistrictName;
	}

	public void setManagementDistrictName(String managementDistrictName) {
		this.managementDistrictName = managementDistrictName;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
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

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
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

	public int getCoordsew() {
		return coordsew;
	}

	public void setCoordsew(int coordsew) {
		this.coordsew = coordsew;
	}

	public String getCoordsewDir() {
		return coordsewDir;
	}

	public void setCoordsewDir(String coordsewDir) {
		this.coordsewDir = coordsewDir;
	}

	public int getCoordsns() {
		return coordsns;
	}

	public void setCoordsns(int coordsns) {
		this.coordsns = coordsns;
	}

	public String getCoordsnsDir() {
		return coordsnsDir;
	}

	public void setCoordsnsDir(String coordsnsDir) {
		this.coordsnsDir = coordsnsDir;
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
	
	@Override
	public String toString(){
		return "Structure: [ wdid: " + wdid + ", structureName: " + structureName + ", associatedAkas: " +
				associatedAkas + ", ciuCode: " + ciuCode + ", structureType: " + structureType + ", waterSource: " +
				waterSource + ", gnisId: " + gnisId + ", streamMile: " + ", associatedCaseNumbers: " + associatedCaseNumbers +
				", associatedPermits: " + associatedPermits + ", associatedMeters: " + ", associatedContacts: " + 
				associatedContacts + ", porStart: " + porStart + ", porEnd: " + porEnd + ", division: " + division +
				", waterDistrict: " + waterDistrict + ", subdistrict: " + subdistrict + ", county: " + county + 
				", designatedBasinName: " + designatedBasinName + ", managementDistrictName: " + managementDistrictName + 
				", pm: " + pm + ", township: " + township + ", range: " + range + ", section: " + section +
				", q10: " + q10 + ", q40: " + q40 + ", q160:  " + q160 + ", coordsew: " + coordsew + ", coordsewDir: " +
				coordsewDir + ", coordsns: " + coordsns + ", coordsnsDir: " + coordsnsDir + ", utmX: " + utmX + ", utmY: " +
				utmY + ", latdecdeg: " + latdecdeg + ", longdecdeg: " + longdecdeg + ", locationAccuracy: " 
				+ locationAccuracy + ", modified: " + modified + " ]";
				
	}
	
}
