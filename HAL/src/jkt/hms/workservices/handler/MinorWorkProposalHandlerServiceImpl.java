package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.masters.business.MasMinorWorkProposal;
import jkt.hms.workservices.controller.AgendaDTO;
import jkt.hms.workservices.dataservice.MinorWorkProposalDataService;

public class MinorWorkProposalHandlerServiceImpl implements
		MinorWorkProposalHandlerService {
	MinorWorkProposalDataService minorworkdetaildataservice = null;

	public Map<String, Object> showMinorWorkProposalJsp() {

		return minorworkdetaildataservice.showMinorWorkProposalJsp();
	}

	public Map<String, Object> showPopUpProposalJsp(Map<String, Object> map) {

		return minorworkdetaildataservice.showPopUpProposalJsp(map);
	}

	public Map<String, Object> showMinorWorkProposalCancellationJsp() {

		return minorworkdetaildataservice
				.showMinorWorkProposalCancellationJsp();
	}

	public boolean addMinorWorkProposal(MasMinorWorkProposal minorworkdetailno,
			Map<String, Object> dataMap) {
		return minorworkdetaildataservice.addMinorWorkProposal(
				minorworkdetailno, dataMap);
	}

	public boolean cancleMinorWorkProposal(
			MasMinorWorkProposal minorworkdetailno) {
		return minorworkdetaildataservice
				.cancleMinorWorkProposal(minorworkdetailno);
	}

	public Map<String, Object> searchMinorWorkProposalCancellationSearch(
			AgendaDTO minorworkdetailno) {
		return minorworkdetaildataservice
				.searchMinorWorkProposalCancellationSearch(minorworkdetailno);

	}

	public MinorWorkProposalDataService getMinorworkdetaildataservice() {
		return minorworkdetaildataservice;
	}

	public void setMinorWorkProposalDataService(
			MinorWorkProposalDataService minorworkdetaildataservice) {
		this.minorworkdetaildataservice = minorworkdetaildataservice;
	}

	public String generateMinorWorkNumber(String userName) {
		return minorworkdetaildataservice.generateMinorWorkNumber(userName);
	}

	public Map<String, Object> searchMinorWorkDetail(
			AgendaDTO minorWorkDetailSearch) {
		return minorworkdetaildataservice
				.searchMinorWorkDetail(minorWorkDetailSearch);

	}

	public Map<String, Object> getConnectionForReport() {
		return minorworkdetaildataservice.getConnectionForReport();
	}
	public Map<String, Object> popUpForProposalJsp(){
		return minorworkdetaildataservice.popUpForProposalJsp();
	}

}
