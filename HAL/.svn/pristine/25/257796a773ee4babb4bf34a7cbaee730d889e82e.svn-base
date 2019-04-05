package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.dataservice.MinorWorkDetailsUpdateDataService;

public class MinorWorkDetailsUpdateHandlerServiceImpl implements
		MinorWorkDetailsUpdateHandlerService {
	MinorWorkDetailsUpdateDataService minorWorkDetailsUpdateDataService = null;

	public Map<String, Object> showMinorWorkDetailsUpdateJsp(int Id) {
		return minorWorkDetailsUpdateDataService
				.showMinorWorkDetailsUpdateJsp(Id);
	}

	public boolean editMinorWorkDetailsUpdateToDatabase(
			Map<String, Object> generalMap) {
		return minorWorkDetailsUpdateDataService
				.editMinorWorkDetailsUpdateToDatabase(generalMap);
	}

	public boolean deleteMinorWorkDetailsUpdate(int minorWorkDetailId,
			Map<String, Object> generalMap) {
		return minorWorkDetailsUpdateDataService.deleteMinorWorkDetailsUpdate(
				minorWorkDetailId, generalMap);
	}

	// ------------------------------------------------------------

	public MinorWorkDetailsUpdateDataService getMinorWorkDetailsUpdateDataService() {
		return minorWorkDetailsUpdateDataService;
	}

	public void setMinorWorkDetailsUpdateDataService(
			MinorWorkDetailsUpdateDataService minorWorkDetailsUpdateDataService) {
		this.minorWorkDetailsUpdateDataService = minorWorkDetailsUpdateDataService;
	}

}
