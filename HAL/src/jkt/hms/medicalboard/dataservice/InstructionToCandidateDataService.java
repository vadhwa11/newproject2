package jkt.hms.medicalboard.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;

public interface InstructionToCandidateDataService {
	public Map<String, Object> showInstructionToCandidateJsp();

	@SuppressWarnings("unchecked")
	public boolean addInstructionToCandidate(Map instructionToCandidateno);

	public String generateMinorWorkNumber(String userName);

	public Map<String, List<MasMedicalExaminationReportOnEntry>> checkUnfitEntry(
			Map inMap);
}
