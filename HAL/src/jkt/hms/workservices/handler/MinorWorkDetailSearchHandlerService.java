package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.controller.AgendaDTO;

public interface MinorWorkDetailSearchHandlerService {

	Map<String, Object> showMinorWorkDetailSearchJsp();

	Map<String, Object> searchMinorWorkDetailSearch(
			AgendaDTO minorWorkDetailSearch);

}
