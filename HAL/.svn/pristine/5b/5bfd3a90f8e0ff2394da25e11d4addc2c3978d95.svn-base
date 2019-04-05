package jkt.hms.medicalBoardCheckup.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalBoardExaminationDetail;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.util.Box;

public interface MedicalBoardHandlerService {

	Map<String, Object> showMedicalExamWaitingList(int hospitalId);
	Map<String, Object> displayDocumentView(Map<String, Object> map);
	Map<String, Object> showintialBoardJsp(Box box);

	Map showInitialMedicalBoardMedExamJsp(Map<String, Object> mapForDS);

	Map<String, Object> addMedicalBoardInit(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails,
			Map<String, Object> mapForDS);

	Map<String, Object> showMedicalOfficerAppointmentInitial(Map<String, Object> mapForDS);
    Map<String, Object> getItemListForDisabilityByAutocomplete(Map<String,Object> dataMap);
    Map<String, Object> showMedicalOfficerInitial(Map<String,Object> mapForDS);
	Map<String, Object> showUploadingDocumentsJsp(int visitId);
	MasMedicalExaminationReportOnEntry loadMedicalExamObj(int medExamId);
	Map<String, Object> submitUploadDocuments(Map<String, Object> mapForDS);
	Boolean updateMedicalExaminationBoardInitial(Map<String, Object> mapForDS);
	Map<String, Object> showMoWatingList(Map<String, Object> mapofds);
	Map<String, Object> viewPatientDetails(Map<String, Object> map);
	Map showMOFormJsp(Box box);
	Map<String, Object> viewUploadJsp(Map<String, Object> mapForDS);
	Map<String, Object> submitUploadDocuments(Box box);
	Map<String, Object> medicalBoardReports(Map<String, Object> mapofds);
	Map<String, Object> getMedicalBoardDetails(Map<String, Object> mapfordata);
	Map<String, Object> getCaseSheetDetails(Map<String, Object> mapForDS);
	Map<String, Object> SaveCaseSheetDetails(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings);
	Map<String, Object> SpecialistOpinionList(int hospitalId);
	Map<String, Object> CommandofficerList(int hospitalId);
	Map showMedicalOfficerMedBoardJsp(Box box);
	Map<String, Object> showUploadViewDocumentJsp(Map<String, Object> mapDetails);
	Map<String, Object> submitUploadDocumentsMo(Map<String, Object> mapForDS);
	Map<String, Object> viewUploadDocumentsMo(Map<String, Object> mapDetails);
	Map<String, Object> showMBCommandOfficerWaitList(int hospitalId);
	Map<String, Object> showMBApproveAuthWaitList(int hospitalId);
	Map<String, Object> showMBPerusingAuthWaitList(int hospitalId);
	Map<String, Object> showMBAppAuthDetails(Map<String, Object> mapForDS);
	Map<String, Object> showMisMedicalBoardReport(Map<String, Object> mapofds);
	Map<String, Object> showMISMedicalBoardReportGraph(Map<String, Object> dataMap);
	Map<String, Object> medicalBoardReports();
	
	Map<String, Object> getConnectionForReport();
	
	Map<String, Object> showCurrentMedicalBoardStatus(Map<String, Object> mapofds);	
	Map<String, Object> rejectMedicalBoardEntry(Map<String, Object> mapDetails);
	Map<String, Object> showMBPerusingAuthDetails(Map<String, Object> mapForDS);
	Map<String, Object> showMedicalExamList(Map<String, Object> dataMap);
	
