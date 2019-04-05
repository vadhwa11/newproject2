package jkt.hms.hr.handler;

import java.util.Map;

import jkt.hms.hr.dataservice.HrRelatedDataService;
import jkt.hms.masters.business.HrLeaveMaintenance;
import jkt.hms.util.Box;

public class HrRelatedHandlerServiceImpl implements HrRelatedHandlerService {

	HrRelatedDataService hrRelatedDataService = null;

	public HrRelatedDataService getHrRelatedDataService() {
		return hrRelatedDataService;
	}

	public void setHrRelatedDataService(
			HrRelatedDataService hrRelatedDataService) {
		this.hrRelatedDataService = hrRelatedDataService;
	}

	public Map<String, Object> showLeaveMaintenanceSearchJsp() {
		return hrRelatedDataService.showLeaveMaintenanceSearchJsp();
	}

	public Map<String, Object> searchEmployeeForLeaveMaintenance(
			Map<String, Object> employeeMap) {
		return hrRelatedDataService
				.searchEmployeeForLeaveMaintenance(employeeMap);
	}

	public Map<String, Object> showLeaveMaintenanceEntryJsp(int empId) {
		return hrRelatedDataService.showLeaveMaintenanceEntryJsp(empId);
	}

	public boolean submitLeaveMaintenanceEntry(
			HrLeaveMaintenance hrLeaveMaintenance) {
		return hrRelatedDataService
				.submitLeaveMaintenanceEntry(hrLeaveMaintenance);
	}

	/**
	 * --------------------------- NIGHT DUTY ENTRY ------------------------
	 */
	public Map<String, Object> getEmployeeDetailsForNightDutyAdd(Box box) {
		return hrRelatedDataService.getEmployeeDetailsForNightDutyAdd(box);
	}

	public Map<String, Object> getGridDataForEmployeeAdd(Box box) {
		return hrRelatedDataService.getGridDataForEmployeeAdd(box);
	}

	public Map<String, Object> getEmployeeDetailsForNightDuty(Box box) {
		return hrRelatedDataService.getEmployeeDetailsForNightDuty(box);
	}

	public Map<String, Object> getGridDataForEmployee(Box box) {
		return hrRelatedDataService.getGridDataForEmployee(box);
	}

	public boolean AddNightDutyEntry(Box box) {
		return hrRelatedDataService.AddNightDutyEntry(box);
	}

	public Map<String, Object> getEmployeeLastDutyDetails(Box box) {
		return hrRelatedDataService.getEmployeeLastDutyDetails(box);
	}

	public boolean updateNightDutyEntry(Box box) {
		return hrRelatedDataService.updateNightDutyEntry(box);
	}

	/**
	 * --------------------------- GUARD DUTY ENTRY ------------------------
	 */
	public Map<String, Object> searchDutyPerformed(
			Map<String, Object> generalmap) {
		return hrRelatedDataService.searchDutyPerformed(generalmap);
	}

	public Map<String, Object> showDutyPerformed() {
		return hrRelatedDataService.showDutyPerformed();
	}

	public boolean updateDutyPerformed(Map<String, Object> generalMap) {
		return hrRelatedDataService.updateDutyPerformed(generalMap);
	}

	public Map<String, Object> getEmployeeDetailsForGuardDutyAdd(Box box) {
		return hrRelatedDataService.getEmployeeDetailsForGuardDutyAdd(box);
	}

	public Map<String, Object> getGridDataForGuardEmployeeAdd(Box box) {
		return hrRelatedDataService.getGridDataForGuardEmployeeAdd(box);
	}

	public Map<String, Object> getEmployeeDetailsForGuardDuty(Box box) {
		return hrRelatedDataService.getEmployeeDetailsForGuardDuty(box);
	}

	public Map<String, Object> getGridDataForGuardEmployee(Box box) {
		return hrRelatedDataService.getGridDataForGuardEmployee(box);
	}

