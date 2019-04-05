package jkt.hms.workservices.dataservice;

import java.util.Map;

import jkt.hms.workservices.controller.AgendaDTO;

public interface MinorWorkDetailSearchForCompletionWorkDataService {

	Map<String, Object> showMinorWorkDetailSearchForCompletionWorkJsp();

	Map<String, Object> searchMinorWorkDetailSearchForCompletionWork(
			AgendaDTO minorWorkDetailSearchForCompletionWork);
}
