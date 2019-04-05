package jkt.hms.leave.controller;

/*import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.*; */

import static jkt.hms.util.RequestConstants.ALLOWED_DAYS;
import static jkt.hms.util.RequestConstants.APPLY_LEAVES_JSP;
import static jkt.hms.util.RequestConstants.APPLY_SHORT_LEAVES_JSP;
import static jkt.hms.util.RequestConstants.APPROVED_BY;
import static jkt.hms.util.RequestConstants.APPROVED_BY_OTHER;
import static jkt.hms.util.RequestConstants.APPROVED_LEAVES_JSP;
import static jkt.hms.util.RequestConstants.CARRY_FORWARD;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CONTACT_ADDRESS;
import static jkt.hms.util.RequestConstants.CONTACT_DETAILS_JSP;
import static jkt.hms.util.RequestConstants.CONTACT_PHONE;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DISAPPROVED_LEAVES_JSP;
import static jkt.hms.util.RequestConstants.EMAIL;
import static jkt.hms.util.RequestConstants.EMP_NAME;
import static jkt.hms.util.RequestConstants.ENCASHMENT_LEAVE_FORM;
import static jkt.hms.util.RequestConstants.ENCHASHMENT;
import static jkt.hms.util.RequestConstants.ENCHASHMENT_CHECK;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HALF_DAY;
import static jkt.hms.util.RequestConstants.HR_EMP_ACC_DEPART;
import static jkt.hms.util.RequestConstants.HR_MESSAGE_JSP;
import static jkt.hms.util.RequestConstants.JOINING_DATE;
import static jkt.hms.util.RequestConstants.LEAVE_BALANCE;
import static jkt.hms.util.RequestConstants.LEAVE_DETAILS_HISTORY_JSP;
import static jkt.hms.util.RequestConstants.LEAVE_DETAILS_JSP;
import static jkt.hms.util.RequestConstants.LEAVE_STATUS;
import static jkt.hms.util.RequestConstants.LEAVE_STATUS_JSP;
import static jkt.hms.util.RequestConstants.LEAVE_TO_ENCASH;
import static jkt.hms.util.RequestConstants.LEAVE_TYPE;
import static jkt.hms.util.RequestConstants.LEAVE_TYPE_ID;
import static jkt.hms.util.RequestConstants.MANAGER_TYPE;
import static jkt.hms.util.RequestConstants.MONTHLY_OR_YEARLY;
import static jkt.hms.util.RequestConstants.MY_DETAILS_JSP;
import static jkt.hms.util.RequestConstants.NO_OF_WORKING_DAYS;
import static jkt.hms.util.RequestConstants.OLD_LEAVE_BALANCE;
import static jkt.hms.util.RequestConstants.REASON;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.SEARCH_LEAVE_BALANCE_JSP;
import static jkt.hms.util.RequestConstants.SHORT_LEAVE_HALF_DAY;
import static jkt.hms.util.RequestConstants.SHOW_LEAVE_BALANCE_JSP;
import static jkt.hms.util.RequestConstants.SHOW_LEAVE_TYPE_MASTER_JSP;
import static jkt.hms.util.RequestConstants.TEAM_DETAILS_JSP;
import static jkt.hms.util.RequestConstants.TITLE;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TYPE;
import static jkt.hms.util.RequestConstants.USERS;
import static jkt.hms.util.RequestConstants.WAITING_LEAVES_ENCASHMENT_JSP;
import static jkt.hms.util.RequestConstants.WAITING_LEAVES_FOR_HR_JSP;
import static jkt.hms.util.RequestConstants.WAITING_LEAVES_JSP;

