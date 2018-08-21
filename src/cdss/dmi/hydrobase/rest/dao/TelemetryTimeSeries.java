package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * This class works for telemeteryTimeSeriesRaw, telemetryTimeSeriesHour, and telemeteryTimeSeriesDay
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrystationdatatypes
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrytimeseriesraw
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrytimeserieshour
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrytimeseriesday
 * @author jurentie
 *
 */
/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryTimeSeries {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/** 
	 * Abbreviation 
	 */
	private String abbrev;
	
	/** 
	 * Flag A
	 */
	private String flagA;

	/** 
	 * Flag B 
	 */
	private String flagB;

	/**
	 * Measurement Count 
	 */
	private int measCount;

	/** 
	 * Measurement Date Time - for hour/day 
	 */
	private LocalDateTime measDate;

	/** 
	 * Measurement Date Time - for raw 
	 */
	private LocalDateTime measDateTime;

	/** 
	 * Measurement Value 
	 */
	private double measValue;

	/** 
	 * Date record last modified 
	 */
	private LocalDateTime modified;

	/** 
	 * Parameter 
	 */
	private String parameter;

	/**
	 * Getters and setters for defined variables.
	 */
	public String getAbbrev() {
		return abbrev;
	}
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public String getFlagA() {
		return flagA;
	}
	public void setFlagA(String flagA) {
		this.flagA = flagA;
	}

	public String getFlagB() {
		return flagB;
	}
	public void setFlagB(String flagB) {
		this.flagB = flagB;
	}

	public int getMeasCount() {
		return measCount;
	}
	public void setMeasCount(int measCount) {
		this.measCount = measCount;
	}

	public LocalDateTime getMeasDate() {
		return measDate;
	}
	public void setMeasDate(String measDate) {
		this.measDate = (measDate == null) ? null : LocalDateTime.parse(measDate);
	}

	public LocalDateTime getMeasDateTime() {
		return measDateTime;
	}
	public void setMeasDateTime(String measDateTime) {
		this.measDateTime = (measDateTime == null) ? null : LocalDateTime.parse(measDateTime);
	}

	public double getMeasValue() {
		return measValue;
	}
	public void setMeasValue(double measValue) {
		this.measValue = measValue;
	}
	
	public LocalDateTime getModified() {
		return modified;
	}
	public void setModified(String modified) {
		if(modified == "N/A" || modified == null){
			this.modified = null;
		}else{
			int indexOf = modified.lastIndexOf("-");
			modified = modified.substring(0, indexOf);
			this.modified = LocalDateTime.parse(modified);
		}
	}
	
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public int getMinute(){
		if(measDateTime != null){
			return measDateTime.getMinute();
		}else{
			return measDate.getMinute();
		}
	}

	/**
	 * Added methods to get date values used in other places in the code.
	 */
	public int getHour(){
		if(measDateTime != null){
			return measDateTime.getHour();
		}else{
			return measDate.getHour();
		}
	}

	public int getDay(){
		if(measDateTime != null){
			return measDateTime.getDayOfMonth();
		}else{
			return measDate.getDayOfMonth();
		}
	}

	public int getMonth(){
		if(measDateTime != null){
			return measDateTime.getMonthValue();
		}else{
			return measDate.getMonthValue();
		}
		
	}

	public int getYear(){
		if(measDateTime != null){
			return measDateTime.getYear();
		}else{
			return measDate.getYear();
		}
		
	}

	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "TelemetryTimeSeriesRaw: [ abbrev: " + abbrev + ", parameter: " + parameter + 
				", measDateTime: " + measDateTime + ", measValue: " + measValue + ", flagA: " + 
				flagA + ", flagB: " + flagB + ", measCount: " + measCount + ", modified: " + modified + " ]";
	}

}
