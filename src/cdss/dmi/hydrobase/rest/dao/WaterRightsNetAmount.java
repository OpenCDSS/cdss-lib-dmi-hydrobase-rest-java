package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WaterRightsNetAmount {
	
	/* listed in alphabetical order */
	
	/*Adjudication date is the date that the water 
	 * right was awarded by the water court.*/
	private LocalDateTime adjudicationDate;
	
	/*
	 * 	A calculated number developed by DWR to rank water rights in order of seniority. 
	 * The priority of the water right is based on the appropriation date and whether the water 
	 * right is subject to the Subordination Doctrine. The appropriation date is the date decreed 
	 * by the court that the water was first put to the decreed beneficial use. The Subordination 
	 * Doctrine established by the court says water rights that are adjudicated after other water 
	 * rights in their stream system must be subordinate to those rights previously decreed, 
	 * regardless of their appropriation date. To determine whether or not a water right is 
	 * subject to the Subordination Doctrine, DWR determines the "previous adjudication date" 
	 * associated with the water right. Water rights that have no previous adjudication date or 
	 * have an appropriation date that is later than the previous adjudication date can simply 
	 * use their appropriation date as their administrative priority. Water rights with an 
	 * appropriation date the same as or earlier than the previous adjudication date must be 
	 * subordinated to those previously decreed rights. Using the appropriation date and previous 
	 * adjudication date, the Priority Admin No (PAN) is calculated as follows:
	 * 
	 * If a water right has no previous adjudication date or the appropriation date of the water 
	 * right is later than the previous adjudication date: the left side of the PAN is the number 
	 * of days between 12/31/1849 and the appropriation date; and, the right side of the PAN is 
	 * zeros (.00000).
	 * 
	 * If the appropriation date of a water right is the same as or earlier than the previous 
	 * adjudication date: the left side of the PAN is the number of days between 12/31/1849 and 
	 * the previous adjudication date; and, the right side is the number of days between 
	 * 12/31/1849 and the appropriation date.
	 */
	private double adminNumber;
	
	
	/*
	 * The date that water was first put to a specific beneficial use or the date that an open, 
	 * overt act was taken at the intended point of diversion to demonstrate an intent to apply 
	 * water for beneficial use.
	 */
	private LocalDateTime appropriationDate;
	
	/*
	 * Water court case number(s) associated with water right
	 */
	private String associatedCaseNumbers;
	
	/*
	 * Comments
	 */
	private String comments;
	
	/*
	 * Distance and direction from East/West section line (feet)
	 */
	private int coordinatesEw;
	
	/*
	 * Direction of measurement from East/West section line
	 */
	private String coordiantesEwDir;

	/*
	 * Distance and direction from North/South section line (feet)
	 */
	private int coordinatesNs;
	
	/*
	 * Direction of measurement from North/South section line
	 */
	private String coordinatesNsDir;
	
	/*
	 * County where the well is located
	 */
	private String county;
	
	/*
	 * Decree Units (either CFS or AF)
	 */
	private String decreedUnits;
	
	/*
	 * Beneficial uses of water right: • 0 - STORAGE • 1 - IRRIGATION • 2 - MUNICIPAL • 3 - COMMERCIAL 
	 * • 4- INDUSTRIAL • 5 - RECREATION • 6 - FISHERY • 7 - FIRE • 8 - DOMESTIC • 9 - STOCK 
	 * • A - AUGMENTATION • B - EXPORT FROM BASIN • C - CUMULATIVE ACCRETION TO RIVER 
	 * • D - CUMULATIVE DEPLETION FROM RIVER • E - EVAPORATIVE • F - FEDERAL RESERVED 
	 * • G - GEOTHERMAL • H - HOUSEHOLD USE ONLY • K - SNOW MAKING • M - MINIMUM STREAMFLOW 
	 * • N - NET EFFECT ON RIVER • P - POWER GENERATION • Q - OTHER • R - RECHARGE • S - EXPORT FROM STATE 
	 * • T - TRANSMOUNTAIN EXPORT • W - WILDLIFE • X - ALL BENEFICIAL USES
	 */
	private String decreedUses;
	
	/*
	 * DWR Water Division
	 */
	private int division;
	
	/*
	 * National Hydrographic Dataset stream identifier
	 */
	private String gnisId;
	
	/*
	 * Last date time that this record was modified in the DWR database
	 */
	private LocalDateTime lastModified;
	
	/*
	 * Latitude value in decimal degrees
	 */
	private double latitiude;
	
	/*
	 * Accuracy of location coordinates
	 */
	private String locationAccuracy;
	
	/*
	 * Longitude (decimal degrees)
	 */
	private double longitude;
	
	/*
	 * Hyperlink to additional details
	 */
	private String moreInformation;
	
	/*
	 * Summation of absolute water right flow/volumetric transactions
	 */
	private double netAbsolute;
	
	/*
	 * Summation of absolute water right alternate point / exchange flow/volumetric transactions.
	 */
	private double netApexAbsolute;
	
	/*
	 * Summation of conditional water right alternate point / exchange flow/volumetric transactions.
	 */
	private double netApexConditional;
	
	/*
	 * Summation of conditional water right flow/volumetric transactions
	 */
	private double netConditional;
	
	/*
	 * Used to distinguish the priority of multiple water rights with identical dates
	 */
	private int orderNumber;
	
	/*
	 * Well permit number
	 */
	private String permit;
	
	/*
	 * Principal Meridian of well’s legal location - there are 5 principal meridians in CO: Sixth (S), 
	 * New Mexico (N), Baca (B), Costilla (C), and Ute (U)
	 */
	private String pm;
	
	/*
	 * The previous adjudication date field allows water rights to be ordered by priority with all rights 
	 * awarded subsequent to a previous adjudication being junior
	 */
	private LocalDateTime priorAdjudicationDate;
	
	/*
	 * An early District Courty's method to indicate a water right's seniority in water drainage
	 */
	private String priorityNumber;
	
	/*
	 * Legal location: 10 acre quarter section
	 */
	private String q10;
	
	/*
	 * Legal location: 160 acre quarter section
	 */
	private String q160;
	
	/*
	 * Legal Location: 40 acre quarter section
	 */
	private String q40;
	
	/*
	 * Legal location: A number in the format “nnnd” where “nnn” is the range number and “d” is the direction 
	 * either East or West
	 */
	private String range;
	
	/*
	 * Flag indicating that the water right has decreed amounts that vary by date
	 */
	private String seasonalLimitation;
	
	/*
	 * Section number - township, range divided into 36 one square mile sections; “U” indicates location in 
	 * Ute Correction (Division 7 only)
	 */
	private String section;
	
	/*
	 * Distance in miles to the confluence with the next downstream water source (or distance to state line)
	 */
	private double streamMile;
	
	/*
	 * Name of Structure
	 */
	private String structureName;
	
	/*
	 * Type of Structure
	 */
	private String structureType;
	
	/*
	 * Legal location: Township number and direction
	 */
	private String township;
	
	/*
	 * The x (Easting) component of the Universal Transverse Mercator system. (Zone 12, NAD83 datum)
	 */
	private double utmX;
	
	/*
	 * The y (Northing) component of the Universal Transverse Mercator system. (Zone 12, NAD83 datum)
	 */
	private double utmY;
	
	/*
	 * DWR Water District
	 */
	private int waterDistrict;
	
	/*
	 * NA
	 */
	private int waterRightNetAmtNum;
	
	/*
	 * Name of the water source as specified in the court case
	 */
	private String waterSource;
	
	/*
	 * DWR unique structure identifier
	 */
	private String wdid;

	public LocalDateTime getAdjudicationDate() {
		return adjudicationDate;
	}

	public void setAdjudicationDate(String adjudicationDate) {
		int len = adjudicationDate.length();
		int lastHyphen = adjudicationDate.lastIndexOf('-');
		adjudicationDate = adjudicationDate.substring(0, lastHyphen);
		this.adjudicationDate = (adjudicationDate == null) ? null :  LocalDateTime.parse(adjudicationDate);
	}

	public double getAdminNumber() {
		return adminNumber;
	}

	public void setAdminNumber(double adminNumber) {
		this.adminNumber = adminNumber;
	}

	public LocalDateTime getAppropriationDate() {
		return appropriationDate;
	}

	public void setAppropriationDate(String appropriationDate) {
		int len = appropriationDate.length();
		int lastHyphen = appropriationDate.lastIndexOf('-');
		appropriationDate = appropriationDate.substring(0, lastHyphen);
		this.appropriationDate = (appropriationDate == null) ? null : LocalDateTime.parse(appropriationDate);
	}

	public String getAssociatedCaseNumbers() {
		return associatedCaseNumbers;
	}

	public void setAssociatedCaseNumbers(String associatedCaseNumbers) {
		this.associatedCaseNumbers = associatedCaseNumbers;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getCoordinatesEw() {
		return coordinatesEw;
	}

	public void setCoordinatesEw(int coordinatesEw) {
		this.coordinatesEw = coordinatesEw;
	}

	public String getCoordiantesEwDir() {
		return coordiantesEwDir;
	}

	public void setCoordiantesEwDir(String coordiantesEwDir) {
		this.coordiantesEwDir = coordiantesEwDir;
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

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getDecreedUnits() {
		return decreedUnits;
	}

	public void setDecreedUnits(String decreedUnits) {
		this.decreedUnits = decreedUnits;
	}

	public String getDecreedUses() {
		return decreedUses;
	}

	public void setDecreedUses(String decreedUses) {
		this.decreedUses = decreedUses;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public String getGnisId() {
		return gnisId;
	}

	public void setGnisId(String gnisId) {
		this.gnisId = gnisId;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		int len = lastModified.length();
		int lastHyphen = lastModified.lastIndexOf('-');
		lastModified = lastModified.substring(0, lastHyphen);
		this.lastModified = (lastModified == null) ? null : LocalDateTime.parse(lastModified);
	}

	public double getLatitiude() {
		return latitiude;
	}

	public void setLatitiude(double latitiude) {
		this.latitiude = latitiude;
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

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public double getNetAbsolute() {
		return netAbsolute;
	}

	public void setNetAbsolute(double netAbsolute) {
		this.netAbsolute = netAbsolute;
	}

	public double getNetApexAbsolute() {
		return netApexAbsolute;
	}

	public void setNetApexAbsolute(double netApexAbsolute) {
		this.netApexAbsolute = netApexAbsolute;
	}

	public double getNetApexConditional() {
		return netApexConditional;
	}

	public void setNetApexConditional(double netApexConditional) {
		this.netApexConditional = netApexConditional;
	}

	public double getNetConditional() {
		return netConditional;
	}

	public void setNetConditional(double netConditional) {
		this.netConditional = netConditional;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public LocalDateTime getPriorAdjudicationDate() {
		return priorAdjudicationDate;
	}

	public void setPriorAdjudicationDate(String priorAdjudicationDate) {
		int len = priorAdjudicationDate.length();
		int lastHyphen = priorAdjudicationDate.lastIndexOf('-');
		priorAdjudicationDate = priorAdjudicationDate.substring(0, lastHyphen);
		this.priorAdjudicationDate = (priorAdjudicationDate == null) ? null : LocalDateTime.parse(priorAdjudicationDate);
	}

	public String getPriorityNumber() {
		return priorityNumber;
	}

	public void setPriorityNumber(String priorityNumber) {
		this.priorityNumber = priorityNumber;
	}

	public String getQ10() {
		return q10;
	}

	public void setQ10(String q10) {
		this.q10 = q10;
	}

	public String getQ160() {
		return q160;
	}

	public void setQ160(String q160) {
		this.q160 = q160;
	}

	public String getQ40() {
		return q40;
	}

	public void setQ40(String q40) {
		this.q40 = q40;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getSeasonalLimitation() {
		return seasonalLimitation;
	}

	public void setSeasonalLimitation(String seasonalLimitation) {
		this.seasonalLimitation = seasonalLimitation;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public double getStreamMile() {
		return streamMile;
	}

	public void setStreamMile(double streamMile) {
		this.streamMile = streamMile;
	}

	public String getStructureName() {
		return structureName;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}

	public String getStructureType() {
		return structureType;
	}

	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
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

	public int getWaterRightNetAmtNum() {
		return waterRightNetAmtNum;
	}

	public void setWaterRightNetAmtNum(int waterRightNetAmtNum) {
		this.waterRightNetAmtNum = waterRightNetAmtNum;
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
}
