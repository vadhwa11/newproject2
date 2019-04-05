package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.controller.MedicalBoardProceedingSearchDTO;

public interface MedicalBoardProceedingSearchHandlerService {

	Map<String, Object> showMedicalBoard();

	Map<String, Object> searchMedicalBoardProceeding(
			MedicalBoardProceedingSearchDTO medicalBoardDTO);

	Map<String, Object> showMedicalBoardForEmployee();

	Map<String, Object> searchMedicalBoardProceedingForEmployee(
			MedicalBoardProceedingSearchDTO medicalBoardDTO);

}
