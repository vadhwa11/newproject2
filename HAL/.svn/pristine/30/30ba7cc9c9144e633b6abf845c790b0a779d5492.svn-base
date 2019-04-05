package jkt.hms.accomodation.dataservice;

import java.util.Map;

import jkt.hms.masters.business.AccomRegistration;
import jkt.hms.masters.business.MasCarGarage;
import jkt.hms.masters.business.MasLocation;
import jkt.hms.masters.business.MasPoolCategory;
import jkt.hms.masters.business.MasSmq;
import jkt.hms.util.Box;

public interface AccomodationDataService {

	// ============================Pool Category
	// ======================================//
	Map<String, Object> showPoolCategory();

	boolean addPoolCategory(MasPoolCategory masPoolCategory);

	boolean editPoolToCategory(Map<String, Object> generalMap);

	boolean deletePoolCategory(int poolCategoryId,
			Map<String, Object> generalMap);

	Map<String, Object> searchPoolCategory(String poolCategoryCode,
			String poolCategoryName);

	// ============================Pool category
	// ======================================//

	// ============================Location Master
	// ====================================//
	public Map<String, Object> showLocationJsp();

	boolean addLocation(MasLocation masLocation);

	boolean editLocation(Map<String, Object> generalMap);

	boolean deleteLocation(int locationId, Map<String, Object> generalMap);

	Map<String, Object> searchLocation(String locationCode, String locationName);

	// ============================= end of Location Master
	// =============================//

	// ==========================Car Garage
	// =============================================//
	Map<String, Object> showCarGarage();

	boolean addCarGarage(MasCarGarage masCarGarage);

	boolean editCarGarage(Map<String, Object> generalMap);

	boolean deleteCarGarage(int carGarageId, Map<String, Object> generalMap);

	Map<String, Object> searchCarGarage(String carGarageCode,
			String carGarageName);

	// ==========================end of Car Garage
	// ======================================//

	// ===========================POOL Master
	// ===========================================//
	Map<String, Object> showPoolJsp();

	Map<String, Object> addPool(Map<String, Object> dataMap);

	Map<String, Object> searchPool(String poolCode, String poolName);

	boolean deletePool(int poolId, Map<String, Object> generalMap);

	boolean editPool(Map<String, Object> generalMap);

	// =========================end of POOL MASTER
	// =====================================//

	// =============================SMQ
	// MASTER==========================================//
	Map<String, Object> showSMQJsp();

	boolean addSmqMaster(MasSmq masSmq);

	boolean deleteSmqMaster(int smqId, Map<String, Object> generalMap);

	Map<String, Object> searchSmqMaster(String smqCode, String smqName);

	boolean editSMQ(Map<String, Object> generalMap);

	// ==============================end of SMQ
	// MAster======================================//

	// ============================ACCOMODATION REGISTRATION FOR
	// AIRMEN=====================//
	Map<String, Object> registraionForAirmen();

	String generateRegistrationNumber();

	Map<String, Object> getRecordsForAirMenReg(Box box);

	boolean submitRegForAirmen(AccomRegistration accomReg);

	Map<String, Object> checkForExistingServiceNo(Map<String, Object> generalMap);

	// ==========================ALLOTMENT fOR
	// AIRMEN====================================//
	Map<String, Object> getPoolListForAlltment();

	Map<String, Object> getRecordsForAirMenAllotment(Box box);

	String generateAllotmentNumber(Map<String, Object> diagMap);

	Map<String, Object> submitAllotmentForAirmen(Box box,
			Map<String, Object> dataMap);

