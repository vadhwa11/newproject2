package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.controller.AgendaDTO;
import jkt.hms.workservices.dataservice.MinorWorkDetailSearchForCompletionWorkDataService;

public class MinorWorkDetailSearchForCompletionWorkHandlerServiceImpl implements
		MinorWorkDetailSearchForCompletionWorkHandlerService {
	MinorWorkDetailSearchForCompletionWorkDataService minorWorkDetailSearchForCompletionWorkDataService = null;

	public Map<String, Object> showMinorWorkDetailSearchForCompletionWorkJsp() {
		return minorWorkDetailSearchForCompletionWorkDataService
				.showMinorWorkDetailSearchForCompletionWorkJsp();
	}

	public Map<String, Object> searchMinorWorkDetailSearchForCompletionWork(
			AgendaDTO minorWorkDetailSearchForCompletionWork) {
		return minorWorkDetailSearchForCompletionWorkDataService
				.searchMinorWorkDetailSearchForCompletionWork(minorWorkDetailSearchForCompletionWork);
	}

	// ------------------------------------------------------------

	public MinorWorkDetailSearchForCompletionWorkDataService getMinorWorkDetailSearchForCompletionWorkDataService() {
		return minorWorkDetailSearchForCompletionWorkDataService;
	}

	public void setMinorWorkDetailSearchForCompletionWorkDataService(
			MinorWorkDetailSearchForCompletionWorkDataService minorWorkDetailSearchForCompletionWorkDataService) {
		this.minorWorkDetailSearchForCompletionWorkDataService = minorWorkDetailSearchForCompletionWorkDataService;
	}

}
