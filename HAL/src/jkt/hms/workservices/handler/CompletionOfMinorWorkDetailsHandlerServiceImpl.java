package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.dataservice.CompletionOfMinorWorkDetailsDataService;

public class CompletionOfMinorWorkDetailsHandlerServiceImpl implements
		CompletionOfMinorWorkDetailsHandlerService {
	CompletionOfMinorWorkDetailsDataService completionOfMinorWorkDetailsDataService = null;

	public Map<String, Object> showCompletionOfMinorWorkDetailsJsp(int Id) {
		return completionOfMinorWorkDetailsDataService
				.showCompletionOfMinorWorkDetailsJsp(Id);
	}

	public String generateCompletionNumber(String userName) {

		return completionOfMinorWorkDetailsDataService
				.generateCompletionNumber(userName);
	}

	public boolean editCompletionOfMinorWorkDetailsToDatabase(
			Map<String, Object> generalMap) {
		return completionOfMinorWorkDetailsDataService
				.editCompletionOfMinorWorkDetailsToDatabase(generalMap);
	}

	// ------------------------------------------------------------

	public CompletionOfMinorWorkDetailsDataService getCompletionOfMinorWorkDetailsDataService() {
		return completionOfMinorWorkDetailsDataService;
	}

	public void setCompletionOfMinorWorkDetailsDataService(
			CompletionOfMinorWorkDetailsDataService completionOfMinorWorkDetailsDataService) {
		this.completionOfMinorWorkDetailsDataService = completionOfMinorWorkDetailsDataService;
	}

}
