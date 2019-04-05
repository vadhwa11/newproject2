package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DEPARTMENT;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DETAIL;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DETAIL_SEARCH;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_NO;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_TYPE_ID;
import static jkt.hms.util.RequestConstants.MINOR_WORK_TYPE_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.WORK_CATEGORY;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.workservices.handler.MajorWorkDetailSearchHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MajorWorkDetailSearchController extends MultiActionController {
	MajorWorkDetailSearchHandlerService majorWorkDetailSearchHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public ModelAndView showMajorWorkDetailSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		map = majorWorkDetailSearchHandlerService
				.showMajorWorkDetailSearchJsp();
		jsp += MAJOR_WORK_DETAIL_SEARCH;
		jsp += ".jsp";
		title = "Major Work Detail Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMajorWorkDetailSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		MajorWorkDetailSearchDTO majorWorkDetailSearchDTO = new MajorWorkDetailSearchDTO();
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			majorWorkDetailSearchDTO.setToDate(request.getParameter(TO_DATE));
		}
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			majorWorkDetailSearchDTO.setFromDate(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(MINOR_WORK_TYPE_ID) != null
				&& !(request.getParameter(MINOR_WORK_TYPE_ID).equals(""))) {
			majorWorkDetailSearchDTO.setWorkTypeName(request
					.getParameter(MINOR_WORK_TYPE_ID));
		}
		if (request.getParameter(MAJOR_WORK_NO) != null
				&& !(request.getParameter(MAJOR_WORK_NO).equals(""))) {
			majorWorkDetailSearchDTO.setMajorWorkNo(request
					.getParameter(MAJOR_WORK_NO));
		}
		if (request.getParameter(WORK_CATEGORY) != null
				&& !(request.getParameter(WORK_CATEGORY).equals(""))) {

			majorWorkDetailSearchDTO.setWorkCategoryName(request
					.getParameter(WORK_CATEGORY));

		}
		if (request.getParameter(MAJOR_WORK_TYPE_ID) != null
				&& !(request.getParameter(MAJOR_WORK_TYPE_ID).equals(""))) {

			majorWorkDetailSearchDTO.setWorkTypeName(request
					.getParameter(MAJOR_WORK_TYPE_ID));
		}

		if (request.getParameter(MAJOR_WORK_DEPARTMENT) != null
				&& !request.getParameter(MAJOR_WORK_DEPARTMENT)
						.equalsIgnoreCase("0")
				&& request.getParameter(MAJOR_WORK_DEPARTMENT) != null) {
			majorWorkDetailSearchDTO.setDepartment(request
					.getParameter(MAJOR_WORK_DEPARTMENT));
		}
		if (request.getParameter(MAJOR_WORK_DETAIL) != null
				&& !request.getParameter(MAJOR_WORK_DETAIL).equalsIgnoreCase(
						"0") && request.getParameter(MAJOR_WORK_DETAIL) != null) {
			majorWorkDetailSearchDTO.setWorkDetails(request
					.getParameter(MAJOR_WORK_DETAIL));
		}

		map = majorWorkDetailSearchHandlerService
				.searchMajorWorkDetailSearch(majorWorkDetailSearchDTO);
		jsp = MAJOR_WORK_DETAIL_SEARCH;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public MajorWorkDetailSearchHandlerService getMajorWorkDetailSearchHandlerService() {
		return majorWorkDetailSearchHandlerService;
	}

	public void setMajorWorkDetailSearchHandlerService(
			MajorWorkDetailSearchHandlerService majorWorkDetailSearchHandlerService) {
		this.majorWorkDetailSearchHandlerService = majorWorkDetailSearchHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}