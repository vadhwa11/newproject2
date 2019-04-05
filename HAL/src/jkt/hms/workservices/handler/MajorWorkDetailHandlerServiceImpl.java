package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.dataservice.MajorWorkDetailDataService;

public class MajorWorkDetailHandlerServiceImpl implements
		MajorWorkDetailHandlerService {
	MajorWorkDetailDataService majorworkdetaildataservice = null;

	public Map<String, Object> showMajorWorkDetailJsp() {

		return majorworkdetaildataservice.showMajorWorkDetailJsp();
	}

	public Map<String, Object> showMajorWorkDetailStatusMessageJsp() {

		return majorworkdetaildataservice.showMajorWorkDetailStatusMessageJsp();
	}

	public boolean addMajorWorkDetail(Map<String, Object> generalMap) {
		return majorworkdetaildataservice.addMajorWorkDetail(generalMap);
	}

	public MajorWorkDetailDataService getMajorworkdetaildataservice() {
		return majorworkdetaildataservice;
	}

	public void setMajorWorkDetailDataService(
			MajorWorkDetailDataService majorworkdetaildataservice) {
		this.majorworkdetaildataservice = majorworkdetaildataservice;
	}

	public String generateMajorWorkNumber(String userName) {
		return majorworkdetaildataservice.generateMajorWorkNumber(userName);
	}

	public boolean editStatusMessageToDatabase(Map<String, Object> generalMap) {
		return majorworkdetaildataservice
				.editStatusMessageToDatabase(generalMap);

	}
}
