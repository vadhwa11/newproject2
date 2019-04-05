package jkt.hms.medicalExam.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalBoardExaminationDetail;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.util.Box;

public interface MedicalExamDataService {

	Map<String, Object> showMedicalExamRegistrationJsp(int hospitalId);

	Map<String, Object> showMedicalExamWaitingList(int hospitalId);

	Map<String, Object> showPrimaryExtMedExamJsp(Box box);

	Map<String, Object> addMedicalExaminationBoardAnnual(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails,
			Map<String, Object> mapForDS);

	Map showAnnualMedExamJsp(Map<String, Object> mapForDS);
	Map<String, Object> getICDList(Map map);
	Map<String, Object> showMedicalOfficerAppointment(Map<String, Object> mapForDS);

	Map<String, Object> searchMedicalExamMedicalOfficer(
			Map<String, Object> mapForDs);

	Map showMedicalOfficerMedExamJsp(Box box);

	List<MasMedicalExaminationReportOnEntry> getExistingMedExamList(Box box);

	Map showMOPrimaryMedExamJsp(Box box);

	Boolean updateMedicalExaminationBoardAnnual(Map<String, Object> mapForDS);

	MasMedicalExaminationReportOnEntry loadMedicalExamObj(int medExamId);

	Map<String, Object> pendingClwatingList(Map<String, Object> mapofds);

	Map<String, Object> validateMedExam(Box box);

	Map<String, Object> rejectMedExam(Box box);

	Map<String, Object> pendingMDWatingList(Map<String, Object> mapofds);

	Map<String, Object> pendingMedicalExamReport();

	Map<String, Object> getConnectionForReport();

	Map<String, Object> getMedicalExamDetails(Map<String, Object> mapfordata);

	Map<String, Object> getPrevMedExamFromHIC(Map<String, Object> mapForDS);

	Map<String, Object> getPrevMedExamFromSMC(Map<String, Object> mapForDS);

	Map<String, Object> getPrevMedBoardFromSMC(Map<String, Object> mapForDS);

	Map<String, Object> getPrevMedBoardFromHIC(Map<String, Object> mapForDS);

	Map<String, Object> showApprovingAWatingList(int hospitalId);
	Map<String, Object> validateMedExamApprovingAuthority(Box box);
	Map<String, Object> showMedicalExamPerAuthority(int hospitalId);
	Map<String, Object> validateMedExamPersusingAuthority(Map<String, Object> mapForDS);

	Map<String, Object> submitUploadDocuments(Map<String, Object> mapForDS);
	Map<String, Object> rejectMedExamAA(Box box);
	Map<String, Object> rejectMedExamPA(Map<String, Object> mapForDS);
	Map<String, Object> viewUploadJsp(Map<String, Object> mapForDS);
	Map<String, Object> viewUploadInvestDocument(Map<String, Object> mapForDS);
	Map<String, Object> showOCUnitWatingList(int hospitalId);
    Map<String, Object> showMedicalExamPerAuthorityAFRO(int hospitalId);
	Map<String, Object> validateMedExamPersusingAuthorityAFRO(Map<String, Object> mapForDS) ;
	Map<String, Object> rejectMedExamPAAFRO(Map<String, Object> dataMap);
	List<MasMedicalExaminationReportOnEntry> getMedicalExamRecord(int medExamId);
	Map<String, Object> getMedicalExamRegisterGraph(Map<String, Object> dataMap);
	Boolean addMedicalExaminationBoardAnnual2A(MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,
			Map<String, Object> mapForDS);
	Boolean updateMedicalExaminationBoardAnnual2A(Map<String, Object> mapForDS);
	Map<String, Object> displayFileUploadData(Map<String, Object> dataMap);
	Map<String, Object> submitUploadDocumentsForMedicalExam(Map<String, Object> dataMap);
	Map<String, Object> getUploadDocumentDetails(Map<String, Object> dataMap);
	Map<String, Object> getUploadDocumentMedicalExamData(Map<String, Object> dataMap);
	Map<String, Object> submitUploadDocumentsInvestForMedicalExam(Map<String, Object> dataMap);
	Map<String, Object> getUploadDocumentInvestigationDetails(Map<String, Object> dataMap);
	Map<String, Object> getUploadDocumentMedicalExamInvestigationData(Map<String, Object> dataMap);
	boolean initiateNewMedicalExam(Map<String, Object> dataMap);
	Map<String, Object> validateMedExamSpecialOpinion(Box box);
	
	Map<String, Object> editMID_MedicalExam(Map<String, Object> mapfordata);

	Boolean addMID_MedicalExam(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,
			Map<String, Object> mapForDS);
	
	Map<String, Object> getPatientDetailAndAddMedicalExam(String serviceNo);
	Map<String, Object> addOldMedicalExamData(Map<String, Object> dataMap);

	Map<String, Object> searchMedicalExamPerAuthority(Box box);

	Map<String, Object> serchPendingMDWatingList(Map<String, Object> mapofds);

	Map<String, Object> showMedicalExamSpecialist(int hospitalId);

	Map<String, Object> validateMedExamSpecialistOpinion(Box box);

	Map<String, Object> showMedicalExamListForSpecialist(
			Map<String, Object> dataMap);

	Map<String, Object> updateMedicalExamEntryBySpecialist(Box box);
	
	Map<String, Object> showForm44Jsp(int hospitalId);

	Map<String, Object> getRankList(int rankId, int tradeId);

	Map<String, Object> showPrintValidateMOMedicalExam(int hospitalId);

	Map<String, Object> getMedicalType(int visitId);

	String getHospitalName(int hospitalId);
	
	Map<String, Object> submitAFMSF7AJsp(Map<String, Object> mapForDS);
	
	Map<String, Object> showAFMSF7AJsp(Map<String, Object> mapForDS);

	Map<String, Object> showMeForm44JSP(Map<String, Object> generalMap);
	boolean submitMedicalExamForm44(Map<String, Object> map);

	Map<String, Object> showAmeDataEntryList();

	Map<String, Object> getServiceNo(Map<String, Object> dataMap);

	Map<String, Object> addAmeDataEntry(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings);

	Map<String, Object> getListOfMedicalExam(Box box);
}
