package jkt.hms.leave.controller;

import jkt.hms.leave.handler.LeaveDetailsHandlerService;
import jkt.security.masters.handler.UserMasterHandlerService;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class YearlyLeavePolicySchedulerController extends QuartzJobBean {
	
	private LeaveDetailsHandlerService leaveHandlerService = null;
	private UserMasterHandlerService userMasterHandlerService = null;
	
	protected void executeInternal(JobExecutionContext arg) throws JobExecutionException {
		try{
			System.out.println("in yearly scheduler");
		
		//	List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediator = new ArrayList<HrMasLeaveTypeMediator>();
		// commented 
			//	leaveHandlerService.updateLeavePolicy();
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public UserMasterHandlerService getUserMasterHandlerService() {
		return userMasterHandlerService;
	}
	public void setUserMasterHandlerService(UserMasterHandlerService userMasterHandlerService) {
		this.userMasterHandlerService = userMasterHandlerService;
	}
	public LeaveDetailsHandlerService getLeaveHandlerService() {
		return leaveHandlerService;
	}
	public void setLeaveHandlerService(LeaveDetailsHandlerService leaveHandlerService) {
		this.leaveHandlerService = leaveHandlerService;
	}


}
