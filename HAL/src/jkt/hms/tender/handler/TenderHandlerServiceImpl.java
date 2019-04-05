/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class 
 *  
 * Tables Used:  
 * @author  Create Date:  
 * Revision Date:      		Revision By: 
 * @version 1.0  
 * @see 
 **/

package jkt.hms.tender.handler;

import java.util.Map;

import jkt.hms.tender.dataservice.TenderDataService;
import jkt.hms.util.Box;

public class TenderHandlerServiceImpl implements TenderHandlerService {
	TenderDataService tenderDataService = null;

	public void setTenderDataService(TenderDataService tenderDataService) {
		this.tenderDataService = tenderDataService;
	}

	public Map<String, Object> getMMFGridData(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getMMFGridData(box);
	}

	public Map<String, Object> createTenderMasterAndTransaction(Box box) {
		return tenderDataService.createTenderMasterAndTransaction(box);
	}

	public Map<String, Object> updateGridItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.updateGridItems(box);
	}

	public Map<String, Object> deleteGridItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.deleteGridItems(box);
	}

	public Map<String, Object> getItemDetails(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getItemDetails(box);
	}

	public Map<String, Object> getItemDetailsForNextRecord(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getItemDetailsForNextRecord(box);
	}

	public Map<String, Object> doAddTenderItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.doAddTenderItems(box);
	}

	public Map<String, Object> getInvitationForTenderDetails(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getInvitationForTenderDetails(box);
	}

	public Map<String, Object> getInvitationTenderGridData(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getInvitationTenderGridData(box);
	}

	public Map<String, Object> printInvitationLetter(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.printInvitationLetter(box);
	}

	public Map<String, Object> addInvitationLetterDetails(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.addInvitationLetterDetails(box);
	}

	public Map<String, Object> getLetterContents(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getLetterContents(box);
	}

	public Map<String, Object> showTenderCreationJsp(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.showTenderCreationJsp(box);
	}

	public Map<String, Object> showDocumentForTenderJspWithGridData(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.showDocumentForTenderJspWithGridData(box);
	}

	public Map<String, Object> printTenderDocument(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.printTenderDocument(box);
	}

	public Map<String, Object> showInvitationLetterReport(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.showInvitationLetterReport(box);
	}

	public Map<String, Object> printTenderDocumentReport(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.printTenderDocumentReport(box);
	}

	public Map<String, Object> createScheduleSoftCopy(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.createScheduleSoftCopy(box);
	}

	public Map<String, Object> getGroupAndTenderComboDetails(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getGroupAndTenderComboDetails(box);
	}

	public Map<String, Object> getTenderTechnicalBidGrid(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getTenderTechnicalBidGrid(box);
	}

	public Map<String, Object> getGroupAndTenderAndSupplierComboDetails(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getGroupAndTenderAndSupplierComboDetails(box);
	}

	public Map<String, Object> updateTechnicalBidGridItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.updateTechnicalBidGridItems(box);
	}

	public Map<String, Object> tenderImportCD(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.tenderImportCD(box);
	}

	public Map<String, Object> getGroupAndTenderAndSupplierComboDetailsForCommercialBid(
			Box box) {
		// TODO Auto-generated method stub
		return tenderDataService
				.getGroupAndTenderAndSupplierComboDetailsForCommercialBid(box);
	}

	public Map<String, Object> getTenderCommercialBidGrid(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getTenderCommercialBidGrid(box);
	}

	public Map<String, Object> updateCommBidGridItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.updateCommBidGridItems(box);
	}

	public Map<String, Object> getTenderCommercialMarkingL1(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getTenderCommercialMarkingL1(box);
	}

	public Map<String, Object> getHODRecommendationDetails(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getHODRecommendationDetails(box);
	}

	public Map<String, Object> showTenderLPO(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.showTenderLPO(box);
	}

	public Map<String, Object> getItemListForAutocomplete(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getItemListForAutocomplete(box);
	}

	public Map<String, Object> populateSupplierInTenderLPO(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.populateSupplierInTenderLPO(box);
	}

	public Map<String, Object> addHODRecommendation(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.addHODRecommendation(box);
	}

	public Map<String, Object> generateLocalPurchaseOrder(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.generateLocalPurchaseOrder(box);
	}

	public Map<String, Object> createLPONoteMasterAndTransaction(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.createLPONoteMasterAndTransaction(box);
	}

	public Map<String, Object> getLPOGridData(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getLPOGridData(box);
	}

	public Map<String, Object> deleteLPOGridItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.deleteLPOGridItems(box);
	}

	public Map<String, Object> updateLPOGridItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.updateLPOGridItems(box);
	}

	public Map<String, Object> getConnection(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getConnection(box);
	}

	public Map<String, Object> getGroupAndTenderAndSupplierComboDetailsForPNC(
			Box box) {
		// TODO Auto-generated method stub
		return tenderDataService
				.getGroupAndTenderAndSupplierComboDetailsForPNC(box);
	}

	public Map<String, Object> getTenderPNCGrid(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getTenderPNCGrid(box);
	}

	public Map<String, Object> updatePNCGridItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.updatePNCGridItems(box);
	}

	public Map<String, Object> getItemListForTenderForNomenclatureByAutocomplete(
			Map<String, Object> dataMap) {
		return tenderDataService
				.getItemListForTenderForNomenclatureByAutocomplete(dataMap);

	}

	public Map<String, Object> getConnectionForReport() {
		return tenderDataService.getConnectionForReport();

	}

	public Map<String, Object> doAddTenderProposalItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.doAddTenderProposalItems(box);
	}

	public Map<String, Object> showTenderProposalJsp(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.showTenderProposalJsp(box);
	}

	public Map<String, Object> deleteTenderProposalGridItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.deleteTenderProposalGridItems(box);
	}

	public Map<String, Object> updateTenderProposalGridItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.updateTenderProposalGridItems(box);
	}

	public Map<String, Object> createTenderMasterAndTransactionForProposals(
			Box box) {
		// TODO Auto-generated method stub
		return tenderDataService
				.createTenderMasterAndTransactionForProposals(box);
	}

	public Map<String, Object> getTenderSupplierListForLPO(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getTenderSupplierListForLPO(box);
	}

	public Map<String, Object> showSupplyOrderSplitUp(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.showSupplyOrderSplitUp(box);
	}

	public Map<String, Object> getStoreSetUpData(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getStoreSetUpData(box);
	}

	public Map<String, Object> cancelSupplyOrderItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.cancelSupplyOrderItems(box);
	}

	public Map<String, Object> getTenderSupplierListForReLPO(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getTenderSupplierListForReLPO(box);
	}

	public Map<String, Object> showReSupplyOrderSplitUp(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.showReSupplyOrderSplitUp(box);
	}

	public Map<String, Object> generateReLocalPurchaseOrder(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.generateReLocalPurchaseOrder(box);
	}

	public Map<String, Object> deleteReTenderProposalGridItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.deleteReTenderProposalGridItems(box);
	}

	public Map<String, Object> showReTenderProposalJsp(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.showReTenderProposalJsp(box);
	}

	public Map<String, Object> updateReTenderProposalGridItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.updateReTenderProposalGridItems(box);
	}

	public Map<String, Object> getReTenderItemDetails(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getReTenderItemDetails(box);
	}

	public Map<String, Object> doAddReTenderProposalItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.doAddReTenderProposalItems(box);
	}

	public Map<String, Object> getReTenderSupplierListForLPO(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getReTenderSupplierListForLPO(box);
	}

	public Map<String, Object> showReTenderSupplyOrderSplitUp(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.showReTenderSupplyOrderSplitUp(box);
	}

	public Map<String, Object> generateReTenderLocalPurchaseOrder(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.generateReTenderLocalPurchaseOrder(box);
	}

	public Map<String, Object> cancelReTenderSupplyOrderItems(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.cancelReTenderSupplyOrderItems(box);
	}

	public Map<String, Object> getReTenderSupplierListForReLPO(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getReTenderSupplierListForReLPO(box);
	}

	public Map<String, Object> showReTenderReSupplyOrderSplitUp(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.showReTenderReSupplyOrderSplitUp(box);
	}

	public Map<String, Object> generateReTenderReLocalPurchaseOrder(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.generateReTenderReLocalPurchaseOrder(box);
	}

	public Map<String, Object> showPvmsNomencaltureSearchJsp(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.showPvmsNomencaltureSearchJsp(box);
	}

	public Map<String, Object> getImportProposals(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return tenderDataService.getImportProposals(dataMap);
	}

	public Map<String, Object> getTenderSupplierListForLPNote(Box box) {
		return tenderDataService.getTenderSupplierListForLPNote(box);
	}

	public Map<String, Object> searchForExistingNomenclature(Box box) {
		return tenderDataService.searchForExistingNomenclature(box);
	}

	public Map<String, Object> showSupplyOrderSplitUpForLpoNote(Box box) {
		return tenderDataService.showSupplyOrderSplitUpForLpoNote(box);
	}

	public Map<String, Object> generateLocalPurchaseOrderForLpoNote(Box box) {
		return tenderDataService.generateLocalPurchaseOrderForLpoNote(box);
	}

	public Map<String, Object> getSuppliersListByAutocomplete(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return tenderDataService.getSuppliersListByAutocomplete(dataMap);
	}

	public Map<String, Object> getDocumentForTenderDetails(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getDocumentForTenderDetails(box);
	}

	public Map<String, Object> getItemId(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getItemId(box);
	}

	public Map<String, Object> getGroupAndTenderComboDetailsForProposal(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getGroupAndTenderComboDetailsForProposal(box);
	}

	public Map<String, Object> getSupplyOrderDetail(String soNo, int dept) {
		// TODO Auto-generated method stub
		return tenderDataService.getSupplyOrderDetail(soNo, dept);
	}

	public Map<String, Object> getExcelSheetDataForVendor(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getExcelSheetDataForVendor(box);
	}

	public boolean importLastTenderProposal(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.importLastTenderProposal(box);
	}

	public Map<String, Object> getTenders(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getTenders(box);
	}

	public Map<String, Object> getTenderDetailsForCosting(Box box) {
		// TODO Auto-generated method stub
		return tenderDataService.getTenderDetailsForCosting(box);
	}
	public Map<String, Object> cancelSupplyOrderItemsForLpoNote(Box box) {
		return tenderDataService.cancelSupplyOrderItemsForLpoNote(box);
	}
	
}
