package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

public class DiversionWaterClass {
	
	/**
	 * Variables declared in order as returned
	 * by DWR API. For more detail see: 
	 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures-divrec-waterclasses
	 */

	/* Type of diversion records */
	private String divrectype;
	
	/* WaterClass Number */
	private int waterclassNum;
	
	/* WaterClass Identifier */
	private String wcIdentifier;
	
	/* WDID of the associated structure */
	private String wdid;
	
	/* WDID account ID */
	private int wdidAcctId;
	
	/* Name of the associated structure */
	private String structureName;
	
	/* WDID account Name */
	private int wdidAcctName;
	
	/* Source code */
	private String sourceCode;
	
	/* Source description */
	private String sourceDescr;
	
	/* From WDID */
	private String fromWdid;
	
	/* From WDID Account ID */
	private int fromWdidAcctId;
	
	/* From structure name */
	private String fromStructureName;
	
	/* From WDID account name */
	private int fromWdidAcctName;
	
	/* Use code */
	private String useCode;
	
	/* Use description */
	private String useDescr;
	
	/* Type code */
	private String typeCode;
	
	/* Type description */
	private String typeDescr;
	
	/* group WDID */
	private String groupWdid;
	
	/* Group structure name */
	private String groupStructureName;
	
	/* To WDID */
	private String toWdid;
	
	/* To WDID account ID */
	private int toWdidAcctId;
	
	/* To structure name */
	private String toStructureName;
	
	/* To WDID account name */
	private int toWdidAcctName;
	
	/* WaterClass description */
	private String wcDescr;
	
	/* Year of First Measurement */
	private int porStart;
	
	/* Year of Last Measurement */
	private int porEnd;
	
	/* Date Last Modified */
	private LocalDateTime porLastModified;
	
	/* DWR Water Division */
	private int division;
	
	/* DWR Water District */
	private int waterDistrict;
	
	/* County */
	private String county;
	
	/* Modified date/time */
	private LocalDateTime modified;

	public String getDivrectype() {
		return divrectype;
	}

	public void setDivrectype(String divrectype) {
		this.divrectype = divrectype;
	}

	public int getWaterclassNum() {
		return waterclassNum;
	}

	public void setWaterclassNum(int waterclassNum) {
		this.waterclassNum = waterclassNum;
	}

	public String getWcIdentifier() {
		return wcIdentifier;
	}

	public void setWcIdentifier(String wcIdentifier) {
		this.wcIdentifier = wcIdentifier;
	}

	public String getWdid() {
		return wdid;
	}

	public void setWdid(String wdid) {
		this.wdid = wdid;
	}

	public int getWdidAcctId() {
		return wdidAcctId;
	}

	public void setWdidAcctId(int wdidAcctId) {
		this.wdidAcctId = wdidAcctId;
	}

	public String getStructureName() {
		return structureName;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}

	public int getWdidAcctName() {
		return wdidAcctName;
	}

	public void setWdidAcctName(int wdidAcctName) {
		this.wdidAcctName = wdidAcctName;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceDescr() {
		return sourceDescr;
	}

	public void setSourceDescr(String sourceDescr) {
		this.sourceDescr = sourceDescr;
	}

	public String getFromWdid() {
		return fromWdid;
	}

	public void setFromWdid(String fromWdid) {
		this.fromWdid = fromWdid;
	}

	public int getFromWdidAcctId() {
		return fromWdidAcctId;
	}

	public void setFromWdidAcctId(int fromWdidAcctId) {
		this.fromWdidAcctId = fromWdidAcctId;
	}

	public String getFromStructureName() {
		return fromStructureName;
	}

	public void setFromStructureName(String fromStructureName) {
		this.fromStructureName = fromStructureName;
	}

	public int getFromWdidAcctName() {
		return fromWdidAcctName;
	}

	public void setFromWdidAcctName(int fromWdidAcctName) {
		this.fromWdidAcctName = fromWdidAcctName;
	}

	public String getUseCode() {
		return useCode;
	}

	public void setUseCode(String useCode) {
		this.useCode = useCode;
	}

	public String getUseDescr() {
		return useDescr;
	}

	public void setUseDescr(String useDescr) {
		this.useDescr = useDescr;
	}
	
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeDescr() {
		return typeDescr;
	}

	public void setTypeDescr(String typeDescr) {
		this.typeDescr = typeDescr;
	}

	public String getGroupWdid() {
		return groupWdid;
	}

	public void setGroupWdid(String groupWdid) {
		this.groupWdid = groupWdid;
	}

	public String getGroupStructureName() {
		return groupStructureName;
	}

	public void setGroupStructureName(String groupStructureName) {
		this.groupStructureName = groupStructureName;
	}

	public String getToWdid() {
		return toWdid;
	}

	public void setToWdid(String toWdid) {
		this.toWdid = toWdid;
	}

	public int getToWdidAcctId() {
		return toWdidAcctId;
	}

	public void setToWdidAcctId(int toWdidAcctId) {
		this.toWdidAcctId = toWdidAcctId;
	}

	public String getToStructureName() {
		return toStructureName;
	}

	public void setToStructureName(String toStructureName) {
		this.toStructureName = toStructureName;
	}

	public int getToWdidAcctName() {
		return toWdidAcctName;
	}

	public void setToWdidAcctName(int toWdidAcctName) {
		this.toWdidAcctName = toWdidAcctName;
	}

	public String getWcDescr() {
		return wcDescr;
	}

	public void setWcDescr(String wcDescr) {
		this.wcDescr = wcDescr;
	}

	public int getPorStart() {
		return porStart;
	}

	public void setPorStart(int porStart) {
		this.porStart = porStart;
	}

	public int getPorEnd() {
		return porEnd;
	}

	public void setPorEnd(int porEnd) {
		this.porEnd = porEnd;
	}

	public LocalDateTime getPorLastModified() {
		return porLastModified;
	}

	public void setPorLastModified(String porLastModified) {
		this.porLastModified = LocalDateTime.parse(porLastModified);
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public int getWaterDistrict() {
		return waterDistrict;
	}

	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = LocalDateTime.parse(modified);
	}
	
	@Override 
	public String toString(){
		return "WaterClass: [ divrectype: " + divrectype + ", waterclassNum: " + waterclassNum + ", wcIdentifier: " +
				wcIdentifier + ", wdid: " + wdid + ", wdidAcctId: " + wdidAcctId + ", structureName: " +
				structureName + ", wdidAcctName: " + wdidAcctName + ", sourceCode: " + sourceCode + ", sourceDescr: " +
				sourceDescr + ", fromWdid: " + fromWdid + ", fromWdidAcctId: " + fromWdidAcctId + ", fromStructureName: " +
				fromStructureName + ", fromWdidAcctName: " + fromWdidAcctName + ", useCode: " + useCode + ", useDescr: " +
				useDescr + ", typeCode: " + typeCode + ", typeDescr: " + typeDescr + ", groupWdid: " + groupWdid +
				", groupStructureName: " + groupStructureName + ", toWdid: " + toWdid + ", toWdidAcctId: " +
				toWdidAcctId + ", toStructureName: " + toStructureName + ", toWdidAcctName: " + toWdidAcctName +
				", wcDescr: " + wcDescr + ", porStart: " + porStart + ", porEnd: " + porEnd + ", porLastModified: " +
				porLastModified + ", division: " + division + ", waterDistrict: " + waterDistrict + ", county: " +
				county + ", modified: " + modified + " ]";
	}
	
}
