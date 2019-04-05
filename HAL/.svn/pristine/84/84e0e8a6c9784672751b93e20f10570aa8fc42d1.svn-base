package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.BATCH_NO;
import static jkt.hms.util.RequestConstants.CERTIFICATE_BY_CANDIDATES_UPDATE_ID;
import static jkt.hms.util.RequestConstants.CERTIFICATE_BY_CANDIDATES_UPDATE_JSP;
import static jkt.hms.util.RequestConstants.CERTIFICATE_BY_CANDIDATE_DETAILS_SRNO;
import static jkt.hms.util.RequestConstants.CERTIFICATE_BY_CANDIDATE_SEARCH_JSP;
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
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.CertificateByTheCandidateSearchHandlerService;
import jkt.hms.medicalboard.handler.CertificateByTheCandidatesUpdateHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CertificateByTheCandidatesUpdateController extends
		MultiActionController {

	private CertificateByTheCandidatesUpdateHandlerService certificateByTheCandidatesUpdateHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;
	private int certificateByTheCandidateId;
	CertificateByTheCandidateSearchHandlerService certificateByTheCandidateSearchHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showCertificateByTheCandidatesUpdateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		setCertificateByTheCandidateId(Integer.parseInt(request
				.getParameter("certificateByTheCandidateId")));
		int Id = getCertificateByTheCandidateId();
		//System.out.println("Id in Controller Show Method" + Id);
		Map map = new HashMap();
		map = certificateByTheCandidatesUpdateHandlerService
				.showCertificateByTheCandidatesUpdateJsp(Id);
		jsp = CERTIFICATE_BY_CANDIDATES_UPDATE_JSP;
		jsp += ".jsp";
		title = "Certificate by the candidate update";
		map.put("contentJsp", jsp);
		map.put("Id", Id);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editCertificateByTheCandidatesUpdate(
			HttpServletRequest request, HttpServletResponse response) {
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

		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<CertificateByTheCandidateUpdateDTO> mbUnfitExplanationList = new ArrayList<CertificateByTheCandidateUpdateDTO>();

		// get the vector of values for each table input field. size of vector
		// will depend on the no of rows added
		Box box = HMSUtil.getBox(request);
		Vector v1 = box.getVector("unfitExp");
		Vector v2 = box.getVector(CERTIFICATE_BY_CANDIDATES_UPDATE_ID);
		Vector v3 = box.getVector(CERTIFICATE_BY_CANDIDATE_DETAILS_SRNO);
		if (request.getParameter(ENTRY_NO) != null) {
			entryNo = request.getParameter(ENTRY_NO);

		}
		if (request.getParameter(ENTRY_DATE) != null) {
			entryDate = request.getParameter(ENTRY_DATE);
		}
		if (request.getParameter(BATCH_NO) != null) {
			batchNo = request.getParameter(BATCH_NO);
		}
		if (request.getParameter(CHEST_NO) != null) {
			chestNo = request.getParameter(CHEST_NO);
		}
		if (request.getParameter(NAME) != null) {
			name = request.getParameter(NAME);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			lastChangedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			lastChangedTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(PLACE) != null) {
			place = request.getParameter(PLACE);
		}
		if (request.getParameter(OPT_TO_REPORT) != null) {
			optToReport = request.getParameter(OPT_TO_REPORT);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		for (int i = 0; i < v1.size(); i++) {
			CertificateByTheCandidateUpdateDTO certificateByTheCandidateSearchDTO = new CertificateByTheCandidateUpdateDTO();
			// setting the values in the POJO
			certificateByTheCandidateSearchDTO.setUnfitExplanation((String) v1
					.get(i));
			certificateByTheCandidateSearchDTO.setId(v2.get(i).toString());
			certificateByTheCandidateSearchDTO.setSrNo(Integer
					.parseInt((String) v3.get(i)));
			certificateByTheCandidateSearchDTO.setLastChangedBy(lastChangedBy);
			certificateByTheCandidateSearchDTO
					.setLastChangeDate(lastChangedDate);
			certificateByTheCandidateSearchDTO
					.setLastChangeTime(lastChangedTime);
			certificateByTheCandidateSearchDTO.setStatus("y");
			// Adding POJO to list based on this list values will be updated in
			// the
			// data service
			mbUnfitExplanationList.add(certificateByTheCandidateSearchDTO);
		}
		masCertificateByTheCandidate.setEntryNo(Integer.parseInt(entryNo));
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
		generalMap.put("id", getCertificateByTheCandidateId());
		List<MbCertificateByCandidateMaster> certificateByTheCandidateList = new ArrayList<MbCertificateByCandidateMaster>();
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		if (listMap.get("duplicateGeneralCodeList") != null) {
			certificateByTheCandidateList = (List) listMap
					.get("duplicateGeneralCodeList");
		}

		boolean successfullyUpdated = false;

		if ((certificateByTheCandidateList.size() == 0 || certificateByTheCandidateList == null)) {
			successfullyUpdated = certificateByTheCandidatesUpdateHandlerService
					.editCertificateByTheCandidatesUpdateToDatabase(generalMap);
			if (successfullyUpdated) {
				message = "Record Updated Successfully !!";
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

		if (successfullyUpdated) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Try Again !!";
		}

		try {
			map = certificateByTheCandidateSearchHandlerService
					.showCertificateByTheCandidateSearchJsp();
		} catch (Exception e) {
		}
		jsp = CERTIFICATE_BY_CANDIDATE_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------------------------------------------------------------------------------------
	// print method

	@SuppressWarnings("unchecked")
	public ModelAndView printMedicalBoard(HttpServletRequest request,
			HttpServletResponse response) {
		int Id = 1;
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = certificateByTheCandidatesUpdateHandlerService
				.getConnectionForReport();
		if (request.getParameter("Id") != null) {
			Id = Integer.parseInt(request.getParameter("Id"));

		}

		parameters.put("id", Id);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		try {

			HMSUtil.generateReport("CertificatebythecandidateEntry",
					parameters, (java.sql.Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ---------------------------------------------------------------------------------------------
	public CertificateByTheCandidatesUpdateHandlerService getCertificateByTheCandidatesUpdateHandlerService() {
		return certificateByTheCandidatesUpdateHandlerService;
	}

	public void setCertificateByTheCandidatesUpdateHandlerService(
			CertificateByTheCandidatesUpdateHandlerService certificateByTheCandidatesUpdateHandlerService) {
		this.certificateByTheCandidatesUpdateHandlerService = certificateByTheCandidatesUpdateHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public Integer getCertificateByTheCandidateId() {
		return certificateByTheCandidateId;
	}

	public void setCertificateByTheCandidateId(
			Integer certificateByTheCandidateId) {
		this.certificateByTheCandidateId = certificateByTheCandidateId;
	}

	public CertificateByTheCandidateSearchHandlerService getCertificateByTheCandidateSearchHandlerService() {
		return certificateByTheCandidateSearchHandlerService;
	}

	public void setCertificateByTheCandidateSearchHandlerService(
			CertificateByTheCandidateSearchHandlerService certificateByTheCandidateSearchHandlerService) {
		this.certificateByTheCandidateSearchHandlerService = certificateByTheCandidateSearchHandlerService;
	}

}
