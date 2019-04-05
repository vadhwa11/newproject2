package jkt.hms.workservices.dataservice;

import java.util.Map;

import jkt.hms.workservices.controller.MajorWorkDetailSearchDTO;

public interface MajorWorkDetailSearchDataService {

	Map<String, Object> showMajorWorkDetailSearchJsp();

	Map<String, Object> searchMajorWorkDetailSearch(
			MajorWorkDetailSearchDTO majorWorkDetailSearch);

}
