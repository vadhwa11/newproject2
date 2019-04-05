package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_PROCEEDING_SEARCH;
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.P_LAST_NAME;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.SERVICE_NO;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.MedicalBoardProceedingSearchHandlerService;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MedicalBoardProceedingSearchController extends
		MultiActionController {

	private MedicalBoardProceedingSearchHandlerService medicalBoardProceedingSearchHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showMedicalBoard(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = medicalBoardProceedingSearchHandlerService.showMedicalBoard();
		jsp += MEDICAL_BOARD_PROCEEDING_SEARCH;
		jsp += ".jsp";
		title = "Medical Board Proceeding Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMedicalBoardProceeding(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		MedicalBoardProceedingSearchDTO medicalBoardProceedingSearchDTO = new MedicalBoardProceedingSearchDTO();
		if (request.getParameter(RANK_ID) != null
				&& !request.getParameter(RANK_ID).equalsIgnoreCase("0")) {
			medicalBoardProceedingSearchDTO.setRank(request
					.getParameter(RANK_ID));

		}
		if (request.getParameter(SERVICE_NO) != null
				&& !request.getParameter(SERVICE_NO).equalsIgnoreCase("")) {
			medicalBoardProceedingSearchDTO.setServiceNo(request
					.getParameter(SERVICE_NO));

		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !request.getParameter(P_FIRST_NAME).equalsIgnoreCase("0")) {
			medicalBoardProceedingSearchDTO.setFirstName(request
					.getParameter(P_FIRST_NAME));

		}
		if (request.getParameter(P_LAST_NAME) != null
				&& !request.getParameter(P_LAST_NAME).equalsIgnoreCase("0")) {
			medicalBoardProceedingSearchDTO.setLastName(request
					.getParameter(P_LAST_NAME));

		}
		if (request.getParameter(AD_NO) != null
				&& !request.getParameter(AD_NO).equalsIgnoreCase("0")) {
			medicalBoardProceedingSearchDTO
					.setAdNo(request.getParameter(AD_NO));

		}
		if (request.getParameter(RequestConstants.STAFF) != null
				&& !request.getParameter(RequestConstants.STAFF)
						.equalsIgnoreCase("")) {
			if (request.getParameter(RequestConstants.STAFF).equalsIgnoreCase(
					"s"))
				medicalBoardProceedingSearchDTO.setStaffFlag(true);
			else if (request.getParameter(RequestConstants.STAFF)
					.equalsIgnoreCase("p"))
				medicalBoardProceedingSearchDTO.setStaffFlag(false);
		}
		map = medicalBoardProceedingSearchHandlerService
				.searchMedicalBoardProceeding(medicalBoardProceedingSearchDTO);
		jsp = MEDICAL_BOARD_PROCEEDING_SEARCH;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showMedicalBoardForEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = medicalBoardProceedingSearchHandlerService
				.showMedicalBoardForEmployee();
		jsp = RequestConstants.MEDICAL_BOARD_PROCEEDING_SEARCH_FOR_EMPLOYEE_JSP;
		;
		jsp += ".jsp";
		title = "Medical Board Proceeding Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMedicalBoardProceedingForEmployee(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		MedicalBoardProceedingSearchDTO medicalBoardProceedingSearchDTO = new MedicalBoardProceedingSearchDTO();
		if (request.getParameter(RANK_ID) != null
				&& !request.getParameter(RANK_ID).equalsIgnoreCase("0")) {
			medicalBoardProceedingSearchDTO.setRank(request
					.getParameter(RANK_ID));

		}
		if (request.getParameter(SERVICE_NO) != null
				&& !request.getParameter(SERVICE_NO).equalsIgnoreCase("")) {
			medicalBoardProceedingSearchDTO.setServiceNo(request
					.getParameter(SERVICE_NO));

		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !request.getParameter(P_FIRST_NAME).equalsIgnoreCase("0")) {
			medicalBoardProceedingSearchDTO.setFirstName(request
					.getParameter(P_FIRST_NAME));

		}
		if (request.getParameter(P_LAST_NAME) != null
				&& !request.getParameter(P_LAST_NAME).equalsIgnoreCase("0")) {
			medicalBoardProceedingSearchDTO.setLastName(request
					.getParameter(P_LAST_NAME));

		}
		if (request.getParameter(AD_NO) != null
				&& !request.getParameter(AD_NO).equalsIgnoreCase("0")) {
			medicalBoardProceedingSearchDTO
					.setAdNo(request.getParameter(AD_NO));

		}
		if (request.getParameter(RequestConstants.STAFF) != null
				&& !request.getParameter(RequestConstants.STAFF)
						.equalsIgnoreCase("")) {
			if (request.getParameter(RequestConstants.STAFF).equalsIgnoreCase(
					"s"))
				medicalBoardProceedingSearchDTO.setStaffFlag(true);
			else if (request.getParameter(RequestConstants.STAFF)
					.equalsIgnoreCase("p"))
				medicalBoardProceedingSearchDTO.setStaffFlag(false);
		}
		map = medicalBoardProceedingSearchHandlerService
				.searchMedicalBoardProceedingForEmployee(medicalBoardProceedingSearchDTO);
		jsp = RequestConstants.MEDICAL_BOARD_PROCEEDING_SEARCH_FOR_EMPLOYEE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public MedicalBoardProceedingSearchHandlerService getMedicalBoardProceedingSearchHandlerService() {
		return medicalBoardProceedingSearchHandlerService;
	}

	public void setMedicalBoardProceedingSearchHandlerService(
			MedicalBoardProceedingSearchHandlerService medicalBoardProceedingSearchHandlerService) {
		this.medicalBoardProceedingSearchHandlerService = medicalBoardProceedingSearchHandlerService;
	}

}
