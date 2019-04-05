package jkt.hms.agendapoints.handler;

import java.util.Map;

import jkt.hms.agendapoints.controller.AgendaPointUpdateSearchDTO;
import jkt.hms.agendapoints.dataservice.AgendaPointUpdateSearchDataService;

public class AgendaPointUpdateSearchHandlerServiceImpl implements
		AgendaPointUpdateSearchHandlerService {
	AgendaPointUpdateSearchDataService agendaPointUpdateSearchDataService = null;

	public Map<String, Object> showAgendaPointSearchJsp() {
		return agendaPointUpdateSearchDataService.showAgendaPointSearchJsp();

	}

	public Map<String, Object> searchAgendaPointSearch(
			AgendaPointUpdateSearchDTO agendaPointSearch) {
		return agendaPointUpdateSearchDataService
				.searchAgendaPointSearch(agendaPointSearch);
	}

	public AgendaPointUpdateSearchDataService getAgendaPointUpdateSearchDataService() {
		return agendaPointUpdateSearchDataService;
	}

	public void setAgendaPointUpdateSearchDataService(
			AgendaPointUpdateSearchDataService agendaPointUpdateSearchDataService) {
		this.agendaPointUpdateSearchDataService = agendaPointUpdateSearchDataService;
	}

}
