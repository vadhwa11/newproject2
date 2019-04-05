package jkt.hms.agendapoints.dataservice;

import java.util.Map;

public interface UpdateAgendaPointsDataService {
	Map<String, Object> showUpdateAgendaPointsForWorkServicesJsp(int Id);

	boolean editUpdateAgendaPointsForWorkServicesToDatabase(
			Map<String, Object> generalMap);
}
