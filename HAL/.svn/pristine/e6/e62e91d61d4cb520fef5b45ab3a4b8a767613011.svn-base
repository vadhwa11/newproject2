package jkt.hms.leave.dataservice;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hms.masters.business.Holidaycalendar;
import jkt.hms.masters.business.HrAccruelRecord;
import jkt.hms.masters.business.HrEmployeeBalance;
import jkt.hms.masters.business.HrEmployeeBalanceHistory;
import jkt.hms.masters.business.HrEmployeeBalanceNew;
import jkt.hms.masters.business.HrEmployeeBalanceNewHistory;
import jkt.hms.masters.business.HrEmployeePersonelDetails;
import jkt.hms.masters.business.HrEncashmentDetails;
import jkt.hms.masters.business.HrEncashmentDetailsHistory;
import jkt.hms.masters.business.HrLeaveDetails;
import jkt.hms.masters.business.HrLeaveDetailsHistory;
import jkt.hms.masters.business.HrMasLeave;
import jkt.hms.masters.business.HrMasLeaveStatus;
import jkt.hms.masters.business.HrMasLeaveType;
import jkt.hms.masters.business.HrMasLeaveTypeBackup;
import jkt.hms.masters.business.HrMasLeaveTypeHistory;
import jkt.hms.masters.business.HrMasLeaveTypeMediator;
import jkt.hms.masters.business.HrMasLeaveTypeMediatorHistory;
import jkt.hms.masters.business.HrMasLeaveTypeNew;
import jkt.hms.masters.business.HrUpdateLeaveBalanceHistory;
import jkt.hms.masters.business.UserManager;
import jkt.hms.util.LeaveManagementUtil;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/*import sun.util.calendar.Era;*/

public class LeaveDetailsDataServiceImpl extends HibernateDaoSupport implements LeaveDetailsDataService
{
	Session session=null;

	public List getLeaveTypeList() {
		List<HrMasLeave> leaveType=new ArrayList<HrMasLeave>();

		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(HrMasLeave.class);

		crit = crit.add(Restrictions.eq("Status", "y" ));

		Order order=Order.asc("Id");
		crit = crit.addOrder(order);

		leaveType = crit.list();

//		leaveType=hbt.find("from jkt.hms.masters.business.HrMasLeave as leave");

		return leaveType;
	}

	@SuppressWarnings("unchecked")
	public Map leaveRecord(int leaveId) {
		HrLeaveDetails leaveDetails=(HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, leaveId);
		List userList = (List)getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee us where us.Id = "+leaveDetails.getLeaveApprovedBy().getId());
		Map detailsMap = new HashMap();
		detailsMap.put("leaveDetails", leaveDetails);
		detailsMap.put("userList", userList);
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public List getManager(int userId) {
		//List<MasEmployee> manager=(List<MasEmployee>)getHibernateTemplate().find("from com.jkt.intranet.business.UserManager as mgr where mgr.EmpId="+userId);
		//changes
		List<UserManager> manager=(List<UserManager>)getHibernateTemplate().find("from jkt.hms.masters.business.UserManager as mgr where mgr.EmpId="+userId);
		return manager;
	}

	@SuppressWarnings("unchecked")
	public List getRestrictedHolidays(){
		//Date today = new Date();

		List<Holidaycalendar> rholidays=getHibernateTemplate().find("from jkt.hms.masters.business.Holidaycalendar as h where h.Rh='yes' and h.HolidayDate >'"+HMSUtil.getDateFormat(new Date(), "yyyy-MM-dd")+"'");
		return rholidays;
	}

	@SuppressWarnings("unchecked")
	public List getHolidays(){
		Calendar calendar = Calendar.getInstance();
		Integer currentYear =  calendar.get(Calendar.YEAR);
			//System.out.println("currentYear==="+currentYear);
		List<Holidaycalendar> holidays=getHibernateTemplate().find("from jkt.hms.masters.business.Holidaycalendar as h where h.Rh='no' and HolidayListYear = '" + currentYear.toString() + "'");
		return holidays;
	}

	@SuppressWarnings("unchecked")
	public List getManagers() {
		List listOfManagers=null;
		listOfManagers=(List<MasEmployee>)getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee as user where user.Id IN( select distinct mgr.ManagerId from jkt.hms.masters.business.UserManager as mgr) order by user.FirstName");
		return listOfManagers;
	}

	public void submitLeaveForm(HrLeaveDetails leave,int userId,String applierId) {
		String fromToDate="";
		String halfDayLeave="";
		getHibernateTemplate().save(leave);
		saveLeaveHistory(leave);
		MasEmployee manager = (MasEmployee)getHibernateTemplate().load(MasEmployee.class, leave.getLeaveApprovedBy().getId());
		HrLeaveDetails leaveDetails= new HrLeaveDetails();
		leaveDetails= (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, leave.getId());
		if(leave.getFromDate()!=null && leave.getToDate()!=null){
			fromToDate="\nLeave period : "+LeaveManagementUtil.convertDateToStringWithoutTime(leave.getFromDate())+" to "+LeaveManagementUtil.convertDateToStringWithoutTime(leave.getToDate());
		}
		else
			fromToDate="\nNo. of days : "+leave.getNoOfWorkingDays();
		if(leave.getHalfDay()!=null || "".equals(leave.getHalfDay()))
			halfDayLeave="\nHalf Day Leave : "+leave.getHalfDay();
		//System.out.println(leaveDetails.getEmpId());
		String emailMessage="There is a leave with leave ID "+leave.getId() +" applied by "+leaveDetails.getEmpId().getFirstName()+" with employee code "+leaveDetails.getEmpId().getEmployeeCode()+
		" and base location "+leaveDetails.getEmpId()/*.getLocation().getLocationDesc()*/ +" waiting for the approval.\n"+
		//	"\nLeave ID is : "+leave.getId()+
		"\nLeave Status is : Waiting"+
		"\nLeave Type is : "+leaveDetails.getLeaveType().getLeaveType().getLeaveType().getDescription()+
		halfDayLeave+
		fromToDate;
		String hrEmailId = getHRLeaveEmail();
		@SuppressWarnings("unused")
		String recipientAddresses = manager.getEmail().concat(",").concat(hrEmailId);
		//mail
		//LeaveManagementUtil.intranetEmailFunction(recipientAddresses, applierId, emailMessage, "Leave Application");
	}
	@SuppressWarnings("unchecked")
	public List waitingLeavesList(MasEmployee user ) {
		
		List<Object> waitingLeaves=new ArrayList<Object>();
		waitingLeaves=getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id = 3 and leave.leaveApprovedBy.Id = "+user.getId()+" order by leave.Id");
		
		return waitingLeaves;
	}

	@SuppressWarnings("unchecked")
	public List approvedLeavesList(MasEmployee user) {
		List<Object> approvedLeaves=new ArrayList<Object>();
		approvedLeaves=getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id=2 and leave.leaveApprovedBy.Id = "+user.getId()+" order by leave.FromDate desc");
		return approvedLeaves;
	}

	@SuppressWarnings("unchecked")
	public List getApprovedLeavesEncashment(MasEmployee user) {
		List<Object> approvedLeaves=new ArrayList<Object>();
		approvedLeaves=getHibernateTemplate().find("from jkt.hms.masters.business.HrEncashmentDetails as leave where leave.LeaveStatus.Id=2 and leave.ApprovedBy.Id = "+user.getId()+" order by leave.ApprovedOn desc");
		return approvedLeaves;
	}

/*	public List getTodayApprovedLeavesEncashment(MasEmployee user) {
		List<HrEncashmentDetails> approvedLeaves=new ArrayList<HrEncashmentDetails>();

		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(HrEncashmentDetails.class);

		Date currentDate = new Date();

		crit = crit.add(Restrictions.eq("ApprovedBy.Id", user.getId() ));
		crit = crit.add(Restrictions.eq("LeaveStatus.Id", 2 ));
		crit = crit.add(Restrictions.ge("FromDate",currentDate ));
		crit = crit.add(Restrictions.le("ToDate",currentDate ));

		Order order=Order.asc("Id");
		crit = crit.addOrder(order);//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));

		approvedLeaves = crit.list();

		approvedLeaves=getHibernateTemplate().find("from jkt.hms.masters.business.HrEncashmentDetails as leave where leave.LeaveStatus.Id=2 and leave.ApprovedBy.Id = "+user.getId());

		return approvedLeaves;
	}*/

	@SuppressWarnings("unchecked")
	public List getTodayApprovedLeavesList(MasEmployee user) {
		List<HrLeaveDetails> approvedLeaves=new ArrayList<HrLeaveDetails>();

		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(HrLeaveDetails.class);

		Date currentDate = new Date();

		crit = crit.add(Restrictions.eq("leaveApprovedBy.Id", user.getId() ));
		crit = crit.add(Restrictions.eq("leaveStatus.Id", 2 ));
		crit = crit.add(Restrictions.le("FromDate",currentDate ));
		crit = crit.add(Restrictions.ge("ToDate",currentDate ));

		Order order=Order.asc("Id");
		crit = crit.addOrder(order);//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));

		approvedLeaves = crit.list();

		//System.out.println("Size of today :"+approvedLeaves.size() );

		return approvedLeaves;

	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public List disapprovedLeavesList(MasEmployee user) {
		List<Object> disapprovedLeaves=new ArrayList<Object>();
		disapprovedLeaves=getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id=4 and leave.leaveApprovedBy.Id = "+user.getId()+" order by leave.FromDate");
		return disapprovedLeaves;
	}

	@SuppressWarnings("unchecked")
	public List getDisapprovedLeavesEncashment(MasEmployee user) {
		List<Object> disapprovedLeaves=new ArrayList<Object>();
		disapprovedLeaves=getHibernateTemplate().find("from jkt.hms.masters.business.HrEncashmentDetails as leave where leave.LeaveStatus.Id=4 and leave.ApprovedBy.Id = "+user.getId());
		return disapprovedLeaves;
	}


	@SuppressWarnings("unchecked")
	public List getLeaveList(int empId) {
		List<HrLeaveDetails> leaveList=new ArrayList<HrLeaveDetails>();
		//leaveList=getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails as l where l.EmpId.Id="+empId+" and l.leaveStatus.Id<>1 order by l.FromDate");
		leaveList=getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails as l where l.EmpId.Id="+empId+" and l.leaveStatus.Id<>5 order by l.FromDate");
		return leaveList;
	}

	public List<HrEmployeeBalanceNew> getLeaveBalance(int empId) {


		List<HrEmployeeBalanceNew> leaveBal=new ArrayList<HrEmployeeBalanceNew>();

		Session session = (Session)getSession();
		
		Criteria crit = session.createCriteria(HrEmployeeBalanceNew.class).createAlias("Emp", "Emp1");
		crit = crit.add(Restrictions.eq("Emp1.Id", empId ));
		Order order=Order.asc("Id");
		crit = crit.addOrder(order);

		leaveBal = crit.list();
		
		return leaveBal;
	}

	public Map approveLeaves(String[] approve,MasEmployee user,String remarks) {
		String fromToDate="";
		String emailMessage="";
		String firstOrSecondHalf = "";
		String msg="";
		Map detailsMap = new HashMap();
		Session session = (Session)getSession();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Transaction tx = session.beginTransaction();
		try{
			for (int i = 0; i < approve.length; i++) {
				HrLeaveDetails leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, Integer.parseInt(approve[i]));
				Integer balanceId=leaveDetails.getEmpIdBal()!=null?leaveDetails.getEmpIdBal().getId():null;
				double noOfWorkingDays = Float.valueOf(leaveDetails.getNoOfWorkingDays());
				Date currentDate = new Date();
				int appliedFromDateMonth = leaveDetails.getFromDate().getMonth();
				int currentMonth = currentDate.getMonth();
				//changes
				HrMasLeaveStatus leaveStatus =new HrMasLeaveStatus();
				int statusId=0;
				if((leaveDetails!=null) && (leaveDetails.getLeaveStatus().getId()==6)){
					statusId=leaveDetails.getLeaveStatus().getId();
					leaveStatus.setId(5);
				}else{
					leaveStatus.setId(2);
				}
				leaveDetails.setLeaveStatus(leaveStatus);
				leaveDetails.setSuggestion(remarks);


				leaveDetails.setApprovedOn(currentDate);
				hbt.update(leaveDetails);
				hbt.refresh(leaveDetails);
				saveLeaveHistory(leaveDetails);

				HrEmployeeBalanceNew leaveBal=(HrEmployeeBalanceNew)getHibernateTemplate().load(HrEmployeeBalanceNew.class,balanceId);
				String noOfWorkingDaysToSave="";
				if(statusId==6){
					double takenAlready = Float.valueOf(leaveBal.getTaken());
					double takenTotal = takenAlready - noOfWorkingDays;
					String taken =new DecimalFormat("0.##").format((double)takenTotal);

					double closingBal = Float.valueOf(leaveBal.getClosingBalance());
					double closingBalYearly = Float.valueOf(leaveBal.getClosingBalanceYearly());

					double takenTotalYearly = Float.valueOf(leaveBal.getTotalLeaveTaken()) - noOfWorkingDays;
					String takenTotalYearlyStr =new DecimalFormat("0.##").format((double)takenTotalYearly);

					noOfWorkingDaysToSave = new DecimalFormat("0.##").format((double)noOfWorkingDays);
					if(leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(4)
							|| leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(3)){
						leaveBal.setAlreadyAvailedPatMat("n");
					}
					double closingBalAfterAprov = closingBal + noOfWorkingDays;
					double closingBalYearlyAfterAprov = closingBalYearly + noOfWorkingDays;

					//Effect short leave Balance only for current Month
					if(leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(20)){
						if(appliedFromDateMonth == currentMonth){
							leaveBal.setClosingBalance( new DecimalFormat("0.##").format((double)closingBalAfterAprov));
							leaveBal.setTaken(taken);
						}
					}else{
						leaveBal.setClosingBalance( new DecimalFormat("0.##").format((double)closingBalAfterAprov));
						leaveBal.setTaken(taken);
					}

					leaveBal.setClosingBalanceYearly( new DecimalFormat("0.##").format((double)closingBalYearlyAfterAprov));

					leaveBal.setTotalLeaveTaken(takenTotalYearlyStr);
				}else{
					if(leaveDetails.getFromDate().getYear()== (new Date()).getYear()){
					String taken = "";
					double closingBalAfterAprov = 0;
					/*if(leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(20)){
						noOfWorkingDays = 1;
					}
					if(leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(4)
							|| leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(3)){
						leaveBal.setAlreadyAvailedPatMat("y");
					}*/    // commented by atul because it was hard code
					double takenAlready = Float.valueOf(leaveBal.getTaken());
					double takenTotal = takenAlready + noOfWorkingDays;
					taken =new DecimalFormat("0.##").format((double)takenTotal);
					double closingBal = Float.valueOf(leaveBal.getClosingBalance());

					closingBalAfterAprov = closingBal - noOfWorkingDays;

					//System.out.println("closingBalAfterAprov==="+closingBalAfterAprov);

					//Effect short leave Balance only for current Month
					if(leaveBal.getLeaveType()!=null && leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(20)){ // short leave 
						if(appliedFromDateMonth == currentMonth){
							leaveBal.setClosingBalance( new DecimalFormat("0.##").format((double)closingBalAfterAprov));
							leaveBal.setTaken(taken);
						}
					} else {
						
						leaveBal.setClosingBalance( new DecimalFormat("0.##").format((double)closingBalAfterAprov));
						
						leaveBal.setTaken(taken);
					}

					// total taken yearly
					double takenTotalYearly = Float.valueOf(leaveBal.getTotalLeaveTaken()) + noOfWorkingDays;
					String takenTotalYearlyStr =new DecimalFormat("0.##").format((double)takenTotalYearly);
					double closingBalYearly = Float.valueOf(leaveBal.getClosingBalanceYearly());

					double closingBalYearlyAfterAprov = closingBalYearly - noOfWorkingDays;
					leaveBal.setClosingBalanceYearly( new DecimalFormat("0.##").format((double)closingBalYearlyAfterAprov));

					noOfWorkingDaysToSave = new DecimalFormat("0.##").format((double)noOfWorkingDays);
					leaveBal.setTotalLeaveTaken(takenTotalYearlyStr);
					}
				}
				hbt.update(leaveBal);
				hbt.refresh(leaveBal);
				saveEmployeeLeaveBalanceNewHistory(leaveBal, noOfWorkingDaysToSave, "n");

///////////////////////////////////
				//leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, Integer.parseInt(approve[i]));

				String leaveAppliedBy = leaveDetails.getEmpId().getFirstName() + " " + leaveDetails.getEmpId().getLastName();
				String leaveType = leaveDetails.getLeaveType().getLeaveType().getLeaveType().getDescription();

				String subject = "Leave Application/" + leaveType
				   + "/" + leaveAppliedBy
				   + "/" + LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getApprovedOn())
				   + "/" + leaveDetails.getLeaveStatus().getStatusDesc();

				//Subject: Leave Application/Leave type/Emp. Name/Action Date/ Leave Application Status

				//Dear (Title)(First and Last Name)

				//Your Leave application dated:(Date) for (Leave Type) has been (Status).
				//Kindly see the updated leave status by logging into your OMEGA account or by clicking on the link mentioned below.
				//http://www.omega.clinirx.com

///////////////////////////////////////////////////////////////////
				emailMessage = "Dear " + leaveDetails.getEmpId().getTitle().getTitleName()
				                + " " + leaveAppliedBy
				                + ",\n\n";
				if(statusId == 6){
					emailMessage = emailMessage + "Your request for cancellation";
					//+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn());
				}else{
					emailMessage = emailMessage + "Your Leave application dated:"
					+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn());
				}

				if(leaveDetails.getHalfDay() != null && !leaveDetails.getHalfDay().equals("")) {
					if(leaveDetails.getHalfDay().equalsIgnoreCase("f")){
						firstOrSecondHalf = "first half";
					}else if(leaveDetails.getHalfDay().equalsIgnoreCase("s")){
						firstOrSecondHalf = "second half";
					}
					fromToDate=" for a half day " + leaveType + " for " + firstOrSecondHalf;
				} else if (leaveDetails.getShortLeaveHalfDay() != null){
					if(leaveDetails.getShortLeaveHalfDay().equalsIgnoreCase("f")){
						firstOrSecondHalf = "first half";
					}else if(leaveDetails.getShortLeaveHalfDay().equalsIgnoreCase("s")){
						firstOrSecondHalf = "second half";
					}
					fromToDate=" for a " + leaveType + " for " + firstOrSecondHalf;
				} else {
					fromToDate=" for " + leaveType;
				}
/*				if(leaveDetails.getLeaveStatus().getId() == 1){
					emailMessage = emailMessage + fromToDate +
					" has been put" + leaveDetails.getLeaveStatus().getStatusDesc()
						+ ".\n";
				}else */
				if(leaveDetails.getLeaveStatus().getId() == 5){
					msg="Leave has been cancelled ";
					emailMessage = emailMessage + fromToDate +
					" has been approved.\n";
				}else{
					msg="Leave has been Approved ";
					emailMessage = emailMessage + fromToDate +
					" has been " + leaveDetails.getLeaveStatus().getStatusDesc()
						+ ".\n";
				}
				emailMessage = emailMessage + "Kindly see the updated leave status by logging into your KSSC account " +
		                  		"or by clicking on the link mentioned below.\n" +
		                  		"This is an auto generated mail through KSSC. Do not reply.";

				List<String> recipientAddresses = new ArrayList<String>();
				String senderAddresses = new String();
				List<String> ccAddresses = new ArrayList<String>();
				List<String> bccAddresses = new ArrayList<String>();

				if(leaveDetails.getLeaveApprovedBy().getEmail() != null  && !leaveDetails.getLeaveApprovedBy().getEmail().equals("")
						&& leaveDetails.getEmpId().getEmail() != null && !leaveDetails.getEmpId().getEmail().equals("")){
					recipientAddresses.add(leaveDetails.getEmpId().getEmail());
					senderAddresses = new String(leaveDetails.getLeaveApprovedBy().getEmail());

					ccAddresses.add(leaveDetails.getLeaveApprovedBy().getEmail());
					 //ccAddresses.add("hrhelpdesk@clinirx.com");

					LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
							ccAddresses , bccAddresses ,emailMessage, subject);

				}
			}
			tx.commit();
		} catch(Exception exception){
			tx.rollback();
			exception.printStackTrace();
		}
		detailsMap.put("msg", msg);
		return detailsMap;
	}
	public void approveLeavesEncashment(String[] approve,MasEmployee user,String remarks) {
		String enchashedOrSimple ="";
		String emailMessage = "";
		for (int i = 0; i < approve.length; i++) {
			HrEncashmentDetails leaveDetails = (HrEncashmentDetails)getHibernateTemplate().load(HrEncashmentDetails.class, Integer.parseInt(approve[i]));
			int balanceId=leaveDetails.getEmpIdBal().getId();
			double noOfWorkingDays=Float.valueOf(leaveDetails.getLeaveToEncash());
			int typeOfLeave=leaveDetails.getLeaveType().getLeaveType().getId();

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			//changes
			HrMasLeaveStatus leaveStatus =new HrMasLeaveStatus();
			leaveStatus.setId(2);

			leaveDetails.setLeaveStatus(leaveStatus);
			leaveDetails.setRemarks(remarks);
			Date currentDate = new Date();
			leaveDetails.setApprovedOn(currentDate);
			hbt.update(leaveDetails);
			hbt.refresh(leaveDetails);
			saveLeaveEncashmentHistory(leaveDetails);

			if(typeOfLeave!=8 ) {//&& typeOfLeave!=3 && typeOfLeave!=4){
				HrEmployeeBalanceNew leaveBal=(HrEmployeeBalanceNew)getHibernateTemplate().load(HrEmployeeBalanceNew.class,balanceId);

				double takenAlready = Float.valueOf(leaveBal.getTaken());
				double takenTotal = takenAlready + noOfWorkingDays;
				double closingBal= Float.valueOf(leaveBal.getClosingBalance());

				String taken =new DecimalFormat("0.##").format((double)takenTotal);
				String noOfWorkingDaysToSave = new DecimalFormat("0.##").format((double)noOfWorkingDays);
				String strclosingBal = new DecimalFormat("0.##").format(closingBal-noOfWorkingDays);
				enchashedOrSimple = "y";

				double takenAlreadyYearly = Float.valueOf(leaveBal.getTotalLeaveTaken());
				double closingBalYearly = Float.valueOf(leaveBal.getClosingBalanceYearly());
				double takenTotalYearly = takenAlreadyYearly + noOfWorkingDays;

				String strclosingBalYearly = new DecimalFormat("0.##").format(closingBalYearly - noOfWorkingDays);

				leaveBal.setTaken(taken);
				leaveBal.setClosingBalance(strclosingBal);
				leaveBal.setTotalLeaveTaken(new DecimalFormat("0.##").format(takenTotalYearly));
				leaveBal.setClosingBalanceYearly(strclosingBalYearly);

				hbt.update(leaveBal);
				hbt.refresh(leaveBal);
				saveEmployeeLeaveBalanceNewHistory(leaveBal, noOfWorkingDaysToSave, enchashedOrSimple);
			}
///////////////////////////////////
			String leaveAppliedBy = leaveDetails.getEmp().getFirstName() + " " + leaveDetails.getEmp().getLastName();
			String leaveType = leaveDetails.getLeaveType().getLeaveType().getLeaveType().getDescription();

			String subject = "Leave Encashment Request/" + leaveType
			   + "/" + leaveAppliedBy + ":" + leaveDetails.getEmp().getEmployeeCode();
			//Subject: Leave Encashment Request/Leave type/Emp. Name/Action Date/ Leave Application Status

			//Dear (Title)(First and Last Name)

			//Your Leave application dated:(Date) for (Leave Type) has been (Status).
			//Kindly see the updated leave status by logging into your OMEGA account or by clicking on the link mentioned below.
			//http://www.omega.clinirx.com

///////////////////////////////////////////////////////////////////
			emailMessage = "Dear " + leaveDetails.getEmp().getTitle().getTitleName()
			                + " " + leaveAppliedBy
			                + ",\n\n";
			//if(statusId == 6){
			//	emailMessage = emailMessage + "Your request for cancellation";
				//+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn());
		//	}else{
				emailMessage = emailMessage + "Your request for leave encashment dated:"
				+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn());
			//}

			if(leaveDetails.getLeaveStatus().getId() == 1){
				emailMessage = emailMessage +
				" has been put " + leaveDetails.getLeaveStatus().getStatusDesc()
					+ ".\n";
			}else if(leaveDetails.getLeaveStatus().getId() == 5){
				emailMessage = emailMessage + " has been approved.\n";
			}else{
				emailMessage = emailMessage +
				" has been " + leaveDetails.getLeaveStatus().getStatusDesc()
					+ ".\n";
			}
			emailMessage = emailMessage + "Kindly see the updated leave status by logging into your KSSC account " +
	                  		"or by clicking on the link mentioned below.\n" +
	                  		"This is an auto generated mail through KSSC. Do not reply.";

			List<String> recipientAddresses = new ArrayList<String>();
			String senderAddresses = new String();
			List<String> ccAddresses = new ArrayList<String>();
			List<String> bccAddresses = new ArrayList<String>();

			if(leaveDetails.getApprovedBy().getEmail() != null  && !leaveDetails.getApprovedBy().getEmail().equals("")
					&& leaveDetails.getEmp().getEmail() != null && !leaveDetails.getEmp().getEmail().equals("")){
				recipientAddresses.add(leaveDetails.getEmp().getEmail());
				senderAddresses = new String(leaveDetails.getApprovedBy().getEmail());

				ccAddresses.add(leaveDetails.getApprovedBy().getEmail());
				////ccAddresses.add("hrhelpdesk@clinirx.com");

				LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
						ccAddresses , bccAddresses ,emailMessage, subject);
			}
		}
	}

	private String getDUHeadEmail(int empId) {
		//System.out.println("emp id whose leave get approved>>>>>>"+empId);
		//changes
	//	List duHead = getHibernateTemplate().find("from com.jkt.intranet.business.Duempmap as du where du.EmpId =" + empId);
	//	Duempmap dumap = (Duempmap) duHead.get(0);
		//System.out.println("du id>>>"+dumap.getDuId());
		//System.out.println("emp under above du >>>"+dumap.getEmpId());
		//String emailId = dumap.getSelectedEmpDuMaster().getDuHeadName().getEmailId();
		//return emailId;
		return "ddd.ddd@jktech.com";
	}

	private String getHRLeaveEmail() {
		//changes
		//List<CategoryUser> hrUser = getHibernateTemplate().find("from com.jkt.intranet.business.CategoryUser as catUser where catUser.CategoryId =15");
		//CategoryUser catUser = hrUser.get(0);
		//return catUser.getUsers().getEmailId();
		return "nares.dfssf@jktech.com";
	}

	public void disapproveLeaves(String[] disapprove,MasEmployee user,String disapproveMessage) {
		String fromToDate="";
		String emailMessage = "";
		String firstOrSecondHalf = "";

		for (int i = 0; i < disapprove.length; i++) {
			HrLeaveDetails leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, Integer.parseInt(disapprove[i]));

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			//changes
			HrMasLeaveStatus leaveStatus =new HrMasLeaveStatus();

			leaveStatus.setId(4);
			leaveDetails.setLeaveStatus(leaveStatus);

			leaveDetails.setDisapproveReason(disapproveMessage);
			Date currentDate = new Date();
			leaveDetails.setApprovedOn(currentDate);
			hbt.update(leaveDetails);
			hbt.refresh(leaveDetails);

			saveLeaveHistory(leaveDetails);

///////////////////////////////////
			//leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, Integer.parseInt(approve[i]));

			String leaveAppliedBy = leaveDetails.getEmpId().getFirstName() + " " + leaveDetails.getEmpId().getLastName();
			String leaveType = leaveDetails.getLeaveType().getLeaveType().getLeaveType().getDescription();

			String subject = "Leave Application/" + leaveType
			   + "/" + leaveAppliedBy
			   + "/" + LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getApprovedOn())
			   + "/" + leaveDetails.getLeaveStatus().getStatusDesc();

			//Subject: Leave Application/Leave type/Emp. Name/Action Date/ Leave Application Status

			//Dear (Title)(First and Last Name)

			//Your Leave application dated:(Date) for (Leave Type) has been (Status).
			//Kindly see the updated leave status by logging into your OMEGA account or by clicking on the link mentioned below.
			//http://www.omega.clinirx.com

