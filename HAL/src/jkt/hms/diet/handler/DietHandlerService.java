package jkt.hms.diet.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasDietIndentItem;
import jkt.hms.util.Box;

public interface DietHandlerService {

	/**
	 * --------------------------- Methods for Menu Item Formula
	 * -----------------------------------
	 * 
	 */

	Map<String, Object> showMenuItemFormulaJsp();

	Map<String, Object> addMenuItemFormula(Box box);

	Map<String, Object> editMenuItemFormula(Box box);

	Map<String, Object> deleteMenuItemFormula(Box box);

	Map<String, Object> searchMenuItemFormula(Box box);

	/**
	 * --------------------------- Methods for Extra Item Formula
	 * -----------------------------------
	 * 
	 */

	Map<String, Object> showExtraItemFormulaJsp();

	Map<String, Object> addExtraItemFormula(Box box);

	Map<String, Object> editExtraItemFormula(Box box);

	Map<String, Object> deleteExtraItemFormula(Box box);

	Map<String, Object> searchExtraItemFormula(Box box);

	/**
	 * --------------------------- Methods for Indent Item Formula
	 * -----------------------------------
	 * 
	 */

	Map<String, Object> showIndentItemFormulaJsp();

	Map<String, Object> addIndentItemFormula(Box box);

	Map<String, Object> editIndentItemFormula(Box box);

	Map<String, Object> deleteIndentItemFormula(Box box);

	Map<String, Object> searchIndentItemFormula(Box box);

	/**
	 * --------------------------- Methods for Patient Diet Change
	 * -----------------------------------
	 * 
	 */

	Map<String, Object> getPatientListForDietChange(int departmentId);

	Map<String, Object> searchDietDetails(Box box);

	Map<String, Object> updatePatientDietDetails(Map<String, Object> infoMap);

	Map<String, Object> getDetailsForDailyDietExtraRequ(
			Map<String, Object> infoMap);

	Map<String, Object> saveDailyDietDetails(Box box);

	Map<String, Object> getDetailsForInternalDemand();

	List<MasDietIndentItem> getItemsForGrid(String rationType);

	Map<String, Object> saveInternalDemandRationDetails(Box box);

	Map<String, Object> getDetailsForBreakfastSummary();

	Map<String, Object> getItemQtyForBreakfast(int breakfastItemId);

	Map<String, Object> saveBreakastDistributionDetails(Box box);

	Map<String, Object> getConnectionForReport();

	String getDepartmentName(int departmentId);

	Map<String, Object> updateDietDetailsForDailyDiet(
			Map<String, Object> infoMap);

	void callProcedureFordailyDietSheet(Box box);
}
