package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.dataservice.MajorWorkDetailUpdateDataService;

public class MajorWorkDetailUpdateHandlerServiceImpl implements
		MajorWorkDetailUpdateHandlerService {
	MajorWorkDetailUpdateDataService majorworkdetailupdatedataservice = null;

	public Map<String, Object> showMajorWorkDetailUpdateJsp(int Id) {

		return majorworkdetailupdatedataservice
				.showMajorWorkDetailUpdateJsp(Id);
	}

	public boolean majorWorkDetailUpdateToDatabase(
			Map<String, Object> generalMap) {
		return majorworkdetailupdatedataservice
				.majorWorkDetailUpdateToDatabase(generalMap);
	}

	public MajorWorkDetailUpdateDataService getMajorworkdetailupdatedataservice() {
		return majorworkdetailupdatedataservice;
	}

	public void setMajorWorkDetailUpdateDataService(
			MajorWorkDetailUpdateDataService majorworkdetailupdatedataservice) {
		this.majorworkdetailupdatedataservice = majorworkdetailupdatedataservice;
	}

}
