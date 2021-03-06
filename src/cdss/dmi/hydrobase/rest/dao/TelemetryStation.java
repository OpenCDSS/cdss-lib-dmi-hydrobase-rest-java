// TelemetryStation - data object for telemetry station

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
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetrystation
 * @author jurentie
 *
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryStation {
	
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
	private Double contrArea;

	/** 
	 * County where the well is located 
	 */
	private String county;

	/** 
	 * Full data source description 
	 */
	private String dataSource;

	/**
	 * Primary source/provider of well measurement data
	 */
	private String dataSourceAbbrev;
	
	/** 
	 * DWR Water Division 
	 */
	private int division;
	
	/** 
	 * Drainage Area 
	 */
	private Double drainArea;

	/** 
	 * Flag A 
	 */
	private String flagA;

	/** 
	 * Flag B 
	 */
	private String flagB;

	/**
	 * National Hydrographic Dataset stream identifier
	 */
	private String gnisId;

	/** 
	 * HUC 10 
	 */
	private String huc10;

	/** 
	 * Latitude (decimal degrees) 
	 */
	private Double latitude;

	/** 
	 * Accuracy of location coordinates 
	 */
	private String locationAccuracy;

	/** 
	 * Longitude (decimal degrees) 
	 */
	private Double longitude;

	/** 
	 * Measurement Date Time 
	 */
	private DateTime measDateTime;

	/** 
	 * Measurement Value 
	 */
	private Double measValue;

	/**
	 * Last date time that this record was modified in the DWR database
	 */
	private DateTime modified;

	/** 
	 * Hyperlink to additional details 
	 */
	private String moreInformation;

	/** 
	 * Parameter 
	 */
	private String parameter;

	/** 
	 * Recorded stage (feet) 
	 */
	private Double stage;

	/** 
	 * Station Name 
	 */
	private String stationName;

	/**
	 * Station of record end.
	 */
	private DateTime stationPorEnd;
	
	/**
	 * Station of record start.
	 */
	private DateTime stationPorStart;
	
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
	private Double streamMile;

	/** 
	 * Type of structure 
	 */
	private String structureType;

	/**
	 * Whether third party data.
	 */
	private Boolean thirdParty;
	
	/** 
	 * Units of measure 
	 */
	private String units;

	/** 
	 * USGS Station ID 
	 */
	private String usgsStationId;

	/** 
	 * The x (Easting) component of the Universal Transverse Mercator system 
	 * (Zone 12, NAD83 datum) 
	 */
	private Double utmX;
	
	/** 
	 * The y (Northing) component of the Universal Transverse Mercator system 
	 * (Zone 12, NAD83 datum) 
	 */
	private Double utmY;
	
	/** 
	 * DWR Water District 
	 */
	private int waterDistrict;

	/** 
	 * Water Source 
	 */
	private String waterSource;

	/** 
	 * DWR unique structure identifier
	 */
	private String wdid;
	
	/**
	 * Getters and setters of defined variables.
	 */
	public String getAbbrev() {
		return abbrev;
	}

	public Double getContrArea() {
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

	public Double getDrainArea() {
		return drainArea;
	}

	public String getFlagA() {
		return flagA;
	}

	public String getFlagB() {
		return flagB;
	}

	public String getGnisId() {
		return gnisId;
	}

	public String getHuc10() {
		return huc10;
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

	public DateTime getMeasDateTime() {
		return measDateTime;
	}

	public Double getMeasValue() {
		return measValue;
	}

	public DateTime getModified() {
		return modified;
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public String getParameter() {
		return parameter;
	}

	public Double getStage() {
		return stage;
	}

	public String getStationName() {
		return stationName;
	}

	public DateTime getStationPorEnd() {
		return stationPorEnd;
	}

	public DateTime getStationPorStart() {
		return stationPorStart;
	}

	public String getStationStatus() {
		return stationStatus;
	}

	public String getStationType() {
		return stationType;
	}

	public Double getStreamMile() {
		return streamMile;
	}

	public String getStructureType() {
		return structureType;
	}

	public Boolean getThirdParty() {
		return thirdParty;
	}

	public String getUnits() {
		return units;
	}

	public String getUsgsStationId() {
		return usgsStationId;
	}

	public Double getUtmX() {
		return utmX;
	}

	public Double getUtmY() {
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

	public void setContrArea(Double contrArea) {
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

	public void setDivision(int div) {
		this.division = div;
	}

	public void setDrainArea(Double drainArea) {
		this.drainArea = drainArea;
	}

	public void setFlagA(String flagA) {
		this.flagA = flagA;
	}

	public void setFlagB(String flagB) {
		this.flagB = flagB;
	}

	public void setGnisId(String gnisId) {
		this.gnisId = gnisId;
	}
	
	public void setHuc10(String huc10) {
		this.huc10 = huc10;
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

	public void setMeasDateTime(String measDateTime) {
		this.measDateTime = TimeToolkit.getInstance().toDateTime(measDateTime, true);
	}

	public void setMeasValue(Double measValue) {
		this.measValue = measValue;
	}

	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, true);
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public void setStage(Double stage) {
		this.stage = stage;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public void setStationPorEnd(String stationPorEnd) {
		this.stationPorEnd = TimeToolkit.getInstance().toDateTime(stationPorEnd, false);
	}
	public void setStationPorStart(String stationPorStart) {
		this.stationPorStart = TimeToolkit.getInstance().toDateTime(stationPorStart, false);
	}

	public void setStationStatus(String stationStatus) {
		this.stationStatus = stationStatus;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public void setStreamMile(Double streamMile) {
		this.streamMile = streamMile;
	}

	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}

	public void setThirdParty(Boolean thirdParty) {
		this.thirdParty = thirdParty;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public void setUsgsStationId(String usgsStationId) {
		this.usgsStationId = usgsStationId;
	}

	public void setUtmX(Double utmX) {
		this.utmX = utmX;
	}

	public void setUtmY(Double utmY) {
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
		return "TelemetryStation: [ div: " + division + ", wd: " + waterDistrict + ", county: " + county + ", stationName: " +
				stationName + ", dataSource: " + dataSource + ", abbrev: " + abbrev + ", usgsStationId: " +
				usgsStationId + ", stationStatus: " + stationStatus + ", stationType: " + stationType + 
				", strcutureType: " + structureType + ", measDateTime: " + measDateTime + ", parameter: " + 
				parameter + ", stage: " + stage + ", measValue: " + measValue + ", units: " + units + ", flagA" + 
				flagA + ", flagB: " + flagB + ", contrArea: " + contrArea + ", drainArea: " + drainArea + 
				", huc10: " + huc10 + ", utmX: " + utmX + ", utmY: " + utmY + ", latitude: " + latitude + 
				", longitude: " + longitude + ", locationAccuracy: " + locationAccuracy + ", wdid: " + wdid + 
				", modified: " + modified + ", moreInformation: " + moreInformation + " ]\n";
	}

}