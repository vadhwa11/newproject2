package jkt.hms.mediClaim.handler;

import java.util.Map;

import jkt.hms.masters.business.MdCardicClaimAdvance;
import jkt.hms.masters.business.MdContigentMedicalBillHd;
import jkt.hms.masters.business.MdMasAuthority;
import jkt.hms.util.Box;

public interface MedicalClaimHandlerService {
	// ---------------------Authority master----------------------------
	Map<String, Object> showAuthorityJsp();

	Map<String, Object> searchAuthority(String authorityCode,
			String authorityName);

	boolean addAuthority(MdMasAuthority masAuthority);

	boolean editAuthority(Map<String, Object> generalMap);

	boolean deleteAuthority(int authorityId, Map<String, Object> generalMap);

	// ----------------Request for Special Investigation Entry----------------

	Map<String, Object> showPatientSearchForSpecialinvestigationJsp();

	Map<String, Object> getPatientDetails(Map<String, Object> mapForDs);

	Map<String, Object> getPatientforInvestigationDetails(int hinId);

	Map<String, Object> getChargeName(Map<String, Object> parameterMap);

	Map<String, Object> fillItemsForChargeName(Map<String, Object> dataMap);

	String getyearlySeqForDisplay(String string);

	Map<String, Object> getDiagnosis(Map<String, Object> parameterMap);

	Map<String, Object> submitSpecialinvestigation(Map<String, Object> infoMap);

	String generateYearlyNumber();

	Map<String, Object> getUnitName(Map<String, Object> parameterMap);

	// ------------- Contingent Bill for Reimbursement of Medical Bill
	// Entry-----
	Map<String, Object> showPatientSearchForContingentBill();

	Map<String, Object> getPatientDetailsForContingentBill(
			Map<String, Object> mapForDs);

	Map<String, Object> getPatientForContingentBillDetails(
			Map<String, Object> mapForDs);

	String generateEntryNumber();

	String getEntrySeqForDisplay(String string);

	Map<String, Object> submitContingentBill(Map<String, Object> infoMap);

	// -------------------Covering Letters to Unit-----------------
	String getCoveringEntrySeqForDisplay(String string);

	Map<String, Object> showPatientForCoveringLetterUnit(
			Map<String, Object> dataMap);

	Map<String, Object> fillItemsForUnitName(Map<String, Object> dataMap);

	Map<String, Object> submitCoveringletter(Map<String, Object> parameterMap);

	Map<String, Object> showGeneralClaimCoveringLetter(
			Map<String, Object> dataMap);

	String getGenCoverEntryNoDisplay(String string);

	// -------------------------General Covering Letter----------------
	Map<String, Object> submitGeneralCoveringletter(
			Map<String, Object> parameterMap);

	Map<String, Object> showPatientForGeneralClaim();

	// -----------------------General Tracking------------------------
	Map<String, Object> getPatientDetailsForGeneralTracking(
			Map<String, Object> mapForDs);

	Map<String, Object> getPatientForGeneralTracking(
			Map<String, Object> mapForDs);

	// --------------------Cardic Claim Advance--------------------------
	Map<String, Object> showPatientCardicClaimAdvance();

	Map<String, Object> getPatientDetailsCardicClaim(
			Map<String, Object> mapForDs);

	Map<String, Object> getPatientforCardicAdvance(int hinId);

	String getyearlyEntryForDisplay(String string);

	Map submitCardicClaimAdvance(MdCardicClaimAdvance cardicClaimAdvance);

	String generateAdvanceEntryNumber();

	// ------- Cardiac claim – Contingent Bill for Reimbursement-----
	Map<String, Object> showPatientSearchForCardicReimbursement();

	Map<String, Object> getPatientForCardicAdvanceBill(
			Map<String, Object> mapForDs);

	Map<String, Object> getPatientDetailsForCardicAdvance(
			Map<String, Object> mapForDs);

	String getCardicEntryForDisplay(String string);

	String generateEntryNoForContingentEntry(Map<String, Object> diagMap);

	Map<String, Object> submitCardicReimbursement(Box box,
			Map<String, Object> dataMap);

	// ---------- Contingent bill movement entry-------------
	Map<String, Object> showPatientSearchContingentBillMovement();

	Map<String, Object> getPatientDetailsForBillMovement(
			Map<String, Object> mapForDs);

	Map<String, Object> submitCardicBillMovement(Box box,
			Map<String, Object> dataMap);

	// --------Cardic Claim Tracking-----------
	Map<String, Object> getPatientDetailsForCardicTracking(
			Map<String, Object> mapForDs);

	Map<String, Object> showPatientForCardicClaim();

	Map<String, Object> getPatientForCardicTracking(int billMovementID);

	Map<String, Object> getDataForSpecialInvetigationJsp();

	Map<String, Object> showPatientUpdateSpecialInv(Map<String, Object> mapForDs);

	Map<String, Object> showUpdateSpecialInvestigation(int specInvHdId);

	boolean updateAdvanceClaim(Box box);

	Map<String, Object> getPateintForCardicAdvance();

	Map<String, Object> showPatientUpdateCardicAdvance(
			Map<String, Object> mapForDs);

	Map<String, Object> showUpdateCardicClaim(int cardicClaimId);

	Map<String, Object> getPateintForCardicBill();

	Map<String, Object> showPatientUpdateCardicBill(Map<String, Object> mapForDs);

	Map<String, Object> showUpdateCardicBill(int contingentHdID);

	boolean updateCardicBill(Box box);

	Map<String, Object> getDataForMedicalBillJsp();

	Map<String, Object> showPatientUpdateMedicalBill(
			Map<String, Object> mapForDs);

	Map<String, Object> showUpdateMedicalBill(int contingentHdID);

	boolean updateMedicalBill(Box box);

	Map<String, Object> updateSpecialInvestigation(Box box);

	Map<String, Object> getDataForCoveringLettersp();

	Map<String, Object> showPatientUpdateCoveringLetter(
			Map<String, Object> mapForDs);

	Map<String, Object> showUpdateCoveringLetter(int coveringLetterId);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> getPatientForCardicBillMovement(String serviceNo,
			Map<String, Object> mapForDs);

	Map<String, Object> showApprovePatientSearchContBill();

	Map<String, Object> getApprovePatientContingentBill(Map<String, Object> mapForDs);

	Map<String, Object> getApprovePatientContBillDetails(
			Map<String, Object> mapForDs);

	MdContigentMedicalBillHd loadContBillObj(int contHdId);

	Map<String, Object> validateContBill(Map<String, Object> infoMap);

}
