package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-structures-divrec-waterclasses
 * @author jurentie
 *
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiversionWaterClass {
	
	/**
	 * Available Timesteps 
	 */
	private String availableTimesteps;

	/**
	 * Current in use code of structure
	 */
	private String ciuCode;
	
	/**
	 * Long version of the current in use code
	 */
	private String ciuCodeLong;
	
	/**
	 * Distance and direction from East/West section line (feet)
	 */
	private int coordsew;
	
	/**
	 * Direction of measurement from East/West section line
	 */
	private String coordsewDir;
	
	
	/**
	 * Distance and direction from North/South section line (feet)
	 */
	private int coordsns;
	
	/**
	 * Direction of measurement from North/South section line
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
	 * Type of record: diversion; stage/volume; or comment
	 */
	private String divrectype;
	
	/**
	 * Name of structure that water is From in SFUTG coding
	 */
	private String fromStructureName;
	
	/**
	 * WDID of structure that water is From in SFUTG coding
	 */
	private String fromWdid;
	
	/**
	 * Account number of water class that water is From in SFUTG coding
	 */
	private int fromWdidAcctId;
	
	/**
	 * Account name of water class that water is From in SFUTG coding
	 */
	private int fromWdidAcctName;
	
	/**
	 * National Hydrographic Dataset stream identifier
	 */
	private String gnisId;
	
	/**
	 * Name of Group structure in SFUTG coding
	 */
	private String groupStructureName;
	
	/**
	 * WDID of Group structure in SFUTG coding
	 */
	private String groupWdid;
	
	/**
	 * Latitude value in decimal degrees
	 */
	private double latdecdeg;
	
	/**
	 * Longitude (decimal degrees)
	 */
	private double longdecdeg;
	
	/**
	 * Thirteen local districts, within the Designated Basins,
	 * with additional administrative authority
	 */
	private String managementDistrictName;
	
	/**
	 * Last date time that this record was modified in the DWR 
	 * database
	 */
	private DateTime modified;
	
	/**
	 * Principal Meridian of well’s legal location - there are 5 principal 
	 * meridians in CO: Sixth (S), New Mexico (N), Baca (B), Costilla (C), 
	 * and Ute (U)
	 */
	private String pm;
	
	/**
	 * Date of last measurement in the well's period of record
	 */
	private DateTime porEnd;
	
	/**
	 * Date last modified
	 */
	private DateTime porLastModified;
	
	/**
	 * Date of first measurement in the well's period of record
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
	 * Legal location: A number in the format “nnnd” where “nnn” 
	 * is the range number and “d” is the direction either East or West
	 */
	private String range;
	
	/**
	 * Section number - township, range divided into 36 one square mile sections; 
	 * “U” indicates location in Ute Correction (Division 7 only)
	 */
	private String section;
	
	/**
	 * Source Code
	 */
	private String sourceCode;
	
	/**
	 * Source description
	 */
	private String sourceDescr;
	
	/**
	 * Distance in miles to the confluence with the next downstream water 
	 * source (or distance to state line)
	 */
	private double streamMile;
	
	/**
	 * Name of structure
	 */
	private String structureName;
	
	/**
	 * Type of structure
	 */
	private String structureType;
	
	/**
	 * User's association that the structure is included in
	 */
	private String subdistrict;
	
	/**
	 * ???
	 */
	private String timeStep;
	
	/**
	 * To structure name
	 */
	private String toStructureName;
	
	/**
	 * To WDID
	 */
	private String toWdid;
	
	/**
	 * To WDID account ID
	 */
	private int toWdidAcctId;
	
	/**
	 * To WDID account Name
	 */
	private int toWdidAcctName;
	
	/**
	 * Legal location: Township number and direction
	 */
	private String township;
	
	/**
	 * Type code
	 */
	private String typeCode;
	
	/**
	 * Type description
	 */
	private String typeDescr;
	
	/**
	 * Use code
	 */
	private String useCode;
	
	/**
	 * Use description
	 */
	private String useDescr;
	
	/**
	 * The x (Easting) component of the Universal Transverse Mercator system. 
	 * (Zone 12, NAD83 datum)
	 */
	private double utmX;
	
	/**
	 * The y (Northing) component of the Universal Transverse Mercator system. (Zone 12, NAD83 datum)
	 */
	private double utmY;
	
	/**
	 * Water Class Number
	 */
	private int waterclassNum;
	
	/**
	 * DWR Water District
	 */
	private int waterDistrict;
	
	/**
	 * Name of the water source as specified in the court case
	 */
	private String waterSource;
	
	/**
	 * Water Class Description
	 */
	private String wcDescr;
	
	/**
	 * A Water Class consists of a series of codes that provide the location of the diversion, 
	 * the SOURCE of water, the USE of the water and the administrative operation required to 
	 * make the diversion.
	 */
	private String wcIdentifier;
	
	/**
	 * DWR unique structure identifier
	 */
	private String wdid;
	
	/**
	 * WDID account ID
	 */
	private int wdidAcctId;
	
	/**
	 * WDID account name
	 */
	private int wdidAcctName;
	
	
	/**
	 * Getters and setters for defined variables.
	 */
	public String getAvailableTimesteps() {
		return availableTimesteps;
	}
	public String getCiuCode() {
		return ciuCode;
	}

	public String getCiuCodeLong() {
		return ciuCodeLong;
	}
	public int getCoordsew() {
		return coordsew;
	}

	public String getCoordsewDir() {
		return coordsewDir;
	}
	public int getCoordsns() {
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

	public String getDivrectype() {
		return divrectype;
	}
	public String getFromStructureName() {
		return fromStructureName;
	}

	public String getFromWdid() {
		return fromWdid;
	}
	public int getFromWdidAcctId() {
		return fromWdidAcctId;
	}

	public int getFromWdidAcctName() {
		return fromWdidAcctName;
	}
	public String getGnisId() {
		return gnisId;
	}

	public String getGroupStructureName() {
		return groupStructureName;
	}
	public String getGroupWdid() {
		return groupWdid;
	}
	
	public double getLatdecdeg() {
		return latdecdeg;
	}
	public double getLongdecdeg() {
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



	public DateTime getPorLastModified() {
		return porLastModified;
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
	public String getSourceCode() {
		return sourceCode;
	}

	public String getSourceDescr() {
		return sourceDescr;
	}
	public double getStreamMile() {
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
	public String getTimeStep() {
		return timeStep;
	}

	public String getToStructureName() {
		return toStructureName;
	}
	public String getToWdid() {
		return toWdid;
	}

	public int getToWdidAcctId() {
		return toWdidAcctId;
	}
	public int getToWdidAcctName() {
		return toWdidAcctName;
	}

	public String getTownship() {
		return township;
	}
	public String getTypeCode() {
		return typeCode;
	}

	public String getTypeDescr() {
		return typeDescr;
	}
	public String getUseCode() {
		return useCode;
	}

	public String getUseDescr() {
		return useDescr;
	}
	public double getUtmX() {
		return utmX;
	}

	public double getUtmY() {
		return utmY;
	}
	public int getWaterclassNum() {
		return waterclassNum;
	}
	
	public int getWaterDistrict() {
		return waterDistrict;
	}
	public String getWaterSource() {
		return waterSource;
	}

	public String getWcDescr() {
		return wcDescr;
	}
	public String getWcIdentifier() {
		return wcIdentifier;
	}

	public String getWdid() {
		return wdid;
	}
	public int getWdidAcctId() {
		return wdidAcctId;
	}

	public int getWdidAcctName() {
		return wdidAcctName;
	}
	public void setAvailableTimesteps(String availableTimesteps) {
		this.availableTimesteps = availableTimesteps;
	}

	public void setCiuCode(String ciuCode) {
		this.ciuCode = ciuCode;
	}
	public void setCiuCodeLong(String ciuCodeLong) {
		this.ciuCodeLong = ciuCodeLong;
	}

	public void setCoordsew(int coordsew) {
		this.coordsew = coordsew;
	}
	public void setCoordsewDir(String coordsewDir) {
		this.coordsewDir = coordsewDir;
	}

	public void setCoordsns(int coordsns) {
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
	public void setDivrectype(String divrectype) {
		this.divrectype = divrectype;
	}

	public void setFromStructureName(String fromStructureName) {
		this.fromStructureName = fromStructureName;
	}
	public void setFromWdid(String fromWdid) {
		this.fromWdid = fromWdid;
	}

	public void setFromWdidAcctId(int fromWdidAcctId) {
		this.fromWdidAcctId = fromWdidAcctId;
	}
	public void setFromWdidAcctName(int fromWdidAcctName) {
		this.fromWdidAcctName = fromWdidAcctName;
	}

	public void setGnisId(String gnisId) {
		this.gnisId = gnisId;
	}
	public void setGroupStructureName(String groupStructureName) {
		this.groupStructureName = groupStructureName;
	}
	
	public void setGroupWdid(String groupWdid) {
		this.groupWdid = groupWdid;
	}
	public void setLatdecdeg(double latdecdeg) {
		this.latdecdeg = latdecdeg;
	}

	public void setLongdecdeg(double longdecdeg) {
		this.longdecdeg = longdecdeg;
	}
	public void setManagementDistrictName(String managementDistrictName) {
		this.managementDistrictName = managementDistrictName;
	}

	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, false);
	}
	public void setPm(String pm) {
		this.pm = pm;
	}

	public void setPorEnd(String porEnd) {
		this.porEnd = DateTime.parse(porEnd);
	}
	public void setPorLastModified(String porLastModified) {
		this.porLastModified = TimeToolkit.getInstance().toDateTime(porLastModified, false);
	}

	public void setPorStart(String porStart) {
		this.porStart = TimeToolkit.getInstance().toDateTime(porStart, false);
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

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	public void setSourceDescr(String sourceDescr) {
		this.sourceDescr = sourceDescr;
	}

	public void setStreamMile(double streamMile) {
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

	public void setTimeStep(String timeStep) {
		this.timeStep = timeStep;
	}
	public void setToStructureName(String toStructureName) {
		this.toStructureName = toStructureName;
	}

	public void setToWdid(String toWdid) {
		this.toWdid = toWdid;
	}
	public void setToWdidAcctId(int toWdidAcctId) {
		this.toWdidAcctId = toWdidAcctId;
	}

	public void setToWdidAcctName(int toWdidAcctName) {
		this.toWdidAcctName = toWdidAcctName;
	}
	public void setTownship(String township) {
		this.township = township;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public void setTypeDescr(String typeDescr) {
		this.typeDescr = typeDescr;
	}

	public void setUseCode(String useCode) {
		this.useCode = useCode;
	}
	public void setUseDescr(String useDescr) {
		this.useDescr = useDescr;
	}

	public void setUtmX(double utmX) {
		this.utmX = utmX;
	}
	public void setUtmY(double utmY) {
		this.utmY = utmY;
	}

	public void setWaterclassNum(int waterclassNum) {
		this.waterclassNum = waterclassNum;
	}
	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}

	public void setWaterSource(String waterSource) {
		this.waterSource = waterSource;
	}
	public void setWcDescr(String wcDescr) {
		this.wcDescr = wcDescr;
	}

	public void setWcIdentifier(String wcIdentifier) {
		this.wcIdentifier = wcIdentifier;
	}
	public void setWdid(String wdid) {
		this.wdid = wdid;
	}

	public void setWdidAcctId(int wdidAcctId) {
		this.wdidAcctId = wdidAcctId;
	}
	public void setWdidAcctName(int wdidAcctName) {
		this.wdidAcctName = wdidAcctName;
	}

	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
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
