package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.BATCH_NO;
import static jkt.hms.util.RequestConstants.CERTIFICATE_BY_CANDIDATE_DETAILS_SRNO;
import static jkt.hms.util.RequestConstants.CERTIFICATE_BY_CANDIDATE_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHEST_NO;
import static jkt.hms.util.RequestConstants.ENTRY_DATE;
import static jkt.hms.util.RequestConstants.ENTRY_NO;
import static jkt.hms.util.RequestConstants.NAME;
import static jkt.hms.util.RequestConstants.OPT_TO_REPORT;
import static jkt.hms.util.RequestConstants.PLACE;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.business.MbCertificateByCandidateMaster;
import jkt.hms.masters.business.MbCertificateByCandidateUnfitExpl;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.CertificateByTheCandidateHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CertificateByTheCandidateController extends MultiActionController {
	private CertificateByTheCandidateHandlerService certificateByTheCandidatehandlerservice = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;

	public ModelAndView showCertificateByTheCandidateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String entryNo = "";
		String lastChangedBy = "";
		if (request.getParameter(CHANGED_BY) != null) {
			lastChangedBy = request.getParameter(CHANGED_BY);
		}
		map = certificateByTheCandidatehandlerservice
				.showCertificateByTheCandidateJsp();
		entryNo = certificateByTheCandidatehandlerservice
				.generateCertificateByCandidateNo(lastChangedBy);
		map.put("entryNo", entryNo);
		jsp = CERTIFICATE_BY_CANDIDATE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCertificateByTheCandidate(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> map = new HashMap<String, Object>();
		String entryNo = "";
		String entryDate = null;
		String batchNo = "";
		String chestNo = "";
		String name = "";
		String place = "";
		String optToReport = "";
		String jsp = "";
		String title = "";
		String message = "";
		String lastChangedBy = "";
		String lastChangedTime = "";
		Date lastChangedDate = null;
		Map<String, Object> listMap = new HashMap<String, Object>();
		MbCertificateByCandidateMaster masCertificateByTheCandidate = new MbCertificateByCandidateMaster();
		// initializing box with the request to get the values from the inner
		// table
		Box box = HMSUtil.getBox(req);

		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<MbCertificateByCandidateUnfitExpl> mbUnfitExplanationList = new ArrayList<MbCertificateByCandidateUnfitExpl>();

		// get the vector of values for each table input field. size of vector
		// will depend on the no of rows added

		Vector v1 = box.getVector("unfit");
		Vector v2 = box.getVector(CERTIFICATE_BY_CANDIDATE_DETAILS_SRNO);

		if (req.getParameter(ENTRY_NO) != null) {
			entryNo = req.getParameter(ENTRY_NO);

		}
		if (req.getParameter(ENTRY_DATE) != null) {
			entryDate = req.getParameter(ENTRY_DATE);
		}
		if (req.getParameter(BATCH_NO) != null) {
			batchNo = req.getParameter(BATCH_NO);
		}
		if (req.getParameter(CHEST_NO) != null) {
			chestNo = req.getParameter(CHEST_NO);
		}
		if (req.getParameter(NAME) != null) {
			name = req.getParameter(NAME);
		}
		if (req.getParameter(PLACE) != null) {
			place = req.getParameter(PLACE);
		}
		if (req.getParameter(OPT_TO_REPORT) != null) {
			optToReport = req.getParameter(OPT_TO_REPORT);
		}
		if (req.getParameter(CHANGED_BY) != null) {
			lastChangedBy = req.getParameter(CHANGED_BY);
		}
		if (req.getParameter(CHANGED_DATE) != null) {
			lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(CHANGED_DATE));
		}
		if (req.getParameter(CHANGED_TIME) != null) {
			lastChangedTime = req.getParameter(CHANGED_TIME);
		}

		if (req.getParameter("title") != null) {
			title = req.getParameter("title");
		}
		for (int i = 0; i < v1.size(); i++) {
			MbCertificateByCandidateUnfitExpl mbCertificateByTheCandidateUnfitExpl = new MbCertificateByCandidateUnfitExpl();
			// setting the values in the POJO
			mbCertificateByTheCandidateUnfitExpl
					.setUnfitExplanation((String) v1.get(i));
			mbCertificateByTheCandidateUnfitExpl.setSrNo(Integer
					.parseInt((String) v2.get(i)));
			mbCertificateByTheCandidateUnfitExpl.setLastChgBy(lastChangedBy);
			mbCertificateByTheCandidateUnfitExpl
					.setLastChgDate(lastChangedDate);
			mbCertificateByTheCandidateUnfitExpl
					.setLastChgTime(lastChangedTime);
			mbCertificateByTheCandidateUnfitExpl.setStatus("y");
			// Adding POJO to list based on this list values will be updated in
			// the
			// data service
			mbUnfitExplanationList.add(mbCertificateByTheCandidateUnfitExpl);
		}
		if (entryNo.equalsIgnoreCase("")) {
			masCertificateByTheCandidate.setEntryNo(0);
		} else {
			masCertificateByTheCandidate.setEntryNo(Integer.parseInt(entryNo));
		}

		masCertificateByTheCandidate.setEntryDate(HMSUtil
				.convertStringTypeDateToDateType(entryDate));
		masCertificateByTheCandidate.setBatchNo(batchNo);
		masCertificateByTheCandidate.setChestNo(chestNo);
		masCertificateByTheCandidate.setName(name);
		masCertificateByTheCandidate.setPlace(place);
		masCertificateByTheCandidate.setOptReportAppealExamination(optToReport);
		masCertificateByTheCandidate.setLastChgBy(lastChangedBy);
		masCertificateByTheCandidate.setLastChgDate(lastChangedDate);
		masCertificateByTheCandidate.setLastChgTime(lastChangedTime);
		masCertificateByTheCandidate.setStatus("y");
		generalMap.put("mbUnfitExplanationList", mbUnfitExplanationList);
		generalMap.put("masCertificateByTheCandidate",
				masCertificateByTheCandidate);
		List<MbCertificateByCandidateMaster> certificateByTheCandidateList = new ArrayList<MbCertificateByCandidateMaster>();
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		if (listMap.get("duplicateGeneralCodeList") != null) {
			certificateByTheCandidateList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		boolean successfullyAdded = false;

		if ((certificateByTheCandidateList.size() == 0 || certificateByTheCandidateList == null)) {
			successfullyAdded = certificateByTheCandidatehandlerservice
					.addCertificateByTheCandidate(generalMap);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		}

		else if ((certificateByTheCandidateList.size() != 0 || certificateByTheCandidateList != null)) {

			if ((certificateByTheCandidateList.size() != 0 || certificateByTheCandidateList != null)) {

				message = "Record already exists.";
			} else if ((certificateByTheCandidateList.size() == 0 || certificateByTheCandidateList == null)) {

				message = "Record already exists.";
			} else if ((certificateByTheCandidateList.size() != 0 || certificateByTheCandidateList != null)) {

				message = "Record already exists.";
			}
		}

		if (successfullyAdded) {
			message = "Record Added Successfully!Do you want to print !!";
		} else {
			message = "Try Again !!";
		}

		try {
			map = certificateByTheCandidatehandlerservice
					.showCertificateByTheCandidateJsp();
		} catch (Exception e) {
		}
		entryNo = certificateByTheCandidatehandlerservice
				.generateCertificateByCandidateNo(lastChangedBy);
		map.put("entryNo", entryNo);
		jsp = RequestConstants.MEDICAL_BOARD_CERTIFICATE_MSG;
		title = "Certificate by the candidate";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public CertificateByTheCandidateHandlerService getMinorworkdetailhandlerservice() {
		return certificateByTheCandidatehandlerservice;
	}

	public void setCertificateByTheCandidateHandlerService(
			CertificateByTheCandidateHandlerService certificateByTheCandidatehandlerservice) {
		this.certificateByTheCandidatehandlerservice = certificateByTheCandidatehandlerservice;
	}

	/**
	 * @return the commonMasterHandlerService
	 */
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	/**
	 * @param commonMasterHandlerService
	 *            the commonMasterHandlerService to set
	 */
	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
