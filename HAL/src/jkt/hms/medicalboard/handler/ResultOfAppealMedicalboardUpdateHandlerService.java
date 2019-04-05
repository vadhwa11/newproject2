package jkt.hms.medicalboard.handler;

import java.util.Map;

public interface ResultOfAppealMedicalboardUpdateHandlerService {

	Map<String, Object> showResultOfAppealMedicalboardUpdateJsp(int Id);

	boolean editResultOfAppealMedicalboardUpdateToDatabase(
			Map<String, Object> generalMap);

	// connection method for print
	public Map<String, Object> getConnectionForReport();
}
