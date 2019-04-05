package jkt.hms.masters.dataservice;

import java.util.Map;

import jkt.hms.masters.business.MasDietCombination;
import jkt.hms.masters.business.MasDietItems;
import jkt.hms.masters.business.MasDietType;
import jkt.hms.util.Box;

public interface CanteenMasterDataService {

	// -----------------------------Diet Master-----------------------

	Map<String, Object> addDiet(Map<String, Object> generalMap);

	Map<String, Object> editDietToDatabase(Map<String, Object> generalMap);

	boolean deleteDiet(int dietId, Map<String, Object> generalMap);

	Map<String, Object> searchDiet(String dietCode, String dietName);

	Map<String, Object> showDietJsp();

	// --------------------------Diet Type---------------------------------
	Map<String, Object> showDietTypeJsp();

	Map<String, Object> searchDietType(String dietTypeCode, String dietTypeName);

	boolean addDietType(MasDietType masDietType);

	boolean deleteDietType(int dietTypeId, Map<String, Object> generalMap);

	boolean editDietTypeToDatabase(Map<String, Object> generalMap);

	// ------------------------Diet Items---------------------------------
	boolean deleteDietItems(int dietItemsId, Map<String, Object> generalMap);

	boolean editDietItemsToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchDietItems(String dietItemsCode,
			String dietItemsName);

	Map<String, Object> showDietItemsJsp();

	boolean addDietItems(MasDietItems masDietItems);

	// --------------------Diet Diet Type---------------------------------------

	Map<String, Object> addDietCombination(MasDietCombination masDietCombination);

	Map<String, Object> deleteDietCombination(int dietDietTypeId,
			Map<String, Object> generalMap);

	Map<String, Object> editDietCombination(Map<String, Object> generalMap);

	Map<String, Object> showDietCombinationJsp();

	Map<String, Object> searchDietCombination(String dietName);

	// -------------------------Diet Menu
	// Item---------------------------------------

	Map<String, Object> showDietMenuItemJsp();

	Map<String, Object> addDietMenuItem(Box box);

	Map<String, Object> deleteDietMenuItem(Box box);

	Map<String, Object> searchDietMenuItem(Box box);

	// --------------------------- Diet Indent Item
	// --------------------------------

	Map<String, Object> showDietIndentItemJsp();

	Map<String, Object> addDietIndentItem(Box box);

	Map<String, Object> editDietIndentItem(Box box);

	boolean deleteDietIndentItem(Box box);

	Map<String, Object> searchDietIndentItem(Box box);

}