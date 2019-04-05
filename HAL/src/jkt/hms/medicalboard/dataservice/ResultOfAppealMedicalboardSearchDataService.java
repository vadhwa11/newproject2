package jkt.hms.medicalboard.dataservice;

import java.util.Map;

import jkt.hms.medicalboard.controller.ResultOfAppealMedicalboardSearchDTO;

public interface ResultOfAppealMedicalboardSearchDataService {

	Map<String, Object> showResultOfAppealMedicalboardSearchJsp();

	Map<String, Object> searchResultOfAppealMedicalboardSearch(
			ResultOfAppealMedicalboardSearchDTO resultOfAppealMedicalboardSearch);

}
