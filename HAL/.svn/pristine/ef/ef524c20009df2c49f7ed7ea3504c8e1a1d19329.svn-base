package jkt.hms.library.dataservice;

import static jkt.hms.util.RequestConstants.BOOK_ISSUE_DETAIL_ID;
import static jkt.hms.util.RequestConstants.RETURN;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.LibBookIssueDetail;
import jkt.hms.masters.business.LibBookIssueHeader;
import jkt.hms.masters.business.LibBookReturnDt;
import jkt.hms.masters.business.LibBookReturnHd;
import jkt.hms.masters.business.LibBookStock;
import jkt.hms.masters.business.LibBookStockTakingDt;
import jkt.hms.masters.business.LibBookStockTakingHd;
import jkt.hms.masters.business.LibCrvDt;
import jkt.hms.masters.business.LibCrvHd;
import jkt.hms.masters.business.LibJournalReceiptEntryDt;
import jkt.hms.masters.business.LibJournalReceiptEntryHd;
import jkt.hms.masters.business.MasBook;
import jkt.hms.masters.business.MasBookCategory;
import jkt.hms.masters.business.MasBookClass;
import jkt.hms.masters.business.MasBookSubClass;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasPublisher;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasVendor;
import jkt.hms.masters.business.MlSupplyorderDetail;
import jkt.hms.masters.business.MlSupplyorderHeader;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PagedArray;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LibraryDataServiceImpl extends HibernateDaoSupport implements
		LibraryDataService {
	HibernateTransactionManager transactionManager = null;
	Session session;

	/**
	 * ----------------- method to show Book Category
	 * --------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBookCategory() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBookCategory> searchBookCategoryList = new ArrayList<MasBookCategory>();
		searchBookCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookCategory ");
		map.put("searchBookCategoryList", searchBookCategoryList);
		return map;
	}

	/**
	 * --------------------------------- method to add book Category
	 * -----------------------------------------
	 */
	public boolean addBookCategory(MasBookCategory masBookCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBookCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	/**
	 * --------------------------------- method to edit book Category
	 * ----------------------------------------
	 */
	public boolean editBookCategory(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bookCategoryName = "";
		@SuppressWarnings("unused")
		String bookCategoryCode = "";
		int bookCategoryId = 0;
		String changedBy = "";
		try {
			bookCategoryId = (Integer) generalMap.get("id");
			bookCategoryCode = (String) generalMap.get("bookCategoryCode");
			bookCategoryName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			System.out
					.println("Exception before masPoolCategory in dataserviceImpl "
							+ e);
		}

		MasBookCategory masbookCategory = (MasBookCategory) getHibernateTemplate()
				.get(MasBookCategory.class, bookCategoryId);

		masbookCategory.setId(bookCategoryId);
		masbookCategory.setBookCategoryName(bookCategoryName);
		masbookCategory.setLastChgBy(changedBy);
		masbookCategory.setLastChgDate(currentDate);
		masbookCategory.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masbookCategory);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/**
	 * --------------------------------- method to delete book Category
	 * --------------------------------------
	 */
	public boolean deleteBookCategory(int bookCategoryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBookCategory masBookCategory = new MasBookCategory();
		masBookCategory = (MasBookCategory) getHibernateTemplate().get(
				MasBookCategory.class, bookCategoryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBookCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBookCategory.setStatus("y");
				dataDeleted = false;
			}
		}
		masBookCategory.setLastChgBy(changedBy);
		masBookCategory.setLastChgDate(currentDate);
		masBookCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masBookCategory);
		return dataDeleted;
	}

	/**
	 * --------------------------------- method to search Book Category
	 * -----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBookCategory(String bookCategoryCode,
			String bookCategoryName) {
		List<MasBookCategory> searchBookCategoryList = new ArrayList<MasBookCategory>();
		Map<String, Object> bookCategoryFieldsMap = new HashMap<String, Object>();
		try {
			if ((bookCategoryName != null) || (bookCategoryCode == null)) {

				searchBookCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBookCategory imc where imc.BookCategoryName like '"
										+ bookCategoryName
										+ "%' order by imc.BookCategoryName");
			} else {
				searchBookCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBookCategory imc where imc.BookCategoryCode like '"
										+ bookCategoryCode
										+ "%' order by imc.BookCategoryCode");
			}
		} catch (Exception e) {
			System.out.println("Ds excp in searchBookCategoryList  " + e);
		}
		bookCategoryFieldsMap.put("searchBookCategoryList",
				searchBookCategoryList);
		return bookCategoryFieldsMap;
	}

	/**
	 * ------------------------------------- method to show BookClass Master
	 * -----------------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBookClass() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBookClass> searchBookClassList = new ArrayList<MasBookClass>();
		List<MasBookCategory> bookCategoryList = new ArrayList<MasBookCategory>();
		List<MasBookCategory> gridBookCategoryList = new ArrayList<MasBookCategory>();

		searchBookClassList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookClass ");
		gridBookCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookCategory as isc");
		bookCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBookCategory as isc where isc.Status = 'y'");

		map.put("searchBookClassList", searchBookClassList);
		map.put("bookCategoryList", bookCategoryList);
		map.put("gridBookCategoryList", gridBookCategoryList);

		return map;
	}

	/**
	 * ------------------------------------------ method to add book class
	 * Master -----------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> addBookClass(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBookClass masBookClass = new MasBookClass();
		boolean saved = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		String bookClassCode = (String) dataMap.get("code");
		String bookClassName = (String) dataMap.get("name");
		int bookCategoryId = (Integer) dataMap.get("bookCategoryId");
		String changedBy = (String) dataMap.get("changedBy");
		Date currentDate = (Date) dataMap.get("currentDate");

		masBookClass.setClassCode(bookClassCode);
		masBookClass.setClassName(bookClassName);

		MasBookCategory masBookCategory = new MasBookCategory();
		masBookCategory.setId(bookCategoryId);
		masBookClass.setBookCategory(masBookCategory);
		masBookClass.setStatus("y");
		masBookClass.setLastChgBy(changedBy);
		masBookClass.setLastChgDate(currentDate);
		masBookClass.setLastChgTime(time);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			hbt.save(masBookClass);
			hbt.refresh(masBookClass);

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	/**
	 * --------------------------------------- method to edit book clas
	 * --------------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean editBookClass(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bookClassName = "";
		int bookClassId = 0;
		String changedBy = "";
		int bookCategoryId = 0;
		try {

			bookClassName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			bookClassId = (Integer) generalMap.get("bookClassId");
			bookCategoryId = (Integer) generalMap.get("bookCategoryId");

		} catch (Exception e) {
			System.out.println("Exception before masTitle in dataserviceImpl "
					+ e);
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasBookClass masBookClass = (MasBookClass) getHibernateTemplate().get(
				MasBookClass.class, bookClassId);

		masBookClass.setId(bookClassId);
		masBookClass.setClassName(bookClassName);
		masBookClass.setLastChgBy(changedBy);
		masBookClass.setLastChgDate(currentDate);
		masBookClass.setLastChgTime(currentTime);
		MasBookCategory masbookCategory = new MasBookCategory();
		masbookCategory.setId(bookCategoryId);
		masBookClass.setBookCategory(masbookCategory);
		try {

			hbt.saveOrUpdate(masBookClass);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		dataUpdated = true;

		return dataUpdated;
	}

	/**
	 * ------------------------------------- method to search book class master
	 * -------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBookClass(String bookClassCode,
			String bookClassName) {
		List<MasBookClass> searchBookClassList = new ArrayList<MasBookClass>();
		List<MasBookCategory> bookCategoryList = new ArrayList<MasBookCategory>();
		List<MasBookCategory> gridBookCategoryList = new ArrayList<MasBookCategory>();

		Map<String, Object> bookFieldsMap = new HashMap<String, Object>();

		try {
			if ((bookClassName != null) || (bookClassCode == null)) {

				searchBookClassList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBookClass imc where imc.ClassName like '"
								+ bookClassName + "%' order by imc.ClassName");
			} else {
				searchBookClassList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBookClass imc where imc.ClassCode like '"
								+ bookClassCode + "%' order by imc.ClassCode");
			}
		} catch (Exception e) {
			System.out.println("Ds excp in searchBookClaasList  " + e);
		}

		gridBookCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookCategory as isc");
		bookCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBookCategory as isc where isc.Status = 'y'");

		bookFieldsMap.put("bookCategoryList", bookCategoryList);
		bookFieldsMap.put("gridBookCategoryList", gridBookCategoryList);
		bookFieldsMap.put("searchBookClassList", searchBookClassList);

		return bookFieldsMap;
	}

	/**
	 * ------------------------------------- method to delete book class
	 * Master---------------------------------
	 */
	public boolean deleteBookClass(int bookClassId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBookClass masbookClass = new MasBookClass();
		masbookClass = (MasBookClass) getHibernateTemplate().get(
				MasBookClass.class, bookClassId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masbookClass.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masbookClass.setStatus("y");
				dataDeleted = false;
			}
		}
		masbookClass.setLastChgBy(changedBy);
		masbookClass.setLastChgDate(currentDate);
		masbookClass.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masbookClass);
		return dataDeleted;
	}

	/**
	 * --------------------------------- METHODS FOR BOOK SUB CLASS
	 * MASTER-----------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBookSubClass() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBookSubClass> searchBookSubClassList = new ArrayList<MasBookSubClass>();
		List<MasBookClass> bookClassList = new ArrayList<MasBookClass>();
		List<MasBookClass> gridBookClassList = new ArrayList<MasBookClass>();

		searchBookSubClassList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookSubClass ");
		gridBookClassList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookClass as isc");
		bookClassList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBookClass as isc where isc.Status = 'y'");

		map.put("searchBookSubClassList", searchBookSubClassList);
		map.put("bookClassList", bookClassList);
		map.put("gridBookClassList", gridBookClassList);

		return map;
	}

	/**
	 * ------------------------------------------ method to add book sub class
	 * Master -----------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> addBookSubClass(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBookSubClass masbookSubClass = new MasBookSubClass();
		boolean saved = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		String bookSubClassCode = (String) dataMap.get("code");
		String bookSubClassName = (String) dataMap.get("name");
		int bookClassId = (Integer) dataMap.get("bookClassId");
		String changedBy = (String) dataMap.get("changedBy");
		Date currentDate = (Date) dataMap.get("currentDate");

		masbookSubClass.setSubClassCode(bookSubClassCode);
		masbookSubClass.setSubClassName(bookSubClassName);

		MasBookClass masBookClass = new MasBookClass();
		masBookClass.setId(bookClassId);
		masbookSubClass.setBookClass(masBookClass);
		masbookSubClass.setStatus("y");
		masbookSubClass.setLastChgBy(changedBy);
		masbookSubClass.setLastChgDate(currentDate);
		masbookSubClass.setLastChgTime(time);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			hbt.save(masbookSubClass);
			hbt.refresh(masbookSubClass);

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	/**
	 * --------------------------------------- method to edit book sub clas
	 * --------------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public boolean editBookSubClass(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bookSubClassName = "";
		int bookSubClassId = 0;
		String changedBy = "";
		int bookClassId = 0;
		try {

			bookSubClassName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			bookClassId = (Integer) generalMap.get("bookClassId");
			bookSubClassId = (Integer) generalMap.get("bookSubClassId");

		} catch (Exception e) {
			System.out.println("Exception before masTitle in dataserviceImpl "
					+ e);
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasBookSubClass masbookSubClass = (MasBookSubClass) getHibernateTemplate()
				.get(MasBookSubClass.class, bookSubClassId);

		masbookSubClass.setId(bookSubClassId);
		masbookSubClass.setSubClassName(bookSubClassName);
		masbookSubClass.setLastChgBy(changedBy);
		masbookSubClass.setLastChgDate(currentDate);
		masbookSubClass.setLastChgTime(currentTime);
		MasBookClass masBookClass = new MasBookClass();
		masBookClass.setId(bookClassId);
		masbookSubClass.setBookClass(masBookClass);
		try {

			hbt.saveOrUpdate(masbookSubClass);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		dataUpdated = true;

		return dataUpdated;
	}

	/**
	 * ------------------------------------- method to search book sub class
	 * master -------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBookSubClass(String bookSubClassCode,
			String bookSubClassName) {
		List<MasBookSubClass> searchBookSubClassList = new ArrayList<MasBookSubClass>();
		List<MasBookClass> bookClassList = new ArrayList<MasBookClass>();
		List<MasBookClass> gridBookClassList = new ArrayList<MasBookClass>();

		Map<String, Object> bookFieldsMap = new HashMap<String, Object>();

		try {
			if ((bookSubClassName != null) || (bookSubClassCode == null)) {

				searchBookSubClassList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBookSubClass imc where imc.SubClassName like '"
										+ bookSubClassName
										+ "%' order by imc.SubClassName");
			} else {
				searchBookSubClassList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasBookSubClass imc where imc.SubClassCode like '"
										+ bookSubClassCode
										+ "%' order by imc.SubClassCode");
			}
		} catch (Exception e) {
			System.out.println("Ds excp in searchBookClaasList  " + e);
		}

		gridBookClassList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookClass as isc");
		bookClassList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBookClass as isc where isc.Status = 'y'");

		bookFieldsMap.put("bookClassList", bookClassList);
		bookFieldsMap.put("gridBookClassList", gridBookClassList);
		bookFieldsMap.put("searchBookSubClassList", searchBookSubClassList);

		return bookFieldsMap;
	}

	/**
	 * ------------------------------------- method to delete book sub class
	 * Master---------------------------------
	 */
	public boolean deleteBookSubClass(int bookSubClassId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBookSubClass masbookSubClass = new MasBookSubClass();
		masbookSubClass = (MasBookSubClass) getHibernateTemplate().get(
				MasBookSubClass.class, bookSubClassId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masbookSubClass.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masbookSubClass.setStatus("y");
				dataDeleted = false;
			}
		}
		masbookSubClass.setLastChgBy(changedBy);
		masbookSubClass.setLastChgDate(currentDate);
		masbookSubClass.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masbookSubClass);
		return dataDeleted;
	}

	/**
	 * ------------------- methods for vendor
	 * master------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showVendorMaster() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVendor> searchVendorList = new ArrayList<MasVendor>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();

		searchVendorList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasVendor ");
		gridDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict as isc");
		districtList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDistrict as isc where isc.Status = 'y'");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState as isc");
		stateList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasState as isc where isc.Status = 'y'");

		map.put("searchVendorList", searchVendorList);
		map.put("districtList", districtList);
		map.put("gridDistrictList", gridDistrictList);
		map.put("gridStateList", gridStateList);
		map.put("stateList", stateList);

		return map;
	}

	/**
	 * --------------------------------- method to add masvendor
	 * -----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> addVendor(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasVendor masVendor = new MasVendor();
		boolean saved = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");

		String vendorCode = (String) dataMap.get("code");
		String vendorName = (String) dataMap.get("name");
		int stateId = (Integer) dataMap.get("stateId");
		int districtId = (Integer) dataMap.get("districtId");

		String changedBy = (String) dataMap.get("changedBy");
		Date currentDate = (Date) dataMap.get("currentDate");
		int pin = (Integer) dataMap.get("pin");
		String address1 = (String) dataMap.get("address1");
		String address2 = (String) dataMap.get("address2");
		String address3 = (String) dataMap.get("address3");

		masVendor.setVendorCode(vendorCode);
		masVendor.setVendorName(vendorName);
		if (pin == 0) {
			masVendor.setPincode(null);
		} else {
			masVendor.setPincode(pin);
		}

		masVendor.setAddress1(address1);
		masVendor.setAddress2(address2);
		masVendor.setAddress3(address3);

		if (districtId == 0) {

			masVendor.setDistrict(null);

		} else {

			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			masVendor.setDistrict(masDistrict);
		}
		if (stateId == 0) {

			masVendor.setState(null);

		} else {

			MasState masState = new MasState();
			masState.setId(stateId);
			masVendor.setState(masState);
		}

		masVendor.setStatus("y");
		masVendor.setLastChgBy(changedBy);
		masVendor.setLastChgDate(currentDate);
		masVendor.setLastChgTime(time);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			hbt.save(masVendor);
			hbt.refresh(masVendor);

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	public boolean deleteVendor(int vendorId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasVendor masVendor = new MasVendor();
		masVendor = (MasVendor) getHibernateTemplate().get(MasVendor.class,
				vendorId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masVendor.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masVendor.setStatus("y");
				dataDeleted = false;
			}
		}
		masVendor.setLastChgBy(changedBy);
		masVendor.setLastChgDate(currentDate);
		masVendor.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masVendor);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchVendor(String vendorCode, String vendorName) {
		List<MasVendor> searchVendorList = new ArrayList<MasVendor>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();

		Map<String, Object> vendorFieldsMap = new HashMap<String, Object>();

		try {
			if ((vendorName != null) || (vendorCode == null)) {

				searchVendorList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasVendor imc where imc.VendorName like '"
								+ vendorName + "%' order by imc.VendorName");
			} else {
				searchVendorList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasVendor imc where imc.VendorCode like '"
								+ vendorCode + "%' order by imc.VendorCode");
			}
		} catch (Exception e) {
			System.out.println("Ds excp in searchVendorList  " + e);
		}

		gridDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict as isc");
		districtList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDistrict as isc where isc.Status = 'y'");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState as isc");
		stateList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasState as isc where isc.Status = 'y'");

		vendorFieldsMap.put("searchVendorList", searchVendorList);
		vendorFieldsMap.put("districtList", districtList);
		vendorFieldsMap.put("gridDistrictList", gridDistrictList);
		vendorFieldsMap.put("gridStateList", gridStateList);
		vendorFieldsMap.put("stateList", stateList);

		return vendorFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean editVendor(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String vendorName = "";
		int vendorId = 0;
		String changedBy = "";
		int districtId = 0;
		int stateId = 0;
		String address1 = "";
		String address2 = "";
		String address3 = "";
		int pin = 0;
		try {

			vendorName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			districtId = (Integer) generalMap.get("districtId");
			stateId = (Integer) generalMap.get("stateId");
			vendorId = (Integer) generalMap.get("vendorId");
			pin = (Integer) generalMap.get("pin");
			address1 = (String) generalMap.get("address1");
			address2 = (String) generalMap.get("address2");
			address3 = (String) generalMap.get("address3");

		} catch (Exception e) {
			System.out.println("Exception before MasVendor in dataserviceImpl "
					+ e);
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasVendor masVendor = (MasVendor) getHibernateTemplate().get(
				MasVendor.class, vendorId);

		masVendor.setId(vendorId);
		masVendor.setVendorName(vendorName);
		masVendor.setLastChgBy(changedBy);
		masVendor.setLastChgDate(currentDate);
		masVendor.setLastChgTime(currentTime);
		masVendor.setAddress1(address1);
		masVendor.setAddress2(address2);
		masVendor.setAddress3(address3);
		masVendor.setPincode(pin);
		if (districtId != '0') {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			masVendor.setDistrict(masDistrict);
		}
		if (stateId != '0') {
			MasState masState = new MasState();
			masState.setId(stateId);
			masVendor.setState(masState);
		}

		try {

			hbt.saveOrUpdate(masVendor);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		dataUpdated = true;

		return dataUpdated;
	}

	/**
	 * ------------------- method to show publisher master
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPublisherMaster() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPublisher> searchPublisherList = new ArrayList<MasPublisher>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();

		searchPublisherList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPublisher ");
		gridDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict as isc");
		districtList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDistrict as isc where isc.Status = 'y'");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState as isc");
		stateList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasState as isc where isc.Status = 'y'");

		map.put("searchPublisherList", searchPublisherList);
		map.put("districtList", districtList);
		map.put("gridDistrictList", gridDistrictList);
		map.put("gridStateList", gridStateList);
		map.put("stateList", stateList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addPublisher(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasPublisher masPub = new MasPublisher();
		boolean saved = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");

		String publisherCode = (String) dataMap.get("code");
		String publisherName = (String) dataMap.get("name");
		int stateId = (Integer) dataMap.get("stateId");
		int districtId = (Integer) dataMap.get("districtId");
		String changedBy = (String) dataMap.get("changedBy");
		Date currentDate = (Date) dataMap.get("currentDate");
		int pin = (Integer) dataMap.get("pin");
		String address1 = (String) dataMap.get("address1");
		String address2 = (String) dataMap.get("address2");
		String address3 = (String) dataMap.get("address3");

		masPub.setPublisherCode(publisherCode);
		masPub.setPublisherName(publisherName);
		if (pin == 0) {
			masPub.setPincode(null);
		} else {
			masPub.setPincode(pin);
		}

		masPub.setAddress1(address1);
		masPub.setAddress2(address2);
		masPub.setAddress3(address3);

		if (districtId == 0) {

			masPub.setDistrict(null);

		} else {

			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			masPub.setDistrict(masDistrict);
		}
		if (stateId == 0) {

			masPub.setState(null);

		} else {

			MasState masState = new MasState();
			masState.setId(stateId);
			masPub.setState(masState);
		}
		masPub.setStatus("y");
		masPub.setLastChgBy(changedBy);
		masPub.setLastChgDate(currentDate);
		masPub.setLastChgTime(time);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			hbt.save(masPub);
			hbt.refresh(masPub);

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPublisher(String publisherCode,
			String publisherName) {
		List<MasPublisher> searchPublisherList = new ArrayList<MasPublisher>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();

		Map<String, Object> publisherFieldsMap = new HashMap<String, Object>();

		try {
			if ((publisherName != null) || (publisherCode == null)) {

				searchPublisherList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasPublisher imc where imc.PublisherName like '"
								+ publisherName
								+ "%' order by imc.PublisherName");
			} else {
				searchPublisherList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasPublisher imc where imc.PublisherCode like '"
								+ publisherCode
								+ "%' order by imc.PublisherCode");
			}
		} catch (Exception e) {
			System.out.println("Ds excp in searchPublisherList  " + e);
		}

		gridDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict as isc");
		districtList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDistrict as isc where isc.Status = 'y'");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState as isc");
		stateList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasState as isc where isc.Status = 'y'");

		publisherFieldsMap.put("searchPublisherList", searchPublisherList);
		publisherFieldsMap.put("districtList", districtList);
		publisherFieldsMap.put("gridDistrictList", gridDistrictList);
		publisherFieldsMap.put("gridStateList", gridStateList);
		publisherFieldsMap.put("stateList", stateList);

		return publisherFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean editPublisher(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String publisherName = "";
		int publisherId = 0;
		String changedBy = "";
		int districtId = 0;
		int stateId = 0;
		String address1 = "";
		String address2 = "";
		String address3 = "";
		int pin = 0;
		try {

			publisherName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			districtId = (Integer) generalMap.get("districtId");
			stateId = (Integer) generalMap.get("stateId");
			publisherId = (Integer) generalMap.get("publisherId");
			pin = (Integer) generalMap.get("pin");
			address1 = (String) generalMap.get("address1");
			address2 = (String) generalMap.get("address2");
			address3 = (String) generalMap.get("address3");

		} catch (Exception e) {
			System.out.println("Exception before masTitle in dataserviceImpl "
					+ e);
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasPublisher masVendor = (MasPublisher) getHibernateTemplate().get(
				MasPublisher.class, publisherId);

		masVendor.setId(publisherId);
		masVendor.setPublisherName(publisherName);
		masVendor.setLastChgBy(changedBy);
		masVendor.setLastChgDate(currentDate);
		masVendor.setLastChgTime(currentTime);
		masVendor.setAddress1(address1);
		masVendor.setAddress2(address2);
		masVendor.setAddress3(address3);
		masVendor.setPincode(pin);
		MasDistrict masDistrict = new MasDistrict();
		masDistrict.setId(districtId);
		masVendor.setDistrict(masDistrict);
		MasState masState = new MasState();
		masState.setId(stateId);
		masVendor.setState(masState);

		try {

			hbt.saveOrUpdate(masVendor);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		dataUpdated = true;

		return dataUpdated;
	}

	public boolean deletePublisher(int publisherId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasPublisher masVendor = new MasPublisher();
		masVendor = (MasPublisher) getHibernateTemplate().get(
				MasPublisher.class, publisherId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masVendor.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masVendor.setStatus("y");
				dataDeleted = false;
			}
		}
		masVendor.setLastChgBy(changedBy);
		masVendor.setLastChgDate(currentDate);
		masVendor.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masVendor);
		return dataDeleted;
	}

	/**
	 * ------------------- method to show book master
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBookMaster() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBook> searchBookList = new ArrayList<MasBook>();
		List<MasBookCategory> bookCategoryList = new ArrayList<MasBookCategory>();
		List<MasBookCategory> gridBookCategoryList = new ArrayList<MasBookCategory>();
		List<MasBookClass> bookClassList = new ArrayList<MasBookClass>();
		List<MasBookClass> gridBookClassList = new ArrayList<MasBookClass>();
		List<MasBookSubClass> bookSubClassList = new ArrayList<MasBookSubClass>();
		List<MasBookSubClass> gridBookSubClassList = new ArrayList<MasBookSubClass>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();
		List<MasPublisher> publisherList = new ArrayList<MasPublisher>();
		List<MasPublisher> gridPublisherList = new ArrayList<MasPublisher>();

		searchBookList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBook ");
		gridBookCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookCategory as isc");
		bookCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBookCategory as isc where isc.Status = 'y'");
		gridBookClassList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookClass as isc");
		bookClassList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBookClass as isc where isc.Status = 'y'");
		gridBookSubClassList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookSubClass as isc");
		bookSubClassList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBookSubClass as isc where isc.Status = 'y'");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as isc");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y'");
		gridPublisherList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPublisher as isc");
		publisherList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPublisher as isc where isc.Status = 'y'");

		map.put("searchBookList", searchBookList);
		map.put("bookCategoryList", bookCategoryList);
		map.put("gridBookCategoryList", gridBookCategoryList);
		map.put("gridBookClassList", gridBookClassList);
		map.put("bookClassList", bookClassList);
		map.put("gridBookSubClassList", gridBookSubClassList);
		map.put("bookSubClassList", bookSubClassList);
		map.put("gridDepartmentList", gridDepartmentList);
		map.put("departmentList", departmentList);
		map.put("gridPublisherList", gridPublisherList);
		map.put("publisherList", publisherList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addBook(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBook masbook = new MasBook();
		boolean saved = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");

		String bookCode = (String) dataMap.get("code");
		String bookName = (String) dataMap.get("name");
		int bookCategoryId = (Integer) dataMap.get("bookCategoryId");
		int bookClassId = (Integer) dataMap.get("bookClassId");
		int bookSubClassId = (Integer) dataMap.get("bookSubClassId");
		String authorName = (String) dataMap.get("authorName");
		String publicationYear = (String) dataMap.get("publicationYear");
		Date purchaseDate = (Date) dataMap.get("purchaseDate");
		String edition = (String) dataMap.get("edition");
		String location = (String) dataMap.get("location");
		String type = (String) dataMap.get("type");
		String volume = (String) dataMap.get("volume");
		int deptId = (Integer) dataMap.get("deptId");
		int publisherId = (Integer) dataMap.get("publisherId");
		String pages = (String) dataMap.get("pages");
		BigDecimal price = (BigDecimal) dataMap.get("price");
		String changedBy = (String) dataMap.get("changedBy");
		Date currentDate = (Date) dataMap.get("currentDate");

		masbook.setBookNo(bookCode);
		masbook.setBookName(bookName);
		masbook.setAuthorName(authorName);
		masbook.setYearPublication(publicationYear);
		masbook.setPurchaseDate(purchaseDate);
		masbook.setEdition(edition);
		masbook.setLocation(location);
		masbook.setTypes(type);
		masbook.setVolume(volume);
		masbook.setPages(pages);
		masbook.setPrice(price);

		MasBookCategory masbookCategory = new MasBookCategory();
		masbookCategory.setId(bookCategoryId);
		masbook.setBookCategory(masbookCategory);

		MasBookClass masbookClass = new MasBookClass();
		masbookClass.setId(bookClassId);
		masbook.setBookClass(masbookClass);

		MasBookSubClass masbooksubClass = new MasBookSubClass();
		masbooksubClass.setId(bookSubClassId);
		masbook.setBookSubClass(masbooksubClass);

		if (publisherId != 0) {
			MasPublisher masPublisher = new MasPublisher();
			masPublisher.setId(publisherId);
			masbook.setPublisher(masPublisher);
		}

		if (deptId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			masbook.setDepartment(masDepartment);
		}

		masbook.setStatus("y");
		masbook.setLastChgBy(changedBy);
		masbook.setLastChgDate(currentDate);
		masbook.setLastChgTime(time);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			hbt.save(masbook);
			hbt.refresh(masbook);

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	public boolean deleteBook(int bookId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBook masBook = new MasBook();
		masBook = (MasBook) getHibernateTemplate().get(MasBook.class, bookId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBook.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBook.setStatus("y");
				dataDeleted = false;
			}
		}
		masBook.setLastChgBy(changedBy);
		masBook.setLastChgDate(currentDate);
		masBook.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masBook);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBook(String bookCode, String bookName) {
		List<MasBook> searchBookList = new ArrayList<MasBook>();
		List<MasBookCategory> bookCategoryList = new ArrayList<MasBookCategory>();
		List<MasBookCategory> gridBookCategoryList = new ArrayList<MasBookCategory>();
		List<MasBookClass> bookClassList = new ArrayList<MasBookClass>();
		List<MasBookClass> gridBookClassList = new ArrayList<MasBookClass>();
		List<MasBookSubClass> bookSubClassList = new ArrayList<MasBookSubClass>();
		List<MasBookSubClass> gridBookSubClassList = new ArrayList<MasBookSubClass>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();
		List<MasPublisher> publisherList = new ArrayList<MasPublisher>();
		List<MasPublisher> gridPublisherList = new ArrayList<MasPublisher>();
		Map<String, Object> bookFieldsMap = new HashMap<String, Object>();

		try {
			if ((bookName != null) || (bookCode == null)) {

				searchBookList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBook imc where imc.BookName like '"
								+ bookName + "%' order by imc.BookName");
			} else {
				searchBookList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBook imc where imc.BookNo like '"
								+ bookCode + "%' order by imc.BookNo");
			}
		} catch (Exception e) {
			System.out.println("Ds excp in searchPublisherList  " + e);
		}
		gridBookCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookCategory as isc");
		bookCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBookCategory as isc where isc.Status = 'y'");
		gridBookClassList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookClass as isc");
		bookClassList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBookClass as isc where isc.Status = 'y'");
		gridBookSubClassList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBookSubClass as isc");
		bookSubClassList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBookSubClass as isc where isc.Status = 'y'");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as isc");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y'");
		gridPublisherList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPublisher as isc");
		publisherList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasPublisher as isc where isc.Status = 'y'");

		bookFieldsMap.put("searchBookList", searchBookList);
		bookFieldsMap.put("bookCategoryList", bookCategoryList);
		bookFieldsMap.put("gridBookCategoryList", gridBookCategoryList);
		bookFieldsMap.put("gridBookClassList", gridBookClassList);
		bookFieldsMap.put("bookClassList", bookClassList);
		bookFieldsMap.put("gridBookSubClassList", gridBookSubClassList);
		bookFieldsMap.put("bookSubClassList", bookSubClassList);
		bookFieldsMap.put("gridDepartmentList", gridDepartmentList);
		bookFieldsMap.put("departmentList", departmentList);
		bookFieldsMap.put("gridPublisherList", gridPublisherList);
		bookFieldsMap.put("publisherList", publisherList);

		return bookFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean editBook(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		int bookId = (Integer) generalMap.get("bookId");
		String bookCode = (String) generalMap.get("code");
		String bookName = (String) generalMap.get("name");
		int bookCategoryId = (Integer) generalMap.get("bookCategoryId");
		int bookClassId = (Integer) generalMap.get("bookClassId");
		int bookSubClassId = (Integer) generalMap.get("bookSubClassId");
		String authorName = (String) generalMap.get("authorName");
		String publicationYear = (String) generalMap.get("publicationYear");
		Date purchaseDate = (Date) generalMap.get("purchaseDate");
		String edition = (String) generalMap.get("edition");
		String location = (String) generalMap.get("location");
		String type = (String) generalMap.get("type");
		String volume = (String) generalMap.get("volume");
		int deptId = (Integer) generalMap.get("deptId");
		int publisherId = (Integer) generalMap.get("publisherId");
		String pages = (String) generalMap.get("pages");
		BigDecimal price = (BigDecimal) generalMap.get("price");
		String changedBy = (String) generalMap.get("changedBy");
		Date currentDate = (Date) generalMap.get("currentDate");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasBook masbook = (MasBook) getHibernateTemplate().get(MasBook.class,
				bookId);

		masbook.setId(bookId);
		masbook.setBookNo(bookCode);
		masbook.setBookName(bookName);
		masbook.setAuthorName(authorName);
		masbook.setYearPublication(publicationYear);
		masbook.setPurchaseDate(purchaseDate);
		masbook.setEdition(edition);
		masbook.setLocation(location);
		masbook.setTypes(type);
		masbook.setVolume(volume);
		masbook.setPages(pages);
		masbook.setPrice(price);

		MasBookCategory masbookCategory = new MasBookCategory();
		masbookCategory.setId(bookCategoryId);
		masbook.setBookCategory(masbookCategory);

		MasBookClass masbookClass = new MasBookClass();
		masbookClass.setId(bookClassId);
		masbook.setBookClass(masbookClass);

		MasBookSubClass masbooksubClass = new MasBookSubClass();
		masbooksubClass.setId(bookSubClassId);
		masbook.setBookSubClass(masbooksubClass);

		if (publisherId != 0) {
			MasPublisher masPublisher = new MasPublisher();
			masPublisher.setId(publisherId);
			masbook.setPublisher(masPublisher);
		}

		if (deptId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			masbook.setDepartment(masDepartment);
		}

		masbook.setStatus("y");
		masbook.setLastChgBy(changedBy);
		masbook.setLastChgDate(currentDate);
		masbook.setLastChgTime(currentTime);
		try {

			hbt.saveOrUpdate(masbook);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		dataUpdated = true;

		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> SupplyOrderEntry(Box box,Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVendor> vendorList = new ArrayList<MasVendor>();
		List<MasBook> bookList = new ArrayList<MasBook>();
		List<MasPublisher> publisherList = new ArrayList<MasPublisher>();
		List<MlSupplyorderHeader> searchSupplyList = new ArrayList<MlSupplyorderHeader>();
		List<MlSupplyorderHeader> supplyList = new ArrayList<MlSupplyorderHeader>();

		session = (Session) getSession();

		try {
			vendorList = getHibernateTemplate().find("from jkt.hms.masters.business.MasVendor as mv order by mv.VendorName");
			bookList = getHibernateTemplate().find("from jkt.hms.masters.business.MasBook as mi where mi.Status = 'y'");
			publisherList = getHibernateTemplate().find("from jkt.hms.masters.business.MasPublisher as mi where mi.Status = 'y' order by mi.PublisherName");
			searchSupplyList = getHibernateTemplate().find("from jkt.hms.masters.business.MlSupplyorderHeader as mi ");
			supplyList = getHibernateTemplate().find("from jkt.hms.masters.business.MlSupplyorderHeader as sgm");

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("vendorList", vendorList);
		map.put("bookList", bookList);
		map.put("publisherList", publisherList);
		map.put("searchSupplyList", searchSupplyList);
		map.put("supplyList", supplyList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getBook(Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasBook> bookList = new ArrayList<MasBook>();
		List objectList = new ArrayList();
		String str = "";

		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}
		try {
			Session session = (Session) getSession();
			String qry = "SELECT book_id FROM mas_book";
			objectList = (List) session.createSQLQuery(qry).list();
			Criteria c = session.createCriteria(MasBook.class).add(
					Restrictions.like("BookName", str)).add(
					Restrictions.in("Id", objectList));
			c.setFirstResult(0);
			c.setMaxResults(25);
			bookList = c.list();

			if (bookList.size() > 0) {
				detailsMap.put("bookList", bookList);
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getBookForJournal(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasBook> bookList = new ArrayList<MasBook>();
		List objectList = new ArrayList();
		String str = "";

		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}
		try {
			Session session = (Session) getSession();
			String qry = "SELECT book_id FROM mas_book where types='Journal'";
			objectList = (List) session.createSQLQuery(qry).list();
			System.out.println("objectList :  " + objectList.size());
			Criteria c = session.createCriteria(MasBook.class).add(
					Restrictions.like("BookName", str)).add(
					Restrictions.in("Id", objectList));
			c.setFirstResult(0);
			c.setMaxResults(25);
			bookList = c.list();

			if (bookList.size() > 0) {
				detailsMap.put("bookList", bookList);
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItemsForBook(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasBook> bookList = new ArrayList<MasBook>();
		Session session = (Session) getSession();
		String bookName = (String) dataMap.get("bookName");
		try {
			bookList = session.createCriteria(MasBook.class).add(Restrictions.eq("BookName", bookName)).list();
			map.put("bookList", bookList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public String generateSupplyOrderEntryNumber(Map<String, Object> diagMap) {
		List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
		List<MlSupplyorderHeader> seqNoList = new ArrayList<MlSupplyorderHeader>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		String entryNo = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(MlSupplyorderHeader.class).list();
		if (seqNoList.size() > 0) {
			for (MlSupplyorderHeader mlSupply : seqNoList) {
				lastSeqNo = mlSupply.getSupplyOrderNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		yearlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "SOEN")).list();

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
				entryNo = entryNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}
			System.out.println("entryNo in ds : " + entryNo);
		} else if (yearlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MlSupplyorderHeader");
			tsObj.setTransactionPrefix("SOEN");
			tsObj.setTransactionSequenceName("Supply Order Entry No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		}
		return entryNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitSupplyOrder(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		String entryNo = box.getString(RequestConstants.SUPPLY_ORDER_NO);
		String quotationNo = box.getString(RequestConstants.QUOTATION_NO);
		String quotDate = box.getString(RequestConstants.QUOTATION_DATE);
		Date quotationDate = HMSUtil.convertStringTypeDateToDateType(quotDate);
		int vendorId = box.getInt(RequestConstants.VENDOR_ID);
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");
		String remarks = box.getString(RequestConstants.REMARKS);
		String date = box.getString(RequestConstants.QUOTATION_DATE);
		Date OrderDate = HMSUtil.convertStringTypeDateToDateType(date);

		String chnDate = box.getString(RequestConstants.CHANGED_DATE);
		Date changedDate = HMSUtil.convertStringTypeDateToDateType(chnDate);
		String changedtime = box.getString(RequestConstants.CHANGED_TIME);
		String user = box.getString(RequestConstants.CHANGED_BY);

		MlSupplyorderHeader mlSupplyorderHeader = new MlSupplyorderHeader();

		mlSupplyorderHeader.setSupplyOrderNo(entryNo);
		if (quotationNo != null && !quotationNo.equals("")) {
			mlSupplyorderHeader.setQuotationNo(quotationNo);
		}
		if (remarks != null && !remarks.equals("")) {
			mlSupplyorderHeader.setRemarks(remarks);
		}
		mlSupplyorderHeader.setQuotationDate(quotationDate);
		mlSupplyorderHeader.setDate(OrderDate);
		if (vendorId != 0) {
			MasVendor masVendor = new MasVendor();
			masVendor.setId(vendorId);
			mlSupplyorderHeader.setVendor(masVendor);
		}
		mlSupplyorderHeader.setLastChgBy(user);
		mlSupplyorderHeader.setLastChgDate(changedDate);
		mlSupplyorderHeader.setLastChgTime(changedtime);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		mlSupplyorderHeader.setHospital(masHospital);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		mlSupplyorderHeader.setDepartment(masDepartment);
		mlSupplyorderHeader.setStatus("y");

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(mlSupplyorderHeader);

			Vector bookId = box.getVector("bookId");
			Vector author = box.getVector("author");
			Vector publisherId = box.getVector("publisherId");
			Vector publication = box.getVector("publication");
			Vector cost = box.getVector("cost");
			Vector edition = box.getVector("edition");

			for (int i = 0; i < bookId.size(); i++) {

				MlSupplyorderDetail detail = new MlSupplyorderDetail();

				if (bookId.get(i) != null && !bookId.get(i).equals("")) {
					detail.setSupplyHeader(mlSupplyorderHeader);
					if (bookId.get(i) != null && !bookId.get(i).equals("")) {
						MasBook masBook = new MasBook();
						masBook.setId(Integer.parseInt((String) bookId.get(i)));
						detail.setBook(masBook);
					}

					if (publisherId.get(i) != null
							&& !publisherId.get(i).equals("")) {
						MasPublisher maspub = new MasPublisher();
						maspub.setId(Integer.parseInt((String) publisherId
								.get(i)));
						detail.setPublisher(maspub);
					}

					if (edition.get(i) != null && !edition.equals("")) {
						detail.setEdition((String) edition.get(i));
					}
					BigDecimal cst = null;
					if (cost.get(i).toString() != null
							&& !cost.get(i).toString().equals("")) {
						cst = new BigDecimal(cost.get(i).toString());
					}

					if (cst != null && !cst.equals("")) {
						detail.setCost(cst);
					}
					if (author.get(i) != null && !author.equals("")) {
						detail.setAuthor((String) author.get(i));
					}
					if (publication != null && !publication.equals("")) {
						detail.setPublicationYear((String) publication.get(i));
					}
					hbt.save(detail);

				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSupplyOrderDetails(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MlSupplyorderDetail> searchSupplyOrderList = new ArrayList<MlSupplyorderDetail>();

		String supplyOrderNo = "";
		String quotationNo = "";
		String bookName = "";
		String accNo = "";
		int vendorId = 0;

		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("supplyOrderNo") != null) {
			supplyOrderNo = (String) mapForDs.get("supplyOrderNo");
		}

		if (mapForDs.get("quotationNo") != null) {
			quotationNo = (String) mapForDs.get("quotationNo");
		}

		if (mapForDs.get("bookName") != null) {
			bookName = (String) mapForDs.get("bookName");
		}

		if (mapForDs.get("accNo") != null) {
			accNo = (String) mapForDs.get("accNo");
		}
		if (mapForDs.get("vendorId") != null) {
			vendorId = (Integer) mapForDs.get("vendorId");
		}
		try {
			crit = session.createCriteria(MlSupplyorderHeader.class).createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId));
			if (!supplyOrderNo.equals("")) {
				crit = crit.add(Restrictions.like("SupplyOrderNo",supplyOrderNo + "%"));
			}
			if (!quotationNo.equals("")) {crit = crit.add(Restrictions.like("QuotationNo", quotationNo	+ "%"));
			}
			System.out.println("vendorId---->"+vendorId);
			if (vendorId != 0)
			{
				crit = crit.createAlias("Vendor", "ven").add(Restrictions.eq("ven.Id", vendorId));
				}

			if (!bookName.equals("")) {
				crit = crit.createAlias("Book", "book").add(
						Restrictions.like("book.BookName", bookName + "%"));
			}
			if (!accNo.equals("")) {
				crit = crit.createAlias("Book", "book").add(
						Restrictions.like("book.BookNo", accNo + "%"));
			}
			searchSupplyOrderList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchSupplyOrderList", searchSupplyOrderList);
		System.out.println("searchSupplyOrderList  "+ searchSupplyOrderList.size());
		return map;
	}

	/**
	 * --------------- method to get list from supply order entry update
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSupplyDetails(Map<String, Object> dataMap) {
		List<MlSupplyorderDetail> supplyDtList = new ArrayList<MlSupplyorderDetail>();
		Session session = (Session) getSession();
		int supplyId = 0;
		if (dataMap.get("supplyId") != null) {
			supplyId = (Integer) dataMap.get("supplyId");
		}
		supplyDtList = session.createCriteria(MlSupplyorderDetail.class)
				.createAlias("SupplyHeader", "sh").add(
						Restrictions.eq("sh.Id", supplyId)).list();

		if (supplyDtList != null && supplyDtList.size() > 0) {
			dataMap.put("supplyDtList", supplyDtList);
		}

		return dataMap;

	}

	/**
	 * ------------- method to update supply entry number
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> updateSupplyOrder(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		MlSupplyorderHeader suppHd = new MlSupplyorderHeader();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		int hdId = box.getInt("hdId");

		String date = box.getString(RequestConstants.DATE);
		Date supplyDate = HMSUtil.convertStringTypeDateToDateType(date);
		String quodate = box.getString(RequestConstants.QUOTATION_DATE);
		Date quotationDate = HMSUtil.convertStringTypeDateToDateType(quodate);
		String quotationNo = box.getString(RequestConstants.QUOTATION_NO);
		int deptId = box.getInt("deptId");
		int hospitalId = box.getInt("hospitalId");
		String changedBy = box.getString(RequestConstants.CHANGED_BY);
		String currentTime = box.getString(RequestConstants.CHANGED_TIME);
		int vendorId = box.getInt(RequestConstants.VENDOR_ID);
		String remarks = box.getString(RequestConstants.REMARKS);

		suppHd.setId(hdId);
		suppHd.setDate(supplyDate);
		suppHd.setQuotationNo(quotationNo);
		suppHd.setQuotationDate(quotationDate);
		MasDepartment masDept = new MasDepartment();
		masDept.setId(deptId);
		suppHd.setDepartment(masDept);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		suppHd.setHospital(masHospital);
		suppHd.setLastChgBy(changedBy);
		suppHd.setLastChgTime(currentTime);
		MasVendor masVendor = new MasVendor();
		masVendor.setId(vendorId);
		suppHd.setVendor(masVendor);
		suppHd.setRemarks(remarks);

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<MlSupplyorderDetail> supplyDetailList = new ArrayList<MlSupplyorderDetail>();
			supplyDetailList = session
					.createCriteria(MlSupplyorderDetail.class).add(
							Restrictions.eq("SupplyHeader.Id", hdId)).list();
			hbt.deleteAll(supplyDetailList);

			Vector bookId = box.getVector("bookId");
			Vector author = box.getVector("author");
			Vector publisherId = box.getVector("publisherId");
			Vector publication = box.getVector("publication");
			Vector cost = box.getVector("cost");
			Vector edition = box.getVector("edition");

			for (int i = 0; i < bookId.size(); i++) {
				MlSupplyorderDetail mlSupply = new MlSupplyorderDetail();
				if (bookId.get(i) != null && !bookId.get(i).equals("")) {
					mlSupply.setSupplyHeader(suppHd);
					if (bookId.get(i) != null && !bookId.get(i).equals("")) {
						MasBook masBook = new MasBook();
						masBook.setId(Integer.parseInt((String) bookId.get(i)));
						mlSupply.setBook(masBook);
					}

					if (publisherId.get(i) != null
							&& !publisherId.get(i).equals("")) {
						MasPublisher maspub = new MasPublisher();
						maspub.setId(Integer.parseInt((String) publisherId
								.get(i)));
						mlSupply.setPublisher(maspub);
					}

					if (edition.get(i) != null && !edition.equals("")) {
						mlSupply.setEdition((String) edition.get(i));
					}
					BigDecimal cst = null;
					if (cost.get(i).toString() != null
							&& !cost.get(i).toString().equals("")) {
						cst = new BigDecimal(cost.get(i).toString());
					}

					if (cst != null && !cst.equals("")) {
						mlSupply.setCost(cst);
					}
					if (author.get(i) != null && !author.equals("")) {
						mlSupply.setAuthor((String) author.get(i));
					}
					if (publication != null && !publication.equals("")) {
						mlSupply
								.setPublicationYear((String) publication.get(i));
					}
					hbt.save(mlSupply);

				}
			}
			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	/**
	 * ---------------------- method for generating receipt no for journal
	 * receipt entry
	 */
	@SuppressWarnings("unchecked")
	public String generateJournalReceiptNumber(Map<String, Object> diagMap) {
		List<TransactionSequence> receiptList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String receiptNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		receiptList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "JRN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (receiptList.size() > 0) {
			for (TransactionSequence transactionSequence : receiptList)
				;
			{
				TransactionSequence obj = (TransactionSequence) receiptList
						.get(0);
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				hbt.update(transactionSequenceObj);

				receiptNo = receiptNo.concat(String.valueOf(seqNo));
				receiptNo = receiptNo.concat("/").concat(currentYear);
			}
		} else if (receiptList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("LibJournalReceiptEntryHd");
			tsObj.setTransactionPrefix("JRN");
			tsObj.setTransactionSequenceName("Journal Receipt Entry No");
			tsObj.setTransactionSequenceNumber(0);

			hbt.save(tsObj);
		}
		return receiptNo;
	}

	/**
	 * ------------------- method for submitting records in journal receipt
	 * entry
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitJournalReceiptEntry(Box box,
			Map<String, Object> dataMap) {
		System.out.println("submitJournalReceiptEntry   ");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		String receiptNo = box.getString(RequestConstants.RECEIPT_NO);
		String date = box.getString(RequestConstants.DATE);
		Date receiptDate = HMSUtil.convertStringTypeDateToDateType(date);
		String issueNo = box.getString(RequestConstants.ISSUE_NO);
		String year = box.getString(RequestConstants.YEAR);
		String month = box.getString(RequestConstants.MONTH);

		String chnDate = box.getString(RequestConstants.CHANGED_DATE);
		Date changedDate = HMSUtil.convertStringTypeDateToDateType(chnDate);
		String changedtime = box.getString(RequestConstants.CHANGED_TIME);
		String user = box.getString(RequestConstants.CHANGED_BY);
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");

		LibJournalReceiptEntryHd libHd = new LibJournalReceiptEntryHd();
		if (receiptNo != null) {
			libHd.setReceiptNo(receiptNo);
		}
		if (receiptDate != null) {
			libHd.setReceiptDate(receiptDate);
		}
		if (year != null && !year.equals("")) {
			libHd.setYear(year);
		}
		if (month != null && !month.equals("")) {
			libHd.setMonth(month);
		}
		if (issueNo != null) {
			libHd.setIssueNo(issueNo);
		}
		libHd.setLastChgBy(user);
		libHd.setLastChgDate(changedDate);
		libHd.setLastChgTime(changedtime);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		libHd.setHospital(masHospital);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		libHd.setDepartment(masDepartment);
		libHd.setStatusHd("y");

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(libHd);

			Vector srNo = box.getVector("SRNo");
			Vector bookId = box.getVector("bookId");
			Vector subject = box.getVector("subject");
			Vector quantity = box.getVector("quantity");

			for (int i = 0; i < bookId.size(); i++) {

				LibJournalReceiptEntryDt libdDt = new LibJournalReceiptEntryDt();

				if (bookId.get(i) != null && !bookId.get(i).equals("")) {
					libdDt.setReceipt(libHd);
					if (bookId.get(i) != null && !bookId.get(i).equals("")) {
						MasBook masBook = new MasBook();
						masBook.setId(Integer.parseInt((String) bookId.get(i)));
						libdDt.setBook(masBook);
					}

					if (subject.get(i) != null && !subject.equals("")) {
						libdDt.setSubject((String) subject.get(i));
					}

					if (quantity.get(i) != null && !quantity.equals("")) {
						libdDt.setQuantity(Integer.parseInt((String) quantity
								.get(i)));
					}
					if (srNo.get(i) != null && !srNo.equals("")) {
						libdDt.setSrNo(Integer.parseInt((String) srNo.get(i)));
					}
					hbt.save(libdDt);

				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	/**
	 * ----------- method to search for journal receipt entry
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getjournalReceiptGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LibJournalReceiptEntryDt> searchLibJournalList = new ArrayList<LibJournalReceiptEntryDt>();

		String receiptNo = "";
		String issueNo = "";
		String bookName = "";
		String accNo = "";

		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("receiptNo") != null) {
			receiptNo = (String) mapForDs.get("receiptNo");
		}

		if (mapForDs.get("issueNo") != null) {
			issueNo = (String) mapForDs.get("issueNo");
		}

		if (mapForDs.get("bookName") != null) {
			bookName = (String) mapForDs.get("bookName");
		}

		if (mapForDs.get("accNo") != null) {
			accNo = (String) mapForDs.get("accNo");
		}
		try {
			crit = session.createCriteria(LibJournalReceiptEntryDt.class)
					.createAlias("Receipt", "recHd").createAlias(
							"recHd.Department", "dept").add(
							Restrictions.eq("dept.Id", deptId));

			if (!receiptNo.equals("")) {
				crit = crit.add(Restrictions.like("recHd.ReceiptNo", receiptNo
						+ "%"));
			}
			if (!issueNo.equals("")) {
				crit = crit.add(Restrictions.like("recHd.IssueNo", issueNo
						+ "%"));
			}
			if (!bookName.equals("")) {
				crit = crit.createAlias("Book", "book").add(
						Restrictions.like("book.BookName", bookName + "%"));
			}
			if (!accNo.equals("")) {
				crit = crit.createAlias("Book", "book").add(
						Restrictions.like("book.BookNo", accNo + "%"));
			}

			searchLibJournalList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchLibJournalList", searchLibJournalList);
		System.out.println("searchLibJournalList  "
				+ searchLibJournalList.size());
		return map;
	}

	/**
	 * -------------------------------method to get details for journal detail
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getJournalDetail(Map<String, Object> dataMap) {
		List<LibJournalReceiptEntryDt> journalDtList = new ArrayList<LibJournalReceiptEntryDt>();
		Session session = (Session) getSession();
		int receiptId = 0;
		if (dataMap.get("receiptId") != null) {
			receiptId = (Integer) dataMap.get("receiptId");
		}
		journalDtList = session.createCriteria(LibJournalReceiptEntryDt.class)
				.createAlias("Receipt", "rec").add(
						Restrictions.eq("rec.Id", receiptId)).list();
		if (journalDtList != null && journalDtList.size() > 0) {
			dataMap.put("journalDtList", journalDtList);
		}

		return dataMap;

	}

	/**
	 * ---------------- method for edit journal receipt entry
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> updateJournalReceiptEntry(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		LibJournalReceiptEntryHd libHd = new LibJournalReceiptEntryHd();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		int hdId = box.getInt("hdId");
		// String receiptNo = box.getString(RequestConstants.RECEIPT_NO);
		String date = box.getString(RequestConstants.DATE);
		Date receiptDate = HMSUtil.convertStringTypeDateToDateType(date);
		int deptId = box.getInt("deptId");
		int hospitalId = box.getInt("hospitalId");
		String changedBy = box.getString(RequestConstants.CHANGED_BY);
		String currentTime = box.getString(RequestConstants.CHANGED_TIME);
		String year = box.getString(RequestConstants.YEAR);
		String month = box.getString(RequestConstants.MONTH);

		libHd.setId(hdId);
		// libHd.setReceiptNo(receiptNo);
		libHd.setReceiptDate(receiptDate);
		MasDepartment masDept = new MasDepartment();
		masDept.setId(deptId);
		libHd.setDepartment(masDept);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		libHd.setHospital(masHospital);
		libHd.setLastChgBy(changedBy);
		libHd.setLastChgTime(currentTime);
		libHd.setYear(year);
		libHd.setMonth(month);

		Transaction tx = null;
		try {


			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);


			List<LibJournalReceiptEntryDt> journalDetailList = new ArrayList<LibJournalReceiptEntryDt>();
			journalDetailList = session.createCriteria(	LibJournalReceiptEntryDt.class).add(Restrictions.eq("Receipt.Id", hdId)).list();
			hbt.deleteAll(journalDetailList);
			System.out.println("journalDetailList " + journalDetailList.size());

			Vector srNo = box.getVector(RequestConstants.SR_NO);
			Vector bookId = box.getVector("bookId");
			System.out.println("bookId.size()       " + bookId.size());
			Vector quantity = box.getVector("quantity");
			Vector subject = box.getVector("subject");
			for (int i = 0; i < bookId.size(); i++) {
				LibJournalReceiptEntryDt libdDt = new LibJournalReceiptEntryDt();
				if (bookId.get(i) != null && !bookId.get(i).equals("")) {
					System.out.println("bookId.get(i)   " + bookId.get(i));
					libdDt.setReceipt(libHd);
					if (bookId.get(i) != null && !bookId.get(i).equals("")) {
						MasBook masBook = new MasBook();
						masBook.setId(Integer.parseInt((String) bookId.get(i)));
						libdDt.setBook(masBook);
					}

					if (subject.get(i) != null && !subject.equals("")) {
						libdDt.setSubject((String) subject.get(i));
					}

					if (quantity.get(i) != null && !quantity.equals("")) {
						libdDt.setQuantity(Integer.parseInt((String) quantity
								.get(i)));
					}

					if (srNo.get(i) != null && !srNo.equals("")) {
						libdDt.setSrNo(Integer.parseInt((String) srNo.get(i)));
					}
					hbt.save(libdDt);

				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	/**
	 * -------------------- method for entry no for supply order no
	 */
	@SuppressWarnings("unchecked")
	public String getSupplyOrderEntryNo(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<MlSupplyorderHeader> seqNoList = new ArrayList<MlSupplyorderHeader>();
		String entryNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(MlSupplyorderHeader.class)
					.list();
			if (seqNoList.size() > 0) {
				for (MlSupplyorderHeader mlSupplyOrder : seqNoList) {
					lastSeqNo = mlSupplyOrder.getSupplyOrderNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "SOEN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear) && maxOrderNo != null) {
						entryNo = String.valueOf(maxOrderNo + 1);
					} else {
						entryNo = String.valueOf(1);
					}
				}
			} else {
				entryNo = String.valueOf(1);
			}

			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entryNo;
	}

	/**
	 * -------------------- method for receipt no for journal
	 */
	@SuppressWarnings("unchecked")
	public String getJournalReceiptNumber(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<LibJournalReceiptEntryHd> seqNoList = new ArrayList<LibJournalReceiptEntryHd>();
		String receiptNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(LibJournalReceiptEntryHd.class)
					.list();
			if (seqNoList.size() > 0) {
				for (LibJournalReceiptEntryHd libReceipt : seqNoList) {
					lastSeqNo = libReceipt.getReceiptNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "JRN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear) && maxOrderNo != null) {
						receiptNo = String.valueOf(maxOrderNo + 1);
					} else {
						receiptNo = String.valueOf(1);
					}
				}
			} else {
				receiptNo = String.valueOf(1);
			}

			receiptNo = receiptNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return receiptNo;
	}

	/**
	 * -------------- methods to show CRV
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showCrv(Box box, Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVendor> vendorList = new ArrayList<MasVendor>();
		List<MasBook> bookList = new ArrayList<MasBook>();
		List<MlSupplyorderHeader> mlSupplyorderHeaderList = new ArrayList<MlSupplyorderHeader>();

		session = (Session) getSession();

		try {
		/*	vendorList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasVendor as mv order by mv.VendorName");
		*/
			vendorList = session.createCriteria(MasVendor.class).add(Restrictions.eq("Status", "y")).list();
			mlSupplyorderHeaderList = session.createQuery("from MlSupplyorderHeader as mso order by mso.SupplyOrderNo ").list();
			bookList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasBook as mi where mi.Status = 'y'");

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("mlSupplyorderHeaderList",mlSupplyorderHeaderList);
		map.put("vendorList", vendorList);
		map.put("bookList", bookList);
		return map;

	}
	public Map<String, Object> journalReceipt(Box box, Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBook> bookList = new ArrayList<MasBook>();
		List<LibJournalReceiptEntryHd> libJournalReceiptEntryHdList = new ArrayList<LibJournalReceiptEntryHd>();

		session = (Session) getSession();

		try {
		/*	vendorList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasVendor as mv order by mv.VendorName");
		*/

			libJournalReceiptEntryHdList = session.createQuery("from LibJournalReceiptEntryHd as mso order by mso.ReceiptNo ").list();
			bookList = getHibernateTemplate().find("from jkt.hms.masters.business.MasBook as mi where mi.Status = 'y'");

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("mlSupplyorderHeaderList",libJournalReceiptEntryHdList);
		map.put("bookList", bookList);
		return map;

	}
	/**
	 * ------------------- method to generate CRV No
	 */
	@SuppressWarnings("unchecked")
	public String generateCRVNumber(Map<String, Object> diagMap) {
		List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
		List<LibCrvHd> seqNoList = new ArrayList<LibCrvHd>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		String crvNo = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(LibCrvHd.class).list();
		if (seqNoList.size() > 0) {
			for (LibCrvHd mlSupply : seqNoList) {
				lastSeqNo = mlSupply.getCrvNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		yearlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "CRV")).list();

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
				crvNo = crvNo.concat("/").concat(String.valueOf(lastSeqYear));
			}
			System.out.println("crvNo in ds : " + crvNo);
		} else if (yearlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("LibCrvHd");
			tsObj.setTransactionPrefix("CRV");
			tsObj.setTransactionSequenceName("LibCrvNo");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			crvNo = crvNo.concat("/").concat(String.valueOf(lastSeqYear));
		}
		return crvNo;
	}

	@SuppressWarnings("unchecked")
	public String getCRVNo(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<LibCrvHd> seqNoList = new ArrayList<LibCrvHd>();
		String crvNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(LibCrvHd.class).list();
			if (seqNoList.size() > 0) {
				for (LibCrvHd crvHd : seqNoList) {
					lastSeqNo = crvHd.getCrvNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "CRV"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear) && maxOrderNo != null) {
						crvNo = String.valueOf(maxOrderNo + 1);
					} else {
						crvNo = String.valueOf(1);
					}
				}
			} else {
				crvNo = String.valueOf(1);
			}

			crvNo = crvNo.concat("/").concat(String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return crvNo;
	}

	/**
	 * ----------------------- method to add crv
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitLibCrv(Box box, Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		String crvNo = box.getString(RequestConstants.CRV);
		String accessionNo = box.getString(RequestConstants.ACCESSION_NO);
		String date = box.getString(RequestConstants.DATE);
		Date crvDate = HMSUtil.convertStringTypeDateToDateType(date);
		String src = box.getString(RequestConstants.SOURCE_OF_RECIEPT);
		int vendorId = box.getInt(RequestConstants.VENDOR_ID);
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");
		String billNo = box.getString(RequestConstants.BILL_NO);
		String blldate = box.getString(RequestConstants.BILL_DATE);
		Date billDate = HMSUtil.convertStringTypeDateToDateType(blldate);
		BigDecimal billAmount = null;
		billAmount = (BigDecimal) dataMap.get("billAmount");
		BigDecimal totalAmount = null;
		totalAmount = (BigDecimal) dataMap.get("totalAmount");
		String changeddate = box.getString(RequestConstants.CHANGED_DATE);
		Date changedDate = HMSUtil.convertStringTypeDateToDateType(changeddate);
		String changedtime = box.getString(RequestConstants.CHANGED_TIME);
		String user = box.getString(RequestConstants.CHANGED_BY);

		LibCrvHd libCrvHd = new LibCrvHd();

		libCrvHd.setCrvNo(crvNo);
		if (accessionNo != null && !accessionNo.equals("")) {
			libCrvHd.setAccessionNo(accessionNo);
		}
		if (billNo != null && !billNo.equals("")) {
			libCrvHd.setBillNo(billNo);
		}
		libCrvHd.setCrvDate(crvDate);
		libCrvHd.setBillDate(billDate);
		if (vendorId != 0) {
			MasVendor masVendor = new MasVendor();
			masVendor.setId(vendorId);
			libCrvHd.setVendor(masVendor);
		}
		libCrvHd.setSourceOfReceipt(src);
		libCrvHd.setBillAmount(billAmount);
		libCrvHd.setTotalAmount(totalAmount);
		libCrvHd.setLastChgBy(user);
		libCrvHd.setLastChgDate(changedDate);
		libCrvHd.setLastChgTime(changedtime);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		libCrvHd.setHospital(masHospital);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		libCrvHd.setDepartment(masDepartment);
		libCrvHd.setStatus("y");

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(libCrvHd);

			Vector bookId = box.getVector("bookId");
			Vector quantity = box.getVector("quantity");
			Vector price = box.getVector("price");
			Vector discount = box.getVector("discount");
			Vector tax = box.getVector("tax");
			Vector amount = box.getVector("amount");
			Vector pageNo = box.getVector("pageNo");
			Vector volume = box.getVector("volume");
			for (int i = 0; i < bookId.size(); i++) {

				LibCrvDt libCrvdt = new LibCrvDt();

				if (bookId.get(i) != null && !bookId.get(i).equals("")) {
					libCrvdt.setCrvHd(libCrvHd);

					if (bookId.get(i) != null && !bookId.get(i).equals("")) {
						MasBook masBook = new MasBook();
						masBook.setId(Integer.parseInt((String) bookId.get(i)));
						libCrvdt.setBook(masBook);
					}

					BigDecimal cst = null;
					if (price.get(i).toString() != null
							&& !price.get(i).toString().equals("")) {
						cst = new BigDecimal(price.get(i).toString());
					}

					if (cst != null && !cst.equals("")) {
						libCrvdt.setPrice(cst);
					}

					BigDecimal dscnt = null;
					if (discount.get(i).toString() != null
							&& !discount.get(i).toString().equals("")) {
						dscnt = new BigDecimal(discount.get(i).toString());
					}

					if (dscnt != null && !dscnt.equals("")) {
						libCrvdt.setDiscount(dscnt);
					}

					if (quantity.get(i).toString() != null
							&& !quantity.get(i).toString().equals("")) {
						libCrvdt.setQuantity(Integer.parseInt(quantity.get(i)
								.toString()));
					}
					if (pageNo.get(i).toString() != null
							&& !pageNo.get(i).toString().equals("")) {
						libCrvdt.setPageNo(Integer.parseInt(pageNo.get(i)
								.toString()));
					}
					BigDecimal vlm = null;
					if (volume.get(i).toString() != null
							&& !volume.get(i).toString().equals("")) {
						vlm = new BigDecimal(volume.get(i).toString());
					}
					if (vlm != null && !vlm.equals("")) {
						libCrvdt.setVolume(vlm);
					}
					BigDecimal amnt = null;
					if (amount.get(i).toString() != null
							&& !amount.get(i).toString().equals("")) {
						amnt = new BigDecimal(amount.get(i).toString());
					}
					if (amnt != null && !amnt.equals("")) {
						libCrvdt.setAmount(amnt);
					}
					BigDecimal tax1 = null;
					if (tax.get(i).toString() != null
							&& !tax.get(i).toString().equals("")) {
						tax1 = new BigDecimal(tax.get(i).toString());
					}
					if (tax1 != null && !tax1.equals("")) {
						libCrvdt.setTax(tax1);
					}

					hbt.save(libCrvdt);
				}
				// Update Stock in Item Batch Stock
				// for All Items
				int booknameId = 0;
				booknameId = libCrvdt.getBook().getId();
				List<LibBookStock> libStockList = new ArrayList<LibBookStock>();
				LibBookStock libBookStock = null;
				libStockList = hbt
						.find("from jkt.hms.masters.business.LibBookStock as inp where inp.Book.Id ="
								+ booknameId);
				if (libStockList != null && libStockList.size() > 0) {
					libBookStock = libStockList.get(0);
					int id = libBookStock.getId();
					libBookStock = (LibBookStock) hbt.load(LibBookStock.class,
							id);

					Integer existing_qty = 0;
					Integer recd_qty = 0;
					BigDecimal recQty = new BigDecimal(0);
					BigDecimal crv_amount = new BigDecimal(0);
					Integer new_qty = 0;
					BigDecimal cost = new BigDecimal(0);
					BigDecimal tot_cost = new BigDecimal(0);

					if (libBookStock.getReceiptQty() != null
							&& libBookStock.getReceiptQty() != 0) {
						existing_qty = libBookStock.getReceiptQty();
					}
					if (libCrvdt.getQuantity() != null
							&& libCrvdt.getQuantity() != 0) {
						recd_qty = libCrvdt.getQuantity();
					}

					if (recd_qty != null) {
						recQty = new BigDecimal(recd_qty);
					}
					new_qty = existing_qty + recd_qty;

					if (libCrvdt.getAmount() != null) {
						crv_amount = libCrvdt.getAmount();
					}
					cost = crv_amount.divide(recQty);
					tot_cost = cost.add(libBookStock.getCost());

					libBookStock.setReceiptQty(recd_qty);
					libBookStock.setClosingStockQty(new_qty);
					libBookStock.setCost(tot_cost);
					libBookStock.setLastChgBy(libCrvHd.getLastChgBy());
					libBookStock.setLastChgDate(libCrvHd.getLastChgDate());
					libBookStock.setLastChgTime(libCrvHd.getLastChgTime());
					libBookStock.setHospital(libCrvHd.getHospital());

					HibernateTemplate hbt1 = getHibernateTemplate();
					hbt1.setFlushModeName("FLUSH_EAGER");
					hbt1.setCheckWriteOperations(false);
					hbt1.update(libBookStock);
				} else {
					LibBookStock lib = new LibBookStock();
					lib.setBook(libCrvdt.getBook());
					Integer recd_qty = 0;
					BigDecimal recQty = new BigDecimal(0);
					BigDecimal crv_amount = new BigDecimal(0);
					BigDecimal cost = new BigDecimal(0);

					if (libCrvdt.getQuantity() != null
							&& libCrvdt.getQuantity() != 0) {
						recd_qty = libCrvdt.getQuantity();
					}

					if (recd_qty != null) {
						recQty = new BigDecimal(recd_qty);
					}
					if (libCrvdt.getAmount() != null) {
						crv_amount = libCrvdt.getAmount();
					}

					cost = crv_amount.divide(recQty, new MathContext(4,
							RoundingMode.UP));

					if (recd_qty != null) {
						lib.setReceiptQty(libCrvdt.getQuantity());
						lib.setClosingStockQty(libCrvdt.getQuantity());
					}

					lib.setCost(cost);
					lib.setLastChgBy(libCrvHd.getLastChgBy());
					lib.setLastChgDate(libCrvHd.getLastChgDate());
					lib.setLastChgTime(libCrvHd.getLastChgTime());
					lib.setHospital(libCrvHd.getHospital());

					HibernateTemplate hbt2 = getHibernateTemplate();
					hbt2.setFlushModeName("FLUSH_EAGER");
					hbt2.setCheckWriteOperations(false);
					hbt2.save(lib);
					hbt2.refresh(lib);
				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}

		map.put("saved", saved);
		return map;
	}

	/**
	 * ----------- method to search for crv
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCrvGrid(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LibCrvDt> searchCrvList = new ArrayList<LibCrvDt>();

		String crvNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("crvNo") != null) {
			crvNo = (String) mapForDs.get("crvNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		try {
			crit = session.createCriteria(LibCrvDt.class).createAlias("CrvHd",
					"crvHd").add(
					Restrictions.between("crvHd.CrvDate", fromDate, toDate))
					.createAlias("crvHd.Department", "dept").add(
							Restrictions.eq("dept.Id", deptId));

			if (!crvNo.equals("")) {
				crit = crit.add(Restrictions.like("crvHd.CrvNo", crvNo + "%"));
			}

			searchCrvList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchCrvList", searchCrvList);
		System.out.println("searchCrvList  " + searchCrvList.size());
		return map;
	}

	/**
	 * --------------- method to get list from crv update
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getCRVDetails(Map<String, Object> dataMap) {
		List<LibCrvDt> crvDtList = new ArrayList<LibCrvDt>();
		Session session = (Session) getSession();
		int crvId = 0;
		if (dataMap.get("crvId") != null) {
			crvId = (Integer) dataMap.get("crvId");
		}
		crvDtList = session.createCriteria(LibCrvDt.class).createAlias("CrvHd",
				"sh").add(Restrictions.eq("sh.Id", crvId)).list();

		if (crvDtList != null && crvDtList.size() > 0) {
			dataMap.put("crvDtList", crvDtList);
		}

		return dataMap;

	}

	/**
	 * ---------------methods for update crv
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> updateLibCrv(Box box, Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		LibCrvHd libCrvHd = new LibCrvHd();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		int hdId = box.getInt("hdId");

		String crvNo = box.getString(RequestConstants.CRV);
		String accessionNo = box.getString(RequestConstants.ACCESSION_NO);
		String date = box.getString(RequestConstants.DATE);
		Date crvDate = HMSUtil.convertStringTypeDateToDateType(date);
		String src = box.getString(RequestConstants.SOURCE_OF_RECIEPT);
		int vendorId = box.getInt(RequestConstants.VENDOR_ID);
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");
		String billNo = box.getString(RequestConstants.BILL_NO);
		String blldate = box.getString(RequestConstants.BILL_DATE);
		Date billDate = HMSUtil.convertStringTypeDateToDateType(blldate);
		BigDecimal billAmount = null;
		billAmount = (BigDecimal) dataMap.get("billAmount");
		BigDecimal totalAmount = null;
		totalAmount = (BigDecimal) dataMap.get("totalAmount");
		String changeddate = box.getString(RequestConstants.CHANGED_DATE);
		Date changedDate = HMSUtil.convertStringTypeDateToDateType(changeddate);
		String changedtime = box.getString(RequestConstants.CHANGED_TIME);
		String user = box.getString(RequestConstants.CHANGED_BY);

		libCrvHd.setId(hdId);
		libCrvHd.setCrvDate(crvDate);
		libCrvHd.setCrvNo(crvNo);
		if (accessionNo != null && !accessionNo.equals("")) {
			libCrvHd.setAccessionNo(accessionNo);
		}
		if (billNo != null && !billNo.equals("")) {
			libCrvHd.setBillNo(billNo);
		}
		libCrvHd.setCrvDate(crvDate);
		libCrvHd.setBillDate(billDate);
		if (vendorId != 0) {
			MasVendor masVendor = new MasVendor();
			masVendor.setId(vendorId);
			libCrvHd.setVendor(masVendor);
		}
		libCrvHd.setSourceOfReceipt(src);
		libCrvHd.setBillAmount(billAmount);
		libCrvHd.setTotalAmount(totalAmount);
		libCrvHd.setLastChgBy(user);
		libCrvHd.setLastChgDate(changedDate);
		libCrvHd.setLastChgTime(changedtime);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		libCrvHd.setHospital(masHospital);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		libCrvHd.setDepartment(masDepartment);
		libCrvHd.setStatus("y");

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<LibCrvDt> crvDetailList = new ArrayList<LibCrvDt>();
			crvDetailList = session.createCriteria(LibCrvDt.class).add(
					Restrictions.eq("CrvHd.Id", hdId)).list();
			hbt.deleteAll(crvDetailList);

			Vector bookId = box.getVector("bookId");
			Vector quantity = box.getVector("quantity");
			Vector price = box.getVector("price");
			Vector discount = box.getVector("discount");
			Vector tax = box.getVector("tax");
			Vector amount = box.getVector("amount");
			Vector pageNo = box.getVector("pageNo");
			Vector volume = box.getVector("volume");

			for (int i = 0; i < bookId.size(); i++) {
				LibCrvDt mlSupply = new LibCrvDt();
				if (bookId.get(i) != null && !bookId.get(i).equals("")) {
					mlSupply.setCrvHd(libCrvHd);
					if (bookId.get(i) != null && !bookId.get(i).equals("")) {
						MasBook masBook = new MasBook();
						masBook.setId(Integer.parseInt((String) bookId.get(i)));
						mlSupply.setBook(masBook);
					}
					BigDecimal cst = null;
					if (price.get(i).toString() != null
							&& !price.get(i).toString().equals("")) {
						cst = new BigDecimal(price.get(i).toString());
					}

					if (cst != null && !cst.equals("")) {
						mlSupply.setPrice(cst);
					}

					BigDecimal dscnt = null;
					if (discount.get(i).toString() != null
							&& !discount.get(i).toString().equals("")) {
						dscnt = new BigDecimal(discount.get(i).toString());
					}

					if (dscnt != null && !dscnt.equals("")) {
						mlSupply.setDiscount(dscnt);
					}

					if (quantity.get(i).toString() != null
							&& !quantity.get(i).toString().equals("")) {
						mlSupply.setQuantity(Integer.parseInt(quantity.get(i)
								.toString()));
					}
					if (pageNo.get(i).toString() != null
							&& !pageNo.get(i).toString().equals("")) {
						mlSupply.setPageNo(Integer.parseInt(pageNo.get(i)
								.toString()));
					}
					BigDecimal vlm = null;
					if (volume.get(i).toString() != null
							&& !volume.get(i).toString().equals("")) {
						vlm = new BigDecimal(volume.get(i).toString());
					}
					if (vlm != null && !vlm.equals("")) {
						mlSupply.setVolume(vlm);
					}
					BigDecimal amnt = null;
					if (amount.get(i).toString() != null
							&& !amount.get(i).toString().equals("")) {
						amnt = new BigDecimal(amount.get(i).toString());
					}
					if (amnt != null && !amnt.equals("")) {
						mlSupply.setAmount(amnt);
					}
					BigDecimal tax1 = null;
					if (tax.get(i).toString() != null
							&& !tax.get(i).toString().equals("")) {
						tax1 = new BigDecimal(tax.get(i).toString());
					}
					if (tax1 != null && !tax1.equals("")) {
						mlSupply.setTax(tax1);
					}
					hbt.save(mlSupply);

				}
			}
			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	// -------------------Methods By Dipali----
	public Map<String, Object> fillServiceDetail(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			String str = "" + dataMap.get("serviceNo");
			Criteria c = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("ServiceNo", str)).add(
					Restrictions.like("Status", "y"));
			employeeList = c.list();
			dataMap.put("employeeList", employeeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBookIssueJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> issuedByList = new ArrayList<MasEmployee>();

		issuedByList = session.createCriteria(MasEmployee.class).add(
				Restrictions.like("Status", "y")).createAlias("Department",
				"dept").createAlias("dept.DepartmentType", "deptType").add(
				Restrictions.eq("deptType.Id", 24)).list();
		map.put("issuedByList", issuedByList);
		return map;
	}

	public String getIssueSeqNoForDisplay(String string) {

		List<Integer> issueSeqNoList = new ArrayList<Integer>();
		List<LibBookIssueHeader> seqNoList = new ArrayList<LibBookIssueHeader>();
		String issueSeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session.createCriteria(LibBookIssueHeader.class).list();
			if (seqNoList.size() > 0) {
				for (LibBookIssueHeader bookIssueHeader : seqNoList) {
					lastSeqNo = bookIssueHeader.getIssueNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			issueSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "BEN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (issueSeqNoList.get(0) == null || issueSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("LibBookIssueHeader");
				tsObj.setTransactionPrefix("BEN");
				tsObj.setTransactionSequenceName("Book Issue No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				issueSeqNo = String.valueOf(1);
			} else if (issueSeqNoList.size() > 0) {
				for (Integer maxOrderNo : issueSeqNoList) {
					if (currentYear.equals(lastSeqYear) && maxOrderNo != null) {
						issueSeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						issueSeqNo = String.valueOf(1);
					}
				}
			}
			issueSeqNo = issueSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return issueSeqNo;
	}

	public String generateBookIssueNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String issueSeqNo = "";
		List<TransactionSequence> issueSeqNoList = new ArrayList<TransactionSequence>();
		List<LibBookIssueHeader> seqNoList = new ArrayList<LibBookIssueHeader>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(LibBookIssueHeader.class).list();
		if (seqNoList.size() > 0) {
			for (LibBookIssueHeader bookIssueHeader : seqNoList) {
				lastSeqNo = bookIssueHeader.getIssueNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		issueSeqNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "BEN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (issueSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : issueSeqNoList) {
				TransactionSequence obj = (TransactionSequence) issueSeqNoList
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
				issueSeqNo = issueSeqNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (issueSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("LibBookIssueHeader");
			tsObj.setTransactionPrefix("BEN");
			tsObj.setTransactionSequenceName("Book Issue No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			issueSeqNo = issueSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return issueSeqNo;
	}

	@SuppressWarnings("unchecked")
	public boolean submitBookIssue(Map<String, Object> infoMap) {
		LibBookIssueHeader bookIssueHeader = new LibBookIssueHeader();
		String userName = "";
		boolean saved = false;
		boolean flag = false;

		List bookList = new ArrayList();
		List bookIssueDetailIdList = new ArrayList();
		List qtyList = new ArrayList();

		int employeeId = 0;
		int hospitalId = 0;
		@SuppressWarnings("unused")
		int issuedBy = 0;

		if (infoMap.get("bookIssueHeader") != null) {
			bookIssueHeader = (LibBookIssueHeader) infoMap
					.get("bookIssueHeader");
		}

		if (infoMap.get("employeeId") != null) {
			employeeId = (Integer) infoMap.get("employeeId");
		}
		if (infoMap.get("issuedBy") != null) {
			issuedBy = (Integer) infoMap.get("issuedBy");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("bookIssueDetailIdList") != null) {
			bookIssueDetailIdList = (List) infoMap.get("bookIssueDetailIdList");
		}
		if (infoMap.get("qtyList") != null) {
			qtyList = (List) infoMap.get("qtyList");
		}
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		@SuppressWarnings("unused")
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
		try {
			hbt.save(bookIssueHeader);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		try {
			if (infoMap.get("bookList") != null) {
				bookList = (List) infoMap.get("bookList");
				System.out.println("book size :"+bookList.size());
				try {
					if (bookList.size() > 0) {
						for (int i = 0; i < bookList.size(); i++) {
							LibBookIssueDetail bookIssueDetail = new LibBookIssueDetail();
							MasBook masBook = new MasBook();
							System.out.println("in for loop ");
							System.out.println("bookList.get(i) befor if :"+bookList.get(i));
							if (bookList.get(i) != null	&& !bookList.get(i).equals("")) {
								System.out.println("bookList.get(i) after if :"+bookList.get(i));
								int bookId = Integer.parseInt(bookList.get(i).toString());
								System.out.println("bookId :"+bookId);
								masBook.setId(bookId);

								bookIssueDetail.setBook(masBook);
								bookIssueDetail.setStatus("i");
								bookIssueDetail.setIssueHd(bookIssueHeader);

								if (qtyList.get(i) != null
										&& !qtyList.get(i).equals("")) {
									int quantity = Integer.parseInt(qtyList.get(i).toString());
									bookIssueDetail.setQuantity(quantity);
								}

								hbt.save(bookIssueDetail);

								try {
									LibBookStock bookStock = (LibBookStock) getHibernateTemplate()
											.load(LibBookStock.class, bookId);
									bookStock.setIssueQty(bookIssueDetail
											.getQuantity());
									hbt.saveOrUpdate(bookStock);
								} catch (RuntimeException e) {
									e.printStackTrace();
								}
							}
						}
					}
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
			}
			saved = true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return saved;
	}

	public Map<String, Object> showSearchBookIssue() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBook> bookList = new ArrayList<MasBook>();
		try {

			bookList = session.createCriteria(MasBook.class).add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("bookList", bookList);

		return map;
	}

	public Map<String, Object> searchUpdateBookIssueJsp(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LibBookIssueHeader> bookHdList = new ArrayList<LibBookIssueHeader>();
		String serviceNo = "";
		String issueNo = "";
		@SuppressWarnings("unused")
		Date issueDate = null;
		int bookIssueHdId = 0;
		Session session = (Session) getSession();
		if (mapForDs.get("issueNo") != null) {
			issueNo = (String) mapForDs.get("issueNo");
		}

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("issueDate") != null) {
			issueDate = (Date) mapForDs.get("issueDate");
		}

		if (mapForDs.get("bookIssueHdId") != null) {
			bookIssueHdId = (Integer) mapForDs.get("bookIssueHdId");
		}
		Criteria crit = session.createCriteria(LibBookIssueHeader.class);

		if (!issueNo.equals("")) {
			crit = crit.add(Restrictions.eq("IssueNo", issueNo));
		}

		if (!serviceNo.equals("")) {
			crit = crit.createAlias("Employee", "emp").add(Restrictions.like("emp.ServiceNo", serviceNo + "%"));
		}
		if (issueDate != null) {
			crit = crit.add(Restrictions.eq("IssueDate", issueDate));
		}


		bookHdList = crit.list();
		System.out.println("bookHdList in db-->"+bookHdList.size());
		map.put("bookHdList", bookHdList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUpdateBlookissue(int bookIssueHdId) {
		System.out.println("in showUpdateBloodissue method ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		LibBookIssueHeader bookIssueHeader = new LibBookIssueHeader();

		List<LibBookIssueHeader> bookIssueHdList = new ArrayList<LibBookIssueHeader>();
		List<LibBookIssueDetail> bookIssueDtList = new ArrayList<LibBookIssueDetail>();
		List<MasEmployee> issuedByList = new ArrayList<MasEmployee>();

		bookIssueHeader = (LibBookIssueHeader) session.load(LibBookIssueHeader.class, bookIssueHdId);
		bookIssueHdList.add(bookIssueHeader);

		bookIssueDtList = session.createCriteria(LibBookIssueDetail.class).add(Restrictions.eq("IssueHd.Id", bookIssueHdId)).list();

		issuedByList = session.createCriteria(MasEmployee.class).add(
				Restrictions.like("Status", "y")).createAlias("Department","dept").createAlias("dept.DepartmentType", "deptType").add(
				Restrictions.eq("deptType.Id", 24)).list();

		map.put("issuedByList", issuedByList);
		map.put("bookIssueHdList", bookIssueHdList);
		map.put("bookIssueDtList", bookIssueDtList);
		return map;
	}

	public boolean updateBookIssue(Box box) {
		System.out.println("box   :" + box);
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<LibBookIssueHeader> issueHdList = session.createCriteria(LibBookIssueHeader.class).list();
			LibBookIssueHeader issueHdObj = (LibBookIssueHeader) issueHdList.get(0);
			int issueHdId = issueHdObj.getId();
			LibBookIssueHeader bookIssueHeader = (LibBookIssueHeader) hbt.load(LibBookIssueHeader.class, issueHdId);

			if (box.getString("issueDate") != null	&& !box.getString("issueDate").equals(""))
				bookIssueHeader.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString("issueDate")));

			MasEmployee issuedBy = new MasEmployee();
			if (box.getString("issuedBy") != null
					&& !box.getString("issuedBy").equals(""))
				issuedBy.setId(Integer.parseInt(box.getString("issuedBy")));
			bookIssueHeader.setIssuedBy(issuedBy);

			MasEmployee masEmployee = new MasEmployee();
			if (box.getString("employeeId") != null
					&& !box.getString("employeeId").equals(""))
				masEmployee
						.setId(Integer.parseInt(box.getString("employeeId")));
			bookIssueHeader.setEmployee(masEmployee);

			bookIssueHeader.setLastChgBy(box.getString("changed_by"));
			bookIssueHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changed_date")));
			bookIssueHeader.setLastChgTime(box.getString("changed_time"));
			hbt.update(bookIssueHeader);

			int bookIssueHdId = bookIssueHeader.getId();
			List<LibBookIssueDetail> bookIssueDtList = session.createCriteria(LibBookIssueDetail.class).add(Restrictions.eq("IssueHd.Id", bookIssueHdId)).list();
			hbt.deleteAll(bookIssueDtList);

				Vector bookId = box.getVector("bookId");
				Vector quantity = box.getVector("quantity");
				System.out.println("book id   :" + box.getVector("bookId"));
				System.out.println("quantity id   :" + box.getVector("quantity"));
				System.out.println("bookId.size()   :" + bookId.size());
				for (int i = 0; i < bookId.size(); i++) {
					if (bookId.get(i) != null && !bookId.get(i).equals("")) {
						LibBookIssueDetail bookIssueDetail = new LibBookIssueDetail();

						bookIssueDetail.setIssueHd(new LibBookIssueHeader(bookIssueHdId));

						if (bookId.get(i) != null	&& !bookId.get(i).equals("")) {
							MasBook masBook = new MasBook();
							masBook.setId(Integer.parseInt((String) bookId.get(i)));
							bookIssueDetail.setBook(masBook);
						}
						if (quantity.get(i) != null && !quantity.get(i).equals("")) {
							bookIssueDetail.setQuantity((Integer) quantity.get(i));
						}
						hbt.save(bookIssueDetail);

					}
				}

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;
	}

	public Map<String, Object> showSearchBookReturnJs() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBook> bookList = new ArrayList<MasBook>();
		try {

			bookList = session.createCriteria(MasBook.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("bookList", bookList);

		return map;
	}

	public String getReturnSeqNoForDisplay() {
		List<Integer> returnSeqNoList = new ArrayList<Integer>();
		List<LibBookReturnHd> seqNoList = new ArrayList<LibBookReturnHd>();
		String returnSeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session.createCriteria(LibBookReturnHd.class).list();
			if (seqNoList.size() > 0) {
				for (LibBookReturnHd bookReturnHd : seqNoList) {
					lastSeqNo = bookReturnHd.getReturnNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			returnSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "BRN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (returnSeqNoList.get(0) == null || returnSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("LibBookReturnHd");
				tsObj.setTransactionPrefix("BRN");
				tsObj.setTransactionSequenceName("Book Return No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				returnSeqNo = String.valueOf(1);
			} else if (returnSeqNoList.size() > 0) {
				for (Integer maxOrderNo : returnSeqNoList) {
					if (currentYear.equals(lastSeqYear) && maxOrderNo != null) {
						returnSeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						returnSeqNo = String.valueOf(1);
					}
				}
			} else {
				returnSeqNo = String.valueOf(1);
			}
			returnSeqNo = returnSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return returnSeqNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBookReturnJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> receiveByList = new ArrayList<MasEmployee>();

		receiveByList = session.createCriteria(MasEmployee.class).add(Restrictions.like("Status", "y")).createAlias("Department","dept").createAlias("dept.DepartmentType", "deptType").add(Restrictions.eq("deptType.Id", 24)).list();
		map.put("receiveByList", receiveByList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillIssueDetail(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		List<LibBookIssueHeader> issueHdList = new ArrayList<LibBookIssueHeader>();
		try {
			String str = "" + dataMap.get("issueNo");
			Criteria c = session.createCriteria(LibBookIssueHeader.class).add(
					Restrictions.eq("IssueNo", str));
			issueHdList = c.list();
			dataMap.put("issueHdList", issueHdList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataMap;
	}

	@SuppressWarnings("unchecked")
	public List<LibBookIssueDetail> fillIssueBookDetail(String issueNo) {
		List<LibBookIssueDetail> issueDtList = new ArrayList<LibBookIssueDetail>();
		Session session = (Session) getSession();
		try {
			issueDtList = session.createCriteria(LibBookIssueDetail.class).add(
					Restrictions.eq("Status", "i"))
					.createAlias("IssueHd", "hd").add(
							Restrictions.eq("hd.IssueNo", issueNo)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return issueDtList;
	}

	public String generateBookReturnNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String returnSeqNo = "";
		List<TransactionSequence> returnSeqNoList = new ArrayList<TransactionSequence>();
		List<LibBookReturnHd> seqNoList = new ArrayList<LibBookReturnHd>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(LibBookReturnHd.class).list();
		if (seqNoList.size() > 0) {
			for (LibBookReturnHd bookReturnHd : seqNoList) {
				lastSeqNo = bookReturnHd.getReturnNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		returnSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "BRN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (returnSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : returnSeqNoList) {
				TransactionSequence obj = (TransactionSequence) returnSeqNoList
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
				returnSeqNo = returnSeqNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (returnSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("LibBookReturnHd");
			tsObj.setTransactionPrefix("BRN");
			tsObj.setTransactionSequenceName("Book Return No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			returnSeqNo = returnSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return returnSeqNo;
	}



	public Map<String, Object> searchUpdateBookReturnJsp(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LibBookReturnHd> bookHdList = new ArrayList<LibBookReturnHd>();
		String serviceNo = "";
		String returnNo = "";
		@SuppressWarnings("unused")
		Date returnDate = null;
		int bookReturnHdId = 0;
		Session session = (Session) getSession();
		if (mapForDs.get("returnNo") != null) {
			returnNo = (String) mapForDs.get("returnNo");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("returnDate") != null) {
			returnDate = (Date) mapForDs.get("returnDate");
		}

		if (mapForDs.get("bookReturnHdId") != null) {
			bookReturnHdId = (Integer) mapForDs.get("bookReturnHdId");
		}
		Criteria crit = session.createCriteria(LibBookReturnHd.class);

		if (!returnNo.equals("")) {
			crit = crit.add(Restrictions.eq("ReturnNo", returnNo));
		}

		/*
		 * if (!serviceNo.equals("")) { crit = crit.createAlias("Employee",
		 * "emp").add(Restrictions.eq("emp.ServiceNo", serviceNo + "%")); }
		 */
		if (returnDate != null) {
			crit = crit.add(Restrictions.eq("returnDate", returnDate));
		}

		bookHdList = crit.list();
		map.put("bookHdList", bookHdList);
		return map;
	}

	public Map<String, Object> showSearchBookReturn() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showUpdateBookReturn(int bookReturnHdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		LibBookReturnHd bookReturnHd = new LibBookReturnHd();

		List<LibBookReturnHd> bookReturnHdList = new ArrayList<LibBookReturnHd>();
		List<LibBookReturnDt> bookReturnDtList = new ArrayList<LibBookReturnDt>();
		List<MasEmployee> receiveByList = new ArrayList<MasEmployee>();

		bookReturnHd = (LibBookReturnHd) session.load(LibBookReturnHd.class,
				bookReturnHdId);
		bookReturnHdList.add(bookReturnHd);
		bookReturnDtList = session.createCriteria(LibBookReturnDt.class).add(
				Restrictions.eq("ReturnHd.Id", bookReturnHdId)).list();
		receiveByList = session.createCriteria(MasEmployee.class).add(
				Restrictions.like("Status", "y")).createAlias("Department",
				"dept").createAlias("dept.DepartmentType", "deptType").add(
				Restrictions.eq("deptType.Id", 24)).list();

		map.put("receiveByList", receiveByList);
		map.put("bookReturnHdList", bookReturnHdList);
		map.put("bookReturnDtList", bookReturnDtList);
		return map;
	}
