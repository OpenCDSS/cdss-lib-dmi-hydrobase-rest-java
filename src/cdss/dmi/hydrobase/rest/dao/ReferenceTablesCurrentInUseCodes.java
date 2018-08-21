package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-currentinusecodes
 * @author jurentie
 *
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceTablesCurrentInUseCodes {
	
	/**
	 * Variables defined in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Current in use code of structure
	 */
	private String ciuCode;
	
	/**
	 * Long version of the Current in Use Code
	 */
	private String ciuCodeLong;
	
	/**
	 * Getters and setters of defined variables
	 */
	public String getCiuCode() {
		return ciuCode;
	}
	public void setCiuCode(String ciuCode) {
		this.ciuCode = ciuCode;
	}
	public String getCiuCodeLong() {
		return ciuCodeLong;
	}
	public void setCiuCodeLong(String ciuCodeLong) {
		this.ciuCodeLong = ciuCodeLong;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "ReferenceTablesCurrentInUse: [ciuCode: " + ciuCode + ", ciuCodeLong: " + ciuCodeLong + "]";
	}

}