///////////////////////////////////////////////////////////////////
			emailMessage = "Dear " + leaveDetails.getEmpId().getTitle().getTitleName()
			                + " " + leaveAppliedBy
			                + ",\n\n";

			emailMessage = emailMessage + "Your Leave application dated:"
				+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn());

			if(leaveDetails.getHalfDay() != null && !leaveDetails.getHalfDay().equals("")) {
				if(leaveDetails.getHalfDay().equalsIgnoreCase("f")){
					firstOrSecondHalf = "first half";
				}else if(leaveDetails.getHalfDay().equalsIgnoreCase("s")){
					firstOrSecondHalf = "second half";
				}
				fromToDate=" for a half day " + leaveType + " for " + firstOrSecondHalf;
			} else if (leaveDetails.getShortLeaveHalfDay() != null){
				if(leaveDetails.getShortLeaveHalfDay().equalsIgnoreCase("f")){
					firstOrSecondHalf = "first half";
				}else if(leaveDetails.getShortLeaveHalfDay().equalsIgnoreCase("s")){
					firstOrSecondHalf = "second half";
				}
				fromToDate=" for a " + leaveType + " for " + firstOrSecondHalf;
			} else {
				fromToDate=" for " + leaveType;
			}
			emailMessage = emailMessage + fromToDate +
			" has been " + leaveDetails.getLeaveStatus().getStatusDesc()
				+ ".\n"
				+ "Kindly see the updated leave status by logging into your KSSC account " +
	                  		"or by clicking on the link mentioned below.\n" +
	                  		
	                  		"This is an auto generated mail through KSSC. Do not reply.";

			List<String> recipientAddresses = new ArrayList<String>();
			String senderAddresses = new String();
			List<String> ccAddresses = new ArrayList<String>();
			List<String> bccAddresses = new ArrayList<String>();

			if(leaveDetails.getLeaveApprovedBy().getEmail() != null  && !leaveDetails.getLeaveApprovedBy().getEmail().equals("")
					&& leaveDetails.getEmpId().getEmail() != null && !leaveDetails.getEmpId().getEmail().equals("")){
				recipientAddresses.add(leaveDetails.getEmpId().getEmail());
				senderAddresses = new String(leaveDetails.getLeaveApprovedBy().getEmail());

				ccAddresses.add(leaveDetails.getLeaveApprovedBy().getEmail());
				////ccAddresses.add("hrhelpdesk@clinirx.com");

				LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
						ccAddresses , bccAddresses ,emailMessage, subject);
			}
		}
	}

	public void disapproveLeavesEncashment(String[] disapprove,MasEmployee user,String disapproveMessage) {
		String fromToDate="";
		String emailMessage = "";

		for (int i = 0; i < disapprove.length; i++) {
			HrEncashmentDetails leaveDetails = (HrEncashmentDetails)getHibernateTemplate().load(HrEncashmentDetails.class, Integer.parseInt(disapprove[i]));

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			//changes
			HrMasLeaveStatus leaveStatus =new HrMasLeaveStatus();
			leaveStatus.setId(4);
			leaveDetails.setLeaveStatus(leaveStatus);

			leaveDetails.setRemarks(disapproveMessage);
			Date currentDate = new Date();
			leaveDetails.setApprovedOn(currentDate);
			hbt.update(leaveDetails);
			hbt.refresh(leaveDetails);
			saveLeaveEncashmentHistory(leaveDetails);
///////////////////////////////////
			//leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, Integer.parseInt(approve[i]));

			String leaveAppliedBy = leaveDetails.getEmp().getFirstName() + " " + leaveDetails.getEmp().getLastName();
			String leaveType = leaveDetails.getLeaveType().getLeaveType().getLeaveType().getDescription();

			String subject = "Leave Encashemnt Request/" + leaveType
			   + "/" + leaveAppliedBy
			   + "/" + LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getApprovedOn())
			   + "/" + leaveDetails.getLeaveStatus().getStatusDesc();

			//Subject: Leave Application/Leave type/Emp. Name/Action Date/ Leave Application Status

			//Dear (Title)(First and Last Name)

			//Your Leave application dated:(Date) for (Leave Type) has been (Status).
			//Kindly see the updated leave status by logging into your OMEGA account or by clicking on the link mentioned below.
			//http://www.omega.clinirx.com

///////////////////////////////////////////////////////////////////
			emailMessage = "Dear " + leaveDetails.getEmp().getTitle().getTitleName()
			                + " " + leaveAppliedBy
			                + ",\n\n";

			emailMessage = emailMessage + "Your request for leave encashment dated:"
				+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn())
				+ " for " + leaveType + " for " + leaveDetails.getLeaveToEncash();

			if(leaveDetails.getLeaveToEncash().equals("1")){
				emailMessage = emailMessage + " day";
			}else{
				emailMessage = emailMessage + " days";
			}
			emailMessage = emailMessage + fromToDate +
			" has been " + leaveDetails.getLeaveStatus().getStatusDesc()
				+ ".\n"
				+ "Kindly see the updated leave status by logging into your KSSC account " +
	                  		"or by clicking on the link mentioned below.\n" +
	                  		
	                  		"This is an auto generated mail through KSSC. Do not reply.";

			List<String> recipientAddresses = new ArrayList<String>();
			String senderAddresses = new String();
			List<String> ccAddresses = new ArrayList<String>();
			List<String> bccAddresses = new ArrayList<String>();

			if(leaveDetails.getApprovedBy().getEmail() != null  && !leaveDetails.getApprovedBy().getEmail().equals("")
					&& leaveDetails.getEmp().getEmail() != null && !leaveDetails.getEmp().getEmail().equals("")){
				recipientAddresses.add(leaveDetails.getEmp().getEmail());
				senderAddresses = new String(leaveDetails.getApprovedBy().getEmail());

				ccAddresses.add(leaveDetails.getApprovedBy().getEmail());
				//ccAddresses.add("hrhelpdesk@clinirx.com");

				LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
						ccAddresses , bccAddresses ,emailMessage, subject);
			}
		}
	}
	public Map deleteLeaves(String[] delete, MasEmployee user, String deleteMessage) {
		String fromToDate="";
		String emailMessage = "";
		Map detailsMap = new HashMap();
		//String firstOrSecondHalf = "";
		String msg="";
		if(delete!=null) {
			for (int i = 0; i < delete.length; i++) {
				HrLeaveDetails leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, Integer.parseInt(delete[i]));
				HrMasLeaveStatus leaveStatus =new HrMasLeaveStatus();
				if(leaveDetails!=null) {
					if(leaveDetails.getLeaveStatus().getId()==2) {
						leaveStatus.setId(6);
					}else{
						leaveStatus.setId(5);
					}
				}
				//changes

				leaveDetails.setLeaveStatus(leaveStatus);

				leaveDetails.setDeleteReason(deleteMessage);
				Date currentDate = new Date();
				leaveDetails.setApprovedOn(currentDate);

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				hbt.update(leaveDetails);
				hbt.refresh(leaveDetails);

				saveLeaveHistory(leaveDetails);
	//			leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, Integer.parseInt(delete[i]));
	////////////////////
				String leaveAppliedBy = leaveDetails.getEmpId().getFirstName() + " " + leaveDetails.getEmpId().getLastName();
				String toBeApprovedBy = leaveDetails.getLeaveApprovedBy().getFirstName() + " " + leaveDetails.getLeaveApprovedBy().getLastName();
				String leaveType = leaveDetails.getLeaveType().getLeaveType().getLeaveType().getDescription();
				String subject = "Leave cancellation/" + leaveType
				   + "/" + leaveAppliedBy
				   + "/" + leaveDetails.getAppliedOn();
				//Subject: Leave Application/Leave type/Emp. Name/Application Date

				//Dear (Title)(first and last name),

				//Emp. Name has applied for (leave type name) from date to date and will be joining back on date.
				//Kindly take up the necessary action by entering into your OMEGA account or by clicking on the link mentioned below.
	///////////////////////////////////////////////////////////////////
				String cancellation = "";
				String endMessage = "";
				emailMessage = "Dear " + leaveDetails.getLeaveApprovedBy().getTitle().getTitleName()
                + " " + toBeApprovedBy
                + ",\n\n";

				if(leaveStatus.getId() == 6){
					msg ="Request For Approve Leave canellation  has been sucssesfully submitted. ";
					cancellation = "cancelling ";
					emailMessage = emailMessage + leaveAppliedBy
				       + " has applied for ";
					endMessage = "Kindly take up the necessary action by entering into " +
						/*"your OMEGA account or by clicking on the link mentioned below.\n" +
                  		*/
                  		"This is an auto generated mail through KSSC. Do not reply.";
				} else if(leaveStatus.getId() == 5){
					msg ="Leave has been cancelled ";
					emailMessage = emailMessage + leaveAppliedBy
				       + " has cancelled ";
				}

				fromToDate = cancellation + leaveType
					+ " for the period "
					+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getFromDate())
					+ " to "
					+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getToDate());

					if(leaveDetails.getDeleteReason() != null){
						fromToDate = fromToDate + " due to " + leaveDetails.getDeleteReason();
					}