	public boolean AddGuardDutyEntry(Box box) {
		return hrRelatedDataService.AddGuardDutyEntry(box);
	}

	public Map<String, Object> getGuardEmployeeLastDutyDetails(Box box) {
		return hrRelatedDataService.getGuardEmployeeLastDutyDetails(box);
	}

	public boolean updateGuardDutyEntry(Box box) {
		return hrRelatedDataService.updateGuardDutyEntry(box);
	}

	/**
	 * --------------------------- WARD DUTY ENTRY ------------------------
	 */
	public Map<String, Object> getEmployeeDetailsForWardDutyAdd(Box box) {
		return hrRelatedDataService.getEmployeeDetailsForWardDutyAdd(box);
	}

	public Map<String, Object> getGridDataForWardEmployeeAdd(Box box) {
		return hrRelatedDataService.getGridDataForWardEmployeeAdd(box);
	}

	public Map<String, Object> getEmployeeDetailsForWardDuty(Box box) {
		return hrRelatedDataService.getEmployeeDetailsForWardDuty(box);
	}

	public Map<String, Object> getGridDataForWardEmployee(Box box) {
		return hrRelatedDataService.getGridDataForWardEmployee(box);
	}

	public boolean AddWardDutyEntry(Box box) {
		return hrRelatedDataService.AddWardDutyEntry(box);
	}

	public Map<String, Object> getWardEmployeeLastDutyDetails(Box box) {
		return hrRelatedDataService.getWardEmployeeLastDutyDetails(box);
	}

	public boolean updateWardDutyEntry(Box box) {
		return hrRelatedDataService.updateWardDutyEntry(box);
	}

	/**
	 * --------------------------- OREDRELY DUTY ENTRY ------------------------
	 */
	public Map<String, Object> getEmployeeDetailsForOrderlyDutyAdd(Box box) {
		return hrRelatedDataService.getEmployeeDetailsForOrderlyDutyAdd(box);
	}

	public Map<String, Object> getGridDataForOrderlyEmployeeAdd(Box box) {
		return hrRelatedDataService.getGridDataForOrderlyEmployeeAdd(box);
	}

	public Map<String, Object> getEmployeeDetailsForOrderlyDuty(Box box) {
		return hrRelatedDataService.getEmployeeDetailsForOrderlyDuty(box);
	}

	public Map<String, Object> getGridDataForOrderlyEmployee(Box box) {
		return hrRelatedDataService.getGridDataForOrderlyEmployee(box);
	}

	public boolean AddOrderlyDutyEntry(Box box) {
		return hrRelatedDataService.AddOrderlyDutyEntry(box);
	}

	public Map<String, Object> getOrderlyEmployeeLastDutyDetails(Box box) {
		return hrRelatedDataService.getOrderlyEmployeeLastDutyDetails(box);
	}

	public boolean updateOrderlyDutyEntry(Box box) {
		return hrRelatedDataService.updateOrderlyDutyEntry(box);
	}

	/**
	 * --------------------------- RANGE FIRING DUTY ENTRY
	 * ------------------------
	 */
	public Map<String, Object> getEmployeeDetailsForRangeFiringDutyAdd(Box box) {
		return hrRelatedDataService
				.getEmployeeDetailsForRangeFiringDutyAdd(box);
	}

	public Map<String, Object> getGridDataForRangeFiringEmployeeAdd(Box box) {
		return hrRelatedDataService.getGridDataForRangeFiringEmployeeAdd(box);
	}

	public Map<String, Object> getEmployeeDetailsForRangeFiringDuty(Box box) {
		return hrRelatedDataService.getEmployeeDetailsForRangeFiringDuty(box);
	}

	public Map<String, Object> getGridDataForRangeFiringEmployee(Box box) {
		return hrRelatedDataService.getGridDataForRangeFiringEmployee(box);
	}

