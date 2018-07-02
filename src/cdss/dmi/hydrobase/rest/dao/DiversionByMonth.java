package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

public class DiversionByMonth {
	
	/**
	 * Variables declared in order as returned
	 * by DWR API. For more detail see: 
	 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures-divrec-divrecmonth
	 */

    /* WDID of the associated structure*/
	private String wdid;
	
	/* WaterClass Number */
	private int waterClassNum;
	
	/*WaterCalss Identifier */
	private String wcIdentifier;
	
	/* Measurement Interval */
	private String measInterval;
	
	/* Measurement Count */
	private int measCount;
	
	/* Data Measurement Date */
	private String dataMeasDate;
	
	/* Data Value */
	private double dataValue;
	
	/* Measurement Units */
	private String measUnits;
	
	/* Observation Code */
	private String obsCode;
	
	/*Approval Status */
	private String approvalStatus;
	
	/* Modified date/time */
	private LocalDateTime modified;

	public String getWdid() {
		return wdid;
	}

	public void setWdid(String wdid) {
		this.wdid = wdid;
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

	public String getMeasInterval() {
		return measInterval;
	}

	public void setMeasInterval(String measInterval) {
		this.measInterval = measInterval;
	}

	public int getMeasCount() {
		return measCount;
	}

	public void setMeasCount(int measCount) {
		this.measCount = measCount;
	}

	public String getDataMeasDate() {
		return dataMeasDate;
	}

	public void setDataMeasDate(String dataMeasDate) {
		this.dataMeasDate = dataMeasDate;
	}

	public double getDataValue() {
		return dataValue;
	}

	public void setDataValue(double dataValue) {
		this.dataValue = dataValue;
	}

	public String getMeasUnits() {
		return measUnits;
	}

	public void setMeasUnits(String measUnits) {
		this.measUnits = measUnits;
	}

	public String getObsCode() {
		return obsCode;
	}

	public void setObsCode(String obsCode) {
		this.obsCode = obsCode;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = (modified == null) ? null : LocalDateTime.parse(modified);
	}
	
	/* Additional getters where relevant */
	public int getYear(){
		return Integer.parseInt(dataMeasDate.split("-")[0]);
	}
	
	public int getMonth(){
		return Integer.parseInt(dataMeasDate.split("-")[1]);
	}
	
	@Override 
	public String toString(){
		return "DiversionByDate: [ wdid: " + wdid + ", waterClassNum: " + waterClassNum + ", wcIdentifier: " +
				wcIdentifier + ", measInterval: " + measInterval + ", measCount: " + measCount + ", dataMeasDate: " + dataMeasDate +
				", dataValue: " + dataValue + ", measUnits: " + measUnits + ", obsCode: " + obsCode + 
				", approvalStatus: " + approvalStatus + ", modified: " + modified + " ]";
	}
}
