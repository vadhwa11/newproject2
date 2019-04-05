package jkt.hms.agendapoints.handler;

import java.util.Map;

import jkt.hms.agendapoints.controller.AgendaPointUpdateSearchDTO;

public interface AgendaPointUpdateSearchHandlerService {
	Map<String, Object> showAgendaPointSearchJsp();

	Map<String, Object> searchAgendaPointSearch(
			AgendaPointUpdateSearchDTO agendaPointSearch);
}
