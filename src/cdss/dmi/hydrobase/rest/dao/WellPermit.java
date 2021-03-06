// WellPermit - data object for well permit

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
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-wellpermits-wellpermit
 * @author jurentie
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WellPermit {
	
	/**
	 * Variables defined in alphabetical order. 
	 * Documentation copied from web services.
	 */
	
	/**
	 * Associated Aquifers
	 */
	private String associatedAquifers;
	
	/**
	 * Water court case number(s) associated with water right
	 */
	private String associatedCaseNumbers;
	
	/**
	 * Associated Uses
	 */
	private String associatedUses;
	
	/**
	 * Depth from surface to bottom of perforated casing (feet)
	 */
	private Integer bottomPerforatedCasing;
	
	/**
	 * Contact Address
	 */
	private String contactAddress;
	
	/**
	 * Contact City
	 */
	private String contactCity;
	
	/**
	 * Contact Name
	 */
	private String contactName;
	
	/**
	 * Contact Postal Code
	 */
	private String contactPostalCode;
	
	/**
	 * Contact State Or Province
	 */
	private String contactStateOrProvince;
	
	/**
	 * Distance and direction from East/West section line (feet)
	 */
	private Integer coordsEw;
	
	/**
	 * Direction of measurement from East/West section line
	 */
	private String coordsEwDir;
	
	/**
	 * Distance and direction from North/South section line (feet)
	 */
	private Integer coordsNs;
	
	/**
	 * Direction of measurement from North/South section line 
	 */
	private String coordsNsDir;
	
	/**
	 * County where the well is located
	 */
	private String county;
	
	/**
	 * Date of First Beneficial Use
	 */
	private DateTime date1stBeneficialUse;
	
	/**
	 * Date Application Received
	 */
	private DateTime dateApplicationReceived;
	
	/**
	 * Date Permit Expires
	 */
	private DateTime datePermitExpires;
	
	/**
	 * Date Permit Issued
	 */
	private DateTime datePermitIssued;
	
	/**
	 * Date Pump Installed
	 */
	private DateTime datePumpInstalled;
	
	/**
	 * Date Well Completed
	 */
	private DateTime dateWellCompleted;
	
	/**
	 * Date Well Plugged
	 */
	private DateTime dateWellPlugged;
	
	/**
	 * Denver Basin Aquifer
	 */
	private String denverBasinAquifer;
	
	/**
	 * Depth Total (ft)
	 */
	private Integer depthTotal;
	
	/**
	 * Eight established geographic areas in Colorado's Eastern Plains where users rely 
	 * primarily on groundwater for water supply
	 */
	private String designatedBasinName;
	
	/**
	 * DWR Water Division
	 */
	private int division;
	
	/**
	 * Driller
	 */
	private String driller;
	
	/**
	 * Driller License
	 */
	private String drillerLic;
	
	/**
	 * Elevation (feet)
	 */
	private Double elevation;
	
	/**
	 * Latitude value in decimal degrees
	 */
	private Double latitude;
	
	/**
	 * Accuracy of location coordinates
	 */
	private String locationAccuracy;
	
	/**
	 * Location Type
	 */
	private String locationType;
	
	/**
	 * Longitude (decimal degrees)
	 */
	private Double longitude;
	
	/**
	 * Thirteen local districts, within the Designated Basins, 
	 * with additional administrative authority
	 */
	private String managementDistrictName;
	
	/**
	 * Last date time that this record was modified in the DWR database
	 */
	private DateTime modified;
	
	/**
	 * Hyperlink to additional details
	 */
	private String moreInformation;
	
	/**
	 * Parcel Name
	 */
	private String parcelName;
	
	/**
	 * Well Permit Number
	 */
	private String permit;
	
	/**
	 * Permit Category Description
	 */
	private String permitCategoryDescr;
	
	/**
	 * Permit Current Status Description
	 */
	private String permitCurrentStatusDescr;
	
	/**
	 * Physical Address
	 */
	private String physicalAddress;
	
	/**
	 * Physical City
	 */
	private String physicalCity;
	
	/**
	 * Physical Postal Code
	 */
	private String physicalPostalCode;
	
	/**
	 * Physical State Or Province
	 */
	private String physicalStateOrProvince;
	
	/**
	 * Principal Meridian of well’s legal location - there are 5 principal meridians in CO: 
	 * Sixth (S), New Mexico (N), Baca (B), Costilla (C), and Ute (U)
	 */
	private String pm;
	
	/**
	 * Pump Installer
	 */
	private String pumpInstaller;
	
	/**
	 * Pump License
	 */
	private String pumpLic;
	
	/**
	 * Pump Test Yield
	 */
	private Double pumpTestYield;
	
	/**
	 * Legal Location: 10 acre quarter section
	 */
	private String q10;
	
	/**
	 * Legal Location: 160 acre quarter section
	 */
	private String q160;
	
	/**
	 * Legal location: 40 acre quarter section
	 */
	private String q40;
	
	/**
	 * Legal location: A number is the direction either East or West
	 */
	private String range;
	
	/**
	 * Permit application receipt number
	 */
	private String receipt;
	
	/**
	 * Section number - township, range divided into 36 one square mile sections;
	 * may indicate location in Ute Correction (Division 7 only)
	 */
	private String section;
	
	/**
	 * Static Water level (feet)
	 */
	private Double staticWaterLevel;
	
	/**
	 * Static Water Level Date
	 */
	private DateTime staticWaterLevelDate;
	
	/**
	 * Depth from surface to top of perforated casing (feet)
	 */
	private Integer topPerforatedCasing;
	
	/**
	 * Legal Location: Township number and direction
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
	 * DWR unique structure identifier
	 */
	private String wdid;
	
	/**
	 * Getters and setters for defined variables
	 */
	public String getAssociatedAquifers() {
		return associatedAquifers;
	}
	public String getAssociatedCaseNumbers() {
		return associatedCaseNumbers;
	}
	public String getAssociatedUses() {
		return associatedUses;
	}
	public Integer getBottomPerforatedCasing() {
		return bottomPerforatedCasing;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public String getContactCity() {
		return contactCity;
	}
	public String getContactName() {
		return contactName;
	}
	public String getContactPostalCode() {
		return contactPostalCode;
	}
	public String getContactStateOrProvince() {
		return contactStateOrProvince;
	}
	public Integer getCoordsEw() {
		return coordsEw;
	}
	public String getCoordsEwDir() {
		return coordsEwDir;
	}
	public Integer getCoordsNs() {
		return coordsNs;
	}
	public String getCoordsNsDir() {
		return coordsNsDir;
	}
	public String getCounty() {
		return county;
	}
	public DateTime getDate1stBeneficialUse() {
		return date1stBeneficialUse;
	}
	public DateTime getDateApplicationReceived() {
		return dateApplicationReceived;
	}
	public DateTime getDatePermitExpires() {
		return datePermitExpires;
	}
	public DateTime getDatePermitIssued() {
		return datePermitIssued;
	}
	public DateTime getDatePumpInstalled() {
		return datePumpInstalled;
	}
	public DateTime getDateWellCompleted() {
		return dateWellCompleted;
	}
	public DateTime getDateWellPlugged() {
		return dateWellPlugged;
	}
	public String getDenverBasinAquifer() {
		return denverBasinAquifer;
	}
	public Integer getDepthTotal() {
		return depthTotal;
	}
	public String getDesignatedBasinName() {
		return designatedBasinName;
	}
	public int getDivision() {
		return division;
	}
	public String getDriller() {
		return driller;
	}
	public String getDrillerLic() {
		return drillerLic;
	}
	public Double getElevation() {
		return elevation;
	}
	public Double getLatitude() {
		return latitude;
	}
	public String getLocationAccuracy() {
		return locationAccuracy;
	}
	public String getLocationType() {
		return locationType;
	}
	public Double getLongitude() {
		return longitude;
	}
	public String getManagementDistrictName() {
		return managementDistrictName;
	}
	public DateTime getModified() {
		return modified;
	}
	public String getMoreInformation() {
		return moreInformation;
	}
	public String getParcelName() {
		return parcelName;
	}
	public String getPermit() {
		return permit;
	}
	public String getPermitCategoryDescr() {
		return permitCategoryDescr;
	}
	public String getPermitCurrentStatusDescr() {
		return permitCurrentStatusDescr;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public String getPhysicalCity() {
		return physicalCity;
	}
	public String getPhysicalPostalCode() {
		return physicalPostalCode;
	}
	public String getPhysicalStateOrProvince() {
		return physicalStateOrProvince;
	}
	public String getPm() {
		return pm;
	}
	public String getPumpInstaller() {
		return pumpInstaller;
	}
	public String getPumpLic() {
		return pumpLic;
	}
	public Double getPumpTestYield() {
		return pumpTestYield;
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
	public Double getStaticWaterLevel() {
		return staticWaterLevel;
	}
	public DateTime getStaticWaterLevelDate() {
		return staticWaterLevelDate;
	}
	public Integer getTopPerforatedCasing() {
		return topPerforatedCasing;
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
	public String getWdid() {
		return wdid;
	}
	public void setAssociatedAquifers(String associatedAquifers) {
		this.associatedAquifers = associatedAquifers;
	}
	public void setAssociatedCaseNumbers(String associatedCaseNumbers) {
		this.associatedCaseNumbers = associatedCaseNumbers;
	}
	public void setAssociatedUses(String associatedUses) {
		this.associatedUses = associatedUses;
	}
	public void setBottomPerforatedCasing(Integer bottomPerforatedCasing) {
		this.bottomPerforatedCasing = bottomPerforatedCasing;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public void setContactCity(String contactCity) {
		this.contactCity = contactCity;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public void setContactPostalCode(String contactPostalCode) {
		this.contactPostalCode = contactPostalCode;
	}
	public void setContactStateOrProvince(String contactStateorProvince) {
		this.contactStateOrProvince = contactStateorProvince;
	}
	public void setCoordsEw(Integer coordsEw) {
		this.coordsEw = coordsEw;
	}
	public void setCoordsEwDir(String coordsEwDir) {
		this.coordsEwDir = coordsEwDir;
	}
	public void setCoordsNs(Integer coordsNs) {
		this.coordsNs = coordsNs;
	}
	public void setCoordsNsDir(String coordsNsDir) {
		this.coordsNsDir = coordsNsDir;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public void setDate1stBeneficialUse(String date1stBeneficialUse) {
		this.date1stBeneficialUse = TimeToolkit.getInstance().toDateTime(date1stBeneficialUse, false);
	}
	public void setDateApplicationReceived(String dateApplicationReceived) {
		this.dateApplicationReceived = TimeToolkit.getInstance().toDateTime(dateApplicationReceived, false);
	}
	public void setDatePermitExpires(String datePermitExpires) {
		this.datePermitExpires = TimeToolkit.getInstance().toDateTime(datePermitExpires, false);
	}
	public void setDatePermitIssued(String datePermitIssued) {
		this.datePermitIssued = TimeToolkit.getInstance().toDateTime(datePermitIssued, false);
	}
	public void setDatePumpInstalled(String datePumpInstalled) {
		this.datePumpInstalled = TimeToolkit.getInstance().toDateTime(datePumpInstalled, false);
	}
	public void setDateWellCompleted(String dateWellCompleted) {
		this.dateWellCompleted = TimeToolkit.getInstance().toDateTime(dateWellCompleted, false);
	}
	public void setDateWellPlugged(String dateWellPlugged) {
		this.dateWellPlugged = TimeToolkit.getInstance().toDateTime(dateWellPlugged, false);
	}
	public void setDenverBasinAquifer(String denverBasinAquifer) {
		this.denverBasinAquifer = denverBasinAquifer;
	}
	public void setDepthTotal(Integer depthTotal) {
		this.depthTotal = depthTotal;
	}
	public void setDesignatedBasinName(String designatedBasinName) {
		this.designatedBasinName = designatedBasinName;
	}
	public void setDivision(Integer division) {
		this.division = division;
	}
	public void setDriller(String driller) {
		this.driller = driller;
	}
	public void setDrillerLic(String drillerLic) {
		this.drillerLic = drillerLic;
	}
	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public void setLocationAccuracy(String locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public void setManagementDistrictName(String managementDistrictName) {
		this.managementDistrictName = managementDistrictName;
	}
	public void setModified(String modified) {
		this.modified = TimeToolkit.getInstance().toDateTime(modified, false);
	}
	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}
	public void setParcelName(String parcelName) {
		this.parcelName = parcelName;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
	public void setPermitCategoryDescr(String permitCategoryDescr) {
		this.permitCategoryDescr = permitCategoryDescr;
	}
	public void setPermitCurrentStatusDescr(String permitCurrentStatusDescr) {
		this.permitCurrentStatusDescr = permitCurrentStatusDescr;
	}
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	public void setPhysicalCity(String physicalCity) {
		this.physicalCity = physicalCity;
	}
	public void setPhysicalPostalCode(String physicalPostalCode) {
		this.physicalPostalCode = physicalPostalCode;
	}
	public void setPhysicalStateOrProvince(String physicalStateOrProvince) {
		this.physicalStateOrProvince = physicalStateOrProvince;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	public void setPumpInstaller(String pumpInstaller) {
		this.pumpInstaller = pumpInstaller;
	}
	public void setPumpLic(String pumpLic) {
		this.pumpLic = pumpLic;
	}
	public void setPumpTestYield(Double pumpTestYield) {
		this.pumpTestYield = pumpTestYield;
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
	public void setStaticWaterLevel(Double staticWaterLevel) {
		this.staticWaterLevel = staticWaterLevel;
	}
	public void setStaticWaterLevelDate(String staticWaterLevelDate) {
		this.staticWaterLevelDate = TimeToolkit.getInstance().toDateTime(staticWaterLevelDate, false);
	}
	public void setTopPerforatedCasing(Integer topPerforatedCasing) {
		this.topPerforatedCasing = topPerforatedCasing;
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
		return "WellPermit: [ receipt: " + receipt + ", permit: " + permit + ", permitCurrentStatusDescr: " + permitCurrentStatusDescr + 
				", contactName: " + contactName + ", contactAddress: " + contactAddress + ", contactCity: " + contactCity + 
				", contactStateOrProvince: " + contactStateOrProvince + ", contactPostalCode: " + contactPostalCode + ", division: " + 
				division + ", waterDistrict: " + waterDistrict + ", county: " + county + ", designatedBasinName: " + designatedBasinName +
				", managementDistrictName: " + managementDistrictName + ", denverBasinAquifer: " + denverBasinAquifer + ", locationType: " + 
				locationType + ", pm: " + pm + ", township: " + township + ", range: " + range + ", section: " + section + ", q160 " + q160 + 
				"q40: " + q40 + ", q10: " + q10 + ", coordsEw: " + coordsEw + ", coordsEwDir: " + coordsEwDir + ", coordsNs: " + coordsNs + 
				", coordsNsDir: " + coordsNsDir + ", utmX: " + utmX + ", utmY: " + utmY + ", latitude: " + latitude + ", longitude: " + 
				longitude + ", locationAccuracy: " + locationAccuracy + ", parcelName: " + parcelName + ", physicalAddress: " + 
				physicalAddress + ", physicalCity: " + physicalCity + ", physicalStateOrProvince: " + physicalStateOrProvince + 
				", phyiscalPostalCode: " + physicalPostalCode + ", permitCategoryDescr: " + permitCategoryDescr + ", datePermitIssued: " +
				datePermitIssued + ", date1stBeneficialUse: " + date1stBeneficialUse + ", datePermitExpires: " + datePermitExpires + 
				", dateWellCompleted: " + dateWellCompleted + ", datePumpInstalled: " + datePumpInstalled + ", dateWellPlugged: " + 
				dateWellPlugged + ", associatedAquifers: " + associatedAquifers + ", associatedUses: " + associatedUses + ", elevation: " +
				elevation + ", depthTotal: " + depthTotal + ", topPerforatedCasing: " + topPerforatedCasing + ", bottomPerforatedCasing: " + 
				bottomPerforatedCasing + ", pumpTestYield: " + pumpTestYield + ", staticWaterLevel: " + staticWaterLevel + 
				", staticWaterLevelDate: " + staticWaterLevelDate + ", wdid: " + wdid + ", associatedCaseNumbers: " + associatedCaseNumbers + 
				", modified: " + modified + ", moreInformation: " + moreInformation + ", dateApplicationReceived: " + dateApplicationReceived +
				", drillerLic: " + drillerLic + ", driller: "+ driller + ", pumpLic: " + pumpLic + ", pumpInstaller: " + pumpInstaller + " ]\n";
	}

}