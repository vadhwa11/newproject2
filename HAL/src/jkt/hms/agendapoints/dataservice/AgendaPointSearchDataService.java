package jkt.hms.agendapoints.dataservice;

import java.util.Map;

import jkt.hms.agendapoints.controller.AgendaPointSearchDTO;

public interface AgendaPointSearchDataService {

	Map<String, Object> showAgendaPointSearchJsp();

	Map<String, Object> searchAgendaPointSearch(
			AgendaPointSearchDTO agendaPointSearch);
}