/*				if(leaveDetails.getHalfDay() != null && !leaveDetails.getHalfDay().equals("")) {
					if(leaveDetails.getHalfDay().equalsIgnoreCase("f")){
						firstOrSecondHalf = "first half";
					}else if(leaveDetails.getHalfDay().equalsIgnoreCase("s")){
						firstOrSecondHalf = "second half";
					}
					fromToDate = cancellation + " a half day " + leaveType
						+ " for " + firstOrSecondHalf + " applied on "
						+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn());
				} else if (leaveDetails.getShortLeaveHalfDay() != null){
					if(leaveDetails.getShortLeaveHalfDay().equalsIgnoreCase("f")){
						firstOrSecondHalf = "first half";
					}else if(leaveDetails.getShortLeaveHalfDay().equalsIgnoreCase("s")){
						firstOrSecondHalf = "second half";
					}
					fromToDate = cancellation + " a " + leaveType + " for " + firstOrSecondHalf + " applied on "
						+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn());
				} else {
					fromToDate= cancellation  + " " + leaveType
						+ " applied on "
						+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn());
				}*/


				emailMessage = emailMessage + fromToDate + ".\n" + endMessage;

				List<String> recipientAddresses = new ArrayList<String>();
				String senderAddresses = new String();
				List<String> ccAddresses = new ArrayList<String>();
				List<String> bccAddresses = new ArrayList<String>();

				if(leaveDetails.getLeaveApprovedBy().getEmail() != null  && !leaveDetails.getLeaveApprovedBy().getEmail().equals("")
						&& leaveDetails.getEmpId().getEmail() != null && !leaveDetails.getEmpId().getEmail().equals("")){
					recipientAddresses.add(leaveDetails.getLeaveApprovedBy().getEmail());
					senderAddresses = new String(leaveDetails.getEmpId().getEmail());

					ccAddresses.add(leaveDetails.getEmpId().getEmail());
					//ccAddresses.add("hrhelpdesk@clinirx.com");

					LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
							ccAddresses , bccAddresses ,emailMessage, subject);
				}
	/////////////////////////////////////
			}
		}
		detailsMap.put("msg", msg);
		return detailsMap;
	}

	public void deleteLeavesEncashment(String[] delete, MasEmployee user, String deleteMessage) {
		String fromToDate="";
		String endMessage = "";
		String emailMessage = "";
		if(delete!=null) {
			for (int i = 0; i < delete.length; i++) {
				HrEncashmentDetails leaveDetails = (HrEncashmentDetails)getHibernateTemplate().load(HrEncashmentDetails.class, Integer.parseInt(delete[i]));

				//changes
				HrMasLeaveStatus leaveStatus =new HrMasLeaveStatus();
				leaveStatus.setId(5);
				leaveDetails.setLeaveStatus(leaveStatus);

				leaveDetails.setDeleteReason(deleteMessage);
				Date currentDate = new Date();
				leaveDetails.setApprovedOn(currentDate);

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				hbt.update(leaveDetails);
				hbt.refresh(leaveDetails);

				saveLeaveEncashmentHistory(leaveDetails);
				////////////////////
				String leaveAppliedBy = leaveDetails.getEmp().getFirstName() + " " + leaveDetails.getEmp().getLastName();
				String toBeApprovedBy = leaveDetails.getApprovedBy().getFirstName() + " " + leaveDetails.getApprovedBy().getLastName();
				String leaveType = leaveDetails.getLeaveType().getLeaveType().getLeaveType().getDescription();
				String subject = "Leave Cancellation/" + leaveType
				   + "/" + leaveAppliedBy
				   + "/" + leaveDetails.getAppliedOn();
				//Subject: Leave Application/Leave type/Emp. Name/Application Date

				//Dear (Title)(first and last name),

				//Emp. Name has applied for (leave type name) from date to date and will be joining back on date.
				//Kindly take up the necessary action by entering into your OMEGA account or by clicking on the link mentioned below.
	///////////////////////////////////////////////////////////////////
				String cancellation = "";
				emailMessage = "Dear " + leaveDetails.getApprovedBy().getTitle().getTitleName()
	            + " " + toBeApprovedBy
	            + ",\n\n";

				if(leaveStatus.getId() == 6){
					cancellation = "cancelling ";
					emailMessage = emailMessage + leaveAppliedBy
				       + " has applied for ";
					endMessage = "Kindly take up the necessary action by entering into " +
						"your KSSC account or by clicking on the link mentioned below.\n" +
                  		
                  		"This is an auto generated mail through KSSC. Do not reply.";

				} else if(leaveStatus.getId() == 5){
					emailMessage = emailMessage + leaveAppliedBy
				       + " has cancelled ";
				}

				fromToDate= cancellation  + " leave encashment of " + leaveType;

				emailMessage = emailMessage + fromToDate + ".\n" + endMessage;

				List<String> recipientAddresses = new ArrayList<String>();
				String senderAddresses = new String();
				List<String> ccAddresses = new ArrayList<String>();
				List<String> bccAddresses = new ArrayList<String>();

				if(leaveDetails.getApprovedBy().getEmail() != null  && !leaveDetails.getApprovedBy().getEmail().equals("")
						&& leaveDetails.getEmp().getEmail() != null && !leaveDetails.getEmp().getEmail().equals("")){
					recipientAddresses.add(leaveDetails.getApprovedBy().getEmail());
					senderAddresses = new String(leaveDetails.getEmp().getEmail());

					ccAddresses.add(leaveDetails.getEmp().getEmail());
					//ccAddresses.add("hrhelpdesk@clinirx.com");

					LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
							ccAddresses , bccAddresses ,emailMessage, subject);
				}
	/////////////////////////////////////

			}
		}
	}

	public List getempNamesList(int userId) {
		List empList=getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee as users where users.Id IN(select mgr.EmpId from jkt.hms.masters.business.UserManager as mgr where mgr.ManagerId="+userId+") order by users.FirstName");
		return empList;
	}

	public void sendSuggestion(String[] suggestion,MasEmployee user,String suggestionMessage) {
		String fromToDate="";
		String emailMessage = "";
		String firstOrSecondHalf = "";

		for (int i = 0; i < suggestion.length; i++) {

			//System.out.println("leave id :"+suggestion[i]);
			HrLeaveDetails leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class,Integer.parseInt(suggestion[i]));
			//change
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			HrMasLeaveStatus leaveStatus =new HrMasLeaveStatus();
			leaveStatus.setId(1);
			leaveDetails.setLeaveStatus(leaveStatus);

			System.out.println("suggestion massage  :"+suggestionMessage);
			leaveDetails.setSuggestion(suggestionMessage);

			Date currentDate = new Date();
			leaveDetails.setApprovedOn(currentDate);

			hbt.update(leaveDetails);
			hbt.refresh(leaveDetails);

			saveLeaveHistory(leaveDetails);
///////////////////////////////////
			//leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, Integer.parseInt(approve[i]));

			String leaveAppliedBy = leaveDetails.getEmpId().getFirstName() + " " + leaveDetails.getEmpId().getLastName();
			String leaveType = leaveDetails.getLeaveType().getLeaveType().getLeaveType().getDescription();

			String subject = "Leave Application/" + leaveType
			   + "/" + leaveAppliedBy
			   + "/" + LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getApprovedOn())
			   + "/" + leaveDetails.getLeaveStatus().getStatusDesc();

			//Subject: Leave Application/Leave type/Emp. Name/Action Date/ Leave Application Status

			//Dear (Title)(First and Last Name)

			//Your Leave application dated:(Date) for (Leave Type) has been (Status).
			//Kindly see the updated leave status by logging into your OMEGA account or by clicking on the link mentioned below.
			//http://www.omega.clinirx.com

