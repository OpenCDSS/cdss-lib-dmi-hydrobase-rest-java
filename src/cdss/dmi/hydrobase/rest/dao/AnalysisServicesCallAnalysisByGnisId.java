package cdss.dmi.hydrobase.rest.dao;

import RTi.Util.Time.DateTime;

public class AnalysisServicesCallAnalysisByGnisId {
	
	private DateTime analysisDate;
	private String analysisGnisId;
	private double analysisOutOfPriorityPercentOfDay;
	private double analysisStreamMile;
	private String analysisWaterSourceName;
	private double analysisWrAdminNo;
	private String boundingStructureName;
	private String boundingWdid;
	private String callType;
	private DateTime dateTimeReleased;
	private DateTime dateTimeSet;
	private int division;
	private String locationStructure;
	private String locationWdid;
	private double locationWdidStreamMile;
	private double priorityAdminNo;
	private DateTime priorityDate;
	private String priorityNo;
	private int priorityOrderNo;
	private String priorityStructure;
	private String priorityWdid;
	private String releaseComment;
	private String setComments;
	private String waterSourceName;
	
	public DateTime getAnalysisDate() {
		return analysisDate;
	}
	public void setAnalysisDate(String analysisDate) {
		if(analysisDate != null){
			int indexLastHyphen = analysisDate.lastIndexOf('-');
			analysisDate = analysisDate.substring(0, indexLastHyphen);
			this.analysisDate = DateTime.parse(analysisDate);
		}else{
			this.analysisDate = null;
		}
	}
	public String getAnalysisGnisId() {
		return analysisGnisId;
	}
	public void setAnalysisGnisId(String analysisGnisId) {
		this.analysisGnisId = analysisGnisId;
	}
	public double getAnalysisOutOfPriorityPercentOfDay() {
		return analysisOutOfPriorityPercentOfDay;
	}
	public void setAnalysisOutOfPriorityPercentOfDay(double analysisOutOfPriorityPercentOfDay) {
		this.analysisOutOfPriorityPercentOfDay = analysisOutOfPriorityPercentOfDay;
	}
	public double getAnalysisStreamMile() {
		return analysisStreamMile;
	}
	public void setAnalysisStreamMile(double analysisStreamMile) {
		this.analysisStreamMile = analysisStreamMile;
	}
	public String getAnalysisWaterSourceName() {
		return analysisWaterSourceName;
	}
	public void setAnalysisWaterSourceName(String analysisWaterSourceName) {
		this.analysisWaterSourceName = analysisWaterSourceName;
	}
	public double getAnalysisWrAdminNo() {
		return analysisWrAdminNo;
	}
	public void setAnalysisWrAdminNo(double analysisWrAdminNo) {
		this.analysisWrAdminNo = analysisWrAdminNo;
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
	public String getLocationStructure() {
		return locationStructure;
	}
	public void setLocationStructure(String locationStructure) {
		this.locationStructure = locationStructure;
	}
	public String getLocationWdid() {
		return locationWdid;
	}
	public void setLocationWdid(String locationWdid) {
		this.locationWdid = locationWdid;
	}
	public double getLocationWdidStreamMile() {
		return locationWdidStreamMile;
	}
	public void setLocationWdidStreamMile(double locationWdidStreamMile) {
		this.locationWdidStreamMile = locationWdidStreamMile;
	}
	public double getPriorityAdminNo() {
		return priorityAdminNo;
	}
	public void setPriorityAdminNo(double priorityAdminNo) {
		this.priorityAdminNo = priorityAdminNo;
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
	public String getPriorityNo() {
		return priorityNo;
	}
	public void setPriorityNo(String priorityNo) {
		this.priorityNo = priorityNo;
	}
	public int getPriorityOrderNo() {
		return priorityOrderNo;
	}
	public void setPriorityOrderNo(int priorityOrderNo) {
		this.priorityOrderNo = priorityOrderNo;
	}
	public String getPriorityStructure() {
		return priorityStructure;
	}
	public void setPriorityStructure(String priorityStructure) {
		this.priorityStructure = priorityStructure;
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
		return "AnalysisServicesCallAnalysisByGnisId: [ analysisDate: " + analysisDate + ", analysisGnisId: " + analysisGnisId + 
				", analysisWaterSourceName: " + analysisWaterSourceName + ", analysisStreamMile: " + analysisStreamMile + 
				", analysisWrAdminNo: " + analysisWrAdminNo + ", division: " + division + ", callType: " + callType + ", dateTimeSet: " +
				dateTimeSet + ", dateTimeReleased: " + dateTimeReleased + ", waterSourceName: " + waterSourceName + ", locationWdid" + 
				locationWdid + ", locationStructure: " + locationStructure + ", locationWdidStreamMile: " + locationWdidStreamMile + 
				", priorityWdid: " + priorityWdid + ", priorityStructure: " + priorityStructure + ", priorityAdminNo: " + priorityAdminNo + 
				", priorityOrderNo: " + priorityOrderNo + ", priorityDate: " + priorityDate + ", priorityNo: " + priorityNo + 
				", boundingWdid: " + boundingWdid + ", boundingStructureName: " + boundingStructureName + ", setComments: " + 
				", releaseComment: " + releaseComment + ", analysisOutOfPriorityPercentOfDay: " + analysisOutOfPriorityPercentOfDay + " ]";
	}

}
