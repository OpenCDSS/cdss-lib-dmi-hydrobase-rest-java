// ColoradoHydroBaseRest_Station_InputFilter_JPanel - input filter panel for station

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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import RTi.Util.GUI.InputFilter;
import RTi.Util.GUI.InputFilter_JPanel;

import RTi.Util.String.StringUtil;
import cdss.dmi.hydrobase.rest.ColoradoHydroBaseRestDataStore;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesCounty;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesWaterDistrict;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesWaterDivision;

@SuppressWarnings("serial")
public class ColoradoHydroBaseRest_Station_InputFilter_JPanel
extends InputFilter_JPanel
implements MouseListener
{
    
/**
Datastore for this panel
*/
private ColoradoHydroBaseRestDataStore datastore = null;

/**
Create an InputFilter_JPanel for ColoradoHydroBaseRest web services historical station queries.
This is used by TSTool.
Default filter panel properties are used (e.g., 3 filter groups).
@return a JPanel containing InputFilter instances for historical station queries.
@param dataStore ColoradoHydroBaseRestDataStore instance.
@exception Exception if there is an error.
*/
public ColoradoHydroBaseRest_Station_InputFilter_JPanel ( ColoradoHydroBaseRestDataStore dataStore )
throws Exception
{	this ( dataStore, -1, -1 );
}

/**
Create an InputFilter_JPanel for ColoradoHydroBaseRest web services historical station queries.
This is used by TSTool.
@return a JPanel containing InputFilter instances for historical station queries.
@param dataStore ColoradoHydroBaseRestDataStore instance.
@param numFilterGroups the number of filter groups to display
@param numWhereChoicesToDisplay the number of where choices to display in each filter
@exception Exception if there is an error.
*/
public ColoradoHydroBaseRest_Station_InputFilter_JPanel (
		ColoradoHydroBaseRestDataStore datastore, int numFilterGroups, int numWhereChoicesToDisplay )
throws Exception
{	this.datastore = datastore;
	
	// Now define the input filters

	List<InputFilter> input_filters = new Vector<InputFilter>(8);
	input_filters.add ( new InputFilter ("", "",
	    StringUtil.TYPE_STRING, null, null, true ) ); // Blank to disable filter

	InputFilter filter;
	// TODO smalers 2018-06-20 Don't show any filters until station web service is actually available
	/*
    // County
	List<ReferenceTablesCounty> countyDataList = datastore.getCounties();
	List<String> countyList = new ArrayList<String> ( countyDataList.size() );
	for ( ReferenceTablesCounty county : countyDataList ) {
		countyList.add ( county.getCounty() ); // TODO smalers 2018-06-19 HydroBase has state + ", CO" );
	}
	filter = new InputFilter ( "County", "county", "county",
		StringUtil.TYPE_STRING, countyList, countyList, false );
	filter.setTokenInfo(",",0);
	input_filters.add ( filter );

	// Water district
	List<ReferenceTablesWaterDistrict> districtDataList = datastore.getWaterDistricts();
	List<String> districtList = new ArrayList<String> ( districtDataList.size() );
	List<String> districtInternalList = new ArrayList<String>(districtDataList.size());
	for ( ReferenceTablesWaterDistrict wd : districtDataList ) {
		districtList.add ("" + wd.getWd() + " - " + wd.getWdName());
		districtInternalList.add ("" + wd.getWd() );
	}
	filter = new InputFilter ( "Water District", "waterDistrict", "waterDistrict",
		StringUtil.TYPE_STRING, districtList, districtInternalList, false );
	filter.setTokenInfo("-",0);
	input_filters.add ( filter );

	// Water division
	List<ReferenceTablesWaterDivision> divisionDataList = datastore.getWaterDivisions();
	List<String> divisionList = new ArrayList<String> ( 7 );
	List<String> divisionInternalList = new ArrayList<String> ( 7 );
	for ( ReferenceTablesWaterDivision div: divisionDataList ) {
		divisionList.add ("" + div.getDiv() + " - " + div.getDivName());
		divisionInternalList.add ("" + div.getDiv() );
	}
	filter = new InputFilter ( "Water Division", "waterDivision", "waterDivision",
		StringUtil.TYPE_STRING, divisionList, divisionInternalList, false );
	filter.setTokenInfo("-",0);
	input_filters.add ( filter );
	*/
	
	// Include this filter to help developers see when the station panel is mistakenly being shown
    input_filters.add ( new InputFilter ( "Stations are not enabled", "stationId", "stationId",
            StringUtil.TYPE_STRING, null, null, true ) );

	if ( numFilterGroups < 0 ) {
		// Set number of filter groups to 4 so that latitude, longitude, radius, units, and one other can be specified
		numFilterGroups = 5;
	}
	if ( numWhereChoicesToDisplay < 0 ) {
		// Set the number of visible rows in the choices
		numWhereChoicesToDisplay = input_filters.size();
	}
	setToolTipText ( "<html>ColoradoHydroBaseRest station queries can be filtered based on station data.</html>" );
	setInputFilters ( input_filters, numFilterGroups, numWhereChoicesToDisplay );
}

/**
 * Check the input filter for appropriate combination of choices.
 * These checks can be performed in the ReadColoradoHydroBaseRest command and the main TSTool UI,
 * both of which use this class.
 * @param displayWarning If true, display a warning dialog if there are errors in the input.
 * If false, do not display a warning, in which case
 * the calling code should generally display a warning and optionally
 * also perform other checks by overriding this method.
 * @return null if no issues or a string that indicates issues,
 * can use \n for line breaks and put at the front of the string.
 */
@Override
public String checkInputFilters ( boolean displayWarning ) {
	// Use the parent class method to check basic input types based on data types
	// - will return empty string if no issues
	String warning = super.checkInputFilters(displayWarning);
	// Perform specific checks
	String warning2 = "";
	int coordCount = 0;
	String Latitude = getInputValue("Latitude", false);
	String Longitude = getInputValue("Longitude", false);
	String LatLongRadius = getInputValue("LatLongRadius", false);
	String LatLongRadiusUnits = getInputValue("LatLongRadiusUnits", false);
	if ( (Latitude != null) && !Latitude.isEmpty() ) {
		++coordCount;
	}
	if ( (Longitude != null) && !Longitude.isEmpty() ) {
		++coordCount;
	}
	if ( (LatLongRadius != null) && !LatLongRadius.isEmpty() ) {
		++coordCount;
	}
	if ( (LatLongRadiusUnits != null) && !LatLongRadiusUnits.isEmpty() ) {
		++coordCount;
	}
	if ( (coordCount > 0) && (coordCount != 4) ) {
		warning2 += "\nSpecifying latitude and longitude requires specifying latitude, longitude, radius, and units.";
	}
	if ( !warning2.isEmpty() ) {
		// Have non-empty specific warnings so append specific warnings
		warning += warning2;
	}
	// Return the general warnings or the appended results
	return warning;
}

public ColoradoHydroBaseRestDataStore getColoradoHydroBaseRestDataStore ()
{
    return this.datastore;
}

public void mouseClicked(MouseEvent event) {}

public void mouseExited(MouseEvent event) {}

public void mouseEntered(MouseEvent event) {}

/**
Responds to mouse pressed events.
@param event the event that happened.
*/
public void mousePressed(MouseEvent event) {
    /** Not enabled - used for PLSS query
	JFrame temp = new JFrame();
	JGUIUtil.setIcon(temp, JGUIUtil.getIconImage());	
	HydroBase_GUI_Util.buildLocation(temp, (JTextField)event.getSource());
	*/
}

public void mouseReleased(MouseEvent event) {}

}
