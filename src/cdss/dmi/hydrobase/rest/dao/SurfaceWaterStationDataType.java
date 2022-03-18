// SurfaceWaterStationDataType - data object for surface water station data types

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
 * This class stores surface water station data type data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurfaceWaterStationDataType {
	
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
	 * Data type, used in TSTool, a variation of 'measType'.
	 */
	private String dataType;

	/**
	 * DWR Water Division.
	 */
	private Integer division;
	
	/**
	 * Latitude value in decimal degrees.
	 */
	private Double latdecdeg;
	
	/**
	 * Accuracy of location coordinates.
	 */
	private String locationAccuracy;
	
	/**
	 * Longitude in decimal degrees.
	 */
	private Double longdecdeg;
	
	/**
	 * Measurement type, from the web service.
	 */
	private String measType;

	/**
	 * Measurement units.
	 */
	private String measUnit;
	
	/**
	 * Period of record end.
	 */
	private DateTime porEnd;
	
	/**
	 * When record last modified.
	 */
	private DateTime porLastModified;
	
	/**
	 * Period of record start.
	 */
	private DateTime porStart;
	
	/**
	 * State abbreviation.
	 */
	private String st;

	/**
	 * Station Name.
	 */
	private String stationName;
	
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

	public String getDataType() {
		return dataType;
	}
	
	public Integer getDivision() {
		return division;
	}
	
	public Double getLatdecdeg() {
		return latdecdeg;
	}
	
	public String getLocationAccuracy() {
		return locationAccuracy;
	}
	
	public Double getLongdecdeg() {
		return longdecdeg;
	}
	
	public String getMeasType() {
		return measType;
	}

	public String getMeasUnit(){
		return measUnit;
	}
	
	public DateTime getPorEnd() {
		return porEnd;
	}

	public DateTime getPorLastModified() {
		return porLastModified;
	}

	public DateTime getPorStart() {
		return porStart;
	}

	public String getSt() {
		return st;
	}
	
	public String getStationName() {
		return stationName;
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
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void setDivision(Integer division) {
		this.division = division;
	}
	
	public void setLatdecdeg(Double latdecdeg) {
		this.latdecdeg = latdecdeg;
	}
	
	public void setLocationAccuracy(String locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
	}
	
	public void setLongdecdeg(Double longdecdeg) {
		this.longdecdeg = longdecdeg;
	}
	
	public void setMeasType(String measType) {
		this.measType = measType;
	}

	public void setMeasUnit(String measUnit){
		this.measUnit = measUnit;
	}
	
	public void setPorEnd(String porEnd) {
		if ( porEnd == null ) {
			this.porEnd = null;
		}
		else {
			try {
				this.porEnd = DateTime.parse(porEnd);
			}
			catch ( Exception e ) {
				Message.printWarning(3, "setPorEnd", "Error parsing porEnd: " + porEnd);
				Message.printWarning(3, "setPorEnd", e);
			}
		}
	}

	public void setPorLastModified(String porLastModified) {
		if ( porLastModified == null ) {
			this.porLastModified = null;
		}
		else {
			try {
				this.porLastModified = DateTime.parse(porLastModified);
			}
			catch ( Exception e ) {
				Message.printWarning(3, "setPorLastModified", "Error parsing porLastModified: " + porLastModified);
				Message.printWarning(3, "setPorLastModified", e);
			}
		}
	}
	
	public void setPorStart(String porStart) {
		if ( porStart == null ) {
			this.porStart = null;
		}
		else {
			try {
				this.porStart = DateTime.parse(porStart);
			}
			catch ( Exception e ) {
				Message.printWarning(3, "setPorStart", "Error parsing porStart: " + porStart);
				Message.printWarning(3, "setPorStart", e);
			}
		}
	}

	public void setSt(String st) {
		this.st= st;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
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
			+ ", dataType: " + dataType
			+ ", division: " + division 
			+ ", latdecdeg: " + latdecdeg
			+ ", locationAccuracy: " + locationAccuracy
			+ ", longdecdeg: " + longdecdeg
			+ ", measType: " + measType
			+ ", measUnit: " + measUnit
			+ ", porEnd: " + porEnd
			+ ", porLastModified: " + porLastModified
			+ ", porStart: " + porStart
			+ ", st: " + st
			+ ", stationName: " + stationName
			+ ", usgsSiteId: " + usgsSiteId
			+ ", utmX: " + utmX
			+ ", utmY: " + utmY
			+ ", waterDistrict: " + waterDistrict
			+ " ]\n";
	}

}