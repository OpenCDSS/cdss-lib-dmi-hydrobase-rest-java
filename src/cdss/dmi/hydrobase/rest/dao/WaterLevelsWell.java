package cdss.dmi.hydrobase.rest.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dto.TimeToolkit;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-groundwater-waterlevels-wells
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-groundwater-waterlevels-wells-wellId * @author jurentie
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WaterLevelsWell {
	
	/**
	 * Variables defined in alphabetical order. 
	 * Documentation copied from web services.
	 */
	
	/**
	 * Aquifer, or aquifers, in which well is located 
	 * (as determined by the data source)
	 */
	private String aquifers;

	/**
	 * Depth from surface to base of grout (feet) 
	 */
	private int baseOfGrout;

	/**
	 * Depth from surface to bottom of perforated casing (feet) 
	 */
	private int bottomPerforatedCasing;

	/**
	 * Person(s) or entity associated with well either 
	 * as applicant or primary contact
	 */
	private String contact;

	/**
	 * Distance and direction from East/West section line (feet)
	 */
	private int coordinatesEw;

	/**
	 * Direction of measurement from east/west section line 
	 */
	private String coordinatesEwDir;

	/** 
	 * Distance from north/south section line (feet) 
	 */
	private int coordinatesNs;

	/**
	 * Direction of measurement from north/south section line 
	 * */
	private String coordinatesNsDir;

	/**
	 * County where the well is located
	 */
	private String county;

	/**
	 * Primary source/provider of well measurement data
	 */
	private String dataSource;

	/**
	 * DataType is not from web services but was added by @jurentie. 
	 * DataType is used later in the code such as ColoradoHydroBaseRest
	 */
	private String dataType;

	/**
	 * Eight established geographic areas in Colorado's Eastern Plains 
	 * where users rely primarily on groundwater for water supply
	 */
	private String designatedBasin;

	/** 
	 * DWR Water Division 
	 */
	private int division;

	/**
	 * Surface elevation at the location of the well (feet above 
	 * mean sea level)
	 */
	private double elevation;

	/**
	 * Accuracy of the ground surface elevation
	 */
	private String elevationAccuracy;

	/**
	 * Latitude value in decimal degrees
	 */
	private double latitude;

	/**
	 * Accuracy of location coordinates
	 */
	private String locationAccuracy;

	/**
	 * Bereau of Reclamation location identification string based on 
	 * the PLSS location
	 */
	private String locationNumber;

	/** 
	 * Longitude in decimal degrees 
	 */
	private double longitude;

	/**
	 * Thirteen local districts, within the Designated Basins, 
	 * with additional administrative authority
	 */
	private String managementDistrict;

	/**
	 * Name of the entity that measured the water level depth
	 */
	private String measurementBy;

	/**
	 * Date of last measurement
	 */
	private DateTime measurementDate;

	/**
	 * Last date time that this record was modified in the DWR database
	 */
	private DateTime modified;

	/** 
	 * Hyperlink to additional information 
	 */
	private String moreInformation;

	/**
	 * Well permit number
	 */
	private String permit;

	/**
	 * Principal Meridian of well’s legal location - there are 5 principal 
	 * meridians in CO: Sixth (S), New Mexico (N), Baca (B), Costilla (C), 
	 * and Ute (U)
	 */
	private String pm;

	/**
	 * Count of measurements in the well’s period of record
	 */
	private int porCount;

	/**
	 * Date of last measurement in the well’s period of record
	 */
	private DateTime porEnd;

	/**
	 * Date of first measurement in the well’s period of record
	 */
	private DateTime porStart;

	/**
	 * Name of DWR Basin Summary publication in which well is included, if applicable
	 */
	private String publicationName;

	/**
	 * Legal Location: 10 acre quarter section indicator 
	 */
	private String q10;

	/** 
	 * Legal Location: 160 acre quarter section indicator 
	 */
	private String q160;

	/** 
	 * Legal Location: 40 acre quarter section inidcator 
	 */
	private String q40;

	/**
	 * Legal location: A number in the format “nnnd” where “nnn” 
	 * is the range number and “d” is the direction either East or West
	 */
	private String range;

	/**
	 * Permit application receipt number
	 */
	private String receipt;

	/**
	 * Section number - township, range divided into 36 one square mile sections; 
	 * “U” indicates location in Ute Correction (Division 7 only)
	 */
	private String section;

	/**
	 * Timestep is not a part of web services and was added by @jurentie. 
	 * Timestep is used in later code such as ColoradoHydroBaseRestDataStore
	 */
	private String timeStep;

	/**
	 * Depth from surface to top of perforated casing (feet)
	 */
	private int topPerforatedCasing;

	/**
	 * Legal Location: Township number and direction
	 */
	private String township;

	/**
	 * US Geologic Survey well identifier
	 */
	private String usgsSiteId;

	/** 
	 * The x (Easting) component of the Universal Transverse Mercator system. 
	 * (Zone 12, NAD83 datum) 
	 */
	private double utmX;

	/** 
	 * The y (Northing) component of the Universal Transverse Mercator system. 
	 * (Zone 12, NAD83 datum) 
	 */
	private double utmY;

	/** 
	 * DWR Water District 
	 */
	private int waterDistrict;

	/** 
	 * Depth to water below land surface (ft) on measurement date
	 */
	private double waterLevelDepth;

	/** 
	 * Elevation of water above mean sea level (feet)
	 */
	private double waterLevelElevation;

	/**
	 * DWR unique structure identifier
	 */
	private String wdid;

	/**
	 * Completed depth of well (ft)
	 */
	private int wellDepth;
	
	/**
	 * Unique ID of well in DWR database
	 */
	private int wellId;
	
	/**
	 * Name of well in DWR database
	 */
	private String wellName;
	
	/**
	 * Getters and setters of defined variables
	 */
	public String getAquifers() {
		return aquifers;
	}
	public int getBaseOfGrout() {
		return baseOfGrout;
	}
	
	public int getBottomPerforatedCasing() {
		return bottomPerforatedCasing;
	}
	public String getContact() {
		return contact;
	}
	public int getCoordinatesEw() {
		return coordinatesEw;
	}
	public String getCoordinatesEwDir() {
		return coordinatesEwDir;
	}
	public int getCoordinatesNs() {
		return coordinatesNs;
	}
	public String getCoordinatesNsDir() {
		return coordinatesNsDir;
	}
	public String getCounty() {
		return county;
	}
	public String getDataSource() {
		return dataSource;
	}
	public String getDataType() {
		return dataType;
	}
	public String getDesignatedBasin() {
		return designatedBasin;
	}
	public int getDivision() {
		return division;
	}
	public double getElevation() {
		return elevation;
	}
	public String getElevationAccuracy() {
		return elevationAccuracy;
	}
	public double getLatitude() {
		return latitude;
	}
	public String getLocationAccuracy() {
		return locationAccuracy;
	}
	public String getLocationNumber() {
		return locationNumber;
	}
	public double getLongitude() {
		return longitude;
	}
	public String getManagementDistrict() {
		return managementDistrict;
	}
	public String getMeasurementBy() {
		return measurementBy;
	}
	public DateTime getMeasurementDate() {
		return measurementDate;
	}
	public DateTime getModified() {
		return modified;
	}
	public String getMoreInformation() {
		return moreInformation;
	}
	public String getPermit() {
		return permit;
	}
	public String getPm() {
		return pm;
	}
	public int getPorCount() {
		return porCount;
	}
	public DateTime getPorEnd() {
		return porEnd;
	}
	public DateTime getPorStart() {
		return porStart;
	}
	public String getPublicationName() {
		return publicationName;
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
	public String getReceipt() {
		return receipt;
	}
	public String getSection() {
		return section;
	}
	public String getTimeStep() {
		return timeStep;
	}
	public int getTopPerforatedCasing() {
		return topPerforatedCasing;
	}
	public String getTownship() {
		return township;
	}
	public String getUsgsSiteId() {
		return usgsSiteId;
	}
	public double getUtmX() {
		return utmX;
	}
	public double getUtmY() {
		return utmY;
	}
	public int getWaterDistrict() {
		return waterDistrict;
	}
	public double getWaterLevelDepth() {
		return waterLevelDepth;
	}
	public double getWaterLevelElevation() {
		return waterLevelElevation;
	}
	public String getWdid() {
		return wdid;
	}
	public int getWellDepth() {
		return wellDepth;
	}
	public int getWellId() {
		return wellId;
	}
	public String getWellName() {
		return wellName;
	}
	public void setAquifers(String aquifers) {
		this.aquifers = aquifers;
	}
	public void setBaseOfGrout(int baseOfGrout) {
		this.baseOfGrout = baseOfGrout;
	}
	public void setBottomPerforatedCasing(int bottomPerforatedCasing) {
		this.bottomPerforatedCasing = bottomPerforatedCasing;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setCoordinatesEw(int coordinatesEw) {
		this.coordinatesEw = coordinatesEw;
	}
	public void setCoordinatesEwDir(String coordinatesEwDir) {
		this.coordinatesEwDir = coordinatesEwDir;
	}
	public void setCoordinatesNs(int coordinatesNs) {
		this.coordinatesNs = coordinatesNs;
	}
	public void setCoordinatesNsDir(String coordinatesNsDir) {
		this.coordinatesNsDir = coordinatesNsDir;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public void setDesignatedBasin(String designatedBasin) {
		this.designatedBasin = designatedBasin;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	public void setElevation(double elevation) {
		this.elevation = elevation;
	}
	public void setElevationAccuracy(String elevationAccuracy) {
		this.elevationAccuracy = elevationAccuracy;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public void setLocationAccuracy(String locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
	}
	public void setLocationNumber(String locationNumber) {
		this.locationNumber = locationNumber;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public void setManagementDistrict(String managementDistrict) {
		this.managementDistrict = managementDistrict;
	}
	public void setMeasurementBy(String measurementBy) {
		this.measurementBy = measurementBy;
	}
	public void setMeasurementDate(String measurementDate) {
		this.measurementDate = TimeToolkit.getInstance().toDateTime(measurementDate, false);
	}
	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, false);
	}
	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	public void setPorCount(int porCount) {
		this.porCount = porCount;
	}
	public void setPorEnd(String porEnd) {
		this.porEnd = TimeToolkit.getInstance().toDateTime(porEnd, false);
	}
	public void setPorStart(String porStart) {
		this.porStart = TimeToolkit.getInstance().toDateTime(porStart, false);
	}
	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
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
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public void setTimeStep(String timeStep) {
		this.timeStep = timeStep;
	}
	public void setTopPerforatedCasing(int topPerforatedCasing) {
		this.topPerforatedCasing = topPerforatedCasing;
	}
	public void setTownship(String township) {
		this.township = township;
	}
	public void setUsgsSiteId(String usgsSiteId) {
		this.usgsSiteId = usgsSiteId;
	}
	public void setUtmX(double utmX) {
		this.utmX = utmX;
	}
	public void setUtmY(double utmY) {
		this.utmY = utmY;
	}
	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}
	public void setWaterLevelDepth(double waterLevelDepth) {
		this.waterLevelDepth = waterLevelDepth;
	}
	public void setWaterLevelElevation(double waterLevelElevation) {
		this.waterLevelElevation = waterLevelElevation;
	}
	public void setWdid(String wdid) {
		this.wdid = wdid;
	}
	public void setWellDepth(int wellDepth) {
		this.wellDepth = wellDepth;
	}
	public void setWellId(int wellId) {
		this.wellId = wellId;
	}
	public void setWellName(String wellName) {
		this.wellName = wellName;
	}
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "WaterLevelsWells [ wellId: " + wellId + ", wellName: " + wellName + ", receipt: " + receipt + 
				", permit: " + permit + ", welLDepth: " + wellDepth + ", measurementDate: " + measurementDate +
				", waterLevelDepth: " + waterLevelDepth + ", waterLevelElevation: " + waterLevelElevation + 
				", measurementBy: " + measurementBy + ", porStart: " + porStart + ", porEnd: " + porEnd + 
				", porCount: " + porCount + ", publicationName: " + ", aquifers: " + aquifers + ", elevation: " +
				elevation + ", elevationAccuracy: " + elevationAccuracy + ", topPerforatedCasing: " + topPerforatedCasing +
				", bottomPerforatedCasing: " + bottomPerforatedCasing + ", baseOfGrout:  " + baseOfGrout + 
				", wdid: " + wdid + ", locationNumber: " + locationNumber + ", usgsSiteId: " + usgsSiteId + 
				", contact: " + contact + ", division: " + division + ", waterDistrict: " + waterDistrict + 
				", county: " + county + ", designatedBasin: " + designatedBasin + ", managementDistrict: " + 
				managementDistrict + ", q10: " + q10 + ", q40: " + q40 + ", q160: " + q160 + ", section: " +
				section + ", township: " + township + ", range: " + range + ", pm: " + pm + ", coordinatesEw: " + 
				coordinatesEw + ", coordinatesEwDir: " + coordinatesEwDir + ", coordinatesNs: " + coordinatesNs + 
				", coordinatesNsDir: " + coordinatesNsDir + ", utmX: " + utmX + ", utmY: " + utmY + ", latitude: " +
				latitude + ", longitude: " + longitude + ", locationAccuracy: " + locationAccuracy + ", dataSource: " + 
				dataSource + ", modified: " + modified + ", moreInformation: " + moreInformation + ", timestep: " +
				timeStep + ", datatype: " + dataType + " ]"; 
	}
}