    /**
     * @author Mukesh.narayan
     * This method is used for validate Approving Authority & Perusing Authority Both
     * @return map message for forwarding to next level
     * @date 15 feb 2012 
     */
	Map<String, Object> saveInitialMedicalBoardPerusingAuthJsp(
			Map<String, Object> mapForDS);
	/**
     * @author Mukesh.narayan
     * This method is used for Save MA Form 16
     * @return boolean true/false 
     * @date 23 feb 2012 
     */
	Map<String, Object> addMedicalBoardMA16(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails,
			Map<String, Object> mapForDS);
	/**
     * @author Mukesh.narayan
     * This method is used for update MA Form 16
     * @return boolean true/false 
     * @date 23 feb 2012 
     */
	Boolean updateMedicalBoardMA16(Map<String, Object> mapForDS);
	Map showMBCommandingOfficerJsp(Map<String, Object> mapForDS);
	Map<String, Object> validateMBCommandingOfficer(Map<String, Object> mapForDS);
	Map<String, Object> showMedicalBoardOpinionWaitList(int hospitalId);
	Map showMedicalBoardForm16(Map<String, Object> mapForDS);
	Boolean addMedicalBoardMO16(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails,
			Map<String, Object> mapForDS);
	Boolean updateMedicalBoardMO16(Map<String, Object> mapForDS);
	Map showMBForm16List(Map<String, Object> mapForDS);
	Map<String, Object> validateAppAuthForm16Jsp(Map<String, Object> mapForDS);
	Map showMBAppAuthForm16List(Map<String, Object> mapForDS);
	Map showMBConfAuthForm16List(Map<String, Object> mapForDS);
	Map showMBAccpAuthForm16List(Map<String, Object> mapForDS);
	Map<String, Object> showMedicalBoardConfirmingAuthority(int hospitalId);
	//--------------------Dinesh Dubey------------------------
	Map<String, Object> getCommandingStatementDetails(Map<String, Object> mapForDS) ;
	Map<String, Object> validateAcceptAuthForm16Jsp(Map<String, Object> mapForDS);
	Map<String, Object> validateConfAuthForm16Jsp(Map<String, Object> mapForDS);
	Map<String, Object> showMedicalBoardAcceptingAuthority(int hospitalId);
	Map<String, Object> rejectMBForm16Entry(Map<String, Object> mapDetails);
	Map<String, Object> getMedicalBoardDetailsForSearch(Map<String, Object> mapfordata);
	Map<String, Object> validateMBOpinion(Map<String, Object> mapForDS);
	/**
     * @author Mukesh.narayan
     * This method is used for waiting list Specialist Opinion
     * @return boolean true/false 
     * @date 03 Apr 2012 
     */
	Map<String, Object> showMedicalBoardSpecialist(int hospitalId);
	Map<String, Object> getMedicalBoardDetail(Map<String, Object> mapfordata);
	Map<String, Object> getPatientDetailAndAddMedicalBoard(String serviceNo);
	Map<String, Object> addOldMedicalBoardData(Map<String, Object> dataMap);
	Map<String, Object> updateMedicalExamEntryBySpecialist(Box box);
	
	Map<String, Object> getSystemDiagList(Map<String, Object> map);
	Map<String, Object> getMedicalExamDetails(Map<String, Object> mapfordata);
	Map<String, Object> saveMIDData(Map<String, Object> dataMap);
	Map<String, Object> fillServiceDetail(Map<String, Object> dataMap);
	Map<String, Object> showMidData();
	Map<String, Object> updateMIDData(Map<String, Object> mapForDS);
	Map<String, Object> showMedicalBoard16Jsp(Map<String, Object> dataMap);
	Map<String, Object> showPrintValidateMO(int hospitalId);
	Map<String, Object> getMedicalType(int visit_id);
	Map<String, Object> searchMedicalBoardPerAuthority(Box box);
	boolean initiateVisistFor2A(Map<String, Object> dataMap);
	Map<String, Object> getMedicalBoardList(Map<String, Object> parameters);
Map<String, Object> showMisMedBoardStatics(Map<String, Object> mapofds); 
	//-------- By Mansi on 13 March 2013
	
	Map<String, Object> showMedBoardForm10(Map<String, Object> mapForDS);
	Map<String, Object> addMedicalBoardForm10(MasMedicalExaminationReportOnEntry masMedicalBoardProceedings, int visitId);
	Map<String, Object> showForm44Jsp(int hospitalId);
	Map<String, Object> autoCompleteForIcdDiagnosis(Map<String, Object> dataMap);
	
	//-----by kiran
	
	Map<String, Object> showMbForm44JSP(Map<String, Object> generalMap);
	boolean submitMedicalBoardForm44(Map<String, Object> map);
	Map<String, Object> showMbForm44IntermeJSP(Map<String, Object> generalMap);
	boolean submitMedicalExamForm44Interme(Map<String, Object> map); 
}
