package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.STATUS_DISPLAY;
import static jkt.hms.util.RequestConstants.TYPE_NAME;
import static jkt.hms.util.RequestConstants.TYPE_OF_ENTRY_MASTER_JSP;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MbTypeOfEntryMaster;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.TypeOfEntryMasterHandlerService;
import jkt.hms.util.HMSUtil;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class TypeOfEntryMasterController extends MultiActionController {
	TypeOfEntryMasterHandlerService typeOfEntryMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showTypeOfEntryMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = typeOfEntryMasterHandlerService.showTypeOfEntryMasterJsp();
		jsp += TYPE_OF_ENTRY_MASTER_JSP;
		jsp += ".jsp";
		title = "TypeOfEntryMaster";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchTypeOfEntryMaster(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String typeOfEntryMasterName = null;
		String jsp = "";
		String title = "";
		if (request.getParameter(SEARCH_FIELD) != null
				&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
			typeOfEntryMasterName = request.getParameter(SEARCH_FIELD);
		}

		map = typeOfEntryMasterHandlerService
				.searchTypeOfEntryMaster(typeOfEntryMasterName);
		jsp = TYPE_OF_ENTRY_MASTER_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("typeOfEntryMasterName", typeOfEntryMasterName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTypeOfEntryMaster(HttpServletRequest request,
			HttpServletResponse response) {
		String code = "";
		String name = "";
		String status = "";
		String maxLimit = "";

		String pojoPropertyCode = "";
		String jsp = "";
		String title = "";
		String message = " ";
		String pojoName = "";
		String pojoPropertyName = "";
		String currentTime = "";

		Map<String, Object> map = new HashMap<String, Object>();
		MbTypeOfEntryMaster masTypeOfEntryMaster = new MbTypeOfEntryMaster();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(STATUS_DISPLAY) != null) {
			status = request.getParameter(STATUS_DISPLAY);
		}
		if (request.getParameter(TYPE_NAME) != null) {
			name = request.getParameter(TYPE_NAME);
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
		generalMap.put("typeOfEntryMasterName", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("status", status);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List typeOfEntryMasterCodeList = new ArrayList();
		List typeOfEntryMasterNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			typeOfEntryMasterCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			typeOfEntryMasterNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((typeOfEntryMasterCodeList.size() == 0 || typeOfEntryMasterCodeList == null)
				&& (typeOfEntryMasterNameList.size() == 0 || typeOfEntryMasterNameList == null)) {
			masTypeOfEntryMaster.setTypeName(name);
			masTypeOfEntryMaster.setStatus("y");
			masTypeOfEntryMaster.setLastChgBy(changedBy);
			masTypeOfEntryMaster.setLastChgDate(currentDate);
			masTypeOfEntryMaster.setLastChgTime(currentTime);
			successfullyAdded = typeOfEntryMasterHandlerService
					.addTypeOfEntryMaster(masTypeOfEntryMaster);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((typeOfEntryMasterCodeList.size() != 0 || typeOfEntryMasterCodeList != null)
				|| (typeOfEntryMasterNameList.size() != 0)
				|| typeOfEntryMasterNameList != null) {

			if ((typeOfEntryMasterCodeList.size() != 0 || typeOfEntryMasterCodeList != null)
					&& (typeOfEntryMasterNameList.size() == 0 || typeOfEntryMasterNameList == null)) {

				message = "TypeOfEntryMaster Code  already exists.";
			} else if ((typeOfEntryMasterNameList.size() != 0 || typeOfEntryMasterNameList != null)
					&& (typeOfEntryMasterCodeList.size() == 0 || typeOfEntryMasterCodeList == null)) {

				message = "TypeOfEntryMaster Name already exists.";
			} else if ((typeOfEntryMasterCodeList.size() != 0 || typeOfEntryMasterCodeList != null)
					&& (typeOfEntryMasterNameList.size() != 0 || typeOfEntryMasterNameList != null)) {

				message = "Work Category Code and Work Category Name already exist.";
			}
		}

		try {
			map = typeOfEntryMasterHandlerService.showTypeOfEntryMasterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TYPE_OF_ENTRY_MASTER_JSP;
		title = "Work Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editTypeOfEntryMaster(HttpServletRequest request,
			HttpServletResponse response) {

		String jsp = "";
		String title = "";
		String message = " ";

		String status = "";
		String pojoName = "";
		String pojoPropertyName = "";

		HttpSession session = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String typeOfEntryMasterName = "";
		int typeOfEntryMasterId = 0;
		String changedBy = "";

		Date changedDate = null;
		String changedTime = "";

		typeOfEntryMasterName = (String) session
				.getAttribute("typeOfEntryMasterName");

		if (request.getParameter(TYPE_NAME) != null
				&& !(request.getParameter(TYPE_NAME).equals(""))) {
			typeOfEntryMasterName = request.getParameter(TYPE_NAME);
		}
		if (request.getParameter(STATUS_DISPLAY) != null
				&& !(request.getParameter(STATUS_DISPLAY).equals(""))) {
			status = request.getParameter(STATUS_DISPLAY);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			typeOfEntryMasterId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", typeOfEntryMasterId);
		generalMap.put("status", status);
		generalMap.put("typeOfEntryMasterName", typeOfEntryMasterName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyRemark", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingTypeOfEntryMasterNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingTypeOfEntryMasterNameList.size() == 0) {

			dataUpdated = typeOfEntryMasterHandlerService
					.editTypeOfEntryMasterToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingTypeOfEntryMasterNameList.size() > 0) {

			message = "Name already exists.";
		}

		try {
			map = typeOfEntryMasterHandlerService.showTypeOfEntryMasterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TYPE_OF_ENTRY_MASTER_JSP;
		title = "Edit Department type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteTypeOfEntryMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int typeOfEntryMasterId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		String jsp = "";
		String title = "";

		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			typeOfEntryMasterId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = typeOfEntryMasterHandlerService.deleteTypeOfEntryMaster(
				typeOfEntryMasterId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}

		try {
			map = typeOfEntryMasterHandlerService.showTypeOfEntryMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TYPE_OF_ENTRY_MASTER_JSP;
		title = "Delete Work Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// ---------------------------------------------------------------------------------------------
	public TypeOfEntryMasterHandlerService getTypeOfEntryMasterHandlerService() {
		return typeOfEntryMasterHandlerService;
	}

	public void setTypeOfEntryMasterHandlerService(
			TypeOfEntryMasterHandlerService typeOfEntryMasterHandlerService) {
		this.typeOfEntryMasterHandlerService = typeOfEntryMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
