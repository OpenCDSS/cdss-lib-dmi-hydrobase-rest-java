package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures-parcelusets-wdid
 * @author jurentie
 *
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParcelUseTimeSeries {
	
	/**
	 * Structures 
	 */
	private double acresProrated;

	/**
	 * Total number of acres 
	 */
	private double acresTotal;

	/**
	 * Associated ground water WDID 
	 */
	private String assocGwWdid;

	/**
	 * Associated surface water WDID 
	 */
	private String assocSwWdid;

	/** 
	 * Calendar Year 
	 */
	private int calYear;

	/**
	 * Not on web services but added in order to sort by div
	 * in comparable method
	 */
	private int div;

	/**
	 * Irrigation Type 
	 */
	private String irrigType;

	/**
	 * Parcel land use 
	 */
	private String landUse;

	/**
	 * Modified date/time 
	 */
	private DateTime modified;

	/**
	 * Parcel ID 
	 */
	private int parcelId;

	/**
	 * Name of associated structure 
	 */
	private String structureName;
	
	/**
	 * WDID 
	 */
	private String wdid;
	
	/**
	 * Getters and setters for declared variables
	 */
	public double getAcresProrated() {
		return acresProrated;
	}

	public double getAcresTotal() {
		return acresTotal;
	}

	public String getAssocGwWdid() {
		return assocGwWdid;
	}

	public String getAssocSwWdid() {
		return assocSwWdid;
	}

	public int getCalYear() {
		return calYear;
	}

	public int getDiv() {
		return div;
	}

	public String getIrrigType() {
		return irrigType;
	}

	public String getLandUse() {
		return landUse;
	}

	public DateTime getModified() {
		return modified;
	}

	public int getParcelId() {
		return parcelId;
	}

	public String getStructureName() {
		return structureName;
	}

	public String getWdid() {
		return wdid;
	}

	public void setAcresProrated(double acresProrated) {
		this.acresProrated = acresProrated;
	}

	public void setAcresTotal(double acresTotal) {
		this.acresTotal = acresTotal;
	}

	public void setAssocGwWdid(String assocGwWdid) {
		this.assocGwWdid = assocGwWdid;
	}

	public void setAssocSwWdid(String assocSwWdid) {
		this.assocSwWdid = assocSwWdid;
	}

	public void setCalYear(int calYear) {
		this.calYear = calYear;
	}

	public void setDiv(int div) {
		this.div = div;
	}

	public void setIrrigType(String irrigType) {
		this.irrigType = irrigType;
	}

	public void setLandUse(String landUse) {
		this.landUse = landUse;
	}

	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, false);
	}

	public void setParcelId(int parcelId) {
		this.parcelId = parcelId;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
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
		return "ParcelUseTimeSeries: [ wdid: " + wdid + ", div " + div + ", structureName: " + structureName + ", calYear: " + 
				calYear + ", parcelId:  " + parcelId + ", landUse: " + landUse + ", irrigType: " + irrigType +
				", acresProrated: " + acresProrated + ", acresTotal: " + acresTotal + ", assocSwWdid: " +
				assocSwWdid + ", assocGwWdid: " + assocGwWdid + ", modified: " + modified + " ]\n";
	}

}
