package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.BATCH_NO;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHEST_NO;
import static jkt.hms.util.RequestConstants.ENTRY_DATE;
import static jkt.hms.util.RequestConstants.ENTRY_NO;
import static jkt.hms.util.RequestConstants.INSTRUCTION_TO_CANDIDATES_UPDATE_ID;
import static jkt.hms.util.RequestConstants.INSTRUCTION_TO_CANDIDATES_UPDATE_JSP;
import static jkt.hms.util.RequestConstants.INSTRUCTION_TO_CANDIDATE_DETAILS_SRNO;
import static jkt.hms.util.RequestConstants.INSTRUCTION_TO_CANDIDATE_SEARCH_JSP;
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
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.InstructionToCandidateSearchHandlerService;
import jkt.hms.medicalboard.handler.InstructionToCandidatesUpdateHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class InstructionToCandidatesUpdateController extends
		MultiActionController {

	private InstructionToCandidatesUpdateHandlerService instructionToCandidatesUpdateHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;
	private int instructionToCandidateId;
	InstructionToCandidateSearchHandlerService instructionToCandidateSearchHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showInstructionToCandidatesUpdateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		setInstructionToCandidateId(Integer.parseInt(request
				.getParameter("instructionToCandidateId")));
		int Id = getInstructionToCandidateId();
		Map map = new HashMap();
		map = instructionToCandidatesUpdateHandlerService
				.showInstructionToCandidatesUpdateJsp(Id);
		jsp = INSTRUCTION_TO_CANDIDATES_UPDATE_JSP;
		jsp += ".jsp";
		title = "Instruction To Candidate Update";
		map.put("Id", Id);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printMedicalBoard(HttpServletRequest request,
			HttpServletResponse response) {
		int Id = 1;
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = instructionToCandidatesUpdateHandlerService
				.getConnectionForReport();
		if (request.getParameter("Id") != null) {
			Id = Integer.parseInt(request.getParameter("Id"));

		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		parameters.put("id", Id);

		try {

			HMSUtil.generateReport("instructionCandidateReport", parameters,
					(java.sql.Connection) connectionMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editInstructionToCandidatesUpdate(
			HttpServletRequest request, HttpServletResponse response) {
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

		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<InstructionToCandidateUpdateDTO> mbUnfitExplanationList = new ArrayList<InstructionToCandidateUpdateDTO>();

		// get the vector of values for each table input field. size of vector
		// will depend on the no of rows added
		Box box = HMSUtil.getBox(request);
		Vector v1 = box.getVector("unfitExp");
		Vector v2 = box.getVector(INSTRUCTION_TO_CANDIDATES_UPDATE_ID);
		Vector v3 = box.getVector(INSTRUCTION_TO_CANDIDATE_DETAILS_SRNO);
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

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		for (int i = 0; i < v1.size(); i++) {
			InstructionToCandidateUpdateDTO instructionToCandidateUpdateDTO = new InstructionToCandidateUpdateDTO();
			// setting the values in the POJO
			instructionToCandidateUpdateDTO.setUnfitExplanation((String) v1
					.get(i));
			instructionToCandidateUpdateDTO.setId(v2.get(i).toString());
			instructionToCandidateUpdateDTO.setSrNo((Integer
					.parseInt((String) v3.get(i))));
			instructionToCandidateUpdateDTO.setLastChangedBy(lastChangedBy);
			instructionToCandidateUpdateDTO.setLastChangeDate(lastChangedDate);
			instructionToCandidateUpdateDTO.setLastChangeTime(lastChangedTime);
			instructionToCandidateUpdateDTO.setStatus("y");
			// Adding POJO to list based on this list values will be updated in
			// the
			// data service
			mbUnfitExplanationList.add(instructionToCandidateUpdateDTO);
		}
		masInstructionToCandidate.setEntryNo(Integer.parseInt(entryNo));
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
		generalMap.put("masInstructionToCandidate", masInstructionToCandidate);
		generalMap.put("id", getInstructionToCandidateId());
		List<MbInstructionToCandidateMaster> instructionToCandidateList = new ArrayList<MbInstructionToCandidateMaster>();
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		if (listMap.get("duplicateGeneralCodeList") != null) {
			instructionToCandidateList = (List) listMap
					.get("duplicateGeneralCodeList");
		}

		boolean successfullyUpdated = false;

		if ((instructionToCandidateList.size() == 0 || instructionToCandidateList == null)) {
			successfullyUpdated = instructionToCandidatesUpdateHandlerService
					.editInstructionToCandidatesUpdateToDatabase(generalMap);
			if (successfullyUpdated) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Try Again !!";
			}

		}

		else if ((instructionToCandidateList.size() != 0 || instructionToCandidateList != null)) {

			if ((instructionToCandidateList.size() != 0 || instructionToCandidateList != null)) {

				message = "Record already exists.";
			} else if ((instructionToCandidateList.size() == 0 || instructionToCandidateList == null)) {

				message = "Record already exists.";
			} else if ((instructionToCandidateList.size() != 0 || instructionToCandidateList != null)) {

				message = "Record already exists.";
			}
		}

		if (successfullyUpdated) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Try Again !!";
		}

		try {
			map = instructionToCandidateSearchHandlerService
					.showInstructionToCandidateSearchJsp();
		} catch (Exception e) {
		}
		jsp = INSTRUCTION_TO_CANDIDATE_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------------------------------------------------------------------------------------
	public InstructionToCandidatesUpdateHandlerService getInstructionToCandidatesUpdateHandlerService() {
		return instructionToCandidatesUpdateHandlerService;
	}

	public void setInstructionToCandidatesUpdateHandlerService(
			InstructionToCandidatesUpdateHandlerService instructionToCandidatesUpdateHandlerService) {
		this.instructionToCandidatesUpdateHandlerService = instructionToCandidatesUpdateHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public Integer getInstructionToCandidateId() {
		return instructionToCandidateId;
	}

	public void setInstructionToCandidateId(Integer instructionToCandidateId) {
		this.instructionToCandidateId = instructionToCandidateId;
	}

	public InstructionToCandidateSearchHandlerService getInstructionToCandidateSearchHandlerService() {
		return instructionToCandidateSearchHandlerService;
	}

	public void setInstructionToCandidateSearchHandlerService(
			InstructionToCandidateSearchHandlerService instructionToCandidateSearchHandlerService) {
		this.instructionToCandidateSearchHandlerService = instructionToCandidateSearchHandlerService;
	}

}
