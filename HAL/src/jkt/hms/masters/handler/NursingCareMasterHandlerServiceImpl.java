package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.MasNursingCare;
import jkt.hms.masters.dataservice.NursingCareMasterDataService;

public class NursingCareMasterHandlerServiceImpl implements
		NursingCareMasterHandlerService {

	NursingCareMasterDataService nursingCareMasterDataService = null;

	public boolean addNursingCare(MasNursingCare masNursingCare) {
		return nursingCareMasterDataService.addNursingCare(masNursingCare);
	}

	public boolean deleteNursingCare(int nursingCareId,
			Map<String, Object> generalMap) {
		return nursingCareMasterDataService.deleteNursingCare(nursingCareId,
				generalMap);
	}

	public boolean editNursingCareToDatabase(Map<String, Object> generalMap) {
		return nursingCareMasterDataService
				.editNursingCareToDatabase(generalMap);
	}

	public Map<String, Object> searchNursingCare(String nursingCareCode,
			String nursingCareName) {
		return nursingCareMasterDataService.searchNursingCare(nursingCareCode,
				nursingCareName);
	}

	public Map<String, Object> showNursingCareJsp() {
		return nursingCareMasterDataService.showNursingCareJsp();
	}

	// ---------------------------------------------------------------------------------
	public NursingCareMasterDataService getNursingCareMasterDataService() {
		return nursingCareMasterDataService;
	}

	public void setNursingCareMasterDataService(
			NursingCareMasterDataService nursingCareMasterDataService) {
		this.nursingCareMasterDataService = nursingCareMasterDataService;
	}
}
