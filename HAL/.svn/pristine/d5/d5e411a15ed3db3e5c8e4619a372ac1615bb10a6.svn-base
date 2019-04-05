package jkt.hms.opd.dataservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.MasVaccineItem;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.Visit;
import jkt.hms.pacs.controller.PacsPatient;
import jkt.hms.util.Box;

public interface OPDDataService {

	// ------------------------------------------methods writen by
	// vikas----------------------------------

	Map<String, Object> getWaitingPatientList(Map mapForDS);

	Map<String, Object> searchWaitingPatientList(Map mapForDS);

	Map<String, Object> getPatientDetails(int visitId);
	
	boolean getAuthorizationForHighValueMedicine(Map<String, Object> dataMap);
	
	Map<String, Object> getTodayOtherPrescription(Map<String, Object> dataMap);
	
	Map<String, Object> stopCurrentMedication(Map<String, Object> dataMap);
	
	Map<String, Object> checkForAlreadyIssuedPrescription(String itemCode, int hindId,int hospitalId);
	
	Map<String, Object> getBedStatus(int deptId, int hospitalId);
	
	Map<String, Object> checkMappedCharge(Map<String, Object> map);
	
	Map<String, Object> doPatientRelease(Map<String, Object> dataMap);
	
	Map<String, Object> getHospitalDepartment(Map<String, Object> dataMap);
	
	Map<String, Object> getOPNursingCareWaitingList(Map<String, Object> map);
	
	Map<String, Object> getDrugAndProcedureDetails(Map<String, Object> map);
	
	Map<String, Object> getDetailsForProcWaitList(int hospitalId,int visitId, String procedureType);	
	
	Map<String, Object> getItemBatch(Box box);
	
	Map<String, Object> submitNursingCare(Box box);
	
	Map<String, Object> getPendingInjectionList(Box box,Date FromDate,Date ToDate,int hospitalId);
	
	Map<String, Object> getProcedureDetailsForPopUp(Box box);
	
	Map<String, Object> saveNursingCare(Box box);
	
	Map<String, Object> getPatientDetailsForPrescribtion(int visitNo,
			String HinNo);

	Map<String, Object> getICDList(Map map);

	Map<String, Object> uploadAndViewDocuments(Map<String, Object> details);
	
	Map<String, Object> viewPreAnesthesiaDetails(Map<String, Object> details);
	
	Map<String, Object> getOPDDetails(Map mapForDS);

	Map<String, Object> showOPDTreatmentRecords(Map<String, Object> details);

	Map<String, Object> getItemListForAutoComplete(Map mapForDS);

	Map<String, Object> submitOPDPatientDetails(Map mapForDS);
	/*Map<String, Object> submitProPatientDetails(Map mapForDSPro);*/
	Map<String, Object> submitProPatientSicknessDetails(Map mapForDSPro);
	Map<String, Object> submitProPatientRegistrationDetails(Map mapForDSPro);
	Map<String, Object> submitProPatientTreatmentDetails(Map mapForDSPro);
	Map<String, Object> saveDetentionDetails(Box box);
	Map<String, Object> submitOPDPatientDetailsChange(Map mapForDS);

	Map<String, Object> showOPDInvestigationRecords(int investigationTemplateList);

	Map<String, Object> getInvestigationListForAutoComplete(Map mapForDS);

	Map<String, Object> getChargeCodeValue(String chargeCodeName);

	Map<String, Object> getPreviousPatientVisit(Map mapForDS);

	Map<String, Object> viewPreviousVisit(Map mapForDS);

	Map<String, Object> showPatientPrevoiusPrescription(Map mapForDS);

	Map<String, Object> showPatientPrevoiusInvestigation(Map mapForDS);

	Map<String, Object> showSurgeryRequisitionJsp(Map mapForDS);

	Map<String, Object> showAjaxResponseForSurgeryRequisitionJsp(Map mapForDS);

	Map<String, Object> showSurgeryRequisitionJspForHin(Map mapForDS);

	Map<String, Object> submitSurgeryRequisitionDetails(Map mapForDS);

	Map<String, Object> searchPatientDetails(Map mapForDS);

	boolean submitSurgeryRequisitionDetailsForInpatient(Map mapForDS);

	// ------------------------------------------End od methods BY
	// Vikas----------------------------------

	// ----------------------------------------Methods By
	// Ritu--------------------------------------------

	Map<String, Object> submitOphthalmologyDetails(Box box);

