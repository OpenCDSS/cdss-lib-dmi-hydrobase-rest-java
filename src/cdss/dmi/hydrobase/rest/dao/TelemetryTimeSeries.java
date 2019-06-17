// TelemetryTimeSeries - data object for telemetry station time series record

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
 * This class works for telemeteryTimeSeriesRaw, telemetryTimeSeriesHour, and telemeteryTimeSeriesDay<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrystationdatatypes<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrytimeseriesraw<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrytimeserieshour<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrytimeseriesday<br>
 * @author jurentie
 *
 */
/*
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
	private DateTime measDate;

	/** 
	 * Measurement Date Time - for raw 
	 */
	private DateTime measDateTime;

	/** 
	 * Measurement Value 
	 */
	private Double measValue;

	/** 
	 * Date record last modified 
	 */
	private DateTime modified;

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
	
	public int getDay(){
		if(measDateTime != null){
			return measDateTime.getDay();
		}else{
			return measDate.getDay();
		}
	}
	
	public String getFlagA() {
		return flagA;
	}
	
	public String getFlagB() {
		return flagB;
	}
	
	public int getHour(){
		if(measDateTime != null){
			return measDateTime.getHour();
		}else{
			return measDate.getHour();
		}
	}
	
	public int getMeasCount() {
		return measCount;
	}
	
	public DateTime getMeasDate() {
		return measDate;
	}
	
	public DateTime getMeasDateTime() {
		return measDateTime;
	}

	public Double getMeasValue() {
		return measValue;
	}
	
	public int getMinute(){
		if(measDateTime != null){
			return measDateTime.getMinute();
		}else{
			return measDate.getMinute();
		}
	}
	
	public DateTime getModified() {
		return modified;
	}
	
	public int getMonth(){
		if(measDateTime != null){
			return measDateTime.getMonth();
		}else{
			return measDate.getMonth();
		}
		
	}
	
	public String getParameter() {
		return parameter;
	}
	
	public int getYear(){
		if(measDateTime != null){
			return measDateTime.getYear();
		}else{
			return measDate.getYear();
		}
		
	}
	
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
	public void setFlagA(String flagA) {
		this.flagA = flagA;
	}
	
	public void setFlagB(String flagB) {
		this.flagB = flagB;
	}
	public void setMeasCount(int measCount) {
		this.measCount = measCount;
	}

	public void setMeasDate(String measDate) {
		this.measDate = TimeToolkit.getInstance().toDateTime(measDate, false);
	}

	public void setMeasDateTime(String measDateTime) {
		this.measDateTime = TimeToolkit.getInstance().toDateTime(measDateTime, false);
	}

	public void setMeasValue(Double measValue) {
		this.measValue = measValue;
	}

	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, false);
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
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
				flagA + ", flagB: " + flagB + ", measCount: " + measCount + ", modified: " + modified + " ]\n";
	}

}