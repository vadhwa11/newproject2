package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_BY;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_DATE;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_TIME;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DATE;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DETAIL;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DETAIL_JSP;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DETAIL_TYPE;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_NO;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_REMARK;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_TIME;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MajorWorkStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasMajorWorkDetail;
import jkt.hms.masters.business.MasWorkCategory;
import jkt.hms.masters.business.MasWorkType;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hms.workservices.handler.MajorWorkDetailHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MajorWorkDetailController extends MultiActionController {
	private MajorWorkDetailHandlerService majorworkdetailhandlerservice = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;

	public ModelAndView showMajorWorkDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String majorWorkNo = "";
		String majorLastChangedBy = "";
		Map map = new HashMap();
		map = majorworkdetailhandlerservice.showMajorWorkDetailJsp();
		if (request.getParameter(LAST_CHANGED_BY) != null) {
			majorLastChangedBy = request.getParameter(LAST_CHANGED_BY);
		}
		majorWorkNo = majorworkdetailhandlerservice
				.generateMajorWorkNumber(majorLastChangedBy);
		map.put("majorWorkNo", majorWorkNo);
		jsp = MAJOR_WORK_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showMajorWorkDetailStatusMessageJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String majorWorkNo = "";
		String majorLastChangedBy = "";
		Map map = new HashMap();
		map = majorworkdetailhandlerservice
				.showMajorWorkDetailStatusMessageJsp();
		jsp = RequestConstants.STATUS_MESSAGE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView addMajorWorkDetail(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String majorworkNo = "";
		Date majorworkDate = null;
		String majorworkTime = "";
		String workCategory = "";
		String jspName = "";
		Integer workType = 0;
		Integer employee = 1;
		String majorworkDetail = "";
		String remarks = "";
		String jsp = "";
		String title = "";
		String message = "";
		String statusOfRecord = "";
		String viewPage = "";
		String pojoName = "";
		String pojoPropertyName = "";
		String currentTime = "";
		String majorlastChangedBy = "";
		String majorlastChangedTime = "";
		Date majorlastChangedDate = null;
		String status = "";
		String changeBy = "";
		String detailType = "";
		HttpSession session = null;
		MasMajorWorkDetail masMajorWorkdetail = new MasMajorWorkDetail();
		Map<String, Object> listMap = new HashMap<String, Object>();
		List masMinorWorkProposalList = new ArrayList();
		String majorWorkNo = "";
		String majorLastChangedBy = "";
		map = majorworkdetailhandlerservice.showMajorWorkDetailJsp();
		if (req.getParameter(LAST_CHANGED_BY) != null) {
			majorLastChangedBy = req.getParameter(LAST_CHANGED_BY);
		}
		if (req.getParameter(MAJOR_WORK_NO) != null) {
			majorworkNo = req.getParameter(MAJOR_WORK_NO);
		}
		if (req.getParameter(MAJOR_WORK_DATE) != null) {
			majorworkDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(MAJOR_WORK_DATE));
		}
		if (req.getParameter(MAJOR_WORK_TIME) != null) {
			majorworkTime = req.getParameter(MAJOR_WORK_TIME);
		}

		if (req.getParameter(LAST_CHANGED_BY) != null) {
			majorlastChangedBy = req.getParameter(LAST_CHANGED_BY);
		}
		if (req.getParameter(LAST_CHANGED_DATE) != null) {
			majorlastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(LAST_CHANGED_DATE));
		}
		if (req.getParameter(LAST_CHANGED_TIME) != null) {
			majorlastChangedTime = req.getParameter(LAST_CHANGED_TIME);
		}

		if (req.getParameter(MAJOR_WORK_CATEGORY_ID) != null) {
			workCategory = req.getParameter(MAJOR_WORK_CATEGORY_ID);

		}
		if (req.getParameter(MAJOR_WORK_TYPE_ID) != null) {
			workType = Integer.parseInt(req.getParameter(MAJOR_WORK_TYPE_ID));

		}
		if (req.getParameter(MAJOR_WORK_DETAIL) != null) {
			majorworkDetail = req.getParameter(MAJOR_WORK_DETAIL);

		}

		if (req.getParameter(MAJOR_WORK_REMARK) != null) {
			remarks = req.getParameter(MAJOR_WORK_REMARK);
		}

		if (req.getParameter(CHANGED_BY) != null
				&& !(req.getParameter(CHANGED_BY).equals(""))) {
			changeBy = req.getParameter(CHANGED_BY);
		}
		if (req.getParameter(CHANGED_TIME) != null
				&& !(req.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = req.getParameter(CHANGED_TIME);

		}
		if (req.getParameter(MAJOR_WORK_DETAIL_TYPE) != null
				&& !(req.getParameter(MAJOR_WORK_DETAIL_TYPE).equals(""))) {
			detailType = req.getParameter(MAJOR_WORK_DETAIL_TYPE);

		}

		if (req.getParameter("title") != null) {
			title = req.getParameter("title");
		}
		// initializing box with the request to get the values from the inner
		// table
		Box box = HMSUtil.getBox(req);
		MajorWorkStatus majorWorkStatus = new MajorWorkStatus();
		masMajorWorkdetail.setMajorWorkDetailNo(majorworkNo);
		masMajorWorkdetail.setMajorWorkDetailDate(majorworkDate);
		masMajorWorkdetail.setMajorWorkDetailTime(majorworkTime);
		masMajorWorkdetail.setStatusOfRecord("y");
		majorWorkStatus.setId(1);
		masMajorWorkdetail.setMajorWorkDetailStatus(majorWorkStatus);
		masMajorWorkdetail.setLastChangedBy(majorlastChangedBy);
		masMajorWorkdetail.setLastChangedDate(majorlastChangedDate);
		masMajorWorkdetail.setLastChangedTime(majorworkTime);
		masMajorWorkdetail.setType(detailType);
		MasWorkCategory masWorkCategory = new MasWorkCategory();
		MasWorkType masworktype = new MasWorkType();
		MasEmployee masemployee = new MasEmployee();
		masMajorWorkdetail.setWorkCategoryName(workCategory);
		masworktype.setId(workType);
		masMajorWorkdetail.setWorkType(masworktype);
		masMajorWorkdetail.setMajorWorkDetail(majorworkDetail);
		masemployee.setId(employee);
		masMajorWorkdetail.setEmployee(masemployee);
		masMajorWorkdetail.setMajorWorkDetailRemarks(remarks);
		generalMap.put("masMajorWorkdetail", masMajorWorkdetail);
		generalMap.put("box", box);
		generalMap.put("code", majorworkNo);
		generalMap.put("pojoPropertyCode", "MajorWorkDetailNo");
		generalMap.put("pojoName", "MasMajorWorkDetail");
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		masMinorWorkProposalList = (List) listMap
				.get("duplicateGeneralCodeList");
		boolean successfullyAdded = false;
		if (masMinorWorkProposalList == null
				|| masMinorWorkProposalList.size() == 0) {
			successfullyAdded = majorworkdetailhandlerservice
					.addMajorWorkDetail(generalMap);
			generalMap.clear();
		} else {
			message = "Major Work No already exist !! ";
		}

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message += "Please Try Again !!";
		}

		try {
			map = majorworkdetailhandlerservice.showMajorWorkDetailJsp();
		} catch (Exception e) {

		}
		majorWorkNo = majorworkdetailhandlerservice
				.generateMajorWorkNumber(majorLastChangedBy);
		map.put("majorWorkNo", majorWorkNo);
		jsp = MAJOR_WORK_DETAIL_JSP;
		title = "Add minor Work Detail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editStatusMessage(HttpServletRequest request,
			HttpServletResponse response) {

		String desc1 = "";
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
		String statusMessage = "";
		int statusMessageId = 0;
		String changedBy = "";

		Date changedDate = null;
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			statusMessageId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			statusMessage = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(RequestConstants.DESC1) != null
				&& !(request.getParameter(RequestConstants.DESC1).equals(""))) {
			desc1 = request.getParameter(RequestConstants.DESC1);
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

		generalMap.put("id", statusMessageId);
		generalMap.put("name", statusMessage);
		generalMap.put("minLimit", desc1);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyRemark", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		boolean dataUpdated = false;

		dataUpdated = majorworkdetailhandlerservice
				.editStatusMessageToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}

		map = majorworkdetailhandlerservice
				.showMajorWorkDetailStatusMessageJsp();

		jsp = RequestConstants.STATUS_MESSAGE_JSP;
		title = "Edit Department type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public MajorWorkDetailHandlerService getMajorworkdetailhandlerservice() {
		return majorworkdetailhandlerservice;
	}

	public void setMajorWorkDetailHandlerService(
			MajorWorkDetailHandlerService majorworkdetailhandlerservice) {
		this.majorworkdetailhandlerservice = majorworkdetailhandlerservice;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
