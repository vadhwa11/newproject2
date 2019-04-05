package jkt.hms.bloodBank.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.bloodBank.dataservice.BloodBankDataService;
import jkt.hms.masters.business.BloodMasComponent;
import jkt.hms.masters.business.BloodReactionEntry;
import jkt.hms.masters.business.BloodTransfusion;
import jkt.hms.masters.business.Patient;
import jkt.hms.util.Box;

public class BloodBankHandlerServiceImpl implements BloodBankHandlerService {

	BloodBankDataService bloodBankDataService;

	// ---------------Blood ComponentMaster---------------------

	public Map<String, Object> showBloodComponentJsp() {
		return bloodBankDataService.showBloodComponentJsp();
	}

	public boolean addBloodComponent(BloodMasComponent bloodMasComponent) {
		return bloodBankDataService.addBloodComponent(bloodMasComponent);
	}

	public boolean editBloodComponent(Map<String, Object> generalMap) {
		return bloodBankDataService.editBloodComponent(generalMap);
	}

	public boolean deleteBloodComponent(int bloodComponentId,
			Map<String, Object> generalMap) {
		return bloodBankDataService.deleteBloodComponent(bloodComponentId,
				generalMap);
	}

	public Map<String, Object> searchBloodComponent(String bloodComponentCode,
			String bloodComponentName) {
		return bloodBankDataService.searchBloodComponent(bloodComponentCode,
				bloodComponentName);
	}

	// --------------------------Blood Request
	// Entry-------------------------------------
	public Map<String, Object> showPatientSearchForBloodRequestJsp() {
		return bloodBankDataService.showPatientSearchForBloodRequestJsp();
	}

	public Map<String, Object> getPatientForBloodRequest(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getPatientForBloodRequest(mapForDs);
	}

	// -----------------------------------------------------------------------
	public BloodBankDataService getBloodBankDataService() {
		return bloodBankDataService;
	}

	public void setBloodBankDataService(
			BloodBankDataService bloodBankDataService) {
		this.bloodBankDataService = bloodBankDataService;
	}

	public Map<String, Object> fillItemsForComponentname(
			Map<String, Object> dataMap) {
		return bloodBankDataService.fillItemsForComponentname(dataMap);
	}

	public Map<String, Object> getDetailsForBloodRequestEnquiry() {
		return bloodBankDataService.getDetailsForBloodRequestEnquiry();
	}

	public Map<String, Object> showBloodRequestEntryJsp(int hinId) {
		return bloodBankDataService.showBloodRequestEntryJsp(hinId);
	}

	public String getOrderSeqForDisplay(String string) {
		return bloodBankDataService.getOrderSeqForDisplay(string);
	}

	public String generateOrderNumber() {
		return bloodBankDataService.generateOrderNumber();
	}

	public boolean submitBloodRequestEntry(Map<String, Object> infoMap) {
		return bloodBankDataService.submitBloodRequestEntry(infoMap);
	}

	public Map<String, Object> getComponentNameForAutoComplete(
			Map<String, Object> parameterMap) {
		return bloodBankDataService
				.getComponentNameForAutoComplete(parameterMap);
	}

	public Map<String, Object> showBloodDonationEntryJsp() {
		return bloodBankDataService.showBloodDonationEntryJsp();
	}

	public Map<String, Object> getSampleCollectionGrid(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getSampleCollectionGrid(mapForDs);
	}

	public Map<String, Object> getDetailsForSampleCollection() {
		return bloodBankDataService.getDetailsForSampleCollection();
	}

	public Map<String, Object> getBloodSampleCollectionDetails(Map orderMap) {
		return bloodBankDataService.getBloodSampleCollectionDetails(orderMap);
	}

	public Map<String, Object> getPatientDetailSampleCollection(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getPatientDetailSampleCollection(mapForDs);
	}

	public Map<String, Object> getSampleCollectionDetailsForNext(
			int newRequestId) {
		return bloodBankDataService
				.getSampleCollectionDetailsForNext(newRequestId);
	}

	public Map<String, Object> submitBloodSampleCollection(
			Map<String, Object> parameterMap) {
		return bloodBankDataService.submitBloodSampleCollection(parameterMap);
	}

	public String generateSampleCollectionNumber() {
		return bloodBankDataService.generateSampleCollectionNumber();
	}

	public String getSampleCollectionSeqForDisplay(String string) {
		return bloodBankDataService.getSampleCollectionSeqForDisplay(string);
	}

	public Map<String, Object> showBloodSampleColletionJsp(int requestId) {
		return bloodBankDataService.showBloodSampleColletionJsp(requestId);
	}

	public String getSampleTestSeqForDisplay(String string) {
		return bloodBankDataService.getSampleTestSeqForDisplay(string);
	}