import java.io.IOException;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.leave.handler.LeaveDetailsHandlerService;
import jkt.hms.masters.business.HrEmployeeBalance;
import jkt.hms.masters.business.HrEmployeeBalanceNew;
import jkt.hms.masters.business.HrEncashmentDetails;
import jkt.hms.masters.business.HrLeaveDetails;
import jkt.hms.masters.business.HrMasLeave;
import jkt.hms.masters.business.HrMasLeaveStatus;
import jkt.hms.masters.business.HrMasLeaveTypeMediator;
import jkt.hms.masters.business.HrMasLeaveTypeNew;
import jkt.hms.masters.business.HrUpdateLeaveBalanceHistory;
import jkt.hms.masters.business.UserManager;
import jkt.hms.util.LeaveManagementUtil;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.Users;
import jkt.security.masters.handler.UserMasterHandlerService;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class LeaveController extends MultiActionController
{

	private LeaveDetailsHandlerService leaveHandlerService = null;
	private UserMasterHandlerService userMasterHandlerService = null;


	public String s = "";
	HttpSession session=null;

	@SuppressWarnings("unchecked")
	public ModelAndView showLeaveApplicationJsp(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		
		List listOfLeaveApprovingAuthorities=null;
		List listOfTypesOfLeaves=null;
		List listOfTypesOfLeavesMedType=null;
		List listOfRestrictedHolidays=null;
		List listOfManagers=null;
		List listOfHolidays=null;
		List listOfRhAvailed=null;
		List birthdayLeaveList = null;
		List anniversaryLeaveList = null;
		List paternityLeaveList = null;
		List encashmentLeaveWaiting=null;
		//
		//HrEmployeeBalance leaveBalance=null;
		
		List<HrEmployeeBalanceNew> leaveBalance = null;
		
		
		List<MasEmployee> userList = null;
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> mapForDs=new HashMap<String,Object>();
		
		//session = request.getSession();
		Users user=(Users)session.getAttribute("users");
		MasEmployee employee= user.getEmployee();
		mapForDs.put("employeeId", employee.getId());
		List manager=leaveHandlerService.getManager(employee.getId());
	
		
		//changes
		//listOfTypesOfLeaves=leaveHandlerService.getLeaveTypeList();
		//listOfTypesOfLeaves = leaveHandlerService.getMasLeaveTypeNewList();
		//listOfManagers = leaveHandlerService.getManagers();
		//userList = userMasterHandlerService.getEmployeeList();
		//listOfLeaveApprovingAuthorities = userMasterHandlerService.getEmployeeList();
		
		listOfTypesOfLeaves=leaveHandlerService.getLeaveTypeList();
		listOfTypesOfLeavesMedType = leaveHandlerService.getMasLeaveTypeMediatorList(); 
		listOfRestrictedHolidays =leaveHandlerService.getRestrictedHolidays();
		listOfHolidays=leaveHandlerService.getHolidays();
		
		
		listOfRhAvailed=leaveHandlerService.getRhAvailed(employee);
		birthdayLeaveList = leaveHandlerService.getBirthdayLeave(employee.getId());
		anniversaryLeaveList = leaveHandlerService.getAnniversaryLeave(employee.getId());
		paternityLeaveList = leaveHandlerService.getPaternityLeave(employee.getId());
		
		leaveBalance = leaveHandlerService.getLeaveBalance(employee.getId());
		//encashmentLeaveWaiting = leaveHandlerService.getWaitingEncashmentLeave(employee);
		
		map = leaveHandlerService.getUserDetails(mapForDs);
		
		map.put("listOfLeaveApprovingAuthorities",listOfLeaveApprovingAuthorities);
		map.put("listOfTypesOfLeaves",listOfTypesOfLeaves);
		map.put("listOfTypesOfLeavesMedType",listOfTypesOfLeavesMedType);
		map.put("manager",manager);
		map.put("bday",new Date());
		map.put("anniversary", new Date());
		map.put("listOfManagers", listOfManagers);
		map.put("listOfRestrictedHolidays",listOfRestrictedHolidays);
		map.put("listOfHolidays", listOfHolidays);
		map.put("listOfRhAvailed", listOfRhAvailed);
		map.put("birthdayLeaveList", birthdayLeaveList);
		map.put("anniversaryLeaveList", anniversaryLeaveList);
		map.put("paternityLeaveList", paternityLeaveList);
		map.put("leaveBalance", leaveBalance);
		map.put("encashmentLeaveWaiting", encashmentLeaveWaiting);
		map.put("userList", userList);
		
		
		String jsp = APPLY_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index","map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showShortLeaveApplicationForm(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);

		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		
		List listOfLeaveApprovingAuthorities=null;
		List listOfTypesOfLeaves=null;
		List listOfRestrictedHolidays=null;
		List listOfManagers=null;
		List listOfHolidays=null;
		List listOfRhAvailed=null;
		List birthdayLeaveList = null;
		List anniversaryLeaveList = null;
		List paternityLeaveList = null;
		List encashmentLeaveWaiting=null;
		//
		//HrEmployeeBalance leaveBalance=null;
		
		List<HrEmployeeBalanceNew> leaveBalance = null;
		
		
		List<MasEmployee> userList = null;
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> mapForDs=new HashMap<String,Object>();
		
		//session = request.getSession();
		
		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		
		List manager=leaveHandlerService.getManager(employee.getId());
		//userList = userMasterHandlerService.getEmployeeList();
		
		//listOfLeaveApprovingAuthorities = userMasterHandlerService.getEmployeeList();
		
		//changes
		//listOfTypesOfLeaves=leaveHandlerService.getLeaveTypeList();
		//listOfTypesOfLeaves = leaveHandlerService.getMasLeaveTypeNewList();
		//listOfTypesOfLeaves = leaveHandlerService.getMasLeaveTypeMediatorList();
		
		//listOfRestrictedHolidays =leaveHandlerService.getRestrictedHolidays();
		
		//listOfHolidays=leaveHandlerService.getHolidays();
		
		//listOfManagers = leaveHandlerService.getManagers();
		//listOfRhAvailed=leaveHandlerService.getRhAvailed(employee);
		//birthdayLeaveList = leaveHandlerService.getBirthdayLeave(employee.getId());
		//anniversaryLeaveList = leaveHandlerService.getAnniversaryLeave(employee.getId());
		//paternityLeaveList = leaveHandlerService.getPaternityLeave(employee.getId());
		
		leaveBalance = leaveHandlerService.getLeaveBalance(employee.getId());
		//encashmentLeaveWaiting = leaveHandlerService.getWaitingEncashmentLeave(employee);
		
		map = leaveHandlerService.getUserDetails(mapForDs);
		
		map.put("listOfLeaveApprovingAuthorities",listOfLeaveApprovingAuthorities);
		map.put("listOfTypesOfLeaves",listOfTypesOfLeaves);
		map.put("manager",manager);
		map.put("bday",new Date());
		map.put("anniversary", new Date());
		map.put("listOfManagers", listOfManagers);
		map.put("listOfRestrictedHolidays",listOfRestrictedHolidays);
		map.put("listOfHolidays", listOfHolidays);
		map.put("listOfRhAvailed", listOfRhAvailed);
		map.put("birthdayLeaveList", birthdayLeaveList);
		map.put("anniversaryLeaveList", anniversaryLeaveList);
		map.put("paternityLeaveList", paternityLeaveList);
		map.put("leaveBalance", leaveBalance);
		map.put("encashmentLeaveWaiting", encashmentLeaveWaiting);
		map.put("userList", userList);
		
		//map.put(MAIN,APPLY_LEAVES_JSP);
		//System.out.println("checking pace ..........");
		String jsp = APPLY_SHORT_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		//map.put(TITLE,"Apply Leave" );
		return new ModelAndView("index","map",map);
	}

	public ModelAndView getNoOfWorkingDays(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> generalMap = new HashMap<String, Object>();
		//System.out.println("in get no of working days");
		
		HttpSession session = request.getSession(false);
		if ( session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Date fromDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter("fromDate"));
		Date toDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter("toDate"));
		List listOfHolidays=null;
		listOfHolidays=leaveHandlerService.getHolidays();
		session=request.getSession(true);
		Users user=(Users)session.getAttribute(USERS);
		generalMap= leaveHandlerService.getEmpPersonalDeatil(user.getId());
		//changes
		 Date dobFromDB = null;
		if(generalMap.get("dob")!= null){
			 dobFromDB =(Date)generalMap.get("dob");
		}
		//Date dobFromDB=psDetail.getDateOfBirth();
		//Date dobFromDB=new Date();
		//System.out.println("dobFromDB==== "+dobFromDB);
		//changes
		//Date anniversary = psDetail.getMarriageDate();
		Date anniversary =null;
		if(generalMap.get("anniversery")!= null){
			anniversary =(Date)generalMap.get("anniversery");
		}
		Map<String,String> dayswithoutDobMap=LeaveManagementUtil.getNumberOfDaysWithoutDateOfBirthOrHolidays(fromDate,toDate,dobFromDB,listOfHolidays,anniversary);
		String noOfWorkingDays = dayswithoutDobMap.get("days");
		String  holidayFlag = dayswithoutDobMap.get("holidayFlag");
		String typeFlag=dayswithoutDobMap.get("typeFlag");
		
		
        StringBuffer responseString = new StringBuffer();
        if(noOfWorkingDays != null){
        	responseString.append(noOfWorkingDays);
        }
        if(holidayFlag != null){
        	responseString.append("$"+holidayFlag+"$");
        }
        if(typeFlag != null){
        	responseString.append(typeFlag);
        }
		try{
			response.getWriter().write(responseString.toString());

		}
		catch(Exception e){}
		return null;
	}

	public ModelAndView submitLeaveForm(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mav=null;

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = false;
		if(session.getAttribute("save") != null){
			flag = true;
		}
		if(flag){
			Users emp =(Users)session.getAttribute(USERS);
			MasEmployee user=emp.getEmployee();
			HrLeaveDetails leave=new HrLeaveDetails();
			Date currentDate = new Date();
			Date jspFromDate = new Date();
			Date jspToDate = new Date();
			Date prevAppFromDate = new Date();
			Date prevAppToDate = new Date();
			Boolean againSameLeaveRecord=false;
			List<HrLeaveDetails> optionalleaveList=new ArrayList<HrLeaveDetails>();
			if(request.getParameter(FROM_DATE)!=null && !(request.getParameter(TO_DATE).equals(""))){
				jspFromDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
				jspToDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
				leave.setFromDate(jspFromDate);
				leave.setToDate(jspToDate);
			} else if(request.getParameter(FROM_DATE)!=null && (request.getParameter(TO_DATE).equals(""))) {
				jspFromDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
				jspToDate=jspFromDate;
				leave.setFromDate(jspFromDate);
				leave.setToDate(jspToDate);
			}
/*			int leaveId=0;
			if(request.getParameter("leaveIdForDatabase")!=null&&!request.getParameter("leaveIdForDatabase").equals("")){
				leaveId = Integer.parseInt(request.getParameter("leaveIdForDatabase"));
			}*/

		List<HrLeaveDetails> leaveList=leaveHandlerService.getLeavesList(user.getId());
		if(request.getParameter(FROM_DATE)!=null && !"".equals(request.getParameter(FROM_DATE))){
			for (HrLeaveDetails leaveRecord : leaveList) {
				if(leaveRecord.getFromDate()!=null)
					if((leaveRecord.getLeaveStatus().getId()==3 || leaveRecord.getLeaveStatus().getId()==2)){
							if(jspFromDate.compareTo(leaveRecord.getFromDate())>= 0 && jspFromDate.compareTo(leaveRecord.getToDate())<= 0)
							{	
								prevAppFromDate = leaveRecord.getFromDate();
								prevAppToDate = leaveRecord.getToDate();
								
								againSameLeaveRecord=true;
							
							}else 	if(jspToDate.compareTo(leaveRecord.getFromDate())>= 0 && jspToDate.compareTo(leaveRecord.getToDate())<= 0)
							{	
									prevAppFromDate = leaveRecord.getFromDate();
									prevAppToDate = leaveRecord.getToDate();
									againSameLeaveRecord=true;
							}else if(jspFromDate.compareTo(leaveRecord.getFromDate())<= 0 && jspToDate.compareTo(leaveRecord.getFromDate())>= 0) {
								
								prevAppFromDate = leaveRecord.getFromDate();
								prevAppToDate = leaveRecord.getToDate();
								againSameLeaveRecord=true;
							
							
						}else if(jspFromDate.compareTo(leaveRecord.getToDate())<= 0 && jspToDate.compareTo(leaveRecord.getToDate())>= 0) {
							
							prevAppFromDate = leaveRecord.getFromDate();
							prevAppToDate = leaveRecord.getToDate();
							againSameLeaveRecord=true;
					
						
					}
						}
				}
			}
			//Date displayDate=DateFormat.getDateInstance(DateFormat.SHORT).format(currentDate);
			if(!againSameLeaveRecord){
				leave.setAppliedOn(currentDate);
				//changes
				//leave.setEmpid(user.getId());
				MasEmployee masEmployee =new MasEmployee();
				masEmployee.setId(user.getId());
				leave.setEmpId(masEmployee);

				leave.setNoOfWorkingDays(request.getParameter(NO_OF_WORKING_DAYS));
				
				int leaveTypeId= 0;
				if(request.getParameter(TYPE)!=null && !(request.getParameter(TYPE).isEmpty())){
				leaveTypeId = Integer.parseInt(request.getParameter(TYPE));
				
				HrMasLeave mlLeave = new HrMasLeave();
				mlLeave.setId(leaveTypeId);
				
				HrMasLeaveTypeNew hmltn = new HrMasLeaveTypeNew();
				hmltn.setLeaveType(mlLeave);
				
				HrMasLeaveTypeMediator hmltm = new HrMasLeaveTypeMediator();
				hmltm.setLeaveType(hmltn);
				leave.setLeaveType(hmltm);
				}
				
				//changes
				String managerType = "";
				if(request.getParameter(MANAGER_TYPE)!=null) {
					 managerType = request.getParameter(MANAGER_TYPE);
				}
				int approvedById = 0;
				if(managerType.equalsIgnoreCase("m")){
					approvedById = Integer.parseInt(request.getParameter(APPROVED_BY));
				}else if(managerType.equalsIgnoreCase("o")){
					approvedById = Integer.parseInt(request.getParameter(APPROVED_BY_OTHER));
				}
				
				MasEmployee approvedBy =new MasEmployee();
				approvedBy.setId(approvedById);
				leave.setLeaveApprovedBy(approvedBy);

				//code added by shailesh
				if(request.getParameter("hrMasLeaveTypeNewId") != null && (!request.getParameter("hrMasLeaveTypeNewId").equals(""))){
					int hrMasLeaveTypeNewId=Integer.parseInt(request.getParameter("hrMasLeaveTypeNewId"));
					HrMasLeaveTypeNew hrMasLeaveTypeNew=new HrMasLeaveTypeNew(hrMasLeaveTypeNewId);
					leave.setHrMasLeaveTypeNew(hrMasLeaveTypeNew);
				}
				if(request.getParameter("leaveIdForDatabase")!=null  && !request.getParameter("leaveIdForDatabase").equals("")){
					HrMasLeaveTypeMediator leaveType =new HrMasLeaveTypeMediator();
					leaveType.setId(Integer.parseInt(request.getParameter("leaveIdForDatabase")));
					leave.setLeaveType(leaveType);
				}
				if(request.getParameter(CONTACT_ADDRESS)!=null && !request.getParameter(CONTACT_ADDRESS).equals("")){
					leave.setContactAddress(request.getParameter(CONTACT_ADDRESS));
				}
				if(request.getParameter("typeFlagForJoiningDate")!=null 
						&& request.getParameter("typeFlagForJoiningDate").equalsIgnoreCase("shortLeave")){
					leave.setJoiningDate(jspFromDate);
					leave.setShortLeaveHalfDay(request.getParameter(SHORT_LEAVE_HALF_DAY));
				} else {
					System.out.println("request.getParameter(JOINING_DATE)"+request.getParameter(JOINING_DATE));
					leave.setJoiningDate(HMSUtil.dateFormatterDDMMYYYY(request.getParameter(JOINING_DATE)));
				}
				
				leave.setReason(request.getParameter(REASON));
				leave.setContactPhone(request.getParameter(CONTACT_PHONE));
				leave.setModifiedBy(user.getId()); 
				leave.setModifiedOn(currentDate);
				
				HrMasLeaveStatus leaveStatus =new HrMasLeaveStatus();
				leaveStatus.setId(3);
				leave.setLeaveStatus(leaveStatus);
	
				if(request.getParameter("balanceIdForDatabase")!=null  && !request.getParameter("balanceIdForDatabase").equals("")){
					HrEmployeeBalanceNew hrUserLeavebalance =new HrEmployeeBalanceNew();
					hrUserLeavebalance.setId(Integer.parseInt(request.getParameter("balanceIdForDatabase")));
					leave.setEmpIdBal(hrUserLeavebalance);
				}
				if(request.getParameter("checkbox")!=null 
						&& request.getParameter("checkbox").equals("half day")
						&& request.getParameter(HALF_DAY)!=null){
						leave.setHalfDay(request.getParameter(HALF_DAY));
				}
				if(request.getParameter(EMAIL)!=null){
					leave.setAlternateEmailId(request.getParameter(EMAIL));
				}
				optionalleaveList.add(leave);
				/*if((request.getParameter("typeFlag")!=null) && !(request.getParameter("typeFlag").equals(""))){
					HrLeaveDetails optionalLeave=new HrLeaveDetails();
					optionalLeave.setFromDate(jspFromDate);
					optionalLeave.setToDate(jspToDate);
					optionalLeave.setAppliedOn(currentDate);
					
					//MasEmployee masEmployee1 =new MasEmployee();
					//masEmployee1.setId(user.getId());
					optionalLeave.setEmpId(masEmployee);

					//optionalLeave.setEmpid(user.getId());
					
					optionalLeave.setNoOfWorkingDays(request.getParameter(NO_OF_WORKING_DAYS));
					
					//changes
					optionalLeave.setLeaveApprovedBy(approvedBy);
					
					if(request.getParameter("typeFlag").equals("dob"))
					{
						HrMasLeaveTypeMediator leaveTypeDOB =new HrMasLeaveTypeMediator();
							leaveTypeDOB.setId(Integer.parseInt(request.getParameter("leaveId")));
						optionalLeave.setLeaveType(leaveTypeDOB);

						//optionalLeave.setType(5);
					}
					else if(request.getParameter("typeFlag").equals("anvsy")) 
					{
						
						HrMasLeaveTypeMediator leaveTypeAnvsy =new HrMasLeaveTypeMediator();
						leaveTypeAnvsy.setId(Integer.parseInt(request.getParameter("leaveId")));				
						//changes
						//HrMasLeave leaveTypeAnvsy =new HrMasLeave();
						//leaveTypeAnvsy.setId(6);
						optionalLeave.setLeaveType(leaveTypeAnvsy);

						//optionalLeave.setType(6);	
					}
					optionalLeave.setJoiningDate(HMSUtil.dateFormatterDDMMYYYY(request.getParameter(JOINING_DATE)));
					optionalLeave.setReason(request.getParameter(REASON));
					if(request.getParameter(CONTACT_ADDRESS)!=null)
					{
						optionalLeave.setContactAddress(request.getParameter(CONTACT_ADDRESS));
					}
					optionalLeave.setContactPhone(request.getParameter(CONTACT_PHONE));
					optionalLeave.setModifiedBy(user.getId()); 
					optionalLeave.setModifiedOn(currentDate);
					
					//changes
					optionalLeave.setLeaveStatus(leaveStatus);
					
					optionalLeave.setEmpIdBal(hrUserLeavebalance);
		
					if(request.getParameter(HALF_DAY)!=null)
					{
						optionalLeave.setHalfDay(request.getParameter(HALF_DAY));
					}
					if(request.getParameter(EMAIL)!=null)
					{
						optionalLeave.setAlternateEmailId(request.getParameter(EMAIL));
					}
					optionalleaveList.add(optionalLeave);
				} */

				//leaveHandlerService.submitLeaveForm(leave,user.getId(),user.getEmailId());
				leaveHandlerService.submitLeaveForm(optionalleaveList,user.getId(),user.getEmail());


				String message[]={"You have successfully applied for the leave.",
						"javascript:history.back()"
						//"/jktintranet/jkt/login?method=showPage&jspPage=home"
				};
				map.put("message",message);
			} else {
				//System.out.println("again same record ");
				String	message[]={"You have already applied for leave from "+LeaveManagementUtil.convertDateToStringWithoutTime(prevAppFromDate)+" to "+LeaveManagementUtil.convertDateToStringWithoutTime(prevAppToDate)+" Please apply again !",
						"javascript:history.back()"
						//"/jktintranet/jkt/login?method=showPage&jspPage=home"
				};
				map.put("message",message);
			}
			
			//changes
			//map.put(MAIN, "message.jsp");
			//map.put(TITLE,"Leave Application");
			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
		
			mav=new ModelAndView("index","map",map);
			session.setAttribute("save", null);
			return mav;
		}else{

			String message[]={"You have already applied for the leave. Go to Apply Leave option to apply again",
					"leave?method=showLeaveApplicationJsp"
					//chnages
					//"/jktintranet/jkt/login?method=showPage&jspPage=home"
			};
			
			//changes
			map.put("message",message);
		//	map.put(MAIN, "message.jsp");
		//	map.put(TITLE,"Leave Application");
			
			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
		
			mav=new ModelAndView("index","map",map);
			return mav;
		}
	}

	public ModelAndView showLeaveStatus(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object> map=new HashMap<String,Object>();
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		//changes
		//map.put(MAIN,LEAVE_STATUS_JSP);
		//map.put(TITLE ,"Leave Status");

		String jsp = LEAVE_STATUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index","map",map);
	}

	public ModelAndView showLeaveDetails(HttpServletRequest request,HttpServletResponse response)
	{
		Map addOrEdit=new HashMap();
		Map<String,Object> map=new HashMap<String,Object>();

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		//changes
		//map.put(MAIN,LEAVE_DETAILS_JSP);
		//map.put(TITLE,"Leave Details");
		//session=request.getSession(true);
		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();
		
		addOrEdit=leaveHandlerService.getAddOrEdit(employee);
		String jsp = LEAVE_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("addOrEdit", addOrEdit);
		return new ModelAndView("index","map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showWaitingLeaves(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user =(Users)session.getAttribute(USERS);
		MasEmployee employee=user.getEmployee();
		List waitingLeavesList = new ArrayList();
		waitingLeavesList=leaveHandlerService.getWaitingLeavesList(employee);
		Map<String,Object> map=new HashMap<String,Object>();
		
	//	map.put(MAIN,WAITING_LEAVES_JSP);
	//	map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList",waitingLeavesList);

		String jsp = WAITING_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index","map",map);
	}

	public ModelAndView showWaitingLeavesEncashment(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user =(Users)session.getAttribute(USERS);
		MasEmployee employee=user.getEmployee();
		
		List waitingLeavesList = new ArrayList();
		waitingLeavesList = leaveHandlerService.getWaitingEncashmentLeave(employee);
		
		Map<String,Object> map=new HashMap<String,Object>();
		
	//	map.put(MAIN,WAITING_LEAVES_JSP);
	//	map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList",waitingLeavesList);

		String jsp = WAITING_LEAVES_ENCASHMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index","map",map);
	}

	public ModelAndView showApprovedLeaves(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		
		
		Users user =(Users)session.getAttribute(USERS);
		MasEmployee employee=user.getEmployee();
		List approvedLeavesList=leaveHandlerService.getApprovedLeavesList(employee);
		
		List<HrEncashmentDetails> approvedLeavesEncashment = leaveHandlerService.getApprovedLeavesEncashment(employee);
		Map<String,Object> map=new HashMap<String,Object>();
		
	//	map.put(MAIN,APPROVED_LEAVES_JSP);
	//	map.put(TITLE,"Approved Leaves");

		map.put("approvedLeavesList", approvedLeavesList);
		map.put("approvedLeavesEncashment", approvedLeavesEncashment);
		
		String jsp = APPROVED_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index","map",map);
	}

	public ModelAndView showApprovedLeavesInCurrentDate(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		
		
		Users user =(Users)session.getAttribute(USERS);
		MasEmployee employee=user.getEmployee();
		List approvedLeavesList=leaveHandlerService.getTodayApprovedLeavesList(employee);
		
		List<HrEncashmentDetails> approvedLeavesEncashment = new ArrayList<HrEncashmentDetails>();
		Map<String,Object> map=new HashMap<String,Object>();
		
	//	map.put(MAIN,APPROVED_LEAVES_JSP);
	//	map.put(TITLE,"Approved Leaves");

		map.put("approvedLeavesList", approvedLeavesList);
		map.put("approvedLeavesEncashment", approvedLeavesEncashment);
		
		String jsp = APPROVED_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index","map",map);
	}

	public ModelAndView showDisapprovedLeaves(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user =(Users)session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();
		List disapprovedLeavesList=leaveHandlerService.getDisapprovedLeavesList(employee);
		
		List<HrEncashmentDetails> disapprovedLeavesEncashment = leaveHandlerService.getDisapprovedLeavesEncashment(employee);
		Map<String,Object> map=new HashMap<String,Object>();
		//map.put(MAIN,DISAPPROVED_LEAVES_JSP);
		//map.put(TITLE,"Disapproved Leaves");
		map.put("disapprovedLeavesList", disapprovedLeavesList);
		map.put("disapprovedLeavesEncashment", disapprovedLeavesEncashment);
		
		String jsp = DISAPPROVED_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index","map",map);
	}

	public ModelAndView showMyDetails(HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException
	{
		String leaveType= "";
		String leaveStatus = "";
		String fromDate = "";
		String toDate = "";
		String encashmentYOrN = "";
		boolean encashmentListOnly=false;

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		
		List<HrLeaveDetails> leaveList=new ArrayList<HrLeaveDetails>();
		List<HrEncashmentDetails> leaveEncashmentList=new ArrayList<HrEncashmentDetails>();
		
		if(request.getParameter(FROM_DATE) != null && !request.getParameter(FROM_DATE).trim().equals("")){
			fromDate = request.getParameter(FROM_DATE);
			//System.out.println("fromdate in controller :"+fromDate);
		}
		if(request.getParameter(TO_DATE) != null && !request.getParameter(TO_DATE).trim().equals("")){
			toDate = request.getParameter(TO_DATE);
			//System.out.println("toDate in controller :"+toDate);
		}

		if(request.getParameter(LEAVE_TYPE) !=null ){
			leaveType = request.getParameter("leaveType");
		}
		if(request.getParameter(LEAVE_STATUS) !=null ){
			leaveStatus = request.getParameter("leaveStatus");
		}
		
		Map<String,Object> mapForDs=new HashMap<String,Object>();
		Users user =(Users)session.getAttribute(USERS);
		
		mapForDs.put("employeeId", user.getEmployee().getId());
		Map<String,Object> map=new HashMap<String,Object>();
		
		map = leaveHandlerService.getPersonalDetailsPatMatDetails(mapForDs);
		
		leaveEncashmentList = leaveHandlerService.getLeavesEncashmentList(user.getEmployee().getId(),fromDate,toDate,leaveType,leaveStatus);
		leaveList = leaveHandlerService.getLeavesList(user.getEmployee().getId(),fromDate,toDate,leaveType,leaveStatus);
		
		if(request.getParameter(ENCHASHMENT_CHECK) != null){
			leaveList = new ArrayList<HrLeaveDetails>();
			encashmentListOnly = true;
		}
		
		map.put("encashmentListOnly",encashmentListOnly );
		map.put("leaveEncashmentList", leaveEncashmentList);
		map.put("leaveList", leaveList);
		
		List<HrEmployeeBalanceNew> leaveBalance=leaveHandlerService.getLeaveBalance(user.getEmployee().getId());
		
		List leaveTypeList = leaveHandlerService.getMasLeaveTypeMediatorList();
		List leaveStatusList = leaveHandlerService.getLeaveStatusList();
		
		//int rhFirstHalf = leaveHandlerService.getRH(leaveList,FIRST_HALF_START,FIRST_HALF_END);
		//int rhSecondHalf = leaveHandlerService.getRH(leaveList,SECOND_HALF_START,SECOND_HALF_END);
		
//		map.put("rhFirstHalf", rhFirstHalf);
//		map.put("rhSecondHalf", rhSecondHalf);
		map.put("leaveBalance", leaveBalance);
		//changes
		//map.put("locationId", user.getLocationId());
		//map.put("locationId", 10);
		
		map.put("leaveTypeList", leaveTypeList);
		map.put("leaveStatusList", leaveStatusList);
		
//		map.put(MAIN,MY_DETAILS_JSP);
//		map.put(TITLE,"My Leave Details");
//		System.out.println("before return jsp");
		String jsp = MY_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index","map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showTeamDetails(HttpServletRequest request,HttpServletResponse response)
	{
		/*--------------------------------*/
		String leaveType= "";
		String leaveStatus = "";
		String fromDate = "";
		String toDate = "";
		boolean encashmentListOnly=false;

		Map<String,Object> mapForDs=new HashMap<String,Object>();
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		
		if(request.getParameter(FROM_DATE) != null && !request.getParameter(FROM_DATE).trim().equals("")){
			fromDate = request.getParameter(FROM_DATE);
			//System.out.println("fromdate in controller :"+fromDate);
		}
		if(request.getParameter(TO_DATE) != null && !request.getParameter(TO_DATE).trim().equals("")){
			toDate = request.getParameter(TO_DATE);
			//System.out.println("toDate in controller :"+toDate);
		}

		if(request.getParameter(LEAVE_TYPE) !=null ){
			leaveType = request.getParameter("leaveType");
		}
		if(request.getParameter(LEAVE_STATUS) !=null ){
			leaveStatus = request.getParameter("leaveStatus");
		}

		/*--------------------------------*/
		//session=request.getSession(true);
		//List leaveList=null;
		Users users =(Users)session.getAttribute(USERS);
		MasEmployee user=users.getEmployee();
		mapForDs.put("employeeId", user.getId());
		
		List empNames=leaveHandlerService.getEmpNamesList(user.getId());
		/*--------------------------------*/
		//changes
		//List<HrLeaveDetails> leaveList=leaveHandlerService.getLeavesList(user.getId(),fromDate,toDate,leaveType,leaveStatus);
		List<HrLeaveDetails> leaveList=null;
		List<HrEncashmentDetails> leaveEncashmentList=new ArrayList<HrEncashmentDetails>();
		
		List leaveTypeList = leaveHandlerService.getMasLeaveTypeMediatorList();
		List leaveStatusList = leaveHandlerService.getLeaveStatusList();
		/*--------------------------------*/
		Boolean flag=false;
		
		Map<String,Object> map=new HashMap<String,Object>();
		map = leaveHandlerService.getPersonalDetailsPatMatDetails(mapForDs);
		
		map.put("encashmentListOnly",encashmentListOnly );
		map.put("leaveList", leaveList);
		map.put("leaveEncashmentList", leaveEncashmentList);
		
		map.put("empNames",empNames);
		//System.out.println(empNames.size()+"djjdjd");
		/*--------------------------------*/
		map.put("leaveTypeList", leaveTypeList);
		map.put("leaveStatusList", leaveStatusList);
		map.put("flag", flag);
		/*--------------------------------*/
	//	map.put(MAIN,TEAM_DETAILS_JSP);
	//	map.put(TITLE,"Team Details");
		
		String jsp = TEAM_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		
		return new ModelAndView("index","map",map);
	}

	public ModelAndView sendSuggestion(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

//		session=request.getSession(true);
		Users user =(Users)session.getAttribute(USERS);
		String suggestion[]=request.getParameterValues("checkbox");
		
		String suggestionMessage="";
		if(request.getParameter("remarks")!=null) {
			suggestionMessage = request.getParameter("remarks");
		}
			
		
		MasEmployee employee = user.getEmployee();
		
		leaveHandlerService.sendSuggestion(suggestion,employee,suggestionMessage);
		List waitingLeavesList=leaveHandlerService.getWaitingLeavesList(employee);
		Map<String,Object> map=new HashMap<String,Object>();
		
		//map.put(MAIN,WAITING_LEAVES_JSP);
		//map.put(TITLE,"Leaves Waiting for approval");
	
		map.put("waitingLeavesList",waitingLeavesList);

		String jsp = WAITING_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView onHoldEncashment(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		
		//session=request.getSession(true);
		Users user =(Users)session.getAttribute(USERS);
		String suggestion[]=request.getParameterValues("checkbox");
		
		String suggestionMessage="";
		if(request.getParameter("remarks")!=null) {
			suggestionMessage = request.getParameter("remarks");
		}
			
		
		MasEmployee employee = user.getEmployee();
		
		leaveHandlerService.onHoldEncashment(suggestion,employee,suggestionMessage);
		List waitingLeavesList=leaveHandlerService.getWaitingEncashmentLeave(employee);
		Map<String,Object> map=new HashMap<String,Object>();
		
		//map.put(MAIN,WAITING_LEAVES_JSP);
		//map.put(TITLE,"Leaves Waiting for approval");
	
		map.put("waitingLeavesList",waitingLeavesList);

		String jsp = WAITING_LEAVES_ENCASHMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
		return new ModelAndView("index","map",map);
	}

	public ModelAndView approveLeaves(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		//session=request.getSession(true);
		Users user =(Users)session.getAttribute(USERS);
		String approve[]=request.getParameterValues("checkbox");
		String remarks="";
		if(request.getParameter("remarks")!=null)
			remarks = request.getParameter("remarks");
		
		MasEmployee employee = user.getEmployee();

		Map map1 =  leaveHandlerService.approveLeaves(approve,employee,remarks);
		
		List waitingLeavesList=leaveHandlerService.getWaitingLeavesList(employee);
		Map<String,Object> map=new HashMap<String,Object>();
		
		//map.put(MAIN,WAITING_LEAVES_JSP);
		//map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList",waitingLeavesList);
		map.put("msg",""+map1.get("msg"));
		String jsp = WAITING_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
		return new ModelAndView("index","map",map);
	}

	public ModelAndView approveLeavesEncashment(HttpServletRequest request,HttpServletResponse response)
	{
		//session=request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user =(Users)session.getAttribute(USERS);
		String approve[]=request.getParameterValues("checkbox");
		String remarks="";
		if(request.getParameter("remarks")!=null)
			remarks = request.getParameter("remarks");
		
		MasEmployee employee = user.getEmployee();

		leaveHandlerService.approveLeavesEncashment(approve,employee,remarks);
		
		List waitingLeavesList=leaveHandlerService.getWaitingEncashmentLeave(employee);
		Map<String,Object> map=new HashMap<String,Object>();
		
		//map.put(MAIN,WAITING_LEAVES_JSP);
		//map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList",waitingLeavesList);

		String jsp = WAITING_LEAVES_ENCASHMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
		return new ModelAndView("index","map",map);
	}

	public ModelAndView disapproveLeaves(HttpServletRequest request,HttpServletResponse response)
	{
		//session=request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user =(Users)session.getAttribute(USERS);
		String disapprove[]=request.getParameterValues("checkbox");
		String disapproveMessage="";
		if(request.getParameter("remarks")!=null) {
			disapproveMessage = request.getParameter("remarks");
		}
			
		
		MasEmployee employee = user.getEmployee();

		leaveHandlerService.disapproveLeaves(disapprove,employee,disapproveMessage);
		List waitingLeavesList=leaveHandlerService.getWaitingLeavesList(employee);
		Map<String,Object> map=new HashMap<String,Object>();
		
//		map.put(MAIN,WAITING_LEAVES_JSP);
	//	map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList",waitingLeavesList);

		String jsp = WAITING_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
		return new ModelAndView("index","map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView disapproveLeavesEncashment(HttpServletRequest request,HttpServletResponse response)
	{
		//session=request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user =(Users)session.getAttribute(USERS);
		String disapprove[]=request.getParameterValues("checkbox");
		String disapproveMessage="";
		if(request.getParameter("remarks")!=null) {
			disapproveMessage = request.getParameter("remarks");
		}
			
		
		MasEmployee employee = user.getEmployee();

		leaveHandlerService.disapproveLeavesEncashment(disapprove,employee,disapproveMessage);
		List waitingLeavesList=leaveHandlerService.getWaitingEncashmentLeave(employee);
		Map<String,Object> map=new HashMap<String,Object>();
		
//		map.put(MAIN,WAITING_LEAVES_JSP);
	//	map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList",waitingLeavesList);

		String jsp = WAITING_LEAVES_ENCASHMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
		return new ModelAndView("index","map",map);
	}

	public ModelAndView deleteLeaves(HttpServletRequest request,HttpServletResponse response)
	{
		//session=request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user =(Users)session.getAttribute(USERS);
		String delete[]=request.getParameterValues("checkbox");
		String deleteForEncashment[]=request.getParameterValues("checkboxEncashment");
		
		String deleteMessage=request.getParameter("deleteMessage");
		
		MasEmployee employee = user.getEmployee();

		Map map1 = leaveHandlerService.deleteLeaves(delete,employee,deleteMessage);
		leaveHandlerService.deleteLeavesEncashment(deleteForEncashment,employee,deleteMessage);
		
		ModelAndView mv=new ModelAndView();
		try {
			mv = showMyDetails(request,response);
			mv.addObject("map1", map1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mv;
	}

	public ModelAndView showTeamMemberDetail(HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException
	{
		/*--------------------------------*/
		String leaveType= "";
		String leaveStatus = "";
		String fromDate = "";
		String toDate = "";
		boolean encashmentListOnly=false;

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		
		List<HrLeaveDetails> leaveList=new ArrayList<HrLeaveDetails>();
		List<HrEncashmentDetails> leaveEncashmentList=new ArrayList<HrEncashmentDetails>();
		Map<String,Object> mapForDs=new HashMap<String,Object>();

		if(request.getParameter(FROM_DATE) != null && !request.getParameter(FROM_DATE).trim().equals("")){
			fromDate = request.getParameter(FROM_DATE);
		}
		if(request.getParameter(TO_DATE) != null && !request.getParameter(TO_DATE).trim().equals("")){
			toDate = request.getParameter(TO_DATE);
		}

		if(request.getParameter(LEAVE_TYPE) !=null ){
			leaveType = request.getParameter("leaveType");
		}
		if(request.getParameter(LEAVE_STATUS) !=null ){
			leaveStatus = request.getParameter("leaveStatus");
		}
		
		/*--------------------------------*/
		//session=request.getSession(true);
		Users users =(Users)session.getAttribute(USERS);
		MasEmployee emp=users.getEmployee();
		mapForDs.put("employeeId", emp.getId());

		int memberId=Integer.parseInt(request.getParameter("memberId"));
		
		leaveEncashmentList = leaveHandlerService.getLeavesEncashmentList(memberId,fromDate,toDate,leaveType,leaveStatus);
		leaveList = leaveHandlerService.getLeavesList(memberId,fromDate,toDate,leaveType,leaveStatus);
		
		if(request.getParameter(ENCHASHMENT_CHECK) != null){
			leaveList = new ArrayList<HrLeaveDetails>();
			encashmentListOnly = true;
			
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map = leaveHandlerService.getPersonalDetailsPatMatDetails(mapForDs);
		map.put("encashmentListOnly",encashmentListOnly );
		
		List<HrEmployeeBalanceNew> leaveBalance=leaveHandlerService.getLeaveBalance(memberId,leaveType);
		MasEmployee memberDetail = leaveHandlerService.getMemberDetails(memberId);
		
		List empNames=leaveHandlerService.getEmpNamesList(emp.getId());
	
		/*--------------------------------*/
		List leaveTypeList = leaveHandlerService.getMasLeaveTypeMediatorList();
		List leaveStatusList = leaveHandlerService.getLeaveStatusList();
		Boolean flag=true;
		/*--------------------------------*/
		map.put("leaveList", leaveList);
		map.put("leaveEncashmentList", leaveEncashmentList);
		
		//map.put("rhFirstHalf", rhFirstHalf);
		//map.put("rhSecondHalf", rhSecondHalf);
		
		map.put("leaveBalance", leaveBalance);
		map.put("empNames",empNames);
		//map.put("locationId", memberDetail.getLocationId());
		/*--------------------------------*/
		map.put("leaveTypeList", leaveTypeList);
		map.put("leaveStatusList", leaveStatusList);
		map.put("flag", flag);
		/*--------------------------------*/
		//map.put(MAIN,TEAM_DETAILS_JSP);
		//map.put(TITLE,"Team Details");
		//System.out.println("before return" +leaveBalance);
		String jsp = TEAM_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
	
		return new ModelAndView("index","map",map);
	}

	public ModelAndView contactDetails(HttpServletRequest request,HttpServletResponse response){

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Map detailsMap = leaveHandlerService.leaveRecord(Integer.parseInt(request.getParameter("leaveId")));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("detailsMap", detailsMap);
		
		//map.put("main",CONTACT_DETAILS_JSP);
		//map.put("title","Details");

		String jsp = CONTACT_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
	
		return new ModelAndView("index","map",map);
	}

	public ModelAndView contactDetailsEncashment(HttpServletRequest request,HttpServletResponse response){
		
		Map detailsMap=new HashMap();
		//Map detailsMap = leaveHandlerService.leaveRecord(Integer.parseInt(request.getParameter("leaveId")));
		Map<String,Object> map=new HashMap<String,Object>();

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		
		map.put("detailsMap", detailsMap);
		
		//map.put("main",CONTACT_DETAILS_JSP);
		//map.put("title","Details");

		String jsp = CONTACT_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
	
		return new ModelAndView("index","map",map);
	}

	public ModelAndView searchLeaveBalance(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object> map=new HashMap<String,Object>();

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		
		List employeeList = userMasterHandlerService.getEmployeeList();
		map.put("employeeList", employeeList);
		
		//map.put(MAIN,SEARCH_LEAVE_BALANCE_JSP);
		//map.put(TITLE,"Search Leave Balance");

		String jsp = SEARCH_LEAVE_BALANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
		return new ModelAndView("index","map",map);
	}

	public ModelAndView viewLeaveBalance(HttpServletRequest request, HttpServletResponse response)
	{
		//session=request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Map<String,Object> map=new HashMap<String,Object>();
		List<HrEncashmentDetails> leaveEncashmentList=new ArrayList<HrEncashmentDetails>();
		
		int empId = 0;
		Map<String,Object> empDetailsMap = new HashMap<String,Object>();
		Map<String,Object> mapForDs=new HashMap<String,Object>();
		Users user =(Users)session.getAttribute(USERS);
		
		mapForDs.put("employeeId", user.getEmployee().getId());

		if((!(request.getParameter(EMP_NAME)).equals(""))|| request.getParameter(EMP_NAME) != null){
			empId = Integer.parseInt(request.getParameter(EMP_NAME));
		}

		map = leaveHandlerService.getPersonalDetailsPatMatDetails(mapForDs);
		empDetailsMap = leaveHandlerService.getEmpLeaveDetails(empId);
		leaveEncashmentList = leaveHandlerService.getLeavesEncashmentList(empId,"","","","");
		map.put("empDetailsMap", empDetailsMap);
		map.put("leaveEncashmentList", leaveEncashmentList);
		//map.put(MAIN,SHOW_LEAVE_BALANCE_JSP);
		//map.put(TITLE,"Show Leave Balance");

		String jsp = SHOW_LEAVE_BALANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
	
		return new ModelAndView("index","map",map);
	}

	public ModelAndView updateLeaveBalance(HttpServletRequest request, HttpServletResponse response)
	{
		//session=request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users)session.getAttribute(USERS);
		int hospitalId =0;
		if (session.getAttribute("hospitalId")!= null) {
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}

		Map<String, Object> map= new HashMap<String, Object>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String currentDate = "";
		String currentTime = "";
		currentDate = (String)utilMap.get("currentDate");	 
		currentTime = (String)utilMap.get("currentTime");

		Date modifiedDate = new Date(); 

		String newLeaveBalance = "";
		String oldLeaveBalance = "";
		String newLeaveBalanceYearly = "";
		String oldLeaveBalanceYearly = "";

		String newOnsiteLeaveBalance = "";
		String remarks = "";
/*		String fromDate = "";
		String toDate = "";
*/
		String recepientAddress = "";
/*		String senderEmailId = "";
		String emailMessage = "";
		String subject = "";
*/		
		double updatedLeaves=0.0;
		boolean flag = false;
		if(session.getAttribute("update") != null){
			flag = true;
		}

		if(flag) {
/*			oldLeaveBalance= request.getParameter(OLD_LEAVE_BALANCE);
			newLeaveBalance = request.getParameter(LEAVE_BALANCE);*/
			oldLeaveBalanceYearly = request.getParameter(OLD_LEAVE_BALANCE);
			newLeaveBalanceYearly = request.getParameter(LEAVE_BALANCE);
			
			updatedLeaves = Double.parseDouble(newLeaveBalanceYearly)-Double.parseDouble(oldLeaveBalanceYearly);
			String balanceAdjustedBy =new DecimalFormat("0.##").format((double)updatedLeaves);
			
			remarks = request.getParameter(REMARKS);
/*			fromDate = request.getParameter(FROM_DATE);
			toDate = request.getParameter(TO_DATE);*/
			
			Integer leaveTypeId = Integer.parseInt(request.getParameter(LEAVE_TYPE_ID));
			int empId = Integer.parseInt(request.getParameter(EMP_NAME));
			int hrId = user.getEmployee().getId();
			
			HrUpdateLeaveBalanceHistory leaveHistory = new HrUpdateLeaveBalanceHistory();
			leaveHistory.setHrId(hrId);
			leaveHistory.setEmpId(empId);
			//leaveHistory.setNewLeaveBalance(newLeaveBalance);
			leaveHistory.setNewLeaveBalanceYearly(newLeaveBalanceYearly);
			
			MasEmployee updatedFor = new MasEmployee();
			updatedFor.setId(empId);
			leaveHistory.setEmployeeUpdated(updatedFor);

			MasEmployee updatedBy = new MasEmployee();
			updatedBy.setId(hrId);
			leaveHistory.setUsers(updatedBy);
			
			leaveHistory.setModifiedAt(modifiedDate);
			leaveHistory.setRemarks(remarks);
			leaveHistory.setBalanceAdjustBy(balanceAdjustedBy);

			leaveHistory.setLastChgBy(user);
			leaveHistory.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			leaveHistory.setLastChgTime(currentTime);

			MasHospital company =new MasHospital();
			company.setId(hospitalId);
			leaveHistory.setCompany(company);

/*			if( fromDate!=null && !(fromDate.equals(""))){
				Date jspFromDate=HMSUtil.dateFormatterDDMMYYYY(fromDate);
				leaveHistory.setFromdate(jspFromDate);
			}
			if( toDate!=null && !(toDate.equals(""))){
				Date jspToDate=HMSUtil.dateFormatterDDMMYYYY(toDate);
				leaveHistory.setFromdate(jspToDate);
			}*/
			HrMasLeaveTypeMediator leaveType=new HrMasLeaveTypeMediator();
			leaveType.setId(leaveTypeId);
			leaveHistory.setLeaveType(leaveType);
			
			leaveHandlerService.updateLeaveBalance(leaveHistory, newLeaveBalanceYearly, newOnsiteLeaveBalance, empId, balanceAdjustedBy);

/*			Map emailIdMap = leaveHandlerService.getEmailId(hrId,empId);

			String empEmailId = (String)emailIdMap.get("empEmailId");	
			String userManagerEmailId = (String)emailIdMap.get("userManagerEmailId");	
			String hrManagerEmailId = (String)emailIdMap.get("hrManagerEmailId");	

			recepientAddress = (recepientAddress.concat(empEmailId)).concat(",").trim();
			recepientAddress = (recepientAddress.concat(userManagerEmailId)).concat(",").trim();
			recepientAddress = (recepientAddress.concat(hrManagerEmailId)).concat(",").trim();*/
			
			//changes
			//Users employee = getUserMasterHandlerService().getUser(empId);
/*			List<MasEmployee> employeeList = getUserMasterHandlerService().getEmployeeList();
			MasEmployee employee = employeeList.get(0);
			
			
			if(recepientAddress != "")
			{
				recepientAddress = recepientAddress.substring(0,recepientAddress.length()-1);
			}*/
/*			if(updatedLeaves>0)
			{
				emailMessage = 	" Leave balance of "+employee.getFirstName()+"("+employee.getEmployeeCode()+") has been updated by "+user.getEmployee().getFirstName()+" "+user.getEmployee().getLastName()+".\n"+
				" Previous leave balance was "+oldLeaveBalance+"."+
				" Current leave balance is "+newLeaveBalance+".\n"+
				" Its increased by "+updatedLeaves+" leaves.\n"+
				" Remarks:"+remarks+".\n";
			}
			else
			{
				emailMessage = 	" Leave balance of "+employee.getFirstName()+"("+employee.getEmployeeCode()+") has been updated by "+user.getEmployee().getFirstName()+" "+user.getEmployee().getLastName()+".\n"+
				" Your previous leave balance was "+oldLeaveBalance+"."+
				" Your current leave balance is "+newLeaveBalance+".\n"+
				" Its decreased by "+(-updatedLeaves)+" leaves.\n"+
				" Remarks:"+remarks+".\n";
			}
			//System.out.println(emailMessage);
			subject = "Updated Leave Balance";

			senderEmailId = user.getEmailAddress();*/
			
			//changes
			//RequestTrackerUtil.intranetEmailFunction(recepientAddress, senderEmailId, emailMessage, subject);

			String message[]={"Leave Balance Updated Successfully."};
			
			List<String> link=new ArrayList<String>();
			
			link.add("Click Here to Update record again ");
			link.add("leave?method=searchLeaveBalance");

			map.put("message",message);
			map.put("link",link);

			
			//map.put("message",message);
			//map.put(MAIN, "message.jsp");
			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put(TITLE,"Leave Balance Updated");

			session.setAttribute("update", null);
			return new ModelAndView("index","map",map);

		}else{

			String message[]={"You have already update the leave balance. Go to Update Leave Balance option to update again",
					"/jktintranet/jkt/leave?method=searchLeaveBalance",
					"/jktintranet/jkt/login?method=showPage&jspPage=home"
			};
			map.put("message",message);
			
			//map.put(MAIN, "message.jsp");
			//map.put(TITLE,"Leave Application");
			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put(TITLE,"Leave Application");
			
			return new ModelAndView("index","map",map);
		}

	}

	public ModelAndView searchLeaveHistory(HttpServletRequest request, HttpServletResponse response)
	{
		//session = request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users)session.getAttribute(USERS);
		Map<String,Object> map=new HashMap<String,Object>();
		String userRole = "";
		String userName = "";
		List employeeList = new ArrayList();
		//Set userRoleMapSet = (Set)user.getRoles();
		//for (Iterator iter = userRoleMapSet.iterator(); iter.hasNext();) {
		//	UserRoleMap userRoleMap = (UserRoleMap) iter.next();
		//	userRole = userRoleMap.getRoleId();
		//	if(userRole.equals("R00017"))
		//	{
		//		employeeList = userMasterHandlerService.getEmployeeList();
		//		map.put("employeeList", employeeList);

			//}
			//else{
				userName = user.getEmployee().getFirstName();
				List leaveHistoryList = leaveHandlerService.viewLeaveHistory(user.getEmployee().getId());
				map.put("leaveHistoryList", leaveHistoryList);
				map.put("userName", userName);

			//}
		//}
		session.setAttribute("firstTime", "firstTime");

		String jsp = LEAVE_DETAILS_HISTORY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
	
		//map.put("main",LEAVE_DETAILS_HISTORY_JSP);
		//map.put("title","Leave Details History");
		
		return new ModelAndView("index","map",map);

	}

	public ModelAndView viewLeaveHistory(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		session.setAttribute("firstTime", "secondTime");
		Map<String,Object> map=new HashMap<String,Object>();
		int empId = Integer.parseInt(request.getParameter(EMP_NAME));
		List employeeList = userMasterHandlerService.getEmployeeList();
		List leaveHistoryList = leaveHandlerService.viewLeaveHistory(empId);
		map.put("employeeList", employeeList);
		map.put("leaveHistoryList", leaveHistoryList);
		
		//map.put(MAIN, LEAVE_DETAILS_HISTORY_JSP);
		//map.put(TITLE, "Leave Deatils History");

		String jsp = LEAVE_DETAILS_HISTORY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	/*
	public ModelAndView helpForLeaveManagement(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute(USERS) == null){
			return new ModelAndView("index");
		}
		Users user=(Users)session.getAttribute("user");
		Set roleSet = user.getRoles();
		Boolean userIsManager = false;
		Boolean userIsHR = false;
		Boolean userIsUser = false;
		for (Iterator roleSetIter = roleSet.iterator(); roleSetIter.hasNext();) 
		{
			UserRoleMap userRoleMap = (UserRoleMap) roleSetIter.next();
			if(userRoleMap.getRoleId().equals("R00004"))
			{
				userIsUser = true;
			}            
			else if(userRoleMap.getRoleId().equals("R00016"))
			{
				userIsManager = true;
			}
			else if(userRoleMap.getRoleId().equals("R00005"))
			{
				userIsHR = true;
			}
		}
		Map<String,Object> map=new HashMap<String,Object>();
		String main = null;
		String title = null;
		if(userIsUser && !userIsManager && !userIsHR ){
			String jsp = USER_LEAVE_HELP_GUIDE_HTM;
			//jsp += ".jsp";

//			map.put(MAIN, USER_LEAVE_HELP_GUIDE_HTM);
	//		map.put(TITLE, "User Help Guide");
		}
		else if(userIsManager && !userIsHR){
			String jsp = MANAGER_LEAVE_HELP_GUIDE_HTM;
		//	map.put(MAIN, MANAGER_LEAVE_HELP_GUIDE_HTM);
		//	map.put(TITLE, "Manager Help Guide");
		}
		else if(userIsHR && !userIsManager){
			String jsp = HR_LEAVE_HELP_GUIDE_HTM;
		//	map.put(MAIN, HR_LEAVE_HELP_GUIDE_HTM);
		//	map.put(TITLE, "HR Help Guide");
		}

		String jsp = WAITING_LEAVES_FOR_HR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}
*/
	
	public ModelAndView waitingLeavesForHR(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Users user =(Users) session.getAttribute(USERS);
		int empId = user.getEmployee().getId();
		List<HrEncashmentDetails> leaveEncashmentList = new ArrayList<HrEncashmentDetails>();  
		List waitingLeavesList=leaveHandlerService.getAllWaitingLeavesForHR(empId);
		// -1 means for all employee
		leaveEncashmentList = leaveHandlerService.getLeavesEncashmentList(empId ,"","","","3");
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("waitingLeavesList",waitingLeavesList);
		map.put("leaveEncashmentList",leaveEncashmentList);
		
//		map.put(MAIN,WAITING_LEAVES_FOR_HR_JSP);
//		map.put(TITLE,"Waiting Leaves");

		String jsp = WAITING_LEAVES_FOR_HR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	

		return new ModelAndView("index","map",map);
	}

	public ModelAndView showLeaveTypeMaster(HttpServletRequest request,HttpServletResponse response)
	{
		
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Map<String,Object> map=new HashMap<String,Object>();
		List<HrMasLeaveTypeNew> leaveTypeForEdit  = new ArrayList<HrMasLeaveTypeNew>();
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		int leaveMasTypeId = 0;
		if (request.getParameter("leaveTypeId")!= null ) {
			leaveMasTypeId = Integer.parseInt(request.getParameter("leaveTypeId"));
			leaveTypeForEdit = leaveHandlerService.getMasLeaveTypeListForId(leaveMasTypeId);
		}

		List<HrMasLeave> leaveTypeList = leaveHandlerService.getLeaveTypeList();
		List<HrMasLeaveTypeNew> masLeaveTypeList = leaveHandlerService.getMasLeaveTypeNewList();
		//List<HrMasLeaveTypeNew> minDateList = leaveHandlerService.getMasLeaveTypeNewMinFromDateForLeaveType(20);
		//List<HrMasLeaveType> leaveTypeForEdit = leaveHandlerService.getMasLeaveTypeListForId(leaveMasTypeId);
		//System.out.println("Size in controller :"+masLeaveTypeList.size());
		map.put("leaveTypeList",leaveTypeList);
		map.put("masLeaveTypeList",masLeaveTypeList);
		map.put("leaveTypeForEdit",leaveTypeForEdit);
		//map.put("minDateList",minDateList);
		
		String jsp = SHOW_LEAVE_TYPE_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	

		return new ModelAndView("index","map",map);
	}
		
	@SuppressWarnings("unchecked")
	public ModelAndView submitTypeMaster(HttpServletRequest request,HttpServletResponse response)
	{

		Map<String,Object> map=new HashMap<String,Object>();
		
		HrMasLeave hrMasLeave = new HrMasLeave();
		
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		//HrMasLeaveType hrMasLeaveType = new HrMasLeaveType();
		//List<HrMasLeaveType> hrMasLeaveTypeList = new ArrayList<HrMasLeaveType>();
		//HttpSession session = request.getSession();
		HrMasLeaveTypeNew hrMasLeaveType = new HrMasLeaveTypeNew();
		
		List<HrMasLeaveTypeNew> hrMasLeaveTypeNewForMaxDate = new ArrayList<HrMasLeaveTypeNew>();
		List<HrMasLeaveTypeNew> hrMasLeaveTypeNewList = new ArrayList<HrMasLeaveTypeNew>();
		
		
		List<MasEmployee> employeeList = null;
		
		//List<HrMasLeaveType> hrMasLeaveTypeAllRec = new ArrayList<HrMasLeaveType>();
		
		Date fromDate = null;
	//	Date toDate = null;
		
		int leaveType = 0;
	//	int allowedDays = 0;
		String encashmentYOrN = "";
		String carryForward = "";
		String halfDayAllow="";
		int encashmentPercentage = 0;
		String remarks = "";
		int bufferRequired=0;
		Date currentDate = new Date();
		Date jspFromDate = new Date();
		Date jspToDate = new Date();
		Boolean againSameLeaveRecord = false;
		Boolean defineAtleastOneForCurrentDate = false;
		Boolean jspFromDateLessThanLeastFromDate = false;
		Boolean insertInFirstPosition = false;
		//Logic for same record
		
		if(request.getParameter(FROM_DATE)!=null && !(request.getParameter(FROM_DATE).equals(""))){
			jspFromDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
		}

		if(request.getParameter(TO_DATE)!=null && !(request.getParameter(TO_DATE).equals(""))){
			jspToDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
		}
		
/*		else if(request.getParameter(FROM_DATE)!=null && (request.getParameter(TO_DATE).equals(""))){
			jspFromDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
			jspToDate=jspFromDate;
		}*/
		
		//System.out.println("in type master method");
	
	/*	if(request.getParameter(TYPE) != null && !request.getParameter(TYPE).trim().equals("")){
			leaveType = Integer.parseInt(request.getParameter(TYPE));
		}
		
		hrMasLeaveTypeList = leaveHandlerService.getMasLeaveTypeList(leaveType);
		
		
		if(request.getParameter(FROM_DATE)!=null && !"".equals(request.getParameter(FROM_DATE))){
			
			for (Iterator leaveListIterator = hrMasLeaveTypeList.iterator(); leaveListIterator.hasNext();) {
				HrMasLeaveType leaveRecord = (HrMasLeaveType) leaveListIterator.next();
				if(leaveRecord.getValidFromDate()!=null)
				{
						if(jspFromDate.compareTo(leaveRecord.getValidFromDate())>=0 && jspFromDate.compareTo(leaveRecord.getValidToDate())<= 0)					{	
							againSameLeaveRecord=true;
							break;
						}else if(jspFromDate.compareTo(leaveRecord.getValidFromDate())<= 0)
						{
							if(jspToDate.compareTo(leaveRecord.getValidFromDate())>= 0 ){
								againSameLeaveRecord=true;
								break;
							}
							
							}else if(jspFromDate.compareTo(leaveRecord.getValidFromDate())== 0 && jspToDate.compareTo(leaveRecord.getValidToDate())==0){
							againSameLeaveRecord=true;
							break;
						}
				}
			}
		}
		//Date displayDate=DateFormat.getDateInstance(DateFormat.SHORT).format(currentDate);
	if(!againSameLeaveRecord){
		System.out.println("Enchament chech box :"+request.getParameter(ENCHASHMENT_CHECK));
		
		if(request.getParameter(TYPE) != null && !request.getParameter(TYPE).trim().equals("")){
			leaveType = Integer.parseInt(request.getParameter(TYPE));
			hrMasLeave.setId(leaveType);
			hrMasLeaveType.setLeaveType(hrMasLeave);
			
		}

		if(request.getParameter(MONTHLY_OR_YEARLY)!=null)
		{
			if(request.getParameter(MONTHLY_OR_YEARLY).equals("monthly"))
				hrMasLeaveType.setMonthlyOrYearly("m");
			else
				hrMasLeaveType.setMonthlyOrYearly("y");
		}

		if(request.getParameter(ALLOWED_DAYS) != null && !request.getParameter(ALLOWED_DAYS).trim().equals("")){
			//allowedDays = Integer.parseInt(request.getParameter(ALLOWED_DAYS));
			hrMasLeaveType.setAllowedDays(request.getParameter(ALLOWED_DAYS));
		}

		if(request.getParameter(ENCHASHMENT_CHECK) != null){
			encashmentYOrN = request.getParameter(ENCHASHMENT_CHECK);
			hrMasLeaveType.setEncashable(encashmentYOrN);
			
			encashmentPercentage = Integer.parseInt(request.getParameter(ENCHASHMENT));
			hrMasLeaveType.setEncashablePercent(encashmentPercentage);
		}
		else {
			encashmentYOrN = "n";
			hrMasLeaveType.setEncashable(encashmentYOrN);
			hrMasLeaveType.setEncashablePercent(0);
		}
	
		if(request.getParameter(CARRY_FORWARD) != null){
			carryForward = request.getParameter(CARRY_FORWARD);
			hrMasLeaveType.setCrFrdable(carryForward);
		}
		else {
			carryForward = "n";
			hrMasLeaveType.setCrFrdable(carryForward);
		}
		
		if(request.getParameter(FROM_DATE) != null && !request.getParameter(FROM_DATE).trim().equals("")){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			hrMasLeaveType.setValidFromDate(fromDate);
			System.out.println("fromdate in controller :"+fromDate);
		}
		if(request.getParameter(TO_DATE) != null && !request.getParameter(TO_DATE).trim().equals("")){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			hrMasLeaveType.setValidToDate(toDate);
			System.out.println("toDate in controller :"+toDate);
		}

		if(request.getParameter(REMARKS) != null){
			remarks = request.getParameter(REMARKS);
			hrMasLeaveType.setRemarks(remarks);
		}
		String lastchangeBy = "";
		if (request.getParameter(CHANGED_BY)!= null) {
			lastchangeBy = request.getParameter(CHANGED_BY);
			hrMasLeaveType.setLastChgBy(lastchangeBy);
		}
		Date changedDate = null;
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			changedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			hrMasLeaveType.setLastChgDate(changedDate);
		}
		String	changedTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			changedTime = request.getParameter(CHANGED_TIME);
			hrMasLeaveType.setLastChgTime(changedTime);
		}

		leaveHandlerService.submitTypeMaster(hrMasLeaveType);

		// To be done later
		
		
		employeeList = userMasterHandlerService.getEmployeeList();
		
		for(MasEmployee employee :employeeList) {
			HrEmployeeBalance employeeBalance =new HrEmployeeBalance();
			
			employeeBalance.setEmp(employee);
			employeeBalance.setLeaveType(hrMasLeaveType);
			//employeeBalance.setOpeningBalance(hrMasLeaveType.getAllowedDays());
			employeeBalance.setTaken("0");
			//employeeBalance.setEarned(hrMasLeaveType.getAllowedDays());
			employeeBalance.setClosingBalance("0");
			employeeBalance.setStatus("y");
			employeeBalance.setLastChgBy(hrMasLeaveType.getLastChgBy());
			employeeBalance.setLastChgDate(hrMasLeaveType.getLastChgDate());
			employeeBalance.setLastChgTime(hrMasLeaveType.getLastChgTime());
			
			leaveHandlerService.saveEmployeeLeaveBalance(employeeBalance);
		}    */
		
		// Added for Only Trial
		
		if(request.getParameter(TYPE) != null && !request.getParameter(TYPE).trim().equals("")){
			leaveType = Integer.parseInt(request.getParameter(TYPE));
		}
		
		
		
		//hrMasLeaveTypeList = leaveHandlerService.getMasLeaveTypeList(leaveType);
		Calendar calendar = Calendar.getInstance();
		calendar.set(9999, 11,31 );
		Date maxDate = calendar.getTime();
		
		//System.out.println("Max Date Is :"+maxDate);
		
		hrMasLeaveTypeNewList = leaveHandlerService.getMasLeaveTypeNewList(leaveType);
		hrMasLeaveTypeNewForMaxDate = leaveHandlerService.getMasLeaveTypeNewForMaxDate(leaveType,maxDate);
		List<Object[]> minDateList = leaveHandlerService.getMasLeaveTypeNewMinFromDateForLeaveType(leaveType);

		Date savedToDate = null;
		Date savedFromDate = null;

		
		if(hrMasLeaveTypeNewList.size()==0) {
			//defineAtleastOneForCurrentDate = true;
		}
		
		if(request.getParameter(FROM_DATE)!=null && !"".equals(request.getParameter(FROM_DATE))){
			if(minDateList.size()>0) {
				Object[] hrMasLeaveRecordColumn = minDateList.get(0);
				java.util.Date fromDateMinRecord = (java.util.Date)hrMasLeaveRecordColumn[0];
				
				//Date minDate=HMSUtil.dateFormatterDDMMYYYY(fromDateMinRecord);
				
				if(jspFromDate.compareTo(fromDateMinRecord)>=0) {
					
			for (HrMasLeaveTypeNew leaveRecord : hrMasLeaveTypeNewList) {
			
				if(leaveRecord.getValidFromDate()!=null)
				{
						String maxDate1=LeaveManagementUtil.convertDateToStringWithoutTime(maxDate);
						Date maxDate2=HMSUtil.dateFormatterDDMMYYYY(maxDate1);

					if((leaveRecord.getValidToDate()).compareTo(maxDate2)!=0) {
						if(jspFromDate.compareTo(leaveRecord.getValidFromDate())>=0 && jspFromDate.compareTo(leaveRecord.getValidToDate())<= 0){
							
							//System.out.println("in if");
							savedFromDate = leaveRecord.getValidFromDate();
							savedToDate = leaveRecord.getValidToDate();
							
							againSameLeaveRecord=true;
							break;
						}
						else
							if(jspFromDate.compareTo(leaveRecord.getValidFromDate())<=0) {
								savedFromDate = leaveRecord.getValidFromDate();
								jspFromDateLessThanLeastFromDate = true;
								break;
							}
					}
					else {
						if(jspFromDate.compareTo(leaveRecord.getValidFromDate())<= 0)
						{
							//System.out.println("in else");
							savedFromDate = leaveRecord.getValidFromDate();
							jspFromDateLessThanLeastFromDate = true;
							break;
						}
					}
				}
			}
				}
				else {
					insertInFirstPosition = true;
				}
			}

		}
		//Date displayDate=DateFormat.getDateInstance(DateFormat.SHORT).format(currentDate);
	if(!againSameLeaveRecord && !defineAtleastOneForCurrentDate && !jspFromDateLessThanLeastFromDate){
		//System.out.println("Enchament chech box :"+request.getParameter(ENCHASHMENT_CHECK));
		
		if(request.getParameter(TYPE) != null && !request.getParameter(TYPE).trim().equals("")){
			leaveType = Integer.parseInt(request.getParameter(TYPE));
			hrMasLeave.setId(leaveType);
			hrMasLeaveType.setLeaveType(hrMasLeave);
			
		}

		if(request.getParameter("halfDayAllow") != null){
			halfDayAllow = request.getParameter("halfDayAllow");
			hrMasLeaveType.setHalfDayAllow(halfDayAllow);
		}
		else {
			halfDayAllow = "n";
			hrMasLeaveType.setHalfDayAllow(halfDayAllow);
		}
		
		
		if(request.getParameter(MONTHLY_OR_YEARLY)!=null)
		{
			if(request.getParameter(MONTHLY_OR_YEARLY).equals("monthly"))
				hrMasLeaveType.setMonthlyOrYearly("m");
			else
				hrMasLeaveType.setMonthlyOrYearly("y");
		}
		else {
			hrMasLeaveType.setMonthlyOrYearly("u");
		}

		if(request.getParameter(ALLOWED_DAYS) != null && !request.getParameter(ALLOWED_DAYS).trim().equals("")){
			//allowedDays = Integer.parseInt(request.getParameter(ALLOWED_DAYS));
			hrMasLeaveType.setAllowedDays(request.getParameter(ALLOWED_DAYS));
		}

		if(request.getParameter(ENCHASHMENT_CHECK) != null){
			encashmentYOrN = request.getParameter(ENCHASHMENT_CHECK);
			hrMasLeaveType.setEncashable(encashmentYOrN);
			if(request.getParameter(ENCHASHMENT)!=null && !request.getParameter(ENCHASHMENT).equals("")){
			encashmentPercentage = Integer.parseInt(request.getParameter(ENCHASHMENT));
			hrMasLeaveType.setEncashablePercent(encashmentPercentage);
			hrMasLeaveType.setBufferRequired(0);
			}
			if(request.getParameter("bufferRequired") != null && !request.getParameter("bufferRequired").equals("")){
				
				bufferRequired = new Integer(request.getParameter("bufferRequired"));
				hrMasLeaveType.setBufferRequired(bufferRequired);
				hrMasLeaveType.setEncashablePercent(0);
			}
			
		}
		else {
			encashmentYOrN = "n";
			hrMasLeaveType.setEncashable(encashmentYOrN);
			hrMasLeaveType.setEncashablePercent(0);
		}
	
		if(request.getParameter(CARRY_FORWARD) != null){
			carryForward = request.getParameter(CARRY_FORWARD);
			hrMasLeaveType.setCrFrdable(carryForward);
		}
		else {
			carryForward = "n";
			hrMasLeaveType.setCrFrdable(carryForward);
		}
		
		if(request.getParameter(FROM_DATE) != null && !request.getParameter(FROM_DATE).trim().equals("")){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			hrMasLeaveType.setValidFromDate(fromDate);
			//System.out.println("fromdate in controller :"+fromDate);
		}
	/*	if(request.getParameter(TO_DATE) != null && !request.getParameter(TO_DATE).trim().equals("")){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			hrMasLeaveType.setValidToDate(toDate);
			System.out.println("toDate in controller :"+toDate);
		}*/

		if(insertInFirstPosition)
		{
			
			Object[] hrMasLeaveRecordColumn = minDateList.get(0);
			java.util.Date fromDateMinRecord1 = (java.util.Date)hrMasLeaveRecordColumn[0];
			//Date minDate1=HMSUtil.dateFormatterDDMMYYYY(fromDateMinRecord1);

			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(fromDateMinRecord1);
			calendar2.add(Calendar.DAY_OF_MONTH, -1);
			Date toDateForFirstRecord = calendar2.getTime();
			
			hrMasLeaveType.setValidToDate(toDateForFirstRecord);
		}
		else {
			hrMasLeaveType.setValidToDate(maxDate);	
		}
		
		
		if(request.getParameter(REMARKS) != null){
			remarks = request.getParameter(REMARKS);
			hrMasLeaveType.setRemarks(remarks);
		}
		String lastchangeBy = "";
		if (request.getParameter(CHANGED_BY)!= null) {
			lastchangeBy = request.getParameter(CHANGED_BY);
			hrMasLeaveType.setLastChgBy(lastchangeBy);
		}
		Date changedDate = null;
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			changedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			hrMasLeaveType.setLastChgDate(changedDate);
		}
		String	changedTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			changedTime = request.getParameter(CHANGED_TIME);
			hrMasLeaveType.setLastChgTime(changedTime);
		}

		int locationId =0;

		if (session.getAttribute("hospitalId")!= null) {
			locationId = (Integer)session.getAttribute("hospitalId");
		}

		
		MasHospital centre =new MasHospital();
		centre.setId(locationId);
		
		hrMasLeaveType.setCompany(centre);
		hrMasLeaveType.setStatus("y");
		
			
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(fromDate);
		calendar2.add(Calendar.DAY_OF_MONTH, -1);
		
		Date toDateInPlaceOfMaxDate = calendar2.getTime();
		
		if(!insertInFirstPosition) {
			if(hrMasLeaveTypeNewForMaxDate.size()>0) {
				HrMasLeaveTypeNew hrMasLeaveTypeNew = hrMasLeaveTypeNewForMaxDate.get(0);
				hrMasLeaveTypeNew.setValidToDate(toDateInPlaceOfMaxDate);
				leaveHandlerService.updateLeaveTypeMasterNew(hrMasLeaveTypeNew);
			}
		}

		
		leaveHandlerService.submitTypeMasterNew(hrMasLeaveType);

		String message = "Leave Type record added successfully.";
	
		List<HrMasLeaveTypeNew> hrMasLeaveTypeNewAllList = new ArrayList<HrMasLeaveTypeNew>();
		List<HrMasLeaveTypeNew> hrMasLeaveTypeNewRecords = new ArrayList<HrMasLeaveTypeNew>();
		
		hrMasLeaveTypeNewAllList = leaveHandlerService.getMasLeaveTypeNewList();
		
		List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediator = new ArrayList<HrMasLeaveTypeMediator>();
		hrMasLeaveTypeMediator = leaveHandlerService.getMasLeaveTypeMediatorList();

		boolean newRecordFound = true;
		if(hrMasLeaveTypeMediator.size()>0) {
			for(HrMasLeaveTypeNew hrMasLeaveTypeNewAll :hrMasLeaveTypeNewAllList) {
				newRecordFound = true; 
				for(HrMasLeaveTypeMediator hrMasLeaveTypeMediator2 :hrMasLeaveTypeMediator) {
					if(hrMasLeaveTypeMediator2.getLeaveType().getLeaveType().getId()
							==hrMasLeaveTypeNewAll.getLeaveType().getId())
						{
							newRecordFound = false;
							if(hrMasLeaveTypeMediator2.getLeaveType().getId()!=hrMasLeaveTypeNewAll.getId()) {
								// update mediator link
								// save mediator to history
								
								hrMasLeaveTypeMediator2.setLeaveType(hrMasLeaveTypeNewAll);
								leaveHandlerService.updateToHrMasLeaveTypeMediator(hrMasLeaveTypeMediator2);
								break;
							}
						}
							
					}
				if(newRecordFound) {
					//add to the new record to be added list
					hrMasLeaveTypeNewRecords.add(hrMasLeaveTypeNewAll);
					newRecordFound=true;
				}
			}
		}else {
			//add to the mediator;
			//save mediator to histroy
			for(HrMasLeaveTypeNew hrMasLeaveTypeNew:hrMasLeaveTypeNewAllList) {
				HrMasLeaveTypeMediator hrMasLeaveTypeMediator2=new HrMasLeaveTypeMediator();
				hrMasLeaveTypeMediator2.setLeaveType(hrMasLeaveTypeNew);
				leaveHandlerService.saveToHrMasLeaveTypeMediator(hrMasLeaveTypeMediator2);
				//add new leave type to employee leave balance table
				
				employeeList = userMasterHandlerService.getEmployeeList();
			//	System.out.println("employee list");
				for(MasEmployee employee :employeeList) {
					HrEmployeeBalanceNew employeeBalance =new HrEmployeeBalanceNew();
					
					employeeBalance.setEmp(employee);
					employeeBalance.setLeaveType(hrMasLeaveTypeMediator2);
					employeeBalance.setOpeningBalance(hrMasLeaveType.getAllowedDays());
					employeeBalance.setTaken("0");
					Float currentMonthEarn=new Float(hrMasLeaveType.getAllowedDays())/12;
					System.out.println("currentMonthEarn.toString()"+currentMonthEarn.toString());
					employeeBalance.setEarned(currentMonthEarn.toString());
					employeeBalance.setClosingBalance("0");
					employeeBalance.setBalanceAdjustedBy("0");
					
					employeeBalance.setStatus("y");
					employeeBalance.setLastChgBy(hrMasLeaveType.getLastChgBy());
					employeeBalance.setLastChgDate(hrMasLeaveType.getLastChgDate());
					employeeBalance.setLastChgTime(hrMasLeaveType.getLastChgTime());
					
					leaveHandlerService.saveEmployeeLeaveBalanceNew(employeeBalance);  //commented by Atul because it looked like waste code
				}    

			}

		}
		
		if(hrMasLeaveTypeNewRecords.size()>0) {
			//add all record to mediator
			//save mediator to history
			for(HrMasLeaveTypeNew hrMasLeaveTypeNew:hrMasLeaveTypeNewRecords) {
				HrMasLeaveTypeMediator hrMasLeaveTypeMediator2=new HrMasLeaveTypeMediator();
				hrMasLeaveTypeMediator2.setLeaveType(hrMasLeaveTypeNew);
				leaveHandlerService.saveToHrMasLeaveTypeMediator(hrMasLeaveTypeMediator2);
				//add new leave type to employee leave balance table
				
				//System.out.println(">>userMasterHandlerService>>>"+userMasterHandlerService);
				employeeList = userMasterHandlerService.getEmployeeList();
				//System.out.println("employee list 1111111");
				for(MasEmployee employee :employeeList) {
					HrEmployeeBalanceNew employeeBalance =new HrEmployeeBalanceNew();
					
					employeeBalance.setEmp(employee);
					employeeBalance.setLeaveType(hrMasLeaveTypeMediator2);
					employeeBalance.setOpeningBalance(hrMasLeaveType.getAllowedDays());
					employeeBalance.setTaken("0");
					Float currentMonthEarn=new Float(hrMasLeaveType.getAllowedDays())/12;
					System.out.println("currentMonthEarn.toString()"+currentMonthEarn.toString());
					employeeBalance.setEarned(currentMonthEarn.toString());
					employeeBalance.setBalanceAdjustedBy("0");
					employeeBalance.setStatus("y");
					employeeBalance.setLastChgBy(hrMasLeaveType.getLastChgBy());
					employeeBalance.setLastChgDate(hrMasLeaveType.getLastChgDate());
					employeeBalance.setLastChgTime(hrMasLeaveType.getLastChgTime());
					//employeeBalance.setClosingBalance("0");  /*commented by rahul*/
					
					/*  changes Start from here Rahul*/
					if(hrMasLeaveType.getCrFrdable().equals("y")){
						employeeBalance.setOpeningBalanceYearly(hrMasLeaveType.getAllowedDays());
					}else{
						employeeBalance.setOpeningBalanceYearly("0");
					}
					employeeBalance.setClosingBalance(hrMasLeaveType.getAllowedDays());
					employeeBalance.setClosingBalanceYearly(hrMasLeaveType.getAllowedDays());
					employeeBalance.setTotalLeaveTaken("0");
										
					/*  changes done till here Rahul*/
					
					leaveHandlerService.saveEmployeeLeaveBalanceNew(employeeBalance);
				}    

			}
			
		}
		
		List<HrMasLeave> leaveTypeList = leaveHandlerService.getLeaveTypeList();
		
		map.put("masLeaveTypeList",hrMasLeaveTypeNewAllList);
		map.put("leaveTypeList",leaveTypeList);
		
		map.put("message",message);	
		
		String jsp = SHOW_LEAVE_TYPE_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		
	}
	else{
			//System.out.println("again same record ");
			String	message[]=new String[1];
			if(againSameLeaveRecord) {
				message[0] = "You already have this leave type i.e between "+savedFromDate + " To " +savedToDate +" Please apply again !";
					//"javascript:history.back()",
					//"login?method=validate"
			//};
			}
			if(defineAtleastOneForCurrentDate) {
				message[0] = "Define Atleast one record for current Date" ;
			}
			if(jspFromDateLessThanLeastFromDate) {
				
				message[0] = "From Date can't be less than "+savedFromDate ;
			}
			
			List<String> link=new ArrayList<String>();
			
			link.add("Click Here to add record again ");
			link.add("/hms/hms/leave?method=showLeaveTypeMaster");

			map.put("message",message);
			map.put("link",link);
			
			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
		}
		//changes
		//map.put(MAIN, "message.jsp");
			
		return new ModelAndView("index","map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView activateInActivateTypeMaster(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object> map=new HashMap<String,Object>();
		HrMasLeaveTypeNew hrMasLeaveType = new HrMasLeaveTypeNew();
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		int leaveMasTypeId = 0;
		
		if (request.getParameter("leaveTypeId")!= null ) {
			leaveMasTypeId = Integer.parseInt(request.getParameter("leaveTypeId"));
		}

		List<HrMasLeaveTypeNew> leaveTypeForEdit = leaveHandlerService.getMasLeaveTypeListForId(leaveMasTypeId);
		
		List<HrMasLeave> leaveTypeList = leaveHandlerService.getLeaveTypeList();
		List<HrMasLeaveTypeNew> masLeaveTypeList = leaveHandlerService.getMasLeaveTypeNewList();
		
		hrMasLeaveType=leaveTypeForEdit.get(0);
		String status = hrMasLeaveType.getStatus();
		
		if(status.equals("y")) {
			hrMasLeaveType.setStatus("n");
		}
		else {
			hrMasLeaveType.setStatus("y");
		}

		leaveHandlerService.updateLeaveTypeMasterNew(hrMasLeaveType);
		
		leaveTypeForEdit = new ArrayList<HrMasLeaveTypeNew>();
		
		String message = "Leave Type record updated successfully.";
		
		map.put("leaveTypeList",leaveTypeList);
		map.put("masLeaveTypeList",masLeaveTypeList);
		map.put("leaveTypeForEdit",leaveTypeForEdit);
		
		//map.put("link",link);
		
		String jsp = SHOW_LEAVE_TYPE_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message",message);
		
		return new ModelAndView("index","map",map);

	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView updateTypeMaster(HttpServletRequest request,HttpServletResponse response)
	{

		Map<String,Object> map=new HashMap<String,Object>();
		
		HrMasLeaveTypeNew hrMasLeaveType = new HrMasLeaveTypeNew();
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		//List<HrMasLeaveType> hrMasLeaveTypeList = new ArrayList<HrMasLeaveType>();
		
		List<HrMasLeaveTypeNew> hrMasLeaveTypeNewList = new ArrayList<HrMasLeaveTypeNew>();
		//List<HrMasLeaveType> hrMasLeaveTypeAllRec = new ArrayList<HrMasLeaveType>();
		
		Date fromDate = null;
	//	Date toDate = null;
		
		int leaveType = 0;
	//	int allowedDays = 0;
		String encashmentYOrN = "";
		String carryForward = "";
		int encashmentPercentage = 0;
		int leaveMasTypeId = 0;
		String remarks = "";

		Date currentDate = new Date();
		Date jspFromDate = new Date();
		//Date jspToDate = new Date();
		Boolean againSameLeaveRecord = false;
		//Logic for same record
		
		if(request.getParameter(FROM_DATE)!=null && !(request.getParameter(FROM_DATE).equals(""))){
			jspFromDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
		}


		
/*		else if(request.getParameter(FROM_DATE)!=null && (request.getParameter(TO_DATE).equals(""))){
			jspFromDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
			jspToDate=jspFromDate;
		}*/
		
		//System.out.println("in type master method");
	
		if(request.getParameter("leaveTypeIdBaseMas") != null && !request.getParameter("leaveTypeIdBaseMas").trim().equals("")){
			leaveType = Integer.parseInt(request.getParameter("leaveTypeIdBaseMas"));
		}
		
		//hrMasLeaveTypeList = leaveHandlerService.getMasLeaveTypeList(leaveType);
		hrMasLeaveTypeNewList = leaveHandlerService.getMasLeaveTypeNewList(leaveType);

		if (request.getParameter("leaveTypeId")!= null ) {
			leaveMasTypeId = Integer.parseInt(request.getParameter("leaveTypeId"));
		}
		
		
		List<HrMasLeaveTypeNew> hrMasLeaveTypeNewForPrevDate =new ArrayList<HrMasLeaveTypeNew>();
		List<HrMasLeaveTypeNew> leaveTypeForEdit = leaveHandlerService.getMasLeaveTypeListForId(leaveMasTypeId);
		hrMasLeaveType=leaveTypeForEdit.get(0);
		
		Date validFromDate = hrMasLeaveType.getValidFromDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(validFromDate);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date prevDate = calendar.getTime();
		
		hrMasLeaveTypeNewForPrevDate = leaveHandlerService.getMasLeaveTypeNewForMaxDate(leaveType,prevDate);
		
		Date savedToDate = null;
		Date savedFromDate=null;
		
		Boolean defineAtleastOneForCurrentDate = false;
		Boolean recordOverlappingOwnToDate = false;
		if(jspFromDate.compareTo(hrMasLeaveType.getValidToDate())>0) {
			savedToDate = hrMasLeaveType.getValidToDate();
			recordOverlappingOwnToDate=true;
		}
		if(hrMasLeaveTypeNewForPrevDate.size()==0) {
			if(jspFromDate.compareTo(currentDate)>0)
			{
				defineAtleastOneForCurrentDate=true;
				
			}
		}
		//id from jsp;
		
		if(request.getParameter(FROM_DATE)!=null && !"".equals(request.getParameter(FROM_DATE))&& !againSameLeaveRecord){
			for (HrMasLeaveTypeNew leaveRecord :hrMasLeaveTypeNewList) {
				if(leaveRecord.getValidFromDate()!=null ) // && leaveRecord.getId()!=leaveMasTypeId)
				{
					if(leaveRecord.getValidFromDate().compareTo(hrMasLeaveType.getValidFromDate())<0) {
						if(jspFromDate.compareTo(leaveRecord.getValidFromDate())<=0) {
							savedFromDate = leaveRecord.getValidFromDate();
							againSameLeaveRecord = true;
							break;
						}
					}
				}
			}
		}
		
	if(!againSameLeaveRecord && !recordOverlappingOwnToDate && !defineAtleastOneForCurrentDate){
		//List<HrMasLeaveTypeNew> leaveTypeForEdit = leaveHandlerService.getMasLeaveTypeListForId(leaveMasTypeId);
		//hrMasLeaveType=leaveTypeForEdit.get(0);
		
		//System.out.println("Enchament chech box :"+request.getParameter(ENCHASHMENT_CHECK));
		
		if(request.getParameter(TYPE) != null && !request.getParameter(TYPE).trim().equals("")){
			leaveType = Integer.parseInt(request.getParameter(TYPE));
			HrMasLeave hrMasLeave = new HrMasLeave();
			hrMasLeave.setId(leaveType);
			hrMasLeaveType.setLeaveType(hrMasLeave);
			
		}

		if(request.getParameter(ALLOWED_DAYS) != null && !request.getParameter(ALLOWED_DAYS).trim().equals("")){
			//allowedDays = Integer.parseInt(request.getParameter(ALLOWED_DAYS));
			hrMasLeaveType.setAllowedDays(request.getParameter(ALLOWED_DAYS));
		}
		int bufferRequired=0;
		if(request.getParameter(ENCHASHMENT_CHECK) != null){
			encashmentYOrN = request.getParameter(ENCHASHMENT_CHECK);
			hrMasLeaveType.setEncashable(encashmentYOrN);
			if(request.getParameter(ENCHASHMENT) != null && !request.getParameter(ENCHASHMENT).equals("")){
				encashmentPercentage = Integer.parseInt(request.getParameter(ENCHASHMENT));
				hrMasLeaveType.setEncashablePercent(encashmentPercentage);
				hrMasLeaveType.setBufferRequired(0);
			}
			if(request.getParameter("bufferRequired") != null && !request.getParameter("bufferRequired").equals("")){
				
				bufferRequired = new Integer(request.getParameter("bufferRequired"));
				hrMasLeaveType.setBufferRequired(bufferRequired);
				hrMasLeaveType.setEncashablePercent(0);
			}
		}
		else {
			encashmentYOrN = "n";
			hrMasLeaveType.setEncashable(encashmentYOrN);
		}
	
		
		
		
		if(request.getParameter(CARRY_FORWARD) != null){
			carryForward = request.getParameter(CARRY_FORWARD);
			hrMasLeaveType.setCrFrdable(carryForward);
		}
		else {
			carryForward = "n";
			hrMasLeaveType.setCrFrdable(carryForward);
		}
		String halfDayAllow="";
		if(request.getParameter("halfDayAllow") != null){
			halfDayAllow = request.getParameter("halfDayAllow");
			hrMasLeaveType.setHalfDayAllow(halfDayAllow);
		}
		else {
			halfDayAllow = "n";
			hrMasLeaveType.setHalfDayAllow(halfDayAllow);
		}
		
		if(request.getParameter(MONTHLY_OR_YEARLY)!=null)
		{
			if(request.getParameter(MONTHLY_OR_YEARLY).equals("monthly"))
				hrMasLeaveType.setMonthlyOrYearly("m");
			else
				hrMasLeaveType.setMonthlyOrYearly("y");
		}
		else {
			hrMasLeaveType.setMonthlyOrYearly("u");
		}
		
		if(request.getParameter(FROM_DATE) != null && !request.getParameter(FROM_DATE).trim().equals("")){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			hrMasLeaveType.setValidFromDate(fromDate);
			//System.out.println("fromdate in controller :"+fromDate);
		}
		
	/*	if(request.getParameter(TO_DATE) != null && !request.getParameter(TO_DATE).trim().equals("")){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			hrMasLeaveType.setValidToDate(toDate);
			System.out.println("toDate in controller :"+toDate);
		}*/

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(jspFromDate);
		calendar2.add(Calendar.DAY_OF_MONTH, -1);
		
		Date toDateInPlaceOfCurrentToDate = calendar2.getTime();

		
		if(hrMasLeaveTypeNewForPrevDate.size()>0) {
			HrMasLeaveTypeNew hrMasLeaveTypeNew = hrMasLeaveTypeNewForPrevDate.get(0);
			hrMasLeaveTypeNew.setValidToDate(toDateInPlaceOfCurrentToDate);
			leaveHandlerService.updateLeaveTypeMasterNew(hrMasLeaveTypeNew);
		}

		
		if(request.getParameter(REMARKS) != null){
			remarks = request.getParameter(REMARKS);
			hrMasLeaveType.setRemarks(remarks);
		}
		String lastchangeBy = "";
		if (request.getParameter(CHANGED_BY)!= null) {
			lastchangeBy = request.getParameter(CHANGED_BY);
			hrMasLeaveType.setLastChgBy(lastchangeBy);
		}
		Date changedDate = null;
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			changedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			hrMasLeaveType.setLastChgDate(changedDate);
		}
		String	changedTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			changedTime = request.getParameter(CHANGED_TIME);
			hrMasLeaveType.setLastChgTime(changedTime);
		}

		//leaveHandlerService.updateTypeMaster(hrMasLeaveType);
		leaveHandlerService.updateLeaveTypeMasterNew(hrMasLeaveType);

		String message = "Leave Type record updated successfully.";
				//"javascript:history.back()",
				//"login?method=validate"

		map.put("message",message);
		
		
		//int leaveMasTypeId = 0;
		//if (request.getParameter("leaveTypeId")!= null ) {
//			leaveMasTypeId = Integer.parseInt(request.getParameter("leaveTypeId"));
	//	}

		List<HrMasLeave> leaveTypeList = leaveHandlerService.getLeaveTypeList();
		
		List<HrMasLeaveTypeNew> masLeaveTypeList = leaveHandlerService.getMasLeaveTypeNewList();
		//System.out.println("Leave Type in Controller :"+masLeaveTypeList.get(0).getLeaveType().getDescription());
		
		
		List<HrMasLeaveTypeNew> hrMasLeaveTypeNewAllList = new ArrayList<HrMasLeaveTypeNew>();
		List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediator = new ArrayList<HrMasLeaveTypeMediator>();
		
		hrMasLeaveTypeNewAllList = leaveHandlerService.getMasLeaveTypeNewList();
		hrMasLeaveTypeMediator = leaveHandlerService.getMasLeaveTypeMediatorList();

		boolean newRecordFound = true;
		if(hrMasLeaveTypeMediator.size()>0) {
			for(HrMasLeaveTypeNew hrMasLeaveTypeNewAll :hrMasLeaveTypeNewAllList) {
				for(HrMasLeaveTypeMediator hrMasLeaveTypeMediator2 :hrMasLeaveTypeMediator) {
					if(hrMasLeaveTypeMediator2.getLeaveType().getLeaveType().getId()
							==hrMasLeaveTypeNewAll.getLeaveType().getId())
						{
							newRecordFound = false;
							if(hrMasLeaveTypeMediator2.getLeaveType().getId()!=hrMasLeaveTypeNewAll.getId()) {
								// update mediator link
								// save mediator to history
								
								hrMasLeaveTypeMediator2.setLeaveType(hrMasLeaveTypeNewAll);
								leaveHandlerService.updateToHrMasLeaveTypeMediator(hrMasLeaveTypeMediator2);
								
							}
						}
							
					}
				if(newRecordFound) {
					//add to the new record to be added list
					//hrMasLeaveTypeNewRecords.add(hrMasLeaveTypeNewAll);
					newRecordFound=true;
				}
			}
		}else {
			//add to the mediator;
			//save mediator to histroy
			}    

	
		
		//if(hrMasLeaveTypeNewRecords.size()>0) {
			//add all record to mediator
			//save mediator to history
		//}
			

		
		leaveTypeForEdit = new ArrayList<HrMasLeaveTypeNew>();
		
		//leaveTypeForEdit = leaveHandlerService.getMasLeaveTypeListForId(leaveMasTypeId);
		//List<String> link=new ArrayList<String>();
		
		//link.add("Click on the link below to update or to view the records ");
		//link.add("leave?method=showLeaveTypeMaster");

				
		map.put("leaveTypeList",leaveTypeList);
		map.put("masLeaveTypeList",masLeaveTypeList);
		map.put("leaveTypeForEdit",leaveTypeForEdit);
		
		//map.put("link",link);
		
		String jsp = SHOW_LEAVE_TYPE_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message",message);
		
	}
	else{
			
		
		//System.out.println("again same record");
		String	message[] = new String[1];
		
		if(defineAtleastOneForCurrentDate) {
			message[0] = "Define Atleast one record for current Date" ;
		}
		if(againSameLeaveRecord) {
			message[0] = "Applied From Date can't be Less than or Equal to  "+savedFromDate;
		}
		if(recordOverlappingOwnToDate) {
			message[0] = "Applied From Date can't be greater than "+ savedToDate ;
		}
			//"javascript:history.back()",
					//"login?method=validate"
			//};
			List<String> link=new ArrayList<String>();
			
			link.add("Click Here to Try Update again ");
			link.add("leave?method=showLeaveTypeMaster&leaveTypeId="+leaveMasTypeId);

			map.put("message",message);
			map.put("link",link);
			
			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);

		}
		
		//changes
		//map.put(MAIN, "message.jsp");
		
	

		return new ModelAndView("index","map",map);
	}

	public ModelAndView encashLeaves(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object> map=new HashMap<String, Object>();
		Map<String,Object> mapForDs = new HashMap<String, Object>();
		
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();
		mapForDs.put("employeeId", employee.getId());
		
		List<HrEmployeeBalanceNew> encashableMasLeaveType = leaveHandlerService.getEncashableMasLeaveType(employee.getId());
		List<UserManager> managers=leaveHandlerService.getManager(employee.getId());
		map = leaveHandlerService.getUserDetails(mapForDs);
		
		map.put("encashableMasLeaveType",encashableMasLeaveType);
		map.put("managers",managers);
		
		String jsp = ENCASHMENT_LEAVE_FORM;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index","map",map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView applyForEncashment(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object> map=new HashMap<String, Object>();
		HrLeaveDetails hrLeaveDetails=new HrLeaveDetails();

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		HrEncashmentDetails encashmentDetails =new HrEncashmentDetails();
		
		//session=request.getSession(true);
		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();
		
		HrMasLeaveTypeMediator leaveType =new HrMasLeaveTypeMediator();
		leaveType.setId(Integer.parseInt(request.getParameter("leaveIdForDatabase")));
		encashmentDetails.setLeaveType(leaveType);

		HrEmployeeBalanceNew hrUserLeavebalance =new HrEmployeeBalanceNew();
		hrUserLeavebalance.setId(Integer.parseInt(request.getParameter("balanceIdForDatabase")));
		encashmentDetails.setEmpIdBal(hrUserLeavebalance);

		Date currentDate = new Date();
		
		encashmentDetails.setAppliedOn(currentDate);
		
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(currentDate);
		    int enYear = cal.get(Calendar.YEAR);
		    encashmentDetails.setEncashYear(""+enYear);
		if(request.getParameter(LEAVE_TO_ENCASH) != null && !request.getParameter(LEAVE_TO_ENCASH).equals("")){
			encashmentDetails.setLeaveToEncash(request.getParameter(LEAVE_TO_ENCASH));
		}
		//changes
		String managerType = "";
		if(request.getParameter(MANAGER_TYPE)!=null) {
			 managerType = request.getParameter(MANAGER_TYPE);
		}
		int approvedById = 0;
		if(managerType.equalsIgnoreCase("m")){
			approvedById = Integer.parseInt(request.getParameter(APPROVED_BY));
		}else if(managerType.equalsIgnoreCase("o")){
			approvedById = Integer.parseInt(request.getParameter(APPROVED_BY_OTHER));
		}

		MasEmployee approvedBy =new MasEmployee();
		approvedBy.setId(approvedById);
		encashmentDetails.setApprovedBy(approvedBy);

		encashmentDetails.setReason(request.getParameter(REASON));
		
		HrMasLeaveStatus leaveStatus =new HrMasLeaveStatus();
		leaveStatus.setId(3);
		encashmentDetails.setLeaveStatus(leaveStatus);
		
		MasEmployee masEmployee =new MasEmployee();
		masEmployee.setId(employee.getId());
		encashmentDetails.setEmp(masEmployee);
		
		String lastchangeBy = "";
		if (request.getParameter(CHANGED_BY)!= null) {
			lastchangeBy = request.getParameter(CHANGED_BY);
			encashmentDetails.setLastChgBy(lastchangeBy);
		}
		Date changedDate = null;
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			changedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			encashmentDetails.setLastChgDate(changedDate);
		}
		String	changedTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			changedTime = request.getParameter(CHANGED_TIME);
			encashmentDetails.setLastChgTime(changedTime);
		}
		encashmentDetails.setStatus("y");
		
		int hospitalId =0;
		if (session.getAttribute("locationId")!= null) {
			hospitalId = (Integer)session.getAttribute("locationId");
		}

		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		encashmentDetails.setCompany(hospital);
		
		leaveHandlerService.applyForEncashment(encashmentDetails);

		String message="You have successfully applied for the leave encashment.";
				//"javascript:history.back()"
				//"/jktintranet/jkt/login?method=showPage&jspPage=home"
		
		map.put("message",message);
		
		List<HrEmployeeBalance> encashableMasLeaveType = leaveHandlerService.getEncashableMasLeaveType(employee.getId());
		List<UserManager> managers=leaveHandlerService.getManager(employee.getId());
		
		map.put("encashableMasLeaveType",encashableMasLeaveType);
		map.put("managers",managers);

		String jsp = ENCASHMENT_LEAVE_FORM;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index","map",map);
	}

	public ModelAndView printEmployeeLeaveCard(HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session = request.getSession(false);
		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		
		try
		{
			int empId=employee.getId();
		
		parameters.put("EmpId", empId);
		
		Map<String, Object> connectionMap = leaveHandlerService.getConnectionForReport();
		//System.out.println("connectionMap.........."+(Connection)connectionMap.get("con"));
		HMSUtil.generateReport("EmpLeaveCard",parameters,(Connection)connectionMap.get("con"),response, getServletContext());
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
				return null;


	}
	
	public ModelAndView getLeaveListJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map =new HashMap<String, Object>();
		Map<String, Object> mapForDs =new HashMap<String, Object>();
		
		session = request.getSession();
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();
		
		mapForDs.put("employeeId", employee.getId());
		
		String halfday= "";
		if(request.getParameter("half")!=null && !(request.getParameter("half").equalsIgnoreCase("")))
		{
			halfday = (request.getParameter("half"));
			mapForDs.put("halfday", halfday);
		}
		
		map = leaveHandlerService.getLeaveListJsp(mapForDs);
		
		String jsp="hr_leaveTypeList";
		
		String title = "";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showEmpForDept(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map =new HashMap<String, Object>();
		Map<String, Object> mapForDs =new HashMap<String, Object>();
		
		session = request.getSession();
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();
		mapForDs.put("employeeId", employee.getId());
		
		Integer departmentId= 0;
		if(request.getParameter(DEPARTMENT_ID)!=null && !(request.getParameter(DEPARTMENT_ID).equalsIgnoreCase("")))
		{
			departmentId = Integer.parseInt((String)(request.getParameter(DEPARTMENT_ID)));
			mapForDs.put("departmentId", departmentId);
		}
		
		map = leaveHandlerService.showEmpForDept(mapForDs);
		
		String jsp=HR_EMP_ACC_DEPART;
		
		String title = "";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		
		return new ModelAndView(jsp,"map",map);
	}

	
	public ModelAndView showApprovedLeavecancel(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
				
		Users user =(Users)session.getAttribute(USERS);
		MasEmployee employee=user.getEmployee();
		List approvedLeavesCancelList=leaveHandlerService.getApprovedLeavecancelList(employee);
		
		List<HrEncashmentDetails> approvedLeavesEncashment = leaveHandlerService.getApprovedLeavesEncashment(employee);
		Map<String,Object> map=new HashMap<String,Object>();
		
	//	map.put(MAIN,APPROVED_LEAVES_JSP);
	//	map.put(TITLE,"Approved Leaves");

		map.put("approvedLeavesCancelList", approvedLeavesCancelList);
		map.put("approvedLeavesEncashment", approvedLeavesEncashment);
		
		String jsp = "ApproveLeaveCancel";
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView cancelLeaveAfterApprove(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		Map map1=new HashMap();
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		//session=request.getSession(true);
		Users user =(Users)session.getAttribute(USERS);
		String cancel[]=request.getParameterValues("checkbox");
		String remarks="";
		
		MasEmployee employee = user.getEmployee();
		String leaveId="";
		if(request.getParameter("leaveId")!=null)
			leaveId = request.getParameter("leaveId");
		//System.out.println("in cance size >>"+cancel.length);
		//map1.put("leaveId", leaveId);
		map1.put("cancel", cancel);
		map1.put("employee", employee);
		 leaveHandlerService.cancelLeaveAfterApprove(map1);
		
			//List approvedLeavesList=leaveHandlerService.getApprovedLeavesList(employee);
		 List approvedLeavesCancelList=leaveHandlerService.getApprovedLeavecancelList(employee);
			
			List<HrEncashmentDetails> approvedLeavesEncashment = leaveHandlerService.getApprovedLeavesEncashment(employee);
			Map<String,Object> map=new HashMap<String,Object>();
			
		//	map.put(MAIN,APPROVED_LEAVES_JSP);
		//	map.put(TITLE,"Approved Leaves");

			//map.put("approvedLeavesList", approvedLeavesList);
			map.put("approvedLeavesCancelList", approvedLeavesCancelList);
			map.put("approvedLeavesEncashment", approvedLeavesEncashment);
			
			//String jsp = APPROVED_LEAVES_JSP;
			String jsp = "ApproveLeaveCancel";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("msg", "Leave has been cancelled ");

			return new ModelAndView("index","map",map);
	}
	
	
	public void getEncashment(HttpServletRequest request,HttpServletResponse response) {
		//System.out.println("getEncashment in cont");
		String userName = "";
		int deptId = 0;
		List<MasEmployee> EmpList = new ArrayList<MasEmployee>();
		session = request.getSession();
		List<HrEncashmentDetails> hrEncashmentDetails = new ArrayList<HrEncashmentDetails>();
		
		
		// --------------------------------------------------------------------------------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String empId = "";
		String rhLeave="";
		try {
			Users user=(Users)session.getAttribute(USERS);
			MasEmployee employee= user.getEmployee();
			dataMap.put("employeeId", employee.getId());		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		map = leaveHandlerService.getEncashment(dataMap);
	
		if (map.get("hrEncashmentDetails") != null) {
			hrEncashmentDetails = (List<HrEncashmentDetails>) map.get("hrEncashmentDetails");
		}

	
		
		StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			if(hrEncashmentDetails.size()>0){
				sb.append("<encash>yes</encash>");				
				}else{
					sb.append("<encash>no</encash>");
				}	
			sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return new ModelAndView(jsp, "map", map);
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
