package jkt.hms.medicalboard.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;

public interface InstructionToCandidateHandlerService {
	public Map<String, Object> showInstructionToCandidateJsp();

	@SuppressWarnings("unchecked")
	public boolean addInstructionToCandidate(Map generalMap);

	public String generateMinorWorkNumber(String userName);

	public Map<String, List<MasMedicalExaminationReportOnEntry>> checkUnfitEntry(
			Map inMap);

}
