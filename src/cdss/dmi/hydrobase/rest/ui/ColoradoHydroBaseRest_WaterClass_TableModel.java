package cdss.dmi.hydrobase.rest.ui;

import java.util.List;

import RTi.TS.TSIdent;
import RTi.TS.TimeSeriesIdentifierProvider;
import RTi.Util.GUI.JWorksheet;
import RTi.Util.GUI.JWorksheet_AbstractRowTableModel;
import cdss.dmi.hydrobase.rest.dao.DiversionWaterClass;


// FIXME @jurentie why is this complaining? 06/22/2018
/**
This class is a table model for time series header information for HydroBase waterclass time series.
By default the sheet will contain row and column numbers.
*/
@SuppressWarnings("serial")
public class ColoradoHydroBaseRest_WaterClass_TableModel
extends JWorksheet_AbstractRowTableModel implements TimeSeriesIdentifierProvider
{

/**
Number of columns in the table model, including the row number.
*/
private final int __COLUMNS = 22;

public final int COL_ID = 0;
public final int COL_NAME = 1;
public final int COL_DATA_SOURCE = 2;
public final int COL_DATA_TYPE = 3;
public final int COL_TIME_STEP = 4;
public final int COL_UNITS = 5;
public final int COL_START = 6;
public final int COL_END = 7;
public final int COL_MEAS_COUNT = 8;
public final int COL_DIV = 9;
public final int COL_DIST = 10;
public final int COL_COUNTY = 11;
public final int COL_STATE = 12;
public final int COL_HUC = 13;
public final int COL_LONG = 14;
public final int COL_LAT = 15;
public final int COL_UTM_X = 16;
public final int COL_UTM_Y = 17;
public final int COL_STR_TYPE = 18;
public final int COL_STRTYPE = 19;
public final int COL_WDID = 20;
public final int COL_INPUT_TYPE = 21;

/**
Input type for time series identifier (default to "HydroBase" but can be set to allow class to be used
with other State-related data, such as ColoradoWaterSMS).
*/
private String __inputType = "ColoradoHydroBaseRest";

private String __timeStep = null;

/**
Constructor.  This builds the model for displaying the given HydroBase time series data.
The input type defaults to "HydroBase".
@param worksheet the JWorksheet that displays the data from the table model.
@param data the list of HydroBase_StationGeolocMeasType or HydroBase_StructureGeolocStructMeasType
that will be displayed in the table (null is allowed - see setData()).
@inputName input name for time series (default if not specified is "HydroBase").  Use this, for example,
when using the class to display data from the ColoradoWaterSMS database.
@throws Exception if an invalid results passed in.
*/
public ColoradoHydroBaseRest_WaterClass_TableModel ( JWorksheet worksheet, List<DiversionWaterClass> data )
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
public ColoradoHydroBaseRest_WaterClass_TableModel ( JWorksheet worksheet, List<DiversionWaterClass> data, String inputType )
throws Exception
{	if ( data == null ) {
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
public Class getColumnClass (int columnIndex) {
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
		case COL_NAME: return "Name/Description";
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
		case COL_STR_TYPE: return "DSS Waterclass Type";
		case COL_STRTYPE: return "Waterclass Type";
		case COL_WDID: return "WDID";
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
    tips[COL_ID] = "Waterclass identifier from primary data provider";
    tips[COL_NAME] = "Waterclass name";
    tips[COL_DATA_SOURCE] = "Organization/agency abbreviation";
    tips[COL_DATA_TYPE] = "Data type";
    tips[COL_TIME_STEP] = "Time step";
    tips[COL_UNITS] = "Data units";
    tips[COL_START] = "Starting date/time of available data";
    tips[COL_END] = "Ending date/time of available data";
    tips[COL_MEAS_COUNT] = "Count of available measurements";
    tips[COL_DIV] = "Water division, determined from spatial location";
    tips[COL_DIST] = "Water district, determined from spatial location";
    tips[COL_COUNTY] = "County name, determined from spatial location";
    tips[COL_STATE] = "State abbreviation";
    tips[COL_HUC] = "Hydrologic Unit Code";
    tips[COL_LONG] = "Longitude decimal degrees";
    tips[COL_LAT] = "Latitude decimal degrees";
    tips[COL_UTM_X] = "UTM X, meters";
    tips[COL_UTM_Y] = "UTM Y, meters";
    tips[COL_STR_TYPE] = "Type of waterclass in broad DSS categories.";
    tips[COL_STRTYPE] = "A means to describe an administrative waterclasses " +
    	"physical diversion point in detail or a way to define a group of waterclass " +
    	"(e.g., augmentation plan, well field).";
    tips[COL_WDID] = "Water district identifier";
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
    widths[COL_NAME] = 20;
    widths[COL_DATA_SOURCE] = 10;
    widths[COL_DATA_TYPE] = 30;
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
    widths[COL_STR_TYPE] = 13;
    widths[COL_STRTYPE] = 10;
    widths[COL_WDID] = 5;
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
    String id = (String)getValueAt( row, COL_ID );
    tsid.setLocation(id);
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
    tsid.setComment(id + " - " + (String)getValueAt ( row, COL_NAME));
    return tsid;
}

/**
From AbstractTableModel.  Returns the data that should be placed in the JTable at the given row and column.
@param row the row for which to return data.
@param col the column for which to return data.
@return the data that should be placed in the JTable at the given row and column.
*/
public Object getValueAt(int row, int col)
{	
	
	// If sorted, get the position in the data from the displayed row.
	// TODO @jurentie 06/22/2018 ask steve if you can get rid of this
	if (_sortOrder != null) {
		row = _sortOrder[row];
	}
	
	// Cast _data row to DiversionWaterClass
	DiversionWaterClass divWC = (DiversionWaterClass)_data.get(row);
	
	// TODO @jurentie 06/22/2018 join structure with waterclass to finish populating table
	// Populate table with data values
	String divRecDataType = divWC.getDivrectype();
	String timeStep = divWC.getTimeStep();
	switch (col) {
		// case 0 handled above.
		case COL_ID: return divWC.getWdid();
		case COL_NAME: return divWC.getStructureName();
		case COL_DATA_SOURCE: return "DWR";
		case COL_DATA_TYPE:
			if(divRecDataType.equalsIgnoreCase("WATERCLASS")){
				String divWCIdentifier = divWC.getWcIdentifier();
				if(divWCIdentifier.indexOf('.') >= 0){
					// Have to wrap periods because they break normal TSID
					return TSIdent.PERIOD_QUOTE + divRecDataType + "-" + divWCIdentifier + TSIdent.PERIOD_QUOTE;
				}
				else {
					// No need for wrapping quotes
					return divRecDataType + "-" + divWCIdentifier;
				}
			}
			else {
				// "Simple" data types like "DivTotal"
				return divRecDataType;
			}
		case COL_TIME_STEP: return timeStep;
		case COL_UNITS:
			if ( divRecDataType.equalsIgnoreCase("DivTotal") || divRecDataType.equalsIgnoreCase("RelTotal") || divRecDataType.equalsIgnoreCase("WaterClass") ) {
				// Diversion records that all derive from daily CFS measurements, aggregated to month and year AF
				if ( timeStep.equalsIgnoreCase("Day")) {
					return "CFS";
				}
				else {
					return "AF";
				}
			}
			else {
				// TODO smalers 2018-06-30 fill this in as other data types are tested
				return "";
			}
		case COL_START: return divWC.getPorStart().getYear();
		case COL_END: return divWC.getPorEnd().getYear();
		//case COL_MEAS_COUNT: return
		case COL_DIV: return divWC.getDivision();
		case COL_DIST: return divWC.getWaterDistrict();
		case COL_COUNTY: return divWC.getCounty();
		case COL_STATE: return "CO";
		//case COL_HUC: return
		//case COL_LONG: return
		//case COL_LAT: return
		//case COL_UTM_X: return
    	//case COL_UTM_Y: return
		//case COL_STR_TYPE: return
		//case COL_STRTYPE: return
		case COL_WDID: return divWC.getWdid();
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

/**
Sets the alternate time step to display, rather than the one read from the
database.
*/
public void setTimeStep(String timeStep) {
	__timeStep = timeStep;
}

}