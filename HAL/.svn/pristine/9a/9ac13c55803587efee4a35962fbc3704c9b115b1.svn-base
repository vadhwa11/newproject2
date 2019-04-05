package jkt.hms.medicalBoardCheckup.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalBoardExaminationDetail;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.medicalBoardCheckup.dataservice.medicalBoardDataService;
import jkt.hms.util.Box;

public class MedicalBoardHandlerServiceImpl implements MedicalBoardHandlerService{

	medicalBoardDataService medicalBoardDataService=null;

	public medicalBoardDataService getMedicalBoardDataService() {
		return medicalBoardDataService;
	}
	public Map<String, Object> displayDocumentView(Map<String, Object> map) {
		return medicalBoardDataService.displayDocumentView(map);
	}
	public Map<String, Object> viewPatientDetails(Map<String, Object> map) {
		return medicalBoardDataService.viewPatientDetails(map);
	}
	public Map<String,Object> getItemListForDisabilityByAutocomplete(Map<String,Object> dataMap){
		return medicalBoardDataService.getItemListForDisabilityByAutocomplete(dataMap);
	}
	public Map<String, Object> viewUploadJsp(Map<String, Object> mapForDS)
	{
		return medicalBoardDataService.viewUploadJsp(mapForDS);
	}
	public Map<String, Object> submitUploadDocuments(Map<String, Object> mapForDS)
	{
		return medicalBoardDataService.submitUploadDocuments(mapForDS);
	}

	public void setMedicalBoardDataService(
			medicalBoardDataService medicalBoardDataService) {
		this.medicalBoardDataService = medicalBoardDataService;
	}
	public Map<String, Object> showUploadingDocumentsJsp(int visitId) {
		return medicalBoardDataService.showUploadingDocumentsJsp(visitId);
	}
	@Override
	public Map<String, Object> showMedicalExamWaitingList(int hospitalId) {
		
		return medicalBoardDataService.showMedicalExamWaitingList(hospitalId);
	}

	@Override
	public Map<String, Object> showintialBoardJsp(Box box) {
		
		return medicalBoardDataService.showintialBoardJsp(box);
		
	}

	@Override
	public Map showInitialMedicalBoardMedExamJsp(Map<String, Object> mapForDS) {
		return medicalBoardDataService.showInitialMedicalBoardMedExamJsp(mapForDS);
	}

	@Override
	public Map<String, Object> addMedicalBoardInit(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails,
			Map<String, Object> mapForDS) {
		return medicalBoardDataService.addMedicalBoardInit(masMedicalBoardProceedings,masMedicalBoardDetails,mapForDS);
	}

	@Override
	public Map<String, Object> showMedicalOfficerAppointmentInitial(Map<String, Object> mapForDS) {
		return medicalBoardDataService.showMedicalOfficerAppointmentInitial(mapForDS);
	}

	@Override
	public Map<String, Object> showMedicalOfficerInitial(Map<String, Object> mapForDS) {
		return medicalBoardDataService.showMedicalOfficerInitial(mapForDS);
	}

	@Override
	public MasMedicalExaminationReportOnEntry loadMedicalExamObj(int medExamId) {
		return medicalBoardDataService.loadMedicalExamObj(medExamId);
	}

	@Override
	public Boolean updateMedicalExaminationBoardInitial(
			Map<String, Object> mapForDS) {
		return medicalBoardDataService.updateMedicalExaminationBoardInitial(mapForDS);
	}

	@Override
	public Map<String, Object> showMoWatingList(Map<String, Object> mapofds) {
		return medicalBoardDataService.showMoWatingList(mapofds);
	}

	@Override
	public Map showMOFormJsp(Box box) {
		return medicalBoardDataService.showMOFormJsp(box);
	}

	@Override
	public Map<String, Object> submitUploadDocuments(Box box) {
	
		return medicalBoardDataService.submitUploadDocuments(box);
	}

	@Override
	public Map<String, Object> medicalBoardReports(Map<String, Object> mapofds) {
		return medicalBoardDataService.medicalBoardReports(mapofds);
	}

	@Override
	public Map<String, Object> getMedicalBoardDetails(
			Map<String, Object> mapfordata) {
		return medicalBoardDataService.getMedicalBoardDetails(mapfordata);
	}

