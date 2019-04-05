package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.workservices.dataservice.MinorWorkDetailDataService;

public class MinorWorkDetailHandlerServiceImpl implements
		MinorWorkDetailHandlerService {
	MinorWorkDetailDataService minorworkdetaildataservice = null;

	public Map<String, Object> showMinorWorkDetailJsp() {

		return minorworkdetaildataservice.showMinorWorkDetailJsp();
	}

	public Map<String, Object> showUserCommentsJsp() {

		return minorworkdetaildataservice.showUserCommentsJsp();
	}

	public boolean addMinorWorkDetail(Map<String, Object> generalMap,
			int proposalNoId) {
		return minorworkdetaildataservice.addMinorWorkDetail(generalMap,
				proposalNoId);
	}

	public MinorWorkDetailDataService getMinorworkdetaildataservice() {
		return minorworkdetaildataservice;
	}

	public void setMinorWorkDetailDataService(
			MinorWorkDetailDataService minorworkdetaildataservice) {
		this.minorworkdetaildataservice = minorworkdetaildataservice;
	}

	public String generateMinorWorkNumber(String userName) {
		return minorworkdetaildataservice.generateMinorWorkNumber(userName);
	}

	public boolean editUserComments(Map<String, Object> generalMap)

	{
		return minorworkdetaildataservice.editUserComments(generalMap);
	}

	public Map<String, Object> showPopUpProposalJsp(Map<String, Object> map) {

		return minorworkdetaildataservice.showPopUpProposalJsp(map);
	}

	public Map<String, Object> showViewUserCommentsJsp(
			Map<String, Object> generalMap) {
		return minorworkdetaildataservice.showViewUserCommentsJsp(generalMap);
	}

}
