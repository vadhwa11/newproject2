package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.dataservice.MinorWorkNotYetReleasedReportDataService;

public class MinorWorkNotYetReleasedReportHandlerServiceImpl implements
		MinorWorkNotYetReleasedReportHandlerService {
	MinorWorkNotYetReleasedReportDataService minorWorkNotYetReleasedReportDataService = null;

	public Map<String, Object> getConnectionForReport() {
		// TODO Auto-generated method stub
		return minorWorkNotYetReleasedReportDataService
				.getConnectionForReport();
	}

	public Map<String, Object> showMinorWorkYetReleased() {
		// TODO Auto-generated method stub
		return minorWorkNotYetReleasedReportDataService
				.showMinorWorkYetReleased();
	}

	public Map<String, Object> showMinorWorkNotYetReleased() {
		// TODO Auto-generated method stub
		return minorWorkNotYetReleasedReportDataService
				.showMinorWorkNotYetReleased();
	}

	public MinorWorkNotYetReleasedReportDataService getMinorWorkNotYetReleasedReportDataService() {
		return minorWorkNotYetReleasedReportDataService;
	}

	public void setMinorWorkNotYetReleasedReportDataService(
			MinorWorkNotYetReleasedReportDataService minorWorkNotYetReleasedReportDataService) {
		this.minorWorkNotYetReleasedReportDataService = minorWorkNotYetReleasedReportDataService;
	}

}
