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

package jkt.hms.tender.dataservice;

import java.util.Map;

import jkt.hms.util.Box;

public interface TenderDataService {

	Map<String, Object> getMMFGridData(Box box);

	Map<String, Object> createTenderMasterAndTransaction(Box box);

	Map<String, Object> updateGridItems(Box box);

	Map<String, Object> deleteGridItems(Box box);

	Map<String, Object> getItemDetails(Box box);

	Map<String, Object> getItemDetailsForNextRecord(Box box);

	Map<String, Object> doAddTenderItems(Box box);

	Map<String, Object> getInvitationForTenderDetails(Box box);

	Map<String, Object> getInvitationTenderGridData(Box box);

	Map<String, Object> printInvitationLetter(Box box);

	Map<String, Object> addInvitationLetterDetails(Box box);

	Map<String, Object> getLetterContents(Box box);

	Map<String, Object> showTenderCreationJsp(Box box);

	Map<String, Object> showDocumentForTenderJspWithGridData(Box box);

	Map<String, Object> printTenderDocument(Box box);

	Map<String, Object> showInvitationLetterReport(Box box);

	Map<String, Object> printTenderDocumentReport(Box box);

	Map<String, Object> createScheduleSoftCopy(Box box);

	Map<String, Object> getGroupAndTenderComboDetails(Box box);

	Map<String, Object> getTenderTechnicalBidGrid(Box box);

	Map<String, Object> getGroupAndTenderAndSupplierComboDetails(Box box);

	Map<String, Object> updateTechnicalBidGridItems(Box box);

	Map<String, Object> tenderImportCD(Box box);

	Map<String, Object> getGroupAndTenderAndSupplierComboDetailsForCommercialBid(
			Box box);

	Map<String, Object> getTenderCommercialBidGrid(Box box);

	Map<String, Object> updateCommBidGridItems(Box box);

	Map<String, Object> getTenderCommercialMarkingL1(Box box);

	Map<String, Object> getHODRecommendationDetails(Box box);

	Map<String, Object> showTenderLPO(Box box);

	Map<String, Object> getItemListForAutocomplete(Box box);

	Map<String, Object> populateSupplierInTenderLPO(Box box);

	Map<String, Object> addHODRecommendation(Box box);

	Map<String, Object> generateLocalPurchaseOrder(Box box);

	Map<String, Object> createLPONoteMasterAndTransaction(Box box);

	Map<String, Object> getLPOGridData(Box box);

	Map<String, Object> deleteLPOGridItems(Box box);

	Map<String, Object> updateLPOGridItems(Box box);

	Map<String, Object> getConnection(Box box);

	Map<String, Object> getGroupAndTenderAndSupplierComboDetailsForPNC(Box box);

	Map<String, Object> getTenderPNCGrid(Box box);

	Map<String, Object> updatePNCGridItems(Box box);

	public Map<String, Object> getTenderSupplierListForLPNote(Box box);

	public Map<String, Object> searchForExistingNomenclature(Box box);

	Map<String, Object> getItemListForTenderForNomenclatureByAutocomplete(
			Map<String, Object> dataMap);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> doAddTenderProposalItems(Box box);

	Map<String, Object> showTenderProposalJsp(Box box);

	Map<String, Object> deleteTenderProposalGridItems(Box box);

	Map<String, Object> updateTenderProposalGridItems(Box box);

	Map<String, Object> createTenderMasterAndTransactionForProposals(Box box);

	Map<String, Object> getTenderSupplierListForLPO(Box box);

	Map<String, Object> showSupplyOrderSplitUp(Box box);

	Map<String, Object> getStoreSetUpData(Box box);

	Map<String, Object> cancelSupplyOrderItems(Box box);

	Map<String, Object> getTenderSupplierListForReLPO(Box box);

	Map<String, Object> showReSupplyOrderSplitUp(Box box);

	Map<String, Object> generateReLocalPurchaseOrder(Box box);

	Map<String, Object> deleteReTenderProposalGridItems(Box box);

	Map<String, Object> showReTenderProposalJsp(Box box);

	Map<String, Object> updateReTenderProposalGridItems(Box box);

	Map<String, Object> getReTenderItemDetails(Box box);

	Map<String, Object> doAddReTenderProposalItems(Box box);

	Map<String, Object> getReTenderSupplierListForLPO(Box box);

	Map<String, Object> showReTenderSupplyOrderSplitUp(Box box);

	Map<String, Object> generateReTenderLocalPurchaseOrder(Box box);

	Map<String, Object> cancelReTenderSupplyOrderItems(Box box);

	Map<String, Object> getReTenderSupplierListForReLPO(Box box);

	Map<String, Object> showReTenderReSupplyOrderSplitUp(Box box);

	Map<String, Object> generateReTenderReLocalPurchaseOrder(Box box);

	Map<String, Object> showPvmsNomencaltureSearchJsp(Box box);

	Map<String, Object> getImportProposals(Map<String, Object> dataMap);

	public Map<String, Object> showSupplyOrderSplitUpForLpoNote(Box box);

	public Map<String, Object> generateLocalPurchaseOrderForLpoNote(Box box);

	Map<String, Object> getSuppliersListByAutocomplete(
			Map<String, Object> dataMap);

	Map<String, Object> getDocumentForTenderDetails(Box box);

	Map<String, Object> getItemId(Box box);

	Map<String, Object> getGroupAndTenderComboDetailsForProposal(Box box);

	Map<String, Object> getSupplyOrderDetail(String soNo, int dept);

	Map<String, Object> getExcelSheetDataForVendor(Box box);

	boolean importLastTenderProposal(Box box);

	Map<String, Object> getTenders(Box box);

	Map<String, Object> getTenderDetailsForCosting(Box box);
	public Map<String , Object> cancelSupplyOrderItemsForLpoNote(Box box);
}