	Map<String, Object> getPatientOphthalmologyDetails(
			Map<String, Object> parameterMap);

	Map<String, Object> getFrequencyList();

	Map<String, Object> submitOphthalmologyDiagnosis(Box box);

	Map<String, Object> getOphthalmologyDiagnosisDetails(
			Map<String, Object> parameterMap);

	Map<String, Object> submitOphthalmologyRetinal(Box box);

	Map<String, Object> getOphthalmologyRetinalDetails(
			Map<String, Object> parameterMap);

	Map<String, Object> submitOphthalmologyFollowUp(Box box);

	Map<String, Object> getOphthalmologyFollowUpDetails(
			Map<String, Object> parameterMap);

	// ----------------------------------------End of Methods by
	// Ritu----------------------------------------------

	/**
	 * --------------------------------------------Start of Methods For By
	 * Mansi-------------------------
	 * 
	 */

	// ................................... Patient Allergic Drugs
	// ............................

	Map<String, Object> getPatientAllergicDrugs(int visitId);

	Map<String, Object> fillItemsInGrid(Map<String, Object> dataMap);

	Map<String, Object> getItemList(Map<String, Object> map);

	Map<String, Object> addPatientAllergicDrugs(Map<String, Object> infoMap);

	Map<String, Object> getItem();

	// ................................... Patient History
	// ............................

	Map<String, Object> getPatientHistory(int visitId);

	boolean addPatientHistory(Map<String, Object> infoMap);

	Map<String, Object> viewPatientHistory(Map<String, Object> parameterMap);

	// ................................Pediatric Vaccination Plan
	// .............................

	Map<String, Object> getPediatricVaccinationPlanJsp(int visitId);

	Map<String, Object> addPediatricVaccinationPlan(Box box);

	Map<String, Object> updatePediatricVaccinationPlan(Box box);

	// ................................... Pediatric Case Sheet
	// ............................

	Map<String, Object> getPediatricCaseSheet(int visitId);

	Map<String, Object> addPediatricCaseSheet(Box box);

	Map<String, Object> viewPediatricCaseSheet(Map<String, Object> parameterMap);

	// ................................... OBG .............................

	Map<String, Object> showOBGJsp(int visitId);

	Map<String, Object> addOBGOne(Box box);

	Map<String, Object> updateOBG(Box box);

	Map<String, Object> addOrUpdateOBGJsp(Box box);

	Map<String, Object> viewOBGONE(Map<String, Object> parameterMap);

	Map<String, Object> viewOBGTWO(Map<String, Object> parameterMap);

	Map<String, Object> viewOBGTHREE(Map<String, Object> parameterMap);

	Map<String, Object> viewOBGFOUR(Map<String, Object> parameterMap);

	// ................................... ENT .............................

	Map<String, Object> showENTJsp(int visitId);

	Map<String, Object> addEnt(Box box);

	Map<String, Object> viewEnt(Map<String, Object> parameterMap);

	// ......................................Report...................................

	List<Object> getHinNoList(String serviceNo);

	List<Object> getVisitNoList(Map<String, Object> detailsMap);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> showDailyDepartmentWiseReportJsp();

	Map<String, Object> showDailyOPDInvestigationsReportJsp();

	Map<String, Object> showDailyOPDPrescriptionsReportJsp();

	Map<String, Object> showDailyOPDRankCategoryReportJsp();

	Map<String, Object> viewPatientAllergicDrug(Map<String, Object> parameterMap);

	// -------------------------------- Cardiology Department
	// Details----------------------------

	Map<String, Object> getCardiologyDepartmentDetails(int visitId);

	boolean addCardiologyDepartmentDetails(Map<String, Object> infoMap);

	Map<String, Object> viewCardiologyDepartmentDetails(
			Map<String, Object> parameterMap);

	// -------------------------------- Gastro-Enterology
	// Endoscopy----------------------------

	Map<String, Object> getGastroEnterologyEndoscopy(int visitId);

	boolean addGastroEnterologyEndoscopy(Map<String, Object> infoMap);

	Map<String, Object> viewGastroEnterologyEndoscopy(
			Map<String, Object> parameterMap);

	// -------------------------------- Gastro-Enterology
	// Colonoscopy----------------------------

	Map<String, Object> getGastroEnterologyColonoscopy(int visitId);

	boolean addGastroEnterologyColonoscopy(Map<String, Object> infoMap);

