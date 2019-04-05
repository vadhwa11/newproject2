package jkt.hms.medicalboard.handler;

import java.util.Map;

public interface InstructionToCandidatesUpdateHandlerService {

	Map<String, Object> showInstructionToCandidatesUpdateJsp(int Id);

	boolean editInstructionToCandidatesUpdateToDatabase(
			Map<String, Object> generalMap);

	// connection method for print
	public Map<String, Object> getConnectionForReport();
}
