/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class DischargeDataService.java 
 * To feed discharge summary details 
 * Tables Used: discharge_items, discharge_items_category, discharge_summary 
 * @author  Create Date: 11.02.2008 Name: Othivadivel K R 
 * Revision Date:      		Revision By: 
 * @version 1.0  
 * @see DischargeController.java, DischargeHandlerService.java, DischargeHandlerServiceImpl.java, DischargeDataServiceImpl.java
 **/

package jkt.hms.discharge.dataservice;

import java.util.Map;

import jkt.hms.util.Box;

public interface DischargeDataService {
	Map<String, Object> getDischargePatientDetails(int inPatient, Box box);

	Map<String, Object> getDischargeFields(Map requestParameters);

	Map<String, Object> addDischargeSummary(Map requestDataMap, Box box);

	Map<String, Object> getDischargeSummaryReportDetails(Map requestParameters);

	Map<String, Object> getAdmissionNumberList(Map requestParameters);

	Map<String, Object> getClinicalSheetReportDetails(
			Map<String, Object> requestParameters);

	Map<String, Object> getSearchPatientComboDetails(Map requestParameters);

	Map<String, Object> showPatientDiagnosisJsp(Map<String, Object> map);

	String getHospitalName(int hospitalId);
	
	Map<String, Object> getClinicalSheetReportDetailsIPD(Map<String, Object> requestParameters);
}
