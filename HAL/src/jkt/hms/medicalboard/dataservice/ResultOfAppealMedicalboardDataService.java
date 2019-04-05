package jkt.hms.medicalboard.dataservice;

import java.util.Map;

public interface ResultOfAppealMedicalboardDataService {
	public Map<String, Object> showResultOfAppealMedicalboardJsp();

	@SuppressWarnings("unchecked")
	public boolean addResultOfAppealMedicalboard(
			Map resultOfAppealMedicalboardno);

	public String generateResultOfAppealMedicalboardNo(String userName);

}
