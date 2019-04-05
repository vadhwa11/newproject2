package jkt.hms.masters.dataservice;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import jkt.hms.masters.business.DischargeItems;
import jkt.hms.masters.business.DischargeItemsCategory;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.IpdKitIssueHeader;
import jkt.hms.masters.business.KitIssueMasterTemplateM;
import jkt.hms.masters.business.KitIssueMasterTemplateT;
import jkt.hms.masters.business.MasBabyStatus;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasBodyPart;
import jkt.hms.masters.business.MasCareType;
import jkt.hms.masters.business.MasDelivery;
import jkt.hms.masters.business.MasDischargeStatus;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasInjuryNature;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InPatientMasterDataServiceImpl extends HibernateDaoSupport
		implements InPatientMasterDataService {

	// ------------------------------------------------ Bed Status
	// ---------------------------------------------
	public boolean editBedStatusToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bedStatusName = "";
		@SuppressWarnings("unused")
		String bedStatusCode = "";
		int bedStatusId = 0;
		String changedBy = "";

		bedStatusId = (Integer) generalMap.get("id");
		bedStatusCode = (String) generalMap.get("bedStatusCode");
		bedStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasBedStatus masBedStatus = (MasBedStatus) getHibernateTemplate().load(
				MasBedStatus.class, bedStatusId);
		masBedStatus.setId(bedStatusId);
		masBedStatus.setBedStatusName(bedStatusName);
		masBedStatus.setLastChgBy(changedBy);
		masBedStatus.setLastChgDate(currentDate);
		masBedStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBedStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBedStatus(String bedStatusCode,
			String bedStatusName) {
		List<MasBedStatus> searchBedStatusList = new ArrayList<MasBedStatus>();
		Session session=(Session)getSession();
		Map bedStatusFieldsMap = new HashMap();
		try {
			if ((bedStatusName != null) || (bedStatusCode == null)) {
				/*searchBedStatusList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBedStatus mbs where mbs.BedStatusName like '"
								+ bedStatusName
								+ "%' order by mbs.BedStatusName");*/
				searchBedStatusList=session.createCriteria(MasBedStatus.class).add(Restrictions.like("BedStatusName", "%"+bedStatusName+"%")).addOrder(Order.asc("BedStatusName")).list();
				
			} else {
/*				searchBedStatusList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBedStatus mbs where mbs.BedStatusCode like '"
								+ bedStatusCode
								+ "%' order by mbs.BedStatusCode");*/
				searchBedStatusList=session.createCriteria(MasBedStatus.class).add(Restrictions.like("BedStatusCode", "%"+bedStatusCode+"%")).addOrder(Order.asc("BedStatusCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bedStatusFieldsMap.put("searchBedStatusList", searchBedStatusList);
		return bedStatusFieldsMap;
	}

	public Map<String, Object> showBedStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBedStatus> searchBedStatusList = new ArrayList<MasBedStatus>();
		Session session=(Session)getSession();try {
			/*searchBedStatusList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasBedStatus ");
			*/
			searchBedStatusList=session.createCriteria(MasBedStatus.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchBedStatusList", searchBedStatusList);
		return map;
	}

	public boolean addBedStatus(MasBedStatus masBedStatus) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBedStatus);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteBedStatus(int bedStatusId,
			Map<String, Object> generalMap) {
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		boolean dataDeleted = false;
		MasBedStatus masBedStatus = new MasBedStatus();
		masBedStatus = (MasBedStatus) getHibernateTemplate().load(
				MasBedStatus.class, bedStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBedStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBedStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		masBedStatus.setLastChgBy(changedBy);
		masBedStatus.setLastChgDate(currentDate);
		masBedStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBedStatus);
		return dataDeleted;
	}

	// --------------------------Injury Nature
	// --------------------------------------

	public boolean addInjuryNature(MasInjuryNature masInjuryNature) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masInjuryNature);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editInjuryNatureToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String injuryNatureName = "";
		@SuppressWarnings("unused")
		String injuryNatureCode = "";
		int injuryNatureId = 0;
		String changedBy = "";
		injuryNatureId = (Integer) generalMap.get("id");
		injuryNatureCode = (String) generalMap.get("injuryNatureCode");
		injuryNatureName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasInjuryNature masInjuryNature = (MasInjuryNature) getHibernateTemplate()
				.load(MasInjuryNature.class, injuryNatureId);

		masInjuryNature.setId(injuryNatureId);
		masInjuryNature.setInjuryNatureName(injuryNatureName);
		masInjuryNature.setLastChgBy(changedBy);
		masInjuryNature.setLastChgDate(currentDate);
		masInjuryNature.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masInjuryNature);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchInjuryNature(String injuryNatureCode,
			String injuryNatureName) {
		List<MasInjuryNature> searchInjuryNatureList = new ArrayList<MasInjuryNature>();
		Map<String, Object> injuryNatureFieldsMap = new HashMap<String, Object>();
		Session session =(Session)getSession();
		try {
			if ((injuryNatureName != null) || (injuryNatureCode == null)) {
/*				searchInjuryNatureList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasInjuryNature imc where imc.InjuryNatureName like '"
										+ injuryNatureName
										+ "%' order by imc.InjuryNatureName");
*/				
				searchInjuryNatureList=session.createCriteria(MasInjuryNature.class).add(Restrictions.like("InjuryNatureName", "%"+injuryNatureName+"%")).addOrder(Order.asc("InjuryNatureName")).list();
				
			} else {
				/*searchInjuryNatureList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasInjuryNature imc where imc.InjuryNatureCode like '"
										+ injuryNatureCode
										+ "%' order by imc.InjuryNatureCode");
				*/
				searchInjuryNatureList=session.createCriteria(MasInjuryNature.class).add(Restrictions.like("InjuryNatureCode", "%"+injuryNatureCode+"%")).addOrder(Order.asc("InjuryNatureName")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		injuryNatureFieldsMap.put("searchInjuryNatureList",
				searchInjuryNatureList);
		return injuryNatureFieldsMap;
	}

	public Map<String, Object> showInjuryNatureJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasInjuryNature> searchInjuryNatureList = new ArrayList<MasInjuryNature>();
		searchInjuryNatureList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasInjuryNature ");
		map.put("searchInjuryNatureList", searchInjuryNatureList);
		return map;
	}

	public boolean deleteInjuryNature(int injuryNatureId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasInjuryNature masInjuryNature = new MasInjuryNature();
		masInjuryNature = (MasInjuryNature) getHibernateTemplate().load(
				MasInjuryNature.class, injuryNatureId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masInjuryNature.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masInjuryNature.setStatus("y");
				dataDeleted = false;
			}
		}
		masInjuryNature.setLastChgBy(changedBy);
		masInjuryNature.setLastChgDate(currentDate);
		masInjuryNature.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masInjuryNature);
		return dataDeleted;
	}

	// ------------------------------- Baby
	// Status--------------------------------------

	public boolean addBabyStatus(MasBabyStatus masBabyStatus) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBabyStatus);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editBabyStatusToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String babyStatusName = "";
		@SuppressWarnings("unused")
		String babyStatusCode = "";
		int babyStatusId = 0;
		String changedBy = "";
		babyStatusId = (Integer) generalMap.get("id");
		babyStatusCode = (String) generalMap.get("babyStatusCode");
		babyStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBabyStatus masBabyStatus = (MasBabyStatus) getHibernateTemplate()
				.load(MasBabyStatus.class, babyStatusId);

		masBabyStatus.setId(babyStatusId);
		masBabyStatus.setBabyStatusName(babyStatusName);
		masBabyStatus.setLastChgBy(changedBy);
		masBabyStatus.setLastChgDate(currentDate);
		masBabyStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBabyStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBabyStatus(String babyStatusCode,
			String babyStatusName) {
		List<MasBabyStatus> searchBabyStatusList = new ArrayList<MasBabyStatus>();
		Map<String, Object> babyStatusFieldsMap = new HashMap<String, Object>();
		try {
			if ((babyStatusName != null) || (babyStatusCode == null)) {
				searchBabyStatusList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBabyStatus imc where imc.BabyStatusName like '"
										+ babyStatusName
										+ "%' order by imc.BabyStatusName");
			} else {
				searchBabyStatusList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBabyStatus imc where imc.BabyStatusCode like '"
										+ babyStatusCode
										+ "%' order by imc.BabyStatusCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		babyStatusFieldsMap.put("searchBabyStatusList", searchBabyStatusList);
		return babyStatusFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBabyStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBabyStatus> searchBabyStatusList = new ArrayList<MasBabyStatus>();
		searchBabyStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBabyStatus ");
		map.put("searchBabyStatusList", searchBabyStatusList);
		return map;
	}

	public boolean deleteBabyStatus(int babyStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasBabyStatus masBabyStatus = new MasBabyStatus();
		masBabyStatus = (MasBabyStatus) getHibernateTemplate().load(
				MasBabyStatus.class, babyStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBabyStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBabyStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		masBabyStatus.setLastChgBy(changedBy);
		masBabyStatus.setLastChgDate(currentDate);
		masBabyStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBabyStatus);
		return dataDeleted;
	}

	// ------------------------delivery------------------------
	public boolean addDelivery(MasDelivery masDelivery) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDelivery);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteDelivery(int deliveryId, Map<String, Object> generalMap) {
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		boolean dataDeleted = false;
		MasDelivery masDelivery = new MasDelivery();
		masDelivery = (MasDelivery) getHibernateTemplate().load(
				MasDelivery.class, deliveryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDelivery.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDelivery.setStatus("y");
				dataDeleted = false;
			}
		}
		masDelivery.setLastChgBy(changedBy);
		masDelivery.setLastChgDate(currentDate);
		masDelivery.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDelivery);
		return dataDeleted;

	}

	public boolean editDeliveryToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String deliveryName = "";
		@SuppressWarnings("unused")
		String deliveryCode = "";
		int deliveryId = 0;
		String changedBy = "";
		deliveryId = (Integer) generalMap.get("id");
		deliveryCode = (String) generalMap.get("deliveryCode");
		deliveryName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDelivery masDelivery = (MasDelivery) getHibernateTemplate().load(
				MasDelivery.class, deliveryId);

		masDelivery.setId(deliveryId);
		masDelivery.setDeliveryName(deliveryName);
		masDelivery.setLastChgBy(changedBy);
		masDelivery.setLastChgDate(currentDate);
		masDelivery.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDelivery);
		dataUpdated = true;
		return dataUpdated;

	}

	public Map<String, Object> searchDelivery(String deliveryCode,
			String deliveryName) {
		List<MasDelivery> searchDeliveryList = new ArrayList<MasDelivery>();
		Map<String, Object> deliveryFieldsMap = new HashMap<String, Object>();
		try {
			if ((deliveryName != null) || (deliveryCode == null)) {
				searchDeliveryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDelivery imc where imc.DeliveryName like '"
										+ deliveryName
										+ "%' order by imc.DeliveryName");
			} else {
				searchDeliveryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDelivery imc where imc.DeliveryCode like '"
										+ deliveryCode
										+ "%' order by imc.DeliveryCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		deliveryFieldsMap.put("searchDeliveryList", searchDeliveryList);
		return deliveryFieldsMap;
	}

	public Map<String, Object> showDeliveryJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDelivery> searchDeliveryList = new ArrayList<MasDelivery>();
		searchDeliveryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDelivery ");
		map.put("searchDeliveryList", searchDeliveryList);
		return map;
	}

	// -----------------------------Care Type--------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCareTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCareType> searchCareTypeList = new ArrayList<MasCareType>();
		searchCareTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCareType ");
		map.put("searchCareTypeList", searchCareTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCareType(String careTypeCode,
			String careTypeName) {
		List<MasCareType> searchCareTypeList = new ArrayList<MasCareType>();
		Map<String, Object> careTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((careTypeName != null) || (careTypeCode == null)) {
				searchCareTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasCareType mcr where mcr.CareTypeName like '"
										+ careTypeName
										+ "%' order by mcr.CareTypeName");
			} else {
				searchCareTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasCareType mcr where mcr.CareTypeCode like '"
										+ careTypeCode
										+ "%' order by mcr.CareTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		careTypeFieldsMap.put("searchCareTypeList", searchCareTypeList);
		return careTypeFieldsMap;
	}

	public boolean addCareType(MasCareType masCareType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCareType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editCareTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String careTypeName = "";
		@SuppressWarnings("unused")
		String careTypeCode = "";
		int careTypeId = 0;
		String changedBy = "";
		careTypeId = (Integer) generalMap.get("id");
		careTypeCode = (String) generalMap.get("careTypeCode");
		careTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasCareType masCareType = (MasCareType) getHibernateTemplate().get(
				MasCareType.class, careTypeId);

		masCareType.setId(careTypeId);
		masCareType.setCareTypeName(careTypeName);
		masCareType.setLastChgBy(changedBy);
		masCareType.setLastChgDate(currentDate);
		masCareType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCareType);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteCareType(int careTypeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasCareType masCareType = new MasCareType();
		masCareType = (MasCareType) getHibernateTemplate().get(
				MasCareType.class, careTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCareType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCareType.setStatus("y");
				dataDeleted = false;
			}
		}
		masCareType.setLastChgBy(changedBy);
		masCareType.setLastChgDate(currentDate);
		masCareType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCareType);
		return dataDeleted;
	}

	// -----------------------------Disposed
	// To--------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDisposedToJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDisposedTo> searchDisposedToList = new ArrayList<MasDisposedTo>();
		searchDisposedToList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDisposedTo ");
		map.put("searchDisposedToList", searchDisposedToList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDisposedTo(String disposedToCode,
			String disposedToName) {
		List<MasDisposedTo> searchDisposedToList = new ArrayList<MasDisposedTo>();
		Map<String, Object> disposedToFieldsMap = new HashMap<String, Object>();
		try {
			if ((disposedToName != null) || (disposedToCode == null)) {
				searchDisposedToList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDisposedTo mdt where mdt.DisposedToName like '"
										+ disposedToName
										+ "%' order by mdt.DisposedToName");
			} else {
				searchDisposedToList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDisposedTo mdt where mdt.DisposedToCode like '"
										+ disposedToCode
										+ "%' order by mdt.DisposedToCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposedToFieldsMap.put("searchDisposedToList", searchDisposedToList);
		return disposedToFieldsMap;
	}

	public boolean addDisposedTo(MasDisposedTo masDisposedTo) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDisposedTo);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editDisposedToToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String disposedToName = "";
		@SuppressWarnings("unused")
		String disposedToCode = "";
		int disposedToId = 0;
		String changedBy = "";
		disposedToId = (Integer) generalMap.get("id");
		disposedToCode = (String) generalMap.get("disposedToCode");
		disposedToName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDisposedTo masDisposedTo = (MasDisposedTo) getHibernateTemplate()
				.get(MasDisposedTo.class, disposedToId);

		masDisposedTo.setId(disposedToId);
		masDisposedTo.setDisposedToName(disposedToName);
		masDisposedTo.setLastChgBy(changedBy);
		masDisposedTo.setLastChgDate(currentDate);
		masDisposedTo.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDisposedTo);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteDisposedTo(int disposedToId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasDisposedTo masDisposedTo = new MasDisposedTo();
		masDisposedTo = (MasDisposedTo) getHibernateTemplate().get(
				MasDisposedTo.class, disposedToId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDisposedTo.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDisposedTo.setStatus("y");
				dataDeleted = false;
			}
		}
		masDisposedTo.setLastChgBy(changedBy);
		masDisposedTo.setLastChgDate(currentDate);
		masDisposedTo.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDisposedTo);
		return dataDeleted;
	}

	// ----------------------------------------Body
	// Part------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBodyPartJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBodyPart> searchBodyPartList = new ArrayList<MasBodyPart>();
		searchBodyPartList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBodyPart");
		map.put("searchBodyPartList", searchBodyPartList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBodyPart(String bodyPartCode,
			String bodyPartName) {
		List<MasBodyPart> searchBodyPartList = new ArrayList<MasBodyPart>();
		Map<String, Object> bodyPartFieldsMap = new HashMap<String, Object>();
		try {
			if ((bodyPartName != null) || (bodyPartCode == null)) {
				searchBodyPartList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBodyPart mbp where mbp.BodyPartName like '"
										+ bodyPartName
										+ "%' order by mbp.BodyPartName");
			} else {
				searchBodyPartList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBodyPart mbp where mbp.BodyPartCode like '"
										+ bodyPartCode
										+ "%' order by mbp.BodyPartCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bodyPartFieldsMap.put("searchBodyPartList", searchBodyPartList);
		return bodyPartFieldsMap;
	}

	public boolean addBodyPart(MasBodyPart masBodyPart) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBodyPart);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editBodyPartToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bodyPartName = "";
		@SuppressWarnings("unused")
		String bodyPartCode = "";
		int bodyPartId = 0;
		String changedBy = "";
		bodyPartId = (Integer) generalMap.get("id");
		bodyPartCode = (String) generalMap.get("bodyPartCode");
		bodyPartName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBodyPart masBodyPart = (MasBodyPart) getHibernateTemplate().get(
				MasBodyPart.class, bodyPartId);

		masBodyPart.setId(bodyPartId);
		masBodyPart.setBodyPartName(bodyPartName);
		masBodyPart.setLastChgBy(changedBy);
		masBodyPart.setLastChgDate(currentDate);
		masBodyPart.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBodyPart);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteBodyPart(int bodyPartId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasBodyPart masBodyPart = new MasBodyPart();
		masBodyPart = (MasBodyPart) getHibernateTemplate().get(
				MasBodyPart.class, bodyPartId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBodyPart.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBodyPart.setStatus("y");
				dataDeleted = false;
			}
		}
		masBodyPart.setLastChgBy(changedBy);
		masBodyPart.setLastChgDate(currentDate);
		masBodyPart.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBodyPart);
		return dataDeleted;
	}

	// ---------------------------------------Discharge
	// Status------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDischargeStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDischargeStatus> searchDischargeStatusList = new ArrayList<MasDischargeStatus>();
		searchDischargeStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDischargeStatus ");
		map.put("searchDischargeStatusList", searchDischargeStatusList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDischargeStatus(
			String dischargeStatusCode, String dischargeStatusName) {
		List<MasDischargeStatus> searchDischargeStatusList = new ArrayList<MasDischargeStatus>();
		Map<String, Object> dischargeStatusFieldsMap = new HashMap<String, Object>();
		try {
			if ((dischargeStatusName != null) || (dischargeStatusCode == null)) {
				searchDischargeStatusList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDischargeStatus mr where mr.DischargeStatusName like '"
										+ dischargeStatusName
										+ "%' order by mr.DischargeStatusName");
			} else {
				searchDischargeStatusList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDischargeStatus mr where mr.DischargeStatusCode like '"
										+ dischargeStatusCode
										+ "%' order by mr.DischargeStatusCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dischargeStatusFieldsMap.put("searchDischargeStatusList",
				searchDischargeStatusList);
		return dischargeStatusFieldsMap;
	}

	public boolean addDischargeStatus(MasDischargeStatus masDischargeStatus) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDischargeStatus);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editDischargeStatusToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String dischargeStatusName = "";
		@SuppressWarnings("unused")
		String dischargeStatusCode = "";
		int dischargeStatusId = 0;
		String changedBy = "";
		dischargeStatusId = (Integer) generalMap.get("id");
		dischargeStatusCode = (String) generalMap.get("dischargeStatusCode");
		dischargeStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDischargeStatus masDischargeStatus = (MasDischargeStatus) getHibernateTemplate()
				.get(MasDischargeStatus.class, dischargeStatusId);

		masDischargeStatus.setId(dischargeStatusId);
		masDischargeStatus.setDischargeStatusName(dischargeStatusName);
		masDischargeStatus.setLastChgBy(changedBy);
		masDischargeStatus.setLastChgDate(currentDate);
		masDischargeStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDischargeStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteDischargeStatus(int dischargeStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasDischargeStatus masDischargeStatus = new MasDischargeStatus();
		masDischargeStatus = (MasDischargeStatus) getHibernateTemplate().get(
				MasDischargeStatus.class, dischargeStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDischargeStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDischargeStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		masDischargeStatus.setLastChgBy(changedBy);
		masDischargeStatus.setLastChgDate(currentDate);
		masDischargeStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDischargeStatus);
		return dataDeleted;
	}

	// ------------------------------Discharge Items---------------------------

	public Map<String, Object> showDischargeItemsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DischargeItems> searchDischargeItemsList = new ArrayList<DischargeItems>();
		searchDischargeItemsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DischargeItems ");
		map.put("searchDischargeItemsList", searchDischargeItemsList);
		return map;
	}

	public Map<String, Object> searchDischargeItems(String itemCode,
			String itemDescription) {
		List<DischargeItems> searchDischargeItemsList = new ArrayList<DischargeItems>();
		Map dischargeItemsFieldsMap = new HashMap();
		try {
			if ((itemDescription != null) || (itemCode == null)) {
				searchDischargeItemsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.DischargeItems sc where sc.ItemDesc like '"
								+ itemDescription + "%' order by sc.ItemDesc");
			} else {
				searchDischargeItemsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.DischargeItems sc where sc.ItemCode like '"
								+ itemCode + "%' order by sc.ItemCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dischargeItemsFieldsMap.put("searchDischargeItemsList",
				searchDischargeItemsList);
		return dischargeItemsFieldsMap;
	}

	public boolean editDischargeItemsToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String itemName = "";
		@SuppressWarnings("unused")
		String itemCode = "";
		int itemId = 0;
		String changedBy = "";
		itemId = (Integer) generalMap.get("id");
		itemCode = (String) generalMap.get("itemCode");
		itemName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		DischargeItems dischargeItems = (DischargeItems) getHibernateTemplate()
				.get(DischargeItems.class, itemId);

		dischargeItems.setId(itemId);
		dischargeItems.setItemDesc(itemName);
		dischargeItems.setLastChgBy(changedBy);
		dischargeItems.setLastChgDate(currentDate);
		dischargeItems.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dischargeItems);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean addDischargeItems(DischargeItems dischargeItems) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(dischargeItems);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteDischargeItems(int dischargeItemsId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DischargeItems dischargeItems = new DischargeItems();
		dischargeItems = (DischargeItems) getHibernateTemplate().get(
				DischargeItems.class, dischargeItemsId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				dischargeItems.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				dischargeItems.setStatus("y");
				dataDeleted = false;
			}
		}
		dischargeItems.setLastChgBy(changedBy);
		dischargeItems.setLastChgDate(currentDate);
		dischargeItems.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dischargeItems);
		return dataDeleted;
	}

	// ------------------------------Discharge Items
	// Category---------------------------
	public Map<String, Object> showDischargeCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DischargeItemsCategory> searchDischargeItemsCategoryList = new ArrayList<DischargeItemsCategory>();
		List<DischargeItems> dischargeItemsList = new ArrayList<DischargeItems>();
		searchDischargeItemsCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DischargeItemsCategory ");
		dischargeItemsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DischargeItems as d order by d.ItemDesc asc");
		map.put("searchDischargeItemsCategoryList",
				searchDischargeItemsCategoryList);
		map.put("dischargeItemsList", dischargeItemsList);
		return map;
	}
	public boolean addDischargeItemsCategory(
			DischargeItemsCategory dischargeItemsCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(dischargeItemsCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteDischargeItemsCategory(int dischargeCateogryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		DischargeItemsCategory dischargeItemsCategory= new DischargeItemsCategory();
		dischargeItemsCategory = (DischargeItemsCategory) getHibernateTemplate().get(DischargeItemsCategory.class, dischargeCateogryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				dischargeItemsCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				dischargeItemsCategory.setStatus("y");
				dataDeleted = false;
			}
		}
		dischargeItemsCategory.setLastChgBy(changedBy);
		dischargeItemsCategory.setLastChgDate(currentDate);
		dischargeItemsCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dischargeItemsCategory);
		return dataDeleted;
	}

	public boolean editDischargeItemsCategory(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String bedNumber = "";
		int itemCode = 0;
		int dischargeCateogryId = 0;
		Integer orderNo = 0;
		String dischargeCategory = null;
		String description = null;
		String labelDataType = null;
		String changedBy = "";
		String currentTime = "";
		Date changedDate = new Date();
		dischargeCateogryId = (Integer) generalMap.get("id");
		itemCode = (Integer) generalMap.get("itemCode");
		orderNo = (Integer) generalMap.get("orderNo");
		dischargeCategory = (String) generalMap.get("dischargeCategory");
		description = (String) generalMap.get("description");
		labelDataType = (String) generalMap.get("labelDataType");
		changedBy = (String) generalMap.get("changedBy");
		changedDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");

		DischargeItemsCategory dischargeItemsCategory = (DischargeItemsCategory) getHibernateTemplate()
				.get(DischargeItemsCategory.class, dischargeCateogryId);

		dischargeItemsCategory.setId(dischargeCateogryId);
		dischargeItemsCategory.setOrderno(orderNo);
		dischargeItemsCategory.setCategoryName(dischargeCategory);
		dischargeItemsCategory.setLabel(description);
		dischargeItemsCategory.setLabelDataType(labelDataType);

		DischargeItems dischargeItems = new DischargeItems();
		dischargeItems.setId(itemCode);
		dischargeItemsCategory.setItemCode(dischargeItems);

		dischargeItemsCategory.setStatus("y");
		dischargeItemsCategory.setLastChgBy(changedBy);
		dischargeItemsCategory.setLastChgDate(changedDate);
		dischargeItemsCategory.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(dischargeItemsCategory);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDischargeItemsCategory(String dischargeItem) {
		List<DischargeItemsCategory> searchDischargeItemsCategoryList = new ArrayList<DischargeItemsCategory>();
		List<DischargeItems> dischargeItemsList = new ArrayList<DischargeItems>();
		Map<String, Object> dischargeItemsCategoryFieldsMap = new HashMap<String, Object>();

		try {
			if (dischargeItem != "") {
				searchDischargeItemsCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.DischargeItemsCategory as i where i.Label like '"
										+ dischargeItem
										+ "%' order by i.Label ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		dischargeItemsList = getHibernateTemplate().find("from jkt.hms.masters.business.DischargeItems as mc where mc.Status = 'y'");

		dischargeItemsCategoryFieldsMap.put("searchDischargeItemsCategoryList",searchDischargeItemsCategoryList);
		dischargeItemsCategoryFieldsMap.put("dischargeItemsList",
				dischargeItemsList);

		return dischargeItemsCategoryFieldsMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemListForAutoComplete(Map<String, Object> map) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String itemCategoryCodeLaundry = properties.getProperty("itemCategoryCodeLaundry");
		
		try {
			String str =  map.get("autoHint") + "%";
/*			String query = "select mst from MasStoreItem as mst join mst.ItemCategory as mic where upper(mst.Nomenclature) like upper('"
					+ str + "') and mic.ItemCategoryCode = '"+itemCategoryCodeLaundry+"'";
			
			Query q = session.createQuery(query);
			itemList = q.list();*/
			itemList=session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature","%"+str.toUpperCase()+"%")).add(Restrictions.eq("ItemCategory", itemCategoryCodeLaundry)).list();
		} catch (Exception e) {

			e.printStackTrace();
		}
		datamap.put("itemList", itemList);
		return datamap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitKitIssueMasterDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		List<KitIssueMasterTemplateM> existingTemplateList = new ArrayList<KitIssueMasterTemplateM>();
		Session session = (Session)getSession();
		existingTemplateList = session.createCriteria(KitIssueMasterTemplateM.class).add(Restrictions.eq("TemplateName",box.getString("templateName") )).list();
		Transaction tx = null;
		try {
			if(existingTemplateList.size() == 0) {
				tx = session.beginTransaction();
				KitIssueMasterTemplateM kitIssueMasterTemplateM = new KitIssueMasterTemplateM();
				kitIssueMasterTemplateM.setTemplateName(box.getString("templateName"));
				kitIssueMasterTemplateM.setStatus("y");
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				kitIssueMasterTemplateM.setHospital(hospital);
				Users user = new Users();
				user.setId(box.getInt("userId"));
				kitIssueMasterTemplateM.setLastChgBy(user);
				kitIssueMasterTemplateM.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				kitIssueMasterTemplateM.setLastChgTime(box.getString(CHANGED_TIME));
				hbt.save(kitIssueMasterTemplateM);
				
				int counter = box.getInt("hdb");
				if(counter >0) {
					for (int i = 1; i <= counter; i++) {
						if(!box.getString("nomenclature"+i).equals("")) {
							KitIssueMasterTemplateT kitIssueMasterTemplateT = new KitIssueMasterTemplateT();
							kitIssueMasterTemplateT.setAuthQuantity(box.getInt("authQuantity"+i));
							kitIssueMasterTemplateT.setItemName(box.getString("nomenclature"+i));
							kitIssueMasterTemplateT.setTemplate(kitIssueMasterTemplateM);
							kitIssueMasterTemplateT.setStatus("y");
							hbt.save(kitIssueMasterTemplateT);
						}
					} 
					
				}
				map.put("message", "Record saved successfully.");
				tx.commit();
			}else {
				map.put("message", "Template Name already exists.");
			}
		} catch (DataAccessException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			map.put("message", "Some Error Occured.Try Again.");
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getKitTemplateList(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<KitIssueMasterTemplateM> kitIssueList = new ArrayList<KitIssueMasterTemplateM>();
		Session session = (Session) getSession();
		kitIssueList = session.createCriteria(KitIssueMasterTemplateM.class).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
		map.put("kitIssueList", kitIssueList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showKitIssueTemplateDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<KitIssueMasterTemplateT> kitIssueDetailsList = new ArrayList<KitIssueMasterTemplateT>();
		Session session = (Session) getSession();
		kitIssueDetailsList = session.createCriteria(KitIssueMasterTemplateT.class).createAlias("Template", "t").add(Restrictions.eq("t.Id", box.getInt("kitIssueMasterId"))).list();
		map.put("kitIssueDetailsList", kitIssueDetailsList);
		return map;
	}

	@Override
	public Map<String, Object> updateKitIssueMasterDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		List<KitIssueMasterTemplateM> existingTemplateList = new ArrayList<KitIssueMasterTemplateM>();
		Session session = (Session)getSession();
		existingTemplateList = session.createCriteria(KitIssueMasterTemplateM.class).add(Restrictions.eq("TemplateName",box.getString("templateName") )).list();
		Transaction tx = null;
		String deleteKitId = box.getString("deleteKitId");
		
		try {
			tx = session.beginTransaction();
			if(existingTemplateList.size() == 0) {
				KitIssueMasterTemplateM kitIssueMasterTemplateM = new KitIssueMasterTemplateM();
				kitIssueMasterTemplateM.setTemplateName(box.getString("templateName"));
				kitIssueMasterTemplateM.setStatus("y");
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				kitIssueMasterTemplateM.setHospital(hospital);
				Users user = new Users();
				user.setId(box.getInt("userId"));
				kitIssueMasterTemplateM.setLastChgBy(user);
				kitIssueMasterTemplateM.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				kitIssueMasterTemplateM.setLastChgTime(box.getString(CHANGED_TIME));
				hbt.save(kitIssueMasterTemplateM);
				
				int counter = box.getInt("hdb");
				if(counter >0) {
					for (int i = 1; i <= counter; i++) {
						if(!box.getString("nomenclature"+i).equals("")) {
							KitIssueMasterTemplateT kitIssueMasterTemplateT = new KitIssueMasterTemplateT();
							kitIssueMasterTemplateT.setAuthQuantity(box.getInt("authQuantity"+i));
							kitIssueMasterTemplateT.setItemName(box.getString("nomenclature"+i));
							kitIssueMasterTemplateT.setTemplate(kitIssueMasterTemplateM);
							kitIssueMasterTemplateT.setStatus("y");
							hbt.save(kitIssueMasterTemplateT);
						}
					} 
					
				}
				
			
			}else {
				int counter = box.getInt("hdb");
				if(counter >0) {
					for (int i = 1; i <= counter; i++) {
						int kitIssueDetailsId = box.getInt("kitIssueDetailsId"+i);
						
						if(kitIssueDetailsId==0 && !box.getString("nomenclature"+i).equals("")) {
							KitIssueMasterTemplateT kitIssueMasterTemplateT = new KitIssueMasterTemplateT();
							kitIssueMasterTemplateT.setAuthQuantity(box.getInt("authQuantity"+i));
							kitIssueMasterTemplateT.setItemName(box.getString("nomenclature"+i));
							KitIssueMasterTemplateM kitIssueMasterTemplateM = new KitIssueMasterTemplateM();
							kitIssueMasterTemplateM.setId(box.getInt("kitIssueMasterId"));
							kitIssueMasterTemplateT.setTemplate(kitIssueMasterTemplateM);
							kitIssueMasterTemplateT.setStatus("y");
							hbt.save(kitIssueMasterTemplateT);
						}else if(kitIssueDetailsId!=0 && !box.getString("nomenclature"+i).equals("")) {
							KitIssueMasterTemplateT kitIssueMasterTemplateT = (KitIssueMasterTemplateT) hbt.load(KitIssueMasterTemplateT.class, kitIssueDetailsId);
							kitIssueMasterTemplateT.setAuthQuantity(box.getInt("authQuantity"+i));
							kitIssueMasterTemplateT.setItemName(box.getString("nomenclature"+i));
							hbt.update(kitIssueMasterTemplateT);
						}
					} 
					
				}
				
				if(!deleteKitId.equals("")) {
					String arr[]=deleteKitId.split(",");
					for(int i=0;i<arr.length;i++) {
						if(!arr[i].equals("") && Integer.parseInt(arr[i].toString())!=0) {
							KitIssueMasterTemplateT kitIssueMasterTemplateT = (KitIssueMasterTemplateT) hbt.load(KitIssueMasterTemplateT.class, Integer.parseInt(arr[i].toString()));
							kitIssueMasterTemplateT.setStatus("n");
							hbt.update(kitIssueMasterTemplateT);
						}
					}
					
				}
				
			}
			map.put("message", "Record saved successfully.");
			tx.commit();
		} catch (DataAccessException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			map.put("message", "Some Error Occured.Try Again.");
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteKitIssueTemplate(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag = false;
		try {
			KitIssueMasterTemplateM kitIssueMasterTemplateM = (KitIssueMasterTemplateM)hbt.load(KitIssueMasterTemplateM.class, box.getInt("kitIssueMasterId"));
			if(box.getString("flag").equals("inactive")) {
				kitIssueMasterTemplateM.setStatus("n");
			}else {
				kitIssueMasterTemplateM.setStatus("y");
			}
			hbt.update(kitIssueMasterTemplateM);
			flag=true;
			map.put("message", "Record saved successfully.");
		} catch (DataAccessException e) {
			map.put("message", "Some Error Occured.Try Again.");
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> getPatientDetailsForKitIssue(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<KitIssueMasterTemplateM> templateList = new ArrayList<KitIssueMasterTemplateM>();
		List<IpdKitIssueHeader> ipdKitIssueList = new ArrayList<IpdKitIssueHeader>();
		inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("inpatientId"))).list();
		templateList = session.createCriteria(KitIssueMasterTemplateM.class).add(Restrictions.eq("Status", "y")).list();
		ipdKitIssueList = session.createCriteria(IpdKitIssueHeader.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent"))).list();
		map.put("inpatientList", inpatientList);
		map.put("templateList", templateList);
		map.put("ipdKitIssueList", ipdKitIssueList);
		return map;
	}

}