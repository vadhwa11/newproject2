package jkt.hms.bloodBank.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.BloodMasComponent;
import jkt.hms.masters.business.BloodReactionEntry;
import jkt.hms.masters.business.BloodTransfusion;
import jkt.hms.masters.business.Patient;
import jkt.hms.util.Box;

public interface BloodBankHandlerService {

	// ------Blood Componentmaster------------------------
	Map<String, Object> showBloodComponentJsp();

	Map<String, Object> searchBloodComponent(String bloodComponentCode,
			String bloodComponentName);

	boolean addBloodComponent(BloodMasComponent bloodMasComponent);

	boolean editBloodComponent(Map<String, Object> generalMap);

	boolean deleteBloodComponent(int bloodComponentId,
			Map<String, Object> generalMap);

	// --------------------Blood Request Entry-----------------------------

	Map<String, Object> showPatientSearchForBloodRequestJsp();

	Map<String, Object> getPatientForBloodRequest(Map<String, Object> mapForDs);

	Map<String, Object> fillItemsForComponentname(Map<String, Object> dataMap);

	Map<String, Object> getDetailsForBloodRequestEnquiry();

	Map<String, Object> showBloodRequestEntryJsp(int hinId);

	String getOrderSeqForDisplay(String string);

	String generateOrderNumber();

	boolean submitBloodRequestEntry(Map<String, Object> infoMap);

	Map<String, Object> getComponentNameForAutoComplete(
			Map<String, Object> parameterMap);

	Map<String, Object> showBloodDonationEntryJsp();

	Map<String, Object> getSampleCollectionGrid(Map<String, Object> mapForDs);

	Map<String, Object> getDetailsForSampleCollection();

	Map<String, Object> getPatientDetailSampleCollection(
			Map<String, Object> mapForDs);

	Map<String, Object> getBloodSampleCollectionDetails(Map orderMap);

	Map<String, Object> submitBloodSampleCollection(
			Map<String, Object> parameterMap);

	Map<String, Object> getSampleCollectionDetailsForNext(int newRequestId);

	String generateSampleCollectionNumber();

	Map<String, Object> showBloodSampleColletionJsp(int requestId);

	String getSampleCollectionSeqForDisplay(String string);

	String getSampleTestSeqForDisplay(String string);

	Map<String, Object> getDetailsForSampleValidation();

	Map<String, Object> getSampleValidationGrid(Map<String, Object> mapForDs);

	Map<String, Object> getPatientDetailSampleValidation(
			Map<String, Object> mapForDs);

	Map<String, Object> showBloodSampleValidationJsp(int sampleId);

	boolean submitBloodSampleValidation(Map<String, Object> parameterMap);

	Map<String, Object> getPatientDetailBloodSampleScreening(
			Map<String, Object> mapForDs);

	Map<String, Object> showBloodSampleScreening(int sampleId);

	Map<String, Object> getDetailsForSampleScreeningTest();

	Map<String, Object> getSampleScreeningTestGrid(Map<String, Object> mapForDs);

	Map<String, Object> getTestName(Map<String, Object> parameterMap);

	boolean submitBloodSampleScreeningTest(Map<String, Object> infoMap);

	String generateSampleTestNumber();

	Map<String, Object> getDetailsForBloodIssue();

	Map<String, Object> getBloodIssueGrid(Map<String, Object> mapForDs);

	Map<String, Object> showStockOpeningBalance();

	Map<String, Object> showBloodDiscardJsp(int bloodStockDetailId);

	String generateOpeningNumber();

	Map<String, Object> submitStockOpeningBalance(Map<String, Object> infoMap);

	List<Patient> getPateintDetail(String serviceNo);

	String getStockSeqNoForDisplay(String string);

	boolean submitBloodDonationEntry(Map<String, Object> infoMap);

	String generateDonationNumber();

	String getDonationSeqNoForDisplay(String string);

	// ------------------------Donor Blood Pending For Sample
	// Screening--------------------------------
	Map<String, Object> getDetailsForDonorSampleScreening();

	Map<String, Object> getDonorSampleScreeningGrid(Map<String, Object> mapForDs);

	Map<String, Object> showDonorBloodSampleScreeningTest(int donationId);

	Map<String, Object> getDonorDetailBloodSampleScreening(
			Map<String, Object> mapForDs);

	String getDonorSampleTestSeqForDisplay(String string);

	boolean submitDonorBloodSampleScreeningTest(Map<String, Object> infoMap);

	// --------------------------Blood Component Separation
	// -------------------------------

