package jkt.hms.agendapoints.handler;

import java.util.Map;

public interface AgendaReportHandlerService {

	Map<String, Object> showAgendaRegister();

	Map<String, Object> showMomRegister();

	public Map<String, Object> getConnectionForReport();

}
