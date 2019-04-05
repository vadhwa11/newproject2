package jkt.hms.mediClaim.handler;

import java.util.Map;

import jkt.hms.masters.business.MdCardicClaimAdvance;
import jkt.hms.masters.business.MdContigentMedicalBillHd;
import jkt.hms.masters.business.MdMasAuthority;
import jkt.hms.mediClaim.dataservice.MedicalClaimDataService;
import jkt.hms.util.Box;

public class MedicalClaimHandlerServiceImpl implements
		MedicalClaimHandlerService {
	MedicalClaimDataService medicalClaimDataService;

	public MedicalClaimDataService getMedicalClaimDataService() {
		return medicalClaimDataService;
	}

	public void setMedicalClaimDataService(
			MedicalClaimDataService medicalClaimDataService) {
		this.medicalClaimDataService = medicalClaimDataService;
	}

	// -------------------------Authority master--------------------------------
	public boolean addAuthority(MdMasAuthority masAuthority) {
		return medicalClaimDataService.addAuthority(masAuthority);
	}

	public boolean deleteAuthority(int authorityId,
			Map<String, Object> generalMap) {
		return medicalClaimDataService.deleteAuthority(authorityId, generalMap);
	}

	public boolean editAuthority(Map<String, Object> generalMap) {
		return medicalClaimDataService.editAuthority(generalMap);
	}

	public Map<String, Object> searchAuthority(String authorityCode,
			String authorityName) {
		return medicalClaimDataService.searchAuthority(authorityCode,
				authorityName);
	}

	public Map<String, Object> showAuthorityJsp() {
		return medicalClaimDataService.showAuthorityJsp();
	}

	// ----------------Request for Special Investigation Entry----------------

	public Map<String, Object> showPatientSearchForSpecialinvestigationJsp() {
		return medicalClaimDataService
				.showPatientSearchForSpecialinvestigationJsp();
	}

	public Map<String, Object> getPatientforInvestigationDetails(int hinId) {
		return medicalClaimDataService.getPatientforInvestigationDetails(hinId);
	}

	public Map<String, Object> getChargeName(Map<String, Object> parameterMap) {
		return medicalClaimDataService.getChargeName(parameterMap);
	}

	public Map<String, Object> fillItemsForChargeName(
			Map<String, Object> dataMap) {
		return medicalClaimDataService.fillItemsForChargeName(dataMap);
	}

	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		return medicalClaimDataService.getPatientDetails(mapForDs);

	}

	public String getyearlySeqForDisplay(String string) {
		return medicalClaimDataService.getyearlySeqForDisplay(string);
	}

	public Map<String, Object> getDiagnosis(Map<String, Object> parameterMap) {
		return medicalClaimDataService.getDiagnosis(parameterMap);
	}

	public String generateYearlyNumber() {
		return medicalClaimDataService.generateYearlyNumber();
	}

	public Map<String, Object> submitSpecialinvestigation(
			Map<String, Object> infoMap) {
		return medicalClaimDataService.submitSpecialinvestigation(infoMap);
	}

	public Map<String, Object> getUnitName(Map<String, Object> parameterMap) {
		return medicalClaimDataService.getUnitName(parameterMap);
	}

	// ------------- Contingent Bill for Reimbursement of Medical Bill
	// Entry-----
	public Map<String, Object> showPatientSearchForContingentBill() {
		return medicalClaimDataService.showPatientSearchForContingentBill();
	}

	public Map<String, Object> getPatientDetailsForContingentBill(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService
				.getPatientDetailsForContingentBill(mapForDs);
	}

	public Map<String, Object> getPatientForContingentBillDetails(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService
				.getPatientForContingentBillDetails(mapForDs);
	}

	public String generateEntryNumber() {
		return medicalClaimDataService.generateEntryNumber();
	}

	public String getEntrySeqForDisplay(String string) {
		return medicalClaimDataService.getEntrySeqForDisplay(string);
	}

	public Map<String, Object> submitContingentBill(Map<String, Object> infoMap) {
		return medicalClaimDataService.submitContingentBill(infoMap);
	}

	public String getCoveringEntrySeqForDisplay(String string) {
		return medicalClaimDataService.getCoveringEntrySeqForDisplay(string);
	}

	public Map<String, Object> showPatientForCoveringLetterUnit(
			Map<String, Object> dataMap) {
		return medicalClaimDataService
				.showPatientForCoveringLetterUnit(dataMap);
	}

	public Map<String, Object> fillItemsForUnitName(Map<String, Object> dataMap) {
		return medicalClaimDataService.fillItemsForUnitName(dataMap);
	}

	public Map<String, Object> submitCoveringletter(
			Map<String, Object> parameterMap) {
		return medicalClaimDataService.submitCoveringletter(parameterMap);
	}

	// ----------------General Covering Letter-------------------------
	public String getGenCoverEntryNoDisplay(String string) {
		return medicalClaimDataService.getGenCoverEntryNoDisplay(string);
	}

	public Map<String, Object> showGeneralClaimCoveringLetter(
			Map<String, Object> dataMap) {
		return medicalClaimDataService.showGeneralClaimCoveringLetter(dataMap);
	}

	public Map<String, Object> submitGeneralCoveringletter(
			Map<String, Object> parameterMap) {
		return medicalClaimDataService
				.submitGeneralCoveringletter(parameterMap);
	}

	// ----------------General Claim Tracking------------------------------
	public Map<String, Object> showPatientForGeneralClaim() {
		return medicalClaimDataService.showPatientForGeneralClaim();
	}

	public Map<String, Object> getPatientDetailsForGeneralTracking(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService
				.getPatientDetailsForGeneralTracking(mapForDs);
	}

	// -----------------------General tracking-----------------------------
	public Map<String, Object> getPatientForGeneralTracking(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService.getPatientForGeneralTracking(mapForDs);
	}

	// -------------Cardic Claim Advance----------------------
	public Map<String, Object> showPatientCardicClaimAdvance() {
		return medicalClaimDataService.showPatientCardicClaimAdvance();
	}

	public Map<String, Object> getPatientDetailsCardicClaim(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService.getPatientDetailsCardicClaim(mapForDs);
	}

	public Map<String, Object> getPatientforCardicAdvance(int hinId) {
		return medicalClaimDataService.getPatientforCardicAdvance(hinId);
	}

	public String getyearlyEntryForDisplay(String string) {
		return medicalClaimDataService.getyearlyEntryForDisplay(string);
	}

	public Map submitCardicClaimAdvance(MdCardicClaimAdvance cardicClaimAdvance)

	{
		return medicalClaimDataService
				.submitCardicClaimAdvance(cardicClaimAdvance);
	}

	public String generateAdvanceEntryNumber() {
		return medicalClaimDataService.generateAdvanceEntryNumber();
	}

	// ------- Cardiac claim – Contingent Bill for Reimbursement-----
	public Map<String, Object> showPatientSearchForCardicReimbursement() {
		return medicalClaimDataService
				.showPatientSearchForCardicReimbursement();
	}

	public String getCardicEntryForDisplay(String string) {
		return medicalClaimDataService.getCardicEntryForDisplay(string);
	}

	public Map<String, Object> getPatientDetailsForCardicAdvance(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService
				.getPatientDetailsForCardicAdvance(mapForDs);
	}

	public Map<String, Object> getPatientForCardicAdvanceBill(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService.getPatientForCardicAdvanceBill(mapForDs);
	}

	// ---------- Contingent bill movement entry-------------
	public Map<String, Object> showPatientSearchContingentBillMovement() {
		return medicalClaimDataService
				.showPatientSearchContingentBillMovement();
	}

	public String generateEntryNoForContingentEntry(Map<String, Object> diagMap) {
		return medicalClaimDataService
				.generateEntryNoForContingentEntry(diagMap);
	}

	public Map<String, Object> submitCardicReimbursement(Box box,
			Map<String, Object> dataMap) {
		return medicalClaimDataService.submitCardicReimbursement(box, dataMap);
	}

	public Map<String, Object> getPatientDetailsForBillMovement(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService
				.getPatientDetailsForBillMovement(mapForDs);
	}

	public Map<String, Object> submitCardicBillMovement(Box box,
			Map<String, Object> dataMap) {
		return medicalClaimDataService.submitCardicBillMovement(box, dataMap);
	}

	public Map<String, Object> getPatientDetailsForCardicTracking(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService
				.getPatientDetailsForCardicTracking(mapForDs);
	}

	public Map<String, Object> showPatientForCardicClaim() {
		return medicalClaimDataService.showPatientForCardicClaim();
	}

	public Map<String, Object> getPatientForCardicTracking(int billMovementID) {
		return medicalClaimDataService
				.getPatientForCardicTracking(billMovementID);
	}

	public Map<String, Object> getDataForSpecialInvetigationJsp() {
		return medicalClaimDataService.getDataForSpecialInvetigationJsp();
	}

	public Map<String, Object> showPatientUpdateSpecialInv(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService.showPatientUpdateSpecialInv(mapForDs);
	}

	public Map<String, Object> showUpdateSpecialInvestigation(int specInvHdId) {
		return medicalClaimDataService
				.showUpdateSpecialInvestigation(specInvHdId);
	}

	public Map<String, Object> getPateintForCardicAdvance() {
		return medicalClaimDataService.getPateintForCardicAdvance();
	}

	public boolean updateAdvanceClaim(Box box) {
		return medicalClaimDataService.updateAdvanceClaim(box);
	}

	public Map<String, Object> showPatientUpdateCardicAdvance(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService.showPatientUpdateCardicAdvance(mapForDs);
	}

	public Map<String, Object> showUpdateCardicClaim(int cardicClaimId) {
		return medicalClaimDataService.showUpdateCardicClaim(cardicClaimId);
	}

	public Map<String, Object> getPateintForCardicBill() {
		return medicalClaimDataService.getPateintForCardicBill();
	}

	public Map<String, Object> showPatientUpdateCardicBill(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService.showPatientUpdateCardicBill(mapForDs);
	}

	public Map<String, Object> showUpdateCardicBill(int contingentHdID) {
		return medicalClaimDataService.showUpdateCardicBill(contingentHdID);
	}

	public boolean updateCardicBill(Box box) {
		return medicalClaimDataService.updateCardicBill(box);
	}

	public Map<String, Object> getDataForMedicalBillJsp() {
		return medicalClaimDataService.getDataForMedicalBillJsp();
	}

	public Map<String, Object> showPatientUpdateMedicalBill(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService.showPatientUpdateMedicalBill(mapForDs);
	}

	public Map<String, Object> showUpdateMedicalBill(int contingentHdID) {
		return medicalClaimDataService.showUpdateMedicalBill(contingentHdID);
	}

	public boolean updateMedicalBill(Box box) {
		return medicalClaimDataService.updateMedicalBill(box);
	}

	public Map<String, Object> updateSpecialInvestigation(Box box) {
		return medicalClaimDataService.updateSpecialInvestigation(box);
	}

	public Map<String, Object> getDataForCoveringLettersp() {
		return medicalClaimDataService.getDataForCoveringLettersp();
	}

	public Map<String, Object> showPatientUpdateCoveringLetter(
			Map<String, Object> mapForDs) {
		return medicalClaimDataService
				.showPatientUpdateCoveringLetter(mapForDs);
	}

	public Map<String, Object> showUpdateCoveringLetter(int coveringLetterId) {
		return medicalClaimDataService
				.showUpdateCoveringLetter(coveringLetterId);
	}

	public Map<String, Object> getConnectionForReport() {
		return medicalClaimDataService.getConnectionForReport();
	}

	public Map<String, Object> getPatientForCardicBillMovement(
			String serviceNo, Map<String, Object> mapForDs) {
		return medicalClaimDataService.getPatientForCardicBillMovement(
				serviceNo, mapForDs);
	}
	public Map<String, Object> showApprovePatientSearchContBill() {
		return medicalClaimDataService.showApprovePatientSearchContBill();
	}

	@Override
	public Map<String, Object> getApprovePatientContingentBill(Map<String, Object> mapForDs) {
		return medicalClaimDataService.getApprovePatientContingentBill(mapForDs);
	}

	@Override
	public Map<String, Object> getApprovePatientContBillDetails(Map<String, Object> mapForDs) {
		return medicalClaimDataService.getApprovePatientContBillDetails(mapForDs);
	}

	public MdContigentMedicalBillHd loadContBillObj(int contHdId) {
		return medicalClaimDataService.loadContBillObj(contHdId);
	}

	@Override
	public Map<String, Object> validateContBill(Map<String, Object> infoMap) {
		return medicalClaimDataService.validateContBill(infoMap);
	}
}
