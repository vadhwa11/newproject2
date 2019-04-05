package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DEFAULT_STATUS_RADIO;
import static jkt.hms.util.RequestConstants.NURSING_CARE_JSP;
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

import jkt.hms.masters.business.MasNursingCare;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.NursingCareMasterHandlerService;
import jkt.hms.util.HMSUtil;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class NursingCareMasterController extends MultiActionController {
	NursingCareMasterHandlerService nursingCareMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	MasNursingCare masNursingCare = new MasNursingCare();

	String code = "";
	String name = "";
	String currentDate = "";
	String currentTime = "";
	String title = "";
	String jspName = "";
	String jsp = "";
	String nursingCare = "";
	String message = " ";
	String url = "";
	String viewPage = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String status = "";
	int id = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	HttpSession session = null;
	String userName = "";

	// -----------------------------------------Nursing
	// Care------------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showNursingCareJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = nursingCareMasterHandlerService.showNursingCareJsp();

		jsp = NURSING_CARE_JSP;
		jsp += ".jsp";
		nursingCare = "NursingCare";
		map.put("contentJsp", jsp);
		map.put("nursingCare", nursingCare);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchNursingCare(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String nursingCareCode = null;
		String nursingCareName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			nursingCareCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			nursingCareName = request.getParameter(SEARCH_NAME);
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
			//System.out.println("Exception --->  " + e);
		}

		if (searchRadio == 1) {
			nursingCareCode = searchField;
			nursingCareName = null;

		} else {
			nursingCareCode = null;
			nursingCareName = searchField;
		}
		map = nursingCareMasterHandlerService.searchNursingCare(
				nursingCareCode, nursingCareName);
		jsp = NURSING_CARE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("nursingCare", nursingCare);
		map.put("nursingCareCode", nursingCareCode);
		map.put("nursingCareName", nursingCareName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addNursingCare(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasNursingCare masNursingCare = new MasNursingCare();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String defaultStatus = "";
		String nursingType= "";
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEFAULT_STATUS_RADIO) != null) {
			defaultStatus = request.getParameter(DEFAULT_STATUS_RADIO);
		}
		if (request.getParameter("nursingType") != null) {
			nursingType = request.getParameter("nursingType");
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
		if (request.getParameter("nursingCare") != null) {
			nursingCare = request.getParameter("nursingCare");
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

		List nursingCareCodeList = new ArrayList();
		List nursingCareNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			nursingCareCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			nursingCareNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((nursingCareCodeList.size() == 0 || nursingCareCodeList == null)
				&& (nursingCareNameList.size() == 0 || nursingCareNameList == null)) {
			masNursingCare.setNursingCode(code);
			masNursingCare.setNursingName(name);
			masNursingCare.setNursingType(nursingType);
			masNursingCare.setDefaultStatus(defaultStatus);
			masNursingCare.setStatus("y");
			masNursingCare.setLastChgBy(changedBy);
			masNursingCare.setLastChgDate(currentDate);
			masNursingCare.setLastChgTime(currentTime);
			successfullyAdded = nursingCareMasterHandlerService
					.addNursingCare(masNursingCare);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((nursingCareCodeList.size() != 0 || nursingCareCodeList != null)
				|| (nursingCareNameList.size() != 0)
				|| nursingCareNameList != null) {
			if ((nursingCareCodeList.size() != 0 || nursingCareCodeList != null)
					&& (nursingCareNameList.size() == 0 || nursingCareNameList == null)) {
				message = "NursingCare Code  already exists.";
			} else if ((nursingCareNameList.size() != 0 || nursingCareNameList != null)
					&& (nursingCareCodeList.size() == 0 || nursingCareCodeList == null)) {
				message = "NursingCare Name already exists.";
			} else if ((nursingCareCodeList.size() != 0 || nursingCareCodeList != null)
					&& (nursingCareNameList.size() != 0 || nursingCareNameList != null)) {
				message = "NursingCare Code and NursingCare Name already exist.";
			}
		}

		url = "/hms/hms/nursing?method=showNursingCareJsp";
		try {
			map = nursingCareMasterHandlerService.showNursingCareJsp();
		} catch (Exception e) {
			//System.out.println("Exception in showNursingCareJsp " + e);
		}
		jsp = NURSING_CARE_JSP;
		nursingCare = "Add NursingCare";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("nursingCare", nursingCare);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editNursingCare(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String nursingCareCode = "";
		String nursingCareName = "";
		int nursingCareId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		String defaultStatus = "";
		String nursingType = ""; 
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			nursingCareId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			nursingCareCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			nursingCareName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEFAULT_STATUS_RADIO) != null) {
			defaultStatus = request.getParameter(DEFAULT_STATUS_RADIO);
		}
		if (request.getParameter("nursingType") != null) {
			nursingType = request.getParameter("nursingType");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("nursingCare") != null) {
			nursingCare = request.getParameter("nursingCare");
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

		generalMap.put("id", nursingCareId);
		generalMap.put("nursingCareCode", nursingCareCode);
		generalMap.put("nursingCareName", nursingCareName);
		generalMap.put("defaultStatus", defaultStatus);
		generalMap.put("nursingType", nursingType);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingOccupationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingOccupationNameList.size() == 0) {

			dataUpdated = nursingCareMasterHandlerService
					.editNursingCareToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data Updated Successfully !!";

			} else {
				message = "Data Cant be Updated !!";
			}
		} else if (existingOccupationNameList.size() > 0) {

			message = "Name already exists.";

		}
		url = "/hms/hms/nursing?method=showNursingCareJsp";
		try {
			map = nursingCareMasterHandlerService.showNursingCareJsp();
		} catch (Exception e) {
			//System.out.println("Exception in showNursingCareJsp " + e);
		}
		jsp = NURSING_CARE_JSP;
		nursingCare = "update NursingCare";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("nursingCare", nursingCare);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteNursingCare(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nursingCareId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			nursingCareId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("nursingCare") != null) {
			nursingCare = request.getParameter("nursingCare");
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
		dataDeleted = nursingCareMasterHandlerService.deleteNursingCare(
				nursingCareId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/nursing?method=showNursingCareJsp";
		try {
			map = nursingCareMasterHandlerService.showNursingCareJsp();
		} catch (Exception e) {
			//System.out.println("Exception in showNursingCareJsp " + e);
		}
		jsp = NURSING_CARE_JSP;
		nursingCare = "Delete NursingCare";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("nursingCare", nursingCare);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public NursingCareMasterHandlerService getNursingCareMasterHandlerService() {
		return nursingCareMasterHandlerService;
	}

	public void setNursingCareMasterHandlerService(
			NursingCareMasterHandlerService nursingCareMasterHandlerService) {
		this.nursingCareMasterHandlerService = nursingCareMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
}
