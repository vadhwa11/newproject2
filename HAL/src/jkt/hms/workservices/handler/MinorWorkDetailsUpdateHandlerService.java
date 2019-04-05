package jkt.hms.workservices.handler;

import java.util.Map;

public interface MinorWorkDetailsUpdateHandlerService {

	Map<String, Object> showMinorWorkDetailsUpdateJsp(int Id);

	boolean editMinorWorkDetailsUpdateToDatabase(Map<String, Object> generalMap);

	public boolean deleteMinorWorkDetailsUpdate(int minorWorkDetailId,
			Map<String, Object> generalMap);
}
