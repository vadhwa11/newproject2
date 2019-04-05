package jkt.hms.agendapoints.dataservice;

import java.util.Map;

import jkt.hms.agendapoints.controller.AgendaDTO;

public interface AgendaDataService {

	Map<String, Object> showAgendaJsp();

	public boolean addAgendaPointsRequest(Map<String, Object> map);

	public Map<String, Object> showMeetingScheduleJsp();

	public Map<String, Object> searchAgendaRequest(Map<String, Object> map);

	public boolean deleteAgendaRequest(Map<String, Object> map);

	public boolean editAgendaPointsRequest(Map<String, Object> map);

	public boolean addMeetingScheduled(Map<String, Object> map);

	public String generateMeetingNumber(String userName);

	public Map<String, Object> showMeetingDetailsJsp(int id);

	public Map<String, Object> searchAgendaMeetingDetailSearch(AgendaDTO map);

	public Map<String, Object> showMeetingDetailSearchJsp();

	public boolean editMeetingScheduled(Map<String, Object> map);

	// connection method for print
	public Map<String, Object> getConnectionForReport();
}
