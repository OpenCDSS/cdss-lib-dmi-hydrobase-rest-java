package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParcelUseTimeSeries {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see:
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures-parcelusets-wdid
	 */
	
	/* WDID */
	private String wdid;
	
	/* Name of associated structure */
	private String structureName;
	
	/* Calendar Year */
	private int calYear;
	
	/* Parcel ID */
	private int parcelId;
	
	/* Parcel land use */
	private String landUse;
	
	/* Irrigation Type */
	private String irrigType;
	
	/* Prorated number of acres */
	private double acresProrated;
	
	/* Total number of acres */
	private double acresTotal;
	
	/* Associated surface water WDID */
	private String assocSwWdid;
	
	/* Associated ground water WDID */
	private String assocGwWdid;
	
	/* Modified date/time */
	private LocalDateTime modified;

	public String getWdid() {
		return wdid;
	}

	public void setWdid(String wdid) {
		this.wdid = wdid;
	}

	public String getStructureName() {
		return structureName;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}

	public int getCalYear() {
		return calYear;
	}

	public void setCalYear(int calYear) {
		this.calYear = calYear;
	}

	public int getParcelId() {
		return parcelId;
	}

	public void setParcelId(int parcelId) {
		this.parcelId = parcelId;
	}

	public String getLandUse() {
		return landUse;
	}

	public void setLandUse(String landUse) {
		this.landUse = landUse;
	}

	public String getIrrigType() {
		return irrigType;
	}

	public void setIrrigType(String irrigType) {
		this.irrigType = irrigType;
	}

	public double getAcresProrated() {
		return acresProrated;
	}

	public void setAcresProrated(double acresProrated) {
		this.acresProrated = acresProrated;
	}

	public double getAcresTotal() {
		return acresTotal;
	}

	public void setAcresTotal(double acresTotal) {
		this.acresTotal = acresTotal;
	}

	public String getAssocSwWdid() {
		return assocSwWdid;
	}

	public void setAssocSwWdid(String assocSwWdid) {
		this.assocSwWdid = assocSwWdid;
	}

	public String getAssocGwWdid() {
		return assocGwWdid;
	}

	public void setAssocGwWdid(String assocGwWdid) {
		this.assocGwWdid = assocGwWdid;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = LocalDateTime.parse(modified);
	}
	
	@Override
	public String toString(){
		return "ParcelUseTimeSeries: [ wdid: " + wdid + ", structureName: " + structureName + ", calYear: " + 
				calYear + ", parcelId:  " + parcelId + ", landUse: " + landUse + ", irrigType: " + irrigType +
				", acresProrated: " + acresProrated + ", acresTotal: " + acresTotal + ", assocSwWdid: " +
				assocSwWdid + ", assocGwWdid: " + assocGwWdid + ", modified: " + modified + " ]";
	}

}