	public Map<String, Object> getDetailsForSampleValidation() {
		return bloodBankDataService.getDetailsForSampleValidation();
	}

	public Map<String, Object> getPatientDetailSampleValidation(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getPatientDetailSampleValidation(mapForDs);
	}

	public Map<String, Object> getSampleValidationGrid(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getSampleValidationGrid(mapForDs);
	}

	public Map<String, Object> showBloodSampleValidationJsp(int sampleId) {
		return bloodBankDataService.showBloodSampleValidationJsp(sampleId);
	}

	public boolean submitBloodSampleValidation(Map<String, Object> parameterMap) {
		return bloodBankDataService.submitBloodSampleValidation(parameterMap);
	}

	public Map<String, Object> getPatientDetailBloodSampleScreening(
			Map<String, Object> mapForDs) {
		return bloodBankDataService
				.getPatientDetailBloodSampleScreening(mapForDs);
	}

	public Map<String, Object> showBloodSampleScreening(int sampleId) {
		return bloodBankDataService.showBloodSampleScreening(sampleId);
	}

	public Map<String, Object> getDetailsForSampleScreeningTest() {
		return bloodBankDataService.getDetailsForSampleScreeningTest();
	}

	public Map<String, Object> getSampleScreeningTestGrid(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getSampleScreeningTestGrid(mapForDs);
	}

	public Map<String, Object> getTestName(Map<String, Object> parameterMap) {
		return bloodBankDataService.getTestName(parameterMap);
	}

	public String generateSampleTestNumber() {
		return bloodBankDataService.generateSampleTestNumber();
	}

	public boolean submitBloodSampleScreeningTest(Map<String, Object> infoMap) {
		return bloodBankDataService.submitBloodSampleScreeningTest(infoMap);
	}

	public Map<String, Object> getBloodIssueGrid(Map<String, Object> mapForDs) {
		return bloodBankDataService.getBloodIssueGrid(mapForDs);
	}

	public Map<String, Object> getDetailsForBloodIssue() {
		return bloodBankDataService.getDetailsForBloodIssue();
	}

	public Map<String, Object> showStockOpeningBalance() {
		return bloodBankDataService.showStockOpeningBalance();
	}

	public Map<String, Object> showBloodDiscardJsp(int bloodStockDetailId) {
		return bloodBankDataService.showBloodDiscardJsp(bloodStockDetailId);
	}

	public String generateOpeningNumber() {
		return bloodBankDataService.generateOpeningNumber();
	}

	public Map<String, Object> submitStockOpeningBalance(
			Map<String, Object> infoMap) {
		return bloodBankDataService.submitStockOpeningBalance(infoMap);
	}

	public List<Patient> getPateintDetail(String serviceNo) {
		return bloodBankDataService.getPateintDetail(serviceNo);
	}

	public String getStockSeqNoForDisplay(String string) {
		return bloodBankDataService.getStockSeqNoForDisplay(string);
	}

	public String getDonationSeqNoForDisplay(String string) {
		return bloodBankDataService.getDonationSeqNoForDisplay(string);
	}

	public boolean submitBloodDonationEntry(Map<String, Object> infoMap) {
		return bloodBankDataService.submitBloodDonationEntry(infoMap);
	}

	public String generateDonationNumber() {
		return bloodBankDataService.generateDonationNumber();
	}

	// ------------------------Donor Blood Pending For Sample
	// Screening--------------------------------
	public Map<String, Object> getDetailsForDonorSampleScreening() {
		return bloodBankDataService.getDetailsForDonorSampleScreening();
	}

	public Map<String, Object> getDonorSampleScreeningGrid(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getDonorSampleScreeningGrid(mapForDs);
	}

	public Map<String, Object> showDonorBloodSampleScreeningTest(int donationId) {
		return bloodBankDataService
				.showDonorBloodSampleScreeningTest(donationId);
	}

	public Map<String, Object> getDonorDetailBloodSampleScreening(
			Map<String, Object> mapForDs) {
		return bloodBankDataService
				.getDonorDetailBloodSampleScreening(mapForDs);
	}

	public String getDonorSampleTestSeqForDisplay(String string) {
		return bloodBankDataService.getDonorSampleTestSeqForDisplay(string);
	}

	public boolean submitDonorBloodSampleScreeningTest(
			Map<String, Object> infoMap) {
		return bloodBankDataService
				.submitDonorBloodSampleScreeningTest(infoMap);
	}

	public Map<String, Object> showBloodComponentSeparationJsp() {
		return bloodBankDataService.showBloodComponentSeparationJsp();
	}

