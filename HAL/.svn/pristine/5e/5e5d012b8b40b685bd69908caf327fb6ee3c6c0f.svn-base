package jkt.hms.stores.handler;

import java.util.List;

import java.util.Map;

import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreIndentSocTracker;
import jkt.hms.stores.dataservice.NonExpandableDataService;
import jkt.hms.util.Box;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class NonExpandableHandlerServiceImpl implements
		NonExpandableHandlerService {

	/*
	 * Instance variables
	 */

	NonExpandableDataService nonExpandableDataService = null;

	// Common methods for NonExpandableController
	public NonExpandableDataService getNonExpandableDataService() {
		return nonExpandableDataService;
	}

	public void setNonExpandableDataService(
			NonExpandableDataService nonExpandableDataService) {
		this.nonExpandableDataService = nonExpandableDataService;
	}

	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By
	// Vivek------------------------------------------
	// ****************************************************************************************************************

	// ------------------------------Indent----------------------------

	public Map<String, Object> getItemListForMMFIndentModify(
			Map<String, Object> dataMap) {

		return nonExpandableDataService.getItemListForMMFIndentModify(dataMap);
	}

	public Map<String, Object> fillItemsCommon(Map<String, Object> dataMap) {
		return nonExpandableDataService.fillItemsCommon(dataMap);
	}

	public Map<String, Object> getItemListForMMFIndent(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.getItemListForMMFIndent(dataMap);
	}

	public Map<String, Object> checkYearExists(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.checkYearExists(dataMap);
	}

	public Map getIndentModifyMapForDepot(int radio_str, int pageNo) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.getIndentModifyMapForDepot(radio_str,
				pageNo);
	}

	public Map<String, Object> lockMMFIndent(int year) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.lockMMFIndent(year);
	}

	public Map<String, Object> showLockMMFIndent() {
		return nonExpandableDataService.showLockMMFIndent();
	}

	public Map<String, Object> showImportMMFIndentJsp(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.showImportMMFIndentJsp(dataMap);
	}

	// public Map getIndentDepotPrintMap(int indentId) {
	// // TODO Auto-generated method stub
	// //return nonExpandableDataService.getIndentDepotPrintMap(indentId);
	// }
	public Map getIndentModifyMap(int radio_str, int pageNo) {

		return nonExpandableDataService.getIndentModifyMap(radio_str, pageNo);
	}

	public Map<String, Object> importMMFIndent(Map<String, Object> dataMap)
			throws java.text.ParseException {
		return nonExpandableDataService.importMMFIndent(dataMap);
	}

	public boolean addNextOrSubmitIndentToMMF(StoreIndentM storeIndentM,
			List list, Map<String, Object> map) {
		return nonExpandableDataService.addNextOrSubmitIndentToMMF(
				storeIndentM, list, map);
	}

	@SuppressWarnings("unchecked")
	public Map showIndent() {
		return nonExpandableDataService.showIndent();
	}

	public Map getIndentMAndTUpdate(int indentId) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.getIndentMAndTUpdate(indentId);
	}

	public Map<String, Object> searchIndent(Map<String, Object> searchFieldMap){
		return nonExpandableDataService.searchIndent(searchFieldMap);
	}

	public StoreIndentM getStoresIndentMObject(int indentId) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.getStoresIndentMObject(indentId);
	}

	public int getIndentId(int indentNo) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.getIndentId(indentNo);
	}

	@SuppressWarnings("unchecked")
	public Map getIndentMAndT(int indentId) {
		return nonExpandableDataService.getIndentMAndT(indentId);
	}

	public boolean updateIndent(StoreIndentM storeIndentTlist, List list) {
		return nonExpandableDataService.updateIndent(storeIndentTlist, list);
	}

	public boolean updateNextIndent(Map<String, Object> masterAndDetailMap)
			throws java.text.ParseException {
		return nonExpandableDataService.updateNextIndent(masterAndDetailMap);
	}

	public Map<String, Object> checkExistenceOfCuurentYearIndent(int year) {

		return nonExpandableDataService.checkExistenceOfCuurentYearIndent(year);
	}

	public boolean updateIndent(StoreIndentM storeIndentTlist) {
		// TODO Auto-generated method stub
		return false;
	}

	// ---------------------End Of MMF Indent------------

	// --------------Indent To Depot ----------------
	public Map<String, Object> getItemListForIndentToDepot(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.getItemListForIndentToDepot(dataMap);
	}

	public Map<String, Object> fillItemsForIndentToDepot(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.fillItemsForIndentToDepot(dataMap);
	}

	public Map<String, Object> addNextOrSubmitIndentToDepot(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.addNextOrSubmitIndentToDepot(dataMap);
	}

	public boolean updateNextIndentToDepot(
			Map<String, Object> masterAndDetailMap) {
		return nonExpandableDataService
				.updateNextIndentToDepot(masterAndDetailMap);
	}

	public Map<String, Object> showIndentJspDepot(Map<String, Object> dataMap) {
		return nonExpandableDataService.showIndentJspDepot(dataMap);
	}

	// ---------------------End Of Indent To Depot---------------

	// --------------Indent To SOC ----------------
	public Map NextOrSubmit(Map<String, Object> dataMap)
			throws java.text.ParseException {
		return nonExpandableDataService.NextOrSubmit(dataMap);
	}

	public Map searchIndentSOC(Map<String, Object> dataMap) {
		return nonExpandableDataService.searchIndentSOC(dataMap);
	}

	public Map<String, Object> chackForItemExistence(Map<String, Object> dataMap) {
		return nonExpandableDataService.chackForItemExistence(dataMap);
	}

	public Map<String, Object> showIndentJspSOC(Map<String, Object> dataMap) {
		return nonExpandableDataService.showIndentJspSOC(dataMap);
	}

	public Map<String, Object> addNextOrSubmitIndentToSOC(
			Map<String, Object> dataMap) throws java.text.ParseException {
		return nonExpandableDataService.addNextOrSubmitIndentToSOC(dataMap);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getIndentModifyMapForSOC(int indentId, int pageNo) {
		return nonExpandableDataService.getIndentModifyMapForSOC(indentId,
				pageNo);
	}

	public boolean updateNextIndentToSOC(Map<String, Object> masterAndDetailMap) {
		return nonExpandableDataService
				.updateNextIndentToSOC(masterAndDetailMap);
	}

	public Map getBrandListForSOC(int itemId) {
		return nonExpandableDataService.getBrandListForSOC(itemId);
	}

	public Map getBrandListForSOC(int itemId, int detailId) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.getBrandListForSOC(itemId, detailId);
	}

	public Map<String, Object> fillItemsForIndentToSOC(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.fillItemsForIndentToSOC(dataMap);
	}

	public Map<String, Object> getManufacturerNameInAjax(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.getManufacturerNameInAjax(dataMap);
	}

	public Map<String, Object> getItemListForIndentToSOC(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.getItemListForIndentToSOC(dataMap);
	}

	// --------------End of Indent To SOC ----------------

	// -------------------------------------- Start of Indent Soc Tracker
	// ------------------------------------------

	public Map<String, Object> showIndentSocTracker() {
		return nonExpandableDataService.showIndentSocTracker();
	}

	public Map<String, Object> getIndentSocTracker(Map<String, Object> idsMap) {
		return nonExpandableDataService.getIndentSocTracker(idsMap);
	}

	public boolean addOrUpdateIndentSocTracker(
			StoreIndentSocTracker indentSocTracker, int indentSocTrackerId) {

		return nonExpandableDataService.addOrUpdateIndentSocTracker(
				indentSocTracker, indentSocTrackerId);
	}

	public Map<String, Object> getItemMapForAutoComplete() {
		//System.out.println("This is getItemMapForAutoComplete in Handler");
		return nonExpandableDataService.getItemMapForAutoComplete();
	}

	public Map<String, Object> adjustLoanIn() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getIndentListForSocTracker(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.getIndentListForSocTracker(dataMap);
	}

	public Map<String, Object> getItemListForSocTracker(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.getItemListForSocTracker(dataMap);
	}

	// -------------------------------------- End of Indent Soc Tracker
	// ------------------------------------------

	// ----------------------------Start Of Issues To Dispensary (CIV)
	// ----------------------

	public Map<String, Object> getIssueDetailPageByPage(
			Map<String, Object> pageMap) {

		return nonExpandableDataService.getIssueDetailPageByPage(pageMap);
	}

	public Map openDeletePopupForIssueciv(Map<String, Object> dataMap) {

		return nonExpandableDataService.openDeletePopupForIssueciv(dataMap);
	}

	public Map showDeleteIsuueCiv(Box box) {

		return nonExpandableDataService.showDeleteIsuueCiv(box);

	}

	public Map deleteIssueCivItems(Box box) {
		return nonExpandableDataService.deleteIssueCivItems(box);
	}

	public Map searchIssueCiv(Box box) {
		return nonExpandableDataService.searchIssueCiv(box);
	}

	public List<MasStoreItem> getItemList() {
		return nonExpandableDataService.getItemList();
	}

	public Map<String, Object> getDemandList(Map dataMap) {
		return nonExpandableDataService.getDemandList(dataMap);
	}

	public Map<String, Object> adjustLoanOut(Map<String, Object> dataMap) {
		return nonExpandableDataService.adjustLoanOut(dataMap);
	}

	public Map showIssueDispensaryJsp(Map<String, Object> dataMap) {
		return nonExpandableDataService.showIssueDispensaryJsp(dataMap);
	}

	public Map getBrandMap(Map<String, Object> dataMap)
			throws java.text.ParseException {
		return nonExpandableDataService.getBrandMap(dataMap);
	}

	@SuppressWarnings("unchecked")
	public boolean addBrandDetails(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.addBrandDetails(dataMap);
	}

	public int getIssueId(String issueNo) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.getIssueId(issueNo);
	}

	public Map<String, Object> getAdjustLoanOutMap(Map<String, Object> dataMap) {

		return nonExpandableDataService.getAdjustLoanOutMap(dataMap);
	}

	public Map<String, Object> getIndentSocPrintMap(int indentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showPrintIndentDepotJsp() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showPrintIssueToDispensary() {
		// TODO Auto-generated method stub
		return nonExpandableDataService.showPrintIssueToDispensary();
	}

	public Map<String, Object> getIssuePrintMap(int issue_m_id) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.getIssuePrintMap(issue_m_id);
	}

	public Map<String, Object> getItemListForIssueToDispensary(
			Map<String, Object> dataMap) {
		return nonExpandableDataService
				.getItemListForIssueToDispensary(dataMap);
	}

	public Map<String, Object> fillItemsForIssueToDispensary(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.fillItemsForIssueToDispensary(dataMap);
	}

	// ----------------------------End Of Issues To Dispensary (CIV)
	// ----------------------

	// ----------------------------Start Of Issues To Dispensary Loan Out
	// ----------------------
	public Map addBrandDetailsForLoanOut(Box box)
			throws java.text.ParseException {
		return nonExpandableDataService.addBrandDetailsForLoanOut(box);
	}

	public Map<String, Object> openDeletePopupForIssueLoanOut(Map dataMap) {
		return nonExpandableDataService.openDeletePopupForIssueLoanOut(dataMap);
	}

	public Map showDeleteIsuueLoanout(Box box) {
		return nonExpandableDataService.showDeleteIsuueLoanout(box);
	}

	public Map deleteIssueLoanoutItems(Box box) {
		return nonExpandableDataService.deleteIssueLoanoutItems(box);
	}

	public Map<String, Object> searchInternalIndentDetails(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.searchInternalIndentDetails(dataMap);
	}

	public Map showIssueDispensaryManualJsp(Map<String, Object> dataMap) {
		return nonExpandableDataService.showIssueDispensaryManualJsp(dataMap);
	}

	public Map searchIssueLoanout(Box box) {
		return nonExpandableDataService.searchIssueLoanout(box);
	}

	public Map<String, Object> getItemListForLoanoutByAutocomplete(
			Map<String, Object> dataMap) {
		return nonExpandableDataService
				.getItemListForLoanoutByAutocomplete(dataMap);
	}

	// ----------------------------End Of Issues To Dispensary Loan Out
	// ----------------------

	// ----------------------------Start Of Issues To Other Units on Surplus
	// (CIV) ----------------------
	public Map addBrandDetailsToOtherUnits(Box box)
			throws java.text.ParseException {
		return nonExpandableDataService.addBrandDetailsToOtherUnits(box);
	}

	public Map<String, Object> openDeletePopupForIssueToOtherUnits(Map dataMap) {
		return nonExpandableDataService
				.openDeletePopupForIssueToOtherUnits(dataMap);
	}

	public Map showDeleteIsuueToOtherUnits(Box box) {
		return nonExpandableDataService.showDeleteIsuueToOtherUnits(box);
	}

	public Map deleteIssueToOtherUnitsItems(Box box) {
		return nonExpandableDataService.deleteIssueToOtherUnitsItems(box);
	}

	public Map showIssueToOtherUnitsJsp(Map<String, Object> dataMap) {
		return nonExpandableDataService.showIssueToOtherUnitsJsp(dataMap);
	}

	public Map searchIssueToOtherUnits(Box box) {
		return nonExpandableDataService.searchIssueToOtherUnits(box);
	}

	public Map<String, Object> getItemListThroughAjax(
			Map<String, Object> dataMap) {

		return nonExpandableDataService.getItemListThroughAjax(dataMap);
	}

	public Map<String, Object> fillItemsForIssueToDepot(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.fillItemsForIssueToDepot(dataMap);
	}

	// ----------------------------End Of Issues To Other Units on Surplus (CIV)
	// ----------------------

	// ----------------------------Start Of Issues To Other Than Airforce Units
	// ----------------------
	public Map addBrandDetailsToOTAFU(Box box) throws java.text.ParseException {
		return nonExpandableDataService.addBrandDetailsToOTAFU(box);
	}

	public Map<String, Object> openDeletePopupForIssueToOTAFU(Map dataMap) {
		return nonExpandableDataService.openDeletePopupForIssueToOTAFU(dataMap);
	}

	public Map showDeleteIsuueToOTAFU(Box box) {
		return nonExpandableDataService.showDeleteIsuueToOTAFU(box);
	}

	public Map deleteIssueToOTAFU(Box box) {
		return nonExpandableDataService.deleteIssueToOTAFU(box);
	}

	public Map showIssueToOTAFUJsp(Map<String, Object> dataMap) {
		return nonExpandableDataService.showIssueToOTAFUJsp(dataMap);
	}

	public Map searchIssueToOTAFU(Box box) {
		return nonExpandableDataService.searchIssueToOTAFU(box);
	}

	public Map<String, Object> getItemListThroughAjaxToOTAFU(
			Map<String, Object> dataMap) {

		return nonExpandableDataService.getItemListThroughAjaxToOTAFU(dataMap);
	}

	public Map<String, Object> fillItemsForIssueToOTAFU(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.fillItemsForIssueToOTAFU(dataMap);
	}

	public Map<String, Object> getIndentDepotPrintMap(int indentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getItemListForIssueToOTAFU(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.getItemListForIssueToOTAFU(dataMap);
	}

	// ----------------------------End Of Issues To Other Than Airforce Units
	// ----------------------

	// -------------------------------Vendor Return
	// ------------------------------

	public Map<String, Object> fillItemsForIndentToVendorReturn(
			Map<String, Object> dataMap) {
		return nonExpandableDataService
				.fillItemsForIndentToVendorReturn(dataMap);
	}

	public Map<String, Object> getItemListForVendorReturn(
			Map<String, Object> dataMap) {
		return nonExpandableDataService.getItemListForVendorReturn(dataMap);
	}

	public Map<String, Object> showVendorReturnJsp(Map<String, Object> map) {
		return nonExpandableDataService.showVendorReturnJsp(map);
	}

	public Map<String, Object> showStockDetailsForVendorReturn(
			Map<String, Object> map) {
		return nonExpandableDataService.showStockDetailsForVendorReturn(map);
	}

	public boolean submitVendorReturnDetails(Map<String, Object> map) {
		return nonExpandableDataService.submitVendorReturnDetails(map);
	}

	public Map<String, Object> showDeleteVendorReturn(Map<String, Object> map) {
		return nonExpandableDataService.showDeleteVendorReturn(map);
	}

	public boolean deleteStockDetailsVendorReturn(Map<String, Object> map) {
		return nonExpandableDataService.deleteStockDetailsVendorReturn(map);
	}

	public Map<String, Object> searchVendorReturn(
			Map<String, Object> searchFieldMap) {
		return nonExpandableDataService.searchVendorReturn(searchFieldMap);
	}

	// ----------------------------Start Of Department Issue
	// ----------------------

	public Map<String, Object> addNextOrSubmitIssue(Map<String, Object> dataMap) {
		return nonExpandableDataService.addNextOrSubmitIssue(dataMap);
	}
	
	public Map<String, Object> updateNextOrSubmitIssue(Map<String, Object> dataMap) {
		return nonExpandableDataService.updateNextOrSubmitIssue(dataMap);
	}

	public Map<String, Object> getItemListForDepartmentIssueNE(
			Map<String, Object> dataMap) {
		return nonExpandableDataService
				.getItemListForDepartmentIssueNE(dataMap);
	}

	// ----------------------------End Of Department Issue
	// ----------------------

	// -------------------------Start of Disposal Entry <= Rs
	// 30------------------------------------------

	public Map<String, Object> showDisposalEntry(Map<String, Object> dataMap) {
		return nonExpandableDataService.showDisposalEntry(dataMap);
	}

	public Map<String, Object> importFromBOS(Map<String, Object> dataMap) {
		return nonExpandableDataService.importFromBOS(dataMap);
	}

	public Map<String, Object> generateCiv(Map<String, Object> dataMap) {
		return nonExpandableDataService.generateCiv(dataMap);
	}

	public Map<String, Object> generateIndent(Map<String, Object> dataMap) {
		return nonExpandableDataService.generateIndent(dataMap);
	}

	public Map<String, Object> updateDisposalEntry(Box box) {
		return nonExpandableDataService.updateDisposalEntry(box);
	}

	public Map<String, Object> saveHeaderForIndent(Box box) {
		return nonExpandableDataService.saveHeaderForIndent(box);

	}

	public Map<String, Object> getIndentMapForDisposal(int indentId, int pageNo) {
		return nonExpandableDataService.getIndentMapForDisposal(indentId,
				pageNo);
	}

	public Map<String, Object> getDisposalData(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.getDisposalData(dataMap);
	}

	public Map<String, Object> getIssueDisposalData(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.getIssueDisposalData(dataMap);
	}

	public Map<String, Object> updateIssueForDisposalEntry(Box box) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.updateIssueForDisposalEntry(box);
	}

	public Map<String, Object> importFromBOS2(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.importFromBOS2(dataMap);
	}

	public Map<String, Object> updateDisposalEntry2(Box box) {
		// TODO Auto-generated method stub
		return nonExpandableDataService.updateDisposalEntry2(box);
	}

	// -------------------------End of Disposal Entry <= Rs
	// 30------------------------------------------
	// *********************************************************************************************************************
	// ------------------------------------End of Methods Written By
	// Vivek----------------------------------------------
	// *****************************************************************************************************************

	// ****************************************************************************************************************
	// ------------------------------------------Start report by
	// Mansi----------------------------------------------//
	// ****************************************************************************************************************

	public Map<String, Object> getConnectionForReport() {
		return nonExpandableDataService.getConnectionForReport();
	}

	public String getHospitalName(int hospitalId) {

		return nonExpandableDataService.getHospitalName(hospitalId);

	}

	public Map<String, Object> showAMCRegisterJsp() {
		return nonExpandableDataService.showAMCRegisterJsp();
	}

	// ****************************************************************************************************************
	// ------------------------------------------End report by
	// Mansi----------------------------------------------//
	// ****************************************************************************************************************
	public Map<String, Object> getItemListForImportedItemByAutocomplete(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpandableDataService
				.getItemListForImportedItemByAutocomplete(dataMap);
	}

	public Map<String, Object> showImportedReportJsp() {
		// TODO Auto-generated method stub
		return nonExpandableDataService.showImportedReportJsp();
	}
	
	public Map<String, Object> getItemListForMeScale(Map<String, Object> dataMap)
	{
		return nonExpandableDataService.getItemListForMeScale(dataMap);
	}
	public Map<String, Object> fillItemsForMeScale(Map<String, Object> dataMap)
	{
		return nonExpandableDataService.fillItemsForMeScale(dataMap);
	}
	
	public Map<String, Object> showLoanOutJsp(Map<String, Object> dataMap)
	{
		return nonExpandableDataService.showLoanOutJsp(dataMap);
	}
	
	public Map<String, Object> getStock(Map<String, Object> dataMap)
	{
		return nonExpandableDataService.getStock(dataMap);
	}
	
	public Map<String, Object> submitLoanOutForNe(Map<String, Object> dataMap)
	{
		return nonExpandableDataService.submitLoanOutForNe(dataMap);
	}
	
	public Map<String, Object> showSearchIndentToDepo(Map<String, Object> dataMap)
	{
		return nonExpandableDataService.showSearchIndentToDepo(dataMap);
	}
	public Map<String,Object> getItemListForDefectiveDrugsByAutocomplete(Map<String,Object> dataMap)
	   {
		return nonExpandableDataService.getItemListForDefectiveDrugsByAutocomplete(dataMap);
	   }
	}