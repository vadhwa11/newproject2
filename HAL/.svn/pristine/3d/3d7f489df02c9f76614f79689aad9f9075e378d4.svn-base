package jkt.hms.masters.dataservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasBudgetCode;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemClass;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasRepairStation;
import jkt.hms.masters.business.MasSalesType;
import jkt.hms.masters.business.MasStoreAirForceDepot;
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
import jkt.hms.masters.business.MasStoreSupplierType;
import jkt.hms.masters.business.MasStoreUnit;
import jkt.hms.masters.business.MasStoreVendorWiseManufacturer;
import jkt.hms.masters.business.MprPriority;
import jkt.hms.util.Box;

public interface PharmacyMasterDataService {

	// ----------------------- Item Type ---------------------------

	Map<String, Object> showItemTypeJsp();

	Map<String, Object> searchItemType(String itemTypeCode, String itemTypeName);

	boolean addItemType(MasItemType masItemType);

	boolean deleteItemType(int itemTypeId, Map<String, Object> generalMap);

	boolean editItemTypeToDatabase(Map<String, Object> generalMap);

	// --------------------------------------- Manufacturer
	// --------------------------------------

	Map<String, Object> showManufacturerJsp();

	Map<String, Object> searchManufacturer(String manufacturerCode,
			String manufacturerName);

	boolean addManufacturer(MasManufacturer masManufacturer);

	boolean deleteManufacturer(int manufacturerId,
			Map<String, Object> generalMap);

	boolean editManufacturerToDatabase(Map<String, Object> generalMap);

	// ---------------------- Item Category ---------------------------

	@SuppressWarnings("unchecked")
	Map searchItemCategory(String itemCategoryCode, String itemCategoryName);

	Map<String, Object> showItemCategoryJsp();

	boolean addItemCategory(MasItemCategory masItemCategory);

	boolean deleteItemCategory(int itemCategoryId,
			Map<String, Object> generalMap);

	boolean editItemCategoryToDatabase(Map<String, Object> generalMap);

	// ------------------------------Sales
	// Type-----------------------------------

	boolean deleteSalesType(Integer salesTypeId, Map<String, Object> generalMap);

	boolean editSalesType(Map<String, Object> generalMap);

	boolean addSalesType(MasSalesType masSalesType);

	Map<String, Object> showSalesTypeJsp();

	Map<String, Object> searchSalesType(String salesTypeCode,
			String salesTypeName);

	// ------------------------------ Item
	// Class-----------------------------------

	/*
	 * Map<String, Object> showItemClassJsp();
	 * 
	 * Map<String, Object> searchItemClass(String itemClassCode,String
	 * itemClassName);
	 * 
	 * boolean addItemClass(MasItemClass masItemClass);
	 * 
	 * boolean deleteItemClass(int itemClassId, Map<String, Object> generalMap);
	 * 
	 * boolean editItemClassToDatabase(Map<String, Object> generalMap);
	 */

	// ----------------------Store Section-------------------------------

	boolean addStoreSection(MasStoreSection masStoreSection);

	boolean deleteStoreSection(int sectionId, Map<String, Object> generalMap);

	boolean editStoreSectionToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchStoreSection(String sectionCode,
			String sectionName);

	Map<String, Object> showStoreSectionJsp();

	// ---------------------- Store Supplier Type ---------------------------

	Map<String, Object> showStoreSupplierTypeJsp();

	Map<String, Object> searchStoreSupplierType(String storeSupplierTypeCode,
			String storeSupplierTypeName);

	boolean addStoreSupplierType(MasStoreSupplierType masStoreStoreSupplierType);

	boolean deleteStoreSupplierType(int storeSupplierTypeId,
			Map<String, Object> generalMap);

	boolean editStoreSupplierTypeToDatabase(Map<String, Object> generalMap);

	// ------------------------------ Store
	// Supplier-----------------------------------

	Map<String, Object> showStoreSupplierJsp(Map<String, Object> dataMap);

	boolean addStoreSupplier(MasStoreSupplier masStoreSupplier,
			Map<String, Object> generalMap);

	Map<String, Object> searchStoreSupplier(String storeSupplierCode,
			String storeSupplierName,int hospitalId,int deptId);

	boolean editStoreSupplierToDatabase(Map<String, Object> generalMap);

	boolean deleteStoreSupplier(Integer storeSupplierId,
			Map<String, Object> generalMap);

	// -----------------------------Item Type
	// Supplier-----------------------------------

	/*
	 * Map<String, Object>getItemWiseSupplier(); boolean
	 * addItemWiseSupplier(MasItemWiseSupplier masItemWiseSupplier);
	 * Map<String,Object> searchItemWiseSupplier(String itemWiseSupplierCode,
	 * String itemWiseSupplierName); boolean editItemWiseSupplier(Map<String,
	 * Object> generalMap); boolean deleteItemWiseSupplier(Integer
	 * itemWiseSupplierId, Map<String, Object> generalMap); boolean
	 * checkItem(int itemId);
	 */

