package cdss.dmi.hydrobase.rest.dao;

import RTi.Util.Time.DateTime;

public class WellPermit {
	
	private String associatedAquifers;
	private String associatedCaseNumbers;
	private String associatedUses;
	private int bottomPerforatedCasing;
	private String contactAddress;
	private String contactCity;
	private String contactName;
	private String contactPostalCode;
	private String contactStateOrProvince;
	private int coordsEw;
	private String coordsEwDir;
	private int coordsNs;
	private String coordsNsDir;
	private String county;
	private DateTime date1stBeneficialUse;
	private DateTime dateApplicationReceived;
	private DateTime datePermitExpires;
	private DateTime datePermitIssued;
	private DateTime datePumpInstalled;
	private DateTime dateWellCompleted;
	private DateTime dateWellPlugged;
	private String denverBasinAquifer;
	private int depthTotal;
	private String designatedBasinName;
	private int division;
	private String driller;
	private String drillerLic;
	private double elevation;
	private double latitude;
	private String locationAccuracy;
	private String locationType;
	private double longitude;
	private String managementDistrictName;
	private DateTime modified;
	private String moreInformation;
	private String parcelName;
	private String permit;
	private String permitCategoryDescr;
	private String permitCurrentStatusDescr;
	private String physicalAddress;
	private String physicalCity;
	private String physicalPostalCode;
	private String physicalStateOrProvince;
	private String pm;
	private String pumpInstaller;
	private String pumpLic;
	private double pumpTestYield;
	private String q10;
	private String q160;
	private String q40;
	private String range;
	private String receipt;
	private String section;
	private double staticWaterLevel;
	private DateTime staticWaterLevelDate;
	private int topPerforatedCasing;
	private String township;
	private double utmX;
	private double utmY;
	private int waterDistrict;
	private String wdid;
	
