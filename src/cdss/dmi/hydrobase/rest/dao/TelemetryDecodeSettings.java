package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrydecodesettings
 * @author jurentie
 *
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryDecodeSettings {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */

	/**
	 * Abbreviation 
	 */
	private String abbrev;
	
	/** 
	 * Current Shift 
	 * JsonProperty to help map a different variable name to the correct
	 * parameter returned from web services
	 */
	@JsonProperty("current_shift")
	private double currentShift;

	/**
	 * Function 
	 */
	private String function;

	/**
	 * Date record last modified 
	 */
	private DateTime modified;

	/**
	 * Parameter 
	 */
	private String parameter;
	
	/**
	 * Rating Start Date 
	 * JsonProperty to help map a different variable name to the correct
	 * parameter returned from web services
	 */
	@JsonProperty("rating_start_date")
	private DateTime ratingStartDate;

	/**
	 * Rating Table Name
	 * JsonProperty to help map a different variable name to the correct
	 * parameter returned from web services 
	 */
	@JsonProperty("rating_table_name")
	private String ratingTableName;
	
	/** 
	 * Shift Curve Name 
	 * JsonProperty to help map a different variable name to the correct
	 * parameter returned from web services
	 */
	@JsonProperty("shift_curve_name")
	private String shiftCurveName;
	
	/** 
	 * Shift Start Date 
	 * JsonProperty to help map a different variable name to the correct
	 * parameter returned from web services
	 */
	@JsonProperty("shift_start_date")
	private DateTime shiftStartDate;

	/** 
	 * Shiftcurve Start Date 
	 * JsonProperty to help map a different variable name to the correct
	 * parameter returned from web services
	 */
	@JsonProperty("shiftcurve_start_date")
	private DateTime shiftcurveStartDate;
	
	/**
	 * Getters and setters for defined variables.
	 */
	public String getAbbrev() {
		return abbrev;
	}
	public double getCurrentShift() {
		return currentShift;
	}

	public String getFunction() {
		return function;
	}
	public DateTime getModified() {
		return modified;
	}

	public String getParameter() {
		return parameter;
	}
	public DateTime getRatingStartDate() {
		return ratingStartDate;
	}

	public String getRatingTableName() {
		return ratingTableName;
	}
	public String getShiftCurveName() {
		return shiftCurveName;
	}

	public DateTime getShiftcurveStartDate() {
		return shiftcurveStartDate;
	}
	public DateTime getShiftStartDate() {
		return shiftStartDate;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
	public void setCurrentShift(double currentShift) {
		this.currentShift = currentShift;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, true);
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public void setRatingStartDate(String ratingStartDate) {
		this.ratingStartDate = TimeToolkit.getInstance().toDateTime(ratingStartDate, true);
	}

	public void setRatingTableName(String ratingTableName) {
		this.ratingTableName = ratingTableName;
	}
	public void setShiftCurveName(String shiftCurveName) {
		this.shiftCurveName = shiftCurveName;
	}

	public void setShiftcurveStartDate(String shiftcurveStartDate) {
		this.shiftcurveStartDate = TimeToolkit.getInstance().toDateTime(shiftcurveStartDate, true);
	}
	public void setShiftStartDate(String shiftStartDate) {
		this.shiftStartDate = TimeToolkit.getInstance().toDateTime(shiftStartDate, true);
	}

	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "TelemetryDecodeSettings [ abbrev: " + abbrev + ", parameter: " + parameter + ", function: " + 
				function + ", ratingTableName: " + ratingTableName + ", ratingStartDate: " + ratingStartDate + 
				", shiftCurveName: " + shiftCurveName + ", shiftcurveStartDate: " + shiftcurveStartDate + 
				", currentShift: " + currentShift + ", shiftStartDate: " + shiftStartDate + ", modified: " + 
				modified + " ]\n";
	}

}
