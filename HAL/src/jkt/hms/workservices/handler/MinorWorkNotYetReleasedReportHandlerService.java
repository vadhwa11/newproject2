package jkt.hms.workservices.handler;

import java.util.Map;

public interface MinorWorkNotYetReleasedReportHandlerService {
	Map<String, Object> showMinorWorkNotYetReleased();

	Map<String, Object> showMinorWorkYetReleased();

	public Map<String, Object> getConnectionForReport();
}
