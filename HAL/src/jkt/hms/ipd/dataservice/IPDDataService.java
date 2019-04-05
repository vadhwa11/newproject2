package jkt.hms.ipd.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.util.Box;

@SuppressWarnings("unchecked")
public interface IPDDataService {

	Map<String, Object> getPatientList(int deptId, int hospitalId);

	Map<String, Object> searchPatient(Map map);

	Map<String, Object> nursingCareSetup(int hin);

	boolean addNursingCare(Map map);
	boolean addDietSetup(Map map);
	Map<String, Object> showFoodTesting(int deptId);

	boolean insertFoodTestingDetails(Map map);

	Map<String, Object> showCaresList();

	Map<String, Object> getPatientListOnBasisOfCare(int careId, int deptId);

	Map<String, Object> searchPatientOnBasisOfCare(Map map);

	boolean submitNursingCareEntryDetails(Map map);

	Map<String, Object> showWardList(String deptName, int deptId);

	Map<String, Object> showWardConsumptionJsp(Map map);

	Map<String, Object> showStockDetailsJsp(Map map);

	boolean submitWardConsumptionDetails(Map map);

	Map<String, Object> modifyWardConsumptionjsp(Map map);

	boolean deleteStockDetails(Map map);

	Map<String, Object> showPatientIssueJsp(Map map);

	boolean submitPatientIssueDetails(Map map);

	Map<String, Object> viewPatientIssueDetails(Map map);

	Map<String, Object> getItemList(Map map);

	Map<String, Object> fillItemsInGrid(Map map);

	Map<String, Object> showPatientDiagnosisJsp(Map map);

	Map<String, Object> getICDList(Map map);

	boolean addPatientDiagnosisInformation(Map map);

	Map<String, Object> showSilDilJsp(Map map);

	boolean submitSilDilStatus(Map map);

	// ---------------------Methods by Dipali------------------------------

	// -------------------------Nursing Clinical
	// Chart---------------------------------
	Map<String, Object> showNursingClinicalChartJsp(int departmentId);

	boolean addNursingClinicalChart(Map<String, Object> dataMap);

	Map getViewClinicalChart(Map<String, Object> dataMap);

	// --------------------------------IntakeOutput-----------------------------------

	Map<String, Object> showIntakeOutputJsp(int inPatient);

	boolean addIntakeOutput(Map<String, Object> map);

	Map getViewIntakeOutput(String radio_str);

	Map<String, Object> showIntakeOutputChartReport(
			Map<String, Object> requestParameters);

	Map<String, Object> getAdmissionNumberList(
			Map<String, Object> requestParameters);

	List<Object> getAdmissionNoList(Map<String, Object> detailsMap);

	// ----------------------------For Reports----------------------

	Map<String, Object> showFoodTastingReportJsp();

	Map<String, Object> showNursingCareReportJsp(Map<String, Object> dataMap);

	List<Object> getHinNoList(String serviceNo);

	String getMothersName(String hinNo);

	List<Object> getHinNo(String serviceNo);

	Map<String, Object> getDBConnection();

	Map<String, Object> getSearchPatientComboDetails(
			Map<String, Object> requestParameters);

	boolean submitWardConsumptionIssueDetails(Map<String, Object> map);

	Map<String, Object> getItemListForWardConsume(Map<String, Object> map);

	Map<String, Object> showDutyNursingReportJsp();

	Map<String, Object> getDiagnosisAndDocumentInit(Map<String, Object> dataMap);

	Map<String, Object> getICDCodeList(Map<String, Object> map);

	Map<String, Object> showWaitingList(Map<String, Object> dataMap);

	Map<String, Object> submitWaitingList(Map<String, Object> dataMap);

	Map<String, Object> getWardRemarksDetails(Map<String, Object> dataMap);

	Map<String, Object> saveWardRemarks(Map<String, Object> dataMap);

	Map<String, Object> getIpIdFormDischargeId(Map<String, Object> tempMap);

	// add by kalyan for patientremarks
	Map<String, Object> getPatientDetails(Map<String, Object> tempMap);

	Map<String, Object> submitPatientRemarks(Map<String, Object> dataMap);

	Map<String, Object> getPatientRemarksDetails(Map<String, Object> dataMap);

	String getdepartmentName(Map<String, Object> dataMap);

	// end

	// -----------------------method added by vikas for button
	// rights---------------

	Map<String, Object> getUserButtonRights(Map<String, Object> dataMap);

	Map<String, Object> getSILDILData(Map<String, Object> dataMap);