///////////////////////////////////////////////////////////////////
			emailMessage = "Dear " + leaveDetails.getEmpId().getTitle().getTitleName()
			                + " " + leaveAppliedBy
			                + ",\n\n";

			emailMessage = emailMessage + "Your Leave application dated:"
				+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn());

			if(leaveDetails.getHalfDay() != null && !leaveDetails.getHalfDay().equals("")) {
				if(leaveDetails.getHalfDay().equalsIgnoreCase("f")){
					firstOrSecondHalf = "first half";
				}else if(leaveDetails.getHalfDay().equalsIgnoreCase("s")){
					firstOrSecondHalf = "second half";
				}
				fromToDate=" for a half day " + leaveType + " for " + firstOrSecondHalf;
			} else if (leaveDetails.getShortLeaveHalfDay() != null){
				if(leaveDetails.getShortLeaveHalfDay().equalsIgnoreCase("f")){
					firstOrSecondHalf = "first half";
				}else if(leaveDetails.getShortLeaveHalfDay().equalsIgnoreCase("s")){
					firstOrSecondHalf = "second half";
				}
				fromToDate=" for a " + leaveType + " for " + firstOrSecondHalf;
			} else {
				fromToDate=" for " + leaveType;
			}

			emailMessage = emailMessage + fromToDate +
			" has been put " + leaveDetails.getLeaveStatus().getStatusDesc()
				+ ".\n"
				+ "Kindly see the updated leave status by logging into your KSSC account " +
                  		"or by clicking on the link mentioned below.\n" +
                  		
                  		"This is an auto generated mail through KSSC. Do not reply.";

			List<String> recipientAddresses = new ArrayList<String>();
			String senderAddresses = new String();
			List<String> ccAddresses = new ArrayList<String>();
			List<String> bccAddresses = new ArrayList<String>();

			if(leaveDetails.getLeaveApprovedBy().getEmail() != null  && !leaveDetails.getLeaveApprovedBy().getEmail().equals("")
					&& leaveDetails.getEmpId().getEmail() != null && !leaveDetails.getEmpId().getEmail().equals("")){
				recipientAddresses.add(leaveDetails.getEmpId().getEmail());
				senderAddresses = new String(leaveDetails.getLeaveApprovedBy().getEmail());

				ccAddresses.add(leaveDetails.getLeaveApprovedBy().getEmail());
				 //ccAddresses.add("hrhelpdesk@clinirx.com");

				LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
						ccAddresses , bccAddresses ,emailMessage, subject);
			}
		}
	}

	public void onHoldEncashment(String[] suggestion,MasEmployee user,String suggestionMessage) {
		String emailMessage="";
		for (int i = 0; i < suggestion.length; i++) {

			HrEncashmentDetails leaveDetails = (HrEncashmentDetails)getHibernateTemplate().load(HrEncashmentDetails.class,Integer.parseInt(suggestion[i]));
			//change
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			HrMasLeaveStatus leaveStatus =new HrMasLeaveStatus();
			leaveStatus.setId(1);
			leaveDetails.setLeaveStatus(leaveStatus);

			leaveDetails.setRemarks(suggestionMessage);

			Date currentDate = new Date();
			leaveDetails.setApprovedOn(currentDate);

			hbt.update(leaveDetails);
			hbt.refresh(leaveDetails);

			saveLeaveEncashmentHistory(leaveDetails);

///////////////////////////////////
			//leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, Integer.parseInt(approve[i]));

			String leaveAppliedBy = leaveDetails.getEmp().getFirstName() + " " + leaveDetails.getEmp().getLastName();
			String leaveType = leaveDetails.getLeaveType().getLeaveType().getLeaveType().getDescription();

			String subject = "Leave Encashment Request/" + leaveType
			   + "/" + leaveAppliedBy
			   + "/" + LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getApprovedOn())
			   + "/" + leaveDetails.getLeaveStatus().getStatusDesc();

			//Subject: Leave Application/Leave type/Emp. Name/Action Date/ Leave Application Status

			//Dear (Title)(First and Last Name)

			//Your Leave application dated:(Date) for (Leave Type) has been (Status).
			//Kindly see the updated leave status by logging into your OMEGA account or by clicking on the link mentioned below.
			//http://www.omega.clinirx.com

///////////////////////////////////////////////////////////////////
			emailMessage = "Dear " + leaveDetails.getEmp().getTitle().getTitleName()
			                + " " + leaveAppliedBy
			                + ",\n\n";

			emailMessage = emailMessage + "Your request for leave encashment dated:"
				+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn())
				+ " for " + leaveType + " for " + leaveDetails.getLeaveToEncash();
			if(leaveDetails.getLeaveToEncash().equals("1")){
				emailMessage = emailMessage + " day";
			}else{
				emailMessage = emailMessage + " days";
			}

			emailMessage = emailMessage +
			" has been put " + leaveDetails.getLeaveStatus().getStatusDesc()
				+ ".\n"
				+ "Kindly see the updated leave status by logging into your KSSC account " +
                  		"or by clicking on the link mentioned below.\n" +
                  		
                  		"This is an auto generated mail through KSSC. Do not reply.";

			List<String> recipientAddresses = new ArrayList<String>();
			String senderAddresses = new String();
			List<String> ccAddresses = new ArrayList<String>();
			List<String> bccAddresses = new ArrayList<String>();

			if(leaveDetails.getApprovedBy().getEmail() != null  && !leaveDetails.getApprovedBy().getEmail().equals("")
					&& leaveDetails.getEmp().getEmail() != null && !leaveDetails.getEmp().getEmail().equals("")){
				recipientAddresses.add(leaveDetails.getEmp().getEmail());
				senderAddresses = new String(leaveDetails.getApprovedBy().getEmail());

				ccAddresses.add(leaveDetails.getApprovedBy().getEmail());
				//ccAddresses.add("hrhelpdesk@clinirx.com");

				LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
						ccAddresses , bccAddresses ,emailMessage, subject);
			}
		}
	}

	public List commonEmpMgr(int userId){
		//List<MasEmployee> empList=(List<MasEmployee>)getHibernateTemplate().find("from com.jkt.intranet.business.UserManager as mgr where mgr.EmpId="+userId);

		//changes
		List<UserManager> empList=(List<UserManager>)getHibernateTemplate().find("from jkt.hms.masters.business.UserManager as user where user.ManagerId ="+userId);
		return empList;
	}

	public void saveLeaveHistory(HrLeaveDetails leave){
		HrLeaveDetailsHistory leaveHist=new HrLeaveDetailsHistory();
		leaveHist.setAppliedOn(leave.getAppliedOn());
		leaveHist.setApprovedBy(leave.getLeaveApprovedBy().getId());
		leaveHist.setContactAddress(leave.getContactAddress());
		leaveHist.setContactPhone(leave.getContactPhone());
		leaveHist.setEmpid(leave.getEmpId().getId());
		leaveHist.setFromDate(leave.getFromDate());
		leaveHist.setJoiningDate(leave.getJoiningDate());
		leaveHist.setModifiedBy(leave.getModifiedBy());
		leaveHist.setModifiedOn(leave.getModifiedOn());
		leaveHist.setNoOfWorkingDays(leave.getNoOfWorkingDays());
		leaveHist.setReason(leave.getReason());
		leaveHist.setEmpIdBal(leave.getEmpIdBal());

		if(leave.getDeleteReason()!=null) {
			leaveHist.setDeleteReason(leave.getDeleteReason());
		}

		leaveHist.setStatus(leave.getLeaveStatus().getId());
		leaveHist.setToDate(leave.getToDate());
		if(leave.getLeaveType()!= null){
			leaveHist.setType(leave.getLeaveType().getId());
		}
		if(leave.getSuggestion()!=null)
			leaveHist.setSuggestion(leave.getSuggestion());

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(leaveHist);
		//hbt.refresh(leaveHist);
	}

	public void saveLeaveEncashmentHistory(HrEncashmentDetails leave){
		HrEncashmentDetailsHistory leaveHist=new HrEncashmentDetailsHistory();
		leaveHist.setAppliedOn(leave.getAppliedOn());
		leaveHist.setApprovedBy(leave.getApprovedBy());
		//leaveHist.setContactAddress(leave.getContactAddress());
		//leaveHist.setContactPhone(leave.getContactPhone());
		leaveHist.setEmp(leave.getEmp());
		//leaveHist.setFromDate(leave.getFromDate());
		//leaveHist.setJoiningDate(leave.getJoiningDate());
		//leaveHist.setModifiedBy(leave.getModifiedBy());
		//leaveHist.setModifiedOn(leave.getModifiedOn());
		leaveHist.setLeaveToEncash(leave.getLeaveToEncash());
		if(leave.getDeleteReason()!=null) {
			leaveHist.setDeleteReason(leave.getDeleteReason());
		}
		leaveHist.setReason(leave.getReason());
		leaveHist.setLeaveStatus(leave.getLeaveStatus());
		//leaveHist.setToDate(leave.getToDate());
		leaveHist.setBalance(leave.getEmpIdBal());
		leaveHist.setCompany(leave.getCompany());
		leaveHist.setStatus(leave.getStatus());
		leaveHist.setLastChgBy(leave.getLastChgBy());
		leaveHist.setLastChgDate(leave.getLastChgDate());
		leaveHist.setLastChgTime(leave.getLastChgTime());

		leaveHist.setLeaveType(leave.getLeaveType());
		if(leave.getRemarks()!=null)
			leaveHist.setRemarks(leave.getRemarks());

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(leaveHist);
		hbt.refresh(leaveHist);
	}

	public Map getEmpLeaveDetails(int empId) {
		Map map = new HashMap();
		List leaveBalanceList = new ArrayList();
		List leaveDetailsList = new ArrayList();
		List userList = new ArrayList();

		userList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee us where us.Id = "+empId);
		leaveBalanceList = getHibernateTemplate().find("from jkt.hms.masters.business.HrEmployeeBalanceNew ul where ul.Emp.Id="+empId);
		leaveDetailsList = getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails ld where ld.EmpId.Id="+empId);

		map.put("leaveBalanceList", leaveBalanceList);
		map.put("leaveDetailsList", leaveDetailsList);
		map.put("userList", userList);
		return map;
	}

	public void updateLeaveBalance(HrUpdateLeaveBalanceHistory leaveHistory, String newLeaveBalanceYearly, String newOnsiteUkBalance, int empId,String balanceAdjustedBy) {
		String emailMessage = "";

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<HrEmployeeBalanceNew> leaveBalanceList = new ArrayList<HrEmployeeBalanceNew>();
		int leaveTypeId = leaveHistory.getLeaveType().getId();

		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(HrEmployeeBalanceNew.class);
			crit = crit.createAlias("LeaveType", "lt");
			crit = crit.add(Restrictions.eq("lt.Id", leaveTypeId));
			crit = crit.add(Restrictions.eq("Emp.Id", empId));
			Order order=Order.asc("Id");
			crit = crit.addOrder(order);//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));
		leaveBalanceList = crit.list();

		HrEmployeeBalanceNew userLeaveBalance = (HrEmployeeBalanceNew)leaveBalanceList.get(0);

		leaveHistory.setPreviousLeaveBalance(userLeaveBalance.getClosingBalance());
		leaveHistory.setPreviousLeaveBalanceYearly(userLeaveBalance.getClosingBalanceYearly());
/*		double newClosingBalanceYearly = Double.valueOf(userLeaveBalance.getClosingBalanceYearly()) + Double.valueOf(leaveHistory.getBalanceAdjustBy());
		leaveHistory.setNewLeaveBalanceYearly(new DecimalFormat("0.##").format(newClosingBalanceYearly));
		hbt.save(leaveHistory);
*/
		double newClosingBalance = Double.valueOf(userLeaveBalance.getClosingBalance()) + Double.valueOf(leaveHistory.getBalanceAdjustBy());
		leaveHistory.setNewLeaveBalance(new DecimalFormat("0.##").format(newClosingBalance));
		hbt.save(leaveHistory);
		hbt.refresh(leaveHistory);

		double balanceAdjusted = Float.valueOf(userLeaveBalance.getBalanceAdjusted())
																		+ Float.valueOf(balanceAdjustedBy);
		String balanceAdjustmentToSave = new DecimalFormat("0.##").format((double)balanceAdjusted);
		userLeaveBalance.setBalanceAdjusted(balanceAdjustmentToSave);
		userLeaveBalance.setClosingBalance(new DecimalFormat("0.##").format(newClosingBalance));
		userLeaveBalance.setClosingBalanceYearly(newLeaveBalanceYearly);
		hbt.update(userLeaveBalance);

///////////////////////////////////
		String leaveAdjustedFor = userLeaveBalance.getEmp().getFirstName() + " " + userLeaveBalance.getEmp().getLastName();
		String leaveAdjustedBy = leaveHistory.getLastChgBy().getEmployee().getFirstName() + " " + leaveHistory.getLastChgBy().getEmployee().getLastName();
		String leaveType = leaveHistory.getLeaveType().getLeaveType().getLeaveType().getDescription();

		String subject = "Leave Balance Adjusted/" + leaveType
		   + "/" + leaveAdjustedFor + ":" + userLeaveBalance.getEmp().getEmployeeCode();

		emailMessage = "Dear " + userLeaveBalance.getEmp().getTitle().getTitleName()
		                + " " + leaveAdjustedFor
		                + ",\n\n";

		emailMessage = emailMessage + "Your leave balance for " + leaveType + " has been updated on "
			+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveHistory.getLastChgDate())
			+ " by " + leaveHistory.getLastChgBy().getEmployee().getTitle().getTitleName()
			+ " " + leaveAdjustedBy
			+ ".\n\n"
			+ "Previous Leave Balance :" + leaveHistory.getPreviousLeaveBalanceYearly() + "\n"
			+ "Current Leave Balance  :" + leaveHistory.getNewLeaveBalanceYearly() + "\n\n";

		emailMessage = emailMessage + "Kindly see the updated leave status by logging into your KSSC account " +
                  		"or by clicking on the link mentioned below.\n" +
                  		
                  		"This is an auto generated mail through KSSC. Do not reply.";

		List<String> recipientAddresses = new ArrayList<String>();
		String senderAddresses = new String();
		List<String> ccAddresses = new ArrayList<String>();
		List<String> bccAddresses = new ArrayList<String>();

		if(userLeaveBalance.getEmp().getEmail() != null  && !userLeaveBalance.getEmp().getEmail().equals("")
				&& leaveHistory.getLastChgBy().getEmployee().getEmail() != null && !leaveHistory.getLastChgBy().getEmployee().getEmail().equals("")){
			recipientAddresses.add(userLeaveBalance.getEmp().getEmail());

			senderAddresses = new String(leaveHistory.getLastChgBy().getEmployee().getEmail());
			ccAddresses.add(leaveHistory.getLastChgBy().getEmployee().getEmail());
			//ccAddresses.add("hrhelpdesk@clinirx.com");

			LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
					ccAddresses , bccAddresses ,emailMessage, subject);
		}

	}

	public Map getEmailId(int hrId, int empId)
	{
		Map map = new HashMap();

		List hrManagerList = getHibernateTemplate().find("from jkt.hms.masters.business.UserManager um where um.EmpId="+hrId);
		//changes
		UserManager hrManager = (UserManager)hrManagerList.get(0);
		String hrManagerEmailId = hrManager.getManagers().getEmail();

		MasEmployee empUser = (MasEmployee)getHibernateTemplate().load(MasEmployee.class, empId);
		String empEmailId = empUser.getEmail();

		List userManagerList = getHibernateTemplate().find("from jkt.hms.masters.business.UserManager um where um.EmpId="+empId);
		String userManagerEmailId =  "";
		if(userManagerList.size()!=0)
		{
			//changes
			UserManager userManager = (UserManager)userManagerList.get(0);
			userManagerEmailId = userManager.getUsers().getEmail();
		}
			//changes
		map.put("hrManagerEmailId", hrManagerEmailId);

		//map.put("hrManagerEmailId", "bn.sjdh@jks.co");
		map.put("empEmailId", empEmailId);
		map.put("userManagerEmailId", userManagerEmailId);

		return map;

	}

	public List viewLeaveHistory(int empId) {
		List leaveHistoryList = new ArrayList();
		leaveHistoryList = getHibernateTemplate().find("from jkt.hms.masters.business.HrUpdateLeaveBalanceHistory balanceHistory where balanceHistory.EmpId = "+empId);
		return leaveHistoryList;
	}

	public List getAvailedRhList(MasEmployee user) {
		int empId=user.getId();
		Calendar currentDate=new GregorianCalendar();
		int currentYear=currentDate.get(Calendar.YEAR);
		List availedRh=null;
		availedRh=getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails leave where leave.leaveType.Id=7 and leave.leaveStatus.Id IN(2,3) and leave.EmpId.Id="+empId+" and year(leave.FromDate)="+currentYear);
		return availedRh;
	}

	public List getBirthdayLeave(int empId) {
		Calendar currentDate=new GregorianCalendar();
		int currentYear=currentDate.get(Calendar.YEAR);
		List birthdayLeave = getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails leave where leave.leaveType.Id = 5 and leave.leaveStatus.Id IN(2,3) and leave.EmpId.Id = "+empId+" and year(leave.FromDate)="+currentYear);
		return birthdayLeave;
	}

	public List getAnniversaryLeave(int empId) {
		Calendar currentDate=new GregorianCalendar();
		int currentYear=currentDate.get(Calendar.YEAR);
		List anniversaryLeave = getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails leave where leave.leaveType.Id = 6 and leave.leaveStatus.Id IN(2,3) and leave.EmpId.Id = "+empId+" and year(leave.FromDate)="+currentYear);
		return anniversaryLeave;
	}

	public List getPaternityLeave(int empId) {
		Calendar currentDate=new GregorianCalendar();
		int currentYear=currentDate.get(Calendar.YEAR);
		List paternityLeave = getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails leave where leave.leaveType.Id = 4 and  leave.leaveStatus.Id IN(2,3) and leave.EmpId.Id = "+empId+" and year(leave.FromDate)="+currentYear);
		return paternityLeave;
	}

	public List getWaitingEncashmentLeave(MasEmployee user) {
		List encashmentLeaveWaiting=getHibernateTemplate().find("from jkt.hms.masters.business.HrEncashmentDetails as leave where leave.LeaveStatus.Id=3 and leave.ApprovedBy.Id = "+user.getId()+" order by leave.Id");
		return encashmentLeaveWaiting;
	}

	public void sendingSMS(HrLeaveDetails leaveDetails,int empId){
//		EmployeeDetails mobilePhoneDetails = (EmployeeDetails)getHibernateTemplate().load(EmployeeDetails.class,empId);
//		if(mobilePhoneDetails!=null)
//		if(mobilePhoneDetails.getMobileNumber()!=null);
		//(new SmsReceiver()).startReceiving(leaveDetails);
	}

	public MasEmployee getMemberDetails(int memberId) {
		MasEmployee memberDetail=(MasEmployee)getHibernateTemplate().load(MasEmployee.class,memberId);
		return memberDetail;
	}

	public List getAllWaitingLeavesForHR(int empId) {
		List<Object> allWaitingLeaves=new ArrayList<Object>();
		//allWaitingLeaves=getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id=3 and leave.EmpId in (select Id from MasEmployee where LineManager="+empId+") order by leave.Id");
		allWaitingLeaves=getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id=3 order by leave.Id");
		return allWaitingLeaves;
	}

	public List getIdsToSendMail() {
		List listOfManagers = new ArrayList();
		List waitingLeavesFromWeek = getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id=3");
		for (Iterator iter = waitingLeavesFromWeek.iterator(); iter.hasNext();) {
			HrLeaveDetails leave = (HrLeaveDetails) iter.next();
			Date appliedDate = leave.getAppliedOn();
			Date currentDate = new Date();
			long days = LeaveManagementUtil.daysDifferenceBetweenTwoDates(appliedDate,currentDate);
			//System.out.println("day after one week>>>"+days);
			if(days>=7)
			{
				//System.out.println("5 days old so send its id>>>");
				//System.out.println("so mgr to set is>>>"+leave.getLeaveApprovedBy().getFullName());
				listOfManagers.add(leave.getLeaveApprovedBy());
				//System.out.println("ist item in manager list>>>"+listOfManagers.get(0));
			}
		}
		return listOfManagers;
	}

	public List getLeaveStatusList() {
		List<Object> leaveStatusList=new ArrayList<Object>();
		leaveStatusList=getHibernateTemplate().find("from jkt.hms.masters.business.HrMasLeaveStatus");
		return leaveStatusList;
	}

	public List<HrLeaveDetails> getLeavesList(Integer userId, String fromDate, String toDate, String leaveType, String leaveStatus) {

		/*StringBuffer query = new StringBuffer("from HrLeaveDetails as leaveDetails order by leaveDetails.Id desc where leaveDetails.EmpId.Id = '"+userId+"'");
		if(fromDate !=null && !fromDate.trim().equals("") && toDate != null && !toDate.trim().equals("")){
			query.append(" and leaveDetails.FromDate >= '" + fromDate+ "' and leaveDetails.FromDate <= '" + toDate + "'" );
		}
		if(leaveType != null && !leaveType.trim().equals("")){
			query.append("and leaveDetails.leaveType.Id = '"+ leaveType +"'");
		}
		if(leaveStatus !=null && !leaveStatus.trim().equals("")){
			query.append("and leaveDetails.leaveStatus.Id = '"+ leaveStatus +"'");
		}
		System.out.println("This is Query  :"+query.toString());*/
		List<HrLeaveDetails> leaveDetailList =null; //= getHibernateTemplate().find(query.toString());

		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(HrLeaveDetails.class);

		if(fromDate !=null && !fromDate.trim().equals("")){

			Date fromDateForQuery = HMSUtil.convertStringTypeDateToDateType(fromDate);
			crit = crit.add(Restrictions.ge("FromDate", fromDateForQuery));
		}
		if( toDate != null && !toDate.trim().equals("")) {

			Date toDateForQuery = HMSUtil.convertStringTypeDateToDateType(toDate);
			crit = crit.add(Restrictions.le("FromDate", toDateForQuery));
		}
		if(leaveType != null && !leaveType.trim().equals("")){
			crit = crit.add(Restrictions.eq("leaveType.Id", Integer.parseInt(leaveType)));

		}
		if(leaveStatus !=null && !leaveStatus.trim().equals("")){
			crit = crit.add(Restrictions.eq("leaveStatus.Id", Integer.parseInt(leaveStatus)));
		}
		Order order=Order.desc("Id");

		crit = crit.addOrder(order);//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));
		crit = crit.add(Restrictions.eq("EmpId.Id", userId));

		leaveDetailList = crit.list();

		System.out.println("Size of List :"+leaveDetailList.size());
		return leaveDetailList;
	}

	public List<HrEncashmentDetails> getLeavesEncashmentList(Integer userId, String fromDate, String toDate, String leaveType, String leaveStatus) {


		List<HrEncashmentDetails> leaveDetailList =null; //= getHibernateTemplate().find(query.toString());

		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(HrEncashmentDetails.class);

		if(fromDate !=null && !fromDate.trim().equals("") && toDate != null && !toDate.trim().equals("")){
			Date fromDateForQuery = HMSUtil.convertStringTypeDateToDateType(fromDate);
			Date toDateForQuery = HMSUtil.convertStringTypeDateToDateType(toDate);

			crit = crit.add(Restrictions.ge("AppliedOn", fromDateForQuery));
			crit = crit.add(Restrictions.le("AppliedOn", toDateForQuery));
		}
		if(leaveType != null && !leaveType.trim().equals("")){
			crit = crit.add(Restrictions.eq("LeaveType.Id", Integer.parseInt(leaveType)));

		}
		if(leaveStatus !=null && !leaveStatus.trim().equals("")){
			crit = crit.add(Restrictions.eq("LeaveStatus.Id", Integer.parseInt(leaveStatus)));
		}
		Order order=Order.desc("Id");

		crit = crit.addOrder(order);//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));

/*		if(userId != -1) {
			crit = crit.createAlias("ApprovedBy", "Emp").add(Restrictions.eq("Emp.Id", userId));
		}*/
		if(userId != -1) {
			crit = crit.add(Restrictions.eq("Emp.Id", userId));
		}


		leaveDetailList = crit.list();

		//System.out.println("Size of List :"+leaveDetailList.size());
		return leaveDetailList;
	}

	public void submitLeaveForm(List<HrLeaveDetails> optionalleaveList,int userId,String applierId)
	{
		String fromToDate="";
		String emailMessage="";
		String firstOrSecondHalf = "";
		Iterator<HrLeaveDetails> iterateoptionalleaveList = optionalleaveList.iterator();

		//List<HrLeaveDetails> leaveDetailsList = new ArrayList<HrLeaveDetails>();
		if(optionalleaveList != null){
			while(iterateoptionalleaveList.hasNext()){
				HrLeaveDetails leave=	iterateoptionalleaveList.next();

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(leave.getLeaveType().getLeaveType());
				hbt.save(leave.getLeaveType());
				hbt.save(leave);
				hbt.flush();

				//getHibernateTemplate().save(leave);

				saveLeaveHistory(leave);
				
				//////////////////////////////////
				String leaveAppliedBy = leave.getEmpId().getFirstName() + " " + leave.getEmpId().getLastName();
				String toBeApprovedBy = leave.getLeaveApprovedBy().getFirstName() + " " + leave.getLeaveApprovedBy().getLastName();
				String leaveType = "";
				if(leave.getLeaveType().getLeaveType().getLeaveType() != null){
				 leaveType = leave.getLeaveType().getLeaveType().getLeaveType().getDescription();
				}
				String subject = "Leave Application/" + leaveType
				   + "/" + leaveAppliedBy
				   + "/" + LeaveManagementUtil.convertDateToStringWithoutTime(leave.getAppliedOn());
				//Subject: Leave Application/Leave type/Emp. Name/Application Date

				//Dear (Title)(first and last name),

				//Emp. Name has applied for (leave type name) from date to date and will be joining back on date.
				//Kindly take up the necessary action by entering into your OMEGA account or by clicking on the link mentioned below.
				///////////////////////////////////////////////////////////////////

				/*emailMessage = "Dear " + leave.getLeaveApprovedBy().getTitle().getTitleName()
				                + " " + toBeApprovedBy
				                + ",\n\n";*/   // commented by Atul because it was throwing exception and the code was not of use because we are not using email notification in HAL

				emailMessage = emailMessage + leaveAppliedBy
				       + " has applied";

				if(leave.getHalfDay() != null && !leave.getHalfDay().equals("")) {
					if(leave.getHalfDay().equalsIgnoreCase("f")){
						firstOrSecondHalf = "first half";
					}else if(leave.getHalfDay().equalsIgnoreCase("s")){
						firstOrSecondHalf = "second half";
					}
					fromToDate=" for a half day " + leaveType + " for " + firstOrSecondHalf + " on "
						+ LeaveManagementUtil.convertDateToStringWithoutTime(leave.getFromDate()) + "";
				} else if (leave.getShortLeaveHalfDay() != null){
					if(leave.getShortLeaveHalfDay().equalsIgnoreCase("f")){
						firstOrSecondHalf = "first half";
					}else if(leave.getShortLeaveHalfDay().equalsIgnoreCase("s")){
						firstOrSecondHalf = "second half";
					}
					fromToDate=" for a " + leaveType + " for " + firstOrSecondHalf + " on "
						+ LeaveManagementUtil.convertDateToStringWithoutTime(leave.getFromDate()) + "";
				} else {
					fromToDate=" for " + leaveType
						+ " from " + LeaveManagementUtil.convertDateToStringWithoutTime(leave.getFromDate())
						+ " to "
						+ LeaveManagementUtil.convertDateToStringWithoutTime(leave.getToDate());
				}
				emailMessage = emailMessage + fromToDate + " and will be joining back on "
				   + LeaveManagementUtil.convertDateToStringWithoutTime(leave.getJoiningDate())
				   + ".\n"
				   + "Kindly take up the necessary action by entering into " +
				   		"your KSSC account or by clicking on the link mentioned below.\n" +
                  		
                  		"This is an auto generated mail through KSSC. Do not reply.";

				List<String> recipientAddresses = new ArrayList<String>();
				String senderAddresses = new String();
				List<String> ccAddresses = new ArrayList<String>();
				List<String> bccAddresses = new ArrayList<String>();

				if(leave.getLeaveApprovedBy().getEmail() != null  && !leave.getLeaveApprovedBy().getEmail().equals("")
						&& leave.getEmpId().getEmail() != null && !leave.getEmpId().getEmail().equals("")){
					recipientAddresses.add(leave.getLeaveApprovedBy().getEmail());
					senderAddresses = new String(leave.getEmpId().getEmail());

					ccAddresses.add(leave.getEmpId().getEmail());
					//ccAddresses.add("hrhelpdesk@clinirx.com");

					LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
							ccAddresses , bccAddresses ,emailMessage, subject);
				}
			}
		}
	}
	
	public Map getAddOrEdit(MasEmployee user) {
		Map addOrEdit=new HashMap();
		boolean teamSkills =false;
		List teamSkillsList = getHibernateTemplate().find("from jkt.hms.masters.business.UserManager as um where um.ManagerId="+user.getId());
		if(!teamSkillsList.isEmpty()){
			teamSkills=true;
		}
		addOrEdit.put("teamSkills",teamSkills);
		return addOrEdit;
	}

	public void submitTypeMaster(HrMasLeaveType hrMasLeaveType) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(hrMasLeaveType);
		hbt.refresh(hrMasLeaveType);

		saveMasLeaveTypeBackUp(hrMasLeaveType);
	}


	public List getMasLeaveTypeList() {
		List<HrMasLeaveType> masleaveTypeList=new ArrayList<HrMasLeaveType>();
		Map<String,Object> utilMap = new HashMap<String,Object>();

		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(HrMasLeaveType.class);

		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		Date currentDate = HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate"));

		crit = crit.add(Restrictions.le("ValidFromDate",currentDate ));
		crit = crit.add(Restrictions.ge("ValidToDate",currentDate ));

		Order order=Order.desc("Id");
		crit = crit.addOrder(order);//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));

		masleaveTypeList = crit.list();

		return masleaveTypeList;
	}


	public List getMasLeaveTypeList(int leaveType) {

		List<HrMasLeaveType> masleaveTypeList=new ArrayList<HrMasLeaveType>();

		Session session = (Session)getSession();

		Criteria crit = session.createCriteria(HrMasLeaveType.class);


		crit = crit.add(Restrictions.eq("LeaveType.Id", leaveType));

		Order order=Order.desc("Id");
		crit = crit.addOrder(order);

		masleaveTypeList = crit.list();

		return masleaveTypeList;

	}

	public List getMasLeaveTypeNewList(int leaveType) {

		List<HrMasLeaveTypeNew> masleaveTypeList=new ArrayList<HrMasLeaveTypeNew>();

		Session session = (Session)getSession();

		Criteria crit = session.createCriteria(HrMasLeaveTypeNew.class);

		crit = crit.add(Restrictions.eq("LeaveType.Id", leaveType));

		Order order=Order.asc("Id");
		crit = crit.addOrder(order);

		masleaveTypeList = crit.list();

		return masleaveTypeList;
	}

	public List getMasLeaveTypeNewMinFromDateForLeaveType(int leaveType) {

		List<Object[]> masleaveTypeList=new ArrayList<Object[]>();

		//masleaveTypeList = getHibernateTemplate().find("select hrmlt.Id,min(hrmlt.ValidFromDate),hrmlt.LeaveType from jkt.hms.masters.business.HrMasLeaveTypeNew as hrmlt group by hrmlt.LeaveType having hrmlt.LeaveType.Id="+leaveType);


		Session session = (Session)getSession();
		Query query = session.createQuery("select min(hrmlt.ValidFromDate),hrmlt.LeaveType.Id from jkt.hms.masters.business.HrMasLeaveTypeNew as hrmlt group by hrmlt.LeaveType having hrmlt.LeaveType.Id="+leaveType);

	/*	crit = crit.setProjection(Projections.projectionList()
				.add(Projections.min("ValidFromDate"))
				.add(Projections.property("LeaveType.Id"))
				.add(Projections.groupProperty("LeaveType.Id")));

		crit = crit.add(Restrictions.le("ValidFromDate",currentDate ));
		crit = crit.add(Restrictions.ge("ValidToDate",currentDate ));

		Order order=Order.asc("LeaveType.Id");
		crit = crit.addOrder(order);//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));*/

		masleaveTypeList = query.list();

		//System.out.println("mas leave type Size :"+masleaveTypeList.size());
		return masleaveTypeList;
	}

	@SuppressWarnings("unchecked")
	public List getMasLeaveTypeNewList() {

		List<HrMasLeaveTypeNew> masleaveTypeList=new ArrayList<HrMasLeaveTypeNew>();
		Map<String,Object> utilMap = new HashMap<String,Object>();

		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(HrMasLeaveTypeNew.class);

		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		Date currentDate = HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate"));

/*		crit = crit.add(Restrictions.le("ValidFromDate",currentDate ));
		crit = crit.add(Restrictions.ge("ValidToDate",currentDate ));*/

		Order order=Order.asc("LeaveType.Id");
		crit = crit.addOrder(order);//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));

		masleaveTypeList = crit.list();

		return masleaveTypeList;
	}

	public List getMasLeaveTypeMediatorList() {

		List<HrMasLeaveTypeMediator> masleaveTypeList=new ArrayList<HrMasLeaveTypeMediator>();

		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(HrMasLeaveTypeMediator.class);

		crit = crit.createAlias("LeaveType", "lt").add(Restrictions.eq("lt.Status", "y"));
		Order order=Order.asc("lt.LeaveType.Id");
		crit = crit.addOrder(order);
		//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));
		masleaveTypeList = crit.list();

		return masleaveTypeList;
	}

	public List getMasLeaveTypeNewForMaxDate(int leaveType,Date maxDate) {

		List<HrMasLeaveTypeNew> masleaveTypeList=new ArrayList<HrMasLeaveTypeNew>();

		Session session = (Session)getSession();

		Criteria crit = session.createCriteria(HrMasLeaveTypeNew.class);


		crit = crit.add(Restrictions.eq("LeaveType.Id", leaveType));
		crit = crit.add(Restrictions.eq("ValidToDate", maxDate));

		Order order=Order.asc("Id");
		crit = crit.addOrder(order);

		masleaveTypeList = crit.list();

		return masleaveTypeList;
	}

	public List getMasLeaveTypeListForId(int id) {

		List<HrMasLeaveTypeNew> masleaveTypeList=new ArrayList<HrMasLeaveTypeNew>();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		HrMasLeaveTypeNew masleaveType = (HrMasLeaveTypeNew)hbt.load(HrMasLeaveTypeNew.class, id);

		masleaveTypeList.add(masleaveType);

		return masleaveTypeList;

	}

	public List getEncashableMasLeaveType(int empId) {

		List<HrEmployeeBalanceNew> hrEmployeeBalance=new ArrayList<HrEmployeeBalanceNew>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		List<HrEncashmentDetails> hrEncashmentDetails=new ArrayList<HrEncashmentDetails>();
		
		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(HrEmployeeBalanceNew.class);

		//utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		//Date currentDate = HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate"));

		//crit = crit.add(Restrictions.le("ValidFromDate",currentDate ));
		//crit = crit.add(Restrictions.ge("ValidToDate",currentDate ));
		crit = crit.createAlias("LeaveType", "lt");
		crit = crit.createAlias("lt.LeaveType", "lt1");
		//crit = crit.createAlias("lt1.LeaveType", "lt2");
		crit = crit.add(Restrictions.eq("lt1.Encashable", "y" ));
		crit = crit.add(Restrictions.eq("Emp.Id",empId ));

		Order order=Order.asc("Id");
		crit = crit.addOrder(order);//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));

		hrEmployeeBalance = crit.list();
			//System.out.println("in data service :"+hrEmployeeBalance.size());
		return hrEmployeeBalance;

	}

	public void applyForEncashment(HrEncashmentDetails encashmentDetails) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(encashmentDetails);
		hbt.refresh(encashmentDetails);
		saveLeaveEncashmentHistory(encashmentDetails);

