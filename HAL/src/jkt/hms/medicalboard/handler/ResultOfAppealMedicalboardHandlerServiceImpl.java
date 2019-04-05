package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.dataservice.ResultOfAppealMedicalboardDataService;

public class ResultOfAppealMedicalboardHandlerServiceImpl implements
		ResultOfAppealMedicalboardHandlerService {
	ResultOfAppealMedicalboardDataService resultOfAppealMedicalboarddataservice = null;

	public Map<String, Object> showResultOfAppealMedicalboardJsp() {
		return resultOfAppealMedicalboarddataservice
				.showResultOfAppealMedicalboardJsp();
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public boolean addResultOfAppealMedicalboard(
			Map resultOfAppealMedicalboardno) {
		return resultOfAppealMedicalboarddataservice
				.addResultOfAppealMedicalboard(resultOfAppealMedicalboardno);
	}

	public ResultOfAppealMedicalboardDataService getMinorworkdetaildataservice() {
		return resultOfAppealMedicalboarddataservice;
	}

	public void setResultOfAppealMedicalboardDataService(
			ResultOfAppealMedicalboardDataService resultOfAppealMedicalboarddataservice) {
		this.resultOfAppealMedicalboarddataservice = resultOfAppealMedicalboarddataservice;
	}

	public String generateResultOfAppealMedicalboardNo(String userName) {
		return resultOfAppealMedicalboarddataservice
				.generateResultOfAppealMedicalboardNo(userName);
	}

}
