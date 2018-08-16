package cdss.dmi.hydrobase.rest.dao;

import RTi.Util.Time.DateTime;

public class AdministrativeCalls {
	
	private double boundingStructureLatitude;
	private double boundingStructureLongitude;
	private String boundingStructureName;
	private String boundingWdid;
	private int callNumber;
	private String callType;
	private DateTime dateTimeReleased;
	private DateTime dateTimeSet;
	private int division;
	private double locationStructureLatitude;
	private double locationStructureLongitude;
	private String locationStructureName;
	private String locationWdid;
	private double locationWdidStreammile;
	private DateTime modified;
	private String moreInformation;
	private double priorityAdminNumber;
	private DateTime priorityDate;
	private String priorityNumber;
	private int priorityOrderNumber;
	private String priorityStructureName;
	private String priorityWdid;
	private String releaseComment;
	private String setComments;
	private String waterSourceName;
	
	public double getBoundingStructureLatitude() {
		return boundingStructureLatitude;
	}
	public void setBoundingStructureLatitude(double boundingStructureLatitude) {
		this.boundingStructureLatitude = boundingStructureLatitude;
	}
	public double getBoundingStructureLongitude() {
		return boundingStructureLongitude;
	}
	public void setBoundingStructureLongitude(double boundingStructureLongitude) {
		this.boundingStructureLongitude = boundingStructureLongitude;
	}
	public String getBoundingStructureName() {
		return boundingStructureName;
	}
	public void setBoundingStructureName(String boundingStructureName) {
		this.boundingStructureName = boundingStructureName;
	}
	public String getBoundingWdid() {
		return boundingWdid;
	}
	public void setBoundingWdid(String boundingWdid) {
		this.boundingWdid = boundingWdid;
	}
	public int getCallNumber() {
		return callNumber;
	}
	public void setCallNumber(int callNumber) {
		this.callNumber = callNumber;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public DateTime getDateTimeReleased() {
		return dateTimeReleased;
	}
	public void setDateTimeReleased(String dateTimeReleased) {
		if(dateTimeReleased != null){
			int indexLastHyphen = dateTimeReleased.lastIndexOf('-');
			dateTimeReleased = dateTimeReleased.substring(0, indexLastHyphen);
			this.dateTimeReleased = DateTime.parse(dateTimeReleased);
		}else{
			this.dateTimeReleased = null;
		}
	}
	public DateTime getDateTimeSet() {
		return dateTimeSet;
	}
	public void setDateTimeSet(String dateTimeSet) {
		if(dateTimeSet != null){
			int indexLastHyphen = dateTimeSet.lastIndexOf('-');
			dateTimeSet = dateTimeSet.substring(0, indexLastHyphen);
			this.dateTimeSet = DateTime.parse(dateTimeSet);
		}else{
			this.dateTimeSet = null;
		}
	}
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	public double getLocationStructureLatitude() {
		return locationStructureLatitude;
	}
	public void setLocationStructureLatitude(double locationStructureLatitude) {
		this.locationStructureLatitude = locationStructureLatitude;
	}
	public double getLocationStructureLongitude() {
		return locationStructureLongitude;
	}
	public void setLocationStructureLongitude(double locationStructureLongitude) {
		this.locationStructureLongitude = locationStructureLongitude;
	}
	public String getLocationStructureName() {
		return locationStructureName;
	}
	public void setLocationStructureName(String locationStructureName) {
		this.locationStructureName = locationStructureName;
	}
	public String getLocationWdid() {
		return locationWdid;
	}
	public void setLocationWdid(String locationWdid) {
		this.locationWdid = locationWdid;
	}
	public double getLocationWdidStreammile() {
		return locationWdidStreammile;
	}
	public void setLocationWdidStreammile(double locationWdidStreammile) {
		this.locationWdidStreammile = locationWdidStreammile;
	}
	public DateTime getModified() {
		return modified;
	}
	public void setModified(String modified) {
		if(modified != null){
			int indexLastHyphen = modified.lastIndexOf('-');
			modified = modified.substring(0, indexLastHyphen);
			this.modified = DateTime.parse(modified);
		}else{
			this.modified = null;
		}
	}
	public String getMoreInformation() {
		return moreInformation;
	}
	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}
	public double getPriorityAdminNumber() {
		return priorityAdminNumber;
	}
	public void setPriorityAdminNumber(double priorityAdminNumber) {
		this.priorityAdminNumber = priorityAdminNumber;
	}
	public DateTime getPriorityDate() {
		return priorityDate;
	}
	public void setPriorityDate(String priorityDate) {
		if(priorityDate != null){
			int indexLastHyphen = priorityDate.lastIndexOf('-');
			priorityDate = priorityDate.substring(0, indexLastHyphen);
			this.priorityDate = DateTime.parse(priorityDate);
		}else{
			this.priorityDate = null;
		}
	}
	public String getPriorityNumber() {
		return priorityNumber;
	}
	public void setPriorityNumber(String priorityNumber) {
		this.priorityNumber = priorityNumber;
	}
	public int getPriorityOrderNumber() {
		return priorityOrderNumber;
	}
	public void setPriorityOrderNumber(int priorityOrderNumber) {
		this.priorityOrderNumber = priorityOrderNumber;
	}
	public String getPriorityStructureName() {
		return priorityStructureName;
	}
	public void setPriorityStructureName(String priorityStructureName) {
		this.priorityStructureName = priorityStructureName;
	}
	public String getPriorityWdid() {
		return priorityWdid;
	}
	public void setPriorityWdid(String priorityWdid) {
		this.priorityWdid = priorityWdid;
	}
	public String getReleaseComment() {
		return releaseComment;
	}
	public void setReleaseComment(String releaseComment) {
		this.releaseComment = releaseComment;
	}
	public String getSetComments() {
		return setComments;
	}
	public void setSetComments(String setComments) {
		this.setComments = setComments;
	}
	public String getWaterSourceName() {
		return waterSourceName;
	}
	public void setWaterSourceName(String waterSourceName) {
		this.waterSourceName = waterSourceName;
	}
	
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
				", modified: " + modified + ", moreInformation: " + moreInformation + " ]";
	}

}
