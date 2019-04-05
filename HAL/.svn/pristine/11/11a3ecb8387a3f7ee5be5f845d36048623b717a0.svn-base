package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.BATCH_NO;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHEST_NO;
import static jkt.hms.util.RequestConstants.ENTRY_DATE;
import static jkt.hms.util.RequestConstants.ENTRY_NO;
import static jkt.hms.util.RequestConstants.INSTRUCTION_TO_CANDIDATE_DETAILS_SRNO;
import static jkt.hms.util.RequestConstants.INSTRUCTION_TO_CANDIDATE_JSP;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_ERROR_MSG;
import static jkt.hms.util.RequestConstants.NAME;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.business.MbInstructionToCandidateMaster;
import jkt.hms.masters.business.MbInstructionToCandidateUnfitExpl;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.InstructionToCandidateHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class InstructionToCandidateController extends MultiActionController {
	private InstructionToCandidateHandlerService instructionToCandidatehandlerservice = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;

	public ModelAndView showInstructionToCandidateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String entryNo = "";
		String lastChangedBy = "";
		if (request.getParameter(CHANGED_BY) != null) {
			lastChangedBy = request.getParameter(CHANGED_BY);
		}
		map = instructionToCandidatehandlerservice
				.showInstructionToCandidateJsp();
		entryNo = instructionToCandidatehandlerservice
				.generateMinorWorkNumber(lastChangedBy);
		map.put("entryNo", entryNo);
		jsp = INSTRUCTION_TO_CANDIDATE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addInstructionToCandidate(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> map = new HashMap<String, Object>();
		String entryNo = "";
		String entryDate = null;
		String batchNo = "";
		String chestNo = "";
		String name = "";
		String jsp = "";
		String title = "";
		String message = "";
		String lastChangedBy = "";
		String lastChangedTime = "";
		Date lastChangedDate = null;
		Map<String, Object> listMap = new HashMap<String, Object>();
		MbInstructionToCandidateMaster masInstructionToCandidate = new MbInstructionToCandidateMaster();
		// initializing box with the request to get the values from the inner
		// table
		Box box = HMSUtil.getBox(req);

		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<MbInstructionToCandidateUnfitExpl> mbUnfitExplanationList = new ArrayList<MbInstructionToCandidateUnfitExpl>();

		// get the vector of values for each table input field. size of vector
		// will depend on the no of rows added

		Vector v1 = box.getVector("unfit");
		Vector v2 = box.getVector(INSTRUCTION_TO_CANDIDATE_DETAILS_SRNO);
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
		generalMap.put("code", entryNo);
		generalMap.put("pojoPropertyCode", "EntryNo");

		generalMap.put("pojoName", "MasMedicalBoardProceedings");
		generalMap.put("batchNo", batchNo);
		generalMap.put("chestNo", chestNo);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		Boolean successfullyAdded = false;
		List codeList = (List) listMap.get("duplicateGeneralCodeList");
		Map unfitMap = (Map) instructionToCandidatehandlerservice
				.checkUnfitEntry(generalMap);
		List unfitList = (List) unfitMap.get("unfitList");
		if (codeList != null && codeList.size() > 0) {
			message = "Entry No Already Exist!";
			jsp = MEDICAL_BOARD_ERROR_MSG;
		} else if (unfitList == null && unfitList.size() == 0) {
			message = "The Batch no and Chest No You have enter is ot a Unfit candidate!";
			jsp = MEDICAL_BOARD_ERROR_MSG;
		} else {
			for (int i = 0; i < v1.size(); i++) {
				MbInstructionToCandidateUnfitExpl mbInstructionToCandidateUnfitExpl = new MbInstructionToCandidateUnfitExpl();
				// setting the values in the POJO
				mbInstructionToCandidateUnfitExpl
						.setUnfitExplanation((String) v1.get(i));
				mbInstructionToCandidateUnfitExpl.setSrNo(Integer
						.parseInt((String) v2.get(i)));
				mbInstructionToCandidateUnfitExpl.setLastChgBy(lastChangedBy);
				mbInstructionToCandidateUnfitExpl
						.setLastChgDate(lastChangedDate);
				mbInstructionToCandidateUnfitExpl
						.setLastChgTime(lastChangedTime);
				mbInstructionToCandidateUnfitExpl.setStatus("y");
				// Adding POJO to list based on this list values will be updated
				// in the data service
				mbUnfitExplanationList.add(mbInstructionToCandidateUnfitExpl);
			}
			if (entryNo.equalsIgnoreCase("")) {
				masInstructionToCandidate.setEntryNo(0);
			} else {
				masInstructionToCandidate.setEntryNo(Integer.parseInt(entryNo));
			}
			masInstructionToCandidate.setEntryDate(HMSUtil
					.convertStringTypeDateToDateType(entryDate));
			masInstructionToCandidate.setBatchNo(batchNo);
			masInstructionToCandidate.setChestNo(chestNo);
			masInstructionToCandidate.setName(name);
			masInstructionToCandidate.setLastChgBy(lastChangedBy);
			masInstructionToCandidate.setLastChgDate(lastChangedDate);
			masInstructionToCandidate.setLastChgTime(lastChangedTime);
			masInstructionToCandidate.setStatus("y");
			generalMap.put("mbUnfitExplanationList", mbUnfitExplanationList);
			generalMap.put("masInstructionToCandidate",
					masInstructionToCandidate);
			List<MbInstructionToCandidateMaster> instructionToCandidateList = new ArrayList<MbInstructionToCandidateMaster>();

			successfullyAdded = instructionToCandidatehandlerservice
					.addInstructionToCandidate(generalMap);
			if (successfullyAdded) {
				message = "Record added successfully! Do You Want To Print?";
				jsp = RequestConstants.MEDICAL_BOARD_INSTRUCTION_MSG;
			} else {
				message = "Record already exixt for this batch no and chest no";
				jsp = RequestConstants.MEDICAL_BOARD_ERROR_MSG;
			}
		}
		try {
			map = instructionToCandidatehandlerservice
					.showInstructionToCandidateJsp();
		} catch (Exception e) {
		}
		entryNo = instructionToCandidatehandlerservice
				.generateMinorWorkNumber(lastChangedBy);
		map.put("entryNo", entryNo);

		title = "Instruction To Candidate Founf Unfit By Special Medical Board";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public InstructionToCandidateHandlerService getMinorworkdetailhandlerservice() {
		return instructionToCandidatehandlerservice;
	}

	public void setInstructionToCandidateHandlerService(
			InstructionToCandidateHandlerService instructionToCandidatehandlerservice) {
		this.instructionToCandidatehandlerservice = instructionToCandidatehandlerservice;
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
