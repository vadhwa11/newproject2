package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.HR_COURSE_MASTER_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.COMMUTATION_WEIGHTAGE_JSP;
import static jkt.hms.util.RequestConstants.COST_CENTER_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_JSP;
import static jkt.hms.util.RequestConstants.DEPARTMENT_TYPE_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_TYPE_JSP;
import static jkt.hms.util.RequestConstants.DESIGNATION_JSP;
import static jkt.hms.util.RequestConstants.FREQUENCY_JSP;
import static jkt.hms.util.RequestConstants.GROUP_JSP;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.TRANSACTION_TYPE_JSP;
import static jkt.hms.util.RequestConstants.DESCRIPTION;
import static jkt.hms.util.RequestConstants.YEAR;
import static jkt.hms.util.RequestConstants.HOLIDAY_DATE;
import static jkt.hms.util.RequestConstants.HOLIDAY_MASTER_ID;
import static jkt.hms.util.RequestConstants.LEAVE_JSP;
import static jkt.hms.util.RequestConstants.RH;
import static jkt.hms.util.RequestConstants.HR_QUALIFICATION_MASTER_JSP;
import static jkt.hms.util.RequestConstants.HR_INSTITUTE_MASTER_JSP;




import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.CommutationWeightage;
import jkt.hms.masters.business.GroupMaster;
import jkt.hms.masters.business.Holidaycalendar;
import jkt.hms.masters.business.HrMasCourse;
import jkt.hms.masters.business.HrMasInstitute;
import jkt.hms.masters.business.HrMasLeave;
import jkt.hms.masters.business.HrMasQualification;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasDesignation;
import jkt.hms.masters.business.MasDivision;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasTransactionType;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.SystemRelatedMasterHandlerService;
import jkt.hms.util.HMSUtil;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class SystemRelatedMasterController extends MultiActionController {
	SystemRelatedMasterHandlerService systemRelatedMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();

	String code = "";
	String name = "";
	String jspName = "";
	String pojoPropertyCode = "";
	String jsp = "";
	String title = "";
	String message = " ";
	String url = "";
	String viewPage = "";
	String pojoName = "";
	String pojoPropertyName = "";
	String currentTime = "";
	HttpSession session = null;

	// -------------------------------------------DepartmentType
	// --------------------------------------

	public ModelAndView searchDepartmentType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String departmentTypeCode = null;
		String departmentTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			departmentTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			departmentTypeName = request.getParameter(SEARCH_NAME);
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
			departmentTypeCode = searchField;
			departmentTypeName = null;
		} else {
			departmentTypeCode = null;
			departmentTypeName = searchField;
		}

		map = systemRelatedMasterHandlerService.searchDepartmentType(
				departmentTypeCode, departmentTypeName);
		jsp = DEPARTMENT_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("departmentTypeCode", departmentTypeCode);
		map.put("departmentTypeName", departmentTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDepartmentTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = systemRelatedMasterHandlerService.showDepartmentTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchDepartmentTypeList = (ArrayList) map
				.get("searchDepartmentTypeList");
		jsp = DEPARTMENT_TYPE_JSP;
		jsp += ".jsp";
		title = "DepartmentType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDepartmentType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasDepartmentType masDepartmentType = new MasDepartmentType();

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

		List departmentTypeCodeList = new ArrayList();
		List departmentTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			departmentTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			departmentTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((departmentTypeCodeList.size() == 0 || departmentTypeCodeList == null)
				&& (departmentTypeNameList.size() == 0 || departmentTypeNameList == null)) {
			masDepartmentType.setDepartmentTypeCode(code);
			masDepartmentType.setDepartmentTypeName(name);
			masDepartmentType.setStatus("y");
			masDepartmentType.setLastChgBy(changedBy);
			masDepartmentType.setLastChgDate(currentDate);
			masDepartmentType.setLastChgTime(currentTime);
			successfullyAdded = systemRelatedMasterHandlerService
					.addDepartmentType(masDepartmentType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((departmentTypeCodeList.size() != 0 || departmentTypeCodeList != null)
				|| (departmentTypeNameList.size() != 0)
				|| departmentTypeNameList != null) {

			if ((departmentTypeCodeList.size() != 0 || departmentTypeCodeList != null)
					&& (departmentTypeNameList.size() == 0 || departmentTypeNameList == null)) {

				message = "DepartmentType Code  already exists.";
			} else if ((departmentTypeNameList.size() != 0 || departmentTypeNameList != null)
					&& (departmentTypeCodeList.size() == 0 || departmentTypeCodeList == null)) {

				message = "DepartmentType Name already exists.";
			} else if ((departmentTypeCodeList.size() != 0 || departmentTypeCodeList != null)
					&& (departmentTypeNameList.size() != 0 || departmentTypeNameList != null)) {

				message = "DepartmentType Code and DepartmentType Name already exist.";
			}
		}
		url = "/hms/hms/systemRelatedMaster?method=showDepartmentTypeJsp";

		try {
			map = systemRelatedMasterHandlerService.showDepartmentTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_TYPE_JSP;
		title = "Add Department type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editDepartmentType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String departmentTypeCode = "";
		String departmentTypeName = "";
		int departmentTypeId = 0;
		String changedBy = "";

		Date changedDate = null;
		String changedTime = "";

		departmentTypeCode = (String) session
				.getAttribute("departmentTypeCode");
		departmentTypeName = (String) session
				.getAttribute("departmentTypeName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			departmentTypeId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			departmentTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			departmentTypeName = request.getParameter(SEARCH_NAME);
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", departmentTypeId);
		generalMap.put("departmentTypeCode", departmentTypeCode);
		generalMap.put("name", departmentTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDepartmentTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDepartmentTypeNameList.size() == 0) {

			dataUpdated = systemRelatedMasterHandlerService
					.editDepartmentTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingDepartmentTypeNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/systemRelatedMaster?method=showDepartmentTypeJsp";
		try {
			map = systemRelatedMasterHandlerService.showDepartmentTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_TYPE_JSP;
		title = "Edit Department type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteDepartmentType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int departmentTypeId = 0;
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
			departmentTypeId = Integer
					.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = systemRelatedMasterHandlerService.deleteDepartmentType(
				departmentTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/systemRelatedMaster?method=showDepartmentTypeJsp";
		try {
			map = systemRelatedMasterHandlerService.showDepartmentTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_TYPE_JSP;
		title = "Delete Department type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// ------------------------------------------
	// TransactionType----------------------------------------

	public ModelAndView searchTransactionType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String transactionTypeCode = null;
		String transactionTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			transactionTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			transactionTypeName = request.getParameter(SEARCH_NAME);
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
			transactionTypeCode = searchField;
			transactionTypeName = null;
		} else {
			transactionTypeCode = null;
			transactionTypeName = searchField;
		}

		map = systemRelatedMasterHandlerService.searchTransactionType(
				transactionTypeCode, transactionTypeName);
		jsp = TRANSACTION_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("transactionTypeCode", transactionTypeCode);
		map.put("transactionTypeName", transactionTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showTransactionTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = systemRelatedMasterHandlerService.showTransactionTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchTransactionTypeList = (ArrayList) map
				.get("searchTransactionTypeList");
		jsp = TRANSACTION_TYPE_JSP;
		jsp += ".jsp";
		title = "TransactionType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTransactionType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasTransactionType masTransactionType = new MasTransactionType();

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

		List transactionTypeCodeList = new ArrayList();
		List transactionTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			transactionTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			transactionTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((transactionTypeCodeList.size() == 0 || transactionTypeCodeList == null)
				&& (transactionTypeNameList.size() == 0 || transactionTypeNameList == null)) {
			masTransactionType.setTransactionTypeCode(code);
			masTransactionType.setTransactionTypeName(name);
			masTransactionType.setStatus("y");
			masTransactionType.setLastChgBy(changedBy);
			masTransactionType.setLastChgDate(currentDate);
			masTransactionType.setLastChgTime(currentTime);
			successfullyAdded = systemRelatedMasterHandlerService
					.addTransactionType(masTransactionType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((transactionTypeCodeList.size() != 0 || transactionTypeCodeList != null)
				|| (transactionTypeNameList.size() != 0)
				|| transactionTypeNameList != null) {

			if ((transactionTypeCodeList.size() != 0 || transactionTypeCodeList != null)
					&& (transactionTypeNameList.size() == 0 || transactionTypeNameList == null)) {

				message = "TransactionType Code  already exists.";
			} else if ((transactionTypeNameList.size() != 0 || transactionTypeNameList != null)
					&& (transactionTypeCodeList.size() == 0 || transactionTypeCodeList == null)) {

				message = "TransactionType Name already exists.";
			} else if ((transactionTypeCodeList.size() != 0 || transactionTypeCodeList != null)
					&& (transactionTypeNameList.size() != 0 || transactionTypeNameList != null)) {

				message = "TransactionType Code and TransactionType Name already exist.";
			}
		}
		url = "/hms/hms/systemRelatedMaster?method=showTransactionTypeJsp";
		try {
			map = systemRelatedMasterHandlerService.showTransactionTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TRANSACTION_TYPE_JSP;
		title = "Add Transaction type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editTransactionType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String transactionTypeCode = "";
		String transactionTypeName = "";
		int transactionTypeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			transactionTypeId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			transactionTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			transactionTypeName = request.getParameter(SEARCH_NAME);
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", transactionTypeId);
		generalMap.put("transactionTypeCode", transactionTypeCode);
		generalMap.put("name", transactionTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingTransactionTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingTransactionTypeNameList.size() == 0) {

			dataUpdated = systemRelatedMasterHandlerService
					.editTransactionTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingTransactionTypeNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/systemRelatedMaster?method=showTransactionTypeJsp";
		try {
			map = systemRelatedMasterHandlerService.showTransactionTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TRANSACTION_TYPE_JSP;
		title = "Edit Transaction type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteTransactionType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int transactionTypeId = 0;
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
			transactionTypeId = Integer.parseInt(request
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
		dataDeleted = systemRelatedMasterHandlerService.deleteTransactionType(
				transactionTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/systemRelatedMaster?method=showTransactionTypeJsp";
		try {
			map = systemRelatedMasterHandlerService.showTransactionTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TRANSACTION_TYPE_JSP;
		title = "Delete Transaction type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -------------------------------Frequency
	// ---------------------------------------------------------

	public ModelAndView searchFrequency(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String frequencyCode = null;
		String frequencyName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			frequencyCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			frequencyName = request.getParameter(SEARCH_NAME);
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
			frequencyCode = searchField;
			frequencyName = null;

		} else {
			frequencyCode = null;
			frequencyName = searchField;
		}
		map = systemRelatedMasterHandlerService.searchFrequency(frequencyCode,
				frequencyName);
		jsp = FREQUENCY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("frequencyCode", frequencyCode);
		map.put("frequencyName", frequencyName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showFrequencyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = systemRelatedMasterHandlerService.showFrequencyJsp();
		@SuppressWarnings("unused")
		ArrayList searchFrequencyList = (ArrayList) map
				.get("searchFrequencyList");
		jsp = FREQUENCY_JSP;
		jsp += ".jsp";
		title = "Frequency";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addFrequency(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasFrequency masFrequency = new MasFrequency();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int orderNo=0;
		BigDecimal fvalue = null;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("orderNo") != null && !(request.getParameter("orderNo").equals(""))	&& !(request.getParameter("orderNo").equals("0"))) {
			orderNo = Integer.parseInt(request
					.getParameter("orderNo"));
		}
		if (request.getParameter("fvalue") != null) {
			fvalue = new BigDecimal(request.getParameter("fvalue"));
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
		List frequencyCodeList = new ArrayList();
		List frequencyNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			frequencyCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			frequencyNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((frequencyCodeList.size() == 0 || frequencyCodeList == null)
				&& (frequencyNameList.size() == 0 || frequencyNameList == null)) {
			masFrequency.setFrequencyCode(code);
			masFrequency.setFrequencyName(name);
			masFrequency.setOrderNo(orderNo);
			masFrequency.setStatus("y");
			masFrequency.setFeq(fvalue);
			masFrequency.setLastChgBy(changedBy);
			masFrequency.setLastChgDate(currentDate);
			masFrequency.setLastChgTime(currentTime);
			successfullyAdded = systemRelatedMasterHandlerService
					.addFrequency(masFrequency);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";

			}
		}

		else if ((frequencyCodeList.size() != 0 || frequencyCodeList != null)
				|| (frequencyNameList.size() != 0) || frequencyNameList != null) {

			if ((frequencyCodeList.size() != 0 || frequencyCodeList != null)
					&& (frequencyNameList.size() == 0 || frequencyNameList == null)) {

				message = "Frequency Code  already exists.";
			} else if ((frequencyNameList.size() != 0 || frequencyNameList != null)
					&& (frequencyCodeList.size() == 0 || frequencyCodeList == null)) {

				message = "Frequency Name already exists.";
			} else if ((frequencyCodeList.size() != 0 || frequencyCodeList != null)
					&& (frequencyNameList.size() != 0 || frequencyNameList != null)) {

				message = "Frequency Code and Frequency Name already exist.";
			}
		}
		url = "/hms/hms/systemRelatedMaster?method=showFrequencyJsp";

		try {
			map = systemRelatedMasterHandlerService.showFrequencyJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FREQUENCY_JSP;
		title = "Add Frequency";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editFrequency(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String frequencyCode = "";
		String frequencyName = "";
		int frequencyId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
int orderNo=0;
BigDecimal fvalue = null;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			frequencyId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			frequencyCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			frequencyName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("fvalue") != null) {
			fvalue = new BigDecimal(request.getParameter("fvalue"));
		}
		if (request.getParameter("orderNo") != null && !(request.getParameter("orderNo").equals(""))	&& !(request.getParameter("orderNo").equals("0"))) {
			orderNo = Integer.parseInt(request
					.getParameter("orderNo"));
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", frequencyId);
		generalMap.put("frequencyCode", frequencyCode);
		generalMap.put("name", frequencyName);
		generalMap.put("orderNo", orderNo);
		generalMap.put("fvalue", fvalue);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingFrequencyNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingFrequencyNameList.size() == 0) {
			dataUpdated = systemRelatedMasterHandlerService
					.editFrequencyToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingFrequencyNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/systemRelatedMaster?method=showFrequencyJsp";
		try {
			map = systemRelatedMasterHandlerService.showFrequencyJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FREQUENCY_JSP;
		title = "Edit Frequency";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteFrequency(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int frequencyId = 0;
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
			frequencyId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = systemRelatedMasterHandlerService.deleteFrequency(
				frequencyId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/systemRelatedMaster?method=showFrequencyJsp";
		try {
			map = systemRelatedMasterHandlerService.showFrequencyJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FREQUENCY_JSP;
		title = "Delete Frequency";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// -----------------------------------Department
	// ------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showDepartmentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = systemRelatedMasterHandlerService.showDepartmentJsp();
		@SuppressWarnings("unused")
		ArrayList searchDepartmentList = (ArrayList) map
				.get("searchDepartmentList");
		jsp = DEPARTMENT_JSP;
		jsp += ".jsp";
		title = "Department";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDepartment(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasDepartment masDepartment = new MasDepartment();
		int divisionId=0;
		int departmentTypeId = 0;
		int costCenterId = 0;
		String changedBy = "";
		//String breadRequired = "";
		String deptNo="";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_TYPE_ID) != null) {
			departmentTypeId = Integer.parseInt(request
					.getParameter(DEPARTMENT_TYPE_ID));
		}
		if (request.getParameter(COST_CENTER_ID) != null) {
			costCenterId = Integer.parseInt(request
					.getParameter(COST_CENTER_ID));
		}
		if (request.getParameter("divisionId") != null 	&& !(request.getParameter("divisionId").equals("0"))) {
			divisionId = Integer.parseInt(request
					.getParameter("divisionId"));
		}
		if (request.getParameter("deptNo") != null) {
			deptNo = request.getParameter("deptNo");
		}		

		/*if (request.getParameter("breadRequired") != null) {
			breadRequired = "y";
		} else {
			breadRequired = "n";
		}*/
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
		int hospitalId=0;
		if(request.getParameter(HOSPITAL_ID) != null && !(request.getParameter(HOSPITAL_ID).equals(""))){
			hospitalId =Integer.parseInt(request.getParameter(HOSPITAL_ID)) ;
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
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		/*listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);*/
		List departmentCodeList = new ArrayList();
		List departmentNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			departmentCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			departmentNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((departmentCodeList.size() == 0 || departmentCodeList == null)
				&& (departmentNameList.size() == 0 || departmentNameList == null))

		{
			masDepartment.setDepartmentCode(code);
			masDepartment.setDepartmentName(name);
			MasDepartmentType masDepartmentType = new MasDepartmentType();
			masDepartmentType.setId(departmentTypeId);
			masDepartment.setDepartmentType(masDepartmentType);
			//masDepartment.setBreadRequired(breadRequired);
			/*MasCostCenter masCostCenter = new MasCostCenter();
			masCostCenter.setId(costCenterId);*/
			masDepartment.setCostCenter(null);

			masDepartment.setDepartmentNo(deptNo);
			MasDivision masDivision = new MasDivision();
			masDivision.setId(divisionId);
			masDepartment.setDivision(masDivision);
			
			masDepartment.setStatus("y");
			masDepartment.setLastChgBy(changedBy);
			masDepartment.setLastChgDate(currentDate);
			masDepartment.setLastChgTime(currentTime);
			
			MasHospital hospital= new MasHospital();
			hospital.setId(hospitalId);
			masDepartment.setHospital(hospital);
			
			successfullyAdded = systemRelatedMasterHandlerService
					.addDepartment(masDepartment);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((departmentCodeList.size() != 0 || departmentCodeList != null)
				|| (departmentNameList.size() != 0)
				|| departmentNameList != null) {

			if ((departmentCodeList.size() != 0 || departmentCodeList != null)
					&& (departmentNameList.size() == 0 || departmentNameList == null)) {

				message = "Department Code  already exists.";
			} else if ((departmentNameList.size() != 0 || departmentNameList != null)
					&& (departmentCodeList.size() == 0 || departmentCodeList == null)) {

				message = "Department Name  already exists.";
			} else if ((departmentCodeList.size() != 0 || departmentCodeList != null)
					&& (departmentNameList.size() != 0 || departmentNameList != null)) {

				message = "Department Code and Department Name already exist.";
			}
		}

		url = "/hms/hms/systemRelatedMaster?method=showDepartmentJsp";

		try {
			map = systemRelatedMasterHandlerService.showDepartmentJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_JSP;
		title = "Add Department";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchDepartment(HttpServletRequest request,
			HttpServletResponse response) throws

	ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String departmentCode = null;
		String departmentName = null;
		int divisionId=0;
		int divisionIdSearch=0;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			departmentCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			departmentName = request.getParameter(SEARCH_NAME);
		}	
		if (request.getParameter("divisionIdSearch") != null 	&& !(request.getParameter("divisionIdSearch").equals("0"))) {
			divisionId = Integer.parseInt(request.getParameter("divisionIdSearch"));
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
System.out.println(searchRadio);
		if (searchRadio == 1) {
			departmentCode = searchField;
			departmentName = null;
			divisionIdSearch=0;
		} 
		 if (searchRadio == 2) {
			departmentCode = null;
			departmentName = searchField;
			divisionIdSearch=0;
		}
		
		 if (searchRadio == 3) {
			departmentCode = null;
			departmentName = null;
			divisionIdSearch=divisionId;
		}
		map = systemRelatedMasterHandlerService.searchDepartment(departmentCode, departmentName,divisionIdSearch);

		jsp = DEPARTMENT_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("departmentCode", departmentCode);
		map.put("departmentName", departmentName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editDepartment(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String departmentCode = "";
		String departmentName = "";
		int departmentId = 0;
		int divisionId=0;
		int departmentTypeId = 0;
		int costCenterId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		//String breadRequired = "";
String deptNo="";
		departmentCode = (String) session.getAttribute("departmentCode");
		departmentName = (String) session.getAttribute("departmentName");

		if (request.getParameter(DEPARTMENT_TYPE_ID) != null) {
			departmentTypeId = Integer.parseInt(request
					.getParameter(DEPARTMENT_TYPE_ID));
		}
		if (request.getParameter(COST_CENTER_ID) != null) {
			costCenterId = Integer.parseInt(request
					.getParameter(COST_CENTER_ID));
		}
		if (request.getParameter("deptNo") != null) {
			deptNo = request.getParameter("deptNo");
		}		
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			departmentId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			departmentCode = request.getParameter(CODE);
		}
		if (request.getParameter("divisionId") != null 	&& !(request.getParameter("divisionId").equals("0"))) {
			divisionId = Integer.parseInt(request
					.getParameter("divisionId"));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			departmentName = request.getParameter(SEARCH_NAME);
		}
		/*if (request.getParameter("breadRequired") != null) {
			breadRequired = "y";
		} else {
			breadRequired = "n";
		}*/
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", departmentId);
		generalMap.put("departmentCode", departmentCode);
		generalMap.put("name", departmentName);
		generalMap.put("departmentTypeId", departmentTypeId);
		//generalMap.put("breadRequired", breadRequired);
		generalMap.put("costCenterId", costCenterId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("divisionId", divisionId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("deptNo", deptNo);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDepartmentNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDepartmentNameList.size() == 0) {

			dataUpdated = systemRelatedMasterHandlerService
					.editDepartmentToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingDepartmentNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/systemRelatedMaster?method=showDepartmentJsp";
		try {
			map = systemRelatedMasterHandlerService.showDepartmentJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_JSP;
		title = "Edit Department";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int departmentId = 0;
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
			departmentId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = systemRelatedMasterHandlerService.deleteDepartment(
				departmentId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/systemRelatedMaster?method=showDepartmentJsp";

		try {
			map = systemRelatedMasterHandlerService.showDepartmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_JSP;
		title = "delete Department";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showDesignationMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = systemRelatedMasterHandlerService.showDesignationJsp();

		jsp = DESIGNATION_JSP;
		jsp += ".jsp";
		title = "De";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView addDesignation(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasDesignation masDesignation = new MasDesignation();

		int groupMasterId = 0;
		String changedBy = "";
		String type = "";
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
		if (request.getParameter("groupMaster") != null) {
			groupMasterId = Integer.parseInt(request
					.getParameter("groupMaster"));
		}
		if (request.getParameter("type") != null) {
			type = request.getParameter("type");
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
		generalMap.put("groupMasterId", groupMasterId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("type", type);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List designationCodeList = new ArrayList();
		List designationNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			designationCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			designationNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((designationCodeList.size() == 0 || designationCodeList == null)
				&& (designationNameList.size() == 0 || designationNameList == null))

		{
			masDesignation.setDesignationCode(code);
			masDesignation.setDesignationName(name);
			GroupMaster groupMaster = new GroupMaster();
			groupMaster.setId(groupMasterId);
			masDesignation.setGroup(groupMaster);
			masDesignation.setStatus("y");
			masDesignation.setType(type);
			masDesignation.setLastChgBy(changedBy);
			masDesignation.setLastChgDate(currentDate);
			masDesignation.setLastChgTime(currentTime);
			successfullyAdded = systemRelatedMasterHandlerService
					.addDesignation(masDesignation);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((designationCodeList.size() != 0 || designationCodeList != null)
				|| (designationNameList.size() != 0)
				|| designationNameList != null) {

			if ((designationCodeList.size() != 0 || designationCodeList != null)
					&& (designationNameList.size() == 0 || designationNameList == null)) {

				message = "Designation Code  already exists.";
			} else if ((designationNameList.size() != 0 || designationNameList != null)
					&& (designationCodeList.size() == 0 || designationCodeList == null)) {

				message = "Designation Name  already exists.";
			} else if ((designationCodeList.size() != 0 || designationCodeList != null)
					&& (designationNameList.size() != 0 || designationNameList != null)) {

				message = "Designation Code and Designation Name already exist.";
			}
		}

		url = "/hms/hms/systemRelatedMaster?method=showDesignationMasterJsp";

		try {
			map = systemRelatedMasterHandlerService.showDesignationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DESIGNATION_JSP;
		title = "Add Designation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchDesignation(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String designationCode = null;
		String designation = null;

		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			designationCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			designation = request.getParameter(SEARCH_NAME);
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
			designationCode = searchField;
			designation = null;

		} else {
			designationCode = null;
			designation = searchField;
		}
		map = systemRelatedMasterHandlerService.searchDesignation(
				designationCode, designation);

		jsp = DESIGNATION_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("designationCode", designationCode);
		map.put("designation", designation);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteDesignation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int designationId = 0;
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
			designationId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = systemRelatedMasterHandlerService.deleteDesignation(
				designationId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/systemRelatedMaster?method=showDesignationJsp";

		try {
			map = systemRelatedMasterHandlerService.showDesignationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DESIGNATION_JSP;
		title = "delete Designation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editDesignation(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String designationCode = "";
		String designation = "";
		int designationId = 0;
		int groupMasterId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String type = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			designationId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			designationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			designation = request.getParameter(SEARCH_NAME);
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
		if (request.getParameter("groupMaster") != null) {
			groupMasterId = Integer.parseInt(request
					.getParameter("groupMaster"));
		}
		if (request.getParameter("type") != null) {
			type = request.getParameter("type");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("groupMasterId", groupMasterId);
		generalMap.put("type", type);
		generalMap.put("id", designationId);
		generalMap.put("designationCode", designationCode);
		generalMap.put("name", designation);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDepartmentNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDepartmentNameList.size() == 0) {

			dataUpdated = systemRelatedMasterHandlerService
					.editDesignation(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingDepartmentNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/systemRelatedMaster?method=showDesignationJsp";
		try {
			map = systemRelatedMasterHandlerService.showDesignationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DESIGNATION_JSP;
		title = "Edit Designation";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------------------------methods for Group
	// Master-------------------------------

	public ModelAndView showGroupMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = systemRelatedMasterHandlerService.showGroupMaster();

		jsp = GROUP_JSP;
		jsp += ".jsp";
		title = "Group Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView addGroupMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		GroupMaster groupMaster = new GroupMaster();

		int retirementAge = 0;
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
		if (request.getParameter("retirementAge") != null
				&& !(request.getParameter("retirementAge").equals(""))) {
			retirementAge = Integer.parseInt(request
					.getParameter("retirementAge"));
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("retirementAge", retirementAge);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List groupMasterCodeList = new ArrayList();
		List groupMasterNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			groupMasterCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			groupMasterNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((groupMasterCodeList.size() == 0 || groupMasterCodeList == null)
				&& (groupMasterNameList.size() == 0 || groupMasterNameList == null))

		{
			groupMaster.setGroupCode(code);
			groupMaster.setGroupName(name);
			groupMaster.setRetirementAge(retirementAge);
			groupMaster.setStatus("y");
			groupMaster.setLastChgBy(changedBy);
			groupMaster.setLastChgDate(currentDate);
			groupMaster.setLastChgTime(currentTime);
			successfullyAdded = systemRelatedMasterHandlerService
					.addGroupMaster(groupMaster);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((groupMasterCodeList.size() != 0 || groupMasterCodeList != null)
				|| (groupMasterNameList.size() != 0)
				|| groupMasterNameList != null) {

			if ((groupMasterCodeList.size() != 0 || groupMasterCodeList != null)
					&& (groupMasterNameList.size() == 0 || groupMasterNameList == null)) {

				message = "Group Code  already exists.";
			} else if ((groupMasterNameList.size() != 0 || groupMasterNameList != null)
					&& (groupMasterCodeList.size() == 0 || groupMasterCodeList == null)) {

				message = "Group Name  already exists.";
			} else if ((groupMasterCodeList.size() != 0 || groupMasterCodeList != null)
					&& (groupMasterNameList.size() != 0 || groupMasterNameList != null)) {

				message = "Group Code and Group Name already exist.";
			}
		}

		url = "/hms/hms/systemRelatedMaster?method=showGroupMaster";

		try {
			map = systemRelatedMasterHandlerService.showGroupMaster();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = GROUP_JSP;
		title = "Add Group Master";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchGroupMaster(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String groupCode = null;
		String groupName = null;

		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			groupCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			groupName = request.getParameter(SEARCH_NAME);
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
			groupCode = searchField;
			groupName = null;

		} else {
			groupCode = null;
			groupName = searchField;
		}
		map = systemRelatedMasterHandlerService.searchGroupMaster(groupCode,
				groupName);

		jsp = GROUP_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("groupCode", groupCode);
		map.put("groupName", groupName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteGroupMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int groupId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		//System.out.println("value of flag----" + flag);
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			groupId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = systemRelatedMasterHandlerService.deleteGroupMaster(
				groupId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/systemRelatedMaster?method=showGroupMaster";

		try {
			map = systemRelatedMasterHandlerService.showGroupMaster();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = GROUP_JSP;
		title = "delete Group Master";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editGroupMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String groupCode = "";
		String groupName = "";
		int groupId = 0;
		int retirementAge = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			groupId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			groupCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			groupName = request.getParameter(SEARCH_NAME);
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
		if (request.getParameter("retirementAge") != null
				&& !(request.getParameter("retirementAge").equals(""))) {
			retirementAge = Integer.parseInt(request
					.getParameter("retirementAge"));
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", groupId);
		generalMap.put("groupCode", groupCode);
		generalMap.put("name", groupName);
		generalMap.put("retirementAge", retirementAge);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDepartmentNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDepartmentNameList.size() == 0) {

			dataUpdated = systemRelatedMasterHandlerService
					.editGroupMaster(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingDepartmentNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/systemRelatedMaster?method=showGroupMaster";
		try {
			map = systemRelatedMasterHandlerService.showGroupMaster();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = GROUP_JSP;
		title = "Edit Group Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ----------------------------Commutation Weightage
	// Master----------------------

	public ModelAndView showCommutationWeightageMasterJsp(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		map = systemRelatedMasterHandlerService
				.showCommutationWeightageMasterJsp();

		jsp = COMMUTATION_WEIGHTAGE_JSP;
		jsp += ".jsp";
		title = "De";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCommutationWeightageMaster(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		CommutationWeightage commutationWeightage = new CommutationWeightage();

		BigDecimal cmValue = null;
		String changedBy = "";
		int age = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter("age") != null) {
			age = Integer.parseInt(request.getParameter("age"));
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
		if (request.getParameter("cmValue") != null) {
			cmValue = new BigDecimal(request.getParameter("cmValue"));
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
		// generalMap.put("name", name);
		generalMap.put("cmValue", cmValue);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List designationCodeList = new ArrayList();
		List designationNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			designationCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			designationNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((designationCodeList.size() == 0 || designationCodeList == null)
				&& (designationNameList.size() == 0 || designationNameList == null))

		{
			//System.out.println("value of pojo name====" + pojoName);
			commutationWeightage.setCommutationWeightageCode(code);
			commutationWeightage.setAge(age);
			commutationWeightage.setCmValue(cmValue);
			commutationWeightage.setStatus("y");
			commutationWeightage.setLastChgBy(changedBy);
			commutationWeightage.setLastChgDate(currentDate);
			commutationWeightage.setLastChgTime(currentTime);
			successfullyAdded = systemRelatedMasterHandlerService
					.addCommutationWeightageMaster(commutationWeightage);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((designationCodeList.size() != 0 || designationCodeList != null)
				|| (designationNameList.size() != 0)
				|| designationNameList != null) {

			if ((designationCodeList.size() != 0 || designationCodeList != null)
					&& (designationNameList.size() == 0 || designationNameList == null)) {

				message = "Commutation Weightage Code  already exists.";
			} else if ((designationNameList.size() != 0 || designationNameList != null)
					&& (designationCodeList.size() == 0 || designationCodeList == null)) {

				message = "Department Name  already exists.";
			} else if ((designationCodeList.size() != 0 || designationCodeList != null)
					&& (designationNameList.size() != 0 || designationNameList != null)) {

				message = "Commutation Weightage Code and Department Name already exist.";
			}
		}

		url = "/hms/hms/systemRelatedMaster?method=showCommutationWeightageMasterJsp";

		try {
			map = systemRelatedMasterHandlerService
					.showCommutationWeightageMasterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMMUTATION_WEIGHTAGE_JSP;
		title = "Add Designation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchCommutationWeightage(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String weightageCode = null;
		int age = 0;

		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			weightageCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			age = Integer.parseInt(request.getParameter(SEARCH_NAME));
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
			weightageCode = searchField;
			age = 0;

		} else {
			weightageCode = null;
			age = Integer.parseInt(searchField);
		}
		map = systemRelatedMasterHandlerService
				.searchCommutationWeightageMaster(weightageCode, age);

		jsp = COMMUTATION_WEIGHTAGE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("weightageCode", weightageCode);
		map.put("age", age);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteCommutationWeightage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int commutationId = 0;
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
			commutationId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = systemRelatedMasterHandlerService
				.deleteCommutationWeightage(commutationId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/systemRelatedMaster?method=showCommutationWeightageMasterJsp";

		try {
			map = systemRelatedMasterHandlerService
					.showCommutationWeightageMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMMUTATION_WEIGHTAGE_JSP;
		title = "Delete Commutation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editCommutationWeightage(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String weightageCode = "";
		int age = 0;
		String name = "";
		int commutationId = 0;
		BigDecimal cmValue = null;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String pojoProperty = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			commutationId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			weightageCode = request.getParameter(CODE);
		}
		if (request.getParameter("age") != null
				&& !(request.getParameter("age").equals(""))) {
			age = Integer.parseInt(request.getParameter("age"));
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoProperty = request.getParameter("pojoPropertyCode");
		}
		if (request.getParameter("cmValue") != null) {
			cmValue = new BigDecimal(request.getParameter("cmValue"));
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		//System.out.println("pojoproperty in controller=====" + pojoProperty);
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("cmValue", cmValue);
		generalMap.put("id", commutationId);
		generalMap.put("weightageCode", weightageCode);
		generalMap.put("name", weightageCode);
		generalMap.put("age", age);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoProperty);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDepartmentNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDepartmentNameList.size() == 0) {

			dataUpdated = systemRelatedMasterHandlerService
					.editCommutationWeightage(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingDepartmentNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/systemRelatedMaster?method=showCommutationWeightageMasterJsp";
		try {
			map = systemRelatedMasterHandlerService
					.showCommutationWeightageMasterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMMUTATION_WEIGHTAGE_JSP;
		title = "Edit Commutation";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------------------------------------------------------------------------------------
	public SystemRelatedMasterHandlerService getSystemRelatedMasterHandlerService() {
		return systemRelatedMasterHandlerService;
	}

	public void setSystemRelatedMasterHandlerService(
			SystemRelatedMasterHandlerService systemRelatedMasterHandlerService) {
		this.systemRelatedMasterHandlerService = systemRelatedMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
	
	//---------------------- Transaction Sequence Master By Mansi
	
	@SuppressWarnings("unchecked")
	public ModelAndView showTransactionSequenceJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = systemRelatedMasterHandlerService.showTransactionSequenceJsp();
		ArrayList searchTransactionSequenceList = (ArrayList) map.get("searchTransactionSequenceList");
		jsp = "transactionSequence";
		jsp += ".jsp";
		title = "Transaction Sequence";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTransactionSequence(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		TransactionSequence transactionSequence = new TransactionSequence();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		int tSqNo=0;
		String tSqName="";
		String tPrefix="";
		String tableName="";
		int month=0;
		int serviceTypeId=0;
		
		
		if (request.getParameter("tSqNo") != null
				&& !(request.getParameter("tSqNo").equals("0"))) {
			tSqNo = Integer.parseInt(request.getParameter("tSqNo"));
		}
		if (request.getParameter("month") != null
				&& !(request.getParameter("month").equals("0"))) {
			month = Integer.parseInt(request.getParameter("month"));
		}
		if (request.getParameter("serviceTypeId") != null
				&& !(request.getParameter("serviceTypeId").equals(""))) {
			serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
		}
		if (request.getParameter("tSqName") != null
				&& !(request.getParameter("tSqName").equals(""))) {
			tSqName = request.getParameter("tSqName");
		}
		if (request.getParameter("tPrefix") != null
				&& !(request.getParameter("tPrefix").equals(""))) {
			tPrefix = request.getParameter("tPrefix");
		}
		if (request.getParameter("tableName") != null
				&& !(request.getParameter("tableName").equals(""))) {
			tableName = request.getParameter("tableName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		generalMap.put("tSqNo", tSqNo);
		generalMap.put("month", month);
		generalMap.put("tableName", tableName);
		generalMap.put("tPrefix", tPrefix);
		
		generalMap.put("tSqName", tSqName);
		generalMap.put("serviceTypeId", serviceTypeId);

		listMap = systemRelatedMasterHandlerService.existingMasters(generalMap);

List transactionSequenceList = new ArrayList();

if (listMap.get("transactionSequenceList") != null) {
	transactionSequenceList = (List) listMap.get("transactionSequenceList");
}

		System.out.println("transactionSequenceList----->"+transactionSequenceList.size());
		boolean successfullyAdded = false;

		if ((transactionSequenceList.size() == 0 || transactionSequenceList == null)) {
			
			transactionSequence.setTransactionSequenceName(tSqName);
		transactionSequence.setTablename(tableName);
		transactionSequence.setTransactionSequenceNumber(tSqNo);
		transactionSequence.setMonth(month);
		transactionSequence.setTransactionPrefix(tPrefix);
			
		transactionSequence.setStatus("y");
		successfullyAdded = systemRelatedMasterHandlerService.addTransactionSequence(transactionSequence);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((transactionSequenceList.size() != 0 || transactionSequenceList != null)){

		
				message = "Already exist.";
			}
		
		url = "/hms/hms/systemRelatedMaster?method=showTransactionSequenceJsp";

		try {
			map = systemRelatedMasterHandlerService.showTransactionSequenceJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "transactionSequence";
		title = "Add Transaction Sequence";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editTransactionSequence(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		int tSqNo=0;
		String tSqName="";
		String tPrefix="";
		String tableName="";
		int month=0;
		int serviceTypeId=0;
		int tSqId = 0;
		
		
		if (request.getParameter("tSqNo") != null
				&& !(request.getParameter("tSqNo").equals("0"))) {
			tSqNo = Integer.parseInt(request.getParameter("tSqNo"));
		}
		if (request.getParameter("month") != null
				&& !(request.getParameter("month").equals("0"))) {
			month = Integer.parseInt(request.getParameter("month"));
		}
		if (request.getParameter("serviceTypeId") != null
				&& !(request.getParameter("serviceTypeId").equals(""))) {
			serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
		}
		if (request.getParameter("tSqName") != null
				&& !(request.getParameter("tSqName").equals(""))) {
			tSqName = request.getParameter("tSqName");
		}
		if (request.getParameter("tPrefix") != null
				&& !(request.getParameter("tPrefix").equals(""))) {
			tPrefix = request.getParameter("tPrefix");
		}
		if (request.getParameter("tableName") != null
				&& !(request.getParameter("tableName").equals(""))) {
			tableName = request.getParameter("tableName");
		}
		
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			tSqId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		
		generalMap.put("id", tSqId);
		generalMap.put("tSqNo", tSqNo);
		generalMap.put("month", month);
		generalMap.put("tableName", tableName);
		generalMap.put("tPrefix", tPrefix);
		
		generalMap.put("tSqName", tSqName);
		generalMap.put("serviceTypeId", serviceTypeId);

		generalMap.put("flag", true);

		listMap = systemRelatedMasterHandlerService.existingMasters(generalMap);

		List transactionSequenceList = new ArrayList();

		if (listMap.get("transactionSequenceList") != null) {
			transactionSequenceList = (List) listMap.get("transactionSequenceList");
		}
		boolean dataUpdated = false;
		if (transactionSequenceList.size() == 0) {

			dataUpdated = systemRelatedMasterHandlerService
					.editTransactionSequence(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (transactionSequenceList.size() > 0) {

			message = "Already exists.";
		}
		url = "/hms/hms/systemRelatedMaster?method=showTransactionSequenceJsp";
		try {
			map = systemRelatedMasterHandlerService.showTransactionSequenceJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "transactionSequence";
		title = "Edit Transaction Sequence";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	//---------------------Leave master---------------------------------	
		@SuppressWarnings("unchecked")
		public ModelAndView showLeaveJsp(HttpServletRequest request,HttpServletResponse response)
		{
			session = request.getSession(true);
			/*System.out.println(systemRelatedMasterHandlerService);*/
			map = systemRelatedMasterHandlerService.showLeaveJsp();
			jsp = "leave";
			jsp += ".jsp";
			title = "Leave";
			map.put("contentJsp",jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		@SuppressWarnings("unchecked")
		public ModelAndView addLeave(HttpServletRequest request, HttpServletResponse response){
			
			Date currentDate = new Date(); 
			String description = "";
			String changedBy = "";
			String currentTime = "";
			int hospitalId=0;
			if (request.getParameter(DESCRIPTION) != null ) {
				description = request.getParameter(DESCRIPTION);
			}
			if (request.getParameter(HOSPITAL_ID) != null) {
				hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
			}
			if(request.getParameter("CHANGED_BY") != null && !(request.getParameter("CHANGED_BY").equals(""))){
				changedBy = request.getParameter("CHANGED_BY");
				System.out.println("changedBy>>>>>>"+changedBy);
			}
			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
				currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			}
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				currentTime = request.getParameter(CHANGED_TIME);
			}
			HrMasLeave hrMasLeave = new HrMasLeave();
			hrMasLeave.setDescription(description);
			
			/*MasHospital masHospital= new MasHospital();
			masHospital.setId(hospitalId);
			hrMasLeave.setCompany(masHospital);*/
			System.out.println("hospitalId---in controller---"+hospitalId);
			
			Users user= new Users();
			user.setId(Integer.parseInt(changedBy));
			hrMasLeave.setLastChgBy(user);
			
			//hrMasLeave.setLastChgBy(changedBy);
			hrMasLeave.setLastChgDate(currentDate);
			hrMasLeave.setLastChgTime(currentTime);
			hrMasLeave.setStatus("y");
			
			map = systemRelatedMasterHandlerService.addLeave(hrMasLeave);
			String jsp = LEAVE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		@SuppressWarnings("unchecked")
		public ModelAndView editLeave(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			int leaveId = 0;
			String description = "";
			String changedBy ="";
			String changedTime = "";
			Date changedDate = null;
			int hospitalId=0;
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				leaveId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(DESCRIPTION) != null && !(request.getParameter(DESCRIPTION).equals(""))){
				description = request.getParameter(DESCRIPTION);
			}
			if (request.getParameter(HOSPITAL_ID) != null && !(request.getParameter(DESCRIPTION).equals("0"))) {
				hospitalId = 	Integer.parseInt(request.getParameter(HOSPITAL_ID));
			}
			if(request.getParameter("CHANGED_BY") != null && !(request.getParameter("CHANGED_BY").equals(""))){
				changedBy = request.getParameter("CHANGED_BY");
			}
			changedDate = new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			generalMap.put("leaveId", leaveId);
			generalMap.put("description", description);
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			
		
			Map map1 = systemRelatedMasterHandlerService.editLeave(generalMap);
			
			message=(String)map1.get("message");
			map=systemRelatedMasterHandlerService.showLeaveJsp();
			String jsp = LEAVE_JSP;
			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView deleteLeave(HttpServletRequest request ,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			int leaveId=0;
			String message="";
			String changedTime = "";
			String changedBy = "";
			Date changedDate = null;
			String flag =""; 
			if(request.getParameter("flag") != null){
				flag = request.getParameter("flag"); 
				generalMap.put("flag", flag);
			}
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				leaveId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter("title") != null){
				title = request.getParameter("title"); 
			}
			if(request.getParameter("CHANGED_BY") != null && !(request.getParameter("CHANGED_BY").equals(""))){
				changedBy = request.getParameter("CHANGED_BY");
			}
			changedDate= new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

			generalMap.put("leaveId", leaveId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
		
			Map map1 = systemRelatedMasterHandlerService.deleteLeave(generalMap);
			message=(String)map1.get("message");
			map=systemRelatedMasterHandlerService.showLeaveJsp();
			String jsp = LEAVE_JSP;
			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
			
		}
		public ModelAndView searchLeave(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();		
			String description  = "";
			if(request.getParameter(DESCRIPTION) != null && !(request.getParameter(DESCRIPTION).equals(""))){
				description = request.getParameter(DESCRIPTION);
			}
			map = systemRelatedMasterHandlerService.searchLeave(description);

			jsp=LEAVE_JSP;
			jsp += ".jsp";
			map.put("search","search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("description",description);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showHolidayMasterJsp(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map= new HashMap<String, Object>();	
			map = systemRelatedMasterHandlerService.showHolidayMasterJsp();
			String jsp = "hr_holidayMaster";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
			
		}
		
		public ModelAndView addHolidayMaster(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map= new HashMap<String, Object>();
			Holidaycalendar holidaycalendar = new Holidaycalendar();
			if(request.getParameter(YEAR)!= null){
				String year = request.getParameter(YEAR); 
				holidaycalendar.setHolidayListYear(year);
			}
			if(request.getParameter(DESCRIPTION)!= null){
				String description = request.getParameter(DESCRIPTION); 
				holidaycalendar.setTitle(description);
			}
			if(request.getParameter("holidayDate")!= null){
				Date holidayDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("holidayDate")); 
				holidaycalendar.setHolidayDate(holidayDate);
			}
			if(request.getParameter("rh")!= null){
				String rh = request.getParameter("rh"); 
				holidaycalendar.setRh(rh);
			}
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				String changedBy = request.getParameter(CHANGED_BY);
				holidaycalendar.setLastChgBy(changedBy);
			}
			Date changedDate= new Date();
			holidaycalendar.setLastChgDate(changedDate);
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				String changedTime = request.getParameter(CHANGED_TIME);
				holidaycalendar.setLastChgTime(changedTime);
			}
			
			holidaycalendar.setStatus("y");
			map = systemRelatedMasterHandlerService.addHolidayMaster(holidaycalendar);
			String jsp = "hr_holidayMaster";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
			
		}
		public ModelAndView editHolidayMaster(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map= new HashMap<String, Object>();
			Map<String, Object> generalMap= new HashMap<String, Object>();
			if(request.getParameter(HOLIDAY_MASTER_ID)!= null){
				int holidayMasterId = Integer.parseInt(request.getParameter(HOLIDAY_MASTER_ID));
				generalMap.put("holidayMasterId", holidayMasterId);
			}
			if(request.getParameter(YEAR)!= null){
				String year = request.getParameter(YEAR); 
				generalMap.put("year", year);
			}
			if(request.getParameter(DESCRIPTION)!= null){
				String description = request.getParameter(DESCRIPTION); 
				generalMap.put("description", description);
			}
			if(request.getParameter(HOLIDAY_DATE)!= null){
				Date holidayDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HOLIDAY_DATE)); 
				generalMap.put("holidayDate", holidayDate);
			}
			if(request.getParameter(RH)!= null){
				String rh = request.getParameter(RH); 
				generalMap.put("rh", rh);
			}
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				String changedBy = request.getParameter(CHANGED_BY);
				generalMap.put("changedBy", changedBy);
			}
			Date changedDate= new Date();
			generalMap.put("changedDate", changedDate);
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				String changedTime = request.getParameter(CHANGED_TIME);
				generalMap.put("changedTime", changedTime);
			}
			int locId=0;
			if(request.getParameter("loc") != null && !(request.getParameter("loc").equals("0"))){
				 locId = Integer.parseInt(""+request.getParameter("loc"));
				 generalMap.put("locId", locId);
			}
			
			map = systemRelatedMasterHandlerService.editHolidayMaster(generalMap);
			String jsp = "hr_holidayMaster";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
			
		}
		/*public ModelAndView deleteHolidayMaster(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map= new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			
			String flag =""; 
			if(request.getParameter("flag") != null){
				flag = request.getParameter("flag"); 
				generalMap.put("flag", flag);
			}
			if(request.getParameter(HOLIDAY_MASTER_ID)!= null){
				int holidayMasterId = Integer.parseInt(request.getParameter(HOLIDAY_MASTER_ID));
				generalMap.put("holidayMasterId", holidayMasterId);
			}
			
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				String changedBy = request.getParameter(CHANGED_BY);
				generalMap.put("changedBy", changedBy);
			}
			Date changedDate= new Date();
			generalMap.put("changedDate", changedDate);
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				String changedTime = request.getParameter(CHANGED_TIME);
				generalMap.put("changedTime", changedTime);
			}
		    map = systemRelatedMasterHandlerService.deleteHolidayMaster(generalMap);
			String jsp = "";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
			
		}*/
		public ModelAndView searchHolidayMaster(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map= new HashMap<String, Object>();
			String name = "";
			if(request.getParameter(DESCRIPTION) != null && !(request.getParameter(DESCRIPTION).equals(""))){
				name = request.getParameter(DESCRIPTION);
			}
			String year = "";
			System.out.println("name  ssdf    "+request.getParameter(YEAR));
			if(request.getParameter(YEAR) != null && !(request.getParameter(YEAR).equals(""))){
				year = request.getParameter(YEAR);
			}
			int searchRadio=1;
			String searchField= "";
			try{
				if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
					searchField = request.getParameter(SEARCH_FIELD);			}

				if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
					searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;	
					}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			if(searchRadio==1){
				name=searchField;
				year=null;

			}else{
				name=null;
				year=searchField;
			}
			map = systemRelatedMasterHandlerService.searchHolidayMaster(name,year);
			String jsp = "hr_holidayMaster";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("search","search");
			return new ModelAndView("index", "map", map);
			
		}


		public ModelAndView showReligionJsp(HttpServletRequest request,
				HttpServletResponse response) {
			HttpSession session = request.getSession();
			session = request.getSession(true);
			map = systemRelatedMasterHandlerService.showReligionJsp();
			jsp = "religion";
			jsp += ".jsp";
			title = "Religion";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		
		
		//****************************************** Start Of Course Master by Atul ****************************//	
		
		@SuppressWarnings("unchecked")
		public ModelAndView showCourseMasterJsp(HttpServletRequest request,HttpServletResponse response)
		{

			Map map = new HashMap();
			map = systemRelatedMasterHandlerService.showCourseMasterJsp();
			String jsp="hrCourseMaster";
			jsp += ".jsp";
			title = "Course Master";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index","map",map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView searchCourseMaster(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map= new HashMap<String, Object>();
			String courseCode = null;
			String courseName = null;
			String searchField = null;
			int searchRadio = 1;
			
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				courseCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))) {
				courseName = request.getParameter(SEARCH_NAME);
			}
			try {
				if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))) {
					searchField = request.getParameter(SEARCH_FIELD);
				}
				if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))) {
					searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(searchRadio == 1) {
				courseCode = searchField;
				courseName = null;
			}else {
				courseName = searchField;
				courseCode = null;
			}
				
		
		map = systemRelatedMasterHandlerService.searchCourseMaster(courseCode, courseName);
		String jsp=HR_COURSE_MASTER_JSP;
		jsp += ".jsp";
		title = "Course Master";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);		
		}
		
		@SuppressWarnings("unchecked")
		public ModelAndView addCourseMaster(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			HrMasCourse hrMasCourse=new HrMasCourse();
			
			String changedBy = "";
			Date changedDate = null;
			String changedTime = "";
			int hospitalId=0;
			String pojoPropertyName = "";
			String pojoPropertyCode = "";
			String pojoName = "";
			HttpSession session = request.getSession();
			
			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			
								
			Map<String,Object> listMap=new HashMap<String,Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}		
					
			
			if(request.getParameter(CHANGED_BY) != null && (!(request.getParameter(CHANGED_BY).equals("")))){
				changedBy = request.getParameter(CHANGED_BY);
			}
			
			
			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
				currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			}
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				currentTime = request.getParameter(CHANGED_TIME);
			}
			if(request.getParameter("title") != null){
				title = request.getParameter("title"); 
			}
			if(request.getParameter("pojoName") != null){
				pojoName = request.getParameter("pojoName"); 
			}
			if(request.getParameter("pojoPropertyName") != null){
				pojoPropertyName = request.getParameter("pojoPropertyName"); 
			}
			if(request.getParameter("pojoPropertyCode") != null){
				pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
			}
			
			generalMap.put("code", code);
			generalMap.put("name", name);
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);
			listMap = systemRelatedMasterHandlerService.checkForExistingMasters(generalMap);
			List courseCodeList = new ArrayList();
			List courseNameList = new  ArrayList();
			
				
			
			if(listMap.get("duplicateGeneralCodeList") != null){
				courseCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				courseNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			
			boolean successfullyAdded = false;
		    if((courseCodeList.size() == 0 || courseCodeList == null))
			{
					hrMasCourse.setCourseCode(code);
					hrMasCourse.setCourseName(name);
									
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					hrMasCourse.setCompany(masHospital);
					
					hrMasCourse.setStatus("y");
					hrMasCourse.setLastChgBy(changedBy);
					hrMasCourse.setLastChgDate(currentDate);
					hrMasCourse.setLastChgTime(currentTime);
				successfullyAdded = systemRelatedMasterHandlerService.addCourseMaster(hrMasCourse);		
			
			if(successfullyAdded)
			{
				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";			
			}	}
				
			else if((courseCodeList.size() != 0 || courseCodeList != null) || (courseNameList.size() != 0) || courseNameList != null){
				if((courseCodeList.size() != 0 || courseCodeList != null) && (courseNameList.size() == 0 || courseNameList == null)){
					
				message = "Course Code already exists.";
				}
				else if((courseNameList.size() != 0 || courseNameList != null) && (courseCodeList.size() == 0 || courseCodeList == null) ){
					
					message = "Course Name  already exists.";
				}
				else if((courseCodeList.size() != 0 || courseCodeList != null) && (courseNameList.size() != 0 || courseNameList != null)){
					message = "Course Code and Course Description already exist.";
				}
			}
				 url = "erp/hrms/educationMasters?method=showCourseMasterJsp";
				try{
					map = systemRelatedMasterHandlerService.showCourseMasterJsp();
				   
				  }catch (Exception e) {
					  e.printStackTrace();
				  }
				  
				  
				    String jsp=HR_COURSE_MASTER_JSP;
					jsp += ".jsp";
					title = "Add Course Master";	
					map.put("message", message);
					map.put("contentJsp", jsp);
					map.put("title", title);
					return new ModelAndView("index","map",map);
				}
	    
		@SuppressWarnings("unchecked")
		public ModelAndView editCourseMaster(HttpServletRequest request, HttpServletResponse response) 
		{
			
			Map<String, Object>	map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> listMap = new HashMap<String, Object>();		
			HttpSession session=request.getSession();
			
			String courseCode="";
			String courseName="";
			int hospitalId =0;
			int courseId=0;
						
			String changedBy = "";
			Date changedDate = null;
			String changedTime = "";
			
			
			
			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
						
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				courseId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				courseCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				courseName = request.getParameter(SEARCH_NAME);
			}
			
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				changedBy = request.getParameter(CHANGED_BY);
			}
			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
				changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			}
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				currentTime = request.getParameter(CHANGED_TIME);
			}
			
			if(request.getParameter("title") != null){
				title = request.getParameter("title"); 
			}
			if(request.getParameter("pojoPropertyName") != null){
				pojoPropertyName = request.getParameter("pojoPropertyName"); 
			}
			if(request.getParameter("pojoName") != null){
				pojoName = request.getParameter("pojoName"); 
			}
			changedDate = new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			
			generalMap.put("id", courseId);
			generalMap.put("code", courseCode);
			generalMap.put("name", courseName);
							
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);

			generalMap.put("flag", true);
			listMap = systemRelatedMasterHandlerService.checkForExistingMasters(generalMap);
		    List existingCourseMasterList = (List)listMap.get("duplicateGeneralCodeList");
			boolean dataUpdated=false;
			if(existingCourseMasterList.size() == 0)
			{
			dataUpdated=systemRelatedMasterHandlerService.editCourseMaster(generalMap);
			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant be updated !!";
			}
			} 
			else if(existingCourseMasterList.size() > 0){
				message = "Name already exists.";
			}
			url = "/erp/hrms/educationMasters?method=showCourseMasterJsp";
			try{
				map = systemRelatedMasterHandlerService.showCourseMasterJsp();
			   
			  }catch (Exception e) {
				  e.printStackTrace();
			  }
			  jsp=HR_COURSE_MASTER_JSP;
			  title="Edit Course Master";
			  jsp += ".jsp";
			  map.put("contentJsp", jsp);
			  map.put("title", title);
			  map.put("message", message);
			  return new ModelAndView("index", "map", map);
		}


		@SuppressWarnings("unchecked")
		public ModelAndView deleteCourseMaster(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int courseId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			courseId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
		
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=systemRelatedMasterHandlerService.deleteCourseMaster(courseId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/erp/hrms/educationMasters?method=showCourseMasterJsp";
		
		try{
			map = systemRelatedMasterHandlerService.showCourseMasterJsp();
		   
		  }catch (Exception e) {
		   e.printStackTrace();
		  }
		  jsp=HR_COURSE_MASTER_JSP;
		  title="Delete Course Master";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
		}

		//******************************************* End of Course Master By Atul***************************************************//
		
		
		//******************************************** Start of Qualification Master By Atul ****************************************//
		

		@SuppressWarnings("unchecked")
		public ModelAndView showQualificationMasterJsp(HttpServletRequest request,HttpServletResponse response)
		{

			Map map = new HashMap();
			map = systemRelatedMasterHandlerService.showQualificationMasterJsp();
			String jsp=HR_QUALIFICATION_MASTER_JSP;
			jsp += ".jsp";
			title = "Qualification Master";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index","map",map);
		}

		
		@SuppressWarnings("unchecked")
		public ModelAndView addQualificationMaster(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			HrMasQualification hrMasQualification=new HrMasQualification();
			
			String changedBy = "";
			Date changedDate = null;
			String changedTime = "";
			int hospitalId=0;
			
			HttpSession session = request.getSession();
			
			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			
								
			Map<String,Object> listMap=new HashMap<String,Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}		
					
			
			if(request.getParameter(CHANGED_BY) != null && (!(request.getParameter(CHANGED_BY).equals("")))){
				changedBy = request.getParameter(CHANGED_BY);
			}
			
			
			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
				currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			}
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				currentTime = request.getParameter(CHANGED_TIME);
			}
			if(request.getParameter("title") != null){
				title = request.getParameter("title"); 
			}
			if(request.getParameter("pojoName") != null){
				pojoName = request.getParameter("pojoName"); 
			}
			if(request.getParameter("pojoPropertyName") != null){
				pojoPropertyName = request.getParameter("pojoPropertyName"); 
			}
			if(request.getParameter("pojoPropertyCode") != null){
				pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
			}
			generalMap.put("code", code);
			generalMap.put("name", name);
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);
			listMap = systemRelatedMasterHandlerService.checkForExistingMasters(generalMap);
			List qualificationCodeList = new ArrayList();
			List qualificationNameList = new  ArrayList();
			
				
			
			if(listMap.get("duplicateGeneralCodeList") != null){
				qualificationCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				qualificationNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			
			boolean successfullyAdded = false;
		
		    if((qualificationCodeList.size() == 0 || qualificationCodeList == null))
			{
					hrMasQualification.setQualificationCode(code);
					hrMasQualification.setQualificationName(name);
									
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					hrMasQualification.setCompany(masHospital);
					
					hrMasQualification.setStatus("y");
					hrMasQualification.setLastChgBy(changedBy);
					hrMasQualification.setLastChgDate(currentDate);
					hrMasQualification.setLastChgTime(currentTime);
				successfullyAdded = systemRelatedMasterHandlerService.addQualificationMaster(hrMasQualification);		
			
			if(successfullyAdded)
			{
				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";			
			}	}
				
			else if((qualificationCodeList.size() != 0 || qualificationCodeList != null) || (qualificationNameList.size() != 0) || qualificationNameList != null){
				if((qualificationCodeList.size() != 0 || qualificationCodeList != null) && (qualificationNameList.size() == 0 || qualificationNameList == null)){
					
				message = "Qualifiction Code already exists.";
				}
				else if((qualificationNameList.size() != 0 || qualificationNameList != null) && (qualificationCodeList.size() == 0 || qualificationCodeList == null) ){
					
					message = "Qualification Name  already exists.";
				}
				else if((qualificationCodeList.size() != 0 || qualificationCodeList != null) && (qualificationNameList.size() != 0 || qualificationNameList != null)){
					message = "Qualification Code and Qualification Description already exist.";
				}
			}
				 url = "erp/hrms/educationMasters?method=showQualificationMasterJsp";
				try{
					map = systemRelatedMasterHandlerService.showQualificationMasterJsp();
				   
				  }catch (Exception e) {
					  e.printStackTrace();
				  }
				  
				  
				    String jsp=HR_QUALIFICATION_MASTER_JSP;
					jsp += ".jsp";
					title = "Add Qualification Master";	
					map.put("message", message);
					map.put("contentJsp", jsp);
					map.put("title", title);
					return new ModelAndView("index","map",map);
				}

		
		@SuppressWarnings("unchecked")
		public ModelAndView searchQualificationMaster(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map= new HashMap<String, Object>();
			String qualificationCode = null;
			String qualificationName = null;
			String searchField = null;
			int searchRadio = 1;
			
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				qualificationCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))) {
				qualificationName = request.getParameter(SEARCH_NAME);
			}
			try {
				if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))) {
					searchField = request.getParameter(SEARCH_FIELD);
				}
				if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))) {
					searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(searchRadio == 1) {
				qualificationCode = searchField;
				qualificationName = null;
			}else {
				qualificationName = searchField;
				qualificationCode = null;
			}
				
		
		map = systemRelatedMasterHandlerService.searchQualificationMaster(qualificationCode, qualificationName);
		String jsp=HR_QUALIFICATION_MASTER_JSP;
		jsp += ".jsp";
		title = "Course Master";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);		
		}
	 	
		@SuppressWarnings("unchecked")
		public ModelAndView editQualificationMaster(HttpServletRequest request, HttpServletResponse response) 
		{
			
			Map<String, Object>	map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> listMap = new HashMap<String, Object>();		
			HttpSession session=request.getSession();
			
			String qualificationCode="";
			String qualificationName="";
			int hospitalId =0;
			int qualificationId=0;
						
			String changedBy = "";
			Date changedDate = null;
			String changedTime = "";
			
	        session = request.getSession();
			
			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
						
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				qualificationId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				qualificationCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				qualificationName = request.getParameter(SEARCH_NAME);
			}
			
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				changedBy = request.getParameter(CHANGED_BY);
			}
			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
				changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			}
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				currentTime = request.getParameter(CHANGED_TIME);
			}
			
			if(request.getParameter("title") != null){
				title = request.getParameter("title"); 
			}
			if(request.getParameter("pojoPropertyName") != null){
				pojoPropertyName = request.getParameter("pojoPropertyName"); 
			}
			if(request.getParameter("pojoName") != null){
				pojoName = request.getParameter("pojoName"); 
			}
			changedDate = new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			
			generalMap.put("id", qualificationId);
			generalMap.put("code", qualificationCode);
			generalMap.put("name", qualificationName);
							
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);

			generalMap.put("flag", true);
			listMap = systemRelatedMasterHandlerService.checkForExistingMasters(generalMap);
		    List existingQualificationMasterList = (List)listMap.get("duplicateGeneralCodeList");
			boolean dataUpdated=false;
			if(existingQualificationMasterList.size() == 0)
			{
			dataUpdated=systemRelatedMasterHandlerService.editQualificationMaster(generalMap);
			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant be updated !!";
			}
			} 
			else if(existingQualificationMasterList.size() > 0){
				message = "Name already exists.";
			}
			url = "/erp/hrms/educationMasters?method=showQualificationMasterJsp";
			try{
				map = systemRelatedMasterHandlerService.showQualificationMasterJsp();
			   
			  }catch (Exception e) {
				  e.printStackTrace();
			  }
			  jsp=HR_QUALIFICATION_MASTER_JSP;
			  title="Edit Qualification Master";
			  jsp += ".jsp";
			  map.put("contentJsp", jsp);
			  map.put("title", title);
			  map.put("message", message);
			  return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView deleteQualificationMaster(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int qualificationId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			qualificationId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
		
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=systemRelatedMasterHandlerService.deleteQualificationMaster(qualificationId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/erp/hrms/educationMasters?method=showQualificationMasterJsp";
		
		try{
			map = systemRelatedMasterHandlerService.showQualificationMasterJsp();
		   
		  }catch (Exception e) {
		   e.printStackTrace();
		  }
		  jsp=HR_QUALIFICATION_MASTER_JSP;
		  title="Delete Qualification Master";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
		}
		

		//******************************************* End of Qualification Master By Atul***************************************************//
		
		
		//****************************************** Start Of Institute Master by Atul ****************************//
		
		@SuppressWarnings("unchecked")
		public ModelAndView showInstituteMasterJsp(HttpServletRequest request,HttpServletResponse response)
		{

			Map map = new HashMap();
			map = systemRelatedMasterHandlerService.showInstituteMasterJsp();
			String jsp=HR_INSTITUTE_MASTER_JSP;
			jsp += ".jsp";
			title = "Institute Master";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index","map",map);
		}
		
		@SuppressWarnings("unchecked")
		public ModelAndView addInstituteMaster(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			HrMasInstitute hrMasInstitute=new HrMasInstitute();
			
			String changedBy = "";
			Date changedDate = null;
			String changedTime = "";
			int hospitalId=0;
			
			session = request.getSession();
			
			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			
								
			Map<String,Object> listMap=new HashMap<String,Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}		
					
			
			if(request.getParameter(CHANGED_BY) != null && (!(request.getParameter(CHANGED_BY).equals("")))){
				changedBy = request.getParameter(CHANGED_BY);
			}
			
			
			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
				currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			}
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				currentTime = request.getParameter(CHANGED_TIME);
			}
			if(request.getParameter("title") != null){
				title = request.getParameter("title"); 
			}
			if(request.getParameter("pojoName") != null){
				pojoName = request.getParameter("pojoName"); 
			}
			if(request.getParameter("pojoPropertyName") != null){
				pojoPropertyName = request.getParameter("pojoPropertyName"); 
			}
			if(request.getParameter("pojoPropertyCode") != null){
				pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
			}
			generalMap.put("code", code);
			generalMap.put("name", name);
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);
			listMap = systemRelatedMasterHandlerService.checkForExistingMasters(generalMap);
			List instituteCodeList = new ArrayList();
			List instituteNameList = new  ArrayList();
			
				
			
			if(listMap.get("duplicateGeneralCodeList") != null){
				instituteCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				instituteNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			
			boolean successfullyAdded = false;
		
		    if((instituteCodeList.size() == 0 || instituteCodeList == null))
			{
					hrMasInstitute.setInstituteCode(code);
					hrMasInstitute.setInstituteName(name);
									
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					hrMasInstitute.setCompany(masHospital);
					
					hrMasInstitute.setStatus("y");
					hrMasInstitute.setLastChgBy(changedBy);
					hrMasInstitute.setLastChgDate(currentDate);
					hrMasInstitute.setLastChgTime(currentTime);
				successfullyAdded = systemRelatedMasterHandlerService.addInstituteMaster(hrMasInstitute);		
			
			if(successfullyAdded)
			{
				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";			
			}	}
				
			else if((instituteCodeList.size() != 0 || instituteCodeList != null) || (instituteNameList.size() != 0) || instituteNameList != null){
				if((instituteCodeList.size() != 0 || instituteCodeList != null) && (instituteNameList.size() == 0 || instituteNameList == null)){
					
				message = "Institute Code already exists.";
				}
				else if((instituteNameList.size() != 0 || instituteNameList != null) && (instituteCodeList.size() == 0 || instituteCodeList == null) ){
					
					message = "Institute Name  already exists.";
				}
				else if((instituteCodeList.size() != 0 || instituteCodeList != null) && (instituteNameList.size() != 0 || instituteNameList != null)){
					message = "Institute Code and Institute Description already exist.";
				}
			}
				 url = "erp/hrms/instituteMaster?method=showInstituteMasterJsp";
				try{
					map = systemRelatedMasterHandlerService.showInstituteMasterJsp();
				   
				  }catch (Exception e) {
					  e.printStackTrace();
				  }
				  
				  
				    String jsp=HR_INSTITUTE_MASTER_JSP;
					jsp += ".jsp";
					title = "Add Institute Master";	
					map.put("message", message);
					map.put("contentJsp", jsp);
					map.put("title", title);
					return new ModelAndView("index","map",map);
				}
		

		@SuppressWarnings("unchecked")
		public ModelAndView searchInstituteMaster(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map= new HashMap<String, Object>();
			String instituteCode = null;
			String instituteName = null;
			String searchField = null;
			int searchRadio = 1;
			
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				instituteCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))) {
				instituteName = request.getParameter(SEARCH_NAME);
			}
			try {
				if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))) {
					searchField = request.getParameter(SEARCH_FIELD);
				}
				if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))) {
					searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(searchRadio == 1) {
				instituteCode = searchField;
				instituteName = null;
			}else {
				instituteName = searchField;
				instituteCode = null;
			}
				
		
		map = systemRelatedMasterHandlerService.searchInstituteMaster(instituteCode, instituteName);
		String jsp=HR_INSTITUTE_MASTER_JSP;
		jsp += ".jsp";
		title = "Institute Master";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);		
		}
		
		
		@SuppressWarnings("unchecked")
		public ModelAndView editInstituteMaster(HttpServletRequest request, HttpServletResponse response) 
		{
			
			Map<String, Object>	map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> listMap = new HashMap<String, Object>();		
			session=request.getSession();
			
			String instituteCode="";
			String instituteName="";
			int hospitalId =0;
			int instituteId=0;
						
			String changedBy = "";
			Date changedDate = null;
			String changedTime = "";
			
	        session = request.getSession();
			
			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
						
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				instituteId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				instituteCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				instituteName = request.getParameter(SEARCH_NAME);
			}
			
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				changedBy = request.getParameter(CHANGED_BY);
			}
			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
				changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			}
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				currentTime = request.getParameter(CHANGED_TIME);
			}
			
			if(request.getParameter("title") != null){
				title = request.getParameter("title"); 
			}
			if(request.getParameter("pojoPropertyName") != null){
				pojoPropertyName = request.getParameter("pojoPropertyName"); 
			}
			if(request.getParameter("pojoName") != null){
				pojoName = request.getParameter("pojoName"); 
			}
			changedDate = new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			
			generalMap.put("id", instituteId);
			generalMap.put("code", instituteCode);
			generalMap.put("name", instituteName);
							
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);

			generalMap.put("flag", true);
			listMap = systemRelatedMasterHandlerService.checkForExistingMasters(generalMap);
		    List existingQualificationMasterList = (List)listMap.get("duplicateGeneralCodeList");
			boolean dataUpdated=false;
			if(existingQualificationMasterList.size() == 0)
			{
			dataUpdated=systemRelatedMasterHandlerService.editInstituteMaster(generalMap);
			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant be updated !!";
			}
			} 
			else if(existingQualificationMasterList.size() > 0){
				message = "Name already exists.";
			}
			url = "/erp/hrms/instituteMaster?method=showInstituteMasterJsp";
			try{
				map = systemRelatedMasterHandlerService.showInstituteMasterJsp();
			   
			  }catch (Exception e) {
				  e.printStackTrace();
			  }
			  jsp=HR_INSTITUTE_MASTER_JSP;
			  title="Edit Institute Master";
			  jsp += ".jsp";
			  map.put("contentJsp", jsp);
			  map.put("title", title);
			  map.put("message", message);
			  return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView deleteInstituteMaster(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int instituteId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			instituteId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
		
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=systemRelatedMasterHandlerService.deleteInstituteMaster(instituteId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/erp/hrms/instituteMaster?method=showInstituteMasterJsp";
		
		try{
			map = systemRelatedMasterHandlerService.showInstituteMasterJsp();
		   
		  }catch (Exception e) {
		   e.printStackTrace();
		  }
		  jsp=HR_INSTITUTE_MASTER_JSP;
		  title="Delete Institute Master";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
		}
		

		//******************************************* End of Institute Master By Rajendra***************************************************//


		
}
