// ColoradoHydroBaseRestDataStoreHelper - class to provide helper methods to use ColoradoHydroBaseRestDataStore

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

package cdss.dmi.hydrobase.rest.ui;

import java.util.ArrayList;
import java.util.List;

import RTi.Util.Message.Message;
import cdss.dmi.hydrobase.rest.dao.ClimateStation;
import cdss.dmi.hydrobase.rest.dao.Structure;
import cdss.dmi.hydrobase.rest.dao.SurfaceWaterStation;
import cdss.dmi.hydrobase.rest.dao.TelemetryStation;
import cdss.dmi.hydrobase.rest.dao.WaterLevelsWell;

/**
 * Class to provide helper methods to use ColoradoHydroBaseRestDataStore.
 * May move this code into the ColoradoHydroBaseRestDataStore but trying to figure out the
 * right level of separation between 
 * @author sam
 *
 */
public class ColoradoHydroBaseRestDataStoreHelper {
	
	public ColoradoHydroBaseRestDataStoreHelper () {
		
	}
	
	// TODO smalers 2018-06-19 the following should return something like ClimateStationTimeSeriesCatalog
	// but go with ClimateStation for now.
	/**
	 * Return the list of station time series, suitable for display in TSTool browse area.
	 * @param dataType
	 * @param interval
	 * @param filterPanel
	 * @return
	 */
	public List<ClimateStation> getClimateStationTimeSeriesCatalog ( String dataType, String interval, ColoradoHydroBaseRest_ClimateStation_InputFilter_JPanel filterPanel ) {
		List<ClimateStation> stationList = new ArrayList<>();
		return stationList;
	}
	
	// TODO smalers 2022-03-13 the following should return something like StructureTimeSeriesCatalog
	// but go with Structure for now.
	/**
	 * Return the list of structure time series, suitable for display in TSTool browse area.
	 * @param dataType
	 * @param interval
	 * @param filterPanel
	 * @return
	 */
	public List<Structure> getStructureTimeSeriesCatalog ( String dataType, String interval, ColoradoHydroBaseRest_Structure_InputFilter_JPanel filterPanel ) {
		List<Structure> structureList = new ArrayList<>();
		Message.printStatus(1, "", "Getting ColoradoHydroBaseRest structure time series list");
		return structureList;
	}

	// TODO smalers 2022-03-13 the following should return something like SurfaceWaterStationTimeSeriesCatalog
	// but go with SurfaceWaterStation for now.
	/**
	 * Return the list of station time series, suitable for display in TSTool browse area.
	 * @param dataType
	 * @param interval
	 * @param filterPanel
	 * @return
	 */
	public List<SurfaceWaterStation> getSurfaceWaterStationTimeSeriesCatalog ( String dataType, String interval, ColoradoHydroBaseRest_SurfaceWaterStation_InputFilter_JPanel filterPanel ) {
		List<SurfaceWaterStation> stationList = new ArrayList<>();
		return stationList;
	}

	// TODO smalers 2018-06-19 the following should return something like TelemetryStationTimeSeriesCatalog
	// but go with Station for now.
	/**
	 * Return the list of telemetry station time series, suitable for display in TSTool browse area.
	 * @param dataType
	 * @param interval
	 * @param filterPanel
	 * @return
	 */
	public List<TelemetryStation> getTelemetryStationTimeSeriesCatalog ( String dataType, String interval, ColoradoHydroBaseRest_TelemetryStation_InputFilter_JPanel filterPanel ) {
		List<TelemetryStation> telemetryStationList = new ArrayList<>();
		Message.printStatus(1, "", "Getting ColoradoHydroBaseRest telemetry station time series list");
		return telemetryStationList;
	}

	// TODO smalers 2018-06-19 the following should return something like WellTimeSeriesCatalog
	// but go with Station for now.
	/**
	 * Return the list of well time series, suitable for display in TSTool browse area.
	 * @param dataType
	 * @param interval
	 * @param filterPanel
	 * @return
	 */
	public List<WaterLevelsWell> getWellTimeSeriesCatalog ( String dataType, String interval, ColoradoHydroBaseRest_Well_InputFilter_JPanel filterPanel ) {
		List<WaterLevelsWell> wellList = new ArrayList<>();
		Message.printStatus(1, "", "Getting ColoradoHydroBaseRest well time series list");
		return wellList;
	}

}
