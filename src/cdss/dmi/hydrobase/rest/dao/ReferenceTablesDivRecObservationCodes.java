// ReferenceTablesDivRecObservationCodes - data object for reference table, diversion record observation code

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
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-divrecobservationcodes
 * @author jurentie
 *
 */
/*
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
	 * Ending irrigation year (Nov-Oct) for obsCode use.
	 */
	private Integer endIyr;
	
	/**
	 * Observation code (e.g., "E").
	 */
	private String obsCode;
	
	/**
	 * Long version of the observation code (e.g., "Estimated").
	 */
	private String obsCodeLong;
	
	/**
	 * Observation code description, can vary depending on startIyr and endIyr.
	 */
	private String obsDescr;
	
	/**
	 * Starting irrigation year (Nov-Oct) for observation code.
	 */
	private Integer startIyr;
	
	/**
	 * Getters and setters of defined variables
	 */
	public Integer getEndIyr() {
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

	public Integer getStartIyr() {
		return startIyr;
	}

	public void setEndIyr(Integer endIyr) {
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

	public void setStartIyr(Integer startIyr) {
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