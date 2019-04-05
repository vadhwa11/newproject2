package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.COMBO_NAME;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.JSP_NAME;
import static jkt.hms.util.RequestConstants.POJO_NAME;
import static jkt.hms.util.RequestConstants.POJO_PROPERTY_ADDRESS;
import static jkt.hms.util.RequestConstants.POJO_PROPERTY_NAME;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.VIEW_PAGE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.handler.CommonMasterHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CommonMasterController extends MultiActionController {
	CommonMasterHandlerService commonMasterHandlerService = null;
	BreadCrumbMaster breadCrumbMaster;
	String jsp = "";
	String title = "";
	String message = "";
	String viewPage = "";
	String url = "";
	String code = "";
	String name = "";
	String jspName = "";
	String errorMessageForExistence = "";
	String updateJspName = "";
	String deleteJspName = "";
	String pojoPropertyName = "";
	String pojoPropertyAddress = "";
	String pojoPropertyCode = "";
	String pojoName = "";

	// -----------------General Methods for All Masters By Deepti
	// Tevatia-----------------------------

	public ModelAndView showMainJsp(HttpServletRequest request,
			HttpServletResponse response) {

		// --------------------- BreadCrumb by Dipali and Mansi
		// ---------------------------

		// Map breadCrumbMap =
		// breadCrumbMaster.showInsidePageWithAppIdOnly(request);

		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter(JSP_NAME) != null) {
			jspName = request.getParameter(JSP_NAME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		// --------------------Condition is for fetching values from related
		// table------------------------------------

		// HttpSession session =request.getSession();
		if (request.getParameter(COMBO_NAME) != null) {

			String masterName = request.getParameter(COMBO_NAME);
			masterName = masterName.trim();
			List comboValueList = commonMasterHandlerService
					.getAllMasterRecords(masterName);
			masterName = masterName.toLowerCase() + "List";
			// session.setAttribute("comboValueList",comboValueList);
			map.put(masterName, comboValueList);

		}

		jspName += ".jsp";
		map.put("contentJsp", jspName);
		// map.put("breadCrumbMap", breadCrumbMap);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------showHome BreadCrumb by Dipali and Mansi
	// ---------------------------
	public ModelAndView showHome(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "index";
		title = "Home Page";
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	// --------------------- End showHome BreadCrumb
	// --------------------------------------------------

	public ModelAndView showUpdateMasters(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mastersEnquiryMap = new HashMap<String, Object>();
		String status = "";
		HttpSession session = request.getSession(false);
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(POJO_NAME) != null) {
			pojoName = request.getParameter(POJO_NAME);
		}
		if (request.getParameter(POJO_PROPERTY_NAME) != null) {
			pojoPropertyName = request.getParameter(POJO_PROPERTY_NAME);
		}
		if (request.getParameter(POJO_PROPERTY_ADDRESS) != null) {
			pojoPropertyAddress = request.getParameter(POJO_PROPERTY_ADDRESS);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("jspName") != null) {
			jspName = request.getParameter("jspName");
		}
		if (request.getParameter("updateJspName") != null) {
			updateJspName = request.getParameter("updateJspName");
		}
		mastersEnquiryMap.put("name", name);
		mastersEnquiryMap.put("pojoName", pojoName);
		mastersEnquiryMap.put("pojoPropertyName", pojoPropertyName);
		mastersEnquiryMap.put("pojoPropertyAddress", pojoPropertyAddress);

		List listByMastersName = commonMasterHandlerService
				.getMastersListByName(mastersEnquiryMap, status);
		if (listByMastersName.size() <= 0) {
			jspName += ".jsp";
			map.put("contentJsp", jspName);
			errorMessageForExistence = "No Records found";
			map.put("errorMessageForExistence", errorMessageForExistence);
			return new ModelAndView("index", "map", map);

		} else if (listByMastersName.equals("")) {
			jspName += ".jsp";
			map.put("contentJsp", jspName);
			errorMessageForExistence = "Please Select One ! ";
			map.put("errorMessageForExistence", errorMessageForExistence);
			return new ModelAndView("index", "map", map);

		}
		if (request.getParameter(COMBO_NAME) != null) {
			String masterName = request.getParameter(COMBO_NAME);
			masterName = masterName.trim();
			List comboValueList = commonMasterHandlerService
					.getAllMasterRecords(masterName);
			masterName = masterName.toLowerCase() + "List";
			map.put(masterName, comboValueList);

		}

		session.setAttribute("name", name);

		jsp = updateJspName + ".jsp";
		map.put("contentJsp", jsp);
		title = "Update " + title;
		map.put("title", title);
		map.put("listByMastersName", listByMastersName);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDeleteMasters(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mastersEnquiryMap = new HashMap<String, Object>();
		String name = "";
		String status = "y";
		HttpSession session = request.getSession();

		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(POJO_NAME) != null) {
			pojoName = request.getParameter(POJO_NAME);
		}
		if (request.getParameter(POJO_PROPERTY_NAME) != null) {
			pojoPropertyName = request.getParameter(POJO_PROPERTY_NAME);
		}
		if (request.getParameter(POJO_PROPERTY_ADDRESS) != null) {
			pojoPropertyAddress = request.getParameter(POJO_PROPERTY_ADDRESS);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("jspName") != null) {
			jspName = request.getParameter("jspName");
		}
		if (request.getParameter("deleteJspName") != null) {
			deleteJspName = request.getParameter("deleteJspName");
		}
		mastersEnquiryMap.put("name", name);
		mastersEnquiryMap.put("pojoName", pojoName);
		mastersEnquiryMap.put("pojoPropertyName", pojoPropertyName);
		mastersEnquiryMap.put("pojoPropertyAddress", pojoPropertyAddress);
		List listByMastersName = commonMasterHandlerService
				.getMastersListByName(mastersEnquiryMap, status);

		if (listByMastersName.size() <= 0) {
			jspName += ".jsp";
			map.put("contentJsp", jspName);
			errorMessageForExistence = "No Records found";
			map.put("errorMessageForExistence", errorMessageForExistence);
			return new ModelAndView("index", "map", map);

		} else if (listByMastersName.equals("")) {
			jspName += ".jsp";
			map.put("contentJsp", jspName);
			errorMessageForExistence = "Please Select One ! ";
			map.put("errorMessageForExistence", errorMessageForExistence);
			return new ModelAndView("index", "map", map);
		}

		session.setAttribute("name", name);
		jsp = deleteJspName + ".jsp";
		;
		title = "Delete " + title;
		map.put("contentJsp", jsp);

		map.put("title", title);
		map.put("listByMastersName", listByMastersName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getMastersInformationOnChange(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mastersEnquiryMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		String status = "y";

		int id = 0;

		if (request.getParameter(COMMON_ID) != null) {
			id = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(POJO_NAME) != null) {
			pojoName = request.getParameter(POJO_NAME);
		}
		if (request.getParameter(POJO_PROPERTY_NAME) != null) {
			pojoPropertyName = request.getParameter(POJO_PROPERTY_NAME);
		}
		if (request.getParameter(POJO_PROPERTY_ADDRESS) != null) {
			pojoPropertyAddress = request.getParameter(POJO_PROPERTY_ADDRESS);
		}
		generalMap.put("id", id);
		generalMap.put("pojoName", pojoName);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyAddress", pojoPropertyAddress);
		List onChangeMastersList = commonMasterHandlerService
				.getMastersInformationOnChange(generalMap);

		if (request.getParameter("jspName") != null) {
			jsp = request.getParameter("jspName");
		}

		if (session.getAttribute("name") != null) {
			name = (String) session.getAttribute("name");
		}

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		mastersEnquiryMap.put("name", name);
		mastersEnquiryMap.put("pojoName", pojoName);
		mastersEnquiryMap.put("pojoPropertyName", pojoPropertyName);
		mastersEnquiryMap.put("pojoPropertyAddress", pojoPropertyAddress);
		List listByMastersName = commonMasterHandlerService
				.getMastersListByName(mastersEnquiryMap, status);

		map.put("name", name);
		map.put("onChangeMastersList", onChangeMastersList);
		map.put("listByMastersName", listByMastersName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEnquiryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String min = "0";
		String max = "4";
		String searchName = "";
		String nextState = "enable";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		HttpSession session = request.getSession(false);

		if (request.getParameter(VIEW_PAGE) != null) {
			viewPage = request.getParameter(VIEW_PAGE);
		}
		if (request.getParameter(POJO_NAME) != null) {
			pojoName = request.getParameter(POJO_NAME);
		}
		if (request.getParameter(POJO_PROPERTY_NAME) != null) {
			pojoPropertyName = request.getParameter(POJO_PROPERTY_NAME);
		}

		if (request.getParameter(POJO_PROPERTY_ADDRESS) != null) {
			pojoPropertyAddress = request.getParameter(POJO_PROPERTY_ADDRESS);
		}

		searchName = request.getParameter(SEARCH_NAME);
		session.setAttribute("searchName", searchName);

		mapForDs.put("pojoName", pojoName);
		mapForDs.put("pojoPropertyName", pojoPropertyName);
		mapForDs.put("pojoPropertyAddress", pojoPropertyAddress);
		mapForDs.put("searchName", searchName);

		List enquiryList = new ArrayList();

		enquiryList = (List) commonMasterHandlerService
				.getTableRecords(mapForDs);
		int sizeOfList = enquiryList.size();

		if ((sizeOfList <= 5)) {
			nextState = "disable";
		}

		viewPage += ".jsp";
		map.put("contentJsp", viewPage);
		map.put("nextState", nextState);
		map.put("enquiryList", enquiryList);
		map.put("min", min);
		map.put("max", max);

		return new ModelAndView("index", "map", map);

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

		if (request.getParameter(VIEW_PAGE) != null)
			viewPage = request.getParameter(VIEW_PAGE);

		if (request.getParameter(POJO_NAME) != null) {
			pojoName = request.getParameter(POJO_NAME);
		}
		if (request.getParameter(POJO_PROPERTY_NAME) != null) {
			pojoPropertyName = request.getParameter(POJO_PROPERTY_NAME);
		}
		if (request.getParameter(POJO_PROPERTY_ADDRESS) != null) {
			pojoPropertyAddress = request.getParameter(POJO_PROPERTY_ADDRESS);
		}

		searchName = (String) session.getAttribute("searchName");

		mapForDs.put("pojoName", pojoName);
		mapForDs.put("pojoPropertyName", pojoPropertyName);
		mapForDs.put("pojoPropertyAddress", pojoPropertyAddress);
		mapForDs.put("searchName", searchName);

		int temp1 = Integer.parseInt(x);
		int temp2 = Integer.parseInt(y);
		temp1 = temp1 + 5;
		temp2 = temp2 + 5;

		Map<String, Object> map = new HashMap<String, Object>();
		List enquiryList = new ArrayList();

		enquiryList = (List) commonMasterHandlerService
				.getTableRecords(mapForDs);

		int sizeOfList = enquiryList.size();

		if ((temp2 + 1 >= sizeOfList)) {
			nextState = "disable";
		}

		viewPage += ".jsp";
		map.put("contentJsp", viewPage);

		min = temp1 + "";
		max = temp2 + "";
		map.put("enquiryList", enquiryList);
		map.put("min", min);
		map.put("max", max);
		map.put("nextState", nextState);
		map.put("previousState", previousState);
		return new ModelAndView("index", "map", map);

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

		if (request.getParameter(VIEW_PAGE) != null)
			viewPage = request.getParameter(VIEW_PAGE);

		if (request.getParameter(POJO_NAME) != null) {
			pojoName = request.getParameter(POJO_NAME);
		}
		if (request.getParameter(POJO_PROPERTY_NAME) != null) {
			pojoPropertyName = request.getParameter(POJO_PROPERTY_NAME);
		}

		if (request.getParameter(POJO_PROPERTY_ADDRESS) != null) {
			pojoPropertyAddress = request.getParameter(POJO_PROPERTY_ADDRESS);
		}
		searchName = (String) session.getAttribute("searchName");

		mapForDs.put("pojoName", pojoName);
		mapForDs.put("pojoPropertyName", pojoPropertyName);
		mapForDs.put("pojoPropertyAddress", pojoPropertyAddress);
		mapForDs.put("searchName", searchName);

		int temp1 = Integer.parseInt(x);
		int temp2 = Integer.parseInt(y);
		temp1 = temp1 - 5;
		temp2 = temp2 - 5;

		Map<String, Object> map = new HashMap<String, Object>();
		List enquiryList = new ArrayList();

		enquiryList = (List) commonMasterHandlerService
				.getTableRecords(mapForDs);

		if ((temp1 <= 0)) {
			previousState = "disable";
		} else
			previousState = "enable";

		viewPage += ".jsp";
		map.put("contentJsp", viewPage);

		min = temp1 + "";
		max = temp2 + "";
		map.put("enquiryList", enquiryList);
		map.put("min", min);
		map.put("max", max);
		map.put("nextState", nextState);
		map.put("previousState", previousState);
		return new ModelAndView("index", "map", map);

	}

	/*
	 * private Master fetchCommonValuesFromForm(HttpServletRequest request,
	 * Map<String, Object> generalMap) {
	 * 
	 * Master master = new Master(); if(request.getParameter(CODE) != null){
	 * master.setCode(request.getParameter(CODE)); }
	 * if(request.getParameter(SEARCH_NAME) != null){
	 * master.setName(request.getParameter(SEARCH_NAME)); }
	 * if(request.getParameter(STATUS) != null){
	 * master.setStatus(Integer.parseInt(request.getParameter(STATUS))); }
	 * 
	 * if(request.getParameter(CHANGED_DATE) != null){
	 * master.setChangedDate(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null){
	 * master.setChangedTime(request.getParameter(CHANGED_TIME)); }
	 * 
	 * return master; }
	 */

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public BreadCrumbMaster getBreadCrumbMaster() {
		return breadCrumbMaster;
	}

	public void setBreadCrumbMaster(BreadCrumbMaster breadCrumbMaster) {
		this.breadCrumbMaster = breadCrumbMaster;
	}

}