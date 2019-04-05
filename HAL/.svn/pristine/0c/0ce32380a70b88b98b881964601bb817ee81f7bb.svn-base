package jkt.hms.agendapoints.handler;

import java.util.Map;

import jkt.hms.agendapoints.controller.AgendaPointSearchDTO;
import jkt.hms.agendapoints.dataservice.AgendaPointSearchDataService;

public class AgendaPointSearchHandlerServiceImpl implements
		AgendaPointSearchHandlerService {
	AgendaPointSearchDataService agendaPointSearchDataService = null;

	public Map<String, Object> showAgendaPointSearchJsp() {
		return agendaPointSearchDataService.showAgendaPointSearchJsp();
	}

	public Map<String, Object> searchAgendaPointSearch(
			AgendaPointSearchDTO agendaPointSearch) {
		return agendaPointSearchDataService
				.searchAgendaPointSearch(agendaPointSearch);
	}

	// ------------------------------------------------------------

	public AgendaPointSearchDataService getAgendaPointSearchDataService() {
		return agendaPointSearchDataService;
	}

	public void setAgendaPointSearchDataService(
			AgendaPointSearchDataService agendaPointSearchDataService) {
		this.agendaPointSearchDataService = agendaPointSearchDataService;
	}

}
