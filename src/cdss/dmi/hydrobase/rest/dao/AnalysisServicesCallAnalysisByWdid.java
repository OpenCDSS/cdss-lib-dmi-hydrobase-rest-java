// AnalysisServicesCallAnalysisByWdid - data object for analysis services for calls

/* NoticeStart

CDSS HydroBase REST Web Services Java Library
CDSS HydroBase REST Web Services Java Library is a part of Colorado's Decision Support Systems (CDSS)
Copyright (C) 2018-2019 Colorado Department of Natural Resources

CDSS HydroBase REST Web Services Java Library is free software:  you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    CDSS HydroBase REST Web Services Java Library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with CDSS HydroBase REST Web Services Java Library.  If not, see <https://www.gnu.org/licenses/>.

NoticeEnd */

package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-analysisservices-callanalysisbywdid
 * @author jurentie
 *
 */
/*
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
	private Double analysisOutOfPriorityOfDay;
	
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
	private Double analysisWrAdminNo;
	
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
	private Double locationWdidStreamMile;
	
	/**
	 * Priority Administration Number
	 */
	private Double priorityAdminNo;
	
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
	private Integer priorityOrderNo;
	
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
	public Double getAnalysisOutOfPriorityOfDay() {
		return analysisOutOfPriorityOfDay;
	}
	
	public String getAnalysisStructureName() {
		return analysisStructureName;
	}
	public String getAnalysisWdid() {
		return analysisWdid;
	}
	
	public Double getAnalysisWrAdminNo() {
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
	public Double getLocationWdidStreamMile() {
		return locationWdidStreamMile;
	}
	
	public Double getPriorityAdminNo() {
		return priorityAdminNo;
	}
	public DateTime getPriorityDate() {
		return priorityDate;
	}
	
	public String getPriorityNo() {
		return priorityNo;
	}
	public Integer getPriorityOrderNo() {
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
	
	public void setAnalysisOutOfPriorityOfDay(Double analysisOutOfPriorityOfDay) {
		this.analysisOutOfPriorityOfDay = analysisOutOfPriorityOfDay;
	}
	public void setAnalysisStructureName(String analysisStructureName) {
		this.analysisStructureName = analysisStructureName;
	}
	
	public void setAnalysisWdid(String analysisWdid) {
		this.analysisWdid = analysisWdid;
	}
	public void setAnalysisWrAdminNo(Double analysisWrAdminNo) {
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
	
	public void setLocationWdidStreamMile(Double locationWdidStreamMile) {
		this.locationWdidStreamMile = locationWdidStreamMile;
	}
	public void setPriorityAdminNo(Double priorityAdminNo) {
		this.priorityAdminNo = priorityAdminNo;
	}
	
	public void setPriorityDate(String priorityDate) {
		this.priorityDate = TimeToolkit.getInstance().toDateTime(priorityDate, true);
	}
	public void setPriorityNo(String priorityNo) {
		this.priorityNo = priorityNo;
	}
	
	public void setPriorityOrderNo(Integer priorityOrderNo) {
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
		return "AnalysisServicesCallAnalysisByWdid: [ analysisDate: " + analysisDate + ", analysisWdid: " + analysisWdid + 
				", analysisStructureName: " + analysisStructureName + ", analysisWrAdminNo: " + analysisWrAdminNo + 
				", analysisOutOfPriorityPercentOfDay: " + analysisOutOfPriorityOfDay + ", division: " + division + 
				", callType: " + callType + ", dateTimeSet: " + dateTimeSet + ", dateTimeReleased: " + dateTimeReleased + 
				", waterSourceName: " + waterSourceName + ", locationWdid: " + locationWdid + ", locationStructure: " +
				locationStructure + ", locationWdidStreamMile: " + locationWdidStreamMile + ", priorityWdid: " + 
				priorityWdid + ", priorityStructure: " + priorityStructure + ", priorityAdminNo: " + priorityAdminNo + 
				", priorityOrderNo: " + priorityOrderNo + ", priorityDate: " + priorityDate + ", priorityNo: " + 
				priorityNo + ", boundingWdid: " + boundingWdid + ", boundingStructureName: " + boundingStructureName + 
				", setComments: " + setComments + ", releaseComment: " + releaseComment + " ]\n";
	}

}