	Map<String, Object> viewGastroEnterologyColonoscopy(
			Map<String, Object> parameterMap);

	// -------------------------------- ANTENATAL
	// CARD----------------------------

	Map<String, Object> getAntenatalCard(int visitId);

	boolean addAntenatalCard(Map<String, Object> infoMap);

	Map<String, Object> viewAntenatalCard(Map<String, Object> parameterMap);

	Map<String, Object> updateAntenatalCard(Box box);

	Map<String, Object> getAntenatalCardEdit(int aId, int visitId);

	Map<String, Object> getGravidagramHTN(int visitId);

	boolean addGravidagramHTN(Map<String, Object> infoMap);

	Map<String, Object> viewGravidagramHTN(Map<String, Object> parameterMap);

	Map<String, Object> getGravidagramGestationalDiabitiesOne(int visitId);

	boolean addGravidagramGestationalDiabitiesOne(Map<String, Object> infoMap);

	Map<String, Object> viewGravidagramGestationalDiabitiesOne(
			Map<String, Object> parameterMap);

	Map<String, Object> getGravidagramGestationalDiabitiesTwo(int visitId);

	boolean addGravidagramGestationalDiabitiesTwo(Map<String, Object> infoMap);

	Map<String, Object> viewGravidagramGestationalDiabitiesTwo(
			Map<String, Object> parameterMap);

	/**
	 * --------------------------------------------End of Methods For By
	 * Mansi-------------------------
	 * 
	 */

	String generateOrderNumber(int hospitalId);

	Map<String, Object> addOncosurgeryCaseSheet(Box box);

	Map<String, Object> showOncosurgeryCaseSheetJsp(int visitId);

	Map<String, Object> viewOncosurgeryCaseSheet(
			Map<String, Object> parameterMap);

	Map<String, Object> addUrologyCaseSheet(Box box);

	Map<String, Object> showUrologyCaseSheetJsp(int visitId);

	Map<String, Object> viewUrologyCaseSheet(Map<String, Object> parameterMap);

	Map<String, Object> showOncosurgeryJsp(int visitId);

	Map<String, Object> addOncosurgery(Box box);

	Map<String, Object> viewOncosurgery(Map<String, Object> parameterMap);

	Map<String, Object> showPatientPreviousHinNumber(
			Map<String, Object> mapForDS);

	Map<String, Object> getDepartmentNameFromId(int departmentId);

	Map<String, Object> viewPreviousNextVisit(Map<String, Object> mapForDS);

	Map<String, Object> getOpdTemplateDepartmentWise(int visitId);

	boolean addOpdTemplateDepartmentWise(Map<String, Object> infoMap);

	Map<String, Object> viewOpdTemplateDepartmentWise(
			Map<String, Object> parameterMap);

	Map<String, Object> viewOpdTemplateDepartmentWisePreNext(
			Map<String, Object> parameterMap);

	/** methods by abha **/
	public Map<String, Object> viewGynaecology(Map<String, Object> parameterMap);

	boolean submitSocioEconomicHistory(Map<String, Object> map);

	boolean submitComplaints(Map<String, Object> map);

	boolean submitMedicalSurgicalHistory(Map<String, Object> map);

	boolean submitGeneralExaminaton(Map<String, Object> map);

	boolean submitSystemicExamination(Map<String, Object> map);

	Map<String, Object> showUploadingDocumentsJsp(int visitId, int inpatientId,Map<String, Object> mapForDS);

	Map<String, Object> submitUploadDocuments(Box box);

	Map<String, Object> viewPatientDetails(Map<String, Object> map);

	Map<String, Object> getPsychiatristQuestionnaire(Map<String, Object> mapForDS);
	
	Map<String, Object> getPsychiatristQaHeading(Map<String, Object> mapForDS);
	
	Map<String, Object> submitPsychiatristQuestionnaire(Map<String, Object> mapForDS);
		
	Map<String, Object> checkItem(Map<String, Object> dataMap);

	public List<Patient> getPatientNameForUpadteOpdDetails(
			Map<String, Object> map);

	@SuppressWarnings("unchecked")
	public List<Visit> getVisitNo(int hinId);

	Map<String, Object> getSurListForAutoComplete(Map<String, Object> map);

	Map<String, Object> getPatientOpdDetails(Map<String, Object> dataMap);

	public Map<String, Object> getOPDDetailsForOpdUpdate(Map mapForDS);

	boolean finalUpdateOpdPatientDetails(Map<String, Object> mapForDS);

