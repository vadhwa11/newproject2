/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * ADTController.java – 
 * Purpose of the class - This is the Admission, Discharge & Transfer Module of ADT. 
 * It contains Admission, Attached Admission, Medico Legal Case Admission, Transfer & Discharge of the patient. 
 * @author  Deepti Tevatia 
 * @author  Ritu Sahu 
 * Create Date: 3rd Jan,2008   
 * Revision Date:      
 * Revision By: Purpose
 * @version 1.0  
 **/

package jkt.hms.adt.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.adt.handler.ADTHandlerService;
import jkt.hms.adt.handler.RegistrationHandlerService;
import jkt.hms.ipd.handler.IPDHandlerService;
import jkt.hms.masters.business.AttachInpatient;
import jkt.hms.masters.business.Discharge;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.ExpiryDetails;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdmissionType;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBlock;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasCareType;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiet;
import jkt.hms.masters.business.MasDischargeStatus;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.UserEmpGroup;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ADTController extends MultiActionController{
	
	ADTHandlerService adtHandlerService = null;
	RegistrationHandlerService registrationHandlerService = null;
	IPDHandlerService ipdHandlerService = null;
	public IPDHandlerService getIpdHandlerService() {
		return ipdHandlerService;
	}

	public void setIpdHandlerService(IPDHandlerService ipdHandlerService) {
		this.ipdHandlerService = ipdHandlerService;
	}

	public RegistrationHandlerService getRegistrationHandlerService() {
		return registrationHandlerService;
	}

	public void setRegistrationHandlerService(
			RegistrationHandlerService registrationHandlerService) {
		this.registrationHandlerService = registrationHandlerService;
	}
	String jsp = "";
	public static int count = 0;

	public ModelAndView showAdmissionJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		
		map = adtHandlerService.getDetailsForSearch(hospitalId);
		jsp = PATIENT_ADMISSION_SEARCH_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientDetailsForAdmission(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String serviceNo = "";
		String hinNo = "";	
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonFName = "";
		String serPersonMName = "";
		String serPersonLName = "";
		int sectionId = 0;
		int tradeId = 0;
		int visitId = 0;
		int commandId = 0;
		String stationName = "";
		int hinId = 0;
		try{
			if(request.getParameter("srHinNo") != null && !(request.getParameter("srHinNo").equals(""))){
				hinNo = request.getParameter("srHinNo");
				mapForDs.put("hinNo", hinNo);
			}
			if(request.getParameter("visitId") != null && !(request.getParameter("visitId").equals(""))){
				visitId = Integer.parseInt(request.getParameter("visitId"));
				
			}
			if(request.getParameter("servNo") != null && !(request.getParameter("servNo").equals(""))){
				serviceNo = request.getParameter("servNo");
				mapForDs.put("serviceNo", serviceNo);
			}
			if(request.getParameter("servTypeId") != null && !(request.getParameter("servTypeId").equals("0"))){
				serviceTypeId = Integer.parseInt(request.getParameter("servTypeId")) ;
				mapForDs.put("serviceTypeId", serviceTypeId);
			}
			if(request.getParameter(RANK_ID) != null && !(request.getParameter(RANK_ID).equals("0"))){
				rankId = Integer.parseInt(request.getParameter(RANK_ID)) ;
				mapForDs.put("rankId", rankId);
			}
			if(request.getParameter(UNIT_ID) !=null && !(request.getParameter(UNIT_ID).equals("0")) ){
				unitId = Integer.parseInt(request.getParameter(UNIT_ID)) ;
				mapForDs.put("unitId", unitId);
			}
			if(request.getParameter(S_FIRST_NAME) != null && !(request.getParameter(S_FIRST_NAME).equals(""))){
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if(request.getParameter(S_MIDDLE_NAME) != null && !(request.getParameter(S_MIDDLE_NAME).equals(""))){
				serPersonMName = request.getParameter(S_MIDDLE_NAME);
				mapForDs.put("serPersonMName", serPersonMName);
			}
			if(request.getParameter(S_LAST_NAME) != null && !(request.getParameter(S_LAST_NAME).equals(""))){
				serPersonLName = request.getParameter(S_LAST_NAME);
				mapForDs.put("serPersonLName", serPersonLName);
			}
			if(request.getParameter("sectionId") != null && !(request.getParameter("sectionId").equals("0"))){
				sectionId = Integer.parseInt(request.getParameter("sectionId"));
				mapForDs.put("sectionId", sectionId);
			}
			if(request.getParameter("stationId") != null && !(request.getParameter("stationId").equals("0"))){
				stationName = (request.getParameter("stationId"));
				mapForDs.put("stationName", stationName);
			}
			if(request.getParameter("commandId") != null && !(request.getParameter("commandId").equals("0"))){
				commandId = Integer.parseInt(request.getParameter("commandId"));
				mapForDs.put("commandId", commandId);
			}
			if(request.getParameter("tradeId") != null && !(request.getParameter("tradeId").equals("0"))){
				tradeId = Integer.parseInt(request.getParameter("tradeId"));
				mapForDs.put("tradeId", tradeId);
			}
			if(request.getParameter("hinId")!= null){
				hinId = Integer.parseInt(request.getParameter("hinId"));
				mapForDs.put("hinId", hinId);
			}
			if(request.getParameter("admissionNo")!= null){
				mapForDs.put("admissionNo", request.getParameter("admissionNo"));
			}
			if(request.getParameter("patientType")!= null){
				mapForDs.put("patientType", request.getParameter("patientType"));
			}
			if(request.getParameter("departmentId")!= null){
				mapForDs.put("departmentId", Integer.parseInt(request.getParameter("departmentId")));
			}
			if(request.getParameter("mobileNo")!= null){
				mapForDs.put("mobileNo", request.getParameter("mobileNo"));
			}
			mapForDs.put("hospitalId",(Integer)session.getAttribute("hospitalId"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		String serviceNoOrHinNo ="";
		if(!serviceNo.equals("") || !hinNo.equals("")){
			serviceNoOrHinNo="yes";
		}
		patientMap = adtHandlerService.getPatientDetails(mapForDs);
		
		String jsp = "";
		String message = "";
		List<Patient> patientList = new ArrayList<Patient>();
		
		if(patientMap.get("patientList") != null){
			patientList = (List<Patient>)patientMap.get("patientList");
		}
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		if(hinId != 0){
			for (Patient patient : patientList) {
				if(patient.getPatientStatus().equals("Out Patient")){
					detailsMap = adtHandlerService.getAdmissionDetails(hospitalId);
					if(request.getParameter("mo")!=null && !(request.getParameter("mo").equals(""))){
						map.put("mo", Integer.parseInt(request.getParameter("mo")));
					}
					
					if(request.getParameter("admissionNotes")!=null && !(request.getParameter("admissionNotes").equals(""))){
						map.put("admissionNotes", request.getParameter("admissionNotes"));
					}
					if(request.getParameter("wardId")!=null && !(request.getParameter("wardId").equals(""))){
						map.put("wardId", Integer.parseInt(request.getParameter("wardId")));
					}
					
					if(request.getParameter("diagnosis")!=null && !(request.getParameter("diagnosis").equals(""))){
						map.put("diagnosis", request.getParameter("diagnosis"));
					}
					if(request.getParameter("fromDepartment")!=null && !(request.getParameter("fromDepartment").equals(""))){
						map.put("fromDepartment", request.getParameter("fromDepartment"));
					}
					jsp = ADMISSION_BY_HIN_NO_JSP+".jsp";
				}else{
					map = adtHandlerService.getDetailsForSearch(hospitalId);
					message = "Patient already admitted";
					map.put("message", message);
					jsp = PATIENT_ADMISSION_SEARCH_JSP+".jsp";
				}
			}
		}else{
			map = adtHandlerService.getDetailsForSearch(hospitalId);
			jsp = PATIENT_ADMISSION_SEARCH_JSP+".jsp";
		}
		
		map.put("patientMap", patientMap);
		patientMap.put("visitId", visitId);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		map.put("serviceNoOrHinNo", serviceNoOrHinNo);
		return new ModelAndView("indexB", "map", map);
	
	}
	
	/*
	 * Fetching the Patient Details, NOK Details, and Registration details from admission screen
	 * and admit the registered patient into the hospital by saving the data.
	*/
	
	@SuppressWarnings({"unchecked","unused"})
		public ModelAndView submitAdmissionInformation(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> admissionMap = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();	
		org.hibernate.Session ses = null;
		HibernateTemplate hibernateTemplateObject = null;
		Transaction tx = null;
		Inpatient inpatient = new Inpatient();
		Patient patient = new Patient();
		
		int hinId = 0;
		int visitId = 0;
		String dietType = "";
		String admissionTime = "";
		String condition = "";
		String nextOfKinName = "";
		String nextOfKinAddress = "";
		String nextOfKinPhoneNo = "";
		String age = "";
		String mlc = "";
		String cardStatus = "";
		String serviceTypeCode = "";
		String adNo = "";
		String motherAdNo = "";
		String conditionStatus = "";
		String ab64 = "";
		String remarks = "";
		String serviceNo ="";
		String attachUnit ="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String conditionNormal = properties.getProperty("conditionNormal");
		String conditionDead = properties.getProperty("conditionDead");
		String conditionCritical = properties.getProperty("conditionCritical");
		Patient patientObj =null;
		String message = "";
		
		try{			
			 ses  = adtHandlerService.getSes();
			 hibernateTemplateObject = adtHandlerService.getHibernateTemplateObject();
			 tx = ses.beginTransaction();
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
		if(!request.getParameter("patientHinId").equals("0")){
			hinId = Integer.parseInt(request.getParameter("patientHinId"));
			 patientObj = new Patient();
			patientObj.setId(hinId);
			inpatient.setHin(patientObj);
		}
		//------Checking for AD no Duplicate----------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> ipMap = new HashMap<String, Object>();
		List<Inpatient> ipList =new ArrayList<Inpatient>();
		dataMap.put("hinId", hinId);
		/*ipMap=adtHandlerService.checkAdNoDuplication(dataMap);*/
		ipMap=adtHandlerService.checkAdNoDuplicationHAL(dataMap, tx, ses);
		if(ipMap.get("inpatientList") !=null){
			ipList=(List<Inpatient>) ipMap.get("inpatientList");
		}
		if(ipList.size() > 0){
			
			for(Inpatient inpatient2 :ipList){
				adNo=inpatient2.getAdNo();
			}
			map.put("adNo", adNo);
			String msg = "Patient Already admitted with A & D No. '"+adNo+"'.Do you want to print IP Admission slip? ";
			map.put("message", msg);
			jsp = MESSAGE_FOR_ADT_JSP+".jsp";
			map.put("message", msg);
			map.put("contentJsp", jsp);
			return new ModelAndView("indexB", "map", map);
		}
		if(request.getParameter(SERVICE_NO) != null && !request.getParameter(SERVICE_NO).equals("") ){
			 serviceNo = request.getParameter(SERVICE_NO);
		}
		
		//---------------------------------------------
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != "0"){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			inpatient.setHospital(masHospital);
		}
		
		int consultingDoctorId =0;
		if(request.getParameter(CONSULTING_DOCTOR) != null && !request.getParameter(CONSULTING_DOCTOR).equals("0")){
			 consultingDoctorId = Integer.parseInt(request.getParameter(CONSULTING_DOCTOR));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(consultingDoctorId);
			inpatient.setDoctor(masEmployee);
		}
		
	
		if(request.getParameter(LAST_AD_NO) !=null){
			inpatient.setPreviousAdNo(""+request.getParameter(LAST_AD_NO));
		}
		if(request.getParameter(BLOOD_GROUP_ID) != null && !request.getParameter(BLOOD_GROUP_ID).equals("0")){
			int bloodGroupId = Integer.parseInt(request.getParameter(BLOOD_GROUP_ID));
			patientMap.put("bloodGroupId", bloodGroupId);
		}
		if(request.getParameter(MARITAL_STATUS_ID) != null && !request.getParameter(MARITAL_STATUS_ID).equals("0")){
			int maritalStatusId = Integer.parseInt(request.getParameter(MARITAL_STATUS_ID));
			patientMap.put("maritalStatusId", maritalStatusId);
		}
	
		int bedId =0 ;
		if(request.getParameter(BED_ID)!= null && !request.getParameter(BED_ID).equals("0") && !request.getParameter(BED_ID).equals("")){
			 bedId = Integer.parseInt(request.getParameter(BED_ID));
			MasBed bed = new MasBed();
			bed.setId(bedId);
			inpatient.setBed(bed);
			admissionMap.put("bedId", bedId);
		}
	
		if(request.getParameter(ADMISSION_TYPE_ID) != null && !request.getParameter(ADMISSION_TYPE_ID).equals("0")){
			int admissionTypeId = Integer.parseInt(request.getParameter(ADMISSION_TYPE_ID));
			MasAdmissionType admissionType = new MasAdmissionType();
			admissionType.setId(admissionTypeId);
			inpatient.setAdmissionType(admissionType);
		}
		if(request.getParameter("prevHospitalName") != null){
			inpatient.setPrevHospitalName(request.getParameter("prevHospitalName"));
		}
		if(request.getParameter("prevAdNo") != null){
			inpatient.setPrevAdNo(request.getParameter("prevAdNo"));
		}
		if(request.getParameter("prevDisposal") != null){
			inpatient.setPrevDisposal(request.getParameter("prevDisposal"));
		}
		if(request.getParameter("prevDiagnosis") != null){
			inpatient.setPrevDiagnosis(request.getParameter("prevDiagnosis"));
		}
		
		if(request.getParameter(DIET_ID) !=null && !request.getParameter(DIET_ID).equals("")){
			int dietId = Integer.parseInt(request.getParameter(DIET_ID));
			MasDiet diet = new MasDiet();
				if(request.getParameter(CONDITION) != null){
					condition = request.getParameter(CONDITION);
				}	
				if(condition.equals(conditionDead)){
					diet.setId(3);
					inpatient.setDiet(diet);
				}
				else{
					diet.setId(dietId);
					inpatient.setDiet(diet);
				}
		}

		if(request.getParameter(DIET_TYPE) != null){
			dietType = request.getParameter(DIET_TYPE);
			inpatient.setDietType(dietType);
		}
		if(request.getParameter(DATE_OF_ADMISSION) != null){
			inpatient.setDateOfAddmission(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_ADMISSION)));
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			 SimpleDateFormat formatterOut = new  SimpleDateFormat("yyyy-MM-dd");
			 String date4MySQL ="";
			try {
				date4MySQL = formatterOut.format(formatterIn.parse(request.getParameter(DATE_OF_ADMISSION)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			admissionMap.put("doa",date4MySQL);
			
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		
		String currentTime = (String)utilMap.get("currentTimeWithoutSc");
		if(request.getParameter(TIME_OF_ADMISSION) != null){
			admissionTime = request.getParameter(TIME_OF_ADMISSION);
			inpatient.setTimeOfAddmission(admissionTime);
			admissionMap.put("toa", request.getParameter(TIME_OF_ADMISSION));
		}else{
			inpatient.setTimeOfAddmission(currentTime);
			
		}
		if(request.getParameter(REMARKS) != null){
			remarks =""+request.getParameter(REMARKS);
			inpatient.setRemarks(remarks);
		}
		int departmentId =0;
		if(request.getParameter(DEPARTMENT_ID) != null && !request.getParameter(DEPARTMENT_ID).equals("0")){
			 departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			inpatient.setDepartment(masDepartment);
			inpatient.setAdWardId(masDepartment);
		}
		if(request.getParameter(CONDITION) != null){
			condition = request.getParameter(CONDITION);
			if(condition.equals(conditionNormal)){
				inpatient.setConditionStatus(request.getParameter(CONDITION_STATUS));
			}else if(condition.equals(conditionDead)){
				inpatient.setConditionStatus(condition);
			}else if(condition.equals(conditionCritical)){
				if(request.getParameter(CONDITION_STATUS) != null){
					conditionStatus = request.getParameter(CONDITION_STATUS);
					inpatient.setConditionStatus(conditionStatus);
				}
			}
			inpatient.setPatientCondition(condition);
			if(condition.equals("Dead")){
				patientMap.put("patientStatus", "Expired");
			}
		}
		
		if(request.getParameter(LIST_DATE) != null && !request.getParameter(LIST_DATE).equals("")){
			inpatient.setListDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(LIST_DATE)));
		}
		if(request.getParameter(LIST_TIME) != null && !request.getParameter(LIST_TIME).equals("")){
			inpatient.setListTime(request.getParameter(LIST_TIME));
		}
	
		if(request.getParameter(NEXT_OF_KIN_NAME) != null){
			nextOfKinName = request.getParameter(NEXT_OF_KIN_NAME);
			patientMap.put("nextOfKinName", nextOfKinName);
		}
		if(request.getParameter(NEXT_OF_KIN_ADDRESS) != null){
			nextOfKinAddress = request.getParameter(NEXT_OF_KIN_ADDRESS);
			patientMap.put("nextOfKinAddress", nextOfKinAddress);
		}
		if(request.getParameter(NEXT_OF_KIN_PHONE_NO) != null){
			nextOfKinPhoneNo = request.getParameter(NEXT_OF_KIN_PHONE_NO);
			patientMap.put("nextOfKinPhoneNo", nextOfKinPhoneNo);
		}
		if(request.getParameter(BLOOD_GROUP_ID) != null && !request.getParameter(BLOOD_GROUP_ID).equals("0")){
			int bloodGroupId = Integer.parseInt(request.getParameter(BLOOD_GROUP_ID));
			patientMap.put("bloodGroupId", bloodGroupId);
		}
		if(request.getParameter(NEXT_OF_KIN_RELATION_ID) != null && !request.getParameter(NEXT_OF_KIN_RELATION_ID).equals("0")){
			int nextOfKinRelationId = Integer.parseInt(request.getParameter(NEXT_OF_KIN_RELATION_ID));
			patientMap.put("nextOfKinRelationId", nextOfKinRelationId);
		}
		if(request.getParameter("nok2Name") != null){
			patientMap.put("nok2Name", request.getParameter("nok2Name"));
		}
		if(request.getParameter("nok2Address") != null){
			patientMap.put("nok2Address", request.getParameter("nok2Address"));
		}
		if(request.getParameter("nok2ContactNo") != null){
			patientMap.put("nok2ContactNo", request.getParameter("nok2ContactNo"));
		}
		if(request.getParameter("nok2RelationId") != null && !request.getParameter("nok2RelationId").equals("0")){
			patientMap.put("nok2RelationId", Integer.parseInt(request.getParameter("nok2RelationId")));
		}
		if(request.getParameter(RANK_ID) !=null){
			if(!request.getParameter(RANK_ID).equals("0") ){
			int  rankId =Integer.parseInt (""+request.getParameter(RANK_ID));
			patientMap.put("rankId",rankId);
			}
		}
		if(request.getParameter(UNIT_ID) != null && !request.getParameter(UNIT_ID).equals("0")){
			if(!request.getParameter(UNIT_ID).equals("Other")){
				int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				patientMap.put("unitId", unitId);
			}else if(request.getParameter(UNIT_ID).equals("Other")){
				MasUnit masUnitObj =new MasUnit();
				if(request.getParameter(UNIT_NAME) != null){
					
					StringBuffer output_str1 = new StringBuffer();
					StringTokenizer s1 = new StringTokenizer(request.getParameter(UNIT_NAME)+"","\'"); 
					
					while (s1.hasMoreTokens())
					{
						output_str1.append(s1.nextToken());
						if (s1.hasMoreTokens())
						{
				 	        output_str1.append(" ");
						}
					}
					
					StringBuffer output_str2 = new StringBuffer();
					StringTokenizer s2 = new StringTokenizer(output_str1+"","\""); 
					
					while (s2.hasMoreTokens())
					{
						output_str2.append(s2.nextToken());
						if (s2.hasMoreTokens())
						{
							output_str2.append(" ");
						}
					}
					
					masUnitObj.setUnitName(""+output_str2);
				}
				if(request.getParameter(UNIT_ADDRESS) != null){
					
						StringBuffer output_str3 = new StringBuffer();
						StringTokenizer s3 = new StringTokenizer(request.getParameter(UNIT_ADDRESS)+"","\'"); 
						
						while (s3.hasMoreTokens())
						{
							output_str3.append(s3.nextToken());
							if (s3.hasMoreTokens())
							{
					 	        output_str3.append(" ");
							}
						}
						
						StringBuffer output_str4 = new StringBuffer();
						StringTokenizer s4 = new StringTokenizer(output_str3+"","\""); 
						
						while (s4.hasMoreTokens())
						{
							output_str4.append(s4.nextToken());
							if (s4.hasMoreTokens())
							{
								output_str4.append(" ");
							}
						}
					masUnitObj.setUnitAddress(""+output_str4);
				}
				if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
					masUnitObj.setLastChgBy(request.getParameter(CHANGED_BY));
				}
				if(request.getParameter(LOCAL_UNIT) != null){
					masUnitObj.setLocalUnit("y");
				}else{
					masUnitObj.setLocalUnit("n");
				}
				Date changedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
				masUnitObj.setLastChgDate(changedDate);
				masUnitObj.setLastChgTime(request.getParameter(CHANGED_TIME));
				masUnitObj.setStatus("t");
				admissionMap.put("masUnitObj", masUnitObj);
			}
		}

		if(request.getParameter(AGE) != null){
			age = request.getParameter(AGE);
			inpatient.setAge(age);
		}
		if(request.getParameter("mlc") != null){
			mlc = request.getParameter("mlc");
			inpatient.setMlc("y");
		}else{
			inpatient.setMlc("n");
		}
		/*if(request.getParameter(I_CARD_VERIFIED) != null){
			cardStatus = request.getParameter(I_CARD_VERIFIED);
			inpatient.setServiceCardStatus("y");
		}else{
			inpatient.setServiceCardStatus("n");
		}*/
		
		if(request.getParameter("attachUnitName") != null 
				  && !request.getParameter("attachUnitName").equals("")){
		    attachUnit = request.getParameter("attachUnitName");
		    inpatient.setAttachedUnit(attachUnit);
		}

		String[] documentIdArray = null;
		StringBuffer documentStr = new StringBuffer();
		if(request.getParameterValues(DOCUMENT_ID) !=null)
		if (!request.getParameterValues(DOCUMENT_ID).equals("0")) {
			documentIdArray = (String[])(request.getParameterValues(DOCUMENT_ID));
			for (int i = 0; i < documentIdArray.length; i++) {
				documentStr.append(documentIdArray[i]);
				documentStr.append(",");
			}
			documentStr.deleteCharAt(documentStr.length()-1);
			
		}
		/*if(request.getParameter(RECORD_OFFICE_ADDRESS_ID) !=null){
			if(!request.getParameter(RECORD_OFFICE_ADDRESS_ID).equals("0")){
			int recordOfficeAddressId = Integer.parseInt(request.getParameter(RECORD_OFFICE_ADDRESS_ID));
			MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
			masRecordOfficeAddress.setId(recordOfficeAddressId);
			inpatient.setRecordOfficeAddress(masRecordOfficeAddress);
			}
		}*/
		if(request.getParameter(AB_64_AVAILABLE) != null){
			ab64 = request.getParameter(AB_64_AVAILABLE);
		}else{
			ab64 = "n";
		}
		
		if(request.getParameter(HIN_NO) != null){
			String hinNo = request.getParameter(HIN_NO);
			inpatient.setHinNo(hinNo);
		}
		if(request.getParameter(PROVISIONAL_DIAG) != null){
			inpatient.setInitDiagnosis(request.getParameter(PROVISIONAL_DIAG));
		}
		if(request.getParameter(CDA_ACCOUNT_NO) != null) {
			patientMap.put("cdaAccountNo",request.getParameter(CDA_ACCOUNT_NO));
		}
		patientMap.put("ab64", ab64);
		Users user = (Users)session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		inpatient.setAddEditBy(userObj);
		Date addEditDate = new Date();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		
		if(request.getParameter(CHANGED_DATE) != null){
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			inpatient.setAddEditDate(addEditDate);
		}
		String addEditTime = "";
		if(request.getParameter(CHANGED_TIME) != null){
			 addEditTime = request.getParameter(CHANGED_TIME);
			inpatient.setAddEditTime(addEditTime);
		}
	    inpatient.setStatus("y");
	  
		inpatient.setAttachedPatient("n");

		
		String patientStatus ="";
		if(patientMap.get("patientStatus") != null){
			patientStatus = (String)patientMap.get("patientStatus");
			
		}
		
		
		if(patientStatus.trim().equals("Expired"))
				{
			// code start for Dead Patient
			
			String nok2Name = "";
			String nok2Address = "";
			String nok2ContactNo = "";
			
			int nextOfKinRelationId = 0;
			int nok2RelationId = 0;
			int bloodGroupId = 0;
			int maritalStatusId = 0;
			
			Patient patientOb = (Patient)hibernateTemplateObject.load(Patient.class, hinId);

			patientOb.setNextOfKinName(nextOfKinName);
			patientOb.setNextOfKinAddress(nextOfKinAddress);
			patientOb.setNextOfKinPhoneNumber(nextOfKinPhoneNo);
			
			
			if(patientMap.get("nok2Name") != null){
				nok2Name = (String)patientMap.get("nok2Name");
				
			}
			
			if(patientMap.get("nok2Address") != null){
				nok2Address = (String)patientMap.get("nok2Address");
				
			}
			
			if(patientMap.get("nok2ContactNo") != null){
				nok2ContactNo = (String)patientMap.get("nok2ContactNo");
				
			}
			
			
			
			if(patientMap.get("nextOfKinRelationId") != null){
				nextOfKinRelationId = (Integer)patientMap.get("nextOfKinRelationId");
				
			}
			
			
			if(patientMap.get("nok2RelationId") != null){
				nok2RelationId = (Integer)patientMap.get("nok2RelationId");
				
			}
			
			if(patientMap.get("bloodGroupId") != null){
				bloodGroupId = (Integer)patientMap.get("bloodGroupId");
				
			}
			
			if(patientMap.get("maritalStatusId") != null){
				maritalStatusId = (Integer)patientMap.get("maritalStatusId");
				
			}
			
			
			patientOb.setNok2Name(nok2Name);
			patientOb.setNok2Address(nok2Address);
			patientOb.setNok2ContactNo(nok2ContactNo);
			
			patientOb.setPatientStatus(patientStatus);
			
			patientOb.setAb64Available(ab64);
			
			if(patientMap.get("nextOfKinRelationId") != null){
				nextOfKinRelationId = (Integer)patientMap.get("nextOfKinRelationId");
				if(nextOfKinRelationId!=0){
					MasRelation masRelation = new MasRelation();
					masRelation.setId(nextOfKinRelationId);
					patientOb.setNextOfKinRelation(masRelation);
				}
			}
			if(patientMap.get("nok2RelationId") != null){
				nok2RelationId = (Integer)patientMap.get("nok2RelationId");
				if(nok2RelationId!=0){
					MasRelation masRelation = new MasRelation();
					masRelation.setId(nok2RelationId);
					patientOb.setNok2Relation(masRelation);
				}
			}
			int unitId =0;
			
			if(patientMap.get("bloodGroupId") != null){
				bloodGroupId = (Integer)patientMap.get("bloodGroupId");
				MasBloodGroup bloodGroup = new MasBloodGroup();
				bloodGroup.setId(bloodGroupId);
				patientOb.setBloodGroup(bloodGroup);
			}
			if(patientMap.get("maritalStatusId") != null){
				maritalStatusId = (Integer)patientMap.get("maritalStatusId");
				MasMaritalStatus maritalStatus = new MasMaritalStatus();
				maritalStatus.setId(maritalStatusId);
				patientOb.setMaritalStatus(maritalStatus);
			}
			Float totalService =null;
			String totalServicePeriod ="";
			if(admissionMap.get("totalService") != null){
				totalService = new Float(""+admissionMap.get("totalService")) ;
				patientOb.setServiceYears(totalService);
			}

			if(admissionMap.get("totalServicePeriod") != null){
				totalServicePeriod = (""+admissionMap.get("totalServicePeriod")) ;
				patientOb.setTotalServicePeriod(totalServicePeriod);
			}

			if(patientMap.get("rankId") != null){
				 int rankId = Integer.parseInt(""+patientMap.get("rankId")) ;
				 MasRank masRank =new MasRank();
				 masRank.setId(rankId);
				 patientOb.setRank(masRank);
			}
		
		

			hibernateTemplateObject.update(patientOb);
			
			 message = "Patient is marked as Dead";
			
			
			
			
			
			
			
			// code ends for Dead Patient
				}
		else
		{
			
			
			String oldAdNoCheckBox ="";
			if(request.getParameter("oldAdNoCheckBox") != null){
				oldAdNoCheckBox =(""+request.getParameter("oldAdNoCheckBox")) ;
			}
			Map<String, Object> adMap = new HashMap<String, Object>();
			if(oldAdNoCheckBox.equals("y")){
				if(request.getParameter(OLD_AD_NO) != null){
					inpatient.setAdNo(""+request.getParameter(OLD_AD_NO));
					adNo=request.getParameter(OLD_AD_NO);
				}
				inpatient.setAdNoType("m");
				admissionMap.put("oldAdmission", "yes");
			}else {
				/*adMap.put("serviceTypeCode", serviceTypeCode);
				adMap.put("serviceTypeId", serviceTypeId);*/			
				adMap.put("date", date);
					
				adMap.put("tableObjectName", "Inpatient");			
				adMap.put("isHospitalWise", "y");
				adMap.put("hospitalId", hospitalId);
				adMap.put("isYearly", "y");			
				adMap.put("isMonthly", "y");
				adMap.put("isPrefix", "y");
				adMap.put("transactionPrefixProperty", "transactionPrefixForIPD");
				
				
				
				/*adNo = adtHandlerService.generateAdNumber(adMap);*/
				
				/*adNo = adtHandlerService.generateTransactionSequence(adMap, ses);*/
				adNo = HMSUtil.generateTransactionSequence(adMap, ses, hibernateTemplateObject);
				
				if(adNo != null){
					inpatient.setAdNo(adNo);
					inpatient.setAdNoType("a");
				}
			}
			 // vjain
			    // Start Code for this is for Patient who is dead at admission time ---Vishal Jain
				if(condition.equals(conditionDead)){
					inpatient.setDischargeDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_ADMISSION)));
					if(request.getParameter(TIME_OF_ADMISSION) != null){
						admissionTime = request.getParameter(TIME_OF_ADMISSION);
						inpatient.setDischargeTime(admissionTime);
					}else{
						inpatient.setDischargeTime(currentTime);
					}
					
					inpatient.setAdStatus("D");
					// ////////////////////////--for dischrge
					Discharge discharge = new Discharge();
					discharge.setHin(patientObj);
					discharge.setDischargeNo(1);
					
						if(adNo != null){
								discharge.setAdNo(adNo);
							
			               }
				
					if(!request.getParameter(CONSULTING_DOCTOR).equals("0")){
					        consultingDoctorId = Integer.parseInt(request.getParameter(CONSULTING_DOCTOR));
							MasEmployee masEmployee2 = new MasEmployee();
							masEmployee2.setId(consultingDoctorId);
							discharge.setDoctor(masEmployee2);
						}	
						
						MasDisposal masDisposal = new MasDisposal();
						masDisposal.setId(8);
						discharge.setDisposal(masDisposal);
						MasDisposedTo masDisposedTo = new MasDisposedTo();
						masDisposedTo.setId(16);
						discharge.setDisposedTo(masDisposedTo);
						MasDischargeStatus masDischargeStatus = new MasDischargeStatus();
						masDischargeStatus.setId(3);
						discharge.setDischargeStatus(masDischargeStatus);
						discharge.setDischargeAdviced("n");
						discharge.setDateOfDischarge(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_ADMISSION)));
						if(request.getParameter(TIME_OF_ADMISSION) != null){
							admissionTime = request.getParameter(TIME_OF_ADMISSION);
							discharge.setTimeOfDischarge(admissionTime);
						}else{
							discharge.setTimeOfDischarge(currentTime);
						}
						discharge.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_ADMISSION)));
						discharge.setAddEditTime(addEditTime);
						discharge.setStatus("y");
						discharge.setAddEditBy(userObj);
						if(!request.getParameter(DEPARTMENT_ID).equals("0")){
							departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
							MasDepartment masDepartment1 = new MasDepartment();
							masDepartment1.setId(departmentId);
							discharge.setWard(masDepartment1);
						}
						// For discharge ICD code
						DischargeIcdCode dischargeIcdCode =new DischargeIcdCode();
						dischargeIcdCode.setHin(patientObj);
						
						MasIcd masIcd = new MasIcd();
						masIcd.setId(8030);
						dischargeIcdCode.setIcd(masIcd);
						dischargeIcdCode.setAddEditBy(userObj);
						dischargeIcdCode.setAddEditDate(addEditDate);
						dischargeIcdCode.setAddEditTime(currentTime);
						dischargeIcdCode.setStatus("y");
						dischargeIcdCode.setZ03("n");
						dischargeIcdCode.setZ09("n");
						dischargeIcdCode.setDiagnosisStatus("f");
						
						admissionMap.put("discharge", discharge);
						admissionMap.put("dischargeIcdCode", dischargeIcdCode);
				}
				else{
					/**
					 * Commented By ritu 
					 * For Not Reported to ward status is W 
					 */
					//inpatient.setAdStatus("A");
					inpatient.setAdStatus("W");
				}
				
			    //  End COde for this is for Patient who is dead at admission time ---Vishal Jain
			if(request.getParameter(TOTAL_SERVICE) != null && !request.getParameter(TOTAL_SERVICE).equals("")){
				admissionMap.put("totalService",request.getParameter(TOTAL_SERVICE));
			}
			if(request.getParameter(TOTAL_SERVICE_PERIOD) != null && !request.getParameter(TOTAL_SERVICE_PERIOD).equals("")){
				admissionMap.put("totalServicePeriod",request.getParameter(TOTAL_SERVICE_PERIOD));
			}
			if(request.getParameter("visitId") != null && !request.getParameter("visitId").equals("") ){
				visitId = Integer.parseInt(request.getParameter("visitId"));
			}
			
			admissionMap.put("visitId", visitId);
			admissionMap.put("patient", patient);
			admissionMap.put("inpatient", inpatient);
			
			admissionMap.put("hinId", hinId);
			admissionMap.put("patientMap", patientMap);
			admissionMap.put("documentIdArray", documentIdArray);
