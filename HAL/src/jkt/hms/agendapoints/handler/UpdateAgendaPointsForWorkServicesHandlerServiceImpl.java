package jkt.hms.agendapoints.handler;

import java.util.Map;

import jkt.hms.agendapoints.dataservice.UpdateAgendaPointsForWorkServicesDataService;

public class UpdateAgendaPointsForWorkServicesHandlerServiceImpl implements
		UpdateAgendaPointsForWorkServicesHandlerService {
	UpdateAgendaPointsForWorkServicesDataService updateAgendaPointsForWorkServicesDataService = null;

	public Map<String, Object> showUpdateAgendaPointsForWorkServicesJsp(int Id) {
		return updateAgendaPointsForWorkServicesDataService
				.showUpdateAgendaPointsForWorkServicesJsp(Id);
	}

	public boolean editUpdateAgendaPointsForWorkServicesToDatabase(
			Map<String, Object> generalMap) {
		return updateAgendaPointsForWorkServicesDataService
				.editUpdateAgendaPointsForWorkServicesToDatabase(generalMap);
	}

	// ------------------------------------------------------------

	public UpdateAgendaPointsForWorkServicesDataService getUpdateAgendaPointsForWorkServicesDataService() {
		return updateAgendaPointsForWorkServicesDataService;
	}

	public void setUpdateAgendaPointsForWorkServicesDataService(
			UpdateAgendaPointsForWorkServicesDataService updateAgendaPointsForWorkServicesDataService) {
		this.updateAgendaPointsForWorkServicesDataService = updateAgendaPointsForWorkServicesDataService;
	}

}
