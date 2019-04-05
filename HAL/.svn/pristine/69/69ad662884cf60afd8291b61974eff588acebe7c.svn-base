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
import jkt.hms.util.Box;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public interface PurchaseOrderHandlerService {

	//Map<String, Object> showPurchaseOrderJsp(int deptId); comment By Tirath For hospitalId
	
	Map<String, Object> showPurchaseOrderJsp(Map<String, Object> dataMap);

	Map<String, Object> submitPurchaseOrder(Map<String, Object> infoMap);

	Map<String, Object> getDetailsForMoreInfoPurchase();

	int getPurchaseOrderId(String poNumber,int hospitalId);

	List<StorePoHeader> getPoHeader(int poId);

	List<StorePoHeader> getPoNumberList(int deptId,int hospitalId);
	List<MasStoreItem>getLpItemList(List itemList);

	List<MasStoreBudget> getBudgetStatusList();

	Map<String, Object> getViewAllMap(int hospitalId);

	Map<String, Object> searchPO(Map<String, Object> searchMap);

	public Map<String, Object> poModifyMap(int radio_str, int pageNo,
			String buttonFlag);

	List<StorePoDetail> getPoDetailListForMoreInfoPurchase(int poDetailId);

	boolean updatePurchaseOrder(Map<String, Object> infoMap);

	List<MasAuthorizer> getApprovalAuthoritiesList();

	Map<String, Object> getConnectionForReport();

	boolean submitApprovalAuthority(String string, int poId);

	List<MasStoreSupplier> getSupplierList();

	Map<String, Object> getStockDetails(Map<String, Object> costMap);

	Map<String, Object> getStoreSetUpDetails();

	List<MasStorePoDeliveryTerms> getPaymentDetails();

	List<MasStorePoDeliveryTerms> getDeliveryDetails();

	List<MasStorePoDeliveryTerms> getDescriptionForDeliveryTermId(
			int poDeliveryTermId);

	String getHospitalName(int i);

	Map<String, Object> getItemListForPurchaseOrder(Map<String, Object> dataMap);

	String getnextPurchaseOrder(String po_number, int departmentId);

	Map<String, Object> deletePurchaseOrderItem(Box box);

	boolean cancelLso(Box box);

	String getPoNumber(int i);

	Map<String, Object> getCurVendorSoAmount(Map<String, Object> dataMap);

	Map<String, Object> getBudgetDetails(Box box);

	Map<String, Object> getpendingLATList(Box box);

	Map<String, Object> pendingSOCRVList(Box box);
	
	Map<String, Object> getSupplyOrderNoAutocomplete(Box box);

	Map<String, Object> getSODetails(Box box);

	Map<String, Object> closePOItem(Box box);
	

	Map<String, Object> generateExcelToVendor(Map<String,Object> map);
	Map<String, Object> generateExcelToVendorSearch(Map<String,Object> map);

	//javed
	
	Map<String, Object> getExpiryDrug(Map<String, Object> map);

	Map<String, Object> getAbcItem(Map<String, Object> requestParameters);

	String getHospitalAddress(int hospitalId);

	Map<String, Object> getResultValue(String po,int hospitalId);

	Map<String, Object> showLPApprovalJsp(Map<String, Object> dataMap);

	Map<String, Object> getSoDetailsForApproval(Box box);

	Map<String, Object> approvePurchaseOrder(Box box);

	Map<String, Object> deletePoDetails(Box box);

	Map<String, Object> getItemListForPurchaseOrderForRC(
			Map<String, Object> dataMap);

	Map<String, Object> getItemListForPurchaseOrderNew(
			Map<String, Object> dataMap1);

	Map<String, Object> getItemListForPurchaseOrderMR(
			Map<String, Object> dataMap1);

	Map<String, Object> getItemListForPurchaseOrderForFAC(
			Map<String, Object> dataMap1);

	/*
	 * boolean addPurchaseOrder(StorePoHeader poHeader,StorePoDetail poDetail);
	 * Map po();
	 */

}