	public String getAssociatedAquifers() {
		return associatedAquifers;
	}
	public void setAssociatedAquifers(String associatedAquifers) {
		this.associatedAquifers = associatedAquifers;
	}
	public String getAssociatedCaseNumbers() {
		return associatedCaseNumbers;
	}
	public void setAssociatedCaseNumbers(String associatedCaseNumbers) {
		this.associatedCaseNumbers = associatedCaseNumbers;
	}
	public String getAssociatedUses() {
		return associatedUses;
	}
	public void setAssociatedUses(String associatedUses) {
		this.associatedUses = associatedUses;
	}
	public int getBottomPerforatedCasing() {
		return bottomPerforatedCasing;
	}
	public void setBottomPerforatedCasing(int bottomPerforatedCasing) {
		this.bottomPerforatedCasing = bottomPerforatedCasing;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getContactCity() {
		return contactCity;
	}
	public void setContactCity(String contactCity) {
		this.contactCity = contactCity;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPostalCode() {
		return contactPostalCode;
	}
	public void setContactPostalCode(String contactPostalCode) {
		this.contactPostalCode = contactPostalCode;
	}
	public String getContactStateOrProvince() {
		return contactStateOrProvince;
	}
	public void setContactStateOrProvince(String contactStateorProvince) {
		this.contactStateOrProvince = contactStateorProvince;
	}
	public int getCoordsEw() {
		return coordsEw;
	}
	public void setCoordsEw(int coordsEw) {
		this.coordsEw = coordsEw;
	}
	public String getCoordsEwDir() {
		return coordsEwDir;
	}
	public void setCoordsEwDir(String coordsEwDir) {
		this.coordsEwDir = coordsEwDir;
	}
	public int getCoordsNs() {
		return coordsNs;
	}
	public void setCoordsNs(int coordsNs) {
		this.coordsNs = coordsNs;
	}
	public String getCoordsNsDir() {
		return coordsNsDir;
	}
	public void setCoordsNsDir(String coordsNsDir) {
		this.coordsNsDir = coordsNsDir;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public DateTime getDate1stBeneficialUse() {
		return date1stBeneficialUse;
	}
	public void setDate1stBeneficialUse(String date1stBeneficialUse) {
		if(date1stBeneficialUse != null){
			int indexLastHyphen = date1stBeneficialUse.lastIndexOf('-');
			date1stBeneficialUse = date1stBeneficialUse.substring(0, indexLastHyphen);
			this.date1stBeneficialUse = DateTime.parse(date1stBeneficialUse);
		}else{
			this.date1stBeneficialUse = null;
		}
	}
	public DateTime getDateApplicationReceived() {
		return dateApplicationReceived;
	}
	public void setDateApplicationReceived(String dateApplicationReceived) {
		if(dateApplicationReceived != null){
			int indexLastHyphen = dateApplicationReceived.lastIndexOf('-');
			dateApplicationReceived = dateApplicationReceived.substring(0, indexLastHyphen);
			this.dateApplicationReceived = DateTime.parse(dateApplicationReceived);
		}else{
			this.dateApplicationReceived = null;
		}
	}
	public DateTime getDatePermitExpires() {
		return datePermitExpires;
	}
	public void setDatePermitExpires(String datePermitExpires) {
		if(datePermitExpires != null){
			int indexLastHyphen = datePermitExpires.lastIndexOf('-');
			datePermitExpires = datePermitExpires.substring(0, indexLastHyphen);
			this.datePermitExpires = DateTime.parse(datePermitExpires);
		}else{
			this.datePermitExpires = null;
		}
	}
	public DateTime getDatePermitIssued() {
		return datePermitIssued;
	}
	public void setDatePermitIssued(String datePermitIssued) {
		if(datePermitIssued != null){
			int indexLastHyphen = datePermitIssued.lastIndexOf('-');
			datePermitIssued = datePermitIssued.substring(0, indexLastHyphen);
			this.datePermitIssued = DateTime.parse(datePermitIssued);
		}else{
			this.datePermitIssued = null;
		}
	}
	public DateTime getDatePumpInstalled() {
		return datePumpInstalled;
	}
	public void setDatePumpInstalled(String datePumpInstalled) {
		if(datePumpInstalled != null){
			int indexLastHyphen = datePumpInstalled.lastIndexOf('-');
			datePumpInstalled = datePumpInstalled.substring(0, indexLastHyphen);
			this.datePumpInstalled = DateTime.parse(datePumpInstalled);
		}else{
			this.datePumpInstalled = null;
		}
	}
	public DateTime getDateWellCompleted() {
		return dateWellCompleted;
	}
	public void setDateWellCompleted(String dateWellCompleted) {
		if(dateWellCompleted != null){
			int indexLastHyphen = dateWellCompleted.lastIndexOf('-');
			dateWellCompleted = dateWellCompleted.substring(0, indexLastHyphen);
			this.dateWellCompleted = DateTime.parse(dateWellCompleted);
		}else{
			this.dateWellCompleted = null;
		}
	}
	public DateTime getDateWellPlugged() {
		return dateWellPlugged;
	}
	public void setDateWellPlugged(String dateWellPlugged) {
		if(dateWellPlugged != null){
			int indexLastHyphen = dateWellPlugged.lastIndexOf('-');
			dateWellPlugged = dateWellPlugged.substring(0, indexLastHyphen);
			this.dateWellPlugged = DateTime.parse(dateWellPlugged);
		}else{
			this.dateWellPlugged = null;
		}
	}
	public String getDenverBasinAquifer() {
		return denverBasinAquifer;
	}
	public void setDenverBasinAquifer(String denverBasinAquifer) {
		this.denverBasinAquifer = denverBasinAquifer;
	}
	public int getDepthTotal() {
		return depthTotal;
	}
	public void setDepthTotal(int depthTotal) {
		this.depthTotal = depthTotal;
	}
	public void setDesignatedBasinName(String designatedBasinName) {
		this.designatedBasinName = designatedBasinName;
	}
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	public String getDesignatedBasinName() {
		return designatedBasinName;
	}
	public String getDriller() {
		return driller;
	}
	public void setDriller(String driller) {
		this.driller = driller;
	}
	public String getDrillerLic() {
		return drillerLic;
	}
	public void setDrillerLic(String drillerLic) {
		this.drillerLic = drillerLic;
	}
	public double getElevation() {
		return elevation;
	}
	public void setElevation(double elevation) {
		this.elevation = elevation;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getLocationAccuracy() {
		return locationAccuracy;
	}
	public void setLocationAccuracy(String locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getManagementDistrictName() {
		return managementDistrictName;
	}
	public void setManagementDistrictName(String managementDistrictName) {
		this.managementDistrictName = managementDistrictName;
	}
	public DateTime getModified() {
		return modified;
	}
	public void setModified(String modified) {
		if(modified != null){
			int indexLastHyphen = modified.lastIndexOf('-');
			modified = modified.substring(0, indexLastHyphen);
			this.modified = DateTime.parse(modified);
		}else{
			this.modified = null;
		}
	}
	public String getMoreInformation() {
		return moreInformation;
	}
	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}
	public String getParcelName() {
		return parcelName;
	}
	public void setParcelName(String parcelName) {
		this.parcelName = parcelName;
	}
	public String getPermit() {
		return permit;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
	public String getPermitCategoryDescr() {
		return permitCategoryDescr;
	}
	public void setPermitCategoryDescr(String permitCategoryDescr) {
		this.permitCategoryDescr = permitCategoryDescr;
	}
	public String getPermitCurrentStatusDescr() {
		return permitCurrentStatusDescr;
	}
	public void setPermitCurrentStatusDescr(String permitCurrentStatusDescr) {
		this.permitCurrentStatusDescr = permitCurrentStatusDescr;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	public String getPhysicalCity() {
		return physicalCity;
	}
	public void setPhysicalCity(String physicalCity) {
		this.physicalCity = physicalCity;
	}
	public String getPhysicalPostalCode() {
		return physicalPostalCode;
	}
	public void setPhysicalPostalCode(String physicalPostalCode) {
		this.physicalPostalCode = physicalPostalCode;
	}
	public String getPhysicalStateOrProvince() {
		return physicalStateOrProvince;
	}
	public void setPhysicalStateOrProvince(String physicalStateOrProvince) {
		this.physicalStateOrProvince = physicalStateOrProvince;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	public String getPumpInstaller() {
		return pumpInstaller;
	}
	public void setPumpInstaller(String pumpInstaller) {
		this.pumpInstaller = pumpInstaller;
	}
	public String getPumpLic() {
		return pumpLic;
	}
	public void setPumpLic(String pumpLic) {
		this.pumpLic = pumpLic;
	}
	public double getPumpTestYield() {
		return pumpTestYield;
	}
	public void setPumpTestYield(double pumpTestYield) {
		this.pumpTestYield = pumpTestYield;
	}
	public String getQ10() {
		return q10;
	}
	public void setQ10(String q10) {
		this.q10 = q10;
	}
	public String getQ160() {
		return q160;
	}
	public void setQ160(String q160) {
		this.q160 = q160;
	}
	public String getQ40() {
		return q40;
	}
	public void setQ40(String q40) {
		this.q40 = q40;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public double getStaticWaterLevel() {
		return staticWaterLevel;
	}
	public void setStaticWaterLevel(double staticWaterLevel) {
		this.staticWaterLevel = staticWaterLevel;
	}
	public DateTime getStaticWaterLevelDate() {
		return staticWaterLevelDate;
	}
	public void setStaticWaterLevelDate(String staticWaterLevelDate) {
		if(staticWaterLevelDate != null){
			int indexLastHyphen = staticWaterLevelDate.lastIndexOf('-');
			staticWaterLevelDate = staticWaterLevelDate.substring(0, indexLastHyphen);
			this.staticWaterLevelDate = DateTime.parse(staticWaterLevelDate);
		}else{
			this.staticWaterLevelDate = null;
		}
	}
	public int getTopPerforatedCasing() {
		return topPerforatedCasing;
	}
	public void setTopPerforatedCasing(int topPerforatedCasing) {
		this.topPerforatedCasing = topPerforatedCasing;
	}
	public String getTownship() {
		return township;
	}
	public void setTownship(String township) {
		this.township = township;
	}
	public double getUtmX() {
		return utmX;
	}
	public void setUtmX(double utmX) {
		this.utmX = utmX;
	}
	public double getUtmY() {
		return utmY;
	}
	public void setUtmY(double utmY) {
		this.utmY = utmY;
	}
	public int getWaterDistrict() {
		return waterDistrict;
	}
	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}
	public String getWdid() {
		return wdid;
	}
	public void setWdid(String wdid) {
		this.wdid = wdid;
	}
	
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
				", drillerLic: " + drillerLic + ", driller: "+ driller + ", pumpLic: " + pumpLic + ", pumpInstaller: " + pumpInstaller + " ]";
	}

}
