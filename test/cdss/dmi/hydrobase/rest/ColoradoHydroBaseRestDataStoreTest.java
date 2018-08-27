package cdss.dmi.hydrobase.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

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
		
		
		// Test one irrigation year and one WDID to limit the test data
		String wdid = "0300915";
		int irrYear = 1999;
		List<DiversionComments> resultsList = chrds.getDivComments(wdid, null, irrYear);
		
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
		
		//Test one data meas date year and one wdid to limit the test data
		String wdid = "8003550";
		String dataMeasDate = "09/30/1999";
		List<DiversionStageVolume> resultsList = chrds.getDiversionStageVolume(wdid, dataMeasDate, null);
		
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
		
		String wdid = "2000505";
		int parcelId = 32004373;
		List<ParcelUseTimeSeries> resultsList = chrds.getParcelUseTSListFromParcelId(wdid, parcelId);
		
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
	
	@Test
	public void getSingleTelemetryStationDataTypeFromWdid(){
		
		/*List<String> array = {"WDID", "MA", "4200935"};
		List<TelemetryStationDataTypes> telStationDataTypes = chrds.getTelemetryDataTypes("AIRTEMP", "15min", array);*/
	}

}
