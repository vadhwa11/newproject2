package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.dataservice.MedicalBoardProceedingUpdateDataService;

public class MedicalBoardProceedingUpdateHandlerServiceImpl implements
		MedicalBoardProceedingUpdateHandlerService {
	MedicalBoardProceedingUpdateDataService medicalBoardProceedingUpdateDataService = null;

	public Map<String, Object> showMedicalBoardUpdateJsp(int Id) {

		return medicalBoardProceedingUpdateDataService
				.showMedicalBoardUpdateJsp(Id);
	}

	public boolean medicalBoardUpdateToDatabase(Map<String, Object> generalMap) {
		return medicalBoardProceedingUpdateDataService
				.medicalBoardUpdateToDatabase(generalMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return medicalBoardProceedingUpdateDataService.getConnectionForReport();
	}

	public MedicalBoardProceedingUpdateDataService getMedicalBoardProceedingUpdateDataService() {
		return medicalBoardProceedingUpdateDataService;
	}

	public void setMedicalBoardProceedingUpdateDataService(
			MedicalBoardProceedingUpdateDataService medicalBoardProceedingUpdateDataService) {
		this.medicalBoardProceedingUpdateDataService = medicalBoardProceedingUpdateDataService;
	}

}
