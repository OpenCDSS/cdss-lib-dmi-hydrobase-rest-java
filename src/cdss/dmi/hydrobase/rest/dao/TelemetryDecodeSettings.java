package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TelemetryDecodeSettings {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrydecodesettings
	 */

	/* Abbreviation */
	private String abbrev;
	
	/* Parameter */
	private String parameter;
	
	/* Function */
	private String function;
	
	
	/* Rating Table Name */
	@JsonProperty("rating_table_name")
	private String ratingTableName;
	
	/* Rating Start Date */
	@JsonProperty("rating_start_date")
	private LocalDateTime ratingStartDate;
	
	/* Shift Curve Name */
	@JsonProperty("shift_curve_name")
	private String shiftCurveName;
	
	/* Shiftcurve Start Date */
	@JsonProperty("shiftcurve_start_date")
	private LocalDateTime shiftcurveStartDate;
	
	/* Current Shift */
	@JsonProperty("current_shift")
	private int currentShift;
	
	/* Shift Start Date */
	@JsonProperty("shift_start_date")
	private LocalDateTime shiftStartDate;
	
	/* Date record last modified */
	private LocalDateTime modified;

	public String getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getRatingTableName() {
		return ratingTableName;
	}

	public void setRatingTableName(String ratingTableName) {
		this.ratingTableName = ratingTableName;
	}

	public LocalDateTime getRatingStartDate() {
		return ratingStartDate;
	}

	public void setRatingStartDate(String ratingStartDate) {
		this.ratingStartDate = LocalDateTime.parse(ratingStartDate);
	}

	public String getShiftCurveName() {
		return shiftCurveName;
	}

	public void setShiftCurveName(String shiftCurveName) {
		this.shiftCurveName = shiftCurveName;
	}

	public LocalDateTime getShiftcurveStartDate() {
		return shiftcurveStartDate;
	}

	public void setShiftcurveStartDate(String shiftcurveStartDate) {
		this.shiftcurveStartDate = LocalDateTime.parse(shiftcurveStartDate);
	}
	
	public int getCurrentShift() {
		return currentShift;
	}

	public void setCurrentShift(int currentShift) {
		this.currentShift = currentShift;
	}

	public LocalDateTime getShiftStartDate() {
		return shiftStartDate;
	}

	public void setShiftStartDate(String shiftStartDate) {
		this.shiftStartDate = LocalDateTime.parse(shiftStartDate);
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = LocalDateTime.parse(modified);
	}
	
	@Override
	public String toString(){
		return "TelemetryDecodeSettings [ abbrev: " + abbrev + ", parameter: " + parameter + ", function: " + 
				function + ", ratingTableName: " + ratingTableName + ", ratingStartDate: " + ratingStartDate + 
				", shiftCurveName: " + shiftCurveName + ", shiftcurveStartDate: " + shiftcurveStartDate + 
				", currentShift: " + currentShift + ", shiftStartDate: " + shiftStartDate + ", modified: " + 
				modified + " ]";
	}

}
