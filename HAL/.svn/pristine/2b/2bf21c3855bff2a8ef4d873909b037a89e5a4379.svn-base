package jkt.hms.appointment.handler;

/**
 * @ author: Priyanka Garg
 * Made on: 9th July 2008
 */

import java.util.List;
import java.util.Map;

import jkt.hms.appointment.dataservice.AppointmentDataService;
import jkt.hms.masters.business.AppBlock;
import jkt.hms.util.Box;

public class AppointmentHandlerServiceImpl implements AppointmentHandlerService {

	AppointmentDataService appointmentDataService = null;

	/**
	 * ------------------------ GETTER AND SETTER METHODS ----------------
	 * 
	 * @return
	 */

	public AppointmentDataService getAppointmentDataService() {
		return appointmentDataService;
	}

	public void setAppointmentDataService(
			AppointmentDataService appointmentDataService) {
		this.appointmentDataService = appointmentDataService;
	}

	/**
	 * -------------------------------- Appointment Setup
	 * ---------------------------
	 */
	public Map<String, Object> showAppSetupJsp() {
		return appointmentDataService.showAppSetupJsp();
	}

	public boolean submitAppointmentSetup(Box box) {
		return appointmentDataService.submitAppointmentSetup(box);
	}

	public Map<String, Object> getRecords(Box box) {
		return appointmentDataService.getRecords(box);
	}

	
	
	public Map<String, Object> getDoctorList(Box box) {
		return appointmentDataService.getDoctorList(box);
	}

	public Map<String, Object> getQuestionnaireList(Box box) {
		return appointmentDataService.getQuestionnaireList(box);
	}
	
	public Map<String, Object> getDoctorAndSessionDetails(Box box) {
		return appointmentDataService.getDoctorAndSessionDetails(box);
	}
	
	public Map<String, Object> getAppDetails(Box box) {
		return appointmentDataService.getAppDetails(box);
	}

	
	
	public boolean updateAppointmentSetup(Box box) {
		return appointmentDataService.updateAppointmentSetup(box);
	}

	/**
	 * ---------------------- PATIENT APPOINTMENTS -------------------
	 */
	public Map<String, Object> showAppointmentPatientJsp(
			Map<String, Object> mapForDs) {
		return appointmentDataService.showAppointmentPatientJsp(mapForDs);
	}

	public Map<String, Object> showAppointmentPatientDepartmentWise(Box box) {
		return appointmentDataService.showAppointmentPatientDepartmentWise(box);
	}

	public Map<String, Object> showExistingPatients(Box box) {
		return appointmentDataService.showExistingPatients(box);
	}

	public Map<String, Object> submitPatientAppointment(Box box) {
		return appointmentDataService.submitPatientAppointment(box);
	}

	public Map<String, Object> submitDulicatePatientNameAppointment(Box box) {
		return appointmentDataService.submitDulicatePatientNameAppointment(box);
	}

	public Map<String, Object> showListBasedonHinNo(Box box) {
		return appointmentDataService.showListBasedonHinNo(box);
	}

	/**
	 * -------------------------- INVESTIGATION SETUP ----------------------
	 */
	public Map<String, Object> showAppointmentInvestigationSetupJsp() {
		return appointmentDataService.showAppointmentInvestigationSetupJsp();
	}

	public Map<String, Object> showAppointmentInvestigationSetupDetails(Box box) {
		return appointmentDataService
				.showAppointmentInvestigationSetupDetails(box);
	}

	public boolean submitAppointmentInvestigationSetup(Box box) {
		return appointmentDataService.submitAppointmentInvestigationSetup(box);
	}

	public boolean updateAppointmentInvestigationSetup(Box box) {
		return appointmentDataService.updateAppointmentInvestigationSetup(box);
	}

	/**
	 * ---------------------------------- INVESTIGATION APPOINTMENT
	 * -----------------------
	 * 
	 * @return
	 */
	public Map<String, Object> showAppointmentInvestigationJsp() {
		return appointmentDataService.showAppointmentInvestigationJsp();
	}

	public Map<String, Object> showAppointmentInvestigationWise(Box box) {
		return appointmentDataService.showAppointmentInvestigationWise(box);
	}

