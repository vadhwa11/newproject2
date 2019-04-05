package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.BABY_STATUS_JSP;
import static jkt.hms.util.RequestConstants.BED_STATUS_JSP;
import static jkt.hms.util.RequestConstants.BODY_PART_JSP;
import static jkt.hms.util.RequestConstants.CARE_TYPE_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DELIVERY_JSP;
import static jkt.hms.util.RequestConstants.DESCRIPTION;
import static jkt.hms.util.RequestConstants.DISCHARGE_ITEMS_CATEGORY;
import static jkt.hms.util.RequestConstants.DISCHARGE_ITEMS_CATEGORY_JSP;
import static jkt.hms.util.RequestConstants.DISCHARGE_ITEMS_ID;
import static jkt.hms.util.RequestConstants.DISCHARGE_ITEMS_JSP;
import static jkt.hms.util.RequestConstants.DISCHARGE_STATUS_JSP;
import static jkt.hms.util.RequestConstants.DISPOSED_TO_JSP;
import static jkt.hms.util.RequestConstants.INJURY_NATURE_JSP;
import static jkt.hms.util.RequestConstants.LABEL_DATA_TYPE;
import static jkt.hms.util.RequestConstants.ORDER_NO;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.DischargeItems;
import jkt.hms.masters.business.DischargeItemsCategory;
import jkt.hms.masters.business.MasBabyStatus;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasBodyPart;
import jkt.hms.masters.business.MasCareType;
import jkt.hms.masters.business.MasDelivery;
import jkt.hms.masters.business.MasDischargeStatus;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasInjuryNature;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.InPatientMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class InPatientMasterController extends MultiActionController {

	InPatientMasterHandlerService inPatientMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	String jsp = "";
	String title = "";
	String message = "";
	String url = "";
	String code = "";
	String name = "";
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String currentDate = "";
	String currentTime = "";
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String userName = "";

	// ------------------------------------------ Bed Status
	// -------------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showBedStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = (Map<String, Object>) inPatientMasterHandlerService
				.showBedStatusJsp();
		@SuppressWarnings("unused")
		ArrayList searchBedStatusList = (ArrayList) map
				.get("searchBedStatusList");
		jsp = BED_STATUS_JSP;
		jsp += ".jsp";
		title = "Bed Status";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchBedStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String bedStatusCode = null;
		String bedStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bedStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bedStatusName = request.getParameter(SEARCH_NAME);
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
			bedStatusCode = searchField;
			bedStatusName = null;
		} else {
			bedStatusCode = null;
			bedStatusName = searchField;
		}
		map = inPatientMasterHandlerService.searchBedStatus(bedStatusCode,
				bedStatusName);
		jsp = BED_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bedStatusCode", bedStatusCode);
		map.put("bedStatusName", bedStatusName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBedStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBedStatus masBedStatus = new MasBedStatus();

		String changedBy = "";
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
		List bedStatusCodeList = new ArrayList();
		List bedStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bedStatusCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			bedStatusNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((bedStatusCodeList.size() == 0 || bedStatusCodeList == null)
				&& (bedStatusNameList.size() == 0 || bedStatusNameList == null)) {
			masBedStatus.setBedStatusCode(code);
			masBedStatus.setBedStatusName(name);
			masBedStatus.setStatus("y");
			masBedStatus.setLastChgBy(changedBy);
			masBedStatus.setLastChgDate(currentDate);
			masBedStatus.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addBedStatus(masBedStatus);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";
			}
		}

		else if ((bedStatusCodeList.size() != 0 || bedStatusCodeList != null)
				|| (bedStatusNameList.size() != 0) || bedStatusNameList != null) {
			if ((bedStatusCodeList.size() != 0 || bedStatusCodeList != null)
					&& (bedStatusNameList.size() == 0 || bedStatusNameList == null)) {
				message = "Bed Status Code  already exists.";
			} else if ((bedStatusNameList.size() != 0 || bedStatusNameList != null)
					&& (bedStatusCodeList.size() == 0 || bedStatusCodeList == null)) {
				message = "Bed Status Name already exists.";
			} else if ((bedStatusCodeList.size() != 0 || bedStatusCodeList != null)
					&& (bedStatusNameList.size() != 0 || bedStatusNameList != null)) {
				message = "Bed Status Code and Bed Status Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showBedStatusJsp";
		try {
			map = inPatientMasterHandlerService.showBedStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BED_STATUS_JSP;
		title = "Add BedStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editBedStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String bedStatusCode = "";
		String bedStatusName = "";
		int bedStatusId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bedStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bedStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bedStatusName = request.getParameter(SEARCH_NAME);
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
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", bedStatusId);
		generalMap.put("bedStatusCode", bedStatusCode);
		generalMap.put("name", bedStatusName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBedStatusNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBedStatusNameList.size() == 0) {
			dataUpdated = inPatientMasterHandlerService
					.editBedStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be Updated !!";
			}
		} else if (existingBedStatusNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showBedStatusJsp";
		try {
			map = inPatientMasterHandlerService.showBedStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BED_STATUS_JSP;
		title = "update BedStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteBedStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int bedStatusId = 0;
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
			bedStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = inPatientMasterHandlerService.deleteBedStatus(
				bedStatusId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showBedStatusJsp";
		try {
			map = inPatientMasterHandlerService.showBedStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BED_STATUS_JSP;
		title = "delete BedStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -------------------------------------- Injury Nature
	// -------------------------------------------------

	public ModelAndView searchInjuryNature(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String injuryNatureCode = null;
		String injuryNatureName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			injuryNatureCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			injuryNatureName = request.getParameter(SEARCH_NAME);
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
			injuryNatureCode = searchField;
			injuryNatureName = null;

		} else {
			injuryNatureCode = null;
			injuryNatureName = searchField;
		}
		map = inPatientMasterHandlerService.searchInjuryNature(
				injuryNatureCode, injuryNatureName);

		jsp = INJURY_NATURE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("injuryNatureCode", injuryNatureCode);
		map.put("injuryNatureName", injuryNatureName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showInjuryNatureJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showInjuryNatureJsp();
		@SuppressWarnings("unused")
		ArrayList searchInjuryNatureList = (ArrayList) map
				.get("searchInjuryNatureList");
		jsp = INJURY_NATURE_JSP;
		jsp += ".jsp";
		title = "InjuryNature";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addInjuryNature(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasInjuryNature masInjuryNature = new MasInjuryNature();

		String changedBy = "";
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

		List injuryNatureCodeList = new ArrayList();
		List injuryNatureNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			injuryNatureCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			injuryNatureNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((injuryNatureNameList.size() == 0 || injuryNatureNameList == null)
				&& (injuryNatureNameList.size() == 0 || injuryNatureNameList == null)) {
			masInjuryNature.setInjuryNatureCode(code);
			masInjuryNature.setInjuryNatureName(name);
			masInjuryNature.setStatus("y");
			masInjuryNature.setLastChgBy(changedBy);
			masInjuryNature.setLastChgDate(currentDate);
			masInjuryNature.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addInjuryNature(masInjuryNature);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((injuryNatureCodeList.size() != 0 || injuryNatureCodeList != null)
				|| (injuryNatureNameList.size() != 0)
				|| injuryNatureNameList != null) {

			if ((injuryNatureCodeList.size() != 0 || injuryNatureCodeList != null)
					&& (injuryNatureNameList.size() == 0 || injuryNatureNameList == null)) {

				message = "Injury Nature Code  already exists.";
			} else if ((injuryNatureNameList.size() != 0 || injuryNatureNameList != null)
					&& (injuryNatureCodeList.size() == 0 || injuryNatureCodeList == null)) {

				message = "Injury Nature Name already exists.";
			} else if ((injuryNatureCodeList.size() != 0 || injuryNatureCodeList != null)
					&& (injuryNatureNameList.size() != 0 || injuryNatureNameList != null)) {

				message = "Injury Nature Code and Injury Nature Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showInjuryNatureJsp";
		try {
			map = inPatientMasterHandlerService.showInjuryNatureJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = INJURY_NATURE_JSP;
		title = "Add Injury Nature";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editInjuryNature(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String injuryNatureCode = "";
		String injuryNatureName = "";
		int injuryNatureId = 0;
		String changedBy = "";

		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		injuryNatureCode = (String) session.getAttribute("injuryNatureCode");
		injuryNatureName = (String) session.getAttribute("injuryNatureName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			injuryNatureId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			injuryNatureCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			injuryNatureName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", injuryNatureId);
		generalMap.put("injuryNatureCode", injuryNatureCode);
		generalMap.put("name", injuryNatureName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingInjuryNatureNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingInjuryNatureNameList.size() == 0) {
			dataUpdated = inPatientMasterHandlerService
					.editInjuryNatureToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingInjuryNatureNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showInjuryNatureJsp";
		try {
			map = inPatientMasterHandlerService.showInjuryNatureJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = INJURY_NATURE_JSP;
		title = "Edit Injury Nature";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteInjuryNature(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int injuryNatureId = 0;
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
			injuryNatureId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = inPatientMasterHandlerService.deleteInjuryNature(
				injuryNatureId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showInjuryNatureJsp";
		try {
			map = inPatientMasterHandlerService.showInjuryNatureJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = INJURY_NATURE_JSP;
		title = "Delete Injury Nature";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -------------------------------------- Baby Status
	// -----------------------------------------------
	public ModelAndView searchBabyStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String babyStatusCode = null;
		String babyStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			babyStatusCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			babyStatusName = request.getParameter(SEARCH_NAME);
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
			babyStatusCode = searchField;
			babyStatusName = null;
		} else {
			babyStatusCode = null;
			babyStatusName = searchField;
		}
		map = inPatientMasterHandlerService.searchBabyStatus(babyStatusCode,
				babyStatusName);
		jsp = BABY_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("babyStatusCode", babyStatusCode);
		map.put("babyStatusName", babyStatusName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showBabyStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showBabyStatusJsp();
		@SuppressWarnings("unused")
		ArrayList searchBabyStatusList = (ArrayList) map
				.get("searchBabyStatusList");
		jsp = BABY_STATUS_JSP;
		jsp += ".jsp";
		title = "BabyStatus";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBabyStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBabyStatus masBabyStatus = new MasBabyStatus();

		String changedBy = "";
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

		List babyStatusCodeList = new ArrayList();
		List babyStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			babyStatusCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			babyStatusNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;
		if ((babyStatusNameList.size() == 0 || babyStatusNameList == null)
				&& (babyStatusNameList.size() == 0 || babyStatusNameList == null)) {
			masBabyStatus.setBabyStatusCode(code);
			masBabyStatus.setBabyStatusName(name);
			masBabyStatus.setStatus("y");
			masBabyStatus.setLastChgBy(changedBy);
			masBabyStatus.setLastChgDate(currentDate);
			masBabyStatus.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addBabyStatus(masBabyStatus);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((babyStatusCodeList.size() != 0 || babyStatusCodeList != null)
				|| (babyStatusNameList.size() != 0)
				|| babyStatusNameList != null) {

			if ((babyStatusCodeList.size() != 0 || babyStatusCodeList != null)
					&& (babyStatusNameList.size() == 0 || babyStatusNameList == null)) {

				message = "Baby Status Code  already exists.";
			} else if ((babyStatusNameList.size() != 0 || babyStatusNameList != null)
					&& (babyStatusCodeList.size() == 0 || babyStatusCodeList == null)) {

				message = "Baby Status Name already exists.";
			} else if ((babyStatusCodeList.size() != 0 || babyStatusCodeList != null)
					&& (babyStatusNameList.size() != 0 || babyStatusNameList != null)) {

				message = "Baby Status Code and Baby Status Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showBabyStatusJsp";

		try {
			map = inPatientMasterHandlerService.showBabyStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BABY_STATUS_JSP;
		title = "Add Baby Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editBabyStatus(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String babyStatusCode = "";
		String babyStatusName = "";
		int babyStatusId = 0;
		String changedBy = "";

		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			babyStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			babyStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			babyStatusName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);

		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", babyStatusId);
		generalMap.put("babyStatusCode", babyStatusCode);
		generalMap.put("name", babyStatusName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBabyStatusNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBabyStatusNameList.size() == 0) {
			dataUpdated = inPatientMasterHandlerService
					.editBabyStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingBabyStatusNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showBabyStatusJsp";

		try {
			map = inPatientMasterHandlerService.showBabyStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BABY_STATUS_JSP;
		title = "Edit Baby Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteBabyStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int babyStatusId = 0;
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
			babyStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = inPatientMasterHandlerService.deleteBabyStatus(
				babyStatusId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showBabyStatusJsp";
		try {
			map = inPatientMasterHandlerService.showBabyStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BABY_STATUS_JSP;
		title = "Delete Baby Status";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ------------------------ Delivery
	// ------------------------------------------
	public ModelAndView searchDelivery(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String deliveryCode = null;
		String deliveryName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			deliveryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			deliveryName = request.getParameter(SEARCH_NAME);
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
			deliveryCode = searchField;
			deliveryName = null;

		} else {
			deliveryCode = null;
			deliveryName = searchField;
		}

		map = inPatientMasterHandlerService.searchDelivery(deliveryCode,
				deliveryName);

		jsp = DELIVERY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deliveryCode", deliveryCode);
		map.put("deliveryName", deliveryName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDeliveryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		map = inPatientMasterHandlerService.showDeliveryJsp();
		String jsp = DELIVERY_JSP;
		jsp += ".jsp";
		title = "Delivery";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDelivery(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasDelivery masDelivery = new MasDelivery();

		String changedBy = "";
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
		List deliveryCodeList = new ArrayList();
		List deliveryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			deliveryCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			deliveryNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((deliveryNameList.size() == 0 || deliveryNameList == null)
				&& (deliveryNameList.size() == 0 || deliveryNameList == null)) {
			masDelivery.setDeliveryCode(code);
			masDelivery.setDeliveryName(name);
			masDelivery.setStatus("y");
			masDelivery.setLastChgBy(changedBy);
			masDelivery.setLastChgDate(currentDate);
			masDelivery.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addDelivery(masDelivery);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((deliveryCodeList.size() != 0 || deliveryCodeList != null)
				|| (deliveryNameList.size() != 0) || deliveryNameList != null) {
			if ((deliveryCodeList.size() != 0 || deliveryCodeList != null)
					&& (deliveryNameList.size() == 0 || deliveryNameList == null)) {
				message = "Delivery Code  already exists.";
			} else if ((deliveryNameList.size() != 0 || deliveryNameList != null)
					&& (deliveryCodeList.size() == 0 || deliveryCodeList == null)) {

				message = "Delivery Name already exists.";
			} else if ((deliveryCodeList.size() != 0 || deliveryCodeList != null)
					&& (deliveryNameList.size() != 0 || deliveryNameList != null)) {

				message = "Delivery Code and Delivery Name already exist.";
			}
		}

		try {
			map = inPatientMasterHandlerService.showDeliveryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DELIVERY_JSP;
		title = "Add Delivery";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editDelivery(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deliveryCode = "";
		String deliveryName = "";
		int deliveryId = 0;
		String changedBy = "";

		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		deliveryCode = (String) session.getAttribute("deliveryCode");
		deliveryName = (String) session.getAttribute("deliveryName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			deliveryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			deliveryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			deliveryName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", deliveryId);
		generalMap.put("deliveryCode", deliveryCode);
		generalMap.put("name", deliveryName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDeliveryNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDeliveryNameList.size() == 0) {

			dataUpdated = inPatientMasterHandlerService
					.editDeliveryToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingDeliveryNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatient?method=showDeliveryJsp";

		try {
			map = inPatientMasterHandlerService.showDeliveryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DELIVERY_JSP;
		title = "update Delivery";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteDelivery(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deliveryId = 0;
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
			deliveryId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = inPatientMasterHandlerService.deleteDelivery(deliveryId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatient?method=showDeliveryJsp";

		try {
			map = inPatientMasterHandlerService.showDeliveryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DELIVERY_JSP;
		title = "delete Delivery";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -------------------------Care Type--------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showCareTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showCareTypeJsp();
		jsp = CARE_TYPE_JSP;
		jsp += ".jsp";
		title = "CareType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchCareType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String careTypeCode = null;
		String careTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			careTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			careTypeName = request.getParameter(SEARCH_NAME);
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
			careTypeCode = searchField;
			careTypeName = null;

		} else {
			careTypeCode = null;
			careTypeName = searchField;
		}
		map = inPatientMasterHandlerService.searchCareType(careTypeCode,
				careTypeName);
		jsp = CARE_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("careTypeCode", careTypeCode);
		map.put("careTypeName", careTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCareType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasCareType masCareType = new MasCareType();
		String changedBy = "";
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

		List careTypeCodeList = new ArrayList();
		List careTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			careTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			careTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((careTypeCodeList.size() == 0 || careTypeCodeList == null)
				&& (careTypeNameList.size() == 0 || careTypeNameList == null)) {
			masCareType.setCareTypeCode(code);
			masCareType.setCareTypeName(name);
			masCareType.setStatus("y");
			masCareType.setLastChgBy(changedBy);
			masCareType.setLastChgDate(currentDate);
			masCareType.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addCareType(masCareType);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((careTypeCodeList.size() != 0 || careTypeCodeList != null)
				|| (careTypeNameList.size() != 0) || careTypeNameList != null) {
			if ((careTypeCodeList.size() != 0 || careTypeCodeList != null)
					&& (careTypeNameList.size() == 0 || careTypeNameList == null)) {
				message = "Care Type Code  already exists.";
			} else if ((careTypeNameList.size() != 0 || careTypeNameList != null)
					&& (careTypeCodeList.size() == 0 || careTypeCodeList == null)) {
				message = "Care Type Name already exists.";
			} else if ((careTypeCodeList.size() != 0 || careTypeCodeList != null)
					&& (careTypeNameList.size() != 0 || careTypeNameList != null)) {
				message = "Care Type Code and Care Type Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showCareTypeJsp";
		try {
			map = inPatientMasterHandlerService.showCareTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CARE_TYPE_JSP;
		title = "Add CareType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editCareType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String careTypeCode = "";
		String careTypeName = "";
		int careTypeId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		careTypeCode = (String) session.getAttribute("careTypeCode");
		careTypeName = (String) session.getAttribute("careTypeName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			careTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			careTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			careTypeName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", careTypeId);
		generalMap.put("careTypeCode", careTypeCode);
		generalMap.put("name", careTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCareTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingCareTypeNameList.size() == 0) {

			dataUpdated = inPatientMasterHandlerService
					.editCareTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCareTypeNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showCareTypeJsp";
		try {
			map = inPatientMasterHandlerService.showCareTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CARE_TYPE_JSP;
		title = "Update CareType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteCareType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int careTypeId = 0;
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
			careTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = inPatientMasterHandlerService.deleteCareType(careTypeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showCareTypeJsp";
		try {
			map = inPatientMasterHandlerService.showCareTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CARE_TYPE_JSP;
		title = "Delete CareType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------------------------Disposed
	// TO-------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showDisposedToJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showDisposedToJsp();
		jsp = DISPOSED_TO_JSP;
		jsp += ".jsp";
		title = "DisposedTo";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchDisposedTo(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String disposedToCode = null;
		String disposedToName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			disposedToCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			disposedToName = request.getParameter(SEARCH_NAME);
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
			disposedToCode = searchField;
			disposedToName = null;

		} else {
			disposedToCode = null;
			disposedToName = searchField;
		}
		map = inPatientMasterHandlerService.searchDisposedTo(disposedToCode,
				disposedToName);
		jsp = DISPOSED_TO_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("disposedToCode", disposedToCode);
		map.put("disposedToName", disposedToName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDisposedTo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasDisposedTo masDisposedTo = new MasDisposedTo();
		String changedBy = "";
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

		List disposedToCodeList = new ArrayList();
		List disposedToNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			disposedToCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			disposedToNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((disposedToCodeList.size() == 0 || disposedToCodeList == null)
				&& (disposedToNameList.size() == 0 || disposedToNameList == null)) {
			masDisposedTo.setDisposedToCode(code);
			masDisposedTo.setDisposedToName(name);
			masDisposedTo.setStatus("y");
			masDisposedTo.setLastChgBy(changedBy);
			masDisposedTo.setLastChgDate(currentDate);
			masDisposedTo.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addDisposedTo(masDisposedTo);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((disposedToCodeList.size() != 0 || disposedToCodeList != null)
				|| (disposedToNameList.size() != 0)
				|| disposedToNameList != null) {
			if ((disposedToCodeList.size() != 0 || disposedToCodeList != null)
					&& (disposedToNameList.size() == 0 || disposedToNameList == null)) {
				message = "DisposedTo Code  already exists.";
			} else if ((disposedToNameList.size() != 0 || disposedToNameList != null)
					&& (disposedToCodeList.size() == 0 || disposedToCodeList == null)) {
				message = "DisposedTo Name already exists.";
			} else if ((disposedToCodeList.size() != 0 || disposedToCodeList != null)
					&& (disposedToNameList.size() != 0 || disposedToNameList != null)) {
				message = "DisposedTo Code and DisposedTo Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showDisposedToJsp";
		try {
			map = inPatientMasterHandlerService.showDisposedToJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISPOSED_TO_JSP;
		title = "Add DisposedTo";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editDisposedTo(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String disposedToCode = "";
		String disposedToName = "";
		int disposedToId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		disposedToCode = (String) session.getAttribute("disposedToCode");
		disposedToName = (String) session.getAttribute("disposedToName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			disposedToId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			disposedToCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			disposedToName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", disposedToId);
		generalMap.put("disposedToCode", disposedToCode);
		generalMap.put("name", disposedToName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDisposedToNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDisposedToNameList.size() == 0) {

			dataUpdated = inPatientMasterHandlerService
					.editDisposedToToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingDisposedToNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showDisposedToJsp";
		try {
			map = inPatientMasterHandlerService.showDisposedToJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISPOSED_TO_JSP;
		title = "Update DisposedTo";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteDisposedTo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int disposedToId = 0;
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
			disposedToId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = inPatientMasterHandlerService.deleteDisposedTo(
				disposedToId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showDisposedToJsp";
		try {
			map = inPatientMasterHandlerService.showDisposedToJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISPOSED_TO_JSP;
		title = "Delete DisposedTo";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -----------------------------------Body
	// Part---------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showBodyPartJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showBodyPartJsp();
		jsp = BODY_PART_JSP;
		jsp += ".jsp";
		title = "bodyPart";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchBodyPart(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String bodyPartCode = null;
		String bodyPartName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bodyPartCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bodyPartName = request.getParameter(SEARCH_NAME);
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
			bodyPartCode = searchField;
			bodyPartName = null;

		} else {
			bodyPartCode = null;
			bodyPartName = searchField;
		}
		map = inPatientMasterHandlerService.searchBodyPart(bodyPartCode,
				bodyPartName);
		jsp = BODY_PART_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bodyPartCode", bodyPartCode);
		map.put("bodyPartName", bodyPartName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBodyPart(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBodyPart masBodyPart = new MasBodyPart();

		String changedBy = "";
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
		List bodyPartCodeList = new ArrayList();
		List bodyPartNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bodyPartCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			bodyPartNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((bodyPartCodeList.size() == 0 || bodyPartCodeList == null)
				&& (bodyPartNameList.size() == 0 || bodyPartNameList == null)) {
			masBodyPart.setBodyPartCode(code);
			masBodyPart.setBodyPartName(name);
			masBodyPart.setStatus("y");
			masBodyPart.setLastChgBy(changedBy);
			masBodyPart.setLastChgDate(currentDate);
			masBodyPart.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addBodyPart(masBodyPart);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";
			}
		}

		else if ((bodyPartCodeList.size() != 0 || bodyPartCodeList != null)
				|| (bodyPartNameList.size() != 0) || bodyPartNameList != null) {
			if ((bodyPartCodeList.size() != 0 || bodyPartCodeList != null)
					&& (bodyPartNameList.size() == 0 || bodyPartNameList == null)) {
				message = "BodyPart Code  already exists.";
			} else if ((bodyPartNameList.size() != 0 || bodyPartNameList != null)
					&& (bodyPartCodeList.size() == 0 || bodyPartCodeList == null)) {
				message = "BodyPart Name already exists.";
			} else if ((bodyPartCodeList.size() != 0 || bodyPartCodeList != null)
					&& (bodyPartNameList.size() != 0 || bodyPartNameList != null)) {
				message = "BodyPart Code and BodyPart Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showBedStatusJsp";
		try {
			map = inPatientMasterHandlerService.showBodyPartJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BODY_PART_JSP;
		title = "Add BodyPart";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editBodyPart(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String bodyPartCode = "";
		String bodyPartName = "";
		int bodyPartId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bodyPartId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bodyPartCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bodyPartName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", bodyPartId);
		generalMap.put("bodyPartCode", bodyPartCode);
		generalMap.put("name", bodyPartName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBodyPartNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBodyPartNameList.size() == 0) {

			dataUpdated = inPatientMasterHandlerService
					.editBodyPartToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBodyPartNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showBodyPartJsp";
		try {
			map = inPatientMasterHandlerService.showBodyPartJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BODY_PART_JSP;
		title = "Update BodyPart";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteBodyPart(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int bodyPartId = 0;
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
			bodyPartId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = inPatientMasterHandlerService.deleteBodyPart(bodyPartId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showBodyPartJsp";
		try {
			map = inPatientMasterHandlerService.showBodyPartJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BODY_PART_JSP;
		title = "Delete BodyPart";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ------------------------------------------ Discharge Status
	// -------------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showDischargeStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showDischargeStatusJsp();
		jsp = DISCHARGE_STATUS_JSP;
		jsp += ".jsp";
		title = "DischargeStatus";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchDischargeStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String dischargeStatusCode = null;
		String dischargeStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			dischargeStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dischargeStatusName = request.getParameter(SEARCH_NAME);
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
			dischargeStatusCode = searchField;
			dischargeStatusName = null;

		} else {
			dischargeStatusCode = null;
			dischargeStatusName = searchField;
		}
		map = inPatientMasterHandlerService.searchDischargeStatus(
				dischargeStatusCode, dischargeStatusName);
		jsp = DISCHARGE_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("dischargeStatusCode", dischargeStatusCode);
		map.put("dischargeStatusName", dischargeStatusName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDischargeStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasDischargeStatus masDischargeStatus = new MasDischargeStatus();
		String changedBy = "";
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

		List dischargeStatusCodeList = new ArrayList();
		List dischargeStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			dischargeStatusCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			dischargeStatusNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((dischargeStatusCodeList.size() == 0 || dischargeStatusCodeList == null)
				&& (dischargeStatusNameList.size() == 0 || dischargeStatusNameList == null)) {
			masDischargeStatus.setDischargeStatusCode(code);
			masDischargeStatus.setDischargeStatusName(name);
			masDischargeStatus.setStatus("y");
			masDischargeStatus.setLastChgBy(changedBy);
			masDischargeStatus.setLastChgDate(currentDate);
			masDischargeStatus.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addDischargeStatus(masDischargeStatus);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((dischargeStatusCodeList.size() != 0 || dischargeStatusCodeList != null)
				|| (dischargeStatusNameList.size() != 0)
				|| dischargeStatusNameList != null) {
			if ((dischargeStatusCodeList.size() != 0 || dischargeStatusCodeList != null)
					&& (dischargeStatusNameList.size() == 0 || dischargeStatusNameList == null)) {
				message = "DS Code  already exists.";
			} else if ((dischargeStatusNameList.size() != 0 || dischargeStatusNameList != null)
					&& (dischargeStatusCodeList.size() == 0 || dischargeStatusCodeList == null)) {
				message = "DS Name already exists.";
			} else if ((dischargeStatusCodeList.size() != 0 || dischargeStatusCodeList != null)
					&& (dischargeStatusNameList.size() != 0 || dischargeStatusNameList != null)) {
				message = "DS Code and DS Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeStatusJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_STATUS_JSP;
		title = "Add DischargeStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editDischargeStatus(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String dischargeStatusCode = "";
		String dischargeStatusName = "";
		int dischargeStatusId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dischargeStatusId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			dischargeStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dischargeStatusName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", dischargeStatusId);
		generalMap.put("dischargeStatusCode", dischargeStatusCode);
		generalMap.put("name", dischargeStatusName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDischargeStatusNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDischargeStatusNameList.size() == 0) {

			dataUpdated = inPatientMasterHandlerService
					.editDischargeStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingDischargeStatusNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeStatusJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_STATUS_JSP;
		title = "Update DischargeStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteDischargeStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int dischargeStatusId = 0;
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
			dischargeStatusId = Integer.parseInt(request
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
		dataDeleted = inPatientMasterHandlerService.deleteDischargeStatus(
				dischargeStatusId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeStatusJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_STATUS_JSP;
		title = "Delete DischargeStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -----------------------DischargeItems-------------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showDischargeItemsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showDischargeItemsJsp();
		jsp = DISCHARGE_ITEMS_JSP;
		jsp += ".jsp";
		title = "DischargeItems";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchDischargeItems(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String itemCode = null;
		String itemName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			itemCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			itemName = request.getParameter(SEARCH_NAME);
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
			itemCode = searchField;
			itemName = null;

		} else {
			itemCode = null;
			itemName = searchField;
		}
		map = inPatientMasterHandlerService.searchDischargeItems(itemCode,
				itemName);
		jsp = DISCHARGE_ITEMS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("itemCode", itemCode);
		map.put("itemName", itemName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDischargeItems(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		DischargeItems dischargeItems = new DischargeItems();
		String changedBy = "";
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

		List itemCodeList = new ArrayList();
		List itemNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			itemCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			itemNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((itemCodeList.size() == 0 || itemCodeList == null)
				&& (itemNameList.size() == 0 || itemNameList == null)) {
			dischargeItems.setItemCode(code);
			dischargeItems.setItemDesc(name);
			dischargeItems.setStatus("y");
			dischargeItems.setLastChgBy(changedBy);
			dischargeItems.setLastChgDate(currentDate);
			dischargeItems.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addDischargeItems(dischargeItems);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((itemCodeList.size() != 0 || itemCodeList != null)
				|| (itemNameList.size() != 0) || itemNameList != null) {
			if ((itemCodeList.size() != 0 || itemCodeList != null)
					&& (itemNameList.size() == 0 || itemNameList == null)) {
				message = "DischargeItem Code  already exists.";
			} else if ((itemNameList.size() != 0 || itemNameList != null)
					&& (itemCodeList.size() == 0 || itemCodeList == null)) {
				message = "DischargeItem Name already exists.";
			} else if ((itemCodeList.size() != 0 || itemCodeList != null)
					&& (itemNameList.size() != 0 || itemNameList != null)) {
				message = "DischargeItem Code and DischargeItem Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeItemsJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeItemsJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_ITEMS_JSP;
		title = "Add DischargeItem";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editDischargeItems(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String itemCode = "";
		String itemName = "";
		int itemId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			itemCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			itemName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", itemId);
		generalMap.put("itemCode", itemCode);
		generalMap.put("name", itemName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingRelationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingRelationNameList.size() == 0) {

			dataUpdated = inPatientMasterHandlerService
					.editDischargeItemsToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingRelationNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeItemsJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeItemsJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_ITEMS_JSP;
		title = "Update DischargeItem";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteDischargeItems(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int itemId = 0;
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
			itemId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = inPatientMasterHandlerService.deleteDischargeItems(
				itemId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeItemsJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeItemsJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_ITEMS_JSP;
		title = "Delete DischargeItem";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -----------------------DischargeItems
	// Category------------------------------------------------

	public ModelAndView showDischargeCategoryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showDischargeCategoryJsp();
		jsp = DISCHARGE_ITEMS_CATEGORY_JSP;
		jsp += ".jsp";
		title = "DischargeItemCategory";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView addDischargeItemsCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		DischargeItemsCategory dischargeItemsCategory = new DischargeItemsCategory();
		int itemCode = 0;
		String dischargeCategory = null;
		String description = null;
		String labelDataType = null;
		int orderNo = 0;
		Date changedDate = null;
		String changedBy = "";
		String changedTime = "";

		if (request.getParameter(DISCHARGE_ITEMS_ID) != null) {
			itemCode = Integer.parseInt(request
					.getParameter(DISCHARGE_ITEMS_ID));
		}
		if (request.getParameter(DISCHARGE_ITEMS_CATEGORY) != null) {
			dischargeCategory = request.getParameter(DISCHARGE_ITEMS_CATEGORY);
		}
		if (request.getParameter(DESCRIPTION) != null) {
			description = request.getParameter(DESCRIPTION);
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderNo = Integer.parseInt(request.getParameter(ORDER_NO));
		}
		if (request.getParameter(LABEL_DATA_TYPE) != null) {
			labelDataType = request.getParameter(LABEL_DATA_TYPE);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("jspName") != null) {
			jspName = request.getParameter("jspName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		boolean successfullyAdded = false;

		DischargeItems dischargeItems = new DischargeItems();
		dischargeItems.setId(itemCode);
		dischargeItemsCategory.setItemCode(dischargeItems);

		dischargeItemsCategory.setCategoryName(dischargeCategory);
		dischargeItemsCategory.setLabel(description);
		dischargeItemsCategory.setOrderno(orderNo);
		dischargeItemsCategory.setLabelDataType(labelDataType);
		dischargeItemsCategory.setStatus("y");
		dischargeItemsCategory.setLastChgBy(changedBy);
		dischargeItemsCategory.setLastChgDate(changedDate);
		dischargeItemsCategory.setLastChgTime(changedTime);
		successfullyAdded = inPatientMasterHandlerService
				.addDischargeItemsCategory(dischargeItemsCategory);
		if (successfullyAdded == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		try {
			map = inPatientMasterHandlerService.showDischargeCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_ITEMS_CATEGORY_JSP;
		title = "Add DischargeItemsCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editDischargeItemsCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		DischargeItemsCategory dischargeItemsCategory = new DischargeItemsCategory();
		int itemCode = 0;
		int dischargeCateogryId = 0;
		String dischargeCategory = null;
		String description = null;
		String labelDataType = null;
		int orderNo = 0;
		Date changedDate = null;
		String changedBy = "";
		String changedTime = "";
		HttpSession session = request.getSession();

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dischargeCateogryId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(DISCHARGE_ITEMS_ID) != null) {
			itemCode = Integer.parseInt(request
					.getParameter(DISCHARGE_ITEMS_ID));
		}
		if (request.getParameter(DISCHARGE_ITEMS_CATEGORY) != null) {
			dischargeCategory = request.getParameter(DISCHARGE_ITEMS_CATEGORY);
		}
		if (request.getParameter(DESCRIPTION) != null) {
			description = request.getParameter(DESCRIPTION);
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderNo = Integer.parseInt(request.getParameter(ORDER_NO));
		}
		if (request.getParameter(LABEL_DATA_TYPE) != null) {
			labelDataType = request.getParameter(LABEL_DATA_TYPE);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
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
		generalMap.put("id", dischargeCateogryId);
		generalMap.put("itemCode", itemCode);
		generalMap.put("dischargeCategory", dischargeCategory);
		generalMap.put("description", description);
		generalMap.put("orderNo", orderNo);
		generalMap.put("labelDataType", labelDataType);
		generalMap.put("dietType", labelDataType);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataUpdated = false;
		dataUpdated = inPatientMasterHandlerService
				.editDischargeItemsCategory(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeCategoryJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_ITEMS_CATEGORY_JSP;
		title = "Add DischargeItemsCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteDischargeItemsCategory(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int dischargeCateogryId = 0;
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
			dischargeCateogryId = Integer.parseInt(request
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
		dataDeleted = inPatientMasterHandlerService
				.deleteDischargeItemsCategory(dischargeCateogryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeCategoryJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_ITEMS_CATEGORY_JSP;
		title = "delete DischargeItemCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchDischargeItemsCategory(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String dischargeItem = "";
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dischargeItem = request.getParameter(SEARCH_NAME);
		}
		System.out.println("dischargeItem==in con===="+dischargeItem);
		map = inPatientMasterHandlerService
				.searchDischargeItemsCategory(dischargeItem);

		jsp = DISCHARGE_ITEMS_CATEGORY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("dischargeItem", dischargeItem);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showKitIssueJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		map = inPatientMasterHandlerService.getKitTemplateList(hospitalId);
		
		 jsp =RequestConstants.SHOW_KIT_ISSUE_JSP;
	
		 jsp += ".jsp";
		 title = "Kit Issue";
		 map.put("contentJsp", jsp);
		 map.put("title",title);
		 return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getItemListForAutoComplete(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
			}
			map.put("deptId", deptId);
			map.put("autoHint", autoHint);
			map = inPatientMasterHandlerService.getItemListForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "opd_responseInGrid";

		return new ModelAndView(jsp, "map", map);
	
	}
	
	public ModelAndView submitKitIssueMasterDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box =HMSUtil.getBox(request);
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		box.put("hospitalId", hospitalId);
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		datamap = inPatientMasterHandlerService.submitKitIssueMasterDetails(box);
		if(!box.getString("flag").equals("") && box.getString("flag").equals("kitIssue")){
			jsp ="patientKitIssue";
		}else{
		 jsp =RequestConstants.SHOW_KIT_ISSUE_JSP;
		}
		jsp += ".jsp";
		map = inPatientMasterHandlerService.getPatientDetailsForKitIssue(box);
		map.put("message", datamap.get("message"));
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showKitIssueTemplateDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		map = inPatientMasterHandlerService.showKitIssueTemplateDetails(box);
		return new ModelAndView("responseKitIssueTemplate", "map", map);
	}
	
	public ModelAndView updateKitIssueMasterDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		Box box =HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		datamap = inPatientMasterHandlerService.updateKitIssueMasterDetails(box);
		String jsp =RequestConstants.SHOW_KIT_ISSUE_JSP; 
		jsp += ".jsp";
		map = inPatientMasterHandlerService.getKitTemplateList(hospitalId);
		map.put("message", datamap.get("message"));
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteKitIssueTemplate(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		Box box =HMSUtil.getBox(request);
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		datamap = inPatientMasterHandlerService.deleteKitIssueTemplate(box);
		String jsp =RequestConstants.SHOW_KIT_ISSUE_JSP; 
		jsp += ".jsp";
		map = inPatientMasterHandlerService.getKitTemplateList(hospitalId);
		map.put("message", datamap.get("message"));
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// -----------------------------------------------------------------

	public InPatientMasterHandlerService getInPatientMasterHandlerService() {
		return inPatientMasterHandlerService;
	}

	public void setInPatientMasterHandlerService(
			InPatientMasterHandlerService inPatientMasterHandlerService) {
		this.inPatientMasterHandlerService = inPatientMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}