	// =========================SMQ VAcation for Airmen
	// ================================//
	Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap);

	Map<String, Object> getSMQAirmenGrid(Map<String, Object> mapForDs);

	Map<String, Object> getSMQVacationDetails(Map<String, Object> dataMap);

	String generateVacationNumber(Map<String, Object> diagMap);

	public boolean submitSmqVacationForAirmen(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> getCurrentGridForAirmen(Map<String, Object> mapForDs);

	// =======================acoomodation for
	// officer===================================//
	Map<String, Object> registraionForOfficer();

	public Map<String, Object> getRecordsForOfficerAllotment(Box box);

	Map<String, Object> getPoolListForAlltmentOfficer();

	Map<String, Object> submitAllotmentForOfficer(Box box,
			Map<String, Object> dataMap);

	// =================== smq vacation for officer
	// ===================================//
	Map<String, Object> getSMQVacationDetailsForOfficer(
			Map<String, Object> dataMap);

	Map<String, Object> getSMQOfficerGrid(Map<String, Object> mapForDs);

	Map<String, Object> getCurrentGridForOfficer(Map<String, Object> mapForDs);

	// =================================releagtion
	// process=========================//
	Map<String, Object> getDetailsForSearchForRelegation(
			Map<String, Object> dataMap);

	Map<String, Object> getCurrentGridForRelegationProcess(
			Map<String, Object> mapForDs);

	Map<String, Object> getRelegationProcessGrid(Map<String, Object> mapForDs);

	Map<String, Object> getRelegationDetail(Map<String, Object> dataMap);

	String generateRelegationNumber(Map<String, Object> diagMap);

	Map<String, Object> submitRelegationDetails(Box box,
			Map<String, Object> dataMap);

	// ===============================NOC=======================================//
	public Map<String, Object> getRecordsForNOC(Box box);

	public Map<String, Object> submitNOC(Box box, Map<String, Object> dataMap);

	// ======================Cancellation of allotment for
	// airmen(acc to ver 2)================//
	public Map<String, Object> getSearchForCancelAirmen(
			Map<String, Object> dataMap);

	public Map<String, Object> getCurrentGridForCancelAllotment(
			Map<String, Object> mapForDs);

	public Map<String, Object> getCancelGrid(Map<String, Object> mapForDs);

	public Map<String, Object> getCancellationDetail(Map<String, Object> dataMap);

	public String generateCancellationNumber(Map<String, Object> diagMap);

	public boolean submitCancellationForAirmen(Box box,
			Map<String, Object> dataMap);

	// ===============================method for smq vacation for airmen (new
	// method acc to 2 ver)===============
	public Map<String, Object> getRecordsForSmqVacation(Box box);

	public boolean updateSmqVacation(Box box, Map<String, Object> dataMap);

	// ======================= methods for allot vacat for airmen(ver
	// 2.0)==============

	public Map<String, Object> getSmqListForAlltment();

	public Map<String, Object> getRecordsForAllotVacat(Box box);

	public Map<String, Object> getPoolList();

	public Map<String, Object> submitAllotmentDetailsAirmen(Box box,
			Map<String, Object> dataMap);

	// =================method to cancel for officer(ver2.0)
	public Map<String, Object> getSearchForCancelOfficer(
			Map<String, Object> dataMap);

	public Map<String, Object> getCurrentGridForCancelAllotmentForOfficer(
			Map<String, Object> mapForDs);

	public Map<String, Object> getCancellationDetailForOfficer(
			Map<String, Object> dataMap);

	public boolean submitCancellationForOfficer(Box box,
			Map<String, Object> dataMap);

	public Map<String, Object> getRecordsForSmqVacationOfficer(Box box);

	public Map<String, Object> getCancelGridOfficer(Map<String, Object> mapForDs);

	// ================ allotment vacant for officer
	public Map<String, Object> getSmqListForOfficerAlltment();

	public Map<String, Object> getRecordsForAllotVacatOfficer(Box box);

	public Map<String, Object> submitAllotmentDetailsOfficer(Box box,
			Map<String, Object> dataMap);

	// =================Occupy vacant for officer
	public Map<String, Object> getDetailsForSearchForOff(
			Map<String, Object> dataMap);

	public Map<String, Object> getOccVacOfficerGrid(Map<String, Object> mapForDs);

	public Map<String, Object> submitRecordsForOccVacOfficer(Box box,
			Map<String, Object> dataMap);

	// ================== method for nac
	public Map<String, Object> getCurrentGridForNac(Map<String, Object> mapForDs);

	public Map<String, Object> getNacGrid(Map<String, Object> mapForDs);

	public Map<String, Object> getDetailsForSearchForAirmen(
			Map<String, Object> dataMap);

	public Map<String, Object> getOccVacAirmenGrid(Map<String, Object> mapForDs);

	public Map<String, Object> submitRecordsForOccVacAirmen(Box box,
			Map<String, Object> dataMap);

	public boolean submitNac(Box box, Map<String, Object> dataMap);

	public Map<String, Object> getConnectionForReport();

	public Map<String, Object> showMarriageAccomodationReg(
			Map<String, Object> map);

	public Map<String, Object> showRelegationList(Map<String, Object> map);

	public boolean updateSmqVacationOfficer(Box box, Map<String, Object> dataMap);

	public Map<String, Object> getRecordsOfServiceNo(Box box);

	public String getRegistrationNumber(String string);

	public String getAllotmentNumber(String string);

	public String getCancellationNumber(String string);

	public String getRelegationNumber(String string);

	public String getVacationNumber(String string);

	public Map<String, Object> showUnitSearchJsp(Box box);

	public Map<String, Object> getRecordsForOfficersReg(Box box);
}
