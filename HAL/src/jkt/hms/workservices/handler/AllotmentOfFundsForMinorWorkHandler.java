package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks;

public interface AllotmentOfFundsForMinorWorkHandler {
	Map<String, Object> showAllotmentOfFundsJsp();

	boolean addAllotmentOfFunds(
			MasAllotmentOfFundsForMinorWorks masAllotmentOfFundsForMinorWorks);

	Map<String, Object> searchAllotmentOfFunds(String allotmentFileNo);

	boolean editAllotmentOfFundsToDatabase(Map<String, Object> generalMap);

	boolean deleteAllotmentOfFundsToDatabase(int Id,
			Map<String, Object> generalMap);
}
