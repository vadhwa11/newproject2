/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * EnquiryController.java – 
 * Purpose of the class - This is Enquiry Module. 
 * It contains Patient Enquiry and Doctor Enquiry. 
 * @author  Ritu Sahu 
 * Create Date: 8th Feb,2008   
 * Revision Date:      
 * Revision By: Purpose
 * @version 1.0  
 **/

package jkt.hms.enquiry.controller;

import static jkt.hms.util.RequestConstants.ADDRESS;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.DISTRICT_ID;
import static jkt.hms.util.RequestConstants.DOCTOR_ENQUIRY_JSP;
import static jkt.hms.util.RequestConstants.DOCTOR_NAME;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.IN_PATIENT_ENQUIRY_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_DEPARTMENT;
import static jkt.hms.util.RequestConstants.PATIENT_DETAILS;
import static jkt.hms.util.RequestConstants.PATIENT_ENQUIRY_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_ENQUIRY_JSP1;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PATIENT_STATUS;
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.P_LAST_NAME;
import static jkt.hms.util.RequestConstants.P_MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.RESPONCE_FOR_AD_VISIT;
import static jkt.hms.util.RequestConstants.RESPONCE_FOR_ALL_ENQUIRY;
import static jkt.hms.util.RequestConstants.RESPONCE_FOR_ALL_ENQUIRY1;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_PERSON_NAME;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.STATE_ID;
import static jkt.hms.util.RequestConstants.S_FIRST_NAME;
import static jkt.hms.util.RequestConstants.S_LAST_NAME;
import static jkt.hms.util.RequestConstants.S_MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.WARD_ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.enquiry.handler.EnquiryHandlerService;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class EnquiryController extends MultiActionController {

	EnquiryHandlerService enquiryHandlerService = null;

	public ModelAndView showEnquiryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		String jsp = "";
		if (request.getParameter("jspName") != null) {
			jsp = request.getParameter("jspName");
		}
		if (jsp.equals("patientEnquiry")) {
			map = enquiryHandlerService.getDetailsForEnquiry();
		} else if (jsp.equals("doctorEnquiry")) {
			wardList = enquiryHandlerService.getWardList();
			map.put("wardList", wardList);
		} else if (jsp.equals("inPatientEnquiry")) {
			map = enquiryHandlerService.getDetailsForEnquiry();
		}
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showEnquiryJsp1(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		String jsp = "";
		if (request.getParameter("jspName") != null) {
			jsp = request.getParameter("jspName");
		}
		if (jsp.equals("patientEnquiry1")) {
			map = enquiryHandlerService.getDetailsForEnquiry();
		} else if (jsp.equals("doctorEnquiry")) {
			wardList = enquiryHandlerService.getWardList();
			map.put("wardList", wardList);
		} else if (jsp.equals("inPatientEnquiry")) {
			map = enquiryHandlerService.getDetailsForEnquiry();
		}
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchPatientForEnquiry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> enquiryMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonName = "";
		String serMName = "";
		String serLName = "";
		String patientName = "";
		String patMName = "";
		String patLName = "";
		int hinId = 0;
		String address = "";
		int districtId = 0;
		int stateId = 0;
		String patientStatus = "";
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				enquiryMap.put("hinNo", hinNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				enquiryMap.put("adNo", adNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				enquiryMap.put("serviceNo", serviceNo);
			}
			if (!(request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
				serviceTypeId = Integer.parseInt(request
						.getParameter(SERVICE_TYPE_ID));
				enquiryMap.put("serviceTypeId", serviceTypeId);
			}
			if (!(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				enquiryMap.put("rankId", rankId);
			}
			if (!(request.getParameter(UNIT_ID).equals("0"))) {
				unitId = Integer.parseInt(request.getParameter(UNIT_ID));
				enquiryMap.put("unitId", unitId);
			}
			if (request.getParameter(SERVICE_PERSON_NAME) != null
					&& !(request.getParameter(SERVICE_PERSON_NAME).equals(""))) {
				serPersonName = request.getParameter(SERVICE_PERSON_NAME);
				enquiryMap.put("serPersonName", serPersonName);
			}
			if (request.getParameter(S_MIDDLE_NAME) != null
					&& !(request.getParameter(S_MIDDLE_NAME).equals(""))) {
				serMName = request.getParameter(S_MIDDLE_NAME);
				enquiryMap.put("serMName", serMName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serLName = request.getParameter(S_LAST_NAME);
				enquiryMap.put("serLName", serLName);
			}
			if (request.getParameter(PATIENT_NAME) != null
					&& !(request.getParameter(PATIENT_NAME).equals(""))) {
				patientName = request.getParameter(PATIENT_NAME);
				enquiryMap.put("patientName", patientName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patMName = request.getParameter(P_MIDDLE_NAME);
				enquiryMap.put("patMName", patMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patLName = request.getParameter(P_LAST_NAME);
				enquiryMap.put("patLName", patLName);
			}
			if (request.getParameter(ADDRESS) != null
					&& !(request.getParameter(ADDRESS).equals(""))) {
				address = request.getParameter(ADDRESS);
				enquiryMap.put("address", address);
			}
			if (!(request.getParameter(DISTRICT_ID).equals("0"))) {
				districtId = Integer
						.parseInt(request.getParameter(DISTRICT_ID));
				enquiryMap.put("districtId", districtId);
			}
			if (!(request.getParameter(STATE_ID).equals("0"))) {
				stateId = Integer.parseInt(request.getParameter(STATE_ID));
				enquiryMap.put("stateId", stateId);
			}
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				enquiryMap.put("hinId", hinId);
			}
			if (request.getParameter(PATIENT_STATUS) != null
					&& !(request.getParameter(PATIENT_STATUS).equals(""))) {
				patientStatus = request.getParameter(PATIENT_STATUS);
				enquiryMap.put("patientStatus", patientStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = enquiryHandlerService
				.getPatientDetailsForEnquiry(enquiryMap);
		map = enquiryHandlerService.getDetailsForEnquiry();

		String jsp = PATIENT_ENQUIRY_JSP;
		jsp += ".jsp";
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchPatientForEnquiry1(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> enquiryMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonName = "";
		String serMName = "";
		String serLName = "";
		String patientName = "";
		String patMName = "";
		String patLName = "";
		int hinId = 0;
		String address = "";
		int districtId = 0;
		int stateId = 0;
		String patientStatus = "";
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				enquiryMap.put("hinNo", hinNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				enquiryMap.put("adNo", adNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				enquiryMap.put("serviceNo", serviceNo);
			}
			if (!(request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
				serviceTypeId = Integer.parseInt(request
						.getParameter(SERVICE_TYPE_ID));
				enquiryMap.put("serviceTypeId", serviceTypeId);
			}
			if (!(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				enquiryMap.put("rankId", rankId);
			}
			if (!(request.getParameter(UNIT_ID).equals("0"))) {
				unitId = Integer.parseInt(request.getParameter(UNIT_ID));
				enquiryMap.put("unitId", unitId);
			}
			if (request.getParameter(SERVICE_PERSON_NAME) != null
					&& !(request.getParameter(SERVICE_PERSON_NAME).equals(""))) {
				serPersonName = request.getParameter(SERVICE_PERSON_NAME);
				enquiryMap.put("serPersonName", serPersonName);
			}
			if (request.getParameter(S_MIDDLE_NAME) != null
					&& !(request.getParameter(S_MIDDLE_NAME).equals(""))) {
				serMName = request.getParameter(S_MIDDLE_NAME);
				enquiryMap.put("serMName", serMName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serLName = request.getParameter(S_LAST_NAME);
				enquiryMap.put("serLName", serLName);
			}
			if (request.getParameter(PATIENT_NAME) != null
					&& !(request.getParameter(PATIENT_NAME).equals(""))) {
				patientName = request.getParameter(PATIENT_NAME);
				enquiryMap.put("patientName", patientName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patMName = request.getParameter(P_MIDDLE_NAME);
				enquiryMap.put("patMName", patMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patLName = request.getParameter(P_LAST_NAME);
				enquiryMap.put("patLName", patLName);
			}
			if (request.getParameter(ADDRESS) != null
					&& !(request.getParameter(ADDRESS).equals(""))) {
				address = request.getParameter(ADDRESS);
				enquiryMap.put("address", address);
			}
			if (!(request.getParameter(DISTRICT_ID).equals("0"))) {
				districtId = Integer
						.parseInt(request.getParameter(DISTRICT_ID));
				enquiryMap.put("districtId", districtId);
			}
			if (!(request.getParameter(STATE_ID).equals("0"))) {
				stateId = Integer.parseInt(request.getParameter(STATE_ID));
				enquiryMap.put("stateId", stateId);
			}
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				enquiryMap.put("hinId", hinId);
			}
			if (request.getParameter(PATIENT_STATUS) != null
					&& !(request.getParameter(PATIENT_STATUS).equals(""))) {
				patientStatus = request.getParameter(PATIENT_STATUS);
				enquiryMap.put("patientStatus", patientStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = enquiryHandlerService.getPatientDetailsForEnquiry(enquiryMap);
		map = enquiryHandlerService.getDetailsForEnquiry();

		String jsp = PATIENT_ENQUIRY_JSP1;
		jsp += ".jsp";
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchDoctorForEnquiry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> enquiryMap = new HashMap<String, Object>();
		String doctorName = "";
		int departmentId = 0;
		if (request.getParameter(DOCTOR_NAME) != null
				&& !request.getParameter(DOCTOR_NAME).equals("")) {
			doctorName = request.getParameter(DOCTOR_NAME);
			enquiryMap.put("doctorName", doctorName);
		}
		if (!request.getParameter(PATIENT_DEPARTMENT).equals("0")) {
			departmentId = Integer.parseInt(request
					.getParameter(PATIENT_DEPARTMENT));
			enquiryMap.put("departmentId", departmentId);
		}
		map = enquiryHandlerService.getDoctorList(enquiryMap);

		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		wardList = enquiryHandlerService.getWardList();
		map.put("wardList", wardList);

		String jsp = DOCTOR_ENQUIRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	// -----------------------------------------InPatient
	// Enquiry--------------------------------
	public ModelAndView searchInPatientForEnquiry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> enquiryMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonName = "";
		String patientName = "";
		int hinId = 0;
		String address = "";
		int districtId = 0;
		int stateId = 0;
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				enquiryMap.put("hinNo", hinNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				enquiryMap.put("adNo", adNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				enquiryMap.put("serviceNo", serviceNo);
			}
			if (!(request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
				serviceTypeId = Integer.parseInt(request
						.getParameter(SERVICE_TYPE_ID));
				enquiryMap.put("serviceTypeId", serviceTypeId);
			}
			if (!(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				enquiryMap.put("rankId", rankId);
			}
			if (!(request.getParameter(UNIT_ID).equals("0"))) {
				unitId = Integer.parseInt(request.getParameter(UNIT_ID));
				enquiryMap.put("unitId", unitId);
			}
			if (request.getParameter(SERVICE_PERSON_NAME) != null
					&& !(request.getParameter(SERVICE_PERSON_NAME).equals(""))) {
				serPersonName = request.getParameter(SERVICE_PERSON_NAME);
				enquiryMap.put("serPersonName", serPersonName);
			}
			if (request.getParameter(PATIENT_NAME) != null
					&& !(request.getParameter(PATIENT_NAME).equals(""))) {
				patientName = request.getParameter(PATIENT_NAME);
				enquiryMap.put("patientName", patientName);
			}
			if (request.getParameter(ADDRESS) != null
					&& !(request.getParameter(ADDRESS).equals(""))) {
				address = request.getParameter(ADDRESS);
				enquiryMap.put("address", address);
			}
			if (!(request.getParameter(DISTRICT_ID).equals("0"))) {
				districtId = Integer
						.parseInt(request.getParameter(DISTRICT_ID));
				enquiryMap.put("districtId", districtId);
			}
			if (!(request.getParameter(STATE_ID).equals("0"))) {
				stateId = Integer.parseInt(request.getParameter(STATE_ID));
				enquiryMap.put("stateId", stateId);
			}
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				enquiryMap.put("hinId", hinId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = enquiryHandlerService
				.getInPatientDetailsForEnquiry(enquiryMap);
		map = enquiryHandlerService.getDetailsForEnquiry();

		String jsp = IN_PATIENT_ENQUIRY_JSP;
		jsp += ".jsp";
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// -----------------------Added By Vivek on 09-07-08
	public ModelAndView searchIP(HttpServletRequest request,
			HttpServletResponse response) {
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
		try {
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(SERVICE_TYPE_ID) != null
					&& !(request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
				serviceTypeId = Integer.parseInt(request
						.getParameter(SERVICE_TYPE_ID));
				mapForDs.put("serviceTypeId", serviceTypeId);
			}
			if (request.getParameter(RANK_ID) != null
					&& !(request.getParameter(RANK_ID).equals(""))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				mapForDs.put("rankId", rankId);
			}
			if (request.getParameter(UNIT_ID) != null
					&& !(request.getParameter(UNIT_ID).equals("0"))) {
				unitId = Integer.parseInt(request.getParameter(UNIT_ID));
				mapForDs.put("unitId", unitId);
			}
			if (request.getParameter(UNIT_ID) != null
					&& !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				mapForDs.put("wardId", wardId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(S_MIDDLE_NAME) != null
					&& !(request.getParameter(S_MIDDLE_NAME).equals(""))) {
				serPersonMName = request.getParameter(S_MIDDLE_NAME);
				mapForDs.put("serPersonMName", serPersonMName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serPersonLName = request.getParameter(S_LAST_NAME);
				mapForDs.put("serPersonLName", serPersonLName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDs.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = enquiryHandlerService
				.getInPatientDetailsForEnquiry2(mapForDs);
		String jsp = "";
		map = enquiryHandlerService.getDetailsForEnquiry();
		jsp = "inPatientEnquiry" + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// -------Added by Vivek At Bangalore-------------

	public ModelAndView getAdVisitDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		String parentId = "";
		String detailId = "";
		int id = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("id") != null) {
			id = Integer.parseInt("" + request.getParameter("id"));
		}

		//System.out.println("id   " + id);
		dataMap.put("id", id);
		map = enquiryHandlerService.getAdVisitDetails(dataMap);
		String jsp = RESPONCE_FOR_AD_VISIT;
		map.put("contentJsp", jsp);
		map.put("parentId", parentId);
		map.put("detailId", detailId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getAllEnquiry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		String opOrString = "";
		String detailId = "";
		int id = 0;
		int hinId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("opOrString") != null) {
			opOrString = ("" + request.getParameter("opOrString"));
		}
		if (request.getParameter("detailId") != null) {
			detailId = ("" + request.getParameter("detailId"));
		}

		if (request.getParameter("id") != null) {
			id = Integer.parseInt("" + request.getParameter("id"));
		}
		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt("" + request.getParameter("hinId"));
		}
		//System.out.println("opOrString  " + opOrString);
		//System.out.println("detailId  " + detailId);
		//System.out.println("id  " + id);
		//System.out.println("hinId  " + hinId);
		dataMap.put("detailId", detailId);
		dataMap.put("opOrString", opOrString);
		dataMap.put("id", id);
		dataMap.put("hinId", hinId);
		map = enquiryHandlerService.getAllEnquiry(dataMap);
		String jsp = RESPONCE_FOR_ALL_ENQUIRY;
		map.put("contentJsp", jsp);
		map.put("opOrString", opOrString);
		map.put("detailId", detailId);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getAllEnquiry1(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		String opOrString = "";
		String detailId = "";
		int id = 0;
		int hinId = 0;
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("opOrString") != null) {
			opOrString = ("" + request.getParameter("opOrString"));
		}
		if (request.getParameter("detailId") != null) {
			detailId = ("" + request.getParameter("detailId"));
		}

		if (request.getParameter("id") != null) {
			id = Integer.parseInt("" + request.getParameter("id"));
		}
		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt("" + request.getParameter("hinId"));
		}
		
		dataMap.put("detailId", detailId);
		dataMap.put("opOrString", opOrString);
		dataMap.put("id", id);
		dataMap.put("hinId", hinId);
		map = enquiryHandlerService.getAllEnquiry1(dataMap);
		String jsp="";
		if (detailId.equals("Diagnostics")) {

			jsp = "responseForDiagEnquiry";

			} else {

			jsp = RESPONCE_FOR_ALL_ENQUIRY1;

			}

		map.put("contentJsp", jsp);
		map.put("opOrString", opOrString);
		map.put("detailId", detailId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		String hinNo = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}
		dataMap.put("hinNo", hinNo);
		map = enquiryHandlerService.showPatientDetails(dataMap);
		String jsp = PATIENT_DETAILS + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showPatientDetails1(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		String hinNo = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}
		dataMap.put("hinNo", hinNo);
		map = enquiryHandlerService.showPatientDetails(dataMap);
		String jsp = "patientAndAdDetails1"+ ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	

	// -----------------------------------------------------------------------------------------------------------
	public EnquiryHandlerService getEnquiryHandlerService() {
		return enquiryHandlerService;
	}

	public void setEnquiryHandlerService(
			EnquiryHandlerService enquiryHandlerService) {
		this.enquiryHandlerService = enquiryHandlerService;
	}

}
