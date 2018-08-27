package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures-divrec-stagevolume-wdid
 * @author jurentie
 *
 */

/**
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
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "stageVolume : [ wdid: " + wdid + ", dataMeasDate: " + dataMeasDate + ", stage: " + 
				stage + ", volume: " + volume + ", approvalStatus: " + approvalStatus + ", modified: " +
				modified;
	}

}
