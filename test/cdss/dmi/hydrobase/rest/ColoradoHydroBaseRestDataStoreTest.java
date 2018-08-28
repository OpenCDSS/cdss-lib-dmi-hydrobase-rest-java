package cdss.dmi.hydrobase.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cdss.dmi.hydrobase.rest.ColoradoHydroBaseRestDataStore;
import cdss.dmi.hydrobase.rest.dao.DiversionComments;
import cdss.dmi.hydrobase.rest.dao.DiversionStageVolume;
import cdss.dmi.hydrobase.rest.dao.ParcelUseTimeSeries;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesCounty;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesCurrentInUseCodes;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesDesignatedBasin;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesDivRecObservationCodes;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesDivRecTypes;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesGroundwaterPublication;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesManagementDistrict;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesPermitActionName;
import cdss.dmi.hydrobase.rest.dao.TelemetryDecodeSettings;
import cdss.dmi.hydrobase.rest.dao.TelemetryDischargeMeasurement;
import cdss.dmi.hydrobase.rest.dao.TelemetryStationDataTypes;

/**
 * In general, tests are created for methods using web services where there 
 * is a command missing that already test that method in TSTool or StateDMI.
 * With the exception of readTimeSeries because read time series is using several
 * of these methods so it will be easier to track down issues using JUnit.
 * @author intern2
 *
 */

public class ColoradoHydroBaseRestDataStoreTest {
	
	private static ColoradoHydroBaseRestDataStore chrds;
	
