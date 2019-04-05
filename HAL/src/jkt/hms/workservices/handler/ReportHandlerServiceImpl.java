package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.dataservice.ReportDataService;

public class ReportHandlerServiceImpl implements ReportHandlerService {
	private ReportDataService reportDataService = null;

	public ReportDataService getReportDataService() {
		return reportDataService;
	}

	public void setReportDataService(ReportDataService reportDataService) {
		this.reportDataService = reportDataService;
	}

	public Map<String, Object> getConnectionForReport() {
		// TODO Auto-generated method stub
		return reportDataService.getConnectionForReport();
	}

	public Map<String, Object> showMinorWorkRegister() {
		// TODO Auto-generated method stub
		return reportDataService.showMinorWorkRegister();
	}

	public Map<String, Object> showMajorWorkRegister() {
		// TODO Auto-generated method stub
		return reportDataService.showMajorWorkRegister();
	}

	public Map<String, Object> printAraogyaReport(Map<String, Object> mapForDs) {
		return reportDataService.printAraogyaReport(mapForDs);
	}

	public Map<String, Object> printMedAdmissionDiagReport(
			Map<String, Object> mapForDs) {
		return reportDataService.printMedAdmissionDiagReport(mapForDs);
	}

	public Map<String, Object> printMisBedReport(Map<String, Object> mapForDs) {
		return reportDataService.printMisBedReport(mapForDs);
	}

}
