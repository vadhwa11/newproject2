package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.controller.MedicalBoardProceedingsUpdateSearchDTO;
import jkt.hms.medicalboard.dataservice.MedicalBoardProceedingUpdateSearchDataService;

public class MedicalBoardProceedingUpdateSearchHandlerServiceImpl implements
		MedicalBoardProceedingUpdateSearchHandlerService {
	MedicalBoardProceedingUpdateSearchDataService medicalBoardProceedingUpdateSearchDataService = null;

	public Map<String, Object> showMedicalBoardSearchJsp() {
		return medicalBoardProceedingUpdateSearchDataService
				.showMedicalBoardSearchJsp();
	}

	public Map<String, Object> searchMedicalBoardProceedingSearch(
			MedicalBoardProceedingsUpdateSearchDTO medicalBoardProceedingsSearchDTO) {
		return medicalBoardProceedingUpdateSearchDataService
				.searchMedicalBoardProceedingSearch(medicalBoardProceedingsSearchDTO);
	}

	public MedicalBoardProceedingUpdateSearchDataService getMedicalBoardProceedingUpdateSearchDataService() {
		return medicalBoardProceedingUpdateSearchDataService;
	}

	public void setMedicalBoardProceedingUpdateSearchDataService(
			MedicalBoardProceedingUpdateSearchDataService medicalBoardProceedingUpdateSearchDataService) {
		this.medicalBoardProceedingUpdateSearchDataService = medicalBoardProceedingUpdateSearchDataService;
	}

}
