package jkt.hms.medicalboard.dataservice;

import java.util.Map;

import jkt.hms.medicalboard.controller.MedicalBoardProceedingsUpdateSearchDTO;

public interface MedicalBoardProceedingUpdateSearchDataService {
	Map<String, Object> showMedicalBoardSearchJsp();

	Map<String, Object> searchMedicalBoardProceedingSearch(
			MedicalBoardProceedingsUpdateSearchDTO medicalBoardProceedingsSearchDTO);
}
