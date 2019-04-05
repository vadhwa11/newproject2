package jkt.hms.investigation.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgSubMasInvestigation;
import jkt.hms.masters.business.DgTemplate;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.util.Box;

public interface InvestigationHandlerService {
	public Map<String, Object> showInvestigationJsp(Box box);

	// public Map<String, Object> showSubInvestigationJsp(Box box);
	public List<DgSubMasInvestigation> getChargeList(Box box);

	public Map<String, Object> getChargeDetails(int subChargeCodeId);

	public Map<String, Object> addSubTest(Box box, Map dataMap);

	public Map<String, Object> getResponseSubchargeList(Box box);

	public Map<String, Object> getChargeDetails(Box box);

	public Map<String, Object> getParameterDetails(Box box);

	public Map<String, Object> getNormalValueDetails(Box box);

	public boolean updateSubTest(Box box);

	public Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap);

	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs);

	public Map<String, Object> getAllDetails(Box box);

	public boolean checkInvestigationExsist(String investigationCode,
			String investigationName);

	boolean addInvestigation(DgMasInvestigation dgmasInvestigation);

	public Map<String, Object> searchInvestigation(int searchModality,
			String investigationName, int deptId);

	public boolean editInvestigation(Map<String, Object> generalMap);

	Map<String, Object> submitResultEntry(Map<String, Object> parameterMap);

	public String generateResultNumber(Map<String, Object> diagMap);

	Map<String, Object> getPatientDetailsForResultValidation(
			Map<String, Object> mapForDs);

	public Map<String, Object> getSampleCollectionDetails(
			int sampleCollectionDetailId, int deptId);

	public Map getResultList(int resultId);

	public Map<String, Object> getResultEntryDetails(int resultId, int deptId);

	public boolean submitResultValidation(Map<String, Object> infoMap);

	public Map<String, Object> getPatientDetailsForReportCollection(
			Map<String, Object> mapForDs);

	public Map<String, Object> getResultDetails(Map<String, Object> mapForDs);

	public boolean deleteInvestigation(int chargeCodeId,
			Map<String, Object> generalMap);

	Map<String, Object> submitResultEntryForSingleParameter(
			Map<String, Object> parameterMap);

	public boolean submitResultValidationForSingleParameter(
			Map<String, Object> infoMap);

	public Map<String, Object> getDetailsForResultValidation(
			Map<String, Object> dataMap);

	public Map<String, Object> getSubTestList(Box box);

	public Map<String, Object> getDetailsForReportCollection(
			Map<String, Object> dataMap);

	public Map<String, Object> getDetails(Map<String, Object> dataMap);

	public boolean submitNormalValues(Box box);

	public Map<String, Object> submitResultEntryForTemplate(
			Map<String, Object> parameterMap);

	public boolean submitResultValidationForTemplate(Map<String, Object> infoMap);

	public boolean submitFixedValues(Box box);

	public boolean submitTemplate(Map<String, Object> dataMap);

	public List<DgTemplate> getTemplateList(int chargeCodeId);

	public boolean updateTemplate(Map<String, Object> map);

	public Map<String, Object> getFixedList(Box box);

	public Map<String, Object> getResultEntryDetailsForNext(int newResultId,
			int deptId);

	public boolean updateNormalValue(Box box);

	public boolean updateFixedValues(Box box);

	public boolean updateReceivedDetails(Map<String, Object> infoMap);

	public Map<String, Object> getResultValidationGrid(
			Map<String, Object> mapForDs);

	public Map<String, Object> getResultGrid(Map<String, Object> mapForDs);

	public Map<String, Object> getResultViewGrid(Map<String, Object> mapForDs);

	public Map<String, Object> getPatientDetailsForResultValidationOrderNo(
			Map<String, Object> mapForDs);

	public Map<String, Object> getConnectionForReport();

	public Map<String, Object> getResultEntryForNext(int newSampleCollectionId,
			int deptId);

	public Map<String, Object> getResultEntryDetailsForTemplate(
			String resultNo, int deptId);

	public boolean updateResultTemplateForValidation(Map<String, Object> dataMap);

	// -------------------------------Start Methods developed by Vivek
	// --------------------------------------

	Map<String, Object> getOrganismList(Map<String, Object> dataMap);

	Map<String, Object> getResultOrganismList(Map<String, Object> dataMap);

	Map<String, Object> getSensitivityList(Map<String, Object> dataMap);

	Map<String, Object> getResultSensitivityList(Map<String, Object> dataMap);

	Map<String, Object> saveSensitivity(Map<String, Object> dataMap);

	boolean submitResultValidationForSensitivity(Map<String, Object> infoMap);

	// -------------------------------End Methods developed by
	// Vivek------------------------------------------

	public Map updateDgResultEntryHeader(
			Map<String, Object> mapForUpdateFilmDetailDs);

	Map<String, Object> getResultValidationAcceptedGrid(
			Map<String, Object> mapForDs);

	Map<String, Object> addSubTestWithoutAddingInMasInvestigation(Box box,
			Map dataMap);

	Map<String, Object> getAllValidatedTestForOrder(
			Map<String, Object> requestMap);

	Map<String, Object> getAllResultValidatedConfidentialOrders(
			Map<String, Object> mapForDs);

	Map<String, Object> getAllValidatedTestForLabOrder(
			Map<String, Object> requestMap);

	Map<String, Object> getResultEntryDetailsForMultipleResultType(
			int resultId, int deptId);

	Map<String, Object> submitResultEntryForTemplateTemparory(
			Map<String, Object> parameterMap);

	Map<String, Object> getDetailsForSearch();

	Map<String, Object> searchProvisionalResultEntryDetails(
			Map<String, Object> requestMap);

	Map<String, Object> getProvisionalResultEntryDetailsForTemplate(
			int resultId, int deptId);

	Map<String, Object> searchFinalResultEntryDetails(
			Map<String, Object> requestMap);

	Map<String, Object> getPatientHistory(Map<String, Object> requestMap);

	Map<String, Object> getResultGridLab(Map<String, Object> mapForDs);

	Map<String, Object> getDetailsForLab(Map<String, Object> dataMap);

	Map<String, Object> getPatientDetailsForLab(Map<String, Object> mapForDs);

	Map<String, Object> getSampleCollectionDetailsForLab(
			Map<String, Object> mapForDs);

	Map<String, Object> submitResultEntryForSingleParameterOnly(
			Map<String, Object> parameterMap);

	String generateResultNumberForLab(Map<String, Object> diagMap);

	Map<String, Object> submitResultEntryForMultipleInvestigationType(
			Map<String, Object> parameterMap);

	Map<String, Object> getResultValidationLabGrid(Map<String, Object> mapForDs);

	Map<String, Object> getPatientDetailsForResultValidationLab(
			Map<String, Object> mapForDs);

	Map<String, Object> getResultEntryDetailsLab(Map<String, Object> requestMap);

	boolean submitResultValidationForSingleParameterOnly(
			Map<String, Object> infoMap);

	boolean submitResultValidationLab(Map<String, Object> infoMap);

	Map<String, Object> getDetailsForProvisionalReportLab(
			Map<String, Object> requestMap);

	Map<String, Object> getDetailsForFinalReportLab(
			Map<String, Object> requestMap);

	Map<String, Object> searchProvisionalResultEntryDetailsLab(
			Map<String, Object> requestMap);

	Map<String, Object> searchFinalResultEntryDetailsLab(
			Map<String, Object> requestMap);

	Map<String, Object> getResultEntryCorrectionLabGrid(
			Map<String, Object> mapForDs);

	boolean submitResultEntryLabForCorrectionMultipleType(
			Map<String, Object> infoMap);

	boolean submitResultEntryForCorrectionSingleInvestigationType(
			Map<String, Object> infoMap);

	Map<String, Object> getPatientDetailsForResultEntryModification(
			Map<String, Object> mapForDs);

	Map<String, Object> getResultEntryForModification(int resultId, int deptId);

	boolean submitResultEntryModificationForSensitivity(
			Map<String, Object> infoMap);

	boolean submitResultEntryForModificationTemplate(Map<String, Object> infoMap);

	Map<String, Object> getPatientDetailsForResultEntryModificationLab(
			Map<String, Object> mapForDs);

	Map<String, Object> getDetailsForFinalReportByOrderNoLab(
			Map<String, Object> requestMap);

	Map<String, Object> getProvisionalReportDetailsOrderNoWiseLab(
			Map<String, Object> requestMap);

	Map<String, Object> getAllValidatedTestForLabOrderNoWise(
			Map<String, Object> requestMap);

	Map<String, Object> populateAllDgresultEntryHeader(Map<String, Object> mapDs);
	public Map<String, Object> showInstructionsPopupJsp(int investigationId);

	public Map<String, Object> rejectTemplateSample(
			Map<String, Object> parameterMap);

	public Map<String, Object> uploadInvDocuments(Box box);

	public Map<String, Object> viewUploadInvDocuments(Map<String, Object> map);

	public Map<String, Object> uploadAndViewDocuments(Map<String, Object> details);

	public Map<String, Object> getResultGridEmpanelledLab(Map<String, Object> mapForDs);
	
	public List<UploadDocuments> getDocumentList(int uploadedDocumentId);

	public String getHospitalName(int hospitalId);

	public Map<String, Object> getPendingListforRadiologyInvestigation(Box box);

	public Map<String, Object> markCompleteRadiologyInvestigation(Box box);

	public Map<String, Object> getPatientDetailsForResultUpdationLab(
			Map<String, Object> mapForDs);

	public Map<String, Object> getResultEntryDetailsLabForUpdation(
			Map<String, Object> dataMap);
}