	@Override
	public Map<String, Object> getCaseSheetDetails(Map<String, Object> mapForDS) {
		return medicalBoardDataService.getCaseSheetDetails(mapForDS);
	}

	@Override
	public Map<String, Object> SaveCaseSheetDetails(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings) {
		return medicalBoardDataService.SaveCaseSheetDetails(masMedicalBoardProceedings);
	}

	
	@Override
	public Map<String, Object> SpecialistOpinionList(int hospitalId) {
		return medicalBoardDataService.SpecialistOpinionList(hospitalId);
	}

	@Override
	public Map<String, Object> CommandofficerList(int hospitalId) {
		return medicalBoardDataService.CommandofficerList(hospitalId);
	}
	@Override
	public Map showMedicalOfficerMedBoardJsp(Box box) {
		return medicalBoardDataService.showMedicalOfficerMedBoardJsp(box);
	}
	@Override
	public Map<String, Object> showUploadViewDocumentJsp(
			Map<String, Object> mapDetails) {
		return medicalBoardDataService.showUploadViewDocumentJsp(mapDetails);
	}
	@Override
	public Map<String, Object> submitUploadDocumentsMo(Map<String, Object> mapForDS) {
		return medicalBoardDataService.submitUploadDocumentsMo(mapForDS);
	}
	@Override
	public Map<String, Object> viewUploadDocumentsMo(
			Map<String, Object> mapDetails) {
		return medicalBoardDataService.viewUploadDocumentsMo(mapDetails);
	}
@Override
	public Map<String, Object> showMBCommandOfficerWaitList(int hospitalId) {
		return medicalBoardDataService.showMBCommandOfficerWaitList(hospitalId);
	}
	@Override
	public Map<String, Object> showMBApproveAuthWaitList(int hospitalId) {
		return medicalBoardDataService.showMBApproveAuthWaitList(hospitalId);
	}
	@Override
	public Map<String, Object> showMBPerusingAuthWaitList(int hospitalId) {
		return medicalBoardDataService.showMBPerusingAuthWaitList(hospitalId);
	}
	@Override
	public Map<String, Object> showMBAppAuthDetails(Map<String, Object> mapForDS) {
		return medicalBoardDataService.showMBAppAuthDetails(mapForDS);
	}
	@Override
	public Map<String, Object> showMisMedicalBoardReport(Map<String, Object> mapofds) {
		return medicalBoardDataService.showMisMedicalBoardReport(mapofds);
	}

