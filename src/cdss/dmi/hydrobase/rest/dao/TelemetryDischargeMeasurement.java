package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryDischargeMeasurement {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrydischargemeasurement
	 */
	
	/* DWR Water Division */
	private int div;
	
	/* DWR Water District */
	private int wd;
	
	/* County */
	private String county;
	
	/*Abbreviation */
	private String abbrev;
	
	/* Measurement Number */
	private String measNo;
	
	/* Measurement Date Time */
	private LocalDateTime measDateTime;
	
	/* Measurement Made By */
	private String measMadeBy;
	
	/* Channel Width */
	private double channelWidth;
	
	/* Section Area */
	private double sectionArea;
	
	/* Mean Velocity */
	private double meanVelocity;
	
	/* Gage Height Change */
	private double gageHeight;
	
	/* Discharge */
	private double discharge;
	
	/* Shift Adjustments */
	private double shiftAdjustment;
	
	/* Percent Difference */
	private double percentDifference;
	
	/* Measurement Method */
	private String measMethod;
	
	/* Measurement Sections */
	private int measSections;
	
	/* Gage height Change */
	private double gageHeightChange;
	
	/* Measurement Duration */
	private double measDuration;
	
	/* Meter Number */
	private String meterNo;
	
	/* Measurement Remarks */
	private String measRemarks;
	
	/* Date record last modified */
	private LocalDateTime modified;

	public int getDiv() {
		return div;
	}

	public void setDiv(int div) {
		this.div = div;
	}

	public int getWd() {
		return wd;
	}

	public void setWd(int wd) {
		this.wd = wd;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public String getMeasNo() {
		return measNo;
	}

	public void setMeasNo(String measNo) {
		this.measNo = measNo;
	}

	public LocalDateTime getMeasDateTime() {
		return measDateTime;
	}

	public void setMeasDateTime(String measDateTime) {
		this.measDateTime = LocalDateTime.parse(measDateTime);
	}

	public String getMeasMadeBy() {
		return measMadeBy;
	}

	public void setMeasMadeBy(String measMadeBy) {
		this.measMadeBy = measMadeBy;
	}

	public double getChannelWidth() {
		return channelWidth;
	}

	public void setChannelWidth(double channelWidth) {
		this.channelWidth = channelWidth;
	}

	public double getSectionArea() {
		return sectionArea;
	}

	public void setSectionArea(double sectionArea) {
		this.sectionArea = sectionArea;
	}

	public double getMeanVelocity() {
		return meanVelocity;
	}

	public void setMeanVelocity(double meanVelocity) {
		this.meanVelocity = meanVelocity;
	}

	public double getGageHeight() {
		return gageHeight;
	}

	public void setGageHeight(double gageHeight) {
		this.gageHeight = gageHeight;
	}

	public double getDischarge() {
		return discharge;
	}

	public void setDischarge(double discharge) {
		this.discharge = discharge;
	}

	public double getShiftAdjustment() {
		return shiftAdjustment;
	}

	public void setShiftAdjustment(double shiftAdjustment) {
		this.shiftAdjustment = shiftAdjustment;
	}

	public double getPercentDifference() {
		return percentDifference;
	}

	public void setPercentDifference(double precentDifference) {
		this.percentDifference = precentDifference;
	}

	public String getMeasMethod() {
		return measMethod;
	}

	public void setMeasMethod(String measMethod) {
		this.measMethod = measMethod;
	}

	public int getMeasSections() {
		return measSections;
	}

	public void setMeasSections(int measSections) {
		this.measSections = measSections;
	}

	public double getGageHeightChange() {
		return gageHeightChange;
	}

	public void setGageHeightChange(double gageHeightChange) {
		this.gageHeightChange = gageHeightChange;
	}

	public double getMeasDuration() {
		return measDuration;
	}

	public void setMeasDuration(double measDuration) {
		this.measDuration = measDuration;
	}

	public String getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public String getMeasRemarks() {
		return measRemarks;
	}

	public void setMeasRemarks(String measRemarks) {
		this.measRemarks = measRemarks;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = LocalDateTime.parse(modified);
	}
	
	@Override
	public String toString(){
		return "TelemetryDischargeMeasurement [ div: " + div + ", wd: " + wd + ", county: " + county + 
				", abbrev: " + abbrev + ", measNo: " + measNo + ", measDateTime: " + measDateTime + 
				", measMadeBy: " + measMadeBy+ ", channelWidth: " + channelWidth + ", sectionArea: " + 
				sectionArea + ", meanVelocity: " + meanVelocity + ", gageHeight: " + gageHeight + ", discharge: " + 
				discharge + ", shiftAdjustment: " + shiftAdjustment + ", percentDifference: " + percentDifference +
				", measMethod: " + measMethod + ", measSections: " + measSections + ", gageHeightChange: " + 
				gageHeightChange + ", measDuration: " + measDuration + ", meterNo: " + meterNo + ", measRemarks" +
				measRemarks + ", modified: " + modified + " ]";
	}

}
