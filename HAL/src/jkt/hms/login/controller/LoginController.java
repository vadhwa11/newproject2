/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class LogshoController.java 
 * Purpose of the class - This is for Login. 
 * Tables Used: mas_hospital, mas_application, users 
 * @author  Create Date: July 2007  Name: Ritu Sahu 
 * Revision Date:      		Revision By: 
 * @version 1.0  
 **/

package jkt.hms.login.controller;

import static jkt.hms.util.RequestConstants.HOSPITAL;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.PASSWORD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.login.handler.LoginHandlerService;
import jkt.hms.masters.business.HmsNoticeBoard;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasApplicationgroup;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.LDAPAuthAndSearch;
import jkt.hms.util.RequestConstants;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class LoginController extends MultiActionController {

	private LoginHandlerService loginHandlerService = null;

	// Method for getting hospital list
	@SuppressWarnings("unchecked")
	public ModelAndView getHospitalName(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> userMap = new HashMap<String, Object>();
		String loginName = request.getParameter(LOGIN_NAME);
		String password = request.getParameter(PASSWORD);
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasEmployeeDepartment> deptList = new ArrayList<MasEmployeeDepartment>();
		//List<Users> userList = new ArrayList<Users>();//Only Active Users
		//List<Users> inuserList = new ArrayList<Users>();//All Users
		//hospitalList = loginHandlerService.getHospitalName(loginName, password);
		List<MasApplicationgroup> applicationgroupList = new ArrayList<MasApplicationgroup>();
		Map<String, Object> hospMap = new HashMap<String, Object>();
		
		/**
		 * LDAP Authentication
		 */
		String jsp = "";
		String title = "";
		String message = "";

		boolean ldapValidate = false;
	/*	if(!loginName.equalsIgnoreCase("jktuser")){
			ldapValidate = LDAPAuthAndSearch.getAuthentcateUserAndPwd(loginName, password);
		}else if(loginName.equalsIgnoreCase("jktuser")){*/
			ldapValidate = true;
		//}
		if(ldapValidate){
			hospMap = loginHandlerService.getHospitalName(loginName, password);
			if(hospMap.get("hospitalList")!=null){
				hospitalList=(List<MasHospital>)hospMap.get("hospitalList");
			}
			Users user=new Users();
			if(hospMap.get("user")!=null){
				user=(Users)hospMap.get("user");
			}



			map.put("loginName", loginName);
			map.put("user", user);
			deptList = loginHandlerService.getDepartmentList(map);
			List <MasCommand> commandList=new ArrayList<MasCommand>();
			commandList=loginHandlerService.showLoginJsp();
			/*
			 * userMap = loginHandlerService.getUserList(map);
			 * Commented By Mukesh 05 Apr 2012
			 */
			//userMap = loginHandlerService.getUserList(map);
			map = loginHandlerService.getGroupName(loginName);
			applicationgroupList = (List)map.get("applicationgroupList");
			//int id =0;
			String groupName = "";
			String status="";
			if(map.get("groupName")!= null){
				groupName = (String)map.get("groupName");
			}
			if(hospMap.get("status")!=null){
				status=(String)hospMap.get("status");
			}

			/*
			 * subChargeCodeList = loginHandlerService.getSubChargeList();
			 */
			/*
			 * inuserList and userList
			 * Commented By Mukesh 05 Apr 2012
			 */
			//inuserList = (List) userMap.get("inaUserList");
			//userList = (List) userMap.get("userList");
			String userStatus="";
			if(user!=null){
				userStatus=user.getStatus();
			}
			/*List<Users> userList = new ArrayList<Users>();//Only Active Users
		List<Users> inuserList = new ArrayList<Users>();//All Users
			 */		
			
			if(status!=null){
				if(!status.equals("")){
					if(status.equalsIgnoreCase("y")){
						System.out.println("hospitallist&deptlist"+hospitalList.size()+" "+deptList.size() );
						if (hospitalList.size() > 0 && deptList.size() > 0) {
							session.setAttribute("loginName", loginName);
							session.setAttribute("password", password);
							map.put("loginName", loginName);
							map.put("password", password);
							map.put("hospitalList", hospitalList);
							map.put("deptList", deptList);
							map.put("applicationgroupList", applicationgroupList);
							map.put("commandList", commandList);
							// map.put("subChargeCodeList", subChargeCodeList);
						} else {
							
							message = "Wrong User name or Password";
							map.put("error", message);
						}
					}else if(status.equalsIgnoreCase("n")){
						message = "User has been disabled contact IT centre";
						map.put("error", message);
					}
				}else{
					message =  "Your profile not yet created. Please contact administrator.";
					map.put("error", message);
				}
			}else{
				message = "Wrong User name or Password";
				map.put("error", message);
			}

		
		}else{
			message = "Authentication Failed.";
			map.put("error", message);
		}
		/*
    	 * This  complete Block
    	 * Commented By Mukesh 05 Apr 2012
    	 */
		/*if (inuserList.size() > 0) {
			if (userList.size() > 0) {
				if (hospitalList.size() > 0 && deptList.size() > 0) {
					session.setAttribute("loginName", loginName);
					session.setAttribute("password", password);
					map.put("loginName", loginName);
					map.put("password", password);
					map.put("hospitalList", hospitalList);
					map.put("deptList", deptList);
					map.put("applicationgroupList", applicationgroupList);
					map.put("commandList", commandList);
					// map.put("subChargeCodeList", subChargeCodeList);
				} else {
					message = "Wrong User name or Password";
					map.put("error", message);
				}
			} else {
				message = "User has been disabled contact IT centre";
				map.put("error", message);
			}
		} else {
			message = "Wrong User name or Password";
			map.put("error", message);
		}*/
//if(groupName.equalsIgnoreCase("Administrator")){
	//	jsp = "responseForHospitalWithGroup";
//}else{
	jsp = "responseForHospital";
//}
		map.put("jsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView getPassword(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> userMap = new HashMap<String, Object>();
		String loginName = request.getParameter(LOGIN_NAME);
		map =  loginHandlerService.getPassword(loginName);
	
		return new ModelAndView("getPassword", "map", map);
	}

	// Method for authenticate user at login
@SuppressWarnings("unchecked")
	public ModelAndView validate(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
    	String SessrfToken = "";
    	String ReqcsrfToken = "";
    	if(session.getAttribute("csrfToken") != null ){
    		SessrfToken = (String) session.getAttribute("csrfToken");
        	 ReqcsrfToken = request.getParameter("csrfToken");
    		
    	}else{
    		String csrfToken = UUID.randomUUID().toString();
   		 System.out.println(">>>csrfToken>>>>>"+csrfToken);
   		    	session.setAttribute("csrfToken", csrfToken);
    	}
    	
    	System.out.println(ReqcsrfToken+"<<<in validate method>>"+SessrfToken);
		int hospitalId = 0;

		Set<MasApplication> applicationSet = null;
		if (request.getParameter(HOSPITAL) != null)
			hospitalId = (Integer.parseInt(request.getParameter(HOSPITAL)));

		int deptId = 0;
		if (request.getParameter(RequestConstants.DEPARTMENT_ID) != null) {
			deptId = Integer.parseInt(request
					.getParameter(RequestConstants.DEPARTMENT_ID));
		}
		int groupId =0;
		if (request.getParameter("group") != null) {
			groupId = Integer.parseInt(request.getParameter("group"));
		}
		/**
		 * Added By Ritu on 12th April 2011
		 */
		int commandId = 0;
		if (request.getParameter(RequestConstants.COMMAND) != null) {
			commandId = Integer.parseInt(request.getParameter(RequestConstants.COMMAND));
		}
		session.setAttribute("commandId", commandId);
		/**
		 * End
		 */

		String loginName=request.getParameter(LOGIN_NAME);
		String password=request.getParameter(PASSWORD);
		String jsp = "";
		String title = "";
		String message = "";
		if (loginName.equalsIgnoreCase("superadmin")) {
			// jsp=Super_Admin;
			jsp = "SuperAdminMenu";
			title = "Admin Creation Page";

		} else {
			List<Object> existingUserList = new ArrayList<Object>();
			List<HmsNoticeBoard> noticeBoardList = new ArrayList<HmsNoticeBoard>();
			String notice = "";
			/**
			 * For LDAP Authentication
			 */
			
			
			boolean ldapValidate = false;
			//if(!loginName.equalsIgnoreCase("jktuser")){
		//		ldapValidate = LDAPAuthAndSearch.getAuthentcateUserAndPwd(loginName, password);
			//}else if(loginName.equalsIgnoreCase("jktuser")){
				ldapValidate = true;
			//}
			if(ldapValidate){
			
			existingUserList = loginHandlerService.getExistingUser(loginName,password);
		//	session.setAttribute("hospitalName", ((Users) existingUserList.get(0)).getEmployee().getHospital().getHospitalName());
			noticeBoardList = (List) loginHandlerService.getNoticeMessage();
			if (existingUserList.size() > 0) {
				/*
				 * for (Iterator iterator = existingUserList.iterator();
				 * iterator.hasNext();) { Object[] object = (Object[])
				 * iterator.next(); Users users = (Users)object[1];
				 */
							
				Users users = (Users) existingUserList.get(0);
				String userName = users.getUserName();
				//int userId = users.getEmployee().getId();
				int userId = users.getId();
				int empId = users.getEmployee().getId();
				Map<String, Object> empMap = new HashMap<String, Object>();
				empMap.put("userId", userId);
				empMap.put("empId", empId);
				/**
				 * Added by ritu
				 * For HIC 
				 * Date
				 * 
				 *  18-12-2012
				 */
				
                
				
				
				List<MasEmployee> empList = new ArrayList<MasEmployee>();
				empList = loginHandlerService.getEmployeeDetails(empMap);
				if(empList.size() > 0){
					session.setAttribute("userSrNo", empList.get(0).getServiceNo());
					session.setAttribute("empName", empList.get(0).getFirstName()+" "+(empList.get(0).getMiddleName()!=null?empList.get(0).getMiddleName():"")+" "+(empList.get(0).getLastName()!=null?empList.get(0).getLastName():""));
					session.setAttribute("unitName", (empList.get(0).getUnit()!=null?empList.get(0).getUnit().getUnitName():""));
					session.setAttribute("divisionId", empList.get(0).getDivision().getId());
				}
				/**
				 * End
				 */
				int id =users.getId();
				String loginUser = users.getLoginName();
				session.setAttribute("loginUser", loginUser);
				session.setAttribute("userName1", userName);
				session.setAttribute("userName", loginUser);
				session.setAttribute("users", users);
				session.setAttribute("deptId", deptId);
				session.setAttribute("userId", userId);
				session.setAttribute("empId", empId);
				session.setAttribute("userIp", request.getRemoteAddr());
				session.setAttribute("id", id);
				
				System.out.println("dss" + session.getAttribute("empId") + session.getAttribute("userId"));
				storeUserNameIp(loginUser,request.getRemoteAddr(),session);
				// ///////////////notice board
				if (noticeBoardList != null && noticeBoardList.size() > 0) {
					notice = (String) noticeBoardList.get(0).getDesc();
				}
				session.setAttribute("notice", notice);
				// ///////////////notice board
				/*
				 * put department name in session to display department in
				 * header.jsp Modified by K.R. Othivadivel, 22 May 2008.
				 */

				/*
				 * This Code Commented By Mukesh Date 05 Apr 2012
				 * session.setAttribute("deptName"
				 * session.setAttribute("deptType"
				 */
				/*session.setAttribute("deptName", loginHandlerService.getDepartmentName(deptId));
				session.setAttribute("deptType", loginHandlerService.getDepartmentTypeCode(deptId));*/
				/*
				 * Code By Mukesh 05 Apr 2012
				 */
				Map<String, Object> mapHospData = new HashMap<String, Object>();
				Map<String, Object> hospMap= new HashMap<String, Object>();
				mapHospData.put("deptId", deptId);
				mapHospData.put("hospitalId", hospitalId);
				hospMap=loginHandlerService.getDepartmentDetails(mapHospData);
				List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
				if(hospMap.get("masDepartmentList")!=null){
					masDepartmentList=(List<MasDepartment>)hospMap.get("masDepartmentList");
				}
				String deptName="";
				String deptType = "";
				String deptCode = "";
				if (masDepartmentList!=null && masDepartmentList.size()>0){
					deptName = masDepartmentList.get(0).getDepartmentName();
					deptType = masDepartmentList.get(0).getDepartmentType().getDepartmentTypeCode();
					deptCode = masDepartmentList.get(0).getDepartmentCode();
				}
				session.setAttribute("deptName", deptName);
				session.setAttribute("deptType", deptType);
				session.setAttribute("deptCode", deptCode);
				
				/**
				 * hospital name to display in header
				 * By Ritu 02 Apr 2012
				 */
				session.setAttribute("hospitalName", loginHandlerService.getLoginHospitalName(hospitalId));
              // map = (Map)loginHandlerService.getGroupName(loginName);
               if(map.get("groupId")!= null){
            	   groupId = (Integer)map.get("groupId");
               }
				jsp = "index";
				title = "Home Page";
				map.put("applicationSet", existingUserList);
				session.setAttribute(HOSPITAL_ID, hospitalId);
				session.setAttribute("groupId", groupId);
				applicationSet = loginHandlerService.getApplications(users,hospitalId,groupId);
				session.setAttribute("applicationSet", applicationSet);
			} else {
				message = "Wrong User name or Password";
				map.put("error", message);
				jsp = "login";
				title = "Login";
			}
		} else {
			message = "AFNET AD Authentication Failed.";
			map.put("error", message);
			jsp = "login";
			title = "Login";
		}// LDAP LOOP
		}
		
        String test = HMSUtil.createFileAndFolder(request);
		map.put("jsp", jsp);
		map.put("title", title);
		map.put("applicationSet", applicationSet);
		System.out.println("end---");
		return new ModelAndView(jsp, "map", map);
		/*if(SessrfToken.equals(ReqcsrfToken))
	    	{
		
		return new ModelAndView(jsp, "map", map);
	    	}
		else if ( SessrfToken != null){
		jsp="error";
		   return new ModelAndView(jsp, "map", map);
		}*/
	}
	public void storeUserNameIp(String UserName , String UserIp ,HttpSession session){
		Map<String,String> userlogin = new HashMap<String,String>();
		List<String> UserNameList = new ArrayList<String>();
		List<String> UserIpList = new ArrayList<String>();
		List<String> SessionIdList = new ArrayList<String>();
		ServletContext sc = getServletContext();
		if(sc.getAttribute("UserNameList")!=null)
		{
			UserNameList=(List<String>)sc.getAttribute("UserNameList");
		}
		if(sc.getAttribute("UserIpList")!=null){
			UserIpList=(List<String>)sc.getAttribute("UserIpList");
		}
		if(sc.getAttribute("SessionIdList")!=null){
			SessionIdList=(List<String>)sc.getAttribute("SessionIdList");
		}
		UserNameList.add(UserName);
		UserIpList.add(UserIp);
		SessionIdList.add(session.getId());
		sc.setAttribute("UserNameList", UserNameList);
		sc.setAttribute("UserIpList", UserIpList);
		sc.setAttribute("SessionIdList", SessionIdList);
	}

	public void getNoticeData(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<HmsNoticeBoard> noticeBoardList = new ArrayList<HmsNoticeBoard>();
		noticeBoardList = (List) loginHandlerService.getNoticeMessage();

		StringBuffer sb = new StringBuffer();
		if (noticeBoardList != null && noticeBoardList.size() > 0) {
			String notice = noticeBoardList.get(0).getDesc();
			if (notice != null && !notice.equals("")) {
				sb.append("<desc>" + notice + "</desc>");
			} else {
				sb.append("<desc>" + "nodesc" + "</desc>");
			}
		} else {
			sb.append("<desc>" + "nodesc" + "</desc>");
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<notice>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</notice>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return new ModelAndView("loginPage");
	}
	
	public ModelAndView forgetPassword(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return new ModelAndView("forgetPassword");
	}

	// End of Code by Ritu

	// Database server testing purpose no use Added by kalyan

	public ModelAndView servertest(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = "servertest.jsp";
		map.put("servertestStart", "n");
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addingNew(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean status = loginHandlerService.addingNew();
		String jsp = "servertest.jsp";
		map.put("servertestStart", "y");
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

    public ModelAndView showUserNameAndIp(HttpServletRequest request , HttpServletResponse response){
    	Map<String,Object> map = new HashMap<String,Object>();
    	List<String> UserNameList = null;
		List<String> UserIpList = null;
		List<String> SessionIdList = null;
		ServletContext sc = getServletContext();
    	if(sc.getAttribute("UserNameList")!=null)
		{
			UserNameList=(List<String>)sc.getAttribute("UserNameList");
		}
		if(sc.getAttribute("UserIpList")!=null){
			UserIpList=(List<String>)sc.getAttribute("UserIpList");
		}
		if(sc.getAttribute("SessionIdList")!=null){
			SessionIdList=(List<String>)sc.getAttribute("SessionIdList");
		}
		
    	map.put("UserNameList",UserNameList);
    	map.put("UserIpList",UserIpList);
    	map.put("SessionIdList",SessionIdList);
    	
    	String jsp = "UserNameAndIp.jsp" ;
    	map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
       	
    }
	// END Database server

    
    public ModelAndView showLoginJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	HttpSession session = request.getSession();
    	String SessrfToken = (String) session.getAttribute("csrfToken");
    	System.out.println("showLoginJsp method"+SessrfToken);
    	String ReqcsrfToken = request.getParameter("csrfToken");
    	map.put("csrfToken", ReqcsrfToken);
    	//if(SessrfToken.equals(ReqcsrfToken))
    	return new ModelAndView("loginNew", "map", map);
    	/*else
    	return new ModelAndView("error", "map", map);*/
   
	}
    
    public ModelAndView showInstructionJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	HttpSession session = request.getSession();
 String csrfToken = UUID.randomUUID().toString();
 System.out.println(">>>csrfToken>>>>>"+csrfToken);
    	session.setAttribute("csrfToken", csrfToken);
    	
    	return new ModelAndView("instruction", "map", map);
   
	}
    
    public ModelAndView showModuleDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", HMSUtil.restrictMetaChar(request.getParameter("moduleName")));
    	HttpSession session = request.getSession();
		session.setAttribute("appId", HMSUtil.restrictMetaChar(request.getParameter("appId")));
		;
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    
    public ModelAndView showHomeJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		return new ModelAndView("index", "map", map);
	}

    
	public LoginHandlerService getLoginHandlerService() {
		return loginHandlerService;
	}

	public void setLoginHandlerService(LoginHandlerService loginHandlerService) {
		this.loginHandlerService = loginHandlerService;
	}
	
    public ModelAndView showReceptionDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Reception");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A3");
    	String jsp = "moduleDefault";
    	String SessrfToken = (String) session.getAttribute("csrfToken");
    	String ReqcsrfToken = request.getParameter("csrfToken");
    	map.put("csrfToken", ReqcsrfToken);
    	
    	if(SessrfToken.equals(ReqcsrfToken))
    		return new ModelAndView(jsp, "map", map);
        	else
        	return new ModelAndView("error", "map", map);
	}
    public ModelAndView showOPDDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "OPD");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A332");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showDispensaryDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Dispensary");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A366");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}

    public ModelAndView showStoresDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Stores");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A89");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showLabDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Lab");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A328");
    	String jsp = "moduleDefault";
    	
    	String SessrfToken = (String) session.getAttribute("csrfToken");
    	String ReqcsrfToken = request.getParameter("csrfToken");
    	map.put("csrfToken", SessrfToken);
    	if(SessrfToken.equals(ReqcsrfToken))
    	return new ModelAndView(jsp, "map", map);
    	else
    		return new ModelAndView("error", "map", map);
    	
	}
    public ModelAndView showLaborDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Labor Room");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A1562");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showMedExamDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "MedicalExam");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A927");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showStatsDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Stn Health Statistics");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A112");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showWardDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Ward");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A105");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showReferralDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Referral");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A1682");
		
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showAviationDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "AviationMedicine");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A1110");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showDentalDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Dental");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A1109");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showSHODefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "SHO");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A985");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showFWCDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "FamilyWelfareCenter");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A989");
    	String jsp = "moduleDefault";
    	String SessrfToken = (String) session.getAttribute("csrfToken");
    	String ReqcsrfToken = request.getParameter("csrfToken");
    	if(SessrfToken.equals(ReqcsrfToken))
    	return new ModelAndView(jsp, "map", map);
    	else
    	return new ModelAndView(jsp, "map", map);
	}
    
    public ModelAndView showMastersDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Masters");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A2");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    
    public ModelAndView showEmergencyDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "EmergencyRoom");
    	HttpSession session = request.getSession();
