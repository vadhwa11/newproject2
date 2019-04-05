package jkt.hms.medicalboard.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalBoardDetails;
import jkt.hms.masters.business.MasMedicalBoardProceedings;
import jkt.hms.medicalboard.dataservice.MedicalBoardProceedingDataService;

public class MedicalBoardProceedingHandlerServiceImpl implements
		MedicalBoardProceedingHandlerService {
	MedicalBoardProceedingDataService medicalBoardProceedingDataService = null;

	public Map<String, Object> showMedicalBoardProceedingJsp(int Id) {
		// TODO Auto-generated method stub
		return medicalBoardProceedingDataService
				.showMedicalBoardProceedingJsp(Id);
	}

	public Map<String, Object> showMedicalBoardProceedingForEmployeeJsp(int Id) {
		// TODO Auto-generated method stub
		return medicalBoardProceedingDataService
				.showMedicalBoardProceedingForEmployeeJsp(Id);
	}

	public MedicalBoardProceedingDataService getMedicalBoardProceedingDataService() {
		return medicalBoardProceedingDataService;
	}

	public void setMedicalBoardProceedingDataService(
			MedicalBoardProceedingDataService medicalBoardProceedingDataService) {
		this.medicalBoardProceedingDataService = medicalBoardProceedingDataService;
	}

	public boolean addMedicalBoardProceeding(
			MasMedicalBoardProceedings masMedicalBoardProceedings,
			List<MasMedicalBoardDetails> masMedicalBoardDetails) {
		// TODO Auto-generated method stub
		return medicalBoardProceedingDataService.addMedicalBoardProceeding(
				masMedicalBoardProceedings, masMedicalBoardDetails);
	}

	public String generateMedicalEntryNumber(String userName) {
		// TODO Auto-generated method stub
		return medicalBoardProceedingDataService
				.generateMedicalEntryNumber(userName);
	}

}
