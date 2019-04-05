package jkt.hms.medicalExam.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalBoardExaminationDetail;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.medicalExam.dataservice.MedicalExamDataService;
import jkt.hms.util.Box;

public class MedicalExamHandlerServiceImpl implements MedicalExamHandlerService {
	
	MedicalExamDataService medicalExamDataService = null;

	public MedicalExamDataService getMedicalExamDataService() {
		return medicalExamDataService;
	}

	public void setMedicalExamDataService(
			MedicalExamDataService medicalExamDataService) {
		this.medicalExamDataService = medicalExamDataService;
	}
	public Map<String, Object> getICDList(Map map) {

		return medicalExamDataService.getICDList(map);
	}

	@Override
	public Map<String, Object> showMedicalExamRegistrationJsp(int hospitalId) {
		return medicalExamDataService.showMedicalExamRegistrationJsp(hospitalId);
	}

	@Override
	public Map<String, Object> showMedicalExamWaitingList(int hospitalId) {
		return medicalExamDataService.showMedicalExamWaitingList(hospitalId);
	}

	@Override
	public Map<String, Object> showPrimaryExtMedExamJsp(Box box) {
		return medicalExamDataService.showPrimaryExtMedExamJsp(box);
	}

	@Override
	public Map<String, Object> addMedicalExaminationBoardAnnual(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails,
			Map<String, Object> mapForDS) {
		return medicalExamDataService.addMedicalExaminationBoardAnnual(masMedicalBoardProceedings,masMedicalBoardDetails,mapForDS);
		
	}

	@Override
	public Map showAnnualMedExamJsp(Map<String, Object> mapForDS) {
		return medicalExamDataService.showAnnualMedExamJsp(mapForDS);
	}

	@Override
	public Map<String, Object> showMedicalOfficerAppointment(Map<String, Object> mapForDS) {
		return medicalExamDataService.showMedicalOfficerAppointment(mapForDS);
	}

	@Override
	public Map<String, Object> searchMedicalExamMedicalOfficer(
			Map<String, Object> mapForDs) {
		return medicalExamDataService.searchMedicalExamMedicalOfficer(mapForDs);
	}
	
	
	@Override
	public List<MasMedicalExaminationReportOnEntry> getExistingMedExamList(
			Box box) {
		return medicalExamDataService.getExistingMedExamList(box);
	}

	@Override
	public Map showMOPrimaryMedExamJsp(Box box) {
		return medicalExamDataService.showMOPrimaryMedExamJsp(box);
	}
	
	@Override
	public Map showMedicalOfficerMedExamJsp(Box box) {
		return medicalExamDataService.showMedicalOfficerMedExamJsp(box);
	}


	@Override
	public Boolean updateMedicalExaminationBoardAnnual(
			Map<String, Object> mapForDS) {
		return medicalExamDataService.updateMedicalExaminationBoardAnnual( mapForDS);
	}

	@Override
	public MasMedicalExaminationReportOnEntry loadMedicalExamObj(int medExamId) {
		return medicalExamDataService.loadMedicalExamObj(medExamId) ;
	}

	@Override
	public Map<String, Object> pendingClwatingList(Map<String, Object> mapofds) {
		return medicalExamDataService.pendingClwatingList( mapofds);
	}

	@Override
	public Map<String, Object> validateMedExam(Box box) {
		return medicalExamDataService.validateMedExam(box);
	}

	@Override
	public Map<String, Object> rejectMedExam(Box box) {
		return medicalExamDataService.rejectMedExam(box); 
	}

	@Override
	public Map<String, Object> pendingMDWatingList(Map<String, Object> mapofds) {
		return medicalExamDataService.pendingMDWatingList( mapofds);
	}

	@Override
	public Map<String, Object> pendingMedicalExamReport() {
		return medicalExamDataService.pendingMedicalExamReport( );
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		return medicalExamDataService.getConnectionForReport( );
	}

	@Override
	public Map<String, Object> getMedicalExamDetails(
			Map<String, Object> mapfordata) {
		return medicalExamDataService.getMedicalExamDetails(mapfordata);
	}

	@Override
	public Map<String, Object> getPrevMedExamFromHIC(Map<String, Object> mapForDS) {
		return medicalExamDataService.getPrevMedExamFromHIC(mapForDS);
	}

	@Override
	public Map<String, Object> getPrevMedExamFromSMC(Map<String, Object> mapForDS) {
		return medicalExamDataService.getPrevMedExamFromSMC(mapForDS);
	}

	@Override
	public Map<String, Object> getPrevMedBoardFromSMC(
			Map<String, Object> mapForDS) {
		return medicalExamDataService.getPrevMedBoardFromSMC(mapForDS);
	}

