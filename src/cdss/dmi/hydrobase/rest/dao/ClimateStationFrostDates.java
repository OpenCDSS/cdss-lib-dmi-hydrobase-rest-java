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
		return this.calYear;
	}

	public DateTime getF28f() {
		return this.f28f;
	}

	public DateTime getF32f() {
		return this.f32f;
	}

	public DateTime getL28s() {
		return this.l28s;
	}

	public DateTime getL32s() {
		return this.l32s;
	}

	public Integer getStationNum() {
		return this.stationNum;
	}
	
	// Setters for data members.

	public void setCalYear(Integer calYear) {
		this.calYear = calYear;
	}

	public void setF28f(String f28f) {
		if ( f28f == null ) {
			this.f28f = null;
		}
		else {
			this.f28f = DateTime.parse(f28f);
		}
	}

	public void setF32f(String f32f) {
		if ( f32f == null ) {
			this.f32f = null;
		}
		else {
			this.f32f = DateTime.parse(f32f);
		}
	}

	public void setL28s(String l28s) {
		if ( l28s == null ) {
			this.l28s = null;
		}
		else {
			this.l28s = DateTime.parse(l28s);
		}
	}

	public void setL32s(String l32s) {
		if ( l32s == null ) {
			this.l32s = null;
		}
		else {
			this.l32s = DateTime.parse(l32s);
		}
	}

	public void setStationNum(Integer stationNum) {
		this.stationNum = stationNum;
	}

	/**
	 * To string method for testing purposes.
	 * Data members are in alphabetical order.
	 */
	@Override 
	public String toString() {
		return "ClimateStationFrostDates: [ " 
			+ ", calYear: " + calYear
			+ ", f28f: " + f28f
			+ ", f32f: " + f32f
			+ ", l28s: " + l28s
			+ ", l32s: " + l32s
			+ ", stationNum: " + stationNum
			+ " ]\n";
	}

}