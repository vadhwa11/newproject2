package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.ADMIN_APPROVAL_DATE;
import static jkt.hms.util.RequestConstants.ADMIN_APPROVAL_FWD_DATE;
import static jkt.hms.util.RequestConstants.ADMIN_APPROVAL_FWD_LETTER;
import static jkt.hms.util.RequestConstants.ADMIN_APPROVAL_NO;
import static jkt.hms.util.RequestConstants.AES_RECEIVED_ON;
import static jkt.hms.util.RequestConstants.BOO_DATE;
import static jkt.hms.util.RequestConstants.BPS_SENT_FOR;
import static jkt.hms.util.RequestConstants.BPS_SENT_FOR_AES_LETTER;
import static jkt.hms.util.RequestConstants.COMPLETED_ON;
import static jkt.hms.util.RequestConstants.ESTIMATED_COST;
import static jkt.hms.util.RequestConstants.FUND_RELEASED_AUTHRITY;
import static jkt.hms.util.RequestConstants.FUND_RELEASED_ON;
import static jkt.hms.util.RequestConstants.HRO_DATE;
import static jkt.hms.util.RequestConstants.HRO_NO;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DETAIL;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DETAIL_SEARCH;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DETAIL_UPDATE_JSP;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DETAIL_UPDATE_PDC;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DETAIL_UPDATE_REVISED_PD;
import static jkt.hms.util.RequestConstants.MAJOR_WORK_DETAIL_UPDATE_WEEK;
import static jkt.hms.util.RequestConstants.PENDING_SCRUTINY_AT;
import static jkt.hms.util.RequestConstants.PENDING_SCRUTINY_DATE;
import static jkt.hms.util.RequestConstants.PRESNIDING_OFFICER;
import static jkt.hms.util.RequestConstants.PROGRESS_PERCENTAGE;
import static jkt.hms.util.RequestConstants.PROGRESS_REMARKS;
import static jkt.hms.util.RequestConstants.PROJECT_OFFICER;
import static jkt.hms.util.RequestConstants.RECEIVED_DATE;
import static jkt.hms.util.RequestConstants.TENDER_ACTION_IN_HAND;
import static jkt.hms.util.RequestConstants.TENDER_COMPLETED;
import static jkt.hms.util.RequestConstants.TENDER_ISSUED_ON;
import static jkt.hms.util.RequestConstants.TO_BE_COMPLETE;
import static jkt.hms.util.RequestConstants.WORK_COMMENCED_ON;
import static jkt.hms.util.RequestConstants.WORK_COMPLETED_ON;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hms.workservices.handler.MajorWorkDetailSearchHandlerService;
import jkt.hms.workservices.handler.MajorWorkDetailUpdateHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MajorWorkDetailUpdateController extends MultiActionController {
	MajorWorkDetailUpdateHandlerService majorworkdetailupdatehandlerservice = null;
	MajorWorkDetailSearchHandlerService majorworksearchupdatehandlerservice = null;

	public ModelAndView showMajorWorkDetailUpdateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		Map map = new HashMap();
		String sampleCollectionDetailId = request
				.getParameter("sampleCollectionDetailId");
		int Id = Integer.parseInt(sampleCollectionDetailId);

		map = majorworkdetailupdatehandlerservice
				.showMajorWorkDetailUpdateJsp(Id);

		jsp = MAJOR_WORK_DETAIL_UPDATE_JSP;
		map.put("Id", Id);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView majorWorkDetailUpdateToDatabase(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String majorWorkRemarks = "";
		int majorWorkStatus = 1;
		String majorWorkHroNo = "";
		Date hroDate = null;
		Date booAssembledOn = null;
		Date majorWorkToBeComplete = null;
		String majorWorkPressidingOffice = "";
		Date majorWorkCompletedOn = null;
		String majorWorkBpsSentForAesLetter = "";
		Date majorWorkBpsSentFor = null;
		Date majorWorkAesReceivedOn = null;
		String majorEstimatedCost = "";
		String majorWorkAdminAproovalNo = "";
		Date majorWorkAdminAproovalDate = null;
		String majorWorkAdminFwdLetter = "";
		Date majorWorkAdminFwdLetterDate = null;
		String majorWorkFundReleaseAuth = "";
		Date majorWorkFundReleasedOn = null;
		int majorWorkWeek = 0;
		Date majorWorkPdc = null;
		Date majorWorkRevisedPd = null;
		String majorWorkTenderActionInHand = "";
		Date majorWorkTenderIssuedOn = null;
		Date majorWorkTenderComplete = null;
		String projectOfficer = "";
		Date pendingScrutinyDate = null;
		Date receivedDate = null;
		String pendingScrutinyAt = "";
		double progressPercentage = 0.00;
		String progressRemarks = "";
		Date majorWorkCompletionOn = null;
		Date majorWorkCommencedOn = null;
		String message = "";
		String url = "";
		String jsp = "";
		String title = "";
		String workTypeId = "";
		int Id = 0;

		if (request.getParameter("Id") != null
				&& !(request.getParameter("Id").equals(""))) {
			Id = Integer.parseInt(request.getParameter("Id"));
		}
		if (request.getParameter(MAJOR_WORK_DETAIL) != null
				&& !(request.getParameter(MAJOR_WORK_DETAIL).equals(""))) {
			majorWorkRemarks = request.getParameter(MAJOR_WORK_DETAIL);

		}
		if (request.getParameter(HRO_NO) != null
				&& !(request.getParameter(HRO_NO).equals(""))) {
			majorWorkHroNo = request.getParameter(HRO_NO);

		}
		if (request.getParameter(RequestConstants.MAJOR_WORK_TYPE_ID) != null
				&& !(request.getParameter(RequestConstants.MAJOR_WORK_TYPE_ID)
						.equals(""))) {
			workTypeId = request
					.getParameter(RequestConstants.MAJOR_WORK_TYPE_ID);

		}
		if (request.getParameter(HRO_DATE) != null
				&& !(request.getParameter(HRO_DATE).equals(""))) {
			hroDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(HRO_DATE));
			majorWorkStatus = 2;
		}
		if (request.getParameter(BOO_DATE) != null
				&& !(request.getParameter(BOO_DATE).equals(""))) {
			booAssembledOn = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(BOO_DATE));
			majorWorkStatus = 3;
		}
		if (request.getParameter(TO_BE_COMPLETE) != null
				&& !(request.getParameter(TO_BE_COMPLETE).equals(""))) {
			majorWorkToBeComplete = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_BE_COMPLETE));
		}
		if (request.getParameter(PRESNIDING_OFFICER) != null
				&& !(request.getParameter(PRESNIDING_OFFICER).equals(""))) {
			majorWorkPressidingOffice = request
					.getParameter(PRESNIDING_OFFICER);
		}
		if (request.getParameter(COMPLETED_ON) != null
				&& !(request.getParameter(COMPLETED_ON).equals(""))) {
			majorWorkCompletedOn = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(COMPLETED_ON));
			majorWorkStatus = 4;
		}
		if (request.getParameter(BPS_SENT_FOR_AES_LETTER) != null
				&& !(request.getParameter(BPS_SENT_FOR_AES_LETTER).equals(""))) {
			majorWorkBpsSentForAesLetter = request
					.getParameter(BPS_SENT_FOR_AES_LETTER);
		}
		if (request.getParameter(BPS_SENT_FOR) != null
				&& !(request.getParameter(BPS_SENT_FOR).equals(""))) {
			majorWorkBpsSentFor = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(BPS_SENT_FOR));
			majorWorkStatus = 5;
		}
		if (request.getParameter(AES_RECEIVED_ON) != null
				&& !(request.getParameter(AES_RECEIVED_ON).equals(""))) {
			majorWorkAesReceivedOn = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(AES_RECEIVED_ON));
			majorWorkStatus = 6;
		}

		if (request.getParameter(ESTIMATED_COST) != null
				&& !(request.getParameter(ESTIMATED_COST).equals(""))) {
			majorEstimatedCost = request.getParameter(ESTIMATED_COST);

		}
		if (request.getParameter(PENDING_SCRUTINY_AT) != null
				&& !(request.getParameter(PENDING_SCRUTINY_AT).equals(""))) {
			pendingScrutinyAt = request.getParameter(PENDING_SCRUTINY_AT);
		}

		if (request.getParameter(PENDING_SCRUTINY_DATE) != null
				&& !(request.getParameter(PENDING_SCRUTINY_DATE).equals(""))) {
			pendingScrutinyDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(PENDING_SCRUTINY_DATE));
		}

		if (request.getParameter(RECEIVED_DATE) != null
				&& !(request.getParameter(RECEIVED_DATE).equals(""))) {
			receivedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RECEIVED_DATE));
			majorWorkStatus = 7;
		}

		if (request.getParameter(ADMIN_APPROVAL_NO) != null
				&& !(request.getParameter(ADMIN_APPROVAL_NO).equals(""))) {
			majorWorkAdminAproovalNo = request.getParameter(ADMIN_APPROVAL_NO);

		}
		if (request.getParameter(ADMIN_APPROVAL_DATE) != null
				&& !(request.getParameter(ADMIN_APPROVAL_DATE).equals(""))) {
			majorWorkAdminAproovalDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ADMIN_APPROVAL_DATE));
		}
		if (request.getParameter(ADMIN_APPROVAL_FWD_LETTER) != null
				&& !(request.getParameter(ADMIN_APPROVAL_FWD_LETTER).equals(""))) {
			majorWorkAdminFwdLetter = request
					.getParameter(ADMIN_APPROVAL_FWD_LETTER);

		}
		if (request.getParameter(ADMIN_APPROVAL_FWD_DATE) != null
				&& !(request.getParameter(ADMIN_APPROVAL_FWD_DATE).equals(""))) {
			majorWorkAdminFwdLetterDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ADMIN_APPROVAL_FWD_DATE));
			majorWorkStatus = 8;
		}

		if (request.getParameter(FUND_RELEASED_AUTHRITY) != null
				&& !(request.getParameter(FUND_RELEASED_AUTHRITY).equals(""))) {
			majorWorkFundReleaseAuth = request
					.getParameter(FUND_RELEASED_AUTHRITY);

		}

		if (request.getParameter(FUND_RELEASED_ON) != null
				&& !(request.getParameter(FUND_RELEASED_ON).equals(""))) {
			majorWorkFundReleasedOn = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FUND_RELEASED_ON));
			majorWorkStatus = 9;
		}

		if (request.getParameter(MAJOR_WORK_DETAIL_UPDATE_WEEK) != null
				&& !(request.getParameter(MAJOR_WORK_DETAIL_UPDATE_WEEK)
						.equals(""))) {
			majorWorkWeek = Integer.parseInt(request
					.getParameter(MAJOR_WORK_DETAIL_UPDATE_WEEK));
		}

		if (request.getParameter(MAJOR_WORK_DETAIL_UPDATE_PDC) != null
				&& !(request.getParameter(MAJOR_WORK_DETAIL_UPDATE_PDC)
						.equals(""))) {
			majorWorkPdc = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(MAJOR_WORK_DETAIL_UPDATE_PDC));

		}
		if (request.getParameter(MAJOR_WORK_DETAIL_UPDATE_REVISED_PD) != null
				&& !(request.getParameter(MAJOR_WORK_DETAIL_UPDATE_REVISED_PD)
						.equals(""))) {
			majorWorkRevisedPd = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(MAJOR_WORK_DETAIL_UPDATE_REVISED_PD));

		}
		if (request.getParameter(TENDER_ACTION_IN_HAND) != null
				&& !(request.getParameter(TENDER_ACTION_IN_HAND).equals(""))) {
			majorWorkTenderActionInHand = request
					.getParameter(TENDER_ACTION_IN_HAND);
			if (request.getParameter(TENDER_ACTION_IN_HAND).equalsIgnoreCase(
					"y")) {
				majorWorkStatus = 10;
			}
		}

		if (request.getParameter(TENDER_ISSUED_ON) != null
				&& !(request.getParameter(TENDER_ISSUED_ON).equals(""))) {
			majorWorkTenderIssuedOn = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TENDER_ISSUED_ON));
			majorWorkStatus = 11;
		}
		if (request.getParameter(TENDER_COMPLETED) != null
				&& !(request.getParameter(TENDER_COMPLETED).equals(""))) {
			majorWorkTenderComplete = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TENDER_COMPLETED));
			majorWorkStatus = 12;
		}
		if (request.getParameter(PROJECT_OFFICER) != null
				&& !(request.getParameter(PROJECT_OFFICER).equals(""))) {
			projectOfficer = request.getParameter(PROJECT_OFFICER);
		}
		if (request.getParameter(PROGRESS_PERCENTAGE) != null
				&& !(request.getParameter(PROGRESS_PERCENTAGE).equals(""))) {
			progressPercentage = new Double(request
					.getParameter(PROGRESS_PERCENTAGE));
		}
		if (request.getParameter(PROGRESS_REMARKS) != null
				&& !(request.getParameter(PROGRESS_REMARKS).equals(""))) {
			progressRemarks = request.getParameter(PROGRESS_REMARKS);
		}

		if (request.getParameter(WORK_COMMENCED_ON) != null
				&& !(request.getParameter(WORK_COMMENCED_ON).equals(""))) {
			majorWorkCommencedOn = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(WORK_COMMENCED_ON));

		}
		if (request.getParameter(WORK_COMPLETED_ON) != null
				&& !(request.getParameter(WORK_COMPLETED_ON).equals(""))) {
			majorWorkCompletionOn = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(WORK_COMPLETED_ON));
			majorWorkStatus = 13;
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		// generalMap.put("majorWorkDetailNo", majorWorkDetailNo);
		generalMap.put("Id", Id);
		generalMap.put("majorWorkRemarks", majorWorkRemarks);
		generalMap.put("majorWorkHroNo", majorWorkHroNo);
		generalMap.put("hroDate", hroDate);
		generalMap.put("booAssembledOn", booAssembledOn);
		generalMap.put("majorWorkToBeComplete", majorWorkToBeComplete);
		generalMap.put("majorWorkPressidingOffice", majorWorkPressidingOffice);
		generalMap.put("majorWorkCompletedOn", majorWorkCompletedOn);
		generalMap.put("majorWorkBpsSentForAesLetter",
				majorWorkBpsSentForAesLetter);
		generalMap.put("majorWorkBpsSentFor", majorWorkBpsSentFor);
		generalMap.put("majorWorkAesReceivedOn", majorWorkAesReceivedOn);
		generalMap.put("majorEstimatedCost", majorEstimatedCost);
		generalMap.put("majorWorkAdminAproovalNo", majorWorkAdminAproovalNo);
		generalMap
				.put("majorWorkAdminAproovalDate", majorWorkAdminAproovalDate);
		generalMap.put("majorWorkAdminFwdLetter", majorWorkAdminFwdLetter);
		generalMap.put("majorWorkAdminFwdLetterDate",
				majorWorkAdminFwdLetterDate);
		generalMap.put("majorWorkFundReleaseAuth", majorWorkFundReleaseAuth);
		generalMap.put("majorWorkFundReleasedOn", majorWorkFundReleasedOn);
		generalMap.put("majorWorkWeek", majorWorkWeek);
		generalMap.put("majorWorkPdc", majorWorkPdc);
		generalMap.put("majorWorkRevisedPd", majorWorkRevisedPd);
		generalMap.put("majorWorkTenderActionInHand",
				majorWorkTenderActionInHand);
		generalMap.put("majorWorkTenderIssuedOn", majorWorkTenderIssuedOn);
		generalMap.put("majorWorkTenderComplete", majorWorkTenderComplete);
		generalMap.put("projectOfficer", projectOfficer);
		generalMap.put("progressPercentage", progressPercentage);
		generalMap.put("progressRemarks", progressRemarks);
		generalMap.put("majorWorkCommencedOn", majorWorkCommencedOn);
		generalMap.put("majorWorkCompletionOn", majorWorkCompletionOn);
		generalMap.put("majorWorkStatus", majorWorkStatus);
		generalMap.put("pendingScrutinyAt", pendingScrutinyAt);
		generalMap.put("pendingScrutinyDate", pendingScrutinyDate);
		generalMap.put("receivedDate", receivedDate);
		generalMap.put("workTypeId", workTypeId);
		generalMap.put("flag", true);

		boolean dataUpdated = false;
		dataUpdated = majorworkdetailupdatehandlerservice
				.majorWorkDetailUpdateToDatabase(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";

		} else {
			message = "Record Cant Be Updated !!";

		}
		try {

			map = majorworksearchupdatehandlerservice
					.showMajorWorkDetailSearchJsp();
		} catch (Exception e) {
		}
		jsp = MAJOR_WORK_DETAIL_SEARCH;
		title = "update Major Work Detail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public MajorWorkDetailUpdateHandlerService getMajorworkdetailupdatehandlerservice() {
		return majorworkdetailupdatehandlerservice;
	}

	public void setMajorWorkDetailUpdateHandlerService(
			MajorWorkDetailUpdateHandlerService majorworkdetailupdatehandlerservice) {
		this.majorworkdetailupdatehandlerservice = majorworkdetailupdatehandlerservice;
	}

	/**
	 * @return the majorworksearchupdatehandlerservice
	 */
	public MajorWorkDetailSearchHandlerService getMajorworksearchupdatehandlerservice() {
		return majorworksearchupdatehandlerservice;
	}

	/**
	 * @param majorworksearchupdatehandlerservice
	 *            the majorworksearchupdatehandlerservice to set
	 */
	public void setMajorworksearchupdatehandlerservice(
			MajorWorkDetailSearchHandlerService majorworksearchupdatehandlerservice) {
		this.majorworksearchupdatehandlerservice = majorworksearchupdatehandlerservice;
	}

}