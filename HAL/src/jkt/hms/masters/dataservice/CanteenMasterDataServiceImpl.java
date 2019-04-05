package jkt.hms.masters.dataservice;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DIET_ITEMS_ID;
import static jkt.hms.util.RequestConstants.EXTRA_ITEM;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INDENT_GROUP;
import static jkt.hms.util.RequestConstants.ITEM_TYPE;
import static jkt.hms.util.RequestConstants.MENU_TYPE;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.masters.business.MasDiet;
import jkt.hms.masters.business.MasDietCombination;
import jkt.hms.masters.business.MasDietIndentItem;
import jkt.hms.masters.business.MasDietItems;
import jkt.hms.masters.business.MasDietMenuItem;
import jkt.hms.masters.business.MasDietType;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CanteenMasterDataServiceImpl extends HibernateDaoSupport implements
		CanteenMasterDataService {

	// -----------------------------Diet
	// Master--------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDietJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDiet> searchDietList = new ArrayList<MasDiet>();

		try {
			searchDietList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDiet ");
			map.put("searchDietList", searchDietList);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addDiet(Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();

		boolean successfullyAdded = false;

		List<MasDiet> duplicateList = new ArrayList<MasDiet>();

		String code = (String) generalMap.get("code");
		String name = (String) generalMap.get("name");
		String category = (String) generalMap.get("category");
		String changedBy = (String) generalMap.get("changedBy");
		Date currentDate = (Date) generalMap.get("currentDate");
		String currentTime = (String) generalMap.get("currentTime");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			duplicateList = hbt
					.find("from jkt.hms.masters.business.MasDiet as md where md.DietCode ='"
							+ code
							+ "' and md.DietName = '"
							+ name
							+ "' and md.DietCategory = '" + category + "'");

			if (duplicateList.size() == 0) {

				MasDiet masDiet = new MasDiet();
				masDiet.setDietCode(code);
				masDiet.setDietName(name);
				masDiet.setDietCategory(category);
				masDiet.setStatus("y");
				masDiet.setLastChgBy(changedBy);
				masDiet.setLastChgDate(currentDate);
				masDiet.setLastChgTime(currentTime);

				hbt.save(masDiet);
				successfullyAdded = true;
			} else {
				map.put("duplicateList", duplicateList);
				successfullyAdded = false;
			}
			map.put("successfullyAdded", successfullyAdded);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean deleteDiet(int dietId, Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasDiet masDiet = new MasDiet();
			masDiet = (MasDiet) hbt.load(MasDiet.class, dietId);

			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masDiet.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masDiet.setStatus("y");
					dataDeleted = false;
				}
			}
			masDiet.setLastChgBy(changedBy);
			masDiet.setLastChgDate(currentDate);
			masDiet.setLastChgTime(currentTime);
			hbt.update(masDiet);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editDietToDatabase(Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDiet> duplicateList = new ArrayList<MasDiet>();

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		String changedBy = "";

		String dietName = "";
		String dietCode = "";
		String category = "";
		int dietId = 0;

		dietId = (Integer) generalMap.get("id");
		dietCode = (String) generalMap.get("dietCode");
		dietName = (String) generalMap.get("name");
		category = (String) generalMap.get("category");

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			duplicateList = hbt
					.find("from jkt.hms.masters.business.MasDiet as md where md.DietCode ='"
							+ dietCode
							+ "' and md.DietName = '"
							+ dietName
							+ "' and md.DietCategory = '" + category + "'");

			if (duplicateList.size() == 0) {
				MasDiet masDiet = (MasDiet) getHibernateTemplate().load(
						MasDiet.class, dietId);

				masDiet.setId(dietId);
				masDiet.setDietName(dietName);
				masDiet.setDietCategory(category);
				masDiet.setLastChgBy(changedBy);
				masDiet.setLastChgDate(currentDate);
				masDiet.setLastChgTime(currentTime);

				hbt.update(masDiet);
				dataUpdated = true;
			} else {
				map.put("duplicateList", duplicateList);
				dataUpdated = false;
			}
			map.put("dataUpdated", dataUpdated);

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDiet(String dietCode, String dietName) {

		List<MasDiet> searchDietList = new ArrayList<MasDiet>();
		Map<String, Object> dietFieldsMap = new HashMap<String, Object>();
		try {
			if ((dietName != null) || (dietCode == null)) {
				searchDietList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDiet imc where imc.DietName like '"
								+ dietName + "%' order by imc.DietName");
			} else {
				searchDietList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDiet imc where imc.DietCode like '"
								+ dietCode + "%' order by imc.DietCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dietFieldsMap.put("searchDietList", searchDietList);
		return dietFieldsMap;
	}

	// ---------------------------------Diet
	// type---------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDietTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietType> searchDietTypeList = new ArrayList<MasDietType>();
		searchDietTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDietType ");
		map.put("searchDietTypeList", searchDietTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDietType(String dietTypeCode,
			String dietTypeName) {
		List<MasDietType> searchDietTypeList = new ArrayList<MasDietType>();
		Map<String, Object> dietTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((dietTypeName != null) || (dietTypeCode == null)) {
				searchDietTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDietType imc where imc.DietTypeName like '"
										+ dietTypeName
										+ "%' order by imc.DietTypeName");
			} else {
				searchDietTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDietType imc where imc.DietTypeCode like '"
										+ dietTypeCode
										+ "%' order by imc.DietTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dietTypeFieldsMap.put("searchDietTypeList", searchDietTypeList);
		return dietTypeFieldsMap;
	}

	public boolean addDietType(MasDietType masDietType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDietType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editDietTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		String changedBy = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String dietTypeName = "";
		@SuppressWarnings("unused")
		String dietTypeCode = "";
		int dietTypeId = 0;

		dietTypeId = (Integer) generalMap.get("id");
		dietTypeCode = (String) generalMap.get("dietTypeCode");
		dietTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDietType masDietType = (MasDietType) getHibernateTemplate().load(
				MasDietType.class, dietTypeId);

		masDietType.setId(dietTypeId);
		masDietType.setDietTypeName(dietTypeName);
		masDietType.setLastChgBy(changedBy);
		masDietType.setLastChgDate(currentDate);
		masDietType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDietType);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteDietType(int dietTypeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDietType masDietType = new MasDietType();
		masDietType = (MasDietType) getHibernateTemplate().load(
				MasDietType.class, dietTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDietType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDietType.setStatus("y");
				dataDeleted = false;
			}
		}
		masDietType.setLastChgBy(changedBy);
		masDietType.setLastChgDate(currentDate);
		masDietType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDietType);
		return dataDeleted;
	}

	// ----------------------------Diet items---------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showDietItemsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietItems> searchDietItemsList = new ArrayList<MasDietItems>();
		searchDietItemsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDietItems ");
		map.put("searchDietItemsList", searchDietItemsList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDietItems(String dietItemsCode,
			String dietItemsName) {
		List<MasDietItems> searchDietItemsList = new ArrayList<MasDietItems>();
		Map<String, Object> dietItemsFieldsMap = new HashMap<String, Object>();
		try {
			if ((dietItemsName != null) || (dietItemsCode == null)) {
				searchDietItemsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDietItems imc where imc.DietItemsName like '"
								+ dietItemsName
								+ "%' order by imc.DietItemsName");
			} else {
				searchDietItemsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDietItems imc where imc.DietItemsCode like '"
								+ dietItemsCode
								+ "%' order by imc.DietItemsCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dietItemsFieldsMap.put("searchDietItemsList", searchDietItemsList);
		return dietItemsFieldsMap;
	}

	public boolean addDietItems(MasDietItems masDietItems) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDietItems);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteDietItems(int dietItemsId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDietItems masDietItems = new MasDietItems();
		masDietItems = (MasDietItems) getHibernateTemplate().load(
				MasDietItems.class, dietItemsId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDietItems.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDietItems.setStatus("y");
				dataDeleted = false;
			}
		}
		masDietItems.setLastChgBy(changedBy);
		masDietItems.setLastChgDate(currentDate);
		masDietItems.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDietItems);
		return dataDeleted;
	}

	public boolean editDietItemsToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		String changedBy = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String dietItemsName = "";
		@SuppressWarnings("unused")
		String dietItemsCode = "";
		int dietItemsId = 0;

		dietItemsId = (Integer) generalMap.get("id");
		dietItemsCode = (String) generalMap.get("dietItemsCode");
		dietItemsName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDietItems masDietItems = (MasDietItems) getHibernateTemplate().load(
				MasDietItems.class, dietItemsId);

		masDietItems.setId(dietItemsId);
		masDietItems.setDietItemsName(dietItemsName);
		masDietItems.setLastChgBy(changedBy);
		masDietItems.setLastChgDate(currentDate);
		masDietItems.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDietItems);
		dataUpdated = true;
		return dataUpdated;
	}

	// ----------------------------------Diet Diet
	// Type--------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDietCombinationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietCombination> searchDietDietTypeList = new ArrayList<MasDietCombination>();
		List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
		List<MasDiet> dietList = new ArrayList<MasDiet>();

		searchDietDietTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDietCombination ");
		dietTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDietType as mc where mc.Status = 'y'");
		dietList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDiet as mc where mc.Status = 'y'");
		map.put("searchDietDietTypeList", searchDietDietTypeList);
		map.put("dietTypeList", dietTypeList);
		map.put("dietList", dietList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addDietCombination(
			MasDietCombination masDietCombination) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		List<MasDietCombination> existingDietCombiList = new ArrayList<MasDietCombination>();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Session session = getSession();

		existingDietCombiList = session
				.createCriteria(MasDietCombination.class).createAlias("Diet",
						"d").add(
						Restrictions.eq("d.Id", masDietCombination.getDiet()
								.getId())).createAlias("DietType", "dt").add(
						Restrictions.eq("dt.Id", masDietCombination
								.getDietType().getId())).list();
		try {
			if (existingDietCombiList.size() == 0) {
				hbt.save(masDietCombination);
				successfullyAdded = true;
			} else {
				successfullyAdded = false;
				map.put("existingDietCombiList", existingDietCombiList);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> deleteDietCombination(int dietDietTypeId,
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietCombination> existingDietCombiList = new ArrayList<MasDietCombination>();
		boolean dataDeleted = false;
		try {
			String changedBy = "";
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			String flag = "";
			if (generalMap.get("flag") != null) {
				flag = (String) generalMap.get("flag");
			}

			Session session = getSession();
			if (flag.equals("Activate")) {
				existingDietCombiList = session.createCriteria(
						MasDietCombination.class).createAlias("Diet", "d").add(
						Restrictions.eq("d.Id", generalMap.get("dietId")))
						.createAlias("DietType", "dt").add(
								Restrictions.eq("dt.Id", generalMap
										.get("dietTypeId"))).list();

			}
			if (existingDietCombiList.size() == 0) {
				MasDietCombination masDietCombination = new MasDietCombination();
				masDietCombination = (MasDietCombination) getHibernateTemplate()
						.get(MasDietCombination.class, dietDietTypeId);

				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");

				if (flag.equals("InActivate")) {
					masDietCombination.setStatus("n");
				} else if (flag.equals("Activate")) {
					masDietCombination.setStatus("y");
				}

				masDietCombination.setLastChgBy(changedBy);
				masDietCombination.setLastChgDate(currentDate);
				masDietCombination.setLastChgTime(currentTime);

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				try {
					hbt.update(masDietCombination);
					dataDeleted = true;
				} catch (RuntimeException e) {
					e.printStackTrace();
				}

			} else {
				dataDeleted = false;
				map.put("existingDietCombiList", existingDietCombiList);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("dataDeleted", dataDeleted);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editDietCombination(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean dataUpdated = false;
		int dietDietTypeId = 0;
		int dietId = 0;
		int dietTypeId = 0;
		@SuppressWarnings("unused")
		String dietCategoryName = "";
		String changedBy = "";
		String currentTime = "";
		String demandDisplay = "";

		Date changedDate = new Date();
		dietDietTypeId = (Integer) generalMap.get("id");
		dietId = (Integer) generalMap.get("dietId");
		dietTypeId = (Integer) generalMap.get("dietTypeId");
		dietCategoryName = (String) generalMap.get("dietCategoryName");
		demandDisplay = (String) generalMap.get("demandDisplay");
		changedBy = (String) generalMap.get("changedBy");
		changedDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		List<MasDietCombination> existingDietCombiList = new ArrayList<MasDietCombination>();

		Session session = getSession();

		existingDietCombiList = session
				.createCriteria(MasDietCombination.class).createAlias("Diet",
						"d").add(Restrictions.eq("d.Id", dietId)).createAlias(
						"DietType", "dt").add(
						Restrictions.eq("dt.Id", dietTypeId))
				.add(Restrictions.not(Restrictions.eq("Id", dietDietTypeId)))
				.list();

		if (existingDietCombiList.size() == 0) {
			MasDietCombination masDietCombination = (MasDietCombination) getHibernateTemplate()
					.get(MasDietCombination.class, dietDietTypeId);

			masDietCombination.setId(dietDietTypeId);

			MasDiet masDiet = new MasDiet();
			masDiet.setId(dietId);
			masDietCombination.setDiet(masDiet);

			MasDietType masDietType = new MasDietType();
			masDietType.setId(dietTypeId);
			masDietCombination.setDietType(masDietType);
			masDietCombination.setDietCombinationName(dietCategoryName);
			masDietCombination.setDemandDisplay(demandDisplay);
			masDietCombination.setStatus("y");
			masDietCombination.setLastChgBy(changedBy);
			masDietCombination.setLastChgDate(changedDate);
			masDietCombination.setLastChgTime(currentTime);
			try {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masDietCombination);
				dataUpdated = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			dataUpdated = false;
			map.put("existingDietCombiList", existingDietCombiList);
		}
		map.put("dataUpdated", dataUpdated);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDietCombination(String dietName) {
		List<MasDietCombination> searchDietDietTypeList = new ArrayList<MasDietCombination>();
		List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
		List<MasDiet> dietList = new ArrayList<MasDiet>();
		Map<String, Object> dietFieldsMap = new HashMap<String, Object>();

		try {
			if (dietName != "") {
				searchDietDietTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDietCombination as i where i.Diet.DietName like '"
										+ dietName
										+ "%' order by i.Diet.DietName ");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchRoomList  " + e);
		}

		dietTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDietType as mc where mc.Status = 'y'");
		dietList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDiet as mc where mc.Status = 'y'");

		dietFieldsMap.put("searchDietDietTypeList", searchDietDietTypeList);
		dietFieldsMap.put("dietTypeList", dietTypeList);
		dietFieldsMap.put("dietList", dietList);

		return dietFieldsMap;

	}

	// -------------------------Diet Menu
	// Item---------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDietMenuItemJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietMenuItem> menuItemList = new ArrayList<MasDietMenuItem>();
		List<MasDietItems> itemList = new ArrayList<MasDietItems>();

		Session session = (Session) getSession();

		try {
			menuItemList = session.createCriteria(MasDietMenuItem.class).list();
			itemList = session.createCriteria(MasDietItems.class).add(
					Restrictions.eq("Status", "y")).list();
			map.put("menuItemList", menuItemList);
			map.put("itemList", itemList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addDietMenuItem(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		List<MasDietMenuItem> existingMenuItemList = new ArrayList<MasDietMenuItem>();
		String menuType = box.getString(MENU_TYPE);
		Vector items = box.getVector(DIET_ITEMS_ID);
		String changedBy = box.getString(CHANGED_BY);
		String changedDate = box.getString(CHANGED_DATE);
		String changedTime = box.getString(CHANGED_TIME);
		int hospitalId=0;
		hospitalId = box.getInt(HOSPITAL_ID);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Session session = getSession();

		for (int i = 0; i < items.size(); i++) {

			existingMenuItemList = session
					.createCriteria(MasDietMenuItem.class).add(
							Restrictions.eq("MenuType", menuType)).add(
							Restrictions.eq("Status", "y")).createAlias(
							"DietItems", "di").add(
							Restrictions.eq("di.Id", Integer
									.parseInt((String) items.get(i)))).list();

			if (existingMenuItemList.size() == 0) {
				MasDietMenuItem menuItem = new MasDietMenuItem();

				menuItem.setMenuType(menuType);
				if (items.get(i) != "") {
					int itemId = Integer.parseInt((String) items.get(i));
					MasDietItems dietItems = new MasDietItems();
					dietItems.setId(itemId);
					menuItem.setDietItems(dietItems);
				}
				menuItem.setLastChgBy(changedBy);
				menuItem.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(changedDate));
				menuItem.setLastChgTime(changedTime);
			
				
				MasHospital hospital= new MasHospital();
				hospital.setId(hospitalId);
				menuItem.setHospital(hospital);
		
				menuItem.setStatus("y");

				hbt.save(menuItem);
				saved = true;
			} else {
				map.put("existingMenuItemList", existingMenuItemList);
				saved = false;
			}
		}
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> deleteDietMenuItem(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietMenuItem> existingMenuItemList = new ArrayList<MasDietMenuItem>();
		boolean dataDeleted = false;
		String changedBy = "";
		String currentDate = "";
		String currentTime = "";
		int menuItemId = 0;
		String flag = "";

		menuItemId = box.getInt(COMMON_ID);
		changedBy = (String) box.getString(CHANGED_BY);
		currentDate = (String) box.getString(CHANGED_DATE);
		currentTime = (String) box.getString(CHANGED_TIME);
		Session session = getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			if (box.getString("flag") != null) {
				flag = (String) box.getString("flag");
			}
			if (flag.equals("Activate")) {
				existingMenuItemList = session.createCriteria(
						MasDietMenuItem.class).add(
						Restrictions.eq("MenuType", box.getString(MENU_TYPE)))
						.add(Restrictions.eq("Status", "y")).createAlias(
								"DietItems", "di").add(
								Restrictions.eq("di.Id", box
										.getInt(DIET_ITEMS_ID))).list();
			}
			if (existingMenuItemList.size() == 0) {
				MasDietMenuItem menuItem = new MasDietMenuItem();
				menuItem = (MasDietMenuItem) hbt.load(MasDietMenuItem.class,
						menuItemId);

				if (flag.equals("InActivate")) {
					menuItem.setStatus("n");
				} else if (flag.equals("Activate")) {
					menuItem.setStatus("y");
				}
				menuItem.setLastChgBy(changedBy);
				menuItem.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(currentDate));
				menuItem.setLastChgTime(currentTime);
				hbt.update(menuItem);
				dataDeleted = true;
			} else {
				map.put("existingMenuItemList", existingMenuItemList);
				dataDeleted = false;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		map.put("dataDeleted", dataDeleted);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDietMenuItem(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietMenuItem> menuItemList = new ArrayList<MasDietMenuItem>();

		Session session = getSession();
		String menuType = box.getString(SEARCH_NAME);

		try {
			menuItemList = session.createCriteria(MasDietMenuItem.class).add(
					Restrictions.like("MenuType", menuType + "%")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map = showDietMenuItemJsp();
		map.put("menuItemList", menuItemList);
		return map;
	}

	// ----------------------- Diet Indent Item-------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDietIndentItemJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();

		Session session = (Session) getSession();

		try {
			indentItemList = session.createCriteria(MasDietIndentItem.class)
					.list();
			map.put("indentItemList", indentItemList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addDietIndentItem(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		boolean successfullyAdded = false;
		List<MasDietIndentItem> duplicateList = new ArrayList<MasDietIndentItem>();

		String indentItemCode = (String) box.getString(CODE);
		String indentItemName = (String) box.getString(SEARCH_NAME);
		String type = (String) box.getString(ITEM_TYPE);
		int hospitalId=0;
		hospitalId = box.getInt(HOSPITAL_ID);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Session session = getSession();
			duplicateList = session.createCriteria(MasDietIndentItem.class)
					.add(Restrictions.eq("IndentItemCode", indentItemCode))
					.add(Restrictions.eq("IndentItemName", indentItemName))
					.add(Restrictions.eq("IndentItemType", type)).list();

			if (duplicateList.size() == 0) {

				MasDietIndentItem indentItem = new MasDietIndentItem();
				indentItem.setIndentItemCode(indentItemCode);
				indentItem.setIndentItemName(indentItemName);
				indentItem.setIndentItemType(type);
				indentItem.setIndentGroup(box.getString(INDENT_GROUP));
				indentItem.setDenominations(box.get("denominations"));
				indentItem.setExtraItem(box.getString(EXTRA_ITEM));
				indentItem.setLastChgBy(box.getString(CHANGED_BY));
				indentItem.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				indentItem.setLastChgTime(box.getString(CHANGED_TIME));
				
				MasHospital hospital= new MasHospital();
				hospital.setId(hospitalId);
				indentItem.setHospital(hospital);
				indentItem.setStatus("y");
				hbt.save(indentItem);
				successfullyAdded = true;
			} else {
				map.put("duplicateList", duplicateList);
				successfullyAdded = false;
			}
			map.put("successfullyAdded", successfullyAdded);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editDietIndentItem(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		boolean successfullyUpdate = false;
		List<MasDietIndentItem> duplicateList = new ArrayList<MasDietIndentItem>();

		int indentItemId = (Integer) box.getInt(COMMON_ID);
		String indentItemCode = (String) box.getString(CODE);
		String indentItemName = (String) box.getString(SEARCH_NAME);
		String type = (String) box.getString(ITEM_TYPE);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Session session = getSession();
			duplicateList = session.createCriteria(MasDietIndentItem.class)
					.add(Restrictions.not(Expression.eq("Id", indentItemId)))
					.add(Restrictions.eq("IndentItemCode", indentItemCode))
					.add(Restrictions.eq("IndentItemName", indentItemName))
					.add(Restrictions.eq("IndentItemType", type)).list();

			if (duplicateList.size() == 0) {

				MasDietIndentItem indentItem = (MasDietIndentItem) hbt.load(
						MasDietIndentItem.class, indentItemId);
				indentItem.setIndentItemName(indentItemName);
				indentItem.setIndentItemType(type);
				indentItem.setIndentGroup(box.getString(INDENT_GROUP));
				indentItem.setDenominations(box.get("denominations"));
				indentItem.setExtraItem(box.getString(EXTRA_ITEM));
				indentItem.setLastChgBy(box.getString(CHANGED_BY));
				indentItem.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				indentItem.setLastChgTime(box.getString(CHANGED_TIME));
				indentItem.setStatus("y");
				hbt.update(indentItem);
				successfullyUpdate = true;
			} else {
				map.put("duplicateList", duplicateList);
				successfullyUpdate = false;
			}
			map.put("successfullyUpdate", successfullyUpdate);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean deleteDietIndentItem(Box box) {
		boolean deleted = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int indentItemId = box.getInt(COMMON_ID);
		String changedBy = box.getString(CHANGED_BY);
		Date changedDate = HMSUtil.convertStringTypeDateToDateType((String) box
				.getString(CHANGED_DATE));
		String changedTime = box.getString(CHANGED_TIME);

		try {
			MasDietIndentItem indentItem = (MasDietIndentItem) hbt.load(
					MasDietIndentItem.class, indentItemId);
			indentItem.setStatus("n");
			if (box.getString("flag") != null) {
				String flag = (String) box.getString("flag");
				if (flag.equals("InActivate")) {
					indentItem.setStatus("n");
				} else if (flag.equals("Activate")) {
					indentItem.setStatus("y");
				}
			}
			indentItem.setLastChgBy(changedBy);
			indentItem.setLastChgDate(changedDate);
			indentItem.setLastChgTime(changedTime);
			hbt.update(indentItem);
			deleted = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return deleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDietIndentItem(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();

		Session session = getSession();
		int radioValue = box.getInt(SELECTED_RADIO);
		String searchName = box.getString(SEARCH_FIELD);
		String searchProperty = "";
		map = showDietIndentItemJsp();
		//System.out.println("radio value=== " + radioValue);
		try {
			if (radioValue == 1) {
				searchProperty = "IndentItemCode";
			} else {
				searchProperty = "IndentItemName";
			}
			indentItemList = session.createCriteria(MasDietIndentItem.class)
					.add(Restrictions.like(searchProperty, searchName + "%"))
					.list();
			System.out
					.println("indent item list ---- " + indentItemList.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("indentItemList", indentItemList);
		return map;
	}

}