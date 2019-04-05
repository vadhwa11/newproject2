package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.ADMIN_APPROVAL_DATE;
import static jkt.hms.util.RequestConstants.ADMIN_APPROVAL_NAME;
import static jkt.hms.util.RequestConstants.ADMIN_APPROVAL_TIME;
import static jkt.hms.util.RequestConstants.APPROVAL_OF_MINOR_WORK_DETAIL_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.ESTIMATED_DATE;
import static jkt.hms.util.RequestConstants.MINOR_WORK_REMARK;
import static jkt.hms.util.RequestConstants.PDC;
import static jkt.hms.util.RequestConstants.TOTAL_BALANCE;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks;
import jkt.hms.masters.business.MasMinorWorkDetail;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;
import jkt.hms.workservices.handler.ApprovalOfMinorWorkDetailHandlerService;
import jkt.hms.workservices.handler.MinorWorkDetailsApprovalHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ApprovalOfMinorWorkDetailController extends MultiActionController {

	private ApprovalOfMinorWorkDetailHandlerService approvalOfMinorWorkDetailHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;
	private int minorWorkDetailId;
	MinorWorkDetailsApprovalHandlerService minorWorkDetailsApprovalHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showApprovalOfMinorWorkDetailJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = null;
		String title = "";
		int totalAllotmentAmount = 0;
		int expenditureAmount = 0;
		setMinorWorkDetailId(Integer.parseInt(request
				.getParameter("minorWorkDetailId")));
		int Id = getMinorWorkDetailId();
		Map map = new HashMap();
		map = approvalOfMinorWorkDetailHandlerService
				.showApprovalOfMinorWorkDetailJsp(Id);
		List<MasAllotmentOfFundsForMinorWorks> allotmentList = new ArrayList<MasAllotmentOfFundsForMinorWorks>();
		allotmentList = (List<MasAllotmentOfFundsForMinorWorks>) map
				.get("allotmentList");
		if (allotmentList != null && allotmentList.size() > 0) {
			for (MasAllotmentOfFundsForMinorWorks masAllotment : allotmentList) {
				if (masAllotment.getStatus().equalsIgnoreCase("y")
						&& masAllotment.getAllotmentFileAmount() != null)
					totalAllotmentAmount += masAllotment
							.getAllotmentFileAmount().intValue();
			}
		}
		map.put("totalAllotmentAmount", totalAllotmentAmount);

		List<MasMinorWorkDetail> minorWorkDetailList = new ArrayList<MasMinorWorkDetail>();
		minorWorkDetailList = (List<MasMinorWorkDetail>) map
				.get("minorWorkDetailList");

		if (minorWorkDetailList != null && minorWorkDetailList.size() > 0) {
			for (MasMinorWorkDetail minorWorkDetail : minorWorkDetailList) {
				if (!minorWorkDetail.getStatus().equalsIgnoreCase("y")
						&& !minorWorkDetail.getStatus().equalsIgnoreCase("r")
						&& minorWorkDetail.getMinorWorkDetailEstimatedCost() != null
						&& !minorWorkDetail.getMinorWorkDetailEstimatedCost()
								.equalsIgnoreCase(""))
					expenditureAmount += Integer.parseInt(minorWorkDetail
							.getMinorWorkDetailEstimatedCost());
			}
		}
		map.put("expenditureAmount", expenditureAmount);
		jsp = APPROVAL_OF_MINOR_WORK_DETAIL_JSP;
		jsp += ".jsp";
		title = "Approval Of Minor Work Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editApprovalOfMinorWorkDetail(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		String message = " ";
		String printFlag = "";
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String totalBalance = "";

		String adminApprovalName = "";
		String adminApprovalDate = "";
		String adminApprovalTime = "";
		String pdc = "";
		String estimatedDate = "";
		String remark = "";

		String pojoPropertyName = "";
		String pojoName = "";
		if (request.getParameter("printFlag") != null) {
			printFlag = request.getParameter("printFlag");
		}
		if (request.getParameter(ADMIN_APPROVAL_NAME) != null
				&& !(request.getParameter(ADMIN_APPROVAL_NAME).equals(""))) {
			adminApprovalName = request.getParameter(ADMIN_APPROVAL_NAME);
		}
		if (request.getParameter(ADMIN_APPROVAL_DATE) != null
				&& !(request.getParameter(ADMIN_APPROVAL_DATE).equals(""))) {
			adminApprovalDate = request.getParameter(ADMIN_APPROVAL_DATE);
		}
		if (request.getParameter(ADMIN_APPROVAL_TIME) != null
				&& !(request.getParameter(ADMIN_APPROVAL_TIME).equals(""))) {
			adminApprovalTime = request.getParameter(ADMIN_APPROVAL_TIME);
		}

		if (request.getParameter(PDC) != null
				&& !(request.getParameter(PDC).equals(""))) {
			pdc = request.getParameter(PDC);
		}
		if (request.getParameter(ESTIMATED_DATE) != null
				&& !(request.getParameter(ESTIMATED_DATE).equals(""))) {
			estimatedDate = request.getParameter(ESTIMATED_DATE);
		}

		if (request.getParameter(TOTAL_BALANCE) != null
				&& !(request.getParameter(TOTAL_BALANCE).equals(""))) {
			totalBalance = request.getParameter(TOTAL_BALANCE);
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
		generalMap.put("adminApprovalName", adminApprovalName);
		generalMap.put("totalBalance", totalBalance);
		generalMap.put("adminApprovalDate", adminApprovalDate);
		generalMap.put("adminApprovalTime", adminApprovalTime);
		generalMap.put("pdc", pdc);
		generalMap.put("estimatedDate", estimatedDate);
		generalMap.put("remark", remark);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoName", pojoName);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("title", title);

		generalMap.put("flag", true);

		// listMap =
		// commonMasterHandlerService.checkForExistingMasters(generalMap);
		// List existingMinorWorkDetailNameList = (List)
		// listMap.get("duplicateMastersList");
		boolean dataUpdated = false;
		/*
		 * if (existingMinorWorkDetailNameList.size() == 0) {
		 */

		dataUpdated = approvalOfMinorWorkDetailHandlerService
				.editApprovalOfMinorWorkDetailToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}
		/*
		 * } else if (existingMinorWorkDetailNameList.size() > 0) {
		 * 
		 * message = "Name already exists."; }
		 */

		map = approvalOfMinorWorkDetailHandlerService
				.showApprovalOfMinorWorkDetailJsp(minorWorkDetailId);
		if (printFlag.equalsIgnoreCase("y")) {
			map.put("printFlag", printFlag);
			map.put("displayMessage", "y");
		}
		jsp = APPROVAL_OF_MINOR_WORK_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("id", minorWorkDetailId);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateAdminApp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		int id = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = approvalOfMinorWorkDetailHandlerService
				.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		if (request.getParameter("id") != null
				&& !request.getParameter("id").equalsIgnoreCase("")) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		//System.out.println("id" + id);
		parameters.put("id", id);

		try {
			HMSUtil.generateReport("Provisionofcallbellatafids", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	// ---------------------------------------------------------------------------------------------
	public ApprovalOfMinorWorkDetailHandlerService getApprovalOfMinorWorkDetailHandlerService() {
		return approvalOfMinorWorkDetailHandlerService;
	}

	public void setApprovalOfMinorWorkDetailHandlerService(
			ApprovalOfMinorWorkDetailHandlerService approvalOfMinorWorkDetailHandlerService) {
		this.approvalOfMinorWorkDetailHandlerService = approvalOfMinorWorkDetailHandlerService;
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

	public MinorWorkDetailsApprovalHandlerService getMinorWorkDetailsApprovalHandlerService() {
		return minorWorkDetailsApprovalHandlerService;
	}

	public void setMinorWorkDetailsApprovalHandlerService(
			MinorWorkDetailsApprovalHandlerService minorWorkDetailsApprovalHandlerService) {
		this.minorWorkDetailsApprovalHandlerService = minorWorkDetailsApprovalHandlerService;
	}

	public void setMinorWorkDetailId(int minorWorkDetailId) {
		this.minorWorkDetailId = minorWorkDetailId;
	}
}
