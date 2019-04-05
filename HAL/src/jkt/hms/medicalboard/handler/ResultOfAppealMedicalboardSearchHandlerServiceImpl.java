package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.controller.ResultOfAppealMedicalboardSearchDTO;
import jkt.hms.medicalboard.dataservice.ResultOfAppealMedicalboardSearchDataService;

public class ResultOfAppealMedicalboardSearchHandlerServiceImpl implements
		ResultOfAppealMedicalboardSearchHandlerService {
	ResultOfAppealMedicalboardSearchDataService resultOfAppealMedicalboardSearchDataService = null;

	public Map<String, Object> showResultOfAppealMedicalboardSearchJsp() {
		return resultOfAppealMedicalboardSearchDataService
				.showResultOfAppealMedicalboardSearchJsp();
	}

	public Map<String, Object> searchResultOfAppealMedicalboardSearch(
			ResultOfAppealMedicalboardSearchDTO resultOfAppealMedicalboardSearch) {
		return resultOfAppealMedicalboardSearchDataService
				.searchResultOfAppealMedicalboardSearch(resultOfAppealMedicalboardSearch);
	}

	// ------------------------------------------------------------

	public ResultOfAppealMedicalboardSearchDataService getResultOfAppealMedicalboardSearchDataService() {
		return resultOfAppealMedicalboardSearchDataService;
	}

	public void setResultOfAppealMedicalboardSearchDataService(
			ResultOfAppealMedicalboardSearchDataService resultOfAppealMedicalboardSearchDataService) {
		this.resultOfAppealMedicalboardSearchDataService = resultOfAppealMedicalboardSearchDataService;
	}

}
