package jkt.hms.workservices.dataservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasWorkCategory;
import jkt.hms.masters.business.MasWorkType;
import jkt.hms.util.HMSUtil;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class WorkTypeDataServiceImpl extends HibernateDaoSupport implements
		WorkTypeDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showWorkTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWorkType> searchWorkTypeList = new ArrayList<MasWorkType>();
		List<MasWorkCategory> searchWorkCategoryList = new ArrayList<MasWorkCategory>();
		searchWorkTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkType ");
		searchWorkCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkCategory ");
		map.put("searchWorkTypeList", searchWorkTypeList);
		map.put("searchWorkCategoryList", searchWorkCategoryList);
		return map;
	}

	public String addWorkType(MasWorkType masWorkType) {
		String msg = "";
		MasWorkCategory masWorkCategory = masWorkType.getWorkCategory();
		List<MasWorkCategory> searchWorkCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasWorkCategory where Id ='"
								+ masWorkCategory.getId() + "'");

		if (masWorkType.getMinLimit() != null
				&& searchWorkCategoryList.get(0).getMinLimit().compareTo(
						masWorkType.getMinLimit()) == 1) {
			msg = "Min Limit can not be less than "
					+ searchWorkCategoryList.get(0).getMinLimit();
		} else if (masWorkType.getMaxLimit() != null
				&& searchWorkCategoryList.get(0).getMaxLimit().compareTo(
						masWorkType.getMaxLimit()) == -1
				&& masWorkType.getWorkCategory().getId() != 3) {
			msg = "Max Limit can not be greater than "
					+ searchWorkCategoryList.get(0).getMaxLimit();
		} else {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(masWorkType);
			hbt.refresh(masWorkType);
			msg = "data updated";
		}
		return msg;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchWorkType(String workTypeCode,
			String workTypeName) {
		List<MasWorkType> searchWorkTypeList = new ArrayList<MasWorkType>();
		Map<String, Object> workTypeFieldsMap = new HashMap<String, Object>();
		List<MasWorkCategory> searchWorkCategoryList = new ArrayList<MasWorkCategory>();
		try {
			if ((workTypeName != null)) {

				searchWorkTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasWorkType imc where imc.WorkTypeName like '"
										+ workTypeName
										+ "%' order by imc.WorkTypeName");
				searchWorkCategoryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasWorkCategory ");
			} else {
				searchWorkTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasWorkType imc where imc.WorkTypeCode like '"
										+ workTypeCode
										+ "%' order by imc.WorkTypeCode");
				searchWorkCategoryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasWorkCategory ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		workTypeFieldsMap.put("searchWorkTypeList", searchWorkTypeList);
		workTypeFieldsMap.put("searchWorkCategoryList", searchWorkCategoryList);
		return workTypeFieldsMap;

	}

	public String editWorkTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String workTypeName = "";
		@SuppressWarnings("unused")
		String workTypeCode = "";
		String minLimit = "";
		String maxLimit = "";
		int workTypeId = 0;
		String changedBy = "";
		int workCategoryId = 0;
		workTypeId = (Integer) generalMap.get("id");
		workTypeCode = (String) generalMap.get("workTypeCode");
		workTypeName = (String) generalMap.get("name");
		String msg = "";

		workCategoryId = (Integer) generalMap.get("workCategoryId");

		minLimit = (String) generalMap.get("minLimit");
		maxLimit = (String) generalMap.get("maxLimit");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasWorkType masWorkType = (MasWorkType) getHibernateTemplate().load(
				MasWorkType.class, workTypeId);
		MasWorkCategory workCategory = new MasWorkCategory();

		masWorkType.setId(workTypeId);
		List<MasWorkCategory> searchWorkCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasWorkCategory where Id ='"
								+ workCategoryId + "'");

		if (minLimit != null
				&& !minLimit.equalsIgnoreCase("")
				&& searchWorkCategoryList.get(0).getMinLimit().compareTo(
						new BigDecimal(minLimit)) > 0) {
			msg = "Min Limit can Not be less than "
					+ searchWorkCategoryList.get(0).getMinLimit();
		} else if (maxLimit != null
				&& !maxLimit.equalsIgnoreCase("")
				&& searchWorkCategoryList.get(0).getMaxLimit().compareTo(
						new BigDecimal(maxLimit)) < 0) {
			msg = "MAX Limit can Not be greater than "
					+ searchWorkCategoryList.get(0).getMaxLimit();
		} else {
			workCategory.setId(workCategoryId);
			masWorkType.setWorkCategory(workCategory);
			masWorkType.setWorkTypeName(workTypeName);
			if (minLimit != null && !minLimit.equalsIgnoreCase(""))
				masWorkType.setMinLimit(new BigDecimal(minLimit));
			if (maxLimit != null && !maxLimit.equalsIgnoreCase(""))
				masWorkType.setMaxLimit(new BigDecimal(maxLimit));
			masWorkType.setLastChgBy(changedBy);
			masWorkType.setLastChgDate(currentDate);
			masWorkType.setLastChgTime(currentTime);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masWorkType);
			dataUpdated = true;
			msg = "data updated";
		}
		return msg;
	}

	public boolean deleteWorkType(int workCategoryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasWorkType masWorkType = new MasWorkType();
		masWorkType = (MasWorkType) getHibernateTemplate().load(
				MasWorkType.class, workCategoryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masWorkType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masWorkType.setStatus("y");
				dataDeleted = false;
			}
		}
		masWorkType.setLastChgBy(changedBy);
		masWorkType.setLastChgDate(currentDate);
		masWorkType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masWorkType);
		return dataDeleted;
	}
}
