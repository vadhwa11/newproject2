package jkt.hms.hr.dataservice;

import java.util.Map;

import jkt.hms.util.Box;

public interface PensionRelatedDataService {

	Map<String, Object> showPersonnelEntryDetailsJsp();

	Map<String, Object> submitPersonnelEntryDetailsJsp(Box box, Map<String, Object> dataMap);

	Map<String, Object> showPersonnelSearchJsp(Map<String, Object> dataMap);

	Map<String, Object> showUpdatePersonnelSearchJsp(Map<String, Object> dataMap);

	Map<String, Object> updatePersonnelEntryDetailsJsp(Box box, Map<String, Object> dataMap);

	Map<String, Object> getDataForPersonnelSearchJsp();

	Map<String, Object> showPersonnelDetailsForCalculationSheet(
			Map<String, Object> dataMap);

	boolean submitCalculationSheetDetails(Box box, Map<String, Object> dataMap);

	Map<String, Object> showUpdatePersonnelSearchForCalculationSheet(
			Map<String, Object> dataMap);

	Map<String, Object> showUpdateCalculationSheet(Map<String, Object> dataMap);

	boolean updateCalculationSheet(Box box, Map<String, Object> dataMap);

	boolean submitDataSheetJsp(Box box);

	Map<String, Object> showUpdatePersonnelSearchForDataSheet(
			Map<String, Object> dataMap);

	Map<String, Object> showUpdateDataSheet(Map<String, Object> dataMap);

	boolean updateDataSheet(Box box);

	Map<String, Object> showPersonnelDetailsForForm7Entry(
			Map<String, Object> dataMap);

	boolean submitForm7Entry(Box box, Map<String, Object> dataMap);

	Map<String, Object> showPersonnelSearchForUpdatePersonnelAndForm7Jsp(
			Map<String, Object> dataMap);

	Map<String, Object> showUpdatePersonnelSearchForForm7(
			Map<String, Object> dataMap);

	Map<String, Object> showUpdateForm7Jsp(Map<String, Object> dataMap);

	boolean updateForm7Entry(Box box, Map<String, Object> dataMap);

	Map<String, Object> showPersonnelDetailsForForm8Entry(
			Map<String, Object> dataMap);

	boolean submitForm8Entry(Box box);

	Map<String, Object> showUpdateForm8Jsp(Map<String, Object> dataMap);

	boolean updateForm8Entry(Box box);

	boolean submitRetirementEntryForm(Box box);

	Map<String, Object> showUpdateRetirementForm(Map<String, Object> dataMap);

	boolean updateRetirementEntryForm(Box box);
	
	public Map<String , Object> EmployeeExist(String passNo, int unitId) ;

	// -------------------nidhi--------------------

	Map<String, Object> getConnectionForReport();
	Map<String, Object> fillRetier(Map<String, Object> dataMap);
}
