package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL_SEARCH_FOR_COMPLETION_WORK_JSP;
import static jkt.hms.util.RequestConstants.MINOR_WORK_NO;
import static jkt.hms.util.RequestConstants.MINOR_WORK_PROPOSAL_DEPARTMENT;
import static jkt.hms.util.RequestConstants.MINOR_WORK_TYPE_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.WORK_CATEGORY;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.workservices.handler.MinorWorkDetailSearchForCompletionWorkHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MinorWorkDetailSearchForCompletionWorkController extends
		MultiActionController {
	MinorWorkDetailSearchForCompletionWorkHandlerService minorWorkDetailSearchForCompletionWorkHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showMinorWorkDetailSearchForCompletionWorkJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = minorWorkDetailSearchForCompletionWorkHandlerService
				.showMinorWorkDetailSearchForCompletionWorkJsp();
		jsp += MINOR_WORK_DETAIL_SEARCH_FOR_COMPLETION_WORK_JSP;
		jsp += ".jsp";
		title = "Minor Work Detail Search For Completion Work";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMinorWorkDetailSearchForCompletionWork(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		AgendaDTO minorWorkDetailSearchForCompletionWorkDTO = new AgendaDTO();
		if (request.getParameter(TO_DATE) != null
				&& !request.getParameter(TO_DATE).equalsIgnoreCase("")) {
			minorWorkDetailSearchForCompletionWorkDTO.setToDate(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(FROM_DATE) != null
				&& !request.getParameter(FROM_DATE).equalsIgnoreCase("")) {
			minorWorkDetailSearchForCompletionWorkDTO.setFromDate(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(MINOR_WORK_TYPE_ID) != null
				&& !request.getParameter(MINOR_WORK_TYPE_ID).equalsIgnoreCase(
						"0")) {
			minorWorkDetailSearchForCompletionWorkDTO.setWorkTypeName(request
					.getParameter(MINOR_WORK_TYPE_ID));
		}
		if (request.getParameter(MINOR_WORK_NO) != null
				&& !request.getParameter(MINOR_WORK_NO).equalsIgnoreCase("")) {
			minorWorkDetailSearchForCompletionWorkDTO.setMinorWorkNo(request
					.getParameter(MINOR_WORK_NO));
		}
		if (request.getParameter(WORK_CATEGORY) != null
				&& !request.getParameter(WORK_CATEGORY).equalsIgnoreCase("")) {
			minorWorkDetailSearchForCompletionWorkDTO
					.setWorkCategoryName(request.getParameter(WORK_CATEGORY));
		}

		if (!request.getParameter(MINOR_WORK_PROPOSAL_DEPARTMENT)
				.equalsIgnoreCase("0")
				&& request.getParameter(MINOR_WORK_PROPOSAL_DEPARTMENT) != null) {
			minorWorkDetailSearchForCompletionWorkDTO.setDepartment(request
					.getParameter(MINOR_WORK_PROPOSAL_DEPARTMENT));
		}
		if (!request.getParameter(MINOR_WORK_DETAIL).equalsIgnoreCase("0")
				&& request.getParameter(MINOR_WORK_DETAIL) != null) {
			minorWorkDetailSearchForCompletionWorkDTO.setWorkDetails(request
					.getParameter(MINOR_WORK_DETAIL));
		}
		map = minorWorkDetailSearchForCompletionWorkHandlerService
				.searchMinorWorkDetailSearchForCompletionWork(minorWorkDetailSearchForCompletionWorkDTO);
		jsp = MINOR_WORK_DETAIL_SEARCH_FOR_COMPLETION_WORK_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public MinorWorkDetailSearchForCompletionWorkHandlerService getMinorWorkDetailSearchForCompletionWorkHandlerService() {
		return minorWorkDetailSearchForCompletionWorkHandlerService;
	}

	public void setMinorWorkDetailSearchForCompletionWorkHandlerService(
			MinorWorkDetailSearchForCompletionWorkHandlerService minorWorkDetailSearchForCompletionWorkHandlerService) {
		this.minorWorkDetailSearchForCompletionWorkHandlerService = minorWorkDetailSearchForCompletionWorkHandlerService;
	}

}