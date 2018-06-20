package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

public class WaterLevelsWellMeasurement {
	
	/**
	 * Variables declared in order as returned
	 * by DWR API. For more detail see: 
	 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-groundwater-waterlevels-wellmeasurements
	 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-groundwater-waterlevels-wellmeasurements-wellId
	 */
	
	/* Well ID Number */
	private int wellId;
	
	/* Well Name */
	private String wellName;
	
	/* DWR Division */
	private int division;
	
	/* DWR Water District */
	private int waterDistrict;
	
	/* County */
	private String county;
	
	/* Management District Name */
	private String managementDistrict;
	
	/* Designated Basin Name */
	private String designatedBasin;
	
	/* Publication Name */
	private String publication;
	
	/* Measurement Date */
	private LocalDateTime measurementDate;
	
	/* Depth to Water (ft) */
	private double depthToWater;
	
	/* Measuring Point Above Land Surface (ft) */
	private double measuringPointAboveLandSurface;
	
	/* Depth to Water Below Land Surface */
	private double depthWaterBelowLandSurface;
	
	/* Elevation of Water (Above Sea Level) */
	private double elevationOfWater;
	
	/* Change From Previous Measure (ft) */
	private double delta;
	
	/* Data Source */
	private String dataSource;
	
	/* Published Measurement? */
	private String published;
	
	/* Measurement Last Modified Date */
	private LocalDateTime modified;
	
	public int getWellId() {
		return wellId;
	}
	public void setWellId(int wellId) {
		this.wellId = wellId;
	}
	public String getWellName() {
		return wellName;
	}
	public void setWellName(String wellName) {
		this.wellName = wellName;
	}
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	public int getWaterDistrict() {
		return waterDistrict;
	}
	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getManagementDistrict() {
		return managementDistrict;
	}
	public void setManagementDistrict(String managementDistrict) {
		this.managementDistrict = managementDistrict;
	}
	public String getDesignatedBasin() {
		return designatedBasin;
	}
	public void setDesignatedBasin(String designatedBasin) {
		this.designatedBasin = designatedBasin;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public LocalDateTime getMeasurementDate() {
		return measurementDate;
	}
	public void setMeasurementDate(String measurementDate) {
		this.measurementDate = LocalDateTime.parse(measurementDate);
	}
	public double getDepthToWater() {
		return depthToWater;
	}
	public void setDepthToWater(double depthToWater) {
		this.depthToWater = depthToWater;
	}
	public double getMeasuringPointAboveLandSurface() {
		return measuringPointAboveLandSurface;
	}
	public void setMeasuringPointAboveLandSurface(double measuringPointAboveLandSurface) {
		this.measuringPointAboveLandSurface = measuringPointAboveLandSurface;
	}
	public double getDepthWaterBelowLandSurface() {
		return depthWaterBelowLandSurface;
	}
	public void setDepthWaterBelowLandSurface(double depthWaterBelowLandSurface) {
		this.depthWaterBelowLandSurface = depthWaterBelowLandSurface;
	}
	public double getElevationOfWater() {
		return elevationOfWater;
	}
	public void setElevationOfWater(double elevationOfWater) {
		this.elevationOfWater = elevationOfWater;
	}
	public double getDelta() {
		return delta;
	}
	public void setDelta(double delta) {
		this.delta = delta;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getPublished() {
		return published;
	}
	public void setPublished(String published) {
		this.published = published;
	}
	public LocalDateTime getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = LocalDateTime.parse(modified);
	}
	
	@Override
	public String toString(){
		return "WaterLEvelsWellMeasurements [ wellId: " + wellId + ", wellName: " + wellName + 
				", division: " + division + ", waterDistrict: " + waterDistrict + ", county: " + 
				county + ", managementDistrict: " + managementDistrict + ", designatedBasin: " + 
				designatedBasin + ", publication: " + publication + ", measurementDate: " + 
				measurementDate + ", depthToWater: " + depthToWater + ", measuringPointAboveLandSurface: " +
				measuringPointAboveLandSurface + ", depthWaterBelowLandSurface: " + depthWaterBelowLandSurface + 
				", elevationOfWater: " + elevationOfWater + ", delta: " + delta + ", dataSource: " + 
				dataSource + ", published: " + published + ", modified: " + modified;
	}

}
