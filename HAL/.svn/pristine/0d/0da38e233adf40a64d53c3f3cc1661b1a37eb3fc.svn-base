package jkt.hms.hr.dataservice;

import java.util.Map;

import jkt.hms.masters.business.HrLeaveMaintenance;
import jkt.hms.util.Box;

public interface HrRelatedDataService {

	Map<String, Object> showLeaveMaintenanceSearchJsp();

	Map<String, Object> searchEmployeeForLeaveMaintenance(
			Map<String, Object> employeeMap);

	Map<String, Object> showLeaveMaintenanceEntryJsp(int empId);

	boolean submitLeaveMaintenanceEntry(HrLeaveMaintenance hrLeaveMaintenance);

	/**
	 * ----------------------------- NIGHT DUTY ENTRY
	 * ---------------------------
	 * 
	 * @param box
	 * @return
	 */

	Map<String, Object> getEmployeeDetailsForNightDutyAdd(Box box);

	Map<String, Object> getGridDataForEmployeeAdd(Box box);

	Map<String, Object> getEmployeeDetailsForNightDuty(Box box);

	Map<String, Object> getGridDataForEmployee(Box box);

	boolean AddNightDutyEntry(Box box);

	Map<String, Object> getEmployeeLastDutyDetails(Box box);

	boolean updateNightDutyEntry(Box box);

	/**
	 * ----------------------------- GUARD DUTY ENTRY
	 * ---------------------------
	 * 
	 * @param box
	 * @return
	 */
	public boolean updateDutyPerformed(Map<String, Object> generalMap);

	public Map<String, Object> searchDutyPerformed(
			Map<String, Object> generalMap);

	public Map<String, Object> showDutyPerformed();

	Map<String, Object> getEmployeeDetailsForGuardDutyAdd(Box box);

	Map<String, Object> getGridDataForGuardEmployeeAdd(Box box);

	Map<String, Object> getEmployeeDetailsForGuardDuty(Box box);

	Map<String, Object> getGridDataForGuardEmployee(Box box);

	boolean AddGuardDutyEntry(Box box);

	Map<String, Object> getGuardEmployeeLastDutyDetails(Box box);

	boolean updateGuardDutyEntry(Box box);

	/**
	 * ----------------------------- WARD DUTY ENTRY ---------------------------
	 * 
	 * @param box
	 * @return
	 */

	Map<String, Object> getEmployeeDetailsForWardDutyAdd(Box box);

	Map<String, Object> getGridDataForWardEmployeeAdd(Box box);

	Map<String, Object> getEmployeeDetailsForWardDuty(Box box);

	Map<String, Object> getGridDataForWardEmployee(Box box);

	boolean AddWardDutyEntry(Box box);

	Map<String, Object> getWardEmployeeLastDutyDetails(Box box);

	boolean updateWardDutyEntry(Box box);

	/**
	 * ----------------------------- ORDERLY DUTY ENTRY
	 * ---------------------------
	 * 
	 * @param box
	 * @return
	 */

	Map<String, Object> getEmployeeDetailsForOrderlyDutyAdd(Box box);

	Map<String, Object> getGridDataForOrderlyEmployeeAdd(Box box);

	Map<String, Object> getEmployeeDetailsForOrderlyDuty(Box box);

	Map<String, Object> getGridDataForOrderlyEmployee(Box box);

	boolean AddOrderlyDutyEntry(Box box);

	Map<String, Object> getOrderlyEmployeeLastDutyDetails(Box box);

	boolean updateOrderlyDutyEntry(Box box);

	/**
	 * ----------------------------- RANGE FIRING DUTY ENTRY
	 * ---------------------------
	 * 
	 * @param box
	 * @return
	 */

	Map<String, Object> getEmployeeDetailsForRangeFiringDutyAdd(Box box);

	Map<String, Object> getGridDataForRangeFiringEmployeeAdd(Box box);

	Map<String, Object> getEmployeeDetailsForRangeFiringDuty(Box box);

	Map<String, Object> getGridDataForRangeFiringEmployee(Box box);

	boolean AddRangeFiringDutyEntry(Box box);

