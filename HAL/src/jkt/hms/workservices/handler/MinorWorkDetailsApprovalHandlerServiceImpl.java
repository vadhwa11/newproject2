package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.controller.AgendaDTO;
import jkt.hms.workservices.dataservice.MinorWorkDetailsApprovalDataService;

public class MinorWorkDetailsApprovalHandlerServiceImpl implements
		MinorWorkDetailsApprovalHandlerService {
	MinorWorkDetailsApprovalDataService minorWorkDetailsApprovalDataService = null;

	public Map<String, Object> showMinorWorkDetailsApprovalJsp() {
		return minorWorkDetailsApprovalDataService
				.showMinorWorkDetailsApprovalJsp();
	}

	public Map<String, Object> searchMinorWorkDetailsApproval(
			AgendaDTO minorWorkDetailsApproval) {
		return minorWorkDetailsApprovalDataService
				.searchMinorWorkDetailsApproval(minorWorkDetailsApproval);
	}

	// ------------------------------------------------------------

	public MinorWorkDetailsApprovalDataService getMinorWorkDetailsApprovalDataService() {
		return minorWorkDetailsApprovalDataService;
	}

	public void setMinorWorkDetailsApprovalDataService(
			MinorWorkDetailsApprovalDataService minorWorkDetailsApprovalDataService) {
		this.minorWorkDetailsApprovalDataService = minorWorkDetailsApprovalDataService;
	}

}
