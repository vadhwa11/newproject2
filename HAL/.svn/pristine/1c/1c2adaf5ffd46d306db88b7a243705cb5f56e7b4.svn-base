package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_BY;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_DATE;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_TIME;
import static jkt.hms.util.RequestConstants.MINOR_WORK_AUTHORITY;
import static jkt.hms.util.RequestConstants.MINOR_WORK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DATE;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL_JSP;
import static jkt.hms.util.RequestConstants.MINOR_WORK_ESTIMATED_COST;
import static jkt.hms.util.RequestConstants.MINOR_WORK_FINENTIAL_YEAR;
import static jkt.hms.util.RequestConstants.MINOR_WORK_ID;
import static jkt.hms.util.RequestConstants.MINOR_WORK_NO;
import static jkt.hms.util.RequestConstants.MINOR_WORK_PROPOSAL_NO;
import static jkt.hms.util.RequestConstants.MINOR_WORK_PROPOSAL_NO_ID;
import static jkt.hms.util.RequestConstants.MINOR_WORK_REMARK;
import static jkt.hms.util.RequestConstants.MINOR_WORK_TIME;
import static jkt.hms.util.RequestConstants.MINOR_WORK_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEARCH_MINOR_WORK_JSP;
import static jkt.hms.util.RequestConstants.USER_COMMENTS;
import static jkt.hms.util.RequestConstants.USER_COMMENTS_JSP;
import static jkt.hms.util.RequestConstants.VIEW_USER_COMMENTS_JSP;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.business.MasMinorWorkDetail;
import jkt.hms.masters.business.MasWorkType;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.workservices.handler.MinorWorkDetailHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MinorWorkDetailController extends MultiActionController {
	MinorWorkDetailHandlerService minorworkdetailhandlerservice = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	public ModelAndView showMinorWorkDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";

		String minorlastChangedBy = "";

		String minorWorkNo = "";
		if (request.getParameter(LAST_CHANGED_BY) != null) {
			minorlastChangedBy = request.getParameter(LAST_CHANGED_BY);
		}
		map = minorworkdetailhandlerservice.showMinorWorkDetailJsp();
		minorWorkNo = minorworkdetailhandlerservice
				.generateMinorWorkNumber(minorlastChangedBy);
		map.put("minorWorkNo", minorWorkNo);
		jsp = MINOR_WORK_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showUserCommentsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String minorWorkNo = "";
		if (request.getParameter(MINOR_WORK_NO) != null) {
			minorWorkNo = request.getParameter(MINOR_WORK_NO);
		}
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		map = minorworkdetailhandlerservice.showUserCommentsJsp();
		jsp = USER_COMMENTS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("minorWorkNo", minorWorkNo);
		// map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView addMinorWorkDetail(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> map = new HashMap<String, Object>();
		String financialyear = "";
		String minorworkNo = "";
		Date minorworkDate = null;
		String minorworkTime = "";
		String workCategory = "";
		Integer workType = 0;
		String minorworkDetail = "";
		String minorestimatedCost = "";
		int proposalNoId = 0;
		String remarks = "";
		String jsp = "";
		String title = "";
		String message = "";
		String minorlastChangedBy = "";
		String minorWorkNo = "";
		String pojoName = "MasMinorWorkDetail";
		String minorlastChangedTime = "";
		Date minorlastChangedDate = null;
		String minorWorkProposalNo = "";
		MasMinorWorkDetail masMinorWorkdetail = new MasMinorWorkDetail();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List minorWorkDetailList = new ArrayList();
		if (req.getParameter(MINOR_WORK_FINENTIAL_YEAR) != null) {
			financialyear = req.getParameter(MINOR_WORK_FINENTIAL_YEAR);

		}
		if (req.getParameter(MINOR_WORK_PROPOSAL_NO_ID) != null) {
			proposalNoId = Integer.parseInt(req
					.getParameter(MINOR_WORK_PROPOSAL_NO_ID));
		}

		if (req.getParameter(MINOR_WORK_NO) != null) {
			minorworkNo = req.getParameter(MINOR_WORK_NO);
		}
		if (req.getParameter(MINOR_WORK_PROPOSAL_NO) != null) {
			minorWorkProposalNo = req.getParameter(MINOR_WORK_PROPOSAL_NO);
		}
		if (req.getParameter(MINOR_WORK_DATE) != null) {
			minorworkDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(MINOR_WORK_DATE));
		}
		if (req.getParameter(MINOR_WORK_TIME) != null) {
			minorworkTime = req.getParameter(MINOR_WORK_TIME);
		}
		if (req.getParameter(LAST_CHANGED_BY) != null) {
			minorlastChangedBy = req.getParameter(LAST_CHANGED_BY);
		}
		if (req.getParameter(LAST_CHANGED_DATE) != null) {
			minorlastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(LAST_CHANGED_DATE));
		}
		if (req.getParameter(LAST_CHANGED_TIME) != null) {
			minorlastChangedTime = req.getParameter(LAST_CHANGED_TIME);
		}
		if (req.getParameter(MINOR_WORK_CATEGORY_ID) != null) {
			workCategory = req.getParameter(MINOR_WORK_CATEGORY_ID);

		}

		if (req.getParameter(MINOR_WORK_TYPE_ID) != null) {
			workType = Integer.parseInt(req.getParameter(MINOR_WORK_TYPE_ID));

		}

		if (req.getParameter(MINOR_WORK_DETAIL) != null) {
			minorworkDetail = req.getParameter(MINOR_WORK_DETAIL);

		}
		if (req.getParameter(MINOR_WORK_DETAIL) != null) {
			minorworkDetail = req.getParameter(MINOR_WORK_DETAIL);

		}

		if (req.getParameter(MINOR_WORK_ESTIMATED_COST) != null) {
			minorestimatedCost = req.getParameter(MINOR_WORK_ESTIMATED_COST);
		}
		if (req.getParameter(MINOR_WORK_REMARK) != null) {
			remarks = req.getParameter(MINOR_WORK_REMARK);
		}
		String authority = "";
		if (req.getParameter(MINOR_WORK_AUTHORITY) != null) {
			authority = req.getParameter(MINOR_WORK_AUTHORITY);

		}
		if (req.getParameter("title") != null) {
			title = req.getParameter("title");
		}
		// initializing box with the request to get the values from the inner
		// table
		Box box = HMSUtil.getBox(req);

		masMinorWorkdetail.setFinancialYear(financialyear);
		masMinorWorkdetail.setMinorWorkDetailNo(minorworkNo);
		masMinorWorkdetail.setProposalNo(minorWorkProposalNo);
		masMinorWorkdetail.setMinorWorkDetailDate(minorworkDate);
		masMinorWorkdetail.setMinorWorkDetailTime(minorworkTime);
		masMinorWorkdetail.setStatus("y");
		masMinorWorkdetail.setLastChgBy(minorlastChangedBy);
		masMinorWorkdetail.setLastChgDate(minorlastChangedDate);
		masMinorWorkdetail.setLastChgTime(minorworkTime);
		masMinorWorkdetail.setWorkCategoryId(workCategory);
		MasWorkType masworktype = new MasWorkType();
		masworktype.setId(workType);
		masMinorWorkdetail.setWorkType(masworktype);
		masMinorWorkdetail.setMinorWorkDetail(minorworkDetail);
		masMinorWorkdetail.setMinorWorkDetailEstimatedCost(minorestimatedCost);
		masMinorWorkdetail.setMinorWorkDetailRemarks(remarks);
		masMinorWorkdetail.setAuthority(authority);
		generalMap.put("masMinorWorkdetail", masMinorWorkdetail);
		generalMap.put("box", box);
		generalMap.put("code", minorworkNo);
		generalMap.put("pojoPropertyCode", "MinorWorkDetailNo");
		generalMap.put("pojoName", pojoName);
		boolean successfullyAdded = false;
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		minorWorkDetailList = (List) listMap.get("duplicateGeneralCodeList");
		if (minorWorkDetailList == null || minorWorkDetailList.size() == 0) {
			successfullyAdded = minorworkdetailhandlerservice
					.addMinorWorkDetail(generalMap, proposalNoId);
			generalMap.clear();
		} else {
			message = "Minor work no already exist !!";
		}

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message += "Try Again !!";
		}

		try {
			map = minorworkdetailhandlerservice.showMinorWorkDetailJsp();
		} catch (Exception e) {
		}
		if (req.getParameter(LAST_CHANGED_BY) != null) {
			minorlastChangedBy = req.getParameter(LAST_CHANGED_BY);
		}
		minorWorkNo = minorworkdetailhandlerservice
				.generateMinorWorkNumber(minorlastChangedBy);
		map.put("minorWorkNo", minorWorkNo);
		jsp = MINOR_WORK_DETAIL_JSP;
		title = "Add minor Work Detail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editUserComments(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		String message = " ";
		Map<String, Object> detailMap = new HashMap<String, Object>();

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String userComment = "";
		String minorWorkId = "";
		String finencialYear = "";
		List<MasWorkType> detailList = new ArrayList<MasWorkType>();

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(MINOR_WORK_ID) != null
				&& !(request.getParameter(MINOR_WORK_ID).equals(""))) {
			minorWorkId = request.getParameter(MINOR_WORK_ID);
		}
		if (request.getParameter(USER_COMMENTS) != null
				&& !(request.getParameter(USER_COMMENTS).equals(""))) {
			userComment = request.getParameter(USER_COMMENTS);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("changedTime", changedTime);
		generalMap.put("userComment", userComment);
		generalMap.put("minorWorkId", minorWorkId);

		boolean successfullyAdded = minorworkdetailhandlerservice
				.editUserComments(generalMap);
		if (successfullyAdded) {
			message = "Data Updated Successfully";
		} else {
			message = "Data could not be updated ! Please try again.";
		}
		map = minorworkdetailhandlerservice.showMinorWorkDetailJsp();
		detailMap = minorworkdetailhandlerservice.showMinorWorkDetailJsp();
		detailList = (List<MasWorkType>) detailMap.get("workTypeList");
		finencialYear = (String) detailMap.get("session");
		jsp = USER_COMMENTS_JSP;
		jsp += ".jsp";
		map.put("workTypeList", detailList);
		map.put("search", "search");
		map.put("session", finencialYear);
		map.put("contentJsp", jsp);

		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPopUpProposalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String jsp = "";
		dataMap = minorworkdetailhandlerservice.showPopUpProposalJsp(map);

		jsp = SEARCH_MINOR_WORK_JSP;
		jsp += ".jsp";
		dataMap.put("contentJsp", jsp);
		return new ModelAndView(SEARCH_MINOR_WORK_JSP, "map", dataMap);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showViewUserCommentsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		String message = " ";

		String minorWorkId = "";
		String finencialYear = "";
		List<MasWorkType> detailList = new ArrayList<MasWorkType>();

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(MINOR_WORK_ID) != null
				&& !(request.getParameter(MINOR_WORK_ID).equals(""))) {
			minorWorkId = request.getParameter(MINOR_WORK_ID);
		}
		generalMap.put("minorWorkId", minorWorkId);

		map = minorworkdetailhandlerservice.showViewUserCommentsJsp(generalMap);

		jsp = VIEW_USER_COMMENTS_JSP;
		jsp += ".jsp";
		map.put("workTypeList", detailList);
		map.put("search", "search");
		map.put("session", finencialYear);
		map.put("contentJsp", jsp);

		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public MinorWorkDetailHandlerService getMinorworkdetailhandlerservice() {
		return minorworkdetailhandlerservice;
	}

	public void setMinorWorkDetailHandlerService(
			MinorWorkDetailHandlerService minorworkdetailhandlerservice) {
		this.minorworkdetailhandlerservice = minorworkdetailhandlerservice;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
