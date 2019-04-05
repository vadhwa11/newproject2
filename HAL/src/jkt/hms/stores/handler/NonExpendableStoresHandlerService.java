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
import jkt.hms.util.Box;

import com.lowagie.text.pdf.codec.postscript.ParseException;

public interface NonExpendableStoresHandlerService {

	Map<String, Object> showNeGrnJsp(Box box, Map<String, Object> dataMap);

	boolean addGrns(Map<String, Object> infoMap);

	Map<String, Object> getListForNeGrn(String choice);

	Map<String, Object> getSupplierListForNeGrn(Map<String, Object> dataMap);

	Map<String, Object> getResponseIndentList(Box box);

	Map<String, Object> showGridJsp(Box box);

	Map<String, Object> fillItemsForGrn(Map<String, Object> dataMap);

	Map<String, Object> getItemListForGrnByAutocomplete(
			Map<String, Object> dataMap);

	Map<String, Object> showNeLoanInJsp(Box box, Map<String, Object> dataMap);

	Map<String, Object> searchGrn(Map<String, Object> searchFieldMap)
			throws ParseException;

	Map<String, Object> modifyGrn(int id, int pageNo);

	List<StoreGrnM> getCrvNumberList(Map<String, Object> dataMap);

	Map<String, Object> fillItemsForLoanIn(Map<String, Object> dataMap);

	Map<String, Object> getItemListForLoanInByAutocomplete(
			Map<String, Object> dataMap);

	boolean addLoanIn(Map<String, Object> infoMap);

	Map<String, Object> showWorkOrderJsp(Box box, Map<String, Object> dataMap);

	Map<String, Object> fillItemsForWorkOrder(Map<String, Object> dataMap);

	Map<String, Object> getItemListForWorkOrderByAutocomplete(
			Map<String, Object> dataMap);

	boolean addWorkOrder(Map<String, Object> infoMap);
	boolean updateGridItemsBos(Box box);

	//Map<String, Object> getWorkOrderModify(int workOrderId, int pageNo);

	List<StoreWorkOrderM> getWorkOrderList();

	Map<String, Object> getConnectionForReport();

	Map<String, Object> searchLoanin(Map<String, Object> searchFieldMap)
			throws ParseException;

	Map<String, Object> modifyLoanin(int id, int pageNo);

	List<StoreLoaninM> getloanList(Map<String, Object> dataMap);

	List<StoreGrnT> getStoreGrnTListForMoreInfo(int storeGrnTId);

	List<StoreLoaninT> getLoanInListForMoreInfo(int loaninDetailId);

	Map<String, Object> showWorkRegisterReportJsp();
	Map<String, Object> showAmcMaintenanceJsp(Box box);

	List getSupplierList();

	List getAmcMList();

	List getRepairNoList();

	Map getNomenclature(int departmentId);

	Map getPvmsNoAndGetSerialNo(int nomenclatureId);

	Map getSerialNoDetails(String serialNo, int itemid);

	Map getAmcRepairDetails(int nomenclatureId, String repairNO);

	Map getAmcSearchResult(Map searchFieldMap);

	public List getRepairNo();

	public List getDocEntryNo();

	public List getStoreAmcT(int id);

	boolean addAmcMDetailsandaddAmcTDetails(StoreAmcM storeAmcM,
			List<StoreAmcT> storeList) throws Exception;

	Map addStoreRepairCivilFirm(StoreRepairCivilFirm storeRepairCivilFirm)
			throws Exception;

	Map updateStoreRepairCivilFirm(StoreRepairCivilFirm storeRepairCivilFirm)
			throws Exception;

	Map showBoardOfSurvey();

	Map createAndImportBosData(Box box);

	
	Map searchBosData(String BosNo, Box box);

	Map updateSearchGridItemsBos(Box box);

	Map getBosData(Box box);

	Map<String, Object> getMeScaleDescription(int meScaleNumber, Box box);

	Map<String, Object> updateGridItemsInViewMeScale(Box box);

	Map<String, Object> getMeScaleData(Box box);

	Map<String, Object> searchItemsForMEScale(Box box);

