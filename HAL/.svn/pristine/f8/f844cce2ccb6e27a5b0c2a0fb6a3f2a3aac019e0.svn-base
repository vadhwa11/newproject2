package jkt.hms.stores.dataservice;

import static jkt.hms.util.RequestConstants.ADDRESS;

import static jkt.hms.util.RequestConstants.AUTHORITY;
import static jkt.hms.util.RequestConstants.BRAND_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID_TEMP;
import static jkt.hms.util.RequestConstants.DISPOSAL_NO;
import static jkt.hms.util.RequestConstants.DOC_NO;
import static jkt.hms.util.RequestConstants.ISSUED_BY;
import static jkt.hms.util.RequestConstants.ISSUE_ID;
import static jkt.hms.util.RequestConstants.NRS;
import static jkt.hms.util.RequestConstants.QTY_ISSUED;
import static jkt.hms.util.RequestConstants.SUPPLY_DEPOT;
import static jkt.hms.util.RequestConstants.TYPE_OF_INDENT;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.transaction.SystemException;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasFormation;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasStoreAirForceDepot;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.StoreAmcM;
import jkt.hms.masters.business.StoreBosM;
import jkt.hms.masters.business.StoreBosT;
import jkt.hms.masters.business.StoreDisposalM;
import jkt.hms.masters.business.StoreDisposalT;
import jkt.hms.masters.business.StoreFyDocumentNo;
import jkt.hms.masters.business.StoreGrnReturnM;
import jkt.hms.masters.business.StoreGrnReturnT;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreIndentSocTracker;
import jkt.hms.masters.business.StoreIndentT;
import jkt.hms.masters.business.StoreInternalIndentM;
import jkt.hms.masters.business.StoreInternalIndentT;
import jkt.hms.masters.business.StoreInternalReturnM;
import jkt.hms.masters.business.StoreInternalReturnT;
import jkt.hms.masters.business.StoreIssueM;
import jkt.hms.masters.business.StoreIssueT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StoreLoanOutM;
import jkt.hms.masters.business.StoreLoanOutT;
import jkt.hms.masters.business.StoreMmfDepartmentM;
import jkt.hms.masters.business.StoreMmfDepartmentT;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StoreWorkOrderT;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PageUtil;
import jkt.hms.util.PagedArray;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class NonExpandableDataServiceImpl extends HibernateDaoSupport implements
		NonExpandableDataService {
	Session session;

	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By
	// Vivek------------------------------------------
	// ****************************************************************************************************************

	// ------Indent To SOC--------------------------------------

	public Map NextOrSubmit(Map<String, Object> dataMap)
			throws java.text.ParseException {

		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Date date = new Date();
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		int storeFyId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = (Box) dataMap.get("box");
		session = (Session) getSession();
		String successfullyAdded = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		String messageTOBeVisibleToTheUser = "";
		String messageType = "";
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			StoreIndentM storeIndentM = new StoreIndentM();
			storeIndentM.setId(Integer.parseInt("" + box.get("indentMId")));
			storeIndentM.setIndentNo("" + box.get("indentNo"));
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse(""
					+ box.get("indentDate")));
			date = java.sql.Date.valueOf(date4MySQL);
			storeIndentM.setIndentDate(date);
			storeIndentM.setRequiredForm("" + box.get("indentFrom"));
			storeIndentM.setIndentType("s");
			storeIndentM.setStatus("o");
			storeIndentM.setLastChgBy(userName);
			storeIndentM.setLastChgDate(date);
			storeIndentM.setLastChgTime(time);

			MasDepartment department = new MasDepartment();
			department
					.setId(Integer.parseInt("" + box.get("departmentIdTemp")));
			storeIndentM.setItemReqDept(department);

			MasDepartment department2 = new MasDepartment();
			department2.setId(deptId);
			storeIndentM.setDepartment(department2);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			storeIndentM.setHospital(hospital);

			storeIndentM.setRequiredForm(""
					+ box.get(RequestConstants.INDENT_FROM));
			storeIndentM.setBriefMentionOfFunctions(""
					+ box.get(RequestConstants.BRIEF_JUSTIFICATION));
			storeIndentM.setExistingFacilities(""
					+ box.get(RequestConstants.EXISTING_FACILITIES));
			storeIndentM.setHowWasTheWork(""
					+ box.get(RequestConstants.HOW_WAS_THE_WORK));
			storeIndentM.setFeedbackAboutThePerformance(""
					+ box.get(RequestConstants.FEEDBACK));
			storeIndentM.setNoOfPatientsWillBeBenefited(""
					+ box.get(RequestConstants.NO_OF_PATIENTS));
			storeIndentM.setDesirabilityOfOutSourcing(""
					+ box.get(RequestConstants.DESIRABILITY));
			storeIndentM.setManufacturerFullAddress(""
					+ box.get(RequestConstants.MANUFACTURER_NAME));
			storeIndentM.setCountryOfOrigin(""
					+ box.get(RequestConstants.COUNTRY_CODE));
			storeIndentM.setIndianAgentDelhiAddress(""
					+ box.get(RequestConstants.INDIAN_AGENT));
			storeIndentM.setStdCode("" + box.get(RequestConstants.STD_CODE));
			if ((box.get(RequestConstants.TELE_NO) != null)
					&& (!box.get(RequestConstants.TELE_NO).equals("")))
				//storeIndentM.setTellNo(Integer.parseInt(""+ box.get(RequestConstants.TELE_NO)));

			//System.out.println("box.get(RequestConstants.FAX_NO)   "+ box.get(RequestConstants.FAX_NO));
			if ((box.get(RequestConstants.FAX_NO) != null)
					&& (!box.get(RequestConstants.FAX_NO).equals("")))
				storeIndentM.setFaxNo(Integer.parseInt(""
						+ box.get(RequestConstants.FAX_NO)));
			storeIndentM.setEmail("" + box.get(RequestConstants.EMAIL));
			storeIndentM.setLocalAddress(""
					+ box.get(RequestConstants.LOCAL_ADDRESS));
			storeIndentM.setLocalStdCode(("" + box
					.get(RequestConstants.LOCAL_STD_CODE)));
			if ((box.get(RequestConstants.LOCAL_TELE_NO) != null)
					&& (!box.get(RequestConstants.LOCAL_TELE_NO).equals("")))
				storeIndentM.setLocalTellNo(Integer.parseInt(""
						+ box.get(RequestConstants.LOCAL_TELE_NO)));
			storeIndentM.setLocalEmail(""
					+ box.get(RequestConstants.LOCAL_EMAIL));
			if ((box.get(RequestConstants.QTY_OF_STND_EQPMT) != null)
					&& (!box.get(RequestConstants.QTY_OF_STND_EQPMT).equals("")))
				storeIndentM.setQty(new BigDecimal(""
						+ box.get(RequestConstants.QTY_OF_STND_EQPMT)));
			if ((box.get(RequestConstants.LOCAL_FAX_NO) != null)
					&& (!box.get(RequestConstants.LOCAL_FAX_NO).equals("")))
				storeIndentM.setLocalFaxNo(Integer.parseInt(""
						+ box.get(RequestConstants.LOCAL_FAX_NO)));
			storeIndentM.setMustAccessories(""
					+ box.get(RequestConstants.MUST_ACCESSORIES));
			storeIndentM.setEssentialAccessories(""
					+ box.get(RequestConstants.ESSENTIAL_ACCESSORIES));
			storeIndentM.setAtSoNumber(""
					+ box.get(RequestConstants.AT_SO_NUMBER));
			storeIndentM.setReferenceOfIndents(""
					+ box.get(RequestConstants.REFERENCE_OF_INDENTS));
			storeIndentM.setAnnualMaintContractReqd(""
					+ box.get(RequestConstants.APPROXIMATE_TOTAL));
			storeIndentM.setPacJustification(""
					+ box.get(RequestConstants.PAC_JUSTIFICATION));
			storeIndentM.setConsumablesRequired(""
					+ box.get(RequestConstants.CONSUMABLE_REQUIRED));
			if ((box.get(RequestConstants.IF_YES_QTY) != null)
					&& (!box.get(RequestConstants.IF_YES_QTY).equals("")))
				storeIndentM.setIfYesQty(new BigDecimal(""
						+ box.get(RequestConstants.IF_YES_QTY)));
			if ((box.get(RequestConstants.DURATION_FOR_WHICH_REQD) != null)
					&& (!box.get(RequestConstants.DURATION_FOR_WHICH_REQD)
							.equals("")))
				storeIndentM.setDurationForWhichReqd(Integer.parseInt(""
						+ box.get(RequestConstants.DURATION_FOR_WHICH_REQD)));
			storeIndentM.setUsertrialrequired(""
					+ box.get(RequestConstants.USER_TRAIL_REQUIRED));
			storeIndentM.setInstallationByFirmRequired(""
					+ box.get(RequestConstants.INSTALLATION_BY_FIRM_REQUIRED));
			storeIndentM.setTurnkeyRequired(""
					+ box.get(RequestConstants.TURN_KEY_REQUIRED));
			storeIndentM.setAnnualMaintContractReqd(""
					+ box.get(RequestConstants.ANNUAL_MAINT_CONTRACT_REQD));
			storeIndentM.setTrainingRequired(""
					+ box.get(RequestConstants.TRAINING_REQUIRED));
			storeIndentM.setImported("n");
			storeIndentM.setPacAttachCertificate(""
					+ box.get(RequestConstants.PAC_JUSTIFICATION));
			if ((box.get(RequestConstants.APPROXIMATE_TOTAL) != null)
					&& (!box.get(RequestConstants.APPROXIMATE_TOTAL).equals("")))
				storeIndentM.setApproximateTotal(new BigDecimal(""
						+ box.get(RequestConstants.APPROXIMATE_TOTAL)));
			hbt.update(storeIndentM);

			StoreIndentT storeIndentT = new StoreIndentT();
			storeIndentT.setId(Integer.parseInt("" + box.get("indentTId")));
			storeIndentT.setIndent(storeIndentM);
			String val = ("" + box.get(RequestConstants.ITEM_NAME));
			int index1 = val.lastIndexOf("[");
			int index2 = val.lastIndexOf("]");
			index1++;
			String pvms = val.substring(index1, index2);
			List<Object> objectList = new ArrayList<Object>();
			String qry = "SELECT item_id FROM mas_store_item as item where item.pvms_no='"
					+ pvms + "';";
			int itemId = 0;
			objectList = (List) session.createSQLQuery(qry).list();
			if (objectList.get(0) != null)
				itemId = Integer.parseInt("" + objectList.get(0));
			MasStoreItem storeItem = new MasStoreItem();
			storeItem.setId(itemId);
			storeIndentT.setItem(storeItem);
			hbt.update(storeIndentT);
			messageTOBeVisibleToTheUser = "Record added successfully";
			messageType = "success";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			messageTOBeVisibleToTheUser = "Record Not added ";
			messageType = "failure";
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();
		} finally {
			// session.close();
		}

		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("messageType", messageType);
		return map;

	}

	public Map searchIndentSOC(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<StoreIndentM> indentMList = new ArrayList<StoreIndentM>();
		List<StoreIndentT> indentTList = new ArrayList<StoreIndentT>();
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int indentId = 0;
		indentId = Integer.parseInt("" + dataMap.get("indentId"));

		searchIndentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o' and md.IndentType= 's' and md.Department.Id='"
								+ deptId + "'");
		//System.out.println("searchIndentList  " + searchIndentList.size());
		departmentList = (List) getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status='y'");
		indentMList = (List) getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreIndentM as md where md.Id='"
						+ indentId + "'");
		indentTList = (List) getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreIndentT as md where md.Indent.Id='"
						+ indentId + "'");
		map.put("searchIndentList", searchIndentList);
		map.put("departmentList", departmentList);
		map.put("indentMList", indentMList);
		map.put("indentTList", indentTList);
		return map;
	}

	public Map<String, Object> chackForItemExistence(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int item_id = 0;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		pvmsNo = "" + dataMap.get("pvmsNo");
		try {

			pvmsNo = "" + dataMap.get("pvmsNo");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("PvmsNo", pvmsNo));
			itemList = c.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;

	}

	public Map<String, Object> getItemListForIndentToSOC(
			Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int deptId = 0;
		int indentId = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		indentId = Integer.parseInt("" + dataMap.get("indentId"));
		List objectList = new ArrayList();
		//System.out.println("deptId  _________________" + deptId);
		//System.out.println("indentId __________________ " + indentId);
		try {
			String str = dataMap.get("autoHint") + "%";
			String qry1 = "SELECT t.item_id FROM store_indent_t t,store_indent_m m where t.indent_id='"
					+ indentId + "' and m.indent_id=t.indent_id";
			objectList = (List) session.createSQLQuery(qry1).list();
			if (objectList.size() != 0) {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.not(Restrictions.in("Id", objectList)));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			} else {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("itemList        ========================== "	+ itemList.size());
		map.put("itemList", itemList);
		return map;

	}

	public Map<String, Object> fillItemsCommon(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int item_id = 0;
		try {
			pvmsNo = "" + dataMap.get("pvmsNo");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("PvmsNo", pvmsNo));
			itemList = c.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;

	}

	public Map<String, Object> fillItemsForIndentToSOC(
			Map<String, Object> dataMap) {

		session = (Session) getSession();
		String pvms = null;
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List objectList = new ArrayList();
		int deptId = 0;
		BigDecimal stockIn = null;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		try {
			String str = "" + dataMap.get("pvmsNo");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str));
			itemList = c.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		try {
			int itemId = 0;
			for (MasStoreItem masStoreItem : itemList) {
				itemId = masStoreItem.getId();

			}

			if (itemId != 0) {
				Criteria c2 = session.createCriteria(MasStoreBrand.class).add(
						Restrictions.eq("Item.Id", itemId));
				brandList = c2.list();
			}
			String qry = "SELECT sum(closing_stock) FROM store_item_batch_stock where item_id='"
					+ itemId + "' and department_id='" + deptId + "';";
			objectList = (List) session.createSQLQuery(qry).list();

			if (objectList.get(0) != null)
				stockIn = new BigDecimal("" + objectList.get(0));
			else
				stockIn = new BigDecimal("0");
			map.put("brandList", brandList);
			map.put("itemList", itemList);
			map.put("stockIn", stockIn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	public Map getBrandListForSOC(int itemId, int detailId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBrand> masStoreBrandList = new ArrayList<MasStoreBrand>();
		List<StoreIndentT> storeIndentTList = new ArrayList<StoreIndentT>();
		List<MasManufacturer> masManufacturerList = new ArrayList<MasManufacturer>();
		masStoreBrandList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreBrand as md where md.Item.Id = '"
						+ itemId + "' ");
		;
		masManufacturerList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasManufacturer  ");
		;
		storeIndentTList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreIndentT as sit where sit.Id='"
						+ detailId + "'  ");
		;
		map.put("masStoreBrandList", masStoreBrandList);
		map.put("masManufacturerList", masManufacturerList);
		map.put("storeIndentTList", storeIndentTList);
		return map;
	}

	public Map getBrandListForSOC(int itemId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBrand> masStoreBrandList = new ArrayList<MasStoreBrand>();
		List<MasManufacturer> masManufacturerList = new ArrayList<MasManufacturer>();
		masStoreBrandList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreBrand as md where md.Item.Id = '"
						+ itemId + "' ");
		;
		masManufacturerList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasManufacturer  ");
		;
		map.put("masStoreBrandList", masStoreBrandList);
		map.put("masManufacturerList", masManufacturerList);
		return map;
	}

	public Map<String, Object> showIndentJspSOC(Map<String, Object> dataMap) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
		List<MasStoreAirForceDepot>  masStoreAirForceDepotList= new ArrayList<MasStoreAirForceDepot>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		session = (Session) getSession();
		String no = "";
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
/*			departmentList = (List) getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasDepartment as md where md.Status='y'");
			storeFyDocumentNoList = (List) getHibernateTemplate()
			.find(
					"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
					+ deptId + "'");
					
					searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o' and md.IndentType= 's' and md.Department.Id='"
									+ deptId + "'");
				supplierList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplier as md where md.Status = 'y' ");
					*/
			
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			storeFyDocumentNoList=session.createCriteria(StoreFyDocumentNo.class).add(Restrictions.eq("Department.Id", deptId)).list();
			searchIndentList=session.createCriteria(StoreIndentM.class)
									.add(Restrictions.eq("Status", "o"))
									.add(Restrictions.eq("IndentType", "S"))
									.add(Restrictions.eq("Department.Id", deptId))
									.list();
			
			supplierList=session.createCriteria(MasStoreSupplier.class)
								.add(Restrictions.eq("Status", "y"))
								.list();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.idEq(hospitalId)).list();
			MasHospital hospital = hospitalList.get(0);
			String hospitalName = hospital.getHospitalName();
			map.put("hospitalName", hospitalName);
			sectionList = new ArrayList<MasStoreSection>();
			sectionList = getHibernateTemplate().find(
			"from jkt.hms.masters.business.MasStoreSection as ms where ms.Status = 'y' order by ms.SectionName asc ");
			masStoreAirForceDepotList = getHibernateTemplate()
			.find("from jkt.hms.masters.business.MasStoreAirForceDepot as md where md.Status = 'y'");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getIndentToSocNo() != null) {
					no = ("" + storeFyDocumentNo.getIndentToSocNo());
					no = getMaxNo(no);
				} else {
					no = getMaxNo("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		map.put("supplierList", supplierList);
		map.put("maxIndentNo", no);
		map.put("departmentList", departmentList);
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		return map;
	}

	public Map<String, Object> addNextOrSubmitIndentToSOC(
			Map<String, Object> dataMap) throws java.text.ParseException {
		String headerStored = "no";
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int pageNo=0;
		int indentMId=0;
		Date date = new Date();
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		int storeFyId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = (Box) dataMap.get("box");
		session = (Session) getSession();
		String successfullyAdded = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		String messageTOBeVisibleToTheUser = "";
		String messageType = "";
		Transaction tx = null;
		int gridSize = 0;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if(box.getInt("gridSize")!= 0){
				gridSize = (Integer)box.getInt("gridSize");
			}
			StoreIndentM storeIndentM = new StoreIndentM();
			pageNo=box.getInt("pageNo");
			//if(pageNo == 1){
			storeIndentM.setIndentNo(box.get("indentNo"));
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse("" + box.get("indentDate")));
			date = java.sql.Date.valueOf(date4MySQL);
			storeIndentM.setIndentDate(date);
			storeIndentM.setRequiredForm("" + box.get(RequestConstants.INDENT_FROM));
			storeIndentM.setIndentType("d");
			storeIndentM.setStatus("o");
			storeIndentM.setImported("n");
			storeIndentM.setLastChgBy(userName);
			storeIndentM.setLastChgDate(date);
			storeIndentM.setLastChgTime(time);
			storeIndentM.setIndentNo(box.getString("indentNo"));
			storeIndentM.setSelfLife(box.getString("lifeType"));
			MasStoreAirForceDepot masStoreSupplier = new MasStoreAirForceDepot();
			masStoreSupplier.setId(box.getInt(SUPPLY_DEPOT));
			storeIndentM.setSuppliedBy(masStoreSupplier);
			if(box.getInt("sectionId") != 0){
			MasStoreSection masStoreSection = new MasStoreSection();
			masStoreSection.setId(box.getInt("sectionId"));
			storeIndentM.setSection(masStoreSection);
			}

			/*MasDepartment department = new MasDepartment();
			department
					.setId(Integer.parseInt("" + box.get("departmentIdTemp")));
			storeIndentM.setItemReqDept(department);
*/
			MasDepartment department2 = new MasDepartment();
			department2.setId(deptId);
			storeIndentM.setDepartment(department2);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			storeIndentM.setHospital(hospital);

			/*storeIndentM.setRequiredForm(""+ box.get(RequestConstants.INDENT_FROM));
			storeIndentM.setBriefMentionOfFunctions(""+ box.get(RequestConstants.BRIEF_JUSTIFICATION));
			storeIndentM.setExistingFacilities(""+ box.get(RequestConstants.EXISTING_FACILITIES));
			storeIndentM.setHowWasTheWork(""+ box.get(RequestConstants.HOW_WAS_THE_WORK));
			storeIndentM.setFeedbackAboutThePerformance(""+ box.get(RequestConstants.FEEDBACK));
			storeIndentM.setNoOfPatientsWillBeBenefited(""+ box.get(RequestConstants.NO_OF_PATIENTS));
			storeIndentM.setDesirabilityOfOutSourcing(""+ box.get(RequestConstants.DESIRABILITY));
			storeIndentM.setManufacturerFullAddress(""+ box.get(RequestConstants.MANUFACTURER_NAME));
			storeIndentM.setCountryOfOrigin(""+ box.get(RequestConstants.COUNTRY_CODE));
			storeIndentM.setIndianAgentDelhiAddress(""+ box.get(RequestConstants.INDIAN_AGENT));
			storeIndentM.setStdCode("" + box.get(RequestConstants.STD_CODE));
			if ((box.get(RequestConstants.TELE_NO) != null) && (!box.get(RequestConstants.TELE_NO).equals(""))) {
				String tellNo = ("" + box.get(RequestConstants.TELE_NO)).trim();
			}
			if ((box.get(RequestConstants.FAX_NO) != null) && (!box.get(RequestConstants.FAX_NO).equals("")))
				storeIndentM.setFaxNo(Integer.parseInt(""+ box.get(RequestConstants.FAX_NO)));
			storeIndentM.setEmail("" + box.get(RequestConstants.EMAIL));
			storeIndentM.setLocalAddress(""+ box.get(RequestConstants.LOCAL_ADDRESS));
			storeIndentM.setLocalStdCode(("" + box.get(RequestConstants.LOCAL_STD_CODE)));
			if ((box.get(RequestConstants.LOCAL_TELE_NO) != null) && (!box.get(RequestConstants.LOCAL_TELE_NO).equals("")))
				storeIndentM.setLocalTellNo(Integer.parseInt("" + box.get(RequestConstants.LOCAL_TELE_NO)));
			storeIndentM.setLocalEmail("" + box.get(RequestConstants.LOCAL_EMAIL));
			if ((box.get(RequestConstants.QTY_OF_STND_EQPMT) != null) && (!box.get(RequestConstants.QTY_OF_STND_EQPMT).equals("")))
				storeIndentM.setQty(new BigDecimal("" + box.get(RequestConstants.QTY_OF_STND_EQPMT)));
			if ((box.get(RequestConstants.LOCAL_FAX_NO) != null) && (!box.get(RequestConstants.LOCAL_FAX_NO).equals("")))
				storeIndentM.setLocalFaxNo(Integer.parseInt("" + box.get(RequestConstants.LOCAL_FAX_NO)));
			storeIndentM.setMustAccessories("" + box.get(RequestConstants.MUST_ACCESSORIES));
			storeIndentM.setEssentialAccessories("" + box.get(RequestConstants.ESSENTIAL_ACCESSORIES));
			storeIndentM.setAtSoNumber("" + box.get(RequestConstants.AT_SO_NUMBER));
			storeIndentM.setReferenceOfIndents("" + box.get(RequestConstants.REFERENCE_OF_INDENTS));
			storeIndentM.setAnnualMaintContractReqd("" + box.get(RequestConstants.ANNUAL_MAINT_CONTRACT_REQD));
			storeIndentM.setPacJustification("" + box.get(RequestConstants.PAC_JUSTIFICATION));
			storeIndentM.setConsumablesRequired("" + box.get(RequestConstants.CONSUMABLE_REQUIRED));
			if ((box.get(RequestConstants.IF_YES_QTY) != null) && (!box.get(RequestConstants.IF_YES_QTY).equals("")))
				storeIndentM.setIfYesQty(new BigDecimal("" + box.get(RequestConstants.IF_YES_QTY)));
			if ((box.get(RequestConstants.DURATION_FOR_WHICH_REQD) != null) && (!box.get(RequestConstants.DURATION_FOR_WHICH_REQD).equals("")))
				storeIndentM.setDurationForWhichReqd(Integer.parseInt("" + box.get(RequestConstants.DURATION_FOR_WHICH_REQD)));
			storeIndentM.setUsertrialrequired("" + box.get(RequestConstants.USER_TRAIL_REQUIRED));
			storeIndentM.setInstallationByFirmRequired("" + box.get(RequestConstants.INSTALLATION_BY_FIRM_REQUIRED));
			storeIndentM.setTurnkeyRequired("" + box.get(RequestConstants.TURN_KEY_REQUIRED));
			storeIndentM.setAnnualMaintContractReqd("" + box.get(RequestConstants.ANNUAL_MAINT_CONTRACT_REQD));
			storeIndentM.setTrainingRequired("" + box.get(RequestConstants.TRAINING_REQUIRED));
			storeIndentM.setImported("n");
			storeIndentM.setPacAttachCertificate("" + box.get(RequestConstants.PAC_JUSTIFICATION));
			if ((box.get(RequestConstants.APPROXIMATE_TOTAL) != null) && (!box.get(RequestConstants.APPROXIMATE_TOTAL).equals("")))
				storeIndentM.setApproximateTotal(new BigDecimal("" + box.get(RequestConstants.APPROXIMATE_TOTAL)));*/
			
			hbt.save(storeIndentM);
			System.out.println("storeIndentM==="+storeIndentM);
			map.put("indentMId", storeIndentM.getId());
				Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
					.load(StoreFyDocumentNo.class, storeFyId);
			storeFyDocumentNo.setIndentToSocNo(""
					+ box.get(RequestConstants.INDENT_NO));
			hbt.update(storeFyDocumentNo);
			//}
			//------------commented by anamika--------------------
			/*StoreIndentT storeIndentT = new StoreIndentT();
			if(pageNo != 1)
			{
				
				int indentId=box.getInt("indentMId");
				StoreIndentM storeIndentM1=new StoreIndentM();
				storeIndentM1.setId(indentId);
				storeIndentT.setIndent(storeIndentM1);
				map.put("indentMId", indentId);
			}
			
			if(pageNo == 1)
			{
				storeIndentT.setIndent(storeIndentM);
			}*/
			System.out.println("gridSize===="+gridSize);
			String pvms="";
		for (int i = 1; i <= gridSize; i++) {
			System.out.println("val===="+box.getInt("itemId"+i));
			StoreIndentT storeIndentT = new StoreIndentT();
			/*String val = (box.getString("itemId"));
			int index1 = val.lastIndexOf("[");
			int index2 = val.lastIndexOf("]");
			index1++;
			System.out.println("val==="+val);
			 pvms = val.substring(index1, index2);
			List<Object> objectList = new ArrayList<Object>();
			String qry = "SELECT item_id FROM mas_store_item as item where item.pvms_no='"
					+ pvms + "';";
			
			int itemId = 0;
			objectList = (List) session.createSQLQuery(qry).list();
			if (objectList.get(0) != null)
				itemId = Integer.parseInt("" + objectList.get(0));
			System.out.println("itemId=="+itemId);*/

			//System.out.println("itemId  in NON ex " + itemId);
			if(box.getInt("itemId"+i) != 0){
				MasStoreItem storeItem = new MasStoreItem();
				storeItem.setId(box.getInt("itemId"+i));
				storeIndentT.setItem(storeItem);
			}
			if ((box.getString("quantityReceived"+i) != null) && (!(box.getString("quantityReceived"+i).equals(""))))
				storeIndentT.setQtyReceived(new BigDecimal(box.getString("quantityReceived"+i)));
			
			if ((box.getString("qtyAuth"+i) != null) && (!(box.getString("qtyAuth"+i).equals(""))))
				storeIndentT.setQtyInMmf(new BigDecimal(box.getString("qtyAuth"+i)));
			
			if ((box.getString("qtyDemanded"+i) != null) && (!(box.getString("qtyDemanded"+i).equals(""))))
				storeIndentT.setQtyInDemand(new BigDecimal(box.getString("qtyDemanded"+i)));
			
			storeIndentT.setIndent(storeIndentM);
			hbt.save(storeIndentT);
			
			messageTOBeVisibleToTheUser = "Record added successfully";
			messageType = "success";
			}
		tx.commit();
		} catch (DataAccessException e) {
			if (tx != null)
				tx.rollback();
			messageTOBeVisibleToTheUser = "Record Not added ";
			messageType = "failure";
			
			e.printStackTrace();
		} finally {
		}

		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("messageType", messageType);

		return map;

	}

	public Map<String, Object> getIndentModifyMapForSOC(int indentId, int pageNo) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIndentM> gridIndentMList = new ArrayList<StoreIndentM>();
		List<StoreIndentT> gridIndentTList = new ArrayList<StoreIndentT>();
		@SuppressWarnings("unused")
		List<MasStoreSection> gridSectionList = new ArrayList<MasStoreSection>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		int id = 0;
		int firstResult = 0;
		int maxResults = 8;

		if (pageNo != 1) {
			firstResult = firstResult + (pageNo - 1) * 8;
		}
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		session = (Session) getSession();
		List<Object> objectList = new ArrayList<Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		try {

			Criteria c = session.createCriteria(StoreIndentT.class).add(
					Restrictions.eq("Indent.Id", indentId));
			gridIndentTList = c.list();
			//System.out.println("gridIndentTList  " + gridIndentTList.size());
			gridIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentM as md where md.Id = '"
							+ indentId + "' and md.Status='o'");
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			itemList = (List<MasStoreItem>) hbt
					.find("from jkt.hms.masters.business.MasStoreItem as mis where mis.Status='y'  and mis.Id<100");
			brandList = (List<MasStoreBrand>) hbt
					.find("from jkt.hms.masters.business.MasStoreBrand as mis where mis.Status='y' ");
			supplierList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplier as md where md.Status = 'y'");
			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'y'");
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection ");
			departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment ");
		} catch (Exception e) {
			//System.out.println("1111111111111111111111111111111111  ");
			e.printStackTrace();
		}
		map.put("gridIndentMList", gridIndentMList);
		map.put("gridIndentTList", gridIndentTList);
		map.put("indentId", indentId);
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("objectList", objectList);
		map.put("itemList", itemList);
		map.put("departmentList", departmentList);
		map.put("supplierList", supplierList);
		map.put("brandList", brandList);

		return map;
	}

	public boolean updateNextIndentToSOC(Map<String, Object> masterAndDetailMap) {

		boolean successfullyAdded = false;
		@SuppressWarnings("unused")
		StoreIndentM storeIndentM2 = new StoreIndentM();
		StoreIndentM storeIndentM3 = new StoreIndentM();
		List<StoreIndentT> storeIndentTListForUpdate = new ArrayList<StoreIndentT>();
		List<StoreIndentT> storeIndentTListForAdd = new ArrayList<StoreIndentT>();
		int indentId = 0;
		String lastChgBy = "";
		Date lastChgDate = null;
		String lastChgTime = "";
		int pageNo = 0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		session = (Session) getSession();
		try {
			tx = session.beginTransaction();
			if (masterAndDetailMap.get("storeIndentM") != null)
				storeIndentM3 = (StoreIndentM) masterAndDetailMap
						.get("storeIndentM");
			if (masterAndDetailMap.get("storeIndentTListForUpdate") != null) {
				storeIndentTListForUpdate = (List<StoreIndentT>) (masterAndDetailMap
						.get("storeIndentTListForUpdate"));
			}
			if (masterAndDetailMap.get("storeIndentTListForAdd") != null) {
				storeIndentTListForAdd = (List<StoreIndentT>) (masterAndDetailMap
						.get("storeIndentTListForAdd"));
			}
			if (masterAndDetailMap.get("indentId") != null) {
				indentId = Integer.parseInt(""
						+ masterAndDetailMap.get("indentId"));
			}

			//System.out.println("indentId indentId        " + indentId);
			if (masterAndDetailMap.get("lastChgBy") != null) {
				lastChgBy = ("" + masterAndDetailMap.get("lastChgBy"));
			}
			if (masterAndDetailMap.get("lastChgTime") != null) {
				lastChgTime = ("" + masterAndDetailMap.get("lastChgTime"));
			}
			if (masterAndDetailMap.get("pageNo") != null) {
				pageNo = Integer.parseInt(("" + masterAndDetailMap
						.get("pageNo")));
			}
			if (masterAndDetailMap.get("lastChgDate") != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn.parse(""
						+ masterAndDetailMap.get("lastChgDate")));
				lastChgDate = java.sql.Date.valueOf(date4MySQL);
			}
			if (pageNo == 1) {
				//System.out.println("hbt.update(storeIndentM3   ");
				hbt.update(storeIndentM3);
			}

			if (masterAndDetailMap.get("storeIndentTListForUpdate") != null) {
				System.out
						.println("updateNextIndent in DS ------------ 11111111");
				storeIndentTListForUpdate = (List<StoreIndentT>) masterAndDetailMap
						.get("storeIndentTListForUpdate");
				//System.out.println("updateNextIndent in DS 1------------ 2222");
				if (storeIndentTListForUpdate.size() > 0) {
					System.out
							.println("updateNextIndent in DS 1------------  333");
					for (int i = 0; i < storeIndentTListForUpdate.size(); i++) {
						System.out
								.println("updateNextIndent in DS 1------------  444");
						StoreIndentT storeIndentT = new StoreIndentT();
						System.out
								.println("updateNextIndent in DS 1------------  555");
						storeIndentT = (StoreIndentT) storeIndentTListForUpdate
								.get(i);
						System.out
								.println("updateNextIndent in DS 1------------ 666");

						StoreIndentM storeIndentM = new StoreIndentM();
						storeIndentM.setId(indentId);
						storeIndentT.setIndent(storeIndentM);

						hbt.update(storeIndentT);
						System.out
								.println("updateNextIndent in DS 1------------  777");
					}
				}
				successfullyAdded = true;
			}
			if (masterAndDetailMap.get("storeIndentTListForAdd") != null) {
				System.out
						.println("updateNextIndent in DS ------------ 11111111");
				storeIndentTListForAdd = (List<StoreIndentT>) masterAndDetailMap
						.get("storeIndentTListForAdd");
				//System.out.println("updateNextIndent in DS 1------------ 2222");
				if (storeIndentTListForAdd.size() > 0) {
					System.out
							.println("updateNextIndent in DS 1------------  333");
					for (int i = 0; i < storeIndentTListForAdd.size(); i++) {
						System.out
								.println("updateNextIndent in DS 1------------  444");
						StoreIndentT storeIndentT = new StoreIndentT();
						System.out
								.println("updateNextIndent in DS 1------------  555");
						storeIndentT = (StoreIndentT) storeIndentTListForAdd
								.get(i);
						System.out
								.println("updateNextIndent in DS 1------------ 666");

						StoreIndentM storeIndentM = new StoreIndentM();
						storeIndentM.setId(indentId);
						storeIndentT.setIndent(storeIndentM);

						hbt.save(storeIndentT);
						System.out
								.println("updateNextIndent in DS 1------------  777");
					}
				}
				successfullyAdded = true;
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			e.printStackTrace();

		} finally {
			session.close();
		}
		return successfullyAdded;

	}

	public Map<String, Object> getManufacturerNameInAjax(
			Map<String, Object> dataMap) {
		int deptId = 0;
		int brandId = 0;
		String manufacturerName = "";
		List objectList = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();
		int mId = 1;
		try {
			if (dataMap.get("deptId") != null)
				deptId = Integer.parseInt("" + dataMap.get("deptId"));
			if (dataMap.get("brandId") != null)
				brandId = Integer.parseInt("" + dataMap.get("brandId"));
			String qry = "SELECT manu.manufacturer_id,manu.manufacturer_name FROM mas_store_brand brand,mas_manufacturer manu where brand.brand_id='"
					+ brandId
					+ "' and brand.manufacturer_id=manu.manufacturer_id ;";
			objectList = (List) session.createSQLQuery(qry).list();
			if (objectList.get(0) != null)
				manufacturerName = ("" + objectList.get(0));
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				mId = (Integer) object[0];
				manufacturerName = "" + object[1];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("manufacturerName", manufacturerName);
		map.put("mId", mId);
		return map;
	}

	// ------End ofIndent To SOC-------------------------------

	// ------Indent To Depot-----------------------------------

	public Map<String, Object> getItemListForIndentToDepot(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int deptId = 0;
		int indentId = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		indentId = Integer.parseInt("" + dataMap.get("indentId"));
		List objectList = new ArrayList();
		//System.out.println("deptId  _________________" + deptId);
		//System.out.println("indentId __________________ " + indentId);
		try {
			String str = dataMap.get("autoHint") + "%";
			String qry1 = "SELECT t.item_id FROM store_indent_t t,store_indent_m m where t.indent_id='"
					+ indentId + "' and m.indent_id=t.indent_id";
			objectList = (List) session.createSQLQuery(qry1).list();
			if (objectList.size() != 0) {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.not(Restrictions.in("Id", objectList)));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			} else {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("itemList        ========================== "	+ itemList.size());
		map.put("itemList", itemList);
		return map;

	}

	public Map<String, Object> fillItemsForIndentToDepot(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int item_id = 0;
		int deptId = 0;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		List objectList = new ArrayList();
		pvmsNo = "" + dataMap.get("pvmsNo");
		try {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
			String qry = "select mas.item_id,mas.pvms_no,mas.nomenclature,mas.strength,b.stock,c.qty, mas.old_niv_no, mas.department_id,con.item_unit_name,sec.section_code from mas_store_item mas inner join mas_store_item_conversion con on mas.item_conversion_id=con.item_conversion_id inner join mas_store_section sec on  mas.section_id=sec.section_id left outer join (select ba.item_id,sum(ba.closing_stock) stock from store_item_batch_stock ba where department_id='"
					+ deptId
					+ "' group by ba.item_id)b on mas.item_id=b.item_id left outer join (select qty,item_id from store_me_scale_details )c on mas.item_id=c.item_id where mas.pvms_no='"
					+ pvmsNo + "'";
			
			System.out.println("qry "+qry);
			objectList = (List) session.createSQLQuery(qry).list();
			pvmsNo = "" + dataMap.get("pvmsNo");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("PvmsNo", pvmsNo));
			itemList = c.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("objectList", objectList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public boolean updateNextIndentToDepot(
			Map<String, Object> masterAndDetailMap) {
		boolean successfullyAdded = false;
		@SuppressWarnings("unused")
		StoreIndentM storeIndentM2 = new StoreIndentM();
		StoreIndentM storeIndentM3 = new StoreIndentM();
		List<StoreIndentT> storeIndentTListForUpdate = new ArrayList<StoreIndentT>();
		List<StoreIndentT> storeIndentTListForAdd = new ArrayList<StoreIndentT>();
		int indentId = 0;
		String lastChgBy = "";
		Date lastChgDate = null;
		String lastChgTime = "";
		int pageNo = 0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		session = (Session) getSession();
		Transaction tx = null;

		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();

			if (masterAndDetailMap.get("storeIndentM") != null)
				storeIndentM3 = (StoreIndentM) masterAndDetailMap
						.get("storeIndentM");
			if (masterAndDetailMap.get("storeIndentTListForUpdate") != null) {
				storeIndentTListForUpdate = (List<StoreIndentT>) (masterAndDetailMap
						.get("storeIndentTListForUpdate"));
			}
			if (masterAndDetailMap.get("storeIndentTListForAdd") != null) {
				storeIndentTListForAdd = (List<StoreIndentT>) (masterAndDetailMap
						.get("storeIndentTListForAdd"));
			}
			if (masterAndDetailMap.get("indentId") != null) {
				indentId = Integer.parseInt(""
						+ masterAndDetailMap.get("indentId"));
			}

			//System.out.println("indentId indentId        " + indentId);
			if (masterAndDetailMap.get("lastChgBy") != null) {
				lastChgBy = ("" + masterAndDetailMap.get("lastChgBy"));
			}
			if (masterAndDetailMap.get("lastChgTime") != null) {
				lastChgTime = ("" + masterAndDetailMap.get("lastChgTime"));
			}
			if (masterAndDetailMap.get("pageNo") != null) {
				pageNo = Integer.parseInt(("" + masterAndDetailMap
						.get("pageNo")));
			}
			if (masterAndDetailMap.get("lastChgDate") != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn.parse(""
						+ masterAndDetailMap.get("lastChgDate")));
				lastChgDate = java.sql.Date.valueOf(date4MySQL);
			}
			if (pageNo == 1) {
				//System.out.println("hbt.update(storeIndentM3   ");
				hbt.update(storeIndentM3);
			}

			if (masterAndDetailMap.get("storeIndentTListForUpdate") != null) {
				System.out
						.println("updateNextIndent in DS ------------ 11111111");
				storeIndentTListForUpdate = (List<StoreIndentT>) masterAndDetailMap
						.get("storeIndentTListForUpdate");
				//System.out.println("updateNextIndent in DS 1------------ 2222");
				if (storeIndentTListForUpdate.size() > 0) {
					System.out
							.println("updateNextIndent in DS 1------------  333");
					for (int i = 0; i < storeIndentTListForUpdate.size(); i++) {
						System.out
								.println("updateNextIndent in DS 1------------  444");
						StoreIndentT storeIndentT = new StoreIndentT();
						System.out
								.println("updateNextIndent in DS 1------------  555");
						storeIndentT = (StoreIndentT) storeIndentTListForUpdate
								.get(i);
						System.out
								.println("updateNextIndent in DS 1------------ 666");

						StoreIndentM storeIndentM = new StoreIndentM();
						storeIndentM.setId(indentId);
						storeIndentT.setIndent(storeIndentM);

						hbt.update(storeIndentT);
						System.out
								.println("updateNextIndent in DS 1------------  777");
					}
				}
				successfullyAdded = true;
			}
			if (masterAndDetailMap.get("storeIndentTListForAdd") != null) {
				System.out
						.println("updateNextIndent in DS ------------ 11111111");
				storeIndentTListForAdd = (List<StoreIndentT>) masterAndDetailMap
						.get("storeIndentTListForAdd");
				//System.out.println("updateNextIndent in DS 1------------ 2222");
				if (storeIndentTListForAdd.size() > 0) {
					System.out
							.println("updateNextIndent in DS 1------------  333");
					for (int i = 0; i < storeIndentTListForAdd.size(); i++) {
						System.out
								.println("updateNextIndent in DS 1------------  444");
						StoreIndentT storeIndentT = new StoreIndentT();
						System.out
								.println("updateNextIndent in DS 1------------  555");
						storeIndentT = (StoreIndentT) storeIndentTListForAdd
								.get(i);
						System.out
								.println("updateNextIndent in DS 1------------ 666");

						StoreIndentM storeIndentM = new StoreIndentM();
						storeIndentM.setId(indentId);
						storeIndentT.setIndent(storeIndentM);

						hbt.save(storeIndentT);
						System.out
								.println("updateNextIndent in DS 1------------  777");
					}
				}
				successfullyAdded = true;
				// --------------Transaction Ended----------
				tx.commit();

			}
		} catch (Exception e) {
			// --------------In case of Transaction Failure----------
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map getIndentModifyMapForDepot(int indentId, int pageNo) {

		Map map = new HashMap();
		List<StoreIndentM> gridIndentMList = new ArrayList<StoreIndentM>();
		List<StoreIndentT> gridIndentTList = new ArrayList<StoreIndentT>();
		@SuppressWarnings("unused")
		List<MasStoreSection> gridSectionList = new ArrayList<MasStoreSection>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		int id = 0;
		int firstResult = 0;
		int maxResults = 8;

		if (pageNo != 1) {
			firstResult = firstResult + (pageNo - 1) * 8;
		}
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		session = (Session) getSession();
		List objectList = new ArrayList();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		session = (Session) getSession();
		Transaction tx = null;
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();
			Criteria c = session.createCriteria(StoreIndentT.class).add(
					Restrictions.eq("Indent.Id", indentId));
			c.setFirstResult(firstResult);
			c.setMaxResults(maxResults);
			gridIndentTList = c.list();
			//System.out.println("gridIndentTList  " + gridIndentTList.size());
			gridIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentM as md where md.Id = '"
							+ indentId + "' and md.Status='o'");
			String qry = "select mas.item_id,mas.pvms_no,mas.nomenclature,mas.strength,b.stock,c.qty_in_mmf,mas.old_niv_no,mas.department_id,con.item_unit_name from mas_store_item mas inner join mas_store_item_conversion con on mas.item_conversion_id= con.item_conversion_id left outer join (select ba.item_id,sum(ba.closing_stock) stock from store_item_batch_stock ba where department_id=1 group by ba.item_id)b on mas.item_id=b.item_id left outer join (select it.qty_in_mmf, it.item_id from  store_indent_m im inner join store_indent_t it on im.indent_id=it.indent_id where im.mmf_for_the_year='"
					+ year + "' )c on mas.item_id=c.item_id;";
			objectList = (List) session.createSQLQuery(qry).list();
			masStoreSupplierList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplier as md where md.Status = 'y'");
			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'y'");
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection ");
			masStoreAirForceDepotList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as md where md.Status = 'y'");

			// --------------Transaction Ended----------
			tx.commit();

		} catch (Exception e) {
			// --------------In case of Transaction Failure----------
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();

		}
		//System.out.println("gridIndentMList  " + gridIndentMList.size());
		//System.out.println("gridIndentTList  " + gridIndentTList.size());
		map.put("gridIndentMList", gridIndentMList);
		map.put("gridIndentTList", gridIndentTList);
		map.put("indentId", indentId);
		map.put("masStoreSupplierList", masStoreSupplierList);
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("objectList", objectList);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addNextOrSubmitIndentToDepot(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		session = (Session) getSession();
		String successfullyAdded = "no";
		@SuppressWarnings("unused")
		int pageNo = 0;
		String maxIndentNo = "";
		StoreIndentM storeIndentM = new StoreIndentM();
		List<StoreIndentM> storeIndentMlist = new ArrayList<StoreIndentM>();
		List<StoreIndentT> storeIndentTlist = new ArrayList<StoreIndentT>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		// For Show Jsp
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();

		session = (Session) getSession();
		List objectList = new ArrayList();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));

		int indentId = 0;
		int storeFyId = 0;
		String indentNo = "";
		if (dataMap.get("storeIndentM") != null) {
			storeIndentM = (StoreIndentM) dataMap.get("storeIndentM");
		}
		if (dataMap.get("indentNo") != null) {
			indentNo = "" + dataMap.get("indentNo");
		}

		if (dataMap.get("storeIndentTlist") != null) {
			storeIndentTlist = (List<StoreIndentT>) dataMap
					.get("storeIndentTlist");
		}
		if (dataMap.get("pageNo") != null) {
			pageNo = Integer.parseInt("" + dataMap.get("pageNo"));
		}
		if (dataMap.get("indentId") != null) {
			indentId = Integer.parseInt("" + dataMap.get("indentId"));
		}
		// Session sess = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (pageNo == 1) {
				hbt.save(storeIndentM);
				storeIndentMlist = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreIndentM as md where md.IndentNo = '"
								+ indentNo + "'");
				for (StoreIndentM storeIndentM2 : storeIndentMlist) {
					indentId = storeIndentM2.getId();
					//System.out.println("indentId  in DS " + indentId);
				}
				Criteria c = session.createCriteria(StoreFyDocumentNo.class)
						.add(Restrictions.eq("Department.Id", deptId));
				storeFyDocumentNoList = c.list();
				for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
					storeFyId = documentNo.getId();
				}

				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
						.load(StoreFyDocumentNo.class, storeFyId);
				storeFyDocumentNo.setIndentToDepotNo(indentNo);
				hbt.update(storeFyDocumentNo);
			}

			if (storeIndentTlist.size() > 0) {
				if (pageNo != 1) {
					storeIndentM.setId(indentId);
				}
				for (int i = 0; i < storeIndentTlist.size(); i++) {
					StoreIndentT storeIndentTObj = new StoreIndentT();
					storeIndentTObj = (StoreIndentT) storeIndentTlist.get(i);
					storeIndentTObj.setIndent(storeIndentM);
					hbt.save(storeIndentTObj);
				}

			}
			successfullyAdded = "yes";
			String qry = "select mas.item_id,mas.pvms_no,mas.nomenclature,mas.strength,b.stock,c.qty_in_mmf,mas.old_niv_no,mas.department_id,con.item_unit_name from mas_store_item mas inner join mas_store_item_conversion con on mas.item_conversion_id= con.item_conversion_id left outer join (select ba.item_id,sum(ba.closing_stock) stock from store_item_batch_stock ba where department_id=1 group by ba.item_id)b on mas.item_id=b.item_id left outer join (select it.qty_in_mmf, it.item_id from  store_indent_m im inner join store_indent_t it on im.indent_id=it.indent_id where im.mmf_for_the_year='"
					+ year + "' )c on mas.item_id=c.item_id;";
			objectList = (List) session.createSQLQuery(qry).list();
			masStoreSupplierList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplier as md where md.Status = 'y'");
			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'y'");
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection ");
			masStoreAirForceDepotList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as md where md.Status = 'y'");
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			e.printStackTrace();
		} finally {
			// session.close();
		}

		map.put("masStoreSupplierList", masStoreSupplierList);
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("objectList", objectList);
		map.put("successfullyAdded", successfullyAdded);
		map.put("indentId", indentId);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showIndentJspDepot(Map<String, Object> dataMap) {
		//System.out.println("showIndentJspDepot");
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));

		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		int grnStartNo = 0;
		String no = "";
		session = (Session) getSession();
		List objectList = new ArrayList();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			String qry = "select mas.item_id,mas.pvms_no,mas.nomenclature,mas.strength,b.stock,c.qty_in_mmf,mas.old_niv_no,mas.department_id,con.item_unit_name from mas_store_item mas inner join mas_store_item_conversion con on mas.item_conversion_id= con.item_conversion_id left outer join (select ba.item_id,sum(ba.closing_stock) stock from store_item_batch_stock ba where department_id=1 group by ba.item_id)b on mas.item_id=b.item_id left outer join (select it.qty_in_mmf, it.item_id from  store_indent_m im inner join store_indent_t it on im.indent_id=it.indent_id where im.mmf_for_the_year='"
					+ year + "' )c on mas.item_id=c.item_id;";
			objectList = (List) session.createSQLQuery(qry).list();
			masStoreAirForceDepotList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as md where md.Status = 'y'");
			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o' and md.Department.Id='"
									+ deptId + "' and md.IndentType='d'");
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection ");
			storeFyDocumentNoList = (List) getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "'");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getIndentToDepotNo() != null) {
					no = ("" + storeFyDocumentNo.getIndentToDepotNo());
					no = getMaxNo(no);
				} else {
					no = getMaxNo("");
				}

			}

		} catch (Exception e) {
			//System.out.println("1");
			e.printStackTrace();
		}
		//System.out.println("masStoreAirForceDepotList  "+ masStoreAirForceDepotList.size());
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("maxIndentNo", no);
		map.put("objectList", objectList);
		return map;

	}

	// ------End of Indent To Depot--------
	// --------------------------------------INDENT---------
	public Map<String, Object> getItemListForMMFIndentModify(
			Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int deptId = 0;
		int issueId = 0;
		int mmfForTheYear = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		//System.out.println("================= deptId ===================== "	+ deptId);
		;
		mmfForTheYear = Integer.parseInt("" + dataMap.get("mmfForTheYear"));
		List objectList = new ArrayList();
		List objectList1 = new ArrayList();
		try {
			String str = dataMap.get("autoHint") + "%";
			String qry = "SELECT t.item_id FROM store_indent_t t,store_indent_m m where m.mmf_for_the_year='"
					+ mmfForTheYear
					+ "' and m.imported ='y' and m.indent_type='p'; ";
			objectList = (List) session.createSQLQuery(qry).list();
			if (objectList.size() != 0) {

				//System.out.println("objectList  " + objectList.size());
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.not(Restrictions.in("Id", objectList)));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			} else {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId));

				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;

	}

	public Map<String, Object> getItemListForMMFIndent(
			Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int deptId = 0;
		int issueId = 0;
		int mmfForTheYear = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		mmfForTheYear = Integer.parseInt("" + dataMap.get("mmfForTheYear"));
		List objectList = new ArrayList();
		List objectList1 = new ArrayList();
		try {
			String str = dataMap.get("autoHint") + "%";
			String qry1 = "SELECT t.item_id FROM store_indent_t t,store_indent_m m where m.mmf_for_the_year='"
					+ mmfForTheYear
					+ "' and m.imported ='y' and m.indent_type='p';";
			objectList1 = (List) session.createSQLQuery(qry1).list();
			//System.out.println("objectList1   " + objectList1.size());
			if (objectList1.size() == 0) {
				String qry = "SELECT t.item_id FROM store_indent_t t,store_indent_m m where m.mmf_for_the_year='"
						+ mmfForTheYear + "'  and m.indent_type='p'; ";
				objectList = (List) session.createSQLQuery(qry).list();
				if ((objectList.size() != 0) && (mmfForTheYear != 0)) {
					Criteria c = session.createCriteria(MasStoreItem.class)
							.add(Restrictions.like("Nomenclature", str)).add(
									Restrictions.eq("Department.Id", deptId))
							.add(
									Restrictions.not(Restrictions.in("Id",
											objectList)));
					c.setFirstResult(0);
					c.setMaxResults(10);
					itemList = c.list();
				} else {
					Criteria c = session.createCriteria(MasStoreItem.class)
							.add(Restrictions.like("Nomenclature", str)).add(
									Restrictions.eq("Department.Id", deptId));

					c.setFirstResult(0);
					c.setMaxResults(10);
					itemList = c.list();

				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//System.out.println("itemList        ========================== "	+ itemList.size());
		map.put("itemList", itemList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> checkYearExists(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIndentM> storeIndentMList = new ArrayList<StoreIndentM>();
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		int mmfForTheYear = 0;
		if (dataMap.get("mmfForTheYear") != null) {
			mmfForTheYear = Integer.parseInt("" + dataMap.get("mmfForTheYear"));
		}
		String messageType = "";
		if (mmfForTheYear != 0)
			storeIndentMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as sim where sim.MmfForTheYear='"
									+ mmfForTheYear
									+ "'  and sim.Imported='y' and sim.Status='o' and sim.IndentType='p'");
		String messageTOBeVisibleToTheUser = "";
		searchIndentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o' and md.IndentType='p'");
		if (storeIndentMList.size() == 0) {

		} else {
			messageTOBeVisibleToTheUser = "For " + mmfForTheYear
					+ " year Records already added.Go for Search to add more ";
			messageType = "failure";
		}
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("messageType", messageType);
		map.put("searchIndentList", searchIndentList);
		return map;
	}

	public Map<String, Object> lockMMFIndent(int year) {
		String messageTOBeVisibleToTheUser = "Record Not Locked";
		Map<String, Object> map = new HashMap<String, Object>();
		String messageType = "failure";
		List<StoreIndentM> storeIndentMList = new ArrayList<StoreIndentM>();
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		int indentId = 0;
		try {
			storeIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentM as sim where sim.MmfForTheYear='"
							+ year
							+ "'   and sim.Status='o' and sim.IndentType='p'");

			for (StoreIndentM storeIndentM : storeIndentMList) {
				indentId = Integer.parseInt("" + storeIndentM.getId());
			}
			if (indentId != 0) {
				StoreIndentM storeIndentM1 = (StoreIndentM) getHibernateTemplate()
						.load(StoreIndentM.class, indentId);
				storeIndentM1.setStatus("p");
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(storeIndentM1);
				messageType = "success";
				messageTOBeVisibleToTheUser = "Record  Locked";
			} else {
				messageType = "failure";
				messageTOBeVisibleToTheUser = "No Records found ";
			}

			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o' and md.IndentType='p'");

		} catch (Exception e) {
			e.printStackTrace();
			messageType = "failure";
			messageTOBeVisibleToTheUser = "Record Not Locked";
		}
		map.put("searchIndentList", searchIndentList);
		map.put("messageType", messageType);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return map;
	}

	public Map<String, Object> showLockMMFIndent() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIndentM> storeIndentMList = new ArrayList<StoreIndentM>();
		try {
			storeIndentMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as sim where sim.IndentType='p'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("storeIndentMList", storeIndentMList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> importMMFIndent(Map<String, Object> dataMap)
			throws java.text.ParseException {
		List<StoreMmfDepartmentM> storeMmfDepartmentMList = new ArrayList<StoreMmfDepartmentM>();
		List<StoreMmfDepartmentT> storeMmfDepartmentTList = new ArrayList<StoreMmfDepartmentT>();
		List<StoreIndentM> storeIndentMList = new ArrayList<StoreIndentM>();
		List<StoreIndentM> storeIndentMTempList = new ArrayList<StoreIndentM>();
		@SuppressWarnings("unused")
		StoreIndentM storeIndentM = new StoreIndentM();
		@SuppressWarnings("unused")
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		String flag = "no";
		int indentId = 0;
		int pageNo = 1;
		String messageTOBeVisibleToTheUser = "";
		String messageType = "failure";
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String no = "";
		String date = "";
		String time = "";
		String userName = "";
		Date indentDate = null;
		session = (Session) getSession();
		Transaction tx = null;
		int year = 0;
		int departmentId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null)
			departmentId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		if (dataMap.get("year") != null)
			year = Integer.parseInt("" + dataMap.get("year"));
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();

		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();

			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			date = (String) utilMap.get("currentDate");
			time = (String) utilMap.get("currentTime");
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse(date));
			Date lastChgDate = java.sql.Date.valueOf(date4MySQL);
			//System.out.println("year       v   year " + year);
			// Checking for existence of Indent
			storeIndentMTempList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentM as md where md.MmfForTheYear='"
							+ year
							+ "' and md.Imported='y' and md.IndentType='p' ");
			if (storeIndentMTempList.size() > 0) {
				messageTOBeVisibleToTheUser = "Already Imported";
				map.put("messageTOBeVisibleToTheUser",
						messageTOBeVisibleToTheUser);
				map.put("messageType", messageType);
				return map;
			}
			// Fetching records from MMF Department
			String qry = "SELECT sum(t.mmf_in_qty),t.item_id,m.id from store_mmf_department_m as m,store_mmf_department_t as t where m.id=t.store_mmf_department_m_id and m.mmf_for_the_year='"
					+ year + "' and m.status='o' group by t.Item_Id;";
			List c = (List) session.createSQLQuery(qry).list();
			if (c.size() == 0) {
				messageTOBeVisibleToTheUser = "No records in MMF Departmet";
				map.put("messageType", messageType);
				map.put("messageTOBeVisibleToTheUser",
						messageTOBeVisibleToTheUser);
				return map;
			}
			// Getting indentId if records are already entered
			storeIndentMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.MmfForTheYear='"
									+ year
									+ "' and md.Imported='n' and md.IndentType='p' and md.Status='o'");
			for (StoreIndentM storeIndentM2 : storeIndentMList) {
				indentId = storeIndentM2.getId();
				map.put("indentId", indentId);
			}
			int srNo = 1;
			int mmfDeptId = 0;
			// Importing records from MMF Department
			StoreIndentM storeIndentM2 = new StoreIndentM();
			if (indentId == 0) {
				storeIndentM2.setMmfForTheYear(year);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeIndentM2.setHospital(masHospital);

				MasDepartment department = new MasDepartment();
				department.setId(1);
				storeIndentM2.setDepartment(department);

				storeIndentM2.setSection(null);
				storeIndentM2.setItemReqDept(department);
				storeIndentM2.setSuppliedBy(null);
				storeIndentM2.setRequiredForm("Commandant,CHAFB");

				SimpleDateFormat formatterIn1 = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut2 = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL1 = formatterOut.format(formatterIn
						.parse(date));
				storeIndentM2.setIndentDate(java.sql.Date.valueOf(date4MySQL));
				storeIndentM2.setLastChgBy(userName);
				storeIndentM2.setStatus("o");
				storeIndentM2.setIndentType("p");
				storeIndentM2.setLastChgDate(java.sql.Date.valueOf(date4MySQL));
				storeIndentM2.setLastChgTime(time);
				List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
				storeFyDocumentNoList = (List) getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreFyDocumentNo ");
				for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
					if (storeFyDocumentNo.getDepartment().getId() == 1) {
						no = ("" + storeFyDocumentNo.getMmfIndentNo());
						no = getMaxNo(no);
					}
				}
				storeIndentM2.setIndentNo(no);
				storeIndentM2.setImported("y");
				MasDepartment department2 = new MasDepartment();
				department2.setId(1);
				storeIndentM2.setDepartment(department);
				MasDepartment department3 = new MasDepartment();
				department3.setId(1);
				storeIndentM2.setDepartment(department3);
				hbt.save(storeIndentM2);
				hbt.refresh(storeIndentM2);

				for (Iterator iterator = c.iterator(); iterator.hasNext();) {
					Object[] object = (Object[]) iterator.next();
					BigDecimal i0 = (BigDecimal) object[0];
					Integer i1 = (Integer) object[1];
					Integer i2 = (Integer) object[2];
					mmfDeptId = i2;
					StoreIndentT storeIndentT = new StoreIndentT();

					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(i1);
					storeIndentT.setItem(masStoreItem);
					BigDecimal bigDecimal = new BigDecimal("" + i0);
					storeIndentT.setQtyInMmf(bigDecimal);
					storeIndentT.setSerialNo(srNo);

					storeIndentT.setIndent(storeIndentM2);

					storeIndentT.setSection(null);

					hbt.save(storeIndentT);
					srNo++;
				}

			} else {
				storeIndentM2.setId(indentId);
				for (Iterator iterator = c.iterator(); iterator.hasNext();) {
					Object[] object = (Object[]) iterator.next();
					BigDecimal i0 = (BigDecimal) object[0];
					Integer i1 = (Integer) object[1];
					Integer i2 = (Integer) object[2];
					mmfDeptId = i2;
					StoreIndentT storeIndentT = new StoreIndentT();

					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(i1);
					storeIndentT.setItem(masStoreItem);
					BigDecimal bigDecimal = new BigDecimal("" + i0);
					storeIndentT.setQtyInMmf(bigDecimal);
					storeIndentT.setSerialNo(srNo);

					storeIndentT.setIndent(storeIndentM2);

					storeIndentT.setSection(null);

					hbt.save(storeIndentT);
					srNo++;
				}
			}

			String qry1 = "SELECT m.id from store_mmf_department_m as m where  m.mmf_for_the_year=2008 and m.status='o';";
			List deptList = (List) session.createSQLQuery(qry1).list();
			System.out
					.println("=======================deptList ================== "
							+ deptList.size());
			for (int i = 0; i < deptList.size(); i++) {
				mmfDeptId = Integer.parseInt("" + deptList.get(i));
				System.out
						.println("=======================deptList ================== "
								+ mmfDeptId);
				StoreMmfDepartmentM mmfDepartmentM = (StoreMmfDepartmentM) getHibernateTemplate()
						.load(StoreMmfDepartmentM.class, mmfDeptId);
				mmfDepartmentM.setStatus("p");
				hbt.update(mmfDepartmentM);
			}
			List<StoreIndentM> list2 = new ArrayList<StoreIndentM>();
			list2 = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentM as md where md.IndentNo='"
							+ no + "' ");
			//System.out.println("storeIndentMList  " + storeIndentMList.size());
			for (StoreIndentM storeIndentM3 : list2) {
				indentId = storeIndentM3.getId();
				map.put("indentId", indentId);
			}

			StoreIndentM storeIndentM1 = (StoreIndentM) getHibernateTemplate()
					.load(StoreIndentM.class, indentId);
			storeIndentM1.setImported("y");
			hbt.update(storeIndentM1);
			messageType = "success";
			map.put("messageType", messageType);
			messageTOBeVisibleToTheUser = "Records are Imported Successfull.If you want to Modify Go for Search";
			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o' and md.IndentType='p'");
			// --------------Transaction Ended----------
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// --------------In case of Transaction Failure----------
			if (tx != null)
				tx.rollback();

			map.put("messageType", messageType);
			messageTOBeVisibleToTheUser = "Records are not Imported ";
		}
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("searchIndentList", searchIndentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showImportMMFIndentJsp(
			Map<String, Object> dataMap) {
		List<StoreIndentM> indentMList = new ArrayList<StoreIndentM>();
		Map<String, Object> map = new HashMap<String, Object>();
		int departmentId = 0;
		if (dataMap.get("departmentId") != null)
			departmentId = Integer.parseInt("" + dataMap.get("departmentId"));
		try {
			session = (Session) getSession();
			String qry = "SELECT DISTINCT mmf_for_the_year  from store_mmf_department_m where status='o';";
			List list = (List) session.createSQLQuery(qry).list();
			map.put("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map getIndentDepotPrintMap(int indentId) {
		Map map = new HashMap();
		session = (Session) getSession();
		List<StoreIndentM> indentMList = new ArrayList<StoreIndentM>();

		Connection con = session.connection();
		try {
			map.put("conn", con);
			indentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentM as md where md.Id = '"
							+ indentId + "'");
			for (StoreIndentM indentM : indentMList) {
				map.put("indentNo", "" + indentM.getIndentNo());
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"yyyy-MM-dd");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"dd/MM/yyyy");
				String date4MySQL = formatterOut.format(formatterIn.parse(""
						+ indentM.getIndentDate()));
				map.put("indentDate", "" + date4MySQL);
				map.put("indentor", "Commandant,CHAFB");
				map.put("nrs", "" + indentM.getNrs());
				map.put("address", "");
				map.put("authority", "" + indentM.getAuthority());
				map.put("supplyDepot", "" + indentM.getSuppliedBy());
				map.put("indentId", "" + indentM.getId());
				map.put("typeOfIndet", " " + indentM.getIndentType());
				map.put("section", " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map showPrintIndentDepotJsp() {
		Map map = new HashMap();
		List<StoreIndentM> indentMList = new ArrayList<StoreIndentM>();
		indentMList = (List<StoreIndentM>) getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreIndentM ");
		map.put("indentMList", indentMList);
		return map;
	}

	@SuppressWarnings( { "unchecked", "deprecation", "unchecked" })
	public Map<String, Object> getIndentSocPrintMap(int indentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();
		List<StoreIndentM> indentMList = new ArrayList<StoreIndentM>();
		Connection con = session.connection();
		try {
			map.put("conn", con);
			indentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentM as md where md.Id = '"
							+ indentId + "'");
			//System.out.println("indentMList  " + indentMList.size());
			for (StoreIndentM indentM : indentMList) {
				map.put("indentNo", "" + indentM.getIndentNo());
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"yyyy-MM-dd");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"dd/MM/yyyy");
				@SuppressWarnings("unused")
				String date4MySQL = formatterOut.format(formatterIn.parse(""
						+ indentM.getIndentDate()));
				map.put("detailOfPatient", "" + indentM.getPatientDetails());
				map.put("justification", "" + indentM.getJustificationNiv());
				map.put("specificJustification", ""
						+ indentM.getPacJustification());
				map.put("dateOfReceive", "" + indentM.getEncodedDate());
				map.put("unitName", "DGFMSHQ");
				map.put("indentId", indentM.getId());

			}
		} catch (Exception e) {
			//System.out.println("-------------" + e);
		}
		return map;
	}

	public Map getIndentModifyMap(int indentId, int pageNo) {

		Map map = new HashMap();
		List<StoreIndentM> gridIndentMList = new ArrayList<StoreIndentM>();
		List<StoreIndentT> gridIndentTList = new ArrayList<StoreIndentT>();
		List<MasStoreSection> gridSectionList = new ArrayList<MasStoreSection>();
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		int id = 0;
		int firstResult = 0;
		int maxResults = 8;
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		if (pageNo != 1) {
			firstResult = firstResult + (pageNo - 1) * 8;
		}

		try {
			Session session = (Session) getSession();
			Criteria c = session.createCriteria(StoreIndentT.class).add(
					Restrictions.eq("Indent.Id", indentId));
			c.setFirstResult(firstResult);
			c.setMaxResults(maxResults);
			gridIndentTList = c.list();
			itemList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreItem as mi where mi.Status = 'y' and mi.Id<100");
			gridIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentM as md where md.Id = '"
							+ indentId + "' and md.Status='o'");
			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o' and md.IndentType='p'");
			for (StoreIndentM storeIndentM : gridIndentMList) {
				id = storeIndentM.getMmfForTheYear();
			}
		} catch (Exception e) {
			//System.out.println("1111111111111111111111111111111111  ");
			e.printStackTrace();
		}

		map.put("gridIndentMList", gridIndentMList);
		map.put("gridIndentTList", gridIndentTList);
		map.put("indentId", indentId);
		map.put("mmfForTheYear", id);
		map.put("itemList", itemList);
		map.put("searchIndentList", searchIndentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> checkExistenceOfCuurentYearIndent(int year) {
		Map<String, Object> indentMap = new HashMap<String, Object>();
		List<StoreIndentM> tempIndentList = new ArrayList<StoreIndentM>();
		List<StoreIndentM> searchPanelIndentList = new ArrayList<StoreIndentM>();
		List<StoreIndentM> searchIndentListForNextYear = new ArrayList<StoreIndentM>();
		boolean masterRecordExist = false;
		int noOfRecordsAlreadyStored = 0;
		@SuppressWarnings("unused")
		int MaxSrNo = 0;
		int indentId = 0;
		int noOfRecordsAlreadyStoredNextYear = 0;
		List<StoreIndentT> gridIndentTList = new ArrayList<StoreIndentT>();
		tempIndentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreIndentM as md where md.MmfForTheYear = '"
						+ year + "' and md.IndentType='p'");
		int nextYear = year + 1;
		searchIndentListForNextYear = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreIndentM as md where md.MmfForTheYear = '"
						+ nextYear + "' and md.IndentType='p'");
		if (searchIndentListForNextYear.size() > 0) {
			noOfRecordsAlreadyStoredNextYear = searchIndentListForNextYear
					.size();
		}
		if (tempIndentList.size() > 0) {
			masterRecordExist = true;
			for (StoreIndentM storeIndentM : tempIndentList) {
				indentId = Integer.parseInt("" + storeIndentM.getId());
			}
			gridIndentTList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentT as md where md.Indent.Id = '"
							+ indentId + "' ");
			if (gridIndentTList.size() > 0)
				noOfRecordsAlreadyStored = gridIndentTList.size();

		}
		searchPanelIndentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'y' and  md.IndentType='p'");
		//System.out.println("searchPanelIndentList     in DATA SERVICE "+ searchPanelIndentList.size());
		indentMap.put("masterRecordExist", masterRecordExist);
		indentMap.put("noOfRecordsAlreadyStored", noOfRecordsAlreadyStored);
		indentMap.put("noOfRecordsAlreadyStoredNextYear",
				noOfRecordsAlreadyStoredNextYear);
		indentMap.put("indentId", indentId);
		indentMap.put("searchPanelIndentList", searchPanelIndentList);
		return indentMap;
	}

	@SuppressWarnings("unchecked")
	public Map showIndent() {

		// session = (Session)getSession();
		// Transaction tx = null;
		// try{
		// //--------------Transaction Started----------
		// tx= session.beginTransaction();
		// //--------------Transaction Ended----------
		// tx.commit();
		// }catch (Exception e) {
		// //--------------In case of Transaction Failure----------
		// if (tx != null) tx.rollback();
		// //System.out.println("****************************************");
		// //System.out.println("---------HMS TRANSACTION ERROR----------");
		// //System.out.println("****************************************");
		// e.printStackTrace();
		// }
		// finally{
		// //--------Session Closing----------
		// session.close();
		// }
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		int grnStartNo = 0;
		String no = "";

		try {
			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o' and md.IndentType='p'");
		} catch (Exception e) {
			//System.out.println("1");
		}
		itemList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreItem as mi where mi.Status = 'y' and mi.Id<100");
		try {
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection ");
		} catch (Exception e) {
			//System.out.println("2");
		}

		try {
			storeFyDocumentNoList = (List) getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreFyDocumentNo ");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getDepartment().getId() == 1) {
					no = ("" + storeFyDocumentNo.getMmfIndentNo());
					//System.out.println("noooooooooooooooooooooooooooooooooo "	+ no);
					no = getMaxNo(no);
					//System.out.println("no     " + no);
				}
			}
		} catch (Exception e) {
			//System.out.println("in db    " + e);
			e.printStackTrace();
		}
		//System.out.println("searchIndentList  " + searchIndentList.size());
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("itemList", itemList);
		map.put("maxIndentNo", no);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map searchIndent(Map searchFieldMap){
		Map<String, Object> map = new HashMap<String, Object>();
		String fromDate = "";
		String toDate = "";
		List<StoreIndentM> gridIndentHeaderList = new ArrayList<StoreIndentM>();
		List<StoreIndentT> gridIndentDetailList = new ArrayList<StoreIndentT>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		String indentNo = "";
		int mmfYear = 0;

		try {
			if (searchFieldMap.get("mmfYear") != null) {

				mmfYear = Integer.parseInt("" + searchFieldMap.get("mmfYear"));
				gridIndentDetailList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreIndentT ");
				gridIndentHeaderList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreIndentM as sim where sim.MmfForTheYear = '"
								+ mmfYear + "' and sim.Status='y' ");

			}
		} catch (Exception e) {
			//System.out.println("in ddddddddddd  " + e);
			e.printStackTrace();
		}

		map.put("gridIndentDetailList", gridIndentDetailList);
		map.put("gridIndentHeaderList", gridIndentHeaderList);
		map.put("itemList", itemList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addNextOrSubmitIndentToMMF(StoreIndentM storeIndentM,
			List storeIndentTlist, Map map) {

		boolean successfullyAdded = false;
		@SuppressWarnings("unused")
		int pageNo = 0;
		String maxIndentNo = "";
		StoreIndentM storeIndentM2 = new StoreIndentM();
		session = (Session) getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			if (!(map.get("headerStored") + "").equals("yes")) {
				hbt.save(storeIndentM);
			}

			if (storeIndentTlist.size() > 0) {
				if ((map.get("headerStored") + "").equals("yes")) {
					int id = Integer.parseInt("" + map.get("indentId"));
					storeIndentM2.setId(id);
				}
				for (int i = 0; i < storeIndentTlist.size(); i++) {
					StoreIndentT storeIndentTObj = new StoreIndentT();
					storeIndentTObj = (StoreIndentT) storeIndentTlist.get(i);
					if ((map.get("headerStored") + "").equals("yes")) {
						storeIndentTObj.setIndent(storeIndentM2);
					} else {
						storeIndentTObj.setIndent(storeIndentM);
					}
					hbt.save(storeIndentTObj);
				}

			}
			successfullyAdded = true;
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// throw e; // or display error message
			e.printStackTrace();
		} finally {
			session.close();
		}

		return successfullyAdded;
	}

	public boolean updateIndent(StoreIndentM storeIndentM, List storeIndentTlist) {
		boolean successfullyAdded = false;
		StoreIndentM storeIndentM2 = new StoreIndentM();
		storeIndentM2 = storeIndentM;
		//System.out.println("uuuuu");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");

		hbt.setCheckWriteOperations(false);

		try {

			hbt.update(storeIndentM2);
		} catch (Exception e) {
			//System.out.println("1111111111111111  " + e);
		}
		try {

			if (storeIndentTlist.size() > 0) {
				//System.out.println("storeIndentTlist.size()   "	+ storeIndentTlist.size());
				//System.out.println("its in Detail part");
				// StoreIndentM storeIndentM2=new StoreIndentM();
				// storeIndentM2.setId(1);
				//System.out.println("its in Detail part2");
				for (int i = 0; i < storeIndentTlist.size(); i++) {
					//System.out.println("its in Detail part 3");
					StoreIndentT storeIndentTObj = new StoreIndentT();
					storeIndentTObj = (StoreIndentT) storeIndentTlist.get(i);
					// storeIndentTObj.setIndent(storeIndentM2);
					hbt.update(storeIndentTObj);
				}

			}
			successfullyAdded = true;
		} catch (Exception e) {
			//System.out.println("34234 " + e);
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean updateNextIndent(Map<String, Object> masterAndDetailMap)
			throws java.text.ParseException {
		boolean successfullyAdded = false;
		StoreIndentM storeIndentM2 = new StoreIndentM();
		List<StoreIndentT> storeIndentTListForUpdate = new ArrayList<StoreIndentT>();
		List<StoreIndentT> storeIndentTListForAdd = new ArrayList<StoreIndentT>();
		int indentId = 0;
		String lastChgBy = "";
		Date lastChgDate = null;
		String lastChgTime = "";
		int pageNo = 0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			if (masterAndDetailMap.get("storeIndentTListForUpdate") != null) {
				storeIndentTListForUpdate = (List<StoreIndentT>) (masterAndDetailMap
						.get("storeIndentTListForUpdate"));
			}
			if (masterAndDetailMap.get("storeIndentTListForAdd") != null) {
				storeIndentTListForAdd = (List<StoreIndentT>) (masterAndDetailMap
						.get("storeIndentTListForAdd"));
			}
			if (masterAndDetailMap.get("indentId") != null) {
				indentId = Integer.parseInt(""
						+ masterAndDetailMap.get("indentId"));
			}
			if (masterAndDetailMap.get("lastChgBy") != null) {
				lastChgBy = ("" + masterAndDetailMap.get("lastChgBy"));
			}
			if (masterAndDetailMap.get("lastChgTime") != null) {
				lastChgTime = ("" + masterAndDetailMap.get("lastChgTime"));
			}
			if (masterAndDetailMap.get("pageNo") != null) {
				pageNo = Integer.parseInt(("" + masterAndDetailMap
						.get("pageNo")));
			}
			if (masterAndDetailMap.get("lastChgDate") != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn.parse(""
						+ masterAndDetailMap.get("lastChgDate")));
				lastChgDate = java.sql.Date.valueOf(date4MySQL);
			}
			if (pageNo == 1) {
				StoreIndentM storeIndentM = (StoreIndentM) getHibernateTemplate()
						.load(StoreIndentM.class, indentId);
				storeIndentM.setLastChgBy(lastChgBy);
				storeIndentM.setLastChgDate(lastChgDate);
				storeIndentM.setLastChgTime(lastChgTime);
				hbt.update(storeIndentM);
			}

			if (masterAndDetailMap.get("storeIndentTListForUpdate") != null) {
				System.out
						.println("updateNextIndent in DS ------------ 11111111");
				storeIndentTListForUpdate = (List<StoreIndentT>) masterAndDetailMap
						.get("storeIndentTListForUpdate");
				//System.out.println("updateNextIndent in DS 1------------ 2222");
				if (storeIndentTListForUpdate.size() > 0) {
					System.out
							.println("updateNextIndent in DS 1------------  333");
					for (int i = 0; i < storeIndentTListForUpdate.size(); i++) {
						System.out
								.println("updateNextIndent in DS 1------------  444");
						StoreIndentT storeIndentT = new StoreIndentT();
						System.out
								.println("updateNextIndent in DS 1------------  555");
						storeIndentT = (StoreIndentT) storeIndentTListForUpdate
								.get(i);
						System.out
								.println("updateNextIndent in DS 1------------ 666");

						StoreIndentM storeIndentM = new StoreIndentM();
						storeIndentM.setId(indentId);
						storeIndentT.setIndent(storeIndentM);

						hbt.update(storeIndentT);
						System.out
								.println("updateNextIndent in DS 1------------  777");
					}
				}
				successfullyAdded = true;
			}
			if (masterAndDetailMap.get("storeIndentTListForAdd") != null) {
				System.out
						.println("updateNextIndent in DS ------------ 11111111");
				storeIndentTListForAdd = (List<StoreIndentT>) masterAndDetailMap
						.get("storeIndentTListForAdd");
				//System.out.println("updateNextIndent in DS 1------------ 2222");
				if (storeIndentTListForAdd.size() > 0) {
					System.out
							.println("updateNextIndent in DS 1------------  333");
					for (int i = 0; i < storeIndentTListForAdd.size(); i++) {
						System.out
								.println("updateNextIndent in DS 1------------  444");
						StoreIndentT storeIndentT = new StoreIndentT();
						System.out
								.println("updateNextIndent in DS 1------------  555");
						storeIndentT = (StoreIndentT) storeIndentTListForAdd
								.get(i);
						System.out
								.println("updateNextIndent in DS 1------------ 666");

						StoreIndentM storeIndentM = new StoreIndentM();
						storeIndentM.setId(indentId);
						storeIndentT.setIndent(storeIndentM);

						hbt.save(storeIndentT);
						System.out
								.println("updateNextIndent in DS 1------------  777");
					}
				}
				successfullyAdded = true;
				tx.commit();
			}
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// throw e; // or display error message
			e.printStackTrace();
		} finally {
			session.close();
		}

		return successfullyAdded;
	}

	public StoreIndentM getStoresIndentMObject(int indentId) {
		StoreIndentM storeIndentM = (StoreIndentM) getHibernateTemplate().load(
				StoreIndentM.class, indentId);
		return storeIndentM;
	}

	@SuppressWarnings("unchecked")
	public int getIndentId(int mmfForTheYear) {
		@SuppressWarnings("unused")
		int indentId = 0;
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();
		list = (List) getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreIndentM as pod where pod.MmfForTheYear = '"
						+ mmfForTheYear + "'");
		for (StoreIndentM indentM2 : list) {
			indentId = Integer.parseInt("" + indentM2.getId());
		}
		return indentId;
	}

	public Map getIndentMAndT(int indentId) {
		Map map = new HashMap();
		List<StoreIndentM> previousStoreIndentMList = new ArrayList<StoreIndentM>();
		List<StoreIndentT> previousStoreIndentTList = new ArrayList<StoreIndentT>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

		try {
			//System.out.println("indentId in db  " + indentId);
			previousStoreIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentM as sm where sm.Id='"
							+ indentId + "'");
			previousStoreIndentTList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentT ");
			itemList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreItem as mi where mi.Status = 'y' and mi.Id<100");
			//System.out.println("previousStoreIndentMList  "+ previousStoreIndentMList.size());
		} catch (Exception e) {
			System.out
					.println("11111111111111              1222222222222222222222"
							+ e);
		}
		//System.out.println("previousStoreIndentMList  "+ previousStoreIndentMList.size());
		//System.out.println("previousStoreIndentTList  "	+ previousStoreIndentTList.size());
		map.put("previousStoreIndentMList", previousStoreIndentMList);
		map.put("previousStoreIndentTList", previousStoreIndentTList);
		map.put("itemList", itemList);

		return map;
	}

	public Map getIndentMAndTUpdate(int indentId) {
		Map map = new HashMap();
		List<StoreIndentM> gridIndentMList = new ArrayList<StoreIndentM>();
		List<StoreIndentT> gridIndentTList = new ArrayList<StoreIndentT>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

		try {
			gridIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentM as sm where sm.Id='"
							+ indentId + "'");
			gridIndentTList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentT as st where st.Indent.Id='"
							+ indentId + "'  ");
		} catch (Exception e) {
			System.out
					.println("11111111111111              1222222222222222222222"
							+ e);
		}

		map.put("gridIndentMList", gridIndentMList);
		map.put("gridIndentTList", gridIndentTList);

		return map;
	}

	// ---------------------------------------- Department Issue
	// ----------------------

	public Map<String, Object> getIssuePrintMap(int issue_m_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
		session = (Session) getSession();
		List<StoreIndentM> indentMList = new ArrayList<StoreIndentM>();
		Connection con = session.connection();
		String demanNo = "";
		String accountingUnit = "";
		String recieptVoucherNo = "";
		String period1 = "";
		String period2 = "";
		String unit1 = "";
		String unit2 = "";
		String address1 = "";
		String address2 = "";
		String depotNo = "";
		String civNo = "";
		String dated = "";
		//System.out.println("issue_m_id in DS " + issue_m_id);
		try {
			storeIssueMList = getHibernateTemplate().find(
					" from jkt.hms.masters.business.StoreIssueM as sim where sim.Id='"
							+ issue_m_id + "'");
			//System.out.println("storeIssueMList  storeIssueMList "+ storeIssueMList.size());
			for (StoreIssueM storeIssueM : storeIssueMList) {
				demanNo = "" + storeIssueM.getIssueNo();
				accountingUnit = "";
				recieptVoucherNo = "" + storeIssueM.getRequestNo();
				period1 = "" + storeIssueM.getIssueNo();
				period2 = "" + storeIssueM.getIssueNo();
				unit1 = "" + storeIssueM.getDepartment().getDepartmentName();
				address1 = "CHAFB,Bangalore-7";
				address2 = "CHAFB,Bangalore-7";
				civNo = "CIV" + storeIssueM.getIssueNo();
				dated = ""
						+ HMSUtil.changeDateToddMMyyyy(storeIssueM
								.getIssueDate());
				unit2 = ""
						+ storeIssueM.getToDepot().getDepartment()
								.getDepartmentName();
				depotNo = ""
						+ storeIssueM.getToDepot().getDepartment()
								.getDepartmentCode();
			}
		} catch (Exception e) {
			//System.out.println("111 2222 " + e);
			e.printStackTrace();
		}
		map.put("demandNo", demanNo);
		map.put("accountingUnit", "");
		map.put("recieptVoucherNo", recieptVoucherNo);
		map.put("period1", period1);
		map.put("period2", period2);
		map.put("unit1", unit1);
		map.put("unit2", unit2);
		map.put("address1", address1);
		map.put("address2", address2);
		map.put("depotNo", depotNo);
		map.put("civNo", civNo);
		map.put("dated", dated);
		map.put("conn", con);
		return map;
	}

	public Map<String, Object> showPrintIssueToDispensary() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
		try {
			storeIssueMList = getHibernateTemplate().find(
					" from jkt.hms.masters.business.StoreIssueM as sgrm");
		} catch (Exception e) {
			//System.out.println("ee " + e);
		}
		//System.out.println("storeGrnReturnMList " + storeIssueMList.size());
		map.put("storeIssueMList", storeIssueMList);
		return map;
	}

	public Map<String, Object> getAdjustLoanOutMap(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int currentMonth = gregorianCalendar.get(Calendar.MONTH) + 1;
		int currentYear = Integer.parseInt(""
				+ gregorianCalendar.get(Calendar.YEAR));
		int toStoreId = 0;

		int deptId = 0;
		int issueMId = 0;

		String monthAndYear = "";
		try {
			if (dataMap.get("deptId") != null) {
				deptId = Integer.parseInt("" + dataMap.get("deptId"));
			}
			if (dataMap.get("toStoreId") != null) {
				toStoreId = Integer.parseInt("" + dataMap.get("toStoreId"));
			}
			if (currentMonth == 1) {
				currentMonth = 12;
				currentYear = currentYear - 1;
				monthAndYear = (currentYear + "-" + currentMonth);

			} else {
				if (currentMonth <= 10) {
					monthAndYear = (currentYear + "-0" + (currentMonth - 1));
				} else {
					monthAndYear = (currentYear + "-" + (currentMonth - 1));
				}
			}
			//System.out.println("monthAndYear     " + monthAndYear);
			storeIssueTList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIssueT as sim where  substring(sim.IssueM.IssueDate, 1,7) = '"
									+ monthAndYear
									+ "' and  sim.IssueM.IssueType='l'  and sim.IssueM.Status='o' and sim.IssueM.Department.Id='"
									+ deptId
									+ "' and sim.IssueM.ToStore.Id='"
									+ toStoreId + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("storeIssueTList " + storeIssueTList.size());
		map.put("storeIssueTList", storeIssueTList);
		map.put("issueMId", issueMId);

		return map;
	}

	/*
	 * This method is user to evaluate auto generated number based on the year
	 * It takes one parameter that is coming from store_fy_document_no
	 */
	public String getMaxNo(String no) {
		String maxNo = "";
		String y1 = "";
		String y2 = "";
		String y3 = "";
		int tempMonth = 0;
		if ((no == null) || (no.equals("0"))) {
			no = "";
		}
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int currentMonth = gregorianCalendar.get(Calendar.MONTH) + 1;
		String currentYear = "" + gregorianCalendar.get(Calendar.YEAR);
		try {

			if ((Integer.parseInt(currentYear.substring(2)) - 1) <= 9)
				y1 = "0" + (Integer.parseInt(currentYear.substring(2)) - 1);
			else
				y1 = "" + (Integer.parseInt(currentYear.substring(2)) - 1);

			if (Integer.parseInt(currentYear.substring(2)) <= 9)
				y2 = "0" + Integer.parseInt(currentYear.substring(2));
			else
				y2 = "" + Integer.parseInt(currentYear.substring(2));
			if ((Integer.parseInt(currentYear.substring(2)) + 1) <= 9)
				y3 = "0" + (Integer.parseInt(currentYear.substring(2)) + 1);
			else
				y3 = "" + (Integer.parseInt(currentYear.substring(2)) + 1);
			//System.out.println("y1 " + y1);
			//System.out.println("y2 " + y2);
			//System.out.println("y3 " + y3);
		} catch (Exception e) {
			System.out
					.println("111111111111111111111111111111111111111111111111");
		}
		try {
			if (!no.equals("")) {
				StringTokenizer stringTokenizer = new StringTokenizer(no, "/");
				tempMonth = Integer.parseInt(stringTokenizer.nextToken());

				tempMonth++;

				if (currentMonth < 4) {

					maxNo = tempMonth + "/" + y1 + "-" + y2;
				} else {
					maxNo = tempMonth + "/" + y2 + "-" + y3;
				}

			} else {
				if (currentMonth < 4) {
					//System.out.println("1");
					maxNo = "01" + "/" + y1 + "-" + y2;
				} else {
					//System.out.println("2");
					maxNo = "01" + "/" + y2 + "-" + y3;
				}
			}
		} catch (Exception e) {
			//System.out.println("getMaxNo    " + e);
			e.printStackTrace();
		}
		//System.out.println("maxNo" + maxNo);
		return maxNo;
	}

	public Map getBrandMap(Map<String, Object> dataMap)
			throws java.text.ParseException {
		Map map = new HashMap();
		List masStoreBrandList = new ArrayList();
		session = (Session) getSession();
		int deptId = 0;
		int itemId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("itemId") != null) {
			itemId = Integer.parseInt("" + dataMap.get("itemId"));
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = formatterOut.format(formatterIn.parse(date));
		Date issueDate = java.sql.Date.valueOf(date4MySQL);

		//System.out.println("itemId  " + itemId);
		//System.out.println("deptId  " + deptId);
		try {
			String qry = "select brand.brand_id,brand.brand_name,stock.batch_no,stock.expiry_date,stock.closing_stock FROM mas_store_brand brand,store_item_batch_stock stock where brand.item_id='"
					+ itemId
					+ "' and brand.brand_id=stock.brand_id  and stock.department_id='"
					+ deptId
					+ "' and  stock.closing_stock >0  and stock.expiry_date>'"
					+ issueDate + "';";
			masStoreBrandList = (List) session.createSQLQuery(qry).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("masStoreBrandList  " + masStoreBrandList.size());
		map.put("masStoreBrandList", masStoreBrandList);
		return map;
	}

	public boolean addBrandDetails(Map<String, Object> dataMap) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}
		String issueNo = "";
		int[] brandIdList = new int[100];
		BigDecimal[] qtyIssuedArray = new BigDecimal[100];
		int issueId = 0;
		int itemId = 0;
		int detailId = 0;
		int itemIssuedIdArray[] = null;
		String qtyIssuedTempArray[] = null;
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		int storeFyId = 0;
		if (dataMap.get("itemIssuedIdArray") != null) {
			itemIssuedIdArray = (int[]) dataMap.get("itemIssuedIdArray");
		}
		if (dataMap.get("qtyIssuedTempArray") != null) {
			qtyIssuedTempArray = (String[]) dataMap.get("qtyIssuedTempArray");
		}
		if (dataMap.get("itemId") != null) {
			itemId = Integer.parseInt("" + dataMap.get("itemId"));
		}
		if (dataMap.get("storeIssueTList") != null) {
			storeIssueTList = (List) dataMap.get("storeIssueTList");
		}
		if (dataMap.get("issueId") != null) {
			issueId = Integer.parseInt("" + dataMap.get("issueId"));
		}
		if (dataMap.get("issueNo") != null) {
			issueNo = ("" + dataMap.get("issueNo"));
		}
		if (dataMap.get("detailId") != null) {
			detailId = Integer.parseInt("" + dataMap.get("detailId"));
			//System.out.println("detailId  " + detailId);
		}
		//System.out.println("issueNo          " + issueNo);
		boolean successfullyAdded = false;

		session = (Session) getSession();
		Transaction tx = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();
			StoreIssueM storeIssueM2 = new StoreIssueM();
			//System.out.println("111");

			String hql = "delete from jkt.hms.masters.business.StoreIssueT as a where a.Id='"
					+ detailId + "'";
			Query query = session.createQuery(hql);
			int row = query.executeUpdate();
			if (storeIssueTList.size() > 0)
				for (int i = 0; i < storeIssueTList.size(); i++) {
					StoreIssueT issueTObj = new StoreIssueT();
					issueTObj = (StoreIssueT) storeIssueTList.get(i);
					issueTObj.setIssued("y");
					hbt.save(issueTObj);
				}
			for (int i = 0; i < qtyIssuedTempArray.length; i++) {
				String qry = "select closing_stock from store_item_batch_stock where brand_id="
						+ itemIssuedIdArray[i];
				List c = (List) session.createSQLQuery(qry).list();
				BigDecimal stock = (BigDecimal) c.get(0);
				String hql2 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.ClosingStock='"
						+ stock.subtract(new BigDecimal(qtyIssuedTempArray[i]))
						+ "' where a.Brand.Id='" + itemIssuedIdArray[i] + "'";
				Query query2 = session.createQuery(hql2);
				int row2 = query2.executeUpdate();
				// hbt.update(storeItemBatchStock);
			}
			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}

			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
					.load(StoreFyDocumentNo.class, storeFyId);
			storeFyDocumentNo.setIssueDeptNo(issueNo);
			hbt.update(storeFyDocumentNo);

			// --------------Transaction End----------
			tx.commit();
			successfullyAdded = true;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return successfullyAdded;
	}

	public int getIssueId(String issueNo) {
		List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
		int id = 0;
		try {
			storeIssueMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIssueM as msb where msb.IssueNo = '"
							+ issueNo + "'");
			//System.out.println("storeIssueMList " + storeIssueMList.size());
		} catch (Exception e) {
			//System.out.println("--- in Db " + e);
			e.printStackTrace();
		}
		for (StoreIssueM storeIssueM : storeIssueMList) {
			id = storeIssueM.getId();
		}
		return id;
	}

	// -------------------------------------- Start of Indent Soc Tracker
	// ------------------------------------------

	public Map<String, Object> getItemListForSocTracker(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIndentT> storeIndentTList = new ArrayList<StoreIndentT>();
		int indentId = 0;

		try {
			if (dataMap.get("indentId") != null) {
				indentId = Integer.parseInt("" + dataMap.get("indentId"));
			}
			if (indentId != 0) {
				storeIndentTList = getHibernateTemplate().find(
						" from jkt.hms.masters.business.StoreIndentT as sit where   sit.Indent.Id= '"
								+ indentId + "'");
			}
			map.put("storeIndentTList", storeIndentTList);
			//System.out.println("storeIndentTList  storeIndentTList  "	+ storeIndentTList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	public Map<String, Object> getIndentListForSocTracker(
			Map<String, Object> dataMap) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIndentM> storeIndentMList = new ArrayList<StoreIndentM>();
		int selectedDepartmentId = 0;
		if (dataMap.get("selectedDepartmentId") != null) {
			selectedDepartmentId = Integer.parseInt(""
					+ dataMap.get("selectedDepartmentId"));
		}
		if (selectedDepartmentId != 0)
			storeIndentMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as sim where sim.IndentType='s' and sim.Status='o' and sim.ItemReqDept.Id= '"
									+ selectedDepartmentId + "'");
		map.put("storeIndentMList", storeIndentMList);
		return map;
	}

	/*
	 * This is the method to get the Indent Soc Tracker related lists
	 */
	public Map<String, Object> showIndentSocTracker() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		Session session = (Session) getSession();
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);

		return map;

	}

	/*
	 * This is the method to get the map from store_indent_soc_tracker table
	 * based on the indentId,departmentId,nomenclature
	 */
	public Map<String, Object> getIndentSocTracker(Map<String, Object> idsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIndentSocTracker> storeIndentSocTrackerList = new ArrayList<StoreIndentSocTracker>();
		List<StoreIndentT> indentTList = new ArrayList<StoreIndentT>();
		List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
		int indentId = 0;
		int toDepartmentId = 0;
		String nomenclature = "";
		int indentIdForGrid = 0;
		int itemId = 0;
		if (idsMap.get("indentId") != null) {
			indentId = Integer.parseInt("" + idsMap.get("indentId"));
		}
		if (idsMap.get("toDepartmentId") != null) {
			toDepartmentId = Integer
					.parseInt("" + idsMap.get("toDepartmentId"));
		}
		if (idsMap.get("itemId") != null) {
			itemId = Integer.parseInt("" + idsMap.get("itemId"));
		}
		//System.out.println("indentId  ======================================"	+ indentId);
		System.out
				.println("toDepartmentId  ======================================"
						+ toDepartmentId);
		//System.out.println("itemId  " + itemId);

		storeIndentSocTrackerList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.StoreIndentSocTracker as sist where sist.Department='"
								+ toDepartmentId
								+ "' and sist.Indent.Id='"
								+ indentId
								+ "' and sist.Item.Id='"
								+ itemId
								+ "'");
		indentTList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreIndentT as sist where  sist.Indent.Id='"
						+ indentId + "' and sist.Item.Id='" + itemId + "'");
		map.put("storeIndentSocTrackerList", storeIndentSocTrackerList);
		map.put("indentTList", indentTList);
		return map;
	}

	/*
	 * This is the method used to add or update the Indent Soc Tracker details
	 */
	public boolean addOrUpdateIndentSocTracker(
			StoreIndentSocTracker indentSocTracker, int indentSocTrackerId) {
		Boolean addOrUpdate = false;
		session = (Session) getSession();
		Transaction tx = null;
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();

			if (indentSocTrackerId != 0) {
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(indentSocTracker);
				//System.out.println("in Update ");
			} else {
				HibernateTemplate hbt2 = getHibernateTemplate();
				hbt2.setFlushModeName("FLUSH_AUTO");
				hbt2.setCheckWriteOperations(false);
				hbt2.save(indentSocTracker);
				//System.out.println("in Add ");
			}
			addOrUpdate = true;
			// --------------Transaction Ended----------
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();
		}
		//System.out.println("addOrUpdate  " + addOrUpdate);
		return addOrUpdate;
	}

	public Map<String, Object> getItemMapForAutoComplete() {
		//System.out.println("getItemMapForAutoComplete in DS 1");
		Map<String, Object> map = new HashMap<String, Object>();
		//System.out.println("getItemMapForAutoComplete in DS 2");
		List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
		List<MasFormation> list = new ArrayList<MasFormation>();
		//System.out.println("getItemMapForAutoComplete in DS 3");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			//System.out.println("getHibernateTemplate()  "	+ getHibernateTemplate());
			list = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasFormation ");
			masStoreItemList = (List<MasStoreItem>) hbt
					.find("from jkt.hms.masters.business.MasStoreItem as mis where mis.Status='y'  and mis.Id<100");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("getItemMapForAutoComplete in DS 4");
		map.put("masStoreItemList", masStoreItemList);
		//System.out.println("getItemMapForAutoComplete    "+ masStoreItemList.size());
		return map;
	}

	// ----------------------------Start Of Issues To Dispensary (CIV)
	// ----------------------

	public Map showIssueDispensaryJsp(Map<String, Object> dataMap) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}
		Map map = new HashMap();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasStoreBrand> masStoreBrandList = new ArrayList<MasStoreBrand>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();
		String max = "";
		String startNo = "";
		String no = "";
		try {
			patientList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.Patient as pt where pt.Status='y'");
			storeInternalIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreInternalIndentM");
			departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment");
			masStoreAirForceDepotList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreAirForceDepot");
			employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee");
			storeFyDocumentNoList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "' ");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getIssueDeptNo() != null) {
					no = ("" + storeFyDocumentNo.getIssueDeptNo());
				} else {
					no = "";
				}

			}
			searchListForPopup = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIssueM sim where sim.Department.Id='"
							+ deptId
							+ "' and sim.Status='o' and sim.IssueType='i'");

		} catch (Exception e) {
			//System.out.println("In showIssueDispensaryJsp " + e);
		}
		//System.out.println("==================no================== " + no);
		try {
			max = getMaxNo(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("storeInternalIndentMList", storeInternalIndentMList);
		map.put("storeInternalIndentTList", storeInternalIndentTList);
		map.put("departmentList", departmentList);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("employeeList", employeeList);
		map.put("max", max);
		map.put("masStoreBrandList", masStoreBrandList);
		map.put("searchListForPopup", searchListForPopup);
		map.put("patientList", patientList);
		return map;
	}

	public Map<String, Object> getIssueDetailPageByPage(
			Map<String, Object> pageMap) {
		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<StoreIssueT> issueTList = new ArrayList<StoreIssueT>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		int issueId = 0;
		int pageNo = 1;
		String issued = "n";
		int deptId = 0;
		deptId = Integer.parseInt("" + pageMap.get("deptId"));
		HibernateTemplate hbt = getHibernateTemplate();
		session = (Session) getSession();
		if (pageMap.get("pageNo") != null) {
			pageNo = Integer.parseInt("" + pageMap.get("pageNo"));
		}

		int firstResult = 0;
		int maxResults = 8;

		if (pageNo != 1) {
			firstResult = firstResult + (pageNo - 1) * 8;
		}
		try {
			if (pageMap.get("issueId") != null) {
				issueId = Integer.parseInt("" + pageMap.get("issueId"));
			}
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// Hibernate Pagination
			Criteria c = session.createCriteria(StoreIssueT.class).add(
					Restrictions.eq("IssueM.Id", issueId)).add(
					Restrictions.eq("Issued", issued));
			c.setFirstResult(firstResult);
			c.setMaxResults(maxResults);
			issueTList = c.list();

			employeeList = hbt
					.find("from jkt.hms.masters.business.MasEmployee");
			departmentList = hbt
					.find("from jkt.hms.masters.business.MasDepartment");
			storeInternalIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreInternalIndentM");

			searchListForPopup = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIssueM sim where sim.Department.Id='"
							+ deptId
							+ "' and sim.Status='o' and sim.IssueType='i'");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// session.close();
		}
		map.put("searchListForPopup", searchListForPopup);
		map.put("storeInternalIndentMList", storeInternalIndentMList);
		map.put("issueTList", issueTList);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("issueId", issueId);
		return map;
	}

	public Map searchInternalIndentDetails(Map<String, Object> dataMap) {

		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int internalIndentId = 0;
		String issueNo = "";
		int issueId = 0;
		int firstResult = 0;
		int maxResults = 8;

		int approvedBy = 0;
		int requestedBy = 0;
		int issuedBy = 0;

		String refNo = "";
		int despenceryName = 0;
		int storeFyId = 0;
		String date = "";
		String time = "";
		Date demandDate = null;
		List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		StoreIssueM storeIssueM = new StoreIssueM();
		List<StoreIssueM> list = new ArrayList<StoreIssueM>();
		List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int currentMonth = gregorianCalendar.get(Calendar.MONTH) + 1;
		int currentYear = Integer.parseInt(""
				+ gregorianCalendar.get(Calendar.YEAR));
		int month = 0;
		int year = 0;
		java.sql.Date startDate = null;
		java.sql.Date endDate = null;
		String messageTOBeVisibleToTheUser = "";
		String messageType = "failure";
		// Retriving data from map
		if (dataMap.get("internalIndentId") != null) {
			internalIndentId = Integer.parseInt(""
					+ dataMap.get("internalIndentId"));
		}
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("issueNo") != null) {
			issueNo = "" + dataMap.get("issueNo");
		}
		if (dataMap.get("approvedBy") != null) {
			approvedBy = Integer.parseInt("" + dataMap.get("approvedBy"));
		}
		if (dataMap.get("requestedBy") != null) {
			requestedBy = Integer.parseInt("" + dataMap.get("requestedBy"));
		}
		if (dataMap.get("issuedBy") != null) {
			issuedBy = Integer.parseInt("" + dataMap.get("issuedBy"));
		}
		if (dataMap.get("refNo") != null) {
			refNo = "" + dataMap.get("refNo");
		}
		if (dataMap.get("despenceryName") != null) {
			despenceryName = Integer.parseInt(""
					+ dataMap.get("despenceryName"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}
		if (dataMap.get("date") != null) {
			date = ("" + dataMap.get("date"));
		}
		if (dataMap.get("time") != null) {
			time = ("" + dataMap.get("time"));
		}

		session = (Session) getSession();
		Transaction tx = null;

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			// --------------Transaction Started----------

			tx = session.beginTransaction();
			if (currentMonth == 1) {
				month = 12;
				year = currentYear - 1;
				startDate = java.sql.Date
						.valueOf(year + "-" + month + "-" + 01);
				endDate = java.sql.Date.valueOf(year + "-" + month + "-" + 31);

			} else {
				startDate = java.sql.Date.valueOf(currentYear + "-"
						+ (currentMonth - 1) + "-" + 01);
				endDate = java.sql.Date.valueOf(currentYear + "-"
						+ (currentMonth - 1) + "-" + 28);

			}
			//System.out.println("despenceryName  " + despenceryName);
			//System.out.println("deptId  " + deptId);
			//System.out.println("endDate  " + endDate);
			//System.out.println("startDate  " + startDate);
			storeIssueMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIssueM as sim where  sim.IssueDate between '"
									+ startDate
									+ "' and '"
									+ endDate
									+ "' and  sim.IssueType='l'  and sim.Status='o' and sim.Department.Id='"
									+ deptId
									+ "' and sim.ToStore.Id='"
									+ despenceryName + "'");
			//System.out.println("storeIssueMList  " + storeIssueMList.size());
			if (storeIssueMList.size() > 0) {
				messageTOBeVisibleToTheUser = "Please Adjust Loan out of last month.Then only you can issue...!";
				messageType = "failure";
				//System.out.println("messageTOBeVisibleToTheUser  "+ messageTOBeVisibleToTheUser);
				map.put("messageTOBeVisibleToTheUser",
						messageTOBeVisibleToTheUser);
				map.put("messageType", messageType);
				return map;
			}

			storeInternalIndentTList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreInternalIndentT as msb where msb.Internal.Id = '"
									+ internalIndentId + "' ");
			storeInternalIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreInternalIndentM as msb where msb.Id = '"
							+ internalIndentId + "' ");

			for (StoreInternalIndentM storeInternalIndentM : storeInternalIndentMList) {
				demandDate = (Date) storeInternalIndentM.getDemandDate();
			}
			// -----Storing data in Issue Table-----
			storeIssueM.setIssueNo(issueNo);

			StoreInternalIndentM storeInternalIndentM = new StoreInternalIndentM();
			storeInternalIndentM.setId(internalIndentId);
			storeIssueM.setRequestNo(storeInternalIndentM);

			MasEmployee employee = new MasEmployee();
			employee.setId(approvedBy);
			storeIssueM.setApprovedBy(employee);

			MasEmployee employee2 = new MasEmployee();
			employee2.setId(requestedBy);
			storeIssueM.setRequestBy(employee2);

			MasEmployee employee3 = new MasEmployee();
			employee3.setId(issuedBy);
			storeIssueM.setIssuedBy(employee3);

			MasDepartment department1 = new MasDepartment();
			department1.setId(deptId);
			storeIssueM.setDepartment(department1);

			MasDepartment department = new MasDepartment();
			department.setId(despenceryName);
			storeIssueM.setToStore(department);
			storeIssueM.setDocNo(refNo);
			storeIssueM.setStatus("o");
			storeIssueM.setIssueType("i");
			storeIssueM.setIssueDate(new Date(date));
			storeIssueM.setToUnit(null);
			storeIssueM.setToDepot(null);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			storeIssueM.setHospital(hospital);

			storeIssueM.setLastChgDate(new Date(date));
			storeIssueM.setLastChgBy(userName);
			storeIssueM.setLastChgTime(time);

			storeIssueM.setRequestDate(new Date(date));
			hbt.save(storeIssueM);
			hbt.refresh(storeIssueM);

			list = hbt
					.find("from jkt.hms.masters.business.StoreIssueM as sim where sim.IssueNo = '"
							+ issueNo + "'");
			StoreIssueM temp = list.get(0);
			StoreIssueM tempStoreIssueM = new StoreIssueM();
			issueId = temp.getId();
			tempStoreIssueM.setId(issueId);

			for (StoreInternalIndentT storeInternalIndentT : storeInternalIndentTList) {
				StoreIssueT storeIssueT = new StoreIssueT();

				MasStoreItem masStoreItem = new MasStoreItem();
				if (storeInternalIndentT.getItem() != null) {
					masStoreItem.setId(storeInternalIndentT.getItem().getId());
					storeIssueT.setItem(masStoreItem);
					storeIssueT.setItemIssued(masStoreItem);
				}
				BigDecimal bigDecimal = new BigDecimal(storeInternalIndentT
						.getQtyRequest());
				storeIssueT.setQtyRequest(bigDecimal);
				storeIssueT.setIssueM(tempStoreIssueM);
				storeIssueT.setBrand(null);
				storeIssueT.setSrNo(0);
				storeIssueT.setIssued("n");
				storeIssueT.setQtyIssued(new BigDecimal(0));
				// storeIssueT.setItemFromIndent("y");
				hbt.save(storeIssueT);
				hbt.refresh(storeIssueT);
			}

			int StoreFyDocumentNoId = 1;
			// StoreFyDocumentNo
			// storeFyDocumentNo=(StoreFyDocumentNo)getHibernateTemplate().load(StoreFyDocumentNo.class,StoreFyDocumentNoId);
			// storeFyDocumentNo.setIssueCivNo(issueNo);
			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
					.load(StoreFyDocumentNo.class, storeFyId);
			storeFyDocumentNo.setIssueDeptReturnNo(issueNo);
			HibernateTemplate hbt2 = getHibernateTemplate();
			hbt2.setFlushModeName("FLUSH_EAGER");
			hbt2.update(storeFyDocumentNo);
			StoreInternalIndentM internalIndentM = (StoreInternalIndentM) getHibernateTemplate()
					.load(StoreInternalIndentM.class, internalIndentId);
			internalIndentM.setStatus("p");
			hbt2.update(internalIndentM);
			searchListForPopup = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIssueM sim where sim.Department.Id='"
							+ deptId + "' and sim.Status='o'");
			// --------------Transaction End----------
			tx.commit();
		} catch (RuntimeException e) {
			// --------------In case of Transaction Failure----------
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();
		} finally {
			// --------Session Closing----------
			// session.close();

		}

		map.put("issueId", issueId);
		map.put("searchListForPopup", searchListForPopup);
		return map;
	}

	public Map openDeletePopupForIssueciv(Map<String, Object> dataMap) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}
		Map map = new HashMap();
		List<StoreIssueM> deleteStoreIssueList = new ArrayList<StoreIssueM>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		deleteStoreIssueList = hbt
				.find("from jkt.hms.masters.business.StoreIssueM as sim where  sim.IssueType='i'  and sim.Status='o' and sim.Department.Id='"
						+ deptId + "'");
		map.put("deleteStoreIssueList", deleteStoreIssueList);
		return map;
	}

	public Map showDeleteIsuueCiv(Box box) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}

		List<StoreIssueT> deleteStoreIssueList = new ArrayList<StoreIssueT>();
		StoreIssueT storeIssueT = new StoreIssueT();
		Map map = new HashMap();
		HibernateTemplate hbt = getHibernateTemplate();
		session = (Session) getSession();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		hbt.setFlushModeName("FLUSH_EAGER");
		int issueId = 0;
		if (box.get("issueId") != null) {
			issueId = Integer.parseInt("" + box.get("issueId"));
		}
		//System.out.println("issueId   " + issueId);
		String qry = "SELECT i.item_id,item.nomenclature,item2.nomenclature,i.qty_request,i.qty_issued,i.issue_m_id,i.item_from_indent FROM store_issue_t i,mas_store_item item,mas_store_item item2 where  i.issue_m_id='"
				+ issueId
				+ "' and item.item_id=i.item_id  and item2.item_id=i.item_issued and  i.issued='y' group by i.item_id;";
		List objectList = (List) session.createSQLQuery(qry).list();

		int id = 0;
		String nomenclature = null;
		int itemId = 0;
		int detailId = 0;
		String issuedItemName = null;
		BigDecimal requestedQty = null;
		BigDecimal issuedQty = null;
		int issueMId = 0;
		String itemFromIndent = "y";

		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();

			try {
				itemId = (Integer) object[0];
			} catch (Exception e) {
				e.printStackTrace();
				itemId = 0;
			}
			try {
				nomenclature = (String) object[1];
			} catch (Exception e) {
				nomenclature = "";
			}
			try {
				issuedItemName = (String) object[2];
			} catch (Exception e) {
				e.printStackTrace();
				issuedItemName = "";
			}
			try {
				requestedQty = new BigDecimal("" + object[3]);
			} catch (Exception e) {
				requestedQty = new BigDecimal("" + 0);
			}

			try {
				issuedQty = new BigDecimal("" + object[4]);
			} catch (Exception e) {
				e.printStackTrace();
				issuedQty = new BigDecimal("" + 0);
			}

			try {
				issueMId = (Integer) object[5];
			} catch (Exception e) {
				e.printStackTrace();
				issueMId = 0;
			}
			try {
				itemFromIndent = "" + object[5];
			} catch (Exception e) {
				e.printStackTrace();
				itemFromIndent = "y";
			}
			hData = new HashMap<String, Object>();

			hData.put("nomenclature", nomenclature);
			hData.put("issuedItemName", issuedItemName);
			hData.put("requestedQty", requestedQty);
			hData.put("issuedQty", issuedQty);
			hData.put("itemId", itemId);
			hData.put("issueMId", issueMId);

			vResult.add(hData);
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		deleteStoreIssueList = hbt
				.find("from jkt.hms.masters.business.StoreIssueM as sim where  sim.IssueType='i'  and sim.Status='o' and sim.Department.Id='"
						+ deptId + "'");
		map.put("deleteStoreIssueList", deleteStoreIssueList);
		map.put("pagedArray", pagedArray);
		return map;
	}

	public Map deleteIssueCivItems(Box box) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}

		Session session = (Session) getSession();
		List<StoreIssueT> storeTenderTList = new ArrayList<StoreIssueT>();
		StoreIssueT storeIssueT = new StoreIssueT();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIssueT> deleteStoreIssueList = new ArrayList<StoreIssueT>();
		session = (Session) getSession();
		Transaction tx = null;
		//System.out.println("box  before  " + box);
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector id = box.getVector("id");
			Vector nomenclature = box.getVector("nomenclature");
			Vector delete = box.getVector("items_to_be_deleted");
			Vector issueMId = box.getVector("issueMId");
			Vector qtyInReq = box.getVector("requestedQty");
			Vector issuedQty = box.getVector("issuedQty");
			Vector itemFromIndentList = box.getVector("itemFromIndent");
			String obj = null;
			int tempBrandId = 0;
			//System.out.println("delete.size()  " + delete.size());

			for (int i = 0; i < delete.size(); i++) {
				StoreIssueT storeIssueT2 = new StoreIssueT();
				int item_id = Integer.parseInt(delete.get(i).toString());
				int issueTId = Integer.parseInt(issueMId.get(i).toString());
				BigDecimal qtyReq = new BigDecimal(qtyInReq.get(i).toString());
				String itemFromIndent = (itemFromIndentList.get(i).toString());
				List<StoreIssueT> tempList = new ArrayList<StoreIssueT>();

				tempList = hbt
						.find("from jkt.hms.masters.business.StoreIssueT as a where a.IssueM.Id='"
								+ issueTId
								+ "' and a.Item.Id=  '"
								+ item_id
								+ "'  ");
				for (StoreIssueT storeIssueT3 : tempList) {
					if (storeIssueT3.getBrand() != null) {
						tempBrandId = Integer.parseInt(""
								+ storeIssueT3.getBrand().getId());
						BigDecimal bigDecimal = new BigDecimal(""
								+ issuedQty.get(i));
						String qry = "update store_item_batch_stock as s set s.closing_stock =(s.closing_stock+'"
								+ bigDecimal
								+ "') where brand_id='"
								+ tempBrandId + "' ";
						Query query2 = session.createSQLQuery(qry);
						int row2 = query2.executeUpdate();
					}
				}

				String hql = "delete from jkt.hms.masters.business.StoreIssueT as a where a.IssueM.Id='"
						+ issueTId + "' and a.Item.Id=  '" + item_id + "' ";
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
			}

			deleteStoreIssueList = hbt
					.find("from jkt.hms.masters.business.StoreIssueM as sim where  sim.IssueType='i'  and sim.Status='o' and sim.Department.Id='"
							+ deptId + "'");
			map.put("deleteStoreIssueList", deleteStoreIssueList);
			map.put("total_records", id.size());
			map.put("deleted_records", delete.size());
			// --------------Transaction Ended----------
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();
		}

		if (Integer.parseInt(map.get("total_records").toString()) == Integer
				.parseInt(map.get("deleted_records").toString())) {
			//System.out.println("total and deleted equal");
			if (box.getInt("currPage") > 1)
				box.put("currPage", box.getInt("currPage") - 1);
		}
		//System.out.println("===  box  ========  " + box);
		map = showDeleteIsuueCiv(box);
		return map;
	}

	public Map searchIssueCiv(Box box) {
		int issueId = 0;
		int deptId = 0;
		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();
		Map<String, Object> pageMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		StoreIssueM issueM = new StoreIssueM();
		List<StoreIssueM> list = new ArrayList<StoreIssueM>();
		deptId = Integer.parseInt("" + box.get("deptId"));
		session = (Session) getSession();
		Transaction tx = null;
		int pageNo = 1;
		String issued = "n";
		if (box.get("issueUnit") != null) {
			issueId = Integer.parseInt(box.get("issueUnit"));
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		list = hbt
				.find("from jkt.hms.masters.business.StoreIssueM as sim where sim.Id = '"
						+ issueId + "'");
		String date11 = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		date11 = (String) utilMap.get("currentDate");
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();

			for (StoreIssueM storeIssueM : list) {
				box.put("issueNo", storeIssueM.getIssueNo());
				try {
					SimpleDateFormat formatterIn = new SimpleDateFormat(
							"yyyy-MM-dd");
					SimpleDateFormat formatterOut = new SimpleDateFormat(
							"dd/MM/yyyy");
					String date4MySQL = formatterOut.format(storeIssueM
							.getIssueDate());
					Date date = java.sql.Date.valueOf(date4MySQL);
					box.put("issueDate", date);
				} catch (Exception e) {
					box.put("issueDate", date11);
				}

				box.put("departmentIdTemp", storeIssueM.getRequestNo().getId());
				box.put("reference", storeIssueM.getDocNo());
				try {
					SimpleDateFormat formatterIn2 = new SimpleDateFormat(
							"yyyy-MM-dd");
					SimpleDateFormat formatterOut2 = new SimpleDateFormat(
							"dd/MM/yyyy");
					String date4MySQL2 = formatterOut2.format(""
							+ storeIssueM.getRequestDate());
					Date date2 = java.sql.Date.valueOf(date4MySQL2);
					box.put("requestDate", date2);
				} catch (Exception e) {
					box.put("requestDate", date11);
				}

				box.put("requestBy", storeIssueM.getRequestBy().getId());
				box.put("approvedBy", storeIssueM.getApprovedBy().getId());
				box.put("issuedBy", storeIssueM.getIssuedBy().getId());
				box.put("requestNo", storeIssueM.getRequestNo().getId());
				// --------------Transaction Ended----------
				tx.commit();

			}
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();

		}
		pageMap.put("issueId", issueId);
		pageMap.put("pageNo", pageNo);
		pageMap.put("deptId", deptId);
		map = getIssueDetailPageByPage(pageMap);
		map.put("box", box);

		return map;
	}

	public List<MasStoreItem> getItemList() {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		itemList = (List<MasStoreItem>) hbt
				.find("from jkt.hms.masters.business.MasStoreItem as mis where mis.Status='y'  and mis.Id<100");
		return itemList;
	}

	public Map<String, Object> getDemandList(Map dataMap) {
		int dispenceryId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		try {
			if (dataMap.get("deptId") != null)
				deptId = Integer.parseInt("" + dataMap.get("deptId"));
			if (dataMap.get("hospitalId") != null)
				hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
			if (dataMap.get("userName") != null)
				userName = ("" + dataMap.get("userName"));
			if (dataMap.get("dispenceryId") != null) {
				dispenceryId = Integer.parseInt(""
						+ dataMap.get("dispenceryId"));
			}
			storeInternalIndentMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreInternalIndentM as siim  where siim.Department.Id='"
									+ dispenceryId
									+ "' and siim.Status='o' and siim.ToStore='"
									+ deptId + "'");
			map.put("storeInternalIndentMList", storeInternalIndentMList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> adjustLoanOut(Map<String, Object> dataMap) {
		session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dateMap = new HashMap<String, Object>();
		List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<StoreIssueM> storeIssueMLoanOutList = new ArrayList<StoreIssueM>();
		List<StoreIssueT> storeIssueTLoanOutList = new ArrayList<StoreIssueT>();
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int currentMonth = gregorianCalendar.get(Calendar.MONTH) + 1;
		int currentYear = Integer.parseInt(""
				+ gregorianCalendar.get(Calendar.YEAR));
		int month = 0;
		int year = 0;
		java.sql.Date startDate = null;
		java.sql.Date endDate = null;
		int issueMId = 0;
		int toStoreId = 0;
		int tempIssueMId = 0;
		int deptId = 0;
		int hospitalId = 0;
		String no = "";
		String max = "";
		String successfullyAdded = "n";
		String monthAndYear = "";
		String messageTOBeVisibleToTheUser = "";
		if (dataMap.get("issueMId") != null) {
			issueMId = Integer.parseInt("" + dataMap.get("issueMId"));
		}
		if (dataMap.get("toStoreId") != null) {
			toStoreId = Integer.parseInt("" + dataMap.get("toStoreId"));
		}
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}

		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("toStoreId") != null) {
			toStoreId = Integer.parseInt("" + dataMap.get("toStoreId"));
		}
		if (currentMonth == 1) {
			currentMonth = 12;
			currentYear = currentYear - 1;
			monthAndYear = (currentYear + "-" + currentMonth);

		} else {
			if (currentMonth <= 10) {
				monthAndYear = (currentYear + "-0" + (currentMonth - 1));
			} else {
				monthAndYear = (currentYear + "-" + (currentMonth - 1));
			}
		}

		String date = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");

		Transaction tx = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();
			storeIssueMList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIssueM as sim where substring(sim.IssueDate, 1,7) = '"
									+ monthAndYear
									+ "' and   sim.IssueType='l'  and sim.Status='o' and sim.Department.Id='"
									+ deptId
									+ "' and sim.ToStore.Id='"
									+ toStoreId + "'");
			//System.out.println("storeIssueMList   " + storeIssueMList.size());
			storeFyDocumentNoList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "' ");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getIssueDeptNo() != null) {
					no = ("" + storeFyDocumentNo.getIssueDeptNo());
				} else {
					no = "";
				}
			}
			max = getMaxNo(no);
			StoreIssueM storeIssueMTemp = new StoreIssueM();
			storeIssueMTemp.setIssueNo(max);
			storeIssueMTemp.setIssueType("i");
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse(date));
			java.sql.Date issueDate = java.sql.Date.valueOf(date4MySQL);
			storeIssueMTemp.setIssueDate(issueDate);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			storeIssueMTemp.setDepartment(masDepartment);
			MasDepartment masDepartment1 = new MasDepartment();
			masDepartment1.setId(toStoreId);
			storeIssueMTemp.setToStore(masDepartment1);
			storeIssueMTemp.setStatus("o");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			storeIssueMTemp.setHospital(masHospital);

			hbt.save(storeIssueMTemp);

			for (StoreIssueM storeIssueM : storeIssueMList) {
				tempIssueMId = storeIssueM.getId();
				if (tempIssueMId != 0) {
					storeIssueTList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.StoreIssueT as sit where sit.IssueM.Id='"
									+ tempIssueMId + "'");
					//System.out.println("storeIssueTList  "+ storeIssueTList.size());
					for (StoreIssueT storeIssueT : storeIssueTList) {

						StoreIssueT storeIssueTTemp = new StoreIssueT();

						MasStoreItem item = new MasStoreItem();
						item.setId(storeIssueT.getItem().getId());
						storeIssueTTemp.setItem(item);

						storeIssueTTemp.setQtyRequest(storeIssueT
								.getQtyRequest());
						storeIssueTTemp.setItemIssued(item);
						storeIssueTTemp.setBatchNo(storeIssueT.getBatchNo());
						storeIssueTTemp
								.setQtyIssued(storeIssueT.getQtyIssued());
						storeIssueTTemp.setRemarks(storeIssueT.getRemarks());
						storeIssueTTemp.setExpiryDate(storeIssueT
								.getExpiryDate());

						storeIssueTTemp.setIssueM(storeIssueMTemp);

						MasStoreBrand brand = new MasStoreBrand();
						brand.setId(storeIssueT.getBrand().getId());
						storeIssueTTemp.setBrand(brand);

						storeIssueTTemp.setSrNo(storeIssueT.getSrNo());
						storeIssueTTemp.setIssued("y");
						// storeIssueTTemp.setItemFromIndent("y");
						hbt.save(storeIssueTTemp);
					}
					for (StoreIssueT storeIssueT : storeIssueTList) {
						StoreIssueM storeIssueM3 = (StoreIssueM) getHibernateTemplate()
								.load(StoreIssueM.class,
										storeIssueT.getIssueM().getId());
						storeIssueM3.setStatus("p");
						hbt.update(storeIssueM3);
					}

				} else {
					if (tx != null)
						tx.rollback();
					successfullyAdded = "n";
					//System.out.println("Current month  Issue is not Created  ");
					messageTOBeVisibleToTheUser = "Current month  Issue is not Created  ";
				}
			}
			// --------------Transaction Ended----------
			tx.commit();
			successfullyAdded = "y";
		} catch (Exception e) {
			// --------------In case of Transaction Failure----------
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();
		} finally {
			// --------Session Closing----------
			session.close();
		}
		map.put("successfullyAdded", successfullyAdded);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return map;
	}

	public Map<String, Object> getItemListForIssueToDispensary(
			Map<String, Object> dataMap) {
		//System.out.println("getItemListForIssueToDispensary i n ds");

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int deptId = 0;
		int issueId = 0;

		try {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
			issueId = Integer.parseInt("" + dataMap.get("issueId"));
			List objectList = new ArrayList();
			String str = dataMap.get("autoHint") + "%";
			String qry = " SELECT item_id FROM store_issue_t where issue_m_id='"
					+ issueId + "';";
			objectList = (List) session.createSQLQuery(qry).list();
			if (objectList.size() > 0) {

				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.not(Restrictions.in("Id", objectList)));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			} else {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId));

				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("itemList                                          "+ itemList.size());
		map.put("itemList", itemList);
		return map;

	}

	// ----------------------------End Of Issues To Dispensary (CIV)
	// ----------------------

	// ----------------------------Start Of Issues To Dispensary Loan Out
	// ----------------------

	public Map<String, Object> getItemListForLoanoutByAutocomplete(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String au = null;
		BigDecimal qtymmf = null;
		BigDecimal annreq = null;
		int item_id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = dataMap.get("autoHint") + "%";
			Integer[] ob = { 1750, 1063 };
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("Nomenclature", str)).add(
					Restrictions.not(Restrictions.in("Id", ob)));
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	public Map addBrandDetailsForLoanOut(Box box)
			throws java.text.ParseException {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		if (box.get("userName") != null) {
			userName = ("" + box.get("userName"));
		}
		Map map = new HashMap();
		int itemId = 0;
		int detailId = 0;
		int itemIssuedIdArray[] = null;
		String qtyIssuedTempArray[] = null;
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		String successfullyAdded = "n";
		int issueId = 0;
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		int storeFyId = 0;
		session = (Session) getSession();
		Transaction tx = null;

		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();

			Vector brandId = box.getVector(BRAND_ID);
			Vector qtyIssued = box.getVector(QTY_ISSUED);
			Vector remarks = box.getVector(RequestConstants.REMARKS);
			Vector batchNo = box.getVector(RequestConstants.BATCH_NO);
			Vector expDate = box.getVector(RequestConstants.EXPIRY_DATE);

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			String issueNo = "" + box.get("issueNo");
			issueId = Integer.parseInt("" + box.get("issueId"));
			int departmentIdTemp = Integer.parseInt(""
					+ box.get("departmentIdTemp"));
			StoreIssueM storeIssueM = new StoreIssueM();
			System.out
					.println("issueId                                                                  "
							+ issueId);
			if (issueId == 0) {
				storeIssueM.setIssueType("l");
				storeIssueM.setIssueNo(box.get("issueNo"));
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String dd = "" + box.get("issueDate");
				String date4MySQL = formatterOut.format(formatterIn.parse(dd));
				java.sql.Date issueDate = java.sql.Date.valueOf(date4MySQL);
				storeIssueM.setIssueDate(issueDate);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIssueM.setDepartment(masDepartment);
				MasDepartment masDepartment2 = new MasDepartment();
				masDepartment2.setId(Integer.parseInt(""
						+ box.get("departmentIdTemp")));
				storeIssueM.setToStore(masDepartment2);
				storeIssueM.setRequestNo(null);
				storeIssueM.setRequestDate(null);

				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(Integer.parseInt("" + box.get("requestBy")));
				storeIssueM.setRequestBy(masEmployee);

				MasEmployee masEmployee2 = new MasEmployee();
				masEmployee2.setId(Integer.parseInt("" + box.get("issuedBy")));
				storeIssueM.setIssuedBy(masEmployee2);

				MasEmployee masEmployee3 = new MasEmployee();
				masEmployee3
						.setId(Integer.parseInt("" + box.get("approvedBy")));
				storeIssueM.setApprovedBy(masEmployee3);
				storeIssueM.setStatus("o");
				storeIssueM.setDocNo(box.get("docNo"));
				storeIssueM.setToUnit(null);
				storeIssueM.setToDepot(null);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(Integer.parseInt("" + box.get("hospitalId")));
				storeIssueM.setHospital(masHospital);
				storeIssueM.setLastChgBy(box.get("changed_by"));
				storeIssueM.setLastChgDate(issueDate);
				storeIssueM.setLastChgTime(box.get("changed_time"));
				Patient hin = new Patient();
				hin.setId(Integer.parseInt("" + box.get("patientName")));
				storeIssueM.setHin(hin);

				hbt.save(storeIssueM);
				hbt.refresh(storeIssueM);
			} else {
				storeIssueM.setId(issueId);
			}
			for (int i = 0; i < brandId.size(); i++) {
				if (Integer.parseInt("" + qtyIssued.get(i)) != 0) {
					StoreIssueT storeIssueT = new StoreIssueT();

					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem
							.setId(Integer.parseInt("" + box.get("itemId")));
					storeIssueT.setItem(masStoreItem);
					storeIssueT.setQtyRequest(new BigDecimal(0));
					storeIssueT.setItem(masStoreItem);
					storeIssueT.setBatchNo("" + batchNo.get(i));
					storeIssueT.setQtyIssued(new BigDecimal(""
							+ qtyIssued.get(i)));
					storeIssueT.setRemarks(box.get("remarks"));
					// storeIssueT.setItemFromIndent("y");
					//System.out.println("expDate.get(i)  " + expDate.get(i));
					try {
						storeIssueT
								.setExpiryDate(new Date("" + expDate.get(i)));
					} catch (Exception e) {
						storeIssueT.setExpiryDate(null);
					}

					MasStoreBrand brand = new MasStoreBrand();
					brand.setId(Integer.parseInt("" + brandId.get(i)));
					storeIssueT.setBrand(brand);
					if (("" + remarks.get(i)).equals("emptyString")) {
						storeIssueT.setRemarks(null);
					} else {
						storeIssueT.setRemarks("" + remarks.get(i));
					}

					storeIssueT.setIssueM(storeIssueM);
					storeIssueT.setSrNo(0);
					storeIssueT.setIssued("y");
					storeIssueT.setItemIssued(masStoreItem);
					hbt.save(storeIssueT);
					hbt.refresh(storeIssueT);

					String qry = "select closing_stock from store_item_batch_stock where brand_id="
							+ brandId.get(i);
					List c = (List) session.createSQLQuery(qry).list();
					BigDecimal stock = (BigDecimal) c.get(0);
					String hql2 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.ClosingStock='"
							+ stock.subtract(new BigDecimal(""
									+ qtyIssued.get(i)))
							+ "' where a.Brand.Id='"
							+ brandId.get(i)
							+ "' where a.Department.Id=1";
					Query query2 = session.createQuery(hql2);
					int row2 = query2.executeUpdate();
				}
			}
			String qry = "select id from store_issue_m where issue_no='"
					+ issueNo + "' and issue_type='l' and department_id='"
					+ deptId + "' and to_store='" + departmentIdTemp + "';";
			List objectList = (List) session.createSQLQuery(qry).list();
			issueId = Integer.parseInt("" + objectList.get(0));

			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
					.load(StoreFyDocumentNo.class, storeFyId);
			storeFyDocumentNo.setIssueLoanoutNo(issueNo);
			hbt.update(storeFyDocumentNo);
			// --------------Transaction End----------
			tx.commit();
			successfullyAdded = "y";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			e.printStackTrace();
		} finally {
			// session.close();
		}

		map.put("successfullyAdded", successfullyAdded);
		map.put("issueId", issueId);
		return map;
	}

	public Map<String, Object> openDeletePopupForIssueLoanOut(Map dataMap) {
		Map map = new HashMap();
		int deptId = 0;
		List<StoreIssueM> deleteStoreIssueList = new ArrayList<StoreIssueM>();
		HibernateTemplate hbt = getHibernateTemplate();
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		hbt.setFlushModeName("FLUSH_EAGER");
		deleteStoreIssueList = hbt
				.find("from jkt.hms.masters.business.StoreIssueM as sim where sim.IssueType='i'  and sim.Status='o' and sim.Department.Id='"
						+ deptId + "'");
		//System.out.println("deleteStoreIssueList  "+ deleteStoreIssueList.size());
		map.put("deleteStoreIssueList", deleteStoreIssueList);
		return map;
	}

	public Map showDeleteIsuueLoanout(Box box) {

		List<StoreIssueT> deleteStoreIssueList = new ArrayList<StoreIssueT>();
		StoreIssueT storeIssueT = new StoreIssueT();
		Map map = new HashMap();
		HibernateTemplate hbt = getHibernateTemplate();
		session = (Session) getSession();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		int departmentIdTemp = 0;
		int deptId = 0;
		deptId = Integer.parseInt("" + box.get("deptId"));
		departmentIdTemp = Integer.parseInt("" + box.get("issueId"));

		hbt.setFlushModeName("FLUSH_EAGER");
		int issueId = 0;
		if (box.get("issueId") != null) {
			issueId = Integer.parseInt("" + box.get("issueId"));
		}
		//System.out.println("issueId   " + issueId);
		String qry = "SELECT i.item_id,item.nomenclature,item2.nomenclature,i.qty_request,i.qty_issued,i.issue_m_id FROM store_issue_t i,mas_store_item item,mas_store_item item2 where  i.issue_m_id='"
				+ issueId
				+ "' and item.item_id=i.item_id  and item2.item_id=i.item_issued and  i.issued='y' group by i.item_id;";
		List objectList = (List) session.createSQLQuery(qry).list();

		int id = 0;
		String nomenclature = null;
		int itemId = 0;
		int detailId = 0;
		String issuedItemName = null;
		BigDecimal requestedQty = null;
		BigDecimal issuedQty = null;
		int issueMId = 0;

		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();

			try {
				itemId = (Integer) object[0];
			} catch (Exception e) {
				e.printStackTrace();
				itemId = 0;
			}
			try {
				nomenclature = (String) object[1];
			} catch (Exception e) {
				nomenclature = "";
			}
			try {
				issuedItemName = (String) object[2];
			} catch (Exception e) {
				e.printStackTrace();
				issuedItemName = "";
			}
			try {
				requestedQty = new BigDecimal("" + object[3]);
			} catch (Exception e) {
				requestedQty = new BigDecimal("" + 0);
			}

			try {
				issuedQty = new BigDecimal("" + object[4]);
			} catch (Exception e) {
				e.printStackTrace();
				issuedQty = new BigDecimal("" + 0);
			}

			try {
				issueMId = (Integer) object[5];
			} catch (Exception e) {
				e.printStackTrace();
				issueMId = 0;
			}
			hData = new HashMap<String, Object>();

			hData.put("nomenclature", nomenclature);
			hData.put("issuedItemName", issuedItemName);
			hData.put("requestedQty", requestedQty);
			hData.put("issuedQty", issuedQty);
			hData.put("itemId", itemId);
			hData.put("issueMId", issueMId);

			vResult.add(hData);
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		deleteStoreIssueList = hbt
				.find("from jkt.hms.masters.business.StoreIssueM as sim where sim.IssueType='i'  and sim.Status='o' and sim.Department.Id='"
						+ deptId + "'");
		map.put("deleteStoreIssueList", deleteStoreIssueList);
		map.put("pagedArray", pagedArray);
		return map;

	}

	public Map deleteIssueLoanoutItems(Box box) {

		List<StoreIssueT> storeTenderTList = new ArrayList<StoreIssueT>();
		StoreIssueT storeIssueT = new StoreIssueT();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIssueT> deleteStoreIssueList = new ArrayList<StoreIssueT>();
		session = (Session) getSession();
		int deptId = 0;
		deptId = Integer.parseInt("" + box.get("deptId"));
		Transaction tx = null;
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector id = box.getVector("id");
			Vector nomenclature = box.getVector("nomenclature");
			Vector delete = box.getVector("items_to_be_deleted");
			Vector issueMId = box.getVector("issueMId");
			Vector qtyInReq = box.getVector("requestedQty");
			Vector issuedQty = box.getVector("issuedQty");

			String obj = null;
			int tempBrandId = 0;
			//System.out.println("delete.size()  " + delete.size());

			for (int i = 0; i < delete.size(); i++) {
				StoreIssueT storeIssueT2 = new StoreIssueT();
				int item_id = Integer.parseInt(delete.get(i).toString());
				int issueId = Integer.parseInt(issueMId.get(i).toString());
				BigDecimal qtyReq = new BigDecimal(qtyInReq.get(i).toString());
				List<StoreIssueT> tempList = new ArrayList<StoreIssueT>();

				tempList = hbt
						.find("from jkt.hms.masters.business.StoreIssueT as a where a.IssueM.Id='"
								+ issueId
								+ "' and a.Item.Id=  '"
								+ item_id
								+ "'  ");
				for (StoreIssueT storeIssueT3 : tempList) {
					if (storeIssueT3.getItem() != null) {
						tempBrandId = Integer.parseInt(""
								+ storeIssueT3.getItem().getId());
						BigDecimal bigDecimal = new BigDecimal(""
								+ issuedQty.get(i));
						String qry = "update store_item_batch_stock as s set s.closing_stock =(s.closing_stock+'"
								+ bigDecimal
								+ "') where item_id='"
								+ item_id
								+ "' ";
						Query query2 = session.createSQLQuery(qry);
						int row2 = query2.executeUpdate();
					}
				}

				String hql = "delete from jkt.hms.masters.business.StoreIssueT as a where a.IssueM.Id='"
						+ issueId + "' and a.Item.Id=  '" + item_id + "' ";
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
			}

			deleteStoreIssueList = hbt
					.find("from jkt.hms.masters.business.StoreIssueM as sim where sim.IssueType='i'  and sim.Status='o' and sim.Department.Id='"
							+ deptId + "'");
			map.put("deleteStoreIssueList", deleteStoreIssueList);
			map.put("total_records", id.size());
			map.put("deleted_records", delete.size());
			// --------------Transaction Ended----------
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();

		}

		if (Integer.parseInt(map.get("total_records").toString()) == Integer
				.parseInt(map.get("deleted_records").toString())) {
			//System.out.println("total and deleted equal");
			if (box.getInt("currPage") > 1)
				box.put("currPage", box.getInt("currPage") - 1);
		}

		map = showDeleteIsuueCiv(box);
		return map;

	}

	public Map<String, Object> searchInternalIndentDetails(int internalIndentId) {
		return null;
	}

	public Map showIssueDispensaryManualJsp(Map<String, Object> dataMap) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}

		Map map = new HashMap();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasStoreBrand> masStoreBrandList = new ArrayList<MasStoreBrand>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();
		String max = "";
		String startNo = "";
		String no = "";
		try {
			patientList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.Patient as pt where pt.Status='y'");
			storeInternalIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreInternalIndentM");
			departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment");
			masStoreAirForceDepotList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreAirForceDepot");
			itemList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreItem as it where it.Id<100 ");
			employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee");
			storeFyDocumentNoList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "' ");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getIssueLoanoutNo() != null) {
					no = ("" + storeFyDocumentNo.getIssueLoanoutNo());
				} else {
					no = "";
				}
			}
			// searchListForPopup=getHibernateTemplate().find("from jkt.hms.masters.business.StoreIssueM as sim where sim.RequestType='m' and sim.IssueType and sim.DocType='l' and sim.Status='o'");
			searchListForPopup = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIssueM sim where sim.Department.Id='"
							+ deptId
							+ "' and sim.Status='o' and sim.IssueType='l'");

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			max = getMaxNo(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("storeInternalIndentMList", storeInternalIndentMList);
		map.put("storeInternalIndentTList", storeInternalIndentTList);
		map.put("departmentList", departmentList);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("itemList", itemList);
		map.put("employeeList", employeeList);
		map.put("max", max);
		map.put("masStoreBrandList", masStoreBrandList);
		map.put("searchListForPopup", searchListForPopup);
		map.put("patientList", patientList);
		return map;

	}

	public Map searchIssueLoanout(Box box) {
		Map map = new HashMap();
		int issueId = 0;
		String max = "";
		List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		List objectList = new ArrayList();
		session=(Session)getSession();
		try {
			issueId = Integer.parseInt("" + box.get("issueUnit"));
			storeIssueMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIssueM as ss where ss.Id='"
							+ issueId + "'");
			
			storeIssueTList=session.createCriteria(StoreIssueT.class)
			.add(Restrictions.eq("IssueM.Id",issueId)).list();
			
			String qry = "select msi.item_id,msi.nomenclature,msi.pvms_no,msic.item_unit_name,sibs.closing_stock,sibs.batch_no,sit.qty_issued,sit.id from store_issue_t sit"+
			" left outer join mas_store_item msi on sit.item_id=msi.item_id"+
			" left outer join mas_store_item_conversion msic on msi.item_conversion_id=msic.item_conversion_id"+
			" left outer join store_item_batch_stock sibs on sibs.item_id=sit.item_id"+
			" left outer join store_issue_m sim on sim.id=sit.issue_m_id where sim.id="
				+ issueId ;
			objectList = (List) session.createSQLQuery(qry).list();
			
			map.put("storeIssueMList", storeIssueMList);
			map.put("objectList", objectList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasStoreBrand> masStoreBrandList = new ArrayList<MasStoreBrand>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();

		try {
			patientList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.Patient as pt where pt.Status='y'");
			storeInternalIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreInternalIndentM");
			departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment");
			masStoreAirForceDepotList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreAirForceDepot");
			itemList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreItem as it where it.Id<100 ");
			employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee");
			storeFyDocumentNoList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreFyDocumentNo ");

			// searchListForPopup=getHibernateTemplate().find("from jkt.hms.masters.business.StoreIssueM as sim where sim.RequestType='m' and sim.IssueType and sim.DocType='l' and sim.Status='o'");
			searchListForPopup = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIssueM ");
			//System.out.println("storeInternalIndentMList                     "+ storeInternalIndentMList.size());
			//System.out.println("storeInternalIndentTList  "+ storeInternalIndentTList.size());
			//System.out.println("departmentList  " + departmentList.size());
			//System.out.println("masStoreAirForceDepotList "+ masStoreAirForceDepotList.size());
			//System.out.println("searchListForPopup "+ searchListForPopup.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("storeInternalIndentMList", storeInternalIndentMList);
		map.put("storeInternalIndentTList", storeInternalIndentTList);
		map.put("departmentList", departmentList);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("itemList", itemList);
		map.put("employeeList", employeeList);
		map.put("max", max);
		map.put("masStoreBrandList", masStoreBrandList);
		map.put("searchListForPopup", searchListForPopup);
		map.put("patientList", patientList);

		return map;
	}

	public Map<String, Object> fillItemsForIssueToDispensary(
			Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreItemBatchStock> batchNoList = new ArrayList<StoreItemBatchStock>();
		String pvmsNo = null;
		pvmsNo = "" + dataMap.get("pvmsNo");
		int itemId = 0;
		List objectList = new ArrayList();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "" + dataMap.get("nomenclature");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", pvmsNo));
			itemList = c.list();
			for (MasStoreItem storeItem : itemList) {
				itemId = storeItem.getId();
				//System.out.println("itemId  " + itemId);
			}
			String qry = "SELECT closing_stock,batch_no FROM store_item_batch_stock where item_id='"
					+ itemId + "'";
			
			Criteria crit = session.createCriteria(StoreItemBatchStock.class).add(
					Restrictions.eq("Item.Id", itemId));
			batchNoList = crit.list();
			
			objectList = (List) session.createSQLQuery(qry).list();
			map.put("objectList", objectList);
			map.put("itemList", itemList);
			map.put("batchNoList", batchNoList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	// ----------------------------End Of Issues To Dispensary Loan Out
	// ----------------------

	// --------------------------------Start Of Issues To Other Units on Surplus
	// (CIV) ---------------------------------

	public Map addBrandDetailsToOtherUnits(Box box)
			throws java.text.ParseException {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}

		Map map = new HashMap();
		int itemId = 0;
		int detailId = 0;
		int itemIssuedIdArray[] = null;
		String qtyIssuedTempArray[] = null;
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		String successfullyAdded = "n";
		int issueId = 0;
		session = (Session) getSession();
		Transaction tx = null;
		//System.out.println("addBrandDetailsToOtherUnits in DS ");
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();

			Vector brandId = box.getVector(BRAND_ID);
			Vector qtyIssued = box.getVector(QTY_ISSUED);
			Vector remarks = box.getVector(RequestConstants.REMARKS);
			Vector batchNo = box.getVector(RequestConstants.BATCH_NO);
			Vector expDate = box.getVector(RequestConstants.EXPIRY_DATE);

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			String issueNo = "" + box.get("issueNo");
			issueId = Integer.parseInt("" + box.get("issueId"));
			int departmentIdTemp = Integer.parseInt(""
					+ box.get("departmentIdTemp"));
			StoreIssueM storeIssueM = new StoreIssueM();
			System.out
					.println("issueId                                                                  "
							+ issueId);
			if (issueId == 0) {
				storeIssueM.setIssueType("o");
				storeIssueM.setIssueNo(box.get("issueNo"));
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String dd = "" + box.get("issueDate");
				String date4MySQL = formatterOut.format(formatterIn.parse(dd));
				java.sql.Date issueDate = java.sql.Date.valueOf(date4MySQL);
				storeIssueM.setIssueDate(issueDate);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIssueM.setDepartment(masDepartment);
				MasStoreAirForceDepot masStoreAirForceDepot = new MasStoreAirForceDepot();
				//System.out.println("departmentIdTemp  before "+ departmentIdTemp);
				masStoreAirForceDepot.setId(departmentIdTemp);
				storeIssueM.setToUnit(masStoreAirForceDepot);
				storeIssueM.setRequestNo(null);
				storeIssueM.setRequestDate(null);

				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(Integer.parseInt("" + box.get("requestBy")));
				storeIssueM.setRequestBy(masEmployee);

				MasEmployee masEmployee2 = new MasEmployee();
				masEmployee2.setId(Integer.parseInt("" + box.get("issuedBy")));
				storeIssueM.setIssuedBy(masEmployee2);

				MasEmployee masEmployee3 = new MasEmployee();
				masEmployee3
						.setId(Integer.parseInt("" + box.get("approvedBy")));
				storeIssueM.setApprovedBy(masEmployee3);
				storeIssueM.setStatus("o");
				storeIssueM.setDocNo(box.get("docNo"));
				storeIssueM.setToDepot(null);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(Integer.parseInt("" + box.get("hospitalId")));
				storeIssueM.setHospital(masHospital);
				storeIssueM.setLastChgBy(box.get("changed_by"));
				storeIssueM.setLastChgDate(issueDate);
				storeIssueM.setLastChgTime(box.get("changed_time"));

				hbt.save(storeIssueM);
				hbt.refresh(storeIssueM);
			} else {
				storeIssueM.setId(issueId);
			}
			for (int i = 0; i < brandId.size(); i++) {
				if (Integer.parseInt("" + qtyIssued.get(i)) != 0) {
					StoreIssueT storeIssueT = new StoreIssueT();

					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem
							.setId(Integer.parseInt("" + box.get("itemId")));
					storeIssueT.setItem(masStoreItem);
					storeIssueT.setQtyRequest(new BigDecimal(0));
					storeIssueT.setItem(masStoreItem);
					storeIssueT.setBatchNo("" + batchNo.get(i));
					storeIssueT.setQtyIssued(new BigDecimal(""
							+ qtyIssued.get(i)));
					storeIssueT.setRemarks(box.get("remarks"));
					//System.out.println("expDate.get(i)  " + expDate.get(i));
					try {
						storeIssueT
								.setExpiryDate(new Date("" + expDate.get(i)));
					} catch (Exception e) {
						storeIssueT.setExpiryDate(null);
					}

					MasStoreBrand brand = new MasStoreBrand();
					brand.setId(Integer.parseInt("" + brandId.get(i)));
					storeIssueT.setBrand(brand);
					if (("" + remarks.get(i)).equals("emptyString")) {
						storeIssueT.setRemarks(null);
					} else {
						storeIssueT.setRemarks("" + remarks.get(i));
					}

					storeIssueT.setIssueM(storeIssueM);
					storeIssueT.setSrNo(0);
					storeIssueT.setIssued("y");
					storeIssueT.setItemIssued(masStoreItem);
					hbt.save(storeIssueT);
					hbt.refresh(storeIssueT);

					String qry = "select closing_stock from store_item_batch_stock where brand_id="
							+ brandId.get(i);
					List c = (List) session.createSQLQuery(qry).list();
					BigDecimal stock = (BigDecimal) c.get(0);
					String hql2 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.ClosingStock='"
							+ stock.subtract(new BigDecimal(""
									+ qtyIssued.get(i)))
							+ "' where a.Brand.Id='"
							+ brandId.get(i)
							+ "' where a.Department.Id=1";
					Query query2 = session.createQuery(hql2);
					int row2 = query2.executeUpdate();
				}
			}
			//System.out.println("issueNo  ssssssssssss" + issueNo);
			//System.out.println("departmentIdTemp  ssssss" + departmentIdTemp);
			String qry = "select id from store_issue_m where issue_no='"
					+ issueNo + "' and issue_type='o' and department_id='"
					+ deptId + "' and to_unit='" + departmentIdTemp + "';";
			List objectList = (List) session.createSQLQuery(qry).list();
			//System.out.println("objectList  " + objectList.size());
			issueId = Integer.parseInt("" + objectList.get(0));

			List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
			int storeFyId = 0;
			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}

			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
					.load(StoreFyDocumentNo.class, storeFyId);
			storeFyDocumentNo.setIssueOtherUnitsNo(issueNo);
			hbt.update(storeFyDocumentNo);

			// --------------Transaction End----------
			tx.commit();
			successfullyAdded = "y";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			e.printStackTrace();
		} finally {
			// session.close();
		}

		map.put("successfullyAdded", successfullyAdded);
		map.put("issueId", issueId);
		return map;
	}

	public Map<String, Object> openDeletePopupForIssueToOtherUnits(Map dataMap) {
		Map map = new HashMap();
		int departmentIdTemp = 0;
		List<StoreIssueM> deleteStoreIssueList = new ArrayList<StoreIssueM>();
		HibernateTemplate hbt = getHibernateTemplate();
		if (dataMap.get("departmentIdTemp") != null) {
			departmentIdTemp = Integer.parseInt(""
					+ dataMap.get("departmentIdTemp"));
		}
		//System.out.println("departmentIdTemp in DS " + departmentIdTemp);
		hbt.setFlushModeName("FLUSH_EAGER");
		deleteStoreIssueList = hbt
				.find("from jkt.hms.masters.business.StoreIssueM as sim where  sim.IssueType='o'  and sim.Status='o' and sim.ToUnit.Id=1");
		//System.out.println("deleteStoreIssueList   "+ deleteStoreIssueList.size());
		map.put("deleteStoreIssueList", deleteStoreIssueList);
		return map;
	}

	public Map showDeleteIsuueToOtherUnits(Box box) {

		List<StoreIssueT> deleteStoreIssueList = new ArrayList<StoreIssueT>();
		StoreIssueT storeIssueT = new StoreIssueT();
		Map map = new HashMap();
		HibernateTemplate hbt = getHibernateTemplate();
		session = (Session) getSession();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		int departmentIdTemp = 0;

		departmentIdTemp = Integer.parseInt("" + box.get("issueId"));

		hbt.setFlushModeName("FLUSH_EAGER");
		int issueId = 0;
		if (box.get("issueId") != null) {
			issueId = Integer.parseInt("" + box.get("issueId"));
		}
		//System.out.println("issueId   " + issueId);
		String qry = "SELECT i.item_id,item.nomenclature,item2.nomenclature,i.qty_request,i.qty_issued,i.issue_m_id FROM store_issue_t i,mas_store_item item,mas_store_item item2 where  i.issue_m_id='"
				+ issueId
				+ "' and item.item_id=i.item_id  and item2.item_id=i.item_issued and  i.issued='y' group by i.item_id;";
		List objectList = (List) session.createSQLQuery(qry).list();

		int id = 0;
		String nomenclature = null;
		int itemId = 0;
		int detailId = 0;
		String issuedItemName = null;
		BigDecimal requestedQty = null;
		BigDecimal issuedQty = null;
		int issueMId = 0;

		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();

			try {
				itemId = (Integer) object[0];
			} catch (Exception e) {
				e.printStackTrace();
				itemId = 0;
			}
			try {
				nomenclature = (String) object[1];
			} catch (Exception e) {
				nomenclature = "";
			}
			try {
				issuedItemName = (String) object[2];
			} catch (Exception e) {
				e.printStackTrace();
				issuedItemName = "";
			}
			try {
				requestedQty = new BigDecimal("" + object[3]);
			} catch (Exception e) {
				requestedQty = new BigDecimal("" + 0);
			}

			try {
				issuedQty = new BigDecimal("" + object[4]);
			} catch (Exception e) {
				e.printStackTrace();
				issuedQty = new BigDecimal("" + 0);
			}

			try {
				issueMId = (Integer) object[5];
			} catch (Exception e) {
				e.printStackTrace();
				issueMId = 0;
			}
			hData = new HashMap<String, Object>();

			hData.put("nomenclature", nomenclature);
			hData.put("issuedItemName", issuedItemName);
			hData.put("requestedQty", requestedQty);
			hData.put("issuedQty", issuedQty);
			hData.put("itemId", itemId);
			hData.put("issueMId", issueMId);

			vResult.add(hData);
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		deleteStoreIssueList = hbt
				.find("from jkt.hms.masters.business.StoreIssueM as sim where  sim.IssueType='o'  and sim.Status='o' and sim.ToUnit.Id=1");
		map.put("deleteStoreIssueList", deleteStoreIssueList);
		map.put("pagedArray", pagedArray);
		return map;

	}

	public Map deleteIssueToOtherUnitsItems(Box box) {

		Session session = (Session) getSession();
		List<StoreIssueT> storeTenderTList = new ArrayList<StoreIssueT>();
		StoreIssueT storeIssueT = new StoreIssueT();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIssueT> deleteStoreIssueList = new ArrayList<StoreIssueT>();
		session = (Session) getSession();
		Transaction tx = null;
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector id = box.getVector("id");
			Vector nomenclature = box.getVector("nomenclature");
			Vector delete = box.getVector("items_to_be_deleted");
			Vector issueMId = box.getVector("issueMId");
			Vector qtyInReq = box.getVector("requestedQty");
			Vector issuedQty = box.getVector("issuedQty");

			String obj = null;
			int tempBrandId = 0;
			//System.out.println("delete.size()  " + delete.size());

			for (int i = 0; i < delete.size(); i++) {
				StoreIssueT storeIssueT2 = new StoreIssueT();
				int item_id = Integer.parseInt(delete.get(i).toString());
				int issueId = Integer.parseInt(issueMId.get(i).toString());
				BigDecimal qtyReq = new BigDecimal(qtyInReq.get(i).toString());
				List<StoreIssueT> tempList = new ArrayList<StoreIssueT>();

				tempList = hbt
						.find("from jkt.hms.masters.business.StoreIssueT as a where a.IssueM.Id='"
								+ issueId
								+ "' and a.Item.Id=  '"
								+ item_id
								+ "'  ");
				for (StoreIssueT storeIssueT3 : tempList) {
					if (storeIssueT3.getBrand() != null) {
						tempBrandId = Integer.parseInt(""
								+ storeIssueT3.getBrand().getId());
						BigDecimal bigDecimal = new BigDecimal(""
								+ issuedQty.get(i));
						String qry = "update store_item_batch_stock as s set s.closing_stock =(s.closing_stock+'"
								+ bigDecimal
								+ "') where brand_id='"
								+ tempBrandId + "' ";
						Query query2 = session.createSQLQuery(qry);
						int row2 = query2.executeUpdate();
					}
				}

				String hql = "delete from jkt.hms.masters.business.StoreIssueT as a where a.IssueM.Id='"
						+ issueId + "' and a.Item.Id=  '" + item_id + "' ";
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
			}

			deleteStoreIssueList = hbt
					.find("from jkt.hms.masters.business.StoreIssueM as sim where  sim.IssueType='o'  and sim.Status='o' and sim.ToUnit.Id=1");
			//System.out.println();
			// map.put("deleteStoreIssueList",deleteStoreIssueList);
			//System.out.println("deleteStoreIssueList  deleteStoreIssueList  "	+ deleteStoreIssueList.size());
			map.put("total_records", id.size());
			map.put("deleted_records", delete.size());
			// --------------Transaction Ended----------
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();

		}

		if (Integer.parseInt(map.get("total_records").toString()) == Integer
				.parseInt(map.get("deleted_records").toString())) {
			//System.out.println("total and deleted equal");
			if (box.getInt("currPage") > 1)
				box.put("currPage", box.getInt("currPage") - 1);
		}

		map = showDeleteIsuueToOtherUnits(box);
		return map;

	}

	public Map showIssueToOtherUnitsJsp(Map<String, Object> dataMap) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}

		Map map = new HashMap();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasStoreBrand> masStoreBrandList = new ArrayList<MasStoreBrand>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();
		String max = "";
		String startNo = "";
		String no = "";
		try {
			patientList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.Patient as pt where pt.Status='y'");
			storeInternalIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreInternalIndentM");
			departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment");
			masStoreAirForceDepotList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreAirForceDepot");
			employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee");
			storeFyDocumentNoList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreFyDocumentNo ");

			storeFyDocumentNoList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "' ");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getIssueOtherUnitsNo() != null) {
					no = ("" + storeFyDocumentNo.getIssueOtherUnitsNo());
				} else {
					no = "";
				}
			}
			searchListForPopup = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIssueM as sim where sim.IssueType='o' and sim.Status='o' and sim.Department.Id='"
									+ deptId + "' ");

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			max = getMaxNo(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("storeInternalIndentMList", storeInternalIndentMList);
		map.put("storeInternalIndentTList", storeInternalIndentTList);
		map.put("departmentList", departmentList);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("employeeList", employeeList);
		map.put("max", max);
		map.put("masStoreBrandList", masStoreBrandList);
		map.put("searchListForPopup", searchListForPopup);
		map.put("patientList", patientList);
		return map;

	}

	public Map searchIssueToOtherUnits(Box box) {
		Map map = new HashMap();
		int issueId = 0;
		List<StoreIssueM> list = new ArrayList<StoreIssueM>();
		try {
			issueId = Integer.parseInt("" + box.get("issueUnit"));
			//System.out.println("issueId issueId  " + issueId);
			list = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIssueM as ss where ss.Id='"
							+ issueId + "'");
			for (StoreIssueM issueM : list) {
				box.put("issueId", issueId);
				box.put("issueNo", issueM.getIssueNo());
				box.put("departmentIdTemp", issueM.getToStore().getId());
				box.put("docNo", issueM.getDocNo());
				box.put("requestBy", issueM.getRequestBy().getId());
				box.put("approvedBy", issueM.getApprovedBy().getId());
				box.put("issuedBy", issueM.getIssuedBy().getId());

			}
			map.put("box", box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasStoreBrand> masStoreBrandList = new ArrayList<MasStoreBrand>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();

		String startNo = "";
		String no = "";
		try {
			patientList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.Patient as pt where pt.Status='y'");
			storeInternalIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreInternalIndentM");
			departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment");
			masStoreAirForceDepotList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreAirForceDepot");
			itemList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreItem as it where it.Id<100 ");
			employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee");
			storeFyDocumentNoList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreFyDocumentNo ");

			// searchListForPopup=getHibernateTemplate().find("from jkt.hms.masters.business.StoreIssueM as sim where sim.RequestType='m' and sim.IssueType and sim.DocType='l' and sim.Status='o'");
			searchListForPopup = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIssueM ");
			//System.out.println("storeInternalIndentMList                     "+ storeInternalIndentMList.size());
			//System.out.println("storeInternalIndentTList  "+ storeInternalIndentTList.size());
			//System.out.println("departmentList  " + departmentList.size());
			//System.out.println("masStoreAirForceDepotList "+ masStoreAirForceDepotList.size());
			//System.out.println("searchListForPopup "+ searchListForPopup.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("storeInternalIndentMList", storeInternalIndentMList);
		map.put("storeInternalIndentTList", storeInternalIndentTList);
		map.put("departmentList", departmentList);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("itemList", itemList);
		map.put("employeeList", employeeList);
		map.put("masStoreBrandList", masStoreBrandList);
		map.put("searchListForPopup", searchListForPopup);
		map.put("patientList", patientList);

		return map;
	}

	public Map<String, Object> getItemListThroughAjax(
			Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String au = null;
		BigDecimal qtymmf = null;
		BigDecimal annreq = null;
		int item_id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = dataMap.get("autoHint") + "%";
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("Nomenclature", str));
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;

	}

	public Map<String, Object> fillItemsForIssueToDepot(
			Map<String, Object> dataMap) {
		//System.out.println("dataMap values" + dataMap);
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		try {
			pvmsNo = "" + dataMap.get("pvmsNo");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", pvmsNo));
			itemList = c.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	// -----------------------------------End Of Issues To Other Units on
	// Surplus (CIV) --------------------------------

	// --------------------------------Start Of Issues To Other Than Airforce
	// Units ---------------------------------

	public Map addBrandDetailsToOTAFU(Box box) throws java.text.ParseException {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}

		Map map = new HashMap();
		int itemId = 0;
		int detailId = 0;
		int itemIssuedIdArray[] = null;
		String qtyIssuedTempArray[] = null;
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		String successfullyAdded = "n";
		int issueId = 0;
		session = (Session) getSession();
		Transaction tx = null;

		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();

			Vector brandId = box.getVector(BRAND_ID);
			Vector qtyIssued = box.getVector(QTY_ISSUED);
			Vector remarks = box.getVector(RequestConstants.REMARKS);
			Vector batchNo = box.getVector(RequestConstants.BATCH_NO);
			Vector expDate = box.getVector(RequestConstants.EXPIRY_DATE);

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			String issueNo = "" + box.get("issueNo");
			issueId = Integer.parseInt("" + box.get("issueId"));
			int departmentIdTemp = Integer.parseInt(""
					+ box.get("departmentIdTemp"));
			StoreIssueM storeIssueM = new StoreIssueM();
			System.out
					.println("issueId                                                                  "
							+ issueId);
			if (issueId == 0) {
				storeIssueM.setIssueType("x");
				storeIssueM.setIssueNo(box.get("issueNo"));
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String dd = "" + box.get("issueDate");
				String date4MySQL = formatterOut.format(formatterIn.parse(dd));
				java.sql.Date issueDate = java.sql.Date.valueOf(date4MySQL);
				storeIssueM.setIssueDate(issueDate);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIssueM.setDepartment(masDepartment);

				storeIssueM.setRequestNo(null);
				storeIssueM.setRequestDate(null);

				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(Integer.parseInt("" + box.get("requestBy")));
				storeIssueM.setRequestBy(masEmployee);

				MasUnit masUnit = new MasUnit();
				masUnit.setId(Integer
						.parseInt("" + box.get("departmentIdTemp")));
				storeIssueM.setOtafu(masUnit);

				MasEmployee masEmployee2 = new MasEmployee();
				masEmployee2.setId(Integer.parseInt("" + box.get("issuedBy")));
				storeIssueM.setIssuedBy(masEmployee2);

				MasEmployee masEmployee3 = new MasEmployee();
				masEmployee3
						.setId(Integer.parseInt("" + box.get("approvedBy")));
				storeIssueM.setApprovedBy(masEmployee3);
				storeIssueM.setStatus("o");
				storeIssueM.setDocNo(box.get("docNo"));
				storeIssueM.setToUnit(null);
				storeIssueM.setToDepot(null);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(Integer.parseInt("" + box.get("hospitalId")));
				storeIssueM.setHospital(masHospital);
				storeIssueM.setLastChgBy(box.get("changed_by"));
				storeIssueM.setLastChgDate(issueDate);
				storeIssueM.setLastChgTime(box.get("changed_time"));

				hbt.save(storeIssueM);
				hbt.refresh(storeIssueM);
			} else {
				storeIssueM.setId(issueId);
			}
			for (int i = 0; i < brandId.size(); i++) {
				if (Integer.parseInt("" + qtyIssued.get(i)) != 0) {
					StoreIssueT storeIssueT = new StoreIssueT();

					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem
							.setId(Integer.parseInt("" + box.get("itemId")));
					storeIssueT.setItem(masStoreItem);
					storeIssueT.setQtyRequest(new BigDecimal(0));
					storeIssueT.setItem(masStoreItem);
					storeIssueT.setBatchNo("" + batchNo.get(i));
					storeIssueT.setQtyIssued(new BigDecimal(""
							+ qtyIssued.get(i)));
					storeIssueT.setRemarks(box.get("remarks"));
					//System.out.println("expDate.get(i)  " + expDate.get(i));
					try {
						storeIssueT
								.setExpiryDate(new Date("" + expDate.get(i)));
					} catch (Exception e) {
						storeIssueT.setExpiryDate(null);
					}

					MasStoreBrand brand = new MasStoreBrand();
					brand.setId(Integer.parseInt("" + brandId.get(i)));
					storeIssueT.setBrand(brand);
					if (("" + remarks.get(i)).equals("emptyString")) {
						storeIssueT.setRemarks(null);
					} else {
						storeIssueT.setRemarks("" + remarks.get(i));
					}

					storeIssueT.setIssueM(storeIssueM);
					storeIssueT.setSrNo(0);
					storeIssueT.setIssued("y");
					storeIssueT.setItemIssued(masStoreItem);
					hbt.save(storeIssueT);
					hbt.refresh(storeIssueT);

					String qry = "select closing_stock from store_item_batch_stock where brand_id="
							+ brandId.get(i);
					List c = (List) session.createSQLQuery(qry).list();
					BigDecimal stock = (BigDecimal) c.get(0);
					String hql2 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.ClosingStock='"
							+ stock.subtract(new BigDecimal(""
									+ qtyIssued.get(i)))
							+ "' where a.Brand.Id='"
							+ brandId.get(i)
							+ "' where a.Department.Id=1";
					Query query2 = session.createQuery(hql2);
					int row2 = query2.executeUpdate();
				}
			}
			//System.out.println("issueNo  ssssssssssss" + issueNo);
			//System.out.println("departmentIdTemp  ssssss" + departmentIdTemp);
			String qry = "select id from store_issue_m where issue_no='"
					+ issueNo
					+ "' and issue_type='x' and department_id=1 and otafu='"
					+ departmentIdTemp + "';";
			List objectList = (List) session.createSQLQuery(qry).list();
			//System.out.println("objectList   " + objectList.size());
			issueId = Integer.parseInt("" + objectList.get(0));

			int storeFyId = 0;
			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}

			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
					.load(StoreFyDocumentNo.class, storeFyId);
			storeFyDocumentNo.setIssueOtafuNo(issueNo);
			hbt.update(storeFyDocumentNo);

			// --------------Transaction End----------
			tx.commit();
			successfullyAdded = "y";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			e.printStackTrace();
		} finally {
			// session.close();
		}

		map.put("successfullyAdded", successfullyAdded);
		map.put("issueId", issueId);
		return map;
	}

	public Map<String, Object> openDeletePopupForIssueToOTAFU(Map dataMap) {
		Map map = new HashMap();
		int deptId = 0;
		session = (Session) getSession();
		List<StoreIssueM> deleteStoreIssueList = new ArrayList<StoreIssueM>();
		HibernateTemplate hbt = getHibernateTemplate();
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}

		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		try {
			Criteria c = session.createCriteria(StoreIssueM.class).add(
					Restrictions.eq("IssueType", "x")).add(
					Restrictions.eq("Status", "o")).add(
					Restrictions.eq("Department.Id", deptId));
			c.setFirstResult(0);
			c.setMaxResults(10);
			deleteStoreIssueList = c.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("deleteStoreIssueList", deleteStoreIssueList);
		map.put("deptId", deptId);
		return map;
	}

	public Map showDeleteIsuueToOTAFU(Box box) {
		int deptId = 0;
		deptId = Integer.parseInt("" + box.get("deptId"));
		List<StoreIssueT> deleteStoreIssueList = new ArrayList<StoreIssueT>();
		StoreIssueT storeIssueT = new StoreIssueT();
		Map map = new HashMap();
		HibernateTemplate hbt = getHibernateTemplate();
		session = (Session) getSession();
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		int departmentIdTemp = 0;

		departmentIdTemp = Integer.parseInt("" + box.get("departmentIdTemp"));
		//System.out.println("departmentIdTemp   in DS departmentIdTemp in DS  "+ departmentIdTemp);

		hbt.setFlushModeName("FLUSH_EAGER");
		int issueId = 0;
		if (box.get("issueId") != null) {
			issueId = Integer.parseInt("" + box.get("issueId"));
		}
		//System.out.println("issueId   " + issueId);
		String qry = "SELECT i.item_id,item.nomenclature,item2.nomenclature,i.qty_request,i.qty_issued,i.issue_m_id FROM store_issue_t i,mas_store_item item,mas_store_item item2 where  i.issue_m_id='"
				+ issueId
				+ "' and item.item_id=i.item_id  and item2.item_id=i.item_issued and  i.issued='y' group by i.item_id;";
		List objectList = (List) session.createSQLQuery(qry).list();

		int id = 0;
		String nomenclature = null;
		int itemId = 0;
		int detailId = 0;
		String issuedItemName = null;
		BigDecimal requestedQty = null;
		BigDecimal issuedQty = null;
		int issueMId = 0;

		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();

			try {
				itemId = (Integer) object[0];
			} catch (Exception e) {
				e.printStackTrace();
				itemId = 0;
			}
			try {
				nomenclature = (String) object[1];
			} catch (Exception e) {
				nomenclature = "";
			}
			try {
				issuedItemName = (String) object[2];
			} catch (Exception e) {
				e.printStackTrace();
				issuedItemName = "";
			}
			try {
				requestedQty = new BigDecimal("" + object[3]);
			} catch (Exception e) {
				requestedQty = new BigDecimal("" + 0);
			}

			try {
				issuedQty = new BigDecimal("" + object[4]);
			} catch (Exception e) {
				e.printStackTrace();
				issuedQty = new BigDecimal("" + 0);
			}

			try {
				issueMId = (Integer) object[5];
			} catch (Exception e) {
				e.printStackTrace();
				issueMId = 0;
			}
			hData = new HashMap<String, Object>();

			hData.put("nomenclature", nomenclature);
			hData.put("issuedItemName", issuedItemName);
			hData.put("requestedQty", requestedQty);
			hData.put("issuedQty", issuedQty);
			hData.put("itemId", itemId);
			hData.put("issueMId", issueMId);

			vResult.add(hData);
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Criteria c = session.createCriteria(StoreIssueM.class).add(
					Restrictions.eq("IssueType", "x")).add(
					Restrictions.eq("Status", "o")).add(
					Restrictions.eq("Department.Id", deptId));
			c.setFirstResult(0);
			c.setMaxResults(10);
			deleteStoreIssueList = c.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("deleteStoreIssueList", deleteStoreIssueList);
		map.put("pagedArray", pagedArray);
		return map;

	}

	public Map deleteIssueToOTAFU(Box box) {
		int deptId = 0;
		deptId = Integer.parseInt("" + box.get("deptId"));
		Session session = (Session) getSession();
		List<StoreIssueT> storeTenderTList = new ArrayList<StoreIssueT>();
		StoreIssueT storeIssueT = new StoreIssueT();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIssueT> deleteStoreIssueList = new ArrayList<StoreIssueT>();
		int departmentIdTemp = 0;
		session = (Session) getSession();
		Transaction tx = null;
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();

			departmentIdTemp = Integer.parseInt(""
					+ box.get("departmentIdTemp"));
			System.out
					.println("departmentIdTemp  in deleteIssueToOTAFU departmentIdTemp  "
							+ departmentIdTemp);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector id = box.getVector("id");
			Vector nomenclature = box.getVector("nomenclature");
			Vector delete = box.getVector("items_to_be_deleted");
			Vector issueMId = box.getVector("issueMId");
			Vector qtyInReq = box.getVector("requestedQty");
			Vector issuedQty = box.getVector("issuedQty");

			String obj = null;
			int tempBrandId = 0;
			//System.out.println("delete.size()  " + delete.size());

			for (int i = 0; i < delete.size(); i++) {
				StoreIssueT storeIssueT2 = new StoreIssueT();
				int item_id = Integer.parseInt(delete.get(i).toString());
				int issueId = Integer.parseInt(issueMId.get(i).toString());
				BigDecimal qtyReq = new BigDecimal(qtyInReq.get(i).toString());
				List<StoreIssueT> tempList = new ArrayList<StoreIssueT>();

				tempList = hbt
						.find("from jkt.hms.masters.business.StoreIssueT as a where a.IssueM.Id='"
								+ issueId
								+ "' and a.Item.Id=  '"
								+ item_id
								+ "'  ");
				for (StoreIssueT storeIssueT3 : tempList) {
					if (storeIssueT3.getBrand() != null) {
						tempBrandId = Integer.parseInt(""
								+ storeIssueT3.getBrand().getId());
						BigDecimal bigDecimal = new BigDecimal(""
								+ issuedQty.get(i));
						String qry = "update store_item_batch_stock as s set s.closing_stock =(s.closing_stock+'"
								+ bigDecimal
								+ "') where brand_id='"
								+ tempBrandId + "' ";
						Query query2 = session.createSQLQuery(qry);
						int row2 = query2.executeUpdate();
					}
				}

				String hql = "delete from jkt.hms.masters.business.StoreIssueT as a where a.IssueM.Id='"
						+ issueId + "' and a.Item.Id=  '" + item_id + "' ";
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
			}

			try {
				Criteria c = session.createCriteria(StoreIssueM.class).add(
						Restrictions.eq("IssueType", "x")).add(
						Restrictions.eq("Status", "o")).add(
						Restrictions.eq("Department.Id", deptId));
				c.setFirstResult(0);
				c.setMaxResults(10);
				deleteStoreIssueList = c.list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// map.put("deleteStoreIssueList",deleteStoreIssueList);
			//System.out.println("deleteStoreIssueList  deleteStoreIssueList  "	+ deleteStoreIssueList.size());
			map.put("total_records", id.size());
			map.put("deleted_records", delete.size());
			// --------------Transaction Ended----------
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();

		}

		if (Integer.parseInt(map.get("total_records").toString()) == Integer
				.parseInt(map.get("deleted_records").toString())) {
			//System.out.println("total and deleted equal");
			if (box.getInt("currPage") > 1)
				box.put("currPage", box.getInt("currPage") - 1);
		}

		map = showDeleteIsuueToOTAFU(box);
		return map;

	}

	public Map showIssueToOTAFUJsp(Map<String, Object> dataMap) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}

		Map map = new HashMap();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();

		int departmentId = 0;
		String max = "";
		String startNo = "";
		String no = "";
		if (dataMap.get("departmentId") != null) {
			departmentId = Integer.parseInt("" + dataMap.get("departmentId"));
		}

		try {
			departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment");
			masUnitList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasUnit");
			employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee");
			storeFyDocumentNoList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "' ");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getIssueOtafuNo() != null) {
					no = ("" + storeFyDocumentNo.getIssueOtafuNo());
				} else {
					no = "";
				}
			}
			max = getMaxNo(no);
			searchListForPopup = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIssueM as sim where sim.IssueType='x' and sim.Status='o' and sim.Department.Id='"
									+ departmentId + "' ");

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("masUnitList", masUnitList);
		map.put("employeeList", employeeList);
		map.put("max", max);
		map.put("searchListForPopup", searchListForPopup);
		return map;

	}

	public Map searchIssueToOTAFU(Box box) {
		Map map = new HashMap();
		int issueId = 0;
		List<StoreIssueM> list = new ArrayList<StoreIssueM>();
		try {
			issueId = Integer.parseInt("" + box.get("issueUnit"));
			//System.out.println("issueId issueId  " + issueId);
			list = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIssueM as ss where ss.Id='"
							+ issueId + "'");
			for (StoreIssueM issueM : list) {
				box.put("issueId", issueId);
				box.put("issueNo", issueM.getIssueNo());
				box.put("departmentIdTemp", issueM.getOtafu().getId());
				box.put("docNo", issueM.getDocNo());
				box.put("requestBy", issueM.getRequestBy().getId());
				box.put("approvedBy", issueM.getApprovedBy().getId());
				box.put("issuedBy", issueM.getIssuedBy().getId());

			}
			map.put("box", box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasStoreBrand> masStoreBrandList = new ArrayList<MasStoreBrand>();
		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();

		String startNo = "";
		String no = "";
		try {
			masUnitList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasUnit as pt where pt.Status='y'");
			storeInternalIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreInternalIndentM");
			departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment");
			employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee");
			storeFyDocumentNoList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreFyDocumentNo ");

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("storeInternalIndentMList", storeInternalIndentMList);
		map.put("storeInternalIndentTList", storeInternalIndentTList);
		map.put("departmentList", departmentList);
		map.put("itemList", itemList);
		map.put("employeeList", employeeList);
		map.put("masStoreBrandList", masStoreBrandList);
		map.put("searchListForPopup", searchListForPopup);
		map.put("masUnitList", masUnitList);

		return map;
	}

	public Map<String, Object> getItemListThroughAjaxToOTAFU(
			Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String au = null;
		BigDecimal qtymmf = null;
		BigDecimal annreq = null;
		int item_id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = dataMap.get("autoHint") + "%";
			// Criteria c =
			// session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature",str));
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("Nomenclature", str));
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();
			System.out
					.println("itemList inside ajax call ======================== "
							+ itemList);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;

	}

	public Map<String, Object> fillItemsForIssueToOTAFU(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String au = null;
		BigDecimal qtymmf = null;
		BigDecimal annreq = null;
		int item_id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "" + dataMap.get("nomenclature");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("Nomenclature", str));
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("itemList", itemList);
		return map;
	}

	public boolean addIndent(StoreIndentM storeIndentM)
			throws IllegalStateException, SystemException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addIndents(StoreIndentM storeIndentM, List list, Map map) {
		// TODO Auto-generated method stub
		return false;
	}

	public Map<String, Object> getItemListForIssueToOTAFU(
			Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int deptId = 0;
		int issueId = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		issueId = Integer.parseInt("" + dataMap.get("issueId"));
		List objectList = new ArrayList();
		try {
			String str = dataMap.get("autoHint") + "%";
			if (issueId != 0) {
				String qry = " SELECT item_id FROM store_issue_t where issue_m_id='"
						+ issueId + "';";
				objectList = (List) session.createSQLQuery(qry).list();
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.not(Restrictions.in("Id", objectList)));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			} else {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId));

				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;

	}

	// -----------------------------------End Of Issues To Other Than Airforce
	// Units --------------------------------

	// ----------------------------Start Of Vendor Return ----------------------
	public Map<String, Object> getItemListForVendorReturn(
			Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvmsNo = null;
		int deptId = 0;
		int indentId = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		indentId = Integer.parseInt("" + dataMap.get("indentId"));
		List objectList = new ArrayList();
		//System.out.println("deptId  _________________" + deptId);
		//System.out.println("indentId __________________ " + indentId);
		try {
			String str = dataMap.get("autoHint") + "%";
			//System.out.println("str    " + str);
			// String qry1
			// ="SELECT t.item_id FROM store_indent_t t,store_indent_m m where t.indent_id='"+indentId+"' and m.indent_id=t.indent_id";
			// String
			// qry="select Distinct(sib.brand_id),brand.brand_name from  store_item_batch_stock as sib,mas_store_brand as brand   where sib.department_id='"+deptId+"' and sib.brand_id=brand.brand_id and and brand.brand_name LIKE '"+str+";";
			// objectList = (List) session.createSQLQuery(qry).list();
			String query = "SELECT DISTINCT (sib.Brand.BrandName),sib.Brand.Id from  StoreItemBatchStock as sib where   sib.Brand.BrandName like '"
					+ str + "'";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
			Query q2 = session.createQuery(query);
			q2.setFirstResult(0);
			q2.setMaxResults(10);
			itemList = q2.list();
			// if(objectList.size()!=0){
			// Criteria c =
			// session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature",str))
			// .add(Restrictions.eq("Department.Id", deptId))
			// .add(Restrictions.not(Restrictions.in("Id", objectList)));
			// c.setFirstResult(0);
			// c.setMaxResults(10);
			// itemList = c.list();
			// }else{
			// Criteria c =
			// session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature",str))
			// .add(Restrictions.eq("Department.Id", deptId));
			// c.setFirstResult(0);
			// c.setMaxResults(10);
			// itemList = c.list();
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("itemList        ========================== "+ itemList.size());
		map.put("itemList", itemList);
		return map;

	}

	public Map<String, Object> fillItemsForIndentToVendorReturn(
			Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String brandName = null;
		int item_id = 0;
		int deptId = 0;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		List objectList = new ArrayList();
		brandName = "" + dataMap.get("brandName");
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		try {
			String qry = "SELECT item.item_id,item.pvms_no,item.nomenclature,brand.brand_id  FROM mas_store_item item,mas_store_brand brand where brand.brand_id=item.item_id and brand.brand_name='"
					+ brandName + "' and item.department_id='" + deptId + "';";
			objectList = (List) session.createSQLQuery(qry).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("objectList  " + objectList.size());
		map.put("objectList", objectList);
		return map;
	}

	public Map<String, Object> showVendorReturnJsp(Map<String, Object> map) {
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<StoreItemBatchStock> listOfItemsInStock = new ArrayList<StoreItemBatchStock>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<StoreFyDocumentNo> issueReturnNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreGrnReturnM> returnNoList = new ArrayList<StoreGrnReturnM>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<StoreGrnReturnM> searchList = new ArrayList<StoreGrnReturnM>();
		Session session = (Session) getSession();
		String returnNo = "";
		String finalReturnNo = "";
		int storeFyDocumentNoId = 0;
		String buttonFlag = "";
		String no = "";
		int deptId = 0;
		String max = "";
		if (map.get("buttonFlag") != null) {
			buttonFlag = (String) map.get("buttonFlag");
		}
		if (map.get("deptId") != null) {
			deptId = Integer.parseInt("" + map.get("deptId"));
		}
		//System.out.println("deptId  in DS  " + deptId);
		try {
			storeFyDocumentNoList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "' ");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getVendorReturnNo() != null) {
					no = ("" + storeFyDocumentNo.getVendorReturnNo());
				} else {
					no = "";
				}
				//System.out.println("no =================== " + no);
			}
			supplierList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplier as pt where pt.Status='y'");
			searchList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreGrnReturnM as pt where pt.Status='y' and pt.Department.id='"
									+ deptId + "'");
			max = getMaxNo(no);
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			deptList = session.createQuery(
					"select md from MasDepartment  as md where md.DepartmentType.Id="
							+ deptId).list();

			listOfItemsInStock = session
					.createQuery(
							"select sib,  sum(sib.ClosingStock) from StoreItemBatchStock as sib where sib.Department.Id="
									+ deptId
									+ "group by sib.BatchNo,sib.CostPrice ")
					.list();
			brandList = session
					.createQuery(
							"select Distinct(sib.Brand.Id),sib.Brand.BrandName from  StoreItemBatchStock as sib where sib.Department.Id="
									+ deptId).list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();

			issueReturnNoList = session.createQuery(
					"select syd from StoreFyDocumentNo as syd where syd.Department.Id="
							+ deptId).list();

			Iterator iterator = listOfItemsInStock.iterator();
			while (iterator.hasNext()) {
				Object[] pair = (Object[]) iterator.next();
				StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) pair[0];
				BigDecimal qtyInHand = (BigDecimal) pair[1];
				String pvmsNo = storeItemBatchStock.getItem().getPvmsNo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!buttonFlag.equals("next")) {
			if (issueReturnNoList != null && issueReturnNoList.size() > 0) {
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) issueReturnNoList
						.get(0);
				returnNo = ("" + storeFyDocumentNo.getIssueDeptReturnNo());
				storeFyDocumentNoId = storeFyDocumentNo.getId();
				try {
					finalReturnNo = getMaxNo(returnNo);
					//System.out.println("finalReturnNo in DS-----"	+ finalReturnNo);
				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("storeFyDocumentNoId", storeFyDocumentNoId);
				map.put("finalReturnNo", finalReturnNo);
			}
		}
		//System.out.println("max  " + max);
		map.put("listOfItemsInStock", listOfItemsInStock);
		map.put("issueReturnNoList", issueReturnNoList);
		map.put("brandList", brandList);
		map.put("returnNoList", returnNoList);
		map.put("deptList", deptList);
		map.put("employeeList", employeeList);
		map.put("max", max);
		map.put("supplierList", supplierList);
		map.put("searchList", searchList);

		return map;
	}

	public Map<String, Object> showStockDetailsForVendorReturn(
			Map<String, Object> map) {
		List listOfItemsInStock = new ArrayList();

		Session session = (Session) getSession();
		int deptId = (Integer) map.get("deptId");
		int brandId = (Integer) map.get("brandId");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			listOfItemsInStock = session
					.createQuery(
							"select sib,  sum(sib.ClosingStock) from StoreItemBatchStock as sib where sib.Department.Id="
									+ deptId
									+ " and sib.Brand.Id="
									+ brandId
									+ "group by sib.BatchNo,sib.CostPrice ")
					.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("listOfItemsInStock", listOfItemsInStock);

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitVendorReturnDetails(Map<String, Object> map) {
		session = (Session) getSession();
		boolean succesfullyAdded = false;
		String fromDateToDate = null;
		String issueType = "w";
		List<String> pvmsList = (List) map.get("pvmsList");
		List<String> batchNumberList = (List) map.get("batchNumberList");
		List brandNameList = (List) map.get("brandNameList");
		List expiryDateList = (List) map.get("expiryDateList");
		List issQtyList = (List) map.get("issQtyList");
		List costPriceList = (List) map.get("costPriceList");
		List amountList = (List) map.get("amountList");
		List storeItemBatchStockIdList = (List) map
				.get("storeItemBatchStockIdList");
		String date = (String) map.get("date");
		StoreGrnReturnM storeGrnReturnM = new StoreGrnReturnM();

		String returnDate = (String) map.get("returnDate");
		String returnNo = (String) map.get("returnNo");
		String referenceNo = (String) map.get("referenceNo");
		String SONo = (String) map.get("SONo");

		int returnById = (Integer) map.get("returnById");

		String remarks = (String) map.get("remarks");
		String reason = (String) map.get("reason");

		int vendorId = (Integer) map.get("vendorId");
		int hospitalId = (Integer) map.get("hospitalId");
		String time = (String) map.get("time");
		String userName = (String) map.get("userName");
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		int storeFyId = 0;
		int deptId = 0;
		int approvedById = 0;
		int storeGrnReturnMId = 0;
		deptId = Integer.parseInt("" + map.get("deptId"));
		int itemId = Integer.parseInt("" + map.get("itemId"));
		approvedById = Integer.parseInt("" + map.get("approvedById"));
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
		Date returnDateForAdd = HMSUtil
				.convertStringTypeDateToDateType(returnDate);
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction transaction = null;
		try {
			// --------------Transaction Started----------
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}

			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
					.load(StoreFyDocumentNo.class, storeFyId);
			storeFyDocumentNo.setVendorReturnNo(returnNo);
			hbt.update(storeFyDocumentNo);

			if (storeGrnReturnMId == 0) {
				storeGrnReturnM.setReturnNo(returnNo);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeGrnReturnM.setDepartment(masDepartment);

				MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
				masStoreSupplier.setId(vendorId);
				storeGrnReturnM.setSupplier(masStoreSupplier);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeGrnReturnM.setHospital(masHospital);

				storeGrnReturnM.setReturnDate(returnDateForAdd);
				storeGrnReturnM.setRefDocNo(referenceNo);

				MasEmployee employee = new MasEmployee();
				employee.setId(approvedById);
				storeGrnReturnM.setApprovedBy(employee);

				storeGrnReturnM.setReason(reason);
				storeGrnReturnM.setRemarks(remarks);

				MasEmployee returnBy = new MasEmployee();
				returnBy.setId(returnById);
				storeGrnReturnM.setReturnBy(returnBy);

				storeGrnReturnM.setLastChgBy(userName);
				storeGrnReturnM.setLastChgDate(dateToInsert);
				storeGrnReturnM.setLastChgTime(time);
				storeGrnReturnM.setStatus("y");
				storeGrnReturnM.setSupplyOrderNo(SONo);
				hbt.save(storeGrnReturnM);
			} else {
				storeGrnReturnM.setId(storeGrnReturnMId);
			}
			Iterator itr = issQtyList.iterator();
			for (int i = 0; i < issQtyList.size(); i++) {
				BigDecimal totalQtyReturned;
				StoreGrnReturnT storeGrnReturnT = new StoreGrnReturnT();

				storeGrnReturnT.setGrnReturn(storeGrnReturnM);
				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem.setId(itemId);
				storeGrnReturnT.setItem(masStoreItem);

				storeGrnReturnT.setBatchNo(batchNumberList.get(i));

				MasStoreBrand masStoreBrand = new MasStoreBrand();
				masStoreBrand
						.setId(Integer.parseInt("" + brandNameList.get(i)));
				storeGrnReturnT.setBrand(masStoreBrand);

				String expiryDate = (String) expiryDateList.get(i);

				Date expiryDateToInsert = HMSUtil
						.convertStringTypeDateToDateType(expiryDate);
				storeGrnReturnT.setExpiryDate(expiryDateToInsert);

				BigDecimal issuedReturnFromJsp = new BigDecimal(""
						+ issQtyList.get(i));
				storeGrnReturnT.setReturnQty(issuedReturnFromJsp);
				BigDecimal bigDecimal2 = new BigDecimal(""
						+ costPriceList.get(i));
				storeGrnReturnT.setUnitRate(bigDecimal2);
				BigDecimal bigDecimal3 = new BigDecimal("" + amountList.get(i));
				storeGrnReturnT.setReturnAmount(bigDecimal3);

				int storeItemBatchStockId = Integer.parseInt(""
						+ storeItemBatchStockIdList.get(i));

				StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) hbt
						.load(StoreItemBatchStock.class, storeItemBatchStockId);
				BigDecimal qtyReturned = (BigDecimal) storeItemBatchStock
						.getIssueReturn();

				if (qtyReturned != null) {
					totalQtyReturned = qtyReturned.add(issuedReturnFromJsp);
				} else {
					totalQtyReturned = issuedReturnFromJsp;
				}

				BigDecimal closingStock = (BigDecimal) storeItemBatchStock
						.getClosingStock();
				closingStock = closingStock.subtract(issuedReturnFromJsp);

				storeItemBatchStock.setIssueReturn(totalQtyReturned);
				storeItemBatchStock.setClosingStock(closingStock);

				hbt.save(storeGrnReturnT);
				hbt.update(storeItemBatchStock);

				i++;
			}
			// --------------Transaction End----------
			transaction.commit();
			succesfullyAdded = true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			e.printStackTrace();
		}

		return succesfullyAdded;
	}

	public Map<String, Object> showDeleteVendorReturn(Map<String, Object> map) {
		Session session = (Session) getSession();

		String returnNo = (String) map.get("returnNo");
		//System.out.println("returnNo  " + returnNo);
		List<StoreGrnReturnM> storeReturnMList = session.createQuery(
				"select sim from StoreGrnReturnM as sim where sim.ReturnNo = '"
						+ returnNo + "'").list();
		//System.out.println("storeReturnMList  " + storeReturnMList.size());
		if (storeReturnMList.size() > 0) {
			StoreGrnReturnM storeGrnReturnM = (StoreGrnReturnM) storeReturnMList
					.get(0);
			int returnId = storeGrnReturnM.getId();
			List<StoreGrnReturnT> storeReturnTList = session.createQuery(
					"select sit from StoreGrnReturnT as sit where sit.GrnReturn.Id='"
							+ returnId + "'").list();
			map.put("storeReturnTList", storeReturnTList);
			System.out
					.println("Size>>>>> of storeReturnTList=================="
							+ storeReturnTList.size());
		}

		return map;
	}

	public boolean deleteStockDetailsVendorReturn(Map<String, Object> map) {

		BigDecimal totalQtyReturned;
		boolean sucessfullyDeleted = false;
		Session session = (Session) getSession();
		int returnTId = (Integer) map.get("returnTId");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			StoreGrnReturnT tObj = (StoreGrnReturnT) hbt.load(
					StoreGrnReturnT.class, returnTId);
			int brandId = tObj.getBrand().getId();
			String batchNo = tObj.getBatchNo();
			BigDecimal costPrice = tObj.getUnitRate();
			BigDecimal qtyReturned = tObj.getReturnQty();

			//System.out.println("Batch number in database===" + batchNo+ "======cost price in dataservice layer===" + costPrice);
			//System.out.println("Id of the transaction table that is to be deleted from table====****************"+ returnTId);

			String hql = "delete from StoreGrnReturnT as sit where sit.Id like :returnTId";
			Query query = session.createQuery(hql).setParameter("returnTId",
					returnTId);
			int row = query.executeUpdate();

			List storeItemBatchStockList = session.createQuery(
					"select sib  from StoreItemBatchStock as sib where sib.BatchNo="
							+ batchNo + "and sib.Brand.Id=" + brandId
							+ "and sib.CostPrice=" + costPrice).list();
			StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) storeItemBatchStockList
					.get(0);
			BigDecimal qtyReturnedFromDB = (BigDecimal) storeItemBatchStock
					.getIssueReturn();
			//System.out.println("qtyReturnedFromDB--------" + qtyReturnedFromDB);
			if (qtyReturned != null) {
				totalQtyReturned = qtyReturnedFromDB.subtract(qtyReturned);
			} else {
				totalQtyReturned = qtyReturnedFromDB;
			}
			BigDecimal closingStock = (BigDecimal) storeItemBatchStock
					.getClosingStock();
			closingStock = closingStock.add(qtyReturned);
			//System.out.println("Quantity Returned is ===***********"+ qtyReturned	+ "=====closing stock has been incresed to===="	+ closingStock);
			//System.out.println("Quantity Returned will be decreased to ===***********"+ totalQtyReturned	+ "=====quantity in database ===="+ qtyReturnedFromDB);

			storeItemBatchStock.setIssueQty(totalQtyReturned);
			storeItemBatchStock.setClosingStock(closingStock);
			hbt.update(storeItemBatchStock);

			sucessfullyDeleted = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return sucessfullyDeleted;
	}

	@SuppressWarnings( { "unchecked", "unused" })
	public Map<String, Object> searchVendorReturn(Map<String, Object> searchMap)
			{
		//System.out.println("StoresDataServiceImpl.searchReturnToDispensary()");
		String fromDate = "";
		String toDate = "";
		int returnId = 0;
		int pageNo = 1;
		int firstResult = 0;
		int maxResults = 8;
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		if (searchMap.get("pageNo") != null) {
			pageNo = Integer.parseInt("" + searchMap.get("pageNo"));
		}
		//System.out.println("PAGE NO IN DS pageNo  " + pageNo);
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplier> searchSupplierList = new ArrayList<MasStoreSupplier>();
		List<StoreInternalReturnM> searchReturnMList = new ArrayList<StoreInternalReturnM>();
		List<StoreGrnReturnT> searchReturnTList = new ArrayList<StoreGrnReturnT>();
		Session session = (Session) getSession();

		if (!(searchMap.get("fromDate").equals(""))
				&& (!searchMap.get("toDate").equals(""))) {
			fromDate = (String) searchMap.get("fromDate");
			toDate = (String) searchMap.get("toDate");
			String date4MySQL1;
			String date4MySQL2;
			try {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				date4MySQL1 = formatterOut.format(formatterIn.parse(fromDate));
				date4MySQL2 = formatterOut.format(formatterIn.parse(toDate));
				java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL1);
				java.sql.Date endDate = java.sql.Date.valueOf(date4MySQL2);

				searchReturnTList = session.createCriteria(
						StoreInternalReturnT.class).add(
						Restrictions.eq("ReturnMain.Id", returnId)).list();
				// searchSupplierList =
				// session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status",
				// "y")).list();
				searchReturnMList = session.createCriteria(
						StoreInternalReturnM.class).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.between("ReturnDate", startDate, endDate))
						.list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (pageNo != 1) {
			firstResult = firstResult + (pageNo - 1) * 8;
		}
		if ((Integer) searchMap.get("returnId") != 0) {
			returnId = (Integer) searchMap.get("returnId");

			//System.out.println("returnId v  returnId  returnId  " + returnId);

			Criteria c = session.createCriteria(StoreGrnReturnT.class).add(
					Restrictions.eq("GrnReturn.Id", returnId));
			// Criteria c =
			// session.createCriteria(StoreInternalReturnT.class).add(Restrictions.eq("ReturnMain.Id",
			// loanInId));
			//System.out.println("firstResult  firstResult  " + firstResult);
			//System.out.println("maxResults  maxResults  " + maxResults);
			c.setFirstResult(firstResult);
			c.setMaxResults(maxResults);
			searchReturnTList = c.list();
			// searchSupplierList =
			// session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status",
			// "y")).list();
			searchReturnMList = session.createCriteria(StoreGrnReturnM.class)
					.add(Restrictions.eq("Status", "y")).add(
							Restrictions.eq("Id", returnId)).list();
		}
		supplierList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreSupplier as pt where pt.Status='y'");
		map.put("searchReturnMList", searchReturnMList);

		map.put("supplierList", supplierList);
		map.put("searchReturnTList", searchReturnTList);

		return map;
	}

	// ----------------------------End Of Vendor Return ----------------------

	// ----------------------------Start Of Department Issue
	// ----------------------
	public Map<String, Object> addNextOrSubmitIssue(Map<String, Object> dataMap) {
		System.out
				.println("=================addNextOrSubmitIssue========================");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = null;
		box = (Box) dataMap.get("box");
		session = (Session) getSession();
		Transaction tx = null;
		StoreIssueM storeIssueM = new StoreIssueM();
		StoreIssueM searchListForPopup = new StoreIssueM();
		String date4MySQL = "";
		String messageType = "";
		String messageTOBeVisibleToTheUser = "";
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		int issueId = 0;
		int pageNo = 1;
		String issueNo = "";
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		if (dataMap.get("issueId") != null)
			issueId = Integer.parseInt("" + dataMap.get("issueId"));
		if (dataMap.get("pageNo") != null)
			pageNo = Integer.parseInt("" + dataMap.get("pageNo"));

		Vector itemIdList = box.getVector("itemId");
		Vector qtyIssuedList = box.getVector(RequestConstants.QTY_ISSUED);
		Vector lotNo = box.getVector("lotNo");
		
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		int storeFyId = 0;
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List objectList = new ArrayList();

		try {
			// ---------------------Start of
			// Transaction----------------------------
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (issueId == 0) {
				storeIssueM.setIssueType("i");
				storeIssueM.setIssueNo("" + box.get(RequestConstants.ISSUE_NO));
				issueNo = "" + box.get(RequestConstants.ISSUE_NO);
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String issueDate=box.get(RequestConstants.ISSUE_DATE);
				date4MySQL = formatterOut.format(formatterIn.parse(""
						+ box.get(RequestConstants.ISSUE_DATE)));
				java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL);
				storeIssueM.setIssueDate(startDate);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIssueM.setDepartment(masDepartment);
				storeIssueM.setStatus("o");
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeIssueM.setHospital(masHospital);

				MasDepartment masDepartment2 = new MasDepartment();
				masDepartment2.setId(Integer.parseInt(""
						+ box.get(RequestConstants.DEPARTMENT_ID_TEMP)));
				storeIssueM.setToStore(masDepartment2);
				storeIssueM.setDocNo("" + box.get(RequestConstants.DOC_NO));

				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(Integer.parseInt(""
						+ box.get(RequestConstants.ISSUED_BY)));
				storeIssueM.setIssuedBy(masEmployee);
				hbt.save(storeIssueM);
			} else {
				storeIssueM.setId(issueId);
			}

			for (int i = 0; i < itemIdList.size(); i++) {
				int item_id = Integer.parseInt(itemIdList.get(i).toString());
				if ((item_id != 0)
						&& (!(qtyIssuedList.get(i).toString()).equals(""))) {
					BigDecimal qtyIssued = new BigDecimal(qtyIssuedList.get(i)
							.toString());

					StoreIssueT storeIssueT = new StoreIssueT();

					MasStoreItem item = new MasStoreItem();
					item.setId(item_id);
					storeIssueT.setItem(item);

					MasStoreItem item2 = new MasStoreItem();
					item2.setId(item_id);
					storeIssueT.setItemIssued(item2);
					storeIssueT.setIssued("y");
					storeIssueT.setIssueM(storeIssueM);
					storeIssueT.setQtyIssued(qtyIssued);

					// --------------------------Start of Stock
					// Updating--------------------------
					BigDecimal stock = null;
					BigDecimal issueQty = null;
					String qry = "select closing_stock,issue_qty from store_item_batch_stock where item_id="
							+ item_id +" and department_id="+deptId;
					List c = (List) session.createSQLQuery(qry).list();

					for (Iterator iterator = c.iterator(); iterator.hasNext();) {
						Object[] object = (Object[]) iterator.next();
						if (object[0] == null) {
							stock = new BigDecimal("0");
						} else {
							stock = (BigDecimal) object[0];
						}
						if (object[1] == null) {
							issueQty = new BigDecimal("0");
						} else {
							issueQty = (BigDecimal) object[1];
						}
					}

					stock = stock.subtract(qtyIssued);
					issueQty = issueQty.add(qtyIssued);
					String hql2 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.ClosingStock='"
							+ stock + "'  where a.Item.Id='" + item_id + "' and department_id='"+ deptId + "'";
					String hql3 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.IssueQty='"
							+ issueQty + "'  where a.Item.Id='" + item_id + "' and department_id='"+ deptId + "'";
					Query query2 = session.createQuery(hql2);
					int row2 = query2.executeUpdate();
					Query query3 = session.createQuery(hql3);
					int row3 = query3.executeUpdate();
					// -------------------------------------------------------------------------------

					hbt.save(storeIssueT);
			
					StoreItemBatchStock storeItemBatchStock=new StoreItemBatchStock();
					storeItemBatchStock.setItem(item);
					MasDepartment masDepartment=new MasDepartment();
					masDepartment.setId(Integer.parseInt(""
						+ box.get(RequestConstants.DEPARTMENT_ID_TEMP)));
					storeItemBatchStock.setDepartment(masDepartment);
					storeItemBatchStock.setBatchNo(lotNo.get(i).toString());
					storeItemBatchStock.setOpeningBalanceAmount(qtyIssued);
					storeItemBatchStock.setClosingStock(qtyIssued);
					storeItemBatchStock.setReceivedQty(qtyIssued);
					storeItemBatchStock.setBrand(null);
					hbt.saveOrUpdate(storeItemBatchStock);
				
				
				}
				
				
				
				
			}

			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}
			if (pageNo == 1 && issueId == 0) {
				String qry = "SELECT id FROM store_issue_m where issue_no='"
						+ issueNo + "' and department_id='" + deptId + "';";
				objectList = (List) session.createSQLQuery(qry).list();
				issueId = Integer.parseInt("" + objectList.get(0));
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
						.load(StoreFyDocumentNo.class, storeFyId);
				storeFyDocumentNo.setIssueDeptNo(issueNo);
				hbt.update(storeFyDocumentNo);
				departmentList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDepartment");
				employeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee");
			}
			// searchListForPopup=(StoreIssueM)
			// getHibernateTemplate().find("from jkt.hms.masters.business.StoreIssueM as sim where sim.IssueType='i' and sim.Status='o' and sim.Department.Id='"+deptId+"' ");
			// ---------------------End of
			// Transaction----------------------------
			tx.commit();
			messageTOBeVisibleToTheUser = "Added Successfully";
			messageType = "success";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			messageTOBeVisibleToTheUser = "Not Added";
			messageType = "failure";
			e.printStackTrace();
		}
		map.put("messageType", messageType);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("issueId", issueId);
		map.put("searchListForPopup", searchListForPopup);
		return map;
	}
	
	
	
	// ----------------------------Start Of Department Issue
	// ----------------------
	public Map<String, Object> updateNextOrSubmitIssue(Map<String, Object> dataMap) {
		System.out
				.println("=================addNextOrSubmitIssue========================");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = null;
		box = (Box) dataMap.get("box");
		session = (Session) getSession();
		Transaction tx = null;
		StoreIssueM storeIssueM = new StoreIssueM();
		StoreIssueM searchListForPopup = new StoreIssueM();
		String date4MySQL = "";
		String messageType = "";
		String messageTOBeVisibleToTheUser = "";
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		int issueId = 0;
		int pageNo = 1;
		String issueNo = "";
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		if (dataMap.get("issueId") != null)
			issueId = Integer.parseInt("" + dataMap.get("issueId"));
		if (dataMap.get("pageNo") != null)
			pageNo = Integer.parseInt("" + dataMap.get("pageNo"));

		Vector itemIdList = box.getVector("itemId");
		Vector qtyIssuedList = box.getVector(RequestConstants.QTY_ISSUED);
		Vector qtyIssuedOldList = box.getVector("oldIssuedQty");
		Vector storeIssueTId = box.getVector("storeIssueTId");
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		int storeFyId = 0;
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List objectList = new ArrayList();

		try {
			// ---------------------Start of
			// Transaction----------------------------
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			storeIssueM= (StoreIssueM) getHibernateTemplate()
			.load(StoreIssueM.class, issueId);
				storeIssueM.setIssueType("i");
				storeIssueM.setIssueNo("" + box.get(RequestConstants.ISSUE_NO));
				issueNo = "" + box.get(RequestConstants.ISSUE_NO);
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String issueDate=box.get(RequestConstants.ISSUE_DATE);
				date4MySQL = formatterOut.format(formatterIn.parse(""
						+ box.get(RequestConstants.ISSUE_DATE)));
				java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL);
				storeIssueM.setIssueDate(startDate);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIssueM.setDepartment(masDepartment);
				storeIssueM.setStatus("o");
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeIssueM.setHospital(masHospital);

				MasDepartment masDepartment2 = new MasDepartment();
				masDepartment2.setId(Integer.parseInt(""
						+ box.get(RequestConstants.DEPARTMENT_ID_TEMP)));
				storeIssueM.setToStore(masDepartment2);
				storeIssueM.setDocNo("" + box.get(RequestConstants.DOC_NO));

				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(Integer.parseInt(""
						+ box.get(RequestConstants.ISSUED_BY)));
				storeIssueM.setIssuedBy(masEmployee);
				hbt.update(storeIssueM);
			
				
			

			for (int i = 0; i < itemIdList.size(); i++) {
				int item_id = Integer.parseInt(itemIdList.get(i).toString());
				if ((item_id != 0)
						&& (!(qtyIssuedList.get(i).toString()).equals(""))) {
					BigDecimal qtyIssued = new BigDecimal(qtyIssuedList.get(i)
							.toString());
					BigDecimal qtyIssuedOld = new BigDecimal(qtyIssuedOldList.get(i)
							.toString());
					storeIssueM= (StoreIssueM) getHibernateTemplate()
					.load(StoreIssueM.class, issueId);
					 StoreIssueT storeIssueT=new StoreIssueT();
					if(storeIssueTId.get(i)!="")
					{
					int storeIssueTId1= Integer.parseInt(storeIssueTId.get(i).toString());
					  storeIssueT= (StoreIssueT) getHibernateTemplate()
					.load(StoreIssueT.class, storeIssueTId1);
					}
					MasStoreItem item = new MasStoreItem();
					item.setId(item_id);
					storeIssueT.setItem(item);

					MasStoreItem item2 = new MasStoreItem();
					item2.setId(item_id);
					storeIssueT.setItemIssued(item2);
					storeIssueT.setIssued("y");
					storeIssueT.setIssueM(storeIssueM);
					storeIssueT.setQtyIssued(qtyIssued);

					// --------------------------Start of Stock
					// Updating--------------------------
					BigDecimal stock = null;
					BigDecimal issueQty = null;
					String qry = "select closing_stock,issue_qty from store_item_batch_stock where item_id="
							+ item_id;
					List c = (List) session.createSQLQuery(qry).list();

					for (Iterator iterator = c.iterator(); iterator.hasNext();) {
						Object[] object = (Object[]) iterator.next();
						if (object[0] == null) {
							stock = new BigDecimal("0");
						} else {
							stock = (BigDecimal) object[0];
						}
						if (object[1] == null) {
							issueQty = new BigDecimal("0");
						} else {
							issueQty = (BigDecimal) object[1];
						}
					}
					qtyIssued=qtyIssued.subtract(qtyIssuedOld);
					stock = stock.subtract(qtyIssued);
					issueQty = issueQty.add(qtyIssued);
					String hql2 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.ClosingStock='"
							+ stock + "'  where a.Item.Id='" + item_id + "'";
					String hql3 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.IssueQty='"
							+ issueQty + "'  where a.Item.Id='" + item_id + "'";
					Query query2 = session.createQuery(hql2);
					int row2 = query2.executeUpdate();
					Query query3 = session.createQuery(hql3);
					int row3 = query3.executeUpdate();
					// -------------------------------------------------------------------------------

					hbt.saveOrUpdate(storeIssueT);
				}
			}

			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}
			if (pageNo == 1 && issueId == 0) {
				String qry = "SELECT id FROM store_issue_m where issue_no='"
						+ issueNo + "' and department_id='" + deptId + "';";
				objectList = (List) session.createSQLQuery(qry).list();
				issueId = Integer.parseInt("" + objectList.get(0));
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
						.load(StoreFyDocumentNo.class, storeFyId);
				storeFyDocumentNo.setIssueDeptNo(issueNo);
				hbt.update(storeFyDocumentNo);
				departmentList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDepartment");
				employeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee");
			}
			// searchListForPopup=(StoreIssueM)
			// getHibernateTemplate().find("from jkt.hms.masters.business.StoreIssueM as sim where sim.IssueType='i' and sim.Status='o' and sim.Department.Id='"+deptId+"' ");
			// ---------------------End of
			// Transaction----------------------------
			tx.commit();
			messageTOBeVisibleToTheUser = "Update Successfully";
			messageType = "success";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			messageTOBeVisibleToTheUser = "Not Added";
			messageType = "failure";
			e.printStackTrace();
		}
		map.put("messageType", messageType);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("issueId", issueId);
		map.put("searchListForPopup", searchListForPopup);
		return map;
	}


	public Map<String, Object> getItemListForDepartmentIssueNE(
			Map<String, Object> dataMap) {

		//System.out.println("getItemListForIssueToDispensary i n ds");

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List objectList = new ArrayList();
		List<Object> stockIdList = new ArrayList<Object>();
		session = (Session) getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int issueId = 0;

		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		if (dataMap.get("issueId") != null)
			issueId = Integer.parseInt("" + dataMap.get("issueId"));
		try {
			String str = dataMap.get("autoHint") + "%";
			String qry1 = "SELECT item_id FROM store_issue_t where issue_m_id='"
					+ issueId + "' ";
			objectList = (List) session.createSQLQuery(qry1).list();

			String qry2 = "SELECT item_id FROM store_item_batch_stock where department_id='"
					+ deptId + "'";
			stockIdList = (List) session.createSQLQuery(qry2).list();

			if ((objectList.size() != 0) && (stockIdList.size() != 0)) {
				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.in("Id", stockIdList)).add(
						Restrictions.not(Restrictions.in("Id", objectList)));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			} else if (stockIdList.size() != 0) {
				Criteria c = session.createCriteria(StoreItemBatchStock.class)
				.createAlias("Item", "item")
				.add(Restrictions.like("item.Nomenclature", str))
				//.add(Restrictions.in("Id", stockIdList));
						.add(Restrictions.eq("Department.Id", deptId)).setProjection(
						Projections.distinct(Projections.projectionList().add(
								Projections.property("Item"))));
						;
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("itemList                                          "+ itemList.size());
		map.put("itemList", itemList);
		return map;

	}

	// ----------------------------End Of Department Issue
	// ---------------------------------

	// -------------------------Start of Disposal Entry <= Rs
	// 30------------------------------------------

	public Map<String, Object> showDisposalEntry(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		String max = "";
		// --------------------------------------------------------------------
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		// --------------------------------------------------------------------
		//System.out.println("deptId  " + deptId);
		//System.out.println("hospitalId " + hospitalId);
		session = (Session) getSession();
		try {
			Criteria c = session.createCriteria(StoreBosM.class).add(
					Restrictions.eq("Department.Id", deptId)).add(
					Restrictions.eq("Hospital.Id", hospitalId));
			storeBosMList = c.list();
			map.put("storeBosMList", storeBosMList);
			storeFyDocumentNoList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "' ");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getDisposalEntryNo() != null) {
					max = ("" + storeFyDocumentNo.getDisposalEntryNo());
				} else {
					max = "";
				}
			}
			max = getMaxNo(max);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("storeBosMList  " + storeBosMList.size());
		//System.out.println("max        " + max);
		map.put("max", max);
		return map;
	}

	public Map<String, Object> importFromBOS(Map<String, Object> dataMap) {
		//System.out.println("===============importFromBOS================");
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
		List<StoreBosT> storeBosTList = new ArrayList<StoreBosT>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<StoreDisposalT> storeDisposalTList = new ArrayList<StoreDisposalT>();
		String maxNo = "";
		session = (Session) getSession();
		// --------------------------------------------------------------------
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		// --------------------------------------------------------------------
		int bosId = 0;
		Box box = null;
		Transaction tx = null;
		String messageTOBeVisibleToTheUser = "";
		String messageType = "";
		String disposalNo = "";
		session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String max = "";
		String disposalStatus = "o";
		// ------------------For Pagination -------------------
		String pvms = null;
		String nomenclature = null;
		String au = null;
		BigDecimal qty = null;
		String remark = null;
		BigDecimal cost = null;
		int id = 0;
		String rvNo = "";
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		// ------------------------------------------------------

		try {
			tx = session.beginTransaction();

			if (dataMap.get("box") != null) {
				box = (Box) dataMap.get("box");
			}
			if (dataMap.get("bosId") != null) {
				bosId = Integer.parseInt("" + dataMap.get("bosId"));
			}
			if (box.get("disposalNo") != null) {
				disposalNo = ("" + box.get("disposalNo"));
			}

			List<StoreDisposalM> storeDisposalMListTemp = new ArrayList<StoreDisposalM>();
			Criteria criteria3 = session.createCriteria(StoreDisposalM.class)
					.add(Restrictions.eq("Bos.Id", bosId)).add(
							Restrictions.eq("Type", "l")).add(
							Restrictions.eq("Department.Id", deptId));
			storeDisposalMListTemp = criteria3.list();

			if (storeDisposalMListTemp.size() == 0) {
				Criteria criteria1 = session.createCriteria(StoreBosM.class)
						.add(Restrictions.eq("Id", bosId));
				storeBosMList = criteria1.list();
				Criteria criteria2 = session.createCriteria(StoreBosT.class)
						.add(Restrictions.eq("BosM.Id", bosId));
				storeBosTList = criteria2.list();

				StoreDisposalM storeDisposalM = new StoreDisposalM();
				for (StoreBosM storeBosM : storeBosMList) {

					storeDisposalM.setDisposalNo(disposalNo);
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String time = (String) utilMap.get("currentTime");
					String date = (String) utilMap.get("currentDate");
					SimpleDateFormat formatterIn = new SimpleDateFormat(
							"dd/MM/yyyy");
					SimpleDateFormat formatterOut = new SimpleDateFormat(
							"yyyy-MM-dd");
					String date4MySQL1 = formatterOut.format(formatterIn
							.parse(date));
					java.sql.Date startDate = java.sql.Date
							.valueOf(date4MySQL1);
					storeDisposalM.setDate(startDate);
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					storeDisposalM.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					storeDisposalM.setHospital(masHospital);

					StoreBosM storeBosM1 = new StoreBosM();
					storeBosM1.setId(bosId);
					storeDisposalM.setBos(storeBosM1);

					storeDisposalM.setType("l");
					storeDisposalM.setStatus("o");
					storeDisposalM.setLastChgBy(userName);
					storeDisposalM.setLastChgDate(startDate);
					storeDisposalM.setLastChgTime(time);
					hbt.save(storeDisposalM);
					hbt.refresh(storeDisposalM);
				}
				int serialNo = 1;
				for (StoreBosT storeBosT : storeBosTList) {
					BigDecimal costTemp = new BigDecimal(""
							+ storeBosT.getCostDetails());
					BigDecimal temp = new BigDecimal("30");
					int state = costTemp.compareTo(temp);
					if (state != 1) {
						StoreDisposalT storeDisposalT = new StoreDisposalT();
						storeDisposalT.setDisposalM(storeDisposalM);
						storeDisposalT
								.setSerialNo("" + storeBosT.getSerialNo());
						storeDisposalT.setSrNo(serialNo);

						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(storeBosT.getItem().getId());
						storeDisposalT.setItem(masStoreItem);
						storeDisposalT.setQty(new BigDecimal(""
								+ storeBosT.getQty()));
						storeDisposalT.setCost(new BigDecimal(""
								+ storeBosT.getCostDetails()));

						storeDisposalT.setRvNo("");
						storeDisposalT.setRemarks("");
						serialNo++;
						hbt.save(storeDisposalT);
						hbt.refresh(storeDisposalT);
					}
				}
				// --------------Updating StoreFyDocumenr-------------
				int storeFyId = 0;
				Criteria c = session.createCriteria(StoreFyDocumentNo.class)
						.add(Restrictions.eq("Department.Id", deptId));
				storeFyDocumentNoList = c.list();
				for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
					storeFyId = documentNo.getId();
				}
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
						.load(StoreFyDocumentNo.class, storeFyId);
				storeFyDocumentNo.setDisposalEntryNo(disposalNo);
				hbt.update(storeFyDocumentNo);
				// ----------------------------------------------------

				// --------------Updating the status of StoreBosM--------

				StoreBosM storeBosM = (StoreBosM) getHibernateTemplate().load(
						StoreBosM.class, bosId);
				storeBosM.setStatus("p");
				hbt.update(storeBosM);
				// ------------------------------------------------------

			} else {
				for (StoreDisposalM storeDisposalM : storeDisposalMListTemp) {
					disposalNo = "" + storeDisposalM.getDisposalNo();
					disposalStatus = "" + storeDisposalM.getStatus();
				}
			}
			Criteria c = session.createCriteria(StoreBosM.class).add(
					Restrictions.eq("Department.Id", deptId)).add(
					Restrictions.eq("Hospital.Id", hospitalId));
			storeBosMList = c.list();

			// ---------For Pagination ------------------

			storeDisposalTList = hbt
					.find("from jkt.hms.masters.business.StoreDisposalT as sdt where sdt.DisposalM.Bos.Id='"
							+ bosId
							+ "' and sdt.DisposalM.Department.Id='"
							+ deptId + "' and sdt.DisposalM.Type='l'");
			//System.out.println("storeDisposalTList    "+ storeDisposalTList.size());
			for (Iterator iterator = storeDisposalTList.iterator(); iterator
					.hasNext();) {
				StoreDisposalT disposalT = (StoreDisposalT) iterator.next();

				try {
					id = disposalT.getId();
				} catch (Exception e) {
					id = 0;
				}

				try {
					pvms = disposalT.getItem().getPvmsNo();
				} catch (Exception e) {
					pvms = "";
				}

				try {
					nomenclature = disposalT.getItem().getNomenclature();
				} catch (Exception e) {
					nomenclature = "";
				}

				try {
					au = disposalT.getItem().getItemConversion()
							.getItemUnitName();
				} catch (Exception e) {
					au = "";
				}

				try {
					qty = new BigDecimal("" + disposalT.getQty());
				} catch (Exception e) {
					qty = new BigDecimal("0");
				}
				try {
					cost = new BigDecimal("" + disposalT.getCost());
				} catch (Exception e) {
					cost = new BigDecimal("0");
				}
				try {
					rvNo = ("" + disposalT.getRvNo());

				} catch (Exception e) {
					rvNo = ("");
				}
				try {
					remark = "" + disposalT.getRemarks();
				} catch (Exception e) {
					remark = "";
				}

				hData = new HashMap<String, Object>();
				hData.put("id", id);
				hData.put("pvms", pvms);
				hData.put("nomenclature", nomenclature);
				hData.put("au", au);
				hData.put("qty", qty);
				hData.put("cost", cost);
				hData.put("rvNo", rvNo);
				hData.put("remark", remark);

				vResult.add(hData);
			}
			//System.out.println("vresult" + vResult);

			if (vResult.size() > 0) {
				testPageData = new HashMap[vResult.size()];
				vResult.copyInto(testPageData);
			}

			try {
				pagedArray = new PageUtil().convertToPagedArrayIndex(
						testPageData, box);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// ------------------------------------------

			// End of transaction
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			messageTOBeVisibleToTheUser = "Not Added";
			messageType = "failure";
			e.printStackTrace();
		}
		map.put("disposalStatus", disposalStatus);
		box.put("bosId", bosId);
		map.put("box", box);
		map.put("max", disposalNo);
		map.put("storeBosMList", storeBosMList);
		map.put("pagedArray", pagedArray);
		map.put("messageType", messageType);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return map;
	}

	public Map<String, Object> generateCiv(Map<String, Object> dataMap) {
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreDisposalM> storeDisposalMListTemp = new ArrayList<StoreDisposalM>();
		List<StoreDisposalT> storeDisposalTListTemp = new ArrayList<StoreDisposalT>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<StoreIssueM> storeIssueMListTemp = new ArrayList<StoreIssueM>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		String no = "";
		String messageTOBeVisibleToTheUser = "";
		String messageType = "";
		int disposalId = 0;
		int issueId = 0;
		// --------------------------------------------------------------------
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		// --------------------------------------------------------------------

		// ------------------For Pagination -------------------
		String pvms = null;
		String nomenclature = null;
		String au = null;
		BigDecimal qty = null;
		String remark = null;
		BigDecimal cost = null;
		int id = 0;
		String rvNo = "";
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		// ------------------------------------------------------
		String serialNo = "";
		BigDecimal stockIn = null;
		BigDecimal qtyIssued = null;
		int departmentIdTemp = 0;
		int issuedBy = 0;
		String docNo = "";

		session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Box box = null;
		int bosId = 0;
		String disposalNo = "";
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		if (dataMap.get("bosId") != null) {
			bosId = Integer.parseInt("" + dataMap.get("bosId"));
		}
		//System.out.println("bosId    asdsadasaddasd   " + bosId);
		if (box.get("disposalNo") != null) {
			disposalNo = ("" + box.get("disposalNo"));
		}

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Criteria criteria3 = session.createCriteria(StoreDisposalM.class)
					.add(Restrictions.eq("Bos.Id", bosId)).add(
							Restrictions.eq("Department.Id", deptId));
			storeDisposalMListTemp = (List<StoreDisposalM>) criteria3.list();
			for (StoreDisposalM storeDisposalM : storeDisposalMListTemp) {
				disposalId = storeDisposalM.getId();
				if (storeDisposalM.getIssue() != null) {
					issueId = storeDisposalM.getIssue().getId();
				} else {
					issueId = 0;
				}
			}
			Criteria criteria1 = session.createCriteria(StoreDisposalT.class)
					.add(Restrictions.eq("DisposalM.Id", disposalId));
			storeDisposalTListTemp = (List<StoreDisposalT>) criteria1.list();
			if (issueId == 0)
				if ((storeDisposalMListTemp.size() > 0)
						&& (storeDisposalTListTemp.size() > 0)) {

					// -----------------Getting IndentNo from
					// storeFyDocumentNo------------
					storeFyDocumentNoList = (List) getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
											+ deptId + "'");
					for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
						if (storeFyDocumentNo.getIssueDeptNo() != null) {
							no = ("" + storeFyDocumentNo.getIssueDeptNo());
							no = getMaxNo(no);
						} else {
							no = getMaxNo("");
						}
					}
					// --------------------------------------------------------------------
					Date currentDate = null;
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");
					SimpleDateFormat formatterIn = new SimpleDateFormat(
							"dd/MM/yyyy");
					SimpleDateFormat formatterOut = new SimpleDateFormat(
							"yyyy-MM-dd");
					String date4MySQL = "";
					try {
						date4MySQL = formatterOut.format(formatterIn.parse(""
								+ date));
					} catch (java.text.ParseException e) {
						e.printStackTrace();
					}
					currentDate = java.sql.Date.valueOf(date4MySQL);
					StoreIssueM storeIssueM = new StoreIssueM();
					for (StoreDisposalM storeDisposalM : storeDisposalMListTemp) {

						storeIssueM.setIssueNo(no);
						storeIssueM.setIssueType("i");
						storeIssueM.setStatus("o");
						storeIssueM.setIssueDate(currentDate);

						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(deptId);
						storeIssueM.setDepartment(masDepartment);

						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						storeIssueM.setHospital(masHospital);
						storeIssueM.setLastChgBy(userName);
						storeIssueM.setLastChgDate(currentDate);
						storeIssueM.setLastChgTime(time);

						hbt.save(storeIssueM);
						hbt.refresh(storeIssueM);
					}

					for (StoreDisposalT storeDisposalT : storeDisposalTListTemp) {

						StoreIssueT storeIssueT = new StoreIssueT();

						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(storeDisposalT.getItem().getId());
						storeIssueT.setItem(masStoreItem);
						storeIssueT.setItemIssued(masStoreItem);
						storeIssueT.setIssueM(storeIssueM);

						hbt.save(storeIssueT);
						hbt.refresh(storeIssueT);
					}

					// ------------------Getting issueId from
					// StoreIndentM-------------
					Criteria criteria4 = session.createCriteria(
							StoreIssueM.class).add(
							Restrictions.eq("IssueNo", no)).add(
							Restrictions.eq("Department.Id", deptId)).add(
							Restrictions.eq("IssueType", "i"));
					storeIssueMListTemp = (List<StoreIssueM>) criteria4.list();
					for (StoreIssueM storeIssueM2 : storeIssueMListTemp) {
						issueId = Integer.parseInt("" + storeIssueM2.getId());
					}
					// -----------------------------------------------------------------

					// ----------Update the issueId in DisposalM
					// table-----------------
					if (issueId != 0) {
						StoreDisposalM storeDisposalM = (StoreDisposalM) getHibernateTemplate()
								.load(StoreDisposalM.class, disposalId);
						StoreIssueM storeIssueM2 = new StoreIssueM();
						storeIssueM2.setId(issueId);
						storeDisposalM.setIssue(storeIssueM2);
						storeDisposalM.setStatus("p");
						hbt.update(storeDisposalM);
					}
					// ------------------------------------------------------------------

					// -------------Updating
					// StoreFyDocumentNo---------------------------
					int storeFyId = 0;
					Criteria c = session
							.createCriteria(StoreFyDocumentNo.class).add(
									Restrictions.eq("Department.Id", deptId));
					storeFyDocumentNoList = c.list();
					for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
						storeFyId = documentNo.getId();
					}

					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
							.load(StoreFyDocumentNo.class, storeFyId);
					storeFyDocumentNo.setIssueDeptNo(no);
					hbt.update(storeFyDocumentNo);

					// ------------------------------------------------------------------

					// ------------------------------------------------------------------

				} else {
					messageType = "failure";
					messageTOBeVisibleToTheUser = "No records found in Disposal Entry";
					map.put("messageType", messageType);
					map.put("messageTOBeVisibleToTheUser",
							messageTOBeVisibleToTheUser);
					return map;
				}
			// ------------------------------------------
			// ---------For Pagination ------------------

			List<StoreIssueM> issueMListForPagination = new ArrayList<StoreIssueM>();
			List<StoreIssueM> issueTListForPagination = new ArrayList<StoreIssueM>();
			issueMListForPagination = hbt
					.find("from jkt.hms.masters.business.StoreIssueM as sdt where sdt.Id='"
							+ issueId + "' ");
			for (StoreIssueM storeIssueM : issueMListForPagination) {
				no = "" + storeIssueM.getIssueNo();
				if (storeIssueM.getToUnit() != null)
					departmentIdTemp = Integer.parseInt(""
							+ storeIssueM.getToUnit().getId());
				if (storeIssueM.getIssuedBy() != null)
					issuedBy = Integer.parseInt(""
							+ storeIssueM.getIssuedBy().getId());
				if (storeIssueM.getDocNo() != null)
					docNo = storeIssueM.getDocNo();

			}
			issueTListForPagination = hbt
					.find("from jkt.hms.masters.business.StoreIssueT as sdt where sdt.IssueM.Id='"
							+ issueId + "' ");
			//System.out.println("issueTListForPaginatio    "+ issueTListForPagination.size());
			int issuedItemId = 0;
			for (Iterator iterator = issueTListForPagination.iterator(); iterator
					.hasNext();) {
				StoreIssueT storeIssueT = (StoreIssueT) iterator.next();
				Set<StoreItemBatchStock> set = new HashSet<StoreItemBatchStock>();
				set = storeIssueT.getItem().getStoreItemBatchStocks();
				try {
					id = storeIssueT.getId();
				} catch (Exception e) {
					id = 0;
				}

				try {
					pvms = storeIssueT.getItem().getPvmsNo();
				} catch (Exception e) {
					pvms = "";
				}
				try {
					issuedItemId = storeIssueT.getItem().getId();
				} catch (Exception e) {
					issuedItemId = 0;
				}

				try {
					nomenclature = storeIssueT.getItem().getNomenclature();
				} catch (Exception e) {
					nomenclature = "";
				}

				try {
					au = storeIssueT.getItem().getItemConversion()
							.getItemUnitName();
				} catch (Exception e) {
					au = "";
				}

				try {
					for (StoreItemBatchStock batchStock : set) {
						if ((batchStock.getItem().getId() == storeIssueT
								.getItem().getId())
								&& (batchStock.getBatchNo() != null))
							serialNo = "" + batchStock.getBatchNo();
					}
					//System.out.println("serialNo   " + serialNo);
				} catch (Exception e) {
					e.printStackTrace();
					serialNo = "";
				}
				try {
					for (StoreItemBatchStock batchStock : set) {
						if ((batchStock.getItem().getId() == storeIssueT
								.getItem().getId())
								&& (batchStock.getClosingStock() != null))
							stockIn = new BigDecimal(""
									+ batchStock.getClosingStock());
					}
					//System.out.println("stockIn  " + stockIn);

				} catch (Exception e) {
					e.printStackTrace();
					stockIn = new BigDecimal("0");
				}

				try {
					qtyIssued = new BigDecimal("" + storeIssueT.getQtyIssued());
				} catch (Exception e) {
					qtyIssued = new BigDecimal("0");
				}
				BigDecimal qtyIssuedTemp = null;
				try {
					qtyIssuedTemp = new BigDecimal(""
							+ storeIssueT.getQtyIssued());
				} catch (Exception e) {
					qtyIssuedTemp = new BigDecimal("0");
				}

				hData = new HashMap<String, Object>();
				hData.put("id", id);
				hData.put("pvms", pvms);
				hData.put("nomenclature", nomenclature);
				hData.put("au", au);
				hData.put("stockIn", stockIn);
				hData.put("serialNo", serialNo);
				hData.put("qtyIssued", qtyIssued);
				hData.put("issuedItemId", issuedItemId);
				hData.put("qtyIssuedTemp", qtyIssuedTemp);

				vResult.add(hData);
			}
			//System.out.println("vresult" + vResult);

			if (vResult.size() > 0) {
				testPageData = new HashMap[vResult.size()];
				vResult.copyInto(testPageData);
			}

			try {
				pagedArray = new PageUtil().convertToPagedArrayIndex(
						testPageData, box);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Criteria c2 = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y"));
			employeeList = c2.list();
			Criteria c3 = session.createCriteria(MasStoreAirForceDepot.class)
					.add(Restrictions.eq("Status", "y"));
			masStoreAirForceDepotList = c3.list();

			// ------------------------------------------
			// ----------------End of Transaction----------
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			messageTOBeVisibleToTheUser = "Not Added";
			messageType = "failure";
			e.printStackTrace();

		}
		// map=getIssueMapForDisposal(issueId, 1);
		map.put("pagedArray", pagedArray);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		box.put("issueNo", no);
		box.put("issueId", issueId);
		box.put("issuedBy", issuedBy);
		box.put("departmentIdTemp", departmentIdTemp);
		box.put("docNo", docNo);
		map.put("box", box);
		map.put("employeeList", employeeList);
		return map;
	}

	public Map getIssueMapForDisposal(int issueId, int pageNo) {
		Box box = new Box(null);
		Map map = new HashMap();
		List<StoreIssueM> gridIssueMList = new ArrayList<StoreIssueM>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreIssueT> gridIssueTList = new ArrayList<StoreIssueT>();
		List<MasStoreSection> gridSectionList = new ArrayList<MasStoreSection>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		int id = 0;
		int firstResult = 0;
		int maxResults = 8;

		if (pageNo != 1) {
			firstResult = firstResult + (pageNo - 1) * 8;
		}
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		session = (Session) getSession();
		List objectList = new ArrayList();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		session = (Session) getSession();
		Transaction tx = null;
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();
			Criteria c = session.createCriteria(StoreIssueT.class).add(
					Restrictions.eq("IssueM.Id", issueId));
			c.setFirstResult(firstResult);
			c.setMaxResults(maxResults);
			gridIssueTList = c.list();

			Criteria c2 = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y"));
			employeeList = c2.list();
			Criteria c3 = session.createCriteria(MasStoreAirForceDepot.class)
					.add(Restrictions.eq("Status", "y"));
			masStoreAirForceDepotList = c3.list();
			gridIssueMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIssueM as md where md.Id = '"
							+ issueId + "' and md.Status='o'");
			for (StoreIssueM storeIssueM : gridIssueMList) {
				box.put("issueId", storeIssueM.getId());
				box.put("issueNo", storeIssueM.getIssueNo());
				box
						.put("departmentIdTemp", storeIssueM.getDepartment()
								.getId());
				if (storeIssueM.getDocNo() != null)
					box.put("docNo", "" + storeIssueM.getDocNo());
				else
					box.put("docNo", "");
				if (storeIssueM.getIssuedBy() != null)
					box.put("issuedBy", storeIssueM.getIssuedBy().getId());
				else
					box.put("issuedBy", 0);

			}
			// --------------Transaction Ended----------
			tx.commit();

		} catch (Exception e) {
			// --------------In case of Transaction Failure----------
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();
		}

		map.put("gridIssueMList", gridIssueMList);
		map.put("gridIssueTList", gridIssueTList);
		map.put("indentId", issueId);
		map.put("masStoreSupplierList", masStoreSupplierList);
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("objectList", objectList);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("box", box);
		map.put("employeeList", employeeList);

		return map;
	}

	public Map<String, Object> generateIndent(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreDisposalM> storeDisposalMListTemp = new ArrayList<StoreDisposalM>();
		List<StoreDisposalT> storeDisposalTListTemp = new ArrayList<StoreDisposalT>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<StoreIndentM> storeIndentMListTemp = new ArrayList<StoreIndentM>();
		String no = "";
		String messageTOBeVisibleToTheUser = "";
		String messageType = "";
		int disposalId = 0;
		int indentId = 0;
		// --------------------------------------------------------------------
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		// --------------------------------------------------------------------

		session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Box box = null;
		int bosId = 0;
		String disposalNo = "";
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		if (dataMap.get("bosId") != null) {
			bosId = Integer.parseInt("" + dataMap.get("bosId"));
		}
		if (box.get("disposalNo") != null) {
			disposalNo = ("" + box.get("disposalNo"));
		}

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Criteria criteria3 = session.createCriteria(StoreDisposalM.class)
					.add(Restrictions.eq("Bos.Id", bosId)).add(
							Restrictions.eq("Department.Id", deptId));
			storeDisposalMListTemp = (List<StoreDisposalM>) criteria3.list();
			for (StoreDisposalM storeDisposalM : storeDisposalMListTemp) {
				disposalId = storeDisposalM.getId();
				if (storeDisposalM.getIndent() != null) {
					indentId = storeDisposalM.getIndent().getId();
				} else {
					indentId = 0;
				}
			}
			Criteria criteria1 = session.createCriteria(StoreDisposalT.class)
					.add(Restrictions.eq("DisposalM.Id", disposalId));
			storeDisposalTListTemp = (List<StoreDisposalT>) criteria1.list();
			if (indentId == 0)
				if ((storeDisposalMListTemp.size() > 0)
						&& (storeDisposalTListTemp.size() > 0)) {

					// -----------------Getting IndentNo from
					// storeFyDocumentNo------------
					storeFyDocumentNoList = (List) getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
											+ deptId + "'");
					for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
						if (storeFyDocumentNo.getIndentToDepotNo() != null) {
							no = ("" + storeFyDocumentNo.getIndentToDepotNo());
							no = getMaxNo(no);
						} else {
							no = getMaxNo("");
						}
					}
					// --------------------------------------------------------------------
					Date currentDate = null;
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					SimpleDateFormat formatterIn = new SimpleDateFormat(
							"dd/MM/yyyy");
					SimpleDateFormat formatterOut = new SimpleDateFormat(
							"yyyy-MM-dd");
					String date4MySQL = "";
					try {
						date4MySQL = formatterOut.format(formatterIn.parse(""
								+ date));
					} catch (java.text.ParseException e) {
						e.printStackTrace();
					}
					currentDate = java.sql.Date.valueOf(date4MySQL);
					StoreIndentM storeIndentM = new StoreIndentM();
					for (StoreDisposalM storeDisposalM : storeDisposalMListTemp) {

						storeIndentM.setIndentNo(no);
						storeIndentM.setIndentType("d");
						storeIndentM.setStatus("o");
						storeIndentM.setNrs("Bangalore");
						storeIndentM.setAuthority("37/36A && 37/37");

						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(deptId);
						storeIndentM.setDepartment(masDepartment);

						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						storeIndentM.setHospital(masHospital);
						storeIndentM.setIndentDate(currentDate);
						storeIndentM.setImported("y");
						hbt.save(storeIndentM);
						hbt.refresh(storeIndentM);
					}

					for (StoreDisposalT storeDisposalT : storeDisposalTListTemp) {

						StoreIndentT storeIndentT = new StoreIndentT();
						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(storeDisposalT.getItem().getId());
						storeIndentT.setItem(masStoreItem);

						try {
							// ------Setting Qty Auth-----------
							BigDecimal qtyAuth = null;
							List objectList = new ArrayList();
							String qry = "SELECT qty FROM store_me_scale_details where item_id='"
									+ storeDisposalT.getItem().getId()
									+ "' and department_id='"
									+ deptId
									+ "' and hospital_id='" + hospitalId + "';";
							objectList = (List) session.createSQLQuery(qry)
									.list();
							if (objectList.size() > 0)
								if (objectList.get(0) != null) {
									qtyAuth = new BigDecimal(""
											+ objectList.get(0));
									storeIndentT.setQtyInMmf(qtyAuth);
								} else {
									storeIndentT
											.setQtyInMmf(new BigDecimal("0"));
								}
							// -----Setting Stock--------
							BigDecimal stockIn = null;
							List objectList1 = new ArrayList();
							String qry1 = "SELECT closing_stock FROM store_item_batch_stock where department_id='"
									+ deptId
									+ "' and item_id='"
									+ storeDisposalT.getItem().getId() + "';";
							storeIndentT.setIndent(storeIndentM);
							objectList1 = (List) session.createSQLQuery(qry1)
									.list();
							if (objectList1.size() > 0)
								if (objectList1.get(0) != null) {
									stockIn = new BigDecimal(""
											+ objectList1.get(0));
									storeIndentT.setStockIn(stockIn);
								} else {
									storeIndentT
											.setStockIn(new BigDecimal("0"));
								}
						} catch (Exception e) {
							e.printStackTrace();
						}
						storeIndentT.setTotalCost(new BigDecimal(""
								+ storeDisposalT.getCost()));
						storeIndentT.setQtyInDemand(new BigDecimal(""
								+ storeDisposalT.getQty()));
						storeIndentT.setRemarks(storeDisposalT.getRemarks());

						hbt.save(storeIndentT);
						hbt.refresh(storeIndentT);
					}

					// ------------------Getting indentId from
					// StoreIndentM-------------
					Criteria criteria4 = session.createCriteria(
							StoreIndentM.class).add(
							Restrictions.eq("IndentNo", no)).add(
							Restrictions.eq("Department.Id", deptId)).add(
							Restrictions.eq("IndentType", "d"));
					storeIndentMListTemp = (List<StoreIndentM>) criteria4
							.list();
					for (StoreIndentM storeIndentM2 : storeIndentMListTemp) {
						indentId = Integer.parseInt("" + storeIndentM2.getId());
					}
					// -----------------------------------------------------------------
					// ----------Update the indentId in DisposalM
					// table-----------------
					if (indentId != 0) {
						StoreDisposalM storeDisposalM = (StoreDisposalM) getHibernateTemplate()
								.load(StoreDisposalM.class, disposalId);
						StoreIndentM storeIndentM2 = new StoreIndentM();
						storeIndentM2.setId(indentId);
						storeDisposalM.setIndent(storeIndentM2);
						hbt.update(storeDisposalM);
					}
					// ------------------------------------------------------------------
					// -------------Updating
					// StoreFyDocumentNo---------------------------
					// -------------Updating
					// StoreFyDocumentNo---------------------------
					int storeFyId = 0;
					Criteria c = session
							.createCriteria(StoreFyDocumentNo.class).add(
									Restrictions.eq("Department.Id", deptId));
					storeFyDocumentNoList = c.list();
					for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
						storeFyId = documentNo.getId();
					}

					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
							.load(StoreFyDocumentNo.class, storeFyId);
					storeFyDocumentNo.setIndentToDepotNo(no);
					hbt.update(storeFyDocumentNo);

					// ------------------------------------------------------------------

					// ------------------------------------------------------------------

				} else {
					messageType = "failure";
					messageTOBeVisibleToTheUser = "No records found in Disposal Entry";
					map.put("messageType", messageType);
					map.put("messageTOBeVisibleToTheUser",
							messageTOBeVisibleToTheUser);
					return map;
				}
			// ----------------End of Transaction----------
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			messageTOBeVisibleToTheUser = "Not Added";
			messageType = "failure";
			e.printStackTrace();

		}
		map = getIndentMapForDisposal(indentId, 1);
		return map;
	}

	public Map<String, Object> updateDisposalEntry(Box box) {
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String max = "";
		int bosId = 0;
		if (box.get("deptId") != null)
			deptId = Integer.parseInt("" + box.get("deptId"));
		if (box.get("bosId") != null)
			bosId = Integer.parseInt("" + box.get("bosId"));
		if (box.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		if (box.get("userName") != null)
			userName = ("" + box.get("userName"));
		if (box.get(DISPOSAL_NO) != null)
			max = ("" + box.get(DISPOSAL_NO));

		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreMmfDepartmentT> storeMmfDepartmentTList = new ArrayList<StoreMmfDepartmentT>();
		StoreMmfDepartmentT storeMmfDepartmentT = null;
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			//System.out.println("box    " + box);
			hbt.setCheckWriteOperations(false);
			Vector srno = box.getVector("srno");
			Vector qty = box.getVector("qty");
			Vector items = box.getVector("id");
			Vector cost = box.getVector("cost");
			Vector remark = box.getVector("remark");
			Vector rvNo = box.getVector("rvNo");
			String obj = null;
			for (int i = 0; i < srno.size(); i++) {
				int itemId = Integer.parseInt(items.get(i).toString());
				StoreDisposalT tObj = (StoreDisposalT) hbt.load(
						StoreDisposalT.class, itemId);

				tObj.setQty(new BigDecimal(qty.get(i).toString()));
				tObj.setCost(new BigDecimal(cost.get(i).toString()));
				tObj.setRemarks(remark.get(i).toString());
				//System.out.println("rvNo.get(i).toString()  "	+ rvNo.get(i).toString());
				tObj.setRvNo(rvNo.get(i).toString());

				hbt.update(tObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		box.put(DISPOSAL_NO, max);
		dataMap.put("box", box);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("bosId", bosId);
		dataMap.put(DISPOSAL_NO, max);

		map = importFromBOS(dataMap);
		return map;
	}

	public Map getIndentMapForDisposal(int indentId, int pageNo) {

		Map map = new HashMap();
		List<StoreIndentM> gridIndentMList = new ArrayList<StoreIndentM>();
		List<StoreIndentT> gridIndentTList = new ArrayList<StoreIndentT>();
		List<MasStoreSection> gridSectionList = new ArrayList<MasStoreSection>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		int id = 0;
		int firstResult = 0;
		int maxResults = 8;

		if (pageNo != 1) {
			firstResult = firstResult + (pageNo - 1) * 8;
		}
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		session = (Session) getSession();
		List objectList = new ArrayList();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		session = (Session) getSession();
		Transaction tx = null;
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();
			Criteria c = session.createCriteria(StoreIndentT.class).add(
					Restrictions.eq("Indent.Id", indentId));
			c.setFirstResult(firstResult);
			c.setMaxResults(maxResults);
			gridIndentTList = c.list();
			//System.out.println("gridIndentTList  " + gridIndentTList.size());
			gridIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIndentM as md where md.Id = '"
							+ indentId + "' and md.Status='o'");
			String qry = "select mas.item_id,mas.pvms_no,mas.nomenclature,mas.strength,b.stock,c.qty_in_mmf,mas.old_niv_no,mas.department_id,con.item_unit_name from mas_store_item mas inner join mas_store_item_conversion con on mas.item_conversion_id= con.item_conversion_id left outer join (select ba.item_id,sum(ba.closing_stock) stock from store_item_batch_stock ba where department_id=1 group by ba.item_id)b on mas.item_id=b.item_id left outer join (select it.qty_in_mmf, it.item_id from  store_indent_m im inner join store_indent_t it on im.indent_id=it.indent_id where im.mmf_for_the_year='"
					+ year + "' )c on mas.item_id=c.item_id;";
			objectList = (List) session.createSQLQuery(qry).list();
			masStoreSupplierList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplier as md where md.Status = 'y'");
			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'y'");
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection ");
			masStoreAirForceDepotList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as md where md.Status = 'y'");

			// --------------Transaction Ended----------
			tx.commit();

		} catch (Exception e) {
			// --------------In case of Transaction Failure----------
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("---------HMS TRANSACTION ERROR----------");
			//System.out.println("****************************************");
			e.printStackTrace();

		}
		//System.out.println("gridIndentMList  " + gridIndentMList.size());
		//System.out.println("gridIndentTList  " + gridIndentTList.size());
		map.put("gridIndentMList", gridIndentMList);
		map.put("gridIndentTList", gridIndentTList);
		map.put("indentId", indentId);
		map.put("masStoreSupplierList", masStoreSupplierList);
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("objectList", objectList);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);

		return map;
	}

	public Map<String, Object> saveHeaderForIndent(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int indentId = 0;
		try {
			if (box.get("indentId") != null) {
				indentId = Integer.parseInt("" + box.get("indentId"));
			}
			StoreIndentM storeIndentM = (StoreIndentM) getHibernateTemplate()
					.load(StoreIndentM.class, indentId);
			MasStoreAirForceDepot airForceDepot = new MasStoreAirForceDepot();
			airForceDepot.setId(Integer.parseInt("" + box.get(SUPPLY_DEPOT)));
			storeIndentM.setSuppliedBy(airForceDepot);
			storeIndentM.setPatientDetails("" + box.get(ADDRESS));
			storeIndentM.setIndentOption("" + box.get(TYPE_OF_INDENT));
			storeIndentM.setNrs("" + box.get(NRS));
			storeIndentM.setAuthority("" + box.get(AUTHORITY));
			hbt.update(storeIndentM);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getDisposalData(Map dataMap) {
		//System.out.println("===============importFromBOS================");
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
		List<StoreBosT> storeBosTList = new ArrayList<StoreBosT>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<StoreDisposalT> storeDisposalTList = new ArrayList<StoreDisposalT>();
		String maxNo = "";
		session = (Session) getSession();
		// --------------------------------------------------------------------
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		// --------------------------------------------------------------------
		int bosId = 0;
		Box box = null;
		Transaction tx = null;
		String messageTOBeVisibleToTheUser = "";
		String messageType = "";
		String disposalNo = "";
		session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String max = "";
		// ------------------For Pagination -------------------
		String pvms = null;
		String nomenclature = null;
		String au = null;
		BigDecimal qty = null;
		String remark = null;
		BigDecimal cost = null;
		int id = 0;
		String rvNo = "";
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		// ------------------------------------------------------

		try {
			tx = session.beginTransaction();

			if (dataMap.get("box") != null) {
				box = (Box) dataMap.get("box");
			}
			if (dataMap.get("bosId") != null) {
				bosId = Integer.parseInt("" + dataMap.get("bosId"));
			}
			if (box.get("disposalNo") != null) {
				disposalNo = ("" + box.get("disposalNo"));
			}
			Criteria c = session.createCriteria(StoreBosM.class).add(
					Restrictions.eq("Department.Id", deptId)).add(
					Restrictions.eq("Hospital.Id", hospitalId));
			storeBosMList = c.list();
			// ---------For Pagination ------------------

			storeDisposalTList = hbt
					.find("from jkt.hms.masters.business.StoreDisposalT as sdt where sdt.DisposalM.Bos.Id='"
							+ bosId
							+ "' and sdt.DisposalM.Department.Id='"
							+ deptId + "'");
			//System.out.println("storeDisposalTList    "+ storeDisposalTList.size());
			for (Iterator iterator = storeDisposalTList.iterator(); iterator
					.hasNext();) {
				StoreDisposalT disposalT = (StoreDisposalT) iterator.next();

				try {
					id = disposalT.getId();
				} catch (Exception e) {
					id = 0;
				}

				try {
					pvms = disposalT.getItem().getPvmsNo();
				} catch (Exception e) {
					pvms = "";
				}

				try {
					nomenclature = disposalT.getItem().getNomenclature();
				} catch (Exception e) {
					nomenclature = "";
				}

				try {
					au = disposalT.getItem().getItemConversion()
							.getItemUnitName();
				} catch (Exception e) {
					au = "";
				}

				try {
					qty = new BigDecimal("" + disposalT.getQty());
				} catch (Exception e) {
					qty = new BigDecimal("0");
				}
				try {
					cost = new BigDecimal("" + disposalT.getCost());
				} catch (Exception e) {
					cost = new BigDecimal("0");
				}
				try {
					rvNo = ("" + disposalT.getRvNo());

				} catch (Exception e) {
					rvNo = ("");
				}
				try {
					remark = "" + disposalT.getRemarks();
				} catch (Exception e) {
					remark = "";
				}

				hData = new HashMap<String, Object>();
				hData.put("id", id);
				hData.put("pvms", pvms);
				hData.put("nomenclature", nomenclature);
				hData.put("au", au);
				hData.put("qty", qty);
				hData.put("cost", cost);
				hData.put("rvNo", rvNo);
				hData.put("remark", remark);

				vResult.add(hData);
			}
			//System.out.println("vresult" + vResult);

			if (vResult.size() > 0) {
				testPageData = new HashMap[vResult.size()];
				vResult.copyInto(testPageData);
			}

			try {
				pagedArray = new PageUtil().convertToPagedArrayIndex(
						testPageData, box);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// ------------------------------------------

			// End of transaction
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			messageTOBeVisibleToTheUser = "Not Added";
			messageType = "failure";
			e.printStackTrace();
		}
		//System.out.println("disposalNo    " + disposalNo);
		box.put("bosId", bosId);
		map.put("box", box);
		map.put("max", disposalNo);
		map.put("storeBosMList", storeBosMList);
		map.put("pagedArray", pagedArray);
		map.put("messageType", messageType);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return map;
	}

	public Map<String, Object> getIssueDisposalData(Map<String, Object> dataMap) {

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreDisposalM> storeDisposalMListTemp = new ArrayList<StoreDisposalM>();
		List<StoreDisposalT> storeDisposalTListTemp = new ArrayList<StoreDisposalT>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<StoreIssueM> storeIssueMListTemp = new ArrayList<StoreIssueM>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		String no = "";
		String messageTOBeVisibleToTheUser = "";
		String messageType = "";
		int disposalId = 0;
		int issueId = 0;
		// --------------------------------------------------------------------
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		// --------------------------------------------------------------------

		// ------------------For Pagination -------------------
		String pvms = null;
		String nomenclature = null;
		String au = null;
		BigDecimal qty = null;
		String remark = null;
		BigDecimal cost = null;
		int id = 0;
		String rvNo = "";
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		// ------------------------------------------------------

		String serialNo = "";
		BigDecimal stockIn = null;
		BigDecimal qtyIssued = null;
		int departmentIdTemp = 0;
		int issuedBy = 0;
		String docNo = "";

		session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Box box = null;
		int bosId = 0;
		String disposalNo = "";
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		if (dataMap.get("bosId") != null) {
			bosId = Integer.parseInt("" + dataMap.get("bosId"));
		}
		if (box.get("disposalNo") != null) {
			disposalNo = ("" + box.get("disposalNo"));
		}

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Criteria criteria3 = session.createCriteria(StoreDisposalM.class)
					.add(Restrictions.eq("Department.Id", deptId));
			storeDisposalMListTemp = (List<StoreDisposalM>) criteria3.list();
			for (StoreDisposalM storeDisposalM : storeDisposalMListTemp) {
				disposalId = storeDisposalM.getId();
				if (storeDisposalM.getIssue() != null) {
					issueId = storeDisposalM.getIssue().getId();
				} else {
					issueId = 0;
				}
			}
			// ---------For Pagination ------------------

			// ---------For Pagination ------------------

			List<StoreIssueM> issueMListForPagination = new ArrayList<StoreIssueM>();
			List<StoreIssueM> issueTListForPagination = new ArrayList<StoreIssueM>();
			issueMListForPagination = hbt
					.find("from jkt.hms.masters.business.StoreIssueM as sdt where sdt.Id='"
							+ issueId + "' ");
			for (StoreIssueM storeIssueM : issueMListForPagination) {
				no = "" + storeIssueM.getIssueNo();
				if (storeIssueM.getToUnit() != null)
					departmentIdTemp = Integer.parseInt(""
							+ storeIssueM.getToUnit().getId());
				if (storeIssueM.getIssuedBy() != null)
					issuedBy = Integer.parseInt(""
							+ storeIssueM.getIssuedBy().getId());
				if (storeIssueM.getDocNo() != null)
					docNo = storeIssueM.getDocNo();

			}
			issueTListForPagination = hbt
					.find("from jkt.hms.masters.business.StoreIssueT as sdt where sdt.IssueM.Id='"
							+ issueId + "' ");
			//System.out.println("issueTListForPaginatio    "+ issueTListForPagination.size());
			int issuedItemId = 0;
			for (Iterator iterator = issueTListForPagination.iterator(); iterator
					.hasNext();) {
				StoreIssueT storeIssueT = (StoreIssueT) iterator.next();
				Set<StoreItemBatchStock> set = new HashSet<StoreItemBatchStock>();
				set = storeIssueT.getItem().getStoreItemBatchStocks();
				try {
					id = storeIssueT.getId();
				} catch (Exception e) {
					id = 0;
				}

				try {
					pvms = storeIssueT.getItem().getPvmsNo();
				} catch (Exception e) {
					pvms = "";
				}
				try {
					issuedItemId = storeIssueT.getItem().getId();
				} catch (Exception e) {
					issuedItemId = 0;
				}

				try {
					nomenclature = storeIssueT.getItem().getNomenclature();
				} catch (Exception e) {
					nomenclature = "";
				}

				try {
					au = storeIssueT.getItem().getItemConversion()
							.getItemUnitName();
				} catch (Exception e) {
					au = "";
				}

				try {
					for (StoreItemBatchStock batchStock : set) {
						if ((batchStock.getItem().getId() == storeIssueT
								.getItem().getId())
								&& (batchStock.getBatchNo() != null))
							serialNo = "" + batchStock.getBatchNo();
					}
					//System.out.println("serialNo   " + serialNo);
				} catch (Exception e) {
					e.printStackTrace();
					serialNo = "";
				}
				try {
					for (StoreItemBatchStock batchStock : set) {
						if ((batchStock.getItem().getId() == storeIssueT
								.getItem().getId())
								&& (batchStock.getClosingStock() != null))
							stockIn = new BigDecimal(""
									+ batchStock.getClosingStock());
					}
					//System.out.println("stockIn  " + stockIn);

				} catch (Exception e) {
					e.printStackTrace();
					stockIn = new BigDecimal("0");
				}

				try {
					qtyIssued = new BigDecimal("" + storeIssueT.getQtyIssued());
				} catch (Exception e) {
					qtyIssued = new BigDecimal("0");
				}
				BigDecimal qtyIssuedTemp = null;
				try {
					qtyIssuedTemp = new BigDecimal(""
							+ storeIssueT.getQtyIssued());
				} catch (Exception e) {
					qtyIssuedTemp = new BigDecimal("0");
				}

				hData = new HashMap<String, Object>();
				hData.put("id", id);
				hData.put("pvms", pvms);
				hData.put("nomenclature", nomenclature);
				hData.put("au", au);
				hData.put("stockIn", stockIn);
				hData.put("serialNo", serialNo);
				hData.put("qtyIssued", qtyIssued);
				hData.put("issuedItemId", issuedItemId);
				hData.put("qtyIssuedTemp", qtyIssuedTemp);

				vResult.add(hData);
			}
			//System.out.println("vresult" + vResult);

			if (vResult.size() > 0) {
				testPageData = new HashMap[vResult.size()];
				vResult.copyInto(testPageData);
			}

			try {
				pagedArray = new PageUtil().convertToPagedArrayIndex(
						testPageData, box);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Criteria c2 = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y"));
			employeeList = c2.list();
			Criteria c3 = session.createCriteria(MasStoreAirForceDepot.class)
					.add(Restrictions.eq("Status", "y"));
			masStoreAirForceDepotList = c3.list();

			// ------------------------------------------
			// ----------------End of Transaction----------
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			messageTOBeVisibleToTheUser = "Not Added";
			messageType = "failure";
			e.printStackTrace();

		}
		map.put("pagedArray", pagedArray);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("box", box);
		map.put("employeeList", employeeList);
		return map;

	}

	public Map<String, Object> updateIssueForDisposalEntry(Box box) {
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String max = "";
		int bosId = 0;
		if (box.get("deptId") != null)
			deptId = Integer.parseInt("" + box.get("deptId"));
		if (box.get("bosId") != null)
			bosId = Integer.parseInt("" + box.get("bosId"));
		if (box.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		if (box.get("userName") != null)
			userName = ("" + box.get("userName"));
		if (box.get(DISPOSAL_NO) != null)
			max = ("" + box.get(DISPOSAL_NO));
		session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreMmfDepartmentT> storeMmfDepartmentTList = new ArrayList<StoreMmfDepartmentT>();
		StoreMmfDepartmentT storeMmfDepartmentT = null;
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			//System.out.println("box    " + box);
			hbt.setCheckWriteOperations(false);
			Vector qty = box.getVector("qtyIssued");
			Vector items = box.getVector("id");
			Vector issuedItemId = box.getVector("issuedItemId");
			Vector qtyIssuedTemp = box.getVector("qtyIssuedTemp");

			int issueId = box.getInt(ISSUE_ID);
			StoreIssueM storeIssueM = (StoreIssueM) getHibernateTemplate()
					.load(StoreIssueM.class, issueId);

			MasEmployee employee = new MasEmployee();
			employee.setId(Integer.parseInt("" + box.get(ISSUED_BY)));
			storeIssueM.setIssuedBy(employee);

			storeIssueM.setDocNo("" + box.get(DOC_NO));
			MasStoreAirForceDepot airForceDepot = new MasStoreAirForceDepot();
			airForceDepot.setId(Integer.parseInt(""
					+ box.get(DEPARTMENT_ID_TEMP)));
			storeIssueM.setToUnit(airForceDepot);
			hbt.update(storeIssueM);
			hbt.refresh(storeIssueM);
			for (int i = 0; i < items.size(); i++) {
				// --------------------------Start of Stock
				// Updating--------------------------
				BigDecimal stock = null;
				BigDecimal issueQty = null;
				//System.out.println("issuedItemId.get(i)  "+ issuedItemId.get(i));
				String qry = "select closing_stock,issue_qty from store_item_batch_stock where item_id="
						+ issuedItemId.get(i);
				List c = (List) session.createSQLQuery(qry).list();

				for (Iterator iterator = c.iterator(); iterator.hasNext();) {
					Object[] object = (Object[]) iterator.next();
					if (object[0] == null) {
						stock = new BigDecimal("0");
					} else {
						stock = (BigDecimal) object[0];
					}
					if (object[1] == null) {
						issueQty = new BigDecimal("0");
					} else {
						issueQty = (BigDecimal) object[1];
					}
				}
				BigDecimal qtyTemp = new BigDecimal("" + qtyIssuedTemp.get(i));
				qtyTemp = (qtyTemp.subtract(new BigDecimal("" + qty.get(i))));

				//System.out.println("qtyTemp         " + qtyTemp);
				String hql2 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.ClosingStock='"
						+ stock.add(qtyTemp)
						+ "'  where a.Item.Id='"
						+ issuedItemId.get(i) + "'";
				String hql3 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.IssueQty='"
						+ issueQty.subtract(qtyTemp)
						+ "'  where a.Item.Id='"
						+ issuedItemId.get(i) + "'";
				Query query2 = session.createQuery(hql2);
				int row2 = query2.executeUpdate();
				Query query3 = session.createQuery(hql3);
				int row3 = query3.executeUpdate();
				// -------------------------------------------------------------------------------
				int itemId = Integer.parseInt(items.get(i).toString());
				StoreIssueT storeIssueT = (StoreIssueT) hbt.load(
						StoreIssueT.class, itemId);
				storeIssueT.setQtyIssued(new BigDecimal("" + qty.get(i)));
				hbt.update(storeIssueT);
				hbt.refresh(storeIssueT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		box.put(DISPOSAL_NO, max);
		dataMap.put("box", box);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("bosId", bosId);
		dataMap.put(DISPOSAL_NO, max);

		map = generateCiv(dataMap);
		return map;
	}

	public Map<String, Object> importFromBOS2(Map<String, Object> dataMap) {

		//System.out.println("===============importFromBOS2================");
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
		List<StoreBosT> storeBosTList = new ArrayList<StoreBosT>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<StoreDisposalT> storeDisposalTList = new ArrayList<StoreDisposalT>();
		String maxNo = "";
		session = (Session) getSession();
		String disposalStatus = "o";
		// --------------------------------------------------------------------
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		// --------------------------------------------------------------------
		int bosId = 0;
		Box box = null;
		Transaction tx = null;
		String messageTOBeVisibleToTheUser = "";
		String messageType = "";
		String disposalNo = "";
		session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String max = "";
		// ------------------For Pagination -------------------
		String pvms = null;
		String nomenclature = null;
		String au = null;
		BigDecimal qty = null;
		String remark = null;
		BigDecimal cost = null;
		int id = 0;
		String rvNo = "";
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		// ------------------------------------------------------

		try {
			tx = session.beginTransaction();

			if (dataMap.get("box") != null) {
				box = (Box) dataMap.get("box");
			}
			if (dataMap.get("bosId") != null) {
				bosId = Integer.parseInt("" + dataMap.get("bosId"));
			}
			if (box.get("disposalNo") != null) {
				disposalNo = ("" + box.get("disposalNo"));
			}

			List<StoreDisposalM> storeDisposalMListTemp = new ArrayList<StoreDisposalM>();
			Criteria criteria3 = session.createCriteria(StoreDisposalM.class)
					.add(Restrictions.eq("Bos.Id", bosId)).add(
							Restrictions.eq("Type", "g")).add(
							Restrictions.eq("Department.Id", deptId));
			storeDisposalMListTemp = criteria3.list();
			//System.out.println("storeDisposalMListTemp --   "+ storeDisposalMListTemp.size());
			if (storeDisposalMListTemp.size() == 0) {
				Criteria criteria1 = session.createCriteria(StoreBosM.class)
						.add(Restrictions.eq("Id", bosId));
				storeBosMList = criteria1.list();

				Criteria criteria2 = session.createCriteria(StoreBosT.class)
						.add(Restrictions.eq("BosM.Id", bosId));
				storeBosTList = criteria2.list();
				//System.out.println("storeBosMList    " + storeBosMList.size());
				//System.out.println("storeBosTList  " + storeBosTList.size());
				StoreDisposalM storeDisposalM = new StoreDisposalM();
				for (StoreBosM storeBosM : storeBosMList) {

					storeDisposalM.setDisposalNo(disposalNo);
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String time = (String) utilMap.get("currentTime");
					String date = (String) utilMap.get("currentDate");
					SimpleDateFormat formatterIn = new SimpleDateFormat(
							"dd/MM/yyyy");
					SimpleDateFormat formatterOut = new SimpleDateFormat(
							"yyyy-MM-dd");
					String date4MySQL1 = formatterOut.format(formatterIn
							.parse(date));
					java.sql.Date startDate = java.sql.Date
							.valueOf(date4MySQL1);
					storeDisposalM.setDate(startDate);
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					storeDisposalM.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					storeDisposalM.setHospital(masHospital);

					StoreBosM storeBosM1 = new StoreBosM();
					storeBosM1.setId(bosId);
					storeDisposalM.setBos(storeBosM1);

					storeDisposalM.setType("g");
					storeDisposalM.setStatus("o");
					storeDisposalM.setLastChgBy(userName);
					storeDisposalM.setLastChgDate(startDate);
					storeDisposalM.setLastChgTime(time);
					hbt.save(storeDisposalM);
					hbt.refresh(storeDisposalM);
				}
				int serialNo = 1;
				for (StoreBosT storeBosT : storeBosTList) {
					BigDecimal costTemp = new BigDecimal(""
							+ storeBosT.getCostDetails());
					BigDecimal temp = new BigDecimal("30");
					int state = costTemp.compareTo(temp);
					if (state == 1) {
						StoreDisposalT storeDisposalT = new StoreDisposalT();
						storeDisposalT.setDisposalM(storeDisposalM);
						storeDisposalT
								.setSerialNo("" + storeBosT.getSerialNo());
						storeDisposalT.setSrNo(serialNo);

						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(storeBosT.getItem().getId());
						storeDisposalT.setItem(masStoreItem);
						storeDisposalT.setQty(new BigDecimal(""
								+ storeBosT.getQty()));
						storeDisposalT.setCost(new BigDecimal(""
								+ storeBosT.getCostDetails()));

						storeDisposalT.setRvNo("");
						storeDisposalT.setRemarks("");
						serialNo++;
						hbt.save(storeDisposalT);
						hbt.refresh(storeDisposalT);
					}
				}
				// --------------Updating StoreFyDocumenr-------------
				int storeFyId = 0;
				Criteria c = session.createCriteria(StoreFyDocumentNo.class)
						.add(Restrictions.eq("Department.Id", deptId));
				storeFyDocumentNoList = c.list();
				for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
					storeFyId = documentNo.getId();
				}
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
						.load(StoreFyDocumentNo.class, storeFyId);
				storeFyDocumentNo.setDisposalEntryNo(disposalNo);
				hbt.update(storeFyDocumentNo);
				// ----------------------------------------------------

				// --------------Updating the status of StoreBosM--------

				StoreBosM storeBosM = (StoreBosM) getHibernateTemplate().load(
						StoreBosM.class, bosId);
				storeBosM.setStatus("p");
				hbt.update(storeBosM);
				// ------------------------------------------------------

			} else {
				for (StoreDisposalM storeDisposalM : storeDisposalMListTemp) {
					disposalNo = "" + storeDisposalM.getDisposalNo();
					disposalStatus = "" + storeDisposalM.getStatus();
				}
			}
			Criteria c = session.createCriteria(StoreBosM.class).add(
					Restrictions.eq("Department.Id", deptId)).add(
					Restrictions.eq("Hospital.Id", hospitalId));
			storeBosMList = c.list();

			// ---------For Pagination ------------------

			storeDisposalTList = hbt
					.find("from jkt.hms.masters.business.StoreDisposalT as sdt where sdt.DisposalM.Bos.Id='"
							+ bosId
							+ "' and sdt.DisposalM.Department.Id='"
							+ deptId + "' and sdt.DisposalM.Type='g'");
			//System.out.println("storeDisposalTList    "+ storeDisposalTList.size());
			for (Iterator iterator = storeDisposalTList.iterator(); iterator
					.hasNext();) {
				StoreDisposalT disposalT = (StoreDisposalT) iterator.next();

				try {
					id = disposalT.getId();
				} catch (Exception e) {
					id = 0;
				}

				try {
					pvms = disposalT.getItem().getPvmsNo();
				} catch (Exception e) {
					pvms = "";
				}

				try {
					nomenclature = disposalT.getItem().getNomenclature();
				} catch (Exception e) {
					nomenclature = "";
				}

				try {
					au = disposalT.getItem().getItemConversion()
							.getItemUnitName();
				} catch (Exception e) {
					au = "";
				}

				try {
					qty = new BigDecimal("" + disposalT.getQty());
				} catch (Exception e) {
					qty = new BigDecimal("0");
				}
				try {
					cost = new BigDecimal("" + disposalT.getCost());
				} catch (Exception e) {
					cost = new BigDecimal("0");
				}
				try {
					rvNo = ("" + disposalT.getRvNo());

				} catch (Exception e) {
					rvNo = ("");
				}
				try {
					remark = "" + disposalT.getRemarks();
				} catch (Exception e) {
					remark = "";
				}

				hData = new HashMap<String, Object>();
				hData.put("id", id);
				hData.put("pvms", pvms);
				hData.put("nomenclature", nomenclature);
				hData.put("au", au);
				hData.put("qty", qty);
				hData.put("cost", cost);
				hData.put("rvNo", rvNo);
				hData.put("remark", remark);

				vResult.add(hData);
			}
			//System.out.println("vresult" + vResult);

			if (vResult.size() > 0) {
				testPageData = new HashMap[vResult.size()];
				vResult.copyInto(testPageData);
			}

			try {
				pagedArray = new PageUtil().convertToPagedArrayIndex(
						testPageData, box);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// ------------------------------------------

			// End of transaction
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			messageTOBeVisibleToTheUser = "Not Added";
			messageType = "failure";
			e.printStackTrace();
		}
		//System.out.println("disposalNo    " + disposalNo);
		box.put("bosId", bosId);
		map.put("box", box);
		map.put("max", disposalNo);
		map.put("disposalStatus", disposalStatus);
		map.put("storeBosMList", storeBosMList);
		map.put("pagedArray", pagedArray);
		map.put("messageType", messageType);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return map;

	}

	public Map<String, Object> updateDisposalEntry2(Box box) {
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String max = "";
		int bosId = 0;
		if (box.get("deptId") != null)
			deptId = Integer.parseInt("" + box.get("deptId"));
		if (box.get("bosId") != null)
			bosId = Integer.parseInt("" + box.get("bosId"));
		if (box.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		if (box.get("userName") != null)
			userName = ("" + box.get("userName"));
		if (box.get(DISPOSAL_NO) != null)
			max = ("" + box.get(DISPOSAL_NO));

		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreMmfDepartmentT> storeMmfDepartmentTList = new ArrayList<StoreMmfDepartmentT>();
		StoreMmfDepartmentT storeMmfDepartmentT = null;
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			//System.out.println("box    " + box);
			hbt.setCheckWriteOperations(false);
			Vector srno = box.getVector("srno");
			Vector qty = box.getVector("qty");
			Vector items = box.getVector("id");
			Vector cost = box.getVector("cost");
			Vector remark = box.getVector("remark");
			Vector rvNo = box.getVector("rvNo");
			String obj = null;
			for (int i = 0; i < srno.size(); i++) {
				int itemId = Integer.parseInt(items.get(i).toString());
				StoreDisposalT tObj = (StoreDisposalT) hbt.load(
						StoreDisposalT.class, itemId);

				tObj.setQty(new BigDecimal(qty.get(i).toString()));
				tObj.setCost(new BigDecimal(cost.get(i).toString()));
				tObj.setRemarks(remark.get(i).toString());
				//System.out.println("rvNo.get(i).toString()  "	+ rvNo.get(i).toString());
				tObj.setRvNo(rvNo.get(i).toString());

				hbt.update(tObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		box.put(DISPOSAL_NO, max);
		dataMap.put("box", box);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("bosId", bosId);
		dataMap.put(DISPOSAL_NO, max);

		map = importFromBOS2(dataMap);
		return map;
	}

	// -------------------------End of Disposal Entry <= Rs
	// 30------------------------------------------

	// *********************************************************************************************************************
	// ------------------------------------End of Methods Written By
	// Vivek------------------------------------------
	// ****************************************************************************************************************

	// *********************************************************************************************************************
	// ------------------------------------Start Stores Report of Methods
	// Written By Mansi------------------------------------------
	// ****************************************************************************************************************

	public Map<String, Object> getConnectionForReport() {

		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	public String getHospitalName(int hospitalId) {
		Session session = (Session) getSession();
		String hospitalName = "";
		List<MasHospital> list = session.createCriteria(MasHospital.class).add(
				Restrictions.eq("Status", "y")).add(
				Restrictions.eq("Id", hospitalId)).list();

		if (list != null && list.size() > 0) {
			MasHospital obj = (MasHospital) list.get(0);
			hospitalName = obj.getHospitalName();
		}
		return hospitalName;
	}

	public Map<String, Object> showAMCRegisterJsp() {
		//System.out.println("showAMCRegisterJsp in DS");
		Map map = new HashMap();
		List<StoreAmcM> searchStoreAmcMList = new ArrayList<StoreAmcM>();
		searchStoreAmcMList = (List<StoreAmcM>) getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreAmcM ");
		map.put("searchStoreAmcMList", searchStoreAmcMList);
		return map;

	}

	// *********************************************************************************************************************
	// ------------------------------------End Stores Report of Methods Written
	// By Mansi------------------------------------------
	// ****************************************************************************************************************

	// === start of autocomplete method by abha

	public Map<String, Object> showImportedReportJsp() {
		//System.out.println("showImportedReportJsp in DS");
		Map map = new HashMap();
		List<MasStoreSection> searchStoreSectionList = new ArrayList<MasStoreSection>();
		List<StoreWorkOrderT> searchMasStoreItemList = new ArrayList<StoreWorkOrderT>();
		session = (Session) getSession();
		

		try 
		{
			searchMasStoreItemList = getHibernateTemplate().find("from jkt.hms.masters.business.StoreWorkOrderT ");
			searchStoreSectionList = (List<MasStoreSection>) getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreSection ");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchMasStoreItemList", searchMasStoreItemList);
		map.put("searchStoreSectionList", searchStoreSectionList);
		return map;

	}

	public Map<String, Object> getItemListForImportedItemByAutocomplete(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		int deptId = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		List objectList = new ArrayList();
		try {
			String str = dataMap.get("autoHint") + "%";
			String qry = "SELECT item_id FROM mas_store_item where imported_item='y'";
			objectList = (List) session.createSQLQuery(qry).list();
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("PvmsNo", str)).add(
					Restrictions.eq("Department.Id", deptId)).add(
					Restrictions.in("Id", objectList));
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;

	}
	
	public Map<String, Object> getItemListForMeScale(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Box box = (Box) dataMap.get("box");
		

		String pvmsNo = null;
		int deptId = 0;
		int indentId = 0;

		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		
		
		List objectList = new ArrayList();
		try {
			String str = "%" + dataMap.get("autoHint") + "%";
			
				

				Criteria c = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("Nomenclature", str)).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.eq("Status", "y"));
						
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			
		} catch (Exception e) {
			//System.out.println("excep:::::::::::::::    " + e);
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}
	
	public Map<String, Object> fillItemsForMeScale(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String pvms = null;

		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "" + dataMap.get("nomenclature");
			StringBuffer output_str = new StringBuffer();
			StringTokenizer s = new StringTokenizer(str, "%");

			while (s.hasMoreTokens()) {
				output_str.append(s.nextToken());
				if (s.hasMoreTokens()) {
					output_str.append("\\%");
				}
			}

			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str)).add(
					Restrictions.eq("Status", "y"));
			itemList = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		map.put("itemList", itemList);
		return map;

	}
	
	
	public Map showLoanOutJsp(Map<String, Object> dataMap) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}
		Map map = new HashMap();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasStoreBrand> masStoreBrandList = new ArrayList<MasStoreBrand>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();
		String max = "";
		String startNo = "";
		String no = "";
		try {
			patientList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.Patient as pt where pt.Status='y'");
			storeInternalIndentMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreInternalIndentM");
			departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment");
			masStoreAirForceDepotList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreAirForceDepot");
			employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee");
			storeFyDocumentNoList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "' ");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getIssueLoanoutNo()!= null) {
					no = ("" + storeFyDocumentNo.getIssueLoanoutNo());
				} else {
					no = "";
				}

			}
			searchListForPopup = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreIssueM sim where sim.Department.Id='"
							+ deptId
							+ "' and sim.Status='o' and sim.IssueType='i'");

		} catch (Exception e) {
			//System.out.println("In showIssueDispensaryJsp " + e);
		}
		//System.out.println("==================no================== " + no);
		try {
			max = getMaxNo(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("storeInternalIndentMList", storeInternalIndentMList);
		map.put("storeInternalIndentTList", storeInternalIndentTList);
		map.put("departmentList", departmentList);
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("employeeList", employeeList);
		map.put("max", max);
		map.put("masStoreBrandList", masStoreBrandList);
		map.put("searchListForPopup", searchListForPopup);
		map.put("patientList", patientList);
		return map;
	}

	
	public Map<String, Object> getStock(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> stockList = new ArrayList<StoreItemBatchStock>();
		List objectList = new ArrayList();
		
		int stockId=0;
		stockId = (Integer)dataMap.get("stockId");
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "" + dataMap.get("nomenclature");
			
			Criteria crit = session.createCriteria(StoreItemBatchStock.class).add(
					Restrictions.eq("Id", stockId));
			stockList = crit.list();
			
			
			map.put("stockList", stockList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}
	
	
	public Map<String, Object> submitLoanOutForNe(Map<String, Object> dataMap) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = null;
		box = (Box) dataMap.get("box");
		session = (Session) getSession();
		Transaction tx = null;
		StoreLoanOutM storeLoanOutM = new StoreLoanOutM();
		//StoreLoanOutT storeLoanOutT = new StoreLoanOutT();
		StoreIssueM searchListForPopup = new StoreIssueM();
		String date4MySQL = "";
		String messageType = "";
		String messageTOBeVisibleToTheUser = "";
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
	
		String issueNo = "";
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));
		
		
		Vector itemIdList = box.getVector("itemId");
		Vector qtyIssuedList = box.getVector(RequestConstants.QTY_ISSUED);
		Vector lotNo = box.getVector("lotNo");
		
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		int storeFyId = 0;
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List objectList = new ArrayList();

		try {
			// ---------------------Start of
			// Transaction----------------------------
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
				storeLoanOutM.setIssueType("i");
				storeLoanOutM.setIssueNo("" + box.get(RequestConstants.ISSUE_NO));
				issueNo = "" + box.get(RequestConstants.ISSUE_NO);
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String issueDate=box.get(RequestConstants.ISSUE_DATE);
				date4MySQL = formatterOut.format(formatterIn.parse(""
						+ box.get(RequestConstants.ISSUE_DATE)));
				java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL);
				storeLoanOutM.setIssueDate(startDate);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeLoanOutM.setDepartment(masDepartment);
				storeLoanOutM.setStatus("o");
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeLoanOutM.setHospital(masHospital);

				MasDepartment masDepartment2 = new MasDepartment();
				masDepartment2.setId(Integer.parseInt(""
						+ box.get(RequestConstants.DEPARTMENT_ID_TEMP)));
				storeLoanOutM.setToStore(masDepartment2);
			//	storeIssueM.setDocNo("" + box.get(RequestConstants.DOC_NO));

				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(Integer.parseInt(""
						+ box.get(RequestConstants.ISSUED_BY)));
				storeLoanOutM.setIssuedBy(masEmployee);
				hbt.save(storeLoanOutM);
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
			
				int stockId=0;
			for (int i = 0; i < itemIdList.size(); i++) {
				int item_id = Integer.parseInt(itemIdList.get(i).toString());
				if ((item_id != 0)
						&& (!(qtyIssuedList.get(i).toString()).equals(""))) {
					BigDecimal qtyIssued = new BigDecimal(qtyIssuedList.get(i)
							.toString());
					stockId=Integer.parseInt(lotNo.get(i).toString());
					StoreLoanOutT storeLoanOutT = new StoreLoanOutT();

					MasStoreItem item = new MasStoreItem();
					item.setId(item_id);
					storeLoanOutT.setItem(item);

					MasStoreItem item2 = new MasStoreItem();
					item2.setId(item_id);
					storeLoanOutT.setItemIssued(item2);
					storeLoanOutT.setIssued("y");
					storeLoanOutT.setIssueM(storeLoanOutM);
					storeLoanOutT.setQtyIssued(qtyIssued);

					// --------------------------Start of Stock
					// Updating--------------------------
					BigDecimal stock = null;
					BigDecimal issueQty = null;
					
					/*String qry = "select closing_stock,issue_qty from store_item_batch_stock where item_id="
							+ item_id +" and department_id="+deptId;*/
					
					String qry = "select closing_stock,issue_qty from store_item_batch_stock where stock_id="+stockId;
						
					
					List c = (List) session.createSQLQuery(qry).list();

					for (Iterator iterator = c.iterator(); iterator.hasNext();) {
						Object[] object = (Object[]) iterator.next();
						if (object[0] == null) {
							stock = new BigDecimal("0");
						} else {
							stock = (BigDecimal) object[0];
						}
						if (object[1] == null) {
							issueQty = new BigDecimal("0");
						} else {
							issueQty = (BigDecimal) object[1];
						}
					}

					stock = stock.subtract(qtyIssued);
					issueQty = issueQty.add(qtyIssued);
					String hql2 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.ClosingStock='"
							+ stock + "'  where a.Id=" + stockId ;
					String hql3 = "update from jkt.hms.masters.business.StoreItemBatchStock  as a set a.IssueQty='"
							+ issueQty + "' where a.Id=" + stockId ;
					Query query2 = session.createQuery(hql2);
					int row2 = query2.executeUpdate();
					Query query3 = session.createQuery(hql3);
					int row3 = query3.executeUpdate();
					// -------------------------------------------------------------------------------

					hbt.save(storeLoanOutT);
			
					StoreItemBatchStock storeItemBatchStock=new StoreItemBatchStock();
					storeItemBatchStock.setItem(item);
					MasDepartment masDepartment1=new MasDepartment();
					masDepartment1.setId(Integer.parseInt(""
						+ box.get(RequestConstants.DEPARTMENT_ID_TEMP)));
					storeItemBatchStock.setDepartment(masDepartment1);
					storeItemBatchStock.setBatchNo(lotNo.get(i).toString());
					storeItemBatchStock.setOpeningBalanceAmount(qtyIssued);
					storeItemBatchStock.setClosingStock(qtyIssued);
					storeItemBatchStock.setReceivedQty(qtyIssued);
					storeItemBatchStock.setBrand(null);
					hbt.saveOrUpdate(storeItemBatchStock);
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
				
				}
				
				
				
				
			}

			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}
			
			
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
						.load(StoreFyDocumentNo.class, storeFyId);
				storeFyDocumentNo.setIssueLoanoutNo(issueNo);
				hbt.update(storeFyDocumentNo);
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				
			
			// searchListForPopup=(StoreIssueM)
			// getHibernateTemplate().find("from jkt.hms.masters.business.StoreIssueM as sim where sim.IssueType='i' and sim.Status='o' and sim.Department.Id='"+deptId+"' ");
			// ---------------------End of
			// Transaction----------------------------
			tx.commit();
			messageTOBeVisibleToTheUser = "Added Successfully";
			messageType = "success";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			//System.out.println("*---------HMS TRANSACTION ERROR--------*");
			//System.out.println("****************************************");
			//System.out.println("****************************************");
			messageTOBeVisibleToTheUser = "Not Added";
			messageType = "failure";
			e.printStackTrace();
		}
		map.put("messageType", messageType);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		
		
		map.put("searchListForPopup", searchListForPopup);
		return map;
	}
	
	
	//----------By Dipali For indent To Depo---
	@Override
	public Map<String, Object> showSearchIndentToDepo(Map<String,Object>dataMap) {

		//System.out.println("showIndentJspDepot");
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));

		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreIndentM> list = new ArrayList<StoreIndentM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		int grnStartNo = 0;
		String no = "";
		session = (Session) getSession();
		List objectList = new ArrayList();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			String qry = "select mas.item_id,mas.pvms_no,mas.nomenclature,mas.strength,b.stock,c.qty_in_mmf," +
					"mas.old_niv_no,mas.department_id," +
					" con.item_unit_name from mas_store_item mas " +
					" inner join mas_store_item_conversion con on mas.item_conversion_id= con.item_conversion_id " +
					" left outer join " +
					"(select ba.item_id,sum(ba.closing_stock) stock from " +
					" store_item_batch_stock ba where department_id=1 group by ba.item_id)b" +
					" on mas.item_id=b.item_id left outer join " +
					" (select it.qty_in_mmf, it.item_id from  store_indent_m im inner join store_indent_t it " +
					"on im.indent_id=it.indent_id where im.mmf_for_the_year=" + year + " )c on mas.item_id=c.item_id";
			objectList = (List) session.createSQLQuery(qry).list();
			masStoreAirForceDepotList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreAirForceDepot as md where md.Status = 'y'");
			searchIndentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreIndentM as md where md.Status = 'o'and  md.Department.Id='"
									+ deptId + "' and md.IndentType='d' order by md.IndentNo desc ");
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection ");
			storeFyDocumentNoList = (List) getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
									+ deptId + "'");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getIndentToDepotNo() != null) {
					no = ("" + storeFyDocumentNo.getIndentToDepotNo());
					no = getMaxNo(no);
				} else {
					no = getMaxNo("");
				}

			}

		} catch (Exception e) {
			//System.out.println("1");
			e.printStackTrace();
		}
		//System.out.println("masStoreAirForceDepotList  "+ masStoreAirForceDepotList.size());
		map.put("masStoreAirForceDepotList", masStoreAirForceDepotList);
		map.put("searchIndentList", searchIndentList);
		map.put("sectionList", sectionList);
		map.put("maxIndentNo", no);
		map.put("objectList", objectList);
		return map;

	
	}
	public Map<String, Object> getItemListForDefectiveDrugsByAutocomplete(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreItem> itemList1 = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		//String pvmsNo = null;
		//Box box = (Box) dataMap.get("box");
		int hospitalId=0;
		int deptId = 0;
		hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		List objectList = new ArrayList();
		try {
			String str = (String) dataMap.get("autoHint");
			str=str.toUpperCase()+ "%";
			String qry = "SELECT item_id FROM store_item_batch_stock where department_id="
				+ deptId+" and hospital_id="+hospitalId ;

			objectList = (List) session.createSQLQuery(qry).list();
			if (objectList.size() != 0) {
				List<BigDecimal> objectNewList = new ArrayList<BigDecimal>();
				String sql="";
				for (int i=0;i<objectList.size();i++) {
					if(i<100){
						if(i==0){
							sql=""+objectList.get(i);
						}else{
							sql=sql+" , "+objectList.get(i);
						}
					}
				}
				/*Criteria c = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.like("Nomenclature", str))

					.add(Restrictions.in("Id", objectList));
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();*/
				if(!sql.equals(""))

				{
					itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"'  and item.ItemType.Id='2' and item.Hospital.Id='"+hospitalId+"'");
					itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.ItemType.Id='1'");
					itemList.addAll(itemList1);

				}else{
					itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"'  and item.ItemType.Id='2' and item.Hospital.Id='"+hospitalId+"'");
					itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.ItemType.Id='1'");
					itemList.addAll(itemList1);
				}



			} else {
				/*Criteria c = session.createCriteria(MasStoreItem.class)
						.add(Restrictions.eq("Status", "y")).add(Restrictions.like("Nomenclature", str).ignoreCase());
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();*/

				itemList=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.Status='y'  and item.ItemType.Id='2' and item.Hospital.Id='"+hospitalId+"'");
				itemList1=getHibernateTemplate().find("select item from jkt.hms.masters.business.MasStoreItem as item where upper(item.Nomenclature) like '"+str+"' and item.Status='y' and item.ItemType.Id='1'");

				itemList.addAll(itemList1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		map.put("objectList", objectList);
		return map;
	}


}
