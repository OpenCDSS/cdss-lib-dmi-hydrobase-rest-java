// TelemetryShift - data object for telemetry shift

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
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetryshiftadjustedratingtable<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetryshiftcurve
 * @author jurentie
 *
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryShift {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Rating Table Name
	 */
	private String ratingTableName;
	
	/**
	 * Shift Curve Name
	 */
	private String shiftCurveName;
	
	/**
	 * X Value
	 */
	private double X;
	
	/**
	 * Y Value
	 */
	private double Y;
	
	/**
	 * Getters and setters of defined variables.
	 */
	public String getRatingTableName() {
		return ratingTableName;
	}
	public String getShiftCurveName() {
		return shiftCurveName;
	}
	public double getX() {
		return X;
	}
	public double getY() {
		return Y;
	}
	public void setRatingTableName(String ratingTableName) {
		this.ratingTableName = ratingTableName;
	}
	public void setShiftCurveName(String shiftCurveName) {
		this.shiftCurveName = shiftCurveName;
	}
	@JsonProperty("X")
	public void setX(double x) {
		X = x;
	}
	@JsonProperty("Y")
	public void setY(double y) {
		Y = y;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override 
	public String toString(){
		if(ratingTableName != null && !ratingTableName.isEmpty()){
			return "TelemetryShiftAdjustedRatingTable: [ ratingTableName: " + ratingTableName + ", X: " + 
					X + ", Y: " + Y + " ]\n";
		}else{
			return "TelemetryShiftCurve: [ shiftCurveName: " + shiftCurveName + ", X: " + X + ", Y: " + Y + " ]\n";
		}
	}
	
}
