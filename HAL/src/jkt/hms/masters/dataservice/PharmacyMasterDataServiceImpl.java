package jkt.hms.masters.dataservice;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.ME_SCALE_DESCRIPTION;
import static jkt.hms.util.RequestConstants.ME_SCALE_NUMBER;
import static jkt.hms.util.RequestConstants.TENDER_ANNREQ;
import static jkt.hms.util.RequestConstants.TENDER_ITEM_ID;
import static jkt.hms.util.RequestConstants.TENDER_NO;
import static jkt.hms.util.RequestConstants.TENDER_SRNO;
import static jkt.hms.util.RequestConstants.SR_NO;












import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemClass;
import jkt.hms.masters.business.MasItemClassification;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasBudgetCode;
import jkt.hms.masters.business.MasSalesType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStoreAirForceDepot;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStoreBudgetT;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreItemGeneric;
import jkt.hms.masters.business.MasStoreMeScale;
import jkt.hms.masters.business.MasStorePharmaIndex;
import jkt.hms.masters.business.MasStorePoDeliveryTerms;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasStoreSupplierGroup;
import jkt.hms.masters.business.MasStoreSupplierType;
import jkt.hms.masters.business.MasStoreUnit;
import jkt.hms.masters.business.MasStoreVendorWiseManufacturer;
import jkt.hms.masters.business.MasStoreUnit;
import jkt.hms.masters.business.MprPriority;
import jkt.hms.masters.business.StoreFyDocumentNo;
import jkt.hms.masters.business.StoreMeScaleDetails;
import jkt.hms.masters.business.StoreSetup;
import jkt.hms.masters.business.MasRepairStation;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.tools.ant.taskdefs.condition.IsSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PharmacyMasterDataServiceImpl extends HibernateDaoSupport
		implements PharmacyMasterDataService {
	// ----------------------------------Item
	// Type-------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showItemTypeJsp() {
		Session session =(Session)getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasItemType> searchItemTypeList = new ArrayList<MasItemType>();
		List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
		searchItemTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasItemType ");
		
		itemGroupList = session.createCriteria(MasStoreGroup.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("searchItemTypeList", searchItemTypeList);
		map.put("itemGroupList", itemGroupList);
		return map;
	}
	public boolean addItemType(MasItemType masItemType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masItemType);
		successfullyAdded = true;
		return successfullyAdded;
	}
	public boolean deleteItemType(int itemTypeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasItemType masItemType = new MasItemType();
		masItemType = (MasItemType) getHibernateTemplate().load(
				MasItemType.class, itemTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masItemType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masItemType.setStatus("y");
				dataDeleted = false;
			}
		}
		masItemType.setLastChgBy(changedBy);
		masItemType.setLastChgDate(currentDate);
		masItemType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masItemType);
		return dataDeleted;
	}
	public boolean editItemTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String itemTypeName = "";
		@SuppressWarnings("unused")
		String itemTypeCode = "";
		int itemTypeId = 0;
		int itemGroupId = 0;
		String changedBy = "";
		itemTypeId = (Integer) generalMap.get("id");
		itemTypeCode = (String) generalMap.get("itemTypeCode");
		itemTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		itemGroupId = (Integer) generalMap.get("itemGroupId");
		currentTime = (String) generalMap.get("currentTime");
		MasItemType masItemType = (MasItemType) getHibernateTemplate().load(
				MasItemType.class, itemTypeId);
		masItemType.setId(itemTypeId);
		masItemType.setItemTypeName(itemTypeName);
		masItemType.setLastChgBy(changedBy);
		masItemType.setLastChgDate(currentDate);
		masItemType.setLastChgTime(currentTime);
		MasStoreGroup masStoreGroup = new MasStoreGroup();
		masStoreGroup.setId(itemGroupId);
		masItemType.setGroup(masStoreGroup);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masItemType);
		dataUpdated = true;
		return dataUpdated;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchItemType(String itemTypeCode,
			String itemTypeName) {
		Session session =(Session)getSession();
		List<MasItemType> searchItemTypeList = new ArrayList<MasItemType>();
		Map<String, Object> itemTypeFieldsMap = new HashMap<String, Object>();
		List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
		try {
			if ((itemTypeName != null) || (itemTypeCode == null)) {

				searchItemTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasItemType sc where sc.ItemTypeName like '"
								+ itemTypeName + "%' order by sc.ItemTypeName");
			} else {
				searchItemTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasItemType sc where sc.ItemTypeCode like '"
								+ itemTypeCode + "%' order by sc.ItemTypeCode");
			}
			itemGroupList = session.createCriteria(MasStoreGroup.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		itemTypeFieldsMap.put("itemGroupList", itemGroupList);
		itemTypeFieldsMap.put("searchItemTypeList", searchItemTypeList);
		return itemTypeFieldsMap;
	}
	// ------------------------------------Manufacturer---------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showManufacturerJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasManufacturer> searchManufacturerList = new ArrayList<MasManufacturer>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();
		Session session = null;

		searchManufacturerList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasManufacturer ");
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

		session = (Session) getSession();
		/*String qry = "SELECT substring(manufacturer_code,2,10) as number1, manufacturer_code FROM mas_manufacturer order by number1";
		String manufacturer_code = "M1";
		List objectList = (List) session.createSQLQuery(qry).list();
		if (objectList != null && objectList.size() > 0) {
			Object[] pair = (Object[]) objectList.get(objectList.size() - 1);
			int no = Integer.parseInt(pair[0].toString()) + 1;
			
			manufacturer_code = "M" + no;
		}*/

		map.put("searchManufacturerList", searchManufacturerList);
		map.put("districtList", districtList);
		map.put("gridDistrictList", gridDistrictList);
		map.put("stateList", stateList);
		map.put("gridStateList", gridStateList);
		//map.put("manufacturer_code", manufacturer_code);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchManufacturer(String manufacturerCode,
			String manufacturerName) {
		List<MasManufacturer> searchManufacturerList = new ArrayList<MasManufacturer>();
		Map<String, Object> manufacturerFieldsMap = new HashMap<String, Object>();
		List<MasDistrict> districtList = null;
		List<MasDistrict> gridDistrictList = null;
		List<MasState> stateList = null;
		List<MasState> gridStateList = null;

		try {
			if ((manufacturerName != null) || (manufacturerCode == null)) {
				searchManufacturerList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasManufacturer mr where mr.ManufacturerName like '"
										+ manufacturerName
										+ "%' order by mr.ManufacturerName");
			} else {
				searchManufacturerList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasManufacturer mr where mr.ManufacturerCode like '"
										+ manufacturerCode
										+ "%' order by mr.ManufacturerCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
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

		manufacturerFieldsMap.put("districtList", districtList);
		manufacturerFieldsMap.put("gridDistrictList", gridDistrictList);
		manufacturerFieldsMap.put("stateList", stateList);
		manufacturerFieldsMap.put("gridStateList", gridStateList);
		manufacturerFieldsMap.put("searchManufacturerList",
				searchManufacturerList);
		return manufacturerFieldsMap;
	}

	public boolean addManufacturer(MasManufacturer masManufacturer) {
		boolean successfullyAdded = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masManufacturer);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editManufacturerToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String manufacturerName = "";
		@SuppressWarnings("unused")
		String manufacturerCode = "";
		int manufacturerId = 0;
		String changedBy = "";
		String contactPerson = "";
		String address1 = "";
		String address2 = "";
		int cityId = 0;
		int stateId = 0;
		String licenceNo = "";
		String salesTaxNo = "";
		int pinCode = 0;
		String phoneNo = "";
		String mobileNo = "";
		String emailId = "";
		String faxNo = "";
		String url = "";
		manufacturerId = (Integer) generalMap.get("id");
		manufacturerCode = (String) generalMap.get("manufacturerCode");
		manufacturerName = (String) generalMap.get("name");
		contactPerson = (String) generalMap.get("contactPerson");
		address1 = (String) generalMap.get("address1");
		address2 = (String) generalMap.get("address2");
		cityId = (Integer) generalMap.get("cityId");
		stateId = (Integer) generalMap.get("stateId");
		pinCode = (Integer) generalMap.get("pinCode");
		licenceNo = (String) generalMap.get("licenceNo");
		salesTaxNo = (String) generalMap.get("salesTaxNo");
		phoneNo = (String) generalMap.get("phoneNo");
		url = (String) generalMap.get("url");
		mobileNo = (String) generalMap.get("mobileNo");
		emailId = (String) generalMap.get("emailId");
		faxNo = (String) generalMap.get("faxNo");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasManufacturer masManufacturer = (MasManufacturer) getHibernateTemplate()
				.load(MasManufacturer.class, manufacturerId);

		masManufacturer.setId(manufacturerId);
		masManufacturer.setManufacturerName(manufacturerName);
		masManufacturer.setContactPerson(contactPerson);
		masManufacturer.setAddress1(address1);
		masManufacturer.setAddress2(address2);
if(cityId!=0){
		MasDistrict masDistrict = new MasDistrict();
		masDistrict.setId(cityId);
		masManufacturer.setCity(masDistrict);
}
if(stateId!=0){
		MasState masState = new MasState();
		masState.setId(stateId);
		masManufacturer.setState(masState);
		}
		masManufacturer.setLicenceNo(licenceNo);
		masManufacturer.setSalesTaxNo(salesTaxNo);
		if(pinCode!=0){
			masManufacturer.setPinCode(pinCode);
			}
		masManufacturer.setFaxNumber(faxNo);
		masManufacturer.setPhoneno(phoneNo);
		masManufacturer.setMobileno(mobileNo);
		masManufacturer.setEmailId(emailId);
		masManufacturer.setUrl(url);
		masManufacturer.setLastChgBy(changedBy);
		masManufacturer.setLastChgDate(currentDate);
		masManufacturer.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masManufacturer);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteManufacturer(int manufacturerId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasManufacturer masManufacturer = new MasManufacturer();
		masManufacturer = (MasManufacturer) getHibernateTemplate().load(
				MasManufacturer.class, manufacturerId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masManufacturer.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masManufacturer.setStatus("y");
				dataDeleted = false;
			}
		}
		masManufacturer.setLastChgBy(changedBy);
		masManufacturer.setLastChgDate(currentDate);
		masManufacturer.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masManufacturer);
		return dataDeleted;
	}

	public Map<String, Object> showBrandJsp(Box box) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = null;

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBrand> searchBrandList = new ArrayList<MasStoreBrand>();
		List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
		// List<MasStoreItem> itemList=new ArrayList<MasStoreItem>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();

		session = (Session) getSession();
		String qry = "select CAST(substring(brand_code,2) as UNSIGNED) as number, brand_code from mas_store_brand order by number";
		List objectList = (List) session.createSQLQuery(qry).list();
		if (objectList != null && objectList.size() > 0) {
			Object[] pair = (Object[]) objectList.get(objectList.size() - 1);
			int no = Integer.parseInt(pair[0].toString()) + 1;
			String brand_code = "B" + no;
			map.put("brand_code", brand_code);
		} else
			map.put("brand_code", "B1");

		if (box.getInt("itemIdFromBrandPopup") != 0) {
			searchBrandList = hbt
					.find("from jkt.hms.masters.business.MasStoreBrand as m where m.Item.Id = "
							+ box.getInt("itemIdFromBrandPopup"));
			// searchBrandList =
			// session.createCriteria(MasStoreBrand.class).add(Restrictions.eq("Item",box.getInt("itemId"))).list();
			masStoreItemList = hbt
					.find("from jkt.hms.masters.business.MasStoreItem as m where m.Id = "
							+ box.getInt("itemIdFromBrandPopup"));
			// masStoreItemList =
			// session.createCriteria(MasStoreItem.class).add(Restrictions.eq("Id",box.getInt("itemId"))).list();
			String nomenclature = masStoreItemList.get(0).getNomenclature()
					+ "[" + masStoreItemList.get(0).getPvmsNo() + "]";
			map.put("nomenclature", nomenclature);
			map.put("itemIdForManufaturer", box.getInt("itemIdFromBrandPopup"));

		} else
			searchBrandList = hbt
					.find("from jkt.hms.masters.business.MasStoreBrand as m ");
		// itemList=getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreItem as sc");
		manufacturerList = hbt
				.find("from jkt.hms.masters.business.MasManufacturer as mm order by mm.ManufacturerName");

		map.put("searchBrandList", searchBrandList);
		// map.put("itemList",itemList);
		map.put("manufacturerList", manufacturerList);

		return map;
	}

	public Map<String, Object> editBrandToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Map<String, Object> detailMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		// String currentTime = "";
		// int itemGenericId=0;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int manufacturerId = 0;
		int itemId = 0;
		// currentTime =
		// (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		// String brandName="";
		@SuppressWarnings("unused")
		// String brandCode="";
		int brandId = 0;
		// String changedBy = "";
		brandId = (Integer) generalMap.get("id");
		// brandCode=(String)generalMap.get("brandCode");
		// brandName=(String)generalMap.get("name");
		// itemGenericId=(Integer)generalMap.get("itemGenericId");
		manufacturerId = (Integer) generalMap.get("manufacturerId");
		itemId = (Integer) generalMap.get("itemId");
		// changedBy = (String)generalMap.get("changedBy");
		// currentDate=(Date)generalMap.get("currentDate");
		// currentTime=(String)generalMap.get("currentTime");
		MasStoreBrand masBrand = (MasStoreBrand) getHibernateTemplate().get(
				MasStoreBrand.class, brandId);

		masBrand.setId(brandId);
		// masBrand.setBrandName(brandName);

		/*
		 * One Case MasStoreItem masStoreItem = masBrand.getItem();
		 *
		 * masStoreItem.setId(itemId);
		 *
		 * MasManufacturer masManufacturer = new MasManufacturer();
		 * masManufacturer.setId(manufacturerId);
		 * masStoreItem.setManufacturer(masManufacturer);
		 *
		 * masBrand.setItem(masStoreItem); One Case
		 */

		/* second Case */
		MasManufacturer masManufacturer = new MasManufacturer();
		masManufacturer.setId(manufacturerId);

		masBrand.setManufacturer(masManufacturer);
		/* second Case */

		/*
		 * MasStoreItemGeneric masStoreItemGeneric= new MasStoreItemGeneric();
		 * masStoreItemGeneric.setId(itemGenericId);
		 * masBrand.setItemGeneric(masStoreItemGeneric);
		 */

		// masBrand.setLastChgBy(changedBy);
		// masBrand.setLastChgDate(currentDate);
		// masBrand.setLastChgTime(currentTime);
		hbt.update(masBrand);
		hbt.refresh(masBrand);
		dataUpdated = true;
		detailMap.put("dataUpdated", dataUpdated);
		// detailMap.put("manufacturerId", manufacturerId);

		return detailMap;
	}

	// --------------------------------------- Supplier
	// -------------------------------------
	public Map<String, Object> showMatchedBrandList(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		Integer itemId = 0;
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		if (parameterMap.get("itemId") != null
				&& !parameterMap.get("itemId").equals("")) {
			itemId = (Integer) parameterMap.get("itemId");

		}
		Session session = (Session) getSession();
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(MasStoreBrand.class).add(
					Restrictions.eq("Item.id", itemId));
			brandList = criteria.list();
			if (brandList.size() > 0) {
				detailMap.put("brandList", brandList);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return detailMap;
	}

	public boolean addStoreSupplier(MasStoreSupplier masStoreSupplier,
			Map<String, Object> generalMap) {

		boolean successfullyAdded = false;
		MasManufacturer masManufacturer = new MasManufacturer();
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreSupplier);
		//hbt.refresh(masStoreSupplier);

		int supplierId = masStoreSupplier.getId();
		String manufacturerStr = "";
		String groupStr = "";

		if (generalMap.get("manufacturerStr") != null) {
			manufacturerStr = (String) generalMap.get("manufacturerStr");
		}
		if (generalMap.get("groupStr") != null) {
			groupStr = (String) generalMap.get("groupStr");
		}

		if (generalMap.get("masManufacturer") != null) {
			masManufacturer = (MasManufacturer) generalMap
					.get("masManufacturer");
			hbt.save(masManufacturer);
			//hbt.refresh(masManufacturer);
		}

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		StringTokenizer str = new StringTokenizer(manufacturerStr, ",");
		StringTokenizer strForGroup = new StringTokenizer(groupStr, ",");

		while (str.hasMoreTokens()) {
			MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer = new MasStoreVendorWiseManufacturer();

			int manufacturerId = Integer.parseInt(str.nextToken());
			MasManufacturer masManufacturer1 = new MasManufacturer();
			masManufacturer1.setId(manufacturerId);
			masStoreVendorWiseManufacturer.setManufacturer(masManufacturer1);

			MasStoreSupplier masSupplier = new MasStoreSupplier();
			masSupplier.setId(supplierId);
			masStoreVendorWiseManufacturer.setSupplier(masSupplier);

			masStoreVendorWiseManufacturer.setLastChgBy(changedBy);
			masStoreVendorWiseManufacturer.setLastChgDate(currentDate);
			masStoreVendorWiseManufacturer.setLastChgTime(currentTime);
			masStoreVendorWiseManufacturer.setStatus("y");
			hbt.save(masStoreVendorWiseManufacturer);
			//hbt.refresh(masStoreVendorWiseManufacturer);

		}

		while (strForGroup.hasMoreTokens()) {
			MasStoreSupplierGroup masStoreSupplierGroup = new MasStoreSupplierGroup();

			int groupId = Integer.parseInt(strForGroup.nextToken());
			MasStoreGroup group = new MasStoreGroup();
			group.setId(groupId);
			masStoreSupplierGroup.setGroup(group);

			MasStoreSupplier masSupplier = new MasStoreSupplier();
			masSupplier.setId(supplierId);
			masStoreSupplierGroup.setSupplier(masSupplier);

			hbt.save(masStoreSupplierGroup);
			//hbt.refresh(masStoreSupplierGroup);
		}

		successfullyAdded = true;
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public boolean deleteStoreSupplier(Integer storeSupplierId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
		masStoreSupplier = (MasStoreSupplier) getHibernateTemplate().load(
				MasStoreSupplier.class, storeSupplierId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		Integer storeSupplieTypeId = masStoreSupplier.getSupplierType().getId();

		if (generalMap.get("flag") != null) {
			List storeSupplierList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSupplierType as mit where mit.Id='"
							+ storeSupplieTypeId + "' and mit.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreSupplier.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreSupplier.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreSupplier.setLastChgBy(changedBy);
		masStoreSupplier.setLastChgDate(currentDate);
		masStoreSupplier.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreSupplier);
		return dataDeleted;
	}

	public boolean editStoreSupplierToDatabase(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		boolean dataUpdated = false;
		int storeSupplierId = 0;
		int storeSupplierTypeId = 0;
		String storeSupplierCode = "";
		String storeSupplierName = "";
		String pinNo = "";
		String tinNo = "";
		String licenceNo = "";
		String salesTaxNo = "";
		String typeOfReg = "";
		String address1 = "";
		String address2 = "";
		int city = 0;
		int state = 0;
		String phoneNo = "";
		String mobileNo = "";
		int pinCode = 0;
		String emailId = "";
		String faxNo = "";
		String url = "";
		String localAddress1 = "";
		String localAddress2 = "";
		int localCity = 0;
		String localPhoneNo = "";
		int localPinCode = 0;
		int localState = 0;

		String cfDistributorName = "";
		String cfDistributorAddress1 = "";
		String cfDistributorAddress2 = "";
		String fdrReceiptAttached = "";

		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";

		String manufacturerStr = "";
		String groupStr = "";

		if (generalMap.get("manufacturerStr") != null) {
			manufacturerStr = (String) generalMap.get("manufacturerStr");
		}
		if (generalMap.get("groupStr") != null) {
			groupStr = (String) generalMap.get("groupStr");
		}
		StringTokenizer str = new StringTokenizer(manufacturerStr, ",");
		StringTokenizer strForGroup = new StringTokenizer(groupStr, ",");

		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			storeSupplierId = (Integer) generalMap.get("id");
			storeSupplierTypeId = (Integer) generalMap
					.get("storeSupplierTypeId");
			storeSupplierCode = (String) generalMap.get("code");
			storeSupplierName = (String) generalMap.get("name");
			address1 = (String) generalMap.get("address1");
			address2 = (String) generalMap.get("address2");
			city = (Integer) generalMap.get("city");
			state = (Integer) generalMap.get("state");
			faxNo = (String) generalMap.get("faxNo");
			url = (String) generalMap.get("url");
			phoneNo = (String) generalMap.get("phoneNo");
			mobileNo = (String) generalMap.get("mobileNo");
			pinCode = (Integer) generalMap.get("pinCode");
			emailId = (String) generalMap.get("emailId");

			localAddress1 = (String) generalMap.get("localAddress1");
			localAddress2 = (String) generalMap.get("localAddress2");
			localCity = (Integer) generalMap.get("localCity");
			localState = (Integer) generalMap.get("localState");

			localPinCode = (Integer) generalMap.get("localPinCode");
			localPhoneNo = (String) generalMap.get("localPhoneNo");

			cfDistributorName = (String) generalMap.get("cfDistributorName");
			cfDistributorAddress1 = (String) generalMap
					.get("cfDistributorAddress1");
			cfDistributorAddress2 = (String) generalMap
					.get("cfDistributorAddress2");
			fdrReceiptAttached = (String) generalMap.get("fdrReceiptAttached");

			salesTaxNo = (String) generalMap.get("salesTaxNo");
			typeOfReg = (String) generalMap.get("typeOfReg");
			licenceNo = (String) generalMap.get("licenceNo");
			tinNo = (String) generalMap.get("tinNo");
			pinNo = (String) generalMap.get("pinNo");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			List<MasStoreSupplierGroup> groupListBySupplier = hbt
					.find("from jkt.hms.masters.business.MasStoreSupplierGroup as inp where inp.Supplier.Id = "
							+ storeSupplierId);

			for (MasStoreSupplierGroup masStoreSupplierGroup : groupListBySupplier) {
				int id = masStoreSupplierGroup.getId();
				String hql = "delete from jkt.hms.masters.business.MasStoreSupplierGroup as a where a.Id = "
						+ id;
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
			}

			List<MasStoreVendorWiseManufacturer> manufacturerListBySupplier = hbt
					.find("from jkt.hms.masters.business.MasStoreVendorWiseManufacturer as inp where inp.Supplier.Id = "
							+ storeSupplierId);

			for (MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer : manufacturerListBySupplier) {
				int id = masStoreVendorWiseManufacturer.getId();
				String hql = "delete from jkt.hms.masters.business.MasStoreVendorWiseManufacturer as a where a.Id = "
						+ id;
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
			}

			while (str.hasMoreTokens()) {
				MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer = new MasStoreVendorWiseManufacturer();

				int manufacturerId = Integer.parseInt(str.nextToken());

				MasManufacturer masManufacturer = new MasManufacturer();
				masManufacturer.setId(manufacturerId);
				masStoreVendorWiseManufacturer.setManufacturer(masManufacturer);

				MasStoreSupplier masSupplier = new MasStoreSupplier();
				masSupplier.setId(storeSupplierId);
				masStoreVendorWiseManufacturer.setSupplier(masSupplier);

				masStoreVendorWiseManufacturer.setLastChgBy(changedBy);
				masStoreVendorWiseManufacturer.setLastChgDate(currentDate);
				masStoreVendorWiseManufacturer.setLastChgTime(currentTime);
				masStoreVendorWiseManufacturer.setStatus("y");
				hbt.save(masStoreVendorWiseManufacturer);
			}

			while (strForGroup.hasMoreTokens()) {
				MasStoreSupplierGroup masStoreSupplierGroup = new MasStoreSupplierGroup();

				int groupId = Integer.parseInt(strForGroup.nextToken());
				MasStoreGroup group = new MasStoreGroup();
				group.setId(groupId);
				masStoreSupplierGroup.setGroup(group);

				MasStoreSupplier masSupplier = new MasStoreSupplier();
				masSupplier.setId(storeSupplierId);
				masStoreSupplierGroup.setSupplier(masSupplier);

				hbt.save(masStoreSupplierGroup);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			MasStoreSupplier masStoreSupplier = (MasStoreSupplier) getHibernateTemplate()
					.load(MasStoreSupplier.class, storeSupplierId);

			masStoreSupplier.setId(storeSupplierId);
			masStoreSupplier.setSupplierName(storeSupplierName);

			MasStoreSupplierType masStoreSupplierType = new MasStoreSupplierType();
			masStoreSupplierType.setId(storeSupplierTypeId);
			masStoreSupplier.setSupplierType(masStoreSupplierType);

			masStoreSupplier.setTinNo(tinNo);
			masStoreSupplier.setSalesTaxNo(salesTaxNo);
			masStoreSupplier.setTypeOfReg(typeOfReg);
			masStoreSupplier.setLicenceNo(licenceNo);
			masStoreSupplier.setPinNo(pinNo);

			masStoreSupplier.setAddress1(address1);
			masStoreSupplier.setAddress2(address2);

			if (city != 0) {
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(city);
				masStoreSupplier.setCity(masDistrict);
			} else {
				masStoreSupplier.setCity(null);
			}

			if (state != 0) {
				MasState masState = new MasState();
				masState.setId(state);
				masStoreSupplier.setState(masState);
			} else {
				masStoreSupplier.setState(null);
			}

			masStoreSupplier.setFaxNumber(faxNo);
			masStoreSupplier.setPhoneNo(phoneNo);
			masStoreSupplier.setMobileNo(mobileNo);
			masStoreSupplier.setPinCode(pinCode);

			masStoreSupplier.setEmailId(emailId);
			masStoreSupplier.setUrl(url);
			masStoreSupplier.setLocalAddress1(localAddress1);
			masStoreSupplier.setLocalAddress2(localAddress2);

			if (localCity != 0) {
				MasDistrict masDistrictLocal = new MasDistrict();
				masDistrictLocal.setId(localCity);
				masStoreSupplier.setLocalCity(masDistrictLocal);
			} else {
				masStoreSupplier.setLocalCity(null);
			}

			if (localState != 0) {
				MasState masStateLocal = new MasState();
				masStateLocal.setId(localState);
				masStoreSupplier.setLocalState(masStateLocal);
			} else {
				masStoreSupplier.setLocalState(null);
			}

			masStoreSupplier.setLocalPinCode(localPinCode);
			masStoreSupplier.setLocalPhoneNo(localPhoneNo);

			masStoreSupplier.setCfLocalDistributorName(cfDistributorName);
			masStoreSupplier
					.setCfLocalDistributorAddress1(cfDistributorAddress1);
			masStoreSupplier
					.setCfLocalDistributorAddress2(cfDistributorAddress2);
			masStoreSupplier.setFdrReceiptAttached(fdrReceiptAttached);

			masStoreSupplier.setLastChgBy(changedBy);
			masStoreSupplier.setLastChgDate(currentDate);
			masStoreSupplier.setLastChgTime(currentTime);

			hbt.update(masStoreSupplier);

			/*
			 * If supplier type is Manufacturer, then the same record will be
			 * stored in Mas Manufacturer table also apart from
			 * mas_store_Supplier.
			 */

			if (storeSupplierTypeId == 2) {
				List masManfList = new ArrayList<MasManufacturer>();
				masManfList = session.createCriteria(MasManufacturer.class)
						.add(
								Restrictions.eq("ManufacturerCode",
										storeSupplierCode)).list();
				if (masManfList != null && masManfList.size() > 0) {
					MasManufacturer masManufacturer = (MasManufacturer) masManfList
							.get(0);
					masManufacturer.setSalesTaxNo(salesTaxNo);
					masManufacturer.setLicenceNo(licenceNo);
					masManufacturer.setAddress1(address1);
					masManufacturer.setAddress2(address2);
					masManufacturer
							.setCfLocalDistributorName(cfDistributorName);
					masManufacturer
							.setCfLocalDistributorAddress1(cfDistributorAddress1);
					masManufacturer
							.setCfLocalDistributorAddress2(cfDistributorAddress2);

					if (city != 0) {
						MasDistrict masDistrict = new MasDistrict();
						masDistrict.setId(city);
						masStoreSupplier.setCity(masDistrict);
						masManufacturer.setCity(masDistrict);
					} else {
						masStoreSupplier.setCity(null);
						masManufacturer.setCity(null);
					}

					if (state != 0) {
						MasState masState = new MasState();
						masState.setId(state);
						masStoreSupplier.setState(masState);
						masManufacturer.setState(masState);
					} else {
						masStoreSupplier.setState(null);
						masManufacturer.setState(null);
					}

					masManufacturer.setFaxNumber(faxNo);

					masManufacturer.setPhoneno(phoneNo);

					masManufacturer.setMobileno(mobileNo);
					masManufacturer.setPinCode(pinCode);
					masManufacturer.setEmailId(emailId);
					masManufacturer.setUrl(url);
					masManufacturer.setLastChgBy(changedBy);
					masManufacturer.setLastChgDate(currentDate);
					masManufacturer.setLastChgTime(currentTime);
					hbt.update(masManufacturer);
				}
			}
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStoreSupplierJsp(Map<String, Object> dataMap) {
		List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();

		List<MasStoreSupplierType> masStoreSupplierTypeList = new ArrayList<MasStoreSupplierType>();
		List<MasStoreSupplierType> gridStoreSupplierTypeList = new ArrayList<MasStoreSupplierType>();

		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<MasStoreGroup> gridMasStoreGroupList = new ArrayList<MasStoreGroup>();

		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		List<MasManufacturer> gridManufacturerList = new ArrayList<MasManufacturer>();

		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();

		List<MasDistrict> localDistrictList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridLocalDistrictList = new ArrayList<MasDistrict>();
		List<MasState> localStateList = new ArrayList<MasState>();
		List<MasState> gridLocalStateList = new ArrayList<MasState>();
		List<MasStoreSupplierGroup> masStoreSupplierGroupList = new ArrayList<MasStoreSupplierGroup>();
		List<MasStoreVendorWiseManufacturer> masStoreVendorWiseManufacturerList = new ArrayList<MasStoreVendorWiseManufacturer>();
		Session session = null;
		Map map = new HashMap();
		int hospitalId=0;
		int deptId=0;
	
		try {
			session = (Session) getSession();
			String qry = "SELECT substring(supplier_code,2,10)  as num, supplier_code FROM mas_store_supplier order by supplier_id";
		
		hospitalId=(Integer)dataMap.get("hospitalId");
		deptId=(Integer)dataMap.get("deptId");
		
			String vendor_code = "V1";
			List objectList = (List) session.createSQLQuery(qry).list();
			if (objectList != null && objectList.size() > 0) {
				Object[] pair = (Object[]) objectList.get(objectList.size() - 1);
				if(pair[0]!=null){
					int no = Integer.parseInt((String)pair[0]) + 1;
					vendor_code = "V" + no;
				}
			}
			gridDistrictList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDistrict as isc");
			districtList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasDistrict as isc where isc.Status = 'y' order by isc.DistrictName asc ");

			gridStateList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasState as isc");
			stateList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasState as isc where isc.Status = 'y' order by isc.StateName asc");

			gridLocalDistrictList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDistrict as isc");
			localDistrictList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasDistrict as isc where isc.Status = 'y' order by isc.DistrictName asc ");

			gridLocalStateList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasState as isc");
			localStateList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasState as isc where isc.Status = 'y' order by isc.StateName asc ");

			masStoreSupplierList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSupplier as isc  order by isc.Id desc "
					
					
					//+ "as mss where mss.Hospital.Id='"+hospitalId+"'"
					);
			masStoreSupplierTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSupplierType as id order by id.SupplierTypeName asc");
			gridStoreSupplierTypeList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreSupplierType as mit where mit.Status = 'y'");

			manufacturerList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasManufacturer "
					//+ "as mf where mf.Hospital.Id='"+hospitalId+"'"
					);
			gridManufacturerList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasManufacturer as mit where mit.Status = 'y' ");
							//+ "and mit.Hospital.Id='"+hospitalId+"'");

			masStoreGroupList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreGroup as id order by id.GroupName asc ");
			gridMasStoreGroupList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreGroup as mit where mit.Status = 'y'");

			masStoreSupplierGroupList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSupplierGroup ");
			masStoreVendorWiseManufacturerList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreVendorWiseManufacturer ");

			map.put("districtList", districtList);
			map.put("gridDistrictList", gridDistrictList);
			map.put("stateList", stateList);
			map.put("gridStateList", gridStateList);
			map.put("gridLocalStateList", gridLocalStateList);
			map.put("localStateList", localStateList);
			map.put("gridLocalDistrictList", gridLocalDistrictList);
			map.put("localDistrictList", localDistrictList);
			map.put("masStoreSupplierList", masStoreSupplierList);
			map.put("masStoreSupplierTypeList", masStoreSupplierTypeList);
			map.put("gridStoreSupplierTypeList", gridStoreSupplierTypeList);
			map.put("manufacturerList", manufacturerList);
			map.put("gridManufacturerList", gridManufacturerList);

			map.put("masStoreGroupList", masStoreGroupList);
			map.put("gridMasStoreGroupList", gridMasStoreGroupList);
			map.put("masStoreSupplierGroupList", masStoreSupplierGroupList);
			map.put("masStoreVendorWiseManufacturerList",masStoreVendorWiseManufacturerList);
			map.put("vendor_code", vendor_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map searchStoreSupplier(String storeSupplierCode,
			String storeSupplierName,int hospitalId,int deptId) {
		List masStoreSupplierList = new ArrayList();
		List masStoreSupplierTypeList = new ArrayList();
		List<MasManufacturer> manufacturerList = null;
		List<MasManufacturer> gridManufacturerList = null;

		List<MasDistrict> districtList = null;
		List<MasDistrict> gridDistrictList = null;
		List<MasState> stateList = null;
		List<MasState> gridStateList = null;

		List<MasDistrict> localDistrictList = null;
		List<MasDistrict> gridLocalDistrictList = null;
		List<MasState> localStateList = null;
		List<MasState> gridLocalStateList = null;
		Map map = new HashMap();
		List gridStoreSupplierTypeList = new ArrayList();

		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<MasStoreGroup> gridMasStoreGroupList = new ArrayList<MasStoreGroup>();

		List<MasStoreSupplierGroup> masStoreSupplierGroupList = new ArrayList<MasStoreSupplierGroup>();
		List<MasStoreVendorWiseManufacturer> masStoreVendorWiseManufacturerList = new ArrayList<MasStoreVendorWiseManufacturer>();

		try {
			if ((storeSupplierName != null) || (storeSupplierCode == null)) {
				masStoreSupplierList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreSupplier ms where ms.SupplierName like '%"
										+ storeSupplierName
										+ "%' and ms.Hospital.Id='"+hospitalId+"' order by ms.SupplierName");

			} else {
				masStoreSupplierList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreSupplier sc where sc.SupplierCode like '%"
										+ storeSupplierCode
										+ "%' and sc.Hospital.Id='"+hospitalId+"' order by sc.SupplierCode");

			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		masStoreSupplierTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreSupplierType as mit where mit.Status = 'y'");

		gridStoreSupplierTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreSupplierType as MasStoreSupplierType");

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

		gridLocalDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict as isc");
		localDistrictList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDistrict as isc where isc.Status = 'y'");

		gridLocalStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState as isc");
		localStateList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasState as isc where isc.Status = 'y'");

		manufacturerList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasManufacturer "
				//+ "as id where id.Hospital.Id='"+hospitalId+"'"
				);
		gridManufacturerList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasManufacturer as mit where mit.Status = 'y' "
						//+ "and mit.Hospital.Id='"+hospitalId+"'"
						);

		masStoreGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreGroup as id");
		gridMasStoreGroupList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreGroup as mit where mit.Status = 'y'");

		masStoreSupplierGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreSupplierGroup ");
		masStoreVendorWiseManufacturerList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreVendorWiseManufacturer ");

		map.put("districtList", districtList);
		map.put("gridDistrictList", gridDistrictList);
		map.put("stateList", stateList);
		map.put("gridStateList", gridStateList);
		map.put("gridLocalStateList", gridLocalStateList);
		map.put("localStateList", localStateList);
		map.put("gridLocalDistrictList", gridLocalDistrictList);
		map.put("localDistrictList", localDistrictList);
		map.put("manufacturerList", manufacturerList);
		map.put("gridManufacturerList", gridManufacturerList);
		map.put("masStoreSupplierList", masStoreSupplierList);
		map.put("masStoreSupplierTypeList", masStoreSupplierTypeList);
		map.put("gridStoreSupplierTypeList", gridStoreSupplierTypeList);

		map.put("masStoreGroupList", masStoreGroupList);
		map.put("gridMasStoreGroupList", gridMasStoreGroupList);
		map.put("masStoreSupplierGroupList", masStoreSupplierGroupList);
		map.put("masStoreVendorWiseManufacturerList",
				masStoreVendorWiseManufacturerList);

		return map;
	}

	// ------------------------------ Supplier Type ---------------------

	public boolean addStoreSupplierType(
			MasStoreSupplierType masStoreSupplierType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreSupplierType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchStoreSupplierType(
			String storeSupplierTypeCode, String storeSupplierTypeName) {

		List<MasStoreSupplierType> searchStoreSupplierTypeList = new ArrayList<MasStoreSupplierType>();
		Map<String, Object> storeSupplierTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((storeSupplierTypeName != null)
					|| (storeSupplierTypeCode == null)) {
				searchStoreSupplierTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreSupplierType imc where imc.SupplierTypeName like '"
										+ storeSupplierTypeName
										+ "%' order by imc.SupplierTypeName");
			} else {
				searchStoreSupplierTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreSupplierType imc where imc.SupplierTypeCode like '"
										+ storeSupplierTypeCode
										+ "%' order by imc.SupplierTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		storeSupplierTypeFieldsMap.put("searchStoreSupplierTypeList",
				searchStoreSupplierTypeList);
		return storeSupplierTypeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStoreSupplierTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplierType> searchStoreSupplierTypeList = new ArrayList<MasStoreSupplierType>();
		searchStoreSupplierTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreSupplierType ");
		map.put("searchStoreSupplierTypeList", searchStoreSupplierTypeList);
		return map;
	}

	public boolean editStoreSupplierTypeToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String storeSupplierTypeName = "";
		@SuppressWarnings("unused")
		String storeSupplierTypeCode = "";
		int storeSupplierTypeId = 0;
		String changedBy = "";
		storeSupplierTypeId = (Integer) generalMap.get("id");
		storeSupplierTypeCode = (String) generalMap
				.get("storeSupplierTypeCode");
		storeSupplierTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreSupplierType masStoreSupplierType = (MasStoreSupplierType) getHibernateTemplate()
				.load(MasStoreSupplierType.class, storeSupplierTypeId);

		masStoreSupplierType.setId(storeSupplierTypeId);
		masStoreSupplierType.setSupplierTypeName(storeSupplierTypeName);
		masStoreSupplierType.setLastChgBy(changedBy);

		masStoreSupplierType.setLastChgDate(currentDate);
		masStoreSupplierType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreSupplierType);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteStoreSupplierType(int storeSupplierTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreSupplierType masStoreSupplierType = new MasStoreSupplierType();
		masStoreSupplierType = (MasStoreSupplierType) getHibernateTemplate()
				.load(MasStoreSupplierType.class, storeSupplierTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreSupplierType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreSupplierType.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreSupplierType.setLastChgBy(changedBy);
		masStoreSupplierType.setLastChgDate(currentDate);
		masStoreSupplierType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreSupplierType);
		return dataDeleted;
	}

	// ---------------------------------- Item
	// Category-------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showItemCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = null;
		session = (Session) getSession();
		try {
			List<MasItemCategory> searchItemCategoryList = new ArrayList<MasItemCategory>();
			List<MasStoreSection> sectionCodeList = new ArrayList<MasStoreSection>();
			List<MasStoreSection> gridSectionList = new ArrayList<MasStoreSection>();
			searchItemCategoryList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasItemCategory ");
			gridSectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection as id");
			
			sectionCodeList = session.createCriteria(MasStoreSection.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("searchItemCategoryList", searchItemCategoryList);
			map.put("sectionCodeList", sectionCodeList);
			map.put("gridSectionList", gridSectionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public boolean addItemCategory(MasItemCategory masItemCategory) {
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masItemCategory);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteItemCategory(int itemCategoryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasItemCategory masItemCategory = new MasItemCategory();
			masItemCategory = (MasItemCategory) getHibernateTemplate().load(
					MasItemCategory.class, itemCategoryId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			Integer sectionId = masItemCategory.getSection().getId();

			if (generalMap.get("flag") != null) {
				List sectionCodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreSection as a where a.Id='"
								+ sectionId + "' and a.Status='y'");
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masItemCategory.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masItemCategory.setStatus("y");
					dataDeleted = false;
				}
			}
			masItemCategory.setLastChgBy(changedBy);
			masItemCategory.setLastChgDate(currentDate);
			masItemCategory.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masItemCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public boolean editItemCategoryToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int sectionId = 0;
		String itemCategoryName = "";
		@SuppressWarnings("unused")
		String itemCategoryCode = "";
		int itemCategoryId = 0;
		String changedBy = "";
		itemCategoryId = (Integer) generalMap.get("id");
		itemCategoryCode = (String) generalMap.get("itemCategoryCode");
		itemCategoryName = (String) generalMap.get("name");
		sectionId = (Integer) generalMap.get("sectionId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasItemCategory masItemCategory = (MasItemCategory) getHibernateTemplate()
				.load(MasItemCategory.class, itemCategoryId);

		masItemCategory.setId(itemCategoryId);
		masItemCategory.setItemCategoryName(itemCategoryName);

		MasStoreSection masStoreSection = new MasStoreSection();
		masStoreSection.setId(sectionId);
		masItemCategory.setSection(masStoreSection);

		masItemCategory.setLastChgBy(changedBy);
		masItemCategory.setLastChgDate(currentDate);
		masItemCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masItemCategory);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map searchItemCategory(String itemCategoryCode,
			String itemCategoryName) {
		List<MasItemCategory> searchItemCategoryList = new ArrayList<MasItemCategory>();
		List sectionCodeList = null;
		Map itemCategoryFieldsMap = new HashMap();
		Session session = null;
		session = (Session) getSession();
		List gridSectionList = null;
		try {
			if ((itemCategoryName != null) || (itemCategoryCode == null)) {
				searchItemCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasItemCategory sc where sc.ItemCategoryName like'"
										+ itemCategoryName
										+ "' order by sc.ItemCategoryName");
			} else {
				searchItemCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasItemCategory sc where sc.ItemCategoryCode like '"
										+ itemCategoryCode
										+ "' order by sc.ItemCategoryCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("searchItemCategoryList"+searchItemCategoryList.size());
		sectionCodeList = session.createCriteria(MasStoreSection.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		gridSectionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreSection as SectionCode");
		itemCategoryFieldsMap.put("gridSectionList", gridSectionList);
		itemCategoryFieldsMap.put("searchItemCategoryList",	searchItemCategoryList);
		itemCategoryFieldsMap.put("sectionCodeList", sectionCodeList);
		return itemCategoryFieldsMap;

	}

	// ----------------------------------Sales
	// Type-------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showSalesTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSalesType> searchSalesTypeList = new ArrayList<MasSalesType>();
		searchSalesTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSalesType ");
		map.put("searchSalesTypeList", searchSalesTypeList);
		return map;
	}

	public boolean addSalesType(MasSalesType masSalesType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masSalesType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteSalesType(Integer salesTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasSalesType masSalesType = new MasSalesType();
		masSalesType = (MasSalesType) getHibernateTemplate().load(
				MasSalesType.class, salesTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masSalesType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masSalesType.setStatus("y");
				dataDeleted = false;
			}
		}
		masSalesType.setLastChgBy(changedBy);
		masSalesType.setLastChgDate(currentDate);
		masSalesType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSalesType);
		return dataDeleted;
	}

	public boolean editSalesType(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int salesTypeId = 0;
		String salesTypeName = "";
		@SuppressWarnings("unused")
		String salesTypeCode = "";
		int salesTypeValue = 0;
		String changedBy = "";
		try {
			salesTypeId = (Integer) generalMap.get("id");
			salesTypeCode = (String) generalMap.get("salesTypeCode");
			salesTypeName = (String) generalMap.get("name");
			salesTypeValue = (Integer) generalMap.get("salesTypeValue");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			MasSalesType masSalesType = (MasSalesType) getHibernateTemplate()
					.load(MasSalesType.class, salesTypeId);

			masSalesType.setId(salesTypeId);
			masSalesType.setSalesTypeCode(salesTypeCode);
			masSalesType.setSalesTypeName(salesTypeName);

			masSalesType.setSalesTypeValue(salesTypeValue);
			masSalesType.setLastChgBy(changedBy);
			masSalesType.setLastChgDate(currentDate);
			masSalesType.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masSalesType);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map searchSalesType(String salesTypeCode, String salesTypeName) {
		List searchSalesTypeList = new ArrayList();
		Map salesTypeFieldMap = new HashMap();
		try {
			if ((salesTypeName != null) || (salesTypeCode == null)) {
				searchSalesTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasSalesType sc where sc.SalesTypeName like '"
								+ salesTypeName
								+ "%' order by sc.SalesTypeName");
			} else {
				searchSalesTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasSalesType sc where sc.SalesTypeCode like '"
								+ salesTypeCode
								+ "%' order by sc.SalesTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		salesTypeFieldMap.put("searchSalesTypeList", searchSalesTypeList);
		return salesTypeFieldMap;
	}

	// ---------------------------------- Item
	// Class-------------------------------------
	/*
	 * @SuppressWarnings("unchecked") public Map<String, Object>
	 * showItemClassJsp() { Map<String,Object> map=new HashMap<String,Object>();
	 * try{ List<MasItemClass> searchItemClassList = new
	 * ArrayList<MasItemClass>(); List<MasItemType> itemTypeCodeList = new
	 * ArrayList<MasItemType>(); List<MasItemType> gridItemTypeList = new
	 * ArrayList<MasItemType>(); searchItemClassList =
	 * getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasItemClass "); gridItemTypeList =
	 * getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasItemType as id"); itemTypeCodeList =
	 * getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasItemType as mc where mc.Status = 'y'");
	 *
	 * map.put("searchItemClassList",searchItemClassList);
	 * map.put("itemTypeCodeList",itemTypeCodeList);
	 * map.put("gridItemTypeList",gridItemTypeList); }catch (Exception e) {
	 * //System.out.println("Exception---------> "+e); } return map; }
	 *
	 * public boolean addItemClass(MasItemClass masItemClass) { boolean
	 * successfullyAdded=false; try {
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_AUTO");
	 * hbt.setCheckWriteOperations(false); hbt.save(masItemClass);
	 * successfullyAdded = true; } catch (DataAccessException e) {
	 * e.printStackTrace(); } return successfullyAdded; }
	 *
	 * @SuppressWarnings("unchecked") public boolean deleteItemClass(int
	 * itemClassId,Map<String, Object> generalMap) { boolean dataDeleted=false;
	 * String changedBy = ""; Date currentDate = new Date(); String currentTime
	 * = ""; currentTime =
	 * (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); try{
	 * MasItemClass masItemClass= new MasItemClass();
	 * masItemClass=(MasItemClass)
	 * getHibernateTemplate().load(MasItemClass.class,itemClassId); changedBy =
	 * (String)generalMap.get("changedBy");
	 * currentDate=(Date)generalMap.get("currentDate");
	 * currentTime=(String)generalMap.get("currentTime"); Integer
	 * itemTypecodeId=masItemClass.getItemType().getId(); if
	 * (masItemClass.getStatus().equals("y")){
	 *
	 * @SuppressWarnings("unused") List
	 * itemTypecodeList=getHibernateTemplate().find
	 * ("from jkt.hms.masters.business.MasItemType as itemType where itemType.Id='"
	 * +itemTypecodeId+"' and itemType.Status='y'");
	 * masItemClass.setStatus("n"); dataDeleted=true; }else{
	 * masItemClass.setStatus("y"); dataDeleted=false; }
	 * masItemClass.setLastChgBy(changedBy);
	 * masItemClass.setLastChgDate(currentDate);
	 * masItemClass.setLastChgTime(currentTime);
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); hbt.update(masItemClass); }catch
	 * (Exception e) { //System.out.println("exc in DS "+e); } return dataDeleted;
	 * }
	 *
	 * public boolean editItemClassToDatabase(Map<String, Object> generalMap) {
	 * boolean dataUpdated=false; Date currentDate = new Date(); String
	 * currentTime = ""; currentTime =
	 * (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); int
	 * itemTypeId=0; String itemClassName="";
	 *
	 * @SuppressWarnings("unused") String itemClassCode=""; int itemClassId=0;
	 * String changedBy = ""; itemClassId=(Integer)generalMap.get("id");
	 * itemClassCode=(String)generalMap.get("itemClassCode");
	 * itemClassName=(String)generalMap.get("name");
	 * itemTypeId=(Integer)generalMap.get("itemTypeId"); changedBy =
	 * (String)generalMap.get("changedBy");
	 * currentDate=(Date)generalMap.get("currentDate");
	 * currentTime=(String)generalMap.get("currentTime"); MasItemClass
	 * masItemClass
	 * =(MasItemClass)getHibernateTemplate().load(MasItemClass.class,
	 * itemClassId);
	 *
	 * masItemClass.setId(itemClassId);
	 * masItemClass.setItemClassName(itemClassName); MasItemType masItemType=
	 * new MasItemType(); masItemType.setId(itemTypeId);
	 * masItemClass.setItemType(masItemType);
	 * masItemClass.setLastChgBy(changedBy);
	 * masItemClass.setLastChgDate(currentDate);
	 * masItemClass.setLastChgTime(currentTime);
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); hbt.update(masItemClass); dataUpdated
	 * = true; return dataUpdated; }
	 *
	 * @SuppressWarnings("unchecked") public Map searchItemClass(String
	 * itemClassCode,String itemClassName) { List<MasItemClass>
	 * searchItemClassList=new ArrayList<MasItemClass>(); List
	 * itemTypeCodeList=null; Map itemClassFieldsMap = new HashMap(); List
	 * gridItemTypeList=null; try{ if((itemClassName!=null) ||
	 * (itemClassCode==null)){searchItemClassList=getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasItemClass sc where sc.ItemClassName like '"
	 * + itemClassName+"%' order by sc.ItemClassName"); } else{
	 * searchItemClassList=getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasItemClass sc where sc.ItemClassCode like '"
	 * + itemClassCode+"%' order by sc.ItemClassCode");} }catch (Exception e) {
	 * //System.out.println("Ds excp in searchItemClass  "+e); }
	 * itemTypeCodeList=getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasItemType as mc where mc.Status = 'y'");
	 * gridItemTypeList=getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasItemType as ItemTypeCode");
	 * itemClassFieldsMap.put("gridItemTypeList",gridItemTypeList);
	 * itemClassFieldsMap.put("searchItemClassList",searchItemClassList);
	 * itemClassFieldsMap.put("itemTypeCodeList",itemTypeCodeList); return
	 * itemClassFieldsMap;
	 *
	 * }
	 */

	// ----------------------------- Item Wise
	// Supplier-----------------------------------

	/*
	 * @SuppressWarnings("unchecked") public Map<String, Object>
	 * getItemWiseSupplier() { List<MasStoreSupplier> masItemWiseSupplierList =
	 * new ArrayList<MasStoreSupplier>();
	 *
	 * @SuppressWarnings("unused") List<MasStoreItem> masItemList = new
	 * ArrayList<MasStoreItem>(); List<MasStoreItem> gridItemList = new
	 * ArrayList<MasStoreItem>(); List<MasStoreSupplier> masSupplierList = new
	 * ArrayList<MasStoreSupplier>(); List<MasStoreSupplier> gridSupplierList =
	 * new ArrayList<MasStoreSupplier>(); Map<String,Object> map=new
	 * HashMap<String,Object>(); try{ masItemWiseSupplierList =
	 * getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasItemWiseSupplier");
	 *
	 * masSupplierList = getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreSupplier as id"); gridSupplierList
	 * = getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreSupplier as mss where mss.Status = 'y'"
	 * );
	 *
	 * masItemList = getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreItem as id"); gridItemList =
	 * getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreItem as mst where mst.Status = 'y'"
	 * );
	 *
	 * map.put("masItemWiseSupplierList",masItemWiseSupplierList);
	 * map.put("masItemList",masItemList); map.put("gridItemList",gridItemList);
	 * map.put("masSupplierList",masSupplierList);
	 * map.put("gridSupplierList",gridSupplierList); }catch (Exception e) {
	 * //System.out.println("exp in ds getSupplier "+e); } return map; }
	 *
	 * public boolean addItemWiseSupplier(MasItemWiseSupplier
	 * masItemWiseSupplier) { boolean saveFlag = false; try{
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_AUTO");
	 * hbt.setCheckWriteOperations(false); hbt.save(masItemWiseSupplier);
	 * saveFlag = true; }catch (Exception e) {
	 * //System.out.println("Ds Exception in PharmacyMasterDataService"+e); }
	 * return saveFlag; }
	 *
	 * @SuppressWarnings("unchecked") public boolean
	 * deleteItemWiseSupplier(Integer itemWiseSupplierId,Map<String, Object>
	 * generalMap) { boolean dataDeleted=false; String changedBy = ""; Date
	 * currentDate = new Date(); String currentTime = ""; currentTime =
	 * (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	 * MasItemWiseSupplier masItemWiseSupplier= new MasItemWiseSupplier();
	 * masItemWiseSupplier
	 * =(MasItemWiseSupplier)getHibernateTemplate().load(MasItemWiseSupplier
	 * .class,itemWiseSupplierId); changedBy =
	 * (String)generalMap.get("changedBy");
	 * currentDate=(Date)generalMap.get("currentDate");
	 * currentTime=(String)generalMap.get("currentTime"); if
	 * (masItemWiseSupplier.getStatus().equals("y")){
	 * masItemWiseSupplier.setStatus("n"); dataDeleted=true; }else{
	 * masItemWiseSupplier.setStatus("y"); dataDeleted=false; }
	 * masItemWiseSupplier.setLastChgBy(changedBy);
	 * masItemWiseSupplier.setLastChgDate(currentDate);
	 * masItemWiseSupplier.setLastChgTime(currentTime);
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); hbt.update(masItemWiseSupplier);
	 * return dataDeleted; }
	 *
	 * public boolean editItemWiseSupplier(Map<String, Object> generalMap) {
	 * boolean dataUpdated = false; int itemWiseId=0; int itemId=0; int
	 * supplierId=0; Date changedDate = new Date(); String changedTime = "";
	 * String changedBy = null;
	 *
	 * itemWiseId=(Integer)generalMap.get("itemWiseId");
	 * itemId=(Integer)generalMap.get("itemId");
	 * supplierId=(Integer)generalMap.get("supplierId");
	 *
	 * changedTime=(String)generalMap.get("changedTime");
	 * changedBy=(String)generalMap.get("changedBy");
	 * changedDate=(Date)generalMap.get("changedDate");
	 *
	 * MasItemWiseSupplier
	 * masSupplierItemWiseSupplier=(MasItemWiseSupplier)getHibernateTemplate
	 * ().load(MasItemWiseSupplier.class,itemWiseId); try{
	 * masSupplierItemWiseSupplier.setId(itemWiseId); MasStoreItem masItem=new
	 * MasStoreItem(); masItem.setId(itemId);
	 * masSupplierItemWiseSupplier.setItem(masItem);
	 *
	 * MasStoreSupplier masSupplier=new MasStoreSupplier();
	 * masSupplier.setId(supplierId);
	 * masSupplierItemWiseSupplier.setSupplier(masSupplier);
	 *
	 * masSupplierItemWiseSupplier.setLastChgBy(changedBy);
	 * masSupplierItemWiseSupplier.setLastChgDate(changedDate);
	 * masSupplierItemWiseSupplier.setLastChgTime(changedTime); }catch
	 * (Exception e) {
	 * //System.out.println("Exception                                             "
	 * +e); } org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false);
	 * hbt.update(masSupplierItemWiseSupplier); dataUpdated = true;
	 *
	 * return dataUpdated; }
	 *
	 * @SuppressWarnings("unchecked") public Map searchItemWiseSupplier(String
	 * itemName,String supplier1) {
	 *
	 * @SuppressWarnings("unused") List item = new ArrayList(); List
	 * masItemWiseSupplierList = new ArrayList();
	 *
	 * List masSupplierList = new ArrayList(); List gridSupplierList = new
	 * ArrayList(); List masItemList = new ArrayList(); List gridItemList = new
	 * ArrayList();
	 *
	 * List itemList = new ArrayList();
	 *
	 * @SuppressWarnings("unused") List supplierList = new ArrayList(); Map map
	 * = new HashMap();
	 *
	 * @SuppressWarnings("unused") List gridSupplierTypeList = new ArrayList();
	 * int itemId=0; int SupplieId=0;
	 *
	 * try{ if((itemName!=null) || (supplier1==null)){ itemList =
	 * getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreItem as ms where ms.Nomenclature like '"
	 * + itemName+"%' order by ms.Nomenclature"); Iterator
	 * iterator=itemList.iterator(); MasStoreItem masItem =
	 * (MasStoreItem)iterator.next(); itemId=masItem.getId();
	 * masItemWiseSupplierList =getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasItemWiseSupplier ms where ms.Item like '"
	 * + itemId+"%' order by ms.Item");
	 *
	 * }else{supplierList=getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreSupplier as  ms where ms.SupplierName like '"
	 * + supplier1+"%' order by ms.SupplierName"); Iterator
	 * iterator2=itemList.iterator(); MasStoreSupplier
	 * masSupplier=(MasStoreSupplier)iterator2.next();
	 * SupplieId=masSupplier.getId();
	 * //System.out.println("SupplieId    "+SupplieId); masItemWiseSupplierList =
	 * getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasItemWiseSupplier sc where sc.Supplier like '"
	 * + SupplieId+"%' order by sc.Supplier");
	 *
	 * } }catch (Exception e) { //System.out.println("Exception ------>"+e); }
	 *
	 * masSupplierList = getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreSupplier as id"); gridSupplierList
	 * = getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreSupplier as mit where mit.Status = 'y'"
	 * );
	 *
	 * masItemList = getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreItem as id"); gridItemList =
	 * getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreItem as mit where mit.Status = 'y'"
	 * );
	 *
	 * map.put("masItemWiseSupplierList",masItemWiseSupplierList);
	 * map.put("masItemList",masItemList); map.put("gridItemList",gridItemList);
	 * map.put("masSupplierList",masSupplierList);
	 * map.put("gridSupplierList",gridSupplierList); return map; } public
	 * Map<String, Object> searchItemWiseSupplier(String itemWiseSupplierCode,
	 * String itemWiseSupplierName) { // TODO Auto-generated method stub return
	 * null; }
	 *
	 * @SuppressWarnings("unchecked") public boolean checkItem(int itemId) {
	 * List tempList=new ArrayList(); boolean flag=false;
	 * tempList=getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasItemWiseSupplier as mit where mit.Id='"
	 * +itemId+"' "); if(tempList.size()==0) { flag=false; }else{ flag=true; }
	 * return flag; }
	 */
	// -----------------------------------------item
	// master---------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showItemJsp(int deptId,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
			List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
			List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
			List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
			List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
			List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
			List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
			List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
			List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
			List<MasStoreBrand> gridBrandList = new ArrayList<MasStoreBrand>();
			List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
			/*String transactionSequenceName = "Item Code";
			List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
			int orderNo = 0;
			sequenceNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionSequenceName",transactionSequenceName)).list();
			TransactionSequence transactionSequence = sequenceNoList.get(0);
			int sequenceNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = sequenceNo + 1;
			*/
			// Criteria c = session.createCriteria(MasStoreItem.class)
			// .add(Restrictions.eq("Department.Id", deptId));
			// c.setFirstResult(0);
			// c.setMaxResults(1000);
			// searchItemList = c.list();
			
			masItemClassList= getHibernateTemplate()
			.find("from jkt.hms.masters.business.MasItemClass where upper(Status) =upper('y')");

			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			int sectionIdForNonDrugs=0;
			try {
				properties.load(resourcePath.openStream());
				sectionIdForNonDrugs = Integer.parseInt(properties.getProperty("SectionIdForDrugs"));
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			

		 	
		 	searchItemList = session.createCriteria(MasStoreItem.class)
		 			.createAlias("ItemClassification", "it").add(Restrictions.eq("it.Id",1))
		 			//.createAlias("ItemType", "it").add(Restrictions.eq("it.ItemTypeName","MEDICAL CONSUMABLE").ignoreCase())
		 			.createAlias("Section", "s").add(Restrictions.eq("s.Id",sectionIdForNonDrugs))
		 			.list();
	
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection as s where upper(s.Status) =upper('y')");
		
			
			itemTypeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemType as mc where upper(mc.Status) = upper('y')");
			itemCategoryList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemCategory as mc where upper(mc.Status) = upper('y')");
			itemConversionList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreItemConversion as mc where upper(mc.Status) = upper('y')");
			groupList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");

			map.put("searchItemList", searchItemList);
			map.put("storeSectionList", sectionList);
			map.put("itemTypeList", itemTypeList);
			map.put("itemCategoryList", itemCategoryList);
			map.put("itemConversionList", itemConversionList);
			map.put("manufacturerList", manufacturerList);
			map.put("storeSupplierList", supplierList);
			map.put("departmentList", departmentList);
			map.put("departmentList1", departmentList1);
			map.put("groupList", groupList);
			map.put("brandList", brandList);
			map.put("gridBrandList", gridBrandList);
			
			map.put("masItemClassList", masItemClassList);
			//map.put("orderNo", orderNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
		/*	List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();

			List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
			List<MasStoreItemGeneric> itemGenericList = new ArrayList<MasStoreItemGeneric>();
			List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
			List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
			List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
			List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
			List<MasItemClass> gridItemClassList = new ArrayList<MasItemClass>();
			List<MasCompany> companyList = new ArrayList<MasCompany>();
			List<MasStoreUnit>uomList=new ArrayList<MasStoreUnit>();
			
			
			 * Commented For Not Displaying Item List //String
			 * query="select * from mas_store_item where department_id='"
			 * +deptId+"'";
			 
			
			 * Criteria c = session.createCriteria(MasStoreItem.class)
			 * .add(Restrictions.eq("Department.Id",deptId ));
			 * c.setFirstResult(0); c.setMaxResults(1000);
			 
			// searchItemList = c.list();
			List<Object> searchItemListforPvms = new ArrayList<Object>();
			
			 * Commented For Not Displaying Item List
			 * //searchItemListforPvms=session.createSQLQuery(query).list();
			 
			for (Iterator iterator = searchItemListforPvms.iterator(); iterator
					.hasNext();) {
				MasStoreItem masStoreItem = new MasStoreItem();
				Object[] object = (Object[]) iterator.next();
				// int srNo = (Integer)object[0];
				masStoreItem.setId((Integer) object[0]);
				masStoreItem.setPvmsNo((String) object[1]);
				if (object[2] != null) {
					MasStoreSection masStoreSection = new MasStoreSection();
					masStoreSection.setId((Integer) object[2]);
					masStoreItem.setSection(masStoreSection);
				}
				masStoreItem.setNomenclature((String) object[3]);
				masStoreItem.setOldNivNo((String) object[29]);
				masStoreItem.setStrength((String) object[36]);
				if (object[37] != null) {
					MasStoreGroup masStoreGroup = new MasStoreGroup();
					masStoreGroup.setId((Integer) object[37]);
					masStoreItem.setGroup(masStoreGroup);
				}
				if (object[4] != null) {
					MasStoreItemGeneric masStoreItemGeneric = new MasStoreItemGeneric();
					masStoreItemGeneric.setId((Integer) object[4]);
					masStoreItem.setItemGeneric(masStoreItemGeneric);
				}
				if (object[31] != null) {
					MasStoreBrand MasStoreBrands = new MasStoreBrand();
					MasStoreBrands.setId((Integer) object[31]);
					masStoreItem.setBrand(MasStoreBrands);
				}
				if (object[5] != null) {
					MasItemType masItemType = new MasItemType();
					masItemType.setId((Integer) object[5]);
					masStoreItem.setItemType(masItemType);
				}
				if (object[6] != null) {
					MasItemCategory masItemCategory = new MasItemCategory();
					masItemCategory.setId((Integer) object[6]);
					masStoreItem.setItemCategory(masItemCategory);
				}
				if (object[7] != null) {
					MasStoreItemConversion masItemConvertion = new MasStoreItemConversion();
					masItemConvertion.setId((Integer) object[7]);
					masStoreItem.setItemConversion(masItemConvertion);
				}
				if (object[22] != null) {
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId((Integer) object[22]);
					masStoreItem.setDepartment(masDepartment);
				}
				masStoreItem.setCostPrice((String) object[10]);
				masStoreItem.setPac((String) object[12]);
				masStoreItem.setNonPac((String) object[30]);
				masStoreItem.setDangerousDrug((String) object[11]);
				masStoreItem.setControlledDrug((String) object[13]);
				masStoreItem.setHighValueDrug((String) object[14]);
				masStoreItem.setRateContractItem((String) object[16]);
				masStoreItem.setSelfLife((String) object[20]);
				masStoreItem.setRol((String) object[17]);
				if (object[15] != null)
				{
					masStoreItem.setSalesTax((Float) object[15]);
				}
				if (object[18] != null)
				{
					masStoreItem.setMaxStock((Float) object[18]);
				}
				if (object[19] != null) {
					masStoreItem.setMinStock((Float) object[19]);
				}

				masStoreItem.setLeadTime((String) object[21]);
				masStoreItem.setLocation((String) object[23]);
				masStoreItem.setSpecification((String) object[24]);
				masStoreItem.setSourceOfSupply((String) object[32]);
				if (object[33] != null) {
					masStoreItem.setSlowMovingDays((Integer) object[33]);
				}
				if (object[34] != null) {
					masStoreItem.setFastMovingDays((Integer) object[34]);
				}
				if (object[35] != null) {
					masStoreItem.setNonMovingDays((Integer) object[35]);
				}
				
				masStoreItem.setExpiry((String) object[38]);
				masStoreItem.setAllergy((String) object[39]);
				masStoreItem.setLastChgBy((String) object[26]);
				if (object[27] != null) {
					masStoreItem.setLastChgDate((Date) object[27]);
				}
				masStoreItem.setLastChgTime((String) object[28]);
				masStoreItem.setStatus((String) object[25]);
				masStoreItem.setSophisticatedItem((String) object[40]);
				masStoreItem.setPppItem((String) object[41]);
				searchItemList.add(masStoreItem);

			}
			
			 * for(String ms:searchItemListforPvms){ MasStoreItem msa=new
			 * MasStoreItem(); msa.setPvmsNo(ms); searchItemList.add(msa); }
			 
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection as id order by id.SectionName asc");
			uomList=getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreUnit as msu where msu.Status='y' order by msu.UnitName asc");
			itemGenericList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreItemGeneric as id");
			itemTypeList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasItemType as mc where mc.Status = 'y'");
			itemCategoryList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasItemCategory as mc where mc.Status = 'y' order by mc.ItemCategoryName asc ");
			itemConversionList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreItemConversion as mc where mc.Status = 'y' order by mc.ItemUnitName asc ");
			departmentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y' order by mc.DepartmentName asc");
			groupList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreGroup as mg where mg.Status = 'y' order by mg.GroupName asc");
			masItemClassList=session.createCriteria(MasItemClass.class).add(Restrictions.eq("Status", "y")).list();
			companyList=session.createCriteria(MasCompany.class).add(Restrictions.eq("Status", "y")).list();
			
			
			//List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
			
			//itemCodeList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo", "NIV%")).add(Restrictions.eq("Hospital.Id", hospitalId))
			//.addOrder(Order.desc("Id")).setMaxResults(1).list();
			List itemCodeList = new ArrayList();
			//itemCodeList=session.createSQLQuery("select max(to_number(subStr(pvms_no,5))) from mas_store_item mas where mas.ITEM_TYPE_ID=2 and mas.HOSPITAL_ID='"+hospitalId+"' and REGEXP_LIKE(subStr(pvms_no,5),'^-?[[:digit:],.]*$')").list();
			String itemNo = "";
			if(itemCodeList.size()>0){
				String itemCode =itemCodeList.get(0).toString();
				//String itemCode = masStoreItem.getPvmsNo();
				//StringTokenizer str = new StringTokenizer(itemCode, "/");
				//String itemNivCode = "";
				//while (str.hasMoreTokens()) {

				//	itemNivCode = str.nextToken();

				//}
				int itemNiv =Integer.parseInt(itemCode)+1;
				itemNo = "NIV/"+itemNiv;
			}else{
				itemNo = "NIV/011"; 
			}
			map.put("itemNo",itemNo);
			map.put("searchItemList", searchItemList);
			map.put("storeSectionList", sectionList);
			map.put("itemGenericList", itemGenericList);
			map.put("itemTypeList", itemTypeList);
			map.put("itemCategoryList", itemCategoryList);
			map.put("itemConversionList", itemConversionList);
			map.put("departmentList", departmentList);
			map.put("groupList", groupList);
			map.put("masItemClassList", masItemClassList);
			map.put("gridItemClassList", gridItemClassList);
			map.put("companyList", companyList);
			map.put("uomList",uomList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;*/
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchItem(String pvmsNo, String nomenclature,
			int deptId, String sectionCode,int hospitalId,int ItemType) {
		List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
		Map<String, Object> itemFieldsMap = new HashMap<String, Object>();
		List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
		List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
		List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
		List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
		Session session = (Session) getSession();
		List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		int sectionIdForNonDrugs=0;
		try {
			properties.load(resourcePath.openStream());
			sectionIdForNonDrugs = Integer.parseInt(properties.getProperty("SectionIdForDrugs"));
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		try {
			if ((pvmsNo != null)) {
	
				
			 	searchItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo","%"+pvmsNo+"%").ignoreCase()).addOrder(Order.asc("PvmsNo"))
			 			.createAlias("ItemClassification", "it").add(Restrictions.eq("it.Id",1))
			 			.createAlias("Section", "s").add(Restrictions.eq("s.Id",sectionIdForNonDrugs))			 			
			 			.list();
			}

			if ((nomenclature != null)) {

			 	searchItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature","%"+nomenclature+"%").ignoreCase()).addOrder(Order.asc("Nomenclature"))
			 			.createAlias("ItemClassification", "it").add(Restrictions.eq("it.Id",1))
			 			.createAlias("Section", "s").add(Restrictions.eq("s.Id",sectionIdForNonDrugs))
			 			.list();
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		storeSectionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreSection as mr where  upper(mr.Status) =upper('y')");
		
		itemTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemType as mbs where  upper(mbs.Status) =upper('y')");
		itemConversionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreItemConversion as mbs where upper(mbs.Status) =upper('y')");
		itemCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemCategory as mbs where  upper(mbs.Status) =upper('y')");
		
		groupList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");
		masItemClassList= getHibernateTemplate()
		.find("from jkt.hms.masters.business.MasItemClass where upper(Status) =upper('y')");


		itemFieldsMap.put("searchItemList", searchItemList);
		itemFieldsMap.put("masItemClassList", masItemClassList);
		itemFieldsMap.put("storeSectionList", storeSectionList);
		itemFieldsMap.put("itemTypeList", itemTypeList);
		itemFieldsMap.put("itemConversionList", itemConversionList);
		itemFieldsMap.put("itemCategoryList", itemCategoryList);
		itemFieldsMap.put("groupList", groupList);
		
		return itemFieldsMap;
	}
	
	
	
	public List checkNivNo(Map testMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
		String nivNo = "";
		int hospitalId=0;
		String name="";
		Session session = (Session) getSession();
		if(testMap.get("hospitalId")!=null)
		{
			hospitalId=Integer.parseInt(""+testMap.get("hospitalId"));
		}
		if(testMap.get("name")!=null)
		{
			name=testMap.get("name").toString();
		}
		if(testMap.get("pvms")!=null)
		{
			nivNo=(String)testMap.get("pvms");
		}
		
		
		masStoreItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.eq("PvmsNo", nivNo.trim()).ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		
		
		/*masStoreItemList = session.createCriteria(MasStoreItem.class).add(
				Restrictions.eq("Nomenclature", name.trim()).ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
       System.out.println("this list"+masStoreItemList.size());	*/
		
       
		return masStoreItemList;
	}
	
	
	
	
	public List checkNomenclature(Map testMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
		String nivNo = "";
		int hospitalId=0;
		String name="";
		Session session = (Session) getSession();
		if(testMap.get("hospitalId")!=null)
		{
			hospitalId=Integer.parseInt(""+testMap.get("hospitalId"));
		}
		if(testMap.get("name")!=null)
		{
			name=testMap.get("name").toString();
		}
		if(testMap.get("pvms")!=null)
		{
			nivNo=(String)testMap.get("pvms");
		}
		
		
		/*
		 masStoreItemList = session.createCriteria(MasStoreItem.class)
		.add(Restrictions.eq("PvmsNo", nivNo.trim()).ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		*/
	
		
		
		masStoreItemList = session.createCriteria(MasStoreItem.class).add(
				Restrictions.eq("Nomenclature", name.trim()).ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		
       
		return masStoreItemList;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	public boolean addItem(MasStoreItem masItem) {
		boolean successfullyAdded = false;

		Session session = (Session) getSession();
		Transaction tx = null;
	try {
			tx = session.beginTransaction();
			
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			hbt.save(masItem);
			hbt.refresh(masItem);
			
			successfullyAdded = true;

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteItem(Integer itemId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasStoreItem masItem = new MasStoreItem();
			masItem = (MasStoreItem) getHibernateTemplate().load(
					MasStoreItem.class, itemId);
			userId = (Integer) generalMap.get("userId");
			Users user = new Users();
			user.setId(userId);
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			// Integer itemTypeId=masItem.getItemType().getId();
			// Integer itemGenericId=masItem.getItemGeneric().getId();
			if (generalMap.get("flag") != null) {
				// List
				// itemTypeList=getHibernateTemplate().find("from jkt.hms.masters.business.MasItemType as itemType where itemType.Id='"+itemTypeId+"' and itemType.Status='y'");
				// List
				// itemGenericList=getHibernateTemplate().find("from jkt.hms.masters.business.MasItemGeneric as itemGeneric where itemGeneric.Id='"+itemGenericId+"' and itemGeneric.Status='y'");

				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masItem.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masItem.setStatus("y");
					dataDeleted = false;
				}
			}
			masItem.setLastChgBy(user);
			masItem.setLastChgDate(currentDate);
			masItem.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public List<MasStoreItem> checkForExistingPvmsNo(String pvmsNo) {
		List<MasStoreItem> existingPvmsNoList = new ArrayList<MasStoreItem>();

		Session session = (Session) getSession();
		existingPvmsNoList = session.createCriteria(MasStoreItem.class).add(
				Restrictions.like("PvmsNo", pvmsNo))
				.createAlias("ItemClassification", "it").add(Restrictions.eq("it.Id",1))
				.list();
		return existingPvmsNoList;
	}

	// -------------------------------------ITEM
	// GENERIC-------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showItemGenericJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItemGeneric> searchItemGenericList = new ArrayList<MasStoreItemGeneric>();
		List<MasStorePharmaIndex> pharmaIndexList = new ArrayList<MasStorePharmaIndex>();
		List<MasStorePharmaIndex> gridPharmaIndexList = new ArrayList<MasStorePharmaIndex>();

		searchItemGenericList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreItemGeneric ");
		pharmaIndexList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStorePharmaIndex as id");
		gridPharmaIndexList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStorePharmaIndex as mc where mc.Status = 'y'");
		map.put("searchItemGenericList", searchItemGenericList);
		map.put("pharamaIndexList", pharmaIndexList);
		map.put("gridPharmaIndexList", gridPharmaIndexList);
		return map;
	}

	public boolean addItemGeneric(MasStoreItemGeneric masStoreItemGeneric) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreItemGeneric);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean editItemGeneric(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String genericName = "";
		int itemGenericId = 0;
		int pharmaIndexId = 0;
		String contraIndication = "";
		String dosageCalculation = "";
		String drugInteraction = "";
		String specialPrecaution = "";
		@SuppressWarnings("unused")
		String sideEffects = "";
		String changedBy = "";
		String currentTime = "";
		Date changedDate = new Date();

		itemGenericId = (Integer) generalMap.get("id");
		genericName = (String) generalMap.get("itemGenericName");

		pharmaIndexId = (Integer) generalMap.get("pharmaIndexId");

		contraIndication = (String) generalMap.get("contraIndication");
		dosageCalculation = (String) generalMap.get("dosageCalculation");
		drugInteraction = (String) generalMap.get("drugInteraction");
		specialPrecaution = (String) generalMap.get("specialPrecaution");
		sideEffects = (String) generalMap.get("sideEffects");

		changedBy = (String) generalMap.get("changedBy");
		changedDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasStoreItemGeneric masStoreItemGeneric = (MasStoreItemGeneric) getHibernateTemplate()
				.get(MasStoreItemGeneric.class, itemGenericId);

		masStoreItemGeneric.setId(itemGenericId);
		masStoreItemGeneric.setGenericName(genericName);

		MasStorePharmaIndex masStorePharmaIndex = new MasStorePharmaIndex();
		masStorePharmaIndex.setId(pharmaIndexId);
		masStoreItemGeneric.setPharmaIndex(masStorePharmaIndex);

		masStoreItemGeneric.setContraIndication(contraIndication);
		masStoreItemGeneric.setDosageCalculation(dosageCalculation);
		masStoreItemGeneric.setDrugInteraction(drugInteraction);
		masStoreItemGeneric.setSpecialPrecaution(specialPrecaution);
		masStoreItemGeneric.setSideEffects(sideEffects);

		masStoreItemGeneric.setStatus("y");
		masStoreItemGeneric.setLastChgBy(changedBy);
		masStoreItemGeneric.setLastChgDate(changedDate);
		masStoreItemGeneric.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masStoreItemGeneric);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteItemGeneric(int itemGenericId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreItemGeneric masStoreItemGeneric = new MasStoreItemGeneric();
		masStoreItemGeneric = (MasStoreItemGeneric) getHibernateTemplate().get(
				MasStoreItemGeneric.class, itemGenericId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		@SuppressWarnings("unused")
		Integer pharmaIndexId = masStoreItemGeneric.getPharmaIndex().getId();

		if (generalMap.get("flag") != null) {
			List itemGenericList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStorePharmaIndex as isc where isc.Id='"
							+ itemGenericId + "' and isc.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreItemGeneric.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreItemGeneric.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreItemGeneric.setLastChgBy(changedBy);
		masStoreItemGeneric.setLastChgDate(currentDate);
		masStoreItemGeneric.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreItemGeneric);
		return dataDeleted;
	}

	public Map<String, Object> searchItemGeneric(String genericName) {
		List<MasStoreItemGeneric> searchItemGenericList = new ArrayList<MasStoreItemGeneric>();
		Map<String, Object> itemGenericFieldsMap = new HashMap<String, Object>();
		List pharamaIndexList = new ArrayList();
		try {
			if ((genericName != null)) {
				searchItemGenericList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreItemGeneric as i where i.GenericName like '"
										+ genericName
										+ "%' order by i.GenericName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		pharamaIndexList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStorePharmaIndex as md where md.Status = 'y' ");
		itemGenericFieldsMap
				.put("searchItemGenericList", searchItemGenericList);
		itemGenericFieldsMap.put("pharamaIndexList", pharamaIndexList);
		return itemGenericFieldsMap;
	}

	// ------------------------------------------StoreVendorWiseManufacturer----------------------------

	public boolean addStoreVendorWiseManufacturer(
			MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreVendorWiseManufacturer);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteStoreVendorWiseManufacturer(
			int storeVendorWiseManufacturerId, Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer = new MasStoreVendorWiseManufacturer();
		masStoreVendorWiseManufacturer = (MasStoreVendorWiseManufacturer) getHibernateTemplate()
				.load(MasStoreVendorWiseManufacturer.class,
						storeVendorWiseManufacturerId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		@SuppressWarnings("unused")
		Integer manufacturerId = masStoreVendorWiseManufacturer
				.getManufacturer().getId();
		if (generalMap.get("flag") != null) {
			List manufacturerList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasManufacturer as isc where isc.Id='"
							+ storeVendorWiseManufacturerId
							+ "' and isc.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreVendorWiseManufacturer.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreVendorWiseManufacturer.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreVendorWiseManufacturer.setLastChgBy(changedBy);
		masStoreVendorWiseManufacturer.setLastChgDate(currentDate);
		masStoreVendorWiseManufacturer.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreVendorWiseManufacturer);
		return dataDeleted;

	}

	public boolean editStoreVendorWiseManufacturerToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		int manufacturerId = 0;
		int storeVendorWiseManufacturerId = 0;
		String changedBy = "";
		String currentTime = "";
		Date changedDate = new Date();
		String storeVendorWiseManufacturerCode = "";
		storeVendorWiseManufacturerId = (Integer) generalMap.get("id");
		storeVendorWiseManufacturerCode = (String) generalMap
				.get("storeVendorWiseManufacturerCode");
		manufacturerId = (Integer) generalMap.get("manufacturerId");
		changedBy = (String) generalMap.get("changedBy");
		changedDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer = (MasStoreVendorWiseManufacturer) getHibernateTemplate()
				.load(MasStoreVendorWiseManufacturer.class,
						storeVendorWiseManufacturerId);
		masStoreVendorWiseManufacturer.setId(storeVendorWiseManufacturerId);

		MasManufacturer masManufacturer = new MasManufacturer();
		masManufacturer.setId(manufacturerId);
		masStoreVendorWiseManufacturer.setManufacturer(masManufacturer);
		masStoreVendorWiseManufacturer.setStatus("y");
		masStoreVendorWiseManufacturer.setLastChgBy(changedBy);
		masStoreVendorWiseManufacturer.setLastChgDate(changedDate);
		masStoreVendorWiseManufacturer.setLastChgTime(currentTime);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masStoreVendorWiseManufacturer);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchStoreVendorWiseManufacturer(
			String storeVendorWiseManufacturerCode) {
		List<MasStoreVendorWiseManufacturer> searchStoreVendorWiseManufacturerList = new ArrayList<MasStoreVendorWiseManufacturer>();
		List manufacturerList = null;
		Map<String, Object> storeVendorWiseManufacturerFieldsMap = new HashMap<String, Object>();
		List gridManufacturerList = null;
		try {
			if (storeVendorWiseManufacturerCode != null) {
				searchStoreVendorWiseManufacturerList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreVendorWiseManufacturer as i where i.VendorCode like '"
										+ storeVendorWiseManufacturerCode
										+ "%' order by i.VendorCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		manufacturerList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasManufacturer as isc where isc.Status = 'y'");
		gridManufacturerList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasManufacturer as isc");
		storeVendorWiseManufacturerFieldsMap.put("gridManufacturerList",
				gridManufacturerList);
		storeVendorWiseManufacturerFieldsMap.put(
				"searchStoreVendorWiseManufacturerList",
				searchStoreVendorWiseManufacturerList);
		storeVendorWiseManufacturerFieldsMap.put("manufacturerList",
				manufacturerList);

		return storeVendorWiseManufacturerFieldsMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStoreVendorWiseManufacturerJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreVendorWiseManufacturer> searchStoreVendorWiseManufacturerList = new ArrayList<MasStoreVendorWiseManufacturer>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		List<MasManufacturer> gridManufacturerList = new ArrayList<MasManufacturer>();
		searchStoreVendorWiseManufacturerList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreVendorWiseManufacturer ");
		gridManufacturerList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasManufacturer as isc");
		manufacturerList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasManufacturer as isc where isc.Status = 'y' order by isc.ManufacturerName asc");
		map.put("searchStoreVendorWiseManufacturerList",
				searchStoreVendorWiseManufacturerList);
		map.put("manufacturerList", manufacturerList);
		map.put("gridManufacturerList", gridManufacturerList);
		return map;
	}

	// ----------------------------Store
	// Section----------------------------------------

	public Map<String, Object> showStoreSectionJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSection> searchStoreSectionList = new ArrayList<MasStoreSection>();
		List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		searchStoreSectionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreSection ");
		itemTypeList = session.createCriteria(MasItemType.class).add(Restrictions.eq("Status", "y")).list();
		map.put("searchStoreSectionList", searchStoreSectionList);
		map.put("itemTypeList", itemTypeList);
		return map;
	}

	public boolean addStoreSection(MasStoreSection masStoreSection) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreSection);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteStoreSection(int sectionId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreSection masStoreSection = new MasStoreSection();
		masStoreSection = (MasStoreSection) getHibernateTemplate().get(
				MasStoreSection.class, sectionId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreSection.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreSection.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreSection.setLastChgBy(changedBy);
		masStoreSection.setLastChgDate(currentDate);
		masStoreSection.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreSection);
		return dataDeleted;
	}

	public boolean editStoreSectionToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String sectionName = "";
		@SuppressWarnings("unused")
		String sectionCode = "";
		int sectionId = 0;
		int itemTypeId = 0;
		String changedBy = "";
		sectionId = (Integer) generalMap.get("id");
		sectionCode = (String) generalMap.get("sectionCode");
		sectionName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
				if(generalMap.get("itemTypeId") != null){
					itemTypeId = (Integer)generalMap.get("itemTypeId");
				}
		MasStoreSection masStoreSection = (MasStoreSection) getHibernateTemplate()
				.get(MasStoreSection.class, sectionId);
		masStoreSection.setId(sectionId);
		masStoreSection.setSectionName(sectionName);
		masStoreSection.setLastChgBy(changedBy);
		MasItemType masItemType = new MasItemType();
		masItemType.setId(itemTypeId);
		masStoreSection.setItemType(masItemType);
		masStoreSection.setLastChgDate(currentDate);
		masStoreSection.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreSection);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchStoreSection(String sectionCode,
			String sectionName) {
		Session session = (Session) getSession();
		List<MasStoreSection> searchStoreSectionList = new ArrayList<MasStoreSection>();
		List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		Map<String, Object> sectionieldsMap = new HashMap<String, Object>();
		try {
			if ((sectionName != null) || (sectionCode == null)) {
				searchStoreSectionList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreSection imc where imc.SectionName like '"
										+ sectionName
										+ "%' order by imc.SectionName");
			} else {
				searchStoreSectionList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreSection imc where imc.SectionCode like '"
										+ sectionCode
										+ "%' order by imc.SectionCode");
			}
			itemTypeList = session.createCriteria(MasItemType.class).add(Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sectionieldsMap.put("itemTypeList", itemTypeList);
		sectionieldsMap.put("searchStoreSectionList", searchStoreSectionList);
		return sectionieldsMap;
	}

	// -----------------------Financial-----------------------
	public Map<String, Object> showFinancialJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreFinancial> searchFinancialList = new ArrayList<MasStoreFinancial>();
		searchFinancialList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreFinancial ");
		map.put("searchFinancialList", searchFinancialList);
		return map;
	}

	public Map<String, Object> searchFinancial(Date startDate, Date endDate) {
		List<MasItemType> searchFinancialList = new ArrayList<MasItemType>();
		Map<String, Object> financialFieldsMap = new HashMap<String, Object>();
		try {
			if ((startDate != null) || (endDate == null)) {

				searchFinancialList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreFinancial sc where sc.StartDate like '"
								+ startDate + "%' order by sc.StartDate");
			} else {
				searchFinancialList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreFinancial sc where sc.EndDate like '"
								+ endDate + "%' order by sc.EndDate");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		financialFieldsMap.put("searchFinancialList", searchFinancialList);
		return financialFieldsMap;
	}

	public boolean addFinancial(MasStoreFinancial masStoreFinancial) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreFinancial);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteFinancial(int financialId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
		masStoreFinancial = (MasStoreFinancial) getHibernateTemplate().load(
				MasStoreFinancial.class, financialId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreFinancial.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreFinancial.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreFinancial.setLastChgBy(changedBy);
		masStoreFinancial.setLastChgDate(currentDate);
		masStoreFinancial.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreFinancial);
		return dataDeleted;
	}

	public boolean editFinancialToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int financialId = 0;
		Date startDate = null;
		Date endDate = null;
		String changedBy = "";
		String financialYear="";
		financialId = (Integer) generalMap.get("id");
		startDate = (Date) generalMap.get("startDate");
		endDate = (Date) generalMap.get("endDate");
		financialYear = (String) generalMap.get("financialYear");
		changedBy = (String) generalMap.get("changedBy");
		
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreFinancial masStoreFinancial = (MasStoreFinancial) getHibernateTemplate()
				.load(MasStoreFinancial.class, financialId);
		masStoreFinancial.setId(financialId);
		masStoreFinancial.setStartDate(startDate);
		masStoreFinancial.setEndDate(endDate);
		masStoreFinancial.setFinancialYear(financialYear);
		masStoreFinancial.setLastChgBy(changedBy);
		masStoreFinancial.setLastChgDate(currentDate);
		masStoreFinancial.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreFinancial);
		dataUpdated = true;
		return dataUpdated;
	}

	// -----------------------PharmaIndex-----------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPharmaIndexJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStorePharmaIndex> searchPharmaIndexList = new ArrayList<MasStorePharmaIndex>();
		searchPharmaIndexList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStorePharmaIndex ");
		map.put("searchPharmaIndexList", searchPharmaIndexList);
		return map;
	}

	public boolean addPharmaIndex(MasStorePharmaIndex masStorePharmaIndex) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStorePharmaIndex);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deletePharmaIndex(int pharmaIndexId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStorePharmaIndex masStorePharmaIndex = new MasStorePharmaIndex();
		masStorePharmaIndex = (MasStorePharmaIndex) getHibernateTemplate()
				.load(MasStorePharmaIndex.class, pharmaIndexId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStorePharmaIndex.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStorePharmaIndex.setStatus("y");
				dataDeleted = false;
			}
		}
		masStorePharmaIndex.setLastChgBy(changedBy);
		masStorePharmaIndex.setLastChgDate(currentDate);
		masStorePharmaIndex.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStorePharmaIndex);
		return dataDeleted;
	}

	public boolean editPharmaIndexToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String pharmaIndexName = "";
		int pharmaIndexId = 0;
		String changedBy = "";

		pharmaIndexId = (Integer) generalMap.get("id");
		pharmaIndexName = (String) generalMap.get("pharmaIndexName");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasStorePharmaIndex masStorePharmaIndex = (MasStorePharmaIndex) getHibernateTemplate()
				.load(MasStorePharmaIndex.class, pharmaIndexId);
		masStorePharmaIndex.setId(pharmaIndexId);
		masStorePharmaIndex.setPharmaIndexName(pharmaIndexName);
		masStorePharmaIndex.setLastChgBy(changedBy);
		masStorePharmaIndex.setLastChgDate(currentDate);
		masStorePharmaIndex.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStorePharmaIndex);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPharmaIndex(String pharmaIndexName) {
		List<MasStorePharmaIndex> searchPharmaIndexList = new ArrayList<MasStorePharmaIndex>();
		Map<String, Object> pharmaIndexFieldsMap = new HashMap<String, Object>();
		try {
			if ((pharmaIndexName != null)) {
				searchPharmaIndexList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStorePharmaIndex as  mb where mb.PharmaIndexName like '"
										+ pharmaIndexName
										+ "%' order by mb.PharmaIndexName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		pharmaIndexFieldsMap
				.put("searchPharmaIndexList", searchPharmaIndexList);
		return pharmaIndexFieldsMap;
	}

	// --------------------------------Store Unit------------------------

	public Map<String, Object> showItemUnitJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreUnit> searchItemUnitList = new ArrayList<MasStoreUnit>();
		searchItemUnitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreUnit ");
		map.put("searchItemUnitList", searchItemUnitList);
		return map;
	}

	public Map<String, Object> searchItemUnit(String unitName) {
		List<MasStoreUnit> searchItemUnitList = new ArrayList<MasStoreUnit>();
		Map<String, Object> storeUnitFieldsMap = new HashMap<String, Object>();
		try {
			if ((unitName != null)) {
				searchItemUnitList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreUnit as  mb where mb.UnitName like '"
								+ unitName + "%' order by mb.UnitName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		storeUnitFieldsMap.put("searchItemUnitList", searchItemUnitList);
		return storeUnitFieldsMap;
	}

	public boolean addItemUnit(MasStoreUnit masStoreUnit) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreUnit);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteItemUnit(int itemUnitId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreUnit masStoreUnit = new MasStoreUnit();
		masStoreUnit = (MasStoreUnit) getHibernateTemplate().load(
				MasStoreUnit.class, itemUnitId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreUnit.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreUnit.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreUnit.setLastChgBy(changedBy);
		masStoreUnit.setLastChgDate(currentDate);
		masStoreUnit.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreUnit);
		return dataDeleted;
	}

	public boolean editItemUnitToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String unitName = "";
		int itemUnitId = 0;
		String changedBy = "";

		itemUnitId = (Integer) generalMap.get("id");
		unitName = (String) generalMap.get("unitName");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasStoreUnit masStoreUnit = (MasStoreUnit) getHibernateTemplate().load(
				MasStoreUnit.class, itemUnitId);
		masStoreUnit.setId(itemUnitId);
		masStoreUnit.setUnitName(unitName);
		masStoreUnit.setLastChgBy(changedBy);
		masStoreUnit.setLastChgDate(currentDate);
		masStoreUnit.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreUnit);
		dataUpdated = true;
		return dataUpdated;
	}

	// ----------------------------Item
	// Conversion---------------------------------------------
	public Map<String, Object> showItemConversionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreUnit> itemPurchaseUnitList = new ArrayList<MasStoreUnit>();
		List<MasStoreUnit> itemIntermediateUnitList = new ArrayList<MasStoreUnit>();
		List<MasStoreUnit> itemIssueUnitList = new ArrayList<MasStoreUnit>();
		List<MasStoreItemConversion> searchItemConversionList = new ArrayList<MasStoreItemConversion>();

		itemPurchaseUnitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreUnit as mbs where mbs.Status = 'y' order by mbs.UnitName asc");
		itemIntermediateUnitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreUnit as mbs where mbs.Status = 'y' order by mbs.UnitName asc");
		itemIssueUnitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreUnit as mbs where mbs.Status = 'y' order by mbs.UnitName asc");
		searchItemConversionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreItemConversion ");
		map.put("itemPurchaseUnitList", itemPurchaseUnitList);
		map.put("itemIntermediateUnitList", itemIntermediateUnitList);
		map.put("itemIssueUnitList", itemIssueUnitList);
		map.put("searchItemConversionList", searchItemConversionList);
		return map;
	}

	public Map<String, Object> searchItemConversion(String itemUnitName) {
		List<MasBed> searchItemConversionList = new ArrayList<MasBed>();
		Map<String, Object> itemConversionFieldsMap = new HashMap<String, Object>();
		List<MasStoreUnit> itemPurchaseUnitList = new ArrayList<MasStoreUnit>();
		List<MasStoreUnit> itemIntermediateUnitList = new ArrayList<MasStoreUnit>();
		List<MasStoreUnit> itemIssueUnitList = new ArrayList<MasStoreUnit>();

		try {
			if ((itemUnitName != null)) {
				searchItemConversionList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreItemConversion as  mb where mb.ItemUnitName like '"
										+ itemUnitName
										+ "%' order by mb.ItemUnitName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		itemPurchaseUnitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreUnit as mbs where mbs.Status = 'y'");
		itemIntermediateUnitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreUnit as mbs where mbs.Status = 'y'");
		itemIssueUnitList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreUnit as mbs where mbs.Status = 'y'");
		itemConversionFieldsMap.put("searchItemConversionList",
				searchItemConversionList);
		itemConversionFieldsMap.put("itemPurchaseUnitList",
				itemPurchaseUnitList);
		itemConversionFieldsMap.put("itemIntermediateUnitList",
				itemIntermediateUnitList);
		itemConversionFieldsMap.put("itemIssueUnitList", itemIssueUnitList);
		return itemConversionFieldsMap;

	}

	public boolean addItemConversion(
			MasStoreItemConversion masStoreItemConversion) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreItemConversion);
		successfullyAdded = true;
		return successfullyAdded;
	}

	// ---------------------------PO Delivery
	// Terms------------------------------------
	public Map<String, Object> showPoDeliveryTermsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStorePoDeliveryTerms> searchPoDeliveryTermsList = new ArrayList<MasStorePoDeliveryTerms>();
		searchPoDeliveryTermsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStorePoDeliveryTerms ");
		map.put("searchPoDeliveryTermsList", searchPoDeliveryTermsList);
		return map;
	}

	public Map<String, Object> searchPoDeliveryTerms(String poDeliveryType) {
		List<MasBed> searchPoDeliveryTermsList = new ArrayList<MasBed>();
		Map<String, Object> poDeliveryTermsFieldsMap = new HashMap<String, Object>();

		try {
			if ((poDeliveryType != null)) {
				searchPoDeliveryTermsList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStorePoDeliveryTerms as  mb where mb.PoDeliveryTermsName like '"
										+ poDeliveryType
										+ "%' order by mb.PoDeliveryTermsName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		poDeliveryTermsFieldsMap.put("searchPoDeliveryTermsList",
				searchPoDeliveryTermsList);
		return poDeliveryTermsFieldsMap;
	}

	public boolean addPoDeliveryTerms(
			MasStorePoDeliveryTerms masStorePoDeliveryTerms) {
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masStorePoDeliveryTerms);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean deletePoDeliveryTerms(int poTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStorePoDeliveryTerms masStorePoDeliveryTerms = new MasStorePoDeliveryTerms();
		masStorePoDeliveryTerms = (MasStorePoDeliveryTerms) getHibernateTemplate()
				.get(MasStorePoDeliveryTerms.class, poTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStorePoDeliveryTerms.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStorePoDeliveryTerms.setStatus("y");
				dataDeleted = false;
			}
		}
		masStorePoDeliveryTerms.setLastChgBy(changedBy);
		masStorePoDeliveryTerms.setLastChgDate(currentDate);
		masStorePoDeliveryTerms.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStorePoDeliveryTerms);
		return dataDeleted;
	}

	public boolean editPoDeliveryTermsToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String poType = "";
		int poDeliveryTermsId = 0;
		String description = "";
		String changedBy = "";
		String currentTime = "";
		Date changedDate = new Date();
		poDeliveryTermsId = (Integer) generalMap.get("id");
		poType = (String) generalMap.get("poType");
		description = (String) generalMap.get("description");

		changedBy = (String) generalMap.get("changedBy");
		changedDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasStorePoDeliveryTerms masStorePoDeliveryTerms = (MasStorePoDeliveryTerms) getHibernateTemplate()
				.get(MasStorePoDeliveryTerms.class, poDeliveryTermsId);

		masStorePoDeliveryTerms.setId(poDeliveryTermsId);
		masStorePoDeliveryTerms.setPoDeliveryTermsName(poType);
		masStorePoDeliveryTerms.setPoDeliveryTermsDescription(description);
		masStorePoDeliveryTerms.setStatus("y");
		masStorePoDeliveryTerms.setLastChgBy(changedBy);
		masStorePoDeliveryTerms.setLastChgDate(changedDate);
		masStorePoDeliveryTerms.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masStorePoDeliveryTerms);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/*
	 * public Map<String, Object> searchBudget(String budgetCode) {
	 * List<MasStoreBudget> searchBudgetList=new ArrayList<MasStoreBudget>();
	 * Map<String,Object> budgetFieldsMap = new HashMap<String,Object>(); List
	 * financialList = new ArrayList(); List gridFinancialList=null; try{
	 * searchBudgetList=getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreBudget as  msb where msb.BudgetCode like '"
	 * + budgetCode+"%' order by msb.BudgetCode"); } catch (Exception e) {
	 * //System.out.println("Ds excp in searchBudgetList  "+e); } financialList =
	 * getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreFinancial as msf where msf.Status = 'y' "
	 * ); gridFinancialList=getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasStoreFinancial as msf where msf.Status = 'y' "
	 * ); budgetFieldsMap.put("searchBudgetList",searchBudgetList);
	 * budgetFieldsMap.put("financialList",financialList);
	 * budgetFieldsMap.put("gridFinancialList",gridFinancialList); return
	 * budgetFieldsMap; } public boolean addBudget(MasStoreBudget
	 * masStoreBudget) { boolean successfullyAdded=false;
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_AUTO");
	 * hbt.setCheckWriteOperations(false); hbt.save(masStoreBudget);
	 * successfullyAdded = true; return successfullyAdded; } public boolean
	 * deleteBudget(int budgetId,Map<String, Object> generalMap) { boolean
	 * dataDeleted=false; String changedBy = ""; Date currentDate = new Date();
	 * String currentTime = ""; currentTime =
	 * (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	 * MasStoreBudget masStoreBudget= new MasStoreBudget();
	 * masStoreBudget=(MasStoreBudget
	 * )getHibernateTemplate().get(MasStoreBudget.class,budgetId); changedBy =
	 * (String)generalMap.get("changedBy");
	 * currentDate=(Date)generalMap.get("currentDate");
	 * currentTime=(String)generalMap.get("currentTime");
	 *
	 * @SuppressWarnings("unused") Integer
	 * financialId=masStoreBudget.getFinancial().getId(); if
	 * (masStoreBudget.getStatus().equals("y")){
	 *
	 * @SuppressWarnings("unused") List
	 * financialList=getHibernateTemplate().find
	 * ("from jkt.hms.masters.business.MasStoreFinancial as msf where msf.Id='"
	 * +budgetId+"' and msf.Status='y'"); masStoreBudget.setStatus("n");
	 * dataDeleted=true; }else{ masStoreBudget.setStatus("y");
	 * dataDeleted=false; } masStoreBudget.setLastChgBy(changedBy);
	 * masStoreBudget.setLastChgDate(currentDate);
	 * masStoreBudget.setLastChgTime(currentTime);
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); hbt.update(masStoreBudget); return
	 * dataDeleted; } public boolean editBudgetToDatabase(Map<String, Object>
	 * generalMap) { boolean dataUpdated=false; int budgetId=0; int financialId
	 * = 0; String budgetCode = ""; Float totalAllocatedAmount = null; Float
	 * crvComittedAmount = null; Float poCommitedAmount = null; Float
	 * utilizedAmount = null; String changedBy = ""; String currentTime=""; Date
	 * changedDate = new Date(); budgetId=(Integer)generalMap.get("id");
	 * budgetCode=(String)generalMap.get("code");
	 * financialId=(Integer)generalMap.get("financialId");
	 * totalAllocatedAmount=(Float)generalMap.get("totalAllocatedAmount");
	 * crvComittedAmount=(Float)generalMap.get("crvComittedAmount");
	 * poCommitedAmount=(Float)generalMap.get("poCommitedAmount");
	 * utilizedAmount=(Float)generalMap.get("utilizedAmount"); changedBy =
	 * (String)generalMap.get("changedBy");
	 * changedDate=(Date)generalMap.get("changedDate");
	 * currentTime=(String)generalMap.get("currentTime");
	 *
	 * MasStoreBudget
	 * masStoreBudget=(MasStoreBudget)getHibernateTemplate().get(MasStoreBudget
	 * .class,budgetId);
	 *
	 * masStoreBudget.setId(budgetId); masStoreBudget.setBudgetCode(budgetCode);
	 *
	 * if(financialId != 0){ MasStoreFinancial masStoreFinancial = new
	 * MasStoreFinancial(); masStoreFinancial.setId(financialId);
	 * masStoreBudget.setFinancial(masStoreFinancial); }
	 *
	 * totalAllocatedAmount=(Float)generalMap.get("totalAllocatedAmount");
	 * crvComittedAmount=(Float)generalMap.get("crvComittedAmount");
	 * poCommitedAmount=(Float)generalMap.get("poCommitedAmount");
	 * utilizedAmount=(Float)generalMap.get("utilizedAmount");
	 * masStoreBudget.setStatus("y"); masStoreBudget.setLastChgBy(changedBy);
	 * masStoreBudget.setLastChgDate(changedDate);
	 * masStoreBudget.setLastChgTime(currentTime); try{
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); hbt.update(masStoreBudget);
	 * dataUpdated = true; }catch (Exception e) {
	 * //System.out.println("eeeeeeee  "+e); } return dataUpdated; }
	 */
	// -----------------------Me Scale--------------------------

	public Map<String, Object> showMeScaleJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreMeScale> searchMeScaleList = new ArrayList<MasStoreMeScale>();

		searchMeScaleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreMeScale ");
		map.put("searchMeScaleList", searchMeScaleList);
		return map;
	}

	public boolean saveMeScale(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		MasStoreMeScale masStoreMeScale = new MasStoreMeScale();
		String meScaleNumber = "";
		String meScaleDescription = "";
		Date changedDate = null;
		String changedBy = "";		
		String changedTime = "";
		int j=0;
		int deptId=0;
		int hospitalId=0;
		
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		Vector srno = box.getVector(SR_NO);
		Vector qty = box.getVector("qty");
		Vector items = box.getVector("idItem");
		
		if(box.get(ME_SCALE_NUMBER) != null && !(box.get(ME_SCALE_NUMBER).equals(""))){
			meScaleNumber = box.get(ME_SCALE_NUMBER);
		}
		if(box.get(ME_SCALE_DESCRIPTION) != null && !(box.get(ME_SCALE_DESCRIPTION).equals(""))){
			meScaleDescription = box.get(ME_SCALE_DESCRIPTION);
		}
		if(box.get(CHANGED_BY) !=null){
			changedBy = box.get(CHANGED_BY);
		}
		if(box.get(CHANGED_DATE) != null){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(box.get(CHANGED_DATE));
		}
		if(box.get(CHANGED_TIME) != null){
			changedTime = box.get(CHANGED_TIME);
		}
		Transaction tx = null;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			tx = session.beginTransaction();
			masStoreMeScale.setMeScale(meScaleNumber);
			masStoreMeScale.setMeScaleDescription(meScaleDescription);
			masStoreMeScale.setStatus("y");
			masStoreMeScale.setLastChgBy(changedBy);
			masStoreMeScale.setLastChgDate(changedDate);
			masStoreMeScale.setLastChgTime(changedTime);
			hbt.save(masStoreMeScale);
			
		for (int i = 0; i < srno.size(); i++) {
			StoreMeScaleDetails meScaleDetails = new StoreMeScaleDetails();
			j=i;
			meScaleDetails.setSerialNo(++j);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			meScaleDetails.setDepartment(masDepartment);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			meScaleDetails.setHospital(masHospital);

			MasStoreItem item = new MasStoreItem();
			item.setId(Integer.parseInt("" + items.get(i)));
			meScaleDetails.setItem(item);
			if(!qty.get(i).equals(""))
			{
			meScaleDetails.setQty(new BigDecimal(qty.get(i).toString()));
			}
			meScaleDetails.setMeScale(masStoreMeScale);
			meScaleDetails.setLastChgBy(changedBy);
			meScaleDetails.setLastChgDate(changedDate);
			meScaleDetails.setLastChgTime(changedTime);
			hbt.save(meScaleDetails);
			
			}
		
		tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteMeScale(int meScaleId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreMeScale masStoreMeScale = new MasStoreMeScale();
		masStoreMeScale = (MasStoreMeScale) getHibernateTemplate().get(
				MasStoreMeScale.class, meScaleId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreMeScale.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreMeScale.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreMeScale.setLastChgBy(changedBy);
		masStoreMeScale.setLastChgDate(currentDate);
		masStoreMeScale.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreMeScale);
		return dataDeleted;
	}

	public boolean editMeScaleToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		String changedBy = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String meScaleDescription = "";
		@SuppressWarnings("unused")
		int meScaleNumber = 0;
		int meScaleId = 0;

		meScaleId = (Integer) generalMap.get("id");
		meScaleNumber = (Integer) generalMap.get("meScaleNumber");
		meScaleDescription = (String) generalMap.get("meScaleDescription");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreMeScale masStoreMeScale = (MasStoreMeScale) getHibernateTemplate()
				.load(MasStoreMeScale.class, meScaleId);

		masStoreMeScale.setId(meScaleId);
		masStoreMeScale.setMeScaleDescription(meScaleDescription);
		masStoreMeScale.setLastChgBy(changedBy);
		masStoreMeScale.setLastChgDate(currentDate);
		masStoreMeScale.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreMeScale);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchMeScale1(Map<String, Object> dataMap) {
		List<StoreMeScaleDetails> searchMeScaleList = new ArrayList<StoreMeScaleDetails>();
		Map<String, Object> meScaleFieldsMap = new HashMap<String, Object>();
		String meScaleNumber  = "";
		String meScaleDescription  = "";
		String pvmsNo  = "";
		Session session=(Session)getSession();
		
		try {
			
			meScaleNumber=(String)dataMap.get("meScaleNumber");
			meScaleDescription=(String)dataMap.get("meScaleDescription");
			pvmsNo=(String)dataMap.get("pvmsNo");
			
			Criteria crit;
			
			 crit=session.createCriteria(StoreMeScaleDetails.class)
			 .createAlias("MeScale", "meScale")
			  .createAlias("Item", "item");
			if(!meScaleNumber.equals(""))
			{
				crit.add(Restrictions.eq("meScale.MeScale", meScaleNumber));
			}
			
			if(!meScaleDescription.equals(""))
			{
				crit.add(Restrictions.eq("meScale.MeScaleDescription", meScaleDescription));
			}
			
			if(!pvmsNo.equals(""))
			{
				crit.add(Restrictions.eq("item.PvmsNo", pvmsNo));
			}
			
			crit.addOrder(
					Order.asc("SerialNo"));
			searchMeScaleList=crit.list();
			
		} catch (Exception e) {
			
		}
		meScaleFieldsMap.put("searchMeScaleList", searchMeScaleList);
		return meScaleFieldsMap;

	}

	// ----------------------------- AirForceUnitDepot--------------------------
	public boolean addAirForceUnitDepot(
			MasStoreAirForceDepot masStoreAirForceDepot) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreAirForceDepot);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public Map<String, Object> showAirForceUnitDepotJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreAirForceDepot> searchAirForceUnitDepotList = new ArrayList<MasStoreAirForceDepot>();

		searchAirForceUnitDepotList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreAirForceDepot ");
		map.put("searchAirForceUnitDepotList", searchAirForceUnitDepotList);
		return map;
	}

	public boolean editAirForceUnitDepotToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String airForceDepotName = "";
		int airForceDepotId = 0;
		String type = "";
		String changedBy = "";
		String currentTime = "";
		Date changedDate = new Date();
		airForceDepotId = (Integer) generalMap.get("id");
		airForceDepotName = (String) generalMap.get("airForceDepotName");
		type = (String) generalMap.get("type");
		changedBy = (String) generalMap.get("changedBy");
		changedDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");

		MasStoreAirForceDepot masStoreAirForceDepot = (MasStoreAirForceDepot) getHibernateTemplate()
				.get(MasStoreAirForceDepot.class, airForceDepotId);

		masStoreAirForceDepot.setId(airForceDepotId);
		masStoreAirForceDepot.setAirForceDepotName(airForceDepotName);
		masStoreAirForceDepot.setAirForceDepotType(type);
		masStoreAirForceDepot.setStatus("y");
		masStoreAirForceDepot.setLastChgBy(changedBy);
		masStoreAirForceDepot.setLastChgDate(changedDate);
		masStoreAirForceDepot.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masStoreAirForceDepot);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteAirForceUnitDepot(int airForceDepotId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreAirForceDepot masStoreAirForceDepot = new MasStoreAirForceDepot();
		masStoreAirForceDepot = (MasStoreAirForceDepot) getHibernateTemplate()
				.get(MasStoreAirForceDepot.class, airForceDepotId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreAirForceDepot.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreAirForceDepot.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreAirForceDepot.setLastChgBy(changedBy);
		masStoreAirForceDepot.setLastChgDate(currentDate);
		masStoreAirForceDepot.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreAirForceDepot);
		return dataDeleted;
	}

	public Map<String, Object> searchAirForceUnitDepot(String airForceDepotName) {
		List<MasStoreAirForceDepot> searchAirForceUnitDepotList = new ArrayList<MasStoreAirForceDepot>();
		Map<String, Object> airForceUnitDepotFieldsMap = new HashMap<String, Object>();

		try {
			if ((airForceDepotName != null)) {
				searchAirForceUnitDepotList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasStoreAirForceDepot as  mb where mb.AirForceDepotName like '"
										+ airForceDepotName
										+ "%' order by mb.AirForceDepotName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		airForceUnitDepotFieldsMap.put("searchAirForceUnitDepotList",
				searchAirForceUnitDepotList);
		return airForceUnitDepotFieldsMap;
	}

	public boolean editItem(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		
		
		int itemId = 0;
		int groupId = 0;
		int itemClassId = 0;
		int sectionId = 0;
		int itemTypeId = 0;
		int itemCategoryId = 0;
		int itemConversionId = 0;
		String pvms = "";
		String commonName = "";
		String highValueDrug = "";
		float minStock=(float) 0.0;
		float maxStock=(float) 0.0;
		int deptId=0;
		int hospitalId = 0;
		int userId = 0;
		String nomenclature = "";
		String tempreture = "";
		String insulin="";
		String expiry="";
		itemId = (Integer) generalMap.get("id");
		String changedBy="";
		insulin= (String) generalMap.get("insulin");
		pvms = (String) generalMap.get("pvms");
		commonName = (String) generalMap.get("commonName");
		tempreture = (String) generalMap.get("tempreture");
		nomenclature = (String) generalMap.get("name");
		itemClassId = (Integer) generalMap.get("itemClassId");
		sectionId = (Integer) generalMap.get("sectionId");
		groupId = (Integer) generalMap.get("groupId");
		itemTypeId = (Integer) generalMap.get("itemTypeId");
		itemCategoryId = (Integer) generalMap.get("itemCategoryId");
		itemConversionId = (Integer) generalMap.get("itemConversionId");
		pvms = (String) generalMap.get("pvms");
		highValueDrug = (String) generalMap.get("highValueDrug");
		minStock = (Float) generalMap.get("minTempreture");
		maxStock = (Float) generalMap.get("maxTempreture");
		hospitalId = (Integer) generalMap.get("hospitalId");
		userId= (Integer) generalMap.get("userId");
		Users user = new Users();
		user.setId(userId);
		expiry = (String) generalMap.get("expiry");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");
		String dispensingUnit="";
		dispensingUnit = (String) generalMap.get("dispensingUnit");
		String brandedGeneric="";
		brandedGeneric = (String) generalMap.get("brandedGeneric");
		String IssueFrom = (String) generalMap.get("IssueFrom");
		String prescribedFrom = (String) generalMap.get("prescribedFrom");
		BigDecimal uomQty = new BigDecimal(0);
		uomQty= (BigDecimal) generalMap.get("uomQty");
		MasStoreItem masStoreItem = (MasStoreItem) getHibernateTemplate().get(
				MasStoreItem.class, itemId);
		
		masStoreItem.setId(itemId);
		masStoreItem.setNomenclature(nomenclature);
		masStoreItem.setPvmsNo(pvms);
		masStoreItem.setCommonName(commonName);
		masStoreItem.setDispUnit(dispensingUnit);
		MasStoreSection masStoreSection = new MasStoreSection();
		masStoreSection.setId(sectionId);
		masStoreItem.setSection(masStoreSection);
		masStoreItem.setIssueFrom(IssueFrom);
		masStoreItem.setPrescribedFrom(prescribedFrom);
		masStoreItem.setLastChgBy(user);

		masStoreItem.setADispQty(uomQty);
		/*if (deptId != 0) {
			 MasDepartment masDepartment = new MasDepartment();
			 masDepartment.setId(deptId);
			 masStoreItem.setDepartment(masDepartment);
		}*/
		

	


		if (groupId != 0) {
			MasStoreGroup masStoreGroup = new MasStoreGroup();
			masStoreGroup.setId(groupId);
			masStoreItem.setGroup(masStoreGroup);
		} else {
			masStoreItem.setGroup(null);
		}

		 MasItemType masStoreItemType = new MasItemType();
		 masStoreItemType.setId(itemTypeId);
		 masStoreItem.setItemType(masStoreItemType);

		if (itemCategoryId != 0) {
			MasItemCategory masStoreItemCategory = new MasItemCategory();
			masStoreItemCategory.setId(itemCategoryId);
			masStoreItem.setItemCategory(masStoreItemCategory);
		}
		if (itemClassId != 0) {
			masStoreItem.setItemClass(new MasItemClass(itemClassId));
		}
		masStoreItem.setHighValueDrug(highValueDrug);
		if(hospitalId !=0){
			MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			masStoreItem.setHospital(masHospital);
			}
	
		MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
		masStoreItemConversion.setId(itemConversionId);
		masStoreItem.setItemConversion(masStoreItemConversion);

		 MasItemClassification c = new MasItemClassification();
		 c.setId(1);
		 masStoreItem.setItemClassification(c);
	
	

		if (itemTypeId != 0) {
			MasItemType masItemType = new MasItemType();
			masItemType.setId(itemTypeId);
			masStoreItem.setItemType(masItemType);
		}
		if (!tempreture.equals("")) {
			masStoreItem.setTemperature(tempreture);
		}
		if (!insulin.equals("")) {
			masStoreItem.setInsulinInjection(insulin);
		}
		
		masStoreItem.setMinStock(minStock);
		masStoreItem.setMaxStock(maxStock);

		masStoreItem.setExpiry(expiry);

		
		masStoreItem.setLastChgBy(user);
		masStoreItem.setBrandedGeneric(brandedGeneric);
		
		masStoreItem.setLastChgDate(currentDate);
		masStoreItem.setLastChgTime(currentTime);
		
		MasHospital h = new MasHospital();
		h.setId(hospitalId);
		masStoreItem.setHospital(h);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreItem);

		dataUpdated = true;
		return dataUpdated;

	}

	public boolean editItemConversionToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int itemConversionId = 0;
		String itemUnitName = "";
		@SuppressWarnings("unused")
		int conversionFactor1 = 0;
		int conversionFactor2 = 0;
		int purchaseUnitId = 0;
		int intermediateUnitid = 0;
		int issueUnitId = 0;
		String changedBy = "";
		String formula = null;
		itemConversionId = (Integer) generalMap.get("id");
		itemUnitName = (String) generalMap.get("name");
		conversionFactor1 = (Integer) generalMap.get("conversionFactor1");
		conversionFactor2 = (Integer) generalMap.get("conversionFactor2");
		purchaseUnitId = (Integer) generalMap.get("purchaseUnitId");
		intermediateUnitid = (Integer) generalMap.get("intermediateUnitid");
		issueUnitId = (Integer) generalMap.get("issueUnitId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		formula = (String) generalMap.get("formula");
		MasStoreItemConversion masStoreItemConversion = (MasStoreItemConversion) getHibernateTemplate()
				.get(MasStoreItemConversion.class, itemConversionId);

		masStoreItemConversion.setId(itemConversionId);
		masStoreItemConversion.setItemUnitName(itemUnitName);
		masStoreItemConversion.setConversionFactor1(conversionFactor1);
		if (conversionFactor2 != 0) {
			masStoreItemConversion.setConversionFactor2(conversionFactor2);
		}

		MasStoreUnit masStoreUnit1 = new MasStoreUnit();
		masStoreUnit1.setId(purchaseUnitId);
		masStoreItemConversion.setPurchaseUnit(masStoreUnit1);

		MasStoreUnit masStoreUnit2 = new MasStoreUnit();
		masStoreUnit2.setId(intermediateUnitid);
		masStoreItemConversion.setIntermediateUnit(masStoreUnit2);

		MasStoreUnit masStoreUnit3 = new MasStoreUnit();
		masStoreUnit3.setId(issueUnitId);
		masStoreItemConversion.setIssueUnit(masStoreUnit3);

		masStoreItemConversion.setLastChgBy(changedBy);
		masStoreItemConversion.setLastChgDate(currentDate);
		masStoreItemConversion.setLastChgTime(currentTime);
		masStoreItemConversion.setFormula(formula);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreItemConversion);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteItemConversion(int itemConversionId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
		masStoreItemConversion = (MasStoreItemConversion) getHibernateTemplate()
				.get(MasStoreItemConversion.class, itemConversionId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreItemConversion.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreItemConversion.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreItemConversion.setLastChgBy(changedBy);
		masStoreItemConversion.setLastChgDate(currentDate);
		masStoreItemConversion.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreItemConversion);
		return dataDeleted;
	}

	// -------------------------------------- Budget Entry
	// ----------------------------

	public Map<String, Object> showBudgetJsp(int deptId,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBudget> searchBudgetList = new ArrayList<MasStoreBudget>();
		List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasStoreBudgetT> budgetDetailsList = new ArrayList<MasStoreBudgetT>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		List<MasBudgetCode> budgetCodes=new ArrayList<MasBudgetCode>();
		List maxFin=new ArrayList();
		int grnStartNo = 0;
		int grnMaxNo = 0;
		try {
			searchBudgetList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreBudget as mb where mb.Department.Id='"
			+ deptId + "' and mb.Hospital.Id='"+hospitalId+"'");
			storeSetupList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreSetup");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			financialList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreFinancial as msf where msf.Status = 'y' ");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			budgetCodes=getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasBudgetCode as mbc where mbc.Status='y'");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
         // System.out.println("budgetlist"+budgetCodes.size());
		try {
			storeFyDocumentNoList = (List) getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreFyDocumentNo ");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getDepartment().getId() == 1) {
					if (grnMaxNo == 0) {
						grnMaxNo = grnStartNo;
						grnMaxNo = grnMaxNo + 1;
					} else {
						grnMaxNo = grnMaxNo + 1;
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * Session session = (Session)getSession(); String sql =
		 * "SELECT b.sr_no,b.authority_letter_no,b.project_amount,b.budgeted_amount,b.additional_amount FROM mas_store_budget a, mas_store_budget_t b where a.budget_id=b.budget_id and financial_id = 2;"
		 * ; budgetDetailsList = session.createSQLQuery(sql).list();
		 *
		 * //getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasStoreBudgetT as msb where msb.Budget.Financial.Id=13"
		 * );
		 * //System.out.println("budgetDetailsList SIZE In DS-----"+budgetDetailsList
		 * .size());
		 */
		Session session = (Session)getSession();
		maxFin=session.createSQLQuery("select max(msf.FINANCIAL_ID) from MAS_STORE_FINANCIAL msf").list();
		List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
		masStoreFinancialList = session.createCriteria(
				MasStoreFinancial.class).list();
		java.util.Date start_date = null;
		java.util.Date end_date = null;
		java.util.Date poDate=new Date();
		int financial_id = 0;
		for (Iterator iterator2 = masStoreFinancialList.iterator(); iterator2
				.hasNext();) {
			MasStoreFinancial masStoreFinancial = (MasStoreFinancial) iterator2
					.next();
			start_date = (java.util.Date) masStoreFinancial
					.getStartDate();
			end_date = (java.util.Date) masStoreFinancial.getEndDate();
			if (poDate.after(start_date) && poDate.before(end_date)) {
				financial_id = masStoreFinancial.getId();
				break;
			} else if (poDate.equals(start_date)
					|| poDate.equals(end_date)) {
				financial_id = masStoreFinancial.getId();
				break;
			}
		}
		String maxFina=financial_id+"";
		maxFina=maxFin.get(0).toString();
		map.put("financialList", financialList);
		map.put("searchBudgetList", searchBudgetList);
		map.put("maxFina",maxFina);
		// map.put("budgetDetailsList",budgetDetailsList);
		map.put("budgetCodes", budgetCodes);
		map.put("budgetCode", grnMaxNo);
		map.put("storeSetupList", storeSetupList);
		return map;
	}

	public boolean addBudgetEntry(MasStoreBudget masStoreBudget,
			List<MasStoreBudgetT> masStoreBudgetTList,
			Map<String, Object> infoMap) {

		boolean successfullyAdded = false;
		MasStoreBudget masStoreBudget2 = new MasStoreBudget();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");

		hbt.setCheckWriteOperations(false);
		if (!(infoMap.get("headerStored") + "").equals("yes")) {

			try {
				hbt.save(masStoreBudget);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {

			if (masStoreBudgetTList.size() > 0) {
				if ((infoMap.get("headerStored") + "").equals("yes")) {
					int id = Integer.parseInt("" + infoMap.get("budgetId"));
					masStoreBudget2.setId(id);
				}
				for (int i = 0; i < masStoreBudgetTList.size(); i++) {
					MasStoreBudgetT masStoreBudgetTObj = new MasStoreBudgetT();
					masStoreBudgetTObj = (MasStoreBudgetT) masStoreBudgetTList
							.get(i);
					if ((infoMap.get("headerStored") + "").equals("yes")) {
						masStoreBudgetTObj.setBudget(masStoreBudget2);
					} else {
						masStoreBudgetTObj.setBudget(masStoreBudget);
					}
					hbt.save(masStoreBudgetTObj);
				}
				int pageNo = 0;
				pageNo = Integer.parseInt("" + infoMap.get("pageNo"));
				if (pageNo == 1) {
					int StoreFyDocumentNoId = 1;
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
							.load(StoreFyDocumentNo.class, StoreFyDocumentNoId);
					HibernateTemplate hbt2 = getHibernateTemplate();
					hbt2.setFlushModeName("FLUSH_EAGER");
					hbt2.update(storeFyDocumentNo);
				}
			}
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public int getMasStoreBudgetId(int budgetCode) {
		int budgetId = 0;
		List<MasStoreBudget> list = new ArrayList<MasStoreBudget>();
		list = (List) getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreBudget as pod where pod.BudgetCode = '"
						+ budgetCode + "'");
		for (MasStoreBudget masStoreBudget2 : list) {
			budgetId = Integer.parseInt("" + masStoreBudget2.getId());
		}
		return budgetId;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMasStoreBudget(
			Map<String, Object> searchFieldMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBudget> gridIndentHeaderList = new ArrayList<MasStoreBudget>();
		List<MasStoreBudgetT> gridIndentDetailList = new ArrayList<MasStoreBudgetT>();
		List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();
		int financialId = 0;
		// List<MasStoreFinancial> gridFinancialList=null;

		try {
			if ((Integer) searchFieldMap.get("financialId") != 0) {
				financialId = (Integer) searchFieldMap.get("financialId");

				gridIndentDetailList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreBudgetT ");
				gridIndentHeaderList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreBudget as msf where msf.Financial.Id='"
								+ financialId + "'");
				// financialList =getHibernateTemplate().find(
				// "from jkt.hms.masters.business.MasStoreFinancial as msf where msf.Id = '"+financialId+"'");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		financialList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasStoreFinancial as msf where msf.Status = 'y' ");
		// map.put("gridFinancialList",gridFinancialList);
		map.put("financialList", financialList);
		map.put("gridIndentDetailList", gridIndentDetailList);
		map.put("gridIndentHeaderList", gridIndentHeaderList);

		return map;
	}

	public Map<String, Object> getBudgetEntryModifyMap(int radio_str) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBudget> gridStoreBudgetList = new ArrayList<MasStoreBudget>();
		List<MasStoreBudgetT> gridMasStoreBudgetTList = new ArrayList<MasStoreBudgetT>();
		List<MasStoreFinancial> gridMasStoreFinancialList = new ArrayList<MasStoreFinancial>();
		int id = 0;
		gridStoreBudgetList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreBudget as md where md.Id = '"
						+ radio_str + "'");
		for (MasStoreBudget masStoreBudget : gridStoreBudgetList) {
			id = masStoreBudget.getId();
		}

		gridMasStoreBudgetTList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreBudgetT st where st.Budget.Id = '"
						+ radio_str + "'");
		gridMasStoreFinancialList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreFinancial ");

		map.put("budgetList", gridStoreBudgetList);
		map.put("budgetTList", gridMasStoreBudgetTList);
		map.put("financialList", gridMasStoreFinancialList);
		map.put("budgetId", id);

		return map;

	}

	public Map<String, Object> getBudgetAndTUpdate(int budgetId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBudget> gridMasStoreBudgetList = new ArrayList<MasStoreBudget>();
		List<MasStoreBudgetT> gridMasStoreBudgetTList = new ArrayList<MasStoreBudgetT>();
		List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();

		try {
			gridMasStoreBudgetList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreBudget as sm where sm.Id='"
							+ budgetId + "'");
			gridMasStoreBudgetTList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreBudgetT as st where st.Budget.Id='"
							+ budgetId + "'  ");
			financialList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasStoreFinancial as mi where mi.Status = 'y' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("budgetList", gridMasStoreBudgetList);
		map.put("budgetTList", gridMasStoreBudgetTList);
		map.put("financialList", financialList);

		return map;
	}

	public boolean updateBudgetEntry(MasStoreBudget masStoreBudget,
			List<MasStoreBudgetT> masStoreBudgetTList) {
		boolean successfullyAdded = false;
		MasStoreBudget masStoreBudget2 = new MasStoreBudget();
		masStoreBudget2 = masStoreBudget;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");

		hbt.setCheckWriteOperations(false);

		try {

			hbt.update(masStoreBudget2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			if (masStoreBudgetTList.size() > 0) {
				for (int i = 0; i < masStoreBudgetTList.size(); i++) {
					MasStoreBudgetT masStoreBudgetTObj = new MasStoreBudgetT();
					masStoreBudgetTObj = (MasStoreBudgetT) masStoreBudgetTList
							.get(i);
					hbt.update(masStoreBudgetTObj);
				}

			}
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getFinancialYearDetails(
			Map<String, Object> generalMap) {
		List<MasStoreBudget> budgetDetailsList = new ArrayList<MasStoreBudget>();
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = (Session) getSession();
		
		int financialId = Integer.parseInt(generalMap.get("financialId").toString());
		int hospitalId=Integer.parseInt(generalMap.get("hospitalId").toString());
		int deptId=Integer.parseInt(generalMap.get("deptId").toString());
		String budget_code = generalMap.get("budget_code").toString();
		List<MasStoreBudget> financialYearList = session.createCriteria(
				MasStoreBudget.class).add(Restrictions.eq("Status", "y")).add(
				Restrictions.eq("BudgetCode", budget_code)).add(
				Restrictions.eq("Financial.Id", financialId)).add(
						Restrictions.eq("Hospital.Id", hospitalId)).add(
								Restrictions.eq("Department.Id", deptId)).list();
		

		String sql = "SELECT b.sr_no,b.authority_letter_no,b.project_amount,b.budgeted_amount,b.additional_amount FROM mas_store_budget a, mas_store_budget_t b where a.budget_id=b.budget_id and a.financial_id = "
				+ financialId + " and a.budget_code='" + budget_code + "' and a.DEPARTMENT_ID='"+deptId+"' and a.HOSPITAL_ID='"+hospitalId+"'";
		budgetDetailsList = session.createSQLQuery(sql).list();

		map.put("budgetDetailsList", budgetDetailsList);
		map.put("financialYearList", financialYearList);
		return map;
	}

	public boolean addBudgetDetails(Map<String, Object> budgetMap) {
		boolean flag = false;
		MasStoreBudgetT masStoreBudgetT = null;
		int budgetId = 0;

		BigDecimal prevSpendAmount = new BigDecimal(0);
		BigDecimal currentSpendAmount = new BigDecimal(0);
		BigDecimal balanceAmount = new BigDecimal(0);

		String currentDate = "";
		String currentTime = "";

		int srNo = 0;

		if (budgetMap.get("masStoreBudgetT") != null) {
			masStoreBudgetT = (MasStoreBudgetT) budgetMap
					.get("masStoreBudgetT");
		}
		if (budgetMap.get("prevSpendAmount") != null) {
			prevSpendAmount = (BigDecimal) budgetMap.get("prevSpendAmount");
		}
		if (budgetMap.get("currentSpendAmount") != null) {
			currentSpendAmount = (BigDecimal) budgetMap
					.get("currentSpendAmount");
		}
		if (budgetMap.get("balanceAmount") != null) {
			balanceAmount = (BigDecimal) budgetMap.get("balanceAmount");
		}
		if (budgetMap.get("currentDate") != null) {
			currentDate = (String) budgetMap.get("currentDate");
		}
		if (budgetMap.get("currentTime") != null) {
			currentTime = (String) budgetMap.get("currentTime");
		}
		if (!budgetMap.get("budgetId").equals("0")) {
			budgetId = (Integer) budgetMap.get("budgetId");
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<MasStoreBudgetT> list = hbt
				.find("from jkt.hms.masters.business.MasStoreBudgetT as sm where sm.Budget.Id='"
						+ budgetId + "' order by sm.SrNo desc");

		if (list != null && list.size() > 0) {
			srNo = list.get(0).getSrNo().intValue();
		}
		masStoreBudgetT.setSrNo(++srNo);
		hbt.save(masStoreBudgetT);

		MasStoreBudget obj = (MasStoreBudget) hbt.load(MasStoreBudget.class,
				budgetId);

		BigDecimal totalAllocatedAmt = new BigDecimal(0);
		BigDecimal balanceAmt = new BigDecimal(0);
		BigDecimal budgetedAmt = null;
		BigDecimal additionalAmt = null;

		if (obj.getTotalAllocatedAmount() != null)
			totalAllocatedAmt = obj.getTotalAllocatedAmount();

		if (obj.getBalanceAmount() != null)
			balanceAmt = obj.getTotalAllocatedAmount();

		if (masStoreBudgetT.getBudgetedAmount() != null)
			budgetedAmt = masStoreBudgetT.getBudgetedAmount();
		else
			budgetedAmt = new BigDecimal(0);

		if (masStoreBudgetT.getAdditionalAmount() != null)
			additionalAmt = masStoreBudgetT.getAdditionalAmount();
		else
			additionalAmt = new BigDecimal(0);

		totalAllocatedAmt = totalAllocatedAmt.add(budgetedAmt).add(
				additionalAmt);
		balanceAmt = balanceAmt.add(budgetedAmt).add(additionalAmt);
		obj.setSpendAmount(prevSpendAmount.add(currentSpendAmount));
		obj.setBalanceAmount(balanceAmt);
		obj.setTotalAllocatedAmount(totalAllocatedAmt);
		obj
				.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(currentDate));
		obj.setLastChgTime(currentTime);
		obj.setLastChgBy("admin");
		obj.setStatus("y");

		hbt.update(obj);
		hbt.refresh(obj);
		flag = true;
		return flag;
	}

	public Map<String, Object> getConnection() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	// --------------------------------Mas Store
	// Group------------------------------
	public Map<String, Object> showStoreGroupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreGroup> searchGroupList = new ArrayList<MasStoreGroup>();
		searchGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreGroup");
		map.put("searchGroupList", searchGroupList);
		return map;
	}

	public boolean addStoreGroup(MasStoreGroup masStoreGroup) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreGroup);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteStoreGroup(int groupId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreGroup masStoreGroup = new MasStoreGroup();
		masStoreGroup = (MasStoreGroup) getHibernateTemplate().get(
				MasStoreGroup.class, groupId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreGroup.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreGroup.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreGroup.setLastChgBy(changedBy);
		masStoreGroup.setLastChgDate(currentDate);
		masStoreGroup.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreGroup);
		return dataDeleted;
	}

	public boolean editGroupToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String groupName = "";
		@SuppressWarnings("unused")
		String groupCode = "";
		int groupId = 0;
		String changedBy = "";
		groupId = (Integer) generalMap.get("id");
		groupCode = (String) generalMap.get("relationCode");
		groupName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreGroup masStoreGroup = (MasStoreGroup) getHibernateTemplate()
				.get(MasStoreGroup.class, groupId);

		masStoreGroup.setId(groupId);
		masStoreGroup.setGroupName(groupName);
		masStoreGroup.setLastChgBy(changedBy);
		masStoreGroup.setLastChgDate(currentDate);
		masStoreGroup.setLastChgTime(currentTime);
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreGroup);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchStoreGroup(String groupCode,
			String groupName) {
		List<MasStoreGroup> searchGroupList = new ArrayList<MasStoreGroup>();
		Map<String, Object> groupFieldsMap = new HashMap<String, Object>();
		try {
			if ((groupName != null) || (groupCode == null)) {
				searchGroupList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreGroup mr where mr.GroupName like '"
								+ groupName + "%' order by mr.GroupName");
			} else {
				searchGroupList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreGroup mr where mr.GroupCode like '"
								+ groupCode + "%' order by mr.GroupCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		groupFieldsMap.put("searchGroupList", searchGroupList);
		return groupFieldsMap;
	}

	public int addBudgetMaster(Map<String, Object> generalMap) {
		MasStoreBudget masStoreBudget = new MasStoreBudget();
		if (generalMap.get("masStoreBudget") != null) {
			masStoreBudget = (MasStoreBudget) generalMap.get("masStoreBudget");
		}

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreBudget);
		hbt.refresh(masStoreBudget);
		return masStoreBudget.getId();
	}
	//--Method For Connction of Reports-------------------------
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

	@Override
	public Map<String, Object> generatePVMSExcel(Map<String, Object> requestParameters) {
		String hospitalName = null;
	    int hospitalId=0;
	    int deptId=0;
		String deptName = null;
		Session session = (Session) getSession();
		 Map<String, Object> dataMap = new HashMap<String, Object>();
	    List storeItemList=new ArrayList();
		if(requestParameters.get("hospitalName") != null){
	    	hospitalName = (String)requestParameters.get("hospitalName");
	    }
	    if(requestParameters.get("hospitalId") != null){
	    	hospitalId = (Integer)requestParameters.get("hospitalId");
	    }
	    if(requestParameters.get("deptName") != null){
	    	deptName = (String)requestParameters.get("deptName");
	    }
	    if(requestParameters.get("deptId") != null){
	    	deptId = (Integer)requestParameters.get("deptId");
	    }
	    storeItemList=session.createCriteria(MasStoreItem.class).add(Restrictions.eq("Status", "y")).
	    createAlias("ItemType", "itm").add(Restrictions.eq("itm.ItemTypeName", "PVMS")).list();
	   // storeItemList=session.createSQLQuery(qry).list();
	    Iterator itr=storeItemList.iterator();
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Stock Status Report");
		//sheet.setColumnWidth((short) 1, (short)10);
		// Create a new font and alter it.
		
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor((short) 80);
		font.setItalic(false);
		font.setStrikeout(false);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		
		HSSFFont font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 12);
		font1.setFontName(HSSFFont.FONT_ARIAL);
		font1.setColor((short) 80);
		font1.setItalic(false);
		font1.setStrikeout(false);
		font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		
		HSSFFont font2 = wb.createFont();
		font2.setFontHeightInPoints((short) 9);
		font2.setFontName(HSSFFont.FONT_ARIAL);
		font2.setColor((short) 80);
		font2.setItalic(false);
		font2.setStrikeout(false);
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		// Fonts are set into a style so create a new one to
		// use.
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment((short) 2);
		
		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setFont(font1);
		style1.setAlignment((short) 2);
		
		HSSFCellStyle style2 = wb.createCellStyle();
		style2.setFont(font2);
		style2.setAlignment((short) 2);
		
		//style1.setLocked(true);

			HSSFRow row2 = sheet.createRow((short) 2);
			HSSFCell cell20 = row2.createCell((short) 3);
			cell20.setCellValue(new HSSFRichTextString(hospitalName));
			cell20.setCellStyle(style1);
			sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));

			HSSFRow row3 = sheet.createRow((short) 3);
			HSSFCell cell30 = row3.createCell((short) 3);
			cell30.setCellValue(new HSSFRichTextString("Medicine Master"));
			cell30.setCellStyle(style1);
			sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));
			
			//HSSFCell cell32 = row3.createCell((short) 7);
			//cell32.setCellValue(new HSSFRichTextString("25/12/2011"));

			HSSFRow row4 = sheet.createRow((short) 4);
			HSSFCell cell40 = row4.createCell((short) 1);
			cell40.setCellStyle(style1);
			cell40.setCellValue(new HSSFRichTextString(""));
			sheet.addMergedRegion(new Region(4, (short) 0, 4, (short) 7));

           // =====Heading Row Start===========================	
			HSSFRow headingRow1 = sheet.createRow((short) 5);
			
			HSSFCell cell70 = headingRow1.createCell((short) 0);
			cell70.setCellValue(new HSSFRichTextString("SR. NO."));
			cell70.setCellStyle(style2);
			sheet.autoSizeColumn((short) 0);
			
			HSSFCell cell71 = headingRow1.createCell((short) 1);
			cell71.setCellValue(new HSSFRichTextString("PVMS No."));
			cell71.setCellStyle(style2);
			sheet.autoSizeColumn((short) 1);
			
			HSSFCell cell72 = headingRow1.createCell((short) 2);
			cell72.setCellValue(new HSSFRichTextString("       Nomenclature                "));
			cell72.setCellStyle(style2);
			sheet.autoSizeColumn((short) 2);
			
			HSSFCell cell73 = headingRow1.createCell((short) 3);
			cell73.setCellValue(new HSSFRichTextString("Section"));
			cell73.setCellStyle(style2);
			sheet.autoSizeColumn((short) 3);
			
			HSSFCell cell74 = headingRow1.createCell((short) 4);
			cell74.setCellValue(new HSSFRichTextString("A/U"));
			cell74.setCellStyle(style2);
			sheet.autoSizeColumn((short) 4);
			
			HSSFCell cell75 = headingRow1.createCell((short) 5);
			cell75.setCellStyle(style);
			cell75.setCellValue(new HSSFRichTextString("Spec"));
			cell75.setCellStyle(style2);
			sheet.autoSizeColumn((short) 5);
			
			HSSFCell cell76 = headingRow1.createCell((short) 6);
			cell76.setCellValue(new HSSFRichTextString("Life"));
			cell76.setCellStyle(style2);
			sheet.autoSizeColumn((short) 6);
			
			HSSFCell cell77 = headingRow1.createCell((short) 7);
			cell77.setCellValue(new HSSFRichTextString("Rate"));
			cell77.setCellStyle(style2);
			sheet.autoSizeColumn((short) 7);
			
			HSSFCell cell78 = headingRow1.createCell((short) 7);
			cell77.setCellValue(new HSSFRichTextString("UOM"));
			cell77.setCellStyle(style2);
			sheet.autoSizeColumn((short) 8);
			
			
			HSSFCell cell79 = headingRow1.createCell((short) 7);
			cell77.setCellValue(new HSSFRichTextString("Source"));
			cell77.setCellStyle(style2);
			sheet.autoSizeColumn((short) 9);
			
			HSSFCell cell80 = headingRow1.createCell((short) 7);
			cell77.setCellValue(new HSSFRichTextString("  Remarks "));
			cell77.setCellStyle(style2);
			sheet.autoSizeColumn((short) 10);
			
			HSSFCell cell81 = headingRow1.createCell((short) 7);
			cell77.setCellValue(new HSSFRichTextString("Min Stock"));
			cell77.setCellStyle(style2);
			sheet.autoSizeColumn((short) 11);
										
			//============Heading Completed=======================

			//Region(int rowFrom, short colFrom, int rowTo, short colTo)
		//	sheet.addMergedRegion(new Region(6, (short) 1, 6, (short) 2));


    int row=6;
    int i=1;
    while(itr.hasNext())
    {
         
          MasStoreItem  masItem = (MasStoreItem)itr.next(); 
          String pvms_no=masItem.getPvmsNo();
          String nomenclature=masItem.getNomenclature();
          String SectionName="";
          String a_u="";
          String specification="";
          String life="";
          String rate="";
          String uom="";
          String source="";
          String remarks="";
          float minStock=(float) 0.0;
          
          if(masItem.getSection() !=null){
        	  if(masItem.getSection().getSectionName() !=null){
        	  SectionName=masItem.getSection().getSectionName();
        	  }
          }
          if(masItem.getItemConversion() !=null){
        	  if(masItem.getItemConversion().getItemUnitName() !=null){
        	  a_u=masItem.getItemConversion().getItemUnitName();
          }
          }
          if(masItem.getSpecification() !=null){
        	  specification=masItem.getSpecification();
          }
          if(masItem.getCostPrice() !=null){
        	  rate=masItem.getCostPrice();
          }
          if(masItem.getItemConversion().getIntermediateUnit() !=null){
        	  if(masItem.getItemConversion().getIntermediateUnit().getUnitName() !=null){
        	  uom=masItem.getItemConversion().getIntermediateUnit().getUnitName();
          } }
          if(masItem.getSourceOfSupply()!=null && !masItem.getSourceOfSupply().equals("0")) {
        	  if(masItem.getSourceOfSupply().equalsIgnoreCase("R")){
        	  source="Rate Contract";
          }else if(masItem.getSourceOfSupply().equalsIgnoreCase("L")){
        	  source="Local purchase";
          }else if(masItem.getSourceOfSupply().equals("P")){
        	  source= "PPP";
          } else if(masItem.getSourceOfSupply().equals("D")){
        	  source= "Depot.";
        	  }
          }else{
        	  source=" ";
          }
        	  
          if(masItem.getRemarks() !=null){
        	  remarks=masItem.getRemarks();
          }
          if(masItem.getMinStock() !=null){
        	  minStock=masItem.getMinStock();
          }
    	/*Object[] pair = (Object[]) itr.next();
    	 String pvms_no=
    	float received_qty=Float.parseFloat(pair[0].toString());
    	float issue_qty=Float.parseFloat(pair[1].toString());
    	float opening_balance_qty=Float.parseFloat(pair[2].toString());
    	float adjust_qty=Float.parseFloat(pair[3].toString());
        String pvms_no=pair[4].toString();
        String nomenclature=pair[5].toString();
        float issue_return=Float.parseFloat(pair[6].toString());
        float balance_qty=Float.parseFloat(pair[7].toString());
        float item_id=Float.parseFloat(pair[8].toString());*/
        
    	HSSFRow detailRow = sheet.createRow((short) row);

    	HSSFCell cell90 = detailRow.createCell((short) 0);
		cell90.setCellValue(i);
		
		HSSFCell cell91 = detailRow.createCell((short) 1);
		cell91.setCellValue(new HSSFRichTextString(pvms_no));
	
		
		HSSFCell cell92 = detailRow.createCell((short) 2);
		cell92.setCellValue(new HSSFRichTextString(nomenclature));
	
		HSSFCell cell93 = detailRow.createCell((short) 3);
		cell93.setCellValue(SectionName);
		
		HSSFCell cell94 = detailRow.createCell((short) 4);
		cell94.setCellValue(a_u);
			
		HSSFCell cell95 = detailRow.createCell((short) 5);
		cell95.setCellValue(specification);
				
		HSSFCell cell96 = detailRow.createCell((short) 6);
		cell96.setCellValue(life);	
		
		HSSFCell cell97 = detailRow.createCell((short) 7);
		cell97.setCellValue(rate);	
		
		HSSFCell cell98 = detailRow.createCell((short) 8);
		cell98.setCellValue(uom);
		
		HSSFCell cell99 = detailRow.createCell((short) 9);
		cell90.setCellValue(source);
		
		HSSFCell cell100 = detailRow.createCell((short) 10);
		cell100.setCellValue(remarks);
		
		HSSFCell cell101 = detailRow.createCell((short) 11);
		cell101.setCellValue(minStock);
	i++;
		row = row + 1;	
    }
    
    dataMap.put("wb", wb);	    
   
	    return requestParameters;
	}

	public boolean updateMeScale(Box box)
	{
			boolean successfullyAdded = false;
			Map<String,Object>  map=new HashMap<String,Object>();
			HibernateTemplate hbt = getHibernateTemplate();
			List<MasStoreMeScale>masStoreMeScaleList=new ArrayList<MasStoreMeScale>();
			List<StoreMeScaleDetails>storeMeScaleDetailsList=new ArrayList<StoreMeScaleDetails>();
			Session session = (Session) getSession();
			String meScaleNumber = "";
			String meScaleDescription = "";
			Date changedDate = null;
			String changedBy = "";		
			String changedTime = "";
			String msg="";
			int j=0;
			int deptId=0;
			int hospitalId=0;
			int itemId=0;
			int headerId=0;
			if (box.get("deptId") != null) {
				deptId = Integer.parseInt("" + box.get("deptId"));
			}
			if (box.get("hospitalId") != null) {
				hospitalId = Integer.parseInt("" + box.get("hospitalId"));
			}
			
			if(box.get(ME_SCALE_NUMBER) != null && !(box.get(ME_SCALE_NUMBER).equals(""))){
			meScaleNumber = box.get(ME_SCALE_NUMBER);
			}
			if(box.get(ME_SCALE_DESCRIPTION) != null && !(box.get(ME_SCALE_DESCRIPTION).equals(""))){
				meScaleDescription = box.get(ME_SCALE_DESCRIPTION);
			}
			if(box.get(CHANGED_BY) !=null){
				changedBy = box.get(CHANGED_BY);
			}
			if(box.get(CHANGED_DATE) != null){
				changedDate = HMSUtil.dateFormatterDDMMYYYY(box.get(CHANGED_DATE));
			}
			if(box.get(CHANGED_TIME) != null){
				changedTime = box.get(CHANGED_TIME);
			}
		
			try{
				headerId=box.getInt("headerId");
				storeMeScaleDetailsList = getHibernateTemplate().find("from jkt.hms.masters.business.StoreMeScaleDetails ms where ms.MeScale.Id='"+headerId+"'");
				MasStoreMeScale masStoreMeScale = (MasStoreMeScale)session.load(MasStoreMeScale.class, headerId);
				masStoreMeScale.setMeScale(meScaleNumber);
				masStoreMeScale.setMeScaleDescription(meScaleDescription);
		 		hospitalId=box.getInt("hospitalId");
		 		hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
		 		hbt.update(masStoreMeScale);
		 		
		 		
		 		
		 		Vector<String> detailId = box.getVector("detailId");
		 		Vector<String> serial = box.getVector(SR_NO);
		 		Vector<String> idItem = box.getVector("idItem");
		 		Vector<String> qty = box.getVector("qty");
		 		int unitId2=0;
		 		int k=serial.size();
		 		int l=storeMeScaleDetailsList.size();
		 		BigDecimal qty1=null;
		 		
		 		{
		 			for(int i=l;i>k;i--)
		 			{
		 				int m=i-1;
		 				StoreMeScaleDetails storeMeScaleDetails = (StoreMeScaleDetails)session.load(StoreMeScaleDetails.class, Integer.parseInt(detailId.get((m))));	
		 				hbt.delete(storeMeScaleDetails);
		 			}
		 		}
		 	
		 		int unitId1=0;
		 		int i;
		 		List<StoreMeScaleDetails>storeMeScaleDetailsList1=new ArrayList<StoreMeScaleDetails>();
		 		
		 		storeMeScaleDetailsList1 = getHibernateTemplate().find("from jkt.hms.masters.business.StoreMeScaleDetails ms where ms.MeScale.Id='"+headerId+"'");
		 		for(i=0;i<storeMeScaleDetailsList1.size();i++){
		 			
		 			StoreMeScaleDetails storeMeScaleDetails = (StoreMeScaleDetails)session.load(StoreMeScaleDetails.class, Integer.parseInt(detailId.get(i)));	
		 			storeMeScaleDetails.setMeScale(masStoreMeScale);
		 			MasStoreItem masStoreItem=new MasStoreItem();
		 			itemId=Integer.parseInt(idItem.get(i));
		 			masStoreItem.setId(itemId);
		 			storeMeScaleDetails.setSerialNo(Integer.parseInt(serial.get(i)));
		 			storeMeScaleDetails.setItem(masStoreItem);
		 			storeMeScaleDetails.setQty(new BigDecimal(qty.get(i)));
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(storeMeScaleDetails);
				}
		 		
		 		if(storeMeScaleDetailsList.size()<serial.size())
		 		{
		 			//for(i=k-1;i>=l;i--)
		 			for(i=l;i<k;i++)
		 			{
		 				StoreMeScaleDetails storeMeScaleDetails1=new StoreMeScaleDetails();
		 			
		 			storeMeScaleDetails1.setMeScale(masStoreMeScale);
		 			storeMeScaleDetails1.setSerialNo(Integer.parseInt(serial.get(i)));
		 			MasStoreItem masStoreItem=new MasStoreItem();
		 			itemId=Integer.parseInt(idItem.get(i));
		 			masStoreItem.setId(itemId);
		 			storeMeScaleDetails1.setItem(masStoreItem);
		 			storeMeScaleDetails1.setQty(new BigDecimal(qty.get(i)));
		 			storeMeScaleDetails1.setLastChgBy(changedBy);
		 			storeMeScaleDetails1.setLastChgDate(changedDate);
		 			storeMeScaleDetails1.setLastChgTime(changedTime);
		 			MasDepartment masDepartment=new MasDepartment();
		 			masDepartment.setId(deptId);
		 			storeMeScaleDetails1.setDepartment(masDepartment);
		 			MasHospital mh=new MasHospital();
		 			mh.setId(hospitalId);
		 			storeMeScaleDetails1.setHospital(mh);
		 			hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.save(storeMeScaleDetails1);
		 			}
		 		}
		 	
		 		successfullyAdded=true;
		 	
			}catch (Exception e) {
				e.printStackTrace();
				successfullyAdded=false;
			}
			
			return successfullyAdded;
	}
	
	/*************************************** For Show Repair Station Jsp  **************/
	
	public Map<String,Object>showRepairStationJsp(Map dataMap)
	{
		Map<String,Object>map=new HashMap<String, Object>();
		int hospitalId=(Integer)dataMap.get("hospitalId");
		List<MasRepairStation>repairStationList=new ArrayList<MasRepairStation>();
		Session session = (Session) getSession();
		repairStationList=session.createCriteria(MasRepairStation.class)
		//.add(Restrictions.eq("Status", "y"))
		.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
	
		map.put("repairStationList",repairStationList);
		return map;
	}
	
	/******************************** Method For Add RepairStation         *****************/
	
	public boolean addRepairStation(MasRepairStation masRepairStation) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masRepairStation);
		successfullyAdded = true;
		return successfullyAdded;
	}
	
	public boolean editRepairStation(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int financialId = 0;
		String repairStationCode = "";
		String repairStationName = "";
		String changedBy = "";
		financialId = (Integer) generalMap.get("id");
		repairStationCode = (String) generalMap.get("repairStationCode");
		repairStationName = (String) generalMap.get("repairStationName");
		
		MasRepairStation masRepairStation = (MasRepairStation) getHibernateTemplate()
				.load(MasRepairStation.class, financialId);
		masRepairStation.setId(financialId);
		masRepairStation.setStationCode(repairStationCode);
		masRepairStation.setStationName(repairStationName);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRepairStation);
		dataUpdated = true;
		return dataUpdated;
	}
	
	
	public boolean deleteRepairStation(int financialId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasRepairStation masRepairStation = new MasRepairStation();
		masRepairStation = (MasRepairStation) getHibernateTemplate().load(
				MasRepairStation.class, financialId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masRepairStation.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masRepairStation.setStatus("y");
				dataDeleted = false;
			}
		}
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRepairStation);
		return dataDeleted;
	}
	
	
	// ------------------------------- Budget Code
		// -------------------------------------------

		public Map<String, Object> showBudgetCodeJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasBudgetCode> searchBudgetCodeList = new ArrayList<MasBudgetCode>();
			Session session=(Session)getSession();
			searchBudgetCodeList=session.createCriteria(MasBudgetCode.class).list();
			map.put("searchBudgetCodeList", searchBudgetCodeList);
			return map;
		}

		public Map<String, Object> searchBudgetCode(String budgetCodeCode,
				String budgetCodeName) {
			List<MasBudgetCode> searchBudgetCodeList = new ArrayList<MasBudgetCode>();
			Map budgetCodeFieldsMap = new HashMap();
			Session session=(Session)getSession();
			try {
				if ((budgetCodeName != null) || (budgetCodeCode == null)) {
					
					searchBudgetCodeList=session.createCriteria(MasBudgetCode.class)
					.add(Restrictions.like("BudgetCodeName","%"+ budgetCodeName+"%").ignoreCase())
					.addOrder(Order.asc("BudgetCodeName")).list();
					
				} else {
					
					searchBudgetCodeList=session.createCriteria(MasBudgetCode.class).add(Restrictions.like("BudgetCodeCode","%"+budgetCodeCode+"%").ignoreCase())
	.addOrder(Order.asc("BudgetCodeCode")).list();
				}
			} catch (Exception e) {
				//System.out.println("Ds excp in searchMajorCategoryCode  " + e);
			}
			budgetCodeFieldsMap.put("searchBudgetCodeList",
					searchBudgetCodeList);
			return budgetCodeFieldsMap;
		}

		public boolean editBudgetCodeToDatabase(Map<String, Object> generalMap) {
			boolean dataUpdated = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			String budgetCodeName = "";
			@SuppressWarnings("unused")
			String budgetCodeCode = "";
			int budgetCodeId = 0;
			String changedBy = "";
			budgetCodeId = (Integer) generalMap.get("id");
			budgetCodeCode = (String) generalMap.get("budgetCodeCode");
			budgetCodeName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			MasBudgetCode masBudgetCode = (MasBudgetCode) getHibernateTemplate()
					.get(MasBudgetCode.class, budgetCodeId);

			masBudgetCode.setId(budgetCodeId);
			masBudgetCode.setBudgetCodeName(budgetCodeName);
			masBudgetCode.setLastChangeBy(changedBy);
			masBudgetCode.setLastChangeDate(currentDate);
			masBudgetCode.setLastChangeTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masBudgetCode);
			dataUpdated = true;
			return dataUpdated;
		}

		public boolean addBudgetCode(MasBudgetCode masBudgetCode) {
			boolean successfullyAdded = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masBudgetCode);
			successfullyAdded = true;
			return successfullyAdded;
		}

		public boolean deleteBudgetCode(int budgetCodeId,
				Map<String, Object> generalMap) {
			boolean dataDeleted = false;
			String changedBy = "";
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			MasBudgetCode masBudgetCode = new MasBudgetCode();
			masBudgetCode = (MasBudgetCode) getHibernateTemplate().get(
					MasBudgetCode.class, budgetCodeId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (masBudgetCode.getStatus().equals("y")) {
				masBudgetCode.setStatus("n");
				dataDeleted = true;
			} else {
				masBudgetCode.setStatus("y");
				dataDeleted = false;
			}
			masBudgetCode.setLastChangeBy(changedBy);
			masBudgetCode.setLastChangeDate(currentDate);
			masBudgetCode.setLastChangeTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masBudgetCode);
			return dataDeleted;
		}
		
		@Override
		public Map<String, Object> getItemTypeGLList(Map<String, Object> dataMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasItemType> masItemTypeList = new ArrayList<MasItemType>();
			Session session = (Session) getSession();
			
			session = (Session) getSession();
			int group = 0;
			try {
				
				if(dataMap.get("group") != null ){
					group = (Integer)dataMap.get("group");
				}
				masItemTypeList = session.createCriteria(MasItemType.class)
							.createAlias("Group", "g")
							.add(Restrictions.eq("g.Id",group))
							.add(Restrictions.eq("Status", "y").ignoreCase()).list();



				

			} catch (Exception e) {
				e.printStackTrace();
			}

			map.put("masItemTypeList", masItemTypeList);
			return map;

	}

		@Override
		public Map<String, Object> getSectionGLList(Map<String, Object> dataMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasStoreSection> masStoreSectionList = new ArrayList<MasStoreSection>();
			Session session = (Session) getSession();
			
			session = (Session) getSession();
			int itemType = 0;
			try {
				
				if(dataMap.get("itemType") != null ){
					itemType = (Integer)dataMap.get("itemType");
				}
				masStoreSectionList = session.createCriteria(MasStoreSection.class)
							.createAlias("ItemType", "g")
							.add(Restrictions.eq("g.Id",itemType))
							//.add(Restrictions.eq("SectionName","Medicinal"))
							.add(Restrictions.eq("Status", "y").ignoreCase()).list();



				

			} catch (Exception e) {
				e.printStackTrace();
			}

			map.put("masStoreSectionList", masStoreSectionList);
			return map;

	}

		@Override
		public Map<String, Object> getCategoryList(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
			List<MasItemClass> classList = new ArrayList<MasItemClass>();
			Session session = (Session) getSession();
			try {
				categoryList = session.createCriteria(MasItemCategory.class)
						.createAlias("Section", "section")
						.add(Restrictions.eq("section.Id", box.getInt("section")))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();
				classList = session.createCriteria(MasItemClass.class)
						.createAlias("Section", "section")
						.add(Restrictions.eq("section.Id", box.getInt("section")))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			} catch (Exception e) {
				e.printStackTrace();
			}

			map.put("categoryList", categoryList);
			map.put("classList", classList);
			return map;

		}

		
		// ---------------------------------- Item
		// Class-------------------------------------
		
		  @SuppressWarnings("unchecked")
		  public Map<String, Object> showItemClassJsp(){
			  Map<String,Object> map=new HashMap<String,Object>();
		  try{ 
			  List<MasItemClass> searchItemClassList = new ArrayList<MasItemClass>();
			  List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
			  Session session = (Session)getSession();
			  searchItemClassList = getHibernateTemplate().find( "from jkt.hms.masters.business.MasItemClass");
			  sectionList = session.createCriteria(MasStoreSection.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			  map.put("searchItemClassList",searchItemClassList);
			  map.put("sectionList",sectionList);
			  }catch (Exception e) {
			  } 
		  return map; }
		 
		  public boolean addItemClass(MasItemClass masItemClass) {
			  boolean successfullyAdded=false;
			  try {
			  org.springframework.orm.hibernate3.HibernateTemplate 
			  hbt = getHibernateTemplate();
			  hbt.setFlushModeName("FLUSH_EAGER");
			  hbt.setCheckWriteOperations(false); 
			  hbt.save(masItemClass);
			  successfullyAdded = true; 
			  } catch (DataAccessException e) 
			  {
			  e.printStackTrace(); 
			  } 
		  return successfullyAdded; 
		  }
		 
		  @SuppressWarnings("unchecked") public boolean deleteItemClass(int itemClassId,Map<String, Object> generalMap) {
			  boolean dataDeleted=false;
			  int userId = 0;
			  Date currentDate = new Date();
			  String currentTime= "";
			  currentTime =(String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			  try{
			  MasItemClass masItemClass= new MasItemClass();
			  masItemClass=(MasItemClass)getHibernateTemplate().load(MasItemClass.class,itemClassId); 
			  userId =(Integer)generalMap.get("changedBy");
			  currentDate=(Date)generalMap.get("currentDate");
			  currentTime=(String)generalMap.get("currentTime");
			  if (masItemClass.getStatus().equalsIgnoreCase("y")){
			  masItemClass.setStatus("n");
			  dataDeleted=true; 
			  }else{
			  masItemClass.setStatus("y");
			  dataDeleted=false;
			  }
			  Users users = new Users();
			  users.setId(userId);
			  masItemClass.setLastChgBy(users);
			  masItemClass.setLastChgDate(currentDate);
			  masItemClass.setLastChgTime(currentTime);
			  org.springframework.orm.hibernate3.HibernateTemplate hbt =
			  getHibernateTemplate();
			  hbt.setFlushModeName("FLUSH_EAGER");
			  hbt.setCheckWriteOperations(false);
			  hbt.update(masItemClass);
			  }catch
			  (Exception e) { 
			  } return dataDeleted;
		  }
		 
		  public boolean editItemClassToDatabase(Map<String, Object> generalMap) {
			  boolean dataUpdated=false;
			  Date currentDate = new Date();
			  String currentTime = "";
			  currentTime =(String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
			  String itemClassName=""; 
			 String itemClassCode="";
			 int itemClassId=0;
			 int sectionId = 0;
			 int userId = 0;
			  itemClassId=(Integer)generalMap.get("id");
			  sectionId=(Integer)generalMap.get("sectionId");
			  itemClassCode=(String)generalMap.get("itemClassCode");
			  itemClassName=(String)generalMap.get("name");
			  userId = (Integer)generalMap.get("changedBy");
			  currentDate=(Date)generalMap.get("currentDate");
			  currentTime=(String)generalMap.get("currentTime");
			  System.out.println("itemClassId---------"+itemClassId);
			  System.out.println("sectionId---------"+sectionId);
			  
			  MasItemClass masItemClass =(MasItemClass)getHibernateTemplate().load(MasItemClass.class, itemClassId);
			  
			  masItemClass.setId(itemClassId);
			  
			  masItemClass.setItemClassName(itemClassName);
			  
			  MasStoreSection masStoreSection = new MasStoreSection();
			  masStoreSection.setId(sectionId);
			  masItemClass.setSection(masStoreSection);
			  
			  Users users = new Users();
			  users.setId(userId);
			  masItemClass.setLastChgBy(users);
			  
			  masItemClass.setLastChgDate(currentDate);
			  masItemClass.setLastChgTime(currentTime);
			  org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			  hbt.setFlushModeName("FLUSH_EAGER");
			  hbt.setCheckWriteOperations(false);
			  hbt.update(masItemClass);
			  dataUpdated = true; 
		  return dataUpdated;
		  }
		 
		  @SuppressWarnings("unchecked") public Map searchItemClass(String itemClassCode,String itemClassName) { 
			  List<MasItemClass>searchItemClassList=new ArrayList<MasItemClass>();
			  Map itemClassFieldsMap = new HashMap();
				Session session =(Session)getSession();
			  try{
			  if((itemClassName!=null) ||(itemClassCode==null)){
				  
				  searchItemClassList =session.createCriteria(MasItemClass.class).add(Restrictions.like("ItemClassName","%"+itemClassName+"%").ignoreCase()).addOrder(Order.asc("ItemClassName")).list();
		  	 } else{
		  		 
		  		searchItemClassList =session.createCriteria(MasItemClass.class).add(Restrictions.like("ItemClassCode","%"+itemClassCode+"%").ignoreCase()).addOrder(Order.asc("ItemClassCode")).list();
		  		 }
			  }catch (Exception e) {
		   }
		  itemClassFieldsMap.put("searchItemClassList",searchItemClassList);
		  return itemClassFieldsMap;
		  }
		 
		  
		  
		// -----------------------------------------item
			// master---------------------------------------

			@SuppressWarnings("unchecked")
			public Map<String, Object> showItemNIPJsp(int deptId,int hospitalId) {
				Map<String, Object> map = new HashMap<String, Object>();
				Session session = (Session) getSession();
				try {
					List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
					List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
					List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
					List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
					List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
					List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
					List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
					List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
					List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
					List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
					List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
					List<MasStoreBrand> gridBrandList = new ArrayList<MasStoreBrand>();
					List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
					/*String transactionSequenceName = "Item Code";
					List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
					int orderNo = 0;
					sequenceNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionSequenceName",transactionSequenceName)).list();
					TransactionSequence transactionSequence = sequenceNoList.get(0);
					int sequenceNo = transactionSequence.getTransactionSequenceNumber();
					orderNo = sequenceNo + 1;
					*/
					// Criteria c = session.createCriteria(MasStoreItem.class)
					// .add(Restrictions.eq("Department.Id", deptId));
					// c.setFirstResult(0);
					// c.setMaxResults(1000);
					// searchItemList = c.list();
					
					masItemClassList= getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemClass where upper(Status) =upper('y')");


				 	
				 	searchItemList = session.createCriteria(MasStoreItem.class)
				 			.createAlias("ItemClassification", "it").add(Restrictions.eq("it.Id",2))
				 			//.createAlias("ItemType", "it").add(Restrictions.eq("it.ItemTypeName","MEDICAL CONSUMABLE").ignoreCase())
				 			.list();
			
					sectionList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasStoreSection as s where upper(s.Status) =upper('y')");
				
					
					itemTypeList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasItemType as mc where upper(mc.Status) = upper('y')");
					itemCategoryList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasItemCategory as mc where upper(mc.Status) = upper('y')");
					itemConversionList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasStoreItemConversion as mc where upper(mc.Status) = upper('y')");
					groupList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");

					map.put("searchItemList", searchItemList);
					map.put("storeSectionList", sectionList);
					map.put("itemTypeList", itemTypeList);
					map.put("itemCategoryList", itemCategoryList);
					map.put("itemConversionList", itemConversionList);
					map.put("manufacturerList", manufacturerList);
					map.put("storeSupplierList", supplierList);
					map.put("departmentList", departmentList);
					map.put("departmentList1", departmentList1);
					map.put("groupList", groupList);
					map.put("brandList", brandList);
					map.put("gridBrandList", gridBrandList);
					
					map.put("masItemClassList", masItemClassList);
					//map.put("orderNo", orderNo);

				} catch (Exception e) {
					e.printStackTrace();
				}
				return map;
				/*	List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();

					List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
					List<MasStoreItemGeneric> itemGenericList = new ArrayList<MasStoreItemGeneric>();
					List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
					List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
					List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
					List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
					List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
					List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
					List<MasItemClass> gridItemClassList = new ArrayList<MasItemClass>();
					List<MasCompany> companyList = new ArrayList<MasCompany>();
					List<MasStoreUnit>uomList=new ArrayList<MasStoreUnit>();
					
					
					 * Commented For Not Displaying Item List //String
					 * query="select * from mas_store_item where department_id='"
					 * +deptId+"'";
					 
					
					 * Criteria c = session.createCriteria(MasStoreItem.class)
					 * .add(Restrictions.eq("Department.Id",deptId ));
					 * c.setFirstResult(0); c.setMaxResults(1000);
					 
					// searchItemList = c.list();
					List<Object> searchItemListforPvms = new ArrayList<Object>();
					
					 * Commented For Not Displaying Item List
					 * //searchItemListforPvms=session.createSQLQuery(query).list();
					 
					for (Iterator iterator = searchItemListforPvms.iterator(); iterator
							.hasNext();) {
						MasStoreItem masStoreItem = new MasStoreItem();
						Object[] object = (Object[]) iterator.next();
						// int srNo = (Integer)object[0];
						masStoreItem.setId((Integer) object[0]);
						masStoreItem.setPvmsNo((String) object[1]);
						if (object[2] != null) {
							MasStoreSection masStoreSection = new MasStoreSection();
							masStoreSection.setId((Integer) object[2]);
							masStoreItem.setSection(masStoreSection);
						}
						masStoreItem.setNomenclature((String) object[3]);
						masStoreItem.setOldNivNo((String) object[29]);
						masStoreItem.setStrength((String) object[36]);
						if (object[37] != null) {
							MasStoreGroup masStoreGroup = new MasStoreGroup();
							masStoreGroup.setId((Integer) object[37]);
							masStoreItem.setGroup(masStoreGroup);
						}
						if (object[4] != null) {
							MasStoreItemGeneric masStoreItemGeneric = new MasStoreItemGeneric();
							masStoreItemGeneric.setId((Integer) object[4]);
							masStoreItem.setItemGeneric(masStoreItemGeneric);
						}
						if (object[31] != null) {
							MasStoreBrand MasStoreBrands = new MasStoreBrand();
							MasStoreBrands.setId((Integer) object[31]);
							masStoreItem.setBrand(MasStoreBrands);
						}
						if (object[5] != null) {
							MasItemType masItemType = new MasItemType();
							masItemType.setId((Integer) object[5]);
							masStoreItem.setItemType(masItemType);
						}
						if (object[6] != null) {
							MasItemCategory masItemCategory = new MasItemCategory();
							masItemCategory.setId((Integer) object[6]);
							masStoreItem.setItemCategory(masItemCategory);
						}
						if (object[7] != null) {
							MasStoreItemConversion masItemConvertion = new MasStoreItemConversion();
							masItemConvertion.setId((Integer) object[7]);
							masStoreItem.setItemConversion(masItemConvertion);
						}
						if (object[22] != null) {
							MasDepartment masDepartment = new MasDepartment();
							masDepartment.setId((Integer) object[22]);
							masStoreItem.setDepartment(masDepartment);
						}
						masStoreItem.setCostPrice((String) object[10]);
						masStoreItem.setPac((String) object[12]);
						masStoreItem.setNonPac((String) object[30]);
						masStoreItem.setDangerousDrug((String) object[11]);
						masStoreItem.setControlledDrug((String) object[13]);
						masStoreItem.setHighValueDrug((String) object[14]);
						masStoreItem.setRateContractItem((String) object[16]);
						masStoreItem.setSelfLife((String) object[20]);
						masStoreItem.setRol((String) object[17]);
						if (object[15] != null)
						{
							masStoreItem.setSalesTax((Float) object[15]);
						}
						if (object[18] != null)
						{
							masStoreItem.setMaxStock((Float) object[18]);
						}
						if (object[19] != null) {
							masStoreItem.setMinStock((Float) object[19]);
						}

						masStoreItem.setLeadTime((String) object[21]);
						masStoreItem.setLocation((String) object[23]);
						masStoreItem.setSpecification((String) object[24]);
						masStoreItem.setSourceOfSupply((String) object[32]);
						if (object[33] != null) {
							masStoreItem.setSlowMovingDays((Integer) object[33]);
						}
						if (object[34] != null) {
							masStoreItem.setFastMovingDays((Integer) object[34]);
						}
						if (object[35] != null) {
							masStoreItem.setNonMovingDays((Integer) object[35]);
						}
						
						masStoreItem.setExpiry((String) object[38]);
						masStoreItem.setAllergy((String) object[39]);
						masStoreItem.setLastChgBy((String) object[26]);
						if (object[27] != null) {
							masStoreItem.setLastChgDate((Date) object[27]);
						}
						masStoreItem.setLastChgTime((String) object[28]);
						masStoreItem.setStatus((String) object[25]);
						masStoreItem.setSophisticatedItem((String) object[40]);
						masStoreItem.setPppItem((String) object[41]);
						searchItemList.add(masStoreItem);

					}
					
					 * for(String ms:searchItemListforPvms){ MasStoreItem msa=new
					 * MasStoreItem(); msa.setPvmsNo(ms); searchItemList.add(msa); }
					 
					sectionList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasStoreSection as id order by id.SectionName asc");
					uomList=getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreUnit as msu where msu.Status='y' order by msu.UnitName asc");
					itemGenericList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasStoreItemGeneric as id");
					itemTypeList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.MasItemType as mc where mc.Status = 'y'");
					itemCategoryList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.MasItemCategory as mc where mc.Status = 'y' order by mc.ItemCategoryName asc ");
					itemConversionList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.MasStoreItemConversion as mc where mc.Status = 'y' order by mc.ItemUnitName asc ");
					departmentList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y' order by mc.DepartmentName asc");
					groupList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.MasStoreGroup as mg where mg.Status = 'y' order by mg.GroupName asc");
					masItemClassList=session.createCriteria(MasItemClass.class).add(Restrictions.eq("Status", "y")).list();
					companyList=session.createCriteria(MasCompany.class).add(Restrictions.eq("Status", "y")).list();
					
					
					//List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
					
					//itemCodeList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo", "NIV%")).add(Restrictions.eq("Hospital.Id", hospitalId))
					//.addOrder(Order.desc("Id")).setMaxResults(1).list();
					List itemCodeList = new ArrayList();
					//itemCodeList=session.createSQLQuery("select max(to_number(subStr(pvms_no,5))) from mas_store_item mas where mas.ITEM_TYPE_ID=2 and mas.HOSPITAL_ID='"+hospitalId+"' and REGEXP_LIKE(subStr(pvms_no,5),'^-?[[:digit:],.]*$')").list();
					String itemNo = "";
					if(itemCodeList.size()>0){
						String itemCode =itemCodeList.get(0).toString();
						//String itemCode = masStoreItem.getPvmsNo();
						//StringTokenizer str = new StringTokenizer(itemCode, "/");
						//String itemNivCode = "";
						//while (str.hasMoreTokens()) {

						//	itemNivCode = str.nextToken();

						//}
						int itemNiv =Integer.parseInt(itemCode)+1;
						itemNo = "NIV/"+itemNiv;
					}else{
						itemNo = "NIV/011"; 
					}
					map.put("itemNo",itemNo);
					map.put("searchItemList", searchItemList);
					map.put("storeSectionList", sectionList);
					map.put("itemGenericList", itemGenericList);
					map.put("itemTypeList", itemTypeList);
					map.put("itemCategoryList", itemCategoryList);
					map.put("itemConversionList", itemConversionList);
					map.put("departmentList", departmentList);
					map.put("groupList", groupList);
					map.put("masItemClassList", masItemClassList);
					map.put("gridItemClassList", gridItemClassList);
					map.put("companyList", companyList);
					map.put("uomList",uomList);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return map;*/
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> searchItemNIP(String pvmsNo, String nomenclature,
					int deptId, String sectionCode,int hospitalId,int ItemType) {
				List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
				Map<String, Object> itemFieldsMap = new HashMap<String, Object>();
				List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
				List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
				List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
				List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
				List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
				Session session = (Session) getSession();
				List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
				try {
					if ((pvmsNo != null)) {
			
						
					 	searchItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo","%"+pvmsNo+"%").ignoreCase()).addOrder(Order.asc("PvmsNo"))
					 			.createAlias("ItemClassification", "it").add(Restrictions.eq("it.Id",2))
					 			.list();
					}

					if ((nomenclature != null)) {

					 	searchItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature","%"+nomenclature+"%").ignoreCase()).addOrder(Order.asc("Nomenclature"))
					 			.createAlias("ItemClassification", "it").add(Restrictions.eq("it.Id",2))
					 			.list();
						
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				storeSectionList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStoreSection as mr where  upper(mr.Status) =upper('y')");
				
				itemTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasItemType as mbs where  upper(mbs.Status) =upper('y')");
				itemConversionList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStoreItemConversion as mbs where upper(mbs.Status) =upper('y')");
				itemCategoryList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasItemCategory as mbs where  upper(mbs.Status) =upper('y')");
				
				groupList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");
				masItemClassList= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemClass where upper(Status) =upper('y')");


				itemFieldsMap.put("searchItemList", searchItemList);
				itemFieldsMap.put("masItemClassList", masItemClassList);
				itemFieldsMap.put("storeSectionList", storeSectionList);
				itemFieldsMap.put("itemTypeList", itemTypeList);
				itemFieldsMap.put("itemConversionList", itemConversionList);
				itemFieldsMap.put("itemCategoryList", itemCategoryList);
				itemFieldsMap.put("groupList", groupList);
				
				return itemFieldsMap;
			}
			
			
			
		
			
			
			
			
		
			
			public boolean addItemNIP(MasStoreItem masItem) {
				boolean successfullyAdded = false;

				Session session = (Session) getSession();
				Transaction tx = null;
			try {
					tx = session.beginTransaction();
					
					HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					hbt.save(masItem);
					hbt.refresh(masItem);
					
					successfullyAdded = true;

					tx.commit();
				} catch (HibernateException e) {
					if (tx != null)
						tx.rollback();
				}
				return successfullyAdded;
			}

			@SuppressWarnings("unchecked")
			public boolean deleteItemNIP(int itemId,
					Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				int userId = 0;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				try {
					MasStoreItem masItem = new MasStoreItem();
					masItem = (MasStoreItem) getHibernateTemplate().load(
							MasStoreItem.class, itemId);
					userId = (Integer) generalMap.get("userId");
					Users user = new Users();
					user.setId(userId);
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
					// Integer itemTypeId=masItem.getItemType().getId();
					// Integer itemGenericId=masItem.getItemGeneric().getId();
					if (generalMap.get("flag") != null) {
						// List
						// itemTypeList=getHibernateTemplate().find("from jkt.hms.masters.business.MasItemType as itemType where itemType.Id='"+itemTypeId+"' and itemType.Status='y'");
						// List
						// itemGenericList=getHibernateTemplate().find("from jkt.hms.masters.business.MasItemGeneric as itemGeneric where itemGeneric.Id='"+itemGenericId+"' and itemGeneric.Status='y'");

						String flag = (String) generalMap.get("flag");
						if (flag.equals("InActivate")) {
							masItem.setStatus("n");
							dataDeleted = true;
						} else if (flag.equals("Activate")) {
							masItem.setStatus("y");
							dataDeleted = false;
						}
					}
					masItem.setLastChgBy(user);
					masItem.setLastChgDate(currentDate);
					masItem.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masItem);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return dataDeleted;
			}

			@Override
			public boolean editItemNIP(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				
				
				int itemId = 0;
				int groupId = 0;
				int itemClassId = 0;
				int sectionId = 0;
				int itemTypeId = 0;
				int itemCategoryId = 0;
				int itemConversionId = 0;
				String pvms = "";
				String commonName = "";
				String highValueDrug = "";
				float minStock=(float) 0.0;
				float maxStock=(float) 0.0;
				int deptId=0;
				int hospitalId = 0;
				int userId = 0;
				String nomenclature = "";
				String tempreture = "";
				String insulin="";
				String expiry="";
				itemId = (Integer) generalMap.get("id");
				String changedBy="";
				insulin= (String) generalMap.get("insulin");
				pvms = (String) generalMap.get("pvms");
				commonName = (String) generalMap.get("commonName");
				tempreture = (String) generalMap.get("tempreture");
				nomenclature = (String) generalMap.get("name");
				itemClassId = (Integer) generalMap.get("itemClassId");
				sectionId = (Integer) generalMap.get("sectionId");
				groupId = (Integer) generalMap.get("groupId");
				itemTypeId = (Integer) generalMap.get("itemTypeId");
				itemCategoryId = (Integer) generalMap.get("itemCategoryId");
				itemConversionId = (Integer) generalMap.get("itemConversionId");
				pvms = (String) generalMap.get("pvms");
				highValueDrug = (String) generalMap.get("highValueDrug");
				minStock = (Float) generalMap.get("minTempreture");
				maxStock = (Float) generalMap.get("maxTempreture");
				hospitalId = (Integer) generalMap.get("hospitalId");
				userId= (Integer) generalMap.get("userId");
				Users user = new Users();
				user.setId(userId);
				expiry = (String) generalMap.get("expiry");
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("changedDate");
				currentTime = (String) generalMap.get("currentTime");
				String dispensingUnit="";
				dispensingUnit = (String) generalMap.get("dispensingUnit");
				String brandedGeneric="";
				brandedGeneric = (String) generalMap.get("brandedGeneric");
				
				BigDecimal uomQty = new BigDecimal(0);
				uomQty= (BigDecimal) generalMap.get("uomQty");
				MasStoreItem masStoreItem = (MasStoreItem) getHibernateTemplate().get(
						MasStoreItem.class, itemId);
				
				masStoreItem.setId(itemId);
				masStoreItem.setNomenclature(nomenclature);
				masStoreItem.setPvmsNo(pvms);
				masStoreItem.setCommonName(commonName);
				masStoreItem.setDispUnit(dispensingUnit);
				MasStoreSection masStoreSection = new MasStoreSection();
				masStoreSection.setId(sectionId);
				masStoreItem.setSection(masStoreSection);

				masStoreItem.setADispQty(uomQty);
				/*if (deptId != 0) {
					 MasDepartment masDepartment = new MasDepartment();
					 masDepartment.setId(deptId);
					 masStoreItem.setDepartment(masDepartment);
				}*/
				

			


				if (groupId != 0) {
					MasStoreGroup masStoreGroup = new MasStoreGroup();
					masStoreGroup.setId(groupId);
					masStoreItem.setGroup(masStoreGroup);
				} else {
					masStoreItem.setGroup(null);
				}

				 MasItemType masStoreItemType = new MasItemType();
				 masStoreItemType.setId(itemTypeId);
				 masStoreItem.setItemType(masStoreItemType);

				if (itemCategoryId != 0) {
					MasItemCategory masStoreItemCategory = new MasItemCategory();
					masStoreItemCategory.setId(itemCategoryId);
					masStoreItem.setItemCategory(masStoreItemCategory);
				}
				if (itemClassId != 0) {
					masStoreItem.setItemClass(new MasItemClass(itemClassId));
				}
				masStoreItem.setHighValueDrug(highValueDrug);
				if(hospitalId !=0){
					MasHospital masHospital=new MasHospital();
					masHospital.setId(hospitalId);
					masStoreItem.setHospital(masHospital);
					}
			
				MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
				masStoreItemConversion.setId(itemConversionId);
				masStoreItem.setItemConversion(masStoreItemConversion);
				
				 MasItemClassification c = new MasItemClassification();
				 c.setId(2);
				 masStoreItem.setItemClassification(c);
			
			
			

				if (itemTypeId != 0) {
					MasItemType masItemType = new MasItemType();
					masItemType.setId(itemTypeId);
					masStoreItem.setItemType(masItemType);
				}
				if (!tempreture.equals("")) {
					masStoreItem.setTemperature(tempreture);
				}
				if (!insulin.equals("")) {
					masStoreItem.setInsulinInjection(insulin);
				}
				
				masStoreItem.setMinStock(minStock);
				masStoreItem.setMaxStock(maxStock);

				masStoreItem.setExpiry(expiry);

				
				masStoreItem.setLastChgBy(user);
				masStoreItem.setBrandedGeneric(brandedGeneric);
				
				masStoreItem.setLastChgDate(currentDate);
				masStoreItem.setLastChgTime(currentTime);
				
				MasHospital h = new MasHospital();
				h.setId(hospitalId);
				masStoreItem.setHospital(h);

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masStoreItem);

				dataUpdated = true;
				return dataUpdated;

			}



			public List<MasStoreItem> checkForExistingPvmsNoNIP(String pvmsNo) {
				List<MasStoreItem> existingPvmsNoList = new ArrayList<MasStoreItem>();

				Session session = (Session) getSession();
				existingPvmsNoList = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("PvmsNo", pvmsNo))
						.createAlias("ItemClassification", "it").add(Restrictions.eq("it.Id",2))
						.list();
				return existingPvmsNoList;
			}
	
			@Override
			public Map<String, Object> showNonDrugJsp(int deptId, int hospitalId) {
				Map<String, Object> map = new HashMap<String, Object>();
				Session session = (Session) getSession();
				try {
					List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
					List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
					List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
					List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
					List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
					List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
					List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
					List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
					List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
					List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
					List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
					List<MasStoreBrand> gridBrandList = new ArrayList<MasStoreBrand>();
					List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
			
					masItemClassList= getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemClass where upper(Status) =upper('y')");
				 	
				 	Properties properties = new Properties();
					URL resourcePath = Thread.currentThread().getContextClassLoader()
							.getResource("adt.properties");
					int sectionIdForNonDrugs=0;
					try {
						properties.load(resourcePath.openStream());
						sectionIdForNonDrugs = Integer.parseInt(properties.getProperty("SectionIdForDrugs"));
					
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					

				 	
				 	searchItemList = session.createCriteria(MasStoreItem.class)
				 			.createAlias("ItemClassification", "it").add(Restrictions.eq("it.Id",1))
				 			.createAlias("Section", "s").add(Restrictions.ne("s.Id",sectionIdForNonDrugs))
				 			//.createAlias("ItemType", "it").add(Restrictions.eq("it.ItemTypeName","MEDICAL CONSUMABLE").ignoreCase())
				 			.list();
			
					
				
			
					sectionList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasStoreSection as s where upper(s.Status) =upper('y')");
				
				
					itemTypeList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasItemType as mc where upper(mc.Status) = upper('y')");
					itemCategoryList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasItemCategory as mc where upper(mc.Status) = upper('y')");
					itemConversionList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasStoreItemConversion as mc where upper(mc.Status) = upper('y')");
					groupList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");

					map.put("searchItemList", searchItemList);
					map.put("storeSectionList", sectionList);
					map.put("itemTypeList", itemTypeList);
					map.put("itemCategoryList", itemCategoryList);
					map.put("itemConversionList", itemConversionList);
					map.put("manufacturerList", manufacturerList);
					map.put("storeSupplierList", supplierList);
					map.put("departmentList", departmentList);
					map.put("departmentList1", departmentList1);
					map.put("groupList", groupList);
					map.put("brandList", brandList);
					map.put("gridBrandList", gridBrandList);
					
					map.put("masItemClassList", masItemClassList);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
				return map;
				
			}
			@Override
			public Map<String, Object> searchNonDrug(String pvmsNo,
					String nomenclature, int deptId, String sectionCode,
					int hospitalId, int itemType) {
				List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
				Map<String, Object> itemFieldsMap = new HashMap<String, Object>();
				List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
				List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
				List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
				List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
				List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
				Session session = (Session) getSession();
				List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				int sectionIdForNonDrugs=0;
				try {
					properties.load(resourcePath.openStream());
					sectionIdForNonDrugs = Integer.parseInt(properties.getProperty("SectionIdForDrugs"));
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(sectionIdForNonDrugs+"sectionIdForNonDrugssectionIdForNonDrugs");
				try {
					if ((pvmsNo != null)) {
			
						
					 	searchItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo","%"+pvmsNo+"%").ignoreCase()).addOrder(Order.asc("PvmsNo"))
					 			.createAlias("ItemClassification", "it").add(Restrictions.eq("it.Id",1))
					 							 			
					 			.createAlias("Section", "s").add(Restrictions.ne("s.Id",sectionIdForNonDrugs))
					 			.list();
					}

					if ((nomenclature != null)) {

					 	searchItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature","%"+nomenclature+"%").ignoreCase()).addOrder(Order.asc("Nomenclature"))
					 			.createAlias("ItemClassification", "it").add(Restrictions.eq("it.Id",1))
					 			.createAlias("Section", "s").add(Restrictions.ne("s.Id",sectionIdForNonDrugs))
					 			.list();
						
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			
				
				
				
				
				storeSectionList=getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStoreSection as mr where  upper(mr.Status) =upper('y')");
				
				itemTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasItemType as mbs where  upper(mbs.Status) =upper('y')");
				itemConversionList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStoreItemConversion as mbs where upper(mbs.Status) =upper('y')");
				itemCategoryList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasItemCategory as mbs where  upper(mbs.Status) =upper('y')");
				
				groupList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");
				masItemClassList= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemClass where upper(Status) =upper('y')");


				itemFieldsMap.put("searchItemList", searchItemList);
				itemFieldsMap.put("masItemClassList", masItemClassList);
				itemFieldsMap.put("storeSectionList", storeSectionList);
				itemFieldsMap.put("itemTypeList", itemTypeList);
				itemFieldsMap.put("itemConversionList", itemConversionList);
				itemFieldsMap.put("itemCategoryList", itemCategoryList);
				itemFieldsMap.put("groupList", groupList);
				
				return itemFieldsMap;
			}
			@Override
			public boolean addNonDrug(MasStoreItem masStoreItem) {
				boolean successfullyAdded = false;

				Session session = (Session) getSession();
				Transaction tx = null;
			try {
					tx = session.beginTransaction();
					
					HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					hbt.save(masStoreItem);
					hbt.refresh(masStoreItem);
					
					successfullyAdded = true;

					tx.commit();
				} catch (HibernateException e) {
					if (tx != null)
						tx.rollback();
				}
				return successfullyAdded;
			}
			@Override
			public boolean deleteNonDrug(int itemId,
					Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				int userId = 0;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				try {
					MasStoreItem masItem = new MasStoreItem();
					masItem = (MasStoreItem) getHibernateTemplate().load(
							MasStoreItem.class, itemId);
					userId = (Integer) generalMap.get("userId");
					Users user = new Users();
					user.setId(userId);
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
					// Integer itemTypeId=masItem.getItemType().getId();
					// Integer itemGenericId=masItem.getItemGeneric().getId();
					if (generalMap.get("flag") != null) {
						// List
						// itemTypeList=getHibernateTemplate().find("from jkt.hms.masters.business.MasItemType as itemType where itemType.Id='"+itemTypeId+"' and itemType.Status='y'");
						// List
						// itemGenericList=getHibernateTemplate().find("from jkt.hms.masters.business.MasItemGeneric as itemGeneric where itemGeneric.Id='"+itemGenericId+"' and itemGeneric.Status='y'");

						String flag = (String) generalMap.get("flag");
						if (flag.equals("InActivate")) {
							masItem.setStatus("n");
							dataDeleted = true;
						} else if (flag.equals("Activate")) {
							masItem.setStatus("y");
							dataDeleted = false;
						}
					}
					masItem.setLastChgBy(user);
					masItem.setLastChgDate(currentDate);
					masItem.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masItem);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return dataDeleted;
			}
			@Override
			public List<MasStoreItem> checkForExistingPvmsNoNonDrug(String pvmsNo) {
				List<MasStoreItem> existingPvmsNoList = new ArrayList<MasStoreItem>();

				Session session = (Session) getSession();
				existingPvmsNoList = session.createCriteria(MasStoreItem.class).add(
						Restrictions.like("PvmsNo", pvmsNo))
						.createAlias("ItemClassification", "it").add(Restrictions.eq("it.Id",1))
						.list();
				return existingPvmsNoList;
			}

			public boolean editNonDrug(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				
				
				int itemId = 0;
				int groupId = 0;
				int itemClassId = 0;
				int sectionId = 0;
				int itemTypeId = 0;
				int itemCategoryId = 0;
				int itemConversionId = 0;
				String pvms = "";
				String commonName = "";
			/*	String highValueDrug = "";
				float minStock=(float) 0.0;
				float maxStock=(float) 0.0;*/
				int deptId=0;
				int hospitalId = 0;
				int userId = 0;
				String nomenclature = "";
				/*String tempreture = "";
				String insulin="";
				String expiry="";
				*/itemId = (Integer) generalMap.get("id");
				String changedBy="";
				//insulin= (String) generalMap.get("insulin");
				pvms = (String) generalMap.get("pvms");
				commonName = (String) generalMap.get("commonName");
				//tempreture = (String) generalMap.get("tempreture");
				nomenclature = (String) generalMap.get("name");
				itemClassId = (Integer) generalMap.get("itemClassId");
				sectionId = (Integer) generalMap.get("sectionId");
				groupId = (Integer) generalMap.get("groupId");
				itemTypeId = (Integer) generalMap.get("itemTypeId");
				itemCategoryId = (Integer) generalMap.get("itemCategoryId");
				itemConversionId = (Integer) generalMap.get("itemConversionId");
				pvms = (String) generalMap.get("pvms");
				//highValueDrug = (String) generalMap.get("highValueDrug");
				//minStock = (Float) generalMap.get("minTempreture");
				//maxStock = (Float) generalMap.get("maxTempreture");
				hospitalId = (Integer) generalMap.get("hospitalId");
				userId= (Integer) generalMap.get("userId");
				Users user = new Users();
				user.setId(userId);
				//expiry = (String) generalMap.get("expiry");
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("changedDate");
				currentTime = (String) generalMap.get("currentTime");
				String dispensingUnit="";
				dispensingUnit = (String) generalMap.get("dispensingUnit");
				String brandedGeneric="";
				brandedGeneric = (String) generalMap.get("brandedGeneric");
				/*String IssueFrom = (String) generalMap.get("IssueFrom");
				String prescribedFrom = (String) generalMap.get("prescribedFrom");*/
				BigDecimal uomQty = new BigDecimal(0);
				uomQty= (BigDecimal) generalMap.get("uomQty");
				MasStoreItem masStoreItem = (MasStoreItem) getHibernateTemplate().get(
						MasStoreItem.class, itemId);
				
				masStoreItem.setId(itemId);
				masStoreItem.setNomenclature(nomenclature);
				masStoreItem.setPvmsNo(pvms);
				masStoreItem.setCommonName(commonName);
				masStoreItem.setDispUnit(dispensingUnit);
				MasStoreSection masStoreSection = new MasStoreSection();
				masStoreSection.setId(sectionId);
				masStoreItem.setSection(masStoreSection);
				/*masStoreItem.setIssueFrom(IssueFrom);
				masStoreItem.setPrescribedFrom(prescribedFrom);*/

				masStoreItem.setADispQty(uomQty);
				/*if (deptId != 0) {
					 MasDepartment masDepartment = new MasDepartment();
					 masDepartment.setId(deptId);
					 masStoreItem.setDepartment(masDepartment);
				}*/
				

			


				if (groupId != 0) {
					MasStoreGroup masStoreGroup = new MasStoreGroup();
					masStoreGroup.setId(groupId);
					masStoreItem.setGroup(masStoreGroup);
				} else {
					masStoreItem.setGroup(null);
				}

				 MasItemType masStoreItemType = new MasItemType();
				 masStoreItemType.setId(itemTypeId);
				 masStoreItem.setItemType(masStoreItemType);

				if (itemCategoryId != 0) {
					MasItemCategory masStoreItemCategory = new MasItemCategory();
					masStoreItemCategory.setId(itemCategoryId);
					masStoreItem.setItemCategory(masStoreItemCategory);
				}
				if (itemClassId != 0) {
					masStoreItem.setItemClass(new MasItemClass(itemClassId));
				}
				//masStoreItem.setHighValueDrug(highValueDrug);
				if(hospitalId !=0){
					MasHospital masHospital=new MasHospital();
					masHospital.setId(hospitalId);
					masStoreItem.setHospital(masHospital);
					}
			
				MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
				masStoreItemConversion.setId(itemConversionId);
				masStoreItem.setItemConversion(masStoreItemConversion);

				 MasItemClassification c = new MasItemClassification();
				 c.setId(1);
				 masStoreItem.setItemClassification(c);
			
			

				if (itemTypeId != 0) {
					MasItemType masItemType = new MasItemType();
					masItemType.setId(itemTypeId);
					masStoreItem.setItemType(masItemType);
				}
				/*if (!tempreture.equals("")) {
					masStoreItem.setTemperature(tempreture);
				}
				if (!insulin.equals("")) {
					masStoreItem.setInsulinInjection(insulin);
				}
				
				masStoreItem.setMinStock(minStock);
				masStoreItem.setMaxStock(maxStock);

				masStoreItem.setExpiry(expiry);*/

				
				masStoreItem.setLastChgBy(user);
				masStoreItem.setBrandedGeneric(brandedGeneric);
				
				masStoreItem.setLastChgDate(currentDate);
				masStoreItem.setLastChgTime(currentTime);
				
				MasHospital h = new MasHospital();
				h.setId(hospitalId);
				masStoreItem.setHospital(h);

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masStoreItem);

				dataUpdated = true;
				return dataUpdated;

			}
		
			@Override
			public boolean addMprPriority(MprPriority masMprPriority) {
				boolean successfullyAdded = false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masMprPriority);
				successfullyAdded = true;
				return successfullyAdded;
			}
			@Override
			public Map<String, Object> showMprPriorityJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MprPriority> searchMprPriorityNameList = new ArrayList<MprPriority>();
				searchMprPriorityNameList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MprPriority");
				map.put("searchMprPriorityNameList", searchMprPriorityNameList);
				return map;
			}
			@Override
			public Map<String, Object> searchMprPriority(
					String mprPriorityCode, String mprPriorityName) {
				List<MprPriority> searchMprPriorityNameList = new ArrayList<MprPriority>();
				Map<String, Object> groupFieldsMap = new HashMap<String, Object>();
				try {
					if ((mprPriorityName != null) || (mprPriorityCode == null)) {
						searchMprPriorityNameList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.MprPriority mr where mr.PrName like '"
										+ mprPriorityName + "%' order by mr.PrName");
					} else {
						searchMprPriorityNameList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.MprPriority mr where mr.PrCode like '"
										+ mprPriorityCode + "%' order by mr.PrCode");
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				groupFieldsMap.put("searchMprPriorityNameList", searchMprPriorityNameList);
				return groupFieldsMap;
			}
			@Override
			public boolean editMprPriorityToDatabase(
					Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				String mprPriorityName = "";
				@SuppressWarnings("unused")
				String mprPriorityCode = "";
				int mprPriorityId = 0;
				int userId = 0;
				mprPriorityId = (Integer) generalMap.get("id");
				mprPriorityCode = (String) generalMap.get("mprPriorityCode");
				mprPriorityName = (String) generalMap.get("name");
				userId = (Integer) generalMap.get("userId");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				MprPriority mprPriority = (MprPriority) getHibernateTemplate()
						.get(MprPriority.class, mprPriorityId);

				mprPriority.setId(mprPriorityId);
				mprPriority.setPrName(mprPriorityName);
				mprPriority.setLastChyBy(userId);
				mprPriority.setLastChgDate(currentDate);
				mprPriority.setLastChgTime(currentTime);
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(mprPriority);
				dataUpdated = true;
				return dataUpdated;
			}
			@Override
			public boolean deleteMprPriority(int mprPriorityId,
					Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				int userId = 0;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MprPriority mprPriority = new MprPriority();
				mprPriority = (MprPriority) getHibernateTemplate().get(
						MprPriority.class, mprPriorityId);
				userId = (Integer) generalMap.get("userId");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						mprPriority.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						mprPriority.setStatus("y");
						dataDeleted = false;
					}
				}
				mprPriority.setLastChyBy(userId);
				mprPriority.setLastChgDate(currentDate);
				mprPriority.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(mprPriority);
				return dataDeleted;
			}

}
