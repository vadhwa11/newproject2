package jkt.hms.ipd.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.ipd.dataservice.IPDDataService;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.util.Box;

public class IPDHandlerServiceImpl implements IPDHandlerService {

	IPDDataService ipdDataService = null;

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPatient(Map map) {
		return ipdDataService.searchPatient(map);
	}

	public Map<String, Object> nursingCareSetup(int hin) {
		return ipdDataService.nursingCareSetup(hin);
	}

	@SuppressWarnings("unchecked")
	public boolean addNursingCare(Map map) {
		return ipdDataService.addNursingCare(map);
	}
    public boolean addDietSetup(Map map){
    	return ipdDataService.addDietSetup(map);
    }
	public Map<String, Object> showFoodTesting(int deptId) {
		return ipdDataService.showFoodTesting(deptId);
	}

	@SuppressWarnings("unchecked")
	public boolean insertFoodTestingDetails(Map map) {
		return ipdDataService.insertFoodTestingDetails(map);
	}

	public Map<String, Object> showCaresList() {
		return ipdDataService.showCaresList();
	}

	public Map<String, Object> getPatientListOnBasisOfCare(int careId,
			int deptId) {
		return ipdDataService.getPatientListOnBasisOfCare(careId, deptId);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPatientOnBasisOfCare(Map map) {
		return ipdDataService.searchPatientOnBasisOfCare(map);
	}

	@SuppressWarnings("unchecked")
	public boolean submitNursingCareEntryDetails(Map map) {

		return ipdDataService.submitNursingCareEntryDetails(map);
	}


	@SuppressWarnings("unchecked")
	public boolean submitDietEntryDetails(Box box) {

		return ipdDataService.submitDietEntryDetails(box);
	}
	
	@SuppressWarnings("unchecked")
	public boolean submitConsultaionEntryDetails(Box box) {

		return ipdDataService.submitConsultaionEntryDetails(box);
	}
	
	@SuppressWarnings("unchecked")
	public boolean submitMedicineEntryPage(Box box) {

		return ipdDataService.submitMedicineEntryPage(box);
	}
	
	/*
	 * list of ward/department (non-Javadoc)
	 * 
	 * @see jkt.hms.ipd.handler.IPDHandlerService#showWardList()
	 */

	public Map<String, Object> showWardList(String deptName, int deptId) {
		return ipdDataService.showWardList(deptName, deptId);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showWardConsumptionJsp(Map map) {
		return ipdDataService.showWardConsumptionJsp(map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStockDetailsJsp(Map map) {
		return ipdDataService.showStockDetailsJsp(map);
	}

	@SuppressWarnings("unchecked")
	public boolean submitWardConsumptionDetails(Map map) {
		return ipdDataService.submitWardConsumptionDetails(map);
	}

	public Map<String, Object> modifyWardConsumptionJsp(Map map) {
		return ipdDataService.modifyWardConsumptionjsp(map);
	}

	public boolean deleteStockDetails(Map map) {
		return ipdDataService.deleteStockDetails(map);
	}

	public Map<String, Object> showPatientIssueJsp(Map map) {
		return ipdDataService.showPatientIssueJsp(map);
	}

	public boolean submitPatientIssueDetails(Map map) {
		return ipdDataService.submitPatientIssueDetails(map);
	}

	public Map<String, Object> viewPatientIssueDetails(Map map) {
		return ipdDataService.viewPatientIssueDetails(map);
	}

	public Map<String, Object> getItemList(Map map) {
		return ipdDataService.getItemList(map);
	}

	public Map<String, Object> fillItemsInGrid(Map map) {
		return ipdDataService.fillItemsInGrid(map);
	}

	public Map<String, Object> showPatientDiagnosisJsp(Map map) {
		return ipdDataService.showPatientDiagnosisJsp(map);
	}

	public Map<String, Object> getICDList(Map map) {
		return ipdDataService.getICDList(map);
	}

	public boolean addPatientDiagnosisInformation(Map map) {
		return ipdDataService.addPatientDiagnosisInformation(map);
	}

	public Map<String, Object> showSilDilJsp(Map map) {
		return ipdDataService.showSilDilJsp(map);
	}

	public boolean submitSilDilStatus(Map map) {
		return ipdDataService.submitSilDilStatus(map);
	}

	// -----------------------------Clinical
	// Chart--------------------------------------
	public Map<String, Object> showNursingClinicalChartJsp(int departmentId) {
		return ipdDataService.showNursingClinicalChartJsp(departmentId);
	}

	public boolean addNursingClinicalChart(Map<String, Object> dataMap) {
		return ipdDataService.addNursingClinicalChart(dataMap);
	}

	public Map getViewClinicalChart(Map<String, Object> dataMap) {
		return ipdDataService.getViewClinicalChart(dataMap);
	}

	// ---------------------------Intake Output
	// Chart--------------------------------------
	public Map<String, Object> showIntakeOutputJsp(int inPatient) {
		return ipdDataService.showIntakeOutputJsp(inPatient);
	}

	public boolean addIntakeOutput(Map<String, Object> map) {
		return ipdDataService.addIntakeOutput(map);
	}

	@SuppressWarnings("unchecked")
	public Map getViewIntakeOutput(String radio_str) {
		return ipdDataService.getViewIntakeOutput(radio_str);
	}

	public Map<String, Object> showIntakeOutputChartReport(
			Map<String, Object> requestParameters) {
		return ipdDataService.showIntakeOutputChartReport(requestParameters);
	}

	public Map<String, Object> getAdmissionNumberList(
			Map<String, Object> requestParameters) {
		return ipdDataService.getAdmissionNumberList(requestParameters);
	}

	public List<Object> getAdmissionNoList(Map<String, Object> detailsMap) {
		return ipdDataService.getAdmissionNoList(detailsMap);
	}

	// -----------------------------------Reports---------------------------------
	public Map<String, Object> showFoodTastingReportJsp() {
		return ipdDataService.showFoodTastingReportJsp();
	}

	public Map<String, Object> showNursingCareReportJsp(
			Map<String, Object> dataMap) {
		return ipdDataService.showNursingCareReportJsp(dataMap);
	}

	public String getMothersName(String hinNo) {
		return ipdDataService.getMothersName(hinNo);
	}

	public List<Object> getHinNo(String serviceNo) {
		return ipdDataService.getHinNo(serviceNo);
	}

	public List<Object> getHinNoList(String serviceNo) {
		return ipdDataService.getHinNoList(serviceNo);
	}

	public Map<String, Object> getSearchPatientComboDetails(
			Map<String, Object> requestParameters) {
		return ipdDataService.getSearchPatientComboDetails(requestParameters);
	}

	// ---------------------------------------------------------------------------------------------------------
	public Map<String, Object> getDBConnection() {
		return ipdDataService.getDBConnection();
	}

	public void setIpdDataService(IPDDataService ipdDataService) {
		this.ipdDataService = ipdDataService;
	}

	public Map<String, Object> getPatientList(int deptId, int hospitalId) {
		return ipdDataService.getPatientList(deptId, hospitalId);
	}

	public Map<String, Object> getPatientListAndNotification(int deptId, int hospitalId, Integer empId) {
		return ipdDataService.getPatientListAndNotification(deptId, hospitalId, empId);
	}
	
	@Override
	public Map<String, Object> showHandTakeJsp(Map<String, Object> map) {
		return ipdDataService.showHandTakeJsp(map);
	}
	
	@Override
	public String getEntrySeqForDisplay(String string) {
		return ipdDataService.getEntrySeqForDisplay(string);
	}
	
	@Override
	public boolean submitHandTakeOver(Box box) {
		return ipdDataService.submitHandTakeOver(box);
	}
	
	@Override
	public Map<String, Object>  getCareTransferAccepJsp(Box box)
	{
		return ipdDataService.getCareTransferAccepJsp(box);
	}
	
	@Override
	public Map<String, Object>  submitcareTransferAcceeptance(Box box)
	{
		return ipdDataService.submitcareTransferAcceeptance(box);
	}
	
	
	@Override
	public Map<String, Object>showSurgeryRequisitionJspForHin(Box box)
	{
		return ipdDataService.showSurgeryRequisitionJspForHin(box);
	}
	
	@Override
	public Map<String, Object>submitSurgeryRequisitionDetailsForInpatient(Box box)
	{
		return ipdDataService.submitSurgeryRequisitionDetailsForInpatient(box);
	}
	
	@Override
	public Map<String, Object>checkMappedCharge(Map<String, Object> map)
	{
		return ipdDataService.checkMappedCharge(map);
	}
	
	@Override
	public Map<String, Object> getInpatientStatus(Box box) {
		return ipdDataService.getInpatientStatus(box);
	}
	
	@Override
	public Map<String, Object> getReferalList(int hospitalId, int userId) {
		return ipdDataService.getReferalList( hospitalId,  userId);
	}
	
	public Map<String, Object> getItemListForLoanoutByAutocompleteBalance(
			Map<String, Object> dataMap) {
		return ipdDataService.getItemListForLoanoutByAutocompleteBalance(dataMap);
	}
	
	
	public boolean submitWardConsumptionIssueDetails(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ipdDataService.submitWardConsumptionIssueDetails(map);
	}

	public Map<String, Object> getItemListForWardConsume(Map<String, Object> map) {
		return ipdDataService.getItemListForWardConsume(map);
	}

	public Map<String, Object> showDutyNursingReportJsp() {
		return ipdDataService.showDutyNursingReportJsp();
	}

	public Map<String, Object> getDiagnosisAndDocumentInit(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return ipdDataService.getDiagnosisAndDocumentInit(dataMap);
	}

	public Map<String, Object> getICDCodeList(Map<String, Object> map) {
		return ipdDataService.getICDCodeList(map);
	}

	public Map<String, Object> showWaitingList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return ipdDataService.showWaitingList(dataMap);
	}

	public Map<String, Object> submitWaitingList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return ipdDataService.submitWaitingList(dataMap);
	}

	public Map<String, Object> getWardRemarksDetails(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return ipdDataService.getWardRemarksDetails(dataMap);
	}

	public Map<String, Object> saveWardRemarks(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return ipdDataService.saveWardRemarks(dataMap);
	}

	public Map<String, Object> getIpIdFormDischargeId(
			Map<String, Object> tempMap) {
		// TODO Auto-generated method stub
		return ipdDataService.getIpIdFormDischargeId(tempMap);
	}

	public Map<String, Object> getPatientDetails(Map<String, Object> tempMap) {
		// TODO Auto-generated method stub
		return ipdDataService.getPatientDetails(tempMap);
	}

	public Map<String, Object> submitPatientRemarks(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return ipdDataService.submitPatientRemarks(dataMap);
	}

	public Map<String, Object> getPatientRemarksDetails(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return ipdDataService.getPatientRemarksDetails(dataMap);
	}

	public String getdepartmentName(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return ipdDataService.getdepartmentName(dataMap);
	}

	// -------------method added by vikas for button rights------

	public Map<String, Object> getUserButtonRights(Map<String, Object> dataMap) {
		return ipdDataService.getUserButtonRights(dataMap);
	}

	public Map<String, Object> getSILDILData(Map<String, Object> dataMap) {
		return ipdDataService.getSILDILData(dataMap);
	}

	@Override
	public Map<String, Object> showNewNursingCareEntryDetailsJsp(Box box) {
		return ipdDataService.showNewNursingCareEntryDetailsJsp(box);
	}
	
	@Override
	public Map<String, Object> showDietEntryDetailsJsp(Box box) {
		return ipdDataService.showDietEntryDetailsJsp(box);
	}
	
	@Override
	public Map<String, Object> showConsultationEntryDetailsJsp(Box box) {
		return ipdDataService.showConsultationEntryDetailsJsp(box);
	}
	
//------
	@Override
	public Map<String, Object> showNewNursingClinicalChartJsp(Box box) {
		return ipdDataService.showNewNursingClinicalChartJsp(box);
	}

	@Override
	public boolean acceptPatientToWard(Box box) {
		return ipdDataService.acceptPatientToWard(box);
	}
	
	@Override
	public boolean transferPatientToLaborRoom(Box box) {
		return ipdDataService.transferPatientToLaborRoom(box);
	}
	
	@Override
	public boolean transferPatientToOT(Box box) {
		return ipdDataService.transferPatientToOT(box);
	}

	@Override
	public Map<String, Object> getPatientDetailsForKitIssue(Box box) {
		return ipdDataService.getPatientDetailsForKitIssue(box);
	}

	@Override
	public Map<String, Object> getTemplateDetails(Box box) {
		return ipdDataService.getTemplateDetails(box);
	}

	@Override
	public Map<String, Object> submitPatientKitIssue(Box box) {
		return ipdDataService.submitPatientKitIssue(box) ;
	}

	@Override
	public Map<String, Object> showCaseSheetJsp(Box box) {
		return ipdDataService.showCaseSheetJsp(box);
	}

	@Override
	public Map<String, Object> submitIpdCaseSheetDetails(Map<String, Object> dataMap) {
		return ipdDataService.submitIpdCaseSheetDetails(dataMap);
	}

	@Override
	public Map<String, Object> getPreviousCaseSheetDetails(Box box) {
		return ipdDataService.getPreviousCaseSheetDetails(box);
	}

	@Override
	public Map<String, Object> showMedicineIssueDetailJsp(Box box) {
		
		return ipdDataService.showMedicineIssueDetailJsp(box);
	}

	@Override
	public Map<String, Object> getMedicineDetailList(Box box) {
		
		return ipdDataService.getMedicineDetailList(box);
	}
	
	@Override
	public Map<String, Object> showPatientName(Map<String, Object> dataMap) {
		
		return ipdDataService.showPatientName(dataMap);
	}

	@Override
	public Map<String, Object> submitMedicineIssueDetails(Box box) {
		
		return ipdDataService.submitMedicineIssueDetails(box);
	}

	@Override
	public Map<String, Object> displayMedicineDetailList(Box box) {
		
		return ipdDataService.displayMedicineDetailList(box);
	}

	@Override
	public Map<String, Object> showPatientMedicalCaseSheetReportForWard(
			String hinNO,int hospitalId,String adNo) {
		return ipdDataService.showPatientMedicalCaseSheetReportForWard(hinNO,hospitalId,adNo);
	}

	@Override
	public Map<String, Object> showDietSetupJsp(Box box) {
		return ipdDataService.showDietSetupJsp(box);
	}

	@Override
	public Map<String, Object> getPatientLatestDiagnosisAndDisability(int inpatientId) {
		return ipdDataService.getPatientLatestDiagnosisAndDisability(inpatientId);
	}

	@Override
	public Map<String, Object> showPatientHinNo(Map<String, Object> dataMap) {
		return ipdDataService.showPatientHinNo(dataMap);
	}

	@Override
	public String getHinNoForCaseSheet(int hinId,int hospitalId) {
		return ipdDataService.getHinNoForCaseSheet(hinId,hospitalId);
	}

	@Override
	public Map<String, Object> deleteDateFromTable(String dateDel, int hinId) {
		return ipdDataService.deleteDateFromTable(dateDel,hinId);
	}

	@Override
	public Map<String, Object> getItemBatchNo(Box box) {
		return ipdDataService.getItemBatchNo(box);
	}

	@Override
	public List<StoreItemBatchStock> getBatchExpiryDate(int batchId) {
		return ipdDataService.getBatchExpiryDate(batchId);
	}

	@Override
	public Map<String, Object> saveDrugConsumptionDetails(Box box) {
		return ipdDataService.saveDrugConsumptionDetails(box);
	}
	
	@Override
	public Map<String, Object> showPayrollDeductionJournal(Box box) {
		return ipdDataService.showPayrollDeductionJournal(box);
	}

	@Override
	public Map<String, Object> runIntakeOutputProc(String hinNo,
			String serviceNo, int hospitalId, String admissionNumber) {
		return ipdDataService.runIntakeOutputProc(hinNo,serviceNo,hospitalId,admissionNumber);
	}

	@Override
	public Map<String, Object> getItemStock(Box box) {
		return ipdDataService.getItemStock(box);
	}

	@Override
	public Map<String, Object> getProcedureForDischargeSummary(Map<String, Object> detailsMap) {
		return ipdDataService.getProcedureForDischargeSummary(detailsMap);
	}

	@Override
	public Map<String, Object> getTreatmentDetailsForDischargeSummary(Map<String, Object> detailsMap) {
		return ipdDataService.getTreatmentDetailsForDischargeSummary(detailsMap) ;
	}

	@Override
	public Map<String, Object> getPrevCaseNoteDiagnosis(Box box) {
		return ipdDataService.getPrevCaseNoteDiagnosis(box);
	}

	@Override
	public Map<String, Object> getPrevTreatmentDetails(Box box) {
		return ipdDataService.getPrevTreatmentDetails(box);
	}

	@Override
	public Map<String, Object> showNewCaseSheetJsp(Box box) {
		return ipdDataService.showNewCaseSheetJsp(box);
	}

	@Override
	public Map<String, Object> getPrevInvestigationDetails(Box box) {
		return ipdDataService.getPrevInvestigationDetails(box);
	}

	@Override
	public Map<String, Object> getPrevProcedureDetails(Box box) {
		return ipdDataService.getPrevProcedureDetails(box);
	}

	@Override
	public Map<String, Object> getPrevDietDetails(Box box) {
		return ipdDataService.getPrevDietDetails(box);
	}
	
	@Override
	public Map<String, Object> getPrevConsultationDetails(Box box) {
		return ipdDataService.getPrevConsultationDetails(box);
	}
	
	@Override
	public Map<String, Object> getTransferHistory(Box box) {
		return ipdDataService.getTransferHistory(box);
	}

	@Override
	public Map<String, Object> getPrevPhysiotherapyDetails(Box box) {
		return ipdDataService.getPrevPhysiotherapyDetails(box);
	}

	@Override
	public void executeProcedureForDMADutyReport(Map<String, Object> parameters) {
		ipdDataService.executeProcedureForDMADutyReport(parameters);
		
	}

	@Override
	public Map<String, Object> showSpecialistOpinionJsp(Box box) {
		return ipdDataService.showSpecialistOpinionJsp(box);
	}

	@Override
	public Map<String, Object> submitIpdSplcialistOpinion(Box box) {
		return ipdDataService.submitIpdSplcialistOpinion(box);
	}

	@Override
	public Map<String, Object> getSpecialistOpinionDetails(Box box) {
		return ipdDataService.getSpecialistOpinionDetails(box);
	}
	
	@Override
	public Map<String, Object> getMedicineList(Box box) {
		return ipdDataService.getMedicineList(box);
	}
	
	public Map<String, Object> getMedicineEntryPage(Box box) {

		return ipdDataService.getMedicineEntryPage(box);
	}

	@Override
	public Map<String, Object> viewSpecialistOpinion(Box box) {
		return ipdDataService.viewSpecialistOpinion(box);
	}

	@Override
	public String getHospitalName(int hospitalId) {
		return ipdDataService.getHospitalName(hospitalId);
	}

}