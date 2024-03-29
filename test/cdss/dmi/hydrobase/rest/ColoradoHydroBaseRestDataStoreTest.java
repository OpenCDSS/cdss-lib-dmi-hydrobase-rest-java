package cdss.dmi.hydrobase.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import cdss.dmi.hydrobase.rest.ColoradoHydroBaseRestDataStore;
import cdss.dmi.hydrobase.rest.dao.DiversionComments;
import cdss.dmi.hydrobase.rest.dao.DiversionStageVolume;
import cdss.dmi.hydrobase.rest.dao.DiversionWaterClass;
import cdss.dmi.hydrobase.rest.dao.ParcelUseTimeSeries;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesCounty;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesCurrentInUseCodes;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesDesignatedBasin;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesDivRecObservationCodes;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesDivRecTypes;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesGroundwaterPublication;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesManagementDistrict;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesPermitActionName;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesTelemetryParams;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesWaterDistrict;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesWaterDivision;
import cdss.dmi.hydrobase.rest.dao.TelemetryDecodeSettings;
import cdss.dmi.hydrobase.rest.dao.TelemetryDischargeMeasurement;
import cdss.dmi.hydrobase.rest.dao.TelemetryRatingTable;
import cdss.dmi.hydrobase.rest.dao.TelemetryShift;
import cdss.dmi.hydrobase.rest.dao.TelemetryStationDataType;
import cdss.dmi.hydrobase.rest.dao.WaterLevelsWell;
import cdss.dmi.hydrobase.rest.dao.WaterRightsNetAmount;
import cdss.dmi.hydrobase.rest.dao.WaterRightsTransaction;

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
	public void testLengthOfGetCountiesList(){
		int expectedLength = 65;
		
		List<ReferenceTablesCounty> counties = chrds.getCounties();
		int resultLength = counties.size();
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/CountiesList.txt", Arrays.asList(counties).toString());
		writeToFile("results/CountiesList.txt", Arrays.asList(counties).toString());
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test that current in use codes list is working by verifying
	 * length of results.
	 * Also verifies readCurrentInUseCodes().
	 */
	@Test
	public void testLengthOfGetCurrentInUseCodesList(){
		int expectedLength = 9;
		
		List<ReferenceTablesCurrentInUseCodes> currentInUseCodes = chrds.getCurrentInUseCodes();
		int resultLength = currentInUseCodes.size();
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/CurrentInUseCodesList.txt", Arrays.asList(currentInUseCodes).toString());
		writeToFile("results/CurrentInUseCodesList.txt", Arrays.asList(currentInUseCodes).toString());
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test that designated basin list is working by verifying 
	 * length of results
	 * Also verifies readDesignatedBasins()
	 */
	@Test
	public void testLengthOfGetDesignatedBasinList(){
		int expectedLength = 8;
		
		List<ReferenceTablesDesignatedBasin> desBasin = chrds.getDesignatedBasin();
		int resultLength = desBasin.size();
		
		//Uncomment the following the regenerate expected results
		writeToFile("expectedResults/DesignatedBasinList.txt", Arrays.asList(desBasin).toString());
		writeToFile("results/DesignatedBasinList.txt", Arrays.asList(desBasin).toString());
		
		assertThat(expectedLength, equalTo(resultLength));
	}

	/**
	 * Test returning a single divComment back by specifying the irrYear and
	 * compares it to the expected result specified below.
	 */
	@Test
	public void testDeserializationOfGetSingleDivCommentFromWdidAndIrrYear() {
		// Create expected result for a single div comment.
		DiversionComments divComment = new DiversionComments();
		divComment.setApprovalStatus("Approved");
		divComment.setComment("AKA LITTLE CACHE ");
		divComment.setCommentType("DIVERSION");
		divComment.setIrrYear(1999);
		divComment.setModified(null);
		divComment.setNotUsed(null);
		divComment.setNotUsedDescr(null);
		divComment.setWdid("0300915");
		
		//Create list with expected diversion comment results
		List<DiversionComments> expectedResultsList = new ArrayList<DiversionComments>();
		expectedResultsList.add(divComment);
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/SingleDivCommentFromWdidAndIrrYear.txt", Arrays.asList(expectedResultsList).toString());
		
		// Test one irrigation year and one WDID to limit the test data
		String wdid = "0300915";
		int irrYear = 1999;
		List<DiversionComments> resultsList = chrds.getDivComments(wdid, null, irrYear);
		resultsList.get(0).setModified(null);
		
		writeToFile("results/SingleDivCommentFromWdidAndIrrYear.txt", Arrays.asList(expectedResultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
	}
	
	@Test
	public void testDeserializationOfGetSingleDiversionStageVolumeFromWdidAndDataMeasDate(){
		//Create expected result for a single div stage volume
		DiversionStageVolume divStageVol = new DiversionStageVolume();
		divStageVol.setApprovalStatus("Approved");
		divStageVol.setDataMeasDate("1999-09-30T00:00:00");
		divStageVol.setModified(null);
		divStageVol.setStage(194.4100);
		divStageVol.setWdid("8003550");
		divStageVol.setVolume(64595.0000);
		
		//Create list with expected diversion stage volume results
		List<DiversionStageVolume> expectedResultsList = new ArrayList<DiversionStageVolume>();
		expectedResultsList.add(divStageVol);
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/SingleDiversionStageVolumeFromWdidAndDataMeasDate.txt", Arrays.asList(expectedResultsList).toString());
		
		//Test one data meas date year and one wdid to limit the test data
		String wdid = "8003550";
		String dataMeasDate = "09/30/1999";
		List<DiversionStageVolume> resultsList = chrds.getDiversionStageVolume(wdid, dataMeasDate, null);
		resultsList.get(0).setModified(null);
		
		writeToFile("results/SingleDiversionStageVolumeFromWdidAndDataMeasDate.txt", Arrays.asList(resultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
	}
	
	/**
	 * Test that div rec observation codes list is correct by getting length
	 * of results.
	 * Also verifies readDivRecObservationCodes().
	 */
	@Test 
	public void testLengthOfGetDivRecObservationCodesList(){
		int expectedLength = 9;
		
		List<ReferenceTablesDivRecObservationCodes> divRecObsCodes = chrds.getDivRecObservationCodes();
		int resultLength = divRecObsCodes.size();
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/DivRecObservationCodesList.txt", Arrays.asList(divRecObsCodes).toString());
		writeToFile("results/DivRecObservationCodesList.txt", Arrays.asList(divRecObsCodes).toString());
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test that div rec types list is correct by getting length of
	 * results.
	 * Also verifies readDivRecTypes().
	 */
	@Test
	public void testLengthOfGetDivRecTypesList(){
		int expectedLength = 6;
		
		List<ReferenceTablesDivRecTypes> divRecTypes = chrds.getDivRecTypes();
		int resultLength = divRecTypes.size();
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/DivRecTypesList.txt", Arrays.asList(divRecTypes).toString());
		writeToFile("results/DivRecTypesList.txt", Arrays.asList(divRecTypes).toString());
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test that groundwater publication list is correct by getting length
	 * of results.
	 * Also verifies readGroundwaterPublication().
	 */
	@Test
	public void testLengthOfGetGroundwaterPublicationList(){
		int expectedLength = 17;
		
		List<ReferenceTablesGroundwaterPublication> groundwaterPublication = chrds.getGroundwaterPublication();
		int resultLength = groundwaterPublication.size();
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/GroundwaterPublicationList.txt", Arrays.asList(groundwaterPublication).toString());
		writeToFile("results/GroundwaterPublicationList.txt", Arrays.asList(groundwaterPublication).toString());
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test that management district list is correct by getting length of 
	 * results.
	 * Also verifies readManagmentDistrict().
	 */
	@Test
	public void testLengthOfGetManagementDistrictList(){
		int expectedLength = 14;
		
		List<ReferenceTablesManagementDistrict> managementDistrict = chrds.getManagementDistrict();
		int resultLength = managementDistrict.size();
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/ManagementDistrictList.txt", Arrays.asList(managementDistrict).toString());
		writeToFile("results/ManagementDistrictList.txt", Arrays.asList(managementDistrict).toString());
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test getting a parcel use using wdid and parcel use id
	 * compares 1 result from web services
	 */
	@Test
	public void testDeserializationOfParcelUseTSListFromParcelId(){
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
		parcelUseTS.setModified(null);
		
		List<ParcelUseTimeSeries> expectedResultsList = new ArrayList<ParcelUseTimeSeries>();
		expectedResultsList.add(parcelUseTS);
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/ParcelUseTSListFromParcelId.txt", Arrays.asList(expectedResultsList).toString());
		
		String wdid = "2000505";
		int parcelId = 32004373;
		List<ParcelUseTimeSeries> resultsList = chrds.readParcelUseTSListForParcelId(wdid, parcelId);
		resultsList.get(0).setModified(null);
		
		writeToFile("results/ParcelUseTSListForParcelId.txt", Arrays.asList(resultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
	}
	
	/**
	 * Test that permit action name list is correct by checking
	 * length of results.
	 * Also verifies readPermitActionName().
	 */
	@Test
	public void testLengthOfGetPemitActionNameList(){
		int expectedLength = 56;
		
		List<ReferenceTablesPermitActionName> permitActionName = chrds.getPermitActionName();
		int resultLength = permitActionName.size();
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/PermitActionName.txt", Arrays.asList(permitActionName).toString());
		writeToFile("results/PermitActionName.txt", Arrays.asList(permitActionName).toString());
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Tests retrieving a single telemetry station data type using 
	 * a wdid.
	 */
	@Test
	public void testDeserializationOfGetSingleTelemetryStationDataTypeFromWdid(){
		
		TelemetryStationDataType telStationDataType = new TelemetryStationDataType();
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
		telStationDataType.setModified(null);
		
		List<TelemetryStationDataType> expectedResultsList = new ArrayList<TelemetryStationDataType>();
		expectedResultsList.add(telStationDataType);
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/SingleTelemetryStationDataTypeFromWdid.txt", Arrays.asList(expectedResults).toString());
	
		String[] inputFilters = {"str_name", "MA", "3302204"};
		List<String[]> listOfTriplets = new ArrayList<String[]>();
		listOfTriplets.add(inputFilters);
		List<TelemetryStationDataType> resultsList = chrds.getTelemetryStationDataTypes("AIRTEMP", "15min", listOfTriplets);
		resultsList.get(0).setModified(null);
		
		writeToFile("results/SingleTelemetryStationDataTypeFromWdid.txt", Arrays.asList(resultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
		
	}
	
	/**
	 * Test that telemetry data type parameters string list is correct
	 * by testing the length of the results
	 */
	@Test
	public void testLengthOfGetTelemetryDataTypeParametersFromWebServicesList(){
		int expectedLength = 36;
		
		List<ReferenceTablesTelemetryParams> telParamsList = chrds.getTelemetryParams();
		String[] telParams = new String[telParamsList.size()];
		for(int i = 0; i < telParamsList.size(); i++){
			telParams[i] = telParamsList.get(i).getParameter();
		}
		int resultLength = telParams.length;
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/TelemetryDataTypeParametersList.txt", Arrays.asList(telParams).toString());
		writeToFile("results/TelemetryDataTypeParametersList.txt", Arrays.asList(telParams).toString());
		
		assertThat(expectedLength, equalTo(resultLength));
	}
	
	/**
	 * Test getting a single 
	 */
	@Test
	public void testDeserializationOfGetSingleTelemetryDecodeSettingsFromAbbrev(){
		TelemetryDecodeSettings telDecodeSetting = new TelemetryDecodeSettings();
		telDecodeSetting.setAbbrev("ABCLATCO");
		telDecodeSetting.setParameter("DISCHRG1");
		telDecodeSetting.setFunction("GH1");
		telDecodeSetting.setRatingTableName("ABCLATCO02");
		telDecodeSetting.setRatingStartDate("2010-01-29T13:41:05.45-07:00");
		telDecodeSetting.setShiftCurveName(null);
		telDecodeSetting.setShiftcurveStartDate(null);
		telDecodeSetting.setCurrentShift(0.0);
		telDecodeSetting.setShiftStartDate(null);
		
		List<TelemetryDecodeSettings> expectedResultsList = new ArrayList<TelemetryDecodeSettings>();
		expectedResultsList.add(telDecodeSetting);
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/SingleTelemetryDecodeSettings.txt", Arrays.asList(expectedResultsList).toString());

		List<TelemetryDecodeSettings> resultsList = chrds.getTelemetryDecodeSettings("ABCLATCO");
		//Modified will change. Remove it from the testing
		resultsList.get(0).setModified(null);
		resultsList.get(0).setShiftStartDate(null);
		writeToFile("results/SingleTelemetryDecodeSettings.txt", Arrays.asList(resultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
		
	}
	
	/**
	 * Test that Jackson deserialization is working correctly by querying a single
	 * telemetry discharge measurement from the abbreviation.
	 */
	@Test
	public void testDeserializationOfGetSingleTelemetryDischargeMeasurementFromAbbrev(){
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
		telDisMeas.setModified(null);
		
		List<TelemetryDischargeMeasurement> expectedResultsList = new ArrayList<TelemetryDischargeMeasurement>();
		expectedResultsList.add(telDisMeas);
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/SingleTelemetryDischargeMeasurementFromAbbrev.txt", Arrays.asList(expectedResultsList).toString());
		
		String abbrev = "2900686A";
		List<TelemetryDischargeMeasurement> resultsList = chrds.getTelemetryDischargeMeasurement(abbrev, null, -1, -1);
		resultsList.get(0).setModified(null);
		writeToFile("results/SingleTelemetryDischargeMeasurementFromAbbrev.txt", Arrays.asList(resultsList).toString());

		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
	}
	
	/**
	 * The above tests that data is properly being deserialized from web services
	 * The following tests querying by other parameters and checking the length
	 * of the results.
	 */
	@Test
	public void testLengthOfGetSingleTelemetryDischargeMeasurementFromCountyList(){
		int expectedLength = 715;
		
		String county = "MESA";
		List<TelemetryDischargeMeasurement> resultsList = chrds.getTelemetryDischargeMeasurement(null, county, -1, -1);
		int resultsLength = resultsList.size();
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/TelemetryDischargeMeasurmentFromCounty.txt", Arrays.asList(resultsList).toString());
		writeToFile("results/TelemetryDischargeMeasurmentFromCounty.txt", Arrays.asList(resultsList).toString());
				
		assertThat(expectedLength, equalTo(resultsLength));
	}
	
	
	/**
	 * Test that telemetry params list is correct by checking 
	 * the length of results.
	 * Also tests readTelemetryParams().
	 */
	@Test
	public void testLengthOfGetTelemetryParamsList(){
		int expectedLength = 36;
		
		List<ReferenceTablesTelemetryParams> resultsList = chrds.getTelemetryParams();
		int resultsLength = resultsList.size();
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/TelemetryParamsList.txt", Arrays.asList(resultsList).toString());
		writeToFile("results/TelemetryParamsList.txt", Arrays.asList(resultsList).toString());
		
		assertThat(expectedLength, equalTo(resultsLength));
	}
	
	/**
	 * Test that telemetry rating table list is correct by checking length
	 * of results.
	 */
	@Test
	public void testLengthOfGetTelemetryRatingTableFromRatingTableName(){
		int expectedLength = 311;
		
		String ratingTableName = "ABCLATCO02";
		List<TelemetryRatingTable> resultsList = chrds.getTelemetryRatingTable(ratingTableName);
		int resultsLength = resultsList.size();
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/TelemetryRatingTableListFromRatingTableName.txt", Arrays.asList(resultsList).toString());
		writeToFile("results/TelemetryRatingTableListFromRatingTableName.txt", Arrays.asList(resultsList).toString());
		
		assertThat(expectedLength, equalTo(resultsLength));
	}
	
	//TODO @jurentie ADD TEST FOR TELEMETRY SHIFT CURVE
	
	@Test
	public void testLengthOfGetTelemetryShiftCurveFromShiftCurveName(){
		int expectedLength = 4;
		
		String shiftCurveName = "BOUBYPCOVST17-A";
		List<TelemetryShift> resultsList = chrds.getTelemetryShiftCurve(shiftCurveName);
		int resultsLength = resultsList.size();
		
		//Uncomment the following to regenerate expected results
		writeToFile("expectedResults/TelemetryShiftCurveFromShiftCurveName.txt", Arrays.asList(resultsList).toString());
		writeToFile("results/TelemetryShiftCurveFromShiftCurveName.txt", Arrays.asList(resultsList).toString());
		
		assertThat(expectedLength, equalTo(resultsLength));
	}
	
	@Test
	public void testDeserializationOfGetWaterClassesFromWdid(){
		DiversionWaterClass waterClass = new DiversionWaterClass();
		waterClass.setDivrectype("WaterClass");
		waterClass.setWaterclassNum(78969);
		waterClass.setWcIdentifier("1300529 S:1 F: U:1 T: G: To:");
		waterClass.setWdid("1300529");
		waterClass.setWdidAcctId(0);
		waterClass.setStructureName("MONITOR DITCH");
		waterClass.setWdidAcctName(0);
		waterClass.setSourceCode("1");
		waterClass.setSourceDescr("Natural Stream flow");
		waterClass.setFromWdidAcctId(0);
		waterClass.setFromWdidAcctName(0);
		waterClass.setUseCode("1");
		waterClass.setUseDescr("Irrigation");
		waterClass.setToWdidAcctId(0);
		waterClass.setToWdidAcctName(0);
		waterClass.setPorStart("1912-06-02T00:00:00");
		waterClass.setPorEnd("1975-07-09T00:00:00");
		waterClass.setPorLastModified("2004-06-09T12:53:00");
		waterClass.setDivision(2);
		waterClass.setWaterDistrict(13);
		waterClass.setCounty("CUSTER");
		waterClass.setModified(null);
		waterClass.setAvailableTimesteps("Day,Month,Year");
		waterClass.setWaterSource("NORTH COLONY CREEK");
		waterClass.setStreamMile(0.63);
		waterClass.setStructureType("DITCH");
		waterClass.setGnisId("00192422");
		waterClass.setCiuCode("I");
		waterClass.setCiuCodeLong("Inactive structure which physically exist, but no diversion records are maintained");
		waterClass.setPm("S");
		waterClass.setTownship("23.0 S");
		waterClass.setRange("72.0 W");
		waterClass.setSection("16");
		waterClass.setQ40("SW");
		waterClass.setQ160("SE");
		waterClass.setCoordsew(0);
		waterClass.setCoordsns(0);
		waterClass.setUtmX(461329.0);
		waterClass.setUtmY(4210892.5);
		waterClass.setLatdecdeg(38.044937);
		waterClass.setLongdecdeg(-105.440726);
		
		List<DiversionWaterClass> expectedResultsList = new ArrayList<DiversionWaterClass>();
		expectedResultsList.add(waterClass);
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/GetWaterClassesFromWdid.txt", Arrays.asList(expectedResultsList).toString());
		
		String[] inputFilters = {"WDID", "MA", "1300529"};
		List<String[]> listOfTriplets = new ArrayList<String[]>();
		listOfTriplets.add(inputFilters);
		
		String dataType = "WaterClass";
		String interval = "Month";
		
		List<DiversionWaterClass> resultsList = chrds.getWaterClasses(dataType, interval, listOfTriplets);
		resultsList.get(0).setModified(null);
		writeToFile("results/GetWaterClassesFromWdid.txt", Arrays.asList(resultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
	}
	
	/**
	 * Test that water districts list is correct by checking
	 * length of results.
	 * Also tests readWaterDistricts().
	 */
	@Test
	public void testLengthOfGetWaterDistrictsList(){
		int expectedLength = 78;
		
		List<ReferenceTablesWaterDistrict> resultsList = chrds.getWaterDistricts();
		int resultsLength = resultsList.size();
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/WaterDistrictsList.txt", Arrays.asList(resultsList).toString());
		writeToFile("results/WaterDistrictsList.txt", Arrays.asList(resultsList).toString());
		
		assertThat(expectedLength, equalTo(resultsLength));
	}
	
	/**
	 * Test that water divisions list is correct by checking 
	 * length of results.
	 * Also tests readWaterDivisions().
	 */
	@Test
	public void testLengthOfGetWaterDivisionsList(){
		int expectedLength = 7;
		
		List<ReferenceTablesWaterDivision> expectedList = chrds.getWaterDivisions();
		int resultsLength = expectedList.size();
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/WaterDivisionsList.txt", Arrays.asList(expectedList).toString());
		writeToFile("results/WaterDivisionsList.txt", Arrays.asList(expectedList).toString());
		
		assertThat(expectedLength, equalTo(resultsLength));
	}

	@Test
	public void testDeserializationOfGetWaterRightsNetAmountFromWdid(){
		WaterRightsNetAmount wrNetAmt = new WaterRightsNetAmount();
		wrNetAmt.setWaterRightNetAmtNum(476781);
		wrNetAmt.setWdid("3600501");
		wrNetAmt.setStructureName("ABBETT AND BENNETT DITCH");
		wrNetAmt.setStructureType("Ditch");
		wrNetAmt.setWaterSource("SPRUCE CREEK");
		wrNetAmt.setGnisId("00175604");
		wrNetAmt.setStreamMile(4.04);
		wrNetAmt.setDivision(5);
		wrNetAmt.setWaterDistrict(36);
		wrNetAmt.setCounty("SUMMIT");
		wrNetAmt.setQ40("NW");
		wrNetAmt.setQ160("SE");
		wrNetAmt.setSection("2");
		wrNetAmt.setTownship("2.0 S");
		wrNetAmt.setRange("81.0 W");
		wrNetAmt.setPm("S");
		wrNetAmt.setUtmX(378567.0);
		wrNetAmt.setUtmY(4419574.0);
		wrNetAmt.setLatitude(39.917564);
		wrNetAmt.setLongitude(-106.420870);
		wrNetAmt.setLocationAccuracy("Digitized");
		wrNetAmt.setAdjudicationDate("1910-03-02T00:00:00-07:00");
		wrNetAmt.setPriorAdjudicationDate("0001-01-01T00:00:00-07:00");
		wrNetAmt.setAppropriationDate("1883-04-24T00:00:00-06:00");
		wrNetAmt.setAdminNumber(12167.00000);
		wrNetAmt.setOrderNumber(0);
		wrNetAmt.setPriorityNumber("14");
		wrNetAmt.setAssociatedCaseNumbers("CA1277");
		wrNetAmt.setDecreedUses("1");
		wrNetAmt.setNetAbsolute(3.5000);
		wrNetAmt.setNetConditional(0.0000);
		wrNetAmt.setNetApexAbsolute(0.0000);
		wrNetAmt.setNetApexConditional(0.0000);
		wrNetAmt.setDecreedUnits("C");
		wrNetAmt.setSeasonalLimitation("No");
		wrNetAmt.setComments("LEGAL CORRECTED IN 81-194. AP AT HOAGLAND CANAL");
		wrNetAmt.setLastModified(null);
		wrNetAmt.setMoreInformation("https://dnrweb.state.co.us/cdss/WaterRights/NetAmounts/476781");
		
		List<WaterRightsNetAmount> expectedResultsList = new ArrayList<WaterRightsNetAmount>();
		expectedResultsList.add(wrNetAmt);
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/GetWaterRightsNetAmount.txt", Arrays.asList(expectedResultsList).toString());

		String wdid = "3600501";
		List<WaterRightsNetAmount> resultsList = chrds.getWaterRightsNetAmount(wdid);
		resultsList.get(0).setLastModified(null);
		writeToFile("results/GetWaterRightsNetAmount.txt", Arrays.asList(resultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
	}
	
	@Test
	public void testDeserializationOfGetWaterRightsTransactionFromWdid(){
		WaterRightsTransaction wrTransaction = new WaterRightsTransaction();
		wrTransaction.setWaterRightNum(129882);
		wrTransaction.setWdid("3600501");
		wrTransaction.setWaterRightName("ABBETT AND BENNETT DITCH");
		wrTransaction.setStructureType("Ditch");
		wrTransaction.setWaterSource("SPRUCE CREEK");
		wrTransaction.setStreamMile(4.04);
		wrTransaction.setGnisId("00175604");
		wrTransaction.setDivision(5);
		wrTransaction.setWaterDistrict(36);
		wrTransaction.setCounty("SUMMIT");
		wrTransaction.setQ10(null);
		wrTransaction.setQ40("SE");
		wrTransaction.setQ160("SE");
		wrTransaction.setSection("2");
		wrTransaction.setTownship("2.0 S");
		wrTransaction.setRange("81.0 W");
		wrTransaction.setPm("S");
		wrTransaction.setUtmX(379000.5);
		wrTransaction.setUtmY(4418992.0);
		wrTransaction.setLatitude(39.912384);
		wrTransaction.setLongitude(-106.415691);
		wrTransaction.setLocationAccuracy("Spotted from quarters");
		wrTransaction.setAdjudicationType("O");
		wrTransaction.setAdjudicationDate("1910-03-02T00:00:00-07:00");
		wrTransaction.setPriorAdjudicationDate("0001-01-01T00:00:00-07:00");
		wrTransaction.setAppropriationDate("1883-04-24T00:00:00-06:00");
		wrTransaction.setSignatureDate("1920-12-23T00:00:00-07:00");
		wrTransaction.setAdminNumber(12167.00000);
		wrTransaction.setOrderNumber(0);
		wrTransaction.setPriorityNumber("14");
		wrTransaction.setCaseNumber("CA1277");
		wrTransaction.setCaseNumberUrl("https://dnrweblink.state.co.us/dwr/Search.aspx?searchcommand={[Water Court]:[case number]=\"CA1277\"}&{[Water Court]:[division]=5}");
		wrTransaction.setDecreedUses("1");
		wrTransaction.setMaxDecreedRate(3.5000);
		wrTransaction.setSeasonalLimitation("No");
		wrTransaction.setComments("LEGAL CORRECTED IN 81-194. AP AT HOAGLAND CANAL");
		wrTransaction.setLastModified(null);
		wrTransaction.setMoreInformation("https://dnrweb.state.co.us/cdss/WaterRights/Transactions/129882");
		
		List<WaterRightsTransaction> expectedResultsList = new ArrayList<WaterRightsTransaction>();
		expectedResultsList.add(wrTransaction);
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/GetWaterRightsTransaction.txt", Arrays.asList(expectedResultsList).toString());
		
		String wdid = "3600501";
		List<WaterRightsTransaction> resultsList = chrds.getWaterRightsTransaction(wdid);
		resultsList.get(0).setLastModified(null);
		writeToFile("results/GetWaterRightsTransaction.txt", Arrays.asList(resultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
	}
	
	@Test
	public void testDeserializationOfSingleGetWellsFromWdid(){
		WaterLevelsWell waterLevelWell = new WaterLevelsWell();
		waterLevelWell.setWellId(75);
		waterLevelWell.setWellName("DB-026  HILLCREST VIL #3 LKA");
		waterLevelWell.setReceipt("9001846");
		waterLevelWell.setPermit("13904-F");
		waterLevelWell.setWellDepth(1106);
		waterLevelWell.setMeasurementDate("2014-05-01T00:00:00");
		waterLevelWell.setMeasurementBy("DWR");
		waterLevelWell.setPorStart("1969-05-13T00:00:00");
		waterLevelWell.setPorEnd("2014-05-01T00:00:00");
		waterLevelWell.setPorCount(29);
		waterLevelWell.setPublicationName("DENVER BASIN");
		waterLevelWell.setAquifers("LOWER ARAPAHOE");
		waterLevelWell.setElevation(5360.0);
		waterLevelWell.setTopPerforatedCasing(746);
		waterLevelWell.setBottomPerforatedCasing(1106);
		waterLevelWell.setWdid("0205722");
		waterLevelWell.setLocationNumber("SC00306631DAA");
		waterLevelWell.setDivision(1);
		waterLevelWell.setWaterDistrict(2);
		waterLevelWell.setCounty("ADAMS");
		waterLevelWell.setQ10("NE");
		waterLevelWell.setQ40("NE");
		waterLevelWell.setQ160("SE");
		waterLevelWell.setSection("31");
		waterLevelWell.setTownship("3.0 S");
		waterLevelWell.setRange("66.0 W");
		waterLevelWell.setPm("S");
		waterLevelWell.setUtmX(515328.0);
		waterLevelWell.setUtmY(4399704.0);
		waterLevelWell.setLatitude(39.747103);
		waterLevelWell.setLongitude(-104.821089);
		waterLevelWell.setLocationAccuracy("GPS");
		waterLevelWell.setDataSource("DWR");
		waterLevelWell.setModified(null);
		waterLevelWell.setMoreInformation("https://dnrweb.state.co.us/cdss/GroundWater/WaterLevels/75");
		
		//Not from web services:
		waterLevelWell.setTimeStep("Day");
		waterLevelWell.setDataType("WaterLevelDepth");
		
		List<WaterLevelsWell> expectedResultsList = new ArrayList<WaterLevelsWell>();
		expectedResultsList.add(waterLevelWell);
		
		//Uncomment the following to regenerate expected results
		//writeToFile("expectedResults/GetWellsFromWdid.txt", Arrays.asList(expectedResultsList).toString());
		
		String[] inputFilters = {"WellID", "EQ", "75"};
		List<String[]> listOfTriplets = new ArrayList<String[]>();
		listOfTriplets.add(inputFilters);
		
		String dataType = "WaterLevelDepth";
		String interval = "Day";
		
		List<WaterLevelsWell> resultsList = chrds.getWells(dataType, interval, listOfTriplets);
		resultsList.get(0).setModified(null);
		writeToFile("results/GetWellsFromWdid.txt", Arrays.asList(resultsList).toString());
		
		assertThat(Arrays.asList(expectedResultsList).toString(), equalTo(Arrays.asList(resultsList).toString()));
	}
}
