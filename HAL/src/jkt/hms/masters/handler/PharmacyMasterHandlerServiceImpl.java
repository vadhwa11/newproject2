package jkt.hms.masters.handler;

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
import jkt.hms.masters.business.MasStoreVendorWiseManufact;
import jkt.hms.masters.business.MasStoreVendorWiseManufacturer;
import jkt.hms.masters.business.MprPriority;
import jkt.hms.masters.dataservice.PharmacyMasterDataService;
import jkt.hms.util.Box;

public class PharmacyMasterHandlerServiceImpl implements
		PharmacyMasterHandlerService {
	PharmacyMasterDataService pharmacyMasterDataService = null;

	// ------------------------------Item
	// Type-----------------------------------
	public Map<String, Object> showItemTypeJsp() {
		return pharmacyMasterDataService.showItemTypeJsp();
	}

	public Map<String, Object> searchItemType(String itemTypeCode,
			String itemTypeName) {
		return pharmacyMasterDataService.searchItemType(itemTypeCode,
				itemTypeName);
	}

	public boolean addItemType(MasItemType masItemType) {
		return pharmacyMasterDataService.addItemType(masItemType);
	}

	public boolean deleteItemType(int itemTypeId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemType(itemTypeId, generalMap);
	}

	public boolean editItemTypeToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItemTypeToDatabase(generalMap);
	}

	// ---------------------------------
	// Manufacturer-------------------------------

	public Map<String, Object> showManufacturerJsp() {
		return pharmacyMasterDataService.showManufacturerJsp();
	}

	public boolean addManufacturer(MasManufacturer masManufacturer) {
		return pharmacyMasterDataService.addManufacturer(masManufacturer);
	}

	public boolean deleteManufacturer(int manufacturerId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteManufacturer(manufacturerId,
				generalMap);
	}

	public boolean editManufacturerToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editManufacturerToDatabase(generalMap);
	}

	public Map<String, Object> searchManufacturer(String manufacturerCode,
			String manufacturerName) {
		return pharmacyMasterDataService.searchManufacturer(manufacturerCode,
				manufacturerName);
	}

	// ------------------------------ Sales
	// Type-----------------------------------
	public boolean addSalesType(MasSalesType masSalesType) {
		return pharmacyMasterDataService.addSalesType(masSalesType);
	}

	public boolean deleteSalesType(Integer salesTypeId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteSalesType(salesTypeId,
				generalMap);
	}

	public boolean editSalesType(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editSalesType(generalMap);
	}

	public Map<String, Object> showSalesTypeJsp() {
		return pharmacyMasterDataService.showSalesTypeJsp();
	}

	public Map<String, Object> searchSalesType(String salesTypeCode,
			String salesTypeName) {
		return pharmacyMasterDataService.searchSalesType(salesTypeCode,
				salesTypeName);
	}

	// -----------------------Item Category
	// --------------------------------------

	public boolean addItemCategory(MasItemCategory masItemCategory) {
		return pharmacyMasterDataService.addItemCategory(masItemCategory);
	}

	public Map searchItemCategory(String itemCategoryCode,
			String itemCategoryName) {
		return pharmacyMasterDataService.searchItemCategory(itemCategoryCode,
				itemCategoryName);
	}

	public Map showItemCategoryJsp() {
		return pharmacyMasterDataService.showItemCategoryJsp();
	}

	public boolean deleteItemCategory(int itemCategoryId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemCategory(itemCategoryId,
				generalMap);
	}

	public boolean editItemCategoryToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItemCategoryToDatabase(generalMap);
	}

	// ---------------------------------------Item
	// Class-----------------------------------

	/*
	 * public Map<String, Object> showItemClassJsp() { return
	 * pharmacyMasterDataService.showItemClassJsp(); } public boolean
	 * addItemClass(MasItemClass masItemClass) { return
	 * pharmacyMasterDataService.addItemClass(masItemClass); }
	 * 
	 * public boolean deleteItemClass(int itemClassId,Map<String, Object>
	 * generalMap) { return
	 * pharmacyMasterDataService.deleteItemClass(itemClassId,generalMap); }
	 * 
	 * public boolean editItemClassToDatabase(Map<String, Object> generalMap) {
	 * return pharmacyMasterDataService.editItemClassToDatabase(generalMap); }
	 * 
	 * public Map<String, Object> searchItemClass(String itemClassCode,String
	 * itemClassName) { return
	 * pharmacyMasterDataService.searchItemClass(itemClassCode,itemClassName); }
	 */
	// ------------------------------- Store Supplier Type
	// --------------------------------

	public boolean addStoreSupplierType(
			MasStoreSupplierType masStoreSupplierType) {
		return pharmacyMasterDataService
				.addStoreSupplierType(masStoreSupplierType);
	}

	public boolean deleteStoreSupplierType(int storeSupplierTypeId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteStoreSupplierType(
				storeSupplierTypeId, generalMap);
	}

	public boolean editStoreSupplierTypeToDatabase(
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService
				.editStoreSupplierTypeToDatabase(generalMap);
	}

	public Map<String, Object> showStoreSupplierTypeJsp() {
		return pharmacyMasterDataService.showStoreSupplierTypeJsp();
	}

	public Map<String, Object> searchStoreSupplierType(
			String storeSupplierTypeCode, String storeSupplierTypeName) {
		return pharmacyMasterDataService.searchStoreSupplierType(
				storeSupplierTypeCode, storeSupplierTypeName);
	}

	// ------------------------------Store
	// Supplier-----------------------------------
	public boolean addStoreSupplier(MasStoreSupplier masStoreSupplier,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.addStoreSupplier(masStoreSupplier,
				generalMap);
	}

	public boolean deleteStoreSupplier(Integer storeSupplierId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteStoreSupplier(storeSupplierId,
				generalMap);
	}

	public boolean editStoreSupplierToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService
				.editStoreSupplierToDatabase(generalMap);
	}

	public Map<String, Object> showStoreSupplierJsp(Map<String, Object> dataMap) {
		return pharmacyMasterDataService.showStoreSupplierJsp(dataMap);
	}

	public Map<String, Object> searchStoreSupplier(String storeSupplierCode,
			String storeSupplierName,int hospitalId,int deptId) {
		return pharmacyMasterDataService.searchStoreSupplier(storeSupplierCode,
				storeSupplierName,hospitalId,deptId);
	}

	// -----------------------------Item Type
	// Supplier-----------------------------------
	/*
	 * public boolean addItemWiseSupplier(MasItemWiseSupplier
	 * masItemWiseSupplier) { return
	 * pharmacyMasterDataService.addItemWiseSupplier(masItemWiseSupplier); }
	 * public boolean deleteItemWiseSupplier(Integer
	 * itemWiseSupplierId,Map<String, Object> generalMap) { return
	 * pharmacyMasterDataService
	 * .deleteItemWiseSupplier(itemWiseSupplierId,generalMap); } public boolean
	 * editItemWiseSupplier(Map<String, Object> generalMap) { return
	 * pharmacyMasterDataService.editItemWiseSupplier(generalMap); } public
	 * Map<String, Object> getItemWiseSupplier() { return
	 * pharmacyMasterDataService.getItemWiseSupplier(); }
	 * 
	 * @SuppressWarnings("unchecked") public Map<String,Object>
	 * searchItemWiseSupplier(String itemWiseSupplierCode,String
	 * itemWiseSupplierName) { return
	 * pharmacyMasterDataService.searchItemWiseSupplier(itemWiseSupplierCode,
	 * itemWiseSupplierName); } public boolean checkItem(int itemId) { return
	 * pharmacyMasterDataService.checkItem(itemId); }
	 */

	// ---------------------------Item generic--------------------
	public Map<String, Object> showItemGenericJsp() {
		return pharmacyMasterDataService.showItemGenericJsp();
	}

	public Map<String, Object> searchItemGeneric(String genericName) {
		return pharmacyMasterDataService.searchItemGeneric(genericName);
	}

	public boolean addItemGeneric(MasStoreItemGeneric masStoreItemGeneric) {
		return pharmacyMasterDataService.addItemGeneric(masStoreItemGeneric);
	}

	public boolean deleteItemGeneric(int itemGenericId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemGeneric(itemGenericId,
				generalMap);
	}

	public boolean editItemGeneric(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItemGeneric(generalMap);
	}

	// ----------------------------------ITEM--------------------------------------------
	
	public List checkNivNo(Map<String, Object> testMap) 
	{
		// TODO Auto-generated method stub
		return pharmacyMasterDataService.checkNivNo(testMap);
	}
	
	public List checkNomenclature(Map<String, Object> testMap) 
	{
		// TODO Auto-generated method stub
		return pharmacyMasterDataService.checkNomenclature(testMap);
	}
	
	
	
	public Map<String, Object> showItemJsp(int deptId,int hospitalId) {
		return pharmacyMasterDataService.showItemJsp(deptId,hospitalId);
	}

	public boolean addItem(MasStoreItem masStoreItem ) {
		return pharmacyMasterDataService.addItem(masStoreItem);
	}

	public boolean editItem(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItem(generalMap);
	}

	public boolean deleteItem(Integer itemId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItem(itemId, generalMap);
	}

	// -----------------------------Section-----------------------
	public boolean addStoreSection(MasStoreSection masStoreSection) {
		return pharmacyMasterDataService.addStoreSection(masStoreSection);
	}

	public boolean deleteStoreSection(int sectionId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteStoreSection(sectionId,
				generalMap);
	}

	public boolean editStoreSectionToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editStoreSectionToDatabase(generalMap);
	}

	public Map<String, Object> searchStoreSection(String sectionCode,
			String sectionName) {
		return pharmacyMasterDataService.searchStoreSection(sectionCode,
				sectionName);
	}

	public Map<String, Object> showStoreSectionJsp() {
		return pharmacyMasterDataService.showStoreSectionJsp();
	}

	// ------------------------------------------StoreVendorWiseManufacturer----------------------------
	@Override
	public boolean addStoreVendorWiseManufacturer(
			MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer) {
		return pharmacyMasterDataService.addStoreVendorWiseManufacturer(
				masStoreVendorWiseManufacturer);
	}

	public boolean deleteStoreVendorWiseManufacturer(
			int storeVendorWiseManufacturerId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteStoreVendorWiseManufacturer(
				storeVendorWiseManufacturerId, generalMap);
	}

	public Map<String, Object> searchStoreVendorWiseManufacturer(
			String storeVendorWiseManufacturerCode) {
		return pharmacyMasterDataService
				.searchStoreVendorWiseManufacturer(storeVendorWiseManufacturerCode);
	}

	public Map<String, Object> showStoreVendorWiseManufacturerJsp() {
		return pharmacyMasterDataService.showStoreVendorWiseManufacturerJsp();
	}

	public boolean editStoreVendorWiseManufacturerToDatabase(
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService
				.editStoreVendorWiseManufacturerToDatabase(generalMap);
	}

	// ---------------------Financial----------------------------------------------

	public boolean addFinancial(MasStoreFinancial masStoreFinancial) {
		return pharmacyMasterDataService.addFinancial(masStoreFinancial);
	}

	public boolean deleteFinancial(int financialId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteFinancial(financialId,
				generalMap);
	}

	public boolean editFinancialToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editFinancialToDatabase(generalMap);
	}

	public Map<String, Object> searchFinancial(Date startDate, Date endDate) {
		return pharmacyMasterDataService.searchFinancial(startDate, endDate);
	}

	public Map<String, Object> showFinancialJsp() {
		return pharmacyMasterDataService.showFinancialJsp();
	}

	// ----------------------------Pharma Index------------------------

	public boolean addPharmaIndex(MasStorePharmaIndex masStorePharmaIndex) {
		return pharmacyMasterDataService.addPharmaIndex(masStorePharmaIndex);
	}

	public boolean editPharmaIndexToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editPharmaIndexToDatabase(generalMap);
	}

	public Map<String, Object> searchPharmaIndex(String pharmaIndexName) {
		return pharmacyMasterDataService.searchPharmaIndex(pharmaIndexName);
	}

	public Map<String, Object> showPharmaIndexJsp() {
		return pharmacyMasterDataService.showPharmaIndexJsp();
	}

	public boolean deletePharmaIndex(int pharmaIndexId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deletePharmaIndex(pharmaIndexId,
				generalMap);
	}

	// ----------------------------------Item
	// Unit-----------------------------------------

	public boolean addItemUnit(MasStoreUnit masStoreUnit) {
		return pharmacyMasterDataService.addItemUnit(masStoreUnit);
	}

	public boolean editItemUnitToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItemUnitToDatabase(generalMap);
	}

	public Map<String, Object> searchItemUnit(String unitName) {
		return pharmacyMasterDataService.searchItemUnit(unitName);
	}

	public Map<String, Object> showItemUnitJsp() {
		return pharmacyMasterDataService.showItemUnitJsp();
	}

	public boolean deleteItemUnit(int itemUnitId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemUnit(itemUnitId, generalMap);
	}

	// --------------------------Item
	// Conversion----------------------------------------

	public Map<String, Object> showItemConversionJsp() {
		return pharmacyMasterDataService.showItemConversionJsp();
	}

	public Map<String, Object> searchItemConversion(String itemUnitName) {
		return pharmacyMasterDataService.searchItemConversion(itemUnitName);
	}

	public boolean addItemConversion(
			MasStoreItemConversion masStoreItemConversion) {
		return pharmacyMasterDataService
				.addItemConversion(masStoreItemConversion);
	}

	public boolean editItemConversionToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService
				.editItemConversionToDatabase(generalMap);
	}

	public boolean deleteItemConversion(int itemConversionId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemConversion(itemConversionId,
				generalMap);
	}

	// ------------------------------PO
	// Delivery---------------------------------------
	public Map<String, Object> showPoDeliveryTermsJsp() {
		return pharmacyMasterDataService.showPoDeliveryTermsJsp();
	}

	public Map<String, Object> searchPoDeliveryTerms(String poDeliveryType) {
		return pharmacyMasterDataService.searchPoDeliveryTerms(poDeliveryType);
	}

	public boolean addPoDeliveryTerms(
			MasStorePoDeliveryTerms masStorePoDeliveryTerms) {
		return pharmacyMasterDataService
				.addPoDeliveryTerms(masStorePoDeliveryTerms);
	}

	public boolean deletePoDeliveryTerms(int poDeliveryTermsId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deletePoDeliveryTerms(
				poDeliveryTermsId, generalMap);
	}

	public boolean editPoDeliveryTermsToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService
				.editPoDeliveryTermsToDatabase(generalMap);
	}

	// ------------------------Budget Entry
	// Master-------------------------------------------
	public Map<String, Object> showBudgetJsp(int deptId,int hospitalId) {
		return pharmacyMasterDataService.showBudgetJsp(deptId,hospitalId);
	}
	
	

	/*
	 * public Map<String, Object> searchBudget(String code) { return
	 * pharmacyMasterDataService.searchBudget(code); } public boolean
	 * addBudget(MasStoreBudget masStoreBudget) { return
	 * pharmacyMasterDataService.addBudget(masStoreBudget); } public boolean
	 * deleteBudget(int budgetId,Map<String, Object> generalMap) { return
	 * pharmacyMasterDataService.deleteBudget(budgetId,generalMap); } public
	 * boolean editBudgetToDatabase(Map<String, Object> generalMap) { return
	 * pharmacyMasterDataService.editBudgetToDatabase(generalMap); }
	 */
	public Map<String, Object> getFinancialYearDetails(
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.getFinancialYearDetails(generalMap);
	}

	public boolean addBudgetDetails(Map<String, Object> budgetMap) {
		return pharmacyMasterDataService.addBudgetDetails(budgetMap);
	}

	public boolean addBudgetEntry(MasStoreBudget masStoreBudget,
			List<MasStoreBudgetT> masStoreBudgetTList,
			Map<String, Object> infoMap) {
		return pharmacyMasterDataService.addBudgetEntry(masStoreBudget,
				masStoreBudgetTList, infoMap);
	}

	public int getMasStoreBudgetId(int budgetCode) {
		return pharmacyMasterDataService.getMasStoreBudgetId(budgetCode);
	}

	public Map<String, Object> searchMasStoreBudget(
			Map<String, Object> searchFieldMap) {
		return pharmacyMasterDataService.searchMasStoreBudget(searchFieldMap);
	}

	public Map<String, Object> getBudgetEntryModifyMap(int radio_str) {
		return pharmacyMasterDataService.getBudgetEntryModifyMap(radio_str);
	}

	public Map<String, Object> getBudgetAndTUpdate(int budgetId) {
		return pharmacyMasterDataService.getBudgetAndTUpdate(budgetId);
	}

	public boolean updateBudgetEntry(MasStoreBudget masStoreBudget,
			List<MasStoreBudgetT> masStoreBudgetTList) {
		return pharmacyMasterDataService.updateBudgetEntry(masStoreBudget,
				masStoreBudgetTList);
	}

	
	public boolean deleteMeScale(int meScaleId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteMeScale(meScaleId, generalMap);
	}

	public boolean editMeScaleToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editMeScaleToDatabase(generalMap);
	}

	public Map<String, Object> showMeScaleJsp() {
		return pharmacyMasterDataService.showMeScaleJsp();
	}

	// ------------------------AirForceUnitDepot--------------------------------

	public boolean addAirForceUnitDepot(
			MasStoreAirForceDepot masStoreAirForceDepot) {
		return pharmacyMasterDataService
				.addAirForceUnitDepot(masStoreAirForceDepot);
	}

	public boolean deleteAirForceUnitDepot(int airForceDepotId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteAirForceUnitDepot(
				airForceDepotId, generalMap);
	}

	public boolean editAirForceUnitDepotToDatabase(
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService
				.editAirForceUnitDepotToDatabase(generalMap);
	}

	public Map<String, Object> searchAirForceUnitDepot(String airForceDepotName) {
		return pharmacyMasterDataService
				.searchAirForceUnitDepot(airForceDepotName);
	}

	public Map<String, Object> showAirForceUnitDepotJsp() {
		return pharmacyMasterDataService.showAirForceUnitDepotJsp();
	}

	// -------------------------------------------------------------------------------------
	public PharmacyMasterDataService getPharmacyMasterDataService() {
		return pharmacyMasterDataService;
	}

	public void setPharmacyMasterDataService(
			PharmacyMasterDataService pharmacyMasterDataService) {
		this.pharmacyMasterDataService = pharmacyMasterDataService;
	}

	public Map<String, Object> searchMeScale1(Map<String, Object> dataMap) {
		return pharmacyMasterDataService.searchMeScale1(dataMap);
	}

	public Map<String, Object> searchItem(String pvmsNo, String nomenclature,
			int deptId, String sectionCode,int hospitalId,int ItemType) {
		return pharmacyMasterDataService.searchItem(pvmsNo, nomenclature,
				deptId, sectionCode,hospitalId,ItemType);
	}

	public Map<String, Object> getConnection() {
		return pharmacyMasterDataService.getConnection();
	}

	/*
	 * public Map<String, Object> searchItem(String nomenclature) { // TODO
	 * Auto-generated method stub return null; }
	 */

	// ---------------------------Mas Store
	// Group---------------------------------
	public boolean addStoreGroup(MasStoreGroup masStoreGroup) {
		return pharmacyMasterDataService.addStoreGroup(masStoreGroup);
	}

	public boolean deleteStoreGroup(int groupId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteStoreGroup(groupId, generalMap);
	}

	public boolean editGroupToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editGroupToDatabase(generalMap);
	}

	public Map<String, Object> searchStoreGroup(String groupCode,
			String groupName) {
		return pharmacyMasterDataService.searchStoreGroup(groupCode, groupName);
	}

	public Map<String, Object> showStoreGroupJsp() {
		return pharmacyMasterDataService.showStoreGroupJsp();
	}

	public List<MasStoreItem> checkForExistingPvmsNo(String pvmsNo) {
		return pharmacyMasterDataService.checkForExistingPvmsNo(pvmsNo);
	}

	public int addBudgetMaster(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.addBudgetMaster(generalMap);
	}

	public Map<String, Object> showBrandJsp(Box box) {
		return pharmacyMasterDataService.showBrandJsp(box);
	}

	public Map<String, Object> editBrandToDatabase(
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editBrandToDatabase(generalMap);
	}

	public Map<String, Object> showMatchedBrandList(Map<String, Object> parameterMap) {
		return pharmacyMasterDataService.showMatchedBrandList(parameterMap);
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		return pharmacyMasterDataService.getConnectionForReport();
	}

	@Override
	public String getHospitalName(int hospitalId) {
		return pharmacyMasterDataService.getHospitalName(hospitalId);
	}

	@Override
	public Map<String, Object> generatePVMSExcel(Map<String, Object> requestParameters) {
		return pharmacyMasterDataService.generatePVMSExcel(requestParameters);
	}
	
	/*******************************  For Save Me Scale By Tirath   *******************************/
	public boolean saveMeScale(Box box)
	{
		return pharmacyMasterDataService.saveMeScale(box);
	}
	
	public boolean updateMeScale(Box box)
	{
		return pharmacyMasterDataService.updateMeScale(box);
	}
	
	public boolean addRepairStation(MasRepairStation masRepairStation)
	{
		return pharmacyMasterDataService.addRepairStation(masRepairStation);
	}
	public boolean editRepairStation(Map<String, Object> generalMap)
	{
		return pharmacyMasterDataService.editRepairStation(generalMap);
	}
	
	public boolean deleteRepairStation(int financialId, Map<String, Object> generalMap)
	{
		return pharmacyMasterDataService.deleteRepairStation(financialId,generalMap);
	}

	public Map<String,Object>showRepairStationJsp(Map<String,Object>dataMap)
	{
		return pharmacyMasterDataService.showRepairStationJsp(dataMap);
	}

	@Override
	public Map<String, Object> showBudgetCodeJsp() {
		return pharmacyMasterDataService.showBudgetCodeJsp();
	}

	@Override
	public boolean deleteBudgetCode(int budgetCodeId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteBudgetCode(budgetCodeId, generalMap);
	}

	@Override
	public boolean editBudgetCodeToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editBudgetCodeToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchBudgetCode(String budgetCodeCode,
			String budgetCodeName) {
		return pharmacyMasterDataService.searchBudgetCode(budgetCodeCode, budgetCodeName);
	}

	@Override
	public boolean addBudgetCode(MasBudgetCode masBudgetCode) {
		return pharmacyMasterDataService.addBudgetCode(masBudgetCode);
	}
	
	@Override
	public Map<String, Object> getItemTypeGLList(Map<String, Object> dataMap) {
		return pharmacyMasterDataService.getItemTypeGLList(dataMap);
	}

	@Override
	public Map<String, Object> getSectionGLList(Map<String, Object> dataMap) {
		return pharmacyMasterDataService.getSectionGLList(dataMap);
	}

	@Override
	public Map<String, Object> getCategoryList(Box box) {
		
		return pharmacyMasterDataService.getCategoryList(box);
	}

	// ---------------------------------------Item
		// Class-----------------------------------

		
		  public Map<String, Object> showItemClassJsp() {
			  return  pharmacyMasterDataService.showItemClassJsp();
			 }
		  public boolean addItemClass(MasItemClass masItemClass) {
			  return pharmacyMasterDataService.addItemClass(masItemClass); }
		  
		  public boolean deleteItemClass(int itemClassId,Map<String, Object> generalMap)
		  {
			  return pharmacyMasterDataService.deleteItemClass(itemClassId,generalMap);
			 }
		  
		  public boolean editItemClassToDatabase(Map<String, Object> generalMap) {
			  return pharmacyMasterDataService.editItemClassToDatabase(generalMap); 
		  }
		  
		  public Map<String, Object> searchItemClass(String itemClassCode,String itemClassName) {
			  return pharmacyMasterDataService.searchItemClass(itemClassCode,itemClassName); 
			  }
		 
		  public Map<String, Object> showItemNIPJsp(int deptId,int hospitalId) {
				return pharmacyMasterDataService.showItemNIPJsp(deptId,hospitalId);
			}

			public boolean addItemNIP(MasStoreItem masStoreItem ) {
				return pharmacyMasterDataService.addItemNIP(masStoreItem);
			}

			public boolean editItemNIP(Map<String, Object> generalMap) {
				return pharmacyMasterDataService.editItemNIP(generalMap);
			}

			
		

			@Override
			public Map<String, Object> searchItemNIP(String pvmsNo,
					String nomenclature, int deptId, String sectionCode,
					int hospitalId, int itemType) {
				  return pharmacyMasterDataService.searchItemNIP(pvmsNo, nomenclature, deptId, sectionCode, hospitalId, itemType);
			}

			@Override
			public boolean deleteItemNIP(int itemId,
					Map<String, Object> generalMap) {
				return pharmacyMasterDataService.deleteItemNIP(itemId, generalMap);
			}

			public List<MasStoreItem> checkForExistingPvmsNoNIP(String pvmsNo) {
				return pharmacyMasterDataService.checkForExistingPvmsNoNIP(pvmsNo);
			}

			@Override
			public Map<String, Object> showNonDrugJsp(int deptId, int hospitalId) {
				return pharmacyMasterDataService.showNonDrugJsp(deptId, hospitalId);
			}

			@Override
			public Map<String, Object> searchNonDrug(String pvmsNo,
					String nomenclature, int deptId, String sectionCode,
					int hospitalId, int itemType) {
				return pharmacyMasterDataService.searchNonDrug(pvmsNo, nomenclature, deptId, sectionCode, hospitalId, itemType);
			}

			@Override
			public boolean addNonDrug(MasStoreItem masStoreItem) {
				return pharmacyMasterDataService.addNonDrug(masStoreItem);
			}

			@Override
			public boolean deleteNonDrug(int itemId,
					Map<String, Object> generalMap) {
				return pharmacyMasterDataService.deleteNonDrug(itemId, generalMap);
			}

			@Override
			public List<MasStoreItem> checkForExistingPvmsNoNonDrug(String pvmsNo) {
				return pharmacyMasterDataService.checkForExistingPvmsNoNonDrug(pvmsNo);
			}

			@Override
			public boolean editNonDrug(Map<String, Object> generalMap) {
				return pharmacyMasterDataService.editNonDrug(generalMap);
			}

			@Override
			public boolean addMprPriority(MprPriority masMprPriority) {
				return pharmacyMasterDataService.addMprPriority(masMprPriority);
			}

			@Override
			public Map<String, Object> showMprPriorityJsp() {
				return pharmacyMasterDataService.showMprPriorityJsp();
			}

			@Override
			public Map<String, Object> searchMprPriority(
					String mprPriorityCode, String mprPriorityName) {
				return pharmacyMasterDataService.searchMprPriority(mprPriorityCode, mprPriorityName);
			}

			@Override
			public boolean editMprPriorityToDatabase(
					Map<String, Object> generalMap) {
				return pharmacyMasterDataService.editMprPriorityToDatabase(generalMap);
			}

			@Override
			public boolean deleteMprPriority(int mprPriorityId,
					Map<String, Object> generalMap) {
				return pharmacyMasterDataService.deleteMprPriority(mprPriorityId, generalMap);
			}

}
