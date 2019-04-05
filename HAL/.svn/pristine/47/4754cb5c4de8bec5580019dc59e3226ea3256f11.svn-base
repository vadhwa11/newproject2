package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.MAX_LIMIT;
import static jkt.hms.util.RequestConstants.MIN_LIMIT;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.WORK_CATEGORY_JSP;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasWorkCategory;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;
import jkt.hms.workservices.handler.WorkCategoryHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class WorkCategoryController extends MultiActionController {
	WorkCategoryHandlerService workCategoryHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showWorkCategoryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = workCategoryHandlerService.showWorkCategoryJsp();
		jsp += WORK_CATEGORY_JSP;
		jsp += ".jsp";
		title = "WorkCategory";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchWorkCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String workCategoryCode = null;
		String workCategoryName = null;
		String searchField = null;
		String jsp = "";
		String title = "";

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			workCategoryCode = request.getParameter(CODE);
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
			workCategoryCode = searchField;
			workCategoryName = null;
		} else {
			workCategoryCode = null;
			workCategoryName = searchField;
		}

		map = workCategoryHandlerService.searchWorkCategory(workCategoryCode,
				workCategoryName);
		jsp = WORK_CATEGORY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("workCategoryCode", workCategoryCode);
		map.put("workCategoryName", workCategoryName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addWorkCategory(HttpServletRequest request,
			HttpServletResponse response) {
		String code = "";
		String name = "";
		String minLimit = "";
		String maxLimit = "";

		String pojoPropertyCode = "";
		String jsp = "";
		String title = "";
		String message = " ";
		String pojoName = "";
		String pojoPropertyName = "";
		String currentTime = "";

		Map<String, Object> map = new HashMap<String, Object>();
		MasWorkCategory masWorkCategory = new MasWorkCategory();

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
		if (request.getParameter(MIN_LIMIT) != null) {
			minLimit = request.getParameter(MIN_LIMIT);
		}
		if (request.getParameter(MAX_LIMIT) != null) {
			maxLimit = request.getParameter(MAX_LIMIT);
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

		generalMap.put("minLimit", minLimit);
		generalMap.put("maxLimit", maxLimit);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List workCategoryCodeList = new ArrayList();
		List workCategoryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			workCategoryCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			workCategoryNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((workCategoryCodeList.size() == 0 || workCategoryCodeList == null)
				&& (workCategoryNameList.size() == 0 || workCategoryNameList == null)) {
			masWorkCategory.setWorkCategoryCode(code);
			masWorkCategory.setWorkCategoryName(name);
			masWorkCategory.setMinLimit(new BigDecimal(minLimit));
			if (maxLimit != null && !maxLimit.equalsIgnoreCase(""))
				masWorkCategory.setMaxLimit(new BigDecimal(maxLimit));
			masWorkCategory.setStatus("y");
			masWorkCategory.setLastChgBy(changedBy);
			masWorkCategory.setLastChgDate(currentDate);
			masWorkCategory.setLastChgTime(currentTime);
			successfullyAdded = workCategoryHandlerService
					.addWorkCategory(masWorkCategory);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((workCategoryCodeList.size() != 0 || workCategoryCodeList != null)
				|| (workCategoryNameList.size() != 0)
				|| workCategoryNameList != null) {

			if ((workCategoryCodeList.size() != 0 || workCategoryCodeList != null)
					&& (workCategoryNameList.size() == 0 || workCategoryNameList == null)) {

				message = "WorkCategory Code  already exists.";
			} else if ((workCategoryNameList.size() != 0 || workCategoryNameList != null)
					&& (workCategoryCodeList.size() == 0 || workCategoryCodeList == null)) {

				message = "WorkCategory Name already exists.";
			} else if ((workCategoryCodeList.size() != 0 || workCategoryCodeList != null)
					&& (workCategoryNameList.size() != 0 || workCategoryNameList != null)) {

				message = "Work Category Code and Work Category Name already exist.";
			}
		}

		try {
			map = workCategoryHandlerService.showWorkCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = WORK_CATEGORY_JSP;
		title = "Work Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editWorkCategory(HttpServletRequest request,
			HttpServletResponse response) {

		String minLimit = "";
		String maxLimit = "";

		String jsp = "";
		String title = "";
		String message = " ";

		String pojoName = "";
		String pojoPropertyName = "";

		HttpSession session = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String workCategoryCode = "";
		String workCategoryName = "";
		int workCategoryId = 0;
		String changedBy = "";

		Date changedDate = null;
		String changedTime = "";

		workCategoryCode = (String) session.getAttribute("workCategoryCode");
		workCategoryName = (String) session.getAttribute("workCategoryName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			workCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			workCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			workCategoryName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(MIN_LIMIT) != null
				&& !(request.getParameter(MIN_LIMIT).equals(""))) {
			minLimit = request.getParameter(MIN_LIMIT);
		}
		if (request.getParameter(MAX_LIMIT) != null
				&& !(request.getParameter(MAX_LIMIT).equals(""))) {
			maxLimit = request.getParameter(MAX_LIMIT);
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

		generalMap.put("id", workCategoryId);
		generalMap.put("workCategoryCode", workCategoryCode);
		generalMap.put("name", workCategoryName);
		generalMap.put("minLimit", minLimit);
		generalMap.put("maxLimit", maxLimit);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyRemark", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingWorkCategoryNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingWorkCategoryNameList.size() == 0) {

			dataUpdated = workCategoryHandlerService
					.editWorkCategoryToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingWorkCategoryNameList.size() > 0) {

			message = "Name already exists.";
		}

		try {
			map = workCategoryHandlerService.showWorkCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = WORK_CATEGORY_JSP;
		title = "Edit Department type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteWorkCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int workCategoryId = 0;
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
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			workCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = workCategoryHandlerService.deleteWorkCategory(
				workCategoryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}

		try {
			map = workCategoryHandlerService.showWorkCategoryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = WORK_CATEGORY_JSP;
		title = "Delete Work Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// ---------------------------------------------------------------------------------------------
	public WorkCategoryHandlerService getWorkCategoryHandlerService() {
		return workCategoryHandlerService;
	}

	public void setWorkCategoryHandlerService(
			WorkCategoryHandlerService workCategoryHandlerService) {
		this.workCategoryHandlerService = workCategoryHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