	Map<String, Object> showBloodComponentSeparationJsp();

	Map<String, Object> getBloodBagNoForAutoComplete(
			Map<String, Object> parameterMap);

	Map<String, Object> getPatientList(String serviceNo);

	Map<String, Object> showBloodTestEntryJsp();

	String generateSerialNumber();

	boolean submitBloodTestEntry(Map<String, Object> infoMap);

	Map<String, Object> fillItemsForInvestigationName(
			Map<String, Object> dataMap);

	Map<String, Object> getPatientDetailBloodIssue(Map<String, Object> mapForDs);

	Map<String, Object> showBloodIssueJsp(int screeningId);

	String getBloodIssueSeqForDisplay(String string);

	boolean submitBloodIssue(Map<String, Object> infoMap);

	String generateMonthlyNumber();

	String generateDonorSampleTestNumber();

	String getDiscardSeqForDisplay(String string);

	String generateDiscardNumber();

	boolean submitBloodDiscard(Map<String, Object> parameterMap);

	Map<String, Object> showSearchPatientForReactionJsp();

	Map<String, Object> searchPatientForBloodReaction(
			Map<String, Object> mapForDs);

	Map<String, Object> showReactionFormEntryJsp(int inpatientId);

	String getEntrySeqForDisplay(String string);

	boolean submitBloodReactionEntry(BloodReactionEntry bldReactionEntry);

	String generateEntryNumber();

	Map<String, Object> showDirectIndirectRegisterReport();

	String getSerialSeqForDisplay(String string);

	Map<String, Object> getDBConnection();

	Map<String, Object> fillPatientDetail(Map<String, Object> dataMap);

	Map<String, Object> showPatientSearchForBloodTransfusionJsp();

	Map<String, Object> getPatientForBloodTransfusion(
			Map<String, Object> mapForDs);

	Map<String, Object> showConsentBloodTransfusion(int inpatientId);

	int getTransfusionEntrySeqForDisplay(String string);

	int generateTransfusionEntryNumber();

	boolean submitBloodTransfusion(BloodTransfusion bloodTransfusion);

	Map<String, Object> showPatientSearchForDonationJsp();

	Map<String, Object> getPatientForUpdateDonation(Map<String, Object> mapForDs);

	Map<String, Object> showUpdateDonationEntry(int bloodDonationId);

	Map<String, Object> submitBloodComponentSeperation(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showPopUpBloodIssueJsp(Map<String, Object> map);

	Map<String, Object> showUpdateReactonEntry(int reactionId);

	Map<String, Object> searchPatientForUpdateReaction(
			Map<String, Object> mapForDs);

	boolean updateBloodReaction(Map<String, Object> generalMap);

	Map<String, Object> showPendingForTransfussionReaction();

	Map<String, Object> searchPatientForTransfussionReaction(
			Map<String, Object> mapForDs);

	Map<String, Object> showTransfussionReaction(int bloodReactionId);

	String getTransfussionTestSeqForDisplay(String string);

	Map<String, Object> fillDonorDetail(Map<String, Object> dataMap);

	boolean submitPopbloodIssue(int stockDetailId,
			Map<String, Object> generalMap);

	boolean updateBloodDonation(Box box);

	boolean updateBloodTestEntry(Box box);

	Map<String, Object> searchPatientForUpdateTest(Map<String, Object> mapForDs);

	Map<String, Object> showUpdateTestEntry(int bloodTestId);

	int generateTransfusionTestNumber();

	boolean submitTransfussionReaction(Map<String, Object> infoMap);

	Map<String, Object> fillBloodbagForDiscrad(Map<String, Object> dataMap);

	Map<String, Object> getTransfusionReactionGrid(Map<String, Object> mapForDs);

	Map<String, Object> fillBloodbagForReaction(Map<String, Object> dataMap);

	Map<String, Object> showPendingBloodDiscard(Map<String, Object> mapForDs);

	Map<String, Object> getComponentNameSeparationForAutoComplete(
			Map<String, Object> parameterMap);

	Map<String, Object> chechBloodBag(Map<String, Object> dataMap);

	Map<String, Object> fillItemsForComponentnameSeparation(
			Map<String, Object> dataMap);

	Map<String, Object> getComponentNameDonationForAutoComplete(Map<String, Object> parameterMap);

	Map<String, Object> showBloodStockRegisterjsp();

	List<Patient> getHinNoForDonor(String serviceNo);

	List<Patient> getDonorDetails(String hinNo);

	Map<String, Object> fillPatientTestDetail(Map<String, Object> dataMap);

}
