package jkt.hms.lab.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.lab.dataservice.LabDataService;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public class LabHandlerServiceImpl implements LabHandlerService {

	LabDataService labDataService = null;

	// -------------------------Order Booking----------------------------
	public Map<String, Object> showOrderBookingJsp(Map<String, Object> map) {
		return labDataService.showOrderBookingJsp(map);
	}

	public Map<String, Object> getMainAndSubCharge() {
		return labDataService.getMainAndSubCharge();
	}

	public Map<String, Object> getChargeCode(Map<String, Object> parameterMap) {
		return labDataService.getChargeCode(parameterMap);
	}

	public Map<String, Object> fillItemsForChargeCode(
			Map<String, Object> dataMap) {
		return labDataService.fillItemsForChargeCode(dataMap);
	}

	public Map<String, Object> submitOrderBooking(Map<String, Object> infoMap) {
		return labDataService.submitOrderBooking(infoMap);
	}

	public String getOrderSeqForDisplay(String string) {
		return labDataService.getOrderSeqForDisplay(string);
	}

	public Map<String, Object> submitOrderBookingForInvestigation(
			Map<String, Object> infoMap) {
		return labDataService.submitOrderBookingForInvestigation(infoMap);
	}

	public String generateOrderNumber(int hospitalId) {
		return labDataService.generateOrderNumber(hospitalId);
	}

	public Map<String, Object> showOrderBookingForInvestigationJsp(int hinId) {
		return labDataService.showOrderBookingForInvestigationJsp(hinId);
	}

	public Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap) {
		return labDataService.getDetailsForSearch(dataMap);
	}

	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		return labDataService.getPatientDetails(mapForDs);
	}

	/*
	 * public Map<String, Object> getDetailsForSample() { return
	 * labDataService.getDetailsForSample(); }
	 */
	public List<Patient> getPatientName(String serviceNo) {
		return labDataService.getPatientName(serviceNo);
	}

	public Map<String, Object> getPatientDetails(String hinNo) {
		return labDataService.getPatientDetails(hinNo);
	}

	public Map<String, Object> getPatientDetail(String visitNo) {
		return labDataService.getPatientDetails(visitNo);
	}

	public Map<String, Object> submitSampleCollection(
			Map<String, Object> parameterMap) {
		return labDataService.submitSampleCollection(parameterMap);
	}

	/*
	 * public Map<String, Object> showSampleCollectionJsp(Map<String, Object>
	 * map) { return labDataService.showSampleCollectionJsp(map); }
	 */

	public Map<String, Object> getSampleCollectionDetails(Map orderMap) {
		return labDataService.getSampleCollectionDetails(orderMap);
	}

	public Map<String, Object> getSampleValidationSearch() {
		return labDataService.getSampleValidationSearch();
	}

	public Map<String, Object> getDetailsForValidationSearch() {
		return labDataService.getDetailsForValidationSearch();
	}

	public Map<String, Object> getPatientDetailsForValidation(
			Map<String, Object> mapForDs) {
		return labDataService.getPatientDetailsForValidation(mapForDs);
	}

	public Map<String, Object> getSampleValidationDetails(int hinId, int uid,
			int deptId) {
		return labDataService.getSampleValidationDetails(hinId, uid, deptId);
	}

	public String getDiagSeqForDisplay(String string) {
		return labDataService.getDiagSeqForDisplay(string);
	}

	public String getSampleSeqForDisplay(String string) {
		return labDataService.getSampleSeqForDisplay(string);
	}

	public boolean submitSampleAcceptance(Map<String, Object> parameterMap) {
		return labDataService.submitSampleAcceptance(parameterMap);
	}

	public Map<String, Object> showSampleNo() {
		return labDataService.showSampleNo();
	}

	public String generateDiagNumber() {
		return labDataService.generateDiagNumber();
	}

	public Map<String, Object> getSampleValidationGrid(
			Map<String, Object> mapForDs) {
		return labDataService.getSampleValidationGrid(mapForDs);
	}

	public Map<String, Object> getPatientDetail(int visitNo) {
		return labDataService.getPatientDetail(visitNo);
	}

	public Map<String, Object> getSampleCollectionGrid(
			Map<String, Object> mapForDs) {
		return labDataService.getSampleCollectionGrid(mapForDs);
	}


	
	// --------------------------Reports-------------------------------------

	public Map<String, Object> showDiagnosticRegisterDoctorWise(
			Map<String, Object> map) {
		return labDataService.showDiagnosticRegisterDoctorWise(map);
	}

	public Map<String, Object> showDiagnosticRegisterDiagnosisWise(
			Map<String, Object> map) {
		return labDataService.showDiagnosticRegisterDiagnosisWise(map);
	}

	public Map<String, Object> showPackingListJsp() {
		return labDataService.showPackingListJsp();
	}

	// -----------------------By Vishal start---------------------------------

	public Map<String, Object> getConnectionForReport() {
		return labDataService.getConnectionForReport();
	}

	// ----------------------------------------------------------------------------------------------
	public LabDataService getLabDataService() {
		return labDataService;
	}

	public void setLabDataService(LabDataService labDataService) {
		this.labDataService = labDataService;
	}

	public List<Visit> getVisitNo(int hinId) {
		return labDataService.getVisitNo(hinId);
	}

	public Map<String, Object> showDepartmentWiseSummary() {
		return labDataService.showDepartmentWiseSummary();
	}

	public List<DgOrderhd> getOrderNoList(Map<String, Object> detailsMap) {
		return labDataService.getOrderNoList(detailsMap);
	}

	public List<Object> getHinNoList(String serviceNo) {
		return labDataService.getHinNoList(serviceNo);
	}

	public List<Object> getResultList(Map<String, Object> detailsMap) {
		return labDataService.getResultList(detailsMap);
	}

	public Map<String, Object> getPatientDetailsForSampleCollection(
			Map<String, Object> mapForDs) {
		return labDataService.getPatientDetailsForSampleCollection(mapForDs);
	}

	public Map<String, Object> getSampleCollectionDetailsForNext(
			int newCollectionId) {
		return labDataService
				.getSampleCollectionDetailsForNext(newCollectionId);
	}

	public Map<String, Object> getSampleValidationDetailsForNext(int newSampleId) {
		return labDataService.getSampleValidationDetailsForNext(newSampleId);
	}

	public Map<String, Object> showDiagnosticRegisterJsp(Map<String, Object> map) {
		return labDataService.showDiagnosticRegisterJsp(map);
	}

	public Map<String, Object> showPatientWiseFilmsJsp(Map<String, Object> map) {

		return labDataService.showPatientWiseFilmsJsp(map);
	}

	public Map<String, Object> showMicrobiologySensitiveWiseReportJsp(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return labDataService.showMicrobiologySensitiveWiseReportJsp(map);
	}

	// -------------------------------Start Methods developed by Vivek
	// --------------------------------------
	// public Map<String, Object> getOrganismList(Map<String, Object> dataMap) {
	// // TODO Auto-generated method stub
	// return labDataService.getOrganismList(dataMap);
	// }
	// public Map<String, Object> getSensitivityList(Map<String, Object>
	// dataMap) {
	// // TODO Auto-generated method stub
	// return labDataService.getSensitivityList(dataMap);
	// }
	// public Map<String, Object> saveSensitivity(Map<String, Object> dataMap) {
	// // TODO Auto-generated method stub
	// return labDataService.saveSensitivity(dataMap);
	// }

	// -------------------------------End Methods developed by
	// Vivek------------------------------------------

	public Map<String, Object> getDgOrderHd(Integer orderNo) {
		return labDataService.getDgOrderHd(orderNo);
	}

	public Map<String, Object> getOrderDetails(Map<String, Object> mapForDs) {
		return labDataService.getOrderDetails(mapForDs);
	}

	public Map<String, Object> updateOrderDetails(
			Map<String, Object> creationDetailsMap) {
		return labDataService.updateOrderDetails(creationDetailsMap);
	}

	public Map<String, Object> getDetailsForOrderSearch() {
		return labDataService.getDetailsForOrderSearch();
	}

	public Map<String, Object> getUpdatableOrdersGridForSingleOrder(
			Map<String, Object> mapForDs) {
		return labDataService.getUpdatableOrdersGridForSingleOrder(mapForDs);
	}

	public Map<String, Object> getUpdatableOrdersGrid(
			Map<String, Object> mapForDs) {
		return labDataService.getUpdatableOrdersGrid(mapForDs);
	}

	public List<Patient> getIPDPatientName(String serviceNo) {
		return labDataService.getIPDPatientName(serviceNo);
	}

	public Map<String, Object> getDetailsForIPDSearch() {
		return labDataService.getDetailsForIPDSearch();
	}

	public Map<String, Object> getPatientDetailsForIPDOrderBooking(
			Map<String, Object> mapForDs) {
		return labDataService.getPatientDetailsForIPDOrderBooking(mapForDs);
	}

	public Map<String, Object> getEmployeeDetailMap(Map<String, Object> mapForDs) {
		return labDataService.getEmployeeDetailMap(mapForDs);
	}

	public Map<String, Object> getOrderDtMap(Map<String, Object> mapForDs) {
		return labDataService.getOrderDtMap(mapForDs);
	}

	public Map<String, Object> getDetailsForAllResultTypes(
			Map<String, Object> mapForDs) {
		return labDataService.getDetailsForAllResultTypes(mapForDs);
	}

	public Map<String, Object> getResultForRadiologyTest(
			Map<String, Object> mapForDs) {
		return labDataService.getResultForRadiologyTest(mapForDs);
	}

	public Map<String, Object> getResultEntryDetailsForLabOrderStatus(
			int resultId, int deptId) {
		return labDataService.getResultEntryDetailsForLabOrderStatus(resultId,
				deptId);
	}

	public Map<String, Object> getOrderNoForCancelOrderList(
			Map<String, Object> mapForDs) {
		return labDataService.getOrderNoForCancelOrderList(mapForDs);
	}

	public Map<String, Object> getTestDetailsForCancel(
			Map<String, Object> mapForDs) {
		return labDataService.getTestDetailsForCancel(mapForDs);
	}

	public Map<String, Object> cancelTestsInDgOrderdt(
			Map<String, Object> mapForDs) {
		return labDataService.cancelTestsInDgOrderdt(mapForDs);
	}

	public Map<String, Object> cancelTestsInDgSampleCollectionDetailLab(
			Map<String, Object> mapForDs) {
		return labDataService
				.cancelTestsInDgSampleCollectionDetailLab(mapForDs);
	}

	public Map<String, Object> cancelTestsInDgSampleCollectionDetail(
			Map<String, Object> mapForDs) {
		return labDataService.cancelTestsInDgSampleCollectionDetail(mapForDs);
	}

	public Map<String, Object> getAllConfidentialOrders(
			Map<String, Object> requestMap) {
		return labDataService.getAllConfidentialOrders(requestMap);
	}

	public Map<String, Object> getOrderDtForConfidentialTest(
			Map<String, Object> mapForDs) {
		return labDataService.getOrderDtForConfidentialTest(mapForDs);
	}

	public Map<String, Object> getDiagnosticRegister(
			Map<String, Object> mapForDs) {
		return labDataService.getDiagnosticRegister(mapForDs);
	}

	public Map<String, Object> printOrderStatusReport(
			Map<String, Object> mapForDs) {
		return labDataService.printOrderStatusReport(mapForDs);
	}

	public Map<String, Object> getAllOrderForOrderBookingReport(
			Map<String, Object> requestMap) {
		return labDataService.getAllOrderForOrderBookingReport(requestMap);
	}

	public Map<String, Object> getDiagnosticRegisterForMultipleTestType(
			Map<String, Object> mapForDs) {
		return labDataService
				.getDiagnosticRegisterForMultipleTestType(mapForDs);
	}

	public Map<String, Object> getResultEntryDetailsForMultipleResultType(
			int resultId, int deptId) {
		return labDataService.getResultEntryDetailsForMultipleResultType(
				resultId, deptId);
	}

	public Map<String, Object> checkForExistingSeqNo(
			Map<String, Object> mapForDs) {
		return labDataService.checkForExistingSeqNo(mapForDs);
	}

	public Map<String, Object> updateOrderBookingForInvestigation(
			Map<String, Object> infoMap) {
		return labDataService.updateOrderBookingForInvestigation(infoMap);
	}

	public Map<String, Object> updateSampleCollection(
			Map<String, Object> parameterMap) {
		return labDataService.updateSampleCollection(parameterMap);
	}

	public Map<String, Object> rejectSample(Map<String, Object> mapForDs) {
		return labDataService.rejectSample(mapForDs);
	}

	public Map<String, Object> getSampleValidationLabGrid(
			Map<String, Object> mapForDs) {
		return labDataService.getSampleValidationLabGrid(mapForDs);
	}

	public Map<String, Object> getPatientDetailsForValidationLab(
			Map<String, Object> mapForDs) {
		return labDataService.getPatientDetailsForValidationLab(mapForDs);
	}

	public Map<String, Object> getSampleValidationDetailsLab(
			String combinedIds, int uid, int deptId) {
		return labDataService.getSampleValidationDetailsLab(combinedIds, uid,
				deptId);
	}

	public boolean submitSampleAcceptanceLab(Map<String, Object> parameterMap) {
		return labDataService.submitSampleAcceptanceLab(parameterMap);
	}

	public Map<String, Object> getTotalCountDepartmentWise(
			Map<String, Object> mapForDs) {
		return labDataService.getTotalCountDepartmentWise(mapForDs);
	}

	@Override
	public Map<String, Object> showDiagnosticRegisterSummaryJsp(Map<String, Object> map) {
		return labDataService.showDiagnosticRegisterSummaryJsp(map);
	}

	@Override
	public Map<String, Object> getDiagnosticSummary(Box box) {
		return labDataService.getDiagnosticSummary(box) ;
	}

	@Override
	public Map<String, Object> showBloodDonorPanelJsp(int hospitalId) {
		return labDataService.showBloodDonorPanelJsp(hospitalId);
	}

	@Override
	public Map<String, Object> getDiagnosticDetailstForGraph(Box box) {
		return labDataService.getDiagnosticDetailstForGraph(box);
	}

	@Override
	public Map<String, Object> showInvestigationRequisitionWaitingList(int hospitalId, int deptId) {
		return labDataService.showInvestigationRequisitionWaitingList(hospitalId, deptId);
	}

	@Override
	public Map<String, Object> showInvestigationRequisitionJsp(Box box) {
		return labDataService.showInvestigationRequisitionJsp(box);
	}

	@Override
	public Map<String, Object> submitInvestigationRequisition(Box box) {
		return labDataService.submitInvestigationRequisition(box);
	}

	@Override
	public Map<String, Object> getInvestigationDetailsForDischargeSummary(
			Map<String, Object> detailsMap) {
		return labDataService.getInvestigationDetailsForDischargeSummary(detailsMap);
	}

	@Override
	public Map<String, Object> getPhysiotherapyList(Map<String, Object> detailsMap) {
		return labDataService.getPhysiotherapyList(detailsMap) ;
	}

	@Override
	public Map<String, Object> getResponseForPhysiotherapyDetails(Box box) {
		return labDataService.getResponseForPhysiotherapyDetails(box);
	}
	@Override
	public Map<String, Object> getHospitalName(int hospitalId)
	{
		return labDataService.getHospitalName(hospitalId);
	}

	@Override
	public Map<String, Object> investigationResult(Box box) {
		return labDataService.investigationResult(box);
	}

	@Override
	public Map<String, Object> getPatientDetailsforBackup(
			Map<String, Object> mapForDs) {
		return labDataService.getPatientDetailsforBackup(mapForDs);
	}

}