	// ---------------------------Item-------------------
	Map<String, Object> showItemJsp(int deptId,int hospitalId);
	
	List checkNivNo(Map<String, Object> testMap);
	List checkNomenclature(Map<String, Object> testMap);

	boolean addItem(MasStoreItem masStoreItem);

	boolean editItem(Map<String, Object> generalMap);

	boolean deleteItem(Integer itemId, Map<String, Object> generalMap);

	// -------------------------------ITEM
	// GENERIC-------------------------------
	Map<String, Object> showItemGenericJsp();

	Map<String, Object> searchItemGeneric(String genericName);

	boolean addItemGeneric(MasStoreItemGeneric masStoreItemGeneric);

	boolean deleteItemGeneric(int itemGenericId, Map<String, Object> generalMap);

	boolean editItemGeneric(Map<String, Object> generalMap);

	// ------------------------------------------StoreVendorWiseManufacturer----------------------------

	Map<String, Object> showStoreVendorWiseManufacturerJsp();

	Map<String, Object> searchStoreVendorWiseManufacturer(
			String storeVendorWiseManufacturerCode);

	boolean editStoreVendorWiseManufacturerToDatabase(
			Map<String, Object> generalMap);

	boolean deleteStoreVendorWiseManufacturer(
			int storeVendorWiseManufacturerId, Map<String, Object> generalMap);

	// ------------------------------Financial
	// Master---------------------------------------
	Map<String, Object> showFinancialJsp();

	Map<String, Object> searchFinancial(Date startDate, Date endDate);

	boolean addFinancial(MasStoreFinancial masStoreFinancial);

	boolean deleteFinancial(int financialId, Map<String, Object> generalMap);

	boolean editFinancialToDatabase(Map<String, Object> generalMap);

	// ------------------------------Pharma Index-----------------------------
	boolean addPharmaIndex(MasStorePharmaIndex masStorePharmaIndex);

	boolean editPharmaIndexToDatabase(Map<String, Object> generalMap);

	boolean deletePharmaIndex(int pharmaIndexId, Map<String, Object> generalMap);

	Map<String, Object> searchPharmaIndex(String pharmaIndexName);

	Map<String, Object> showPharmaIndexJsp();

	// -----------------------Store Unit--------------------------------------

	boolean addItemUnit(MasStoreUnit masStoreUnit);

	boolean editItemUnitToDatabase(Map<String, Object> generalMap);

	boolean deleteItemUnit(int itemUnitId, Map<String, Object> generalMap);

	Map<String, Object> searchItemUnit(String unitName);

	Map<String, Object> showItemUnitJsp();

	// -----------------------Item
	// Conversion-----------------------------------------------
	Map<String, Object> showItemConversionJsp();

	Map<String, Object> searchItemConversion(String itemUnitName);

	// -------------------------PO Delivery
	// terms------------------------------------
	Map<String, Object> showPoDeliveryTermsJsp();

	Map<String, Object> searchPoDeliveryTerms(String poDeliveryType);

	boolean addPoDeliveryTerms(MasStorePoDeliveryTerms masStorePoDeliveryTerms);

	boolean deletePoDeliveryTerms(int poDeliveryTermsId,
			Map<String, Object> generalMap);

	boolean editPoDeliveryTermsToDatabase(Map<String, Object> generalMap);

	// ----------------------Budget Entry Master----------------------------
	Map<String, Object> showBudgetJsp(int deptId,int hospitalId);

	/*
	 * Map<String, Object> searchBudget(String code);
	 * 
	 * boolean addBudget(MasStoreBudget masStoreBudget);
	 * 
	 * boolean deleteBudget(int budgetId, Map<String, Object> generalMap);
	 * 
	 * boolean editBudgetToDatabase(Map<String, Object> generalMap);
	 */

	boolean addBudgetEntry(MasStoreBudget masStoreBudget,
			List<MasStoreBudgetT> masStoreBudgetTList,
			Map<String, Object> infoMap);

	int getMasStoreBudgetId(int budgetCode);

	Map<String, Object> searchMasStoreBudget(Map<String, Object> searchFieldMap);

	Map<String, Object> getBudgetEntryModifyMap(int radio_str);

	Map<String, Object> getBudgetAndTUpdate(int budgetId);

	boolean updateBudgetEntry(MasStoreBudget masStoreBudget,
			List<MasStoreBudgetT> masStoreBudgetTList);

	
	boolean deleteMeScale(int meScaleId, Map<String, Object> generalMap);

	boolean editMeScaleToDatabase(Map<String, Object> generalMap);

	Map<String, Object> showMeScaleJsp();

	Map<String, Object> searchMeScale1(Map<String, Object> dataMap);

