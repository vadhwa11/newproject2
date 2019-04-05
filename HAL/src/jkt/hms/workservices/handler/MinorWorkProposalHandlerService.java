package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.masters.business.MasMinorWorkProposal;
import jkt.hms.workservices.controller.AgendaDTO;

public interface MinorWorkProposalHandlerService {
	public Map<String, Object> showMinorWorkProposalJsp();

	public Map<String, Object> showPopUpProposalJsp(Map<String, Object> map);

	public boolean addMinorWorkProposal(MasMinorWorkProposal minorworkdetailno,
			Map<String, Object> dataMap);

	public Map<String, Object> searchMinorWorkProposalCancellationSearch(
			AgendaDTO minorworkdetailno);

	public String generateMinorWorkNumber(String userName);

	public Map<String, Object> showMinorWorkProposalCancellationJsp();

	public boolean cancleMinorWorkProposal(
			MasMinorWorkProposal minorworkdetailno);

	public Map<String, Object> searchMinorWorkDetail(
			AgendaDTO minorWorkDetailSearch);
	public Map<String, Object> popUpForProposalJsp();

	public Map<String, Object> getConnectionForReport();
}
