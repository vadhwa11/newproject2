package jkt.hms.investigation.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.investigation.dataservice.InvestigationDataService;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgSubMasInvestigation;
import jkt.hms.masters.business.DgTemplate;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.dataservice.CommonMasterDataService;
import jkt.hms.util.Box;

public class InvestigationHandlerServiceImpl implements
		InvestigationHandlerService {
	InvestigationDataService investigationDataService = null;
	CommonMasterDataService commonMasterDataService = null;

	// ---------------------------------------------------------------------------------------------------
	public CommonMasterDataService getCommonMasterDataService() {
		return commonMasterDataService;
	}

	public void setCommonMasterDataService(
			CommonMasterDataService commonMasterDataService) {
		this.commonMasterDataService = commonMasterDataService;
	}

	public InvestigationDataService getInvestigationDataService() {
		return investigationDataService;
	}

	public void setInvestigationDataService(
			InvestigationDataService investigationDataService) {
		this.investigationDataService = investigationDataService;
	}

	// ------------------------------------------------------------------------------------------------------

	public Map<String, Object> showInvestigationJsp(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.showInvestigationJsp(box);
	}

	public Map<String, Object> getChargeDetails(int subChargeCodeId) {
		// TODO Auto-generated method stub
		return investigationDataService.getChargeDetails(subChargeCodeId);
	}

	public Map getResponseSubchargeList(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getResponseSubchargeList(box);
	}

	public Map getChargeDetails(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getChargeDetails(box);
	}

	public Map getParameterDetails(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getParameterDetails(box);
	}

	public Map<String, Object> getNormalValueDetails(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getNormalValueDetails(box);
	}

	public boolean updateSubTest(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.updateSubTest(box);
	}

	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService.getPatientDetails(mapForDs);
	}

	public boolean checkInvestigationExsist(String investigationCode,
			String investigationName) {
		// TODO Auto-generated method stub
		return investigationDataService.checkInvestigationExsist(
				investigationCode, investigationName);
	}

	public boolean addInvestigation(DgMasInvestigation dgmasInvestigation) {
		// TODO Auto-generated method stub
		return investigationDataService.addInvestigation(dgmasInvestigation);
	}

	public Map<String, Object> searchInvestigation(int searchModality,
			String investigationName,int deptId) {
		// TODO Auto-generated method stub
		return investigationDataService.searchInvestigation(searchModality,
				investigationName,deptId);
	}

	public boolean editInvestigation(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return investigationDataService.editInvestigation(generalMap);
	}

	public Map<String, Object> submitResultEntry(
			Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return investigationDataService.submitResultEntry(parameterMap);
	}

	public String generateResultNumber(Map<String, Object> diagMap) {
		// TODO Auto-generated method stub
		return investigationDataService.generateResultNumber(diagMap);
	}

	public Map<String, Object> getPatientDetailsForResultValidation(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService
				.getPatientDetailsForResultValidation(mapForDs);
	}

	public Map<String, Object> getAllDetails(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getAllDetails(box);
	}

	public Map<String, Object> getSampleCollectionDetails(
			int sampleCollectionDetailId, int deptId) {
		// TODO Auto-generated method stub
		return investigationDataService.getSampleCollectionDetails(
				sampleCollectionDetailId, deptId);
	}

	public Map getResultList(int resultId) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultList(resultId);
	}

	public Map<String, Object> getResultEntryDetails(int resultId, int deptId) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultEntryDetails(resultId, deptId);
	}

	public boolean submitResultValidation(Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return investigationDataService.submitResultValidation(infoMap);
	}

	public Map<String, Object> getPatientDetailsForReportCollection(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService
				.getPatientDetailsForReportCollection(mapForDs);
	}

	public Map<String, Object> getResultDetails(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultDetails(mapForDs);
	}

	public boolean deleteInvestigation(int chargeCodeId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return investigationDataService.deleteInvestigation(chargeCodeId,
				generalMap);
	}

	public Map<String, Object> submitResultEntryForSingleParameter(
			Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return investigationDataService
				.submitResultEntryForSingleParameter(parameterMap);
	}

	public boolean submitResultValidationForSingleParameter(
			Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return investigationDataService
				.submitResultValidationForSingleParameter(infoMap);
	}

	public Map<String, Object> getDetailsForResultValidation(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getDetailsForResultValidation(dataMap);
	}

	public Map<String, Object> getSubTestList(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getSubTestList(box);
	}

	public Map<String, Object> getDetailsForReportCollection(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getDetailsForReportCollection(dataMap);
	}

	public Map<String, Object> getDetails(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getDetails(dataMap);
	}

	public boolean submitNormalValues(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.submitNormalValues(box);
	}

	public Map<String, Object> submitResultEntryForTemplate(
			Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return investigationDataService
				.submitResultEntryForTemplate(parameterMap);
	}

	public boolean submitResultValidationForTemplate(Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return investigationDataService
				.submitResultValidationForTemplate(infoMap);
	}

	public boolean submitFixedValues(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.submitFixedValues(box);
	}

	public List<DgTemplate> getTemplateList(int chargeCodeId) {
		// TODO Auto-generated method stub
		return investigationDataService.getTemplateList(chargeCodeId);
	}

	public boolean updateTemplate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return investigationDataService.updateTemplate(map);
	}

	public Map<String, Object> addSubTest(Box box, Map dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.addSubTest(box, dataMap);
	}

	public Map<String, Object> getFixedList(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getFixedList(box);
	}

	public List<DgSubMasInvestigation> getChargeList(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getChargeList(box);
	}

	public boolean submitTemplate(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.submitTemplate(dataMap);
	}

	public Map<String, Object> getResultEntryDetailsForNext(int newResultId,
			int deptId) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultEntryDetailsForNext(
				newResultId, deptId);
	}

	public Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getDetailsForSearch(dataMap);
	}

	public boolean updateNormalValue(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.updateNormalValue(box);
	}

	public boolean updateFixedValues(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.updateFixedValues(box);
	}

	public boolean submitResultValidationForSensitivity(
			Map<String, Object> infoMap) {
		return investigationDataService
				.submitResultValidationForSensitivity(infoMap);

	}

	public boolean updateReceivedDetails(Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return investigationDataService.updateReceivedDetails(infoMap);
	}

	public Map<String, Object> getResultValidationGrid(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultValidationGrid(mapForDs);
	}

	public Map<String, Object> getResultGrid(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultGrid(mapForDs);
	}

	public Map<String, Object> getResultViewGrid(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultViewGrid(mapForDs);
	}

	/** method by mansi **/
	public Map<String, Object> getPatientDetailsForResultValidationOrderNo(
			Map<String, Object> mapForDs) {
		return investigationDataService
				.getPatientDetailsForResultValidationOrderNo(mapForDs);
	}

	public Map<String, Object> getConnectionForReport() {
		// TODO Auto-generated method stub
		return investigationDataService.getConnectionForReport();
	}

	public Map<String, Object> getResultEntryForNext(int newSampleCollectionId,
			int deptId) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultEntryForNext(
				newSampleCollectionId, deptId);
	}

	/** end of method **/
	public Map<String, Object> getResultEntryDetailsForTemplate(
			String resultNo, int deptId) {
		return investigationDataService.getResultEntryDetailsForTemplate(
				resultNo, deptId);
	}

	// -------------------------------Start Methods developed by Vivek
	// --------------------------------------
	public Map<String, Object> getOrganismList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getOrganismList(dataMap);
	}

	public Map<String, Object> getResultOrganismList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultOrganismList(dataMap);
	}

	public Map<String, Object> getSensitivityList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getSensitivityList(dataMap);
	}

	public Map<String, Object> saveSensitivity(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.saveSensitivity(dataMap);
	}

	public Map<String, Object> getResultSensitivityList(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultSensitivityList(dataMap);
	}

	public boolean updateResultTemplateForValidation(Map<String, Object> dataMap) {
		return investigationDataService
				.updateResultTemplateForValidation(dataMap);
	}

	// -------------------------------End Methods developed by
	// Vivek------------------------------------------
	// ////////////////////////////
	public Map updateDgResultEntryHeader(
			Map<String, Object> mapForUpdateFilmDetailDs) {
		return investigationDataService
				.updateDgResultEntryHeader(mapForUpdateFilmDetailDs);
	}

	// ////////////////// For UPdate Film Size
	public Map<String, Object> getResultValidationAcceptedGrid(
			Map<String, Object> mapForDs) {
		return investigationDataService
				.getResultValidationAcceptedGrid(mapForDs);
	}

	public Map<String, Object> addSubTestWithoutAddingInMasInvestigation(
			Box box, Map dataMap) {
		return investigationDataService
				.addSubTestWithoutAddingInMasInvestigation(box, dataMap);
	}

	public Map<String, Object> getAllValidatedTestForOrder(
			Map<String, Object> requestMap) {
		return investigationDataService.getAllValidatedTestForOrder(requestMap);
	}

	public Map<String, Object> getAllResultValidatedConfidentialOrders(
			Map<String, Object> mapForDs) {
		return investigationDataService
				.getAllResultValidatedConfidentialOrders(mapForDs);
	}

	public Map<String, Object> getAllValidatedTestForLabOrder(
			Map<String, Object> requestMap) {
		return investigationDataService
				.getAllValidatedTestForLabOrder(requestMap);
	}

	public Map<String, Object> getResultEntryDetailsForMultipleResultType(
			int resultId, int deptId) {
		return investigationDataService
				.getResultEntryDetailsForMultipleResultType(resultId, deptId);
	}

	public Map<String, Object> submitResultEntryForTemplateTemparory(
			Map<String, Object> parameterMap) {
		return investigationDataService
				.submitResultEntryForTemplateTemparory(parameterMap);
	}

	public Map<String, Object> getDetailsForSearch() {
		return investigationDataService.getDetailsForSearch();
	}

	public Map<String, Object> searchProvisionalResultEntryDetails(
			Map<String, Object> requestMap) {
		return investigationDataService
				.searchProvisionalResultEntryDetails(requestMap);
	}

	public Map<String, Object> getProvisionalResultEntryDetailsForTemplate(
			int resultId, int deptId) {
		return investigationDataService
				.getProvisionalResultEntryDetailsForTemplate(resultId, deptId);
	}

	public Map<String, Object> searchFinalResultEntryDetails(
			Map<String, Object> requestMap) {
		return investigationDataService
				.searchFinalResultEntryDetails(requestMap);
	}

	public Map<String, Object> getPatientHistory(Map<String, Object> requestMap) {
		return investigationDataService.getPatientHistory(requestMap);
	}

	public Map<String, Object> getResultGridLab(Map<String, Object> mapForDs) {
		return investigationDataService.getResultGridLab(mapForDs);
	}

	public Map<String, Object> getDetailsForLab(Map<String, Object> dataMap) {
		return investigationDataService.getDetailsForLab(dataMap);
	}

	public Map<String, Object> getPatientDetailsForLab(
			Map<String, Object> mapForDs) {
		return investigationDataService.getPatientDetailsForLab(mapForDs);
	}

	public Map<String, Object> getSampleCollectionDetailsForLab(
			Map<String, Object> mapForDs) {
		return investigationDataService
				.getSampleCollectionDetailsForLab(mapForDs);
	}

	public Map<String, Object> submitResultEntryForSingleParameterOnly(
			Map<String, Object> parameterMap) {
		return investigationDataService
				.submitResultEntryForSingleParameterOnly(parameterMap);
	}

	public String generateResultNumberForLab(Map<String, Object> diagMap) {
		return investigationDataService.generateResultNumberForLab(diagMap);
	}

	public Map<String, Object> submitResultEntryForMultipleInvestigationType(
			Map<String, Object> parameterMap) {
		return investigationDataService
				.submitResultEntryForMultipleInvestigationType(parameterMap);
	}

	public Map<String, Object> getResultValidationLabGrid(
			Map<String, Object> mapForDs) {
		return investigationDataService.getResultValidationLabGrid(mapForDs);
	}

	public Map<String, Object> getPatientDetailsForResultValidationLab(
			Map<String, Object> mapForDs) {
		return investigationDataService
				.getPatientDetailsForResultValidationLab(mapForDs);
	}

	public Map<String, Object> getResultEntryDetailsLab(
			Map<String, Object> requestMap) {
		return investigationDataService.getResultEntryDetailsLab(requestMap);
	}

	public boolean submitResultValidationForSingleParameterOnly(
			Map<String, Object> infoMap) {
		return investigationDataService
				.submitResultValidationForSingleParameterOnly(infoMap);
	}

	public boolean submitResultValidationLab(Map<String, Object> infoMap) {
		return investigationDataService.submitResultValidationLab(infoMap);
	}

	public Map<String, Object> getDetailsForProvisionalReportLab(
			Map<String, Object> requestMap) {
		return investigationDataService
				.getDetailsForProvisionalReportLab(requestMap);
	}

	public Map<String, Object> getDetailsForFinalReportLab(
			Map<String, Object> requestMap) {
		return investigationDataService.getDetailsForFinalReportLab(requestMap);
	}

	public Map<String, Object> searchProvisionalResultEntryDetailsLab(
			Map<String, Object> requestMap) {
		return investigationDataService
				.searchProvisionalResultEntryDetailsLab(requestMap);
	}

	public Map<String, Object> searchFinalResultEntryDetailsLab(
			Map<String, Object> requestMap) {
		return investigationDataService
				.searchFinalResultEntryDetailsLab(requestMap);
	}

	public Map<String, Object> getResultEntryCorrectionLabGrid(
			Map<String, Object> mapForDs) {
		return investigationDataService
				.getResultEntryCorrectionLabGrid(mapForDs);
	}

	public boolean submitResultEntryLabForCorrectionMultipleType(
			Map<String, Object> infoMap) {
		return investigationDataService
				.submitResultEntryLabForCorrectionMultipleType(infoMap);
	}

	public boolean submitResultEntryForCorrectionSingleInvestigationType(
			Map<String, Object> infoMap) {
		return investigationDataService
				.submitResultEntryForCorrectionSingleInvestigationType(infoMap);
	}

	public Map<String, Object> getPatientDetailsForResultEntryModification(
			Map<String, Object> mapForDs) {
		return investigationDataService
				.getPatientDetailsForResultEntryModification(mapForDs);
	}

	public Map<String, Object> getResultEntryForModification(int resultId,
			int deptId) {
		return investigationDataService.getResultEntryForModification(resultId,
				deptId);
	}

	public boolean submitResultEntryModificationForSensitivity(
			Map<String, Object> infoMap) {
		return investigationDataService
				.submitResultEntryModificationForSensitivity(infoMap);
	}

	public boolean submitResultEntryForModificationTemplate(
			Map<String, Object> infoMap) {
		return investigationDataService
				.submitResultEntryForModificationTemplate(infoMap);
	}

	public Map<String, Object> getPatientDetailsForResultEntryModificationLab(
			Map<String, Object> mapForDs) {
		return investigationDataService
				.getPatientDetailsForResultEntryModificationLab(mapForDs);
	}

	public Map<String, Object> getDetailsForFinalReportByOrderNoLab(
			Map<String, Object> requestMap) {
		return investigationDataService
				.getDetailsForFinalReportByOrderNoLab(requestMap);
	}

	public Map<String, Object> getProvisionalReportDetailsOrderNoWiseLab(
			Map<String, Object> requestMap) {
		return investigationDataService
				.getProvisionalReportDetailsOrderNoWiseLab(requestMap);
	}

	public Map<String, Object> getAllValidatedTestForLabOrderNoWise(
			Map<String, Object> requestMap) {
		return investigationDataService
				.getAllValidatedTestForLabOrderNoWise(requestMap);

	}

	public Map<String, Object> populateAllDgresultEntryHeader(
			Map<String, Object> mapDs) {
		return investigationDataService.populateAllDgresultEntryHeader(mapDs);
	}