	public boolean AddRangeFiringDutyEntry(Box box) {
		return hrRelatedDataService.AddRangeFiringDutyEntry(box);
	}

	public boolean updateRangeFiringDutyEntry(Box box) {
		return hrRelatedDataService.updateRangeFiringDutyEntry(box);
	}

	public Map<String, Object> searchRangeFiringDutyEntry(Box box) {
		return hrRelatedDataService.searchRangeFiringDutyEntry(box);
	}

	/**
	 * ---------------------------------- DUTY DISPLAY ---------------------
	 */

	public Map<String, Object> searchDutyDisplay(Box box) {
		return hrRelatedDataService.searchDutyDisplay(box);
	}

	/**
	 *------------------------ Duty Exemption Entry ----------------------
	 */

	public Map<String, Object> showDutyExemptionSearchJsp() {
		return hrRelatedDataService.showDutyExemptionSearchJsp();
	}

	public Map<String, Object> searchEmployeeForDutyExemption(
			Map<String, Object> employeeMap) {
		return hrRelatedDataService.searchEmployeeForDutyExemption(employeeMap);
	}

	public Map<String, Object> showDutyExemptionEntryJsp(int empId) {
		return hrRelatedDataService.showDutyExemptionEntryJsp(empId);
	}

	public boolean submitDutyExemptionEntry(Box box) {
		return hrRelatedDataService.submitDutyExemptionEntry(box);
	}

	/**
	 * --------------------------- DAILY ROUTINE ENTRY ------------------------
	 */
	public Map<String, Object> getEmployeeDetailsForDailyRoutineAdd(Box box) {
		return hrRelatedDataService.getEmployeeDetailsForDailyRoutineAdd(box);
	}

	public Map<String, Object> getGridDataForDailyRoutineEmployeeAdd(Box box) {
		return hrRelatedDataService.getGridDataForDailyRoutineEmployeeAdd(box);
	}

	public Map<String, Object> getEmployeeDetailsForDailyRoutine(Box box) {
		return hrRelatedDataService.getEmployeeDetailsForDailyRoutine(box);
	}

	public Map<String, Object> getGridDataForDailyRoutineEmployee(Box box) {
		return hrRelatedDataService.getGridDataForDailyRoutineEmployee(box);
	}

	public boolean AddDailyRoutineEntry(Box box) {
		return hrRelatedDataService.AddDailyRoutineEntry(box);
	}

	public boolean updateDailyRoutineEntry(Box box) {
		return hrRelatedDataService.updateDailyRoutineEntry(box);
	}

	public Map<String, Object> searchDailyRoutineEntry(Box box) {
		return hrRelatedDataService.searchDailyRoutineEntry(box);
	}

	public Map<String, Object> showDailyRoutineEntryJsp() {
		return hrRelatedDataService.showDailyRoutineEntryJsp();
	}

	/**
	 * ----------------------- UPDATE ARRIVAL ENTRY -------------------------
	 */

	public Map<String, Object> showUpdateArrivalSearchJsp() {
		return hrRelatedDataService.showUpdateArrivalSearchJsp();
	}

	public Map<String, Object> searchEmployeeForUpdateArrival(
			Map<String, Object> employeeMap) {
		return hrRelatedDataService.searchEmployeeForUpdateArrival(employeeMap);
	}

	public Map<String, Object> showUpdateArrivalEntryJsp(int empId) {
		return hrRelatedDataService.showUpdateArrivalEntryJsp(empId);
	}

	public boolean submitUpdateArrivalEntry(Box box) {
		return hrRelatedDataService.submitUpdateArrivalEntry(box);
	}

	/**
	 * -------------------- LEAVE APPLICATION PENDING FOR RECOMMENDATION
	 * ----------------------------
	 */

	public Map<String, Object> searchEmployeeForLeavePending(
			Map<String, Object> employeeMap) {
		return hrRelatedDataService.searchEmployeeForLeavePending(employeeMap);
	}

