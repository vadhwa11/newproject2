package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.BATCH_NO;
import static jkt.hms.util.RequestConstants.CHEST_NO;
import static jkt.hms.util.RequestConstants.ENTRY_DATE;
import static jkt.hms.util.RequestConstants.ENTRY_NO;
import static jkt.hms.util.RequestConstants.NAME;
import static jkt.hms.util.RequestConstants.RESULT_OF_APPEAL_MEDICALBOARD_SEARCH_JSP;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.ResultOfAppealMedicalboardSearchHandlerService;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ResultOfAppealMedicalboardSearchController extends
		MultiActionController {
	ResultOfAppealMedicalboardSearchHandlerService resultOfAppealMedicalboardSearchHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public ModelAndView showResultOfAppealMedicalboardSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		map = resultOfAppealMedicalboardSearchHandlerService
				.showResultOfAppealMedicalboardSearchJsp();
		jsp = RESULT_OF_APPEAL_MEDICALBOARD_SEARCH_JSP;
		jsp += ".jsp";
		title = "Result Of Appeal Medical Board Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printResultOfAppealMedicalboardSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		map = resultOfAppealMedicalboardSearchHandlerService
				.showResultOfAppealMedicalboardSearchJsp();
		jsp = RequestConstants.MEDICAL_BOARD_RESULT_PRINT_JSP;
		jsp += ".jsp";
		title = "Result Of Appeal Medical Board Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchResultOfAppealMedicalboardSearch(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		ResultOfAppealMedicalboardSearchDTO resultOfAppealMedicalboardSearchDTO = new ResultOfAppealMedicalboardSearchDTO();
		if (!request.getParameter(ENTRY_NO).equalsIgnoreCase("")
				&& request.getParameter(ENTRY_NO) != null) {
			resultOfAppealMedicalboardSearchDTO.setEntryNo(request
					.getParameter(ENTRY_NO));
		}
		if (!request.getParameter(ENTRY_DATE).equalsIgnoreCase("")
				&& request.getParameter(ENTRY_DATE) != null) {
			resultOfAppealMedicalboardSearchDTO.setEntryDate(request
					.getParameter(ENTRY_DATE));
		}
		if (!request.getParameter(BATCH_NO).equalsIgnoreCase("")
				&& request.getParameter(BATCH_NO) != null) {
			resultOfAppealMedicalboardSearchDTO.setBatchNo(request
					.getParameter(BATCH_NO));
		}
		if (!request.getParameter(CHEST_NO).equalsIgnoreCase("")
				&& request.getParameter(CHEST_NO) != null) {
			resultOfAppealMedicalboardSearchDTO.setChestNo(request
					.getParameter(CHEST_NO));
		}
		if (!request.getParameter(NAME).equalsIgnoreCase("")
				&& request.getParameter(NAME) != null) {
			resultOfAppealMedicalboardSearchDTO.setName(request
					.getParameter(NAME));
		}
		String flag = "";
		if (request.getParameter(RequestConstants.FLAG_FOR_PRINT) != null
				&& !(request.getParameter(RequestConstants.FLAG_FOR_PRINT)
						.equals(""))) {
			flag = request.getParameter(RequestConstants.FLAG_FOR_PRINT);
		}
		if (flag.equalsIgnoreCase("y")) {
			jsp = RequestConstants.MEDICAL_BOARD_RESULT_PRINT_JSP;
		} else {
			jsp = RESULT_OF_APPEAL_MEDICALBOARD_SEARCH_JSP;
		}
		map = resultOfAppealMedicalboardSearchHandlerService
				.searchResultOfAppealMedicalboardSearch(resultOfAppealMedicalboardSearchDTO);

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ResultOfAppealMedicalboardSearchHandlerService getResultOfAppealMedicalboardSearchHandlerService() {
		return resultOfAppealMedicalboardSearchHandlerService;
	}

	public void setResultOfAppealMedicalboardSearchHandlerService(
			ResultOfAppealMedicalboardSearchHandlerService resultOfAppealMedicalboardSearchHandlerService) {
		this.resultOfAppealMedicalboardSearchHandlerService = resultOfAppealMedicalboardSearchHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}