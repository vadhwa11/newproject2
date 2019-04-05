package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL_SEARCH_JSP;
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
import jkt.hms.workservices.handler.MinorWorkDetailSearchHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MinorWorkDetailSearchController extends MultiActionController {
	MinorWorkDetailSearchHandlerService minorWorkDetailSearchHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public ModelAndView showMinorWorkDetailSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		map = minorWorkDetailSearchHandlerService
				.showMinorWorkDetailSearchJsp();
		jsp += MINOR_WORK_DETAIL_SEARCH_JSP;
		jsp += ".jsp";
		title = "Minor Work Detail Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMinorWorkDetailSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		AgendaDTO minorWorkDetailSearchDTO = new AgendaDTO();
		if (!request.getParameter(TO_DATE).equalsIgnoreCase("")
				&& request.getParameter(TO_DATE) != null) {
			minorWorkDetailSearchDTO.setToDate(request.getParameter(TO_DATE));
		}
		if (!request.getParameter(FROM_DATE).equalsIgnoreCase("")
				&& request.getParameter(FROM_DATE) != null) {
			minorWorkDetailSearchDTO.setFromDate(request
					.getParameter(FROM_DATE));
		}
		if (!request.getParameter(MINOR_WORK_TYPE_ID).equalsIgnoreCase("0")
				&& request.getParameter(MINOR_WORK_TYPE_ID) != null) {
			minorWorkDetailSearchDTO.setWorkTypeName(request
					.getParameter(MINOR_WORK_TYPE_ID));
		}
		if (!request.getParameter(MINOR_WORK_NO).equalsIgnoreCase("")
				&& request.getParameter(MINOR_WORK_NO) != null) {
			minorWorkDetailSearchDTO.setMinorWorkNo(request
					.getParameter(MINOR_WORK_NO));
		}
		if (request.getParameter(WORK_CATEGORY) != null) {
			minorWorkDetailSearchDTO.setWorkCategoryName(request
					.getParameter(WORK_CATEGORY));
		}
		if (!request.getParameter(MINOR_WORK_PROPOSAL_DEPARTMENT)
				.equalsIgnoreCase("0")
				&& request.getParameter(MINOR_WORK_PROPOSAL_DEPARTMENT) != null) {
			minorWorkDetailSearchDTO.setDepartment(request
					.getParameter(MINOR_WORK_PROPOSAL_DEPARTMENT));
		}
		if (!request.getParameter(MINOR_WORK_DETAIL).equalsIgnoreCase("0")
				&& request.getParameter(MINOR_WORK_DETAIL) != null) {
			minorWorkDetailSearchDTO.setWorkDetails(request
					.getParameter(MINOR_WORK_DETAIL));
		}
		map = minorWorkDetailSearchHandlerService
				.searchMinorWorkDetailSearch(minorWorkDetailSearchDTO);
		jsp = MINOR_WORK_DETAIL_SEARCH_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public MinorWorkDetailSearchHandlerService getMinorWorkDetailSearchHandlerService() {
		return minorWorkDetailSearchHandlerService;
	}

	public void setMinorWorkDetailSearchHandlerService(
			MinorWorkDetailSearchHandlerService minorWorkDetailSearchHandlerService) {
		this.minorWorkDetailSearchHandlerService = minorWorkDetailSearchHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}