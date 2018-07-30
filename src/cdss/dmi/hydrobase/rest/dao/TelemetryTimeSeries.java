package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class works for telemeteryTimeSeriesRaw, telemetryTimeSeriesHour, and telemeteryTimeSeriesDay
 * @author jurentie
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryTimeSeries {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrytimeseriesraw
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrytimeserieshour
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrytimeseriesday
	 */
	
	/* Abbreviation */
	private String abbrev;
	
	/* Parameter */
	private String parameter;
	
	/* Measurement Date Time - for hour/day */
	private LocalDateTime measDate;
	
	/* Measurement Date Time - for raw */
	private LocalDateTime measDateTime;
	
	/* Measurement Value */
	private double measValue;
	
	/* Flag A*/
	private String flagA;
	
	/* Flag B */
	private String flagB;
	
	/* Measurement Count */
	private int measCount;
	
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
	
	public int getMinute(){
		if(measDateTime != null){
			return measDateTime.getMinute();
		}else{
			return measDate.getMinute();
		}
	}
	
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
	
	@Override
	public String toString(){
		return "TelemetryTimeSeriesRaw: [ abbrev: " + abbrev + ", parameter: " + parameter + 
				", measDateTime: " + measDateTime + ", measValue: " + measValue + ", flagA: " + 
				flagA + ", flagB: " + flagB + ", measCount: " + measCount + ", modified: " + modified + " ]";
	}

}
