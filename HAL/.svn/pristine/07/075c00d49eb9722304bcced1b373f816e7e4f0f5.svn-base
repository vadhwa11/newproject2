package jkt.hms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasNursingCare;
import jkt.hms.util.HMSUtil;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NursingCareMasterDataServiceImpl extends HibernateDaoSupport
		implements NursingCareMasterDataService {

	public boolean addNursingCare(MasNursingCare masNursingCare) {
		System.out.println("masNursingCare=="+masNursingCare);
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masNursingCare);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteNursingCare(int nursingCareId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasNursingCare masNursingCare = new MasNursingCare();
		masNursingCare = (MasNursingCare) getHibernateTemplate().load(
				MasNursingCare.class, nursingCareId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masNursingCare.getStatus().equals("y")) {
			masNursingCare.setStatus("n");
			dataDeleted = true;
		} else {
			masNursingCare.setStatus("y");
			dataDeleted = false;
		}
		masNursingCare.setLastChgBy(changedBy);
		masNursingCare.setLastChgDate(currentDate);
		masNursingCare.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masNursingCare);
		return dataDeleted;
	}

	public boolean editNursingCareToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String nursingCareName = "";
		@SuppressWarnings("unused")
		String nursingCareCode = "";
		String defaultStatus = "";
		int nursingCareId = 0;
		String changedBy = "";
		
		String nursingType = "";
		nursingCareId = (Integer) generalMap.get("id");
		nursingCareCode = (String) generalMap.get("nursingCareCode");
		nursingCareName = (String) generalMap.get("nursingCareName");
		nursingType = (String) generalMap.get("nursingType");
		defaultStatus = (String) generalMap.get("defaultStatus");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasNursingCare masNursingCare = (MasNursingCare) getHibernateTemplate()
				.load(MasNursingCare.class, nursingCareId);

		masNursingCare.setId(nursingCareId);
		masNursingCare.setNursingName(nursingCareName);
		masNursingCare.setDefaultStatus(defaultStatus);
		masNursingCare.setNursingType(nursingType);
		masNursingCare.setLastChgBy(changedBy);
		masNursingCare.setLastChgDate(currentDate);
		masNursingCare.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masNursingCare);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchNursingCare(String nursingCareCode,
			String nursingCareName) {
		List<MasNursingCare> searchNursingCareList = new ArrayList<MasNursingCare>();
		Map<String, Object> nursingCareFieldsMap = new HashMap<String, Object>();
		try {
			if ((nursingCareName != null) || (nursingCareCode == null)) {

				searchNursingCareList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasNursingCare sc where sc.NursingName like '"
								+ nursingCareName
								+ "%' order by sc.NursingName");
			} else {

				searchNursingCareList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasNursingCare sc where sc.NursingCode like '"
								+ nursingCareCode
								+ "%' order by sc.NursingCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchNursingCare  " + e);
		}

		nursingCareFieldsMap
				.put("searchNursingCareList", searchNursingCareList);
		return nursingCareFieldsMap;
	}

	public Map<String, Object> showNursingCareJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasNursingCare> searchNursingCareList = new ArrayList<MasNursingCare>();
		searchNursingCareList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasNursingCare ");
		map.put("searchNursingCareList", searchNursingCareList);
		return map;
	}

}
