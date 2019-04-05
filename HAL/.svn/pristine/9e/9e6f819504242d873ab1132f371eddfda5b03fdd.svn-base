/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class DischargeHandlerServiceImpl.java 
 * To feed discharge summary details 
 * Tables Used: discharge_items, discharge_items_category, discharge_summary 
 * @author  Create Date: 11.02.2008 Name: Othivadivel K R 
 * Revision Date:      		Revision By: 
 * @version 1.0  
 * @see DischargeController.java, DischargeHandlerService.java, DischargeDataService.java, DischargeDataServiceImpl.java
 **/

package jkt.hms.discharge.handler;

import java.util.Map;

import jkt.hms.discharge.dataservice.DischargeDataService;
import jkt.hms.util.Box;

public class DischargeHandlerServiceImpl implements DischargeHandlerService {
	DischargeDataService dischargeDataService = null;

	public void setDischargeDataService(
			DischargeDataService dischargeDataService) {
		this.dischargeDataService = dischargeDataService;
	}

	public Map<String, Object> getDischargePatientDetails(int inPatient,Box box) {
		return dischargeDataService.getDischargePatientDetails(inPatient,box);
	}

	public Map<String, Object> getDischargeFields(Map requestParameters) {
		return dischargeDataService.getDischargeFields(requestParameters);
	}

	public Map<String, Object> addDischargeSummary(Map requestDataMap, Box box) {
		return dischargeDataService.addDischargeSummary(requestDataMap,box);
	}

	public Map<String, Object> getDischargeSummaryReportDetails(
			Map requestParameters) {
		return dischargeDataService
				.getDischargeSummaryReportDetails(requestParameters);
	}

	public Map<String, Object> getAdmissionNumberList(Map requestParameters) {
		return dischargeDataService.getAdmissionNumberList(requestParameters);
	}

	public Map<String, Object> getClinicalSheetReportDetails(
			Map<String, Object> requestParameters) {
		// TODO Auto-generated method stub
		return dischargeDataService
				.getClinicalSheetReportDetails(requestParameters);
	}

	public Map<String, Object> getSearchPatientComboDetails(
			Map requestParameters) {
		// TODO Auto-generated method stub
		return dischargeDataService
				.getSearchPatientComboDetails(requestParameters);
	}

	public Map<String, Object> showPatientDiagnosisJsp(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dischargeDataService.showPatientDiagnosisJsp(map);
	}
	@Override
	public String getHospitalName(int hospitalId) {
		return dischargeDataService.getHospitalName(hospitalId);
	}

	@Override
	public Map<String, Object> getClinicalSheetReportDetailsIPD(
			Map<String, Object> requestParameters) {
		return dischargeDataService.getClinicalSheetReportDetailsIPD(requestParameters);
	}
}
