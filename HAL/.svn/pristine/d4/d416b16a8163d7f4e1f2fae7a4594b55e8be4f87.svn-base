/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * DietDataServiceImpl.java – 
 * Purpose of the class - This is for Diet Module. 
 * @author  Ritu Sahu 
 * Create Date: 5th Sep,2008   
 * Revision Date:      
 * Revision By: Purpose
 * @version 1.0  
 **/
package jkt.hms.diet.dataservice;

import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.CONDITION;
import static jkt.hms.util.RequestConstants.DATE;
import static jkt.hms.util.RequestConstants.DEATH_OFF;
import static jkt.hms.util.RequestConstants.DEATH_OTH;
import static jkt.hms.util.RequestConstants.DEMAND_DATE;
import static jkt.hms.util.RequestConstants.DEMAND_SERIAL_NO;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DIET_COMBINATION_ID;
import static jkt.hms.util.RequestConstants.DIET_DETAILS_ID;
import static jkt.hms.util.RequestConstants.DIET_ID;
import static jkt.hms.util.RequestConstants.DIET_ITEMS_ID;
import static jkt.hms.util.RequestConstants.DIET_TYPE_ID;
import static jkt.hms.util.RequestConstants.DISCHARGE_OFF;
import static jkt.hms.util.RequestConstants.DISCHARGE_OTH;
import static jkt.hms.util.RequestConstants.EXTRA_SCALE;
import static jkt.hms.util.RequestConstants.FOR_DATE;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.INDENT_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.ITEM_ID;
import static jkt.hms.util.RequestConstants.ITEM_NAME;
import static jkt.hms.util.RequestConstants.LIME_SUGAR_PATIENTS;
import static jkt.hms.util.RequestConstants.MEDICAL_OFFICER_ID;
import static jkt.hms.util.RequestConstants.MENU_TYPE;
import static jkt.hms.util.RequestConstants.MONTH;
import static jkt.hms.util.RequestConstants.NIGHT_DUTY_PERSONS;
import static jkt.hms.util.RequestConstants.PATIENT_CATEGORY;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.QUANTITY_DEMANDED;
import static jkt.hms.util.RequestConstants.RATION_TYPE;
import static jkt.hms.util.RequestConstants.REMAIN_OFF;
import static jkt.hms.util.RequestConstants.REMAIN_OTH;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.STRENGTH;
import static jkt.hms.util.RequestConstants.THERAPEUTIC_DIET_ID;
import static jkt.hms.util.RequestConstants.TOTAL_PATIENT;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TRANSFER_IN_OFF;
import static jkt.hms.util.RequestConstants.TRANSFER_IN_OTH;
import static jkt.hms.util.RequestConstants.TRANSFER_OUT_OFF;
import static jkt.hms.util.RequestConstants.TRANSFER_OUT_OTH;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.VALID_FROM_DATE;
import static jkt.hms.util.RequestConstants.YEAR;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import jkt.hms.masters.business.DietBreakfastSummary;
import jkt.hms.masters.business.DietDailyExtraSummary;
import jkt.hms.masters.business.DietDailyGeneralSummary;
import jkt.hms.masters.business.DietDailySummary;
import jkt.hms.masters.business.DietDailyTherapeuticSummary;
import jkt.hms.masters.business.DietDemandDateDetails;
import jkt.hms.masters.business.DietDemandRationHeader;
import jkt.hms.masters.business.DietDemandRationItems;
import jkt.hms.masters.business.DietDemandRationStrength;
import jkt.hms.masters.business.DietDetails;
import jkt.hms.masters.business.DietExtraItemFormula;
import jkt.hms.masters.business.DietIndentItemFormula;
import jkt.hms.masters.business.DietMenuItemFormula;
import jkt.hms.masters.business.DietWardBreakfastSummary;
import jkt.hms.masters.business.Discharge;
import jkt.hms.masters.business.ExpiryDetails;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiet;
import jkt.hms.masters.business.MasDietCombination;
import jkt.hms.masters.business.MasDietIndentItem;
import jkt.hms.masters.business.MasDietItems;
import jkt.hms.masters.business.MasDietMenuItem;
import jkt.hms.masters.business.MasDietType;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreUnit;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Transfer;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DietDataServiceImpl extends HibernateDaoSupport implements
		DietDataService {

	/**
	 * --------------------------- Method to show Menu Item Formula jsp
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMenuItemFormulaJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<DietMenuItemFormula> menuItemFormulaList = new ArrayList<DietMenuItemFormula>();
		List<MasDietItems> dietItemsList = new ArrayList<MasDietItems>();
		List<String> menuTypeList = new ArrayList<String>();
		List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();
		List<MasStoreUnit> uomList = new ArrayList<MasStoreUnit>();
		List<MasDietMenuItem> menuItemList = new ArrayList<MasDietMenuItem>();

		Session session = (Session) getSession();
		try {
			session.clear();
			menuTypeList = session.createCriteria(MasDietMenuItem.class)
					.setProjection(
							Projections.distinct(Projections.projectionList()
									.add(Projections.property("MenuType"))))
					.list();

			menuItemFormulaList = session.createCriteria(
					DietMenuItemFormula.class).list();
			dietCombinationList = session.createCriteria(
					MasDietCombination.class).add(
					Restrictions.eq("Status", "y")).list();
			dietItemsList = session.createCriteria(MasDietItems.class).add(
					Restrictions.eq("Status", "y")).list();
			uomList = session.createCriteria(MasStoreUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			menuItemList = session.createCriteria(MasDietMenuItem.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("menuItemFormulaList", menuItemFormulaList);
		map.put("dietCombinationList", dietCombinationList);
		map.put("dietItemsList", dietItemsList);
		map.put("uomList", uomList);
		map.put("menuTypeList", menuTypeList);
		map.put("menuItemList", menuItemList);
		return map;
	}

	/**
	 * --------------------------- Method to submit Menu Item Formula details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> addMenuItemFormula(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		DietMenuItemFormula menuItemFormula = new DietMenuItemFormula();
		List<DietMenuItemFormula> existingList = new ArrayList<DietMenuItemFormula>();
		Session session = getSession();
		boolean saved = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int dietCombinationId = box.getInt(DIET_COMBINATION_ID);
		int dietItemsId = box.getInt(DIET_ITEMS_ID);
		String menuType = box.getString(MENU_TYPE);
		Date validFromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(VALID_FROM_DATE));
		String patientCategory = box.getString(PATIENT_CATEGORY);

		try {

			MasDietCombination dietCombination = new MasDietCombination();
			dietCombination.setId(dietCombinationId);
			menuItemFormula.setDietCombination(dietCombination);

			MasDietItems dietItems = new MasDietItems();
			dietItems.setId(dietItemsId);
			menuItemFormula.setDietItems(dietItems);

			MasStoreUnit storeUnit = new MasStoreUnit();
			storeUnit.setId(box.getInt(UNIT_ID));
			menuItemFormula.setUnit(storeUnit);

			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			menuItemFormula.setHospital(hospital);

			menuItemFormula.setMenuType(menuType);
			menuItemFormula
					.setQuantity(new BigDecimal(box.getString(QUANTITY)));
			menuItemFormula.setPatientCategory(patientCategory);
			menuItemFormula.setValidityStartDate(validFromDate);
			menuItemFormula.setLastChgBy(box.getString(CHANGED_BY));
			menuItemFormula.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			menuItemFormula.setLastChgTime(box.getString(CHANGED_TIME));
			menuItemFormula.setStatus("y");

			existingList = session.createCriteria(DietMenuItemFormula.class)
					.add(Restrictions.eq("MenuType", menuType))
					.add(Restrictions.eq("PatientCategory", patientCategory))
					.createAlias("DietItems", "di").add(
							Restrictions.eq("di.Id", dietItemsId)).createAlias(
							"DietCombination", "dc").add(
							Restrictions.eq("dc.Id", dietCombinationId)).list();

			Date validityStartDate = null;
			int id = 0;
			String flag = "";
			if (existingList.size() > 0) {
				for (DietMenuItemFormula obj : existingList) {
					id = obj.getId();
					validityStartDate = obj.getValidityStartDate();
					if (!HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateNotEqual";
					} else {
						flag = "dateEqual";
						break;
					}
				}

				if (flag.equals("dateNotEqual")) {
					DietMenuItemFormula itemFormula = (DietMenuItemFormula) hbt
							.load(DietMenuItemFormula.class, id);
					itemFormula.setStatus("n");
					hbt.update(itemFormula);
					hbt.save(menuItemFormula);
					saved = true;
				} else {
					saved = false;
					map.put("existingList", existingList);
				}

			} else if (existingList.size() == 0) {
				hbt.save(menuItemFormula);
				saved = true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	/**
	 * --------------------------- Method to Edit Menu Item Formula details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> editMenuItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<DietMenuItemFormula> existingList = new ArrayList<DietMenuItemFormula>();
		Session session = getSession();
		boolean updated = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int menuItemFormulaId = box.getInt(COMMON_ID);
		int dietCombinationId = box.getInt(DIET_COMBINATION_ID);
		int dietItemsId = box.getInt(DIET_ITEMS_ID);
		String menuType = box.getString(MENU_TYPE);
		Date validFromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(VALID_FROM_DATE));
		String patientCategory = box.getString(PATIENT_CATEGORY);

		try {
			DietMenuItemFormula menuItemFormula = (DietMenuItemFormula) hbt
					.load(DietMenuItemFormula.class, menuItemFormulaId);

			MasDietCombination dietCombination = new MasDietCombination();
			dietCombination.setId(dietCombinationId);
			menuItemFormula.setDietCombination(dietCombination);

			MasDietItems dietItems = new MasDietItems();
			dietItems.setId(dietItemsId);
			menuItemFormula.setDietItems(dietItems);

			MasStoreUnit storeUnit = new MasStoreUnit();
			storeUnit.setId(box.getInt(UNIT_ID));
			menuItemFormula.setUnit(storeUnit);

			menuItemFormula.setMenuType(menuType);
			menuItemFormula
					.setQuantity(new BigDecimal(box.getString(QUANTITY)));
			menuItemFormula.setPatientCategory(patientCategory);
			menuItemFormula.setValidityStartDate(validFromDate);
			menuItemFormula.setLastChgBy(box.getString(CHANGED_BY));
			menuItemFormula.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			menuItemFormula.setLastChgTime(box.getString(CHANGED_TIME));

			existingList = session.createCriteria(DietMenuItemFormula.class)
					.add(Restrictions.eq("MenuType", menuType))
					.add(Restrictions.eq("PatientCategory", patientCategory))
					.add(
							Restrictions.not(Expression.eq("Id",
									menuItemFormulaId))).createAlias(
							"DietItems", "di").add(
							Restrictions.eq("di.Id", dietItemsId)).createAlias(
							"DietCombination", "dc").add(
							Restrictions.eq("dc.Id", dietCombinationId)).list();

			Date validityStartDate = null;
			int id = 0;
			String flag = "";
			if (existingList.size() > 0) {
				for (DietMenuItemFormula obj : existingList) {
					id = obj.getId();
					validityStartDate = obj.getValidityStartDate();
					if (!HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateNotEqual";
					} else {
						flag = "dateEqual";
						break;
					}
				}

				if (flag.equals("dateNotEqual")) {
					DietMenuItemFormula itemFormula = (DietMenuItemFormula) hbt
							.load(DietMenuItemFormula.class, id);
					itemFormula.setStatus("n");
					hbt.update(itemFormula);
					updated = true;
				} else {
					updated = false;
					map.put("existingList", existingList);
				}
			} else if (existingList.size() == 0) {
				hbt.update(menuItemFormula);
				updated = true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		map.put("updated", updated);
		return map;
	}

	/**
	 * --------------------------- Method to delete Menu Item Formula details
	 * -----------------------------------
	 * 
	 */

	public Map<String, Object> deleteMenuItemFormula(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();

		boolean deleted = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int menuItemFormulaId = box.getInt(COMMON_ID);
		String changedBy = box.getString(CHANGED_BY);
		Date changedDate = HMSUtil.convertStringTypeDateToDateType((String) box
				.getString(CHANGED_DATE));
		String changedTime = box.getString(CHANGED_TIME);

		try {
			DietMenuItemFormula dietMenuItemFormula = (DietMenuItemFormula) hbt
					.load(DietMenuItemFormula.class, menuItemFormulaId);
			dietMenuItemFormula.setStatus("n");
			dietMenuItemFormula.setLastChgBy(changedBy);
			dietMenuItemFormula.setLastChgDate(changedDate);
			dietMenuItemFormula.setLastChgTime(changedTime);
			hbt.update(dietMenuItemFormula);
			deleted = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("deleted", deleted);
		return map;
	}

	/**
	 * --------------------------- Method to Search Menu Item Formula
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMenuItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DietMenuItemFormula> menuItemFormulaList = new ArrayList<DietMenuItemFormula>();
		Session session = getSession();

		try {
			String itemName = box.getString(ITEM_NAME);
			map = showMenuItemFormulaJsp();
			menuItemFormulaList = session.createCriteria(
					DietMenuItemFormula.class).createAlias("DietItems", "di")
					.add(Restrictions.like("di.DietItemsName", itemName + "%"))
					.list();
			map.put("menuItemFormulaList", menuItemFormulaList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * --------------------------- Method to show Extra Item Formula jsp
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showExtraItemFormulaJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<DietExtraItemFormula> extraItemFormulaList = new ArrayList<DietExtraItemFormula>();
		List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();
		List<MasStoreUnit> uomList = new ArrayList<MasStoreUnit>();

		Session session = (Session) getSession();

		try {
			session.clear();
			extraItemFormulaList = session.createCriteria(
					DietExtraItemFormula.class).list();
			indentItemList = session.createCriteria(MasDietIndentItem.class)
					.add(Restrictions.eq("ExtraItem", "y")).add(
							Restrictions.eq("Status", "y")).list();
			uomList = session.createCriteria(MasStoreUnit.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("extraItemFormulaList", extraItemFormulaList);
		map.put("indentItemList", indentItemList);
		map.put("uomList", uomList);

		return map;
	}

	/**
	 * --------------------------- Method to submit Extra Item Formula details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> addExtraItemFormula(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		DietExtraItemFormula extraItemFormula = new DietExtraItemFormula();
		List<DietExtraItemFormula> existingList = new ArrayList<DietExtraItemFormula>();
		Session session = getSession();
		boolean saved = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int itemId = box.getInt(ITEM_ID);
		Date validFromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(VALID_FROM_DATE));

		try {

			MasDietIndentItem indentItem = new MasDietIndentItem();
			indentItem.setId(itemId);
			extraItemFormula.setIndentItem(indentItem);

			MasStoreUnit storeUnit = new MasStoreUnit();
			storeUnit.setId(box.getInt(UNIT_ID));
			extraItemFormula.setUnit(storeUnit);

			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			extraItemFormula.setHospital(hospital);

			extraItemFormula.setExtraScale(box.getInt(EXTRA_SCALE));
			extraItemFormula.setValidityStartDate(validFromDate);
			extraItemFormula.setLastChgBy(box.getString(CHANGED_BY));
			extraItemFormula.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			extraItemFormula.setLastChgTime(box.getString(CHANGED_TIME));
			extraItemFormula.setStatus("y");

			existingList = session.createCriteria(DietExtraItemFormula.class)
					.createAlias("IndentItem", "i").add(
							Restrictions.eq("i.Id", itemId)).list();

			Date validityStartDate = null;
			int id = 0;
			String flag = "";
			if (existingList.size() > 0) {
				for (DietExtraItemFormula obj : existingList) {
					id = obj.getId();
					validityStartDate = obj.getValidityStartDate();
					if (!HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateNotEqual";
					} else {
						flag = "dateEqual";
						break;
					}
				}

				if (flag.equals("dateNotEqual")) {
					DietExtraItemFormula itemFormula = (DietExtraItemFormula) hbt
							.load(DietExtraItemFormula.class, id);
					itemFormula.setStatus("n");
					hbt.update(itemFormula);
					hbt.save(extraItemFormula);
					saved = true;
				} else {
					saved = false;
					map.put("existingList", existingList);
				}

			} else if (existingList.size() == 0) {
				hbt.save(extraItemFormula);
				saved = true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	/**
	 * --------------------------- Method to Edit Extra Item Formula details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> editExtraItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<DietExtraItemFormula> existingList = new ArrayList<DietExtraItemFormula>();
		Session session = (Session) getSession();
		boolean updated = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int extraItemFormulaId = box.getInt(COMMON_ID);
		int itemId = box.getInt(ITEM_ID);
		Date validFromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(VALID_FROM_DATE));

		try {
			existingList = session.createCriteria(DietExtraItemFormula.class)
					.add(
							Restrictions.not(Expression.eq("Id",
									extraItemFormulaId))).add(
							Restrictions.eq("Status", "y")).createAlias(
							"IndentItem", "i").add(
							Restrictions.eq("i.Id", itemId)).list();

			DietExtraItemFormula extraItemFormula = new DietExtraItemFormula();

			extraItemFormula = (DietExtraItemFormula) hbt.load(
					DietExtraItemFormula.class, extraItemFormulaId);

			MasDietIndentItem indentItem = new MasDietIndentItem();
			indentItem.setId(itemId);
			extraItemFormula.setIndentItem(indentItem);

			MasStoreUnit storeUnit = new MasStoreUnit();
			storeUnit.setId(box.getInt(UNIT_ID));
			extraItemFormula.setUnit(storeUnit);

			extraItemFormula.setExtraScale(box.getInt(EXTRA_SCALE));
			extraItemFormula.setValidityStartDate(validFromDate);
			extraItemFormula.setLastChgBy(box.getString(CHANGED_BY));
			extraItemFormula.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			extraItemFormula.setLastChgTime(box.getString(CHANGED_TIME));
			extraItemFormula.setStatus("y");

			Date validityStartDate = null;
			int id = 0;
			String flag = "";
			if (existingList.size() > 0) {
				for (DietExtraItemFormula obj : existingList) {
					id = obj.getId();
					validityStartDate = obj.getValidityStartDate();
					if (!HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateNotEqual";
					} else if (HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateEqual";
						break;
					}

				}
				if (flag.equals("dateNotEqual")) {
					DietExtraItemFormula itemFormula = (DietExtraItemFormula) hbt
							.load(DietExtraItemFormula.class, id);
					itemFormula.setStatus("n");
					hbt.update(itemFormula);
					hbt.update(extraItemFormula);
					updated = true;
				} else if (flag.equals("dateEqual")) {
					updated = false;
					map.put("existingList", existingList);

				}
			} else if (existingList.size() == 0) {
				hbt.update(extraItemFormula);
				updated = true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		map.put("updated", updated);
		return map;
	}

	/**
	 * --------------------------- Method to delete Extra Item Formula details
	 * -----------------------------------
	 * 
	 */

	public Map<String, Object> deleteExtraItemFormula(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();

		boolean deleted = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int extraItemFormulaId = box.getInt(COMMON_ID);
		String changedBy = box.getString(CHANGED_BY);
		Date changedDate = HMSUtil.convertStringTypeDateToDateType((String) box
				.getString(CHANGED_DATE));
		String changedTime = box.getString(CHANGED_TIME);

		try {
			DietExtraItemFormula dietExtraItemFormula = (DietExtraItemFormula) hbt
					.load(DietExtraItemFormula.class, extraItemFormulaId);
			dietExtraItemFormula.setStatus("n");
			dietExtraItemFormula.setLastChgBy(changedBy);
			dietExtraItemFormula.setLastChgDate(changedDate);
			dietExtraItemFormula.setLastChgTime(changedTime);
			hbt.update(dietExtraItemFormula);
			deleted = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("deleted", deleted);
		return map;
	}

	/**
	 * --------------------------- Method to Search Extra Item Formula
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchExtraItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DietExtraItemFormula> extraItemFormulaList = new ArrayList<DietExtraItemFormula>();
		Session session = getSession();

		try {
			String itemName = box.getString(ITEM_NAME);
			map = showExtraItemFormulaJsp();
			extraItemFormulaList = session
					.createCriteria(DietExtraItemFormula.class)
					.createAlias("IndentItem", "di")
					.add(Restrictions.like("di.IndentItemName", itemName + "%"))
					.list();
			map.put("extraItemFormulaList", extraItemFormulaList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * --------------------------- Method to show Indent Item Formula jsp
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showIndentItemFormulaJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<DietIndentItemFormula> indentItemFormulaList = new ArrayList<DietIndentItemFormula>();
		List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();
		List<MasStoreUnit> uomList = new ArrayList<MasStoreUnit>();
		List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();

		Session session = (Session) getSession();

		try {
			session.clear();
			indentItemFormulaList = session.createCriteria(
					DietIndentItemFormula.class).list();
			indentItemList = session.createCriteria(MasDietIndentItem.class)
					.add(Restrictions.eq("Status", "y")).list();
			uomList = session.createCriteria(MasStoreUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			dietCombinationList = session.createCriteria(
					MasDietCombination.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("dietCombinationList", dietCombinationList);
		map.put("indentItemFormulaList", indentItemFormulaList);
		map.put("indentItemList", indentItemList);
		map.put("uomList", uomList);

		return map;
	}

	/**
	 * --------------------------- Method to submit Indent Item Formula details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> addIndentItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		DietIndentItemFormula indentItemFormula = new DietIndentItemFormula();
		List<DietIndentItemFormula> existingList = new ArrayList<DietIndentItemFormula>();
		Session session = getSession();
		boolean saved = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int dietCombinationId = box.getInt(DIET_COMBINATION_ID);
		int itemsId = box.getInt(ITEM_ID);
		Date validFromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(VALID_FROM_DATE));
		String patientCategory = box.getString(PATIENT_CATEGORY);

		try {

			MasDietCombination dietCombination = new MasDietCombination();
			dietCombination.setId(dietCombinationId);
			indentItemFormula.setDietCombination(dietCombination);

			MasDietIndentItem indentItems = new MasDietIndentItem();
			indentItems.setId(itemsId);
			indentItemFormula.setIndentItem(indentItems);

			MasStoreUnit storeUnit = new MasStoreUnit();
			storeUnit.setId(box.getInt(UNIT_ID));
			indentItemFormula.setUnit(storeUnit);

			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			indentItemFormula.setHospital(hospital);

			indentItemFormula.setQuantity(new BigDecimal(box
					.getString(QUANTITY)));
			indentItemFormula.setPatientCategory(patientCategory);
			indentItemFormula.setValidityStartDate(validFromDate);
			indentItemFormula.setLastChgBy(box.getString(CHANGED_BY));
			indentItemFormula.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			indentItemFormula.setLastChgTime(box.getString(CHANGED_TIME));
			indentItemFormula.setStatus("y");

			existingList = session.createCriteria(DietIndentItemFormula.class)
					.add(Restrictions.eq("PatientCategory", patientCategory))
					.createAlias("IndentItem", "i").add(
							Restrictions.eq("i.Id", itemsId)).createAlias(
							"DietCombination", "dc").add(
							Restrictions.eq("dc.Id", dietCombinationId)).list();

			Date validityStartDate = null;
			int id = 0;
			String flag = "";
			if (existingList.size() > 0) {
				for (DietIndentItemFormula obj : existingList) {
					id = obj.getId();
					validityStartDate = obj.getValidityStartDate();
					if (!HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateNotEqual";
					} else {
						flag = "dateEqual";
						break;
					}
				}

				if (flag.equals("dateNotEqual")) {
					DietIndentItemFormula itemFormula = (DietIndentItemFormula) hbt
							.load(DietIndentItemFormula.class, id);
					itemFormula.setStatus("n");
					hbt.update(itemFormula);
					hbt.save(indentItemFormula);
					saved = true;
				} else {
					saved = false;
					map.put("existingList", existingList);
				}

			} else if (existingList.size() == 0) {
				hbt.save(indentItemFormula);
				saved = true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	/**
	 * --------------------------- Method to Edit Indent Item Formula details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> editIndentItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<DietIndentItemFormula> existingList = new ArrayList<DietIndentItemFormula>();
		Session session = getSession();
		boolean updated = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int indentItemFormulaId = box.getInt(COMMON_ID);
		int dietCombinationId = box.getInt(DIET_COMBINATION_ID);
		int itemsId = box.getInt(ITEM_ID);
		Date validFromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(VALID_FROM_DATE));
		String patientCategory = box.getString(PATIENT_CATEGORY);

		try {
			DietIndentItemFormula indentItemFormula = (DietIndentItemFormula) hbt
					.load(DietIndentItemFormula.class, indentItemFormulaId);

			MasDietCombination dietCombination = new MasDietCombination();
			dietCombination.setId(dietCombinationId);
			indentItemFormula.setDietCombination(dietCombination);

			MasDietIndentItem indentItems = new MasDietIndentItem();
			indentItems.setId(itemsId);
			indentItemFormula.setIndentItem(indentItems);

			MasStoreUnit storeUnit = new MasStoreUnit();
			storeUnit.setId(box.getInt(UNIT_ID));
			indentItemFormula.setUnit(storeUnit);

			indentItemFormula.setQuantity(new BigDecimal(box
					.getString(QUANTITY)));
			indentItemFormula.setPatientCategory(patientCategory);
			indentItemFormula.setValidityStartDate(validFromDate);
			indentItemFormula.setLastChgBy(box.getString(CHANGED_BY));
			indentItemFormula.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			indentItemFormula.setLastChgTime(box.getString(CHANGED_TIME));

			existingList = session.createCriteria(DietIndentItemFormula.class)
					.add(Restrictions.eq("PatientCategory", patientCategory))
					.add(
							Restrictions.not(Expression.eq("Id",
									indentItemFormulaId))).createAlias(
							"IndentItem", "i").add(
							Restrictions.eq("i.Id", itemsId)).createAlias(
							"DietCombination", "dc").add(
							Restrictions.eq("dc.Id", dietCombinationId)).list();

			Date validityStartDate = null;
			int id = 0;
			String flag = "";
			if (existingList.size() > 0) {
				for (DietIndentItemFormula obj : existingList) {
					id = obj.getId();
					validityStartDate = obj.getValidityStartDate();
					if (!HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateNotEqual";
					} else {
						flag = "dateEqual";
						break;
					}
				}

				if (flag.equals("dateNotEqual")) {
					DietIndentItemFormula itemFormula = (DietIndentItemFormula) hbt
							.load(DietIndentItemFormula.class, id);
					itemFormula.setStatus("n");
					hbt.update(itemFormula);
					updated = true;
				} else {
					updated = false;
					map.put("existingList", existingList);
				}
			} else if (existingList.size() == 0) {
				hbt.update(indentItemFormula);
				updated = true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		map.put("updated", updated);
		return map;
	}

	/**
	 * --------------------------- Method to delete Indent Item Formula details
	 * -----------------------------------
	 * 
	 */

	public Map<String, Object> deleteIndentItemFormula(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();

		boolean deleted = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int indentItemFormulaId = box.getInt(COMMON_ID);
		String changedBy = box.getString(CHANGED_BY);
		Date changedDate = HMSUtil.convertStringTypeDateToDateType((String) box
				.getString(CHANGED_DATE));
		String changedTime = box.getString(CHANGED_TIME);

		try {
			DietIndentItemFormula indentItemFormula = (DietIndentItemFormula) hbt
					.load(DietIndentItemFormula.class, indentItemFormulaId);
			indentItemFormula.setStatus("n");
			indentItemFormula.setLastChgBy(changedBy);
			indentItemFormula.setLastChgDate(changedDate);
			indentItemFormula.setLastChgTime(changedTime);
			hbt.update(indentItemFormula);
			deleted = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("deleted", deleted);
		return map;
	}

	/**
	 * --------------------------- Method to Search Extra Item Formula
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchIndentItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DietIndentItemFormula> indentItemFormulaList = new ArrayList<DietIndentItemFormula>();
		Session session = getSession();

		try {
			String itemName = box.getString(ITEM_NAME);
			map = showIndentItemFormulaJsp();
			indentItemFormulaList = session.createCriteria(
					DietIndentItemFormula.class)
					.createAlias("IndentItem", "di").add(
							Restrictions.like("di.IndentItemName", itemName
									+ "%")).list();
			map.put("indentItemFormulaList", indentItemFormulaList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * --------------------------- Method to get patient list for change diet
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientListForDietChange(int departmentId) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<DietDetails> dietDetailsList = new ArrayList<DietDetails>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<MasDiet> dietList = new ArrayList<MasDiet>();
		List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
		List<Transfer> todayTransferList = new ArrayList<Transfer>();
		List<Transfer> todayTransferOutList = new ArrayList<Transfer>();
		List<Discharge> todayDischargeList = new ArrayList<Discharge>();
		List<Discharge> gCurrDateDischargeList = new ArrayList<Discharge>();
		List<Discharge> currDateDischargeList = new ArrayList<Discharge>();
		List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String deptName = "";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, +1);
		Date nextDate = cal.getTime();
		Session session = getSession();

		try {
			deptList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Id", departmentId)).list();

			gCurrDateDischargeList = session.createCriteria(Discharge.class)
					.createAlias("Ward", "d").add(
							Restrictions.eq("d.Id", departmentId)).add(
							Restrictions.gt("DateOfDischarge", HMSUtil
									.convertStringTypeDateToDateType(date)))
					.list();

			currDateDischargeList = session.createCriteria(Discharge.class)
					.createAlias("Ward", "d").add(
							Restrictions.eq("d.Id", departmentId)).add(
							Restrictions.eq("DateOfDischarge", HMSUtil
									.convertStringTypeDateToDateType(date)))
					.list();

			List curDisObj = new ArrayList();
			String list = "";
			for (Discharge discharge : currDateDischargeList) {
				curDisObj.add(discharge.getHin().getId());

				if (list.length() > 0) {
					list = list + "," + discharge.getHin().getId();
				} else {
					list = list + discharge.getHin().getId();
				}
			}
			if (currDateDischargeList.size() > 0) {
				try {
					int dateOfMonth, month, year;
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(nextDate);
					StringBuffer dateOnly = new StringBuffer();
					year = calendar.get(Calendar.YEAR);
					dateOnly.append(year);
					dateOnly.append("/");
					month = calendar.get(Calendar.MONTH) + 1;
					if (month < 10)
						dateOnly.append("0");
					dateOnly.append(month);
					dateOnly.append("/");
					dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
					if (dateOfMonth < 10)
						dateOnly.append("0");
					dateOnly.append(dateOfMonth);

					String hql = "delete from jkt.hms.masters.business.DietDetails as a where a.DietDate='"
							+ dateOnly.toString()
							+ "' and a.Hin.Id in("
							+ list
							+ ")";
					Query query = session.createQuery(hql);
					int row = query.executeUpdate();
					//System.out.println("row:::222::" + row);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			List objectList1 = new ArrayList();
			for (Discharge discharge : gCurrDateDischargeList) {
				objectList1.add(discharge.getAdNo());
			}
			dietDetailsList = session.createCriteria(DietDetails.class).add(
					Restrictions.eq("DietDate", nextDate)).add(
					Restrictions.eq("Department.Id", departmentId)).list();

			todayTransferList = session.createCriteria(Transfer.class)
					.createAlias("ToWard", "d").add(
							Restrictions.eq("d.Id", departmentId)).add(
							Restrictions.eq("DateOfTransfer", HMSUtil
									.convertStringTypeDateToDateType(date)))
					.list();

			todayTransferOutList = session.createCriteria(Transfer.class)
					.createAlias("FromWard", "d").add(
							Restrictions.eq("d.Id", departmentId)).add(
							Restrictions.eq("DateOfTransfer", HMSUtil
									.convertStringTypeDateToDateType(date)))
					.list();
			int dateOfMonth, month, year;
			Calendar calendar = Calendar.getInstance();
			// calendar.setTime( nextDate );
			StringBuffer dateOnly = new StringBuffer();
			year = calendar.get(Calendar.YEAR);
			dateOnly.append(year);
			dateOnly.append("-");
			month = calendar.get(Calendar.MONTH) + 1;
			if (month < 10)
				dateOnly.append("0");
			dateOnly.append(month);
			dateOnly.append("-");
			dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
			if (dateOfMonth < 10)
				dateOnly.append("0");
			dateOnly.append(dateOfMonth);

			todayDischargeList = session.createCriteria(Discharge.class)
					.createAlias("Ward", "d").add(
							Restrictions.eq("d.Id", departmentId)).add(
							Restrictions.eq("DateOfDischarge", HMSUtil
									.convertStringTypeDateToDateType(date)))
					.list();

			List objectList = new ArrayList();
			for (Transfer transfer : todayTransferList) {
				objectList.add(transfer.getHin().getId());
			}

			for (Discharge discharge : todayDischargeList) {
				objectList.add(discharge.getHin().getId());
			}

			List objectList2 = new ArrayList();
			for (Transfer transferOut : todayTransferOutList) {
				objectList2.add(transferOut.getHin().getId());
			}

			dietList = session.createCriteria(MasDiet.class).add(
					Restrictions.eq("Status", "y")).list();

			dietTypeList = session.createCriteria(MasDietType.class).add(
					Restrictions.eq("Status", "y")).list();

			dietCombinationList = session.createCriteria(
					MasDietCombination.class).add(
					Restrictions.eq("Status", "y")).list();

			if (deptList.size() > 0) {
				MasDepartment masDepartment = (MasDepartment) deptList.get(0);
				deptName = masDepartment.getDepartmentName();
				map.put("deptName", deptName);
			}

			map.put("dietList", dietList);
			map.put("dietTypeList", dietTypeList);
			map.put("dietCombinationList", dietCombinationList);
			map.put("dietDetailsList", dietDetailsList);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * --------------------------- Method to search patient diet details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDietDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DietDetails> dietDetailsList = new ArrayList<DietDetails>();
		List<MasDiet> dietList = new ArrayList<MasDiet>();
		List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
		List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();

		String serviceNo = box.getString(SERVICE_NO);
		String hin = box.getString(HIN_NO);
		String adNo = box.getString(AD_NO);
		int departmentId = box.getInt("departmentId");
		String deptName = "";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, +1);
		Date nextDate = cal.getTime();

		Session session = getSession();
		try {
			deptList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Id", departmentId)).list();

			dietList = session.createCriteria(MasDiet.class).add(
					Restrictions.eq("Status", "y")).list();

			dietTypeList = session.createCriteria(MasDietType.class).add(
					Restrictions.eq("Status", "y")).list();

			dietCombinationList = session.createCriteria(
					MasDietCombination.class).add(
					Restrictions.eq("Status", "y")).list();

			if (deptList.size() > 0) {
				MasDepartment masDepartment = (MasDepartment) deptList.get(0);
				deptName = masDepartment.getDepartmentName();
				map.put("deptName", deptName);
			}
			Criteria crit = null;

			crit = session.createCriteria(DietDetails.class).createAlias(
					"Inpatient", "ip").add(Restrictions.eq("ip.AdStatus", "A"))
					.createAlias("ip.Department", "d").add(
							Restrictions.eq("d.Id", departmentId)).add(
							Restrictions.eq("DietDate", nextDate));

			if ((serviceNo != null && !(serviceNo.equals("")))
					|| (hin != null && !(hin.equals("")))) {
				crit = crit.createAlias("Hin", "p");
			}
			if (adNo != null && !(adNo.equals(""))) {
				crit = crit.add(Restrictions.eq("ip.AdNo", adNo));
			}
			if (serviceNo != null && !(serviceNo.equals(""))) {
				crit = crit.add(Restrictions.eq("p.ServiceNo", serviceNo));
			}
			if (hin != null && !(hin.equals(""))) {
				crit = crit.add(Restrictions.eq("p.HinNo", hin));
			}

			dietDetailsList = crit.list();
			map.put("dietDetailsList", dietDetailsList);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("dietList", dietList);
		map.put("dietTypeList", dietTypeList);
		map.put("dietCombinationList", dietCombinationList);
		return map;
	}

	/**
	 * --------------------------- Method to Save Patient diet details through
	 * scheduler -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public boolean addPatientDietDetails() {

		List<DietDetails> todayDietList = new ArrayList<DietDetails>();
		List<DietDetails> nextDayDietList = new ArrayList<DietDetails>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
		List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();
		List<Transfer> todayTransferList = new ArrayList<Transfer>();
		List<Discharge> todayDischargeList = new ArrayList<Discharge>();
		List<ExpiryDetails> todayExpiryList = new ArrayList<ExpiryDetails>();
		List<Discharge> gCurrDateDischargeList = new ArrayList<Discharge>();

		boolean flag = false;
		Session session = getSession();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, +1);
		Date nextDate = cal.getTime();
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DAY_OF_MONTH, -1);
		Date prevDate = cal1.getTime();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			gCurrDateDischargeList = session.createCriteria(Discharge.class)
					.add(
							Restrictions.gt("DateOfDischarge", HMSUtil
									.convertStringTypeDateToDateType(date)))
					.list();

			List objectList1 = new ArrayList();
			for (Discharge discharge : gCurrDateDischargeList) {
				objectList1.add(discharge.getAdNo());
			}
			Criteria crit = null;
			crit = session.createCriteria(DietDetails.class).add(
					Restrictions.eq("DietDate", HMSUtil
							.convertStringTypeDateToDateType(date)))
					.createAlias("Inpatient", "ip");
			if (objectList1.size() > 0) {
				crit = crit.add(Restrictions.or(Restrictions.eq("ip.AdStatus",
						"A"), Restrictions.in("ip.AdNo", objectList1)));
			} else {
				crit = crit.add(Restrictions.eq("ip.AdStatus", "A"));
			}

			todayDietList = crit.list();
			inpatientList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("AdStatus", "A")).add(
					Restrictions.lt("DateOfAddmission", HMSUtil
							.convertStringTypeDateToDateType(date))).list();

			dietTypeList = session.createCriteria(MasDietType.class).add(
					Restrictions.eq("Status", "y")).list();
			dietCombinationList = session.createCriteria(
					MasDietCombination.class).add(
					Restrictions.eq("Status", "y")).list();

			nextDayDietList = session.createCriteria(DietDetails.class).add(
					Restrictions.eq("DietDate", nextDate)).list();

			if (nextDayDietList.size() == 0) {
				if (todayDietList != null && todayDietList.size() > 0) {
					for (DietDetails dietDetails : todayDietList) {
						try {
							//
							List<Inpatient> inpatList = new ArrayList<Inpatient>();
							List<Transfer> tranList = new ArrayList<Transfer>();
							inpatList = session.createCriteria(Inpatient.class)
									.add(
											Restrictions.eq("Id", dietDetails
													.getInpatient().getId()))
									.list();
							Inpatient inpatient = (Inpatient) inpatList.get(0);

							tranList = session
									.createCriteria(Transfer.class)
									.add(
											Restrictions.eq("AdNo", inpatient
													.getAdNo()))
									.add(
											Restrictions
													.eq(
															"DateOfTransfer",
															HMSUtil
																	.convertStringTypeDateToDateType(date)))
									.list();
							if (tranList.size() == 0) {
								if (dietDetails.getDepartment().getId() == inpatient
										.getDepartment().getId()) {
									dietDetails.setDietDate(nextDate);
									dietDetails.setStatus("y");
									hbt.save(dietDetails);
								} else {
									dietDetails.setDietDate(nextDate);
									dietDetails.setStatus("y");
									dietDetails
											.setDepartment(new MasDepartment(
													inpatient.getDepartment()
															.getId()));
									hbt.save(dietDetails);
								}
							} else {
								dietDetails.setDietDate(nextDate);
								dietDetails.setStatus("y");
								hbt.save(dietDetails);
							}
							//
							// dietDetails.setDietDate(nextDate);
							// dietDetails.setStatus("y");
							// hbt.save(dietDetails);
							flag = true;
						} catch (RuntimeException e) {
							e.printStackTrace();
						}

					}
				}
			}

			todayTransferList = session.createCriteria(Transfer.class).add(
					Restrictions.eq("DateOfTransfer", prevDate)).list();

			todayDischargeList = session.createCriteria(Discharge.class).add(
					Restrictions.eq("DateOfDischarge", prevDate)).list();
			todayExpiryList = session.createCriteria(ExpiryDetails.class).add(
					Restrictions.eq("ExpiryDate", prevDate)).list();

			List<DietDetails> dietDetailsList = new ArrayList<DietDetails>();
			dietDetailsList = session.createCriteria(DietDetails.class).add(
					Restrictions.eq("DietDate", nextDate)).list();

			try {
				for (DietDetails dietDt : dietDetailsList) {
					for (Transfer transfer : todayTransferList) {
						if (transfer.getHin().getId() == dietDt.getHin()
								.getId()
								&& transfer.getToWard().getId() != dietDt
										.getDepartment().getId()) {
							DietDetails dtDetails = (DietDetails) hbt.get(
									DietDetails.class, dietDt.getId());
							MasDepartment department = new MasDepartment();
							department.setId(transfer.getToWard().getId());
							dtDetails.setDepartment(department);
							hbt.update(dtDetails);

						}
					}
				}

				for (Discharge discharge : todayDischargeList) {
					for (DietDetails dietDt : dietDetailsList) {
						if (discharge.getHin().getId() == dietDt.getHin()
								.getId()
								&& discharge.getWard().getId() != dietDt
										.getDepartment().getId()) {
							DietDetails dtDetails = (DietDetails) hbt.load(
									DietDetails.class, dietDt.getId());
							hbt.delete(dtDetails);

						}
					}
				}

				for (ExpiryDetails expiryDetails : todayExpiryList) {
					for (DietDetails dietDt : dietDetailsList) {
						if (expiryDetails.getHin().getId() == dietDt.getHin()
								.getId()
								&& expiryDetails.getWard().getId() != dietDt
										.getDepartment().getId()) {
							DietDetails dtDetails = (DietDetails) hbt.load(
									DietDetails.class, dietDt.getId());
							hbt.delete(dtDetails);

						}
					}
				}
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}

			for (Inpatient inpatient : inpatientList) {
				if (inpatient.getDietDetails() == null
						|| inpatient.getDietDetails().size() == 0) {
					DietDetails dietDetailsObj = new DietDetails();
					dietDetailsObj.setDiet(inpatient.getDiet());
					String category = inpatient.getHin().getRank()
							.getRankCategory().getRankCategoryName();
					String dietCategory = "";
					String patientCategory = "";
					if (category.equalsIgnoreCase("Officer")) {
						dietCategory = "Officer";
					} else {
						dietCategory = "Other";
					}
					String relation = inpatient.getHin().getRelation()
							.getRelationName();
					if (category.equalsIgnoreCase("Officer")) {
						patientCategory = "Officer";
					} else if (category.equalsIgnoreCase("Officer Family")) {
						patientCategory = "Officer Family";
					} else if (!category.equalsIgnoreCase("Officer")
							&& !category.equalsIgnoreCase("Officer Family")
							&& relation.equalsIgnoreCase("Self")) {
						patientCategory = "Others";
					} else if (!category.equalsIgnoreCase("Officer")
							&& !category.equalsIgnoreCase("Officer Family")
							&& !relation.equalsIgnoreCase("Self")) {
						patientCategory = "Others Family";
					}

					dietDetailsObj.setDepartment(inpatient.getDepartment());
					dietDetailsObj.setDietCategory(dietCategory);
					dietDetailsObj.setPatientCategory(patientCategory);
					dietDetailsObj.setDietDate(nextDate);
					dietDetailsObj.setHin(inpatient.getHin());
					dietDetailsObj.setHospital(inpatient.getHospital());
					dietDetailsObj.setInpatient(inpatient);
					dietDetailsObj.setStatus("y");
					dietDetailsObj.setPatientCondition("B");
					int dietTypeId = 0;
					for (MasDietType masDietType : dietTypeList) {
						if (inpatient.getDietType().equalsIgnoreCase(
								masDietType.getDietTypeName())) {
							dietTypeId = masDietType.getId();
							dietDetailsObj.setDietType(masDietType);
						}
					}

					for (MasDietCombination dietCombination : dietCombinationList) {
						if (inpatient.getDiet().getId() == dietCombination
								.getDiet().getId()
								&& dietTypeId == dietCombination.getDietType()
										.getId()
								&& dietCombination.getDemandDisplay().equals(
										"n")) {
							dietDetailsObj.setDietCombination(dietCombination);
						}
					}
					try {
						hbt.save(dietDetailsObj);
					} catch (RuntimeException e) {
						e.printStackTrace();
					}
				}
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * --------------------------- Method to Update Patient diet details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> updatePatientDietDetails(
			Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpServletRequest request = (HttpServletRequest) infoMap
				.get("request");
		boolean flag = false;

		int hospitalId = (Integer) infoMap.get("hospitalId");

		int count = Integer.parseInt(request.getParameter("counter"));

		List dietDetailsId = new ArrayList();
		List hinId = new ArrayList();
		List inpatientId = new ArrayList();
		List dietId = new ArrayList();
		List dietTypeId = new ArrayList();
		List dietCombinationId = new ArrayList();
		List condition = new ArrayList();
		List therapeuticDietId = new ArrayList();

		for (int i = 1; i <= count; i++) {
			if (request.getParameter(DIET_DETAILS_ID + i) != null) {
				dietDetailsId.add(request.getParameter(DIET_DETAILS_ID + i));

				if (request.getParameter(HIN_ID + i) != null) {
					hinId.add(request.getParameter(HIN_ID + i));
				}
				if (request.getParameter(INPATIENT_ID + i) != null) {
					inpatientId.add(request.getParameter(INPATIENT_ID + i));
				}
				if (request.getParameter(DIET_ID + i) != null) {
					dietId.add(request.getParameter(DIET_ID + i));
				}
				if (request.getParameter(DIET_TYPE_ID + i) != null) {
					dietTypeId.add(request.getParameter(DIET_TYPE_ID + i));
				}
				if (request.getParameter(DIET_COMBINATION_ID + i) != null) {
					dietCombinationId.add(request
							.getParameter(DIET_COMBINATION_ID + i));
				}
				if (request.getParameter(CONDITION + i) != null) {
					condition.add(request.getParameter(CONDITION + i));
				}
				if (request.getParameter(THERAPEUTIC_DIET_ID + i) != null) {
					therapeuticDietId.add(request
							.getParameter(THERAPEUTIC_DIET_ID + i));
				}
			}
		}

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			for (int i = 0; i < dietDetailsId.size(); i++) {
				int detailsId = Integer.parseInt(dietDetailsId.get(i)
						.toString());
				DietDetails dietDetails = (DietDetails) hbt.load(
						DietDetails.class, detailsId);

				if (dietDetailsId.get(i) != null && dietDetailsId.get(i) != "") {

					try {
						MasHospital hospital = new MasHospital();
						hospital.setId(hospitalId);
						dietDetails.setHospital(hospital);

						Patient patient = new Patient();
						patient.setId(Integer.parseInt((String) hinId.get(i)));
						dietDetails.setHin(patient);

						Inpatient inpatient = new Inpatient();
						inpatient.setId(Integer.parseInt((String) inpatientId
								.get(i)));
						dietDetails.setInpatient(inpatient);

						MasDiet diet = new MasDiet();
						if (dietId.get(i) != null
								&& !(dietId.get(i).equals("0"))) {
							diet
									.setId(Integer.parseInt((String) dietId
											.get(i)));
							dietDetails.setDiet(diet);
						}

						MasDietType dietType = new MasDietType();
						if (dietTypeId.get(i) != null
								&& !(dietTypeId.get(i).equals("0"))) {
							dietType.setId(Integer.parseInt((String) dietTypeId
									.get(i)));
							dietDetails.setDietType(dietType);
						}

						MasDietCombination dietCombination = new MasDietCombination();
						if (dietCombinationId.get(i) != null
								&& !(dietCombinationId.get(i).equals(""))) {
							dietCombination
									.setId(Integer
											.parseInt((String) dietCombinationId
													.get(i)));
							dietDetails.setDietCombination(dietCombination);
						}

						if (condition.get(i) != null
								&& !(condition.get(i).equals(""))) {
							dietDetails.setPatientCondition((String) condition
									.get(i));
						}

						MasDiet thrDiet = new MasDiet();
						if (therapeuticDietId.get(i) != null
								&& !(therapeuticDietId.get(i).equals("0"))) {
							thrDiet
									.setId(Integer
											.parseInt((String) therapeuticDietId
													.get(i)));
							dietDetails.setTherapeuticDiet(thrDiet);
						}

						dietDetails.setLastChgBy(request
								.getParameter(CHANGED_BY));
						dietDetails.setLastChgDate(HMSUtil
								.convertStringTypeDateToDateType(request
										.getParameter(CHANGED_DATE)));
						dietDetails.setLastChgTime(request
								.getParameter(CHANGED_TIME));
						dietDetails.setStatus("y");

						hbt.update(dietDetails);

					} catch (RuntimeException e) {
						e.printStackTrace();
					}
				}
				flag = true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	/**
	 * --------------------------- Method to get details for Daily diet extra
	 * requisition jsp -----------------------------------
	 * 
	 */

	@SuppressWarnings( { "unchecked", "deprecation" })
	public Map<String, Object> getDetailsForDailyDietExtraRequ(
			Map<String, Object> infoMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<MasDiet> dietList = new ArrayList<MasDiet>();
		List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
		List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();
		List<DietDailyGeneralSummary> dailyDietSummaryList = new ArrayList<DietDailyGeneralSummary>();
		List<DietDailySummary> dietDailySummaryList = new ArrayList<DietDailySummary>();
		List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();
		List<Object[]> countListForTherapeuticDiet = new ArrayList<Object[]>();
		List<Object[]> prevDaySupplementryDietList = new ArrayList<Object[]>();
		List<Object[]> currentDaySplmntryDietList = new ArrayList<Object[]>();
		List<Object[]> transferInList = new ArrayList<Object[]>();
		List<Object[]> transferOutList = new ArrayList<Object[]>();
		List<Object[]> dischargeList = new ArrayList<Object[]>();
		List<Object[]> expiryList = new ArrayList<Object[]>();
		List<Object[]> wardWiseInpatientList = new ArrayList<Object[]>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

		List<DietDailyGeneralSummary> existingGeneralSummaryList = new ArrayList<DietDailyGeneralSummary>();

		List totalOffList = new ArrayList();
		List totalOthList = new ArrayList();

		Session session = getSession();
		int departmentId = (Integer) infoMap.get("departmentId");
		int hospitalId = (Integer) infoMap.get("hospitalId");
		String deptName = "";

		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DAY_OF_MONTH, +1);
		Date nextDate = cal1.getTime();

		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_MONTH, -1);
		Date privDate = cal2.getTime();
		String nextDateForDB = "";
		String prvDateForDB = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		existingGeneralSummaryList = session.createCriteria(
				DietDailyGeneralSummary.class).createAlias("Department", "d")
				.add(Restrictions.eq("d.Id", departmentId)).add(
						Restrictions.eq("DietSummaryDate", nextDate)).list();
		nextDateForDB = sdf.format(nextDate);
		prvDateForDB = sdf.format(privDate);
		Date currentDate = new Date();
		String date = sdf.format(currentDate);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date1 = (String) utilMap.get("currentDate");

		if (existingGeneralSummaryList.size() > 0) {
			try {
				for (DietDailyGeneralSummary generalOject : existingGeneralSummaryList) {
					hbt.delete(generalOject);
				}
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		}

		java.sql.Connection con = session.connection();
		String sql = "{call proc_insert_diet_summary(" + departmentId + ",'"
				+ nextDateForDB + "'," + hospitalId + ")}";
		try {
			CallableStatement cals = con.prepareCall(sql);
			cals.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		try {
			dailyDietSummaryList = session.createCriteria(
					DietDailyGeneralSummary.class).createAlias("Department",
					"d").add(Restrictions.eq("d.Id", departmentId)).add(
					Restrictions.eq("DietSummaryDate", nextDate)).list();
			dietDailySummaryList = session.createCriteria(
					DietDailySummary.class).createAlias("Department", "d").add(
					Restrictions.eq("d.Id", departmentId)).add(
					Restrictions.eq("DietSummaryDate", nextDate)).list();
			try {

				String offQury = "select sum(num), a.diet_code from (SELECT count(*) as num,"
						+ " dd.diet_category as diet_cat,  dt.diet_type_name as diet_type_name, md.diet_code as diet_code FROM diet_details dd"
						+ " left join mas_diet_type dt on  dd.diet_type_id=dt.diet_type_id"
						+ " left join mas_diet md  on dd.diet_id=md.diet_id where dd.department_id = "
						+ departmentId
						+ " and  dd.diet_date='"
						+ nextDateForDB
						+ "' and "
						+ " dd.diet_category='Officer' group by dd.diet_id, dd.diet_type_id ) as a "
						+ " group  by a.diet_code order by a.diet_code";

				totalOffList = session.createSQLQuery(offQury).list();

				String othQury = "select sum(num), a.diet_code from (SELECT count(*) as num,"
						+ " dd.diet_category ,  dt.diet_type_name as diet_type_name, md.diet_code as diet_code FROM diet_details dd"
						+ " left join mas_diet_type dt on  dd.diet_type_id=dt.diet_type_id"
						+ " left join mas_diet md  on dd.diet_id=md.diet_id where dd.department_id = "
						+ departmentId
						+ " and  dd.diet_date='"
						+ nextDateForDB
						+ "' and "
						+ " dd.diet_category='Other' group by dd.diet_id, dd.diet_type_id ) as a "
						+ " group  by a.diet_code order by a.diet_code";

				totalOthList = session.createSQLQuery(othQury).list();

				String therapeuticQuery = " SELECT count(*), dd.diet_category, md.diet_code  "
						+ " FROM diet_details dd left join mas_diet md "
						+ " on dd.therapeutic_diet_id=md.diet_id where dd.department_id = "
						+ departmentId
						+ " and  "
						+ " dd.diet_date='"
						+ nextDateForDB
						+ "' and dd.therapeutic_diet_id is not null"
						+ " group by dd.therapeutic_diet_id,dd.diet_category";

				countListForTherapeuticDiet = session.createSQLQuery(
						therapeuticQuery).list();

				List<DietDailyTherapeuticSummary> existingThrpSummaryList = new ArrayList<DietDailyTherapeuticSummary>();

				existingThrpSummaryList = session.createCriteria(
						DietDailyTherapeuticSummary.class).createAlias(
						"Department", "d").add(
						Restrictions.eq("d.Id", departmentId)).add(
						Restrictions.eq("DietSummaryDate", nextDate)).list();

				if (existingThrpSummaryList.size() > 0) {
					try {
						for (DietDailyTherapeuticSummary therapeuticSummaryOject : existingThrpSummaryList) {
							hbt.delete(therapeuticSummaryOject);
						}
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
				}

				if (countListForTherapeuticDiet.size() > 0) {
					for (Object[] obj : countListForTherapeuticDiet) {
						DietDailyTherapeuticSummary therapeuticDietSummary = new DietDailyTherapeuticSummary();
						therapeuticDietSummary.setDietCount(Integer
								.parseInt(obj[0].toString()));
						therapeuticDietSummary.setDietCategory((String) obj[1]);
						therapeuticDietSummary.setDietCode((String) obj[2]);

						MasDepartment department = new MasDepartment();
						department.setId(departmentId);
						therapeuticDietSummary.setDepartment(department);

						MasHospital hospital = new MasHospital();
						hospital.setId(hospitalId);
						therapeuticDietSummary.setHospital(hospital);

						therapeuticDietSummary.setDietSummaryDate(nextDate);

						try {
							hbt.save(therapeuticDietSummary);
						} catch (RuntimeException e) {
							e.printStackTrace();
						}

					}
				}

			} catch (RuntimeException e) {
				e.printStackTrace();
			}

			dietList = session.createCriteria(MasDiet.class).add(
					Restrictions.eq("Status", "y")).list();

			dietTypeList = session.createCriteria(MasDietType.class).add(
					Restrictions.eq("Status", "y")).list();

			dietCombinationList = session.createCriteria(
					MasDietCombination.class).add(
					Restrictions.eq("Status", "y")).list();

			indentItemList = session.createCriteria(MasDietIndentItem.class)
					.add(Restrictions.eq("ExtraItem", "y")).add(
							Restrictions.eq("Status", "y")).list();

			employeeList = session.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "ec").add(
							Restrictions.eq("ec.EmpCategoryName", "Doctor"))
					.list();

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -1);
			Date prevDate = cal.getTime();

			String splmntryPrevQuery = "";
			splmntryPrevQuery = " SELECT count(*),diet_id,diet_type,"
					+ " case rank_category_name when 'Officer' then 'Officer'"
					+ " else 'Other' end as category_name"
					+ " FROM inpatient ip "
					+ " left join patient p on ip.hin_id = p.hin_id"
					+ " left join mas_rank mr on p.rank_id = mr.rank_id"
					+ " left join mas_rank_category mrc on  mr.rank_category_id = mrc.rank_category_id "
					+ " where department_id= " + departmentId
					+ " and date_of_addmission = '" + sdf.format(prevDate)
					+ "' " + " group by diet_id, diet_type,category_name";

			prevDaySupplementryDietList = session.createSQLQuery(
					splmntryPrevQuery).list();

			//System.out.println("prevDaySupplementryDietList------- "+ prevDaySupplementryDietList.size());

			String splmntryCurrentDayQuery = "";
			splmntryCurrentDayQuery = " SELECT count(*),dd.diet_id,dd.diet_type_id,"
					+ " case rank_category_name when 'Officer' then 'Officer'"
					+ " else 'Other' end as category_name"
					+ " from diet_details dd"
					+ " left join inpatient ip on dd.inpatient_id=ip.inpatient_id"
					+ " left join patient p on ip.hin_id = p.hin_id"
					+ " left join mas_rank mr on p.rank_id = mr.rank_id"
					+ " left join mas_rank_category mrc on mr.rank_category_id = mrc.rank_category_id "
					+ " where dd.department_id= "
					+ departmentId
					+ " and date_of_addmission = '"
					+ sdf.format(prevDate)
					+ "'"
					+ " and diet_date='"
					+ date
					+ "'"
					+ " and dd.inpatient_id in (select d.inpatient_id from diet_details d"
					+ " left join inpatient i on d.inpatient_id = i.inpatient_id"
					+ " where d.department_id= "
					+ departmentId
					+ " and date_of_addmission = '"
					+ sdf.format(prevDate)
					+ "'" + " )" + " group by diet_id, diet_type,category_name";

			currentDaySplmntryDietList = session.createSQLQuery(
					splmntryCurrentDayQuery).list();

			//System.out.println("currentDaySplmntryDietList--- "+ currentDaySplmntryDietList.size());
			String transferInQyery = "";
			transferInQyery = "select count(*),dd.diet_category from transfer tr"
					+ " left join patient p on tr.hin_id = p.hin_id"
					+ " left join diet_details dd on dd.hin_id = p.hin_id"
					+ " where tr.date_of_transfer = '"
					+ prvDateForDB
					+ "' and diet_date='"
					+ nextDateForDB
					+ "'"
					+ " and tr.to_ward_id = "
					+ departmentId
					+ " and p.patient_status = 'In Patient'"
					+ " group by dd.diet_category";

			transferInList = session.createSQLQuery(transferInQyery).list();

			String transferOutQyery = "";
			transferOutQyery = "select count(*),dd.diet_category from transfer tr"
					+ " left join patient p on tr.hin_id = p.hin_id"
					+ " left join diet_details dd on dd.hin_id = p.hin_id"
					+ " where tr.date_of_transfer = '"
					+ prvDateForDB
					+ "' and diet_date='"
					+ nextDateForDB
					+ "'"
					+ " and tr.from_ward_id = "
					+ departmentId
					+ " and p.patient_status = 'In Patient' "
					+ " group by dd.diet_category";

			transferOutList = session.createSQLQuery(transferOutQyery).list();

			String dischargeQyery = "";
			dischargeQyery = "select count(*),case rank_category_name when 'Officer' then 'Officer'"
					+ " when 'Officer Family' then 'Officer' "
					+ " else 'Other' end as category_name from discharge d"
					+ " left join patient p on d.hin_id = p.hin_id"
					+ " left join mas_rank mr on p.rank_id = mr.rank_id"
					+ " left join mas_rank_category mrc on mr.rank_category_id = mrc.rank_category_id"
					+ " where d.date_of_discharge = '"
					+ date
					+ "'"
					+ " and d.ward_id = "
					+ departmentId
					+ " and d.status = 'y'" + " group by category_name";

			dischargeList = session.createSQLQuery(dischargeQyery).list();

			String expiryDtQyery = "";
			expiryDtQyery = " select count(*),case rank_category_name when 'Officer' then 'Officer'"
					+ " when 'Officer Family' then 'Officer' "
					+ " else 'Other' end as category_name from expiry_details ed"
					+ " left join patient p on ed.hin_id = p.hin_id"
					+ " left join mas_rank mr on p.rank_id = mr.rank_id"
					+ " left join mas_rank_category mrc on mr.rank_category_id = mrc.rank_category_id"
					+ " where ed.expiry_date = '"
					+ date
					+ "' "
					+ " and ed.ward_id = "
					+ departmentId
					+ " group by category_name";

			expiryList = session.createSQLQuery(expiryDtQyery).list();

			List<Discharge> gCurrDateDischargeList = new ArrayList<Discharge>();
			gCurrDateDischargeList = session.createCriteria(Discharge.class)
					.createAlias("Ward", "d").add(
							Restrictions.eq("d.Id", departmentId)).add(
							Restrictions.gt("DateOfDischarge", HMSUtil
									.convertStringTypeDateToDateType(date1)))
					.list();

			List curDisObj = new ArrayList();
			String list = "";
			for (Discharge discharge : gCurrDateDischargeList) {
				curDisObj.add(discharge.getAdNo());
				if (list.length() > 0) {
					list = list + ",'" + discharge.getAdNo() + "'";
				} else {
					list = list + "'" + discharge.getAdNo() + "'";
				}
			}

			String inpatientQuery = "";
			inpatientQuery = "select count(*),dd.diet_category from inpatient ip"
					+ " left join diet_details dd on ip.inpatient_id = dd.inpatient_id"
					+ " where dd.department_id = " + departmentId;
			if (curDisObj.size() > 0) {
				inpatientQuery = inpatientQuery
						+ " and (ip.ad_status = 'A' or ip.ad_no in(" + list
						+ "))";
			} else {
				inpatientQuery = inpatientQuery + " and ip.ad_status = 'A' ";
			}
			inpatientQuery = inpatientQuery + " and diet_date='"
					+ nextDateForDB + "' " + " group by dd.diet_category";
			wardWiseInpatientList = session.createSQLQuery(inpatientQuery)
					.list();

			deptList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Id", departmentId)).list();

			if (deptList.size() > 0) {
				MasDepartment masDepartment = (MasDepartment) deptList.get(0);
				deptName = masDepartment.getDepartmentName();
				map.put("deptName", deptName);
			}
			map.put("countListForTherapeuticDiet", countListForTherapeuticDiet);
			map.put("dailyDietSummaryList", dailyDietSummaryList);
			map.put("indentItemList", indentItemList);
			map.put("dietList", dietList);
			map.put("dietTypeList", dietTypeList);
			map.put("totalOffList", totalOffList);
			map.put("totalOthList", totalOthList);
			map.put("prevDaySupplementryDietList", prevDaySupplementryDietList);
			map.put("transferInList", transferInList);
			map.put("transferOutList", transferOutList);
			map.put("dischargeList", dischargeList);
			map.put("expiryList", expiryList);
			map.put("wardWiseInpatientList", wardWiseInpatientList);
			map.put("employeeList", employeeList);
			map.put("dietCombinationList", dietCombinationList);
			map.put("currentDaySplmntryDietList", currentDaySplmntryDietList);
			map.put("dietDailySummaryList", dietDailySummaryList);

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * --------------------------- Method to Add daily diet and extra
	 * requisition details -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveDailyDietDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<DietDailyExtraSummary> existingExtraDietList = new ArrayList<DietDailyExtraSummary>();
		List<DietDailySummary> existingDietSummaryList = new ArrayList<DietDailySummary>();

		boolean flag = false;
		Session session = getSession();
		int departmentId = 0;
		departmentId = box.getInt("departmentId");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DAY_OF_MONTH, +1);
		Date nextDate = cal1.getTime();

		try {
			existingExtraDietList = session.createCriteria(
					DietDailyExtraSummary.class).add(
					Restrictions.eq("DietSummaryDate", nextDate)).createAlias(
					"Department", "d").add(
					Restrictions.eq("d.Id", departmentId)).list();

			existingDietSummaryList = session.createCriteria(
					DietDailySummary.class).createAlias("Department", "d").add(
					Restrictions.eq("d.Id", departmentId)).add(
					Restrictions.eq("DietSummaryDate", nextDate)).list();

		} catch (HibernateException e1) {
			e1.printStackTrace();
		}

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		// ----------------------- Saving data into DailyExtraDietSummary
		// table--------------------------
		try {
			if (existingExtraDietList.size() > 0) {
				int dateOfMonth, month, year;
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(nextDate);
				StringBuffer dateOnly = new StringBuffer();
				year = calendar.get(Calendar.YEAR);
				dateOnly.append(year);
				dateOnly.append("/");
				month = calendar.get(Calendar.MONTH) + 1;
				if (month < 10)
					dateOnly.append("0");
				dateOnly.append(month);
				dateOnly.append("/");
				dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
				if (dateOfMonth < 10)
					dateOnly.append("0");
				dateOnly.append(dateOfMonth);
				String hql = "delete from jkt.hms.masters.business.DietDailyExtraSummary as a where a.DietSummaryDate='"
						+ dateOnly.toString() + "'";
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
				//System.out.println("rows:::delete::" + row);
			}

			Vector indentItem = box.getVector(INDENT_ID);
			Vector extraScale = box.getVector(EXTRA_SCALE);
			Vector unit = box.getVector(UNIT_ID);

			for (int i = 0; i < extraScale.size(); i++) {
				DietDailyExtraSummary extraDietSummary = new DietDailyExtraSummary();
				if (extraScale.get(i) != null && !extraScale.get(i).equals("")
						&& !extraScale.get(i).equals("0")) {
					if (indentItem.get(i) != null) {
						MasDietIndentItem masIndentItem = new MasDietIndentItem();
						masIndentItem.setId(Integer.parseInt(indentItem.get(i)
								.toString()));
						extraDietSummary.setIndentItem(masIndentItem);
					}
					if (unit.get(i) != null) {
						MasStoreUnit masStoreUnit = new MasStoreUnit();
						masStoreUnit.setId(Integer.parseInt(unit.get(i)
								.toString()));
						extraDietSummary.setUnit(masStoreUnit);
					}

					extraDietSummary.setExtraItemQty(Integer
							.parseInt(extraScale.get(i).toString()));

					MasDepartment department = new MasDepartment();
					department.setId(box.getInt("departmentId"));
					extraDietSummary.setDepartment(department);

					MasHospital hospital = new MasHospital();
					hospital.setId(box.getInt("hospitalId"));
					extraDietSummary.setHospital(hospital);

					extraDietSummary.setDietSummaryDate(nextDate);

					hbt.save(extraDietSummary);

				}
			}

			// ----------------------- Saving or Updating data into
			// DailyDietSummary table--------------------------

			if (existingDietSummaryList.size() == 0) {

				DietDailySummary dailyDietSummary = new DietDailySummary();

				try {
					MasEmployee employee = new MasEmployee();
					employee.setId(box.getInt(MEDICAL_OFFICER_ID));
					dailyDietSummary.setMedicalOfficer(employee);

					MasDepartment department = new MasDepartment();
					department.setId(box.getInt("departmentId"));
					dailyDietSummary.setDepartment(department);

					MasHospital hospital = new MasHospital();
					hospital.setId(box.getInt("hospitalId"));
					dailyDietSummary.setHospital(hospital);

					dailyDietSummary.setOtherDiet(box.getString("otherDiet"));
					dailyDietSummary.setSepcialDiet(box
							.getString("specialDiet"));
					dailyDietSummary.setDemandDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString(DEMAND_DATE)));
					dailyDietSummary.setForDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString(FOR_DATE)));
					dailyDietSummary.setDietSummaryDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString(FOR_DATE)));
					dailyDietSummary.setLimeSugarPatients(box
							.getInt(LIME_SUGAR_PATIENTS));
					dailyDietSummary.setNightDutyPersons(box
							.getInt(NIGHT_DUTY_PERSONS));
					dailyDietSummary.setTransferInOfficer(box
							.getInt(TRANSFER_IN_OFF));
					dailyDietSummary.setTransferInOther(box
							.getInt(TRANSFER_IN_OTH));
					dailyDietSummary.setTransferOutOfficer(box
							.getInt(TRANSFER_OUT_OFF));
					dailyDietSummary.setTransferOutOther(box
							.getInt(TRANSFER_OUT_OTH));
					dailyDietSummary.setDichargeOfficer(box
							.getInt(DISCHARGE_OFF));
					dailyDietSummary.setDischargeOther(box
							.getInt(DISCHARGE_OTH));
					dailyDietSummary.setDeathOfficer(box.getInt(DEATH_OFF));
					dailyDietSummary.setDeathOther(box.getInt(DEATH_OTH));
					dailyDietSummary
							.setRemainingOfficer(box.getInt(REMAIN_OFF));
					dailyDietSummary.setRemainingOther(box.getInt(REMAIN_OTH));
					dailyDietSummary
							.setTotalPatients(box.getInt(TOTAL_PATIENT));
					dailyDietSummary.setChangedBy(box.getString(CHANGED_BY));
					dailyDietSummary.setChangedDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString(CHANGED_DATE)));
					dailyDietSummary
							.setChangedTime(box.getString(CHANGED_TIME));

					hbt.save(dailyDietSummary);
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
			} else {
				DietDailySummary dietDailySummary = (DietDailySummary) existingDietSummaryList
						.get(0);
				DietDailySummary dailyDietSummary = (DietDailySummary) hbt
						.load(DietDailySummary.class, dietDailySummary.getId());

				MasEmployee employee = new MasEmployee();
				employee.setId(box.getInt(MEDICAL_OFFICER_ID));
				dailyDietSummary.setMedicalOfficer(employee);

				MasDepartment department = new MasDepartment();
				department.setId(box.getInt("departmentId"));
				dailyDietSummary.setDepartment(department);

				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				dailyDietSummary.setHospital(hospital);

				dailyDietSummary.setOtherDiet(box.getString("otherDiet"));
				dailyDietSummary.setSepcialDiet(box.getString("specialDiet"));
				dailyDietSummary.setDemandDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(DEMAND_DATE)));
				dailyDietSummary.setForDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(FOR_DATE)));
				dailyDietSummary.setDietSummaryDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(FOR_DATE)));
				dailyDietSummary.setLimeSugarPatients(box
						.getInt(LIME_SUGAR_PATIENTS));
				dailyDietSummary.setNightDutyPersons(box
						.getInt(NIGHT_DUTY_PERSONS));
				dailyDietSummary.setTransferInOfficer(box
						.getInt(TRANSFER_IN_OFF));
				dailyDietSummary
						.setTransferInOther(box.getInt(TRANSFER_IN_OTH));
				dailyDietSummary.setTransferOutOfficer(box
						.getInt(TRANSFER_OUT_OFF));
				dailyDietSummary.setTransferOutOther(box
						.getInt(TRANSFER_OUT_OTH));
				dailyDietSummary.setDichargeOfficer(box.getInt(DISCHARGE_OFF));
				dailyDietSummary.setDischargeOther(box.getInt(DISCHARGE_OTH));
				dailyDietSummary.setDeathOfficer(box.getInt(DEATH_OFF));
				dailyDietSummary.setDeathOther(box.getInt(DEATH_OTH));
				dailyDietSummary.setRemainingOfficer(box.getInt(REMAIN_OFF));
				dailyDietSummary.setRemainingOther(box.getInt(REMAIN_OTH));
				dailyDietSummary.setTotalPatients(box.getInt(TOTAL_PATIENT));
				dailyDietSummary.setChangedBy(box.getString(CHANGED_BY));
				dailyDietSummary.setChangedDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				dailyDietSummary.setChangedTime(box.getString(CHANGED_TIME));

				hbt.update(dailyDietSummary);
				hbt.refresh(dailyDietSummary);
			}
			flag = true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		String msg = "";
		if (existingDietSummaryList.size() > 0
				&& existingExtraDietList.size() > 0) {
			msg = "Record Already exist.";
		} else if (existingDietSummaryList.size() == 0
				|| existingExtraDietList.size() == 0 && flag == true) {
			msg = "Record Saved Successfully!";
		} else {
			msg = "Some Problem Occured";
		}
		map.put("message", msg);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForInternalDemand() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDiet> dietList = new ArrayList<MasDiet>();
		List<Object[]> dietDetailsList = new ArrayList<Object[]>();

		Session session = getSession();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String date1 = "";
		String date2 = "";

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date prevDate = cal.getTime();

		date1 = sdf.format(prevDate);

		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DAY_OF_MONTH, -7);
		Date prevDate1 = cal1.getTime();

		date2 = sdf.format(prevDate1);
		try {
			dietList = session.createCriteria(MasDietCombination.class).add(
					Restrictions.eq("Status", "y")).list();

			String qry = "SELECT count(*),dt.diet_combination_name"
					+ " FROM diet_details dd"
					+ " left join mas_diet_combination dt on  dd.diet_combination_id=dt.diet_combination_id"
					+ " where  dd.diet_date between '" + date2 + "'and '"
					+ date1 + "' group by dd.diet_combination_id";

			dietDetailsList = session.createSQLQuery(qry).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		int maxSeqNo = 0;
		List<Integer> seqNoList = new ArrayList<Integer>();
		String seqNo = "";
		try {
			seqNoList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "DMSN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (seqNoList.get(0) != null) {
				maxSeqNo = seqNoList.get(0);
				seqNo = String.valueOf(maxSeqNo + 1);
			} else {
				seqNo = String.valueOf(1);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("demandSrNo", seqNo);

		map.put("dietList", dietList);
		map.put("dietDetailsList", dietDetailsList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<MasDietIndentItem> getItemsForGrid(String rationType) {
		List<MasDietIndentItem> itemList = new ArrayList<MasDietIndentItem>();
		Session session = getSession();

		try {
			itemList = session.createCriteria(MasDietIndentItem.class).add(
					Restrictions.eq("IndentItemType", rationType)).add(
					Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return itemList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveInternalDemandRationDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		List<DietDemandRationHeader> existingDemandRationList = new ArrayList<DietDemandRationHeader>();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Session session = getSession();

		Date fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		Date toDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(TO_DATE));

		int year = fromDate.getYear() + 1900;
		int month = fromDate.getMonth();
		int date = fromDate.getDate();
		int year1 = toDate.getYear() + 1900;
		int month1 = toDate.getMonth();
		int date1 = toDate.getDate();

		Date d1 = new GregorianCalendar(year, month, date).getTime();
		Date d2 = new GregorianCalendar(year1, month1, date1).getTime();
		long diff = d2.getTime() - d1.getTime();
		long dif = diff / (1000 * 60 * 60 * 24) + 1;

		existingDemandRationList = session.createCriteria(
				DietDemandRationHeader.class).add(
				Restrictions.eq("DemandFromDate", fromDate)).add(
				Restrictions.eq("DemandToDate", toDate)).list();

		if (existingDemandRationList.size() == 0) {
			DietDemandRationHeader demandRationHeader = new DietDemandRationHeader();
			try {
				List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();

				seqNoList = session.createCriteria(TransactionSequence.class)
						.add(Restrictions.eq("TransactionPrefix", "DMSN"))
						.list();
				if (seqNoList.size() > 0) {
					int seqId = seqNoList.get(0).getId();
					TransactionSequence trnsSeq = (TransactionSequence) hbt
							.load(TransactionSequence.class, seqId);
					trnsSeq.setTransactionSequenceNumber(box
							.getInt(DEMAND_SERIAL_NO));
					hbt.update(trnsSeq);
				} else {
					TransactionSequence trnsSeq = new TransactionSequence();
					trnsSeq.setTablename("DietDemandRationHeader");
					trnsSeq.setTransactionPrefix("DMSN");
					trnsSeq.setTransactionSequenceName("Demand Serial No");
					trnsSeq.setTransactionSequenceNumber(box
							.getInt(DEMAND_SERIAL_NO));
					trnsSeq.setCreatedby(box.getString(CHANGED_BY));
					hbt.save(trnsSeq);
				}
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				demandRationHeader.setHospital(hospital);

				demandRationHeader.setDemandSrNo(box
						.getString(DEMAND_SERIAL_NO));
				demandRationHeader.setRationType(box.getString(RATION_TYPE));
				demandRationHeader.setDemandSrNo(box
						.getString(DEMAND_SERIAL_NO));
				demandRationHeader.setMessName("Patient Mess");
				demandRationHeader.setUnit("CHAFB");
				demandRationHeader.setDemandFromDate(fromDate);
				demandRationHeader.setDemandToDate(toDate);
				demandRationHeader.setChangedBy(box.getString(CHANGED_BY));
				demandRationHeader.setChangedDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				demandRationHeader.setChangedTime(box.getString(CHANGED_TIME));

				try {
					hbt.save(demandRationHeader);
				} catch (RuntimeException e) {
					e.printStackTrace();
				}

				for (int i = 0; i < dif; i++) {
					Calendar calObj = Calendar.getInstance();
					calObj.add(Calendar.DAY_OF_MONTH, i);
					Date dt = calObj.getTime();
					DietDemandDateDetails dateDetails = new DietDemandDateDetails();
					dateDetails.setDemandDate(dt);
					dateDetails.setDietDemandRationHeader(demandRationHeader);
					hbt.save(dateDetails);
				}

			} catch (RuntimeException e) {
				e.printStackTrace();
			}

			try {
				Vector dietCombinationId = box.getVector(DIET_COMBINATION_ID);
				Vector strength = box.getVector(STRENGTH);

				for (int i = 0; i < strength.size(); i++) {
					if (strength.get(i) != null && !strength.get(i).equals("0")) {
						DietDemandRationStrength rationStrength = new DietDemandRationStrength();
						if (dietCombinationId.get(i) != null
								&& !dietCombinationId.get(i).equals("")) {
							MasDietCombination dietCombination = new MasDietCombination();
							dietCombination.setId(Integer
									.parseInt(dietCombinationId.get(i)
											.toString()));
							rationStrength.setDietCombination(dietCombination);
						}
						rationStrength.setStrength(Integer.parseInt(strength
								.get(i).toString()));
						rationStrength
								.setDietDemandRationHeader(demandRationHeader);
						rationStrength.setChangedBy(box.getString(CHANGED_BY));
						rationStrength.setChangedDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString(CHANGED_DATE)));
						rationStrength.setChangedTime(box
								.getString(CHANGED_TIME));

						hbt.save(rationStrength);
					}
				}
			} catch (DataAccessException e) {
				e.printStackTrace();
			}

			try {
				Vector itemId = box.getVector(ITEM_ID);
				Vector quantity = box.getVector(QUANTITY_DEMANDED);
				Vector remarks = box.getVector(REMARKS);

				for (int i = 0; i < quantity.size(); i++) {
					if (quantity.get(i) != null && !quantity.get(i).equals("")) {
						DietDemandRationItems demandRationItems = new DietDemandRationItems();
						if (itemId.get(i) != null && !itemId.get(i).equals("")) {
							MasDietIndentItem dietIndentItem = new MasDietIndentItem();
							dietIndentItem.setId(Integer.parseInt(itemId.get(i)
									.toString()));
							demandRationItems.setItem(dietIndentItem);
						}
						demandRationItems.setDemandQuantity(new BigDecimal(
								quantity.get(i).toString()));
						if (remarks.get(i) != null
								&& !remarks.get(i).equals("")) {
							demandRationItems.setRemarks(remarks.get(i)
									.toString());
						}
						demandRationItems
								.setDietDemandRationHeader(demandRationHeader);
						demandRationItems.setChangedBy(box
								.getString(CHANGED_BY));
						demandRationItems.setChangedDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString(CHANGED_DATE)));
						demandRationItems.setChangedTime(box
								.getString(CHANGED_TIME));

						hbt.save(demandRationItems);
					}
				}
				flag = true;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		}

		String msg = "";
		if (existingDemandRationList.size() > 0) {
			msg = "Record Already exist.";
		} else if (existingDemandRationList.size() == 0 && flag == true) {
			msg = "Record Saved Successfully!";
		} else {
			msg = "Some Problem Occured.";
		}
		map.put("message", msg);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForBreakfastSummary() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietMenuItem> menuItemlist = new ArrayList<MasDietMenuItem>();
		List<Object[]> wardWiseStrengthList = new ArrayList<Object[]>();
		List<Object[]> wardWiseEggQtyList = new ArrayList<Object[]>();
		List<Object[]> wardListForBread = new ArrayList<Object[]>();
		List<Object> cDietPatientList = new ArrayList<Object>();
		List<Object> diabeticPatientList = new ArrayList<Object>();

		Session session = getSession();

		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(currentDate);

		try {
			menuItemlist = session.createCriteria(MasDietMenuItem.class).add(
					Restrictions.like("MenuType", "Breakfast%")).add(
					Restrictions.eq("Status", "y")).list();

			String wardStrength = " select count(*),department_name from diet_details dd"
					+ " left join mas_department md on dd.department_id=md.department_id"
					+ " where diet_category ='Other' and patient_condition='W'"
					+ " and diet_date='" + date + "' group by dd.department_id";

			wardWiseStrengthList = session.createSQLQuery(wardStrength).list();

			String countQryForEggs = "select count(*),md.department_name,mif.quantity,diet_category,patient_condition "
					+ " from diet_details dd left join mas_diet_combination mdc "
					+ " on dd.diet_combination_id = mdc.diet_combination_id"
					+ " left join mas_department md on dd.department_id = md.department_id"
					+ " left join diet_menu_item_formula mif on mdc.diet_combination_id = mif.diet_combination_id"
					+ " left join mas_diet_items di on mif.diet_items_id = di.diet_items_id"
					+ " where diet_date = '"
					+ date
					+ "'"
					+ " and di.diet_items_code = 'Eggs'"
					+ " group by dd.department_id,dd.diet_combination_id,diet_category,patient_condition";

			wardWiseEggQtyList = session.createSQLQuery(countQryForEggs).list();

			String wardListForBreadQry = "select sum(a),dept, id from (select count(*) as a, md.department_name as dept, dd.department_id as id "
					+ " from diet_details dd "
					+ " left join mas_department md on dd.department_id = md.department_id"
					+ " where diet_date = '"
					+ date
					+ "' and bread_required='y'"
					+ " group by dd.department_id"
					+ " union "
					+ " select count(*) as a ,md.department_name as dept,dd.department_id as id "
					+ " from diet_details dd"
					+ " left join mas_department md on dd.department_id = md.department_id"
					+ " where diet_date = '"
					+ date
					+ "' and diet_category='Officer'"
					+ " group by dd.department_id,diet_category ) c"
					+ " group by dept order by id";

			wardListForBread = session.createSQLQuery(wardListForBreadQry)
					.list();

			String cdietQry = "SELECT count(*) FROM diet_details dd"
					+ " left join mas_diet md on dd.diet_id = md.diet_id	"
					+ " where diet_date='" + date + "' and md.diet_code = 'C'"
					+ " group by dd.diet_id";

			cDietPatientList = session.createSQLQuery(cdietQry).list();

			String diabeticQry = "SELECT count(*) FROM diet_details dd"
					+ " left join mas_diet md on dd.therapeutic_diet_id = md.diet_id	"
					+ " where diet_date='" + date
					+ "' and md.diet_name = 'Diabetic'"
					+ " group by dd.therapeutic_diet_id";

			diabeticPatientList = session.createSQLQuery(diabeticQry).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("wardWiseEggQtyList", wardWiseEggQtyList);
		map.put("menuItemlist", menuItemlist);
		map.put("wardWiseStrengthList", wardWiseStrengthList);
		map.put("wardListForBread", wardListForBread);
		map.put("cDietPatientList", cDietPatientList);
		map.put("diabeticPatientList", diabeticPatientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemQtyForBreakfast(int breakfastItemId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DietMenuItemFormula> itemQtyList = new ArrayList<DietMenuItemFormula>();
		List<BigInteger> totalBedPatientList = new ArrayList<BigInteger>();
		List<Object[]> eggQtyForBedPatientList = new ArrayList<Object[]>();

		Session session = getSession();

		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(currentDate);

		try {
			itemQtyList = session.createCriteria(DietMenuItemFormula.class)
					.add(Restrictions.like("MenuType", "Breakfast%"))
					.createAlias("DietItems", "di").add(
							Restrictions.eq("di.Id", breakfastItemId)).list();

			String bedPatientQry = " select count(*) from diet_details dd"
					+ " where diet_category='Other' and patient_condition = 'B' and diet_date = '"
					+ date + "'";

			totalBedPatientList = session.createSQLQuery(bedPatientQry).list();

			String qry = " select count(*),mif.quantity"
					+ " from diet_details dd left join mas_diet_combination mdc"
					+ " on dd.diet_combination_id = mdc.diet_combination_id"
					+ " left join mas_department md on dd.department_id = md.department_id "
					+ " left join diet_menu_item_formula mif on mdc.diet_combination_id = mif.diet_combination_id"
					+ " left join mas_diet_items di on mif.diet_items_id = di.diet_items_id"
					+ " where diet_date = '"
					+ date
					+ "' and di.diet_items_code = 'Eggs' and diet_category='Other' "
					+ " and patient_condition = 'B' group by dd.diet_combination_id ";

			eggQtyForBedPatientList = session.createSQLQuery(qry).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("totalBedPatientList", totalBedPatientList);
		map.put("itemQtyList", itemQtyList);
		map.put("eggQtyForBedPatientList", eggQtyForBedPatientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveBreakastDistributionDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DietBreakfastSummary> existingListForBreakfast = new ArrayList<DietBreakfastSummary>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Session session = getSession();

		Date summaryDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(DATE));

		existingListForBreakfast = session.createCriteria(
				DietBreakfastSummary.class).add(
				Restrictions.eq("SummaryDate", summaryDate)).list();

		if (existingListForBreakfast.size() == 0) {
			try {

				DietBreakfastSummary breakfastSummary = new DietBreakfastSummary();
				MasDietMenuItem dietItems = new MasDietMenuItem();
				dietItems.setId(box.getInt(ITEM_ID));
				breakfastSummary.setItem(dietItems);
				if (box.getInt("messItemQty") != 0) {
					breakfastSummary.setMessItemQty(box.getInt("messItemQty"));
				}
				if (box.getInt("messEggQty") != 0) {
					breakfastSummary.setMessEggQty(box.getInt("messEggQty"));
				}
				if (box.getInt("wardItemQty") != 0) {
					breakfastSummary.setWardItemQty(box.getInt("wardItemQty"));
				}
				if (box.getInt("wardEggQty") != 0) {
					breakfastSummary.setWardEggQty(box.getInt("wardEggQty"));
				}
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				breakfastSummary.setHospital(hospital);
				breakfastSummary.setSummaryDate(summaryDate);
				breakfastSummary.setChangedBy(box.getString(CHANGED_BY));
				breakfastSummary.setChangedDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				breakfastSummary.setChangedTime(box.getString(CHANGED_TIME));

				hbt.save(breakfastSummary);

				Vector departmentId = box.getVector(DEPARTMENT_ID);
				Vector breadQty = box.getVector("breadQty");
				Vector eggQty = box.getVector("eggQty");

				for (int i = 0; i < departmentId.size(); i++) {
					if (Integer.parseInt(breadQty.get(i).toString()) != 0
							|| Integer.parseInt(eggQty.get(i).toString()) != 0) {
						DietWardBreakfastSummary wardBreakfastSummary = new DietWardBreakfastSummary();
						MasDepartment department = new MasDepartment();
						department.setId(Integer.parseInt(departmentId.get(i)
								.toString()));
						wardBreakfastSummary.setDepartment(department);
						if (Integer.parseInt(breadQty.get(i).toString()) != 0) {
							wardBreakfastSummary.setBreadQty(Integer
									.parseInt(breadQty.get(i).toString()));
						}
						if (Integer.parseInt(eggQty.get(i).toString()) != 0) {
							wardBreakfastSummary.setEggsQty(Integer
									.parseInt(eggQty.get(i).toString()));
						}
						wardBreakfastSummary.setSummaryDate(summaryDate);
						wardBreakfastSummary
								.setBreakfastSummary(breakfastSummary);
						wardBreakfastSummary.setChangedBy(box
								.getString(CHANGED_BY));
						wardBreakfastSummary.setChangedDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString(CHANGED_DATE)));
						wardBreakfastSummary.setChangedTime(box
								.getString(CHANGED_TIME));

						hbt.save(wardBreakfastSummary);
					}
				}
				flag = true;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		}
		String msg = "";
		if (existingListForBreakfast.size() > 0) {
			msg = "Record Already exist.";
		} else if (existingListForBreakfast.size() == 0 && flag == true) {
			msg = "Record Saved Successfully!";
		} else {
			msg = "Some Problem Occured.";
		}
		map.put("message", msg);
		return map;
	}

	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	@SuppressWarnings("unchecked")
	public String getDepartmentName(int departmentId) {
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = getSession();
		String deptName = "";
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					(Restrictions.eq("Id", departmentId))).list();

			MasDepartment masDepartment = (MasDepartment) departmentList.get(0);
			deptName = masDepartment.getDepartmentName();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return deptName;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> updateDietDetailsForDailyDiet(
			Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		//System.out.println("inside updateDietDetailsForDailyDiet ");
		List<DietDetails> todayDietList = new ArrayList<DietDetails>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Transfer> todayTransferList = new ArrayList<Transfer>();
		List<Discharge> todayDischargeList = new ArrayList<Discharge>();
		List<ExpiryDetails> todayExpiryList = new ArrayList<ExpiryDetails>();
		List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
		List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();

		Session session = getSession();

		int departmentId = (Integer) infoMap.get("departmentId");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		Date currentDate = new Date();
		currentDate = HMSUtil.convertStringTypeDateToDateType(date);

		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DAY_OF_MONTH, +1);
		Date nextDate = cal1.getTime();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			todayDietList = session.createCriteria(DietDetails.class)
					.createAlias("Department", "d").add(
							Restrictions.eq("d.Id", departmentId)).add(
							Restrictions.eq("DietDate", HMSUtil
									.convertStringTypeDateToDateType(date)))
					.list();

			inpatientList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("AdStatus", "A")).createAlias("Department",
					"d").add(Restrictions.eq("d.Id", departmentId)).add(
					Restrictions.eq("DateOfAddmission", currentDate)).list();

			todayTransferList = session.createCriteria(Transfer.class).add(
					Restrictions.eq("DateOfTransfer", HMSUtil
							.convertStringTypeDateToDateType(date))).list();

			todayDischargeList = session.createCriteria(Discharge.class)
					.createAlias("Ward", "d").add(
							Restrictions.eq("d.Id", departmentId)).add(
							Restrictions.eq("DateOfDischarge", HMSUtil
									.convertStringTypeDateToDateType(date)))
					.list();

			todayExpiryList = session.createCriteria(ExpiryDetails.class)
					.createAlias("Ward", "d").add(
							Restrictions.eq("d.Id", departmentId)).add(
							Restrictions.eq("ExpiryDate", HMSUtil
									.convertStringTypeDateToDateType(date)))
					.list();

			dietTypeList = session.createCriteria(MasDietType.class).add(
					Restrictions.eq("Status", "y")).list();
			dietCombinationList = session.createCriteria(
					MasDietCombination.class).add(
					Restrictions.eq("Status", "y")).list();

			try {
				/*
				 * for (Transfer transfer : todayTransferList) { for(DietDetails
				 * dietDt : todayDietList) { if(transfer.getHin().getId() ==
				 * dietDt.getHin().getId()) { if(transfer.getFromWard().getId()
				 * == departmentId || transfer.getToWard().getId() ==
				 * departmentId){ DietDetails dtDetails =
				 * (DietDetails)hbt.get(DietDetails.class, dietDt.getId());
				 * MasDepartment department = new MasDepartment();
				 * department.setId(transfer.getToWard().getId());
				 * dtDetails.setDepartment(department); hbt.update(dtDetails); }
				 * } } }
				 */

				for (Discharge discharge : todayDischargeList) {
					for (DietDetails dietDt : todayDietList) {
						if (discharge.getHin().getId() == dietDt.getHin()
								.getId()
								&& discharge.getWard().getId() == dietDt
										.getDepartment().getId()) {
							DietDetails dtDetails = (DietDetails) hbt.load(
									DietDetails.class, dietDt.getId());
							hbt.delete(dtDetails);

						}
					}
				}

				for (ExpiryDetails expiryDetails : todayExpiryList) {
					for (DietDetails dietDt : todayDietList) {
						if (expiryDetails.getHin().getId() == dietDt.getHin()
								.getId()
								&& expiryDetails.getWard().getId() == dietDt
										.getDepartment().getId()) {
							DietDetails dtDetails = (DietDetails) hbt.load(
									DietDetails.class, dietDt.getId());
							hbt.delete(dtDetails);

						}
					}
				}
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}
			for (Inpatient inpatient : inpatientList) {
				//System.out.println("inpatientlist ------ "+ inpatient.getDietDetails());
				if (inpatient.getDietDetails() == null
						|| inpatient.getDietDetails().size() == 0) {
					DietDetails dietDetailsObj = new DietDetails();
					dietDetailsObj.setDiet(inpatient.getDiet());
					String category = inpatient.getHin().getRank()
							.getRankCategory().getRankCategoryName();
					String dietCategory = "";
					String patientCategory = "";
					if (category.equalsIgnoreCase("Officer")
							|| category.equalsIgnoreCase("Officer Family")) {
						dietCategory = "Officer";
					} else {
						dietCategory = "Other";
					}
					String relation = inpatient.getHin().getRelation()
							.getRelationName();
					if (category.equalsIgnoreCase("Officer")) {
						patientCategory = "Officer";
					} else if (category.equalsIgnoreCase("Officer Family")) {
						patientCategory = "Officer Family";
					} else if (!category.equalsIgnoreCase("Officer")
							&& !category.equalsIgnoreCase("Officer Family")
							&& relation.equalsIgnoreCase("Self")) {
						patientCategory = "Others";
					} else if (!category.equalsIgnoreCase("Officer")
							&& !category.equalsIgnoreCase("Officer Family")
							&& !relation.equalsIgnoreCase("Self")) {
						patientCategory = "Others Family";
					}

					dietDetailsObj.setDepartment(inpatient.getDepartment());
					dietDetailsObj.setDietCategory(dietCategory);
					dietDetailsObj.setPatientCategory(patientCategory);
					dietDetailsObj.setDietDate(nextDate);
					dietDetailsObj.setHin(inpatient.getHin());
					dietDetailsObj.setHospital(inpatient.getHospital());
					dietDetailsObj.setInpatient(inpatient);
					dietDetailsObj.setStatus("y");
					dietDetailsObj.setPatientCondition("B");
					int dietTypeId = 0;
					for (MasDietType masDietType : dietTypeList) {
						if (inpatient.getDietType().equalsIgnoreCase(
								masDietType.getDietTypeName())) {
							dietTypeId = masDietType.getId();
							dietDetailsObj.setDietType(masDietType);
						}
					}

					for (MasDietCombination dietCombination : dietCombinationList) {
						if (inpatient.getDiet().getId() == dietCombination
								.getDiet().getId()
								&& dietTypeId == dietCombination.getDietType()
										.getId()
								&& dietCombination.getDemandDisplay().equals(
										"n")) {
							dietDetailsObj.setDietCombination(dietCombination);
						}
					}
					try {
						hbt.save(dietDetailsObj);
					} catch (RuntimeException e) {
						e.printStackTrace();
					}
				}

			}

			try {
				map = getDetailsForDailyDietExtraRequ(infoMap);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	public void callProcedureFordailyDietSheet(Box box) {

		int month = box.getInt(MONTH);
		int year = box.getInt(YEAR);
		int deptId = box.getInt("deptId");

		Session session = getSession();
		java.sql.Connection con = session.connection();
		String sql = "{call proc_diet_ward_montly_summary(" + month + ","
				+ year + "," + deptId + ")}";
		try {
			CallableStatement cals = con.prepareCall(sql);
			cals.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}

}
