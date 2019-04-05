package jkt.hms.leave.handler;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.HrEmployeeBalance;
import jkt.hms.masters.business.HrEmployeeBalanceNew;
import jkt.hms.masters.business.HrEmployeePersonelDetails;
import jkt.hms.masters.business.HrEncashmentDetails;
import jkt.hms.masters.business.HrLeaveDetails;
import jkt.hms.masters.business.HrMasLeaveType;
import jkt.hms.masters.business.HrMasLeaveTypeMediator;
import jkt.hms.masters.business.HrMasLeaveTypeNew;
import jkt.hms.masters.business.HrUpdateLeaveBalanceHistory;
/*import jkt.hms.masters.business.HrUserLeavebalance;*/

public interface LeaveDetailsHandlerService 
{
	public Map<String, Object> getLeaveListJsp(Map<String, Object> generalMap);
	
	public Map<String, Object> getEmpPersonalDeatil(int uid);
	
	public void updateLeavePolicy();
	
	public void updateLeaveBalanceMonthly();
	
	List getLeaveTypeList();

	void submitLeaveForm(HrLeaveDetails leave,int userId,String applierId);

	@SuppressWarnings("unchecked")
	List getWaitingLeavesList(MasEmployee user);

	List getApprovedLeavesList(MasEmployee user);

	List getDisapprovedLeavesList(MasEmployee user);

	List getLeavesList(int empId);
	
	List getLeaveStatusList();

	Map approveLeaves(String[] approve,MasEmployee user,String remarks);

	void disapproveLeaves(String[] disapprove,MasEmployee user,String disapproveMessage);

	List getEmpNamesList(int userId);

	void sendSuggestion(String[] suggestion, MasEmployee user, String suggestionMessage);

	int getRH(List<HrLeaveDetails> leaveList, String first_half_start, String first_half_end) throws IOException, ParseException;

	List<HrEmployeeBalanceNew> getLeaveBalance(int empId);
	
	List<HrEmployeeBalanceNew> getLeaveBalance(int empId,String leaveType);

	List getManager(int userId);

	List getRestrictedHolidays();

	
	List getHolidays();
	
	Map getEmpLeaveDetails(int empId);
	
	List getManagers();

	void updateLeaveBalance(HrUpdateLeaveBalanceHistory leaveHistory, String newLeaveBalance, String newOnsiteUkBalance, int empId, String balanceAdjustedBy);

	Map getEmailId(int hrId, int empId);

	List viewLeaveHistory(int empId);

	Map leaveRecord(int leaveId);
 
	List getRhAvailed(MasEmployee user);

	List getBirthdayLeave(int empId);

	List getAnniversaryLeave(int empId);

	List getPaternityLeave(int empId);

	List getWaitingEncashmentLeave(MasEmployee user);

	Map deleteLeaves(String[] delete, MasEmployee user, String deleteMessage);

	MasEmployee getMemberDetails(int memberId);

	List getAllWaitingLeavesForHR(int eid);

	List<HrLeaveDetails> getLeavesList(Integer id, String fromDate, String toDate, String leaveType, String leaveStatus);
	
	void submitLeaveForm(List<HrLeaveDetails> optionalleaveList,int userId,String applierId);
	
	public Map getAddOrEdit(MasEmployee user);
	
	public List getMasLeaveTypeList() ;
	
	public List getMasLeaveTypeList(int leaveType);
	
	public void submitTypeMaster(HrMasLeaveType hrMasLeaveType);
	
	public List getMasLeaveTypeListForId(int id) ;
	
	public void updateTypeMaster(HrMasLeaveType hrMasLeaveType) ;
	
	public List getEncashableMasLeaveType(int empId) ;
	
	public void applyForEncashment(HrEncashmentDetails encashmentDetails) ;
	
	public void saveEmployeeLeaveBalanceHistory(HrEmployeeBalance employeeBalance) ;
	
	public void saveEmployeeLeaveBalance(HrEmployeeBalance employeeBalance) ;
	
	public void disapproveLeavesEncashment(String[] disapprove,MasEmployee user,String disapproveMessage);
	
	public void approveLeavesEncashment(String[] approve,MasEmployee user,String remarks) ;
	
	public void onHoldEncashment(String[] suggestion,MasEmployee user,String suggestionMessage) ;
	
	public List getApprovedLeavesEncashment(MasEmployee user) ;
	
	public List getDisapprovedLeavesEncashment(MasEmployee user);
	
	public List<HrEncashmentDetails> getLeavesEncashmentList(Integer userId, String fromDate, String toDate, String leaveType, String leaveStatus);
	
	public void deleteLeavesEncashment(String[] delete, MasEmployee user, String deleteMessage) ;
	
	public void submitTypeMasterNew(HrMasLeaveTypeNew hrMasLeaveType) ;
	
	public List getMasLeaveTypeNewList(int leaveType) ;
	
	public List getMasLeaveTypeNewForMaxDate(int leaveType,Date maxDate) ;
	
	public void updateLeaveTypeMasterNew(HrMasLeaveTypeNew hrMasLeaveTypeNew) ;
	
	public List getMasLeaveTypeNewList() ;

	public List getMasLeaveTypeMediatorList() ;
	
	public void saveToHrMasLeaveTypeMediator(HrMasLeaveTypeMediator hrMasLeaveTypeMediator) ;
	
	public void updateToHrMasLeaveTypeMediator(HrMasLeaveTypeMediator hrMasLeaveTypeMediator) ;
	
	public void saveEmployeeLeaveBalanceNew(HrEmployeeBalanceNew employeeBalance) ;
	
	public List getMasLeaveTypeNewMinFromDateForLeaveType(int leaveType) ;
	
	public List getTodayApprovedLeavesList(MasEmployee user) ;
	public HrMasLeaveTypeNew getCurrentPolicy(int hrMasLeaveTypeMediatorID);
	public Map<String, Object> getConnectionForReport();
	
	public Map<String, Object> getUserDetails(Map<String, Object> generalMap) ;
	
	public Map<String, Object> showEmpForDept(Map<String, Object> generalMap) ;
	
	public Map<String, Object> getPersonalDetailsPatMatDetails(Map<String, Object> generalMap) ;

	public List getApprovedLeavecancelList(MasEmployee employee);

	public void cancelLeaveAfterApprove(Map map1);

	public Map<String, Object> getEncashment(Map<String, Object> dataMap);
}
