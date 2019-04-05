package jkt.hms.workservices.dataservice;

import java.util.Map;

import jkt.hms.masters.business.MasMinorWorkProposal;
import jkt.hms.workservices.controller.AgendaDTO;

public interface MinorWorkProposalDataService {
	public Map<String, Object> showMinorWorkProposalJsp();

	public Map<String, Object> showMinorWorkProposalCancellationJsp();

	public Map<String, Object> showPopUpProposalJsp(Map<String, Object> map);

	public boolean addMinorWorkProposal(MasMinorWorkProposal minorworkdetailno,
			Map<String, Object> dataMap);

	public boolean cancleMinorWorkProposal(
			MasMinorWorkProposal minorworkdetailno);

	public Map<String, Object> searchMinorWorkProposalCancellationSearch(
			AgendaDTO minorworkdetailno);

	public String generateMinorWorkNumber(String userName);

	public Map<String, Object> searchMinorWorkDetail(
			AgendaDTO minorWorkDetailSearch);

	public Map<String, Object> getConnectionForReport();
	
	public Map<String, Object> popUpForProposalJsp();
}