//    	session.setAttribute("appId", "A1142"); // DIT
		session.setAttribute("appId", "A1155"); // Local
//    	session.setAttribute("appId", "A1180"); // IEW
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showRadioDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Radiodiagnosis");
    	HttpSession session = request.getSession();
//    	session.setAttribute("appId", "A1161"); // DIT
		session.setAttribute("appId", "A1157"); // Local
//    	session.setAttribute("appId", "A1178"); // IEW
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showECGDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "ECG");
    	HttpSession session = request.getSession();
//    	session.setAttribute("appId", "A1160"); // DIT
		session.setAttribute("appId", "A1169"); // Local
//    	session.setAttribute("appId", "A1179"); // IEW
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showMonitoringDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Monitoring");
    	HttpSession session = request.getSession();
//    	session.setAttribute("appId", "A1180"); // DIT
    	session.setAttribute("appId", "A1216"); // Local
//    	session.setAttribute("appId", "A1162"); // IEW
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    
    public ModelAndView showWardPharmacyDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Ward Pharmacy");
    	HttpSession session = request.getSession();
//    	session.setAttribute("appId", "A1180"); // DIT
    	session.setAttribute("appId", "A1587"); // Local
//    	session.setAttribute("appId", "A1162"); // IEW
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    public ModelAndView showAdminDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Admin");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A324"); // 
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    
    public ModelAndView showAccountsDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Accounts");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A1913"); // 
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    
    public ModelAndView showPayrollDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Payroll");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A1914"); // 
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    
    public ModelAndView showOTDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "OT");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A541");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
    
    public ModelAndView showBillingDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleName", "Billing");
    	HttpSession session = request.getSession();
		session.setAttribute("appId", "A1");
    	String jsp = "moduleDefault";
    	return new ModelAndView(jsp, "map", map);
	}
}