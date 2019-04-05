package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.BATCH_NO;
import static jkt.hms.util.RequestConstants.CHEST_NO;
import static jkt.hms.util.RequestConstants.ENTRY_DATE;
import static jkt.hms.util.RequestConstants.ENTRY_NO;
import static jkt.hms.util.RequestConstants.INSTRUCTION_TO_CANDIDATE_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.NAME;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.InstructionToCandidateSearchHandlerService;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class InstructionToCandidateSearchController extends
		MultiActionController {
	InstructionToCandidateSearchHandlerService instructionToCandidateSearchHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public ModelAndView showInstructionToCandidateSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		map = instructionToCandidateSearchHandlerService
				.showInstructionToCandidateSearchJsp();
		jsp = INSTRUCTION_TO_CANDIDATE_SEARCH_JSP;
		jsp += ".jsp";
		title = "Minor Work Detail Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printInstructionToCandidateSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		map = instructionToCandidateSearchHandlerService
				.showInstructionToCandidateSearchJsp();
		jsp = RequestConstants.MEDICAL_BOARD_INSTR_PRINT_JSP;
		jsp += ".jsp";
		title = "Minor Work Detail Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchInstructionToCandidateSearch(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		InstructionToCandidateSearchDTO instructionToCandidateSearchDTO = new InstructionToCandidateSearchDTO();
		if (!request.getParameter(ENTRY_NO).equalsIgnoreCase("")
				&& request.getParameter(ENTRY_NO) != null) {
			instructionToCandidateSearchDTO.setEntryNo(request
					.getParameter(ENTRY_NO));
		}
		if (!request.getParameter(ENTRY_DATE).equalsIgnoreCase("")
				&& request.getParameter(ENTRY_DATE) != null) {
			instructionToCandidateSearchDTO.setEntryDate(request
					.getParameter(ENTRY_DATE));
		}
		if (!request.getParameter(BATCH_NO).equalsIgnoreCase("")
				&& request.getParameter(BATCH_NO) != null) {
			instructionToCandidateSearchDTO.setBatchNo(request
					.getParameter(BATCH_NO));
		}
		if (!request.getParameter(CHEST_NO).equalsIgnoreCase("")
				&& request.getParameter(CHEST_NO) != null) {
			instructionToCandidateSearchDTO.setChestNo(request
					.getParameter(CHEST_NO));
		}
		if (!request.getParameter(NAME).equalsIgnoreCase("")
				&& request.getParameter(NAME) != null) {
			instructionToCandidateSearchDTO.setName(request.getParameter(NAME));
		}
		String flag = "";
		if (request.getParameter(RequestConstants.FLAG_FOR_PRINT) != null
				&& !(request.getParameter(RequestConstants.FLAG_FOR_PRINT)
						.equals(""))) {
			flag = request.getParameter(RequestConstants.FLAG_FOR_PRINT);
		}
		if (flag.equalsIgnoreCase("y")) {
			jsp = RequestConstants.MEDICAL_BOARD_INSTR_PRINT_JSP;
		} else {
			jsp = INSTRUCTION_TO_CANDIDATE_SEARCH_JSP;
		}
		map = instructionToCandidateSearchHandlerService
				.searchInstructionToCandidateSearch(instructionToCandidateSearchDTO);

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public InstructionToCandidateSearchHandlerService getInstructionToCandidateSearchHandlerService() {
		return instructionToCandidateSearchHandlerService;
	}

	public void setInstructionToCandidateSearchHandlerService(
			InstructionToCandidateSearchHandlerService instructionToCandidateSearchHandlerService) {
		this.instructionToCandidateSearchHandlerService = instructionToCandidateSearchHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}