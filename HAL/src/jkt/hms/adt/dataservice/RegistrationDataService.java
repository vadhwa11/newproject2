package jkt.hms.adt.dataservice;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public interface RegistrationDataService {

	Map<String, Object> showRegistrationJsp(int hospitalId);

	Map<String, Object> submitPatientInformation(Map<String, Object> objectMap);

	String getHinId(String serviceNo, int serviceTypeId);

	Map<String, Object> getVisitDetails();

	Map<String, Object> getPatientDetails(Map<String, Object> mapForDs);

	Map<String, Object> saveVisitInformation(Map<String, Object> mapForDs);

	Map<String, Object> getUpdateRegistrationDetails();

	boolean updateRegistrationInformation(Map<String, Object> mapForDs);

	Map<String, Object> getServiceTypeAndRelation(
			Map<String, Object> parameterMap);

	String getMothersName(String motherHinNo);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> updateVisitDetails(Map<String, Object> parameterMap);

	String getTokenNoForDepartment(int departmentId, int sessionId, int deptId, HttpServletRequest request);

	Map<String, Object> getPatientListForName(Map<String, Object> parameterMap);

	List<Object[]> getHinNoList(String serviceNo);

	Map<String, Object> getPatientDetailsForUpdate(
			Map<String, Object> parameterMap);

	List<Visit> getVisitNo(String hinNo);

	Map<String, Object> getPatientVisitDetailsForUpdate(
			Map<String, Object> parameterMap);

	boolean updateVisitInformation(Map<String, Object> parameterMap);

	Map<String, Object> getDetailsForVisit();

	Map<String, Object> getServicePersonName(String serviceNo, int serviceTypeId);

	Map<String, Object> getVisitData(Map<String, Object> dataMap);

	Map<String, Object> getTokenNo(Map<String, Object> dataMap);

	Map<String, Object> populatePatientDetails(Map<String, Object> dataMap);

	Map<String, Object> getAdmissionNoList(Map<String, Object> dataMap);

	List<Visit> checkPatientVisit(Box box);

	String getConsulationRoom(int consultingDoctor);

	Map<String, Object> getAdmissionDetails();

	Map<String, Object> getAppointmentTypeNoneList(Map<String, Object> mapForDs);

	boolean addTrade(MasTrade masTrade, String s);

	Map<String, Object> addPhotoFile(Map<String, Object> generalMap);

	Map<String, Object> displayRegisPhoto(String hinNo);

	Map<String, Object> showAircraftEmergencyJsp(int hospitalId);

	Map<String, Object> saveAirCraftEmergencyDetails(Box box, Map<String, Object> infoMap);
	
	Map<String, Object> saveEmergencyPerformaDetails(Box box);

	Map<String, Object> showMHReferralRegisterJsp(Box box);

	Map<String, Object> showPatientDetailsForServiceNo(Box box);

	Map<String, Object> saveMHReferralRegisterDetails(Box box);

	Map<String, Object> getServiceNoDetailsForReg(Box box);

	Map<String, Object> getServPersonPatientDetails(Box box);

	Map<String, Object> getSrPhoto(Box box);

	Map<String, Object> getMhReferralDetailsForEdit(Box box);

	Map<String, Object> updateMHReferralRegisterDetails(Box box);

	Map<String, Object> getPatientInfoForVisit(Box box);

	Map<String, Object> getOutPatientHinNo(Box box);

	Map<String, Object> getDetailsForDMOCallRegister(int hospitalId);

	Map<String, Object> saveDMOCallRegisterDetails(Box box);

	Map<String, Object> showAmbulanceRunRegister();

	Map<String, Object> saveAmbulanceRunRegisterDetails(Box box);

	Map<String, Object> showDMARegister(Map<String, Object> dataMap);

	Map<String, Object> updatePatientImage(Map<String, Object> mapDetails);

	Map<String, Object> getItemBatch(Box box);

	Map<String, Object> saveDmaRegisterDetails(Box box);

	Map<String, Object> getHinNoForDMA(Box box);

	Map<String, Object> getHinNoForMinorSurgery(Box box);

	Map<String, Object> getPatientDetailsForMinorSurgery(Box box);

	Map<String, Object> saveMinorSurgeryDetails(Box box);

	List<Visit> getVisitNoForMinorSurgery(int hinId);

	Map<String, Object> showECGRecordJsp(int hospitalId);

	Map<String, Object> saveECGRecordDetails(Box box);

	Map<String, Object> saveInjectionRegisterDetails(Box box);

	Map<String, Object> getInjectionListForAutoComplete(Map<String, Object> map);

	Map<String, Object> savePatientDetentionDetails(Box box);

	Map<String, Object> getServiceNoDetailsFromHIC(Box box);

	Map<String, Object> getMedExamForHICUpdate();

	Map<String, Object> getProcedureForAutoComplete(Map<String, Object> map);

	Map<String, Object> getPendingProcedureList(Box box);

	Map<String, Object> getDetailsForProcWaitList(int hospitalId);

	Map<String, Object> getPendingProcedureDetails(Box box);

	Map<String, Object> showMHReferralRegisterReportJsp(int hospitalId);

	Map<String, Object> showAmbulanceRegisterReportJsp(int hospitalId);

	Map<String, Object> getPendingDetentionList(Box box);

	Map<String, Object> getPendingDetentionDetails(Box box);

	Map<String, Object> getDoctorList(int hospitalId);

	Map<String, Object> getPendingInjectionList(Box box);

	Map<String, Object> getInjectionDetails(Box box);

	Map<String, Object> getDetailsForReport(int hospitalId);

	Map<String, Object> getOPDRegisterData(Box box);

	Map<String, Object> showOPDStatisticsGraph(Box box);

	Map<String, Object> showPrintAircraftEmergencyRegisterReport(Box box);

	Map<String, Object> showOtherEmeregencyReportOnScreen(Box box);

	Map<String, Object> showPrintMHReferralRegisterReport(Box box);

	Map<String, Object> showPrintAmbulanceRegisterReport(Box box);

	Map<String, Object> showPrintProcedureRegisterReport(Box box);

	Map<String, Object> showprintDetentionRegisterReport(Box box);

	Map<String, Object> getItemId(Box box);

//	Map<String, Object> submitDMAStockDetails(Box box);

	Map<String, Object> showMHReferralGraph(Box box);

	Map<String, Object> showProcedureGraph(Box box);

	Map<String, Object> showAmbulanceRegisterGraph(Box box);

	Map<String, Object> showAircraftRegisterGraph(Box box);

	Map<String, Object> saveUnwillingnessCertificate(Box box);

	Map<String, Object> showOtherEmergencyGraph(Box box);

	Map<String, Object> showDetentionRegisterGraph(Box box);

	Map<String, Object> showInjectionRegisterGraph(Box box);

	Map<String, Object> showPrintInjectionRegisterReport(Box box);

	Map<String, Object> getImmunizationForAutoComplete(Map<String, Object> map);

	Map<String, Object> getImmunizationId(Box box);

	Map<String, Object> getInjectionDetailsForAppointment(Box box);

	Map<String, Object> saveInjectionAppointment(Box box);

	Map<String, Object> getInjectionAppointmentDetails(Box box);

	Map<String, Object> getPatientImmunizationDetails(int hinId);

	Map<String, Object> getPatientAllergyDetails(int hinId);

	Map<String, Object> inactivatePatientAllergies(Box box);
	boolean saveImmunizationDetails(Map<String, Object> mapForDs);
	boolean saveAllergiesDetails(Map<String, Object> mapForDs);

	Map<String, Object> getPatientList(String hinNo);

	Map<String, Object> issueInjectionFromReception(Box box);

	Map<String, Object> saveLifeStyleFactors(Box box);

	Map<String, Object> showLifestyleJsp(Box box);

	Map<String, Object> getServiceNoDetailsForMHRun(Box box);
	
	
	//-- By Mansi on 11 March 2013
	Map<String, Object> fillAVPilotRegServiceDetail(Map<String, Object> dataMap);

	boolean addRecordForHL7();

	Map<String, Object> getIcdId(String icdNo);

	Map<String, Object> checkPopUpForReg(Map<String, Object> parameterMap);

	Map<String, Object> getRelationListForServiceNo(
			Map<String, Object> parameterMap);

	Map<String, Object> updateHinNo(Map<String, Object> dataMap);

	Map<String, Object> getServicePersonNameHAL(String serviceNo,
			int serviceTypeId);

	Map<String, Object> populatePatientDetailsHAL(Map<String, Object> dataMap);

	Map<String, Object> getPatientTypeCodeAndRelationCode(
			HttpServletRequest request);

	String getHinIdHAL(String patientCode, HttpServletRequest request);

	Map<String, Object> submitPatientInformationHAL(
			Map<String, Object> objectMap);

	Map<String, Object> getListOfPendingForApproval(Box box);

	Map<String, Object> submitPendingForApproval(HttpServletRequest request);

	Map<String, Object> responseForVisitOfHALEmployees(String serviceNo,
			int serviceTypeId, int hospitalId);

	Map<String, Object> submitPatientInformationEmployeeVisit(
			Map<String, Object> objectMap, HttpServletRequest request);

	Map<String, Object> checkPopUpForRegHAL(Map<String, Object> parameterMap);

	Map<String, Object> getPatientListForNameHAL(
			Map<String, Object> parameterMap);

	Map<String, Object> getPatientInfoForVisitHAL(Box box);

	Map<String, Object> showPendingOtherVisitJsp(Box box);

	Map<String, Object> getServiceNoDetailsForRegHAL(Box box);

	Map<String, Object> getListOnlinePatients(Box box);

	Map<String, Object> cancleOnlineAppointment(Map<String, Object> objectMap);

	Map<String, Object> submitPatientInformationOnlineEmployeeVisit(
			Map<String, Object> objectMap);

	Map<String, Object> showOtherVisitJsp(int hospitalId);

	Map<String, Object> submitPatientInformationOtherPatientVisit(
			Map<String, Object> objectMap, HttpServletRequest request);

	Map<String, Object> getDepartmentList(int hospitalId);

	Map<String, Object> getListOfPatientVisitReferral(Box box);

	Map<String, Object> submitReferral(HttpServletRequest request);

	Map<String, Object> updateOtherPatientInformation(
			Map<String, Object> objectMap);

	Map<String, Object> getOPDVisitList(Box box);
	
	Map<String, Object> transferPatientVisitList(Map<String, Object> map);

	Map<String, Object> getPatientAppointmentList(Box box);

	Map<String, Object> showRegistrationJspOtherPatient(int hospitalId);

	
}