	Map<String, Object> responseForDoctarsList(Map mapForDS);

	Map<String, Object> showOpdFrequencyJsp();

	boolean addInvestigationTemplate(Map mapForDS);

	Map<String, Object> getListForTreatment(Map<String, Object> mapForDs);

	boolean addPrescriptionTemplate(Map mapForDS);

	Map<String, Object> showOPDTemplateRecords(Map<String, Object> mapForDS);

	Map<String, Object> getInvestigationListForAutoCompleteSurgery(Map mapForDS);

	/**
	 * -------------------------Start of methods for OPD Details Update By
	 * Naresh----------------------------
	 */

	Map<String, Object> showOrderBookingForInvestigationJsp(
			Map<String, Object> mapForDs);

	String getOrderSeqForDisplay(String string);

	Map<String, Object> getMainAndSubCharge();

	Map<String, Object> submitOrderBookingForInvestigation(
			Map<String, Object> infoMap);

	Map<String, Object> submitSampleCollection(Map<String, Object> parameterMap);

	Map<String, Object> searchENTForUpdateJsp(int visitId);

	Map<String, Object> updateEnt(Box box);

	Map<String, Object> searchPediatricForUpdate(int visitId);

	Map<String, Object> updatePediatricCaseSheet(Box box);

	Map<String, Object> getDetailsForVisit();

	Map<String, Object> getPatientDetails(Map<String, Object> mapForDs);

	int getTokenNoForDepartment(int departmentId);

	Map<String, Object> getVisitDetails();

	Map<String, Object> getTreatmentList(Map<String, Object> mapForDs);

	Map<String, Object> savePhysiotherapyVisitDetails(
			Map<String, Object> mapForDs);

	Map<String, Object> updatePhysiotherapyVisitDetails(
			Map<String, Object> mapForDs);

	boolean updateCardiologyDepartmentDetails(Map<String, Object> infoMap);

	Map<String, Object> updateUrologyCaseSheet(Box box);

	Map<String, Object> showPhysiotherapyAttendanceRegisterJsp(
			Map<String, Object> mapForDs);

	Map<String, Object> showDetailsForLabourRoom(Map<String, Object> mapForDs);

	boolean submitAllDetailsLabourRoom(Map<String, Object> map);
	
	Map<String,Object> showItemSearchJsp(Box box) ;
	
	public Map<String, Object> getPrescriptionList(Map<String, Object> mapForDs);
	public Map<String, Object> getPrescriptionDetails(Map<String, Object> mapForDs);
	public Map<String, Object> getPrescriptionDetailList(Map<String, Object> dataMap);
	public Map<String, Object> submitPendingPrescriptionDetails(Box box,
			Map<String, Object> dataMap);
	public Map<String,Object> updateOpdOpht(Box box);
	public Map<String,Object> searchOPHTForUpdateJsp(int visitId);
	public Map<String , Object> getOpdOphthalmology(int VisitId);  
	List<PatientPrescriptionHeader> getPresVisitNo(String hinNo);
	List<PatientPrescriptionHeader> getPresVisitNoForNIC(String hinNo);
	public Map<String , Object> getOpdOphthalmologyFollowUp(int VisitId);

	Map<String, Object> showTreatmentPopUp(Map<String, Object> map);

	Map<String, Object> showPopUpFamilyHistory(Map<String, Object> dataMap);
	Map<String, Object> showPatientPreviousVisitForHospitality(
			Map<String, Object> mapForDS);

	Map<String, Object> showTreatment(Map<String, Object> map);

	Map<String, Object> showSymptomPopUp(Map<String, Object> map);

	Map<String, Object> showDiagnosisPopUp(Map<String, Object> map);

	Map<String, Object> showSymptom(Map<String, Object> map);

	Map<String, Object> showDiagnosis(Map<String, Object> map);

	Map<String, Object> getPreviousMedicalBoardDetails(
			Map<String, Object> mapForDS);

	Map<String, Object> showPopupTokenJsp(Map<String, Object> mapForDS);

	Map<String, Object> updateVistToken(Map<String, Object> mapForToken);
	Map<String, Object> submitDifferentialDiagnosis(String arr[]);

	Map<String, Object> getDetailsForProcList(Map<String, Object> map);

	Map<String, Object> saveProcedureDetails(Box box);

	Map<String, Object> getDetentionDetailsList(Map<String, Object> map);


