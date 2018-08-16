package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-analysisservices-watersourcerouteanalysis
 * @author jurentie
 *
 */

/**
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
	public void setFeatureType(String featureType) {
		this.featureType = featureType;
	}
	public String getGnisId() {
		return gnisId;
	}
	public void setGnisId(String gnisId) {
		this.gnisId = gnisId;
	}
	public double getStreamMile() {
		return streamMile;
	}
	public void setStreamMile(double streamMile) {
		this.streamMile = streamMile;
	}
	public String getStructureName() {
		return structureName;
	}
	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}
	public String getStructureType() {
		return structureType;
	}
	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}
	public String getWdid() {
		return wdid;
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
				", structureName: " + structureName + ", structureType: " + structureType + ", wdid: " + wdid + " ]";
	}

}