	@Override
	public Map<String, Object> showMISMedicalBoardReportGraph(Map<String, Object> dataMap) {
		return medicalBoardDataService.showMISMedicalBoardReportGraph(dataMap);
	}
	public Map<String, Object> medicalBoardReports() {
		return medicalBoardDataService.medicalBoardReports();
	}
	@Override
	public Map<String, Object> getConnectionForReport() {
		return medicalBoardDataService.getConnectionForReport();
	}
	@Override
	public Map<String, Object> showCurrentMedicalBoardStatus(
			Map<String, Object> mapofds) {
		return medicalBoardDataService.showCurrentMedicalBoardStatus(mapofds);
	}
	@Override
	public Map<String, Object> rejectMedicalBoardEntry(
			Map<String, Object> mapDetails) {
		return medicalBoardDataService.rejectMedicalBoardEntry(mapDetails);
	}
	@Override
	public Map<String, Object> showMBPerusingAuthDetails(Map<String, Object> mapForDS) {
		return medicalBoardDataService.showMBPerusingAuthDetails(mapForDS);
	}
	@Override
	public Map<String, Object> showMedicalExamList(Map<String, Object> dataMap) {
		return medicalBoardDataService.showMedicalExamList(dataMap);
	}
	@Override
	public Map<String, Object> saveInitialMedicalBoardPerusingAuthJsp(
			Map<String, Object> mapForDS) {
		return medicalBoardDataService.saveInitialMedicalBoardPerusingAuthJsp(mapForDS);
	}
	@Override
	public Map<String, Object> addMedicalBoardMA16(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails,
			Map<String, Object> mapForDS) {
		
		return medicalBoardDataService.addMedicalBoardMA16(masMedicalBoardProceedings,masMedicalBoardDetails,mapForDS);
	}
	@Override
	public Boolean updateMedicalBoardMA16(Map<String, Object> mapForDS) {
		return medicalBoardDataService.updateMedicalBoardMA16(mapForDS);
	}
	@Override
	public Map showMBCommandingOfficerJsp(Map<String, Object> mapForDS) {
		return medicalBoardDataService.showMBCommandingOfficerJsp(mapForDS);
	}
	@Override
	public Map<String, Object> validateMBCommandingOfficer(
			Map<String, Object> mapForDS) {
		return medicalBoardDataService.validateMBCommandingOfficer(mapForDS);
	}
	@Override
	public Map<String, Object> showMedicalBoardOpinionWaitList(int hospitalId) {
		return medicalBoardDataService.showMedicalBoardOpinionWaitList(hospitalId);
	}
	@Override
	public Map showMedicalBoardForm16(Map<String, Object> mapForDS) {
		return medicalBoardDataService.showMedicalBoardForm16(mapForDS);
	}
	@Override
	public Boolean addMedicalBoardMO16(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails,
			Map<String, Object> mapForDS) {
		return medicalBoardDataService.addMedicalBoardMO16(masMedicalBoardProceedings,masMedicalBoardDetails,mapForDS);
	}
	@Override
	public Boolean updateMedicalBoardMO16(Map<String, Object> mapForDS) {
		return medicalBoardDataService.updateMedicalBoardMO16(mapForDS);
	}
	@Override
	public Map showMBForm16List(Map<String, Object> mapForDS) {
		return medicalBoardDataService.showMBForm16List(mapForDS);
	}
	@Override
	public Map<String, Object> validateAppAuthForm16Jsp(
			Map<String, Object> mapForDS) {
		return medicalBoardDataService.validateAppAuthForm16Jsp(mapForDS);
	}
	@Override
	public Map showMBAppAuthForm16List(Map<String, Object> mapForDS) {
		return medicalBoardDataService.showMBAppAuthForm16List(mapForDS);
	}
	@Override
	public Map showMBConfAuthForm16List(Map<String, Object> mapForDS) {
		return medicalBoardDataService.showMBConfAuthForm16List(mapForDS);
	}
	@Override
	public Map showMBAccpAuthForm16List(Map<String, Object> mapForDS) {
		return medicalBoardDataService.showMBAccpAuthForm16List(mapForDS);
	}
	@Override
	public Map<String, Object> showMedicalBoardConfirmingAuthority(
			int hospitalId) {
		return medicalBoardDataService.showMedicalBoardConfirmingAuthority(hospitalId);
	}
	//--------------------Dinesh Dubey-----------------------------
	public Map<String, Object> getCommandingStatementDetails(Map<String, Object> mapForDS) {
		return medicalBoardDataService.getCommandingStatementDetails(mapForDS);
	}
	@Override
	public Map<String, Object> validateAcceptAuthForm16Jsp(Map<String, Object> mapForDS) {
		return medicalBoardDataService.validateAcceptAuthForm16Jsp(mapForDS);
	}
	@Override
	public Map<String, Object> validateConfAuthForm16Jsp(Map<String, Object> mapForDS) {
		return medicalBoardDataService.validateConfAuthForm16Jsp(mapForDS);
	}
	@Override
	public Map<String, Object> showMedicalBoardAcceptingAuthority(int hospitalId) {
		return medicalBoardDataService.showMedicalBoardAcceptingAuthority(hospitalId);
	}
	@Override
	public Map<String, Object> rejectMBForm16Entry(Map<String, Object> mapDetails) {
		return medicalBoardDataService.rejectMBForm16Entry(mapDetails);
	}
	public Map<String, Object> getMedicalBoardDetailsForSearch(Map<String, Object> mapfordata)
	{
		return medicalBoardDataService.getMedicalBoardDetailsForSearch(mapfordata);
	}
	@Override
	public Map<String, Object> validateMBOpinion(Map<String, Object> mapForDS) {
		return medicalBoardDataService.validateMBOpinion(mapForDS);
	}
	@Override
	public Map<String, Object> showMedicalBoardSpecialist(int hospitalId) {
		return medicalBoardDataService.showMedicalBoardSpecialist(hospitalId);
	}
	public Map<String, Object> getMedicalBoardDetail(Map<String, Object> mapfordata) {
		return medicalBoardDataService.getMedicalBoardDetail(mapfordata);
	}
	@Override
	public Map<String, Object> getPatientDetailAndAddMedicalBoard(String serviceNo) {
		return medicalBoardDataService.getPatientDetailAndAddMedicalBoard(serviceNo);
	}
	@Override
	public Map<String, Object> addOldMedicalBoardData(Map<String, Object> dataMap) {
		return medicalBoardDataService.addOldMedicalBoardData(dataMap);
	}
	@Override
	public Map<String, Object> updateMedicalExamEntryBySpecialist(Box box) {
		return medicalBoardDataService.updateMedicalExamEntryBySpecialist(box);
	}
	@Override
	public Map<String, Object> getSystemDiagList(Map<String, Object> map) {
		return medicalBoardDataService.getSystemDiagList(map);
	}
	@Override
	public Map<String, Object> getMedicalExamDetails(
			Map<String, Object> mapfordata) {
		return medicalBoardDataService.getMedicalExamDetails(mapfordata);
	}
	@Override
	public Map<String, Object> saveMIDData(Map<String, Object> dataMap) {
		return medicalBoardDataService.saveMIDData(dataMap);
	}
	@Override
	public Map<String, Object> fillServiceDetail(Map<String, Object> dataMap) {
		return medicalBoardDataService.fillServiceDetail(dataMap);
	}
	@Override
	public Map<String, Object> showMidData() {
		return medicalBoardDataService.showMidData();
	}
	@Override
	public Map<String, Object> updateMIDData(Map<String, Object> mapForDS) {
		return medicalBoardDataService.updateMIDData(mapForDS);
	}
	@Override
	public Map<String, Object> showMedicalBoard16Jsp(Map<String, Object> dataMap) {
		return medicalBoardDataService.showMedicalBoard16Jsp(dataMap);
	}
	@Override
	public Map<String, Object> showPrintValidateMO(int hospitalId) {
		return medicalBoardDataService.showPrintValidateMO(hospitalId);
	}
	@Override
	public Map<String, Object> getMedicalType(int visit_id) {
		return medicalBoardDataService.getMedicalType(visit_id);
	}
	@Override
	public Map<String, Object> searchMedicalBoardPerAuthority(Box box) {
		return medicalBoardDataService.searchMedicalBoardPerAuthority(box);
	}
	@Override
	public boolean initiateVisistFor2A(Map<String, Object> dataMap) {
		return medicalBoardDataService.initiateVisistFor2A(dataMap);
	}
	@Override
	public Map<String, Object> getMedicalBoardList(
			Map<String, Object> parameters) {
		return medicalBoardDataService.getMedicalBoardList(parameters);
	}
	@Override
	public Map<String, Object> showMisMedBoardStatics(
			Map<String, Object> mapofds) {
		return medicalBoardDataService.showMisMedBoardStatics(mapofds);
	}
	//--------Start By Mansi on 13 March 2013
	
