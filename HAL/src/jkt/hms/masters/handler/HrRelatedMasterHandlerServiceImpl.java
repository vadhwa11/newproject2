package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.HrClassMaster;
import jkt.hms.masters.business.HrDutyMaster;
import jkt.hms.masters.business.HrDutyTimeMaster;
import jkt.hms.masters.business.HrEstablishmentMaster;
import jkt.hms.masters.business.HrLeaveTypeMaster;
import jkt.hms.masters.business.HrMedicalCourseMaster;
import jkt.hms.masters.business.HrSpecialistMaster;
import jkt.hms.masters.dataservice.HrRelatedMasterDataService;

public class HrRelatedMasterHandlerServiceImpl implements
		HrRelatedMasterHandlerService {

	HrRelatedMasterDataService hrRelatedMasterDataService = null;

	public HrRelatedMasterDataService getHrRelatedMasterDataService() {
		return hrRelatedMasterDataService;
	}

	public void setHrRelatedMasterDataService(
			HrRelatedMasterDataService hrRelatedMasterDataService) {
		this.hrRelatedMasterDataService = hrRelatedMasterDataService;
	}

	public Map<String, Object> showSpecialityJsp() {
		return hrRelatedMasterDataService.showSpecialityJsp();
	}

	public boolean addSpeciality(HrSpecialistMaster hrSpecialistMaster) {
		return hrRelatedMasterDataService.addSpeciality(hrSpecialistMaster);
	}

	public boolean deleteSpeciality(int id, Map<String, Object> generalMap) {
		return hrRelatedMasterDataService.deleteSpeciality(id, generalMap);
	}

	public boolean editSpecialityToDatabase(Map<String, Object> generalMap) {
		return hrRelatedMasterDataService.editSpecialityToDatabase(generalMap);
	}

	public Map<String, Object> searchSpeciality(String code, String name) {
		return hrRelatedMasterDataService.searchSpeciality(code, name);
	}

	/**
	 * ----------------- Medical Course Master ---------------
	 */
	public Map<String, Object> showMedicalCourseJsp() {
		return hrRelatedMasterDataService.showMedicalCourseJsp();
	}

	public boolean addMedicalCourse(HrMedicalCourseMaster hrMedicalCourseMaster) {
		return hrRelatedMasterDataService
				.addMedicalCourse(hrMedicalCourseMaster);
	}

	public boolean deleteMedicalCourse(int id, Map<String, Object> generalMap) {
		return hrRelatedMasterDataService.deleteMedicalCourse(id, generalMap);
	}

	public boolean editMedicalCourseToDatabase(Map<String, Object> generalMap) {
		return hrRelatedMasterDataService
				.editMedicalCourseToDatabase(generalMap);
	}

	public Map<String, Object> searchMedicalCourse(String code, String name) {
		return hrRelatedMasterDataService.searchMedicalCourse(code, name);
	}

	/**
	 * ----------------- Leave Type Master ---------------
	 */
	public Map<String, Object> showLeaveTypeJsp() {
		return hrRelatedMasterDataService.showLeaveTypeJsp();
	}

	public boolean addLeaveType(HrLeaveTypeMaster hrLeaveTypeMaster) {
		return hrRelatedMasterDataService.addLeaveType(hrLeaveTypeMaster);
	}

	public boolean deleteLeaveType(int id, Map<String, Object> generalMap) {
		return hrRelatedMasterDataService.deleteLeaveType(id, generalMap);
	}

	public boolean editLeaveTypeToDatabase(Map<String, Object> generalMap) {
		return hrRelatedMasterDataService.editLeaveTypeToDatabase(generalMap);
	}

	public Map<String, Object> searchLeaveType(String leaveType, String details) {
		return hrRelatedMasterDataService.searchLeaveType(leaveType, details);
	}

	/**
	 * ----------------- Duty Time Master ---------------
	 */
	public Map<String, Object> showDutyTimeJsp() {
		return hrRelatedMasterDataService.showDutyTimeJsp();
	}

	public boolean addDutyTime(HrDutyTimeMaster hrDutyTimeMaster) {
		return hrRelatedMasterDataService.addDutyTime(hrDutyTimeMaster);
	}

	public boolean deleteDutyTime(int id, Map<String, Object> generalMap) {
		return hrRelatedMasterDataService.deleteDutyTime(id, generalMap);
	}

	public boolean editDutyTimeToDatabase(Map<String, Object> generalMap) {
		return hrRelatedMasterDataService.editDutyTimeToDatabase(generalMap);
	}

	public Map<String, Object> searchDutyTime(String code) {
		return hrRelatedMasterDataService.searchDutyTime(code);
	}

	/**
	 * ----------------- Establishment Master ---------------
	 */
	public Map<String, Object> showEstablishmentJsp() {
		return hrRelatedMasterDataService.showEstablishmentJsp();
	}

	public boolean addEstablishment(HrEstablishmentMaster hrEstablishmentMaster) {
		return hrRelatedMasterDataService
				.addEstablishment(hrEstablishmentMaster);
	}

	public boolean deleteEstablishment(int id, Map<String, Object> generalMap) {
		return hrRelatedMasterDataService.deleteEstablishment(id, generalMap);
	}

	public boolean editEstablishmentToDatabase(Map<String, Object> generalMap) {
		return hrRelatedMasterDataService
				.editEstablishmentToDatabase(generalMap);
	}

	public Map<String, Object> searchEstablishment(String unitName,
			String specialityName) {
		return hrRelatedMasterDataService.searchEstablishment(unitName,
				specialityName);
	}

	/**
	 * --------------------- Class Master --------------------
	 */

	public Map<String, Object> showClassJsp() {
		return hrRelatedMasterDataService.showClassJsp();
	}

	public boolean addClass(HrClassMaster hrClassMaster) {
		return hrRelatedMasterDataService.addClass(hrClassMaster);
	}

	public boolean deleteClass(int id, Map<String, Object> generalMap) {
		return hrRelatedMasterDataService.deleteClass(id, generalMap);
	}

	public boolean editClassToDatabase(Map<String, Object> generalMap) {
		return hrRelatedMasterDataService.editClassToDatabase(generalMap);
	}

	public Map<String, Object> searchClass(String code, String name) {
		return hrRelatedMasterDataService.searchClass(code, name);
	}

	/**
	 * --------------------- Duty Master -------------------
	 */
	public Map<String, Object> showDutyJsp() {
		return hrRelatedMasterDataService.showDutyJsp();
	}

	public boolean addDuty(HrDutyMaster hrDutyMaster) {
		return hrRelatedMasterDataService.addDuty(hrDutyMaster);
	}

	public boolean deleteDuty(int id, Map<String, Object> generalMap) {
		return hrRelatedMasterDataService.deleteDuty(id, generalMap);
	}

	public boolean editDutyToDatabase(Map<String, Object> generalMap) {
		return hrRelatedMasterDataService.editDutyToDatabase(generalMap);
	}

	public Map<String, Object> searchDuty(String code, String name) {
		return hrRelatedMasterDataService.searchDuty(code, name);
	}

}
