package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DATE_OF_COSTING_RECEIVED;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DATE;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAILS_UPDATE_JSP;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.MINOR_WORK_ESTIMATED_COST;
import static jkt.hms.util.RequestConstants.MINOR_WORK_FINENTIAL_YEAR;
import static jkt.hms.util.RequestConstants.MINOR_WORK_NO;
import static jkt.hms.util.RequestConstants.MINOR_WORK_REMARK;
import static jkt.hms.util.RequestConstants.MINOR_WORK_TIME;
import static jkt.hms.util.RequestConstants.WORK_CATEGORY;
import static jkt.hms.util.RequestConstants.WORK_TYPE;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;
import jkt.hms.workservices.handler.MinorWorkDetailSearchHandlerService;
import jkt.hms.workservices.handler.MinorWorkDetailsUpdateHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MinorWorkDetailsUpdateController extends MultiActionController {

	private MinorWorkDetailsUpdateHandlerService minorWorkDetailsUpdateHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;
	private int minorWorkDetailId;
	MinorWorkDetailSearchHandlerService minorWorkDetailSearchHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showMinorWorkDetailsUpdateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		setMinorWorkDetailId(Integer.parseInt(request
				.getParameter("minorWorkDetailId")));
		int Id = getMinorWorkDetailId();
		Map map = new HashMap();
		map = minorWorkDetailsUpdateHandlerService
				.showMinorWorkDetailsUpdateJsp(Id);
		jsp = MINOR_WORK_DETAILS_UPDATE_JSP;
		jsp += ".jsp";
		title = "Minor Work Detail Update";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editMinorWorkDetailsUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		String message = " ";
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String financialYear = "";
		String workCategory = "";
		String workType = "";
		String minorWorkNo = "";
		String minorWorkDate = "";
		String dateOfCostingReceived = "";
		String minorWorkTime = "";
		String detailsOfWork = "";
		String estimatedCost = "";
		String remark = "";
		String pojoPropertyName = "";
		String pojoName = "";

		if (request.getParameter(MINOR_WORK_FINENTIAL_YEAR) != null
				&& !(request.getParameter(MINOR_WORK_FINENTIAL_YEAR).equals(""))) {
			financialYear = request.getParameter(MINOR_WORK_FINENTIAL_YEAR);
		}
		if (request.getParameter(WORK_CATEGORY) != null
				&& !(request.getParameter(WORK_CATEGORY).equals(""))) {
			workCategory = request.getParameter(WORK_CATEGORY);
		}
		if (request.getParameter(WORK_TYPE) != null
				&& !(request.getParameter(WORK_TYPE).equals(""))) {
			workType = request.getParameter(WORK_TYPE);
		}

		if (request.getParameter(MINOR_WORK_NO) != null
				&& !(request.getParameter(MINOR_WORK_NO).equals(""))) {
			minorWorkNo = request.getParameter(MINOR_WORK_NO);
		}
		if (request.getParameter(MINOR_WORK_DATE) != null
				&& !(request.getParameter(MINOR_WORK_DATE).equals(""))) {
			minorWorkDate = request.getParameter(MINOR_WORK_DATE);
		}
		if (request.getParameter(DATE_OF_COSTING_RECEIVED) != null
				&& !(request.getParameter(DATE_OF_COSTING_RECEIVED).equals(""))) {
			dateOfCostingReceived = request
					.getParameter(DATE_OF_COSTING_RECEIVED);
		}
		if (request.getParameter(MINOR_WORK_TIME) != null
				&& !(request.getParameter(MINOR_WORK_TIME).equals(""))) {
			minorWorkTime = request.getParameter(MINOR_WORK_TIME);
		}
		if (request.getParameter(MINOR_WORK_DETAIL) != null
				&& !(request.getParameter(MINOR_WORK_DETAIL).equals(""))) {
			detailsOfWork = request.getParameter(MINOR_WORK_DETAIL);
		}
		if (request.getParameter(MINOR_WORK_ESTIMATED_COST) != null
				&& !(request.getParameter(MINOR_WORK_ESTIMATED_COST).equals(""))) {
			estimatedCost = request.getParameter(MINOR_WORK_ESTIMATED_COST);
		}
		if (request.getParameter(MINOR_WORK_REMARK) != null
				&& !(request.getParameter(MINOR_WORK_REMARK).equals(""))) {
			remark = request.getParameter(MINOR_WORK_REMARK);
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

		generalMap.put("id", minorWorkDetailId);
		generalMap.put("financialYear", financialYear);
		generalMap.put("workCategory", workCategory);
		generalMap.put("dateOfCostingReceived", dateOfCostingReceived);
		generalMap.put("workType", workType);
		generalMap.put("minorWorkNo", minorWorkNo);
		generalMap.put("minorWorkDate", minorWorkDate);
		generalMap.put("minorWorkTime", minorWorkTime);
		generalMap.put("detailsOfWork", detailsOfWork);
		generalMap.put("estimatedCost", estimatedCost);
		generalMap.put("remark", remark);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoName", pojoName);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("title", title);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingMinorWorkDetailNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;

		dataUpdated = minorWorkDetailsUpdateHandlerService
				.editMinorWorkDetailsUpdateToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}

		map = minorWorkDetailSearchHandlerService
				.showMinorWorkDetailSearchJsp();
		jsp = MINOR_WORK_DETAIL_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteMinorWorkDetailsUpdate(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int minorWorkDetailsUpdateId = 0;
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
			minorWorkDetailsUpdateId = Integer.parseInt(request
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
		dataDeleted = minorWorkDetailsUpdateHandlerService
				.deleteMinorWorkDetailsUpdate(minorWorkDetailsUpdateId,
						generalMap);
		if (dataDeleted == true) {
			message = "Record is canceled successfully !!";
		} else {
			message = "Record could not be canceled successfully !!";
		}

		try {
			map = minorWorkDetailSearchHandlerService
					.showMinorWorkDetailSearchJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MINOR_WORK_DETAIL_SEARCH_JSP;
		title = "Minor Work Details Search";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// ---------------------------------------------------------------------------------------------
	public MinorWorkDetailsUpdateHandlerService getMinorWorkDetailsUpdateHandlerService() {
		return minorWorkDetailsUpdateHandlerService;
	}

	public void setMinorWorkDetailsUpdateHandlerService(
			MinorWorkDetailsUpdateHandlerService minorWorkDetailsUpdateHandlerService) {
		this.minorWorkDetailsUpdateHandlerService = minorWorkDetailsUpdateHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public Integer getMinorWorkDetailId() {
		return minorWorkDetailId;
	}

	public void setMinorWorkDetailId(Integer minorWorkDetailId) {
		this.minorWorkDetailId = minorWorkDetailId;
	}

	public MinorWorkDetailSearchHandlerService getMinorWorkDetailSearchHandlerService() {
		return minorWorkDetailSearchHandlerService;
	}

	public void setMinorWorkDetailSearchHandlerService(
			MinorWorkDetailSearchHandlerService minorWorkDetailSearchHandlerService) {
		this.minorWorkDetailSearchHandlerService = minorWorkDetailSearchHandlerService;
	}

}
