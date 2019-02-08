// AnalysisServicesWaterSourceRouteAnalysis - data object for analysis services, source water route framework

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
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-analysisservices-watersourcerouteanalysis
 * @author jurentie
 *
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisServicesWaterSourceRouteAnalysis {
	
	/**
	 * Variables defined in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Feature Type
	 */
	private String featureType;
	
	/**
	 * GNIS ID
	 */
	private String gnisId;
	
	/**
	 * Stream Mile Number
	 */
	private double streamMile;
	
	/**
	 * Structure Name
	 */
	private String structureName;
	
	/**
	 * Structure Type
	 */
	private String structureType;
	
	/**
	 * DWR Unique Structure Identifier
	 */
	private String wdid;
	
	/**
	 * Getters and setters for defined variables
	 */
	public String getFeatureType() {
		return featureType;
	}
	public String getGnisId() {
		return gnisId;
	}
	public double getStreamMile() {
		return streamMile;
	}
	public String getStructureName() {
		return structureName;
	}
	public String getStructureType() {
		return structureType;
	}
	public String getWdid() {
		return wdid;
	}
	public void setFeatureType(String featureType) {
		this.featureType = featureType;
	}
	public void setGnisId(String gnisId) {
		this.gnisId = gnisId;
	}
	public void setStreamMile(double streamMile) {
		this.streamMile = streamMile;
	}
	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}
	public void setStructureType(String structureType) {
		this.structureType = structureType;
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
		return "AnalysisServicesWaterSourceRouteAnalysis: [ featureType: " + featureType + ", gnisId: " + ", streamMile: " + streamMile +
				", structureName: " + structureName + ", structureType: " + structureType + ", wdid: " + wdid + " ]\n";
	}

}
