package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures-divrec-divrecday
 * @author jurentie
 *
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiversionByDay {
	
	/**
	 * Variables defined in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Approval Status 
	 */
	private String approvalStatus;

	/**
	 * Data Measurement Date 
	 */
	private DateTime dataMeasDate;
	
	/**
	 * Data Value 
	 */
	private double dataValue;
	
	/**
	 *  Measurement Interval 
	 */
	private String measInterval;
	
	/**
	 *  Measurement Units 
	 */
	private String measUnits;
	
	/**
	 *  Modified date/time 
	 */
	private DateTime modified;
	
	/** 
	 * Observation Code 
	 */
	private String obsCode;
	
	/** 
	 * WaterClass Number 
	 */
	private int waterClassNum;
	
	/** 
	 * WaterCalss Identifier 
	 */
	private String wcIdentifier;
	
    /** 
     * WDID of the associated structure
     */
	private String wdid;
	
	/**
	 * Getters and setters for defined variables.
	 */
	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public DateTime getDataMeasDate() {
		return dataMeasDate;
	}

	public void setDataMeasDate(String dataMeasDate) {
		this.dataMeasDate = (dataMeasDate == null || dataMeasDate == "") ? null : DateTime.parse(dataMeasDate);
	}

	public double getDataValue() {
		return dataValue;
	}

	public void setDataValue(double dataValue) {
		this.dataValue = dataValue;
	}

	public String getMeasInterval() {
		return measInterval;
	}

	public void setMeasInterval(String measInterval) {
		this.measInterval = measInterval;
	}

	public String getMeasUnits() {
		return measUnits;
	}

	public void setMeasUnits(String measUnits) {
		this.measUnits = measUnits;
	}

	public DateTime getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = (modified == null || modified == "") ? null : DateTime.parse(modified);
	}

	public String getObsCode() {
		return obsCode;
	}

	public void setObsCode(String obsCode) {
		this.obsCode = obsCode;
	}

	public int getWaterClassNum() {
		return waterClassNum;
	}

	public void setWaterClassNum(int waterClassNum) {
		this.waterClassNum = waterClassNum;
	}

	public String getWcIdentifier() {
		return wcIdentifier;
	}

	public void setWcIdentifier(String wcIdentifier) {
		this.wcIdentifier = wcIdentifier;
	}

	public String getWdid() {
		return wdid;
	}

	public void setWdid(String wdid) {
		this.wdid = wdid;
	}
	
	/**
	 *  Additional getters that are necessary in other locations in the code
	 */
	public int getYear(){
		return dataMeasDate.getYear();
	}

	public int getMonth(){
		return dataMeasDate.getMonth();
	}
	
	public int getDay(){
		return dataMeasDate.getDay();
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override 
	public String toString(){
		return "DiversionByDate: [ wdid: " + wdid + ", waterClassNum: " + waterClassNum + ", wcIdentifier: " +
				wcIdentifier + ", measInterval: " + measInterval + ", dataMeasDate: " + dataMeasDate +
				", dataValue: " + dataValue + ", measUnits: " + measUnits + ", obsCode: " + obsCode + 
				", approvalStatus: " + approvalStatus + ", modified: " + modified + " ]";
	}

}