//			admissionMap.put("diagnosidIdArray", diagnosidIdArray);
			admissionMap.put("addEditTime", addEditTime);
			admissionMap.put("addEditDate", addEditDate);
			admissionMap.put("userId", userId);
			admissionMap.put("adNo", adNo);
			admissionMap.put("condition",condition);
			admissionMap.put("conditionStatus",conditionStatus);
			admissionMap.put("departmentId",departmentId);
			admissionMap.put("consultingDoctorId",consultingDoctorId);
			
			
			Map<String, Object> mapTemp = new HashMap<String, Object>();
			List<Inpatient> inpatientList =new ArrayList<Inpatient>();
			Map<String, Object> detailsMasterMap = new HashMap<String, Object>();
			Map<String, Object> patientDetailsMap = new HashMap<String, Object>();
			Map<String, Object> mapForDs = new HashMap<String, Object>();
			Map<String, Object> attachDetailsMap = new HashMap<String, Object>();
			
			String admissionFlag ="";
			
			if(!adNo.equalsIgnoreCase("NO"))
				/*mapTemp  = adtHandlerService.submitAdmissionInformation(admissionMap);*/
				mapTemp  = adtHandlerService.submitAdmissionInformationHAL(admissionMap, tx, ses);
				
				inpatientList=(List<Inpatient>) mapTemp.get("inpatientList");
				admissionFlag =""+mapTemp.get("admissionFlag");
				Map<String, Object> mlcMap = new HashMap<String, Object>();
				Map<String, Object> attachPatientMap = new HashMap<String, Object>();
				String mlcNo = "";
				int mlcFlag = 0;
				if(admissionFlag.equals("true")){
					/*if(request.getParameter("mlcFlag") != null && request.getParameter("mlcFlag").equals("1")){
						String flag = "";
						if(request.getParameter("flag") != null){
							flag = request.getParameter("flag");
							map.put("flag", flag);
						}
						mlcMap = adtHandlerService.getDetailsForMLC();
						mlcNo = adtHandlerService.generateMLCNo(adMap);
						
						mlcMap = adtHandlerService.getDetailsForMLCHAL(tx, ses);
						mlcNo = adtHandlerService.generateMLCNoHAL(adMap, tx, ses);
						
						mapForDs.put("hinId", hinId);
						patientDetailsMap = adtHandlerService.getPatientDetails(mapForDs);
						patientDetailsMap = adtHandlerService.getPatientDetailsHAL(mapForDs, tx, ses);
						
						
						
						message = "Patient has been admitted successfully with A & D No. '"+adNo+"'";
						jsp = "mlc_case.jsp";
						map.put("mlcNo", mlcNo);
						map.put("adNo", adNo);
						map.put("condition",condition);
						map.put("message", message);
						map.put("patientMap", patientDetailsMap);
						map.put("detailsMap", mlcMap);
					}else if(request.getParameter(ATTACH_ADMISSION) != null){
						
						message = "Patient has been admitted successfully with A & D No. '"+adNo+"'";
						jsp=ATTACH_ADMISSION_JSP+".jsp";
						attachPatientMap.put("parentAdNo", adNo);
						attachPatientMap.put("hinId", hinId);
						attachDetailsMap = adtHandlerService.getAttachPatientDetails(attachPatientMap);
						attachDetailsMap = adtHandlerService.getAttachPatientDetailsHAL(attachPatientMap, tx, ses);
						mapForDs.put("hinId", hinId);
						patientDetailsMap = adtHandlerService.getPatientDetails(mapForDs);
						detailsMasterMap = adtHandlerService.getAdmissionDetails(hospitalId);
						patientDetailsMap = adtHandlerService.getPatientDetailsHAL(mapForDs, tx, ses);
						detailsMasterMap = adtHandlerService.getAdmissionDetailsHAL(hospitalId, tx, ses);
						
						map.put("attachMap", attachDetailsMap);
						map.put("patientMap", patientDetailsMap);
						map.put("detailsMap", detailsMasterMap);
						map.put("message", message);
						map.put("inpatientList",inpatientList);
						map.put("adNo", adNo);
						map.put("serviceNo", serviceNo);
					}else{
						message = "Patient has been admitted successfully with A & D No. '"+adNo+"'.Do you want to print? ";
						
						map.put("adNo", adNo);
						//adtHandlerService.closeHibernateSession();
						map.put("message", message);
						jsp = MESSAGE_FOR_ADT_JSP+".jsp";
					}*/
					
					message = "Patient has been admitted successfully with A & D No. '"+adNo+"'.Do you want to print? ";					
					map.put("adNo", adNo);
					
				}else{
					if(adNo.equalsIgnoreCase("NO"))
						message = "Some Error Has occured While Generating AdNo.";
					else
						message = "Some Error Has occured.";
					/*jsp = MESSAGE_FOR_ADT_JSP+".jsp";
					map.put("message", message);*/
					//adtHandlerService.closeHibernateSession();
				}
			
		}
		
		
		
		
		
		jsp = MESSAGE_FOR_ADT_JSP+".jsp";
		map.put("message", message);
		
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		if(tx!=null)
			tx.rollback();
	}
	finally
	{
		
		if(tx!=null)
			tx.commit();
		
		if(ses!=null)
			ses.close();
	}
			String backUrl = "";
			backUrl = "/hms/hms/adt?method=showAdmissionJsp";
			map.put("backUrl", backUrl);
			
			map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView printIPAdmissionSlip(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String adNo = "";
		if(request.getParameter("adNo") != null){
			adNo = request.getParameter("adNo");
		}	
		detailsMap = adtHandlerService.getConnectionForReport();
		parameters.put("adNo", adNo);
//		try {
//			byte bytes[] = null;
//			try
//			{
//			bytes =	JasperRunManager.runReportToPdf(getCompiledReport("IPAdmissionSlip"),parameters,(Connection)detailsMap.get("conn"));
//			}
//			catch(JRException e)
//			{
//				e.printStackTrace();
//			}
//			
//			//response.setHeader("Content-Disposition", "attachment; filename=RegistrationCard.pdf");
//			response.setContentType("application/pdf");
//			response.setContentLength(bytes.length);
//			ServletOutputStream ouputStream;
//			try {
//				ouputStream = response.getOutputStream();
//				ouputStream.write(bytes, 0, bytes.length);
//				ouputStream.flush();
//				ouputStream.close();
//				} catch (IOException e) 
//				{
//					e.printStackTrace();
//				}
			HMSUtil.generateReport("IPAdmissionSlip", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		}
		return null;
	}
	
	
	public ModelAndView getMotherName(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		String motherAdNo = request.getParameter("motherAd");
		String motherName = adtHandlerService.getMotherName(motherAdNo);
		if(motherName.equals("")){
			motherName="No Records Matched!";
		}
		String jsp = AJAX_MESSAGE_JSP;
		String message=motherName;
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
		
	}
	
