package jkt.hms.stores.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.StoreAmcM;
import jkt.hms.masters.business.StoreAmcT;
import jkt.hms.masters.business.StoreBosM;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreLoaninM;
import jkt.hms.masters.business.StoreLoaninT;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.StoreRepairCivilFirm;
import jkt.hms.masters.business.StoreWorkOrderM;
import jkt.hms.stores.dataservice.NonExpendableStoresDataService;
import jkt.hms.stores.dataservice.StoresDataService;
import jkt.hms.util.Box;

import com.lowagie.text.pdf.codec.postscript.ParseException;

public class NonExpendableStoresHandlerServiceImpl implements
		NonExpendableStoresHandlerService {
	NonExpendableStoresDataService nonExpendableStoresDataService = null;
	StoresDataService storesDataService = null;

	public NonExpendableStoresDataService getNonExpendableStoresDataService() {
		return nonExpendableStoresDataService;
	}

	public void setNonExpendableStoresDataService(
			NonExpendableStoresDataService nonExpendableStoresDataService) {
		this.nonExpendableStoresDataService = nonExpendableStoresDataService;
	}

	public StoresDataService getStoresDataService() {
		return storesDataService;
	}

	public void setStoresDataService(StoresDataService storesDataService) {
		this.storesDataService = storesDataService;
	}
	public Map showNeGrnJsp(Box box, Map<String, Object> dataMap) {
		return nonExpendableStoresDataService.showNeGrnJsp(box, dataMap);
	}

	public boolean addGrns(Map<String, Object> infoMap) {
		return nonExpendableStoresDataService.addGrns(infoMap);
	}

	public Map<String, Object> getListForNeGrn(String choice) {
		return nonExpendableStoresDataService.getListForNeGrn(choice);
	}

	public Map<String, Object> showGridJsp(Box box) {
		return nonExpendableStoresDataService.showGridJsp(box);
	}

	public Map showNeLoanInJsp(Box box, Map<String, Object> dataMap) {
		
		return nonExpendableStoresDataService.showNeLoanInJsp(box, dataMap);
	}

	public boolean addLoanIn(Map<String, Object> infoMap) {
		
		return nonExpendableStoresDataService.addLoanIn(infoMap);
	}

	public Map getResponseIndentList(Box box) {
		
		return nonExpendableStoresDataService.getResponseIndentList(box);
	}

	public Map<String, Object> fillItemsForGrn(Map<String, Object> dataMap) {
		
		return nonExpendableStoresDataService.fillItemsForGrn(dataMap);
	}

	public Map<String, Object> getItemListForGrnByAutocomplete(
			Map<String, Object> dataMap) {
		
		return nonExpendableStoresDataService
				.getItemListForGrnByAutocomplete(dataMap);
	}

	public Map<String, Object> fillItemsForLoanIn(Map<String, Object> dataMap) {
		
		return nonExpendableStoresDataService.fillItemsForLoanIn(dataMap);
	}

	public Map<String, Object> getItemListForLoanInByAutocomplete(
			Map<String, Object> dataMap) {
		
		return nonExpendableStoresDataService
				.getItemListForLoanInByAutocomplete(dataMap);
	}

	public Map showWorkOrderJsp(Box box, Map<String, Object> dataMap) {
		
		return nonExpendableStoresDataService.showWorkOrderJsp(box, dataMap);
	}

	public Map<String, Object> fillItemsForWorkOrder(Map<String, Object> dataMap) {
		
		return nonExpendableStoresDataService.fillItemsForWorkOrder(dataMap);
	}

	public Map<String, Object> getItemListForWorkOrderByAutocomplete(
			Map<String, Object> dataMap) {
		
		return nonExpendableStoresDataService
				.getItemListForWorkOrderByAutocomplete(dataMap);
	}

	public boolean addWorkOrder(Map<String, Object> infoMap) {
		
		return nonExpendableStoresDataService.addWorkOrder(infoMap);
	}

/*	public Map<String, Object> getWorkOrderModify(int workOrderId, int pageNo) {
		
		return nonExpendableStoresDataService.getWorkOrderModify(workOrderId,
				pageNo);
	}*/

	public Map showAmcMaintenanceJsp(Box box) {

		return nonExpendableStoresDataService.showAmcMaintenanceJsp(box);
	}

	public Map getNomenclature(int departmentId) {

		return nonExpendableStoresDataService.getNomenclature(departmentId);
	}

	public Map getPvmsNoAndGetSerialNo(int nomenclatureId) {

		return nonExpendableStoresDataService
				.getPvmsNoAndGetSerialNo(nomenclatureId);
	}

	public Map getSerialNoDetails(String serialNo, int itemId) {

		return nonExpendableStoresDataService.getSerialNoDetails(serialNo,
				itemId);
	}

	public List getSupplierList() {

		return nonExpendableStoresDataService.getSupplierList();
	}

	public boolean addAmcMDetailsandaddAmcTDetails(StoreAmcM storeAmcM,
			List<StoreAmcT> storeList) throws Exception {
		return nonExpendableStoresDataService.addAmcMDetailsandaddAmcTDetails(
				storeAmcM, storeList);
	}

	public List getAmcMList() {

		return nonExpendableStoresDataService.getAmcMList();
	}

	public List getRepairNoList() {

		return nonExpendableStoresDataService.getRepairNoList();
	}

	public Map addStoreRepairCivilFirm(StoreRepairCivilFirm storeRepairCivilFirm)
			throws Exception {

		return nonExpendableStoresDataService
				.addStoreRepairCivilFirm(storeRepairCivilFirm);
	}

	public List getRepairNo() {
		return nonExpendableStoresDataService.getRepairNo();
	}

	public Map getAmcRepairDetails(int nomenclatureId, String repairNO) {

		return nonExpendableStoresDataService.getAmcRepairDetails(
				nomenclatureId, repairNO);

	}

	public List getDocEntryNo() {

		return nonExpendableStoresDataService.getDocEntryNo();
	}

	public Map updateStoreRepairCivilFirm(
			StoreRepairCivilFirm storeRepairCivilFirm) throws Exception {

		return nonExpendableStoresDataService
				.updateStoreRepairCivilFirm(storeRepairCivilFirm);

	}

	public Map getAmcSearchResult(Map searchFieldMap) {

		return nonExpendableStoresDataService.getAmcSearchResult(searchFieldMap);
	}

	public List getStoreAmcT(int id) {
		
		return nonExpendableStoresDataService.getStoreAmcT(id);
	}

	public Map<String, Object> modifyGrn(int id, int pageNo) {
		
		return nonExpendableStoresDataService.modifyGrn(id, pageNo);
	}

	public Map searchGrn(Map searchFieldMap) throws ParseException {
		
		return nonExpendableStoresDataService.searchGrn(searchFieldMap);
	}

	public List<StoreWorkOrderM> getWorkOrderList() {
		
		return nonExpendableStoresDataService.getWorkOrderList();
	}

	public Map<String, Object> getConnectionForReport() {
		
		return nonExpendableStoresDataService.getConnectionForReport();
	}

	public Map<String, Object> modifyLoanin(int id, int pageNo) {
		
		return nonExpendableStoresDataService.modifyLoanin(id, pageNo);
	}

	public Map searchLoanin(Map searchFieldMap) throws ParseException {
		
		return nonExpendableStoresDataService.searchLoanin(searchFieldMap);
	}

	public Map showBoardOfSurvey() {
		
		return nonExpendableStoresDataService.showBoardOfSurvey();
	}

	public Map createAndImportBosData(Box box) {
		
		return nonExpendableStoresDataService.createAndImportBosData(box);
	}

	

	public Map searchBosData(String BosNo, Box box) {
		
		return nonExpendableStoresDataService.searchBosData(BosNo, box);
	}

	public Map updateSearchGridItemsBos(Box box) {
		
		return nonExpendableStoresDataService.updateSearchGridItemsBos(box);
	}

	public List<StoreGrnM> getCrvNumberList(Map<String, Object> dataMap) {
		
		return nonExpendableStoresDataService.getCrvNumberList(dataMap);
	}

	public List<StoreLoaninM> getloanList(Map<String, Object> dataMap) {
		
		return nonExpendableStoresDataService.getloanList(dataMap);
	}

	public List<StoreLoaninT> getLoanInListForMoreInfo(int loaninDetailId) {
		
		return nonExpendableStoresDataService
				.getLoanInListForMoreInfo(loaninDetailId);
	}

	public List<StoreGrnT> getStoreGrnTListForMoreInfo(int storeGrnTId) {
		
		return nonExpendableStoresDataService
				.getStoreGrnTListForMoreInfo(storeGrnTId);
	}

	public Map getBosData(Box box) {
		
		return nonExpendableStoresDataService.getBosData(box);
	}

	// ------------------------Start of Methods Written By Anand &Vivek

	// ============================Start of ME Scale Equipment

	public Map<String, Object> getMeScaleData(Box box) {
		return nonExpendableStoresDataService.getMeScaleData(box);
	}

	public Map<String, Object> searchItemsForMEScale(Box box) {
		return nonExpendableStoresDataService.searchItemsForMEScale(box);
	}

	public Map<String, Object> addItemToMeScale(Box box) {
		//return nonExpendableStoresDataService.addItemToMeScale(box);
		return null;
	}

	public Map<String, Object> deleteMeScaleItems(Box box) {
		return nonExpendableStoresDataService.deleteMeScaleItems(box);
	}

	public Map<String, Object> getMeScaleDescription(int meScaleNumber, Box box) {
		return nonExpendableStoresDataService.getMeScaleDescription(
				meScaleNumber, box);
	}

	public Map<String, Object> updateGridItemsInViewMeScale(Box box) {
		return nonExpendableStoresDataService.updateGridItemsInViewMeScale(box);
	}

	public Map<String, Object> viewMeScaleJsp() {
		return nonExpendableStoresDataService.viewMeScaleJsp();
	}
	// ----------------Start of Methods Written By Anand & Vivek

	public Map<String, Object> showWorkRegisterReportJsp() {
		
		return nonExpendableStoresDataService.showWorkRegisterReportJsp();
	}
	
	
	public Map<String, Object> getItemListForGrnByAutocompleteForNnExpendableGrn(
			Map<String, Object> dataMap)
			{
		return nonExpendableStoresDataService.getItemListForGrnByAutocompleteForNnExpendableGrn(dataMap);
			}
	
	public Map<String, Object> getindenList(int indentId)
	{
		return nonExpendableStoresDataService.getindenList(indentId);
	}
	
	public Map<String, Object> showInstallationCertificate(Map<String, Object> dataMap)
	{
		return nonExpendableStoresDataService.showInstallationCertificate(dataMap);
	}

	public Map<String, Object> responseNomenclature(Map<String,Object>dataMap) {
		
		return nonExpendableStoresDataService.responseNomenclature(dataMap);
	}
	
	public Map<String, Object> updateInstallationDate(Map<String, Object> dataMap)
	{
		return nonExpendableStoresDataService.updateInstallationDate(dataMap);
	}
	
	public Map<String, Object> showInitialDeficiencyIndentJspDepot(Map<String, Object> dataMap)
	{
		return nonExpendableStoresDataService.showInitialDeficiencyIndentJspDepot(dataMap);
	}
	
	public Map<String, Object> fillItemsForIndentToDepot(Map<String, Object> dataMap)
	{
		return nonExpendableStoresDataService.fillItemsForIndentToDepot(dataMap);
	}
	
	public Map<String, Object> getSupplierListForNeGrn(Map<String, Object> dataMap)
	{
		return nonExpendableStoresDataService.getSupplierListForNeGrn(dataMap);
	}
	
	public Map<String, Object> getPoList(int poId)
	{
		return nonExpendableStoresDataService.getPoList(poId);
	}
	
	public int countNo(String workOrderNo)
	{
		return nonExpendableStoresDataService.countNo(workOrderNo);
	}
	
	public Map<String,Object>showRepairStationJsp(Map dataMap)
	{
		return nonExpendableStoresDataService.showRepairStationJsp(dataMap);
	}

	public Map getWorkOrderModify(Map<String, Object> infoMap) {
		return nonExpendableStoresDataService.getWorkOrderModify(infoMap);
	}

	@Override
	public List<StorePoHeader> getPoNumberList(int deptId, int hospitalId) {
		return nonExpendableStoresDataService.getPoNumberList(deptId,hospitalId);
	}


	@Override
	public Map<String, Object> showNonPurchaseOrderJsp(
			Map<String, Object> dataMap) {
		return nonExpendableStoresDataService.showNonPurchaseOrderJsp(dataMap);
	}

	@Override
	public List<StorePoHeader> getPoHeader(int poId) {
		return nonExpendableStoresDataService.getPoHeader(poId);
	}

	@Override
	public int getPurchaseOrderId(String poNumber, int hospitalId) {
		return nonExpendableStoresDataService.getPurchaseOrderId(poNumber, hospitalId);
	}

	@Override
	public String getnextPurchaseOrder(String poNumber, int departmentId) {
		return nonExpendableStoresDataService.getnextPurchaseOrder(poNumber, departmentId);
	}

	@Override
	public Map<String, Object> submitNonPurchaseOrder(Map<String, Object> infoMap) {
		return nonExpendableStoresDataService.submitNonPurchaseOrder(infoMap);
	}

	@Override
	public Map<String, Object> fillItemsForNonLpo(Map<String, Object> dataMap) {
		return nonExpendableStoresDataService.fillItemsForNonLpo(dataMap);
	}

	@Override
	public Map<String, Object> getItemListNonSupplyOrder(
			Map<String, Object> dataMap) {
		return nonExpendableStoresDataService.getItemListNonSupplyOrder(dataMap);
	}

	@Override
	public Map getViewAllMap(int hospitalId) {
		return nonExpendableStoresDataService.getViewAllMap(hospitalId);
	}


	@Override
	public Map<String, Object> searchPO(Map<String, Object> searchFieldMap) {
		return nonExpendableStoresDataService.searchPO(searchFieldMap);
	}

	@Override
	public Map<String, Object> poModifyMap(int poDetailId, int pageNo,
			String buttonFlag) {
		return nonExpendableStoresDataService.poModifyMap(poDetailId,pageNo,buttonFlag);
	}

	@Override
	public boolean updatePurchaseOrder(Map<String, Object> infoMap) {
		return nonExpendableStoresDataService.updatePurchaseOrder(infoMap);
	}

	@Override
	public Map<String, Object> deletePurchaseOrderItem(Box box) {
		return nonExpendableStoresDataService.deletePurchaseOrderItem(box);
	}
	@Override
	public boolean updateWorkOrder(Map<String, Object> infoMap) {
		return nonExpendableStoresDataService.updateWorkOrder(infoMap);
	}
	@Override
	public Map<String, Object> getListForNeGrn1(String choice, int hospitalId) {
		return nonExpendableStoresDataService.getListForNeGrn1(choice, hospitalId);
	}

	@Override
	public Map<String, Object> getManuList() {
		return nonExpendableStoresDataService.getManuList();
	}

	@Override
	public Map<String, Object> showIndentToDepoNe(
			Map<String, Object> dataMap) {
		return nonExpendableStoresDataService.showIndentToDepoNe(dataMap);
	}

	@Override
	public Map<String, Object> getItemListForIndentToDepot(
			Map<String, Object> dataMap) {
		return nonExpendableStoresDataService.getItemListForIndentToDepot(dataMap);
	}
	
	@Override
	public StoreWorkOrderM loadWorkOrderObj(int workOrderId) {
		return nonExpendableStoresDataService.loadWorkOrderObj(workOrderId);
	}

	@Override
	public String getHospitalAddress(int hospitalId) {
		return nonExpendableStoresDataService.getHospitalAddress(hospitalId);
	}

	@Override
	public String getHospitalName(int hospitalId) {
		return nonExpendableStoresDataService.getHospitalName(hospitalId);
	}

	@Override
	public String getPoNumber(int poId) {
		return nonExpendableStoresDataService.getPoNumber(poId);
	}
@Override
	public Map addNextOrSubmitIndentToDepot(Map<String, Object> dataMap) {
		return nonExpendableStoresDataService.addNextOrSubmitIndentToDepot(dataMap);
	}

	@Override
	public Map<String, Object> generateExcelForDepotNe(
			Map<String, Object> requestParameters) {
		return nonExpendableStoresDataService.generateExcelForDepotNe(requestParameters);
	}

	@Override
	public Map<String, Object> newSearchIndentNe(
			Map<String, Object> searchFieldMap) {
		return nonExpendableStoresDataService.newSearchIndentNe(searchFieldMap);
	}

	public Map<String,Object> getItemListForDefectiveDrugsByAutocomplete(Map<String,Object> dataMap)
	{
		return nonExpendableStoresDataService.getItemListForDefectiveDrugsByAutocomplete(dataMap);
		
	}
	public Map<String,Object> fillItemsForDefectiveDrugs(Map<String,Object> dataMap)
	 {
		return nonExpendableStoresDataService.fillItemsForDefectiveDrugs(dataMap);
	 }
	public Map<String,Object> getItemListForIssueToDispensary(Map<String,Object> dataMap)
	  {
		return nonExpendableStoresDataService.getItemListForIssueToDispensary(dataMap);
	  }
	public Map<String,Object> fillItemsForIssueToDispensary(Map<String,Object> dataMap)
	 {
		return nonExpendableStoresDataService.fillItemsForIssueToDispensary(dataMap);
	 }
    public boolean submitMeScale(Map<String,Object> dataMap)
     {
    	return nonExpendableStoresDataService.submitMeScale(dataMap);
     }
    public boolean  updateGridItemsBos(Box box) {
		
		return nonExpendableStoresDataService.updateGridItemsBos(box);
	}

	@Override
	public Map<String, Object> getItemListForCondemnationByAutocomplete(
			Map<String, Object> dataMap) {
		
		return nonExpendableStoresDataService.getItemListForCondemnationByAutocomplete(dataMap);
	}

	

	@Override
	public Map<String, Object> getItemListForBoardOfSurveyAutocom(
			Map<String, Object> dataMap) {
		return nonExpendableStoresDataService.getItemListForBoardOfSurveyAutocom(dataMap);
	}

	@Override
	public Map<String, Object> getItemListForEquipmentLoanOut(
			Map<String, Object> dataMap) {
		return nonExpendableStoresDataService.getItemListForEquipmentLoanOut(dataMap);
	}

	@Override
	public Map<String, Object> fillItemsForEquipmentLoanOut(
			Map<String, Object> dataMap) {
		return nonExpendableStoresDataService.fillItemsForEquipmentLoanOut(dataMap);
	}
	
		public List<StoreBosM> printBOSJsp() {
		return nonExpendableStoresDataService.printBOSJsp();
	}
	public Map addBrandDetailsForEquipLoanOut(Box box) {
		return nonExpendableStoresDataService.addBrandDetailsForEquipLoanOut(box);
	}

	@Override
	public Map searchEquipmentLoanOut(Box box) {
		return nonExpendableStoresDataService.searchEquipmentLoanOut(box);
	}



}