/*public Map<String, Object> updateBookReturn(Box box,Map<String, Object> dataMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	LibBookReturnHd libhd = new LibBookReturnHd();
	boolean saved = false;
	Session session = (Session) getSession();
	if (dataMap.get("box") != null) {
		box = (Box) dataMap.get("box");
	}
	int hdId = box.getInt("hdId");



	//String returnNo = box.getString(RequestConstants.RETURN_NO);

	String date = box.getString(RequestConstants.RETURN_DATE);
	Date returnDate = HMSUtil.convertStringTypeDateToDateType(date);
	int emplyeeReceivedBy=box.getInt(RequestConstants.ISSUED_BY);
	//int employeeId=box.getInt(RequestConstants.EMPLOYEE_ID);
	int hospitalId = box.getInt("hospitalId");
	//int deptId = box.getInt("deptId");
	String changeddate = box.getString(RequestConstants.CHANGED_DATE);
	Date changedDate = HMSUtil.convertStringTypeDateToDateType(changeddate);
	String changedtime = box.getString(RequestConstants.CHANGED_TIME);
	String user = box.getString(RequestConstants.CHANGED_BY);

	libhd.setId(hdId);
	libhd.setIssueDate(issueDate);

	//libhd.setIssueNo(issueNo);
	libhd.setLastChgBy(user);
	libhd.setLastChgDate(changedDate);
	libhd.setLastChgTime(changedtime);

	if (employeeId != 0) {
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeeId);
		libhd.setEmployee(masEmployee);
	}


	if (employeeIssueBy != 0) {
		MasEmployee issuedBy = new MasEmployee();
		issuedBy.setId(employeeIssueBy);
		libhd.setIssuedBy(issuedBy);
	}

	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	libhd.setHospital(masHospital);
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(deptId);
	libhd.setDepartment(masDepartment);
	libhd.setStatus("y");

	Transaction tx = null;
	try {
		tx = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<LibBookIssueDetail> libBookIssueDetail = new ArrayList<LibBookIssueDetail>();
		libBookIssueDetail = session.createCriteria(LibBookIssueDetail.class).add(Restrictions.eq("IssueHd.Id", hdId)).list();
		hbt.deleteAll(libBookIssueDetail);

		Vector bookId = box.getVector("bookId");
		Vector quantity = box.getVector("quantity");


		for (int i = 0; i < bookId.size(); i++) {
			LibBookIssueDetail libdt = new LibBookIssueDetail();
			if (bookId.get(i) != null && !bookId.get(i).equals("")) {
				libdt.setIssueHd(libhd);


				if (bookId.get(i) != null && !bookId.get(i).equals("")) {
					MasBook masBook = new MasBook();
					masBook.setId(Integer.parseInt((String) bookId.get(i)));
					libdt.setBook(masBook);
				}


				if (quantity.get(i)!= null	&& !quantity.get(i).equals("")) {
					libdt.setQuantity(Integer.parseInt((String) quantity
							.get(i)));
				}
				hbt.save(libdt);

			}
		}
		saved = true;
		tx.commit();
	} catch (Exception e) {
		if (tx != null)
			tx.rollback();
		System.out.println("Error ocurred!! please try again");
		e.printStackTrace();

	}
	map.put("saved", saved);
	return map;
}*/

	public boolean updateBookReturn(Box box) {



		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<LibBookReturnHd> returnHdList = session.createCriteria(LibBookReturnHd.class).add(Restrictions.eq("Id", box.getInt(RequestConstants.BOOK_RETURN_HD_ID))).list();
			LibBookReturnHd returnHdObj = (LibBookReturnHd) returnHdList.get(0);
			int returnHdId = returnHdObj.getId();
			LibBookReturnHd bookReturnHd = (LibBookReturnHd) hbt.load(LibBookReturnHd.class, returnHdId);

			if (box.getString("returnDate") != null	&& !box.getString("returnDate").equals(""))
				bookReturnHd.setReturnDate(HMSUtil.convertStringTypeDateToDateType(box.getString("returnDate")));

			MasEmployee receivedBy = new MasEmployee();
			if (box.getString("receivedBy") != null
					&& !box.getString("receivedBy").equals(""))
				receivedBy.setId(Integer.parseInt(box.getString("receivedBy")));
			bookReturnHd.setReceivedBy(receivedBy);

			LibBookIssueHeader bookIssueHeader = new LibBookIssueHeader();
			if (box.getString("bookIssueHdId") != null
					&& !box.getString("bookIssueHdId").equals(""))
				bookIssueHeader.setId(Integer.parseInt(box
						.getString("bookIssueHdId")));
			bookReturnHd.setIssueHd(bookIssueHeader);

			bookReturnHd.setLastChgBy(box.getString("changed_by"));
			bookReturnHd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString("changed_date")));
			bookReturnHd.setLastChgTime(box.getString("changed_time"));
			hbt.update(bookReturnHd);

			int bookReturnHdId = bookReturnHd.getId();
			System.out.println("bookReturnHdId" + bookReturnHdId);
			List<LibBookReturnDt> bookReturnDtList = session.createCriteria(LibBookReturnDt.class).add(
					Restrictions.eq("ReturnHd.Id", bookReturnHdId)).list();

			try {
				Vector book_return =box.getVector(RequestConstants.RETURN);
				System.out.println("book return  " + book_return.size());
				Vector issue_id = box.getVector("issue_id");
				int issueId = (Integer) box.getInt(RequestConstants.BOOK_ISSUE_DETAIL_ID);
				LibBookReturnDt bookReturnDetail = new LibBookReturnDt();
				int cnt = 0;
				for (LibBookReturnDt libBookReturnDt : bookReturnDtList) {
					System.out.println("libBookReturnDt id -"	+ libBookReturnDt.getId());
					/*if(libBookReturnDt.getBookReturn().equals("n")){
						libBookReturnDt.setBookReturn("n");
					}
					else
					{
						libBookReturnDt.setBookReturn("y");
					}*/
					if (book_return.contains(libBookReturnDt.getId())) {
						System.out.println("book_return" + book_return);

						libBookReturnDt.setBookReturn("y");
					}
					session.update(libBookReturnDt);

				}
				// for (int i = 0; i < book_return.size(); i++)
				// {
				// if (book_return.get(i) != null &&
				// !book_return.get(i).equals(""))
				// {
				//
				// bookReturnDetail.setReturnHd(new
				// LibBookReturnHd(bookReturnHdId));
				//
				// if (issue_id.get(i) != null && !issue_id.get(i).equals(""))
				// {
				// LibBookIssueDetail bookIssueDetail = new
				// LibBookIssueDetail();
				// bookIssueDetail.setId(Integer.parseInt((String)
				// issue_id.get(i)));
				// bookReturnDetail.setIssueDt(bookIssueDetail);
				// }
				//
				// if (book_return.get(i) != null &&
				// !book_return.get(i).equals(""))
				// {
				// bookReturnDetail.setBookReturn((String) book_return.get(i));
				// }
				// hbt.save(bookReturnDetail);
				//
				// }
				// }
				//
				// issueId = bookReturnDetail.getIssueDt().getId();
				// System.out.println("issueId in Ds :" + issueId);
				//
				// LibBookIssueDetail issueDetails = (LibBookIssueDetail)
				// getHibernateTemplate().load(
				// LibBookIssueDetail.class, issueId);
				// issueDetails.setStatus("i");
				// hbt.update(issueDetails);
				// hbt.refresh(issueDetails);

			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;
	}

	public String getStockTakingNoForDisplay(String string) {
		List<Integer> stockSeqNoList = new ArrayList<Integer>();
		List<LibBookStockTakingHd> seqNoList = new ArrayList<LibBookStockTakingHd>();
		String stockSeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session.createCriteria(LibBookStockTakingHd.class)
					.list();
			if (seqNoList.size() > 0) {
				for (LibBookStockTakingHd bookStockTakingHd : seqNoList) {
					if (bookStockTakingHd.getStockTakingNo() != null)
						lastSeqNo = bookStockTakingHd.getStockTakingNo();
					else
						lastSeqNo = "1/2009";
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			stockSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "BSTN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (stockSeqNoList.get(0) == null || stockSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("LibBookStockTakingHd");
				tsObj.setTransactionPrefix("BSTN");
				tsObj.setTransactionSequenceName("Book Stock No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				stockSeqNo = String.valueOf(1);
			} else if (stockSeqNoList.size() > 0) {
				for (Integer maxOrderNo : stockSeqNoList) {
					if (currentYear.equals(lastSeqYear) && maxOrderNo != null) {
						stockSeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						stockSeqNo = String.valueOf(1);
					}
				}
			}
			stockSeqNo = stockSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return stockSeqNo;
	}

	public Map<String, Object> showBookStockTakingJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LibBookStock> stockList = new ArrayList<LibBookStock>();
		stockList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.LibBookStock ");
		map.put("stockList", stockList);

		List<LibBookStockTakingDt> savedDtList = new ArrayList<LibBookStockTakingDt>();
		savedDtList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.LibBookStockTakingDt ");
		map.put("savedDtList", savedDtList);
		return map;
	}

	// ----------Methods for reports By dipali-----
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBookIssueRegisterReport(Map map) {
		Session session = (Session) getSession();
		List<MasBook> bookList = new ArrayList<MasBook>();
		try {
			bookList = session.createCriteria(MasBook.class).add(
					Restrictions.eq("Status", "y")).list();

			if (bookList.size() > 0) {
				map.put("bookList", bookList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBookPendingRegisterReport(Map map) {
		Session session = (Session) getSession();
		List<MasBook> bookList = new ArrayList<MasBook>();
		try {
			bookList = session.createCriteria(MasBook.class).add(
					Restrictions.eq("Status", "y")).list();

			if (bookList.size() > 0) {
				map.put("bookList", bookList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	public Map<String, Object> getGridDataForStockTaking(Box box) {

		System.out.println("getGridDataForStockTaking   in DSS");
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		session = (Session) getSession();

		String bookName = null;
		String accNo = null;
		String publishYear = null;
		Integer stockQty = null;
		BigDecimal cost = null;
		String purchaseDate = null;
		String acctualStock = null;

		int id = 0;
		int libHeaderId = 0;
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<LibBookStock> stockList = new ArrayList<LibBookStock>();
		List<LibBookStockTakingDt> savedDtList = new ArrayList<LibBookStockTakingDt>();
		List<MasBook> bookList = new ArrayList<MasBook>();
		List<LibBookStock> searchStockList = new ArrayList<LibBookStock>();

		try {

			// bookList =
			// session.createCriteria(MasBook.class).add(Restrictions.eq("Status",
			// "y")).list();

			// stockList = session.createCriteria(LibBookStock.class).list();
			// map.put("bookList", bookList);
			// map.put("stockList", stockList);

			int pageno = 1;
			int numOfRows = 15;
			try {
				if (box.get("pageno") != null) {
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			} catch (Exception e) {
				pageno = 1;
			}
			try {
				if (box.get("numOfRows") != null) {
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("numOfRows", numOfRows);
			map.put("pageno", pageno);

			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;

			String qry = "SELECT count(*) FROM lib_book_stock ";
			try {
				totalRecords = Integer.parseInt(session.createSQLQuery(qry)
						.list().get(0).toString());
			} catch (Exception e) {
				totalRecords = 0;
			}
			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			Criteria c = session.createCriteria(LibBookStock.class);

			c.setFirstResult(first);
			System.out.println(first + "first");
			if (totalRecords < numOfRows)
				c.setMaxResults(totalRecords);
			else
				c.setMaxResults(numOfRows);
			System.out.println(first + "first");
			stockList = c.list();
			map.put("stockList", stockList);
			if (box.get("libHeaderId") != null
					&& !box.get("libHeaderId").equals("")) {
				libHeaderId = box.getInt("libHeaderId");
				Criteria c1 = session
						.createCriteria(LibBookStockTakingDt.class)
						.add(Restrictions.eq("SockTakingHd.Id", libHeaderId));
				map.put("libHeaderId", libHeaderId);
				c1.setFirstResult(first);
				c1.setMaxResults(numOfRows);
				savedDtList = c1.list();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("vresult" + vResult);

		try {
			if (!box.contains("numOfRows"))
				box.put("numOfRows", 15);

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("savedDtList", savedDtList);

		return map;

	}

	public Map<String, Object> importStockTakingData(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getBookNameForAutoComplete(
			Map<String, Object> parameterMap) {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasBook> bookList = new ArrayList<MasBook>();
		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}

		bookList = session.createCriteria(LibBookStock.class).createAlias("Book", "bk").add(Restrictions.like("bk.BookName", str)).add(	Restrictions.like("bk.Status", "y")).list();
		if (bookList.size() > 0) {
			detailsMap.put("bookList", bookList);
		}
		return detailsMap;
	}

	public Map<String, Object> searchUpdateBookStock(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LibBookReturnHd> bookHdList = new ArrayList<LibBookReturnHd>();
		String stockNo = "";
		@SuppressWarnings("unused")
		Date stockDate = null;
		int bookStockHdId = 0;
		Session session = (Session) getSession();
		if (mapForDs.get("stockNo") != null) {
			stockNo = (String) mapForDs.get("stockNo");
		}
		if (mapForDs.get("stockDate") != null) {
			stockDate = (Date) mapForDs.get("stockDate");
		}

		if (mapForDs.get("bookStockHdId") != null) {
			bookStockHdId = (Integer) mapForDs.get("bookStockHdId");
		}
		Criteria crit = session.createCriteria(LibBookStockTakingHd.class);

		if (!stockNo.equals("")) {
			crit = crit.add(Restrictions.eq("StockTakingNo", stockNo));
		}
		if (stockDate != null) {
			crit = crit.add(Restrictions.eq("SockTakinDate", stockDate));
		}

		bookHdList = crit.list();
		map.put("bookHdList", bookHdList);
		return map;
	}

	public Map<String, Object> showUpdateBookStock(int bookStockHdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		LibBookStockTakingHd bookStockHd = new LibBookStockTakingHd();

		List<LibBookStockTakingHd> bookStockHdList = new ArrayList<LibBookStockTakingHd>();
		List<LibBookStockTakingDt> bookStockDtList = new ArrayList<LibBookStockTakingDt>();

		bookStockHd = (LibBookStockTakingHd) session.load(
				LibBookStockTakingHd.class, bookStockHdId);
		bookStockHdList.add(bookStockHd);
		bookStockDtList = session.createCriteria(LibBookStockTakingDt.class)
				.add(Restrictions.eq("StrikeCharge", "y")).add(
						Restrictions.eq("SockTakingHd.Id", bookStockHdId))
				.list();

		map.put("bookStockHdList", bookStockHdList);
		map.put("bookStockDtList", bookStockDtList);
		return map;
	}

	public boolean updateBookStock(Box box) {
		// TODO Auto-generated method stub
		return false;
	}

	public String generateStockTakingNumber(Map<String, Object> diagMap) {
		System.out.println("in generate method   :");
		Map<String, Object> map = new HashMap<String, Object>();
		String stockSeqNo = "";
		List<TransactionSequence> stockSeqNoList = new ArrayList<TransactionSequence>();
		List<LibBookStockTakingHd> seqNoList = new ArrayList<LibBookStockTakingHd>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(LibBookStockTakingHd.class).list();
		if (seqNoList.size() > 0) {
			for (LibBookStockTakingHd bookStockHeader : seqNoList) {
				lastSeqNo = bookStockHeader.getStockTakingNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		stockSeqNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "BSTN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (stockSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : stockSeqNoList) {
				TransactionSequence obj = (TransactionSequence) stockSeqNoList
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
				stockSeqNo = stockSeqNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (stockSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("LibBookStockTakingHd");
			tsObj.setTransactionPrefix("BSTN");
			tsObj.setTransactionSequenceName("Book Stock No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			stockSeqNo = stockSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return stockSeqNo;
	}

	public Map<String, Object> submitBookStockTaking(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		boolean saved = false;
		int libHeaderId = 0;
		System.out.println("box values" + box);
		try {
			Vector bookStockId = box.getVector("bookStockId");
			Vector charge = box.getVector(RequestConstants.CHARGE);
			Vector srNo = box.getVector(RequestConstants.SR_NO);
			Vector tempForCheackBoxes = box.getVector("tempForCheackBoxes");
			String status = "n";
			libHeaderId = box.getInt("libHeaderId");
			session.setFlushMode(FlushMode.ALWAYS);
			List<LibBookStockTakingHd> libBookStockTakingHdList = new ArrayList<LibBookStockTakingHd>();
			if (libHeaderId == 0 || (Integer.toString(libHeaderId).equals(""))) {
				int hospitalId = 1;// box.getInt("hospitalId");
				String stockdate = box.getString(RequestConstants.DATE);
				String changeddate = box
						.getString(RequestConstants.CHANGED_DATE);
				Date stockDate = HMSUtil
						.convertStringTypeDateToDateType(stockdate);
				Date changedDate = HMSUtil
						.convertStringTypeDateToDateType(changeddate);
				String changedtime = box
						.getString(RequestConstants.CHANGED_TIME);
				String user = box.getString(RequestConstants.CHANGED_BY);
				LibBookStockTakingHd libBookStockTakingHd = new LibBookStockTakingHd();

				libBookStockTakingHd.setSockTakinDate(stockDate);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				libBookStockTakingHd.setHospital(masHospital);

				libBookStockTakingHd.setLastChgBy("user");
				libBookStockTakingHd.setLastChgDate(changedDate);
				libBookStockTakingHd.setLastChgTime(changedtime);

				session.save(libBookStockTakingHd);

				LibBookStockTakingHd savedLibBookStockTakingHd = new LibBookStockTakingHd();
				Criteria c = session.createCriteria(LibBookStockTakingHd.class)
						.addOrder(Order.desc("Id"));
				c.setFirstResult(0);
				c.setMaxResults(1);
				libBookStockTakingHdList = c.list();
			} else {
				libBookStockTakingHdList = session.createCriteria(
						LibBookStockTakingHd.class).add(
						Restrictions.eq("Id", libHeaderId)).list();
			}
			if (libBookStockTakingHdList != null
					&& libBookStockTakingHdList.size() > 0) {
				libHeaderId = libBookStockTakingHdList.get(0).getId();
			}
			for (int cnt = 0; cnt < bookStockId.size(); cnt++) {
				LibBookStockTakingDt libBookStockTakingDt = new LibBookStockTakingDt();
				List<LibBookStockTakingDt> LibBookStockTakingDtList1 = session
						.createCriteria(LibBookStockTakingDt.class).add(
								Restrictions.eq("SrNo", Integer.parseInt(srNo
										.get(cnt).toString())))
						.add(Restrictions.eq("SockTakingHd.Id", libHeaderId))
						.list();

				if (LibBookStockTakingDtList1 != null
						&& LibBookStockTakingDtList1.size() > 0) {
					libBookStockTakingDt = LibBookStockTakingDtList1.get(0);
				}
				libBookStockTakingDt.setBookSock(new LibBookStock(Integer
						.parseInt(bookStockId.get(cnt).toString())));
				libBookStockTakingDt.setSockTakingHd(new LibBookStockTakingHd(
						libHeaderId));
				// for (int temp = 0; temp < charge.size(); temp++)
				// {
				// for (int cnt1 = 0; cnt1 < srNo.size(); cnt1++)
				// {
				// if
				// ((srNo.get(cnt1).toString()).equals(charge.get(temp).toString()))
				// {
				// status = "y";
				// System.out.println("status --" + status);
				// break;
				// }
				// }
				// }

				libBookStockTakingDt.setStrikeCharge(tempForCheackBoxes
						.get(cnt).toString());
				libBookStockTakingDt.setSrNo(Integer.parseInt(srNo.get(cnt)
						.toString()));
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setCheckWriteOperations(false);
				hbt.setFlushModeName("FLUSH_EAGER");
				if (libBookStockTakingDt.getId() != null) {
					hbt.update(libBookStockTakingDt);
					hbt.refresh(libBookStockTakingDt);
				} else {
					session.save(libBookStockTakingDt);
					session.refresh(libBookStockTakingDt);
				}

			}
			map.put("pageno", box.getInt("pageno"));
			map.put("libHeaderId", libHeaderId);
			saved = true;

			session.close();

			// session.flush();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		map.put("saved", saved);
		return map;
	}


	public Map<String, Object> getSupplyOrderDetailsCRV(Map<String, Object> mapForDs)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<MlSupplyorderDetail> searchSupplyOrderList = new ArrayList<MlSupplyorderDetail>();

		String supplyOrderNo = "";

		Session session = (Session) getSession();
		Criteria crit = null;

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("supplyOrderNo") != null) {
			supplyOrderNo = (String) mapForDs.get("supplyOrderNo");
		}


		try {
			crit = session.createCriteria(MlSupplyorderHeader.class).createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId));
			if (!supplyOrderNo.equals("")) {
				crit = crit.add(Restrictions.like("SupplyOrderNo",supplyOrderNo + "%"));
			}
			searchSupplyOrderList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchSupplyOrderList", searchSupplyOrderList);
		System.out.println("searchSupplyOrderList  "+ searchSupplyOrderList.size());
		return map;
	}

	@Override
	public Map<String, Object> updateBookIssue(Box box,Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		LibBookIssueHeader libhd = new LibBookIssueHeader();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		int hdId = box.getInt("hdId");

		String serviceNo = box.getString(RequestConstants.SERVICE_NO);
		String date = box.getString(RequestConstants.ISSUE_DATE);
		Date issueDate = HMSUtil.convertStringTypeDateToDateType(date);
		int employeeIssueBy=box.getInt(RequestConstants.ISSUED_BY);
		int employeeId=box.getInt(RequestConstants.EMPLOYEE_ID);
		int hospitalId = box.getInt("hospitalId");
		//int deptId = box.getInt("deptId");
		String changeddate = box.getString(RequestConstants.CHANGED_DATE);
		Date changedDate = HMSUtil.convertStringTypeDateToDateType(changeddate);
		String changedtime = box.getString(RequestConstants.CHANGED_TIME);
		String user = box.getString(RequestConstants.CHANGED_BY);

		libhd.setId(hdId);
		libhd.setIssueDate(issueDate);

		//libhd.setIssueNo(issueNo);
		libhd.setLastChgBy(user);
		libhd.setLastChgDate(changedDate);
		libhd.setLastChgTime(changedtime);

		if (employeeId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			libhd.setEmployee(masEmployee);
		}


		if (employeeIssueBy != 0) {
			MasEmployee issuedBy = new MasEmployee();
			issuedBy.setId(employeeIssueBy);
			libhd.setIssuedBy(issuedBy);
		}

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		libhd.setHospital(masHospital);
		/*MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		libhd.setDepartment(masDepartment);
		libhd.setStatus("y");*/

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<LibBookIssueDetail> libBookIssueDetail = new ArrayList<LibBookIssueDetail>();
			libBookIssueDetail = session.createCriteria(LibBookIssueDetail.class).add(Restrictions.eq("IssueHd.Id", hdId)).list();
			hbt.deleteAll(libBookIssueDetail);

			Vector bookId = box.getVector("bookId");
			Vector quantity = box.getVector("quantity");


			for (int i = 0; i < bookId.size(); i++) {
				LibBookIssueDetail libdt = new LibBookIssueDetail();
				if (bookId.get(i) != null && !bookId.get(i).equals("")) {
					libdt.setIssueHd(libhd);


					if (bookId.get(i) != null && !bookId.get(i).equals("")) {
						MasBook masBook = new MasBook();
						masBook.setId(Integer.parseInt((String) bookId.get(i)));
						libdt.setBook(masBook);
					}


					if (quantity.get(i)!= null	&& !quantity.get(i).equals("")) {
						libdt.setQuantity(Integer.parseInt((String) quantity
								.get(i)));
					}
					hbt.save(libdt);

				}
			}
			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error ocurred!! please try again");
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;

	}


	public boolean submitBookReturn2(Map<String, Object> infoMap) {

		LibBookReturnHd bookReturnHd = new LibBookReturnHd();
		String userName = "";
		boolean saved = false;

		List returnList = new ArrayList();
		List issueDtList = new ArrayList();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		@SuppressWarnings("unused")
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);

		int employeeId = 0;
		int hospitalId = 0;
		@SuppressWarnings("unused")
		int issuedBy = 0;

		if (infoMap.get("bookReturnHd") != null) {
			bookReturnHd = (LibBookReturnHd) infoMap.get("bookReturnHd");
		}
		if (infoMap.get("employeeId") != null) {
			employeeId = (Integer) infoMap.get("employeeId");
		}
		if (infoMap.get("issuedBy") != null) {
			issuedBy = (Integer) infoMap.get("issuedBy");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("issueDtList") != null) {
			issueDtList = (List) infoMap.get("issueDtList");
		}
		if (infoMap.get("returnList") != null) {
			returnList = (List) infoMap.get("returnList");
		}



		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(bookReturnHd);

		System.out.println("returnList--in db-->"+returnList.size());
		System.out.println("issueDtList--in db-->"+issueDtList.size());

		if (returnList.size() > 0) {
						for (int i = 0; i < returnList.size(); i++) {
							LibBookReturnDt bookReturnDt = new LibBookReturnDt();
							LibBookIssueDetail bookIssueDetail = new LibBookIssueDetail();

							if (returnList.get(i) != null && !returnList.get(i).equals("")) {

								String bookReturn = returnList.get(i).toString();
								bookReturnDt.setBookReturn(bookReturn);
								System.out.println("bookReturnDt--in db-->"+bookReturnDt.getId());
								System.out.println("bookReturnHd--in db-->"+bookReturnDt.getReturnHd().getId());
								if (issueDtList.get(i) != null && !issueDtList.get(i).equals("0")) {

									int issueDtId = Integer.parseInt(issueDtList.get(i).toString());
									bookIssueDetail.setId(issueDtId);
									bookReturnDt.setIssueDt(bookIssueDetail);

									bookReturnDt.setReturnHd(bookReturnHd);

									LibBookIssueDetail issueDetailObj = (LibBookIssueDetail) hbt.load(LibBookIssueDetail.class,issueDtId);
									issueDetailObj.setStatus("r");

									hbt.saveOrUpdate(issueDetailObj);

									try {
										int bookId = bookReturnDt.getIssueDt().getBook().getId();
										System.out.println("+bookId:  in 4116 :  "	+ bookId);
										LibBookStock bookStock = (LibBookStock) getHibernateTemplate().load(LibBookStock.class,	bookId);
										// bookStock.setReturnQty();
										hbt.saveOrUpdate(bookStock);
									} catch (RuntimeException e) {
										e.printStackTrace();
									}

								}

								hbt.save(bookReturnDt);

							}
							saved = true;

						}
					}

		return saved;
	}
	public boolean submitBookReturn(Map<String, Object> infoMap) {
		LibBookReturnHd bookReturnHd = new LibBookReturnHd();
		String userName = "";
		boolean saved = false;
		boolean flag = false;

		List returnList = new ArrayList();
		List issueDtList = new ArrayList();

		List bookReturnDetailIdList = new ArrayList();


		int employeeId = 0;
		int hospitalId = 0;
		@SuppressWarnings("unused")
		int issuedBy = 0;

		if (infoMap.get("bookReturnHd") != null) {
			bookReturnHd = (LibBookReturnHd) infoMap
					.get("bookReturnHd");
		}
		if (infoMap.get("bookReturnDetailIdList") != null) {
			bookReturnDetailIdList = (List) infoMap.get("bookReturnDetailIdList");
		}
		if (infoMap.get("employeeId") != null) {
			employeeId = (Integer) infoMap.get("employeeId");
		}
		if (infoMap.get("issuedBy") != null) {
			issuedBy = (Integer) infoMap.get("issuedBy");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("returnList") != null) {
			returnList = (List) infoMap.get("returnList");
		}
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		@SuppressWarnings("unused")
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
		try {
			hbt.save(bookReturnHd);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		try {
			if (infoMap.get("issueDtList") != null) {
				issueDtList = (List) infoMap.get("issueDtList");
				try {
					if (issueDtList.size() > 0) {
						for (int i = 0; i < issueDtList.size(); i++) {
							System.out.println("111111");
							LibBookReturnDt libBookReturnDt = new LibBookReturnDt();
							LibBookIssueDetail bookIssueDetail = new LibBookIssueDetail();
							if (issueDtList.get(i) != null && !issueDtList.get(i).equals(""))
							{
								System.out.println("2222222");
								int issueDtId = Integer.parseInt(issueDtList.get(i).toString());
								bookIssueDetail.setId(issueDtId);
								libBookReturnDt.setIssueDt(bookIssueDetail);

								LibBookIssueDetail issueDetailObj = (LibBookIssueDetail) hbt.load(LibBookIssueDetail.class,issueDtId);
								issueDetailObj.setStatus("r");
								hbt.saveOrUpdate(issueDetailObj);
								System.out.println("3333333");
								libBookReturnDt.setReturnHd(bookReturnHd);
								System.out.println("444444");

								if (returnList.get(i) != null 	&& !returnList.get(i).equals("")) {
									System.out.println("555555");
									String bookReturn = returnList.get(i).toString();
									System.out.println("bookReturn--->"+bookReturn);
									libBookReturnDt.setBookReturn(bookReturn);
								}

								System.out.println("666666");
							hbt.save(libBookReturnDt);
							System.out.println("777777");
							try {
								int bookId = libBookReturnDt.getIssueDt().getBook().getId();
								System.out.println("+bookId:  in 4116 :  "	+ bookId);
									LibBookStock bookStock = (LibBookStock) getHibernateTemplate().load(LibBookStock.class, bookId);

									hbt.saveOrUpdate(bookStock);
								} catch (RuntimeException e) {
									e.printStackTrace();
								}
							}
							}

				}
				}catch (DataAccessException e) {
					e.printStackTrace();
				}
			}

			saved = true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return saved;
	}
	}
