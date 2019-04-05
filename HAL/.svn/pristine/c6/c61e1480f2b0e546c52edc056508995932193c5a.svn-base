package jkt.hms.lab.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public interface LabHandlerService {

	// -----------------------------Order
	// Booking-------------------------------------

	Map<String, Object> showOrderBookingJsp(Map<String, Object> map);

	Map<String, Object> getMainAndSubCharge();

	Map<String, Object> getChargeCode(Map<String, Object> parameterMap);

	Map<String, Object> fillItemsForChargeCode(Map<String, Object> dataMap);

	Map<String, Object> submitOrderBooking(Map<String, Object> infoMap);

	Map<String, Object> submitOrderBookingForInvestigation(
			Map<String, Object> infoMap);

	String getOrderSeqForDisplay(String string);

	String generateOrderNumber(int hospitalId);

	Map<String, Object> getPatientDetail(int visitNo);

	Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap);

	Map<String, Object> getPatientDetails(Map<String, Object> mapForDs);

	// Map<String, Object> getDetailsForSample();

	Map<String, Object> getPatientDetails(String hinNo);

	Map<String, Object> submitSampleCollection(Map<String, Object> parameterMap);

	Map<String, Object> getSampleCollectionDetails(Map orderMap);

	Map<String, Object> getSampleValidationSearch();

	Map<String, Object> getPatientDetailsForValidation(
			Map<String, Object> mapForDs);

	Map<String, Object> getSampleValidationDetails(int hinId, int uid,
			int deptId);

	Map<String, Object> getDetailsForValidationSearch();

	String getDiagSeqForDisplay(String string);

	List<Patient> getPatientName(String serviceNo);

	Map<String, Object> showOrderBookingForInvestigationJsp(int hinId);

	String getSampleSeqForDisplay(String string);

	Map<String, Object> getSampleCollectionGrid(Map<String, Object> mapForDs);

	boolean submitSampleAcceptance(Map<String, Object> parameterMap);

	Map<String, Object> showSampleNo();

	String generateDiagNumber();

	Map<String, Object> getSampleValidationGrid(Map<String, Object> mapForDs);
	


	// ---------------------------Report's
	// Screen-------------------------------------------

	Map<String, Object> showDiagnosticRegisterDoctorWise(Map<String, Object> map);

	Map<String, Object> showPatientWiseFilmsJsp(Map<String, Object> map);

	Map<String, Object> showMicrobiologySensitiveWiseReportJsp(
			Map<String, Object> map);

	Map<String, Object> showDiagnosticRegisterDiagnosisWise(
			Map<String, Object> map);

	Map<String, Object> showPackingListJsp();

	// ------------------------------- For Report by
	// Vishal------------------------------------
	Map<String, Object> getConnectionForReport();

	List<Visit> getVisitNo(int hinId);

	Map<String, Object> showDepartmentWiseSummary();

	List<DgOrderhd> getOrderNoList(Map<String, Object> detailsMap);

	List<Object> getHinNoList(String serviceNo);

	List<Object> getResultList(Map<String, Object> detailsMap);

	Map<String, Object> getPatientDetailsForSampleCollection(
			Map<String, Object> mapForDs);

	Map<String, Object> getSampleCollectionDetailsForNext(int newCollectionId);

	Map<String, Object> getSampleValidationDetailsForNext(int newSampleId);

	Map<String, Object> showDiagnosticRegisterJsp(Map<String, Object> map);

	Map<String, Object> getDgOrderHd(Integer orderNo);

	// -------------------------------Start Methods developed by Vivek
	// --------------------------------------
	//
	// Map<String, Object> getOrganismList(Map<String, Object> dataMap);
	//
	// Map<String, Object> getSensitivityList(Map<String, Object> dataMap);
	//
	// Map<String, Object> saveSensitivity(Map<String, Object> dataMap);
	//	
	// -------------------------------End Methods developed by
	// Vivek------------------------------------------
	Map<String, Object> getOrderDetails(Map<String, Object> mapForDs);

	Map<String, Object> updateOrderDetails(
			Map<String, Object> creationDetailsMap);

	Map<String, Object> getDetailsForOrderSearch();

	Map<String, Object> getUpdatableOrdersGridForSingleOrder(
			Map<String, Object> mapForDs);

	Map<String, Object> getUpdatableOrdersGrid(Map<String, Object> mapForDs);

	List<Patient> getIPDPatientName(String serviceNo);

	Map<String, Object> getDetailsForIPDSearch();

	Map<String, Object> getPatientDetailsForIPDOrderBooking(
			Map<String, Object> mapForDs);

	Map<String, Object> getEmployeeDetailMap(Map<String, Object> mapForDs);

	Map<String, Object> getOrderDtMap(Map<String, Object> mapForDs);

	Map<String, Object> getDetailsForAllResultTypes(Map<String, Object> mapForDs);

	Map<String, Object> getResultForRadiologyTest(Map<String, Object> mapForDs);

	Map<String, Object> getResultEntryDetailsForLabOrderStatus(int resultId,
			int deptId);

	Map<String, Object> getOrderNoForCancelOrderList(
			Map<String, Object> mapForDs);

	Map<String, Object> getTestDetailsForCancel(Map<String, Object> mapForDs);

	Map<String, Object> cancelTestsInDgOrderdt(Map<String, Object> mapForDs);

	Map<String, Object> cancelTestsInDgSampleCollectionDetailLab(
			Map<String, Object> mapForDs);

	Map<String, Object> cancelTestsInDgSampleCollectionDetail(
			Map<String, Object> mapForDs);

	Map<String, Object> getAllConfidentialOrders(Map<String, Object> requestMap);

	Map<String, Object> getOrderDtForConfidentialTest(
			Map<String, Object> mapForDs);

	Map<String, Object> getDiagnosticRegister(Map<String, Object> mapForDs);

	Map<String, Object> printOrderStatusReport(Map<String, Object> mapForDs);

	Map<String, Object> getAllOrderForOrderBookingReport(
			Map<String, Object> requestMap);

	Map<String, Object> getDiagnosticRegisterForMultipleTestType(
			Map<String, Object> mapForDs);

	Map<String, Object> getResultEntryDetailsForMultipleResultType(
			int resultId, int deptId);

	Map<String, Object> checkForExistingSeqNo(Map<String, Object> mapForDs);

	Map<String, Object> updateOrderBookingForInvestigation(
			Map<String, Object> infoMap);

	Map<String, Object> updateSampleCollection(Map<String, Object> parameterMap);

	Map<String, Object> rejectSample(Map<String, Object> mapForDs);

	Map<String, Object> getSampleValidationLabGrid(Map<String, Object> mapForDs);

	Map<String, Object> getPatientDetailsForValidationLab(
			Map<String, Object> mapForDs);

	Map<String, Object> getSampleValidationDetailsLab(String combinedIds,
			int uid, int deptId);

	boolean submitSampleAcceptanceLab(Map<String, Object> parameterMap);

	Map<String, Object> getTotalCountDepartmentWise(Map<String, Object> mapForDs);

	Map<String, Object> showDiagnosticRegisterSummaryJsp(Map<String, Object> map);

	Map<String, Object> getDiagnosticSummary(Box box);

	Map<String, Object> showBloodDonorPanelJsp(int hospitalId);

	Map<String, Object> getDiagnosticDetailstForGraph(Box box);

	Map<String, Object> showInvestigationRequisitionWaitingList(int hospitalId, int deptId);

	Map<String, Object> showInvestigationRequisitionJsp(Box box);

	Map<String, Object> submitInvestigationRequisition(Box box);

	Map<String, Object> getInvestigationDetailsForDischargeSummary(
			Map<String, Object> detailsMap);

	Map<String, Object> getPhysiotherapyList(Map<String, Object> detailsMap);

	Map<String, Object> getResponseForPhysiotherapyDetails(Box box);
	
	Map<String, Object> getHospitalName(int hospitalId);
	
	Map<String, Object> investigationResult(Box box);

	Map<String, Object> getPatientDetailsforBackup(Map<String, Object> mapForDs);
}
