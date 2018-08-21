package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-diversionnotusedcodes
 * @author jurentie
 *
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceTablesDiversionNotUsedCodes {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Code/reason if structure is not used
	 */
	private String notUsedCode;
	
	/**
	 * Water Class description
	 */
	private String notUsedCodeDescr;
	
	/**
	 * Getters and setters of defined variables
	 */
	public String getNotUsedCode() {
		return notUsedCode;
	}
	public String getNotUsedCodeDescr() {
		return notUsedCodeDescr;
	}
	public void setNotUsedCode(String notUsedCode) {
		this.notUsedCode = notUsedCode;
	}
	public void setNotUsedCodeDescr(String notUsedCodeDescr) {
		this.notUsedCodeDescr = notUsedCodeDescr;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "ReferenceTablesDiversionNotUsedCodes: [ notUsedCode: " + notUsedCode + ", notUsedCodeDescr: " + notUsedCodeDescr + "]";
	}

}
