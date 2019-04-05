package jkt.hms.appointment.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.AppBlock;
import jkt.hms.util.Box;

/**
 * @ author: Priyanka Garg Made on: 9th July 2008
 */

public interface AppointmentDataService {
	/**
	 * ----------------------- PATIENT SETUP ------------------------
	 * 
	 * @return
	 */
	Map<String, Object> showAppSetupJsp();

	boolean submitAppointmentSetup(Box box);

	Map<String, Object> getRecords(Box box);
	
	Map<String, Object> getDoctorList(Box box);
	
	Map<String, Object> getAppDetails(Box box);

	boolean updateAppointmentSetup(Box box);

	/**
	 * ------------------------ PATIENT APPOINTMENTS ------------------
	 * 
	 * @return
	 */
	Map<String, Object> showAppointmentPatientJsp(Map<String, Object> mapForDs);

	Map<String, Object> showAppointmentPatientDepartmentWise(Box box);

	Map<String, Object> showExistingPatients(Box box);

	Map<String, Object> submitPatientAppointment(Box box);

	Map<String, Object> submitDulicatePatientNameAppointment(Box box);

	Map<String, Object> showListBasedonHinNo(Box box);

	/**
	 * ------------------------ INVESTIGATION SETUP --------------------
	 * 
	 * @return
	 */
	Map<String, Object> showAppointmentInvestigationSetupJsp();

	Map<String, Object> showAppointmentInvestigationSetupDetails(Box box);

	boolean submitAppointmentInvestigationSetup(Box box);

	boolean updateAppointmentInvestigationSetup(Box box);

	/**
	 * ------------------------------ INVESTIGATION APPOINTMENT
	 * -------------------------
	 * 
	 * @return
	 */

	Map<String, Object> showAppointmentInvestigationJsp();

	Map<String, Object> showAppointmentInvestigationWise(Box box);

	Map<String, Object> submitInvestigationAppointment(Box box);

	Map<String, Object> submitDulicatePatientNameInvAppointment(Box box);

	/**
	 * ----------------------------- CANCELLATION FOR PATIENT APPOINTMENTS
	 * ---------------------
	 */

	Map<String, Object> showAppointmentPatientCancellationJsp();

	Map<String, Object> patientAppointmentList(Box box);

	boolean submitCancelPatientAppointment(Box box);

	/**
	 * ----------------------------- CANCELLATION FOR INVESTIGATION APPOINTMENTS
	 * ---------------------
	 */

	Map<String, Object> showAppointmentInvestigationCancellationJsp();

	Map<String, Object> investigationAppointmentList(Box box);

	boolean submitCancelInvestigationAppointment(Box box);

	/**
	 * ---------------------- UPLOAD DOCUMENTS -------------------
	 */

	Map<String, Object> submitUploadDocuments(Box box);

	Map<String, Object> viewUploadDocuments(Box box);

	/**
	 * ------------------------ For Report By Vishal--------------------
	 */
	Map<String, Object> getConnectionForReport();

	Map<String, Object> getEmployeeDepartmentCategory();

	Map<String, Object> getEquipmentDepartmentCategory();

	Map<String, Object> showExistingPatientsForDoctors(Box box);

	Map<String, Object> showPatientAppointmentSelectedDepartmentJsp(Box box);

	Map<String, Object> showInvestigationAppointmentSelectedDeptEquipment(
			Box box);

	// ------Appointment Block by Dipali

	Map<String, Object> showAppBlockJsp();

	Map<String, Object> getBlockAppointment();

	boolean submitAppointmentBlock(AppBlock appBlock);
	
	boolean updateAppointmentBlock(AppBlock appBlock);
	
	boolean deleteAppointmentBlock(AppBlock appBlock);

	/**
	 * --------------------------------- BLOCK APPOINTMENTS
	 * -------------------------
	 * 
	 */

	List getPatientAppointments(String DepartmentId, String blockDateFrom,
			String blockDateTo);

	boolean cancelAppointmentBlock(List appointments);

	Map<String, Object> getDoctorAndSessionDetails(Box box);
	
	Map<String, Object> getLoginDoctorDetailsByDepartment(Map<String, Object> mapForDs);

	Map<String, Object> getQuestionnaireList(Box box);
}