	boolean updateRangeFiringDutyEntry(Box box);

	Map<String, Object> searchRangeFiringDutyEntry(Box box);

	Map<String, Object> searchDutyDisplay(Box box);

	/**
	 * ----------------------- Duty Exemption Entry ---------------------
	 */

	Map<String, Object> showDutyExemptionSearchJsp();

	Map<String, Object> searchEmployeeForDutyExemption(
			Map<String, Object> employeeMap);

	Map<String, Object> showDutyExemptionEntryJsp(int empId);

	boolean submitDutyExemptionEntry(Box box);

	/**
	 * ----------------------------- DAILY ROUTINE ENTRY
	 * ---------------------------
	 * 
	 * @param box
	 * @return
	 */

	Map<String, Object> getEmployeeDetailsForDailyRoutineAdd(Box box);

	Map<String, Object> getGridDataForDailyRoutineEmployeeAdd(Box box);

	Map<String, Object> getEmployeeDetailsForDailyRoutine(Box box);

	Map<String, Object> getGridDataForDailyRoutineEmployee(Box box);

	boolean AddDailyRoutineEntry(Box box);

	boolean updateDailyRoutineEntry(Box box);

	Map<String, Object> searchDailyRoutineEntry(Box box);

	Map<String, Object> searchDailyRoutineDutyDisplay(Box box);

	Map<String, Object> showDailyRoutineEntryJsp();

	/**
	 * --------------------- UPDATE ARRIVAL ENTRY ----------------------
	 */

	Map<String, Object> showUpdateArrivalSearchJsp();

	Map<String, Object> searchEmployeeForUpdateArrival(
			Map<String, Object> employeeMap);

	Map<String, Object> showUpdateArrivalEntryJsp(int empId);

	boolean submitUpdateArrivalEntry(Box box);

	/**
	 * ----------------------LEAVE APPLICATION PENDING FOR RECOMMENDATION
	 * ------------------
	 */

	Map<String, Object> searchEmployeeForLeavePending(
			Map<String, Object> employeeMap);

	Map<String, Object> showLeavePendingEntryJsp(int empId);

	boolean submitLeavePendingEntry(Box box);

	Map<String, Object> showGuardDutyEntryJsp();

	Map<String, Object> showNightDutyEntryJsp();

	Map<String, Object> showOrderlyDutyEntryJsp();

	Map<String, Object> showWardDutyEntryJsp();

	/**
	 * 0---------------------------- DELETE METHODS -------------------
	 * 
	 * @param box
	 * @return
	 */

	boolean deleteGuardDutyEntry(Box box);

	boolean deleteNightDutyEntry(Box box);

	boolean deleteOrderlyDutyEntry(Box box);

	boolean deleteWardDutyEntry(Box box);

	boolean deleteDailyRoutineDutyEntry(Box box);

	/**
	 * ------------------------- SEARCH METHODS ON THE MAIN DUTY SCREENS
	 * --------------------
	 * 
	 * @param box
	 * @return
	 */

	Map<String, Object> searchNightDutyData(Box box);

	Map<String, Object> searchDailyRoutineDutyData(Box box);

	Map<String, Object> searchGuardDutyData(Box box);

	Map<String, Object> searchOrderlyDutyData(Box box);

	Map<String, Object> searchWardDutyData(Box box);

	/**
	 * ------------------------- METHODS FOR SEARCH ON ADDITION POP UP SCREEN
	 * -------------------
	 */

	Map<String, Object> searchGuardDutyEntry(Box box);

	Map<String, Object> searchNightDutyEntry(Box box);

	Map<String, Object> searchOrderlyDutyEntry(Box box);

	Map<String, Object> searchWardDutyEntry(Box box);

	/**
	 * ------------------------------- REPORTS
	 * ------------------------------------------
	 * 
	 * @return
	 */

	Map<String, Object> getConnectionForReport();

	Map<String, Object> showEstablishmentReportJsp();

	Map<String, Object> showDepartmentWiseReportJsp();

	Map<String, Object> showRankWiseReportJsp();

	Map<String, Object> showSpecialistWiseReportJsp();

}
