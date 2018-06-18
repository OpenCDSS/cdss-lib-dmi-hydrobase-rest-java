package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

public class DiversionComment {
	
	/**
	 * Variables declared in order as returned
	 * by DWR API. For more detail see: 
	 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures-divrec-comments-wdid
	 */

	/* WDID */
	private String wdid;
	
	/* Type of comment */
	private String commentType;
	
	/* Irrigation year (Nov 1 to Oct31) */
	private int irrYear;
	
	/* Not used code */
	private String notUsed;
	
	/* Not used code description */
	private String notUsedDescr;
	
	/* Irrigation year comments */
	private String comment;
	
	/* Approval status of comment */
	private String approvalStatus;
	
	/* Modified date/time */
	private LocalDateTime modified;

	public String getWdid() {
		return wdid;
	}

	public void setWdid(String wdid) {
		this.wdid = wdid;
	}

	public String getCommentType() {
		return commentType;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}

	public int getIrrYear() {
		return irrYear;
	}

	public void setIrrYear(int irrYear) {
		this.irrYear = irrYear;
	}

	public String getNotUsed() {
		return notUsed;
	}

	public void setNotUsed(String notUsed) {
		this.notUsed = notUsed;
	}

	public String getNotUsedDescr() {
		return notUsedDescr;
	}

	public void setNotUsedDescr(String notUsedDescr) {
		this.notUsedDescr = notUsedDescr;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		return "DiversionComment: [ wdid: " + wdid + ", commentType: " + commentType + ", irrYear: " + 
				irrYear + ", notUsed: " + notUsed + ", notUsedDescr: " + notUsedDescr + ", comment: " + 
				comment + ", approvalStatus: " + approvalStatus + ", modified: " + modified + " ]";
	}
	
}
