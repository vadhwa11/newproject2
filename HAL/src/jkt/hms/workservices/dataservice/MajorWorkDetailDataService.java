package jkt.hms.workservices.dataservice;

import java.util.Map;

public interface MajorWorkDetailDataService {
	public Map<String, Object> showMajorWorkDetailJsp();

	public Map<String, Object> showMajorWorkDetailStatusMessageJsp();

	public boolean addMajorWorkDetail(Map<String, Object> generalMap);

	public boolean editStatusMessageToDatabase(Map<String, Object> generalMap);

	public String generateMajorWorkNumber(String userName);
}
