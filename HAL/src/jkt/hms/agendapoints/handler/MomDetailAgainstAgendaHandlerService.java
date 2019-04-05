package jkt.hms.agendapoints.handler;

import java.util.Map;

public interface MomDetailAgainstAgendaHandlerService {
	public Map<String, Object> showMomDetailAgainstAgendaJsp(int Id);

	boolean addMomDetailAgainstAgenda(Map<String, Object> generalMap);

	public String generateMomNumber(String userName);
}
