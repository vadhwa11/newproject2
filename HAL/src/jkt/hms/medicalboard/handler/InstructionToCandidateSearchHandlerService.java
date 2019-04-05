package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.controller.InstructionToCandidateSearchDTO;

public interface InstructionToCandidateSearchHandlerService {

	Map<String, Object> showInstructionToCandidateSearchJsp();

	Map<String, Object> searchInstructionToCandidateSearch(
			InstructionToCandidateSearchDTO instructionToCandidateSearch);

}
