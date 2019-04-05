package jkt.hms.workservices.dataservice;

import java.util.Map;

import jkt.hms.workservices.controller.AgendaDTO;

public interface MinorWorkDetailSearchDataService {

	Map<String, Object> showMinorWorkDetailSearchJsp();

	Map<String, Object> searchMinorWorkDetailSearch(
			AgendaDTO minorWorkDetailSearch);

}
