package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.dataservice.ApprovalOfMinorWorkDetailDataService;

public class ApprovalOfMinorWorkDetailHandlerServiceImpl implements
		ApprovalOfMinorWorkDetailHandlerService {
	ApprovalOfMinorWorkDetailDataService approvalOfMinorWorkDetailDataService = null;

	public Map<String, Object> showApprovalOfMinorWorkDetailJsp(int Id) {
		return approvalOfMinorWorkDetailDataService
				.showApprovalOfMinorWorkDetailJsp(Id);
	}

	public boolean editApprovalOfMinorWorkDetailToDatabase(
			Map<String, Object> generalMap) {
		return approvalOfMinorWorkDetailDataService
				.editApprovalOfMinorWorkDetailToDatabase(generalMap);
	}

	// ------------------------------------------------------------

	public ApprovalOfMinorWorkDetailDataService getApprovalOfMinorWorkDetailDataService() {
		return approvalOfMinorWorkDetailDataService;
	}

	public void setApprovalOfMinorWorkDetailDataService(
			ApprovalOfMinorWorkDetailDataService approvalOfMinorWorkDetailDataService) {
		this.approvalOfMinorWorkDetailDataService = approvalOfMinorWorkDetailDataService;
	}

	public Map<String, Object> getConnectionForReport() {
		return approvalOfMinorWorkDetailDataService.getConnectionForReport();
	}

}
