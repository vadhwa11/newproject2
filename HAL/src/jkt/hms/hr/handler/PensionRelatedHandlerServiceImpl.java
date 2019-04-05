package jkt.hms.hr.handler;

import java.util.Map;

import jkt.hms.hr.dataservice.PensionRelatedDataService;
import jkt.hms.util.Box;

public class PensionRelatedHandlerServiceImpl implements
		PensionRelatedHandlerService {

	PensionRelatedDataService pensionRelatedDataService = null;

	public PensionRelatedDataService getPensionRelatedDataService() {
		return pensionRelatedDataService;
	}

	public void setPensionRelatedDataService(
			PensionRelatedDataService pensionRelatedDataService) {
		this.pensionRelatedDataService = pensionRelatedDataService;
	}

	// -------------------------------------------------------------------------
	public Map<String, Object> showPersonnelEntryDetailsJsp() {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.showPersonnelEntryDetailsJsp();
	}

	public Map<String, Object> submitPersonnelEntryDetailsJsp(Box box,
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.submitPersonnelEntryDetailsJsp(box,
				dataMap);
	}

	public Map<String, Object> showPersonnelSearchJsp(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.showPersonnelSearchJsp(dataMap);
	}

	public Map<String, Object> showUpdatePersonnelSearchJsp(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.showUpdatePersonnelSearchJsp(dataMap);
	}

	public Map<String, Object> updatePersonnelEntryDetailsJsp(Box box,
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.updatePersonnelEntryDetailsJsp(box,
				dataMap);
	}

	public Map<String, Object> getDataForPersonnelSearchJsp() {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.getDataForPersonnelSearchJsp();
	}

	public Map<String, Object> showPersonnelDetailsForCalculationSheet(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService
				.showPersonnelDetailsForCalculationSheet(dataMap);
	}

	public boolean submitCalculationSheetDetails(Box box,
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.submitCalculationSheetDetails(box,
				dataMap);
	}

	public Map<String, Object> showUpdatePersonnelSearchForCalculationSheet(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService
				.showUpdatePersonnelSearchForCalculationSheet(dataMap);
	}

	public Map<String, Object> showUpdateCalculationSheet(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.showUpdateCalculationSheet(dataMap);
	}

	public boolean updateCalculationSheet(Box box, Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.updateCalculationSheet(box, dataMap);
	}

	public boolean submitDataSheetJsp(Box box) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.submitDataSheetJsp(box);
	}

	public Map<String, Object> showUpdatePersonnelSearchForDataSheet(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService
				.showUpdatePersonnelSearchForDataSheet(dataMap);
	}

	public Map<String, Object> showUpdateDataSheet(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.showUpdateDataSheet(dataMap);
	}

	public boolean updateDataSheet(Box box) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.updateDataSheet(box);
	}

	public Map<String, Object> showPersonnelDetailsForForm7Entry(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService
				.showPersonnelDetailsForForm7Entry(dataMap);
	}

	public boolean submitForm7Entry(Box box, Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.submitForm7Entry(box, dataMap);
	}

	public Map<String, Object> showPersonnelSearchForUpdatePersonnelAndForm7Jsp(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService
				.showPersonnelSearchForUpdatePersonnelAndForm7Jsp(dataMap);
	}

	public Map<String, Object> showUpdatePersonnelSearchForForm7(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService
				.showUpdatePersonnelSearchForForm7(dataMap);
	}

	public Map<String, Object> showUpdateForm7Jsp(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.showUpdateForm7Jsp(dataMap);
	}

	public boolean updateForm7Entry(Box box, Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.updateForm7Entry(box, dataMap);
	}

	public Map<String, Object> showPersonnelDetailsForForm8Entry(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService
				.showPersonnelDetailsForForm8Entry(dataMap);
	}

	public boolean submitForm8Entry(Box box) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.submitForm8Entry(box);
	}

	public Map<String, Object> showUpdateForm8Jsp(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.showUpdateForm8Jsp(dataMap);
	}

	public boolean updateForm8Entry(Box box) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.updateForm8Entry(box);
	}

	public boolean submitRetirementEntryForm(Box box) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.submitRetirementEntryForm(box);
	}

	public Map<String, Object> showUpdateRetirementForm(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.showUpdateRetirementForm(dataMap);
	}

	public boolean updateRetirementEntryForm(Box box) {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.updateRetirementEntryForm(box);
	}
	
	public Map<String , Object> EmployeeExist(String passNo, int unitId) {
		return pensionRelatedDataService.EmployeeExist(passNo, unitId);
	}

	// --------------------nidhi--------------------
	public Map<String, Object> getConnectionForReport() {
		// TODO Auto-generated method stub
		return pensionRelatedDataService.getConnectionForReport();
	}
	public Map<String, Object> fillRetier(Map<String, Object> dataMap) {
		return pensionRelatedDataService.fillRetier(dataMap);
	}

}
