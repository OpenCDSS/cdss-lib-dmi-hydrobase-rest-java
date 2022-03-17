// SurfaceWaterStationDataType - data object for surface water station

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

import RTi.Util.Message.Message;
import RTi.Util.Time.DateTime;

/**
 * This class stores surface water station data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurfaceWaterStation {
	
    // Data members are declared in alphabetical order.
	
	/**
	 * Abbreviation, matches real-time station.
	 */
	private String abbrev;
	
	/**
	 * County where the station is located.
	 */
	private String county;
	
	/**
	 * Primary source/provider of station data (e.g., "USGS", "DWR").
	 */
	private String dataSource;
	
	/**
	 * DWR Water Division.
	 */
	private Integer division;
	
	/**
	 * Period of record end.
	 */
	private DateTime endDate;
	
	/**
	 * Latitude value in decimal degrees.
	 */
	private Double latitude;
	
	/**
	 * Accuracy of location coordinates.
	 */
	private String locationAccuracy;
	
	/**
	 * Longitude in decimal degrees.
	 */
	private Double longitude;
	
	/**
	 * When record last modified.
	 */
	private DateTime modified;
	
	/**
	 * Measurement unit:
	 * - TODO smalers 2022-03-13 why is this included here?
	 */
	private String measUnit;

	/**
	 * More information about the station.
	 */
	private String moreInformation;
	
	/**
	 * Period of record start.
	 */
	private DateTime startDate;
	
	/**
	 * State abbreviation.
	 */
	private String state;

	/**
	 * Station name.
	 */
	private String stationName;
	
	/**
	 * Station number.
	 */
	private Integer stationNum;
	
	/**
	 * USGS Station ID
	 */
	private String usgsSiteId;
	
	/**
	 * The x (Easting) component of the Universal Transverse Mercator system (Zone 12, NAD83 datum).
	 */
	private Double utmX;
	
	/**
	 * The y (Northing) component of the Universal Transverse Mercator system (Zone 12, NAD83 datum).
	 */
	private Double utmY;

	/**
	 * DWR Water District
	 */
	private Integer waterDistrict;
	
	// Getters for data members.

	public String getAbbrev() {
		return abbrev;
	}

	public String getCounty() {
		return county;
	}
	
	public String getDataSource() {
		return dataSource;
	}
	
	public Integer getDivision() {
		return division;
	}
	
	public DateTime getEndDate() {
		return endDate;
	}

	public Double getLatitude() {
		return latitude;
	}
	
	public String getLocationAccuracy() {
		return locationAccuracy;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public String getMeasUnit(){
		return measUnit;
	}
	
	public String getMoreInformation(){
		return moreInformation;
	}
	
	public DateTime getModified() {
		return modified;
	}

	public DateTime getStartDate() {
		return startDate;
	}

	public String getState() {
		return state;
	}
	
	public String getStationName() {
		return stationName;
	}

	public Integer getStationNum() {
		return stationNum;
	}

	public String getUsgsSiteId() {
		return usgsSiteId;
	}
	
	public Double getUtmX() {
		return utmX;
	}
	
	public Double getUtmY() {
		return utmY;
	}
	
	public Integer getWaterDistrict() {
		return waterDistrict;
	}
	
	// Setters for data members.
	
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
	
	public void setCounty(String county) {
		this.county = county;
	}
	
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	
	public void setDivision(Integer division) {
		this.division = division;
	}
	
	public void setEndDate(String endDate) {
		if ( endDate == null ) {
			this.endDate = null;
		}
		else {
			try {
				this.endDate = DateTime.parse(endDate);
			}
			catch ( Exception e ) {
				Message.printWarning(3, "setEndDate", "Error parsing endDate: " + endDate);
			}
		}
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public void setLocationAccuracy(String locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public void setMeasUnit(String measUnit){
		this.measUnit = measUnit;
	}
	
	public void setModified(String modified) {
		if ( modified == null ) {
			this.modified = null;
		}
		else {
			try {
				this.modified = DateTime.parse(modified);
			}
			catch ( Exception e ) {
				Message.printWarning(3, "setModified", "Error parsing modified: " + modified);
			}
		}
	}
	
	public void setStartDate(String startDate) {
		if ( startDate == null ) {
			this.startDate = null;
		}
		try {
			this.startDate = DateTime.parse(startDate);
		}
		catch ( Exception e ) {
			Message.printWarning(3, "setStartDate", "Error parsing startDate: " + startDate );
		}
	}

	public void setState(String state) {
		this.state= state;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	public void setStationNum(Integer stationNum) {
		this.stationNum = stationNum;
	}
	
	public void setUsgsSiteId(String usgsSiteId) {
		this.usgsSiteId = usgsSiteId;
	}

	public void setUtmX(Double utmX) {
		this.utmX = utmX;
	}
	
	public void setUtmY(Double utmY) {
		this.utmY = utmY;
	}

	public void setWaterDistrict(Integer waterDistrict) {
		this.waterDistrict = waterDistrict;
	}
	
	/**
	 * To string method for testing purposes:
	 * Data members defined in order of how they are returned in a json format from web services.
	 */
	@Override
	public String toString(){
		return "SurfaceWaterStationDataTypes: [ "
			+ ", abbrev: " + abbrev
			+ ", county: " + county
			+ ", dataSource: " + dataSource
			+ ", division: " + division 
			+ ", endDate: " + endDate
			+ ", latitude: " + latitude
			+ ", locationAccuracy: " + locationAccuracy
			+ ", longitude: " + longitude
			+ ", measUnit: " + measUnit
			+ ", modified: " + modified
			+ ", startDate: " + startDate
			+ ", state: " + state
			+ ", stationName: " + stationName
			+ ", stationNum: " + stationNum
			+ ", usgsSiteId: " + usgsSiteId
			+ ", utmX: " + utmX
			+ ", utmY: " + utmY
			+ ", waterDistrict: " + waterDistrict
			+ " ]\n";
	}

}