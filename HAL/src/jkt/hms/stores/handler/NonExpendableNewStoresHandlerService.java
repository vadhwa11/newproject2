package jkt.hms.stores.handler;

import java.util.Map;

import jkt.hms.util.Box;

public interface NonExpendableNewStoresHandlerService {

	Map<String, Object> showCondemnationJsp(Box box, Map<String, Object> dataMap);

	Map<String, Object> getWorkOrderDetails(Box box);

	Map<String, Object> getWorkOrderDataForDisplayGrid(Box box);

	Map<String, Object> deleteGridItemsForCondemnation(Box box);

	Map<String, Object> updateGridItemsInCondemnation(Box box);

	Map<String, Object> searchCondemnation(Box box);

	Map<String, Object> getCondemnationPrintMap(int condemnationId);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> saveCondemnationEntry(Box box);

}
