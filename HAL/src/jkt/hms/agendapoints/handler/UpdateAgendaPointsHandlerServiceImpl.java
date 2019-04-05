package jkt.hms.agendapoints.handler;

import java.util.Map;

import jkt.hms.agendapoints.dataservice.UpdateAgendaPointsDataService;

public class UpdateAgendaPointsHandlerServiceImpl implements
		UpdateAgendaPointsHandlerService {
	UpdateAgendaPointsDataService updateAgendaPointsDataService = null;

	public Map<String, Object> showUpdateAgendaPointsForWorkServicesJsp(int Id) {
		return updateAgendaPointsDataService
				.showUpdateAgendaPointsForWorkServicesJsp(Id);
	}

	public boolean editUpdateAgendaPointsForWorkServicesToDatabase(
			Map<String, Object> generalMap) {
		return updateAgendaPointsDataService
				.editUpdateAgendaPointsForWorkServicesToDatabase(generalMap);
	}

	public UpdateAgendaPointsDataService getUpdateAgendaPointsDataService() {
		return updateAgendaPointsDataService;
	}

	public void setUpdateAgendaPointsDataService(
			UpdateAgendaPointsDataService updateAgendaPointsDataService) {
		this.updateAgendaPointsDataService = updateAgendaPointsDataService;
	}

}
