package jkt.hms.medicalboard.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster;
import jkt.hms.medicalboard.controller.ResultOfAppealMedicalboardSearchDTO;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ResultOfAppealMedicalboardSearchDataServiceImpl extends
		HibernateDaoSupport implements
		ResultOfAppealMedicalboardSearchDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public Map<String, Object> showResultOfAppealMedicalboardSearchJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MbResultOfAppealMedicalboardMaster> resultOfAppealMedicalboardList = new ArrayList<MbResultOfAppealMedicalboardMaster>();

		resultOfAppealMedicalboardList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster");
		map.put("mbResultOfAppealMedicalboardMasterList",
				resultOfAppealMedicalboardList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchResultOfAppealMedicalboardSearch(
			ResultOfAppealMedicalboardSearchDTO resultOfAppealMedicalboardSearch) {
		List<MbResultOfAppealMedicalboardMaster> searchResultOfAppealMedicalboardSearchList = new ArrayList<MbResultOfAppealMedicalboardMaster>();

		Map<String, Object> resultOfAppealMedicalboardSearchFieldsMap = new HashMap<String, Object>();

		String entryNo = "";
		String entryDate = "";
		String batchNo = "";
		String chestNo = "";
		String name = "";
		int entryNoIntValue = 0;
		Date entryDate1 = null;
		Session session = (Session) getSession();
		if (resultOfAppealMedicalboardSearch.getEntryNo() != null
				&& !resultOfAppealMedicalboardSearch.getEntryNo()
						.equalsIgnoreCase("")) {
			entryNo = resultOfAppealMedicalboardSearch.getEntryNo();
			entryNoIntValue = Integer.parseInt(entryNo);
		}

		if (resultOfAppealMedicalboardSearch.getEntryDate() != null
				&& !resultOfAppealMedicalboardSearch.getEntryDate()
						.equalsIgnoreCase("")) {
			entryDate = resultOfAppealMedicalboardSearch.getEntryDate();
			entryDate1 = HMSUtil.convertStringTypeDateToDateType(entryDate);
		}
		if (resultOfAppealMedicalboardSearch.getBatchNo() != null
				&& !resultOfAppealMedicalboardSearch.getBatchNo()
						.equalsIgnoreCase("")) {
			batchNo = resultOfAppealMedicalboardSearch.getBatchNo();
		}
		if (resultOfAppealMedicalboardSearch.getChestNo() != null
				&& !resultOfAppealMedicalboardSearch.getChestNo()
						.equalsIgnoreCase("")) {
			chestNo = resultOfAppealMedicalboardSearch.getChestNo();
		}
		if (resultOfAppealMedicalboardSearch.getName() != null
				&& !resultOfAppealMedicalboardSearch.getName()
						.equalsIgnoreCase("")) {
			name = resultOfAppealMedicalboardSearch.getName();
		}

		try {
			Criteria crit = session
					.createCriteria(MbResultOfAppealMedicalboardMaster.class);

			if (entryNoIntValue != 0) {
				crit = crit.add(Restrictions.eq("EntryNo", entryNoIntValue));
			}
			if (entryDate1 != null && !entryDate1.equals("")) {
				crit = crit.add(Restrictions.eq("EntryDate", entryDate1));
			}
			if (!batchNo.equals("")) {
				crit = crit.add(Restrictions.like("BatchNo", batchNo + "%"));
			}
			if (!chestNo.equals("")) {
				crit = crit.add(Restrictions.like("ChestNo", chestNo + "%"));
			}
			if (!name.equals("")) {
				crit = crit.add(Restrictions.like("Name", name + "%"));
			}
			searchResultOfAppealMedicalboardSearchList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultOfAppealMedicalboardSearchFieldsMap.put(
				"searchResultOfAppealMedicalboardSearchList",
				searchResultOfAppealMedicalboardSearchList);
		return resultOfAppealMedicalboardSearchFieldsMap;
	}
}
