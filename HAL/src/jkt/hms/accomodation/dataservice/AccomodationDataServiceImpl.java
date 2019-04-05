package jkt.hms.accomodation.dataservice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.AccomAllotment;
import jkt.hms.masters.business.AccomRegistration;
import jkt.hms.masters.business.MasCarGarage;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLocation;
import jkt.hms.masters.business.MasPool;
import jkt.hms.masters.business.MasPoolCategory;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasSmq;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.PoolRank;
import jkt.hms.masters.business.RelegationProcess;
import jkt.hms.masters.business.SmqVacation;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AccomodationDataServiceImpl extends HibernateDaoSupport implements
		AccomodationDataService {

	/**
	 * -------------------------------- method to show Pool Category
	 * --------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPoolCategory() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPoolCategory> searchPoolCategoryList = new ArrayList<MasPoolCategory>();
		searchPoolCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPoolCategory ");
		map.put("searchPoolCategoryList", searchPoolCategoryList);
		return map;
	}

	/**
	 * --------------------------------- method to add Pool Category
	 * -----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean addPoolCategory(MasPoolCategory masPoolCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masPoolCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	/**
	 * --------------------------------- method to edit Pool Category
	 * ----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean editPoolToCategory(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String poolCategoryName = "";
		@SuppressWarnings("unused")
		String poolCategoryCode = "";
		int poolCategoryId = 0;
		String changedBy = "";
		try {
			poolCategoryId = (Integer) generalMap.get("id");
			poolCategoryCode = (String) generalMap.get("poolCategoryCode");
			poolCategoryName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			System.out
					.println("Exception before masPoolCategory in dataserviceImpl "
							+ e);
		}

		MasPoolCategory masPoolCategory = (MasPoolCategory) getHibernateTemplate()
				.get(MasPoolCategory.class, poolCategoryId);

		masPoolCategory.setId(poolCategoryId);
		masPoolCategory.setPoolCategoryName(poolCategoryName);
		masPoolCategory.setLastChgBy(changedBy);
		masPoolCategory.setLastChgDate(currentDate);
		masPoolCategory.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masPoolCategory);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/**
	 * --------------------------------- method to delete Pool Category
	 * --------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean deletePoolCategory(int poolCategoryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasPoolCategory masPoolCategory = new MasPoolCategory();
		masPoolCategory = (MasPoolCategory) getHibernateTemplate().get(
				MasPoolCategory.class, poolCategoryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masPoolCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masPoolCategory.setStatus("y");
				dataDeleted = false;
			}
		}
		masPoolCategory.setLastChgBy(changedBy);
		masPoolCategory.setLastChgDate(currentDate);
		masPoolCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masPoolCategory);
		return dataDeleted;
	}

	/**
	 * --------------------------------- method to search Pool Category
	 * -----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPoolCategory(String poolCategoryCode,
			String poolCategoryName) {
		List<MasPoolCategory> searchPoolCategoryList = new ArrayList<MasPoolCategory>();
		Map<String, Object> poolCategoryFieldsMap = new HashMap<String, Object>();
		try {
			if ((poolCategoryName != null) || (poolCategoryCode == null)) {

				searchPoolCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasPoolCategory imc where imc.PoolCategoryName like '"
										+ poolCategoryName
										+ "%' order by imc.PoolCategoryName");
			} else {
				searchPoolCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasPoolCategory imc where imc.PoolCategoryCode like '"
										+ poolCategoryCode
										+ "%' order by imc.PoolCategoryCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchPoolCategoryList  " + e);
		}
		poolCategoryFieldsMap.put("searchPoolCategoryList",
				searchPoolCategoryList);
		return poolCategoryFieldsMap;
	}

	/**
	 * -------------------------------- method to show Location Master
	 * -------------------------------------
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showLocationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLocation> searchLocationList = new ArrayList<MasLocation>();
		searchLocationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasLocation ");
		map.put("searchLocationList", searchLocationList);
		return map;
	}

	/**
	 * --------------------------------- method to add Location Master
	 * --------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean addLocation(MasLocation masLocation) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masLocation);
		successfullyAdded = true;
		return successfullyAdded;
	}

	/**
	 * --------------------------------- method to edit Location Master
	 * ----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean editLocation(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String locationName = "";
		int locationId = 0;
		String changedBy = "";
		try {
			locationId = (Integer) generalMap.get("id");
			locationName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			//System.out.println("Exception before masTitle in dataserviceImpl "+ e);
		}

		MasLocation masLocation = (MasLocation) getHibernateTemplate().get(
				MasLocation.class, locationId);

		masLocation.setId(locationId);
		masLocation.setLocationName(locationName);
		masLocation.setLastChgBy(changedBy);
		masLocation.setLastChgDate(currentDate);
		masLocation.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masLocation);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/**
	 * --------------------------------- method to delete Location
	 * -------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean deleteLocation(int locationId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasLocation masLocation = new MasLocation();
		masLocation = (MasLocation) getHibernateTemplate().get(
				MasLocation.class, locationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masLocation.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masLocation.setStatus("y");
				dataDeleted = false;
			}
		}
		masLocation.setLastChgBy(changedBy);
		masLocation.setLastChgDate(currentDate);
		masLocation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masLocation);
		return dataDeleted;
	}

	/**
	 * --------------------------------- method to search Location
	 * --------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchLocation(String locationCode,
			String locationName) {
		List<MasLocation> searchLocationList = new ArrayList<MasLocation>();
		Map<String, Object> locationFieldsMap = new HashMap<String, Object>();
		try {
			if ((locationName != null) || (locationCode == null)) {

				searchLocationList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasLocation imc where imc.LocationName like '"
										+ locationName
										+ "%' order by imc.LocationName");
			} else {
				searchLocationList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasLocation imc where imc.LocationCode like '"
										+ locationCode
										+ "%' order by imc.LocationCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchLocationList  " + e);
		}
		locationFieldsMap.put("searchLocationList", searchLocationList);
		return locationFieldsMap;
	}

	/**
	 * -------------------------------- method to show Car
	 * Garage--------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showCarGarage() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCarGarage> searchCarGarageList = new ArrayList<MasCarGarage>();
		searchCarGarageList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCarGarage ");
		map.put("searchCarGarageList", searchCarGarageList);
		return map;
	}

	/**
	 * -------------------------------- method to add Car Garage
	 * ------------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean addCarGarage(MasCarGarage masCarGarage) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCarGarage);
		successfullyAdded = true;
		return successfullyAdded;
	}

	/**
	 * --------------------------------------method to edit Car Garage
	 * ----------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean editCarGarage(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String carGarageName = "";
		int carGarageId = 0;
		String changedBy = "";
		try {
			carGarageId = (Integer) generalMap.get("id");
			carGarageName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			System.out
					.println("Exception before masCarGarage in dataserviceImpl "
							+ e);
		}

		MasCarGarage masCarGarage = (MasCarGarage) getHibernateTemplate().get(
				MasCarGarage.class, carGarageId);

		masCarGarage.setId(carGarageId);
		masCarGarage.setCarGarageName(carGarageName);
		masCarGarage.setLastChgBy(changedBy);
		masCarGarage.setLastChgDate(currentDate);
		masCarGarage.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masCarGarage);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/**
	 * --------------------------------------------method to delete Car
	 * Garage--------------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean deleteCarGarage(int carGarageId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasCarGarage masCarGarage = new MasCarGarage();
		masCarGarage = (MasCarGarage) getHibernateTemplate().get(
				MasCarGarage.class, carGarageId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCarGarage.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCarGarage.setStatus("y");
				dataDeleted = false;
			}
		}
		masCarGarage.setLastChgBy(changedBy);
		masCarGarage.setLastChgDate(currentDate);
		masCarGarage.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masCarGarage);
		return dataDeleted;
	}

	/**
	 * -----------------------------method to search car garage
	 * ----------------------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCarGarage(String carGarageCode,
			String carGarageName) {
		List<MasCarGarage> searchCarGarageList = new ArrayList<MasCarGarage>();
		Map<String, Object> carGarageFieldsMap = new HashMap<String, Object>();
		try {
			if ((carGarageName != null) || (carGarageCode == null)) {

				searchCarGarageList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCarGarage imc where imc.CarGarageName like '"
								+ carGarageName
								+ "%' order by imc.CarGarageName");
			} else {
				searchCarGarageList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCarGarage imc where imc.CarGarageCode like '"
								+ carGarageCode
								+ "%' order by imc.CarGarageCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchCarGarageList  " + e);
		}
		carGarageFieldsMap.put("searchCarGarageList", searchCarGarageList);
		return carGarageFieldsMap;
	}

	/**
	 * ------------------------------------- method to show Pool Master
	 * -----------------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPoolJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPool> searchPoolList = new ArrayList<MasPool>();
		List<MasPoolCategory> poolCategoryList = new ArrayList<MasPoolCategory>();
		List<MasPoolCategory> gridPoolCategoryList = new ArrayList<MasPoolCategory>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<PoolRank> gridRankList = new ArrayList<PoolRank>();

		searchPoolList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPool ");
		gridPoolCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPoolCategory as isc");
		poolCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPoolCategory as isc where isc.Status = 'y'");
		gridRankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.PoolRank as isc");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as isc where isc.ServiceType.Id = '2' and isc.ServiceStatus.Id='1'");
		map.put("searchPoolList", searchPoolList);
		map.put("poolCategoryList", poolCategoryList);
		map.put("gridPoolCategoryList", gridPoolCategoryList);
		map.put("rankList", rankList);
		map.put("gridRankList", gridRankList);
		return map;
	}

	/**
	 * ------------------------------------------ method to add pool Master
	 * -----------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> addPool(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasPool masPool = new MasPool();
		Box box = null;
		boolean saved = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		String poolCode = (String) dataMap.get("code");
		String poolName = (String) dataMap.get("name");
		int authorisation = (Integer) dataMap.get("authorisation");
		int poolCategoryId = (Integer) dataMap.get("poolCategoryId");
		String changedBy = (String) dataMap.get("changedBy");
		Date currentDate = (Date) dataMap.get("currentDate");

		masPool.setPoolCode(poolCode);
		masPool.setPoolName(poolName);
		masPool.setAuthorisation(authorisation);
		MasPoolCategory maspoolCategory = new MasPoolCategory();
		maspoolCategory.setId(poolCategoryId);
		masPool.setPoolCategory(maspoolCategory);
		masPool.setStatus("y");
		masPool.setLastChgBy(changedBy);
		masPool.setLastChgDate(currentDate);
		masPool.setLastChgTime(time);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			hbt.save(masPool);
			hbt.refresh(masPool);
			Vector rankId = box.getVector(RequestConstants.RANK_ID);
			for (int i = 0; i < rankId.size(); i++) {
				PoolRank poolRank = new PoolRank();
				poolRank.setPool(masPool);
				if (rankId.get(i) != null && !rankId.get(i).equals("")) {
					MasRank masRank1 = new MasRank();
					masRank1.setId(Integer.parseInt((String) rankId.get(i)));
					poolRank.setRank(masRank1);
				}
				hbt.save(poolRank);
				hbt.refresh(poolRank);
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	/**
	 * --------------------------------------- method to edit
	 * pool--------------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean editPool(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String poolName = "";
		int poolId = 0;
		String changedBy = "";
		Integer authorisation = 0;
		int poolCategoryId = 0;
		String rankStr = null;
		try {

			poolName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			poolId = (Integer) generalMap.get("poolId");
			authorisation = (Integer) generalMap.get("authorisation");
			poolCategoryId = (Integer) generalMap.get("poolCategoryId");
			if (generalMap.get("rankStr") != null) {
				rankStr = (String) generalMap.get("rankStr");
			}

		} catch (Exception e) {
			//System.out.println("Exception before masTitle in dataserviceImpl "+ e);
		}
		StringTokenizer str = new StringTokenizer(rankStr, ",");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasPool masPool = (MasPool) getHibernateTemplate().get(MasPool.class,
				poolId);

		masPool.setId(poolId);
		masPool.setPoolName(poolName);
		masPool.setAuthorisation(authorisation);
		masPool.setLastChgBy(changedBy);
		masPool.setLastChgDate(currentDate);
		masPool.setLastChgTime(currentTime);
		MasPoolCategory maspoolCategory = new MasPoolCategory();
		maspoolCategory.setId(poolCategoryId);
		masPool.setPoolCategory(maspoolCategory);
		try {

			hbt.saveOrUpdate(masPool);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		List<PoolRank> poolRankList = hbt
				.find("from jkt.hms.masters.business.PoolRank ud where ud.Pool.Id="
						+ poolId);
		for (Iterator iterator = poolRankList.iterator(); iterator.hasNext();) {
			PoolRank poolRank = (PoolRank) iterator.next();
			int id = poolRank.getId();
			String hql = "delete from jkt.hms.masters.business.PoolRank as a where a.Id = "
					+ id;
			Query query = session.createQuery(hql);
			int row = query.executeUpdate();
		}
		while (str.hasMoreTokens()) {
			PoolRank poolRank = new PoolRank();
			int rankId = Integer.parseInt(str.nextToken());
			poolRank.setRank(new MasRank(rankId));
			poolRank.setPool(masPool);

			try {
				hbt.save(poolRank);
				hbt.refresh(poolRank);
				dataUpdated = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dataUpdated;
	}

	/**
	 * ------------------------------------- method to search pool master
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPool(String poolCode, String poolName) {
		List<MasPool> searchPoolList = new ArrayList<MasPool>();
		List<MasPoolCategory> poolCategoryList = new ArrayList<MasPoolCategory>();
		List<MasPoolCategory> gridPoolCategoryList = new ArrayList<MasPoolCategory>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<PoolRank> gridRankList = new ArrayList<PoolRank>();

		Map<String, Object> poolFieldsMap = new HashMap<String, Object>();

		try {
			if ((poolName != null) || (poolCode == null)) {

				searchPoolList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasPool imc where imc.PoolName like '"
								+ poolName + "%' order by imc.PoolName");
			} else {
				searchPoolList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasPool imc where imc.PoolCode like '"
								+ poolCode + "%' order by imc.PoolCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchPool  " + e);
		}

		gridPoolCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPoolCategory as isc");
		poolCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPoolCategory as isc where isc.Status = 'y'");
		gridRankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.PoolRank as isc");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as isc where isc.Status = 'y' and isc.ServiceStatus.Id='1'");
		poolFieldsMap.put("poolCategoryList", poolCategoryList);
		poolFieldsMap.put("gridPoolCategoryList", gridPoolCategoryList);
		poolFieldsMap.put("searchPoolList", searchPoolList);
		poolFieldsMap.put("gridRankList", gridRankList);
		poolFieldsMap.put("rankList", rankList);
		return poolFieldsMap;
	}

	/**
	 * ------------------------------------- method to delete Pool
	 * Master---------------------------------
	 */
	public boolean deletePool(int poolId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasPool masPool = new MasPool();
		masPool = (MasPool) getHibernateTemplate().get(MasPool.class, poolId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masPool.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masPool.setStatus("y");
				dataDeleted = false;
			}
		}
		masPool.setLastChgBy(changedBy);
		masPool.setLastChgDate(currentDate);
		masPool.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masPool);
		return dataDeleted;
	}

	/**
	 * -----------------------------------method to show SMQ Master
	 * -------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showSMQJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSmq> searchSmqList = new ArrayList<MasSmq>();
		List<MasPoolCategory> poolCategoryList = new ArrayList<MasPoolCategory>();
		List<MasPoolCategory> gridPoolCategoryList = new ArrayList<MasPoolCategory>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		List<MasPool> gridPoolList = new ArrayList<MasPool>();
		List<MasLocation> locationList = new ArrayList<MasLocation>();
		List<MasLocation> gridLocationList = new ArrayList<MasLocation>();

		searchSmqList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSmq ");
		gridPoolCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPoolCategory as isc");
		poolCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPoolCategory as isc where isc.Status = 'y'");
		gridPoolList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPool as isc");
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as isc where isc.Status = 'y'");
		gridLocationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasLocation as isc");
		locationList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasLocation as isc where isc.Status = 'y'");
		String SmqCode="S"+generateCodeNumber("SmqMaster","SMQM","SMQ Master Code");

		map.put("searchSmqList", searchSmqList);
		map.put("poolCategoryList", poolCategoryList);
		map.put("gridPoolCategoryList", gridPoolCategoryList);
		map.put("poolList", poolList);
		map.put("gridPoolList", gridPoolList);
		map.put("locationList", locationList);
		map.put("gridLocationList", gridLocationList);
		map.put("SmqCode", SmqCode);
		return map;
	}
	public String generateCodeNumber(String className,String prefix , String message){
		String generatedCode ="";
		int temp=0;
		List<TransactionSequence> orderSeqNoList = null;
		Session session = getSession();
		try {
			orderSeqNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", prefix)).list();
			if(orderSeqNoList!=null && orderSeqNoList.size()>0){
				temp=orderSeqNoList.get(0).getTransactionSequenceNumber();
				generatedCode =String.valueOf(++temp);
			}else{
				generatedCode="1";
				TransactionSequence transactionSequence = new TransactionSequence();
				transactionSequence.setTransactionPrefix(prefix);
				transactionSequence.setTransactionSequenceName(message);
				transactionSequence.setTransactionSequenceNumber(0);
				transactionSequence.setTablename(className);
				transactionSequence.setStatus("y");
				session.save(transactionSequence);
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}
		return generatedCode ;
	}
	public boolean saveCodeNumber(String prefix)
	{
		boolean successfull=false;
		int temp=0;
		List<TransactionSequence> orderSeqNoList = null;
		TransactionSequence transactionSequence = null ;
		Session session = getSession();
		
		try {
			orderSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", prefix)).list();
			if(orderSeqNoList !=null){
			temp = orderSeqNoList.get(0).getTransactionSequenceNumber();
			transactionSequence = orderSeqNoList.get(0);
			transactionSequence.setTransactionSequenceNumber(temp++);
			session.persist(transactionSequence);
			successfull=true;
			}else{
				successfull=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			successfull=false;
			session.close();
			// TODO: handle exception
		}
		return successfull;
	}
	public String generateYearlyEntryNo()
	{
		Map<String, Object> utilMap = null;
		List<MasSmq> searchSmqList = null;
		List<TransactionSequence> orderSeqNoList = null;
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String entrySeqNo="";
		String lastSeqNo="";
		String lastSeqYear="";
		Session session = getSession();

		try {
			searchSmqList = session.createCriteria(MasSmq.class).list();
			if (searchSmqList !=null && searchSmqList.size() > 0) {
				for (MasSmq Smq : searchSmqList) {
					lastSeqNo = Smq.getSmqCode();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			orderSeqNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "SMQM")).list();
			// .setProjection(Projections.projectionList().add(Projections.max("TransactionSequenceNumber")))
			//System.out.println("orderSeqNoList:::" + orderSeqNoList.size());
			if (orderSeqNoList != null && orderSeqNoList.size() > 0) {
				for (TransactionSequence maxOrderNo : orderSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entrySeqNo = String.valueOf(maxOrderNo
								.getTransactionSequenceNumber() + 1);
					} else {
						entrySeqNo = String.valueOf(1);
						maxOrderNo.setTransactionSequenceNumber(0);
						session.saveOrUpdate(maxOrderNo);

					}
				}
			} else {
				entrySeqNo = String.valueOf(1);
				TransactionSequence transactionSequence = new TransactionSequence();
				transactionSequence.setTransactionPrefix("SMQM");
				transactionSequence.setTransactionSequenceName("Smq Master Entry No.");
				transactionSequence.setTransactionSequenceNumber(0);
				transactionSequence.setTablename("MasSmq");
				transactionSequence.setStatus("y");
				session.save(transactionSequence);
			}
			entrySeqNo = entrySeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		return entrySeqNo;
	}

	/**
	 * ---------------------------------method to add SMQ
	 * Master--------------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean addSmqMaster(MasSmq masSmq) {
		boolean successfullyAdded = false;
		List<TransactionSequence> orderSeqNoList = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = getSession();
	
		try {
			successfullyAdded =saveCodeNumber("SMQM");
			hbt.save(masSmq);
			TransactionSequence transactionSequence = null;
			orderSeqNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "SMQM")).list();
			transactionSequence=orderSeqNoList.get(0);
			int sqno = transactionSequence.getTransactionSequenceNumber() +1 ;
			//System.out.println("transactionSequence::"+transactionSequence.getTransactionSequenceNumber()+"::sqno::"+sqno);
			transactionSequence.setTransactionSequenceNumber(sqno);
			hbt.saveOrUpdate(transactionSequence);
			hbt.refresh(transactionSequence);
			successfullyAdded = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			successfullyAdded = false;
			e.printStackTrace();
			
		}
		return successfullyAdded;
	}

	/**
	 * ------------------------------------- method to delete SMQ Master
	 * ----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean deleteSmqMaster(int smqId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasSmq masSmq = new MasSmq();
		masSmq = (MasSmq) getHibernateTemplate().get(MasSmq.class, smqId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masSmq.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masSmq.setStatus("y");
				dataDeleted = false;
			}
		}
		masSmq.setLastChgBy(changedBy);
		masSmq.setLastChgDate(currentDate);
		masSmq.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masSmq);
		return dataDeleted;
	}

	/**
	 * --------------------------------------method to search SMQ Master
	 * ----------------------------------------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchSmqMaster(String smqCode, String smqName) {
		List<MasSmq> searchSmqList = new ArrayList<MasSmq>();
		List<MasPoolCategory> poolCategoryList = new ArrayList<MasPoolCategory>();
		List<MasPoolCategory> gridPoolCategoryList = new ArrayList<MasPoolCategory>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		List<MasPool> gridPoolList = new ArrayList<MasPool>();
		List<MasLocation> locationList = new ArrayList<MasLocation>();
		List<MasLocation> gridLocationList = new ArrayList<MasLocation>();
		Map<String, Object> smqFieldsMap = new HashMap<String, Object>();

		try {
			if ((smqName != null) || (smqCode == null)) {

				searchSmqList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasSmq imc where imc.SmqName like '%"
								+ smqName + "%' order by imc.SmqName");
			} else {
				searchSmqList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasSmq imc where imc.SmqCode like '"
								+ smqCode + "%' order by imc.SmqCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchSMQ  " + e);
		}

		gridPoolCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPoolCategory as isc");
		poolCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPoolCategory as isc where isc.Status = 'y'");
		gridPoolList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPool as isc");
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as isc where isc.Status = 'y'");
		gridLocationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasLocation as isc");
		locationList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasLocation as isc where isc.Status = 'y'");
		smqFieldsMap.put("searchSmqList", searchSmqList);
		smqFieldsMap.put("poolCategoryList", poolCategoryList);
		smqFieldsMap.put("gridPoolCategoryList", gridPoolCategoryList);
		smqFieldsMap.put("poolList", poolList);
		smqFieldsMap.put("gridPoolList", gridPoolList);
		smqFieldsMap.put("locationList", locationList);
		smqFieldsMap.put("gridLocationList", gridLocationList);
		return smqFieldsMap;
	}

	/**
	 * -------------------------------------- method to edit mas Smq
	 * ------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean editSMQ(Map<String, Object> generalMap) {
		boolean editedSuccessfully = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";
		int smqId = (Integer) generalMap.get("smqId");
		int poolId = (Integer) generalMap.get("poolId");
		String smqStatus = (String) generalMap.get("smqStatus");
		int poolCategoryId = (Integer) generalMap.get("poolCategoryId");
		int locationId = (Integer) generalMap.get("locationId");
		String smqName = (String) generalMap.get("smqName");
		String smqCode = (String) generalMap.get("smqCode");
		String smqType = (String) generalMap.get("smqType");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasSmq masSmq = (MasSmq) getHibernateTemplate()
				.get(MasSmq.class, smqId);
		if (smqId != '0') {
			masSmq.setId(smqId);
		}
		masSmq.setSmqCode(smqCode);
		masSmq.setSmqName(smqName);
		masSmq.setSmqStatus(smqStatus);
		masSmq.setSmqType(smqType);
		if (poolCategoryId != '0') {
			MasPoolCategory masPoolCategory = new MasPoolCategory();
			masPoolCategory.setId(poolCategoryId);
			masSmq.setPoolCategory(masPoolCategory);
		}
		if (poolId != '0') {
			MasPool masPool = new MasPool();
			masPool.setId(poolId);
			masSmq.setPool(masPool);
		}
		if (locationId != '0') {
			MasLocation masLocation = new MasLocation();
			masLocation.setId(locationId);
			masSmq.setLocation(masLocation);
		}

		masSmq.setLastChgBy(changedBy);
		masSmq.setLastChgDate(currentDate);
		masSmq.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSmq);
		editedSuccessfully = true;
		return editedSuccessfully;
	}

	/**
	 * --------------------------------------- method to show accomodation
	 * Registration For Airmen -------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> registraionForAirmen() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasUnit> previousUnitList = new ArrayList<MasUnit>();

		List<PoolRank> poolRankList = new ArrayList<PoolRank>();
		List<MasPool> poolList = new ArrayList<MasPool>();

		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as isc where isc.RankCategory.Id not in('1','7') and isc.ServiceStatus.Id='1' and isc.ServiceType.Id in('1','2','6') ");
		tradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade as isc where isc.Status = 'y'");
		unitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as isc where isc.Status = 'y' and isc.DependentUnit = 'y'");
		previousUnitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as isc where isc.Status = 'y'");

		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as mp where mp.Status='y' and mp.PoolCategory.Id='1'");
		poolRankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.PoolRank where Pool.PoolCategory.Id='1'");

		map.put("serviceTypeList", serviceTypeList);
		map.put("rankList", rankList);
		map.put("tradeList", tradeList);
		map.put("unitList", unitList);
		map.put("previousUnitList", previousUnitList);
		map.put("poolList", poolList);
		map.put("poolRankList", poolRankList);

		return map;
	}

	/**
	 * ------------------------------------method to generate Registration No
	 * ---------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public String generateRegistrationNumber() {
		List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
		List<AccomRegistration> seqNoList = new ArrayList<AccomRegistration>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		String registrationNo = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(AccomRegistration.class).list();
		if (seqNoList.size() > 0) {
			for (AccomRegistration accomReg : seqNoList) {
				lastSeqNo = accomReg.getRegistrationNo();
			}

			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		yearlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "REG")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (yearlySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : yearlySeqNoList) {
				TransactionSequence obj = (TransactionSequence) yearlySeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if (currentYear.equals(lastSeqYear)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					seqNo = 0;
				}
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				registrationNo = registrationNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}

		} else if (yearlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("AccomRegistration");
			tsObj.setTransactionPrefix("REG");
			tsObj.setTransactionSequenceName("Registration No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			registrationNo = registrationNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}

		return registrationNo;
	}

	@SuppressWarnings("unchecked")
	public String getRegistrationNumber(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<AccomRegistration> seqNoList = new ArrayList<AccomRegistration>();
		String registrationNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(AccomRegistration.class).list();
			if (seqNoList.size() > 0) {
				for (AccomRegistration accom : seqNoList) {
					lastSeqNo = accom.getRegistrationNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "REG"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear) && maxOrderNo != null) {
						registrationNo = String.valueOf(maxOrderNo + 1);
					} else {
						registrationNo = String.valueOf(1);
					}
				}
			} else {
				registrationNo = String.valueOf(1);
			}

			registrationNo = registrationNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return registrationNo;
	}

	/**
	 * ------------------------------------- method to get Records From Employee
	 * Master for Airmen Registration-------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getRecordsForAirMenReg(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		String queryString = null;
		String queryString1 = null;
		String serviceNo = "";
		try {

			serviceNo = box.getString(RequestConstants.SERVICE_NO);
			if (serviceNo != null && !serviceNo.equals("")) {
				queryString = "from MasEmployee where Unit.Id in(31,59,160,184) and ServiceNo="
						+ serviceNo;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			employeeList = getHibernateTemplate().find(queryString);
			if (employeeList != null && employeeList.size() > 0) {
				//System.out.println("employeeList.size() in data service    "+ employeeList.get(0).getRank().getId());
				queryString1 = "from MasRank where Id='"
						+ employeeList.get(0).getRank().getId()
						+ "' and RankCategory.Id ='3'";
				rankList = getHibernateTemplate().find(queryString1);
			}
			if (rankList != null && rankList.size() <= 0) {
				employeeList = null;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getRecordsForOfficersReg(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		String queryString = null;
		String queryString1 = null;
		String serviceNo = "";
		try {

			serviceNo = box.getString(RequestConstants.SERVICE_NO);
			if (serviceNo != null && !serviceNo.equals("")) {
				queryString = "from MasEmployee where Unit.Id in(31,59,160,184) and ServiceNo="
						+ serviceNo;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			employeeList = getHibernateTemplate().find(queryString);
			if (employeeList != null && employeeList.size() > 0) {
				queryString1 = "from MasRank where Id='"
						+ employeeList.get(0).getRank().getId()
						+ "' and RankCategory.Id ='1'";
				rankList = getHibernateTemplate().find(queryString1);
			}
			if (rankList != null && rankList.size() <= 0) {
				employeeList = null;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		return map;
	}

	/**
	 * ---------- method to get records on basis of service no
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getRecordsOfServiceNo(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		String queryString = null;
		String serviceNo = "";
		serviceNo = box.get(RequestConstants.SERVICE_NO);
		queryString = "from AccomRegistration where ServiceNo=" + serviceNo;

		try {
			employeeList = getHibernateTemplate().find(queryString);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("employeeList", employeeList);

		return map;
	}

	/**
	 * ------------------------------------- method to add records for
	 * registration for airmen --------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean submitRegForAirmen(AccomRegistration accomReg) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(accomReg);
		successfullyAdded = true;
		return successfullyAdded;
	}

	/**
	 * ------------------------------------- checking for existing service no
	 * added -----------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> checkForExistingServiceNo(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int rankId = 0;
		if (generalMap.get("serviceNo") != null) {
			serviceNo = (String) generalMap.get("serviceNo");
		}
		if (generalMap.get("rankId") != null) {
			rankId = (Integer) generalMap.get("rankId");
		}
		List<AccomRegistration> duplicateServiceNoList = new ArrayList<AccomRegistration>();
		duplicateServiceNoList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.AccomRegistration as g where g.ServiceNo = '"
						+ serviceNo + "'and g.Rank.Id = '" + rankId + "'");
		map.put("duplicateServiceNoList", duplicateServiceNoList);
		return map;
	}

	/**
	 * ------------------------------------- get Pool code list for
	 * allotment-----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPoolListForAlltment() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '2'");
		map.put("poolList", poolList);

		return map;
	}

	/**
	 * ------------------------------------- method to get records on basis of
	 * pool code in allotment ---------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getRecordsForAirMenAllotment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomRegistration> airmenRegList = new ArrayList<AccomRegistration>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		List<MasPool> poolList = new ArrayList<MasPool>();

		String queryString = null;
		String queryString1 = null;
		int poolId = box.getInt(RequestConstants.POOL_ID);
		queryString = "from AccomRegistration where RegStatus='n' or RegStatus= 'c' and RegType='a' and Pool.Id="
				+ poolId;
		queryString1 = "from MasSmq where SmqStatus ='v'and Pool.Id=" + poolId;
		try {

			airmenRegList = getHibernateTemplate().find(queryString);
			smqList = getHibernateTemplate().find(queryString1);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '2'");
		map.put("airmenRegList", airmenRegList);
		map.put("smqList", smqList);
		map.put("poolList", poolList);
		return map;
	}

	/**
	 * ------------------------------------------ method to generate allotment
	 * number --------------------------------
	 */

	@SuppressWarnings("unchecked")
	public String generateAllotmentNumber(Map<String, Object> diagMap) {
		List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
		List<AccomAllotment> seqNoList = new ArrayList<AccomAllotment>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		String allotmentNo = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(AccomAllotment.class).list();
		if (seqNoList.size() > 0) {
			for (AccomAllotment accomAllot : seqNoList) {
				lastSeqNo = accomAllot.getAllotmentNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		yearlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "AN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (yearlySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : yearlySeqNoList) {
				TransactionSequence obj = (TransactionSequence) yearlySeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if (currentYear.equals(lastSeqYear)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					seqNo = 0;
				}
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				allotmentNo = allotmentNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}

		} else if (yearlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("AccomAllotment");
			tsObj.setTransactionPrefix("AN");
			tsObj.setTransactionSequenceName("Allotment No.");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			allotmentNo = allotmentNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return allotmentNo;
	}

	@SuppressWarnings("unchecked")
	public String getAllotmentNumber(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<AccomAllotment> seqNoList = new ArrayList<AccomAllotment>();
		String allotmentNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(AccomAllotment.class).list();
			if (seqNoList.size() > 0) {
				for (AccomAllotment accom : seqNoList) {
					lastSeqNo = accom.getAllotmentNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "AN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear) && maxOrderNo != null) {
						allotmentNo = String.valueOf(maxOrderNo + 1);
					} else {
						allotmentNo = String.valueOf(1);
					}
				}
			} else {
				allotmentNo = String.valueOf(1);
			}

			allotmentNo = allotmentNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return allotmentNo;
	}

	/**
	 * ------------------------------------ method to submit allotments for
	 * airmen ---------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitAllotmentForAirmen(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}

		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '2'");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector poolId = box.getVector(RequestConstants.POOL_NAME);
			Vector rankId = box.getVector(RequestConstants.RANK_ID);
			Vector smqId = box.getVector(RequestConstants.SMQ_NAME);
			Vector accomId = box.getVector(RequestConstants.ACCOM_ID);
			Vector allotmentType = box
					.getVector(RequestConstants.TYPE_OF_ALLOTMENT);
			String remarks = box.getString(RequestConstants.REMARKS);
			Vector retentionDate = box
					.getVector(RequestConstants.RETENTION_TILL);
			String allotmentNo = box.getString(RequestConstants.ALLOTMENT_NO);
			Vector changedBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector currentTime = box.getVector(RequestConstants.CHANGED_TIME);
			Vector deptId = box.getVector(RequestConstants.DEPARTMENT_ID);
			Vector hospitalId = box.getVector(RequestConstants.HOSPITAL_ID);
			String allotmentTime = box
					.getString(RequestConstants.ALLOTMENT_TIME);

			for (int i = 0; i < smqId.size(); i++) {
				AccomAllotment accomAllot = new AccomAllotment();
				if (smqId.get(i) != null && !smqId.get(i).equals("")) {
					if (rankId.get(i) != null && !rankId.get(i).equals("")) {
						MasRank masRank = new MasRank();
						masRank.setId(Integer.parseInt((String) rankId.get(i)));
						accomAllot.setRank(masRank);
					}
					MasPool masPool = new MasPool();
					masPool.setId(Integer.parseInt((String) poolId.get(i)));
					accomAllot.setPool(masPool);

					if (smqId.get(i) != null && !smqId.get(i).equals("")) {
						MasSmq masSmq = new MasSmq();
						masSmq.setId(Integer.parseInt((String) smqId.get(i)));
						accomAllot.setSmq(masSmq);
					}
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer
							.parseInt((String) deptId.get(i)));
					accomAllot.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(Integer.parseInt((String) hospitalId
							.get(i)));
					accomAllot.setHospital(masHospital);

					if (accomId.get(i) != null && !accomId.get(i).equals("")) {
						AccomRegistration accomReg = new AccomRegistration();
						accomReg.setId(Integer
								.parseInt((String) accomId.get(i)));
						accomAllot.setAccom(accomReg);
					}
					if (allotmentType.get(i) != null
							&& !allotmentType.equals("")) {
						accomAllot.setAllotmentType((String) allotmentType
								.get(i));
					}

					if (remarks != null && !remarks.equals("")) {
						accomAllot.setRemarks(remarks);
					}
					if (retentionDate != null && !retentionDate.equals("")) {
						if (allotmentType.get(i).equals("r")) {
							accomAllot
									.setRetentionDate(HMSUtil
											.convertStringTypeDateToDateType(box
													.get(RequestConstants.RETENTION_TILL)));
						} else {
							accomAllot.setRetentionDate(null);
						}
					}
					if (allotmentNo != null && !allotmentNo.equals("")) {
						accomAllot.setAllotmentNo(allotmentNo);
					}
					accomAllot.setHoToDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.HO_TO_DATE)));
					accomAllot.setAllotType("a");

					accomAllot.setLastChgBy((String) changedBy.get(i));
					accomAllot.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomAllot.setLastChgTime((String) currentTime.get(i));

					accomAllot.setAllotmentDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.ALLOTMENT_DATE)));
					accomAllot.setAllotmentTime(allotmentTime);
					hbt.save(accomAllot);

					int smqId1 = Integer.parseInt(smqId.get(i).toString());

					MasSmq masSmq1 = (MasSmq) getHibernateTemplate().load(
							MasSmq.class, smqId1);
					masSmq1.setSmqStatus("o");
					hbt.update(masSmq1);

					int accomId1 = Integer.parseInt(accomId.get(i).toString());
					AccomRegistration accomReg = (AccomRegistration) getHibernateTemplate()
							.load(AccomRegistration.class, accomId1);
					accomReg.setRegStatus("o");
					map.put("allotmentNo", allotmentNo);
					hbt.saveOrUpdate(accomReg);

				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		map.put("poolList", poolList);

		return map;
	}

	/**
	 * ------------------------------------- method to search Occupy Vacant for
	 * Airmen(Ver 2.0) ------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		Session session = (Session) getSession();
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as mp where mp.Status='y' and mp.PoolCategory.Id='2'");

		if (poolList.size() > 0) {
			detailsMap.put("poolList", poolList);
		}
		smqList = session.createCriteria(MasSmq.class).add(
				Restrictions.eq("Status", "y")).createAlias("PoolCategory",
				"poolCat").add(Restrictions.eq("poolCat.Id", 2)).list();
		if (smqList.size() > 0) {
			detailsMap.put("smqList", smqList);
		}
		return detailsMap;
	}

	/**
	 * 
	 * -----------------------method to get current date records for smq
	 * vacation of airmen------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getCurrentGridForAirmen(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> allotmentList = new ArrayList<AccomAllotment>();
		Date currentDate = new Date();

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		try {
			crit = session.createCriteria(AccomAllotment.class).add(
					Restrictions.eq("AllotType", "a")).createAlias("Accom",
					"accomAllot").add(
					Restrictions.eq("accomAllot.RegStatus", "o")).add(
					Restrictions.eq("accomAllot.RegType", "a")).createAlias(
					"accomAllot.Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).add(
					Restrictions.eq("AllotmentDate", currentDate));
			allotmentList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("allotmentList", allotmentList);
		return map;
	}

	/**
	 * ----------------------------------method to get
	 * data---------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSMQAirmenGrid(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> smqVacationList = new ArrayList<AccomAllotment>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		int rankId = 0;
		int smqId = 0;
		String allotmentNo = "";
		String serPersonFName = "";

		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("rankId") != null) {
			rankId = Integer.parseInt("" + mapForDs.get("rankId"));
		}
		if (mapForDs.get("smqId") != null) {
			smqId = Integer.parseInt("" + mapForDs.get("smqId"));
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}

		if (mapForDs.get("allotmentNo") != null) {
			allotmentNo = (String) mapForDs.get("allotmentNo");
		}

		try {
			crit = session.createCriteria(AccomAllotment.class).add(
					Restrictions.eq("AllotType", "a")).add(
					Restrictions.between("AllotmentDate", fromDate, toDate))
					.createAlias("Accom", "accom").add(
							Restrictions.eq("accom.RegStatus", "o"))
					.createAlias("accom.Department", "dept").add(
							Restrictions.eq("dept.Id", deptId));
			if (!allotmentNo.equals("")) {
				crit = crit.add(Restrictions.like("AllotmentNo", allotmentNo
						+ "%"));
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("accom.ServiceNo", serviceNo
						+ "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("accom.ServicePersonName",
						serPersonFName + "%"));
			}
			if (smqId != 0) {
				crit = crit.createAlias("Smq", "smq").add(
						Restrictions.eq("smq.Id", smqId));
			}
			if (rankId != 0) {
				crit = crit.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}

			smqVacationList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("smqVacationList", smqVacationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSMQVacationDetails(Map dataMap) {
		List<AccomAllotment> smqVacationDetailList = new ArrayList<AccomAllotment>();
		Session session = (Session) getSession();
		int allotmentId = 0;
		if (dataMap.get("allotmentId") != null) {
			allotmentId = (Integer) dataMap.get("allotmentId");
		}
		smqVacationDetailList = session.createCriteria(AccomAllotment.class)
				.add(Restrictions.eq("AllotType", "a")).add(
						Restrictions.eq("Id", allotmentId)).list();
		if (smqVacationDetailList != null && smqVacationDetailList.size() > 0) {
			dataMap.put("smqVacationDetailList", smqVacationDetailList);
		}
		return dataMap;

	}

	/**
	 * -----------------------------------------method to generate Vacation No
	 * .----------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public String generateVacationNumber(Map<String, Object> diagMap) {
		List<TransactionSequence> vacationNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String vacationNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		vacationNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "VN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (vacationNoList.size() > 0) {
			for (TransactionSequence transactionSequence : vacationNoList) {
				TransactionSequence obj = (TransactionSequence) vacationNoList
						.get(0);
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				hbt.update(transactionSequenceObj);

				vacationNo = vacationNo.concat(String.valueOf(seqNo));
				vacationNo = vacationNo.concat("/").concat(currentYear);
			}
		} else if (vacationNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("SmqVacation");
			tsObj.setTransactionPrefix("VN");
			tsObj.setTransactionSequenceName("Vacation No.");
			tsObj.setTransactionSequenceNumber(0);

			hbt.save(tsObj);
		}
		return vacationNo;
	}

	@SuppressWarnings("unchecked")
	public String getVacationNumber(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<SmqVacation> seqNoList = new ArrayList<SmqVacation>();
		String vacationNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(SmqVacation.class).list();
			if (seqNoList.size() > 0) {
				for (SmqVacation smq : seqNoList) {
					lastSeqNo = smq.getVacationNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "VN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear) && maxOrderNo != null) {
						vacationNo = String.valueOf(maxOrderNo + 1);
					} else {
						vacationNo = String.valueOf(1);
					}
				}
			} else {
				vacationNo = String.valueOf(1);
			}

			vacationNo = vacationNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return vacationNo;
	}

	/**
	 * ---------------------------------- method to submit smq vacation for
	 * airmen ----------------------------------
	 */

	@SuppressWarnings("unchecked")
	public boolean submitSmqVacationForAirmen(Box box,
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		boolean successfullyAdded = false;

		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector vacationNo = box.getVector(RequestConstants.VACATION_NO);
			Vector vacationTime = box.getVector(RequestConstants.VACATION_TIME);
			Vector changeBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector changetime = box.getVector(RequestConstants.CHANGED_TIME);
			Vector regId = box.getVector(RequestConstants.REGISTRATION_ID);
			Vector validated = box.getVector(RequestConstants.VALIDATED);
			Vector smqId = box.getVector(RequestConstants.SMQ_ID);
			Vector deptId = box.getVector(RequestConstants.DEPARTMENT_ID);
			Vector hospitalId = box.getVector(RequestConstants.HOSPITAL_ID);
			for (int i = 0; i < validated.size(); i++) {
				if (validated.get(i) != null && !validated.get(i).equals("")) {
					SmqVacation smqVacation = new SmqVacation();
					smqVacation.setVacationNo((String) vacationNo.get(i));
					smqVacation.setVacationTime((String) vacationTime.get(i));
					smqVacation.setVacationType("a");
					smqVacation.setVacationDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.VACATION_DATE)));
					smqVacation.setLastChgBy((String) changeBy.get(i));
					smqVacation.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer
							.parseInt((String) deptId.get(i)));
					smqVacation.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(Integer.parseInt((String) hospitalId
							.get(i)));
					smqVacation.setHospital(masHospital);

					AccomRegistration accomReg = (AccomRegistration) hbt.load(
							AccomRegistration.class, Integer
									.parseInt((String) regId.get(i)));
					accomReg.setLastChgBy((String) changeBy.get(i));
					accomReg.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomReg.setAcceptedDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomReg.setLastChgTime((String) changetime.get(i));
					accomReg.setRegStatus("v");
					hbt.saveOrUpdate(accomReg);

					int smqId1 = Integer.parseInt(smqId.get(i).toString());

					MasSmq masSmq1 = (MasSmq) getHibernateTemplate().load(
							MasSmq.class, smqId1);
					masSmq1.setSmqStatus("m");
					hbt.update(masSmq1);

				}
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	/**
	 * -------------------------------- method to getList for registration for
	 * officers ------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> registraionForOfficer() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<PoolRank> poolRankList = new ArrayList<PoolRank>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		List<MasUnit> previousUnitList = new ArrayList<MasUnit>();

		serviceTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'");
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as isc where isc.RankCategory.Id in('1','7') and isc.ServiceStatus.Id='1' and isc.ServiceType.Id in('1','2','6')");
		tradeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasTrade as isc where isc.Status = 'y'");
		unitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as isc where isc.Status = 'y' and isc.DependentUnit = 'y'");
		previousUnitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnit as isc where isc.Status = 'y'");
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as mp where mp.Status='y' and mp.PoolCategory.Id='2'");
		poolRankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.PoolRank where Pool.PoolCategory.Id='2'");
		map.put("previousUnitList", previousUnitList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("rankList", rankList);
		map.put("tradeList", tradeList);
		map.put("unitList", unitList);
		map.put("poolRankList", poolRankList);
		map.put("poolList", poolList);

		return map;
	}

	/**
	 * ------------------------------------- get Pool code list for
	 * allotment-----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPoolListForAlltmentOfficer() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '1'");
		map.put("poolList", poolList);

		return map;
	}

	/**
	 * ------------------------------------- method to get records on basis of
	 * pool code in allotment For officers ---------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getRecordsForOfficerAllotment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomRegistration> officerRegList = new ArrayList<AccomRegistration>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		List<MasCarGarage> garageList = new ArrayList<MasCarGarage>();
		List<MasCarGarage> garageNoList = new ArrayList<MasCarGarage>();
		String queryString = null;
		String queryString1 = null;
		int poolId = box.getInt(RequestConstants.POOL_ID);
		queryString = "from AccomRegistration where  RegStatus='w'or RegStatus='c' and RegType='o' and Pool.Id="
				+ poolId;
		queryString1 = "from MasSmq where SmqStatus ='v'and Pool.Id=" + poolId;
		try {

			officerRegList = getHibernateTemplate().find(queryString);
			smqList = getHibernateTemplate().find(queryString1);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '1'");
		garageList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCarGarage");
		garageNoList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCarGarage ");

		map.put("officerRegList", officerRegList);
		map.put("smqList", smqList);
		map.put("poolList", poolList);
		map.put("garageList", garageList);
		map.put("garageNoList", garageNoList);
		return map;
	}

	/**
	 * ----------------------------method to submit allotment for officers
	 * ---------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitAllotmentForOfficer(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}

		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '1'");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector poolId = box.getVector(RequestConstants.POOL_NAME);
			Vector rankId = box.getVector(RequestConstants.RANK_ID);
			Vector smqId = box.getVector(RequestConstants.SMQ_NAME);
			Vector accomId = box.getVector(RequestConstants.ACCOM_ID);
			Vector allotmentType = box
					.getVector(RequestConstants.TYPE_OF_ALLOTMENT);
			String remarks = box.getString(RequestConstants.REMARKS);
			String allotmentNo = box.getString(RequestConstants.ALLOTMENT_NO);
			Vector changedBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector currentTime = box.getVector(RequestConstants.CHANGED_TIME);
			String allotmentTime = box
					.getString(RequestConstants.ALLOTMENT_TIME);
			Vector deptId = box.getVector(RequestConstants.DEPARTMENT_ID);
			Vector hospitalId = box.getVector(RequestConstants.HOSPITAL_ID);
			Vector garageId = box.getVector("garage");

			for (int i = 0; i < smqId.size(); i++) {

				AccomAllotment accomAllot = new AccomAllotment();
				if (smqId.get(i) != null && !smqId.get(i).equals("")) {

					if (rankId.get(i) != null && !rankId.get(i).equals("")) {
						MasRank masRank = new MasRank();
						masRank.setId(Integer.parseInt((String) rankId.get(i)));
						accomAllot.setRank(masRank);
					}
					MasPool masPool = new MasPool();
					masPool.setId(Integer.parseInt((String) poolId.get(i)));
					accomAllot.setPool(masPool);

					if (smqId.get(i) != null && !smqId.get(i).equals("")) {
						MasSmq masSmq = new MasSmq();
						masSmq.setId(Integer.parseInt((String) smqId.get(i)));
						accomAllot.setSmq(masSmq);
					}

					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer
							.parseInt((String) deptId.get(i)));
					accomAllot.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(Integer.parseInt((String) hospitalId
							.get(i)));
					accomAllot.setHospital(masHospital);

					if (accomId.get(i) != null && !accomId.get(i).equals("")) {
						AccomRegistration accomReg = new AccomRegistration();
						accomReg.setId(Integer
								.parseInt((String) accomId.get(i)));
						accomAllot.setAccom(accomReg);
					}
					if (garageId.get(i) != null && !garageId.get(i).equals("0")) {
						MasCarGarage masCarGarage = new MasCarGarage();
						masCarGarage.setId(Integer.parseInt((String) garageId
								.get(i)));
						accomAllot.setMasCarGarage(masCarGarage);
					}
					if (allotmentType.get(i) != null
							&& !allotmentType.equals("")) {
						accomAllot.setAllotmentType((String) allotmentType
								.get(i));
					}

					accomAllot.setRemarks(remarks);

					accomAllot.setHoToDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.HO_TO_DATE)));

					accomAllot.setAllotmentNo(allotmentNo);

					accomAllot.setAllotType("o");
					accomAllot.setLastChgBy((String) changedBy.get(i));
					accomAllot.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomAllot.setLastChgTime((String) currentTime.get(i));

					accomAllot.setAllotmentDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.ALLOTMENT_DATE)));
					accomAllot.setAllotmentTime(allotmentTime);
					map.put("allotmentNo", allotmentNo);
					hbt.save(accomAllot);

					int smqId1 = Integer.parseInt(smqId.get(i).toString());
					MasSmq masSmq1 = (MasSmq) getHibernateTemplate().load(
							MasSmq.class, smqId1);
					masSmq1.setSmqStatus("o");
					hbt.update(masSmq1);
					hbt.refresh(masSmq1);

					int accomId1 = Integer.parseInt(accomId.get(i).toString());
					AccomRegistration accomReg = (AccomRegistration) getHibernateTemplate()
							.load(AccomRegistration.class, accomId1);
					accomReg.setRegStatus("o");
					hbt.update(accomReg);

				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		map.put("poolList", poolList);
		return map;
	}

	/**
	 * ----------------------------------method to get data for smq vacation for
	 * officers---------------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSMQOfficerGrid(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> smqVacationList = new ArrayList<AccomAllotment>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		int rankId = 0;
		int smqId = 0;
		String allotmentNo = "";
		String serPersonFName = "";

		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}

		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("rankId") != null) {
			rankId = Integer.parseInt("" + mapForDs.get("rankId"));
		}
		if (mapForDs.get("smqId") != null) {
			smqId = Integer.parseInt("" + mapForDs.get("smqId"));
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}

		if (mapForDs.get("allotmentNo") != null) {
			allotmentNo = (String) mapForDs.get("allotmentNo");
		}

		try {
			crit = session.createCriteria(AccomAllotment.class).add(
					Restrictions.eq("AllotType", "o")).add(
					Restrictions.between("AllotmentDate", fromDate, toDate))
					.createAlias("Accom", "accom").add(
							Restrictions.eq("accom.RegStatus", "o")).add(
							Restrictions.eq("Department.Id", deptId));

			if (!allotmentNo.equals("")) {
				crit = crit.add(Restrictions.like("AllotmentNo", allotmentNo
						+ "%"));
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("accom.ServiceNo", serviceNo
						+ "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("accom.ServicePersonName",
						serPersonFName + "%"));
			}
			if (smqId != 0) {
				crit = crit.createAlias("Smq", "smq").add(
						Restrictions.eq("smq.Id", smqId));
			}
			if (rankId != 0) {
				crit = crit.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}

			smqVacationList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("smqVacationList", smqVacationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSMQVacationDetailsForOfficer(Map dataMap) {
		List<AccomAllotment> smqVacationDetailList = new ArrayList<AccomAllotment>();
		Session session = (Session) getSession();
		int allotmentId = 0;
		if (dataMap.get("allotmentId") != null) {
			allotmentId = (Integer) dataMap.get("allotmentId");
		}
		smqVacationDetailList = session.createCriteria(AccomAllotment.class)
				.add(Restrictions.eq("AllotType", "o")).add(
						Restrictions.eq("Id", allotmentId)).list();
		if (smqVacationDetailList != null && smqVacationDetailList.size() > 0) {
			dataMap.put("smqVacationDetailList", smqVacationDetailList);
		}
		return dataMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCurrentGridForOfficer(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> allotmentList = new ArrayList<AccomAllotment>();
		Date currentDate = new Date();

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		try {
			crit = session.createCriteria(AccomAllotment.class).add(
					Restrictions.eq("AllotType", "o")).createAlias("Accom",
					"accomAllot").add(
					Restrictions.eq("accomAllot.RegStatus", "o")).add(
					Restrictions.eq("accomAllot.RegType", "o")).createAlias(
					"accomAllot.Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).add(
					Restrictions.eq("AllotmentDate", currentDate));
			allotmentList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("allotmentList", allotmentList);
		return map;
	}

	/**
	 * ----------------------method to get data in relegation process for
	 * search-----------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearchForRelegation(
			Map<String, Object> dataMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		Session session = (Session) getSession();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).createAlias("ServiceStatus",
				"ServiceStatus").add(Restrictions.eq("ServiceStatus.Id", 1))
				.list();
		if (rankList.size() > 0) {
			detailsMap.put("rankList", rankList);
		}
		serviceTypeList = session.createCriteria(MasServiceType.class).add(
				Restrictions.eq("Status", "y")).list();
		if (serviceTypeList.size() > 0) {
			detailsMap.put("serviceTypeList", serviceTypeList);
		}
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '1'");
		if (poolList.size() > 0) {
			detailsMap.put("poolList", poolList);
		}
		return detailsMap;
	}

	/**
	 * -----------------------------get current record for grid of relegation
	 * process-----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getCurrentGridForRelegationProcess(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomRegistration> searchRelegationList = new ArrayList<AccomRegistration>();
		Date currentDate = new Date();

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		try {
			crit = session.createCriteria(AccomRegistration.class).add(
					Restrictions.eq("RegType", "o")).add(
					Restrictions.eq("RegStatus", "w")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).add(
					Restrictions.eq("RegistrationDate", currentDate));
			searchRelegationList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchRelegationList", searchRelegationList);
		return map;
	}

	/**
	 * -------------------------------method to data of grid for relegation
	 * process----------------------------
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getRelegationProcessGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomRegistration> searchRelegationList = new ArrayList<AccomRegistration>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		int rankId = 0;
		int poolId = 0;
		int serviceTypeId = 0;
		String registrationNo = "";
		String serPersonFName = "";

		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}

		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("rankId") != null) {
			rankId = Integer.parseInt("" + mapForDs.get("rankId"));
		}
		if (mapForDs.get("poolId") != null) {
			poolId = Integer.parseInt("" + mapForDs.get("poolId"));
		}
		if (mapForDs.get("serviceTypeId") != null) {
			serviceTypeId = Integer
					.parseInt("" + mapForDs.get("serviceTypeId"));
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}

		if (mapForDs.get("registrationNo") != null) {
			registrationNo = (String) mapForDs.get("registrationNo");
		}

		try {
			crit = session.createCriteria(AccomRegistration.class).add(
					Restrictions.eq("RegType", "o")).add(
					Restrictions.eq("RegStatus", "w")).add(
					Restrictions.between("RegistrationDate", fromDate, toDate))
					.createAlias("Department", "dept").add(
							Restrictions.eq("dept.Id", deptId));

			if (!registrationNo.equals("")) {
				crit = crit.add(Restrictions.like("RegistrationNo",
						registrationNo + "%"));
			}
			if (!serviceNo.equals("")) {
				crit = crit
						.add(Restrictions.like("ServiceNo", serviceNo + "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("ServicePersonName",
						serPersonFName + "%"));
			}
			if (poolId != 0) {
				crit = crit.add(Restrictions.eq("Pool.Id", poolId));
			}
			if (rankId != 0) {
				crit = crit.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}
			if (serviceTypeId != 0) {
				crit = crit.createAlias("ServiceType", "serviceType").add(
						Restrictions.eq("serviceType.Id", serviceTypeId));
			}
			searchRelegationList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchRelegationList", searchRelegationList);
		return map;
	}

	/**
	 * -------------------------------method to get details for relegation
	 * process--------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getRelegationDetail(Map dataMap) {
		List<AccomRegistration> relegationDetailList = new ArrayList<AccomRegistration>();
		Session session = (Session) getSession();
		int vacationId = 0;
		if (dataMap.get("vacationId") != null) {
			vacationId = (Integer) dataMap.get("vacationId");
		}
		//System.out.println("vacationId  " + vacationId);
		relegationDetailList = session.createCriteria(AccomRegistration.class)
				.add(Restrictions.eq("RegType", "o")).add(
						Restrictions.eq("RegStatus", "w")).add(
						Restrictions.eq("Id", vacationId)).list();
		//System.out.println("relegationDetailList : "+ relegationDetailList.size());
		if (relegationDetailList != null && relegationDetailList.size() > 0) {
			dataMap.put("relegationDetailList", relegationDetailList);
		}
		// //System.out.println("relegationDetailList.size() " +
		// relegationDetailList.size());

		return dataMap;

	}

	/**
	 * --------------------------------- method to generate Relegation
	 * Number----------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public String generateRelegationNumber(Map<String, Object> diagMap) {
		List<TransactionSequence> relegationNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String relegationNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		relegationNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "RN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (relegationNoList.size() > 0) {
			for (TransactionSequence transactionSequence : relegationNoList) {
				TransactionSequence obj = (TransactionSequence) relegationNoList
						.get(0);
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				hbt.update(transactionSequenceObj);

				relegationNo = relegationNo.concat(String.valueOf(seqNo));
				relegationNo = relegationNo.concat("/").concat(currentYear);
			}
		} else if (relegationNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("RelegationProcess");
			tsObj.setTransactionPrefix("RN");
			tsObj.setTransactionSequenceName("Relegation No.");
			tsObj.setTransactionSequenceNumber(0);

			hbt.save(tsObj);
		}
		return relegationNo;
	}

	@SuppressWarnings("unchecked")
	public String getRelegationNumber(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<RelegationProcess> seqNoList = new ArrayList<RelegationProcess>();
		String relegationNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(RelegationProcess.class).list();
			if (seqNoList.size() > 0) {
				for (RelegationProcess rel : seqNoList) {
					lastSeqNo = rel.getRelegationNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "RN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear) && maxOrderNo != null) {
						relegationNo = String.valueOf(maxOrderNo + 1);
					} else {
						relegationNo = String.valueOf(1);
					}
				}
			} else {
				relegationNo = String.valueOf(1);
			}

			relegationNo = relegationNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return relegationNo;
	}

	/**
	 * -------------------------method to submit relegation
	 * process---------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitRelegationDetails(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// Vector vacationId = box.getVector(RequestConstants.VACATION_ID);
			Vector relegationDate = box
					.getVector(RequestConstants.RELEAGTION_DATE);
			Vector relegationNo = box.getVector(RequestConstants.RELEAGTION_NO);
			Vector relegationTime = box
					.getVector(RequestConstants.RELEAGTION_TIME);
			Vector relegationType = box
					.getVector(RequestConstants.RELEAGTION_TYPE);
			Vector relegationFrom = box
					.getVector(RequestConstants.RELEAGTION_FROM);
			Vector relegationTo = box.getVector(RequestConstants.RELEAGTION_TO);
			Vector relegationCompleted = box
					.getVector(RequestConstants.RELEAGTION_COMPLETED);
			Vector remarks = box.getVector(RequestConstants.REMARKS);
			Vector changedBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector currentTime = box.getVector(RequestConstants.CHANGED_TIME);
			Vector deptId = box.getVector(RequestConstants.DEPARTMENT_ID);
			Vector hospitalId = box.getVector(RequestConstants.HOSPITAL_ID);

			for (int i = 0; i < relegationCompleted.size(); i++) {
				RelegationProcess relegationProcess = new RelegationProcess();
				if (relegationCompleted.get(i) != null
						&& !relegationCompleted.get(i).equals("")) {
					// SmqVacation smqVacation = new SmqVacation();
					// smqVacation.setId(Integer.parseInt((String)
					// vacationId.get(i)));
					// relegationProcess.setVacation(smqVacation);

					if (relegationNo != null && !relegationNo.equals("")) {
						relegationProcess.setRelegationNo((String) relegationNo
								.get(i));
					}
					if (relegationType != null && !relegationType.equals("")) {
						relegationProcess
								.setRelegationType((String) relegationType
										.get(i));
					}
					if (relegationTime != null && !relegationTime.equals("")) {
						relegationProcess
								.setRelegationTime((String) relegationTime
										.get(i));
					}
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer
							.parseInt((String) deptId.get(i)));
					relegationProcess.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(Integer.parseInt((String) hospitalId
							.get(i)));
					relegationProcess.setHospital(masHospital);

					if (relegationFrom.get(i) != null
							&& !relegationFrom.equals("")) {
						relegationProcess
								.setRelegationFrom(HMSUtil
										.convertStringTypeDateToDateType(box
												.get(RequestConstants.RELEAGTION_FROM)));
					}
					if (relegationDate.get(i) != null
							&& !relegationDate.equals("")) {
						relegationProcess
								.setRelegationDate(HMSUtil
										.convertStringTypeDateToDateType(box
												.get(RequestConstants.RELEAGTION_DATE)));
					}
					if (relegationTo.get(i) != null && !relegationTo.equals("")) {
						relegationProcess.setRelegationTo(HMSUtil
								.convertStringTypeDateToDateType(box
										.get(RequestConstants.RELEAGTION_TO)));
					}
					if (remarks != null && !remarks.equals("")) {
						relegationProcess.setRemarks((String) remarks.get(i));
					}
					if (relegationCompleted != null
							&& !relegationCompleted.equals("")) {
						relegationProcess.setRelegationCompleted("y");

					}

					relegationProcess.setLastChgBy((String) changedBy.get(i));
					relegationProcess.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					relegationProcess.setLastChgTime((String) currentTime
							.get(i));
					hbt.save(relegationProcess);
				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	/**
	 * -----------------------------------------method to get pool list in NOC
	 * -------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getRecordsForNOC(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomRegistration> officerRegList = new ArrayList<AccomRegistration>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		String queryString = null;
		String queryString1 = null;
		int poolId = box.getInt(RequestConstants.POOL_ID);
		queryString = "from AccomRegistration where  RegStatus='n' and RegType='o' and Pool.Id="
				+ poolId;
		queryString1 = "from MasSmq where SmqStatus ='v'and Pool.Id=" + poolId;
		try {

			officerRegList = getHibernateTemplate().find(queryString);
			smqList = getHibernateTemplate().find(queryString1);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '1'");

		map.put("officerRegList", officerRegList);
		map.put("smqList", smqList);
		map.put("poolList", poolList);
		return map;
	}

	/**
	 * ------------------------------------- method to submit NOC and update
	 * records on registration table --------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitNOC(Box box, Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}

		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '1'");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// Vector poolId = box.getVector(RequestConstants.POOL_NAME);
			Vector regId = box.getVector(RequestConstants.REGISTRATION_ID);
			Vector validated = box.getVector(RequestConstants.VALIDATED);
			String remarks = box.getString(RequestConstants.REMARKS);

			for (int i = 0; i < validated.size(); i++) {
				if (validated.get(i) != null && !validated.get(i).equals("")) {

					AccomRegistration accomRegistration = (AccomRegistration) hbt
							.load(AccomRegistration.class, Integer
									.parseInt((String) regId.get(i)));

					accomRegistration.setRegStatus("w");
					accomRegistration.setAcceptedDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.ACCEPTED_DATE)));
					accomRegistration.setRemarks(remarks);
					hbt.saveOrUpdate(accomRegistration);
				}

			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		map.put("poolList", poolList);
		return map;
	}

	/**
	 * ----------------------- method to show cancel allotment for
	 * airmen--------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSearchForCancelAirmen(
			Map<String, Object> dataMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		Session session = (Session) getSession();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).createAlias("ServiceStatus",
				"ServiceStatus").add(Restrictions.eq("ServiceStatus.Id", 1))
				.list();
		if (rankList.size() > 0) {
			detailsMap.put("rankList", rankList);
		}
		serviceTypeList = session.createCriteria(MasServiceType.class).add(
				Restrictions.eq("Status", "y")).list();
		if (serviceTypeList.size() > 0) {
			detailsMap.put("serviceTypeList", serviceTypeList);
		}
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as mp where mp.Status='y' and mp.PoolCategory.Id='2'");
		if (poolList.size() > 0) {
			detailsMap.put("poolList", poolList);
		}
		smqList = session.createCriteria(MasSmq.class).add(
				Restrictions.eq("Status", "y")).createAlias("PoolCategory",
				"poolCat").add(Restrictions.eq("poolCat.Id", 2)).list();
		if (smqList.size() > 0) {
			detailsMap.put("smqList", smqList);
		}
		return detailsMap;
	}

	/**
	 * ------------------------------ method to get grid for cancellation of
	 * allotment -------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCurrentGridForCancelAllotment(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> searchAllotmentList = new ArrayList<AccomAllotment>();
		Date currentDate = new Date();

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		try {
			crit = session.createCriteria(AccomAllotment.class).add(
					Restrictions.eq("AllotType", "a")).createAlias("Accom",
					"accom").add(Restrictions.eq("accom.RegStatus", "o"))
					.createAlias("Department", "dept").add(
							Restrictions.eq("dept.Id", deptId)).add(
							Restrictions.eq("HoToDate", currentDate));
			searchAllotmentList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchAllotmentList", searchAllotmentList);
		return map;
	}

	/**
	 * -----------------------method to get grid for cancellation of allotmnet
	 * of airmen-------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCancelGrid(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> searchAllotmentList = new ArrayList<AccomAllotment>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		int rankId = 0;
		int poolId = 0;
		int serviceTypeId = 0;
		String allotmentNo = "";
		int smqId = 0;

		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("rankId") != null) {
			rankId = Integer.parseInt("" + mapForDs.get("rankId"));
		}
		if (mapForDs.get("poolId") != null) {
			poolId = Integer.parseInt("" + mapForDs.get("poolId"));
		}
		if (mapForDs.get("serviceTypeId") != null) {
			serviceTypeId = Integer
					.parseInt("" + mapForDs.get("serviceTypeId"));
		}

		if (mapForDs.get("allotmentNo") != null) {
			allotmentNo = (String) mapForDs.get("allotmentNo");
		}
		if (mapForDs.get("smqId") != null) {
			smqId = Integer.parseInt("" + mapForDs.get("smqId"));
		}

		try {
			crit = session.createCriteria(AccomAllotment.class).add(
					Restrictions.eq("AllotType", "a")).createAlias("Accom",
					"accom").add(Restrictions.eq("accom.RegStatus", "o")).add(
					Restrictions.between("HoToDate", fromDate, toDate))
					.createAlias("Department", "dept").add(
							Restrictions.eq("dept.Id", deptId));
			if (!allotmentNo.equals("")) {
				crit = crit.add(Restrictions.like("AllotmentNo", allotmentNo
						+ "%"));
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("accom.ServiceNo", serviceNo
						+ "%"));
			}

			if (poolId != 0) {
				crit = crit.add(Restrictions.eq("Pool.Id", poolId));
			}
			if (smqId != 0) {
				crit = crit.add(Restrictions.eq("Smq.Id", smqId));
			}
			if (rankId != 0) {
				crit = crit.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}
			if (serviceTypeId != 0) {
				crit = crit.createAlias("accom.ServiceType", "serviceType")
						.add(Restrictions.eq("serviceType.Id", serviceTypeId));
			}
			searchAllotmentList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchAllotmentList", searchAllotmentList);
		return map;
	}

	/**
	 * ---------------------------- method to get allotment records for
	 * cancellation for airmen
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCancellationDetail(Map<String, Object> dataMap) {
		List<AccomAllotment> cancelDetailList = new ArrayList<AccomAllotment>();
		Session session = (Session) getSession();
		int allotmentId = 0;
		if (dataMap.get("allotmentId") != null) {
			allotmentId = (Integer) dataMap.get("allotmentId");
		}
		cancelDetailList = session.createCriteria(AccomAllotment.class).add(
				Restrictions.eq("AllotType", "a")).add(
				Restrictions.eq("Id", allotmentId)).list();
		if (cancelDetailList != null && cancelDetailList.size() > 0) {
			dataMap.put("cancelDetailList", cancelDetailList);
		}

		return dataMap;

	}

	/**
	 * ---------------------------- method to generate Cancellation
	 * no-----------------------
	 */

	@SuppressWarnings("unchecked")
	public String generateCancellationNumber(Map<String, Object> diagMap) {
		List<TransactionSequence> cancelNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String cancelNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		cancelNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "CN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (cancelNoList.size() > 0) {
			for (TransactionSequence transactionSequence : cancelNoList) {
				TransactionSequence obj = (TransactionSequence) cancelNoList
						.get(0);
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				hbt.update(transactionSequenceObj);

				cancelNo = cancelNo.concat(String.valueOf(seqNo));
				cancelNo = cancelNo.concat("/").concat(currentYear);
			}
		} else if (cancelNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("AccomRegistration");
			tsObj.setTransactionPrefix("CN");
			tsObj.setTransactionSequenceName("Cancel No.");
			tsObj.setTransactionSequenceNumber(0);

			hbt.save(tsObj);
		}
		return cancelNo;
	}

	@SuppressWarnings("unchecked")
	public String getCancellationNumber(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<AccomRegistration> seqNoList = new ArrayList<AccomRegistration>();
		String cancelNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(AccomRegistration.class).list();
			if (seqNoList.size() > 0) {
				for (AccomRegistration accom : seqNoList) {
					lastSeqNo = accom.getCancelNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "CN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear) && maxOrderNo != null) {
						cancelNo = String.valueOf(maxOrderNo + 1);
					} else {
						cancelNo = String.valueOf(1);
					}
				}
			} else {
				cancelNo = String.valueOf(1);
			}

			cancelNo = cancelNo.concat("/").concat(String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return cancelNo;
	}

	/**
	 * -------------------------- method for cancellation the allotment of
	 * airmen-------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean submitCancellationForAirmen(Box box,
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		boolean successfullyAdded = false;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector cancelNo = box.getVector(RequestConstants.CANCEL_NO);
			Vector smqId = box.getVector(RequestConstants.SMQ_ID);
			Vector regId = box.getVector(RequestConstants.REGISTRATION_ID);
			Vector validated = box.getVector(RequestConstants.VALIDATED);
			Vector changedBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector currentTime = box.getVector(RequestConstants.CHANGED_TIME);

			for (int i = 0; i < validated.size(); i++) {
				if (validated.get(i) != null && !validated.get(i).equals("")) {
					AccomRegistration accomReg = (AccomRegistration) hbt.load(
							AccomRegistration.class, Integer
									.parseInt((String) regId.get(i)));

					accomReg.setRegStatus("c");
					accomReg.setCancelNo((String) cancelNo.get(i));
					accomReg.setCancelDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CANCEL_DATE)));
					accomReg.setLastChgBy((String) changedBy.get(i));
					accomReg.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomReg.setLastChgTime((String) currentTime.get(i));
					dataMap.put("cancelNo", (String) cancelNo.get(i));
					hbt.saveOrUpdate(accomReg);

					int smqId1 = Integer.parseInt(smqId.get(i).toString());

					MasSmq masSmq1 = (MasSmq) getHibernateTemplate().load(
							MasSmq.class, smqId1);
					masSmq1.setSmqStatus("v");
					hbt.update(masSmq1);

				}
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	/**
	 * ------------------------------- method to get records for smq vacation on
	 * basis of pool id -----------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getRecordsForSmqVacation(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> smqVacList = new ArrayList<AccomAllotment>();
		List<MasPool> poolList = new ArrayList<MasPool>();

		String queryString = null;

		int poolId = box.getInt(RequestConstants.POOL_ID);
		queryString = "from AccomAllotment where Accom.RegType='a' and Smq.SmqStatus='o' and Accom.RegStatus='o' and Accom.Pool.Id="
				+ poolId;
		try {

			smqVacList = getHibernateTemplate().find(queryString);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '2'");
		map.put("smqVacList", smqVacList);
		map.put("poolList", poolList);
		return map;
	}

	/**
	 * ---------------------- method to update status in registration for smq
	 * Vacation of airmen(Ver2.0)
	 */

	@SuppressWarnings("unchecked")
	public boolean updateSmqVacation(Box box, Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		boolean successfullyAdded = false;

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector vacationNo = box.getVector(RequestConstants.VACATION_NO);
			Vector vacationTime = box.getVector(RequestConstants.VACATION_TIME);
			Vector changeBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector changetime = box.getVector(RequestConstants.CHANGED_TIME);
			Vector regId = box.getVector(RequestConstants.REGISTRATION_ID);
			Vector validated = box.getVector(RequestConstants.VALIDATED);
			Vector deptId = box.getVector(RequestConstants.DEPARTMENT_ID);
			Vector hospitalId = box.getVector(RequestConstants.HOSPITAL_ID);
			Vector allotmentId = box.getVector(RequestConstants.ALLOTMENT_ID);
			Vector smqId = box.getVector(RequestConstants.SMQ_ID);

			for (int i = 0; i < validated.size(); i++) {
				// / if (validated.get(i) != null &&
				// !validated.get(i).equals(""))
				// {
				SmqVacation smqVacation = new SmqVacation();
				AccomRegistration accomReg = (AccomRegistration) hbt.load(
						AccomRegistration.class, Integer
								.parseInt((String) regId.get(i)));
				smqVacation.setVacationNo((String) vacationNo.get(i));
				smqVacation.setVacationTime((String) vacationTime.get(i));
				smqVacation.setVacationType("a");
				smqVacation.setMaintenance("m");
				smqVacation.setVacationDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.get(RequestConstants.VACATION_DATE)));
				smqVacation.setLastChgBy((String) changeBy.get(i));
				smqVacation.setLastChgTime((String) changetime.get(i));
				smqVacation.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.get(RequestConstants.CHANGED_DATE)));
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(Integer.parseInt((String) deptId.get(i)));
				smqVacation.setDepartment(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(Integer.parseInt((String) hospitalId.get(i)));
				smqVacation.setHospital(masHospital);
				int allotId = Integer.parseInt((String) allotmentId.get(i));
				if (allotId != '0') {
					AccomAllotment accom = new AccomAllotment();
					accom.setId(allotId);
					smqVacation.setAllotment(accom);
				}
				dataMap.put("vacationNo", vacationNo.get(i));

				hbt.save(smqVacation);

				accomReg.setRegStatus("v");
				accomReg.setLastChgBy((String) changeBy.get(i));
				accomReg.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.get(RequestConstants.CHANGED_DATE)));
				accomReg.setLastChgTime((String) changetime.get(i));
				hbt.saveOrUpdate(accomReg);

				int smqId1 = Integer.parseInt(smqId.get(i).toString());
				MasSmq masSmq1 = (MasSmq) getHibernateTemplate().load(
						MasSmq.class, smqId1);
				masSmq1.setSmqStatus("m");
				hbt.update(masSmq1);
			}
			// }

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	/**
	 * ---- method to update smq vacation for officer
	 */

	@SuppressWarnings("unchecked")
	public boolean updateSmqVacationOfficer(Box box, Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		boolean successfullyAdded = false;

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector vacationNo = box.getVector(RequestConstants.VACATION_NO);
			Vector vacationTime = box.getVector(RequestConstants.VACATION_TIME);
			Vector changeBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector changetime = box.getVector(RequestConstants.CHANGED_TIME);
			Vector regId = box.getVector(RequestConstants.REGISTRATION_ID);
			Vector validated = box.getVector(RequestConstants.VALIDATED);
			Vector deptId = box.getVector(RequestConstants.DEPARTMENT_ID);
			Vector hospitalId = box.getVector(RequestConstants.HOSPITAL_ID);
			Vector allotmentId = box.getVector(RequestConstants.ALLOTMENT_ID);
			Vector smqId = box.getVector(RequestConstants.SMQ_ID);

			for (int i = 0; i < validated.size(); i++) {
				if (validated.get(i) != null && !validated.get(i).equals("")) {
					SmqVacation smqVacation = new SmqVacation();
					smqVacation.setVacationNo((String) vacationNo.get(i));
					smqVacation.setVacationTime((String) vacationTime.get(i));
					smqVacation.setVacationType("o");
					smqVacation.setVacationDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.VACATION_DATE)));
					smqVacation.setLastChgBy((String) changeBy.get(i));
					smqVacation.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					smqVacation.setLastChgTime((String) changetime.get(i));
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer
							.parseInt((String) deptId.get(i)));
					smqVacation.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(Integer.parseInt((String) hospitalId
							.get(i)));
					smqVacation.setHospital(masHospital);
					int allotId = Integer.parseInt((String) allotmentId.get(i));
					if (allotId != '0') {
						AccomAllotment accom = new AccomAllotment();
						accom.setId(allotId);
						smqVacation.setAllotment(accom);
					}
					hbt.save(smqVacation);

					AccomRegistration accomReg = (AccomRegistration) hbt.load(
							AccomRegistration.class, Integer
									.parseInt((String) regId.get(i)));

					accomReg.setRegStatus("v");
					accomReg.setLastChgBy((String) changeBy.get(i));
					accomReg.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomReg.setLastChgTime((String) changetime.get(i));
					hbt.saveOrUpdate(accomReg);

					int smqId1 = Integer.parseInt(smqId.get(i).toString());

					MasSmq masSmq1 = (MasSmq) getHibernateTemplate().load(
							MasSmq.class, smqId1);
					masSmq1.setSmqStatus("m");
					hbt.update(masSmq1);
				}
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	/**
	 * ---------------------- method to get smq list for vacat allot for airmen
	 * -------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSmqListForAlltment() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		smqList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSmq as g where g.Pool.PoolCategory.Id = '2'");
		map.put("smqList", smqList);

		return map;
	}

	/**
	 * --------------- method to get records on absis of SMq in allot vacat for
	 * airmen(ver 2.0)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getRecordsForAllotVacat(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> smqVacList = new ArrayList<AccomAllotment>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		List<MasPool> poolList = new ArrayList<MasPool>();

		String queryString = null;

		int smqId = box.getInt(RequestConstants.SMQ_ID);
		queryString = "from AccomAllotment where Accom.RegType='a' and Accom.RegStatus='o' and Smq.Id="
				+ smqId;
		try {

			smqVacList = getHibernateTemplate().find(queryString);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		smqList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSmq as g where g.Pool.PoolCategory.Id = '2'");
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '2'");
		map.put("smqVacList", smqVacList);
		map.put("smqList", smqList);
		map.put("poolList", poolList);
		return map;
	}

	/**
	 * ----------------------- method to get poolList For
	 * Aitrmen-----------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPoolList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '2'");
		map.put("poolList", poolList);

		return map;
	}

	/**
	 * ------------------- methods for cancellation of allotment for
	 * officer-----------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSearchForCancelOfficer(
			Map<String, Object> dataMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		Session session = (Session) getSession();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).createAlias("ServiceStatus",
				"ServiceStatus").add(Restrictions.eq("ServiceStatus.Id", 1))
				.list();
		if (rankList.size() > 0) {
			detailsMap.put("rankList", rankList);
		}
		serviceTypeList = session.createCriteria(MasServiceType.class).add(
				Restrictions.eq("Status", "y")).list();
		if (serviceTypeList.size() > 0) {
			detailsMap.put("serviceTypeList", serviceTypeList);
		}
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as mp where mp.Status='y' and mp.PoolCategory.Id='1'");
		if (poolList.size() > 0) {
			detailsMap.put("poolList", poolList);
		}
		smqList = session.createCriteria(MasSmq.class).add(
				Restrictions.eq("Status", "y")).createAlias("PoolCategory",
				"poolCat").add(Restrictions.eq("poolCat.Id", 1)).list();
		if (smqList.size() > 0) {
			detailsMap.put("smqList", smqList);
		}
		return detailsMap;
	}

	/**
	 * ------------------------------ method to get grid for cancellation of
	 * allotment For oFficer-------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCurrentGridForCancelAllotmentForOfficer(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> searchAllotmentList = new ArrayList<AccomAllotment>();
		Date currentDate = new Date();

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		try {
			crit = session.createCriteria(AccomAllotment.class).add(
					Restrictions.eq("AllotType", "o")).createAlias("Accom",
					"accom").add(Restrictions.eq("accom.RegStatus", "o"))
					.createAlias("Department", "dept").add(
							Restrictions.eq("dept.Id", deptId)).add(
							Restrictions.eq("HoToDate", currentDate));
			searchAllotmentList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchAllotmentList", searchAllotmentList);
		return map;
	}

	/**
	 * ------------------ method to show cancel form for officer
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCancellationDetailForOfficer(
			Map<String, Object> dataMap) {
		List<AccomAllotment> cancelDetailList = new ArrayList<AccomAllotment>();
		Session session = (Session) getSession();
		int allotmentId = 0;
		if (dataMap.get("allotmentId") != null) {
			allotmentId = (Integer) dataMap.get("allotmentId");
		}
		cancelDetailList = session.createCriteria(AccomAllotment.class).add(
				Restrictions.eq("AllotType", "o")).add(
				Restrictions.eq("Id", allotmentId)).list();
		if (cancelDetailList != null && cancelDetailList.size() > 0) {
			dataMap.put("cancelDetailList", cancelDetailList);
		}

		return dataMap;

	}

	/**
	 * -------------------------- method for cancellation the allotment of
	 * airmen-------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean submitCancellationForOfficer(Box box,
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		boolean successfullyAdded = false;

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector cancelNo = box.getVector(RequestConstants.CANCEL_NO);
			Vector regId = box.getVector(RequestConstants.REGISTRATION_ID);
			Vector validated = box.getVector(RequestConstants.VALIDATED);
			Vector changedBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector currentTime = box.getVector(RequestConstants.CHANGED_TIME);
			Vector smqId = box.getVector(RequestConstants.SMQ_ID);

			for (int i = 0; i < validated.size(); i++) {
				if (validated.get(i) != null && !validated.get(i).equals("")) {
					AccomRegistration accomReg = (AccomRegistration) hbt.load(
							AccomRegistration.class, Integer
									.parseInt((String) regId.get(i)));
					accomReg.setRegStatus("c");
					accomReg.setCancelNo((String) cancelNo.get(i));
					accomReg.setCancelDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CANCEL_DATE)));
					accomReg.setLastChgBy((String) changedBy.get(i));
					accomReg.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomReg.setLastChgTime((String) currentTime.get(i));
					dataMap.put("cancelNo", cancelNo.get(i));
					hbt.saveOrUpdate(accomReg);

					int smqId1 = Integer.parseInt(smqId.get(i).toString());

					MasSmq masSmq1 = (MasSmq) getHibernateTemplate().load(
							MasSmq.class, smqId1);
					masSmq1.setSmqStatus("v");
					hbt.update(masSmq1);
				}
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	/**
	 * ------------------------------- method to get records for smq vacation on
	 * basis of pool id -----------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getRecordsForSmqVacationOfficer(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> smqVacList = new ArrayList<AccomAllotment>();
		List<MasPool> poolList = new ArrayList<MasPool>();

		String queryString = null;

		int poolId = box.getInt(RequestConstants.POOL_ID);
		queryString = "from AccomAllotment where Accom.RegType='o' and Smq.SmqStatus='o' and Accom.RegStatus='o' and Accom.Pool.Id="
				+ poolId;
		try {

			smqVacList = getHibernateTemplate().find(queryString);
			//System.out.println("smqVacList :  " + smqVacList.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '1'");
		map.put("smqVacList", smqVacList);
		map.put("poolList", poolList);
		return map;
	}

	/**
	 * ---------------------- method to get smq list for vacat allot for airmen
	 * -------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSmqListForOfficerAlltment() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		smqList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSmq as g where g.Pool.PoolCategory.Id = '1'");
		map.put("smqList", smqList);

		return map;
	}

	/**
	 * --------------- method to get records on absis of SMq in allot vacat for
	 * airmen(ver 2.0)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getRecordsForAllotVacatOfficer(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> smqVacList = new ArrayList<AccomAllotment>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		List<MasPool> poolList = new ArrayList<MasPool>();

		String queryString = null;

		int smqId = box.getInt(RequestConstants.SMQ_ID);
		queryString = "from AccomAllotment where Accom.RegType='o' and Accom.RegStatus='o' and Smq.Id="
				+ smqId;
		try {

			smqVacList = getHibernateTemplate().find(queryString);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		smqList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSmq as g where g.Pool.PoolCategory.Id = '1' ");
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '1'");
		map.put("smqVacList", smqVacList);
		map.put("smqList", smqList);
		map.put("poolList", poolList);
		return map;
	}

	/**
	 * ------------------------------------- method to search Occupy Vacant for
	 * officer(Ver 2.0) ------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearchForOff(
			Map<String, Object> dataMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		Session session = (Session) getSession();
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as mp where mp.Status='y' and mp.PoolCategory.Id='1'");

		if (poolList.size() > 0) {
			detailsMap.put("poolList", poolList);
		}
		smqList = session.createCriteria(MasSmq.class).add(
				Restrictions.eq("Status", "y")).createAlias("PoolCategory",
				"poolCat").add(Restrictions.eq("poolCat.Id", 1)).list();
		if (smqList.size() > 0) {
			detailsMap.put("smqList", smqList);
		}
		return detailsMap;
	}

	/**
	 * ------------------------------------- method to search Occupy Vacant for
	 * airmen(Ver 2.0) ------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearchForAirmen(
			Map<String, Object> dataMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		Session session = (Session) getSession();
		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as mp where mp.Status='y' and mp.PoolCategory.Id='2'");

		if (poolList.size() > 0) {
			detailsMap.put("poolList", poolList);
		}
		smqList = session.createCriteria(MasSmq.class).add(
				Restrictions.eq("Status", "y")).createAlias("PoolCategory",
				"poolCat").add(Restrictions.eq("poolCat.Id", 2)).list();
		if (smqList.size() > 0) {
			detailsMap.put("smqList", smqList);
		}
		return detailsMap;
	}

	/**
	 * -------------------------------method to data of grid for
	 * Occupancy/Vacation Return For Airmen process----------------------------
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getOccVacOfficerGrid(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> allotmentList = new ArrayList<AccomAllotment>();
		Date hoToFromDate = new Date();
		Date hoToDate = new Date();
		Date allotFromDate = new Date();
		Date allotToDate = new Date();
		String allotmentNo = "";
		int poolId = 0;
		int smqId = 0;
		int deptId = 0;
		String previous = "";

		Session session = (Session) getSession();
		Criteria crit = null;

		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("hoToFromDate") != null) {
			hoToFromDate = (Date) mapForDs.get("hoToFromDate");
		}

		if (mapForDs.get("hoToDate") != null) {
			hoToDate = (Date) mapForDs.get("hoToDate");
		}
		if (mapForDs.get("allotFromDate") != null) {
			allotFromDate = (Date) mapForDs.get("allotFromDate");
		}

		if (mapForDs.get("allotToDate") != null) {
			allotToDate = (Date) mapForDs.get("allotToDate");
		}

		if (mapForDs.get("smqId") != null) {
			smqId = Integer.parseInt("" + mapForDs.get("smqId"));
		}
		if (mapForDs.get("poolId") != null) {
			poolId = Integer.parseInt("" + mapForDs.get("poolId"));
		}

		if (mapForDs.get("allotmentNo") != null) {
			allotmentNo = (String) mapForDs.get("allotmentNo");
		}
		if (mapForDs.get("previous") != null) {
			previous = (String) mapForDs.get("previous");
		}
		try {
			if (previous.equalsIgnoreCase("o")) {
				crit = session.createCriteria(AccomAllotment.class).add(
						Restrictions.eq("AllotType", "o")).createAlias("Accom",
						"accom").add(Restrictions.eq("accom.RegStatus", "o"))
						.add(Restrictions.eq("accom.RegType", "o")).add(
								Restrictions.between("AllotmentDate",
										allotFromDate, allotToDate))
						.createAlias("Department", "dept").add(
								Restrictions.eq("dept.Id", deptId));
			} else if (previous.equalsIgnoreCase("v")) {
				crit = session.createCriteria(AccomAllotment.class).add(
						Restrictions.eq("AllotType", "o")).createAlias("Accom",
						"accom").add(Restrictions.eq("accom.RegStatus", "v"))
						.add(Restrictions.eq("accom.RegType", "o")).add(
								Restrictions.between("AllotmentDate",
										allotFromDate, allotToDate))
						.createAlias("Department", "dept").add(
								Restrictions.eq("dept.Id", deptId));
			}

			if (!allotmentNo.equals("")) {
				crit = crit.add(Restrictions.like("AllotmentNo", allotmentNo
						+ "%"));
			}

			if (poolId != 0) {
				crit = crit.createAlias("Pool", "pool").add(
						Restrictions.eq("pool.Id", poolId));
			}
			if (smqId != 0) {
				crit = crit.createAlias("Smq", "smq").add(
						Restrictions.eq("smq.Id", smqId));
			}

			if (hoToDate != null && hoToFromDate != null) {
				crit = crit.add(Restrictions.between("HoToDate", hoToFromDate,
						hoToDate));
			}

			allotmentList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("allotmentList", allotmentList);
		return map;
	}

	/**
	 * -------------------------------method to data of grid for
	 * Occupancy/Vacation Return For Airmen process----------------------------
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getOccVacAirmenGrid(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> allotmentList = new ArrayList<AccomAllotment>();
		Date hoToFromDate = new Date();
		Date hoToDate = new Date();
		Date allotFromDate = new Date();
		Date allotToDate = new Date();
		String allotmentNo = "";
		int poolId = 0;
		int smqId = 0;
		int deptId = 0;
		String previous = "";

		Session session = (Session) getSession();
		Criteria crit = null;

		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("hoToFromDate") != null) {
			hoToFromDate = (Date) mapForDs.get("hoToFromDate");
		}

		if (mapForDs.get("hoToDate") != null) {
			hoToDate = (Date) mapForDs.get("hoToDate");
		}
		if (mapForDs.get("allotFromDate") != null) {
			allotFromDate = (Date) mapForDs.get("allotFromDate");
		}

		if (mapForDs.get("allotToDate") != null) {
			allotToDate = (Date) mapForDs.get("allotToDate");
		}

		if (mapForDs.get("smqId") != null) {
			smqId = Integer.parseInt("" + mapForDs.get("smqId"));
		}
		if (mapForDs.get("poolId") != null) {
			poolId = Integer.parseInt("" + mapForDs.get("poolId"));
		}

		if (mapForDs.get("allotmentNo") != null) {
			allotmentNo = (String) mapForDs.get("allotmentNo");
		}
		if (mapForDs.get("previous") != null) {
			previous = (String) mapForDs.get("previous");
		}
		try {
			if (previous.equalsIgnoreCase("o")) {
				crit = session.createCriteria(AccomAllotment.class).add(
						Restrictions.eq("AllotType", "a")).createAlias("Accom",
						"accom").add(Restrictions.eq("accom.RegStatus", "o"))
						.add(Restrictions.eq("accom.RegType", "a")).add(
								Restrictions.between("AllotmentDate",
										allotFromDate, allotToDate))
						.createAlias("Department", "dept").add(
								Restrictions.eq("dept.Id", deptId));
			} else if (previous.equalsIgnoreCase("v")) {
				crit = session.createCriteria(AccomAllotment.class).add(
						Restrictions.eq("AllotType", "o")).createAlias("Accom",
						"accom").add(Restrictions.eq("accom.RegStatus", "v"))
						.add(Restrictions.eq("accom.RegType", "a")).add(
								Restrictions.between("AllotmentDate",
										allotFromDate, allotToDate))
						.createAlias("Department", "dept").add(
								Restrictions.eq("dept.Id", deptId));
			}

			if (!allotmentNo.equals("")) {
				crit = crit.add(Restrictions.like("AllotmentNo", allotmentNo
						+ "%"));
			}

			if (poolId != 0) {
				crit = crit.createAlias("Pool", "pool").add(
						Restrictions.eq("pool.Id", poolId));
			}
			if (smqId != 0) {
				crit = crit.createAlias("Smq", "smq").add(
						Restrictions.eq("smq.Id", smqId));
			}

			if (hoToDate != null && hoToFromDate != null) {
				crit = crit.add(Restrictions.between("HoToDate", hoToFromDate,
						hoToDate));
			}

			allotmentList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("allotmentList", allotmentList);
		return map;
	}

	/**
	 * -------------- method to search NAC For Officer(ver 2.0)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getCurrentGridForNac(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomRegistration> nacList = new ArrayList<AccomRegistration>();
		List<AccomAllotment> accomList = new ArrayList<AccomAllotment>();
		Date currentDate = new Date();
		String serviceNo = "";

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		int smqId = 0;
		accomList = session.createCriteria(AccomAllotment.class).createAlias(
				"Accom", "accom").add(
				Restrictions.eq("accom.ServiceNo", serviceNo)).createAlias(
				"Smq", "smq").add(Restrictions.eq("smq.SmqStatus", "o")).list();
		for (AccomAllotment accomAllot : accomList) {
			smqId = accomAllot.getSmq().getId();
		}
		List<MasSmq> smqlist = new ArrayList<MasSmq>();
		smqlist = session.createCriteria(MasSmq.class).add(
				Restrictions.eq("Id", smqId)).list();
		try {
			crit = session.createCriteria(AccomRegistration.class).add(
					Restrictions.eq("RegType", "o")).add(
					Restrictions.eq("RegStatus", "o")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).add(
					Restrictions.eq("RegistrationDate", currentDate));
			nacList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("nacList", nacList);
		map.put("accomList", accomList);
		map.put("smqlist", smqlist);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getNacGrid(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomRegistration> nacList = new ArrayList<AccomRegistration>();
		List<AccomAllotment> accomList = new ArrayList<AccomAllotment>();

		Date regFromDate = new Date();
		Date regToDate = new Date();
		String serviceNo = "";

		int deptId = 0;

		Session session = (Session) getSession();
		Criteria crit = null;

		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("regFromDate") != null) {
			regFromDate = (Date) mapForDs.get("regFromDate");
		}

		if (mapForDs.get("regToDate") != null) {
			regToDate = (Date) mapForDs.get("regToDate");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		int smqId = 0;
		accomList = session.createCriteria(AccomAllotment.class).createAlias(
				"Accom", "accom").add(
				Restrictions.eq("accom.ServiceNo", serviceNo)).createAlias(
				"Smq", "smq").add(Restrictions.eq("smq.SmqStatus", "o")).list();
		for (AccomAllotment accomAllot : accomList) {
			smqId = accomAllot.getSmq().getId();
		}
		List<MasSmq> smqlist = new ArrayList<MasSmq>();
		smqlist = session.createCriteria(MasSmq.class).add(
				Restrictions.eq("Id", smqId)).list();

		try {

			crit = session.createCriteria(AccomRegistration.class).add(
					Restrictions.eq("RegType", "o")).add(
					Restrictions.eq("RegStatus", "o")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).add(
					Restrictions.between("RegistrationDate", regFromDate,
							regToDate));
			if (!serviceNo.equals("")) {
				crit = crit
						.add(Restrictions.like("ServiceNo", serviceNo + "%"));
			}

			nacList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("nacList", nacList);
		map.put("accomList", accomList);
		map.put("smqlist", smqlist);
		return map;
	}

	/**
	 * ------------- method to add allot vacant for officer
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitAllotmentDetailsOfficer(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}

		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '1'");
		smqList = session.createCriteria(MasSmq.class).add(
				Restrictions.eq("Status", "y")).createAlias("PoolCategory",
				"poolCat").add(Restrictions.eq("poolCat.Id", 1)).list();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector poolId = box.getVector(RequestConstants.POOL_ID);
			Vector smqId = box.getVector(RequestConstants.SMQ_ID);
			Vector accomId = box.getVector(RequestConstants.REGISTRATION_ID);
			Vector allotmentNo = box.getVector(RequestConstants.ALLOTMENT_NO);
			Vector changedBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector currentTime = box.getVector(RequestConstants.CHANGED_TIME);
			Vector allotmentTime = box
					.getVector(RequestConstants.ALLOTMENT_TIME);
			Vector deptId = box.getVector(RequestConstants.DEPARTMENT_ID);
			Vector hospitalId = box.getVector(RequestConstants.HOSPITAL_ID);

			for (int i = 0; i < allotmentNo.size(); i++) {
				AccomAllotment accomAllot = new AccomAllotment();
				if (allotmentNo.get(i) != null
						&& !allotmentNo.get(i).equals("")) {

					MasPool masPool = new MasPool();
					masPool.setId(Integer.parseInt((String) poolId.get(i)));
					accomAllot.setPool(masPool);

					if (smqId.get(i) != null && !smqId.get(i).equals("")) {
						MasSmq masSmq = new MasSmq();
						masSmq.setId(Integer.parseInt((String) smqId.get(i)));
						accomAllot.setSmq(masSmq);
					}

					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer
							.parseInt((String) deptId.get(i)));
					accomAllot.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(Integer.parseInt((String) hospitalId
							.get(i)));
					accomAllot.setHospital(masHospital);

					if (accomId.get(i) != null && !accomId.get(i).equals("")) {
						AccomRegistration accomReg = new AccomRegistration();
						accomReg.setId(Integer
								.parseInt((String) accomId.get(i)));
						accomAllot.setAccom(accomReg);
					}

					accomAllot.setHoToDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.HO_TO_DATE)));
					if (allotmentNo != null && !allotmentNo.equals("")) {
						accomAllot.setAllotmentNo((String) allotmentNo.get(i));
					}
					accomAllot.setAllotType("o");
					accomAllot.setLastChgBy((String) changedBy.get(i));
					accomAllot.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomAllot.setLastChgTime((String) currentTime.get(i));

					accomAllot.setAllotmentDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.ALLOTMENT_DATE)));
					accomAllot.setAllotmentTime((String) allotmentTime.get(i));
					hbt.save(accomAllot);

					int smqId1 = Integer.parseInt(smqId.get(i).toString());
					MasSmq masSmq1 = (MasSmq) getHibernateTemplate().load(
							MasSmq.class, smqId1);
					masSmq1.setSmqStatus("o");
					hbt.update(masSmq1);

					int accomId1 = Integer.parseInt(accomId.get(i).toString());
					AccomRegistration accomReg = (AccomRegistration) getHibernateTemplate()
							.load(AccomRegistration.class, accomId1);
					accomReg.setRegStatus("o");
					hbt.update(accomReg);

				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		map.put("poolList", poolList);
		return map;
	}

	/**
	 * ------------- method to add allot vacant for officer
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitRecordsForOccVacOfficer(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector allotmentNo = box
					.getVector(RequestConstants.ALLOTMENT_FILE_NO);
			Vector changedBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector currentTime = box.getVector(RequestConstants.CHANGED_TIME);
			Vector deptId = box.getVector(RequestConstants.DEPARTMENT_ID);
			Vector hospitalId = box.getVector(RequestConstants.HOSPITAL_ID);
			Vector allotId = box.getVector(RequestConstants.ALLOTMENT_ID);
			Vector regId = box.getVector(RequestConstants.REGISTRATION_ID);

			for (int i = 0; i < allotmentNo.size(); i++) {
				AccomAllotment accomAllot = (AccomAllotment) hbt.load(
						AccomAllotment.class, Integer.parseInt((String) allotId
								.get(i)));
				if (allotmentNo.get(i) != null
						&& !allotmentNo.get(i).equals("")) {
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer
							.parseInt((String) deptId.get(i)));
					accomAllot.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(Integer.parseInt((String) hospitalId
							.get(i)));
					accomAllot.setHospital(masHospital);

					accomAllot.setLastChgBy((String) changedBy.get(i));
					accomAllot.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomAllot.setLastChgTime((String) currentTime.get(i));

					accomAllot.setPhysicalDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.ENTRY_DATE)));
					hbt.saveOrUpdate(accomAllot);

					AccomRegistration accomReg = (AccomRegistration) hbt.load(
							AccomRegistration.class, Integer
									.parseInt((String) regId.get(i)));
					accomReg.setLastChgBy((String) changedBy.get(i));
					accomReg.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomReg.setLastChgTime((String) currentTime.get(i));
					accomReg.setRegStatus("v");
					hbt.saveOrUpdate(accomReg);

				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	/**
	 * ------------- method to add allot vacant for officer
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitRecordsForOccVacAirmen(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector allotmentNo = box
					.getVector(RequestConstants.ALLOTMENT_FILE_NO);
			Vector changedBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector currentTime = box.getVector(RequestConstants.CHANGED_TIME);
			Vector deptId = box.getVector(RequestConstants.DEPARTMENT_ID);
			Vector hospitalId = box.getVector(RequestConstants.HOSPITAL_ID);
			Vector allotId = box.getVector(RequestConstants.ALLOTMENT_ID);
			Vector regId = box.getVector(RequestConstants.REGISTRATION_ID);
			for (int i = 0; i < allotmentNo.size(); i++) {
				AccomAllotment accomAllot = (AccomAllotment) hbt.load(
						AccomAllotment.class, Integer.parseInt((String) allotId
								.get(i)));
				if (allotmentNo.get(i) != null
						&& !allotmentNo.get(i).equals("")) {
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer
							.parseInt((String) deptId.get(i)));
					accomAllot.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(Integer.parseInt((String) hospitalId
							.get(i)));
					accomAllot.setHospital(masHospital);

					accomAllot.setLastChgBy((String) changedBy.get(i));
					accomAllot.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomAllot.setLastChgTime((String) currentTime.get(i));

					accomAllot.setPhysicalDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.ENTRY_DATE)));
					hbt.saveOrUpdate(accomAllot);

					AccomRegistration accomReg = (AccomRegistration) hbt.load(
							AccomRegistration.class, Integer
									.parseInt((String) regId.get(i)));
					accomReg.setLastChgBy((String) changedBy.get(i));
					accomReg.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomReg.setLastChgTime((String) currentTime.get(i));
					accomReg.setRegStatus("v");
					hbt.saveOrUpdate(accomReg);
				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	/**
	 * -----------------------method to get grid for cancellation of allotmnet
	 * of airmen-------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCancelGridOfficer(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccomAllotment> searchAllotmentList = new ArrayList<AccomAllotment>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		int rankId = 0;
		int poolId = 0;
		int serviceTypeId = 0;
		String allotmentNo = "";
		String serPersonFName = "";
		int smqId = 0;

		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("rankId") != null) {
			rankId = Integer.parseInt("" + mapForDs.get("rankId"));
		}
		if (mapForDs.get("poolId") != null) {
			poolId = Integer.parseInt("" + mapForDs.get("poolId"));
		}
		if (mapForDs.get("serviceTypeId") != null) {
			serviceTypeId = Integer
					.parseInt("" + mapForDs.get("serviceTypeId"));
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}

		if (mapForDs.get("allotmentNo") != null) {
			allotmentNo = (String) mapForDs.get("allotmentNo");
		}
		if (mapForDs.get("smqId") != null) {
			smqId = Integer.parseInt("" + mapForDs.get("smqId"));
		}

		try {
			crit = session.createCriteria(AccomAllotment.class).add(
					Restrictions.eq("AllotType", "o")).createAlias("Accom",
					"accom").add(Restrictions.eq("accom.RegStatus", "o")).add(
					Restrictions.between("HoToDate", fromDate, toDate))
					.createAlias("Department", "dept").add(
							Restrictions.eq("dept.Id", deptId));
			if (!allotmentNo.equals("")) {
				crit = crit.add(Restrictions.like("AllotmentNo", allotmentNo
						+ "%"));
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.like("accom.ServiceNo", serviceNo
						+ "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("accom.ServicePersonName",
						serPersonFName + "%"));
			}
			if (poolId != 0) {
				crit = crit.add(Restrictions.eq("Pool.Id", poolId));
			}
			if (smqId != 0) {
				crit = crit.add(Restrictions.eq("Smq.Id", smqId));
			}
			if (rankId != 0) {
				crit = crit.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}
			if (serviceTypeId != 0) {
				crit = crit.createAlias("accom.ServiceType", "serviceType")
						.add(Restrictions.eq("serviceType.Id", serviceTypeId));
			}
			searchAllotmentList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchAllotmentList", searchAllotmentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitAllotmentDetailsAirmen(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPool> poolList = new ArrayList<MasPool>();
		List<MasSmq> smqList = new ArrayList<MasSmq>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}

		poolList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPool as g where g.PoolCategory.Id = '2'");
		smqList = session.createCriteria(MasSmq.class).add(
				Restrictions.eq("Status", "y")).createAlias("PoolCategory",
				"poolCat").add(Restrictions.eq("poolCat.Id", 2)).list();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector poolId = box.getVector(RequestConstants.POOL_ID);
			Vector smqId = box.getVector(RequestConstants.SMQ_ID);
			Vector accomId = box.getVector(RequestConstants.REGISTRATION_ID);
			Vector allotmentNo = box.getVector(RequestConstants.ALLOTMENT_NO);
			Vector changedBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector currentTime = box.getVector(RequestConstants.CHANGED_TIME);
			Vector allotmentTime = box
					.getVector(RequestConstants.ALLOTMENT_TIME);
			Vector deptId = box.getVector(RequestConstants.DEPARTMENT_ID);
			Vector hospitalId = box.getVector(RequestConstants.HOSPITAL_ID);

			for (int i = 0; i < allotmentNo.size(); i++) {
				AccomAllotment accomAllot = new AccomAllotment();
				if (allotmentNo.get(i) != null
						&& !allotmentNo.get(i).equals("")) {

					MasPool masPool = new MasPool();
					masPool.setId(Integer.parseInt((String) poolId.get(i)));
					accomAllot.setPool(masPool);

					if (smqId.get(i) != null && !smqId.get(i).equals("")) {
						MasSmq masSmq = new MasSmq();
						masSmq.setId(Integer.parseInt((String) smqId.get(i)));
						accomAllot.setSmq(masSmq);
					}

					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer
							.parseInt((String) deptId.get(i)));
					accomAllot.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(Integer.parseInt((String) hospitalId
							.get(i)));
					accomAllot.setHospital(masHospital);

					if (accomId.get(i) != null && !accomId.get(i).equals("")) {
						AccomRegistration accomReg = new AccomRegistration();
						accomReg.setId(Integer
								.parseInt((String) accomId.get(i)));
						accomAllot.setAccom(accomReg);
					}

					accomAllot.setHoToDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.HO_TO_DATE)));
					if (allotmentNo != null && !allotmentNo.equals("")) {
						accomAllot.setAllotmentNo((String) allotmentNo.get(i));
					}
					accomAllot.setAllotType("a");
					accomAllot.setLastChgBy((String) changedBy.get(i));
					accomAllot.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomAllot.setLastChgTime((String) currentTime.get(i));

					accomAllot.setAllotmentDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.ALLOTMENT_DATE)));
					accomAllot.setAllotmentTime((String) allotmentTime.get(i));
					map.put("allotmentNo", allotmentNo.get(i));
					hbt.save(accomAllot);

					int smqId1 = Integer.parseInt(smqId.get(i).toString());
					MasSmq masSmq1 = (MasSmq) getHibernateTemplate().load(
							MasSmq.class, smqId1);
					masSmq1.setSmqStatus("o");
					hbt.update(masSmq1);

					int accomId1 = Integer.parseInt(accomId.get(i).toString());
					AccomRegistration accomReg = (AccomRegistration) getHibernateTemplate()
							.load(AccomRegistration.class, accomId1);
					accomReg.setRegStatus("o");
					hbt.update(accomReg);

				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		map.put("poolList", poolList);
		return map;
	}

	/**
	 * ---------------------- method to update sttaus in registration for nac
	 * (Ver2.0)
	 */

	@SuppressWarnings("unchecked")
	public boolean submitNac(Box box, Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		boolean successfullyAdded = false;

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Vector regId = box.getVector(RequestConstants.REGISTRATION_ID);
			Vector validated = box.getVector(RequestConstants.VALIDATED);
			Vector changeBy = box.getVector(RequestConstants.CHANGED_BY);
			Vector changetime = box.getVector(RequestConstants.CHANGED_TIME);
			Vector remarks = box.getVector(RequestConstants.REMARKS);

			for (int i = 0; i < validated.size(); i++) {
				if (validated.get(i) != null && !validated.get(i).equals("")) {
					AccomRegistration accomReg = (AccomRegistration) hbt.load(
							AccomRegistration.class, Integer
									.parseInt((String) regId.get(i)));

					accomReg.setRegStatus("a");
					accomReg.setRemarks((String) remarks.get(i));
					accomReg.setLastChgBy((String) changeBy.get(i));
					accomReg.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					accomReg.setLastChgTime((String) changetime.get(i));
					accomReg.setAcceptedDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.CHANGED_DATE)));
					hbt.saveOrUpdate(accomReg);
				}
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	/** method for connection of report * */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getConnectionForReport() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection con = session.connection();
		map.put("con", con);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMarriageAccomodationReg(
			Map<String, Object> map) {
		List<MasLocation> locationList = new ArrayList<MasLocation>();
		locationList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasLocation as isc where isc.Status = 'y'");
		try {

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("locationList", locationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showRelegationList(Map<String, Object> map) {
		List<MasRank> rankList = new ArrayList<MasRank>();
		rankList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRank as isc where isc.Status = 'y'");
		try {

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("rankList", rankList);
		return map;
	}

	public Map<String, Object> showUnitSearchJsp(Box box) {

		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String str = box.get("unit_name");
			if (str != null && str.length() > 0) {
				str = "%" + str.replace(" ", "%") + "%";
				Session session = (Session) getSession();
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				// masIcdList =
				// session.createCriteria(MasIcd.class).add(Restrictions.like("IcdName",
				// str)).list();
				String query = "from MasUnit as unit  where unit.UnitName like '"
						+ str + "' and unit.Status='y'";
				Query q = session.createQuery(query);
				masUnitList = q.list();
			}
			map.put("masUnitList", masUnitList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}
	/**
	 * ----------------------------------------end of code
	 * -------------------------------------------------------------------------
	 */

}
