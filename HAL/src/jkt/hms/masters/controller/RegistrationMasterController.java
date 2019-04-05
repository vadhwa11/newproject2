package jkt.hms.masters.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.RegistrationMasterHandlerService;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class RegistrationMasterController extends MultiActionController {
	RegistrationMasterHandlerService registrationMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	MasReference masReference = new MasReference();
	String code = "";
	String name = "";
	String jspName = "";
	String jsp = "";
	String title = "";
	String message = " ";
	String url = "";
	String viewPage = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	HttpSession session = null;
	// -----------------------------------Reference By
	// Mansi----------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView addReference(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String referenceCode = "";
		String referenceName = "";
		String referenceStatus = "";
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if (request.getParameter(RequestConstants.CODE) != null
				&& !(request.getParameter(RequestConstants.CODE).equals(""))) {
			referenceCode = request.getParameter(RequestConstants.CODE);
		}
		if (request.getParameter(RequestConstants.SEARCH_NAME) != null
				&& !(request.getParameter(RequestConstants.SEARCH_NAME)
						.equals(""))) {
			referenceName = request.getParameter(RequestConstants.SEARCH_NAME);
		}
		if (request.getParameter(RequestConstants.STATUS) != null
				&& !(request.getParameter(RequestConstants.STATUS).equals(""))) {
			referenceStatus = request.getParameter(RequestConstants.STATUS);
		}
		if (request.getParameter(RequestConstants.CHANGED_BY) != null
				&& !(request.getParameter(RequestConstants.CHANGED_BY)
						.equals(""))) {
			changedBy = request.getParameter(RequestConstants.CHANGED_BY);
		}
		if (request.getParameter(RequestConstants.CHANGED_DATE) != null
				&& !(request.getParameter(RequestConstants.CHANGED_DATE)
						.equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.CHANGED_DATE));
		}
		if (request.getParameter(RequestConstants.CHANGED_TIME) != null
				&& !(request.getParameter(RequestConstants.CHANGED_TIME)
						.equals(""))) {
			changedTime = request.getParameter(RequestConstants.CHANGED_TIME);
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
		if (request.getParameter("jspName") != null) {
			jspName = request.getParameter("jspName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		generalMap.put("code", referenceCode);
		generalMap.put("name", referenceName);
		generalMap.put("status", referenceStatus);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List referenceMasterCodeList = new ArrayList();
		List referenceMasterNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			referenceMasterCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			referenceMasterNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}

		boolean dataSaved = false;
		if (((referenceMasterCodeList.size() == 0) || (referenceMasterCodeList == null))
				&& ((referenceMasterNameList.size() == 0) || referenceMasterNameList == null)) {

			masReference.setReferenceCode(referenceCode);
			masReference.setReferenceName(referenceName);
			masReference.setStatus(referenceStatus);
			masReference.setLastChgBy(changedBy);
			masReference.setLastChgDate(changedDate);
			masReference.setLastChgTime(changedTime);

			dataSaved = registrationMasterHandlerService
					.addReference(masReference);
			if (dataSaved = true) {
				message = "Reference Information Saved Successfully !! ";
			} else {
				message = "Try Again ! ";
			}

			url = "/hms/hms/common?method=showMainJsp&jspName="
					+ RequestConstants.REFERENCE_JSP;
			jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
			map.put("message", message);
			map.put("url", url);
		} else if (((referenceMasterCodeList.size() != 0) || (referenceMasterCodeList != null))
				|| ((referenceMasterNameList.size() != 0) || referenceMasterNameList != null)) {
			if ((referenceMasterNameList.size() == 0 || referenceMasterNameList == null)
					&& (referenceMasterCodeList.size() != 0 || referenceMasterCodeList != null)) {
				message = "Code is already exist.";
			} else if ((referenceMasterCodeList.size() == 0 || referenceMasterCodeList == null)
					&& ((referenceMasterNameList.size() != 0 || referenceMasterNameList != null))) {
				message = "Name is already exist.";
			}

			else if (((referenceMasterCodeList.size() != 0) || (referenceMasterCodeList != null))
					&& ((referenceMasterNameList.size() != 0) || referenceMasterNameList != null)) {

				message = "Code and Name are already exist.";

			}
			map.put("errorMessageForExistence", message);
			jsp = RequestConstants.REFERENCE_JSP;
		}

		title = "Reference";
		jsp += ".jsp";
		map.put("dataSaved", dataSaved);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView updateReference(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		int referenceId = 0;
		String referenceCode = "";
		String referenceName = "";
		String referenceStatus = "";
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(RequestConstants.COMMON_ID) != null
				&& !(request.getParameter(RequestConstants.COMMON_ID)
						.equals(""))) {
			referenceId = Integer.parseInt(request
					.getParameter(RequestConstants.COMMON_ID));
		}
		if (request.getParameter(RequestConstants.CODE) != null
				&& !(request.getParameter(RequestConstants.CODE).equals(""))) {
			referenceCode = request.getParameter(RequestConstants.CODE);
		}
		if (request.getParameter(RequestConstants.SEARCH_NAME) != null
				&& !(request.getParameter(RequestConstants.SEARCH_NAME)
						.equals(""))) {
			referenceName = request.getParameter(RequestConstants.SEARCH_NAME);
		}
		if (request.getParameter(RequestConstants.STATUS) != null
				&& !(request.getParameter(RequestConstants.STATUS).equals(""))) {
			referenceStatus = request.getParameter(RequestConstants.STATUS);
		}
		if (request.getParameter(RequestConstants.CHANGED_BY) != null
				&& !(request.getParameter(RequestConstants.CHANGED_BY)
						.equals(""))) {
			changedBy = request.getParameter(RequestConstants.CHANGED_BY);
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("jspName") != null) {
			jspName = request.getParameter("jspName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", referenceId);
		generalMap.put("code", referenceCode);
		generalMap.put("name", referenceName);
		generalMap.put("status", referenceStatus);
		generalMap.put("userName", changedBy);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List existingReferenceNameList = (List) listMap
				.get("duplicateMastersList");

		MasReference masReference = new MasReference();
		boolean dataFixed = false;
		String message = "";

		if (existingReferenceNameList.size() == 0) {
			masReference.setId(referenceId);
			masReference.setReferenceCode(referenceCode);
			masReference.setReferenceName(referenceName);
			masReference.setStatus(referenceStatus);
			masReference.setLastChgBy(changedBy);
			masReference.setLastChgDate(changedDate);
			masReference.setLastChgTime(changedTime);

			dataFixed = registrationMasterHandlerService
					.updateReference(masReference);
			if (dataFixed == true) {
				message = "Reference Information Updated Successfully !! ";
				jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
				title = "Reference";

			} else {
				message = "Try again!";
			}
			url = "/hms/hms/common?method=showMainJsp&jspName="
					+ RequestConstants.REFERENCE_JSP;
			jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
			map.put("message", message);
			map.put("url", url);

		} else if (existingReferenceNameList.size() > 0) {

			message = "Name is already exists.";
			jsp = RequestConstants.REFERENCE_JSP;
			title = "Update Reference";
			map.put("errorMessageForExistence", message);
		}
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteReference(HttpServletRequest request,
			HttpServletResponse response) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean dataDeleted = false;
		int referenceId = 0;

		if (request.getParameter(RequestConstants.COMMON_ID) != null
				&& !(request.getParameter(RequestConstants.COMMON_ID)
						.equals(""))) {
			referenceId = Integer.parseInt(request
					.getParameter(RequestConstants.COMMON_ID));
		}

		dataDeleted = registrationMasterHandlerService
				.deleteReference(referenceId);
		if (dataDeleted == true) {
			message = "Reference Information Deleted Successfully !!";

		} else {
			message = "Try again!";
		}
		url = "/hms/hms/common?method=showMainJsp&jspName="
				+ RequestConstants.REFERENCE_JSP;
		jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
		title = "Reference";
		jsp += ".jsp";
		map.put("url", url);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public RegistrationMasterHandlerService getRegistrationMasterHandlerService() {
		return registrationMasterHandlerService;
	}

	public void setRegistrationMasterHandlerService(
			RegistrationMasterHandlerService registrationMasterHandlerService) {
		this.registrationMasterHandlerService = registrationMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
