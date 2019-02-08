// ColoradoHydroBaseRest_TelemetryStation_TableModel - table model for telemetry station

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

import java.text.DecimalFormat;
import java.util.List;

import RTi.TS.TSIdent;
import RTi.TS.TimeSeriesIdentifierProvider;
import RTi.Util.GUI.JWorksheet;
import RTi.Util.GUI.JWorksheet_AbstractRowTableModel;
import cdss.dmi.hydrobase.rest.dao.TelemetryStationDataTypes;

/**
This class is a table model for time series header information for HydroBase station time series.
By default the sheet will contain row and column numbers.
*/
@SuppressWarnings("serial")
public class ColoradoHydroBaseRest_TelemetryStation_TableModel<T> extends JWorksheet_AbstractRowTableModel<T>
implements TimeSeriesIdentifierProvider
{

/**
Number of columns in the table model, including the row number.
*/
private final int __COLUMNS = 21;

public final int COL_ID = 0;
public final int COL_ABBREV = 1;
public final int COL_NAME = 2;
public final int COL_DATA_SOURCE = 3;
public final int COL_DATA_SOURCE_NAME = 4;
public final int COL_DATA_TYPE = 5;
public final int COL_TIME_STEP = 6;
public final int COL_UNITS = 7;
public final int COL_START = 8;
public final int COL_END = 9;
public final int COL_MEAS_COUNT = 10;
public final int COL_DIV = 11;
public final int COL_DIST = 12;
public final int COL_COUNTY = 13;
public final int COL_STATE = 14;
public final int COL_HUC = 15;
public final int COL_LONG = 16;
public final int COL_LAT = 17;
public final int COL_UTM_X = 18;
public final int COL_UTM_Y = 19;
public final int COL_INPUT_TYPE = 20;

/**
Input type for time series identifier (default to "HydroBase" but can be set to allow class to be used
with other State-related data, such as ColoradoWaterSMS).
*/
private String __inputType = "ColoradoHydroBaseRest";

/**
Constructor.  This builds the model for displaying the given HydroBase time series data.
The input type defaults to "HydroBase".
@param worksheet the JWorksheet that displays the data from the table model.
@param data the list of HydroBase_StationGeolocMeasType that will be displayed in the table
(null is allowed - see setData()).
@inputName input name for time series (default if not specified is "HydroBase").  Use this, for example,
when using the class to display data from the ColoradoWaterSMS database.
@throws Exception if an invalid results passed in.
*/
public ColoradoHydroBaseRest_TelemetryStation_TableModel ( JWorksheet worksheet, List<T> data )
throws Exception
{
    this ( worksheet, data, null );
}

/**
Constructor.  This builds the model for displaying the given HydroBase time series data.
@param worksheet the JWorksheet that displays the data from the table model.
@param data the list of HydroBase_StationGeolocMeasType or HydroBase_StructureGeolocStructMeasType
that will be displayed in the table (null is allowed - see setData()).
@inputType input type for time series (default if null or blank is "HydroBase").  Use this, for example,
when using the class to display data from the ColoradoWaterSMS database.
@throws Exception if an invalid results passed in.
*/
public ColoradoHydroBaseRest_TelemetryStation_TableModel ( JWorksheet worksheet, List<T> data, String inputType )
throws Exception
{
	if ( data == null ) {
		_rows = 0;
	}
	else {
	    _rows = data.size();
	}
	_data = data;
	if ( (inputType != null) && !inputType.equals("") ) {
	    __inputType = inputType;
	}
}

/**
From AbstractTableModel.  Returns the class of the data stored in a given column.
@param columnIndex the column for which to return the data class.
*/
public Class<?> getColumnClass (int columnIndex) {
	switch (columnIndex) {
		// FIXME - can't seem to handle missing...
		//case COL_START:		return Integer.class;
		//case COL_END:			return Integer.class;
		//case COL_DIV:			return Integer.class;
		//case COL_DIST:		return Integer.class;
		default: return String.class;
	}
}

/**
From AbstractTableMode.  Returns the number of columns of data.
@return the number of columns of data.
*/
public int getColumnCount() {
	return __COLUMNS;
}

/**
From AbstractTableMode.  Returns the name of the column at the given position.
@return the name of the column at the given position.
*/
public String getColumnName(int columnIndex) {
	switch (columnIndex) {
		case COL_ID: return "ID";
		case COL_ABBREV: return "CO Abbrev.";
		case COL_NAME: return "Name/Description";
		case COL_DATA_SOURCE_NAME: return "Data Source Name";
		case COL_DATA_SOURCE: return "Data Source";
		case COL_DATA_TYPE: return "Data Type";
		case COL_TIME_STEP: return "Time Step";
		case COL_UNITS: return "Units";
		case COL_START: return "Start";
		case COL_END: return "End";
		case COL_MEAS_COUNT: return "Meas. Count";
		case COL_DIV: return "Div.";
		case COL_DIST: return "Dist.";
		case COL_COUNTY: return "County";
		case COL_STATE: return "State";
		case COL_HUC: return "HUC";
        case COL_LONG: return "Longtitude";
        case COL_LAT: return "Latitude";
		case COL_UTM_X: return "UTM X";
		case COL_UTM_Y: return "UTM Y";
		case COL_INPUT_TYPE: return "Data Store/Input Type";
		default: return "";
	}
}

/**
Returns an array containing the column widths (in number of characters).
@return an integer array containing the widths for each field.
*/
public String[] getColumnToolTips() {
    String[] tips = new String[__COLUMNS];
    tips[COL_ID] = "Station identifier from primary data provider";
    tips[COL_ABBREV] =
        "Station abbreviation used with Satellite Monitoring System (River3+Place3+State2, like \"PLAKERCO\").";
    tips[COL_NAME] = "Station name";
    tips[COL_DATA_SOURCE_NAME] = "Organization/agency abbreviation";
    tips[COL_DATA_SOURCE] = "Organization/agency name";
    tips[COL_DATA_TYPE] = "Data type";
    tips[COL_TIME_STEP] = "Time step";
    tips[COL_UNITS] = "Data units are not currently available from web services for station/parameter";
    tips[COL_START] = "Starting date/time of available data";
    tips[COL_END] = "Ending date/time of available data";
    tips[COL_MEAS_COUNT] = "Count of available measurements";
    tips[COL_DIV] = "Water division";
    tips[COL_DIST] = "Water district";
    tips[COL_COUNTY] = "County name";
    tips[COL_STATE] = "State abbreviation";
    tips[COL_HUC] = "Hydrologic Unit Code";
    tips[COL_LONG] = "Longitude decimal degrees";
    tips[COL_LAT] = "Latitude decimal degrees";
    tips[COL_UTM_X] = "UTM X, meters";
    tips[COL_UTM_Y] = "UTM Y, meters";
    tips[COL_INPUT_TYPE] = "Input type or data store name";
    return tips;
}

/**
Returns an array containing the column widths (in number of characters).
@return an integer array containing the widths for each field.
*/
public int[] getColumnWidths() {
    int[] widths = new int[__COLUMNS];
    widths[COL_ID] = 12;
    widths[COL_ABBREV] = 7;
    widths[COL_NAME] = 20;
    widths[COL_DATA_SOURCE_NAME] = 10;
    widths[COL_DATA_SOURCE] = 10;
    widths[COL_DATA_TYPE] = 15;
    widths[COL_TIME_STEP] = 8;
    widths[COL_UNITS] = 8;
    widths[COL_START] = 10;
    widths[COL_END] = 10;
    widths[COL_MEAS_COUNT] = 8;
    widths[COL_DIV] = 5;
    widths[COL_DIST] = 5;
    widths[COL_COUNTY] = 8;
    widths[COL_STATE] = 3;
    widths[COL_HUC] = 8;
    widths[COL_LONG] = 8;
    widths[COL_LAT] = 8;
    widths[COL_UTM_X] = 8;
    widths[COL_UTM_Y] = 8;
    widths[COL_INPUT_TYPE] = 15;
    return widths;
}

/**
Returns the format to display the specified column.
@param column column for which to return the format.
@return the format (as used by StringUtil.formatString()).
*/
public String getFormat ( int column ) {
	switch (column) {
		default: return "%s"; // All are strings.
	}
}

/**
From AbstractTableMode.  Returns the number of rows of data in the table.
*/
public int getRowCount() {
	return _rows;
}

/**
Return a TSIdent object for the specified row, used to transfer the table to valid time series identifier.
@return the TSIdent object for the specified row.
@exception Exception if there is an error setting the interval in the TSIdent.
*/
public TSIdent getTimeSeriesIdentifier(int row) {
    TSIdent tsid = new TSIdent();
	String locType = "abbrev:";
    String abbrev = (String)getValueAt( row, COL_ABBREV );
    tsid.setLocation(locType + abbrev );
    tsid.setSource((String)getValueAt( row, COL_DATA_SOURCE));
    tsid.setType((String)getValueAt( row, COL_DATA_TYPE));
    try {
    	tsid.setInterval((String)getValueAt ( row, COL_TIME_STEP));
    }
    catch ( Exception e ) {
    	// Recast exception so it does not require declaring in method signature
    	throw new RuntimeException(e);
    }
    // Scenario is blank
    // Sequence number is blank
    tsid.setInputType((String)getValueAt( row, COL_INPUT_TYPE));
    // No input name
    // Format a simple comment that includes the telemetry station name
    String id = (String)getValueAt( row, COL_ID );
    if ( (id == null) || id.isEmpty() ) {
    	// Only include ABBREV in comment
    	tsid.setComment(abbrev + " - " + (String)getValueAt ( row, COL_NAME));
    }
    else {
    	// Also include ID in comment
    	tsid.setComment(abbrev + " (" + id + ") - " + (String)getValueAt ( row, COL_NAME));
    }
    return tsid;
}

//FIXME @jurentie 06/20/2018 imports/irrelevant code
/**
From AbstractTableModel.  Returns the data that should be placed in the JTable at the given row and column.
@param row the row for which to return data.
@param col the column for which to return data.
@return the data that should be placed in the JTable at the given row and column.
*/
public Object getValueAt(int row, int col)
{	
	
	// If sorted, get the position in the data from the displayed row.
	// TODO @jurentie 06/22/2018 ask steve if you can remove this
	if (_sortOrder != null) {
		row = _sortOrder[row];
	}
	
	DecimalFormat df = new DecimalFormat();
	df.setMaximumFractionDigits(6);
	df.setMinimumFractionDigits(6);

	TelemetryStationDataTypes tsds = (TelemetryStationDataTypes)_data.get(row);
	
	switch (col) {
		// case 0 handled above.
		case COL_ID: return tsds.getWdid();
		case COL_ABBREV: return tsds.getAbbrev();
		case COL_NAME: return tsds.getStationName();
		case COL_DATA_SOURCE_NAME: return tsds.getDataSource();
		case COL_DATA_SOURCE: return tsds.getDataSourceAbbrev();
		case COL_DATA_TYPE: return tsds.getParameter();
		case COL_TIME_STEP: return tsds.getTimeStep();
		//case COL_UNITS: return
		//case COL_START:
		//case COL_END:
		//case COL_MEAS_COUNT: return
		case COL_DIV: return tsds.getDivision();
		case COL_DIST: return tsds.getWaterDistrict();
		case COL_COUNTY: return tsds.getCounty();
		case COL_STATE: return "CO";
		case COL_HUC: return tsds.getHuc10();
		case COL_LONG: return df.format(tsds.getLongdecdeg());
		case COL_LAT: return df.format(tsds.getLatdecdeg());
		case COL_UTM_X: return tsds.getUtmX();
		case COL_UTM_Y: return tsds.getUtmY();
		case COL_INPUT_TYPE: return __inputType;
		default: return "";
	}
}

/**
Set the input type (default is "HydroBase" but need to change when the table model is used for
multiple purposes.
*/
public void setInputType ( String inputType )
{
    __inputType = inputType;
}

}
