package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures-divrec-comments-wdid
 * @author jurentie
 *
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiversionComments {
	
	/**
	 * Variables defined in alphabetical order.
	 * Documentation copied from web services.
	 */

	/**
	 * Approval status of comment 
	 */
	private String approvalStatus;
	
	/**
	 * Irrigation year comments 
	 */
	private String comment;
	
	/** 
	 * Type of comment 
	 */
	private String commentType;
	
	/** 
	 * Irrigation year (Nov 1 to Oct31) 
	 */
	private int irrYear;
	
	/** 
	 * Modified date/time 
	 */
	private DateTime modified;
	
	/** 
	 * Not used code 
	 */
	private String notUsed;
	
	/** 
	 * Not used code description 
	 */
	private String notUsedDescr;
	
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
	public String getComment() {
		return comment;
	}

	public String getCommentType() {
		return commentType;
	}
	public int getIrrYear() {
		return irrYear;
	}

	public DateTime getModified() {
		return modified;
	}
	public String getNotUsed() {
		return notUsed;
	}

	public String getNotUsedDescr() {
		return notUsedDescr;
	}
	public String getWdid() {
		return wdid;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}
	public void setIrrYear(int irrYear) {
		this.irrYear = irrYear;
	}

	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, false);
	}
	public void setNotUsed(String notUsed) {
		this.notUsed = notUsed;
	}

	public void setNotUsedDescr(String notUsedDescr) {
		this.notUsedDescr = notUsedDescr;
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
		return "DiversionComment: [ wdid: " + wdid + ", commentType: " + commentType + ", irrYear: " + 
				irrYear + ", notUsed: " + notUsed + ", notUsedDescr: " + notUsedDescr + ", comment: " + 
				comment + ", approvalStatus: " + approvalStatus + ", modified: " + modified + " ]\n";
	}
	
}
