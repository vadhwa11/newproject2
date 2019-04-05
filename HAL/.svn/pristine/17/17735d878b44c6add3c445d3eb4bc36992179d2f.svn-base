package jkt.hms.accomodation.handler;

import java.util.Map;

import jkt.hms.accomodation.dataservice.AccomodationDataService;
import jkt.hms.masters.business.AccomRegistration;
import jkt.hms.masters.business.MasCarGarage;
import jkt.hms.masters.business.MasLocation;
import jkt.hms.masters.business.MasPoolCategory;
import jkt.hms.masters.business.MasSmq;
import jkt.hms.util.Box;

public class AccomodationHandlerServiceImpl implements
		AccomodationHandlerService {
	// ------------------------------------------------------------------------------------------------
	AccomodationDataService accomodationDataService = null;

	public AccomodationDataService getAccomodationDataService() {
		return accomodationDataService;
	}

	public void setAccomodationDataService(
			AccomodationDataService accomodationDataService) {
		this.accomodationDataService = accomodationDataService;
	}

	// -------------------------------------------------------------------------------------------------------
	// =====================================Pool Category
	// ============================================//
	public Map<String, Object> showPoolCategory() {
		return accomodationDataService.showPoolCategory();
	}

	public boolean addPoolCategory(MasPoolCategory masPoolCategory) {
		return accomodationDataService.addPoolCategory(masPoolCategory);
	}

	public boolean editPoolToCategory(Map<String, Object> generalMap) {
		return accomodationDataService.editPoolToCategory(generalMap);
	}

	public boolean deletePoolCategory(int poolCategoryId,
			Map<String, Object> generalMap) {
		return accomodationDataService.deletePoolCategory(poolCategoryId,
				generalMap);
	}

	public Map<String, Object> searchPoolCategory(String poolCategoryCode,
			String poolCategoryName) {
		return accomodationDataService.searchPoolCategory(poolCategoryCode,
				poolCategoryName);
	}

	// =====================================end of Pool Category
	// ============================================//

	// ==================================== Location Master
	// =========================================//
	public Map<String, Object> showLocationJsp() {
		return accomodationDataService.showLocationJsp();
	}

	public boolean addLocation(MasLocation masLocation) {
		return accomodationDataService.addLocation(masLocation);
	}

	public boolean editLocation(Map<String, Object> generalMap) {
		return accomodationDataService.editLocation(generalMap);
	}

	public boolean deleteLocation(int locationId, Map<String, Object> generalMap) {
		return accomodationDataService.deleteLocation(locationId, generalMap);
	}

	public Map<String, Object> searchLocation(String locationCode,
			String locationName) {
		return accomodationDataService.searchLocation(locationCode,
				locationName);
	}

	// =================================end of Location Master
	// ==========================================//

	// ============================Car Garage
	// ==========================================================//
	public Map<String, Object> showCarGarage() {
		return accomodationDataService.showCarGarage();
	}

	public boolean addCarGarage(MasCarGarage masCarGarage) {
		return accomodationDataService.addCarGarage(masCarGarage);
	}

	public boolean deleteCarGarage(int carGarageId,
			Map<String, Object> generalMap) {
		return accomodationDataService.deleteCarGarage(carGarageId, generalMap);
	}

	public boolean editCarGarage(Map<String, Object> generalMap) {
		return accomodationDataService.editCarGarage(generalMap);
	}

	public Map<String, Object> searchCarGarage(String carGarageCode,
			String carGarageName) {
		return accomodationDataService.searchCarGarage(carGarageCode,
				carGarageName);
	}

	// ==================================end of Car Garage
	// ========================================//

	// ====================================Pool Master
	// ============================================//
	public Map<String, Object> showPoolJsp() {
		return accomodationDataService.showPoolJsp();
	}

	public Map<String, Object> addPool(Map<String, Object> dataMap) {
		return accomodationDataService.addPool(dataMap);
	}

	public Map<String, Object> searchPool(String poolCode, String poolName) {
		return accomodationDataService.searchPool(poolCode, poolName);
	}

	public boolean deletePool(int poolId, Map<String, Object> generalMap) {
		return accomodationDataService.deletePool(poolId, generalMap);
	}

	public boolean editPool(Map<String, Object> generalMap) {
		return accomodationDataService.editPool(generalMap);
	}

	// =====================================end of pool Master
	// =====================================//

	// =======================================SMQ
	// Master===========================================//
	public Map<String, Object> showSMQJsp() {
		return accomodationDataService.showSMQJsp();
	}

	public boolean addSmqMaster(MasSmq masSmq) {
		return accomodationDataService.addSmqMaster(masSmq);
	}

	public boolean deleteSmqMaster(int smqId, Map<String, Object> generalMap) {
		return accomodationDataService.deleteSmqMaster(smqId, generalMap);
	}

	public Map<String, Object> searchSmqMaster(String smqCode, String smqName) {
		return accomodationDataService.searchSmqMaster(smqCode, smqName);
	}

	public boolean editSMQ(Map<String, Object> generalMap) {
		return accomodationDataService.editSMQ(generalMap);
	}

	// =======================================end of SMQ
	// Master===========================================

	// ======================ACCOMODATION REGISTRATION FOR
	// AIRMEN=====================================
	public Map<String, Object> registraionForAirmen() {
		return accomodationDataService.registraionForAirmen();
	}

	public String generateRegistrationNumber() {
		return accomodationDataService.generateRegistrationNumber();
	}

	public Map<String, Object> getRecordsForAirMenReg(Box box) {
		return accomodationDataService.getRecordsForAirMenReg(box);
	}

	public boolean submitRegForAirmen(AccomRegistration accomReg) {
		return accomodationDataService.submitRegForAirmen(accomReg);
	}

	public Map<String, Object> checkForExistingServiceNo(
			Map<String, Object> generalMap) {
		return accomodationDataService.checkForExistingServiceNo(generalMap);
	}

	// =======================END OF ACCOMODATION REGISTRATION FOR
	// AIRMEN=====================================

	// =======================ALLOTMENT FOR
	// AIRMEN============================================================
	public Map<String, Object> getPoolListForAlltment() {
		return accomodationDataService.getPoolListForAlltment();
	}

	public Map<String, Object> getRecordsForAirMenAllotment(Box box) {
		return accomodationDataService.getRecordsForAirMenAllotment(box);
	}

	public String generateAllotmentNumber(Map<String, Object> diagMap) {
		return accomodationDataService.generateAllotmentNumber(diagMap);
	}

	public Map<String, Object> submitAllotmentForAirmen(Box box,
			Map<String, Object> dataMap) {
		return accomodationDataService.submitAllotmentForAirmen(box, dataMap);
	}

	// ------------------------------------------------------------------------------------------------------------
	public Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap) {
		return accomodationDataService.getDetailsForSearch(dataMap);
	}

	public Map<String, Object> getSMQAirmenGrid(Map<String, Object> mapForDs) {
		return accomodationDataService.getSMQAirmenGrid(mapForDs);
	}

	public Map<String, Object> getSMQVacationDetails(Map<String, Object> dataMap) {
		return accomodationDataService.getSMQVacationDetails(dataMap);
	}

	public String generateVacationNumber(Map<String, Object> diagMap) {
		return accomodationDataService.generateVacationNumber(diagMap);
	}

	public Map<String, Object> getCurrentGridForAirmen(
			Map<String, Object> mapForDs) {
		return accomodationDataService.getCurrentGridForAirmen(mapForDs);
	}

	// --------------------------------------------------------------------------------------------------------

	public Map<String, Object> registraionForOfficer() {
		return accomodationDataService.registraionForOfficer();
	}

	public Map<String, Object> getPoolListForAlltmentOfficer() {
		return accomodationDataService.getPoolListForAlltmentOfficer();
	}

	public Map<String, Object> getRecordsForOfficerAllotment(Box box) {
		return accomodationDataService.getRecordsForOfficerAllotment(box);
	}

	public Map<String, Object> submitAllotmentForOfficer(Box box,
			Map<String, Object> dataMap) {
		return accomodationDataService.submitAllotmentForOfficer(box, dataMap);
	}

	// --------------------------------smq vacation for officer
	// --------------------------------------------

	public Map<String, Object> getSMQOfficerGrid(Map<String, Object> mapForDs) {
		return accomodationDataService.getSMQOfficerGrid(mapForDs);
	}

	public Map<String, Object> getSMQVacationDetailsForOfficer(
			Map<String, Object> dataMap) {
		return accomodationDataService.getSMQVacationDetailsForOfficer(dataMap);
	}

	public Map<String, Object> getCurrentGridForOfficer(
			Map<String, Object> mapForDs) {
		return accomodationDataService.getCurrentGridForOfficer(mapForDs);
	}

	// ------------------------------relegation
	// process-------------------------------------------------
	public Map<String, Object> getDetailsForSearchForRelegation(
			Map<String, Object> dataMap) {
		return accomodationDataService
				.getDetailsForSearchForRelegation(dataMap);
	}

	public Map<String, Object> getCurrentGridForRelegationProcess(
			Map<String, Object> mapForDs) {
		return accomodationDataService
				.getCurrentGridForRelegationProcess(mapForDs);
	}

	public Map<String, Object> getRelegationProcessGrid(
			Map<String, Object> mapForDs) {
		return accomodationDataService.getRelegationProcessGrid(mapForDs);
	}

	public Map<String, Object> getRelegationDetail(Map<String, Object> dataMap) {
		return accomodationDataService.getRelegationDetail(dataMap);
	}

	public String generateRelegationNumber(Map<String, Object> diagMap) {
		return accomodationDataService.generateRelegationNumber(diagMap);
	}

	public Map<String, Object> submitRelegationDetails(Box box,
			Map<String, Object> dataMap) {
		return accomodationDataService.submitRelegationDetails(box, dataMap);
	}

	public Map<String, Object> getRecordsForNOC(Box box) {
		return accomodationDataService.getRecordsForNOC(box);
	}

	public Map<String, Object> submitNOC(Box box, Map<String, Object> dataMap) {
		return accomodationDataService.submitNOC(box, dataMap);
	}

	public Map<String, Object> getCurrentGridForCancelAllotment(
			Map<String, Object> mapForDs) {

		return accomodationDataService
				.getCurrentGridForCancelAllotment(mapForDs);
	}

	public Map<String, Object> getSearchForCancelAirmen(
			Map<String, Object> dataMap) {
		return accomodationDataService.getSearchForCancelAirmen(dataMap);
	}

	public Map<String, Object> getCancelGrid(Map<String, Object> mapForDs) {
		return accomodationDataService.getCancelGrid(mapForDs);
	}

	public Map<String, Object> getCancellationDetail(Map<String, Object> dataMap) {
		return accomodationDataService.getCancellationDetail(dataMap);
	}

	public String generateCancellationNumber(Map<String, Object> diagMap) {
		return accomodationDataService.generateCancellationNumber(diagMap);
	}

	public boolean submitCancellationForAirmen(Box box,
			Map<String, Object> dataMap) {
		return accomodationDataService
				.submitCancellationForAirmen(box, dataMap);
	}

	public Map<String, Object> getRecordsForSmqVacation(Box box) {
		return accomodationDataService.getRecordsForSmqVacation(box);
	}

	public boolean updateSmqVacation(Box box, Map<String, Object> dataMap) {
		return accomodationDataService.updateSmqVacation(box, dataMap);
	}

	public Map<String, Object> getSmqListForAlltment() {
		return accomodationDataService.getSmqListForAlltment();
	}

	public Map<String, Object> getRecordsForAllotVacat(Box box) {
		return accomodationDataService.getRecordsForAllotVacat(box);
	}

	public Map<String, Object> getPoolList() {
		return accomodationDataService.getPoolList();
	}

	public Map<String, Object> getCurrentGridForCancelAllotmentForOfficer(
			Map<String, Object> mapForDs) {
		return accomodationDataService
				.getCurrentGridForCancelAllotmentForOfficer(mapForDs);
	}

	public Map<String, Object> getSearchForCancelOfficer(
			Map<String, Object> dataMap) {
		return accomodationDataService.getSearchForCancelOfficer(dataMap);
	}

	public Map<String, Object> getCancellationDetailForOfficer(
			Map<String, Object> dataMap) {
		return accomodationDataService.getCancellationDetailForOfficer(dataMap);
	}

	public boolean submitCancellationForOfficer(Box box,
			Map<String, Object> dataMap) {
		return accomodationDataService.submitCancellationForOfficer(box,
				dataMap);
	}

	public Map<String, Object> getRecordsForSmqVacationOfficer(Box box) {
		return accomodationDataService.getRecordsForSmqVacationOfficer(box);
	}

	public Map<String, Object> getRecordsForAllotVacatOfficer(Box box) {
		return accomodationDataService.getRecordsForAllotVacatOfficer(box);
	}

	public Map<String, Object> getSmqListForOfficerAlltment() {
		return accomodationDataService.getSmqListForOfficerAlltment();
	}

	public Map<String, Object> getDetailsForSearchForOff(
			Map<String, Object> dataMap) {
		return accomodationDataService.getDetailsForSearchForOff(dataMap);
	}

	public Map<String, Object> getOccVacOfficerGrid(Map<String, Object> mapForDs) {
		return accomodationDataService.getOccVacOfficerGrid(mapForDs);
	}

	public Map<String, Object> getCurrentGridForNac(Map<String, Object> mapForDs) {
		return accomodationDataService.getCurrentGridForNac(mapForDs);
	}

	public Map<String, Object> getNacGrid(Map<String, Object> mapForDs) {
		return accomodationDataService.getNacGrid(mapForDs);
	}

	public Map<String, Object> submitAllotmentDetailsOfficer(Box box,
			Map<String, Object> dataMap) {
		return accomodationDataService.submitAllotmentDetailsOfficer(box,
				dataMap);
	}

	public Map<String, Object> submitRecordsForOccVacOfficer(Box box,
			Map<String, Object> dataMap) {
		return accomodationDataService.submitRecordsForOccVacOfficer(box,
				dataMap);
	}

	public Map<String, Object> getCancelGridOfficer(Map<String, Object> mapForDs) {
		return accomodationDataService.getCancelGridOfficer(mapForDs);
	}

	public boolean submitSmqVacationForAirmen(Box box,
			Map<String, Object> dataMap) {
		return accomodationDataService.submitSmqVacationForAirmen(box, dataMap);
	}

	public Map<String, Object> submitAllotmentDetailsAirmen(Box box,
			Map<String, Object> dataMap) {
		return accomodationDataService.submitAllotmentDetailsAirmen(box,
				dataMap);
	}

	public Map<String, Object> getDetailsForSearchForAirmen(
			Map<String, Object> dataMap) {
		return accomodationDataService.getDetailsForSearchForAirmen(dataMap);
	}

	public Map<String, Object> getOccVacAirmenGrid(Map<String, Object> mapForDs) {
		return accomodationDataService.getOccVacAirmenGrid(mapForDs);
	}

	public Map<String, Object> submitRecordsForOccVacAirmen(Box box,
			Map<String, Object> dataMap) {
		return accomodationDataService.submitRecordsForOccVacAirmen(box,
				dataMap);
	}

	public boolean submitNac(Box box, Map<String, Object> dataMap) {
		return accomodationDataService.submitNac(box, dataMap);
	}

	public Map<String, Object> showMarriageAccomodationReg(
			Map<String, Object> map) {
		return accomodationDataService.showMarriageAccomodationReg(map);
	}

	public Map<String, Object> getConnectionForReport() {
		return accomodationDataService.getConnectionForReport();
	}

	public Map<String, Object> showRelegationList(Map<String, Object> map) {
		return accomodationDataService.showRelegationList(map);
	}

	public boolean updateSmqVacationOfficer(Box box, Map<String, Object> dataMap) {
		return accomodationDataService.updateSmqVacationOfficer(box, dataMap);
	}

	public Map<String, Object> getRecordsOfServiceNo(Box box) {
		return accomodationDataService.getRecordsOfServiceNo(box);
	}

	public String getAllotmentNumber(String string) {
		return accomodationDataService.getAllotmentNumber(string);
	}

	public String getRegistrationNumber(String string) {

		return accomodationDataService.getRegistrationNumber(string);
	}

	public String getCancellationNumber(String string) {
		return accomodationDataService.getCancellationNumber(string);
	}

	public String getRelegationNumber(String string) {
		return accomodationDataService.getRelegationNumber(string);
	}

	public String getVacationNumber(String string) {
		return accomodationDataService.getVacationNumber(string);
	}

	public Map<String, Object> showUnitSearchJsp(Box box) {
		return accomodationDataService.showUnitSearchJsp(box);
	}

	public Map<String, Object> getRecordsForOfficersReg(Box box) {
		return accomodationDataService.getRecordsForOfficersReg(box);
	}

}
