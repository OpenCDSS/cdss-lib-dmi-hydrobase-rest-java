// DiversionStageVolume - data object for diversion record stage/volume record (for reservoir)

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

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures-divrec-stagevolume-wdid
 * @author jurentie
 *
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiversionStageVolume {
	
	/**
	 * Variables defined in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Status of approval 
	 */
	private String approvalStatus;
	
	/**
	 * Date/time of measurement 
	 */
	private DateTime dataMeasDate;
	
	/**
	 * Modified date/time 
	 */
	private DateTime modified;
	
	/**
	 * Recorded stage (feet) 
	 */
	private double stage;
	
	/** 
	 * Recorded volume (AF) 
	 */
	private double volume;

	/**
	 * WDID 
	 */
	private String wdid;
	
	
	/**
	 * Getters and setters for defined variables.
	 */
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public DateTime getDataMeasDate() {
		return dataMeasDate;
	}

	public DateTime getModified() {
		return modified;
	}
	public double getStage() {
		return stage;
	}

	public double getVolume() {
		return volume;
	}
	public String getWdid() {
		return wdid;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public void setDataMeasDate(String dataMeasDate) {
		this.dataMeasDate = TimeToolkit.getInstance().toDateTime(dataMeasDate, false);
	}

	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, false);
	}
	public void setStage(double stage) {
		this.stage = stage;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	public void setWdid(String wdid) {
		this.wdid = wdid;
	}
	
	public int getYear(){
		return dataMeasDate.getYear();
	}
	
	public int getMonth(){
		return dataMeasDate.getMonth();
	}
	
	public int getDay(){
		return dataMeasDate.getDay();
	}
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "stageVolume : [ wdid: " + wdid + ", dataMeasDate: " + dataMeasDate + ", stage: " + 
				stage + ", volume: " + volume + ", approvalStatus: " + approvalStatus + ", modified: " +
				modified + " ]\n";
	}

}
