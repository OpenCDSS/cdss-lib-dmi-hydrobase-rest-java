package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryRatingTable {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetryratingtable
	 */
	
	private String ratingTableName;
	private double X;
	private double Y;
	
	public String getRatingTableName() {
		return ratingTableName;
	}
	public void setRatingTableName(String ratingTableName) {
		this.ratingTableName = ratingTableName;
	}
	public double getX() {
		return X;
	}
	public void setX(double x) {
		X = x;
	}
	public double getY() {
		return Y;
	}
	public void setY(double y) {
		Y = y;
	}
	
	@Override 
	public String toString(){
		return "TelemetryRatingTable: [ ratingTableName: " + ratingTableName + ", X: " + 
				X + ", Y: " + Y;
	}

}
