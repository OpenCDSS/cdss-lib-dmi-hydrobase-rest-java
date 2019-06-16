// AnalysisServicesWaterSourceRouteFramework - data object for analysis services, source water route framework

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

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-analysisservices-watersourcerouteframework
 * @author jurentie
 *
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisServicesWaterSourceRouteFramework {
	
	/**
	 * Variables defined in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * DWR Water Division
	 */
	private int division;
	
	/**
	 * National Hydrographic Dataset Stream Identifier
	 */
	private String gnisId;
	
	/**
	 * GNIS Name
	 */
	private String gnisName;
	
	/**
	 * Stream Length
	 */
	private Double streamLength;
	
	/**
	 * Tributary GNIS Name
	 */
	private String tribGnisName;
	
	/**
	 * Tributary To GNIS ID
	 */
	private String TributaryToGnisId;
	
	/**
	 * Tributary To Level
	 */
	private Integer tributaryToLevel;
	
	/**
	 * Tributary To Stream Mile
	 */
	private Double tributaryToStreamMile;
	
	/**
	 * DWR Water District
	 */
	private int waterDistrict;
	
	/**
	 * Getters and setters for defined variables.
	 */
	public int getDivision() {
		return division;
	}
	public String getGnisId() {
		return gnisId;
	}
	
	public String getGnisName() {
		return gnisName;
	}
	public Double getStreamLength() {
		return streamLength;
	}
	
	public String getTribGnisName() {
		return tribGnisName;
	}
	public String getTributaryToGnisId() {
		return TributaryToGnisId;
	}
	
	public Integer getTributaryToLevel() {
		return tributaryToLevel;
	}
	public Double getTributaryToStreamMile() {
		return tributaryToStreamMile;
	}
	
	public int getWaterDistrict() {
		return waterDistrict;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	
	public void setGnisId(String gnisId) {
		this.gnisId = gnisId;
	}
	public void setGnisName(String gnisName) {
		this.gnisName = gnisName;
	}
	
	public void setStreamLength(Double streamLength) {
		this.streamLength = streamLength;
	}
	public void setTribGnisName(String tribGnisName) {
		this.tribGnisName = tribGnisName;
	}
	
	public void setTributaryToGnisId(String tributaryToGnisId) {
		TributaryToGnisId = tributaryToGnisId;
	}
	public void setTributaryToLevel(Integer tributaryToLevel) {
		this.tributaryToLevel = tributaryToLevel;
	}
	
	public void setTributaryToStreamMile(Double tributaryToStreamMile) {
		this.tributaryToStreamMile = tributaryToStreamMile;
	}
	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "AnalysisServicesWaterSourceRouteFramework: [ division: " + division + ", waterDistrict: " + waterDistrict + 
				", gnisId: " + gnisId + ", streamLength: " + streamLength + ", tributaryToLevel: " + tributaryToLevel + 
				", TributaryToGnisId: " + TributaryToGnisId + ", tribGnisName: " + tribGnisName + ", tributaryToStreamMile: " +
				tributaryToStreamMile + " ]\n";
	}

}