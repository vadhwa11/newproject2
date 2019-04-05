package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.controller.MedicalBoardProceedingSearchDTO;
import jkt.hms.medicalboard.dataservice.MedicalBoardProceedingSearchDataService;

public class MedicalBoardProceedingSearchHandlerServiceImpl implements
		MedicalBoardProceedingSearchHandlerService {
	MedicalBoardProceedingSearchDataService medicalBoardProceedingSearchDataService = null;

	public Map<String, Object> showMedicalBoard() {
		// TODO Auto-generated method stub
		return medicalBoardProceedingSearchDataService.showMedicalBoard();
	}

	public Map<String, Object> showMedicalBoardForEmployee() {
		// TODO Auto-generated method stub
		return medicalBoardProceedingSearchDataService.showMedicalBoard();
	}

	public MedicalBoardProceedingSearchDataService getMedicalBoardProceedingSearchDataService() {
		return medicalBoardProceedingSearchDataService;
	}

	public void setMedicalBoardProceedingSearchDataService(
			MedicalBoardProceedingSearchDataService medicalBoardProceedingSearchDataService) {
		this.medicalBoardProceedingSearchDataService = medicalBoardProceedingSearchDataService;
	}

	public Map<String, Object> searchMedicalBoardProceeding(
			MedicalBoardProceedingSearchDTO medicalBoardDTO) {
		// TODO Auto-generated method stub
		return medicalBoardProceedingSearchDataService
				.searchMedicalBoardProceeding(medicalBoardDTO);
	}

	public Map<String, Object> searchMedicalBoardProceedingForEmployee(
			MedicalBoardProceedingSearchDTO medicalBoardDTO) {
		// TODO Auto-generated method stub
		return medicalBoardProceedingSearchDataService
				.searchMedicalBoardProceedingForEmployee(medicalBoardDTO);
	}

}
