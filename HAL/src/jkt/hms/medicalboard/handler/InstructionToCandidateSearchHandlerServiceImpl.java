package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.controller.InstructionToCandidateSearchDTO;
import jkt.hms.medicalboard.dataservice.InstructionToCandidateSearchDataService;

public class InstructionToCandidateSearchHandlerServiceImpl implements
		InstructionToCandidateSearchHandlerService {
	InstructionToCandidateSearchDataService instructionToCandidateSearchDataService = null;

	public Map<String, Object> showInstructionToCandidateSearchJsp() {
		return instructionToCandidateSearchDataService
				.showInstructionToCandidateSearchJsp();
	}

	public Map<String, Object> searchInstructionToCandidateSearch(
			InstructionToCandidateSearchDTO instructionToCandidateSearch) {
		return instructionToCandidateSearchDataService
				.searchInstructionToCandidateSearch(instructionToCandidateSearch);
	}

	// ------------------------------------------------------------

	public InstructionToCandidateSearchDataService getInstructionToCandidateSearchDataService() {
		return instructionToCandidateSearchDataService;
	}

	public void setInstructionToCandidateSearchDataService(
			InstructionToCandidateSearchDataService instructionToCandidateSearchDataService) {
		this.instructionToCandidateSearchDataService = instructionToCandidateSearchDataService;
	}

}
