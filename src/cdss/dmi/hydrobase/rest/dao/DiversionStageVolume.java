package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

public class DiversionStageVolume {
	
	/**
	 * Variables declared in order as returned
	 * by DWR API. For more detail see: 
	 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures-divrec-stagevolume-wdid
	 */
	
	/* WDID */
	private String wdid;
	
	/* Date/time of measurement */
	private LocalDateTime dataMeasDate;
	
	/* Recorded stage (feet) */
	private double stage;
	
	/* Recorded volume (AF) */
	private double volume;
	
	/* Status of approval */
	private String approvalStatus;
	
	/* Modified date/time */
	private LocalDateTime modified;

	public String getWdid() {
		return wdid;
	}

	public void setWdid(String wdid) {
		this.wdid = wdid;
	}

	public LocalDateTime getDataMeasDate() {
		return dataMeasDate;
	}

	public void setDataMeasDate(String dataMeasDate) {
		this.dataMeasDate = LocalDateTime.parse(dataMeasDate);
	}

	public double getStage() {
		return stage;
	}

	public void setStage(double stage) {
		this.stage = stage;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = LocalDateTime.parse(modified);
	}
	
	@Override
	public String toString(){
		return "stageVolume : [ wdid: " + wdid + ", dataMeasDate: " + dataMeasDate + ", stage: " + 
				stage + ", volume: " + volume + ", approvalStatus: " + approvalStatus + ", modified: " +
				modified;
	}

}
