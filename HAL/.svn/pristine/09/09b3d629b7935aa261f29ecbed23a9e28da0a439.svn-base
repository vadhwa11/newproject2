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

package jkt.hms.cssd.handler;

import java.util.Map;

import jkt.hms.masters.business.CssdInstrumentMaster;
import jkt.hms.masters.business.CssdMaterialMaster;
import jkt.hms.util.Box;

public interface CssdHandlerService {

	public String generateBatchNo(String userName);

	Map<String, Object> showInstrumentMasterJsp(Box box);

	boolean addInstrumentMaster(CssdInstrumentMaster cssdInstrumentMaster);

	Map<String, Object> checkForExistingMasters(Map<String, Object> generalMap);

	Map<String, Object> searchInstrumentMaster(Map<String, Object> map);

	boolean editInstrumentMaster(Map<String, Object> generalMap);

	boolean deleteInstrumentMaster(Map<String, Object> generalMap);

	Map<String, Object> showMaterialStockEntryJsp(Box box);

	Map<String, Object> getMaterialNamesForAutocomplete(
			Map<String, Object> dataMap);

	Map<String, Object> addAndRefreshGrid(Box box);

	Map<String, Object> getStockGridData(Box box);

	Map<String, Object> showAutoclaveRequestJsp(Box box);

	Map<String, Object> getAutoclaveRequestMaterialNamesForAutocomplete(
			Map<String, Object> dataMap);

	Map<String, Object> addAndRefreshAutoclaveRequestGrid(Box box);

	Map<String, Object> getAutoclaveRequestStockGridData(Box box);

	Map<String, Object> showAutoclaveEntryJsp(Box box);

	Map<String, Object> showAutoclaveEntryDetailJsp(Box box);

	Map<String, Object> getAutoclaveRequestEntryGridDataForAutoclaveEntry(
			Box box);

	Map<String, Object> submitEntryDetails(Box box);

	Map<String, Object> deleteCssdEntryGridItems(Box box);

	Map<String, Object> showMaterialMasterJsp(Box box);

	Map<String, Object> searchMaterialMaster(Map<String, Object> map);

	boolean editMaterialMaster(Map<String, Object> generalMap);

	boolean deleteMaterialMaster(Map<String, Object> generalMap);

	boolean addMaterialMaster(CssdMaterialMaster cssdMaterialMaster);

	Map<String, Object> showAutoclaveReceiptJsp(Box box);

	Map<String, Object> addAndRefreshAutoclaveReceiptGrid(Box box);

	Map<String, Object> getAutoclaveReceiptStockGridData(Box box);

	Map<String, Object> updateAutoclaveReceiptGridData(Box box);

	Map<String, Object> getAutoclaveRecallGridData(Box box);

	Map<String, Object> updateAutoclaveRecallGridData(Box box);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> showAutoclaveMaterialList(Box box);
}