	public void writeToFile(String fileName, String contents){
		String folder = System.getProperty("user.dir") + "/test/";
		BufferedWriter writer;
		File file;
		try {
			file = new File(folder + fileName);
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(contents);

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize Colorado HydroBase Rest Datastore
	 * No apiKey
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	@BeforeClass
	public static void create() throws URISyntaxException, IOException{
		chrds = new ColoradoHydroBaseRestDataStore("DWR", "Colorado Division of Water Resources Hydrobase", 
				new URI("http://dnrweb.state.co.us/DWR/DwrApiService/api/v2"), "");
	}
	
	/**
	 * Test that counties list is working by verifying length of
	 * results.
	 * Also verifies readCounties().
	 */
	@Test
	public void getCountiesLength(){
		int expectedLength = 65;
		
		List<ReferenceTablesCounty> counties = chrds.getCounties();
		int resultLength = counties.size();
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test that current in use codes list is working by verifying
	 * length of results.
	 * Also verifies readCurrentInUseCodes().
	 */
	@Test
	public void getCurrentInUseCodesLength(){
		int expectedLength = 9;
		
		List<ReferenceTablesCurrentInUseCodes> currentInUseCodes = chrds.getCurrentInUseCodes();
		int resultLength = currentInUseCodes.size();
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test that designated basin list is working by verifying 
	 * length of results
	 * Also verifies readDesignatedBasins()
	 */
	@Test
	public void getDesignatedBasinLength(){
		int expectedLength = 8;
		
		List<ReferenceTablesDesignatedBasin> desBasin = chrds.getDesignatedBasin();
		int resultLength = desBasin.size();
		
		assertThat(expectedLength, equalTo(resultLength));
	}

	/**
	 * Test returning a single divComment back by specifying the irrYear and
	 * compares it to the expected result specified below.
	 */
	@Test
	public void getSingleDivCommentFromWdidAndIrrYear() {
		// Create expected result for a single div comment.
		DiversionComments divComment = new DiversionComments();
		divComment.setApprovalStatus("Approved");
		divComment.setComment("AKA LITTLE CACHE ");
		divComment.setCommentType("DIVERSION");
		divComment.setIrrYear(1999);
		divComment.setModified("2001-08-14T11:14:52.187");
		divComment.setNotUsed(null);
		divComment.setNotUsedDescr(null);
		divComment.setWdid("0300915");
		
		//Create list with expected diversion comment results
		List<DiversionComments> expectedResultsList = new ArrayList<DiversionComments>();
		expectedResultsList.add(divComment);
		
		//writeToFile("expectedResults/SingleDivCommentFromWdidAndIrrYear.txt", Arrays.asList(expectedResultsList).toString());
		
		// Test one irrigation year and one WDID to limit the test data
		String wdid = "0300915";
		int irrYear = 1999;
		List<DiversionComments> resultsList = chrds.getDivComments(wdid, null, irrYear);
		
		writeToFile("results/SingleDivCommentFromWdidAndIrrYear.txt", Arrays.asList(expectedResultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
	}
	
	@Test
	public void getSingleDiversionStageVolumeFromWdidAndDataMeasDate(){
		//Create expected result for a single div stage volume
		DiversionStageVolume divStageVol = new DiversionStageVolume();
		divStageVol.setApprovalStatus("Approved");
		divStageVol.setDataMeasDate("1999-09-30T00:00:00");
		divStageVol.setModified("2001-08-14T11:47:18.903");
		divStageVol.setStage(194.4100);
		divStageVol.setWdid("8003550");
		divStageVol.setVolume(64595.0000);
		
		//Create list with expected diversion stage volume results
		List<DiversionStageVolume> expectedResultsList = new ArrayList<DiversionStageVolume>();
		expectedResultsList.add(divStageVol);
		
		//writeToFile("expectedResults/SingleDiversionStageVolumeFromWdidAndDataMeasDate.txt", Arrays.asList(expectedResultsList).toString());
		
		//Test one data meas date year and one wdid to limit the test data
		String wdid = "8003550";
		String dataMeasDate = "09/30/1999";
		List<DiversionStageVolume> resultsList = chrds.getDiversionStageVolume(wdid, dataMeasDate, null);
		
		writeToFile("results/SingleDiversionStageVolumeFromWdidAndDataMeasDate.txt", Arrays.asList(resultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
	}
	
	/**
	 * Test that div rec observation codes list is correct by getting length
	 * of results.
	 * Also verifies readDivRecObservationCodes().
	 */
	@Test 
	public void getDivRecObservationCodesLength(){
		int expectedLength = 9;
		
		List<ReferenceTablesDivRecObservationCodes> divRecObsCodes = chrds.getDivRecObservationCodes();
		int resultLength = divRecObsCodes.size();
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test that div rec types list is correct by getting length of
	 * results.
	 * Also verifies readDivRecTypes().
	 */
	@Test
	public void getDivRecTypesLength(){
		int expectedLength = 6;
		
		List<ReferenceTablesDivRecTypes> divRecTypes = chrds.getDivRecTypes();
		int resultLength = divRecTypes.size();
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test that groundwater publication list is correct by getting length
	 * of results.
	 * Also verifies readGroundwaterPublication().
	 */
	@Test
	public void getGroundwaterPublicationLength(){
		int expectedLength = 17;
		
		List<ReferenceTablesGroundwaterPublication> grndwaterPublication = chrds.getGroundwaterPublication();
		int resultLength = grndwaterPublication.size();
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test that management district list is correct by getting length of 
	 * results.
	 * Also verifies readManagmentDistrict().
	 */
	@Test
	public void getManagementDistrictLength(){
		int expectedLength = 14;
		
		List<ReferenceTablesManagementDistrict> managementDistrict = chrds.getManagementDistrict();
		int resultLength = managementDistrict.size();
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test getting a parcel use using wdid and parcel use id
	 * compares 1 result from web services
	 */
	@Test
	public void parcelUseTSListFromParcelId(){
		ParcelUseTimeSeries parcelUseTS = new ParcelUseTimeSeries();
		parcelUseTS.setWdid("2000505");
		parcelUseTS.setDiv(3);
		parcelUseTS.setStructureName("ALAMOSA D");
		parcelUseTS.setCalYear(1998);
		parcelUseTS.setParcelId(32004373);
		parcelUseTS.setLandUse("GRASS_PASTURE");
		parcelUseTS.setIrrigType("FLOOD");
		parcelUseTS.setAcresProrated(102.0551);
		parcelUseTS.setAcresTotal(102.0551);
		parcelUseTS.setAssocSwWdid("1");
		parcelUseTS.setAssocGwWdid("0");
		parcelUseTS.setModified("2018-08-07T14:00:13.757");
		
		List<ParcelUseTimeSeries> expectedResultsList = new ArrayList<ParcelUseTimeSeries>();
		expectedResultsList.add(parcelUseTS);
		
		//writeToFile("expectedResults/ParcelUseTSListFromParcelId.txt", Arrays.asList(expectedResultsList).toString());
		
		String wdid = "2000505";
		int parcelId = 32004373;
		List<ParcelUseTimeSeries> resultsList = chrds.getParcelUseTSListFromParcelId(wdid, parcelId);
		
		writeToFile("results/ParcelUseTSListFromParcelId.txt", Arrays.asList(resultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
	}
	
	/**
	 * Test that permit action name list is correct by checking
	 * length of results.
	 * Also verifies readPermitActionName().
	 */
	@Test
	public void getPemitActionNameLength(){
		int expectedLength = 54;
		
		List<ReferenceTablesPermitActionName> permitActionName = chrds.getPermitActionName();
		int resultLength = permitActionName.size();
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Tests retrieving a single telemetry station data type using 
	 * a wdid.
	 */
	@Test
	public void getSingleTelemetryStationDataTypeFromWdid(){
		
		TelemetryStationDataTypes telStationDataType = new TelemetryStationDataTypes();
		telStationDataType.setDivision(7);
		telStationDataType.setWaterDistrict(33);
		telStationDataType.setCounty("LA PLATA");
		telStationDataType.setStationName("LA PLATA RIVER AT THE COLORADO-NEW MEXICO STATELINE");
		telStationDataType.setDataSourceAbbrev("DWR");
		telStationDataType.setDataSource("Co. Division of Water Resources");
		telStationDataType.setAbbrev("LAPMEXCO");
		telStationDataType.setWdid("3302204");
		telStationDataType.setUsgsStationId("09366500");
		telStationDataType.setStationStatus("Active");
		telStationDataType.setStationType("Stream Gage");
		telStationDataType.setWaterSource("LA PLATA RIVER");
		telStationDataType.setGnisId("00897392");
		telStationDataType.setStreamMile(0.01);
		telStationDataType.setStructureType("Stream Gage");
		telStationDataType.setParameter("AIRTEMP");
		telStationDataType.setParameterUnit("DEG F");
		telStationDataType.setContrArea(0.0);
		telStationDataType.setDrainArea(0.0);
		telStationDataType.setHuc10("14080105");
		telStationDataType.setUtmX(216243.1);
		telStationDataType.setUtmY(4099593.1);
		telStationDataType.setLatdecdeg(36.999694);
		telStationDataType.setLongdecdeg(-108.188667);
		telStationDataType.setLocationAccuracy(null);
		telStationDataType.setModified("2016-01-13T09:45:58.277");
		
		List<TelemetryStationDataTypes> expectedResultsList = new ArrayList<TelemetryStationDataTypes>();
		expectedResultsList.add(telStationDataType);
		
		//writeToFile("expectedResults/SingleTelemetryStationDataTypeFromWdid.txt", Arrays.asList(expectedResults).toString());
	
		String[] inputFilters = {"str_name", "MA", "3302204"};
		List<String[]> listOfTriplets = new ArrayList<String[]>();
		listOfTriplets.add(inputFilters);
		List<TelemetryStationDataTypes> resultsList = chrds.getTelemetryDataTypes("AIRTEMP", "15min", listOfTriplets);
		
		writeToFile("results/SingleTelemetryStationDataTypeFromWdid.txt", Arrays.asList(resultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
		
	}
	
	/**
	 * Test that telemetry data type parameters string list is correct
	 * by testing the length of the results
	 */
	@Test
	public void getTelemetryDataTypeParametersFromWebServicesLength(){
		int expectedLength = 40;
		
		String[] telParams = chrds.getTelemetryDataTypeParametersFromWebServices();
		int resultLength = telParams.length;
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test getting a single 
	 */
	@Test
	public void getSingleTelemetryDecodeSettingsFromAbbrev(){
		TelemetryDecodeSettings telDecodeSetting = new TelemetryDecodeSettings();
		telDecodeSetting.setAbbrev("ABCLATCO");
		telDecodeSetting.setParameter("DISCHRG1");
		telDecodeSetting.setFunction("GH1");
		telDecodeSetting.setRatingTableName("ABCLATCO02");
		telDecodeSetting.setRatingStartDate("2010-01-29T13:41:05.45-07:00");
		telDecodeSetting.setShiftCurveName(null);
		telDecodeSetting.setShiftcurveStartDate(null);
		telDecodeSetting.setCurrentShift(0.0);
		telDecodeSetting.setShiftStartDate("2018-08-09T09:10:38.63-06:00");
		telDecodeSetting.setModified("2018-08-09T09:10:38.63-06:00");
		
		List<TelemetryDecodeSettings> expectedResultsList = new ArrayList<TelemetryDecodeSettings>();
		expectedResultsList.add(telDecodeSetting);
		writeToFile("expectedResults/SingleTelemetryDecodeSettings.txt", Arrays.asList(expectedResultsList).toString());

		List<TelemetryDecodeSettings> resultsList = chrds.getTelemetryDecodeSettings("ABCLATCO");
		writeToFile("results/SingleTelemetryDecodeSettings.txt", Arrays.asList(resultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
		
	}
	
	/**
	 * Test that Jackson deserialization is working correctly by querying a single
	 * telemetry discharge measurement from the abbreviation.
	 */
	@Test
	public void getSingleTelemetryDischargeMeasurementFromAbbrev(){
		TelemetryDischargeMeasurement telDisMeas = new TelemetryDischargeMeasurement();
		telDisMeas.setDivision(7);
		telDisMeas.setWaterDistrict(29);
		telDisMeas.setCounty(null);
		telDisMeas.setAbbrev("2900686A");
		telDisMeas.setMeasNo("1");
		telDisMeas.setMeasDateTime("2011-08-09T17:28:00-06:00");
		telDisMeas.setMeasMadeBy("BKB");
		telDisMeas.setChannelWidth(10.1);
		telDisMeas.setSectionArea(17.5);
		telDisMeas.setMeanVelocity(1.75);
		telDisMeas.setGageHeight(1.18);
		telDisMeas.setDischarge(30.7);
		telDisMeas.setShiftAdjustment(0.0);
		telDisMeas.setPercentDifference(-1.6);
		telDisMeas.setMeasMethod(".6");
		telDisMeas.setMeasSections(21);
		telDisMeas.setGageHeightChange(-0.01);
		telDisMeas.setMeasDuration(0.35);
		telDisMeas.setMeterNo("A99170");
		telDisMeas.setMeasRemarks("Found very good measurement section");
		telDisMeas.setModified("2013-05-22T16:22:29.663-06:00");
		
		List<TelemetryDischargeMeasurement> expectedResultsList = new ArrayList<TelemetryDischargeMeasurement>();
		expectedResultsList.add(telDisMeas);
		writeToFile("expectedResults/SingleTelemetryDischargeMeasurementFromAbbrev.txt", Arrays.asList(expectedResultsList).toString());
		
		List<TelemetryDischargeMeasurement> resultsList = chrds.getTelemetryDischargeMeasurement("2900686A", null, -1, -1);
		writeToFile("results/SingleTelemetryDischargeMeasurementFromAbbrev.txt", Arrays.asList(resultsList).toString());

		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
	}
	
	

}
