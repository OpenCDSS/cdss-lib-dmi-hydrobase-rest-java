// ClimateStationTSMonth - data object for month interval climate station time series record

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
 * Note that multiple statistics are returned for the 'measType'
 * and need to be handled in time series identifier and user documentation.
 * <pre>
    {
      "stationNum": 104,
      "siteId": "USC00053005",
      "measType": "Evap",
      "calYear": 1949,
      "calMonthNum": 4,
      "minValue": 0.03,
      "maxValue": 0.29,
      "avgValue": 0.16,
      "totalValue": 3.01,
      "measUnit": "in",
      "measCount": 19,
      "dataSource": "NOAA",
      "modified": "2013-03-29T15:42:05.663"
    },
 * </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClimateStationTSMonth {
	
	// Data members are defined in alphabetical order.

	/**
	 * Data value.
	 */
	private Double avgValue;

	/**
	 * Calendar month number.
	 */
	private Integer calMonthNum;

	/**
	 * Calendar year number.
	 */
	private Integer calYear;
	
	/**
	 * Primary source/provider of station data (e.g., "USGS", "DWR").
	 */
	private String dataSource;

	/**
	 * Data value.
	 */
	private Double maxValue;

	/**
	 * Count of daily measurements to calculate monthly statistic value.
	 */
	private Integer measCount;

	/**
	 * Measurement type.
	 */
	private String measType;

	/**
	 * Measurement units.
	 */
	private String measUnit;

	/**
	 * Data value.
	 */
	private Double minValue;

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
	private Integer stationNum;

	/**
	 * Data value.
	 */
	private Double totalValue;
	
	// Getters for data members.

	public Double getAvgValue () {
		return avgValue;
	}

	public Integer getCalMonthNum() {
		return calMonthNum;
	}

	public Integer getCalYear() {
		return calYear;
	}

	public String getDataSource() {
		return dataSource;
	}

	public Double getMaxValue () {
		return maxValue;
	}

	public Double getMinValue () {
		return minValue;
	}

	public Integer getMeasCount() {
		return measCount;
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

	public Integer getStationNum() {
		return stationNum;
	}
	
	public Double getTotalValue() {
		return totalValue;
	}

	// Setters for data members.

	public void setAvgValue(Double avgValue) {
		this.avgValue = avgValue;
	}

	public void setCalMonNum(Integer calMonthNum) {
		this.calMonthNum = calMonthNum;
	}

	public void setCalYear(Integer calYear) {
		this.calYear = calYear;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public void setMeasType(String measType) {
		this.measType = measType;
	}

	public void setMeasUnit(String measUnit){
		this.measUnit = measUnit;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public void setModified(String modified) {
		if ( modified == null ) {
			this.modified = null;
		}
		else {
			this.modified = DateTime.parse(modified);
		}
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public void setStationNum(Integer stationNum) {
		this.stationNum = stationNum;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	/**
	 * To string method for testing purposes.
	 * Data members are in alphabetical order.
	 */
	@Override 
	public String toString(){
		return "SurfaceWaterTSDay: [ " 
			+ ", avgValue: " + avgValue
			+ ", calMonthNum: " + calMonthNum
			+ ", calYear: " + calYear
			+ ", dataSource: " + dataSource
			+ ", maxValue: " + maxValue
			+ ", minValue: " + minValue
			+ ", measType: " + measType
			+ ", measUnit: " + measUnit
			+ ", modified: " + modified
			+ ", siteId: " + siteId
			+ ", stationNum: " + stationNum
			+ ", totalValue: " + totalValue
			+ " ]\n";
	}

}