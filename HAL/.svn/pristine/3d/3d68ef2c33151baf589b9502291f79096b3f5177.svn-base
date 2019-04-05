package jkt.hms.masters.dataservice;

import java.util.Map;

import jkt.hms.masters.business.HrClassMaster;
import jkt.hms.masters.business.HrDutyMaster;
import jkt.hms.masters.business.HrDutyTimeMaster;
import jkt.hms.masters.business.HrEstablishmentMaster;
import jkt.hms.masters.business.HrLeaveTypeMaster;
import jkt.hms.masters.business.HrMedicalCourseMaster;
import jkt.hms.masters.business.HrSpecialistMaster;

public interface HrRelatedMasterDataService {

	Map<String, Object> showSpecialityJsp();

	boolean addSpeciality(HrSpecialistMaster hrSpecialistMaster);

	boolean deleteSpeciality(int id, Map<String, Object> generalMap);

	boolean editSpecialityToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchSpeciality(String code, String name);

	/**
	 * --------------------- Medical Course Master ----------------------
	 * 
	 * @return
	 */

	Map<String, Object> showMedicalCourseJsp();

	boolean addMedicalCourse(HrMedicalCourseMaster hrMedicalCourseMaster);

	boolean deleteMedicalCourse(int id, Map<String, Object> generalMap);

	boolean editMedicalCourseToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchMedicalCourse(String code, String name);

	/**
	 * --------------------- Leave Type Master ----------------------
	 * 
	 * @return
	 */

	Map<String, Object> showLeaveTypeJsp();

	boolean addLeaveType(HrLeaveTypeMaster hrLeaveTypeMaster);

	boolean deleteLeaveType(int id, Map<String, Object> generalMap);

	boolean editLeaveTypeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchLeaveType(String leaveType, String details);

	/**
	 * --------------------- Duty Time Master ----------------------
	 * 
	 * @return
	 */

	Map<String, Object> showDutyTimeJsp();

	boolean addDutyTime(HrDutyTimeMaster hrDutyTimeMaster);

	boolean deleteDutyTime(int id, Map<String, Object> generalMap);

	boolean editDutyTimeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchDutyTime(String code);

	/**
	 * --------------------- Establishment Master ----------------------
	 * 
	 * @return
	 */

	Map<String, Object> showEstablishmentJsp();

	boolean addEstablishment(HrEstablishmentMaster hrEstablishmentMaster);

	boolean deleteEstablishment(int id, Map<String, Object> generalMap);

	boolean editEstablishmentToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchEstablishment(String unitName,
			String specialityName);

	/**
	 * -------------------- Class Master -------------------------
	 */
	Map<String, Object> showClassJsp();

	boolean addClass(HrClassMaster hrClassMaster);

	boolean deleteClass(int id, Map<String, Object> generalMap);

	boolean editClassToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchClass(String code, String name);

	/**
	 * --------------------- Duty Master ---------------------
	 */

	Map<String, Object> showDutyJsp();

	boolean addDuty(HrDutyMaster hrDutyMaster);

	boolean deleteDuty(int id, Map<String, Object> generalMap);

	boolean editDutyToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchDuty(String code, String name);

}
