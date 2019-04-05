package jkt.hms.agendapoints.handler;

import java.util.Map;

public interface UpdateAgendaPointsHandlerService {
	Map<String, Object> showUpdateAgendaPointsForWorkServicesJsp(int Id);

	boolean editUpdateAgendaPointsForWorkServicesToDatabase(
			Map<String, Object> generalMap);
}
