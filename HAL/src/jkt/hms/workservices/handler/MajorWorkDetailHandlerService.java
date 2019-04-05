package jkt.hms.workservices.handler;

import java.util.Map;

public interface MajorWorkDetailHandlerService {
	public Map<String, Object> showMajorWorkDetailJsp();

	public boolean addMajorWorkDetail(Map<String, Object> generalMap);

	boolean editStatusMessageToDatabase(Map<String, Object> generalMap);

	public String generateMajorWorkNumber(String userName);

	public Map<String, Object> showMajorWorkDetailStatusMessageJsp();

}
