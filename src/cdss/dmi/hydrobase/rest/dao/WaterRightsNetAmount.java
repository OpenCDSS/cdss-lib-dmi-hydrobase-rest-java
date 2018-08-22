package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-waterrights-netamount
 * @author jurentie
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WaterRightsNetAmount {
	
	/**
	 * Variables defined in alphabetical order. 
	 * Documentation copied from web services.
	 */
	
	/**
	 * Adjudication date is the date that the water 
	 * right was awarded by the water court.
	 */
	private DateTime adjudicationDate;
	
	/**
	 * 	A calculated number developed by DWR to rank water rights in order of seniority. 
	 */
	private double adminNumber;
	
	
	/**
	 * The date that water was first put to a specific beneficial use or the date that an open, 
	 * overt act was taken at the intended point of diversion to demonstrate an intent to apply 
	 * water for beneficial use.
	 */
	private DateTime appropriationDate;
	
	/**
	 * Water court case number(s) associated with water right
	 */
	private String associatedCaseNumbers;
	
	/**
	 * Comments
	 */
	private String comments;
	
	/**
	 * Distance and direction from East/West section line (feet)
	 */
	private int coordinatesEw;
	
	/**
	 * Direction of measurement from East/West section line
	 */
	private String coordinatesEwDir;

	/**
	 * Distance and direction from North/South section line (feet)
	 */
	private int coordinatesNs;
	
	/**
	 * Direction of measurement from North/South section line
	 */
	private String coordinatesNsDir;
	
	/**
	 * County where the well is located
	 */
	private String county;
	
	/**
	 * Decree Units (either CFS or AF)
	 */
	private String decreedUnits;
	
	/**
	 * Beneficial uses of water right: • 0 - STORAGE • 1 - IRRIGATION • 2 - MUNICIPAL • 3 - COMMERCIAL 
	 * • 4- INDUSTRIAL • 5 - RECREATION • 6 - FISHERY • 7 - FIRE • 8 - DOMESTIC • 9 - STOCK 
	 * • A - AUGMENTATION • B - EXPORT FROM BASIN • C - CUMULATIVE ACCRETION TO RIVER 
	 * • D - CUMULATIVE DEPLETION FROM RIVER • E - EVAPORATIVE • F - FEDERAL RESERVED 
	 * • G - GEOTHERMAL • H - HOUSEHOLD USE ONLY • K - SNOW MAKING • M - MINIMUM STREAMFLOW 
	 * • N - NET EFFECT ON RIVER • P - POWER GENERATION • Q - OTHER • R - RECHARGE • S - EXPORT FROM STATE 
	 * • T - TRANSMOUNTAIN EXPORT • W - WILDLIFE • X - ALL BENEFICIAL USES
	 */
	private String decreedUses;
	
	/**
	 * DWR Water Division
	 */
	private int division;
	
	/**
	 * National Hydrographic Dataset stream identifier
	 */
	private String gnisId;
	
	/**
	 * Last date time that this record was modified in the DWR database
	 */
	private DateTime lastModified;
	
	/**
	 * Latitude value in decimal degrees
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
	 * Hyperlink to additional details
	 */
	private String moreInformation;
	
	/**
	 * Summation of absolute water right flow/volumetric transactions
	 */
	private double netAbsolute;
	
	/**
	 * Summation of absolute water right alternate point / exchange flow/volumetric transactions.
	 */
	private double netApexAbsolute;
	
	/**
	 * Summation of conditional water right alternate point / exchange flow/volumetric transactions.
	 */
	private double netApexConditional;
	
	/**
	 * Summation of conditional water right flow/volumetric transactions
	 */
	private double netConditional;
	
	/**
	 * Used to distinguish the priority of multiple water rights with identical dates
	 */
	private int orderNumber;
	
	/**
	 * Well permit number
	 */
	private String permit;
	
	/**
	 * Principal Meridian of well’s legal location - there are 5 principal meridians in CO: Sixth (S), 
	 * New Mexico (N), Baca (B), Costilla (C), and Ute (U)
	 */
	private String pm;
	
	/**
	 * The previous adjudication date field allows water rights to be ordered by priority with all rights 
	 * awarded subsequent to a previous adjudication being junior
	 */
	private DateTime priorAdjudicationDate;
	
	/**
	 * An early District Courty's method to indicate a water right's seniority in water drainage
	 */
	private String priorityNumber;
	
	/**
	 * Legal location: 10 acre quarter section
	 */
	private String q10;
	
	/**
	 * Legal location: 160 acre quarter section
	 */
	private String q160;
	
	/**
	 * Legal Location: 40 acre quarter section
	 */
	private String q40;
	
	/**
	 * Legal location: A number in the format “nnnd” where “nnn” is the range number and “d” is the direction 
	 * either East or West
	 */
	private String range;
	
	/**
	 * Flag indicating that the water right has decreed amounts that vary by date
	 */
	private String seasonalLimitation;
	
	/**
	 * Section number - township, range divided into 36 one square mile sections; “U” indicates location in 
	 * Ute Correction (Division 7 only)
	 */
	private String section;
	
	/**
	 * Distance in miles to the confluence with the next downstream water source (or distance to state line)
	 */
	private double streamMile;
	
	/**
	 * Name of Structure
	 */
	private String structureName;
	
	/**
	 * Type of Structure
	 */
	private String structureType;
	
	/**
	 * Legal location: Township number and direction
	 */
	private String township;
	
	/**
	 * The x (Easting) component of the Universal Transverse Mercator system. (Zone 12, NAD83 datum)
	 */
	private double utmX;
	
	/**
	 * The y (Northing) component of the Universal Transverse Mercator system. (Zone 12, NAD83 datum)
	 */
	private double utmY;
	
	/**
	 * DWR Water District
	 */
	private int waterDistrict;
	
	/**
	 * NA
	 */
	private int waterRightNetAmtNum;
	
	/**
	 * Name of the water source as specified in the court case
	 */
	private String waterSource;
	
	/**
	 * DWR unique structure identifier
	 */
	private String wdid;

	/**
	 * Getters and setters for defined variables
	 */
	public DateTime getAdjudicationDate() {
		return adjudicationDate;
	}

	public double getAdminNumber() {
		return adminNumber;
	}

	public DateTime getAppropriationDate() {
		return appropriationDate;
	}

	public String getAssociatedCaseNumbers() {
		return associatedCaseNumbers;
	}

	public String getComments() {
		return comments;
	}

	public String getCoordinatesEwDir() {
		return coordinatesEwDir;
	}

	public int getCoordinatesEw() {
		return coordinatesEw;
	}

	public int getCoordinatesNs() {
		return coordinatesNs;
	}

	public String getCoordinatesNsDir() {
		return coordinatesNsDir;
	}

	public String getCounty() {
		return county;
	}

	public String getDecreedUnits() {
		return decreedUnits;
	}

	public String getDecreedUses() {
		return decreedUses;
	}

	public int getDivision() {
		return division;
	}

	public String getGnisId() {
		return gnisId;
	}

	public DateTime getLastModified() {
		return lastModified;
	}

	public double getLatitude() {
		return latitude;
	}

	public String getLocationAccuracy() {
		return locationAccuracy;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public double getNetAbsolute() {
		return netAbsolute;
	}

	public double getNetApexAbsolute() {
		return netApexAbsolute;
	}

	public double getNetApexConditional() {
		return netApexConditional;
	}

	public double getNetConditional() {
		return netConditional;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public String getPermit() {
		return permit;
	}

	public String getPm() {
		return pm;
	}

	public DateTime getPriorAdjudicationDate() {
		return priorAdjudicationDate;
	}

	public String getPriorityNumber() {
		return priorityNumber;
	}

	public String getQ10() {
		return q10;
	}

	public String getQ160() {
		return q160;
	}

	public String getQ40() {
		return q40;
	}

	public String getRange() {
		return range;
	}

	public String getSeasonalLimitation() {
		return seasonalLimitation;
	}

	public String getSection() {
		return section;
	}

	public double getStreamMile() {
		return streamMile;
	}

	public String getStructureName() {
		return structureName;
	}

	public String getStructureType() {
		return structureType;
	}

	public String getTownship() {
		return township;
	}

	public double getUtmX() {
		return utmX;
	}

	public double getUtmY() {
		return utmY;
	}

	public int getWaterDistrict() {
		return waterDistrict;
	}

	public int getWaterRightNetAmtNum() {
		return waterRightNetAmtNum;
	}

	public String getWaterSource() {
		return waterSource;
	}

	public String getWdid() {
		return wdid;
	}

	public void setAdjudicationDate(String adjudicationDate) {
		this.adjudicationDate = TimeToolkit.getInstance().toDateTime(adjudicationDate, true);
	}

	public void setAdminNumber(double adminNumber) {
		this.adminNumber = adminNumber;
	}

	public void setAppropriationDate(String appropriationDate) {
		this.appropriationDate = TimeToolkit.getInstance().toDateTime(appropriationDate, true);
	}

	public void setAssociatedCaseNumbers(String associatedCaseNumbers) {
		this.associatedCaseNumbers = associatedCaseNumbers;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setCoordinatesEwDir(String coordiantesEwDir) {
		this.coordinatesEwDir = coordiantesEwDir;
	}

	public void setCoordinatesEw(int coordinatesEw) {
		this.coordinatesEw = coordinatesEw;
	}

	public void setCoordinatesNs(int coordinatesNs) {
		this.coordinatesNs = coordinatesNs;
	}

	public void setCoordinatesNsDir(String coordinatesNsDir) {
		this.coordinatesNsDir = coordinatesNsDir;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public void setDecreedUnits(String decreedUnits) {
		this.decreedUnits = decreedUnits;
	}

	public void setDecreedUses(String decreedUses) {
		this.decreedUses = decreedUses;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public void setGnisId(String gnisId) {
		this.gnisId = gnisId;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = TimeToolkit.getInstance().toDateTime(lastModified, true);
	}

	public void setLatitude(double latitiude) {
		this.latitude = latitiude;
	}

	public void setLocationAccuracy(String locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public void setNetAbsolute(double netAbsolute) {
		this.netAbsolute = netAbsolute;
	}

	public void setNetApexAbsolute(double netApexAbsolute) {
		this.netApexAbsolute = netApexAbsolute;
	}

	public void setNetApexConditional(double netApexConditional) {
		this.netApexConditional = netApexConditional;
	}

	public void setNetConditional(double netConditional) {
		this.netConditional = netConditional;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public void setPriorAdjudicationDate(String priorAdjudicationDate) {
		this.priorAdjudicationDate = TimeToolkit.getInstance().toDateTime(priorAdjudicationDate, true);
	}

	public void setPriorityNumber(String priorityNumber) {
		this.priorityNumber = priorityNumber;
	}

	public void setQ10(String q10) {
		this.q10 = q10;
	}

	public void setQ160(String q160) {
		this.q160 = q160;
	}

	public void setQ40(String q40) {
		this.q40 = q40;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public void setSeasonalLimitation(String seasonalLimitation) {
		this.seasonalLimitation = seasonalLimitation;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public void setStreamMile(double streamMile) {
		this.streamMile = streamMile;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}

	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public void setUtmX(double utmX) {
		this.utmX = utmX;
	}

	public void setUtmY(double utmY) {
		this.utmY = utmY;
	}

	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}

	public void setWaterRightNetAmtNum(int waterRightNetAmtNum) {
		this.waterRightNetAmtNum = waterRightNetAmtNum;
	}

	public void setWaterSource(String waterSource) {
		this.waterSource = waterSource;
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
	public String toString() {
		return "WaterRightsNetAmount: [ waterRightsNetAmtNum: " + waterRightNetAmtNum + ", wdid: " + wdid + 
				", structureName: " + structureName + ", structureType: " + structureType + ", waterSource: " +
				waterSource + ", gnisId: " + gnisId + ", streamMile: " + streamMile + ", division: " + division + 
				", waterDistrict: " + waterDistrict + ", county: " + county + ", q10: " + q10 + ", q40: " + q40 + 
				", q160: " + q160 + ", section: " + section + ", township: " + township + ", range: " + range + 
				", pm: " + pm + ", coordinatesEw: " + coordinatesEw + ", coordinatesEwDir: " + coordinatesEwDir + 
				", coordinatesNs: " + coordinatesNs + ", coordinatesNsDir: " + coordinatesNsDir + ", utmX: " + utmX +
				", utmY: " + utmY + ", latitude: " + latitude + ", longitude: " + longitude + ", locationAccuracy: " +
				locationAccuracy + ", adjudicationDate: " + adjudicationDate + ", priorAdjudicationDate: " + 
				priorAdjudicationDate + ", appropriationDate: " + appropriationDate + ", adminNumber: " + adminNumber + 
				", orderNumber: " + orderNumber + ", priorityNumber: " + priorityNumber + ", associatedCaseNumbers" +
				associatedCaseNumbers + ", decreedUses: " + decreedUses + ", netAbsolute: " + netAbsolute + 
				", netConditional: " + netConditional + ", netApexAbsolute: " + netApexAbsolute + ", decreedUnits: " +
				decreedUnits + ", seasonalLimitation: " + seasonalLimitation + ", comments: " + comments + 
				", lastModified: " + ", permit: " + permit + ", moreInformation: " + moreInformation + " ]";
	}
}
