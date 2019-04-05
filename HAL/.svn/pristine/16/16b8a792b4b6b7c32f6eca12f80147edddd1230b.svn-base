package jkt.hms.leave.handler;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import jkt.hms.masters.business.MasEmployee;
import jkt.hms.util.HMSUtil;
import jkt.hms.leave.dataservice.LeaveDetailsDataService;
import jkt.hms.masters.business.HrEmployeeBalance;
import jkt.hms.masters.business.HrEmployeeBalanceNew;
import jkt.hms.masters.business.HrEmployeePersonelDetails;
import jkt.hms.masters.business.HrEncashmentDetails;
import jkt.hms.masters.business.HrLeaveDetails;
import jkt.hms.masters.business.HrMasLeaveType;
import jkt.hms.masters.business.HrMasLeaveTypeMediator;
import jkt.hms.masters.business.HrMasLeaveTypeNew;
import jkt.hms.masters.business.HrUpdateLeaveBalanceHistory;
import jkt.hms.util.LeaveManagementUtil;

public class LeaveDetailsHandlerServiceImpl implements LeaveDetailsHandlerService 
{
	private LeaveDetailsDataService leaveDataService = null;
	
	public List getLeaveTypeList() {
		List leaveTypeList = leaveDataService.getLeaveTypeList();
        return leaveTypeList;
	}

	public Map leaveRecord(int leaveId) {
		Map detailsMap=leaveDataService.leaveRecord(leaveId);
		return detailsMap;
	}

	public List getRestrictedHolidays() {
		List restrictedHolidaysList = leaveDataService.getRestrictedHolidays();
        return restrictedHolidaysList;
	}
	
	public List getHolidays() {
		List holidaysList = leaveDataService.getHolidays();
        return holidaysList;
	}
	
	public List getManager(int userId) {
		List mgr=leaveDataService.getManager(userId);
		return mgr;
	}
	
	public List getManagers() {
		List managersList = leaveDataService.getManagers();
        return managersList;
	}
	
	public void submitLeaveForm(HrLeaveDetails leave,int userId,String applierId) {
		leaveDataService.submitLeaveForm(leave,userId,applierId);
	}
	
	public List getWaitingLeavesList(MasEmployee user) {
		List waitingLeavesList = leaveDataService.waitingLeavesList(user);
        return waitingLeavesList;
	}
	
	public List getApprovedLeavesList(MasEmployee user) {
		List approvedLeavesList = leaveDataService.approvedLeavesList(user);
        return approvedLeavesList;
	}

	public List getDisapprovedLeavesList(MasEmployee user) {
		List disapprovedLeavesList = leaveDataService.disapprovedLeavesList(user);
	    return disapprovedLeavesList;
	}

	public List getLeavesList(int empId) {
		List leaveList = leaveDataService.getLeaveList(empId);
        return leaveList;
	}
	
	public List<HrEmployeeBalanceNew> getLeaveBalance(int empId) {
		List<HrEmployeeBalanceNew> balance = leaveDataService.getLeaveBalance(empId);
		return balance;
	}
	
	public List<HrEmployeeBalanceNew> getLeaveBalance(int empId,String leaveType) {
		List<HrEmployeeBalanceNew> balance = leaveDataService.getLeaveBalance(empId,leaveType);
		return balance;
	}

	public void sendSuggestion(String[] suggestion,MasEmployee user,String suggestionMessage) {
		leaveDataService.sendSuggestion(suggestion,user,suggestionMessage);
	}

	public Map approveLeaves(String[] approve,MasEmployee user,String remarks) {
		return leaveDataService.approveLeaves(approve,user,remarks);		
	}

	public void disapproveLeaves(String[] disapprove,MasEmployee user,String disapproveMessage) {
		leaveDataService.disapproveLeaves(disapprove,user,disapproveMessage);
	}
	
	public Map deleteLeaves(String[] delete, MasEmployee user,String deleteMessage) {
		 return leaveDataService.deleteLeaves(delete,user,deleteMessage);
	}
	
	public List getEmpNamesList(int userId) {
		List empNamesList = leaveDataService.getempNamesList(userId);
        return empNamesList;
	}
	
	public LeaveDetailsDataService getLeaveDataService() {
		return leaveDataService;
	}

	public void setLeaveDataService(LeaveDetailsDataService leaveDataService) {
		this.leaveDataService = leaveDataService;
	}

	public int getRH(List<HrLeaveDetails> leaveList,String startDuration,String endDuration) throws IOException, ParseException
	{
		Properties properties = LeaveManagementUtil.loadProperyFile("holiday.properties");
		int rhCode = Integer.parseInt(properties.get("RestrictedHoliday").toString());
		Date startDate =HMSUtil.dateFormatterDDMMYYYY(properties.getProperty(startDuration).toString());
        Date endDate = HMSUtil.dateFormatterDDMMYYYY(properties.getProperty(endDuration).toString());
        int restrictedHoliday = 1;
        for (HrLeaveDetails details : leaveList) 
        {
        	if(details.getLeaveType().getId() == rhCode && details.getLeaveStatus().getId()== 2)
        	{
        		Date fromDate = details.getFromDate();
        		if(LeaveManagementUtil.compareDates(fromDate, startDate) >= 0 && LeaveManagementUtil.compareDates(fromDate,endDate) < 0)
        		{
        			restrictedHoliday--;
        		}
        	}
		}
		return restrictedHoliday;
	}