//	public ModelAndView showAttachWindow(HttpServletRequest request, HttpServletResponse response){
//		Map<String, Object> map = new HashMap<String, Object>();
//		Map<String, Object> detailsMasterMap = new HashMap<String, Object>();
//		Map<String, Object> patientDetailsMap = new HashMap<String, Object>();
//		Map<String, Object> mapForDs = new HashMap<String, Object>();
//		Map<String, Object> attachDetailsMap = new HashMap<String, Object>();
//		int hinId = 0;
//		
//		if(!request.getParameter("hinId").equals("0")){
//			hinId = Integer.parseInt(request.getParameter("hinId"));
//		}
//		mapForDs.put("hinId", hinId);
//		
//		attachDetailsMap = adtHandlerService.getAttachPatientDetails(hinId);
//		patientDetailsMap = adtHandlerService.getPatientDetails(mapForDs);
//		detailsMasterMap = adtHandlerService.getAdmissionDetails();
//		jsp = ATTACH_ADMISSION_JSP;
//		
//		map.put("attachMap", attachDetailsMap);
//		map.put("patientMap", patientDetailsMap);
//		map.put("detailsMap", detailsMasterMap);
//		return new ModelAndView(jsp, "map", map);
//		
//	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView saveAttachedAdmission(HttpServletRequest request, HttpServletResponse response){
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> attachMap = new HashMap<String, Object>();
		Map<String, Object> detailsMasterMap = new HashMap<String, Object>();
		Map<String, Object> patientDetailsMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> attachDetailsMap = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		String formName = "";
		String attachName = "";
		String age = "";
		String dietType = "";
		String attachTime = "";
		String serviceTypeCode = "";
		String adNo = "";
		int sexId = 0;
		int dietId = 0;
		int relationId = 0;
		int wardId = 0;
		int hinId = 0;
		int hospitalId = 0;
		String atOrDt ="";
		String serviceNo ="";
		int serviceTypeid =0;
		AttachInpatient attachInpatient = new AttachInpatient();
		String parentAdNo=""+box.get("parentAdNo");
		HttpSession session = request.getSession();
		try{
		if(session.getAttribute(HOSPITAL_ID) != "0"){
			 hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			attachInpatient.setHospital(masHospital);
		}
		if(request.getParameter(SERVICE_NO) != null){
			serviceNo = request.getParameter(SERVICE_NO); 
		}
		if(request.getParameter(SERVICE_TYPE_ID) != null){
			serviceTypeid =Integer.parseInt(""+request.getParameter(SERVICE_TYPE_ID)) ; 
		}
		if(request.getParameter("formName") != null){
			formName = request.getParameter("formName"); 
		}
		if(request.getParameter(NAME_OF_ATTACH) != null){
			attachName = request.getParameter(NAME_OF_ATTACH); 
			attachInpatient.setNameOfAttached(attachName);
		}
		String ageUnit ="";
		if(request.getParameter(AGE) != null){
			age = request.getParameter(AGE); 
			if(request.getParameter(AGE_UNIT) != null){
				ageUnit =request.getParameter(AGE_UNIT);
			}
			age=age+" "+ageUnit;
			attachInpatient.setAge(age);
			attachMap.put("age", age);
		}
		if(request.getParameter(DIET_TYPE) != null){
			dietType = request.getParameter(DIET_TYPE);
			attachInpatient.setDietType(dietType);
		}
		if(!request.getParameter(HIN_ID).equals("0")){
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			attachMap.put("hinId", hinId);
		}
		if(!request.getParameter(DIET_ID).equals("0")){
			dietId = Integer.parseInt(request.getParameter(DIET_ID));
			attachMap.put("dietId", dietId);
		}
		if(!request.getParameter(SEX_ID).equals("0")){
			sexId = Integer.parseInt(request.getParameter(SEX_ID));
			attachMap.put("sexId", sexId);
		}
		if(!request.getParameter(RELATION_ID).equals("0")){
			relationId = Integer.parseInt(request.getParameter(RELATION_ID));
			attachMap.put("relationId", relationId);
		}
		if(!request.getParameter(DEPARTMENT_ID).equals("0")){
			wardId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			attachMap.put("wardId", wardId);
		}
		if(request.getParameter(BED_ID)!= null && !request.getParameter(BED_ID).equals("0")){
			int bedId = Integer.parseInt(request.getParameter(BED_ID));
			MasBed bed = new MasBed();
			bed.setId(bedId);
			attachInpatient.setBed(bed);
			attachMap.put("bedId", bedId);
		}
		if(!request.getParameter(DIET_ID).equals("0")){
			dietId = Integer.parseInt(request.getParameter(DIET_ID));
			attachMap.put("dietId", dietId);
		}
		if(!request.getParameter(HSR_RECEIPT_NO).equals("0")){
			String hsrReceiptNo = (""+request.getParameter(HSR_RECEIPT_NO));
			attachMap.put("hsrReceiptNo",hsrReceiptNo);
		}
		if(!request.getParameter(HSR_AMOUNT).equals("")){
			String hsrAmount =(request.getParameter(HSR_AMOUNT));
			attachMap.put("hsrAmount",hsrAmount);
		}
		if(request.getParameter(CHANGED_DATE) != null){
			attachInpatient.setAttachDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE)));
		}
		if(request.getParameter(CHANGED_TIME) != null){
			attachTime = request.getParameter(CHANGED_TIME);
			attachInpatient.setAttachTime(attachTime);
		}
		if(request.getParameter(SERVICE_TYPE_CODE) != null){
			serviceTypeCode = request.getParameter(SERVICE_TYPE_CODE);
		}
		if(request.getParameter(AT_OR_DT) != null){
			atOrDt = request.getParameter(AT_OR_DT);
		}
		
		Users user = (Users)session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		attachInpatient.setAddEditBy(userObj);
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTimeWithoutSc");
		
		attachInpatient.setAttachDate(HMSUtil.convertStringTypeDateToDateType(date));
		attachInpatient.setAttachTime(time);
		attachInpatient.setStatus("y");
		
		Map<String, Object> adMap = new HashMap<String, Object>();
		adMap.put("serviceTypeCode", serviceTypeCode);
		adMap.put("date", date);
		//adNo = adtHandlerService.generateAdNumber(adMap);
		if(adNo != null){
			attachInpatient.setAdNo(adNo);
		}
		attachMap.put("attachInpatient", attachInpatient);
		attachMap.put("hospitalId",hospitalId);
		attachMap.put("attachName", attachName);
		attachMap.put("box",box);
		attachMap.put("parentAdNo",parentAdNo);
		attachMap.put("atOrDt",atOrDt);
		Map<String, Object> tempMap = new HashMap<String, Object>();
		  List<Inpatient> inpatientList =new ArrayList<Inpatient>();
		String attachFlag = "";
		int serviceTypeId = 0;
		if(request.getParameter(SERVICE_TYPE_ID) != null){
			serviceTypeId =Integer.parseInt(""+request.getParameter(SERVICE_TYPE_ID)) ;
		}
		attachMap.put("wardId", wardId);
		attachMap.put("serviceNo", serviceNo);
		attachMap.put("serviceTypeId", serviceTypeId);
		 tempMap = adtHandlerService.saveAttachedAdmission(attachMap);
		 inpatientList= (List<Inpatient>) tempMap.get("inpatientList");
		 attachFlag=""+tempMap.get("attachFlag");
		 adNo=""+tempMap.get("adNo");
		String message = "";
		if(attachFlag.equals("true")){
			message = "Attach Patient has been submitted successfully with A & D No. '"+adNo+"'";
			jsp=ATTACH_ADMISSION_JSP+".jsp";
			
			Map<String, Object> attachPatientMap = new HashMap<String, Object>();
			attachPatientMap.put("hinId", hinId);
			attachPatientMap.put("parentAdNo", parentAdNo);
			mapForDs.put("serviceNo", serviceNo);
			attachDetailsMap = adtHandlerService.getAttachPatientDetails(attachPatientMap);
			patientDetailsMap = adtHandlerService.getPatientDetails(mapForDs);
			detailsMasterMap = adtHandlerService.getAdmissionDetails(hospitalId);
			
			map.put("attachMap", attachDetailsMap);
			map.put("patientMap", patientDetailsMap);
			map.put("detailsMap", detailsMasterMap);
			map.put("message", message);
			map.put("inpatientList",inpatientList);
			map.put("adNo", adNo);
		}else{
			message = "Some Error has occured";
			jsp = MESSAGE_FOR_ADT_JSP+".jsp";
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("serviceNo",serviceNo);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showMedicoLegalCaseDetails(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mlcMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		
		String flag = "";
		String mlcNo = "";
		int visitNo = 0;
		String hin = "";
		String adNo = "";
		String condition = "";
		boolean exist = false;
		String message = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> mlcDetailsMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		parameterMap.put("date", date);
		
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		if(request.getParameter(VISIT_NUMBER) != null){
			visitNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
			map.put("visitNo", visitNo);
			parameterMap.put("visitNo", visitNo);
	 	}
		
		if(request.getParameter(HIN_NO) != null){
			hin = request.getParameter(HIN_NO);
			parameterMap.put("hinNo", hin);
		}
		if(request.getParameter(AD_NO) != null){
			adNo = request.getParameter(AD_NO);
			parameterMap.put("adNo", adNo);
		}
		if(request.getParameter("condition") != null){
			condition = request.getParameter("condition");
			//parameterMap.put("condition",condition);
		}
		HttpSession session = request.getSession();
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		parameterMap.put("hospitalId", hospitalId);
		patientMap = adtHandlerService.getPatientDetails(parameterMap);
		
		mlcDetailsMap=adtHandlerService.getMlcDetails(parameterMap);
		
		exist =(Boolean)mlcDetailsMap.get("status");
		condition = (String)mlcDetailsMap.get("condition");
		
		if(exist){
			if(adNo != ""){
			jsp = IP_MLC_CASE_JSP+".jsp";
		    message ="IP MLC already added for "+ adNo +" admission";
			}else if(visitNo != 0){
		    jsp = OP_MLC_CASE_JSP+".jsp";
		    message ="OP MLC already added for visitNo "+ visitNo+"";
			}
		map.put("message", message);
		}else{
		mlcMap = adtHandlerService.getDetailsForMLC();
		mlcNo = adtHandlerService.generateMLCNo(parameterMap);
		map.put("mlcNo", mlcNo);
		map.put("adNo", adNo);
		map.put("condition",condition);
		jsp = MEDICO_LEGAL_CASE_JSP+".jsp";
		map.put("patientMap", patientMap);
		map.put("detailsMap", mlcMap);
		}
		
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
		
	}
	
	public ModelAndView submitMLCDetails(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		Users user = new Users();
		if(session.getAttribute("users") != null){
			user = (Users)session.getAttribute("users");
		}
		box.put("userId", user.getId());
		boolean mlcFlag = adtHandlerService.submitMLCDetails(box);
		String message = "";
		if(mlcFlag == true){
			message = "MLC Information has been submitted.Do you want to print ?";
		
		}else{
			message = "Some Error Occurred. ";

		}
//		jsp = "messageForOPMlc"+".jsp";
		String backFlag = "";
		if(request.getParameter("backFlag")!=null)
		{ 
			backFlag =request.getParameter("backFlag");
		}
		String jsp = "";
		if(backFlag.equals("OPD")){
			jsp = "messageForOPMlc";
		}else{
			
			map.put("contentJsp", "messageForOPMlc.jsp");
			jsp = "index";
		}
		map.put("backFlag", backFlag);
		map.put("message", message);
		map.put("mlcNo",box.getString(MLC_NO));
		return new ModelAndView(jsp, "map", map);
		
	}
	
	public ModelAndView showTransferJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		map = adtHandlerService.getDetailsForSearch(hospitalId);
		
		jsp = PATIENT_TRANSFER_SEARCH_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientDetailsForTransfer(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String serviceNo = "";
		String hinNo = "";	
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		int wardId = 0;
		String serPersonFName = "";
		String serPersonMName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String adNo = "";	
		int inpatientId = 0;
		try{
				Users userObj = (Users)session.getAttribute("users");
				if(userObj!= null){
					mapForDs.put("user", userObj);
				}
				
			if(request.getParameter(AD_NO) != null && !(request.getParameter(AD_NO).equals(""))){
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if(request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))){
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if(request.getParameter(SERVICE_NO) != null && !(request.getParameter(SERVICE_NO).equals(""))){
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if(request.getParameter(SERVICE_TYPE_ID) != null && !(request.getParameter(SERVICE_TYPE_ID).equals("0"))){
				serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID)) ;
				mapForDs.put("serviceTypeId", serviceTypeId);
			}
			if(request.getParameter(RANK_ID) != null && !(request.getParameter(RANK_ID).equals(""))){
				rankId = Integer.parseInt(request.getParameter(RANK_ID)) ;
				mapForDs.put("rankId", rankId);
			}
			if(request.getParameter(UNIT_ID) != null && !(request.getParameter(UNIT_ID).equals("0"))){
				unitId = Integer.parseInt(request.getParameter(UNIT_ID)) ;
				mapForDs.put("unitId", unitId);
			}
			if(request.getParameter(UNIT_ID) != null && !(request.getParameter(WARD_ID).equals("0"))){
				wardId = Integer.parseInt(request.getParameter(WARD_ID)) ;
				mapForDs.put("wardId", wardId);
			}
			if(request.getParameter(S_FIRST_NAME) != null && !(request.getParameter(S_FIRST_NAME).equals(""))){
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if(request.getParameter(S_MIDDLE_NAME) != null && !(request.getParameter(S_MIDDLE_NAME).equals(""))){
				serPersonMName = request.getParameter(S_MIDDLE_NAME);
				mapForDs.put("serPersonMName", serPersonMName);
			}
			if(request.getParameter(S_LAST_NAME) != null && !(request.getParameter(S_LAST_NAME).equals(""))){
				serPersonLName = request.getParameter(S_LAST_NAME);
				mapForDs.put("serPersonLName", serPersonLName);
			}
			if(request.getParameter(P_FIRST_NAME) != null && !(request.getParameter(P_FIRST_NAME).equals(""))){
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if(request.getParameter(P_MIDDLE_NAME) != null && !(request.getParameter(P_MIDDLE_NAME).equals(""))){
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDs.put("patientMName", patientMName);
			}
			if(request.getParameter(P_LAST_NAME) != null && !(request.getParameter(P_LAST_NAME).equals(""))){
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if(request.getParameter("inpatientId")!= null){
				inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = adtHandlerService.getPatientDetailsForTransfer(mapForDs);
		String jsp = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		
		if(patientMap.get("inpatientList") != null){
			inpatientList = (List<Inpatient>)patientMap.get("inpatientList");
		}
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		if((!adNo.equals("") && inpatientList.size() > 0 ) || inpatientId != 0){
				detailsMap = adtHandlerService.getTransferDetails(hospitalId);
				jsp = TRANSFER_BY_HIN_NO_JSP+".jsp";
		}else{
			map = adtHandlerService.getDetailsForSearch(hospitalId);
			jsp = PATIENT_TRANSFER_SEARCH_JSP+".jsp";
		}
		
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	
	public ModelAndView submitTransferInformation(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Transfer transfer = new Transfer();
		int hinId = 0;
		int fromWardId = 0;
		int toWardId = 0;
		int fromDoctorId = 0;
		int toDoctorId = 0;
		int fromBedId = 0;
		int toBedId = 0;
		int authorizerId = 0;
		
		HttpSession session = request.getSession();
		System.out.println("transferedSuccessfullytop1");
		
		String adNo = "";
		if(request.getParameter(TRANSFER_NO) != null){
			transfer.setTransferNo(Integer.parseInt(request.getParameter(TRANSFER_NO)));
		}
		if(request.getParameter(HIN_ID) != null){
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			Patient patient = new Patient();
			patient.setId(hinId);
			transfer.setHin(patient);
		}
		if(request.getParameter(AD_NO) != null){
			adNo = request.getParameter(AD_NO);
			transfer.setAdNo(adNo);
		}
		if(request.getParameter(FROM_WARD) != null){
			fromWardId = Integer.parseInt(request.getParameter(FROM_WARD));
			MasDepartment fromWardObj = new MasDepartment();
			fromWardObj.setId(fromWardId);
			transfer.setFromWard(fromWardObj);
		}
		if(request.getParameter(TO_WARD) != null && !request.getParameter(TO_WARD).equals("0")){
			toWardId = Integer.parseInt(request.getParameter(TO_WARD));
			MasDepartment toWardObj = new MasDepartment();
			toWardObj.setId(toWardId);
			transfer.setToWard(toWardObj);
		}
		else
		{
			toWardId = Integer.parseInt(request.getParameter(FROM_WARD));
			MasDepartment toWardObj = new MasDepartment();
			toWardObj.setId(toWardId);
			transfer.setToWard(toWardObj);
		}
		System.out.println("transferedSuccessfullytop2");
		if(request.getParameter(FROM_DOCTOR) != null){
			fromDoctorId = Integer.parseInt(request.getParameter(FROM_DOCTOR));
			MasEmployee fromDoctorObj = new MasEmployee();
			fromDoctorObj.setId(fromDoctorId);
			transfer.setFromDoctor(fromDoctorObj);
		}
		if(!request.getParameter(TO_DOCTOR).equals("0")){
			toDoctorId = Integer.parseInt(request.getParameter(TO_DOCTOR));
			MasEmployee toDoctorObj = new MasEmployee();
			toDoctorObj.setId(toDoctorId);
			transfer.setToDoctor(toDoctorObj);
		}
		System.out.println("transferedSuccessfullytop3");
		if(request.getParameter(FROM_BED) != null){
			fromBedId = Integer.parseInt(request.getParameter(FROM_BED));
			MasBed fromBedObj = new MasBed();
			fromBedObj.setId(fromBedId);
			transfer.setFromBed(fromBedObj);
		}
		if(request.getParameter("inpatientId") != null && !request.getParameter("inpatientId").trim().equals("0")){
			Inpatient inpatietObj = new Inpatient();
			inpatietObj.setId(Integer.parseInt(request.getParameter("inpatientId")));
			transfer.setInpatient(inpatietObj);
		}
		if(request.getParameter(BED_ID)!= null && !request.getParameter(BED_ID).equals("0") && !request.getParameter(BED_ID).equals("")){
			toBedId = Integer.parseInt(request.getParameter(BED_ID));
			MasBed bed = new MasBed();
			bed.setId(toBedId);
			transfer.setToBed(bed);
		}
		else
		{
			toBedId = Integer.parseInt(request.getParameter(FROM_BED));
			MasBed bed = new MasBed();
			bed.setId(toBedId);
			transfer.setToBed(bed);
		}
		if(request.getParameter(TRANSFER_DATE) != null){
			transfer.setDateOfTransfer(HMSUtil.convertStringTypeDateToDateType(request.getParameter(TRANSFER_DATE)));
		}
		if(request.getParameter(TRANSFER_TIME) != null){
			transfer.setTimeOfTransfer(request.getParameter(TRANSFER_TIME));
		}
		if(request.getParameter(AD_STATUS) != null){
			transfer.setAdStatus(request.getParameter(AD_STATUS));
		}
//		if(request.getParameter(LIST) != null && !(request.getParameter(LIST).equals("0"))){
//			transfer.setList(request.getParameter(LIST));
//		}
//		if(request.getParameter(LIST_DATE) != null){
//			transfer.setListDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(LIST_DATE)));
//		}
//		if(request.getParameter(LIST_TIME) != null){
//			transfer.setListTime(request.getParameter(LIST_TIME));
//		}
//		if(!request.getParameter(CONDITION).equals("0")){
//			transfer.setPatientCondition(request.getParameter(CONDITION));
//		}
		/*if(!request.getParameter(AUTHORIZER_ID).equals("0")){
			MasEmployee masEmployee = new MasEmployee();
			authorizerId = Integer.parseInt(request.getParameter(AUTHORIZER_ID));
			masEmployee.setId(authorizerId);
			transfer.setAuthorizedBy(masEmployee);
		}*/
		System.out.println("transferedSuccessfullytop5");
		Users user = (Users)session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		transfer.setAddEditBy(userObj);

		int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		transfer.setHospital(masHospital);
		
		
		if(request.getParameter(CHANGED_DATE) != null){
			Date addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			transfer.setAddEditDate(addEditDate);
		}
		if(request.getParameter(CHANGED_TIME) != null){
			String addEditTime = request.getParameter(CHANGED_TIME);
			transfer.setAddEditTime(addEditTime);
		}
		if(request.getParameter("transfer_reason") != null){
			String transfer_reason = request.getParameter("transfer_reason");
			transfer.setTransferReason(transfer_reason);
		}
		transfer.setStatus("y");
		System.out.println("transferedSuccessfullytop6");
		Map<String, Object> transferMap = new HashMap<String, Object>();
		transferMap.put("adNo", adNo);
		transferMap.put("transfer",transfer);
		transferMap.put("fromBedId", fromBedId);
		transferMap.put("toBedId", toBedId);		
		transferMap.put("toDoctorId", toDoctorId);
		transferMap.put("toWardId", toWardId);
		transferMap.put("hospitalId", hospitalId);
		System.out.println("transferedSuccessfullytop7");
		boolean transferedSuccessfully = false;
		transferedSuccessfully = adtHandlerService.submitTransferInformation(transferMap);
		int deptId = (Integer)session.getAttribute("deptId");
		String message = "";
		/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
		map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, user.getEmployee().getId());
		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		jsp = PATIENT_LIST_JSP+".jsp";
		if (transferedSuccessfully) {
			message=" Transfer has been completed Successfully.";
		}else{
			message = "Some problem Occured! Try Again.";
		}
		
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showDischargeJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		map = adtHandlerService.getDetailsForSearch(hospitalId);
		jsp = PATIENT_DISCHARGE_SEARCH_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientDetailsForDischarge(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();
		String hinNo = "";	
		int wardId = 0;
		String adNo = "";	
		int inpatientId = 0;
		String serviceNo = "";
		HttpSession session = request.getSession();
		
		try{
			
			Users userObj = (Users)session.getAttribute("users");
			/*int userId = userObj.getId();
			Users user = new Users();
			user.setId(userId);*/
			if(userObj!= null){
				mapForDs.put("user", userObj);
			}
			mapForDs.put("hospitalId", session.getAttribute("hospitalId"));
			if(request.getParameter(SERVICE_NO) != null && !(request.getParameter(SERVICE_NO).equals(""))){
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if(request.getParameter(AD_NO) != null && !(request.getParameter(AD_NO).equals(""))){
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if(request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))){
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if(request.getParameter(WARD_ID) != null && !(request.getParameter(WARD_ID).equals("0"))){
				wardId = Integer.parseInt(request.getParameter(WARD_ID)) ;
				mapForDs.put("wardId", wardId);
			}
			if(request.getParameter("inpatientId")!= null){
				inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		patientMap = adtHandlerService.getPatientDetailsForDischarge(mapForDs);
		
		String jsp = "";
		String message = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Inpatient> inpatientTempList = new ArrayList<Inpatient>();
		
		if(patientMap.get("inpatientList") != null){
			inpatientList = (List<Inpatient>)patientMap.get("inpatientList");
		}
		if(patientMap.get("inpatientTempList") != null){
			inpatientTempList = (List<Inpatient>)patientMap.get("inpatientTempList");
		}
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		
		if((!adNo.equals("") && inpatientList.size() > 0 ) || inpatientId != 0){
				detailsMap = adtHandlerService.getDischargeDetails();
				patientDiagnosisMap = adtHandlerService.getPatientDiagnosis(adNo, inpatientId);
				map.put("patientDiagnosisMap", patientDiagnosisMap);
				jsp = DISCHARGE_BY_HIN_NO_JSP+".jsp";
		}else if(!adNo.equals("") && inpatientTempList.size() > 0 && inpatientList.size() == 0){
			map = adtHandlerService.getDetailsForSearch(hospitalId);
			message = "Discharge Summary of patient is not prepared.Please first prepare discharge summary.";
			map.put("message", message);
			jsp = PATIENT_DISCHARGE_SEARCH_JSP+".jsp";
		}else{
			map = adtHandlerService.getDetailsForSearch(hospitalId);
			jsp = PATIENT_DISCHARGE_SEARCH_JSP+".jsp";
		}
		
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	public ModelAndView submitDischargeInformation(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Discharge discharge = new Discharge();
		int hinId = 0;
		int bedId = 0;
		String adNo = "";
		int disposedToId = 0;
		int disposalId = 0;
		int careTypeId = 0;
		int doctorId = 0;
		int inpatientId = 0;
		Date dischargeDate = null;
		String dischargeTime = "";
		int dischargeStatusId = 0;
		int departmentId = 0;
		
		HttpSession session = request.getSession();
		
		if(request.getParameter(INPATIENT_ID) != null){
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			discharge.setInpatient(inpatient);
		}
		if(request.getParameter(DISCHARGE_NO) != null){
			discharge.setDischargeNo(Integer.parseInt(request.getParameter(DISCHARGE_NO)));
		}
		if(request.getParameter("workingDiagnosis") != null){
			discharge.setWorkingDiagnosis(request.getParameter("workingDiagnosis"));
		}
		if(request.getParameter(HIN_ID) != null){
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			Patient patient = new Patient();
			
			patient.setId(hinId);
			discharge.setHin(patient);
		}
		if(request.getParameter(AD_NO) != null){
			adNo = request.getParameter(AD_NO);
			discharge.setAdNo(adNo);
		}
		if(!request.getParameter(DISPOSAL_ID).equals("0")){
			disposalId = Integer.parseInt(request.getParameter(DISPOSAL_ID));
			MasDisposal masDisposal = new MasDisposal();
			masDisposal.setId(disposalId);
			discharge.setDisposal(masDisposal);
		}
		if(!request.getParameter(DISPOSED_TO_ID).equals("0")){
			disposedToId = Integer.parseInt(request.getParameter(DISPOSED_TO_ID));
			MasDisposedTo masDisposedTo = new MasDisposedTo();
			masDisposedTo.setId(disposedToId);
			discharge.setDisposedTo(masDisposedTo);
		}
		if(!request.getParameter(CARE_TYPE_ID).equals("0")){
			careTypeId = Integer.parseInt(request.getParameter(CARE_TYPE_ID));
			MasCareType masCareType = new MasCareType();
			masCareType.setId(careTypeId);
			discharge.setCareType(masCareType);
		}
		if(!request.getParameter(DOCTOR_NAME).equals("0")){
			doctorId = Integer.parseInt(request.getParameter(DOCTOR_NAME));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(doctorId);
			discharge.setDoctor(masEmployee);
		}
		if(!request.getParameter(DISCHARGE_STATUS_ID).equals("0")){
			dischargeStatusId = Integer.parseInt(request.getParameter(DISCHARGE_STATUS_ID));
			MasDischargeStatus masDischargeStatus = new MasDischargeStatus();
			masDischargeStatus.setId(dischargeStatusId);
			discharge.setDischargeStatus(masDischargeStatus);
		}
		if(!request.getParameter(DEPARTMENT_ID).equals("0")){
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			discharge.setWard(masDepartment);
		}
		
		if(request.getParameter(AD_STATUS) != null){
			discharge.setAdStatus(request.getParameter(AD_STATUS));
		}
		if(request.getParameter(DISCHARGE_IN_MEDICAL_CATEGORY) != null ){
			discharge.setDischargeInMedicalCategory(request.getParameter(DISCHARGE_IN_MEDICAL_CATEGORY));
		}
		if(request.getParameter(INJURY_REPORT_INITIATED_ON) != null && !(request.getParameter(INJURY_REPORT_INITIATED_ON).equals(""))){
			discharge.setInjuryReportInitiatedOn(HMSUtil.convertStringTypeDateToDateType(request.getParameter(INJURY_REPORT_INITIATED_ON)));
		}
		if(request.getParameter(BOARD_HELD_ON) != null && !(request.getParameter(BOARD_HELD_ON).equals(""))){
			discharge.setBoardHeldOn(HMSUtil.convertStringTypeDateToDateType(request.getParameter(BOARD_HELD_ON)));
		}
		if(request.getParameter(CARE_SUMMARY) != null){
			discharge.setCareSummary(request.getParameter(CARE_SUMMARY));
		}
		if(request.getParameter(INSTRUCTIONS) != null){
			discharge.setInstructionsToPatient(request.getParameter(INSTRUCTIONS));
		}
		if(request.getParameter(FOLLOW_UP) != null && !(request.getParameter(FOLLOW_UP).equals(""))){
			discharge.setFollowUpDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FOLLOW_UP)));
		}
		if(request.getParameter(OTHER_HOSPITAL_NAME) != null && !request.getParameter(OTHER_HOSPITAL_NAME).equals("")){
			discharge.setOtherHospital(request.getParameter(OTHER_HOSPITAL_NAME));
		}
		
		if(request.getParameter("injury_report_init_at") != null && !request.getParameter("injury_report_init_at").equals("")){
			discharge.setInjuryReportInitAt(request.getParameter("injury_report_init_at"));
		}
		
		if(request.getParameter("document_initiated") != null && !request.getParameter("document_initiated").equals("")){
			discharge.setDocumentInitiated(request.getParameter("document_initiated"));
		}
		
		bedId = Integer.parseInt(request.getParameter(BED_ID));
		
		Users user = (Users)session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		discharge.setAddEditBy(userObj);
		Map<String, Object> dischargeMap = new HashMap<String, Object>();
		int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		discharge.setHospital(masHospital);
		String addEditTime = "";
		Date addEditDate = null;
		if(request.getParameter(DISCHARGE_DATE) != null){
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DISCHARGE_DATE));
			discharge.setAddEditDate(addEditDate);
			discharge.setDateOfDischarge(addEditDate);
			dischargeMap.put("addEditDate", addEditDate);
		}
		if(request.getParameter(DISCHARGE_TIME) != null){
			addEditTime = request.getParameter(DISCHARGE_TIME);
			discharge.setAddEditTime(addEditTime);
			discharge.setTimeOfDischarge(addEditTime);
			dischargeMap.put("addEditTime", addEditTime);
		}
		discharge.setStatus("y");
	//	if(disposedToId == 16 || disposedToId == 14)
			discharge.setDischargeAdviced("n");
		//else
		//	discharge.setDischargeAdviced("y");
		
		String[]  icdIdArr = null ;
		String[] disIdArray = null;
		StringBuffer documentStr = new StringBuffer();
		String icd ="";
			try{
				int j=0;
			if(request.getParameterValues(DIAGNOSIS_ID) !=null)
			if (!request.getParameterValues(DIAGNOSIS_ID).equals("0")) {
				disIdArray = (String[])(request.getParameterValues(DIAGNOSIS_ID));
				icdIdArr=new String[disIdArray.length];
				for (int i = 0; i < disIdArray.length; i++) {
					icd=disIdArray[i];
					if(!icd.equals("") ){
					 int index1=icd.lastIndexOf("[");
					 int index2=icd.lastIndexOf("]");
					 index1 =index1+1;
					icdIdArr[j]=(icd.substring(index1, index2));
					j++;
					}
				}
			}
			}catch (Exception e) {
				e.printStackTrace();
			}

			List<DischargeIcdCode> icdCodeList = new ArrayList<DischargeIcdCode>();
			try{
				String str="";
//				String[] diagnosidIdArray = null;
//				if(request.getParameterValues(DIAGNOSIS_ID) !=null)
//				if (!request.getParameterValues(DIAGNOSIS_ID).equals("0")) {
//					diagnosidIdArray = (String[])(request.getParameterValues(DIAGNOSIS_ID));
//				} 
				
				for(int i = 0 ; i<disIdArray.length; i++){
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					if(icdIdArr[i] !=null)
					if(!icdIdArr[i].equals("0")){
						Patient patient = new Patient();
						patient.setId(hinId);
						dischargeIcdCode.setHin(patient);
						
						Inpatient inpatient = new Inpatient();
						inpatient.setId(inpatientId);
						dischargeIcdCode.setInpatient(inpatient);
						
						if(request.getParameter(Z03) != null){
							dischargeIcdCode.setZ03("y");
						}else{
							dischargeIcdCode.setZ03("n");
						}
						 icd=disIdArray[i];
						if(icd.contains("{OLD}")){
							dischargeIcdCode.setZ09("y");
						}else{
							dischargeIcdCode.setZ09("n");
						}
						
						dischargeIcdCode.setDiagnosisStatus("f");
						
						Users userObject = new Users();
						userObject.setId(userId);
						dischargeIcdCode.setAddEditBy(userObject);
						
						dischargeIcdCode.setAddEditDate(addEditDate);
						dischargeIcdCode.setAddEditTime(addEditTime);
						dischargeIcdCode.setStatus("y");
						
						icdCodeList.add(dischargeIcdCode);
							str=(i+1+1)+"";
					}
				}
				dischargeMap.put("icdCodeList", icdCodeList);
				dischargeMap.put("icdIdArr", icdIdArr);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
	
		dischargeMap.put("hinId", hinId);
		dischargeMap.put("inpatientId", inpatientId);
		dischargeMap.put("adNo", adNo);
		dischargeMap.put("discharge",discharge);
		dischargeMap.put("bedId", bedId);
		dischargeMap.put("dischargeDate", dischargeDate);
		dischargeMap.put("dischargeTime", dischargeTime);

		boolean dischargeInfoSave = false;
		boolean discheck = false;
		Map<String, Object> dismap = new HashMap<String, Object>();
		String userSrNo = (String)session.getAttribute("userSrNo");
		dischargeMap.put("userSrNo",userSrNo);
		
		
		//dischargeInfoSave = adtHandlerService.submitDischargeInformation(dischargeMap);
		dismap = adtHandlerService.submitDischargeInformation(dischargeMap);
		
		
		discheck = (Boolean)dismap.get("dis");
		dischargeInfoSave = (Boolean)dismap.get("saved");
	
		String message = "";
		Map<String, Object> patientDetailsMap = new HashMap<String, Object>();
		patientDetailsMap.put("adNo", adNo);
		patientDetailsMap.put("inpatientId", inpatientId);
		if(discheck){
		if (dischargeInfoSave) {
			message=" Discharge Information has been submitted Successfully.Do you want print ?";
			if(request.getParameter("flag") != null && request.getParameter("flag").equals("expiry")){
				
				map = adtHandlerService.showExpiryDetails(patientDetailsMap);
				jsp = EXPIRY_DETAILS_JSP+".jsp";
				
			}else{
				jsp = MESSAGE_FOR_DISCHARGE_JSP+".jsp";
			}
		}else{
			message = "Some problem Occured! Try Again.";
			jsp = MESSAGE_FOR_DISCHARGE_JSP+".jsp";
		}
		}else{
			message = "Discharge Information already submitted. Do you want print ?";
			jsp = MESSAGE_FOR_DISCHARGE_JSP+".jsp";
		}
		String backUrl = "";
		backUrl = "/hms/hms/adt?method=showDischargeJsp";
		map.put("inpatientId", inpatientId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("backUrl", backUrl);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showFinalDischargeJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = adtHandlerService.getDepartmentList();
		jsp = FINAL_DISCHARGE_JSP+".jsp";
		map.put("departmentList", departmentList);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showReadyToDischargeList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> dischargeMap = new HashMap<String, Object>();
		int departmentId = 0;
		String serviceNo = null;
		String adNo = null;
		String hin = null;	
		
		try{
			if(request.getParameter(SERVICE_NO) != null && !(request.getParameter(SERVICE_NO).equals(""))){
				serviceNo = request.getParameter(SERVICE_NO);
				dischargeMap.put("serviceNo", serviceNo);
			}
			if(request.getParameter(AD_NO) != null && !(request.getParameter(AD_NO).equals(""))){
				adNo = request.getParameter(AD_NO);
				dischargeMap.put("adNo", adNo);
			}
			if(request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))){
				hin = request.getParameter(HIN_NO);
				dischargeMap.put("hin", hin);
			}
			if(!(request.getParameter(WARD_ID).equals("0"))){
				departmentId = Integer.parseInt(request.getParameter(WARD_ID)) ;
				dischargeMap.put("departmentId", departmentId);
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = adtHandlerService.getDischargePatientList(dischargeMap);
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = adtHandlerService.getDepartmentList();
		
		jsp = FINAL_DISCHARGE_JSP+".jsp";
		
		map.put("departmentList", departmentList);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("departmentId", departmentId);
		return new ModelAndView("indexB", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView dischargePatient(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		int dischargeId = 0;
		if(request.getParameter("parent") != null){
			dischargeId = Integer.parseInt(request.getParameter("parent"));
			detailsMap.put("dischargeId", dischargeId);
		}
		String  dischargeSuccessfully = "false";
		tempMap = adtHandlerService.dischargePatient(detailsMap);
	
		String message = "";
		dischargeSuccessfully=""+tempMap.get("dischargeSuccessfully");
		if (dischargeSuccessfully.equals("true") ) {
			message=" Discharged Successfully.Do you want print ?";
				
		}else{
			message = "Some problem Occured! Try Again.";
		}
		String backUrl = "";
		backUrl = "/hms/hms/adt?method=showFinalDischargeJsp";
		
		jsp = MESSAGE_FOR_DISCHARGE_JSP+".jsp";
		map.put("inpatientId",tempMap.get("inpatientId"));
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("backUrl", backUrl);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView submitExpiryDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		ExpiryDetails expiryDetails = new ExpiryDetails();
		int hinId = 0;
		int inpatientId = 0;
		int bedId = 0;
		int dCauseOfDeathId = 0;
		int sCauseOfDeathId = 0;
		int cCauseOfDeathId = 0;
		int relationId = 0;
		int blockId = 0;
		int districtId = 0;
		int stateId = 0;
		int countryId = 0;
		int wardId = 0;
		
		if(request.getParameter(INPATIENT_ID) != null){
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			expiryDetails.setInpatient(inpatient);
		}
		if(request.getParameter(HIN_ID) != null){
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			Patient patient = new Patient();
			patient.setId(hinId);
			expiryDetails.setHin(patient);
		}
		if(request.getParameter(WARD_ID) != null){
			wardId = Integer.parseInt(request.getParameter(WARD_ID));
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(wardId);
			expiryDetails.setWard(masDepartment);
		}
		if(request.getParameter(BED_ID) != null){
			bedId = Integer.parseInt(request.getParameter(BED_ID));
			MasBed masBed = new MasBed();
			masBed.setId(bedId);
			expiryDetails.setBed(masBed);
		}
		if(request.getParameter(D_DEATH_CAUSE_ID) !=  null){
			expiryDetails.setDDeathCauseText(""+request.getParameter(D_DEATH_CAUSE_ID));
		}
		if(request.getParameter(S_DEATH_CAUSE_ID) !=null){
			expiryDetails.setSDeathCauseText(""+request.getParameter(S_DEATH_CAUSE_ID));
		}
		if(request.getParameter(C_DEATH_CAUSE_ID) !=  null){
			expiryDetails.setCDeathCauseText(""+request.getParameter(C_DEATH_CAUSE_ID));
		}

		if(request.getParameter(INFORMANT_NAME) != null){
			expiryDetails.setInformantName(request.getParameter(INFORMANT_NAME));
		}
		if(!request.getParameter(RELATION_ID).equals("0")){
			relationId = Integer.parseInt(request.getParameter(RELATION_ID));
			MasRelation masRelation = new MasRelation();
			masRelation.setId(relationId);
			expiryDetails.setInformantRelation(masRelation);
		}
		
		if(!request.getParameter(DISTRICT_ID).equals("0")){
			districtId = Integer.parseInt(request.getParameter(DISTRICT_ID));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			expiryDetails.setInformantDistrict(masDistrict);
		}
		if(request.getParameter(ADDRESS) != null){
			expiryDetails.setInformantAddress(request.getParameter(ADDRESS));
		}
		
		if(!request.getParameter(BLOCK_ID).equals("0")){
			blockId = Integer.parseInt(request.getParameter(BLOCK_ID));
			MasBlock masBlock = new MasBlock();
			masBlock.setId(blockId);
			expiryDetails.setInformantBlock(masBlock);
		}
		if(!request.getParameter(COUNTRY_ID).equals("0")){
			countryId = Integer.parseInt(request.getParameter(COUNTRY_ID));
			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			expiryDetails.setInformantCountry(masCountry);
		}
		if(!request.getParameter(STATE_ID).equals("0")){
			stateId = Integer.parseInt(request.getParameter(STATE_ID));
			MasState masState = new MasState();
			masState.setId(stateId);
			expiryDetails.setInformantState(masState);
		}
		
		if(request.getParameter(DEATH_CERTIFICATE_NO) != null){
			expiryDetails.setDeathCertificateNo(request.getParameter(DEATH_CERTIFICATE_NO));
		}
		if(request.getParameter(DEATH_CERTIFICATE_TAKEN_BY) != null){
			expiryDetails.setDeathCertificateTakenBy(request.getParameter(DEATH_CERTIFICATE_TAKEN_BY));
		}
		if(request.getParameter(DATE_OF_EXPIRY) != null && !(request.getParameter(DATE_OF_EXPIRY).equals(""))){
			expiryDetails.setExpiryDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_EXPIRY)));
		}
		if(request.getParameter(TIME_OF_EXPIRY) != null){
			expiryDetails.setExpiryTime(request.getParameter(TIME_OF_EXPIRY));
		}
		if(request.getParameter(CONSQUENCE_OF) !=  null){
			expiryDetails.setConsequenceOf(""+request.getParameter(CONSQUENCE_OF));
		}
		if(request.getParameter(ID_MARK1) !=  null){
			expiryDetails.setIdMarks1(""+request.getParameter(ID_MARK1));
		}
		if(request.getParameter(ID_MARK2) !=  null){
			expiryDetails.setIdMarks2(""+request.getParameter(ID_MARK2));
		}
		if(request.getParameter(REMARKS) !=  null){
			expiryDetails.setRemarks(""+request.getParameter(REMARKS));
		}
		HttpSession session = request.getSession();
		
		int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		expiryDetails.setHospital(masHospital);
		
		Users user = (Users)session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		expiryDetails.setAddEditBy(userObj);
		
		if(request.getParameter(CHANGED_DATE) != null){
			Date addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			expiryDetails.setAddEditDate(addEditDate);
		}
		if(request.getParameter(CHANGED_TIME) != null){
			String addEditTime = request.getParameter(CHANGED_TIME);
			expiryDetails.setAddEditTime(addEditTime);
		}
		
		Map<String, Object> expiryDetilsMap = new HashMap<String, Object>();
		expiryDetilsMap.put("expiryDetails", expiryDetails);
		expiryDetilsMap.put("hinId", hinId);
		boolean saved = false;
		saved = adtHandlerService.submitExpiryDetails(expiryDetilsMap);
		String message = "";

		if (saved == true) {
			message="Expiry Details  saved successfully.Do you want print ?";
		}else{
			message = "Some problem Occured! Try Again.";
		}
		
		jsp = MESSAGE_FOR_EXPIRY_DETAILS+".jsp";
		map.put("inpatientId", inpatientId);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateExpiryDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		ExpiryDetails expiryDetails = new ExpiryDetails();
		int hinId = 0;
		int inpatientId = 0;
		int bedId = 0;
		int dCauseOfDeathId = 0;
		int sCauseOfDeathId = 0;
		int cCauseOfDeathId = 0;
		int relationId = 0;
		int blockId = 0;
		int districtId = 0;
		int stateId = 0;
		int countryId = 0;
		int wardId = 0;
		int expireId=0;
		
		if(request.getParameter(INPATIENT_ID) != null){
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			expiryDetails.setInpatient(inpatient);
		}
		if(request.getParameter(HIN_ID) != null){
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			Patient patient = new Patient();
			patient.setId(hinId);
			expiryDetails.setHin(patient);
		}
		if(request.getParameter(WARD_ID) != null){
			wardId = Integer.parseInt(request.getParameter(WARD_ID));
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(wardId);
			expiryDetails.setWard(masDepartment);
		}
		if(request.getParameter(BED_ID) != null){
			bedId = Integer.parseInt(request.getParameter(BED_ID));
			MasBed masBed = new MasBed();
			masBed.setId(bedId);
			expiryDetails.setBed(masBed);
		}
		if(request.getParameter("expireId") !=  null && !request.getParameter("expireId").equals("")){
			expiryDetails.setId(Integer.parseInt(request.getParameter("expireId")));
		}
		if(request.getParameter(D_DEATH_CAUSE_ID) !=  null){
			expiryDetails.setDDeathCauseText(""+request.getParameter(D_DEATH_CAUSE_ID));
		}
		if(request.getParameter(S_DEATH_CAUSE_ID) !=null){
			expiryDetails.setSDeathCauseText(""+request.getParameter(S_DEATH_CAUSE_ID));
		}
		if(request.getParameter(C_DEATH_CAUSE_ID) !=  null){
			expiryDetails.setCDeathCauseText(""+request.getParameter(C_DEATH_CAUSE_ID));
		}

		if(request.getParameter(INFORMANT_NAME) != null){
			expiryDetails.setInformantName(request.getParameter(INFORMANT_NAME));
		}
		if(!request.getParameter(RELATION_ID).equals("0")){
			relationId = Integer.parseInt(request.getParameter(RELATION_ID));
			MasRelation masRelation = new MasRelation();
			masRelation.setId(relationId);
			expiryDetails.setInformantRelation(masRelation);
		}
		
		if(!request.getParameter(DISTRICT_ID).equals("0")){
			districtId = Integer.parseInt(request.getParameter(DISTRICT_ID));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			expiryDetails.setInformantDistrict(masDistrict);
		}
		if(request.getParameter(ADDRESS) != null){
			expiryDetails.setInformantAddress(request.getParameter(ADDRESS));
		}
		
		if(!request.getParameter(BLOCK_ID).equals("0")){
			blockId = Integer.parseInt(request.getParameter(BLOCK_ID));
			MasBlock masBlock = new MasBlock();
			masBlock.setId(blockId);
			expiryDetails.setInformantBlock(masBlock);
		}
		if(!request.getParameter(COUNTRY_ID).equals("0")){
			countryId = Integer.parseInt(request.getParameter(COUNTRY_ID));
			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			expiryDetails.setInformantCountry(masCountry);
		}
		if(!request.getParameter(STATE_ID).equals("0")){
			stateId = Integer.parseInt(request.getParameter(STATE_ID));
			MasState masState = new MasState();
			masState.setId(stateId);
			expiryDetails.setInformantState(masState);
		}
		
		if(request.getParameter(DEATH_CERTIFICATE_NO) != null){
			expiryDetails.setDeathCertificateNo(request.getParameter(DEATH_CERTIFICATE_NO));
		}
		if(request.getParameter(DEATH_CERTIFICATE_TAKEN_BY) != null){
			expiryDetails.setDeathCertificateTakenBy(request.getParameter(DEATH_CERTIFICATE_TAKEN_BY));
		}
		if(request.getParameter(DATE_OF_EXPIRY) != null && !(request.getParameter(DATE_OF_EXPIRY).equals(""))){
			expiryDetails.setExpiryDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_EXPIRY)));
		}
		if(request.getParameter(TIME_OF_EXPIRY) != null){
			expiryDetails.setExpiryTime(request.getParameter(TIME_OF_EXPIRY));
		}
		if(request.getParameter(CONSQUENCE_OF) !=  null){
			expiryDetails.setConsequenceOf(""+request.getParameter(CONSQUENCE_OF));
		}
		if(request.getParameter(ID_MARK1) !=  null){
			expiryDetails.setIdMarks1(""+request.getParameter(ID_MARK1));
		}
		if(request.getParameter(ID_MARK2) !=  null){
			expiryDetails.setIdMarks2(""+request.getParameter(ID_MARK2));
		}
		if(request.getParameter(REMARKS) !=  null){
			expiryDetails.setRemarks(""+request.getParameter(REMARKS));
		}
		HttpSession session = request.getSession();
		
		int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		expiryDetails.setHospital(masHospital);
		
		Users user = (Users)session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		expiryDetails.setAddEditBy(userObj);
		
		if(request.getParameter(CHANGED_DATE) != null){
			Date addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			expiryDetails.setAddEditDate(addEditDate);
		}
		if(request.getParameter(CHANGED_TIME) != null){
			String addEditTime = request.getParameter(CHANGED_TIME);
			expiryDetails.setAddEditTime(addEditTime);
		}
		
		Map<String, Object> expiryDetilsMap = new HashMap<String, Object>();
		expiryDetilsMap.put("expiryDetails", expiryDetails);
		expiryDetilsMap.put("hinId", hinId);
		boolean saved = false;
		saved = adtHandlerService.updateExpiryDetails(expiryDetilsMap);
		String message = "";

		if (saved == true) {
			message="Expiry Details Update successfully.Do you want print ?";
		}else{
			message = "Some problem Occured! Try Again.";
		}
		
		jsp = MESSAGE_FOR_EXPIRY_DETAILS+".jsp";
		map.put("inpatientId", inpatientId);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
//	-----------------------------For Reports----------------
	
	
	public ModelAndView showIPAdmissionReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = IP_ADMISSION_REPORT_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView showIPAdmissionReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String adNo = "";
		String userName = "";
		int relation_id = 0;
		int service_status_id = 0;
		String service ="";
		String relationForReport = "";
		HttpSession session = request.getSession();
		String condition_status = "";
		StringBuffer condition_status_message = new StringBuffer();
		String hospitalName = "";
		int hospitalId=0;
		
		if (session.getAttribute("hospitalId") != null)
			hospitalId = (Integer) session.getAttribute("hospitalId");
		if (session.getAttribute("hospitalName") != null)
			hospitalName = (String) session.getAttribute("hospitalName");
		if (session.getAttribute("userName") != null)
		userName = (String) session.getAttribute("userName");
		if(request.getParameter(AD_NO) != null){
			adNo = request.getParameter(AD_NO);
		}
		@SuppressWarnings("unused")
		String subPath = "";
		//File reportFile =	new File(getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("adNo", adNo);
		List<Inpatient> inpatientList =new ArrayList<Inpatient>();
		detailsMap = adtHandlerService.getDiagnosisAndDocInit(dataMap);
		inpatientList=(List<Inpatient>)detailsMap.get("inpatientList");
		for(Inpatient inpatient :inpatientList){
			if(inpatient.getHin().getRelation() != null)
			relation_id =inpatient.getHin().getRelation().getId();
			if(inpatient.getHin().getServiceStatus() !=null)
			service_status_id = inpatient.getHin().getServiceStatus().getId();
			
			condition_status = inpatient.getConditionStatus()!=null?inpatient.getConditionStatus():"";
			if (condition_status.equalsIgnoreCase("SIL") || condition_status.equalsIgnoreCase("DIL"))
			{
				condition_status_message.append("Patient Admitted as ");
				condition_status_message.append(condition_status);
				condition_status_message.append(" on ");
				try{
					 SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
					 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
					 String date4MySQL=formatterOut.format(formatterIn.parse(""+inpatient.getDateOfAddmission()));
				     condition_status_message.append(date4MySQL);
				}catch (Exception e) {
					e.printStackTrace();
				}
				condition_status_message.append(" at ");
				condition_status_message.append(inpatient.getTimeOfAddmission());
			}
			if(inpatient.getHin().getRelation() !=null)
			if(Integer.parseInt(""+inpatient.getHin().getRelation().getId()) == 8){
			relationForReport =""+inpatient.getHin().getRelation().getRelationName();
			}else{
				relationForReport =""+inpatient.getHin().getRelation().getRelationName()+" of";
			}
		}
		if(service_status_id == 1 ){
			if(relation_id ==8){
				service ="Serving Personnel";
			}else{
				service = "Serving Personnel Dependent ";
			}
			
		}else if(service_status_id == 2){
			if(relation_id ==8){
				service ="Ex Service Personnel";
			}else{
				service = "Ex Service Personnel Dependent ";
			}
			
		}
	 	String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        parameters.put("path", imagePath);
		//subPath = reportFile.toString();
		parameters.put("relationForReport", relationForReport);
		parameters.put("service", service);
		parameters.put("adNo", adNo);
		parameters.put("IMG_PATH", request.getSession().getServletContext().getRealPath("/jsp/images/logonew-hal.jpg"));
		parameters.put("hospitalName", hospitalName);
		parameters.put("hospitalId", hospitalId);
		parameters.put("condition_status_message",condition_status_message.toString());
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		parameters.put("userName", userName);
		parameters.put("doc_attached", ""+detailsMap.get("docString"));
		parameters.put("diagnosis", ""+detailsMap.get("diagnosisString"));
		try {
			HMSUtil.generateReport("IPAdmissionSlip", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		/*try {
			byte bytes[] = null;
			try
			{
			bytes =	JasperRunManager.runReportToPdf(getCompiledReport("IPAdmissionSlip"),parameters,(Connection)detailsMap.get("conn"));
			HMSUtil.generateReport("Tender_Document_Report", map, (Connection)map.get("conn"), response, getServletContext());
			}
			catch(JRException e)
			{
				e.printStackTrace();
			}
			
			try {
				response.setContentType("application/pdf");
				response.setContentLength(bytes.length);
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}*/
			
		/*} catch (IllegalStateException e) {
			e.printStackTrace();
		}*/
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView getAdmissionNoList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		try{
		if(request.getParameter(SERVICE_NO) != null && !(request.getParameter(SERVICE_NO).equals(""))){
			serviceNo = request.getParameter(SERVICE_NO);
			detailsMap.put("serviceNo", serviceNo);
		}
		if(request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))){
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Object> hinNoList = new ArrayList<Object>();
		String flag = "";
		String mlc = "";
		String wound = "";
		String silDil= "";
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag");
		}
		if(request.getParameter("silDil") != null){
			silDil = request.getParameter("silDil");
		}
		if(request.getParameter("mlc") != null){
			mlc = request.getParameter("mlc");
			map.put("mlc", mlc);
		}
		if(request.getParameter("wound") != null){
			wound = request.getParameter("wound");
			map.put("wound", wound);
		}
		if(flag.equals("admission")){
			admissionNoList = adtHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			
			if(silDil.equals("silDil")){
				jsp = RESPONSE_FOR_ADMISSION_NO_NEW;
			}else{
				jsp = RESPONSE_FOR_ADMISSION_NO;
			}
		}else if(flag.equals("hin")){
			hinNoList = adtHandlerService.getHinNoList(serviceNo);
			map.put("hinNoList", hinNoList);
			if(request.getParameter("medical") != null){
				jsp = HIN_NO_fOR_MEDICAL_CERTIFICATE_JSP;
			}else{
				jsp = RESPONSE_FOR_HIN_NO;
			}
		}
		if(silDil.equals("silDil")){
			map.put("silDil", silDil);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
		
	}
	
	public ModelAndView showWoundReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = WOUND_REPORT_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showWoundCertificateReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String adNo = "";
		
		if(request.getParameter(AD_NO) != null){
			adNo = request.getParameter(AD_NO);
		}
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		detailsMap = adtHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("adNo", adNo);
		
//		try {
//		byte[] bytes = null;
//			try {
//				 bytes =
//				JasperRunManager.runReportToPdf(getCompiledReport("WoundCertificate"),parameters,(Connection)detailsMap.get("conn"));
//				 HMSUtil.generateReport("WoundCertificate", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
//			} catch (JRException e) {
//
//				e.printStackTrace();
//			} 				 
//			response.setContentType("application/pdf");
//			response.setContentLength(bytes.length);
//			ServletOutputStream ouputStream;
//			try {
//						ouputStream = response.getOutputStream();
//						ouputStream.write(bytes, 0, bytes.length);
//						ouputStream.flush();
//						ouputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		}
		 HMSUtil.generateReport("WoundCertificate", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	
	public ModelAndView showIpAdmissionRegisterReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
	//	map = adtHandlerService.getServiceTypeDepartmentCategory();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		map = registrationHandlerService.getDetailsForReport(hospitalId);
		jsp = IP_ADMISSION_REGISTER_REPORT_JSP+".jsp";
		map.put("contentJsp", jsp);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showIpAdmissionRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		String qry = "";
		HttpSession session = request.getSession();
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("") && request.getParameter("hospitalId").equals("0")){
			
			qry += "  and mas_hospital.command_id="+Integer.parseInt(request.getParameter("cmdId"));
		}else{
			if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("")){
				hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			}else{
				hospitalId = (Integer)session.getAttribute("hospitalId");
			}
			qry += "  and inpatient.hospital_id="+hospitalId;
		}
		
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		
		if(request.getParameter(SERVICE_TYPE_ID)!=null && !(request.getParameter(SERVICE_TYPE_ID).equals("0"))){
			qry += " and patient.service_type_id = "+Integer.parseInt(request.getParameter(SERVICE_TYPE_ID))+"";
		}
		if(request.getParameter(SERVICE_STATUS_ID)!=null && !(request.getParameter(SERVICE_STATUS_ID).equals("0"))){
			qry += " and patient.service_status_id = "+Integer.parseInt(request.getParameter(SERVICE_STATUS_ID))+"";
		}
		if(request.getParameter("fromRankId")!=null && request.getParameter("toRankId")!=null && !(request.getParameter("fromRankId").equals("0")) && !(request.getParameter("toRankId").equals("0"))){
			qry += " and patient.rank_id between "+Integer.parseInt(request.getParameter("fromRankId"))+" and "+Integer.parseInt(request.getParameter("toRankId"));
		}
		if(request.getParameter(RANK_CATEGORY_ID)!=null && !(request.getParameter(RANK_CATEGORY_ID).equals("0"))){
			qry += " and mas_rank.rank_category_id = "+Integer.parseInt(request.getParameter(RANK_CATEGORY_ID))+"";
		}
		if(request.getParameter(TRADE_ID)!=null && !(request.getParameter(TRADE_ID).equals("0"))){
			qry += " and patient.trade_id = "+Integer.parseInt(request.getParameter(TRADE_ID))+"";
		}
		if(request.getParameter(UNIT_ID)!=null && !(request.getParameter(UNIT_ID).equals("0"))){
			qry += " and patient.unit_id = "+Integer.parseInt(request.getParameter(UNIT_ID))+"";
		}
		if(request.getParameter(SECTION_ID)!=null && !(request.getParameter(SECTION_ID).equals("0"))){
			qry += " and patient.section_id = "+Integer.parseInt(request.getParameter(SECTION_ID))+"";
		}
		if(request.getParameter(MARITAL_STATUS_ID)!=null && !(request.getParameter(MARITAL_STATUS_ID).equals("0"))){
			qry += " and patient.marital_status_id = "+Integer.parseInt(request.getParameter(MARITAL_STATUS_ID))+"";
		}
		if(request.getParameter(SEX_ID)!=null && !(request.getParameter(SEX_ID).equals("0"))){
			qry += " and patient.sex_id = "+Integer.parseInt(request.getParameter(SEX_ID))+"";
		}
		if (request.getParameter(SERVICE_NO) != null && !(request.getParameter(SERVICE_NO).equals(""))) {
			qry += " and patient.service_no='"+HMSUtil.restrictMetaChar(request.getParameter(SERVICE_NO))+"'";
		}
		if ( request.getParameter("fromAge")!=null && request.getParameter("toAge")!=null && request.getParameter("fromAgeUnit")!=null && request.getParameter("toAgeUnit")!=null && !(request.getParameter("fromAge").equals("")) && !(request.getParameter("fromAgeUnit").equals(""))
				&& !(request.getParameter("toAge").equals("")) && !(request.getParameter("toAgeUnit").equals(""))) {
			String fromAge = request.getParameter("fromAge");
			String toAge = request.getParameter("toAge");
			qry +=" and substr(patient.age,0,INSTR(patient.age,' ')) >="+fromAge+" " +
					" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"+request.getParameter("fromAgeUnit")+"'" +
					" and substr(patient.age,0,INSTR(patient.age,' ')) <="+toAge+" " +
					" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"+request.getParameter("toAgeUnit")+"'";
			
		}
		if (request.getParameter("fromServ")!=null && request.getParameter("toServ")!=null && request.getParameter("fromServUnit")!=null && request.getParameter("toServUnit")!=null && !(request.getParameter("fromServ").equals("")) && !(request.getParameter("fromServUnit").equals(""))
				&& !(request.getParameter("toServ").equals("")) && !(request.getParameter("toServUnit").equals(""))) {
			String fromServ = request.getParameter("fromServ");
			String toServ = request.getParameter("toServ");
			qry +=" and patient.service_years >="+fromServ+" " +
					" and  total_service_period='"+request.getParameter("fromServUnit")+"'" +
					" and patient.service_years <="+toServ+" " +
					" and  total_service_period='"+request.getParameter("toServUnit")+"'";
			
		}
		if (request.getParameter("fromAdNo")!=null && !(request.getParameter("fromAdNo").equals("")) && request.getParameter("toAdNo")!=null && !(request.getParameter("toAdNo").equals(""))) {
			
		}
		if(request.getParameter(CONSULTING_DOCTOR)!=null && !(request.getParameter(CONSULTING_DOCTOR).equals("0"))){
			qry += " and inpatient.doctor_id = "+Integer.parseInt(request.getParameter(CONSULTING_DOCTOR))+"";
		}
		/*if (request.getParameter("icd") != null && !(request.getParameter("icd").equals(""))) {
			String icd = request.getParameter("icd");
			 int index1=icd.lastIndexOf("[");
			  int index2=icd.lastIndexOf("]");
			   index1++;
			   String icdCode =""+icd.substring(index1, index2);
			qry += " and icd.icd_code='"+icdCode+"'";
		}
		if (request.getParameter("icdNo") != null && !(request.getParameter("icdNo").equals(""))) {
			qry += " and icd.icd_code='"+request.getParameter("icdNo")+"'";
		}*/
		if (request.getParameter("icd") != null && !(request.getParameter("icd").equals(""))) {
			String icd = request.getParameter("icd");
			 int index1=icd.lastIndexOf("[");
			  int index2=icd.lastIndexOf("]");
			   index1++;
			   int icdCode =Integer.parseInt(""+icd.substring(index1, index2));
			qry += " and icd.icd_id="+icdCode+"";
		}
		if (request.getParameter("icdId")!=null && !(request.getParameter("icdId").equals(""))  && !(request.getParameter("icdId").equals("0"))) {
			qry += " and icd.icd_id="+Integer.parseInt(request.getParameter("icdId"))+"";
		}
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		parameters.put("hospitalId", hospitalId);
		String reportName = ""; 
		if(request.getParameter("reportType").equals("summary")) {
			reportName = "IPAdmissionRegisterSummary";
		}else if(request.getParameter("reportType").equals("detail")) {
			reportName = "IPAdmissionRegisterDetail";
		}
		
		HMSUtil.generateReport(reportName, parameters,(Connection) detailsMap.get("conn"), response,getServletContext());
		return null;
		
		/*
			                Date fromDate = null;
			                Date toDate = null;
			                Date currDate = null;
			                int serviceTypeId = 0;
			                int departmentId = 0;
			                String stringVariable = "";
			                String stringVariable2 = "";
			                String reportName="";
			                Map<String, Object> parameters = new HashMap<String, Object>();

			                
			                //Report As on Date
			                if(request.getParameter(ADMISSION_STATUS) !=null)
			                {
			                        currDate =
			HMSUtil.convertStringTypeDateToDateType(request.getParameter("currDate"));
			                        //parameters.put("fromDate", fromDate);                        
			                        parameters.put("toDate", currDate);
			                        //stringVariable = "  and inpatient.ad_status = 'A' ";
			                        reportName="IPAdmissionRegisterNew2";
			                }
			                else // From To Date Report
			                {
			                        reportName="IPAdmissionRegisterNew";
			                        //stringVariable = "  and inpatient.ad_status!='C'";
			                        if(request.getParameter(FROM_DATE) != null){
			                                fromDate =
			HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			                        }
			                        if(request.getParameter(TO_DATE) != null){
			                                toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			                        }
			                        parameters.put("fromDate", fromDate);
			                        parameters.put("toDate", toDate);
			                }
			                
			                
			                if(!request.getParameter(SERVICE_TYPE_ID).equals("0") &&
			request.getParameter(DEPARTMENT_ID).equals("0")){
			                        serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
			                        //stringVariable = stringVariable + " and patient.service_type_id="+serviceTypeId;
			                        stringVariable = " and patient.service_type_id="+serviceTypeId;
			                        stringVariable2 = " and b.service_type_id="+serviceTypeId;
			                }
			                if(!request.getParameter(DEPARTMENT_ID).equals("0") &&
			request.getParameter(SERVICE_TYPE_ID).equals("0")){
			                        departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			                        //stringVariable = stringVariable + " and inpatient.ad_ward_id = "+departmentId;
			                        stringVariable =  " and inpatient.ad_ward_id = "+departmentId;
			                        stringVariable2 = " and a.ad_ward_id="+departmentId;
			                }
			                if(!request.getParameter(DEPARTMENT_ID).equals("0") &&
			!request.getParameter(SERVICE_TYPE_ID).equals("0")){
			                        serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
			                        departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
 //stringVariable = stringVariable + " and inpatient.ad_ward_id="+departmentId+"and patient.service_type_id="+serviceTypeId;
			    stringVariable = " and inpatient.ad_ward_id="+departmentId+" and patient.service_type_id="+serviceTypeId;
			    stringVariable2 = " and a.ad_ward_id="+departmentId+" and b.service_type_id="+serviceTypeId;
			                }
			                
			                parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			                Map<String, Object> detailsMap = new HashMap<String, Object>();
			                detailsMap = adtHandlerService.getConnectionForReport();
			                parameters.put("stringVariable", stringVariable);
			                parameters.put("stringVariable2", stringVariable2);

			                HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("conn"),
			response, getServletContext());
			                return null;
			        */
		
	
	}	
public ModelAndView showIpDischargeRegisterReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getServiceTypeDepartmentCategory();
				
		jsp = IP_DISCHARGE_REGISTER_REPORT_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
		}
public ModelAndView showIpDischargeRegisterReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		Date currDate = null;
		int serviceTypeId = 0;
		int departmentId = 0;
		String stringVariable = "";
		String stringVariable2 = "";
		String reportName="";
		Map<String, Object> parameters = new HashMap<String, Object>();

		
		//Report As on Date
			reportName="IPDischargeRegisterNew";
			if(request.getParameter(FROM_DATE) != null){
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			}
			if(request.getParameter(TO_DATE) != null){
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			}
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
		
		
		
		if(!request.getParameter(SERVICE_TYPE_ID).equals("0") && request.getParameter(DEPARTMENT_ID).equals("0")){
			serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
			stringVariable = stringVariable + " and patient.service_type_id="+serviceTypeId;
			stringVariable2 = " and b.service_type_id="+serviceTypeId;
		}
		if(!request.getParameter(DEPARTMENT_ID).equals("0") && request.getParameter(SERVICE_TYPE_ID).equals("0")){
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			stringVariable = stringVariable + " and inpatient.department_id="+departmentId;
			stringVariable2 = " and a.department_id="+departmentId;
		}
		if(!request.getParameter(DEPARTMENT_ID).equals("0") && !request.getParameter(SERVICE_TYPE_ID).equals("0")){
			serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			stringVariable = stringVariable + " and inpatient.department_id="+departmentId+" and patient.service_type_id="+serviceTypeId;
			stringVariable2 = " and a.department_id="+departmentId+" and b.service_type_id="+serviceTypeId;
		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.getConnectionForReport();
		parameters.put("stringVariable", stringVariable);
		parameters.put("stringVariable2", stringVariable2);

		HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	public ModelAndView showIPAdmServiceTypeCategoryWiseReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getServiceTypeDepartmentCategory();
				
		jsp = IP_ADM_SERVICE_TYPE_CATEGORY_REPORT_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showIpAdmissionServiceTypeCategoryReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = null;
		int departmentId = 0;
		String criteria = "";
		String silOrDil = "";
		if(request.getParameter(DATE) != null){
			date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE));
		}
		if(!request.getParameter(DEPARTMENT_ID).equals("0")){
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			criteria = " and inpatient.department_id="+departmentId;
		}
		
		if(request.getParameter(SILORDIL) != null){
			silOrDil = request.getParameter(SILORDIL);
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("date", date);
		parameters.put("criteria", criteria);
//		try {
//				byte bytes[] = null;
//				try
//				{
//					if(silOrDil.equals("y")){
//						bytes =	JasperRunManager.runReportToPdf(getCompiledReport("IPAdmServiceTypeCategoryWiseSIDI"),parameters,(Connection)detailsMap.get("conn"));
//						HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
//					}else{
//						bytes =	JasperRunManager.runReportToPdf(getCompiledReport("IPAdmissionServiceTypeCategoryWise"),parameters,(Connection)detailsMap.get("conn"));
//					}
//				}
//				catch(JRException e)
//				{
//					e.printStackTrace();
//				}
//				
//				response.setContentType("application/pdf");
//				response.setContentLength(bytes.length);
//				ServletOutputStream ouputStream;
//				try {
//					ouputStream = response.getOutputStream();
//					ouputStream.write(bytes, 0, bytes.length);
//					ouputStream.flush();
//					ouputStream.close();
//					} catch (IOException e) 
//					{
//						e.printStackTrace();
//					}
//			
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		}
		if(silOrDil.equals("y")){
			HMSUtil.generateReport("IPAdmServiceTypeCategoryWiseSIDI", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		}else{
			HMSUtil.generateReport("IPAdmissionServiceTypeCategoryWise", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		}
		return null;
	}
	
	public ModelAndView showMedicalCertificateReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
				
		jsp = MEDICAL_CERTIFICATE_REPORT_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView getVisitDates(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		
		if(request.getParameter(HIN_NO) != null){
			hinNo = request.getParameter(HIN_NO);
		}
		map = adtHandlerService.getVisitDates(hinNo);
		jsp = RESPONSE_FOR_VISIT_DATE;
		return new ModelAndView(jsp,"map",map);
	}
	
	public ModelAndView getDiagnosis(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date visitDate = null;
		
		if(request.getParameter(TO_DATE) != null){
			visitDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		map = adtHandlerService.getDiagnosis(visitDate);
		jsp = "responseForDiagnosis";
		return new ModelAndView(jsp,"map",map);
	}
	
	public ModelAndView showMedicalCertificateReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String hinNo ="";
		String diagnosis = "";
		String fitUnfitFor = "";
		if(request.getParameter(FROM_DATE) != null){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if(request.getParameter(TO_DATE) != null){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		if(request.getParameter(HIN_NO) != null){
			hinNo = request.getParameter(HIN_NO);
		}
		if(request.getParameter(DIAGNOSIS_ID) != null){
			diagnosis = request.getParameter(DIAGNOSIS_ID);
		}
		if(request.getParameter(FIT_UNFIT_FOR) != null){
			fitUnfitFor = request.getParameter(FIT_UNFIT_FOR);
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("hinNo", hinNo);
		parameters.put("diagnosis", diagnosis);
		parameters.put("fitUnfitFor", fitUnfitFor);
//		try {
//			byte bytes[] = null;
//			try
//			{
//			bytes =	JasperRunManager.runReportToPdf(getCompiledReport("MedicalCertificate"),parameters,(Connection)detailsMap.get("conn"));
//			HMSUtil.generateReport("MedicalCertificate", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
//			}
//			catch(JRException e)
//			{
//				e.printStackTrace();
//			}
//			
//			response.setContentType("application/pdf");
//			response.setContentLength(bytes.length);
//			ServletOutputStream ouputStream;
//			try {
//				ouputStream = response.getOutputStream();
//				ouputStream.write(bytes, 0, bytes.length);
//				ouputStream.flush();
//				ouputStream.close();
//				} catch (IOException e) 
//				{
//					e.printStackTrace();
//				}
//		
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		}
		HMSUtil.generateReport("MedicalCertificate", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	
	
	/**
	 * ----------------------------------- Update Admission ----------------------------
	 */
	
	public ModelAndView showUpdateSearchJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		if(request.getParameter("jsp").equals("admission")){
			jsp = SEARCH_ADMISSION_JSP;
		}
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showPrintLabelSearchJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = "searchForLablePrint.jsp";
		
		map.put("contentJsp", jsp);
		
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showUpdateAdmissionJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientAdmissionMap = new HashMap<String, Object>();
		String adNo = "";
		if(request.getParameter(AD_NO) !=  null){
			adNo = request.getParameter(AD_NO);
		}
		patientAdmissionMap = adtHandlerService.getPatientAdmissionDetailsForUpdate(adNo);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != "0"){
			 hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			
		}
		map = adtHandlerService.getAdmissionDetails(hospitalId);
		
		String jsp = UPDATE_ADMISSION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientAdmissionMap", patientAdmissionMap);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView updateAdmissionInformation(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int inpatientId = 0;
		int hinId = 0;
		int departmentId = 0;
		String dietType = "";
		String nextOfKinName = "";
		String nextOfKinAddress = "";
		String nextOfKinPhoneNo = "";
		String adNo = "";
		
		if(!request.getParameter(INPATIENT_ID).equals("0")){
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			parameterMap.put("inpatientId", inpatientId);
		}
		if(!request.getParameter(HIN_ID).equals("0")){
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			parameterMap.put("hinId", hinId);
		}
		
		if(!request.getParameter(DEPARTMENT_ID).equals("0")){
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			parameterMap.put("departmentId", departmentId);
		}
		
		if(!request.getParameter(CONSULTING_DOCTOR).equals("0")){
			int consultingDoctorId = Integer.parseInt(request.getParameter(CONSULTING_DOCTOR));
			parameterMap.put("consultingDoctorId", consultingDoctorId);
		
		}
		if(!request.getParameter(BLOOD_GROUP_ID).equals("0")){
			int bloodGroupId = Integer.parseInt(request.getParameter(BLOOD_GROUP_ID));
			parameterMap.put("bloodGroupId", bloodGroupId);
		}
		
		if(!request.getParameter(CASE_TYPE_ID).equals("0")){
			int caseTypeId = Integer.parseInt(request.getParameter(CASE_TYPE_ID));
			parameterMap.put("caseTypeId", caseTypeId);
		
		}
		if(!request.getParameter(ADMISSION_TYPE_ID).equals("0")){
			int admissionTypeId = Integer.parseInt(request.getParameter(ADMISSION_TYPE_ID));
			parameterMap.put("admissionTypeId", admissionTypeId);
	
		}
		if(!request.getParameter(DIET_ID).equals("0")){
			int dietId = Integer.parseInt(request.getParameter(DIET_ID));
			parameterMap.put("dietId", dietId);
		}
		if(!request.getParameter(DIAGNOSIS_ID).equals("0")){
			int diagnosisId = Integer.parseInt(request.getParameter(DIAGNOSIS_ID));
			parameterMap.put("diagnosisId", diagnosisId);
		}
		if(request.getParameter(DIET_TYPE) != null){
			dietType = request.getParameter(DIET_TYPE);
			parameterMap.put("dietType", dietType);
		}
				
		if(request.getParameter(NEXT_OF_KIN_NAME) != null){

            nextOfKinName = request.getParameter(NEXT_OF_KIN_NAME);

            parameterMap.put("nextOfKinName", nextOfKinName);

      }

      if(request.getParameter(NEXT_OF_KIN_ADDRESS) != null){

            nextOfKinAddress =
request.getParameter(NEXT_OF_KIN_ADDRESS);

            parameterMap.put("nextOfKinAddress", nextOfKinAddress);

      }

      if(request.getParameter(NEXT_OF_KIN_PHONE_NO) != null){

            nextOfKinPhoneNo =
request.getParameter(NEXT_OF_KIN_PHONE_NO);

            parameterMap.put("nextOfKinPhoneNo", nextOfKinPhoneNo);

      }



      if(!request.getParameter(NEXT_OF_KIN_RELATION_ID).equals("0")){

            int nextOfKinRelationId =
Integer.parseInt(request.getParameter(NEXT_OF_KIN_RELATION_ID));

            parameterMap.put("nextOfKinRelationId",
nextOfKinRelationId);

      }
		String[] documentIdArray = null;
	try{
	
		StringBuffer documentStr = new StringBuffer();
		if (request.getParameterValues(DOCUMENT_ID)!=null && !request.getParameterValues(DOCUMENT_ID).equals("0")) {
			documentIdArray = (String[])(request.getParameterValues(DOCUMENT_ID));
			for (int i = 0; i < documentIdArray.length; i++) {
				documentStr.append(documentIdArray[i]);
				documentStr.append(",");
			}
			documentStr.deleteCharAt(documentStr.length()-1);
			
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
//		if(!request.getParameter(DOCUMENT_ID).equals("0")){
//			int documentId = Integer.parseInt(request.getParameter(DOCUMENT_ID));
//			parameterMap.put("documentId", documentId);
//		}
		if(!request.getParameter(RECORD_OFFICE_ADDRESS_ID).equals("0")){
			int recordOfficeAddressId = Integer.parseInt(request.getParameter(RECORD_OFFICE_ADDRESS_ID));
			parameterMap.put("recordOfficeAddressId", recordOfficeAddressId);
		}
		
		if(!request.getParameter(HSR_RECEIPT_NO).equals("0")){
			String hsrReceiptNo = (""+request.getParameter(HSR_RECEIPT_NO));
			parameterMap.put("hsrReceiptNo", hsrReceiptNo);
		}
		if(!request.getParameter(HSR_AMOUNT).equals("") && !request.getParameter(HSR_AMOUNT).equals("0")){
			BigDecimal hsrAmount =new BigDecimal(request.getParameter(HSR_AMOUNT));
			parameterMap.put("hsrAmount", hsrAmount);
		}else{
			BigDecimal hsrAmount =new BigDecimal(0);
			parameterMap.put("hsrAmount", hsrAmount);
		}
		Users user = (Users)session.getAttribute("users");
		int userId = user.getId();
		parameterMap.put("userId", userId);
		Date addEditDate = null;
			
		if(request.getParameter(CHANGED_DATE) != null){
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			parameterMap.put("addEditDate", addEditDate);
		}
		if(request.getParameter(CHANGED_TIME) != null){
			String addEditTime = request.getParameter(CHANGED_TIME);
			parameterMap.put("addEditTime", addEditTime);
		}
		if(request.getParameter("adNo") != null){
			 adNo = request.getParameter("adNo");
			map.put("uadNo", adNo);
		}
		
		String message = "";
		parameterMap.put("documentIdArray", documentIdArray);
			boolean admissionFlag = adtHandlerService.updateAdmissionInformation(parameterMap);
			
			if(admissionFlag == true){
				message = "Patient Admission Information Updated successfully.";
			}else{
				message = "Some Error Has occured.";
				
			}
			String backUrl = "";
			backUrl = "/hms/hms/adt?method=showUpdateSearchJsp";
			map.put("backUrl", backUrl);
			
			jsp = MESSAGE_FOR_ADT_JSP+".jsp";
			map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView cancelAdmissionInformation(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		int inpatientId = 0;
		int bedId = 0;
		@SuppressWarnings("unused")
		String dietType = "";
		@SuppressWarnings("unused")
		String nextOfKinName = "";
		@SuppressWarnings("unused")
		String nextOfKinAddress = "";
		@SuppressWarnings("unused")
		String nextOfKinPhoneNo = "";
		String message ="";
		String parentAdNo ="";
		if(!request.getParameter(INPATIENT_ID).equals("0")){
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			parameterMap.put("inpatientId", inpatientId);
		}
		if(!request.getParameter(BED_ID).equals("0")){
			bedId = Integer.parseInt(request.getParameter(BED_ID));
			parameterMap.put("bedId", bedId);
		}
		if(request.getParameter("parentAdNo") != null){
			parentAdNo = (request.getParameter("parentAdNo"));
			parameterMap.put("parentAdNo", parentAdNo);
		}
			boolean admissionFlag = adtHandlerService.cancelAdmissionInformation(parameterMap);
			
			if(admissionFlag == true){
				message = "Patient Admission has cancel successfully.";
			}else{
				message = "Some Error Has occured.";
				
			}
			String backUrl = "";
			backUrl = "/hms/hms/adt?method=showUpdateSearchJsp";
			map.put("backUrl", backUrl);
			
			jsp = MESSAGE_FOR_ADT_JSP+".jsp";
			map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showAdditionalInfoJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = "dischargeAdditionInfo";
		
		map.put("contentJsp", jsp);
		
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView saveAdditionalInfoForDischarge(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		String jsp = "";
		String movementCode = "";
		String warrantNo = "";
		String shr = "";
		String remarks = "";
		int dischargeId = 0;
		boolean flag= false;
		String formName = "";
		
		if(request.getParameter(DISCHARGE_ID) != null){
			dischargeId = Integer.parseInt(request.getParameter(DISCHARGE_ID));
			parameterMap.put("dischargeId", dischargeId);
		}
		if(request.getParameter(MOVEMENT_CODE) != null){
			movementCode = request.getParameter(MOVEMENT_CODE);
			parameterMap.put("movementCode", movementCode);
			
		}
		if(request.getParameter(WARRANT_NO) != null){
			warrantNo = request.getParameter(WARRANT_NO);
			parameterMap.put("warrantNo", warrantNo);
		}
		if(request.getParameter(SHR) != null){
			shr = request.getParameter(SHR);
			parameterMap.put("shr", shr);
		}
		if(request.getParameter(REMARKS) != null){
			remarks = request.getParameter(REMARKS);
			parameterMap.put("remarks", remarks);
		}
		if(request.getParameter("formName") != null){
			formName = request.getParameter("formName"); 
		}
		flag = adtHandlerService.saveAdditionalInfoForDischarge(parameterMap);
		
		String message = "";
		if(flag == true){
			message = "Information has been submitted successfully";
		}else{
			message = "Some Error has occured";
		}
		
		jsp = MESSAGE_FOR_ADT_JSP;
		map.put("formName", formName);
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView showOPMlcJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = OP_MLC_CASE_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
/*	
 * 
 * For Reports
	*/
	
	
	public ModelAndView showSiDiReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = SI_DI_REPORT_JSP;
		String serviceNo ="";
		if(request.getParameter("serviceNo") != null){
			serviceNo = request.getParameter("serviceNo"); 
		}
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("serviceNo", serviceNo);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showSiDiReport(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String adNo = "";
		
		if(request.getParameter(AD_NO) != null){
			adNo = request.getParameter(AD_NO);
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("adNo", adNo);
		detailsMap = adtHandlerService.getSiDiData(dataMap);
		Map<String, Object> parameters = new HashMap<String, Object>();
		String dateSilDil = "";
		try{
			parameters.put("placed_by", ""+detailsMap.get("placed_by"));
			parameters.put("Placed_on", ""+detailsMap.get("Placed_on"));
			parameters.put("si_di", ""+detailsMap.get("si_di"));
			parameters.put("placedOrTakenOffBy", ""+detailsMap.get("placedOrTakenOffBy"));
			SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		if(detailsMap.get("si_di_date")!=null && !detailsMap.get("si_di_date").equals(""))
			 dateSilDil=formatterOut.format(formatterIn.parse(""+detailsMap.get("si_di_date")));
			
			parameters.put("si_di_date", dateSilDil);
			parameters.put("si_di_time", ""+detailsMap.get("si_di_time"));
			parameters.put("diagnosis", ""+detailsMap.get("diagnosis"));
			parameters.put("nok_status", ""+detailsMap.get("nok_status"));
			parameters.put("placedOrTakenOffBy", ""+detailsMap.get("placedOrTakenOffBy"));
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		parameters.put("adNo", adNo);
//		try {
//			byte[] bytes = null;
//			bytes =JasperRunManager.runReportToPdf(getCompiledReport("SiDiReport"),parameters,(Connection)detailsMap.get("conn"));
//			HMSUtil.generateReport("SiDiReport", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
//			response.setContentType("application/pdf");
//			response.setContentLength(bytes.length);
//			ServletOutputStream ouputStream;
//			ouputStream = response.getOutputStream();
//			ouputStream.write(bytes, 0, bytes.length);
//			ouputStream.flush();
//			ouputStream.close();
//				
//			} catch (Exception e) {
//			e.printStackTrace();
//		}
		HMSUtil.generateReport("SiDiReport", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	
	public ModelAndView showMedicoLegalReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = MEDICO_LEGAL_REPORT_JSP;
		
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView getMlcNo(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		
		if(request.getParameter(HIN_NO) != null){
			hinNo = request.getParameter(HIN_NO);
		}
		map = adtHandlerService.getMlcNo(hinNo);
		jsp = RESPONSE_FOR_MLC_NO;
		return new ModelAndView(jsp,"map",map);
	}
	
	public ModelAndView showMedicoLegalReport(HttpServletRequest request, HttpServletResponse  response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String mlcNo = "";
		
		if(request.getParameter(MLC_NO) != null){
			mlcNo = request.getParameter(MLC_NO);
		}
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		detailsMap = adtHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("mlcNo", mlcNo);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
//		try {
//		byte[] bytes = null;
//			try {
//				 bytes =
//				JasperRunManager.runReportToPdf(getCompiledReport("MedicoLegalReport"),parameters,(Connection)detailsMap.get("conn"));
//				 HMSUtil.generateReport("MedicoLegalReport", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
//			} catch (JRException e) {
//
//				e.printStackTrace();
//			} 				 
//			response.setContentType("application/pdf");
//			response.setContentLength(bytes.length);
//			ServletOutputStream ouputStream;
//			try {
//						ouputStream = response.getOutputStream();
//						ouputStream.write(bytes, 0, bytes.length);
//						ouputStream.flush();
//						ouputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			} catch (IllegalStateException e) {
//			e.printStackTrace();
//		}
		parameters.put("hospitalId", hospitalId);
		parameters.put("IMG_PATH", request.getSession().getServletContext().getRealPath("/jsp/images/humanBody.jpg"));
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		 HMSUtil.generateReport("MLC_CASE", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	
		
	private JasperReport getCompiledReport(String fileName)	throws JRException {

		File reportFile =new File(getServletContext().getRealPath("/reports/" + fileName + ".jasper"));
		JasperReport jasperReport =(JasperReport) JRLoader.loadObject(reportFile.getPath());

		return jasperReport;
	}
	
//	---------------------At Bangalore ----------------------
	public ModelAndView showSilDilInAdt(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = SIL_DIL_IN_ADT+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showIPMlcJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = IP_MLC_CASE_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView getIPMlcJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String flag = "";
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
//		mlcMap = adtHandlerService.getDetailsForMLC();
//		mlcNo = adtHandlerService.generateMLCNo(adMap);
//						
//		message = "Patient has been admitted successfully with A & D No. '"+adNo+"'";
//		jsp = MEDICO_LEGAL_CASE_JSP+".jsp";
//		map.put("mlcNo", mlcNo);
//		map.put("adNo", adNo);
//		map.put("message", message);
//		map.put("detailsMap", mlcMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView printSilDilRepotInAdt(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		@SuppressWarnings("unused")
		Date currDate = null;
		int serviceTypeId = 0;
		int departmentId = 0;
		String stringVariable = "";
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="SilDil_As_On_Main";
		
			if(request.getParameter(FROM_DATE) != null){
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			}
			if(request.getParameter(TO_DATE) != null){
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			}
			
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
	
		
		if(!request.getParameter(SERVICE_TYPE_ID).equals("0") && request.getParameter(DEPARTMENT_ID).equals("0")){
			serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
			stringVariable = " and patient.service_type_id="+serviceTypeId;
		}
		if(!request.getParameter(DEPARTMENT_ID).equals("0") && request.getParameter(SERVICE_TYPE_ID).equals("0")){
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			stringVariable = " and inpatient.department_id="+departmentId;
		}
		if(!request.getParameter(DEPARTMENT_ID).equals("0") && !request.getParameter(SERVICE_TYPE_ID).equals("0")){
			serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			stringVariable = " and inpatient.department_id="+departmentId+" and patient.service_type_id="+serviceTypeId;
		}
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.getConnectionForReport();
		parameters.put("stringVariable", stringVariable);
//		try {
//			byte bytes[] = null;
//			try
//			{
//			bytes =	JasperRunManager.runReportToPdf(getCompiledReport(reportName),parameters,(Connection)detailsMap.get("conn"));
//			 HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
//			}
//			catch(JRException e)
//			{
//				e.printStackTrace();
//			}
//			
//			response.setContentType("application/pdf");
//			response.setContentLength(bytes.length);
//			ServletOutputStream ouputStream;
//			try {
//				ouputStream = response.getOutputStream();
//				ouputStream.write(bytes, 0, bytes.length);
//				ouputStream.flush();
//				ouputStream.close();
//				} catch (IOException e) 
//				{
//					e.printStackTrace();
//				}
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		}
		 HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	
	//--Added on 10-07-08----------------
	
	public void chechBed(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBed> bedList =new ArrayList<MasBed>();
		HttpSession session = request.getSession();
		int wardId =0;
		if(request.getParameter("wardId") != null){
			wardId = Integer.parseInt(request.getParameter("wardId"));
		}
		int fromBedId =0;
		if(request.getParameter("fromBedId") != null){
			fromBedId = Integer.parseInt(request.getParameter("fromBedId"));
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		
		dataMap.put("wardId", wardId);
		dataMap.put("fromBedId", fromBedId);
		dataMap.put("hospitalId", hospitalId);
		map = adtHandlerService.chechBed(dataMap);
		bedList=(List<MasBed>) map.get("bedList");
		int bedId =0;
		for (MasBed bed : bedList) {
			bedId=bed.getId();
		}
		StringBuffer sb = new StringBuffer();
	
			sb.append("<item>");
			if(bedId > 0){
				sb.append("<bedStatus>" +"yes" + "</bedStatus>");
			}else{
				sb.append("<bedStatus>" +"no" + "</bedStatus>");
			}
			sb.append("<bedId>" +bedId + "</bedId>");
			sb.append("</item>");
	

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}
	@SuppressWarnings("unchecked")
	public void checkAdNoDuplication(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList =new ArrayList<Inpatient>();
		String adNo ="";
		if(request.getParameter("adNo") != null){
			adNo = (request.getParameter("adNo"));
		}
		
		dataMap.put("adNo",adNo);
		map = adtHandlerService.checkOffLineAdNoDuplicationFor(dataMap);
		inpatientList=(List<Inpatient>) map.get("inpatientList");
		StringBuffer sb = new StringBuffer();
	
			sb.append("<item>");
			if(inpatientList.size() > 0){
				sb.append("<adStatus>" +"yes" + "</adStatus>");
			}else{
				sb.append("<adStatus>" +"no" + "</adStatus>");
			}
			sb.append("</item>");
	

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	@SuppressWarnings("unchecked")
	public void checkForDuplicateOfAdnoInAttach(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List objectList=new ArrayList();
		String serviceNo ="";
		int relationId =0;
		int serviceTypeId =0;
		if(request.getParameter("serviceNo") != null){
			serviceNo = (request.getParameter("serviceNo"));
		}
		if(request.getParameter("serviceTypeId") != null){
			serviceTypeId =Integer.parseInt(""+(request.getParameter("serviceTypeId"))) ;
		}
		if(request.getParameter("relationId") != null){
			relationId =Integer.parseInt(""+(request.getParameter("relationId"))) ;
		}
		dataMap.put("serviceNo",serviceNo);
		dataMap.put("serviceTypeId",serviceTypeId);
		dataMap.put("relationId",relationId);
		List<Inpatient> ipList =new ArrayList<Inpatient>();
		map = adtHandlerService.checkForDuplicateOfAdnoInAttach(dataMap);
		objectList=(List)map.get("objectList");
		int uniqueRelId =0;
		String pName ="";
		String sName ="";
		String rank ="";
		String info ="ALREADY ADMITTED INFORMATION...!"+"\n\n";
		try{
		if(objectList.size() > 0){
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				if(relationId ==2 || relationId ==3 || relationId ==8 )
				if(Integer.parseInt(""+object[0]) ==relationId  )
					uniqueRelId = Integer.parseInt(""+object[0]);
				info =info+object[1]+" ("+object[4]+") "+"\n";
		}
		}
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<uniqueRelId>"+uniqueRelId+"</uniqueRelId>");
			sb.append("<info>"+info+"</info>");
			sb.append("</item>");
	
	
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	@SuppressWarnings("unchecked")
	public void getIcdWithIcdCode(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List objectList=new ArrayList();
		String icdCode ="";
		if(request.getParameter("icdCode") != null){
			icdCode = (request.getParameter("icdCode"));
		}
		dataMap.put("icdCode",icdCode);
		List<MasIcd> masIcdList =new ArrayList<MasIcd>();
		map = adtHandlerService.getIcdWithIcdCode(dataMap);
		masIcdList=(List)map.get("masIcdList");
		String icdString ="no";
		for(MasIcd masIcd :masIcdList){
			icdString = masIcd.getIcdSubCategory().getIcdSubCategoryName()+":"+masIcd.getIcdName()+"["+masIcd.getIcdCode()+"]";
		}
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<icdString>"+icdString.toUpperCase()+"</icdString>");
			sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		
			try {
				response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<items>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public ModelAndView oldDischargeEntry(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<UserEmpGroup> userRights = new ArrayList<UserEmpGroup>();
		HttpSession session = request.getSession();
		Users userObj = (Users)session.getAttribute("users");
				
		map = adtHandlerService.getDischargeDetails();
		if(userObj!= null){
			map1= adtHandlerService.getUserRights( userObj);
			if(map1.get("userRights")!= null){
				userRights = (List)map1.get("userRights");
				map.put("userRights", userRights);
			}
		}
		jsp = OLD_DISCHARGE_ENTRY+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	@SuppressWarnings("unchecked")
	public void getDischargeDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List objectList=new ArrayList();
		String serviceNo ="";
		if(request.getParameter("serviceNo") != null){
			serviceNo = (request.getParameter("serviceNo"));
		}
		dataMap.put("serviceNo",serviceNo);
		@SuppressWarnings("unused")
		List<MasIcd> masIcdList =new ArrayList<MasIcd>();
		map = adtHandlerService.getDischargeDetails(dataMap);
		objectList=(List)map.get("objectList");
		
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<adLists>");
			try{
				for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
					Object[] object = (Object[]) iterator.next();
					
					sb.append("<adList>");
						sb.append("<adId>" + object[0] + "</adId>");
						sb.append("<adNo>" + object[1]+ "</adNo>");
						sb.append("</adList>");
				}
				}catch (Exception e) {
					e.printStackTrace();
				}
				sb.append("</adLists>");
				sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		
			try {
				response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<items>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	@SuppressWarnings("unchecked")
	public void getDetailsOfDischarge(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List objectList=new ArrayList();
		String inpatientId ="";
		String admissionNo ="";
		if(request.getParameter("inpatientId") != null){
			inpatientId = (request.getParameter("inpatientId"));
		}
		if(request.getParameter("admissionNo") != null){
			admissionNo = (request.getParameter("admissionNo"));
		}
		dataMap.put("inpatientId",inpatientId);
		dataMap.put("admissionNo",admissionNo);
		@SuppressWarnings("unused")
		List<Inpatient> inpatientList =new ArrayList<Inpatient>();
		@SuppressWarnings("unused")
		List<Discharge> dischargeList =new ArrayList<Discharge>();
		List<DischargeIcdCode> dischargeIcdCodeList =new ArrayList<DischargeIcdCode>();
		map = adtHandlerService.getDetailsOfDischarge(dataMap);
		
		inpatientList=(List<Inpatient>)map.get("inpatientList");
		dischargeList=(List<Discharge>)map.get("dischargeList");
		dischargeIcdCodeList=(List<DischargeIcdCode>)map.get("dischargeIcdCodeList");
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			for(Inpatient inpatient :inpatientList){
				sb.append("<sName>" + inpatient.getHin().getSFirstName()+" "+inpatient.getHin().getSMiddleName() +" "+inpatient.getHin().getSLastName()+ "</sName>");
				sb.append("<pName>" + inpatient.getHin().getPFirstName()+" "+inpatient.getHin().getPMiddleName() +" "+inpatient.getHin().getPLastName()+ "</pName>");
				try{
				SimpleDateFormat formatterIn2 = new SimpleDateFormat("yyyy-MM-dd");
				 SimpleDateFormat formatterOut2 = new  SimpleDateFormat("dd/MM/yyyy");
				 String date4MySQL2=formatterOut2.format(formatterIn2.parse(""+inpatient.getDateOfAddmission()));
				sb.append("<doa>" + date4MySQL2+ "</doa>");
				}catch (Exception e) {
					e.printStackTrace();
				}
				sb.append("<relation>" + inpatient.getHin().getRelation().getRelationName()+ "</relation>");
				sb.append("<age>" + inpatient.getAge()+ "</age>");
				sb.append("<sex>" + inpatient.getHin().getSex().getAdministrativeSexName()+ "</sex>");
				sb.append("<hinId>" + inpatient.getHin().getId()+ "</hinId>");
				sb.append("<deptId>" + inpatient.getDepartment().getId()+ "</deptId>");
			}
			 
				sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		
			try {
				response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<items>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public ModelAndView getDetailsOfDischarge2(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> temp = new HashMap<String, Object>();
		List objectList=new ArrayList();
		String inpatientId ="";
		String admissionNo ="";
		if(request.getParameter("inpatientId") != null){
			inpatientId = (request.getParameter("inpatientId"));
		}
		if(request.getParameter("admissionNo") != null){
			admissionNo = (request.getParameter("admissionNo"));
		}
		dataMap.put("inpatientId",inpatientId);
		dataMap.put("admissionNo",admissionNo);
		@SuppressWarnings("unused")
		List<Inpatient> inpatientList =new ArrayList<Inpatient>();
		@SuppressWarnings("unused")
		List<Discharge> dischargeList =new ArrayList<Discharge>();
		List<DischargeIcdCode> dischargeIcdCodeList =new ArrayList<DischargeIcdCode>();
		map = adtHandlerService.getDetailsOfDischarge(dataMap);
		temp = adtHandlerService.getDischargeDetails();
		try{
		map.put("employeeList", temp.get("employeeList"));
		map.put("diagnosisList", temp.get("diagnosisList"));
		map.put("disposedToList", temp.get("disposedToList"));
		map.put("disposalList",temp.get("disposalList") );
		map.put("careTypeList", temp.get("careTypeList"));
		map.put("dischargeStatusList", temp.get("dischargeStatusList") );
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseForUpdateDischarge";
	
	map.put("inpatientId", inpatientId);
	map.put("contentJsp", jsp);
	return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView updateDischarge(HttpServletRequest request, HttpServletResponse response){
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Discharge discharge = new Discharge();
		int hinId = 0;
		int bedId = 0;
		String adNo = "";
		int disposedToId = 0;
		int disposalId = 0;
		int careTypeId = 0;
		int doctorId = 0;
		int inpatientId = 0;
		Date dischargeDate = null;
		String dischargeTime = "";
		int dischargeStatusId = 0;
		int departmentId = 0;
		int hospitalId =0;
		String workingDiagnosis = "";
		HttpSession session = request.getSession();
		
		String addEditTime = "";
		Date addEditDate = null;
		
		Users user = (Users)session.getAttribute("users");
		int userId = user.getId();
		dataMap.put("userId", userId);
		session = request.getSession();
		
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		if(request.getParameter("hinId") != null){
			dataMap.put("hinId", request.getParameter("hinId"));
		}
		if(request.getParameter(DISCHARGE_DATE) != null){
			dataMap.put("dischargeDate", request.getParameter(DISCHARGE_DATE));
		}
		if(request.getParameter(INPATIENT_ID) != null){
			dataMap.put("inpatientId", request.getParameter(INPATIENT_ID));
		}
		if(request.getParameter(DISCHARGE_TIME) != null){
			
			dataMap.put("dischargeTime",  request.getParameter(DISCHARGE_TIME));
		}
		
			int dId =0;
			if(request.getParameter("dId") != null){
				dId =Integer.parseInt(""+request.getParameter("dId"));
			dataMap.put("dischargeId",  request.getParameter("dId"));
		}
			String deleteDiagnosis=""; 
			if(request.getParameter(DELETE_DIAGNOSIS) != null){
				deleteDiagnosis ="yes";
			}
			if(dId ==0){
				
				if(request.getParameter(DISCHARGE_NO) != null){
					discharge.setDischargeNo(Integer.parseInt(request.getParameter(DISCHARGE_NO)));
				}
				if(request.getParameter("hinId") != null){
					discharge.setHin(new Patient(Integer.parseInt(""+request.getParameter("hinId"))));
				}
				if(request.getParameter("admissionNo") != null){
					adNo = request.getParameter("admissionNo");
					discharge.setAdNo(adNo);
				}
				
					MasDisposal masDisposal = new MasDisposal();
					masDisposal.setId(7);
					discharge.setDisposal(masDisposal);
				
				
					MasDisposedTo masDisposedTo = new MasDisposedTo();
					masDisposedTo.setId(5);
					discharge.setDisposedTo(masDisposedTo);
				
				
					MasCareType masCareType = new MasCareType();
					masCareType.setId(6);
					discharge.setCareType(masCareType);
			
			
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(1);
					discharge.setDoctor(masEmployee);
		
				
					MasDischargeStatus masDischargeStatus = new MasDischargeStatus();
					masDischargeStatus.setId(5);
					discharge.setDischargeStatus(masDischargeStatus);
					discharge.setHospital(new MasHospital(hospitalId));
				if(!request.getParameter("deptId").equals("0")){
					departmentId = Integer.parseInt(request.getParameter("deptId"));
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(departmentId);
					discharge.setWard(masDepartment);
				}
				if(request.getParameter(DOCTOR_NAME) != null){
					discharge.setDoctor(new MasEmployee(Integer.parseInt(""+request.getParameter(DOCTOR_NAME))));
				}
				if(request.getParameter(DISPOSAL_ID) != null){
					discharge.setDisposal(new MasDisposal(Integer.parseInt(""+request.getParameter(DISPOSAL_ID))));
				}
				if(request.getParameter(DISPOSED_TO_ID) != null){
					discharge.setDisposedTo(new MasDisposedTo(Integer.parseInt(""+request.getParameter(DISPOSED_TO_ID))));
				}
				if(request.getParameter(CARE_TYPE_ID) != null && !request.getParameter(CARE_TYPE_ID).equals("")){
					discharge.setCareType(new MasCareType(Integer.parseInt(""+request.getParameter(CARE_TYPE_ID))));
				}
				if(request.getParameter(INJURY_REPORT_INITIATED_ON) != null && !request.getParameter(INJURY_REPORT_INITIATED_ON).equals("")){
					SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
					 SimpleDateFormat formatterOut = new  SimpleDateFormat("yyyy-MM-dd");
					 String date4MySQL =null;
					try {
						date4MySQL = formatterOut.format(formatterIn.parse(request.getParameter(INJURY_REPORT_INITIATED_ON)));
						 discharge.setInjuryReportInitiatedOn(java.sql.Date.valueOf(date4MySQL));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}
				if(request.getParameter("injury_report_init_at") != null && !request.getParameter("injury_report_init_at").equals("")){
					discharge.setInjuryReportInitAt(""+request.getParameter("injury_report_init_at"));
				}
				if(request.getParameter(BOARD_HELD_ON) != null && !request.getParameter(BOARD_HELD_ON).equals("")){
					SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
					 SimpleDateFormat formatterOut2 = new  SimpleDateFormat("yyyy-MM-dd");
					 String date4MySQL2 =null;
					try {
						date4MySQL2 = formatterOut2.format(formatterIn2.parse(request.getParameter(BOARD_HELD_ON)));
						 discharge.setBoardHeldOn(java.sql.Date.valueOf(date4MySQL2));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}
				if(request.getParameter(FOLLOW_UP) != null && !request.getParameter(FOLLOW_UP).equals("")){
					SimpleDateFormat formatterIn3 = new SimpleDateFormat("dd/MM/yyyy");
					 SimpleDateFormat formatterOut3 = new  SimpleDateFormat("yyyy-MM-dd");
					 String date4MySQL3 =null;
					try {
						date4MySQL3 = formatterOut3.format(formatterIn3.parse(request.getParameter(FOLLOW_UP)));
						 discharge.setFollowUpDate(java.sql.Date.valueOf(date4MySQL3));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}
				if(request.getParameter(DISCHARGE_IN_MEDICAL_CATEGORY) != null && !request.getParameter(DISCHARGE_IN_MEDICAL_CATEGORY).equals("")){
					discharge.setDischargeInMedicalCategory(""+request.getParameter(DISCHARGE_IN_MEDICAL_CATEGORY));
				}
				if(request.getParameter(DISCHARGE_STATUS_ID) != null && !request.getParameter(DISCHARGE_STATUS_ID).equals("")){
					discharge.setDischargeStatus(new MasDischargeStatus(Integer.parseInt(""+request.getParameter(DISCHARGE_STATUS_ID))));
				}
				if(request.getParameter(CARE_SUMMARY) != null){
					discharge.setCareSummary(""+request.getParameter(CARE_SUMMARY));
				}
				if(request.getParameter(INSTRUCTIONS) != null){
					discharge.setInstructionsToPatient(""+request.getParameter(INSTRUCTIONS));
				}
				if(request.getParameter("document_initiated") != null){
					discharge.setDocumentInitiated(""+request.getParameter("document_initiated"));
				}
								
				if(request.getParameter(DISCHARGE_DATE) != null && !request.getParameter(DISCHARGE_DATE).equals("")){
					SimpleDateFormat formatterIn4 = new SimpleDateFormat("dd/MM/yyyy");
					 SimpleDateFormat formatterOut4 = new  SimpleDateFormat("yyyy-MM-dd");
					 String date4MySQL4 =null;
					try {
						date4MySQL4 = formatterOut4.format(formatterIn4.parse(request.getParameter(DISCHARGE_DATE)));
						 discharge.setDateOfDischarge(java.sql.Date.valueOf(date4MySQL4));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}
				if(request.getParameter(DISCHARGE_TIME) != null){
					discharge.setTimeOfDischarge(""+request.getParameter(DISCHARGE_TIME));
				}
				discharge.setStatus("y");
				discharge.setDischargeAdviced("y");
			}
			int hdb=1;
			if (Integer.parseInt(request.getParameter("hdb")) != 1) {
				hdb=Integer.parseInt(request.getParameter("hdb"));
			}
			
				String[]  diagnosidIdArray = new String[hdb] ;
				String str="";
				try{
					for(int i = 0 ; i<hdb; i++){
						if(request.getParameter("icd"+str) != null){
							String icd=request.getParameter("icd"+str);
							   diagnosidIdArray[i]=(icd);
								
						}else{
							diagnosidIdArray[i]="0";
						}
						str=(i+1+1)+"";
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			dataMap.put("diagnosidIdArray",diagnosidIdArray);
			dataMap.put("discharge",discharge);
			dataMap.put("dId",dId);
			dataMap.put("box",box);
			dataMap.put("deleteDiagnosis", deleteDiagnosis);
		map = adtHandlerService.updateDischarge(dataMap);
		
		String message = "";
		String saved ="n";
		Map<String, Object> patientDetailsMap = new HashMap<String, Object>();
		
		saved=""+map.get("saved");
		if (saved.equals("y")) {
			message="Discharge Information has been Updated Successfully.";
				jsp = MESSAGE_FOR_ADT_JSP+".jsp";
		
		}else{
			message = "Some problem Occured! Try Again.";
			jsp = MESSAGE_FOR_ADT_JSP+".jsp";
		}
		map.put("inpatientId", inpatientId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	
	}
	
	
	
	public ModelAndView showICDSearchJsp(HttpServletRequest request,HttpServletResponse response)
	{
	   Box box = HMSUtil.getBox(request);
	   Map<String, Object> map = new HashMap<String, Object>();
	   String search = "n";
	   
	   if(request.getParameter("search")!= null){
		   search = (String)request.getParameter("search");
	   }
	   map=adtHandlerService.getICDDetails(box);
	   jsp = "ADT_ICD_Search";
	   if(search.equalsIgnoreCase("y")){
		   jsp =jsp +".jsp";
	   }
	   map.put("search",search);
	   map.put("contentJsp",jsp);
	   if(search.equalsIgnoreCase("y")){
	   return new ModelAndView("indexB", "map", map);
	   }else{
		   return new ModelAndView(jsp, "map", map);	   
	   }
	 }

	public ModelAndView showExpiryDetailsSearchJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		map = adtHandlerService.getDetailsForSearch(hospitalId);
		jsp = SEARCH_EXPITY_DETAILS_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView searchExpiryDetails(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();
		
		String hinNo = "";	
		int wardId = 0;
		String adNo = "";	
		int inpatientId = 0;
		String serviceNo = "";
		
		try{
			
			if(request.getParameter(SERVICE_NO) != null && !(request.getParameter(SERVICE_NO).equals(""))){
				serviceNo = request.getParameter(SERVICE_NO);
				dataMap.put("serviceNo", serviceNo);
			}
			if(request.getParameter(AD_NO) != null && !(request.getParameter(AD_NO).equals(""))){
				adNo = request.getParameter(AD_NO);
				dataMap.put("adNo", adNo);
			}
			if(request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))){
				hinNo = request.getParameter(HIN_NO);
				dataMap.put("hinNo", hinNo);
			}
			if(request.getParameter(WARD_ID) != null && !(request.getParameter(WARD_ID).equals("0"))){
				wardId = Integer.parseInt(request.getParameter(WARD_ID)) ;
				dataMap.put("wardId", wardId);
			}
			if(request.getParameter("inpatientId")!= null){
				inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
				dataMap.put("inpatientId", inpatientId);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		patientMap = adtHandlerService.searchExpiryDetails(dataMap);
		
		String jsp = "";
		String message = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Inpatient> inpatientTempList = new ArrayList<Inpatient>();
		
		if(patientMap.get("inpatientList") != null){
			inpatientList = (List<Inpatient>)patientMap.get("inpatientList");
		}
		if(patientMap.get("inpatientTempList") != null){
			inpatientTempList = (List<Inpatient>)patientMap.get("inpatientTempList");
		}
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		if((!adNo.equals("") && inpatientList.size() > 0 ) || inpatientId != 0){
				detailsMap = adtHandlerService.getDischargeDetails();
				patientDiagnosisMap = adtHandlerService.getPatientDiagnosis(adNo, inpatientId);
				map.put("patientDiagnosisMap", patientDiagnosisMap);
				jsp = DISCHARGE_BY_HIN_NO_JSP+".jsp";
		}else if(!adNo.equals("") && inpatientTempList.size() > 0 && inpatientList.size() == 0){
			map = adtHandlerService.getDetailsForSearch(hospitalId);
			message = "Discharge Summary of patient is not prepared.Please first prepare discharge summary.";
			map.put("message", message);
			jsp = SEARCH_EXPITY_DETAILS_JSP+".jsp";
		}else{
			map = adtHandlerService.getDetailsForSearch(hospitalId);
			jsp = SEARCH_EXPITY_DETAILS_JSP+".jsp";
		}
		
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showExpiryDetails(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ExpiryDetails> expList = new ArrayList<ExpiryDetails>();
		String message = "";
		int hinId =0;
		String adNo ="";
		String search = "n"; 
		boolean status = false;
		Map<String, Object> patientDetailsMap = new HashMap<String, Object>();

		if(request.getParameter("adNo") != null){
			adNo =(request.getParameter("adNo")) ;
		}

		if(request.getParameter("search") != null){
			search =(request.getParameter("search")) ;
		}
		patientDetailsMap.put("adNo", adNo);
		patientDetailsMap.put("search", search);
		map = adtHandlerService.showExpiryDetails(patientDetailsMap);
		if(map != null){
			expList =(List<ExpiryDetails>) map.get("expDetailsList");
			status = (Boolean) map.get("status");
		}
		if(status){
		jsp = EXPIRY_DETAILS_JSP+".jsp";
		}else{
			jsp = "searchForExpiryPatient"+".jsp";
			message = message + "Expiry Detail Does Not Filled ";
		}

		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView getDischargeScreen(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		String message = "";
		int hinId =0;
		int inpatientId =0;
		String adNo ="";
        HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("users");
		Map<String, Object> patientDetailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Inpatient> inpatientTempList = new ArrayList<Inpatient>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();
				if(request.getParameter("parent")!= null){
					inpatientId = Integer.parseInt(request.getParameter("parent"));
					mapForDs.put("inpatientId", inpatientId);
				}
				mapForDs.put("user",user);
				
		patientMap = adtHandlerService.getPatientDetailsForDischarge(mapForDs);
		if(patientMap.get("inpatientList") != null){
				inpatientList = (List<Inpatient>)patientMap.get("inpatientList");
			}
			if(patientMap.get("inpatientTempList") != null){
				inpatientTempList = (List<Inpatient>)patientMap.get("inpatientTempList");
			}
			
		if((inpatientList.size() > 0 ) || inpatientId != 0){
					detailsMap = adtHandlerService.getDischargeDetails();
					patientDiagnosisMap = adtHandlerService.getPatientDiagnosis(adNo, inpatientId);
					map.put("patientDiagnosisMap", patientDiagnosisMap);
					jsp = DISCHARGE_BY_HIN_NO_JSP+".jsp";
			}
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView getTransferScreen(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		String message = "";
		int inpatientId =0;
		Map<String, Object> patientDetailsMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		if(request.getParameter("parent") != null){
			inpatientId = Integer.parseInt(request.getParameter("parent"));
		}
		
		Users userObj = (Users)session.getAttribute("users");
		if(userObj!= null){
			mapForDs.put("user", userObj);
		}
		mapForDs.put("inpatientId", inpatientId);
		patientMap = adtHandlerService.getPatientDetailsForTransfer(mapForDs);
		String jsp = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
				if(patientMap.get("inpatientList") != null){
					inpatientList = (List<Inpatient>)patientMap.get("inpatientList");
				}
			
		if((inpatientList.size() > 0 ) || inpatientId != 0){
		detailsMap = adtHandlerService.getTransferDetails(hospitalId);
				}
				jsp = TRANSFER_BY_HIN_NO_JSP+".jsp";
				map.put("patientMap", patientMap);
				map.put("detailsMap", detailsMap);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView printExpiryDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		@SuppressWarnings("unused")
		Date currDate = null;
		int inpatientId = 0;
		int departmentId = 0;
		String placed_on = "";
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="expiryDetails";
			if(request.getParameter("inpatientId") != null){
				inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		dataMap.put("inpatientId", inpatientId);
		detailsMap = adtHandlerService.printExpiryDetails(dataMap);
		if(detailsMap.get("placed_on") !=null){
			placed_on =""+detailsMap.get("placed_on");
		}
		parameters.put("inpatientId", inpatientId);
		parameters.put("placed_on", placed_on);
//		try {
//			byte bytes[] = null;
//			try
//			{
//			bytes =	JasperRunManager.runReportToPdf(getCompiledReport(reportName),parameters,(Connection)detailsMap.get("conn"));
//			 HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
//			}
//			catch(JRException e)
//			{
//				e.printStackTrace();
//			}
//			
//			response.setContentType("application/pdf");
//			response.setContentLength(bytes.length);
//			ServletOutputStream ouputStream;
//			try {
//				ouputStream = response.getOutputStream();
//				ouputStream.write(bytes, 0, bytes.length);
//				ouputStream.flush();
//				ouputStream.close();
//				} catch (IOException e) 
//				{
//					e.printStackTrace();
//				}
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		}
		 HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	public ModelAndView showSearchPopup(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		map = adtHandlerService.getDetailsForSearch(hospitalId);
		jsp = SEARCH_POPUP;
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView searchUpdatePatientDischarge(HttpServletRequest request, HttpServletResponse response){

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		String serviceNo = "";
		String hinNo = "";	
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		int wardId = 0;
		String serPersonFName = "";
		String serPersonMName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String adNo = "";	
		int inpatientId = 0;
		try{
			if(request.getParameter(AD_NO) != null && !(request.getParameter(AD_NO).equals(""))){
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if(request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))){
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if(request.getParameter(SERVICE_NO) != null && !(request.getParameter(SERVICE_NO).equals(""))){
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if(request.getParameter(SERVICE_TYPE_ID) != null && !(request.getParameter(SERVICE_TYPE_ID).equals("0"))){
				serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID)) ;
				mapForDs.put("serviceTypeId", serviceTypeId);
			}
			if(request.getParameter(RANK_ID) != null && !(request.getParameter(RANK_ID).equals(""))){
				rankId = Integer.parseInt(request.getParameter(RANK_ID)) ;
				mapForDs.put("rankId", rankId);
			}
			if(request.getParameter(UNIT_ID) != null && !(request.getParameter(UNIT_ID).equals("0"))){
				unitId = Integer.parseInt(request.getParameter(UNIT_ID)) ;
				mapForDs.put("unitId", unitId);
			}
			if(request.getParameter(S_FIRST_NAME) != null && !(request.getParameter(S_FIRST_NAME).equals(""))){
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if(request.getParameter(S_MIDDLE_NAME) != null && !(request.getParameter(S_MIDDLE_NAME).equals(""))){
				serPersonMName = request.getParameter(S_MIDDLE_NAME);
				mapForDs.put("serPersonMName", serPersonMName);
			}
			if(request.getParameter(S_LAST_NAME) != null && !(request.getParameter(S_LAST_NAME).equals(""))){
				serPersonLName = request.getParameter(S_LAST_NAME);
				mapForDs.put("serPersonLName", serPersonLName);
			}
			if(request.getParameter(P_FIRST_NAME) != null && !(request.getParameter(P_FIRST_NAME).equals(""))){
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if(request.getParameter(P_MIDDLE_NAME) != null && !(request.getParameter(P_MIDDLE_NAME).equals(""))){
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDs.put("patientMName", patientMName);
			}
			if(request.getParameter(P_LAST_NAME) != null && !(request.getParameter(P_LAST_NAME).equals(""))){
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if(request.getParameter("inpatientId")!= null){
				inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		patientMap = adtHandlerService.searchPatientDischarge(mapForDs);
		map = adtHandlerService.getDetailsForSearch(hospitalId);
		String jsp = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		
		if(patientMap.get("inpatientList") != null){
			inpatientList = (List<Inpatient>)patientMap.get("inpatientList");
		}
		map.put("inpatientList", inpatientList);
		map.put("contentJsp", jsp);
		jsp = SEARCH_POPUP;
		return new ModelAndView(jsp,"map", map);
		
		
		
	}
	public void checkCancelAdmissionState(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String inpatientId ="";
		String cancelState ="no";
		if(request.getParameter("inpatientId") != null){
			inpatientId = (request.getParameter("inpatientId"));
		}
		dataMap.put("inpatientId",inpatientId);
		map = adtHandlerService.checkCancelAdmissionState(dataMap);
		if(map.get("cancelState") !=null){
			cancelState =""+map.get("cancelState");
		}
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			
				sb.append("<cancelState>"+cancelState+"</cancelState>");
			
				sb.append("</item>");
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
		
			try {
				response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<items>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public ModelAndView showTransferRegReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getServiceTypeDepartmentCategory();
				
		jsp = TRANSFER_REG_REPORT_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView printTransferRegReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		int departmentId1 = 0;
		int departmentId2 = 0;
		String stringVariable = "";
		Map<String, Object> parameters = new HashMap<String, Object>();
			if(request.getParameter(FROM_DATE) != null){
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			}
			if(request.getParameter(TO_DATE) != null){
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			}
		if(!request.getParameter(DEPARTMENT_ID).equals("0") && request.getParameter(DEPARTMENT_ID) !=null){
			departmentId1 = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			stringVariable = " and transfer.from_ward_id="+departmentId1;
		}
		if(!request.getParameter(DEPARTMENT_ID_TEMP).equals("0") && request.getParameter(DEPARTMENT_ID_TEMP) !=null){
			departmentId2 = Integer.parseInt(request.getParameter(DEPARTMENT_ID_TEMP));
			stringVariable = stringVariable+" and transfer.to_ward_id="+departmentId2;
		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("stringVariable", stringVariable);
//		try {
//			byte bytes[] = null;
//			try
//			{
//			bytes =	JasperRunManager.runReportToPdf(getCompiledReport("TransferReg"),parameters,(Connection)detailsMap.get("conn"));
//			 HMSUtil.generateReport("TransferReg", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//			
//			response.setContentType("application/pdf");
//			response.setContentLength(bytes.length);
//			ServletOutputStream ouputStream;
//			try {
//				ouputStream = response.getOutputStream();
//				ouputStream.write(bytes, 0, bytes.length);
//				ouputStream.flush();
//				ouputStream.close();
//				} catch (IOException e) 
//				{
//					e.printStackTrace();
//				}
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		}
		 HMSUtil.generateReport("TransferReg", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	
	public ModelAndView cancelDischarge(HttpServletRequest request,HttpServletResponse response)
	{
	   Map<String, Object> map = new HashMap<String, Object>();
	   Map<String, Object> dataMap = new HashMap<String, Object>();
	   int inpatientId =0;
	   if(request.getParameter("inpatientId") != null){
		   inpatientId =Integer.parseInt(""+(request.getParameter("inpatientId"))) ;
		}
	   dataMap.put("inpatientId", inpatientId);
	   map=adtHandlerService.cancelDischarge(dataMap);
	   String message ="";
	   if(map.get("saved") !=null)
		   if(map.get("saved").equals("yes"))
			   message ="Discharge Canceled successfully";
		   else
			   message ="Discharge not Canceled";
	   jsp = MESSAGE_FOR_CANCEL_DISCHARGE+".jsp";
	   map.put("contentJsp",jsp);
	   map.put("message",message);
	   return new ModelAndView("indexB", "map", map);
	 }
	public ModelAndView showUnitSearchJsp(HttpServletRequest request,HttpServletResponse response)
	{
	   Box box = HMSUtil.getBox(request);
	   Map<String, Object> map = new HashMap<String, Object>();
	   map=adtHandlerService.showUnitSearchJsp(box);
	   jsp = "unitNameSearch";
	   map.put("contentJsp",jsp);
	   return new ModelAndView(jsp, "map", map);
	 }
//	-----------Start of Methods written by KALYAN-------------------
	public ModelAndView showUnitValidateJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.showUnitValidateJsp();
		ArrayList  searchUnitList = (ArrayList)map.get("searchUnitList");

		jsp = UNIT_VALIDATION+".jsp";
		map.put("contentJsp",jsp);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showTradeValidateJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.showTradeValidateJsp();
		ArrayList  searchTradeList = (ArrayList)map.get("searchTradeList");

		jsp = TRADE_VALIDATION+".jsp";
		map.put("searchTradeList",searchTradeList);
		map.put("contentJsp",jsp);
		return new ModelAndView("indexB", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView searchUnitValidate(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String unitName  = null;
		String unitAddress = null;
		String searchField= null;
		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(searchRadio==1){
			unitName=searchField;
			unitAddress=null;
		}else{
			unitName=null;
			unitAddress=searchField;
		}

		map = adtHandlerService.searchUnit(unitName, unitAddress);

		jsp=UNIT_VALIDATION;

		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("unitName",unitName);
		map.put("unitAddress",unitAddress);
		return new ModelAndView("indexB", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView searchTradeValidate(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String tradeName  = null;
		String tradeAddress = null;
		String searchField= null;
		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(searchRadio==1){
			tradeName=searchField;			
		}

		map = adtHandlerService.searchTrade(tradeName);

		jsp=TRADE_VALIDATION;

		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("unitName",tradeName);
		map.put("unitAddress",tradeAddress);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	
	public ModelAndView getUnitDetails(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int id =0;
		if(request.getParameter("id") != null){
			id =Integer.parseInt(""+request.getParameter("id")) ;
		}
		map = adtHandlerService.getUnitDetails(id);
       jsp = "responseUnitValidate";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getTradeDetails(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int id =0;
		if(request.getParameter("id") != null){
			id =Integer.parseInt(""+request.getParameter("id")) ;
		}
		map = adtHandlerService.getTradeDetails(id);
       jsp = "responseTradeValidate";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	
	

	public ModelAndView validateUnit(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> validateUnitMap = new HashMap<String, Object>();
		int id =0;
		String unitName = "";
		String unitAddress = "";
		String localuUnit="n";
		 String message ="";
		if(request.getParameter("unitCode") != null){
			id =Integer.parseInt(""+request.getParameter("unitCode")) ;
		}
		
		if(request.getParameter("unitName") != null){
			unitName =request.getParameter("unitName");
		}
		if(request.getParameter("unitAddress") != null){
			unitAddress	 =request.getParameter("unitAddress");
		}
		if(request.getParameter("localUnit") != null){
			localuUnit =request.getParameter("localUnit");
		}
		validateUnitMap.put("id",id);
		validateUnitMap.put("unitName",unitName);
		validateUnitMap.put("unitAddress",unitAddress);
		validateUnitMap.put("localuUnit",localuUnit);
		
		map = adtHandlerService.updateUnit(validateUnitMap);
		message="Record Updated Successfully !!";
		
		jsp = UNIT_VALIDATION+".jsp";
		map.put("contentJsp",jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView validateTrade(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> validateTradeMap = new HashMap<String, Object>();
		int id =0;
		String tradeName = "";
		String tradeAddress = "";
		String localuTrade="n";
		 String message ="";
		if(request.getParameter("tradeCode") != null){
			id =Integer.parseInt(""+request.getParameter("tradeCode")) ;
		}
		if(request.getParameter("tradeName") != null){
			tradeName =request.getParameter("tradeName");
		}
		if(request.getParameter("tradeAddress") != null){
			tradeAddress	 =request.getParameter("tradeAddress");
		}
		if(request.getParameter("localTrade") != null){
			localuTrade =request.getParameter("localTrade");
		}
		validateTradeMap.put("id",id);
		validateTradeMap.put("tradeName",tradeName);
		
		
		map = adtHandlerService.updateTrade(validateTradeMap);
		message="Record Updated Successfully !!";
		
		jsp = TRADE_VALIDATION+".jsp";
		map.put("contentJsp",jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateValidateUnit(HttpServletRequest request,HttpServletResponse response) throws ServletRequestBindingException
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> unitMap = new HashMap<String, Object>();
		int newId =0;
		int oldId=0;
		String message ="";
		if(request.getParameter("newUnitId") != null){
			newId =Integer.parseInt(""+request.getParameter("newUnitId")) ;
		}
		
		if(request.getParameter("unitCode") != null){
			oldId =Integer.parseInt(""+request.getParameter("unitCode")) ;
		}
		
	
		Box box = HMSUtil.getBox(request);
		
		unitMap.put("newId",newId);
		unitMap.put("oldId",oldId);
    
		map = adtHandlerService.updateValidateUnit(unitMap,box);
		
		boolean data =(Boolean) map.get("data");
		if(data){
			message = "Record Deleted Successfully!! ";
		}else{
			message="Record Updated Successfully  ";	
		}
		
		jsp = UNIT_VALIDATION+".jsp";
		map.put("contentJsp",jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView updateValidateTrade(HttpServletRequest request,HttpServletResponse response) throws ServletRequestBindingException
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tradeMap = new HashMap<String, Object>();
		int newId =0;
		int oldId=0;
		String message ="";
		if(request.getParameter("newTradeId") != null){
			newId =Integer.parseInt(""+request.getParameter("newTradeId")) ;
		}
		
		if(request.getParameter("tradeCode") != null){
			oldId =Integer.parseInt(""+request.getParameter("tradeCode")) ;
		}
		
	
		Box box = HMSUtil.getBox(request);
		
		tradeMap.put("newId",newId);
		tradeMap.put("oldId",oldId);
    
		map = adtHandlerService.updateValidateTrade(tradeMap,box);
		boolean data =(Boolean) map.get("data");
		if(data){
			message = "Record Deleted Successfully!! ";
		}else{
			message="Record Updated Successfully  ";	
		}
		
		jsp = TRADE_VALIDATION+".jsp";
		map.put("contentJsp",jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView deleteValidateUnit(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int unitId =0;
		if(request.getParameter("unit") != null){
			unitId =Integer.parseInt(""+request.getParameter("unit")) ;
		}
		map = adtHandlerService.deleteValidateUnit(unitId);
		
		jsp = UNIT_VALIDATION+".jsp";
		map.put("contentJsp",jsp);
		
		return new ModelAndView("indexB", "map", map);
}


	public void getNewUnitDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List objectList=new ArrayList();
		int newUnitId =0;
		if(request.getParameter("NewUnitId") != null && !request.getParameter("NewUnitId").equals("")){
			newUnitId = Integer.parseInt(""+request.getParameter("NewUnitId")) ;
		}
		
        dataMap.put("newUnitId",newUnitId);
		@SuppressWarnings("unused")
		
		List<MasUnit> masUnitList =new ArrayList<MasUnit>();
		map = adtHandlerService.getNewUnitDetails(dataMap);
		masUnitList=(List<MasUnit>)map.get("newUnitList");
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			
			 for(MasUnit masUnit :masUnitList){
			if(masUnit.getUnitAddress()!=""){
				 sb.append("<sUnitAddress>" +masUnit.getUnitAddress()+ "</sUnitAddress>");
			}else{
				 sb.append("<sUnitAddress>" +" "+ "</sUnitAddress>");
			}	 
				sb.append("<sLocalUnit>" + masUnit.getLocalUnit()+ "</sLocalUnit>");
			 }
				sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		
			try {
				response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<items>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public ModelAndView cancelFinalDischargeJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		//departmentList = adtHandlerService.getDepartmentList();
		jsp = "cancelFinalDischargeJsp.jsp";
		map.put("departmentList", departmentList);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showFinalDischargeList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> dischargeMap = new HashMap<String, Object>();
		int departmentId = 0;
		String serviceNo = null;
		String adNo = null;
		String hin = null;	

		try{
			if(request.getParameter(SERVICE_NO) != null && !(request.getParameter(SERVICE_NO).equals(""))){
				serviceNo = request.getParameter(SERVICE_NO);
				dischargeMap.put("serviceNo", serviceNo);
			}
			if(request.getParameter(AD_NO) != null && !(request.getParameter(AD_NO).equals(""))){
				adNo = request.getParameter(AD_NO);
				dischargeMap.put("adNo", adNo);
			}
			if(request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))){
				hin = request.getParameter(HIN_NO);
				dischargeMap.put("hin", hin);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = adtHandlerService.getFinalDischargePatientList(dischargeMap);

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = adtHandlerService.getDepartmentList();

		jsp = "cancelFinalDischargeJsp.jsp";

		map.put("departmentList", departmentList);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("departmentId", departmentId);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView cancelDischargePatient(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		int dischargeId = 0;
		if(request.getParameter("parent") != null){
			dischargeId = Integer.parseInt(request.getParameter("parent"));
			detailsMap.put("dischargeId", dischargeId);
		}
		String  dischargeSuccessfully = "false";
		tempMap = adtHandlerService.canceldischargePatient(detailsMap);

		String message = "";
		dischargeSuccessfully=""+tempMap.get("dischargeSuccessfully");
		if (dischargeSuccessfully.equals("true") ) {
			message=" Canceled Patient Discharge Successfully.";

		}else{
			message = "Some problem Occured! Try Again.";
		}
		String backUrl = "";
		backUrl = "/hms/hms/adt?method=cancelFinalDischargeJsp";

		jsp = "messageForCancelDischarge.jsp";
		map.put("inpatientId",tempMap.get("inpatientId"));
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("backUrl", backUrl);
		return new ModelAndView("indexB", "map", map);
	}	
	
//	-----------End of Methods written by KALYAN-------------------
//	-----------------------------------------------------------------------------
	//////////////   Code Added For OPD             ////////////////////
	@SuppressWarnings("unchecked")
    public void getIcdWithIcdCodeForOpd(HttpServletRequest
    						request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List objectList=new ArrayList();
		String icdCode ="";
		if(request.getParameter("icdCode") != null){
			icdCode = (request.getParameter("icdCode"));
		}
		dataMap.put("icdCode",icdCode);
		List<MasIcd> masIcdList =new ArrayList<MasIcd>();
		map = adtHandlerService.getIcdWithIcdCode(dataMap);
		masIcdList=(List)map.get("masIcdList");
		String icdString ="no";
		for(MasIcd masIcd :masIcdList){
			icdString =
					masIcd.getIcdSubCategory().getIcdSubCategoryName()+":"+masIcd.getIcdName()+"["+masIcd.getIcdCode()+"]["+masIcd.getId()+"]";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<icdString>"+icdString.toUpperCase()+"</icdString>");
		sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
					response.getWriter().write("<items>");
					response.getWriter().write(sb.toString());
					response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
        }
	}
	public void checkTodayTransactions(HttpServletRequest
			request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List objectList=new ArrayList();
		String adNo ="";
		if(request.getParameter("adNo") != null){
			adNo = request.getParameter("adNo");
		}
		String status = "false";
		dataMap.put("adNo",adNo);
		map = adtHandlerService.checkTodayTransactions(dataMap);
		status=(String)map.get("status");

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<status>"+status+"</status>");
		sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ModelAndView showExpiryJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "searchForExpiryPatient"+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	/*public ModelAndView showExpiryDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "searchForExpiryPatient"+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}*/
	public ModelAndView deleteValidateTrade(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int tradeId =0;
		if(request.getParameter("trade") != null){
			tradeId =Integer.parseInt(""+request.getParameter("trade")) ;
		}
		map = adtHandlerService.deleteValidateTrade(tradeId);
		
		jsp = TRADE_VALIDATION+".jsp";
		map.put("contentJsp",jsp);
		
		return new ModelAndView("indexB", "map", map);
}
	public ModelAndView showTradeSearchJsp(HttpServletRequest request,HttpServletResponse response)
	{
	   Box box = HMSUtil.getBox(request);
	   Map<String, Object> map = new HashMap<String, Object>();
	   map=adtHandlerService.showTradeSearchJsp(box);
	   jsp = "tradeNameSearch";
	   map.put("contentJsp",jsp);
	   return new ModelAndView(jsp, "map", map);
	 }
	
	
	public ADTHandlerService getAdtHandlerService() {
		return adtHandlerService;
	}
	public void setAdtHandlerService(ADTHandlerService adtHandlerService) {
		this.adtHandlerService = adtHandlerService;
	}
	//--------------Injury Report By Vishal------------
	public ModelAndView showInjuryReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.showInjuryReportJsp();
		jsp = INJURY_REPORT_JSP;
		jsp += ".jsp";
		String title = "Injury Admission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView PrintInjuryReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		Map<String, Object> parameters = new HashMap<String, Object>();
			if(request.getParameter(FROM_DATE) != null){
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			}
			if(request.getParameter(TO_DATE) != null){
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
	
		HMSUtil.generateReport("injuryReport", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	public ModelAndView showLabelReport(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String ad_no = "";
		detailsMap = adtHandlerService.getConnectionForReport();
		if(request.getParameter(AD_NO) != null){
			ad_no = request.getParameter(AD_NO);
		}
		parameters.put("ad_no", ad_no);

		HMSUtil.generateReport("ADNO_Label_report", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}	
	
	public ModelAndView getHinNoForAdm(HttpServletRequest request, HttpServletResponse  response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String serviceNo = box.getString("serviceNo");
		map = adtHandlerService.getHinNoForAdm(serviceNo);
		String jsp = "responseForAdmHinNo";
		
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView showPatientAdmissionJsp(HttpServletRequest request, HttpServletResponse  response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		detailsMap = adtHandlerService.getAdmissionDetails(hospitalId);
		String jsp = "admissionByHinNo.jsp";
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchPatintForAdmAjax(HttpServletRequest request, HttpServletResponse  response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int hinId = 0;
		if(request.getParameter("hinId")!= null && !request.getParameter("hinId").equals("")){
			hinId = Integer.parseInt(request.getParameter("hinId"));
			mapForDs.put("hinId", hinId);
		}
		patientMap = adtHandlerService.getPatientDetails(mapForDs);
		
		String message = "";
		List<Patient> patientList = new ArrayList<Patient>();
		
		if(patientMap.get("patientList") != null){
			patientList = (List<Patient>)patientMap.get("patientList");
		}
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		detailsMap = adtHandlerService.getAdmissionDetails(hospitalId);
		if(patientList.size() > 0){
			for (Patient patient : patientList) {
				if(patient.getPatientStatus().equals("In Patient")){
					message = "Patient already admitted";
					map.put("message", message);
				}
				jsp = ADMISSION_BY_HIN_NO_JSP+".jsp";
			}
		}
		
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
			
		return new ModelAndView("responsePatientForAdm","map",map);
	}
	public ModelAndView showPatientTrackJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> ptmap = new HashMap<String, Object>();
		int hospitalId = 0;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		box.put("hospitalId", hospitalId);
		map = adtHandlerService.getDetailsForSearch(hospitalId);
		ptmap = adtHandlerService.searchPatientTrack(box);
		String jsp = "patientTrack.jsp";
		map.put("contentJsp", jsp);
		map.put("ptmap", ptmap);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView searchPatientTrack(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> ptmap = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = adtHandlerService.getDetailsForSearch(hospitalId);
		ptmap = adtHandlerService.searchPatientTrack(box);
		String jsp = "patientTrack.jsp";
		map.put("contentJsp", jsp);
		map.put("ptmap", ptmap);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView showPatientAppointmentJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		map = adtHandlerService.getDetailsForSearch(hospitalId);
		String jsp = "patientAppointment.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView getHinForAppointment(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String serviceNo = box.getString(SERVICE_NO);
		List<Object> hinNoList = new ArrayList<Object>();
		hinNoList = adtHandlerService.getHinNoList(serviceNo);
		map.put("hinNoList", hinNoList);
		String jsp = "responseHinForAppointment";
		return new ModelAndView(jsp,"map",map);
	}
	
	public ModelAndView getHinDetailsForAppointment(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = adtHandlerService.getHinDetailsForAppointment(box);
		
		String jsp = "responsePtDtForAppointment";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView submitPatientAppointment(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dtmap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		Users user = new Users();
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		if(session.getAttribute("users") != null){
			user = (Users)session.getAttribute("users");
		}
		box.put("userId", user.getId());
		box.put("hospitalId", hospitalId);
		
		boolean flag = false;
		dtmap = adtHandlerService.submitPatientAppointment(box);
		if(dtmap.get("flag")!= null){
			flag = (Boolean)dtmap.get("flag");
		}
		String message = "";
		if(flag){
			message= "Record saved successfully.";
		}else{
			message = "Some Problem Occured!";
		}
		map = adtHandlerService.getDetailsForSearch(hospitalId);
		String jsp = "patientAppointment.jsp";
		map.put("dtmap", dtmap);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView cancelPatientAppointment(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		boolean flag = false;
		flag = adtHandlerService.cancelPatientAppointment(box);
		String message = "";
		if(flag){
			message= "Appointment Cancelled.";
		}else{
			message = "Some Problem Occured!";
		}
		map = adtHandlerService.getDetailsForSearch(hospitalId);
		String jsp = "patientAppointment.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView searchAppointments(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dtmap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		box.put("hospitalId", hospitalId);
		dtmap = adtHandlerService.searchAppointments(box);
		map = adtHandlerService.getDetailsForSearch(hospitalId);
		String jsp = "patientAppointment.jsp";
		map.put("contentJsp", jsp);
		map.put("dtmap", dtmap);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView getPatientNamesForApp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = adtHandlerService.getPatientNamesForApp(box);
		map.put("counter", box.getInt("counter"));
		return new ModelAndView("responseForPatientName","map",map);
	}
	
	@SuppressWarnings("unchecked")
	public void getPatientDetailsForApp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList =new ArrayList<Patient>();
		Box box = HMSUtil.getBox(request);
		map = adtHandlerService.getPatientDetailsForApp(box);
		patientList=(List<Patient>) map.get("patientList");
	
		StringBuffer sb = new StringBuffer();
		for(Patient patient : patientList){
			sb.append("<item>");
			sb.append("<hinId>"+patient.getId()+"</hinId>");
			sb.append("<serviceTypeId>"+patient.getServiceType().getId()+"</serviceTypeId>");
			sb.append("<relation>"+patient.getRelation().getRelationName()+"</relation>");
			sb.append("<relationId>"+patient.getRelation().getId()+"</relationId>");
			sb.append("<rank>"+patient.getRank().getRankName()+"</rank>");
			sb.append("<rankId>"+patient.getRank().getId()+"</rankId>");
			sb.append("<sname>"+patient.getSFirstName()+" "+(patient.getSMiddleName()!=null?patient.getSMiddleName():"")+" "+(patient.getSLastName()!=null?patient.getSLastName():"")+"</sname>");
			sb.append("<unit>"+patient.getUnit().getUnitName()+"</unit>");
			sb.append("<pname>"+patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"")+"</pname>");
			sb.append("<sex>"+patient.getSex().getId()+"</sex>");
			sb.append("<age>"+patient.getAge()+"</age>");
			sb.append("</item>");
	
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ModelAndView showMlcJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> patientDetailsMap = new HashMap<String, Object>();
		map = adtHandlerService.getDetailsForMLC();
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		parameterMap.put("date", date);
		HttpSession session= request.getSession();
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		parameterMap.put("hospitalId", hospitalId);
		String mlcNo = adtHandlerService.generateMLCNo(parameterMap);
		map.put("mlcNo", mlcNo);
		if(request.getParameter("hinId")!=null) {
			map.put("hinId", Integer.parseInt(request.getParameter("hinId")));
			patientDetailsMap = adtHandlerService.getPatientDetails(map);
			map.put("patientMap", patientDetailsMap);
		}
		/*jsp = "mlc_case.jsp";
		map.put("contentJsp", jsp);*/
		String backFlag = "";
		if(request.getParameter("backFlag")!=null)
		{ 
			backFlag =request.getParameter("backFlag");
		}
		String jsp = "";
		if(backFlag.equals("OPD")||backFlag.equals("fp")){
			jsp = "mlc_case";
		}else{
			
			map.put("contentJsp", "mlc_case.jsp");
			jsp = "index";
		}
		map.put("backFlag", backFlag);
		if( request.getParameter("flag")!=null)
			map.put("flag", HMSUtil.restrictMetaChar(request.getParameter("flag")));
		if(request.getParameter("adNo")!=null)
			map.put("adNo", HMSUtil.restrictMetaChar(request.getParameter("adNo")));
		if(request.getParameter("parent")!=null)
			map.put("inpatientId", Integer.parseInt(request.getParameter("parent")));
		return new ModelAndView(jsp, "map", map);
		
	}
	public ModelAndView getHinNoForMlc(HttpServletRequest request, HttpServletResponse  response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String serviceNo = HMSUtil.restrictMetaChar(box.getString("serviceNo"));
		List<Object> hinNoList = new ArrayList<Object>();
		hinNoList = adtHandlerService.getHinNoList(serviceNo);
		String jsp = "responseForHinNo";
		map.put("hinNoList", hinNoList);
		map.put("mlcForm", "mlcForm");
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getPatientDetailsForMlc(HttpServletRequest request, HttpServletResponse  response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		
		String hinNo = "";
		if(request.getParameter("hinNo")!= null){
			hinNo = HMSUtil.restrictMetaChar(request.getParameter("hinNo"));
			mapForDs.put("hinNo", hinNo);
		}
		map = adtHandlerService.getPatientDetails(mapForDs);
		return new ModelAndView("responsePatientForMLC","map",map);
	}
	

	public ModelAndView showIpAdmissionRegisterGraph(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = adtHandlerService.showIpAdmissionRegisterGraph(box);
		List<Object[]> ipRegisterList = new ArrayList<Object[]>();
		ipRegisterList = (List<Object[]>)map.get("ipRegisterList");
		String ENCODING = "ISO-8859-1";
		try {
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_ip_data.xml")));
		
			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING
					+ "\"?>");
			out.write("<chart>");
			int i =0;
				out.write("<series>");
				for(Object[] object : ipRegisterList){
					out.write("<value xid='"+i+"'>"+HMSUtil.convertDateToStringWithoutTime((Date)object[0])+"</value>");
					i++;
				}
				out.write("</series>");
				out.write("<graphs>");
				int j=1;
				
				for(int k=0;k<5;k++){
					
					out.write("<graph gid='"+k+"'>");
					int l=0;
					for(Object[] objVal : ipRegisterList){
						
						if(objVal[j]!=null)
							out.write("<value xid='"+l+"' >"+objVal[j]+"</value>");
						else
							out.write("<value xid='"+l+"' >0</value>");
						l++;
						
					}
					j++;
					out.write("</graph>");
				}
			
				out.write("</graphs>");
				
			
			out.write("</chart>");
			out.close();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "IPRegisterGraph";
		
		return new ModelAndView(jsp,"map",map);
	}

	public ModelAndView showIPRegisterOnScreen(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = adtHandlerService.showIPRegisterOnScreen(box);
		String jsp = "ipRegister.jsp";
		map.put("contentJsp", jsp);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}
	

	public ModelAndView showAvailableBedStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		HttpSession session =request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		box.put("hospitalId", hospitalId);
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getBedStatus(box);
		jsp = "ADT_Bed_Selection";
		map.put("contentJsp", jsp);
		map.put("chargeCodeId", box.getInt("chargeCodeId"));
		map.put("hinNo", box.getString("hinNo"));
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView cancelAdmission(HttpServletRequest request,
			HttpServletResponse response) {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				Map<String, Object> map = new HashMap<String, Object>();
				
				int id = 0;
				HttpSession session = request.getSession();
				int hospitalId = 0;
				int deptId = 0;
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
				}
				
			if(request.getParameter("id")!=null)
			{
				id = Integer.parseInt(request.getParameter("id")); 
			}
				dataMap.put("hospitalId", hospitalId);
				dataMap.put("id", id);
			map = adtHandlerService.cancelAdmission(dataMap);
				
				boolean result = false;
				if (map.get("result") != null) {
					result = (Boolean) map.get("result");
				}
				
				try {
					response.setContentType("application/json");
					PrintWriter pw = response.getWriter();
					if(result)
					  pw.write("s");
					else
					  pw.write("f");	
					
				
				}
				
				catch (Exception e) {
					e.printStackTrace();
				}
				
				return null;
			}
}

