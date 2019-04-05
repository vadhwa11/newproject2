package jkt.hms.medicalboard.handler;

import java.util.Map;

public interface ResultOfAppealMedicalboardHandlerService {
	public Map<String, Object> showResultOfAppealMedicalboardJsp();

	@SuppressWarnings("unchecked")
	public boolean addResultOfAppealMedicalboard(Map generalMap);

	public String generateResultOfAppealMedicalboardNo(String userName);

}
