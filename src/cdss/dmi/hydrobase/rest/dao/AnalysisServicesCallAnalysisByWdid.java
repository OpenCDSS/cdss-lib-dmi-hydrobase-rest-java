package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-analysisservices-callanalysisbywdid
 * @author jurentie
 *
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisServicesCallAnalysisByWdid {
	
	/**
	 * Variables defined in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Analysis Date
	 */
	private DateTime analysisDate;
	
	/**
	 * Analysis Out Of Priority Percent Of Day
	 */
	private double analysisOutOfPriorityOfDay;
	
	/**
	 * Analysis Structure Name
	 */
	private String analysisStructureName;
	
	/**
	 * Analysis WDID
	 */
	private String analysisWdid;
	
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
	 * Division
	 */
	private int division;
	
	/**
	 * Location Structure
	 */
	private String locationStructure;
	
	/**
	 * Location WDID
	 */
	private String locationWdid;
	
	/**
	 * Location WDID Stream Mile
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
	public void setAnalysisDate(String analysisDate) {
		this.analysisDate = TimeToolkit.getInstance().toDateTime(analysisDate, true);
	}
	
	public double getAnalysisOutOfPriorityOfDay() {
		return analysisOutOfPriorityOfDay;
	}
	public void setAnalysisOutOfPriorityOfDay(double analysisOutOfPriorityOfDay) {
		this.analysisOutOfPriorityOfDay = analysisOutOfPriorityOfDay;
	}
	
	public String getAnalysisStructureName() {
		return analysisStructureName;
	}
	public void setAnalysisStructureName(String analysisStructureName) {
		this.analysisStructureName = analysisStructureName;
	}
	
	public String getAnalysisWdid() {
		return analysisWdid;
	}
	public void setAnalysisWdid(String analysisWdid) {
		this.analysisWdid = analysisWdid;
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
		this.dateTimeReleased = TimeToolkit.getInstance().toDateTime(dateTimeReleased, true);
	}
	
	public DateTime getDateTimeSet() {
		return dateTimeSet;
	}
	public void setDateTimeSet(String dateTimeSet) {
		this.dateTimeSet = TimeToolkit.getInstance().toDateTime(dateTimeSet, true);
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
		this.priorityDate = TimeToolkit.getInstance().toDateTime(priorityDate, true);
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
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "AnalysisServicesCallAnalysisByWdid: [ analysisDate: " + analysisDate + ", analysisWdid: " + analysisWdid + 
				", analysisStructureName: " + analysisStructureName + ", analysisWrAdminNo: " + analysisWrAdminNo + 
				", analysisOutOfPriorityPercentOfDay: " + analysisOutOfPriorityOfDay + ", division: " + division + 
				", callType: " + callType + ", dateTimeSet: " + dateTimeSet + ", dateTimeReleased: " + dateTimeReleased + 
				", waterSourceName: " + waterSourceName + ", locationWdid: " + locationWdid + ", locationStructure: " +
				locationStructure + ", locationWdidStreamMile: " + locationWdidStreamMile + ", priorityWdid: " + 
				priorityWdid + ", priorityStructure: " + priorityStructure + ", priorityAdminNo: " + priorityAdminNo + 
				", priorityOrderNo: " + priorityOrderNo + ", priorityDate: " + priorityDate + ", priorityNo: " + 
				priorityNo + ", boundingWdid: " + boundingWdid + ", boundingStructureName: " + boundingStructureName + 
				", setComments: " + setComments + ", releaseComment: " + releaseComment + " ]";
	}

}
