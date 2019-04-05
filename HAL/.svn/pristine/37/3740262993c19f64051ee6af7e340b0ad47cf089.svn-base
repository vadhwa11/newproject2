/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class DischargeController.java 
 * To feed discharge summary details 
 * Tables Used: discharge_items, discharge_items_category, discharge_summary 
 * @author  Create Date: 11.02.2008  Name: Othivadivel K R 
 * Revision Date:      		Revision By: 
 * @version 1.0  
 * @see DischargeHandlerService.java, DischargeHandlerServiceImpl.java, DischargeDataService.java, DischargeDataServiceImpl.java
 **/

package jkt.hms.discharge.controller;

import static jkt.hms.util.RequestConstants.ADMISSION_NUMBER;
import static jkt.hms.util.RequestConstants.CLINICAL_SHEET_REPORT_SCREEN;
import static jkt.hms.util.RequestConstants.DISCHARGE_DETAILS_INPUT_JSP;
import static jkt.hms.util.RequestConstants.DISCHARGE_FIELDS_DISPLAY_JSP;
import static jkt.hms.util.RequestConstants.DISCHARGE_SUMMARY_GENERAL_REPORT;
import static jkt.hms.util.RequestConstants.DISCHARGE_SUMMARY_GYNA_REPORT;
import static jkt.hms.util.RequestConstants.DISCHARGE_SUMMARY_NABH_REPORT;
import static jkt.hms.util.RequestConstants.DISCHARGE_SUMMARY_PEDIA_REPORT;
import static jkt.hms.util.RequestConstants.DISCHARGE_SUMMARY_REPORT_SCREEN;
import static jkt.hms.util.RequestConstants.FILE_NAME;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.MESSAGE_FOR_DISCHARGE_SUMMARY;
import static jkt.hms.util.RequestConstants.OUTPUT_TO;
import static jkt.hms.util.RequestConstants.PATIENT_DIAGNOSIS_JSP;
import static jkt.hms.util.RequestConstants.SERVICE_NO;

