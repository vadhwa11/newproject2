package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.HrClassMaster;
import jkt.hms.masters.business.HrDutyMaster;
import jkt.hms.masters.business.HrDutyTimeMaster;
import jkt.hms.masters.business.HrEstablishmentMaster;
import jkt.hms.masters.business.HrLeaveTypeMaster;
import jkt.hms.masters.business.HrMedicalCourseMaster;
import jkt.hms.masters.business.HrSpecialistMaster;

public interface HrRelatedMasterHandlerService {

	Map<String, Object> showSpecialityJsp();

	boolean addSpeciality(HrSpecialistMaster hrSpecialistMaster);

	Map<String, Object> searchSpeciality(String code, String name);

	boolean editSpecialityToDatabase(Map<String, Object> generalMap);

	boolean deleteSpeciality(int id, Map<String, Object> generalMap);

	/**
	 * ------------------- Medical Course Master ----------------------
	 * 
	 * @return
	 */

	Map<String, Object> showMedicalCourseJsp();

	boolean addMedicalCourse(HrMedicalCourseMaster hrMedicalCourseMaster);

	Map<String, Object> searchMedicalCourse(String code, String name);

	boolean editMedicalCourseToDatabase(Map<String, Object> generalMap);

	boolean deleteMedicalCourse(int id, Map<String, Object> generalMap);

	/**
	 * ------------------- Leave Type Master ----------------------
	 * 
	 * @return
	 */

	Map<String, Object> showLeaveTypeJsp();

	boolean addLeaveType(HrLeaveTypeMaster hrLeaveTypeMaster);

	Map<String, Object> searchLeaveType(String leaveType, String details);

	boolean editLeaveTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteLeaveType(int id, Map<String, Object> generalMap);

	/**
	 * ------------------- Duty Time Master ----------------------
	 * 
	 * @return
	 */

	Map<String, Object> showDutyTimeJsp();

	boolean addDutyTime(HrDutyTimeMaster hrDutyTimeMaster);

	Map<String, Object> searchDutyTime(String code);

	boolean editDutyTimeToDatabase(Map<String, Object> generalMap);

	boolean deleteDutyTime(int id, Map<String, Object> generalMap);

	/**
	 * ---------------------- Establishment Master --------------
	 * 
	 * @return
	 */

	Map<String, Object> showEstablishmentJsp();

	boolean addEstablishment(HrEstablishmentMaster hrEstablishmentMaster);

	Map<String, Object> searchEstablishment(String unitName,
			String specialityName);

	boolean editEstablishmentToDatabase(Map<String, Object> generalMap);

	boolean deleteEstablishment(int id, Map<String, Object> generalMap);

	/**
	 * ----------------------- Class Master ----------------------
	 */
	Map<String, Object> showClassJsp();

	boolean addClass(HrClassMaster hrClassMaster);

	Map<String, Object> searchClass(String code, String name);

	boolean editClassToDatabase(Map<String, Object> generalMap);

	boolean deleteClass(int id, Map<String, Object> generalMap);

	/**
	 * ---------------------- Duty Master -----------------------
	 */
	Map<String, Object> showDutyJsp();

	boolean addDuty(HrDutyMaster hrDutyMaster);

	Map<String, Object> searchDuty(String code, String name);

	boolean editDutyToDatabase(Map<String, Object> generalMap);

	boolean deleteDuty(int id, Map<String, Object> generalMap);

}