	public Map<String, Object> showMedBoardForm10(Map<String, Object> mapForDS) {
		return medicalBoardDataService.showMedBoardForm10(mapForDS);
	}
	@Override
	public Map<String, Object> addMedicalBoardForm10(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,int visitId) {
		return medicalBoardDataService.addMedicalBoardForm10(masMedicalBoardProceedings,visitId);
	}
	@Override
	public Map<String, Object> showForm44Jsp(int hospitalId) {
		return medicalBoardDataService.showForm44Jsp(hospitalId);
	}
	@Override
	public Map<String, Object> autoCompleteForIcdDiagnosis(
			Map<String, Object> dataMap) {
		return medicalBoardDataService.autoCompleteForIcdDiagnosis(dataMap);
	}
	@Override
	public Map<String, Object> showMbForm44IntermeJSP(Map<String, Object> generalMap) {
		return medicalBoardDataService.showMbForm44IntermeJSP(generalMap);
	}
	@Override
	public Map<String, Object> showMbForm44JSP(Map<String, Object> generalMap) {
		return medicalBoardDataService.showMbForm44JSP(generalMap);
	}
	@Override
	public boolean submitMedicalBoardForm44(Map<String, Object> map) {
		return medicalBoardDataService.submitMedicalBoardForm44(map);
	}
	@Override
	public boolean submitMedicalExamForm44Interme(Map<String, Object> map) {
		return medicalBoardDataService.submitMedicalExamForm44Interme(map);
	}
}
