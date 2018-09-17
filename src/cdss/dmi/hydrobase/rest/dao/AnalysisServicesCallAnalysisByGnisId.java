package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-analysisservices-callanalysisbygnisid
 * @author jurentie
 *
 */
/* Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisServicesCallAnalysisByGnisId {
	
	/**
	 * Variables defined in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Analysis Date
	 */
	private DateTime analysisDate;
	
	/**
	 * Analysis GNIS ID
	 */
	private String analysisGnisId;
	
	/**
	 * Analysis Out Of Priority Percent Of Day
	 */
	private double analysisOutOfPriorityPercentOfDay;
	
	/**
	 * Analysis Stream Mile
	 */
	private double analysisStreamMile;
	
	/**
	 * Analysis Water Source Name
	 */
	private String analysisWaterSourceName;
	
	/**
	 * Analysis Water Right Administration Number
	 */
	private double analysisWrAdminNo;
	
	/**
	 * Bounding Structure Name
	 */
	private String boundingStructureName;
	
	/**
	 * Bounding WDID
	 */
	private String boundingWdid;
	
	/**
	 * Call Type
	 */
	private String callType;
	
	/**
	 * Date Time Released
	 */
	private DateTime dateTimeReleased;
	
	/**
	 * Date Time Set
	 */
	private DateTime dateTimeSet;
	
	/**
	 * DWR Water Divsion
	 */
	private int division;
	
	/**
	 * Location Structure
	 */
	private String locationStructure;
	
	/**
	 * Location Wdid
	 */
	private String locationWdid;
	
	/**
	 * Location Wdid Stream Mile
	 */
	private double locationWdidStreamMile;
	
	/**
	 * Priority Administration Number
	 */
	private double priorityAdminNo;
	
	/**
	 * Priority Date
	 */
	private DateTime priorityDate;
	
	/**
	 * Priority Number
	 */
	private String priorityNo;
	
	/**
	 * Priority Order Number
	 */
	private int priorityOrderNo;
	
	/**
	 * Priority Structure
	 */
	private String priorityStructure;
	
	/**
	 * Priority WDID
	 */
	private String priorityWdid;
	
	/**
	 * Release Comment
	 */
	private String releaseComment;
	
	/**
	 * Set Comments
	 */
	private String setComments;
	
	/**
	 * Water Source Name
	 */
	private String waterSourceName;
	
	/**
	 * Getters and setters for defined variables
	 */
	
	public DateTime getAnalysisDate() {
		return analysisDate;
	}
	public String getAnalysisGnisId() {
		return analysisGnisId;
	}
	
	public double getAnalysisOutOfPriorityPercentOfDay() {
		return analysisOutOfPriorityPercentOfDay;
	}
	public double getAnalysisStreamMile() {
		return analysisStreamMile;
	}
	
	public String getAnalysisWaterSourceName() {
		return analysisWaterSourceName;
	}
	public double getAnalysisWrAdminNo() {
		return analysisWrAdminNo;
	}
	
	public String getBoundingStructureName() {
		return boundingStructureName;
	}
	public String getBoundingWdid() {
		return boundingWdid;
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
	
	public String getLocationStructure() {
		return locationStructure;
	}
	public String getLocationWdid() {
		return locationWdid;
	}
	
	public double getLocationWdidStreamMile() {
		return locationWdidStreamMile;
	}
	public double getPriorityAdminNo() {
		return priorityAdminNo;
	}
	
	public DateTime getPriorityDate() {
		return priorityDate;
	}
	public String getPriorityNo() {
		return priorityNo;
	}
	
	public int getPriorityOrderNo() {
		return priorityOrderNo;
	}
	public String getPriorityStructure() {
		return priorityStructure;
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
	
	public void setAnalysisDate(String analysisDate) {
		this.analysisDate = TimeToolkit.getInstance().toDateTime(analysisDate, true);
	}
	public void setAnalysisGnisId(String analysisGnisId) {
		this.analysisGnisId = analysisGnisId;
	}
	
	public void setAnalysisOutOfPriorityPercentOfDay(double analysisOutOfPriorityPercentOfDay) {
		this.analysisOutOfPriorityPercentOfDay = analysisOutOfPriorityPercentOfDay;
	}
	public void setAnalysisStreamMile(double analysisStreamMile) {
		this.analysisStreamMile = analysisStreamMile;
	}
	
	public void setAnalysisWaterSourceName(String analysisWaterSourceName) {
		this.analysisWaterSourceName = analysisWaterSourceName;
	}
	public void setAnalysisWrAdminNo(double analysisWrAdminNo) {
		this.analysisWrAdminNo = analysisWrAdminNo;
	}
	
	public void setBoundingStructureName(String boundingStructureName) {
		this.boundingStructureName = boundingStructureName;
	}
	public void setBoundingWdid(String boundingWdid) {
		this.boundingWdid = boundingWdid;
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
	
	public void setLocationStructure(String locationStructure) {
		this.locationStructure = locationStructure;
	}
	public void setLocationWdid(String locationWdid) {
		this.locationWdid = locationWdid;
	}
	
	public void setLocationWdidStreamMile(double locationWdidStreamMile) {
		this.locationWdidStreamMile = locationWdidStreamMile;
	}
	public void setPriorityAdminNo(double priorityAdminNo) {
		this.priorityAdminNo = priorityAdminNo;
	}
	
	public void setPriorityDate(String priorityDate) {
		this.priorityDate = TimeToolkit.getInstance().toDateTime(priorityDate, true);
	}
	public void setPriorityNo(String priorityNo) {
		this.priorityNo = priorityNo;
	}
	
	public void setPriorityOrderNo(int priorityOrderNo) {
		this.priorityOrderNo = priorityOrderNo;
	}
	public void setPriorityStructure(String priorityStructure) {
		this.priorityStructure = priorityStructure;
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
		return "AnalysisServicesCallAnalysisByGnisId: [ analysisDate: " + analysisDate + ", analysisGnisId: " + analysisGnisId + 
				", analysisWaterSourceName: " + analysisWaterSourceName + ", analysisStreamMile: " + analysisStreamMile + 
				", analysisWrAdminNo: " + analysisWrAdminNo + ", division: " + division + ", callType: " + callType + ", dateTimeSet: " +
				dateTimeSet + ", dateTimeReleased: " + dateTimeReleased + ", waterSourceName: " + waterSourceName + ", locationWdid" + 
				locationWdid + ", locationStructure: " + locationStructure + ", locationWdidStreamMile: " + locationWdidStreamMile + 
				", priorityWdid: " + priorityWdid + ", priorityStructure: " + priorityStructure + ", priorityAdminNo: " + priorityAdminNo + 
				", priorityOrderNo: " + priorityOrderNo + ", priorityDate: " + priorityDate + ", priorityNo: " + priorityNo + 
				", boundingWdid: " + boundingWdid + ", boundingStructureName: " + boundingStructureName + ", setComments: " + 
				", releaseComment: " + releaseComment + ", analysisOutOfPriorityPercentOfDay: " + analysisOutOfPriorityPercentOfDay + " ]\n";
	}

}
