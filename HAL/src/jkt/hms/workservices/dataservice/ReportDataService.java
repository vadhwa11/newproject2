package jkt.hms.workservices.dataservice;

import java.util.Map;

public interface ReportDataService {
	public Map<String, Object> showMinorWorkRegister();

	public Map<String, Object> showMajorWorkRegister();

	public Map<String, Object> getConnectionForReport();

	public Map<String, Object> printAraogyaReport(Map<String, Object> mapForDs);

	public Map<String, Object> printMedAdmissionDiagReport(
			Map<String, Object> mapForDs);

	public Map<String, Object> printMisBedReport(Map<String, Object> mapForDs);
}
