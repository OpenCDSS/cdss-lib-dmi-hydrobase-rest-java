package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-divrecobservationcodes
 * @author jurentie
 *
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceTablesDivRecObservationCodes {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Ending Irrigation Year
	 */
	private int endIyr;
	
	/**
	 * Observation Code
	 */
	private String obsCode;
	
	/**
	 * Long version of the Observation Code
	 */
	private String obsCodeLong;
	
	/**
	 * Observation Code Description
	 */
	private String obsDescr;
	
	/**
	 * Starting Irrigation Year
	 */
	private int startIyr;
	
	/**
	 * Getters and setters of defined variables
	 */
	public int getEndIyr() {
		return endIyr;
	}
	public String getObsCode() {
		return obsCode;
	}
	public String getObsCodeLong() {
		return obsCodeLong;
	}
	public String getObsDescr() {
		return obsDescr;
	}
	public int getStartIyr() {
		return startIyr;
	}
	public void setEndIyr(int endIyr) {
		this.endIyr = endIyr;
	}
	public void setObsCode(String obsCode) {
		this.obsCode = obsCode;
	}
	public void setObsCodeLong(String obsCodeLong) {
		this.obsCodeLong = obsCodeLong;
	}
	public void setObsDescr(String obsDescr) {
		this.obsDescr = obsDescr;
	}
	public void setStartIyr(int startIyr) {
		this.startIyr = startIyr;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "ReferenceTablesDivRecObservationCodes: [obsCode: " + obsCode + ", startIyr: " + startIyr + ", endIyr: " + endIyr + 
				", obsCodeLong: " + obsCodeLong + ", obsDescr: " + obsDescr + "]\n";
	}

}
