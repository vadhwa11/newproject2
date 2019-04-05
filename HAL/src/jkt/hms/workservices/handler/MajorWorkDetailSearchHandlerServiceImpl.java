package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.controller.MajorWorkDetailSearchDTO;
import jkt.hms.workservices.dataservice.MajorWorkDetailSearchDataService;

public class MajorWorkDetailSearchHandlerServiceImpl implements
		MajorWorkDetailSearchHandlerService {
	MajorWorkDetailSearchDataService majorWorkDetailSearchDataService = null;

	public Map<String, Object> showMajorWorkDetailSearchJsp() {
		return majorWorkDetailSearchDataService.showMajorWorkDetailSearchJsp();
	}

	public Map<String, Object> searchMajorWorkDetailSearch(
			MajorWorkDetailSearchDTO majorWorkDetailSearch) {
		return majorWorkDetailSearchDataService
				.searchMajorWorkDetailSearch(majorWorkDetailSearch);
	}

	// ------------------------------------------------------------

	public MajorWorkDetailSearchDataService getMajorWorkDetailSearchDataService() {
		return majorWorkDetailSearchDataService;
	}

	public void setMajorWorkDetailSearchDataService(
			MajorWorkDetailSearchDataService majorWorkDetailSearchDataService) {
		this.majorWorkDetailSearchDataService = majorWorkDetailSearchDataService;
	}

}
