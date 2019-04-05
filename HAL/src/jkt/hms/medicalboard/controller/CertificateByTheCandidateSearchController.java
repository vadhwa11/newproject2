package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.BATCH_NO;
import static jkt.hms.util.RequestConstants.CERTIFICATE_BY_CANDIDATE_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.CHEST_NO;
import static jkt.hms.util.RequestConstants.ENTRY_DATE;
import static jkt.hms.util.RequestConstants.ENTRY_NO;
import static jkt.hms.util.RequestConstants.NAME;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.CertificateByTheCandidateSearchHandlerService;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CertificateByTheCandidateSearchController extends
		MultiActionController {
	CertificateByTheCandidateSearchHandlerService certificateByTheCandidateSearchHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public ModelAndView showCertificateByTheCandidateSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		map = certificateByTheCandidateSearchHandlerService
				.showCertificateByTheCandidateSearchJsp();
		jsp = CERTIFICATE_BY_CANDIDATE_SEARCH_JSP;
		jsp += ".jsp";
		title = "Minor Work Detail Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printCertificateByTheCandidateSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		map = certificateByTheCandidateSearchHandlerService
				.showCertificateByTheCandidateSearchJsp();
		jsp = RequestConstants.MEDICAL_BOARD_CERTIFICATE_PRINT_JSP;
		jsp += ".jsp";
		title = "Minor Work Detail Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchCertificateByTheCandidateSearch(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		CertificateByTheCandidateSearchDTO certificateByTheCandidateSearchDTO = new CertificateByTheCandidateSearchDTO();
		if (!request.getParameter(ENTRY_NO).equalsIgnoreCase("")
				&& request.getParameter(ENTRY_NO) != null) {
			certificateByTheCandidateSearchDTO.setEntryNo(request
					.getParameter(ENTRY_NO));
		}
		if (!request.getParameter(ENTRY_DATE).equalsIgnoreCase("")
				&& request.getParameter(ENTRY_DATE) != null) {
			certificateByTheCandidateSearchDTO.setEntryDate(request
					.getParameter(ENTRY_DATE));
		}
		if (!request.getParameter(BATCH_NO).equalsIgnoreCase("")
				&& request.getParameter(BATCH_NO) != null) {
			certificateByTheCandidateSearchDTO.setBatchNo(request
					.getParameter(BATCH_NO));
		}
		if (!request.getParameter(CHEST_NO).equalsIgnoreCase("")
				&& request.getParameter(CHEST_NO) != null) {
			certificateByTheCandidateSearchDTO.setChestNo(request
					.getParameter(CHEST_NO));
		}
		if (!request.getParameter(NAME).equalsIgnoreCase("")
				&& request.getParameter(NAME) != null) {
			certificateByTheCandidateSearchDTO.setName(request
					.getParameter(NAME));
		}
		String flag = "";
		if (request.getParameter(RequestConstants.FLAG_FOR_PRINT) != null
				&& !(request.getParameter(RequestConstants.FLAG_FOR_PRINT)
						.equals(""))) {
			flag = request.getParameter(RequestConstants.FLAG_FOR_PRINT);
		}
		if (flag.equalsIgnoreCase("y")) {
			jsp = RequestConstants.MEDICAL_BOARD_CERTIFICATE_PRINT_JSP;
		} else {
			jsp = CERTIFICATE_BY_CANDIDATE_SEARCH_JSP;
		}
		map = certificateByTheCandidateSearchHandlerService
				.searchCertificateByTheCandidateSearch(certificateByTheCandidateSearchDTO);

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public CertificateByTheCandidateSearchHandlerService getCertificateByTheCandidateSearchHandlerService() {
		return certificateByTheCandidateSearchHandlerService;
	}

	public void setCertificateByTheCandidateSearchHandlerService(
			CertificateByTheCandidateSearchHandlerService certificateByTheCandidateSearchHandlerService) {
		this.certificateByTheCandidateSearchHandlerService = certificateByTheCandidateSearchHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}