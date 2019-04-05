package jkt.hms.medicalboard.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalBoardDetails;
import jkt.hms.masters.business.MasMedicalBoardProceedings;

public interface MedicalBoardProceedingDataService {

	public Map<String, Object> showMedicalBoardProceedingJsp(int Id);

	public boolean addMedicalBoardProceeding(
			MasMedicalBoardProceedings masMedicalBoardProceedings,
			List<MasMedicalBoardDetails> masMedicalBoardDetails);

	public String generateMedicalEntryNumber(String userName);

	public Map<String, Object> showMedicalBoardProceedingForEmployeeJsp(int Id);

}
