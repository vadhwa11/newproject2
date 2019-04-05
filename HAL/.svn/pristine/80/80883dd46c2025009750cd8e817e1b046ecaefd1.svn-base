package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL_APPROVAL_JSP;
import static jkt.hms.util.RequestConstants.MINOR_WORK_NO;
import static jkt.hms.util.RequestConstants.MINOR_WORK_PROPOSAL_DEPARTMENT;
import static jkt.hms.util.RequestConstants.MINOR_WORK_TYPE_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.WORK_CATEGORY;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.business.MasMinorWorkDetail;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.workservices.handler.MinorWorkDetailsApprovalHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MinorWorkDetailsApprovalController extends MultiActionController {
	MinorWorkDetailsApprovalHandlerService minorWorkDetailsApprovalHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showMinorWorkDetailsApprovalJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = minorWorkDetailsApprovalHandlerService
				.showMinorWorkDetailsApprovalJsp();
		jsp += MINOR_WORK_DETAIL_APPROVAL_JSP;
		jsp += ".jsp";
		title = "Minor Work Detail Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMinorWorkDetailsApproval(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		List<MasMinorWorkDetail> searchList = null;
		AgendaDTO minorWorkDetailsApprovalDTO = new AgendaDTO();
		if (!request.getParameter(TO_DATE).equalsIgnoreCase("")
				&& request.getParameter(TO_DATE) != null) {
			minorWorkDetailsApprovalDTO
					.setToDate(request.getParameter(TO_DATE));
		}
		if (!request.getParameter(FROM_DATE).equalsIgnoreCase("")
				&& request.getParameter(FROM_DATE) != null) {
			minorWorkDetailsApprovalDTO.setFromDate(request
					.getParameter(FROM_DATE));
		}
		if (!request.getParameter(MINOR_WORK_TYPE_ID).equalsIgnoreCase("0")
				&& request.getParameter(MINOR_WORK_TYPE_ID) != null) {
			minorWorkDetailsApprovalDTO.setWorkTypeName(request
					.getParameter(MINOR_WORK_TYPE_ID));
		}
		if (request.getParameter(MINOR_WORK_NO) != null
				&& !request.getParameter(MINOR_WORK_NO).equalsIgnoreCase("")) {
			minorWorkDetailsApprovalDTO.setMinorWorkNo(request
					.getParameter(MINOR_WORK_NO));
		}
		if (request.getParameter(WORK_CATEGORY) != null
				&& !request.getParameter(WORK_CATEGORY).equalsIgnoreCase("0")) {
			minorWorkDetailsApprovalDTO.setWorkCategoryName(request
					.getParameter(WORK_CATEGORY));
		}
		if (!request.getParameter(MINOR_WORK_PROPOSAL_DEPARTMENT)
				.equalsIgnoreCase("0")
				&& request.getParameter(MINOR_WORK_PROPOSAL_DEPARTMENT) != null) {
			minorWorkDetailsApprovalDTO.setDepartment(request
					.getParameter(MINOR_WORK_PROPOSAL_DEPARTMENT));
		}
		if (!request.getParameter(MINOR_WORK_DETAIL).equalsIgnoreCase("0")
				&& request.getParameter(MINOR_WORK_DETAIL) != null) {
			minorWorkDetailsApprovalDTO.setWorkDetails(request
					.getParameter(MINOR_WORK_DETAIL));
		}
		map = minorWorkDetailsApprovalHandlerService
				.searchMinorWorkDetailsApproval(minorWorkDetailsApprovalDTO);
		/*
		 * searchList = (List<MasMinorWorkDetail>)
		 * map.get("searchMinorWorkDetailsApprovalList"); if (searchList == null
		 * || searchList.size() <= 0) { map =
		 * minorWorkDetailsApprovalHandlerService
		 * .showMinorWorkDetailsApprovalJsp(); }
		 */
		jsp = MINOR_WORK_DETAIL_APPROVAL_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public MinorWorkDetailsApprovalHandlerService getMinorWorkDetailsApprovalHandlerService() {
		return minorWorkDetailsApprovalHandlerService;
	}

	public void setMinorWorkDetailsApprovalHandlerService(
			MinorWorkDetailsApprovalHandlerService minorWorkDetailsApprovalHandlerService) {
		this.minorWorkDetailsApprovalHandlerService = minorWorkDetailsApprovalHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}