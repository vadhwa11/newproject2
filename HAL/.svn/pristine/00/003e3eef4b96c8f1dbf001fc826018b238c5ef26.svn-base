package jkt.hms.adt.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jkt.hms.adt.dataservice.RegistrationDataService;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public class RegistrationHandlerServiceImpl implements
		RegistrationHandlerService {

	RegistrationDataService registrationDataService = null;

	public Map<String, Object> showRegistrationJsp(int hospitalId) {
		return registrationDataService.showRegistrationJsp(hospitalId);
	}
	
	public Map<String, Object> showRegistrationJspOtherPatient(int hospitalId) {
		return registrationDataService.showRegistrationJspOtherPatient(hospitalId);
	}
	
	public Map<String, Object> getDepartmentList(int hospitalId) {
		return registrationDataService.getDepartmentList(hospitalId);
	}

	public Map<String, Object> submitPatientInformation(
			Map<String, Object> objectMap) {
		return registrationDataService.submitPatientInformation(objectMap);
	}
	
	public Map<String, Object> submitPatientInformationEmployeeVisit(
			Map<String, Object> objectMap, HttpServletRequest request) {
		return registrationDataService.submitPatientInformationEmployeeVisit(objectMap, request);
	}
	
	public Map<String, Object> submitPatientInformationOnlineEmployeeVisit(
			Map<String, Object> objectMap) {
		return registrationDataService.submitPatientInformationOnlineEmployeeVisit(objectMap);
	}
	
	public Map<String, Object> cancleOnlineAppointment(
			Map<String, Object> objectMap) {
		return registrationDataService.cancleOnlineAppointment(objectMap);
	}
	
	public Map<String, Object> submitPatientInformationHAL(
			Map<String, Object> objectMap) {
		return registrationDataService.submitPatientInformationHAL(objectMap);
	}
	
	public Map<String, Object> updateOtherPatientInformation(
			Map<String, Object> objectMap) {
		return registrationDataService.updateOtherPatientInformation(objectMap);
	}
	
	public Map<String, Object> submitPatientInformationOtherPatientVisit(
			Map<String, Object> objectMap, HttpServletRequest request) {
		return registrationDataService.submitPatientInformationOtherPatientVisit(objectMap, request);
	}


	public String getHinId(String serviceNo, int serviceTypeId) {
		return registrationDataService.getHinId(serviceNo, serviceTypeId);
	}
	
	public String getHinIdHAL(String patientCode, HttpServletRequest request) {
		return registrationDataService.getHinIdHAL(patientCode, request);
	}

	public Map<String, Object> getVisitDetails() {
		return registrationDataService.getVisitDetails();
	}

	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		return registrationDataService.getPatientDetails(mapForDs);
	}

	public Map<String, Object> saveVisitInformation(Map<String, Object> mapForDs) {
		return registrationDataService.saveVisitInformation(mapForDs);
	}

	public Map<String, Object> updateVisitDetails(
			Map<String, Object> parameterMap) {
		return registrationDataService.updateVisitDetails(parameterMap);
	}

	public Map<String, Object> getUpdateRegistrationDetails() {
		return registrationDataService.getUpdateRegistrationDetails();
	}

	public boolean updateRegistrationInformation(Map<String, Object> mapForDs) {
		return registrationDataService.updateRegistrationInformation(mapForDs);
	}

	public Map<String, Object> getServiceTypeAndRelation(
			Map<String, Object> parameterMap) {
		return registrationDataService.getServiceTypeAndRelation(parameterMap);
	}
	
	public Map<String, Object> showPendingOtherVisitJsp(Box box) {
		return registrationDataService.showPendingOtherVisitJsp(box);
		
	}
	public Map<String, Object> getListOfPendingForApproval(Box box) {
		return registrationDataService.getListOfPendingForApproval(box);
		
	}
	
	public Map<String, Object> showOtherVisitJsp(int hospitalId) {
		return registrationDataService.showOtherVisitJsp(hospitalId);
		
	}
	
	public Map<String, Object> getListOfPatientVisitReferral(Box box) {
		return registrationDataService.getListOfPatientVisitReferral(box);
		
	}
	
	public Map<String, Object> getListOnlinePatients(Box box) {
		return registrationDataService.getListOnlinePatients(box);
		
	}
	
	public Map<String, Object> getPatientTypeCodeAndRelationCode(
			HttpServletRequest request) {
		return registrationDataService.getPatientTypeCodeAndRelationCode(request);
	}
	
	public Map<String, Object> submitPendingForApproval(
			HttpServletRequest request) {
		return registrationDataService.submitPendingForApproval(request);
	}
	public Map<String, Object> submitReferral(
			HttpServletRequest request) {
		return registrationDataService.submitReferral(request);
	}
	
	public String getMothersName(String motherHinNo) {
		return registrationDataService.getMothersName(motherHinNo);
	}

	public Map<String, Object> getConnectionForReport() {
		return registrationDataService.getConnectionForReport();
	}

	public String getTokenNoForDepartment(int departmentId, int sessionId, int deptId, HttpServletRequest request) {
		return registrationDataService.getTokenNoForDepartment(departmentId, sessionId, deptId, request);
	}

	public Map<String, Object> getPatientListForName(
			Map<String, Object> parameterMap) {
		return registrationDataService.getPatientListForName(parameterMap);
	}
	
	public Map<String, Object> getPatientListForNameHAL(
			Map<String, Object> parameterMap) {
		return registrationDataService.getPatientListForNameHAL(parameterMap);
	}

	public List<Object[]> getHinNoList(String serviceNo) {
		return registrationDataService.getHinNoList(serviceNo);
	}

	public Map<String, Object> getPatientDetailsForUpdate(
			Map<String, Object> parameterMap) {
		return registrationDataService.getPatientDetailsForUpdate(parameterMap);
	}

	public List<Visit> getVisitNo(String hinNo) {
		return registrationDataService.getVisitNo(hinNo);
	}

	public Map<String, Object> getPatientVisitDetailsForUpdate(
			Map<String, Object> parameterMap) {
		return registrationDataService
				.getPatientVisitDetailsForUpdate(parameterMap);
	}

	public boolean updateVisitInformation(Map<String, Object> parameterMap) {
		return registrationDataService.updateVisitInformation(parameterMap);
	}

	public Map<String, Object> getDetailsForVisit() {
		return registrationDataService.getDetailsForVisit();
	}

	public Map<String, Object> getServicePersonName(String serviceNo,
			int serviceTypeId) {
		return registrationDataService.getServicePersonName(serviceNo,
				serviceTypeId);
	}
	
	public Map<String, Object> responseForVisitOfHALEmployees(String serviceNo,
			int serviceTypeId, int hospitalId) {
		return registrationDataService.responseForVisitOfHALEmployees(serviceNo,
				serviceTypeId, hospitalId);
	}
	
	public Map<String, Object> getServicePersonNameHAL(String serviceNo,
			int serviceTypeId) {
		return registrationDataService.getServicePersonNameHAL(serviceNo,
				serviceTypeId);
	}

	// -----------------------------------------------------------------

	public RegistrationDataService getRegistrationDataService() {
		return registrationDataService;
	}

	public void setRegistrationDataService(
			RegistrationDataService registrationDataService) {
		this.registrationDataService = registrationDataService;
	}

	public Map<String, Object> getVisitData(Map<String, Object> dataMap) {

		return registrationDataService.getVisitData(dataMap);
	}

	public Map<String, Object> getTokenNo(Map<String, Object> dataMap) {
		return registrationDataService.getTokenNo(dataMap);
	}

	public Map<String, Object> populatePatientDetails(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return registrationDataService.populatePatientDetails(dataMap);
	}
	
	public Map<String, Object> populatePatientDetailsHAL(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return registrationDataService.populatePatientDetailsHAL(dataMap);
	}

	public Map<String, Object> getAdmissionNoList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return registrationDataService.getAdmissionNoList(dataMap);
	}

	public List<Visit> checkPatientVisit(Box box) {
		return registrationDataService.checkPatientVisit(box);
	}

	public String getConsulationRoom(int consultingDoctor) {
		return registrationDataService.getConsulationRoom(consultingDoctor);
	}

	public Map<String, Object> getAdmissionDetails() {
		// TODO Auto-generated method stub
		return registrationDataService.getAdmissionDetails();
	}

	public Map<String, Object> getAppointmentTypeNoneList(
			Map<String, Object> mapForDs) {
		return registrationDataService.getAppointmentTypeNoneList(mapForDs);
	}

	public boolean addTrade(MasTrade masTrade, String ss) {
		// TODO Auto-generated method stub
		return registrationDataService.addTrade(masTrade, ss);
	}

	public Map<String, Object> addPhotoFile(Map<String, Object> generalMap) {
		return registrationDataService.addPhotoFile(generalMap);
	}

	public Map<String, Object> displayRegisPhoto(String hinNo) {
		return registrationDataService.displayRegisPhoto(hinNo);
	}

	public Map<String, Object> showAircraftEmergencyJsp(int hospitalId) {
		return registrationDataService.showAircraftEmergencyJsp(hospitalId);
	}

	public Map<String, Object> saveEmergencyPerformaDetails(Box box) {
		return registrationDataService.saveEmergencyPerformaDetails(box);
	}

	public Map<String, Object> showMHReferralRegisterJsp(Box box) {
		return registrationDataService.showMHReferralRegisterJsp(box);
	}

	public Map<String, Object> showPatientDetailsForServiceNo(Box box) {
		return registrationDataService.showPatientDetailsForServiceNo(box);
	}

	public Map<String, Object> saveMHReferralRegisterDetails(Box box) {
		return registrationDataService.saveMHReferralRegisterDetails(box) ;
	}

	public Map<String, Object> getServiceNoDetailsForReg(Box box) {
		return registrationDataService.getServiceNoDetailsForReg(box) ;
	}
	
	public Map<String, Object> getServiceNoDetailsForRegHAL(Box box) {
		return registrationDataService.getServiceNoDetailsForRegHAL(box) ;
	}

	public Map<String, Object> getServPersonPatientDetails(Box box) {
		return registrationDataService.getServPersonPatientDetails(box);
	}

	public Map<String, Object> getSrPhoto(Box box) {
		return registrationDataService.getSrPhoto(box);
	}

	public Map<String, Object> getMhReferralDetailsForEdit(Box box) {
		return registrationDataService.getMhReferralDetailsForEdit(box);
	}

	public Map<String, Object> updateMHReferralRegisterDetails(Box box) {
		return registrationDataService.updateMHReferralRegisterDetails(box);
	}

	public Map<String, Object> getPatientInfoForVisit(Box box) {
		return registrationDataService.getPatientInfoForVisit(box);
	}

	public Map<String, Object> getPatientInfoForVisitHAL(Box box) {
		return registrationDataService.getPatientInfoForVisitHAL(box);
	}

	public Map<String, Object> getOutPatientHinNo(Box box) {
		return registrationDataService.getOutPatientHinNo(box);
	}

	@Override
	public Map<String, Object> getDetailsForDMOCallRegister(int hospitalId) {
		return registrationDataService.getDetailsForDMOCallRegister(hospitalId);
	}

	@Override
	public Map<String, Object> saveDMOCallRegisterDetails(Box box) {
		return registrationDataService.saveDMOCallRegisterDetails(box);
	}

	@Override
	public Map<String, Object> showAmbulanceRunRegister() {
		return registrationDataService.showAmbulanceRunRegister();
	}

	@Override
	public Map<String, Object> saveAmbulanceRunRegisterDetails(Box box) {
		return registrationDataService.saveAmbulanceRunRegisterDetails(box);
	}

	@Override
	public Map<String, Object> showDMARegister(Map<String, Object> dataMap) {
		return registrationDataService.showDMARegister(dataMap);
	}

	@Override
	public Map<String, Object> updatePatientImage(Map<String, Object> mapDetails) {
		return registrationDataService.updatePatientImage(mapDetails);
	}

	@Override
	public Map<String, Object> getItemBatch(Box box) {
		return registrationDataService.getItemBatch(box);
	}

	@Override
	public Map<String, Object> saveDmaRegisterDetails(Box box) {
		return registrationDataService.saveDmaRegisterDetails(box);
	}

	@Override
	public Map<String, Object> getHinNoForDMA(Box box) {
		return registrationDataService.getHinNoForDMA(box);
	}

	@Override
	public Map<String, Object> getHinNoForMinorSurgery(Box box) {
		return registrationDataService.getHinNoForMinorSurgery(box);
	}

	@Override
	public Map<String, Object> getPatientDetailsForMinorSurgery(Box box) {
		return registrationDataService.getPatientDetailsForMinorSurgery(box);
	}

	@Override
	public Map<String, Object> saveMinorSurgeryDetails(Box box) {
		return registrationDataService.saveMinorSurgeryDetails(box);
	}

	@Override
	public List<Visit> getVisitNoForMinorSurgery(int hinId) {
		return registrationDataService.getVisitNoForMinorSurgery(hinId);
	}

	@Override
	public Map<String, Object> showECGRecordJsp(int hospitalId) {
		return registrationDataService.showECGRecordJsp(hospitalId);
	}

	@Override
	public Map<String, Object> saveECGRecordDetails(Box box) {
		return registrationDataService.saveECGRecordDetails(box);
	}

	@Override
	public Map<String, Object> saveInjectionRegisterDetails(Box box) {
		return registrationDataService.saveInjectionRegisterDetails(box);
	}

	@Override
	public Map<String, Object> getInjectionListForAutoComplete(Map<String, Object> map) {
		return registrationDataService.getInjectionListForAutoComplete(map);
	}

	@Override
	public Map<String, Object> savePatientDetentionDetails(Box box) {
		return registrationDataService.savePatientDetentionDetails(box);
	}

	@Override
	public Map<String, Object> getServiceNoDetailsFromHIC(Box box) {
		return registrationDataService.getServiceNoDetailsFromHIC(box);
	}

	@Override
	public Map<String, Object> getMedExamForHICUpdate() {
		return registrationDataService.getMedExamForHICUpdate();
	}

	@Override
	public Map<String, Object> getProcedureForAutoComplete(Map<String, Object> map) {
		return registrationDataService.getProcedureForAutoComplete(map);
	}

	@Override
	public Map<String, Object> getPendingProcedureList(Box box) {
		return registrationDataService.getPendingProcedureList(box) ;
	}

	@Override
	public Map<String, Object> getDetailsForProcWaitList(int hospitalId) {
		return registrationDataService.getDetailsForProcWaitList(hospitalId);
	}

	@Override
	public Map<String, Object> getPendingProcedureDetails(Box box) {
		return registrationDataService.getPendingProcedureDetails(box);
	}

	@Override
	public Map<String, Object> showMHReferralRegisterReportJsp(int hospitalId) {
		return registrationDataService.showMHReferralRegisterReportJsp(hospitalId);
	}

	@Override
	public Map<String, Object> showAmbulanceRegisterReportJsp(int hospitalId) {
		return registrationDataService.showAmbulanceRegisterReportJsp(hospitalId);
	}

	@Override
	public Map<String, Object> getPendingDetentionList(Box box) {
		return registrationDataService.getPendingDetentionList(box) ;
	}

	@Override
	public Map<String, Object> getPendingDetentionDetails(Box box) {
		return registrationDataService.getPendingDetentionDetails(box);
	}

	@Override
	public Map<String, Object> getDoctorList(int hospitalId) {
		return registrationDataService.getDoctorList(hospitalId);
	}

	@Override
	public Map<String, Object> getPendingInjectionList(Box box) {
		return registrationDataService.getPendingInjectionList(box);
	}

	@Override
	public Map<String, Object> getInjectionDetails(Box box) {
		return registrationDataService.getInjectionDetails(box);
	}

	@Override
	public Map<String, Object> getDetailsForReport(int hospitalId) {
		return registrationDataService.getDetailsForReport(hospitalId);
	}

	@Override
	public Map<String, Object> getOPDRegisterData(Box box) {
		return registrationDataService.getOPDRegisterData(box);
	}
	
	@Override
	public Map<String, Object> showOPDStatisticsGraph(Box box) {
		return registrationDataService.showOPDStatisticsGraph(box);
	}

	@Override
	public Map<String, Object> showPrintAircraftEmergencyRegisterReport(
			Box box) {
		return registrationDataService.showPrintAircraftEmergencyRegisterReport(box);
	}

	@Override
	public Map<String, Object> showOtherEmeregencyReportOnScreen(Box box) {

		return registrationDataService.showOtherEmeregencyReportOnScreen(box);
	}

	@Override
	public Map<String, Object> showPrintMHReferralRegisterReport(Box box) {
		return registrationDataService.showPrintMHReferralRegisterReport(box);
	}

	@Override
	public Map<String, Object> showPrintAmbulanceRegisterReport(Box box) {
		return registrationDataService.showPrintAmbulanceRegisterReport(box);
	}

	@Override
	public Map<String, Object> showPrintProcedureRegisterReport(Box box) {
		return registrationDataService.showPrintProcedureRegisterReport(box);
	}

	@Override
	public Map<String, Object> showprintDetentionRegisterReport(Box box) {
		return registrationDataService.showprintDetentionRegisterReport(box);
	}

	@Override
	public Map<String, Object> getItemId(Box box) {
		return registrationDataService.getItemId(box);
	}

