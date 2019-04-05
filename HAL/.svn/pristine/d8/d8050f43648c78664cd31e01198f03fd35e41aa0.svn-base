package jkt.hms.purchaseOrder.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStorePoDeliveryTerms;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.purchaseOrder.dataservice.PurchaseOrderDataService;
import jkt.hms.util.Box;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class PurchaseOrderHandlerServiceImpl implements
		PurchaseOrderHandlerService {

	PurchaseOrderDataService purchaseOrderDataService = null;

	public Map<String, Object> showPurchaseOrderJsp(Map<String, Object> dataMap) {
		return purchaseOrderDataService.showPurchaseOrderJsp(dataMap);
	}

	public Map<String, Object> submitPurchaseOrder(Map<String, Object> infoMap) {
		return purchaseOrderDataService.submitPurchaseOrder(infoMap);
	}

	public Map<String, Object> getDetailsForMoreInfoPurchase() {
		return purchaseOrderDataService.getDetailsForMoreInfoPurchase();
	}

	public int getPurchaseOrderId(String poNumber,int hospitalId) {
		return purchaseOrderDataService.getPurchaseOrderId(poNumber,hospitalId);
	}

	public List<StorePoHeader> getPoHeader(int poId) {
		return purchaseOrderDataService.getPoHeader(poId);
	}

	public List<StorePoHeader> getPoNumberList(int deptId,int hospitalId) {
		return purchaseOrderDataService.getPoNumberList(deptId,hospitalId);
	}
	
	public List<MasStoreItem>getLpItemList(List itemList) {
		return purchaseOrderDataService.getLpItemList(itemList);
	}

	public List<MasStoreBudget> getBudgetStatusList() {
		return purchaseOrderDataService.getBudgetStatusList();
	}

	public Map<String, Object> getViewAllMap(int hospitalId) {
		return purchaseOrderDataService.getViewAllMap(hospitalId);
	}

	public Map<String, Object> searchPO(Map<String, Object> searchMap){
		return purchaseOrderDataService.searchPO(searchMap);
	}

	public Map<String, Object> poModifyMap(int id, int pageNo, String buttonFlag) {
		return purchaseOrderDataService.poModifyMap(id, pageNo, buttonFlag);
	}

	public List<StorePoDetail> getPoDetailListForMoreInfoPurchase(int poDetailId) {
		return purchaseOrderDataService
				.getPoDetailListForMoreInfoPurchase(poDetailId);
	}

	public List<MasAuthorizer> getApprovalAuthoritiesList() {
		return purchaseOrderDataService.getApprovalAuthoritiesList();
	}

	public boolean updatePurchaseOrder(Map<String, Object> infoMap) {
		return purchaseOrderDataService.updatePurchaseOrder(infoMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return purchaseOrderDataService.getConnectionForReport();
	}

	public boolean submitApprovalAuthority(String approvalIds, int poId) {
		return purchaseOrderDataService.submitApprovalAuthority(approvalIds,
				poId);
	}

	public List<MasStoreSupplier> getSupplierList() {
		return purchaseOrderDataService.getSupplierList();
	}

	public Map<String, Object> getStockDetails(Map<String, Object> costMap) {
		return purchaseOrderDataService.getStockDetails(costMap);
	}

	public Map<String, Object> getStoreSetUpDetails() {
		return purchaseOrderDataService.getStoreSetUpDetails();
	}

	public List<MasStorePoDeliveryTerms> getPaymentDetails() {
		return purchaseOrderDataService.getPaymentDetails();
	}

	public List<MasStorePoDeliveryTerms> getDeliveryDetails() {
		return purchaseOrderDataService.getDeliveryDetails();
	}

	public List<MasStorePoDeliveryTerms> getDescriptionForDeliveryTermId(
			int poDeliveryTermId) {
		return purchaseOrderDataService
				.getDescriptionForDeliveryTermId(poDeliveryTermId);
	}

	public Map<String, Object> getItemListForPurchaseOrderForRC(
			Map<String, Object> dataMap) {
		return purchaseOrderDataService.getItemListForPurchaseOrderForRC(dataMap);
	}

	// Setters & Getters........

	public PurchaseOrderDataService getPurchaseOrderDataService() {
		return purchaseOrderDataService;
	}

	public void setPurchaseOrderDataService(
			PurchaseOrderDataService purchaseOrderDataService) {
		this.purchaseOrderDataService = purchaseOrderDataService;
	}

	public String getHospitalName(int i) {
		return purchaseOrderDataService.getHospitalName(i);
	}

	public String getnextPurchaseOrder(String po_number, int departmentId) {
		// TODO Auto-generated method stub
		return purchaseOrderDataService.getnextPurchaseOrder(po_number,
				departmentId);
	}

	public Map<String, Object> deletePurchaseOrderItem(Box box) {
		// TODO Auto-generated method stub
		return purchaseOrderDataService.deletePurchaseOrderItem(box);
	}

	public boolean cancelLso(Box box) {
		// TODO Auto-generated method stub
		return purchaseOrderDataService.cancelLso(box);
	}

	public String getPoNumber(int i) {
		// TODO Auto-generated method stub
		return purchaseOrderDataService.getPoNumber(i);
	}

	public Map<String, Object> getCurVendorSoAmount(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return purchaseOrderDataService.getCurVendorSoAmount(dataMap);
	}

	public Map<String, Object> getBudgetDetails(Box box) {
		// TODO Auto-generated method stub
		return purchaseOrderDataService.getBudgetDetails(box);
	}

	public Map<String, Object> getpendingLATList(Box box) {
		// TODO Auto-generated method stub
		return purchaseOrderDataService.getpendingLATList(box);
	}

	public Map<String, Object> pendingSOCRVList(Box box) {
		// TODO Auto-generated method stub
		return purchaseOrderDataService.pendingSOCRVList(box);
	}
	public Map<String, Object> getSupplyOrderNoAutocomplete(Box box) {
		return purchaseOrderDataService.getSupplyOrderNoAutocomplete(box);
	}


	public Map<String, Object> getSODetails(Box box) {
		return purchaseOrderDataService.getSODetails(box);
	}

	public Map<String, Object> closePOItem(Box box) {
		return purchaseOrderDataService.closePOItem(box);
	}
	
	public Map<String, Object> generateExcelToVendor(Map<String,Object> map)
	{
		return purchaseOrderDataService.generateExcelToVendor(map);
	}
	public Map<String, Object> generateExcelToVendorSearch(Map<String,Object> map)
	{
		return purchaseOrderDataService.generateExcelToVendorSearch(map);
	}
//javed
	@Override
	public Map<String, Object> getExpiryDrug(Map<String, Object> map) {
		return purchaseOrderDataService.getExpiryDrug(map);
	}

	@Override
	public Map<String, Object> getAbcItem(Map<String, Object> requestParameters) {
		return purchaseOrderDataService.getAbcItem(requestParameters);
	}

	@Override
	public String getHospitalAddress(int hospitalId) {
		return purchaseOrderDataService.getHospitalAddress(hospitalId);
	}
// javed khan
	@Override
	public Map<String, Object> getResultValue(String po,int hospitalId) {
		return purchaseOrderDataService.getResultValue(po,hospitalId) ;
	}

	@Override
	public Map<String, Object> showLPApprovalJsp(Map<String, Object> dataMap) {
		return purchaseOrderDataService.showLPApprovalJsp(dataMap);
	}

	@Override
	public Map<String, Object> getSoDetailsForApproval(Box box) {
		return purchaseOrderDataService.getSoDetailsForApproval(box);
	}

	@Override
	public Map<String, Object> approvePurchaseOrder(Box box) {
		return purchaseOrderDataService.approvePurchaseOrder(box);
	}

	@Override
	public Map<String, Object> deletePoDetails(Box box) {
		return purchaseOrderDataService.deletePoDetails(box);
	}
	
	@Override
	public Map<String, Object> getItemListForPurchaseOrderNew(Map<String, Object> dataMap) {
		return purchaseOrderDataService.getItemListForPurchaseOrderNew(dataMap);
	}

	@Override
	public Map<String, Object> getItemListForPurchaseOrderMR(Map<String, Object> dataMap) {
		return purchaseOrderDataService.getItemListForPurchaseOrderMR(dataMap);
	}

	@Override
	public Map<String, Object> getItemListForPurchaseOrder(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getItemListForPurchaseOrderForFAC(Map<String, Object> dataMap1)
	{
		return purchaseOrderDataService.getItemListForPurchaseOrderForFAC(dataMap1);
	}

}
