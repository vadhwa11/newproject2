package jkt.hms.agendapoints.handler;

import java.util.Map;

import jkt.hms.agendapoints.controller.AgendaDTO;
import jkt.hms.agendapoints.dataservice.AgendaDataService;

public class AgendaHandlerServiceImpl implements AgendaHandlerService {
	private AgendaDataService agendaDataService = null;

	public Map<String, Object> showAgendaJsp() {
		return agendaDataService.showAgendaJsp();
	}

	public AgendaDataService getAgendaDataService() {
		return agendaDataService;
	}

	public void setAgendaDataService(AgendaDataService agendaDataService) {
		this.agendaDataService = agendaDataService;
	}

	public Map<String, Object> showMeetingScheduleJsp() {
		return agendaDataService.showMeetingScheduleJsp();
	}

	public boolean addAgendaPointsRequest(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return agendaDataService.addAgendaPointsRequest(map);
	}

	public Map<String, Object> searchAgendaRequest(Map<String, Object> map) {
		return agendaDataService.searchAgendaRequest(map);
	}

	public boolean deleteAgendaRequest(Map<String, Object> map) {
		return agendaDataService.deleteAgendaRequest(map);
	}

	public boolean editAgendaPointsRequest(Map<String, Object> map) {
		return agendaDataService.editAgendaPointsRequest(map);
	}

	public boolean addMeetingScheduled(Map<String, Object> map) {
		return agendaDataService.addMeetingScheduled(map);
	}

	public String generateMeetingNumber(String userName) {
		return agendaDataService.generateMeetingNumber(userName);
	}

	public Map<String, Object> showMeetingDetailsJsp(int id) {
		return agendaDataService.showMeetingDetailsJsp(id);
	}

	public Map<String, Object> searchAgendaMeetingDetailSearch(AgendaDTO map) {
		return agendaDataService.searchAgendaMeetingDetailSearch(map);
	}

	public Map<String, Object> showMeetingDetailSearchJsp() {
		return agendaDataService.showMeetingDetailSearchJsp();
	}

	public boolean editMeetingScheduled(Map<String, Object> map) {
		return agendaDataService.editMeetingScheduled(map);
	}

	public Map<String, Object> getConnectionForReport() {
		return agendaDataService.getConnectionForReport();
	}
}
