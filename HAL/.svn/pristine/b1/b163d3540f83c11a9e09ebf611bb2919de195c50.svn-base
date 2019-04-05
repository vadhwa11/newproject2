package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.MasNursingCare;

public interface NursingCareMasterHandlerService {

	Map<String, Object> showNursingCareJsp();

	Map<String, Object> searchNursingCare(String nursingCareCode,
			String nursingCareName);

	boolean addNursingCare(MasNursingCare masNursingCare);

	boolean editNursingCareToDatabase(Map<String, Object> generalMap);

	boolean deleteNursingCare(int nursingCareId, Map<String, Object> generalMap);

}
