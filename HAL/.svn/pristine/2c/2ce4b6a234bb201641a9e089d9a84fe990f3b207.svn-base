package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.dataservice.InstructionToCandidatesUpdateDataService;

public class InstructionToCandidatesUpdateHandlerServiceImpl implements
		InstructionToCandidatesUpdateHandlerService {
	InstructionToCandidatesUpdateDataService instructionToCandidatesUpdateDataService = null;

	public Map<String, Object> showInstructionToCandidatesUpdateJsp(int Id) {
		return instructionToCandidatesUpdateDataService
				.showInstructionToCandidatesUpdateJsp(Id);
	}

	public boolean editInstructionToCandidatesUpdateToDatabase(
			Map<String, Object> generalMap) {
		return instructionToCandidatesUpdateDataService
				.editInstructionToCandidatesUpdateToDatabase(generalMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return instructionToCandidatesUpdateDataService
				.getConnectionForReport();
	}

	// ------------------------------------------------------------

	public InstructionToCandidatesUpdateDataService getInstructionToCandidatesUpdateDataService() {
		return instructionToCandidatesUpdateDataService;
	}

	public void setInstructionToCandidatesUpdateDataService(
			InstructionToCandidatesUpdateDataService instructionToCandidatesUpdateDataService) {
		this.instructionToCandidatesUpdateDataService = instructionToCandidatesUpdateDataService;
	}

}
