package cdss.dmi.hydrobase.rest.dao;

public class AnalysisServicesWaterSourceRouteAnalysis {
	
	private String featureType;
	private String gnisId;
	private double streamMile;
	private String structureName;
	private String structureType;
	private String wdid;
	
	public String getFeatureType() {
		return featureType;
	}
	public void setFeatureType(String featureType) {
		this.featureType = featureType;
	}
	public String getGnisId() {
		return gnisId;
	}
	public void setGnisId(String gnisId) {
		this.gnisId = gnisId;
	}
	public double getStreamMile() {
		return streamMile;
	}
	public void setStreamMile(double streamMile) {
		this.streamMile = streamMile;
	}
	public String getStructureName() {
		return structureName;
	}
	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}
	public String getStructureType() {
		return structureType;
	}
	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}
	public String getWdid() {
		return wdid;
	}
	public void setWdid(String wdid) {
		this.wdid = wdid;
	}
	
	@Override
	public String toString(){
		return "AnalysisServicesWaterSourceRouteAnalysis: [ featureType: " + featureType + ", gnisId: " + ", streamMile: " + streamMile +
				", structureName: " + structureName + ", structureType: " + structureType + ", wdid: " + wdid + " ]";
	}

}
