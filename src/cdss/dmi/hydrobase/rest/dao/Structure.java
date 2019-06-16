// Structure - data object for structure

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

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures
 * @author jurentie
 *
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Structure {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */

	/** 
	 * Alternate names for structure
	 */
	private String associatedAkas;

	/** 
	 * Water court case number(s) associated with water right
	 */
	private String associatedCaseNumbers;

	/** 
	 * Contacts associated with structure
	 */
	private String associatedContacts;

	/**
	 * List of meters associated with WDID
	 */
	private String associatedMeters;

	/**
	 * List of well permits associated with WDID
	 */
	private String associatedPermits;

	/**
	 * Current in use code of structure
	 */
	private String ciuCode;

	/**
	 * Distance and direction from east/west section line (feet) 
	 */
	private Integer coordsew;

	/** 
	 * Direction of measurement from east/west section line 
	 */
	private String coordsewDir;

	/** 
	 * Distance and direction from north/south section line 
	 */
	private Integer coordsns;

	/** 
	 * Direction of measurement from north/south section line 
	 */
	private String coordsnsDir;

	/** 
	 * County where the well is located 
	 */
	private String county;

	/**
	 * Eight established geographic areas in Colorado's Eastern Plains 
	 * where users rely primarily on groundwater for water supply
	 */
	private String designatedBasinName;

	/** 
	 * DWR Water Division 
	 */
	private int division;

	/** 
	 * National Hydrographic Dataset stream identifier 
	 */
	private String  gnisId;

	/**
	 * Latitude value in decimal degrees 
	 */
	private Double latdecdeg;

	/** 
	 * Accuracy of location coordiantes
	 */
	private String locationAccuracy;

	/** 
	 * Longitude in decimal degrees 
	 */
	private Double longdecdeg;

	/**
	 * Thirteen local districts, within the Designated Basins, with 
	 * additional administrative authority
	 */
	private String managementDistrictName;

	/**
	 * Last date time that this record was modified in the DWR database
	 */
	private DateTime modified;

	/**
	 * Principal Meridian of wellâ€™s legal location - there are 5 principal 
	 * meridians in CO: Sixth (S), New Mexico (N), Baca (B), Costilla (C), 
	 * and Ute (U)
	 */
	private String pm;

	/**
	 * Date of last measurement in the wellâ€™s period of record
	 */
	private DateTime porEnd;

	/**
	 * Date of first measurement in the wellâ€™s period of record
	 */
	private DateTime porStart;

	/**
	 * Legal location: 10 acre quarter section
	 */
	private String q10;

	/**
	 * Legal location: 160 acre quarter section
	 */
	private String q160;

	/**
	 * Legal location: 40 acre quarter section
	 */
	private String q40;

	/**
	 * Legal location: A number in the format â€œnnndâ€� where â€œnnnâ€� is 
	 * the range number and â€œdâ€� is the direction either East or West
	 */
	private String range;

	/**
	 * Section number - township, range divided into 36 one square mile sections; 
	 * â€œUâ€� indicates location in Ute Correction (Division 7 only)
	 */
	private String section;

	/**
	 * Distance in miles to the confluence with the next downstream water source 
	 * (or distance to state line)
	 */
	private Double streamMile;

	/** 
	 * Name of Structure 
	 */
	private String structureName;
	
	/** 
	 * Type of Structure 
	 */
	private String structureType;
	
	/**
	 * User's association that the structure is included in
	 */
	private String subdistrict;

	/**
	 * Legal location: Township number and direction
	 */
	private String township;

	/**
	 * The x (Easting) component of the Universal Transverse Mercator system. 
	 * (Zone 12, NAD83 datum)
	 */
	private Double utmX;

	/** 
	 * The y (Northing) component of the Universal Transverse Mercator system. 
	 * (Zone 12, NAD83 datum) 
	 */
	private Double utmY;

	/**
	 * DWR Water District 
	 */
	private int waterDistrict;

	/**
	 * Name of the water source as specified in the court case
	 */
	private String waterSource;
	
	/**
	 * DWR unique structure identifier
	 */
	private String wdid;
	
	/**
	 * Getters and setters of defined variables
	 */
	public String getAssociatedAkas() {
		return associatedAkas;
	}

	public String getAssociatedCaseNumbers() {
		return associatedCaseNumbers;
	}

	public String getAssociatedContacts() {
		return associatedContacts;
	}

	public String getAssociatedMeters() {
		return associatedMeters;
	}

	public String getAssociatedPermits() {
		return associatedPermits;
	}

	public String getCiuCode() {
		return ciuCode;
	}

	public Integer getCoordsew() {
		return coordsew;
	}

	public String getCoordsewDir() {
		return coordsewDir;
	}

	public Integer getCoordsns() {
		return coordsns;
	}

	public String getCoordsnsDir() {
		return coordsnsDir;
	}

	public String getCounty() {
		return county;
	}

	public String getDesignatedBasinName() {
		return designatedBasinName;
	}

	public int getDivision() {
		return division;
	}

	public String getGnisId() {
		return gnisId;
	}

	public Double getLatdecdeg() {
		return latdecdeg;
	}

	public String getLocationAccuracy() {
		return locationAccuracy;
	}

	public Double getLongdecdeg() {
		return longdecdeg;
	}

	public String getManagementDistrictName() {
		return managementDistrictName;
	}

	public DateTime getModified() {
		return modified;
	}

	public String getPm() {
		return pm;
	}

	public DateTime getPorEnd() {
		return porEnd;
	}

	public DateTime getPorStart() {
		return porStart;
	}

	public String getQ10() {
		return q10;
	}

	public String getQ160() {
		return q160;
	}

	public String getQ40() {
		return q40;
	}

	public String getRange() {
		return range;
	}

	public String getSection() {
		return section;
	}

	public Double getStreamMile() {
		return streamMile;
	}

	public String getStructureName() {
		return structureName;
	}

	public String getStructureType() {
		return structureType;
	}

	public String getSubdistrict() {
		return subdistrict;
	}

	public String getTownship() {
		return township;
	}

	public Double getUtmX() {
		return utmX;
	}

	public Double getUtmY() {
		return utmY;
	}

	public int getWaterDistrict() {
		return waterDistrict;
	}

	public String getWaterSource() {
		return waterSource;
	}

	public String getWdid() {
		return wdid;
	}

	public void setAssociatedAkas(String associatedAkas) {
		this.associatedAkas = associatedAkas;
	}

	public void setAssociatedCaseNumbers(String associatedCaseNumbers) {
		this.associatedCaseNumbers = associatedCaseNumbers;
	}

	public void setAssociatedContacts(String associatedContacts) {
		this.associatedContacts = associatedContacts;
	}

	public void setAssociatedMeters(String associatedMeters) {
		this.associatedMeters = associatedMeters;
	}

	public void setAssociatedPermits(String associatedPermits) {
		this.associatedPermits = associatedPermits;
	}

	public void setCiuCode(String ciuCode) {
		this.ciuCode = ciuCode;
	}

	public void setCoordsew(Integer coordsew) {
		this.coordsew = coordsew;
	}

	public void setCoordsewDir(String coordsewDir) {
		this.coordsewDir = coordsewDir;
	}

	public void setCoordsns(Integer coordsns) {
		this.coordsns = coordsns;
	}

	public void setCoordsnsDir(String coordsnsDir) {
		this.coordsnsDir = coordsnsDir;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public void setDesignatedBasinName(String designatedBasinName) {
		this.designatedBasinName = designatedBasinName;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public void setGnisId(String gnisID) {
		this.gnisId = gnisID;
	}

	public void setLatdecdeg(Double latdecdeg) {
		this.latdecdeg = latdecdeg;
	}

	public void setLocationAccuracy(String locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
	}

	public void setLongdecdeg(Double longdecdeg) {
		this.longdecdeg = longdecdeg;
	}

	public void setManagementDistrictName(String managementDistrictName) {
		this.managementDistrictName = managementDistrictName;
	}

	public void setModified(String modified) {
		this.modified = (modified == null) ? null : TimeToolkit.getInstance().toDateTime(modified, false);
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public void setPorEnd(String porEnd) {
		this.porEnd = (porEnd == null) ? null : TimeToolkit.getInstance().toDateTime(porEnd, false);
	}

	public void setPorStart(String porStart) {
		this.porStart = (porStart == null) ? null : TimeToolkit.getInstance().toDateTime(porStart, false);
	}

	public void setQ10(String q10) {
		this.q10 = q10;
	}

	public void setQ160(String q160) {
		this.q160 = q160;
	}

	public void setQ40(String q40) {
		this.q40 = q40;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public void setStreamMile(Double streamMile) {
		this.streamMile = streamMile;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}

	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}

	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public void setUtmX(Double utmX) {
		this.utmX = utmX;
	}

	public void setUtmY(Double utmY) {
		this.utmY = utmY;
	}

	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}

	public void setWaterSource(String waterSource) {
		this.waterSource = waterSource;
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
		return "Structure: [ wdid: " + wdid + ", structureName: " + structureName + ", associatedAkas: " +
				associatedAkas + ", ciuCode: " + ciuCode + ", structureType: " + structureType + ", waterSource: " +
				waterSource + ", gnisId: " + gnisId + ", streamMile: " + ", associatedCaseNumbers: " + associatedCaseNumbers +
				", associatedPermits: " + associatedPermits + ", associatedMeters: " + ", associatedContacts: " + 
				associatedContacts + ", porStart: " + porStart + ", porEnd: " + porEnd + ", division: " + division +
				", waterDistrict: " + waterDistrict + ", subdistrict: " + subdistrict + ", county: " + county + 
				", designatedBasinName: " + designatedBasinName + ", managementDistrictName: " + managementDistrictName + 
				", pm: " + pm + ", township: " + township + ", range: " + range + ", section: " + section +
				", q10: " + q10 + ", q40: " + q40 + ", q160:  " + q160 + ", coordsew: " + coordsew + ", coordsewDir: " +
				coordsewDir + ", coordsns: " + coordsns + ", coordsnsDir: " + coordsnsDir + ", utmX: " + utmX + ", utmY: " +
				utmY + ", latdecdeg: " + latdecdeg + ", longdecdeg: " + longdecdeg + ", locationAccuracy: " 
				+ locationAccuracy + ", modified: " + modified + " ]\n";
	}
	
}