	public Map<String, Object> submitInvestigationAppointment(Box box) {
		return appointmentDataService.submitInvestigationAppointment(box);
	}

	public Map<String, Object> submitDulicatePatientNameInvAppointment(Box box) {
		return appointmentDataService
				.submitDulicatePatientNameInvAppointment(box);
	}

	/**
	 * ----------------------------- CANCELLATION FOR PATIENT APPOINTMENTS
	 * ---------------------
	 */
	public Map<String, Object> showAppointmentPatientCancellationJsp() {
		return appointmentDataService.showAppointmentPatientCancellationJsp();
	}

	public Map<String, Object> patientAppointmentList(Box box) {
		return appointmentDataService.patientAppointmentList(box);
	}

	public boolean submitCancelPatientAppointment(Box box) {
		return appointmentDataService.submitCancelPatientAppointment(box);
	}

	/**
	 * ----------------------------- CANCELLATION FOR INVESTIGATION APPOINTMENTS
	 * ---------------------
	 */

	public Map<String, Object> showAppointmentInvestigationCancellationJsp() {
		return appointmentDataService
				.showAppointmentInvestigationCancellationJsp();
	}

	public Map<String, Object> investigationAppointmentList(Box box) {
		return appointmentDataService.investigationAppointmentList(box);
	}

	public boolean submitCancelInvestigationAppointment(Box box) {
		return appointmentDataService.submitCancelInvestigationAppointment(box);
	}

	/**
	 *------------------------- UPLOAD DOCUMENTS -------------
	 */

	public Map<String, Object> submitUploadDocuments(Box box) {
		return appointmentDataService.submitUploadDocuments(box);
	}

	public Map<String, Object> viewUploadDocuments(Box box) {
		return appointmentDataService.viewUploadDocuments(box);
	}

	/**
	 * -------------------------- For Report By Vishal ----------------------
	 */
	public Map<String, Object> getConnectionForReport() {
		return appointmentDataService.getConnectionForReport();
	}

	public Map<String, Object> getEmployeeDepartmentCategory() {
		return appointmentDataService.getEmployeeDepartmentCategory();
	}

	public Map<String, Object> getEquipmentDepartmentCategory() {
		return appointmentDataService.getEquipmentDepartmentCategory();
	}

	public Map<String, Object> showExistingPatientsForDoctors(Box box) {
		return appointmentDataService.showExistingPatientsForDoctors(box);
	}

	/**
	 * -------------------------- END For Report By Vishal
	 * ----------------------
	 * 
	 */

	public Map<String, Object> showPatientAppointmentSelectedDepartmentJsp(
			Box box) {
		return appointmentDataService
				.showPatientAppointmentSelectedDepartmentJsp(box);
	}

	public Map<String, Object> showInvestigationAppointmentSelectedDeptEquipment(
			Box box) {
		return appointmentDataService
				.showInvestigationAppointmentSelectedDeptEquipment(box);
	}

	// ------Appointment Block by Dipali
	public Map<String, Object> showAppBlockJsp() {
		return appointmentDataService.showAppBlockJsp();
	}

	public boolean submitAppointmentBlock(AppBlock appBlock) {
		return appointmentDataService.submitAppointmentBlock(appBlock);
	}
	
	public boolean updateAppointmentBlock(AppBlock appBlock){
		return appointmentDataService.updateAppointmentBlock(appBlock);
	}

	public Map<String, Object> getBlockAppointment() {
		return appointmentDataService.getBlockAppointment();
	}

	public List getPatientAppointments(String DepartmentId,
			String blockDateFrom, String blockDateTo) {
		return appointmentDataService.getPatientAppointments(DepartmentId,
				blockDateFrom, blockDateTo);
	}

	public boolean cancelAppointmentBlock(List appointments) {
		return appointmentDataService.cancelAppointmentBlock(appointments);
	}

	public boolean deleteAppointmentBlock(AppBlock appBlock) {
		return appointmentDataService.deleteAppointmentBlock(appBlock);
	}
	
	public Map<String, Object> getLoginDoctorDetailsByDepartment(Map<String, Object> mapForDs) {
		return appointmentDataService.getLoginDoctorDetailsByDepartment(mapForDs);
	}

}
