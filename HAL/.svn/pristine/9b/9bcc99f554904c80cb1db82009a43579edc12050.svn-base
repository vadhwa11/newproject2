package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.ACCOUNT_TYPE_JSP;
import static jkt.hms.util.RequestConstants.BANK_CODE;
import static jkt.hms.util.RequestConstants.BANK_JSP;
import static jkt.hms.util.RequestConstants.BANK_NAME;
import static jkt.hms.util.RequestConstants.BILL_TYPE_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHARGE_TYPE_JSP;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
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

import jkt.hms.masters.business.MasAccountType;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBillType;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.handler.BillingMasterHandlerService;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BillingMasterController extends MultiActionController {

	BillingMasterHandlerService billingMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String message = " ";
	String url = "";
	String code = "";
	String name = "";
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	HttpSession session = null;
	String viewPage = "";
	String currentTime = "";

	// ----------------------------------- Account
	// Type--------------------------------------

	public ModelAndView searchAccountType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String accountTypeCode = null;
		String accountTypeName = null;
		String searchField = null;
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			accountTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			accountTypeName = request.getParameter(SEARCH_NAME);
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
			accountTypeCode = searchField;
			accountTypeName = null;
		} else {
			accountTypeCode = null;
			accountTypeName = searchField;
		}
		map = billingMasterHandlerService.searchAccountType(accountTypeCode,
				accountTypeName);
		jsp = ACCOUNT_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("accountTypeCode", accountTypeCode);
		map.put("accountTypeName", accountTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showAccountTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = billingMasterHandlerService.showAccountTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchAccountTypeList = (ArrayList) map
				.get("searchAccountTypeList");
		jsp = ACCOUNT_TYPE_JSP;
		jsp += ".jsp";
		title = "AccountType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAccountType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasAccountType masAccountType = new MasAccountType();

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

		List accountTypeCodeList = new ArrayList();
		List accountTypeNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			accountTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			accountTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((accountTypeCodeList.size() == 0 || accountTypeCodeList == null)
				&& (accountTypeNameList.size() == 0 || accountTypeNameList == null)) {
			masAccountType.setAccountTypeCode(code);
			masAccountType.setAccountTypeName(name);
			masAccountType.setStatus("y");
			masAccountType.setLastChgBy(changedBy);
			masAccountType.setLastChgDate(currentDate);
			masAccountType.setLastChgTime(currentTime);
			successfullyAdded = billingMasterHandlerService
					.addAccountType(masAccountType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((accountTypeCodeList.size() != 0 || accountTypeCodeList != null)
				|| (accountTypeNameList.size() != 0)
				|| accountTypeNameList != null) {

			if ((accountTypeCodeList.size() != 0 || accountTypeCodeList != null)
					&& (accountTypeNameList.size() == 0 || accountTypeNameList == null)) {

				message = "Account Type Code  already exists.";
			} else if ((accountTypeNameList.size() != 0 || accountTypeNameList != null)
					&& (accountTypeCodeList.size() == 0 || accountTypeCodeList == null)) {

				message = "Account Type Name already exists.";
			} else if ((accountTypeCodeList.size() != 0 || accountTypeCodeList != null)
					&& (accountTypeNameList.size() != 0 || accountTypeNameList != null)) {
				message = "Account Type Code and Account Type Name already exist.";
			}
		}
		url = "/hms/hms/billingMaster?method=showAccountTypeJsp";
		try {
			map = billingMasterHandlerService.showAccountTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ACCOUNT_TYPE_JSP;
		title = "Add Account Type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editAccountType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String accountTypeCode = "";
		String accountTypeName = "";
		int accountTypeId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		accountTypeName = (String) session.getAttribute("chargeTypeName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			accountTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			accountTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			accountTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", accountTypeId);
		generalMap.put("accountTypeCode", accountTypeCode);
		generalMap.put("name", accountTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingAccountTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingAccountTypeNameList.size() == 0) {
			dataUpdated = billingMasterHandlerService
					.editAccountTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingAccountTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/billingMaster?method=showAccountTypeJsp";

		try {
			map = billingMasterHandlerService.showAccountTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ACCOUNT_TYPE_JSP;
		title = "Edit Account Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteAccountType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int accountTypeId = 0;
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
			accountTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = billingMasterHandlerService.deleteAccountType(
				accountTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/billingMaster?method=showAccountTypeJsp";

		try {
			map = billingMasterHandlerService.showAccountTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ACCOUNT_TYPE_JSP;
		title = "Delete Account Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// --------------------------------------- Charge
	// Type---------------------------------------------

	public ModelAndView searchChargeType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String chargeTypeCode = null;
		String chargeTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			chargeTypeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			chargeTypeName = request.getParameter(SEARCH_NAME);
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
			chargeTypeCode = searchField;
			chargeTypeName = null;

		} else {
			chargeTypeCode = null;
			chargeTypeName = searchField;
		}
		map = billingMasterHandlerService.searchChargeType(chargeTypeCode,
				chargeTypeName);
		jsp = CHARGE_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("chargeTypeCode", chargeTypeCode);
		map.put("chargeTypeName", chargeTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showChargeTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = billingMasterHandlerService.showChargeTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchChargeTypeList = (ArrayList) map
				.get("searchChargeTypeList");
		jsp = CHARGE_TYPE_JSP;
		jsp += ".jsp";
		title = "ChargeType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addChargeType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasChargeType masChargeType = new MasChargeType();

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

		List chargeTypeCodeList = new ArrayList();
		List chargeTypeNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			chargeTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			chargeTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((chargeTypeCodeList.size() == 0 || chargeTypeCodeList == null)
				&& (chargeTypeNameList.size() == 0 || chargeTypeNameList == null)) {
			masChargeType.setChargeTypeCode(code);
			masChargeType.setChargeTypeName(name);
			masChargeType.setStatus("y");
			masChargeType.setLastChgBy(changedBy);
			masChargeType.setLastChgDate(currentDate);
			masChargeType.setLastChgTime(currentTime);
			successfullyAdded = billingMasterHandlerService
					.addChargeType(masChargeType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((chargeTypeCodeList.size() != 0 || chargeTypeCodeList != null)
				|| (chargeTypeNameList.size() != 0)
				|| chargeTypeNameList != null) {

			if ((chargeTypeCodeList.size() != 0 || chargeTypeCodeList != null)
					&& (chargeTypeNameList.size() == 0 || chargeTypeNameList == null)) {

				message = "Charge Type Code  already exists.";
			} else if ((chargeTypeNameList.size() != 0 || chargeTypeNameList != null)
					&& (chargeTypeCodeList.size() == 0 || chargeTypeCodeList == null)) {

				message = "Charge Type Name already exists.";
			} else if ((chargeTypeCodeList.size() != 0 || chargeTypeCodeList != null)
					&& (chargeTypeNameList.size() != 0 || chargeTypeNameList != null)) {
				message = "Charge Type Code and Charge Type Name already exist.";
			}
		}

		url = "/hms/hms/billingMaster?method=showChargeTypeJsp";
		try {
			map = billingMasterHandlerService.showChargeTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CHARGE_TYPE_JSP;
		title = "Add Charge Type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editChargeType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String chargeTypeCode = "";
		String chargeTypeName = "";
		int chargeTypeId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		chargeTypeCode = (String) session.getAttribute("chargeTypeCode");
		chargeTypeName = (String) session.getAttribute("chargeTypeName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			chargeTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			chargeTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			chargeTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", chargeTypeId);
		generalMap.put("chargeTypeCode", chargeTypeCode);
		generalMap.put("name", chargeTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingChargeTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingChargeTypeNameList.size() == 0) {
			dataUpdated = billingMasterHandlerService
					.editChargeTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingChargeTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/billingMaster?method=showChargeTypeJsp";

		try {
			map = billingMasterHandlerService.showChargeTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CHARGE_TYPE_JSP;
		title = "Edit Charge Type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteChargeType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int chargeTypeId = 0;
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
			chargeTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = billingMasterHandlerService.deleteChargeType(
				chargeTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/billingMaster?method=showChargeTypeJsp";

		try {
			map = billingMasterHandlerService.showChargeTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CHARGE_TYPE_JSP;
		title = "Delete Charge Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ----------------------------------Bill
	// Type----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showBillTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = (Map<String, Object>) billingMasterHandlerService
				.showBillTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchBillTypeList = (ArrayList) map
				.get("searchBillTypeList");
		jsp = BILL_TYPE_JSP;
		jsp += ".jsp";
		title = "Bill Type";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchBillType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String billTypeCode = null;
		String billTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			billTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			billTypeName = request.getParameter(SEARCH_NAME);
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
			billTypeCode = searchField;
			billTypeName = null;

		} else {
			billTypeCode = null;
			billTypeName = searchField;
		}
		map = billingMasterHandlerService.searchBillType(billTypeCode,
				billTypeName);
		jsp = BILL_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("billTypeCode", billTypeCode);
		map.put("billTypeName", billTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBillType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBillType masBillType = new MasBillType();
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
		int hospitalId=0;
		if(request.getParameter(HOSPITAL_ID) != null && !(request.getParameter(HOSPITAL_ID).equals(""))){
			hospitalId =Integer.parseInt(request.getParameter(HOSPITAL_ID)) ;
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List billTypeCodeList = new ArrayList();
		List billTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			billTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			billTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((billTypeCodeList.size() == 0 || billTypeCodeList == null)
				&& (billTypeNameList.size() == 0 || billTypeNameList == null)) {
			masBillType.setBillTypeCode(code);
			masBillType.setBillTypeName(name);
			masBillType.setStatus("y");
			masBillType.setLastChgBy(changedBy);
			masBillType.setLastChgDate(currentDate);
			masBillType.setLastChgTime(currentTime);
			
			MasHospital hospital= new MasHospital();
			hospital.setId(hospitalId);
			masBillType.setHospital(hospital);
			
			successfullyAdded = billingMasterHandlerService
					.addBillType(masBillType);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((billTypeCodeList.size() != 0 || billTypeCodeList != null)
				|| (billTypeNameList.size() != 0) || billTypeNameList != null) {
			if ((billTypeCodeList.size() != 0 || billTypeCodeList != null)
					&& (billTypeNameList.size() == 0 || billTypeNameList == null)) {
				message = "Bill Type Code  already exists.";
			} else if ((billTypeNameList.size() != 0 || billTypeNameList != null)
					&& (billTypeCodeList.size() == 0 || billTypeCodeList == null)) {
				message = "Bill Type Name already exists.";
			} else if ((billTypeCodeList.size() != 0 || billTypeCodeList != null)
					&& (billTypeNameList.size() != 0 || billTypeNameList != null)) {
				message = "Bill Type Code and Bill Type Name already exist.";
			}
		}
		url = "/hms/hms/otMaster?method=showBillTypeJsp";
		try {
			map = billingMasterHandlerService.showBillTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BILL_TYPE_JSP;
		title = "Add Bill Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editBillType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String billTypeCode = "";
		String billTypeName = "";
		int billTypeId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		billTypeCode = (String) session.getAttribute("billTypeCode");
		billTypeName = (String) session.getAttribute("billTypeName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			billTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			billTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			billTypeName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", billTypeId);
		generalMap.put("billTypeCode", billTypeCode);
		generalMap.put("name", billTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBillTypeNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingBillTypeNameList.size() == 0) {
			dataUpdated = billingMasterHandlerService
					.editBillTypeToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Data Updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBillTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/otMaster?method=showBillTypeJsp";
		try {
			map = billingMasterHandlerService.showBillTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BILL_TYPE_JSP;
		title = "update Bill Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteBillType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int billTypeId = 0;
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
			billTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = billingMasterHandlerService.deleteBillType(billTypeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/otMaster?method=showBillTypeJsp";
		try {
			map = billingMasterHandlerService.showBillTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BILL_TYPE_JSP;
		title = "delete Bill Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ------------------------------------------Bank
	// Master------------------------------

	public ModelAndView searchBank(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String bankCode = null;
		String bankName = null;
		String searchField = null;

		if (request.getParameter(BANK_CODE) != null
				&& !(request.getParameter(BANK_CODE).equals(""))) {
			bankCode = request.getParameter(BANK_CODE);
		}

		if (request.getParameter(BANK_NAME) != null
				&& !(request.getParameter(BANK_NAME).equals(""))) {
			bankName = request.getParameter(BANK_NAME);
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
			bankCode = searchField;
			bankName = null;
		} else {
			bankCode = null;
			bankName = searchField;
		}
		map = billingMasterHandlerService.searchBank(bankCode, bankName);
		jsp = BANK_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bankCode", bankCode);
		map.put("bankName", bankName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showBankJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = billingMasterHandlerService.showBankJsp();
		@SuppressWarnings("unused")
		ArrayList searchBankList = (ArrayList) map.get("searchBankList");
		jsp = BANK_JSP;
		jsp += ".jsp";
		title = "Bank";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBank(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasBankMaster masBank = new MasBankMaster();
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

		List bankCodeList = new ArrayList();
		List bankNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bankCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			bankNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((bankCodeList.size() == 0 || bankCodeList == null)
				&& (bankNameList.size() == 0 || bankNameList == null)) {
			masBank.setBankCode(code);
			masBank.setBankName(name);
			masBank.setStatus("y");
			masBank.setLastChgBy(changedBy);
			masBank.setLastChgDate(currentDate);
			masBank.setLastChgTime(currentTime);
			successfullyAdded = billingMasterHandlerService.addBank(masBank);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((bankCodeList.size() != 0 || bankCodeList != null)
				|| (bankNameList.size() != 0) || bankNameList != null) {

			if ((bankCodeList.size() != 0 || bankCodeList != null)
					&& (bankNameList.size() == 0 || bankNameList == null)) {

				message = "Bank Code  already exists.";
			} else if ((bankNameList.size() != 0 || bankNameList != null)
					&& (bankCodeList.size() == 0 || bankCodeList == null)) {

				message = "Bank Name already exists.";
			} else if ((bankCodeList.size() != 0 || bankCodeList != null)
					&& (bankNameList.size() != 0 || bankNameList != null)) {

				message = "Bank Code and Bank Name already exist.";
			}
		}

		url = "/hms/hms/billingMaster?method=showBankJsp";

		try {
			map = billingMasterHandlerService.showBankJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BANK_JSP;
		title = "Add Bank";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editBank(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String bankCode = "";
		String bankName = "";
		int bankId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		bankCode = (String) session.getAttribute("bankCode");
		bankName = (String) session.getAttribute("bankName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bankId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bankCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bankName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", bankId);
		generalMap.put("bankCode", bankCode);
		generalMap.put("name", bankName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBankNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBankNameList.size() == 0) {
			dataUpdated = billingMasterHandlerService
					.editBankToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingBankNameList.size() > 0) {

			message = "Name already exists.";

		}
		url = "/hms/hms/billingMaster?method=showBankJsp";

		try {
			map = billingMasterHandlerService.showBankJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BANK_JSP;
		title = "Edit Bank";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteBank(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int bankId = 0;
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
			bankId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = billingMasterHandlerService
				.deleteBank(bankId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/billingMaster?method=showBankJsp";

		try {
			map = billingMasterHandlerService.showBankJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BANK_JSP;
		title = "Delete Bank";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// ----------------------------------------------------------------------------------------------------
	public BillingMasterHandlerService getBillingMasterHandlerService() {
		return billingMasterHandlerService;
	}

	public void setBillingMasterHandlerService(
			BillingMasterHandlerService billingMasterHandlerService) {
		this.billingMasterHandlerService = billingMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