	public Map<String, Object> getBloodBagNoForAutoComplete(
			Map<String, Object> parameterMap) {
		return bloodBankDataService.getBloodBagNoForAutoComplete(parameterMap);
	}

	public Map<String, Object> getPatientList(String serviceNo) {
		return bloodBankDataService.getPatientList(serviceNo);
	}

	public Map<String, Object> showBloodTestEntryJsp() {
		return bloodBankDataService.showBloodTestEntryJsp();
	}

	public String generateSerialNumber() {
		return bloodBankDataService.generateSerialNumber();
	}

	public boolean submitBloodTestEntry(Map<String, Object> infoMap) {
		return bloodBankDataService.submitBloodTestEntry(infoMap);
	}

	public Map<String, Object> fillItemsForInvestigationName(
			Map<String, Object> dataMap) {
		return bloodBankDataService.fillItemsForInvestigationName(dataMap);
	}

	public Map<String, Object> getPatientDetailBloodIssue(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getPatientDetailBloodIssue(mapForDs);
	}

	public String getBloodIssueSeqForDisplay(String string) {
		return bloodBankDataService.getBloodIssueSeqForDisplay(string);
	}

	public Map<String, Object> showBloodIssueJsp(int screeningId) {
		return bloodBankDataService.showBloodIssueJsp(screeningId);
	}

	public String generateMonthlyNumber() {
		return bloodBankDataService.generateMonthlyNumber();
	}

	public boolean submitBloodIssue(Map<String, Object> infoMap) {
		return bloodBankDataService.submitBloodIssue(infoMap);
	}

	public String generateDonorSampleTestNumber() {
		return bloodBankDataService.generateDonorSampleTestNumber();
	}

	public String getDiscardSeqForDisplay(String string) {
		return bloodBankDataService.getDiscardSeqForDisplay(string);
	}

	public String generateDiscardNumber() {
		return bloodBankDataService.generateDiscardNumber();
	}

	public boolean submitBloodDiscard(Map<String, Object> parameterMap) {
		return bloodBankDataService.submitBloodDiscard(parameterMap);
	}

	public Map<String, Object> showSearchPatientForReactionJsp() {
		return bloodBankDataService.showSearchPatientForReactionJsp();
	}

	public Map<String, Object> searchPatientForBloodReaction(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.searchPatientForBloodReaction(mapForDs);
	}

	public Map<String, Object> showReactionFormEntryJsp(int inpatientId) {
		return bloodBankDataService.showReactionFormEntryJsp(inpatientId);
	}

	public String getEntrySeqForDisplay(String string) {
		return bloodBankDataService.getEntrySeqForDisplay(string);
	}

	public String generateEntryNumber() {
		return bloodBankDataService.generateEntryNumber();
	}

	public boolean submitBloodReactionEntry(BloodReactionEntry bldReactionEntry) {
		return bloodBankDataService.submitBloodReactionEntry(bldReactionEntry);
	}

	public Map<String, Object> showDirectIndirectRegisterReport() {
		return bloodBankDataService.showDirectIndirectRegisterReport();
	}

	public String getSerialSeqForDisplay(String string) {
		return bloodBankDataService.getSerialSeqForDisplay(string);
	}

	public Map<String, Object> getDBConnection() {
		return bloodBankDataService.getDBConnection();
	}

	public Map<String, Object> fillPatientDetail(Map<String, Object> dataMap) {
		return bloodBankDataService.fillPatientDetail(dataMap);
	}

	public Map<String, Object> showPatientSearchForBloodTransfusionJsp() {
		return bloodBankDataService.showPatientSearchForBloodTransfusionJsp();
	}

	public Map<String, Object> getPatientForBloodTransfusion(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getPatientForBloodTransfusion(mapForDs);
	}

	public Map<String, Object> showConsentBloodTransfusion(int inpatientId) {
		return bloodBankDataService.showConsentBloodTransfusion(inpatientId);
	}

	public int getTransfusionEntrySeqForDisplay(String string) {
		return bloodBankDataService.getTransfusionEntrySeqForDisplay(string);
	}

	public int generateTransfusionEntryNumber() {
		return bloodBankDataService.generateTransfusionEntryNumber();
	}

	public boolean submitBloodTransfusion(BloodTransfusion bloodTransfusion) {
		return bloodBankDataService.submitBloodTransfusion(bloodTransfusion);
	}

	public Map<String, Object> showPatientSearchForDonationJsp() {
		return bloodBankDataService.showPatientSearchForDonationJsp();
	}

	public Map<String, Object> getPatientForUpdateDonation(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getPatientForUpdateDonation(mapForDs);
	}

	public Map<String, Object> showUpdateDonationEntry(int bloodDonationId) {
		return bloodBankDataService.showUpdateDonationEntry(bloodDonationId);
	}

