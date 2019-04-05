package jkt.hms.masters.controller;
import static jkt.hms.util.RequestConstants.FROM_TIME;
import static jkt.hms.util.RequestConstants.TO_TIME;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.ATTACHED;
import static jkt.hms.util.RequestConstants.AUTHORIZER_JSP;
import static jkt.hms.util.RequestConstants.BED_JSP;
import static jkt.hms.util.RequestConstants.BED_STATUS_ID;
import static jkt.hms.util.RequestConstants.BLOOD_GROUP_CODE;
import static jkt.hms.util.RequestConstants.CASE_TYPE_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHARGE;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_CODE;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_JSP;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_NAME;
import static jkt.hms.util.RequestConstants.CHARGE_TYPE_ID;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.COMPLAINT_JSP;
import static jkt.hms.util.RequestConstants.COMPLICATION_JSP;
import static jkt.hms.util.RequestConstants.CONFIDENTIAL;
import static jkt.hms.util.RequestConstants.COST_CENTER_JSP;
import static jkt.hms.util.RequestConstants.CRITERIA;
import static jkt.hms.util.RequestConstants.DEATH_CAUSE_JSP;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.OT_ID;
import static jkt.hms.util.RequestConstants.DIAG_ID;
import static jkt.hms.util.RequestConstants.DIAG_PARAM_JSP;
import static jkt.hms.util.RequestConstants.DIET_TYPE;
import static jkt.hms.util.RequestConstants.DISCARD_DATE;
import static jkt.hms.util.RequestConstants.DSICHARGE_SUMMARY;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.ICD_CAUSE_GROUP_ID;
import static jkt.hms.util.RequestConstants.ICD_CAUSE_GROUP_JSP;
import static jkt.hms.util.RequestConstants.ICD_JSP;
import static jkt.hms.util.RequestConstants.ICD_MAIN_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.ICD_MAIN_CATEGORY_JSP;
import static jkt.hms.util.RequestConstants.ICD_SUB_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.ICD_SUB_CATEGORY_JSP;
import static jkt.hms.util.RequestConstants.INTRODUCTION_DATE;
import static jkt.hms.util.RequestConstants.JASPER_FILE_NAME;
import static jkt.hms.util.RequestConstants.MAIN_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.MAIN_CHARGECODE_JSP;
import static jkt.hms.util.RequestConstants.MAIN_CHRAGE_TYPE;
import static jkt.hms.util.RequestConstants.MAJOR_CATEGORY_CODE_JSP;
import static jkt.hms.util.RequestConstants.NORMAL_VALUE;
import static jkt.hms.util.RequestConstants.PATIENT_STATUS_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_TYPE_JSP;
import static jkt.hms.util.RequestConstants.PREFIX;
import static jkt.hms.util.RequestConstants.ROOM_ID;
import static jkt.hms.util.RequestConstants.ROOM_JSP;
import static jkt.hms.util.RequestConstants.ROOM_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SEQUENCE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_STATUS_JSP;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_JSP;
import static jkt.hms.util.RequestConstants.SHORT_DESCRIPTION;
import static jkt.hms.util.RequestConstants.SUB_CHARGE;
import static jkt.hms.util.RequestConstants.SUB_CHARGECODE_ID;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasComplaint;
import jkt.hms.masters.business.MasComplication;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDeathCause;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasIcdMainCategory;
import jkt.hms.masters.business.MasIcdSubCategory;
import jkt.hms.masters.business.MasIcdcausegrp;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMajorCategoryCode;
import jkt.hms.masters.business.MasPatientStatus;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRoom;
import jkt.hms.masters.business.MasRoomType;
import jkt.hms.masters.business.MasSample;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasSubTest;
import jkt.hms.masters.business.MasUnitOfMeasurement;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.HospitalDetailsMasterHandlerService;
import jkt.hms.masters.handler.ReportDataSource;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.bind.RequestUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class HospitalDetailsMasterController extends MultiActionController {
	HospitalDetailsMasterHandlerService hospitalDetailsMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
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
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	HttpSession session = null;

	// ----------------------------- Cost
	// Center----------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showCostCenterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showCostCenterJsp();
		jsp = COST_CENTER_JSP;
		jsp += ".jsp";
		title = "CostCenter";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchCostCenter(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String costCenterCode = null;
		String costCenterName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			costCenterCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			costCenterName = request.getParameter(SEARCH_NAME);
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
			costCenterCode = searchField;
			costCenterName = null;

		} else {
			costCenterCode = null;
			costCenterName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchCostCenter(
				costCenterCode, costCenterName);

		jsp = COST_CENTER_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("costCenterCode", costCenterCode);
		map.put("costCenterName", costCenterName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCostCenter(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasCostCenter masCostCenter = new MasCostCenter();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String changedBy = "";

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
		List costCenterCodeList = new ArrayList();
		List costCenterNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			costCenterCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			costCenterNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((costCenterCodeList.size() == 0 || costCenterCodeList == null)
				&& (costCenterNameList.size() == 0 || costCenterNameList == null)) {
			masCostCenter.setCostCenterCode(code);
			masCostCenter.setCostCenterName(name);
			masCostCenter.setStatus("y");
			masCostCenter.setLastChgBy(changedBy);
			masCostCenter.setLastChgDate(currentDate);
			masCostCenter.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addCostCenter(masCostCenter);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((costCenterCodeList.size() != 0 || costCenterCodeList != null)
				|| (costCenterNameList.size() != 0)
				|| costCenterNameList != null) {
			if ((costCenterCodeList.size() != 0 || costCenterCodeList != null)
					&& (costCenterNameList.size() == 0 || costCenterNameList == null)) {
				message = "Cost Center Code  already exists.";
			} else if ((costCenterNameList.size() != 0 || costCenterNameList != null)
					&& (costCenterCodeList.size() == 0 || costCenterCodeList == null)) {
				message = "Cost Center Name already exists.";
			} else if ((costCenterCodeList.size() != 0 || costCenterCodeList != null)
					&& (costCenterNameList.size() != 0 || costCenterNameList != null)) {
				message = "Cost Center Code and Cost Center Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showCostCenterJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showCostCenterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COST_CENTER_JSP;
		title = "Add Cost center";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editCostCenter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String costCenterCode = "";
		String costCenterName = "";
		int costCenterId = 0;
		String changedBy = "";
		Date changedDate = null;
		Date currentDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			costCenterId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			costCenterCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			costCenterName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", costCenterId);
		generalMap.put("costCenterCode", costCenterCode);
		generalMap.put("name", costCenterName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCostCenterNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingCostCenterNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editCostCenterToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCostCenterNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showCostCenterJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showCostCenterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COST_CENTER_JSP;
		title = "Update Cost center";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteCostCenter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int costCenterId = 0;
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
			costCenterId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteCostCenter(
				costCenterId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showCostCenterJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showCostCenterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COST_CENTER_JSP;
		title = "Delete Cost center";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ----------------------------- Major Category Code
	// -----------------------------------------

	public ModelAndView showMajorCategoryCodeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showMajorCategoryCodeJsp();
		jsp = MAJOR_CATEGORY_CODE_JSP;
		jsp += ".jsp";
		title = "MajorCategoryCode";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchMajorCategoryCode(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String majorCategoryCodeCode = null;

		String majorCategoryCodeName = null;

		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			majorCategoryCodeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			majorCategoryCodeName = request.getParameter(SEARCH_NAME);
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
			majorCategoryCodeCode = searchField;
			majorCategoryCodeName = null;

		} else {
			majorCategoryCodeCode = null;
			majorCategoryCodeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchMajorCategoryCode(
				majorCategoryCodeCode, majorCategoryCodeName);

		jsp = MAJOR_CATEGORY_CODE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("majorCategoryCodeCode", majorCategoryCodeCode);
		map.put("majorCategoryCodeName", majorCategoryCodeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMajorCategoryCode(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasMajorCategoryCode masMajorCategoryCode = new MasMajorCategoryCode();

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
		List majorCategoryCodeCodeList = new ArrayList();
		List majorCategoryCodeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			majorCategoryCodeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			majorCategoryCodeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((majorCategoryCodeCodeList.size() == 0 || majorCategoryCodeCodeList == null)
				&& (majorCategoryCodeNameList.size() == 0 || majorCategoryCodeNameList == null)) {
			masMajorCategoryCode.setMajorCategoryCode(code);
			masMajorCategoryCode.setMajorCategoryName(name);
			masMajorCategoryCode.setStatus("y");
			masMajorCategoryCode.setLastChgBy(changedBy);
			masMajorCategoryCode.setLastChgDate(currentDate);
			masMajorCategoryCode.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addMajorCategoryCode(masMajorCategoryCode);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((majorCategoryCodeCodeList.size() != 0 || majorCategoryCodeCodeList != null)
				|| (majorCategoryCodeNameList.size() != 0)
				|| majorCategoryCodeNameList != null) {

			if ((majorCategoryCodeCodeList.size() != 0 || majorCategoryCodeCodeList != null)
					&& (majorCategoryCodeNameList.size() == 0 || majorCategoryCodeNameList == null)) {
				message = "major Category Code  already exists.";
			} else if ((majorCategoryCodeNameList.size() != 0 || majorCategoryCodeNameList != null)
					&& (majorCategoryCodeCodeList.size() == 0 || majorCategoryCodeCodeList == null)) {
				message = "major Category Name already exists.";
			} else if ((majorCategoryCodeCodeList.size() != 0 || majorCategoryCodeCodeList != null)
					&& (majorCategoryCodeNameList.size() != 0 || majorCategoryCodeNameList != null)) {
				message = "major Category Code and major Category Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showMajorCategoryCodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService
					.showMajorCategoryCodeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MAJOR_CATEGORY_CODE_JSP;
		title = "Add Major Category code";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editMajorCategoryCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String majorCategoryCode = "";
		String majorCategoryName = "";
		int majorCtegoryCodeId = 0;
		String changedBy = "";
		Date changedDate = null;
		Date currentDate = null;
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			majorCtegoryCodeId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			majorCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			majorCategoryName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", majorCtegoryCodeId);
		generalMap.put("majorCategoryCode", majorCategoryCode);
		generalMap.put("name", majorCategoryName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingMajorCategoryCodeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingMajorCategoryCodeNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editMajorCategoryCodeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingMajorCategoryCodeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showMajorCategoryCodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService
					.showMajorCategoryCodeJsp();
		} catch (Exception e) {
			//System.out.println("Exception in showMajorCategoryCodeJsp " + e);
		}
		jsp = MAJOR_CATEGORY_CODE_JSP;
		title = "Update Major Category code";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteMajorCategoryCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int majorCategoryCodeId = 0;
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
			majorCategoryCodeId = Integer.parseInt(request
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
		dataDeleted = hospitalDetailsMasterHandlerService
				.deleteMajorCategoryCode(majorCategoryCodeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/hospital?method=showMajorCategoryCodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService
					.showMajorCategoryCodeJsp();
		} catch (Exception e) {
			//System.out.println("Exception in showMajorCategoryCodeJsp " + e);
		}
		jsp = MAJOR_CATEGORY_CODE_JSP;
		title = "Delete Major Category code";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// --------------------------------------------Death Cause
	// -----------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showDeathCauseJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showDeathCauseJsp();
		@SuppressWarnings("unused")
		ArrayList searchTitleList = (ArrayList) map.get("searchTitleList");
		jsp = DEATH_CAUSE_JSP;
		jsp += ".jsp";
		title = "deathCause";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchDeathCause(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String deathCauseCode = null;
		String deathCauseName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			deathCauseCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			deathCauseName = request.getParameter(SEARCH_NAME);
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
			deathCauseCode = searchField;
			deathCauseName = null;

		} else {
			deathCauseCode = null;
			deathCauseName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchDeathCause(
				deathCauseCode, deathCauseName);
		jsp = DEATH_CAUSE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deathCauseCode", deathCauseCode);
		map.put("deathCauseName", deathCauseName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDeathCause(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasDeathCause masDeathCause = new MasDeathCause();
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
		List deathCauseCodeList = new ArrayList();
		List deathCauseNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			deathCauseCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			deathCauseNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((deathCauseCodeList.size() == 0 || deathCauseCodeList == null)
				&& (deathCauseNameList.size() == 0 || deathCauseNameList == null)) {
			masDeathCause.setDeathCauseCode(code);
			masDeathCause.setDeathCauseName(name);
			masDeathCause.setStatus("y");
			masDeathCause.setLastChgBy(changedBy);
			masDeathCause.setLastChgDate(currentDate);
			masDeathCause.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addDeathCause(masDeathCause);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((deathCauseCodeList.size() != 0 || deathCauseCodeList != null)
				|| (deathCauseNameList.size() != 0)
				|| deathCauseNameList != null) {
			if ((deathCauseCodeList.size() != 0 || deathCauseCodeList != null)
					&& (deathCauseNameList.size() == 0 || deathCauseNameList == null)) {
				message = "Death Cause Code  already exists.";
			} else if ((deathCauseNameList.size() != 0 || deathCauseNameList != null)
					&& (deathCauseCodeList.size() == 0 || deathCauseCodeList == null)) {
				message = "Death Cause Name already exists.";
			} else if ((deathCauseCodeList.size() != 0 || deathCauseCodeList != null)
					&& (deathCauseNameList.size() != 0 || deathCauseNameList != null)) {
				message = "Death Cause Code and Death Cause Name already exist.";
			}

		}
		url = "/hms/hms/hospital?method=showDeathCauseJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showDeathCauseJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEATH_CAUSE_JSP;
		title = "Add Death Cause";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editDeathCause(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String deathCauseCode = "";
		String deathCauseName = "";
		int deathCauseId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			deathCauseId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			deathCauseCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			deathCauseName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", deathCauseId);
		generalMap.put("deathCauseCode", deathCauseCode);
		generalMap.put("name", deathCauseName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDeathCauseNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDeathCauseNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editDeathCauseToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingDeathCauseNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showDeathCauseJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showDeathCauseJsp();
		} catch (Exception e) {
			//System.out.println("Exception in showDeathCauseJsp " + e);
		}
		jsp = DEATH_CAUSE_JSP;
		title = "Update Death Cause";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteDeathCause(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deathCauseId = 0;
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
			deathCauseId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteDeathCause(
				deathCauseId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/hospital?method=showDeathCauseJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showDeathCauseJsp();
		} catch (Exception e) {
			//System.out.println("Exception in showDeathCauseJsp " + e);
		}
		jsp = DEATH_CAUSE_JSP;
		title = "Delete Death Cause";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ------------------------------------Patient_Status
	// -----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showPatientStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = (Map<String, Object>) hospitalDetailsMasterHandlerService
				.showPatientStatusJsp();
		jsp = PATIENT_STATUS_JSP;
		jsp += ".jsp";
		title = "PatientStatus";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchPatientStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String patientStatusCode = null;
		String patientStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(BLOOD_GROUP_CODE).equals(""))) {
			patientStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			patientStatusName = request.getParameter(SEARCH_NAME);
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
			patientStatusCode = searchField;
			patientStatusName = null;
		} else {
			patientStatusCode = null;
			patientStatusName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchPatientStatus(
				patientStatusCode, patientStatusName);
		jsp = PATIENT_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("patientStatusCode", patientStatusCode);
		map.put("patientStatusName", patientStatusName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPatientStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasPatientStatus masPatientStatus = new MasPatientStatus();
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
		List patientStatusCodeList = new ArrayList();
		List patientStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			patientStatusCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			patientStatusNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((patientStatusCodeList.size() == 0 || patientStatusCodeList == null)
				&& (patientStatusNameList.size() == 0 || patientStatusNameList == null)) {
			masPatientStatus.setPatientStatusCode(code);
			masPatientStatus.setPatientStatusName(name);
			masPatientStatus.setStatus("y");
			masPatientStatus.setLastChgBy(changedBy);
			masPatientStatus.setLastChgDate(currentDate);
			masPatientStatus.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addPatientStatus(masPatientStatus);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((patientStatusCodeList.size() != 0 || patientStatusCodeList != null)
				|| (patientStatusNameList.size() != 0)
				|| patientStatusNameList != null) {

			if ((patientStatusCodeList.size() != 0 || patientStatusCodeList != null)
					&& (patientStatusNameList.size() == 0 || patientStatusNameList == null)) {
				message = "Patient Status Code  already exists.";
			} else if ((patientStatusNameList.size() != 0 || patientStatusNameList != null)
					&& (patientStatusCodeList.size() == 0 || patientStatusCodeList == null)) {
				message = "Patient Status Name already exists.";
			} else if ((patientStatusCodeList.size() != 0 || patientStatusCodeList != null)
					&& (patientStatusNameList.size() != 0 || patientStatusNameList != null)) {
				message = "Patient Status Code and Patient Status Name already exist.";
			}
		}
		url = "/hms/hms/hospital?method=showPatientStatusJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showPatientStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PATIENT_STATUS_JSP;
		title = "Add Patient Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editPatientStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String patientStatusCode = "";
		String patientStatusName = "";
		int patientStatusId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			patientStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			patientStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			patientStatusName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", patientStatusId);
		generalMap.put("patientStatusCode", patientStatusCode);
		generalMap.put("name", patientStatusName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingPatientStatusNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingPatientStatusNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editPatientStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingPatientStatusNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showPatientStatusJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showPatientStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PATIENT_STATUS_JSP;
		title = "Update Patient Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deletePatientStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int patientStatusId = 0;
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
			patientStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deletePatientStatus(
				patientStatusId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showPatientStatusJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showPatientStatusJsp();
		} catch (Exception e) {
			//System.out.println("Exception in showPatientStatusJsp " + e);
		}
		jsp = PATIENT_STATUS_JSP;
		title = "Delete Patient Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -------------------------------------------------BED
	// MASTER-----------------------------------------------------

	public ModelAndView showBedJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		
		map = hospitalDetailsMasterHandlerService.showBedJsp(hospitalId);
		jsp = BED_JSP;
		jsp += ".jsp";
		title = "Bed";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchBed(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		int depId = 0;

		if (request.getParameter("depId") != null
				&& !(request.getParameter("depId").equals("0"))) {
			depId =Integer.parseInt(request.getParameter("depId"));
		}
		session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		
		map = hospitalDetailsMasterHandlerService.searchBed(depId,hospitalId);
		jsp = BED_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("depId", depId);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBed(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasBed masBed = new MasBed();
		String bedNumber = "";
		int departmentId = 0;
		int roomId = 0;
		int bedStatusId = 0;
		String adNo = "";
		String dietType = "";
		String attached = "";
		Date introductionDate = null;
		Date discardDate = null;
		Date changedDate = null;
		String changedBy = "";
		String changedTime = "";
		int hospitalId = 0;
		Integer userId = (Integer) session.getAttribute("userId");
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bedNumber = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(ROOM_ID) != null && !(request.getParameter(ROOM_ID).equals("0"))) {
			roomId = Integer.parseInt(request.getParameter(ROOM_ID));
		}
		if (request.getParameter(BED_STATUS_ID) != null) {
			bedStatusId = Integer.parseInt(request.getParameter(BED_STATUS_ID));
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		if (request.getParameter(DIET_TYPE) != null) {
			dietType = request.getParameter(DIET_TYPE);
		}
		if (request.getParameter(ATTACHED) != null) {
			masBed.setAttached(request.getParameter(ATTACHED));
		} else {
			masBed.setAttached("n");
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
		if (request.getParameter(INTRODUCTION_DATE) != null) {
			introductionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(INTRODUCTION_DATE));
		}
		if (request.getParameter(DISCARD_DATE) != null) {
			discardDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DISCARD_DATE));
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
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer
					.parseInt(request.getParameter(HOSPITAL_ID));
		}
		generalMap.put("name", bedNumber);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("roomId", roomId);
		
		/*listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);*/
		listMap = hospitalDetailsMasterHandlerService.checkExistingBedNo(generalMap);
		List bedNumberList = new ArrayList();

		if (listMap.get("bedNumberList") != null) {
			bedNumberList = (List) listMap.get("bedNumberList");
		}

		boolean successfullyAdded = false;
		if (bedNumberList.size() == 0) {
			masBed.setBedNo(bedNumber);

			MasDepartment departmentObj = new MasDepartment();
			departmentObj.setId(departmentId);
			masBed.setDepartment(departmentObj);

			if(roomId!=0){
				MasRoom masRoom = new MasRoom();
				masRoom.setId(roomId);
				masBed.setRoom(masRoom);
		}


			MasBedStatus bedStatusObj = new MasBedStatus();
			bedStatusObj.setId(bedStatusId);
			masBed.setBedStatus(bedStatusObj);
			
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			masBed.setHospital(hospital);

			masBed.setAdNo(adNo);
			masBed.setDietType(dietType);
			masBed.setIntroductionDate(introductionDate);
			masBed.setDiscardDate(discardDate);
			masBed.setStatus("y");
			Users users=new Users();
			users.setId(userId);
			masBed.setLastChgBy(users);
			
			masBed.setLastChgDate(changedDate);
			masBed.setLastChgTime(changedTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addBed(masBed);
			if (successfullyAdded == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if (bedNumberList.size() != 0) {
			message = "Bed Number already exists.";
		}
		try {
			map = hospitalDetailsMasterHandlerService.showBedJsp(hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BED_JSP;
		title = "Add Bed";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editBed(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasBed masBed = new MasBed();
		String bedNumber = "";
		int bedId = 0;
		int departmentId = 0;
		int roomId = 0;
		int bedStatusId = 0;
		String adNo = "";
		String dietType = "";
		String attached = "";
		Date introductionDate = null;
		Date discardDate = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = new Date();
		session = request.getSession();
		int hospitalId = 0;
		Integer userId = (Integer) session.getAttribute("userId");
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer
					.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bedId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bedNumber = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_ID) != "") {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(BED_STATUS_ID) != "") {
			bedStatusId = Integer.parseInt(request.getParameter(BED_STATUS_ID));
		}
		if (request.getParameter(ROOM_ID) != "") {
			roomId = Integer.parseInt(request.getParameter(ROOM_ID));
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		if (request.getParameter(DIET_TYPE) != null) {
			dietType = request.getParameter(DIET_TYPE);
		}

		if (request.getParameter(ATTACHED) != null) {
			attached = request.getParameter(ATTACHED);
			//masBed.setAttached(request.getParameter(ATTACHED));
		} else {
			attached = "n";
			//masBed.setAttached("n");
		}

		if (request.getParameter(INTRODUCTION_DATE) != null) {
			introductionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(INTRODUCTION_DATE));
		}
		if (request.getParameter(DISCARD_DATE) != null) {
			discardDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DISCARD_DATE));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
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
		generalMap.put("id", bedId);
		generalMap.put("bedNumber", bedNumber);
		generalMap.put("departmentId", departmentId);
		generalMap.put("bedStatusId", bedStatusId);
		generalMap.put("roomId", roomId);
		generalMap.put("adNo", adNo);
		generalMap.put("dietType", dietType);
		generalMap.put("attached", attached);
		generalMap.put("introductionDate", introductionDate);
		generalMap.put("discardDate", discardDate);
		generalMap.put("userId", userId);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("hospitalId", hospitalId);
		boolean dataUpdated = false;
		dataUpdated = hospitalDetailsMasterHandlerService
				.editBedToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/hospital?method=showBedJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showBedJsp(hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BED_JSP;
		title = "Add Bed";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteBed(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int bedId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int hospitalId = 0;
		Integer userId = (Integer) session.getAttribute("userId");
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer
					.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bedId = Integer.parseInt(request.getParameter(COMMON_ID));
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

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = hospitalDetailsMasterHandlerService.deleteBed(bedId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showBedJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showBedJsp(hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BED_JSP;
		title = "delete Bed";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------------------------Service
	// Status----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showServiceStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showServiceStatusJsp();
		jsp = SERVICE_STATUS_JSP;
		jsp += ".jsp";
		title = "ServiceStatus";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchServiceStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceStatusCode = null;
		String serviceStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			serviceStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			serviceStatusName = request.getParameter(SEARCH_NAME);
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
			serviceStatusCode = searchField;
			serviceStatusName = null;
		} else {
			serviceStatusCode = null;
			serviceStatusName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchServiceStatus(
				serviceStatusCode, serviceStatusName);

		jsp = SERVICE_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("serviceStatusCode", serviceStatusCode);
		map.put("serviceStatusName", serviceStatusName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addServiceStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasServiceStatus masServiceStatus = new MasServiceStatus();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String changedBy = "";

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

		List serviceStatusCodeList = new ArrayList();
		List serviceStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			serviceStatusCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			serviceStatusNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((serviceStatusCodeList.size() == 0 || serviceStatusCodeList == null)
				&& (serviceStatusNameList.size() == 0 || serviceStatusNameList == null)) {
			masServiceStatus.setServiceStatusCode(code);
			masServiceStatus.setServiceStatusName(name);
			masServiceStatus.setStatus("y");
			masServiceStatus.setLastChgBy(changedBy);
			masServiceStatus.setLastChgDate(currentDate);
			masServiceStatus.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addServiceStatus(masServiceStatus);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		}

		else if ((serviceStatusCodeList.size() != 0 || serviceStatusCodeList != null)
				|| (serviceStatusNameList.size() != 0)
				|| serviceStatusNameList != null) {
			if ((serviceStatusCodeList.size() != 0 || serviceStatusCodeList != null)
					&& (serviceStatusNameList.size() == 0 || serviceStatusNameList == null)) {
				message = "Service Status Code  already exists.";
			} else if ((serviceStatusNameList.size() != 0 || serviceStatusNameList != null)
					&& (serviceStatusCodeList.size() == 0 || serviceStatusCodeList == null)) {
				message = "Service Status Name already exists.";
			} else if ((serviceStatusCodeList.size() != 0 || serviceStatusCodeList != null)
					&& (serviceStatusNameList.size() != 0 || serviceStatusNameList != null)) {
				message = "Service Status Code and Service Status Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showServiceStatusJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showServiceStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SERVICE_STATUS_JSP;
		title = "Add Service Status";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView editServiceStatus(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String serviceStatusCode = "";
		String serviceStatusName = "";
		int serviceStatusId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		serviceStatusCode = (String) session.getAttribute("serviceStatusCode");
		serviceStatusName = (String) session.getAttribute("serviceStatusName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			serviceStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			serviceStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			serviceStatusName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", serviceStatusId);
		generalMap.put("serviceStatusCode", serviceStatusCode);
		generalMap.put("name", serviceStatusName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingServiceStatusNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingServiceStatusNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editServiceStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingServiceStatusNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showServiceStatusJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showServiceStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SERVICE_STATUS_JSP;
		title = "Edit Service Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteServiceStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int serviceStatusId = 0;
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
			serviceStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteServiceStatus(
				serviceStatusId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showServiceStatusJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showServiceStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SERVICE_STATUS_JSP;
		title = "Delete Service Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ----------------------------- Case Type -------------------------
	public ModelAndView searchCaseType(HttpServletRequest request,
			HttpServletResponse response)

	throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String caseTypeCode = null;
		String caseTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			caseTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			caseTypeName = request.getParameter(SEARCH_NAME);
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
			caseTypeCode = searchField;
			caseTypeName = null;

		} else {
			caseTypeCode = null;
			caseTypeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchCaseType(caseTypeCode,
				caseTypeName);

		jsp = CASE_TYPE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("caseTypeCode", caseTypeCode);
		map.put("caseTypeName", caseTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showCaseTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showCaseTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchCaseTypeList = (ArrayList) map
				.get("searchCaseTypeList");
		jsp = CASE_TYPE_JSP;
		jsp += ".jsp";
		title = "CaseType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCaseType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasCaseType masCaseType = new MasCaseType();

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

		List caseTypeCodeList = new ArrayList();
		List caseTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			caseTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			caseTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((caseTypeNameList.size() == 0 || caseTypeNameList == null)
				&& (caseTypeNameList.size() == 0 || caseTypeNameList == null)) {
			masCaseType.setCaseTypeCode(code);
			masCaseType.setCaseTypeName(name);
			masCaseType.setStatus("y");
			masCaseType.setLastChgBy(changedBy);
			masCaseType.setLastChgDate(currentDate);
			masCaseType.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addCaseType(masCaseType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((caseTypeCodeList.size() != 0 || caseTypeCodeList != null)
				|| (caseTypeNameList.size() != 0) || caseTypeNameList != null) {

			if ((caseTypeCodeList.size() != 0 || caseTypeCodeList != null)
					&& caseTypeNameList.size() == 0 || caseTypeNameList == null) {
				message = "CT Code  already exists.";
			} else if ((caseTypeNameList.size() != 0 || caseTypeNameList != null)
					&& (caseTypeCodeList.size() == 0 || caseTypeCodeList == null)) {

				message = "CT Name already exists.";
			} else if ((caseTypeCodeList.size() != 0 || caseTypeCodeList != null)
					&& (caseTypeNameList.size() != 0 || caseTypeNameList != null)) {

				message = "CT Code and CT Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showCaseTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showCaseTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CASE_TYPE_JSP;
		title = "Add Case type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView editCaseType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String caseTypeCode = "";
		String caseTypeName = "";
		int caseTypeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			caseTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			caseTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			caseTypeName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", caseTypeId);
		generalMap.put("caseTypeCode", caseTypeCode);
		generalMap.put("name", caseTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCaseTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingCaseTypeNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editCaseTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCaseTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showCaseTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showCaseTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CASE_TYPE_JSP;
		title = "Edit Case type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteCaseType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int caseTypeId = 0;
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
			caseTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteCaseType(
				caseTypeId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showCaseTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showCaseTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CASE_TYPE_JSP;
		title = "Delete Case type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// ----------------------------- Main Charge
	// Code-----------------------------

	public ModelAndView searchMainChargecode(HttpServletRequest request,
			HttpServletResponse esponse) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String mainChargecodeCode = null;
		String mainChargecodeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			mainChargecodeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			mainChargecodeName = request.getParameter(SEARCH_NAME);
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
			mainChargecodeCode = searchField;
			mainChargecodeName = null;

		} else {
			mainChargecodeCode = null;
			mainChargecodeName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchMainChargecode(
				mainChargecodeCode, mainChargecodeName);

		jsp = MAIN_CHARGECODE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("mainChargecodeCode", mainChargecodeCode);
		map.put("mainChargecodeName", mainChargecodeName);

		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showMainChargecodeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = hospitalDetailsMasterHandlerService.showMainChargecodeJsp();
		@SuppressWarnings("unused")
		ArrayList searchMainChargecodeList = (ArrayList) map
				.get("searchMainChargecodeList");
		jsp = MAIN_CHARGECODE_JSP;
		jsp += ".jsp";
		title = "MainChargecode";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMainChargecode(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasMainChargecode masMainChargecode = new MasMainChargecode();

		String changedBy = "";
		String mainChargeType = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int deptId = 0;
		if (request.getParameter(DEPARTMENT_ID) != null) {
			deptId = Integer.valueOf(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(MAIN_CHRAGE_TYPE) != null) {
			mainChargeType = request.getParameter(MAIN_CHRAGE_TYPE);
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
		generalMap.put("mainChargeType", mainChargeType);
		generalMap.put("deptId", deptId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List mainChargecodeCodeList = new ArrayList();
		List mainChargecodeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			mainChargecodeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			mainChargecodeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((mainChargecodeNameList.size() == 0 || mainChargecodeNameList == null)
				&& (mainChargecodeNameList.size() == 0 || mainChargecodeNameList == null)) {
			masMainChargecode.setMainChargecodeCode(code);
			masMainChargecode.setMainChargecodeName(name);
			masMainChargecode.setMainchargeType(mainChargeType);
			masMainChargecode.setStatus("y");
			masMainChargecode.setLastChgBy(changedBy);
			masMainChargecode.setLastChgDate(currentDate);
			masMainChargecode.setLastChgTime(currentTime);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			masMainChargecode.setDepartment(masDepartment);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addMainChargecode(masMainChargecode);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((mainChargecodeCodeList.size() != 0 || mainChargecodeCodeList != null)
				|| (mainChargecodeNameList.size() != 0)
				|| mainChargecodeNameList != null) {

			if ((mainChargecodeCodeList.size() != 0 || mainChargecodeCodeList != null)
					&& (mainChargecodeNameList.size() == 0 || mainChargecodeNameList == null)) {

				message = "MainCharge Code  already exists.";
			} else if ((mainChargecodeNameList.size() != 0 || mainChargecodeNameList != null)
					&& (mainChargecodeCodeList.size() == 0 || mainChargecodeCodeList == null)) {

				message = "MainChargeCode Name already exists.";
			} else if ((mainChargecodeCodeList.size() != 0 || mainChargecodeCodeList != null)
					&& (mainChargecodeNameList.size() != 0 || mainChargecodeNameList != null)) {

				message = "MainCharge Code and MainChargeCode Name	already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showMainChargecodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showMainChargecodeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MAIN_CHARGECODE_JSP;
		title = "Add MainChargecode";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editMainChargecode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		int mainChargecodeId = 0;
		String mainChargecodeCode = "";
		String mainChargecodeName = "";
		String mainChargeType = "";

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		Date currentDate = null;
		int departmentId = 0;
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			mainChargecodeId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			mainChargecodeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			mainChargecodeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(MAIN_CHRAGE_TYPE) != null
				&& !(request.getParameter(MAIN_CHRAGE_TYPE).equals(""))) {
			mainChargeType = request.getParameter(MAIN_CHRAGE_TYPE);
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

		generalMap.put("id", mainChargecodeId);
		generalMap.put("mainChargecodeCode", mainChargecodeCode);
		generalMap.put("name", mainChargecodeName);
		generalMap.put("mainChargeType", mainChargeType);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("departmentId", departmentId);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingMainChargecodeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingMainChargecodeNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editMainChargecodeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingMainChargecodeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showMainChargecodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showMainChargecodeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MAIN_CHARGECODE_JSP;
		title = "Edit MainChargecode";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteMainChargecode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int mainChargecodeId = 0;
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
			mainChargecodeId = Integer
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteMainChargecode(
				mainChargecodeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showMainChargecodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showMainChargecodeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MAIN_CHARGECODE_JSP;
		title = "delete MainChargecode";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -----------------------------------------------------COMPLAINT-------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showComplaintJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showComplaintJsp();
		jsp = COMPLAINT_JSP;
		jsp += ".jsp";
		title = "Complaint";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchComplaint(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String complaintCode = null;
		String complaintName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complaintCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			complaintName = request.getParameter(SEARCH_NAME);
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
			complaintCode = searchField;
			complaintName = null;

		} else {
			complaintCode = null;
			complaintName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchComplaint(
				complaintCode, complaintName);
		jsp = COMPLAINT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("complaintCode", complaintCode);
		map.put("complaintName", complaintName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addComplaint(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasComplaint masComplaint = new MasComplaint();
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
		List complaintCodeList = new ArrayList();
		List complaintNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			complaintCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			complaintNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((complaintCodeList.size() == 0 || complaintCodeList == null)
				&& (complaintNameList.size() == 0 || complaintNameList == null)) {
			masComplaint.setComplaintCode(code);
			masComplaint.setComplaintName(name);
			masComplaint.setStatus("y");
			masComplaint.setLastChgBy(changedBy);
			masComplaint.setLastChgDate(currentDate);
			masComplaint.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addComplaint(masComplaint);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((complaintCodeList.size() != 0 || complaintCodeList != null)
				|| (complaintNameList.size() != 0) || complaintNameList != null) {
			if ((complaintCodeList.size() != 0 || complaintCodeList != null)
					&& (complaintNameList.size() == 0 || complaintNameList == null)) {

				message = "Complaint Code  already exists.";
			} else if ((complaintNameList.size() != 0 || complaintNameList != null)
					&& (complaintCodeList.size() == 0 || complaintCodeList == null)) {
				message = "Complaint Name already exists.";
			} else if ((complaintCodeList.size() != 0 || complaintCodeList != null)
					&& (complaintNameList.size() != 0 || complaintNameList != null)) {

				message = "Complaint Code and Complaint Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showComplaintJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showComplaintJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLAINT_JSP;
		title = "Add Complaint";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editComplaint(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String complaintCode = "";
		String complaintName = "";
		int complaintId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			complaintId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complaintCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			complaintName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", complaintId);
		generalMap.put("complaintCode", complaintCode);
		generalMap.put("name", complaintName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingComplaintNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingComplaintNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editComplaintToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingComplaintNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showComplaintJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showComplaintJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLAINT_JSP;
		title = "edit Complaint";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteComplaint(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int complaintId = 0;
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
			complaintId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteComplaint(
				complaintId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showComplaintJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showComplaintJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLAINT_JSP;
		title = "delete Complaint";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -----------------------------------------------------COMPLICATION----------------------------------------------

	public ModelAndView searchComplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String complicationCode = null;
		String complicationName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complicationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			complicationName = request.getParameter(SEARCH_NAME);
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
			complicationCode = searchField;
			complicationName = null;
		} else {
			complicationCode = null;
			complicationName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchComplication(
				complicationCode, complicationName);

		jsp = COMPLICATION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("complicationCode", complicationCode);
		map.put("complicationName", complicationName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showComplicationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showComplicationJsp();
		@SuppressWarnings("unused")
		ArrayList searchComplicationList = (ArrayList) map
				.get("searchComplicationList");
		jsp = COMPLICATION_JSP;
		jsp += ".jsp";
		title = "Complication";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addComplication(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasComplication masComplication = new MasComplication();
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

		List complicationCodeList = new ArrayList();
		List complicationNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			complicationCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			complicationNameList = (List) listMap
					.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((complicationNameList.size() == 0 || complicationNameList == null)
				&& (complicationNameList.size() == 0 || complicationNameList == null)) {
			masComplication.setComplicationCode(code);
			masComplication.setComplicationName(name);
			masComplication.setStatus("y");
			masComplication.setLastChgBy(changedBy);
			masComplication.setLastChgDate(currentDate);
			masComplication.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addComplication(masComplication);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((complicationCodeList.size() != 0 || complicationCodeList != null)
				|| (complicationNameList.size() != 0)
				|| complicationNameList != null) {

			if ((complicationCodeList.size() != 0 || complicationCodeList != null)
					&& (complicationNameList.size() == 0 || complicationNameList == null)) {

				message = "Complication Code  already exists.";
			} else if ((complicationNameList.size() != 0 || complicationNameList != null)
					&& (complicationCodeList.size() == 0 || complicationCodeList == null)) {

				message = "Complication Name already exists.";
			} else if ((complicationCodeList.size() != 0 || complicationCodeList != null)
					&& (complicationNameList.size() != 0 || complicationNameList != null)) {

				message = "Complication Code and Complication Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showComplicationJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showComplicationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLICATION_JSP;
		title = "add Complication";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editComplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String complicationCode = "";
		String complicationName = "";
		int complicationId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			complicationId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complicationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			complicationName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", complicationId);
		generalMap.put("complicationCode", complicationCode);
		generalMap.put("name", complicationName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingComplicationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingComplicationNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editComplicationToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingComplicationNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showComplicationJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showComplicationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLICATION_JSP;
		title = "edit Complication";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteComplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int complicationId = 0;
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
			complicationId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteComplication(
				complicationId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showComplicationJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showComplicationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLICATION_JSP;
		title = "delete Complication";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ------------------------------- Authorizer------------------------------

	public ModelAndView searchAuthorizer(HttpServletRequest request,
			HttpServletResponse response)

	throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String authorizerCode = null;
		String authorizerName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			authorizerCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			authorizerName = request.getParameter(SEARCH_NAME);
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
			authorizerCode = searchField;
			authorizerName = null;

		} else {
			authorizerCode = null;
			authorizerName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchAuthorizer(
				authorizerCode, authorizerName);
		jsp = AUTHORIZER_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("authorizerCode", authorizerCode);
		map.put("authorizerName", authorizerName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showAuthorizerJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showAuthorizerJsp();
		@SuppressWarnings("unused")
		ArrayList searchAuthorizerList = (ArrayList) map
				.get("searchAuthorizerList");
		jsp = AUTHORIZER_JSP;
		jsp += ".jsp";
		title = "Authorizer";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAuthorizer(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasAuthorizer masAuthorizer = new MasAuthorizer();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int hospitalId = 0;
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
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer
					.parseInt(request.getParameter(HOSPITAL_ID));
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List authorizerCodeList = new ArrayList();
		List authorizerNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			authorizerCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			authorizerNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((authorizerNameList.size() == 0 || authorizerNameList == null)
				&& (authorizerNameList.size() == 0 || authorizerNameList == null)) {
			masAuthorizer.setAuthorizerCode(code);
			masAuthorizer.setAuthorizerName(name);
			masAuthorizer.setStatus("y");
			masAuthorizer.setLastChgBy(changedBy);
			masAuthorizer.setLastChgDate(currentDate);
			masAuthorizer.setLastChgTime(currentTime);
			
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			masAuthorizer.setHospital(hospital);
			
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addAuthorizer(masAuthorizer);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		}

		else if ((authorizerCodeList.size() != 0 || authorizerCodeList != null)
				|| (authorizerNameList.size() != 0)
				|| authorizerNameList != null) {

			if ((authorizerCodeList.size() != 0 || authorizerCodeList != null)
					&& (authorizerNameList.size() == 0 || authorizerNameList == null)) {

				message = "Authorizer Code  already exists.";
			} else if ((authorizerNameList.size() != 0 || authorizerNameList != null)
					&& (authorizerCodeList.size() == 0 || authorizerCodeList == null)) {

				message = "Authorizer Name already exists.";
			} else if ((authorizerCodeList.size() != 0 || authorizerCodeList != null)
					&& (authorizerNameList.size() != 0 || authorizerNameList != null)) {

				message = "Authorizer Code and Authorizer Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showAuthorizerJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showAuthorizerJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = AUTHORIZER_JSP;
		title = "Add Authorizer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editAuthorizer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String authorizerCode = "";
		String authorizerName = "";
		int authorizerId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			authorizerId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			authorizerCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			authorizerName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", authorizerId);
		generalMap.put("authorizerCode", authorizerCode);
		generalMap.put("name", authorizerName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingAuthorizerNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingAuthorizerNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editAuthorizerToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingAuthorizerNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showAuthorizerJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showAuthorizerJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = AUTHORIZER_JSP;
		title = "edit Authorizer";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteAuthorizer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int authorizerId = 0;
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
			authorizerId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteAuthorizer(
				authorizerId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showAuthorizerJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showAuthorizerJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = AUTHORIZER_JSP;
		title = "delete Authorizer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -------------------------------------- Room
	// ----------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showRoomJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showRoomJsp();
		jsp = ROOM_JSP;
		jsp += ".jsp";
		title = "Room";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addRoom(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasRoom masRoom = new MasRoom();
		int roomTypeId = 0;
		int departmentId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String pojoPropertyName="";
		String pojoPropertyCode="";
		int hospitalId = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (!request.getParameter(ROOM_TYPE_ID).equals("0")) {
			roomTypeId = Integer.parseInt(request.getParameter(ROOM_TYPE_ID));
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
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
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		generalMap.put("code", code);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List roomCodeList = new ArrayList();
		List roomNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			roomCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		boolean successfullyAdded = false;

		if ((roomCodeList.size() == 0 || roomCodeList == null)
				&& (roomNameList.size() == 0 || roomNameList == null)) {
			masRoom.setRoomCode(code);
			if (roomTypeId != 0) {
				MasRoomType masRoomType = new MasRoomType();
				masRoomType.setId(roomTypeId);
				masRoom.setRoomType(masRoomType);
			}
			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				masRoom.setDepartment(masDepartment);
			}
			masRoom.setStatus("y");
			masRoom.setLastChgBy(changedBy);
			masRoom.setLastChgDate(currentDate);
			masRoom.setLastChgTime(currentTime);
			
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			masRoom.setHospital(hospital);
			
			successfullyAdded = hospitalDetailsMasterHandlerService.addRoom(masRoom);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((roomCodeList.size() != 0 || roomCodeList != null)
				|| (roomNameList.size() != 0) || roomNameList != null) {

			if ((roomCodeList.size() != 0 || roomCodeList != null)
					&& (roomNameList.size() == 0 || roomNameList == null)) {

				message = "Room Code  already exists.";
			} else if ((roomNameList.size() != 0 || roomNameList != null)
					&& (roomCodeList.size() == 0 || roomCodeList == null)) {

				message = "Room Name  already exists.";
			} else if ((roomCodeList.size() != 0 || roomCodeList != null)
					&& (roomNameList.size() != 0 || roomNameList != null)) {

				message = "Room Code and Room Name already exist.";
			}
		}
		url = "/hms/hms/hospital?method=showRoomJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showRoomJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ROOM_JSP;
		title = "add Room";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchRoom(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String roomCode = null;
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			roomCode = request.getParameter(CODE);
		}
		map = hospitalDetailsMasterHandlerService.searchRoom(roomCode);
		jsp = ROOM_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("roomCode", roomCode);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editRoom(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String roomCode = "";
		int roomTypeId = 0;
		int departmentId = 0;
		int roomId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		roomCode = (String) session.getAttribute("roomCode");
		if (request.getParameter(ROOM_TYPE_ID) != null
				&& !(request.getParameter(ROOM_TYPE_ID).equals(""))) {
			roomTypeId = Integer.parseInt(request.getParameter(ROOM_TYPE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			roomId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			roomCode = request.getParameter(CODE);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", roomId);
		generalMap.put("roomCode", roomCode);
		generalMap.put("roomTypeId", roomTypeId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		boolean dataUpdated = false;

		dataUpdated = hospitalDetailsMasterHandlerService
				.editRoomToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}
		url = "/hms/hms/hospital?method=showRoomJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showRoomJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ROOM_JSP;
		title = "edit Room";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteRoom(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int roomId = 0;
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
			roomId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteRoom(roomId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showRoomJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showRoomJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ROOM_JSP;
		title = "delete Room";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * // -------------------------------------------- Charge Code
	 * -----------------------------
	 * 
	 * @SuppressWarnings("deprecation") public ModelAndView
	 * searchChargeCode(HttpServletRequest request, HttpServletResponse
	 * response) { Map<String, Object> map= new HashMap<String, Object>();
	 * String chargeCodeCode = null; String chargeCodeName = null; String
	 * searchField= null;
	 * 
	 * if(request.getParameter(CHARGE_CODE_CODE) != null &&
	 * !(request.getParameter(CHARGE_CODE_CODE).equals(""))){ chargeCodeCode =
	 * request.getParameter(CHARGE_CODE_CODE); }
	 * 
	 * if(request.getParameter(CHARGE_CODE_NAME) != null &&
	 * !(request.getParameter(CHARGE_CODE_NAME).equals(""))){ chargeCodeName =
	 * request.getParameter(CHARGE_CODE_NAME); }
	 * 
	 * int searchRadio=1; try{ if(request.getParameter(SEARCH_FIELD) != null &&
	 * !(request.getParameter(SEARCH_FIELD).equals(""))){ searchField =
	 * request.getParameter(SEARCH_FIELD); }
	 * 
	 * if(request.getParameter(SELECTED_RADIO) != null &&
	 * !(request.getParameter(SELECTED_RADIO).equals(""))){ searchRadio
	 * =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ; } }catch
	 * (Exception e) { e.printStackTrace(); }
	 * 
	 * if(searchRadio==1){ chargeCodeCode=searchField; chargeCodeName =null;
	 * 
	 * }else{ chargeCodeCode=null; chargeCodeName =searchField; }
	 * 
	 * map =
	 * hospitalDetailsMasterHandlerService.searchChargeCode(chargeCodeCode,
	 * chargeCodeName );
	 * 
	 * jsp=CHARGE_CODE_JSP;
	 * 
	 * jsp += ".jsp"; map.put("contentJsp",jsp); map.put("title", title);
	 * 
	 * 
	 * map.put("chargeCodeCode",chargeCodeCode);
	 * map.put("chargeCodeName ",chargeCodeName );
	 * 
	 * 
	 * 
	 * return new ModelAndView("indexB", "map", map); }
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * showChargeCodeJsp(HttpServletRequest request,HttpServletResponse
	 * response) {
	 * 
	 * session = request.getSession();
	 * 
	 * map = hospitalDetailsMasterHandlerService.showChargeCodeJsp(); jsp =
	 * CHARGE_CODE_JSP; title = "Charge Code"; jsp +=".jsp";
	 * map.put("contentJsp", jsp); map.put("title", title);
	 * 
	 * return new ModelAndView("indexB","map",map);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * @SuppressWarnings({ "unchecked", "deprecation" }) public ModelAndView
	 * addChargeCode(HttpServletRequest request, HttpServletResponse response){
	 * 
	 * 
	 * Map <String,Object>map = new HashMap<String,Object>();
	 * 
	 * @SuppressWarnings("unused") Map<String, Object> listMap = new
	 * HashMap<String, Object>(); Map<String, Object> generalMap = new
	 * HashMap<String, Object>();
	 * 
	 * MasChargeCode masChargeCode = new MasChargeCode();
	 * 
	 * MasMainChargecode masMainChargecode= new MasMainChargecode() ;
	 * MasSubChargecode masSubChargecode = new MasSubChargecode(); MasChargeType
	 * masChargeType= new MasChargeType(); MasDepartment masDepartment= new
	 * MasDepartment(); MasSample masSample= new MasSample();
	 * MasUnitOfMeasurement masUnitOfMeasurement = new MasUnitOfMeasurement();
	 * String
	 * checkBoxConfidence=null,checkBoxDischargeSummary=null,subTestRecords
	 * =null; String chargeCodeCode; String changedBy="";
	 * 
	 * try {
	 * 
	 * chargeCodeCode =
	 * 
	 * RequestUtils.getStringParameter(request,CHARGE_CODE_CODE);
	 * masChargeCode.setChargeCodeCode(chargeCodeCode);
	 * 
	 * 
	 * masChargeCode.setChargeCodeName(RequestUtils.getStringParameter(request,
	 * CHARGE_CODE_NAME));
	 * 
	 * 
	 * masMainChargecode.setId(RequestUtils.getIntParameter(request,
	 * MAIN_CHARGECODE_ID)); masChargeCode.setMainChargecode(masMainChargecode);
	 * 
	 * 
	 * 
	 * 
	 * masSubChargecode.setId(RequestUtils.getIntParameter(request,SUB_CHARGECODE_ID
	 * )); masChargeCode.setSubChargecode(masSubChargecode);
	 * 
	 * masChargeCode.setCharge(RequestUtils.getFloatParameter(request,CHARGE));
	 * 
	 * 
	 * 
	 * 
	 * masChargeType.setId(RequestUtils.getIntParameter(request,CHARGE_TYPE_ID));
	 * masChargeCode.setChargeType(masChargeType);
	 * 
	 * masDepartment.setId(RequestUtils.getIntParameter(request,DEPARTMENT_ID));
	 * masChargeCode.setDepartment(masDepartment);
	 * 
	 * subTestRecords = request.getParameter("subTest");
	 * 
	 * } catch (ServletRequestBindingException e) {
	 * 
	 * e.printStackTrace(); }
	 * masSample.setId(RequestUtils.getIntParameter(request,SAMPLE_ID,0));
	 * masChargeCode.setSample(masSample);
	 * 
	 * 
	 * masChargeCode.setNormalValue(RequestUtils.getStringParameter(request,
	 * NORMAL_VALUE,null));
	 * 
	 * 
	 * masUnitOfMeasurement.setId(RequestUtils.getIntParameter(request,
	 * UNIT_OF_MEASUREMENT_ID,0));
	 * masChargeCode.setUnitOfMeasurement(masUnitOfMeasurement);
	 * 
	 * 
	 * checkBoxConfidence=RequestUtils.getStringParameter(request,CONFIDENTIAL,null
	 * );
	 * 
	 * 
	 * checkBoxDischargeSummary=RequestUtils.getStringParameter(request,
	 * DSICHARGE_SUMMARY,null); if(checkBoxConfidence==null){
	 * masChargeCode.setConfidential("n"); }else{ try {
	 * 
	 * 
	 * masChargeCode.setConfidential(RequestUtils.getStringParameter(request,
	 * CONFIDENTIAL)); } catch (ServletRequestBindingException e) {
	 * e.printStackTrace(); } }
	 * 
	 * if(request.getParameter("pojoName") != null){ pojoName =
	 * request.getParameter("pojoName"); }
	 * if(request.getParameter(POJO_PROPERTY_CODE) != null){ pojoPropertyCode =
	 * request.getParameter(POJO_PROPERTY_CODE); }
	 * if(request.getParameter(POJO_PROPERTY_NAME) != null){ pojoPropertyName =
	 * request.getParameter(POJO_PROPERTY_NAME); }
	 * if(request.getParameter("jspName") != null){ jspName =
	 * request.getParameter("jspName"); } if(request.getParameter("title") !=
	 * null){ title = request.getParameter("title"); }
	 * 
	 * if(checkBoxDischargeSummary==null){
	 * masChargeCode.setAppearInDischargeSummary("n"); }else{ try {
	 * 
	 * 
	 * 
	 * masChargeCode.setAppearInDischargeSummary(RequestUtils.getStringParameter(
	 * request,DSICHARGE_SUMMARY
	 * 
	 * )); } catch (ServletRequestBindingException e) { e.printStackTrace(); } }
	 * 
	 * generalMap.put("pojoPropertyName", pojoPropertyName);
	 * generalMap.put("pojoPropertyCode", pojoPropertyCode);
	 * generalMap.put("pojoName", pojoName);
	 * 
	 * listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
	 * 
	 * String changedTime=""; Date changedDate= new Date();
	 * if(request.getParameter(CHANGED_DATE) != null){ changedDate =
	 * 
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null){ changedTime =
	 * request.getParameter(CHANGED_TIME); } if(request.getParameter(CHANGED_BY)
	 * != null &&
	 * 
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); }
	 * 
	 * masChargeCode.setLastChgDate(changedDate);
	 * masChargeCode.setLastChgTime(changedTime);
	 * masChargeCode.setLastChgBy(changedBy); masChargeCode.setStatus("y");
	 * boolean successfullyAdded = false; List<MasSubTest> masSubtest = new
	 * ArrayList<MasSubTest>(); if(subTestRecords!=null){ masSubtest =
	 * addSubTest(subTestRecords); }
	 * 
	 * 
	 * 
	 * if((checkChargeCodeExsist(masChargeCode.getChargeCodeCode(),masChargeCode.
	 * getChargeCodeName()))==true) {
	 * 
	 * successfullyAdded =
	 * 
	 * 
	 * hospitalDetailsMasterHandlerService.addChargeCode(masChargeCode,masSubtest
	 * ); } if(successfullyAdded == true) { message =
	 * "Charge Code Information Saved Successfully "; }else{ message =
	 * "Try Again."; } map.put("message",message); url =
	 * "/hms/hms/hospital?method=showChargeCodeJsp"; try{ map =
	 * hospitalDetailsMasterHandlerService.showChargeCodeJsp();
	 * 
	 * }catch (Exception e) {
	 * //System.out.println("Exception in showChargeCodeJsp "+e); }
	 * jsp=CHARGE_CODE_JSP; title="delete ChargeCode"; jsp += ".jsp";
	 * 
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("message",
	 * message); return new ModelAndView("indexB", "map", map);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public boolean checkChargeCodeExsist(String chargeCodeCode, String
	 * chargeCodeName) { boolean
	 * 
	 * 
	 * chargeCodeExsist=hospitalDetailsMasterHandlerService.checkChargeCodeExsist
	 * (chargeCodeCode,chargeCodeName)
	 * 
	 * ; return chargeCodeExsist; }
	 * 
	 * public List<MasSubTest> addSubTest(String subTestEditList) {
	 * StringTokenizer stringTokenizerOfSubTest=new
	 * StringTokenizer(subTestEditList,","); int i=0;
	 * 
	 * List<MasSubTest> subTestList=new ArrayList<MasSubTest>(); MasSubTest
	 * masSubtest =null; while(stringTokenizerOfSubTest.hasMoreTokens()){
	 * masSubtest = new MasSubTest();
	 * 
	 * String tempString =stringTokenizerOfSubTest.nextToken();
	 * 
	 * if(tempString.equals("0")) {
	 * masSubtest.setSubTestCode(stringTokenizerOfSubTest.nextToken());
	 * masSubtest.setSubTestName(stringTokenizerOfSubTest.nextToken());
	 * stringTokenizerOfSubTest.nextToken(); String
	 * normalValue=stringTokenizerOfSubTest.nextToken();
	 * 
	 * if(!normalValue.equals("~^")) { masSubtest.setNormalValue(normalValue); }
	 * else { masSubtest.setNormalValue("");
	 * 
	 * } String unitofResult=stringTokenizerOfSubTest.nextToken();
	 * 
	 * 
	 * if(!unitofResult.equals("~^")) {
	 * masSubtest.setUnitOfResult(unitofResult); } else {
	 * masSubtest.setUnitOfResult("");
	 * 
	 * } stringTokenizerOfSubTest.nextToken(); masSubtest.setStatus("y"); }
	 * else{ masSubtest.setId(new Integer(tempString));
	 * masSubtest.setSubTestCode(stringTokenizerOfSubTest.nextToken());
	 * masSubtest.setSubTestName(stringTokenizerOfSubTest.nextToken());
	 * stringTokenizerOfSubTest.nextToken(); String
	 * normalValue=stringTokenizerOfSubTest.nextToken();
	 * 
	 * if(!normalValue.equals("~^")) { masSubtest.setNormalValue(normalValue); }
	 * else { masSubtest.setNormalValue("");
	 * 
	 * } String unitofResult=stringTokenizerOfSubTest.nextToken();
	 * 
	 * 
	 * if(!unitofResult.equals("~^")) {
	 * masSubtest.setUnitOfResult(unitofResult); } else {
	 * masSubtest.setUnitOfResult("");
	 * 
	 * } stringTokenizerOfSubTest.nextToken(); masSubtest.setStatus("y"); }
	 * subTestList.add(masSubtest); i++; }
	 * 
	 * return subTestList; }
	 * 
	 * @SuppressWarnings("deprecation") public ModelAndView
	 * editChargeCode(HttpServletRequest request, HttpServletResponse
	 * 
	 * response) {
	 * 
	 * Map<String, Object>map = new HashMap<String, Object>(); MasChargeCode
	 * chargeCode=new MasChargeCode(); String changedBy=""; String
	 * checkBoxConfidence=null,checkBoxDischargeSummary=null;String
	 * 
	 * multipleResults = null; String chargeCodeName = null; String
	 * chargeCodeCode=null; Integer chargeCodeId=null; Integer mainChargeId =
	 * null,subChargeId = null,departmentId = null, chargeTypeId
	 * 
	 * = null, sampleId = null,unitOfResult = null; String
	 * status=null,normalValue = null; try { chargeCodeId =
	 * 
	 * RequestUtils.getIntParameter(request,CHARGE_CODE_ID); status =
	 * 
	 * (String)RequestUtils.getStringParameter(request,STATUS, "String");
	 * multipleResults =
	 * 
	 * RequestUtils.getStringParameter(request,"multipleresults", "String"); }
	 * catch (ServletRequestBindingException e1) {
	 * 
	 * e1.printStackTrace(); } boolean subTesttobeDeleted = false; String
	 * subTestEditList = ""; List<MasSubTest> masSubTest = new
	 * ArrayList<MasSubTest>(); subTesttobeDeleted = true;
	 * subTestEditList=request.getParameter("subTest");
	 * 
	 * boolean successfullyAdded=false; String message=null;
	 * if(status.equals("Active")){ try { chargeCode.setId(chargeCodeId);
	 * chargeCodeCode =
	 * 
	 * RequestUtils.getStringParameter(request,CHARGE_CODE_CODE);
	 * chargeCode.setChargeCodeCode(chargeCodeCode); chargeCodeName =
	 * RequestUtils.getStringParameter(request,CHARGE_CODE_NAME);
	 * chargeCode.setChargeCodeName(chargeCodeName); float
	 * amount=RequestUtils.getFloatParameter(request,CHARGE);
	 * chargeCode.setCharge(amount);
	 * 
	 * MasMainChargecode masMainChargecode = new
	 * 
	 * MasMainChargecode(); mainChargeId =
	 * 
	 * RequestUtils.getIntParameter(request,MAIN_CHARGECODE_ID);
	 * masMainChargecode.setId(mainChargeId);
	 * chargeCode.setMainChargecode(masMainChargecode);
	 * 
	 * MasSubChargecode masSubChargecode= new
	 * 
	 * MasSubChargecode(); subChargeId =
	 * 
	 * RequestUtils.getIntParameter(request,SUB_CHARGECODE_ID);
	 * masSubChargecode.setId(subChargeId);
	 * chargeCode.setSubChargecode(masSubChargecode);
	 * 
	 * MasChargeType masChargeType = new MasChargeType(); chargeTypeId =
	 * 
	 * RequestUtils.getIntParameter(request,CHARGE_TYPE_ID);
	 * masChargeType.setId(chargeTypeId);
	 * chargeCode.setChargeType(masChargeType);
	 * 
	 * MasDepartment masDepartment= new MasDepartment(); departmentId =
	 * 
	 * RequestUtils.getIntParameter(request,DEPARTMENT_ID);
	 * masDepartment.setId(departmentId);
	 * chargeCode.setDepartment(masDepartment);
	 * 
	 * MasSample masSample= new MasSample(); sampleId =
	 * 
	 * RequestUtils.getIntParameter(request,SAMPLE_ID);
	 * masSample.setId(sampleId); chargeCode.setSample(masSample);
	 * 
	 * normalValue =
	 * 
	 * RequestUtils.getStringParameter(request,NORMAL_VALUE,null);
	 * chargeCode.setNormalValue(normalValue);
	 * 
	 * MasUnitOfMeasurement masUnitOfMeasurement= new
	 * 
	 * MasUnitOfMeasurement(); unitOfResult =
	 * 
	 * RequestUtils.getIntParameter(request,UNIT_OF_MEASUREMENT_ID);
	 * masUnitOfMeasurement.setId(unitOfResult);
	 * 
	 * 
	 * chargeCode.setUnitOfMeasurement(masUnitOfMeasurement);
	 * 
	 * } catch (ServletRequestBindingException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * checkBoxConfidence=RequestUtils.getStringParameter(request,CONFIDENTIAL,null
	 * );
	 * 
	 * 
	 * checkBoxDischargeSummary=RequestUtils.getStringParameter(request,
	 * DSICHARGE_SUMMARY,null); if(checkBoxConfidence==null){
	 * chargeCode.setConfidential("n"); }else{ try {
	 * 
	 * 
	 * chargeCode.setConfidential(RequestUtils.getStringParameter(request,
	 * CONFIDENTIAL)); } catch (ServletRequestBindingException e) {
	 * e.printStackTrace(); } }
	 * 
	 * if(checkBoxDischargeSummary==null){
	 * chargeCode.setAppearInDischargeSummary("n"); }else{
	 * 
	 * try {
	 * 
	 * 
	 * chargeCode.setAppearInDischargeSummary(RequestUtils.getStringParameter(
	 * request,DSICHARGE_SUMMARY)); } catch (ServletRequestBindingException e) {
	 * e.printStackTrace(); } }
	 * 
	 * 
	 * String changedTime=""; Date changedDate= new Date();
	 * if(request.getParameter(CHANGED_DATE) != null){ changedDate =
	 * 
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null){ changedTime =
	 * request.getParameter(CHANGED_TIME); } if(request.getParameter(CHANGED_BY)
	 * != null &&
	 * 
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); }
	 * 
	 * chargeCode.setLastChgDate(changedDate);
	 * chargeCode.setLastChgTime(changedTime);
	 * chargeCode.setLastChgBy(changedBy); chargeCode.setStatus("y");
	 * 
	 * 
	 * if(multipleResults.equals("String")) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if((checkChargeCodeNameExsistForEditing(chargeCodeId,chargeCodeName))==true
	 * ) { if(subTestEditList!= null) { masSubTest =
	 * 
	 * editSubTest(subTestEditList,chargeCodeId); } successfullyAdded =
	 * 
	 * hospitalDetailsMasterHandlerService.editChargeCode(chargeCode,masSubTest,
	 * subTesttobeDeleted);
	 * 
	 * 
	 * } } else {
	 * 
	 * if(subTestEditList!= null) { masSubTest =
	 * 
	 * editSubTest(subTestEditList,chargeCodeId); }
	 * 
	 * successfullyAdded =
	 * 
	 * hospitalDetailsMasterHandlerService.editChargeCode(chargeCode,
	 * masSubTest, subTesttobeDeleted); }
	 * 
	 * if(successfullyAdded) {
	 * 
	 * message="The Record is updated successfully."; } else {
	 * 
	 * message="The Name already exsist!!!."; }
	 * 
	 * }
	 * 
	 * else {
	 * 
	 * message = "Record is InActive, Can't be Updated."; }
	 * 
	 * 
	 * map.put("message",message); url =
	 * "/hms/hms/hospital?method=showChargeCodeJsp"; try{ map =
	 * hospitalDetailsMasterHandlerService.showChargeCodeJsp();
	 * 
	 * }catch (Exception e) {
	 * //System.out.println("Exception in showChargeCodeJsp "+e); }
	 * jsp=CHARGE_CODE_JSP; title="edit ChargeCode"; jsp += ".jsp";
	 * 
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("message",
	 * message); return new ModelAndView("indexB", "map", map);
	 * 
	 * }
	 * 
	 * public List<MasSubTest> editSubTest(String subTestEditList, Integer
	 * chargeCodeId) { { StringTokenizer stringTokenizerOfSubTest=new
	 * 
	 * StringTokenizer(subTestEditList,","); int i=0; List<MasSubTest>
	 * subTestList=new ArrayList<MasSubTest>(); MasSubTest masSubTest =null;
	 * while(stringTokenizerOfSubTest.hasMoreTokens()){ masSubTest = new
	 * MasSubTest();
	 * 
	 * String tempString =stringTokenizerOfSubTest.nextToken();
	 * 
	 * if(tempString.equals("0")) {
	 * 
	 * 
	 * masSubTest.setSubTestCode(stringTokenizerOfSubTest.nextToken());
	 * 
	 * 
	 * masSubTest.setSubTestName(stringTokenizerOfSubTest.nextToken());
	 * stringTokenizerOfSubTest.nextToken(); String
	 * 
	 * normalValue=stringTokenizerOfSubTest.nextToken();
	 * 
	 * if(!normalValue.equals("~^")) {
	 * 
	 * 
	 * masSubTest.setNormalValue(normalValue); } else {
	 * masSubTest.setNormalValue("");
	 * 
	 * } String
	 * 
	 * unitofResult=stringTokenizerOfSubTest.nextToken();
	 * 
	 * 
	 * if(!unitofResult.equals("~^")) {
	 * 
	 * 
	 * masSubTest.setUnitOfResult(unitofResult); } else {
	 * masSubTest.setUnitOfResult("");
	 * 
	 * } stringTokenizerOfSubTest.nextToken(); MasChargeCode masChargeCode = new
	 * 
	 * MasChargeCode(); masChargeCode.setId(chargeCodeId);
	 * masSubTest.setChargeCode(masChargeCode); masSubTest.setStatus("y");
	 * 
	 * 
	 * } else{
	 * 
	 * masSubTest.setId(new Integer(tempString));
	 * 
	 * 
	 * masSubTest.setSubTestCode(stringTokenizerOfSubTest.nextToken());
	 * 
	 * 
	 * masSubTest.setSubTestName(stringTokenizerOfSubTest.nextToken());
	 * stringTokenizerOfSubTest.nextToken(); String
	 * 
	 * normalValue=stringTokenizerOfSubTest.nextToken();
	 * 
	 * if(!normalValue.equals("~^")) {
	 * 
	 * 
	 * masSubTest.setNormalValue(normalValue); } else {
	 * masSubTest.setNormalValue("");
	 * 
	 * } String
	 * 
	 * unitofResult=stringTokenizerOfSubTest.nextToken();
	 * 
	 * 
	 * if(!unitofResult.equals("~^")) {
	 * 
	 * 
	 * masSubTest.setUnitOfResult(unitofResult); } else {
	 * masSubTest.setUnitOfResult("");
	 * 
	 * } stringTokenizerOfSubTest.nextToken();
	 * 
	 * 
	 * masSubTest.getChargeCode().setId(chargeCodeId);
	 * masSubTest.setStatus("y"); } subTestList.add(masSubTest); i++;
	 * 
	 * 
	 * } return subTestList;
	 * 
	 * } }
	 * 
	 * public boolean checkChargeCodeNameExsistForEditing(int chargeCodeId,
	 * String
	 * 
	 * chargeCodeName) { boolean
	 * 
	 * chargeCodeameExsistForEdition=hospitalDetailsMasterHandlerService.
	 * checkChargeCodeNameExsistForEditing(chargeCodeId, chargeCodeName); return
	 * chargeCodeameExsistForEdition;
	 * 
	 * }
	 * 
	 * public ModelAndView deleteSubTest(HttpServletRequest
	 * request,HttpServletResponse
	 * 
	 * response){
	 * 
	 * Integer subTestId=(Integer.valueOf(request.getParameter("subTestId")));
	 * hospitalDetailsMasterHandlerService.deleteSubTest(subTestId); return
	 * showChargeCodeJsp(request,response); }
	 * 
	 * 
	 * 
	 * @SuppressWarnings("deprecation") public ModelAndView
	 * deleteChargeCode(HttpServletRequest request, HttpServletResponse
	 * 
	 * response) { Map<String, Object>map = new HashMap<String, Object>();
	 * String status = null; String message; Integer chargeCodeId = null; try {
	 * chargeCodeId =
	 * 
	 * RequestUtils.getIntParameter(request,CHARGE_CODE_ID); status =
	 * (String)RequestUtils.getStringParameter(request,STATUS,
	 * 
	 * "String"); RequestUtils.getStringParameter(request,CHARGE_CODE_CODE);
	 * 
	 * } catch (ServletRequestBindingException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * boolean successfullyDeleted =
	 * 
	 * 
	 * hospitalDetailsMasterHandlerService.deleteChargeCode(chargeCodeId,status);
	 * 
	 * if(successfullyDeleted) { if(status.equals("Active")){
	 * message=" Record is InActivated successfully"; } else{
	 * message=" Record is Activated successfully"; } } else {
	 * 
	 * message="Some Problem Occured while Processing Kindly try Again."; }
	 * 
	 * map.put("message",message); url =
	 * "/hms/hms/hospital?method=showChargeCodeJsp"; try{ map =
	 * hospitalDetailsMasterHandlerService.showChargeCodeJsp();
	 * 
	 * }catch (Exception e) {
	 * //System.out.println("Exception in showChargeCodeJsp "+e); }
	 * jsp=CHARGE_CODE_JSP; title="delete ChargeCode"; jsp += ".jsp";
	 * 
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("message",
	 * message); return new ModelAndView("indexB", "map", map); }
	 */

	// -------------------------------------------- Charge Code
	// -----------------------------

	@SuppressWarnings("deprecation")
	public ModelAndView searchChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String chargeCodeCode = null;
		String chargeCodeName = null;

		String searchField = null;

		if (request.getParameter(CHARGE_CODE_CODE) != null
				&& !(request.getParameter(CHARGE_CODE_CODE).equals(""))) {
			chargeCodeCode = request.getParameter(CHARGE_CODE_CODE);
		}

		if (request.getParameter(CHARGE_CODE_NAME) != null
				&& !(request.getParameter(CHARGE_CODE_NAME).equals(""))) {
			chargeCodeName = request.getParameter(CHARGE_CODE_NAME);
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
			chargeCodeCode = searchField;
			chargeCodeName = null;

		} else {
			chargeCodeCode = null;
			chargeCodeName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchChargeCode(
				chargeCodeCode, chargeCodeName);

		jsp = CHARGE_CODE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("chargeCodeCode", chargeCodeCode);
		map.put("chargeCodeName", chargeCodeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showChargeCodeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showChargeCodeJsp();
		@SuppressWarnings("unused")
		ArrayList searchChargeCodeList = (ArrayList) map
				.get("searchChargeCodeList");
		jsp = CHARGE_CODE_JSP;
		jsp += ".jsp";
		title = "ChargeCode";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings( { "unchecked", "deprecation" })
	public ModelAndView addChargeCode(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		MasChargeCode masChargeCode = new MasChargeCode();
		MasMainChargecode masMainChargecode = new MasMainChargecode();
		MasSubChargecode masSubChargecode = new MasSubChargecode();
		MasChargeType masChargeType = new MasChargeType();
		MasDepartment masDepartment = new MasDepartment();
		MasSample masSample = new MasSample();
		MasUnitOfMeasurement masUnitOfMeasurement = new MasUnitOfMeasurement();
		String checkBoxConfidence = null, checkBoxDischargeSummary = null, subTestRecords = null;
		String changedBy = "";
		Date currentDate = new Date();
		int mainChargecodeId = 0;
		int subChargecodeId = 0;
		int chargeTypeId = 0;
		int departmentId = 0;
		int sampleId = 0;
		int chargeCodeId = 0;
		int unitOfMeasurementId = 0;
		float amount = 0;
		if (request.getParameter(CHARGE_CODE_CODE) != null) {
			code = request.getParameter(CHARGE_CODE_CODE);

		}
		if (request.getParameter(CHARGE_CODE_NAME) != null) {
			name = request.getParameter(CHARGE_CODE_NAME);

		}
		if (request.getParameter(CHARGE) != null
				&& !request.getParameter(CHARGE).equals("0")
				&& !request.getParameter(CHARGE).equals("")) {
			amount = Float.parseFloat(request.getParameter(CHARGE));

		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.valueOf(request
					.getParameter(MAIN_CHARGECODE_ID));

		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargecodeId = Integer.valueOf(request
					.getParameter(SUB_CHARGECODE_ID));

		}
		if (request.getParameter(CHARGE_TYPE_ID) != null) {
			chargeTypeId = Integer
					.valueOf(request.getParameter(CHARGE_TYPE_ID));

		}

		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer.valueOf(request.getParameter(DEPARTMENT_ID));

		}
		// if (request.getParameter(SAMPLE_ID) != null) {
		// sampleId = Integer.valueOf(request.getParameter(SAMPLE_ID));

		// }
		// if (request.getParameter(UNIT_OF_MEASUREMENT_ID) != null) {
		// unitOfMeasurementId =
		// Integer.valueOf(request.getParameter(UNIT_OF_MEASUREMENT_ID));

		// }

		subTestRecords = request.getParameter("subTest");

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

		masChargeCode.setNormalValue(RequestUtils.getStringParameter(request,
				NORMAL_VALUE, null));

		// masUnitOfMeasurement.setId(RequestUtils.getIntParameter(request,UNIT_OF_MEASUREMENT_ID,0));
		// masChargeCode.setUnitOfMeasurement(masUnitOfMeasurement);

		checkBoxConfidence = RequestUtils.getStringParameter(request,
				CONFIDENTIAL, null);

		checkBoxDischargeSummary = RequestUtils.getStringParameter(request,
				DSICHARGE_SUMMARY, null);
		if (checkBoxConfidence == null) {
			masChargeCode.setConfidential("n");
		} else {
			try {

				masChargeCode.setConfidential(RequestUtils.getStringParameter(
						request, CONFIDENTIAL));
			} catch (ServletRequestBindingException e) {
				e.printStackTrace();
			}
		}
		if (checkBoxDischargeSummary == null) {
			masChargeCode.setAppearInDischargeSummary("n");
		} else {
			try {

				masChargeCode.setAppearInDischargeSummary(RequestUtils
						.getStringParameter(request, DSICHARGE_SUMMARY

						));
			} catch (ServletRequestBindingException e) {
				e.printStackTrace();
			}
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

		List chargeCodeCodeList = new ArrayList();
		List chargeCodeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			chargeCodeCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			chargeCodeNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;
		if ((chargeCodeNameList.size() == 0 || chargeCodeNameList == null)
				&& (chargeCodeCodeList.size() == 0 || chargeCodeCodeList == null)) {
			masChargeCode.setChargeCodeCode(code);
			masChargeCode.setChargeCodeName(name);

			masChargeCode.setCharge(amount);

			masMainChargecode.setId(mainChargecodeId);
			masChargeCode.setMainChargecode(masMainChargecode);

			masSubChargecode.setId(subChargecodeId);
			masChargeCode.setSubChargecode(masSubChargecode);

			masChargeType.setId(chargeTypeId);
			masChargeCode.setChargeType(masChargeType);

			masDepartment.setId(departmentId);
			masChargeCode.setDepartment(masDepartment);

			// masSample.setId(sampleId);
			// masChargeCode.setSample(masSample);

			// masUnitOfMeasurement.setId(unitOfMeasurementId);
			// masChargeCode.setUnitOfMeasurement(masUnitOfMeasurement);

			masChargeCode.setStatus("y");
			masChargeCode.setLastChgBy(changedBy);
			masChargeCode.setLastChgDate(currentDate);
			masChargeCode.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addChargeCode(masChargeCode);

			if (successfullyAdded = true) {
				message = "Record Added Successfully";
			} else {
				message = "Try Again !";

			}

		}

		else if ((chargeCodeCodeList.size() != 0 || chargeCodeCodeList != null)
				|| (chargeCodeNameList.size() != 0)
				|| chargeCodeNameList != null) {

			if ((chargeCodeCodeList.size() != 0 || chargeCodeCodeList != null)
					&& (chargeCodeNameList.size() == 0 || chargeCodeNameList == null)) {

				message = "Charge Code  already exists.";
			} else if ((chargeCodeNameList.size() != 0 || chargeCodeNameList != null)
					&& (chargeCodeCodeList.size() == 0 || chargeCodeCodeList == null)) {

				message = "Charge Name already exists.";
			} else if ((chargeCodeCodeList.size() != 0 || chargeCodeCodeList != null)
					&& (chargeCodeNameList.size() != 0 || chargeCodeNameList != null)) {

				message = "Charge Code and Charge Name already exist.";
			}

		}
		try {
			if (masChargeCode.getId() != null && masChargeCode.getId() != 0) {
				chargeCodeId = masChargeCode.getId();
			}
			//System.out.println("chargeCodeId   " + chargeCodeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			map = hospitalDetailsMasterHandlerService.showChargeCodeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CHARGE_CODE_JSP;
		title = "Add ChargeCode";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("chargeTypeId", chargeTypeId);
		map.put("mainChargecodeId", mainChargecodeId);
		map.put("subChargecodeId", subChargecodeId);
		map.put("chargeCodeId", chargeCodeId);
		map.put("name", name);
		return new ModelAndView("indexB", "map", map);
	}

	public boolean checkChargeCodeExsist(String chargeCodeCode,
			String chargeCodeName) {
		boolean chargeCodeExsist = hospitalDetailsMasterHandlerService
				.checkChargeCodeExsist(chargeCodeCode, chargeCodeName);
		return chargeCodeExsist;
	}

	public List<MasSubTest> addSubTest(String subTestEditList) {
		StringTokenizer stringTokenizerOfSubTest = new StringTokenizer(
				subTestEditList, ",");
		int i = 0;

		List<MasSubTest> subTestList = new ArrayList<MasSubTest>();
		MasSubTest masSubtest = null;
		while (stringTokenizerOfSubTest.hasMoreTokens()) {
			masSubtest = new MasSubTest();

			String tempString = stringTokenizerOfSubTest.nextToken();

			if (tempString.equals("0")) {
				masSubtest.setSubTestCode(stringTokenizerOfSubTest.nextToken());
				masSubtest.setSubTestName(stringTokenizerOfSubTest.nextToken());
				stringTokenizerOfSubTest.nextToken();
				String normalValue = stringTokenizerOfSubTest.nextToken();

				if (!normalValue.equals("~^")) {
					masSubtest.setNormalValue(normalValue);
				} else {
					masSubtest.setNormalValue("");

				}
				String unitofResult = stringTokenizerOfSubTest.nextToken();

				if (!unitofResult.equals("~^")) {
					masSubtest.setUnitOfResult(unitofResult);
				} else {
					masSubtest.setUnitOfResult("");

				}
				stringTokenizerOfSubTest.nextToken();
				masSubtest.setStatus("y");
			} else {
				masSubtest.setId(new Integer(tempString));
				masSubtest.setSubTestCode(stringTokenizerOfSubTest.nextToken());
				masSubtest.setSubTestName(stringTokenizerOfSubTest.nextToken());
				stringTokenizerOfSubTest.nextToken();
				String normalValue = stringTokenizerOfSubTest.nextToken();

				if (!normalValue.equals("~^")) {
					masSubtest.setNormalValue(normalValue);
				} else {
					masSubtest.setNormalValue("");

				}
				String unitofResult = stringTokenizerOfSubTest.nextToken();

				if (!unitofResult.equals("~^")) {
					masSubtest.setUnitOfResult(unitofResult);
				} else {
					masSubtest.setUnitOfResult("");

				}
				stringTokenizerOfSubTest.nextToken();
				masSubtest.setStatus("y");
			}
			subTestList.add(masSubtest);
			i++;
		}

		return subTestList;
	}

	public ModelAndView editChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String chargecodeCode = "";
		String chargecodeName = "";
		int mainChargecodeId = 0;
		int subChargecodeId = 0;
		int departmentId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		int subchargeCodeId = 0;
		int chargeId = 0;
		int chargeTypeId = 0;
		float charge = 0;
		if (request.getParameter(CHARGE) != null
				&& !request.getParameter(CHARGE).equals("0")
				&& !request.getParameter(CHARGE).equals("")) {
			charge = Float.parseFloat(request.getParameter(CHARGE));

		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subchargeCodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null
				&& !(request.getParameter(CHARGE_CODE_ID).equals(""))) {
			chargeId = Integer.parseInt(request.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter(CHARGE_CODE_CODE) != null
				&& !(request.getParameter(CHARGE_CODE_CODE).equals(""))) {
			chargecodeCode = request.getParameter(CHARGE_CODE_CODE);
		}
		if (request.getParameter(CHARGE_CODE_NAME) != null
				&& !(request.getParameter(CHARGE_CODE_NAME).equals(""))) {
			chargecodeName = request.getParameter(CHARGE_CODE_NAME);
		}

		if (request.getParameter(CHARGE_TYPE_ID) != null
				&& !(request.getParameter(CHARGE_TYPE_ID).equals(""))) {
			chargeTypeId = Integer.parseInt(request
					.getParameter(CHARGE_TYPE_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", chargeId);
		generalMap.put("charge", charge);
		generalMap.put("chargeTypeId", chargeTypeId);
		generalMap.put("chargecodeCode", chargecodeCode);
		generalMap.put("chargecodeName", chargecodeName);
		generalMap.put("mainChargecodeId", mainChargecodeId);
		generalMap.put("subchargeCodeId", subchargeCodeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("departmentId", departmentId);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingSubChargeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingSubChargeNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editChargeCode(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingSubChargeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showChargeCodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showChargeCodeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CHARGE_CODE_JSP;
		title = "edit Charge";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public List<MasSubTest> editSubTest(String subTestEditList,
			Integer chargeCodeId) {
		{
			StringTokenizer stringTokenizerOfSubTest = new

			StringTokenizer(subTestEditList, ",");
			int i = 0;
			List<MasSubTest> subTestList = new ArrayList<MasSubTest>();
			MasSubTest masSubTest = null;
			while (stringTokenizerOfSubTest.hasMoreTokens()) {
				masSubTest = new MasSubTest();

				String tempString = stringTokenizerOfSubTest.nextToken();

				if (tempString.equals("0")) {
					masSubTest.setSubTestCode(stringTokenizerOfSubTest
							.nextToken());

					masSubTest.setSubTestName(stringTokenizerOfSubTest
							.nextToken());
					stringTokenizerOfSubTest.nextToken();
					String normalValue = stringTokenizerOfSubTest.nextToken();

					if (!normalValue.equals("~^")) {

						masSubTest.setNormalValue(normalValue);
					} else {
						masSubTest.setNormalValue("");

					}
					String

					unitofResult = stringTokenizerOfSubTest.nextToken();

					if (!unitofResult.equals("~^")) {

						masSubTest.setUnitOfResult(unitofResult);
					} else {
						masSubTest.setUnitOfResult("");

					}
					stringTokenizerOfSubTest.nextToken();
					MasChargeCode masChargeCode = new

					MasChargeCode();
					masChargeCode.setId(chargeCodeId);
					masSubTest.setChargeCode(masChargeCode);
					masSubTest.setStatus("y");

				} else {

					masSubTest.setId(new Integer(tempString));

					masSubTest.setSubTestCode(stringTokenizerOfSubTest
							.nextToken());
					masSubTest.setSubTestName(stringTokenizerOfSubTest
							.nextToken());
					stringTokenizerOfSubTest.nextToken();
					String

					normalValue = stringTokenizerOfSubTest.nextToken();

					if (!normalValue.equals("~^")) {

						masSubTest.setNormalValue(normalValue);
					} else {
						masSubTest.setNormalValue("");

					}
					String

					unitofResult = stringTokenizerOfSubTest.nextToken();

					if (!unitofResult.equals("~^")) {

						masSubTest.setUnitOfResult(unitofResult);
					} else {
						masSubTest.setUnitOfResult("");

					}
					stringTokenizerOfSubTest.nextToken();

					masSubTest.getChargeCode().setId(chargeCodeId);
					masSubTest.setStatus("y");
				}
				subTestList.add(masSubTest);
				i++;

			}
			return subTestList;

		}
	}

	public boolean checkChargeCodeNameExsistForEditing(int chargeCodeId,
			String chargeCodeName) {
		boolean

		chargeCodeameExsistForEdition = hospitalDetailsMasterHandlerService
				.checkChargeCodeNameExsistForEditing(chargeCodeId,
						chargeCodeName);
		return chargeCodeameExsistForEdition;

	}

	public ModelAndView deleteSubTest(HttpServletRequest request,
			HttpServletResponse response) {

		Integer subTestId = (Integer.valueOf(request.getParameter("subTestId")));
		hospitalDetailsMasterHandlerService.deleteSubTest(subTestId);
		return showChargeCodeJsp(request, response);
	}

	@SuppressWarnings("deprecation")
	public ModelAndView deleteChargeCode(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int chargeCodeId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}

		if (request.getParameter(CHARGE_CODE_ID) != null
				&& !(request.getParameter(CHARGE_CODE_ID).equals(""))) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteChargeCode1(
				chargeCodeId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showChargeCodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showChargeCodeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CHARGE_CODE_JSP;
		title = "Delete Charge Code";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

		/*
		 * Map<String, Object> map = new HashMap<String, Object>(); int
		 * chargeCodeId=0; String message=null;
		 * 
		 * 
		 * if(request.getParameter(CHARGE_CODE_ID) != null &&
		 * !(request.getParameter(CHARGE_CODE_ID).equals(""))){ chargeCodeId
		 * =Integer.parseInt( request.getParameter(CHARGE_CODE_ID)); }
		 * if(request.getParameter("title") != null){ title =
		 * request.getParameter("title"); } boolean dataDeleted=false;
		 * dataDeleted
		 * =hospitalDetailsMasterHandlerService.deleteChargeCode(chargeCodeId);
		 * if (dataDeleted==true) {
		 * 
		 * message="Record is InActivated successfully"; }
		 * 
		 * else{ message="Record is Activated successfully"; } url =
		 * "/hms/hms/generalMaster?method=showChargeCodeJsp"; try{ map =
		 * hospitalDetailsMasterHandlerService.showChargeCodeJsp(); }catch
		 * (Exception e) { e.printStackTrace(); } jsp=CHARGE_CODE_JSP;
		 * title="delete ChargeCode"; jsp += ".jsp";
		 * 
		 * map.put("contentJsp", jsp); map.put("title", title); map.put("url",
		 * url); map.put("message", message); return new ModelAndView("indexB",
		 * "map", map);
		 */
	}

	// --------------------------------------sub charge Code
	// --------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showSubChargeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = hospitalDetailsMasterHandlerService.showSubChargeJsp();
		@SuppressWarnings("unused")
		ArrayList searchSubChargeList = (ArrayList) map
				.get("searchSubChargeList");
		jsp = SUB_CHARGE;
		jsp += ".jsp";
		title = "SubCharge";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView addDiagParam(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		DiagParam diagParam = new DiagParam();
		int mainChargecodeId = 0;
		String changedBy = "";
		Map listMap = new HashMap();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int deptId = 0;
		int sequenceNo = 0;
		String prefix = "";
		String criteria = "";
		int subChargecodeId = 0;

		if (request.getParameter(SEQUENCE_NO) != null) {
			sequenceNo = Integer.parseInt(request.getParameter(SEQUENCE_NO));
		}
		if (request.getParameter(PREFIX) != null) {
			prefix = request.getParameter(PREFIX);
		}
		if (request.getParameter(CRITERIA) != null) {
			criteria = request.getParameter(CRITERIA);
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.valueOf(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargecodeId = Integer.valueOf(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			deptId = Integer.valueOf(request.getParameter(DEPARTMENT_ID));
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
		generalMap.put("sequenceNo", sequenceNo);
		generalMap.put("prefix", prefix);
		generalMap.put("criteria", criteria);
		generalMap.put("mainChargecodeId", mainChargecodeId);
		generalMap.put("subChargecodeId", subChargecodeId);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		List subChargecodeList = new ArrayList();
		Box box = HMSUtil.getBox(request);
		map = hospitalDetailsMasterHandlerService.getSubchargeList(box);
		if (map.get("subChargecodeList") != null) {
			subChargecodeList = (List) map.get("subChargecodeList");
		}

		boolean successfullyAdded = false;
		if (subChargecodeList.size() == 0 || subChargecodeList == null) {
			diagParam.setSeqNo(sequenceNo);
			diagParam.setCriteria(criteria);
			diagParam.setPrefix(prefix);

			MasMainChargecode masMainChargecode = new MasMainChargecode();
			masMainChargecode.setId(mainChargecodeId);
			diagParam.setMainCharge(masMainChargecode);

			MasSubChargecode masSubChargecode = new MasSubChargecode();
			masSubChargecode.setId(subChargecodeId);
			diagParam.setSubCharge(masSubChargecode);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(1);
			diagParam.setHospital(masHospital);

			diagParam.setStatus("y");
			diagParam.setLastChgBy(changedBy);
			diagParam.setLastChgDate(currentDate);
			diagParam.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addDiagParam(diagParam);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if (subChargecodeList.size() != 0 || subChargecodeList != null) {

			message = "Sub Charge already exists.";

		}

		try {
			map = hospitalDetailsMasterHandlerService.showParamJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIAG_PARAM_JSP;
		title = "add Diagnostic Param";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchSubCharge(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String subChargecodeCode = null;
		String subChargecodeName = null;
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
			subChargecodeCode = searchField;
			subChargecodeName = null;

		} else {
			subChargecodeCode = null;
			subChargecodeName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchSubCharge(
				subChargecodeCode, subChargecodeName);

		jsp = SUB_CHARGE;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("subChargecodeCode", subChargecodeCode);
		map.put("subChargecodeName", subChargecodeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editSubCharge(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String subChargecodeCode = "";
		String subChargecodeName = "";
		int mainChargecodeId = 0;
		int subChargecodeId = 0;
		int departmentId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& !(request.getParameter(MAIN_CHARGECODE_ID).equals(""))) {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			subChargecodeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			subChargecodeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			subChargecodeName = request.getParameter(SEARCH_NAME);
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
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", subChargecodeId);
		generalMap.put("subChargecodeCode", subChargecodeCode);
		generalMap.put("name", subChargecodeName);
		generalMap.put("mainChargecodeId", mainChargecodeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("departmentId", departmentId);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingSubChargeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingSubChargeNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editSubChargeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingSubChargeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showSubChargeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showSubChargeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SUB_CHARGE;
		title = "edit SubCharge";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteSubCharge(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int subChargeCodeId = 0;
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
			subChargeCodeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteSubCharge(
				subChargeCodeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=subChargeCodeId";
		try {
			map = hospitalDetailsMasterHandlerService.showSubChargeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SUB_CHARGE;
		title = "delete SubCharge";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------------------------- ICD Main Category
	// -------------------------------

	public ModelAndView searchIcdMainCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String icdMaincategoryCode = null;
		String icdMaincategoryName = null;
		String searchField = null;
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdMaincategoryCode = request.getParameter(CODE);

		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdMaincategoryName = request.getParameter(SEARCH_NAME);
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
			icdMaincategoryCode = searchField;
			icdMaincategoryName = null;
		} else {
			icdMaincategoryCode = null;
			icdMaincategoryName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchIcdMainCategory(
				icdMaincategoryCode, icdMaincategoryName);
		jsp = ICD_MAIN_CATEGORY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("icdMaincategoryCode", icdMaincategoryCode);
		map.put("icdMaincategoryName", icdMaincategoryName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showIcdMainCategoryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showIcdMainCategoryJsp();
		@SuppressWarnings("unused")
		ArrayList searchIcdMainCategoryList = (ArrayList) map
				.get("searchIcdMainCategoryList");
		jsp = ICD_MAIN_CATEGORY_JSP;
		jsp += ".jsp";
		title = "ICD Main Category";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addIcdMainCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasIcdMainCategory masIcdMainCategory = new MasIcdMainCategory();

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

		List icdMainCategoryCodeList = new ArrayList();
		List icdMainCategoryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			icdMainCategoryCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			icdMainCategoryNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((icdMainCategoryNameList.size() == 0 || icdMainCategoryNameList == null)
				&& (icdMainCategoryNameList.size() == 0 || icdMainCategoryNameList == null)) {
			masIcdMainCategory.setIcdMaincategoryCode(code);
			masIcdMainCategory.setIcdMaincategoryName(name);
			masIcdMainCategory.setStatus("y");
			masIcdMainCategory.setLastChgBy(changedBy);
			masIcdMainCategory.setLastChgDate(currentDate);
			masIcdMainCategory.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addIcdMainCategory(masIcdMainCategory);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";

			}
		}

		else if ((icdMainCategoryCodeList.size() != 0 || icdMainCategoryCodeList != null)
				|| (icdMainCategoryNameList.size() != 0)
				|| icdMainCategoryNameList != null) {

			if ((icdMainCategoryCodeList.size() != 0 || icdMainCategoryCodeList != null)
					&& (icdMainCategoryNameList.size() == 0 || icdMainCategoryNameList == null)) {

				message = "icd Main Category Code  already exists.";
			} else if ((icdMainCategoryNameList.size() != 0 || icdMainCategoryNameList != null)
					&& (icdMainCategoryCodeList.size() == 0 || icdMainCategoryCodeList == null)) {

				message = "icd Main Category Name already exists.";
			} else if ((icdMainCategoryCodeList.size() != 0 || icdMainCategoryCodeList != null)
					&& (icdMainCategoryNameList.size() != 0 || icdMainCategoryNameList != null)) {

				message = "icd Main Category Code and icd Main Category Name already exist.";
			}
		}
		url = "/hms/hms/hospital?method=showIcdMainCategoryJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdMainCategoryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_MAIN_CATEGORY_JSP;
		title = "add IcdMainCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editIcdMainCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String icdMainCategoryCode = "";
		String icdMainCategoryName = "";
		int icdMainCategoryId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			icdMainCategoryId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdMainCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdMainCategoryName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", icdMainCategoryId);
		generalMap.put("icdMainCategoryCode", icdMainCategoryCode);
		generalMap.put("name", icdMainCategoryName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingIcdMainCategoryNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingIcdMainCategoryNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editIcdMainCategoryToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingIcdMainCategoryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showIcdMainCategoryJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdMainCategoryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_MAIN_CATEGORY_JSP;
		title = "edit IcdMainCategory";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteIcdMainCategory(HttpServletRequest request,
			HttpServletResponse response)

	{
		Map<String, Object> map = new HashMap<String, Object>();
		int icdMainCategoryId = 0;
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
			icdMainCategoryId = Integer.parseInt(request
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

		dataDeleted = hospitalDetailsMasterHandlerService
				.deleteIcdMainCategory(icdMainCategoryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showIcdMainCategoryJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdMainCategoryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_MAIN_CATEGORY_JSP;
		title = "delete IcdMainCategory";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// ----------------------------ICD Master------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showIcdJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showIcdJsp();
		@SuppressWarnings("unused")
		ArrayList searchIcdList = (ArrayList) map.get("searchIcdList");
		jsp = ICD_JSP;
		jsp += ".jsp";
		title = "ICD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addIcd(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasIcd masIcd = new MasIcd();

		int icdSubCategoryId = 0;
		int icdCauseId = 0;
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
		if (!request.getParameter(ICD_SUB_CATEGORY_ID).equals("0")) {
			icdSubCategoryId = Integer.parseInt(request
					.getParameter(ICD_SUB_CATEGORY_ID));
		}
		if (!request.getParameter(ICD_CAUSE_GROUP_ID).equals("0")) {
			icdCauseId = Integer.parseInt(request
					.getParameter(ICD_CAUSE_GROUP_ID));
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

		List icdCodeList = new ArrayList();
		List icdNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			icdCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			icdNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((icdCodeList.size() == 0 || icdCodeList == null)
				&& (icdNameList.size() == 0 || icdNameList == null)) {
			masIcd.setIcdCode(code);
			masIcd.setIcdName(name);

			if (icdSubCategoryId != 0) {
				MasIcdSubCategory masIcdSubCategory = new MasIcdSubCategory();
				masIcdSubCategory.setId(icdSubCategoryId);
				masIcd.setIcdSubCategory(masIcdSubCategory);
			}
			if (icdCauseId != 0) {
				MasIcdcausegrp masIcdcausegrp = new MasIcdcausegrp();
				masIcdcausegrp.setId(icdCauseId);
				masIcd.setIcdCause(masIcdcausegrp);
			}

			masIcd.setStatus("y");
			masIcd.setLastChgBy(changedBy);
			masIcd.setLastChgDate(currentDate);
			masIcd.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addIcd(masIcd);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((icdCodeList.size() != 0 || icdCodeList != null)
				|| (icdNameList.size() != 0) || icdNameList != null) {

			if ((icdCodeList.size() != 0 || icdCodeList != null)
					&& (icdNameList.size() == 0 || icdNameList == null)) {

				message = "ICD Code  already exists.";
			} else if ((icdNameList.size() != 0 || icdNameList != null)
					&& (icdCodeList.size() == 0 || icdCodeList == null)) {

				message = "ICD Name  already exists.";
			} else if ((icdCodeList.size() != 0 || icdCodeList != null)
					&& (icdNameList.size() != 0 || icdNameList != null)) {

				message = "ICD Code and ICD Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showIcdJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_JSP;
		title = "add Icd";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchIcd(HttpServletRequest request,
			HttpServletResponse response) throws

	ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String icdCode = null;
		String icdName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdName = request.getParameter(SEARCH_NAME);
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
			icdCode = searchField;
			icdName = null;

		} else {
			icdCode = null;
			icdName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchIcd(icdCode, icdName);
		jsp = ICD_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("icdCode", icdCode);
		map.put("icdName", icdName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editIcd(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String icdCode = "";
		String icdName = "";
		int icdSubCategoryId = 0;
		int icdId = 0;
		int icdCauseId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (!request.getParameter(ICD_SUB_CATEGORY_ID).equals("0")) {
			icdSubCategoryId = Integer.parseInt(request
					.getParameter(ICD_SUB_CATEGORY_ID));
		}
		if (!request.getParameter(ICD_CAUSE_GROUP_ID).equals("0")) {
			icdCauseId = Integer.parseInt(request
					.getParameter(ICD_CAUSE_GROUP_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			icdId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdName = request.getParameter(SEARCH_NAME);
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
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", icdId);
		generalMap.put("icdCode", icdCode);
		generalMap.put("name", icdName);
		generalMap.put("icdSubCategoryId", icdSubCategoryId);
		generalMap.put("icdCauseId", icdCauseId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingIcdNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingIcdNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editIcdToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingIcdNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showIcdJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_JSP;
		title = "edit Icd";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteIcd(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int icdId = 0;
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
			icdId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteIcd(icdId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showIcdJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_JSP;
		title = "delete Icd";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// --------------------------------------------------- Icd SubCategory
	// ---------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showIcdSubCategoryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showIcdSubCategoryJsp();
		@SuppressWarnings("unused")
		ArrayList searchIcdSubCategoryList = (ArrayList) map
				.get("searchIcdSubCategoryList");
		jsp = ICD_SUB_CATEGORY_JSP;
		jsp += ".jsp";
		title = "ICD SubCategory";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addIcdSubCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasIcdSubCategory masIcdSubCategory = new MasIcdSubCategory();
		int icdMainCategoryId = 0;
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
		if (request.getParameter(ICD_MAIN_CATEGORY_ID) != null) {
			icdMainCategoryId = Integer.valueOf(request
					.getParameter(ICD_MAIN_CATEGORY_ID));
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

		List icdSubCategoryCodeList = new ArrayList();
		List icdSubCategoryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			icdSubCategoryCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			icdSubCategoryNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((icdSubCategoryCodeList.size() == 0 || icdSubCategoryCodeList == null)
				&& (icdSubCategoryNameList.size() == 0 || icdSubCategoryNameList == null)) {
			masIcdSubCategory.setIcdSubCategoryCode(code);
			masIcdSubCategory.setIcdSubCategoryName(name);
			MasIcdMainCategory masIcdMainCategory = new MasIcdMainCategory();
			masIcdMainCategory.setId(icdMainCategoryId);
			masIcdSubCategory.setIcdMaincategory(masIcdMainCategory);

			masIcdSubCategory.setStatus("y");
			masIcdSubCategory.setLastChgBy(changedBy);
			masIcdSubCategory.setLastChgDate(currentDate);
			masIcdSubCategory.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addIcdSubCategory(masIcdSubCategory);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((icdSubCategoryCodeList.size() != 0 || icdSubCategoryCodeList != null)
				|| (icdSubCategoryNameList.size() != 0)
				|| icdSubCategoryNameList != null) {

			if ((icdSubCategoryCodeList.size() != 0 || icdSubCategoryCodeList != null)
					&& (icdSubCategoryNameList.size() == 0 || icdSubCategoryNameList == null)) {

				message = "ICD SubCategory Code  already exists.";
			} else if ((icdSubCategoryNameList.size() != 0 || icdSubCategoryNameList != null)
					&& (icdSubCategoryCodeList.size() == 0 || icdSubCategoryCodeList == null)) {

				message = "ICD SubCategory Name  already exists.";
			} else if ((icdSubCategoryCodeList.size() != 0 || icdSubCategoryCodeList != null)
					&& (icdSubCategoryNameList.size() != 0 || icdSubCategoryNameList != null)) {

				message = "ICD SubCategory Code and ICD SubCategory Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showIcdSubCategoryJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdSubCategoryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_SUB_CATEGORY_JSP;
		title = "add IcdSubCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchIcdSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String icdSubCategoryCode = null;
		String icdSubCategoryName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdSubCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdSubCategoryName = request.getParameter(SEARCH_NAME);
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
			icdSubCategoryCode = searchField;
			icdSubCategoryName = null;
		} else {
			icdSubCategoryCode = null;
			icdSubCategoryName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchIcdSubCategory(
				icdSubCategoryCode, icdSubCategoryName);
		jsp = ICD_SUB_CATEGORY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("icdSubCategoryCode", icdSubCategoryCode);
		map.put("icdSubCategoryName", icdSubCategoryName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editIcdSubCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String icdSubCategoryCode = "";
		String icdSubCategoryName = "";
		int icdMainCategoryId = 0;
		int icdSubCategoryId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(ICD_MAIN_CATEGORY_ID) != null
				&& !(request.getParameter(ICD_MAIN_CATEGORY_ID).equals(""))) {
			icdMainCategoryId = Integer.parseInt(request
					.getParameter(ICD_MAIN_CATEGORY_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			icdSubCategoryId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdSubCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdSubCategoryName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", icdSubCategoryId);
		generalMap.put("icdSubCategoryCode", icdSubCategoryCode);
		generalMap.put("name", icdSubCategoryName);
		generalMap.put("icdMainCategoryId", icdMainCategoryId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingIcdSubCategoryNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingIcdSubCategoryNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editIcdSubCategoryToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingIcdSubCategoryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showIcdSubCategoryJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdSubCategoryJsp();

		} catch (Exception e) {
			//System.out.println("Exception in showIcdSubCategoryJsp " + e);
		}
		jsp = ICD_SUB_CATEGORY_JSP;
		title = "edit IcdSubCategory";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteIcdSubCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int icdSubCategoryId = 0;
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
			icdSubCategoryId = Integer
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteIcdSubCategory(
				icdSubCategoryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showIcdSubCategoryJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdSubCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_SUB_CATEGORY_JSP;
		title = "delete IcdSubCategory";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// ----------------------------- Service Type -------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showServiceTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showServiceTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchServiceTypeList = (ArrayList) map
				.get("searchServiceTypeList");
		jsp = SERVICE_TYPE_JSP;
		jsp += ".jsp";
		title = "ServiceType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchServiceType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceTypeCode = null;
		String serviceTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			serviceTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			serviceTypeName = request.getParameter(SEARCH_NAME);
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
			serviceTypeCode = searchField;
			serviceTypeName = null;
		} else {
			serviceTypeCode = null;
			serviceTypeName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchServiceType(
				serviceTypeCode, serviceTypeName);

		jsp = SERVICE_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("serviceTypeCode", serviceTypeCode);
		map.put("serviceTypeName", serviceTypeName);

		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addServiceType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasServiceType masServiceType = new MasServiceType();
		String changedBy = "";
		String shortDescription = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SHORT_DESCRIPTION) != null) {
			shortDescription = request.getParameter(SHORT_DESCRIPTION);
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

		List serviceTypeCodeList = new ArrayList();
		List serviceTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			serviceTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			serviceTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((serviceTypeCodeList.size() == 0 || serviceTypeCodeList == null)
				&& (serviceTypeNameList.size() == 0 || serviceTypeNameList == null)) {
			masServiceType.setServiceTypeCode(code);
			masServiceType.setServiceTypeName(name);
			masServiceType.setServiceNameShortDesc(shortDescription);
			masServiceType.setStatus("y");
			masServiceType.setLastChgBy(changedBy);
			masServiceType.setLastChgDate(currentDate);
			masServiceType.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addServiceType(masServiceType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((serviceTypeCodeList.size() != 0 || serviceTypeCodeList != null)
				|| (serviceTypeNameList.size() != 0)
				|| serviceTypeNameList != null) {

			if ((serviceTypeCodeList.size() != 0 || serviceTypeCodeList != null)
					&& serviceTypeNameList.size() == 0
					|| serviceTypeNameList == null) {
				message = "ServiceType Code  already exists.";
			} else if ((serviceTypeNameList.size() != 0 || serviceTypeNameList != null)
					&& (serviceTypeCodeList.size() == 0 || serviceTypeCodeList == null)) {
				message = "ServiceType Name already exists.";
			} else if ((serviceTypeCodeList.size() != 0 || serviceTypeCodeList != null)
					&& (serviceTypeNameList.size() != 0 || serviceTypeNameList != null)) {

				message = "ServiceType Code and ServiceType Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showServiceTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showServiceTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SERVICE_TYPE_JSP;
		title = "Add Service type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView editServiceType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String serviceTypeCode = "";
		String serviceTypeName = "";
		String shortDescription = "";
		int serviceTypeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			serviceTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			serviceTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			serviceTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SHORT_DESCRIPTION) != null
				&& !(request.getParameter(SHORT_DESCRIPTION).equals(""))) {
			shortDescription = request.getParameter(SHORT_DESCRIPTION);
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

		generalMap.put("id", serviceTypeId);
		generalMap.put("serviceTypeCode", serviceTypeCode);
		generalMap.put("name", serviceTypeName);
		generalMap.put("shortDescription", shortDescription);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingServiceTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingServiceTypeNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editServiceTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingServiceTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showServiceTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showServiceTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SERVICE_TYPE_JSP;
		title = "Edit Service Type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteServiceType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int serviceTypeId = 0;
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
			serviceTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteServiceType(
				serviceTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showServiceTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showServiceTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SERVICE_TYPE_JSP;
		title = "Delete Service type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// --------------------------- REPORT METHOD For Service Type
	// ------------------------
	public ModelAndView genrateReportForServiceType(HttpServletRequest request,
			HttpServletResponse resp) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceTypeCode = null;
		String serviceTypeName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "ServiceTypeCode", "ServiceTypeName" };
		List<MasServiceType> searchServiceTypeList = new ArrayList<MasServiceType>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			serviceTypeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			serviceTypeName = request.getParameter(SEARCH_NAME);
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
			serviceTypeCode = searchField;
			serviceTypeName = null;

		} else {
			serviceTypeCode = null;
			serviceTypeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchIcdSubCategory(
				serviceTypeCode, serviceTypeName);
		searchServiceTypeList = (List<MasServiceType>) map
				.get("searchServiceTypeList");
		if (searchServiceTypeList != null || !searchServiceTypeList.isEmpty()) {
			ds = new ReportDataSource(fields, searchServiceTypeList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("servicetype"), new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//System.out.println("No Report Data found");
		}

		return null;
	}

	// --------------------------- REPORT METHOD For Cost Center
	// ------------------------

	public ModelAndView genrateReportForCostCenterCode(
			HttpServletRequest request, HttpServletResponse resp)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String costCenterCode = null;
		String costCenterName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "CostCenterCode", "CostCenterName" };
		List<MasCostCenter> searchCostCenterList = new ArrayList<MasCostCenter>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			costCenterCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			costCenterName = request.getParameter(SEARCH_NAME);
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
			costCenterCode = searchField;
			costCenterName = null;

		} else {
			costCenterCode = null;
			costCenterName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchCostCenter(
				costCenterCode, costCenterName);
		searchCostCenterList = (List<MasCostCenter>) map
				.get("searchCostCenterList");
		if (searchCostCenterList != null || !searchCostCenterList.isEmpty()) {
			ds = new ReportDataSource(fields, searchCostCenterList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("costcenter"), new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//System.out.println("No Report Data found");
		}

		return null;
	}

	// --------------------------- REPORT METHODS For Major Category Code
	// ------------------------

	public ModelAndView genrateReportForMajorCategoryCode(
			HttpServletRequest request, HttpServletResponse resp)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String majorCategoryCode = null;
		String majorCategoryName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "MajorCategoryCode", "MajorCategoryName" };
		List<MasMajorCategoryCode> searchMajorCategoryCodeList = new ArrayList<MasMajorCategoryCode>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			majorCategoryCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			majorCategoryName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);

			}

			if (request.getParameter(SELECTED_RADIO) != null &&

			!(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio

				= Integer.parseInt(request.getParameter(SELECTED_RADIO));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			majorCategoryCode = searchField;
			majorCategoryName = null;

		} else {
			majorCategoryCode = null;
			majorCategoryName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchMajorCategoryCode(
				majorCategoryCode, majorCategoryName);
		searchMajorCategoryCodeList = (List<MasMajorCategoryCode>) map
				.get("searchMajorCategoryCodeList");
		if (searchMajorCategoryCodeList != null
				|| !searchMajorCategoryCodeList.isEmpty()) {
			ds = new ReportDataSource(fields, searchMajorCategoryCodeList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("majorcategorycode"), new HashMap(),
						ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//System.out.println("No Report Data found");
		}

		return null;
	}

	// --------------------------- REPORT METHODS Death Cause
	// ------------------------

	public ModelAndView generateReportForDeathCause(HttpServletRequest request,
			HttpServletResponse resp) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String deathCauseCode = null;
		String deathCauseName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "DeathCauseCode", "DeathCauseName" };
		List<MasDeathCause> searchDeathCauseList = new ArrayList<MasDeathCause>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			deathCauseCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			deathCauseName = request.getParameter(SEARCH_NAME);
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
			deathCauseCode = searchField;
			deathCauseName = null;

		} else {
			deathCauseCode = null;
			deathCauseName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchDeathCause(
				deathCauseCode, deathCauseName);
		searchDeathCauseList = (List<MasDeathCause>) map
				.get("searchDeathCauseList");
		if (searchDeathCauseList != null || !searchDeathCauseList.isEmpty()) {
			ds = new ReportDataSource(fields, searchDeathCauseList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("deathcause"), new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//System.out.println("No Report Data found");
		}

		return null;
	}

	// --------------------------- REPORT METHOD For Patient Status
	// ------------------------

	public ModelAndView generateReportForPatientStatus(
			HttpServletRequest request, HttpServletResponse resp)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String patientStatusCode = null;
		String patientStatusName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "PatientStatusCode", "PatientStatusName" };
		List<MasPatientStatus> searchPatientStatusList = new ArrayList<MasPatientStatus>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			patientStatusCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			patientStatusName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);

			}

			if (request.getParameter(SELECTED_RADIO) != null &&

			!(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio

				= Integer.parseInt(request.getParameter(SELECTED_RADIO));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			patientStatusCode = searchField;
			patientStatusName = null;

		} else {
			patientStatusCode = null;
			patientStatusName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchPatientStatus(
				patientStatusCode, patientStatusName);
		searchPatientStatusList = (List<MasPatientStatus>) map
				.get("searchPatientStatusList");
		if (searchPatientStatusList != null
				|| !searchPatientStatusList.isEmpty()) {
			ds = new ReportDataSource(fields, searchPatientStatusList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("patientstatus"), new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//System.out.println("No Report Data found");
		}

		return null;
	}

	// --------------------------- REPORT METHOD For Main Charge Code
	// ------------------------

	public ModelAndView genrateReportForMainChargecode(
			HttpServletRequest request, HttpServletResponse resp)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String mainChargecodeCode = null;
		String mainChargecodeName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "mainChargecodeCode", "mainChargecodeName" };
		List<MasMainChargecode> searchMainChargecodeList = new ArrayList<MasMainChargecode>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			mainChargecodeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			mainChargecodeName = request.getParameter(SEARCH_NAME);
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
			mainChargecodeCode = searchField;
			mainChargecodeName = null;

		} else {
			mainChargecodeCode = null;
			mainChargecodeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchMainChargecode(
				mainChargecodeCode, mainChargecodeName);
		searchMainChargecodeList = (List<MasMainChargecode>) map
				.get("searchMainChargecodeList");
		if (searchMainChargecodeList != null
				|| !searchMainChargecodeList.isEmpty()) {
			ds = new ReportDataSource(fields, searchMainChargecodeList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager
						.runReportToPdf(getCompiledReport("main_chargecode"),
								new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//System.out.println("No Report Data found");
		}

		return null;
	}

	// --------------------------- REPORT METHOD For Complaint
	// ------------------------

	public ModelAndView generateReportForComplaint(HttpServletRequest request,
			HttpServletResponse resp) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String complaintCode = null;
		String complaintName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "ComplaintCode", "ComplaintName" };
		List<MasComplaint> searchComplaintList = new ArrayList<MasComplaint>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complaintCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			complaintName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);

			}

			if (request.getParameter(SELECTED_RADIO) != null &&

			!(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio

				= Integer.parseInt(request.getParameter(SELECTED_RADIO));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			complaintCode = searchField;
			complaintName = null;

		} else {
			complaintCode = null;
			complaintName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchComplaint(
				complaintCode, complaintName);
		searchComplaintList = (List<MasComplaint>) map
				.get("searchComplaintList");
		if (searchComplaintList != null || !searchComplaintList.isEmpty()) {
			ds = new ReportDataSource(fields, searchComplaintList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("complaint"), new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//System.out.println("No Report Data found");
		}

		return null;
	}

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	// --------------------------- REPORT METHOD For ICD Main Category Code
	// ------------------------

	public ModelAndView genrateReportForICDMainCategory(
			HttpServletRequest request, HttpServletResponse resp)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String icdMainCategoryCode = null;
		String icdMainCategoryName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "IcdMaincategoryCode", "IcdMaincategoryCode" };
		List<MasIcdMainCategory> searchIcdMainCategoryList = new ArrayList<MasIcdMainCategory>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdMainCategoryCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdMainCategoryName = request.getParameter(SEARCH_NAME);
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
			icdMainCategoryCode = searchField;
			icdMainCategoryName = null;

		} else {
			icdMainCategoryCode = null;
			icdMainCategoryName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchIcdMainCategory(
				icdMainCategoryCode, icdMainCategoryName);
		searchIcdMainCategoryList = (List<MasIcdMainCategory>) map
				.get("searchIcdMainCategoryList");
		if (searchIcdMainCategoryList != null
				|| !searchIcdMainCategoryList.isEmpty()) {
			ds = new ReportDataSource(fields, searchIcdMainCategoryList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager
						.runReportToPdf(getCompiledReport("IcdMainCategory"),
								new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//System.out.println("No Report Data found");
		}

		return null;
	}

	// --------------------------- REPORT METHODS For ICD Sub Category
	// ------------------------

	public ModelAndView genrateReportForICDSubCategory(
			HttpServletRequest request, HttpServletResponse resp)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String icdSubCategoryCode = null;
		String icdSubCategoryName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "IcdSubcategoryCode", "IcdSubcategoryCode" };
		List<MasIcdSubCategory> searchIcdSubCategoryList = new ArrayList<MasIcdSubCategory>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdSubCategoryCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdSubCategoryName = request.getParameter(SEARCH_NAME);
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
			icdSubCategoryCode = searchField;
			icdSubCategoryName = null;

		} else {
			icdSubCategoryCode = null;
			icdSubCategoryName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchIcdSubCategory(
				icdSubCategoryCode, icdSubCategoryName);
		searchIcdSubCategoryList = (List<MasIcdSubCategory>) map
				.get("searchIcdSubCategoryList");
		if (searchIcdSubCategoryList != null
				|| !searchIcdSubCategoryList.isEmpty()) {
			ds = new ReportDataSource(fields, searchIcdSubCategoryList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("IcdSubCategory"), new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//System.out.println("No Report Data found");
		}

		return null;
	}

	// -------------------------------------------------------------------------------------------------

	public ModelAndView generateReportForHospitalRelatedMasters(
			HttpServletRequest request, HttpServletResponse response) {
		String jasper = null;
		int group = 0;
		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
			//System.out.println("jasper" + jasper);
		}

		if (request.getParameter("group") != null) {
			group = Integer.parseInt(request.getParameter("group").toString());
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = hospitalDetailsMasterHandlerService.getConnection();
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		parameters.put("group", group);
		HMSUtil.generateReport(jasper, parameters, (Connection) parameters
				.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);
	}

	// --------------------------------------Patient
	// Type----------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showPatientTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showPatientTypeJsp();
		jsp = PATIENT_TYPE_JSP;
		jsp += ".jsp";
		title = "Patient Type";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchPatientType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String patientTypeCode = null;
		String patientTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			patientTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			patientTypeName = request.getParameter(SEARCH_NAME);
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
			patientTypeCode = searchField;
			patientTypeName = null;
		} else {
			patientTypeCode = null;
			patientTypeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchPatientType(
				patientTypeCode, patientTypeName);

		jsp = PATIENT_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("patientTypeCode", patientTypeCode);
		map.put("patientTypeName", patientTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPatientType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasPatientType masPatientType = new MasPatientType();
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

		List patientTypeCodeList = new ArrayList();
		List patientTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			patientTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			patientTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((patientTypeCodeList.size() == 0 || patientTypeCodeList == null)
				&& (patientTypeNameList.size() == 0 || patientTypeNameList == null)) {
			masPatientType.setPatientTypeCode(code);
			masPatientType.setPatientTypeName(name);
			masPatientType.setStatus("y");
			masPatientType.setLastChgBy(changedBy);
			masPatientType.setLastChgDate(currentDate);
			masPatientType.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addPatientType(masPatientType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";

			} else {
				message = "Try Again !!";

			}
		}

		else if ((patientTypeCodeList.size() != 0 || patientTypeCodeList != null)
				|| (patientTypeNameList.size() != 0)
				|| patientTypeNameList != null) {

			if ((patientTypeCodeList.size() != 0 || patientTypeCodeList != null)
					&& (patientTypeNameList.size() == 0 || patientTypeNameList == null)) {

				message = "Patient Type Code  already exists.";
			} else if ((patientTypeNameList.size() != 0 || patientTypeNameList != null)
					&& (patientTypeCodeList.size() == 0 || patientTypeCodeList == null)) {

				message = "Patient Type Name already exists.";
			} else if ((patientTypeCodeList.size() != 0 || patientTypeCodeList != null)
					&& (patientTypeNameList.size() != 0 || patientTypeNameList != null)) {

				message = "Patient Type Code and Patient Type Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showPatientTypeJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showPatientTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PATIENT_TYPE_JSP;
		title = "Add Patient Type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView editPatientType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String patientTypeCode = "";
		String patientTypeName = "";
		int patientTypeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			patientTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			patientTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			patientTypeName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", patientTypeId);
		generalMap.put("patientTypeCode", patientTypeCode);
		generalMap.put("name", patientTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingPatientTypeNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingPatientTypeNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editPatientTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingPatientTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showPatientTypeJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showPatientTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PATIENT_TYPE_JSP;
		title = "update PatientType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deletePatientType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int patientTypeId = 0;
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
			patientTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deletePatientType(
				patientTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showPatientTypeJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showPatientTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PATIENT_TYPE_JSP;
		title = "delete PatientType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// --------------------------------------------IcdCausegrp
	// -----------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showIcdCauseJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = hospitalDetailsMasterHandlerService.showIcdCauseJsp();
		jsp = ICD_CAUSE_GROUP_JSP;
		jsp += ".jsp";
		title = "icdCausegrp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchIcdCause(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String causeCode = null;
		String causeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			causeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			causeName = request.getParameter(SEARCH_NAME);
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
			causeCode = searchField;
			causeName = null;

		} else {
			causeCode = null;
			causeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchIcdCause(causeCode,
				causeName);
		jsp = ICD_CAUSE_GROUP_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("causeCode", causeCode);
		map.put("causeName", causeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addIcdCause(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasIcdcausegrp masIcdcausegrp = new MasIcdcausegrp();
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
		List causeCodeList = new ArrayList();
		List causeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			causeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			causeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((causeCodeList.size() == 0 || causeCodeList == null)
				&& (causeNameList.size() == 0 || causeNameList == null)) {
			masIcdcausegrp.setIcdCauseCode(code);
			masIcdcausegrp.setIcdCauseName(name);
			masIcdcausegrp.setStatus("y");
			masIcdcausegrp.setLastChgBy(changedBy);
			masIcdcausegrp.setLastChgDate(currentDate);
			masIcdcausegrp.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addIcdCause(masIcdcausegrp);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((causeCodeList.size() != 0 || causeCodeList != null)
				|| (causeNameList.size() != 0) || causeNameList != null) {
			if ((causeCodeList.size() != 0 || causeCodeList != null)
					&& (causeNameList.size() == 0 || causeNameList == null)) {
				message = "Cause Code  already exists.";
			} else if ((causeNameList.size() != 0 || causeNameList != null)
					&& (causeCodeList.size() == 0 || causeCodeList == null)) {
				message = "Cause Name already exists.";
			} else if ((causeCodeList.size() != 0 || causeCodeList != null)
					&& (causeNameList.size() != 0 || causeNameList != null)) {
				message = "Cause Code and Death Cause Name already exist.";
			}

		}
		url = "/hms/hms/hospital?method=showIcdCauseJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdCauseJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_CAUSE_GROUP_JSP;
		title = "Add icdCausegrp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editIcdCause(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String causeCode = "";
		String causeName = "";
		int causeId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			causeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			causeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			causeName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", causeId);
		generalMap.put("causeCode", causeCode);
		generalMap.put("name", causeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCauseNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingCauseNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editIcdCauseToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCauseNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showIcdCauseJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdCauseJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_CAUSE_GROUP_JSP;
		title = "Update icdCausegrp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteIcdCause(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int causeId = 0;
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
			causeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteIcdCause(
				causeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/hospital?method=showIcdCauseJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdCauseJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_CAUSE_GROUP_JSP;
		title = "Delete icdCausegrp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ------------------------------------------------------------------------------------------
	/** new Diag Param master **/
	@SuppressWarnings("unchecked")
	public ModelAndView showParamJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = hospitalDetailsMasterHandlerService.showParamJsp();
		@SuppressWarnings("unused")
		ArrayList searchParamList = (ArrayList) map.get("searchParamList");
		jsp = DIAG_PARAM_JSP;
		jsp += ".jsp";
		title = "Parameter";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView addSubCharge(HttpServletRequest request,
			HttpServletResponse response) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		MasSubChargecode masSubChargecode = new MasSubChargecode();
		int mainChargecodeId = 0;
		String changedBy = "";
		Map listMap = new HashMap();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int deptId = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.valueOf(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			deptId = Integer.valueOf(request.getParameter(DEPARTMENT_ID));
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

		List subChargeCodeList = new ArrayList();
		List subChargeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			subChargeCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			subChargeNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((subChargeCodeList.size() == 0 || subChargeCodeList == null)
				&& (subChargeNameList.size() == 0 || subChargeNameList == null)) {
			masSubChargecode.setSubChargecodeCode(code);
			masSubChargecode.setSubChargecodeName(name);

			MasMainChargecode masMainChargecode = new MasMainChargecode();
			masMainChargecode.setId(mainChargecodeId);
			masSubChargecode.setMainChargecode(masMainChargecode);
			MasDepartment masDep = new MasDepartment();
			masDep.setId(deptId);
			masSubChargecode.setDepartment(masDep);
			masSubChargecode.setStatus("y");
			masSubChargecode.setLastChgBy(changedBy);
			masSubChargecode.setLastChgDate(currentDate);
			masSubChargecode.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addSubCharge(masSubChargecode);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((subChargeCodeList.size() != 0 || subChargeCodeList != null)
				|| (subChargeNameList.size() != 0) || subChargeNameList != null) {

			if ((subChargeCodeList.size() != 0 || subChargeCodeList != null)
					&& (subChargeNameList.size() == 0 || subChargeNameList == null)) {

				message = "SubCharge Code  already exists.";
			} else if ((subChargeNameList.size() != 0 || subChargeNameList != null)
					&& (subChargeCodeList.size() == 0 || subChargeCodeList == null)) {

				message = "SubCharge Description  already exists.";
			} else if ((subChargeCodeList.size() != 0 || subChargeCodeList != null)
					&& (subChargeNameList.size() != 0 || subChargeNameList != null)) {

				message = "SubCharge Code and SubCharge Description already exist.";
			}
		}

		try {
			map = hospitalDetailsMasterHandlerService.showSubChargeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SUB_CHARGE;
		title = "add SubCharge";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editDiagParam(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		int sequenceNo = 0;
		String prefix = "";
		String criteria = "";
		int diagId = 0;

		if (request.getParameter(SEQUENCE_NO) != null
				&& !(request.getParameter(SEQUENCE_NO).equals(""))) {
			sequenceNo = Integer.parseInt(request.getParameter(SEQUENCE_NO));
		}
		if (request.getParameter(DIAG_ID) != null) {
			diagId = Integer.parseInt(request.getParameter(DIAG_ID));
		}
		if (request.getParameter(PREFIX) != null
				&& !(request.getParameter(PREFIX).equals(""))) {
			prefix = request.getParameter(PREFIX);
		}
		if (request.getParameter(CRITERIA) != null
				&& !(request.getParameter(CRITERIA).equals(""))) {
			criteria = request.getParameter(CRITERIA);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", diagId);
		generalMap.put("sequenceNo", sequenceNo);
		generalMap.put("prefix", prefix);
		generalMap.put("criteria", criteria);

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		// listMap =
		// commonMasterHandlerService.checkForExistingMasters(generalMap);
		// List existingSubChargeNameList =
		// (List)listMap.get("duplicateMastersList");

		boolean dataUpdated = false;

		dataUpdated = hospitalDetailsMasterHandlerService
				.editDiagParam(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}

		url = "/hms/hms/hospital?method=showParamJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showParamJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIAG_PARAM_JSP;
		title = "edit Diag Param";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteDiagParam(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int diagId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(DIAG_ID) != null
				&& !(request.getParameter(DIAG_ID).equals(""))) {
			diagId = Integer.parseInt(request.getParameter(DIAG_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteDiagParam(
				diagId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showParamJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showParamJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIAG_PARAM_JSP;
		title = "delete Diag Param";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchDiagParam(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String subChargecodeCode = null;
		String subChargecodeName = null;
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
			subChargecodeCode = searchField;
			subChargecodeName = null;

		} else {
			subChargecodeCode = null;
			subChargecodeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchSubChargeInDiagParam(
				subChargecodeCode, subChargecodeName);

		jsp = DIAG_PARAM_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("subChargecodeCode", subChargecodeCode);
		map.put("subChargecodeName", subChargecodeName);
		return new ModelAndView("indexB", "map", map);
	}
	
	// ------------------------------------------Session
			// ----------------------------------

			public ModelAndView searchSession(HttpServletRequest request,
					HttpServletResponse response) throws ServletRequestBindingException {
				Map<String, Object> map = new HashMap<String, Object>();
				String sessionName = null;

				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					sessionName = request.getParameter(SEARCH_NAME);
				}
				map = hospitalDetailsMasterHandlerService.searchSession(sessionName);
				jsp = "session";
				jsp += ".jsp";
				map.put("search", "search");
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("sessionName", sessionName);
				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unchecked")
			public ModelAndView showSessionJsp(HttpServletRequest request,
					HttpServletResponse response) {
				Map map = new HashMap();
				Box box=HMSUtil.getBox(request);
				HttpSession session=request.getSession();
				int hospitalId=0;
				if(session.getAttribute(HOSPITAL_ID)!=null){
					hospitalId=Integer.parseInt(session.getAttribute(HOSPITAL_ID).toString());
					box.put(HOSPITAL_ID, hospitalId);
				}
				
				map = hospitalDetailsMasterHandlerService.showSessionJsp(box);
				String jsp = "session";
				jsp += ".jsp";
				title = "Session";
				map.put("contentJsp", jsp);
				map.put("title", title);

				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unchecked")
			public ModelAndView addSession(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				MasSession masSession = new MasSession();
				String changedBy = "";
				String fromTime="";
				String toTime="";
				Map<String, Object> listMap = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();
				Date currentDate = new Date();
				HttpSession session = request.getSession();
				session = request.getSession();
				Integer userId = (Integer) session.getAttribute("userId");
				Box box=HMSUtil.getBox(request);
				int hospitalId=0;
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
					box.put(HOSPITAL_ID, hospitalId);
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
				if (request.getParameter(FROM_TIME) != null
						&& !(request.getParameter(FROM_TIME).equals(""))) {
					fromTime = request.getParameter(FROM_TIME);
				}
				if (request.getParameter(TO_TIME) != null
						&& !(request.getParameter(TO_TIME).equals(""))) {
					toTime = request.getParameter(TO_TIME);
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

				if (request.getParameter("pojoPropertyName") != null) {
					pojoPropertyName = request.getParameter("pojoPropertyName");
				}

				generalMap.put("name", name);

				generalMap.put("currentDate", currentDate);
				generalMap.put("currentTime", currentTime);

				generalMap.put("pojoPropertyName", pojoPropertyName);
				generalMap.put("pojoName", pojoName);
				generalMap.put(HOSPITAL_ID, hospitalId);

				listMap = hospitalDetailsMasterHandlerService
						.checkSession(generalMap);
				List sessionNameList = new ArrayList();
				if (listMap.get("duplicateGeneralNameList") != null) {
					sessionNameList = (List) listMap.get("duplicateGeneralNameList");
				}
				boolean successfullyAdded = false;

				if ((sessionNameList.size() == 0 || sessionNameList == null)
						&& (sessionNameList.size() == 0 || sessionNameList == null)) {
					masSession.setSessionName(name);
					
					masSession.setFromTime(fromTime);
					masSession.setToTime(toTime);
					
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					masSession.setHospital(masHospital);
					
					
					masSession.setStatus("Y");
					
					Users users = new Users();
					users.setId(userId);
					masSession.setLastChgBy(users);
					
					
					masSession.setLastChgDate(currentDate);
					masSession.setLastChgTime(currentTime);
					successfullyAdded = hospitalDetailsMasterHandlerService.addSession(masSession);

					if (successfullyAdded) {
						message = "Record Added Successfully !!";
					} else {
						message = "Try Again !!";
					}
				} else if ((sessionNameList.size() != 0) || sessionNameList != null) {
					if ((sessionNameList.size() != 0 || sessionNameList != null)) {
						message = "Session Name already exists.";
					}
				}
				try {
					map = hospitalDetailsMasterHandlerService.showSessionJsp(box);
				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "session";
				title = "Add Session";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView editSession(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();
				Map<String, Object> listMap = new HashMap<String, Object>();
				MasSession masSession = new MasSession();
				session = request.getSession();
				String sessionName = "";
				int sessionId = 0;
				String changedBy = "";
				Date changedDate = null;
				String changedTime = "";
				int hospitalId=0;
				String fromTime="";
				String toTime="";
				Box box=HMSUtil.getBox(request); 
				if(session.getAttribute(HOSPITAL_ID)!=null){
					hospitalId=Integer.parseInt(session.getAttribute(HOSPITAL_ID).toString());
					box.put(HOSPITAL_ID, hospitalId);
				} 
				Integer userId = (Integer) session.getAttribute("userId");

				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					sessionId = Integer.parseInt(request.getParameter(COMMON_ID));
				}

				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					sessionName = request.getParameter(SEARCH_NAME);
				}

				if (request.getParameter(CHANGED_BY) != null
						&& !(request.getParameter(CHANGED_BY).equals(""))) {
					changedBy = request.getParameter(CHANGED_BY);
				}
				if (request.getParameter(FROM_TIME) != null
						&& !(request.getParameter(FROM_TIME).equals(""))) {
					fromTime = request.getParameter(FROM_TIME);
				}
				if (request.getParameter(TO_TIME) != null
						&& !(request.getParameter(TO_TIME).equals(""))) {
					toTime = request.getParameter(TO_TIME);
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

				generalMap.put("id", sessionId);
				generalMap.put("name", sessionName);
				generalMap.put("userId", userId);
				generalMap.put("hospitalId", hospitalId);
				generalMap.put("fromTime", fromTime);
				generalMap.put("toTime", toTime);
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
				generalMap.put("pojoPropertyName", pojoPropertyName);
				generalMap.put("pojoName", pojoName);

				generalMap.put("flag", true);

				listMap = commonMasterHandlerService
						.checkForExistingMasters(generalMap);
				List existingOccupationNameList = (List) listMap
						.get("duplicateGeneralNameList");

				boolean dataUpdated = false;
				if (existingOccupationNameList.size() == 0) {
					dataUpdated = hospitalDetailsMasterHandlerService
							.editSessionToDatabase(generalMap);

					if (dataUpdated == true) {
						message = "Record updated Successfully !!";
					} else {
						message = "Record Cant be updated !!";
					}
				} else if (existingOccupationNameList.size() > 0) {
					message = "Name already exists.";
				}
				url = "/hms/hms/hospitalDetailsMaster?method=showSessionJsp";

				try {
					map = hospitalDetailsMasterHandlerService.showSessionJsp(box);

				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "session";
				title = "update Session";
				jsp += ".jsp";

				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView deleteSession(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				int sessionId = 0;
				String message = null;
				String changedBy = "";
				String changedTime = "";
				Date changedDate = null; 
				HttpSession session = request.getSession();
				session = request.getSession();
				Integer userId = (Integer) session.getAttribute("userId"); 
				Map<String, Object> generalMap = new HashMap<String, Object>();
				String flag = "";
				Box box=HMSUtil.getBox(request);
				int hospitalId=0;
				if(session.getAttribute(HOSPITAL_ID)!=null){
					hospitalId=Integer.parseInt(session.getAttribute(HOSPITAL_ID).toString());
					box.put(HOSPITAL_ID, hospitalId);
				}
				if (request.getParameter("flag") != null) {
					flag = request.getParameter("flag");
					generalMap.put("flag", flag);
				}
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					sessionId = Integer.parseInt(request.getParameter(COMMON_ID));
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

				generalMap.put("userId", userId);
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
				boolean dataDeleted = false;
				dataDeleted = hospitalDetailsMasterHandlerService.deleteSession(sessionId,
						generalMap);
				if (dataDeleted == true) {
					message = "Record is InActivated successfully !!";
				}

				else {
					message = "Record is Activated successfully !!";
				}
				url = "/hms/hms/hospital?method=showSessionJsp";

				try {
					map = hospitalDetailsMasterHandlerService.showSessionJsp(box);
				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "session";
				title = "delete Session";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}
			

			public ModelAndView generateReportForGeneralMasters(HttpServletRequest request, HttpServletResponse response)
			{
				HttpSession session = request.getSession();
				Map<String, Object> mapResponse = new HashMap<String, Object>();
				Map<String, Object> mapForDs = new HashMap<String, Object>();
				List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
				int hospitalId = 0;
				String hospitalName = "";
				String qry = "";
				String searchField = "";
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					mapForDs.put("hospitalId", hospitalId);
					mapResponse = hospitalDetailsMasterHandlerService.getHospitalName(mapForDs);
				}
				if (mapResponse.get("masHospitaList") != null) {
					masHospitaList = (List) mapResponse.get("masHospitaList");
					hospitalName = masHospitaList.get(0).getHospitalName();
				}

				String colCode = "";
				if (request.getParameter("colCode") != null
						&& !(request.getParameter("colCode").equals(""))) {
					colCode = request.getParameter("colCode");
				}
				String colName = "";
				if (request.getParameter("colName") != null
						&& !(request.getParameter("colName").equals(""))) {
					colName = request.getParameter("colName");
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
				System.out.println("searchRadio---" + searchRadio);
				if (searchRadio == 1) {

					if (!searchField.equals("")) {
						qry = "where "+colCode+"='"+searchField+"'";
					} else {
						qry = "";
					}
				} else if (searchRadio == 2) {
					if (!searchField.equals("")) {
						qry = "where upper(" + colName + ") like upper('%"
								+ searchField + "%')";
					} else {
						qry = "";
					}
				} else {
					qry = "";
				}

				String jasper = null;
				if (request.getParameter(JASPER_FILE_NAME) != null) {
					jasper = request.getParameter(JASPER_FILE_NAME);
				}
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("qry", qry);
				parameters.put("hospitalName", hospitalName);
				parameters.put("hospitalId", hospitalId);
				
				String userHome = getServletContext().getRealPath("");	         
		        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
		        parameters.put("path", imagePath);
				
				parameters.put("SUBREPORT_DIR",
						getServletContext().getRealPath("/reports/"));

				Map<String, Object> connectionMap = hospitalDetailsMasterHandlerService.getConnection();

				HMSUtil.generateReport(jasper, parameters,
						(Connection) connectionMap.get("conn"), response,
						getServletContext());

				return null;
			}
			
			
			// -------------------------------------------------BED
			// MASTER-----------------------------------------------------

			public ModelAndView showOtJsp(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				session = request.getSession(true);
				map = hospitalDetailsMasterHandlerService.showOtJsp();
				jsp = "otTable";
				jsp += ".jsp";
				title = "Ot";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView searchOt(HttpServletRequest request,
					HttpServletResponse response) throws ServletRequestBindingException {
				Map<String, Object> map = new HashMap<String, Object>();
				String bedNumber = null;

				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					bedNumber = request.getParameter(SEARCH_NAME);
				}

				map = hospitalDetailsMasterHandlerService.searchOt(bedNumber);
				jsp = "otTable";
				jsp += ".jsp";
				map.put("search", "search");
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("bedNumber", bedNumber);
				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unchecked")
			public ModelAndView addOt(HttpServletRequest request,
					HttpServletResponse response) {
				HttpSession session=request.getSession();
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> listMap = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();
				MasBed masBed = new MasBed();
				String bedNumber = "";
				int departmentId = 0;
				int bedStatusId = 0;
				String adNo = "";
				String dietType = "";
				Date introductionDate = null;
				Date discardDate = null;
				Date changedDate = null;
				String changedBy = "";
				String changedTime = "";
				String pojoPropertyName = "";
				String pojoPropertyCode = "";
				int userId=(Integer)session.getAttribute(USER_ID);
				int hospitalid=(Integer)session.getAttribute(HOSPITAL_ID);
				int otId=0;
				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					bedNumber = request.getParameter(SEARCH_NAME);
				}
				if (request.getParameter(DEPARTMENT_ID) != null) {
					departmentId = Integer
							.parseInt(request.getParameter(DEPARTMENT_ID));
				}	
				if (request.getParameter(OT_ID) != null) {
					otId = Integer
							.parseInt(request.getParameter(OT_ID));
				}
			
			
				if (request.getParameter(BED_STATUS_ID) != null) {
					bedStatusId = Integer.parseInt(request.getParameter(BED_STATUS_ID));
				}
				if (request.getParameter(AD_NO) != null) {
					adNo = request.getParameter(AD_NO);
				}
				if (request.getParameter(DIET_TYPE) != null) {
					dietType = request.getParameter(DIET_TYPE);
				}
				if (request.getParameter(ATTACHED) != null) {
					masBed.setAttached(request.getParameter(ATTACHED));
				} else {
					masBed.setAttached("n");
				}
				/*
				 * if (request.getParameter(CHANGED_BY) != null) { changedBy =
				 * request.getParameter(CHANGED_BY); }
				 */
				if (request.getParameter(CHANGED_DATE) != null) {
					changedDate = HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(CHANGED_DATE));
				}
				if (request.getParameter(CHANGED_TIME) != null) {
					changedTime = request.getParameter(CHANGED_TIME);
				}
				if (request.getParameter(INTRODUCTION_DATE) != null) {
					introductionDate = HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(INTRODUCTION_DATE));
				}
				if (request.getParameter(DISCARD_DATE) != null) {
					discardDate = HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(DISCARD_DATE));
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

				generalMap.put("name", bedNumber);
				generalMap.put("code", departmentId);
				generalMap.put("currentDate", currentDate);
				generalMap.put("currentTime", currentTime);
				generalMap.put("hospitalid", hospitalid); // added by amit das on 27-09-2016
				generalMap.put("pojoPropertyCode", pojoPropertyCode);
				generalMap.put("pojoPropertyName", pojoPropertyName);
				generalMap.put("pojoName", pojoName);
				generalMap.put(USER_ID, userId);

				listMap = hospitalDetailsMasterHandlerService
						.checkForExistingMastersForHospital(generalMap);
				List bedNumberList = new ArrayList();

				if (listMap.get("duplicateGeneralCodeList") != null) {
					bedNumberList = (List) listMap.get("duplicateGeneralCodeList");
				}

				boolean successfullyAdded = false;
				if (bedNumberList.size() == 0) {
					masBed.setBedNo(bedNumber);

					MasDepartment departmentObj = new MasDepartment();
					departmentObj.setId(departmentId);
					masBed.setDepartment(departmentObj);


					MasBedStatus bedStatusObj = new MasBedStatus();
					bedStatusObj.setId(bedStatusId);
					masBed.setBedStatus(bedStatusObj);

					masBed.setAdNo(adNo);
					masBed.setDietType(dietType);
					masBed.setIntroductionDate(introductionDate);
					masBed.setDiscardDate(discardDate);
					masBed.setStatus("y");
					masBed.setBedType("P");
					masBed.setFlag("OT");
					
					Users users=new Users();
					users.setId(userId);
					masBed.setLastChgBy(users);
					MasHospital hospital=new MasHospital();
					hospital.setId(hospitalid);
					masBed.setHospital(hospital);
					masBed.setLastChgDate(changedDate);
					masBed.setLastChgTime(changedTime);
					successfullyAdded = hospitalDetailsMasterHandlerService
							.addOt(masBed,otId);
					if (successfullyAdded == true) {
						message = "Record Added Successfully !!";
					} else {
						message = "Try Again !!";
					}

				} else if (bedNumberList.size() != 0) {
					message = "Same Table Number for selected Ward already exists.";
				}
				try {
					map = hospitalDetailsMasterHandlerService.showOtJsp();
				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "otTable";
				title = "Add Ot";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView editOt(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();
				MasBed masBed = new MasBed();
				String bedNumber = "";
				int bedId = 0;
				int departmentId = 0;
				int bedStatusId = 0;
				String adNo = "";
				String dietType = "";
				String attached = "";
				Date introductionDate = null;
				Date discardDate = null;
				String changedBy = "";
				String changedTime = "";
				Date changedDate = new Date();
				String code = "";
				String name = "";
				String jspName = "";
				String pojoPropertyName = "";
				String pojoPropertyCode = "";
				session = request.getSession(true);
				int userId=(Integer)session.getAttribute(USER_ID);
int otId=0;
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					bedId = Integer.parseInt(request.getParameter(COMMON_ID));
				}
				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					bedNumber = request.getParameter(SEARCH_NAME);
				}
				if (request.getParameter(DEPARTMENT_ID) != "") {
					departmentId = Integer
							.parseInt(request.getParameter(DEPARTMENT_ID));
				}
				if (request.getParameter(OT_ID) != null) {
					otId = Integer
							.parseInt(request.getParameter(OT_ID));
				}
				if (request.getParameter(BED_STATUS_ID) != "") {
					bedStatusId = Integer.parseInt(request.getParameter(BED_STATUS_ID));
				}
			
				if (request.getParameter(AD_NO) != null) {
					adNo = request.getParameter(AD_NO);
				}
				if (request.getParameter(DIET_TYPE) != null) {
					dietType = request.getParameter(DIET_TYPE);
				}

				if (request.getParameter(ATTACHED) != null) {
					masBed.setAttached(request.getParameter(ATTACHED));
				} else {
					masBed.setAttached("n");
				}

				if (request.getParameter(INTRODUCTION_DATE) != null) {
					introductionDate = HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(INTRODUCTION_DATE));
				}
				if (request.getParameter(DISCARD_DATE) != null) {
					discardDate = HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(DISCARD_DATE));
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
				generalMap.put("id", bedId);
				generalMap.put("bedNumber", bedNumber);
				generalMap.put("departmentId", departmentId);
				generalMap.put("bedStatusId", bedStatusId);
				generalMap.put("adNo", adNo);
				generalMap.put("dietType", dietType);
				generalMap.put("attached", attached);
				generalMap.put("introductionDate", introductionDate);
				generalMap.put("discardDate", discardDate);
				generalMap.put("changedBy", changedBy);
				generalMap.put("changedDate", changedDate);
				generalMap.put("currentTime", changedTime);
				generalMap.put("otId", otId);
				generalMap.put(USER_ID, userId);

				boolean dataUpdated = false;
				dataUpdated = hospitalDetailsMasterHandlerService.editOtToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Record Updated Successfully !!";
				} else {
					message = "Record Cant Be Updated !!";
				}
				url = "/hms/hms/hospital?method=showOtJsp";
				try {
					map = hospitalDetailsMasterHandlerService.showOtJsp();
				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "otTable";
				title = "Add Ot";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView deleteOt(HttpServletRequest request,
					HttpServletResponse response) {
				HttpSession session=request.getSession();

				Map<String, Object> map = new HashMap<String, Object>();
				int bedId = 0;
				String message = null;
				String changedBy = "";
				String changedTime = "";
				Date changedDate = null;
				String flag = "";
				int userId=(Integer)session.getAttribute(USER_ID);

				if (request.getParameter("flag") != null) {
					flag = request.getParameter("flag");
					generalMap.put("flag", flag);
				}
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					bedId = Integer.parseInt(request.getParameter(COMMON_ID));
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
				generalMap.put(USER_ID, userId);

				boolean dataDeleted = false;
				dataDeleted = hospitalDetailsMasterHandlerService.deleteOt(bedId,
						generalMap);
				if (dataDeleted == true) {
					message = "Record is InActivated successfully !!";
				}

				else {
					message = "Record is Activated successfully !!";
				}
				url = "/hms/hms/hospital?method=showOtJsp";
				try {
					map = hospitalDetailsMasterHandlerService.showOtJsp();
				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "otTable";
				title = "delete Ot";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}
			
			public ModelAndView generateReportForGeneralMastersItem(HttpServletRequest request, HttpServletResponse response)
			{
				HttpSession session = request.getSession();
				Map<String, Object> mapResponse = new HashMap<String, Object>();
				Map<String, Object> mapForDs = new HashMap<String, Object>();
				List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
				int hospitalId = 0;
				String hospitalName = "";
				String qry = "";
				String searchField = "";
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					mapForDs.put("hospitalId", hospitalId);
					mapResponse = hospitalDetailsMasterHandlerService.getHospitalName(mapForDs);
				}
				if (mapResponse.get("masHospitaList") != null) {
					masHospitaList = (List) mapResponse.get("masHospitaList");
					hospitalName = masHospitaList.get(0).getHospitalName();
				}

				String colCode = "";
				if (request.getParameter("colCode") != null
						&& !(request.getParameter("colCode").equals(""))) {
					colCode = request.getParameter("colCode");
				}
				String colName = "";
				if (request.getParameter("colName") != null
						&& !(request.getParameter("colName").equals(""))) {
					colName = request.getParameter("colName");
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
				System.out.println("searchRadio---" + searchRadio);
				if (searchRadio == 1) {

					if (!searchField.equals("")) {
						qry = "and  "+colCode+"='"+searchField+"'";
					} else {
						qry = "";
					}
				} else if (searchRadio == 2) {
					if (!searchField.equals("")) {
						qry = "and upper(" + colName + ") like upper('%"
								+ searchField + "%')";
					} else {
						qry = "";
					}
				} else {
					qry = "";
				}

				if(request.getParameter("prescribedFromR")!=null)
				{
					if (!request.getParameter("prescribedFromR").equals("")) {
						qry = " and PRESCRIBED_FROM='"+request.getParameter("prescribedFromR")+"'";
					} 
					
				}
			
				String jasper = null;
				if (request.getParameter(JASPER_FILE_NAME) != null) {
					jasper = request.getParameter(JASPER_FILE_NAME);
				}
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("qry", qry);
				
				System.out.println("jasper="+jasper);
				System.out.println("qry="+qry);
				parameters.put("hospitalName", hospitalName);
				parameters.put("hospitalId", hospitalId);
				
				String userHome = getServletContext().getRealPath("");	         
		        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
		        parameters.put("path", imagePath);
				
				parameters.put("SUBREPORT_DIR",
						getServletContext().getRealPath("/reports/"));

				Map<String, Object> connectionMap = hospitalDetailsMasterHandlerService.getConnection();

				HMSUtil.generateReport(jasper, parameters,
						(Connection) connectionMap.get("conn"), response,
						getServletContext());

				return null;
			}
			
			 public ModelAndView generateReportForGeneralMastersPatientFamilyHistory(HttpServletRequest request, HttpServletResponse response)
				{
					HttpSession session = request.getSession();
					Map<String, Object> mapResponse = new HashMap<String, Object>();
					Map<String, Object> mapForDs = new HashMap<String, Object>();
					List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
					int hospitalId = 0;
					String hospitalName = "";
					String qry = "";
					String searchField = "";
					if (session.getAttribute("hospitalId") != null) {
						hospitalId = (Integer) session.getAttribute("hospitalId");
						mapForDs.put("hospitalId", hospitalId);
						mapResponse = hospitalDetailsMasterHandlerService.getHospitalName(mapForDs);
					}
					if (mapResponse.get("masHospitaList") != null) {
						masHospitaList = (List) mapResponse.get("masHospitaList");
						hospitalName = masHospitaList.get(0).getHospitalName();
					}

					String colCode = "";
					if (request.getParameter("colCode") != null
							&& !(request.getParameter("colCode").equals(""))) {
						colCode = request.getParameter("colCode");
					}
					String colName = "";
					if (request.getParameter("colName") != null
							&& !(request.getParameter("colName").equals(""))) {
						colName = request.getParameter("colName");
					}
					int searchRadio = 0;
					String templateCode=""; 
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
						if (request.getParameter("templateCode") != null
								&& !(request.getParameter("templateCode").equals(""))) {
							templateCode =request.getParameter("templateCode");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("searchRadio---" + searchRadio);
				
					if (searchRadio == 1) {

						if (!searchField.equals("")) {
							qry = "where "+colCode+"='"+searchField+"'and template_code='"+templateCode+"'";
						} else {
							qry = "where template_code='"+templateCode+"'";
						}
					} else if (searchRadio == 2) {
						if (!searchField.equals("")) {
							qry = "where upper(" + colName + ") like upper('%"
									+ searchField + "%') and template_code='"+templateCode+"'";
						} else {
							qry = "where template_code='"+templateCode+"'";
						}
					} else {
						qry = "where template_code='"+templateCode+"'";
					}
System.out.println("qry-----"+qry);
					String jasper = null;
					if (request.getParameter(JASPER_FILE_NAME) != null) {
						jasper = request.getParameter(JASPER_FILE_NAME);
					}
					Map<String, Object> parameters = new HashMap<String, Object>();
					parameters.put("qry", qry);
					parameters.put("hospitalName", hospitalName);
					parameters.put("hospitalId", hospitalId);
					
					String userHome = getServletContext().getRealPath("");	         
			        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
			        parameters.put("path", imagePath);
					
					parameters.put("SUBREPORT_DIR",
							getServletContext().getRealPath("/reports/"));

					Map<String, Object> connectionMap = hospitalDetailsMasterHandlerService.getConnection();

					HMSUtil.generateReport(jasper, parameters,
							(Connection) connectionMap.get("conn"), response,
							getServletContext());

					return null;
				}
	public HospitalDetailsMasterHandlerService getHospitalDetailsMasterHandlerService() {
		return hospitalDetailsMasterHandlerService;
	}

	public void setHospitalDetailsMasterHandlerService(
			HospitalDetailsMasterHandlerService hospitalDetailsMasterHandlerService) {
		this.hospitalDetailsMasterHandlerService = hospitalDetailsMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
	
	

}