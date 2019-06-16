// TelemetryDischargeMeasurement - data object for telemetry discharge measurement

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
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrydischargemeasurement
 * @author jurentie
 *
 */
/*
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
	private Double channelWidth;

	/** 
	 * County where the well is located
	 */
	private String county;

	/** 
	 * Discharge 
	 */
	private Double discharge;
	
	/** 
	 * DWR Water Division 
	 */
	private int division;
	
	/** 
	 * Gage Height 
	 */
	private Double gageHeight;

	/** 
	 * Gage height Change 
	 */
	private Double gageHeightChange;

	/** 
	 * Mean Velocity 
	 */
	private Double meanVelocity;

	/** 
	 * Measurement Date Time 
	 */
	private DateTime measDateTime;

	/** 
	 * Measurement Duration 
	 */
	private Double measDuration;

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
	private Integer measSections;

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
	private Double percentDifference;

	/** 
	 * Section Area 
	 */
	private Double sectionArea;
	
	/**
	 * Shift Adjustments 
	 */
	private Double shiftAdjustment;
	
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

	public Double getChannelWidth() {
		return channelWidth;
	}

	public String getCounty() {
		return county;
	}

	public Double getDischarge() {
		return discharge;
	}

	public int getDivision() {
		return division;
	}

	public Double getGageHeight() {
		return gageHeight;
	}

	public Double getGageHeightChange() {
		return gageHeightChange;
	}

	public Double getMeanVelocity() {
		return meanVelocity;
	}

	public DateTime getMeasDateTime() {
		return measDateTime;
	}

	public Double getMeasDuration() {
		return measDuration;
	}

	public String getMeasMadeBy() {
		return measMadeBy;
	}

	public String getMeasMethod() {
		return measMethod;
	}

	public String getMeasNo() {
		return measNo;
	}

	public String getMeasRemarks() {
		return measRemarks;
	}

	public Integer getMeasSections() {
		return measSections;
	}

	public String getMeterNo() {
		return meterNo;
	}

	public DateTime getModified() {
		return modified;
	}

	public Double getPercentDifference() {
		return percentDifference;
	}

	public Double getSectionArea() {
		return sectionArea;
	}

	public Double getShiftAdjustment() {
		return shiftAdjustment;
	}

	public int getWaterDistrict() {
		return waterDistrict;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public void setChannelWidth(Double channelWidth) {
		this.channelWidth = channelWidth;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public void setDischarge(Double discharge) {
		this.discharge = discharge;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public void setGageHeight(Double gageHeight) {
		this.gageHeight = gageHeight;
	}

	public void setGageHeightChange(Double gageHeightChange) {
		this.gageHeightChange = gageHeightChange;
	}

	public void setMeanVelocity(Double meanVelocity) {
		this.meanVelocity = meanVelocity;
	}

	public void setMeasDateTime(String measDateTime) {
		this.measDateTime = TimeToolkit.getInstance().toDateTime(measDateTime, true);
	}

	public void setMeasDuration(Double measDuration) {
		this.measDuration = measDuration;
	}

	public void setMeasMadeBy(String measMadeBy) {
		this.measMadeBy = measMadeBy;
	}

	public void setMeasMethod(String measMethod) {
		this.measMethod = measMethod;
	}

	public void setMeasNo(String measNo) {
		this.measNo = measNo;
	}

	public void setMeasRemarks(String measRemarks) {
		this.measRemarks = measRemarks;
	}

	public void setMeasSections(Integer measSections) {
		this.measSections = measSections;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, true);
	}

	public void setPercentDifference(Double precentDifference) {
		this.percentDifference = precentDifference;
	}

	public void setSectionArea(Double sectionArea) {
		this.sectionArea = sectionArea;
	}

	public void setShiftAdjustment(Double shiftAdjustment) {
		this.shiftAdjustment = shiftAdjustment;
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
				measRemarks + ", modified: " + modified + " ]\n";
	}

}