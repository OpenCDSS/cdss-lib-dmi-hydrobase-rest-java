// SurfaceWaterTSYear - data object for year interval surface water time series records

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
 * This class stores data for surface water station year (water year) interval time series data, for example see below.
 * Note that multiple statistics are included for the 'measType' and need to be handled in time series identifier.
 * <pre>
    {
      "stationNum": 476,
      "abbrev": "PLAKERCO",
      "usgsSiteId": "06754000",
      "measType": "Streamflow",
      "waterYear": 1901,
      "minQCfs": 62.00,
      "maxQCfs": 5860.00,
      "avgQCfs": 840.48,
      "totalQAf": 255064.22,
      "measCount": 153,
      "dataSource": "USGS",
      "modified": "2015-06-17T11:53:02.593"
    },
 * </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurfaceWaterTSYear {
	
	// Data members are defined in alphabetical order.
	
	/**
	 * Abbreviation, matches real-time station.
	 */
	private String abbrev;

	/**
	 * Data value.
	 */
	private Double avgQCfs;

	/**
	 * Calendar month number.
	 */
	private Integer calMonNum;

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
	private Double maxQCfs;

	/**
	 * Count of daily measurements to calculate monthly statistic value.
	 */
	private Integer measCount;
	
	/**
	 * Measurement type.
	 */
	private String measType;

	/**
	 * Data value.
	 */
	private Double minQCfs;

	/**
	 * Modification time.
	 */
	private DateTime modified;
	
	/**
	 * Station number.
	 */
	private Integer stationNum;

	/**
	 * Data value.
	 */
	private Double totalQAf;
	
	/**
	 * USGS site ID.
	 */
	private String usgsSiteId;
	
	// Getters for data members.

	public String getAbbrev() {
		return abbrev;
	}

	public Double getAvgQCfs(){
		return avgQCfs;
	}

	public Integer getCalMonNum() {
		return calMonNum;
	}

	public Integer getCalyear() {
		return calYear;
	}

	public String getDataSource() {
		return dataSource;
	}

	public Double getMaxQCfs() {
		return maxQCfs;
	}

	public Integer getMeasCount() {
		return measCount;
	}

	public String getMeasType() {
		return measType;
	}

	public Double getMinQCfs(){
		return minQCfs;
	}

	public DateTime getModified() {
		return modified;
	}

	public Integer getStationNum() {
		return stationNum;
	}

	public Double getTotalQAf(){
		return totalQAf;
	}
	
	public String getUsgsSiteId() {
		return usgsSiteId;
	}

	// Setters for data members.

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public void setAvgQCfs(Double avgQCfs) {
		this.avgQCfs = avgQCfs;
	}
	
	public void setCalMonNum(Integer calMonNum) {
		this.calMonNum = calMonNum;
	}

	public void setCalYear(Integer calYear) {
		this.calYear = calYear;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public void setMaxQCfs(Double maxQCfs) {
		this.maxQCfs = maxQCfs;
	}

	public void setMeasCount(Integer measCount){
		this.measCount = measCount;
	}

	public void setMeasType(String measType) {
		this.measType = measType;
	}

	public void setMinQCfs(Double minQCfs) {
		this.minQCfs = minQCfs;
	}

	public void setModified(DateTime modified) {
		this.modified = modified;
	}

	public void setStationNum(Integer stationNum) {
		this.stationNum = stationNum;
	}

	public void setTotalQAf(Double totalQAf) {
		this.totalQAf = totalQAf;
	}

	public void setUsgsSiteId(String usgsSiteId) {
		this.usgsSiteId = usgsSiteId;
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
			+ ", avgQcfs: " + avgQCfs
			+ ", calMonNum: " + calMonNum
			+ ", calYear: " + calYear
			+ ", dataSource: " + dataSource
			+ ", maxQCfs: " + maxQCfs
			+ ", measCount: " + measCount
			+ ", minQCfs: " + minQCfs
			+ ", measType: " + measType
			+ ", modified: " + modified
			+ ", stationNum: " + stationNum
			+ ", totalQAf: " + totalQAf
			+ ", usgsSiteId: " + usgsSiteId
			+ " ]\n";
	}

}