	Map<String, Object> showNewNursingCareEntryDetailsJsp(Box box);

	Map<String, Object> showNewNursingClinicalChartJsp(Box box);

	boolean acceptPatientToWard(Box box);

	Map<String, Object> getPatientDetailsForKitIssue(Box box);

	Map<String, Object> getTemplateDetails(Box box);

	Map<String, Object> submitPatientKitIssue(Box box);

	Map<String, Object> showCaseSheetJsp(Box box);

	Map<String, Object> submitIpdCaseSheetDetails(Map<String, Object> dataMap);

	Map<String, Object> getPreviousCaseSheetDetails(Box box);

	Map<String, Object> showMedicineIssueDetailJsp(Box box);

	Map<String, Object> getMedicineDetailList(Box box);
	
	Map<String, Object> showPatientName(Map<String, Object> dataMap);

	Map<String, Object> submitMedicineIssueDetails(Box box);

	Map<String, Object> displayMedicineDetailList(Box box);

	Map<String, Object> showPatientMedicalCaseSheetReportForWard(String hinNO, int hospitalId, String adNo);

	Map<String, Object> showDietSetupJsp(Box box);

	Map<String, Object> getPatientLatestDiagnosisAndDisability(int inpatientId);

	Map<String, Object> showPatientHinNo(Map<String, Object> dataMap);

	String getHinNoForCaseSheet(int hinId, int hospitalId);

	Map<String, Object> deleteDateFromTable(String dateDel, int hinId);

	Map<String, Object> getItemBatchNo(Box box);

	List<StoreItemBatchStock> getBatchExpiryDate(int batchId);

	Map<String, Object> saveDrugConsumptionDetails(Box box);

	Map<String, Object> runIntakeOutputProc(String hinNo, String serviceNo,
			int hospitalId, String admissionNumber);

	Map<String, Object> getItemStock(Box box);

	Map<String, Object> getProcedureForDischargeSummary(
			Map<String, Object> detailsMap);

	Map<String, Object> getTreatmentDetailsForDischargeSummary(
			Map<String, Object> detailsMap);

	Map<String, Object> getPrevCaseNoteDiagnosis(Box box);

	Map<String, Object> getPrevTreatmentDetails(Box box);

	Map<String, Object> showNewCaseSheetJsp(Box box);

	Map<String, Object> getPrevInvestigationDetails(Box box);

	Map<String, Object> getPrevProcedureDetails(Box box);

	Map<String, Object> getPrevDietDetails(Box box);

	Map<String, Object> getPrevPhysiotherapyDetails(Box box);

	void executeProcedureForDMADutyReport(Map<String, Object> parameters);

	Map<String, Object> showSpecialistOpinionJsp(Box box);

	Map<String, Object> submitIpdSplcialistOpinion(Box box);

	Map<String, Object> getSpecialistOpinionDetails(Box box);

	Map<String, Object> viewSpecialistOpinion(Box box);

	Map<String, Object> getPatientListAndNotification(int deptId,
			int hospitalId, int empId);

	Map<String, Object> getReferalList(int hospitalId, int userId);

	Map<String, Object> showHandTakeJsp(Map<String, Object> map);

	String getEntrySeqForDisplay(String string);

	boolean submitHandTakeOver(Box box);

	Map<String, Object> getCareTransferAccepJsp(Box box);

	Map<String, Object> submitcareTransferAcceeptance(Box box);

	Map<String, Object> showSurgeryRequisitionJspForHin(Box box);

	Map<String, Object> submitSurgeryRequisitionDetailsForInpatient(Box box);

	Map<String, Object> checkMappedCharge(Map<String, Object> map);

	Map<String, Object> getItemListForLoanoutByAutocompleteBalance(
			Map<String, Object> dataMap);

	Map<String, Object> showDietEntryDetailsJsp(Box box);

	boolean submitDietEntryDetails(Box box);

	Map<String, Object> getMedicineList(Box box);

	Map<String, Object> getMedicineEntryPage(Box box);

	boolean submitMedicineEntryPage(Box box);

	String getHospitalName(int hospitalId);

	Map<String, Object> showConsultationEntryDetailsJsp(Box box);

	boolean submitConsultaionEntryDetails(Box box);

	Map<String, Object> getPrevConsultationDetails(Box box);

	boolean transferPatientToLaborRoom(Box box);

	boolean transferPatientToOT(Box box);

	Map<String, Object> showPayrollDeductionJournal(Box box);

	Map<String, Object> getTransferHistory(Box box);

	Map<String, Object> getInpatientStatus(Box box);

}