	// --------------------------------
	// AirForceUnitDepot-------------------------------------
	boolean addAirForceUnitDepot(MasStoreAirForceDepot masStoreAirForceDepot);

	boolean deleteAirForceUnitDepot(int airForceDepotId,
			Map<String, Object> generalMap);

	boolean editAirForceUnitDepotToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchAirForceUnitDepot(String airForceDepotName);

	Map<String, Object> showAirForceUnitDepotJsp();

	boolean addItemConversion(MasStoreItemConversion masStoreItemConversion);

	boolean editItemConversionToDatabase(Map<String, Object> generalMap);

	boolean deleteItemConversion(int itemConversionId,
			Map<String, Object> generalMap);

	Map<String, Object> searchItem(String pvmsNo, String nomenclature,
			int deptId, String sectionCode,int hospitalId,int ItemType);

	Map<String, Object> getConnection();

	Map<String, Object> getFinancialYearDetails(Map<String, Object> generalMap);

	boolean addBudgetDetails(Map<String, Object> budgetMap);

	boolean addStoreGroup(MasStoreGroup masStoreGroup);

	boolean deleteStoreGroup(int groupId, Map<String, Object> generalMap);

	boolean editGroupToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchStoreGroup(String groupCode, String groupName);

	Map<String, Object> showStoreGroupJsp();

	List<MasStoreItem> checkForExistingPvmsNo(String pvmsNo);

	int addBudgetMaster(Map<String, Object> generalMap);

	Map<String, Object> showBrandJsp(Box box);

	Map<String, Object> editBrandToDatabase(Map<String, Object> generalMap);

	Map<String, Object> showMatchedBrandList(Map<String, Object> parameterMap);

	boolean addStoreVendorWiseManufacturer(
			MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer);

	Map<String, Object> getConnectionForReport();

	String getHospitalName(int hospitalId);

	Map<String, Object> generatePVMSExcel(Map<String, Object> requestParameters);
	
	/*******************************  For Save Me Scale By Tirath   *******************************/
	boolean saveMeScale(Box box);
	boolean updateMeScale(Box box);
	
	/********************************* Method For Add Repair Station *******************/
	Map<String,Object>showRepairStationJsp(Map<String,Object>dataMap);
	boolean addRepairStation(MasRepairStation masRepairStation);
	boolean editRepairStation(Map<String, Object> generalMap);
	boolean deleteRepairStation(int financialId, Map<String, Object> generalMap);

	

	Map<String, Object> showBudgetCodeJsp();

	boolean deleteBudgetCode(int budgetCodeId, Map<String, Object> generalMap);

	boolean editBudgetCodeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchBudgetCode(String budgetCodeCode,
			String budgetCodeName);

	boolean addBudgetCode(MasBudgetCode masBudgetCode);

	
	Map<String, Object> getSectionGLList(Map<String, Object> dataMap);

	Map<String, Object> getCategoryList(Box box);

	Map<String, Object> getItemTypeGLList(Map<String, Object> dataMap);
	
	// ------------------------------ Item
		// Class-----------------------------------

		
		  Map<String, Object> showItemClassJsp();
		  
		  Map<String, Object> searchItemClass(String itemClassCode,String
		  itemClassName);
		  
		  boolean addItemClass(MasItemClass masItemClass);
		  
		  boolean deleteItemClass(int itemClassId, Map<String, Object> generalMap);
		  
		  boolean editItemClassToDatabase(Map<String, Object> generalMap);
		  
		  
		  
			boolean deleteItemNIP(int itemId, Map<String, Object> generalMap);

			Map<String, Object> showItemNIPJsp(int deptId, int hospitalId);

			boolean editItemNIP(Map<String, Object> generalMap);

			boolean addItemNIP(MasStoreItem masStoreItem);

			Map<String, Object> searchItemNIP(String pvmsNo, String nomenclature,
					int deptId, String sectionCode, int hospitalId, int itemType);
			
			List<MasStoreItem> checkForExistingPvmsNoNIP(String trim);
			
			

			Map<String, Object> showNonDrugJsp(int deptId, int hospitalId);

			Map<String, Object> searchNonDrug(String pvmsNo, String nomenclature,
					int deptId, String sectionCode, int hospitalId, int itemType);

			boolean addNonDrug(MasStoreItem masStoreItem);

			boolean deleteNonDrug(int itemId, Map<String, Object> generalMap);

			List<MasStoreItem> checkForExistingPvmsNoNonDrug(String pvmsNo);
			
			boolean editNonDrug(Map<String, Object> generalMap);
			
			boolean addMprPriority(MprPriority masMprPriority);
			
			Map<String, Object> showMprPriorityJsp();

			Map<String, Object> searchMprPriority(String mprPriorityCode,
					String mprPriorityName);

			boolean editMprPriorityToDatabase(Map<String, Object> generalMap);

			boolean deleteMprPriority(int mprPriorityId,
					Map<String, Object> generalMap);
			
}
