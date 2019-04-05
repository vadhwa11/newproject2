package jkt.hms.accomodation.controller;

import static jkt.hms.util.RequestConstants.ALLOTMENT_FOR_AIRMEN;
import static jkt.hms.util.RequestConstants.ALLOTMENT_FOR_OFFICER;
import static jkt.hms.util.RequestConstants.ALLOTMENT_ID;
import static jkt.hms.util.RequestConstants.ALLOTMENT_NO;
import static jkt.hms.util.RequestConstants.ANTE_DATE;
import static jkt.hms.util.RequestConstants.ANTI_DATE_REMARKS;
import static jkt.hms.util.RequestConstants.ANTI_DATE_SENIORITY;
import static jkt.hms.util.RequestConstants.AUTHORISATION;
import static jkt.hms.util.RequestConstants.CAR_GARAGE_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DATE_OF_AME;
import static jkt.hms.util.RequestConstants.DATE_OF_REPORTING;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.LOCATION_ID;
import static jkt.hms.util.RequestConstants.LOCATION_MASTER_JSP;
import static jkt.hms.util.RequestConstants.NOC;
import static jkt.hms.util.RequestConstants.POOL_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.POOL_CATEGORY_JSP;
import static jkt.hms.util.RequestConstants.POOL_ID;
import static jkt.hms.util.RequestConstants.POOL_JSP;
import static jkt.hms.util.RequestConstants.POSTED_DATE;
import static jkt.hms.util.RequestConstants.POSTING_DATE;
import static jkt.hms.util.RequestConstants.PREVIOUS_SMQ;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.REGISTRATION_DATE;
import static jkt.hms.util.RequestConstants.REGISTRATION_FOR_AIRMEN;
import static jkt.hms.util.RequestConstants.REGISTRATION_FOR_OFFICER;
import static jkt.hms.util.RequestConstants.REGISTRATION_NO;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SEARCH_RELEAGTION_PROCESS;
import static jkt.hms.util.RequestConstants.SEARCH_SMQ_VACATION_AIRMEN;
import static jkt.hms.util.RequestConstants.SEARCH_SMQ_VACATION_OFFICER;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_PERSON_NAME;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.SFX;
import static jkt.hms.util.RequestConstants.SMQ_ID;
import static jkt.hms.util.RequestConstants.SMQ_JSP;
import static jkt.hms.util.RequestConstants.SMQ_STATUS;
import static jkt.hms.util.RequestConstants.SMQ_TYPE;
import static jkt.hms.util.RequestConstants.SMQ_VACATION_AIRMEN;
import static jkt.hms.util.RequestConstants.SMQ_VACATION_OFFICER;
import static jkt.hms.util.RequestConstants.S_FIRST_NAME;
import static jkt.hms.util.RequestConstants.TIME;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.TYPE_OF_RECEIVE;
import static jkt.hms.util.RequestConstants.UNIT;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.VACATION_ID;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.accomodation.handler.AccomodationHandlerService;
import jkt.hms.masters.business.AccomAllotment;
import jkt.hms.masters.business.AccomRegistration;
import jkt.hms.masters.business.MasCarGarage;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLocation;
import jkt.hms.masters.business.MasPool;
import jkt.hms.masters.business.MasPoolCategory;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasSmq;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AccomodationController extends MultiActionController {
	// -------------------------------------------------------------------------------------------------------------//
	AccomodationHandlerService accomodationHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public AccomodationHandlerService getAccomodationHandlerService() {
		return accomodationHandlerService;
	}

	public void setAccomodationHandlerService(
			AccomodationHandlerService accomodationHandlerService) {
		this.accomodationHandlerService = accomodationHandlerService;
	}

	// -------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------general-----------------------------------------------------------//
	HttpSession session = null;
	String jsp = "";
	String message = "";
	String title = "";
	String code = "";
	String name = "";
	String currentDate = "";
	String currentTime = "";
	String changedBy = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String url = "";
	String reportMsg = "";
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();

	// ------------------------------------------general----------------------------------------------------------//

	/**
	 * ------------------------------------------- method to show Pool Category
	 * ------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showPoolCategoryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = accomodationHandlerService.showPoolCategory();
		jsp = POOL_CATEGORY_JSP;
		jsp += ".jsp";
		title = "Pool Category";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------------------------method to add Pool category
	 * --------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView addPoolCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasPoolCategory masPoolCategory = new MasPoolCategory();
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

		List poolCatCodeList = new ArrayList();
		List poolCatNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			poolCatCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			poolCatNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((poolCatCodeList.size() == 0 || poolCatCodeList == null)
				&& (poolCatNameList.size() == 0 || poolCatNameList == null)) {
			masPoolCategory.setPoolCategoryCode(code);
			masPoolCategory.setPoolCategoryName(name);
			masPoolCategory.setStatus("y");
			masPoolCategory.setLastChgBy(changedBy);
			masPoolCategory.setLastChgDate(currentDate);
			masPoolCategory.setLastChgTime(currentTime);
			successfullyAdded = accomodationHandlerService
					.addPoolCategory(masPoolCategory);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((poolCatCodeList.size() != 0 || poolCatCodeList != null)
				|| (poolCatNameList.size() != 0) || poolCatNameList != null) {
			if ((poolCatCodeList.size() != 0 || poolCatCodeList != null)
					&& (poolCatNameList.size() == 0 || poolCatNameList == null)) {

				message = "Pool Category Code  already exists.";
			} else if ((poolCatNameList.size() != 0 || poolCatNameList != null)
					&& (poolCatCodeList.size() == 0 || poolCatCodeList == null)) {

				message = "Pool Category Name already exists.";
			} else if ((poolCatCodeList.size() != 0 || poolCatCodeList != null)
					&& (poolCatNameList.size() != 0 || poolCatNameList != null)) {

				message = "Pool Category Code and Pool Category Name already exist.";
			}
		}

		try {
			map = accomodationHandlerService.showPoolCategory();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = POOL_CATEGORY_JSP;
		title = "Add Pool Category";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- method to edit Pool Category
	 * -----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView editPoolToCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String poolCategoryCode = "";
		String poolCategoryName = "";
		int poolCategoryId = 0;
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			poolCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			poolCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			poolCategoryName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", poolCategoryId);
		generalMap.put("poolCategoryCode", poolCategoryCode);
		generalMap.put("name", poolCategoryName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List<MasPoolCategory> existingPoolCategoryNameList = (List<MasPoolCategory>) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingPoolCategoryNameList.size() == 0) {
			dataUpdated = accomodationHandlerService
					.editPoolToCategory(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingPoolCategoryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/accom?method=showPoolCategoryJsp";

		try {
			map = accomodationHandlerService.showPoolCategory();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = POOL_CATEGORY_JSP;
		title = "update Pool Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------ method to delete Pool Category
	 * ----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView deletePoolCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int poolCategoryId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			poolCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = accomodationHandlerService.deletePoolCategory(
				poolCategoryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/accom?method=showPoolCategoryJsp";

		try {
			map = accomodationHandlerService.showPoolCategory();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = POOL_CATEGORY_JSP;
		title = "delete Pool Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- method to Search Pool Category
	 * -----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchPoolCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String poolCategoryCode = null;
		String poolCategoryName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			poolCategoryCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			poolCategoryName = request.getParameter(SEARCH_NAME);
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
			poolCategoryCode = searchField;
			poolCategoryName = null;

		} else {
			poolCategoryCode = null;
			poolCategoryName = searchField;
		}
		map = accomodationHandlerService.searchPoolCategory(poolCategoryCode,
				poolCategoryName);

		jsp = POOL_CATEGORY_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("poolCategoryCode", poolCategoryCode);
		map.put("poolCategoryName", poolCategoryName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------- method to show Location Master
	 * -----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showLocationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = accomodationHandlerService.showLocationJsp();
		String jsp = LOCATION_MASTER_JSP;
		jsp += ".jsp";
		title = "Location Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------------------- method to add Location master
	 * -------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView addLocation(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasLocation masLocation = new MasLocation();
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

		List locationCodeList = new ArrayList();
		List locationNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			locationCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			locationNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((locationCodeList.size() == 0 || locationCodeList == null)
				&& (locationNameList.size() == 0 || locationNameList == null)) {
			masLocation.setLocationCode(code);
			masLocation.setLocationName(name);
			masLocation.setStatus("y");
			masLocation.setLastChgBy(changedBy);
			masLocation.setLastChgDate(currentDate);
			masLocation.setLastChgTime(currentTime);
			successfullyAdded = accomodationHandlerService
					.addLocation(masLocation);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((locationCodeList.size() != 0 || locationCodeList != null)
				|| (locationNameList.size() != 0) || locationNameList != null) {
			if ((locationCodeList.size() != 0 || locationCodeList != null)
					&& (locationNameList.size() == 0 || locationNameList == null)) {

				message = "Location Code  already exists.";
			} else if ((locationNameList.size() != 0 || locationNameList != null)
					&& (locationCodeList.size() == 0 || locationCodeList == null)) {

				message = "Location Name already exists.";
			} else if ((locationCodeList.size() != 0 || locationCodeList != null)
					&& (locationNameList.size() != 0 || locationNameList != null)) {

				message = "Location Code and Location Name already exist.";
			}
		}

		try {
			map = accomodationHandlerService.showLocationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = LOCATION_MASTER_JSP;
		title = "Add Location";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------------- method to edit Location Master
	 * -----------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView editLocation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String locationCode = "";
		String locationName = "";
		int locationId = 0;
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			locationId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			locationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			locationName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", locationId);
		generalMap.put("locationCode", locationCode);
		generalMap.put("name", locationName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingLocationNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingLocationNameList.size() == 0) {
			dataUpdated = accomodationHandlerService.editLocation(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingLocationNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/accom?method=showLocationJsp";

		try {
			map = accomodationHandlerService.showLocationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = LOCATION_MASTER_JSP;
		title = "update Location";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------------- method to delete Location
	 * -----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView deleteLocation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int locationId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			locationId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = accomodationHandlerService.deleteLocation(locationId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/accom?method=showLocationJsp";

		try {
			map = accomodationHandlerService.showLocationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = LOCATION_MASTER_JSP;
		title = "delete Location";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------------- method to search Location
	 * -------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchLocation(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String locationCode = null;
		String locationName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			locationCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			locationName = request.getParameter(SEARCH_NAME);
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
			locationCode = searchField;
			locationName = null;

		} else {
			locationCode = null;
			locationName = searchField;
		}
		map = accomodationHandlerService.searchLocation(locationCode,
				locationName);
		jsp = LOCATION_MASTER_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("locationCode", locationCode);
		map.put("locationName", locationName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------------- method to show Car Garage
	 * ------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showCarGarageJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = accomodationHandlerService.showCarGarage();
		jsp = CAR_GARAGE_JSP;
		jsp += ".jsp";
		title = "Car Garage";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------------------------method to add Car Garage
	 * --------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView addCarGarage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasCarGarage masCarGarage = new MasCarGarage();
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

		List carGarageCodeList = new ArrayList();
		List carGarageNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			carGarageCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			carGarageNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((carGarageCodeList.size() == 0 || carGarageCodeList == null)
				&& (carGarageNameList.size() == 0 || carGarageNameList == null)) {
			masCarGarage.setCarGarageCode(code);
			masCarGarage.setCarGarageName(name);
			masCarGarage.setStatus("y");
			masCarGarage.setLastChgBy(changedBy);
			masCarGarage.setLastChgDate(currentDate);
			masCarGarage.setLastChgTime(currentTime);
			successfullyAdded = accomodationHandlerService
					.addCarGarage(masCarGarage);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((carGarageCodeList.size() != 0 || carGarageCodeList != null)
				|| (carGarageNameList.size() != 0) || carGarageNameList != null) {
			if ((carGarageCodeList.size() != 0 || carGarageCodeList != null)
					&& (carGarageNameList.size() == 0 || carGarageNameList == null)) {

				message = "Car Garage Code  already exists.";
			} else if ((carGarageNameList.size() != 0 || carGarageNameList != null)
					&& (carGarageCodeList.size() == 0 || carGarageCodeList == null)) {

				message = "Car Garage Name already exists.";
			} else if ((carGarageCodeList.size() != 0 || carGarageCodeList != null)
					&& (carGarageNameList.size() != 0 || carGarageNameList != null)) {

				message = "Car Garage Code and Car Garage Name already exist.";
			}
		}

		try {
			map = accomodationHandlerService.showCarGarage();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CAR_GARAGE_JSP;
		title = "Add Car Garage";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- method to edit Car Garage
	 * -----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView editCarGarage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String carGarageCode = "";
		String carGarageName = "";
		int carGarageId = 0;
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			carGarageId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			carGarageCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			carGarageName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", carGarageId);
		generalMap.put("poolCategoryCode", carGarageCode);
		generalMap.put("name", carGarageName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List<MasCarGarage> existingCarGarageNameList = (List<MasCarGarage>) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCarGarageNameList.size() == 0) {
			dataUpdated = accomodationHandlerService.editCarGarage(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCarGarageNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/accom?method=showCarGarageJsp";

		try {
			map = accomodationHandlerService.showCarGarage();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CAR_GARAGE_JSP;
		title = "update Car Garage";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------ method to delete Pool Category
	 * ----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView deleteCarGarage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int carGarageId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			carGarageId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = accomodationHandlerService.deleteCarGarage(carGarageId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/accom?method=showCarGarageJsp";

		try {
			map = accomodationHandlerService.showCarGarage();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CAR_GARAGE_JSP;
		title = "delete Car Garage";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- method to Search Pool Category
	 * -----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchCarGarage(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String carGarageCode = null;
		String carGarageName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			carGarageCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			carGarageName = request.getParameter(SEARCH_NAME);
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
			carGarageCode = searchField;
			carGarageName = null;

		} else {
			carGarageCode = null;
			carGarageName = searchField;
		}
		map = accomodationHandlerService.searchCarGarage(carGarageCode,
				carGarageName);

		jsp = CAR_GARAGE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("carGarageCode", carGarageCode);
		map.put("carGarageName", carGarageName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- method to show Pool Master
	 * ----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showPoolMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = accomodationHandlerService.showPoolJsp();
		jsp = POOL_JSP;
		jsp += ".jsp";
		title = "Pool Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * -------------------------------------- method to add Pool Master
	 * -----------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView addPool(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int poolCategoryId = 0;
		int authorisation = 0;
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

		if (request.getParameter(AUTHORISATION) != null
				&& !(request.getParameter(AUTHORISATION).equals(""))) {
			authorisation = Integer.parseInt(request
					.getParameter(AUTHORISATION));
		}
		if (request.getParameter(POOL_CATEGORY_ID) != null) {
			poolCategoryId = Integer.parseInt(request
					.getParameter(POOL_CATEGORY_ID));
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

		List poolCodeList = new ArrayList();
		List poolNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			poolCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			poolNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		if ((poolCodeList.size() == 0 || poolCodeList == null)
				&& (poolNameList.size() == 0 || poolNameList == null)) {
			dataMap.put("code", code);
			dataMap.put("name", name);
			dataMap.put("status", "y");
			dataMap.put("authorisation", authorisation);
			dataMap.put("poolCategoryId", poolCategoryId);
			dataMap.put("changedBy", changedBy);
			dataMap.put("currentDate", currentDate);
			dataMap.put("currentTime", currentTime);
			Box box = HMSUtil.getBox(request);
			dataMap.put("box", box);
			map = accomodationHandlerService.addPool(dataMap);
			saved = (Boolean) map.get("saved");
			if (saved == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((poolCodeList.size() != 0 || poolCodeList != null)
				|| (poolNameList.size() != 0) || poolNameList != null) {
			if ((poolCodeList.size() != 0 || poolCodeList != null)
					&& (poolNameList.size() == 0 || poolNameList == null)) {

				message = "Pool Code  already exists.";
			} else if ((poolNameList.size() != 0 || poolNameList != null)
					&& (poolCodeList.size() == 0 || poolCodeList == null)) {

				message = "Pool Name already exists.";
			} else if ((poolCodeList.size() != 0 || poolCodeList != null)
					&& (poolNameList.size() != 0 || poolNameList != null)) {

				message = "Pool Code and Pool Name already exist.";
			}

		}
		try {
			map = accomodationHandlerService.showPoolJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = POOL_JSP;
		title = "Add Pool";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -----------------------------------method to edit pool
	 * master---------------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView editPool(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int poolCategoryId = 0;
		int authorisation = 0;
		int poolId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			poolId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
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

		if (request.getParameter(AUTHORISATION) != null
				&& !(request.getParameter(AUTHORISATION).equals(""))) {
			authorisation = Integer.parseInt(request
					.getParameter(AUTHORISATION));
		}
		if (request.getParameter(POOL_CATEGORY_ID) != null) {
			poolCategoryId = Integer.parseInt(request
					.getParameter(POOL_CATEGORY_ID));
		}

		String[] rankIdArray = null;
		StringBuffer rankStr = new StringBuffer();

		if (request.getParameterValues(RANK_ID) != null
				&& request.getParameterValues(RANK_ID).length > 0) {
			rankIdArray = (String[]) (request.getParameterValues(RANK_ID));

			for (int i = 0; i < rankIdArray.length; i++) {
				rankStr.append(rankIdArray[i]);
				rankStr.append(",");
			}
			rankStr.deleteCharAt(rankStr.length() - 1);
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
		generalMap.put("poolCategoryId", poolCategoryId);
		generalMap.put("authorisation", authorisation);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("poolId", poolId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("rankStr", rankStr.toString());

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List<MasPoolCategory> existingPoolList = (List<MasPoolCategory>) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingPoolList.size() == 0) {
			dataUpdated = accomodationHandlerService.editPool(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingPoolList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/accom?method=showPoolJsp";

		try {
			map = accomodationHandlerService.showPoolJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = POOL_JSP;
		title = "update Pool";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------- method to search pool Master
	 * ---------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchPool(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String poolCode = null;
		String poolName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			poolCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			poolName = request.getParameter(SEARCH_NAME);
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
			poolCode = searchField;
			poolName = null;

		} else {
			poolCode = null;
			poolName = searchField;
		}
		map = accomodationHandlerService.searchPool(poolCode, poolName);

		jsp = POOL_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("poolCode", poolCode);
		map.put("poolName", poolName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------------------- method to show SMQ Master
	 * ------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showSMQJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = accomodationHandlerService.showSMQJsp();
		jsp = SMQ_JSP;
		jsp += ".jsp";
		title = "SMQ Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------------------------- method to delete POOL
	 * Master------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView deletePool(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int poolId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			poolId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = accomodationHandlerService.deletePool(poolId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/accom?method=showPoolMasterJsp";

		try {
			map = accomodationHandlerService.showPoolJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = POOL_JSP;
		title = "delete Pool Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------method to add SMQ
	 * Master------------------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView addSmqMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasSmq masSmq = new MasSmq();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int poolCategoryId = 0;
		int poolId = 0;
		int locationId = 0;
		String smqStatus = "";
		String smqType = "";
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

		if (request.getParameter(SMQ_STATUS) != null
				&& !(request.getParameter(SMQ_STATUS).equals(""))) {
			smqStatus = request.getParameter(SMQ_STATUS);
		}
		if (request.getParameter(SMQ_TYPE) != null
				&& !(request.getParameter(SMQ_TYPE).equals(""))) {
			smqType = request.getParameter(SMQ_TYPE);
		}
		if (request.getParameter(POOL_CATEGORY_ID) != null) {
			poolCategoryId = Integer.parseInt(request
					.getParameter(POOL_CATEGORY_ID));
		}
		if (request.getParameter(LOCATION_ID) != null) {
			locationId = Integer.parseInt(request.getParameter(LOCATION_ID));
		}
		if (request.getParameter(POOL_ID) != null) {
			poolId = Integer.parseInt(request.getParameter(POOL_ID));
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

		List smqCodeList = new ArrayList();
		List smqNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			smqCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			smqNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((smqCodeList.size() == 0 || smqCodeList == null)
				&& (smqNameList.size() == 0 || smqNameList == null)) {
			masSmq.setSmqCode(code);
			masSmq.setSmqName(name);
			masSmq.setStatus("y");
			MasPool masPool = new MasPool();
			masPool.setId(poolId);
			masSmq.setPool(masPool);
			MasLocation masLocation = new MasLocation();
			masLocation.setId(locationId);
			masSmq.setLocation(masLocation);
			masSmq.setSmqStatus(smqStatus);
			masSmq.setSmqType(smqType);
			MasPoolCategory masPoolCategory = new MasPoolCategory();
			masPoolCategory.setId(poolCategoryId);
			masSmq.setPoolCategory(masPoolCategory);
			masSmq.setLastChgBy(changedBy);
			masSmq.setLastChgDate(currentDate);
			masSmq.setLastChgTime(currentTime);
			successfullyAdded = accomodationHandlerService.addSmqMaster(masSmq);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((smqCodeList.size() != 0 || smqCodeList != null)
				|| (smqNameList.size() != 0) || smqNameList != null) {
			if ((smqCodeList.size() != 0 || smqCodeList != null)
					&& (smqNameList.size() == 0 || smqNameList == null)) {

				message = "SMQ Code  already exists.";
			} else if ((smqNameList.size() != 0 || smqNameList != null)
					&& (smqCodeList.size() == 0 || smqCodeList == null)) {

				message = "SMQ Name already exists.";
			} else if ((smqCodeList.size() != 0 || smqCodeList != null)
					&& (smqNameList.size() != 0 || smqNameList != null)) {

				message = "SMQ Code and SMQ Name already exist.";
			}
		}

		try {
			map = accomodationHandlerService.showSMQJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SMQ_JSP;
		title = "Add SMQ";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------- delete SMQ Master
	 * ------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView deleteSmqMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int smqId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			smqId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = accomodationHandlerService.deleteSmqMaster(smqId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/accom?method=showSMQJsp";

		try {
			map = accomodationHandlerService.showSMQJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SMQ_JSP;
		title = "delete SMQ Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------------------- methdo to search SMQ
	 * -----------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchSmqMaster(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String smqCode = null;
		String smqName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			smqCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			smqName = request.getParameter(SEARCH_NAME);
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
			smqCode = searchField;
			smqName = null;

		} else {
			smqCode = null;
			smqName = searchField;
		}
		map = accomodationHandlerService.searchSmqMaster(smqCode, smqName);

		jsp = SMQ_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("smqCode", smqCode);
		map.put("smqName", smqName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------- method to edit SMQ Master
	 * ---------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView editSMQ(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String smqCode = "";
		String smqName = "";
		String smqType = "";
		String smqStatus = "";
		int locationId = 0;
		int poolCategoryId = 0;
		int poolId = 0;
		int smqId = 0;
		String changedTime = "";
		Date changedDate = null;
		String changedBy = "";

		if (request.getParameter(COMMON_ID) != null
				&& (!request.getParameter(COMMON_ID).equals("0"))) {
			smqId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(LOCATION_ID) != null
				&& (!request.getParameter(LOCATION_ID).equals("0"))) {
			locationId = Integer.parseInt(request.getParameter(LOCATION_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (request.getParameter(POOL_CATEGORY_ID) != null
				&& (!request.getParameter(POOL_CATEGORY_ID).equals("0"))) {
			poolCategoryId = Integer.parseInt(request
					.getParameter(POOL_CATEGORY_ID));
		}
		if (request.getParameter(POOL_ID) != null
				&& (!request.getParameter(POOL_ID).equals("0"))) {
			poolId = Integer.parseInt(request.getParameter(POOL_ID));
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			smqName = (request.getParameter(SEARCH_NAME));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			smqCode = request.getParameter(CODE);
		}
		if (request.getParameter(SMQ_TYPE) != null
				&& !(request.getParameter(SMQ_TYPE).equals(""))) {
			smqType = (request.getParameter(SMQ_TYPE));
		}
		if (request.getParameter(SMQ_STATUS) != null
				&& !(request.getParameter(SMQ_STATUS).equals(""))) {
			smqStatus = (request.getParameter(SMQ_STATUS));
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
		generalMap.put("smqId", smqId);
		generalMap.put("locationId", locationId);
		generalMap.put("poolCategoryId", poolCategoryId);
		generalMap.put("poolId", poolId);
		generalMap.put("smqName", smqName);
		generalMap.put("smqCode", smqCode);
		generalMap.put("smqType", smqType);
		generalMap.put("smqStatus", smqStatus);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List<MasSmq> existingSmqList = (List<MasSmq>) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingSmqList.size() == 0) {
			dataUpdated = accomodationHandlerService.editSMQ(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingSmqList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/accom?method=showSMQJsp";
		try {
			map = accomodationHandlerService.showSMQJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = SMQ_JSP;
		title = "edit SMQ Master";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * --------------------------- method to show accomodation registration for
	 * airmen -------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView registraionForAirmen(HttpServletRequest request,
			HttpServletResponse response) {
		String registrationNo = "";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		map = accomodationHandlerService.registraionForAirmen();
		registrationNo = request.getParameter("registrationNo");
		registrationNo = accomodationHandlerService
				.getRegistrationNumber(registrationNo);
		jsp = REGISTRATION_FOR_AIRMEN;
		jsp += ".jsp";
		title = "Accomodation Registration For Airmen";
		map.put("contentJsp", jsp);
		map.put("title", title);
		if (registrationNo != "") {
			map.put("registrationNo", registrationNo);
		}

		map.put("datamap", datamap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------ method to get Records from Employee Master
	 * for airmen ------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView getRecordsForAirMenReg(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String registrationNo = "";
		int unitId = 0;
		String serviceNo = "";
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if (!request.getParameter(UNIT).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT));
		}
		if (request.getParameter(REGISTRATION_NO) != null
				&& !request.getParameter(REGISTRATION_NO).equals("")) {
			registrationNo = request.getParameter(REGISTRATION_NO);
		}

		box.put("unitId", unitId);
		if (request.getParameter(SERVICE_NO) != null
				&& !request.getParameter(SERVICE_NO).equals("")) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		infoMap = accomodationHandlerService.getRecordsForAirMenReg(box);
		employeeList = (List) infoMap.get("employeeList");

		if (employeeList == null || employeeList.size() == 0) {
			map = accomodationHandlerService.registraionForAirmen();
			map.put("employeeList", employeeList);
			message = serviceNo
					+ " "
					+ "Service No does not exist for Airmen! Please enter service no of Airmen.";
			map.put("message", message);
			jsp = "registrationForAirmen";

		} else {
			map = accomodationHandlerService.registraionForAirmen();
			jsp = "responseForRegAirmen";
		}
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("registrationNo", registrationNo);
		map.put("unitId", unitId);
		map.put("infoMap", infoMap);
		map.put("serviceNo", serviceNo);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------- method to get Recods for Officer Registartion
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView getRecordsForOfficerReg(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String registrationNo = "";
		int unitId = 0;
		String serviceNo = "";
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if (!request.getParameter(UNIT).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT));
		}
		if (request.getParameter(REGISTRATION_NO) != null
				&& !request.getParameter(REGISTRATION_NO).equals("")) {
			registrationNo = request.getParameter(REGISTRATION_NO);
		}

		box.put("unitId", unitId);
		if (request.getParameter(SERVICE_NO) != null
				&& !request.getParameter(SERVICE_NO).equals("")) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		infoMap = accomodationHandlerService.getRecordsForOfficersReg(box);
		employeeList = (List) infoMap.get("employeeList");
		if (employeeList == null || employeeList.size() == 0) {
			map = accomodationHandlerService.registraionForOfficer();
			message = serviceNo + " " + "Service No doesnot exsist.";
			map.put("message", message);
			jsp = "registrationForOfficer";

		} else {
			map = accomodationHandlerService.registraionForOfficer();
			jsp = "responseForRegOfficer";
		}
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("registrationNo", registrationNo);
		map.put("unitId", unitId);
		map.put("infoMap", infoMap);
		map.put("serviceNo", serviceNo);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------- method to add records for
	 * registration of airmen ------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitRegForAirmen(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		AccomRegistration accomReg = new AccomRegistration();
		Date currentDate = new Date();
		int hospitalId = 0;
		int deptId = 0;
		String registrationNo = "";
		Date registrationDate = new Date();
		String registrationTime = "";
		String serviceNo = "";
		String servicePersonName = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int tradeId = 0;
		String sfx = "";
		Date reportingDate = new Date();
		int unitId = 0;
		int poolId = 0;
		String previousSmq = "";
		Date marriageDate = new Date();
		String remarks = "";
		String antiDateRemarks = "";
		Date antiDateSeniority = new Date();
		int unit = 0;

		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
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
		if (request.getParameter(REGISTRATION_NO) != null
				&& !(request.getParameter(REGISTRATION_NO).equals(""))) {
			registrationNo = request.getParameter(REGISTRATION_NO);
		}

		if (request.getParameter(REGISTRATION_DATE) != null
				&& !(request.getParameter(REGISTRATION_DATE).equals(""))) {
			registrationDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(REGISTRATION_DATE));
		}
		if (request.getParameter(TIME) != null
				&& !(request.getParameter(TIME).equals(""))) {
			registrationTime = request.getParameter(TIME);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(SERVICE_PERSON_NAME) != null
				&& !(request.getParameter(SERVICE_PERSON_NAME).equals(""))) {
			servicePersonName = request.getParameter(SERVICE_PERSON_NAME);
		}
		if (request.getParameter(SERVICE_TYPE_ID) != null
				&& (!request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}
		if (request.getParameter(RANK_ID) != null
				&& (!request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		if (request.getParameter(TRADE_ID) != null
				&& (!request.getParameter(TRADE_ID).equals("0"))) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		}
		if (request.getParameter(SFX) != null
				&& !(request.getParameter(SFX).equals(""))) {
			sfx = request.getParameter(SFX);
		}
		if (request.getParameter(DATE_OF_REPORTING) != null
				&& !(request.getParameter(DATE_OF_REPORTING).equals(""))) {
			reportingDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_REPORTING));
		}
		if (request.getParameter(UNIT_ID) != null
				&& (!request.getParameter(UNIT_ID).equals("0"))) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}
		if (request.getParameter(POOL_ID) != null
				&& (!request.getParameter(POOL_ID).equals("0"))) {
			poolId = Integer.parseInt(request.getParameter(POOL_ID));
		}
		if (request.getParameter(PREVIOUS_SMQ) != null
				&& !(request.getParameter(PREVIOUS_SMQ).equals(""))) {
			previousSmq = request.getParameter(PREVIOUS_SMQ);
		}
		if (request.getParameter(DATE_OF_AME) != null
				&& !(request.getParameter(DATE_OF_AME).equals(""))) {
			marriageDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_AME));
		}
		if (request.getParameter(REMARKS) != null
				&& !(request.getParameter(REMARKS).equals(""))) {
			remarks = request.getParameter(REMARKS);
		}
		if (request.getParameter(ANTI_DATE_SENIORITY) != null
				&& !(request.getParameter(ANTI_DATE_SENIORITY).equals(""))) {
			antiDateSeniority = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ANTI_DATE_SENIORITY));
		}
		if (request.getParameter(UNIT) != null
				&& (!request.getParameter(UNIT).equals("0"))) {
			unit = Integer.parseInt(request.getParameter(UNIT));
		}
		if (request.getParameter(ANTI_DATE_REMARKS) != null
				&& !(request.getParameter(ANTI_DATE_REMARKS).equals(""))) {
			antiDateRemarks = request.getParameter(ANTI_DATE_REMARKS);
		}
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("rankId", rankId);
		listMap = accomodationHandlerService
				.checkForExistingServiceNo(generalMap);
		List<AccomRegistration> serviceNoList = new ArrayList<AccomRegistration>();
		if (listMap.get("duplicateServiceNoList") != null) {
			serviceNoList = (List<AccomRegistration>) listMap
					.get("duplicateServiceNoList");
		}
		boolean successfullyAdded = false;
		if (serviceNoList.size() == 0 || serviceNoList == null) {
			accomReg.setRegistrationNo(registrationNo);
			accomReg.setRegistrationDate(registrationDate);
			accomReg.setRegistrationTime(registrationTime);
			accomReg.setServiceNo(serviceNo);
			accomReg.setServicePersonName(servicePersonName);
			if (serviceTypeId != 0) {
				MasServiceType masServiceType = new MasServiceType();
				masServiceType.setId(serviceTypeId);
				accomReg.setServiceType(masServiceType);
			}

			MasRank masRank = new MasRank();
			masRank.setId(rankId);
			accomReg.setRank(masRank);

			if (tradeId != 0) {
				MasTrade masTrade = new MasTrade();
				masTrade.setId(tradeId);
				accomReg.setTrade(masTrade);
			}

			accomReg.setSfx(sfx);
			accomReg.setReportingDate(reportingDate);

			if (unitId != 0) {
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				accomReg.setPreviousUnit(masUnit);
			}

			MasPool masPool = new MasPool();
			masPool.setId(poolId);
			accomReg.setPool(masPool);

			accomReg.setPreviousSmq(previousSmq);
			accomReg.setMarriageDate(marriageDate);
			accomReg.setRemarks(remarks);
			accomReg.setLastChgBy(changedBy);
			accomReg.setLastChgDate(currentDate);
			accomReg.setLastChgTime(currentTime);
			accomReg.setRegType("a");
			accomReg.setRegStatus("n");/*
										 * this is default status NON OCCUPIED
										 * when registration is done
										 */
			accomReg.setActualRegistrationDate(registrationDate);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			accomReg.setDepartment(masDepartment);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			accomReg.setHospital(masHospital);

			if (unit != 0) {
				MasUnit masUni = new MasUnit();
				masUni.setId(unit);
				accomReg.setUnit(masUni);
			}
			accomReg.setAntiDateRemarks(antiDateRemarks);
			accomReg.setAntiDateSeniority(antiDateSeniority);

			successfullyAdded = accomodationHandlerService
					.submitRegForAirmen(accomReg);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";

			}
		} else if (serviceNoList.size() != 0 || serviceNoList != null) {
			message = "Service No.With Same Rank already exists.";
		}
		try {

			String temp = accomodationHandlerService
					.generateRegistrationNumber();
			registrationNo = request.getParameter("registrationNo");
			registrationNo = accomodationHandlerService
					.getRegistrationNumber(registrationNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		map = accomodationHandlerService.registraionForAirmen();
		jsp = REGISTRATION_FOR_AIRMEN;
		title = "Accomodation Registration For Airmen";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("registrationNo", registrationNo);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- method for allotment of
	 * accomodation for airmen-----------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView allotAccomForAirmen(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = accomodationHandlerService.getPoolListForAlltment();
		jsp = ALLOTMENT_FOR_AIRMEN;
		jsp += ".jsp";
		title = "Accomodation Registration For Airmen";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------------------------method to get records for airmen
	 * allotment ---------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView getRecordsForAirMenAllotment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = accomodationHandlerService.getRecordsForAirMenAllotment(box);
		List<AccomRegistration> airmenRegList = new ArrayList<AccomRegistration>();
		airmenRegList = (List<AccomRegistration>) accomodationHandlerService
				.getRecordsForAirMenAllotment(box).get("airmenRegList");
		String allotmentNo = "";
		if (airmenRegList.size() > 0) {
			allotmentNo = request.getParameter("allotmentNo");
			allotmentNo = accomodationHandlerService
					.getAllotmentNumber(allotmentNo);
			if (allotmentNo != "") {
				map.put("allotmentNo", allotmentNo);
			}
		}
		jsp = ALLOTMENT_FOR_AIRMEN;
		jsp += ".jsp";
		title = "allotment Of Marriage Accomodation For Airmen";
		map.put("poolId", box.getInt(RequestConstants.POOL_ID));
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------------------- method to generate allotment
	 * no--------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView generateAllotmentNumber(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> diagMap = new HashMap<String, Object>();
		String allotmentNo = "";
		allotmentNo = accomodationHandlerService
				.generateAllotmentNumber(diagMap);
		if (allotmentNo != "") {
			map.put("allotmentNo", allotmentNo);
		}

		jsp = "allotmentForAirmen";
		title = "allotment Of Marriage Accomodation For Airmen";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * -------------------------------------method to submit allotment for
	 * airmen ------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitAllotmentForAirmen(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		map = accomodationHandlerService.submitAllotmentForAirmen(box, dataMap);
		String allotmentNo = "";
		allotmentNo = (String) map.get("allotmentNo");

		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		jsp = RequestConstants.MESSAGE_REPORT;
		jsp += ".jsp";
		reportMsg = "/hms/hms/accom?method=generateReportForAirmenAllotment";
		url = "/hms/hms/accom?method=allotAccomForAirmen ";
		map.put("reportMsg", reportMsg);
		map.put("url", url);
		map.put("allotmentNo", allotmentNo);
		title = "allotment Of Marriage Accomodation For Airmen";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------- method to show Occupy Vacation
	 * Return airmen (Ver 2.0) forAirmen---------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView OccupyVacationReturnAirmen(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = accomodationHandlerService.getDetailsForSearch(dataMap);
		patientMap = accomodationHandlerService
				.getCurrentGridForAirmen(mapForDs);
		String jsp = RequestConstants.OCCUPY_VACANT_AIRMEN;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------------------method to search SMQ Vacation
	 * ----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchSmqVacationAirmen(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String allotmentNo = "";
		String serviceNo = "";
		int smqId = 0;
		int rankId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";
		int allotmentId = 0;
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
			mapForDs.put("toDate", toDate);
		}

		if (request.getParameter(ALLOTMENT_NO) != null
				&& !(request.getParameter(ALLOTMENT_NO).equals(""))) {
			allotmentNo = request.getParameter(ALLOTMENT_NO);
			mapForDs.put("allotmentNo", allotmentNo);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		if (request.getParameter(SMQ_ID) != null
				&& !(request.getParameter(SMQ_ID).equals("0"))) {
			smqId = Integer.parseInt(request.getParameter(SMQ_ID));
			mapForDs.put("smqId", smqId);
		}
		if (request.getParameter(ALLOTMENT_ID) != null
				&& !(request.getParameter(ALLOTMENT_ID).equals("0"))) {
			allotmentId = Integer.parseInt(request.getParameter(ALLOTMENT_ID));
			mapForDs.put("allotmentId", allotmentId);
		}

		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = accomodationHandlerService.getSMQAirmenGrid(mapForDs);
		detailsMap = accomodationHandlerService.getDetailsForSearch(dataMap);
		jsp = SMQ_VACATION_AIRMEN + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showSmqVacationAirmen(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<AccomAllotment> smqVacationDetailList = new ArrayList<AccomAllotment>();
		String vacationNo = "";
		int allotmentId = 0;
		if (request.getParameter(ALLOTMENT_ID) != null
				&& !(request.getParameter(ALLOTMENT_ID).equals("0"))) {
			allotmentId = Integer.parseInt(request.getParameter(ALLOTMENT_ID));
			dataMap.put("allotmentId", allotmentId);
		}
		map = accomodationHandlerService.getSMQVacationDetails(dataMap);
		if (dataMap.get("smqVacationDetailList") != null) {
			smqVacationDetailList = (List<AccomAllotment>) dataMap
					.get("smqVacationDetailList");
		}
		vacationNo = accomodationHandlerService.generateVacationNumber(diagMap);
		if (vacationNo != "") {
			map.put("vacationNo", vacationNo);
		}
		jsp = SEARCH_SMQ_VACATION_AIRMEN + ".jsp";
		map.put("contentJsp", jsp);
		map.put("smqVacationDetailList", smqVacationDetailList);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------- method to submit smq vacation for
	 * airmen -----------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitSmqVacationForAirmen(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		String message = "";

		dataMap.put("box", box);

		boolean flag = false;
		try {
			flag = accomodationHandlerService.submitSmqVacationForAirmen(box,
					dataMap);

			if (flag == false) {
				message = "Successfully Vacate Allotment For Airmen";
			} else {
				message = "Some Problem occured.";
			}
		} catch (Exception e) {
			//System.out.println("[][][][][][ " + e);
		}
		map = accomodationHandlerService.getPoolListForAlltment();
		String jsp = RequestConstants.SMQ_VACATION_AIRMEN + ".jsp";

		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * ------------------------------------ method to show registration for
	 * Officers---------------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView registraionForOfficers(HttpServletRequest request,
			HttpServletResponse response) {
		String registrationNo = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map = accomodationHandlerService.registraionForOfficer();
		registrationNo = request.getParameter("registrationNo");
		registrationNo = accomodationHandlerService
				.getRegistrationNumber(registrationNo);
		if (registrationNo != "") {
			map.put("registrationNo", registrationNo);
		}

		jsp = REGISTRATION_FOR_OFFICER;
		jsp += ".jsp";
		title = "Accomodation Registration For Officer";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("registrationNo", registrationNo);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------- method to add records for
	 * registration of airmen ------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitRegForOfficer(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		AccomRegistration accomReg = new AccomRegistration();
		Date currentDate = new Date();
		int hospitalId = 0;
		int deptId = 0;
		String registrationNo = "";
		Date registrationDate = new Date();
		String registrationTime = "";
		String serviceNo = "";
		String servicePersonName = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int tradeId = 0;
		String sfx = "";
		int unitId = 0;
		int poolId = 0;
		String previousSmq = "";
		String remarks = "";
		String typeOfReceive = "";
		Date postedDate = new Date();
		Date postingDate = new Date();
		Date anteDate = new Date();
		String antiDateRemarks = "";
		Date antiDateSeniority = new Date();
		int unit = 0;
		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
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
		if (request.getParameter(REGISTRATION_NO) != null
				&& !(request.getParameter(REGISTRATION_NO).equals(""))) {
			registrationNo = request.getParameter(REGISTRATION_NO);
		}
		if (request.getParameter(TYPE_OF_RECEIVE) != null
				&& !(request.getParameter(TYPE_OF_RECEIVE).equals(""))) {
			typeOfReceive = request.getParameter(TYPE_OF_RECEIVE);
		}
		if (request.getParameter(REGISTRATION_DATE) != null
				&& !(request.getParameter(REGISTRATION_DATE).equals(""))) {
			registrationDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(REGISTRATION_DATE));
		}
		if (request.getParameter(TIME) != null
				&& !(request.getParameter(TIME).equals(""))) {
			registrationTime = request.getParameter(TIME);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(SERVICE_PERSON_NAME) != null
				&& !(request.getParameter(SERVICE_PERSON_NAME).equals(""))) {
			servicePersonName = request.getParameter(SERVICE_PERSON_NAME);
		}
		if (request.getParameter(SERVICE_TYPE_ID) != null
				&& (!request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}
		if (request.getParameter(RANK_ID) != null
				&& (!request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		if (request.getParameter(TRADE_ID) != null
				&& (!request.getParameter(TRADE_ID).equals("0"))) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		}
		if (request.getParameter(SFX) != null
				&& !(request.getParameter(SFX).equals(""))) {
			sfx = request.getParameter(SFX);
		}

		if (request.getParameter(UNIT_ID) != null
				&& (!request.getParameter(UNIT_ID).equals("0"))) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}
		if (request.getParameter(POOL_ID) != null
				&& (!request.getParameter(POOL_ID).equals("0"))) {
			poolId = Integer.parseInt(request.getParameter(POOL_ID));
		}
		if (request.getParameter(PREVIOUS_SMQ) != null
				&& !(request.getParameter(PREVIOUS_SMQ).equals(""))) {
			previousSmq = request.getParameter(PREVIOUS_SMQ);
		}
		if (request.getParameter(REMARKS) != null
				&& !(request.getParameter(REMARKS).equals(""))) {
			remarks = request.getParameter(REMARKS);
		}
		if (request.getParameter(POSTING_DATE) != null
				&& !(request.getParameter(POSTING_DATE).equals(""))) {
			postingDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(POSTING_DATE));
		}
		if (request.getParameter(ANTE_DATE) != null
				&& !(request.getParameter(ANTE_DATE).equals(""))) {
			anteDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ANTE_DATE));
		}
		if (request.getParameter(POSTED_DATE) != null
				&& !(request.getParameter(POSTED_DATE).equals(""))) {
			postedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(POSTED_DATE));
		}
		if (request.getParameter(ANTI_DATE_SENIORITY) != null
				&& !(request.getParameter(ANTI_DATE_SENIORITY).equals(""))) {
			antiDateSeniority = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ANTI_DATE_SENIORITY));
		}
		if (request.getParameter(UNIT) != null
				&& (!request.getParameter(UNIT).equals("0"))) {
			unit = Integer.parseInt(request.getParameter(UNIT));
		}
		if (request.getParameter(ANTI_DATE_REMARKS) != null
				&& !(request.getParameter(ANTI_DATE_REMARKS).equals(""))) {
			antiDateRemarks = request.getParameter(ANTI_DATE_REMARKS);
		}
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("rankId", rankId);
		listMap = accomodationHandlerService
				.checkForExistingServiceNo(generalMap);
		List<AccomRegistration> serviceNoList = new ArrayList<AccomRegistration>();
		if (listMap.get("duplicateServiceNoList") != null) {
			serviceNoList = (List<AccomRegistration>) listMap
					.get("duplicateServiceNoList");
		}
		boolean successfullyAdded = false;
		if (serviceNoList.size() == 0 || serviceNoList == null) {
			accomReg.setRegistrationNo(registrationNo);
			accomReg.setRegistrationDate(registrationDate);
			accomReg.setRegistrationTime(registrationTime);
			accomReg.setServiceNo(serviceNo);
			accomReg.setServicePersonName(servicePersonName);
			if (serviceTypeId != 0) {
				MasServiceType masServiceType = new MasServiceType();
				masServiceType.setId(serviceTypeId);
				accomReg.setServiceType(masServiceType);
			}

			MasRank masRank = new MasRank();
			masRank.setId(rankId);
			accomReg.setRank(masRank);

			if (tradeId != 0) {
				MasTrade masTrade = new MasTrade();
				masTrade.setId(tradeId);
				accomReg.setTrade(masTrade);
			}

			accomReg.setSfx(sfx);

			if (unitId != 0) {
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				accomReg.setPreviousUnit(masUnit);
			}

			MasPool masPool = new MasPool();
			masPool.setId(poolId);
			accomReg.setPool(masPool);

			accomReg.setPreviousSmq(previousSmq);
			accomReg.setAnteDate(anteDate);
			accomReg.setPostedDate(postedDate);
			accomReg.setPostingDate(postingDate);
			accomReg.setTypeOfReceive(typeOfReceive);
			accomReg.setRemarks(remarks);
			accomReg.setLastChgBy(changedBy);
			accomReg.setLastChgDate(currentDate);
			accomReg.setLastChgTime(currentTime);
			accomReg.setRegType("o");
			accomReg.setRegStatus("n");/*
										 * this is default status NON OCCUPIED
										 * when registration is done
										 */
			accomReg.setActualRegistrationDate(registrationDate);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			accomReg.setDepartment(masDepartment);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			accomReg.setHospital(masHospital);

			if (unit != 0) {
				MasUnit masUni = new MasUnit();
				masUni.setId(unit);
				accomReg.setUnit(masUni);
			}
			accomReg.setAntiDateRemarks(antiDateRemarks);
			accomReg.setAntiDateSeniority(antiDateSeniority);

			successfullyAdded = accomodationHandlerService
					.submitRegForAirmen(accomReg);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";

			}
		} else if (serviceNoList.size() != 0 || serviceNoList != null) {
			message = "Service No.With Same Rank already exists.";
		}
		try {

			String temp = accomodationHandlerService
					.generateRegistrationNumber();
			registrationNo = request.getParameter("registrationNo");
			registrationNo = accomodationHandlerService
					.getRegistrationNumber(temp);
			map = accomodationHandlerService.registraionForOfficer();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = REGISTRATION_FOR_OFFICER;
		title = "Accomodation Registration For Airmen";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("registrationNo", registrationNo);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- method for allotment of
	 * accomodation for airmen-----------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView allotAccomForOfficer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = accomodationHandlerService.getPoolListForAlltmentOfficer();

		jsp = ALLOTMENT_FOR_OFFICER;
		jsp += ".jsp";
		title = "Accomodation Registration For Officer";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------------------------method to get records for officer
	 * allotment ---------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView getRecordsForOfficerAllotment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> testMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		List<AccomRegistration> officerRegList = new ArrayList<AccomRegistration>();
		map = accomodationHandlerService.getRecordsForOfficerAllotment(box);
		officerRegList = (List<AccomRegistration>) accomodationHandlerService
				.getRecordsForOfficerAllotment(box).get("officerRegList");
		String allotmentNo = "";
		if (officerRegList.size() > 0) {
			allotmentNo = request.getParameter("allotmentNo");
			allotmentNo = accomodationHandlerService
					.getAllotmentNumber(allotmentNo);
			if (allotmentNo != "") {
				map.put("allotmentNo", allotmentNo);
			}
		}
		jsp = ALLOTMENT_FOR_OFFICER;
		jsp += ".jsp";
		title = "allotment Of Marriage Accomodation For Officer";
		map.put("poolId", box.getInt(RequestConstants.POOL_ID));
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("testMap", testMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -----------------------------------------method to submit allotment for
	 * smqs /garage officers-------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitAllotmentForOfficer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);

		map = accomodationHandlerService
				.submitAllotmentForOfficer(box, dataMap);
		String allotmentNo = "";
		allotmentNo = (String) map.get("allotmentNo");
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		//System.out.println(allotmentNo);
		jsp = RequestConstants.MESSAGE_REPORT;
		jsp += ".jsp";
		title = "allotment Of Marriage Accomodation For Officer";
		reportMsg = "/hms/hms/accom?method=generateReportForOfficerAllotment";
		url = "/hms/hms/accom?method=allotAccomForOfficer ";
		map.put("reportMsg", reportMsg);
		map.put("allotmentNo", allotmentNo);
		map.put("url", url);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------- method to show screen for vacation of
	 * SMQs for officers -----------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showSMQVacationForOfficer(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = accomodationHandlerService.getDetailsForSearch(dataMap);
		patientMap = accomodationHandlerService
				.getCurrentGridForOfficer(mapForDs);
		String jsp = SMQ_VACATION_OFFICER;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------------------method to get grid on basis of search
	 * for smq vacation of officers --------------------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView searchSmqVacationOfficer(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String allotmentNo = "";
		String serviceNo = "";
		int smqId = 0;
		int rankId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
			mapForDs.put("toDate", toDate);
		}

		if (request.getParameter(ALLOTMENT_NO) != null
				&& !(request.getParameter(ALLOTMENT_NO).equals(""))) {
			allotmentNo = request.getParameter(ALLOTMENT_NO);
			mapForDs.put("allotmentNo", allotmentNo);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		if (request.getParameter(SMQ_ID) != null
				&& !(request.getParameter(SMQ_ID).equals("0"))) {
			smqId = Integer.parseInt(request.getParameter(SMQ_ID));
			mapForDs.put("smqId", smqId);
		}

		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = accomodationHandlerService.getSMQOfficerGrid(mapForDs);
		detailsMap = accomodationHandlerService.getDetailsForSearch(dataMap);
		jsp = SMQ_VACATION_OFFICER + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------method to get smq vacation details for
	 * officer------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showSmqVacationOfficer(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<AccomAllotment> smqVacationDetailList = new ArrayList<AccomAllotment>();
		String vacationNo = "";
		int allotmentId = 0;
		if (request.getParameter(ALLOTMENT_ID) != null
				&& !(request.getParameter(ALLOTMENT_ID).equals("0"))) {
			allotmentId = Integer.parseInt(request.getParameter(ALLOTMENT_ID));
			dataMap.put("allotmentId", allotmentId);
		}
		map = accomodationHandlerService
				.getSMQVacationDetailsForOfficer(dataMap);
		if (dataMap.get("smqVacationDetailList") != null) {
			smqVacationDetailList = (List<AccomAllotment>) dataMap
					.get("smqVacationDetailList");
		}
		vacationNo = accomodationHandlerService.generateVacationNumber(diagMap);
		if (vacationNo != "") {
			map.put("vacationNo", vacationNo);
		}
		jsp = SEARCH_SMQ_VACATION_OFFICER + ".jsp";
		map.put("contentJsp", jsp);
		map.put("smqVacationDetailList", smqVacationDetailList);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------- method to submit smq vacation for
	 * officer ---------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitSmqVacationForOfficer(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		String message = "";

		dataMap.put("box", box);

		boolean flag = false;
		try {
			flag = accomodationHandlerService.submitSmqVacationForAirmen(box,
					dataMap);

			if (flag == false) {
				message = "Successfully Vacate  the Allotment For Officer";
			} else {
				message = "Some Problem occured.";
			}
		} catch (Exception e) {
			//System.out.println("[][][][][][ " + e);
		}
		map = accomodationHandlerService.getPoolListForAlltmentOfficer();
		String jsp = RequestConstants.SMQ_VACATION_OFFICER + ".jsp";

		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * ---------------------------------------show relegation
	 * process-----------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showRelegationProcess(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = accomodationHandlerService
				.getDetailsForSearchForRelegation(dataMap);
		patientMap = accomodationHandlerService
				.getCurrentGridForRelegationProcess(mapForDs);
		String jsp = SEARCH_RELEAGTION_PROCESS;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------------------method to search Relegation
	 * Process---------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchRelegationOfficer(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String registrationNo = "";
		String serviceNo = "";
		int poolId = 0;
		int rankId = 0;
		int serviceTypeId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";
		int vacationId = 0;
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
			mapForDs.put("toDate", toDate);
		}

		if (request.getParameter(REGISTRATION_NO) != null
				&& !(request.getParameter(REGISTRATION_NO).equals(""))) {
			registrationNo = request.getParameter(REGISTRATION_NO);
			mapForDs.put("registrationNo", registrationNo);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		if (request.getParameter(POOL_ID) != null
				&& !(request.getParameter(POOL_ID).equals("0"))) {
			poolId = Integer.parseInt(request.getParameter(POOL_ID));
			mapForDs.put("poolId", poolId);
		}
		if (request.getParameter(SERVICE_TYPE_ID) != null
				&& !(request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
			mapForDs.put("serviceTypeId", serviceTypeId);
		}
		if (request.getParameter(VACATION_ID) != null
				&& !(request.getParameter(VACATION_ID).equals("0"))) {
			vacationId = Integer.parseInt(request.getParameter(VACATION_ID));
			mapForDs.put("vacationId", vacationId);
		}

		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = accomodationHandlerService
				.getRelegationProcessGrid(mapForDs);
		detailsMap = accomodationHandlerService
				.getDetailsForSearchForRelegation(dataMap);
		jsp = SEARCH_RELEAGTION_PROCESS + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------method to show relegation process screen
	 * ------------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showRelegationProcessOfficer(
			HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IllegalStateException {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<AccomRegistration> relegationDetailList = new ArrayList<AccomRegistration>();
		String relegationNo = "";
		int vacationId = 0;
		if (request.getParameter(VACATION_ID) != null
				&& !(request.getParameter(VACATION_ID).equals("0"))) {
			vacationId = Integer.parseInt(request.getParameter(VACATION_ID));
			dataMap.put("vacationId", vacationId);
		}
		map = accomodationHandlerService.getRelegationDetail(dataMap);
		if (dataMap.get("relegationDetailList") != null) {
			relegationDetailList = (List<AccomRegistration>) dataMap
					.get("relegationDetailList");
		}
		relegationNo = accomodationHandlerService
				.generateRelegationNumber(diagMap);
		if (relegationNo != "") {
			map.put("relegationNo", relegationNo);
		}
		jsp = RequestConstants.RELEAGTION_PROCESS + ".jsp";
		map.put("contentJsp", jsp);
		map.put("relegationDetailList", relegationDetailList);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * 
	 * ------------------------method to submit relegation process details
	 * ----------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitRelegationDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<AccomRegistration> relegationDetailList = new ArrayList<AccomRegistration>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		String url = "";
		map = accomodationHandlerService.submitRelegationDetails(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		map = accomodationHandlerService.getRelegationDetail(dataMap);
		if (dataMap.get("relegationDetailList") != null) {
			relegationDetailList = (List<AccomRegistration>) dataMap
					.get("relegationDetailList");
		}
		jsp = RequestConstants.MESSAGE_ACCOMODATION;
		jsp += ".jsp";
		title = "Relegation Process";
		url = "/hms/hms/accom?method=showRelegationProcess";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("relegationDetailList", relegationDetailList);
		map.put("url", url);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------------------- method to show jsp for
	 * NOC------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showNOCJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = accomodationHandlerService.getPoolListForAlltmentOfficer();
		jsp = NOC;
		jsp += ".jsp";
		title = "Issue Of Willingness Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------------------method to get records for NOC
	 * ------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView getRecordsForNOC(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> testMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = accomodationHandlerService.getRecordsForNOC(box);
		jsp = NOC;
		jsp += ".jsp";
		title = "Issue Of Willingness Certificate";
		map.put("poolId", box.getInt(RequestConstants.POOL_ID));
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("testMap", testMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------------------------- method to submit NOC and update
	 * sttaus in registration table ------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitNOC(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);

		map = accomodationHandlerService.submitNOC(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Accepted Successfully !!";
		} else {
			message = "Try Again !!";
		}
		jsp = NOC;
		jsp += ".jsp";
		title = "Issue Of Willingness Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------------- method to cancel allotment order for airmen
	 * -----------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView cancelForAirmen(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = accomodationHandlerService
				.getSearchForCancelAirmen(dataMap);
		patientMap = accomodationHandlerService
				.getCurrentGridForCancelAllotment(mapForDs);
		String jsp = RequestConstants.SERACH_CANCEL_AIRMEN;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------- method to search for cancel of allotment for
	 * airmen------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchCancelForAirmen(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String allotmentNo = "";
		String serviceNo = "";
		int poolId = 0;
		int rankId = 0;
		int serviceTypeId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";
		int allotmentId = 0;
		int smqId = 0;
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		if (request.getParameter(ALLOTMENT_NO) != null
				&& !(request.getParameter(ALLOTMENT_NO).equals(""))) {
			allotmentNo = request.getParameter(ALLOTMENT_NO);
			mapForDs.put("allotmentNo", allotmentNo);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}

		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		if (request.getParameter(POOL_ID) != null
				&& !(request.getParameter(POOL_ID).equals("0"))) {
			poolId = Integer.parseInt(request.getParameter(POOL_ID));
			mapForDs.put("poolId", poolId);
		}
		if (request.getParameter(SMQ_ID) != null
				&& !(request.getParameter(SMQ_ID).equals("0"))) {
			smqId = Integer.parseInt(request.getParameter(SMQ_ID));
			mapForDs.put("smqId", smqId);
		}
		if (request.getParameter(SERVICE_TYPE_ID) != null
				&& !(request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
			mapForDs.put("serviceTypeId", serviceTypeId);
		}
		if (request.getParameter(ALLOTMENT_ID) != null
				&& !(request.getParameter(ALLOTMENT_ID).equals("0"))) {
			allotmentId = Integer.parseInt(request.getParameter(ALLOTMENT_ID));
			mapForDs.put("allotmentId", allotmentId);
		}

		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = accomodationHandlerService.getCancelGrid(mapForDs);
		detailsMap = accomodationHandlerService
				.getSearchForCancelAirmen(dataMap);
		jsp = RequestConstants.SERACH_CANCEL_AIRMEN + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------- method to show jsp for cancel of allotment for
	 * airmen-----------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showCancelForAirmen(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<AccomAllotment> cancelDetailList = new ArrayList<AccomAllotment>();
		String cancelNo = "";
		int allotmentId = 0;
		if (request.getParameter(ALLOTMENT_ID) != null
				&& !(request.getParameter(ALLOTMENT_ID).equals("0"))) {
			allotmentId = Integer.parseInt(request.getParameter(ALLOTMENT_ID));
			dataMap.put("allotmentId", allotmentId);
		}
		map = accomodationHandlerService.getCancellationDetail(dataMap);
		if (dataMap.get("cancelDetailList") != null) {
			cancelDetailList = (List<AccomAllotment>) dataMap
					.get("cancelDetailList");
		}
		cancelNo = request.getParameter("cancelNo");
		cancelNo = accomodationHandlerService.getRegistrationNumber(cancelNo);
		if (cancelNo != "") {
			map.put("cancelNo", cancelNo);
		}
		jsp = RequestConstants.CANCEL_AIRMEN + ".jsp";
		map.put("contentJsp", jsp);
		map.put("cancelDetailList", cancelDetailList);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * method to update records in registration table which are cancel for
	 * airmen
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitCancellationForAirmen(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		String message = "";

		dataMap.put("box", box);
		String cancelNo = "";

		boolean flag = false;
		try {
			flag = accomodationHandlerService.submitCancellationForAirmen(box,
					dataMap);
			cancelNo = (String) dataMap.get("cancelNo");
			if (flag == false) {
				message = "Successfully Cancelled the Allotment For Airmen";
			} else {
				message = "Some Problem occured.";
			}
		} catch (Exception e) {
			//System.out.println("[][][][][][ " + e);
		}
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String userName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("deptName", deptName);
		dataMap.put("userName", userName);
		detailsMap = accomodationHandlerService
				.getSearchForCancelAirmen(dataMap);
		patientMap = accomodationHandlerService
				.getCurrentGridForCancelAllotment(mapForDs);
		// String temp =
		// accomodationHandlerService.generateCancellationNumber(diagMap);
		String jsp = RequestConstants.MESSAGE_REPORT + ".jsp";
		reportMsg = "/hms/hms/accom?method=generateReportForAirmenCancellation";
		url = "/hms/hms/accom?method=cancelForAirmen ";
		map.put("reportMsg", reportMsg);
		map.put("url", url);
		map.put("message", message);
		map.put("cancelNo", cancelNo);
		map.put("contentJsp", jsp);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------------- new method to show Smq Vacation for airmen
	 * -----------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView smqVacForAirmen(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = accomodationHandlerService.getPoolListForAlltment();

		jsp = SMQ_VACATION_AIRMEN;
		jsp += ".jsp";
		title = "SMQ Vacation For Airmen";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------- method to get records for smq vacation of airmen(ver
	 * 2.0) -------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView getRecordsForAirMenVacation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		List<AccomAllotment> smqVacList = new ArrayList<AccomAllotment>();
		map = accomodationHandlerService.getRecordsForSmqVacation(box);
		smqVacList = (List) accomodationHandlerService
				.getRecordsForSmqVacation(box).get("smqVacList");

		String vacationNo = "";
		if (smqVacList.size() > 0) {
			vacationNo = accomodationHandlerService
					.generateVacationNumber(diagMap);
			if (vacationNo != "") {
				map.put("vacationNo", vacationNo);
			}
		}
		jsp = SMQ_VACATION_AIRMEN;
		jsp += ".jsp";
		title = "SMQ Vacation For Airmen";
		map.put("poolId", box.getInt(RequestConstants.POOL_ID));
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------- method to update status in Accom
	 * registration For Smq Vacation(ver 2.0)
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView updateSmqVacation(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String message = "";
		String vacationNo = "";
		dataMap.put("box", box);

		boolean flag = false;
		try {
			flag = accomodationHandlerService.updateSmqVacation(box, dataMap);
			vacationNo = (String) dataMap.get("vacationNo");
			if (flag == false) {
				message = "Successfully Vacated ";
			} else {
				message = "Some Problem occured.";
			}
		} catch (Exception e) {
			//System.out.println("[][][][][][ " + e);
		}

		String jsp = RequestConstants.MESSAGE_REPORT + ".jsp";
		reportMsg = "/hms/hms/accom?method=generateReportForAirmenVacation";
		url = "/hms/hms/accom?method=smqVacForAirmen";
		map.put("reportMsg", reportMsg);
		map.put("vacationNo", vacationNo);
		map.put("url", url);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------- method ALLOTMENT/VACATION OF SMQs for AIRMEN (Ver
	 * 2.0)---------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView allotVacatAirmen(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = accomodationHandlerService.getSmqListForAlltment();
		// String vacationNo = "";

		// vacationNo =
		// accomodationHandlerService.generateVacationNumber(diagMap);

		// if (vacationNo != "")
		// {
		// map.put("vacationNo", vacationNo);
		// }
		jsp = RequestConstants.ALLOT_VACAT_AIRMEN;
		jsp += ".jsp";
		title = "SMQ Vacation For Airmen";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------- method to get records for allotment vacation of
	 * airmen(ver 2.0) -------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView getRecordsAllotVacatAirmen(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String vacationNo = "";
		map = accomodationHandlerService.getRecordsForAllotVacat(box);
		if (accomodationHandlerService.getRecordsForAllotVacat(box).size() > 0) {

			vacationNo = accomodationHandlerService
					.generateVacationNumber(diagMap);
		}
		if (vacationNo != "") {
			map.put("vacationNo", vacationNo);
		}
		String allotmentNo = "";
		allotmentNo = accomodationHandlerService
				.generateAllotmentNumber(diagMap);
		if (allotmentNo != "") {
			map.put("allotmentNo", allotmentNo);
		}
		jsp = RequestConstants.ALLOT_VACAT_AIRMEN;
		jsp += ".jsp";
		title = "Allotment Vacation For Airmen";
		map.put("smqId", box.getInt(RequestConstants.SMQ_ID));
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------- method to show Allotment details for
	 * Allotment/Vacant(ver 2.0)
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showAllotmentDetailsAirmen(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		Box box = HMSUtil.getBox(request);
		smqList = (List) accomodationHandlerService
				.getRecordsForAllotVacat(box).get("smqList");
		map = accomodationHandlerService.getPoolList();
		String allotmentNo = "";
		allotmentNo = accomodationHandlerService
				.generateAllotmentNumber(diagMap);
		allotmentNo = accomodationHandlerService
				.getAllotmentNumber(allotmentNo);
		if (allotmentNo != "") {
			map.put("allotmentNo", allotmentNo);
		}
		int smqId = 0;
		int registrationId = 0;
		String vacationNo = "";
		Date vacationDate = new Date();
		int allotmentId = 0;
		int poolId = 0;
		String poolName = "";
		if (request.getParameter("smqId") != null
				&& !(request.getParameter("smqId").equals("0"))) {
			smqId = Integer.parseInt(request.getParameter("smqId"));
		}
		if (request.getParameter("vacationNo") != null
				&& !(request.getParameter("vacationNo").equals(""))) {
			vacationNo = request.getParameter("vacationNo");
		}
		if (request.getParameter("vacationDate") != null
				&& !(request.getParameter("vacationDate").equals(""))) {
			vacationDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("vacationDate"));
		}
		if (request.getParameter("registrationId") != null
				&& !(request.getParameter("registrationId").equals("0"))) {
			registrationId = Integer.parseInt(request
					.getParameter("registrationId"));
		}
		if (request.getParameter("allotmentId") != null
				&& !(request.getParameter("allotmentId").equals("0"))) {
			allotmentId = Integer.parseInt(request.getParameter("allotmentId"));
		}
		if (request.getParameter("poolId") != null
				&& !(request.getParameter("poolId").equals("0"))) {
			poolId = Integer.parseInt(request.getParameter("poolId"));
		}
		if (request.getParameter("poolName") != null
				&& !(request.getParameter("poolName").equals(""))) {
			poolName = request.getParameter("poolName");
		}
		jsp = "allotmentDetailsAirmen";
		jsp += ".jsp";
		map.put("smqList", smqList);
		map.put("vacationDate", vacationDate);
		map.put("vacationNo", vacationNo);
		map.put("smqId", smqId);
		map.put("registrationId", registrationId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("allotmentId", allotmentId);
		map.put("poolId", poolId);
		map.put("poolName", poolName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * method to get Records for Allotment/Vacant when servcie No is given (Ver
	 * 2.0)
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView getRecordsForAllotVacantAirmen(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String allotmentNo = "";
		map = accomodationHandlerService.getRecordsForAirMenReg(box);
		if (accomodationHandlerService.getRecordsForAirMenReg(box).size() > 0) {
			allotmentNo = accomodationHandlerService
					.generateAllotmentNumber(diagMap);
		}
		if (allotmentNo != "") {
			map.put("allotmentNo", allotmentNo);
		}

		jsp = "allotmentDetails";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("allotmentNo", allotmentNo);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------ method to get records for cancellation of allotment of
	 * officer
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView cancelForOfficer(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = accomodationHandlerService
				.getSearchForCancelOfficer(dataMap);
		patientMap = accomodationHandlerService
				.getCurrentGridForCancelAllotmentForOfficer(mapForDs);
		String jsp = RequestConstants.SEARCH_CANCEL_OFFICER;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------- method to show cancel for allotment of officer (Ver 2.0)
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showCancelForOfficer(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<AccomAllotment> cancelDetailList = new ArrayList<AccomAllotment>();
		String cancelNo = "";
		int allotmentId = 0;
		if (request.getParameter(ALLOTMENT_ID) != null
				&& !(request.getParameter(ALLOTMENT_ID).equals("0"))) {
			allotmentId = Integer.parseInt(request.getParameter(ALLOTMENT_ID));
			dataMap.put("allotmentId", allotmentId);
		}
		map = accomodationHandlerService
				.getCancellationDetailForOfficer(dataMap);
		if (dataMap.get("cancelDetailList") != null) {
			cancelDetailList = (List<AccomAllotment>) dataMap
					.get("cancelDetailList");
		}
		cancelNo = accomodationHandlerService
				.generateCancellationNumber(diagMap);
		if (cancelNo != "") {
			map.put("cancelNo", cancelNo);
		}
		jsp = RequestConstants.CANCEL_OFFICER + ".jsp";
		map.put("contentJsp", jsp);
		map.put("cancelDetailList", cancelDetailList);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * method to update records in registration table which are cancel for
	 * Officer
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitCancellationForOfficer(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		String message = "";
		String cancelNo = "";

		dataMap.put("box", box);

		boolean flag = false;
		try {
			flag = accomodationHandlerService.submitCancellationForOfficer(box,
					dataMap);
			cancelNo = (String) dataMap.get("cancelNo");
			if (flag == false) {
				message = "Successfully Cancelled the Allotment For Officer";
			} else {
				message = "Some Problem occured.";
			}
		} catch (Exception e) {
			//System.out.println("[][][][][][ " + e);
		}
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String userName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("deptName", deptName);
		dataMap.put("userName", userName);
		detailsMap = accomodationHandlerService
				.getSearchForCancelOfficer(dataMap);
		patientMap = accomodationHandlerService
				.getCurrentGridForCancelAllotmentForOfficer(mapForDs);
		String jsp = RequestConstants.MESSAGE_REPORT + ".jsp";
		reportMsg = "/hms/hms/accom?method=generateReportForOfficerCancellation";
		url = "/hms/hms/accom?method=cancelForOfficer";
		map.put("cancelNo", cancelNo);
		map.put("reportMsg", reportMsg);
		map.put("url", url);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView smqVacForOfficer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = accomodationHandlerService.getPoolListForAlltmentOfficer();

		jsp = SMQ_VACATION_OFFICER;
		jsp += ".jsp";
		title = "SMQ Vacation For Officer";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------- method to get records for smq vacation of airmen(ver
	 * 2.0) -------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView getRecordsForOfficerVacation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		List<AccomAllotment> smqVacList = new ArrayList<AccomAllotment>();
		map = accomodationHandlerService.getRecordsForSmqVacationOfficer(box);
		smqVacList = (List) accomodationHandlerService
				.getRecordsForSmqVacationOfficer(box).get("smqVacList");
		String vacationNo = "";
		if (smqVacList.size() > 0) {
			vacationNo = accomodationHandlerService
					.generateVacationNumber(diagMap);
			if (vacationNo != "") {
				map.put("vacationNo", vacationNo);
			}
		}
		//System.out.println("smqVacList in cont:  " + smqVacList.size());
		jsp = SMQ_VACATION_OFFICER;
		jsp += ".jsp";
		title = "SMQ Vacation For Officer";
		map.put("poolId", box.getInt(RequestConstants.POOL_ID));
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView updateSmqVacationOfficer(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String message = "";

		dataMap.put("box", box);

		boolean flag = false;
		try {
			flag = accomodationHandlerService.updateSmqVacationOfficer(box,
					dataMap);

			if (flag == false) {
				message = "Successfully Vacated ";
			} else {
				message = "Some Problem occured.";
			}
		} catch (Exception e) {
			//System.out.println("[][][][][][ " + e);
		}

		String jsp = RequestConstants.MESSAGE_REPORT + ".jsp";
		reportMsg = "/hms/hms/accom?method=generateReportForOfficerVacation";
		url = "/hms/hms/accom?method=smqVacForOfficer";
		map.put("reportMsg", reportMsg);
		map.put("url", url);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------- method ALLOTMENT/VACATION OF SMQs for Officer (Ver
	 * 2.0)---------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView allotVacantOfficer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = accomodationHandlerService.getSmqListForOfficerAlltment();
		// String vacationNo = "";
		// if (accomodationHandlerService.getSmqListForOfficerAlltment().size()
		// >
		// 0)
		// {
		// vacationNo =
		// accomodationHandlerService.generateVacationNumber(diagMap);
		// }
		// if (vacationNo != "")
		// {
		// map.put("vacationNo", vacationNo);
		// }
		jsp = RequestConstants.ALLOT_VACAT_OFFICER;
		jsp += ".jsp";
		title = "SMQ Vacation For Airmen";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------- method to get records for allotment vacation of
	 * Officer(ver 2.0) -------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView getRecordsAllotVacatOfficer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = accomodationHandlerService.getRecordsForAllotVacatOfficer(box);
		String vacationNo = "";
		if (accomodationHandlerService.getRecordsForAllotVacatOfficer(box)
				.size() > 0) {
			vacationNo = accomodationHandlerService
					.generateVacationNumber(diagMap);
		}
		if (vacationNo != "") {
			map.put("vacationNo", vacationNo);
		}
		String allotmentNo = "";
		allotmentNo = accomodationHandlerService
				.generateAllotmentNumber(diagMap);
		if (allotmentNo != "") {
			map.put("allotmentNo", allotmentNo);
		}
		jsp = RequestConstants.ALLOT_VACAT_OFFICER;
		jsp += ".jsp";
		title = "Allotment Vacation For Officer";
		map.put("smqId", box.getInt(RequestConstants.SMQ_ID));
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------- method to show Occupy Vacation
	 * Return airmen (Ver 2.0) forAirmen---------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView occupyVacantOfficer(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = accomodationHandlerService
				.getDetailsForSearchForOff(dataMap);
		patientMap = accomodationHandlerService
				.getCurrentGridForOfficer(mapForDs);
		String jsp = RequestConstants.OCCUPY_VACANT_OFFICER;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------------------method to Occupy Vacant Details for
	 * officer(ver 2.0) ---------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchOccVacOfficer(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date hoToFromDate = new Date();
		Date hoToDate = new Date();
		Date allotFromDate = new Date();
		Date allotToDate = new Date();
		String allotmentNo = "";
		int poolId = 0;
		int smqId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";
		String previous = "";
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			hoToFromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			mapForDs.put("hoToFromDate", hoToFromDate);
		}

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			hoToDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
			mapForDs.put("hoToDate", hoToDate);
		}
		if (request.getParameter(RequestConstants.ALLOTMENT_DATE) != null
				&& !(request.getParameter(RequestConstants.ALLOTMENT_DATE)
						.equals(""))) {
			allotFromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.ALLOTMENT_DATE));
			mapForDs.put("allotFromDate", allotFromDate);
		}

		if (request.getParameter(RequestConstants.ALLOTMENT_FILE_DATE) != null
				&& !(request.getParameter(RequestConstants.ALLOTMENT_FILE_DATE)
						.equals(""))) {
			allotToDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.ALLOTMENT_FILE_DATE));
			mapForDs.put("allotToDate", allotToDate);
		}

		if (request.getParameter(ALLOTMENT_NO) != null
				&& !(request.getParameter(ALLOTMENT_NO).equals(""))) {
			allotmentNo = request.getParameter(ALLOTMENT_NO);
			mapForDs.put("allotmentNo", allotmentNo);
		}

		if (request.getParameter(SMQ_ID) != null
				&& !(request.getParameter(SMQ_ID).equals("0"))) {
			smqId = Integer.parseInt(request.getParameter(SMQ_ID));
			mapForDs.put("smqId", smqId);
		}
		if (request.getParameter(POOL_ID) != null
				&& !(request.getParameter(POOL_ID).equals("0"))) {
			poolId = Integer.parseInt(request.getParameter(POOL_ID));
			mapForDs.put("poolId", poolId);
		}
		if (request.getParameter(PREVIOUS_SMQ) != null
				&& !(request.getParameter(PREVIOUS_SMQ).equals(""))) {
			previous = request.getParameter(PREVIOUS_SMQ);
			mapForDs.put("previous", previous);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = accomodationHandlerService.getOccVacOfficerGrid(mapForDs);
		detailsMap = accomodationHandlerService
				.getDetailsForSearchForOff(dataMap);
		jsp = RequestConstants.OCCUPY_VACANT_OFFICER + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------------------method to Occupy Vacant Details for
	 * officer(ver 2.0) ---------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchOccVacAirmen(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date hoToFromDate = new Date();
		Date hoToDate = new Date();
		Date allotFromDate = new Date();
		Date allotToDate = new Date();
		String allotmentNo = "";
		int poolId = 0;
		int smqId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";
		String previous = "";
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			hoToFromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			mapForDs.put("hoToFromDate", hoToFromDate);
		}

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			hoToDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
			mapForDs.put("hoToDate", hoToDate);
		}
		if (request.getParameter(RequestConstants.ALLOTMENT_DATE) != null
				&& !(request.getParameter(RequestConstants.ALLOTMENT_DATE)
						.equals(""))) {
			allotFromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.ALLOTMENT_DATE));
			mapForDs.put("allotFromDate", allotFromDate);
		}

		if (request.getParameter(RequestConstants.ALLOTMENT_FILE_DATE) != null
				&& !(request.getParameter(RequestConstants.ALLOTMENT_FILE_DATE)
						.equals(""))) {
			allotToDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.ALLOTMENT_FILE_DATE));
			mapForDs.put("allotToDate", allotToDate);
		}

		if (request.getParameter(ALLOTMENT_NO) != null
				&& !(request.getParameter(ALLOTMENT_NO).equals(""))) {
			allotmentNo = request.getParameter(ALLOTMENT_NO);
			mapForDs.put("allotmentNo", allotmentNo);
		}

		if (request.getParameter(SMQ_ID) != null
				&& !(request.getParameter(SMQ_ID).equals("0"))) {
			smqId = Integer.parseInt(request.getParameter(SMQ_ID));
			mapForDs.put("smqId", smqId);
		}
		if (request.getParameter(POOL_ID) != null
				&& !(request.getParameter(POOL_ID).equals("0"))) {
			poolId = Integer.parseInt(request.getParameter(POOL_ID));
			mapForDs.put("poolId", poolId);
		}
		if (request.getParameter(PREVIOUS_SMQ) != null
				&& !(request.getParameter(PREVIOUS_SMQ).equals(""))) {
			previous = request.getParameter(PREVIOUS_SMQ);
			mapForDs.put("previous", previous);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = accomodationHandlerService.getOccVacAirmenGrid(mapForDs);
		detailsMap = accomodationHandlerService
				.getDetailsForSearchForAirmen(dataMap);
		jsp = RequestConstants.OCCUPY_VACANT_AIRMEN + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------- method for NAC for Officer(ver 2.0)
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchNac(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		mapForDs.put("serviceNo", serviceNo);
		patientMap = accomodationHandlerService.getCurrentGridForNac(mapForDs);
		String jsp = RequestConstants.NAC_OFFICER;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------- method to search NAc
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView nacOfficer(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		Date regFromDate = new Date();
		Date regToDate = new Date();
		String serviceNo = "";

		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";

		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (request.getParameter(RequestConstants.FROM_DATE) != null
				&& !(request.getParameter(RequestConstants.FROM_DATE)
						.equals(""))) {
			regFromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.FROM_DATE));
			mapForDs.put("regFromDate", regFromDate);
		}

		if (request.getParameter(RequestConstants.TO_DATE) != null
				&& !(request.getParameter(RequestConstants.TO_DATE).equals(""))) {
			regToDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.TO_DATE));
			mapForDs.put("regToDate", regToDate);
		}

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}

		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = accomodationHandlerService.getNacGrid(mapForDs);
		jsp = RequestConstants.NAC_OFFICER + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------- method to show Allotment details for Allotment/Vacant
	 * For Officer(ver 2.0)
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showAllotmentDetailsOfficer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		smqList = (List) accomodationHandlerService
				.getRecordsForAllotVacatOfficer(box).get("smqList");
		map = accomodationHandlerService.getPoolList();
		String allotmentNo = "";
		allotmentNo = accomodationHandlerService
				.generateAllotmentNumber(diagMap);
		allotmentNo = accomodationHandlerService
				.getAllotmentNumber(allotmentNo);
		if (allotmentNo != "") {
			map.put("allotmentNo", allotmentNo);
		}
		int smqId = 0;
		int registrationId = 0;
		String vacationNo = "";
		Date vacationDate = new Date();
		int allotmentId = 0;
		int poolId = 0;
		String poolName = "";

		if (request.getParameter("smqId") != null
				&& !(request.getParameter("smqId").equals("0"))) {
			smqId = Integer.parseInt(request.getParameter("smqId"));
		}
		if (request.getParameter("vacationNo") != null
				&& !(request.getParameter("vacationNo").equals(""))) {
			vacationNo = request.getParameter("vacationNo");
		}
		if (request.getParameter("vacationDate") != null
				&& !(request.getParameter("vacationDate").equals(""))) {
			vacationDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("vacationDate"));
		}
		if (request.getParameter("registrationId") != null
				&& !(request.getParameter("registrationId").equals("0"))) {
			registrationId = Integer.parseInt(request
					.getParameter("registrationId"));
		}
		if (request.getParameter("allotmentId") != null
				&& !(request.getParameter("allotmentId").equals("0"))) {
			allotmentId = Integer.parseInt(request.getParameter("allotmentId"));
		}
		if (request.getParameter("poolId") != null
				&& !(request.getParameter("poolId").equals("0"))) {
			poolId = Integer.parseInt(request.getParameter("poolId"));
		}
		if (request.getParameter("poolName") != null
				&& !(request.getParameter("poolName").equals(""))) {
			poolName = request.getParameter("poolName");
		}
		jsp = "allotmentDetailsOfficer";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("smqList", smqList);
		map.put("vacationDate", vacationDate);
		map.put("vacationNo", vacationNo);
		map.put("smqId", smqId);
		map.put("registrationId", registrationId);
		map.put("allotmentId", allotmentId);
		map.put("poolName", poolName);
		map.put("poolId", poolId);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------- method to submit allotVacant for officer
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView submitAllotmentDetailsOfficer(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);

		map = accomodationHandlerService.submitAllotmentDetailsOfficer(box,
				dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		jsp = RequestConstants.MESSAGE_REPORT;
		jsp += ".jsp";
		reportMsg = "/hms/hms/accom?method=generateReportAllotVacateOfficer";
		url = "/hms/hms/accom?method=allotVacatOfficer";
		map.put("reportMsg", reportMsg);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------- method to submit allotVacant for Airmen
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView submitAllotmentDetailsAirmen(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		String vacationNo = "";
		String allotmentNo = "";

		map = accomodationHandlerService.submitAllotmentDetailsAirmen(box,
				dataMap);
		allotmentNo = (String) map.get("allotmentNo");
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		String temp = accomodationHandlerService
				.generateVacationNumber(diagMap);
		vacationNo = request.getParameter("registrationNo");
		vacationNo = accomodationHandlerService.getVacationNumber(vacationNo);
		jsp = RequestConstants.MESSAGE_REPORT;
		jsp += ".jsp";
		reportMsg = "/hms/hms/accom?method=generateReportForAirmenAllotment";
		url = "/hms/hms/accom?method=allotVacatAirmen";
		map.put("allotmentNo", allotmentNo);
		map.put("reportMsg", reportMsg);
		map.put("url", url);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------- method to submit occupyvacant for officer
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView submitRecordsForOccVacOfficer(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);

		map = accomodationHandlerService.submitRecordsForOccVacOfficer(box,
				dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		jsp = RequestConstants.OCCUPY_VACANT_OFFICER;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------- method to submit occupyvacant for officer
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView submitRecordsForOccVacAirmen(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);

		map = accomodationHandlerService.submitRecordsForOccVacAirmen(box,
				dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		jsp = RequestConstants.OCCUPY_VACANT_AIRMEN;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------- method to search for cancel of allotment for
	 * airmen------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchCancelForOfficer(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String allotmentNo = "";
		String serviceNo = "";
		int poolId = 0;
		int rankId = 0;
		int serviceTypeId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";
		int allotmentId = 0;
		int smqId = 0;
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		if (request.getParameter(ALLOTMENT_NO) != null
				&& !(request.getParameter(ALLOTMENT_NO).equals(""))) {
			allotmentNo = request.getParameter(ALLOTMENT_NO);
			mapForDs.put("allotmentNo", allotmentNo);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		if (request.getParameter(POOL_ID) != null
				&& !(request.getParameter(POOL_ID).equals("0"))) {
			poolId = Integer.parseInt(request.getParameter(POOL_ID));
			mapForDs.put("poolId", poolId);
		}
		if (request.getParameter(SMQ_ID) != null
				&& !(request.getParameter(SMQ_ID).equals("0"))) {
			smqId = Integer.parseInt(request.getParameter(SMQ_ID));
			mapForDs.put("smqId", smqId);
		}
		if (request.getParameter(SERVICE_TYPE_ID) != null
				&& !(request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
			mapForDs.put("serviceTypeId", serviceTypeId);
		}
		if (request.getParameter(ALLOTMENT_ID) != null
				&& !(request.getParameter(ALLOTMENT_ID).equals("0"))) {
			allotmentId = Integer.parseInt(request.getParameter(ALLOTMENT_ID));
			mapForDs.put("allotmentId", allotmentId);
		}

		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = accomodationHandlerService.getCancelGridOfficer(mapForDs);
		detailsMap = accomodationHandlerService
				.getSearchForCancelOfficer(dataMap);
		jsp = RequestConstants.SEARCH_CANCEL_OFFICER + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * method to update status for nac
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitNac(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String message = "";

		dataMap.put("box", box);

		boolean flag = false;
		try {
			flag = accomodationHandlerService.submitNac(box, dataMap);

			if (flag == false) {
				message = "Successfully Accepted ";
			} else {
				message = "Some Problem occured.";
			}
		} catch (Exception e) {
			//System.out.println("[][][][][][ " + e);
		}

		String jsp = RequestConstants.MESSAGE_ACCOMODATION + ".jsp";
		url = "/hms/hms/accom?method=searchNac";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("url", url);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------- method for report
	 */
	@SuppressWarnings("unchecked")
	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showMarriageAccomodationReg(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		jsp = "marriageAccomRegistration";
		jsp += ".jsp";
		title = "Married Accommodation Register";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView waitingRegPoolWise(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		jsp = "waitingRegPoolWise";
		jsp += ".jsp";
		title = "Waiting Register for Pool Wise";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView generateWaitingRegisterPoolWise(
			HttpServletRequest request, HttpServletResponse response) {
		String query = "";
		String category = "";

		try {
			if (request.getParameter(RequestConstants.CATEGORY_NAME) != null
					&& !(request.getParameter(RequestConstants.CATEGORY_NAME)
							.equals(""))) {
				category = (request
						.getParameter(RequestConstants.CATEGORY_NAME));
			}

			query = " where accom_registration.reg_type = '" + category + "'";
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = accomodationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("QUERY", query);
		try {

			if (category.equalsIgnoreCase("o")) {
				HMSUtil.generateReport("wating_list_register_off", parameters,
						(Connection) detailsMap.get("con"), response,
						getServletContext());
			} else if (category.equalsIgnoreCase("a")) {
				HMSUtil.generateReport("Wating_List_Register_airmen",
						parameters, (Connection) detailsMap.get("con"),
						response, getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView VacatAllotOfSmq(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		jsp = "vacateAllotOfSmq";
		jsp += ".jsp";
		title = "Vacation / Allotment of SMQ";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showAllotedList(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		map = accomodationHandlerService.showMarriageAccomodationReg(map);
		jsp = "allotedList";
		jsp += ".jsp";
		title = "Allotted list for Location wise";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showRelegationList(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		map = accomodationHandlerService.showRelegationList(map);
		jsp = "relegationList";
		jsp += ".jsp";
		title = "Relegation list";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------- method to generate report for Airmen Allotment
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView generateReportForAirmenAllotment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String allotmentNo = "";

		session = request.getSession();

		try {
			if (request.getParameter("allotmentNo") != null) {
				allotmentNo = request.getParameter("allotmentNo");
			}
			//System.out.println(allotmentNo);

			detailsMap = accomodationHandlerService.getConnectionForReport();
			parameters.put("allotmentNo", allotmentNo);
			HMSUtil.generateReport("allotment_order_airmen", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ---------------- method to generate Report for allotment of officer
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView generateReportForOfficerAllotment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String allotmentNo = "";

		session = request.getSession();

		try {
			if (request.getParameter("allotmentNo") != null) {
				allotmentNo = request.getParameter("allotmentNo");
			}

			detailsMap = accomodationHandlerService.getConnectionForReport();
			parameters.put("allotmentNo", allotmentNo);
			//System.out.println(allotmentNo + "898");

			HMSUtil.generateReport(
					"allotment_of_married_accommodation_for_officer_form",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * --------------------- method for cancellation of officer
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView generateReportForOfficerCancellation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String cancelNo = "";

		session = request.getSession();

		try {
			if (request.getParameter(RequestConstants.CANCEL_NO) != null) {
				cancelNo = request.getParameter(RequestConstants.CANCEL_NO);
			}

			detailsMap = accomodationHandlerService.getConnectionForReport();
			parameters.put("cancelNo", cancelNo);
			//System.out.println("cancelNo+++" + cancelNo);
			HMSUtil.generateReport("cancellation_for_office", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ---------------method for cancellation of Airmen
	 */
	public ModelAndView generateReportForAirmenCancellation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String cancelNo = "";

		session = request.getSession();

		try {
			if (request.getParameter(RequestConstants.CANCEL_NO) != null) {
				cancelNo = request.getParameter(RequestConstants.CANCEL_NO);
			}

			detailsMap = accomodationHandlerService.getConnectionForReport();
			parameters.put("cancelNo", cancelNo);
			HMSUtil.generateReport("cancellation_for_airmen", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ---------------- method for smq vacation of airmen
	 */

	public ModelAndView generateReportForAirmenVacation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String vacationNo = "";

		session = request.getSession();

		try {
			if (request.getParameter(RequestConstants.VACATION_NO) != null) {
				vacationNo = request.getParameter(RequestConstants.VACATION_NO);
			}

			detailsMap = accomodationHandlerService.getConnectionForReport();
			parameters.put("vacationNo", vacationNo);
			HMSUtil.generateReport("vacation_allotment_of_SMQ_airmen",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------ method for smq vacation of officer
	 */

	public ModelAndView generateReportForOfficerVacation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String vacationNo = "";

		session = request.getSession();

		try {
			if (request.getParameter(RequestConstants.VACATION_NO) != null) {
				vacationNo = request.getParameter(RequestConstants.VACATION_NO);
			}

			detailsMap = accomodationHandlerService.getConnectionForReport();
			parameters.put("vacationNo", vacationNo);
			HMSUtil.generateReport("allotment_vacation_order_sl_no",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * -------------- method to generate Nac report
	 */
	public ModelAndView generateNacReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String vacationNo = "";

		session = request.getSession();

		try {
			if (request.getParameter(RequestConstants.VACATION_NO) != null) {
				vacationNo = request.getParameter(RequestConstants.VACATION_NO);
			}

			detailsMap = accomodationHandlerService.getConnectionForReport();
			parameters.put("vacationNo", vacationNo);
			HMSUtil.generateReport("nac_for_married_accn", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void fillServiceNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<AccomRegistration> employeeList = new ArrayList<AccomRegistration>();
		String serviceNo = "";
		Box box = HMSUtil.getBox(request);
		try {
			if (request.getParameter("serviceNo") != null) {
				serviceNo = request.getParameter("serviceNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("serviceNo", serviceNo);
		box.put("serviceNo", serviceNo);
		map = accomodationHandlerService.getRecordsOfServiceNo(box);
		if (map.get("employeeList") != null) {
			employeeList = (List<AccomRegistration>) map.get("employeeList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			if (employeeList.size() > 0) {
				for (AccomRegistration masEmployee : employeeList) {

					sb.append("<item>");
					sb.append("<servicePersonName>"
							+ masEmployee.getServicePersonName()
							+ "</servicePersonName>");

					sb.append("</item>");

					break;
				}
			} else {
				sb.append("<item>");
				sb.append("<servicePersonName>" + "-" + "</servicePersonName>");

				sb.append("</item>");
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public ModelAndView showUnitSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = accomodationHandlerService.showUnitSearchJsp(box);
		jsp = "unitNameSearchMarriageAccomodation";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView generateMarriageAccomRegister(
			HttpServletRequest request, HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String category = "";
		String query = "";
		int deptId = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}
			if (request.getParameter(RequestConstants.CATEGORY_NAME) != null
					&& !(request.getParameter(RequestConstants.CATEGORY_NAME)
							.equals(""))) {
				category = (request
						.getParameter(RequestConstants.CATEGORY_NAME));
			}
			query = " where accom_registration.registration_date between '"
					+ fromDate + "' and '" + toDate
					+ "' and accom_registration.department_id ='" + deptId
					+ "' and accom_registration.reg_type = '" + category + "'";
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = accomodationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("departId", deptId);
		try {
			if (category.equalsIgnoreCase("o")) {
				HMSUtil.generateReport("Marrige_accomodation_Register_off",
						parameters, (Connection) detailsMap.get("con"),
						response, getServletContext());
			} else if (category.equalsIgnoreCase("a")) {
				HMSUtil.generateReport("marrige_accomodation_register_airmen",
						parameters, (Connection) detailsMap.get("con"),
						response, getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView generateVacateAllot(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		String category = "";
		String query = "";
		int deptId = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(RequestConstants.CATEGORY_NAME) != null
					&& !(request.getParameter(RequestConstants.CATEGORY_NAME)
							.equals(""))) {
				category = (request
						.getParameter(RequestConstants.CATEGORY_NAME));
			}

			query = " and accom_registration.registration_date = '" + fromDate
					+ " ' and accom_registration.`reg_type` = '" + category
					+ "'";
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = accomodationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("category", category);
		// parameters.put("QUERY", query);
		parameters.put("deptId", deptId);
		try {

			if (category.equalsIgnoreCase("o")) {
				HMSUtil.generateReport("vacation_allotment_of_SMQ_off",
						parameters, (Connection) detailsMap.get("con"),
						response, getServletContext());
			} else if (category.equalsIgnoreCase("a")) {
				HMSUtil.generateReport("vacation_allotment_of_SMQ_airmen",
						parameters, (Connection) detailsMap.get("con"),
						response, getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView generateReportForAllotedList(
			HttpServletRequest request, HttpServletResponse response) {
		String query = "";
		int locationId = 0;
		String category = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		int deptid = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptid = Integer.parseInt("" + session.getAttribute("deptId"));

		try {
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !(request.getParameter(RequestConstants.FROM_DATE)
							.equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !(request.getParameter(RequestConstants.TO_DATE)
							.equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.TO_DATE));
			}
			if (request.getParameter(RequestConstants.CATEGORY_NAME) != null
					&& !(request.getParameter(RequestConstants.CATEGORY_NAME)
							.equals(""))) {
				category = (request
						.getParameter(RequestConstants.CATEGORY_NAME));
			}

			if (request.getParameter(RequestConstants.LOCATION_ID) != null
					&& !(request.getParameter(RequestConstants.LOCATION_ID)
							.equals(""))) {
				locationId = Integer.parseInt((request
						.getParameter(RequestConstants.LOCATION_ID)));
			}
			//System.out.println("fromDate -- :  " + fromDate);
			//System.out.println("toDate -- :  " + toDate);
			query = " and accom_registration.`registration_date` between '"
					+ fromDate + "' and '" + toDate + "'";
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = accomodationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("allotedfromdate", fromDate);
		parameters.put("allotedtodate", toDate);
		parameters.put("location", locationId);
		parameters.put("deptId", deptid);

		//System.out.println(locationId);
		try {

			HMSUtil.generateReport("Alloted_List_for_period", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView generateRelegationReport(HttpServletRequest request,
			HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		int rankId = 0;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}
			if (request.getParameter(RANK_ID) != null
					&& !(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt((request.getParameter(RANK_ID)));
			}
			query = "where relegation_process.`relegation_date` between '"
					+ fromDate + "'and '" + toDate
					+ "' and   accom_registration.`rank_id` = '" + rankId + "'";
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = accomodationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("Relegation_List", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
