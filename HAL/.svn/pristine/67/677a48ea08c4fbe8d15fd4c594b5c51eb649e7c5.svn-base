package jkt.security.masters.controller;

import static jkt.hms.util.RequestConstants.ADDRESS;
import static jkt.hms.util.RequestConstants.APPLICATION_ID;
import static jkt.hms.util.RequestConstants.APPLICATION_NAME;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.CONTACT_NUMBER;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_NAME;
import static jkt.hms.util.RequestConstants.EMAIL_ID;
import static jkt.hms.util.RequestConstants.EMPLOYEE_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.FIRST_NAME;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.GROUP_APP_ID;
import static jkt.hms.util.RequestConstants.GROUP_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_MASTER_JSP;
import static jkt.hms.util.RequestConstants.HOSPITAL_NAME;
import static jkt.hms.util.RequestConstants.LAST_NAME;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.MODULE_MANAGEMENT_JSP;
import static jkt.hms.util.RequestConstants.OT_ID;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.SEARCH_AND_EDIT_APPLICATION;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.STATUS;
import static jkt.hms.util.RequestConstants.SURGERY_DATE;
import static jkt.hms.util.RequestConstants.TELL_NO_OFFICE;
import static jkt.hms.util.RequestConstants.TITLE_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.URL;
import static jkt.hms.util.RequestConstants.USER_APPLICATION_JSP;
import static jkt.hms.util.RequestConstants.USER_DEPARTMENT_JSP;
import static jkt.hms.util.RequestConstants.USER_GROUP_HOSPITAL_JSP;
import static jkt.hms.util.RequestConstants.USER_GROUP_ID;
import static jkt.hms.util.RequestConstants.USER_GROUP_JSP;
import static jkt.hms.util.RequestConstants.USER_GROUP_NAME;
import static jkt.hms.util.RequestConstants.USER_HOSPITAL_MAINTENANCE_JSP;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.USER_JSP;
import static jkt.hms.util.RequestConstants.USER_NAME;
import static jkt.hms.util.RequestConstants.VALID_DATE;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.appointment.handler.AppointmentHandlerService;
import jkt.hms.masters.business.AnswerFaq;
import jkt.hms.masters.business.AssignParentToApplicationgroup;
import jkt.hms.masters.business.Complain;
import jkt.hms.masters.business.EmpGroups;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasApplicationgroup;
import jkt.hms.masters.business.MasButtonForm;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasTemplate;
import jkt.hms.masters.business.QuestionFaq;
import jkt.hms.masters.business.StoreInternalReturnM;
import jkt.hms.masters.business.TemplateApplication;
import jkt.hms.masters.business.UserApplications;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.UserEmpGroup;
import jkt.hms.masters.business.UserGroups;
import jkt.hms.masters.business.UserTemplate;
import jkt.hms.masters.business.UserUsergroupHospital;
import jkt.hms.masters.business.UsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.security.masters.handler.SuperAdminMasterHandlerService;
import jkt.security.masters.handler.UserMasterHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import securityenc.EncryptPwd;

@SuppressWarnings("unchecked")
public class UserMasterController extends MultiActionController {

	String jsp = "";
	List hospitalList = null;
	List employeeList = null;
	List userList = null;
	Map map = null;
	HttpSession session = null;
	String title = "";
	String message = "";
	String url = "";
	UserMasterHandlerService userMasterHandlerService = null;

	
	String code = "";
	String name = "";
	String currentDate = "";
	String currentTime = "";
	String changedBy = "";
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";

	CommonMasterHandlerService commonMasterHandlerService = null;
	SuperAdminMasterHandlerService superAdminMasterHandlerService = null;
	AppointmentHandlerService appointmentHandlerService = null;
	

	Map<String, Object> generalMap = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	// ---------------------------------------User By Mansi
	// ---------------------------------//
	public ModelAndView searchUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String loginName = null;
		if (request.getParameter(LOGIN_NAME) != null
				&& !(request.getParameter(LOGIN_NAME).equals(""))) {
			loginName = request.getParameter(LOGIN_NAME).trim();
		}

		session = request.getSession(true);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		map = userMasterHandlerService.searchUser(loginName, hospitalId);
		jsp = USER_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("loginName", loginName);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView showUserJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		map = userMasterHandlerService.showUserJsp(hospitalId);
		String jsp = USER_JSP;
		jsp += ".jsp";
		title = "User";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUser(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Users users = new Users();
		int employeeId = 0;
		String password = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		//String loginName = "";
		String userName = "";
		String firstName="";
		String lastName="";
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
/*
		if (request.getParameter(LOGIN_NAME) != null) {
			loginName = request.getParameter(LOGIN_NAME);
		}*/
		if (request.getParameter(SEARCH_NAME) != null) {
			userName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("employeeName") != null) {
			firstName = request.getParameter("employeeName");
		}
		if (request.getParameter("lastName") != null) {
			lastName = request.getParameter("lastName");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(RequestConstants.EMPLOYEE_ID) != null) {
			employeeId = Integer.parseInt(request
					.getParameter(RequestConstants.EMPLOYEE_ID));

		}
		if (request.getParameter(RequestConstants.PASSWORD) != null) {
			password = request.getParameter(RequestConstants.PASSWORD);
		}
	
	
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}