	@Override
	public Map<String, Object> getPrevMedBoardFromHIC(
			Map<String, Object> mapForDS) {
		return medicalExamDataService.getPrevMedBoardFromHIC(mapForDS);
	}

	@Override
	public Map<String, Object> showApprovingAWatingList(int hospitalId) {
		return medicalExamDataService.showApprovingAWatingList(hospitalId);
	}

	@Override
	public Map<String, Object> validateMedExamApprovingAuthority(Box box) {
		return medicalExamDataService.validateMedExamApprovingAuthority(box);
	}
	@Override
	public Map<String, Object> showMedicalExamPerAuthority(int hospitalId) 
	{
		return medicalExamDataService.showMedicalExamPerAuthority(hospitalId);
	}
	@Override
	public Map<String, Object> validateMedExamPersusingAuthority(Map<String, Object> mapForDS) {
		return medicalExamDataService.validateMedExamPersusingAuthority(mapForDS);
	}
	public Map<String, Object> submitUploadDocuments(Map<String, Object> mapForDS)
	{
		return medicalExamDataService.submitUploadDocuments(mapForDS);
	}
	public Map<String, Object> rejectMedExamAA(Box box)
	{
		return medicalExamDataService.rejectMedExamAA(box);
	}
	public Map<String, Object> rejectMedExamPA(Map<String, Object> mapForDS)
	{
		return medicalExamDataService.rejectMedExamPA(mapForDS);
	}
	public Map<String, Object> viewUploadJsp(Map<String, Object> mapForDS)
	{
		return medicalExamDataService.viewUploadJsp(mapForDS);
	}
	public Map<String, Object> viewUploadInvestDocument(Map<String, Object> mapForDS)
	{
		return medicalExamDataService.viewUploadInvestDocument(mapForDS);
	}
	@Override
	public Map<String, Object> showOCUnitWatingList(int hospitalId)
	{
		return medicalExamDataService.showOCUnitWatingList(hospitalId);
	}
	@Override
	public Map<String, Object> showMedicalExamPerAuthorityAFRO(int hospitalId) 
	{
		return medicalExamDataService.showMedicalExamPerAuthorityAFRO(hospitalId);
	}
	@Override
	public Map<String, Object> validateMedExamPersusingAuthorityAFRO(Map<String, Object> mapForDS) {
		return medicalExamDataService.validateMedExamPersusingAuthorityAFRO(mapForDS);
	}
	public Map<String, Object> rejectMedExamPAAFRO(Map<String, Object> dataMap)
	{
		return medicalExamDataService.rejectMedExamPAAFRO(dataMap);
	}
	public List<MasMedicalExaminationReportOnEntry> getMedicalExamRecord(int medExamId)
	{
		return medicalExamDataService.getMedicalExamRecord(medExamId);
	}
	public Map<String, Object> getMedicalExamRegisterGraph(Map<String, Object> dataMap)
	{
		return medicalExamDataService.getMedicalExamRegisterGraph(dataMap);
	}
	public Boolean addMedicalExaminationBoardAnnual2A(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,Map<String, Object> mapForDS) 
	{
		return medicalExamDataService.addMedicalExaminationBoardAnnual2A(masMedicalBoardProceedings,mapForDS);
		
	}
	public Boolean updateMedicalExaminationBoardAnnual2A(Map<String, Object> mapForDS) 
	{
		return medicalExamDataService.updateMedicalExaminationBoardAnnual2A( mapForDS);
	}
	public Map<String, Object> displayFileUploadData(Map<String, Object> dataMap)
	{
		return medicalExamDataService.displayFileUploadData(dataMap);
	}
	public Map<String, Object> submitUploadDocumentsForMedicalExam(Map<String, Object> dataMap)
	{
		return medicalExamDataService.submitUploadDocumentsForMedicalExam(dataMap);
	}
	public Map<String, Object> getUploadDocumentDetails(Map<String, Object> dataMap)
	{
		return medicalExamDataService.getUploadDocumentDetails(dataMap);
	}
	public Map<String, Object> getUploadDocumentMedicalExamData(Map<String, Object> dataMap)
	{
		return medicalExamDataService.getUploadDocumentMedicalExamData(dataMap);
	}
	public Map<String, Object> submitUploadDocumentsInvestForMedicalExam(Map<String, Object> dataMap)
	{
		return medicalExamDataService.submitUploadDocumentsInvestForMedicalExam(dataMap);
	} 
   public Map<String, Object> getUploadDocumentInvestigationDetails(Map<String, Object> dataMap)
   {
	   return medicalExamDataService.getUploadDocumentInvestigationDetails(dataMap);
   }
   public Map<String, Object> getUploadDocumentMedicalExamInvestigationData(Map<String, Object> dataMap)
   {
	   return medicalExamDataService.getUploadDocumentMedicalExamInvestigationData(dataMap);
   }
   public boolean initiateNewMedicalExam(Map<String, Object> dataMap)
   {
	   return medicalExamDataService.initiateNewMedicalExam(dataMap);
   }
   public Map<String, Object> validateMedExamSpecialOpinion(Box box) {
		return medicalExamDataService.validateMedExamSpecialOpinion(box);
	}

@Override
public Map<String, Object> editMID_MedicalExam(Map<String, Object> mapfordata) {
	return medicalExamDataService.editMID_MedicalExam(mapfordata);
}

@Override
public Boolean addMID_MedicalExam(
		MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,
		Map<String, Object> mapForDS) {
	return medicalExamDataService.addMID_MedicalExam(masMedicalBoardProceedings,mapForDS);
}

public Map<String, Object> getPatientDetailAndAddMedicalExam(String serviceNo)
{
	return medicalExamDataService.getPatientDetailAndAddMedicalExam(serviceNo);
	
}
public Map<String, Object> addOldMedicalExamData(Map<String, Object> dataMap)
{
	return medicalExamDataService.addOldMedicalExamData(dataMap);
}

@Override
public Map<String, Object> searchMedicalExamPerAuthority(Box box) {
	
	return medicalExamDataService.searchMedicalExamPerAuthority(box);
}

public Map<String, Object> serchPendingMDWatingList(Map<String, Object> mapofds) {
	// TODO Auto-generated method stub
	return medicalExamDataService.serchPendingMDWatingList(mapofds);
}

@Override
public Map<String, Object> showMedicalExamSpecialist(int hospitalId) {
	// TODO Auto-generated method stub
	return medicalExamDataService.showMedicalExamSpecialist(hospitalId);
}

@Override
public Map<String, Object> validateMedExamSpecialistOpinion(Box box) {
	// TODO Auto-generated method stub
	return medicalExamDataService.validateMedExamSpecialistOpinion(box);
}

@Override
public Map<String, Object> showMedicalExamListForSpecialist(Map<String, Object> dataMap) {
	// TODO Auto-generated method stub
	return medicalExamDataService.showMedicalExamListForSpecialist(dataMap);
}

@Override
public Map<String, Object> updateMedicalExamEntryBySpecialist(Box box) {
	// TODO Auto-generated method stub
	return medicalExamDataService.updateMedicalExamEntryBySpecialist(box);
}

@Override
public Map<String, Object> showForm44Jsp(int hospitalId) {
	return medicalExamDataService.showForm44Jsp(hospitalId);
}

@Override
public Map<String, Object> getRankList(int rankId, int tradeId) {
	return medicalExamDataService.getRankList(rankId,tradeId);
	
}

@Override
public Map<String, Object> showPrintValidateMOMedicalExam(int hospitalId) {
	// TODO Auto-generated method stub
	return medicalExamDataService.showPrintValidateMOMedicalExam(hospitalId);
}

@Override
public Map<String, Object> getMedicalType(int visitId) {
	// TODO Auto-generated method stub
	return medicalExamDataService.getMedicalType(visitId);
}

@Override
public String getHospitalName(int hospitalId) {
	// TODO Auto-generated method stub
	return medicalExamDataService.getHospitalName(hospitalId);
}

@Override
public Map<String, Object> submitAFMSF7AJsp(Map<String, Object> mapForDS) {
	return medicalExamDataService.submitAFMSF7AJsp(mapForDS);
}

@Override
public Map<String, Object> showAFMSF7AJsp(Map<String, Object> mapForDS) {
	return medicalExamDataService.showAFMSF7AJsp(mapForDS);
}

public Map<String, Object> showMeForm44JSP(Map<String, Object> generalMap) {
	
	return medicalExamDataService.showMeForm44JSP(generalMap);
}


public boolean submitMedicalExamForm44(Map<String, Object> map) {
	return medicalExamDataService.submitMedicalExamForm44(map);
}

@Override
public Map<String, Object> showAmeDataEntryList() {
	return medicalExamDataService.showAmeDataEntryList();
}

@Override
public Map<String, Object> getServiceNo(Map<String, Object> dataMap) {
	return medicalExamDataService.getServiceNo(dataMap);
}

@Override
public Map<String, Object> addAmeDataEntry(
		MasMedicalExaminationReportOnEntry masMedicalBoardProceedings) {
	return medicalExamDataService.addAmeDataEntry(masMedicalBoardProceedings);
}

@Override
public Map<String, Object> getListOfMedicalExam(Box box) {
	return medicalExamDataService.getListOfMedicalExam(box);
	
}


}
