package jkt.hms.workservices.handler;

import java.util.Map;

public interface ApprovalOfMinorWorkDetailHandlerService {

	Map<String, Object> showApprovalOfMinorWorkDetailJsp(int Id);

	boolean editApprovalOfMinorWorkDetailToDatabase(
			Map<String, Object> generalMap);

	public Map<String, Object> getConnectionForReport();
}