	Map<String, Object> showSymptomSubPopUp(Map<String, Object> map);
	Map<String, Object> showSymptomSub(Map<String, Object> map);


	Map<String, Object> showHospitalizedDischargeSummaryReport(
			Map<String, Object> mapDetail);

	Map<String, Object> showPatientPrevoiusPrescriptionRepeat(
			Map<String, Object> mapForDS);

	Map<String, Object> showPatientPrevoiusInvestigationNew(
			Map<String, Object> mapForDS);

	Map<String, Object> getHospitalParameterDetails(int hospitalId);

	Map<String, Object> getDiseaseId(String diseaseWise);

	Map<String, Object> getListForDisease(Map<String, Object> dataMap);

	Map<String, Object> showDiseaseWisePatient(Map<String, Object> dataMap);

	Map<String, Object> exportDiseaseWisePatient(Map<String, Object> dataMap);

	Map<String, Object> showPhysiotherapyListJsp(Box box);

	Map<String, Object> getTherapyTypeListForAutoComplete(
			Map<String, Object> generalMap);

	Map<String, Object> savePhysiotherapyDetails(Box box);

	Map<String, Object> getTheraphyId(Box box);

	Map<String, Object> showAllergyDetailsJsp(Box box);

	Map<String, Object> getAllergyTypeListForAutoComplete(
			Map<String, Object> generalMap);

	Map<String, Object> getAllergyId(Box box);

	Map<String, Object> saveAllergyDetails(Box box);

	Map<String, Object> showInvestigationResult(Box box);

	Map<String, Object> calculateIdealWeight(Map<String, Object> dataMap);

	Map<String, Object> showDiseaseFeatures(Box box);

	Map<String, Object> getPatientDetailsFordirectVisitEntry(String serviceNo);

	Map<String, Object> getPatientData(Box box);

	Map<String, Object> showCtJsp(Box box);

	Map<String, Object> saveCtDetails(Box box);

	Map<String, Object> displayAU(Map<String, Object> dataMap);

	Map<String, Object> autoCompleteForDiagnosis(Map<String, Object> dataMap);

	Map<String, Object> getvisitDetails(Map<String, Object> mapfordata);

	List<DgOrderhd> getInvestigationVisitNo(String hinNo);

	Map<String, Object> checkDuplicateForOtherMedicine(
			Map<String, Object> dataMap);

	Map<String, Object> showOPDInvestigationRecordsForOpd(
			String investigationTemplateId,int hinId);

	Map<String, Object> showSearchForWaitingPatientListJsp(
			Map<String, Object> mapForDS);

	Map<String, Object> showRelatedMedicineNames(Box box);
	
	Map<String, Object> getConnectionForReportForHIS();
	Map<String, Object> showPatientDirectPrescription(Map<String, Object> mapData);
	Map<String, Object> saveDirectPrescription(Map<String, Object> dataMap);

	Map<String, Object> getHospitalWards(Map<String, Object> map);

	Map<String, Object> getPrescriptionDetailsForWard(
			Map<String, Object> mapForDs);
	
	int getPatient(String hinNo);

	List<Visit> getPresVisitNoForOPD(String hinNo);

	Map<String, Object> getPartialPrescriptionDetailsForWard(
			Map<String, Object> mapForDs);
	
	Map<String, Object> getVisitForPatient(String hinNo, int visitId);
	Map<String, Object> getRecallOpdPatientDetails(Map<String, Object> map);
	Map<String, Object> updateRecallOpdPatientDetails(Map<String, Object> map);

	Map<String, Object> getNIPPrescriptionDetails(Map<String, Object> mapForDs);

	Map<String, Object> getTodayOtherPrescriptionForIPD(int hinId);
	
	List<PatientPrescriptionHeader> getPresVisitNoForIssueNo(String hinNo);
	
	Map<String, Object> getOPDPACSCommunication(Map<String, Object> mapForDs);
	
	Map<String, Object> sendMessageToRadiology(Map<String, Object> mapForDs);	
	
	Map<String, Object> getRadiologyMessageList(Map<String, Object> mapForDs);
	
	Map<String, Object> submitRadioResponse(Map<String, Object> mapForDs);
	
	public List<PacsPatient> getAllPacsPatients(Map<String, Object> map);
	
	public int getPacsPatientsCount(Map<String, Object> map);

	Map<String, Object> getPrescriptionDetailsFAC(Map<String, Object> mapForDs);