	public Map<String, Object> showLeavePendingEntryJsp(int empId) {
		return hrRelatedDataService.showLeavePendingEntryJsp(empId);
	}

	public boolean submitLeavePendingEntry(Box box) {
		return hrRelatedDataService.submitLeavePendingEntry(box);
	}

	public Map<String, Object> showGuardDutyEntryJsp() {
		return hrRelatedDataService.showGuardDutyEntryJsp();
	}

	public Map<String, Object> showNightDutyEntryJsp() {
		return hrRelatedDataService.showNightDutyEntryJsp();
	}

	public Map<String, Object> showOrderlyDutyEntryJsp() {
		return hrRelatedDataService.showOrderlyDutyEntryJsp();
	}

	public Map<String, Object> showWardDutyEntryJsp() {
		return hrRelatedDataService.showWardDutyEntryJsp();
	}

	/**
	 * ---------------------------- DELETE METHODS
	 * --------------------------------
	 */

	public boolean deleteGuardDutyEntry(Box box) {
		return hrRelatedDataService.deleteGuardDutyEntry(box);
	}

	public boolean deleteNightDutyEntry(Box box) {
		return hrRelatedDataService.deleteNightDutyEntry(box);
	}

	public boolean deleteOrderlyDutyEntry(Box box) {
		return hrRelatedDataService.deleteOrderlyDutyEntry(box);
	}

	public boolean deleteWardDutyEntry(Box box) {
		return hrRelatedDataService.deleteWardDutyEntry(box);
	}

	public boolean deleteDailyRoutineDutyEntry(Box box) {
		return hrRelatedDataService.deleteDailyRoutineDutyEntry(box);
	}

	/**
	 * ------------------------- SEARCH METHODS ON THE MAIN DUTY SCREENS
	 * -----------------------
	 */

	public Map<String, Object> searchNightDutyData(Box box) {
		return hrRelatedDataService.searchNightDutyData(box);
	}

	public Map<String, Object> searchDailyRoutineDutyData(Box box) {
		return hrRelatedDataService.searchDailyRoutineDutyData(box);
	}

	public Map<String, Object> searchGuardDutyData(Box box) {
		return hrRelatedDataService.searchGuardDutyData(box);
	}

	public Map<String, Object> searchOrderlyDutyData(Box box) {
		return hrRelatedDataService.searchOrderlyDutyData(box);
	}

	public Map<String, Object> searchWardDutyData(Box box) {
		return hrRelatedDataService.searchWardDutyData(box);
	}

	/**
	 * ------------------------- METHODS FOR SEARCH ON ADDITION POP UP SCREEN
	 * -------------------
	 */

	public Map<String, Object> searchGuardDutyEntry(Box box) {
		return hrRelatedDataService.searchGuardDutyEntry(box);
	}

	public Map<String, Object> searchNightDutyEntry(Box box) {
		return hrRelatedDataService.searchNightDutyEntry(box);
	}

	public Map<String, Object> searchOrderlyDutyEntry(Box box) {
		return hrRelatedDataService.searchOrderlyDutyEntry(box);
	}

	public Map<String, Object> searchWardDutyEntry(Box box) {
		return hrRelatedDataService.searchWardDutyEntry(box);
	}

	public Map<String, Object> getConnectionForReport() {
		return hrRelatedDataService.getConnectionForReport();
	}

	public Map<String, Object> showEstablishmentReportJsp() {
		return hrRelatedDataService.showEstablishmentReportJsp();
	}

	public Map<String, Object> showDepartmentWiseReportJsp() {
		return hrRelatedDataService.showDepartmentWiseReportJsp();
	}

	public Map<String, Object> showRankWiseReportJsp() {
		return hrRelatedDataService.showRankWiseReportJsp();
	}

	public Map<String, Object> showSpecialistWiseReportJsp() {
		return hrRelatedDataService.showSpecialistWiseReportJsp();
	}

}
