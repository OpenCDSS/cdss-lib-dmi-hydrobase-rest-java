// TelemetryStationDataTypes - data object for telemetry station data types

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

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrystationdatatypes
 * @author jurentie
 *
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryStationDataTypes {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Abbreviation
	 */
	private String abbrev;
	
	/**
	 * Contributing Area
	 */
	private double contrArea;
	
	/**
	 * County where the well is located
	 */
	private String county;
	
	/**
	 * Primary source/provider of well measurement data
	 */
	private String dataSource;
	
	/**
	 * Data source abbreviation
	 */
	private String dataSourceAbbrev;
	
	/**
	 * DWR Water Division
	 */
	private int division;
	
	/**
	 * Drainage Area
	 */
	private double drainArea;
	
	/**
	 * National Hydrographic Dataset stream identifier
	 */
	private String gnisId;
	
	/**
	 * HUC 10
	 */
	private String huc10;
	
	/**
	 * Latitude value in decimal degrees
	 */
	private double latdecdeg;
	
	/**
	 * Accuracy of location coordinates
	 */
	private String locationAccuracy;
	
	/**
	 * Longitude in decimal degrees
	 */
	private double longdecdeg;
	
	/**
	 * Last date time that this record was modified in the DWR database
	 */
	private DateTime modified;
	
	/**
	 * Parameter
	 */
	private String parameter;
	
	/**
	 * Unit for given Parameter
	 */
	private String parameterUnit;
	
	/**
	 * Station Name
	 */
	private String stationName;
	
	/**
	 * Station Status
	 */
	private String stationStatus;
	
	/**
	 * Station Type
	 */
	private String stationType;
	
	/**
	 * Distance in miles to the confluence with the next downstream 
	 * water source (or distance to state line)
	 */
	private double streamMile;
	
	/**
	 * Type of structure
	 */
	private String structureType;
	
	/**
	 * USGS Station ID
	 */
	private String usgsStationId;
	
	/**
	 * The x (Easting) component of the Universal Transverse Mercator system. 
	 * (Zone 12, NAD83 datum)
	 */
	private double utmX;
	
	/**
	 * The y (Northing) component of the Universal Transverse Mercator system. 
	 * (Zone 12, NAD83 datum)
	 */
	private double utmY;
	/**
	 * Added variable for use in other places in the code. 
	 * Not originally from web services
	 * @jurentie
	 */
	private String timeStep;
	
	/**
	 * DWR Water District
	 */
	private int waterDistrict;
	
	/**
	 * Name of the water source as specified in the court case
	 */
	private String waterSource;
	
	/**
	 * DWR unique structure identifier
	 */
	private String wdid;
	
	/**
	 * Getters and setters for defined variables
	 */
	public String getAbbrev() {
		return abbrev;
	}
	public double getContrArea() {
		return contrArea;
	}
	
	public String getCounty() {
		return county;
	}
	public String getDataSource() {
		return dataSource;
	}
	
	public String getDataSourceAbbrev() {
		return dataSourceAbbrev;
	}
	public int getDivision() {
		return division;
	}
	
	public double getDrainArea() {
		return drainArea;
	}
	public String getGnisId() {
		return gnisId;
	}
	
	public String getHuc10() {
		return huc10;
	}
	public double getLatdecdeg() {
		return latdecdeg;
	}
	
	public String getLocationAccuracy() {
		return locationAccuracy;
	}
	public double getLongdecdeg() {
		return longdecdeg;
	}
	
	public DateTime getModified() {
		return modified;
	}
	public String getParameter() {
		return parameter;
	}
	
	public String getParameterUnit(){
		return parameterUnit;
	}
	public String getStationName() {
		return stationName;
	}
	
	public String getStationStatus() {
		return stationStatus;
	}
	public String getStationType() {
		return stationType;
	}
	
	public double getStreamMile() {
		return streamMile;
	}
	public String getStructureType() {
		return structureType;
	}
	
	public String getTimeStep() {
		return timeStep;
	}
	public String getUsgsStationId() {
		return usgsStationId;
	}
	
	public double getUtmX() {
		return utmX;
	}
	public double getUtmY() {
		return utmY;
	}
	
	public int getWaterDistrict() {
		return waterDistrict;
	}
	public String getWaterSource() {
		return waterSource;
	}
	
	public String getWdid() {
		return wdid;
	}
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
	
	public void setContrArea(double contrArea) {
		this.contrArea = contrArea;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public void setDataSourceAbbrev(String dataSourceAbbrev) {
		this.dataSourceAbbrev = dataSourceAbbrev;
	}
	
	public void setDivision(int division) {
		this.division = division;
	}
	public void setDrainArea(double drainArea) {
		this.drainArea = drainArea;
	}
	
	public void setGnisId(String gnisId) {
		this.gnisId = gnisId;
	}
	public void setHuc10(String huc10) {
		this.huc10 = huc10;
	}
	
	public void setLatdecdeg(double latdecdeg) {
		this.latdecdeg = latdecdeg;
	}
	public void setLocationAccuracy(String locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
	}
	
	public void setLongdecdeg(double longdecdeg) {
		this.longdecdeg = longdecdeg;
	}
	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, false);
	}
	
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public void setParameterUnit(String parameterUnit){
		this.parameterUnit = parameterUnit;
	}
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public void setStationStatus(String stationStatus) {
		this.stationStatus = stationStatus;
	}
	
	public void setStationType(String stationType) {
		this.stationType = stationType;
	}
	public void setStreamMile(double streamMile) {
		this.streamMile = streamMile;
	}
	
	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}
	public void setTimeStep(String timeStep) {
		this.timeStep = timeStep;
	}
	
	public void setUsgsStationId(String usgsStationId) {
		this.usgsStationId = usgsStationId;
	}
	public void setUtmX(double utmX) {
		this.utmX = utmX;
	}
	
	public void setUtmY(double utmY) {
		this.utmY = utmY;
	}
	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}
	
	public void setWaterSource(String waterSource) {
		this.waterSource = waterSource;
	}
	public void setWdid(String wdid) {
		this.wdid = wdid;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "TelemetryStationDataTypes: [ division: " + division + ", waterDistrict: " + waterDistrict + 
				", county: " + county + ", stationName: " + stationName + ", dataSourceAbbrev: " + dataSourceAbbrev + 
				", dataSource: " + dataSource + ", abbrev: " + abbrev + ", wdid: " + wdid + ", usgsStationId: "+
				usgsStationId + ", stationStatus: " + stationStatus + ", stationType: " + stationType + ", stationType: " +
				stationType + ", stationType: " + stationType + ", waterSource: " + waterSource + ", gnisId: " + gnisId + 
				", streamMile: " + streamMile + ", structureType: " + structureType + ", parameter: " + parameter + 
				", parameterUnit: " + parameterUnit + ", contrArea: " + contrArea + ", drainArea: " + drainArea + 
				", huc10: " + huc10 + ", utmX: " + utmX + ", utmY: " + ", latdecdeg: " + latdecdeg + ", longdecdeg: " + 
				longdecdeg + ", locationAccuracy: " + locationAccuracy + ", modified: " + modified + " ]\n";
	}

}
