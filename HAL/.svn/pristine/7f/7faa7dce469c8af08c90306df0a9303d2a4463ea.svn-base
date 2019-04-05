package jkt.hms.fwc.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public interface FWCHandlerService {

	Map<String, Object> getWaitingPatientList(Map mapForDS);
	Map<String, Object> searchWaitingPatientList(Map map);
	Map<String, Object> getPatientDetails(int visitId);
	Map<String, Object> showAntCardJsp(Map<String, Object> dataMap);
	Map<String, Object> submitAntenatalCard(Box box,
			Map<String, Object> mapForDS);
	Map<String, Object> showFwcUploadViewDocumentJsp(Map<String, Object> dataMap);
	Map<String, Object> submitFwcUploadDocuments(Box box);
	Map<String, Object> viewFwcPatientDetails(Map<String, Object> map);
	Map<String, Object> getPNCDataList(Map<String, Object> mapForDS);
	Map<String, Object> submitPncPatientDetails(Map<String, Object> mapForDS,
			Box box);
	Map<String, Object> showPediatricJsp(Map<String, Object> dataMap);
	Map<String, Object> submitPediatricsDetail(Box box,Map<String, Object> mapForDS);
	Map<String, Object> getImmunizationId(Box box);
	Map<String, Object> showFamilyPlanningJsp(Map<String, Object> generalMap);
	Map<String, Object> submitfamilyPlanningDetails(Box box, Map<String, Object> generalMap);
	Map<String, Object> showSterilisationWaitinglistJsp(
			Map<String, Object> generalMap);
	Map<String, Object> showImmunisationJsp(Map<String, Object> dataMap);
	Map<String, Object> submitFwcImmunizationDetail(
			Map<String, Object> mapForDS);
	Map<String, Object> printHealthCard(Map<String, Object> requestParameters);
	Map<String, Object> forwardToMoFamilyPlanning(Box box);
	Map<String, Object> showIssueSterilizationCertificateJsp(Box box);
	Map<String, Object> getConnectionForReport();
	Map<String, Object> issueSterilisationCertificate(Box box);
	Map<String, Object> showAntentatalCardJsp(Map<String, Object> dataMap);
	Map<String, Object> submitAntenatalCardFollowUp(Box box,
			Map<String, Object> infoMap);
	Map<String, Object> viewUlterSoundTestForOrderNo(
			Map<String, Object> mapForDs);
	Map<String, Object> viewOtherInvTestForOrderNo(Map<String, Object> mapForDs);
	Map<String, Object> displayVaccine(Map<String, Object> dataMap);
	
	Map<String, Object> printHealthCardHeight(Map<String, Object> requestParameters);
	
	Map<String, Object> printHealthCardHeadCircumference(Map<String, Object> requestParameters);
	
	Map<String, Object> printHealthCardB(Map<String, Object> requestParameters);
	
	Map<String, Object> printHealthCardHeightB(Map<String, Object> requestParameters);
	
	Map<String, Object> printHealthCardHeadCircumferenceB(Map<String, Object> requestParameters);
	Map<String, Object> displayGrowthChartValue(Map<String, Object> dataMap);
	
	Map<String, Object> displayFileUploadData(Map<String, Object> dataMap);
	Map<String, Object> submitUploadDocumentsInvestForMedicalExam(
			Map<String, Object> dataMap);
	Map<String, Object> getUploadDocumentInvestigationDetails(Map<String, Object> dataMap);
	Map<String, Object> getUploadDocumentMedicalExamInvestigationData(Map<String, Object> dataMap);
	
	//-------------------- By Mansi on 30 April 2013
	
	Map<String, Object> showRegForIUD(Box box);
	
	Map<String, Object> getPatientDetails(Box box);
	
	Map<String, Object> getPatientDetailsFordirectVisitEntry(String serviceNo);
	
	Map<String, Object> saveRegisterForIUD(Box box);
	
	Map<String, Object> showRegisterForIUDReportJsp(int hospitalId);
	
	Map<String, Object> showAntentatalCardFollowUpJsp(Map<String, Object> dataMap);
	
	Map<String, Object> showDeliveryDetails(Map<String, Object> dataMap);
	
	Map<String, Object> submitDeliveryDetails(Box box,Map<String, Object> mapForDS);
	


}