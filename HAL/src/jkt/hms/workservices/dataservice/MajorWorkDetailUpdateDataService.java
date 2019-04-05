package jkt.hms.workservices.dataservice;

import java.util.Map;

public interface MajorWorkDetailUpdateDataService {
	public Map<String, Object> showMajorWorkDetailUpdateJsp(int Id);

	public boolean majorWorkDetailUpdateToDatabase(
			Map<String, Object> generalMap);

}