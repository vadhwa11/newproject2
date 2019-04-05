package jkt.hms.workservices.dataservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks;
import jkt.hms.util.HMSUtil;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AllotmentOfFundsForMinorWorkDataServiceImpl extends
		HibernateDaoSupport implements AllotmentOfFundsForMinorWorkDataService {
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAllotmentOfFundsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAllotmentOfFundsForMinorWorks> searchAllotmentOfFundsList = new ArrayList<MasAllotmentOfFundsForMinorWorks>();
		searchAllotmentOfFundsList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks");
		//System.out.println("size of List" + searchAllotmentOfFundsList.size());
		Calendar c = Calendar.getInstance();
		Integer i;
		Integer year;
		Integer sessionyear = 0;
		String session = "";
		year = c.get(Calendar.YEAR);
		i = c.get(Calendar.MONTH) + 1;
		if (i >= 4) {
			sessionyear = year + 1;
			session = "" + year + "-" + sessionyear;

		} else {
			sessionyear = year - 1;
			session = "" + sessionyear + "-" + year;
		}
		map.put("session", session);
		map.put("searchAllotmentOfFundsList", searchAllotmentOfFundsList);
		return map;
	}

	public boolean addAllotmentOfFunds(
			MasAllotmentOfFundsForMinorWorks masAllotmentOfFundsForMinorWorks) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAllotmentOfFundsForMinorWorks);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAllotmentOfFunds(String allotmentFileNo) {
		List<MasAllotmentOfFundsForMinorWorks> searchAllotmentOfFundsList = new ArrayList<MasAllotmentOfFundsForMinorWorks>();
		Map<String, Object> allotmentOfFundsFieldsMap = new HashMap<String, Object>();
		try {
			if ((allotmentFileNo != null)) {

				searchAllotmentOfFundsList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks imc where imc.AllotmentFileNo like '"
										+ allotmentFileNo
										+ "%' order by imc.AllotmentFileNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		allotmentOfFundsFieldsMap.put("searchAllotmentOfFundsList",
				searchAllotmentOfFundsList);
		return allotmentOfFundsFieldsMap;

	}

	public boolean editAllotmentOfFundsToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		@SuppressWarnings("unused")
		int Id = 0;
		String financialYear = "";
		String allotmentFileNo = "";
		String allotmentFileDate = "";
		String allotmentAmount = "";
		String remarks = "";
		String changedBy = "";
		Id = (Integer) generalMap.get("id");
		financialYear = (String) generalMap.get("financialYear");
		//System.out.println("In data Service FinancialYear" + financialYear);
		allotmentFileNo = (String) generalMap.get("allotmentFileNo");
		allotmentFileDate = (String) generalMap.get("allotmentFileDate");
		allotmentAmount = (String) generalMap.get("allotmentAmount");
		remarks = (String) generalMap.get("remarks");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAllotmentOfFundsForMinorWorks masAllotmentOfFundsForMinorWorks = (MasAllotmentOfFundsForMinorWorks) getHibernateTemplate()
				.load(MasAllotmentOfFundsForMinorWorks.class, Id);

		masAllotmentOfFundsForMinorWorks.setId(Id);
		masAllotmentOfFundsForMinorWorks.setFinancialYear(financialYear);
		masAllotmentOfFundsForMinorWorks.setAllotmentFileNo(allotmentFileNo);
		masAllotmentOfFundsForMinorWorks.setAllotmentFileDate(HMSUtil
				.dateFormatterDDMMYYYY(allotmentFileDate));
		masAllotmentOfFundsForMinorWorks.setAllotmentFileAmount(new BigDecimal(
				allotmentAmount));
		masAllotmentOfFundsForMinorWorks.setRemarks(remarks);
		masAllotmentOfFundsForMinorWorks.setLastChangedBy(changedBy);
		masAllotmentOfFundsForMinorWorks.setLastChangedDate(currentDate);
		masAllotmentOfFundsForMinorWorks.setLastChangedTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		// hbt.setFlushMode(FlushMode.ALWAYS);
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAllotmentOfFundsForMinorWorks);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteAllotmentOfFundsToDatabase(int Id,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasAllotmentOfFundsForMinorWorks masAllotmentOfFundsForMinorWorks = new MasAllotmentOfFundsForMinorWorks();
		masAllotmentOfFundsForMinorWorks = (MasAllotmentOfFundsForMinorWorks) getHibernateTemplate()
				.load(MasAllotmentOfFundsForMinorWorks.class, Id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAllotmentOfFundsForMinorWorks.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAllotmentOfFundsForMinorWorks.setStatus("y");
				dataDeleted = false;
			}
		}
		masAllotmentOfFundsForMinorWorks.setLastChangedBy(changedBy);
		masAllotmentOfFundsForMinorWorks.setLastChangedDate(currentDate);
		masAllotmentOfFundsForMinorWorks.setLastChangedTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAllotmentOfFundsForMinorWorks);
		return dataDeleted;
	}

}
