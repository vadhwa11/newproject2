package jkt.hms.agendapoints.handler;

import java.util.Map;

import jkt.hms.agendapoints.controller.MomWorkDetailSearchDTO;

public interface MomWorkDetailSearchHandlerService {
	Map<String, Object> showMomWorkDetailSearchJsp();

	Map<String, Object> searchMomWorkDetailSearch(
			MomWorkDetailSearchDTO momWorkDetailSearch);
}
