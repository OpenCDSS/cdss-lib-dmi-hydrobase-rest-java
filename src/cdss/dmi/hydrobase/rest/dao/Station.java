package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Placeholder class for stations with historical time series.
 * This is not to be confused with TelemetryStation, which records real-time data.
 * This class is defined so that UI elements such as input filters can be enabled.
 * The name of this class may change when DWR releases the API for the stations.
 * @author sam
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {

	public Station () {
		
	}
}