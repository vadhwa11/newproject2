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
import static jkt.hms.util.RequestConstants.WORK_CATEGORY;
import static jkt.hms.util.RequestConstants.WORK_TYPE_JSP;

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
import jkt.hms.masters.business.MasWorkType;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;
import jkt.hms.workservices.handler.WorkTypeHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class WorkTypeController extends MultiActionController {
	private WorkTypeHandlerService workTypeHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;

	/**
	 * This method initialize the map with the data base that will be displayed
	 * in the table when the page loads.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showWorkTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {

		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map = workTypeHandlerService.showWorkTypeJsp();
		jsp = WORK_TYPE_JSP;
		jsp += ".jsp";
		title = "Work Type";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * This method returns the map which contains the search result based on the
	 * given input.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return
	 * @throws ServletRequestBindingException
	 */
	public ModelAndView searchWorkType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String workTypeCode = null;
		String workTypeName = null;
		String searchField = null;
		String jsp = "";
		String title = "";
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			workTypeCode = request.getParameter(CODE);
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
			workTypeCode = searchField;
			workTypeName = null;
		} else {
			workTypeCode = null;
			workTypeName = searchField;
		}
		map = workTypeHandlerService.searchWorkType(workTypeCode, workTypeName);
		jsp = WORK_TYPE_JSP;
		jsp += ".jsp";
		title = "Work Type";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		// map.put("workTypeCode", workTypeCode);
		// map.put("workTypeName", workTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * This method gets the values that received from the from the form and add
	 * them into the data base.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView addWorkType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasWorkType masWorkType = new MasWorkType();
		int workCategoryId = 0;
		String changedBy = "";
		String code = "";
		String name = "";
		String minLimit = "";
		String maxLimit = "";
		String pojoPropertyCode = "";
		String jsp = "";
		String title = "";
		String msg = " ";
		String pojoName = "";
		String pojoPropertyName = "";
		String currentTime = "";

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
		if (request.getParameter(WORK_CATEGORY) != null) {
			workCategoryId = Integer.parseInt(request
					.getParameter(WORK_CATEGORY));
		}
		if (request.getParameter(MIN_LIMIT) != null
				&& !(request.getParameter(MIN_LIMIT).equals(""))) {
			minLimit = request.getParameter(MIN_LIMIT);
		}
		if (request.getParameter(MAX_LIMIT) != null
				&& !(request.getParameter(MAX_LIMIT).equals(""))) {
			maxLimit = request.getParameter(MAX_LIMIT);
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

		List workTypeCodeList = new ArrayList();
		List workTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			workTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			workTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		if ((workTypeCodeList.size() == 0 || workTypeCodeList == null)
				&& (workTypeNameList.size() == 0 || workTypeNameList == null)) {
			MasWorkCategory workCategory = new MasWorkCategory();
			masWorkType.setWorkTypeCode(code);
			masWorkType.setWorkTypeName(name);
			workCategory.setId(workCategoryId);
			masWorkType.setWorkCategory(workCategory);
			if (minLimit != null && !minLimit.equalsIgnoreCase(""))
				masWorkType.setMinLimit(new BigDecimal(minLimit));
			if (maxLimit != null && !maxLimit.equalsIgnoreCase(""))
				masWorkType.setMaxLimit(new BigDecimal(maxLimit));
			masWorkType.setStatus("y");
			masWorkType.setLastChgBy(changedBy);
			masWorkType.setLastChgDate(currentDate);
			masWorkType.setLastChgTime(currentTime);
			msg = workTypeHandlerService.addWorkType(masWorkType);

			if (msg.equalsIgnoreCase("data updated")) {
				msg = "Record Added Successfully !!";
			} else {
				msg += " Try Again !!";
			}
		}

		else if ((workTypeCodeList.size() != 0 || workTypeCodeList != null)
				|| (workTypeNameList.size() != 0) || workTypeNameList != null) {

			if ((workTypeCodeList.size() != 0 || workTypeCodeList != null)
					&& (workTypeNameList.size() == 0 || workTypeNameList == null)) {

				msg = "Work Type Code  already exists.";
			} else if ((workTypeNameList.size() != 0 || workTypeNameList != null)
					&& (workTypeCodeList.size() == 0 || workTypeCodeList == null)) {

				msg = "Work Type Name already exists.";
			} else if ((workTypeCodeList.size() != 0 || workTypeCodeList != null)
					&& (workTypeNameList.size() != 0 || workTypeNameList != null)) {

				msg = "Work Type Code and Work Type Name already exist.";
			}
		}
		try {
			map = workTypeHandlerService.showWorkTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = WORK_TYPE_JSP;
		title = "Work Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", msg);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * This mthod is to update the recored in the data base.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView editWorkType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		String pojoName = "";
		String pojoPropertyName = "";
		HttpSession session = null;
		session = request.getSession();
		String workTypeCode = "";
		String workTypeName = "";
		String maxLimit = "";
		String minLimit = "";
		int workTypeId = 0;
		String changedBy = "";
		int workCategoryId = 0;
		Date changedDate = null;
		String changedTime = "";
		workTypeCode = (String) session.getAttribute("workTypeCode");
		workTypeName = (String) session.getAttribute("workTypeName");
		minLimit = (String) session.getAttribute("minLimit");
		maxLimit = (String) session.getAttribute("maxLimit");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			workTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			workTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			workTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(WORK_CATEGORY) != null) {
			workCategoryId = Integer.parseInt(request
					.getParameter(WORK_CATEGORY));
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

		generalMap.put("id", workTypeId);
		generalMap.put("workTypeCode", workTypeCode);
		generalMap.put("name", workTypeName);
		generalMap.put("workCategoryId", workCategoryId);
		generalMap.put("minLimit", minLimit);
		generalMap.put("maxLimit", maxLimit);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingWorkTypeNameList = (List) listMap
				.get("duplicateMastersList");

		String msg = "";
		if (existingWorkTypeNameList.size() == 0) {

			msg = workTypeHandlerService.editWorkTypeToDatabase(generalMap);

			if (msg.equalsIgnoreCase("data updated")) {
				msg = "Data updated Successfully !!";
			} else {
				msg += " Data Cant be updated !!";
			}
		} else if (existingWorkTypeNameList.size() > 0) {

			msg = "Name already exists.";
		}
		try {
			map = workTypeHandlerService.showWorkTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = WORK_TYPE_JSP;
		title = "Edit Department type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", msg);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * This method is to in-activate and activate a record.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView deleteWorkType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int workTypeId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		String jsp = "";
		String title = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			workTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = workTypeHandlerService.deleteWorkType(workTypeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = workTypeHandlerService.showWorkTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = WORK_TYPE_JSP;
		title = "Delete Work Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// ---------------------------------------------------------------------------------------------
	/**
	 * Gets the WorkTypeHandlerServices
	 * 
	 */
	public WorkTypeHandlerService getWorkTypeHandlerService() {
		return workTypeHandlerService;
	}

	/**
	 * 
	 * @param workTypeHandlerService
	 */
	public void setWorkTypeHandlerService(
			WorkTypeHandlerService workTypeHandlerService) {
		this.workTypeHandlerService = workTypeHandlerService;
	}

	/**
	 * Gets the CommonMasterHandlerServices.
	 * 
	 * @return commonMasterHandlerService
	 */
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	/**
	 * Sets the CommonMasterHandlerService
	 * 
	 * @param commonMasterHandlerService
	 */
	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
