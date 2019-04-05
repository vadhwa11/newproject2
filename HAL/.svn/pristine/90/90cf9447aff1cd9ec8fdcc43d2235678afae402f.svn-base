package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.ADMIN_NAME;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.COMPLETION_DATE_WORK_SERVICE;
import static jkt.hms.util.RequestConstants.COMPLETION_OF_MINOR_WORK_DETAIL_JSP;
import static jkt.hms.util.RequestConstants.COMPLETION_TIME_WORK_SERVICE;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL_SEARCH_FOR_COMPLETION_WORK_JSP;
import static jkt.hms.util.RequestConstants.MINOR_WORK_REMARK;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;
import jkt.hms.workservices.handler.CompletionOfMinorWorkDetailsHandlerService;
import jkt.hms.workservices.handler.MinorWorkDetailSearchForCompletionWorkHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CompletionOfMinorWorkDetailsController extends
		MultiActionController {

	private CompletionOfMinorWorkDetailsHandlerService completionOfMinorWorkDetailsHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;
	private MinorWorkDetailSearchForCompletionWorkHandlerService minorWorkDetailSearchForCompletionWorkHandlerService = null;
	private int minorWorkDetailId;

	@SuppressWarnings("unchecked")
	public ModelAndView showCompletionOfMinorWorkDetailsJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = null;
		String title = "";
		String completionNumber = "";
		setMinorWorkDetailId(Integer.parseInt(request
				.getParameter("minorWorkDetailId")));
		int Id = getMinorWorkDetailId();
		Map map = new HashMap();
		completionNumber = completionOfMinorWorkDetailsHandlerService
				.generateCompletionNumber("");

		map.put("completionNumber", completionNumber);
		map = completionOfMinorWorkDetailsHandlerService
				.showCompletionOfMinorWorkDetailsJsp(Id);
		jsp = COMPLETION_OF_MINOR_WORK_DETAIL_JSP;
		jsp += ".jsp";
		title = "Approval Of Minor Work Detail";
		map.put("completionNumber", completionNumber);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editCompletionOfMinorWorkDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		String message = " ";
		String completionNumber = "";
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		String adminName = "";
		String completionDate = "";
		String completionTime = "";
		String remark = "";

		String pojoPropertyName = "";
		String pojoName = "";

		if (request.getParameter(ADMIN_NAME) != null
				&& !(request.getParameter(ADMIN_NAME).equals(""))) {
			adminName = request.getParameter(ADMIN_NAME);
		}
		if (request.getParameter(COMPLETION_DATE_WORK_SERVICE) != null
				&& !(request.getParameter(COMPLETION_DATE_WORK_SERVICE)
						.equals(""))) {
			completionDate = request.getParameter(COMPLETION_DATE_WORK_SERVICE);
		}
		if (request.getParameter(COMPLETION_TIME_WORK_SERVICE) != null
				&& !(request.getParameter(COMPLETION_TIME_WORK_SERVICE)
						.equals(""))) {
			completionTime = request.getParameter(COMPLETION_TIME_WORK_SERVICE);
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
		generalMap.put("adminName", adminName);
		generalMap.put("completionDate", completionDate);
		generalMap.put("completionTime", completionTime);
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

		dataUpdated = completionOfMinorWorkDetailsHandlerService
				.editCompletionOfMinorWorkDetailsToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !Please try again!";
		}

		completionNumber = completionOfMinorWorkDetailsHandlerService
				.generateCompletionNumber("");
		map = minorWorkDetailSearchForCompletionWorkHandlerService
				.showMinorWorkDetailSearchForCompletionWorkJsp();
		jsp = MINOR_WORK_DETAIL_SEARCH_FOR_COMPLETION_WORK_JSP;
		jsp += ".jsp";
		map.put("completionNumber", completionNumber);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------------------------------------------------------------------------------------
	public CompletionOfMinorWorkDetailsHandlerService getCompletionOfMinorWorkDetailsHandlerService() {
		return completionOfMinorWorkDetailsHandlerService;
	}

	public void setCompletionOfMinorWorkDetailsHandlerService(
			CompletionOfMinorWorkDetailsHandlerService completionOfMinorWorkDetailsHandlerService) {
		this.completionOfMinorWorkDetailsHandlerService = completionOfMinorWorkDetailsHandlerService;
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

	public MinorWorkDetailSearchForCompletionWorkHandlerService getMinorWorkDetailSearchForCompletionWorkHandlerService() {
		return minorWorkDetailSearchForCompletionWorkHandlerService;
	}

	public void setMinorWorkDetailSearchForCompletionWorkHandlerService(
			MinorWorkDetailSearchForCompletionWorkHandlerService minorWorkDetailSearchForCompletionWorkHandlerService) {
		this.minorWorkDetailSearchForCompletionWorkHandlerService = minorWorkDetailSearchForCompletionWorkHandlerService;
	}
}
