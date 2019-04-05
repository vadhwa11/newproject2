package jkt.hms.leave.controller;

import java.util.ArrayList;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

import jkt.hms.util.HMSUtil;
import jkt.hms.leave.dataservice.LeaveDetailsDataService;
import jkt.hms.leave.handler.LeaveDetailsHandlerService;
import jkt.hms.masters.business.HrMasLeaveTypeMediator;
import jkt.security.masters.handler.UserMasterHandlerService;

public class MonthlyLeaveSchedulerController extends QuartzJobBean {

	private LeaveDetailsHandlerService leaveHandlerService = null;
	private UserMasterHandlerService userMasterHandlerService = null;
	
	protected void executeInternal(JobExecutionContext arg) throws JobExecutionException {
		try{
			System.out.println("in monthly scheduler"+leaveHandlerService);
		
		//	List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediator = new ArrayList<HrMasLeaveTypeMediator>();
		//	leaveHandlerService.updateLeavePolicy(); // Commented For Time Being
			leaveHandlerService.updateLeaveBalanceMonthly();
			
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