//////////////////////////////////
		String emailMessage="";
		String leaveAppliedBy = encashmentDetails.getEmp().getFirstName() + " " + encashmentDetails.getEmp().getLastName();
		String toBeApprovedBy = encashmentDetails.getApprovedBy().getFirstName() + " " + encashmentDetails.getApprovedBy().getLastName();
		String leaveType = encashmentDetails.getLeaveType().getLeaveType().getLeaveType().getDescription();
		String subject = "Leave Encashment Request/"
			+ leaveAppliedBy + ":" + encashmentDetails.getEmp().getEmployeeCode();
		//Subject: Leave Encashment Request/Employee Name: Employee Code
		//Dear (Title)(first and last name),
		//Emp. Name has applied for leave encashment of leave type for (No. of Days).
		//Kindly take up the necessary action by entering into your OMEGA account or by clicking on the link mentioned below.
		//http://www.omega.clinirx.com

///////////////////////////////////////////////////////////////////
		emailMessage = "Dear " + encashmentDetails.getApprovedBy().getTitle().getTitleName()
		                + " " + toBeApprovedBy
		                + ",\n\n";

		emailMessage = emailMessage + leaveAppliedBy
		       + " has applied for leave encashment of " + leaveType
		       + " for ";
		       if(encashmentDetails.getLeaveToEncash().equals("1")){
		    	   emailMessage = emailMessage + encashmentDetails.getLeaveToEncash() + " day.\n";
		       }else{
		    	   emailMessage = emailMessage + encashmentDetails.getLeaveToEncash() + " days.\n";
		       }
		       emailMessage = emailMessage + "Kindly take up the necessary action by entering into " +
		   		"your KSSC account or by clicking on the link mentioned below.\n" +
          		
          		"This is an auto generated mail through KSSC. Do not reply.";

		List<String> recipientAddresses = new ArrayList<String>();
		String senderAddresses = new String();
		List<String> ccAddresses = new ArrayList<String>();
		List<String> bccAddresses = new ArrayList<String>();

		if(encashmentDetails.getApprovedBy().getEmail() != null  && !encashmentDetails.getApprovedBy().getEmail().equals("")
				&& encashmentDetails.getEmp().getEmail() != null && !encashmentDetails.getEmp().getEmail().equals("")){
			recipientAddresses.add(encashmentDetails.getApprovedBy().getEmail());
			senderAddresses = new String(encashmentDetails.getEmp().getEmail());

			ccAddresses.add(encashmentDetails.getEmp().getEmail());
			//ccAddresses.add("hrhelpdesk@clinirx.com");

			LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
					ccAddresses , bccAddresses ,emailMessage, subject);
		}


	}
	public void updateLeaveTypeMasterNew(HrMasLeaveTypeNew hrMasLeaveTypeNew) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.update(hrMasLeaveTypeNew);
		hbt.refresh(hrMasLeaveTypeNew);

		//saveMasLeaveTypeBackUp(hrMasLeaveType);

	}

	public void updateTypeMaster(HrMasLeaveType hrMasLeaveType) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.update(hrMasLeaveType);
		hbt.refresh(hrMasLeaveType);

		//saveMasLeaveTypeBackUp(hrMasLeaveType);

	}


	public void saveEmployeeLeaveBalance(HrEmployeeBalance employeeBalance) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(employeeBalance);
		hbt.refresh(employeeBalance);
		saveEmployeeLeaveBalanceHistory(employeeBalance);

	}

	public void saveEmployeeLeaveBalanceNew(HrEmployeeBalanceNew employeeBalance) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(employeeBalance);
		hbt.refresh(employeeBalance);
		saveEmployeeLeaveBalanceNewHistory(employeeBalance,"0","n");

	}

	public void saveEmployeeLeaveBalanceNewHistory(HrEmployeeBalanceNew employeeBalance,String noOfWorkingDaysToSave, String encashedOrSimple) {

		HrEmployeeBalanceNewHistory employeeBalanceHistory =new HrEmployeeBalanceNewHistory();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		employeeBalanceHistory.setClosingBalance(employeeBalance.getClosingBalance());
		//employeeBalanceHistory.setEarned(employeeBalance.getEarned());
		employeeBalanceHistory.setEmp(employeeBalance.getEmp());
		employeeBalanceHistory.setLastChgBy(employeeBalance.getLastChgBy());
		employeeBalanceHistory.setLastChgDate(employeeBalance.getLastChgDate());
		employeeBalanceHistory.setLastChgTime(employeeBalance.getLastChgTime());
		employeeBalanceHistory.setLeaveType(employeeBalance.getLeaveType());
		employeeBalanceHistory.setOpeningBalance(employeeBalance.getOpeningBalance());
		employeeBalanceHistory.setStatus(employeeBalance.getStatus());
		employeeBalanceHistory.setTaken(employeeBalance.getTaken());
		employeeBalanceHistory.setNoOfWorkingDays(noOfWorkingDaysToSave);
		employeeBalanceHistory.setEncashedOrSimple(encashedOrSimple);
		employeeBalanceHistory.setClosingBalance(employeeBalance.getClosingBalance());
		
		hbt.save(employeeBalanceHistory);
		hbt.refresh(employeeBalanceHistory);
	}


	public void saveEmployeeLeaveBalanceHistory(HrEmployeeBalance employeeBalance) {

		HrEmployeeBalanceHistory employeeBalanceHistory =new HrEmployeeBalanceHistory();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		employeeBalanceHistory.setClosingBalance(employeeBalance.getClosingBalance());
		employeeBalanceHistory.setEarned(employeeBalance.getEarned());
		employeeBalanceHistory.setEmp(employeeBalance.getEmp());
		employeeBalanceHistory.setLastChgBy(employeeBalance.getLastChgBy());
		employeeBalanceHistory.setLastChgDate(employeeBalance.getLastChgDate());
		employeeBalanceHistory.setLastChgTime(employeeBalance.getLastChgTime());
		employeeBalanceHistory.setLeaveType(employeeBalance.getLeaveType());
		employeeBalanceHistory.setOpeningBalance(employeeBalance.getOpeningBalance());
		employeeBalanceHistory.setStatus(employeeBalance.getStatus());
		employeeBalanceHistory.setTaken(employeeBalance.getTaken());

		hbt.save(employeeBalanceHistory);
		hbt.refresh(employeeBalanceHistory);
	}

	public void saveMasLeaveTypeBackUp(HrMasLeaveType hrMasLeaveType) {
		HrMasLeaveTypeBackup hrMasLeaveTypeBackup = new HrMasLeaveTypeBackup();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hrMasLeaveTypeBackup.setAllowedDays(hrMasLeaveType.getAllowedDays());
		hrMasLeaveTypeBackup.setCrFrdable(hrMasLeaveType.getCrFrdable());
		hrMasLeaveTypeBackup.setEncashable(hrMasLeaveType.getEncashable());
		hrMasLeaveTypeBackup.setEncashablePercent(hrMasLeaveType.getEncashablePercent());
		hrMasLeaveTypeBackup.setEnchFormula(hrMasLeaveType.getEnchFormula());
		hrMasLeaveTypeBackup.setLastChgBy(hrMasLeaveType.getLastChgBy());
		hrMasLeaveTypeBackup.setLastChgDate(hrMasLeaveType.getLastChgDate());
		hrMasLeaveTypeBackup.setLastChgTime(hrMasLeaveType.getLastChgTime());
		hrMasLeaveTypeBackup.setLeaveType(hrMasLeaveType.getLeaveType());
		hrMasLeaveTypeBackup.setMonthOrYear(hrMasLeaveType.getMonthOrYear());
		hrMasLeaveTypeBackup.setRemarks(hrMasLeaveType.getRemarks());
		hrMasLeaveTypeBackup.setStatus(hrMasLeaveType.getStatus());
		hrMasLeaveTypeBackup.setValidFromDate(hrMasLeaveType.getValidFromDate());
		hrMasLeaveTypeBackup.setValidToDate(hrMasLeaveType.getValidToDate());

		hbt.save(hrMasLeaveTypeBackup);
		hbt.refresh(hrMasLeaveTypeBackup);

		saveMasLeaveTypeHistory(hrMasLeaveTypeBackup);
	}

	public void saveMasLeaveTypeHistory(HrMasLeaveTypeBackup hrMasLeaveTypeBackup) {
		HrMasLeaveTypeHistory hrMasLeaveTypeHistory = new HrMasLeaveTypeHistory();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hrMasLeaveTypeHistory.setAllowedDays(hrMasLeaveTypeBackup.getAllowedDays());
		hrMasLeaveTypeHistory.setCrFrdable(hrMasLeaveTypeBackup.getCrFrdable());
		hrMasLeaveTypeHistory.setEncashable(hrMasLeaveTypeBackup.getEncashable());
		hrMasLeaveTypeHistory.setEncashablePercent(hrMasLeaveTypeBackup.getEncashablePercent());
		hrMasLeaveTypeHistory.setEnchFormula(hrMasLeaveTypeBackup.getEnchFormula());
		hrMasLeaveTypeHistory.setLastChgBy(hrMasLeaveTypeBackup.getLastChgBy());
		hrMasLeaveTypeHistory.setLastChgDate(hrMasLeaveTypeBackup.getLastChgDate());
		hrMasLeaveTypeHistory.setLastChgTime(hrMasLeaveTypeBackup.getLastChgTime());
		hrMasLeaveTypeHistory.setLeaveType(hrMasLeaveTypeBackup.getLeaveType());
		hrMasLeaveTypeHistory.setMonthOrYear(hrMasLeaveTypeBackup.getMonthOrYear());
		hrMasLeaveTypeHistory.setRemarks(hrMasLeaveTypeBackup.getRemarks());
		hrMasLeaveTypeHistory.setStatus(hrMasLeaveTypeBackup.getStatus());
		hrMasLeaveTypeHistory.setValidFromDate(hrMasLeaveTypeBackup.getValidFromDate());
		hrMasLeaveTypeHistory.setValidToDate(hrMasLeaveTypeBackup.getValidToDate());

		hbt.save(hrMasLeaveTypeHistory);
		hbt.refresh(hrMasLeaveTypeHistory);
	}

	public List<HrEmployeeBalanceNew> getLeaveBalance(int empId,String leaveType) {


		List<HrEmployeeBalanceNew> leaveBal=new ArrayList<HrEmployeeBalanceNew>();

		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(HrEmployeeBalanceNew.class);

		if(leaveType != null && !leaveType.trim().equals("")){
			crit = crit.add(Restrictions.eq("LeaveType.Id", Integer.parseInt(leaveType)));
		}

		//System.out.println("Employee Id :"+empId);
		crit = crit.add(Restrictions.eq("Emp.Id", empId ));

		Order order=Order.asc("Id");
		crit = crit.addOrder(order);//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));

		leaveBal = crit.list();
		//System.out.println("leave bal in data servive :"+leaveBal.size());

		return leaveBal;
	}

	public void submitTypeMasterNew(HrMasLeaveTypeNew hrMasLeaveType) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(hrMasLeaveType);
		hbt.refresh(hrMasLeaveType);

		//saveMasLeaveTypeBackUp(hrMasLeaveType);
	}

	public void saveToHrMasLeaveTypeMediator(HrMasLeaveTypeMediator hrMasLeaveTypeMediator) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(hrMasLeaveTypeMediator);
		hbt.refresh(hrMasLeaveTypeMediator);

		//save to history
		saveToHrMasLeaveTypeMediatorHistory(hrMasLeaveTypeMediator);
	}

	public void updateToHrMasLeaveTypeMediator(HrMasLeaveTypeMediator hrMasLeaveTypeMediator) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.update(hrMasLeaveTypeMediator);
		hbt.refresh(hrMasLeaveTypeMediator);

		saveToHrMasLeaveTypeMediatorHistory(hrMasLeaveTypeMediator);
	}

	public void saveToHrMasLeaveTypeMediatorHistory(HrMasLeaveTypeMediator hrMasLeaveTypeMediator) {
		HrMasLeaveTypeMediatorHistory hrMasLeaveTypeMediatorHistory = new HrMasLeaveTypeMediatorHistory();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hrMasLeaveTypeMediatorHistory.setLeaveType(hrMasLeaveTypeMediator.getLeaveType());

		hbt.save(hrMasLeaveTypeMediatorHistory);
		hbt.refresh(hrMasLeaveTypeMediatorHistory);

	}

	public void updateLeavePolicy()
	{
		int hrMasLeaveTypeNewId=0;
		String tomorrow = "";
		Calendar cal = Calendar.getInstance();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cal.add(Calendar.DATE, +1);
		tomorrow=dateFormat.format(cal.getTime());

		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		HrMasLeaveTypeNew hrMasLeaveTypeNew = new HrMasLeaveTypeNew();
		List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediatorList = new ArrayList<HrMasLeaveTypeMediator>();

		hrMasLeaveTypeMediatorList= hbt.find("from HrMasLeaveTypeMediator as hmt where hmt.LeaveType.ValidToDate='"+HMSUtil.getDateFormat(new Date(), "yyyy-MM-dd")+"'");
		if(hrMasLeaveTypeMediatorList!=null && hrMasLeaveTypeMediatorList.size()>0)
		{
			for (HrMasLeaveTypeMediator hrMasLeaveTypeMediator : hrMasLeaveTypeMediatorList)
			{
				int mediatorId=hrMasLeaveTypeMediator.getId();
				hrMasLeaveTypeNewId=hrMasLeaveTypeMediator.getLeaveType().getId();

				HrMasLeaveTypeNew hrMasLeaveTypeNewobj = hrMasLeaveTypeMediator.getLeaveType();

				if(hrMasLeaveTypeNewobj.getStatus().equalsIgnoreCase("y")) {
					hrMasLeaveTypeNewobj.setStatus("n");
				}
				//leaveType=hrMasLeaveTypeNewobj.getLeaveType();
				int leaveTypeId=0;
				leaveTypeId=hrMasLeaveTypeNewobj.getLeaveType().getId();
				hbt.update(hrMasLeaveTypeNewobj);
				hbt.refresh(hrMasLeaveTypeNewobj);

				HrMasLeaveTypeNew hrMasLeaveTypeNewFresh = (HrMasLeaveTypeNew)hbt.find("from HrMasLeaveTypeNew as leaveType where leaveType.ValidFromDate='"+tomorrow+"' and leaveType.LeaveType.Id='"+leaveTypeId+"'").get(0);
				int noOfDaysAllowed =0;
				String crFwd="";
				String mnthORyear="";

				noOfDaysAllowed=Integer.valueOf(hrMasLeaveTypeNewFresh.getAllowedDays());
				mnthORyear= hrMasLeaveTypeNewFresh.getMonthOrYear();
				crFwd = hrMasLeaveTypeNewFresh.getCrFrdable();

				if(hrMasLeaveTypeNewFresh.getStatus().equalsIgnoreCase("n")) {
					hrMasLeaveTypeNewFresh.setStatus("y");
				}
				hrMasLeaveTypeMediator.setLeaveType(hrMasLeaveTypeNewFresh);
				hbt.update(hrMasLeaveTypeMediator);
				hbt.refresh(hrMasLeaveTypeMediator);
				List<HrEmployeeBalanceNew> hrEmployeeBalanceNewList = hbt.find("from HrEmployeeBalanceNew as empBal where empBal.LeaveType.Id='"+mediatorId+"'");
				for (HrEmployeeBalanceNew hrEmployeeBalanceNew : hrEmployeeBalanceNewList) {
					Date date = new Date();
					//int sexid=hrEmployeeBalanceNew.getEmp().getEmployeePersonalDetails().getGender().getId();
					//int leaveid=hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId();

					double closingBal=0;
					double openingBal=0;
					double earn=0;
					double taken=0;
					double newOpeningBal= 0;
					//openingBal = noOfDaysAllowed;
					//if(((sexid==2) && (leaveid==3))||((sexid==3)&&(leaveid==4)))
					//{

					//}else{
					if(mnthORyear.equalsIgnoreCase("m")) {
						if((date.getMonth()== 12) && (date.getDay()==31) ){
							earn=noOfDaysAllowed;//wrong calculation
						}else{
							earn=noOfDaysAllowed;
						}
					} else if(mnthORyear.equalsIgnoreCase("y")) {
						earn = noOfDaysAllowed/12;
					}

					if(hrEmployeeBalanceNew.getClosingBalance()!=null) {
						closingBal =Double.valueOf(hrEmployeeBalanceNew.getClosingBalance());
					} else {
						closingBal =0;
					}

//				if(hrEmployeeBalanceNew.getOpeningBalance()!=null)
//				{
//					openingBal =Double.valueOf(hrEmployeeBalanceNew.getOpeningBalance());
//				}
//				else
//				{
//					openingBal =0;
//				}
					if(hrEmployeeBalanceNew.getTaken()!=null) {
						taken = Double.valueOf(hrEmployeeBalanceNew.getTaken());
					} else {
						taken = 0;
					}

					if(crFwd.equalsIgnoreCase("y"))
					{
						if((date.getMonth()== 12) && (date.getDay()==31) )
						{
							newOpeningBal = 0;
							closingBal=0;
							earn=0;
						}else{
							newOpeningBal = closingBal;
						}
					}else{
						newOpeningBal = openingBal;
					}
					//}
					hrEmployeeBalanceNew.setOpeningBalance(new DecimalFormat("0.##").format((double)newOpeningBal));
					hrEmployeeBalanceNew.setClosingBalance(new DecimalFormat("0.##").format((double)(newOpeningBal+earn-taken)));

					hrEmployeeBalanceNew.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					hrEmployeeBalanceNew.setLastChgTime(time);
					hbt.update(hrEmployeeBalanceNew);
					hbt.refresh(hrEmployeeBalanceNew);
				}
			}
		}
	}
	@SuppressWarnings("unchecked")
	public void updateLeaveBalanceMonthly() {
		Session session=getSession();
		Transaction tx = session.beginTransaction();
		try{
			HrMasLeave leaveType=new HrMasLeave();
			Calendar cal = Calendar.getInstance();
			//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			cal.add(Calendar.DATE, +1);

			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");
			String time = (String)utilMap.get("currentTime");

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			int childrenCount = 0;
			List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediatorList = new ArrayList<HrMasLeaveTypeMediator>();
			hrMasLeaveTypeMediatorList= session.createCriteria(HrMasLeaveTypeMediator.class)
												.createAlias("LeaveType", "lt")
												.add(Restrictions.eq("lt.Status", "y"))
												.list();

			if(hrMasLeaveTypeMediatorList!=null && hrMasLeaveTypeMediatorList.size()>0) {
				for (HrMasLeaveTypeMediator hrMasLeaveTypeMediator : hrMasLeaveTypeMediatorList) {
					HrAccruelRecord hrAccruelRecord = new HrAccruelRecord();
					int mediatorId=hrMasLeaveTypeMediator.getId();

					HrMasLeaveTypeNew hrMasLeaveTypeNewobj = hrMasLeaveTypeMediator.getLeaveType();
					leaveType=hrMasLeaveTypeNewobj.getLeaveType();
					int leaveTypeId=0;
					leaveTypeId=leaveType.getId();

					double noOfDaysAllowed =0;
					String crFwd="";
					String mnthORyear="";

					noOfDaysAllowed=Double.valueOf(hrMasLeaveTypeNewobj.getAllowedDays());
					mnthORyear= hrMasLeaveTypeNewobj.getMonthOrYear();
					crFwd = hrMasLeaveTypeNewobj.getCrFrdable();

					List<HrEmployeeBalanceNew> hrEmployeeBalanceNewList = new ArrayList<HrEmployeeBalanceNew>();
					hrEmployeeBalanceNewList = session.createCriteria(HrEmployeeBalanceNew.class)
										.add(Restrictions.eq("LeaveType.Id", mediatorId))
										.list();
					if(hrEmployeeBalanceNewList.size()>0){
						for (HrEmployeeBalanceNew hrEmployeeBalanceNew : hrEmployeeBalanceNewList) {
							List<Integer> empDependents = new ArrayList<Integer>();

							empDependents = session.createCriteria(MasEmployeeDependent.class)
													.add(Restrictions.eq("Employee.Id", hrEmployeeBalanceNew.getEmp().getId()))
													.createAlias("Relation", "rel")
													.add(Restrictions.or(
															Restrictions.eq("rel.RelationCode", "03"),
															Restrictions.eq("rel.RelationCode", "04")))
													.setProjection(Projections.projectionList()
															.add(Projections.count("rel.RelationCode")))
													.list();

							int sexid = 0;
							if(hrEmployeeBalanceNew.getEmp().getPersonalDetails()!=null) {
								 sexid=hrEmployeeBalanceNew.getEmp().getPersonalDetails().getGender().getId();
							}

							Date date = new Date();
							double earn=0;
							double newOpeningBal= 0;
							double newOpeningBalYearly=0;
							double newClosingBal= 0;
							double newClosingBalYearly = 0;
							int currentMonth = date.getMonth()+1;
							
							Calendar calendar = Calendar.getInstance();
							Integer currentYear =  calendar.get(Calendar.YEAR);
							int monthMaxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
							
							String alreadyAvailed = hrEmployeeBalanceNew.getAlreadyAvailedPatMat();
							childrenCount = empDependents.get(0);

							//if(((sexid==2) && (leaveTypeId==3)) || ((sexid==3)&&(leaveTypeId==4))) {
							if(((sexid==2) && (leaveTypeId==3))) { // for maternity
								if((currentMonth== 12) && (date.getDate()==31)) {
										if(childrenCount < 2){
											hrEmployeeBalanceNew.setEarned(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
											hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
											hrEmployeeBalanceNew.setClosingBalance(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
											hrEmployeeBalanceNew.setClosingBalanceYearly(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
											hrAccruelRecord.setAccrued(hrMasLeaveTypeNewobj.getAllowedDays());
										} else {
											hrEmployeeBalanceNew.setEarned("0");
											hrEmployeeBalanceNew.setAccrued("0");
											hrEmployeeBalanceNew.setClosingBalance("0");
											hrEmployeeBalanceNew.setClosingBalanceYearly("0");
											hrAccruelRecord.setAccrued("0");
										}
										hrEmployeeBalanceNew.setBalanceAdjusted("0");
										hrEmployeeBalanceNew.setAlreadyAvailedPatMat("n");
										hrEmployeeBalanceNew.setTaken("0");
										hrEmployeeBalanceNew.setTotalLeaveTaken("0");
										//hrEmployeeBalanceNew.setEntitlementAccJoinDate(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
								}else{
									if(alreadyAvailed.equals("y")){
										hrEmployeeBalanceNew.setClosingBalance("0");
										hrEmployeeBalanceNew.setClosingBalanceYearly("0");
									}
								}
								hrEmployeeBalanceNew.setOpeningBalance(new DecimalFormat("0.##").format((double)0));
								hrEmployeeBalanceNew.setOpeningBalanceYearly(new DecimalFormat("0.##").format((double)0));
							}else if(leaveTypeId != 4 && leaveTypeId != 3) {
								if(mnthORyear.equalsIgnoreCase("m")) { //-------------------
									earn = new Double(noOfDaysAllowed);
									if((currentMonth== 12) && (date.getDate()==31) ) {
										if(crFwd.equalsIgnoreCase("y")){
											newOpeningBal = Double.valueOf(hrEmployeeBalanceNew.getClosingBalance());
											newClosingBal = newOpeningBal + earn;

											newOpeningBalYearly = Double.valueOf(hrEmployeeBalanceNew.getClosingBalanceYearly());
											newClosingBalYearly = newOpeningBalYearly + noOfDaysAllowed;
										}else{
											newOpeningBal = 0;
											newClosingBal = earn;

											newOpeningBalYearly = 0;
											newClosingBalYearly = noOfDaysAllowed;
										}
										hrEmployeeBalanceNew.setOpeningBalanceYearly(new DecimalFormat("0.##").format((double)newOpeningBalYearly));
										hrEmployeeBalanceNew.setClosingBalanceYearly(new DecimalFormat("0.##").format((double)(newClosingBalYearly)));
										hrEmployeeBalanceNew.setBalanceAdjusted("0");
										hrEmployeeBalanceNew.setTotalLeaveTaken("0");
										hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format((double)(earn)));
										hrEmployeeBalanceNew.setEntitlementAccJoinDate(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
									} else {
										newOpeningBal = Double.valueOf(hrEmployeeBalanceNew.getClosingBalance());;
										newClosingBal = newOpeningBal +  earn;

										double alreadyEarned = 0;
										if(hrEmployeeBalanceNew.getAccrued() != null){
											alreadyEarned = Double.valueOf(hrEmployeeBalanceNew.getAccrued());
										}
										double totalEarned = alreadyEarned + earn;
										hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format((double)totalEarned));
									}
								} else if(mnthORyear.equalsIgnoreCase("y")) {
									//earn = new Double(noOfDaysAllowed/12.0);
									earn = new Double(noOfDaysAllowed);
									
									if(leaveTypeId==13){ // for EL
										int leaveDays=0;
										int earnDays=0;
										int absentDays=0;
										for(int i=1; i<=monthMaxDays;i++){
											
											// for leave count except Cl
										String leaveCountQry ="select no_of_working_days from hr_leave_details where empid="+hrEmployeeBalanceNew.getEmp().getId()+"  and status=2 and '"+currentYear+"/"+currentMonth+"/"+i+"'"
															+"' between from_date and to_date and  leave_type !=2 "; // except casual leave
										//System.out.println("leaveCountQry>>>"+leaveCountQry);
										int leave  = (Integer)session.createSQLQuery(leaveCountQry).uniqueResult();
										
										
										// for CL count
										String clCountQry ="select no_of_working_days from hr_leave_details where empid="+hrEmployeeBalanceNew.getEmp().getId()+"  and status=2 and '"+currentYear+"/"+currentMonth+"/"+i+"'"
												+"' between from_date and to_date and  leave_type = 2 "; // except casual leave
											//System.out.println("leaveCountQry>>>"+leaveCountQry);
											int clDays  = (Integer)session.createSQLQuery(clCountQry).uniqueResult();
											
											//System.out.println("CL>> >"+clDays+"  another leave>>> "+leave);
										
											// for Absent count
										if(leave == 0 && clDays == 0){ // 
											String ChkAbsent ="select count(*) from hr_attendance_loader where employee_id="+hrEmployeeBalanceNew.getEmp().getId()+" and date='"+currentYear+"/"+currentMonth+"/"+i+"'";
											int absent  = (Integer)session.createSQLQuery(clCountQry).uniqueResult();
											 
											if(absent==0){ // not entry in hr_attendance_loader table that means employee absent
												absentDays = absentDays+1;
											}
											
										}
										leaveDays = leaveDays+leave;
										}
										earnDays= monthMaxDays-leaveDays-absentDays;
										earn = earnDays/11;
										
									}// End for EL
									
									if((currentMonth == 12) && (date.getDate()==31) ) {
										if(crFwd.equalsIgnoreCase("y")){
											if(leaveTypeId != 13){
											newOpeningBal = Double.valueOf(hrEmployeeBalanceNew.getClosingBalance());
											newClosingBal = newOpeningBal + earn;

											newOpeningBalYearly = Double.valueOf(hrEmployeeBalanceNew.getClosingBalanceYearly());
											newClosingBalYearly = newOpeningBalYearly + noOfDaysAllowed;
											}else{
												
												newOpeningBal = Double.valueOf(hrEmployeeBalanceNew.getClosingBalance());
												if(newOpeningBal != 30){
													newClosingBal = newOpeningBal + earn;
												}else{
													newClosingBal = newOpeningBal;
												}
												newOpeningBalYearly = Double.valueOf(hrEmployeeBalanceNew.getClosingBalanceYearly());
												newClosingBalYearly = newOpeningBalYearly + noOfDaysAllowed;
												
											}
										}else{
											newOpeningBal = 0;
											newClosingBal = earn;

											newOpeningBalYearly = 0;
											newClosingBalYearly = noOfDaysAllowed;
										}
										hrEmployeeBalanceNew.setOpeningBalanceYearly(new DecimalFormat("0.##").format((double)newOpeningBalYearly));
										hrEmployeeBalanceNew.setClosingBalanceYearly(new DecimalFormat("0.##").format((double)(newClosingBalYearly)));
										hrEmployeeBalanceNew.setBalanceAdjusted("0");
										hrEmployeeBalanceNew.setTotalLeaveTaken("0");
										hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format((double)(earn)));
										hrEmployeeBalanceNew.setEntitlementAccJoinDate(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
									} else {
										if(leaveTypeId != 13){
											newOpeningBal = (Double.valueOf(hrEmployeeBalanceNew.getClosingBalance()));
											newClosingBal = newOpeningBal +  earn;
	
											double alreadyEarned = 0;
											if(hrEmployeeBalanceNew.getAccrued() != null){
												alreadyEarned = Double.valueOf(hrEmployeeBalanceNew.getAccrued());
											}
											double totalEarned = alreadyEarned + earn;
											hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format((double)totalEarned));
										
										}else{ // for EL
											
											newOpeningBal = (Double.valueOf(hrEmployeeBalanceNew.getClosingBalance()));
											if(newOpeningBal != 30){
													newClosingBal = newOpeningBal +  earn;
													double alreadyEarned = 0;
													if(hrEmployeeBalanceNew.getAccrued() != null){
														alreadyEarned = Double.valueOf(hrEmployeeBalanceNew.getAccrued());
													}
													double totalEarned = alreadyEarned + earn;
													hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format((double)totalEarned));
											}else{
												newClosingBal = newOpeningBal ;
												double alreadyEarned = 0;
												if(hrEmployeeBalanceNew.getAccrued() != null){
													alreadyEarned = Double.valueOf(hrEmployeeBalanceNew.getAccrued());
												}
												double totalEarned = alreadyEarned ;
												hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format((double)totalEarned));
											}
										
											
										}
									}
								}
								/*if(leaveTypeId == 20) {
									newOpeningBal = 0;
									newOpeningBalYearly = 0;
									earn = new Double(noOfDaysAllowed);
									newClosingBal = new Double(noOfDaysAllowed);
									newClosingBalYearly = new Double(noOfDaysAllowed);
									hrEmployeeBalanceNew.setBalanceAdjusted("0");
									hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format((double)earn));
									hrEmployeeBalanceNew.setOpeningBalanceYearly(new DecimalFormat("0.##").format((double)newOpeningBalYearly));
									hrEmployeeBalanceNew.setClosingBalanceYearly(new DecimalFormat("0.##").format((double)(newClosingBalYearly)));
									hrEmployeeBalanceNew.setEntitlementAccJoinDate(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
								}*/
								hrEmployeeBalanceNew.setOpeningBalance(new DecimalFormat("0.##").format((double)newOpeningBal));
								hrEmployeeBalanceNew.setClosingBalance(new DecimalFormat("0.##").format((double)(newClosingBal)));

								hrEmployeeBalanceNew.setTaken("0");
								hrEmployeeBalanceNew.setEarned(new DecimalFormat("0.##").format((double)earn));
							}
							hrAccruelRecord.setAccrued(new DecimalFormat("0.##").format((double)earn));
							hrAccruelRecord.setMonth(String.valueOf(cal.get(Calendar.MONTH)+1));
							hrAccruelRecord.setYear(String.valueOf(cal.get(Calendar.YEAR)));
							hrAccruelRecord.setEmp(hrEmployeeBalanceNew.getEmp());
							hrAccruelRecord.setBalance(hrEmployeeBalanceNew);
							hrAccruelRecord.setLeaveType(hrEmployeeBalanceNew.getLeaveType());
							hbt.save(hrAccruelRecord);
							//hbt.refresh(hrAccruelRecord);

							hrEmployeeBalanceNew.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
							hrEmployeeBalanceNew.setLastChgTime(time);

							hbt.update(hrEmployeeBalanceNew);
							//hbt.refresh(hrEmployeeBalanceNew);
					}
					// EXECUTES WHEN NEW LEAVE TYPE IS ADDED.
				} else {
					List<MasEmployee> masEmployeeList = hbt.find("from MasEmployee as emp where emp.Status='y'");
					for (MasEmployee masEmployee : masEmployeeList) {

						List<Integer> empDependents = new ArrayList<Integer>();
						empDependents = session.createCriteria(MasEmployeeDependent.class)
												.add(Restrictions.eq("Employee.Id", masEmployee.getId()))
												.createAlias("Relation", "rel")
												.add(Restrictions.or(
														Restrictions.eq("rel.RelationCode", "03"),
														Restrictions.eq("rel.RelationCode", "04")))
												.setProjection(Projections.projectionList()
														.add(Projections.count("rel.RelationCode")))
												.list();

						childrenCount = empDependents.get(0);
						int joinDate =new Integer( (HMSUtil.convertDateToStringTypeDate(masEmployee.getJoinDate())).substring(0, 2));
						HrEmployeeBalanceNew newObj = new HrEmployeeBalanceNew();
						double closingBal=0;
						double openingBal=0;
						double earn=0;
						double taken=0;
						Date date = new Date();
						int sexid=masEmployee.getPersonalDetails().getGender().getId();

						if(((sexid==2) && (leaveTypeId==3))||((sexid==3)&&(leaveTypeId==4))) {
							HrMasLeaveTypeMediator mediator = new HrMasLeaveTypeMediator();
							mediator.setId(mediatorId);
							newObj.setLeaveType(mediator);
							newObj.setEmp(masEmployee);
							newObj.setTaken("0");
							newObj.setTotalLeaveTaken("0");
							newObj.setOpeningBalance(new DecimalFormat("0.##").format((double)0));
							newObj.setClosingBalance(new DecimalFormat("0.##").format((double)(noOfDaysAllowed)));
							if(childrenCount < 2 ){
								newObj.setEarned(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
								hrAccruelRecord.setAccrued(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
							} else {
								newObj.setEarned(new DecimalFormat("0.##").format((double)0));
								hrAccruelRecord.setAccrued("0");
							}
							newObj.setAlreadyAvailedPatMat("n");
							newObj.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
							newObj.setLastChgTime(time);
							newObj.setStatus("y");
							newObj.setBalanceAdjusted("0");
						}else if(leaveTypeId != 3 && leaveTypeId != 4){
							if(mnthORyear.equalsIgnoreCase("m")) {
									earn = noOfDaysAllowed;
									closingBal = noOfDaysAllowed;
									taken = 0;
							} else if(mnthORyear.equalsIgnoreCase("y")) {
									earn = noOfDaysAllowed/12;
									closingBal = noOfDaysAllowed/12;
									taken = 0;
							}

							HrMasLeaveTypeMediator mediator = new HrMasLeaveTypeMediator();
							mediator.setId(mediatorId);
							newObj.setLeaveType(mediator);
							newObj.setEmp(masEmployee);
							newObj.setOpeningBalance(new DecimalFormat("0.##").format((double)openingBal));
							newObj.setClosingBalance(new DecimalFormat("0.##").format((double)(closingBal)));
							Date today = new Date();
							if((masEmployee.getJoinDate().getYear()== today.getYear()) && (masEmployee.getJoinDate().getMonth()==today.getMonth())) {
								if(joinDate<=15) {
									newObj.setEarned(new DecimalFormat("0.##").format((double)earn));
								} else {
									earn=0;
									newObj.setEarned(new DecimalFormat("0.##").format((double)earn));
								}
							}
							newObj.setAccrued(new DecimalFormat("0.##").format((double)earn));
							newObj.setTaken(new DecimalFormat("0.##").format((double)taken));
							newObj.setTotalLeaveTaken("0");
							newObj.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
							newObj.setLastChgTime(time);
							newObj.setBalanceAdjusted("0");
							newObj.setStatus("y");
						}
						hbt.save(newObj);
						hbt.refresh(newObj);

						hrAccruelRecord.setMonth(String.valueOf(cal.get(Calendar.MONTH)+1));
						hrAccruelRecord.setYear(String.valueOf(cal.get(Calendar.YEAR)));
						hrAccruelRecord.setEmp(newObj.getEmp());
						hrAccruelRecord.setBalance(newObj);
						hrAccruelRecord.setLeaveType(newObj.getLeaveType());
						hbt.save(hrAccruelRecord);
						hbt.refresh(hrAccruelRecord);
				  }
				}
			}
		}
			System.out.println("=========Finished==============");

			tx.commit();
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	  }

	public HrMasLeaveTypeNew getCurrentPolicy(int hrMasLeaveTypeMediatorID) {
		Session session=getSession();
		HrMasLeaveTypeNew hrMasLeaveTypeNew=new HrMasLeaveTypeNew();
		try{ HrMasLeave hrMasLeave;

			HrMasLeaveTypeMediator hrMasLeaveTypeMediator=(HrMasLeaveTypeMediator)	session.load(HrMasLeaveTypeMediator.class, hrMasLeaveTypeMediatorID);
			hrMasLeaveTypeNew=(HrMasLeaveTypeNew)	session.load(HrMasLeaveTypeNew.class, hrMasLeaveTypeMediator.getLeaveType().getId());

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return hrMasLeaveTypeNew;
	}
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		map.put("con",con);
	return map;
	}

	public Map<String, Object> getEmpPersonalDeatil(int uid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users>usersList = new ArrayList<Users>();
		//HrEmployeePersonelDetails hrEmployeePersonelDetails = new HrEmployeePersonelDetails();
		Session session = (Session)getSession();
		///hrEmployeePersonelDetails = (HrEmployeePersonelDetails)session.createCriteria(HrEmployeePersonelDetails.class).add(Restrictions.eq("Id", uid)).uniqueResult();
		usersList = session.createCriteria(Users.class).createAlias("Employee", "emp").add(Restrictions.idEq(uid)).list();
		Date dob = null;
		Date anniversery = null;
		if(usersList.size()>0){
			for(Users users : usersList){
				dob =users.getEmployee().getDateOfBirth();
				anniversery =users.getEmployee().getDateOfMarriage();
				map.put("dob", dob);
				map.put("anniversery", anniversery);
				
			}
		}
		return map ;
	}

	public Map<String, Object> getLeaveListJsp(Map<String, Object> generalMap)
	{

		List<HrMasLeaveTypeMediator> leaveTypeList=new ArrayList<HrMasLeaveTypeMediator>();
		int employeeId = 0;
		String halfday = "";
		if(generalMap.get("employeeId") != null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		if(generalMap.get("halfday") != null){
			halfday = (String)generalMap.get("halfday");
		}
		Session session = (Session)getSession();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		if(halfday.equalsIgnoreCase("n")){
			Criteria crit = session.createCriteria(HrMasLeaveTypeMediator.class);
				crit = crit.createAlias("LeaveType", "lt")
							.add(Restrictions.eq("lt.HalfDayAllow", halfday));
				Order order=Order.asc("lt.LeaveType.Id");
			crit = crit.addOrder(order);
			//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));
			leaveTypeList = crit.list();

		}else{
			leaveTypeList=getMasLeaveTypeMediatorList();
		}

		List<Integer> empDependents = new ArrayList<Integer>();
		empDependents = session.createCriteria(MasEmployeeDependent.class)
								.add(Restrictions.eq("Employee.Id", employeeId))
								.createAlias("Relation", "rel")
								.add(Restrictions.or(
										Restrictions.eq("rel.RelationCode", "03"),
										Restrictions.eq("rel.RelationCode", "04")))
								.setProjection(Projections.projectionList()
										.add(Projections.count("rel.RelationCode")))
								.list();

		List<Object> empPatMatAvailedOrNot = new ArrayList<Object>();
		empPatMatAvailedOrNot = session.createCriteria(HrEmployeeBalanceNew.class)
								.add(Restrictions.eq("Emp.Id", employeeId))
								.createAlias("LeaveType", "med")
								.createAlias("med.LeaveType", "leaveNew")
								.createAlias("leaveNew.LeaveType", "actLeaveType")
								.add(Restrictions.or(
										Restrictions.eq("actLeaveType.Id", 3),
										Restrictions.eq("actLeaveType.Id", 4)))
								.setProjection(Projections.projectionList()
										.add(Projections.property("AlreadyAvailedPatMat"))
										.add(Projections.property("actLeaveType.Id")))
								.addOrder(Order.asc("actLeaveType.Id"))
								.list();


		utilMap.put("empDependents", empDependents);
		utilMap.put("empPatMatAvailedOrNot", empPatMatAvailedOrNot);
		utilMap.put("leaveTypeList",leaveTypeList);

		return utilMap;
	}
	public Map<String, Object> getUserDetails(Map<String, Object> generalMap) {

		Map<String,Object> map = new HashMap<String, Object>();
		int employeeId = 0;

		if(generalMap.get("employeeId") != null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		Session session = (Session)getSession();
		List<Integer> empDependents = new ArrayList<Integer>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		//System.out.println("rel>>>"+employeeId);
		Criteria crit = session.createCriteria(MasEmployeeDependent.class)
								.add(Restrictions.eq("Employee.Id", employeeId))
								.createAlias("Relation", "rel")
								.add(Restrictions.or(
										Restrictions.eq("rel.RelationCode", "03"),
										Restrictions.eq("rel.RelationCode", "04")))
								.setProjection(Projections.projectionList()
										.add(Projections.count("rel.RelationCode")));
		empDependents = crit.list();

		List<Object> empMatAvailedOrNot = new ArrayList<Object>();
		empMatAvailedOrNot = session.createCriteria(HrEmployeeBalanceNew.class)
								.add(Restrictions.eq("Emp.Id", employeeId))
								.createAlias("LeaveType", "med")
								.createAlias("med.LeaveType", "leaveNew")
								.createAlias("leaveNew.LeaveType", "actLeaveType")
								.add(Restrictions.eq("actLeaveType.Id", 3))
								.setProjection(Projections.projectionList()
										.add(Projections.property("AlreadyAvailedPatMat")))
								.list();

		List<Object> empPatAvailedOrNot = new ArrayList<Object>();
		empPatAvailedOrNot = session.createCriteria(HrEmployeeBalanceNew.class)
								.add(Restrictions.eq("Emp.Id", employeeId))
								.createAlias("LeaveType", "med")
								.createAlias("med.LeaveType", "leaveNew")
								.createAlias("leaveNew.LeaveType", "actLeaveType")
								.add(Restrictions.eq("actLeaveType.Id", 4))
								.setProjection(Projections.projectionList()
										.add(Projections.property("AlreadyAvailedPatMat")))
								.list();

		masDepartmentList = session.createCriteria(MasDepartment.class)
								.add(Restrictions.eq("Status", "y").ignoreCase())
								.list();
        MasEmployee employee = (MasEmployee)session.load(MasEmployee.class, employeeId);
        System.out.println("masDepartmentList"+masDepartmentList.size());
		map.put("masDepartmentList", masDepartmentList);
		map.put("empDependents", empDependents);
		map.put("empPatAvailedOrNot", empPatAvailedOrNot);
		map.put("empMatAvailedOrNot", empMatAvailedOrNot);
		map.put("employee", employee);

		return map;
	}
	public Map<String, Object> getPersonalDetailsPatMatDetails(Map<String, Object> generalMap) {

		Map<String,Object> map = new HashMap<String, Object>();
		int employeeId = 0;

		if(generalMap.get("employeeId") != null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		Session session = (Session)getSession();
		List<Integer> empDependents = new ArrayList<Integer>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();

		Criteria crit = session.createCriteria(MasEmployeeDependent.class)
								.add(Restrictions.eq("Employee.Id", employeeId))
								.createAlias("Relation", "rel")
								.add(Restrictions.or(
										Restrictions.eq("rel.RelationCode", "03"),
										Restrictions.eq("rel.RelationCode", "04")))
								.setProjection(Projections.projectionList()
										.add(Projections.count("rel.RelationCode")));

		empDependents = crit.list();

		List<Object> empMatAvailedOrNot = new ArrayList<Object>();
		empMatAvailedOrNot = session.createCriteria(HrEmployeeBalanceNew.class)
								.add(Restrictions.eq("Emp.Id", employeeId))
								.createAlias("LeaveType", "med")
								.createAlias("med.LeaveType", "leaveNew")
								.createAlias("leaveNew.LeaveType", "actLeaveType")
								.add(Restrictions.eq("actLeaveType.Id", 3))
								.setProjection(Projections.projectionList()
										.add(Projections.property("AlreadyAvailedPatMat")))
								.list();

		List<Object> empPatAvailedOrNot = new ArrayList<Object>();
		empPatAvailedOrNot = session.createCriteria(HrEmployeeBalanceNew.class)
								.add(Restrictions.eq("Emp.Id", employeeId))
								.createAlias("LeaveType", "med")
								.createAlias("med.LeaveType", "leaveNew")
								.createAlias("leaveNew.LeaveType", "actLeaveType")
								.add(Restrictions.eq("actLeaveType.Id", 4))
								.setProjection(Projections.projectionList()
										.add(Projections.property("AlreadyAvailedPatMat")))
								.list();

		map.put("empDependents", empDependents);
		map.put("empMatAvailedOrNot", empMatAvailedOrNot);
		map.put("empPatAvailedOrNot", empPatAvailedOrNot);
		return map;
	}

	public Map<String, Object> showEmpForDept(Map<String, Object> generalMap) {

		Map<String,Object> map = new HashMap<String, Object>();
		int departmentId = 0;

		if(generalMap.get("departmentId") != null){
			departmentId = (Integer)generalMap.get("departmentId");
		}
		Session session = (Session)getSession();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		Criteria crit = session.createCriteria(MasEmployee.class)
								.add(Restrictions.eq("Department.Id", departmentId))
								.add(Restrictions.eq("Status", "y").ignoreCase());

		masEmployeeList = crit.list();
		System.out.println("masEmployeeList"+masEmployeeList.size());
		System.out.println("departmentId"+departmentId);
		map.put("masEmployeeList", masEmployeeList);
		return map;
	}
	
	public List getApprovedLeavecancelList(MasEmployee user) {
		List<Object> approvedLeavesCancel=new ArrayList<Object>();
		approvedLeavesCancel=getHibernateTemplate().find("from jkt.hms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id=6 and leave.leaveApprovedBy.Id = "+user.getId()+" order by leave.FromDate desc");
		//approvedLeavesCancel=getHibernateTemplate().find("from jkt.hrms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id=2 and leave.leaveApprovedBy.Id = "+user.getId()+" order by leave.FromDate desc");
		return approvedLeavesCancel;
	}

	@Override
	public void cancelLeaveAfterApprove(Map map1) {
		String fromToDate="";
		String emailMessage="";
		String firstOrSecondHalf = "";
		Session session = (Session)getSession(); 
              String cancel[] = (String[])map1.get("cancel");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Transaction tx = session.beginTransaction();
		//int leaveId = Integer.parseInt(""+map1.get("leaveId"));
		try{
			for (int i = 0; i < cancel.length; i++) {
				//System.out.println("--"+cancel[i]);
				HrLeaveDetails leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, Integer.parseInt(cancel[i]));
				//System.out.println("-2-"+leaveDetails);
			//HrLeaveDetails leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, leaveId);
				int balanceId=leaveDetails.getEmpIdBal().getId();
				double noOfWorkingDays = Float.valueOf(leaveDetails.getNoOfWorkingDays());
				Date currentDate = new Date();
				int appliedFromDateMonth = leaveDetails.getFromDate().getMonth();
				int currentMonth = currentDate.getMonth();
				//changes
				HrMasLeaveStatus leaveStatus =new HrMasLeaveStatus();
				int statusId=0;
				if((leaveDetails!=null) && (leaveDetails.getLeaveStatus().getId()==6)){
					statusId=leaveDetails.getLeaveStatus().getId();
					leaveStatus.setId(5);
				}else{
					leaveStatus.setId(5);
				}
				leaveDetails.setLeaveStatus(leaveStatus);
				//leaveDetails.setSuggestion(remarks);


				//leaveDetails.setApprovedOn(currentDate);
				hbt.update(leaveDetails);
				hbt.refresh(leaveDetails);
				/*if(leaveDetails.getLeaveType().getId() == 10){ // for compOff
				
				List<HrAttendanceLoader> attendList =session.createCriteria(HrAttendanceLoader.class).createAlias("Employee", "me").
				add(Restrictions.eq("me.Id", leaveDetails.getEmpId().getId())).add(Restrictions.eq("Date", leaveDetails.getAppliedOn())).list();
				HrAttendanceLoader attendance = (HrAttendanceLoader)hbt.load(HrAttendanceLoader.class, attendList.get(0).getId());		
				attendance.setStatus("");	
				hbt.update(attendance);
				hbt.refresh(attendance);
				}*/
				
				saveLeaveHistory(leaveDetails);
				//System.out.println("balanceId>>>>"+balanceId);
				HrEmployeeBalanceNew leaveBal=(HrEmployeeBalanceNew)getHibernateTemplate().load(HrEmployeeBalanceNew.class,balanceId);
				String noOfWorkingDaysToSave="";
			/*	if(statusId==7){
					double takenAlready = Float.valueOf(leaveBal.getTaken());
					double takenTotal = takenAlready - noOfWorkingDays;
					String taken =new DecimalFormat("0.##").format((double)takenTotal);

					double closingBal = Float.valueOf(leaveBal.getClosingBalance());
					double closingBalYearly = Float.valueOf(leaveBal.getClosingBalanceYearly());

					double takenTotalYearly = Float.valueOf(leaveBal.getTotalLeaveTaken()) - noOfWorkingDays;
					String takenTotalYearlyStr =new DecimalFormat("0.##").format((double)takenTotalYearly);

					noOfWorkingDaysToSave = new DecimalFormat("0.##").format((double)noOfWorkingDays);
					if(leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(4)
							|| leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(3)){
						leaveBal.setAlreadyAvailedPatMat("n");
					}
					double closingBalAfterAprov = closingBal + noOfWorkingDays;
					double closingBalYearlyAfterAprov = closingBalYearly + noOfWorkingDays;

					//Effect short leave Balance only for current Month
					if(leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(20)){
						if(appliedFromDateMonth == currentMonth){
							leaveBal.setClosingBalance( new DecimalFormat("0.##").format((double)closingBalAfterAprov));
							leaveBal.setTaken(taken);
						}
					}else{
						leaveBal.setClosingBalance( new DecimalFormat("0.##").format((double)closingBalAfterAprov));
						leaveBal.setTaken(taken);
					}

					leaveBal.setClosingBalanceYearly( new DecimalFormat("0.##").format((double)closingBalYearlyAfterAprov));

					leaveBal.setTotalLeaveTaken(takenTotalYearlyStr);
				}else{*/
					if(leaveDetails.getFromDate().getYear()== (new Date()).getYear()){
					String taken = "";
					double closingBalAfterCancel = 0;
					if(leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(20)){
						noOfWorkingDays = 1;
					}
					if(leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(4)
							|| leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(3)){
						leaveBal.setAlreadyAvailedPatMat("y");
					}
					double takenAlready = Float.valueOf(leaveBal.getTaken());
					//System.out.println(takenAlready+"    "+noOfWorkingDays);
					double takenTotal = takenAlready - noOfWorkingDays;
					//System.out.println(takenTotal+"  takenTotal  ");
					taken =new DecimalFormat("0.##").format((double)takenTotal);
					double closingBal = Float.valueOf(leaveBal.getClosingBalance());

					closingBalAfterCancel=closingBal + noOfWorkingDays;

					//System.out.println("closingBalAftercancel==8888="+closingBalAfterCancel);

					//Effect short leave Balance only for current Month
					if(leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(20)){
						if(appliedFromDateMonth == currentMonth){
							leaveBal.setClosingBalance( new DecimalFormat("0.##").format((double)closingBalAfterCancel));
							leaveBal.setTaken(taken);
						}
					} else {
						
						leaveBal.setClosingBalance( new DecimalFormat("0.##").format((double)closingBalAfterCancel));
						
						leaveBal.setTaken(taken);
					}

					// total taken yearly
					double takenTotalYearly = Float.valueOf(leaveBal.getTotalLeaveTaken()) - noOfWorkingDays;
					String takenTotalYearlyStr =new DecimalFormat("0.##").format((double)takenTotalYearly);
					double closingBalYearly = Float.valueOf(leaveBal.getClosingBalanceYearly());

					double closingBalYearlyAfterCancel = closingBalYearly + noOfWorkingDays;
					
					leaveBal.setClosingBalanceYearly( new DecimalFormat("0.##").format((double)closingBalYearlyAfterCancel));
					noOfWorkingDaysToSave = new DecimalFormat("0.##").format((double)noOfWorkingDays);
					leaveBal.setTotalLeaveTaken(takenTotalYearlyStr);
					
					
					
					
					/*// added by javed khan for cancel birthday and anniversary leave and Add to PL 
					
					if(leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(5) || leaveBal.getLeaveType().getLeaveType().getLeaveType().getId().equals(6) ){
						
						System.out.println(leaveDetails.getEmpId().getId());
						int balanceId1= (Integer) session.createSQLQuery("select id from hr_employee_balance_new where emp_id="+leaveDetails.getEmpId().getId()+" and leave_type=3").uniqueResult();
						
						// System.out.println(leaveBal1.size()+"leaveBal1.getId() ");
						 
						HrEmployeeBalanceNew leaveBal2=(HrEmployeeBalanceNew)getHibernateTemplate().load(HrEmployeeBalanceNew.class,balanceId1);
						 double takenAlready1 = Float.valueOf(leaveBal2.getTaken());
							double takenTotal1 = takenAlready1 - noOfWorkingDays;
							String taken1 =new DecimalFormat("0.##").format((double)takenTotal1);
							double closingBal1 = Float.valueOf(leaveBal2.getClosingBalance());

							closingBalAfterCancel = closingBal1 + noOfWorkingDays;
							leaveBal2.setClosingBalance( new DecimalFormat("0.##").format((double)closingBalAfterCancel));
							leaveBal2.setTaken(taken);


							
							
							// total taken yearly
							double takenTotalYearly1 = Float.valueOf(leaveBal2.getTotalLeaveTaken()) - noOfWorkingDays;
							String takenTotalYearlyStr1 =new DecimalFormat("0.##").format((double)takenTotalYearly1);
							double closingBalYearly1 = Float.valueOf(leaveBal2.getClosingBalanceYearly());

							double closingBalYearlyAfterAprov1 = closingBalYearly + noOfWorkingDays;
							leaveBal2.setClosingBalanceYearly( new DecimalFormat("0.##").format((double)closingBalYearlyAfterAprov1));

							noOfWorkingDaysToSave = new DecimalFormat("0.##").format((double)noOfWorkingDays);
							leaveBal2.setTotalLeaveTaken(takenTotalYearlyStr1);
							
							hbt.update(leaveBal2);
							hbt.refresh(leaveBal2);
						 
					}*/
					
					
					
					}
				//}
				hbt.update(leaveBal);
				hbt.refresh(leaveBal);		
				
				
				
				saveEmployeeLeaveBalanceNewHistory(leaveBal, noOfWorkingDaysToSave, "n");

///////////////////////////////////
				//leaveDetails = (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class, Integer.parseInt(approve[i]));

				String leaveAppliedBy = leaveDetails.getEmpId().getFirstName() + " " + leaveDetails.getEmpId().getLastName();
				String leaveType = leaveDetails.getLeaveType().getLeaveType().getLeaveType().getDescription();

				String subject = "Leave Application/" + leaveType
				   + "/" + leaveAppliedBy
				   + "/" + LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getApprovedOn())
				   + "/" + leaveDetails.getLeaveStatus().getStatusDesc();

				//Subject: Leave Application/Leave type/Emp. Name/Action Date/ Leave Application Status

				//Dear (Title)(First and Last Name)

				//Your Leave application dated:(Date) for (Leave Type) has been (Status).
				//Kindly see the updated leave status by logging into your OMEGA account or by clicking on the link mentioned below.
				//http://www.omega.clinirx.com

///////////////////////////////////////////////////////////////////
				emailMessage = "Dear " + leaveDetails.getEmpId().getTitle().getTitleName()
				                + " " + leaveAppliedBy
				                + ",\n\n";
				if(statusId == 6){
					emailMessage = emailMessage + "Your request for cancellation";
					//+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn());
				}else{
					emailMessage = emailMessage + "Your Leave application dated:"
					+ LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn());
				}

				if(leaveDetails.getHalfDay() != null && !leaveDetails.getHalfDay().equals("")) {
					if(leaveDetails.getHalfDay().equalsIgnoreCase("f")){
						firstOrSecondHalf = "first half";
					}else if(leaveDetails.getHalfDay().equalsIgnoreCase("s")){
						firstOrSecondHalf = "second half";
					}
					fromToDate=" for a half day " + leaveType + " for " + firstOrSecondHalf;
				} else if (leaveDetails.getShortLeaveHalfDay() != null){
					if(leaveDetails.getShortLeaveHalfDay().equalsIgnoreCase("f")){
						firstOrSecondHalf = "first half";
					}else if(leaveDetails.getShortLeaveHalfDay().equalsIgnoreCase("s")){
						firstOrSecondHalf = "second half";
					}
					fromToDate=" for a " + leaveType + " for " + firstOrSecondHalf;
				} else {
					fromToDate=" for " + leaveType;
				}
			 
				
					emailMessage = emailMessage + fromToDate +
					" has been " + leaveDetails.getLeaveStatus().getStatusDesc()
						+ ".\n";
				
				/*emailMessage = emailMessage + "Kindly see the updated leave status by logging into your OMEGA account " +
		                  		"or by clicking on the link mentioned below.\n" +
		                  		
		                  		"This is an auto generated mail through OMEGA. Do not reply.";*/

				List<String> recipientAddresses = new ArrayList<String>();
				String senderAddresses = new String();
				List<String> ccAddresses = new ArrayList<String>();
				List<String> bccAddresses = new ArrayList<String>();

				if(leaveDetails.getLeaveApprovedBy().getEmail() != null  && !leaveDetails.getLeaveApprovedBy().getEmail().equals("")
						&& leaveDetails.getEmpId().getEmail() != null && !leaveDetails.getEmpId().getEmail().equals("")){
					recipientAddresses.add(leaveDetails.getEmpId().getEmail());
					senderAddresses = new String(leaveDetails.getLeaveApprovedBy().getEmail());

					ccAddresses.add(leaveDetails.getLeaveApprovedBy().getEmail());
					 //ccAddresses.add("hrhelpdesk@clinirx.com");

					LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
							ccAddresses , bccAddresses ,emailMessage, subject);

				}
			}
			tx.commit();
		} catch(Exception exception){
			tx.rollback();
			exception.printStackTrace();
		}
	
	}

	@Override
	public Map<String, Object> getEncashment(Map<String, Object> dataMap) {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		Calendar currentDate=new GregorianCalendar();
		
		int empId = Integer.parseInt(""+dataMap.get("employeeId"));
		
		int currentYear=currentDate.get(Calendar.YEAR);
		
		System.out.println(" currentYear "+currentYear);
		
		List<HrEncashmentDetails> hrEncashmentDetails = new ArrayList<HrEncashmentDetails>();
		
		hrEncashmentDetails = session.createCriteria(HrEncashmentDetails.class).add(Restrictions.eq("EncashYear", ""+currentYear))
						.createAlias("Emp", "Emp").add(Restrictions.eq("Emp.Id", empId))
						.createAlias("LeaveStatus", "LeaveStatus").add(Restrictions.or(Restrictions.eq("LeaveStatus.Id", 2), Restrictions.eq("LeaveStatus.Id", 3)))
						.list();
		
		
		
		
		map.put("hrEncashmentDetails",hrEncashmentDetails);
	
		return map;
	}

}