public Map<String, Object> showInstructionsPopupJsp(int investigationId) {
		
		return investigationDataService.showInstructionsPopupJsp(investigationId);
	}

@Override
public Map<String, Object> rejectTemplateSample(Map<String, Object> parameterMap) {
	return investigationDataService.rejectTemplateSample(parameterMap);
}

@Override
public Map<String, Object> uploadInvDocuments(Box box) {
	return investigationDataService.uploadInvDocuments(box);
}

@Override
public Map<String, Object> viewUploadInvDocuments(Map<String, Object> map) {
	return investigationDataService.viewUploadInvDocuments(map);
}

@Override
public Map<String, Object> uploadAndViewDocuments(Map<String, Object> parameterMap) {
	
	return investigationDataService.uploadAndViewDocuments(parameterMap);
}

@Override
public List<UploadDocuments> getDocumentList(int uploadedDocumentId) {
	return investigationDataService.getDocumentList(uploadedDocumentId);
}



@Override
public Map<String, Object> getResultGridEmpanelledLab(
		Map<String, Object> mapForDs) {
	return investigationDataService.getResultGridForEmpanelled(mapForDs);
}

@Override
public String getHospitalName(int hospitalId) {
	return investigationDataService.getHospitalName(hospitalId);
}

@Override
public Map<String, Object> getPendingListforRadiologyInvestigation(Box box) {
	return investigationDataService.getPendingListforRadiologyInvestigation(box);
	
	
}

@Override
public Map<String, Object> markCompleteRadiologyInvestigation(Box box) {
	return investigationDataService.markCompleteRadiologyInvestigation(box);
}

@Override
public Map<String, Object> getPatientDetailsForResultUpdationLab(
		Map<String, Object> mapForDs) {
	return investigationDataService.getPatientDetailsForResultUpdationLab(mapForDs);
}

@Override
public Map<String, Object> getResultEntryDetailsLabForUpdation(
		Map<String, Object> dataMap) {
	return investigationDataService.getResultEntryDetailsLabForUpdation(dataMap);
}

}