	Map<String, Object> addItemToMeScale(Box box);

	Map<String, Object> deleteMeScaleItems(Box box);

	Map<String, Object> viewMeScaleJsp();
	Map<String, Object> getItemListForGrnByAutocompleteForNnExpendableGrn(
			Map<String, Object> dataMap);
	Map<String, Object> getindenList(int indentId);
	Map<String, Object> getPoList(int poId);
	Map<String, Object> showInstallationCertificate(Map<String, Object> dataMap);
	Map<String, Object> responseNomenclature(Map<String, Object> dataMap);
	Map<String, Object> updateInstallationDate(Map<String, Object> dataMap);
	Map<String, Object> showInitialDeficiencyIndentJspDepot(Map<String, Object> dataMap);
	Map<String, Object> fillItemsForIndentToDepot(Map<String, Object> dataMap);
	int countNo(String workOrderNo);
	
	/*************** Method For Repair Station  ****************************/
	
	Map<String,Object>showRepairStationJsp(Map dataMap);

	Map getWorkOrderModify(Map<String, Object> infoMap);

	Map<String, Object> showNonPurchaseOrderJsp(Map<String, Object> dataMap);

	List<StorePoHeader> getPoNumberList(int deptId, int hospitalId);

	int getPurchaseOrderId(String poNumber, int hospitalId);

	String getnextPurchaseOrder(String poNumber, int departmentId);

	Map<String, Object> submitNonPurchaseOrder(Map<String, Object> infoMap);

	List<StorePoHeader> getPoHeader(int poId);

	Map<String, Object> fillItemsForNonLpo(Map<String, Object> dataMap);

	Map<String, Object> getItemListNonSupplyOrder(Map<String, Object> dataMap);

	Map getViewAllMap(int hospitalId);

	Map<String, Object> searchPO(Map<String, Object> searchFieldMap);

	Map<String, Object> poModifyMap(int poDetailId, int pageNo,
			String buttonFlag);

	boolean updatePurchaseOrder(Map<String, Object> infoMap);

	Map<String, Object> deletePurchaseOrderItem(Box box);

	boolean updateWorkOrder(Map<String, Object> infoMap);
	StoreWorkOrderM loadWorkOrderObj(int workOrderId);
	String getPoNumber(int poId);

	String getHospitalName(int hospitalId);

	String getHospitalAddress(int hospitalId);
// add by javed khan
	Map<String, Object> getListForNeGrn1(String choice, int hospitalId);

	Map<String, Object> getManuList();

	Map<String, Object> showIndentToDepoNe(Map<String, Object> dataMap);

	Map<String, Object> getItemListForIndentToDepot(Map<String, Object> dataMap);

	Map addNextOrSubmitIndentToDepot(Map<String, Object> dataMap);

	Map<String, Object> generateExcelForDepotNe(
			Map<String, Object> requestParameters);

	Map<String, Object> newSearchIndentNe(Map<String, Object> searchFieldMap);
	Map<String,Object> getItemListForDefectiveDrugsByAutocomplete(Map<String,Object> dataMap);
	Map<String,Object> fillItemsForDefectiveDrugs(Map<String,Object> dataMap);
	Map<String,Object> getItemListForIssueToDispensary(Map<String,Object> dataMap);
	Map<String,Object> fillItemsForIssueToDispensary(Map<String,Object> dataMap);
	boolean submitMeScale(Map<String,Object> dataMap);
	Map<String, Object> getItemListForCondemnationByAutocomplete(
			Map<String, Object> dataMap);

	Map<String, Object> getItemListForBoardOfSurveyAutocom(
			Map<String, Object> dataMap);

	Map<String, Object> getItemListForEquipmentLoanOut(
			Map<String, Object> dataMap);

	Map<String, Object> fillItemsForEquipmentLoanOut(Map<String, Object> dataMap);

	Map addBrandDetailsForEquipLoanOut(Box box);
	
	// add by Mansi Gagrani Jain
	List<StoreBosM> printBOSJsp();
	
	Map searchEquipmentLoanOut(Box box);
}
