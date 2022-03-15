// ClimateStationFrostDates - data object for station time series frost dates

/* NoticeStart

CDSS HydroBase REST Web Services Java Library
CDSS HydroBase REST Web Services Java Library is a part of Colorado's Decision Support Systems (CDSS)
Copyright (C) 2018-2022 Colorado Department of Natural Resources

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

/**
 * This class stores data for climate station frost dates, for example see below (using dates only).
 * The data types need to be handled in the time series identifier and user documentation.
 * <pre>
    {
      "stationNum": 104,
      "calYear": 1895,
      "l28s": "1895-05-12",
      "f28f": "1895-09-22",
      "l32s": "1895-05-17",
      "f32f": "1895-09-22"
    },
 * </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClimateStationFrostDates {
	
	// Data members are defined in alphabetical order.

	/**
	 * Calendar year number.
	 */
	private Integer calYear;

	/**
	 * First fall date with temperature 28F.
	 */
	private DateTime f28f;

	/**
	 * First fall date with temperature 32F.
	 */
	private DateTime f32f;

	/**
	 * Last spring date with temperature 28F.
	 */
	private DateTime l28s;

	/**
	 * Last spring date with temperature 32F.
	 */
	private DateTime l32s;
	
	/**
	 * Station number.
	 */
	private Integer stationNum;

	// Getters for data members.

	public Integer getCalYear() {
		return calYear;
	}

	public DateTime getF28f() {
		return f28f;
	}

	public DateTime getF32f() {
		return f32f;
	}

	public DateTime getL28s() {
		return l28s;
	}

	public DateTime getL32s() {
		return l32s;
	}

	public Integer getStationNum() {
		return stationNum;
	}
	
	// Setters for data members.

	public void setCalYear(Integer calYear) {
		this.calYear = calYear;
	}

	public void setF28F(DateTime f28f) {
		this.f28f = f28f;
	}

	public void setF32F(DateTime f32f) {
		this.f32f = f32f;
	}

	public void setL28s(DateTime l28s) {
		this.l28s = l28s;
	}

	public void setL32s(DateTime l32s) {
		this.l32s = l32s;
	}

	public void setStationNum(Integer stationNum) {
		this.stationNum = stationNum;
	}

	/**
	 * To string method for testing purposes.
	 * Data members are in alphabetical order.
	 */
	@Override 
	public String toString(){
		return "SurfaceWaterTSDay: [ " 
			+ ", calYear: " + calYear
			+ ", f28f: " + f28f
			+ ", f32f: " + f32f
			+ ", l28s: " + l28s
			+ ", l32s: " + l32s
			+ ", stationNum: " + stationNum
			+ " ]\n";
	}

}