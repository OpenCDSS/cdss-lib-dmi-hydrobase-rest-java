// SurfaceWaterTSDay - data object for day interval surface water time series records

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
 * This class stores data for surface water station day interval time series data, for example see below.
 * Note that as single implied statistic (mean daily flow) is implied for the 'measType' and need to be handled in time series identifier.
 * <pre>
 *     {
      "stationNum": 476,
      "abbrev": "PLAKERCO",
      "usgsSiteId": "06754000",
      "measType": "Streamflow",
      "measDate": "1901-05-01",
      "value": 1540.000000,
      "flagA": "A",
      "flagB": null,
      "flagC": null,
      "flagD": null,
      "dataSource": "USGS",
      "modified": "2015-06-17",
      "measUnit": "cfs"
    },
 * </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurfaceWaterTSDay {
	
	// Data members are defined in alphabetical order.
	
	/**
	 * Abbreviation, matches real-time station.
	 */
	private String abbrev;
	
	/**
	 * Primary source/provider of station data (e.g., "USGS", "DWR").
	 */
	private String dataSource;

	/**
	 * flagA.
	 */
	private String flagA;

	/**
	 * flagB.
	 */
	private String flagB;

	/**
	 * flagC.
	 */
	private String flagC;

	/**
	 * flagD.
	 */
	private String flagD;
	
	/**
	 * Data measurement date.
	 */
	private DateTime measDate;
	
	/**
	 * Measurement type.
	 */
	private String measType;

	/**
	 * Measurement units.
	 */
	private String measUnit;

	/**
	 * Modification time.
	 */
	private DateTime modified;
	
	/**
	 * Station number.
	 */
	private Integer stationNum;
	
	/**
	 * USGS site ID.
	 */
	private String usgsSiteId;
	
	/**
	 * Data value.
	 */
	private Double value;
	
	// Getters for data members.

	public String getAbbrev() {
		return abbrev;
	}

	public String getDataSource() {
		return dataSource;
	}

	public String getFlagA() {
		return flagA;
	}

	public String getFlagB() {
		return flagB;
	}

	public String getFlagC() {
		return flagC;
	}

	public String getFlagD() {
		return flagD;
	}

	public DateTime getMeasDate() {
		return measDate;
	}

	public String getMeasType() {
		return measType;
	}

	public String getMeasUnit(){
		return measUnit;
	}

	public DateTime getModified() {
		return modified;
	}

	public Integer getStationNum() {
		return stationNum;
	}
	
	public String getUsgsSiteId() {
		return usgsSiteId;
	}

	public Double getValue() {
		return value;
	}

	// Setters for data members.

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
	
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public void setFlagA(String flagA) {
		this.flagA = flagA;
	}

	public void setFlagB(String flagB) {
		this.flagB = flagB;
	}

	public void setFlagC(String flagC) {
		this.flagC = flagC;
	}

	public void setFlagD(String flagD) {
		this.flagD = flagD;
	}
	
	public void setMeasDate(DateTime measDate) {
		this.measDate = measDate;
	}

	public void setModified(DateTime modified) {
		this.modified = modified;
	}

	public void setMeasType(String measType) {
		this.measType = measType;
	}

	public void setMeasUnit(String measUnit){
		this.measUnit = measUnit;
	}

	public void setStationNum(Integer stationNum) {
		this.stationNum = stationNum;
	}

	public void setUsgsSiteId(String usgsSiteId) {
		this.usgsSiteId = usgsSiteId;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override 
	public String toString(){
		return "SurfaceWaterTSDay: [ " 
			+ "abbrev: " + abbrev
			+ ", dataSource: " + dataSource
			+ ", flagA: " + flagA
			+ ", flagB: " + flagB
			+ ", flagC: " + flagC
			+ ", flagD: " + flagD
			+ ", measDate: " + measDate
			+ ", measType: " + measType
			+ ", measUnit: " + measUnit
			+ ", modified: " + modified
			+ ", stationNum: " + stationNum
			+ ", usgsSiteId: " + usgsSiteId
			+ ", value: " + value
			+ " ]\n";
	}

}