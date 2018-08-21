package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrydischargemeasurement
 * @author jurentie
 *
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryDischargeMeasurement {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/** 
	 * Abbreviation 
	 */
	private String abbrev;

	/** 
	 * Channel Width 
	 */
	private double channelWidth;

	/** 
	 * County where the well is located
	 */
	private String county;

	/** 
	 * Discharge 
	 */
	private double discharge;
	
	/** 
	 * DWR Water Division 
	 */
	private int division;
	
	/** 
	 * Gage Height 
	 */
	private double gageHeight;

	/** 
	 * Gage height Change 
	 */
	private double gageHeightChange;

	/** 
	 * Mean Velocity 
	 */
	private double meanVelocity;

	/** 
	 * Measurement Date Time 
	 */
	private DateTime measDateTime;

	/** 
	 * Measurement Duration 
	 */
	private double measDuration;

	/** 
	 * Measurement Made By 
	 */
	private String measMadeBy;

	/** 
	 * Measurement Method 
	 */
	private String measMethod;

	/** 
	 * Measurement Number 
	 */
	private String measNo;

	/**
	 * Measurement Remarks 
	 */
	private String measRemarks;

	/** 
	 * Measurement Sections 
	 */
	private int measSections;

	/** 
	 * Meter Number 
	 */
	private String meterNo;

	/**
	 * Last date time that this record was modified in the DWR database
	 */
	private DateTime modified;

	/** 
	 * Percent Difference 
	 */
	private double percentDifference;

	/** 
	 * Section Area 
	 */
	private double sectionArea;
	
	/**
	 * Shift Adjustments 
	 */
	private double shiftAdjustment;
	
	/** 
	 * DWR Water District 
	 */
	private int waterDistrict;

	/**
	 * Getters and setters of defined variables.
	 */
	public String getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public double getChannelWidth() {
		return channelWidth;
	}

	public void setChannelWidth(double channelWidth) {
		this.channelWidth = channelWidth;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public double getDischarge() {
		return discharge;
	}

	public void setDischarge(double discharge) {
		this.discharge = discharge;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public double getGageHeight() {
		return gageHeight;
	}

	public void setGageHeight(double gageHeight) {
		this.gageHeight = gageHeight;
	}

	public double getGageHeightChange() {
		return gageHeightChange;
	}

	public void setGageHeightChange(double gageHeightChange) {
		this.gageHeightChange = gageHeightChange;
	}

	public double getMeanVelocity() {
		return meanVelocity;
	}

	public void setMeanVelocity(double meanVelocity) {
		this.meanVelocity = meanVelocity;
	}

	public DateTime getMeasDateTime() {
		return measDateTime;
	}

	public void setMeasDateTime(String measDateTime) {
		this.measDateTime = TimeToolkit.getInstance().toDateTime(measDateTime, true);
	}

	public double getMeasDuration() {
		return measDuration;
	}

	public void setMeasDuration(double measDuration) {
		this.measDuration = measDuration;
	}

	public String getMeasMadeBy() {
		return measMadeBy;
	}

	public void setMeasMadeBy(String measMadeBy) {
		this.measMadeBy = measMadeBy;
	}

	public String getMeasMethod() {
		return measMethod;
	}

	public void setMeasMethod(String measMethod) {
		this.measMethod = measMethod;
	}

	public String getMeasNo() {
		return measNo;
	}

	public void setMeasNo(String measNo) {
		this.measNo = measNo;
	}

	public String getMeasRemarks() {
		return measRemarks;
	}

	public void setMeasRemarks(String measRemarks) {
		this.measRemarks = measRemarks;
	}

	public int getMeasSections() {
		return measSections;
	}

	public void setMeasSections(int measSections) {
		this.measSections = measSections;
	}

	public String getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public DateTime getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, true);
	}

	public double getPercentDifference() {
		return percentDifference;
	}

	public void setPercentDifference(double precentDifference) {
		this.percentDifference = precentDifference;
	}

	public double getSectionArea() {
		return sectionArea;
	}

	public void setSectionArea(double sectionArea) {
		this.sectionArea = sectionArea;
	}

	public double getShiftAdjustment() {
		return shiftAdjustment;
	}

	public void setShiftAdjustment(double shiftAdjustment) {
		this.shiftAdjustment = shiftAdjustment;
	}

	public int getWaterDistrict() {
		return waterDistrict;
	}

	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}

	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "TelemetryDischargeMeasurement [ div: " + division + ", wd: " + waterDistrict + ", county: " + county + 
				", abbrev: " + abbrev + ", measNo: " + measNo + ", measDateTime: " + measDateTime + 
				", measMadeBy: " + measMadeBy+ ", channelWidth: " + channelWidth + ", sectionArea: " + 
				sectionArea + ", meanVelocity: " + meanVelocity + ", gageHeight: " + gageHeight + ", discharge: " + 
				discharge + ", shiftAdjustment: " + shiftAdjustment + ", percentDifference: " + percentDifference +
				", measMethod: " + measMethod + ", measSections: " + measSections + ", gageHeightChange: " + 
				gageHeightChange + ", measDuration: " + measDuration + ", meterNo: " + meterNo + ", measRemarks" +
				measRemarks + ", modified: " + modified + " ]";
	}

}
