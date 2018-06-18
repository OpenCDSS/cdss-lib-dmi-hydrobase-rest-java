package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

/**
 * This class works for telemeteryTimeSeriesRaw, telemetryTimeSeriesHour, and telemeteryTimeSeriesDay
 * @author jurentie
 *
 */
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
	private String measDate;
	
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
	
	public String getMeasDate() {
		return measDate;
	}

	public void setMeasDate(String measDate) {
		this.measDate = measDate;
	}

	public LocalDateTime getMeasDateTime() {
		return measDateTime;
	}

	public void setMeasDateTime(String measDateTime) {
		this.measDateTime = LocalDateTime.parse(measDateTime);
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
		this.modified = LocalDateTime.parse(modified);
	}
	
	@Override
	public String toString(){
		return "TelemetryTimeSeriesRaw: [ abbrev: " + abbrev + ", parameter: " + parameter + 
				", measDateTime: " + measDateTime + ", measValue: " + measValue + ", flagA: " + 
				flagA + ", flagB: " + flagB + ", measCount: " + measCount + ", modified: " + modified + " ]";
	}

}
