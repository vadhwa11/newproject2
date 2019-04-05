package jkt.hms.fwc.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.fwc.handler.FWCHandlerService;
import jkt.hms.fwc.dataservice.FWCDataService;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public class FWCHandlerServiceImpl implements FWCHandlerService{

	FWCDataService fwcDataService = null;
	
	public FWCDataService getFwcDataService() {
		return fwcDataService;
	}

	public void setFwcDataService(FWCDataService fwcDataService) {
		this.fwcDataService = fwcDataService;
	}

	public Map<String, Object> getWaitingPatientList(Map mapForDS) {
		return fwcDataService.getWaitingPatientList(mapForDS);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchWaitingPatientList(Map map) {
		return fwcDataService.searchWaitingPatientList(map);
	}

	public Map<String, Object> getPatientDetails(int visitId) {
		return fwcDataService.getPatientDetails(visitId);
	}

	@Override
	public Map<String, Object> showAntCardJsp(Map<String, Object> dataMap) {
	
		return fwcDataService.showAntCardJsp(dataMap);
	}

	@Override
	public Map<String, Object> submitAntenatalCard(Box box,
			Map<String, Object> mapForDS) {
		
		return fwcDataService.submitAntenatalCard(box,mapForDS);
	}

	@Override
	public Map<String, Object> showFwcUploadViewDocumentJsp(Map<String, Object> dataMap) {
		
		return fwcDataService.showFwcUploadViewDocumentJsp(dataMap);
	}

	@Override
	public Map<String, Object> submitFwcUploadDocuments(Box box) {
		
		return fwcDataService.submitFwcUploadDocuments(box);
	}

	@Override
	public Map<String, Object> viewFwcPatientDetails(Map<String, Object> map) {
		
		return fwcDataService.viewFwcPatientDetails(map);
	}

	@Override
	public Map<String, Object> getPNCDataList(Map<String, Object> mapForDS) {
		
		return fwcDataService.getPNCDataList(mapForDS);
	}

	@Override
	public Map<String, Object> submitPncPatientDetails(Map<String, Object> mapForDS, Box box) {
		
		return fwcDataService.submitPncPatientDetails(mapForDS, box);
	}

	@Override
	public Map<String, Object> showPediatricJsp(Map<String, Object> dataMap) {
		
		return fwcDataService.showPediatricJsp(dataMap);
	}

	@Override
	public Map<String, Object> submitPediatricsDetail(Box box,Map<String, Object> mapForDS) {
		
		return fwcDataService.submitPediatricsDetail(box,mapForDS);
	}

	@Override
	public Map<String, Object> getImmunizationId(Box box) {
		
		return fwcDataService.getImmunizationId(box);
	}

	@Override
	public Map<String, Object> showFamilyPlanningJsp(Map<String, Object> generalMap) {
		
		return fwcDataService.showFamilyPlanningJsp(generalMap);
	}

	@Override
	public Map<String, Object> submitfamilyPlanningDetails(Box box,
			Map<String, Object> generalMap) {
		
		return fwcDataService.submitfamilyPlanningDetails(box,generalMap);
	}

	@Override
	public Map<String, Object> showSterilisationWaitinglistJsp(
			Map<String, Object> generalMap) {
	
		return fwcDataService.showSterilisationWaitinglistJsp(generalMap);
	}

	@Override
	public Map<String, Object> showImmunisationJsp(Map<String, Object> dataMap) {
		
		return fwcDataService.showImmunisationJsp(dataMap);
	}

	@Override
	public Map<String, Object> submitFwcImmunizationDetail(
			Map<String, Object> mapForDS) {
		
		return fwcDataService.submitFwcImmunizationDetail(mapForDS);
	}

	@Override
	public Map<String, Object> printHealthCard(Map<String, Object> requestParameters) {
		
		return fwcDataService.printHealthCard(requestParameters);
	}

	@Override
	public Map<String, Object> forwardToMoFamilyPlanning(Box box) {
		return fwcDataService.forwardToMoFamilyPlanning(box);
	}

	@Override
	public Map<String, Object> showIssueSterilizationCertificateJsp(Box box) {
		return fwcDataService.showIssueSterilizationCertificateJsp(box);
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		return fwcDataService.getConnectionForReport();
	}

	@Override
	public Map<String, Object> issueSterilisationCertificate(Box box) {
		return fwcDataService.issueSterilisationCertificate(box);
	}

	@Override
	public Map<String, Object> showAntentatalCardJsp(Map<String, Object> dataMap) {
		return fwcDataService.showAntentatalCardJsp(dataMap);
	}

	@Override
	public Map<String, Object> submitAntenatalCardFollowUp(
			Box box,Map<String, Object> infoMap) {
		return fwcDataService.submitAntenatalCardFollowUp(box,infoMap);
	}

	@Override
	public Map<String, Object> viewUlterSoundTestForOrderNo(
			Map<String, Object> mapForDs) {
		return fwcDataService.viewUlterSoundTestForOrderNo(mapForDs);
	}


	@Override
	public Map<String, Object> viewOtherInvTestForOrderNo(
			Map<String, Object> mapForDs) {
		return fwcDataService.viewOtherInvTestForOrderNo(mapForDs);
	}

	@Override
	public Map<String, Object> displayVaccine(Map<String, Object> dataMap) {
	
		return fwcDataService.displayVaccine(dataMap);
	}

	@Override
	public Map<String, Object> printHealthCardHeadCircumference(
			Map<String, Object> requestParameters) {
		return fwcDataService.printHealthCardHeadCircumference(requestParameters);
	}

	@Override
	public Map<String, Object> printHealthCardHeight(
			Map<String, Object> requestParameters) {
		return fwcDataService.printHealthCardHeight(requestParameters);
	}
	
	@Override
	public Map<String, Object> printHealthCardB(Map<String, Object> requestParameters) {
		
		return fwcDataService.printHealthCardB(requestParameters);
	}
	
	@Override
	public Map<String, Object> printHealthCardHeadCircumferenceB(
			Map<String, Object> requestParameters) {
		return fwcDataService.printHealthCardHeadCircumferenceB(requestParameters);
	}

	@Override
	public Map<String, Object> printHealthCardHeightB(
			Map<String, Object> requestParameters) {
		return fwcDataService.printHealthCardHeightB(requestParameters);
	}

	@Override
	public Map<String, Object> displayGrowthChartValue(Map<String, Object> dataMap) {
	
		return fwcDataService.displayGrowthChartValue(dataMap);
	}

	@Override
	public Map<String, Object> displayFileUploadData(Map<String, Object> dataMap) {
		return fwcDataService.displayFileUploadData(dataMap);
	}

	@Override
	public Map<String, Object> getUploadDocumentInvestigationDetails(
			Map<String, Object> dataMap) {
		return fwcDataService.getUploadDocumentInvestigationDetails(dataMap);
	}

	@Override
	public Map<String, Object> getUploadDocumentMedicalExamInvestigationData(
			Map<String, Object> dataMap) {
		return fwcDataService.getUploadDocumentMedicalExamInvestigationData(dataMap);
	}

	@Override
	public Map<String, Object> submitUploadDocumentsInvestForMedicalExam(
			Map<String, Object> dataMap) {
		return fwcDataService.submitUploadDocumentsInvestForMedicalExam(dataMap);
	}

	
//-------------------- By Mansi on 30 April 2013
	

	@Override
	public Map<String, Object> showRegForIUD(Box box) {
		return fwcDataService.showRegForIUD(box);
	}

	@Override
	public Map<String, Object> getPatientDetails(Box box) {
		return fwcDataService.getPatientDetails(box);
	}

	@Override
	public Map<String, Object> getPatientDetailsFordirectVisitEntry(
			String serviceNo) {
		return fwcDataService.getPatientDetailsFordirectVisitEntry(serviceNo);
	}

	@Override
	public Map<String, Object> saveRegisterForIUD(Box box) {
		return fwcDataService.saveRegisterForIUD(box);
	}

	@Override
	public Map<String, Object> showRegisterForIUDReportJsp(int hospitalId) {
		return fwcDataService.showRegisterForIUDReportJsp(hospitalId);
	}

	@Override
	public Map<String, Object> showAntentatalCardFollowUpJsp(
			Map<String, Object> dataMap) {
		return fwcDataService.showAntentatalCardFollowUpJsp(dataMap);
	}

	@Override
	public Map<String, Object> showDeliveryDetails(Map<String, Object> dataMap) {
		return fwcDataService.showDeliveryDetails(dataMap);
	}

	@Override
	public Map<String, Object> submitDeliveryDetails(Box box,
			Map<String, Object> mapForDS) {
		return fwcDataService.submitDeliveryDetails(box, mapForDS);
	}



}