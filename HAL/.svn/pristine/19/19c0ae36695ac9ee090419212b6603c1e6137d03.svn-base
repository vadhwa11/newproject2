package jkt.hms.medicalboard.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.medicalboard.dataservice.InstructionToCandidateDataService;

public class InstructionToCandidateHandlerServiceImpl implements
		InstructionToCandidateHandlerService {
	InstructionToCandidateDataService instructionToCandidatedataservice = null;

	public Map<String, Object> showInstructionToCandidateJsp() {
		return instructionToCandidatedataservice
				.showInstructionToCandidateJsp();
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public boolean addInstructionToCandidate(Map instructionToCandidateno) {
		return instructionToCandidatedataservice
				.addInstructionToCandidate(instructionToCandidateno);
	}

	public InstructionToCandidateDataService getMinorworkdetaildataservice() {
		return instructionToCandidatedataservice;
	}

	public void setInstructionToCandidateDataService(
			InstructionToCandidateDataService instructionToCandidatedataservice) {
		this.instructionToCandidatedataservice = instructionToCandidatedataservice;
	}

	public String generateMinorWorkNumber(String userName) {
		return instructionToCandidatedataservice
				.generateMinorWorkNumber(userName);
	}

	public Map<String, List<MasMedicalExaminationReportOnEntry>> checkUnfitEntry(
			Map inMap) {
		return instructionToCandidatedataservice.checkUnfitEntry(inMap);
	}

}
