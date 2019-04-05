package jkt.hms.opd.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.MasVaccineItem;
import jkt.hms.masters.business.OpdVaccinMst;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.Visit;
import jkt.hms.opd.dataservice.OPDDataService;
import jkt.hms.pacs.controller.PacsPatient;
import jkt.hms.util.Box;

public class OPDHandlerServiceImpl implements OPDHandlerService {

	
	OPDDataService opdDataService = null;

	public OPDDataService getOpdDataService() {
		return opdDataService;
	}

	public void setOpdDataService(OPDDataService opdDataService) {
		this.opdDataService = opdDataService;
	}

	// ---------------------------------------------methods written by

	public Map<String, Object> getWaitingPatientList(Map mapForDS) {
		return opdDataService.getWaitingPatientList(mapForDS);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchWaitingPatientList(Map map) {
		return opdDataService.searchWaitingPatientList(map);
	}

	@Override
	public Map<String, Object> doPatientRelease(Map<String, Object> dataMap) {
		return opdDataService.doPatientRelease(dataMap);
	}

		
	@Override
	public boolean getAuthorizationForHighValueMedicine(Map<String, Object> dataMap) {
		return opdDataService.getAuthorizationForHighValueMedicine(dataMap);
	}
	
	
	@Override
	public Map<String, Object> getTodayOtherPrescription(Map<String, Object> dataMap) {
		return opdDataService.getTodayOtherPrescription(dataMap);
	}
	
	@Override
	public Map<String, Object> getTodayOtherPrescriptionForIPD(int hinId ) {
		return opdDataService.getTodayOtherPrescriptionForIPD(hinId);
	}
	
	
	@Override
	public Map<String, Object> stopCurrentMedication(Map<String, Object> dataMap) {
		return opdDataService.stopCurrentMedication(dataMap);
	}
	@Override
	public Map<String, Object> checkForAlreadyIssuedPrescription(String itemCode, int hindId,int hospitalId){
		return opdDataService.checkForAlreadyIssuedPrescription(itemCode,hindId, hospitalId);
	}
	
	@Override
	public Map<String, Object> getBedStatus(int deptId, int hospitalId) {
		// TODO Auto-generated method stub
		return opdDataService.getBedStatus(deptId, hospitalId);
	}
	
	@Override
	public Map<String, Object> checkMappedCharge(Map<String, Object> map) {
		return opdDataService.checkMappedCharge(map);
	}
	
	public Map<String,Object>getHospitalDepartment(Map<String,Object>map){
		// TODO Auto-generated method stub
		return opdDataService.getHospitalDepartment(map);
	}
	
	public Map<String,Object>getHospitalWards(Map<String,Object>map){
		// TODO Auto-generated method stub
		return opdDataService.getHospitalWards(map);
	}
	
	public Map<String, Object> getOPNursingCareWaitingList(	Map<String, Object> map) {
		return opdDataService.getOPNursingCareWaitingList(map);
	}
	
	
	@Override
	public Map<String, Object> getDetailsForProcWaitList(int hospitalId,int visitId, String procedureType) {
		return opdDataService.getDetailsForProcWaitList(hospitalId,visitId,  procedureType);
	}
	
	@Override
	public Map<String, Object> getItemBatch(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.getItemBatch(box);
	}
	
	@Override
	public Map<String, Object> submitNursingCare(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.submitNursingCare(box);
	}
	
	@Override
	public Map<String, Object> getPendingInjectionList(Box box,Date FromDate,Date ToDate,int hospitalId) {
		// TODO Auto-generated method stub
		return opdDataService.getPendingInjectionList(box,FromDate,ToDate,hospitalId);
	}
	
	@Override
	public Map<String, Object> saveNursingCare(Box box) {
		return opdDataService.saveNursingCare(box);
	}

	@Override
	public Map<String, Object> getProcedureDetailsForPopUp(Box box) {
		return opdDataService.getProcedureDetailsForPopUp(box);
	}

	
	public Map<String, Object> getPatientDetails(int visitId) {

		return opdDataService.getPatientDetails(visitId);
	}
	public Map<String , Object> getOpdOphthalmology(int VisitId){
		return opdDataService.getOpdOphthalmology(VisitId);
	}

	public Map<String, Object> getDrugAndProcedureDetails(Map<String, Object> map)
	{
		return opdDataService.getDrugAndProcedureDetails(map);
	}
	
	public Map<String, Object> getPatientDetailsForPrescribtion(int visitNo,
			String HinNo) {

		return opdDataService.getPatientDetailsForPrescribtion(visitNo, HinNo);
	}

	public Map<String, Object> getICDList(Map map) {
		return opdDataService.getICDList(map);
	}
	
	@Override
	public Map<String, Object> uploadAndViewDocuments(Map<String, Object> dataMap) {
		return opdDataService.uploadAndViewDocuments(dataMap);
	}

	@Override
	public Map<String, Object> viewPreAnesthesiaDetails(Map<String, Object> dataMap) {
		return opdDataService.viewPreAnesthesiaDetails(dataMap);
	}
	
	
	public Map<String, Object> getOPDDetails(Map mapForDS) {
		return opdDataService.getOPDDetails(mapForDS);
	}

	public Map<String, Object> showOPDTreatmentRecords(Map<String, Object> details) {
		return opdDataService.showOPDTreatmentRecords(details);
	}

	public Map<String, Object> getItemListForAutoComplete(Map mapForDS) {
		return opdDataService.getItemListForAutoComplete(mapForDS);
	}

	public Map<String, Object> submitOPDPatientDetails(Map mapForDS) {
		return opdDataService.submitOPDPatientDetails(mapForDS);
	}
/*	public Map<String, Object> submitProPatientDetails(Map mapForDSPro) {
		
		return opdDataService.submitProPatientDetails(mapForDSPro);
	}*/
	
	public Map<String, Object> submitProPatientSicknessDetails(Map mapForDSPro) {
		
		return opdDataService.submitProPatientSicknessDetails(mapForDSPro);
	}
	public Map<String, Object> submitProPatientRegistrationDetails(Map mapForDSPro) {
		
		return opdDataService.submitProPatientRegistrationDetails(mapForDSPro);
	}
	
	public Map<String, Object> submitProPatientTreatmentDetails(Map mapForDSPro) {
		
		return opdDataService.submitProPatientTreatmentDetails(mapForDSPro);
	}
	public Map<String, Object> submitOPDPatientDetailsChange(Map mapForDS) {
		
		return opdDataService.submitOPDPatientDetailsChange(mapForDS);
	}

	public Map<String, Object> getInvestigationListForAutoComplete(Map mapForDS) {
		
		return opdDataService.getInvestigationListForAutoComplete(mapForDS);
	}

	public Map<String, Object> getChargeCodeValue(String chargeCodeName) {
		
		return opdDataService.getChargeCodeValue(chargeCodeName);
	}

	public Map<String, Object> getPreviousPatientVisit(Map mapForDS) {

		return opdDataService.getPreviousPatientVisit(mapForDS);
	}

	public Map<String, Object> viewPreviousVisit(Map mapForDS) {

		return opdDataService.viewPreviousVisit(mapForDS);
	}

	public Map<String, Object> showPatientPrevoiusPrescription(Map mapForDS) {
		
		return opdDataService.showPatientPrevoiusPrescription(mapForDS);
	}

	public Map<String, Object> showPatientPrevoiusInvestigation(Map mapForDS) {
		
		return opdDataService.showPatientPrevoiusInvestigation(mapForDS);
	}

	public Map<String, Object> showSurgeryRequisitionJsp(Map mapForDS) {
		
		return opdDataService.showSurgeryRequisitionJsp(mapForDS);
	}

	public Map<String, Object> showAjaxResponseForSurgeryRequisitionJsp(Map mapForDS) {
		return opdDataService.showAjaxResponseForSurgeryRequisitionJsp(mapForDS);
	}

	public Map<String, Object> showSurgeryRequisitionJspForHin(Map mapForDS) {
		return opdDataService.showSurgeryRequisitionJspForHin(mapForDS);
	}

	public Map<String, Object> submitSurgeryRequisitionDetails(Map mapForDS) {
		return opdDataService.submitSurgeryRequisitionDetails(mapForDS);
	}

	public Map<String, Object> searchPatientDetails(Map mapForDS) {
		return opdDataService.searchPatientDetails(mapForDS);
	}

	public boolean submitSurgeryRequisitionDetailsForInpatient(Map mapForDS) {
		return opdDataService
				.submitSurgeryRequisitionDetailsForInpatient(mapForDS);
	}

	public Map<String, Object> submitOphthalmologyDetails(Box box) {
		return opdDataService.submitOphthalmologyDetails(box);
	}

	public Map<String, Object> getPatientOphthalmologyDetails(
			Map<String, Object> parameterMap) {
		return opdDataService.getPatientOphthalmologyDetails(parameterMap);
	}

	public Map<String, Object> getFrequencyList() {
		return opdDataService.getFrequencyList();
	}

	public Map<String, Object> submitOphthalmologyDiagnosis(Box box) {
		return opdDataService.submitOphthalmologyDiagnosis(box);
	}

	public Map<String, Object> getOphthalmologyDiagnosisDetails(
			Map<String, Object> parameterMap) {
		return opdDataService.getOphthalmologyDiagnosisDetails(parameterMap);
	}

	public Map<String, Object> submitOphthalmologyRetinal(Box box) {
		return opdDataService.submitOphthalmologyRetinal(box);
	}

	public Map<String, Object> getOphthalmologyRetinalDetails(
			Map<String, Object> parameterMap) {
		return opdDataService.getOphthalmologyRetinalDetails(parameterMap);
	}

	public Map<String, Object> submitOphthalmologyFollowUp(Box box) {
		return opdDataService.submitOphthalmologyFollowUp(box);
	}

	public Map<String, Object> getOphthalmologyFollowUpDetails(
			Map<String, Object> parameterMap) {
		return opdDataService.getOphthalmologyFollowUpDetails(parameterMap);
	}
	// ................................... Patient Allergic Drugs

	public Map<String, Object> getPatientAllergicDrugs(int visitId) {
		return opdDataService.getPatientAllergicDrugs(visitId);
	}

	public Map<String, Object> fillItemsInGrid(Map<String, Object> dataMap) {
		return opdDataService.fillItemsInGrid(dataMap);
	}

	public Map<String, Object> getItemList(Map<String, Object> map) {
		return opdDataService.getItemList(map);
	}

	public Map<String, Object> addPatientAllergicDrugs(
			Map<String, Object> infoMap) {
		return opdDataService.addPatientAllergicDrugs(infoMap);
	}

	public Map<String, Object> getItem() {
		return opdDataService.getItem();
	}

	// ................................... Patient History

	public Map<String, Object> getPatientHistory(int visitId) {
		return opdDataService.getPatientHistory(visitId);
	}

	public boolean addPatientHistory(Map<String, Object> infoMap) {
		return opdDataService.addPatientHistory(infoMap);
	}

	public Map<String, Object> viewPatientHistory(
			Map<String, Object> parameterMap) {
		return opdDataService.viewPatientHistory(parameterMap);
	}

	// ................................Pediatric Vaccination Plan

	public Map<String, Object> getPediatricVaccinationPlanJsp(int visitId) {
		return opdDataService.getPediatricVaccinationPlanJsp(visitId);
	}

	public Map<String, Object> addPediatricVaccinationPlan(Box box) {
		return opdDataService.addPediatricVaccinationPlan(box);
	}

	public Map<String, Object> updatePediatricVaccinationPlan(Box box) {
		return opdDataService.updatePediatricVaccinationPlan(box);
	}

	// ................................... Pediatric Case Sheet

	public Map<String, Object> getPediatricCaseSheet(int visitId) {
		return opdDataService.getPediatricCaseSheet(visitId);
	}

	public Map<String, Object> addPediatricCaseSheet(Box box) {
		return opdDataService.addPediatricCaseSheet(box);
	}

	public Map<String, Object> viewPediatricCaseSheet(
			Map<String, Object> parameterMap) {
		return opdDataService.viewPediatricCaseSheet(parameterMap);
	}

	// ................................... OBG .............................

	public Map<String, Object> showOBGJsp(int visitId) {
		return opdDataService.showOBGJsp(visitId);
	}

	public Map<String, Object> addOBGOne(Box box) {
		return opdDataService.addOBGOne(box);
	}

	public Map<String, Object> updateOBG(Box box) {
		return opdDataService.updateOBG(box);
	}

	public Map<String, Object> addOrUpdateOBGJsp(Box box) {
		return opdDataService.addOrUpdateOBGJsp(box);
	}

	// ................................... ENT .............................

	public Map<String, Object> showENTJsp(int visitId) {
		return opdDataService.showENTJsp(visitId);
	}

	public Map<String, Object> addEnt(Box box) {
		return opdDataService.addEnt(box);
	}

	public Map<String, Object> viewEnt(Map<String, Object> parameterMap) {
		return opdDataService.viewEnt(parameterMap);
	}

	public Map<String, Object> viewOBGONE(Map<String, Object> parameterMap) {
		return opdDataService.viewOBGONE(parameterMap);
	}

	public Map<String, Object> viewOBGTWO(Map<String, Object> parameterMap) {
		return opdDataService.viewOBGTWO(parameterMap);

	}

	public Map<String, Object> viewOBGTHREE(Map<String, Object> parameterMap) {
		return opdDataService.viewOBGTHREE(parameterMap);

	}

	public Map<String, Object> viewOBGFOUR(Map<String, Object> parameterMap) {
		return opdDataService.viewOBGFOUR(parameterMap);
	}

	// ......................................Report...................................

	public List<Object> getHinNoList(String serviceNo) {
		return opdDataService.getHinNoList(serviceNo);
	}

	public List<Object> getVisitNoList(Map<String, Object> detailsMap) {
		return opdDataService.getVisitNoList(detailsMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return opdDataService.getConnectionForReport();
	}

	public Map<String, Object> showDailyDepartmentWiseReportJsp() {
		return opdDataService.showDailyDepartmentWiseReportJsp();
	}

	public Map<String, Object> showDailyOPDInvestigationsReportJsp() {
		return opdDataService.showDailyOPDInvestigationsReportJsp();
	}

	public Map<String, Object> showDailyOPDPrescriptionsReportJsp() {
		return opdDataService.showDailyOPDPrescriptionsReportJsp();
	}

	public Map<String, Object> showDailyOPDRankCategoryReportJsp() {
		return opdDataService.showDailyOPDRankCategoryReportJsp();
	}

	public Map<String, Object> viewPatientAllergicDrug(
			Map<String, Object> parameterMap) {
		return opdDataService.viewPatientAllergicDrug(parameterMap);
	}

	// -------------------------------- Cardiology Department

	public Map<String, Object> getCardiologyDepartmentDetails(int visitId) {
		return opdDataService.getCardiologyDepartmentDetails(visitId);
	}

	public boolean addCardiologyDepartmentDetails(Map<String, Object> infoMap) {
		return opdDataService.addCardiologyDepartmentDetails(infoMap);
	}

	public Map<String, Object> viewCardiologyDepartmentDetails(
			Map<String, Object> parameterMap) {
		return opdDataService.viewCardiologyDepartmentDetails(parameterMap);
	}

	// -------------------------------- Gastro-EnterologyEndoscopy-------

	public Map<String, Object> getGastroEnterologyEndoscopy(int visitId) {
		return opdDataService.getGastroEnterologyEndoscopy(visitId);
	}

	public boolean addGastroEnterologyEndoscopy(Map<String, Object> infoMap) {
		return opdDataService.addGastroEnterologyEndoscopy(infoMap);
	}

	public Map<String, Object> viewGastroEnterologyEndoscopy(
			Map<String, Object> parameterMap) {
		return opdDataService.viewGastroEnterologyEndoscopy(parameterMap);
	}

	// ------------------ Gastro-EnterologyColonoscopy

	public Map<String, Object> getGastroEnterologyColonoscopy(int visitId) {
		return opdDataService.getGastroEnterologyColonoscopy(visitId);
	}

	public boolean addGastroEnterologyColonoscopy(Map<String, Object> infoMap) {
		return opdDataService.addGastroEnterologyColonoscopy(infoMap);
	}

	public Map<String, Object> viewGastroEnterologyColonoscopy(
			Map<String, Object> parameterMap) {
		return opdDataService.viewGastroEnterologyColonoscopy(parameterMap);
	}

	// -------------------------------- ANTENATAL CARD

	public Map<String, Object> getAntenatalCard(int visitId) {
		return opdDataService.getAntenatalCard(visitId);
	}

	public boolean addAntenatalCard(Map<String, Object> infoMap) {
		return opdDataService.addAntenatalCard(infoMap);
	}

	public Map<String, Object> viewAntenatalCard(
			Map<String, Object> parameterMap) {
		return opdDataService.viewAntenatalCard(parameterMap);
	}

	public Map<String, Object> updateAntenatalCard(Box box) {
		return opdDataService.updateAntenatalCard(box);
	}

	public Map<String, Object> getGravidagramHTN(int visitId) {
		return opdDataService.getGravidagramHTN(visitId);
	}

	public Map<String, Object> getAntenatalCardEdit(int aId, int visitId) {
		return opdDataService.getAntenatalCardEdit(aId, visitId);
	}

	public boolean addGravidagramHTN(Map<String, Object> infoMap) {
		return opdDataService.addGravidagramHTN(infoMap);
	}

	public Map<String, Object> viewGravidagramHTN(
			Map<String, Object> parameterMap) {
		return opdDataService.viewGravidagramHTN(parameterMap);
	}

	public Map<String, Object> getGravidagramGestationalDiabitiesOne(int visitId) {
		return opdDataService.getGravidagramGestationalDiabitiesOne(visitId);
	}

	public boolean addGravidagramGestationalDiabitiesOne(
			Map<String, Object> infoMap) {
		return opdDataService.addGravidagramGestationalDiabitiesOne(infoMap);
	}

	public Map<String, Object> viewGravidagramGestationalDiabitiesOne(
			Map<String, Object> parameterMap) {
		return opdDataService
				.viewGravidagramGestationalDiabitiesOne(parameterMap);
	}

	public Map<String, Object> getGravidagramGestationalDiabitiesTwo(int visitId) {
		return opdDataService.getGravidagramGestationalDiabitiesTwo(visitId);
	}

	public boolean addGravidagramGestationalDiabitiesTwo(
			Map<String, Object> infoMap) {
		return opdDataService.addGravidagramGestationalDiabitiesTwo(infoMap);
	}

	public Map<String, Object> viewGravidagramGestationalDiabitiesTwo(
			Map<String, Object> parameterMap) {
		return opdDataService
				.viewGravidagramGestationalDiabitiesTwo(parameterMap);
	}

	public String generateOrderNumber(int hospitalId) {
		return opdDataService.generateOrderNumber(hospitalId);
	}

	public Map<String, Object> addOncosurgeryCaseSheet(Box box) {
		return opdDataService.addOncosurgeryCaseSheet(box);
	}

	public Map<String, Object> showOncosurgeryCaseSheetJsp(int visitId) {
		return opdDataService.showOncosurgeryCaseSheetJsp(visitId);
	}

	public Map<String, Object> viewOncosurgeryCaseSheet(
			Map<String, Object> parameterMap) {
		return opdDataService.viewOncosurgeryCaseSheet(parameterMap);

	}

	public Map<String, Object> addUrologyCaseSheet(Box box) {
		return opdDataService.addUrologyCaseSheet(box);
	}

	public Map<String, Object> showUrologyCaseSheetJsp(int visitId) {
		return opdDataService.showUrologyCaseSheetJsp(visitId);
	}

	public Map<String, Object> viewUrologyCaseSheet(
			Map<String, Object> parameterMap) {
		return opdDataService.viewUrologyCaseSheet(parameterMap);

	}

	public Map<String, Object> addOncosurgery(Box box) {
		return opdDataService.addOncosurgery(box);
	}

	public Map<String, Object> showOncosurgeryJsp(int visitId) {
		return opdDataService.showOncosurgeryJsp(visitId);
	}

	public Map<String, Object> viewOncosurgery(Map<String, Object> parameterMap) {
		return opdDataService.viewOncosurgery(parameterMap);

	}

	public Map<String, Object> showPatientPreviousHinNumber(
			Map<String, Object> mapForDS) {
		
		return opdDataService.showPatientPreviousHinNumber(mapForDS);
	}

	public Map<String, Object> getDepartmentNameFromId(int departmentId) {
		return opdDataService.getDepartmentNameFromId(departmentId);
	}

	public Map<String, Object> viewPreviousNextVisit(
			Map<String, Object> mapForDS) {
		return opdDataService.viewPreviousNextVisit(mapForDS);
	}

	public Map<String, Object> getOpdTemplateDepartmentWise(int visitId) {
		return opdDataService.getOpdTemplateDepartmentWise(visitId);
	}

	public boolean addOpdTemplateDepartmentWise(Map<String, Object> infoMap) {
		return opdDataService.addOpdTemplateDepartmentWise(infoMap);
	}

	public Map<String, Object> viewOpdTemplateDepartmentWise(
			Map<String, Object> parameterMap) {
		return opdDataService.viewOpdTemplateDepartmentWise(parameterMap);
	}

	public Map<String, Object> viewOpdTemplateDepartmentWisePreNext(
			Map<String, Object> parameterMap) {
		return opdDataService
				.viewOpdTemplateDepartmentWisePreNext(parameterMap);
	}

	public boolean submitSocioEconomicHistory(Map<String, Object> map) {
		
		return opdDataService.submitSocioEconomicHistory(map);
	}

	public Map<String, Object> viewGynaecology(Map<String, Object> parameterMap) {
		
		return opdDataService.viewGynaecology(parameterMap);
	}

	public boolean submitComplaints(Map<String, Object> map) {
		
		return opdDataService.submitComplaints(map);
	}

	public boolean submitGeneralExaminaton(Map<String, Object> map) {
		
		return opdDataService.submitGeneralExaminaton(map);
	}

	public boolean submitMedicalSurgicalHistory(Map<String, Object> map) {
		
		return opdDataService.submitMedicalSurgicalHistory(map);
	}

	public List<Patient> getPatientNameForUpadteOpdDetails(
			Map<String, Object> map) {
		return opdDataService.getPatientNameForUpadteOpdDetails(map);
	}

	public boolean submitSystemicExamination(Map<String, Object> map) {
		
		return opdDataService.submitSystemicExamination(map);
	}

	public Map<String, Object> showUploadingDocumentsJsp(int visitId, int inpatientId,Map<String, Object> mapForDS){
		return opdDataService.showUploadingDocumentsJsp(visitId, inpatientId,mapForDS);
	}

	public Map<String, Object> submitUploadDocuments(Box box) {
		return opdDataService.submitUploadDocuments(box);
	}

	public Map<String, Object> viewPatientDetails(Map<String, Object> map) {
		return opdDataService.viewPatientDetails(map);
	}
	
	public Map<String, Object> getPsychiatristQuestionnaire(Map<String, Object> map) {
		return opdDataService.getPsychiatristQuestionnaire(map);
	}

	
	public Map<String, Object> getPsychiatristQaHeading(Map<String, Object> map) {
		return opdDataService.getPsychiatristQaHeading(map);
	}
	
	
	public Map<String, Object> submitPsychiatristQuestionnaire(Map<String, Object> map) {
		return opdDataService.submitPsychiatristQuestionnaire(map);
	}
	
	public Map<String, Object> checkItem(Map<String, Object> dataMap) {
		return opdDataService.checkItem(dataMap);
	}

	public Map<String, Object> getSurListForAutoComplete(Map<String, Object> map) {
		
		return opdDataService.getSurListForAutoComplete(map);
	}

	public List<Visit> getVisitNo(int hinId) {
		return opdDataService.getVisitNo(hinId);
	}

	public Map<String, Object> getPatientOpdDetails(Map<String, Object> dataMap) {
		return opdDataService.getPatientOpdDetails(dataMap);
	}

	public Map<String, Object> getOPDDetailsForOpdUpdate(Map mapForDS) {
		return opdDataService.getOPDDetailsForOpdUpdate(mapForDS);
	}

	public boolean finalUpdateOpdPatientDetails(Map<String, Object> mapForDS) {
		return opdDataService.finalUpdateOpdPatientDetails(mapForDS);
	}

	public Map<String, Object> responseForDoctarsList(Map mapForDS) {
		return opdDataService.responseForDoctarsList(mapForDS);
	}

	public Map<String, Object> showOpdFrequencyJsp() {
		return opdDataService.showOpdFrequencyJsp();
	}

	public boolean addInvestigationTemplate(Map mapForDS) {
		return opdDataService.addInvestigationTemplate(mapForDS);
	}

	public Map<String, Object> getListForTreatment(Map<String, Object> mapForDS) {
		return opdDataService.getListForTreatment(mapForDS);
	}

	public boolean addPrescriptionTemplate(Map mapForDS) {
		return opdDataService.addPrescriptionTemplate(mapForDS);
	}

	public Map<String, Object> showOPDTemplateRecords(
			Map<String, Object> mapForDS) {
		return opdDataService.showOPDTemplateRecords(mapForDS);
	}

	public Map<String, Object> getInvestigationListForAutoCompleteSurgery(
			Map mapForDS) {
		return opdDataService
				.getInvestigationListForAutoCompleteSurgery(mapForDS);
	}

	/**
	 * -------------------------Start of methods for OPD Details Update By
	 */

	public Map<String, Object> showOrderBookingForInvestigationJsp(
			Map<String, Object> mapForDs) {
		return opdDataService.showOrderBookingForInvestigationJsp(mapForDs);
	}

	public String getOrderSeqForDisplay(String string) {
		return opdDataService.getOrderSeqForDisplay(string);
	}

	public Map<String, Object> getMainAndSubCharge() {
		return opdDataService.getMainAndSubCharge();
	}

	public Map<String, Object> submitOrderBookingForInvestigation(
			Map<String, Object> infoMap) {
		return opdDataService.submitOrderBookingForInvestigation(infoMap);
	}

	public Map<String, Object> submitSampleCollection(
			Map<String, Object> parameterMap) {
		return opdDataService.submitSampleCollection(parameterMap);
	}

	public Map<String, Object> searchENTForUpdateJsp(int visitId) {
		return opdDataService.searchENTForUpdateJsp(visitId);
	}

	public Map<String, Object> updateEnt(Box box) {
		return opdDataService.updateEnt(box);
	}

	public Map<String, Object> searchPediatricForUpdate(int visitId) {
		return opdDataService.searchPediatricForUpdate(visitId);
	}

	public Map<String, Object> updatePediatricCaseSheet(Box box) {
		return opdDataService.updatePediatricCaseSheet(box);
	}

	public Map<String, Object> getDetailsForVisit() {
		return opdDataService.getDetailsForVisit();
	}

	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		return opdDataService.getPatientDetails(mapForDs);
	}

	public int getTokenNoForDepartment(int departmentId) {
		return opdDataService.getTokenNoForDepartment(departmentId);
	}

	public Map<String, Object> getVisitDetails() {
		return opdDataService.getVisitDetails();
	}

	public Map<String, Object> getTreatmentList(Map<String, Object> mapForDs) {
		return opdDataService.getTreatmentList(mapForDs);
	}

	public Map<String, Object> savePhysiotherapyVisitDetails(
			Map<String, Object> mapForDs) {
		return opdDataService.savePhysiotherapyVisitDetails(mapForDs);
	}

	public Map<String, Object> updatePhysiotherapyVisitDetails(
			Map<String, Object> mapForDs) {
		return opdDataService.updatePhysiotherapyVisitDetails(mapForDs);
	}

	public boolean updateCardiologyDepartmentDetails(Map<String, Object> infoMap) {
		return opdDataService.updateCardiologyDepartmentDetails(infoMap);
	}

	public Map<String, Object> updateUrologyCaseSheet(Box box) {
		return opdDataService.updateUrologyCaseSheet(box);
	}

	public Map<String, Object> showPhysiotherapyAttendanceRegisterJsp(
			Map<String, Object> mapForDs) {
		return opdDataService.showPhysiotherapyAttendanceRegisterJsp(mapForDs);
	}

	public Map<String, Object> showDetailsForLabourRoom(
			Map<String, Object> mapForDs) {
		return opdDataService.showDetailsForLabourRoom(mapForDs);
	}

	public boolean submitAllDetailsLabourRoom(Map<String, Object> map) {
		return opdDataService.submitAllDetailsLabourRoom(map);
	}
	/**
	 * -------------------------End of methods for OPD Details Update By
	 */
	public Map<String, Object> showItemSearchJsp(Box box) {
		return opdDataService.showItemSearchJsp(box);
	}

	public Map<String, Object> getPrescriptionList(Map<String, Object> mapForDs) {
		return opdDataService.getPrescriptionList(mapForDs);
	}

	
	public Map<String, Object> getPrescriptionListFAC(Map<String, Object> mapForDs) {
		return opdDataService.getPrescriptionListFAC(mapForDs);
	}
	
	public Map<String, Object> getPrescriptionDetails(
			Map<String, Object> mapForDs) {
		return opdDataService.getPrescriptionDetails(mapForDs);
	}
	
	public Map<String, Object> getPrescriptionDetailsFAC(
			Map<String, Object> mapForDs) {
		return opdDataService.getPrescriptionDetailsFAC(mapForDs);
	}
	
	public Map<String, Object> showPendingPrescriptionJspCorporateFAC(
			Map<String, Object> mapForDs) {
		return opdDataService.showPendingPrescriptionJspCorporateFAC(mapForDs);
	}
	
	public Map<String, Object> getNIPPrescriptionDetails(
			Map<String, Object> mapForDs) {
		return opdDataService.getNIPPrescriptionDetails(mapForDs);
	}
	
	public Map<String, Object> getPrescriptionDetailsForWard(
			Map<String, Object> mapForDs) {
		return opdDataService.getPrescriptionDetailsForWard(mapForDs);
	}
	
	public Map<String, Object> getPrescriptionDetailsForWardPartial(
			Map<String, Object> mapForDs) {
		return opdDataService.getPrescriptionDetailsForWardPartial(mapForDs);
	}
	
	public Map<String, Object> getPartialPrescriptionDetailsForWard(
			Map<String, Object> mapForDs) {
		return opdDataService.getPartialPrescriptionDetailsForWard(mapForDs);
	}

	public Map<String, Object> getPrescriptionDetailList(
			Map<String, Object> dataMap) {
		return opdDataService.getPrescriptionDetailList(dataMap);
	}

	public Map<String, Object> submitPendingPrescriptionDetails(Box box,
			Map<String, Object> dataMap) {
		return opdDataService.submitPendingPrescriptionDetails(box, dataMap);
	}
	public Map<String,Object> updateOpdOpht(Box box){
		return opdDataService.updateOpdOpht(box);
	}
	public Map<String,Object> searchOPHTForUpdateJsp(int visitId){
		return opdDataService.searchOPHTForUpdateJsp(visitId);
	}

	  public List<PatientPrescriptionHeader> getPresVisitNo(String hinNo) {
	  return opdDataService.getPresVisitNo(hinNo);
	 }
	  public List<PatientPrescriptionHeader> getPresVisitNoForNIC(String hinNo) {
		  return opdDataService.getPresVisitNoForNIC(hinNo);
	  }
	  public Map<String , Object> getOpdOphthalmologyFollowUp(int VisitId){
		  return opdDataService.getOpdOphthalmologyFollowUp(VisitId);
	  }

	
	@Override
	public Map<String, Object> showPatientPreviousVisitForHospitality(
			Map<String, Object> mapForDS) {
		return opdDataService.showPatientPreviousVisitForHospitality(mapForDS);
	}

	@Override
	public Map<String, Object> showTreatmentPopUp(Map<String, Object> map) {
		return opdDataService.showTreatmentPopUp(map);	}

	@Override
	public Map<String, Object> showTreatment(Map<String, Object> map) {
		return opdDataService.showTreatment(map);
	}

	@Override
	public Map<String, Object> showSymptomPopUp(Map<String, Object> map) {
	
		return opdDataService.showSymptomPopUp(map);
	}

	@Override
	public Map<String, Object> showDiagnosisPopUp(Map<String, Object> map) {

		return opdDataService.showDiagnosisPopUp(map);
	}

	@Override
	public Map<String, Object> showSymptom(Map<String, Object> map) {
		return opdDataService.showSymptom(map);
	}

	@Override
	public Map<String, Object> showDiagnosis(Map<String, Object> map) {
		return opdDataService.showDiagnosis(map);
	}

	@Override
	public Map<String, Object> getPreviousMedicalBoardDetails(
			Map<String, Object> mapForDS) {
		return opdDataService. getPreviousMedicalBoardDetails(mapForDS);
	}

	@Override
	public Map<String, Object> showPopupTokenJsp(Map<String, Object> mapForDS) {
		return opdDataService.showPopupTokenJsp(mapForDS);
	}

	@Override
	public Map<String, Object> updateVistToken(Map<String, Object> mapForToken) {
		return opdDataService.updateVistToken(mapForToken);
	}

	
	public Map<String, Object> submitDifferentialDiagnosis(String arr[])
	{
		return opdDataService.submitDifferentialDiagnosis(arr);
	}

	@Override
	public Map<String, Object> getDetailsForProcList(Map<String, Object> map) {
		return opdDataService.getDetailsForProcList(map);
	}

	@Override
	public Map<String, Object> saveProcedureDetails(Box box) {
		return opdDataService.saveProcedureDetails(box);
	}

	@Override
	public Map<String, Object> getDetentionDetailsList(Map<String, Object> map) {
		return opdDataService.getDetentionDetailsList(map);
	}

	@Override
	public Map<String, Object> saveDetentionDetails(Box box) {
		return opdDataService.saveDetentionDetails(box);
	}
	@Override
	public Map<String, Object> showSymptomSubPopUp(Map<String, Object> map) {
	
		return opdDataService.showSymptomSubPopUp(map);
		
	}
	@Override
	public Map<String, Object> showSymptomSub(Map<String, Object> map) {
		return opdDataService.showSymptomSub(map);
	}
	@Override
	public Map<String, Object> showHospitalizedDischargeSummaryReport(
			Map<String, Object> mapDetail) {
		return opdDataService.showHospitalizedDischargeSummaryReport(mapDetail);
	}

	@Override
	public Map<String, Object> showPatientPrevoiusPrescriptionRepeat(
			Map<String, Object> mapForDS) {
		return opdDataService.showPatientPrevoiusPrescriptionRepeat(mapForDS);
	}

	@Override
	public Map<String, Object> showPatientPrevoiusInvestigationNew(
			Map<String, Object> mapForDS) {
		return opdDataService.showPatientPrevoiusInvestigationNew(mapForDS);
	}

	@Override
	public Map<String, Object> getDiseaseId(String diseaseWise) {
		return opdDataService.getDiseaseId(diseaseWise);
	}

	@Override
	public Map<String, Object> getHospitalParameterDetails(int hospitalId) {
		return opdDataService.getHospitalParameterDetails(hospitalId);
	}

	@Override
	public Map<String, Object> getListForDisease(Map<String, Object> dataMap) {
		return opdDataService.getListForDisease(dataMap);
	}
	
	public Map<String, Object> showDiseaseWisePatient(
			Map<String, Object> dataMap) {
		return opdDataService.showDiseaseWisePatient(dataMap);
	}

	@Override
	public Map<String, Object> exportDiseaseWisePatient(
			Map<String, Object> dataMap) {
		return opdDataService.exportDiseaseWisePatient(dataMap);
	}

	@Override
	public Map<String, Object> showPhysiotherapyListJsp(Box box) {
		return opdDataService.showPhysiotherapyListJsp(box) ;
	}

	
	public Map<String, Object> getTherapyTypeListForAutoComplete(
			Map<String, Object> generalMap) {
		return opdDataService.getTherapyTypeListForAutoComplete(generalMap);
	}

	@Override
	public Map<String, Object> savePhysiotherapyDetails(Box box) {
		
		return opdDataService.savePhysiotherapyDetails(box);
	}

	@Override
	public Map<String, Object> getTheraphyId(Box box) {
		return opdDataService.getTheraphyId(box);
	}

	@Override
	public Map<String, Object> showAllergyDetailsJsp(Box box) {
		return opdDataService.showAllergyDetailsJsp(box);
	}

	@Override
	public Map<String, Object> getAllergyTypeListForAutoComplete(
			Map<String, Object> generalMap) {
		return opdDataService.getAllergyTypeListForAutoComplete(generalMap);
	}

	@Override
	public Map<String, Object> getAllergyId(Box box) {
		return opdDataService.getAllergyId(box);
	}

	@Override
	public Map<String, Object> saveAllergyDetails(Box box) {
		return opdDataService.saveAllergyDetails(box);
	}

	@Override
	public Map<String, Object> showInvestigationResult(Box box) {
		return opdDataService.showInvestigationResult(box);
	}

	@Override
	public Map<String, Object> calculateIdealWeight(Map<String, Object> dataMap) {
		return opdDataService.calculateIdealWeight(dataMap);
	}

	@Override
	public Map<String, Object> showDiseaseFeatures(Box box) {
		
		return opdDataService.showDiseaseFeatures(box);
	}
	@Override
	public Map<String, Object> getPatientDetailsFordirectVisitEntry(
			String serviceNo) {
		return opdDataService.getPatientDetailsFordirectVisitEntry(serviceNo);
	}

	@Override
	public Map<String, Object> getPatientData(Box box) {
		return opdDataService.getPatientData(box);
	}

	@Override
	public Map<String, Object> showCtJsp(Box box) {
		return opdDataService.showCtJsp(box);
	}

	@Override
	public Map<String, Object> saveCtDetails(Box box) {
		return opdDataService.saveCtDetails(box);
	}

	@Override
	public Map<String, Object> displayAU(Map<String, Object> dataMap) {
		return opdDataService.displayAU(dataMap);
	}

	@Override
	public Map<String, Object> autoCompleteForDiagnosis(Map<String, Object> dataMap) {
		return opdDataService.autoCompleteForDiagnosis(dataMap);
	}

	@Override
	public Map<String, Object> getvisitDetails(Map<String, Object> mapfordata) {
		return opdDataService.getvisitDetails(mapfordata);
	}

	@Override
	public List<DgOrderhd> getInvestigationVisitNo(String hinNo) {
		return opdDataService.getInvestigationVisitNo(hinNo);
	}

	@Override
	public Map<String, Object> checkDuplicateForOtherMedicine(
			Map<String, Object> dataMap) {
		return opdDataService.checkDuplicateForOtherMedicine(dataMap);
	}

	@Override
	public Map<String, Object> showOPDInvestigationRecordsForOpd(
			String investigationTemplateId, int hinId) {
		return opdDataService.showOPDInvestigationRecordsForOpd(investigationTemplateId,hinId);
	}

	@Override
	public Map<String, Object> showOPDInvestigationRecords(
			int investigationTemplateId) {
		return opdDataService.showOPDInvestigationRecords(investigationTemplateId);
	}

	@Override
	public Map<String, Object> showSearchForWaitingPatientListJsp(Map<String, Object> mapForDS) {
		
		return opdDataService.showSearchForWaitingPatientListJsp(mapForDS);
	}

	@Override
	public Map<String, Object> showRelatedMedicineNames(Box box) {
		return opdDataService.showRelatedMedicineNames(box);
	}
	
	@Override
	public Map<String, Object> getConnectionForReportForHIS() {
		return opdDataService.getConnectionForReportForHIS();
	}

	@Override
	public Map<String, Object> showPopUpFamilyHistory(Map<String, Object> dataMap) {
		return opdDataService.showPopUpFamilyHistory(dataMap);
	}
	@Override
	public Map<String, Object> showPatientDirectPrescription(Map<String, Object> mapData) {
		return opdDataService.showPatientDirectPrescription(mapData);
	}
	
	@Override
	public Map<String, Object> showPatientDirectPrescriptionResponse(Map<String, Object> mapData) {
		return opdDataService.showPatientDirectPrescriptionResponse(mapData);
	}
	@Override
	public Map<String, Object> saveDirectPrescription(Map<String, Object> dataMap) {
		return opdDataService.saveDirectPrescription(dataMap);
	}

	@Override
	public int getPatient(String hinNo) {
		return opdDataService.getPatient(hinNo);
	}

	@Override
	public List<Visit> getPresVisitNoForOPD(String hinNo) {
		return opdDataService.getPresVisitNoForOPD(hinNo);
	}

	@Override
	public Map<String, Object> getVisitForPatient(String hinNo, int deptId) {
		return opdDataService.getVisitForPatient(hinNo, deptId);
	}
	
	@Override
	public Map<String, Object> getRecallOpdPatientDetails(Map<String, Object> dataMap) {
		return opdDataService.getRecallOpdPatientDetails(dataMap);
	}
	@Override
	public Map<String, Object> updateRecallOpdPatientDetails(Map<String, Object> dataMap) {
		return opdDataService.updateRecallOpdPatientDetails(dataMap);
	}


	@Override
	public List<PatientPrescriptionHeader> getPresVisitNoForIssueNo(String hinId) {
		return opdDataService.getPresVisitNoForIssueNo(hinId);
	}

	
	@Override
	public Map<String, Object>getOPDPACSCommunication(Map<String, Object> dataMap) {
		return opdDataService.getOPDPACSCommunication(dataMap);
	}
	
	@Override
	public Map<String, Object>sendMessageToRadiology(Map<String, Object> dataMap) {
		return opdDataService.sendMessageToRadiology(dataMap);
	}
	
	@Override
	public Map<String, Object>getRadiologyMessageList(Map<String, Object> dataMap) {
		return opdDataService.getRadiologyMessageList(dataMap);
	}
	
	@Override
	public Map<String, Object>submitRadioResponse(Map<String, Object> dataMap) {
		return opdDataService.submitRadioResponse(dataMap);
	}

	@Override
	public List<PacsPatient> getAllPacsPatients(Map<String, Object> dataMap) {
		return opdDataService.getAllPacsPatients(dataMap);
	}
	
	@Override
	public int getPacsPatientsCount(Map<String, Object> dataMap) {
		return opdDataService.getPacsPatientsCount(dataMap);
	}
	

	@Override
	public Map<String, Object> showProcedureCalenderDoctorWise(Map<String, Object> dataMap) {
		return opdDataService.showProcedureCalenderDoctorWise(dataMap);
	}

	@Override
	public Map<String, Object> getPreviousTherapy(Map<String, Object> dataMap) {
		return opdDataService.getPreviousTherapy(dataMap);
	}

	@Override
	public Map<String, Object> getTherapyWaitingList(Map<String, Object> dataMap) {
		return opdDataService.getTherapyWaitingList(dataMap);
	}

	@Override
	public Map<String, Object> getTherapyDetailsList(Map<String, Object> dataMap) {
		return opdDataService.getTherapyDetailsList(dataMap);
	}
	
	@Override
	public Map<String, Object> saveTherapyDetails(Map<String, Object> dataMap) {
		return opdDataService.saveTherapyDetails(dataMap);
	}

	@Override
	public Map<String, Object> getPreviousTherapyDetails(Map<String, Object> dataMap) {
		return opdDataService.getPreviousTherapyDetails(dataMap);
	}

	@Override
	public Map<String, Object> getDentalProcedureWaitingList(Map<String, Object> dataMap) {
		return opdDataService.getDentalProcedureWaitingList(dataMap);
	}
	
	@Override
	public Map<String, Object> checkForAlreadyPrescibedInvestigation(Map<String, Object> dataMap) {
		return opdDataService.checkForAlreadyPrescibedInvestigation(dataMap);
	}

	
	@Override
	public Map<String, Object> showVaccineDetailJsp(Map<String, Object> dataMap) {
		return opdDataService.showVaccineDetailJsp(dataMap);
	}

	
	
	@Override
	public Map<String, Object> submitVaccineDetail(Map<String, Object> mapForDs) {
		return opdDataService.submitVaccineDetail(mapForDs);
	}
	
	@Override
	public Map<String, Object> submitOBGPatientDetails(Map<String, Object> mapForDs) {
		return opdDataService.submitOBGPatientDetails(mapForDs);
	}
	
	@Override
	public Map<String, Object> showEmpergencyOPDJsp(Map<String, Object> mapForDs) {
		return opdDataService.showEmpergencyOPDJsp(mapForDs);
	}
	
	@Override
	public Map<String, Object> getServiceNoDetailsForRegHAL(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.getServiceNoDetailsForRegHAL(box);
	}
	
	@Override
	public Map<String, Object> showPatientDetailsEmergencyOPD(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return opdDataService.showPatientDetailsEmergencyOPD(mapForDs);
	}
	
	
	
	@Override
	public Map<String, Object> saveEmergencyOPD(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return opdDataService.saveEmergencyOPD(mapForDs);
	}

	
	@Override
	public Map<String, Object> getWaitingEmergencyPatientList(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getWaitingEmergencyPatientList(mapForDS);
	}

	@Override
	public Map<String, Object> getEmergencyRecall(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getEmergencyRecall(mapForDS);
	}
	 
	@Override
	public Map<String, Object> getPhysiotherapyNursingCareWaitingList(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getPhysiotherapyNursingCareWaitingList(mapForDS);
	}
	
	@Override
	public Map<String, Object> getPhysiotherapyDetails(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getPhysiotherapyDetails(mapForDS);
	}
	
	@Override
	public Map<String, Object> getOphthalmolgoyWaitngList(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getOphthalmolgoyWaitngList(mapForDS);
	}
	
	@Override
	public Map<String, Object> showOphthalParameters(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.showOphthalParameters(mapForDS);
	}
	
	@Override
	public Map<String, Object> submitOphthalParameters(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.submitOphthalParameters(mapForDS);
	}

	@Override
	public Map<String, Object> getContradictedItemList(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getContradictedItemList(mapForDS);
	}


	@Override
	public Map<String, Object> getFACWaitingList(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getFACWaitingList(mapForDS);
	}
	

	@Override
	public Map<String, Object> updateFAC(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.updateFAC(mapForDS);
	}

	@Override
	public Map<String, Object> getFacUpdateScreen(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getFacUpdateScreen(mapForDS);
	}

	@Override
	public Map<String, Object> showCIMSPopUp(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.showCIMSPopUp(mapForDS);

	}
	@Override
	public Map<String, Object> getCIMSDetails(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getCIMSDetails(mapForDS);

	}

	@Override
	public Map<String, Object> getNipItemListForAutoComplete(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getNipItemListForAutoComplete(mapForDS);

	}	
	@Override
	public Map<String, Object> getPreviousSurgery(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getPreviousSurgery(mapForDS);

	}	

	@Override
	public  Map<String, Object>getCurrentPrescriptionList(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getCurrentPrescriptionList(mapForDS);

	}	
	@Override
	public  Map<String, Object>getPrescriptionTemplateList(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getPrescriptionTemplateList(mapForDS);

	}	
	@Override
	public  Map<String, Object>getTreatmentListByTemplateId(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getTreatmentListByTemplateId(mapForDS);

	}	
	
	@Override
	public  boolean submitUpdatedTemplate(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.submitUpdatedTemplate(mapForDS);

	}	
	@Override
	public  boolean deleteOpdTemplate(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.deleteOpdTemplate(mapForDS);

	}	
	
/*	public  Map<String, Object> getWaitingReferralPatientList(Map<String, Object> mapForDS) {
		return opdDataService.getWaitingReferralPatientList(mapForDS);

	}	*/

	public  boolean submitUpdatedInvestigationTemplate(Map<String, Object> mapForDS) {
		return opdDataService.submitUpdatedInvestigationTemplate(mapForDS);

	}	

	@Override
	public  Map<String, Object>doVisitRelease(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.doVisitRelease(mapForDS);

	}	
	@Override
	public  Map<String, Object>getPreviousDentalXray(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getPreviousDentalXray(mapForDS);

	}	
	
	@Override
	public  Map<String, Object>getAvailableDoctorList(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getAvailableDoctorList(mapForDS);

	}	

	@Override
	public  Map<String, Object>getPreviousOBGVisit(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getPreviousOBGVisit(mapForDS);

	}	
	@Override
	public  Map<String, Object>getPatientVaccineDetails(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getPatientVaccineDetails(mapForDS);

	}	
	
	@Override
	public  Map<String, Object>submitOPDVaccineDetails(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.submitOPDVaccineDetails(mapForDS);

	}	
	
	@Override
	public  Map<String, Object>updateDeleteNISNIP(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.updateDeleteNISNIP(mapForDS);

	}	
	
	@Override
	public  Map<String, Object>getVaccineReport(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdDataService.getVaccineReport(mapForDS);

	}
	
}