	Map<String, Object> getPrescriptionListFAC(Map<String, Object> mapForDs);
	
	Map<String, Object> showProcedureCalenderDoctorWise(Map<String, Object> mapForDs); 

	Map<String, Object> getPreviousTherapy(Map<String, Object> mapForDs);
	
	Map<String, Object> getTherapyWaitingList(Map<String, Object> mapForDs);

	Map<String, Object> getTherapyDetailsList(Map<String, Object> mapForDs);
	Map<String, Object> saveTherapyDetails(Map<String, Object> mapForDs);
	
	Map<String, Object> getPreviousTherapyDetails(Map<String, Object> mapForDs);
	
	Map<String, Object> getDentalProcedureWaitingList(Map<String, Object> mapForDs);

	Map<String, Object> checkForAlreadyPrescibedInvestigation(Map<String, Object> mapForDs);
	
	Map<String, Object> showVaccineDetailJsp(Map<String, Object> mapForDs);

	
	Map<String, Object> submitVaccineDetail(Map<String, Object> mapForDs);

	Map<String, Object> getPrescriptionDetailsForWardPartial(
			Map<String, Object> mapForDs);
	
	Map<String, Object> submitOBGPatientDetails(Map<String, Object> mapForDs);
			
	Map<String, Object> showEmpergencyOPDJsp(Map<String, Object> mapForDs);
	
	Map<String, Object> getServiceNoDetailsForRegHAL(Box box);
	Map<String, Object> showPatientDetailsEmergencyOPD(Map<String, Object> mapForDs);
	
	Map<String, Object> saveEmergencyOPD(Map<String, Object> dataMap);

	Map<String, Object> getWaitingEmergencyPatientList(Map<String, Object> mapForDS);
	
	Map<String, Object> getEmergencyRecall(Map<String, Object> mapForDS);
	
	Map<String, Object> getPhysiotherapyNursingCareWaitingList(Map<String, Object> map);
	
	Map<String, Object> getPhysiotherapyDetails(Map<String, Object> map);

	Map<String, Object> showPatientDirectPrescriptionResponse(
			Map<String, Object> mapData);
	
	Map<String, Object> getOphthalmolgoyWaitngList(Map<String, Object> map);
	
	Map<String, Object> showOphthalParameters(Map<String, Object> map);
	
	Map<String, Object> submitOphthalParameters(Map<String, Object> map);
	
	Map<String, Object> getContradictedItemList(Map<String, Object> map);
	
	Map<String, Object> getFACWaitingList(Map<String, Object> map);
	
	Map<String, Object> getFacUpdateScreen(Map<String, Object> map);
	
	Map<String, Object> updateFAC(Map<String, Object> map);
	
	Map<String, Object> showCIMSPopUp(Map<String, Object> map);
	
	Map<String, Object> getCIMSDetails(Map<String, Object> map);
	
	Map<String, Object> getNipItemListForAutoComplete(Map<String, Object> map);
	
	Map<String, Object> getPreviousSurgery(Map<String, Object> map);
	
	Map<String, Object> getCurrentPrescriptionList(Map<String, Object> map);
	
	Map<String, Object> getPrescriptionTemplateList(Map<String, Object> map);
	
	Map<String, Object> getTreatmentListByTemplateId(Map<String, Object> map);
	
	boolean submitUpdatedTemplate(Map<String, Object> map);
	
	boolean deleteOpdTemplate(Map<String, Object> map);
	
/*	Map<String, Object> getWaitingReferralPatientList(Map<String, Object> map);*/
	
	boolean submitUpdatedInvestigationTemplate(Map<String, Object> map);

	Map<String, Object> doVisitRelease(Map<String, Object> dataMap);

	Map<String, Object> getPreviousDentalXray(Map<String, Object> mapForDS);
	
	Map<String, Object> getAvailableDoctorList(Map<String, Object> mapForDS);

	Map<String, Object> getPreviousOBGVisit(Map<String, Object>  mapForDS);
	
	Map<String, Object> getPatientVaccineDetails(Map mapForDS);

	Map<String, Object> submitOPDVaccineDetails(Map<String, Object>  mapForDS);
	
	Map<String, Object> updateDeleteNISNIP(Map<String, Object>  mapForDS);
	
	Map<String, Object> getVaccineReport(Map<String, Object>  mapForDS);

	Map<String, Object> showPendingPrescriptionJspCorporateFAC(Map<String, Object> mapForDs);
}