/*	@Override
	public Map<String, Object> submitDMAStockDetails(Box box) {
		return registrationDataService.submitDMAStockDetails(box) ;
	}*/

	@Override
	public Map<String, Object> showMHReferralGraph(Box box) {
		return registrationDataService.showMHReferralGraph(box) ;
	}

	@Override
	public Map<String, Object> showProcedureGraph(Box box) {
		return registrationDataService.showProcedureGraph(box) ;
	}

	@Override
	public Map<String, Object> showAmbulanceRegisterGraph(Box box) {
		return registrationDataService.showAmbulanceRegisterGraph(box);
	}

	@Override
	public Map<String, Object> showAircraftRegisterGraph(Box box) {
		return registrationDataService.showAircraftRegisterGraph(box);
	}

	@Override
	public Map<String, Object> saveUnwillingnessCertificate(Box box) {
		return registrationDataService.saveUnwillingnessCertificate(box);
	}

	@Override
	public Map<String, Object> showOtherEmergencyGraph(Box box) {
		return registrationDataService.showOtherEmergencyGraph(box);
	}

	@Override
	public Map<String, Object> showDetentionRegisterGraph(Box box) {
		return registrationDataService.showDetentionRegisterGraph(box) ;
	}

	@Override
	public Map<String, Object> showInjectionRegisterGraph(Box box) {
		return registrationDataService.showInjectionRegisterGraph(box);
	}

	@Override
	public Map<String, Object> showPrintInjectionRegisterReport(Box box) {
		return registrationDataService.showPrintInjectionRegisterReport(box) ;
	}

	@Override
	public Map<String, Object> getImmunizationForAutoComplete(Map<String, Object> map) {
		return registrationDataService.getImmunizationForAutoComplete(map);
	}

	@Override
	public Map<String, Object> getImmunizationId(Box box) {
		return registrationDataService.getImmunizationId(box);
	}

	@Override
	public Map<String, Object> getInjectionDetailsForAppointment(Box box) {
		return registrationDataService.getInjectionDetailsForAppointment(box);
	}

	@Override
	public Map<String, Object> saveInjectionAppointment(Box box) {
		return registrationDataService.saveInjectionAppointment(box);
	}

	@Override
	public Map<String, Object> getInjectionAppointmentDetails(Box box) {
		return registrationDataService.getInjectionAppointmentDetails(box);
	}

	@Override
	public Map<String, Object> getPatientImmunizationDetails(int hinId) {
		return registrationDataService.getPatientImmunizationDetails(hinId);
	}

	@Override
	public Map<String, Object> getPatientAllergyDetails(int hinId) {
		return registrationDataService.getPatientAllergyDetails(hinId);
	}

	@Override
	public Map<String, Object> inactivatePatientAllergies(Box box) {
		return registrationDataService.inactivatePatientAllergies(box);
	}

	public boolean saveImmunizationDetails(Map<String, Object> mapForDs)
	{
		return registrationDataService.saveImmunizationDetails(mapForDs);
	}
	
	public boolean saveAllergiesDetails(Map<String, Object> mapForDs)
	{
		return registrationDataService.saveAllergiesDetails(mapForDs);
	}

	@Override
	public Map<String, Object> getPatientList(String hinNo) {
		return registrationDataService.getPatientList(hinNo);
	}

	@Override
	public Map<String, Object> issueInjectionFromReception(Box box) {
		return registrationDataService.issueInjectionFromReception(box);
	}

	@Override
	public Map<String, Object> saveLifeStyleFactors(Box box) {
		return registrationDataService.saveLifeStyleFactors(box);
	}

	@Override
	public Map<String, Object> showLifestyleJsp(Box box) {
		return registrationDataService.showLifestyleJsp(box);
	}

	@Override
	public Map<String, Object> getServiceNoDetailsForMHRun(Box box) {
		return registrationDataService.getServiceNoDetailsForMHRun(box);
	}

	//----------- By Mansi on 11 March 2013
	@Override
	public Map<String, Object> fillAVPilotRegServiceDetail(
			Map<String, Object> dataMap) {
		return registrationDataService.fillAVPilotRegServiceDetail(dataMap);
	}

	@Override
	public Map<String, Object> saveAirCraftEmergencyDetails(Box box,
			Map<String, Object> infoMap) {
		return registrationDataService.saveAirCraftEmergencyDetails(box,infoMap);
	}

	@Override
	public Map<String, Object> getIcdId(String icdNo) {
		return registrationDataService.getIcdId(icdNo);
	}

	@Override
	public Map<String, Object> checkPopUpForReg(Map<String, Object> parameterMap) {
		return registrationDataService.checkPopUpForReg(parameterMap);
	}
	
	@Override
	public Map<String, Object> checkPopUpForRegHAL(Map<String, Object> parameterMap) {
		return registrationDataService.checkPopUpForRegHAL(parameterMap);
	}

	@Override
	public Map<String, Object> getRelationListForServiceNo(Map<String, Object> parameterMap)
	{
		return registrationDataService.getRelationListForServiceNo(parameterMap);
	}

	@Override
	public Map<String, Object> updateHinNo(Map<String, Object> dataMap) {
		return registrationDataService.updateHinNo(dataMap);
	}
	
	@Override
	public Map<String, Object> getOPDVisitList(Box box) {
		return registrationDataService.getOPDVisitList(box);
	}
	
	@Override
	public Map<String, Object> transferPatientVisitList(Map<String, Object> map) {
		return registrationDataService.transferPatientVisitList(map);
	}

	@Override
	public Map<String, Object> getPatientAppointmentList(Box box) {
		return registrationDataService.getPatientAppointmentList(box);
	}
}