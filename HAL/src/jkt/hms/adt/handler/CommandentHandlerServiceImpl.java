package jkt.hms.adt.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.adt.dataservice.CommandentDataService;
import jkt.hms.masters.business.Inpatient;

public class CommandentHandlerServiceImpl implements CommandentHandlerService {
	CommandentDataService commandentDataService = null;

	public CommandentDataService getCommandentDataService() {
		return commandentDataService;
	}

	public void setCommandentDataService(
			CommandentDataService commandentDataService) {
		this.commandentDataService = commandentDataService;
	}

	/**
	 * ---------------------------------- Today Admission and SIL/DIL
	 * ------------------------------------- made by Mansi Gagrani
	 * 
	 * @param generalMap
	 * @return
	 */
	public List<Inpatient> showTodayAdmission(Map<String, Object> map) {
		return commandentDataService.showTodayAdmission(map);
	}

	public List<Inpatient> showTodaySILDILJsp(Map<String, Object> map) {
		return commandentDataService.showTodaySILDILJsp(map);
	}

	/**
	 * ---------------------------------- ADT BED STATUS
	 * ------------------------------------- made by Priyanka Garg
	 * 
	 * @return
	 */

	public Map<String, Object> showBedStateJsp(Map<String, Object> generalMap) {
		return commandentDataService.showBedStateJsp(generalMap);
	}
}