	public Map getEmpLeaveDetails(int empId) {
		Map empLeaveDeatils = leaveDataService.getEmpLeaveDetails(empId);
		return empLeaveDeatils;
	}

	public void updateLeaveBalance(HrUpdateLeaveBalanceHistory leaveHistory, String newLeaveBalance, String newOnsiteUkBalance, int empId, String balanceAdjustedBy) {
		leaveDataService.updateLeaveBalance(leaveHistory, newLeaveBalance,newOnsiteUkBalance, empId, balanceAdjustedBy);
	}

	public Map getEmailId(int hrId, int empId) {
		Map adminEmailIdList = leaveDataService.getEmailId(hrId, empId);
		return adminEmailIdList;
	}

	public List viewLeaveHistory(int empId) {
		List leaveHistoryList = leaveDataService.viewLeaveHistory(empId);
		return leaveHistoryList;
	}

	public List getRhAvailed(MasEmployee user) {
		List availedRhList = leaveDataService.getAvailedRhList(user);
        return availedRhList;
	}

	public List getBirthdayLeave(int empId) {
		List birthdayLeaveList = leaveDataService.getBirthdayLeave(empId);
		return birthdayLeaveList;
	}

	public List getAnniversaryLeave(int empId) {
		List anniversaryLeaveList = leaveDataService.getAnniversaryLeave(empId);
		return anniversaryLeaveList;
	}

	public List getPaternityLeave(int empId) {
		List paternityLeaveList = leaveDataService.getPaternityLeave(empId);
		return paternityLeaveList;
	}

	public List getWaitingEncashmentLeave(MasEmployee user) {
		List encashmentLeaveWaiting= leaveDataService.getWaitingEncashmentLeave(user);
		return encashmentLeaveWaiting;
	}

	public MasEmployee getMemberDetails(int memberId) {
		MasEmployee memberDetail= leaveDataService.getMemberDetails(memberId);
		return memberDetail;
	}

	public List getAllWaitingLeavesForHR(int eid) {
		List allWaitingLeavesList = leaveDataService.getAllWaitingLeavesForHR(eid);
        return allWaitingLeavesList;
	}

	public List getLeaveStatusList() {
		List leaveStatusList  = leaveDataService.getLeaveStatusList();
		return leaveStatusList;
	}

	public List<HrLeaveDetails> getLeavesList(Integer id, String fromDate, String toDate, String leaveType, String leaveStatus) {
		List<HrLeaveDetails> leaveDetailsList = leaveDataService.getLeavesList(id, fromDate, toDate, leaveType, leaveStatus); 
		return leaveDetailsList;
	}

	public void submitLeaveForm(List<HrLeaveDetails> optionalleaveList, int userId, String applierId) {
		leaveDataService.submitLeaveForm(optionalleaveList,userId,applierId);
		
	}

	public Map getAddOrEdit(MasEmployee user) {
		return leaveDataService.getAddOrEdit(user);
	}
	public List getMasLeaveTypeList() {
		return leaveDataService.getMasLeaveTypeList();
	}
	public List getMasLeaveTypeList(int leaveType) {
		return leaveDataService.getMasLeaveTypeList(leaveType);
	}
	
	public void submitTypeMaster(HrMasLeaveType hrMasLeaveType) {
		leaveDataService.submitTypeMaster(hrMasLeaveType);
	}
	public List getMasLeaveTypeListForId(int id) {
		return leaveDataService.getMasLeaveTypeListForId(id);
	}
	public void updateTypeMaster(HrMasLeaveType hrMasLeaveType) {
		leaveDataService.updateTypeMaster(hrMasLeaveType);
	}
	
	public List getEncashableMasLeaveType(int empId) {
		return leaveDataService.getEncashableMasLeaveType(empId);
	}
	
	public void applyForEncashment(HrEncashmentDetails encashmentDetails) {
		leaveDataService.applyForEncashment(encashmentDetails);
	}
	
	public void saveEmployeeLeaveBalanceHistory(HrEmployeeBalance employeeBalance) {
		leaveDataService.saveEmployeeLeaveBalanceHistory(employeeBalance);
	}
	
	public void saveEmployeeLeaveBalance(HrEmployeeBalance employeeBalance) {
		leaveDataService.saveEmployeeLeaveBalance(employeeBalance);
	}
	
	public void disapproveLeavesEncashment(String[] disapprove,MasEmployee user,String disapproveMessage) {
		leaveDataService.disapproveLeavesEncashment(disapprove,user,disapproveMessage);
	}

	public void approveLeavesEncashment(String[] approve,MasEmployee user,String remarks) {
		leaveDataService.approveLeavesEncashment(approve,user,remarks);
	}
	
	public void onHoldEncashment(String[] suggestion,MasEmployee user,String suggestionMessage) {
		leaveDataService.onHoldEncashment(suggestion,user,suggestionMessage);
	}
	
