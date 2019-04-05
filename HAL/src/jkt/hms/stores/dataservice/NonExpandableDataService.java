package jkt.hms.stores.dataservice;

import java.util.List;

import java.util.Map;

import javax.transaction.SystemException;

import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreIndentSocTracker;
import jkt.hms.util.Box;



public interface NonExpandableDataService {
	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By
	// Vivek------------------------------------------
	// ****************************************************************************************************************

	// ---------Indent To Depot------------------
	Map<String, Object> getItemListForIndentToDepot(Map<String, Object> dataMap);

	Map<String, Object> fillItemsForIndentToDepot(Map<String, Object> dataMap);

	Map<String, Object> getItemListForMMFIndentModify(
			Map<String, Object> dataMap);

	Map<String, Object> fillItemsCommon(Map<String, Object> dataMap);

	Map<String, Object> showIndentJspDepot(Map<String, Object> dataMap);

	Map<String, Object> addNextOrSubmitIndentToDepot(Map<String, Object> dataMap);

	Map<String, Object> getIndentModifyMapForDepot(int indentId, int pageNo);

	boolean updateNextIndentToDepot(Map<String, Object> masterAndDetailMap);

	// ---------End of Indent To Depot------------------
	// ---------Indent To SOC ------------------

	Map NextOrSubmit(Map<String, Object> dataMap)
			throws java.text.ParseException;

	Map searchIndentSOC(Map<String, Object> dataMap);

	Map<String, Object> chackForItemExistence(Map<String, Object> dataMap);

	Map<String, Object> getItemListForIndentToSOC(Map<String, Object> dataMap);

	Map<String, Object> showIndentJspSOC(Map<String, Object> dataMap);

	Map<String, Object> addNextOrSubmitIndentToSOC(Map<String, Object> dataMap)
			throws java.text.ParseException;

	Map<String, Object> getIndentModifyMapForSOC(int indentId, int pageNo);

	boolean updateNextIndentToSOC(Map<String, Object> masterAndDetailMap);

	Map getBrandListForSOC(int itemId);

	Map getBrandListForSOC(int itemId, int detailId);

	Map<String, Object> fillItemsForIndentToSOC(Map<String, Object> dataMap);

	Map<String, Object> getManufacturerNameInAjax(Map<String, Object> dataMap);

	// ---------End of Indent To SOC------------------

	// ------------------------------------Start of MMF
	// Indent-----------------------------------------------------------

	Map<String, Object> getItemListForMMFIndent(Map<String, Object> dataMap);

	Map showIndent();

	Map searchIndent(Map searchFieldMap);

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

	Map<String, Object> getBrandMap(Map<String, Object> dataMap)
			throws java.text.ParseException;

	boolean addBrandDetails(Map<String, Object> dataMap);

	int getIssueId(String issueNo);

	Map<String, Object> getAdjustLoanOutMap(Map<String, Object> dataMap);

	Map<String, Object> showPrintIssueToDispensary();

	Map<String, Object> getIssuePrintMap(int issue_m_id);

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

	// ----------------------------End Of Issues To Other Than Airforce Units
	// ----------------------

	// ----------------------------Start Of Vendor Return ----------------------

	Map<String, Object> fillItemsForIndentToVendorReturn(
			Map<String, Object> dataMap);

	Map<String, Object> getItemListForVendorReturn(Map<String, Object> dataMap);

	Map<String, Object> showVendorReturnJsp(Map<String, Object> map);

	Map<String, Object> showStockDetailsForVendorReturn(Map<String, Object> map);

	boolean submitVendorReturnDetails(Map<String, Object> map);

	Map<String, Object> showDeleteVendorReturn(Map<String, Object> map);

	boolean deleteStockDetailsVendorReturn(Map<String, Object> map);

	Map<String, Object> searchVendorReturn(Map<String, Object> searchFieldMap);

	// ----------------------------End Of Vendor Return ----------------------

	// ----------------------------Start Of Department Issue
	// ----------------------

	Map<String, Object> addNextOrSubmitIssue(Map<String, Object> dataMap);
	Map<String, Object> updateNextOrSubmitIssue(Map<String, Object> dataMap);

	Map<String, Object> getItemListForDepartmentIssueNE(
			Map<String, Object> dataMap);

	// ----------------------------End Of Department Issue
	// ----------------------

	// -------------------------Start of Disposal Entry <= Rs
	// 30------------------------------------------

	Map<String, Object> showDisposalEntry(Map<String, Object> dataMap);

	Map<String, Object> importFromBOS(Map<String, Object> dataMap);

	Map<String, Object> generateCiv(Map<String, Object> dataMap);

	Map<String, Object> generateIndent(Map<String, Object> dataMap);

	Map<String, Object> updateDisposalEntry(Box box);

	Map<String, Object> saveHeaderForIndent(Box box);

	Map<String, Object> getIndentMapForDisposal(int indentId, int pageNo);

	Map<String, Object> getDisposalData(Map<String, Object> dataMap);

	Map<String, Object> getIssueDisposalData(Map<String, Object> dataMap);

	Map<String, Object> updateIssueForDisposalEntry(Box box);

	Map<String, Object> importFromBOS2(Map<String, Object> dataMap);

	Map<String, Object> updateDisposalEntry2(Box box);

	// -------------------------End of Disposal Entry <= Rs
	// 30------------------------------------------
	// *********************************************************************************************************************
	// ------------------------------------End of Methods Written By
	// Vivek------------------------------------------
	// ****************************************************************************************************************
	// *********************************************************************************************************************

	// ****************************************************************************************************************
	// ------------------------------------------Start report by
	// Mansi----------------------------------------------//
	// ****************************************************************************************************************

	Map<String, Object> getConnectionForReport();

	String getHospitalName(int hospitalId);

	Map<String, Object> showAMCRegisterJsp();

	// ****************************************************************************************************************
	// ------------------------------------------End report by
	// Mansi----------------------------------------------//
	// ****************************************************************************************************************

	// =============== method by abha =====================
	Map<String, Object> showImportedReportJsp();

	Map<String, Object> getItemListForImportedItemByAutocomplete(
			Map<String, Object> dataMap);
	//                       Method For ItemList For MeScale By Tirath            //
	
	Map<String, Object> getItemListForMeScale(Map<String, Object> dataMap);
	Map<String, Object> fillItemsForMeScale(Map<String, Object> dataMap);
	
	Map<String, Object> showLoanOutJsp(Map<String, Object> dataMap);
	Map<String, Object> getStock(Map<String, Object> dataMap);
	Map<String, Object> submitLoanOutForNe(Map<String, Object> dataMap);
	Map<String, Object> showSearchIndentToDepo(Map<String, Object> dataMap);
	Map<String,Object> getItemListForDefectiveDrugsByAutocomplete(Map<String,Object> dataMap);
}
