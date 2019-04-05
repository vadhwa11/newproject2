package jkt.hms.stores.handler;

import java.util.Map;

import jkt.hms.stores.dataservice.NonExpendableNewStoresDataService;
import jkt.hms.util.Box;

public class NonExpendableNewStoresHandlerServiceImpl implements
		NonExpendableNewStoresHandlerService {

	// Getters & Setters of Data Service
	NonExpendableNewStoresDataService nonExpendableNewStoresDataService = null;

	public NonExpendableNewStoresDataService getNonExpendableNewStoresDataService() {
		return nonExpendableNewStoresDataService;
	}

	public void setNonExpendableNewStoresDataService(
			NonExpendableNewStoresDataService nonExpendableNewStoresDataService) {
		this.nonExpendableNewStoresDataService = nonExpendableNewStoresDataService;
	}

	public Map<String, Object> updateGridItemsInCondemnation(Box box) {
		return nonExpendableNewStoresDataService
				.updateGridItemsInCondemnation(box);
	}

	// ***************************Condemnation Entry
	// Form***********************************

	public Map showCondemnationJsp(Box box, Map<String, Object> dataMap) {
		return nonExpendableNewStoresDataService.showCondemnationJsp(box,
				dataMap);
	}

	public Map<String, Object> getWorkOrderDetails(Box box) {
		return nonExpendableNewStoresDataService.getWorkOrderDetails(box);
	}

	public Map<String, Object> deleteGridItemsForCondemnation(Box box) {
		return nonExpendableNewStoresDataService
				.deleteGridItemsForCondemnation(box);
	}

	public Map<String, Object> getWorkOrderDataForDisplayGrid(Box box) {
		return nonExpendableNewStoresDataService
				.getWorkOrderDataForDisplayGrid(box);
	}

	public Map<String, Object> searchCondemnation(Box box) {
		return nonExpendableNewStoresDataService.searchCondemnation(box);
	}

	public Map<String, Object> getCondemnationPrintMap(int condemnationId) {
		return nonExpendableNewStoresDataService
				.getCondemnationPrintMap(condemnationId);
	}

	public Map<String, Object> getConnectionForReport() {
		return nonExpendableNewStoresDataService.getConnectionForReport();
	}

	@Override
	public Map<String, Object> saveCondemnationEntry(Box box) {
		// TODO Auto-generated method stub
		return nonExpendableNewStoresDataService.saveCondemnationEntry(box);
	}

}
