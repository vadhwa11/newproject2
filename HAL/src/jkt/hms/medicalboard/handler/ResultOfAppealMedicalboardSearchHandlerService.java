package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.controller.ResultOfAppealMedicalboardSearchDTO;

public interface ResultOfAppealMedicalboardSearchHandlerService {

	Map<String, Object> showResultOfAppealMedicalboardSearchJsp();

	Map<String, Object> searchResultOfAppealMedicalboardSearch(
			ResultOfAppealMedicalboardSearchDTO resultOfAppealMedicalboardSearch);

}
