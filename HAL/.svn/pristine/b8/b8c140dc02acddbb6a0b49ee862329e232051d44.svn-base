package jkt.security.masters.controller;

import static jkt.hms.util.RequestConstants.APPLICATION_NAME;
import static jkt.hms.util.RequestConstants.QUANTITY;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.EmpGroups;
import jkt.hms.masters.business.GroupApplication;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasButtonForm;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.UserButtonRights;
import jkt.hms.masters.business.UserEmpGroup;
import jkt.hms.masters.business.UserUsergroupApplication;
import jkt.hms.masters.business.UserUsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.security.masters.handler.SuperAdminMasterHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class SuperAdminMasterController extends MultiActionController {

	SuperAdminMasterHandlerService superAdminMasterHandlerService = null;
	String jsp = "";
	String title = "";
	String message = " ";
	HttpSession session = null;
	String url = "";
	String viewPage = "";
	String pojoName = "";
	String pojoPropertyName = "";

	public ModelAndView showHospitalMasterJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = RequestConstants.HOSPITAL_JSP;
		title = "Hospital";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("SuperAdminMenu", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addHospitalMaster(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			Map<Object, Object> map = new HashMap<Object, Object>();
			String hospitalCode = request
					.getParameter(RequestConstants.HOSPITAL_CODE);
			String hospitalName = request
					.getParameter(RequestConstants.SEARCH_NAME);
			String changedDate = request
					.getParameter(RequestConstants.CHANGED_DATE);
			Date changeDate = HMSUtil.dateFormatterDDMMYYYY(changedDate);
			String hospitalStatus = request
					.getParameter(RequestConstants.STATUS);
			String address = request.getParameter(RequestConstants.ADDRESS);
			String contactNumber = request
					.getParameter(RequestConstants.CONTACT_NUMBER);
			String changedBy = request
					.getParameter(RequestConstants.CHANGED_BY);
			String changedTime = request
					.getParameter(RequestConstants.CHANGED_TIME);
			Map listMap = new HashMap();

			listMap = superAdminMasterHandlerService.checkForExistingHospital(
					hospitalCode, hospitalName);
			List<MasHospital> hospitalCodeList = (List<MasHospital>) listMap
					.get("codeList");
			List<MasHospital> hospitalNameList = (List<MasHospital>) listMap
					.get("nameList");

			MasHospital hospitalMaster = new MasHospital();
			boolean dataSaved = false;

			if ((hospitalCodeList.size() == 0 || hospitalCodeList == null)
					&& (hospitalNameList.size() == 0 || hospitalNameList == null)) {
				hospitalMaster.setHospitalCode(hospitalCode);
				hospitalMaster.setHospitalName(hospitalName);
				hospitalMaster.setStatus(hospitalStatus);
				hospitalMaster.setAddress(address);
				hospitalMaster.setContactNumber(contactNumber);
				hospitalMaster.setLastChgBy(changedBy);
				hospitalMaster.setLastChgDate(changeDate);
				hospitalMaster.setLastChgTime(changedTime);
				dataSaved = superAdminMasterHandlerService.addHospital(hospitalMaster);
				if (dataSaved == true) {
					message = "Hospital Information saved successfully!!";
				} else {
					message = "Try again!";
				}

				url = "/security/security/superAdmin?method=showHospitalMasterJsp";
				jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
				map.put("url", url);
			} else if ((hospitalCodeList.size() != 0 || hospitalCodeList != null)
					|| (hospitalNameList.size() != 0)
					|| hospitalNameList != null) {
				if ((hospitalCodeList.size() != 0 || hospitalCodeList != null)
						&& (hospitalNameList.size() == 0 || hospitalNameList == null)) {
					message = "Hospital Code  already exists.";
				} else if ((hospitalNameList.size() != 0 || hospitalNameList != null)
						&& (hospitalCodeList.size() == 0 || hospitalCodeList == null)) {
					message = "Hospital Name  already exists.";
				} else if ((hospitalCodeList.size() != 0 || hospitalCodeList != null)
						&& (hospitalNameList.size() != 0 || hospitalNameList != null)) {
					message = "Hospital Code and Hospital Name already exists.";
				}
				jsp = RequestConstants.HOSPITAL_JSP;
			}

			jsp += ".jsp";
			title = "Hospital Master";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("SuperAdminMenu", "map", map);
		} catch (Exception ex) {
			ex.printStackTrace();
			jsp = RequestConstants.EXCEPTION_JSP;
			title = "Exception";
			Map<Object, String> map = new HashMap<Object, String>();
			String message = ex.getClass().getName();

			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("SuperAdminMenu", "map", map);
		}
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showUpdateHospital(HttpServletRequest request,
			HttpServletResponse response) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		session = request.getSession();

		String hospitalCode = "";
		String hospitalName = "";
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();

		if (request.getParameter(RequestConstants.HOSPITAL_CODE) != null) {
			hospitalCode = request.getParameter(RequestConstants.HOSPITAL_CODE);
		}

		if (request.getParameter(RequestConstants.SEARCH_NAME) != null) {
			hospitalName = request.getParameter(RequestConstants.SEARCH_NAME);
		}
		hospitalNameList = superAdminMasterHandlerService.getHospitalNameList(
				hospitalCode, hospitalName);
		session.setAttribute("hospitalCode", hospitalCode);
		session.setAttribute("hospitalName", hospitalName);

		jsp = RequestConstants.UPDATE_HOSPITAL_JSP;
		title = "Update HOSPITAL";
		jsp += ".jsp";
		map.put("hospitalNameList", hospitalNameList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("SuperAdminMenu", "map", map);
	}

	public ModelAndView showUpdateHospitalWithDetails(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		Map<Object, Object> map = new HashMap<Object, Object>();
		String hospitalCode = "";
		String hospitalName = "";

		hospitalCode = (String) session.getAttribute("hospitalCode");
		hospitalName = (String) session.getAttribute("hospitalName");

		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		List<MasHospital> hospitalMasterList = new ArrayList<MasHospital>();
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();

		hospitalNameList = superAdminMasterHandlerService.getHospitalNameList(hospitalCode, hospitalName);
		hospitalMasterList = superAdminMasterHandlerService.getHospitalMasterList(hospitalId);
		jsp = RequestConstants.UPDATE_HOSPITAL_JSP;
		title = "Update Hospital";
		jsp += ".jsp";
		map.put("hospitalNameList", hospitalNameList);
		map.put("hospitalMasterList", hospitalMasterList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		
		return new ModelAndView("SuperAdminMenu", "map", map);
	}
	public ModelAndView updateHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = Integer.parseInt(request.getParameter(RequestConstants.HOSPITAL_ID));
		String hospitalCode = request.getParameter(RequestConstants.HOSPITAL_CODE);
		String hospitalName = request.getParameter(RequestConstants.SEARCH_NAME);
		String address = request.getParameter(RequestConstants.ADDRESS);
		String contactNumber = request
				.getParameter(RequestConstants.CONTACT_NUMBER);
		String hospitalStatus = request.getParameter(RequestConstants.STATUS);
		String hospitalChangeBy = request
				.getParameter(RequestConstants.CHANGED_BY);
		Date hospitalDate = new Date();
		String hospitalTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		List<MasHospital> checkList = new ArrayList<MasHospital>();
		checkList = superAdminMasterHandlerService
				.checkExistingHospitalForEdit(hospitalId, hospitalName);

		MasHospital hospitalMaster = new MasHospital();
		boolean dataFixed = false;
		String message = "";

		if (checkList.size() == 0 || checkList == null) {
			hospitalMaster.setId(hospitalId);
			hospitalMaster.setHospitalCode(hospitalCode);
			hospitalMaster.setHospitalName(hospitalName);
			hospitalMaster.setAddress(address);
			hospitalMaster.setContactNumber(contactNumber);
			hospitalMaster.setStatus(hospitalStatus);
			hospitalMaster.setLastChgBy(hospitalChangeBy);
			hospitalMaster.setLastChgDate(hospitalDate);
			hospitalMaster.setLastChgTime(hospitalTime);

			dataFixed = superAdminMasterHandlerService
					.updateHospital(hospitalMaster);
			if (dataFixed == true) {
				message = "Hospital Information updated successfully.";
			} else {
				message = "Try again!";
			}
			url = "/security/security/superAdmin?method=showHospitalMasterJsp";
			jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
			map.put("url", url);

		} else if (checkList.size() > 0 || checkList != null) {

			message = "Hospital Name  already exists.";
			jsp = RequestConstants.HOSPITAL_JSP;
			title = "Update Hospital";

		}
		jsp += ".jsp";
		title = "Hospital";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("SuperAdminMenu", "map", map);
	}

	public ModelAndView showDeleteHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		session = request.getSession();

		String hospitalCode = "";
		String hospitalName = "";
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();

		if (request.getParameter(RequestConstants.HOSPITAL_CODE) != null) {
			hospitalCode = request.getParameter(RequestConstants.HOSPITAL_CODE);
		}

		if (request.getParameter(RequestConstants.SEARCH_NAME) != null) {
			hospitalName = request.getParameter(RequestConstants.SEARCH_NAME);
		}

		hospitalNameList = superAdminMasterHandlerService.getHospitalNameList(
				hospitalCode, hospitalName);
		session.setAttribute("hospitalCode", hospitalCode);
		session.setAttribute("hospitalName", hospitalName);

		jsp = RequestConstants.DELETE_HOSPITAL_JSP;
		title = "Delete Hospital";
		jsp += ".jsp";
		map.put("hospitalNameList", hospitalNameList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("SuperAdminMenu", "map", map);

	}

	public ModelAndView showDeleteHospitalWithDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		session = request.getSession();

		String hospitalCode = "";
		String hospitalName = "";

		hospitalCode = (String) session.getAttribute("hospitalCode");
		hospitalName = (String) session.getAttribute("hospitalName");

		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		List<MasHospital> hospitalMasterList = new ArrayList<MasHospital>();
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();

		hospitalNameList = superAdminMasterHandlerService.getHospitalNameList(
				hospitalCode, hospitalName);
		hospitalMasterList = superAdminMasterHandlerService
				.getHospitalMasterList(hospitalId);

		jsp = RequestConstants.DELETE_HOSPITAL_JSP;
		title = "Delete Title";

		jsp += ".jsp";
		map.put("hospitalNameList", hospitalNameList);
		map.put("hospitalMasterList", hospitalMasterList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("SuperAdminMenu", "map", map);
	}

	public ModelAndView deleteHospital(HttpServletRequest request,
			HttpServletResponse response) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		int hospitalId = Integer.parseInt(request
				.getParameter(RequestConstants.HOSPITAL_ID));
		boolean dataDeleted = superAdminMasterHandlerService
				.deleteHospital(hospitalId);
		if (dataDeleted == true) {
			message = "Hospital Information deleted successfully!!";

		} else {
			message = "Try again!";
		}

		url = "/security/security/superAdmin?method=showHospitalMasterJsp";
		jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
		map.put("url", url);
		title = "Delete Hospital";

		jsp += ".jsp";
		map.put("dataDeleted", dataDeleted);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("SuperAdminMenu", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showEnquiryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String min = "0";
		String max = "4";
		String searchName = "";
		String nextState = "enable";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		HttpSession session = request.getSession(false);

		if (session.getAttribute("pojoName") != null)
			pojoName = (String) session.getAttribute("pojoName");

		if (session.getAttribute("viewPage") != null)
			viewPage = (String) session.getAttribute("viewPage");

		if (session.getAttribute("pojoPropertyName") != null)
			pojoPropertyName = (String) session
					.getAttribute("pojoPropertyName");

		searchName = request.getParameter(RequestConstants.SEARCH_NAME);
		session.setAttribute("searchName", searchName);

		mapForDs.put("pojoName", pojoName);
		mapForDs.put("pojoPropertyName", pojoPropertyName);
		mapForDs.put("searchName", searchName);

		List enquiryList = new ArrayList();

		enquiryList = (List) superAdminMasterHandlerService
				.getTableRecords(mapForDs);

		int sizeOfList = enquiryList.size();

		if ((sizeOfList <= 5)) {
			nextState = "disable";
		}
		viewPage += ".jsp";
		map.put("nextState", nextState);
		map.put("enquiryList", enquiryList);
		map.put("min", min);
		map.put("max", max);
		map.put("contentJsp", viewPage);
		return new ModelAndView("SuperAdminMenu", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView next(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		String nextState = "enable";
		String previousState = "enable";
		String min;
		String max;
		String searchName = "";

		String x = (String) session.getAttribute("min");
		String y = (String) session.getAttribute("max");

		if (session.getAttribute("pojoName") != null)
			pojoName = (String) session.getAttribute("pojoName");

		if (session.getAttribute("viewPage") != null)
			viewPage = (String) session.getAttribute("viewPage");

		if (session.getAttribute("pojoPropertyName") != null)
			pojoPropertyName = (String) session
					.getAttribute("pojoPropertyName");

		searchName = (String) session.getAttribute("searchName");

		mapForDs.put("pojoName", pojoName);
		mapForDs.put("pojoPropertyName", pojoPropertyName);
		mapForDs.put("searchName", searchName);

		int temp1 = Integer.parseInt(x);
		int temp2 = Integer.parseInt(y);
		temp1 = temp1 + 5;
		temp2 = temp2 + 5;

		Map<String, Object> map = new HashMap<String, Object>();
		List enquiryList = new ArrayList();

		enquiryList = (List) superAdminMasterHandlerService
				.getTableRecords(mapForDs);

		int sizeOfList = enquiryList.size();

		if ((temp2 + 1 >= sizeOfList)) {
			nextState = "disable";
		}

		viewPage += ".jsp";
		min = temp1 + "";
		max = temp2 + "";
		map.put("enquiryList", enquiryList);
		map.put("min", min);
		map.put("max", max);
		map.put("nextState", nextState);
		map.put("previousState", previousState);
		map.put("contentJsp", viewPage);
		return new ModelAndView("SuperAdminMenu", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView previous(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		String nextState = "enable";
		String previousState = "enable";
		HttpSession session = request.getSession(false);
		String min;
		String max;
		String searchName = "";

		String x = (String) session.getAttribute("min");
		String y = (String) session.getAttribute("max");

		if (session.getAttribute("pojoName") != null)
			pojoName = (String) session.getAttribute("pojoName");

		if (session.getAttribute("viewPage") != null)
			viewPage = (String) session.getAttribute("viewPage");

		if (session.getAttribute("pojoPropertyName") != null)
			pojoPropertyName = (String) session
					.getAttribute("pojoPropertyName");

		searchName = (String) session.getAttribute("searchName");

		mapForDs.put("pojoName", pojoName);
		mapForDs.put("pojoPropertyName", pojoPropertyName);
		mapForDs.put("searchName", searchName);

		int temp1 = Integer.parseInt(x);
		int temp2 = Integer.parseInt(y);
		temp1 = temp1 - 5;
		temp2 = temp2 - 5;

		Map<String, Object> map = new HashMap<String, Object>();
		List enquiryList = new ArrayList();

		enquiryList = (List) superAdminMasterHandlerService
				.getTableRecords(mapForDs);

		if ((temp1 <= 0)) {
			previousState = "disable";
		} else
			previousState = "enable";

		viewPage += ".jsp";
		min = temp1 + "";
		max = temp2 + "";
		map.put("enquiryList", enquiryList);
		map.put("min", min);
		map.put("max", max);
		map.put("nextState", nextState);
		map.put("previousState", previousState);
		map.put("contentJsp", viewPage);
		return new ModelAndView("SuperAdminMenu", "map", map);

	}

	// ----------------------------methods written by
	// vikas------------------------------------------

	public ModelAndView showModuleManagementJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = superAdminMasterHandlerService.showModuleManagementJsp(box);
		List users = (List) map.get("users");
		map.put("users", users);
		jsp = RequestConstants.MODULE_MANAGEMENT_JSP;
		jsp += ".jsp";
		title = "Module Management";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		map.put("search", "NO");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUserManagementJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int userId = 0;
		if (request.getParameter("userIdNew") != null
				&& !request.getParameter("userIdNew").equals(""))
			userId = Integer.parseInt(request.getParameter("userIdNew"));
		List<Users> userList = new ArrayList<Users>();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		map = superAdminMasterHandlerService.showUserManagementJsp(userId);

		jsp = RequestConstants.USER_MANAGEMENT_JSP;
		title = "User Management";

		jsp += ".jsp";
		map.put("hospitalId", hospitalId);
		map.put("userId", userId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getGroupList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();

		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		map = superAdminMasterHandlerService.getGroupList(hospitalId);

		jsp = RequestConstants.USERGROUP_LIST_JSP;
		title = "User Management";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showApplicationListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();

		int groupHospitalId = Integer.parseInt(request
				.getParameter("groupHospitalId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		
		int groupId = superAdminMasterHandlerService
				.getGroupIdFromGroupHospitalId(groupHospitalId);
		map = superAdminMasterHandlerService.getApplicationGroupWise(groupId);
		map = superAdminMasterHandlerService.getMasterApplicationList(userId);
		String parentAppId="";
		if(map.get("parentAppId") !=null){
			parentAppId=(String)map.get("parentAppId");
		}
		map = superAdminMasterHandlerService.getUserUsergroupApplicationList(
				userId, groupHospitalId,parentAppId);
		jsp = RequestConstants.GROUP_WISE_APPLICATION_JSP;
		title = "User Management";

		jsp += ".jsp";
		map.put("parentAppId",parentAppId);
		map.put("hospitalId", hospitalId);
		map.put("groupHospitalId", groupHospitalId);
		map.put("userId", userId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;
	}

	public ModelAndView submitUserWiseApplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		String message = null;
		Box box = HMSUtil.getBox(request);
	//	int hospitalId = (Integer) session.getAttribute("hospitalId");
		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int groupHospitalId = Integer.parseInt(request
				.getParameter("groupHospitalId"));
		String[] str = request.getParameterValues("groupApplicationId");
		String applicationId = request.getParameter("applicationId");
		String parentAppId = request.getParameter("parentAppId");
		//int order_no =  Integer.parseInt(request.getParameter("order_no"));
		map = superAdminMasterHandlerService
				.getGroupApplicationArray(applicationId);
		List<GroupApplication> groupAppArrayList = (List<GroupApplication>) map
				.get("groupAppArrayList");
		List groupApplicationList = new ArrayList();
		List orderApplicationList = new ArrayList();
		if (str != null) {
			for (int j = 0; j < str.length; j++) {
				int groupApplicationId = Integer.parseInt(str[j]);
				groupApplicationList.add(groupApplicationId);
			}
		}
		map.put("groupAppArrayList", groupAppArrayList);
		map.put("groupHospitalId", groupHospitalId);
		map.put("userId", userId);
		map.put("groupApplicationList", groupApplicationList);
		map.put("parentAppId", parentAppId);
		map.put("orderApplicationList", orderApplicationList);
		map.put("box", box);
		boolean successfullyAdded = superAdminMasterHandlerService
				.submitUserWiseApplication(map);
		if (successfullyAdded) {
			// map= superAdminMasterHandlerService.showModuleManagementJsp(box);
			map = superAdminMasterHandlerService.showUserManagementJsp(userId);
			message = "Application Has Been Assigned/Removed From  User";
			jsp = RequestConstants.USER_MANAGEMENT_JSP;
		} else {
			message = "Error Ocurred Please Try Again";
			jsp = RequestConstants.MODULE_MANAGEMENT_JSP;
		}
		jsp += ".jsp";
		map.put("hospitalId", hospitalId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView changeWardJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();

		String userName = (String) session.getAttribute("userName");
		Users users = (Users) session.getAttribute("users");

		Integer deptId = (Integer) session.getAttribute("deptId");
		String deptName = (String) session.getAttribute("deptName");
		map = superAdminMasterHandlerService.getDepartmentList();
		jsp = "changeWard";
		title = "Change Ward";
		jsp += ".jsp";
		map.put("userName", userName);
		map.put("deptId", String.valueOf(deptId));
		map.put("deptName", deptName);
		if(users.getId() != null)
		{
		map.put("userId", users.getId());
		}
		map.put("contentJsp", jsp);
		map.put("message", "");
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView changeWardInSession(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = 0;
		String deptName = "";
		deptId = box.getInt("ward");
		deptName = box.getString("deptName");
		String message = "";

		session.setAttribute("deptId", deptId);
		session.setAttribute("deptName", deptName);
		session.setAttribute("deptType", superAdminMasterHandlerService
				.getDepartmentTypeCode(deptId));

		String userName = (String) session.getAttribute("userName");
		deptId = (Integer) session.getAttribute("deptId");
		deptName = (String) session.getAttribute("deptName");
		map = superAdminMasterHandlerService.getDepartmentList();
		jsp = "changeWard";
		title = "Change Ward";
		jsp += ".jsp";
		map.put("userName", userName);
		map.put("deptId", String.valueOf(deptId));
		map.put("deptName", deptName);
		map.put("message",
				"Ward/Department has been Successfully Changed!......");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	// Added by kalyan

	public ModelAndView showChangePassword(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession(true);

		String oldpwd = "";
		String newpwd = "";
		String conpwd = "";
		String action = "";
		String loginName = "";
		int userId = 0;

		if (request.getParameter("oldPwd") != null) {
			oldpwd = request.getParameter("oldPwd");
		}

		if (request.getParameter("newPwd") != null) {
			newpwd = request.getParameter("newPwd");
		}

		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}
		if (request.getParameter("conPwd") != null) {
			conpwd = request.getParameter("conPwd");
		}
		if (request.getParameter("userId") != null
				&& (Integer.parseInt(request.getParameter("userId")) != 0)) {
			userId = Integer.parseInt(request.getParameter("userId"));
		}
		if (request.getParameter("loginName") != null) {
			if (!request.getParameter("loginName").equals("")) {
				loginName = request.getParameter("loginName");
			}
		}

		dataMap.put("oldpwd", oldpwd);
		dataMap.put("newpwd", newpwd);

		String userName = (String) session.getAttribute("userName");
		String loginUser = (String) session.getAttribute("loginUser");
		Integer deptId = (Integer) session.getAttribute("deptId");
		String deptName = (String) session.getAttribute("deptName");

		dataMap.put("userId", userId);
		dataMap.put("userName", userName);
		dataMap.put("loginUser", loginUser);
		dataMap.put("action", action);
		dataMap.put("loginName", loginName);

		map = superAdminMasterHandlerService.updateNewPassowd(dataMap);

		jsp = "changePassword";
		title = "Change Password";
		jsp += ".jsp";
		String message = "";
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}

		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * Added by Priyanka on 27 Nov 2008 for doing search on Module Management
	 * screen according to user name and login name.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showRecordsForModuleManagement(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = superAdminMasterHandlerService.showModuleManagementJsp(box);
		List users = (List) map.get("users");
		map.put("users", users);
		jsp = RequestConstants.MODULE_MANAGEMENT_JSP;
		jsp += ".jsp";
		title = "Module Management";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		map.put("search", "YES");
		return new ModelAndView("indexB", "map", map);
	}

	// ------------------methods For enhancement of security module Assign
	// Application to user-------------

	public ModelAndView showAssignApplicationToUsers(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		// map= superAdminMasterHandlerService.showModuleManagementJsp(box);

		jsp = "assignApplicationToUser";
		jsp += ".jsp";
		title = "Module Management";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		return new ModelAndView("indexB", "map", map);
	}

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
		map = superAdminMasterHandlerService
				.getApplicationListForAutoComplete(map);
		jsp = "responseForApplicationList";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getGroupListForAssignApplication(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();

		String applicationName = request.getParameter("applicationName");
		int index1 = applicationName.indexOf("[");
		index1 = index1 + 1;
		int index2 = applicationName.indexOf("]");

		String applicationId = applicationName.substring(index1, index2);
		List groupApplicationList = superAdminMasterHandlerService
				.getGroupForApplication(applicationId);

		jsp = "groupListForAssignApplication";
		title = "User Management";
		map.put("groupApplicationList", groupApplicationList);

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}

	public ModelAndView getHospitalList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();

		String applicationName = request.getParameter("applicationName");
		int index1 = applicationName.indexOf("[");
		index1 = index1 + 1;
		int index2 = applicationName.indexOf("]");
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String applicationId = applicationName.substring(index1, index2);
		List groupApplicationList = superAdminMasterHandlerService
				.getGroupForApplication(applicationId);
		// GroupApplication
		// groupApplication=(GroupApplication)groupApplicationList.get(0);
		// String groupName=groupApplication.getGroup().getGroupName();
		// int groupId=groupApplication.getGroup().getId();
		int groupApplicationId = Integer.parseInt(request
				.getParameter("groupAppId"));
		List hospitalList = superAdminMasterHandlerService.getHospitalList(
				groupApplicationId, hospitalId);
		// int groupApplicationId=groupApplication.getId();
		// List usersList=superAdminMasterHandlerService.getUsersList();
		// List userUGAppList=
		map = superAdminMasterHandlerService.getEmpGroupList();
		jsp = "hospitalList";
		title = "User Management";
		map.put("groupApplicationId", groupApplicationId);
		map.put("hospitalId", hospitalId);
		map.put("hospitalList", hospitalList);
		map.put("applicationId", applicationId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}

	@SuppressWarnings("unused")
	public ModelAndView getUsersList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
		// List<UserEmpGroup> usersList= new ArrayList<UserEmpGroup>();
		List<UserUsergroupHospital> usersList = new ArrayList<UserUsergroupHospital>();
		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		List<UserUsergroupApplication> userUGAppList = new ArrayList<UserUsergroupApplication>();
		int groupApplicationId = Integer.parseInt(request
				.getParameter("groupApplicationId"));
		String applicationId = request.getParameter("applicationId");
		String combinedId = request.getParameter("hospitalId");
		int index1 = combinedId.indexOf(",");
		int groupHospitalId = Integer.parseInt(combinedId.substring(0, index1));
		index1++;
		int hospitalId = Integer.parseInt(combinedId.substring(index1));

		// int
		// groupHospitalId=Integer.parseInt(request.getParameter("hospitalId"));
		// int hospitalId=Integer.parseInt(request.getParameter("hospId"));
		if (request.getParameter("empGroupId") != null
				&& !request.getParameter("empGroupId").equals("")) {
			int empGroupId = Integer.parseInt(request
					.getParameter("empGroupId"));
			// usersList=superAdminMasterHandlerService.getUsersListFromUserEmpGroup(empGroupId,groupHospitalId);
			userEmpGroupList = superAdminMasterHandlerService
					.getUsersListFromUserEmpGroup(empGroupId, groupHospitalId);
			map.put("empGroupId", empGroupId);
			map.put("userEmpGroupList", userEmpGroupList);
			map.put("value", "true");
		} else {
			map.put("value", "false");
		}
		usersList = superAdminMasterHandlerService
				.getUserListFromUserUserGroupHospitalForGroupHospitalId(groupHospitalId);
		// usersList=superAdminMasterHandlerService.getAllUsersListFromUserEmpGroup(hospitalId);
		userUGAppList = superAdminMasterHandlerService
				.getUserListFromUserUGApp(groupHospitalId, groupApplicationId);

		jsp = "userList";
		title = "User Management";
		map.put("hospitalId", hospitalId);
		map.put("userUGAppList", userUGAppList);
		map.put("usersList", usersList);
		map.put("applicationId", applicationId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}

	public ModelAndView addUserWiseApplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		int groupApplicationId = Integer.parseInt(request
				.getParameter("groupApplicationId"));
		String applicationId = request.getParameter("applicationId");
		// int empGroupId=Integer.parseInt(request.getParameter("empGroupId"));
		String combinedId = request.getParameter("hospitalId");
		int index1 = combinedId.indexOf(",");
		int groupHospitalId = Integer.parseInt(combinedId.substring(0, index1));
		Map<String, Object> arrayMap = superAdminMasterHandlerService
				.getGroupApplicationArray(applicationId);
		List<GroupApplication> groupAppArrayList = (List<GroupApplication>) arrayMap
				.get("groupAppArrayList");
		String arr[] = request.getParameterValues("userId");
		List<UserUsergroupApplication> userUGApplList = superAdminMasterHandlerService
				.getUserListFromUserUGApp(groupHospitalId, groupApplicationId);
		List<Integer> userIdList = new ArrayList<Integer>();
		List<Integer> userIdToBeAdded = new ArrayList<Integer>();
		List<Integer> userIdToBeRemoved = new ArrayList<Integer>();
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				int userId = Integer.parseInt(arr[i]);
				userIdList.add(userId);
			}
		}
		if (userIdList.size() >= userUGApplList.size()) {

			OuterLoop: for (Integer userId : userIdList) {
				String bool = "false";
				InnerLoop: for (UserUsergroupApplication userUsergroupApplication : userUGApplList) {
					if (userId.intValue() == userUsergroupApplication.getUser()
							.getId()) {
						bool = "true";
						break InnerLoop;
					}
				}
				if (bool.equals("false")) {
					userIdToBeAdded.add(userId);
				}
			}
			for (UserUsergroupApplication userUsergroupApplication : userUGApplList) {
				String bool = "false";
				InnerLoop: for (Integer userId : userIdList) {
					if (userId.intValue() == userUsergroupApplication.getUser()
							.getId()) {
						bool = "true";
						break InnerLoop;
					}

				}
				if (bool.equals("false")) {
					userIdToBeRemoved.add(userUsergroupApplication.getUser()
							.getId());
				}
			}

		} else {
			for (UserUsergroupApplication userUsergroupApplication : userUGApplList) {
				String bool = "false";
				InnerLoop: for (Integer userId : userIdList) {
					if (userId.intValue() == userUsergroupApplication.getUser()
							.getId()) {
						bool = "true";
						break InnerLoop;
					}
				}
				if (bool.equals("false")) {
					userIdToBeRemoved.add(userUsergroupApplication.getUser()
							.getId());
				}
			}
			for (Integer userId : userIdList) {
				String bool = "false";
				InnerLoop: for (UserUsergroupApplication userUsergroupApplication : userUGApplList) {
					if (userId.intValue() == userUsergroupApplication.getUser()
							.getId()) {
						bool = "true";
						break InnerLoop;
					}
				}
				if (bool.equals("false")) {
					userIdToBeAdded.add(userId);
				}
			}

		}
		dataMap.put("userIdToBeAdded", userIdToBeAdded);
		dataMap.put("userIdToBeRemoved", userIdToBeRemoved);
		dataMap.put("groupApplicationId", groupApplicationId);
		dataMap.put("groupHospitalId", groupHospitalId);
		dataMap.put("groupAppArrayList", groupAppArrayList);
		boolean successfullyAdded = superAdminMasterHandlerService
				.addUserWiseApplication(dataMap);
		if (successfullyAdded) {
			message = "Aplication Has Been Assigned To Users.";

		} else {
			message = "There Is problem In Assigning Application To Users.";
		}

		jsp = "assignApplicationToUser";
		jsp += ".jsp";
		title = "User Management";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;
	}

	// ----------------methods added for Assign module------------------
	public ModelAndView showAssignModuleToEmpGroupJsp(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = (Integer) session.getAttribute("hospitalId");

		map = superAdminMasterHandlerService.showAssignModuleToEmpGroupJsp();
		String jsp = "assignModuleToEmpGroup";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView populateEmpGroupAndAppGroupJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		map = superAdminMasterHandlerService.populateEmpGroupAndAppGroupJsp(hospitalId);
		jsp = "populateEmpGroupAndApplGroup";
		title = "populate EmpLoyee Group";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getApplicationList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		String combinedGroupAndGroupHospitalId = request
				.getParameter("groupId");
		int index1 = combinedGroupAndGroupHospitalId.indexOf(",");
		
		int groupId = Integer.parseInt(combinedGroupAndGroupHospitalId
				.substring(0, index1));
		index1++;
		int groupHospitalId = Integer.parseInt(combinedGroupAndGroupHospitalId
				.substring(index1));

		map = superAdminMasterHandlerService.getApplicationGroupWise(groupId);
		List applicationListGroupWise = (List) map
				.get("applicationListGroupWise");

		if (request.getParameter("empGroup") != null && !request.getParameter("empGroup").equals("")) {
			int empGroupId = Integer.parseInt(request.getParameter("empGroup"));
			userEmpGroupList = superAdminMasterHandlerService
					.getUserListFromUserEmpGroup(empGroupId);
			map.put("userEmpGroupList", userEmpGroupList);
			map.put("value", "true");
		} else {
			map.put("value", "false");
		}

		List<MasApplication> masApplicationList = superAdminMasterHandlerService
				.getApplicationList(groupId);
		List<UserUsergroupHospital> usersList = superAdminMasterHandlerService
				.getUserListFromUserUserGroupHospitalForGroupHospitalId(groupHospitalId);
		List<UserUsergroupApplication> userUGAppList = superAdminMasterHandlerService
				.getUserListFromUUGAppForGroupHospital(groupHospitalId);

		jsp = "applicationList";
		title = "User Management";
		map.put("userUGAppList", userUGAppList);
		map.put("usersList", usersList);
		map.put("masApplicationList", masApplicationList);
		map.put("applicationListGroupWise", applicationListGroupWise);
		map.put("groupHospitalId", groupHospitalId);
		map.put("groupId", groupId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}

	public ModelAndView getUserRights(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		int userId = Integer.parseInt("" + request.getParameter("userId"));

		String combinedGroupAndGroupHospitalId = request
				.getParameter("groupId");
		int index1 = combinedGroupAndGroupHospitalId.indexOf(",");
		int groupId = Integer.parseInt(combinedGroupAndGroupHospitalId
				.substring(0, index1));
		index1++;
		int groupHospitalId = Integer.parseInt(combinedGroupAndGroupHospitalId
				.substring(index1));
		List<UserUsergroupApplication> userApplicationList = superAdminMasterHandlerService
				.getUserApplicationList(userId, groupId);
		// List<UserUsergroupHospital>
		// usersList=superAdminMasterHandlerService.getUserListFromUserUserGroupHospitalForGroupHospitalId(groupHospitalId);
		// List<UserUsergroupApplication>
		// userUGAppList=superAdminMasterHandlerService.getUserListFromUUGAppForGroupHospital(groupHospitalId);

		jsp = "userApplicationList";
		title = "User Management";

		map.put("userApplicationList", userApplicationList);
		map.put("groupId", groupId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}

	public ModelAndView assignModuleToEmpGroup(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String[] userIdArray = request.getParameterValues("userId");
		String[] appIdArray = request.getParameterValues("appId");
		String combinedGroupAndGroupHospitalId = request
				.getParameter("groupId");
		int index1 = combinedGroupAndGroupHospitalId.indexOf(",");

		int groupId = Integer.parseInt(combinedGroupAndGroupHospitalId
				.substring(0, index1));
		index1++;
		int groupHospitalId = Integer.parseInt(combinedGroupAndGroupHospitalId
				.substring(index1));
		dataMap = superAdminMasterHandlerService
				.getApplicationGroupWise(groupId);

		dataMap.put("userIdArray", userIdArray);
		dataMap.put("appIdArray", appIdArray);
		dataMap.put("groupHospitalId", groupHospitalId);

		boolean bool = superAdminMasterHandlerService
				.assignModuleToEmpGroup(dataMap);

		String message = "";
		if (bool) {

			message = "Module Has been Assigned To Employee Group.";

		} else {
			message = "Problem Occurred in Assigning Module To Employee Group.";
		}
		map = superAdminMasterHandlerService.showAssignModuleToEmpGroupJsp();
		String jsp = "assignModuleToEmpGroup";
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	// -------------------end of mehods for Assign module---------
	// ----------------------------methods addd by vikas for on
	// 30/04/09------------------

	public ModelAndView showAssignButtonRightsToEmpGroupJsp(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		map = superAdminMasterHandlerService
				.showAssignButtonRightsToEmpGroupJsp();
		String jsp = "assignButtonRightsToEmpGroup";
		jsp += ".jsp";
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getButtonDetailsWithUsersList(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		String formName = "";
		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		List<MasButtonForm> buttonList = new ArrayList<MasButtonForm>();
		List<UserButtonRights> buttonRightsAvailableList = new ArrayList<UserButtonRights>();
		if (request.getParameter("formName") != null
				&& !request.getParameter("formName").equals("0")) {

			formName = request.getParameter("formName");
			map = superAdminMasterHandlerService.getButtonList(formName);

		}
		if (request.getParameter("empGroup") != null
				&& !request.getParameter("empGroup").equals("")) {
			int empGroupId = Integer.parseInt(request.getParameter("empGroup"));
			dataMap.put("empGroupId", empGroupId);
			dataMap.put("hospitalId", hospitalId);
			userEmpGroupList = superAdminMasterHandlerService
					.getUserListFromUserEmpGroup(dataMap);
			map.put("userEmpGroupList", userEmpGroupList);

		}
		jsp = "buttonRightsAndUsersList";
		title = "User Management";
		map.put("formName", formName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}

	public ModelAndView assignButtonRightsToEmpGroup(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String[] userIdArray = request.getParameterValues("userId");
		String[] buttonNameArray = request.getParameterValues("buttonName");

		int empGroupId = Integer.parseInt(request.getParameter("empGroup"));
		dataMap.put("userIdArray", userIdArray);
		dataMap.put("buttonNameArray", buttonNameArray);
		dataMap.put("empGroupId", empGroupId);

		boolean bool = superAdminMasterHandlerService
				.assignButtonRightsToEmpGroup(dataMap);
		String message = "";
		if (bool) {

			message = "BUtton Rights Has been Assigned To Employee Group.";

		} else {
			message = "Problem Occurred in Assigning Button Rights To Employee Group.";
		}
		map = superAdminMasterHandlerService
				.showAssignButtonRightsToEmpGroupJsp();
		String jsp = "assignButtonRightsToEmpGroup";
		jsp += ".jsp";
		map.put("hospitalId", hospitalId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView getEmpNameByLoginName(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		String loginName = "";
		if (request.getParameter("loginName") != null) {
			loginName = request.getParameter("loginName");
		}
		map = superAdminMasterHandlerService
				.getEmpNameByLoginName(loginName);
		
		jsp = "empNameByLoginName";
		title = "User Management";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}

	public ModelAndView showRemoveButtonRights(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		int userId = 0;

		if (request.getParameter("userIdNew") != null
				&& !request.getParameter("userIdNew").equals(""))
			userId = Integer.parseInt(request.getParameter("userIdNew"));

		dataMap.put("userId", userId);

		map = superAdminMasterHandlerService.showRemoveButtonRights(dataMap);

		jsp = "removeButtonRights";
		title = "User Management";

		jsp += ".jsp";
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
		// return null;
	}

	public ModelAndView getButtonDetailsForRemoveRights(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		String formName = "";

		int userId = Integer.parseInt(request.getParameter("userId"));

		if (request.getParameter("formName") != null
				&& !request.getParameter("formName").equals("0")) {
			formName = request.getParameter("formName");
		}
		dataMap.put("formName", formName);
		dataMap.put("userId", userId);
		map = superAdminMasterHandlerService
				.getButtonRightsAvailableList(dataMap);
		jsp = "buttonList";
		title = "User Management";
		map.put("userId", userId);
		map.put("formName", formName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}

	public ModelAndView removeButtonRights(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		String[] buttonNameArray = request.getParameterValues("userButtonId");
		String formName = request.getParameter("formName");
		int userId = Integer.parseInt(request.getParameter("userId"));
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		dataMap.put("buttonNameArray", buttonNameArray);
		dataMap.put("userId", userId);
		dataMap.put("formName", formName);
		boolean bool = superAdminMasterHandlerService
				.removeButtonRights(dataMap);
		String message = "";
		if (bool) {

			message = "Button Rights Has been Removed From User.";

		} else {
			message = "Problem Occurred in Removing Button Rights.";
		}
		map = superAdminMasterHandlerService.showRemoveButtonRights(dataMap);
		String jsp = "removeButtonRights";
		jsp += ".jsp";
		map.put("hospitalId", hospitalId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView viewUserRightsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		int userId = 0;
		if (request.getParameter("userIdNew") != null
				&& !request.getParameter("userIdNew").equals(""))
			userId = Integer.parseInt(request.getParameter("userIdNew"));
		dataMap.put("userId", userId);
		dataMap.put("hospitalId", hospitalId);
		map = superAdminMasterHandlerService.viewUserRights(dataMap);
		jsp = "viewUserRights";

		jsp += ".jsp";

		map.put("userId", userId);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;
	}

	public ModelAndView removeUserRights(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		String message = "";
		int userId = 0;
		int hospitalId = 0;
		if (request.getParameter("userId") != null
				&& !request.getParameter("userId").equals(""))
			userId = Integer.parseInt(request.getParameter("userId"));

		if (request.getParameter("hospitalId") != null
				&& !request.getParameter("hospitalId").equals(""))
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));

		dataMap.put("userId", userId);
		dataMap.put("hospitalId", hospitalId);

		boolean bool = superAdminMasterHandlerService.removeUserRights(dataMap);

		if (bool) {
			message = "User Rights Has been Removed Successfully!!";
		} else {
			message = "Some Error Ocurred in Removing  User Rights!!";
		}

		map = superAdminMasterHandlerService.showModuleManagementJsp(box);
		List users = (List) map.get("users");
		map.put("users", users);
		jsp = RequestConstants.MODULE_MANAGEMENT_JSP;

		jsp += ".jsp";

		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;
	}

	public ModelAndView showOrderApplicationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		map = superAdminMasterHandlerService.showOrderApplicationJsp();

		String jsp = "showOrderApplication";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView populateEmpGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		map = superAdminMasterHandlerService.populateEmpGroup(hospitalId);

		jsp = "populateEmpGroup";
		title = "populate EmpLoyee Group";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getApplicationListForOrdering(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int groupId = 0;
		int groupHospitalId = 0;

		if (request.getParameter("groupId") != null
				&& !request.getParameter("groupId").equals("0")) {

			String combinedGroupAndGroupHospitalId = request
					.getParameter("groupId");
			int index1 = combinedGroupAndGroupHospitalId.indexOf(",");
			groupId = Integer.parseInt(combinedGroupAndGroupHospitalId
					.substring(0, index1));
			index1++;
			groupHospitalId = Integer.parseInt(combinedGroupAndGroupHospitalId
					.substring(index1));
		}

		map = superAdminMasterHandlerService.getApplicationGroupWise(groupId);
		List applicationListGroupWise = (List) map
				.get("applicationListGroupWise");

		String parentAppId = (String) map.get("parentAppId");
		List<MasApplication> masApplicationList = superAdminMasterHandlerService
				.getApplicationList(groupId);

		jsp = "orderApplication";
		title = "User Management";
		map.put("parentAppId", parentAppId);
		map.put("masApplicationList", masApplicationList);
		map.put("applicationListGroupWise", applicationListGroupWise);
		map.put("groupHospitalId", groupHospitalId);
		map.put("groupId", groupId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}

	public ModelAndView submitSwapApplication(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Vector appIdVector = box.getVector("appIdToSwap");
		Vector OrderNoVector = box.getVector("orderNo");

		Vector subAppIdVector = box.getVector("subAppIdToSwap");
		Vector subOrderNoVector = box.getVector("subOrderNo");

		appIdVector.addAll(subAppIdVector);
		OrderNoVector.addAll(subOrderNoVector);

		dataMap.put("appIdVector", appIdVector);
		dataMap.put("OrderNoVector", OrderNoVector);

		boolean bool = superAdminMasterHandlerService
				.submitSwapApplication(dataMap);
		String message = "";
		if (bool) {
			message = "Application Ordered.";
		} else {
			message = "Problem Occurred .";
		}
		map = superAdminMasterHandlerService.showOrderApplicationJsp();
		String jsp = "showOrderApplication";
		jsp += ".jsp";
		map.put("hospitalId", hospitalId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showSubMenuForOrdering(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		session = request.getSession();
		int groupId = 0;
		String subParentAppId = "";
		if (request.getParameter("groupIdSub") != null
				&& !request.getParameter("groupIdSub").equals("0")) {
			groupId = Integer.parseInt(request.getParameter("groupIdSub"));
			mapForDs.put("groupId", groupId);
		}
		if (request.getParameter("subParentAppId") != null
				&& !request.getParameter("subParentAppId").equals("0")) {
			subParentAppId = request.getParameter("subParentAppId");
			mapForDs.put("subParentAppId", subParentAppId);
		}

		map = superAdminMasterHandlerService.showSubMenuForOrdering(mapForDs);

		jsp = "subMenuOrdering";
		title = "User Management";

		map.put("groupId", groupId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}

	public ModelAndView addOrderInApplication(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		boolean bool = superAdminMasterHandlerService.addOrderInApplication();
		map = superAdminMasterHandlerService.showModuleManagementJsp(box);
		List users = (List) map.get("users");
		map.put("users", users);
		jsp = RequestConstants.MODULE_MANAGEMENT_JSP;

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("indexB", "map", map);
	}

	// ----------------------------end of methods addded by vikas for on
	// 30/04/09------------------
	//---- methods added by anand
	@SuppressWarnings("unchecked")
	public ModelAndView showUserDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();		
		List<MasDepartment> departmentlist=new ArrayList<MasDepartment>();
		map = superAdminMasterHandlerService.getDepartmentUserList();
		departmentlist = (List<MasDepartment>)map.get("departmentlist");
		jsp = RequestConstants.USER_DEPARTMENT;
		jsp += ".jsp";
		title = "userDepartment";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("departmentlist", departmentlist);
		return new ModelAndView("index", "map", map);
	}
	

	@SuppressWarnings("unchecked")
	public ModelAndView showEmpGrpDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();		
		List<EmpGroups> empGroupList=new ArrayList<EmpGroups>();
		map = superAdminMasterHandlerService.getEmpGroupList();
		empGroupList = (List<EmpGroups>)map.get("empGroupList");
		jsp = RequestConstants.USER_EMP_GRP;
		jsp += ".jsp";
		title = "UserEmpGrpDetails";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("empGroupList", empGroupList);
		return new ModelAndView("index", "map", map);
	}
	 	

 	
	@SuppressWarnings("unchecked")
	   public ModelAndView generateUserDepartmentReport(HttpServletRequest request, HttpServletResponse response)
	   {
	     
	      int deptId = 0;
	      int hospitalId =0;
	      String query = "";
	      HttpSession session=request.getSession();

	      try
	      {
	           if (request.getParameter(RequestConstants.DEPARTMENT_ID) != null
	               && !(request.getParameter(RequestConstants.DEPARTMENT_ID).equals("0")))
	         {
	            deptId = Integer.parseInt(request.getParameter(RequestConstants.DEPARTMENT_ID));
	           // query = query + " AND work_load_entry_detail.department_id = " + deptId;
	         }
	           if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null)
	           {
	              hospitalId = (Integer) session.getAttribute(RequestConstants.HOSPITAL_ID);
	           }
	      } catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      Map<String, Object> detailsMap = new HashMap<String, Object>();
	      detailsMap = superAdminMasterHandlerService.getConnectionForReport();
	      Map<String, Object> parameters = new HashMap<String, Object>();
	     
	      parameters.put("department_id", deptId);
	      parameters.put("hosptial_id", hospitalId);
	     
	      try
	      {

	         HMSUtil.generateReport("User_department_rep", parameters, (Connection) detailsMap
	               .get("conn"), response, getServletContext());

	      } catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return null;
	   }

	
	@SuppressWarnings("unchecked")
	   public ModelAndView generateEmpGrpDetailsRep(HttpServletRequest request, HttpServletResponse response)
	   {
	     
	      int empGrList = 0;
	      int hospitalId =0;
	      String query = "";
	      HttpSession session=request.getSession();

	      try
	      {
	           if (request.getParameter(RequestConstants.EMPLOYEE_GROUP_ID) != null
	               && !(request.getParameter(RequestConstants.EMPLOYEE_GROUP_ID).equals("0")))
	         {
	            empGrList = Integer.parseInt(request.getParameter(RequestConstants.EMPLOYEE_GROUP_ID));
	           // query = query + " AND work_load_entry_detail.department_id = " + deptId;
	         }
	           
	      } catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      Map<String, Object> detailsMap = new HashMap<String, Object>();
	      detailsMap = superAdminMasterHandlerService.getConnectionForReport();
	      Map<String, Object> parameters = new HashMap<String, Object>();
	     
	      parameters.put("emp_group_id", empGrList);	     
	      try
	      {

	         HMSUtil.generateReport("User_emp_group_rep", parameters, (Connection) detailsMap
	               .get("conn"), response, getServletContext());

	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return null;
	   }

	public SuperAdminMasterHandlerService getSuperAdminMasterHandlerService() {
		return superAdminMasterHandlerService;
	}

	public void setSuperAdminMasterHandlerService(
			SuperAdminMasterHandlerService superAdminMasterHandlerService) {
		this.superAdminMasterHandlerService = superAdminMasterHandlerService;
	}

}