		generalMap.put("code", userName);
		generalMap.put("userName", userName);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List userLoginNameList = new ArrayList();
		List userNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			userLoginNameList = (List) listMap.get("duplicateGeneralCodeList");
		}
		/*
		 * if(listMap.get("duplicateGeneralNameList") != null){ userNameList =
		 * (List)listMap.get("duplicateGeneralNameList"); }
		 */
		int counterMenu=0;
		if (request.getParameter("counterMenu") != null	&& !(request.getParameter("counterMenu").equals(""))) 
		{
			counterMenu= Integer.parseInt(""+request.getParameter("counterMenu"));
		}
		List<Integer> templetIdList=new ArrayList<Integer>();
		try 
		{
			if(counterMenu>0)
			{
				for (int ct = 1; ct <=counterMenu; ct++) 
				{
					int templetId=0;
					if (request.getParameter("templetId"+ct) != null) 
					{
						templetId= Integer.parseInt(""+request.getParameter("templetId"+ct));
					}
					if(templetId>0)
					{
						templetIdList.add(templetId);
					}
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		map.put("hospitalId", hospitalId);
		map.put("templetIdList", templetIdList);
		
		map.put("changedBy", changedBy);
		map.put("currentDate", currentDate);
		map.put("currentTime", currentTime);
		
		map.put("templetIdList", templetIdList);
		boolean successfullyAdded = false;
		UserEmpGroup userEmpGroup = new UserEmpGroup();
		if ((userLoginNameList.size() == 0 || userLoginNameList == null)
				&& (userNameList.size() == 0 || userNameList == null)) {
			users.setLoginName(userName);
			users.setUserName(userName);
			users.setFirstName(firstName);
			users.setLastName(lastName);
			users.setStatus("y");
			users.setLastChgBy(changedBy);
			users.setLastChgDate(currentDate);
			users.setLastChgTime(currentTime);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			users.setEmployee(masEmployee);
			users.setPassword(HMSUtil.encryptPassword(password));
			// passwordDecoded = Base64.encode(password.getBytes());
			// users.setPassword(password);
			//users.setPassword(HMSUtil.encryptPassword(password));
			try {
				users.setPassword(EncryptPwd.SHA1(password));
				users.setStatusSHA1("y");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				successfullyAdded = userMasterHandlerService.addUser(users,map);
			
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((userLoginNameList.size() != 0 || userLoginNameList != null)
				|| (userNameList.size() != 0) || userNameList != null) {
			if ((userLoginNameList.size() != 0 || userLoginNameList != null)
					&& (userNameList.size() == 0 || userNameList == null)) {

				message = "Login Name already exists.";
			}
			
		}

		try {
			map = userMasterHandlerService.showUserJsp(hospitalId);

		} catch (Exception e) {
e.printStackTrace();		}
		jsp = USER_JSP;
		title = "Add User ";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editUser(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		//String loginName = "";
		String userName = "";
		int userId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String firstName="";
		String lastName="";
		
		int employeeId = 0;
		String password = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
	/*	if (request.getParameter(LOGIN_NAME) != null
				&& !(request.getParameter(LOGIN_NAME).equals(""))) {
			loginName = request.getParameter(LOGIN_NAME);
		}*/
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			userName = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter("employeeName") != null) {
			firstName = request.getParameter("employeeName");
		}
		if (request.getParameter("lastName") != null) {
			lastName = request.getParameter("lastName");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(RequestConstants.EMPLOYEE_ID) != null) {
			employeeId = Integer.parseInt(request
					.getParameter(RequestConstants.EMPLOYEE_ID));

		}
		
		  if (request.getParameter(RequestConstants.PASSWORD) != null) {
		  password = request.getParameter(RequestConstants.PASSWORD); }
		 
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", userId);
		generalMap.put("lastName", lastName);
		generalMap.put("firstName", firstName);
		//generalMap.put("loginName", loginName);
		generalMap.put("name", userName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		 generalMap.put("password", password);
		generalMap.put("employeeId", employeeId);
	
		generalMap.put("hospitalId", hospitalId);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		boolean dataUpdated = false;

		dataUpdated = userMasterHandlerService.editUserToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}/*
		 * List existingUserNameList =
		 * (List)listMap.get("duplicateMastersList"); boolean dataUpdated=false;
		 * if(existingUserNameList.size() == 0) {
		 * dataUpdated=userMasterHandlerService.editUserToDatabase(generalMap);
		 * 
		 * if(dataUpdated==true){ message="Data updated Successfully !!"; }
		 * else{ message="Data Cant Be Updated !!"; } } else
		 * if(existingUserNameList.size() > 0){ message =
		 * "Name already exists."; }
		 */
		url = "/security/security/user?method=showUserJsp";

		try {
			map = userMasterHandlerService.showUserJsp(hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_JSP;
		title = "update User";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteUser(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int userId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute("hospitalId");

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteUser(userId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/security/security/user?method=showUserJsp";

		try {
			map = userMasterHandlerService.showUserJsp(hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_JSP;
		title = "delete UserGroups";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * public ModelAndView showUserJsp(HttpServletRequest request,
	 * HttpServletResponse response) { Map map = new HashMap();
	 * 
	 * hospitalList = new ArrayList(); employeeList = new ArrayList();
	 * 
	 * employeeList = (List) userMasterHandlerService.getEmployeeList();
	 * hospitalList = (List) userMasterHandlerService.getHospitalList();
	 * userList=(List)userMasterHandlerService.getUserList();
	 * 
	 * map = userMasterHandlerService.showUserJsp();
	 * 
	 * 
	 * String jsp=USER_JSP; jsp += ".jsp"; title = "User";
	 * map.put("hospitalList", hospitalList); map.put("employeeList",
	 * employeeList); map.put("userList", userList); map.put("contentJsp", jsp);
	 * map.put("title", title); return new
	 * ModelAndView("SuperAdminMenu","map",map);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * addUser(HttpServletRequest request, HttpServletResponse response) throws
	 * ParseException { String message=null;
	 * 
	 * @SuppressWarnings("unused")
	 * 
	 * String loginName = null; String userName = null; String employeeCode
	 * =null; String password = null; String loginNameTemp=null; String
	 * employeeCodeTemp=null; Date currentDate = new Date(); jsp = USER_JSP;
	 * title="User Master"; Users users=new Users();
	 * 
	 * 
	 * if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
	 * loginName = request.getParameter(RequestConstants.LOGIN_NAME);
	 * loginName=loginName.trim(); } if
	 * (request.getParameter(RequestConstants.USER_NAME) != null) { userName =
	 * request.getParameter(RequestConstants.USER_NAME); } if
	 * (request.getParameter(RequestConstants.EMPLOYEE_CODE) != null) {
	 * employeeCode = request.getParameter(RequestConstants.EMPLOYEE_CODE);
	 * 
	 * } if (request.getParameter(RequestConstants.PASSWORD) != null) { password
	 * = request.getParameter(RequestConstants.PASSWORD); }
	 * if(request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); }
	 * if(request.getParameter(CHANGED_DATE) != null &&
	 * !(request.getParameter(CHANGED_DATE).equals(""))){ currentDate =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null &&
	 * !(request.getParameter(CHANGED_TIME).equals(""))){ currentTime =
	 * request.getParameter(CHANGED_TIME); }
	 * 
	 * 
	 * userList=new ArrayList();
	 * userList=(List)userMasterHandlerService.getUserList(); String
	 * loginNameUpper=null; if(userList.size() != 0 || userList != null) for
	 * (Iterator iter = userList.iterator(); iter.hasNext();) { Users
	 * userListObj = (Users) iter.next();
	 * loginNameTemp=(String)userListObj.getLoginName();
	 * loginNameTemp=loginNameTemp.toUpperCase();
	 * loginNameUpper=loginName.toUpperCase();
	 * employeeCodeTemp=(String)userListObj.getEmployeeCode();
	 * 
	 * if(loginNameTemp!=null) if(loginNameUpper.equals(loginNameTemp) ||
	 * loginNameUpper==loginNameTemp) { map =
	 * userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Login Name Already Exists"; map.put("message", message);
	 * title="User Master"; map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map); } if(!employeeCode.equals("select"))
	 * if(employeeCode.equals(employeeCodeTemp)||
	 * employeeCode==employeeCodeTemp) { map =
	 * userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Employee Code Already Mapped"; map.put("message",
	 * message); title="User Master"; map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map); } }
	 * 
	 * users.setLoginName(loginName); users.setUserName(userName);
	 * if(!employeeCode.equals("select")) users.setEmployeeCode(employeeCode);
	 * users.setPassword(password); users.setStatus("y");
	 * 
	 * users.setLastChgBy(changedBy); users.setLastChgDate(currentDate);
	 * users.setLastChgTime(currentTime); Boolean flag=false;
	 * flag=userMasterHandlerService.addUser(users); if(flag==true) { map =
	 * userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Record Added Successfully"; map.put("message", message);
	 * title="User Master"; map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map);
	 * 
	 * }else{ map = userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Record Not Added "; title="User Master";
	 * map.put("message", message); map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map);
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * showUpdateUser(HttpServletRequest request,HttpServletResponse response) {
	 * 
	 * 
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>(); Map<String,
	 * Object> generalMap = new HashMap<String, Object>();
	 * 
	 * session=request.getSession(true); String userGroupsCode=""; String
	 * userGroupsName=""; int userGroupsId=0; String changedBy = ""; String
	 * changedTime = ""; Date changedDate = null; String userName = null; String
	 * employeeCode =null; String password = null; String loginNameTemp=null;
	 * String employeeCodeTemp=null; Date currentDate = new Date(); String
	 * loginName=null; jsp = USER_JSP; title="User Master"; Users users=new
	 * Users();
	 * 
	 * 
	 * if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
	 * loginName = request.getParameter(RequestConstants.LOGIN_NAME);
	 * loginName=loginName.trim(); } if
	 * (request.getParameter(RequestConstants.USER_NAME) != null) { userName =
	 * request.getParameter(RequestConstants.USER_NAME); } if
	 * (request.getParameter(RequestConstants.EMPLOYEE_CODE) != null) {
	 * employeeCode = request.getParameter(RequestConstants.EMPLOYEE_CODE);
	 * 
	 * } if (request.getParameter(RequestConstants.PASSWORD) != null) { password
	 * = request.getParameter(RequestConstants.PASSWORD); }
	 * if(request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); }
	 * 
	 * changedDate = new Date(); changedTime =
	 * (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	 * 
	 * 
	 * userList=new ArrayList();
	 * userList=(List)userMasterHandlerService.getUserList(); String
	 * loginNameUpper=null; if(userList.size() != 0 || userList != null) for
	 * (Iterator iter = userList.iterator(); iter.hasNext();) { Users
	 * userListObj = (Users) iter.next();
	 * loginNameTemp=(String)userListObj.getLoginName();
	 * loginNameTemp=loginNameTemp.toUpperCase();
	 * loginNameUpper=loginName.toUpperCase();
	 * employeeCodeTemp=(String)userListObj.getEmployeeCode();
	 * 
	 * if(loginNameTemp!=null) if(loginNameUpper.equals(loginNameTemp) ||
	 * loginNameUpper==loginNameTemp) { map =
	 * userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Login Name Already Exists"; map.put("message", message);
	 * title="User Master"; map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map); } if(!employeeCode.equals("select"))
	 * if(employeeCode.equals(employeeCodeTemp)||
	 * employeeCode==employeeCodeTemp) { map =
	 * userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Employee Code Already Mapped"; map.put("message",
	 * message); title="User Master"; map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map); } }
	 * 
	 * users.setLoginName(loginName); users.setUserName(userName);
	 * if(!employeeCode.equals("select")) users.setEmployeeCode(employeeCode);
	 * users.setPassword(password); users.setStatus("y");
	 * 
	 * users.setLastChgBy(changedBy); users.setLastChgDate(currentDate);
	 * users.setLastChgTime(currentTime); Boolean flag=false;
	 * flag=userMasterHandlerService.updateUser(users); if(flag==true) { map =
	 * userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Data updated Successfully "; map.put("message", message);
	 * title="User Master"; map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map);
	 * 
	 * }else{ map = userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Data Cant Be Updated  "; title="User Master";
	 * map.put("message", message); map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map);
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * showUpdateUserWithDetails(HttpServletRequest request, HttpServletResponse
	 * response) {
	 * 
	 * @SuppressWarnings("unused") //HttpSession session =
	 * request.getSession(true); Map map=new HashMap();
	 * 
	 * @SuppressWarnings("unused") List<Users> selectedList=new
	 * ArrayList<Users>(); List updateList=new ArrayList(); String jsp =
	 * RequestConstants.UPDATE_USER_JSP;
	 * 
	 * @SuppressWarnings("unused") String loginName=null; String
	 * loginNameString=null; if
	 * (request.getParameter(RequestConstants.LOGIN_NAME) != null)
	 * loginName=(String) request.getParameter(RequestConstants.LOGIN_NAME);
	 * 
	 * if(session.getAttribute("loginNameString")!=null)
	 * loginNameString=(String)session.getAttribute("loginNameString");
	 * 
	 * updateList=userMasterHandlerService.getLoginList(loginNameString);
	 * 
	 * map.put("updateList", updateList);
	 * 
	 * url="/security/security/user?method=showUserJsp"; map.put("url", url);
	 * jsp += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map); }
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * updateUser(HttpServletRequest request, HttpServletResponse response)
	 * throws ParseException {
	 * 
	 * String message=null; int id = 0; String loginName = null; String userName
	 * = null; String employeeCode =null; String password = null; String
	 * lastChgBy=null; String lastChgTime = null; Date lastChgDate = null;
	 * String status="";
	 * 
	 * @SuppressWarnings("unused") String loginNameTemp=null;
	 * 
	 * @SuppressWarnings("unused") String employeeCodeTemp=null; jsp =
	 * RequestConstants.MESSAGE_FOR_MASTERS_JSP;
	 * 
	 * 
	 * 
	 * if (request.getParameter("userId") != null) { id =
	 * Integer.parseInt(request.getParameter("userId"));
	 * 
	 * } if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
	 * loginName = request.getParameter(RequestConstants.LOGIN_NAME);
	 * loginName=loginName.trim(); } if
	 * (request.getParameter(RequestConstants.USER_NAME) != null) { userName =
	 * request.getParameter(RequestConstants.USER_NAME); } if
	 * (request.getParameter(RequestConstants.EMPLOYEE_CODE) != null) {
	 * employeeCode = request.getParameter(RequestConstants.EMPLOYEE_CODE);
	 * 
	 * } if (request.getParameter(RequestConstants.PASSWORD) != null) { password
	 * = request.getParameter(RequestConstants.PASSWORD); } if
	 * (request.getParameter(RequestConstants.STATUS) != null) { status =
	 * (request.getParameter(RequestConstants.STATUS)); } if
	 * (request.getParameter(RequestConstants.CHANGED_BY) != null) { lastChgBy =
	 * request.getParameter(RequestConstants.CHANGED_BY);
	 * 
	 * } if (request.getParameter(RequestConstants.CHANGED_DATE_HIDDEN) != null)
	 * { SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
	 * SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
	 * String
	 * date4MySQL=formatterOut.format(formatterIn.parse(request.getParameter
	 * (RequestConstants.CHANGED_DATE_HIDDEN))); lastChgDate =
	 * java.sql.Date.valueOf(date4MySQL);
	 * 
	 * } if (request.getParameter(RequestConstants.CHANGED_TIME_HIDDEN) != null)
	 * { lastChgTime =
	 * request.getParameter(RequestConstants.CHANGED_TIME_HIDDEN);
	 * 
	 * } Users users=new Users(); userList=new ArrayList();
	 * userList=(List)userMasterHandlerService.getUserList();
	 * 
	 * @SuppressWarnings("unused") String loginNameUpper=null; users.setId(id);
	 * users.setLoginName(loginName); users.setUserName(userName);
	 * if(!employeeCode.equals("select")) users.setEmployeeCode(employeeCode);
	 * users.setPassword(password); users.setStatus(status);
	 * users.setLastChgBy(lastChgBy); users.setLastChgDate(lastChgDate);
	 * users.setLastChgTime(lastChgTime);
	 * 
	 * Boolean flag=false; flag=userMasterHandlerService.updateUser(users);
	 * if(flag==true) { url="/security/security/user?method=showUserJsp";
	 * map.put("url", url); title="User Master";
	 * message="Record Updated Successfully"; map.put("message", message);
	 * map.put("title", title); jsp += ".jsp"; map.put("contentJsp", jsp);
	 * return new ModelAndView("SuperAdminMenu", "map", map);
	 * 
	 * }else{ url="/security/security/user?method=showUserJsp"; map.put("url",
	 * url); message="Record Not Updated "; title="User Master";
	 * map.put("message", message); map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * showDeleteUser(HttpServletRequest request, HttpServletResponse response)
	 * { String loginName=null;
	 * 
	 * String jsp = RequestConstants.DELETE_USER_JSP; List deleteList=new
	 * ArrayList(); Map map=new HashMap(); if
	 * (request.getParameter(RequestConstants.LOGIN_NAME) != null) { loginName =
	 * request.getParameter(RequestConstants.LOGIN_NAME);
	 * loginName=loginName.trim(); }
	 * 
	 * deleteList=userMasterHandlerService.getLoginList(loginName);
	 * if(deleteList.size()==0){ jsp=RequestConstants.MESSAGE_FOR_MASTERS_JSP;
	 * message="Records Not found ";
	 * 
	 * map.put("message", message); }
	 * url="/security/security/user?method=showUserJsp"; map.put("url", url);
	 * title="User Master"; map.put("title", title); map.put("deleteList",
	 * deleteList); jsp += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * deleteUser(HttpServletRequest request, HttpServletResponse response)
	 * throws ParseException { String jsp =
	 * RequestConstants.MESSAGE_FOR_MASTERS_JSP; Map map=new HashMap();
	 * 
	 * 
	 * 
	 * int id = 0; String loginName = null; String userName = null; String
	 * employeeCode =null; String password = null; String lastChgBy=null; String
	 * lastChgTime = null;
	 * 
	 * @SuppressWarnings("unused") Date lastChgDate = null; String status="";
	 * String message=null;
	 * 
	 * 
	 * try{
	 * 
	 * if (request.getParameter(RequestConstants.USER_ID) != null) {
	 * 
	 * id = Integer.parseInt(request.getParameter(RequestConstants.USER_ID));
	 * 
	 * 
	 * } if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
	 * loginName = request.getParameter(RequestConstants.LOGIN_NAME);
	 * loginName=loginName.trim(); } if
	 * (request.getParameter(RequestConstants.USER_NAME) != null) { userName =
	 * request.getParameter(RequestConstants.USER_NAME); } if
	 * (request.getParameter(RequestConstants.EMPLOYEE_CODE) != null) {
	 * employeeCode = request.getParameter(RequestConstants.EMPLOYEE_CODE);
	 * 
	 * } if (request.getParameter(RequestConstants.PASSWORD) != null) { password
	 * = request.getParameter(RequestConstants.PASSWORD); }
	 * 
	 * if (request.getParameter(RequestConstants.CHANGED_BY) != null) {
	 * lastChgBy = request.getParameter(RequestConstants.CHANGED_BY);
	 * 
	 * } if (request.getParameter(RequestConstants.CHANGED_DATE_HIDDEN) != null)
	 * { SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
	 * SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
	 * 
	 * String
	 * date4MySQL=formatterOut.format(formatterIn.parse(request.getParameter
	 * (RequestConstants.CHANGED_DATE_HIDDEN)));
	 * 
	 * lastChgDate = java.sql.Date.valueOf(date4MySQL);
	 * 
	 * 
	 * } if (request.getParameter(RequestConstants.CHANGED_TIME_HIDDEN) != null)
	 * { lastChgTime =
	 * request.getParameter(RequestConstants.CHANGED_TIME_HIDDEN);
	 * 
	 * }
	 * 
	 * 
	 * }catch (Exception e) {//System.out.println(
	 * "Exception in UsersMasterController while data Retiving from Form "+e); }
	 * try{ Users users=new Users(); users.setId(id);
	 * users.setLoginName(loginName); users.setUserName(userName);
	 * users.setEmployeeCode(employeeCode); users.setPassword(password);
	 * users.setLastChgBy(lastChgBy); users.setLastChgDate(lastChgDate);
	 * users.setLastChgTime(lastChgTime); users.setStatus("n"); Boolean
	 * flag=false; flag=userMasterHandlerService.updateUser(users);
	 * if(flag==true) { url="/security/security/user?method=showUserJsp";
	 * map.put("url", url); title="User Master"; map.put("title", title);
	 * message="Record Deleted Successfully"; map.put("message", message); jsp
	 * += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map);
	 * 
	 * }else{ url="/security/security/user?method=showUserJsp"; map.put("url",
	 * url); title="User Master"; map.put("title", title);
	 * message="Record Not Deleted "; map.put("message", message); jsp +=
	 * ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map);
	 * 
	 * } }catch (Exception e) {//System.out.println(
	 * "Exception in UsersMasterController while stroring values in bean"+e); }
	 * 
	 * jsp += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map); }
	 * 
	 * 
	 * 
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * showEnquiryUser(HttpServletRequest request, HttpServletResponse response)
	 * { String loginName=null; String message=""; String jsp =
	 * RequestConstants.ENQUIRY_USER_JSP; Map map=new HashMap(); List
	 * enquiryList=new ArrayList();
	 * 
	 * if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
	 * loginName = request.getParameter(RequestConstants.LOGIN_NAME);
	 * loginName=loginName.trim(); }
	 * 
	 * enquiryList=userMasterHandlerService.getLoginList(loginName);
	 * if(enquiryList.size()==0){
	 * url="/security/security/user?method=showUserJsp"; map.put("url", url);
	 * jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP; title="User Master";
	 * map.put("title", title); message="Records not found"; map.put("message",
	 * message); jsp += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map); } map.put("enquiryList",
	 * enquiryList); map.put("loginString", loginName);
	 * 
	 * url="/security/security/user?method=showUserJsp"; map.put("url", url);
	 * jsp += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map); }
	 */
	public UserMasterHandlerService getUserMasterHandlerService() {
		return userMasterHandlerService;
	}

	public void setUserMasterHandlerService(
			UserMasterHandlerService userMasterHandlerService) {
		this.userMasterHandlerService = userMasterHandlerService;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView next(HttpServletRequest request,
			HttpServletResponse response) {
		@SuppressWarnings("unused")
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		String nextState = "enable";
		String previousState = "enable";
		String min;
		String max;
		@SuppressWarnings("unused")
		String searchName = "";
		List enquiryList = new ArrayList();
		String jsp = RequestConstants.ENQUIRY_USER_JSP;

		String x = (String) session.getAttribute("min");
		String y = (String) session.getAttribute("max");
		String loginString = (String) session.getAttribute("loginString");

		enquiryList = userMasterHandlerService.getLoginList(loginString);

		int temp1 = Integer.parseInt(x);
		int temp2 = Integer.parseInt(y);
		temp1 = temp1 + 5;
		temp2 = temp2 + 5;

		int sizeOfList = enquiryList.size();

		if ((temp2 + 1 >= sizeOfList)) {
			nextState = "disable";
		}

		min = temp1 + "";
		max = temp2 + "";
		map.put("enquiryList", enquiryList);
		map.put("loginString", loginString);
		map.put("min", min);
		map.put("max", max);
		map.put("nextState", nextState);
		map.put("previousState", previousState);
		url = "/security/security/user?method=showUserJsp";
		map.put("url", url);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView previous(HttpServletRequest request,
			HttpServletResponse response) {
		@SuppressWarnings("unused")
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		String nextState = "enable";
		String previousState = "enable";
		HttpSession session = request.getSession(false);
		String min;
		String max;

		String jsp = RequestConstants.ENQUIRY_USER_JSP;

		String x = (String) session.getAttribute("min");
		String y = (String) session.getAttribute("max");
		String loginString = (String) session.getAttribute("loginString");

		int temp1 = Integer.parseInt(x);
		int temp2 = Integer.parseInt(y);
		temp1 = temp1 - 5;
		temp2 = temp2 - 5;

		Map<String, Object> map = new HashMap<String, Object>();
		List enquiryList = new ArrayList();

		enquiryList = userMasterHandlerService.getLoginList(loginString);

		if ((temp1 <= 0)) {
			previousState = "disable";
		} else
			previousState = "enable";
		url = "/security/security/user?method=showUserJsp";
		map.put("url", url);
		min = temp1 + "";
		max = temp2 + "";
		map.put("enquiryList", enquiryList);
		map.put("loginString", loginString);
		map.put("min", min);
		map.put("max", max);
		map.put("nextState", nextState);
		map.put("previousState", previousState);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	// Hospital User Maintenance Methods

	@SuppressWarnings("unchecked")
	public ModelAndView showUserHospMaintenanceJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		userList = new ArrayList();
		hospitalList = new ArrayList();
		userList = (List) userMasterHandlerService.getUserList();
		hospitalList = (List) userMasterHandlerService.getHospitalList();

		map.put("userList", userList);
		map.put("hospitalList", hospitalList);

		jsp = RequestConstants.USER_HOSPITAL_MAINTENENCE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUserHospMaintenance(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {

		jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
		@SuppressWarnings("unused")
		List hospitalList = new ArrayList();
		List list = new ArrayList();
		int loginId = 0;
		int hospitalId = 0;
		int groupId = 1;
		int groupHospitalId = 0;
		String status = "";
		String message = "";
		String lastChgBy = null;
		String lastChgTime = null;
		Date lastChgDate = null;
		Date validDate = null;

		if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
			loginId = Integer.parseInt(request
					.getParameter(RequestConstants.LOGIN_NAME));
		}

		if (request.getParameter(RequestConstants.HOSPITAL_NAME) != null) {
			hospitalId = Integer.parseInt(request
					.getParameter(RequestConstants.HOSPITAL_NAME));
		}

		if (request.getParameter(RequestConstants.GROUP_NAME) != null) {
			groupId = Integer.parseInt(request
					.getParameter(RequestConstants.GROUP_NAME));
		}
		try {
			if (request.getParameter(RequestConstants.VALID_DATE) != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request
								.getParameter(RequestConstants.VALID_DATE)));
				validDate = java.sql.Date.valueOf(date4MySQL);
			}
		} catch (Exception e) {
e.printStackTrace();		}
		if (request.getParameter(RequestConstants.CHANGED_BY) != null) {
			lastChgBy = request.getParameter(RequestConstants.CHANGED_BY);
		}

		try {
			if (request.getParameter(RequestConstants.CHANGED_DATE) != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request
								.getParameter(RequestConstants.CHANGED_DATE)));
				lastChgDate = java.sql.Date.valueOf(date4MySQL);
			}
		} catch (Exception e1) {
e1.printStackTrace();		}
		if (request.getParameter(RequestConstants.CHANGED_TIME) != null) {

			lastChgTime = request.getParameter(RequestConstants.CHANGED_TIME);
		}

		if (request.getParameter(RequestConstants.STATUS) != null) {
			status = (request.getParameter(RequestConstants.STATUS));
		}

		list = userMasterHandlerService.getGroupHospitalId(groupId, hospitalId);
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			UsergroupHospital listObj = (UsergroupHospital) iter.next();

			if (list.size() != 0 && list != null) {

				groupHospitalId = listObj.getId();

			}

		}
		map = new HashMap();
		@SuppressWarnings("unused")
		UserUsergroupHospital userUsergroupHospital = new UserUsergroupHospital();
		userUsergroupHospital.getUser().setId(loginId);
		userUsergroupHospital.getGroupHospital().setId(groupHospitalId);
		userUsergroupHospital.setStatus(status);
		userUsergroupHospital.setValidUpto(validDate);
		userUsergroupHospital.setLastChgBy(lastChgBy);
		userUsergroupHospital.setLastChgDate(lastChgDate);
		userUsergroupHospital.setLastChgTime(lastChgTime);

		list = userMasterHandlerService.checkExistOfUserHospMapping(loginId,
				groupHospitalId);
		if (list.size() != 0 && list != null) {
			url = "/security/security/user?method=showUserHospMaintenanceJsp";
			map.put("url", url);
			message = "Recorn already mapped";
			map.put("message", message);
			title = "User Hospital Maintenence";
			map.put("title", title);
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		} else {
			boolean flag = userMasterHandlerService
					.addUserHosp(userUsergroupHospital);

			if (flag) {
				message = "Record mapped successfully ";
			} else {
				message = "Record not mapped";
			}
		}
		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		map.put("message", message);
		jsp += ".jsp";
		title = "User Hospital Maintenence";
		map.put("title", title);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showUpdateUserHospMaintenance(
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException {

		String jsp = RequestConstants.UPDATE_USER_HOSPITAL_MAINTENENCE;

		int loginId = 0;
		int hospitalId = 0;
		int groupId = 1;
		int groupHospitalId = 0;
		@SuppressWarnings("unused")
		int status = 0;
		@SuppressWarnings("unused")
		String message = "";
		@SuppressWarnings("unused")
		String lastChgBy = null;
		@SuppressWarnings("unused")
		String lastChgTime = null;
		@SuppressWarnings("unused")
		Date lastChgDate;
		@SuppressWarnings("unused")
		Date validDate;

		Map map = new HashMap();
		List list = new ArrayList();
		List userList = new ArrayList();
		@SuppressWarnings("unused")
		List userGroupHospList = new ArrayList();
		List userUserGroupHospList = new ArrayList();
		@SuppressWarnings("unused")
		List hospList = new ArrayList();

		try {
			if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
				loginId = Integer.parseInt(request
						.getParameter(RequestConstants.LOGIN_NAME));

			}

			if (request.getParameter(RequestConstants.HOSPITAL_NAME) != null) {
				hospitalId = Integer.parseInt(request
						.getParameter(RequestConstants.HOSPITAL_NAME));

			}

			if (request.getParameter(RequestConstants.GROUP_NAME) != null) {
				groupId = Integer.parseInt(request
						.getParameter(RequestConstants.GROUP_NAME));

			}

			if (request.getParameter(RequestConstants.CHANGED_BY) != null) {
				lastChgBy = request.getParameter(RequestConstants.CHANGED_BY);

			}

			if (request.getParameter(RequestConstants.CHANGED_TIME) != null) {

				lastChgTime = request
						.getParameter(RequestConstants.CHANGED_TIME);

			}

			if (request.getParameter(RequestConstants.STATUS) != null) {
				status = Integer.parseInt(request
						.getParameter(RequestConstants.STATUS));
			}

		} catch (Exception e3) {
e3.printStackTrace();		}

		try {

			list = userMasterHandlerService.getGroupHospitalId(groupId,
					hospitalId);

			for (Iterator iter = list.iterator(); iter.hasNext();) {
				UsergroupHospital listObj = (UsergroupHospital) iter.next();

				if (list.size() != 0 && list != null) {

					groupHospitalId = listObj.getId();

				}

			}
		} catch (Exception e) {
e.printStackTrace();		}

		try {

			userList = (List) userMasterHandlerService.getUserList();

			userUserGroupHospList = (List) userMasterHandlerService
					.getUserUserGroupHospList(loginId, groupHospitalId);

		} catch (Exception e2) {
e2.printStackTrace();		}

		try {

			map.put("userUserGroupHospList", userUserGroupHospList);

			map.put("userList", userList);
		} catch (Exception e4) {
e4.printStackTrace();		}
		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		jsp += ".jsp";
		title = "User Hospital Maintenence";
		map.put("title", title);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView updateUserHospMaintenance(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
		boolean flag = false;

		int groupHospitalId = 0;
		String status = "";
		String message = "";
		String lastChgBy = null;
		String lastChgTime = null;
		Date lastChgDate = null;
		Date validDate = null;

		UserUsergroupHospital userUsergroupHospital = new UserUsergroupHospital();
		List userUsergroupHospitalList = new ArrayList();
		Map map = new HashMap();

		if (request.getParameter(RequestConstants.VALID_DATE) != null) {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse(request
					.getParameter(RequestConstants.VALID_DATE)));
			validDate = java.sql.Date.valueOf(date4MySQL);
		}

		if (request.getParameter(RequestConstants.CHANGED_BY) != null) {
			lastChgBy = request.getParameter(RequestConstants.CHANGED_BY);
		}

		if (request.getParameter(RequestConstants.CHANGED_DATE) != null) {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse(request
					.getParameter(RequestConstants.CHANGED_DATE)));
			lastChgDate = java.sql.Date.valueOf(date4MySQL);
		}

		if (request.getParameter(RequestConstants.CHANGED_TIME) != null) {

			lastChgTime = request.getParameter(RequestConstants.CHANGED_TIME);

		}

		if (request.getParameter(RequestConstants.STATUS) != null) {
			status = (request.getParameter(RequestConstants.STATUS));
		}
		try {
			if (request.getParameter("groupHospitalIdField") != null) {
				groupHospitalId = Integer.parseInt(request
						.getParameter("groupHospitalIdField"));

			}

			userUsergroupHospitalList = userMasterHandlerService
					.getUserUserGroupHospListWithGHID(groupHospitalId);

			if (userUsergroupHospitalList.size() != 0
					&& userUsergroupHospitalList != null) {
				Iterator iter = userUsergroupHospitalList.iterator();

				UserUsergroupHospital listObj = (UserUsergroupHospital) iter
						.next();
				userUsergroupHospital.setId(listObj.getId());
				userUsergroupHospital.setUser(listObj.getUser());
				userUsergroupHospital.setGroupHospital(listObj
						.getGroupHospital());
				userUsergroupHospital.setStatus(status);
				userUsergroupHospital.setValidUpto(validDate);
				userUsergroupHospital.setLastChgBy(lastChgBy);
				userUsergroupHospital.setLastChgDate(lastChgDate);
				userUsergroupHospital.setLastChgTime(lastChgTime);
			}

			flag = userMasterHandlerService
					.updateUserUsergroupHospital(userUsergroupHospital);

			if (flag) {
				message = "Updated";
			} else {
				message = "Not Updated";
			}

		} catch (Exception e3) {
e3.printStackTrace();		}
		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		title = "User Hospital Maintenence";
		map.put("title", title);
		map.put("message", message);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDeleteUserHospMaintenance(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = RequestConstants.DELETE_USER_HOSPITAL_MAINTENENCE;

		int loginId = 0;
		@SuppressWarnings("unused")
		int hospitalId = 0;
		@SuppressWarnings("unused")
		int groupId = 1;
		@SuppressWarnings("unused")
		int id = 0;
		@SuppressWarnings("unused")
		int groupHospitalId = 0;
		int userGroupHospitalId = 0;
		map = new HashMap();
		List listWithUserId = new ArrayList();
		List userGroupHospList = new ArrayList();
		List userList = new ArrayList();
		List hospitalList = new ArrayList();

		@SuppressWarnings("unused")
		List userGroupHospListForDelete = new ArrayList();
		List deleteList = new ArrayList();

		if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
			loginId = Integer.parseInt(request
					.getParameter(RequestConstants.LOGIN_NAME));

		}
		@SuppressWarnings("unused")
		List loginNameList = new ArrayList();
		loginNameList = (List) userMasterHandlerService.getUserName(loginId);

		@SuppressWarnings("unused")
		String userName = "";
		for (Iterator iter3 = loginNameList.iterator(); iter3.hasNext();) {
			Users usersObj = (Users) iter3.next();

			if (loginNameList.size() != 0 && loginNameList != null) {

				userName = usersObj.getLoginName();

			}
		}

		listWithUserId = (List) userMasterHandlerService
				.getListWithUserId(loginId);

		userGroupHospList = (List) userMasterHandlerService
				.getUserGroupHospList();

		try {
			for (Iterator iter1 = listWithUserId.iterator(); iter1.hasNext();) {
				UserUsergroupHospital listObj1 = (UserUsergroupHospital) iter1
						.next();

				if (listWithUserId.size() != 0 && listWithUserId != null) {

					userGroupHospitalId = listObj1.getGroupHospital().getId();

					for (Iterator iter2 = userGroupHospList.iterator(); iter2
							.hasNext();) {
						@SuppressWarnings("unused")
						UsergroupHospital listObj2 = (UsergroupHospital) iter2
								.next();
						if (userGroupHospList.size() != 0
								&& userGroupHospList != null) {
							id = listObj2.getId();

						}
						if (userGroupHospitalId == id) {
							deleteList.add(listObj2);
						}

					}
				}

			}

		} catch (Exception e) {
e.printStackTrace();		}

		userList = (List) userMasterHandlerService.getUserList();
		hospitalList = (List) userMasterHandlerService.getHospitalList();

		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		map.put("listWithUserId", listWithUserId);
		map.put("userId", loginId);
		map.put("loginNameList", loginNameList);
		map.put("deleteList", deleteList);
		map.put("userList", userList);
		map.put("hospitalList", hospitalList);
		title = "User Hospital Maintenence";
		map.put("title", title);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteUserHospMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
		int userUserGroupHospId = 0;
		String message = "";
		List list = new ArrayList();
		int id = 0;
		int userId = 0;
		int groupHospitalId = 0;
		String status = "";
		boolean flag = false;

		@SuppressWarnings("unused")
		String lastChgBy = null;
		@SuppressWarnings("unused")
		String lastChgTime = null;
		@SuppressWarnings("unused")
		Date lastChgDate = null;
		@SuppressWarnings("unused")
		Date validDate = null;
		UserUsergroupHospital userUsergroupHospital = new UserUsergroupHospital();
		try {
			if (request.getParameter("userUserGroupHospId") != null) {

				userUserGroupHospId = Integer.parseInt(request
						.getParameter("userUserGroupHospId"));

			}

			list = userMasterHandlerService
					.getUserUserGroupHospListWithID(userUserGroupHospId);

			Iterator iter1 = list.iterator();

			UserUsergroupHospital listObj1 = (UserUsergroupHospital) iter1
					.next();
			if (list.size() != 0 && list != null) {

				id = listObj1.getId();
				userId = listObj1.getUser().getId();
				groupHospitalId = listObj1.getGroupHospital().getId();
				status = "n";
				validDate = (Date) listObj1.getValidUpto();
				lastChgBy = listObj1.getLastChgBy();
				lastChgTime = listObj1.getLastChgTime();
				lastChgDate = (Date) listObj1.getLastChgDate();
			}

		} catch (Exception e) {
e.printStackTrace();		}
		userUsergroupHospital.setId(id);
		userUsergroupHospital.getUser().setId(userId);
		userUsergroupHospital.getGroupHospital().setId(groupHospitalId);
		userUsergroupHospital.setStatus(status);
		userUsergroupHospital.setValidUpto(validDate);
		userUsergroupHospital.setLastChgBy(lastChgBy);
		userUsergroupHospital.setLastChgDate(lastChgDate);
		userUsergroupHospital.setLastChgTime(lastChgTime);

		flag = userMasterHandlerService
				.updateUserUsergroupHospital(userUsergroupHospital);
		if (flag) {
			message = "Record Deleted";
		} else {
			message = "Record not Deleted";
		}
		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		title = "User Hospital Maintenence";
		map.put("title", title);
		map.put("message", message);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showEnquiryUserHospMaintenance(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = RequestConstants.ENQUIRY_USER_HOSPITAL_MAINTENENCE;
		@SuppressWarnings("unused")
		int loginId = 0;
		List userUsergroupHospitalList = new ArrayList();
		List userList = new ArrayList();
		List hospitalList = new ArrayList();
		List userGroupList = new ArrayList();
		Map map = new HashMap();
		String message = "";
		if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
			loginId = Integer.parseInt(request
					.getParameter(RequestConstants.LOGIN_NAME));

		}
		try {
			userUsergroupHospitalList = userMasterHandlerService
					.getListWithUserId(loginId);
			userGroupList = userMasterHandlerService.getUserGroupHospList();
			userList = userMasterHandlerService.getUserList();
			hospitalList = userMasterHandlerService.getHospitalList();
		} catch (Exception e) {
e.printStackTrace();		}
		if (userUsergroupHospitalList.size() == 0) {

			title = "User Hospital Maintenence";
			map.put("title", title);
			url = "/security/security/user?method=showUserHospMaintenanceJsp";
			map.put("url", url);
			message = "Records Not Found with LoginName";
			map.put("message", message);
			jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		map.put("userGroupList", userGroupList);
		map.put("userList", userList);
		map.put("hospitalList", hospitalList);
		map.put("userUsergroupHospitalList", userUsergroupHospitalList);
		map.put("loginIdTemp", loginId + "");

		title = "User Hospital Maintenence";
		map.put("title", title);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView nextForUserHosp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();

		HttpSession session = request.getSession(false);
		String nextState = "enable";
		String previousState = "enable";
		String min;
		String max;
		String x = "";
		String y = "";
		int temp1 = 0;
		int temp2 = 0;
		String loginIdTemp = "";

		@SuppressWarnings("unused")
		String searchName = "";
		@SuppressWarnings("unused")
		List enquiryList = new ArrayList();
		String jsp = RequestConstants.ENQUIRY_USER_HOSPITAL_MAINTENENCE;
		List userUsergroupHospitalList = new ArrayList();
		List userList = new ArrayList();
		if (session.getAttribute("min") != null)
			x = (String) session.getAttribute("min");

		if (session.getAttribute("max") != null)
			y = (String) session.getAttribute("max");
		if (session.getAttribute("loginIdTemp") != null)
			loginIdTemp = (String) session.getAttribute("loginIdTemp");

		int loginIdTemp2 = Integer.parseInt(""
				+ session.getAttribute("loginIdTemp"));
		try {
			userUsergroupHospitalList = (List) userMasterHandlerService
					.getListWithUserId(loginIdTemp2);
			userList = userMasterHandlerService.getUserList();
			temp1 = Integer.parseInt(x);
			temp2 = Integer.parseInt(y);
			temp1 = temp1 + 5;
			temp2 = temp2 + 5;

			int sizeOfList = userUsergroupHospitalList.size();

			if ((temp2 + 1 >= sizeOfList)) {
				nextState = "disable";
			}

		} catch (Exception e) {
e.printStackTrace();		}
		try {
			min = temp1 + "";
			max = temp2 + "";
			map.put("userUsergroupHospitalList", userUsergroupHospitalList);
			map.put("userList", userList);
			map.put("loginIdTemp", loginIdTemp);
			map.put("min", min);
			map.put("max", max);
			map.put("nextState", nextState);
			map.put("previousState", previousState);

		} catch (Exception e) {
e.printStackTrace();		}
		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView previousForUserHosp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();

		HttpSession session = request.getSession(false);
		String nextState = "enable";
		String previousState = "enable";
		String min;
		String max;
		String x = "";
		String y = "";
		int temp1 = 0;
		int temp2 = 0;
		String loginIdTemp = "";

		@SuppressWarnings("unused")
		String searchName = "";
		@SuppressWarnings("unused")
		List enquiryList = new ArrayList();
		String jsp = RequestConstants.ENQUIRY_USER_HOSPITAL_MAINTENENCE;
		List userUsergroupHospitalList = new ArrayList();
		List userList = new ArrayList();
		if (session.getAttribute("min") != null)
			x = (String) session.getAttribute("min");

		if (session.getAttribute("max") != null)
			y = (String) session.getAttribute("max");
		if (session.getAttribute("loginIdTemp") != null)
			loginIdTemp = (String) session.getAttribute("loginIdTemp");

		int loginIdTemp2 = Integer.parseInt(""
				+ session.getAttribute("loginIdTemp"));
		try {
			userUsergroupHospitalList = (List) userMasterHandlerService
					.getListWithUserId(loginIdTemp2);
			userList = userMasterHandlerService.getUserList();
			temp1 = Integer.parseInt(x);
			temp2 = Integer.parseInt(y);
			temp1 = temp1 - 5;
			temp2 = temp2 - 5;

			@SuppressWarnings("unused")
			int sizeOfList = userUsergroupHospitalList.size();

			if ((temp1 <= 0)) {
				previousState = "disable";
			} else
				previousState = "enable";

		} catch (Exception e) {
e.printStackTrace();		}
		try {
			min = temp1 + "";
			max = temp2 + "";
			map.put("userUsergroupHospitalList", userUsergroupHospitalList);
			map.put("userList", userList);
			map.put("loginIdTemp", loginIdTemp);
			map.put("min", min);
			map.put("max", max);
			map.put("nextState", nextState);
			map.put("previousState", previousState);

		} catch (Exception e) {
		}
		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	// ********************************************************************************//
	// ***************************** Start Modules Written By
	// Mansi********************//
	// ********************************************************************************//

	// ------------------------------------------User Groups
	// --------------------------

	public ModelAndView searchUserGroups(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String userGroupsCode = null;
		String userGroupsName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			userGroupsCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			userGroupsName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			userGroupsCode = searchField;
			userGroupsName = null;

		} else {
			userGroupsCode = null;
			userGroupsName = searchField;
		}
		map = userMasterHandlerService.searchUserGroups(userGroupsCode,
				userGroupsName);

		jsp = USER_GROUP_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("userGroupsCode", userGroupsCode);
		map.put("userGroupsName", userGroupsName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showUserGroupsJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = userMasterHandlerService.showUserGroupsJsp();
		String jsp = USER_GROUP_JSP;
		jsp += ".jsp";
		title = "User Groups";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUserGroups(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserGroups masUserGroups = new UserGroups();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List userGroupsCodeList = new ArrayList();
		List userGroupsNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			userGroupsCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			userGroupsNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((userGroupsCodeList.size() == 0 || userGroupsCodeList == null)
				&& (userGroupsNameList.size() == 0 || userGroupsNameList == null)) {
			masUserGroups.setCode(code);
			masUserGroups.setGroupName(name);
			masUserGroups.setStatus("y");
			masUserGroups.setLastChgBy(changedBy);
			masUserGroups.setLastChgDate(currentDate);
			masUserGroups.setLastChgTime(currentTime);
			successfullyAdded = userMasterHandlerService
					.addUserGroups(masUserGroups);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
				|| (userGroupsNameList.size() != 0)
				|| userGroupsNameList != null) {
			if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
					&& (userGroupsNameList.size() == 0 || userGroupsNameList == null)) {

				message = "User Groups Code  already exists.";
			} else if ((userGroupsNameList.size() != 0 || userGroupsNameList != null)
					&& (userGroupsCodeList.size() == 0 || userGroupsCodeList == null)) {

				message = "User Groups Name already exists.";
			} else if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
					&& (userGroupsNameList.size() != 0 || userGroupsNameList != null)) {

				message = "User Groups Code and User Groups Name already exist.";
			}
		}

		try {
			map = userMasterHandlerService.showUserGroupsJsp();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		jsp = USER_GROUP_JSP;
		title = "Add User Groups";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editUserGroups(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String userGroupsCode = "";
		String userGroupsName = "";
		int userGroupsId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			userGroupsCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			userGroupsName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", userGroupsId);
		generalMap.put("userGroupsCode", userGroupsCode);
		generalMap.put("name", userGroupsName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingUserGroupsNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingUserGroupsNameList.size() == 0) {
			dataUpdated = userMasterHandlerService
					.editUserGroupsToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingUserGroupsNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/security/security/user?method=showUserGroupsJsp";

		try {
			map = userMasterHandlerService.showUserGroupsJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_GROUP_JSP;
		title = "update User Groups";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteUserGroups(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int userGroupsId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteUserGroups(userGroupsId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/security/security/user?method=showUserGroupsJsp";

		try {
			map = userMasterHandlerService.showUserGroupsJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_GROUP_JSP;
		title = "delete UserGroups";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -------------------------------------------User Group Hospital
	// --------------------------------------------------
	public ModelAndView showUsergroupHospitalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = userMasterHandlerService.showUsergroupHospitalJsp();
		jsp = USER_GROUP_HOSPITAL_JSP;
		jsp += ".jsp";
		title = "User Group Hospital";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUsergroupHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		UsergroupHospital masUsergroupHospital = new UsergroupHospital();
		int userGroupId = 0;
		int hospitalId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(USER_GROUP_ID) != null) {
			userGroupId = Integer.parseInt(request.getParameter(USER_GROUP_ID));
		}
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("userGroupId", userGroupId);
		generalMap.put("hospitalId", hospitalId);
		listMap = userMasterHandlerService
				.checkForExistingGroupHospital(generalMap);
		List duplicateGroupHospitalList = new ArrayList();

		if (listMap.get("duplicateGroupHospitalList") != null) {
			duplicateGroupHospitalList = (List) listMap
					.get("duplicateGroupHospitalList");
		}

		boolean successfullyAdded = false;
		if ((duplicateGroupHospitalList.size() == 0 || duplicateGroupHospitalList == null))

		{
			if(userGroupId>0){
				UserGroups masUserGroups = new UserGroups();
				masUserGroups.setId(userGroupId);
				masUsergroupHospital.setGroup(masUserGroups);
			}
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			masUsergroupHospital.setHospital(masHospital);

			masUsergroupHospital.setStatus("y");
			masUsergroupHospital.setLastChgBy(changedBy);
			masUsergroupHospital.setLastChgDate(currentDate);
			masUsergroupHospital.setLastChgTime(currentTime);
			successfullyAdded = userMasterHandlerService
			.addUsergroupHospital(masUsergroupHospital);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if (duplicateGroupHospitalList.size() != 0) {

			message = "User Group Name and Hospital Name already exist.";
		}

		try {
			map = userMasterHandlerService.showUsergroupHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_GROUP_HOSPITAL_JSP;
		title = "Add User Group Hospital";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editUsergroupHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		int usergroupHospitalId = 0;
		int userGroupId = 0;
		int hospitalId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null) {
			usergroupHospitalId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(USER_GROUP_ID) != null) {
			userGroupId = Integer.parseInt(request.getParameter(USER_GROUP_ID));
		}
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", usergroupHospitalId);
		generalMap.put("userGroupId", userGroupId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("flag", true);

		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = userMasterHandlerService
				.checkForExistingGroupHospital(generalMap);
		List duplicateGroupHospitalList = new ArrayList();

		if (listMap.get("duplicateGroupHospitalList") != null) {
			duplicateGroupHospitalList = (List) listMap
					.get("duplicateGroupHospitalList");
		}

		boolean dataUpdated = false;
		if ((duplicateGroupHospitalList.size() == 0 || duplicateGroupHospitalList == null)) {
			dataUpdated = userMasterHandlerService
					.editUsergroupHospital(generalMap);
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant be updated !!";
			}
		} else if (duplicateGroupHospitalList.size() != 0) {

			message = "User Group Name and Hospital Name already exist.";
		}

		try {
			map = userMasterHandlerService.showUsergroupHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_GROUP_HOSPITAL_JSP;
		title = "Edit User Group Hospital";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteUsergroupHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int usergroupHospitalId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			usergroupHospitalId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteUsergroupHospital(
				usergroupHospitalId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = userMasterHandlerService.showUsergroupHospitalJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_GROUP_HOSPITAL_JSP;
		title = "Delete User Group Hospital";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchUsergroupHospital(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String groupName = "";
		String hospitalName = "";
		String searchField = null;

		if (request.getParameter(USER_GROUP_NAME) != null
				&& !(request.getParameter(USER_GROUP_NAME).equals(""))) {
			groupName = request.getParameter(USER_GROUP_NAME);
		}
		if (request.getParameter(HOSPITAL_NAME) != null
				&& !(request.getParameter(HOSPITAL_NAME).equals(""))) {
			hospitalName = request.getParameter(HOSPITAL_NAME);
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			groupName = searchField;
			hospitalName = null;
		} else {
			groupName = null;
			hospitalName = searchField;
		}
		map = userMasterHandlerService.searchUsergroupHospital(groupName,
				hospitalName);

		jsp = USER_GROUP_HOSPITAL_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("groupName", groupName);
		map.put("hospitalName", hospitalName);
		return new ModelAndView("indexB", "map", map);
	}

	// ------------------------------------------Hospital
	// Master--------------------------

	public ModelAndView searchHospital(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String hospitalCode = null;
		String hospitalName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			hospitalCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			hospitalName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			hospitalCode = searchField;
			hospitalName = null;

		} else {
			hospitalCode = null;
			hospitalName = searchField;
		}
		map = userMasterHandlerService.searchHospital(hospitalCode,
				hospitalName);

		jsp = HOSPITAL_MASTER_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hospitalCode", hospitalCode);
		map.put("hospitalName", hospitalName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showHospitalJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = userMasterHandlerService.showHospitalJsp();
		String jsp = "hospital";
		jsp += ".jsp";
		title = "Hospital";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasHospital masHospital = new MasHospital();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String contactNumber = "";
		String hospitalAddress = "";
		int  command = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(ADDRESS) != null) {
			hospitalAddress = request.getParameter(ADDRESS);
		}
		 
		if(request.getParameter("command")!= null && (!request.getParameter("command").equals("")))
		 {		 
			command = Integer.parseInt(request.getParameter("command"));
			
		 }
		if (request.getParameter(CONTACT_NUMBER) != null) {
			contactNumber = request.getParameter(CONTACT_NUMBER);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		// generalMap.put("hospitalAddress", hospitalAddress);
		// generalMap.put("contactNumber", contactNumber);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
        generalMap.put("command",command); 
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List hospitalCodeList = new ArrayList();
		List hospitalNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			hospitalCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			hospitalNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		
		/*
		 * Code for Employee , Assign Template and Login Details
		 */
		Map<String, Object> dataForSaveMap = new HashMap<String, Object>();
		int employeeId=0;
		int loginId=0;
		String loginName="";
		String password="";
		String serviceNo="";
		int rankId=0;
		int titleId=0;
		String firstName="";
		String middleName="";
		String lastName="";
		int tradeId=0;
		int empCategoryId=0;
        int unitId=0;
        int departmentId=0;
        String offPhone="";
        
        
		if (request.getParameter("employeeId") != null
				&& !(request.getParameter("employeeId").equals(""))) {
			employeeId =Integer.parseInt(request.getParameter("employeeId"));
		}
		if (request.getParameter("loginId") != null
				&& !(request.getParameter("loginId").equals(""))) {
			loginId =Integer.parseInt(request.getParameter("loginId"));
		}
		
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals(""))) {
			rankId =Integer.parseInt(request.getParameter(RANK_ID));
		}
		if (request.getParameter(TITLE_ID) != null
				&& !(request.getParameter(TITLE_ID).equals(""))) {
			titleId=Integer.parseInt(request.getParameter(TITLE_ID));
		}
		if (request.getParameter(FIRST_NAME) != null) {
			firstName = request.getParameter(FIRST_NAME);
		}
		if (request.getParameter(MIDDLE_NAME) != null) {
			middleName = request.getParameter(MIDDLE_NAME);
		}
		if (request.getParameter(LAST_NAME) != null) {
			lastName = request.getParameter(LAST_NAME);
		}
		if (!request.getParameter(TRADE_ID).equals("0")) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		}
		if(!request.getParameter(EMPLOYEE_CATEGORY_ID).equals("0")) {
			empCategoryId = Integer.parseInt(request.getParameter(EMPLOYEE_CATEGORY_ID));
		}
		if(!request.getParameter(UNIT_ID).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}
		if(!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if(request.getParameter(TELL_NO_OFFICE) != null) {
			offPhone=request.getParameter(TELL_NO_OFFICE).trim();
		}
		if(request.getParameter("loginName") != null) {
			loginName=request.getParameter("loginName").trim();
		}
		if(request.getParameter("password") != null) {
			password=request.getParameter("password").trim();
		}
		dataForSaveMap.put("employeeId", employeeId);
        dataForSaveMap.put("loginId", loginId);
        dataForSaveMap.put("loginName", loginName);
        dataForSaveMap.put("password", password);
        dataForSaveMap.put("serviceNo", serviceNo);
        dataForSaveMap.put("rankId", rankId);
        dataForSaveMap.put("titleId", titleId);
        dataForSaveMap.put("firstName", firstName);
        dataForSaveMap.put("middleName", middleName);
        dataForSaveMap.put("lastName", lastName);
        dataForSaveMap.put("tradeId", tradeId);
        dataForSaveMap.put("empCategoryId", empCategoryId);
        dataForSaveMap.put("unitId", unitId);
        dataForSaveMap.put("departmentId", departmentId);
        dataForSaveMap.put("offPhone", offPhone);
        dataForSaveMap.put("masHospital", masHospital);
		boolean successfullyAdded = false;

		if ((hospitalCodeList.size() == 0 || hospitalCodeList == null)
				&& (hospitalNameList.size() == 0 || hospitalNameList == null)) {
			masHospital.setHospitalCode(code);
			masHospital.setHospitalName(name);
			masHospital.setAddress(hospitalAddress);
			masHospital.setContactNumber(contactNumber);
			masHospital.setStatus("y");
			masHospital.setLastChgBy(changedBy);
			masHospital.setLastChgDate(currentDate);
			masHospital.setLastChgTime(currentTime);
			MasCommand masCommand = new MasCommand();
			masCommand.setId(command);
			masHospital.setCommand(masCommand);
			
			dataForSaveMap.put("changedBy", changedBy);
			dataForSaveMap.put("currentDate", currentDate);
			dataForSaveMap.put("currentTime", currentTime);
			
			successfullyAdded = userMasterHandlerService
					.addHospital(dataForSaveMap);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}else if ((hospitalCodeList.size() != 0 || hospitalCodeList != null)
				|| (hospitalNameList.size() != 0) || hospitalNameList != null) {
			if ((hospitalCodeList.size() != 0 || hospitalCodeList != null)
					&& (hospitalNameList.size() == 0 || hospitalNameList == null)) {

				message = "Hospital Code  already exists.";
			} else if ((hospitalNameList.size() != 0 || hospitalNameList != null)
					&& (hospitalCodeList.size() == 0 || hospitalCodeList == null)) {

				message = "Hospital Name already exists.";
			} else if ((hospitalCodeList.size() != 0 || hospitalCodeList != null)
					&& (hospitalNameList.size() != 0 || hospitalNameList != null)) {

				message = "Hospital Code and Hospital Name already exist.";
			}
		}

		try {
			map = userMasterHandlerService.showHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "hospital";
		title = "Add Hospital";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editHospital(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String hospitalCode = "";
		String hospitalName = "";
		int userGroupsId = 0;
		String hospitalAddress = "";
		String contactNumber = "";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			hospitalCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			hospitalName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(ADDRESS) != null) {
			hospitalAddress = request.getParameter(ADDRESS);
		}
		if (request.getParameter(CONTACT_NUMBER) != null) {
			contactNumber = request.getParameter(CONTACT_NUMBER);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		int command = 0;
		if(request.getParameter("command")!= null && (!request.getParameter("command").equals("")))
		 {		 
			command = Integer.parseInt(request.getParameter("command"));
			
		 }
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", userGroupsId);
		generalMap.put("userGroupsCode", hospitalCode);
		generalMap.put("name", hospitalName);
		generalMap.put("hospitalAddress", hospitalAddress);
		generalMap.put("contactNumber", contactNumber);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("command", command);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingHospitalNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingHospitalNameList.size() == 0) {
			dataUpdated = userMasterHandlerService
					.editHospitalToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingHospitalNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/security/security/user?method=showHospitalJsp";

		try {
			map = userMasterHandlerService.showHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "hospital";
		title = "update Hospital";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int hospitalId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			hospitalId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteHospital(hospitalId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/security/security/user?method=showHospitalJsp";

		try {
			map = userMasterHandlerService.showHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "hospital";
		title = "delete Hospital";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * Load Employee Details
	 */
	
	public ModelAndView getServiceNoDetails(
			HttpServletRequest request, HttpServletResponse response) {
		//serviceNo
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		Box box  = HMSUtil.getBox(request);
		map = userMasterHandlerService.getServiceNoDetails(box);
		
		return new ModelAndView("responseForEmployeeAdminHosp","map",map);
	}
	// -------------------------------------------User Group Maintenance
	// --------------------------------------------------
	public ModelAndView showUserHospitalMaintenanceJsp(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession(true);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> generalMap = new HashMap<String, Object>();
		generalMap.put("hospitalId", hospitalId);
		map = userMasterHandlerService
				.showUserHospitalMaintenanceJsp(generalMap);
		jsp = USER_HOSPITAL_MAINTENANCE_JSP;
		jsp += ".jsp";
		title = "User Hospital Maintenance";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * addUserHospitalMaintenance(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String,Object> map = new
	 * HashMap<String,Object>(); UserUsergroupHospital masUserUsergroupHospital
	 * = new UserUsergroupHospital(); int usersId=0; int hospitalId=0; int
	 * groupId=0; String changedBy = ""; Map<String, Object> listMap=new
	 * HashMap<String, Object>(); Map<String, Object> generalMap = new
	 * HashMap<String, Object>(); Date currentDate = new Date(); Date validUpto
	 * = new Date(); if (request.getParameter(USER_ID) != null) { usersId =
	 * Integer.parseInt(request.getParameter(USER_ID));
	 * //System.out.println("usersId    "+usersId); } if
	 * (request.getParameter(HOSPITAL_ID) != null) { hospitalId =
	 * Integer.parseInt(request.getParameter(HOSPITAL_ID)); } if
	 * (request.getParameter(GROUP_ID) != null) { groupId =
	 * Integer.parseInt(request.getParameter(GROUP_ID)); }
	 * if(request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); } if(request.getParameter(CHANGED_DATE)
	 * != null && !(request.getParameter(CHANGED_DATE).equals(""))){ currentDate
	 * = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null &&
	 * !(request.getParameter(CHANGED_TIME).equals(""))){ currentTime =
	 * request.getParameter(CHANGED_TIME); } if(request.getParameter(VALID_DATE)
	 * != null && !(request.getParameter(VALID_DATE).equals(""))){ validUpto =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(VALID_DATE)); }
	 * 
	 * 
	 * map=userMasterHandlerService.getGroupHospitalIdFromUsergroupHospital(groupId
	 * , hospitalId);
	 * 
	 * List userGroupList= new ArrayList();
	 * 
	 * userGroupList=(List)map.get("groupHospitalIdList");
	 * 
	 * ////System.out.println("groupHospitalId ka size  "+userGroupList.size());
	 * UsergroupHospital
	 * usergroupHospital=(UsergroupHospital)userGroupList.get(0);
	 * 
	 * int groupHospitalId=usergroupHospital.getId();
	 * 
	 * generalMap.put("changedBy", changedBy); generalMap.put("currentDate",
	 * currentDate); generalMap.put("currentTime", currentTime);
	 * generalMap.put("usersId", usersId); /*generalMap.put("hospitalId",
	 * hospitalId); generalMap.put("groupId", groupId);
	 */
	/*
	 * generalMap.put("groupHospitalId", groupHospitalId); listMap =
	 * userMasterHandlerService.checkForExistingHospital(generalMap); List
	 * duplicateHospitalList = new ArrayList();
	 * 
	 * if(listMap.get("duplicateHospitalList") != null){ duplicateHospitalList =
	 * (List)listMap.get("duplicateHospitalList"); } Users users = new Users();
	 * users.setId(usersId); masUserUsergroupHospital.setUser(users);
	 * //System.out.println("usersId inside bracket  "+usersId); boolean
	 * successfullyAdded = false; if((duplicateHospitalList.size() == 0 ||
	 * duplicateHospitalList == null)) {
	 * 
	 * 
	 * 
	 * usergroupHospital.setId(groupHospitalId);
	 * masUserUsergroupHospital.setGroupHospital(usergroupHospital);
	 * 
	 * masUserUsergroupHospital.setValidUpto(validUpto);
	 * masUserUsergroupHospital.setStatus("y");
	 * masUserUsergroupHospital.setLastChgBy(changedBy);
	 * masUserUsergroupHospital.setLastChgDate(currentDate);
	 * masUserUsergroupHospital.setLastChgTime(currentTime);
	 * 
	 * successfullyAdded =
	 * userMasterHandlerService.addUserHospitalMaintenance(masUserUsergroupHospital
	 * ); if(successfullyAdded){ message="Record Added Successfully !!"; }else{
	 * message="Try Again !!"; } } else if(duplicateHospitalList.size() != 0 ){
	 * 
	 * 
	 * message = "User Name and Hospital Name and Group Name already exist."; }
	 * 
	 * try{ map = userMasterHandlerService.showUserHospitalMaintenanceJsp();
	 * 
	 * }catch (Exception e) { e.printStackTrace(); }
	 * jsp=USER_HOSPITAL_MAINTENANCE_JSP; title="Add User Hospital Maintenance";
	 * jsp += ".jsp"; map.put("contentJsp", jsp); map.put("title", title);
	 * map.put("message", message); return new ModelAndView("index", "map",
	 * map); }
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView addUserHospitalMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		UserUsergroupHospital masUserUsergroupHospital = null;
		int usersId = 0;
		int hospitalId = 0;
		int groupId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date validUpto = new Date();
		try {
			if (request.getParameter(USER_ID) != null) {
				usersId = Integer.parseInt(request.getParameter(USER_ID));
			}
			if (request.getParameter(HOSPITAL_ID) != null) {
				hospitalId = Integer
						.parseInt(request.getParameter(HOSPITAL_ID));
			}
			if (request.getParameter(GROUP_ID) != null) {
				groupId = Integer.parseInt(request.getParameter(GROUP_ID));
			}
			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				currentDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
			}
			if (request.getParameter(VALID_DATE) != null
					&& !(request.getParameter(VALID_DATE).equals(""))) {
				validUpto = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(VALID_DATE));
			}

		/*	map = userMasterHandlerService
					.getGroupHospitalIdFromUsergroupHospital(groupId,
							hospitalId);
			List userGroupList = (List) map.get("groupHospitalIdList");
			UsergroupHospital usergroupHospital = (UsergroupHospital) userGroupList
					.get(0);
			int groupHospitalId = usergroupHospital.getId();*/
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("usersId", usersId);
		//	generalMap.put("groupHospitalId", groupHospitalId);
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("groupId", groupId);

			listMap = userMasterHandlerService
					.checkForExistingHospital(generalMap);
			List duplicateHospitalList = new ArrayList();

			if (listMap.get("duplicateHospitalList") != null) {
				duplicateHospitalList = (List) listMap
						.get("duplicateHospitalList");
			}
			boolean successfullyAdded = false;
			if ((duplicateHospitalList == null || duplicateHospitalList.size() == 0)) {
				masUserUsergroupHospital = new UserUsergroupHospital();
				masUserUsergroupHospital.setUser(new Users(usersId));
				/*masUserUsergroupHospital
						.setGroupHospital(new UsergroupHospital(groupHospitalId));*/
			//	masUserUsergroupHospital.setValidUpto(validUpto);
				MasHospital hospital = new MasHospital();
				hospital.setId(hospitalId);
				masUserUsergroupHospital.setHospital(hospital);
				masUserUsergroupHospital.setStatus("y");
				masUserUsergroupHospital.setLastChgBy(changedBy);
				masUserUsergroupHospital.setLastChgDate(currentDate);
				masUserUsergroupHospital.setLastChgTime(currentTime);
				generalMap.put("masUserUsergroupHospital",
						masUserUsergroupHospital);
				successfullyAdded = userMasterHandlerService
						.addUserHospitalMaintenance(generalMap);
				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			} else if (duplicateHospitalList.size() != 0) {
				message = "User Name and Hospital Name and Group Name already exist.";
			}

			map = userMasterHandlerService
					.showUserHospitalMaintenanceJsp(generalMap);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jsp = USER_HOSPITAL_MAINTENANCE_JSP;
		title = "Add User Hospital Maintenance";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editUserHospitalMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		int groupId = 0;
		int usersId = 0;
		int hospitalId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		Date validUpto = null;
		int userHospitalMaintenanceId = 0;
		if (request.getParameter(COMMON_ID) != null) {
			userHospitalMaintenanceId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(USER_ID) != null) {
			usersId = Integer.parseInt(request.getParameter(USER_ID));
		}
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		/*if (request.getParameter(VALID_DATE) != null
				&& !(request.getParameter(VALID_DATE).equals(""))) {
			validUpto = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(VALID_DATE));
		}*/
		/*if (request.getParameter(GROUP_ID) != null) {
			groupId = Integer.parseInt(request.getParameter(GROUP_ID));
		}*/
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

	/*	map = userMasterHandlerService.getGroupHospitalIdFromUsergroupHospital(
				groupId, hospitalId);
		List userGroupList = (List) map.get("groupHospitalIdList");
		UsergroupHospital usergroupHospital = (UsergroupHospital) userGroupList
				.get(0);
		int groupHospitalId = usergroupHospital.getId();*/

		generalMap.put("id", userHospitalMaintenanceId);
		generalMap.put("usersId", usersId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("flag", true);
	//	generalMap.put("validUpto", validUpto);
	//	generalMap.put("groupHospitalId", groupHospitalId);
		generalMap.put("hospitalId", hospitalId);

		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = userMasterHandlerService.checkForExistingHospital(generalMap);
		List duplicateHospitalList = new ArrayList();

		if (listMap.get("duplicateHospitalList") != null) {
			duplicateHospitalList = (List) listMap.get("duplicateHospitalList");
		}

		boolean dataUpdated = false;
		if ((duplicateHospitalList.size() == 0 || duplicateHospitalList == null)) {
			dataUpdated = userMasterHandlerService
					.editUserHospitalMaintenance(generalMap);
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant be updated !!";
			}
		} else if (duplicateHospitalList.size() != 0) {

			message = "User Name and Hospital Name and Group Name already exist.";
		}

		try {
			map = userMasterHandlerService
					.showUserHospitalMaintenanceJsp(generalMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_HOSPITAL_MAINTENANCE_JSP;
		title = "Edit User Hospital Maintenance";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteUserHospitalMaintenance(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int userHospitalMaintenanceId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";

		session = request.getSession(true);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> generalMap = new HashMap<String, Object>();
		generalMap.put("hospitalId", hospitalId);

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userHospitalMaintenanceId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteUserHospitalMaintenance(
				userHospitalMaintenanceId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = userMasterHandlerService
					.showUserHospitalMaintenanceJsp(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_HOSPITAL_MAINTENANCE_JSP;
		title = "Delete User Hospital Maintenance";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchUserHospitalMaintenance(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				userName = request.getParameter(SEARCH_FIELD);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map = userMasterHandlerService.searchUserHospitalMaintenance(userName);

		jsp = USER_HOSPITAL_MAINTENANCE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getUserGroupForHospital(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		List<Object> userGroupForHospitalList = new ArrayList<Object>();
		userGroupForHospitalList = userMasterHandlerService
				.getUserGroupForHospital(hospitalId);
		map.put("hospitalId", hospitalId);

		String jsp = "";
		String title = "";
		String message = "";

		if (userGroupForHospitalList.size() > 0) {
			session.setAttribute("hospitalId", hospitalId);
			map.put("hospitalId", hospitalId);
			map.put("userGroupForHospitalList", userGroupForHospitalList);

		} else {
			message = "Group is not available !!";
			map.put("error", message);
		}

		jsp = "responseForGroup";
		map.put("jsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	// ********************************************************************************//
	// ***************************** End Modules Written By
	// Mansi********************//
	// ********************************************************************************//

	// ==================================================================================================
	// ======================= start of application module by abha
	// =======================
	// ========================================================================================================
	public ModelAndView showApplicationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("d");
		String jsp = "";
		String title = "";
		String applicationId = "";
		String parentId = "";
		String parentName = "";
		if (request.getParameter(APPLICATION_ID) != null
				&& !(request.getParameter(APPLICATION_ID).equals(""))) {
			applicationId = request.getParameter(APPLICATION_ID);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasApplication> applicationList = new ArrayList<MasApplication>();
		List<UserGroups> groupList = new ArrayList<UserGroups>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List objectList = new ArrayList();
		applicationList = userMasterHandlerService.getApplicationList();
		//groupList = userMasterHandlerService.getGroupList();
		//hospitalList = userMasterHandlerService.getHospitallistList();
		objectList = userMasterHandlerService.getApplicationIdList();
		jsp = RequestConstants.APPLICATION_JSP;
		jsp += ".jsp";
		// map.put("parentName", parentName);
		map.put("objectList", objectList);
		map.put("applicationList", applicationList);
		map.put("groupList", groupList);
		map.put("hospitalList", hospitalList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	// method to add application in masApplication and GroupApplication and
	// userGroupHospital
	@SuppressWarnings("unchecked")
	public ModelAndView addApplication(HttpServletRequest request,
			HttpServletResponse response) {
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		List<MasApplication> applicationList = new ArrayList<MasApplication>();
		
		List<UserGroups> groupList = new ArrayList<UserGroups>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List objectList = new ArrayList();
		boolean successfullyAdded = false;

		infoMap.put("box", box);
		successfullyAdded = userMasterHandlerService.addApplication(infoMap);
		if (successfullyAdded == true) {
			message = "Applications Added Successfully !!";
			map = userMasterHandlerService.showUserList();
		} else {
			message = "Try Again !!";
		}
		applicationList = userMasterHandlerService.getApplicationList();
		//groupList = userMasterHandlerService.getGroupList();
		//hospitalList = userMasterHandlerService.getHospitallistList();
		objectList = userMasterHandlerService.getApplicationIdList();
		jsp = RequestConstants.APPLICATION_JSP;
		jsp += ".jsp";
		// map.put("parentName", parentName);
		map.put("objectList", objectList);
		map.put("applicationList", applicationList);
		map.put("groupList", groupList);
		map.put("hospitalList", hospitalList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addApplication1(HttpServletRequest request,
			HttpServletResponse response) {
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		boolean successfullyAdded = false;

		infoMap.put("box", box);
		successfullyAdded = userMasterHandlerService.addApplication(infoMap);
		if (successfullyAdded == true) {
			message = "Applications Added Successfully !!";
			map = userMasterHandlerService.showUserList();
		} else {
			message = "Try Again !!";
		}
		jsp = MODULE_MANAGEMENT_JSP;
		url = "/hms/hms/user?method=showApplicationJsp";
		title = "Applications";
		jsp += ".jsp";
		map.put("url", url);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * public ModelAndView responseGroupList(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * //System.out.println("inside response group list"); Box box =
	 * HMSUtil.getBox(request); Map<String, Object> map = new HashMap<String,
	 * Object>(); map=userMasterHandlerService.getGroupList(box);
	 * jsp="responseGroupList"; return new ModelAndView(jsp,"map", map); }
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchAndEditApplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = SEARCH_AND_EDIT_APPLICATION;
		jsp += ".jsp";
		title = "Search Application";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getApplicationListByAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));

		}
		dataMap.put("autoHint", autoHint);
		map = userMasterHandlerService
				.getApplicationListByAutocomplete(dataMap);
		jsp = "resultForApplication";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UsergroupHospital> groupList = new ArrayList<UsergroupHospital>();
		List<MasApplication> applicationList = new ArrayList<MasApplication>();
		String applicationName = "";
		String applicationId = "";
		if (request.getParameter(APPLICATION_ID) != null
				&& !(request.getParameter(APPLICATION_ID).equals(""))) {
			applicationId = request.getParameter(APPLICATION_ID);
		}
		int index1 = applicationId.indexOf("[");
		index1 = index1 + 1;
		int index2 = applicationId.indexOf("]");
		String appId = applicationId.substring(index1, index2);
		map = userMasterHandlerService.searchApplication(appId);
		groupList = userMasterHandlerService.getGroupList();
		applicationList = userMasterHandlerService.getApplicationList();
		jsp = SEARCH_AND_EDIT_APPLICATION;
		jsp += ".jsp";
		map.put("applicationList", applicationList);
		map.put("groupList", groupList);
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("applicationName", applicationName);
		map.put("applicationId", applicationId);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateApplication(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		MasApplication masApplication = new MasApplication();
		// GroupApplication groupApplication = new GroupApplication();
		String applicationId = "";
		String applicationName = "";
		String url = "";
		int orderNo = 0;
		String parentId = "";
		String status = "";
		int groupId = 0;
		int groupApplicationId = 0;
		String messageTOBeVisibleToTheUser = "";

		if (request.getParameter("app") != null) {
			applicationId = request.getParameter("app");
		}

		if (request.getParameter("appName") != null) {
			applicationName = request.getParameter("appName");
		}
		if ((request.getParameter("url") != null)) {
			url = request.getParameter("url");
		}
		if (request.getParameter("orderNo") != null) {
			orderNo = Integer.parseInt(request.getParameter("orderNo"));
		}
		if ((box.get("aaaa") != null)) {
			parentId = request.getParameter("aaaa");

		}
		if ((request.getParameter(GROUP_ID) != null)) {
			groupId = Integer.parseInt(request.getParameter(GROUP_ID));
		}

		if ((request.getParameter(GROUP_APP_ID) != null)) {
			groupApplicationId = Integer.parseInt(request
					.getParameter(GROUP_APP_ID));
		}
		if (request.getParameter(STATUS) != null) {
			status = (request.getParameter(STATUS));
		}

		map.put("groupApplicationId", groupApplicationId);
		map.put("masApplication", masApplication);
		map.put("applicationId", applicationId);
		map.put("applicationName", applicationName);
		map.put("url", url);
		map.put("orderNo", orderNo);
		map.put("parentId", parentId);
		map.put("groupId", groupId);
		map.put("status", status);
		map.put("flag", true);
		boolean dataUpdated = false;
		dataUpdated = userMasterHandlerService.updateApplication(map);

		if (dataUpdated == true) {
			message = "Application Updated Successfully !!";
		} else {
			message = "Application Cant Be Updated !!";
		}
		jsp = SEARCH_AND_EDIT_APPLICATION;
		// jsp=MODULE_MANAGEMENT_JSP;
		// url="/hms/hms/user?method=showApplicationJsp";
		title = "update Application";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// ========================== USER DEPARTMENT MASTER by
	// ABHA==========================================
	// -------------------------------------------User Group Hospital
	// --------------------------------------------------
	public ModelAndView showUserDepartmentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = userMasterHandlerService.showUserDepartmentJsp();
		jsp = USER_DEPARTMENT_JSP;
		jsp += ".jsp";
		title = "User Department";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUserDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasEmployeeDepartment masUserDepartment = new MasEmployeeDepartment();
		int userId = 0;
		int departmentId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String[] deptIdArray = null;
		StringBuffer deptStr = new StringBuffer();
		int divisionId=0;
		if (request.getParameter(USER_ID) != null) {
			userId = Integer.parseInt(request.getParameter(USER_ID));
		}
		if (request.getParameter("divisionId") != null) {
			divisionId = Integer.parseInt(request.getParameter("divisionId"));
		}
		if (request.getParameterValues(DEPARTMENT_ID) != null
				&& !request.getParameterValues(DEPARTMENT_ID).equals("0")) {
			deptIdArray = (String[]) (request.getParameterValues(DEPARTMENT_ID));
			for (int i = 0; i < deptIdArray.length; i++) {
				deptStr.append(deptIdArray[i]);
				deptStr.append(",");
			}
			deptStr.deleteCharAt(deptStr.length() - 1);
			generalMap.put("deptStr", deptStr.toString());
		}

		generalMap.put("userId", userId);
		generalMap.put("divisionId", divisionId);
		listMap = userMasterHandlerService
				.checkForExistingUserDepartment(generalMap);
		List duplicateUserDepartmentList = new ArrayList();

		if (listMap.get("duplicateUserDepartmentList") != null) {
			duplicateUserDepartmentList = (List) listMap
					.get("duplicateUserDepartmentList");
		}

		boolean successfullyAdded = false;
		if ((duplicateUserDepartmentList == null || duplicateUserDepartmentList
				.size() == 0)) {
			successfullyAdded = userMasterHandlerService
					.addUserDepartment(generalMap);
			if (successfullyAdded) {
				message = "Record(s) Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if (duplicateUserDepartmentList.size() != 0) {
			message = "User Name already exists. Select the User and Edit the Details!......";
		}

		try {
			map = userMasterHandlerService.showUserDepartmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_DEPARTMENT_JSP;
		title = "Add User Department";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editUserDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		int userDepartmentId = 0;
		int userId = 0;
		int departmentId = 0;

		if (request.getParameter(COMMON_ID) != null) {
			userDepartmentId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		int divisionId=0;
	/*	if (request.getParameter(USER_ID) != null) {
			userId = Integer.parseInt(request.getParameter(USER_ID));
		}*/
		
		if (request.getParameter("userIdHidden") != null) {
			userId = Integer.parseInt(request.getParameter("userIdHidden"));
		}
		
		System.out.println("userId"+userId);
		if (request.getParameter("divisionId") != null) {
			divisionId = Integer.parseInt(request.getParameter("divisionId"));
		}
		String[] departmentIdArray = null;
		StringBuffer departmentStr = new StringBuffer();

		if (request.getParameterValues(DEPARTMENT_ID) != null
				&& request.getParameterValues(DEPARTMENT_ID).length > 0) {
			departmentIdArray = (String[]) (request
					.getParameterValues(DEPARTMENT_ID));

			for (int i = 0; i < departmentIdArray.length; i++) {
				departmentStr.append(departmentIdArray[i]);
				departmentStr.append(",");
			}
			departmentStr.deleteCharAt(departmentStr.length() - 1);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		generalMap.put("id", userDepartmentId);
		generalMap.put("userId", userId);
		generalMap.put("divisionId", divisionId);
		generalMap.put("departmentStr", departmentStr.toString());
		generalMap.put("flag", true);

		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = userMasterHandlerService
				.checkForExistingUserDepartment(generalMap);
		List duplicateUserDepartmentList = new ArrayList();

		if (listMap.get("duplicateUserDepartmentList") != null) {
			duplicateUserDepartmentList = (List) listMap
					.get("duplicateUserDepartmentList");
		}

		boolean dataUpdated = false;
		if ((duplicateUserDepartmentList == null || duplicateUserDepartmentList
				.size() == 0)) {
			message = "User Name and Department Name not exist.";
		} else if (duplicateUserDepartmentList.size() != 0) {
			dataUpdated = userMasterHandlerService
					.editUserDepartment(generalMap);
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant be updated !!";
			}
		}

		try {
			map = userMasterHandlerService.showUserDepartmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_DEPARTMENT_JSP;
		title = "Edit User Department";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteUserDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int userDepartmentId = 0;
		int userId = 0;
		String message = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userDepartmentId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}

		if (request.getParameter(USER_ID) != null) {
			userId = Integer.parseInt(request.getParameter(USER_ID));
			generalMap.put("userId", userId);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteUserDepartment(
				userDepartmentId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = userMasterHandlerService.showUserDepartmentJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_DEPARTMENT_JSP;
		title = "Delete User Department";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchUserDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = userMasterHandlerService.searchUserDepartment(box);
		List users = (List) map.get("users");
		map.put("users", users);
		jsp = RequestConstants.USER_DEPARTMENT_JSP;
		jsp += ".jsp";
		title = "Module Management";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchUserDepartment1(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		String loginName = "";
		String departmentName = "";
		String searchField = null;

		if (request.getParameter(USER_NAME) != null
				&& !(request.getParameter(USER_NAME).equals(""))) {
			userName = request.getParameter(USER_NAME);
		}
		if (request.getParameter(LOGIN_NAME) != null
				&& !(request.getParameter(LOGIN_NAME).equals(""))) {
			loginName = request.getParameter(LOGIN_NAME);
		}
		if (request.getParameter(DEPARTMENT_NAME) != null
				&& !(request.getParameter(DEPARTMENT_NAME).equals(""))) {
			departmentName = request.getParameter(DEPARTMENT_NAME);
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			userName = searchField;
			departmentName = null;
		} else {
			userName = null;
			departmentName = searchField;
		}
		map = userMasterHandlerService.searchUserDepartment(userName,
				departmentName);

		jsp = USER_DEPARTMENT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("userName", userName);
		map.put("departmentName", departmentName);
		return new ModelAndView("indexB", "map", map);
	}

	// added by kalyan
	@SuppressWarnings("unchecked")
	public void getEmpName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List objectList = new ArrayList();
		String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		dataMap.put("serviceNo", serviceNo);
		@SuppressWarnings("unused")
		List<MasEmployee> empList = new ArrayList<MasEmployee>();

		if (!serviceNo.equals("") && serviceNo != null) {
			map = userMasterHandlerService.getEmpName(dataMap);
		}
		boolean existuser=false;
		empList = (List) map.get("empList");
		existuser=(Boolean) map.get("existuser");
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		for (MasEmployee emp : empList) {
			if (emp.getFirstName() != null) {
				sb.append("<employeeName>" + emp.getFirstName() + "</employeeName>");
			} 
			else {
				sb.append("<employeeName>" + "" + "</employeeName>");
				
			}
			if (emp.getLastName() != null) {
				sb.append("<lastName>" +  emp.getLastName() + "</lastName>");
			} 
			else {
				
				sb.append("<lastName>" + "" + "</lastName>");
			}
			if (emp.getId() != null) {
				sb.append("<employeeId>" + emp.getId() + "</employeeId>");
				

			}
			sb.append("<existuser>" + existuser + "</existuser>");
			
			
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
	}

	// end kalyan

	// ===================== end of user department
	// ==========================================================

	// ===================== Methods Written by Vivek
	// =========================Start========================
	public ModelAndView getApplicationForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {

		String appName = "";
		if (request.getParameter(APPLICATION_NAME) != null) {
			appName = (request.getParameter(APPLICATION_NAME));
		}
		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appName", appName);
		map = userMasterHandlerService.getApplicationForAutoComplete(map);
		jsp = "responceApplication";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		return new ModelAndView(jsp, "map", map);
	}

	public void getUrl(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List objectList = new ArrayList();
		int appId = 0;
		if (request.getParameter("appId") != null) {
			appId = Integer.parseInt("" + request.getParameter("appId"));
		}
		dataMap.put("appId", appId);
		@SuppressWarnings("unused")
		List<UserApplications> userApplicationsList = new ArrayList<UserApplications>();

		if (appId != 0) {
			map = userMasterHandlerService.getUrl(dataMap);
		}
		userApplicationsList = (List<UserApplications>) map
				.get("userApplicationsList");
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		for (UserApplications userApplications : userApplicationsList) {
			StringBuffer output_str = new StringBuffer();
			StringTokenizer s = new StringTokenizer(userApplications.getUrl()
					.toString(), "&");
			while (s.hasMoreTokens()) {
				output_str.append(s.nextToken());
				if (s.hasMoreTokens()) {
					output_str.append("\'");
				}
			}
			sb.append("<url>" + output_str.toString() + "</url>");
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

	}

	public ModelAndView getParentApplication(HttpServletRequest request,
			HttpServletResponse response) {

		String prAppName = "a";
		if (request.getParameter("prId") != null) {
			prAppName = ("" + request.getParameter("prId"));
		}
		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prAppName", prAppName);
		map = userMasterHandlerService.getParentApplication(map);
		jsp = "responceParentApplication";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		return new ModelAndView(jsp, "map", map);
	}

	public void getSubParentApplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasApplication> masApplicationList = new ArrayList<MasApplication>();

		String parentId = "";
		if (request.getParameter("parentId") != null) {
			parentId = request.getParameter("parentId");
		}
		dataMap.put("parentId", parentId);

		if (parentId != "") {
			map = userMasterHandlerService.getSubParentApplication(dataMap);
		}
		masApplicationList = (List) map.get("masApplicationList");
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<masApplicationLists>");
		try {
			for (Iterator iterator = masApplicationList.iterator(); iterator
					.hasNext();) {
				MasApplication masApplication = (MasApplication) iterator
						.next();

				sb.append("<masApplicationList>");
				sb.append("<masApplicationId>" + masApplication.getId()
						+ "</masApplicationId>");

				StringBuffer output_str = new StringBuffer();
				StringTokenizer s = new StringTokenizer(masApplication
						.getName().toString(), "&");

				while (s.hasMoreTokens()) {
					output_str.append(s.nextToken());
				}
				sb.append("<masApplicationName>" + output_str.toString()
						+ "</masApplicationName>");
				sb.append("</masApplicationList>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sb.append("</masApplicationLists>");
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
	}

	// ------------------------User Application----------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showUserApplicationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = userMasterHandlerService.showUserApplicationJsp();
		jsp = USER_APPLICATION_JSP;
		jsp += ".jsp";
		title = "UserApplication";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchUserApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String applicationName = null;
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			applicationName = request.getParameter(SEARCH_NAME);
		}

		map = userMasterHandlerService.searchUserApplication(applicationName);
		jsp = USER_APPLICATION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("applicationName", applicationName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUserApplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserApplications userApplications = new UserApplications();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(URL) != null) {
			url = request.getParameter(URL);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("url", url);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List urlList = new ArrayList();
		List applicationNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			urlList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			applicationNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((urlList.size() == 0 || urlList == null)
				&& (applicationNameList.size() == 0 || applicationNameList == null)) {
			userApplications.setUrl(url);
			userApplications.setAppName(name);
			userApplications.setStatus("y");
			userApplications.setLastChgBy(changedBy);
			userApplications.setLastChgDate(currentDate);
			userApplications.setLastChgTime(currentTime);
			System.out.println("ss");
			successfullyAdded = userMasterHandlerService
					.addUserApplication(userApplications);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((urlList.size() != 0 || urlList != null)
				|| (applicationNameList.size() != 0)
				|| applicationNameList != null) {
			if ((urlList.size() != 0 || urlList != null)
					&& (applicationNameList.size() == 0 || applicationNameList == null)) {
				message = "Url already exists.";
			} else if ((applicationNameList.size() != 0 || applicationNameList != null)
					&& (urlList.size() == 0 || urlList == null)) {
				message = "Application Name already exists.";
			} else if ((urlList.size() != 0 || urlList != null)
					&& (applicationNameList.size() != 0 || applicationNameList != null)) {
				message = "Url and Application Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showUserApplicationJsp";
		try {
			map = userMasterHandlerService.showUserApplicationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_APPLICATION_JSP;
		title = "Add UserApplication";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editUserApplication(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String url = "";
		String applicationName = "";
		int userApplicationId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userApplicationId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(URL) != null
				&& !(request.getParameter(URL).equals(""))) {
			url = request.getParameter(URL);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			applicationName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", userApplicationId);
		generalMap.put("url", url);
		generalMap.put("name", applicationName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingApplicationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingApplicationNameList.size() == 0) {

			dataUpdated = userMasterHandlerService
					.editUserApplication(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingApplicationNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showUserApplicationJsp";
		try {
			map = userMasterHandlerService.showUserApplicationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_APPLICATION_JSP;
		title = "Update User Application";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteUserApplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int userApplicationId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userApplicationId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteUserApplication(
				userApplicationId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showUserApplicationJsp";
		try {
			map = userMasterHandlerService.showUserApplicationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_APPLICATION_JSP;
		title = "Delete User Application";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ===================== Methods Written by Vivek
	// =========================End==========================
	// ------------------code for adding emp groups---------------
	// ===================== Methods Written by
	// Vikas=====================================

	@SuppressWarnings("unchecked")
	public ModelAndView showGroupsJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = userMasterHandlerService.showGroupsJsp();
		String jsp = "empGroups";
		jsp += ".jsp";
		title = "User Groups";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchEmpGroups(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String empGroupsCode = null;
		String empGroupsName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			empGroupsCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			empGroupsName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			empGroupsCode = searchField;
			empGroupsName = null;

		} else {
			empGroupsCode = null;
			empGroupsName = searchField;
		}
		map = userMasterHandlerService.searchEmpGroups(empGroupsCode,
				empGroupsName);

		jsp = "empGroups";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("empGroupsCode", empGroupsCode);
		map.put("empGroupsName", empGroupsName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addEmpGroups(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		EmpGroups masUserGroups = new EmpGroups();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List userGroupsCodeList = new ArrayList();
		List userGroupsNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			userGroupsCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			userGroupsNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((userGroupsCodeList.size() == 0 || userGroupsCodeList == null)
				&& (userGroupsNameList.size() == 0 || userGroupsNameList == null)) {
			masUserGroups.setEmpGroupCode(code);
			masUserGroups.setEmpGroupName(name);
			masUserGroups.setStatus("y");
			masUserGroups.setLastChgBy(changedBy);
			masUserGroups.setLastChgDate(currentDate);
			masUserGroups.setLastChgTime(currentTime);
			successfullyAdded = userMasterHandlerService
					.addEmpGroups(masUserGroups);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
				|| (userGroupsNameList.size() != 0)
				|| userGroupsNameList != null) {
			if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
					&& (userGroupsNameList.size() == 0 || userGroupsNameList == null)) {

				message = "Employee Groups Code  already exists.";
			} else if ((userGroupsNameList.size() != 0 || userGroupsNameList != null)
					&& (userGroupsCodeList.size() == 0 || userGroupsCodeList == null)) {

				message = "Employee Groups Name already exists.";
			} else if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
					&& (userGroupsNameList.size() != 0 || userGroupsNameList != null)) {

				message = "Employee Groups Code and Employee Groups Name already exist.";
			}
		}

		try {
			map = userMasterHandlerService.showGroupsJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "empGroups";
		title = "Add User Groups";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editEmpGroups(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String empGroupsCode = "";
		String empGroupsName = "";
		int userGroupsId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			empGroupsCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			empGroupsName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", userGroupsId);
		generalMap.put("empGroupsCode", empGroupsCode);
		generalMap.put("name", empGroupsName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingUserGroupsNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingUserGroupsNameList.size() == 0) {
			dataUpdated = userMasterHandlerService
					.editEmpGroupsToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingUserGroupsNameList.size() > 0) {
			message = "Name already exists.";
		}
		// url = "/security/security/user?method=showUserGroupsJsp";

		try {
			map = userMasterHandlerService.showGroupsJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "empGroups";
		title = "update User Groups";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteEmpGroups(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int empGroupsId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			empGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteEmpGroups(empGroupsId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		// url = "/security/security/user?method=showUserGroupsJsp";

		try {
			map = userMasterHandlerService.showGroupsJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "empGroups";
		title = "delete UserGroups";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// --------------------End of code for adding emp groups-----------------

	public ModelAndView showButtonMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = userMasterHandlerService.showButtonMasterJsp();
		jsp = "buttonForm";
		title = "Button Details";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView addButtonDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasButtonForm masButtonForm = new MasButtonForm();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String url = "";
		String formName = "";
		String cssClass = "";
		String formulaUsed = "";
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			formName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("url") != null) {
			url = request.getParameter("url");
		}
		if (request.getParameter("cssClass") != null) {
			cssClass = request.getParameter("cssClass");
		}
		if (request.getParameter("formulaUsed") != null) {
			formulaUsed = request.getParameter("formulaUsed");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("formName", formName);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List userGroupsCodeList = new ArrayList();
		List userGroupsNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			userGroupsCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			userGroupsNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((userGroupsCodeList.size() == 0 || userGroupsCodeList == null)
				&& (userGroupsNameList.size() == 0 || userGroupsNameList == null)) {
			masButtonForm.setButtonName(code);
			masButtonForm.setFormName(formName);
			masButtonForm.setUrl(url);
			masButtonForm.setStatus("y");
			masButtonForm.setLastChgBy(changedBy);
			masButtonForm.setLastChgDate(currentDate);
			masButtonForm.setLastChgTime(currentTime);
			masButtonForm.setClassName(cssClass);
			masButtonForm.setFormulaUsed(formulaUsed);
			successfullyAdded = userMasterHandlerService
					.addButtonDetails(masButtonForm);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
				|| (userGroupsNameList.size() != 0)
				|| userGroupsNameList != null) {
			if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
					&& (userGroupsNameList.size() == 0 || userGroupsNameList == null)) {

				message = "Button Name  already exists.";
			} else if ((userGroupsNameList.size() != 0 || userGroupsNameList != null)
					&& (userGroupsCodeList.size() == 0 || userGroupsCodeList == null)) {

				message = "Form Name already exists.";
			} else if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
					&& (userGroupsNameList.size() != 0 || userGroupsNameList != null)) {

				message = "Button Name and Form Name already exist.";
			}
		}
		try {
			map = userMasterHandlerService.showButtonMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "buttonForm";
		title = "Add Button Details";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editButtonDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String buttonName = "";
		String formName = "";
		int masButtonId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String url = "";
		String cssClass = "";
		String formulaUsed = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			masButtonId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			buttonName = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			formName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("url") != null
				&& !(request.getParameter("url").equals(""))) {
			url = request.getParameter("url");
		}
		if (request.getParameter("cssClass") != null) {
			cssClass = request.getParameter("cssClass");
		}
		if (request.getParameter("formulaUsed") != null) {
			formulaUsed = request.getParameter("formulaUsed");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", masButtonId);
		generalMap.put("buttonName", buttonName);
		generalMap.put("name", formName);
		generalMap.put("url", url);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("cssClass", cssClass);
		generalMap.put("formulaUsed", formulaUsed);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		// listMap =
		// commonMasterHandlerService.checkForExistingMasters(generalMap);
		// List existingUserGroupsNameList =
		// (List)listMap.get("duplicateMastersList");

		boolean dataUpdated = userMasterHandlerService
				.editButtonDetails(generalMap);
		;

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}

		/*
		 * else if(existingUserGroupsNameList.size() > 0){ message =
		 * "Name already exists."; }
		 */
		// url = "/security/security/user?method=showUserGroupsJsp";

		try {
			map = userMasterHandlerService.showButtonMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "buttonForm";
		title = "update Button Details";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteButtonDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int buttonId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			buttonId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteButtonDetails(buttonId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		// url = "/security/security/user?method=showHospitalJsp";
		try {
			map = userMasterHandlerService.showButtonMasterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "buttonForm";
		title = "Delete Button Details";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getUserGroups(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		
		map = userMasterHandlerService.getUerGroupDetails(box);

		jsp = "userGroupPopUp";
		title = "User Group Details";
		// jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	// / for future this method can be used to encrypt all the passwords in the
	// database at one call of this method

	/*
	 * public ModelAndView encryptAllUserPassword(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletRequestBindingException { int
	 * hospitalId=0; hospitalId=(Integer)session.getAttribute("hospitalId");
	 * Map<String, Object> map = new HashMap<String, Object>(); boolean bool =
	 * userMasterHandlerService.encryptAllUserPassword(); if(bool){ map =
	 * userMasterHandlerService.showUserJsp(hospitalId); } jsp=USER_JSP; jsp +=
	 * ".jsp"; title="delete UserGroups"; map.put("contentJsp",jsp);
	 * map.put("title", title);
	 * 
	 * return new ModelAndView("index", "map", map);
	 * 
	 * }
	 */

	// /////////SECURITY Template Part////////////////

	@SuppressWarnings("unused")
	public ModelAndView showTemplateJsp(HttpServletRequest request,HttpServletResponse response) {
		
		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		List<MasApplication> moduleList = new ArrayList<MasApplication>();
		moduleList = userMasterHandlerService.getModuleListForTemplate();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		templateList = userMasterHandlerService.getTemplateList();
		List<MasButtonForm> formList = new ArrayList<MasButtonForm>();
		formList = userMasterHandlerService.getFormList();
		map.put("moduleList", moduleList);
		map.put("templateList", templateList);
		map.put("formList", formList);
		jsp = "templateCreation";
		jsp += ".jsp";
		title = "Template";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getApplicationListForTemplate(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		String parentId = request.getParameter("parentId");
		String templateId = request.getParameter(RequestConstants.TEMPLATE);
		map = userMasterHandlerService.populateApplications(parentId,templateId);
		jsp = "applicationListForTemplate";
		title = "Template";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showTemplateMaster(HttpServletRequest request,HttpServletResponse response) {
		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = userMasterHandlerService.showTemplateJsp();
		jsp = "masTemplate";
		jsp += ".jsp";
		title = "Template";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasTemplate masTemplate = new MasTemplate();
		session = request.getSession(true);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		int parentId=0;
		int employeeCategoryId=0;
		if (request.getParameter("parentId") != null) {
			parentId = Integer.parseInt(request.getParameter("parentId"));
		}
		if (request.getParameter("employeeCategoryId") != null) {
			employeeCategoryId = Integer.parseInt(request.getParameter("employeeCategoryId"));
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List templateCodeList = new ArrayList();
		List templateNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			templateCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			templateNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((templateCodeList.size() == 0 || templateCodeList == null)
				&& (templateNameList.size() == 0 || templateNameList == null)) {
			masTemplate.setTemplateCode(code);
			masTemplate.setTemplateName(name);
			masTemplate.setStatus("y");
			masTemplate.setLastChgBy(changedBy);
			masTemplate.setLastChgDate(currentDate);
			masTemplate.setLastChgTime(currentTime);
			if(parentId>0){
				MasTemplate masTemplate2=new MasTemplate();
				masTemplate2.setId(parentId);
				masTemplate.setTemplate(masTemplate2);
			}
			if(employeeCategoryId>0){
				MasEmpCategory masEmpCategory=new MasEmpCategory();
				masEmpCategory.setId(employeeCategoryId);
				masTemplate.setEmpCategory(masEmpCategory);
			}
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			masTemplate.setDept(masDepartment);
			MasHospital masHosp = new MasHospital();
			masHosp.setId(hospitalId);
			masTemplate.setHospital(masHosp);

			successfullyAdded = userMasterHandlerService
					.addTemplate(masTemplate);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((templateCodeList.size() != 0 || templateCodeList != null)
				|| (templateNameList.size() != 0) || templateNameList != null) {
			if ((templateCodeList.size() != 0 || templateCodeList != null)
					&& (templateNameList.size() == 0 || templateNameList == null)) {

				message = "Template Code  already exists.";
			} else if ((templateNameList.size() != 0 || templateNameList != null)
					&& (templateCodeList.size() == 0 || templateCodeList == null)) {

				message = "Template Name already exists.";
			} else if ((templateCodeList.size() != 0 || templateCodeList != null)
					&& (templateNameList.size() != 0 || templateNameList != null)) {

				message = "Template Code and Template Name already exist.";
			}
		}

		try {
			map = userMasterHandlerService.showTemplateJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "masTemplate";
		title = "Add Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editTemplate(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String templateCode = "";
		String templateName = "";
		int userGroupsId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			templateCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			templateName = request.getParameter(SEARCH_NAME);
		}
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		int deptId = (Integer) session.getAttribute("deptId");
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		int parentId=0;
		int employeeCategoryId=0;
		if (request.getParameter("parentId") != null) {
			parentId = Integer.parseInt(request.getParameter("parentId"));
		}
		if (request.getParameter("employeeCategoryId") != null) {
			employeeCategoryId = Integer.parseInt(request.getParameter("employeeCategoryId"));
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", userGroupsId);
		generalMap.put("templateCode", templateCode);
		generalMap.put("templateName", templateName);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("deptId", deptId);

		generalMap.put("parentId", parentId);
		generalMap.put("employeeCategoryId", employeeCategoryId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingHospitalNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingHospitalNameList.size() == 0) {
			dataUpdated = userMasterHandlerService.editTemplate(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingHospitalNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/user?method=showTemplateMaster";

		try {
			map = userMasterHandlerService.showTemplateJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "masTemplate";
		title = "update Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView searchTemplate(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String templateCode = null;
		String templateName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			templateCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			templateName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			templateCode = searchField;
			templateName = null;

		} else {
			templateCode = null;
			templateName = searchField;
		}
		map = userMasterHandlerService.searchTemplate(templateCode,
				templateName);

		jsp = "masTemplate";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("templateCode", templateCode);
		map.put("templateName", templateName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int templateId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			templateId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteTemplate(templateId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/user?method=showTemplateMaster";

		try {
			map = userMasterHandlerService.showTemplateJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "masTemplate";
		title = "delete template";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitApplicationWiseTemplate(
			HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		session = request.getSession();
		String message = null;
		int templateId = Integer.parseInt(request.getParameter("template"));
		String template = (String) request.getParameter("template");
		String[] str = request.getParameterValues("appId");
		String parentId = request.getParameter("parentId");
		//System.out.println("parentId-5335--cc---->"+parentId);
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}

		String[] button = request.getParameterValues("buttonName");
		List groupApplicationList = new ArrayList();
	//	groupApplicationList.add(parentId);
	//	System.out.println(templateId+"<--templateId--App Id-str.length-->"+str.length);
		if (str != null) {
			for (int j = 0; j < str.length; j++) {

				String appId = (str[j]);
				//System.out.println("App Id-->"+appId);
				datamap.put("appId", appId);
				groupApplicationList.add(appId);
			}
		}
		List buttonList = new ArrayList();
		if (button != null) {
			for (int k = 0; k < button.length; k++) {

				Integer buttonId = Integer.parseInt(button[k].toString());
				datamap.put("buttonId", buttonId);
				
				buttonList.add(buttonId);
			}
		}
		datamap.put("templateId", templateId);
		datamap.put("groupApplicationList", groupApplicationList);
		datamap.put("parentId", parentId);
		datamap.put("userName", userName);
		datamap.put("buttonList", buttonList);

		boolean successfullyAdded = userMasterHandlerService
				.submitTemplateWiseApplication(datamap);
		List<MasApplication> moduleList = new ArrayList<MasApplication>();
		moduleList = userMasterHandlerService.getModuleListForTemplate();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		map = userMasterHandlerService.getTemplateModuleList(template);
		List<MasButtonForm> formList = new ArrayList<MasButtonForm>();
		formList = userMasterHandlerService.getFormList();
		if (successfullyAdded) {
			message = "Module has been Assigned to the template";
			jsp = "templateCreation";
		} else {
			message = "Error Ocurred Please Try Again";
			jsp = "templateCreation";
		}
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("moduleList", moduleList);
		map.put("templateId", templateId);
		map.put("formList",formList);
		
		// map.put("templateList", templateList);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAssignTemplateToUser(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		List empGroupList = new ArrayList();
		empGroupList = userMasterHandlerService.getEmpGroupForTemplate();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		templateList = userMasterHandlerService.getTemplateList();

		map.put("empGroupList", empGroupList);
		map.put("templateList", templateList);
		jsp = "showAssignTemplateToUser";
		jsp += ".jsp";
		title = "Template";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");

		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView getUsersList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int empGroup = (Integer.parseInt(request.getParameter("empGroup")));
		map = userMasterHandlerService.getUserList(empGroup);
		List<UserEmpGroup> empGrpList = new ArrayList<UserEmpGroup>();
		empGrpList = (List<UserEmpGroup>) map.get("empGrpList");
		int templateId = 0;
		if (request.getParameter("template") != null) {
			templateId = Integer.parseInt(request.getParameter("template"));
		}
		int empGroupId = 0;
		if (request.getParameter("empGroup") != null) {
			empGroupId = Integer.parseInt(request.getParameter("empGroup"));
		}
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		map = userMasterHandlerService.getTemplateApplicationList(templateId,
				hospitalId);
		List<TemplateApplication> tempAppList = new ArrayList<TemplateApplication>();
		tempAppList = (List) map.get("tempAppList");
		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		buttonTemplateList = (List<Integer>) map.get("buttonTemplateList");
		List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
		userTemplateList = userMasterHandlerService
				.getUsersListFromUserTemplate(templateId, empGroupId);

		jsp = "userListForTemplate";
		title = "User Management";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("empGrpList", empGrpList);
		map.put("userTemplateList", userTemplateList);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView assignTemplateToUser(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		String message = null;
		String[] arr = request.getParameterValues("userId");
		int templateId = 0;
		if (request.getParameter("template") != null) {
			templateId = Integer.parseInt(request.getParameter("template"));
		}

		int empGroupId = 0;
		if (request.getParameter("empGroup") != null) {
			empGroupId = Integer.parseInt(request.getParameter("empGroup"));
		}
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		map = userMasterHandlerService.getTemplateApplicationList(templateId,
				hospitalId);
		List<Object> grpAppList = new ArrayList<Object>();
		grpAppList = (List<Object>) map.get("grpAppList");
		List<Object> usrGrpHospList = new ArrayList<Object>();
		usrGrpHospList = (List<Object>) map.get("usrGrpHospList");
		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		buttonTemplateList = (List<Integer>) map.get("buttonTemplateList");

		map = userMasterHandlerService.getDepartmentTemplateList(templateId,hospitalId);
		 List<Integer> DepartmentTemplateList = new ArrayList<Integer>();
	        if(map.get("DepartmentTemplateList") != null){
	        	DepartmentTemplateList = (List<Integer>)map.get("DepartmentTemplateList");
	        }
	        
		List<Integer> userIdList = new ArrayList<Integer>();
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				int userId1 = Integer.parseInt(arr[i]);
				userIdList.add(userId1);
			}
			dataMap.put("userIdList", userIdList);
		}

		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		dataMap.put("userName", userName);
		dataMap.put("templateId", templateId);
		dataMap.put("grpAppList", grpAppList);
		dataMap.put("usrGrpHospList", usrGrpHospList);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("empGroupId", empGroupId);
		dataMap.put("buttonTemplateList", buttonTemplateList);
		dataMap.put("DepartmentTemplateList", DepartmentTemplateList);
		List empGroupList = new ArrayList();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();

		boolean successfullyAdded = userMasterHandlerService
				.addUserWiseTemplate(dataMap);
		empGroupList = userMasterHandlerService.getEmpGroupForTemplate();
		templateList = userMasterHandlerService.getTemplateList();
		if (successfullyAdded) {
			message = "Template Has Been Assigned To The User";
			jsp = "showAssignTemplateToUser";
		} else {
			message = "Error Ocurred Please Try Again";
			jsp = "showAssignTemplateToUser";
		}

		jsp += ".jsp";
		map.put("empGroupList", empGroupList);
		map.put("templateList", templateList);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView viewAssignTemplateToUser(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		int templateId = 0;
		int empGroupId = 0;
		if (request.getParameter("template") != null) {
			templateId = Integer.parseInt(request.getParameter("template"));
		}
		if (request.getParameter("empGroup") != null) {
			empGroupId = Integer.parseInt(request.getParameter("empGroup"));
		}
		List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
		empGroupList = userMasterHandlerService.getEmpGroupForTemplate();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		templateList = userMasterHandlerService.getTemplateList();

		List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
		userTemplateList = userMasterHandlerService
				.getUsersListFromUserTemplate(templateId, empGroupId);

		int hospitalId = (Integer) session.getAttribute("hospitalId");
		map = userMasterHandlerService.getTemplateApplicationList(templateId,
				hospitalId);
		List<Object> grpAppList = new ArrayList<Object>();
		grpAppList = (List<Object>) map.get("grpAppList");
		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		buttonTemplateList = (List<Integer>)map.get("buttonTemplateList");

		map.put("empGroupList", empGroupList);
		map.put("templateList", templateList);
		map.put("templateId", templateId);
		map.put("empGroupId", empGroupId);
		map.put("userTemplateList", userTemplateList);
		map.put("buttonTemplateList", buttonTemplateList);
		jsp = "viewAssignTemplateTouser";
		jsp += ".jsp";
		title = "Template";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editAssignTemplateToUser(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Integer> userIdList = new ArrayList<Integer>();
		List<Integer> unSelectedUserIdList = new ArrayList<Integer>();
		List<String> selectedUserIdList = new ArrayList<String>();
		session = request.getSession();
		String message = null;
		int templateId = 0;
		if (request.getParameter("template") != null) {
			templateId = Integer.parseInt(request.getParameter("template"));
		}

		int empGroupId = 0;
		if (request.getParameter("empGroup") != null) {
			empGroupId = Integer.parseInt(request.getParameter("empGroup"));
		}

		List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
		userTemplateList = userMasterHandlerService
				.getUsersListFromUserTemplate(templateId, empGroupId);
		
		for(UserTemplate userTemplate :userTemplateList ){
			userIdList.add(userTemplate.getUser().getId());
		}
		
		String[] arr = request.getParameterValues("userId");
		if(arr!=null && arr.length>0){
		selectedUserIdList = Arrays.asList(arr);
		}
		int userId1 =0;
		if (arr != null) {
			
			for(Integer integer : userIdList){
				if(!selectedUserIdList.contains(integer.toString())){
					unSelectedUserIdList.add(integer);
				}
				
			}
			
		}else if(arr==null){
			unSelectedUserIdList = userIdList;
		}
		dataMap.put("userTempUserid", unSelectedUserIdList);
 		
		/*int userTempUserid =0;
		if (userTemplateList.size() > 0) {
			for (UserTemplate userTemplate : userTemplateList) {
				userTempUserid = userTemplate.getUser().getId();
				dataMap.put("userTempUserid", userTempUserid);
			}
		}*/

		int hospitalId = (Integer) session.getAttribute("hospitalId");
		map = userMasterHandlerService.getTemplateApplicationList(templateId,
				hospitalId);

		List<Object> grpAppList = new ArrayList<Object>();
		grpAppList = (List<Object>) map.get("grpAppList");

		List<Object> usrGrpHospList = new ArrayList<Object>();
		usrGrpHospList = (List<Object>) map.get("usrGrpHospList");
		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		buttonTemplateList = (List<Integer>)map.get("buttonTemplateList");

		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		dataMap.put("userName", userName);
		dataMap.put("templateId", templateId);
		dataMap.put("grpAppList", grpAppList);
		dataMap.put("usrGrpHospList", usrGrpHospList);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("empGroupId", empGroupId);
		dataMap.put("userTemplateList", userTemplateList);
		dataMap.put("buttonTemplateList", buttonTemplateList);

		boolean successfullyAdded = userMasterHandlerService
				.editUserWiseTemplate(dataMap);

		List empGroupList = new ArrayList();
		empGroupList = userMasterHandlerService.getEmpGroupForTemplate();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		templateList = userMasterHandlerService.getTemplateList();
		if (successfullyAdded) {
			message = "Template has been removed ";
			jsp = "showAssignTemplateToUser";
		} else {
			message = "Error Ocurred Please Try Again";
			jsp = "showAssignTemplateToUser";
		}
		jsp += ".jsp";
		map.put("empGroupList", empGroupList);
		map.put("templateList", templateList);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showTemplateModulesJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasApplication> moduleList = new ArrayList<MasApplication>();
		moduleList = userMasterHandlerService.getModuleListForTemplate();
		String templateId = request.getParameter(RequestConstants.TEMPLATE);
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		map = userMasterHandlerService.getTemplateModuleList(templateId);
		map.put("moduleList", moduleList);
		// map.put("templateList", templateList);
		List<MasButtonForm> formList = new ArrayList<MasButtonForm>();
		formList = userMasterHandlerService.getFormList();
		map.put("formList", formList);
		jsp = "templateCreation";
		jsp += ".jsp";
		title = "Template";
		map.put("templateId", templateId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getButtonListForForm(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		String parentId = request.getParameter("parentId");
		String templateId = request.getParameter(RequestConstants.TEMPLATE);
		String formName = request.getParameter("formName");
		map = userMasterHandlerService.getButtonList(formName);
		jsp = "buttonListForForm";
		title = "Template";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAppGroup(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasApplicationgroup masAppGroup = new MasApplicationgroup();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String code ="";
		String name ="";
		String changedBy="";
		String currentTime ="";
		String pojoPropertyCode = "";
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List appGroupCodeList = new ArrayList();
		List appGroupNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			appGroupCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			appGroupNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((appGroupCodeList.size() == 0 || appGroupCodeList == null)
				&& (appGroupNameList.size() == 0 || appGroupNameList == null)) {
			masAppGroup.setApplicationgroupCode(code);
			masAppGroup.setApplicationgroupName(name);
			masAppGroup.setStatus("y");
			masAppGroup.setLastChgBy(changedBy);
			masAppGroup.setLastChgDate(currentDate);
			masAppGroup.setLastChgTime(currentTime);
			successfullyAdded = userMasterHandlerService
					.addApplicationGroup(masAppGroup);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((appGroupCodeList.size() != 0 || appGroupCodeList != null)
				|| (appGroupNameList.size() != 0) || appGroupNameList != null) {
			if ((appGroupCodeList.size() != 0 || appGroupCodeList != null)
					&& (appGroupNameList.size() == 0 || appGroupNameList == null)) {

				message = "Application Group Code  already exists.";
			} else if ((appGroupNameList.size() != 0 || appGroupNameList != null)
					&& (appGroupCodeList.size() == 0 || appGroupCodeList == null)) {

				message = "Application Group Name already exists.";
			} else if ((appGroupCodeList.size() != 0 || appGroupCodeList != null)
					&& (appGroupNameList.size() != 0 || appGroupNameList != null)) {

				message = "Application Group Code and Application Group Name already exist.";
			}
		}

		try {
			map = userMasterHandlerService.showAppGroup();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "masApplicationGroup";
		title = "Add Application Group";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editApplicationGroup(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String appGroupCode = "";
		String appGroupName = "";
		int appGroupId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			appGroupId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			appGroupCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			appGroupName = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", appGroupId);
		generalMap.put("appGroupCode", appGroupCode);
		generalMap.put("appGroupName", appGroupName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingHospitalNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingHospitalNameList.size() == 0) {
			dataUpdated = userMasterHandlerService
					.editAppGroup(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingHospitalNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/user?method=showAppGroup";

		try {
			map = userMasterHandlerService.showAppGroup();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "masApplicationGroup";
		title = "update Application group";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteAppGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int appGroupId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			appGroupId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteApplicationGroup(appGroupId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/superAdmin?method=showAppGroup";

		try {
			map = userMasterHandlerService.showAppGroup();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "masApplicationGroup";
		title = "delete Application Group";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchAppGroup(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String appGroupCode = null;
		String appGroupName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			appGroupCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			appGroupName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			appGroupCode = searchField;
			appGroupName = null;

		} else {
			appGroupCode = null;
			appGroupName = searchField;
		}
		map = userMasterHandlerService.searchAppGroup(appGroupCode, appGroupName);

		jsp = "masApplicationGroup";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("appGroupCode", appGroupCode);
		map.put("appGroupName", appGroupName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAsssignParentJsp(HttpServletRequest request,HttpServletResponse response) {
		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map = userMasterHandlerService.getParentList();
		jsp = RequestConstants.APP_PARENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	
	public ModelAndView submitParentAndGroup(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		session = request.getSession();
		String message = null;
		int appGroupId = Integer.parseInt(request.getParameter("appGroupId"));
		String[] str = request.getParameterValues("buttonName");
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}

		List parentList = new ArrayList();
		if (str != null) {
			for (int j = 0; j < str.length; j++) {

				String appId = (str[j]);
				datamap.put("appId", appId);
				parentList.add(appId);
			}
		}
		datamap.put("parentList", parentList);
		datamap.put("userName", userName);
		datamap.put("appGroupId", appGroupId);

		boolean successfullyAdded = userMasterHandlerService
				.submitParentAndGroup(datamap);
		if (successfullyAdded) {
			map = userMasterHandlerService.getParentList();
			message = "Applications Are assigned to The group";
			jsp = RequestConstants.APP_PARENT_JSP;

		} else {
			map = userMasterHandlerService.getParentList();
			message = "Error Ocurred Please Try Again";
			jsp = RequestConstants.APP_PARENT_JSP;

		}
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAppGroup(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map =userMasterHandlerService.showAppGroup();
		String jsp = "masApplicationGroup";
		jsp += ".jsp";
		title = "Application Group";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	// =========================End==========================
	public ModelAndView getDepartmentListForTemplate(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		String parentId = request.getParameter("parentId");
		String templateId = request.getParameter(RequestConstants.TEMPLATE);
		map = userMasterHandlerService.populateDepartment(templateId);
		jsp = "departmentListForTemplate";
		title = "Template";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitDepartmentWiseTemplate(
			HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		session = request.getSession();
		String message = null;
		int templateId = Integer.parseInt(request.getParameter("template"));
		String template = (String) request.getParameter("template");
		List depList = new ArrayList(); 
		String userName = "";
		int count = 0;
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if(request.getParameter("countVal") != null ){
			 count = Integer.parseInt(request.getParameter("countVal"));
		}
		datamap.put("templateId", templateId);
		datamap.put("userName", userName);
		int depId = 0;
		for(int j=0;j<=count;j++){
			if(request.getParameter("depChk"+j)!= null){
				
				if(request.getParameter("depChk"+j).equalsIgnoreCase("yes")){
					
					depId = Integer.parseInt(request.getParameter("depId"+j));
					depList.add(depId);
				}
			}
		}
		datamap.put("depList", depList); 
		boolean successfullyAdded = userMasterHandlerService
				.submitTemplateWiseDepartment(datamap);
		List<MasApplication> moduleList = new ArrayList<MasApplication>();
		moduleList = userMasterHandlerService.getModuleListForTemplate();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		map = userMasterHandlerService.getTemplateModuleList(template);
		List<MasButtonForm> formList = new ArrayList<MasButtonForm>();
		formList = userMasterHandlerService.getFormList();
		if (successfullyAdded) {
			message = "Department has been Assigned to the template";
			jsp = "templateCreation";
		} else {
			message = "Error Ocurred Please Try Again";
			jsp = "templateCreation";
		}
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("moduleList", moduleList);
		map.put("templateId", templateId);
		map.put("formList",formList);
		// map.put("templateList", templateList);
		return new ModelAndView("indexB", "map", map);
	}
	
	//--merge by Dipali 1/jul/2010---
	public ModelAndView showResponseAsssignParentJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int appGroupId = 0;
		List<AssignParentToApplicationgroup> assignAppList = new ArrayList<AssignParentToApplicationgroup>();
		if (request.getParameter("appGroupId") != null && !request.getParameter("appGroupId").equals("")) {
			appGroupId = Integer.parseInt(request.getParameter("appGroupId"));
		}
		
		parameterMap.put("appGroupId", appGroupId);
		map = userMasterHandlerService.getAssignParentList(parameterMap);
		jsp = RequestConstants.RESPONSE_APP_PARENT;
		return new ModelAndView(jsp, "map", map);
	}
	
	
	//------------------------------------
	/*
	 * Code for Templete Assigned To User
	 * Code By Mukesh Narayan Singh
	 * Date 01-Jun-2012
	 */
	public ModelAndView showUserAssignedTemplet(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		session = request.getSession();
		HttpSession session = request.getSession();
		String serviceNo = null;
		String firstName = null;
		String lastName = null;
		String searchField = null;
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String superUserServiceNo = properties.getProperty("superUserServiceNo");
		
		String userName = "";
		if(session.getAttribute("userName")!=null){
			userName = (String)session.getAttribute("userName");
		}
		System.out.println("re hospital"+request.getParameter("hospitalId"));
		if(userName.equals(superUserServiceNo) || userName.equals("jktuser"))
		{
			if(request.getParameter("hospitalId") != null)
			{
				int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
				mapDetails.put("hospitalId", hospitalId);
			}else
			{
				int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapDetails.put("hospitalId", hospitalId);
			}
		}
		else
		{
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			mapDetails.put("hospitalId", hospitalId);
		}
		
		int searchRadio = 1;
		
		if (request.getParameter(SEARCH_FIELD) != null
				&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
			searchField = request.getParameter(SEARCH_FIELD);
		}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		
		if (searchRadio == 1) {
			serviceNo = searchField;
			firstName = null;
			lastName = null;
		} else if (searchRadio == 2) {
			serviceNo = null;
			firstName = searchField;
			lastName = null;
		}
		mapDetails.put("serviceNo", serviceNo);
		mapDetails.put("firstName", firstName);
		
		
		//MasTemplate
		map = userMasterHandlerService.showUserAssignedTemplet(mapDetails);
		jsp = "showUserAssinedTemplet.jsp";
		title = "Show User Assined Templet";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView getUserByEmpCat(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		session = request.getSession();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		mapDetails.put("hospitalId", hospitalId);
		int employeeCategoryId=0;
		if (request.getParameter("employeeCategoryId") != null
				&& !(request.getParameter("employeeCategoryId").equals(""))) {
			employeeCategoryId= Integer.parseInt(""+request.getParameter("employeeCategoryId"));
			
		}
		mapDetails.put("employeeCategoryId", employeeCategoryId);
		//MasTemplate
		map = userMasterHandlerService.showUserAssignedTemplet(mapDetails);
		jsp = "showUserAssinedTempletResponse";
		title = "Show User Assined Templet";
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	/*public ModelAndView saveUserAssignedTemplet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		
		session = request.getSession();
		String message = null;
		

		int empGroupId = 0;
		if (request.getParameter("empGroup") != null) {
			empGroupId = Integer.parseInt(request.getParameter("empGroup"));
		}
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		
		
		 * Code for get Dynamic data
		 
		int counter=0;
		if (request.getParameter("counter") != null
				&& !(request.getParameter("counter").equals(""))) {
			counter= Integer.parseInt(""+request.getParameter("counter"));
			
		}
		int templetCnt=0;
		if (request.getParameter("templetCnt") != null
				&& !(request.getParameter("templetCnt").equals(""))) {
			templetCnt= Integer.parseInt(""+request.getParameter("templetCnt"));
			
		}
		List<Integer> templetIdList=new ArrayList<Integer>();
		List<Integer> userIdList=new ArrayList<Integer>();
		List<Integer> preTempletIdList=new ArrayList<Integer>();
		List<Integer> preUserIdList=new ArrayList<Integer>();
		try {
			Box box = HMSUtil.getBox(request);
			if(counter>0){
				for (int ct = 1; ct <=counter; ct++) {
					int empId=0;
					if (request.getParameter("empId"+ct) != null
							&& !(request.getParameter("empId"+ct).equals(""))) {
						empId= Integer.parseInt(""+request.getParameter("empId"+ct));
						
					}
					int userId=0;
					if (request.getParameter("userId"+ct) != null
							&& !(request.getParameter("userId"+ct).equals(""))) {
						userId= Integer.parseInt(""+request.getParameter("userId"+ct));
						
					}
				
					Vector<String> tempId = box.getVector("templetIdHidden"+ct);
					Vector<String> preTempletIdVec = box.getVector("preTempletId"+ct);
				//	for(int templet=1;templet<=templetCnt;templet++){
					for(int templet=0;templet<tempId.size();templet++){
						int templetId=0;
						if (request.getParameter("templetId"+templet+""+ct) != null) {
							templetId= Integer.parseInt(""+request.getParameter("templetId"+templet+""+ct));
						}
						if(!tempId.get(templet).equals("0") && !tempId.get(templet).equals("") )
							templetId = Integer.parseInt(tempId.get(templet).toString());
						
						if(templetId>0){
							templetIdList.add(templetId);
							userIdList.add(userId);
						}
						int preTempletId=0;
						if (request.getParameter("preTempletId"+templet+""+ct) != null) {
							preTempletId= Integer.parseInt(""+request.getParameter("preTempletId"+templet+""+ct));
						}
						if(!preTempletIdVec.get(templet).equals("") )
							preTempletId = Integer.parseInt(preTempletIdVec.get(templet).toString());
						
						if(preTempletId>0){
								preTempletIdList.add(preTempletId);
								preUserIdList.add(userId);	
						}
						
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		*//**
		 * Commented By ritu on 20 Aug 2015
		 *//*
		int employeeCategoryId=0;
		if (request.getParameter("employeeCategoryId") != null
				&& !(request.getParameter("employeeCategoryId").equals(""))) {
			employeeCategoryId= Integer.parseInt(""+request.getParameter("employeeCategoryId"));
				mapDetails.put("employeeCategoryId", employeeCategoryId);
		}
		
		 * Code for remove rights 
		 
		Map<String, Object> removeTemplateMap = new HashMap<String, Object>();
		removeTemplateMap.put("preTempletIdList", preTempletIdList);
		removeTemplateMap.put("preUserIdList", preUserIdList);
		removeTemplateMap.put("hospitalId", hospitalId);
		map = userMasterHandlerService.removeTemplateApplicationList(removeTemplateMap);
		
		 * Code for remove rights 
		 
		boolean successfullyAdded=true;
		if(templetIdList.size()>0){
			int index=0;
			for (Integer templateIdInt : templetIdList) {
				*//**
				 * Commented by ritu on 20 aug 2015
				 *//*
				Map<String, Object> mapDetails = new HashMap<String, Object>();
				
				mapDetails.put("templateId", templateIdInt);
				map = userMasterHandlerService.getTemplateAsPerEmpCatList(mapDetails);
				int templateIdEmpCat=0;
				if(map.get("templateIdEmpCat")!=null){
					templateIdEmpCat=(Integer)map.get("templateIdEmpCat");
				}
				
			//	map = userMasterHandlerService.getTemplateApplicationList(templateIdEmpCat,hospitalId);
				map = userMasterHandlerService.getTemplateApplicationList(templateIdInt,hospitalId);
				
				List<Object> grpAppList = new ArrayList<Object>();
				grpAppList = (List<Object>) map.get("grpAppList");
				List<Object> usrGrpHospList = new ArrayList<Object>();
				usrGrpHospList = (List<Object>) map.get("usrGrpHospList");
			//	dataMap.put("templateId", templateIdEmpCat);
				dataMap.put("templateId", templateIdInt);
				dataMap.put("grpAppList", grpAppList);
				dataMap.put("usrGrpHospList", usrGrpHospList);
				
			
			    dataMap.put("userName", userName);
				
				dataMap.put("hospitalId", hospitalId);
				dataMap.put("empGroupId", empGroupId);
		
				dataMap.put("userIdList", userIdList);
				dataMap.put("userId", userIdList.get(index));
				Map<String, Object> mapTempletOnly = new HashMap<String, Object>();
				mapTempletOnly = userMasterHandlerService.addUserWiseTemplateOnly(dataMap);
				if(mapTempletOnly.get("successfullyAdded")!=null){
					successfullyAdded=(Boolean)mapTempletOnly.get("successfullyAdded");
				}
				if(!successfullyAdded){
					message="Error Ocurred Please Try Again";
					break;
				}
				++index;
				
			}
		}
		
		if(successfullyAdded){
			message="User Rights assigned successfully.";
		}

	
		Map<String, Object> mapDetails = new HashMap<String, Object>();
	//	mapDetails.put("employeeCategoryId", employeeCategoryId);
		//MasTemplate
		map = userMasterHandlerService.showUserAssignedTemplet(mapDetails);
		map.put("message", message);
		jsp = "showUserAssinedTemplet.jsp";
		title = "Show User Assined Templet";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	*/
	public ModelAndView getAdminDetailsForHospital(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = userMasterHandlerService.getAdminDetailsForHospital(box);
		
		
		return new ModelAndView("responseForHospitalAdmin", "map", map);
	}
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public SuperAdminMasterHandlerService getSuperAdminMasterHandlerService() {
		return superAdminMasterHandlerService;
	}

	public void setSuperAdminMasterHandlerService(
			SuperAdminMasterHandlerService superAdminMasterHandlerService) {
		this.superAdminMasterHandlerService = superAdminMasterHandlerService;
	}

	
	//----By Kiran for Complain..
	
	
	public ModelAndView showComplainA(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		
		int userId=0;
		userId=(Integer)session.getAttribute("userId");
		int hospitalId=0;
		hospitalId=(Integer)session.getAttribute("hospitalId");
		map.put("userId", userId);
		map.put("hospitalId", hospitalId);
		map=userMasterHandlerService.showComplainA(map);
		jsp = "Complain_A";
		jsp = jsp + ".jsp";
		title = "Complain A";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showComplainB(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		
		int userId=0;
		userId=(Integer)session.getAttribute("userId");
		int hospitalId=0;
		hospitalId=(Integer)session.getAttribute("hospitalId");
		map.put("userId", userId);
		map.put("hospitalId", hospitalId);
		map=userMasterHandlerService.showComplainB(map);
		jsp = "Complain_B";
		jsp = jsp + ".jsp";
		title = "Complain B";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showComplainC(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		
		int userId=0;
		userId=(Integer)session.getAttribute("userId");
		int hospitalId=0;
		hospitalId=(Integer)session.getAttribute("hospitalId");
		map.put("userId", userId);
		map.put("hospitalId", hospitalId);
		map=userMasterHandlerService.showComplainC(map);
		jsp = "Complain_C";
		jsp = jsp + ".jsp";
		title = "Complain C";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitComplainA(HttpServletRequest request,HttpServletResponse response) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		Complain comp = new Complain();
		Date date1 = new Date();
		String date ="";
		String time ="";
		String reqBy1="";
		int reqBy=0;
		String reqType="";
		String descrip="";
		String status="";
		int hospitalId=0;
		session = request.getSession(true);
		
	try
	{
		
		if (request.getParameter("complainDate") != null) {
			date = request.getParameter("complainDate");
			
		}
		
		if (request.getParameter("ComplainTime") != null) {
			time = request.getParameter("ComplainTime");
			
		}
		
		if (request.getParameter("requested_by1") != null) {
			reqBy = Integer.parseInt(""+request.getParameter("requested_by1"));
			
		}
				
		if (request.getParameter("req_type") != null) {
			reqType = request.getParameter("req_type");
			
		}
		
		if (request.getParameter("description") != null) {
			descrip = request.getParameter("description");
					
		}
		
		if(request.getParameter("status")!=null){
			status = request.getParameter("status");
			
		}
		
		if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))) {
			comp.setLastChangeBy(request.getParameter(CHANGED_BY));
		}
		
		Date LChangeDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			LChangeDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			comp.setLastChangeDate(LChangeDate);
		}
			
		String LChangeTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			LChangeTime = request.getParameter(CHANGED_TIME);
			comp.setLastChangeTime(LChangeTime);
		}
		
		
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		
		
	}
	catch(Exception e)
	{
		System.out.println("Exception--->>"+e);
	}

		comp.setComplainDate(HMSUtil.convertStringTypeDateToDateType(date));
		comp.setComplainTime(time);
		
		MasEmployee masemp=new MasEmployee();
		masemp.setId(reqBy);
		comp.setRequestBy(masemp);
		
		MasHospital masHospital =  new MasHospital();
		masHospital.setId(hospitalId);
		comp.setHospital(masHospital);
		
		comp.setRequestType(reqType);
		comp.setDiscription(descrip);
		comp.setStatus(status);
		
		boolean successfullyAdded = false;
		successfullyAdded=userMasterHandlerService.submitComplainA(comp);
		
		if(successfullyAdded)
		{
			message="Record Added Successfully !!";
		}
		else
		{				
			message="Try Again !!";
		}
		
		int userId=0;
		userId=(Integer)session.getAttribute("userId");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put("userId", userId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("reqBy", reqBy);
		map=userMasterHandlerService.showComplainA(dataMap);
		
		jsp="Complain_A";
		title="Submit Complain";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchComplainA(HttpServletRequest request,HttpServletResponse response) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		Date fromDate = new Date();
		Date toDate = new Date();
		int userName =0;
		int hospitalId=0;
		int userId=0;
		String reqType ="";
		session = request.getSession(true);
		try
		{
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
		
			if (request.getParameter("userName") != null && !(request.getParameter("userName").equals(""))) {
				userName =Integer.parseInt(request.getParameter("userName"));
				
			}
			if (request.getParameter("requested_type") != null && !(request.getParameter("requested_type").equals(""))) {
				reqType = request.getParameter("requested_type");
				
			}
			
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
			userId=(Integer)session.getAttribute("userId");
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("fromDate--->>" +fromDate);
		System.out.println("toDate--->>" +toDate);
		
		
		dataMap.put("fromDate", fromDate);
		dataMap.put("toDate", toDate);
		dataMap.put("userName", userName);
		dataMap.put("reqType", reqType);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userId", userId);
		
		map=userMasterHandlerService.searchComplainA(dataMap);
		
		jsp="Complain_A";
		title="Search Complain";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView getComplainData(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int compainId = 0;
		compainId = box.getInt("compainId");
		
		box.put("compainId", compainId);
		map = userMasterHandlerService.getComplainData(box);
		
		String jsp = "responseForDirectComplainEntry";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView updateComplainA(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Complain comp = new Complain();
		int compainId = 0;
		String complainTime="";
		Date complainDate = new Date();
		String time ="";
		String reqBy1="";
		int reqBy=0;
		String reqType="";
		String descrip="";
		String status="";
		int hospitalId=0;
		
		if (request.getParameter("compainId") != null) {
			compainId = Integer.parseInt(request.getParameter("compainId"));
		}
				
		if (request.getParameter("complainDate") != null
				&& !(request.getParameter("complainDate").equals(""))) {
			complainDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("complainDate"));
						
		}
		if (request.getParameter("ComplainTime") != null) {
			time = request.getParameter("ComplainTime");
		}
		
		if (request.getParameter("requested_by1") != null) {
			reqBy = Integer.parseInt(""+request.getParameter("requested_by1"));
			
		}
				
		if (request.getParameter("request_type") != null) {
			reqType = request.getParameter("request_type");
			
		}
		
		if (request.getParameter("description") != null) {
			descrip = request.getParameter("description");
						
		}
		
		if(request.getParameter("status")!=null){
			status = request.getParameter("status");
			
		}
		
		if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))) {
			comp.setLastChangeBy(request.getParameter(CHANGED_BY));
		}
		
		Date LChangeDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			LChangeDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			comp.setLastChangeDate(LChangeDate);
		}
			
		String LChangeTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			LChangeTime = request.getParameter(CHANGED_TIME);
			comp.setLastChangeTime(LChangeTime);
		}
		
		
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		map.put("complainId", compainId);
		map.put("complainDate", complainDate);
		map.put("hospitalId", hospitalId);
		map.put("reqBy", reqBy);
		map.put("complainTime", time);
		map.put("reqType", reqType);
		map.put("descrip", descrip);
		
		
		
		boolean dataUpdated = false;
		dataUpdated = userMasterHandlerService.updateComplainA(map);

		if (dataUpdated == true) {
			message = "Complain Updated Successfully !!";
		} else {
			message = "Complain Cant Be Updated !!";
		}
		
		int userId=0;
		userId=(Integer)session.getAttribute("userId");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put("userId", userId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("reqBy", reqBy);
		map=userMasterHandlerService.showComplainA(dataMap);
		
		jsp="Complain_A";
		title="Update Complain";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView getComplainBData(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int compainId = 0;
		compainId = box.getInt("compainId");
		box.put("compainId", compainId);
		map = userMasterHandlerService.getComplainBData(box);
		String jsp = "responseForDirectComplainBEntry";
		return new ModelAndView(jsp, "map", map);
	}
	
	
	public ModelAndView updateComplainB(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		int userId=0;
		userId=(Integer)session.getAttribute("userId");
		
		Complain comp = new Complain();
		int compainId = 0;
		String complainTime="";
		Date complainDate = new Date();
		String time ="";
		String reqBy1="";
		int reqBy=0;
		String reqType="";
		String descrip="";
		String airHqRemarks="";
		String status="";
		int hospitalId=0;
		
		if (request.getParameter("compainId") != null) {
			compainId = Integer.parseInt(request.getParameter("compainId"));
		}
		System.out.println("compainId--->>" +compainId); 
		
		if (request.getParameter("complainDate") != null
				&& !(request.getParameter("complainDate").equals(""))) {
			complainDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("complainDate"));
			
			
		}
		if (request.getParameter("ComplainTime") != null) {
			time = request.getParameter("ComplainTime");
			
		}
		
		if (request.getParameter("requested_by1") != null) {
			reqBy = Integer.parseInt(""+request.getParameter("requested_by1"));
			
		}
				
		if (request.getParameter("request_type") != null) {
			reqType = request.getParameter("request_type");
			
		}
		
		if (request.getParameter("description") != null) {
			descrip = request.getParameter("description");
						
		}
		
		if (request.getParameter("airHqRemarks") != null) {
			airHqRemarks = request.getParameter("airHqRemarks");
			
		}
		
		if(request.getParameter("status")!=null){
			status = request.getParameter("status");
			
		}
		
		if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))) {
			comp.setLastChangeBy(request.getParameter(CHANGED_BY));
		}
		
		Date LChangeDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			LChangeDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			
		}
			
		String LChangeTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			LChangeTime = request.getParameter(CHANGED_TIME);
			}
		
		
		
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		
		dataMap.put("complainId", compainId);
		dataMap.put("complainDate", complainDate);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("reqBy", reqBy);
		dataMap.put("complainTime", time);
		dataMap.put("reqType", reqType);
		dataMap.put("descrip", descrip);
		dataMap.put("status", status);
		dataMap.put("airHqRemarks",airHqRemarks);
		dataMap.put("LChangeDate", LChangeDate);
		dataMap.put("LChangeTime", LChangeTime);
		
		
		
		boolean dataUpdated = false;
		dataUpdated = userMasterHandlerService.updateComplainB(dataMap);

		if (dataUpdated == true) {
			message = "Complain Updated Successfully !!";
		} else {
			message = "Complain Cant Be Updated !!";
		}
				
		userId=(Integer)session.getAttribute("userId");
				
		dataMap.put("userId", userId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("reqBy", reqBy);
		map=userMasterHandlerService.showComplainB(dataMap);
		
		jsp="Complain_B";
		title="Update Complain";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	
	public ModelAndView getComplainCData(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int compainId = 0;
		compainId = box.getInt("compainId");
		box.put("compainId", compainId);
		map = userMasterHandlerService.getComplainCData(box);
		String jsp = "responseForDirectComplainCEntry";
		return new ModelAndView(jsp, "map", map);
		
	}
	
	public ModelAndView updateComplainC(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		int userId=0;
		userId=(Integer)session.getAttribute("userId");
		//Box box = HMSUtil.getBox(request);.
		Complain comp = new Complain();
		int compainId = 0;
		String complainTime="";
		Date complainDate = new Date();
		String time ="";
		String reqBy1="";
		int reqBy=0;
		String reqType="";
		String descrip="";
		String airHqRemarks="";
		String status="";
		int hospitalId=0;
		Date completionDate= new Date();
		String vendorRemarks="";
		
		if (request.getParameter("compainId") != null && !(request.getParameter("compainId").equals(""))) {
			compainId = Integer.parseInt(request.getParameter("compainId"));
		}
				
		if (request.getParameter("complainDate") != null && !(request.getParameter("complainDate").equals(""))) {
			complainDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("complainDate"));
			
			
		}
		if (request.getParameter("ComplainTime") != null && !(request.getParameter("ComplainTime").equals(""))) {
			time = request.getParameter("ComplainTime");
			
		}
		
		if (request.getParameter("requested_by1") != null && !(request.getParameter("requested_by1").equals(""))) {
			reqBy = Integer.parseInt(""+request.getParameter("requested_by1"));
			
		}
				
		if (request.getParameter("request_type") != null && !(request.getParameter("request_type").equals(""))) {
			reqType = request.getParameter("request_type");
			
		}
		
		if (request.getParameter("description") != null && !(request.getParameter("description").equals(""))) {
			descrip = request.getParameter("description");
					
		}
		
		if (request.getParameter("airHqRemarks") != null && !(request.getParameter("airHqRemarks").equals(""))) {
			airHqRemarks = request.getParameter("airHqRemarks");
			
		}
		
		if(request.getParameter("status")!=null && !(request.getParameter("status").equals(""))){
			status = request.getParameter("status");
			
		}
		
		if (request.getParameter("completionDate") != null && !(request.getParameter("completionDate").equals(""))) {
			completionDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("completionDate"));
			
		}
		
		if (request.getParameter("vendorRemarks") != null) {
			vendorRemarks = request.getParameter("vendorRemarks");
			
		}
		
		
		if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))) {
			comp.setLastChangeBy(request.getParameter(CHANGED_BY));
		}
		
		Date LChangeDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			LChangeDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			
		}
			
		String LChangeTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			LChangeTime = request.getParameter(CHANGED_TIME);
			
		}
					
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				
		dataMap.put("complainId", compainId);
		dataMap.put("complainDate", complainDate);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("reqBy", reqBy);
		dataMap.put("complainTime", time);
		dataMap.put("reqType", reqType);
		dataMap.put("descrip", descrip);
		dataMap.put("airHqRemarks",airHqRemarks);
		dataMap.put("status",status);
		dataMap.put("completionDate",completionDate);
		dataMap.put("vendorRemarks",vendorRemarks);
		dataMap.put("LChangeDate", LChangeDate);
		dataMap.put("LChangeTime", LChangeTime);
		
		boolean dataUpdated = false;
		dataUpdated = userMasterHandlerService.updateComplainC(dataMap);

		if (dataUpdated == true) {
			message = "Complain Updated Successfully !!";
		} else {
			message = "Complain Cant Be Updated !!";
		}
		
		userId=(Integer)session.getAttribute("userId");
				
		dataMap.put("userId", userId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("reqBy", reqBy);
		map=userMasterHandlerService.showComplainC(dataMap);
		
		jsp="Complain_C";
		title="Update Complain";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
public ModelAndView searchComplainB(HttpServletRequest request,HttpServletResponse response) {
		
	Map<String,Object> map=new HashMap<String,Object>();
	Map<String,Object> dataMap=new HashMap<String,Object>();
	Date fromDate = new Date();
	Date toDate = new Date();
	int userName =0;
	int hospitalId=0;
	String reqType ="";
	try
	{
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter("userName") != null && !(request.getParameter("userName").equals(""))) {
			userName =Integer.parseInt(request.getParameter("userName"));
			
		}
		if (request.getParameter("requested_type") != null && !(request.getParameter("requested_type").equals(""))) {
			reqType = request.getParameter("requested_type");
			
		}
		
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	dataMap.put("fromDate", fromDate);
	dataMap.put("toDate", toDate);
	dataMap.put("userName", userName);
	dataMap.put("reqType", reqType);
	dataMap.put("hospitalId", hospitalId);
	
	map=userMasterHandlerService.searchComplainB(dataMap);
	
	jsp="Complain_B";
	title="Search Complain";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	return new ModelAndView("indexB", "map", map);
	}

public ModelAndView searchComplainC(HttpServletRequest request,HttpServletResponse response) {
	
	Map<String,Object> map=new HashMap<String,Object>();
	Map<String,Object> dataMap=new HashMap<String,Object>();
	Date fromDate = new Date();
	Date toDate = new Date();
	int userName =0;
	int hospitalId=0;
	String reqType ="";
	try
	{
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter("userName") != null && !(request.getParameter("userName").equals(""))) {
			userName =Integer.parseInt(request.getParameter("userName"));
					}
		if (request.getParameter("requested_type") != null && !(request.getParameter("requested_type").equals(""))) {
			reqType = request.getParameter("requested_type");
				}
		
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	dataMap.put("fromDate", fromDate);
	dataMap.put("toDate", toDate);
	dataMap.put("userName", userName);
	dataMap.put("reqType", reqType);
	dataMap.put("hospitalId", hospitalId);
	
	map=userMasterHandlerService.searchComplainC(dataMap);
	
	jsp="Complain_C";
	title="Search Complain";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	return new ModelAndView("indexB", "map", map);
}

//-----By Kiran for FAQ

public ModelAndView questionFaqJsp(HttpServletRequest request,HttpServletResponse response) {
	session = request.getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	
	int hospitalId=0;
	hospitalId=(Integer)session.getAttribute("hospitalId");
	
	map.put("hospitalId", hospitalId);
	map=userMasterHandlerService.questionFaqJsp(map);
	jsp = "question_faq";
	jsp = jsp + ".jsp";
	title = "Question FAQ";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView answerFaqJsp(HttpServletRequest request,HttpServletResponse response) {
	session = request.getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	
	int hospitalId=0;
	hospitalId=(Integer)session.getAttribute("hospitalId");
	int questionId=0;
	if (request.getParameter("questionId") != null) {
		questionId = Integer.parseInt(request
				.getParameter("questionId"));

	}
	map.put("hospitalId", hospitalId);
	map.put("questionId", questionId);
	map=userMasterHandlerService.answerFaqJsp(map);
	jsp = "answer_faq";
	jsp = jsp + ".jsp";
	title = "Answer FAQ";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView askQuestionJsp(HttpServletRequest request,HttpServletResponse response) {
	session = request.getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	
	int userId=0;
	userId=(Integer)session.getAttribute("userId");
	int hospitalId=0;
	hospitalId=(Integer)session.getAttribute("hospitalId");
	map.put("userId", userId);
	map.put("hospitalId", hospitalId);
	map=userMasterHandlerService.questionFaqJsp(map);
	jsp = "ask_question";
	jsp = jsp + ".jsp";
	title = "Ask Question";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}


public ModelAndView submitAskQuestion(HttpServletRequest request,HttpServletResponse response) {
	
	Map<String,Object> map=new HashMap<String,Object>();
	QuestionFaq q = new QuestionFaq();
	String questionName ="";
	String newQuestion ="";
	String moduleName ="";
	int hospitalId=0;
	
try
{
	
	if (request.getParameter("questionName") != null) {
		questionName = request.getParameter("questionName");
			}
	
	if (request.getParameter("newQuestion") != null) {
		newQuestion = request.getParameter("newQuestion");
		}
	
	if (request.getParameter("moduleName") != null) {
		moduleName = request.getParameter("moduleName");
		}
	
	if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))) {
		q.setLastChangeBy(request.getParameter(CHANGED_BY));
	}
	
	Date LChangeDate = null;
	if (request.getParameter(CHANGED_DATE) != null) {
		LChangeDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
		q.setLastChangeDate(LChangeDate);
	}
		
	String LChangeTime = "";
	if (request.getParameter(CHANGED_TIME) != null) {
		LChangeTime = request.getParameter(CHANGED_TIME);
		q.setLastChangeTime(LChangeTime);
	}
	
	
	hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
}
catch(Exception e)
{
	System.out.println("Exception--->>"+e);
}

	MasHospital masHospital =  new MasHospital();
	masHospital.setId(hospitalId);
	q.setHospital(masHospital);
	
	q.setQuestionName(questionName);
	q.setQuestion(newQuestion);
	q.setModuleName(moduleName);
	
	boolean successfullyAdded = false;
	successfullyAdded=userMasterHandlerService.submitAskQuestion(q);
	
	if(successfullyAdded)
	{
		message="Record Added Successfully !!";
	}
	else
	{				
		message="Try Again !!";
	}
	
	map.put("hospitalId", hospitalId);
	
	map=userMasterHandlerService.questionFaqJsp(map);
	
	jsp="question_faq";
	title="Submit Ask Question";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	return new ModelAndView("indexB", "map", map);
}

public ModelAndView submitPostAnswer(HttpServletRequest request,HttpServletResponse response) {
	
	Map<String,Object> map=new HashMap<String,Object>();
	AnswerFaq a = new AnswerFaq();
	String typeAnswer ="";
	int hospitalId=0;
	int questionId=0;
	
	
try
{
	
	if (request.getParameter("typeAnswer") != null) {
		typeAnswer = request.getParameter("typeAnswer");
		
	}
	if (request.getParameter("questionId") != null && !(request.getParameter("questionId").equals(""))) {
		questionId = Integer.parseInt(""+request.getParameter("questionId"));
		
	}
	if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))) {
		a.setLastChangeBy(request.getParameter(CHANGED_BY));
	}
	
	Date LChangeDate = null;
	if (request.getParameter(CHANGED_DATE) != null) {
		LChangeDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
		a.setLastChangeDate(LChangeDate);
	}
		
	String LChangeTime = "";
	if (request.getParameter(CHANGED_TIME) != null) {
		LChangeTime = request.getParameter(CHANGED_TIME);
		a.setLastChangeTime(LChangeTime);
	}
	
	
	hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
}
catch(Exception e)
{
	System.out.println("Exception--->>"+e);
}

	MasHospital masHospital =  new MasHospital();
	masHospital.setId(hospitalId);
	a.setHospital(masHospital);
	
	QuestionFaq questionFaq = new QuestionFaq();
	questionFaq.setId(questionId);
	a.setGroupId(questionFaq);
	
	a.setAnswer(typeAnswer);
		
	boolean successfullyAdded = false;
	successfullyAdded=userMasterHandlerService.submitPostAnswer(a);
	
	if(successfullyAdded)
	{
		message="Record Added Successfully !!";
	}
	else
	{				
		message="Try Again !!";
	}
	
	map.put("hospitalId", hospitalId);
	map.put("questionId", questionId);

	map=userMasterHandlerService.answerFaqJsp(map);
	
	jsp="answer_faq";
	title="Submit Ask Question";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	return new ModelAndView("indexB", "map", map);
}


public ModelAndView searchDiscussionBoard(HttpServletRequest request,HttpServletResponse response) {
	
	Map<String,Object> map=new HashMap<String,Object>();
	Map<String,Object> dataMap=new HashMap<String,Object>();
	//Complain comp = new Complain();
	
	int hospitalId=0;
	String searchText ="";
	String moduleName ="";
	
	session = request.getSession(true);
	
	try
	{
		if (request.getParameter("searchText") != null ) {
			searchText = request.getParameter("searchText");
		}
		
		if (request.getParameter("moduleName") != null ) {
			moduleName = request.getParameter("moduleName");
		}
		
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	dataMap.put("searchText", searchText);
	dataMap.put("moduleName", moduleName);
	dataMap.put("hospitalId", hospitalId);
		
	map=userMasterHandlerService.searchDiscussionBoard(dataMap);
	
	jsp="question_faq";
	title="Search Discussion Board";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView saveUserAssignedTemplet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		
		session = request.getSession();
		String message = null;
		
	
		int empGroupId = 0;
		if (request.getParameter("empGroup") != null) {
			empGroupId = Integer.parseInt(request.getParameter("empGroup"));
		}
//		int hospitalId = (Integer) session.getAttribute("hospitalId");
		int hospitalId = 0;
		if(request.getParameter("hospitalId") != null)
		{
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else
		{
			 hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		/*
		 * Code for get Dynamic data
		 */
		int counter=0;
		if (request.getParameter("counter") != null
				&& !(request.getParameter("counter").equals(""))) {
			counter= Integer.parseInt(""+request.getParameter("counter"));
			
		}
		int templetCnt=0;
		if (request.getParameter("templetCnt") != null
				&& !(request.getParameter("templetCnt").equals(""))) {
			templetCnt= Integer.parseInt(""+request.getParameter("templetCnt"));
			
		}
		List<Integer> templetIdList=new ArrayList<Integer>();
		List<Integer> userIdList=new ArrayList<Integer>();
		List<Integer> preTempletIdList=new ArrayList<Integer>();
		List<Integer> preUserIdList=new ArrayList<Integer>();
		try {
			Box box = HMSUtil.getBox(request);
			if(counter>0){
				for (int ct = 1; ct <=counter; ct++) {
				
					int userId=0;
					if (request.getParameter("userId"+ct) != null
							&& !(request.getParameter("userId"+ct).equals(""))) {
						userId= Integer.parseInt(""+request.getParameter("userId"+ct));
						
					}
				
					Vector<String> tempId = box.getVector("templetIdHidden"+ct);
					Vector<String> preTempletIdVec = box.getVector("preTempletId"+ct);
					Vector<String> changeFlagVec = box.getVector("changeFlag"+ct);
					for(int templet=0;templet<tempId.size();templet++){
						String changeFlag = "";
						changeFlag = changeFlagVec.get(templet);
						if(changeFlag.equalsIgnoreCase("yes")){
							int templetId=0;
							
							if(!tempId.get(templet).equals("0") && !tempId.get(templet).equals("") )
								templetId = Integer.parseInt(tempId.get(templet).toString());
							
							/*if(!userTemplateIdVed.get(templet).equals("") )
								userTemplateId = Integer.parseInt(userTemplateIdVed.get(templet).toString());*/

							if(templetId>0){
								templetIdList.add(templetId);
								userIdList.add(userId);
							}
							int preTempletId=0;

							if(!preTempletIdVec.get(templet).equals("") )
								preTempletId = Integer.parseInt(preTempletIdVec.get(templet).toString());
							
							if(preTempletId>0){
								preTempletIdList.add(preTempletId);
								preUserIdList.add(userId);	
							}
						}
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		Map<String, Object> removeTemplateMap = new HashMap<String, Object>();
		removeTemplateMap.put("preTempletIdList", preTempletIdList);
		removeTemplateMap.put("preUserIdList", preUserIdList);
		removeTemplateMap.put("hospitalId", hospitalId);
		map = userMasterHandlerService.removeTemplateApplicationList(removeTemplateMap);
		
		
		boolean successfullyAdded=true;
		if(templetIdList.size()>0){
			int index=0;
			for (Integer templateIdInt : templetIdList) {
				
				map = userMasterHandlerService.getTemplateApplicationList(templateIdInt,hospitalId);
				
				List<Object> grpAppList = new ArrayList<Object>();
				grpAppList = (List<Object>) map.get("grpAppList");
				List<Object> usrGrpHospList = new ArrayList<Object>();
				usrGrpHospList = (List<Object>) map.get("usrGrpHospList");
				dataMap.put("templateId", templateIdInt);
				dataMap.put("grpAppList", grpAppList);
				dataMap.put("usrGrpHospList", usrGrpHospList);
				
			
			    dataMap.put("userName", userName);
				
				dataMap.put("hospitalId", hospitalId);
				dataMap.put("empGroupId", empGroupId);
		
				dataMap.put("userIdList", userIdList);
				dataMap.put("userId", userIdList.get(index));
				Map<String, Object> mapTempletOnly = new HashMap<String, Object>();
				mapTempletOnly = userMasterHandlerService.addUserWiseTemplateOnly(dataMap);
				if(mapTempletOnly.get("successfullyAdded")!=null){
					successfullyAdded=(Boolean)mapTempletOnly.get("successfullyAdded");
				}
				if(!successfullyAdded){
					message="Error Ocurred Please Try Again";
					break;
				}
				++index;
				
			}
		}
		
		
		
		if(successfullyAdded){
			message="User Rights assigned successfully.";
		}
	
	
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		map = userMasterHandlerService.showUserAssignedTemplet(mapDetails);
		map.put("message", message);
		jsp = "showUserAssinedTemplet.jsp";
		title = "Show User Assined Templet";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	@SuppressWarnings("unchecked")
	public void doResetPassword(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		String empNo = "";
		if (request.getParameter("empNo") != null) {
			empNo = (request.getParameter("empNo"));
		}
		dataMap.put("empNo", empNo);
		
		map = userMasterHandlerService.doResetPassword(dataMap);
		
		boolean existuser=false;
		String Msg = (String) map.get("Msg");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		
				sb.append("<Msg>" + Msg + "</Msg>");
			
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
	}
	
	
	public ModelAndView showPendingListofResetPassword(HttpServletRequest request,HttpServletResponse response)
	{
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();	
		Map<String,Object> dataMap = new HashMap<String,Object>();
		Map<String,Object> map = new HashMap<String,Object>();
						
				
		jsp = "passwordResetList";
		jsp += ".jsp";
		title = "Pending List of Reset Password";	
		
		map.put("contentJsp", jsp);
		map.put("title", title);
		
		
		return new ModelAndView("index", "map", map);
	}


	public ModelAndView getListOfPasswordReset(HttpServletRequest request,HttpServletResponse response)
		
	{
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Users> userList = new ArrayList<Users>();
		
		Box box = HMSUtil.getBox(request);	
		
		String unitType="";
		
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId =  (Integer)session.getAttribute("hospitalId");
		}
		
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId =  (Integer)session.getAttribute("deptId");
		}
		
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		
		map = userMasterHandlerService.getListOfPasswordReset(box);
		
		if(map.get("userList")!= null)
		{
			userList = (List<Users>) map.get("userList");
		}
		System.out.println("in controller userList="+userList.size());
		int totalRecords = 0;
		if(map.get("totalRecords")!= null)
		{
			totalRecords = (Integer) map.get("totalRecords");
		}
		
		try
		{
			PrintWriter pw = response.getWriter();	
			
			pw.write("[");
			int counter=1;
			
			for(Users list : userList)
			{
				
				
			    if(counter != userList.size())
			    {
			    	
			    		pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+(list.getResetReqOn() != null?HMSUtil.changeDateToddMMyyyy(list.getResetReqOn()):"")+"\",\"EmployeeNo\": \""+(list.getEmployee()!=null?list.getEmployee().getServiceNo():"")+"\",\"Name\": \""+(list.getEmployee()!=null?list.getEmployee().getFirstName():"")+"\",\"Designation\": \""+(list.getEmployee().getRank()!=null?list.getEmployee().getRank().getRankName():"")+"\",\"Count\": \""+(list.getResetCount()!=null?list.getResetCount():"")+"\",\"totalRecords\":\""+totalRecords+"\"},");
			    	
			    }
			    else
			    {		    	
			    	pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+(list.getResetReqOn() != null?HMSUtil.changeDateToddMMyyyy(list.getResetReqOn()):"")+"\",\"EmployeeNo\": \""+(list.getEmployee()!=null?list.getEmployee().getServiceNo():"")+"\",\"Name\": \""+(list.getEmployee()!=null?list.getEmployee().getFirstName():"")+"\",\"Designation\": \""+(list.getEmployee().getRank()!=null?list.getEmployee().getRank().getRankName():"")+"\",\"Count\": \""+(list.getResetCount()!=null?list.getResetCount():"")+"\",\"totalRecords\":\""+totalRecords+"\"}");
			    	
			    }
			
			    counter++;		
			}
			
			
			pw.write("]");
			
			
		}
		
		catch(Exception e)
		{
			userList.clear();
			e.printStackTrace();
		}	
		userList.clear();
		return null;		
		

	}
	
	
	public ModelAndView submitResetDetails(HttpServletRequest request, HttpServletResponse response)
	{
		 	Map<String, Object> map = new HashMap<String, Object>();
		 	Map<String, Object> dataMap = new HashMap<String, Object>();
		 	Map<String, Object> datamap = new HashMap<String, Object>();
			
			
			int deptId = 0;
			int hospitalId=0;
			Box box = HMSUtil.getBox(request);	
			HttpSession session = request.getSession();
			
			
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
				box.put("deptId", deptId);
			}
			
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			}
			
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("deptId",deptId);


			
		
		 	
		 	datamap = userMasterHandlerService.submitResetDetails(box);
		 	if(datamap.get("bSuccessfullyAdded")!= null)
		 	{
		 		map.put("bSuccessfullyAdded", datamap.get("bSuccessfullyAdded"));
		 		map.put("message", datamap.get("message"));
		 	
		 		map.put("flag", "ResetPassword");
		 	} 	
		 	
		 		
		 	jsp = "storeMessage_New";
			jsp = jsp + ".jsp";
			title = "Receive Report Entry";
		 	
		 	
		 	map.put("contentJsp", jsp);
		 	map.put("title", title);	
		 	return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showDoctorRoasterJsp(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int departmentId = 0;
		int hospitalId =0;
		Box box = HMSUtil.getBox(request);
		int doctorId =0;

		try {
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				box.put("hospitalId", hospitalId);
			}
		
			if(request.getParameter(DEPARTMENT_ID)!=null && !request.getParameter(DEPARTMENT_ID).equals("0"))
			{
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				mapForDS.put(DEPARTMENT_ID,departmentId);
				box.put(DEPARTMENT_ID, departmentId);
			}
			
			if(request.getParameter("refereddoctor") !=null && !request.getParameter("refereddoctor").equals("0")){
				
				doctorId = Integer.parseInt(request.getParameter("refereddoctor"));
				mapForDS.put("doctorId",doctorId);
				
			}
		/*	if(request.getParameter(HIN_NO) !=null  && !request.getParameter(HIN_NO).equals("")){
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put(HIN_NO, hinNo);
			}*/
			
			if(request.getParameter("fromDate") !=null  && !request.getParameter("fromDate").equals("")){
				mapForDS.put("fromDate", request.getParameter("fromDate"));
			}
			if(request.getParameter("toDate") !=null  && !request.getParameter("toDate").equals("")){
				mapForDS.put("toDate", request.getParameter("toDate"));
			}
			
			mapForDS.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));

		} catch (Exception e) {
			e.printStackTrace();
		}
		List<MasEmployee> doctorListDeptWise = null;

       if(departmentId!=0)
       {
		map = appointmentHandlerService.getDoctorList(box);
        if(map.get("doctorList")!=null)
    	  doctorListDeptWise = (List<MasEmployee>)map.get("doctorList");
     
       }
		map = userMasterHandlerService.getDoctorRoasterDetails(mapForDS);
		
	//	map.put("otProcedure", otProcedure);
		String jsp = "";
		jsp = "doctorRoaster" + ".jsp";

		//map.put("patientMap", patientMap);
		//map.put("detailsMap", detailsMap);
		map.put("fromDate", request.getParameter("fromDate"));
		map.put("deptId", departmentId);
		map.put("contentJsp", jsp);
		map.put("doctorListDeptWise", doctorListDeptWise);
		map.put("doctorId", doctorId);
		
		return new ModelAndView("index", "map", map);
	}
	
	public AppointmentHandlerService getAppointmentHandlerService() {
		return appointmentHandlerService;
	}

	public void setAppointmentHandlerService(
			AppointmentHandlerService appointmentHandlerService) {
		this.appointmentHandlerService = appointmentHandlerService;
	}

	public ModelAndView submitDoctorRoasterJsp(HttpServletRequest request,HttpServletResponse response) {
	
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();

        int hiddenValue = 0;
        int doctorId = 0;
        int totalColumn = 0;
        int totalcolumn1=0;
        int deptId = 0;
        String mrngValue=null;
        String evnValue=null;
        int mrnId = 0;
        		int evnId = 0;
        		Date currentDate = new Date();
        		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        		try {
        			currentDate = df.parse(df.format(currentDate));
        		} catch (ParseException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
        Date roasterDateFormat =null;
        Date roasterDate =null;
        List<Integer> doctorIdList = new ArrayList<Integer>();
        List<Date> roasterDateList = new ArrayList<Date>();
        List< String> roasterValueList = new ArrayList<String>();
        List< Integer> roasterIdList = new ArrayList<Integer>();
        if(request.getParameter("deptId") !=null  && !request.getParameter("deptId").equals("")){
        	deptId = Integer.parseInt(request.getParameter("deptId"));
		}
		if(request.getParameter("hiddenValue") !=null  && !request.getParameter("hiddenValue").equals("")){
			hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
		}
		if(request.getParameter("totalColumn") !=null  && !request.getParameter("totalColumn").equals("")){
			totalColumn = Integer.parseInt(request.getParameter("totalColumn"));
		}
		for(int i=1;i<hiddenValue;i++)
		{
			if(request.getParameter("doctorId"+i) !=null  && !request.getParameter("doctorId"+i).equals("")){
				doctorId = Integer.parseInt(request.getParameter("doctorId"+i));
				
				for(int j=0;j<=totalColumn;j++)
				{
					if(request.getParameter("roasterDate"+j) !=null  && !request.getParameter("roasterDate"+j).equals("")){
						roasterDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("roasterDate"+j)); ;
					}
					else
						roasterDate =null;
					
					if(roasterDate!=null && roasterDate.compareTo(currentDate)>=0)
					{totalcolumn1++;
						roasterDateList.add(roasterDate);
					//System.out.println(roasterDate +" mrn "+request.getParameter("mrng"+j+"doc"+doctorId) +" evn"+request.getParameter("mrng"+j+"doc"+doctorId));
					//System.out.println("mrng"+j+"doc"+doctorId);
					
					if(request.getParameter("mrng"+j+"doc"+doctorId)==null)
						mrngValue ="n";
					else
						mrngValue = request.getParameter("mrng"+j+"doc"+doctorId);
					
					if(request.getParameter("evn"+j+"doc"+doctorId)==null)
						evnValue ="n";
					else
						evnValue = request.getParameter("evn"+j+"doc"+doctorId);
					roasterValueList.add(mrngValue+evnValue);
					//System.out.println("mrng"+j+"roaster"+doctorId);
					//System.out.println("val="+request.getParameter("mrng"+j+"roaster"+doctorId));
					
					if(request.getParameter("mrng"+j+"roaster"+doctorId)!=null)
					{
						roasterIdList.add(Integer.parseInt(request.getParameter("mrng"+j+"roaster"+doctorId)));
					}
					else
						roasterIdList.add(0);
					}
					
				}
				if(i==1)
				{
					//System.out.println(totalcolumn1 +"totalcoladadumn1");
				    mapForDS.put("totalColumn1",totalcolumn1 );
				}
				doctorIdList.add(doctorId);
			}
		}
	//	System.out.println(roasterIdList.size() +"roasterIdList");
		//System.out.println(totalcolumn1 +"totalcolumn1");
        mapForDS.put("hiddenValue",hiddenValue );
        mapForDS.put("doctorIdList", doctorIdList);
        mapForDS.put("roasterDateList",roasterDateList );
    	
        mapForDS.put("roasterValueList",roasterValueList );
        mapForDS.put("deptId",deptId );
        mapForDS.put("currentDate",request.getParameter("currentDate") );
        mapForDS.put("currentTime",request.getParameter("currentTime") );
        mapForDS.put("roasterIdList",roasterIdList );
        

        mapForDS.put("userId", session.getAttribute("userId")!=null?(Integer)session.getAttribute("userId"):null);
        
        

    	//System.out.println("doctorIdList"+doctorIdList.size());
		//System.out.println("roasterDateList"+roasterDateList.size());
		map = userMasterHandlerService.submitDoctorRoasterDetails(mapForDS);
		String error =null;
		if(map.get("dataSaved")!=null)
		{
			boolean result = (Boolean)map.get("dataSaved");
			if(result)
			message ="Record Added Successfully !!!";
			else
				error="Data could not saved..";
		}
		
		
		map = userMasterHandlerService.getDoctorRoasterDetails(mapForDS);
	//	map.put("otProcedure", otProcedure);
		String jsp = "";
		jsp = "doctorRoaster" + ".jsp";

		//map.put("patientMap", patientMap);
		//map.put("detailsMap", detailsMap);
		//map.put("fromDate", request.getParameter("fromDate"));
		//map.put("toDate", request.getParameter("toDate"));
		map.put("contentJsp", jsp);
		//map.remove("deptId");
		map.put("message", message);
		map.put("error", error);
		return new ModelAndView("index", "map", map);
	}

}