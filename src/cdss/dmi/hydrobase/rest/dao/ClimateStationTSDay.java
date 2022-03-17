// ClimateStationTSDay - data object for day interval climate station time series record

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
 * This class stores data for climate station station day interval time series data, for example see below.
 * Note that a single implied statistic (total daily evaporation) is implied for the 'measType'
 * and need to be handled in time series identifier and user documentation.
 * <pre>
    {
      "stationNum": 104,
      "siteId": "USC00053005",
      "measType": "Evap",
      "measDate": "1949-04-06T00:00:00-06:00",
      "value": 0.228346,
      "flagA": null,
      "flagB": null,
      "flagC": "0",
      "flagD": "1900",
      "dataSource": "NOAA",
      "modified": "2013-03-29T15:42:05.663-06:00",
      "measUnit": "in"
    },
 * </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClimateStationTSDay {
	
	// Data members are defined in alphabetical order.
	
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
	 * Site ID.
	 */
	private String siteId;
	
	/**
	 * Station number.
	 */
	private int stationNum;
	
	/**
	 * Data value.
	 */
	private double value;
	
	// Getters for data members.

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

	public String getSiteId() {
		return siteId;
	}

	public int getStationNum() {
		return stationNum;
	}
	
	public double getValue() {
		return value;
	}

	// Setters for data members.

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
	
	public void setMeasDate(String measDate) {
		this.measDate = DateTime.parse(measDate);
	}

	public void setModified(String modified) {
		this.modified = DateTime.parse(modified);
	}

	public void setMeasType(String measType) {
		this.measType = measType;
	}

	public void setMeasUnit(String measUnit){
		this.measUnit = measUnit;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public void setStationNum(int stationNum) {
		this.stationNum = stationNum;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	/**
	 * To string method for testing purposes.
	 * Data members are in alphabetical order.
	 */
	@Override 
	public String toString(){
		return "SurfaceWaterTSDay: [ " 
			+ ", dataSource: " + dataSource
			+ ", flagA: " + flagA
			+ ", flagB: " + flagB
			+ ", flagC: " + flagC
			+ ", flagD: " + flagD
			+ ", measDate: " + measDate
			+ ", measType: " + measType
			+ ", measUnit: " + measUnit
			+ ", modified: " + modified
			+ ", siteId: " + siteId
			+ ", stationNum: " + stationNum
			+ ", value: " + value
			+ " ]\n";
	}

}