	public List getApprovedLeavesEncashment(MasEmployee user) {
		List approvedLeavesList = leaveDataService.getApprovedLeavesEncashment(user);
        return approvedLeavesList;
	}
	
	public List getDisapprovedLeavesEncashment(MasEmployee user) {
		List disapprovedLeavesList = leaveDataService.getDisapprovedLeavesEncashment(user);
	    return disapprovedLeavesList;
	}
	
	public List<HrEncashmentDetails> getLeavesEncashmentList(Integer userId, String fromDate, String toDate, String leaveType, String leaveStatus) {
		List<HrEncashmentDetails> leaveDetailsList = leaveDataService.getLeavesEncashmentList(userId, fromDate, toDate, leaveType, leaveStatus); 
		return leaveDetailsList;
	}

	public void deleteLeavesEncashment(String[] delete, MasEmployee user, String deleteMessage) {
		leaveDataService.deleteLeavesEncashment(delete,user,deleteMessage);
	}
	
	public void submitTypeMasterNew(HrMasLeaveTypeNew hrMasLeaveType) {
		leaveDataService.submitTypeMasterNew(hrMasLeaveType);
	}
	
	public List getMasLeaveTypeNewList(int leaveType) {
		return leaveDataService.getMasLeaveTypeNewList(leaveType);
	}
	
	public List getMasLeaveTypeNewForMaxDate(int leaveType,Date maxDate) {
		return leaveDataService.getMasLeaveTypeNewForMaxDate(leaveType, maxDate);
	}
	
	public void updateLeaveTypeMasterNew(HrMasLeaveTypeNew hrMasLeaveTypeNew) {
		leaveDataService.updateLeaveTypeMasterNew(hrMasLeaveTypeNew);
	}
	
	public List getMasLeaveTypeNewList() {
		return leaveDataService.getMasLeaveTypeNewList();
	}
	
	public List getMasLeaveTypeMediatorList() {
		return leaveDataService.getMasLeaveTypeMediatorList();
	}
	
	public void saveToHrMasLeaveTypeMediator(HrMasLeaveTypeMediator hrMasLeaveTypeMediator) {
		leaveDataService.saveToHrMasLeaveTypeMediator(hrMasLeaveTypeMediator);
	}
	
	public void updateToHrMasLeaveTypeMediator(HrMasLeaveTypeMediator hrMasLeaveTypeMediator) {
		leaveDataService.updateToHrMasLeaveTypeMediator(hrMasLeaveTypeMediator);	
	}
	
	public void saveEmployeeLeaveBalanceNew(HrEmployeeBalanceNew employeeBalance) {
		leaveDataService.saveEmployeeLeaveBalanceNew(employeeBalance);
	}
	
	public List getMasLeaveTypeNewMinFromDateForLeaveType(int leaveType) {
		return leaveDataService.getMasLeaveTypeNewMinFromDateForLeaveType(leaveType);
	}
	
	public List getTodayApprovedLeavesList(MasEmployee user) {
		return leaveDataService.getTodayApprovedLeavesList(user);	
	}

	public void updateLeavePolicy() {
		// TODO Auto-generated method stub
		leaveDataService.updateLeavePolicy();
	}

	public void updateLeaveBalanceMonthly() {
		// TODO Auto-generated method stub
		leaveDataService.updateLeaveBalanceMonthly();
	}

	public HrMasLeaveTypeNew getCurrentPolicy(int hrMasLeaveTypeMediatorID) {
		// TODO Auto-generated method stub
		return leaveDataService.getCurrentPolicy(hrMasLeaveTypeMediatorID);
	}

	public Map<String, Object> getConnectionForReport() {
		// TODO Auto-generated method stub
		return leaveDataService.getConnectionForReport();
	}

	public Map<String, Object> getEmpPersonalDeatil(int uid) {
		return leaveDataService.getEmpPersonalDeatil(uid);
	}

	public Map<String, Object> getLeaveListJsp(Map<String, Object> generalMap){
		// TODO Auto-generated method stub
		return leaveDataService.getLeaveListJsp(generalMap);
	}
	public Map<String, Object> getUserDetails(Map<String, Object> generalMap) {
		return leaveDataService.getUserDetails(generalMap);
	}
	
	public Map<String, Object> showEmpForDept(Map<String, Object> generalMap) {
		return leaveDataService.showEmpForDept(generalMap);
	}
	
	public Map<String, Object> getPersonalDetailsPatMatDetails(Map<String, Object> generalMap) {
		return leaveDataService.getPersonalDetailsPatMatDetails(generalMap);
	}

	@Override
	public List getApprovedLeavecancelList(MasEmployee employee) {
		return leaveDataService.getApprovedLeavecancelList(employee);
	}

	@Override
	public void cancelLeaveAfterApprove(Map map1) {
		 leaveDataService.cancelLeaveAfterApprove(map1);
		
	}

	@Override
	public Map<String, Object> getEncashment(Map<String, Object> dataMap) {
		return leaveDataService.getEncashment(dataMap);
	}
}
