package jkt.hms.agendapoints.handler;

import java.util.Map;

import jkt.hms.agendapoints.controller.MomWorkDetailSearchDTO;
import jkt.hms.agendapoints.dataservice.MomWorkDetailSearchDataService;

public class MomWorkDetailSearchHandlerServiceImpl implements
		MomWorkDetailSearchHandlerService {
	MomWorkDetailSearchDataService momWorkDetailSearchDataService = null;

	public Map<String, Object> showMomWorkDetailSearchJsp() {
		return momWorkDetailSearchDataService.showMomWorkDetailSearchJsp();
	}

	public Map<String, Object> searchMomWorkDetailSearch(
			MomWorkDetailSearchDTO momWorkDetailSearch) {
		return momWorkDetailSearchDataService
				.searchMomWorkDetailSearch(momWorkDetailSearch);
	}

	// ------------------------------------------------------------

	public MomWorkDetailSearchDataService getMomWorkDetailSearchDataService() {
		return momWorkDetailSearchDataService;
	}

	public void setMomWorkDetailSearchDataService(
			MomWorkDetailSearchDataService momWorkDetailSearchDataService) {
		this.momWorkDetailSearchDataService = momWorkDetailSearchDataService;
	}

}
