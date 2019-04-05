package jkt.hms.medicalboard.dataservice;

import java.util.Map;

public interface MedicalBoardProceedingUpdateDataService {
	public Map<String, Object> showMedicalBoardUpdateJsp(int Id);

	public boolean medicalBoardUpdateToDatabase(Map<String, Object> generalMap);

	public Map<String, Object> getConnectionForReport();
}
