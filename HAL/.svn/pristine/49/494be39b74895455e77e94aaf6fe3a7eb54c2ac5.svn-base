package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks;
import jkt.hms.workservices.dataservice.AllotmentOfFundsForMinorWorkDataService;

public class AllotmentOfFundsForMinorWorkHandlerImpl implements
		AllotmentOfFundsForMinorWorkHandler {
	AllotmentOfFundsForMinorWorkDataService allotmentOfFundsForMinorWorkDataService = null;

	public Map<String, Object> showAllotmentOfFundsJsp() {
		return allotmentOfFundsForMinorWorkDataService
				.showAllotmentOfFundsJsp();
	}

	public boolean addAllotmentOfFunds(
			MasAllotmentOfFundsForMinorWorks masAllotmentOfFundsForMinorWorks) {
		return allotmentOfFundsForMinorWorkDataService
				.addAllotmentOfFunds(masAllotmentOfFundsForMinorWorks);
	}

	public Map<String, Object> searchAllotmentOfFunds(String allotmentFileNo) {
		return allotmentOfFundsForMinorWorkDataService
				.searchAllotmentOfFunds(allotmentFileNo);
	}

	public boolean editAllotmentOfFundsToDatabase(Map<String, Object> generalMap) {
		return allotmentOfFundsForMinorWorkDataService
				.editAllotmentOfFundsToDatabase(generalMap);
	}

	public boolean deleteAllotmentOfFundsToDatabase(int Id,
			Map<String, Object> generalMap) {
		return allotmentOfFundsForMinorWorkDataService
				.deleteAllotmentOfFundsToDatabase(Id, generalMap);
	}

	// ---------------------------------------------------------------------------------------------

	public AllotmentOfFundsForMinorWorkDataService getAllotmentOfFundsForMinorWorkDataService() {
		return allotmentOfFundsForMinorWorkDataService;
	}

	public void setAllotmentOfFundsForMinorWorkDataService(
			AllotmentOfFundsForMinorWorkDataService allotmentOfFundsForMinorWorkDataService) {
		this.allotmentOfFundsForMinorWorkDataService = allotmentOfFundsForMinorWorkDataService;
	}

}
