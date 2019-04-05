package jkt.hms.medicalboard.dataservice;

import java.util.Map;

import jkt.hms.medicalboard.controller.MedicalBoardProceedingSearchDTO;

public interface MedicalBoardProceedingSearchDataService {

	Map<String, Object> showMedicalBoard();

	Map<String, Object> searchMedicalBoardProceeding(
			MedicalBoardProceedingSearchDTO medicalBoardDTO);

	Map<String, Object> showMedicalBoardForEmployee();

	Map<String, Object> searchMedicalBoardProceedingForEmployee(
			MedicalBoardProceedingSearchDTO medicalBoardDTO);

}
