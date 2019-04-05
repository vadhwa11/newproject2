package jkt.hms.stores.dataservice;

import java.util.List;
import java.util.Map;

import javax.transaction.SystemException;

import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.StoreBalanceM;
import jkt.hms.masters.business.StoreBalanceT;
import jkt.hms.masters.business.StoreBoo;
import jkt.hms.masters.business.StoreDefectiveDrugM;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreIndentSocTracker;
import jkt.hms.masters.business.StoreLoaninM;
import jkt.hms.masters.business.StoreLoaninT;
import jkt.hms.masters.business.StoreMaterialPurchaseReqM;
import jkt.hms.masters.business.StoreOpPatientIssueM;
import jkt.hms.masters.business.StoreOpPatientIssueT;
import jkt.hms.masters.business.StoreSampleTestingEntry;
import jkt.hms.masters.business.StoreStockTakingM;
import jkt.hms.masters.business.StoreStockTakingT;
import jkt.hms.masters.business.StoreSupplyOrderEntry;
import jkt.hms.util.Box;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public interface StoresDataService {
	// ===================== START OF GRN,LOANIN,BOO,DEFECTIVE ENTRY BY ABHA
	// ===========
	// ======================= END OF ABHA Code===================
	// ===================================================================================================================
	Map showGrnJsp(Box box, Map<String, Object> dataMap);
	Map showGrnProJsp(Box box, Map<String, Object> dataMap);

	Map<String, Object> getDetailsForMoreInfoGrn();



	public Map<String , Object> ShowListOFLoanInForUpdate();

	public Map<String ,Object>updateForLoanIn(Box box);

	Map showLoanInJsp(Map<String, Object> dataMap);

	Map searchGrn(Map searchFieldMap) ;

	// Map getGrnModifyMap(int radio_str);
	// Map getLoanInModifyMap(int radio_str);
	public boolean addGrns(Map<String, Object> infoMap,
			Map<String, Object> dataMap);

	boolean updateGrn(StoreGrnM storeGrnM, List list);

	boolean addLoanIn(Map<String, Object> infoMap, Map<String, Object> dataMap);

	List<StoreGrnM> getCrvNumberList(int deptId);

	Map<String, Object> getIndentList(String choice);

	Map<String, Object> getVendorList(String vendor);

	Map<String, Object> getLoanInList(int poId);

	Map getBarcodeList(int grnId);

	public Map<String, Object> getGrnNoListForAutoComplete(Box box);

	List<StoreGrnT> getStoreGrnTListForMoreInfo(int storeGrnTId);

	Map getViewAllMap();

	Map searchLoanin(Map searchFieldMap) ;

	Map<String, Object> modifyLoanin(int id, int pageNo);

	List<StoreLoaninT> getLoanInListForMoreInfo(int loaninDetailId);

	boolean updateLoanIn(Map<String, Object> infoMap);

	Map<String, Object> getDetailsForLoanIn();

	List<StoreGrnM> getGrn(int grnId);

	// Map<String, Object> grnModifyMap(int id, int pageNo);
	List<StoreLoaninM> getloanList();

	boolean submitAdjustLoanIn(int loaninId, StoreGrnM storeGrnM, int poId,
			List list, Map<String, Object> infoMap);

	Map<String, Object> getExpiryDateInAjax(Map<String, Object> dataMap);

	Map<String, Object> modifyGrn(int id, int pageNo, int spoid, String items);

	List<StoreGrnM> getGrnList();

	Map<String, Object> getAdjustmentList(int workOrderId, int pageNo,
			String items, String loan);

	// ---------------------------- BOO ENTRY---------------------
	Map<String, Object> showBooJsp(Map<String, Object> infoMap);

	boolean addBoo(Map<String, Object> infoMap);

	Map searchBoo(Map searchFieldMap);

	Map<String, Object> getBooModifyMap(int radio_str);

	boolean updateBoo(StoreBoo storeBoo, List list);

	// -------------- connection-----
	Map<String, Object> getGrnPrintMap(int grnId);

	Map<String, Object> getContingentBillPrintMap(int grnId);

	Map<String, Object> getProformaPrintMap(int grnId);

	Map<String, Object> showGridJsp(Box box);

	Map<String, Object> showGridLoanInJsp(Box box);

	Map<String, Object> showDefectiveDrugJsp(Map<String, Object> dataMap);
	Map<String, Object> showProformaBSearchJsp(Map<String, Object> dataMap);

	Map<String, Object> fillItemsForDefectiveDrugs(Map<String, Object> dataMap);

	Map<String, Object> getItemListForDefectiveDrugsByAutocomplete(
			Map<String, Object> dataMap);

	public boolean addDefectiveDrugs(Map<String, Object> infoMap,
			Map<String, Object> dataMap);

	public boolean addProformaBEntry(Map<String, Object> infoMap,
			Map<String, Object> dataMap);

	Map searchDefectiveDrug(Map searchFieldMap) ;

	Map getDefectiveDrugModifyMap(int id, int pageNo);

	List<StoreDefectiveDrugM> getDefectDrug(int entryId);

	List<StoreDefectiveDrugM> getDefectiveList();

	Map<String, Object> defectiveDrugModifyMap(int id);

	boolean createAdjustment(Map<String, Object> infoMap);

	Map getResponseIndentList(Box box);
	Map getResponseProformaList(Box box);

	Map<String, Object> fillItemsForGrn(Map<String, Object> dataMap);

	Map<String, Object> getItemListForGrnByAutocomplete(
			Map<String, Object> dataMap);

	Map getResponsePoList(Box box);

	Map<String, Object> fillItemsForLoanIn(Map<String, Object> dataMap);

	Map<String, Object> getItemListForLoanInByAutocomplete(
			Map<String, Object> dataMap);

	List<StoreDefectiveDrugM> getDefectiveDrugsList();

	List<StoreBoo> getBooList();

	// ==========================================================================================
	// =======================END OF METHODS BY ABHA==========================
	// =================================================================================================

	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By
	// Vivek------------------------------------------
	// ****************************************************************************************************************

	// ---------Indent To Depot------------------

	public Map<String, Object> showPrintIndentDepotJsp(
			Map<String, Object> dataMap);

	Map<String, Object> getItemListForIndentToDepot(Map<String, Object> dataMap);

	Map<String, Object> fillItemsForIndentToDepot(Map<String, Object> dataMap);

	Map<String, Object> getItemListForMMFIndentModify(
			Map<String, Object> dataMap);

	Map<String, Object> fillItemsCommon(Map<String, Object> dataMap);

	Map<String, Object> updateArrovalPro(Map<String, Object> dataMap);
	Map<String, Object> validateNivMaster(Map<String, Object> dataMap);

	Map<String, Object> showIndentJspDepot(Map<String, Object> dataMap);

	Map<String, Object> addNextOrSubmitIndentToDepot(Map<String, Object> dataMap);

	Map<String, Object> getIndentModifyMapForDepot(int indentId, int pageNo , int deptId,int hospitalId);
	Map<String, Object> getIndentModifyMapForDepotOld(int indentId, int pageNo , int deptId,int hospitalId);

	boolean updateNextIndentToDepot(Map<String, Object> masterAndDetailMap);

	Map<String, Object> getIndentDepotPrintMap(int indentId);

	// ---------End of Indent To Depot------------------
	// ---------Indent To SOC ------------------

	Map<String, Object> getItemListForIndentToSOC(Map<String, Object> dataMap);

	Map<String, Object> showIndentJspSOC(Map<String, Object> dataMap);

	Map<String, Object> addNextOrSubmitIndentToSOC(Map<String, Object> dataMap);

	Map<String, Object> getIndentModifyMapForSOC(int indentId, int pageNo);

	boolean updateNextIndentToSOC(Map<String, Object> masterAndDetailMap);

	Map getBrandListForSOC(int itemId);

	Map getBrandListForSOC(int itemId, int detailId);

	Map<String, Object> fillItemsForIndentToSOC(Map<String, Object> dataMap);

	Map<String, Object> getManufacturerNameInAjax(Map<String, Object> dataMap);

	// ---------End of Indent To SOC------------------

	// ------------------------------------Start of MMF
	// Indent-----------------------------------------------------------
	Map printMmfIndent(int indentId);

	Map<String, Object> getItemListForMMFIndent(Map<String, Object> dataMap);

	Map showIndent(int deptId);

	Map searchIndent(Map searchFieldMap) ;

	boolean addIndent(StoreIndentM storeIndentM) throws IllegalStateException,
			SystemException;

	boolean addIndents(StoreIndentM storeIndentM, List list, Map map);

	Map getIndentModifyMap(int indentId, int pageNo);

	boolean updateIndent(StoreIndentM storeIndentM, List list);

	StoreIndentM getStoresIndentMObject(int indentId);

	int getIndentId(int mmfForTheYear);

	public Map getIndentMAndTUpdate(int indentId);

	Map getIndentMAndT(int indentId);

	public Map getIndentSocPrintMap(int indentId);

	boolean updateNextIndent(Map<String, Object> masterAndDetailMap)
			throws java.text.ParseException;

	Map<String, Object> checkExistenceOfCuurentYearIndent(int year);

	Map<String, Object> showImportMMFIndentJsp(Map<String, Object> dataMap);;

	Map<String, Object> importMMFIndent(Map<String, Object> dataMap)
			throws java.text.ParseException;

	Map<String, Object> showLockMMFIndent();

	Map<String, Object> lockMMFIndent(int year);

	// ------------------------------------End of MMF
	// Indent-----------------------------------------------------------

	// ----------------------------Start Of Issues To Dispensary (CIV)
	// ----------------------

	public Map<String, Object> getIssueDetailPageByPage(
			Map<String, Object> pageMap);

	Map openDeletePopupForIssueciv(Map<String, Object> dataMap);

	Map<String, Object> showIssueDispensaryJsp(Map<String, Object> dataMap);

	Map<String, Object> showIssueUnit(Map<String, Object> dataMap);

	Map<String, Object> getBrandMap(Map<String, Object> dataMap)
			throws java.text.ParseException;

	boolean addBrandDetails(Map<String, Object> dataMap);

	int getIssueId(String issueNo);

	Map<String, Object> getAdjustLoanOutMap(Map<String, Object> dataMap);

	Map<String, Object> showPrintIssueToDispensary();

	Map<String, Object> getIssuePrintMap(int issue_m_id);

	Map<String, Object> getIssueIndentMap(String demandNo, int deptId);

	Map showDeleteIsuueCiv(Box box);

	Map deleteIssueCivItems(Box box);

	Map searchIssueCiv(Box box);

	List<MasStoreItem> getItemList();

	Map<String, Object> getDemandList(Map dataMap);

	Map<String, Object> adjustLoanOut(Map<String, Object> dataMap);

	Map<String, Object> searchInternalIndentDetails(Map<String, Object> dataMap);

	Map<String, Object> checkYearExists(Map<String, Object> dataMap);

	Map<String, Object> getItemListForIssueToDispensary(
			Map<String, Object> dataMap);

	Map<String, Object> fillItemsForIssueToDispensary(
			Map<String, Object> dataMap);
	Map<String, Object> fillBatchForIssueToPatient(
			Map<String, Object> dataMap);

	// ----------------------------End Of Issues To Dispensary (CIV)
	// ----------------------

	// -------------------------------------- Start of Indent Soc Tracker
	// ------------------------------------------

	public Map<String, Object> showIndentSocTracker();

	public Map<String, Object> getIndentSocTracker(Map<String, Object> idsMap);

	public boolean addOrUpdateIndentSocTracker(
			StoreIndentSocTracker indentSocTracker, int indentSocTrackerId);

	public Map<String, Object> getItemMapForAutoComplete();

	Map<String, Object> getIndentListForSocTracker(Map<String, Object> dataMap);

	Map<String, Object> getItemListForSocTracker(Map<String, Object> dataMap);

	// -------------------------------------- End of Indent Soc Tracker
	// ------------------------------------------

	// ----------------------------Start Of Issues To Dispensary Loan Out
	// ----------------------

	Map<String, Object> checkHinExistence(Map<String, Object> dataMap);

	Map<String, Object> getHinNo(Map<String, Object> dataMap);
	Map<String, Object> getRequestedBy(Map<String, Object> dataMap);

	Map addBrandDetailsForLoanOut(Box box) throws java.text.ParseException;

	Map<String, Object> openDeletePopupForIssueLoanOut(Map dataMap);

	Map showDeleteIsuueLoanout(Box box);

	Map deleteIssueLoanoutItems(Box box);

	Map showIssueDispensaryManualJsp(Map<String, Object> dataMap);

	Map searchIssueLoanout(Box box);

	Map<String, Object> getItemListForLoanoutByAutocomplete(
			Map<String, Object> dataMap);

	// ----------------------------End Of Issues To Dispensary Loan Out
	// ----------------------

	// ----------------------------Start Of Issues To Other Units on Surplus
	// (CIV) ----------------------

	Map printIssueToOtherUnits(int issue_m_id);

	Map addBrandDetailsToOtherUnits(Box box) throws java.text.ParseException;

	Map<String, Object> openDeletePopupForIssueToOtherUnits(Map dataMap);

	Map showDeleteIsuueToOtherUnits(Box box);

	Map deleteIssueToOtherUnitsItems(Box box);

	Map showIssueToOtherUnitsJsp(Map<String, Object> dataMap);

	Map searchIssueToOtherUnits(Box box);

	Map<String, Object> getItemListThroughAjax(Map<String, Object> dataMap);

	Map<String, Object> fillItemsForIssueToDepot(Map<String, Object> dataMap);

	Map<String, Object> getItemListForIssueToOTAFU(Map<String, Object> dataMap);

	// ----------------------------End Of Issues To Other Units on Surplus (CIV)
	// ----------------------

	// ----------------------------Start Of Issues To Other Than Airforce Units
	// ----------------------

	Map addBrandDetailsToOTAFU(Box box) throws java.text.ParseException;

	Map<String, Object> openDeletePopupForIssueToOTAFU(Map dataMap);

	Map showDeleteIsuueToOTAFU(Box box);

	Map deleteIssueToOTAFU(Box box);

	Map showIssueToOTAFUJsp(Map<String, Object> dataMap);

	Map searchIssueToOTAFU(Box box);

	Map<String, Object> getItemListThroughAjaxToOTAFU(
			Map<String, Object> dataMap);

	Map<String, Object> fillItemsForIssueToOTAFU(Map<String, Object> dataMap);

	boolean addNextOrSubmitIndentToMMF(StoreIndentM storeIndentM, List list,
			Map map);

	Map<String, Object> fillIssueToOTAFUBasedOnLotNo(Map<String, Object> dataMap);

	// ----------------------------End Of Issues To Other Than Airforce Units
	// ----------------------

	// ----------------------------Start Of Vendor Return ----------------------

	Map<String, Object> fillItemsForIndentToVendorReturn(
			Map<String, Object> dataMap);

	Map<String, Object> getItemListForVendorReturn(Map<String, Object> dataMap);

	Map<String, Object> showVendorReturnJsp(Map<String, Object> map);

	Map<String, Object> showStockDetailsForVendorReturn(Map<String, Object> map);

	Map<String, Object> submitVendorReturnDetails(Map<String, Object> dataMap);

	Map<String, Object> showDeleteVendorReturn(Map<String, Object> map);

	boolean deleteStockDetailsVendorReturn(Map<String, Object> map);

	Map<String, Object> searchVendorReturn(Map<String, Object> searchFieldMap);

	// ----------------------------End Of Vendor Return ----------------------
	// *********************************************************************************************************************
	// ------------------------------------End of Methods Written By
	// Vivek------------------------------------------
	// ****************************************************************************************************************
	// ****************************************************************************************************************
	// ------------------------------------ Methods Written By
	// Vikas------------------------------------------
	// ****************************************************************************************************************

	Map<String, Object> showOPDPatientIssue(Map map);

	Map<String, Object> getHinNoList(String serviceNumber);

	Map<String, Object> getParaList(String issueNo);

	Map<String, Object> showOPDPatientIssueGrid(Map map);
	
	Map<String, Object> showIPDPartialPatientIssueGrid(Map map);

	Map<String, Object> showOPDStockDetailsJsp(Map map);

	Map<String, Object> submitOPDPatientStockDetails(Map map);
	
	Map<String, Object> submitIPPatientStockDetails(Box box);

	Map<String, Object> showModifyOPDPatientIssueJsp(Map map);

	boolean deleteStockDetails(Map map);

	Map<String, Object> showStockDetailsForLotNo(Map map);

	Map<String, Object> getItemListForOPD(Map map);

	Map<String, Object> fillItemsInGridForOPD(Map map);

	Map<String, Object> fillItemsInGridForOPDDir(Map map);

	Map<String, Object> fillItemsInGridForLotNo(Map map);

	// *********************************************************************************************************************
	// ------------------------------------End of Methods Written By
	// Vikas------------------------------------------
	// ****************************************************************************************************************

	// *************************START BY DEEPTI
	// TEVATIA********************************************

	// -------------------------------Return from
	// Dispensary------------------------------

	Map<String, Object> showReturnFromDispensaryJsp(Map<String, Object> map);

	Map<String, Object> showStockDetailsForReturnDispensary(
			Map<String, Object> map);

	Map<String, Object> submitReturnDispensaryDetails(Map<String, Object> map);
	//boolean submitReturnDispensaryDetails(Map<String, Object> map);

	Map<String, Object> showDeleteReturnFromDispensary(Map<String, Object> map);

	boolean deleteStockDetailsReturnToDispensary(Map<String, Object> map);

	Map<String, Object> searchReturnToDispensary(
			Map<String, Object> searchFieldMap);

	Map<String, Object> getItemListForDepartmentReturn(
			Map<String, Object> dataMap);

	// -------------------------------Store
	// MMF-------------------------------------

	Map<String, Object> showMmfDepartment(int deptId, int hospitalId);

	Map<String, Object> createAndImportMmfDepartmentData(Box box);

	Map<String, Object> getMmfDepartmentData(Box box);

	Map<String, Object> getItemDetails(Box box);

	Map<String, Object> getItemDetailsForMmfDepartmentJspForNextRecord(Box box);

	Map<String, Object> doAddMmfItems(Box box);

	Map<String, Object> updateGridItemsInMmf(Box box);

	Map<String, Object> getCurrentYearMmf(Box box);

	Map<String, Object> deleteGridItemsForMmf(Box box);

	Map<String, Object> resetMmfDepartmentData(Box box);

	Map<String, Object> showMmfDepartmentApproval(Box box);

	Map<String, Object> getCurrentYearMmfByItem(Box box);

	Map<String, Object> updateGridItemsInMmfDepartmentApproval(Box box);

	Map<String, Object> getItemListForNomenclature(Box box);

	public Map<String, Object> getItemObject(Box box);

	public Map<String, Object> getItemObjectFromPvms(Box box);

	// ---------------------------------- Physical
	// Stock----------------------------------------

	Map<String, Object> searchPhysicalStock(int departmentId);

	boolean addPhysicalStock(StoreStockTakingM storeStockTakingM,
			List<StoreStockTakingT> storeStockTakingTlist);

	boolean updatePhysicalStock(StoreStockTakingM storeStockTakingM,
			List<StoreStockTakingT> storeStockTakingTlist);

	int getStoreMmfDepartmentId(String docNo);

	Map<String, Object> getBalance1ModifyMap(int balanceId, int pageNo,
			Map<String, Object> dataMap);

	boolean updateNextBalance1(Map<String, Object> masterAndDetailMap);

	Map<String, Object> addNextOrSubmitBalance(Map<String, Object> dataMap);

	boolean addAdjustment(Box box);

	boolean addAdjustment1(Box box);

	Map<String, Object> showAdjustment1(Box box);

	// boolean storeItemBatch(Map<String, Object> map);

	Map getMmfDepartmentModifyMapForDepot(int mmfDepartmentId, int pageNo);

	boolean updateNextMmfDepartment(Map<String, Object> masterAndDetailMap);

	Map<String, Object> addNextOrSubmitMmfDepartment(Map<String, Object> dataMap);

	// --------------------------------New Grid For Department
	// Indent----------------------

	Map<String, Object> showDepartmentIndent(int deptId,int hospitalId);

	Map<String, Object> createAndImportDepartmentIndentData(Box box);

	Map<String, Object> getDepartmentIndentData(Box box);

	Map<String, Object> getItemDetailsForDepartmentIndent(Box box);

	Map<String, Object> getItemDetailsForDepartmentIndentForNextRecord(Box box);

	Map<String, Object> doAddInternalIndentItems(Box box);

	Map<String, Object> updateGridItemsInDepartmentIndent(Box box);

	Map<String, Object> deleteGridItemsForDepartmentIndent(Box box);

	Map<String, Object> searchMmfDepartmentData(Box box);


	String getMmfNo(int docId);

	// New Grid For Physical Stock

	Map<String, Object> showPhysicalStock(Map<String, Object> dataMap);

	Map<String, Object> createGridForPhysicalStockData(Box box);

	Map<String, Object> updateGridItemsInPhysicalStock(Box box);

	Map<String, Object> getGridDataForPhysicalStock(Box box);

	// *************************END BY DEEPTI
	// TEVATIA********************************************

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------Start of Functions Written By K.R.
	// Othivadivel------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	Map<String, Object> showMMFDepartmentWiseSplitup(Box box);

	Map<String, Object> getIndentNosForSupplyOrderEntry(Box box);

	Map<String, Object> getItemsForSupplyOrderEntryJsp(Box box);

	Map<String, Object> doAddSupplyOrderEntryItems(Box box);

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------End of Functions Written By K.R.
	// Othivadivel------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------Start of Functions Written By
	// Mansi-------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	// --------------------------------------- Balance--------------------------

	Map<String, Object> showBalance(Map<String, Object> dataMap);

	Map<String, Object> searchBalance(Map<String, Object> searchFieldMap);

	boolean addBalance(StoreBalanceM storeBalanceM,
			List<StoreBalanceT> storeBalanceTlist, Map<String, Object> infoMap);

	Map<String, Object> getBalanceModifyMap(int radio_str);

	Map<String, Object> getBalanceMAndTUpdate(int balanceId);

	boolean updateBalance(StoreBalanceM storeBalanceM,
			List<StoreBalanceT> storeBalanceTlist);

	int getBalanceId(int balanceNo);

	Map<String, Object> showLastDemandNo(int pageNo);

	Map<String, Object> showLastDocNo(int pageNo);

	// -----------------------------------------------
	// Ack---------------------------------------
	Map<String, Object> showAckJsp(int deptId,int hospitalId);

	Map<String, Object> createGridIssueData(Box box);

	Map<String, Object> doAddAckItems(Box box);

	// ------------------------------------------- Supply Order Entry
	// --------------------------------

	Map<String, Object> showSupplyOrderEntryJsp();

	Map<String, Object> searchSupplyOrderEntry(int indentId);

	boolean addStoreSupplyOrderEntry(int indentId,
			List<StoreSupplyOrderEntry> storeSupplyOrderEntrylist);

	boolean updateSupplyOrderEnter(int indentId,
			List<StoreSupplyOrderEntry> storeSupplyOrderEntrylist);

	Map<String, Object> createGridSupplyOrderEntryData(Box box);

	Map<String, Object> getItemDetailsForSupplyOrderEntry(Box box);

	Map<String, Object> getItemDetailsForUpdateSupplyOrderEntry(Box box);

	Map<String, Object> fillItemsForBalance(Map<String, Object> dataMap);
	Map<String, Object> getMasterByAutocomplete(Map<String, Object> dataMap);
	Map<String, Object> jsonForMasterAdd(Map<String, Object> dataMap);

	Map<String, Object> getItemListForLoanoutByAutocompleteBalance(
			Map<String, Object> dataMap);

	Map<String, Object> getConnectionForReport();
	Map<String, Object> getResultValue(String pro,int hospitalId);

	Map<String, Object> getLPOList(int indentId);

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------End of Functions Written By
	// Mansi-------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------Start of Reports Functions Written
	// By Mansi-------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	String getHospitalName(int hospitalId);
	
	String generateABCAnalysisReport(int deptId,String fromDate,String toDate);

	Map<String, Object> showItemCatalogueJsp(Box box);

	Map<String, Object> showVendorReportJsp();

	Map<String, Object> showBrandReportJsp();

	Map<String, Object> showDrugListBodySystemWiseReportJsp();

	Map<String, Object> showVendorTurnoverEnquiryReportJsp();

	Map<String, Object> showExternalIssueReportJsp();

	Map<String, Object> showDMConsumDrugWiseReportJsp();

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------End of Reports Functions Written By
	// Mansi-------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// ---------------------------start--methods written by vikas at
	// banglore-----------------------

	Map<String, Object> getItemListForCompleteStockNomenclatureByAutocomplete(
			Map dataMap);
	Map<String, Object> getItemListForCompleteStockCommonNameByAutocomplete(
			Map dataMap);
	Map<String, Object> getStockDetails(Box box);

	Map<String, Object> getStockDetailsForNextRecord(Box box);

	Map<String, Object> submitLoanIn(Box box);
	Map<String, Object> submitCrvAftProDeatail(Box box);

	Map<String, Object> getLoanOutPrintMap(Map dataMap);

	// ---------------------------End of--methods written by vikas at
	// banglore-----------------------

	/**
	 * added by Priyanka on 13 May 2008
	 */
	Map<String, Object> getDBConnection();

	Map<String, Object> getATSODate(int indentId);

	Map<String, Object> getActualQtyAsPerAU(Map<String, Object> paramMap);

	Map<String, Object> submitGrn(Box box);

	Map<String, Object> getBudgetDetails(Box box);

	Map<String, Object> getEcelSheetDataForMMf(Box box);

	Map<String, Object> getItemDetailsForStockTakingAdd(Box box);

	Map<String, Object> doAddStockTakingItems(Box box);

	Map<String, Object> showDispensaryComsumptionJsp(Box box);

	Map<String, Object> submitDispensaryConsumptionStockDetails(
			Map<String, Object> map);

	// :::::::::::START::::::::::::ADD FOR CRV MODIFICATION
	// SCREEN:::::::::::::::BY KALYAN::::::::::::::::::::::
	Map<String, Object> updateCrv(Box box);

	Map<String, Object> getSOItemDetails(Box box);

	Map<String, Object> getLPItemDetails(Box box);
	Map<String, Object> getLPItemDetailsValidate(Box box);
	Map<String, Object> getLPItemProBDetails(Box box);

	Map<String, Object> findloanInItems(Map<String, Object> dataMap);

	Map<String, Object> findGrnLedgeraction(Map<String, Object> dataMap);

	// :::::::::::END::::::::::::ADD FOR CRV MODIFICATION
	// SCREEN::::::::::::::::::::::::::::::::::::::::::::::::
	Map<String, Object> pendingSupplierOrderDetails(Map<String, Object> dataMap);

	Map<String, Object> showItemSearchJsp(Box box);

	Map<String, Object> showPvmsNomencaltureSearchJsp(Box box);

	Map<String, Object> showLoanOutStatusJsp(Box box);

	Map<String, Object> getItemId(Box box);

	Map<String, Object> getMasItemId(Box box);

	Map<String, Object> checkgrnNo(Box box);

	Map<String, Object> getVendorDetails(Box box);

	boolean closeIssueCiv(int issueId);

	public Map<String, Object> getItemListForLoanoutByAutocompleteBalancePvms(
			Map<String, Object> dataMap);

	boolean checkCrvStatus(Box box);

	Map<String, Object> deleteOpeningBalanceItems(Box box);

	Map<String, Object> validateOpeningBalanceItems(Box box);

	Map<String, Object> deleteGridItemsIssueToDispensary(Box box);

	Map<String, Object> showNewDepartmentMMFJsp(Box box);

	Map<String, Object> doAddNewMmfItems(Box box);

	Map<String, Object> createAndImportTotalMmfDepartmentData(Box box);

Map<String , Object> showItemAdjustmentScreen(Map<String , Object> map );

	public Map<String, Object> fillItemsForAdjustment(Map<String, Object> dataMap) ;

	public boolean updateItemForAdjustment(Map<String ,Object> map);

	boolean updateGRN();

	Map<String, Object> getitem(Box box);
	Map<String, Object> getPatientDetailsForPrescription(int wardId);
	Map<String, Object> getPatientDetailsForPartialPrescription(int prescriptionId);
	Map<String, Object> getPatientDetailsForNextPrescription(int prescriptionId);
	Map<String, Object> showSearchDepartmentIndent(int deptId, int hospitalId);
	Map<String, Object> showDemandIssueReportJsp(int deptId);
	Map<String, Object> searchItemForMMFApproval(Box box);
	Map<String, Object> getVendorList();
	Map<String, Object> getSOListForLoanIn(Map<String, Object> dataMap );

	Map<String, Object> getLoanInTListForModify(int loanInId);

	Map<String, Object> getLoanInItemsForVendor(Box box);
	boolean checkDemandIssue(Map<String,Object> map);

	Map<String, Object> showInternalIssueReportJsp();

	boolean submitDispensaryForLp(Box box);
	Map<String, Object> getPrescriptionForPatientIssueList(Map<String, Object> dataMap);
	Map<String, Object> generateActualStockExcel(Map<String,Object> map);
	Map<String, Object> generateActualStockSactionExcel(Map<String,Object> map);
	List<StoreOpPatientIssueT> getDailyIssueSummery(Map<String,Object> map);

	Map<String, Object> showActualStockReportJsp();
	Map<String, Object> fillItemsInGridForDepartmentIndent(Map<String,Object> map);

	Map<String, Object> showSearchIndentToDepo(int deptId,int hospitalId);

	Map<String, Object> deleteGridItemsForIndentDepo(Box box);

	Map<String, Object> searchIndentDetails(Box box);

	Map<String, Object> insertIssueForIndent(Map<String, Object> utilMap,Box box);

	Map<String, Object> insertIssueForOtherUnits(Map<String, Object> utilMap,Box box);

	Map<String, Object> insertIssueForIndentwithoutbarcode(Map<String, Object> utilMap,Box box);

	//Dinesh
	public Map<String, Object> showAddDepartmentIndentJsp(Box box);
	public Map<String, Object> indentTrackingHistoryJsp(Map<String, Object> dataMap);
	public Map<String, Object> showWardPrescription(Map<String, Object> dataMap);
	public Map<String, Object> getItemListForIndent(Box box);
	public Map<String, Object> getOtherItemsForIndent(Box box);
	public Map<String, Object> getDataForBarcode(Box box);

	Map<String, Object> getDataForIssueBarcode(Box box);
	List<StoreOpPatientIssueM> printPatientIssue(int deptId,int hospitalId);
	Map<String, Object> generateActualStockDetailsExcel(Map<String,Object> map);
	boolean updateDefective(Box box);
	Map<String, Object> generateActualStockSactionDetailsExcel(Map<String,Object> map);
	Map<String, Object> printDispensaryReceiveItemReportExcel(Map<String,Object> map);
	boolean submitOPDPatientStockDetailsWithBarCode(Map map);
	//ASHUTOSH



	public Map<String, Object> getLpPrescriptionList(Map<String, Object> mapForDs);
	public Map<String, Object> getLpPrescriptionDetails(Map<String, Object>mapForDs);

	List<Object> getBatchNoList(String serviceNo,int hospitalId);
	String getBarCodeNumber(String motherHinNo,String serviceNo);
	Map<String, Object> reportPvms(Box box);
	Map<String, Object> reportMasterMedcine(Box box);
	Map<String, Object> reportStockStatus(Box box);
	Map<String, Object> reportStockBatch(Box box);
	Map<String, Object> reportStockReceipt(Box box);
	Map<String, Object> reportStockIssue(Box box);
	Map<String, Object> reportStockSurplus(Box box);
	Map<String, Object> reportStockDeficient(Box box);
	Map<String, Object> reportStockABC(Box box);
	Map<String, Object> reportStockVDU(Box box);




	Map<String, Object> checkCurrentBatchStock(Map<String, Object> dataMap);
	Map<String, Object> generateExcelForDepot(Map<String, Object> dataMap);

	boolean updateIssueToOtherUnit(Box box);
// javed khan
	Map<String, Object> getReceiptRegisterReport(
			Map<String, Object> requestParameters);

	Map<String, Object> getSurplusItem(Map<String, Object> requestParameters);

	Map<String, Object> getRecieveItem(Map<String, Object> parameters);

	Map<String, Object> getLocalRegisterReport(Map<String, Object> requestParameters);

	Map<String, Object> getActualStock(Map<String, Object> requestParameters);

	Map<String, Object> getActualStockSection(Map<String, Object> requestParameters);

	Map<String, Object> getDefectiveDrugsItem(Map<String, Object> requestParameters);

	Map<String, Object> getVEDItem(Map<String, Object> requestParameters);

	Map<String, Object> getFSNItem(Map<String, Object> requestParameters);

	Map<String, Object> getTurnOverDataInAjax(Map<String, Object> dataMap);

	Map<String, Object> getDailyIssueItem(Map<String, Object> requestParameters);

	Map<String, Object> getdrugStock(Map<String, Object> requestParameters);

	Map<String, Object> getSurplusMedicalStoreItem(Map<String, Object> datamap);

	boolean addDrugCost(Map<String, Object> infoMap, Map<String, Object> dataMap);

String getPVMS(String itemId);
	String getBrand(String brandId);
	String getSupplierId(String supplierNo);
	String getSupplierPenAmt(int supplierId,int hospitalId);
	List getPreId(String supplierNo);
	String getManu(String manuId);
	Map<String, Object> searchDrugCost(Map<String, Object> searchFieldMap);

	Map<String, Object> getExpiryDateForReturnDispensary(
			Map<String, Object> dataMap);

	Map<String, Object> createAndSaveMmfDepartmentData(Box box);

	Map<String, Object> getPendingForIndentData(Map<String, Object> dataMap);

	Map<String, Object> showLoanout(int deptId, int hospitalId); // javed khan

	String getHospitalAddress(int hospitalId);

	String consignerName(int supId, String jsp);

	Map<String, Object> getDepartmentList();

	Map<String, Object> showPrescriptionDetails(int precriptionId);

	Map<String, Object> showOPDPatientLoanOutIssueGrid(Map<String, Object> map);

	Map<String, Object> getItemListForTurnOverByAutocomplete(
			Map<String, Object> dataMap);

	List getSupplierName(int hospitalId);

	Map<String, Object> getUnit(Map<String, Object> dataMap);

	Map<String, Object> getAU();

	Map<String, Object> getDepartmentIssueData(Map datamap);
	Map<String, Object> showPendingDefectiveItemsJsp(Box box);
	Map<String, Object> submitPendingDefectiveItemsJsp(Box box);
	Map<String, Object> getPatientDetailsForPatientDirectPriscription(Map<String, Object> dataMap);
	Map<String, Object> showDirectPriscriptionJsp(Map<String, Object> dataMap);
	Map<String, Object> showIndentHistoryJsp(Map<String, Object> dataMap);
	Map<String, Object> waitingForRateContract(Map<String, Object> dataMap);
	Map<String, Object> showGrnJspForAFMSD(Box box,Map<String, Object> dataMap);
	Map<String, Object> submitDirectPatientIssue(Map mapForDS);
	boolean submitOPDPatientStockDetailsDirect(Map map);
	Map<String, Object> getIndentNo(Map<String, Object> dataMap);
	public boolean submitSampleTestingEntry(Map<String, Object> infoMap,Map<String, Object> dataMap) ;
	Map<String, Object> showSampleTestingEntryJsp(Map<String, Object> dataMap);
	Map<String, Object> submitFollowDetailsForSampleEntry(Box box);
	Map<String, Object> searchSampleTestingEntry(Map<String, Object> dataMap);
	List<StoreSampleTestingEntry> getSampleTestingEntry();
	Map getSampleTestEntryModifyMap(int id, int pageNo);
	boolean updateSampleTestingEntry(Box box);
	Map<String, Object> getMMFItem(Map<String, Object> dataMap);
	Map<String, Object> insertIssueForIndentupdate(Map<String, Object> utilMap,
			Box box);

				Map<String, Object> ExportExcelForPerformaB(Box box);

	//				Method written by Tirath

	Map<String, Object> showMedicineReturnJsp(Map<String, Object> dataMap);

	public boolean submitMedicineReturn(Map<String, Object> infoMap,
			Map<String, Object> dataMap);


	 // add javed for print issue to units from dispensary

	Map printIssueDispToUnits(int issueMId);

	Map<String, Object> insertIssueForIndentToUnit(Map<String, Object> utilMap,
			Box box);

	// add javed khan for  section in Auto Indent
	Map<String, Object> showSearchIndentToDepo1(
			Map<String, Object> requestParameters);

	// Added by Kiran for Department Allocation
	Map<String,Object> getSMCAndDept(Map<String,Object>dataMap);
	Map<String,Object> getAssignedDepartmentt(Map<String,Object>dataMap);
	public boolean AssignDepartmentForStoreFyDocument(Map<String, Object> dataMap);

	//Added by javed khan for Proforma B Approval

	Map<String, Object> showProformaBApproval(Map<String, Object> dataMap);
	Map<String, Object> showProformaBAccountApproval(Map<String, Object> dataMap);

	Map<String, Object> getPendingProformaForApproval(
			Map<String, Object> dataMap);

	Map<String, Object> getPendingProformaForApprovalAccount(
			Map<String, Object> dataMap);

	Map<String, Object> proformaBApproved(Map<String, Object> dataMap);

	Map<String, Object> showProformaBeforApproval(Box box);
	//Added by javed khan  for search indent
	Map<String, Object> newSearchIndent(Map<String, Object> searchFieldMap);

	Map getIndentModifyMapForDepot1(int radioStr, int pageNo, int deptId,
			int hospitalId);

	//Added by javed khan  for addExistingInsnet in dispensary
	Map<String, Object> getDepartmentExistingIndentData(Box box);

	Map<String, Object> doAddInternalIndentsubmit(Box box);
	Map<String, Object> doAddIndentsubmit(Box box);

	Map<String, Object> getDepartmentIndentSearchData(Box box);

	Map<String, Object> getStockQtyInAjax(Map<String, Object> dataMap);
	String getPVMS(int deptId, String nomenclature, int hospitalId);
	Map<String, Object> importNivMaster(Map<String, Object> utilMap);
	Map<String, Object> createPvmsItemExcelList(Box box);
	Map<String, Object> importPvmsMaster(Map<String, Object> utilMap);
	Map<String, Object> updateMmfDepartmentEntry(Box box);
	Map<String, Object> getItemDetailsToUpdate(Box box);
	Map<String, Object> updateBatchAndExpiryDate(Box box);
	Map<String, Object> getItemBatch(Box box);
	Map<String, Object> generateExcelForMmf(Box box);
	Map<String, Object> showProformaBEntryJsp(Map<String, Object> dataMap);
	Map<String,Object> getPvmsID(String pvmsNo);
	Map<String, Object> getDrugExpiryList(Box box);
	Map<String, Object> getItemTypeList(Box box);
	Map<String, Object> getSectionList(Box box);
	Map<String, Object> getCategoryList(Box box);
	List<StoreMaterialPurchaseReqM> getMPRNumberList(int deptId, int hospitalId);
	Map<String, Object> showMPRScreen(Map<String, Object> dataMap);
	Map<String, Object> addNextOrSubmitBalance(Map<String, Object> dataMap,Box box);
	Map<String, Object> rcReceive(Map<String, Object> dataMap,Box box);
	
	Map<String, Object> getItemTypeGLList(Map<String, Object> dataMap);
	Map<String, Object> getSectionGLList(Map<String, Object> dataMap);
	Map<String, Object> showNIS(Map<String, Object> dataMap);
	Map<String, Object> getCategoryGList(Box box);
	Map<String, Object> getDrugExpiryListReport(Box box);
	Map<String, Object> saveMPR(Box box);
	List<Object[]> getFinancialYearList();
	List<Object[]> getMPRPriorityList();
	Map<String, Object> getListOfMPR(Box box);
	Map<String, Object> getMPRDetails(int mprId);
	Map<String, Object> updateSavedMPR(Box box);
	Map<String, Object> DeleteFromDatabase_AddRemoveGrid(Box box);
	Map<String, Object> showVendorReturnRptJsp();
	Map<String, Object> showDepartmentReturnRegJsp(int hospitalId);
	Map<String, Object> showVendorReturnRegJsp(int hospitalId);
	Map<String, Object> dailyIssueSummryReport();
	Map<String, Object> showRCPrintJsp(int hospitalId);
	Map<String, Object> showRequestForQuotationJsp(Map<String, Object> dataMap);
	Map<String, Object> getMPRListListbasedonYear(Box box);
	Map<String, Object> getMPRDetailsforQuotation(Box box);
	Map<String, Object> saveEnquiryforQuotation(Box box);
	Map<String, Object> getListOfEnquiry(Box box);
	Map<String, Object> getVendorQuotationDetails(int headerId);
	Map<String, Object> getEnquiryListListbasedonYear(Box box);
	Map<String, Object> getQuotationDetailsforPO(Box box);
	Map<String, Object> savePO(Box box);
	Map<String, Object> getListOfPO(Box box);
	Map<String, Object> getPODetails(int headerId);
	Map<String, Object> submitIPPartialPatientStockDetails(Map map);
	Map<String, Object> getPOListbasedonYear(Box box);
	Map<String, Object> getPODetailsforChallanEntry(Box box);
	List<Object[]> getEmployeeListForDepartment(Box box);
	Map<String, Object> submitRREntry(Box box);
	Map<String, Object> submitRCWaitingList(Box box);
	Map getReceiveRCWaitingList(Box box);
	Map<String, Object> getItemRCList(Box box);
	Map<String, Object> submitRCEntry(Box box);
	Map<String, Object> GetMPRAndPODetailsOfItem(Box box);
	Map<String, Object> showRCReportJsp(int hospitalId, int deptId);
	Map<String, Object> getRRList(Map<String, Object> dataMap);
	Map<String, Object> getPOList(Map<String, Object> dataMap);
	Map<String, Object> getPOYear(Box box);
	Map<String, Object> submitIndentForSupplier(Box box);
	Map<String, Object> getListOfSupplierIndent(Box box);
	Map<String, Object> getSupplierIndentDetails(int headerId);
	Map<String, Object> getRRListForInspection(Box box);
	Map<String, Object> getRRDetailsforInspection(int headerId);
	Map<String, Object> submitRRInspectionDetails(Box box);
	Map<String, Object> submitRRApprovalDetails(Box box);
	Map<String, Object> getSupplierIndentListbasedonPO(Box box);
	Map<String, Object> fillItemsForUnsedMedicine(Box box);
	Map<String, Object> getPatientDetailsForPrescriptionByHin(int hinId);
	Map<String, Object> showOPDPatientIssueGridByHin(Map map);
	Map<String, Object> submitOPDPatientStockDetailsByHin(Map map);
	Map<String, Object> fillItemsForIndent(Map<String, Object> dataMap);
	Map<String, Object> showOPDPatientNIPApprovalGrid(Map map);
	Map<String, Object> getPatientDetailsForNIP(int hinId);
	/*Map<String, Object> showOPDPatientNIPIssue(int hinId);*/
	Map<String, Object> submitOPDPatientNIPDetails(Box box);
	Map<String, Object> addStockofReturnedMedicine(Box box);
	Map<String, Object> getListOfUnusedMedicine(Box box);
	Map<String, Object> getStockDetailsforMR(Box box);
	Map<String, Object> showIPDPatientIssueGridPatientWise(Map map);
	Map<String, Object> saveMR(Box box);
	Map<String, Object> getListOfMR(Box box);
	
	Map<String, Object> getMRDetails(int mrId);
	Map<String, Object> updateSavedMR(Box box);
	Map<String, Object> submitApprovalDetailsofMR(Box box);
	
	Map<String, Object> getListOfPendingForReceivingExpiredDrugs(Box box);
	Map<String, Object> getReturnDetailsofExpiredDrugs(int returnHeaderId);
	
	Map<String, Object> saveStockofReturnDrugs(Box box);
	Map<String, Object> getListofReceivedExpiredDrugs(Box box);
	Map<String, Object> saveRC(Box box);
	Map<String, Object> getRCDetails(int requestHeaderId);
	Map<String, Object> getListOfRC(Box box);
	Map<String, Object> submitApprovalDetailsofRC(Box box);
	Map<String, Object> updateSavedRC(Box box);
	Map<String, Object> rcToVendor(Map<String, Object> dataMap);
	Map<String, Object> getDemandListForRC(Map dataMap);
	Map<String, Object> getRCRequestDetails(Box box);
	Map<String, Object> getListOfReceiveRC(Box box);
	Map<String, Object> insertIssueForIndentwithoutbarcodeForRC(
			Map<String, Object> utilMap, Box box);
	Map<String, Object> showAckJspForRC(int deptId, int hospitalId);
	Map<String, Object> doAddAckItemsForRC(Box box);
	Map<String, Object> getPendingListofActionofDrugDisposal(Box box);
	Map<String, Object> submitActionDetailsofDrugsDisposal(Box box);
	Map<String, Object> showOPDPatientIssueFAC(Map map);
	Map<String, Object> getPatientDetailsForPrescriptionFAC(int prescriptionId);
	Map<String, Object> showOPDPatientIssueGridFAC(Map map);
	Map<String, Object> submitOPDPatientStockDetailsFAC(Map map);
	Map<String, Object> showPhysicalStockJsp(Box box);
	Map<String, Object> submitPhysicalStockTaking(Box box);
	Map<String, Object> showIssueMedicineReportJsp();
	Map<String, Object> getListOfReceiveMR(Box box);
	Map<String, Object> getIndentDetailsforChallanEntry(Box box);
	Map<String, Object> getPendingListforApprovalofStockTacking(Box box);
	Map<String, Object> getStockTakingDetails(int stockTakingHeaderId);
	Map<String, Object> updateStockTaking(Box box);
	Map<String, Object> getPatientDetailsForPrescriptionPartial(int wardId);
	Map<String, Object> showOPDPatientIssueGridPartial(Map map);
	Map<String, Object> submitIPPatientStockDetailsPartial(Box box);
	Map<String, Object> getVendorDetailsforPO(Box box);
	Map<String, Object> getVendorList(Map<String, Object> dataMap);
	Map<String, Object> getVendorName(Map<String, Object> requestParameters);
	int getPrintCount(String column_name, String din_no);
	void updatePrintCount(String column_name, String din_no);
	Map<String, Object> showOPDPatientIssueGridForMIssue(Map map);
	Map<String, Object> saveMRMIssue(Box box);
	Map showIssueDispensaryJspPartial(Map<String, Object> dataMap);
	Map<String, Object> getListOfReceiveMRPartial(Box box);
	Map<String, Object> getDemandListPartial(Map dataMap);
	Map<String, Object> getDataForBarcodeDispensary(Box box);
	Map<String, Object> insertIssueForIndentwithoutbarcodeWP(
			Map<String, Object> utilMap, Box box);
	Map<String, Object> getListOfReceiveMRForWard(Box box);
	Map<String, Object> getDataForBarBatchStockId(Box box);
	Map<String, Object> searchIndentDetailswithBatchId(Box box);
	Map<String, Object> getListOfMRWard(Box box);
	Map<String, Object> updateSavedMRWard(Box box);
	Map<String, Object> getListOfRCCDS(Box box);
	Map<String, Object> updateSavedRCCDS(Box box);
	Map<String, Object> showLabRequestWardWise(int hospitalId);
	Map<String, Object> getStockDetailsForDepartment(Box box);
	Map<String, Object> rcListSubmitUntilReceive(Box box);
	Map<String, Object> viewUpdateRCSubmitUntilReceive(Box box);
	Map<String, Object> rcListToVendorSubmitUntilReceive(Box box);
	Map<String, Object> getRCDetailsSubmitUntilReceive(int requestHeaderId);
	Map<String, Object> DeleteFromDatabase_AddRemoveGridRC(Box box);
	Map<String, Object> getMedicineIssueAndReceiveDetails(Box box);
	Map<String, Object> fillItemsForDrugDisposal(Map<String, Object> dataMap);

}