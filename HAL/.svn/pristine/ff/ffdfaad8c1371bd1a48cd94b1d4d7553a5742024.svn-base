package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.controller.AgendaDTO;
import jkt.hms.workservices.dataservice.MinorWorkDetailSearchDataService;

public class MinorWorkDetailSearchHandlerServiceImpl implements
		MinorWorkDetailSearchHandlerService {
	MinorWorkDetailSearchDataService minorWorkDetailSearchDataService = null;

	public Map<String, Object> showMinorWorkDetailSearchJsp() {
		return minorWorkDetailSearchDataService.showMinorWorkDetailSearchJsp();
	}

	public Map<String, Object> searchMinorWorkDetailSearch(
			AgendaDTO minorWorkDetailSearch) {
		return minorWorkDetailSearchDataService
				.searchMinorWorkDetailSearch(minorWorkDetailSearch);
	}

	// ------------------------------------------------------------

	public MinorWorkDetailSearchDataService getMinorWorkDetailSearchDataService() {
		return minorWorkDetailSearchDataService;
	}

	public void setMinorWorkDetailSearchDataService(
			MinorWorkDetailSearchDataService minorWorkDetailSearchDataService) {
		this.minorWorkDetailSearchDataService = minorWorkDetailSearchDataService;
	}

}
