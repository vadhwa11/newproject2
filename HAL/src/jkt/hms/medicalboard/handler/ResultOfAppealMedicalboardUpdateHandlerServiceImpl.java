package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.dataservice.ResultOfAppealMedicalboardUpdateDataService;

public class ResultOfAppealMedicalboardUpdateHandlerServiceImpl implements
		ResultOfAppealMedicalboardUpdateHandlerService {
	ResultOfAppealMedicalboardUpdateDataService resultOfAppealMedicalboardsUpdateDataService = null;

	public Map<String, Object> showResultOfAppealMedicalboardUpdateJsp(int Id) {
		return resultOfAppealMedicalboardsUpdateDataService
				.showResultOfAppealMedicalboardUpdateJsp(Id);
	}

	public boolean editResultOfAppealMedicalboardUpdateToDatabase(
			Map<String, Object> generalMap) {
		return resultOfAppealMedicalboardsUpdateDataService
				.editResultOfAppealMedicalboardUpdateToDatabase(generalMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return resultOfAppealMedicalboardsUpdateDataService
				.getConnectionForReport();
	}

	// ------------------------------------------------------------

	public ResultOfAppealMedicalboardUpdateDataService getResultOfAppealMedicalboardUpdateDataService() {
		return resultOfAppealMedicalboardsUpdateDataService;
	}

	public void setResultOfAppealMedicalboardUpdateDataService(
			ResultOfAppealMedicalboardUpdateDataService resultOfAppealMedicalboardsUpdateDataService) {
		this.resultOfAppealMedicalboardsUpdateDataService = resultOfAppealMedicalboardsUpdateDataService;
	}

}
