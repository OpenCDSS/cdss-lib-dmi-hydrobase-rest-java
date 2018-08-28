package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-analysisservices-watersourcerouteframework
 * @author jurentie
 *
 */

/**
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
	private double streamLength;
	
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
	private int tributaryToLevel;
	
	/**
	 * Tributary To Stream Mile
	 */
	private double tributaryToStreamMile;
	
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
	public double getStreamLength() {
		return streamLength;
	}
	
	public String getTribGnisName() {
		return tribGnisName;
	}
	public String getTributaryToGnisId() {
		return TributaryToGnisId;
	}
	
	public int getTributaryToLevel() {
		return tributaryToLevel;
	}
	public double getTributaryToStreamMile() {
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
	
	public void setStreamLength(double streamLength) {
		this.streamLength = streamLength;
	}
	public void setTribGnisName(String tribGnisName) {
		this.tribGnisName = tribGnisName;
	}
	
	public void setTributaryToGnisId(String tributaryToGnisId) {
		TributaryToGnisId = tributaryToGnisId;
	}
	public void setTributaryToLevel(int tributaryToLevel) {
		this.tributaryToLevel = tributaryToLevel;
	}
	
	public void setTributaryToStreamMile(double tributaryToStreamMile) {
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
