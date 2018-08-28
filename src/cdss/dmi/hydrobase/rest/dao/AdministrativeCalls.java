package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-administrativecalls-active
 * @author jurentie
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdministrativeCalls {
	
	/**
	 * Variables defined in alphabetical order. 
	 * Documentation copied from web services.
	 */
	
	/**
	 * Latitude (decimal degrees) of bounding structure
	 */
	private double boundingStructureLatitude;
	
	/**
	 * Longitude (decimal degrees) of bounding structure
	 */
	private double boundingStructureLongitude;
	
	/**
	 * Structure Name of upper terminus of Call; if blank, the call extends 
	 * to the headwaters of the basin
	 */
	private String boundingStructureName;
	
	/**
	 * WDID of upper terminus of Call; if blank, the call extends to the 
	 * headwaters of the basin
	 */
	private String boundingWdid;
	
	/**
	 * Unique call identifier
	 */
	private int callNumber;
	
	/**
	 * The type of administration being described: Call, Futile Call, 
	 * Nonconsumptive Call, or Authorized Diversion
	 */
	private String callType;
	
	/**
	 * Date and time that Administrative Call all was released
	 */
	private DateTime dateTimeReleased;
	
	/**
	 * Date and time that Administrative Call all was set
	 */
	private DateTime dateTimeSet;
	
	/**
	 * DWR Water Division
	 */
	private int division;
	
	/**
	 * Latitude (decimal degrees) of calling structure
	 */
	private double locationStructureLatitude;
	
	/**
	 * Longitude (decimal degrees) of calling structure
	 */
	private double locationStructureLongitude;
	
	/**
	 * Call location structure name
	 */
	private String locationStructureName;
	
	/**
	 * Call location structure WDID
	 */
	private String locationWdid;
	
	/**
	 * Call location structure stream mile
	 */
	private double locationWdidStreammile;
	
	/**
	 * Last date time that this record was modified in the DWR database
	 */
	private DateTime modified;
	
	/**
	 * Hyperlink to additional details
	 */
	private String moreInformation;
	
	/**
	 * A calculated number developed by DWR to rank water rights in 
	 * order of seniority.
	 */
	private double priorityAdminNumber;
	
	/**
	 * Either the appropriation date or the previous adjudication date, 
	 * whichever is earlier
	 */
	private DateTime priorityDate;
	
	/**
	 * An early District Court’s method to indicate a water right’s seniority 
	 * in a water drainage
	 */
	private String priorityNumber;
	
	/**
	 * An order number may be assigned to distinguish decrees with identical dates 
	 * but have been decreed to have specifically different priorities.
	 */
	private int priorityOrderNumber;
	
	/**
	 * Waterright Structure...definition
	 */
	private String priorityStructureName;
	
	/**
	 * Priority WDID
	 */
	private String priorityWdid;
	
	/**
	 * Comments related to the release of the call
	 */
	private String releaseComment;
	
	/**
	 * Comments related to setting the Administrative Call
	 */
	private String setComments;
	
	/**
	 * Name of water source
	 */
	private String waterSourceName;
	
	/**
	 * Getters and setters for defined variables
	 */
	
	public double getBoundingStructureLatitude() {
		return boundingStructureLatitude;
	}
	public double getBoundingStructureLongitude() {
		return boundingStructureLongitude;
	}
	
	public String getBoundingStructureName() {
		return boundingStructureName;
	}
	public String getBoundingWdid() {
		return boundingWdid;
	}
	
	public int getCallNumber() {
		return callNumber;
	}
	public String getCallType() {
		return callType;
	}
	
	public DateTime getDateTimeReleased() {
		return dateTimeReleased;
	}
	public DateTime getDateTimeSet() {
		return dateTimeSet;
	}
	
	public int getDivision() {
		return division;
	}
	public double getLocationStructureLatitude() {
		return locationStructureLatitude;
	}
	
	public double getLocationStructureLongitude() {
		return locationStructureLongitude;
	}
	public String getLocationStructureName() {
		return locationStructureName;
	}
	
	public String getLocationWdid() {
		return locationWdid;
	}
	public double getLocationWdidStreammile() {
		return locationWdidStreammile;
	}
	
	public DateTime getModified() {
		return modified;
	}
	public String getMoreInformation() {
		return moreInformation;
	}
	
	public double getPriorityAdminNumber() {
		return priorityAdminNumber;
	}
	public DateTime getPriorityDate() {
		return priorityDate;
	}
	
	public String getPriorityNumber() {
		return priorityNumber;
	}
	public int getPriorityOrderNumber() {
		return priorityOrderNumber;
	}
	
	public String getPriorityStructureName() {
		return priorityStructureName;
	}
	public String getPriorityWdid() {
		return priorityWdid;
	}
	
	public String getReleaseComment() {
		return releaseComment;
	}
	public String getSetComments() {
		return setComments;
	}
	
	public String getWaterSourceName() {
		return waterSourceName;
	}
	public void setBoundingStructureLatitude(double boundingStructureLatitude) {
		this.boundingStructureLatitude = boundingStructureLatitude;
	}
	
	public void setBoundingStructureLongitude(double boundingStructureLongitude) {
		this.boundingStructureLongitude = boundingStructureLongitude;
	}
	public void setBoundingStructureName(String boundingStructureName) {
		this.boundingStructureName = boundingStructureName;
	}
	
	public void setBoundingWdid(String boundingWdid) {
		this.boundingWdid = boundingWdid;
	}
	public void setCallNumber(int callNumber) {
		this.callNumber = callNumber;
	}
	
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public void setDateTimeReleased(String dateTimeReleased) {
		this.dateTimeReleased = TimeToolkit.getInstance().toDateTime(dateTimeReleased, true);
	}
	
	public void setDateTimeSet(String dateTimeSet) {
		this.dateTimeSet = TimeToolkit.getInstance().toDateTime(dateTimeSet, true);
	}
	public void setDivision(int division) {
		this.division = division;
	}
	
	public void setLocationStructureLatitude(double locationStructureLatitude) {
		this.locationStructureLatitude = locationStructureLatitude;
	}
	public void setLocationStructureLongitude(double locationStructureLongitude) {
		this.locationStructureLongitude = locationStructureLongitude;
	}
	
	public void setLocationStructureName(String locationStructureName) {
		this.locationStructureName = locationStructureName;
	}
	public void setLocationWdid(String locationWdid) {
		this.locationWdid = locationWdid;
	}
	
	public void setLocationWdidStreammile(double locationWdidStreammile) {
		this.locationWdidStreammile = locationWdidStreammile;
	}
	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, true);
	}
	
	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}
	public void setPriorityAdminNumber(double priorityAdminNumber) {
		this.priorityAdminNumber = priorityAdminNumber;
	}
	
	public void setPriorityDate(String priorityDate) {
		this.priorityDate = TimeToolkit.getInstance().toDateTime(priorityDate, true);
	}
	public void setPriorityNumber(String priorityNumber) {
		this.priorityNumber = priorityNumber;
	}
	
	public void setPriorityOrderNumber(int priorityOrderNumber) {
		this.priorityOrderNumber = priorityOrderNumber;
	}
	public void setPriorityStructureName(String priorityStructureName) {
		this.priorityStructureName = priorityStructureName;
	}
	
	public void setPriorityWdid(String priorityWdid) {
		this.priorityWdid = priorityWdid;
	}
	public void setReleaseComment(String releaseComment) {
		this.releaseComment = releaseComment;
	}
	
	public void setSetComments(String setComments) {
		this.setComments = setComments;
	}
	public void setWaterSourceName(String waterSourceName) {
		this.waterSourceName = waterSourceName;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "AdministrativeCallsActive: [ callNumber: " + callNumber + ", callType: " + callType + ", dateTimeSet: " + dateTimeSet + 
				", dateTimeReleased: " + dateTimeReleased + ", waterSourceName: " + waterSourceName + ", locationWdid: " +
				locationWdid + ", locationWdidStreammile: " + locationWdidStreammile + ", locationStructureName: " + 
				locationStructureName + ", priorityWdid: " + priorityWdid + ", priorityStructureName: " + priorityStructureName + 
				", priorityAdminNumber: " + priorityAdminNumber + ", priorityOrderNumber: " + priorityOrderNumber + ", priorityDate: " + 
				priorityDate + ", priorityNumber: " + priorityNumber + ", boundingWdid: " + boundingWdid + ", boundingStructureName: " + 
				", setComments: " + setComments + ", releaseComment: " + releaseComment + ", division: " + division + 
				", locationStructureLatitude: " + locationStructureLatitude + ", locationStructureLongitude: " + locationStructureLongitude +
				", boundingStructureLatitude: " + boundingStructureLatitude + ", boundingStructureLongitude: " + boundingStructureLongitude + 
				", modified: " + modified + ", moreInformation: " + moreInformation + " ]\n";
	}

}
