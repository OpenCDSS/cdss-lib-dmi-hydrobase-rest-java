// WaterLevelsWellMeasurement - data record for water level well measurement

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

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-groundwater-waterlevels-wellmeasurements<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-groundwater-waterlevels-wellmeasurements-wellId<br>
 * @author jurentie
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WaterLevelsWellMeasurement {
	
	/**
	 * Variables defined in alphabetical order. 
	 * Documentation copied from web services.
	 */
	
	/** 
	 * County where the well is located
	 */
	private String county;

	/** 
	 * Primary source/provider of well measurement data
	 */
	private String dataSource;

	/**
	 * Elevation of water in well on this date minus elevation 
	 * on the most recent prior date (feet)
	 */
	private Double delta;

	/**
	 * Depth from measure point to water level in well (feet)
	 */
	private Double depthToWater;

	/**
	 * Depth to Water Below Land Surface (ft)
	 */
	private Double depthWaterBelowLandSurface;

	/**
	 * Eight established geographic areas in Colorado's Eastern Plains where users 
	 * rely primarily on groundwater for water supply
	 */
	private String designatedBasin;

	/** 
	 * DWR Division 
	 */
	private int division;

	/**
	 * Elevation of water level in well (feet above mean sea level)
	 */
	private Double elevationOfWater;

	/**
	 * Thirteen local districts, within the Designated Basins, 
	 * with additional administrative authority
	 */
	private String managementDistrict;

	/**
	 * Date of measurement
	 */
	private DateTime measurementDate;

	/**
	 * Height of measure point above surface (feet)
	 */
	private Double measuringPointAboveLandSurface;

	/**
	 * Last date time that this record was modified in the DWR database
	 */
	private DateTime modified;

	/**
	 * Name of DWR Basin Summary publication in which well is included, 
	 * if applicable
	 */
	private String publication;

	/**
	 * Manual observation
	 */
	private String published;

	/**
	 * DWR Water District 
	 */
	private int waterDistrict;
	
	/**
	 * Unique ID of well in DWR database
	 */
	private int wellId;
	
	/**
	 * Name of well in DWR database
	 */
	private String wellName;
	
	/**
	 * Getters and setters of defined variables
	 */
	public String getCounty() {
		return county;
	}
	public String getDataSource() {
		return dataSource;
	}
	public int getDay(){
		return measurementDate.getDay();
	}
	public Double getDelta() {
		return delta;
	}
	public Double getDepthToWater() {
		return depthToWater;
	}
	public Double getDepthWaterBelowLandSurface() {
		return depthWaterBelowLandSurface;
	}
	public String getDesignatedBasin() {
		return designatedBasin;
	}
	public int getDivision() {
		return division;
	}
	public Double getElevationOfWater() {
		return elevationOfWater;
	}
	public String getManagementDistrict() {
		return managementDistrict;
	}
	public DateTime getMeasurementDate() {
		return measurementDate;
	}
	public double getMeasuringPointAboveLandSurface() {
		return measuringPointAboveLandSurface;
	}
	public DateTime getModified() {
		return modified;
	}
	public int getMonth(){
		return measurementDate.getMonth();
	}
	public String getPublication() {
		return publication;
	}
	public String getPublished() {
		return published;
	}
	public int getWaterDistrict() {
		return waterDistrict;
	}
	public int getWellId() {
		return wellId;
	}
	public String getWellName() {
		return wellName;
	}
	public int getYear(){
		return measurementDate.getYear();
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public void setDelta(Double delta) {
		this.delta = delta;
	}
	public void setDepthToWater(Double depthToWater) {
		this.depthToWater = depthToWater;
	}
	public void setDepthWaterBelowLandSurface(Double depthWaterBelowLandSurface) {
		this.depthWaterBelowLandSurface = depthWaterBelowLandSurface;
	}
	public void setDesignatedBasin(String designatedBasin) {
		this.designatedBasin = designatedBasin;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	public void setElevationOfWater(Double elevationOfWater) {
		this.elevationOfWater = elevationOfWater;
	}
	public void setManagementDistrict(String managementDistrict) {
		this.managementDistrict = managementDistrict;
	}
	public void setMeasurementDate(String measurementDate) {
		this.measurementDate = TimeToolkit.getInstance().toDateTime(measurementDate, true);
	}
	public void setMeasuringPointAboveLandSurface(Double measuringPointAboveLandSurface) {
		this.measuringPointAboveLandSurface = measuringPointAboveLandSurface;
	}
	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, false);
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public void setPublished(String published) {
		this.published = published;
	}
	
	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}
	
	public void setWellId(int wellId) {
		this.wellId = wellId;
	}
	
	public void setWellName(String wellName) {
		this.wellName = wellName;
	}
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "WaterLEvelsWellMeasurements [ wellId: " + wellId + ", wellName: " + wellName + 
				", division: " + division + ", waterDistrict: " + waterDistrict + ", county: " + 
				county + ", managementDistrict: " + managementDistrict + ", designatedBasin: " + 
				designatedBasin + ", publication: " + publication + ", measurementDate: " + 
				measurementDate + ", depthToWater: " + depthToWater + ", measuringPointAboveLandSurface: " +
				measuringPointAboveLandSurface + ", depthWaterBelowLandSurface: " + depthWaterBelowLandSurface + 
				", elevationOfWater: " + elevationOfWater + ", delta: " + delta + ", dataSource: " + 
				dataSource + ", published: " + published + ", modified: " + modified + " ]\n";
	}

}