	public Map<String, Object> submitBloodComponentSeperation(Box box,
			Map<String, Object> dataMap) {
		return bloodBankDataService
				.submitBloodComponentSeperation(box, dataMap);
	}

	public Map<String, Object> showUpdateReactonEntry(int reactionId) {
		return bloodBankDataService.showUpdateReactonEntry(reactionId);
	}

	public Map<String, Object> searchPatientForUpdateReaction(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.searchPatientForUpdateReaction(mapForDs);
	}

	public boolean updateBloodReaction(Map<String, Object> generalMap) {
		return bloodBankDataService.updateBloodReaction(generalMap);
	}

	public Map<String, Object> showPendingForTransfussionReaction() {
		return bloodBankDataService.showPendingForTransfussionReaction();

	}

	public Map<String, Object> searchPatientForTransfussionReaction(
			Map<String, Object> mapForDs) {
		return bloodBankDataService
				.searchPatientForTransfussionReaction(mapForDs);
	}

	public String getTransfussionTestSeqForDisplay(String string) {
		return bloodBankDataService.getTransfussionTestSeqForDisplay(string);
	}

	public Map<String, Object> showTransfussionReaction(int bloodReactionId) {
		return bloodBankDataService.showTransfussionReaction(bloodReactionId);
	}

	public Map<String, Object> fillDonorDetail(Map<String, Object> dataMap) {
		return bloodBankDataService.fillDonorDetail(dataMap);
	}

	public Map<String, Object> showPopUpBloodIssueJsp(Map<String, Object> map) {
		return bloodBankDataService.showPopUpBloodIssueJsp(map);
	}

	public boolean submitPopbloodIssue(int stockDetailId,
			Map<String, Object> generalMap) {
		return bloodBankDataService.submitPopbloodIssue(stockDetailId,
				generalMap);
	}

	public boolean updateBloodDonation(Box box) {
		return bloodBankDataService.updateBloodDonation(box);
	}

	public boolean updateBloodTestEntry(Box box) {
		return bloodBankDataService.updateBloodTestEntry(box);
	}

	public Map<String, Object> searchPatientForUpdateTest(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.searchPatientForUpdateTest(mapForDs);
	}

	public Map<String, Object> showUpdateTestEntry(int bloodTestId) {
		return bloodBankDataService.showUpdateTestEntry(bloodTestId);
	}

	public int generateTransfusionTestNumber() {
		return bloodBankDataService.generateTransfusionTestNumber();
	}

	public boolean submitTransfussionReaction(Map<String, Object> infoMap) {
		return bloodBankDataService.submitTransfussionReaction(infoMap);
	}

	public Map<String, Object> fillBloodbagForDiscrad(
			Map<String, Object> dataMap) {
		return bloodBankDataService.fillBloodbagForDiscrad(dataMap);
	}

	public Map<String, Object> getTransfusionReactionGrid(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getTransfusionReactionGrid(mapForDs);
	}

	public Map<String, Object> fillBloodbagForReaction(
			Map<String, Object> dataMap) {
		return bloodBankDataService.fillBloodbagForReaction(dataMap);
	}

	public Map<String, Object> showPendingBloodDiscard(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.showPendingBloodDiscard(mapForDs);
	}

	public Map<String, Object> getComponentNameSeparationForAutoComplete(
			Map<String, Object> parameterMap) {
		return bloodBankDataService
				.getComponentNameSeparationForAutoComplete(parameterMap);
	}

	public Map<String, Object> chechBloodBag(Map<String, Object> dataMap) {
		return bloodBankDataService.chechBloodBag(dataMap);
	}

	public Map<String, Object> fillItemsForComponentnameSeparation(
			Map<String, Object> dataMap) {
		return bloodBankDataService
				.fillItemsForComponentnameSeparation(dataMap);
	}

	@Override
	public Map<String, Object> getComponentNameDonationForAutoComplete(
			Map<String, Object> parameterMap) {
		return bloodBankDataService.getComponentNameDonationForAutoComplete(parameterMap);
	}

	@Override
	public Map<String, Object> showBloodStockRegisterjsp() {
		return bloodBankDataService.showBloodStockRegisterjsp();
	}

	@Override
	public List<Patient> getHinNoForDonor(String serviceNo) {
		return bloodBankDataService.getHinNoForDonor(serviceNo);
	}

	@Override
	public List<Patient> getDonorDetails(String hinNo) {
		return bloodBankDataService.getDonorDetails(hinNo);
	}

	@Override
	public Map<String, Object> fillPatientTestDetail(Map<String, Object> dataMap) {
		return bloodBankDataService.fillPatientTestDetail(dataMap);
	}
}
