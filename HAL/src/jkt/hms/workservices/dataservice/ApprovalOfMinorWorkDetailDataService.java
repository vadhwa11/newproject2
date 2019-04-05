package jkt.hms.workservices.dataservice;

import java.util.Map;

public interface ApprovalOfMinorWorkDetailDataService {

	Map<String, Object> showApprovalOfMinorWorkDetailJsp(int Id);

	boolean editApprovalOfMinorWorkDetailToDatabase(
			Map<String, Object> generalMap);

	public Map<String, Object> getConnectionForReport();
}
