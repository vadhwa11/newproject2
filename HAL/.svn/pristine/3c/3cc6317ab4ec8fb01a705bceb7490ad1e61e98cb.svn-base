package jkt.hms.workservices.dataservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasWorkCategory;
import jkt.hms.util.HMSUtil;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class WorkCategoryDataServiceImpl extends HibernateDaoSupport implements
		WorkCategoryDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showWorkCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWorkCategory> searchWorkCategoryList = new ArrayList<MasWorkCategory>();
		searchWorkCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkCategory ");
		map.put("searchWorkCategoryList", searchWorkCategoryList);
		return map;
	}

	public boolean addWorkCategory(MasWorkCategory masWorkCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masWorkCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchWorkCategory(String workCategoryCode,
			String workCategoryName) {
		List<MasWorkCategory> searchWorkCategoryList = new ArrayList<MasWorkCategory>();
		Map<String, Object> workCategoryFieldsMap = new HashMap<String, Object>();
		try {
			if ((workCategoryName != null) || (workCategoryCode == null)) {

				searchWorkCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasWorkCategory imc where imc.WorkCategoryName like '"
										+ workCategoryName
										+ "%' order by imc.WorkCategoryName");
			} else {
				searchWorkCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasWorkCategory imc where imc.WorkCategoryCode like '"
										+ workCategoryCode
										+ "%' order by imc.WorkCategoryCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		workCategoryFieldsMap.put("searchWorkCategoryList",
				searchWorkCategoryList);
		return workCategoryFieldsMap;

	}

	public boolean editWorkCategoryToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String workCategoryName = "";
		@SuppressWarnings("unused")
		String workCategoryCode = "";
		String minLimit = "";
		String maxLimit = "";
		int workCategoryId = 0;
		String changedBy = "";
		workCategoryId = (Integer) generalMap.get("id");
		workCategoryCode = (String) generalMap.get("workCategoryCode");
		workCategoryName = (String) generalMap.get("name");
		minLimit = (String) generalMap.get("minLimit");
		maxLimit = (String) generalMap.get("maxLimit");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasWorkCategory masWorkCategory = (MasWorkCategory) getHibernateTemplate()
				.load(MasWorkCategory.class, workCategoryId);

		masWorkCategory.setId(workCategoryId);
		masWorkCategory.setWorkCategoryName(workCategoryName);
		masWorkCategory.setMinLimit(new BigDecimal(minLimit));
		masWorkCategory.setMaxLimit(new BigDecimal(maxLimit));
		masWorkCategory.setLastChgBy(changedBy);
		masWorkCategory.setLastChgDate(currentDate);
		masWorkCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		// hbt.setFlushMode(FlushMode.ALWAYS);
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masWorkCategory);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteWorkCategory(int workCategoryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasWorkCategory masWorkCategory = new MasWorkCategory();
		masWorkCategory = (MasWorkCategory) getHibernateTemplate().load(
				MasWorkCategory.class, workCategoryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masWorkCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masWorkCategory.setStatus("y");
				dataDeleted = false;
			}
		}
		masWorkCategory.setLastChgBy(changedBy);
		masWorkCategory.setLastChgDate(currentDate);
		masWorkCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masWorkCategory);
		return dataDeleted;
	}
}