import java.sql.Connection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.discharge.handler.DischargeHandlerService;
import jkt.hms.ipd.handler.IPDHandlerService;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class DischargeController extends MultiActionController {

	DischargeHandlerService dischargeHandlerService = null;
	IPDHandlerService ipdHandlerService = null;
	String jsp = "";
	String title = "";
	String userName = null;
	String message = null;
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = null;

	public ModelAndView showDischargeInputJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int inPatient = 0;
		if (request.getParameter("parent") != null
				&& request.getParameter("parent") != "") {
			inPatient = Integer.parseInt(request.getParameter("parent"));
		}
		Box box = HMSUtil.getBox(request);
		box.put("box", box);
		box.put(HOSPITAL_ID, (Integer)session.getAttribute("hospitalId"));
		Map<String, Object> map = new HashMap<String, Object>();
		map = dischargeHandlerService.getDischargePatientDetails(inPatient,box);
		jsp = DISCHARGE_DETAILS_INPUT_JSP;
		jsp += ".jsp";
		title = "Discharge Details Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView displayDischargeFields(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		if (request.getParameter("casetype") != null
				&& request.getParameter("casetype") != "") {
			requestParameters.put("casetype", request.getParameter("casetype"));
		}

		if (request.getParameter(ADMISSION_NUMBER) != null
				&& request.getParameter(ADMISSION_NUMBER) != "") {
			requestParameters.put(ADMISSION_NUMBER, request
					.getParameter(ADMISSION_NUMBER));
		}

		if (request.getParameter(HIN_ID) != null
				&& request.getParameter(HIN_ID) != "") {
			requestParameters.put(HIN_ID, request.getParameter(HIN_ID));
		}

		if (request.getParameter(INPATIENT_ID) != null
				&& request.getParameter(INPATIENT_ID) != "") {
			requestParameters.put(INPATIENT_ID, request
					.getParameter(INPATIENT_ID));
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map = dischargeHandlerService.getDischargeFields(requestParameters);
		jsp = DISCHARGE_FIELDS_DISPLAY_JSP;
		title = "Discharge Details Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addDischargeSummary(HttpServletRequest request,
			HttpServletResponse response) {
		Enumeration e = request.getParameterNames();
		Map<String, Object> requestDataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		box.put("box", box);
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = request.getParameter(key);
			//System.out.println("key  " + key);
			//System.out.println("value  " + value);
			requestDataMap.put(key, value);
		}
		String andNo = "";
		String hinNo = "";
		int inPatientId = 0;
		String flag = "";
		String serviceNo = "";
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		if (request.getParameter("flag") != null
				&& request.getParameter("flag") != "") {
			flag = (request.getParameter("flag"));
		}
		if (request.getParameter(ADMISSION_NUMBER) != null
				&& request.getParameter(ADMISSION_NUMBER) != "") {
			andNo = (request.getParameter(ADMISSION_NUMBER));
		}
		//System.out.println("andNo   " + andNo);
		if (request.getParameter(HIN_NO) != null
				&& request.getParameter(HIN_NO) != "") {
			hinNo = (request.getParameter(HIN_NO));
		}
		if (request.getParameter(SERVICE_NO) != null
				&& request.getParameter(SERVICE_NO) != "") {
			serviceNo = (request.getParameter(SERVICE_NO));
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& request.getParameter(INPATIENT_ID) != "") {
			inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		box.put(HOSPITAL_ID, (Integer)session.getAttribute("hospitalId"));
		String userSrNo = (String)session.getAttribute("userSrNo");
		box.put("userSrNo",userSrNo);
		
		map = dischargeHandlerService.addDischargeSummary(requestDataMap,box);
		Set set = (Set) map.get("inpatientSet");
		// List list=(List) set;
		if (flag.equals("PatientDiagnosis")) {
			int deptId = 0;
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			String deptName = request.getParameter("deptName");
			map.put("inPatientId", inPatientId);
			map.put("deptId", deptId);
			map = dischargeHandlerService.showPatientDiagnosisJsp(map);
			map.put("deptName", deptName);
			map.put("andNo", andNo);
			map.put("hinNo", hinNo);
			map.put("serviceNo", serviceNo);
			jsp = PATIENT_DIAGNOSIS_JSP;
		} else {
			/*jsp = MESSAGE_FOR_DISCHARGE_SUMMARY;*/
			jsp = "messageForWard";
		}

		map.put("inPatientSet", set);

		jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("andNo", andNo);
		map.put(HIN_NO, hinNo);
		map.put("serviceNo", serviceNo);
		map.put("printUrl", "/hms/hms/discharge?method=showDischargeSummaryReport&flag=c&adNo="+inPatientId+"&hinNo="+box.getString("hinNo")+"&serviceNo="+box.getString("serviceNo"));
		map.put("backUrl", "/hms/hms/ipd?method=showPatientListJsp");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showPatientDischargeSummary(HttpServletRequest request,
			HttpServletResponse response) {
		jsp = DISCHARGE_SUMMARY_REPORT_SCREEN;
		jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("status", "fresh");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showClinicalSheetReportScreen(
			HttpServletRequest request, HttpServletResponse response) {
		String adNo = "";
		String serviceNo = "";
		if (request.getParameter("parent") != null) {
			adNo = request.getParameter("parent");
		}
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		//System.out.println("adNo   " + adNo);
		//System.out.println("ServiceNo   " + serviceNo);
		jsp = CLINICAL_SHEET_REPORT_SCREEN;
		jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("adNo", adNo);
		map.put("serviceNo", serviceNo);
		map.put("status", "fresh");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showClinicalSheetReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String admissionNumber = null;
		String fileName = null;
		String serviceNo = null;
		String hinNo = null;
		String outputTo = null;
		String casetype = null;
		session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		try {
			if (request.getParameter("adNo") != null
					&& !(request.getParameter("adNo").equals(""))) {
				admissionNumber = request.getParameter("adNo");
				requestParameters.put(ADMISSION_NUMBER, admissionNumber);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				requestParameters.put(SERVICE_NO, serviceNo);
			}
			if (request.getParameter(FILE_NAME) != null
					&& !(request.getParameter(FILE_NAME).equals(""))) {
				fileName = request.getParameter(FILE_NAME) + ".pdf";
				requestParameters.put(FILE_NAME, fileName);
			}
			if (request.getParameter(OUTPUT_TO) != null
					&& !(request.getParameter(OUTPUT_TO).equals(""))) {
				outputTo = request.getParameter(OUTPUT_TO);
				requestParameters.put(OUTPUT_TO, outputTo);
			}

			if (request.getParameter("casetype") != null
					&& !(request.getParameter("casetype").equals(""))) {
				casetype = request.getParameter("casetype");
				requestParameters.put("casetype", casetype);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		parameters = dischargeHandlerService
				.getClinicalSheetReportDetails(requestParameters);
		if (parameters.get("hinNo") != null) {
			hinNo = ("" + parameters.get("hinNo"));
		}
		/*
		 * Parameters (ad_no) is used in the sql query which build in JASPER
		 * report Rest of the parameter values in the "parameter" map are used
		 * in Report Form
		 */
		int hospitalId=0;
		String hospitalName="";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = dischargeHandlerService.getHospitalName(hospitalId);
			parameters.put("hospitalName", hospitalName);
			parameters.put("hospitalId", hospitalId);
		}
		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
		parameters.put("path", imagePath);
		
		
		parameters.put("hospitalId", session.getAttribute("hospitalId"));
		parameters.put("adNo", admissionNumber);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
	//	if (parameters.get("status") != null) {
	//		map.put("status", "nodata");
	//		map.put("admissionNumber", admissionNumber);
	//	} else {
			HMSUtil.generateReport("Clinical_Sheet_Report", parameters,
					(Connection) parameters.get("conn"), response,
					getServletContext());
	//	}
		return null;
	}

	public ModelAndView showDischargeSummaryReport(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		//System.out.println("request   " + box);
		Map<String, Object> cparameters = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> clincialMap = new HashMap<String, Object>();
		int admissionNumber = 0;
		@SuppressWarnings("unused")
		String fileName;
		fileName = null;
		String hinNo = null;
		String service_no = null;
		@SuppressWarnings("unused")
		String outputTo = null;
		@SuppressWarnings("unused")
		String casetype = null;
		session = request.getSession();
		String flag="";
		String serviceNo="";
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		try {
			if (request.getParameter("adNo") != null
					&& !(request.getParameter("adNo").equals(""))) {
				admissionNumber = box.getInt("adNo");
				parameters.put("adNo", admissionNumber);
				clincialMap.put(ADMISSION_NUMBER, admissionNumber);
			}
			if (request.getParameter("flag") != null
					&& !(request.getParameter("flag").equals(""))) {
				flag = request.getParameter("flag");
			
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				clincialMap.put(SERVICE_NO, serviceNo);
			}
		
			
		/*	if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				requestParameters.put(HIN_NO, hinNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				service_no = request.getParameter(SERVICE_NO);
				requestParameters.put(SERVICE_NO, service_no);

			}*/
			//System.out.println("admissionNumber  " + admissionNumber);

			parameters = dischargeHandlerService
					.getDischargeSummaryReportDetails(requestParameters);

			/*
			 * Following two parameters (hinNo, adNo) are used in the sql query
			 * which build in JASPER report Rest of the parameter values in the
			 * "parameter" map are used in Report Form
			 */
			int hospitalId=0;
			String hospitalName="";
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				hospitalName = dischargeHandlerService.getHospitalName(hospitalId);
				parameters.put("hospitalName", hospitalName);
				parameters.put("hospitalId", hospitalId);
			}
			String userHome = getServletContext().getRealPath("");	         
	        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
			parameters.put("path", imagePath);
			parameters.put("hinNo", hinNo);
			parameters.put("adNo", admissionNumber);
			parameters.put("IMG_PATH", request.getSession().getServletContext().getRealPath("/jsp/images/humanBody.jpg"));
			parameters.put("SUBREPORT_DIR", getServletContext()
					.getRealPath("/reports/"));
			parameters.put("hospitalId", session.getAttribute("hospitalId"));
			if(flag.equalsIgnoreCase("d")){
			HMSUtil.generateReport("Declaration_form",
					parameters, (Connection) parameters.get("conn"),
					response, getServletContext());}
			if(flag.equalsIgnoreCase("p")){
				HMSUtil.generateReport("prescriptionPatientIPD",
						parameters, (Connection) parameters.get("conn"),
						response, getServletContext());}
			if(flag.equalsIgnoreCase("i")){
				HMSUtil.generateReport("investigationPatientIPD",
						parameters, (Connection) parameters.get("conn"),
						response, getServletContext());}
			if(flag.equalsIgnoreCase("l")){
				HMSUtil.generateReport("linen_formIPD",
						parameters, (Connection) parameters.get("conn"),
						response, getServletContext());}
			if(flag.equalsIgnoreCase("s")){
				HMSUtil.generateReport("surgeryRequisionIPD",
						parameters, (Connection) parameters.get("conn"),
						response, getServletContext());}
			if(flag.equalsIgnoreCase("proce")){
				HMSUtil.generateReport("procedureIPD",
						parameters, (Connection) parameters.get("conn"),
						response, getServletContext());}
			
			
			if(flag.equalsIgnoreCase("c")){
				System.out.println(serviceNo+"--------------");
				System.out.println(admissionNumber+"--------------");
				System.out.println(hospitalId+"--------------");
				
				if (request.getParameter(FILE_NAME) != null
						&& !(request.getParameter(FILE_NAME).equals(""))) {
					fileName = request.getParameter(FILE_NAME) + ".pdf";
					clincialMap.put(FILE_NAME, fileName);
				}
				if (request.getParameter(OUTPUT_TO) != null
						&& !(request.getParameter(OUTPUT_TO).equals(""))) {
					outputTo = request.getParameter(OUTPUT_TO);
					clincialMap.put(OUTPUT_TO, outputTo);
				}

				if (request.getParameter("casetype") != null
						&& !(request.getParameter("casetype").equals(""))) {
					casetype = request.getParameter("casetype");
					clincialMap.put("casetype", casetype);
				}
				/*cparameters = dischargeHandlerService.getClinicalSheetReportDetailsIPD(clincialMap);*/
				parameters.putAll(dischargeHandlerService.getClinicalSheetReportDetailsIPD(clincialMap));
				if (cparameters.get("hinNo") != null) {
					hinNo = ("" + cparameters.get("hinNo"));
				}
				
				cparameters.put("hospitalId", session.getAttribute("hospitalId"));
				cparameters.put("adNo", admissionNumber);
					
				HMSUtil.generateReport("Ward_casesheet",parameters, (Connection) parameters.get("conn"),
						response, getServletContext());
				
			}
	
	

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView getAdmissionNumberList(HttpServletRequest request,
			HttpServletResponse response) {
		String serviceNo = null;
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		session = request.getSession(false);
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		if (request.getParameter(SERVICE_NO) != null
				&& request.getParameter(SERVICE_NO) != "") {
			serviceNo = request.getParameter(SERVICE_NO);
			requestParameters.put(SERVICE_NO, serviceNo);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = dischargeHandlerService.getAdmissionNumberList(requestParameters);
		jsp = "admissionNumberPopulate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showPatientSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		if (request.getParameter("serviceNo") != null
				&& request.getParameter("serviceNo") != "") {
			requestParameters.put("serviceNo", request
					.getParameter("serviceNo"));
		}

		if (request.getParameter("serviceType") != null
				&& request.getParameter("serviceType") != "") {
			requestParameters.put("serviceType", request
					.getParameter("serviceType"));
		}

		if (request.getParameter("rank") != null
				&& request.getParameter("rank") != "") {
			requestParameters.put("rank", request.getParameter("rank"));
		}

		if (request.getParameter("unit") != null
				&& request.getParameter("unit") != "") {
			requestParameters.put("unit", request.getParameter("unit"));
		}

		if (request.getParameter("patientName") != null
				&& request.getParameter("patientName") != "") {
			requestParameters.put("patientName", request
					.getParameter("patientName"));
		}

		if (request.getParameter("servicePersonnelName") != null
				&& request.getParameter("servicePersonnelName") != "") {
			requestParameters.put("servicePersonnelName", request
					.getParameter("servicePersonnelName"));
		}

		if (request.getParameter("SearchFlag") != null
				&& request.getParameter("SearchFlag") != "") {
			requestParameters.put("SearchFlag", request
					.getParameter("SearchFlag"));
		}
		if (request.getParameter("adNo") != null
				&& request.getParameter("adNo") != "") {
			requestParameters.put("adNo", request.getParameter("adNo"));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		requestParameters.put("deptId", deptId);
		map = dischargeHandlerService
				.getSearchPatientComboDetails(requestParameters);
		jsp = "Discharge_Patient_Search";
		title = "Patient Search Screen";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public void setDischargeHandlerService(
			DischargeHandlerService dischargeHandlerService) {
		this.dischargeHandlerService = dischargeHandlerService;
	}
	
	
	public ModelAndView showDischargeSummaryReportFromPastHistory(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		//System.out.println("request   " + box);
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String admissionNumber = null;
		int hospitalIdForReport =0;
		@SuppressWarnings("unused")
		String fileName;
		fileName = null;
		String hinNo = null;
		String service_no = null;
		@SuppressWarnings("unused")
		String outputTo = null;
		@SuppressWarnings("unused")
		String casetype = null;
		session = request.getSession();
		
		if (request.getParameter("hospitalIdForReport") != null&& !(request.getParameter("hospitalIdForReport").equals(""))) {
			hospitalIdForReport = Integer.parseInt(request.getParameter("hospitalIdForReport"));
			parameters.put("hospitalId", hospitalIdForReport);
		}
		requestParameters.put("hospitalId", hospitalIdForReport);
		try {
			if (request.getParameter("adNo") != null&& !(request.getParameter("adNo").equals(""))) {
				admissionNumber = request.getParameter("adNo");
				parameters.put("adNo", admissionNumber);
			}
			
		

			parameters = dischargeHandlerService
					.getDischargeSummaryReportDetails(requestParameters);

			/*
			 * Following two parameters (hinNo, adNo) are used in the sql query
			 * which build in JASPER report Rest of the parameter values in the
			 * "parameter" map are used in Report Form
			 */
System.out.println("adNo="+admissionNumber);
System.out.println("hospitalIdForReport="+hospitalIdForReport);
			parameters.put("hinNo", hinNo);
			parameters.put("adNo", admissionNumber);
			parameters.put("IMG_PATH", request.getSession().getServletContext().getRealPath("/jsp/images/humanBody.jpg"));
			parameters.put("SUBREPORT_DIR", getServletContext()
					.getRealPath("/reports/"));
			parameters.put("hospitalId", hospitalIdForReport);
			HMSUtil.generateReport("Discharge_SlipNew",
					parameters, (Connection) parameters.get("conn"),
					response, getServletContext());
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ModelAndView showClinicalSheetReportIPD(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int admissionNumber = 0;
		String fileName = null;
		String serviceNo = null;
		String hinNo = null;
		String outputTo = null;
		String casetype = null;
		session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		try {
			if (request.getParameter("adNo") != null
					&& !(request.getParameter("adNo").equals(""))) {
				admissionNumber =Integer.parseInt(request.getParameter("adNo"));
				requestParameters.put(ADMISSION_NUMBER, admissionNumber);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				requestParameters.put(SERVICE_NO, serviceNo);
			}
			if (request.getParameter(FILE_NAME) != null
					&& !(request.getParameter(FILE_NAME).equals(""))) {
				fileName = request.getParameter(FILE_NAME) + ".pdf";
				requestParameters.put(FILE_NAME, fileName);
			}
			if (request.getParameter(OUTPUT_TO) != null
					&& !(request.getParameter(OUTPUT_TO).equals(""))) {
				outputTo = request.getParameter(OUTPUT_TO);
				requestParameters.put(OUTPUT_TO, outputTo);
			}

			if (request.getParameter("casetype") != null
					&& !(request.getParameter("casetype").equals(""))) {
				casetype = request.getParameter("casetype");
				requestParameters.put("casetype", casetype);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		parameters = dischargeHandlerService
				.getClinicalSheetReportDetailsIPD(requestParameters);
		if (parameters.get("hinNo") != null) {
			hinNo = ("" + parameters.get("hinNo"));
		}
		/*
		 * Parameters (ad_no) is used in the sql query which build in JASPER
		 * report Rest of the parameter values in the "parameter" map are used
		 * in Report Form
		 */
		int hospitalId=0;
		String hospitalName="";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = dischargeHandlerService.getHospitalName(hospitalId);
			parameters.put("hospitalName", hospitalName);
			parameters.put("hospitalId", hospitalId);
		}
		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
		parameters.put("path", imagePath);
		
		
		parameters.put("hospitalId", session.getAttribute("hospitalId"));
		parameters.put("adNo", admissionNumber);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
	//	if (parameters.get("status") != null) {
	//		map.put("status", "nodata");
	//		map.put("admissionNumber", admissionNumber);
	//	} else {
			HMSUtil.generateReport("Clinical_Sheet_ReportIPD", parameters,
					(Connection) parameters.get("conn"), response,
					getServletContext());
	//	}
		return null;
	}
}
