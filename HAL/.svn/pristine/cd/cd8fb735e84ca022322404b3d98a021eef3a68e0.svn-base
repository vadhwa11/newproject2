package jkt.hms.stores.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;

import org.springframework.web.servlet.ModelAndView;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;






























import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.StoreAdjustmentM;
import jkt.hms.masters.business.StoreAdjustmentT;
import jkt.hms.masters.business.StoreBalanceM;
import jkt.hms.masters.business.StoreBalanceT;
import jkt.hms.masters.business.StoreBoo;
import jkt.hms.masters.business.StoreDefectiveDrugM;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnReturnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreIndentSocTracker;
import jkt.hms.masters.business.StoreInternalIndentM;
import jkt.hms.masters.business.StoreInternalIndentT;
import jkt.hms.masters.business.StoreIssueM;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StoreLoaninM;
import jkt.hms.masters.business.StoreLoaninT;
import jkt.hms.masters.business.StoreMaterialPurchaseReqM;
import jkt.hms.masters.business.StoreMmfDepartmentM;
import jkt.hms.masters.business.StoreMmfDepartmentT;
import jkt.hms.masters.business.StoreOpPatientIssueM;
import jkt.hms.masters.business.StoreOpPatientIssueT;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StoreQuotationReceiptM;
import jkt.hms.masters.business.StoreQuotationRequestM;
import jkt.hms.masters.business.StoreSampleTestingEntry;
import jkt.hms.masters.business.StoreSoc;
import jkt.hms.masters.business.StoreStockTakingM;
import jkt.hms.masters.business.StoreStockTakingT;
import jkt.hms.masters.business.StoreSupplyOrderEntry;
import jkt.hms.stores.dataservice.StoresDataService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreIndentT;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public  class StoresHandlerServiceImpl implements StoresHandlerService {
	StoresDataService storesDataService=null;

	public StoresDataService getStoresDataService() {
		return storesDataService;
	}


	public void setStoresDataService(StoresDataService storesDataService) {
		this.storesDataService = storesDataService;
	}
	//=========== START OF METHOD BY ABHA==================
	public Map<String, Object> getBarcodeList(int grnId) {
		return storesDataService.getBarcodeList(grnId);
	}

	public Map<String, Object> getBooModifyMap(int radio_str) {
		return storesDataService.getBooModifyMap(radio_str);
	}


	public Map<String, Object> getContingentBillPrintMap(int grnId) {
		return storesDataService.getContingentBillPrintMap(grnId);

	}




	public List<StoreGrnM> getCrvNumberList(int deptId) {
		return storesDataService.getCrvNumberList(deptId);
	}


	public Map<String, Object> getGrnPrintMap(int grnId) {
		return storesDataService.getGrnPrintMap(grnId);
	}

	public Map<String, Object>getGrnNoListForAutoComplete(Box box ){
		return storesDataService.getGrnNoListForAutoComplete( box );
	}


	public Map<String, Object> getProformaPrintMap(int grnId) {
		return storesDataService.getProformaPrintMap(grnId);
	}




	public Map searchBoo(Map searchFieldMap) {
		return storesDataService.searchBoo(searchFieldMap);
	}

	public Map<String, Object> showBooJsp(Map<String, Object>infoMap) {

		return storesDataService.showBooJsp(infoMap);

	}


	public boolean addBoo(Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return storesDataService.addBoo(infoMap);
	}


	public boolean addDefectiveDrugs(Map<String, Object> infoMap,Map<String, Object>dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.addDefectiveDrugs(infoMap,dataMap);
	}

	public boolean addProformaBEntry(Map<String, Object> infoMap,Map<String, Object>dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.addProformaBEntry(infoMap,dataMap);
	}



	public boolean addGrns(Map<String, Object> infoMap,Map<String, Object>dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.addGrns(infoMap,dataMap);
	}


	public boolean addLoanIn( Map<String, Object> infoMap,Map<String, Object>dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.addLoanIn(infoMap,dataMap);
	}





	public List<StoreDefectiveDrugM> getDefectDrug(int entryId) {
		// TODO Auto-generated method stub
		return storesDataService.getDefectDrug(entryId);
	}


	public Map getDefectiveDrugModifyMap(int id, int pageNo) {
		// TODO Auto-generated method stub
		return storesDataService.getDefectiveDrugModifyMap(id,pageNo);
	}


	public Map<String, Object> getDetailsForLoanIn() {
		// TODO Auto-generated method stub
		return storesDataService.getDetailsForLoanIn();
	}


	public Map<String, Object> getDetailsForMoreInfoGrn() {
		// TODO Auto-generated method stub
		return storesDataService.getDetailsForMoreInfoGrn();
	}


	public List<StoreGrnM> getGrn(int grnId) {
		// TODO Auto-generated method stub
		return storesDataService.getGrn(grnId);
	}


//	public Map getGrnModifyMap(int radio_str) {
//	// TODO Auto-generated method stub
//	return storesDataService.getGrnModifyMap(radio_str);
//	}


	public Map<String, Object> getIndentList(String choice) {
		// TODO Auto-generated method stub
		return storesDataService.getIndentList(choice);
	}


	public Map<String, Object> getLoanInList(int poId) {
		// TODO Auto-generated method stub
		return storesDataService.getLoanInList(poId);
	}


	public List<StoreLoaninT> getLoanInListForMoreInfo(int loaninDetailId) {
		// TODO Auto-generated method stub
		return storesDataService.getLoanInListForMoreInfo(loaninDetailId);
	}


	public List<StoreGrnT> getStoreGrnTListForMoreInfo(int storeGrnTId) {
		// TODO Auto-generated method stub
		return storesDataService.getStoreGrnTListForMoreInfo(storeGrnTId);
	}


	public Map<String, Object> getVendorList(String vendor) {
		// TODO Auto-generated method stub
		return storesDataService.getVendorList(vendor);
	}


	public Map getViewAllMap() {
		// TODO Auto-generated method stub
		return storesDataService.getViewAllMap();
	}


	public List<StoreLoaninM> getloanList() {
		// TODO Auto-generated method stub
		return storesDataService.getloanList();
	}


//	public Map<String, Object> grnModifyMap(int id, int pageNo) {
//	// TODO Auto-generated method stub
//	return storesDataService.grnModifyMap(id, pageNo);
//	}


	public Map<String, Object> modifyLoanin(int id, int pageNo) {
		// TODO Auto-generated method stub
		return storesDataService.modifyLoanin(id, pageNo);
	}


	public Map searchDefectiveDrug(Map searchFieldMap){
		// TODO Auto-generated method stub
		return storesDataService.searchDefectiveDrug(searchFieldMap);
	}


	public Map searchGrn(Map searchFieldMap){
		// TODO Auto-generated method stub
		return storesDataService.searchGrn(searchFieldMap);
	}


	public Map searchLoanin(Map searchFieldMap){
		// TODO Auto-generated method stub
		return storesDataService.searchLoanin(searchFieldMap);
	}


	public Map<String, Object> showDefectiveDrugJsp(Map<String, Object>dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.showDefectiveDrugJsp(dataMap);
	}

	public Map<String, Object> showProformaBSearchJsp(Map<String, Object>dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.showProformaBSearchJsp(dataMap);
	}



	public Map<String, Object> showGridJsp(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.showGridJsp(box);
	}


	public Map<String, Object> showGridLoanInJsp(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.showGridLoanInJsp(box);
	}


	public Map showGrnJsp(Box box ,Map<String, Object>dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.showGrnJsp(box,dataMap);
	}
	public Map showGrnProJsp(Box box ,Map<String, Object>dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.showGrnProJsp(box,dataMap);
	}


	public Map showLoanInJsp(Map<String, Object>dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.showLoanInJsp(dataMap);
	}


	public boolean submitAdjustLoanIn(int loaninId, StoreGrnM storeGrnM,
			int poId, List list, Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return storesDataService.submitAdjustLoanIn(loaninId, storeGrnM, poId, list, infoMap);
	}


	public boolean updateBoo(StoreBoo storeBoo, List list) {
		// TODO Auto-generated method stub
		return storesDataService.updateBoo(storeBoo, list);
	}


	public boolean updateGrn(StoreGrnM storeGrnM, List list) {
		// TODO Auto-generated method stub
		return storesDataService.updateGrn(storeGrnM, list);
	}


	public boolean updateLoanIn(Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return storesDataService.updateLoanIn(infoMap);
	}

	public Map<String, Object> fillItemsForGrn(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.fillItemsForGrn(dataMap);
	}
	public Map<String, Object> getItemListForGrnByAutocomplete(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.getItemListForGrnByAutocomplete(dataMap);
	}


	public Map getResponseIndentList(Box box)
	{
		return storesDataService.getResponseIndentList(box);
	}
	
	public Map getReceiveRCWaitingList(Box box)
	{
		return storesDataService.getReceiveRCWaitingList(box);
	}
	
	public Map getResponseProformaList(Box box)
	{
		return storesDataService.getResponseProformaList(box);
	}
	public Map getResponsePoList(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getResponsePoList(box);
	}


	public Map<String, Object> fillItemsForLoanIn(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.fillItemsForLoanIn(dataMap);
	}


	public Map<String, Object> getItemListForLoanInByAutocomplete(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.getItemListForLoanInByAutocomplete(dataMap);
	}
	public Map<String, Object> getItemListForDefectiveDrugsByAutocomplete(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.getItemListForDefectiveDrugsByAutocomplete(dataMap);
	}


	public Map<String, Object> fillItemsForDefectiveDrug(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.fillItemsForDefectiveDrugs(dataMap);
	}



	public Map<String, Object> fillItemsForDefectiveDrugs(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.fillItemsForDefectiveDrugs(dataMap);
	}

	
	public Map<String, Object> fillItemsForDrugDisposal(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.fillItemsForDrugDisposal(dataMap);
	}

//	public Map getLoanInModifyMap(int radio_str) {
//	// TODO Auto-generated method stub
//	return storesDataService.getLoanInModifyMap(radio_str);
//	}


	public Map<String, Object> getExpiryDateInAjax(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.getExpiryDateInAjax(dataMap);
	}


	public Map<String, Object> defectiveDrugModifyMap(int id) {
		// TODO Auto-generated method stub
		return storesDataService.defectiveDrugModifyMap(id);
	}


	public List<StoreDefectiveDrugM> getDefectiveList() {
		// TODO Auto-generated method stub
		return storesDataService.getDefectiveList();
	}




	public List<StoreGrnM> getGrnList() {
		// TODO Auto-generated method stub
		return storesDataService.getGrnList();
	}


	public Map<String, Object> modifyGrn(int id, int pageNo , int spoid, String items) {
		// TODO Auto-generated method stub
		return storesDataService.modifyGrn(id, pageNo, spoid, items);
	}


	public Map<String, Object> getAdjustmentList(
			int workOrderId, int pageNo, String items,String loan) {
		// TODO Auto-generated method stub
		return storesDataService.getAdjustmentList(workOrderId, pageNo,items,loan);
	}

	public boolean createAdjustment(Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return storesDataService.createAdjustment(infoMap);
	}


	public List<StoreDefectiveDrugM> getDefectiveDrugsList() {
		// TODO Auto-generated method stub
		return storesDataService.getDefectiveDrugsList();
	}


	public List<StoreBoo> getBooList() {
		// TODO Auto-generated method stub
		return storesDataService.getBooList();
	}

//	================================================================================
//	==========================END OF ABHA METHOD================
//	========================================================================

	//*********************************************************************************************************************
	//------------------------------------Start of Methods Written By Vivek------------------------------------------
	//****************************************************************************************************************

	//------------------------------Indent----------------------------

	public Map printMmfIndent(int indentId) {
		return storesDataService.printMmfIndent(indentId);
	}

	public Map<String, Object> getItemListForMMFIndentModify(Map<String, Object> dataMap) {

		return storesDataService.getItemListForMMFIndentModify(dataMap);
	}
	public Map<String, Object> fillItemsCommon(Map<String, Object> dataMap) {
		return storesDataService.fillItemsCommon(dataMap);
	}
	public Map<String, Object> updateArrovalPro(Map<String, Object> dataMap) {
		return storesDataService.updateArrovalPro(dataMap);
	}
	public Map<String, Object> validateNivMaster(Map<String, Object> dataMap) {
		return storesDataService.validateNivMaster(dataMap);
	}
	
	public Map<String, Object> getItemListForMMFIndent(Map<String, Object> dataMap) {
		return storesDataService.getItemListForMMFIndent(dataMap);
	}
	public Map<String, Object> checkYearExists(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.checkYearExists(dataMap);
	}

	public Map getIndentModifyMapForDepot(int radio_str, int pageNo , int deptId,int hospitalId) {
		// TODO Auto-generated method stub
		return storesDataService.getIndentModifyMapForDepot(radio_str,pageNo , deptId,hospitalId) ;
	}


	public Map getIndentModifyMapForDepotOld(int radio_str, int pageNo , int deptId,int hospitalId) {
		// TODO Auto-generated method stub
		return storesDataService.getIndentModifyMapForDepotOld(radio_str,pageNo , deptId,hospitalId) ;
	}


	public Map<String, Object> lockMMFIndent(int year) {
		// TODO Auto-generated method stub
		return storesDataService.lockMMFIndent(year);
	}
	public Map<String, Object> showLockMMFIndent() {
		return storesDataService.showLockMMFIndent();
	}
	public Map<String, Object> showImportMMFIndentJsp(Map<String, Object> dataMap) {
		return storesDataService.showImportMMFIndentJsp(dataMap);
	}
//	public Map getIndentDepotPrintMap(int indentId) {
//	// TODO Auto-generated method stub
//	//return storesDataService.getIndentDepotPrintMap(indentId);
//	}
	public Map getIndentModifyMap(int radio_str, int pageNo) {

		return storesDataService.getIndentModifyMap(radio_str, pageNo);
	}
	public Map<String, Object> importMMFIndent(Map<String, Object> dataMap) throws java.text.ParseException {
		return storesDataService.importMMFIndent(dataMap);
	}

	public boolean addNextOrSubmitIndentToMMF(StoreIndentM storeIndentM, List list, Map<String,Object> map) {
		return storesDataService.addNextOrSubmitIndentToMMF(storeIndentM, list, map);
	}

	@SuppressWarnings("unchecked")
	public Map showIndent(int deptId) {
		return storesDataService.showIndent(deptId);
	}



	public Map getIndentMAndTUpdate(int indentId) {
		// TODO Auto-generated method stub
		return storesDataService.getIndentMAndTUpdate(indentId);
	}

	public Map<String, Object> searchIndent(Map<String, Object> searchFieldMap){
		return storesDataService.searchIndent(searchFieldMap);
	}


	public StoreIndentM getStoresIndentMObject(int indentId) {
		// TODO Auto-generated method stub
		return storesDataService.getStoresIndentMObject(indentId);
	}


	public int getIndentId(int indentNo) {
		// TODO Auto-generated method stub
		return storesDataService.getIndentId(indentNo);
	}


	@SuppressWarnings("unchecked")
	public Map getIndentMAndT(int indentId) {
		return storesDataService.getIndentMAndT(indentId);
	}
	public boolean updateIndent(StoreIndentM storeIndentTlist, List list) {
		return storesDataService.updateIndent(storeIndentTlist, list);
	}
	public boolean updateNextIndent(Map<String, Object> masterAndDetailMap) throws java.text.ParseException {
		return storesDataService.updateNextIndent(masterAndDetailMap);
	}
	public Map<String, Object> checkExistenceOfCuurentYearIndent(int year) {

		return storesDataService.checkExistenceOfCuurentYearIndent(year);
	}

	public boolean updateIndent(StoreIndentM storeIndentTlist) {
		// TODO Auto-generated method stub
		return false;
	}

	//---------------------End Of MMF Indent------------

	//--------------Indent To Depot ----------------
	public Map<String, Object> getItemListForIndentToDepot(Map<String, Object> dataMap) {
		return storesDataService.getItemListForIndentToDepot(dataMap) ;
	}

	public Map<String, Object> fillItemsForIndentToDepot(Map<String, Object> dataMap) {
		return storesDataService.fillItemsForIndentToDepot(dataMap);
	}

	public Map<String, Object> addNextOrSubmitIndentToDepot(Map<String, Object> dataMap) {
		return storesDataService.addNextOrSubmitIndentToDepot(dataMap);
	}

	public boolean updateNextIndentToDepot(Map<String, Object> masterAndDetailMap) {
		return storesDataService.updateNextIndentToDepot(masterAndDetailMap) ;
	}
	public Map<String, Object> showIndentJspDepot(Map<String, Object> dataMap) {
		return storesDataService.showIndentJspDepot(dataMap);
	}
	//---------------------End Of Indent To Depot---------------

	//--------------Indent To SOC ----------------
	public Map<String, Object> showIndentJspSOC(Map<String, Object> dataMap){
		return storesDataService.showIndentJspSOC(dataMap);
	}
	public Map<String, Object> addNextOrSubmitIndentToSOC(Map<String, Object> dataMap) {
		return storesDataService.addNextOrSubmitIndentToSOC(dataMap);
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getIndentModifyMapForSOC(int indentId, int pageNo) {
		return storesDataService.getIndentModifyMapForSOC(indentId, pageNo);
	}
	public boolean updateNextIndentToSOC(Map<String, Object> masterAndDetailMap) {
		return storesDataService.updateNextIndentToSOC(masterAndDetailMap);
	}
	public Map getBrandListForSOC(int itemId) {
		return storesDataService.getBrandListForSOC(itemId);
	}
	public Map getBrandListForSOC(int itemId, int detailId) {
		// TODO Auto-generated method stub
		return storesDataService.getBrandListForSOC(itemId,detailId);
	}
	public Map<String, Object> fillItemsForIndentToSOC(Map<String, Object> dataMap) {
		return storesDataService.fillItemsForIndentToSOC(dataMap);
	}
	public Map<String, Object> getManufacturerNameInAjax(Map<String, Object> dataMap) {
		return storesDataService.getManufacturerNameInAjax(dataMap);
	}
	public Map<String, Object> getItemListForIndentToSOC(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForIndentToSOC(dataMap);
	}

	//--------------End of Indent To SOC ----------------



//	-------------------------------------- Start of Indent Soc Tracker  ------------------------------------------

	public Map<String,Object> showIndentSocTracker() {
		return storesDataService.showIndentSocTracker();
	}
	public Map<String, Object> getIndentSocTracker(Map<String, Object> idsMap) {
		return storesDataService.getIndentSocTracker(idsMap);
	}
	public boolean addOrUpdateIndentSocTracker(StoreIndentSocTracker indentSocTracker,int indentSocTrackerId) {

		return storesDataService.addOrUpdateIndentSocTracker(indentSocTracker,indentSocTrackerId);
	}


	public Map<String, Object> getItemMapForAutoComplete() {
		//System.out.println("This is getItemMapForAutoComplete in Handler");
		return storesDataService.getItemMapForAutoComplete();
	}


	public Map<String, Object> adjustLoanIn() {
		// TODO Auto-generated method stub
		return null;
	}
	public Map<String, Object> getIndentListForSocTracker(Map<String, Object> dataMap) {
		return storesDataService.getIndentListForSocTracker(dataMap);
	}
	public Map<String, Object> getItemListForSocTracker(Map<String, Object> dataMap) {
		return storesDataService.getItemListForSocTracker(dataMap);
	}
//	-------------------------------------- End of Indent Soc Tracker  ------------------------------------------

	//----------------------------Start Of Issues To Dispensary (CIV) ----------------------

	public Map<String, Object> getIssueDetailPageByPage(Map<String, Object> pageMap) {

		return storesDataService.getIssueDetailPageByPage(pageMap);
	}


	public Map openDeletePopupForIssueciv(Map<String, Object> dataMap) {

		return storesDataService.openDeletePopupForIssueciv(dataMap);
	}

	public Map showDeleteIsuueCiv(Box box) {

		return storesDataService.showDeleteIsuueCiv(box);

	}


	public Map deleteIssueCivItems(Box box) {
		return storesDataService.deleteIssueCivItems(box);
	}


	public Map searchIssueCiv(Box box) {
		return storesDataService.searchIssueCiv(box);
	}


	public List<MasStoreItem> getItemList() {
		return storesDataService.getItemList();
	}


	public Map<String, Object> getDemandList(Map dataMap) {
		return storesDataService.getDemandList(dataMap);
	}
	
	public Map<String, Object> getDemandListPartial(Map dataMap) {
		return storesDataService.getDemandListPartial(dataMap);
	}

	
	public Map<String, Object> getDemandListForRC(Map dataMap) {
		return storesDataService.getDemandListForRC(dataMap);
	}

	public Map<String, Object> adjustLoanOut(Map<String, Object> dataMap) {
		return storesDataService.adjustLoanOut(dataMap);
	}
	
	public Map showIssueDispensaryJsp(Map<String, Object> dataMap) {
		return storesDataService.showIssueDispensaryJsp(dataMap);
	}

	public Map showIssueDispensaryJspPartial(Map<String, Object> dataMap) {
		return storesDataService.showIssueDispensaryJspPartial(dataMap);
	}
	
	public Map showIssueUnit(Map<String, Object> dataMap) {
		return storesDataService.showIssueUnit(dataMap);
	}


	public Map getBrandMap(Map<String, Object> dataMap)throws java.text.ParseException {
		return storesDataService.getBrandMap(dataMap);
	}


	@SuppressWarnings("unchecked")
	public boolean addBrandDetails(Map<String,Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.addBrandDetails(dataMap);
	}
	public int getIssueId(String issueNo) {
		// TODO Auto-generated method stub
		return storesDataService.getIssueId(issueNo);
	}
	public Map<String, Object> getAdjustLoanOutMap(Map<String, Object> dataMap) {

		return storesDataService.getAdjustLoanOutMap(dataMap);
	}
	public Map<String, Object> getIndentSocPrintMap(int indentId) {
		// TODO Auto-generated method stub
		return null;
	}
	public Map<String, Object> showPrintIndentDepotJsp(Map<String, Object> dataMap) {
		return storesDataService.showPrintIndentDepotJsp(dataMap);
	}
	public Map<String, Object> showPrintIssueToDispensary() {
		// TODO Auto-generated method stub
		return storesDataService.showPrintIssueToDispensary();
	}
	public Map<String, Object> getIssuePrintMap(int issue_m_id) {
		// TODO Auto-generated method stub
		return storesDataService.getIssuePrintMap(issue_m_id);
	}

	public Map<String, Object> getIssueIndentMap(String demandNo,int deptId) {
		// TODO Auto-generated method stub
		return storesDataService.getIssueIndentMap(demandNo,deptId);
	}

	public Map<String, Object> getItemListForIssueToDispensary(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForIssueToDispensary(dataMap);
	}
	public Map<String, Object> fillItemsForIssueToDispensary(Map<String, Object> dataMap) {
		return storesDataService. fillItemsForIssueToDispensary(dataMap);
	}
	
	public Map<String, Object> fillBatchForIssueToPatient(Map<String, Object> dataMap) {
		return storesDataService. fillBatchForIssueToPatient(dataMap);
	}
	
	
	//----------------------------End Of Issues To Dispensary (CIV) ----------------------

	//----------------------------Start Of Issues To Dispensary Loan Out ----------------------
	public Map<String, Object> getHinNo(Map<String, Object> dataMap) {

		return storesDataService.getHinNo(dataMap);
	}
	public Map<String, Object> getRequestedBy(Map<String, Object> dataMap) {

		return storesDataService.getRequestedBy(dataMap);
	}
	public Map addBrandDetailsForLoanOut(Box box) throws java.text.ParseException {
		return storesDataService.addBrandDetailsForLoanOut(box);
	}
	public Map<String, Object> openDeletePopupForIssueLoanOut(Map dataMap) {
		return storesDataService.openDeletePopupForIssueLoanOut(dataMap);
	}
	public Map showDeleteIsuueLoanout(Box box) {
		return storesDataService.showDeleteIsuueLoanout(box) ;
	}


	public Map deleteIssueLoanoutItems(Box box) {
		return storesDataService.deleteIssueLoanoutItems(box) ;
	}


	public Map<String, Object> searchInternalIndentDetails(Map<String, Object> dataMap) {
		return storesDataService.searchInternalIndentDetails(dataMap);
	}


	public Map showIssueDispensaryManualJsp(Map<String, Object> dataMap) {
		return storesDataService.showIssueDispensaryManualJsp(dataMap);
	}


	public Map searchIssueLoanout(Box box) {
		return storesDataService.searchIssueLoanout(box);
	}

	public Map<String, Object> getItemListForLoanoutByAutocomplete(Map<String, Object> dataMap) {
		return storesDataService.getItemListForLoanoutByAutocomplete(dataMap);
	}

	//----------------------------End Of Issues To Dispensary Loan Out ----------------------

	//----------------------------Start Of Issues To Other Units on Surplus (CIV) ----------------------

	public Map printIssueToOtherUnits(int issue_m_id) {
		return storesDataService.printIssueToOtherUnits(issue_m_id);
	}
	public Map addBrandDetailsToOtherUnits(Box box) throws java.text.ParseException {
		return storesDataService.addBrandDetailsToOtherUnits(box);
	}


	public Map<String, Object> openDeletePopupForIssueToOtherUnits(Map dataMap) {
		return storesDataService.openDeletePopupForIssueToOtherUnits(dataMap);
	}


	public Map showDeleteIsuueToOtherUnits(Box box) {
		return storesDataService.showDeleteIsuueToOtherUnits(box);
	}


	public Map deleteIssueToOtherUnitsItems(Box box) {
		return storesDataService.deleteIssueToOtherUnitsItems(box);
	}

	public Map showIssueToOtherUnitsJsp(Map<String, Object> dataMap) {
		return storesDataService.showIssueToOtherUnitsJsp(dataMap);
	}


	public Map searchIssueToOtherUnits(Box box) {
		return storesDataService.searchIssueToOtherUnits(box);
	}

	public Map<String, Object> getItemListThroughAjax(Map<String, Object> dataMap) {

		return storesDataService.getItemListThroughAjax(dataMap);
	}

	public Map<String, Object> fillItemsForIssueToDepot(Map<String, Object> dataMap) {
		return storesDataService.fillItemsForIssueToDepot(dataMap);
	}

	//----------------------------End Of Issues To Other Units on Surplus (CIV) ----------------------


	//----------------------------Start Of Issues To Other Than Airforce Units  ----------------------
	public Map addBrandDetailsToOTAFU(Box box) throws java.text.ParseException {
		return storesDataService.addBrandDetailsToOTAFU(box);
	}


	public Map<String, Object> openDeletePopupForIssueToOTAFU(Map dataMap) {
		return storesDataService.openDeletePopupForIssueToOTAFU(dataMap);
	}


	public Map showDeleteIsuueToOTAFU(Box box) {
		return storesDataService.showDeleteIsuueToOTAFU(box);
	}


	public Map deleteIssueToOTAFU(Box box) {
		return storesDataService.deleteIssueToOTAFU(box);
	}

	public Map showIssueToOTAFUJsp(Map<String, Object> dataMap) {
		return storesDataService.showIssueToOTAFUJsp(dataMap);
	}


	public Map searchIssueToOTAFU(Box box) {
		return storesDataService.searchIssueToOTAFU(box);
	}

	public Map<String, Object> getItemListThroughAjaxToOTAFU(Map<String, Object> dataMap) {

		return storesDataService.getItemListThroughAjaxToOTAFU(dataMap);
	}

	public Map<String, Object> fillItemsForIssueToOTAFU(Map<String, Object> dataMap) {
		return storesDataService.fillItemsForIssueToOTAFU(dataMap);
	}


	public Map<String, Object> getIndentDepotPrintMap(int indentId) {

		return storesDataService.getIndentDepotPrintMap(indentId);
	}
	public Map<String, Object> getItemListForIssueToOTAFU(Map<String, Object> dataMap) {
		return storesDataService.getItemListForIssueToOTAFU(dataMap) ;
	}
	public Map<String, Object> fillIssueToOTAFUBasedOnLotNo(Map<String, Object> dataMap) {
		return storesDataService.fillIssueToOTAFUBasedOnLotNo(dataMap);
	}
	//----------------------------End Of Issues To Other Than Airforce Units  ----------------------

	//-------------------------------Vendor Return ------------------------------

	public Map<String, Object> fillItemsForIndentToVendorReturn(Map<String, Object> dataMap) {
		return storesDataService.fillItemsForIndentToVendorReturn(dataMap);
	}

	public Map<String, Object> getItemListForVendorReturn(Map<String, Object> dataMap) {
		return storesDataService.getItemListForVendorReturn(dataMap);
	}

	public Map<String, Object> showVendorReturnJsp(Map<String, Object> map) {
		return storesDataService.showVendorReturnJsp(map);
	}


	public Map<String, Object> showStockDetailsForVendorReturn(Map<String, Object> map) {
		return storesDataService.showStockDetailsForVendorReturn(map);
	}


	public Map<String, Object> submitVendorReturnDetails(Map<String, Object> dataMap) {
		return storesDataService.submitVendorReturnDetails(dataMap);
	}


	public Map<String, Object> showDeleteVendorReturn(Map<String, Object> map) {
		return storesDataService.showDeleteVendorReturn(map) ;
	}


	public boolean deleteStockDetailsVendorReturn(Map<String, Object> map) {
		return storesDataService.deleteStockDetailsVendorReturn(map);
	}


	public Map<String, Object> searchVendorReturn(Map<String, Object> searchFieldMap) {
		return storesDataService.searchVendorReturn(searchFieldMap);
	}


	//*********************************************************************************************************************
	//------------------------------------End of Methods Written By Vivek----------------------------------------------
	//*****************************************************************************************************************
	//*********************************************************************************************************************
	//------------------------------------ Methods Written By Vikas----------------------------------------------
	//*****************************************************************************************************************
	public Map<String, Object> showOPDPatientIssue(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showOPDPatientIssue(map);
	}
	
	
	
	public Map<String, Object> showOPDPatientIssueFAC(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showOPDPatientIssueFAC(map);
	}


	public Map<String, Object> getHinNoList(String serviceNumber) {
		// TODO Auto-generated method stub
		return storesDataService.getHinNoList(serviceNumber);
	}



	public Map<String, Object> getParaList(String issueNo) {
		// TODO Auto-generated method stub
		return storesDataService.getParaList(issueNo);
	}

	public Map<String, Object> showOPDPatientIssueGridForMIssue(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showOPDPatientIssueGridForMIssue(map);
	}
	
	public Map<String, Object> showOPDPatientIssueGrid(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showOPDPatientIssueGrid(map);
	}
	
	public Map<String, Object> showOPDPatientIssueGridPartial(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showOPDPatientIssueGridPartial(map);
	}
	
	public Map<String, Object> showOPDPatientIssueGridFAC(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showOPDPatientIssueGridFAC(map);
	}
	
	public Map<String, Object> showIPDPartialPatientIssueGrid(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showIPDPartialPatientIssueGrid(map);
	}
	
	public Map<String, Object> showIPDPatientIssueGridPatientWise(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showIPDPatientIssueGridPatientWise(map);
	}
	
	public Map<String, Object> showOPDPatientIssueGridByHin(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showOPDPatientIssueGridByHin(map);
	}
	
	public Map<String, Object> showOPDPatientNIPApprovalGrid(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showOPDPatientNIPApprovalGrid(map);
	}


	public Map<String, Object> showOPDStockDetailsJsp(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showOPDStockDetailsJsp(map);
	}


	public Map<String, Object> submitOPDPatientStockDetails(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.submitOPDPatientStockDetails(map);
	}
	
	public Map<String, Object> submitOPDPatientStockDetailsFAC(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.submitOPDPatientStockDetailsFAC(map);
	}
	
	public Map<String, Object> submitOPDPatientStockDetailsByHin(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.submitOPDPatientStockDetailsByHin(map);
	}
	
	public Map<String, Object> submitOPDPatientNIPDetails(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.submitOPDPatientNIPDetails(box);
	}
	
	public Map<String, Object> submitIPPatientStockDetails(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.submitIPPatientStockDetails(box);
	}
	
	public Map<String, Object> submitIPPatientStockDetailsPartial(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.submitIPPatientStockDetailsPartial(box);
	}

	public Map<String, Object> submitIPPartialPatientStockDetails(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.submitIPPartialPatientStockDetails(map);
	}

	public Map<String, Object> showModifyOPDPatientIssueJsp(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showModifyOPDPatientIssueJsp(map);
	}


	public boolean deleteStockDetails(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.deleteStockDetails(map);
	}


	public Map<String, Object> showStockDetailsForLotNo(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.showStockDetailsForLotNo(map);
	}

	public Map<String, Object> getItemListForOPD(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.getItemListForOPD(map);
	}

	public Map<String, Object> fillItemsInGridForOPD(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.fillItemsInGridForOPD(map);
	}


	public Map<String, Object> fillItemsInGridForOPDDir(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.fillItemsInGridForOPDDir(map);
	}





	public Map<String, Object> fillItemsInGridForLotNo(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.fillItemsInGridForLotNo(map);
	}
	//*********************************************************************************************************************
	//------------------------------------End of Methods Written By Vikas----------------------------------------------
	//*****************************************************************************************************************

//	-----------------------Start of Modules Of Deepti Tevatia  ---------------------

	//-------------------------------Return from Dispensary------------------------------

	public Map<String, Object> showReturnFromDispensaryJsp(Map<String, Object> map) {
		return storesDataService.showReturnFromDispensaryJsp(map);
	}


	public Map<String, Object> showStockDetailsForReturnDispensary(Map<String, Object> map) {
		return storesDataService.showStockDetailsForReturnDispensary(map);
	}


	public Map<String, Object>  submitReturnDispensaryDetails(Map<String, Object> dataMap) {
		return storesDataService.submitReturnDispensaryDetails(dataMap);
	}


	public Map<String, Object> showDeleteReturnFromDispensary(Map<String, Object> map) {
		return storesDataService.showDeleteReturnFromDispensary(map) ;
	}


	public boolean deleteStockDetailsReturnToDispensary(Map<String, Object> map) {
		return storesDataService.deleteStockDetailsReturnToDispensary(map);
	}


	public Map<String, Object> searchReturnToDispensary(Map<String, Object> searchFieldMap) {
		return storesDataService.searchReturnToDispensary(searchFieldMap);
	}

	public Map<String, Object> getItemListForDepartmentReturn(Map<String, Object> dataMap) {
		return storesDataService.getItemListForDepartmentReturn(dataMap);
	}

	//---------------------------------- Physical Stock----------------------------------------


	public Map<String, Object> searchPhysicalStock(int departmentId) {
		return storesDataService.searchPhysicalStock(departmentId);
	}


	public boolean addPhysicalStock(StoreStockTakingM storeStockTakingM,
			List<StoreStockTakingT> storeStockTakingTlist) {
		return storesDataService.addPhysicalStock(storeStockTakingM,storeStockTakingTlist);
	}

	public boolean updatePhysicalStock(StoreStockTakingM storeStockTakingM,
			List<StoreStockTakingT> storeStockTakingTlist) {
		return storesDataService.updatePhysicalStock(storeStockTakingM,storeStockTakingTlist);
	}

	//----------------------------------New Grid------ Department Indent----------------------

	public Map<String, Object> showDepartmentIndent(int deptId,int hospitalId) {
		return storesDataService.showDepartmentIndent(deptId,hospitalId);
	}

	public Map<String, Object> createAndImportDepartmentIndentData(Box box) {
		return storesDataService.createAndImportDepartmentIndentData(box);
	}


	public Map<String, Object> getDepartmentIndentData(Box box) {
		return storesDataService.getDepartmentIndentData(box);
	}


	public Map<String, Object> getItemDetailsForDepartmentIndent(Box box) {
		return storesDataService.getItemDetailsForDepartmentIndent(box);
	}
	public Map<String, Object> getItemDetailsForDepartmentIndentForNextRecord(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getItemDetailsForDepartmentIndentForNextRecord(box);
	}

	public Map<String, Object> doAddInternalIndentItems(Box box) {
		return storesDataService.doAddInternalIndentItems(box);
	}


	public Map<String, Object> updateGridItemsInDepartmentIndent(Box box) {
		return storesDataService.updateGridItemsInDepartmentIndent(box);
	}


	public Map<String, Object> deleteGridItemsForDepartmentIndent(Box box) {
		return storesDataService.deleteGridItemsForDepartmentIndent(box);
	}



//	-------------------------------------- MMF Department  ------------------------------------------
	public Map<String, Object> showMmfDepartment(int deptId, int hospitalId) {
		return storesDataService.showMmfDepartment(deptId, hospitalId);
	}

	public Map<String, Object> createAndImportMmfDepartmentData(Box box) {
		return storesDataService.createAndImportMmfDepartmentData(box);
	}

	public Map<String, Object> getMmfDepartmentData(Box box) {
		return storesDataService.getMmfDepartmentData(box);
	}


	public Map<String, Object> getItemDetails(Box box) {
		return storesDataService.getItemDetails(box);
	}
	public Map<String, Object> getItemDetailsForMmfDepartmentJspForNextRecord(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getItemDetailsForMmfDepartmentJspForNextRecord(box);
	}

	public Map<String, Object> doAddMmfItems(Box box) {
		return storesDataService.doAddMmfItems(box);
	}


	public Map<String, Object> updateGridItemsInMmf(Box box) {
		return storesDataService.updateGridItemsInMmf(box);
	}


	public Map<String, Object> getCurrentYearMmf(Box box) {
		return storesDataService.getCurrentYearMmf(box);
	}


	public Map<String, Object> deleteGridItemsForMmf(Box box) {
		return storesDataService.deleteGridItemsForMmf(box);
	}

	public Map<String, Object> searchMmfDepartmentData(Box box) {
		return storesDataService.searchMmfDepartmentData(box) ;
	}



	public Map<String, Object> reportPvms(Box box) {
		return storesDataService.reportPvms(box) ;
	}
	public Map<String, Object> reportMasterMedcine(Box box) {
		return storesDataService.reportMasterMedcine(box) ;
	}
	public Map<String, Object> reportStockStatus(Box box) {
		return storesDataService.reportStockStatus(box) ;
	}
	public Map<String, Object> reportStockBatch(Box box) {
		return storesDataService.reportStockBatch(box) ;
	}
	public Map<String, Object> reportStockReceipt(Box box) {
		return storesDataService.reportStockReceipt(box) ;
	}
	public Map<String, Object> reportStockIssue(Box box) {
		return storesDataService.reportStockIssue(box) ;
	}
	public Map<String, Object> reportStockSurplus(Box box) {
		return storesDataService.reportStockSurplus(box) ;
	}
	public Map<String, Object> reportStockDeficient(Box box) {
		return storesDataService.reportStockDeficient(box) ;
	}
	public Map<String, Object> reportStockABC(Box box) {
		return storesDataService.reportStockABC(box) ;
	}
	public Map<String, Object> reportStockVDU(Box box) {
		return storesDataService.reportStockVDU(box) ;
	}





	public String getMmfNo(int docId) {
		return storesDataService.getMmfNo(docId);
	}

	public boolean addAdjustment(Box box) {
		return storesDataService.addAdjustment(box);
	}

	public Map<String, Object> showAdjustment1(Box box) {
		return storesDataService.showAdjustment1(box);
	}

	/*public boolean storeItemBatch(Map<String, Object> map) {
				return storesDataService.storeItemBatch(map);
				}
	 */

	//New Grid For Physical Stock

	public Map<String, Object> showPhysicalStock(Map<String, Object> dataMap){
		return storesDataService.showPhysicalStock(dataMap);
	}

	public Map<String, Object> createGridForPhysicalStockData(Box box) {
		return storesDataService.createGridForPhysicalStockData(box);
	}



	public Map<String, Object> updateGridItemsInPhysicalStock(Box box) {
		return storesDataService.updateGridItemsInPhysicalStock(box);
	}

	public Map<String, Object> getGridDataForPhysicalStock(
			Box box) {
		return storesDataService.getGridDataForPhysicalStock(box);
	}

//	-----------------------END of Modules Of Deepti Tevatia  ---------------------

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------Start of Functions Written By K.R. Othivadivel------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	public Map<String, Object> showMMFDepartmentWiseSplitup(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.showMMFDepartmentWiseSplitup(box);
	}



	public Map<String, Object> getIndentNosForSupplyOrderEntry(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getIndentNosForSupplyOrderEntry(box);
	}



	public Map<String, Object> getItemsForSupplyOrderEntryJsp(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getItemsForSupplyOrderEntryJsp(box);
	}



	public Map<String, Object> doAddSupplyOrderEntryItems(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.doAddSupplyOrderEntryItems(box);
	}

	//-----------------------------------------------------------------------------------------------------------------
	// -------------------------------------End of Functions Written By K.R. Othivadivel------------------------------
	// -----------------------------------------------------------------------------------------------------------------


	//-----------------------------------------------------------------------------------------------------------------
	//-------------------------------------Start of Functions Written By Mansi-------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------


	//--------------------------------------- Balance--------------------------

	public Map<String, Object> showBalance(Map<String, Object> dataMap) {
		return storesDataService.showBalance(dataMap);
	}
	
	public Map<String, Object> getItemRCList(Box box) {
		return storesDataService.getItemRCList(box);
	}


	public Map<String, Object> searchBalance(Map<String, Object> searchFieldMap) {
		return storesDataService.searchBalance(searchFieldMap);
	}


	public boolean addBalance(StoreBalanceM storeBalanceM,	List<StoreBalanceT> storeBalanceTlist, Map<String, Object> infoMap) {
		return storesDataService.addBalance(storeBalanceM,storeBalanceTlist,infoMap);
	}


	public Map<String, Object> getBalanceModifyMap(int radio_str) {
		return storesDataService.getBalanceModifyMap(radio_str);
	}


	public Map<String, Object> getBalanceMAndTUpdate(int balanceId) {
		return storesDataService.getBalanceMAndTUpdate(balanceId);
	}


	public boolean updateBalance(StoreBalanceM storeBalanceM,
			List<StoreBalanceT> storeBalanceTlist) {
		return storesDataService.updateBalance(storeBalanceM,storeBalanceTlist);
	}

	public int getBalanceId(int balanceNo) {
		return storesDataService.getBalanceId(balanceNo);
	}

	public Map<String, Object> getBalance1ModifyMap(int balanceId, int pageNo,Map<String, Object> dataMap) {
		return storesDataService.getBalance1ModifyMap(balanceId,pageNo,dataMap);
	}

	public boolean updateNextBalance1(Map<String, Object> masterAndDetailMap) throws java.text.ParseException {
		return storesDataService.updateNextBalance1(masterAndDetailMap);
	}


	public Map<String, Object> addNextOrSubmitBalance(Map<String, Object> dataMap) {
		return storesDataService.addNextOrSubmitBalance(dataMap);
	}



	public Map<String, Object>  showLastDemandNo(int pageNo) {
		return storesDataService.showLastDemandNo(pageNo);
	}


	public Map<String, Object> showLastDocNo(int pageNo) {
		return storesDataService.showLastDocNo(pageNo);
	}



	//-----------------------New Grid for Ack-------------------------------------------
	public Map<String, Object> showAckJsp(int deptId,int hospitalId) {
		return storesDataService.showAckJsp(deptId,hospitalId);
	}

	public Map<String, Object> showAckJspForRC(int deptId,int hospitalId) {
		return storesDataService.showAckJspForRC(deptId,hospitalId);
	}

	public Map<String, Object> createGridIssueData(Box box) {
		return storesDataService.createGridIssueData(box);
	}


	public Map<String, Object> doAddAckItems(Box box) {
		return storesDataService.doAddAckItems(box);
	}
	
	public Map<String, Object> doAddAckItemsForRC(Box box) {
		return storesDataService.doAddAckItemsForRC(box);
	}



	public Map<String, Object> showSupplyOrderEntryJsp() {
		return storesDataService.showSupplyOrderEntryJsp();
	}

	public Map<String, Object> searchSupplyOrderEntry(int indentId) {
		return storesDataService.searchSupplyOrderEntry(indentId);
	}

	public boolean addStoreSupplyOrderEntry(int indentId,List<StoreSupplyOrderEntry> storeSupplyOrderEntrylist) {
		return storesDataService.addStoreSupplyOrderEntry(indentId,storeSupplyOrderEntrylist);
	}


	public boolean updateSupplyOrderEnter(int indentId,List<StoreSupplyOrderEntry> storeSupplyOrderEntrylist) {
		return storesDataService.updateSupplyOrderEnter(indentId,storeSupplyOrderEntrylist);
	}

	public Map<String, Object> createGridSupplyOrderEntryData(Box box) {
		return storesDataService.createGridSupplyOrderEntryData(box);
	}


	public Map<String, Object> getItemDetailsForSupplyOrderEntry(
			Box box) {
		return storesDataService.getItemDetailsForSupplyOrderEntry(box);
	}


	public Map<String, Object> getItemDetailsForUpdateSupplyOrderEntry(
			Box box) {
		return storesDataService.getItemDetailsForUpdateSupplyOrderEntry(box);
	}


	public Map<String, Object> fillItemsForBalance(
			Map<String, Object> dataMap) {
		return storesDataService.fillItemsForBalance(dataMap);
	}


	public Map<String, Object> getItemListForLoanoutByAutocompleteBalance(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForLoanoutByAutocompleteBalance(dataMap);
	}


	public Map<String, Object> getConnectionForReport() {
		return storesDataService.getConnectionForReport();
	}
	
	public int getPrintCount(String column_name, String din_no) {
		return storesDataService.getPrintCount(column_name, din_no);
	}
	
	public void updatePrintCount(String column_name, String din_no) {
		 storesDataService.updatePrintCount(column_name, din_no);
	}

	public Map<String, Object> getResultValue(String pro,int hospitalId) {
		return storesDataService.getResultValue(pro,hospitalId);
	}


	public Map<String, Object> checkHinExistence(Map<String, Object> dataMap) {
		return storesDataService.checkHinExistence(dataMap);
	}



	public Map<String, Object> getLPOList(int indentId) {
		return storesDataService.getLPOList(indentId);
	}


	//-----------------------------------------------------------------------------------------------------------------
	//-------------------------------------End of Functions Written By Mansi-------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------



	//-----------------------------------------------------------------------------------------------------------------
	// -------------------------------------Start of Reports Functions Written By Mansi------------------------------
	// -----------------------------------------------------------------------------------------------------------------


	public String getHospitalName(int hospitalId) {
		return storesDataService.getHospitalName(hospitalId);
	}
	
	
	public String generateABCAnalysisReport(int deptId,String fromDate,String toDate) {
		return storesDataService.generateABCAnalysisReport(deptId,fromDate,toDate);
	}
	


	public Map<String, Object> showItemCatalogueJsp(Box box) {
		return storesDataService.showItemCatalogueJsp(box);
	}



	public Map<String, Object> showVendorReportJsp() {
		return storesDataService.showVendorReportJsp();
	}

	public Map<String, Object> showBrandReportJsp() {
		return storesDataService.showBrandReportJsp();
	}


	public Map<String, Object> showDrugListBodySystemWiseReportJsp() {
		return storesDataService.showDrugListBodySystemWiseReportJsp();
	}


	public Map<String, Object> showVendorTurnoverEnquiryReportJsp() {
		return storesDataService.showVendorTurnoverEnquiryReportJsp();
	}


	public Map<String, Object> showExternalIssueReportJsp() {
		return storesDataService.showExternalIssueReportJsp();
	}

	public Map<String, Object> showDMConsumDrugWiseReportJsp() {
		return storesDataService.showDMConsumDrugWiseReportJsp();
	}


	//-----------------------------------------------------------------------------------------------------------------
	//-------------------------------------End of Reports Functions Written By Mansi-------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------

	/**
	 * added by Priyanka on 13 May 2008
	 */
	public Map<String, Object> getDBConnection() {
		return storesDataService.getDBConnection();
	}

	public Map<String, Object>  getATSODate(int indentId)
	{
		return storesDataService.getATSODate(indentId);
	}


	public Map<String, Object> getActualQtyAsPerAU(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return storesDataService.getActualQtyAsPerAU(paramMap);
	}


	public Map<String, Object> submitGrn(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.submitGrn(box);
	}


	public Map<String, Object> getBudgetDetails(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getBudgetDetails(box);
	}


	public Map<String, Object> getItemListForCompleteStockNomenclatureByAutocomplete(Map dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.getItemListForCompleteStockNomenclatureByAutocomplete(dataMap);
	}
	public Map<String, Object> getItemListForCompleteStockCommonNameByAutocomplete(Map dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.getItemListForCompleteStockCommonNameByAutocomplete(dataMap);
	}


	public Map<String, Object> getStockDetails(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getStockDetails(box);
	}


	public Map<String, Object> getStockDetailsForNextRecord(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getStockDetailsForNextRecord(box);
	}


	public Map<String, Object> submitLoanIn(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.submitLoanIn(box);
	}


	public Map<String, Object> submitCrvAftProDeatail(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.submitCrvAftProDeatail(box);
	}




	public Map<String, Object> resetMmfDepartmentData(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.resetMmfDepartmentData(box);
	}


	public Map<String, Object> getLoanOutPrintMap(Map dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.getLoanOutPrintMap(dataMap);
	}

	public Map<String, Object> getCurrentYearMmfByItem(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getCurrentYearMmfByItem(box);
	}


	public Map<String, Object> getItemListForNomenclature(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getItemListForNomenclature(box);
	}


	public Map<String, Object> showMmfDepartmentApproval(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.showMmfDepartmentApproval( box);
	}


	public Map<String, Object> updateGridItemsInMmfDepartmentApproval(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.updateGridItemsInMmfDepartmentApproval(box);
	}


	public Map<String, Object> getItemObject(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getItemObject(box);

	}


	public Map<String, Object> getItemObjectFromPvms(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getItemObjectFromPvms(box);
	}

	public Map<String, Object> getEcelSheetDataForMMf(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getEcelSheetDataForMMf(box);
	}


	public Map<String, Object> getItemDetailsForStockTakingAdd(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getItemDetailsForStockTakingAdd(box);
	}


	public Map<String, Object> doAddStockTakingItems(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.doAddStockTakingItems(box);
	}


	public Map<String, Object> showDispensaryComsumptionJsp(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.showDispensaryComsumptionJsp(box);
	}


	public Map<String, Object> submitDispensaryConsumptionStockDetails(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return storesDataService.submitDispensaryConsumptionStockDetails(map);
	}
	//:::::::::::START::::::::::::ADD FOR CRV MODIFICATION SCREEN:::::::::::::::BY KALYAN::::::::::::::::::::::
	public Map<String, Object> updateCrv(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.updateCrv(box);
	}

	public Map<String, Object> getSOItemDetails(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getSOItemDetails(box);
	}

	public Map<String, Object> getLPItemDetails(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getLPItemDetails(box);
	}

	public Map<String, Object> getLPItemDetailsValidate(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getLPItemDetailsValidate(box);
	}

	public Map<String, Object> getLPItemProBDetails(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getLPItemProBDetails(box);
	}




	//:::::::::::END::::::::::::ADD FOR CRV MODIFICATION SCREEN:::::::::::::::::::::::::::::::::::::::::::::::


	public Map<String, Object> findloanInItems(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.findloanInItems(dataMap);
	}

	public Map<String, Object> findGrnLedgeraction(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.findGrnLedgeraction(dataMap);
	}
	public Map<String, Object> pendingSupplierOrderDetails(Map<String, Object> dataMap) {
		return storesDataService.pendingSupplierOrderDetails(dataMap);
	}

	public Map<String, Object> showItemSearchJsp(Box box) {
		return storesDataService.showItemSearchJsp(box);
	}
	public Map<String, Object> showPvmsNomencaltureSearchJsp(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.showPvmsNomencaltureSearchJsp(box);
	}
	public Map<String, Object> showLoanOutStatusJsp(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.showLoanOutStatusJsp(box);
	}
	public Map<String, Object> getMasItemId(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getMasItemId(box);
	}
	public Map<String, Object> getItemId(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getItemId(box);
	}
	public Map<String, Object> checkgrnNo(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.checkgrnNo(box);
	}
	public Map<String, Object> getVendorDetails(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getVendorDetails(box);
	}

	public boolean closeIssueCiv(int issueId) {
		// TODO Auto-generated method stub
		return storesDataService.closeIssueCiv(issueId);
	}
	public Map<String, Object> getItemListForLoanoutByAutocompleteBalancePvms(Map<String, Object> dataMap) {
		return storesDataService.getItemListForLoanoutByAutocompleteBalancePvms(dataMap);
	}


	public boolean checkCrvStatus(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.checkCrvStatus(box);
	}


	public Map<String, Object> deleteOpeningBalanceItems(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.deleteOpeningBalanceItems(box);
	}


	public Map<String, Object> validateOpeningBalanceItems(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.validateOpeningBalanceItems(box);
	}


	public Map<String, Object> deleteGridItemsIssueToDispensary(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.deleteGridItemsIssueToDispensary(box);
	}
	public Map<String , Object> ShowListOFLoanInForUpdate(){
		return storesDataService.ShowListOFLoanInForUpdate();
	}
	public Map<String ,Object>updateForLoanIn(Box box){
		return storesDataService.updateForLoanIn(box);
	}

	public Map<String, Object> showNewDepartmentMMFJsp(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.showNewDepartmentMMFJsp(box);
	}

	public Map<String, Object> doAddNewMmfItems(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.doAddNewMmfItems(box);
	}

	public Map<String, Object> createAndImportTotalMmfDepartmentData(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.createAndImportTotalMmfDepartmentData(box);
	}

	public Map<String, Object> fillItemsForAdjustment(Map<String, Object> dataMap) {
		return storesDataService.fillItemsForAdjustment(dataMap);
	}
	public boolean updateItemForAdjustment(Map<String, Object> map) {
		return storesDataService.updateItemForAdjustment(map);
	}


	public Map<String, Object> getitem(Box box) {
		return storesDataService.getitem(box);
	}
	public Map<String, Object> getPatientDetailsForPrescription(
			int wardId) {
		return storesDataService.getPatientDetailsForPrescription(wardId);
	}
	
	public Map<String, Object> getPatientDetailsForPrescriptionPartial(
			int wardId) {
		return storesDataService.getPatientDetailsForPrescriptionPartial(wardId);
	}
	
	public Map<String, Object> getPatientDetailsForPrescriptionFAC(
			int prescriptionId) {
		return storesDataService.getPatientDetailsForPrescriptionFAC(prescriptionId);
	}
	
	public Map<String, Object> getPatientDetailsForPartialPrescription(
			int prescriptionId) {
		return storesDataService.getPatientDetailsForPartialPrescription(prescriptionId);
	}
	
	public Map<String, Object> getPatientDetailsForPrescriptionByHin(
			int hinId) {
		return storesDataService.getPatientDetailsForPrescriptionByHin(hinId);
	}
	
	/*public Map<String, Object> showOPDPatientNIPIssue(
			int hinId) {
		return storesDataService.showOPDPatientNIPIssue(hinId);
	}*/
	public Map<String, Object> getPatientDetailsForNIP(
			int hinId) {
		return storesDataService.getPatientDetailsForNIP(hinId);
	}
	
	public Map<String, Object> showSearchDepartmentIndent(int deptId, int hospitalId) {
		return storesDataService.showSearchDepartmentIndent(deptId, hospitalId);
	}
	public Map<String, Object> showDemandIssueReportJsp(int deptId) {
		return storesDataService.showDemandIssueReportJsp(deptId);
	}
	public Map<String, Object> searchItemForMMFApproval(Box box) {
		return storesDataService.searchItemForMMFApproval(box);
	}
	public Map<String, Object> getVendorList() {
		return storesDataService.getVendorList();
	}
	public Map<String, Object> getSOListForLoanIn(Map<String, Object> dataMap ) {
		return storesDataService.getSOListForLoanIn(dataMap );
	}


	public Map<String, Object> getLoanInTListForModify(int loanInId) {
		return storesDataService.getLoanInTListForModify(loanInId);
	}

	public Map<String, Object> getLoanInItemsForVendor(Box box) {
		return storesDataService.getLoanInItemsForVendor(box);
	}
	public boolean checkDemandIssue(Map<String,Object> map){
		return storesDataService.checkDemandIssue(map);
	}

	@Override
	public Map<String, Object> showInternalIssueReportJsp() {
		return storesDataService.showInternalIssueReportJsp();
	}

	public boolean submitDispensaryForLp(Box box) {
		return storesDataService.submitDispensaryForLp(box);
	}

	public Map<String, Object> getPrescriptionForPatientIssueList(Map<String,Object> map)
	{
		return storesDataService.getPrescriptionForPatientIssueList(map);
	}
	public Map<String, Object> generateActualStockExcel(Map<String,Object> map)
	{
		return storesDataService.generateActualStockExcel(map);
	}
	public Map<String, Object> generateActualStockSactionExcel(Map<String,Object> map)
	{
		return storesDataService.generateActualStockSactionExcel(map);
	}
	public List<StoreOpPatientIssueT> getDailyIssueSummery(Map<String,Object> map)
	{
		return storesDataService.getDailyIssueSummery(map);
	}


	@Override
	public Map<String, Object> showActualStockReportJsp() {
		return storesDataService.showActualStockReportJsp();
	}
	public Map<String, Object> getPatientDetailsForNextPrescription(int prescriptionId) {
		return storesDataService.getPatientDetailsForNextPrescription(prescriptionId);
	}

	public Map<String, Object> fillItemsInGridForDepartmentIndent(Map<String,Object> map)
	{
		return storesDataService.fillItemsInGridForDepartmentIndent(map);
	}
	@Override
	public Map<String, Object> deleteGridItemsForIndentDepo(Box box) {
		return storesDataService.deleteGridItemsForIndentDepo(box);
	}



	@Override
	public Map<String, Object> showSearchIndentToDepo(int deptId,int hospitalId) {
		return storesDataService.showSearchIndentToDepo(deptId,hospitalId);
	}


	@Override
	public Map<String, Object> getRCRequestDetails(Box box) {
		return storesDataService.getRCRequestDetails(box);
	}


	@Override
	public Map<String, Object> insertIssueForIndent(Map<String, Object> utilMap, Box box) {
		return storesDataService.insertIssueForIndent(utilMap,box);
	}
   // Dinesh
	public Map<String, Object> showAddDepartmentIndentJsp(Box box) {
		return storesDataService.showAddDepartmentIndentJsp(box);
	}
	@Override
	public Map<String, Object> indentTrackingHistoryJsp(Map<String, Object> dataMap) {
		return storesDataService.indentTrackingHistoryJsp(dataMap);
	}
	@Override
	public Map<String, Object> showWardPrescription(Map<String, Object> dataMap) {
		return storesDataService.showWardPrescription(dataMap);
	}
	public Map<String, Object> getItemListForIndent(Box box)
	{
		return storesDataService.getItemListForIndent(box);
	}
	public Map<String, Object> getOtherItemsForIndent(Box box) {

		return storesDataService.getOtherItemsForIndent(box);
	}
	public Map<String, Object> getDataForBarcode(Box box)
	{
		return storesDataService.getDataForBarcode(box);
	}
	
	public Map<String, Object> getDataForBarcodeDispensary(Box box)
	{
		return storesDataService.getDataForBarcodeDispensary(box);
	}


	@Override
	public Map<String, Object> getDataForIssueBarcode(Box box) {
		return storesDataService.getDataForIssueBarcode(box);
	}
	public  List<StoreOpPatientIssueM> printPatientIssue(int deptId,int hospitalId)
	{
		return storesDataService.printPatientIssue(deptId,hospitalId);
	}

	@Override
	public boolean updateDefective(Box box) {
		return storesDataService.updateDefective(box);
	}
	public Map<String, Object> generateActualStockDetailsExcel(Map<String,Object> map)
	{
		return storesDataService.generateActualStockDetailsExcel(map);
	}
	public Map<String, Object> generateActualStockSactionDetailsExcel(Map<String,Object> map)
	{
		return storesDataService.generateActualStockSactionDetailsExcel(map);
	}
	public Map<String, Object> printDispensaryReceiveItemReportExcel(Map<String,Object> map)
	{
		return storesDataService.printDispensaryReceiveItemReportExcel(map);
	}

	public boolean submitOPDPatientStockDetailsWithBarCode(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.submitOPDPatientStockDetailsWithBarCode(map);
	}

	@Override
	public Map<String, Object> generatePVMSExcel(
			Map<String, Object> requestParameters) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, Object> insertIssueForIndentwithoutbarcode(
			Map<String, Object> utilMap, Box box) {
		return storesDataService.insertIssueForIndentwithoutbarcode(utilMap, box);
	}
	
	@Override
	public Map<String, Object> insertIssueForIndentwithoutbarcodeWP(
			Map<String, Object> utilMap, Box box) {
		return storesDataService.insertIssueForIndentwithoutbarcodeWP(utilMap, box);
	}
	
	@Override
	public Map<String, Object> insertIssueForIndentwithoutbarcodeForRC(
			Map<String, Object> utilMap, Box box) {
		return storesDataService.insertIssueForIndentwithoutbarcodeForRC(utilMap, box);
	}

	@Override
	public Map<String, Object> insertIssueForOtherUnits(
			Map<String, Object> utilMap, Box box) {
		return storesDataService.insertIssueForOtherUnits(utilMap, box);
	}


	@Override
	public Map<String, Object> showItemAdjustmentScreen(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
		public String getBarCodeNumber(String motherHinNo,String serviceNo) {
		return storesDataService.getBarCodeNumber(motherHinNo,serviceNo);
    }

	@Override
	public List<Object> getBatchNoList(String serviceNo,int hospitalId) {
		System.out.println("after login data");
		return storesDataService.getBatchNoList(serviceNo,hospitalId);
	}


	@Override
	public Map<String, Object> checkCurrentBatchStock(Map<String, Object> dataMap) {
		return storesDataService.checkCurrentBatchStock(dataMap);
	}

	public Map<String, Object> generateExcelForDepot(Map<String, Object> dataMap) {
		return storesDataService.generateExcelForDepot(dataMap);
	}
	//***************ashutosh

	public Map<String, Object> getLpPrescriptionList(Map<String, Object> mapForDs) {
		return storesDataService.getLpPrescriptionList(mapForDs);
	}

	public Map<String, Object> getLpPrescriptionDetails(
			Map<String, Object> mapForDs) {
		return storesDataService.getLpPrescriptionDetails(mapForDs);
	}

	@Override
	public boolean updateIssueToOtherUnit(Box box) {
		return storesDataService.updateIssueToOtherUnit(box) ;
	}
	// ************************ javed khan
	public Map<String, Object> getReceiptRegisterReport(Map<String, Object> requestParameters) {
		return storesDataService.getReceiptRegisterReport(requestParameters);
	}


	@Override
	public Map<String, Object> getSurplusItem(Map<String, Object> requestParameters) {
		return storesDataService.getSurplusItem(requestParameters);

	}


	@Override
	public Map<String, Object> getRecieveItem(Map<String, Object> parameters) {
		return storesDataService.getRecieveItem(parameters);
	}


	@Override
	public Map<String, Object> getLocalRegisterReport(Map<String, Object> requestParameters) {
			return storesDataService.getLocalRegisterReport(requestParameters);
	}


	@Override
	public Map<String, Object> getActualStock(Map<String, Object> requestParameters) {

		return storesDataService. getActualStock(requestParameters);
	}


	@Override
	public Map<String, Object> getActualStockSection(Map<String, Object> requestParameters) {

		return storesDataService. getActualStockSection(requestParameters);
	}


	@Override
	public Map<String, Object> getDefectiveDrugsItem(Map<String, Object> requestParameters) {

		return storesDataService. getDefectiveDrugsItem(requestParameters);
	}


	@Override
	public Map<String, Object> getVEDItem(Map<String, Object> requestParameters) {
		return storesDataService. getVEDItem(requestParameters);
	}


	@Override
	public Map<String, Object> getFSNItem(Map<String, Object> requestParameters) {
		return storesDataService. getFSNItem(requestParameters);
	}


	@Override
	public Map<String, Object> getTurnOverDataInAjax(Map<String, Object> dataMap) {
		return storesDataService. getTurnOverDataInAjax(dataMap);
	}


	@Override
	public Map<String, Object> getDailyIssueItem(Map<String, Object> requestParameters) {

		return storesDataService.getDailyIssueItem(requestParameters);
	}


	@Override
	public Map<String, Object> getdrugStock(Map<String, Object> requestParameters) {

		return storesDataService.getdrugStock(requestParameters);
	}


	@Override
	public Map<String, Object> getSurplusMedicalStoreItem(Map<String, Object> datamap) {
		return storesDataService.getSurplusMedicalStoreItem(datamap);

	}


	@Override
	public boolean addDrugCost(Map<String, Object> infoMap,
			Map<String, Object> dataMap) {
		return storesDataService.addDrugCost(infoMap,dataMap);
	}

		public String getPVMS(String itemId){
		return storesDataService.getPVMS(itemId);
	}

	public String getBrand(String brandId){
		return storesDataService.getBrand(brandId);
	}
	public String getSupplierId(String supplierNo){
		return storesDataService.getSupplierId(supplierNo);
	}

	public String getSupplierPenAmt(int supplierId,int hospitalId){
		return storesDataService.getSupplierPenAmt(supplierId,hospitalId);
	}


	public List getPreId(String supplierNo){
		return storesDataService.getPreId(supplierNo);
	}
	public String getManu(String manuId){
		return storesDataService.getManu(manuId);
	}


	@Override
	public Map<String, Object> searchDrugCost(Map<String, Object> searchFieldMap) {
		return storesDataService.searchDrugCost(searchFieldMap);
	}


	@Override
	public Map<String, Object> getExpiryDateForReturnDispensary(Map<String, Object> dataMap) {

		return storesDataService.getExpiryDateForReturnDispensary(dataMap);
	}


	@Override
	public Map<String, Object> createAndSaveMmfDepartmentData(Box box) {
		return storesDataService.createAndSaveMmfDepartmentData(box);
	}


	@Override
	public Map<String, Object> getPendingForIndentData(Map<String, Object> dataMap) {

		return storesDataService.getPendingForIndentData(dataMap);
	}


	@Override
	public Map<String, Object> showLoanout(int deptId, int hospitalId) {
		return storesDataService.showLoanout(deptId, hospitalId);
	}


	@Override
	public String getHospitalAddress(int hospitalId) {
		return storesDataService.getHospitalAddress(hospitalId);
	}


	@Override
	public String consignerName(int supId, String jsp) {
		return storesDataService.consignerName(supId,jsp);
	}


	@Override
	public Map<String, Object> getDepartmentList() {
		return storesDataService.getDepartmentList();
	}


	@Override
	public Map<String, Object> showPrescriptionDetails(int precriptionId) {
		return storesDataService. showPrescriptionDetails(precriptionId);
	}


	@Override
	public Map<String, Object> showOPDPatientLoanOutIssueGrid(Map<String, Object> map) {

		return storesDataService. showOPDPatientLoanOutIssueGrid(map);
	}


	@Override
	public Map<String, Object> getItemListForTurnOverByAutocomplete(Map<String, Object> dataMap) {
			return storesDataService. getItemListForTurnOverByAutocomplete(dataMap);
	}


	@Override
	public List getSupplierName(int hospitalId) {
		return storesDataService. getSupplierName(hospitalId);
	}



	@Override
	public Map<String, Object> getUnit(Map<String, Object> dataMap) {
		return storesDataService.getUnit(dataMap);
	}


	@Override
	public Map<String, Object> getAU() {
		return storesDataService.getAU();
	}



	public Map<String, Object> showPendingDefectiveItemsJsp(Box box)
	{
		return storesDataService. showPendingDefectiveItemsJsp(box);
	}


	public Map<String, Object> submitPendingDefectiveItemsJsp(Box box)
	{
		return storesDataService. submitPendingDefectiveItemsJsp(box);
	}
	// ************************

	public Map<String, Object> getDepartmentIssueData(Map datamap)
	{
		return storesDataService.getDepartmentIssueData(datamap);
	}

	// ************************

	public Map<String, Object> getPatientDetailsForPatientDirectPriscription(Map<String, Object> dataMap)
	{
		return storesDataService. getPatientDetailsForPatientDirectPriscription(dataMap);
	}

	public Map<String, Object> showDirectPriscriptionJsp(Map<String, Object> dataMap)
	{
		return storesDataService.showDirectPriscriptionJsp(dataMap);
	}
	public Map<String, Object> showIndentHistoryJsp(Map<String, Object> dataMap)
	{
		return storesDataService.showIndentHistoryJsp(dataMap);
	}
	public Map<String, Object> waitingForRateContract(Map<String, Object> dataMap)
	{
		return storesDataService.waitingForRateContract(dataMap);
	}
	
	public Map<String, Object> rcToVendor(Map<String, Object> dataMap)
	{
		return storesDataService.rcToVendor(dataMap);
	}
	
	public Map<String, Object> rcListSubmitUntilReceive(Box box)
	{
		return storesDataService.rcListSubmitUntilReceive(box);
	}

	public Map<String, Object> showGrnJspForAFMSD(Box box,Map<String, Object> dataMap)
	{
		return storesDataService. showGrnJspForAFMSD(box,dataMap);
	}
	public Map<String, Object> submitDirectPatientIssue(Map mapForDS) {
		// TODO Auto-generated method stub
		return storesDataService.submitDirectPatientIssue(mapForDS);
	}

	public boolean submitOPDPatientStockDetailsDirect(Map map) {
		// TODO Auto-generated method stub
		return storesDataService.submitOPDPatientStockDetailsDirect(map);
	}

	@Override
	public Map<String, Object> getIndentNo(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.getIndentNo(dataMap);
	}

	public boolean submitSampleTestingEntry(Map<String, Object> infoMap,Map<String, Object> dataMap)
	{
		return storesDataService.submitSampleTestingEntry(infoMap,dataMap);
	}


	public Map<String, Object> showSampleTestingEntryJsp(Map<String, Object> dataMap)
	{
		return storesDataService.showSampleTestingEntryJsp(dataMap);
	}


	public Map<String, Object> submitFollowDetailsForSampleEntry(Box box)
	{
		return storesDataService.submitFollowDetailsForSampleEntry(box);
	}

	public Map<String, Object> searchSampleTestingEntry(Map<String, Object> dataMap)
	{
		return storesDataService.searchSampleTestingEntry(dataMap);
	}

	public List<StoreSampleTestingEntry> getSampleTestingEntry()
	{
		return storesDataService.getSampleTestingEntry();
	}

	public Map getSampleTestEntryModifyMap(int id, int pageNo)
	{
		return storesDataService.getSampleTestEntryModifyMap(id,pageNo);
	}

	public boolean updateSampleTestingEntry(Box box)
	{
		return storesDataService.updateSampleTestingEntry(box);
	}

	@Override
	public Map<String, Object> insertIssueForIndentupdate(
			Map<String, Object> utilMap, Box box) {
		return storesDataService.insertIssueForIndentupdate(utilMap,  box);
	}


	public Map<String, Object> getMMFItem(Map<String, Object> dataMap)
	{
		return storesDataService.getMMFItem(dataMap);
	}


public Map<String, Object> ExportExcelForPerformaB(Box box)
	{
		return storesDataService.ExportExcelForPerformaB(box);
	}


	public Map<String, Object> showMedicineReturnJsp(Map<String, Object> dataMap)
	{
		return storesDataService.showMedicineReturnJsp(dataMap);
	}

	public boolean submitMedicineReturn(Map<String, Object> infoMap,
			Map<String, Object> dataMap)
			{
		return storesDataService.submitMedicineReturn(infoMap,dataMap);
			}

	  // add javed for print issue to units from dispensary
	@Override
	public Map printIssueDispToUnits(int issueMId) {
		return storesDataService.printIssueDispToUnits(issueMId);
	}


	@Override
	public Map<String, Object> insertIssueForIndentToUnit(
			Map<String, Object> utilMap, Box box) {
		return storesDataService.insertIssueForIndentToUnit(utilMap,box);
	}

	// add javed khan for  section in Auto Indent
	@Override
	public Map<String, Object> showSearchIndentToDepo1(
			Map<String, Object> requestParameters) {
		return storesDataService.showSearchIndentToDepo1(requestParameters);
	}

	public Map<String,Object> getSMCAndDept(Map<String,Object>dataMap)
	{
		return storesDataService.getSMCAndDept(dataMap);
	}

	public Map<String,Object> getAssignedDepartmentt(Map<String,Object>dataMap)
	{
		return storesDataService.getAssignedDepartmentt(dataMap);
	}

	public boolean AssignDepartmentForStoreFyDocument(Map<String,Object>dataMap)
	{
		return storesDataService.AssignDepartmentForStoreFyDocument(dataMap);
	}


	//Added by javed khan for Proforma B Approval

	@Override
	public Map<String, Object> showProformaBApproval(Map<String, Object> dataMap) {
		return storesDataService.showProformaBApproval(dataMap);
	}

	public Map<String, Object> showProformaBAccountApproval(Map<String, Object> dataMap) {
		return storesDataService.showProformaBAccountApproval(dataMap);
	}


	@Override
	public Map<String, Object> getPendingProformaForApproval(
			Map<String, Object> dataMap) {
		return storesDataService.getPendingProformaForApproval(dataMap);
	}

	public Map<String, Object> getPendingProformaForApprovalAccount(
			Map<String, Object> dataMap) {
		return storesDataService.getPendingProformaForApprovalAccount(dataMap);
	}


	@Override
	public Map<String, Object> proformaBApproved(Map<String, Object> dataMap) {
		return storesDataService.proformaBApproved(dataMap);
	}


	@Override
	public Map<String, Object> showProformaBeforApproval(Box box) {
		return storesDataService.showProformaBeforApproval(box);
	}


	@Override
	public Map<String, Object> newSearchIndent(Map<String, Object> searchFieldMap) {

		return storesDataService.newSearchIndent(searchFieldMap);
	}


	@Override
	public Map getIndentModifyMapForDepot1(int radioStr, int pageNo,int deptId, int hospitalId) {

		return  storesDataService.getIndentModifyMapForDepot1( radioStr,  pageNo, deptId,  hospitalId);
	}


	@Override
	public Map<String, Object> getDepartmentExistingIndentData(Box box) {
		return  storesDataService.getDepartmentExistingIndentData(box);
	}


	@Override
	public Map<String, Object> doAddInternalIndentsubmit(Box box) {
		return  storesDataService.doAddInternalIndentsubmit(box);
	}

	public Map<String, Object> doAddIndentsubmit(Box box) {
		return  storesDataService.doAddIndentsubmit(box);
	}



	@Override
	public Map<String, Object> getDepartmentIndentSearchData(Box box) {
		return  storesDataService.getDepartmentIndentSearchData(box);
	}

	@Override
	public Map<String, Object> getStockQtyInAjax(Map<String, Object> dataMap){
		return  storesDataService.getStockQtyInAjax(dataMap);
	}


	@Override
	public String getPVMS(int deptId, String nomenclature, int hospitalId) {
		return storesDataService.getPVMS(deptId,nomenclature,hospitalId);
	}


	@Override
	public Map<String, Object> importNivMaster(Map<String, Object> utilMap) {
		
		return storesDataService.importNivMaster(utilMap);
	}


	@Override
	public Map<String, Object> createPvmsItemExcelList(Box box) {
	
		return storesDataService.createPvmsItemExcelList(box);
	}


	@Override
	public Map<String, Object> importPvmsMaster(Map<String, Object> utilMap) {
	
		return storesDataService.importPvmsMaster(utilMap);
	}


	@Override
	public Map<String, Object> updateMmfDepartmentEntry(Box box) {
		return storesDataService.updateMmfDepartmentEntry(box);
	}


	@Override
	public Map<String, Object> getItemDetailsToUpdate(Box box) {
		return storesDataService.getItemDetailsToUpdate(box);
	}


	@Override
	public Map<String, Object> updateBatchAndExpiryDate(Box box) {
		return storesDataService.updateBatchAndExpiryDate(box);
	}


	@Override
	public Map<String, Object> getItemBatch(Box box) {
		return storesDataService.getItemBatch(box);
	}


	@Override
	public Map<String, Object> generateExcelForMmf(Box box) {
		return storesDataService.generateExcelForMmf(box);
	}


	@Override
	public Map<String, Object> showProformaBEntryJsp(Map<String, Object> dataMap) {
		return storesDataService.showProformaBEntryJsp(dataMap);
	}
	@Override
	public Map<String, Object> getPvmsID(String pvmsNo)
	{
		return storesDataService.getPvmsID(pvmsNo);
	}


	@Override
	public Map<String, Object> getDrugExpiryList(Box box) {
		return storesDataService.getDrugExpiryList(box);
	}


	@Override
	public Map<String, Object> getItemTypeList(Box box) {
		return storesDataService.getItemTypeList(box);
	}


	@Override
	public Map<String, Object> getSectionList(Box box) {
		return storesDataService.getSectionList(box);
	}


	@Override
	public Map<String, Object> getCategoryList(Box box) {
		return storesDataService.getCategoryList(box);
	}


	@Override
	public List<StoreMaterialPurchaseReqM> getMPRNumberList(int deptId,	int hospitalId) {
		return storesDataService.getMPRNumberList(deptId,hospitalId);
	}


	@Override
	public Map<String, Object> showMPRScreen(Map<String, Object> dataMap) {
		return storesDataService.showMPRScreen(dataMap);
	}
	
	@Override
	public Map<String, Object> getMasterByAutocomplete(
			Map<String, Object> dataMap) {
		return storesDataService.getMasterByAutocomplete(dataMap);
	}

	@Override
	public Map<String, Object> jsonForMasterAdd(Map<String, Object> dataMap) {
		return storesDataService.jsonForMasterAdd(dataMap);
	}
	
	@Override
	public Map<String, Object> addNextOrSubmitBalance(
			Map<String, Object> dataMap,Box box) {
		return storesDataService.addNextOrSubmitBalance(dataMap,box);
	}
	@Override
	public Map<String, Object> rcReceive(
			Map<String, Object> dataMap,Box box) {
		return storesDataService.rcReceive(dataMap,box);
	}
	@Override
	public Map<String, Object> getItemTypeGLList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.getItemTypeGLList(dataMap);
	}


	@Override
	public Map<String, Object> getSectionGLList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.getSectionGLList(dataMap);
	}
	@Override
	public Map<String, Object> showNIS(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.showNIS(dataMap);
	}


	@Override
	public Map<String, Object> getCategoryGList(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getCategoryGList(box);
	}


	@Override
	public Map<String, Object> getDrugExpiryListReport(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getDrugExpiryListReport(box);
	}


	@Override
	public Map<String, Object> saveMPR(Box box) {
		return storesDataService.saveMPR(box);
	}


	@Override
	public List<Object[]> getFinancialYearList() {
		return storesDataService.getFinancialYearList();
	}


	@Override
	public List<Object[]> getMPRPriorityList() {
		return storesDataService.getMPRPriorityList();
	}


	@Override
	public Map<String, Object> getListOfMPR(Box box) {
		return storesDataService.getListOfMPR(box);
	}


	@Override
	public Map<String, Object> getMPRDetails(int mprId) {
		return storesDataService.getMPRDetails(mprId);
	}


	@Override
	public Map<String, Object> updateSavedMPR(Box box) {
		return storesDataService.updateSavedMPR(box);
	}


	@Override
	public Map<String, Object> DeleteFromDatabase_AddRemoveGrid(Box box) {
		return storesDataService.DeleteFromDatabase_AddRemoveGrid(box);
	}
	
	@Override
	public Map<String, Object> DeleteFromDatabase_AddRemoveGridRC(Box box) {
		return storesDataService.DeleteFromDatabase_AddRemoveGridRC(box);
	}


	@Override
	public Map<String, Object> showVendorReturnRptJsp() {
		return storesDataService.showVendorReturnRptJsp();
	}


	@Override
	public Map<String, Object> showDepartmentReturnRegJsp(int hospitalId) {
		return storesDataService.showDepartmentReturnRegJsp(hospitalId);
	}


	@Override
	public Map<String, Object> showVendorReturnRegJsp(int hospitalId) {
		return storesDataService.showVendorReturnRegJsp(hospitalId);
	}


	@Override
	public Map<String, Object> dailyIssueSummryReport() {
		return storesDataService.dailyIssueSummryReport();
	}


	@Override
	public Map<String, Object> showRCPrintJsp(int hospitalId) {
		return storesDataService.showRCPrintJsp(hospitalId);
	}


	@Override
	public Map<String, Object> showRequestForQuotationJsp(Map<String, Object> dataMap) {
		return storesDataService.showRequestForQuotationJsp(dataMap);
	}


	@Override
	public Map<String, Object> getMPRListListbasedonYear(Box box) {
		return storesDataService.getMPRListListbasedonYear(box);
	}


	@Override
	public Map<String, Object> getMPRDetailsforQuotation(Box box) {
		return storesDataService.getMPRDetailsforQuotation(box);
	}


	@Override
	public Map<String, Object> saveEnquiryforQuotation(Box box) {
		return storesDataService.saveEnquiryforQuotation(box);
	}


	@Override
	public Map<String, Object> getListOfEnquiry(Box box) {
		return storesDataService.getListOfEnquiry(box);
	}


	@Override
	public Map<String, Object> getVendorQuotationDetails(int headerId) {
		return storesDataService.getVendorQuotationDetails(headerId);
	}
	
	@Override
	public Map<String, Object> getEnquiryListListbasedonYear(Box box) {
		return storesDataService.getEnquiryListListbasedonYear(box);
	}
	
	@Override
	public Map<String, Object> getQuotationDetailsforPO(Box box) {
		return storesDataService.getQuotationDetailsforPO(box);
	}
	
	@Override
	public Map<String, Object> getVendorDetailsforPO(Box box) {
		return storesDataService.getVendorDetailsforPO(box);
	}
	
	@Override
	public Map<String, Object> savePO(Box box) {
		return storesDataService.savePO(box);
	}
	
	@Override
	public Map<String, Object> getListOfPO(Box box) {
		return storesDataService.getListOfPO(box);
	}


	@Override
	public Map<String, Object> getPODetails(int headerId) {
		return storesDataService.getPODetails(headerId);
	}
	
	@Override
	public Map<String, Object> submitRCWaitingList(Box box) {
		return storesDataService.submitRCWaitingList(box);
	}
	
	@Override
	public Map<String, Object> getPOListbasedonYear(Box box) {
		return storesDataService.getPOListbasedonYear(box);
	}
	
	@Override
	public Map<String, Object> getPODetailsforChallanEntry(Box box) {
		return storesDataService.getPODetailsforChallanEntry(box);
	}
	@Override
	public List<Object[]> getEmployeeListForDepartment(Box box) {
		return storesDataService.getEmployeeListForDepartment(box);
	}
	
	@Override
	public Map<String, Object> submitRREntry(Box box) {
		return storesDataService.submitRREntry(box);
	}
	
	@Override
	public Map<String, Object> submitRCEntry(Box box) {
		return storesDataService.submitRCEntry(box);
	}
	
	@Override
	public Map<String, Object> GetMPRAndPODetailsOfItem(Box box) {
		return storesDataService.GetMPRAndPODetailsOfItem(box);
	}




	@Override
	public Map<String, Object> showRCReportJsp(int hospitalId, int deptId) {
		return storesDataService.showRCReportJsp(hospitalId, deptId);
	}

	@Override
	public Map<String, Object> showIssueMedicineReportJsp() {
		return storesDataService.showIssueMedicineReportJsp();
	}

	@Override
	public Map<String, Object> getRRList(Map<String, Object> dataMap) {
		return storesDataService.getRRList(dataMap);
	}
	@Override
	public Map<String, Object> getPOList(Map<String, Object> dataMap) {
		return storesDataService.getPOList(dataMap);
	}


	@Override
	public Map<String, Object> getPOYear(Box box) {
		return storesDataService.getPOYear(box);
	}
	@Override
	public Map<String, Object> submitIndentForSupplier(Box box) {
		return storesDataService.submitIndentForSupplier(box);
	}
	
	@Override
	public Map<String, Object> getListOfSupplierIndent(Box box) {
		return storesDataService.getListOfSupplierIndent(box);
	}
	
	@Override
	public Map<String, Object> getSupplierIndentDetails(int headerId) {
		return storesDataService.getSupplierIndentDetails(headerId);
	}
	
	@Override
	public Map<String, Object> getRRListForInspection(Box box) {
		return storesDataService.getRRListForInspection(box);
	}
	
	@Override
	public Map<String, Object> getRRDetailsforInspection(int headerId) {
		return storesDataService.getRRDetailsforInspection(headerId);
	}
	
	@Override
	public Map<String, Object> submitRRInspectionDetails(Box box) {
		return storesDataService.submitRRInspectionDetails(box);
	}
	
	@Override
	public Map<String, Object> submitRRApprovalDetails(Box box) {
		return storesDataService.submitRRApprovalDetails(box);
	}
	
	@Override
	public Map<String, Object> getSupplierIndentListbasedonPO(Box box) {
		return storesDataService.getSupplierIndentListbasedonPO(box);
	}
	
	@Override
	public Map<String, Object> fillItemsForUnsedMedicine(Box box) {
		return storesDataService.fillItemsForUnsedMedicine(box);
	}

	@Override
	public Map<String, Object> fillItemsForIndent(Map<String, Object> dataMap) {
		return storesDataService.fillItemsForIndent(dataMap);
	}
	
	@Override
	public Map<String, Object> addStockofReturnedMedicine(Box box) {
		return storesDataService.addStockofReturnedMedicine(box);
	}
	
	@Override
	public Map<String, Object> getListOfUnusedMedicine(Box box) {
		return storesDataService.getListOfUnusedMedicine(box);
	}
	
	@Override
	public Map<String, Object> getStockDetailsforMR(Box box) {
		return storesDataService.getStockDetailsforMR(box);
	}
	
	@Override
	public Map<String, Object> saveRC(Box box) {
		return storesDataService.saveRC(box);
	}
	
	@Override
	public Map<String, Object> saveMR(Box box) {
		return storesDataService.saveMR(box);
	}
	
	@Override
	public Map<String, Object> saveMRMIssue(Box box) {
		return storesDataService.saveMRMIssue(box);
	}
	
	@Override
	public Map<String, Object> getListOfMR(Box box) {
		return storesDataService.getListOfMR(box);
	}
	
	@Override
	public Map<String, Object> getListOfMRWard(Box box) {
		return storesDataService.getListOfMRWard(box);
	}
	
	
	@Override
	public Map<String, Object> getListOfRC(Box box) {
		return storesDataService.getListOfRC(box);
	}
	
	@Override
	public Map<String, Object> getListOfRCCDS(Box box) {
		return storesDataService.getListOfRCCDS(box);
	}
	
	@Override
	public Map<String, Object> getListOfReceiveRC(Box box) {
		return storesDataService.getListOfReceiveRC(box);
	}
	
	@Override
	public Map<String, Object> getListOfReceiveMR(Box box) {
		return storesDataService.getListOfReceiveMR(box);
	}
	
	@Override
	public Map<String, Object> getListOfReceiveMRForWard(Box box) {
		return storesDataService.getListOfReceiveMRForWard(box);
	}
	
	@Override
	public Map<String, Object> getListOfReceiveMRPartial(Box box) {
		return storesDataService.getListOfReceiveMRPartial(box);
	}
	
	@Override
	public Map<String, Object> getMRDetails(int mrId) {
		return storesDataService.getMRDetails(mrId);
	}
	
	@Override
	public Map<String, Object> getRCDetails(int requestHeaderId) {
		return storesDataService.getRCDetails(requestHeaderId);
	}
	
	@Override
	public Map<String, Object> getRCDetailsSubmitUntilReceive(int requestHeaderId) {
		return storesDataService.getRCDetailsSubmitUntilReceive(requestHeaderId);
	}
	
	@Override
	public Map<String, Object> viewUpdateRCSubmitUntilReceive(Box box) {
		return storesDataService.viewUpdateRCSubmitUntilReceive(box);
	}
	
	
	@Override
	public Map<String, Object> updateSavedMR(Box box) {
		return storesDataService.updateSavedMR(box);
	}
	
	@Override
	public Map<String, Object> updateSavedMRWard(Box box) {
		return storesDataService.updateSavedMRWard(box);
	}
	
	@Override
	public Map<String, Object> updateSavedRC(Box box) {
		return storesDataService.updateSavedRC(box);
	}
	
	@Override
	public Map<String, Object> updateSavedRCCDS(Box box) {
		return storesDataService.updateSavedRCCDS(box);
	}
	
	@Override
	public Map<String, Object> rcListToVendorSubmitUntilReceive(Box box) {
		return storesDataService.rcListToVendorSubmitUntilReceive(box);
	}
	
	@Override
	public Map<String, Object> submitApprovalDetailsofMR(Box box) {
		return storesDataService.submitApprovalDetailsofMR(box);
	}
	
	@Override
	public Map<String, Object> submitApprovalDetailsofRC(Box box) {
		return storesDataService.submitApprovalDetailsofRC(box);
	}
	
	@Override
	public Map<String, Object> getListOfPendingForReceivingExpiredDrugs(Box box) {
		return storesDataService.getListOfPendingForReceivingExpiredDrugs(box);
	}
	
	@Override
	public Map<String, Object> getReturnDetailsofExpiredDrugs(int returnHeaderId) {
		return storesDataService.getReturnDetailsofExpiredDrugs(returnHeaderId);
	}
	
	@Override
	public Map<String, Object> saveStockofReturnDrugs(Box box) {
		return storesDataService.saveStockofReturnDrugs(box);
	}


	@Override
	public Map<String, Object> getListofReceivedExpiredDrugs(Box box) {
		return storesDataService.getListofReceivedExpiredDrugs(box);
	}
	

	@Override
	public Map<String, Object> getPendingListofActionofDrugDisposal(Box box) {
		return storesDataService.getPendingListofActionofDrugDisposal(box);
	}
	
	@Override
	public Map<String, Object> submitActionDetailsofDrugsDisposal(Box box) {
		return storesDataService.submitActionDetailsofDrugsDisposal(box);
	}
	
	@Override
	public Map<String, Object> showPhysicalStockJsp(Box box) {
		return storesDataService.showPhysicalStockJsp(box);
	}
	
	
	@Override
	public Map<String, Object> submitPhysicalStockTaking(Box box) {
		return storesDataService.submitPhysicalStockTaking(box);
	}
	
	@Override
	public Map<String, Object> searchIndentDetails(Box box) {
		return storesDataService.searchIndentDetails(box);
	}
	
	@Override
	public Map<String, Object> getIndentDetailsforChallanEntry(Box box) {
		return storesDataService.getIndentDetailsforChallanEntry(box);
	}
	
	@Override
	public Map<String, Object> getPendingListforApprovalofStockTacking(Box box) {
		return storesDataService.getPendingListforApprovalofStockTacking(box);
	}
	
	@Override
	public Map<String, Object> showLabRequestWardWise(int hospitalId) {
		return storesDataService.showLabRequestWardWise(hospitalId);
	}
	
	@Override
	public Map<String, Object> getStockTakingDetails(int stockTakingHeaderId) {
		return storesDataService.getStockTakingDetails(stockTakingHeaderId);
	}
	
	@Override
	public Map<String, Object> updateStockTaking(Box box) {
		return storesDataService.updateStockTaking(box);
	}
	
	@Override
	public Map<String, Object> getVendorList(Map<String, Object> dataMap) {
		return storesDataService.getVendorList(dataMap);
	}
	
	@Override
	public Map<String, Object> getVendorName(Map<String, Object> requestParameters) {
		return storesDataService.getVendorName(requestParameters);
	}
	
	@Override
	public Map<String, Object> getDataForBarBatchStockId(Box box) {
		return storesDataService.getDataForBarBatchStockId(box);
	}
	
	@Override
	public Map<String, Object> searchIndentDetailswithBatchId(Box box) {
		return storesDataService.searchIndentDetailswithBatchId(box);
	}




	@Override
	public Map<String, Object> getStockDetailsForDepartment(Box box) {
		return storesDataService.getStockDetailsForDepartment(box);
	}
	
	@Override
	public Map<String, Object> getMedicineIssueAndReceiveDetails(Box box) {
		return storesDataService.getMedicineIssueAndReceiveDetails(box);
	}
	
	
}
