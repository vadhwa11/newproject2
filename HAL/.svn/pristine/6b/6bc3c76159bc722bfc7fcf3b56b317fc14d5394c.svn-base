/**
 * Copyright 2011 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class SHOController.java
 * Purpose of the class - This is for SHO
 * @author  Mukesh Narayan Singh
 * Create Date: 5th Aug,2011
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/

package jkt.hms.sho.controller;
import static jkt.hms.util.RequestConstants.ACCOMMODATION;
import static jkt.hms.util.RequestConstants.ADDRESS;
import static jkt.hms.util.RequestConstants.ADMINISTRATIVE_ACTIONS;
import static jkt.hms.util.RequestConstants.ALCHOLISM;
import static jkt.hms.util.RequestConstants.ANALYSIS_OF_PSYCHOLOGICAL_CASES;
import static jkt.hms.util.RequestConstants.AVERAGE_NO_OF_PERSONS_COUNSELED;
import static jkt.hms.util.RequestConstants.BIO_MEDICAL_WASTE_DISPOSAL_INSPECTING;
import static jkt.hms.util.RequestConstants.BOILING;
import static jkt.hms.util.RequestConstants.CATEGORY_NAME;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHLORINATION_CARRIED_OUT_CPWD;
import static jkt.hms.util.RequestConstants.CLARIFICATION;
import static jkt.hms.util.RequestConstants.CLINICAL_FEATURES;
import static jkt.hms.util.RequestConstants.CONFIRMED_CASE_H1N1;
import static jkt.hms.util.RequestConstants.CONFIRMED_CASE_H1N1_RESPONSE;
import static jkt.hms.util.RequestConstants.CONTACT;
import static jkt.hms.util.RequestConstants.COPING;
import static jkt.hms.util.RequestConstants.COUNSELING_DATE;
import static jkt.hms.util.RequestConstants.COUNSELING_DONE_AFER_WORKING_HRS;
import static jkt.hms.util.RequestConstants.COVERING;
import static jkt.hms.util.RequestConstants.DATE;
import static jkt.hms.util.RequestConstants.DATE_HOUR_OF_SAMPLING;
import static jkt.hms.util.RequestConstants.DATE_OF_ADMISSION;
import static jkt.hms.util.RequestConstants.DATE_OF_ONSET;
import static jkt.hms.util.RequestConstants.DATE_OF_POSTING;
import static jkt.hms.util.RequestConstants.DATE_OF_REPORT;
import static jkt.hms.util.RequestConstants.DATE_SAMPLE_SENT;
import static jkt.hms.util.RequestConstants.DEPTH_OF_SURFACE;
import static jkt.hms.util.RequestConstants.DEPTH_OF_WATER;
import static jkt.hms.util.RequestConstants.DIAGNOSIS;
import static jkt.hms.util.RequestConstants.DIAGNOSIS_DATE;
import static jkt.hms.util.RequestConstants.EMPLOYEE_FIRST_NAME;
import static jkt.hms.util.RequestConstants.EMPLOYEE_LAST_NAME;
import static jkt.hms.util.RequestConstants.EMPLOYMENT_OF_COUNSELOR;
import static jkt.hms.util.RequestConstants.ENTRY_FLAG;
import static jkt.hms.util.RequestConstants.FEEDBACK_COUNSELOR;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.GEOLOGICAL_STRATA;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_RESPONSE;
import static jkt.hms.util.RequestConstants.LAST_MED_BOARD_DATE;
import static jkt.hms.util.RequestConstants.LOW_MED_CAT_PSYCHIARIC_PATIENT_COUNSELING;
import static jkt.hms.util.RequestConstants.MEDICAL_CATEGORY;
import static jkt.hms.util.RequestConstants.MEDICAL_FACILITY_FIRST;
import static jkt.hms.util.RequestConstants.MEDICAL_UNIT_FIRST_ADMITTED;
import static jkt.hms.util.RequestConstants.MENTAL_AND_PHYSICAL_RETARDED_CHILDEREN;
import static jkt.hms.util.RequestConstants.MENTAL_AND_PHYSICAL_RETARDED_CHILDEREN_RESPONSE;
import static jkt.hms.util.RequestConstants.NAME;
import static jkt.hms.util.RequestConstants.NATURE_AND_DISTANCE;
import static jkt.hms.util.RequestConstants.NATURE_AND_SOURCE_OF_WATER;
import static jkt.hms.util.RequestConstants.NATURE_OF_EXAIM_REQRD;
import static jkt.hms.util.RequestConstants.NEXT_REVIEW_DATE;
import static jkt.hms.util.RequestConstants.NOTIFIABLE_DISEASE_ENTRY;
import static jkt.hms.util.RequestConstants.NOTIFIABLE_DISEASE_PRINT;
import static jkt.hms.util.RequestConstants.NOTIFIABLE_DISEASE_PRINT_RESPONSE;
import static jkt.hms.util.RequestConstants.NOTIFIABLE_ID;
import static jkt.hms.util.RequestConstants.NO_OF_LECTURES;
import static jkt.hms.util.RequestConstants.OCCUPATIONAL_EXPOSURE_HIV;
import static jkt.hms.util.RequestConstants.PRESENT_CONDITION;
import static jkt.hms.util.RequestConstants.PRESENT_METEOROLOGICAL;
import static jkt.hms.util.RequestConstants.PRESENT_UNIT;
import static jkt.hms.util.RequestConstants.PROBLEMS_FACED;
import static jkt.hms.util.RequestConstants.QUALIFICATION;
import static jkt.hms.util.RequestConstants.RAISING_WATER;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.RECORD_CASES;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.RESPIRATORY_SYSTEM;
import static jkt.hms.util.RequestConstants.RESULT;
import static jkt.hms.util.RequestConstants.RETENTION_SERVICE;
import static jkt.hms.util.RequestConstants.SAL;
import static jkt.hms.util.RequestConstants.SAMPLE_WATER_FROM;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SOFTENING;
import static jkt.hms.util.RequestConstants.STAINING;
import static jkt.hms.util.RequestConstants.STORED_SURFACE_WATER;
import static jkt.hms.util.RequestConstants.STRATA_PENETRATED;
import static jkt.hms.util.RequestConstants.TESTING_LABORATORY;
import static jkt.hms.util.RequestConstants.TOTAL_HOURS;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TRADE;
import static jkt.hms.util.RequestConstants.TRAVELL;
import static jkt.hms.util.RequestConstants.TREATMENT;
import static jkt.hms.util.RequestConstants.TYPES_OF_CASES_COUNSELED;
import static jkt.hms.util.RequestConstants.VISIT_NUMBER;
import static jkt.hms.util.RequestConstants.WARNING_LETTER;
import static jkt.hms.util.RequestConstants.WATER_SAMPLE_FOR_ANALYSIS;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MisConfirmedH1n1;
import jkt.hms.masters.business.MisFeedbackCounselor;
import jkt.hms.masters.business.MisWaterSampleAnalysis;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Users;
import jkt.hms.sho.handler.SHOHandler;
import jkt.hms.util.HMSUtil;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
//public class SHOController extends MultiActionController{
public class SHOController extends MultiActionController{

	/*
	 * Logger Implemented By Mukesh Narayan Singh
	 * Date 5 Aug 2011
	 */
	static final Logger loger = Logger.getLogger(jkt.hms.sho.controller.SHOController.class);

	SHOHandler shoHandler=null;

	public SHOHandler getShoHandler() {
		return shoHandler;
	}

	public void setShoHandler(SHOHandler shoHandler) {
		this.shoHandler = shoHandler;
	}

	/*protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}*/
	HttpSession session = null;
	String jsp = "";
	String title = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	String message = "";
	String url="";
	public ModelAndView showNotifiableDisease(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		/*int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}*/
		map = shoHandler.showNotifiableDisease(mapDetail);
		String message="";
		if(map.get("message")!=null){
			message=(String)map.get("message");
		}
		System.out.println("message-->"+message);

		jsp = NOTIFIABLE_DISEASE_ENTRY;
		jsp = jsp + ".jsp";
		title = "Notifiable Disease Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printNotifiableDisease(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		int hospitalId=0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		/*int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}*/
		mapDetail.put("hospitalId",hospitalId);


		map = shoHandler.printNotifiableDisease(mapDetail);
		String message="";
		if(map.get("message")!=null){
			message=(String)map.get("message");
		}
		System.out.println("message-->"+message);

		jsp = NOTIFIABLE_DISEASE_PRINT;
		jsp = jsp + ".jsp";
		title = "Notifiable Disease Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView viewNotifiableDiseaseDetails(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		int hospitalId=0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		String fromDate = "";
		String toDate = "";
		String serviceNo="";
		if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
			//fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			fromDate = request.getParameter(FROM_DATE).trim();
			mapDetail.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
			//toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			toDate = request.getParameter(TO_DATE).trim();
			mapDetail.put("toDate", toDate);
		}
		if (request.getParameter(SERVICE_NO) != null && !(request.getParameter(SERVICE_NO).equals(""))) {
			//toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(SERVICE_NO));
			serviceNo = request.getParameter(SERVICE_NO).trim();
			mapDetail.put("serviceNo", serviceNo);
		}
		/*int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}*/
		mapDetail.put("hospitalId",hospitalId);


		map = shoHandler.viewNotifiableDiseaseDetails(mapDetail);
		String message="";
		if(map.get("message")!=null){
			message=(String)map.get("message");
		}

		jsp = NOTIFIABLE_DISEASE_PRINT_RESPONSE;
		jsp = jsp + ".jsp";
		title = "Notifiable Disease Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printNotifiableDiseaseReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";

		session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				Map<String, Object> mapHospital = new HashMap<String, Object>();
				mapHospital.put("hospitalId", hospitalId);
				map = shoHandler.getHospitalName(mapHospital);
				String hospitalName="";
				String hospitalAdd="";
				if(map.get("hospitalName")!=null){
					hospitalName=(String)map.get("hospitalName");
				}
				if(map.get("hospitalAdd")!=null){
					hospitalAdd=(String)map.get("hospitalAdd");
				}
				requestParameters.put("HOSP_NAME", hospitalName);
				requestParameters.put("HOSP_ADD", hospitalAdd);
			}

			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
				requestParameters.put("DepartmentName", deptName);
			}
			/*if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}*/
			String notifiableId="";
			if (request.getParameter(NOTIFIABLE_ID) != null && !(request.getParameter(NOTIFIABLE_ID).equals(""))) {
				notifiableId =request.getParameter(NOTIFIABLE_ID);
				requestParameters.put("NOTIFIABLE_ID", notifiableId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = shoHandler.getConnectionForReport();
		HMSUtil.generateReport("notifiable_report", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("indexB", "map", map);
	}
	//Low Med Cat Psychiatric Patient Counseling Entry
	public ModelAndView showLowMedCatPsychiatricPatientCounelingEntry(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		map = shoHandler.showLowMedCatPsychiatricPatientCounelingEntry(mapDetail);
		jsp = LOW_MED_CAT_PSYCHIARIC_PATIENT_COUNSELING;
		jsp = jsp + ".jsp";
		title = "Low Med Cat Psychiatric Patient Counseling Entry";
		map.put("contentJsp", jsp);
		map.put("jspFlag", "lmc");
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	//LOW_MED_CAT_PSYCHIARIC_PATIENT_COUNSELING_RESPONSE
	public ModelAndView getHinNoForDiseaseSHO(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		String serviceNo = "";
		String respForm = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		if (request.getParameter("respForm") != null) {
			respForm = (request.getParameter("respForm"));
		}

		dataMap.put("serviceNo", serviceNo);
		dataMap.put("respForm", respForm);

		map = shoHandler.getHinNoForDiseaseSHO(dataMap);
		if (respForm != null) {
			if (respForm.equals("lmc")) {
				jsp = "lmcPsychiatricPatientCounselingResponse";
				map.put("jspFlag", "lmc");
			}else{
				jsp = "lmcPsychiatricPatientCounselingResponse";
				map.put("jspFlag", "cam");
			}
		}
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView editLowMedCatPsychiatricPatientCouneling(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapRespSave = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String currentDate = null;
		int hospitalId = 0;
		int rankId = 0;
		int empId = 0;
		int tradeId = 0;
		int medicalcategory = 0;
		int hin_id=0;
		String remarks = "";
		String serviceNo = null;
		String changedBy = "";
		int presentUnit = 0;
		String employeeName = null;
		String lastName = null;
		Date nextreviewDate = null;
		Date dateOfPosting = null;
		String status = "";
		String diagnosis = null;
		Date counselingDate=null;
		Date diagnosisDate=null;
		String warningLetter="";
		String retentionService="";
		String categoryName="";
		String entryFlag="";
		hospitalId = (Integer) session.getAttribute("hospitalId");
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			//System.out.println("serviceNo:::::::" + serviceNo);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hin_id = Integer.parseInt(request.getParameter(HIN_ID));
			//System.out.println("serviceNo:::::::" + serviceNo);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals(""))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			//System.out.println("rankId:::::::::" + rankId);
		}
		if (request.getParameter(EMPLOYEE_FIRST_NAME) != null
				&& !(request.getParameter(EMPLOYEE_FIRST_NAME).equals(""))) {
			employeeName = request.getParameter(EMPLOYEE_FIRST_NAME);
			//System.out.println("emp::name::" + employeeName);
		}
		if (request.getParameter(EMPLOYEE_LAST_NAME) != null
				&& !(request.getParameter(EMPLOYEE_LAST_NAME).equals(""))) {
			lastName = request.getParameter(EMPLOYEE_LAST_NAME);
			//System.out.println("emp:ll:name::" + lastName);
		}
		if (request.getParameter(TRADE) != null
				&& !(request.getParameter(TRADE).equals(""))) {
			tradeId = Integer.parseInt(request.getParameter(TRADE));
			//System.out.println("trade:::::" + tradeId);
		}
		if (request.getParameter(MEDICAL_CATEGORY) != null
				&& !(request.getParameter(MEDICAL_CATEGORY).equals(""))) {
			medicalcategory = Integer.parseInt(request
					.getParameter(MEDICAL_CATEGORY));
			//System.out.println("medicalCategory::::::" + medicalcategory);
		}
		if (request.getParameter(PRESENT_UNIT) != null
				&& !(request.getParameter(PRESENT_UNIT).equals(""))) {
			presentUnit = Integer.parseInt(request.getParameter(PRESENT_UNIT));
			//System.out.println("presentUnit:::::::::" + presentUnit);
		}

		/*
		 * Above data is from response jsp
		 * Code form Parent JSP
		 */
		if (request.getParameter(DIAGNOSIS) != null) {
			diagnosis = request.getParameter(DIAGNOSIS);
			//System.out.println("DIAGNOSIS::::" + diagnosis);
		}
		Date lastMedBoardDate=null;
		if (request.getParameter(LAST_MED_BOARD_DATE) != null
				&& !(request.getParameter(LAST_MED_BOARD_DATE).equals(""))) {
			lastMedBoardDate =  HMSUtil.convertStringTypeDateToDateType(request.getParameter(LAST_MED_BOARD_DATE));
			//System.out.println("currentDate::::::" + currentDate);
		}
		if (request.getParameter(NEXT_REVIEW_DATE) != null
				&& !(request.getParameter(NEXT_REVIEW_DATE).equals(""))) {
			nextreviewDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(NEXT_REVIEW_DATE));
			//System.out.println("nextreviewdate:::::" + nextreviewDate);
		}

		if (request.getParameter(DATE_OF_POSTING) != null
				&& !(request.getParameter(DATE_OF_POSTING).equals(""))) {
			dateOfPosting = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_POSTING));
			//System.out.println("nextreviewdate:::::" + nextreviewDate);
		}
		if (request.getParameter(COUNSELING_DATE) != null
				&& !(request.getParameter(COUNSELING_DATE).equals(""))) {
			counselingDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(COUNSELING_DATE));
			//System.out.println("counselingDate:::::" + counselingDate);
		}

		if (request.getParameter(DIAGNOSIS_DATE) != null
				&& !(request.getParameter(DIAGNOSIS_DATE).equals(""))) {
			diagnosisDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DIAGNOSIS_DATE));
			//System.out.println("counselingDate:::::" + counselingDate);
		}
		if (request.getParameter(WARNING_LETTER) != null) {
			warningLetter = request.getParameter(WARNING_LETTER);
			//System.out.println("warningLetter::::" + warningLetter);
		}
		if (request.getParameter(RETENTION_SERVICE) != null) {
			retentionService = request.getParameter(RETENTION_SERVICE);
			//System.out.println("RETENTION_SERVICE::::" + retentionService);
		}

		if (request.getParameter(CATEGORY_NAME) != null) {
			categoryName = request.getParameter(CATEGORY_NAME);
			//System.out.println("categoryName::::" + categoryName);
		}

		if (request.getParameter(ENTRY_FLAG) != null) {
			entryFlag = request.getParameter(ENTRY_FLAG);
			//System.out.println("categoryName::::" + categoryName);
		}

		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
			//System.out.println("remarks::::" + remarks);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			//System.out.println("changeby::::::" + changedBy);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = request.getParameter(CHANGED_DATE);
			//System.out.println("currentDate::::::" + currentDate);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			//System.out.println("currentTime::::::" + currentTime);
		}
		if (request.getParameter("status") != null
				&& !(request.getParameter("status").equals(""))) {
			status = request.getParameter("status");
			//System.out.println("status::::::::" + status);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
			//System.out.println("title::::" + title);
		}
		generalMap.put("entryFlag", entryFlag);
		generalMap.put("retentionService", retentionService);
		generalMap.put("warningLetter", warningLetter);
		generalMap.put("categoryName", categoryName);
		generalMap.put("counselingDate", counselingDate);
		generalMap.put("diagnosisDate", diagnosisDate);

		generalMap.put("status", status);
		generalMap.put("employeeId", empId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("hin_id", hin_id);
		generalMap.put("rankId", rankId);
		generalMap.put("employeeName", employeeName);
		generalMap.put("lastName", lastName);
		generalMap.put("tradeId", tradeId);
		generalMap.put("medicalcategory", medicalcategory);
		generalMap.put("presentUnit", presentUnit);
		generalMap.put("diagnosis", diagnosis);
		generalMap.put("lastMedBoardDate", lastMedBoardDate);
		generalMap.put("nextreviewDate", nextreviewDate);
		generalMap.put("dateOfPosting", dateOfPosting);
		generalMap.put("remarks", remarks);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		boolean dataUpdated = false;

		mapRespSave = shoHandler.editLowMedCatPsychiatricPatientCouneling(generalMap);
		if(mapRespSave.get("dataUpdated")!=null){
			dataUpdated=(Boolean)mapRespSave.get("dataUpdated");
		}
		if (dataUpdated == true) {
			message = "Data Saved Successfully";
		} else {
			message = "Data Updated Successfully";

		}

		/***********************************************************************
		 * when record is updated, it will show the MasEmployee table records
		 * for fetching from MasEmployee the value of receiptStatusRadio is set
		 * to constant 2
		 **********************************************************************/

		url = "/hms/hms/sHO?method=showLowMedCatPsychiatricPatientCounelingEntry";
		map = shoHandler.showLowMedCatPsychiatricPatientCounelingEntry(generalMap);

		if (status != null) {
			jsp = LOW_MED_CAT_PSYCHIARIC_PATIENT_COUNSELING;
			if (status.equals("lmc")) {
				title = "Low Med Cat Psychiatric Patient Counseling Entry";
				map.put("jspFlag", "lmc");
			} else if (status.equals("cam")) {
				title = " Cases of Alcoholism Monitoring Entry";
				map.put("jspFlag", "cam");
			}/* else if (status.equals("clearance")) {
				jsp = "clearanceFormJsp";
				title = "update AFMSF-1 ClearanceForm";
			} else if (status.equals("dispatch")) {
				jsp = "dispatchDetailsJsp";
				title = "update AFMSF-1 DispatchDetails";
			}*/
		}
		title = "Low Med Cat Psychiatric Patient Counseling Entry";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView showCaseOfAlcoholismMonitoringEntry(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		map = shoHandler.showLowMedCatPsychiatricPatientCounelingEntry(mapDetail);
		jsp = LOW_MED_CAT_PSYCHIARIC_PATIENT_COUNSELING;
		jsp = jsp + ".jsp";
		title = "Cases of Alcoholism Monitoring Entry";
		map.put("jspFlag", "cam");
		map.put("contentJsp", jsp);

		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showConfirmedCasesH1N1(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		map = shoHandler.showConfirmedCasesH1N1(mapDetail);
		jsp = CONFIRMED_CASE_H1N1;
		jsp = jsp + ".jsp";
		title = "Confirmed Cases (H1N1) Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getHinNoSHO(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		mapDetail.put("serviceNo", serviceNo);
		map = shoHandler.getHinNoSHO(mapDetail);
		map.put("serviceNo", serviceNo);
		jsp = HIN_RESPONSE;
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView confirmedCasesH1N1Response(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		/*String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}*/
		String hinId = "";
		if (request.getParameter("hinId") != null) {
			hinId = request.getParameter("hinId").trim();
		}
		//mapDetail.put("serviceNo", serviceNo);
		mapDetail.put("hinId", hinId);
		map = shoHandler.confirmedCasesH1N1Response(mapDetail);
		jsp = CONFIRMED_CASE_H1N1_RESPONSE;
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView saveConfirmedCasesH1N1(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		Date currentDate = null;
		String changedBy = "";
		int hospitalId = 0;
		int empId = 0;
		int hin_id=0;
		String remarks = "";
		String serviceNo = null;

		hospitalId = (Integer) session.getAttribute("hospitalId");
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			System.out.println("serviceNo:::::::" + serviceNo);
		}

		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hin_id = Integer.parseInt(request.getParameter(HIN_ID));
			System.out.println("serviceNo:::::::" + serviceNo);
		}

		String medicalFacilityFirst="";
		if (request.getParameter(MEDICAL_FACILITY_FIRST) != null) {
			medicalFacilityFirst = request.getParameter(MEDICAL_FACILITY_FIRST);
			System.out.println("medicalFacilityFirst::::" + medicalFacilityFirst);
		}
		String medicalUnitFirstAdmitted="";
		if (request.getParameter(MEDICAL_UNIT_FIRST_ADMITTED) != null) {
			medicalUnitFirstAdmitted = request.getParameter(MEDICAL_UNIT_FIRST_ADMITTED);
			System.out.println("medicalUnitFirstAdmitted::::" + medicalUnitFirstAdmitted);
		}
		Date dateOfOnset=null;
		if (request.getParameter(DATE_OF_ONSET) != null
				&& !(request.getParameter(DATE_OF_ONSET).equals(""))) {
			dateOfOnset =  HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_ONSET));
			System.out.println("dateOfOnset::::::" + dateOfOnset);
		}
		Date dateOfAdmission=null;
		if (request.getParameter(DATE_OF_ADMISSION) != null
				&& !(request.getParameter(DATE_OF_ADMISSION).equals(""))) {
			dateOfAdmission =  HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_ADMISSION));
			System.out.println("dateOfAdmission::::::" + dateOfAdmission);
		}
		String contact="";
		if (request.getParameter(CONTACT) != null) {
			contact = request.getParameter(CONTACT);
			System.out.println("contact::::" + contact);
		}
		String travell="";
		if (request.getParameter(TRAVELL) != null) {
			travell = request.getParameter(TRAVELL);
			System.out.println("travell::::" + travell);
		}

		String clinicalFeatures="";
		if (request.getParameter(CLINICAL_FEATURES) != null) {
			clinicalFeatures = request.getParameter(CLINICAL_FEATURES);
			System.out.println("clinicalFeatures::::" + clinicalFeatures);
		}
		String respairatorySystem="";
		if (request.getParameter(RESPIRATORY_SYSTEM) != null) {
			respairatorySystem = request.getParameter(RESPIRATORY_SYSTEM);
			System.out.println("respairatorySystem::::" + respairatorySystem);
		}

		Date dateSampleSent=null;
		if (request.getParameter(DATE_SAMPLE_SENT) != null
				&& !(request.getParameter(DATE_SAMPLE_SENT).equals(""))) {
			dateSampleSent =  HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_SAMPLE_SENT));
			System.out.println("dateSampleSent::::::" + dateSampleSent);
		}

		String testingLaboratory="";
		if (request.getParameter(TESTING_LABORATORY) != null) {
			testingLaboratory = request.getParameter(TESTING_LABORATORY);
			System.out.println("testingLaboratory::::" + testingLaboratory);
		}

		Date dateOfReport=null;
		if (request.getParameter(DATE_OF_REPORT) != null
				&& !(request.getParameter(DATE_OF_REPORT).equals(""))) {
			dateOfReport =  HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_REPORT));
			System.out.println("dateOfReport::::::" + dateOfReport);
		}

		String result="";

		if (request.getParameter(RESULT) != null) {
			result = request.getParameter(RESULT);
			System.out.println("result::::" + result);
		}
		String treatment="";
		if (request.getParameter(TREATMENT) != null) {
			treatment = request.getParameter(TREATMENT);
			System.out.println("treatment::::" + treatment);
		}
		String presentCondition="";
		if (request.getParameter(PRESENT_CONDITION) != null) {
			presentCondition = request.getParameter(PRESENT_CONDITION);
			System.out.println("presentCondition::::" + presentCondition);
		}
		/*
		 * Above data is from response jsp
		 * Code form Parent JSP
		 */
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
			System.out.println("remarks::::" + remarks);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			System.out.println("changeby::::::" + changedBy);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			System.out.println("currentDate::::::" + currentDate);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			System.out.println("currentTime::::::" + currentTime);
		}
		MisConfirmedH1n1 misConfirmedH1n1=new MisConfirmedH1n1();
		misConfirmedH1n1.setServiceNo(serviceNo);
		if(hin_id>0){
			Patient patient=new Patient();
			patient.setId(hin_id);
			misConfirmedH1n1.setHin(patient);
		}
		if(hospitalId>0){
			MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			misConfirmedH1n1.setHospital(masHospital);
		}
		misConfirmedH1n1.setMedFacilityFirst(medicalFacilityFirst);
		misConfirmedH1n1.setMedUnitFirstAdmitted(medicalUnitFirstAdmitted);
		misConfirmedH1n1.setDateOfOnset(dateOfOnset);
		misConfirmedH1n1.setDateOfAdmission(dateOfAdmission);
		misConfirmedH1n1.setContactWithCase(contact);
		misConfirmedH1n1.setTravell(travell);
		misConfirmedH1n1.setClinicalFeatures(clinicalFeatures);
		misConfirmedH1n1.setRespiratory(respairatorySystem);
		misConfirmedH1n1.setDateSampleSent(dateSampleSent);
		misConfirmedH1n1.setTestingLaboratory(testingLaboratory);
		misConfirmedH1n1.setDateOfReport(dateOfReport);
		misConfirmedH1n1.setResult(result);
		misConfirmedH1n1.setTreatment(treatment);
		misConfirmedH1n1.setPresentCondition(presentCondition);

		misConfirmedH1n1.setStatus("y");
		misConfirmedH1n1.setLastChgBy(changedBy);
		misConfirmedH1n1.setLastChgTime(currentTime);
		misConfirmedH1n1.setLastChgDate(currentDate);

		mapDetail.put("misConfirmedH1n1", misConfirmedH1n1);
		map = shoHandler.saveConfirmedCasesH1N1(mapDetail);
		jsp = CONFIRMED_CASE_H1N1;
		jsp = jsp + ".jsp";
		title = "Confirmed Cases (H1N1) Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}


	public ModelAndView showWaterAnalysis(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		map = shoHandler.showWaterAnalysis(mapDetail);
		jsp = WATER_SAMPLE_FOR_ANALYSIS;
		jsp = jsp + ".jsp";
		title = "Water Sample for Analysis Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveWaterSampleForAnalysis(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		String natureAndDistance="";
		String sampleWaterFrom="";
		String natureOfExaimReqrd="";
		String dateHourOfSampling="";
		String natureAndSourceOfWater="";
		String geologicalStrata="";
		String depthOfWater="";
		String depthOfSurface="";
		String staining="";
		String coping="";
		String strataPenetrated="";
		String covering="";
		String raisingWater="";
		String storedSurfacewater="";
		String presentMeteorological="";
		String clarification="";
		String boiling="";
		String softening="";
		String chlorinationCarriedOutCPWD="";

		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute("hospitalId");



		if (request.getParameter(NATURE_AND_DISTANCE) != null
				&& !(request.getParameter(NATURE_AND_DISTANCE).equals(""))) {
			natureAndDistance = request.getParameter(NATURE_AND_DISTANCE);
			System.out.println("natureAndDistance::::::" + natureAndDistance);
		}
		if (request.getParameter(SAMPLE_WATER_FROM) != null
				&& !(request.getParameter(SAMPLE_WATER_FROM).equals(""))) {
			sampleWaterFrom = request.getParameter(SAMPLE_WATER_FROM);
			System.out.println("sampleWaterFrom::::::" + sampleWaterFrom);
		}
		if (request.getParameter(NATURE_OF_EXAIM_REQRD) != null
				&& !(request.getParameter(NATURE_OF_EXAIM_REQRD).equals(""))) {
			natureOfExaimReqrd = request.getParameter(NATURE_OF_EXAIM_REQRD);
			System.out.println("natureOfExaimReqrd::::::" + natureOfExaimReqrd);
		}
		if (request.getParameter(DATE_HOUR_OF_SAMPLING) != null
				&& !(request.getParameter(DATE_HOUR_OF_SAMPLING).equals(""))) {
			dateHourOfSampling = request.getParameter(DATE_HOUR_OF_SAMPLING);
			System.out.println("dateHourOfSampling::::::" + dateHourOfSampling);
		}
		if (request.getParameter(NATURE_AND_SOURCE_OF_WATER) != null
				&& !(request.getParameter(NATURE_AND_SOURCE_OF_WATER).equals(""))) {
			natureAndSourceOfWater = request.getParameter(NATURE_AND_SOURCE_OF_WATER);
			System.out.println("natureAndSourceOfWater::::::" + natureAndSourceOfWater);
		}
		if (request.getParameter(GEOLOGICAL_STRATA) != null
				&& !(request.getParameter(GEOLOGICAL_STRATA).equals(""))) {
			geologicalStrata = request.getParameter(GEOLOGICAL_STRATA);
			System.out.println("geologicalStrata::::::" + geologicalStrata);
		}
		if (request.getParameter(DEPTH_OF_WATER) != null
				&& !(request.getParameter(DEPTH_OF_WATER).equals(""))) {
			depthOfWater = request.getParameter(DEPTH_OF_WATER);
			System.out.println("depthOfWater::::::" + depthOfWater);
		}
		if (request.getParameter(DEPTH_OF_SURFACE) != null
				&& !(request.getParameter(DEPTH_OF_SURFACE).equals(""))) {
			depthOfSurface = request.getParameter(DEPTH_OF_SURFACE);
			System.out.println("depthOfSurface::::::" + depthOfSurface);
		}
		if (request.getParameter(STAINING) != null
				&& !(request.getParameter(STAINING).equals(""))) {
			staining = request.getParameter(STAINING);
			System.out.println("staining::::::" + staining);
		}
		if (request.getParameter(COPING) != null
				&& !(request.getParameter(COPING).equals(""))) {
			coping = request.getParameter(COPING);
			System.out.println("coping::::::" + coping);
		}
		if (request.getParameter(STRATA_PENETRATED) != null
				&& !(request.getParameter(STRATA_PENETRATED).equals(""))) {
			strataPenetrated = request.getParameter(STRATA_PENETRATED);
			System.out.println("strataPenetrated::::::" + strataPenetrated);
		}
		if (request.getParameter(COVERING) != null
				&& !(request.getParameter(COVERING).equals(""))) {
			covering = request.getParameter(COVERING);
			System.out.println("covering::::::" + covering);
		}
		if (request.getParameter(RAISING_WATER) != null
				&& !(request.getParameter(RAISING_WATER).equals(""))) {
			raisingWater = request.getParameter(RAISING_WATER);
			System.out.println("raisingWater::::::" + raisingWater);
		}
		if (request.getParameter(STORED_SURFACE_WATER) != null
				&& !(request.getParameter(STORED_SURFACE_WATER).equals(""))) {
			storedSurfacewater = request.getParameter(STORED_SURFACE_WATER);
			System.out.println("storedSurfacewater::::::" + storedSurfacewater);
		}
		if (request.getParameter(CHLORINATION_CARRIED_OUT_CPWD) != null
				&& !(request.getParameter(CHLORINATION_CARRIED_OUT_CPWD).equals(""))) {
			chlorinationCarriedOutCPWD = request.getParameter(CHLORINATION_CARRIED_OUT_CPWD);
			System.out.println("chlorinationCarriedOutCPWD::::::" + chlorinationCarriedOutCPWD);
		}
		if (request.getParameter(CLARIFICATION) != null
				&& !(request.getParameter(CLARIFICATION).equals(""))) {
			clarification = request.getParameter(CLARIFICATION);
			System.out.println("clarification::::::" + clarification);
		}
		if (request.getParameter(BOILING) != null
				&& !(request.getParameter(BOILING).equals(""))) {
			boiling = request.getParameter(BOILING);
			System.out.println("boiling::::::" + boiling);
		}
		if (request.getParameter(SOFTENING) != null
				&& !(request.getParameter(SOFTENING).equals(""))) {
			softening = request.getParameter(SOFTENING);
			System.out.println("softening::::::" + softening);
		}
		if (request.getParameter(PRESENT_METEOROLOGICAL) != null
				&& !(request.getParameter(PRESENT_METEOROLOGICAL).equals(""))) {
			presentMeteorological = request.getParameter(PRESENT_METEOROLOGICAL);
			System.out.println("presentMeteorological::::::" + presentMeteorological);
		}
		Date currentDate = null;
		String currentTime = "";
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			System.out.println("changeby::::::" + changedBy);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			System.out.println("currentDate::::::" + currentDate);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			System.out.println("currentTime::::::" + currentTime);
		}

		MisWaterSampleAnalysis misWaterSampleAnalysis=new MisWaterSampleAnalysis();

		if(hospitalId>0){
			MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			misWaterSampleAnalysis.setHospital(masHospital);
		}
		misWaterSampleAnalysis.setNatureAndDistance(natureAndDistance);
		misWaterSampleAnalysis.setSampleWaterFrom(sampleWaterFrom);
		misWaterSampleAnalysis.setNatureOfExaimReqrd(natureOfExaimReqrd);
		misWaterSampleAnalysis.setDateHourOfSampling(dateHourOfSampling);
		misWaterSampleAnalysis.setNatureAndSourceOfWater(natureAndSourceOfWater);
		misWaterSampleAnalysis.setGeologicalStrata(geologicalStrata);
		misWaterSampleAnalysis.setDepthOfWater(depthOfWater);
		misWaterSampleAnalysis.setDepthOfSurface(depthOfSurface);
		misWaterSampleAnalysis.setStaining(staining);


		misWaterSampleAnalysis.setCoping(coping);
		misWaterSampleAnalysis.setStrataPenetrated(strataPenetrated);
		misWaterSampleAnalysis.setCovering(covering);
		misWaterSampleAnalysis.setRaisingWater(raisingWater);
		misWaterSampleAnalysis.setStoredSurfaceWater(storedSurfacewater);
		misWaterSampleAnalysis.setPresentMeteorological(presentMeteorological);


		misWaterSampleAnalysis.setClarification(clarification);
		misWaterSampleAnalysis.setBoiling(boiling);
		misWaterSampleAnalysis.setSoftening(softening);
		misWaterSampleAnalysis.setChlorinationCarriedOutCpwd(chlorinationCarriedOutCPWD);

		misWaterSampleAnalysis.setStatus("y");
		misWaterSampleAnalysis.setLastChgBy(changedBy);
		misWaterSampleAnalysis.setLastChgTime(currentTime);
		misWaterSampleAnalysis.setLastChgDate(currentDate);
		mapDetail.put("misWaterSampleAnalysis", misWaterSampleAnalysis);

		map = shoHandler.saveWaterSampleForAnalysis(mapDetail);
		map = shoHandler.showWaterAnalysis(mapDetail);
		jsp = WATER_SAMPLE_FOR_ANALYSIS;
		jsp = jsp + ".jsp";
		title = "Water Sample for Analysis Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showFeedBackOfCounselor(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		int deptId = (Integer) session.getAttribute("deptId");
		mapDetail.put("hospitalId", hospitalId);
		mapDetail.put("deptId", deptId);
		map = shoHandler.showFeedBackOfCounselor(mapDetail);
		jsp = FEEDBACK_COUNSELOR;
		jsp = jsp + ".jsp";
		title = "Feedback of Counselor Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveFeedbackCounselor(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();

		String name="";
		String qualification="";
		Date employedDate=null;
		String sal="";
	    String visitNumber="";
	    String totalHours="";
	    String address="";

	    String averageNoOfPersonsCounseled="";
	    String typesOfCasesCounseled="";
	  
	    String noOfLectures="";
	    String counselingDoneAfterWorkingHrs="";
	    String alcholism="";
	    String recordCases="";
	    String administrativeActions="";
	    String employmentOfCounselor="";
	    String problemsFaced="";
	    String analysisOfPsychologicalCases="";

	    int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute("hospitalId");


	    // Name of Counselor
	    if (request.getParameter(NAME) != null
				&& !(request.getParameter(NAME).equals(""))) {
	    	name = request.getParameter(NAME);
			System.out.println("name::::::" + name);
		}
	    if (request.getParameter(QUALIFICATION) != null
				&& !(request.getParameter(QUALIFICATION).equals(""))) {
	    	qualification = request.getParameter(QUALIFICATION);
			System.out.println("qualification::::::" + qualification);
		}
	    //Employed Date
	    if (request.getParameter(DATE) != null
				&& !(request.getParameter(DATE).equals(""))) {
	    	employedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE));
			System.out.println("employedDate::::::" + employedDate);
		}

	  //Honorarium per month
	    if (request.getParameter(SAL) != null
	    		&& !(request.getParameter(SAL).equals(""))) {
	    	sal = request.getParameter(SAL);
			System.out.println("sal::::::" + sal);
		}
	    //No. of visits per week
	    if (request.getParameter(VISIT_NUMBER) != null
				&& !(request.getParameter(VISIT_NUMBER).equals(""))) {
	    	visitNumber = request.getParameter(VISIT_NUMBER);
			System.out.println("visitNumber::::::" + visitNumber);
		}

	    //Hours of work
	    if (request.getParameter(TOTAL_HOURS) != null
				&& !(request.getParameter(TOTAL_HOURS).equals(""))) {
	    	totalHours = request.getParameter(TOTAL_HOURS);
			System.out.println("totalHours::::::" + totalHours);
		}

	  //Place of conducting the counseling sessions
	    if (request.getParameter(ADDRESS) != null
				&& !(request.getParameter(ADDRESS).equals(""))) {
	    	address = request.getParameter(ADDRESS);
			System.out.println("address::::::" + address);
		}
	    if (request.getParameter(AVERAGE_NO_OF_PERSONS_COUNSELED) != null
				&& !(request.getParameter(AVERAGE_NO_OF_PERSONS_COUNSELED).equals(""))) {
	    	averageNoOfPersonsCounseled = request.getParameter(AVERAGE_NO_OF_PERSONS_COUNSELED);
			System.out.println("averageNoOfPersonsCounseled::::::" + averageNoOfPersonsCounseled);
		}

	    if (request.getParameter(TYPES_OF_CASES_COUNSELED) != null
				&& !(request.getParameter(TYPES_OF_CASES_COUNSELED).equals(""))) {
	    	typesOfCasesCounseled = request.getParameter(TYPES_OF_CASES_COUNSELED);
			System.out.println("typesOfCasesCounseled::::::" + typesOfCasesCounseled);
		}
	    if (request.getParameter(NO_OF_LECTURES) != null
				&& !(request.getParameter(NO_OF_LECTURES).equals(""))) {
	    	noOfLectures = request.getParameter(NO_OF_LECTURES);
			System.out.println("noOfLectures::::::" + noOfLectures);
		}

	    if (request.getParameter(COUNSELING_DONE_AFER_WORKING_HRS) != null
				&& !(request.getParameter(COUNSELING_DONE_AFER_WORKING_HRS).equals(""))) {
	    	counselingDoneAfterWorkingHrs = request.getParameter(COUNSELING_DONE_AFER_WORKING_HRS);
			System.out.println("counselingDoneAfterWorkingHrs::::::" + counselingDoneAfterWorkingHrs);
		}
	    //Are cases of Alcohol dependence Syndrome also being maintained

	    if (request.getParameter(ALCHOLISM) != null
				&& !(request.getParameter(ALCHOLISM).equals(""))) {
	    	alcholism = request.getParameter(ALCHOLISM);
			System.out.println("alcholism::::::" + alcholism);
		}
	    if (request.getParameter(RECORD_CASES) != null
				&& !(request.getParameter(RECORD_CASES).equals(""))) {
	    	recordCases = request.getParameter(RECORD_CASES);
			System.out.println("recordCases::::::" + recordCases);
		}
	    if (request.getParameter(ADMINISTRATIVE_ACTIONS) != null
				&& !(request.getParameter(ADMINISTRATIVE_ACTIONS).equals(""))) {
	    	administrativeActions = request.getParameter(ADMINISTRATIVE_ACTIONS);
			System.out.println("administrativeActions::::::" + administrativeActions);
		}

	    if (request.getParameter(EMPLOYMENT_OF_COUNSELOR) != null
				&& !(request.getParameter(EMPLOYMENT_OF_COUNSELOR).equals(""))) {
	    	employmentOfCounselor = request.getParameter(EMPLOYMENT_OF_COUNSELOR);
			System.out.println("employmentOfCounselor::::::" + employmentOfCounselor);
		}
	    if (request.getParameter(PROBLEMS_FACED) != null
				&& !(request.getParameter(PROBLEMS_FACED).equals(""))) {
	    	problemsFaced = request.getParameter(PROBLEMS_FACED);
			System.out.println("problemsFaced::::::" + problemsFaced);
		}

	    if (request.getParameter(ANALYSIS_OF_PSYCHOLOGICAL_CASES) != null
				&& !(request.getParameter(ANALYSIS_OF_PSYCHOLOGICAL_CASES).equals(""))) {
	    	analysisOfPsychologicalCases = request.getParameter(ANALYSIS_OF_PSYCHOLOGICAL_CASES);
			System.out.println("analysisOfPsychologicalCases::::::" + analysisOfPsychologicalCases);
		}
	    Date currentDate = null;
		String currentTime = "";
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			System.out.println("changeby::::::" + changedBy);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			System.out.println("currentDate::::::" + currentDate);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			System.out.println("currentTime::::::" + currentTime);
		}
		MisFeedbackCounselor misFeedbackCounselor=new MisFeedbackCounselor();
	    if(hospitalId>0){
			MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			misFeedbackCounselor.setHospital(masHospital);
		}
	    misFeedbackCounselor.setCounselorName(name);
	    misFeedbackCounselor.setQualification(qualification);
	    misFeedbackCounselor.setEmployedDate(employedDate);
	    misFeedbackCounselor.setHonorarium(sal);
	    misFeedbackCounselor.setVisitsPerWeek(visitNumber);
	    misFeedbackCounselor.setWorkHours(totalHours);
	    misFeedbackCounselor.setCounselingPlace(address);
	    misFeedbackCounselor.setCounseledPersons(averageNoOfPersonsCounseled);

	    misFeedbackCounselor.setCounseledCasesType(typesOfCasesCounseled);
	    misFeedbackCounselor.setNoOfLecture(noOfLectures);

	    misFeedbackCounselor.setCounAfterWorkingHrs(counselingDoneAfterWorkingHrs);
	    misFeedbackCounselor.setAlcoholDependence(alcholism);
	    misFeedbackCounselor.setRecordCases(recordCases);
	    misFeedbackCounselor.setAdministrativeAction(administrativeActions);
	    misFeedbackCounselor.setEmploymentOfCounselor(employmentOfCounselor);
	    misFeedbackCounselor.setProblemsFaced(problemsFaced);
	    misFeedbackCounselor.setAnalysisofPsyCases(analysisOfPsychologicalCases);
	    misFeedbackCounselor.setStatus("y");
		misFeedbackCounselor.setLastChgBy(changedBy);
		misFeedbackCounselor.setLastChgTime(currentTime);
		misFeedbackCounselor.setLastChgDate(currentDate);
		mapDetail.put("misFeedbackCounselor",misFeedbackCounselor);
		map = shoHandler.saveFeedbackCounselor(mapDetail);
		jsp = FEEDBACK_COUNSELOR;
		jsp = jsp + ".jsp";
		title = "Feedback of Counselor Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOccupationalExposureHIV(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		map = shoHandler.showOccupationalExposureHIV(mapDetail);
		jsp = OCCUPATIONAL_EXPOSURE_HIV;
		jsp = jsp + ".jsp";
		title = "Occupational Exposure to HIV Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveOccupationalExposureHIV(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();

		map = shoHandler.saveOccupationalExposureHIV(mapDetail);
		jsp = OCCUPATIONAL_EXPOSURE_HIV;
		jsp = jsp + ".jsp";
		title = "Occupational Exposure to HIV Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printOccupationalExposureHIV(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";

		session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				Map<String, Object> mapHospital = new HashMap<String, Object>();
				mapHospital.put("hospitalId", hospitalId);
				map = shoHandler.getHospitalName(mapHospital);
				String hospitalName="";
				String hospitalAdd="";
				if(map.get("hospitalName")!=null){
					hospitalName=(String)map.get("hospitalName");
				}
				if(map.get("hospitalAdd")!=null){
					hospitalAdd=(String)map.get("hospitalAdd");
				}
				requestParameters.put("HOSP_NAME", hospitalName);
				requestParameters.put("HOSP_ADD", hospitalAdd);
			}

			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
				requestParameters.put("DepartmentName", deptName);
			}
			/*if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}*/
			String notifiableId="";
			if (request.getParameter(NOTIFIABLE_ID) != null && !(request.getParameter(NOTIFIABLE_ID).equals(""))) {
				notifiableId =request.getParameter(NOTIFIABLE_ID);
				requestParameters.put("NOTIFIABLE_ID", notifiableId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = shoHandler.getConnectionForReport();
		HMSUtil.generateReport("notifiable_report", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showBioMedicalWasteDisposalInspecting(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		map = shoHandler.showBioMedicalWasteDisposalInspecting(mapDetail);
		jsp ="biomedicalwastemgt";
		jsp +=  ".jsp";
		title = "Bio Medical Waste Disposal Inspecting Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveBioMedicalWasteDisposalInspecting(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();

		map = shoHandler.saveBioMedicalWasteDisposalInspecting(mapDetail);
		jsp = BIO_MEDICAL_WASTE_DISPOSAL_INSPECTING;
		jsp = jsp + ".jsp";
		title = "Bio Medical Waste Disposal/ Inspecting Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printBioMedicalWasteDisposalInspecting(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";

		session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				Map<String, Object> mapHospital = new HashMap<String, Object>();
				mapHospital.put("hospitalId", hospitalId);
				map = shoHandler.getHospitalName(mapHospital);
				String hospitalName="";
				String hospitalAdd="";
				if(map.get("hospitalName")!=null){
					hospitalName=(String)map.get("hospitalName");
				}
				if(map.get("hospitalAdd")!=null){
					hospitalAdd=(String)map.get("hospitalAdd");
				}
				requestParameters.put("HOSP_NAME", hospitalName);
				requestParameters.put("HOSP_ADD", hospitalAdd);
			}

			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
				requestParameters.put("DepartmentName", deptName);
			}
			/*if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}*/
			String notifiableId="";
			if (request.getParameter(NOTIFIABLE_ID) != null && !(request.getParameter(NOTIFIABLE_ID).equals(""))) {
				notifiableId =request.getParameter(NOTIFIABLE_ID);
				requestParameters.put("NOTIFIABLE_ID", notifiableId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = shoHandler.getConnectionForReport();
		HMSUtil.generateReport("notifiable_report", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showMentalAndPhysicalRetardedChildren(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		map = shoHandler.showMentalAndPhysicalRetardedChildren(mapDetail);
		jsp = MENTAL_AND_PHYSICAL_RETARDED_CHILDEREN;
		jsp = jsp + ".jsp";
		title = "Mental / Physical Retarded Children Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showMentalAndPhysicalRetardedChildrenResponse(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		jsp = MENTAL_AND_PHYSICAL_RETARDED_CHILDEREN_RESPONSE;
		jsp = jsp + ".jsp";
		title = "Mental / Physical Retarded Children Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		String serviceNo = "";
		String respForm = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		if (request.getParameter("respForm") != null) {
			respForm = (request.getParameter("respForm"));
		}

		mapDetail.put("serviceNo", serviceNo);
		mapDetail.put("respForm", respForm);

		map = shoHandler.getHinNoForDiseaseSHO(mapDetail);
		if (respForm != null) {
			if (respForm.equals("lmc")) {
				jsp = "lmcPsychiatricPatientCounselingResponse";
				map.put("jspFlag", "lmc");
			}else{
				jsp = "lmcPsychiatricPatientCounselingResponse";
				map.put("jspFlag", "cam");
			}
		}
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView saveMentalAndPhysicalRetardedChildren(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();

		map = shoHandler.saveMentalAndPhysicalRetardedChildren(mapDetail);
		jsp = MENTAL_AND_PHYSICAL_RETARDED_CHILDEREN;
		jsp = jsp + ".jsp";
		title = "Mental / Physical Retarded Children Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showAccommodation(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		map = shoHandler.showAccommodation(mapDetail);
		jsp = "accommodatio";
		jsp +=  ".jsp";
		title = "Accommodation  Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveAccommodation (HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();

		map = shoHandler.saveAccommodation(mapDetail);
		jsp = ACCOMMODATION;
		jsp = jsp + ".jsp";
		title = "Accommodation  Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showRenewableApplication(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		//map = shoHandler.showAccommodation(mapDetail);
		jsp = "renewableApplication";
		jsp = jsp + ".jsp";
		title = "Renewable Application";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	//----Methods Written by Kiran
	
	public ModelAndView showWaterSurveillance(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		//map = shoHandler.showAccommodation(mapDetail);
		jsp = "sho_waterSurveillance";
		jsp = jsp + ".jsp";
		title = "Water Surveillance";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showFreeFromInfection(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		//map = shoHandler.showAccommodation(mapDetail);
		jsp = "sho_freeFromInfection";
		jsp = jsp + ".jsp";
		title = "Free From Infection";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showVectorControl(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		//map = shoHandler.showAccommodation(mapDetail);
		jsp = "sho_vectorControlActivity";
		jsp = jsp + ".jsp";
		title = "Vector Control Activity";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showHealthPromotion(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		//map = shoHandler.showAccommodation(mapDetail);
		jsp = "sho_healthPromotionActivity";
		jsp = jsp + ".jsp";
		title = "Health Promotion Activity";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showMalariaCase(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		mapForDS.put("hospitalId", hospitalId);
		if (request.getParameter("consultingDoc") != null) {
			int empId = Integer.parseInt(request.getParameter("consultingDoc"));
			//System.out.println("empId when selecting doctor name======" + empId);
			mapForDS.put("empId", empId);
		}else{
			
			Users user = new Users();
			if(session.getAttribute("users")!=null){
				user = (Users)session.getAttribute("users");
			}
			mapForDS.put("empId", user.getEmployee().getId());
		}

		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			
			mapForDS.put("deptId", deptId);
		} else {
			deptId = (Integer) session.getAttribute("deptId");
			mapForDS.put("deptId", deptId);
		}
		
		
		
		
		//map = shoHandler.getDoctorList(mapForDS);
		jsp = "sho_MalariaCase";
		jsp = jsp + ".jsp";
		title = "Malaria Case";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showSmoMalariaCase(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		//map = shoHandler.showAccommodation(mapDetail);
		jsp = "sho_SmoMalariaCase";
		/*jsp = jsp + ".jsp";
		title = "SMO Malaria Case";
		map.put("contentJsp", jsp);
		map.put("title", title);*/
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView showFoodHandler(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map = shoHandler.showFoodHandler();
		jsp = "sho_FoodHandler";
		jsp = jsp + ".jsp";
		title = "SMO Food Handler";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

//---SHO Help
	
public void showShoHelp(HttpServletRequest request,HttpServletResponse response) {

		
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome
				+ fileSeparator
				+ "help"
				+ fileSeparator;
				
	
		
		try {
			
			response.setContentType("application/pdf");
			
			response.setHeader("Content-Disposition", "attachment;filename="
					+ java.net.URLEncoder.encode("SHO.pdf")
					+ "");

			File f = new File(uploadURL + "/SHO.pdf");
			InputStream in = new FileInputStream(f);
			response.getOutputStream().flush();
			ServletOutputStream outs = response.getOutputStream();

			long length = f.length();

			if (length > Integer.MAX_VALUE) {
				// File is too large
			}

			// Create the byte array to hold the data
			byte[] bytes = new byte[(int) length];

			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = in.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}

			if (offset < bytes.length) {
			}
			outs.write(bytes);
			in.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	
	}
	
}

