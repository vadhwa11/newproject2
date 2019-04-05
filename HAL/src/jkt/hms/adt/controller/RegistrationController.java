/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class RegistrationController.java 
 * Purpose of the class - This is for Registration, Visit Module. 
 * It contains Registration and Visit of the patient. 
 * @author  Ritu Sahu 
 * Create Date: 3rd Jan,2008   
 * Revision Date:      
 * Revision By: Purpose
 * @version 1.0  
 **/
package jkt.hms.adt.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.adt.handler.RegistrationHandlerService;
import jkt.hms.masters.business.AppPatientAppointments;
import jkt.hms.masters.business.AvPilotRegistrationDt;
import jkt.hms.masters.business.Category;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasComplaint;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiagnosisConclusion;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasImmunization;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasMedicalExamFamilyHis;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasOthersCategory;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasSection;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStation;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.UserButtonRights;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.opd.handler.OPDHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.LDAPAuthAndSearch;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.io.FileUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.lowagie.text.pdf.codec.Base64.OutputStream;

public class RegistrationController extends MultiActionController {

	RegistrationHandlerService registrationHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	OPDHandlerService opdHandlerService = null;

	public OPDHandlerService getOpdHandlerService() {
		return opdHandlerService;
	}

	public void setOpdHandlerService(OPDHandlerService opdHandlerService) {
		this.opdHandlerService = opdHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	/**
	 * ----------------------------------- Patient Registration Related
	 * Method----------------------------
	 */

	public ModelAndView showRegistrationJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.showRegistrationJsp(hospitalId);
		// StringBuffer jsp = new StringBuffer(REGISTRATION_JSP);
		String jsp = REGISTRATION_JSP + ".jsp";
		// jsp.append(".jsp");
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * submitPatientInformation(HttpServletRequest request, HttpServletResponse
	 * response) { Map<String, Object> map = new HashMap<String, Object>();
	 * Map<String, Object> dataMap = new HashMap<String, Object>(); HttpSession
	 * session = request.getSession(); Patient patient = new Patient(); Visit
	 * visit = new Visit(); int servicePersonRelationId = 0; int serTypeId = 0;
	 * String hinNo = ""; String serviceNo = ""; Map<String, Object> objectMap =
	 * new HashMap<String, Object>();
	 * 
	 * Users user = (Users) session.getAttribute("users"); int userId =
	 * user.getId(); Users userObj = new Users(); userObj.setId(userId);
	 * patient.setAddEditBy(user);
	 * 
	 * if (request.getParameter(HIN_NO) != null) { hinNo =
	 * request.getParameter(HIN_NO); patient.setHinNo(hinNo); } if
	 * (request.getParameter(SERVICE_NO) != null) { serviceNo =
	 * request.getParameter(SERVICE_NO); patient.setServiceNo(serviceNo.trim());
	 * 
	 * } MasServiceType masServiceType = new MasServiceType(); serTypeId =
	 * Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
	 * masServiceType.setId
	 * (Integer.parseInt(request.getParameter(SERVICE_TYPE_ID)));
	 * patient.setServiceType(masServiceType);
	 * 
	 * String suffix = ""; if (request.getParameter(SUFFIX) != null&&
	 * !request.getParameter(SUFFIX).equals("")) { suffix =
	 * request.getParameter(SUFFIX); } patient.setSuffix(suffix);
	 * 
	 * 
	 * if (request.getParameter("echs") != null) { String echs =
	 * request.getParameter("echs"); patient.setEchsNo(echs); } String prefix =
	 * ""; if (request.getParameter(PREFIX) != null &&
	 * !request.getParameter(PREFIX).equals("")) { prefix =
	 * request.getParameter(PREFIX); } patient.setPrefix(prefix.trim());
	 * 
	 * int serviceStatusId = 0; if (request.getParameter(SERVICE_STATUS_ID) !=
	 * null && !request.getParameter(SERVICE_STATUS_ID).equals("0")) {
	 * serviceStatusId = Integer.parseInt(request
	 * .getParameter(SERVICE_STATUS_ID)); MasServiceStatus masServiceStatus =
	 * new MasServiceStatus(); masServiceStatus.setId(serviceStatusId);
	 * patient.setServiceStatus(masServiceStatus); }
	 * 
	 * if (serTypeId == 7) { MasRelation masRelation = new MasRelation();
	 * masRelation.setId(8); patient.setRelation(masRelation);
	 * patient.setRank(new MasRank(179)); patient.setUnit(new MasUnit(257)); }
	 * else { if (request.getParameter(SERVICE_PERSONNEL_RELATION_ID) != null &&
	 * !request.getParameter(SERVICE_PERSONNEL_RELATION_ID).equals("0")) {
	 * servicePersonRelationId =
	 * Integer.parseInt(request.getParameter(SERVICE_PERSONNEL_RELATION_ID));
	 * MasRelation masRelation = new MasRelation();
	 * masRelation.setId(servicePersonRelationId);
	 * patient.setRelation(masRelation); } }
	 * 
	 * if (request.getParameter(RANK_ID) != null &&
	 * !request.getParameter(RANK_ID).equals("0")) { int rankId =
	 * Integer.parseInt(request.getParameter(RANK_ID)); MasRank masRank = new
	 * MasRank(); masRank.setId(rankId); patient.setRank(masRank); }
	 * if(request.getParameter(S_FIRST_NAME) != null)
	 * patient.setSFirstName((request
	 * .getParameter(S_FIRST_NAME).trim()).toUpperCase()); if
	 * (request.getParameter(S_MIDDLE_NAME) != null) {
	 * patient.setSMiddleName((request
	 * .getParameter(S_MIDDLE_NAME).trim()).toUpperCase()); } if
	 * (request.getParameter(S_LAST_NAME) != null) {
	 * patient.setSLastName((request
	 * .getParameter(S_LAST_NAME).trim()).toUpperCase()); }
	 * 
	 * if (request.getParameter(TRADE_ID) != null &&
	 * !request.getParameter(TRADE_ID).equals("0")) {
	 * if(!request.getParameter(TRADE_ID).equals("other")){ int tradeId =
	 * Integer.parseInt(request.getParameter(TRADE_ID)); MasTrade masTrade = new
	 * MasTrade(); masTrade.setId(tradeId); patient.setTrade(masTrade); } else
	 * if (request.getParameter(TRADE_NAME)!= null &&
	 * !request.getParameter(TRADE_NAME).equals("")) { MasTrade masTradeObj =
	 * new MasTrade();
	 * 
	 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 = new
	 * StringTokenizer(request .getParameter(TRADE_NAME) + "", "\'");
	 * 
	 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
	 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
	 * 
	 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 = new
	 * StringTokenizer(output_str1 + "", "\"");
	 * 
	 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
	 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
	 * 
	 * masTradeObj .setTradeName("" + output_str2); // patient.setTradeName("" +
	 * output_str2);
	 * 
	 * if (request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))) { masTradeObj
	 * .setLastChgBy(request.getParameter(CHANGED_BY)); }
	 * 
	 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
	 * .getParameter(CHANGED_DATE)); masTradeObj.setLastChgDate(changedDate);
	 * masTradeObj.setLastChgTime(request.getParameter(CHANGED_TIME));
	 * masTradeObj.setStatus("n");
	 * 
	 * objectMap.put("masTradeObj", masTradeObj ); } } if
	 * (!request.getParameter(TITLE).equals("0")) { int titleId =
	 * Integer.parseInt(request.getParameter(TITLE)); MasTitle masTitle = new
	 * MasTitle(); masTitle.setId(titleId); patient.setTitle(masTitle); }
	 * patient
	 * .setPFirstName((request.getParameter(P_FIRST_NAME).trim()).toUpperCase
	 * ()); if (request.getParameter(P_MIDDLE_NAME) != null) {
	 * patient.setPMiddleName
	 * ((request.getParameter(P_MIDDLE_NAME).trim()).toUpperCase()); } if
	 * (request.getParameter(P_LAST_NAME) != null) {
	 * patient.setPLastName((request
	 * .getParameter(P_LAST_NAME).trim()).toUpperCase()); } if
	 * (!request.getParameter(GENDER).equals("0")) { int genderId =
	 * Integer.parseInt(request.getParameter(GENDER)); MasAdministrativeSex
	 * masAdministrativeSex = new MasAdministrativeSex();
	 * masAdministrativeSex.setId(genderId);
	 * patient.setSex(masAdministrativeSex); } String age = ""; if
	 * (request.getParameter(AGE) != null) { if (request.getParameter(AGE_UNIT)
	 * != null) { String ageUnit = request.getParameter(AGE_UNIT); age =
	 * request.getParameter(AGE).concat(" ").concat(ageUnit);
	 * patient.setAge(age); } } if (request.getParameter("ageLabel") != null &&
	 * !(request.getParameter("ageLabel").equals(""))) { age =
	 * request.getParameter("ageLabel"); patient.setAge(age); } if
	 * (request.getParameter(DATE_OF_BIRTH) != null &&
	 * !(request.getParameter(DATE_OF_BIRTH).equals(""))) { Date dateOfBirth =
	 * HMSUtil.dateFormatterDDMMYYYY(request .getParameter(DATE_OF_BIRTH));
	 * patient.setDateOfBirth(dateOfBirth); }
	 * 
	 * if (request.getParameter(RELIGION_ID) != null &&
	 * !request.getParameter(RELIGION_ID).equals("0")) { int religionId =
	 * Integer.parseInt(request.getParameter(RELIGION_ID)); MasReligion
	 * masReligion = new MasReligion(); masReligion.setId(religionId);
	 * patient.setReligion(masReligion); } if
	 * (request.getParameter(MARITAL_STATUS_ID) != null &&
	 * !request.getParameter(MARITAL_STATUS_ID).equals("0")) { int
	 * maritalStatusId = Integer.parseInt(request
	 * .getParameter(MARITAL_STATUS_ID)); MasMaritalStatus masMaritalStatus =
	 * new MasMaritalStatus(); masMaritalStatus.setId(maritalStatusId);
	 * patient.setMaritalStatus(masMaritalStatus);
	 * objectMap.put("ptMaritalStatus", masMaritalStatus); } if
	 * (request.getParameter(OCCUPATION_ID) != null &&
	 * !request.getParameter(OCCUPATION_ID).equals("0")) { int occupationId =
	 * Integer.parseInt(request .getParameter(OCCUPATION_ID)); MasOccupation
	 * masOccupation = new MasOccupation(); masOccupation.setId(occupationId);
	 * patient.setOccupation(masOccupation); } if
	 * (request.getParameter(BLOOD_GROUP_ID) != null &&
	 * !request.getParameter(BLOOD_GROUP_ID).equals("0")) { int bloodGroupId =
	 * Integer.parseInt(request .getParameter(BLOOD_GROUP_ID)); MasBloodGroup
	 * masBloodGroup = new MasBloodGroup(); masBloodGroup.setId(bloodGroupId);
	 * patient.setBloodGroup(masBloodGroup); objectMap.put("ptBloodGroup",
	 * masBloodGroup); }
	 * 
	 * if (request.getParameter(DISTRICT) != null &&
	 * !request.getParameter(DISTRICT).equals("0")) { int districtId =
	 * Integer.parseInt(request.getParameter(DISTRICT)); MasDistrict masDistrict
	 * = new MasDistrict(); masDistrict.setId(districtId);
	 * patient.setDistrict(masDistrict); } if (request.getParameter(ADDRESS) !=
	 * null) { patient.setAddress(request.getParameter(ADDRESS)); } if
	 * (request.getParameter(PATIENT_DISTRICT) != null) {
	 * patient.setPatientDistrict(request.getParameter(PATIENT_DISTRICT)); }
	 * 
	 * if (!request.getParameter(BLOCK).equals("0")) { int blockId =
	 * Integer.parseInt(request.getParameter(BLOCK)); MasBlock masBlock = new
	 * MasBlock(); masBlock.setId(blockId); patient.setBlock(masBlock); } if
	 * (request.getParameter(PINCODE) != null) {
	 * patient.setPinCode(request.getParameter(PINCODE)); }
	 * 
	 * if (request.getParameter(POST_OFFICE) != null) {
	 * patient.setPostOffice(request.getParameter(POST_OFFICE)); }
	 * 
	 * int countryId = Integer.parseInt(request.getParameter(NATIONALITY));
	 * MasCountry masCountry = new MasCountry(); masCountry.setId(countryId);
	 * patient.setCountry(masCountry); if(request.getParameter(STATE) != null &&
	 * !request.getParameter(STATE).equals("0")){ int stateId =
	 * Integer.parseInt(request.getParameter(STATE)); MasState masState = new
	 * MasState(); masState.setId(stateId); patient.setState(masState); }
	 * 
	 * if (request.getParameter(TELEPHONE_NO) != null) {
	 * patient.setPhoneNumber(request.getParameter(TELEPHONE_NO));
	 * objectMap.put("telephoneNo", request.getParameter(TELEPHONE_NO)); } if
	 * (request.getParameter(MOBILE_NO) != null) {
	 * patient.setMobileNumber(request.getParameter(MOBILE_NO));
	 * objectMap.put("mobileNo", request.getParameter(MOBILE_NO)); } if
	 * (request.getParameter("afnetNo") != null) {
	 * patient.setAfnetNo(request.getParameter("afnetNo"));
	 * objectMap.put("afnetNo", request.getParameter("afnetNo")); } if
	 * (request.getParameter(EMAIL_ID) != null) {
	 * patient.setEmailId(request.getParameter(EMAIL_ID)); }
	 * 
	 * if (request.getParameter(RELATIVE_NAME) != null) {
	 * patient.setNextOfKinName(request.getParameter(RELATIVE_NAME)); }
	 * 
	 * // patient.setNewStatus("P"); if (request.getParameter(CONTACT_NUMBER) !=
	 * null) { patient.setContactNo(request.getParameter(CONTACT_NUMBER));
	 * objectMap.put("contactNo", request.getParameter(CONTACT_NUMBER)); } if
	 * (request.getParameter(RELATION_ID) != null &&
	 * !request.getParameter(RELATION_ID).equals("0")) {
	 * 
	 * int relationId = Integer .parseInt(request.getParameter(RELATION_ID));
	 * MasRelation masRelationObj = new MasRelation();
	 * masRelationObj.setId(relationId); patient.setRelation(masRelationObj); }
	 * if (request.getParameter(EMERGENCY_ADDRESS) != null) { patient
	 * .setNextOfKinAddress(request .getParameter(EMERGENCY_ADDRESS)); }
	 * 
	 * if (request.getParameter(EMERGENCY_PHONE) != null) {
	 * patient.setNextOfKinPhoneNumber(request .getParameter(EMERGENCY_PHONE));
	 * }
	 * 
	 * if (request.getParameter(RECORD_OFFICE_ADDRESS_ID) != null &&
	 * !request.getParameter(RECORD_OFFICE_ADDRESS_ID).equals("0")) { int
	 * recordOfficeAddId = Integer.parseInt(request
	 * .getParameter(RECORD_OFFICE_ADDRESS_ID)); MasRecordOfficeAddress
	 * masRecordOfficeAddress = new MasRecordOfficeAddress();
	 * masRecordOfficeAddress.setId(recordOfficeAddId);
	 * patient.setRecordOfficeAddress(masRecordOfficeAddress); } if
	 * (request.getParameter(UNIT_ID) != null &&
	 * !request.getParameter(UNIT_ID).equals("0")) {
	 * if(!request.getParameter(UNIT_ID).equals("other")){ int unitId =
	 * Integer.parseInt(request.getParameter(UNIT_ID)); MasUnit masUnit = new
	 * MasUnit(); masUnit.setId(unitId); patient.setUnit(masUnit); } else if
	 * (request.getParameter(UNIT_NAME)!=null &&
	 * !request.getParameter(UNIT_NAME).equals("")) { MasUnit masUnitObj = new
	 * MasUnit(); if (request.getParameter(UNIT_NAME) != null) {
	 * 
	 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 = new
	 * StringTokenizer(request .getParameter(UNIT_NAME) + "", "\'");
	 * 
	 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
	 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
	 * 
	 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 = new
	 * StringTokenizer(output_str1 + "", "\"");
	 * 
	 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
	 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
	 * 
	 * masUnitObj.setUnitName("" + output_str2); } if
	 * (request.getParameter(UNIT_ADDRESS) != null) {
	 * 
	 * StringBuffer output_str3 = new StringBuffer(); StringTokenizer s3 = new
	 * StringTokenizer(request .getParameter(UNIT_ADDRESS) + "", "\'");
	 * 
	 * while (s3.hasMoreTokens()) { output_str3.append(s3.nextToken()); if
	 * (s3.hasMoreTokens()) { output_str3.append(" "); } }
	 * 
	 * StringBuffer output_str4 = new StringBuffer(); StringTokenizer s4 = new
	 * StringTokenizer(output_str3 + "", "\"");
	 * 
	 * while (s4.hasMoreTokens()) { output_str4.append(s4.nextToken()); if
	 * (s4.hasMoreTokens()) { output_str4.append(" "); } }
	 * masUnitObj.setUnitAddress("" + output_str4); }
	 * 
	 * if (request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))) {
	 * masUnitObj.setLastChgBy(request.getParameter(CHANGED_BY)); } if
	 * (request.getParameter(LOCAL_UNIT) != null) {
	 * masUnitObj.setLocalUnit("y"); } else { masUnitObj.setLocalUnit("n"); }
	 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
	 * .getParameter(CHANGED_DATE)); masUnitObj.setLastChgDate(changedDate);
	 * masUnitObj.setLastChgTime(request.getParameter(CHANGED_TIME));
	 * masUnitObj.setStatus("n"); objectMap.put("masUnitObj", masUnitObj); } }
	 * 
	 * if(serviceStatusId == 2){ MasUnit masUnit = new MasUnit();
	 * masUnit.setId(257); patient.setUnit(masUnit); }
	 * 
	 * if (request.getParameter(FORMATION_ID) != null) {
	 * patient.setFormation(request.getParameter(FORMATION_ID)); }
	 * 
	 * if (request.getParameter(TOTAL_SERVICE) != null &&
	 * !request.getParameter(TOTAL_SERVICE).equals("")) {
	 * patient.setServiceYears(Float.parseFloat(request
	 * .getParameter(TOTAL_SERVICE))); } if
	 * (request.getParameter(TOTAL_SERVICE_PERIOD) != null &&
	 * !request.getParameter(TOTAL_SERVICE_PERIOD).equals("")) {
	 * patient.setTotalServicePeriod(request
	 * .getParameter(TOTAL_SERVICE_PERIOD)); } if (request.getParameter(STATION)
	 * != null && !request.getParameter(STATION).equals("")) { if(
	 * !request.getParameter(STATION).equals("other")){
	 * patient.setStation(request.getParameter(STATION)); }else
	 * if(request.getParameter("stationName") != null){
	 * patient.setStation(request.getParameter("stationName"));
	 * 
	 * MasStation masStation = new MasStation();
	 * 
	 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 = new
	 * StringTokenizer(request .getParameter("stationName") + "", "\'");
	 * 
	 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
	 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
	 * 
	 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 = new
	 * StringTokenizer(output_str1 + "", "\"");
	 * 
	 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
	 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
	 * 
	 * masStation.setStationName("" + output_str2);
	 * masStation.setStationCode(output_str2.substring(0, 3)); //
	 * patient.setTradeName("" + output_str2);
	 * 
	 * if (request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))) { masStation
	 * .setLastChgBy(user); }
	 * 
	 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
	 * .getParameter(CHANGED_DATE)); masStation.setLastChgDate(changedDate);
	 * masStation.setLastChgTime(request.getParameter(CHANGED_TIME));
	 * masStation.setStatus("y");
	 * 
	 * objectMap.put("masStation", masStation );
	 * 
	 * } }
	 * 
	 * if (request.getParameter(CDA_ACCOUNT_NO) != null) {
	 * patient.setCdaAccountNo(request.getParameter(CDA_ACCOUNT_NO)); } if
	 * (request.getParameter(REFERENCE) != null &&
	 * !request.getParameter(REFERENCE).equals("0")) { int referenceId =
	 * Integer.parseInt(request.getParameter(REFERENCE)); MasReference
	 * masReference = new MasReference(); masReference.setId(referenceId);
	 * patient.setReference(masReference); } if (request.getParameter(REMARKS)
	 * != null) { patient.setRemarks(request.getParameter(REMARKS)); }
	 * 
	 * //int complaintId = 0;
	 * 
	 * if(!request.getParameter(COMPLAINT_ID).equals("0")) { complaintId =
	 * Integer.parseInt(request.getParameter(COMPLAINT_ID)); MasComplaint
	 * masComplaint = new MasComplaint(); masComplaint.setId(complaintId);
	 * visit.setComplaint(masComplaint); }
	 * 
	 * 
	 * int patientDepartmentId = 0; if (request.getParameter(PATIENT_DEPARTMENT)
	 * != null && !request.getParameter(PATIENT_DEPARTMENT).equals("0")) {
	 * patientDepartmentId = Integer.parseInt(request
	 * .getParameter(PATIENT_DEPARTMENT)); MasDepartment masDepartment = new
	 * MasDepartment(); masDepartment.setId(patientDepartmentId);
	 * visit.setDepartment(masDepartment); }
	 * 
	 * if (request.getParameter(DEPARTMENT_ID) != null &&
	 * !request.getParameter(DEPARTMENT_ID).equals("0")) { MasDepartment
	 * masDepartment = new MasDepartment();
	 * masDepartment.setId(Integer.parseInt(
	 * request.getParameter(DEPARTMENT_ID)));
	 * visit.setDepartment(masDepartment); } int consultingDoctorId = 0; if
	 * (request.getParameter(CONSULTING_DOCTOR) != null &&
	 * !request.getParameter(CONSULTING_DOCTOR).equals("0")) {
	 * consultingDoctorId = Integer.parseInt(request
	 * .getParameter(CONSULTING_DOCTOR)); MasEmployee consultingDoctorObj = new
	 * MasEmployee(); consultingDoctorObj.setId(consultingDoctorId);
	 * visit.setDoctor(consultingDoctorObj); } int caseTypeId = 0; if
	 * (request.getParameter(CASE_TYPE_ID)!=null &&
	 * !request.getParameter(CASE_TYPE_ID).equals("0")) { caseTypeId =
	 * Integer.parseInt(request.getParameter(CASE_TYPE_ID)); MasCaseType
	 * masCaseType = new MasCaseType(); masCaseType.setId(caseTypeId);
	 * visit.setCaseType(masCaseType); } int diagnosisId = 0;
	 * 
	 * if (request.getParameter(COMPLAINT_ID) != null &&
	 * !(request.getParameter(COMPLAINT_ID).equals(""))) { String complaint =
	 * request.getParameter(COMPLAINT_ID); visit.setComplaintString(complaint);
	 * }
	 * 
	 * 
	 * if(!(request.getParameter(COMPLAINT_ID).equals("0"))){ int complaintId =
	 * Integer.parseInt(request.getParameter(COMPLAINT_ID)); MasComplaint
	 * masComplaint = new MasComplaint(); masComplaint.setId(complaintId);
	 * visit.setComplaint(masComplaint); }
	 * 
	 * 
	 * if (request.getParameter(DIAGNOSIS_ID) != null &&
	 * !(request.getParameter(DIAGNOSIS_ID).equals(""))) { String diagnosis =
	 * request.getParameter(DIAGNOSIS_ID); visit.setDiagnosisString(diagnosis);
	 * }
	 * 
	 * 
	 * if(!request.getParameter(DIAGNOSIS_ID).equals("0")){ diagnosisId =
	 * Integer.parseInt(request.getParameter(DIAGNOSIS_ID));
	 * MasDiagnosisConclusion masDiagnosisConclusion = new
	 * MasDiagnosisConclusion(); masDiagnosisConclusion.setId(diagnosisId);
	 * visit.setDiagnosis(masDiagnosisConclusion); }
	 * 
	 * int disposalId = 0; if (request.getParameter(DISPOSAL_ID) != null &&
	 * !request.getParameter(DISPOSAL_ID).equals("0")) { disposalId =
	 * Integer.parseInt(request.getParameter(DISPOSAL_ID)); MasDisposal
	 * masDisposal = new MasDisposal(); masDisposal.setId(disposalId);
	 * visit.setDisposal(masDisposal); } if
	 * (request.getParameter(HOSPITAL_STAFF) != null) {
	 * visit.setHospitalStaff(request.getParameter(HOSPITAL_STAFF)); } else {
	 * visit.setHospitalStaff("n"); }
	 * 
	 * if (request.getParameter(TOKEN_NO) != null &&
	 * !(request.getParameter(TOKEN_NO).equals(""))) {
	 * visit.setTokenNo(Integer.parseInt(request.getParameter(TOKEN_NO))); }
	 * Date addEditDate = null; if (request.getParameter(CHANGED_DATE) != null)
	 * { addEditDate = HMSUtil.convertStringTypeDateToDateType(request
	 * .getParameter(CHANGED_DATE)); patient.setAddEditDate(addEditDate); }
	 * 
	 * String addEditTime = ""; if (request.getParameter(CHANGED_TIME) != null)
	 * { addEditTime = request.getParameter(CHANGED_TIME);
	 * patient.setAddEditTime(addEditTime); } if
	 * (request.getParameter(POLICE_STATION) != null) {
	 * patient.setPoliceStation(request.getParameter(POLICE_STATION)); } if
	 * (request.getParameter(I_CARD_VALIDITY_DATE) != null &&
	 * !(request.getParameter(I_CARD_VALIDITY_DATE).equals(""))) {
	 * patient.setServiceCardValidityDate(HMSUtil
	 * .convertStringTypeDateToDateType(request
	 * .getParameter(I_CARD_VALIDITY_DATE))); } if
	 * (request.getParameter(DEPENDENT_CARD_ISSUE_DATE) != null &&
	 * !(request.getParameter(DEPENDENT_CARD_ISSUE_DATE).equals(""))) {
	 * patient.setDependentCardIssueDate(HMSUtil
	 * .convertStringTypeDateToDateType(request
	 * .getParameter(DEPENDENT_CARD_ISSUE_DATE))); } if
	 * (request.getParameter(I_CARD_VERIFIED) != null) {
	 * patient.setServiceCardStatus(request.getParameter(I_CARD_VERIFIED)); }
	 * else { patient.setServiceCardStatus("n"); } if
	 * (request.getParameter(MOTHER_HIN_NO) != null) {
	 * patient.setMotherHinNo(request.getParameter(MOTHER_HIN_NO)); } Date
	 * regDate = null; if (request.getParameter(REG_DATE) != null) { regDate =
	 * HMSUtil.convertStringTypeDateToDateType(request .getParameter(REG_DATE));
	 * patient.setRegDate(regDate); } String regTime = ""; if
	 * (request.getParameter(REG_TIME) != null) { regTime =
	 * request.getParameter(REG_TIME); patient.setRegTime(regTime); } String
	 * adPro = "No";
	 * 
	 * if (request.getParameter("AdPro") != null) { adPro =
	 * request.getParameter("AdPro"); } if(request.getParameter(SR_SEX) != null
	 * && !(request.getParameter(SR_SEX).equals("0"))){ MasAdministrativeSex
	 * admsex = new MasAdministrativeSex();
	 * admsex.setId(Integer.parseInt(request.getParameter(SR_SEX)));
	 * patient.setSrSex(admsex); }
	 * 
	 * if (request.getParameter(SR_AGE) != null) { if
	 * (request.getParameter(SR_AGE_UNIT) != null) { String ageUnit =
	 * request.getParameter(SR_AGE_UNIT); String srage =
	 * request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
	 * patient.setSrAge(srage); } } if(request.getParameter(SR_DOB) != null &&
	 * !(request.getParameter(SR_DOB).equals(""))){
	 * patient.setSrDob(HMSUtil.convertStringTypeDateToDateType
	 * (request.getParameter(SR_DOB))); } if(request.getParameter(COMMAND) !=
	 * null && !(request.getParameter(COMMAND).equals("0"))){
	 * if(!(request.getParameter(COMMAND).equals("other"))){ MasCommand command
	 * = new MasCommand();
	 * command.setId(Integer.parseInt(request.getParameter(COMMAND)));
	 * patient.setCommand(command); }else if
	 * (request.getParameter("commandName")!= null &&
	 * !request.getParameter("commandName").equals("")) { MasCommand masCommand
	 * = new MasCommand();
	 * 
	 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 = new
	 * StringTokenizer(request.getParameter("commandName") + "", "\'");
	 * 
	 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
	 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
	 * 
	 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 = new
	 * StringTokenizer(output_str1 + "", "\"");
	 * 
	 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
	 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
	 * 
	 * masCommand.setCommandName("" + output_str2);
	 * masCommand.setCommandCode(output_str2.substring(0, 3));
	 * 
	 * if (request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))) {
	 * masCommand.setLastChgBy(user); }
	 * 
	 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
	 * .getParameter(CHANGED_DATE)); masCommand.setLastChgDate(changedDate);
	 * masCommand.setLastChgTime(request.getParameter(CHANGED_TIME));
	 * masCommand.setStatus("n");
	 * 
	 * objectMap.put("masCommand", masCommand ); } }
	 * 
	 * int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID); MasHospital
	 * masHospital = new MasHospital(); masHospital.setId(hospitalId);
	 * 
	 * if(request.getParameter("commissionDate") != null &&
	 * !(request.getParameter("commissionDate").equals(""))){
	 * patient.setCommissionDate
	 * (HMSUtil.convertStringTypeDateToDateType(request.
	 * getParameter("commissionDate"))); }
	 * if(request.getParameter("srMaritalStatus") != null &&
	 * !(request.getParameter("srMaritalStatus").equals("0"))){ MasMaritalStatus
	 * maritalStatus = new MasMaritalStatus();
	 * maritalStatus.setId(Integer.parseInt
	 * (request.getParameter("srMaritalStatus")));
	 * patient.setSrMaritalStatus(maritalStatus); objectMap.put("maritalStatus",
	 * maritalStatus); } if(request.getParameter(SECTION_ID) != null &&
	 * !(request.getParameter(SECTION_ID).equals("0"))){
	 * if(!(request.getParameter(SECTION_ID).equals("other"))){ MasSection
	 * section = new MasSection();
	 * section.setId(Integer.parseInt(request.getParameter(SECTION_ID)));
	 * patient.setSection(section); objectMap.put("section", section); }else if
	 * (request.getParameter("sectionName")!= null &&
	 * !request.getParameter("sectionName").equals("")) { MasSection masSection
	 * = new MasSection();
	 * 
	 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 = new
	 * StringTokenizer(request.getParameter("sectionName") + "", "\'");
	 * 
	 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
	 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
	 * 
	 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 = new
	 * StringTokenizer(output_str1 + "", "\"");
	 * 
	 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
	 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
	 * 
	 * masSection.setSectionName("" + output_str2);
	 * masSection.setSectionCode(output_str2.substring(0, 3));
	 * 
	 * if (request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))) {
	 * masSection.setLastChgBy(user); }
	 * 
	 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
	 * .getParameter(CHANGED_DATE)); masSection.setLastChgDate(changedDate);
	 * masSection.setLastChgTime(request.getParameter(CHANGED_TIME));
	 * masSection.setStatus("n"); masSection.setHospital(masHospital);
	 * 
	 * objectMap.put("masSection", masSection ); } } if
	 * (request.getParameter(SERV_BLD_GROUP) != null &&
	 * !request.getParameter(SERV_BLD_GROUP).equals("0")) { int bldGrpId =
	 * Integer.parseInt(request .getParameter(SERV_BLD_GROUP)); MasBloodGroup
	 * masBloodGroup = new MasBloodGroup(); masBloodGroup.setId(bldGrpId);
	 * patient.setSrBloodGroup(masBloodGroup); objectMap.put("masBloodGroup",
	 * masBloodGroup ); }
	 * 
	 * if(request.getParameter("income") != null){
	 * patient.setIncome(request.getParameter("income")); }
	 * 
	 * if(request.getParameter("dependencyDate") != null &&
	 * !(request.getParameter("dependencyDate").equals(""))){
	 * patient.setDependencyDate
	 * (HMSUtil.convertStringTypeDateToDateType(request.
	 * getParameter("dependencyDate"))); } if(request.getParameter("authority")
	 * != null ){ patient.setAuthority(request.getParameter("authority")); }
	 * if(request.getParameter("dependencyRemovalDate") != null &&
	 * !(request.getParameter("dependencyRemovalDate").equals(""))){
	 * patient.setDependencyRemovalDate
	 * (HMSUtil.convertStringTypeDateToDateType(request
	 * .getParameter("dependencyRemovalDate"))); }
	 *//**
	 * @Date 24 Aug 2011
	 */
	/*
	 * if(request.getParameter(PERMANENT_ADDRESS) != null ){
	 * patient.setPermanentAddress(request.getParameter(PERMANENT_ADDRESS)); }
	 * if(request.getParameter("phoneNoRes") != null ){
	 * patient.setTelephoneResi(request.getParameter("phoneNoRes")); }
	 * if(request.getParameter("permCityId") != null &&
	 * !request.getParameter("permCityId").equals("0")){ MasDistrict district =
	 * new MasDistrict();
	 * district.setId(Integer.parseInt(request.getParameter("permCityId")));
	 * patient.setPermanentCity(district); }
	 * if(request.getParameter("drugAllergies") != null ){
	 * patient.setDrugAllergies(request.getParameter("drugAllergies")); }
	 * if(request.getParameter("smoker") != null ){ patient.setSmoker("y");
	 * }else{ patient.setSmoker("n"); } if(request.getParameter("alcohol") !=
	 * null ){ patient.setAlcohol("y"); }else{ patient.setAlcohol("n"); }
	 * if(request.getParameter(NEXT_OF_KIN_NAME) != null){
	 * patient.setNextOfKinName(request.getParameter(NEXT_OF_KIN_NAME)); }
	 * 
	 * if(request.getParameter(NEXT_OF_KIN_PHONE_NO) != null){
	 * patient.setNextOfKinPhoneNumber
	 * (request.getParameter(NEXT_OF_KIN_PHONE_NO)); }
	 * if(request.getParameter(NEXT_OF_KIN_RELATION_ID) != null &&
	 * !request.getParameter(NEXT_OF_KIN_RELATION_ID).equals("0")){ int
	 * nextOfKinRelationId =
	 * Integer.parseInt(request.getParameter(NEXT_OF_KIN_RELATION_ID));
	 * MasRelation relation = new MasRelation();
	 * relation.setId(nextOfKinRelationId);
	 * patient.setNextOfKinRelation(relation); }
	 * patient.setHospital(masHospital); patient.setStatus("y");
	 * patient.setPatientStatus("Out Patient"); patient.setInpatientNo(0);
	 * if(request.getParameter("img1") != null &&
	 * !request.getParameter("img1").equals("")){ map.put("img1",
	 * request.getParameter("img1")); } map.put("regFlag", "reg"); if
	 * (patientDepartmentId != 0 || complaintId != 0 || diagnosisId != 0 ||
	 * disposalId != 0 || consultingDoctorId != 0 || caseTypeId != 0 ||
	 * request.getParameter(HOSPITAL_STAFF) != null) { // if(consultingDoctorId
	 * != 0){ if(request.getParameter(VISIT_NUMBER) != null &&
	 * !request.getParameter(VISIT_NUMBER).equals("")){
	 * visit.setVisitNo(Integer.parseInt(request.getParameter(VISIT_NUMBER)));
	 * patient
	 * .setCurrentVisitNo(Integer.parseInt(request.getParameter(VISIT_NUMBER)));
	 * objectMap
	 * .put("currentVisitNo",Integer.parseInt(request.getParameter(VISIT_NUMBER
	 * ))); }else{ visit.setVisitNo(1); patient.setCurrentVisitNo(1);
	 * objectMap.put("currentVisitNo",1); }
	 * 
	 * if (request.getParameter(REPORTING_FOR) != null &&
	 * !request.getParameter(REPORTING_FOR).equals("0")) { int reportingFor =
	 * Integer.parseInt(request .getParameter(REPORTING_FOR)); MasReporting
	 * reporting = new MasReporting(); reporting.setId(reportingFor);
	 * visit.setReportingFor(reporting); } visit.setHospital(masHospital);
	 * visit.setAddEditBy(user); visit.setAge(age);
	 * visit.setVisitDate(addEditDate); visit.setAddEditDate(addEditDate);
	 * visit.setAddEditTime(addEditTime); visit.setVisitTime(addEditTime);
	 * visit.setVisitDate(regDate); visit.setVisitTime(regTime);
	 * 
	 * visit.setStatus("y"); visit.setEdStatus("n");
	 * 
	 * visit.setAppointmentType("D"); if(request.getParameter("medExamCategory")
	 * != null && !(request.getParameter("medExamCategory")).equals("")){
	 * visit.setMedExamType(request.getParameter("medExamCategory"));
	 * visit.setVisitStatus("c"); visit.setMedStatus("w"); }else
	 * if(request.getParameter("medBoardCategory") != null &&
	 * !(request.getParameter("medBoardCategory")).equals("")){
	 * visit.setMedExamType(request.getParameter("medBoardCategory"));
	 * visit.setMedStatus("w"); visit.setVisitStatus("c"); }else{
	 * 
	 * visit.setVisitStatus("w"); }
	 * 
	 * objectMap.put("visit", visit); //}
	 * 
	 * 
	 * if(request.getParameter("regHinId") != null &&
	 * !request.getParameter("regHinId").equals("0")){ objectMap.put("regHinId",
	 * Integer.parseInt(request.getParameter("regHinId"))); }else
	 * if(request.getParameter("selfRegHin") != null &&
	 * !request.getParameter("selfRegHin").equals("")){
	 * objectMap.put("selfRegHin"
	 * ,Integer.parseInt(request.getParameter("selfRegHin"))); }
	 * 
	 * objectMap.put("hinNo", hinNo); objectMap.put("patient", patient); Box box
	 * = HMSUtil.getBox(request); objectMap.put("box", box);
	 * 
	 * Map<String, Object> detailsMap = new HashMap<String, Object>(); Boolean
	 * successfullyAdded = false; List<Patient> existingHinNoList = new
	 * ArrayList<Patient>(); List<Visit> visitList = new ArrayList<Visit>();
	 * 
	 * detailsMap = registrationHandlerService
	 * .submitPatientInformation(objectMap); if (detailsMap.get("visitList") !=
	 * null) { visitList = (List<Visit>) detailsMap.get("visitList");
	 * map.put("visitList", visitList); }
	 * 
	 * if (detailsMap.get("existingHinNoList") != null) { existingHinNoList =
	 * (List<Patient>) detailsMap .get("existingHinNoList"); } if
	 * (detailsMap.get("succesfullyAdded") != null) { successfullyAdded =
	 * (Boolean) detailsMap.get("succesfullyAdded"); } String message; if
	 * (successfullyAdded == true && existingHinNoList.size() == 0) {
	 * if(request.getParameter(HIN_NO) == null ||
	 * request.getParameter(HIN_NO).equals("")){
	 * //if(request.getParameter("regHinId") != null &&
	 * !request.getParameter("regHinId").equals("0")){
	 * if(request.getParameter("selfHinNo") != null &&
	 * !request.getParameter("selfHinNo").equals("")){ map.put("hinNo",
	 * request.getParameter("selfHinNo")); } message =
	 * " Visit Information saved Successfully."; map.put("regHinId",
	 * request.getParameter("regHinId")); }else{ message =
	 * " Registration Information saved Successfully. Do you want to print ?"; }
	 * map.put("hinNo", hinNo); map.put("serviceNo", serviceNo);
	 * 
	 * if (request.getParameter("image") != null) { uploadPhoto(request); } }
	 * else if (existingHinNoList.size() > 0) { message =
	 * "Data can not be saved.This Hin is already exists."; } else { message =
	 * "Some problem Occured! Try Again."; } String backUrl = ""; backUrl =
	 * "/hms/hms/registration?method=showRegistrationJsp"; map.put("backUrl",
	 * backUrl); StringBuffer jsp = new StringBuffer(""); if
	 * (adPro.equalsIgnoreCase("YES")) { Map<String, Object> patientMap = new
	 * HashMap<String, Object>(); Map<String, Object> mapForDs = new
	 * HashMap<String, Object>(); Map<String, Object> AdDetailsMap1 = new
	 * HashMap<String, Object>(); mapForDs.put("hinNo", hinNo);
	 * 
	 * 
	 * patientMap = registrationHandlerService.getPatientDetails(mapForDs);
	 * AdDetailsMap1 = registrationHandlerService.getAdmissionDetails();
	 * jsp.append(ADMISSION_BY_HIN_NO_JSP); map.put("patientMap", patientMap);
	 * map.put("detailsMap", AdDetailsMap1); } else { dataMap.put("users",
	 * user); Map<String, Object> newMap = commonMasterHandlerService
	 * .getUserButtonRights(dataMap); List<UserButtonRights> userRightsList =
	 * (List<UserButtonRights>) newMap .get("userRightsList");
	 * //System.out.println
	 * ("size of userRightsList in controller submit patient information====u====="
	 * + userRightsList.size()); map.put("userRightsList", userRightsList);
	 * if(request.getParameter("flag").equals("registration")){
	 * jsp.append(MSG_FOR_REG);
	 * 
	 * }else if(request.getParameter("flag").equals("medicalExam")){
	 * jsp.append(MSG_FOR_REG); } }
	 * 
	 * jsp.append(".jsp"); map.put("contentJsp", jsp); map.put("message",
	 * message); map.put("existingHinNoList", existingHinNoList); return new
	 * ModelAndView("index", "map", map); }
	 */

	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitPatientInformation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Patient patient = new Patient();

		int servicePersonRelationId = 0;
		int serTypeId = 0;
		String hinNo = "";
		String serviceNo = "";
		Map<String, Object> objectMap = new HashMap<String, Object>();

		Users user = (Users) session.getAttribute("users");
		patient.setAddEditBy(user);
		objectMap.put("user", user);

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);

		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			patient.setHinNo(hinNo);
			patient.setPreviousHinNo(hinNo);

		}
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = HMSUtil.restrictMetaChar(request
					.getParameter(SERVICE_NO));
			// serviceNo = request.getParameter(SERVICE_NO);
			patient.setServiceNo(serviceNo.trim());

		}
		MasServiceType masServiceType = new MasServiceType();
		serTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
		masServiceType.setId(Integer.parseInt(request
				.getParameter(SERVICE_TYPE_ID)));
		patient.setServiceType(masServiceType);

		String suffix = "";
		if (request.getParameter(SUFFIX) != null
				&& !request.getParameter(SUFFIX).equals("")) {
			suffix = HMSUtil.restrictMetaChar(request.getParameter(SUFFIX));
			// suffix = request.getParameter(SUFFIX);
		}
		patient.setSuffix(suffix);
		objectMap.put("suffix", suffix);

		String prefix = "";
		if (request.getParameter(PREFIX) != null
				&& !request.getParameter(PREFIX).equals("")) {
			prefix = HMSUtil.restrictMetaChar(request.getParameter(PREFIX));
			// prefix = request.getParameter(PREFIX);
		}
		patient.setPrefix(prefix.trim());
		objectMap.put("prefix", prefix);

		int serviceStatusId = 0;
		if (request.getParameter(SERVICE_STATUS_ID) != null
				&& !request.getParameter(SERVICE_STATUS_ID).equals("0")) {
			serviceStatusId = Integer.parseInt(request
					.getParameter(SERVICE_STATUS_ID));
			MasServiceStatus masServiceStatus = new MasServiceStatus();
			masServiceStatus.setId(serviceStatusId);
			patient.setServiceStatus(masServiceStatus);
		}

		if (request.getParameter(RANK_ID) != null
				&& !request.getParameter(RANK_ID).equals("0")) {
			int rankId = Integer.parseInt(request.getParameter(RANK_ID));
			MasRank masRank = new MasRank();
			masRank.setId(rankId);
			patient.setRank(masRank);
			objectMap.put("masRank", masRank);
		}
		if (request.getParameter(S_FIRST_NAME) != null) {
			patient.setSFirstName((request.getParameter(S_FIRST_NAME).trim())
					.toUpperCase());
			objectMap.put("sFirstName",
					(request.getParameter(S_FIRST_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(S_MIDDLE_NAME) != null) {
			patient.setSMiddleName((request.getParameter(S_MIDDLE_NAME).trim())
					.toUpperCase());
			objectMap.put("sMiddleName",
					(request.getParameter(S_MIDDLE_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(S_LAST_NAME) != null) {
			patient.setSLastName((request.getParameter(S_LAST_NAME).trim())
					.toUpperCase());
			objectMap.put("sLastName",
					(request.getParameter(S_LAST_NAME).trim()).toUpperCase());
		}

		if (request.getParameter(TRADE_ID) != null
				&& !request.getParameter(TRADE_ID).equals("0")) {
			if (!request.getParameter(TRADE_ID).equals("31")) { // for other
				int tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
				MasTrade masTrade = new MasTrade();
				masTrade.setId(tradeId);
				patient.setTrade(masTrade);
				objectMap.put("masTrade", masTrade);
			} else if (request.getParameter(TRADE_NAME) != null
					&& !request.getParameter(TRADE_NAME).equals("")) {
				MasTrade masTradeObj = new MasTrade();

				StringBuffer output_str1 = new StringBuffer();
				StringTokenizer s1 = new StringTokenizer(
						request.getParameter(TRADE_NAME) + "", "\'");

				while (s1.hasMoreTokens()) {
					output_str1.append(s1.nextToken());
					if (s1.hasMoreTokens()) {
						output_str1.append(" ");
					}
				}

				StringBuffer output_str2 = new StringBuffer();
				StringTokenizer s2 = new StringTokenizer(output_str1 + "", "\"");

				while (s2.hasMoreTokens()) {
					output_str2.append(s2.nextToken());
					if (s2.hasMoreTokens()) {
						output_str2.append(" ");
					}
				}

				masTradeObj.setTradeName("" + output_str2);

				if (request.getParameter(CHANGED_BY) != null
						&& !(request.getParameter(CHANGED_BY).equals(""))) {
					masTradeObj.setLastChgBy(request.getParameter(CHANGED_BY));
				}

				Date changedDate = HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(CHANGED_DATE));
				masTradeObj.setLastChgDate(changedDate);
				masTradeObj.setLastChgTime(request.getParameter(CHANGED_TIME));
				masTradeObj.setStatus("n");

				objectMap.put("masTradeObj", masTradeObj);
			}
		}
		if (request.getParameter(RECORD_OFFICE_ADDRESS_ID) != null
				&& !request.getParameter(RECORD_OFFICE_ADDRESS_ID).equals("0")) {
			int recordOfficeAddId = Integer.parseInt(request
					.getParameter(RECORD_OFFICE_ADDRESS_ID));
			MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
			masRecordOfficeAddress.setId(recordOfficeAddId);
			patient.setRecordOfficeAddress(masRecordOfficeAddress);
			objectMap.put("masRecordOfficeAddress", masRecordOfficeAddress);
		}
		if (request.getParameter(UNIT_ID) != null
				&& !request.getParameter(UNIT_ID).equals("0")) {
			if (!request.getParameter(UNIT_ID).equals("other")) {
				int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				patient.setUnit(masUnit);
				objectMap.put("masUnit", masUnit);
			} else if (request.getParameter(UNIT_NAME) != null
					&& !request.getParameter(UNIT_NAME).equals("")) {
				MasUnit masUnitObj = new MasUnit();
				if (request.getParameter(UNIT_NAME) != null) {

					StringBuffer output_str1 = new StringBuffer();
					StringTokenizer s1 = new StringTokenizer(
							request.getParameter(UNIT_NAME) + "", "\'");

					while (s1.hasMoreTokens()) {
						output_str1.append(s1.nextToken());
						if (s1.hasMoreTokens()) {
							output_str1.append(" ");
						}
					}

					StringBuffer output_str2 = new StringBuffer();
					StringTokenizer s2 = new StringTokenizer(output_str1 + "",
							"\"");

					while (s2.hasMoreTokens()) {
						output_str2.append(s2.nextToken());
						if (s2.hasMoreTokens()) {
							output_str2.append(" ");
						}
					}

					masUnitObj.setUnitName("" + output_str2);
				}
				if (request.getParameter(UNIT_ADDRESS) != null) {

					StringBuffer output_str3 = new StringBuffer();
					StringTokenizer s3 = new StringTokenizer(
							request.getParameter(UNIT_ADDRESS) + "", "\'");

					while (s3.hasMoreTokens()) {
						output_str3.append(s3.nextToken());
						if (s3.hasMoreTokens()) {
							output_str3.append(" ");
						}
					}

					StringBuffer output_str4 = new StringBuffer();
					StringTokenizer s4 = new StringTokenizer(output_str3 + "",
							"\"");

					while (s4.hasMoreTokens()) {
						output_str4.append(s4.nextToken());
						if (s4.hasMoreTokens()) {
							output_str4.append(" ");
						}
					}
					masUnitObj.setUnitAddress("" + output_str4);
				}

				if (request.getParameter(CHANGED_BY) != null
						&& !(request.getParameter(CHANGED_BY).equals(""))) {
					masUnitObj.setLastChgBy(request.getParameter(CHANGED_BY));
				}
				if (request.getParameter(LOCAL_UNIT) != null) {
					masUnitObj.setLocalUnit("y");
				} else {
					masUnitObj.setLocalUnit("n");
				}
				Date changedDate = HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(CHANGED_DATE));
				masUnitObj.setLastChgDate(changedDate);
				masUnitObj.setLastChgTime(request.getParameter(CHANGED_TIME));
				masUnitObj.setStatus("n");
				objectMap.put("masUnitObj", masUnitObj);
			}
		}

		if (serviceStatusId == 2) {
			MasUnit masUnit = new MasUnit();
			masUnit.setId(257);
			patient.setUnit(masUnit);
		}

		if (request.getParameter("commissionDate") != null
				&& !(request.getParameter("commissionDate").equals(""))) {
			patient.setCommissionDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("commissionDate")));
			objectMap.put("commisionDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("commissionDate")));
		}
		if (request.getParameter(TOTAL_SERVICE) != null
				&& !request.getParameter(TOTAL_SERVICE).equals("")) {
			patient.setServiceYears(Float.parseFloat(request
					.getParameter(TOTAL_SERVICE)));
			objectMap.put("totalService",
					Float.parseFloat(request.getParameter(TOTAL_SERVICE)));
		}
		if (request.getParameter(TOTAL_SERVICE_PERIOD) != null
				&& !request.getParameter(TOTAL_SERVICE_PERIOD).equals("")) {
			patient.setTotalServicePeriod(request
					.getParameter(TOTAL_SERVICE_PERIOD));
		}
		if (request.getParameter(STATION) != null
				&& !request.getParameter(STATION).equals("")) {
			if (!request.getParameter(STATION).equals("other")) {
				patient.setStation(request.getParameter(STATION));
				objectMap.put("station", request.getParameter(STATION));
			} else if (request.getParameter("stationName") != null) {
				patient.setStation(request.getParameter("stationName"));

				MasStation masStation = new MasStation();

				StringBuffer output_str1 = new StringBuffer();
				StringTokenizer s1 = new StringTokenizer(
						request.getParameter("stationName") + "", "\'");

				while (s1.hasMoreTokens()) {
					output_str1.append(s1.nextToken());
					if (s1.hasMoreTokens()) {
						output_str1.append(" ");
					}
				}

				StringBuffer output_str2 = new StringBuffer();
				StringTokenizer s2 = new StringTokenizer(output_str1 + "", "\"");

				while (s2.hasMoreTokens()) {
					output_str2.append(s2.nextToken());
					if (s2.hasMoreTokens()) {
						output_str2.append(" ");
					}
				}

				masStation.setStationName("" + output_str2);
				masStation.setStationCode(output_str2.substring(0, 3));

				if (request.getParameter(CHANGED_BY) != null
						&& !(request.getParameter(CHANGED_BY).equals(""))) {
					masStation.setLastChgBy(user);
				}

				Date changedDate = HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(CHANGED_DATE));
				masStation.setLastChgDate(changedDate);
				masStation.setLastChgTime(request.getParameter(CHANGED_TIME));
				masStation.setStatus("n");

				objectMap.put("masStation", masStation);

			}
		}

		if (request.getParameter(COMMAND) != null
				&& !(request.getParameter(COMMAND).equals("0"))) {
			if (!(request.getParameter(COMMAND).equals("other"))) {
				MasCommand command = new MasCommand();
				command.setId(Integer.parseInt(request.getParameter(COMMAND)));
				patient.setCommand(command);
				objectMap.put("command", command);
			} else if (request.getParameter("commandName") != null
					&& !request.getParameter("commandName").equals("")) {
				MasCommand masCommand = new MasCommand();

				StringBuffer output_str1 = new StringBuffer();
				StringTokenizer s1 = new StringTokenizer(
						request.getParameter("commandName") + "", "\'");

				while (s1.hasMoreTokens()) {
					output_str1.append(s1.nextToken());
					if (s1.hasMoreTokens()) {
						output_str1.append(" ");
					}
				}

				StringBuffer output_str2 = new StringBuffer();
				StringTokenizer s2 = new StringTokenizer(output_str1 + "", "\"");

				while (s2.hasMoreTokens()) {
					output_str2.append(s2.nextToken());
					if (s2.hasMoreTokens()) {
						output_str2.append(" ");
					}
				}

				masCommand.setCommandName("" + output_str2);
				masCommand.setCommandCode(output_str2.substring(0, 3));

				if (request.getParameter(CHANGED_BY) != null
						&& !(request.getParameter(CHANGED_BY).equals(""))) {
					masCommand.setLastChgBy(user);
				}

				Date changedDate = HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(CHANGED_DATE));
				masCommand.setLastChgDate(changedDate);
				masCommand.setLastChgTime(request.getParameter(CHANGED_TIME));
				masCommand.setStatus("n");

				objectMap.put("masCommand", masCommand);
			}
		}
		if (request.getParameter(SECTION_ID) != null
				&& !(request.getParameter(SECTION_ID).equals("0"))) {
			if (!(request.getParameter(SECTION_ID).equals("other"))) {
				MasSection section = new MasSection();
				section.setId(Integer.parseInt(request.getParameter(SECTION_ID)));
				patient.setSection(section);
				objectMap.put("section", section);
			} else if (request.getParameter("sectionName") != null
					&& !request.getParameter("sectionName").equals("")) {
				MasSection masSection = new MasSection();

				StringBuffer output_str1 = new StringBuffer();
				StringTokenizer s1 = new StringTokenizer(
						request.getParameter("sectionName") + "", "\'");

				while (s1.hasMoreTokens()) {
					output_str1.append(s1.nextToken());
					if (s1.hasMoreTokens()) {
						output_str1.append(" ");
					}
				}

				StringBuffer output_str2 = new StringBuffer();
				StringTokenizer s2 = new StringTokenizer(output_str1 + "", "\"");

				while (s2.hasMoreTokens()) {
					output_str2.append(s2.nextToken());
					if (s2.hasMoreTokens()) {
						output_str2.append(" ");
					}
				}

				masSection.setSectionName("" + output_str2);
				masSection.setSectionCode(output_str2.substring(0, 3));

				if (request.getParameter(CHANGED_BY) != null
						&& !(request.getParameter(CHANGED_BY).equals(""))) {
					masSection.setLastChgBy(user);
				}

				Date changedDate = HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(CHANGED_DATE));
				masSection.setLastChgDate(changedDate);
				masSection.setLastChgTime(request.getParameter(CHANGED_TIME));
				masSection.setStatus("y");
				masSection.setHospital(masHospital);

				objectMap.put("masSection", masSection);
			}
		}

		if (request.getParameter(SR_SEX) != null
				&& !(request.getParameter(SR_SEX).equals("0"))) {
			MasAdministrativeSex admsex = new MasAdministrativeSex();
			admsex.setId(Integer.parseInt(request.getParameter(SR_SEX)));
			patient.setSrSex(admsex);
			objectMap.put("srSex", admsex);
		}

		if (request.getParameter(SR_AGE) != null) {
			if (request.getParameter(SR_AGE_UNIT) != null) {
				String ageUnit = request.getParameter(SR_AGE_UNIT);
				String srage = request.getParameter(SR_AGE).concat(" ")
						.concat(ageUnit);
				patient.setSrAge(srage);
				objectMap.put("srAge", srage);
			}
		}
		if (request.getParameter(SR_DOB) != null
				&& !(request.getParameter(SR_DOB).equals(""))) {
			patient.setSrDob(HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(SR_DOB)));
			objectMap.put("srDob", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(SR_DOB)));
		}

		if (request.getParameter("srMaritalStatus") != null
				&& !(request.getParameter("srMaritalStatus").equals("0"))) {
			MasMaritalStatus maritalStatus = new MasMaritalStatus();
			maritalStatus.setId(Integer.parseInt(request
					.getParameter("srMaritalStatus")));
			patient.setSrMaritalStatus(maritalStatus);
			objectMap.put("maritalStatus", maritalStatus);
		}

		/*
		 * if (request.getParameter(SERV_BLD_GROUP) != null &&
		 * !request.getParameter(SERV_BLD_GROUP).equals("0")) { int bldGrpId =
		 * Integer.parseInt(request .getParameter(SERV_BLD_GROUP));
		 * MasBloodGroup masBloodGroup = new MasBloodGroup();
		 * masBloodGroup.setId(bldGrpId);
		 * patient.setSrBloodGroup(masBloodGroup);
		 * objectMap.put("masBloodGroup", masBloodGroup ); }
		 */
		if (request.getParameter(RELIGION_ID) != null
				&& !request.getParameter(RELIGION_ID).equals("0")) {
			int religionId = Integer
					.parseInt(request.getParameter(RELIGION_ID));
			MasReligion masReligion = new MasReligion();
			masReligion.setId(religionId);
			patient.setReligion(masReligion);
			objectMap.put("masReligion", masReligion);
		}

		if (request.getParameter(TELEPHONE_NO) != null) {
			patient.setPhoneNumber(request.getParameter(TELEPHONE_NO));
			objectMap.put("telephoneNo", request.getParameter(TELEPHONE_NO));
		}
		if (request.getParameter(MOBILE_NO) != null) {
			patient.setMobileNumber(request.getParameter(MOBILE_NO));
			objectMap.put("mobileNo", request.getParameter(MOBILE_NO));
		}
		if (request.getParameter("afnetNo") != null) {
			patient.setAfnetNo(request.getParameter("afnetNo"));
			objectMap.put("afnetNo", request.getParameter("afnetNo"));
		}

		if (request.getParameter(PERMANENT_ADDRESS) != null) {
			patient.setPermanentAddress(request.getParameter(PERMANENT_ADDRESS));
			objectMap.put("permanentAddress",
					request.getParameter(PERMANENT_ADDRESS));
		}
		if (request.getParameter("phoneNoRes") != null) {
			patient.setTelephoneResi(request.getParameter("phoneNoRes"));
			objectMap.put("telephoneResi", request.getParameter("phoneNoRes"));
		}
		if (request.getParameter("permCityId") != null
				&& !request.getParameter("permCityId").equals("0")) {
			MasDistrict district = new MasDistrict();
			district.setId(Integer.parseInt(request.getParameter("permCityId")));
			patient.setPermanentCity(district);
			objectMap.put("permanentCity", district);
		}
		if (request.getParameter("permStateId") != null
				&& !request.getParameter("permStateId").equals("0")) {
			MasState state = new MasState();
			state.setId(Integer.parseInt(request.getParameter("permStateId")));
			patient.setPermanentState(state);
			objectMap.put("permanentState", state);
		}
		if (request.getParameter(NEXT_OF_KIN_NAME) != null
				&& !request.getParameter(NEXT_OF_KIN_NAME).equals("")) {
			patient.setNextOfKinName(request.getParameter(NEXT_OF_KIN_NAME));
			objectMap.put("nok1Name", request.getParameter(NEXT_OF_KIN_NAME));
		} 
		if (request.getParameter("telephoneNoPerm") != null) {
			patient.setTelephoneNoPerm(request.getParameter("telephoneNoPerm"));
			objectMap.put("telephoneNoPerm",
					request.getParameter("telephoneNoPerm"));
		}
		if (request.getParameter("otherContactNo") != null) {
			patient.setOtherContactNo(request.getParameter("otherContactNo"));
			objectMap.put("otherContactNo",
					request.getParameter("otherContactNo"));
		}
		if (request.getParameter("policeStation") != null) {
			patient.setPoliceStation(request.getParameter("policeStation"));
			objectMap.put("policeStation",
					request.getParameter("policeStation"));
		}
		if (request.getParameter("pinCode") != null) {
			patient.setPinCode(request.getParameter("pinCode"));
			objectMap.put("pinCode", request.getParameter("pinCode"));
		}
		if (request.getParameter(NEXT_OF_KIN_PHONE_NO) != null
				&& !request.getParameter(NEXT_OF_KIN_PHONE_NO).equals("")) {
			patient.setNextOfKinPhoneNumber(request
					.getParameter(NEXT_OF_KIN_PHONE_NO));
			objectMap.put("nok1Phone",
					request.getParameter(NEXT_OF_KIN_PHONE_NO));
		} else if (request.getParameter(SR_NEXT_OF_KIN_PHONE_NO) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_PHONE_NO).equals("")) {
			patient.setNextOfKinPhoneNumber(request
					.getParameter(SR_NEXT_OF_KIN_PHONE_NO));
			objectMap.put("nok1Phone",
					request.getParameter(SR_NEXT_OF_KIN_PHONE_NO));
		}
		if (request.getParameter(NEXT_OF_KIN_ADDRESS) != null
				&& !request.getParameter(NEXT_OF_KIN_ADDRESS).equals("")) {
			patient.setNextOfKinAddress(request
					.getParameter(NEXT_OF_KIN_ADDRESS));
			objectMap.put("nok1Address",
					request.getParameter(NEXT_OF_KIN_ADDRESS));
		} else if (request.getParameter(SR_NEXT_OF_KIN_ADDRESS) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_ADDRESS).equals("")) {
			patient.setNextOfKinAddress(request
					.getParameter(SR_NEXT_OF_KIN_ADDRESS));
			objectMap.put("nok1Address",
					request.getParameter(SR_NEXT_OF_KIN_ADDRESS));
		}
		if (request.getParameter(NEXT_OF_KIN_RELATION_ID) != null
				&& !request.getParameter(NEXT_OF_KIN_RELATION_ID).equals("0")) {
			int nextOfKinRelationId = Integer.parseInt(request
					.getParameter(NEXT_OF_KIN_RELATION_ID));
			MasRelation relation = new MasRelation();
			relation.setId(nextOfKinRelationId);
			patient.setNextOfKinRelation(relation);
			objectMap.put("nok1Relation", relation);
		} else if (request.getParameter(SR_NEXT_OF_KIN_RELATION_ID) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_RELATION_ID)
						.equals("0")) {
			int nextOfKinRelationId = Integer.parseInt(request
					.getParameter(SR_NEXT_OF_KIN_RELATION_ID));
			MasRelation relation = new MasRelation();
			relation.setId(nextOfKinRelationId);
			patient.setNextOfKinRelation(relation);
			objectMap.put("nok1Relation", relation);
		}

		if (request.getParameter("nok1PoliceStation") != null
				&& !request.getParameter("nok1PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("nok1PoliceStation"));
			objectMap.put("nok1PoliceStation",
					request.getParameter("nok1PoliceStation"));
		} else if (request.getParameter("srnok1PoliceStation") != null
				&& !request.getParameter("srnok1PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("srnok1PoliceStation"));
			objectMap.put("nok1PoliceStation",
					request.getParameter("srnok1PoliceStation"));
		}

		if (request.getParameter("nok1PinCode") != null
				&& !request.getParameter("nok1PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("nok1PinCode"));
			objectMap.put("nok1PinCode", request.getParameter("nok1PinCode"));
		} else if (request.getParameter("srnok1PinCode") != null
				&& !request.getParameter("srnok1PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("srnok1PinCode"));
			objectMap.put("nok1PinCode", request.getParameter("srnok1PinCode"));
		}

		if (request.getParameter("nok2Name") != null
				&& !request.getParameter("nok2Name").equals("")) {
			patient.setNok2Name(request.getParameter("nok2Name"));
			objectMap.put("nok2Name", request.getParameter("nok2Name"));
		} 
		if (request.getParameter("nok2RelationId") != null
				&& !request.getParameter("nok2RelationId").equals("0")) {
			int nok2RelationId = Integer.parseInt(request
					.getParameter("nok2RelationId"));
			MasRelation relation = new MasRelation();
			relation.setId(nok2RelationId);
			patient.setNok2Relation(relation);
			objectMap.put("nok2Relation", relation);
		} else if (request.getParameter("srnok2RelationId") != null
				&& !request.getParameter("srnok2RelationId").equals("0")) {
			int nok2RelationId = Integer.parseInt(request
					.getParameter("srnok2RelationId"));
			MasRelation relation = new MasRelation();
			relation.setId(nok2RelationId);
			patient.setNok2Relation(relation);
			objectMap.put("nok2Relation", relation);
		}

		if (request.getParameter("nok2ContactNo") != null
				&& !request.getParameter("nok2ContactNo").equals("")) {
			patient.setNok2ContactNo(request.getParameter("nok2ContactNo"));
			objectMap.put("nok2ContactNo",
					request.getParameter("nok2ContactNo"));
		} else if (request.getParameter("srnok2ContactNo") != null
				&& !request.getParameter("srnok2ContactNo").equals("")) {
			patient.setNok2ContactNo(request.getParameter("srnok2ContactNo"));
			objectMap.put("nok2ContactNo",
					request.getParameter("srnok2ContactNo"));
		}

		if (request.getParameter("nok2Address") != null
				&& !request.getParameter("nok2Address").equals("")) {
			patient.setNok2Address(request.getParameter("nok2Address"));
			objectMap.put("nok2Address", request.getParameter("nok2Address"));
		} else if (request.getParameter("srnok2Address") != null
				&& !request.getParameter("srnok2Address").equals("")) {
			patient.setNok2Address(request.getParameter("srnok2Address"));
			objectMap.put("nok2Address", request.getParameter("srnok2Address"));
		}

		if (request.getParameter("nok2PoliceStation") != null
				&& !request.getParameter("nok2PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("nok2PoliceStation"));
			objectMap.put("nok2PoliceStation",
					request.getParameter("nok2PoliceStation"));
		} else if (request.getParameter("srnok2PoliceStation") != null
				&& !request.getParameter("srnok2PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("srnok2PoliceStation"));
			objectMap.put("nok2PoliceStation",
					request.getParameter("srnok2PoliceStation"));
		}

		if (request.getParameter("nok2PinCode") != null
				&& !request.getParameter("nok2PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("nok2PinCode"));
			objectMap.put("nok2PinCode", request.getParameter("nok2PinCode"));
		} else if (request.getParameter("srnok2PinCode") != null
				&& !request.getParameter("srnok2PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("srnok2PinCode"));
			objectMap.put("nok2PinCode", request.getParameter("srnok2PinCode"));
		}
		if (request.getParameter("srMarriageDate") != null
				&& !request.getParameter("srMarriageDate").equals("")) {
			patient.setSrMarriageDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("srMarriageDate")));
			objectMap.put("srMarriageDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("srMarriageDate")));
		}
		if (request.getParameter("depMarriageDate") != null
				&& !request.getParameter("depMarriageDate").equals("")) {
			patient.setDepMarriageDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("depMarriageDate")));
			objectMap.put("depMarriageDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("depMarriageDate")));
		}
		if (request.getParameter("identificationMark1") != null) {
			patient.setSrIdentificationMark1(request
					.getParameter("identificationMark1"));
			objectMap.put("identificationMark1",
					request.getParameter("identificationMark1"));
		}
		if (request.getParameter("identificationMark2") != null) {
			patient.setSrIdentificationMark2(request
					.getParameter("identificationMark2"));
			objectMap.put("identificationMark2",
					request.getParameter("identificationMark2"));
		}
		if (request.getParameter("depIdentificationMark1") != null) {
			patient.setDepIdentificationMark1(request
					.getParameter("depIdentificationMark1"));
			objectMap.put("depIdentificationMark1",
					request.getParameter("depIdentificationMark1"));
		}
		if (request.getParameter("depIdentificationMark2") != null) {
			patient.setDepIdentificationMark2(request
					.getParameter("depIdentificationMark2"));
			objectMap.put("depIdentificationMark2",
					request.getParameter("depIdentificationMark2"));
		}
		if (serTypeId == 7) {
			MasRelation masRelation = new MasRelation();
			masRelation.setId(8);
			patient.setRelation(masRelation);
			patient.setRank(new MasRank(179));
			patient.setUnit(new MasUnit(257));
		} else {
			if (request.getParameter(RELATION_ID) != null
					&& !request.getParameter(RELATION_ID).equals("0")) {
				servicePersonRelationId = Integer.parseInt(request
						.getParameter(RELATION_ID));
				MasRelation masRelation = new MasRelation();
				masRelation.setId(servicePersonRelationId);
				patient.setRelation(masRelation);
			} else {
				MasRelation masRelation = new MasRelation();
				masRelation.setId(8);
				patient.setRelation(masRelation);
			}
		}
		if (!request.getParameter(TITLE).equals("0")) {
			int titleId = Integer.parseInt(request.getParameter(TITLE));
			MasTitle masTitle = new MasTitle();
			masTitle.setId(titleId);
			patient.setTitle(masTitle);
		}
		patient.setPFirstName((request.getParameter(P_FIRST_NAME).trim())
				.toUpperCase());
		objectMap.put("pFirstName",
				(request.getParameter(P_FIRST_NAME).trim()).toUpperCase());
		if (request.getParameter(P_MIDDLE_NAME) != null) {
			patient.setPMiddleName((request.getParameter(P_MIDDLE_NAME).trim())
					.toUpperCase());
			objectMap.put("pMiddleName",
					(request.getParameter(P_MIDDLE_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(P_LAST_NAME) != null) {
			patient.setPLastName((request.getParameter(P_LAST_NAME).trim())
					.toUpperCase());
			objectMap.put("pLastName",
					(request.getParameter(P_LAST_NAME).trim()).toUpperCase());
		}
		if (!request.getParameter(GENDER).equals("0")) {
			int genderId = Integer.parseInt(request.getParameter(GENDER));
			MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
			masAdministrativeSex.setId(genderId);
			patient.setSex(masAdministrativeSex);
			objectMap.put("pSex", masAdministrativeSex);
		}
		String age = "";
		if (request.getParameter(AGE) != null) {
			if (request.getParameter(AGE_UNIT) != null) {
				String ageUnit = request.getParameter(AGE_UNIT);
				age = request.getParameter(AGE).concat(" ").concat(ageUnit);
				patient.setAge(age);
				objectMap.put("pAge", age);
			}
		}
		System.out.println(request.getParameter(AGE));
		if (request.getParameter("ageLabel") != null
				&& !(request.getParameter("ageLabel").equals(""))) {
			age = request.getParameter("ageLabel");
			patient.setAge(age);
		}
		if (request.getParameter(DATE_OF_BIRTH) != null
				&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
			Date dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_BIRTH));
			patient.setDateOfBirth(dateOfBirth);
			objectMap.put("pDob", dateOfBirth);
		}

		if (request.getParameter(MARITAL_STATUS_ID) != null
				&& !request.getParameter(MARITAL_STATUS_ID).equals("0")) {
			int maritalStatusId = Integer.parseInt(request
					.getParameter(MARITAL_STATUS_ID));
			MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
			masMaritalStatus.setId(maritalStatusId);
			patient.setMaritalStatus(masMaritalStatus);
			objectMap.put("ptMaritalStatus", masMaritalStatus);
		}
		if (request.getParameter(OCCUPATION_ID) != null
				&& !request.getParameter(OCCUPATION_ID).equals("0")) {
			int occupationId = Integer.parseInt(request
					.getParameter(OCCUPATION_ID));
			MasOccupation masOccupation = new MasOccupation();
			masOccupation.setId(occupationId);
			patient.setOccupation(masOccupation);
			objectMap.put("masOccupation", masOccupation);
		}
		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !request.getParameter(BLOOD_GROUP_ID).equals("0")) {
			int bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bloodGroupId);
			patient.setBloodGroup(masBloodGroup);
			objectMap.put("ptBloodGroup", masBloodGroup);
		}
		if (request.getParameter(SR_BLOOD_GROUP_ID) != null
				&& !request.getParameter(SR_BLOOD_GROUP_ID).equals("0")) {
			int bloodGroupId = Integer.parseInt(request
					.getParameter(SR_BLOOD_GROUP_ID));
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bloodGroupId);
			patient.setSrBloodGroup(masBloodGroup);
			if (request.getParameter(RELATION_ID).equals("0")
					|| request.getParameter(RELATION_ID).equals("8")) {
				patient.setBloodGroup(masBloodGroup);
				objectMap.put("ptBloodGroup", masBloodGroup);
			}
			objectMap.put("srBloodGroup", masBloodGroup);
		}

		if (request.getParameter("income") != null) {
			patient.setIncome(request.getParameter("income"));
			objectMap.put("income", request.getParameter("income"));
		}

		if (request.getParameter("dependencyDate") != null
				&& !(request.getParameter("dependencyDate").equals(""))) {
			patient.setDependencyDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyDate")));
			objectMap.put("dependencyDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyDate")));
		}
		if (request.getParameter("authority") != null) {
			patient.setAuthority(request.getParameter("authority"));
			objectMap.put("authority", request.getParameter("authority"));
		}
		if (request.getParameter("dependencyRemovalDate") != null
				&& !(request.getParameter("dependencyRemovalDate").equals(""))) {
			patient.setDependencyRemovalDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyRemovalDate")));
			objectMap.put("dependencyRemovalDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyRemovalDate")));
		}
		if (request.getParameter(DISTRICT) != null
				&& !request.getParameter(DISTRICT).equals("0")) {
			int districtId = Integer.parseInt(request.getParameter(DISTRICT));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			patient.setDistrict(masDistrict);
			objectMap.put("masDistrict", masDistrict);
		}
		if (request.getParameter(ADDRESS) != null) {
			patient.setAddress(request.getParameter(ADDRESS));
			objectMap.put("address", request.getParameter(ADDRESS));
		}

		if (request.getParameter(CONTACT_NUMBER) != null) {
			patient.setContactNo(request.getParameter(CONTACT_NUMBER));
			objectMap.put("contactNo", request.getParameter(CONTACT_NUMBER));
		}

		if (request.getParameter(STATE) != null
				&& !request.getParameter(STATE).equals("0")) {
			int stateId = Integer.parseInt(request.getParameter(STATE));
			MasState masState = new MasState();
			masState.setId(stateId);
			patient.setState(masState);
			objectMap.put("masState", masState);
		}
		Date addEditDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			patient.setAddEditDate(addEditDate);
		}

		String addEditTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			addEditTime = request.getParameter(CHANGED_TIME);
			patient.setAddEditTime(addEditTime);
		}

		Date regDate = null;
		if (request.getParameter(REG_DATE) != null) {
			regDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(REG_DATE));
			patient.setRegDate(regDate);
		}
		String regTime = "";
		if (request.getParameter(REG_TIME) != null) {
			regTime = request.getParameter(REG_TIME);
			patient.setRegTime(regTime);
		}

		if (request.getParameter("smokerLess10") != null
				|| request.getParameter("srsmokerLess10") != null) {
			patient.setSmokerLess10("y");
			objectMap.put("smokerLess10", "y");
		} else {
			patient.setSmokerLess10("n");
			objectMap.put("smokerLess10", "n");
		}
		if (request.getParameter("smokerMore10") != null
				|| request.getParameter("smokerMore10") != null) {
			patient.setSmokerMore10("y");
			objectMap.put("smokerMore10", "y");
		} else {
			patient.setSmokerMore10("n");
			objectMap.put("smokerMore10", "n");
		}

		if (request.getParameter("alcohol") != null
				&& !request.getParameter("alcohol").equals("")) {
			patient.setAlcohol(request.getParameter("alcohol"));
			objectMap.put("alcohol", request.getParameter("alcohol"));
		} else if (request.getParameter("sralcohol") != null
				&& !request.getParameter("sralcohol").equals("")) {
			patient.setAlcohol(request.getParameter("sralcohol"));
			objectMap.put("alcohol", request.getParameter("sralcohol"));
		}
		if (request.getParameter("otherFamilyHistory") != null
				&& !request.getParameter("otherFamilyHistory").equals("")) {
			patient.setOtherFamilyHistory(request
					.getParameter("otherFamilyHistory"));
			objectMap.put("otherFamilyHistory",
					request.getParameter("otherFamilyHistory"));
		} else if (request.getParameter("otherSrFamilyHistory") != null
				&& !request.getParameter("otherSrFamilyHistory").equals("")) {
			patient.setOtherFamilyHistory(request
					.getParameter("otherSrFamilyHistory"));
			objectMap.put("otherFamilyHistory",
					request.getParameter("otherSrFamilyHistory"));
		}

		if (request.getParameter("allergies") != null) {
			patient.setDrugAllergies(request.getParameter("allergies"));
			objectMap.put("allergies", request.getParameter("allergies"));
		}
		if (request.getParameter("srAllergies") != null) {
			patient.setDrugAllergies(request.getParameter("srAllergies"));
			objectMap.put("srallergies", request.getParameter("srAllergies"));
		}
		/**
		 * Commented By Ritu Single family history not required
		 */
		/*
		 * if(request.getParameter("familyHistory") != null &&
		 * !request.getParameter("familyHistory").equals("0")){
		 * PatientFamilyHistory familyHistory = new PatientFamilyHistory();
		 * familyHistory
		 * .setId(Integer.parseInt(request.getParameter("familyHistory")));
		 * patient.setFamilyHistory(familyHistory); }
		 */

		/**
		 * Added By Ritu for multiple family history
		 */
		String[] familyHistoryArray = null;
		if (request.getParameterValues("familyHistory") != null) {
			familyHistoryArray = request.getParameterValues("familyHistory");
			objectMap.put("familyHistoryArray", familyHistoryArray);
		} else if (request.getParameterValues("srfamilyHistory") != null) {
			familyHistoryArray = request.getParameterValues("srfamilyHistory");
			objectMap.put("familyHistoryArray", familyHistoryArray);
		}
		/**
		 * End
		 */

		if (request.getParameter("presentMedCat") != null
				&& !request.getParameter("presentMedCat").equals("0")) {
			Category category = new Category();
			category.setCategoryid(Integer.parseInt(request
					.getParameter("presentMedCat")));
			patient.setCategory(category);
			objectMap.put("category", category);
		}
		/*
		 * if(request.getParameter("medCatPeriod") != null &&
		 * !request.getParameter("medCatPeriod").equals("")){
		 * patient.setMedCatPeriod(request.getParameter("medCatPeriod"));
		 * objectMap.put("medCatPeriod", request.getParameter("medCatPeriod"));
		 * }Commented by dipali
		 */
		// ---Addd By dipali as discussed with Anshu (05-mar-2013)
		if (request.getParameter("medCatPeriod") != null
				&& !request.getParameter("medCatPeriod").equals("")) {
			if (request.getParameter("medCatDuration") != null) {
				String medCatDuration = request.getParameter("medCatDuration");
				String finalMedCat = request.getParameter("medCatPeriod")
						.concat(" ").concat(medCatDuration);
				patient.setMedCatPeriod(finalMedCat);
				objectMap.put("medCatPeriod", finalMedCat);
			}
		}// --------

		if (request.getParameter("medCatDate") != null
				&& !request.getParameter("medCatDate").equals("")) {
			patient.setMedCatDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("medCatDate")));
			objectMap.put("medCatDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("medCatDate")));
		}
		if (request.getParameter("echs") != null) {
			patient.setEchsNo(request.getParameter("echs"));
			objectMap.put("echs", request.getParameter("echs"));
		}
		patient.setHospital(masHospital);
		patient.setStatus("y");
		patient.setPatientStatus("Out Patient");
		patient.setInpatientNo(0);
		if (request.getParameter("img1") != null
				&& !request.getParameter("img1").equals("")) {
			map.put("img1", request.getParameter("img1"));
		}
		map.put("regFlag", "reg");

		String[] rptForArr = null;
		if (request.getParameterValues("reportingFor") != null) {
			rptForArr = request.getParameterValues("reportingFor");
			objectMap.put("rptForArr", rptForArr);
		}
		List<Visit> visitObjList = new ArrayList<Visit>();
		if (rptForArr != null && rptForArr.length > 0) {
			for (int i = 0; i < rptForArr.length; i++) {
				Visit visit = new Visit();
				visit.setReportingFor(rptForArr[i]);
				if (request.getParameter(DEPARTMENT_ID) != null
						&& !request.getParameter(DEPARTMENT_ID).equals("0")) {
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer.parseInt(request
							.getParameter(DEPARTMENT_ID)));
					visit.setDepartment(masDepartment);
				}
				String tokenAndDoctor = "";

				/*
				 * if (request.getParameter(TOKEN_NO) != null &&
				 * !(request.getParameter(TOKEN_NO).equals(""))) {
				 * visit.setTokenNo
				 * (Integer.parseInt(request.getParameter(TOKEN_NO)));
				 * tokenAndDoctor = request.getParameter(TOKEN_NO); }
				 */
				int tokenNo = 0;

				int consultingDoctorId = 0;
				if (request.getParameter(CONSULTING_DOCTOR) != null
						&& !request.getParameter(CONSULTING_DOCTOR).equals("0")) {
					consultingDoctorId = Integer.parseInt(request
							.getParameter(CONSULTING_DOCTOR));
					MasEmployee consultingDoctorObj = new MasEmployee();
					consultingDoctorObj.setId(consultingDoctorId);
					visit.setDoctor(consultingDoctorObj);
					objectMap.put("consultingDoctorId", consultingDoctorId);
					int maxTokenNo = 0;
				/*	maxTokenNo = registrationHandlerService
							.getTokenNoForDepartment(consultingDoctorId);*/
					tokenNo = maxTokenNo + 1;

					tokenAndDoctor = tokenNo + "#" + consultingDoctorId;
				} else {
					tokenNo = 0;
					tokenAndDoctor = tokenNo + "#" + consultingDoctorId;
				}
				if (rptForArr[i].equals("OPD")
						|| rptForArr[i].equals("FollowUp")) {
					if (request.getParameter("roomNo") != null
							&& !request.getParameter("roomNo").equals("")) {
						visit.setRoomNo(Integer.parseInt(request
								.getParameter("roomNo")));
					}
				}
				visit.setTokenNo(tokenNo);
				visit.setTokenDoctor(tokenAndDoctor);

				visit.setHospital(masHospital);
				visit.setAddEditBy(user);
				visit.setAge(age);
				visit.setVisitDate(addEditDate);
				visit.setAddEditDate(addEditDate);
				visit.setAddEditTime(addEditTime);
				visit.setVisitTime(addEditTime);
				visit.setVisitDate(regDate);
				visit.setVisitTime(regTime);

				visit.setStatus("y");
				// ---------commented by anamika
				// visit.setEdStatus("n");

				visit.setAppointmentType("D");
				if (rptForArr[i].equals("MedExam")) {
					if (request.getParameter("medExamCategory") != null
							&& !(request.getParameter("medExamCategory"))
									.equals("")) {
						visit.setMedExamType(request
								.getParameter("medExamCategory"));
						visit.setVisitStatus("c");
						visit.setMedStatus("w");
					}
				} else if (rptForArr[i].equals("MedBoard")) {
					if (request.getParameter("medBoardCategory") != null
							&& !(request.getParameter("medBoardCategory"))
									.equals("")) {
						visit.setMedExamType(request
								.getParameter("medBoardCategory"));
						visit.setMedStatus("w");
						visit.setVisitStatus("c");
					}
				} else if (rptForArr[i].equals("FamilyWC")) {
					if (request.getParameter("fwcCategory") != null
							&& !(request.getParameter("fwcCategory"))
									.equals("")) {
						visit.setFwcCategory(request
								.getParameter("fwcCategory"));
						visit.setVisitStatus("w");
					}
				} else {
					visit.setVisitStatus("w");
				}

				if (request.getParameter("priority") != null) {
					visit.setPriority(Integer.parseInt(request
							.getParameter("priority")));
				}
				if (rptForArr[i].equals("FollowUp")
						&& request.getParameter("followUpDepartment") != null
						&& request.getParameter("followUpDepartment").equals(
								"FamilyWC")) {
					visit.setFollowUpDepartment(request
							.getParameter("followUpDepartment"));
					visit.setFwcCategory("PNC");
				} else {
					if (request.getParameter("followUpDepartment") != null
							&& rptForArr[i].equals("FollowUp")) {
						visit.setFollowUpDepartment(request
								.getParameter("followUpDepartment"));
					}
				}
				objectMap.put("visit", visit);
				visitObjList.add(visit);
				objectMap.put("visitObjList", visitObjList);
			}
		}
		if (request.getParameter("regHinId") != null
				&& !request.getParameter("regHinId").equals("0")) {
			objectMap.put("regHinId",
					Integer.parseInt(request.getParameter("regHinId")));
		} else if (request.getParameter("selfRegHin") != null
				&& !request.getParameter("selfRegHin").equals("")) {
			objectMap.put("selfRegHin",
					Integer.parseInt(request.getParameter("selfRegHin")));
		}

		/**
		 * Code for Immunization
		 */

		int immCount = 0;
		if (request.getParameter("immCount") != null
				&& !(request.getParameter("immCount").equals(""))) {
			immCount = Integer.parseInt(request.getParameter("immCount"));
		}
		if (immCount > 0) {
			List<Integer> immuDtIdList = new ArrayList<Integer>();
			List<String> immuNameList = new ArrayList<String>();
			List<Integer> immunizationIdList = new ArrayList<Integer>();
			List<String> dateList = new ArrayList<String>();
			List<String> doseList = new ArrayList<String>();
			List<String> routeList = new ArrayList<String>();
			List<String> batchNoList = new ArrayList<String>();
			List<String> domList = new ArrayList<String>();
			List<String> doeList = new ArrayList<String>();

			for (int j = 1; j <= immCount; j++) {
				if (request.getParameter("immunId" + j) != null
						&& !request.getParameter("immunId" + j).equals("")) {
					immuDtIdList.add(Integer.parseInt(request
							.getParameter("immunId" + j)));
				} else {
					immuDtIdList.add(0);
				}
				if (request.getParameter("immunizationName" + j) != null) {
					immuNameList.add(request.getParameter("immunizationName"
							+ j));
				}
				/*
				 * if(request.getParameter("immunizationId"+j)!=null &&
				 * !request.getParameter("immunizationId"+j).equals("")){
				 * immunizationIdList
				 * .add(Integer.parseInt(request.getParameter("immunizationId"
				 * +j))); }
				 */

				if (request.getParameter("vdate" + j) != null) {
					dateList.add(request.getParameter("vdate" + j));
				}
				if (request.getParameter("dose" + j) != null) {
					doseList.add(request.getParameter("dose" + j));
				}
				if (request.getParameter("route" + j) != null) {
					routeList.add(request.getParameter("route" + j));
				}
				if (request.getParameter("batchNo" + j) != null) {
					batchNoList.add(request.getParameter("batchNo" + j));
				}
				if (request.getParameter("dom" + j) != null) {
					domList.add(request.getParameter("dom" + j));
				}
				if (request.getParameter("doe" + j) != null) {
					doeList.add(request.getParameter("doe" + j));
				}

			}
			objectMap.put("immuDtIdList", immuDtIdList);
			objectMap.put("immuNameList", immuNameList);
			objectMap.put("dateList", dateList);
			objectMap.put("doseList", doseList);
			objectMap.put("routeList", routeList);
			objectMap.put("batchNoList", batchNoList);
			objectMap.put("domList", domList);
			objectMap.put("doeList", doeList);
			objectMap.put("immunizationIdList", immunizationIdList);
		}
		objectMap.put("masHospital", masHospital);
		/**
		 * 
		 */

		/**
		 * Code for Allergies
		 */

		int allergyCount = 0;
		if (request.getParameter("allergyCount") != null
				&& !(request.getParameter("allergyCount").equals(""))) {
			allergyCount = Integer.parseInt(request
					.getParameter("allergyCount"));
		}
		// System.out.println("allergyCount  - "+allergyCount);
		if (allergyCount > 0) {
			List<Integer> allergyDetailsIdList = new ArrayList<Integer>();
			List<String> allergyNameList = new ArrayList<String>();
			List<String> descList = new ArrayList<String>();
			List<String> severityList = new ArrayList<String>();
			List<String> sinceList = new ArrayList<String>();
			List<String> remarksList = new ArrayList<String>();

			for (int j = 1; j <= allergyCount; j++) {
				if (request.getParameter("allergyDetailsId" + j) != null
						&& !request.getParameter("allergyDetailsId" + j)
								.equals("")) {
					allergyDetailsIdList.add(Integer.parseInt(request
							.getParameter("allergyDetailsId" + j)));
				} else {
					allergyDetailsIdList.add(0);
				}
				if (request.getParameter("allergyName" + j) != null
						&& !request.getParameter("allergyName" + j).equals("")) {
					allergyNameList
							.add(request.getParameter("allergyName" + j));
				}
				if (request.getParameter("description" + j) != null) {
					descList.add(request.getParameter("description" + j));
				}
				if (request.getParameter("severity" + j) != null) {
					severityList.add(request.getParameter("severity" + j));
				}
				if (request.getParameter("since" + j) != null) {
					sinceList.add(request.getParameter("since" + j));
				}
				if (request.getParameter("remarks" + j) != null) {
					remarksList.add(request.getParameter("remarks" + j));
				}

			}
			objectMap.put("allergyDetailsIdList", allergyDetailsIdList);
			objectMap.put("allergyNameList", allergyNameList);
			objectMap.put("descList", descList);
			objectMap.put("severityList", severityList);
			objectMap.put("sinceList", sinceList);
			objectMap.put("remarksList", remarksList);

		}
		if (request.getParameter("ldapData") != null) {
			objectMap.put("ldapData", request.getParameter("ldapData"));
		}
		/**
		 * 
		 */
		objectMap.put("hinNo", hinNo);
		objectMap.put("patient", patient);

		Box box = HMSUtil.getBox(request);
		objectMap.put("box", box);
		String userSrNo = (String) session.getAttribute("userSrNo");
		objectMap.put("userSrNo", userSrNo);

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;
		List<Patient> existingHinNoList = new ArrayList<Patient>();
		List<Visit> visitList = new ArrayList<Visit>();

		detailsMap = registrationHandlerService
				.submitPatientInformation(objectMap);
		if (detailsMap.get("visitList") != null) {
			visitList = (List<Visit>) detailsMap.get("visitList");
			map.put("visitList", visitList);
		}

		if (detailsMap.get("existingHinNoList") != null) {
			existingHinNoList = (List<Patient>) detailsMap
					.get("existingHinNoList");
		}
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true && existingHinNoList.size() == 0) {
			if (request.getParameter(HIN_NO) == null
					|| request.getParameter(HIN_NO).equals("")) {
				if (request.getParameter("selfHinNo") != null
						&& !request.getParameter("selfHinNo").equals("")) {
					map.put("hinNo", request.getParameter("selfHinNo"));
				}
				if (rptForArr != null && rptForArr.length > 0) {
					message = " Visit Information saved Successfully.";
				} else {
					message = " Patient Information Updated Successfully.";
				}
				map.put("regHinId", request.getParameter("regHinId"));
				map.put("hinNo", request.getParameter("printHinNo"));

			} else {
				message = " Registration Information saved Successfully.";
				map.put("hinNo", hinNo);
			}
			map.put("serviceNo", serviceNo);

			if (request.getParameter("image") != null) {
				uploadPhoto(request);
			}
		} else if (existingHinNoList.size() > 0) {
			message = "Data can not be saved.This Hin is already exists.";
		} else {
			message = "Some problem Occured! Try Again.";
		}
		String backUrl = "";
		backUrl = "/hms/hms/registration?method=showRegistrationJsp";
		map.put("backUrl", backUrl);
		StringBuffer jsp = new StringBuffer("");

		dataMap.put("users", user);
		Map<String, Object> newMap = commonMasterHandlerService
				.getUserButtonRights(dataMap);
		List<UserButtonRights> userRightsList = (List<UserButtonRights>) newMap
				.get("userRightsList");
		map.put("userRightsList", userRightsList);
		/*
		 * if(request.getParameter("flag").equals("registration")){
		 * jsp.append(MSG_FOR_REG);
		 * 
		 * }else if(request.getParameter("flag").equals("medicalExam")){
		 * jsp.append(MSG_FOR_REG); }
		 * 
		 * jsp.append(".jsp");
		 */
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("existingHinNoList", existingHinNoList);
		return new ModelAndView("msgForReg", "map", map);
	}

	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitPatientInformationHAL(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Patient patient = new Patient();

		int servicePersonRelationId = 0;
		int serTypeId = 0;
		String hinNo = "";
		String serviceNo = "";
		Map<String, Object> objectMap = new HashMap<String, Object>();

		Users user = (Users) session.getAttribute("users");
		patient.setAddEditBy(user);
		objectMap.put("user", user);

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);

		if (request.getParameter(HIN_NO) != null) {
			hinNo = getHinNoHALDynamic(request, response);
			patient.setHinNo(hinNo);
			patient.setPreviousHinNo(hinNo);

		}
		/*
		 * if (request.getParameter(SERVICE_NO) != null) { serviceNo =
		 * HMSUtil.restrictMetaChar(request.getParameter(SERVICE_NO)); //
		 * serviceNo = request.getParameter(SERVICE_NO);
		 * patient.setServiceNo(serviceNo.trim());
		 * 
		 * }
		 */
		/*
		 * MasServiceType masServiceType = new MasServiceType(); serTypeId =
		 * Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
		 * masServiceType
		 * .setId(Integer.parseInt(request.getParameter(SERVICE_TYPE_ID)));
		 * patient.setServiceType(masServiceType);
		 */

		/*
		 * String suffix = ""; if (request.getParameter(SUFFIX) != null&&
		 * !request.getParameter(SUFFIX).equals("")) { suffix =
		 * HMSUtil.restrictMetaChar(request.getParameter(SUFFIX)); // suffix =
		 * request.getParameter(SUFFIX); } patient.setSuffix(suffix);
		 * objectMap.put("suffix", suffix);
		 */
		/*
		 * String prefix = ""; if (request.getParameter(PREFIX) != null &&
		 * !request.getParameter(PREFIX).equals("")) { prefix =
		 * HMSUtil.restrictMetaChar(request.getParameter(PREFIX)); // prefix =
		 * request.getParameter(PREFIX); } patient.setPrefix(prefix.trim());
		 * objectMap.put("prefix", prefix);
		 */
		int serviceStatusId = 0;
		if (request.getParameter(SERVICE_STATUS_ID) != null
				&& !request.getParameter(SERVICE_STATUS_ID).equals("0")) {
			serviceStatusId = Integer.parseInt(request
					.getParameter(SERVICE_STATUS_ID));
			MasServiceStatus masServiceStatus = new MasServiceStatus();
			masServiceStatus.setId(serviceStatusId);
			patient.setServiceStatus(masServiceStatus);
		}

		/*
		 * if (request.getParameter(RANK_ID) != null &&
		 * !request.getParameter(RANK_ID).equals("0")) { int rankId =
		 * Integer.parseInt(request.getParameter(RANK_ID)); MasRank masRank =
		 * new MasRank(); masRank.setId(rankId); patient.setRank(masRank);
		 * objectMap.put("masRank",masRank); }
		 */
		if (request.getParameter(S_FIRST_NAME) != null) {
			patient.setSFirstName((request.getParameter(S_FIRST_NAME).trim())
					.toUpperCase());
			objectMap.put("sFirstName",
					(request.getParameter(S_FIRST_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(S_MIDDLE_NAME) != null) {
			patient.setSMiddleName((request.getParameter(S_MIDDLE_NAME).trim())
					.toUpperCase());
			objectMap.put("sMiddleName",
					(request.getParameter(S_MIDDLE_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(S_LAST_NAME) != null) {
			patient.setSLastName((request.getParameter(S_LAST_NAME).trim())
					.toUpperCase());
			objectMap.put("sLastName",
					(request.getParameter(S_LAST_NAME).trim()).toUpperCase());
		}
		
	    /* patient.setBillable(null);*/
	     patient.setPaymentStatus(null); 

		if (request.getParameter(RECORD_OFFICE_ADDRESS_ID) != null
				&& !request.getParameter(RECORD_OFFICE_ADDRESS_ID).equals("0")) {
			int recordOfficeAddId = Integer.parseInt(request
					.getParameter(RECORD_OFFICE_ADDRESS_ID));
			MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
			masRecordOfficeAddress.setId(recordOfficeAddId);
			patient.setRecordOfficeAddress(masRecordOfficeAddress);
			objectMap.put("masRecordOfficeAddress", masRecordOfficeAddress);
		}
		

		if (request.getParameter(SR_SEX) != null
				&& !(request.getParameter(SR_SEX).equals("0"))) {
			MasAdministrativeSex admsex = new MasAdministrativeSex();
			admsex.setId(Integer.parseInt(request.getParameter(SR_SEX)));
			patient.setSrSex(admsex);
			objectMap.put("srSex", admsex);
		}

		if (request.getParameter(SR_AGE) != null) {
			if (request.getParameter(SR_AGE_UNIT) != null) {
				String ageUnit = request.getParameter(SR_AGE_UNIT);
				String srage = request.getParameter(SR_AGE).concat(" ")
						.concat(ageUnit);
				patient.setSrAge(srage);
				objectMap.put("srAge", srage);
			}
		}
		if (request.getParameter("dateOfBirth") != null
				&& !(request.getParameter("dateOfBirth").equals(""))) {
			patient.setSrDob(HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("dateOfBirth")));
			patient.setDateOfBirth(HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("dateOfBirth")));
			objectMap.put("srDob", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dateOfBirth")));
		}

		if (request.getParameter("srMaritalStatus") != null
				&& !(request.getParameter("srMaritalStatus").equals("0"))) {
			MasMaritalStatus maritalStatus = new MasMaritalStatus();
			maritalStatus.setId(Integer.parseInt(request
					.getParameter("srMaritalStatus")));
			patient.setSrMaritalStatus(maritalStatus);
			objectMap.put("maritalStatus", maritalStatus);
		}
		if (request.getParameter("categoryId") != null
				&& !(request.getParameter("categoryId").equals("0"))) {
			MasOthersCategory othersCategory = new MasOthersCategory();
			othersCategory.setId(Integer.parseInt(request
					.getParameter("categoryId")));
			patient.setOthersCategory(othersCategory);
			objectMap.put("othersCategory", othersCategory);
		}

		
		if (request.getParameter(RELIGION_ID) != null
				&& !request.getParameter(RELIGION_ID).equals("0")) {
			int religionId = Integer
					.parseInt(request.getParameter(RELIGION_ID));
			MasReligion masReligion = new MasReligion();
			masReligion.setId(religionId);
			patient.setReligion(masReligion);
			objectMap.put("masReligion", masReligion);
		}

		if (request.getParameter(TELEPHONE_NO) != null) {
			patient.setPhoneNumber(request.getParameter(TELEPHONE_NO));
			objectMap.put("telephoneNo", request.getParameter(TELEPHONE_NO));
		}
		if (request.getParameter(MOBILE_NO) != null) {
			patient.setMobileNumber(request.getParameter(MOBILE_NO));
			objectMap.put("mobileNo", request.getParameter(MOBILE_NO));
		}
		if (request.getParameter("afnetNo") != null) {
			patient.setAfnetNo(request.getParameter("afnetNo"));
			objectMap.put("afnetNo", request.getParameter("afnetNo"));
		}

		if (request.getParameter(PERMANENT_ADDRESS) != null) {
			patient.setPermanentAddress(request.getParameter(PERMANENT_ADDRESS).trim());
			objectMap.put("permanentAddress",
					request.getParameter(PERMANENT_ADDRESS).trim());
		}
		if (request.getParameter("phoneNoRes") != null) {
			patient.setTelephoneResi(request.getParameter("phoneNoRes"));
			objectMap.put("telephoneResi", request.getParameter("phoneNoRes"));
		}
		if (request.getParameter("permCityId") != null
				&& !request.getParameter("permCityId").equals("0")) {
			MasDistrict district = new MasDistrict();
			district.setId(Integer.parseInt(request.getParameter("permCityId")));
			patient.setPermanentCity(district);
			objectMap.put("permanentCity", district);
		}
		if (request.getParameter("permStateId") != null
				&& !request.getParameter("permStateId").equals("0")) {
			MasState state = new MasState();
			state.setId(Integer.parseInt(request.getParameter("permStateId")));
			patient.setPermanentState(state);
			objectMap.put("permanentState", state);
		}
		if (request.getParameter(NEXT_OF_KIN_NAME) != null
				&& !request.getParameter(NEXT_OF_KIN_NAME).equals("")) {
			patient.setNextOfKinName(request.getParameter(NEXT_OF_KIN_NAME));
			objectMap.put("nok1Name", request.getParameter(NEXT_OF_KIN_NAME));
		}
		if (request.getParameter("telephoneNoPerm") != null) {
			patient.setTelephoneNoPerm(request.getParameter("telephoneNoPerm"));
			objectMap.put("telephoneNoPerm",
					request.getParameter("telephoneNoPerm"));
		}
		if (request.getParameter("otherContactNo") != null) {
			patient.setOtherContactNo(request.getParameter("otherContactNo"));
			objectMap.put("otherContactNo",
					request.getParameter("otherContactNo"));
		}
		if (request.getParameter("policeStation") != null) {
			patient.setPoliceStation(request.getParameter("policeStation"));
			objectMap.put("policeStation",
					request.getParameter("policeStation"));
		}
		if (request.getParameter("pinCode") != null) {
			patient.setPinCode(request.getParameter("pinCode"));
			objectMap.put("pinCode", request.getParameter("pinCode"));
		}
		if (request.getParameter(NEXT_OF_KIN_PHONE_NO) != null
				&& !request.getParameter(NEXT_OF_KIN_PHONE_NO).equals("")) {
			patient.setNextOfKinPhoneNumber(request
					.getParameter(NEXT_OF_KIN_PHONE_NO));
			objectMap.put("nok1Phone",
					request.getParameter(NEXT_OF_KIN_PHONE_NO));
		} else if (request.getParameter(SR_NEXT_OF_KIN_PHONE_NO) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_PHONE_NO).equals("")) {
			patient.setNextOfKinPhoneNumber(request
					.getParameter(SR_NEXT_OF_KIN_PHONE_NO));
			objectMap.put("nok1Phone",
					request.getParameter(SR_NEXT_OF_KIN_PHONE_NO));
		}
		if (request.getParameter(NEXT_OF_KIN_ADDRESS) != null
				&& !request.getParameter(NEXT_OF_KIN_ADDRESS).equals("")) {
			patient.setNextOfKinAddress(request
					.getParameter(NEXT_OF_KIN_ADDRESS).trim());
			objectMap.put("nok1Address",
					request.getParameter(NEXT_OF_KIN_ADDRESS).trim());
		} else if (request.getParameter(SR_NEXT_OF_KIN_ADDRESS) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_ADDRESS).equals("")) {
			patient.setNextOfKinAddress(request
					.getParameter(SR_NEXT_OF_KIN_ADDRESS).trim());
			objectMap.put("nok1Address",
					request.getParameter(SR_NEXT_OF_KIN_ADDRESS).trim());
		}
		if (request.getParameter(NEXT_OF_KIN_RELATION_ID) != null
				&& !request.getParameter(NEXT_OF_KIN_RELATION_ID).equals("0")) {
			int nextOfKinRelationId = Integer.parseInt(request
					.getParameter(NEXT_OF_KIN_RELATION_ID));
			MasRelation relation = new MasRelation();
			relation.setId(nextOfKinRelationId);
			patient.setNextOfKinRelation(relation);
			objectMap.put("nok1Relation", relation);
		} else if (request.getParameter(SR_NEXT_OF_KIN_RELATION_ID) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_RELATION_ID)
						.equals("0")) {
			int nextOfKinRelationId = Integer.parseInt(request
					.getParameter(SR_NEXT_OF_KIN_RELATION_ID));
			MasRelation relation = new MasRelation();
			relation.setId(nextOfKinRelationId);
			patient.setNextOfKinRelation(relation);
			objectMap.put("nok1Relation", relation);
		}

		if (request.getParameter("nok1PoliceStation") != null
				&& !request.getParameter("nok1PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("nok1PoliceStation"));
			objectMap.put("nok1PoliceStation",
					request.getParameter("nok1PoliceStation"));
		} else if (request.getParameter("srnok1PoliceStation") != null
				&& !request.getParameter("srnok1PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("srnok1PoliceStation"));
			objectMap.put("nok1PoliceStation",
					request.getParameter("srnok1PoliceStation"));
		}

		if (request.getParameter("nok1PinCode") != null
				&& !request.getParameter("nok1PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("nok1PinCode"));
			objectMap.put("nok1PinCode", request.getParameter("nok1PinCode"));
		} else if (request.getParameter("srnok1PinCode") != null
				&& !request.getParameter("srnok1PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("srnok1PinCode"));
			objectMap.put("nok1PinCode", request.getParameter("srnok1PinCode"));
		}

		if (request.getParameter("nok2Name") != null
				&& !request.getParameter("nok2Name").equals("")) {
			patient.setNok2Name(request.getParameter("nok2Name"));
			objectMap.put("nok2Name", request.getParameter("nok2Name"));
		} 
		if (request.getParameter("nok2RelationId") != null
				&& !request.getParameter("nok2RelationId").equals("0")) {
			int nok2RelationId = Integer.parseInt(request
					.getParameter("nok2RelationId"));
			MasRelation relation = new MasRelation();
			relation.setId(nok2RelationId);
			patient.setNok2Relation(relation);
			objectMap.put("nok2Relation", relation);
		} else if (request.getParameter("srnok2RelationId") != null
				&& !request.getParameter("srnok2RelationId").equals("0")) {
			int nok2RelationId = Integer.parseInt(request
					.getParameter("srnok2RelationId"));
			MasRelation relation = new MasRelation();
			relation.setId(nok2RelationId);
			patient.setNok2Relation(relation);
			objectMap.put("nok2Relation", relation);
		}

		if (request.getParameter("nok2ContactNo") != null
				&& !request.getParameter("nok2ContactNo").equals("")) {
			patient.setNok2ContactNo(request.getParameter("nok2ContactNo"));
			objectMap.put("nok2ContactNo",
					request.getParameter("nok2ContactNo"));
		} else if (request.getParameter("srnok2ContactNo") != null
				&& !request.getParameter("srnok2ContactNo").equals("")) {
			patient.setNok2ContactNo(request.getParameter("srnok2ContactNo"));
			objectMap.put("nok2ContactNo",
					request.getParameter("srnok2ContactNo"));
		}

		if (request.getParameter("nok2Address") != null
				&& !request.getParameter("nok2Address").equals("")) {
			patient.setNok2Address(request.getParameter("nok2Address").trim());
			objectMap.put("nok2Address", request.getParameter("nok2Address").trim());
		} else if (request.getParameter("srnok2Address") != null
				&& !request.getParameter("srnok2Address").equals("")) {
			patient.setNok2Address(request.getParameter("srnok2Address").trim());
			objectMap.put("nok2Address", request.getParameter("srnok2Address").trim());
		}

		if (request.getParameter("nok2PoliceStation") != null
				&& !request.getParameter("nok2PoliceStation").equals("")) {
			patient.setNok2PoliceStation(request
					.getParameter("nok2PoliceStation"));
			objectMap.put("nok2PoliceStation",
					request.getParameter("nok2PoliceStation"));
		} else if (request.getParameter("srnok2PoliceStation") != null
				&& !request.getParameter("srnok2PoliceStation").equals("")) {
			patient.setNok2PoliceStation(request
					.getParameter("srnok2PoliceStation"));
			objectMap.put("nok2PoliceStation",
					request.getParameter("srnok2PoliceStation"));
		}

		if (request.getParameter("nok2PinCode") != null
				&& !request.getParameter("nok2PinCode").equals("")) {
			patient.setNok2PinCode(request.getParameter("nok2PinCode"));
			objectMap.put("nok2PinCode", request.getParameter("nok2PinCode"));
		} else if (request.getParameter("srnok2PinCode") != null
				&& !request.getParameter("srnok2PinCode").equals("")) {
			patient.setNok2PinCode(request.getParameter("srnok2PinCode"));
			objectMap.put("nok2PinCode", request.getParameter("srnok2PinCode"));
		}
		if (request.getParameter("srMarriageDate") != null
				&& !request.getParameter("srMarriageDate").equals("")) {
			patient.setSrMarriageDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("srMarriageDate")));
			objectMap.put("srMarriageDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("srMarriageDate")));
		}
		if (request.getParameter("depMarriageDate") != null
				&& !request.getParameter("depMarriageDate").equals("")) {
			patient.setDepMarriageDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("depMarriageDate")));
			objectMap.put("depMarriageDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("depMarriageDate")));
		}
		if (request.getParameter("identificationMark1") != null) {
			patient.setSrIdentificationMark1(request
					.getParameter("identificationMark1"));
			objectMap.put("identificationMark1",
					request.getParameter("identificationMark1"));
		}
		if (request.getParameter("identificationMark2") != null) {
			patient.setSrIdentificationMark2(request
					.getParameter("identificationMark2"));
			objectMap.put("identificationMark2",
					request.getParameter("identificationMark2"));
		}
		if (request.getParameter("depIdentificationMark1") != null) {
			patient.setDepIdentificationMark1(request
					.getParameter("depIdentificationMark1"));
			objectMap.put("depIdentificationMark1",
					request.getParameter("depIdentificationMark1"));
		}
		if (request.getParameter("depIdentificationMark2") != null) {
			patient.setDepIdentificationMark2(request
					.getParameter("depIdentificationMark2"));
			objectMap.put("depIdentificationMark2",
					request.getParameter("depIdentificationMark2"));
		}
		/*
		 * if (serTypeId == 7) { MasRelation masRelation = new MasRelation();
		 * masRelation.setId(8); patient.setRelation(masRelation);
		 * patient.setRank(new MasRank(179)); patient.setUnit(new MasUnit(257));
		 * } else { if (request.getParameter(RELATION_ID) != null &&
		 * !request.getParameter(RELATION_ID).equals("0")) {
		 * servicePersonRelationId =
		 * Integer.parseInt(request.getParameter(RELATION_ID)); MasRelation
		 * masRelation = new MasRelation();
		 * masRelation.setId(servicePersonRelationId);
		 * patient.setRelation(masRelation); }else{ MasRelation masRelation =
		 * new MasRelation(); masRelation.setId(8);
		 * patient.setRelation(masRelation); } }
		 */
		/*
		 * if (!request.getParameter(TITLE).equals("0")) { int titleId =
		 * Integer.parseInt(request.getParameter(TITLE)); MasTitle masTitle =
		 * new MasTitle(); masTitle.setId(titleId); patient.setTitle(masTitle);
		 * }
		 */
		patient.setPFirstName((request.getParameter(P_FIRST_NAME).trim())
				.toUpperCase());
		objectMap.put("pFirstName",
				(request.getParameter(P_FIRST_NAME).trim()).toUpperCase());
		if (request.getParameter(P_MIDDLE_NAME) != null) {
			patient.setPMiddleName((request.getParameter(P_MIDDLE_NAME).trim())
					.toUpperCase());
			objectMap.put("pMiddleName",
					(request.getParameter(P_MIDDLE_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(P_LAST_NAME) != null) {
			patient.setPLastName((request.getParameter(P_LAST_NAME).trim())
					.toUpperCase());
			objectMap.put("pLastName",
					(request.getParameter(P_LAST_NAME).trim()).toUpperCase());
		}
		if (!request.getParameter(GENDER).equals("0")) {
			int genderId = Integer.parseInt(request.getParameter(GENDER));
			MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
			masAdministrativeSex.setId(genderId);
			patient.setSex(masAdministrativeSex);
			objectMap.put("pSex", masAdministrativeSex);
		}
		String age = "";
		if (request.getParameter(AGE) != null) {
			if (request.getParameter(AGE_UNIT) != null) {
				String ageUnit = request.getParameter(AGE_UNIT);
				age = request.getParameter(AGE).concat(" ").concat(ageUnit);
				patient.setAge(age);
				objectMap.put("pAge", age);
			}
		}
		System.out.println(request.getParameter(AGE));
		if (request.getParameter("ageLabel") != null
				&& !(request.getParameter("ageLabel").equals(""))) {
			age = request.getParameter("ageLabel");
			patient.setAge(age);
		}
		if (request.getParameter("srDob") != null
				&& !(request.getParameter("srDob").equals(""))) {
			Date dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("srDob"));
			patient.setDateOfBirth(dateOfBirth);
			objectMap.put("pDob", dateOfBirth);
		}

		if (request.getParameter(MARITAL_STATUS_ID) != null
				&& !request.getParameter(MARITAL_STATUS_ID).equals("0")) {
			int maritalStatusId = Integer.parseInt(request
					.getParameter(MARITAL_STATUS_ID));
			MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
			masMaritalStatus.setId(maritalStatusId);
			patient.setMaritalStatus(masMaritalStatus);
			objectMap.put("ptMaritalStatus", masMaritalStatus);
		}
		
		if (request.getParameter("dependencyDate") != null
				&& !(request.getParameter("dependencyDate").equals(""))) {
			patient.setDependencyDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyDate")));
			objectMap.put("dependencyDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyDate")));
		}
		if (request.getParameter("authority") != null) {
			patient.setAuthority(request.getParameter("authority"));
			objectMap.put("authority", request.getParameter("authority"));
		}
		if (request.getParameter("dependencyRemovalDate") != null
				&& !(request.getParameter("dependencyRemovalDate").equals(""))) {
			patient.setDependencyRemovalDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyRemovalDate")));
			objectMap.put("dependencyRemovalDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyRemovalDate")));
		}
		if (request.getParameter(DISTRICT) != null
				&& !request.getParameter(DISTRICT).equals("0")) {
			int districtId = Integer.parseInt(request.getParameter(DISTRICT));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			patient.setDistrict(masDistrict);
			objectMap.put("masDistrict", masDistrict);
		}
		if (request.getParameter(ADDRESS) != null) {
			patient.setAddress(request.getParameter(ADDRESS));
			objectMap.put("address", request.getParameter(ADDRESS));
		}

		if (request.getParameter(CONTACT_NUMBER) != null) {
			patient.setContactNo(request.getParameter(CONTACT_NUMBER));
			objectMap.put("contactNo", request.getParameter(CONTACT_NUMBER));
		}

		if (request.getParameter(STATE) != null
				&& !request.getParameter(STATE).equals("0")) {
			int stateId = Integer.parseInt(request.getParameter(STATE));
			MasState masState = new MasState();
			masState.setId(stateId);
			patient.setState(masState);
			objectMap.put("masState", masState);
		}
		Date addEditDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			patient.setAddEditDate(addEditDate);
		}

		String addEditTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			addEditTime = request.getParameter(CHANGED_TIME);
			patient.setAddEditTime(addEditTime);
		}

		Date regDate = null;
		if (request.getParameter(REG_DATE) != null) {
			regDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(REG_DATE));
			patient.setRegDate(regDate);
		}
		String regTime = "";
		if (request.getParameter(REG_TIME) != null) {
			regTime = request.getParameter(REG_TIME);
			patient.setRegTime(regTime);
		}

		if (request.getParameter("smokerLess10") != null
				|| request.getParameter("srsmokerLess10") != null) {
			patient.setSmokerLess10("y");
			objectMap.put("smokerLess10", "y");
		} else {
			patient.setSmokerLess10("n");
			objectMap.put("smokerLess10", "n");
		}
		if (request.getParameter("smokerMore10") != null
				|| request.getParameter("smokerMore10") != null) {
			patient.setSmokerMore10("y");
			objectMap.put("smokerMore10", "y");
		} else {
			patient.setSmokerMore10("n");
			objectMap.put("smokerMore10", "n");
		}

		if (request.getParameter("alcohol") != null
				&& !request.getParameter("alcohol").equals("")) {
			patient.setAlcohol(request.getParameter("alcohol"));
			objectMap.put("alcohol", request.getParameter("alcohol"));
		} else if (request.getParameter("sralcohol") != null
				&& !request.getParameter("sralcohol").equals("")) {
			patient.setAlcohol(request.getParameter("sralcohol"));
			objectMap.put("alcohol", request.getParameter("sralcohol"));
		}
		if (request.getParameter("otherFamilyHistory") != null
				&& !request.getParameter("otherFamilyHistory").equals("")) {
			patient.setOtherFamilyHistory(request
					.getParameter("otherFamilyHistory"));
			objectMap.put("otherFamilyHistory",
					request.getParameter("otherFamilyHistory"));
		} else if (request.getParameter("otherSrFamilyHistory") != null
				&& !request.getParameter("otherSrFamilyHistory").equals("")) {
			patient.setOtherFamilyHistory(request
					.getParameter("otherSrFamilyHistory"));
			objectMap.put("otherFamilyHistory",
					request.getParameter("otherSrFamilyHistory"));
		}

		if (request.getParameter("allergies") != null) {
			patient.setDrugAllergies(request.getParameter("allergies"));
			objectMap.put("allergies", request.getParameter("allergies"));
		}
		if (request.getParameter("srAllergies") != null) {
			patient.setDrugAllergies(request.getParameter("srAllergies"));
			objectMap.put("srallergies", request.getParameter("srAllergies"));
		}
		/**
		 * Commented By Ritu Single family history not required
		 */
		/*
		 * if(request.getParameter("familyHistory") != null &&
		 * !request.getParameter("familyHistory").equals("0")){
		 * PatientFamilyHistory familyHistory = new PatientFamilyHistory();
		 * familyHistory
		 * .setId(Integer.parseInt(request.getParameter("familyHistory")));
		 * patient.setFamilyHistory(familyHistory); }
		 */

		/**
		 * Added By Ritu for multiple family history
		 */
		String[] familyHistoryArray = null;
		if (request.getParameterValues("familyHistory") != null) {
			familyHistoryArray = request.getParameterValues("familyHistory");
			objectMap.put("familyHistoryArray", familyHistoryArray);
		} else if (request.getParameterValues("srfamilyHistory") != null) {
			familyHistoryArray = request.getParameterValues("srfamilyHistory");
			objectMap.put("familyHistoryArray", familyHistoryArray);
		}
		/**
		 * End
		 */

		if (request.getParameter("presentMedCat") != null
				&& !request.getParameter("presentMedCat").equals("0")) {
			Category category = new Category();
			category.setCategoryid(Integer.parseInt(request
					.getParameter("presentMedCat")));
			patient.setCategory(category);
			objectMap.put("category", category);
		}
		/*
		 * if(request.getParameter("medCatPeriod") != null &&
		 * !request.getParameter("medCatPeriod").equals("")){
		 * patient.setMedCatPeriod(request.getParameter("medCatPeriod"));
		 * objectMap.put("medCatPeriod", request.getParameter("medCatPeriod"));
		 * }Commented by dipali
		 */
		// ---Addd By dipali as discussed with Anshu (05-mar-2013)
		if (request.getParameter("medCatPeriod") != null
				&& !request.getParameter("medCatPeriod").equals("")) {
			if (request.getParameter("medCatDuration") != null) {
				String medCatDuration = request.getParameter("medCatDuration");
				String finalMedCat = request.getParameter("medCatPeriod")
						.concat(" ").concat(medCatDuration);
				patient.setMedCatPeriod(finalMedCat);
				objectMap.put("medCatPeriod", finalMedCat);
			}
		}// --------

		if (request.getParameter("medCatDate") != null
				&& !request.getParameter("medCatDate").equals("")) {
			patient.setMedCatDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("medCatDate")));
			objectMap.put("medCatDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("medCatDate")));
		}
		if (request.getParameter("echs") != null) {
			patient.setEchsNo(request.getParameter("echs"));
			objectMap.put("echs", request.getParameter("echs"));
		}
		patient.setHospital(masHospital);
		patient.setStatus("y");
		patient.setPatientStatus("Out Patient");
		patient.setInpatientNo(0);
		if (request.getParameter("img1") != null
				&& !request.getParameter("img1").equals("")) {
			map.put("img1", request.getParameter("img1"));
		}
		map.put("regFlag", "reg");

		String[] rptForArr = null;
		if (request.getParameterValues("reportingFor") != null) {
			rptForArr = request.getParameterValues("reportingFor");
			objectMap.put("rptForArr", rptForArr);
		}
	
		if (request.getParameter("regHinId") != null
				&& !request.getParameter("regHinId").equals("0")
				&& !request.getParameter("regHinId").equals("")) {
			objectMap.put("regHinId",
					Integer.parseInt(request.getParameter("regHinId")));
		} else if (request.getParameter("selfRegHin") != null
				&& !request.getParameter("selfRegHin").equals("")
				&& !request.getParameter("selfRegHin").equals("")) {
			objectMap.put("selfRegHin",
					Integer.parseInt(request.getParameter("selfRegHin")));
		}

		/**
		 * Code for Immunization
		 */

		/*
		 * int immCount =0; if(request.getParameter("immCount")!=null &&
		 * !(request.getParameter("immCount").equals(""))){ immCount =
		 * Integer.parseInt(request.getParameter("immCount")); } if(immCount
		 * >0){ List<Integer> immuDtIdList = new ArrayList<Integer>();
		 * List<String> immuNameList = new ArrayList<String>(); List<Integer>
		 * immunizationIdList = new ArrayList<Integer>(); List<String> dateList
		 * = new ArrayList<String>(); List<String> doseList = new
		 * ArrayList<String>(); List<String> routeList = new
		 * ArrayList<String>(); List<String> batchNoList = new
		 * ArrayList<String>(); List<String> domList = new ArrayList<String>();
		 * List<String> doeList = new ArrayList<String>();
		 * 
		 * for (int j = 1; j <= immCount; j++) {
		 * if(request.getParameter("immunId"+j)!=null &&
		 * !request.getParameter("immunId"+j).equals("")){
		 * immuDtIdList.add(Integer
		 * .parseInt(request.getParameter("immunId"+j))); }else{
		 * immuDtIdList.add(0); }
		 * if(request.getParameter("immunizationName"+j)!=null){
		 * immuNameList.add(request.getParameter("immunizationName"+j)); }
		 * if(request.getParameter("immunizationId"+j)!=null &&
		 * !request.getParameter("immunizationId"+j).equals("")){
		 * immunizationIdList
		 * .add(Integer.parseInt(request.getParameter("immunizationId"+j))); }
		 * 
		 * if(request.getParameter("vdate"+j)!=null){
		 * dateList.add(request.getParameter("vdate"+j)); }
		 * if(request.getParameter("dose"+j)!=null){
		 * doseList.add(request.getParameter("dose"+j)); }
		 * if(request.getParameter("route"+j)!=null){
		 * routeList.add(request.getParameter("route"+j)); }
		 * if(request.getParameter("batchNo"+j)!=null){
		 * batchNoList.add(request.getParameter("batchNo"+j)); }
		 * if(request.getParameter("dom"+j)!=null){
		 * domList.add(request.getParameter("dom"+j)); }
		 * if(request.getParameter("doe"+j)!=null){
		 * doeList.add(request.getParameter("doe"+j)); }
		 * 
		 * } objectMap.put("immuDtIdList", immuDtIdList);
		 * objectMap.put("immuNameList", immuNameList);
		 * objectMap.put("dateList", dateList); objectMap.put("doseList",
		 * doseList); objectMap.put("routeList", routeList);
		 * objectMap.put("batchNoList", batchNoList); objectMap.put("domList",
		 * domList); objectMap.put("doeList", doeList);
		 * objectMap.put("immunizationIdList", immunizationIdList); }
		 * objectMap.put("masHospital", masHospital);
		 */
		/**
		 * 
		 */

		/**
		 * Code for Allergies
		 */

		int allergyCount = 0;
		if (request.getParameter("allergyCount") != null
				&& !(request.getParameter("allergyCount").equals(""))) {
			allergyCount = Integer.parseInt(request
					.getParameter("allergyCount"));
		}
		// System.out.println("allergyCount  - "+allergyCount);
		if (allergyCount > 0) {
			List<Integer> allergyDetailsIdList = new ArrayList<Integer>();
			List<String> allergyNameList = new ArrayList<String>();
			List<String> descList = new ArrayList<String>();
			List<String> severityList = new ArrayList<String>();
			List<String> sinceList = new ArrayList<String>();
			List<String> remarksList = new ArrayList<String>();

			for (int j = 1; j <= allergyCount; j++) {
				if (request.getParameter("allergyDetailsId" + j) != null
						&& !request.getParameter("allergyDetailsId" + j)
								.equals("")) {
					allergyDetailsIdList.add(Integer.parseInt(request
							.getParameter("allergyDetailsId" + j)));
				} else {
					allergyDetailsIdList.add(0);
				}
				if (request.getParameter("allergyName" + j) != null
						&& !request.getParameter("allergyName" + j).equals("")) {
					allergyNameList
							.add(request.getParameter("allergyName" + j));
				}
				if (request.getParameter("description" + j) != null) {
					descList.add(request.getParameter("description" + j));
				}
				if (request.getParameter("severity" + j) != null) {
					severityList.add(request.getParameter("severity" + j));
				}
				if (request.getParameter("since" + j) != null) {
					sinceList.add(request.getParameter("since" + j));
				}
				if (request.getParameter("remarks" + j) != null) {
					remarksList.add(request.getParameter("remarks" + j));
				}

			}
			objectMap.put("allergyDetailsIdList", allergyDetailsIdList);
			objectMap.put("allergyNameList", allergyNameList);
			objectMap.put("descList", descList);
			objectMap.put("severityList", severityList);
			objectMap.put("sinceList", sinceList);
			objectMap.put("remarksList", remarksList);

		}
		if (request.getParameter("ldapData") != null) {
			objectMap.put("ldapData", request.getParameter("ldapData"));
		}
		if (request.getParameter("patientTypeName") != null) {
			objectMap.put("patientTypeName",
					request.getParameter("patientTypeName"));
		}
		/**
		 * 
		 */
		objectMap.put("hinNo", hinNo);
		objectMap.put("patient", patient);

		Box box = HMSUtil.getBox(request);
		objectMap.put("box", box);
		String userSrNo = (String) session.getAttribute("userSrNo");
		objectMap.put("userSrNo", userSrNo);

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;
		List<Patient> existingHinNoList = new ArrayList<Patient>();
		List<Visit> visitList = new ArrayList<Visit>();

		detailsMap = registrationHandlerService
				.submitPatientInformationHAL(objectMap);
		/*
		 * if (detailsMap.get("visitList") != null) { visitList = (List<Visit>)
		 * detailsMap.get("visitList"); map.put("visitList", visitList); }
		 */

		if (detailsMap.get("existingHinNoList") != null) {
			existingHinNoList = (List<Patient>) detailsMap
					.get("existingHinNoList");
		}
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true && existingHinNoList.size() == 0) {
			if (request.getParameter(HIN_NO) == null
					|| request.getParameter(HIN_NO).equals("")) {
				if (request.getParameter("selfHinNo") != null
						&& !request.getParameter("selfHinNo").equals("")) {
					map.put("hinNo", request.getParameter("selfHinNo"));
				}
				if (rptForArr != null && rptForArr.length > 0) {
					message = " Visit Information saved Successfully.";
				} else {
					message = " Patient Information Saved Successfully.";
				}
				map.put("regHinId", request.getParameter("regHinId"));
				map.put("hinNo", request.getParameter("printHinNo"));

			} else {
				message = " Registration Information Saved Successfully.";
				map.put("hinNo", hinNo);
			}
			map.put("serviceNo", serviceNo);

			if (request.getParameter("image") != null) {
				uploadPhoto(request);
			}
		} else if (existingHinNoList.size() > 0) {
			message = "Data can not be saved.This Hin is already exists.";
		} else {
			message = "Some problem Occured! Try Again.";
		}
		
		dataMap.put("users", user);
	
		/*
		 * if(request.getParameter("flag").equals("registration")){
		 * jsp.append(MSG_FOR_REG);
		 * 
		 * }else if(request.getParameter("flag").equals("medicalExam")){
		 * jsp.append(MSG_FOR_REG); }
		 * 
		 * jsp.append(".jsp");
		 */
		String jsp = "msgForRegHAL.jsp";
		map.put("contentJsp", jsp);		
		map.put("message", message);
		map.put("hinNo", objectMap.get("hinNo"));
		map.put("existingHinNoList", existingHinNoList);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView updateOtherPatientInformation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Patient patient = new Patient();

		int servicePersonRelationId = 0;
		int serTypeId = 0;
		String hinNo = "";
		String serviceNo = "";
		Map<String, Object> objectMap = new HashMap<String, Object>();

		Users user = (Users) session.getAttribute("users");
		patient.setAddEditBy(user);
		objectMap.put("user", user);

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);

		/*if (request.getParameter(HIN_NO) != null) {
			hinNo = getHinNoHALDynamic(request, response);
			patient.setHinNo(hinNo);
			patient.setPreviousHinNo(hinNo);

		}*/
		/*
		 * if (request.getParameter(SERVICE_NO) != null) { serviceNo =
		 * HMSUtil.restrictMetaChar(request.getParameter(SERVICE_NO)); //
		 * serviceNo = request.getParameter(SERVICE_NO);
		 * patient.setServiceNo(serviceNo.trim());
		 * 
		 * }
		 */
		/*
		 * MasServiceType masServiceType = new MasServiceType(); serTypeId =
		 * Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
		 * masServiceType
		 * .setId(Integer.parseInt(request.getParameter(SERVICE_TYPE_ID)));
		 * patient.setServiceType(masServiceType);
		 */

		/*
		 * String suffix = ""; if (request.getParameter(SUFFIX) != null&&
		 * !request.getParameter(SUFFIX).equals("")) { suffix =
		 * HMSUtil.restrictMetaChar(request.getParameter(SUFFIX)); // suffix =
		 * request.getParameter(SUFFIX); } patient.setSuffix(suffix);
		 * objectMap.put("suffix", suffix);
		 */
		/*
		 * String prefix = ""; if (request.getParameter(PREFIX) != null &&
		 * !request.getParameter(PREFIX).equals("")) { prefix =
		 * HMSUtil.restrictMetaChar(request.getParameter(PREFIX)); // prefix =
		 * request.getParameter(PREFIX); } patient.setPrefix(prefix.trim());
		 * objectMap.put("prefix", prefix);
		 */
		int serviceStatusId = 0;
		if (request.getParameter(SERVICE_STATUS_ID) != null
				&& !request.getParameter(SERVICE_STATUS_ID).equals("0")) {
			serviceStatusId = Integer.parseInt(request
					.getParameter(SERVICE_STATUS_ID));
			MasServiceStatus masServiceStatus = new MasServiceStatus();
			masServiceStatus.setId(serviceStatusId);
			patient.setServiceStatus(masServiceStatus);
		}

		/*
		 * if (request.getParameter(RANK_ID) != null &&
		 * !request.getParameter(RANK_ID).equals("0")) { int rankId =
		 * Integer.parseInt(request.getParameter(RANK_ID)); MasRank masRank =
		 * new MasRank(); masRank.setId(rankId); patient.setRank(masRank);
		 * objectMap.put("masRank",masRank); }
		 */
		if (request.getParameter(S_FIRST_NAME) != null) {
			patient.setSFirstName((request.getParameter(S_FIRST_NAME).trim())
					.toUpperCase());
			objectMap.put("sFirstName",
					(request.getParameter(S_FIRST_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(S_MIDDLE_NAME) != null) {
			patient.setSMiddleName((request.getParameter(S_MIDDLE_NAME).trim())
					.toUpperCase());
			objectMap.put("sMiddleName",
					(request.getParameter(S_MIDDLE_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(S_LAST_NAME) != null) {
			patient.setSLastName((request.getParameter(S_LAST_NAME).trim())
					.toUpperCase());
			objectMap.put("sLastName",
					(request.getParameter(S_LAST_NAME).trim()).toUpperCase());
		}
		
	    /* patient.setBillable(null);*/
	    /* patient.setPaymentStatus(null); */

		/*
		 * if (request.getParameter(TRADE_ID) != null &&
		 * !request.getParameter(TRADE_ID).equals("0")) {
		 * if(!request.getParameter(TRADE_ID).equals("31")){ // for other int
		 * tradeId = Integer.parseInt(request.getParameter(TRADE_ID)); MasTrade
		 * masTrade = new MasTrade(); masTrade.setId(tradeId);
		 * patient.setTrade(masTrade); objectMap.put("masTrade",masTrade); }
		 * else if (request.getParameter(TRADE_NAME)!= null &&
		 * !request.getParameter(TRADE_NAME).equals("")) { MasTrade masTradeObj
		 * = new MasTrade();
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request .getParameter(TRADE_NAME) + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masTradeObj .setTradeName("" + output_str2);
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) { masTradeObj
		 * .setLastChgBy(request.getParameter(CHANGED_BY)); }
		 * 
		 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE));
		 * masTradeObj.setLastChgDate(changedDate);
		 * masTradeObj.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masTradeObj.setStatus("n");
		 * 
		 * objectMap.put("masTradeObj", masTradeObj ); } }
		 */
		if (request.getParameter(RECORD_OFFICE_ADDRESS_ID) != null
				&& !request.getParameter(RECORD_OFFICE_ADDRESS_ID).equals("0")) {
			int recordOfficeAddId = Integer.parseInt(request
					.getParameter(RECORD_OFFICE_ADDRESS_ID));
			MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
			masRecordOfficeAddress.setId(recordOfficeAddId);
			patient.setRecordOfficeAddress(masRecordOfficeAddress);
			objectMap.put("masRecordOfficeAddress", masRecordOfficeAddress);
		}
		/*
		 * if (request.getParameter(UNIT_ID) != null &&
		 * !request.getParameter(UNIT_ID).equals("0")) {
		 * if(!request.getParameter(UNIT_ID).equals("other")){ int unitId =
		 * Integer.parseInt(request.getParameter(UNIT_ID)); MasUnit masUnit =
		 * new MasUnit(); masUnit.setId(unitId); patient.setUnit(masUnit);
		 * objectMap.put("masUnit",masUnit); } else if
		 * (request.getParameter(UNIT_NAME)!=null &&
		 * !request.getParameter(UNIT_NAME).equals("")) { MasUnit masUnitObj =
		 * new MasUnit(); if (request.getParameter(UNIT_NAME) != null) {
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request .getParameter(UNIT_NAME) + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masUnitObj.setUnitName("" + output_str2); } if
		 * (request.getParameter(UNIT_ADDRESS) != null) {
		 * 
		 * StringBuffer output_str3 = new StringBuffer(); StringTokenizer s3 =
		 * new StringTokenizer(request .getParameter(UNIT_ADDRESS) + "", "\'");
		 * 
		 * while (s3.hasMoreTokens()) { output_str3.append(s3.nextToken()); if
		 * (s3.hasMoreTokens()) { output_str3.append(" "); } }
		 * 
		 * StringBuffer output_str4 = new StringBuffer(); StringTokenizer s4 =
		 * new StringTokenizer(output_str3 + "", "\"");
		 * 
		 * while (s4.hasMoreTokens()) { output_str4.append(s4.nextToken()); if
		 * (s4.hasMoreTokens()) { output_str4.append(" "); } }
		 * masUnitObj.setUnitAddress("" + output_str4); }
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) {
		 * masUnitObj.setLastChgBy(request.getParameter(CHANGED_BY)); } if
		 * (request.getParameter(LOCAL_UNIT) != null) {
		 * masUnitObj.setLocalUnit("y"); } else { masUnitObj.setLocalUnit("n");
		 * } Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE)); masUnitObj.setLastChgDate(changedDate);
		 * masUnitObj.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masUnitObj.setStatus("n"); objectMap.put("masUnitObj", masUnitObj); }
		 * }
		 */

		/*
		 * if(serviceStatusId == 2){ MasUnit masUnit = new MasUnit();
		 * masUnit.setId(257); patient.setUnit(masUnit); }
		 */

		/*
		 * if(request.getParameter("commissionDate") != null &&
		 * !(request.getParameter("commissionDate").equals(""))){
		 * patient.setCommissionDate
		 * (HMSUtil.convertStringTypeDateToDateType(request
		 * .getParameter("commissionDate")));
		 * objectMap.put("commisionDate",HMSUtil
		 * .convertStringTypeDateToDateType(
		 * request.getParameter("commissionDate"))); } if
		 * (request.getParameter(TOTAL_SERVICE) != null &&
		 * !request.getParameter(TOTAL_SERVICE).equals("")) {
		 * patient.setServiceYears(Float.parseFloat(request
		 * .getParameter(TOTAL_SERVICE)));
		 * objectMap.put("totalService",Float.parseFloat(request
		 * .getParameter(TOTAL_SERVICE))); } if
		 * (request.getParameter(TOTAL_SERVICE_PERIOD) != null &&
		 * !request.getParameter(TOTAL_SERVICE_PERIOD).equals("")) {
		 * patient.setTotalServicePeriod(request
		 * .getParameter(TOTAL_SERVICE_PERIOD)); } if
		 * (request.getParameter(STATION) != null &&
		 * !request.getParameter(STATION).equals("")) { if(
		 * !request.getParameter(STATION).equals("other")){
		 * patient.setStation(request.getParameter(STATION));
		 * objectMap.put("station", request.getParameter(STATION)); }else
		 * if(request.getParameter("stationName") != null){
		 * patient.setStation(request.getParameter("stationName"));
		 * 
		 * MasStation masStation = new MasStation();
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request .getParameter("stationName") + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masStation.setStationName("" + output_str2);
		 * masStation.setStationCode(output_str2.substring(0, 3));
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) { masStation
		 * .setLastChgBy(user); }
		 * 
		 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE)); masStation.setLastChgDate(changedDate);
		 * masStation.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masStation.setStatus("n");
		 * 
		 * objectMap.put("masStation", masStation );
		 * 
		 * } }
		 */
		/*
		 * if(request.getParameter(COMMAND) != null &&
		 * !(request.getParameter(COMMAND).equals("0"))){
		 * if(!(request.getParameter(COMMAND).equals("other"))){ MasCommand
		 * command = new MasCommand();
		 * command.setId(Integer.parseInt(request.getParameter(COMMAND)));
		 * patient.setCommand(command); objectMap.put("command", command); }else
		 * if (request.getParameter("commandName")!= null &&
		 * !request.getParameter("commandName").equals("")) { MasCommand
		 * masCommand = new MasCommand();
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request.getParameter("commandName") + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masCommand.setCommandName("" + output_str2);
		 * masCommand.setCommandCode(output_str2.substring(0, 3));
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) {
		 * masCommand.setLastChgBy(user); }
		 * 
		 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE)); masCommand.setLastChgDate(changedDate);
		 * masCommand.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masCommand.setStatus("n");
		 * 
		 * objectMap.put("masCommand", masCommand ); } }
		 * if(request.getParameter(SECTION_ID) != null &&
		 * !(request.getParameter(SECTION_ID).equals("0"))){
		 * if(!(request.getParameter(SECTION_ID).equals("other"))){ MasSection
		 * section = new MasSection();
		 * section.setId(Integer.parseInt(request.getParameter(SECTION_ID)));
		 * patient.setSection(section); objectMap.put("section", section); }else
		 * if (request.getParameter("sectionName")!= null &&
		 * !request.getParameter("sectionName").equals("")) { MasSection
		 * masSection = new MasSection();
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request.getParameter("sectionName") + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masSection.setSectionName("" + output_str2);
		 * masSection.setSectionCode(output_str2.substring(0, 3));
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) {
		 * masSection.setLastChgBy(user); }
		 * 
		 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE)); masSection.setLastChgDate(changedDate);
		 * masSection.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masSection.setStatus("y"); masSection.setHospital(masHospital);
		 * 
		 * objectMap.put("masSection", masSection ); } }
		 */

		if (request.getParameter(SR_SEX) != null
				&& !(request.getParameter(SR_SEX).equals("0"))) {
			MasAdministrativeSex admsex = new MasAdministrativeSex();
			admsex.setId(Integer.parseInt(request.getParameter(SR_SEX)));
			patient.setSrSex(admsex);
			objectMap.put("srSex", admsex);
		}

		if (request.getParameter(SR_AGE) != null) {
			if (request.getParameter(SR_AGE_UNIT) != null) {
				String ageUnit = request.getParameter(SR_AGE_UNIT);
				String srage = request.getParameter(SR_AGE).concat(" ")
						.concat(ageUnit);
				patient.setSrAge(srage);
				objectMap.put("srAge", srage);
			}
		}
		if (request.getParameter(SR_DOB) != null
				&& !(request.getParameter(SR_DOB).equals(""))) {
			patient.setSrDob(HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(SR_DOB)));
			objectMap.put("srDob", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(SR_DOB)));
		}

		if (request.getParameter("srMaritalStatus") != null
				&& !(request.getParameter("srMaritalStatus").equals("0"))) {
			MasMaritalStatus maritalStatus = new MasMaritalStatus();
			maritalStatus.setId(Integer.parseInt(request
					.getParameter("srMaritalStatus")));
			patient.setSrMaritalStatus(maritalStatus);
			objectMap.put("maritalStatus", maritalStatus);
		}
		
		if (request.getParameter("categoryId") != null
				&& !(request.getParameter("categoryId").equals("0"))) {
			MasOthersCategory othersCategory = new MasOthersCategory();
			othersCategory.setId(Integer.parseInt(request
					.getParameter("categoryId")));
			patient.setOthersCategory(othersCategory);
			objectMap.put("othersCategory", othersCategory);
		}

		/*
		 * if (request.getParameter(SERV_BLD_GROUP) != null &&
		 * !request.getParameter(SERV_BLD_GROUP).equals("0")) { int bldGrpId =
		 * Integer.parseInt(request .getParameter(SERV_BLD_GROUP));
		 * MasBloodGroup masBloodGroup = new MasBloodGroup();
		 * masBloodGroup.setId(bldGrpId);
		 * patient.setSrBloodGroup(masBloodGroup);
		 * objectMap.put("masBloodGroup", masBloodGroup ); }
		 */
		if (request.getParameter(RELIGION_ID) != null
				&& !request.getParameter(RELIGION_ID).equals("0")) {
			int religionId = Integer
					.parseInt(request.getParameter(RELIGION_ID));
			MasReligion masReligion = new MasReligion();
			masReligion.setId(religionId);
			patient.setReligion(masReligion);
			objectMap.put("masReligion", masReligion);
		}

		if (request.getParameter(TELEPHONE_NO) != null) {
			patient.setPhoneNumber(request.getParameter(TELEPHONE_NO));
			objectMap.put("telephoneNo", request.getParameter(TELEPHONE_NO));
		}
		if (request.getParameter(MOBILE_NO) != null) {
			patient.setMobileNumber(request.getParameter(MOBILE_NO));
			objectMap.put("mobileNo", request.getParameter(MOBILE_NO));
		}
		if (request.getParameter("afnetNo") != null) {
			patient.setAfnetNo(request.getParameter("afnetNo"));
			objectMap.put("afnetNo", request.getParameter("afnetNo"));
		}

		if (request.getParameter(PERMANENT_ADDRESS) != null) {
			patient.setPermanentAddress(request.getParameter(PERMANENT_ADDRESS));
			objectMap.put("permanentAddress",
					request.getParameter(PERMANENT_ADDRESS));
		}
		if (request.getParameter("phoneNoRes") != null) {
			patient.setTelephoneResi(request.getParameter("phoneNoRes"));
			objectMap.put("telephoneResi", request.getParameter("phoneNoRes"));
		}
		if (request.getParameter("permCityId") != null
				&& !request.getParameter("permCityId").equals("0")) {
			MasDistrict district = new MasDistrict();
			district.setId(Integer.parseInt(request.getParameter("permCityId")));
			patient.setPermanentCity(district);
			objectMap.put("permanentCity", district);
		}
		if (request.getParameter("permStateId") != null
				&& !request.getParameter("permStateId").equals("0")) {
			MasState state = new MasState();
			state.setId(Integer.parseInt(request.getParameter("permStateId")));
			patient.setPermanentState(state);
			objectMap.put("permanentState", state);
		}
		if (request.getParameter(NEXT_OF_KIN_NAME) != null
				&& !request.getParameter(NEXT_OF_KIN_NAME).equals("")) {
			patient.setNextOfKinName(request.getParameter(NEXT_OF_KIN_NAME));
			objectMap.put("nok1Name", request.getParameter(NEXT_OF_KIN_NAME));
		} 
		if (request.getParameter("telephoneNoPerm") != null) {
			patient.setTelephoneNoPerm(request.getParameter("telephoneNoPerm"));
			objectMap.put("telephoneNoPerm",
					request.getParameter("telephoneNoPerm"));
		}
		if (request.getParameter("otherContactNo") != null) {
			patient.setOtherContactNo(request.getParameter("otherContactNo"));
			objectMap.put("otherContactNo",
					request.getParameter("otherContactNo"));
		}
		if (request.getParameter("policeStation") != null) {
			patient.setPoliceStation(request.getParameter("policeStation"));
			objectMap.put("policeStation",
					request.getParameter("policeStation"));
		}
		if (request.getParameter("pinCode") != null) {
			patient.setPinCode(request.getParameter("pinCode"));
			objectMap.put("pinCode", request.getParameter("pinCode"));
		}
		if (request.getParameter(NEXT_OF_KIN_PHONE_NO) != null
				&& !request.getParameter(NEXT_OF_KIN_PHONE_NO).equals("")) {
			patient.setNextOfKinPhoneNumber(request
					.getParameter(NEXT_OF_KIN_PHONE_NO));
			objectMap.put("nok1Phone",
					request.getParameter(NEXT_OF_KIN_PHONE_NO));
		} else if (request.getParameter(SR_NEXT_OF_KIN_PHONE_NO) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_PHONE_NO).equals("")) {
			patient.setNextOfKinPhoneNumber(request
					.getParameter(SR_NEXT_OF_KIN_PHONE_NO));
			objectMap.put("nok1Phone",
					request.getParameter(SR_NEXT_OF_KIN_PHONE_NO));
		}
		if (request.getParameter(NEXT_OF_KIN_ADDRESS) != null
				&& !request.getParameter(NEXT_OF_KIN_ADDRESS).equals("")) {
			patient.setNextOfKinAddress(request
					.getParameter(NEXT_OF_KIN_ADDRESS));
			objectMap.put("nok1Address",
					request.getParameter(NEXT_OF_KIN_ADDRESS));
		} else if (request.getParameter(SR_NEXT_OF_KIN_ADDRESS) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_ADDRESS).equals("")) {
			patient.setNextOfKinAddress(request
					.getParameter(SR_NEXT_OF_KIN_ADDRESS));
			objectMap.put("nok1Address",
					request.getParameter(SR_NEXT_OF_KIN_ADDRESS));
		}
		if (request.getParameter(NEXT_OF_KIN_RELATION_ID) != null
				&& !request.getParameter(NEXT_OF_KIN_RELATION_ID).equals("0")) {
			int nextOfKinRelationId = Integer.parseInt(request
					.getParameter(NEXT_OF_KIN_RELATION_ID));
			MasRelation relation = new MasRelation();
			relation.setId(nextOfKinRelationId);
			patient.setNextOfKinRelation(relation);
			objectMap.put("nok1Relation", relation);
		} else if (request.getParameter(SR_NEXT_OF_KIN_RELATION_ID) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_RELATION_ID)
						.equals("0")) {
			int nextOfKinRelationId = Integer.parseInt(request
					.getParameter(SR_NEXT_OF_KIN_RELATION_ID));
			MasRelation relation = new MasRelation();
			relation.setId(nextOfKinRelationId);
			patient.setNextOfKinRelation(relation);
			objectMap.put("nok1Relation", relation);
		}

		if (request.getParameter("nok1PoliceStation") != null
				&& !request.getParameter("nok1PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("nok1PoliceStation"));
			objectMap.put("nok1PoliceStation",
					request.getParameter("nok1PoliceStation"));
		} else if (request.getParameter("srnok1PoliceStation") != null
				&& !request.getParameter("srnok1PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("srnok1PoliceStation"));
			objectMap.put("nok1PoliceStation",
					request.getParameter("srnok1PoliceStation"));
		}

		if (request.getParameter("nok1PinCode") != null
				&& !request.getParameter("nok1PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("nok1PinCode"));
			objectMap.put("nok1PinCode", request.getParameter("nok1PinCode"));
		} else if (request.getParameter("srnok1PinCode") != null
				&& !request.getParameter("srnok1PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("srnok1PinCode"));
			objectMap.put("nok1PinCode", request.getParameter("srnok1PinCode"));
		}

		if (request.getParameter("nok2Name") != null
				&& !request.getParameter("nok2Name").equals("")) {
			patient.setNok2Name(request.getParameter("nok2Name"));
			objectMap.put("nok2Name", request.getParameter("nok2Name"));
		} 
		if (request.getParameter("nok2RelationId") != null
				&& !request.getParameter("nok2RelationId").equals("0")) {
			int nok2RelationId = Integer.parseInt(request
					.getParameter("nok2RelationId"));
			MasRelation relation = new MasRelation();
			relation.setId(nok2RelationId);
			patient.setNok2Relation(relation);
			objectMap.put("nok2Relation", relation);
		} else if (request.getParameter("srnok2RelationId") != null
				&& !request.getParameter("srnok2RelationId").equals("0")) {
			int nok2RelationId = Integer.parseInt(request
					.getParameter("srnok2RelationId"));
			MasRelation relation = new MasRelation();
			relation.setId(nok2RelationId);
			patient.setNok2Relation(relation);
			objectMap.put("nok2Relation", relation);
		}

		if (request.getParameter("nok2ContactNo") != null
				&& !request.getParameter("nok2ContactNo").equals("")) {
			patient.setNok2ContactNo(request.getParameter("nok2ContactNo"));
			objectMap.put("nok2ContactNo",
					request.getParameter("nok2ContactNo"));
		} else if (request.getParameter("srnok2ContactNo") != null
				&& !request.getParameter("srnok2ContactNo").equals("")) {
			patient.setNok2ContactNo(request.getParameter("srnok2ContactNo"));
			objectMap.put("nok2ContactNo",
					request.getParameter("srnok2ContactNo"));
		}

		if (request.getParameter("nok2Address") != null
				&& !request.getParameter("nok2Address").equals("")) {
			patient.setNok2Address(request.getParameter("nok2Address"));
			objectMap.put("nok2Address", request.getParameter("nok2Address"));
		} else if (request.getParameter("srnok2Address") != null
				&& !request.getParameter("srnok2Address").equals("")) {
			patient.setNok2Address(request.getParameter("srnok2Address"));
			objectMap.put("nok2Address", request.getParameter("srnok2Address"));
		}

		if (request.getParameter("nok2PoliceStation") != null
				&& !request.getParameter("nok2PoliceStation").equals("")) {
			patient.setNok2PoliceStation(request
					.getParameter("nok2PoliceStation"));
			objectMap.put("nok2PoliceStation",
					request.getParameter("nok2PoliceStation"));
		} else if (request.getParameter("srnok2PoliceStation") != null
				&& !request.getParameter("srnok2PoliceStation").equals("")) {
			patient.setNok2PoliceStation(request
					.getParameter("srnok2PoliceStation"));
			objectMap.put("nok2PoliceStation",
					request.getParameter("srnok2PoliceStation"));
		}

		if (request.getParameter("nok2PinCode") != null
				&& !request.getParameter("nok2PinCode").equals("")) {
			patient.setNok2PinCode(request.getParameter("nok2PinCode"));
			objectMap.put("nok2PinCode", request.getParameter("nok2PinCode"));
		} else if (request.getParameter("srnok2PinCode") != null
				&& !request.getParameter("srnok2PinCode").equals("")) {
			patient.setNok2PinCode(request.getParameter("srnok2PinCode"));
			objectMap.put("nok2PinCode", request.getParameter("srnok2PinCode"));
		}
		if (request.getParameter("srMarriageDate") != null
				&& !request.getParameter("srMarriageDate").equals("")) {
			patient.setSrMarriageDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("srMarriageDate")));
			objectMap.put("srMarriageDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("srMarriageDate")));
		}
		if (request.getParameter("depMarriageDate") != null
				&& !request.getParameter("depMarriageDate").equals("")) {
			patient.setDepMarriageDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("depMarriageDate")));
			objectMap.put("depMarriageDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("depMarriageDate")));
		}
		if (request.getParameter("identificationMark1") != null) {
			patient.setSrIdentificationMark1(request
					.getParameter("identificationMark1"));
			objectMap.put("identificationMark1",
					request.getParameter("identificationMark1"));
		}
		if (request.getParameter("identificationMark2") != null) {
			patient.setSrIdentificationMark2(request
					.getParameter("identificationMark2"));
			objectMap.put("identificationMark2",
					request.getParameter("identificationMark2"));
		}
		if (request.getParameter("depIdentificationMark1") != null) {
			patient.setDepIdentificationMark1(request
					.getParameter("depIdentificationMark1"));
			objectMap.put("depIdentificationMark1",
					request.getParameter("depIdentificationMark1"));
		}
		if (request.getParameter("depIdentificationMark2") != null) {
			patient.setDepIdentificationMark2(request
					.getParameter("depIdentificationMark2"));
			objectMap.put("depIdentificationMark2",
					request.getParameter("depIdentificationMark2"));
		}
		/*
		 * if (serTypeId == 7) { MasRelation masRelation = new MasRelation();
		 * masRelation.setId(8); patient.setRelation(masRelation);
		 * patient.setRank(new MasRank(179)); patient.setUnit(new MasUnit(257));
		 * } else { if (request.getParameter(RELATION_ID) != null &&
		 * !request.getParameter(RELATION_ID).equals("0")) {
		 * servicePersonRelationId =
		 * Integer.parseInt(request.getParameter(RELATION_ID)); MasRelation
		 * masRelation = new MasRelation();
		 * masRelation.setId(servicePersonRelationId);
		 * patient.setRelation(masRelation); }else{ MasRelation masRelation =
		 * new MasRelation(); masRelation.setId(8);
		 * patient.setRelation(masRelation); } }
		 */
		/*
		 * if (!request.getParameter(TITLE).equals("0")) { int titleId =
		 * Integer.parseInt(request.getParameter(TITLE)); MasTitle masTitle =
		 * new MasTitle(); masTitle.setId(titleId); patient.setTitle(masTitle);
		 * }
		 */
		patient.setPFirstName((request.getParameter(P_FIRST_NAME).trim())
				.toUpperCase());
		objectMap.put("pFirstName",
				(request.getParameter(P_FIRST_NAME).trim()).toUpperCase());
		if (request.getParameter(P_MIDDLE_NAME) != null) {
			patient.setPMiddleName((request.getParameter(P_MIDDLE_NAME).trim())
					.toUpperCase());
			objectMap.put("pMiddleName",
					(request.getParameter(P_MIDDLE_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(P_LAST_NAME) != null) {
			patient.setPLastName((request.getParameter(P_LAST_NAME).trim())
					.toUpperCase());
			objectMap.put("pLastName",
					(request.getParameter(P_LAST_NAME).trim()).toUpperCase());
		}
		if (!request.getParameter(GENDER).equals("0")) {
			int genderId = Integer.parseInt(request.getParameter(GENDER));
			MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
			masAdministrativeSex.setId(genderId);
			patient.setSex(masAdministrativeSex);
			objectMap.put("pSex", masAdministrativeSex);
		}
		String age = "";
		if (request.getParameter(AGE) != null) {
			if (request.getParameter(AGE_UNIT) != null) {
				String ageUnit = request.getParameter(AGE_UNIT);
				age = request.getParameter(AGE).concat(" ").concat(ageUnit);
				patient.setAge(age);
				objectMap.put("pAge", age);
			}
		}
		System.out.println(request.getParameter(AGE));
		if (request.getParameter("ageLabel") != null
				&& !(request.getParameter("ageLabel").equals(""))) {
			age = request.getParameter("ageLabel");
			patient.setAge(age);
		}
		if (request.getParameter(DATE_OF_BIRTH) != null
				&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
			Date dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_BIRTH));
			patient.setDateOfBirth(dateOfBirth);
			objectMap.put("pDob", dateOfBirth);
		}

		if (request.getParameter(MARITAL_STATUS_ID) != null
				&& !request.getParameter(MARITAL_STATUS_ID).equals("0")) {
			int maritalStatusId = Integer.parseInt(request
					.getParameter(MARITAL_STATUS_ID));
			MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
			masMaritalStatus.setId(maritalStatusId);
			patient.setMaritalStatus(masMaritalStatus);
			objectMap.put("ptMaritalStatus", masMaritalStatus);
		}
		/*
		 * if (request.getParameter(OCCUPATION_ID) != null &&
		 * !request.getParameter(OCCUPATION_ID).equals("0")) { int occupationId
		 * = Integer.parseInt(request .getParameter(OCCUPATION_ID));
		 * MasOccupation masOccupation = new MasOccupation();
		 * masOccupation.setId(occupationId);
		 * patient.setOccupation(masOccupation); objectMap.put("masOccupation",
		 * masOccupation); } if (request.getParameter(BLOOD_GROUP_ID) != null &&
		 * !request.getParameter(BLOOD_GROUP_ID).equals("0")) { int bloodGroupId
		 * = Integer.parseInt(request .getParameter(BLOOD_GROUP_ID));
		 * MasBloodGroup masBloodGroup = new MasBloodGroup();
		 * masBloodGroup.setId(bloodGroupId);
		 * patient.setBloodGroup(masBloodGroup); objectMap.put("ptBloodGroup",
		 * masBloodGroup); } if (request.getParameter(SR_BLOOD_GROUP_ID) != null
		 * && !request.getParameter(SR_BLOOD_GROUP_ID).equals("0")) { int
		 * bloodGroupId = Integer.parseInt(request
		 * .getParameter(SR_BLOOD_GROUP_ID)); MasBloodGroup masBloodGroup = new
		 * MasBloodGroup(); masBloodGroup.setId(bloodGroupId);
		 * patient.setSrBloodGroup(masBloodGroup); if
		 * (request.getParameter(RELATION_ID).equals("0") ||
		 * request.getParameter(RELATION_ID).equals("8")) {
		 * patient.setBloodGroup(masBloodGroup); objectMap.put("ptBloodGroup",
		 * masBloodGroup); } objectMap.put("srBloodGroup", masBloodGroup); }
		 * 
		 * if (request.getParameter("income") != null) {
		 * patient.setIncome(request.getParameter("income"));
		 * objectMap.put("income", request.getParameter("income")); }
		 */
		if (request.getParameter("dependencyDate") != null
				&& !(request.getParameter("dependencyDate").equals(""))) {
			patient.setDependencyDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyDate")));
			objectMap.put("dependencyDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyDate")));
		}
		if (request.getParameter("authority") != null) {
			patient.setAuthority(request.getParameter("authority"));
			objectMap.put("authority", request.getParameter("authority"));
		}
		if (request.getParameter("dependencyRemovalDate") != null
				&& !(request.getParameter("dependencyRemovalDate").equals(""))) {
			patient.setDependencyRemovalDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyRemovalDate")));
			objectMap.put("dependencyRemovalDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyRemovalDate")));
		}
		if (request.getParameter(DISTRICT) != null
				&& !request.getParameter(DISTRICT).equals("0")) {
			int districtId = Integer.parseInt(request.getParameter(DISTRICT));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			patient.setDistrict(masDistrict);
			objectMap.put("masDistrict", masDistrict);
		}
		if (request.getParameter(ADDRESS) != null) {
			patient.setAddress(request.getParameter(ADDRESS));
			objectMap.put("address", request.getParameter(ADDRESS));
		}

		if (request.getParameter(CONTACT_NUMBER) != null) {
			patient.setContactNo(request.getParameter(CONTACT_NUMBER));
			objectMap.put("contactNo", request.getParameter(CONTACT_NUMBER));
		}

		if (request.getParameter(STATE) != null
				&& !request.getParameter(STATE).equals("0")) {
			int stateId = Integer.parseInt(request.getParameter(STATE));
			MasState masState = new MasState();
			masState.setId(stateId);
			patient.setState(masState);
			objectMap.put("masState", masState);
		}
		Date addEditDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			patient.setAddEditDate(addEditDate);
		}

		String addEditTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			addEditTime = request.getParameter(CHANGED_TIME);
			patient.setAddEditTime(addEditTime);
		}

		/*Date regDate = null;
		if (request.getParameter(REG_DATE) != null) {
			regDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(REG_DATE));
			patient.setRegDate(regDate);
		}
		String regTime = "";
		if (request.getParameter(REG_TIME) != null) {
			regTime = request.getParameter(REG_TIME);
			patient.setRegTime(regTime);
		}*/

		if (request.getParameter("smokerLess10") != null
				|| request.getParameter("srsmokerLess10") != null) {
			patient.setSmokerLess10("y");
			objectMap.put("smokerLess10", "y");
		} else {
			patient.setSmokerLess10("n");
			objectMap.put("smokerLess10", "n");
		}
		if (request.getParameter("smokerMore10") != null
				|| request.getParameter("smokerMore10") != null) {
			patient.setSmokerMore10("y");
			objectMap.put("smokerMore10", "y");
		} else {
			patient.setSmokerMore10("n");
			objectMap.put("smokerMore10", "n");
		}

		if (request.getParameter("alcohol") != null
				&& !request.getParameter("alcohol").equals("")) {
			patient.setAlcohol(request.getParameter("alcohol"));
			objectMap.put("alcohol", request.getParameter("alcohol"));
		} else if (request.getParameter("sralcohol") != null
				&& !request.getParameter("sralcohol").equals("")) {
			patient.setAlcohol(request.getParameter("sralcohol"));
			objectMap.put("alcohol", request.getParameter("sralcohol"));
		}
		if (request.getParameter("otherFamilyHistory") != null
				&& !request.getParameter("otherFamilyHistory").equals("")) {
			patient.setOtherFamilyHistory(request
					.getParameter("otherFamilyHistory"));
			objectMap.put("otherFamilyHistory",
					request.getParameter("otherFamilyHistory"));
		} else if (request.getParameter("otherSrFamilyHistory") != null
				&& !request.getParameter("otherSrFamilyHistory").equals("")) {
			patient.setOtherFamilyHistory(request
					.getParameter("otherSrFamilyHistory"));
			objectMap.put("otherFamilyHistory",
					request.getParameter("otherSrFamilyHistory"));
		}

		if (request.getParameter("allergies") != null) {
			patient.setDrugAllergies(request.getParameter("allergies"));
			objectMap.put("allergies", request.getParameter("allergies"));
		}
		if (request.getParameter("srAllergies") != null) {
			patient.setDrugAllergies(request.getParameter("srAllergies"));
			objectMap.put("srallergies", request.getParameter("srAllergies"));
		}
		/**
		 * Commented By Ritu Single family history not required
		 */
		/*
		 * if(request.getParameter("familyHistory") != null &&
		 * !request.getParameter("familyHistory").equals("0")){
		 * PatientFamilyHistory familyHistory = new PatientFamilyHistory();
		 * familyHistory
		 * .setId(Integer.parseInt(request.getParameter("familyHistory")));
		 * patient.setFamilyHistory(familyHistory); }
		 */

		/**
		 * Added By Ritu for multiple family history
		 */
		String[] familyHistoryArray = null;
		if (request.getParameterValues("familyHistory") != null) {
			familyHistoryArray = request.getParameterValues("familyHistory");
			objectMap.put("familyHistoryArray", familyHistoryArray);
		} else if (request.getParameterValues("srfamilyHistory") != null) {
			familyHistoryArray = request.getParameterValues("srfamilyHistory");
			objectMap.put("familyHistoryArray", familyHistoryArray);
		}
		/**
		 * End
		 */

		if (request.getParameter("presentMedCat") != null
				&& !request.getParameter("presentMedCat").equals("0")) {
			Category category = new Category();
			category.setCategoryid(Integer.parseInt(request
					.getParameter("presentMedCat")));
			patient.setCategory(category);
			objectMap.put("category", category);
		}
		/*
		 * if(request.getParameter("medCatPeriod") != null &&
		 * !request.getParameter("medCatPeriod").equals("")){
		 * patient.setMedCatPeriod(request.getParameter("medCatPeriod"));
		 * objectMap.put("medCatPeriod", request.getParameter("medCatPeriod"));
		 * }Commented by dipali
		 */
		// ---Addd By dipali as discussed with Anshu (05-mar-2013)
		if (request.getParameter("medCatPeriod") != null
				&& !request.getParameter("medCatPeriod").equals("")) {
			if (request.getParameter("medCatDuration") != null) {
				String medCatDuration = request.getParameter("medCatDuration");
				String finalMedCat = request.getParameter("medCatPeriod")
						.concat(" ").concat(medCatDuration);
				patient.setMedCatPeriod(finalMedCat);
				objectMap.put("medCatPeriod", finalMedCat);
			}
		}// --------

		if (request.getParameter("medCatDate") != null
				&& !request.getParameter("medCatDate").equals("")) {
			patient.setMedCatDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("medCatDate")));
			objectMap.put("medCatDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("medCatDate")));
		}
		if (request.getParameter("echs") != null) {
			patient.setEchsNo(request.getParameter("echs"));
			objectMap.put("echs", request.getParameter("echs"));
		}
		/*patient.setHospital(masHospital);
		patient.setStatus("y");
		patient.setPatientStatus("Out Patient");
		patient.setInpatientNo(0);*/
		if (request.getParameter("img1") != null
				&& !request.getParameter("img1").equals("")) {
			map.put("img1", request.getParameter("img1"));
		}
		map.put("regFlag", "reg");

		String[] rptForArr = null;
		if (request.getParameterValues("reportingFor") != null) {
			rptForArr = request.getParameterValues("reportingFor");
			objectMap.put("rptForArr", rptForArr);
		}
		/*
		 * List<Visit> visitObjList = new ArrayList<Visit>(); if(rptForArr!=null
		 * && rptForArr.length > 0){ for (int i = 0; i < rptForArr.length; i++)
		 * { Visit visit = new Visit(); visit.setReportingFor(rptForArr[i]); if
		 * (request.getParameter(DEPARTMENT_ID) != null &&
		 * !request.getParameter(DEPARTMENT_ID).equals("0")) { MasDepartment
		 * masDepartment = new MasDepartment();
		 * masDepartment.setId(Integer.parseInt
		 * (request.getParameter(DEPARTMENT_ID)));
		 * visit.setDepartment(masDepartment); } String tokenAndDoctor = "";
		 * 
		 * if (request.getParameter(TOKEN_NO) != null &&
		 * !(request.getParameter(TOKEN_NO).equals(""))) {
		 * visit.setTokenNo(Integer.parseInt(request.getParameter(TOKEN_NO)));
		 * tokenAndDoctor = request.getParameter(TOKEN_NO); } int tokenNo = 0;
		 * 
		 * int consultingDoctorId = 0; if
		 * (request.getParameter(CONSULTING_DOCTOR) != null &&
		 * !request.getParameter(CONSULTING_DOCTOR).equals("0")) {
		 * consultingDoctorId = Integer.parseInt(request
		 * .getParameter(CONSULTING_DOCTOR)); MasEmployee consultingDoctorObj =
		 * new MasEmployee(); consultingDoctorObj.setId(consultingDoctorId);
		 * visit.setDoctor(consultingDoctorObj);
		 * objectMap.put("consultingDoctorId", consultingDoctorId); int
		 * maxTokenNo = 0; maxTokenNo =
		 * registrationHandlerService.getTokenNoForDepartment
		 * (consultingDoctorId); tokenNo = maxTokenNo + 1;
		 * 
		 * tokenAndDoctor = tokenNo+"#"+consultingDoctorId; }else{ tokenNo = 0;
		 * tokenAndDoctor = tokenNo+"#"+consultingDoctorId; }
		 * if(rptForArr[i].equals("OPD") || rptForArr[i].equals("FollowUp")){
		 * if(request.getParameter("roomNo") != null &&
		 * !request.getParameter("roomNo").equals("")){
		 * visit.setRoomNo(Integer.parseInt(request.getParameter("roomNo"))); }
		 * } visit.setTokenNo(tokenNo); visit.setTokenDoctor(tokenAndDoctor);
		 * 
		 * visit.setHospital(masHospital); visit.setAddEditBy(user);
		 * visit.setAge(age); visit.setVisitDate(addEditDate);
		 * visit.setAddEditDate(addEditDate); visit.setAddEditTime(addEditTime);
		 * visit.setVisitTime(addEditTime); visit.setVisitDate(regDate);
		 * visit.setVisitTime(regTime);
		 * 
		 * visit.setStatus("y"); //---------commented by anamika
		 * //visit.setEdStatus("n");
		 * 
		 * visit.setAppointmentType("D"); if(rptForArr[i].equals("MedExam")){
		 * if(request.getParameter("medExamCategory") != null &&
		 * !(request.getParameter("medExamCategory")).equals("")){
		 * visit.setMedExamType(request.getParameter("medExamCategory"));
		 * visit.setVisitStatus("c"); visit.setMedStatus("w"); } }else
		 * if(rptForArr[i].equals("MedBoard")){
		 * if(request.getParameter("medBoardCategory") != null &&
		 * !(request.getParameter("medBoardCategory")).equals("")){
		 * visit.setMedExamType(request.getParameter("medBoardCategory"));
		 * visit.setMedStatus("w"); visit.setVisitStatus("c"); } }else
		 * if(rptForArr[i].equals("FamilyWC")){
		 * if(request.getParameter("fwcCategory") != null &&
		 * !(request.getParameter("fwcCategory")).equals("")){
		 * visit.setFwcCategory(request.getParameter("fwcCategory"));
		 * visit.setVisitStatus("w"); } }else{ visit.setVisitStatus("w"); }
		 * 
		 * if(request.getParameter("priority")!=null){
		 * visit.setPriority(Integer.
		 * parseInt(request.getParameter("priority"))); }
		 * if(rptForArr[i].equals("FollowUp") &&
		 * request.getParameter("followUpDepartment")!=null &&
		 * request.getParameter("followUpDepartment").equals("FamilyWC") ){
		 * visit
		 * .setFollowUpDepartment(request.getParameter("followUpDepartment"));
		 * visit.setFwcCategory("PNC"); } else {
		 * if(request.getParameter("followUpDepartment")!=null &&
		 * rptForArr[i].equals("FollowUp")){
		 * visit.setFollowUpDepartment(request.
		 * getParameter("followUpDepartment")); } } objectMap.put("visit",
		 * visit); visitObjList.add(visit);
		 * objectMap.put("visitObjList",visitObjList); } }
		 */
		if (request.getParameter("regHinId") != null
				&& !request.getParameter("regHinId").equals("0")
				&& !request.getParameter("regHinId").equals("")) {
			objectMap.put("regHinId",
					Integer.parseInt(request.getParameter("regHinId")));
		} else if (request.getParameter("selfRegHin") != null
				&& !request.getParameter("selfRegHin").equals("")
				&& !request.getParameter("selfRegHin").equals("")) {
			objectMap.put("selfRegHin",
					Integer.parseInt(request.getParameter("selfRegHin")));
		}

		/**
		 * Code for Immunization
		 */

		/*
		 * int immCount =0; if(request.getParameter("immCount")!=null &&
		 * !(request.getParameter("immCount").equals(""))){ immCount =
		 * Integer.parseInt(request.getParameter("immCount")); } if(immCount
		 * >0){ List<Integer> immuDtIdList = new ArrayList<Integer>();
		 * List<String> immuNameList = new ArrayList<String>(); List<Integer>
		 * immunizationIdList = new ArrayList<Integer>(); List<String> dateList
		 * = new ArrayList<String>(); List<String> doseList = new
		 * ArrayList<String>(); List<String> routeList = new
		 * ArrayList<String>(); List<String> batchNoList = new
		 * ArrayList<String>(); List<String> domList = new ArrayList<String>();
		 * List<String> doeList = new ArrayList<String>();
		 * 
		 * for (int j = 1; j <= immCount; j++) {
		 * if(request.getParameter("immunId"+j)!=null &&
		 * !request.getParameter("immunId"+j).equals("")){
		 * immuDtIdList.add(Integer
		 * .parseInt(request.getParameter("immunId"+j))); }else{
		 * immuDtIdList.add(0); }
		 * if(request.getParameter("immunizationName"+j)!=null){
		 * immuNameList.add(request.getParameter("immunizationName"+j)); }
		 * if(request.getParameter("immunizationId"+j)!=null &&
		 * !request.getParameter("immunizationId"+j).equals("")){
		 * immunizationIdList
		 * .add(Integer.parseInt(request.getParameter("immunizationId"+j))); }
		 * 
		 * if(request.getParameter("vdate"+j)!=null){
		 * dateList.add(request.getParameter("vdate"+j)); }
		 * if(request.getParameter("dose"+j)!=null){
		 * doseList.add(request.getParameter("dose"+j)); }
		 * if(request.getParameter("route"+j)!=null){
		 * routeList.add(request.getParameter("route"+j)); }
		 * if(request.getParameter("batchNo"+j)!=null){
		 * batchNoList.add(request.getParameter("batchNo"+j)); }
		 * if(request.getParameter("dom"+j)!=null){
		 * domList.add(request.getParameter("dom"+j)); }
		 * if(request.getParameter("doe"+j)!=null){
		 * doeList.add(request.getParameter("doe"+j)); }
		 * 
		 * } objectMap.put("immuDtIdList", immuDtIdList);
		 * objectMap.put("immuNameList", immuNameList);
		 * objectMap.put("dateList", dateList); objectMap.put("doseList",
		 * doseList); objectMap.put("routeList", routeList);
		 * objectMap.put("batchNoList", batchNoList); objectMap.put("domList",
		 * domList); objectMap.put("doeList", doeList);
		 * objectMap.put("immunizationIdList", immunizationIdList); }
		 * objectMap.put("masHospital", masHospital);
		 */
		/**
		 * 
		 */

		/**
		 * Code for Allergies
		 */

		int allergyCount = 0;
		if (request.getParameter("allergyCount") != null
				&& !(request.getParameter("allergyCount").equals(""))) {
			allergyCount = Integer.parseInt(request
					.getParameter("allergyCount"));
		}
		// System.out.println("allergyCount  - "+allergyCount);
		if (allergyCount > 0) {
			List<Integer> allergyDetailsIdList = new ArrayList<Integer>();
			List<String> allergyNameList = new ArrayList<String>();
			List<String> descList = new ArrayList<String>();
			List<String> severityList = new ArrayList<String>();
			List<String> sinceList = new ArrayList<String>();
			List<String> remarksList = new ArrayList<String>();

			for (int j = 1; j <= allergyCount; j++) {
				if (request.getParameter("allergyDetailsId" + j) != null
						&& !request.getParameter("allergyDetailsId" + j)
								.equals("")) {
					allergyDetailsIdList.add(Integer.parseInt(request
							.getParameter("allergyDetailsId" + j)));
				} else {
					allergyDetailsIdList.add(0);
				}
				if (request.getParameter("allergyName" + j) != null
						&& !request.getParameter("allergyName" + j).equals("")) {
					allergyNameList
							.add(request.getParameter("allergyName" + j));
				}
				if (request.getParameter("description" + j) != null) {
					descList.add(request.getParameter("description" + j));
				}
				if (request.getParameter("severity" + j) != null) {
					severityList.add(request.getParameter("severity" + j));
				}
				if (request.getParameter("since" + j) != null) {
					sinceList.add(request.getParameter("since" + j));
				}
				if (request.getParameter("remarks" + j) != null) {
					remarksList.add(request.getParameter("remarks" + j));
				}

			}
			objectMap.put("allergyDetailsIdList", allergyDetailsIdList);
			objectMap.put("allergyNameList", allergyNameList);
			objectMap.put("descList", descList);
			objectMap.put("severityList", severityList);
			objectMap.put("sinceList", sinceList);
			objectMap.put("remarksList", remarksList);

		}
		if (request.getParameter("ldapData") != null) {
			objectMap.put("ldapData", request.getParameter("ldapData"));
		}
		if (request.getParameter("patientTypeName") != null) {
			objectMap.put("patientTypeName",
					request.getParameter("patientTypeName"));
		}
		/**
		 * 
		 */
		objectMap.put("hinNo", hinNo);
		objectMap.put("patient", patient);

		Box box = HMSUtil.getBox(request);
		objectMap.put("box", box);
		String userSrNo = (String) session.getAttribute("userSrNo");
		objectMap.put("userSrNo", userSrNo);

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;
		List<Patient> existingHinNoList = new ArrayList<Patient>();
		List<Visit> visitList = new ArrayList<Visit>();

		detailsMap = registrationHandlerService
				.updateOtherPatientInformation(objectMap);
		/*
		 * if (detailsMap.get("visitList") != null) { visitList = (List<Visit>)
		 * detailsMap.get("visitList"); map.put("visitList", visitList); }
		 */

		if (detailsMap.get("existingHinNoList") != null) {
			existingHinNoList = (List<Patient>) detailsMap
					.get("existingHinNoList");
		}
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true && existingHinNoList.size() == 0) {
			if (request.getParameter(HIN_NO) == null
					|| request.getParameter(HIN_NO).equals("")) {
				if (request.getParameter("selfHinNo") != null
						&& !request.getParameter("selfHinNo").equals("")) {
					map.put("hinNo", request.getParameter("selfHinNo"));
				}
				if (rptForArr != null && rptForArr.length > 0) {
					message = " Visit Information saved Successfully.";
				} else {
					message = " Patient Information Updated Successfully.";
				}
				map.put("regHinId", request.getParameter("regHinId"));
				map.put("hinNo", request.getParameter("printHinNo"));

			} else {
				message = " Registration Information Updated Successfully.";
				map.put("hinNo", hinNo);
			}
			map.put("serviceNo", serviceNo);

			if (request.getParameter("image") != null) {
				uploadPhoto(request);
			}
		} else if (existingHinNoList.size() > 0) {
			message = "Data can not be saved.This Hin is already exists.";
		} else {
			message = "Some problem Occured! Try Again.";
		}
		
		dataMap.put("users", user);
	
		/*
		 * if(request.getParameter("flag").equals("registration")){
		 * jsp.append(MSG_FOR_REG);
		 * 
		 * }else if(request.getParameter("flag").equals("medicalExam")){
		 * jsp.append(MSG_FOR_REG); }
		 * 
		 * jsp.append(".jsp");
		 */
		String jsp = "msgForUpdateOtherPatientInformation.jsp";
		map.put("contentJsp", jsp);		
		map.put("message", message);
		map.put("hinNo", objectMap.get("hinNo"));
		map.put("existingHinNoList", existingHinNoList);
		return new ModelAndView("index", "map", map);
	}
	
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitPatientInformationOtherPatientVisit(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Patient patient = new Patient();

		int servicePersonRelationId = 0;
		int serTypeId = 0;
		String hinNo = "";
		String serviceNo = "";
		Map<String, Object> objectMap = new HashMap<String, Object>();

		Users user = (Users) session.getAttribute("users");
		patient.setAddEditBy(user);
		objectMap.put("user", user);

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);

		if (request.getParameter(HIN_NO) != null) {
			hinNo = getHinNoHALDynamic(request, response);
			patient.setHinNo(hinNo);
			patient.setPreviousHinNo(hinNo);

		}
		/*
		 * if (request.getParameter(SERVICE_NO) != null) { serviceNo =
		 * HMSUtil.restrictMetaChar(request.getParameter(SERVICE_NO)); //
		 * serviceNo = request.getParameter(SERVICE_NO);
		 * patient.setServiceNo(serviceNo.trim());
		 * 
		 * }
		 */
		/*
		 * MasServiceType masServiceType = new MasServiceType(); serTypeId =
		 * Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
		 * masServiceType
		 * .setId(Integer.parseInt(request.getParameter(SERVICE_TYPE_ID)));
		 * patient.setServiceType(masServiceType);
		 */

		/*
		 * String suffix = ""; if (request.getParameter(SUFFIX) != null&&
		 * !request.getParameter(SUFFIX).equals("")) { suffix =
		 * HMSUtil.restrictMetaChar(request.getParameter(SUFFIX)); // suffix =
		 * request.getParameter(SUFFIX); } patient.setSuffix(suffix);
		 * objectMap.put("suffix", suffix);
		 */
		/*
		 * String prefix = ""; if (request.getParameter(PREFIX) != null &&
		 * !request.getParameter(PREFIX).equals("")) { prefix =
		 * HMSUtil.restrictMetaChar(request.getParameter(PREFIX)); // prefix =
		 * request.getParameter(PREFIX); } patient.setPrefix(prefix.trim());
		 * objectMap.put("prefix", prefix);
		 */
		int serviceStatusId = 0;
		if (request.getParameter(SERVICE_STATUS_ID) != null
				&& !request.getParameter(SERVICE_STATUS_ID).equals("0")) {
			serviceStatusId = Integer.parseInt(request
					.getParameter(SERVICE_STATUS_ID));
			MasServiceStatus masServiceStatus = new MasServiceStatus();
			masServiceStatus.setId(serviceStatusId);
			patient.setServiceStatus(masServiceStatus);
		}

		/*
		 * if (request.getParameter(RANK_ID) != null &&
		 * !request.getParameter(RANK_ID).equals("0")) { int rankId =
		 * Integer.parseInt(request.getParameter(RANK_ID)); MasRank masRank =
		 * new MasRank(); masRank.setId(rankId); patient.setRank(masRank);
		 * objectMap.put("masRank",masRank); }
		 */
		if (request.getParameter(S_FIRST_NAME) != null) {
			patient.setSFirstName((request.getParameter(S_FIRST_NAME).trim())
					.toUpperCase());
			objectMap.put("sFirstName",
					(request.getParameter(S_FIRST_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(S_MIDDLE_NAME) != null) {
			patient.setSMiddleName((request.getParameter(S_MIDDLE_NAME).trim())
					.toUpperCase());
			objectMap.put("sMiddleName",
					(request.getParameter(S_MIDDLE_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(S_LAST_NAME) != null) {
			patient.setSLastName((request.getParameter(S_LAST_NAME).trim())
					.toUpperCase());
			objectMap.put("sLastName",
					(request.getParameter(S_LAST_NAME).trim()).toUpperCase());
		}
		
	    /* patient.setBillable(null);*/
	     patient.setPaymentStatus(null); 

		/*
		 * if (request.getParameter(TRADE_ID) != null &&
		 * !request.getParameter(TRADE_ID).equals("0")) {
		 * if(!request.getParameter(TRADE_ID).equals("31")){ // for other int
		 * tradeId = Integer.parseInt(request.getParameter(TRADE_ID)); MasTrade
		 * masTrade = new MasTrade(); masTrade.setId(tradeId);
		 * patient.setTrade(masTrade); objectMap.put("masTrade",masTrade); }
		 * else if (request.getParameter(TRADE_NAME)!= null &&
		 * !request.getParameter(TRADE_NAME).equals("")) { MasTrade masTradeObj
		 * = new MasTrade();
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request .getParameter(TRADE_NAME) + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masTradeObj .setTradeName("" + output_str2);
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) { masTradeObj
		 * .setLastChgBy(request.getParameter(CHANGED_BY)); }
		 * 
		 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE));
		 * masTradeObj.setLastChgDate(changedDate);
		 * masTradeObj.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masTradeObj.setStatus("n");
		 * 
		 * objectMap.put("masTradeObj", masTradeObj ); } }
		 */
		if (request.getParameter(RECORD_OFFICE_ADDRESS_ID) != null
				&& !request.getParameter(RECORD_OFFICE_ADDRESS_ID).equals("0")) {
			int recordOfficeAddId = Integer.parseInt(request
					.getParameter(RECORD_OFFICE_ADDRESS_ID));
			MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
			masRecordOfficeAddress.setId(recordOfficeAddId);
			patient.setRecordOfficeAddress(masRecordOfficeAddress);
			objectMap.put("masRecordOfficeAddress", masRecordOfficeAddress);
		}
		/*
		 * if (request.getParameter(UNIT_ID) != null &&
		 * !request.getParameter(UNIT_ID).equals("0")) {
		 * if(!request.getParameter(UNIT_ID).equals("other")){ int unitId =
		 * Integer.parseInt(request.getParameter(UNIT_ID)); MasUnit masUnit =
		 * new MasUnit(); masUnit.setId(unitId); patient.setUnit(masUnit);
		 * objectMap.put("masUnit",masUnit); } else if
		 * (request.getParameter(UNIT_NAME)!=null &&
		 * !request.getParameter(UNIT_NAME).equals("")) { MasUnit masUnitObj =
		 * new MasUnit(); if (request.getParameter(UNIT_NAME) != null) {
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request .getParameter(UNIT_NAME) + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masUnitObj.setUnitName("" + output_str2); } if
		 * (request.getParameter(UNIT_ADDRESS) != null) {
		 * 
		 * StringBuffer output_str3 = new StringBuffer(); StringTokenizer s3 =
		 * new StringTokenizer(request .getParameter(UNIT_ADDRESS) + "", "\'");
		 * 
		 * while (s3.hasMoreTokens()) { output_str3.append(s3.nextToken()); if
		 * (s3.hasMoreTokens()) { output_str3.append(" "); } }
		 * 
		 * StringBuffer output_str4 = new StringBuffer(); StringTokenizer s4 =
		 * new StringTokenizer(output_str3 + "", "\"");
		 * 
		 * while (s4.hasMoreTokens()) { output_str4.append(s4.nextToken()); if
		 * (s4.hasMoreTokens()) { output_str4.append(" "); } }
		 * masUnitObj.setUnitAddress("" + output_str4); }
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) {
		 * masUnitObj.setLastChgBy(request.getParameter(CHANGED_BY)); } if
		 * (request.getParameter(LOCAL_UNIT) != null) {
		 * masUnitObj.setLocalUnit("y"); } else { masUnitObj.setLocalUnit("n");
		 * } Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE)); masUnitObj.setLastChgDate(changedDate);
		 * masUnitObj.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masUnitObj.setStatus("n"); objectMap.put("masUnitObj", masUnitObj); }
		 * }
		 */

		/*
		 * if(serviceStatusId == 2){ MasUnit masUnit = new MasUnit();
		 * masUnit.setId(257); patient.setUnit(masUnit); }
		 */

		/*
		 * if(request.getParameter("commissionDate") != null &&
		 * !(request.getParameter("commissionDate").equals(""))){
		 * patient.setCommissionDate
		 * (HMSUtil.convertStringTypeDateToDateType(request
		 * .getParameter("commissionDate")));
		 * objectMap.put("commisionDate",HMSUtil
		 * .convertStringTypeDateToDateType(
		 * request.getParameter("commissionDate"))); } if
		 * (request.getParameter(TOTAL_SERVICE) != null &&
		 * !request.getParameter(TOTAL_SERVICE).equals("")) {
		 * patient.setServiceYears(Float.parseFloat(request
		 * .getParameter(TOTAL_SERVICE)));
		 * objectMap.put("totalService",Float.parseFloat(request
		 * .getParameter(TOTAL_SERVICE))); } if
		 * (request.getParameter(TOTAL_SERVICE_PERIOD) != null &&
		 * !request.getParameter(TOTAL_SERVICE_PERIOD).equals("")) {
		 * patient.setTotalServicePeriod(request
		 * .getParameter(TOTAL_SERVICE_PERIOD)); } if
		 * (request.getParameter(STATION) != null &&
		 * !request.getParameter(STATION).equals("")) { if(
		 * !request.getParameter(STATION).equals("other")){
		 * patient.setStation(request.getParameter(STATION));
		 * objectMap.put("station", request.getParameter(STATION)); }else
		 * if(request.getParameter("stationName") != null){
		 * patient.setStation(request.getParameter("stationName"));
		 * 
		 * MasStation masStation = new MasStation();
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request .getParameter("stationName") + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masStation.setStationName("" + output_str2);
		 * masStation.setStationCode(output_str2.substring(0, 3));
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) { masStation
		 * .setLastChgBy(user); }
		 * 
		 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE)); masStation.setLastChgDate(changedDate);
		 * masStation.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masStation.setStatus("n");
		 * 
		 * objectMap.put("masStation", masStation );
		 * 
		 * } }
		 */
		/*
		 * if(request.getParameter(COMMAND) != null &&
		 * !(request.getParameter(COMMAND).equals("0"))){
		 * if(!(request.getParameter(COMMAND).equals("other"))){ MasCommand
		 * command = new MasCommand();
		 * command.setId(Integer.parseInt(request.getParameter(COMMAND)));
		 * patient.setCommand(command); objectMap.put("command", command); }else
		 * if (request.getParameter("commandName")!= null &&
		 * !request.getParameter("commandName").equals("")) { MasCommand
		 * masCommand = new MasCommand();
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request.getParameter("commandName") + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masCommand.setCommandName("" + output_str2);
		 * masCommand.setCommandCode(output_str2.substring(0, 3));
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) {
		 * masCommand.setLastChgBy(user); }
		 * 
		 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE)); masCommand.setLastChgDate(changedDate);
		 * masCommand.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masCommand.setStatus("n");
		 * 
		 * objectMap.put("masCommand", masCommand ); } }
		 * if(request.getParameter(SECTION_ID) != null &&
		 * !(request.getParameter(SECTION_ID).equals("0"))){
		 * if(!(request.getParameter(SECTION_ID).equals("other"))){ MasSection
		 * section = new MasSection();
		 * section.setId(Integer.parseInt(request.getParameter(SECTION_ID)));
		 * patient.setSection(section); objectMap.put("section", section); }else
		 * if (request.getParameter("sectionName")!= null &&
		 * !request.getParameter("sectionName").equals("")) { MasSection
		 * masSection = new MasSection();
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request.getParameter("sectionName") + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masSection.setSectionName("" + output_str2);
		 * masSection.setSectionCode(output_str2.substring(0, 3));
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) {
		 * masSection.setLastChgBy(user); }
		 * 
		 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE)); masSection.setLastChgDate(changedDate);
		 * masSection.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masSection.setStatus("y"); masSection.setHospital(masHospital);
		 * 
		 * objectMap.put("masSection", masSection ); } }
		 */

		if (request.getParameter(SR_SEX) != null
				&& !(request.getParameter(SR_SEX).equals("0"))) {
			MasAdministrativeSex admsex = new MasAdministrativeSex();
			admsex.setId(Integer.parseInt(request.getParameter(SR_SEX)));
			patient.setSrSex(admsex);
			objectMap.put("srSex", admsex);
		}

		if (request.getParameter(SR_AGE) != null) {
			if (request.getParameter(SR_AGE_UNIT) != null) {
				String ageUnit = request.getParameter(SR_AGE_UNIT);
				String srage = request.getParameter(SR_AGE).concat(" ")
						.concat(ageUnit);
				patient.setSrAge(srage);
				objectMap.put("srAge", srage);
			}
		}
		if (request.getParameter(SR_DOB) != null
				&& !(request.getParameter(SR_DOB).equals(""))) {
			patient.setSrDob(HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(SR_DOB)));
			objectMap.put("srDob", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(SR_DOB)));
		}

		if (request.getParameter("srMaritalStatus") != null
				&& !(request.getParameter("srMaritalStatus").equals("0"))) {
			MasMaritalStatus maritalStatus = new MasMaritalStatus();
			maritalStatus.setId(Integer.parseInt(request
					.getParameter("srMaritalStatus")));
			patient.setSrMaritalStatus(maritalStatus);
			objectMap.put("maritalStatus", maritalStatus);
		}
		if (request.getParameter("categoryId") != null
				&& !(request.getParameter("categoryId").equals("0"))) {
			MasOthersCategory othersCategory = new MasOthersCategory();
			othersCategory.setId(Integer.parseInt(request
					.getParameter("categoryId")));
			patient.setOthersCategory(othersCategory);
			objectMap.put("othersCategory", othersCategory);
		}

		/*
		 * if (request.getParameter(SERV_BLD_GROUP) != null &&
		 * !request.getParameter(SERV_BLD_GROUP).equals("0")) { int bldGrpId =
		 * Integer.parseInt(request .getParameter(SERV_BLD_GROUP));
		 * MasBloodGroup masBloodGroup = new MasBloodGroup();
		 * masBloodGroup.setId(bldGrpId);
		 * patient.setSrBloodGroup(masBloodGroup);
		 * objectMap.put("masBloodGroup", masBloodGroup ); }
		 */
		if (request.getParameter(RELIGION_ID) != null
				&& !request.getParameter(RELIGION_ID).equals("0")) {
			int religionId = Integer
					.parseInt(request.getParameter(RELIGION_ID));
			MasReligion masReligion = new MasReligion();
			masReligion.setId(religionId);
			patient.setReligion(masReligion);
			objectMap.put("masReligion", masReligion);
		}

		if (request.getParameter(TELEPHONE_NO) != null) {
			patient.setPhoneNumber(request.getParameter(TELEPHONE_NO));
			objectMap.put("telephoneNo", request.getParameter(TELEPHONE_NO));
		}
		if (request.getParameter(MOBILE_NO) != null) {
			patient.setMobileNumber(request.getParameter(MOBILE_NO));
			objectMap.put("mobileNo", request.getParameter(MOBILE_NO));
		}
		if (request.getParameter("afnetNo") != null) {
			patient.setAfnetNo(request.getParameter("afnetNo"));
			objectMap.put("afnetNo", request.getParameter("afnetNo"));
		}

		if (request.getParameter(PERMANENT_ADDRESS) != null) {
			patient.setPermanentAddress(request.getParameter(PERMANENT_ADDRESS));
			objectMap.put("permanentAddress",
					request.getParameter(PERMANENT_ADDRESS));
		}
		if (request.getParameter("phoneNoRes") != null) {
			patient.setTelephoneResi(request.getParameter("phoneNoRes"));
			objectMap.put("telephoneResi", request.getParameter("phoneNoRes"));
		}
		if (request.getParameter("permCityId") != null
				&& !request.getParameter("permCityId").equals("0")) {
			MasDistrict district = new MasDistrict();
			district.setId(Integer.parseInt(request.getParameter("permCityId")));
			patient.setPermanentCity(district);
			objectMap.put("permanentCity", district);
		}
		if (request.getParameter("permStateId") != null
				&& !request.getParameter("permStateId").equals("0")) {
			MasState state = new MasState();
			state.setId(Integer.parseInt(request.getParameter("permStateId")));
			patient.setPermanentState(state);
			objectMap.put("permanentState", state);
		}
		if (request.getParameter(NEXT_OF_KIN_NAME) != null
				&& !request.getParameter(NEXT_OF_KIN_NAME).equals("")) {
			patient.setNextOfKinName(request.getParameter(NEXT_OF_KIN_NAME));
			objectMap.put("nok1Name", request.getParameter(NEXT_OF_KIN_NAME));
		} 
		if (request.getParameter("telephoneNoPerm") != null) {
			patient.setTelephoneNoPerm(request.getParameter("telephoneNoPerm"));
			objectMap.put("telephoneNoPerm",
					request.getParameter("telephoneNoPerm"));
		}
		if (request.getParameter("otherContactNo") != null) {
			patient.setOtherContactNo(request.getParameter("otherContactNo"));
			objectMap.put("otherContactNo",
					request.getParameter("otherContactNo"));
		}
		if (request.getParameter("policeStation") != null) {
			patient.setPoliceStation(request.getParameter("policeStation"));
			objectMap.put("policeStation",
					request.getParameter("policeStation"));
		}
		if (request.getParameter("pinCode") != null) {
			patient.setPinCode(request.getParameter("pinCode"));
			objectMap.put("pinCode", request.getParameter("pinCode"));
		}
		if (request.getParameter(NEXT_OF_KIN_PHONE_NO) != null
				&& !request.getParameter(NEXT_OF_KIN_PHONE_NO).equals("")) {
			patient.setNextOfKinPhoneNumber(request
					.getParameter(NEXT_OF_KIN_PHONE_NO));
			objectMap.put("nok1Phone",
					request.getParameter(NEXT_OF_KIN_PHONE_NO));
		} else if (request.getParameter(SR_NEXT_OF_KIN_PHONE_NO) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_PHONE_NO).equals("")) {
			patient.setNextOfKinPhoneNumber(request
					.getParameter(SR_NEXT_OF_KIN_PHONE_NO));
			objectMap.put("nok1Phone",
					request.getParameter(SR_NEXT_OF_KIN_PHONE_NO));
		}
		if (request.getParameter(NEXT_OF_KIN_ADDRESS) != null
				&& !request.getParameter(NEXT_OF_KIN_ADDRESS).equals("")) {
			patient.setNextOfKinAddress(request
					.getParameter(NEXT_OF_KIN_ADDRESS));
			objectMap.put("nok1Address",
					request.getParameter(NEXT_OF_KIN_ADDRESS));
		} else if (request.getParameter(SR_NEXT_OF_KIN_ADDRESS) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_ADDRESS).equals("")) {
			patient.setNextOfKinAddress(request
					.getParameter(SR_NEXT_OF_KIN_ADDRESS));
			objectMap.put("nok1Address",
					request.getParameter(SR_NEXT_OF_KIN_ADDRESS));
		}
		if (request.getParameter(NEXT_OF_KIN_RELATION_ID) != null
				&& !request.getParameter(NEXT_OF_KIN_RELATION_ID).equals("0")) {
			int nextOfKinRelationId = Integer.parseInt(request
					.getParameter(NEXT_OF_KIN_RELATION_ID));
			MasRelation relation = new MasRelation();
			relation.setId(nextOfKinRelationId);
			patient.setNextOfKinRelation(relation);
			objectMap.put("nok1Relation", relation);
		} else if (request.getParameter(SR_NEXT_OF_KIN_RELATION_ID) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_RELATION_ID)
						.equals("0")) {
			int nextOfKinRelationId = Integer.parseInt(request
					.getParameter(SR_NEXT_OF_KIN_RELATION_ID));
			MasRelation relation = new MasRelation();
			relation.setId(nextOfKinRelationId);
			patient.setNextOfKinRelation(relation);
			objectMap.put("nok1Relation", relation);
		}

		if (request.getParameter("nok1PoliceStation") != null
				&& !request.getParameter("nok1PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("nok1PoliceStation"));
			objectMap.put("nok1PoliceStation",
					request.getParameter("nok1PoliceStation"));
		} else if (request.getParameter("srnok1PoliceStation") != null
				&& !request.getParameter("srnok1PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("srnok1PoliceStation"));
			objectMap.put("nok1PoliceStation",
					request.getParameter("srnok1PoliceStation"));
		}

		if (request.getParameter("nok1PinCode") != null
				&& !request.getParameter("nok1PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("nok1PinCode"));
			objectMap.put("nok1PinCode", request.getParameter("nok1PinCode"));
		} else if (request.getParameter("srnok1PinCode") != null
				&& !request.getParameter("srnok1PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("srnok1PinCode"));
			objectMap.put("nok1PinCode", request.getParameter("srnok1PinCode"));
		}

		if (request.getParameter("nok2Name") != null
				&& !request.getParameter("nok2Name").equals("")) {
			patient.setNok2Name(request.getParameter("nok2Name"));
			objectMap.put("nok2Name", request.getParameter("nok2Name"));
		} 
		if (request.getParameter("nok2RelationId") != null
				&& !request.getParameter("nok2RelationId").equals("0")) {
			int nok2RelationId = Integer.parseInt(request
					.getParameter("nok2RelationId"));
			MasRelation relation = new MasRelation();
			relation.setId(nok2RelationId);
			patient.setNok2Relation(relation);
			objectMap.put("nok2Relation", relation);
		} else if (request.getParameter("srnok2RelationId") != null
				&& !request.getParameter("srnok2RelationId").equals("0")) {
			int nok2RelationId = Integer.parseInt(request
					.getParameter("srnok2RelationId"));
			MasRelation relation = new MasRelation();
			relation.setId(nok2RelationId);
			patient.setNok2Relation(relation);
			objectMap.put("nok2Relation", relation);
		}

		if (request.getParameter("nok2ContactNo") != null
				&& !request.getParameter("nok2ContactNo").equals("")) {
			patient.setNok2ContactNo(request.getParameter("nok2ContactNo"));
			objectMap.put("nok2ContactNo",
					request.getParameter("nok2ContactNo"));
		} else if (request.getParameter("srnok2ContactNo") != null
				&& !request.getParameter("srnok2ContactNo").equals("")) {
			patient.setNok2ContactNo(request.getParameter("srnok2ContactNo"));
			objectMap.put("nok2ContactNo",
					request.getParameter("srnok2ContactNo"));
		}

		if (request.getParameter("nok2Address") != null
				&& !request.getParameter("nok2Address").equals("")) {
			patient.setNok2Address(request.getParameter("nok2Address"));
			objectMap.put("nok2Address", request.getParameter("nok2Address"));
		} else if (request.getParameter("srnok2Address") != null
				&& !request.getParameter("srnok2Address").equals("")) {
			patient.setNok2Address(request.getParameter("srnok2Address"));
			objectMap.put("nok2Address", request.getParameter("srnok2Address"));
		}

		if (request.getParameter("nok2PoliceStation") != null
				&& !request.getParameter("nok2PoliceStation").equals("")) {
			patient.setNok2PoliceStation(request
					.getParameter("nok2PoliceStation"));
			objectMap.put("nok2PoliceStation",
					request.getParameter("nok2PoliceStation"));
		} else if (request.getParameter("srnok2PoliceStation") != null
				&& !request.getParameter("srnok2PoliceStation").equals("")) {
			patient.setNok2PoliceStation(request
					.getParameter("srnok2PoliceStation"));
			objectMap.put("nok2PoliceStation",
					request.getParameter("srnok2PoliceStation"));
		}

		if (request.getParameter("nok2PinCode") != null
				&& !request.getParameter("nok2PinCode").equals("")) {
			patient.setNok2PinCode(request.getParameter("nok2PinCode"));
			objectMap.put("nok2PinCode", request.getParameter("nok2PinCode"));
		} else if (request.getParameter("srnok2PinCode") != null
				&& !request.getParameter("srnok2PinCode").equals("")) {
			patient.setNok2PinCode(request.getParameter("srnok2PinCode"));
			objectMap.put("nok2PinCode", request.getParameter("srnok2PinCode"));
		}
		if (request.getParameter("srMarriageDate") != null
				&& !request.getParameter("srMarriageDate").equals("")) {
			patient.setSrMarriageDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("srMarriageDate")));
			objectMap.put("srMarriageDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("srMarriageDate")));
		}
		if (request.getParameter("depMarriageDate") != null
				&& !request.getParameter("depMarriageDate").equals("")) {
			patient.setDepMarriageDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("depMarriageDate")));
			objectMap.put("depMarriageDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("depMarriageDate")));
		}
		if (request.getParameter("identificationMark1") != null) {
			patient.setSrIdentificationMark1(request
					.getParameter("identificationMark1"));
			objectMap.put("identificationMark1",
					request.getParameter("identificationMark1"));
		}
		if (request.getParameter("identificationMark2") != null) {
			patient.setSrIdentificationMark2(request
					.getParameter("identificationMark2"));
			objectMap.put("identificationMark2",
					request.getParameter("identificationMark2"));
		}
		if (request.getParameter("depIdentificationMark1") != null) {
			patient.setDepIdentificationMark1(request
					.getParameter("depIdentificationMark1"));
			objectMap.put("depIdentificationMark1",
					request.getParameter("depIdentificationMark1"));
		}
		if (request.getParameter("depIdentificationMark2") != null) {
			patient.setDepIdentificationMark2(request
					.getParameter("depIdentificationMark2"));
			objectMap.put("depIdentificationMark2",
					request.getParameter("depIdentificationMark2"));
		}
		/*
		 * if (serTypeId == 7) { MasRelation masRelation = new MasRelation();
		 * masRelation.setId(8); patient.setRelation(masRelation);
		 * patient.setRank(new MasRank(179)); patient.setUnit(new MasUnit(257));
		 * } else { if (request.getParameter(RELATION_ID) != null &&
		 * !request.getParameter(RELATION_ID).equals("0")) {
		 * servicePersonRelationId =
		 * Integer.parseInt(request.getParameter(RELATION_ID)); MasRelation
		 * masRelation = new MasRelation();
		 * masRelation.setId(servicePersonRelationId);
		 * patient.setRelation(masRelation); }else{ MasRelation masRelation =
		 * new MasRelation(); masRelation.setId(8);
		 * patient.setRelation(masRelation); } }
		 */
		/*
		 * if (!request.getParameter(TITLE).equals("0")) { int titleId =
		 * Integer.parseInt(request.getParameter(TITLE)); MasTitle masTitle =
		 * new MasTitle(); masTitle.setId(titleId); patient.setTitle(masTitle);
		 * }
		 */
		patient.setPFirstName((request.getParameter(P_FIRST_NAME).trim())
				.toUpperCase());
		objectMap.put("pFirstName",
				(request.getParameter(P_FIRST_NAME).trim()).toUpperCase());
		if (request.getParameter(P_MIDDLE_NAME) != null) {
			patient.setPMiddleName((request.getParameter(P_MIDDLE_NAME).trim())
					.toUpperCase());
			objectMap.put("pMiddleName",
					(request.getParameter(P_MIDDLE_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(P_LAST_NAME) != null) {
			patient.setPLastName((request.getParameter(P_LAST_NAME).trim())
					.toUpperCase());
			objectMap.put("pLastName",
					(request.getParameter(P_LAST_NAME).trim()).toUpperCase());
		}
		if (!request.getParameter(GENDER).equals("0")) {
			int genderId = Integer.parseInt(request.getParameter(GENDER));
			MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
			masAdministrativeSex.setId(genderId);
			patient.setSex(masAdministrativeSex);
			objectMap.put("pSex", masAdministrativeSex);
		}
		String age = "";
		if (request.getParameter(AGE) != null) {
			if (request.getParameter(AGE_UNIT) != null) {
				String ageUnit = request.getParameter(AGE_UNIT);
				age = request.getParameter(AGE).concat(" ").concat(ageUnit);
				patient.setAge(age);
				objectMap.put("pAge", age);
			}
		}
		System.out.println(request.getParameter(AGE));
		if (request.getParameter("ageLabel") != null
				&& !(request.getParameter("ageLabel").equals(""))) {
			age = request.getParameter("ageLabel");
			patient.setAge(age);
		}
		if (request.getParameter(DATE_OF_BIRTH) != null
				&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
			Date dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_BIRTH));
			patient.setDateOfBirth(dateOfBirth);
			objectMap.put("pDob", dateOfBirth);
		}

		if (request.getParameter(MARITAL_STATUS_ID) != null
				&& !request.getParameter(MARITAL_STATUS_ID).equals("0")) {
			int maritalStatusId = Integer.parseInt(request
					.getParameter(MARITAL_STATUS_ID));
			MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
			masMaritalStatus.setId(maritalStatusId);
			patient.setMaritalStatus(masMaritalStatus);
			objectMap.put("ptMaritalStatus", masMaritalStatus);
		}
		/*
		 * if (request.getParameter(OCCUPATION_ID) != null &&
		 * !request.getParameter(OCCUPATION_ID).equals("0")) { int occupationId
		 * = Integer.parseInt(request .getParameter(OCCUPATION_ID));
		 * MasOccupation masOccupation = new MasOccupation();
		 * masOccupation.setId(occupationId);
		 * patient.setOccupation(masOccupation); objectMap.put("masOccupation",
		 * masOccupation); } if (request.getParameter(BLOOD_GROUP_ID) != null &&
		 * !request.getParameter(BLOOD_GROUP_ID).equals("0")) { int bloodGroupId
		 * = Integer.parseInt(request .getParameter(BLOOD_GROUP_ID));
		 * MasBloodGroup masBloodGroup = new MasBloodGroup();
		 * masBloodGroup.setId(bloodGroupId);
		 * patient.setBloodGroup(masBloodGroup); objectMap.put("ptBloodGroup",
		 * masBloodGroup); } if (request.getParameter(SR_BLOOD_GROUP_ID) != null
		 * && !request.getParameter(SR_BLOOD_GROUP_ID).equals("0")) { int
		 * bloodGroupId = Integer.parseInt(request
		 * .getParameter(SR_BLOOD_GROUP_ID)); MasBloodGroup masBloodGroup = new
		 * MasBloodGroup(); masBloodGroup.setId(bloodGroupId);
		 * patient.setSrBloodGroup(masBloodGroup); if
		 * (request.getParameter(RELATION_ID).equals("0") ||
		 * request.getParameter(RELATION_ID).equals("8")) {
		 * patient.setBloodGroup(masBloodGroup); objectMap.put("ptBloodGroup",
		 * masBloodGroup); } objectMap.put("srBloodGroup", masBloodGroup); }
		 * 
		 * if (request.getParameter("income") != null) {
		 * patient.setIncome(request.getParameter("income"));
		 * objectMap.put("income", request.getParameter("income")); }
		 */
		if (request.getParameter("dependencyDate") != null
				&& !(request.getParameter("dependencyDate").equals(""))) {
			patient.setDependencyDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyDate")));
			objectMap.put("dependencyDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyDate")));
		}
		if (request.getParameter("authority") != null) {
			patient.setAuthority(request.getParameter("authority"));
			objectMap.put("authority", request.getParameter("authority"));
		}
		if (request.getParameter("dependencyRemovalDate") != null
				&& !(request.getParameter("dependencyRemovalDate").equals(""))) {
			patient.setDependencyRemovalDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyRemovalDate")));
			objectMap.put("dependencyRemovalDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyRemovalDate")));
		}
		if (request.getParameter(DISTRICT) != null
				&& !request.getParameter(DISTRICT).equals("0")) {
			int districtId = Integer.parseInt(request.getParameter(DISTRICT));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			patient.setDistrict(masDistrict);
			objectMap.put("masDistrict", masDistrict);
		}
		if (request.getParameter(ADDRESS) != null) {
			patient.setAddress(request.getParameter(ADDRESS));
			objectMap.put("address", request.getParameter(ADDRESS));
		}

		if (request.getParameter(CONTACT_NUMBER) != null) {
			patient.setContactNo(request.getParameter(CONTACT_NUMBER));
			objectMap.put("contactNo", request.getParameter(CONTACT_NUMBER));
		}

		if (request.getParameter(STATE) != null
				&& !request.getParameter(STATE).equals("0")) {
			int stateId = Integer.parseInt(request.getParameter(STATE));
			MasState masState = new MasState();
			masState.setId(stateId);
			patient.setState(masState);
			objectMap.put("masState", masState);
		}
		Date addEditDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			patient.setAddEditDate(addEditDate);
		}

		String addEditTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			addEditTime = request.getParameter(CHANGED_TIME);
			patient.setAddEditTime(addEditTime);
		}

		Date regDate = null;
		if (request.getParameter(REG_DATE) != null) {
			regDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(REG_DATE));
			patient.setRegDate(regDate);
			objectMap.put("regDate", regDate);
		}
		String regTime = "";
		if (request.getParameter(REG_TIME) != null) {
			regTime = request.getParameter(REG_TIME);
			patient.setRegTime(regTime);
		}

		if (request.getParameter("smokerLess10") != null
				|| request.getParameter("srsmokerLess10") != null) {
			patient.setSmokerLess10("y");
			objectMap.put("smokerLess10", "y");
		} else {
			patient.setSmokerLess10("n");
			objectMap.put("smokerLess10", "n");
		}
		if (request.getParameter("smokerMore10") != null
				|| request.getParameter("smokerMore10") != null) {
			patient.setSmokerMore10("y");
			objectMap.put("smokerMore10", "y");
		} else {
			patient.setSmokerMore10("n");
			objectMap.put("smokerMore10", "n");
		}

		if (request.getParameter("alcohol") != null
				&& !request.getParameter("alcohol").equals("")) {
			patient.setAlcohol(request.getParameter("alcohol"));
			objectMap.put("alcohol", request.getParameter("alcohol"));
		} else if (request.getParameter("sralcohol") != null
				&& !request.getParameter("sralcohol").equals("")) {
			patient.setAlcohol(request.getParameter("sralcohol"));
			objectMap.put("alcohol", request.getParameter("sralcohol"));
		}
		if (request.getParameter("otherFamilyHistory") != null
				&& !request.getParameter("otherFamilyHistory").equals("")) {
			patient.setOtherFamilyHistory(request
					.getParameter("otherFamilyHistory"));
			objectMap.put("otherFamilyHistory",
					request.getParameter("otherFamilyHistory"));
		} else if (request.getParameter("otherSrFamilyHistory") != null
				&& !request.getParameter("otherSrFamilyHistory").equals("")) {
			patient.setOtherFamilyHistory(request
					.getParameter("otherSrFamilyHistory"));
			objectMap.put("otherFamilyHistory",
					request.getParameter("otherSrFamilyHistory"));
		}

		if (request.getParameter("allergies") != null) {
			patient.setDrugAllergies(request.getParameter("allergies"));
			objectMap.put("allergies", request.getParameter("allergies"));
		}
		if (request.getParameter("srAllergies") != null) {
			patient.setDrugAllergies(request.getParameter("srAllergies"));
			objectMap.put("srallergies", request.getParameter("srAllergies"));
		}
		/**
		 * Commented By Ritu Single family history not required
		 */
		/*
		 * if(request.getParameter("familyHistory") != null &&
		 * !request.getParameter("familyHistory").equals("0")){
		 * PatientFamilyHistory familyHistory = new PatientFamilyHistory();
		 * familyHistory
		 * .setId(Integer.parseInt(request.getParameter("familyHistory")));
		 * patient.setFamilyHistory(familyHistory); }
		 */

		/**
		 * Added By Ritu for multiple family history
		 */
		String[] familyHistoryArray = null;
		if (request.getParameterValues("familyHistory") != null) {
			familyHistoryArray = request.getParameterValues("familyHistory");
			objectMap.put("familyHistoryArray", familyHistoryArray);
		} else if (request.getParameterValues("srfamilyHistory") != null) {
			familyHistoryArray = request.getParameterValues("srfamilyHistory");
			objectMap.put("familyHistoryArray", familyHistoryArray);
		}
		/**
		 * End
		 */

		if (request.getParameter("presentMedCat") != null
				&& !request.getParameter("presentMedCat").equals("0")) {
			Category category = new Category();
			category.setCategoryid(Integer.parseInt(request
					.getParameter("presentMedCat")));
			patient.setCategory(category);
			objectMap.put("category", category);
		}
		/*
		 * if(request.getParameter("medCatPeriod") != null &&
		 * !request.getParameter("medCatPeriod").equals("")){
		 * patient.setMedCatPeriod(request.getParameter("medCatPeriod"));
		 * objectMap.put("medCatPeriod", request.getParameter("medCatPeriod"));
		 * }Commented by dipali
		 */
		// ---Addd By dipali as discussed with Anshu (05-mar-2013)
		if (request.getParameter("medCatPeriod") != null
				&& !request.getParameter("medCatPeriod").equals("")) {
			if (request.getParameter("medCatDuration") != null) {
				String medCatDuration = request.getParameter("medCatDuration");
				String finalMedCat = request.getParameter("medCatPeriod")
						.concat(" ").concat(medCatDuration);
				patient.setMedCatPeriod(finalMedCat);
				objectMap.put("medCatPeriod", finalMedCat);
			}
		}// --------

		if (request.getParameter("medCatDate") != null
				&& !request.getParameter("medCatDate").equals("")) {
			patient.setMedCatDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("medCatDate")));
			objectMap.put("medCatDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("medCatDate")));
		}
		if (request.getParameter("echs") != null) {
			patient.setEchsNo(request.getParameter("echs"));
			objectMap.put("echs", request.getParameter("echs"));
		}
		patient.setHospital(masHospital);
		patient.setStatus("y");
		patient.setPatientStatus("Out Patient");
		patient.setInpatientNo(0);
		if (request.getParameter("img1") != null
				&& !request.getParameter("img1").equals("")) {
			map.put("img1", request.getParameter("img1"));
		}
		map.put("regFlag", "reg");

	
		String[] rptForArr = new String[1];
		if (request.getParameterValues("departmentId") != null) {
			rptForArr[0] = "OPD";
			objectMap.put("rptForArr", rptForArr);
		}

		List<Visit> visitObjList = new ArrayList<Visit>();
		if (rptForArr != null && rptForArr.length > 0) {
			for (int i = 0; i < rptForArr.length; i++) {
				Visit visit = new Visit();
				visit.setReportingFor(rptForArr[i]);
				if (request.getParameter(DEPARTMENT_ID) != null
						&& !request.getParameter(DEPARTMENT_ID).equals("0")) {
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer.parseInt(request
							.getParameter(DEPARTMENT_ID)));
					objectMap.put("departmentId", masDepartment.getId());
					visit.setDepartment(masDepartment);
				}
				String tokenAndDoctor = "";
				int tokenNo = 0;
				/*if (request.getParameter(TOKEN_NO) != null
						&& !(request.getParameter(TOKEN_NO).equals(""))) {
					tokenNo= Integer.parseInt(request
							.getParameter(TOKEN_NO));
					visit.setTokenNo(tokenNo);
					tokenAndDoctor = request.getParameter(TOKEN_NO);
				}*/
				

				int consultingDoctorId = 0;
				int consultingsessionId= 0;
				if (request.getParameter(EMPLOYEE_ID) != null
						&& !request.getParameter(EMPLOYEE_ID).equals("0") && request.getParameter(SESSION_ID) != null
								&& !request.getParameter(SESSION_ID).equals("0")) {
					consultingDoctorId = Integer.parseInt(request
							.getParameter(EMPLOYEE_ID));
					consultingsessionId = Integer.parseInt(request
							.getParameter(SESSION_ID));
					MasEmployee consultingDoctorObj = new MasEmployee();
					consultingDoctorObj.setId(consultingDoctorId);
					visit.setDoctor(consultingDoctorObj);
					MasSession consultingSessionobj = new MasSession();
					consultingSessionobj.setId(consultingsessionId);
					visit.setSession(consultingSessionobj);
					// added by vinay in case of  other patient we have to set visit_admin_flag as y  to eliminate the barcode at Dispensary
					visit.setVisitByAdmin("y");
					objectMap.put("consultingDoctorId", consultingDoctorId);
					objectMap.put("consultingsessionId", consultingsessionId);
					int maxTokenNo = 0;
					/*maxTokenNo = registrationHandlerService
							.getTokenNoForDepartment(consultingDoctorId, consultingsessionId);*/
					/*tokenNo = maxTokenNo + 1;*/

					tokenAndDoctor = tokenNo + "#" + consultingDoctorId;
				}
				/*else {
					tokenNo = 0;
					tokenAndDoctor = tokenNo + "#" + consultingDoctorId;
				}*/
				if (rptForArr[i].equals("OPD")
						|| rptForArr[i].equals("FollowUp")) {
					if (request.getParameter("roomNo") != null
							&& !request.getParameter("roomNo").equals("")) {
						visit.setRoomNo(Integer.parseInt(request
								.getParameter("roomNo")));
					}
				}
				visit.setTokenNo(tokenNo);
				visit.setTokenDoctor(tokenAndDoctor);

				visit.setHospital(masHospital);
				visit.setAddEditBy(user);
				/*visit.setAge(age);*/
				visit.setVisitDate(addEditDate);
				visit.setAddEditDate(addEditDate);
				visit.setAddEditTime(addEditTime);
				visit.setVisitTime(addEditTime);
				visit.setVisitDate(regDate);
				visit.setVisitTime(regTime);

				visit.setStatus("y"); // ---------commented by anamika
				// visit.setEdStatus("n");

				visit.setAppointmentType("D");
				if (rptForArr[i].equals("MedExam")) {
					if (request.getParameter("medExamCategory") != null
							&& !(request.getParameter("medExamCategory"))
									.equals("")) {
						visit.setMedExamType(request
								.getParameter("medExamCategory"));
						visit.setVisitStatus("c");
						visit.setMedStatus("w");
					}
				} else if (rptForArr[i].equals("MedBoard")) {
					if (request.getParameter("medBoardCategory") != null
							&& !(request.getParameter("medBoardCategory"))
									.equals("")) {
						visit.setMedExamType(request
								.getParameter("medBoardCategory"));
						visit.setMedStatus("w");
						visit.setVisitStatus("c");
					}
				} else if (rptForArr[i].equals("FamilyWC")) {
					if (request.getParameter("fwcCategory") != null
							&& !(request.getParameter("fwcCategory"))
									.equals("")) {
						visit.setFwcCategory(request
								.getParameter("fwcCategory"));
						visit.setVisitStatus("w");
					}
				} else {
					visit.setVisitStatus("w");
				}

				if (request.getParameter("priority") != null) {
					visit.setPriority(Integer.parseInt(request
							.getParameter("priority")));
				}
				if (rptForArr[i].equals("FollowUp")
						&& request.getParameter("followUpDepartment") != null
						&& request.getParameter("followUpDepartment").equals(
								"FamilyWC")) {
					visit.setFollowUpDepartment(request
							.getParameter("followUpDepartment"));
					visit.setFwcCategory("PNC");
				} else {
					if (request.getParameter("followUpDepartment") != null
							&& rptForArr[i].equals("FollowUp")) {
						visit.setFollowUpDepartment(request
								.getParameter("followUpDepartment"));
					}
				}
				objectMap.put("visit", visit);
				visitObjList.add(visit);
				objectMap.put("visitObjList", visitObjList);
			}
		}

		
		if (request.getParameter("regHinId") != null
				&& !request.getParameter("regHinId").equals("0")
				&& !request.getParameter("regHinId").equals("")) {
			objectMap.put("regHinId",
					Integer.parseInt(request.getParameter("regHinId")));
		} else if (request.getParameter("selfRegHin") != null
				&& !request.getParameter("selfRegHin").equals("")
				&& !request.getParameter("selfRegHin").equals("")) {
			objectMap.put("selfRegHin",
					Integer.parseInt(request.getParameter("selfRegHin")));
		}

		/**
		 * Code for Immunization
		 */

		/*
		 * int immCount =0; if(request.getParameter("immCount")!=null &&
		 * !(request.getParameter("immCount").equals(""))){ immCount =
		 * Integer.parseInt(request.getParameter("immCount")); } if(immCount
		 * >0){ List<Integer> immuDtIdList = new ArrayList<Integer>();
		 * List<String> immuNameList = new ArrayList<String>(); List<Integer>
		 * immunizationIdList = new ArrayList<Integer>(); List<String> dateList
		 * = new ArrayList<String>(); List<String> doseList = new
		 * ArrayList<String>(); List<String> routeList = new
		 * ArrayList<String>(); List<String> batchNoList = new
		 * ArrayList<String>(); List<String> domList = new ArrayList<String>();
		 * List<String> doeList = new ArrayList<String>();
		 * 
		 * for (int j = 1; j <= immCount; j++) {
		 * if(request.getParameter("immunId"+j)!=null &&
		 * !request.getParameter("immunId"+j).equals("")){
		 * immuDtIdList.add(Integer
		 * .parseInt(request.getParameter("immunId"+j))); }else{
		 * immuDtIdList.add(0); }
		 * if(request.getParameter("immunizationName"+j)!=null){
		 * immuNameList.add(request.getParameter("immunizationName"+j)); }
		 * if(request.getParameter("immunizationId"+j)!=null &&
		 * !request.getParameter("immunizationId"+j).equals("")){
		 * immunizationIdList
		 * .add(Integer.parseInt(request.getParameter("immunizationId"+j))); }
		 * 
		 * if(request.getParameter("vdate"+j)!=null){
		 * dateList.add(request.getParameter("vdate"+j)); }
		 * if(request.getParameter("dose"+j)!=null){
		 * doseList.add(request.getParameter("dose"+j)); }
		 * if(request.getParameter("route"+j)!=null){
		 * routeList.add(request.getParameter("route"+j)); }
		 * if(request.getParameter("batchNo"+j)!=null){
		 * batchNoList.add(request.getParameter("batchNo"+j)); }
		 * if(request.getParameter("dom"+j)!=null){
		 * domList.add(request.getParameter("dom"+j)); }
		 * if(request.getParameter("doe"+j)!=null){
		 * doeList.add(request.getParameter("doe"+j)); }
		 * 
		 * } objectMap.put("immuDtIdList", immuDtIdList);
		 * objectMap.put("immuNameList", immuNameList);
		 * objectMap.put("dateList", dateList); objectMap.put("doseList",
		 * doseList); objectMap.put("routeList", routeList);
		 * objectMap.put("batchNoList", batchNoList); objectMap.put("domList",
		 * domList); objectMap.put("doeList", doeList);
		 * objectMap.put("immunizationIdList", immunizationIdList); }
		 * objectMap.put("masHospital", masHospital);
		 */
		/**
		 * 
		 */

		/**
		 * Code for Allergies
		 */

		int allergyCount = 0;
		if (request.getParameter("allergyCount") != null
				&& !(request.getParameter("allergyCount").equals(""))) {
			allergyCount = Integer.parseInt(request
					.getParameter("allergyCount"));
		}
		// System.out.println("allergyCount  - "+allergyCount);
		if (allergyCount > 0) {
			List<Integer> allergyDetailsIdList = new ArrayList<Integer>();
			List<String> allergyNameList = new ArrayList<String>();
			List<String> descList = new ArrayList<String>();
			List<String> severityList = new ArrayList<String>();
			List<String> sinceList = new ArrayList<String>();
			List<String> remarksList = new ArrayList<String>();

			for (int j = 1; j <= allergyCount; j++) {
				if (request.getParameter("allergyDetailsId" + j) != null
						&& !request.getParameter("allergyDetailsId" + j)
								.equals("")) {
					allergyDetailsIdList.add(Integer.parseInt(request
							.getParameter("allergyDetailsId" + j)));
				} else {
					allergyDetailsIdList.add(0);
				}
				if (request.getParameter("allergyName" + j) != null
						&& !request.getParameter("allergyName" + j).equals("")) {
					allergyNameList
							.add(request.getParameter("allergyName" + j));
				}
				if (request.getParameter("description" + j) != null) {
					descList.add(request.getParameter("description" + j));
				}
				if (request.getParameter("severity" + j) != null) {
					severityList.add(request.getParameter("severity" + j));
				}
				if (request.getParameter("since" + j) != null) {
					sinceList.add(request.getParameter("since" + j));
				}
				if (request.getParameter("remarks" + j) != null) {
					remarksList.add(request.getParameter("remarks" + j));
				}

			}
			objectMap.put("allergyDetailsIdList", allergyDetailsIdList);
			objectMap.put("allergyNameList", allergyNameList);
			objectMap.put("descList", descList);
			objectMap.put("severityList", severityList);
			objectMap.put("sinceList", sinceList);
			objectMap.put("remarksList", remarksList);

		}
		if (request.getParameter("ldapData") != null) {
			objectMap.put("ldapData", request.getParameter("ldapData"));
		}
		if (request.getParameter("patientTypeName") != null) {
			objectMap.put("patientTypeName",
					request.getParameter("patientTypeName"));
		}
		/**
		 * 
		 */
		objectMap.put("hinNo", hinNo);
		objectMap.put("patient", patient);

		Box box = HMSUtil.getBox(request);
		objectMap.put("box", box);
		String userSrNo = (String) session.getAttribute("userSrNo");
		objectMap.put("userSrNo", userSrNo);

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;
		List<Patient> existingHinNoList = new ArrayList<Patient>();
		List<Visit> visitList = new ArrayList<Visit>();

		detailsMap = registrationHandlerService
				.submitPatientInformationOtherPatientVisit(objectMap, request);
		/*
		 * if (detailsMap.get("visitList") != null) { visitList = (List<Visit>)
		 * detailsMap.get("visitList"); map.put("visitList", visitList); }
		 */

		if (detailsMap.get("existingHinNoList") != null) {
			existingHinNoList = (List<Patient>) detailsMap
					.get("existingHinNoList");
		}
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			if (request.getParameter(HIN_NO) == null
					|| request.getParameter(HIN_NO).equals("")) {
				if (request.getParameter("selfHinNo") != null
						&& !request.getParameter("selfHinNo").equals("")) {
					map.put("hinNo", request.getParameter("selfHinNo"));
				}
				if (rptForArr != null && rptForArr.length > 0) {
					message = " Visit Information saved Successfully.";
				} else {
					message = " Patient Information Updated Successfully.";
				}
				map.put("regHinId", request.getParameter("regHinId"));
				map.put("hinNo", request.getParameter("printHinNo"));

			} else {
				message = " Visit Created Successfully.";
				map.put("hinNo", hinNo);
			}
			map.put("serviceNo", serviceNo);

			if (request.getParameter("image") != null) {
				uploadPhoto(request);
			}
		}  else {
			String msg = (String)detailsMap.get("msg");
			if(!msg.trim().equals(""))
			{
				message  = msg;
			}
			else
			{
				message = "Some problem Occured! Try Again.";
			}
			
		}
		String backUrl = "";
		backUrl = "/hms/hms/registration?method=showRegistrationJsp";
		map.put("backUrl", backUrl);
		

		dataMap.put("users", user);
		Map<String, Object> newMap = commonMasterHandlerService
				.getUserButtonRights(dataMap);
		List<UserButtonRights> userRightsList = (List<UserButtonRights>) newMap
				.get("userRightsList");
		map.put("userRightsList", userRightsList);
		/*
		 * if(request.getParameter("flag").equals("registration")){
		 * jsp.append(MSG_FOR_REG);
		 * 
		 * }else if(request.getParameter("flag").equals("medicalExam")){
		 * jsp.append(MSG_FOR_REG); }
		 * 
		 * jsp.append(".jsp");
		 */
		String jsp = "msgForRegOtherPatientVisit.jsp";
			
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("existingHinNoList", existingHinNoList);
		map.put("hinNo", objectMap.get("hinNo"));
		map.put("visit_id", detailsMap.get("visit_id"));
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitPatientInformationEmployeeVisit(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Patient patient = new Patient();

		int servicePersonRelationId = 0;
		int serTypeId = 0;
		String hinNo = "";
		String serviceNo = "";
		int blood_group_id =0; 
		Map<String, Object> objectMap = new HashMap<String, Object>();

		Users user = (Users) session.getAttribute("users");
		patient.setAddEditBy(user);
		patient.setBillable("n");
		objectMap.put("user", user);

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		objectMap.put("hospitalId", hospitalId);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);

		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			patient.setHinNo(hinNo);
			patient.setPreviousHinNo(hinNo);

		}
		
		if (request.getParameter("bloodGroupId") != null && !request.getParameter("bloodGroupId").trim().equals("")) {
			blood_group_id = Integer.parseInt(request.getParameter("bloodGroupId"));
			MasBloodGroup mbg = new MasBloodGroup();
			mbg.setId(blood_group_id);
			patient.setBloodGroup(mbg);			

		}

		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = HMSUtil.restrictMetaChar(request
					.getParameter(SERVICE_NO)); //
			serviceNo = request.getParameter(SERVICE_NO);
			patient.setServiceNo(serviceNo.trim());
		}

		if (request.getParameter(RANK_ID) != null
				&& !request.getParameter(RANK_ID).equals("0")) {
			int rankId = Integer.parseInt(request.getParameter(RANK_ID));
			MasRank masRank = new MasRank();
			masRank.setId(rankId);
			patient.setRank(masRank);
			objectMap.put("masRank", masRank);
		}

		if (request.getParameter(S_FIRST_NAME) != null) {
			patient.setSFirstName((request.getParameter(S_FIRST_NAME).trim())
					.toUpperCase());
			objectMap.put("sFirstName",
					(request.getParameter(S_FIRST_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(S_MIDDLE_NAME) != null) {
			patient.setSMiddleName((request.getParameter(S_MIDDLE_NAME).trim())
					.toUpperCase());
			objectMap.put("sMiddleName",
					(request.getParameter(S_MIDDLE_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(S_LAST_NAME) != null) {
			patient.setSLastName((request.getParameter(S_LAST_NAME).trim())
					.toUpperCase());
			objectMap.put("sLastName",
					(request.getParameter(S_LAST_NAME).trim()).toUpperCase());
		}

		
		if (request.getParameter(RECORD_OFFICE_ADDRESS_ID) != null
				&& !request.getParameter(RECORD_OFFICE_ADDRESS_ID).equals("0")) {
			int recordOfficeAddId = Integer.parseInt(request
					.getParameter(RECORD_OFFICE_ADDRESS_ID));
			MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
			masRecordOfficeAddress.setId(recordOfficeAddId);
			patient.setRecordOfficeAddress(masRecordOfficeAddress);
			objectMap.put("masRecordOfficeAddress", masRecordOfficeAddress);
		}
	
		if (request.getParameter(SR_SEX) != null
				&& !(request.getParameter(SR_SEX).equals("0"))) {
			MasAdministrativeSex admsex = new MasAdministrativeSex();
			admsex.setId(Integer.parseInt(request.getParameter(SR_SEX)));
			patient.setSrSex(admsex);
			objectMap.put("srSex", admsex);
		}

		if (request.getParameter(SR_AGE) != null) {
			if (request.getParameter(SR_AGE_UNIT) != null) {
				String ageUnit = request.getParameter(SR_AGE_UNIT);
				String srage = request.getParameter(SR_AGE).concat(" ")
						.concat(ageUnit);
				patient.setSrAge(srage);
				objectMap.put("srAge", srage);
			}
		}
		if (request.getParameter(SR_DOB) != null
				&& !(request.getParameter(SR_DOB).equals(""))) {
			patient.setSrDob(HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(SR_DOB)));
			objectMap.put("srDob", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(SR_DOB)));
		}

		if (request.getParameter("srMaritalStatus") != null
				&& !(request.getParameter("srMaritalStatus").equals("0"))) {
			MasMaritalStatus maritalStatus = new MasMaritalStatus();
			maritalStatus.setId(Integer.parseInt(request
					.getParameter("srMaritalStatus")));
			patient.setSrMaritalStatus(maritalStatus);
			objectMap.put("maritalStatus", maritalStatus);
		}

		if (request.getParameter(SERV_BLD_GROUP) != null
				&& !request.getParameter(SERV_BLD_GROUP).equals("0")) {
			int bldGrpId = Integer.parseInt(request
					.getParameter(SERV_BLD_GROUP));
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bldGrpId);
			patient.setSrBloodGroup(masBloodGroup);
			objectMap.put("masBloodGroup", masBloodGroup);
		}

		if (request.getParameter(RELIGION_ID) != null
				&& !request.getParameter(RELIGION_ID).equals("0")) {
			int religionId = Integer
					.parseInt(request.getParameter(RELIGION_ID));
			MasReligion masReligion = new MasReligion();
			masReligion.setId(religionId);
			patient.setReligion(masReligion);
			objectMap.put("masReligion", masReligion);
		}

		if (request.getParameter(TELEPHONE_NO) != null) {
			patient.setPhoneNumber(request.getParameter(TELEPHONE_NO));
			objectMap.put("telephoneNo", request.getParameter(TELEPHONE_NO));
		}
		if (request.getParameter(MOBILE_NO) != null) {
			patient.setMobileNumber(request.getParameter(MOBILE_NO));
			objectMap.put("mobileNo", request.getParameter(MOBILE_NO));
		}
		if (request.getParameter("afnetNo") != null) {
			patient.setAfnetNo(request.getParameter("afnetNo"));
			objectMap.put("afnetNo", request.getParameter("afnetNo"));
		}

		if (request.getParameter(PERMANENT_ADDRESS) != null) {
			patient.setPermanentAddress(request.getParameter(PERMANENT_ADDRESS).trim());
			objectMap.put("permanentAddress",
					request.getParameter(PERMANENT_ADDRESS).trim());
		}
		if (request.getParameter("phoneNoRes") != null) {
			patient.setTelephoneResi(request.getParameter("phoneNoRes"));
			objectMap.put("telephoneResi", request.getParameter("phoneNoRes"));
		}
		if (request.getParameter("permCityId") != null
				&& !request.getParameter("permCityId").equals("0")) {
			MasDistrict district = new MasDistrict();
			district.setId(Integer.parseInt(request.getParameter("permCityId")));
			patient.setPermanentCity(district);
			objectMap.put("permanentCity", district);
		}
		if (request.getParameter("permStateId") != null
				&& !request.getParameter("permStateId").equals("0")) {
			MasState state = new MasState();
			state.setId(Integer.parseInt(request.getParameter("permStateId")));
			patient.setPermanentState(state);
			objectMap.put("permanentState", state);
		}
		if (request.getParameter(NEXT_OF_KIN_NAME) != null
				&& !request.getParameter(NEXT_OF_KIN_NAME).equals("")) {
			patient.setNextOfKinName(request.getParameter(NEXT_OF_KIN_NAME));
			objectMap.put("nok1Name", request.getParameter(NEXT_OF_KIN_NAME));
		} 
		if (request.getParameter("telephoneNoPerm") != null) {
			patient.setTelephoneNoPerm(request.getParameter("telephoneNoPerm"));
			objectMap.put("telephoneNoPerm",
					request.getParameter("telephoneNoPerm"));
		}
		if (request.getParameter("otherContactNo") != null) {
			patient.setOtherContactNo(request.getParameter("otherContactNo"));
			objectMap.put("otherContactNo",
					request.getParameter("otherContactNo"));
		}
		if (request.getParameter("policeStation") != null) {
			patient.setPoliceStation(request.getParameter("policeStation"));
			objectMap.put("policeStation",
					request.getParameter("policeStation"));
		}
		if (request.getParameter("pinCode") != null) {
			patient.setPinCode(request.getParameter("pinCode"));
			objectMap.put("pinCode", request.getParameter("pinCode"));
		}
		if (request.getParameter(NEXT_OF_KIN_PHONE_NO) != null
				&& !request.getParameter(NEXT_OF_KIN_PHONE_NO).equals("")) {
			patient.setNextOfKinPhoneNumber(request
					.getParameter(NEXT_OF_KIN_PHONE_NO));
			objectMap.put("nok1Phone",
					request.getParameter(NEXT_OF_KIN_PHONE_NO));
		} else if (request.getParameter(SR_NEXT_OF_KIN_PHONE_NO) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_PHONE_NO).equals("")) {
			patient.setNextOfKinPhoneNumber(request
					.getParameter(SR_NEXT_OF_KIN_PHONE_NO));
			objectMap.put("nok1Phone",
					request.getParameter(SR_NEXT_OF_KIN_PHONE_NO));
		}
		if (request.getParameter(NEXT_OF_KIN_ADDRESS) != null
				&& !request.getParameter(NEXT_OF_KIN_ADDRESS).equals("")) {
			patient.setNextOfKinAddress(request
					.getParameter(NEXT_OF_KIN_ADDRESS).trim());
			objectMap.put("nok1Address",
					request.getParameter(NEXT_OF_KIN_ADDRESS).trim());
		} else if (request.getParameter(SR_NEXT_OF_KIN_ADDRESS) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_ADDRESS).equals("")) {
			patient.setNextOfKinAddress(request
					.getParameter(SR_NEXT_OF_KIN_ADDRESS).trim());
			objectMap.put("nok1Address",
					request.getParameter(SR_NEXT_OF_KIN_ADDRESS).trim());
		}
		if (request.getParameter(NEXT_OF_KIN_RELATION_ID) != null
				&& !request.getParameter(NEXT_OF_KIN_RELATION_ID).equals("0")) {
			int nextOfKinRelationId = Integer.parseInt(request
					.getParameter(NEXT_OF_KIN_RELATION_ID));
			MasRelation relation = new MasRelation();
			relation.setId(nextOfKinRelationId);
			patient.setNextOfKinRelation(relation);
			objectMap.put("nok1Relation", relation);
		} else if (request.getParameter(SR_NEXT_OF_KIN_RELATION_ID) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_RELATION_ID)
						.equals("0")) {
			int nextOfKinRelationId = Integer.parseInt(request
					.getParameter(SR_NEXT_OF_KIN_RELATION_ID));
			MasRelation relation = new MasRelation();
			relation.setId(nextOfKinRelationId);
			patient.setNextOfKinRelation(relation);
			objectMap.put("nok1Relation", relation);
		}

		if (request.getParameter("nok1PoliceStation") != null
				&& !request.getParameter("nok1PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("nok1PoliceStation"));
			objectMap.put("nok1PoliceStation",
					request.getParameter("nok1PoliceStation"));
		} else if (request.getParameter("srnok1PoliceStation") != null
				&& !request.getParameter("srnok1PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("srnok1PoliceStation"));
			objectMap.put("nok1PoliceStation",
					request.getParameter("srnok1PoliceStation"));
		}

		if (request.getParameter("nok1PinCode") != null
				&& !request.getParameter("nok1PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("nok1PinCode"));
			objectMap.put("nok1PinCode", request.getParameter("nok1PinCode"));
		} else if (request.getParameter("srnok1PinCode") != null
				&& !request.getParameter("srnok1PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("srnok1PinCode"));
			objectMap.put("nok1PinCode", request.getParameter("srnok1PinCode"));
		}

		if (request.getParameter("nok2Name") != null
				&& !request.getParameter("nok2Name").equals("")) {
			patient.setNok2Name(request.getParameter("nok2Name"));
			objectMap.put("nok2Name", request.getParameter("nok2Name"));
		} 
		if (request.getParameter("nok2RelationId") != null
				&& !request.getParameter("nok2RelationId").equals("0")) {
			int nok2RelationId = Integer.parseInt(request
					.getParameter("nok2RelationId"));
			MasRelation relation = new MasRelation();
			relation.setId(nok2RelationId);
			patient.setNok2Relation(relation);
			objectMap.put("nok2Relation", relation);
		} else if (request.getParameter("srnok2RelationId") != null
				&& !request.getParameter("srnok2RelationId").equals("0")) {
			int nok2RelationId = Integer.parseInt(request
					.getParameter("srnok2RelationId"));
			MasRelation relation = new MasRelation();
			relation.setId(nok2RelationId);
			patient.setNok2Relation(relation);
			objectMap.put("nok2Relation", relation);
		}

		if (request.getParameter("nok2ContactNo") != null
				&& !request.getParameter("nok2ContactNo").equals("")) {
			patient.setNok2ContactNo(request.getParameter("nok2ContactNo"));
			objectMap.put("nok2ContactNo",
					request.getParameter("nok2ContactNo"));
		} else if (request.getParameter("srnok2ContactNo") != null
				&& !request.getParameter("srnok2ContactNo").equals("")) {
			patient.setNok2ContactNo(request.getParameter("srnok2ContactNo"));
			objectMap.put("nok2ContactNo",
					request.getParameter("srnok2ContactNo"));
		}

		if (request.getParameter("nok2Address") != null
				&& !request.getParameter("nok2Address").equals("")) {
			patient.setNok2Address(request.getParameter("nok2Address").trim());
			objectMap.put("nok2Address", request.getParameter("nok2Address").trim());
		} else if (request.getParameter("srnok2Address") != null
				&& !request.getParameter("srnok2Address").equals("")) {
			patient.setNok2Address(request.getParameter("srnok2Address").trim());
			objectMap.put("nok2Address", request.getParameter("srnok2Address").trim());
		}

		if (request.getParameter("nok2PoliceStation") != null
				&& !request.getParameter("nok2PoliceStation").equals("")) {
			patient.setNok2PoliceStation(request
					.getParameter("nok2PoliceStation"));
			objectMap.put("nok2PoliceStation",
					request.getParameter("nok2PoliceStation"));
		} else if (request.getParameter("srnok2PoliceStation") != null
				&& !request.getParameter("srnok2PoliceStation").equals("")) {
			patient.setNok2PoliceStation(request
					.getParameter("srnok2PoliceStation"));
			objectMap.put("nok2PoliceStation",
					request.getParameter("srnok2PoliceStation"));
		}

		if (request.getParameter("nok2PinCode") != null
				&& !request.getParameter("nok2PinCode").equals("")) {
			patient.setNok2PinCode(request.getParameter("nok2PinCode"));
			objectMap.put("nok2PinCode", request.getParameter("nok2PinCode"));
		} else if (request.getParameter("srnok2PinCode") != null
				&& !request.getParameter("srnok2PinCode").equals("")) {
			patient.setNok2PinCode(request.getParameter("srnok2PinCode"));
			objectMap.put("nok2PinCode", request.getParameter("srnok2PinCode"));
		}
		if (request.getParameter("srMarriageDate") != null
				&& !request.getParameter("srMarriageDate").equals("")) {
			patient.setSrMarriageDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("srMarriageDate")));
			objectMap.put("srMarriageDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("srMarriageDate")));
		}
		if (request.getParameter("depMarriageDate") != null
				&& !request.getParameter("depMarriageDate").equals("")) {
			patient.setDepMarriageDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("depMarriageDate")));
			objectMap.put("depMarriageDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("depMarriageDate")));
		}
		if (request.getParameter("identificationMark1") != null) {
			patient.setSrIdentificationMark1(request
					.getParameter("identificationMark1"));
			objectMap.put("identificationMark1",
					request.getParameter("identificationMark1"));
		}
		if (request.getParameter("identificationMark2") != null) {
			patient.setSrIdentificationMark2(request
					.getParameter("identificationMark2"));
			objectMap.put("identificationMark2",
					request.getParameter("identificationMark2"));
		}
		if (request.getParameter("depIdentificationMark1") != null) {
			patient.setDepIdentificationMark1(request
					.getParameter("depIdentificationMark1"));
			objectMap.put("depIdentificationMark1",
					request.getParameter("depIdentificationMark1"));
		}
		if (request.getParameter("depIdentificationMark2") != null) {
			patient.setDepIdentificationMark2(request
					.getParameter("depIdentificationMark2"));
			objectMap.put("depIdentificationMark2",
					request.getParameter("depIdentificationMark2"));
		}

		if (serTypeId == 7) {
			MasRelation masRelation = new MasRelation();
			masRelation.setId(8);
			patient.setRelation(masRelation);
			patient.setRank(new MasRank(179));
			patient.setUnit(new MasUnit(257));
		} else {
			if (request.getParameter("reltnId") != null
					&& !request.getParameter("reltnId").equals("0")) {
				servicePersonRelationId = Integer.parseInt(request
						.getParameter("reltnId"));
				MasRelation masRelation = new MasRelation();
				masRelation.setId(servicePersonRelationId);
				patient.setRelation(masRelation);
			} else {
				MasRelation masRelation = new MasRelation();
				masRelation.setId(8);
				patient.setRelation(masRelation);
			}
		}

	

		patient.setPFirstName((request.getParameter(P_FIRST_NAME).trim())
				.toUpperCase());
		objectMap.put("pFirstName",
				(request.getParameter(P_FIRST_NAME).trim()).toUpperCase());
		if (request.getParameter(P_MIDDLE_NAME) != null) {
			patient.setPMiddleName((request.getParameter(P_MIDDLE_NAME).trim())
					.toUpperCase());
			objectMap.put("pMiddleName",
					(request.getParameter(P_MIDDLE_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(P_LAST_NAME) != null) {
			patient.setPLastName((request.getParameter(P_LAST_NAME).trim())
					.toUpperCase());
			objectMap.put("pLastName",
					(request.getParameter(P_LAST_NAME).trim()).toUpperCase());
		}
		if (!request.getParameter(GENDER).equals("0")) {
			int genderId = Integer.parseInt(request.getParameter(GENDER));
			MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
			masAdministrativeSex.setId(genderId);
			patient.setSex(masAdministrativeSex);
			objectMap.put("pSex", masAdministrativeSex);
		}
		String age = "";
		if (request.getParameter(AGE) != null && !request.getParameter(AGE).trim().equals("")) {
						
				age = request.getParameter(AGE).concat(" ").concat("Years");
				patient.setAge(age);
				objectMap.put("pAge", age);
			
		}
	
		if (request.getParameter(DATE_OF_BIRTH) != null
				&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
			Date dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_BIRTH));
			patient.setDateOfBirth(dateOfBirth);
			objectMap.put("pDob", dateOfBirth);
		}

		if (request.getParameter(MARITAL_STATUS_ID) != null
				&& !request.getParameter(MARITAL_STATUS_ID).equals("0")) {
			int maritalStatusId = Integer.parseInt(request
					.getParameter(MARITAL_STATUS_ID));
			MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
			masMaritalStatus.setId(maritalStatusId);
			patient.setMaritalStatus(masMaritalStatus);
			objectMap.put("ptMaritalStatus", masMaritalStatus);
		}
		if (request.getParameter(OCCUPATION_ID) != null
				&& !request.getParameter(OCCUPATION_ID).equals("0")) {
			int occupationId = Integer.parseInt(request
					.getParameter(OCCUPATION_ID));
			MasOccupation masOccupation = new MasOccupation();
			masOccupation.setId(occupationId);
			patient.setOccupation(masOccupation);
			objectMap.put("masOccupation", masOccupation);
		}
		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !request.getParameter(BLOOD_GROUP_ID).equals("")) {
			int bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bloodGroupId);
			patient.setBloodGroup(masBloodGroup);
			objectMap.put("ptBloodGroup", masBloodGroup);
		}
		if (request.getParameter(SR_BLOOD_GROUP_ID) != null
				&& !request.getParameter(SR_BLOOD_GROUP_ID).equals("0")) {
			int bloodGroupId = Integer.parseInt(request
					.getParameter(SR_BLOOD_GROUP_ID));
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bloodGroupId);
			patient.setSrBloodGroup(masBloodGroup);
			if (request.getParameter(RELATION_ID)!= null && (request.getParameter(RELATION_ID).equals("0")
					|| request.getParameter(RELATION_ID).equals("8"))) {
				patient.setBloodGroup(masBloodGroup);
				objectMap.put("ptBloodGroup", masBloodGroup);
			}
			objectMap.put("srBloodGroup", masBloodGroup);
		}

		if (request.getParameter("income") != null) {
			patient.setIncome(request.getParameter("income"));
			objectMap.put("income", request.getParameter("income"));
		}

		if (request.getParameter("dependencyDate") != null
				&& !(request.getParameter("dependencyDate").equals(""))) {
			patient.setDependencyDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyDate")));
			objectMap.put("dependencyDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyDate")));
		}
		if (request.getParameter("authority") != null) {
			patient.setAuthority(request.getParameter("authority"));
			objectMap.put("authority", request.getParameter("authority"));
		}
		if (request.getParameter("dependencyRemovalDate") != null
				&& !(request.getParameter("dependencyRemovalDate").equals(""))) {
			patient.setDependencyRemovalDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyRemovalDate")));
			objectMap.put("dependencyRemovalDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyRemovalDate")));
		}
		if (request.getParameter(DISTRICT) != null
				&& !request.getParameter(DISTRICT).equals("0")) {
			int districtId = Integer.parseInt(request.getParameter(DISTRICT));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			patient.setDistrict(masDistrict);
			objectMap.put("masDistrict", masDistrict);
		}
		if (request.getParameter(ADDRESS) != null) {
			patient.setAddress(request.getParameter(ADDRESS).trim());
			objectMap.put("address", request.getParameter(ADDRESS).trim());
		}

		if (request.getParameter(CONTACT_NUMBER) != null) {
			patient.setContactNo(request.getParameter(CONTACT_NUMBER));
			objectMap.put("contactNo", request.getParameter(CONTACT_NUMBER));
		}

		if (request.getParameter(STATE) != null
				&& !request.getParameter(STATE).equals("0")) {
			int stateId = Integer.parseInt(request.getParameter(STATE));
			MasState masState = new MasState();
			masState.setId(stateId);
			patient.setState(masState);
			objectMap.put("masState", masState);
		}
		Date addEditDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			patient.setAddEditDate(addEditDate);
		}

		String addEditTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			addEditTime = request.getParameter(CHANGED_TIME);
			patient.setAddEditTime(addEditTime);
		}

		Date regDate = null;
		if (request.getParameter(REG_DATE) != null) {
			regDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(REG_DATE));
			patient.setRegDate(regDate);
			objectMap.put("regDate", regDate);
		}
		String regTime = "";
		if (request.getParameter(REG_TIME) != null) {
			regTime = request.getParameter(REG_TIME);
			patient.setRegTime(regTime);
		}

		if (request.getParameter("smokerLess10") != null
				|| request.getParameter("srsmokerLess10") != null) {
			patient.setSmokerLess10("y");
			objectMap.put("smokerLess10", "y");
		} else {
			patient.setSmokerLess10("n");
			objectMap.put("smokerLess10", "n");
		}
		if (request.getParameter("smokerMore10") != null
				|| request.getParameter("smokerMore10") != null) {
			patient.setSmokerMore10("y");
			objectMap.put("smokerMore10", "y");
		} else {
			patient.setSmokerMore10("n");
			objectMap.put("smokerMore10", "n");
		}

		if (request.getParameter("alcohol") != null
				&& !request.getParameter("alcohol").equals("")) {
			patient.setAlcohol(request.getParameter("alcohol"));
			objectMap.put("alcohol", request.getParameter("alcohol"));
		} else if (request.getParameter("sralcohol") != null
				&& !request.getParameter("sralcohol").equals("")) {
			patient.setAlcohol(request.getParameter("sralcohol"));
			objectMap.put("alcohol", request.getParameter("sralcohol"));
		}
		if (request.getParameter("otherFamilyHistory") != null
				&& !request.getParameter("otherFamilyHistory").equals("")) {
			patient.setOtherFamilyHistory(request
					.getParameter("otherFamilyHistory"));
			objectMap.put("otherFamilyHistory",
					request.getParameter("otherFamilyHistory"));
		} else if (request.getParameter("otherSrFamilyHistory") != null
				&& !request.getParameter("otherSrFamilyHistory").equals("")) {
			patient.setOtherFamilyHistory(request
					.getParameter("otherSrFamilyHistory"));
			objectMap.put("otherFamilyHistory",
					request.getParameter("otherSrFamilyHistory"));
		}

		if (request.getParameter("allergies") != null) {
			patient.setDrugAllergies(request.getParameter("allergies"));
			objectMap.put("allergies", request.getParameter("allergies"));
		}
		if (request.getParameter("srAllergies") != null) {
			//patient.setDrugAllergies(request.getParameter("srAllergies"));
			objectMap.put("srallergies", request.getParameter("srAllergies"));
		}
	
		String[] familyHistoryArray = null;
		if (request.getParameterValues("familyHistory") != null) {
			familyHistoryArray = request.getParameterValues("familyHistory");
			objectMap.put("familyHistoryArray", familyHistoryArray);
		} else if (request.getParameterValues("srfamilyHistory") != null) {
			familyHistoryArray = request.getParameterValues("srfamilyHistory");
			objectMap.put("familyHistoryArray", familyHistoryArray);
		}
	

		if (request.getParameter("presentMedCat") != null
				&& !request.getParameter("presentMedCat").equals("0")) {
			Category category = new Category();
			category.setCategoryid(Integer.parseInt(request
					.getParameter("presentMedCat")));
			patient.setCategory(category);
			objectMap.put("category", category);
		}
		
		if (request.getParameter("medCatPeriod") != null
				&& !request.getParameter("medCatPeriod").equals("")) {
			if (request.getParameter("medCatDuration") != null) {
				String medCatDuration = request.getParameter("medCatDuration");
				String finalMedCat = request.getParameter("medCatPeriod")
						.concat(" ").concat(medCatDuration);
				patient.setMedCatPeriod(finalMedCat);
				objectMap.put("medCatPeriod", finalMedCat);
			}
		}

		if (request.getParameter("medCatDate") != null
				&& !request.getParameter("medCatDate").equals("")) {
			patient.setMedCatDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("medCatDate")));
			objectMap.put("medCatDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("medCatDate")));
		}
		if (request.getParameter("echs") != null) {
			patient.setEchsNo(request.getParameter("echs"));
			objectMap.put("echs", request.getParameter("echs"));
		}
		patient.setHospital(masHospital);
		patient.setStatus("y");
		patient.setPatientStatus("Out Patient");
		patient.setInpatientNo(0);
		if (request.getParameter("img1") != null
				&& !request.getParameter("img1").equals("")) {
			map.put("img1", request.getParameter("img1"));
		}
		map.put("regFlag", "reg");

		String[] rptForArr = new String[1];
		rptForArr[0] = "OPD";
		objectMap.put("rptForArr", rptForArr);
	

		List<Visit> visitObjList = new ArrayList<Visit>();
		if (rptForArr != null && rptForArr.length > 0) {
			for (int i = 0; i < rptForArr.length; i++) {
				Visit visit = new Visit();
				visit.setReportingFor(rptForArr[i]);
		
				String tokenAndDoctor = "";
				int tokenNo = 0;
			
				

				if (rptForArr[i].equals("OPD")
						|| rptForArr[i].equals("FollowUp")) {
					if (request.getParameter("roomNo") != null
							&& !request.getParameter("roomNo").equals("")) {
						visit.setRoomNo(Integer.parseInt(request
								.getParameter("roomNo")));
					}
				}
				visit.setTokenNo(tokenNo);
				visit.setTokenDoctor(tokenAndDoctor);

				visit.setHospital(masHospital);
				visit.setAddEditBy(user);
				/*visit.setAge(age);*/
				visit.setVisitDate(addEditDate);
				visit.setAddEditDate(addEditDate);
				visit.setAddEditTime(addEditTime);
				visit.setVisitTime(addEditTime);
				visit.setVisitDate(regDate);
				visit.setVisitTime(regTime);

				visit.setStatus("y"); // ---------commented by anamika
				// visit.setEdStatus("n");

				visit.setAppointmentType("D");
				if (rptForArr[i].equals("MedExam")) {
					if (request.getParameter("medExamCategory") != null
							&& !(request.getParameter("medExamCategory"))
									.equals("")) {
						visit.setMedExamType(request
								.getParameter("medExamCategory"));
						visit.setVisitStatus("c");
						visit.setMedStatus("w");
					}
				} else if (rptForArr[i].equals("MedBoard")) {
					if (request.getParameter("medBoardCategory") != null
							&& !(request.getParameter("medBoardCategory"))
									.equals("")) {
						visit.setMedExamType(request
								.getParameter("medBoardCategory"));
						visit.setMedStatus("w");
						visit.setVisitStatus("c");
					}
				} else if (rptForArr[i].equals("FamilyWC")) {
					if (request.getParameter("fwcCategory") != null
							&& !(request.getParameter("fwcCategory"))
									.equals("")) {
						visit.setFwcCategory(request
								.getParameter("fwcCategory"));
						visit.setVisitStatus("w");
					}
				} else {
					visit.setVisitStatus("w");
				}

				if (request.getParameter("priority") != null) {
					visit.setPriority(Integer.parseInt(request
							.getParameter("priority")));
				}
				if (rptForArr[i].equals("FollowUp")
						&& request.getParameter("followUpDepartment") != null
						&& request.getParameter("followUpDepartment").equals(
								"FamilyWC")) {
					visit.setFollowUpDepartment(request
							.getParameter("followUpDepartment"));
					visit.setFwcCategory("PNC");
				} else {
					if (request.getParameter("followUpDepartment") != null
							&& rptForArr[i].equals("FollowUp")) {
						visit.setFollowUpDepartment(request
								.getParameter("followUpDepartment"));
					}
				}
				objectMap.put("visit", visit);
				visitObjList.add(visit);
				objectMap.put("visitObjList", visitObjList);
			}
		}

		if (request.getParameter("regHinId") != null
				&& !request.getParameter("regHinId").equals("0")
				&& !request.getParameter("regHinId").equals("")) {
			objectMap.put("regHinId",
					Integer.parseInt(request.getParameter("regHinId")));
		} else if (request.getParameter("selfRegHin") != null
				&& !request.getParameter("selfRegHin").equals("")
				&& !request.getParameter("selfRegHin").equals("")) {
			objectMap.put("selfRegHin",
					Integer.parseInt(request.getParameter("selfRegHin")));
		}

		

		int allergyCount = 0;
		if (request.getParameter("allergyCount") != null
				&& !(request.getParameter("allergyCount").equals(""))) {
			allergyCount = Integer.parseInt(request
					.getParameter("allergyCount"));
		}
		
		if (allergyCount > 0) {
			List<Integer> allergyDetailsIdList = new ArrayList<Integer>();
			List<String> allergyNameList = new ArrayList<String>();
			List<String> descList = new ArrayList<String>();
			List<String> severityList = new ArrayList<String>();
			List<String> sinceList = new ArrayList<String>();
			List<String> remarksList = new ArrayList<String>();

			for (int j = 1; j <= allergyCount; j++) {
				if (request.getParameter("allergyDetailsId" + j) != null
						&& !request.getParameter("allergyDetailsId" + j)
								.equals("")) {
					allergyDetailsIdList.add(Integer.parseInt(request
							.getParameter("allergyDetailsId" + j)));
				} else {
					allergyDetailsIdList.add(0);
				}
				if (request.getParameter("allergyName" + j) != null
						&& !request.getParameter("allergyName" + j).equals("")) {
					allergyNameList
							.add(request.getParameter("allergyName" + j));
				}
				if (request.getParameter("description" + j) != null) {
					descList.add(request.getParameter("description" + j));
				}
				if (request.getParameter("severity" + j) != null) {
					severityList.add(request.getParameter("severity" + j));
				}
				if (request.getParameter("since" + j) != null) {
					sinceList.add(request.getParameter("since" + j));
				}
				if (request.getParameter("remarks" + j) != null) {
					remarksList.add(request.getParameter("remarks" + j));
				}

			}
			objectMap.put("allergyDetailsIdList", allergyDetailsIdList);
			objectMap.put("allergyNameList", allergyNameList);
			objectMap.put("descList", descList);
			objectMap.put("severityList", severityList);
			objectMap.put("sinceList", sinceList);
			objectMap.put("remarksList", remarksList);

		}
		if (request.getParameter("ldapData") != null) {
			objectMap.put("ldapData", request.getParameter("ldapData"));
		}
		if (request.getParameter("patientTypeName") != null) {
			objectMap.put("patientTypeName",
					request.getParameter("patientTypeName"));
		}
		if (request.getParameter("visitByAdmin") != null) {
			objectMap.put("visitByAdmin",
					request.getParameter("visitByAdmin"));
		}
		/**
		 * 
		 */
		objectMap.put("hinNo", hinNo);
		objectMap.put("patient", patient);

		Box box = HMSUtil.getBox(request);
		objectMap.put("box", box);
		String userSrNo = (String) session.getAttribute("userSrNo");
		objectMap.put("userSrNo", userSrNo);

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;
		List<Patient> existingHinNoList = new ArrayList<Patient>();
		List<Visit> visitList = new ArrayList<Visit>();

		detailsMap = registrationHandlerService
				.submitPatientInformationEmployeeVisit(objectMap, request);
	

		if (detailsMap.get("existingHinNoList") != null) {
			existingHinNoList = (List<Patient>) detailsMap
					.get("existingHinNoList");
		}
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message =(String)detailsMap.get("msg");
		
		

		dataMap.put("users", user);
		
		System.out.println("after submit");		
		String jsp = "msgForVisitOfHALEmployees.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("existingHinNoList", existingHinNoList);
		map.put("hinNo", objectMap.get("hinNo"));
		map.put("visit_id", detailsMap.get("visit_id"));
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitPatientInformationOnlineEmployeeVisit(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Patient patient = new Patient();

		int servicePersonRelationId = 0;
		int serTypeId = 0;
		int aPAId = 0;
		String hinNo = "";
		String serviceNo = "";
		Map<String, Object> objectMap = new HashMap<String, Object>();

		Users user = (Users) session.getAttribute("users");
		patient.setAddEditBy(user);
		patient.setBillable("n");
		objectMap.put("user", user);

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);

		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			patient.setHinNo(hinNo);
			patient.setPreviousHinNo(hinNo);

		}
		if(request.getParameter("aPAId")!= null && !request.getParameter("aPAId").trim().equals("")){
			aPAId = Integer.parseInt(request.getParameter("aPAId"));
			objectMap.put("aPAId", aPAId);
		}
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = HMSUtil.restrictMetaChar(request
					.getParameter(SERVICE_NO)); //
			serviceNo = request.getParameter(SERVICE_NO);
			patient.setServiceNo(serviceNo.trim());
		}

		/*
		 * MasServiceType masServiceType = new MasServiceType(); serTypeId =
		 * Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
		 * masServiceType
		 * .setId(Integer.parseInt(request.getParameter(SERVICE_TYPE_ID)));
		 * patient.setServiceType(masServiceType);
		 */

		/*
		 * String suffix = ""; if (request.getParameter(SUFFIX) != null&&
		 * !request.getParameter(SUFFIX).equals("")) { suffix =
		 * HMSUtil.restrictMetaChar(request.getParameter(SUFFIX)); // suffix =
		 * request.getParameter(SUFFIX); } patient.setSuffix(suffix);
		 * objectMap.put("suffix", suffix);
		 */
		/*
		 * String prefix = ""; if (request.getParameter(PREFIX) != null &&
		 * !request.getParameter(PREFIX).equals("")) { prefix =
		 * HMSUtil.restrictMetaChar(request.getParameter(PREFIX)); // prefix =
		 * request.getParameter(PREFIX); } patient.setPrefix(prefix.trim());
		 * objectMap.put("prefix", prefix);
		 */
		/*
		 * int serviceStatusId = 0; if (request.getParameter(SERVICE_STATUS_ID)
		 * != null && !request.getParameter(SERVICE_STATUS_ID).equals("0")) {
		 * serviceStatusId = Integer.parseInt(request
		 * .getParameter(SERVICE_STATUS_ID)); MasServiceStatus masServiceStatus
		 * = new MasServiceStatus(); masServiceStatus.setId(serviceStatusId);
		 * patient.setServiceStatus(masServiceStatus); }
		 */

		if (request.getParameter(RANK_ID) != null
				&& !request.getParameter(RANK_ID).equals("0")) {
			int rankId = Integer.parseInt(request.getParameter(RANK_ID));
			MasRank masRank = new MasRank();
			masRank.setId(rankId);
			patient.setRank(masRank);
			objectMap.put("masRank", masRank);
		}

		if (request.getParameter(S_FIRST_NAME) != null) {
			patient.setSFirstName((request.getParameter(S_FIRST_NAME).trim())
					.toUpperCase());
			objectMap.put("sFirstName",
					(request.getParameter(S_FIRST_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(S_MIDDLE_NAME) != null) {
			patient.setSMiddleName((request.getParameter(S_MIDDLE_NAME).trim())
					.toUpperCase());
			objectMap.put("sMiddleName",
					(request.getParameter(S_MIDDLE_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(S_LAST_NAME) != null) {
			patient.setSLastName((request.getParameter(S_LAST_NAME).trim())
					.toUpperCase());
			objectMap.put("sLastName",
					(request.getParameter(S_LAST_NAME).trim()).toUpperCase());
		}

		/*
		 * if (request.getParameter(TRADE_ID) != null &&
		 * !request.getParameter(TRADE_ID).equals("0")) {
		 * if(!request.getParameter(TRADE_ID).equals("31")){ // for other int
		 * tradeId = Integer.parseInt(request.getParameter(TRADE_ID)); MasTrade
		 * masTrade = new MasTrade(); masTrade.setId(tradeId);
		 * patient.setTrade(masTrade); objectMap.put("masTrade",masTrade); }
		 * else if (request.getParameter(TRADE_NAME)!= null &&
		 * !request.getParameter(TRADE_NAME).equals("")) { MasTrade masTradeObj
		 * = new MasTrade();
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request .getParameter(TRADE_NAME) + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masTradeObj .setTradeName("" + output_str2);
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) { masTradeObj
		 * .setLastChgBy(request.getParameter(CHANGED_BY)); }
		 * 
		 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE));
		 * masTradeObj.setLastChgDate(changedDate);
		 * masTradeObj.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masTradeObj.setStatus("n");
		 * 
		 * objectMap.put("masTradeObj", masTradeObj ); } }
		 */
		if (request.getParameter(RECORD_OFFICE_ADDRESS_ID) != null
				&& !request.getParameter(RECORD_OFFICE_ADDRESS_ID).equals("0")) {
			int recordOfficeAddId = Integer.parseInt(request
					.getParameter(RECORD_OFFICE_ADDRESS_ID));
			MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
			masRecordOfficeAddress.setId(recordOfficeAddId);
			patient.setRecordOfficeAddress(masRecordOfficeAddress);
			objectMap.put("masRecordOfficeAddress", masRecordOfficeAddress);
		}
		/*
		 * if (request.getParameter(UNIT_ID) != null &&
		 * !request.getParameter(UNIT_ID).equals("0")) {
		 * if(!request.getParameter(UNIT_ID).equals("other")){ int unitId =
		 * Integer.parseInt(request.getParameter(UNIT_ID)); MasUnit masUnit =
		 * new MasUnit(); masUnit.setId(unitId); patient.setUnit(masUnit);
		 * objectMap.put("masUnit",masUnit); } else if
		 * (request.getParameter(UNIT_NAME)!=null &&
		 * !request.getParameter(UNIT_NAME).equals("")) { MasUnit masUnitObj =
		 * new MasUnit(); if (request.getParameter(UNIT_NAME) != null) {
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request .getParameter(UNIT_NAME) + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masUnitObj.setUnitName("" + output_str2); } if
		 * (request.getParameter(UNIT_ADDRESS) != null) {
		 * 
		 * StringBuffer output_str3 = new StringBuffer(); StringTokenizer s3 =
		 * new StringTokenizer(request .getParameter(UNIT_ADDRESS) + "", "\'");
		 * 
		 * while (s3.hasMoreTokens()) { output_str3.append(s3.nextToken()); if
		 * (s3.hasMoreTokens()) { output_str3.append(" "); } }
		 * 
		 * StringBuffer output_str4 = new StringBuffer(); StringTokenizer s4 =
		 * new StringTokenizer(output_str3 + "", "\"");
		 * 
		 * while (s4.hasMoreTokens()) { output_str4.append(s4.nextToken()); if
		 * (s4.hasMoreTokens()) { output_str4.append(" "); } }
		 * masUnitObj.setUnitAddress("" + output_str4); }
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) {
		 * masUnitObj.setLastChgBy(request.getParameter(CHANGED_BY)); } if
		 * (request.getParameter(LOCAL_UNIT) != null) {
		 * masUnitObj.setLocalUnit("y"); } else { masUnitObj.setLocalUnit("n");
		 * } Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE)); masUnitObj.setLastChgDate(changedDate);
		 * masUnitObj.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masUnitObj.setStatus("n"); objectMap.put("masUnitObj", masUnitObj); }
		 * }
		 */

		/*
		 * if(serviceStatusId == 2){ MasUnit masUnit = new MasUnit();
		 * masUnit.setId(257); patient.setUnit(masUnit); }
		 */

		/*
		 * if(request.getParameter("commissionDate") != null &&
		 * !(request.getParameter("commissionDate").equals(""))){
		 * patient.setCommissionDate
		 * (HMSUtil.convertStringTypeDateToDateType(request
		 * .getParameter("commissionDate")));
		 * objectMap.put("commisionDate",HMSUtil
		 * .convertStringTypeDateToDateType(
		 * request.getParameter("commissionDate"))); } if
		 * (request.getParameter(TOTAL_SERVICE) != null &&
		 * !request.getParameter(TOTAL_SERVICE).equals("")) {
		 * patient.setServiceYears(Float.parseFloat(request
		 * .getParameter(TOTAL_SERVICE)));
		 * objectMap.put("totalService",Float.parseFloat(request
		 * .getParameter(TOTAL_SERVICE))); } if
		 * (request.getParameter(TOTAL_SERVICE_PERIOD) != null &&
		 * !request.getParameter(TOTAL_SERVICE_PERIOD).equals("")) {
		 * patient.setTotalServicePeriod(request
		 * .getParameter(TOTAL_SERVICE_PERIOD)); } if
		 * (request.getParameter(STATION) != null &&
		 * !request.getParameter(STATION).equals("")) { if(
		 * !request.getParameter(STATION).equals("other")){
		 * patient.setStation(request.getParameter(STATION));
		 * objectMap.put("station", request.getParameter(STATION)); }else
		 * if(request.getParameter("stationName") != null){
		 * patient.setStation(request.getParameter("stationName"));
		 * 
		 * MasStation masStation = new MasStation();
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request .getParameter("stationName") + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masStation.setStationName("" + output_str2);
		 * masStation.setStationCode(output_str2.substring(0, 3));
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) { masStation
		 * .setLastChgBy(user); }
		 * 
		 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE)); masStation.setLastChgDate(changedDate);
		 * masStation.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masStation.setStatus("n");
		 * 
		 * objectMap.put("masStation", masStation );
		 * 
		 * } }
		 */
		/*
		 * if(request.getParameter(COMMAND) != null &&
		 * !(request.getParameter(COMMAND).equals("0"))){
		 * if(!(request.getParameter(COMMAND).equals("other"))){ MasCommand
		 * command = new MasCommand();
		 * command.setId(Integer.parseInt(request.getParameter(COMMAND)));
		 * patient.setCommand(command); objectMap.put("command", command); }else
		 * if (request.getParameter("commandName")!= null &&
		 * !request.getParameter("commandName").equals("")) { MasCommand
		 * masCommand = new MasCommand();
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request.getParameter("commandName") + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masCommand.setCommandName("" + output_str2);
		 * masCommand.setCommandCode(output_str2.substring(0, 3));
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) {
		 * masCommand.setLastChgBy(user); }
		 * 
		 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE)); masCommand.setLastChgDate(changedDate);
		 * masCommand.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masCommand.setStatus("n");
		 * 
		 * objectMap.put("masCommand", masCommand ); } }
		 * if(request.getParameter(SECTION_ID) != null &&
		 * !(request.getParameter(SECTION_ID).equals("0"))){
		 * if(!(request.getParameter(SECTION_ID).equals("other"))){ MasSection
		 * section = new MasSection();
		 * section.setId(Integer.parseInt(request.getParameter(SECTION_ID)));
		 * patient.setSection(section); objectMap.put("section", section); }else
		 * if (request.getParameter("sectionName")!= null &&
		 * !request.getParameter("sectionName").equals("")) { MasSection
		 * masSection = new MasSection();
		 * 
		 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 =
		 * new StringTokenizer(request.getParameter("sectionName") + "", "\'");
		 * 
		 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
		 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
		 * 
		 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 =
		 * new StringTokenizer(output_str1 + "", "\"");
		 * 
		 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
		 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
		 * 
		 * masSection.setSectionName("" + output_str2);
		 * masSection.setSectionCode(output_str2.substring(0, 3));
		 * 
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) {
		 * masSection.setLastChgBy(user); }
		 * 
		 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
		 * .getParameter(CHANGED_DATE)); masSection.setLastChgDate(changedDate);
		 * masSection.setLastChgTime(request.getParameter(CHANGED_TIME));
		 * masSection.setStatus("y"); masSection.setHospital(masHospital);
		 * 
		 * objectMap.put("masSection", masSection ); } }
		 */

		if (request.getParameter(SR_SEX) != null
				&& !(request.getParameter(SR_SEX).equals("0"))) {
			MasAdministrativeSex admsex = new MasAdministrativeSex();
			admsex.setId(Integer.parseInt(request.getParameter(SR_SEX)));
			patient.setSrSex(admsex);
			objectMap.put("srSex", admsex);
		}

		if (request.getParameter(SR_AGE) != null) {
			if (request.getParameter(SR_AGE_UNIT) != null) {
				String ageUnit = request.getParameter(SR_AGE_UNIT);
				String srage = request.getParameter(SR_AGE).concat(" ")
						.concat(ageUnit);
				patient.setSrAge(srage);
				objectMap.put("srAge", srage);
			}
		}
		if (request.getParameter(SR_DOB) != null
				&& !(request.getParameter(SR_DOB).equals(""))) {
			patient.setSrDob(HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(SR_DOB)));
			objectMap.put("srDob", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(SR_DOB)));
		}

		if (request.getParameter("srMaritalStatus") != null
				&& !(request.getParameter("srMaritalStatus").equals("0"))) {
			MasMaritalStatus maritalStatus = new MasMaritalStatus();
			maritalStatus.setId(Integer.parseInt(request
					.getParameter("srMaritalStatus")));
			patient.setSrMaritalStatus(maritalStatus);
			objectMap.put("maritalStatus", maritalStatus);
		}

		if (request.getParameter(SERV_BLD_GROUP) != null
				&& !request.getParameter(SERV_BLD_GROUP).equals("0")) {
			int bldGrpId = Integer.parseInt(request
					.getParameter(SERV_BLD_GROUP));
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bldGrpId);
			patient.setSrBloodGroup(masBloodGroup);
			objectMap.put("masBloodGroup", masBloodGroup);
		}

		if (request.getParameter(RELIGION_ID) != null
				&& !request.getParameter(RELIGION_ID).equals("0")) {
			int religionId = Integer
					.parseInt(request.getParameter(RELIGION_ID));
			MasReligion masReligion = new MasReligion();
			masReligion.setId(religionId);
			patient.setReligion(masReligion);
			objectMap.put("masReligion", masReligion);
		}

		if (request.getParameter(TELEPHONE_NO) != null) {
			patient.setPhoneNumber(request.getParameter(TELEPHONE_NO));
			objectMap.put("telephoneNo", request.getParameter(TELEPHONE_NO));
		}
		if (request.getParameter(MOBILE_NO) != null) {
			patient.setMobileNumber(request.getParameter(MOBILE_NO));
			objectMap.put("mobileNo", request.getParameter(MOBILE_NO));
		}
		if (request.getParameter("afnetNo") != null) {
			patient.setAfnetNo(request.getParameter("afnetNo"));
			objectMap.put("afnetNo", request.getParameter("afnetNo"));
		}

		if (request.getParameter(PERMANENT_ADDRESS) != null) {
			patient.setPermanentAddress(request.getParameter(PERMANENT_ADDRESS));
			objectMap.put("permanentAddress",
					request.getParameter(PERMANENT_ADDRESS));
		}
		if (request.getParameter("phoneNoRes") != null) {
			patient.setTelephoneResi(request.getParameter("phoneNoRes"));
			objectMap.put("telephoneResi", request.getParameter("phoneNoRes"));
		}
		if (request.getParameter("permCityId") != null
				&& !request.getParameter("permCityId").equals("0")) {
			MasDistrict district = new MasDistrict();
			district.setId(Integer.parseInt(request.getParameter("permCityId")));
			patient.setPermanentCity(district);
			objectMap.put("permanentCity", district);
		}
		if (request.getParameter("permStateId") != null
				&& !request.getParameter("permStateId").equals("0")) {
			MasState state = new MasState();
			state.setId(Integer.parseInt(request.getParameter("permStateId")));
			patient.setPermanentState(state);
			objectMap.put("permanentState", state);
		}
		if (request.getParameter(NEXT_OF_KIN_NAME) != null
				&& !request.getParameter(NEXT_OF_KIN_NAME).equals("")) {
			patient.setNextOfKinName(request.getParameter(NEXT_OF_KIN_NAME));
			objectMap.put("nok1Name", request.getParameter(NEXT_OF_KIN_NAME));
		}
		if (request.getParameter("telephoneNoPerm") != null) {
			patient.setTelephoneNoPerm(request.getParameter("telephoneNoPerm"));
			objectMap.put("telephoneNoPerm",
					request.getParameter("telephoneNoPerm"));
		}
		if (request.getParameter("otherContactNo") != null) {
			patient.setOtherContactNo(request.getParameter("otherContactNo"));
			objectMap.put("otherContactNo",
					request.getParameter("otherContactNo"));
		}
		if (request.getParameter("policeStation") != null) {
			patient.setPoliceStation(request.getParameter("policeStation"));
			objectMap.put("policeStation",
					request.getParameter("policeStation"));
		}
		if (request.getParameter("pinCode") != null) {
			patient.setPinCode(request.getParameter("pinCode"));
			objectMap.put("pinCode", request.getParameter("pinCode"));
		}
		if (request.getParameter(NEXT_OF_KIN_PHONE_NO) != null
				&& !request.getParameter(NEXT_OF_KIN_PHONE_NO).equals("")) {
			patient.setNextOfKinPhoneNumber(request
					.getParameter(NEXT_OF_KIN_PHONE_NO));
			objectMap.put("nok1Phone",
					request.getParameter(NEXT_OF_KIN_PHONE_NO));
		} else if (request.getParameter(SR_NEXT_OF_KIN_PHONE_NO) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_PHONE_NO).equals("")) {
			patient.setNextOfKinPhoneNumber(request
					.getParameter(SR_NEXT_OF_KIN_PHONE_NO));
			objectMap.put("nok1Phone",
					request.getParameter(SR_NEXT_OF_KIN_PHONE_NO));
		}
		if (request.getParameter(NEXT_OF_KIN_ADDRESS) != null
				&& !request.getParameter(NEXT_OF_KIN_ADDRESS).equals("")) {
			patient.setNextOfKinAddress(request
					.getParameter(NEXT_OF_KIN_ADDRESS));
			objectMap.put("nok1Address",
					request.getParameter(NEXT_OF_KIN_ADDRESS));
		} else if (request.getParameter(SR_NEXT_OF_KIN_ADDRESS) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_ADDRESS).equals("")) {
			patient.setNextOfKinAddress(request
					.getParameter(SR_NEXT_OF_KIN_ADDRESS));
			objectMap.put("nok1Address",
					request.getParameter(SR_NEXT_OF_KIN_ADDRESS));
		}
		if (request.getParameter(NEXT_OF_KIN_RELATION_ID) != null
				&& !request.getParameter(NEXT_OF_KIN_RELATION_ID).equals("0")) {
			int nextOfKinRelationId = Integer.parseInt(request
					.getParameter(NEXT_OF_KIN_RELATION_ID));
			MasRelation relation = new MasRelation();
			relation.setId(nextOfKinRelationId);
			patient.setNextOfKinRelation(relation);
			objectMap.put("nok1Relation", relation);
		} else if (request.getParameter(SR_NEXT_OF_KIN_RELATION_ID) != null
				&& !request.getParameter(SR_NEXT_OF_KIN_RELATION_ID)
						.equals("0")) {
			int nextOfKinRelationId = Integer.parseInt(request
					.getParameter(SR_NEXT_OF_KIN_RELATION_ID));
			MasRelation relation = new MasRelation();
			relation.setId(nextOfKinRelationId);
			patient.setNextOfKinRelation(relation);
			objectMap.put("nok1Relation", relation);
		}

		if (request.getParameter("nok1PoliceStation") != null
				&& !request.getParameter("nok1PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("nok1PoliceStation"));
			objectMap.put("nok1PoliceStation",
					request.getParameter("nok1PoliceStation"));
		} else if (request.getParameter("srnok1PoliceStation") != null
				&& !request.getParameter("srnok1PoliceStation").equals("")) {
			patient.setNok1PoliceStation(request
					.getParameter("srnok1PoliceStation"));
			objectMap.put("nok1PoliceStation",
					request.getParameter("srnok1PoliceStation"));
		}

		if (request.getParameter("nok1PinCode") != null
				&& !request.getParameter("nok1PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("nok1PinCode"));
			objectMap.put("nok1PinCode", request.getParameter("nok1PinCode"));
		} else if (request.getParameter("srnok1PinCode") != null
				&& !request.getParameter("srnok1PinCode").equals("")) {
			patient.setNok1PinCode(request.getParameter("srnok1PinCode"));
			objectMap.put("nok1PinCode", request.getParameter("srnok1PinCode"));
		}

		if (request.getParameter("nok2Name") != null
				&& !request.getParameter("nok2Name").equals("")) {
			patient.setNok2Name(request.getParameter("nok2Name"));
			objectMap.put("nok2Name", request.getParameter("nok2Name"));
		} 
		if (request.getParameter("nok2RelationId") != null
				&& !request.getParameter("nok2RelationId").equals("0")) {
			int nok2RelationId = Integer.parseInt(request
					.getParameter("nok2RelationId"));
			MasRelation relation = new MasRelation();
			relation.setId(nok2RelationId);
			patient.setNok2Relation(relation);
			objectMap.put("nok2Relation", relation);
		} else if (request.getParameter("srnok2RelationId") != null
				&& !request.getParameter("srnok2RelationId").equals("0")) {
			int nok2RelationId = Integer.parseInt(request
					.getParameter("srnok2RelationId"));
			MasRelation relation = new MasRelation();
			relation.setId(nok2RelationId);
			patient.setNok2Relation(relation);
			objectMap.put("nok2Relation", relation);
		}

		if (request.getParameter("nok2ContactNo") != null
				&& !request.getParameter("nok2ContactNo").equals("")) {
			patient.setNok2ContactNo(request.getParameter("nok2ContactNo"));
			objectMap.put("nok2ContactNo",
					request.getParameter("nok2ContactNo"));
		} else if (request.getParameter("srnok2ContactNo") != null
				&& !request.getParameter("srnok2ContactNo").equals("")) {
			patient.setNok2ContactNo(request.getParameter("srnok2ContactNo"));
			objectMap.put("nok2ContactNo",
					request.getParameter("srnok2ContactNo"));
		}

		if (request.getParameter("nok2Address") != null
				&& !request.getParameter("nok2Address").equals("")) {
			patient.setNok2Address(request.getParameter("nok2Address"));
			objectMap.put("nok2Address", request.getParameter("nok2Address"));
		} else if (request.getParameter("srnok2Address") != null
				&& !request.getParameter("srnok2Address").equals("")) {
			patient.setNok2Address(request.getParameter("srnok2Address"));
			objectMap.put("nok2Address", request.getParameter("srnok2Address"));
		}

		if (request.getParameter("nok2PoliceStation") != null
				&& !request.getParameter("nok2PoliceStation").equals("")) {
			patient.setNok2PoliceStation(request
					.getParameter("nok2PoliceStation"));
			objectMap.put("nok2PoliceStation",
					request.getParameter("nok2PoliceStation"));
		} else if (request.getParameter("srnok2PoliceStation") != null
				&& !request.getParameter("srnok2PoliceStation").equals("")) {
			patient.setNok2PoliceStation(request
					.getParameter("srnok2PoliceStation"));
			objectMap.put("nok2PoliceStation",
					request.getParameter("srnok2PoliceStation"));
		}

		if (request.getParameter("nok2PinCode") != null
				&& !request.getParameter("nok2PinCode").equals("")) {
			patient.setNok2PinCode(request.getParameter("nok2PinCode"));
			objectMap.put("nok2PinCode", request.getParameter("nok2PinCode"));
		} else if (request.getParameter("srnok2PinCode") != null
				&& !request.getParameter("srnok2PinCode").equals("")) {
			patient.setNok2PinCode(request.getParameter("srnok2PinCode"));
			objectMap.put("nok2PinCode", request.getParameter("srnok2PinCode"));
		}
		if (request.getParameter("srMarriageDate") != null
				&& !request.getParameter("srMarriageDate").equals("")) {
			patient.setSrMarriageDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("srMarriageDate")));
			objectMap.put("srMarriageDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("srMarriageDate")));
		}
		if (request.getParameter("depMarriageDate") != null
				&& !request.getParameter("depMarriageDate").equals("")) {
			patient.setDepMarriageDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("depMarriageDate")));
			objectMap.put("depMarriageDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("depMarriageDate")));
		}
		if (request.getParameter("identificationMark1") != null) {
			patient.setSrIdentificationMark1(request
					.getParameter("identificationMark1"));
			objectMap.put("identificationMark1",
					request.getParameter("identificationMark1"));
		}
		if (request.getParameter("identificationMark2") != null) {
			patient.setSrIdentificationMark2(request
					.getParameter("identificationMark2"));
			objectMap.put("identificationMark2",
					request.getParameter("identificationMark2"));
		}
		if (request.getParameter("depIdentificationMark1") != null) {
			patient.setDepIdentificationMark1(request
					.getParameter("depIdentificationMark1"));
			objectMap.put("depIdentificationMark1",
					request.getParameter("depIdentificationMark1"));
		}
		if (request.getParameter("depIdentificationMark2") != null) {
			patient.setDepIdentificationMark2(request
					.getParameter("depIdentificationMark2"));
			objectMap.put("depIdentificationMark2",
					request.getParameter("depIdentificationMark2"));
		}

		if (serTypeId == 7) {
			MasRelation masRelation = new MasRelation();
			masRelation.setId(8);
			patient.setRelation(masRelation);
			patient.setRank(new MasRank(179));
			patient.setUnit(new MasUnit(257));
		} else {
			if (request.getParameter("reltnId") != null
					&& !request.getParameter("reltnId").equals("0")) {
				servicePersonRelationId = Integer.parseInt(request
						.getParameter("reltnId"));
				MasRelation masRelation = new MasRelation();
				masRelation.setId(servicePersonRelationId);
				patient.setRelation(masRelation);
			} else {
				MasRelation masRelation = new MasRelation();
				masRelation.setId(8);
				patient.setRelation(masRelation);
			}
		}

		/*if (!request.getParameter(TITLE).equals("0")) {
			int titleId = Integer.parseInt(request.getParameter(TITLE));
			MasTitle masTitle = new MasTitle();
			masTitle.setId(titleId);
			patient.setTitle(masTitle);
		}*/

		patient.setPFirstName((request.getParameter(P_FIRST_NAME).trim())
				.toUpperCase());
		objectMap.put("pFirstName",
				(request.getParameter(P_FIRST_NAME).trim()).toUpperCase());
		if (request.getParameter(P_MIDDLE_NAME) != null) {
			patient.setPMiddleName((request.getParameter(P_MIDDLE_NAME).trim())
					.toUpperCase());
			objectMap.put("pMiddleName",
					(request.getParameter(P_MIDDLE_NAME).trim()).toUpperCase());
		}
		if (request.getParameter(P_LAST_NAME) != null) {
			patient.setPLastName((request.getParameter(P_LAST_NAME).trim())
					.toUpperCase());
			objectMap.put("pLastName",
					(request.getParameter(P_LAST_NAME).trim()).toUpperCase());
		}
		if (!request.getParameter(GENDER).equals("0")) {
			int genderId = Integer.parseInt(request.getParameter(GENDER));
			MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
			masAdministrativeSex.setId(genderId);
			patient.setSex(masAdministrativeSex);
			objectMap.put("pSex", masAdministrativeSex);
		}
		String age = "";
		if (request.getParameter(AGE) != null && !request.getParameter(AGE).trim().equals("")) {
						
				age = request.getParameter(AGE).concat(" ").concat("Years");
				patient.setAge(age);
				objectMap.put("pAge", age);
			
		}
		/*System.out.println(request.getParameter(AGE));
		if (request.getParameter("ageLabel") != null
				&& !(request.getParameter("ageLabel").equals(""))) {
			age = request.getParameter("ageLabel");
			patient.setAge(age);
		}*/
		if (request.getParameter(DATE_OF_BIRTH) != null
				&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
			Date dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_BIRTH));
			patient.setDateOfBirth(dateOfBirth);
			objectMap.put("pDob", dateOfBirth);
		}

		if (request.getParameter(MARITAL_STATUS_ID) != null
				&& !request.getParameter(MARITAL_STATUS_ID).equals("0")) {
			int maritalStatusId = Integer.parseInt(request
					.getParameter(MARITAL_STATUS_ID));
			MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
			masMaritalStatus.setId(maritalStatusId);
			patient.setMaritalStatus(masMaritalStatus);
			objectMap.put("ptMaritalStatus", masMaritalStatus);
		}
		if (request.getParameter(OCCUPATION_ID) != null
				&& !request.getParameter(OCCUPATION_ID).equals("0")) {
			int occupationId = Integer.parseInt(request
					.getParameter(OCCUPATION_ID));
			MasOccupation masOccupation = new MasOccupation();
			masOccupation.setId(occupationId);
			patient.setOccupation(masOccupation);
			objectMap.put("masOccupation", masOccupation);
		}
		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !request.getParameter(BLOOD_GROUP_ID).equals("0")) {
			int bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bloodGroupId);
			patient.setBloodGroup(masBloodGroup);
			objectMap.put("ptBloodGroup", masBloodGroup);
		}
		if (request.getParameter(SR_BLOOD_GROUP_ID) != null
				&& !request.getParameter(SR_BLOOD_GROUP_ID).equals("0")) {
			int bloodGroupId = Integer.parseInt(request
					.getParameter(SR_BLOOD_GROUP_ID));
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bloodGroupId);
			patient.setSrBloodGroup(masBloodGroup);
			if (request.getParameter(RELATION_ID)!= null && (request.getParameter(RELATION_ID).equals("0")
					|| request.getParameter(RELATION_ID).equals("8"))) {
				patient.setBloodGroup(masBloodGroup);
				objectMap.put("ptBloodGroup", masBloodGroup);
			}
			objectMap.put("srBloodGroup", masBloodGroup);
		}

		if (request.getParameter("income") != null) {
			patient.setIncome(request.getParameter("income"));
			objectMap.put("income", request.getParameter("income"));
		}

		if (request.getParameter("dependencyDate") != null
				&& !(request.getParameter("dependencyDate").equals(""))) {
			patient.setDependencyDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyDate")));
			objectMap.put("dependencyDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyDate")));
		}
		if (request.getParameter("authority") != null) {
			patient.setAuthority(request.getParameter("authority"));
			objectMap.put("authority", request.getParameter("authority"));
		}
		if (request.getParameter("dependencyRemovalDate") != null
				&& !(request.getParameter("dependencyRemovalDate").equals(""))) {
			patient.setDependencyRemovalDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyRemovalDate")));
			objectMap.put("dependencyRemovalDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("dependencyRemovalDate")));
		}
		if (request.getParameter(DISTRICT) != null
				&& !request.getParameter(DISTRICT).equals("0")) {
			int districtId = Integer.parseInt(request.getParameter(DISTRICT));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			patient.setDistrict(masDistrict);
			objectMap.put("masDistrict", masDistrict);
		}
		if (request.getParameter(ADDRESS) != null) {
			patient.setAddress(request.getParameter(ADDRESS));
			objectMap.put("address", request.getParameter(ADDRESS));
		}

		if (request.getParameter(CONTACT_NUMBER) != null) {
			patient.setContactNo(request.getParameter(CONTACT_NUMBER));
			objectMap.put("contactNo", request.getParameter(CONTACT_NUMBER));
		}

		if (request.getParameter(STATE) != null
				&& !request.getParameter(STATE).equals("0")) {
			int stateId = Integer.parseInt(request.getParameter(STATE));
			MasState masState = new MasState();
			masState.setId(stateId);
			patient.setState(masState);
			objectMap.put("masState", masState);
		}
		Date addEditDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			patient.setAddEditDate(addEditDate);
		}

		String addEditTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			addEditTime = request.getParameter(CHANGED_TIME);
			patient.setAddEditTime(addEditTime);
		}

		Date regDate = null;
		if (request.getParameter(REG_DATE) != null) {
			regDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(REG_DATE));
			patient.setRegDate(regDate);
			objectMap.put("regDate", regDate);
		}
		String regTime = "";
		if (request.getParameter(REG_TIME) != null) {
			regTime = request.getParameter(REG_TIME);
			patient.setRegTime(regTime);
		}

		if (request.getParameter("smokerLess10") != null
				|| request.getParameter("srsmokerLess10") != null) {
			patient.setSmokerLess10("y");
			objectMap.put("smokerLess10", "y");
		} else {
			patient.setSmokerLess10("n");
			objectMap.put("smokerLess10", "n");
		}
		if (request.getParameter("smokerMore10") != null
				|| request.getParameter("smokerMore10") != null) {
			patient.setSmokerMore10("y");
			objectMap.put("smokerMore10", "y");
		} else {
			patient.setSmokerMore10("n");
			objectMap.put("smokerMore10", "n");
		}

		if (request.getParameter("alcohol") != null
				&& !request.getParameter("alcohol").equals("")) {
			patient.setAlcohol(request.getParameter("alcohol"));
			objectMap.put("alcohol", request.getParameter("alcohol"));
		} else if (request.getParameter("sralcohol") != null
				&& !request.getParameter("sralcohol").equals("")) {
			patient.setAlcohol(request.getParameter("sralcohol"));
			objectMap.put("alcohol", request.getParameter("sralcohol"));
		}
		if (request.getParameter("otherFamilyHistory") != null
				&& !request.getParameter("otherFamilyHistory").equals("")) {
			patient.setOtherFamilyHistory(request
					.getParameter("otherFamilyHistory"));
			objectMap.put("otherFamilyHistory",
					request.getParameter("otherFamilyHistory"));
		} else if (request.getParameter("otherSrFamilyHistory") != null
				&& !request.getParameter("otherSrFamilyHistory").equals("")) {
			patient.setOtherFamilyHistory(request
					.getParameter("otherSrFamilyHistory"));
			objectMap.put("otherFamilyHistory",
					request.getParameter("otherSrFamilyHistory"));
		}

		if (request.getParameter("allergies") != null) {
			patient.setDrugAllergies(request.getParameter("allergies"));
			objectMap.put("allergies", request.getParameter("allergies"));
		}
		if (request.getParameter("srAllergies") != null) {
			patient.setDrugAllergies(request.getParameter("srAllergies"));
			objectMap.put("srallergies", request.getParameter("srAllergies"));
		}
		/**
		 * Commented By Ritu Single family history not required
		 */
		/*
		 * if(request.getParameter("familyHistory") != null &&
		 * !request.getParameter("familyHistory").equals("0")){
		 * PatientFamilyHistory familyHistory = new PatientFamilyHistory();
		 * familyHistory
		 * .setId(Integer.parseInt(request.getParameter("familyHistory")));
		 * patient.setFamilyHistory(familyHistory); }
		 */

		/**
		 * Added By Ritu for multiple family history
		 */
		String[] familyHistoryArray = null;
		if (request.getParameterValues("familyHistory") != null) {
			familyHistoryArray = request.getParameterValues("familyHistory");
			objectMap.put("familyHistoryArray", familyHistoryArray);
		} else if (request.getParameterValues("srfamilyHistory") != null) {
			familyHistoryArray = request.getParameterValues("srfamilyHistory");
			objectMap.put("familyHistoryArray", familyHistoryArray);
		}
		/**
		 * End
		 */

		if (request.getParameter("presentMedCat") != null
				&& !request.getParameter("presentMedCat").equals("0")) {
			Category category = new Category();
			category.setCategoryid(Integer.parseInt(request
					.getParameter("presentMedCat")));
			patient.setCategory(category);
			objectMap.put("category", category);
		}
		/*
		 * if(request.getParameter("medCatPeriod") != null &&
		 * !request.getParameter("medCatPeriod").equals("")){
		 * patient.setMedCatPeriod(request.getParameter("medCatPeriod"));
		 * objectMap.put("medCatPeriod", request.getParameter("medCatPeriod"));
		 * }Commented by dipali
		 */
		// ---Addd By dipali as discussed with Anshu (05-mar-2013)
		if (request.getParameter("medCatPeriod") != null
				&& !request.getParameter("medCatPeriod").equals("")) {
			if (request.getParameter("medCatDuration") != null) {
				String medCatDuration = request.getParameter("medCatDuration");
				String finalMedCat = request.getParameter("medCatPeriod")
						.concat(" ").concat(medCatDuration);
				patient.setMedCatPeriod(finalMedCat);
				objectMap.put("medCatPeriod", finalMedCat);
			}
		}// --------

		if (request.getParameter("medCatDate") != null
				&& !request.getParameter("medCatDate").equals("")) {
			patient.setMedCatDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("medCatDate")));
			objectMap.put("medCatDate", HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter("medCatDate")));
		}
		if (request.getParameter("echs") != null) {
			patient.setEchsNo(request.getParameter("echs"));
			objectMap.put("echs", request.getParameter("echs"));
		}
		patient.setHospital(masHospital);
		patient.setStatus("y");
		patient.setPatientStatus("Out Patient");
		patient.setInpatientNo(0);
		if (request.getParameter("img1") != null
				&& !request.getParameter("img1").equals("")) {
			map.put("img1", request.getParameter("img1"));
		}
		map.put("regFlag", "reg");

		String[] rptForArr = new String[1];
		if (request.getParameterValues("departmentId") != null) {
			rptForArr[0] = "OPD";
			objectMap.put("rptForArr", rptForArr);
		}

		List<Visit> visitObjList = new ArrayList<Visit>();
		if (rptForArr != null && rptForArr.length > 0) {
			for (int i = 0; i < rptForArr.length; i++) {
				Visit visit = new Visit();
				visit.setReportingFor(rptForArr[i]);
				if (request.getParameter(DEPARTMENT_ID) != null
						&& !request.getParameter(DEPARTMENT_ID).equals("0")) {
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer.parseInt(request
							.getParameter(DEPARTMENT_ID)));
					objectMap.put("departmentId", masDepartment.getId());
					visit.setDepartment(masDepartment);
				}
				String tokenAndDoctor = "";
				int tokenNo = 0;
				if (request.getParameter(TOKEN_NO) != null
						&& !(request.getParameter(TOKEN_NO).equals(""))) {
					tokenNo= Integer.parseInt(request
							.getParameter(TOKEN_NO));
					visit.setTokenNo(tokenNo);
					tokenAndDoctor = request.getParameter(TOKEN_NO);
				}
				

				int consultingDoctorId = 0;
				int consultingsessionId= 0;
				if (request.getParameter(EMPLOYEE_ID) != null
						&& !request.getParameter(EMPLOYEE_ID).equals("0") && request.getParameter(SESSION_ID) != null
								&& !request.getParameter(SESSION_ID).equals("0")) {
					consultingDoctorId = Integer.parseInt(request
							.getParameter(EMPLOYEE_ID));
					consultingsessionId = Integer.parseInt(request
							.getParameter(SESSION_ID));
					MasEmployee consultingDoctorObj = new MasEmployee();
					consultingDoctorObj.setId(consultingDoctorId);
					visit.setDoctor(consultingDoctorObj);
					MasSession consultingSessionobj = new MasSession();
					consultingSessionobj.setId(consultingsessionId);
					visit.setSession(consultingSessionobj);
					objectMap.put("consultingDoctorId", consultingDoctorId);
					objectMap.put("consultingsessionId", consultingsessionId);
					int maxTokenNo = 0;
					/*maxTokenNo = registrationHandlerService
							.getTokenNoForDepartment(consultingDoctorId, consultingsessionId);*/
					/*tokenNo = maxTokenNo + 1;*/

					tokenAndDoctor = tokenNo + "#" + consultingDoctorId;
				}
				/*else {
					tokenNo = 0;
					tokenAndDoctor = tokenNo + "#" + consultingDoctorId;
				}*/
				if (rptForArr[i].equals("OPD")
						|| rptForArr[i].equals("FollowUp")) {
					if (request.getParameter("roomNo") != null
							&& !request.getParameter("roomNo").equals("")) {
						visit.setRoomNo(Integer.parseInt(request
								.getParameter("roomNo")));
					}
				}
				visit.setTokenNo(tokenNo);
				visit.setTokenDoctor(tokenAndDoctor);

				visit.setHospital(masHospital);
				visit.setAddEditBy(user);
				/*visit.setAge(age);*/
				/*visit.setVisitDate(addEditDate);*/
				visit.setAddEditDate(regDate);
				visit.setAddEditTime(regTime);
				/*visit.setVisitTime(addEditTime);*/
				visit.setVisitDate(regDate);
				visit.setVisitTime(regTime);

				visit.setStatus("y"); // ---------commented by anamika
				// visit.setEdStatus("n");

				visit.setAppointmentType("O");
				if (rptForArr[i].equals("MedExam")) {
					if (request.getParameter("medExamCategory") != null
							&& !(request.getParameter("medExamCategory"))
									.equals("")) {
						visit.setMedExamType(request
								.getParameter("medExamCategory"));
						visit.setVisitStatus("c");
						visit.setMedStatus("w");
					}
				} else if (rptForArr[i].equals("MedBoard")) {
					if (request.getParameter("medBoardCategory") != null
							&& !(request.getParameter("medBoardCategory"))
									.equals("")) {
						visit.setMedExamType(request
								.getParameter("medBoardCategory"));
						visit.setMedStatus("w");
						visit.setVisitStatus("c");
					}
				} else if (rptForArr[i].equals("FamilyWC")) {
					if (request.getParameter("fwcCategory") != null
							&& !(request.getParameter("fwcCategory"))
									.equals("")) {
						visit.setFwcCategory(request
								.getParameter("fwcCategory"));
						visit.setVisitStatus("w");
					}
				} else {
					visit.setVisitStatus("w");
				}

				if (request.getParameter("priority") != null) {
					visit.setPriority(Integer.parseInt(request
							.getParameter("priority")));
				}
				if (rptForArr[i].equals("FollowUp")
						&& request.getParameter("followUpDepartment") != null
						&& request.getParameter("followUpDepartment").equals(
								"FamilyWC")) {
					visit.setFollowUpDepartment(request
							.getParameter("followUpDepartment"));
					visit.setFwcCategory("PNC");
				} else {
					if (request.getParameter("followUpDepartment") != null
							&& rptForArr[i].equals("FollowUp")) {
						visit.setFollowUpDepartment(request
								.getParameter("followUpDepartment"));
					}
				}
				objectMap.put("visit", visit);
				visitObjList.add(visit);
				objectMap.put("visitObjList", visitObjList);
			}
		}

		if (request.getParameter("regHinId") != null
				&& !request.getParameter("regHinId").equals("0")
				&& !request.getParameter("regHinId").equals("")) {
			objectMap.put("regHinId",
					Integer.parseInt(request.getParameter("regHinId")));
		} else if (request.getParameter("selfRegHin") != null
				&& !request.getParameter("selfRegHin").equals("")
				&& !request.getParameter("selfRegHin").equals("")) {
			objectMap.put("selfRegHin",
					Integer.parseInt(request.getParameter("selfRegHin")));
		}

		/**
		 * Code for Immunization
		 */

		/*
		 * int immCount =0; if(request.getParameter("immCount")!=null &&
		 * !(request.getParameter("immCount").equals(""))){ immCount =
		 * Integer.parseInt(request.getParameter("immCount")); } if(immCount
		 * >0){ List<Integer> immuDtIdList = new ArrayList<Integer>();
		 * List<String> immuNameList = new ArrayList<String>(); List<Integer>
		 * immunizationIdList = new ArrayList<Integer>(); List<String> dateList
		 * = new ArrayList<String>(); List<String> doseList = new
		 * ArrayList<String>(); List<String> routeList = new
		 * ArrayList<String>(); List<String> batchNoList = new
		 * ArrayList<String>(); List<String> domList = new ArrayList<String>();
		 * List<String> doeList = new ArrayList<String>();
		 * 
		 * for (int j = 1; j <= immCount; j++) {
		 * if(request.getParameter("immunId"+j)!=null &&
		 * !request.getParameter("immunId"+j).equals("")){
		 * immuDtIdList.add(Integer
		 * .parseInt(request.getParameter("immunId"+j))); }else{
		 * immuDtIdList.add(0); }
		 * if(request.getParameter("immunizationName"+j)!=null){
		 * immuNameList.add(request.getParameter("immunizationName"+j)); }
		 * if(request.getParameter("immunizationId"+j)!=null &&
		 * !request.getParameter("immunizationId"+j).equals("")){
		 * immunizationIdList
		 * .add(Integer.parseInt(request.getParameter("immunizationId"+j))); }
		 * 
		 * if(request.getParameter("vdate"+j)!=null){
		 * dateList.add(request.getParameter("vdate"+j)); }
		 * if(request.getParameter("dose"+j)!=null){
		 * doseList.add(request.getParameter("dose"+j)); }
		 * if(request.getParameter("route"+j)!=null){
		 * routeList.add(request.getParameter("route"+j)); }
		 * if(request.getParameter("batchNo"+j)!=null){
		 * batchNoList.add(request.getParameter("batchNo"+j)); }
		 * if(request.getParameter("dom"+j)!=null){
		 * domList.add(request.getParameter("dom"+j)); }
		 * if(request.getParameter("doe"+j)!=null){
		 * doeList.add(request.getParameter("doe"+j)); }
		 * 
		 * } objectMap.put("immuDtIdList", immuDtIdList);
		 * objectMap.put("immuNameList", immuNameList);
		 * objectMap.put("dateList", dateList); objectMap.put("doseList",
		 * doseList); objectMap.put("routeList", routeList);
		 * objectMap.put("batchNoList", batchNoList); objectMap.put("domList",
		 * domList); objectMap.put("doeList", doeList);
		 * objectMap.put("immunizationIdList", immunizationIdList); }
		 * objectMap.put("masHospital", masHospital);
		 */
		/**
		 * 
		 */

		/**
		 * Code for Allergies
		 */

		int allergyCount = 0;
		if (request.getParameter("allergyCount") != null
				&& !(request.getParameter("allergyCount").equals(""))) {
			allergyCount = Integer.parseInt(request
					.getParameter("allergyCount"));
		}
		// System.out.println("allergyCount  - "+allergyCount);
		if (allergyCount > 0) {
			List<Integer> allergyDetailsIdList = new ArrayList<Integer>();
			List<String> allergyNameList = new ArrayList<String>();
			List<String> descList = new ArrayList<String>();
			List<String> severityList = new ArrayList<String>();
			List<String> sinceList = new ArrayList<String>();
			List<String> remarksList = new ArrayList<String>();

			for (int j = 1; j <= allergyCount; j++) {
				if (request.getParameter("allergyDetailsId" + j) != null
						&& !request.getParameter("allergyDetailsId" + j)
								.equals("")) {
					allergyDetailsIdList.add(Integer.parseInt(request
							.getParameter("allergyDetailsId" + j)));
				} else {
					allergyDetailsIdList.add(0);
				}
				if (request.getParameter("allergyName" + j) != null
						&& !request.getParameter("allergyName" + j).equals("")) {
					allergyNameList
							.add(request.getParameter("allergyName" + j));
				}
				if (request.getParameter("description" + j) != null) {
					descList.add(request.getParameter("description" + j));
				}
				if (request.getParameter("severity" + j) != null) {
					severityList.add(request.getParameter("severity" + j));
				}
				if (request.getParameter("since" + j) != null) {
					sinceList.add(request.getParameter("since" + j));
				}
				if (request.getParameter("remarks" + j) != null) {
					remarksList.add(request.getParameter("remarks" + j));
				}

			}
			objectMap.put("allergyDetailsIdList", allergyDetailsIdList);
			objectMap.put("allergyNameList", allergyNameList);
			objectMap.put("descList", descList);
			objectMap.put("severityList", severityList);
			objectMap.put("sinceList", sinceList);
			objectMap.put("remarksList", remarksList);

		}
		if (request.getParameter("ldapData") != null) {
			objectMap.put("ldapData", request.getParameter("ldapData"));
		}
		if (request.getParameter("patientTypeName") != null) {
			objectMap.put("patientTypeName",
					request.getParameter("patientTypeName"));
		}
		/**
		 * 
		 */
		objectMap.put("hinNo", hinNo);
		objectMap.put("patient", patient);

		Box box = HMSUtil.getBox(request);
		objectMap.put("box", box);
		String userSrNo = (String) session.getAttribute("userSrNo");
		objectMap.put("userSrNo", userSrNo);

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;
		List<Patient> existingHinNoList = new ArrayList<Patient>();
		List<Visit> visitList = new ArrayList<Visit>();

		detailsMap = registrationHandlerService
				.submitPatientInformationOnlineEmployeeVisit(objectMap);
		/*
		 * if (detailsMap.get("visitList") != null) { visitList = (List<Visit>)
		 * detailsMap.get("visitList"); map.put("visitList", visitList); }
		 */

		if (detailsMap.get("existingHinNoList") != null) {
			existingHinNoList = (List<Patient>) detailsMap
					.get("existingHinNoList");
		}
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			if (request.getParameter(HIN_NO) == null
					|| request.getParameter(HIN_NO).equals("")) {
				if (request.getParameter("selfHinNo") != null
						&& !request.getParameter("selfHinNo").equals("")) {
					map.put("hinNo", request.getParameter("selfHinNo"));
				}
				if (rptForArr != null && rptForArr.length > 0) {
					message = " <font color='green'>Visit Information saved Successfully.</font>";
				} else {
					message = "<font color='green'> Patient Information Updated Successfully.</font>";
				}
				map.put("regHinId", request.getParameter("regHinId"));
				map.put("hinNo", request.getParameter("printHinNo"));

			} else {
				message = " <font color='green'>Visit Created Successfully.</font>";
				map.put("hinNo", hinNo);
			}
			map.put("serviceNo", serviceNo);

			if (request.getParameter("image") != null) {
				uploadPhoto(request);
			}
		}  else {
			String msg = (String)detailsMap.get("msg");
			if(!msg.trim().equals(""))
			{
				message  = msg;
			}
			else
			{
				message = "<font color='red'>Some problem Occured! Try Again.</font>";
			}
			
		}
	/*	String backUrl = "";
		backUrl = "/hms/hms/registration?method=showRegistrationJsp";
		map.put("backUrl", backUrl);
		StringBuffer jsp = new StringBuffer("");*/

		dataMap.put("users", user);
		/*Map<String, Object> newMap = commonMasterHandlerService
				.getUserButtonRights(dataMap);
		List<UserButtonRights> userRightsList = (List<UserButtonRights>) newMap
				.get("userRightsList");
		map.put("userRightsList", userRightsList);*/
		/*
		 * if(request.getParameter("flag").equals("registration")){
		 * jsp.append(MSG_FOR_REG);
		 * 
		 * }else if(request.getParameter("flag").equals("medicalExam")){
		 * jsp.append(MSG_FOR_REG); }
		 * 
		 * jsp.append(".jsp");
		 */
		String jsp = "msgForVisitOfOnlineEmployees.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("existingHinNoList", existingHinNoList);
		map.put("hinNo", objectMap.get("hinNo"));
		map.put("controllerFlag", "visit");
		map.put("visit_id", detailsMap.get("visit_id"));
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView cancleOnlineAppointment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();		
		HttpSession session = request.getSession();
		boolean successfullyAdded = false;
		Users user = (Users) session.getAttribute("users");		
		map.put("user", user);


		int aPAId =0;
		if(request.getParameter("aPAId")!= null && !request.getParameter("aPAId").trim().equals("")){
			aPAId = Integer.parseInt(request.getParameter("aPAId"));
			map.put("aPAId", aPAId);
		}
		map = registrationHandlerService
				.cancleOnlineAppointment(map);
		
		if (map.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			message = "Appointment Cancelled Successfully.";
		}  else {
			
				message = "Some problem Occured! Try Again.";		
			
		}
	    String jsp = "msgForVisitOfOnlineEmployees.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);	
		map.put("controllerFlag", "cancle");
		return new ModelAndView("index", "map", map);
	}

	private void uploadPhoto(HttpServletRequest request) {
		String url = "";
		String hinNo = "";
		if (request.getParameter("photoUrl") != null) {
			url = request.getParameter("photoUrl");
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}

		String str = "\\";
		String fileName = url.substring(url.lastIndexOf(str) + 1);
		String imageType = fileName.substring(fileName.lastIndexOf(".") + 1);
		String newFileName = hinNo.concat(".").concat(imageType);

		try {
			int count;
			if (!url.equals("")) {
				FileInputStream fis = new FileInputStream(url);
				File file = new File(url);
				int length = (int) file.length();

				byte data[] = new byte[length];

				File reportFile = new File(getServletContext().getRealPath(
						"/patientphoto/" + newFileName));
				if (!reportFile.exists()) {
					new File(newFileName).createNewFile();
				}

				FileOutputStream fos = new FileOutputStream(reportFile);
				while ((count = fis.read(data, 0, length)) != -1) {
					fos.write(data, 0, count);
				}
				fos.flush();
				fos.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	public ModelAndView printRegistrationCard(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String hinNo = "";
		int visit_id = 0;
		@SuppressWarnings("unused")
		// String opdPrint ="n";
		String pSlip = "n";
		// String mcs ="n";
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}

		if (request.getParameter(PRESCRIPTION_SLIP) != null) {
			pSlip = request.getParameter(PRESCRIPTION_SLIP);
		}
		if (request.getParameter(VISIT_NUMBER) != null) {
			visit_id = Integer.parseInt(request.getParameter(VISIT_NUMBER));
		}
		// if(request.getParameter(MEDICAL_CASE_SHEET) != null){
		// mcs=request.getParameter(MEDICAL_CASE_SHEET);
		// }
		// if(request.getParameter(OPD_PRINT) != null){
		// opdPrint=request.getParameter(OPD_PRINT);
		// }

		detailsMap = registrationHandlerService.getConnectionForReport();
		/**
		 * For Patient Photo
		 */
		patientMap = registrationHandlerService.getPatientList(hinNo);
		String imgfile = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientList") != null) {
			patientList = (List<Patient>) patientMap.get("patientList");
		}
		// map=
		// String uploadURL ="";
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		// String uploadURL =
		// userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"photo"+fileSeparator;
		String uploadURL = request.getSession().getServletContext()
				.getRealPath(fileSeparator + "photo" + fileSeparator);
		/*
		 * if(map.get("uploadURL")!=null){
		 * uploadURL=(String)map.get("uploadURL"); }
		 */
		String path = "";
		if (patientList != null && patientList.size() > 0) {
			Patient patient = new Patient();
			patient = (Patient) patientList.get(0);

			path = uploadURL;
			// path=uploadURL+fileSeparator+hinNo;
			if (patient.getPatientImage() != null) {

				File f = new File(path);
				try {
					if (f.exists()) {
						f.delete();
						f.mkdir();
						// File someFile = new File(hinNo + ".jpg");
						File someFile = new File(path + fileSeparator + hinNo
								+ ".jpg");
						FileOutputStream fos = new FileOutputStream(someFile);
						fos.write(patient.getPatientImage());
						fos.flush();
						fos.close();
					} else {
						f.mkdir();
						File someFile = new File(path + fileSeparator + hinNo
								+ ".jpg");
						FileOutputStream fos = new FileOutputStream(someFile);
						fos.write(patient.getPatientImage());
						fos.flush();
						fos.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				// String imgfile =
				// uploadURL+uploadDocumentsList.get(0).getFileName()+"."+uploadDocumentsList.get(0).getFileExtension()
				// ;
				imgfile = path + fileSeparator + hinNo + ".jpg";
			}/*
			 * else{ try{ File f = new File(path); if (f.exists()) { }else{
			 * f.mkdir(); File someFile = new File(path+fileSeparator+hinNo +
			 * ".jpg"); FileOutputStream fos = new FileOutputStream( someFile);
			 * fos.write(patient.getPatientImage()); fos.flush(); fos.close(); }
			 * } catch (Exception e) { e.printStackTrace(); } }
			 */
		}

		if (pSlip.equals("p")) {
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				Map<String, Object> map = new HashMap<String, Object>();
				dataMap.put("hinNo", hinNo);
				map = registrationHandlerService.getTokenNo(dataMap);
				parameters.put("hinNo", hinNo);
				parameters.put("tokenNo", "" + map.get("tokenNo"));
				parameters.put("hinNo", hinNo);
				if (visit_id != 0) {
					parameters.put("visitId", visit_id);
				}
				byte bytes1[] = null;
				try {
					bytes1 = JasperRunManager.runReportToPdf(
							getCompiledReport("prescriptionSlip"), parameters,
							(Connection) detailsMap.get("conn"));
				} catch (JRException e) {
					e.printStackTrace();
				}

				response.setContentType("application/pdf");
				response.setContentLength(bytes1.length);
				ServletOutputStream ouputStream;
				try {
					ouputStream = response.getOutputStream();
					ouputStream.write(bytes1, 0, bytes1.length);
					ouputStream.flush();
					ouputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (pSlip.equals("m")) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			dataMap.put("hinNo", hinNo);
			map = registrationHandlerService.getVisitData(dataMap);
			parameters.put("visitDate", "" + map.get("visitDate"));
			parameters.put("diagnosis", "" + map.get("visitDiagnosis"));
			parameters.put("hinNo", hinNo);

			HMSUtil.generateReport("medicalCaseSheet", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}
		if (pSlip.equals("o")) {

			File f2 = null;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			@SuppressWarnings("unused")
			Map<String, Object> map = new HashMap<String, Object>();
			dataMap.put("hinNo", hinNo);
			parameters.put("hinNo", hinNo);
			try {
				path = uploadURL;
				File f = new File(path);
				f2 = new File(path + fileSeparator + hinNo + ".jpg");
				if (f.exists()) {
					if (!f2.exists()) {
						File someFile = new File(path + fileSeparator
								+ "default.jpg");
						FileOutputStream fos = new FileOutputStream(someFile);
						// byte image[];
						fos.write(1111);
						fos.flush();
						fos.close();
					}
				} else {
					f.mkdir();
					File someFile = new File(path + fileSeparator
							+ "default.jpg");
					FileOutputStream fos = new FileOutputStream(someFile);
					// byte image[];
					fos.write(1111);
					fos.flush();
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (f2.exists()) {
				if (request.getSession().getServletContext()
						.getRealPath("/photo/" + hinNo + ".jpg") != null) {
					parameters.put("PATIENT_IMAGE",
							request.getSession().getServletContext()
									.getRealPath("/photo/" + hinNo + ".jpg"));
					HMSUtil.generateReport("RegistrationCardNew", parameters,
							(Connection) detailsMap.get("conn"), response,
							getServletContext());
				}
			} else {
				HMSUtil.generateReport("RegistrationCard", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		}
		if (pSlip.equals("c")) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			@SuppressWarnings("unused")
			Map<String, Object> map = new HashMap<String, Object>();
			dataMap.put("hinNo", hinNo);
			parameters.put("hinNo", hinNo);

			HMSUtil.generateReport("consentForm", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}

		return null;
	} 
	
	public ModelAndView printOnlineAppointmentCard(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String hinNo = "";
		int appointmentId = 0;
		@SuppressWarnings("unused")
		// String opdPrint ="n";
		String pSlip = "n";
		// String mcs ="n";
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}

		if (request.getParameter(PRESCRIPTION_SLIP) != null) {
			pSlip = request.getParameter(PRESCRIPTION_SLIP);
		}
		if (request.getParameter("appointmentId") != null) {
			appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
		}
		// if(request.getParameter(MEDICAL_CASE_SHEET) != null){
		// mcs=request.getParameter(MEDICAL_CASE_SHEET);
		// }
		// if(request.getParameter(OPD_PRINT) != null){
		// opdPrint=request.getParameter(OPD_PRINT);
		// }

		detailsMap = registrationHandlerService.getConnectionForReport();
		/**
		 * For Patient Photo
		 */
		/*patientMap = registrationHandlerService.getPatientList(hinNo);*/
		String imgfile = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientList") != null) {
			patientList = (List<Patient>) patientMap.get("patientList");
		}
		// map=
		// String uploadURL ="";
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		// String uploadURL =
		// userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"photo"+fileSeparator;
		String uploadURL = request.getSession().getServletContext()
				.getRealPath(fileSeparator + "photo" + fileSeparator);
		/*
		 * if(map.get("uploadURL")!=null){
		 * uploadURL=(String)map.get("uploadURL"); }
		 */
		String path = "";
		if (patientList != null && patientList.size() > 0) {
			Patient patient = new Patient();
			patient = (Patient) patientList.get(0);

			path = uploadURL;
			// path=uploadURL+fileSeparator+hinNo;
			if (patient.getPatientImage() != null) {

				File f = new File(path);
				try {
					if (f.exists()) {
						f.delete();
						f.mkdir();
						// File someFile = new File(hinNo + ".jpg");
						File someFile = new File(path + fileSeparator + hinNo
								+ ".jpg");
						FileOutputStream fos = new FileOutputStream(someFile);
						fos.write(patient.getPatientImage());
						fos.flush();
						fos.close();
					} else {
						f.mkdir();
						File someFile = new File(path + fileSeparator + hinNo
								+ ".jpg");
						FileOutputStream fos = new FileOutputStream(someFile);
						fos.write(patient.getPatientImage());
						fos.flush();
						fos.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				// String imgfile =
				// uploadURL+uploadDocumentsList.get(0).getFileName()+"."+uploadDocumentsList.get(0).getFileExtension()
				// ;
				imgfile = path + fileSeparator + hinNo + ".jpg";
			}/*
			 * else{ try{ File f = new File(path); if (f.exists()) { }else{
			 * f.mkdir(); File someFile = new File(path+fileSeparator+hinNo +
			 * ".jpg"); FileOutputStream fos = new FileOutputStream( someFile);
			 * fos.write(patient.getPatientImage()); fos.flush(); fos.close(); }
			 * } catch (Exception e) { e.printStackTrace(); } }
			 */
		}
/*
		if (pSlip.equals("p")) {
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				Map<String, Object> map = new HashMap<String, Object>();
				dataMap.put("hinNo", hinNo);
				map = registrationHandlerService.getTokenNo(dataMap);
				parameters.put("hinNo", hinNo);
				parameters.put("tokenNo", "" + map.get("tokenNo"));
				parameters.put("hinNo", hinNo);
				if (visit_id != 0) {
					parameters.put("visitId", visit_id);
				}
				byte bytes1[] = null;
				try {
					bytes1 = JasperRunManager.runReportToPdf(
							getCompiledReport("prescriptionSlip"), parameters,
							(Connection) detailsMap.get("conn"));
				} catch (JRException e) {
					e.printStackTrace();
				}

				response.setContentType("application/pdf");
				response.setContentLength(bytes1.length);
				ServletOutputStream ouputStream;
				try {
					ouputStream = response.getOutputStream();
					ouputStream.write(bytes1, 0, bytes1.length);
					ouputStream.flush();
					ouputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
	/*	if (pSlip.equals("m")) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			dataMap.put("hinNo", hinNo);
			map = registrationHandlerService.getVisitData(dataMap);
			parameters.put("visitDate", "" + map.get("visitDate"));
			parameters.put("diagnosis", "" + map.get("visitDiagnosis"));
			parameters.put("hinNo", hinNo);

			HMSUtil.generateReport("medicalCaseSheet", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}*/
		if (pSlip.equals("o")) {

			File f2 = null;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			@SuppressWarnings("unused")
			Map<String, Object> map = new HashMap<String, Object>();
			dataMap.put("hinNo", hinNo);
			parameters.put("appointmentId", String.valueOf(appointmentId));
			try {
				path = uploadURL;
				File f = new File(path);
				f2 = new File(path + fileSeparator + hinNo + ".jpg");
				if (f.exists()) {
					if (!f2.exists()) {
						File someFile = new File(path + fileSeparator
								+ "default.jpg");
						FileOutputStream fos = new FileOutputStream(someFile);
						// byte image[];
						fos.write(1111);
						fos.flush();
						fos.close();
					}
				} else {
					f.mkdir();
					File someFile = new File(path + fileSeparator
							+ "default.jpg");
					FileOutputStream fos = new FileOutputStream(someFile);
					// byte image[];
					fos.write(1111);
					fos.flush();
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (f2.exists()) {
				if (request.getSession().getServletContext()
						.getRealPath("/photo/" + hinNo + ".jpg") != null) {
					parameters.put("PATIENT_IMAGE",
							request.getSession().getServletContext()
									.getRealPath("/photo/" + hinNo + ".jpg"));
					HMSUtil.generateReport("RegistrationCardNew", parameters,
							(Connection) detailsMap.get("conn"), response,
							getServletContext());
				}
			} else {
				HMSUtil.generateReport("Online_Patient_Token_Card", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		}
		/*if (pSlip.equals("c")) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			@SuppressWarnings("unused")
			Map<String, Object> map = new HashMap<String, Object>();
			dataMap.put("hinNo", hinNo);
			parameters.put("hinNo", hinNo);

			HMSUtil.generateReport("consentForm", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}*/

		return null;
	}
	
	public synchronized ModelAndView printTokenCard(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String hinNo = "";
		int visit_id = 0;
		@SuppressWarnings("unused")
		// String opdPrint ="n";
		String pSlip = "n";
		// String mcs ="n";
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}

		if (request.getParameter(PRESCRIPTION_SLIP) != null) {
			pSlip = request.getParameter(PRESCRIPTION_SLIP);
		}
		if (request.getParameter("visit_id") != null) {
			visit_id = Integer.parseInt(request.getParameter("visit_id"));
		}
		// if(request.getParameter(MEDICAL_CASE_SHEET) != null){
		// mcs=request.getParameter(MEDICAL_CASE_SHEET);
		// }
		// if(request.getParameter(OPD_PRINT) != null){
		// opdPrint=request.getParameter(OPD_PRINT);
		// }

		detailsMap = registrationHandlerService.getConnectionForReport();
		/**
		 * For Patient Photo
		 */
		/*patientMap = registrationHandlerService.getPatientList(hinNo);*/
		String imgfile = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientList") != null) {
			patientList = (List<Patient>) patientMap.get("patientList");
		}
		// map=
		// String uploadURL ="";
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		// String uploadURL =
		// userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"photo"+fileSeparator;
		String uploadURL = request.getSession().getServletContext()
				.getRealPath(fileSeparator + "photo" + fileSeparator);
		/*
		 * if(map.get("uploadURL")!=null){
		 * uploadURL=(String)map.get("uploadURL"); }
		 */
		String path = "";
		if (patientList != null && patientList.size() > 0) {
			Patient patient = new Patient();
			patient = (Patient) patientList.get(0);

			path = uploadURL;
			// path=uploadURL+fileSeparator+hinNo;
			if (patient.getPatientImage() != null) {

				File f = new File(path);
				try {
					if (f.exists()) {
						f.delete();
						f.mkdir();
						// File someFile = new File(hinNo + ".jpg");
						File someFile = new File(path + fileSeparator + hinNo
								+ ".jpg");
						FileOutputStream fos = new FileOutputStream(someFile);
						fos.write(patient.getPatientImage());
						fos.flush();
						fos.close();
					} else {
						f.mkdir();
						File someFile = new File(path + fileSeparator + hinNo
								+ ".jpg");
						FileOutputStream fos = new FileOutputStream(someFile);
						fos.write(patient.getPatientImage());
						fos.flush();
						fos.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				// String imgfile =
				// uploadURL+uploadDocumentsList.get(0).getFileName()+"."+uploadDocumentsList.get(0).getFileExtension()
				// ;
				imgfile = path + fileSeparator + hinNo + ".jpg";
				System.out.println("imgfile="+imgfile);
			}/*
			 * else{ try{ File f = new File(path); if (f.exists()) { }else{
			 * f.mkdir(); File someFile = new File(path+fileSeparator+hinNo +
			 * ".jpg"); FileOutputStream fos = new FileOutputStream( someFile);
			 * fos.write(patient.getPatientImage()); fos.flush(); fos.close(); }
			 * } catch (Exception e) { e.printStackTrace(); } }
			 */
		}
/*
		if (pSlip.equals("p")) {
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				Map<String, Object> map = new HashMap<String, Object>();
				dataMap.put("hinNo", hinNo);
				map = registrationHandlerService.getTokenNo(dataMap);
				parameters.put("hinNo", hinNo);
				parameters.put("tokenNo", "" + map.get("tokenNo"));
				parameters.put("hinNo", hinNo);
				if (visit_id != 0) {
					parameters.put("visitId", visit_id);
				}
				byte bytes1[] = null;
				try {
					bytes1 = JasperRunManager.runReportToPdf(
							getCompiledReport("prescriptionSlip"), parameters,
							(Connection) detailsMap.get("conn"));
				} catch (JRException e) {
					e.printStackTrace();
				}

				response.setContentType("application/pdf");
				response.setContentLength(bytes1.length);
				ServletOutputStream ouputStream;
				try {
					ouputStream = response.getOutputStream();
					ouputStream.write(bytes1, 0, bytes1.length);
					ouputStream.flush();
					ouputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
	/*	if (pSlip.equals("m")) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			dataMap.put("hinNo", hinNo);
			map = registrationHandlerService.getVisitData(dataMap);
			parameters.put("visitDate", "" + map.get("visitDate"));
			parameters.put("diagnosis", "" + map.get("visitDiagnosis"));
			parameters.put("hinNo", hinNo);

			HMSUtil.generateReport("medicalCaseSheet", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}*/
		if (pSlip.equals("o")) {

			File f2 = null;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			@SuppressWarnings("unused")
			Map<String, Object> map = new HashMap<String, Object>();
			dataMap.put("hinNo", hinNo);
			parameters.put("visitId", String.valueOf(visit_id));
			try {
				path = uploadURL;
				File f = new File(path);
				f2 = new File(path + fileSeparator + hinNo + ".jpg");
				if (f.exists()) {
					if (!f2.exists()) {
						File someFile = new File(path + fileSeparator
								+ "default.jpg");
						FileOutputStream fos = new FileOutputStream(someFile);
						// byte image[];
						fos.write(1111);
						fos.flush();
						fos.close();
					}
				} else {
					f.mkdir();
					File someFile = new File(path + fileSeparator
							+ "default.jpg");
					FileOutputStream fos = new FileOutputStream(someFile);
					// byte image[];
					fos.write(1111);
					fos.flush();
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (f2.exists()) {
				System.out.println("1");
				if (request.getSession().getServletContext()
						.getRealPath("/photo/" + hinNo + ".jpg") != null) {
					parameters.put("PATIENT_IMAGE",
							request.getSession().getServletContext()
									.getRealPath("/photo/" + hinNo + ".jpg"));
					HMSUtil.generateReport("RegistrationCardNew", parameters,
							(Connection) detailsMap.get("conn"), response,
							getServletContext());
				
				//	detailsMap.put("Report_Path", request.getContextPath()+"/photo/"+"RegistrationCardNew"+hinNo+""+".pdf");
					//HMSUtil.generateReportForDirectPrintPatient("RegistrationCardNew", parameters, (Connection)detailsMap.get("conn"), response, getServletContext(), getServletContext().getRealPath("/photo/"),hinNo);
				}
			} else {
				System.out.println("2");
				
				detailsMap.put("Report_Path", request.getContextPath()+"/photo/"+"Patient_Token_Card"+hinNo+""+".pdf");
				HMSUtil.generateReportForDirectPrintPatient("Patient_Token_Card", parameters, (Connection)detailsMap.get("conn"), response, getServletContext(), getServletContext().getRealPath("/photo/"),hinNo);
				
			}
		}
		try{
			((Connection) detailsMap.get("conn")).close();
			}catch(Exception e){
				e.printStackTrace();
			}
		return new ModelAndView("printReports", "map", detailsMap);
	}

	/**
	 * ----------------------------------- Patient Visit
	 * ----------------------------
	 */

	public ModelAndView showPatientVisitJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = registrationHandlerService.getDetailsForVisit();
		String jsp = PATIENT_VISIT_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showVisitDetails(HttpServletRequest request,
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
		String serPersonFName = "";
		String serPersonMName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		Date appointmentDate = new Date();
		int hinId = 0;
		try {
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
					&& !(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				mapForDs.put("rankId", rankId);
			}
			if (request.getParameter(UNIT_ID) != null
					&& !(request.getParameter(UNIT_ID).equals("0"))) {
				unitId = Integer.parseInt(request.getParameter(UNIT_ID));
				mapForDs.put("unitId", unitId);
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
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter("appointment") != null) {
				appointmentDate = HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(APPOINTMENT_DATE));
				mapForDs.put("appointmentDate", appointmentDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = registrationHandlerService.getPatientDetails(mapForDs);
		int maxTokenNo = 0;
		int tokenNo = 0;
		int deptId = 0;

		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		/*maxTokenNo = registrationHandlerService.getTokenNoForDepartment(deptId);*/
		tokenNo = maxTokenNo + 1;
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		patientList = (List<Patient>) patientMap.get("patientList");
		if ((!hinNo.equals("") && patientList.size() > 0) || hinId != 0) {
			detailsMap = registrationHandlerService.getVisitDetails();
			jsp = VISIT_BY_HIN_JSP + ".jsp";
		} else {
			map = registrationHandlerService.getDetailsForVisit();
			jsp = PATIENT_VISIT_SEARCH_JSP + ".jsp";
		}

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		map.put("tokenNo", tokenNo);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView saveVisitInformation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Visit visit = new Visit();
		Patient patient = new Patient();

		int hinId = 0;
		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			patient.setId(hinId);
			visit.setHin(patient);
		}
		String hinNo = "";
		if (request.getParameter("hinNo") != null) {
			hinNo = (request.getParameter("hinNo"));

		}
		if (!(request.getParameter(PATIENT_DEPARTMENT).equals("0"))) {
			int departmentId = Integer.parseInt(request
					.getParameter(PATIENT_DEPARTMENT));
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			visit.setDepartment(masDepartment);
		}
		if (!(request.getParameter(CONSULTING_DOCTOR).equals("0"))) {
			int consultingDoctorId = Integer.parseInt(request
					.getParameter(CONSULTING_DOCTOR));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(consultingDoctorId);
			visit.setDoctor(masEmployee);
		}
		if (request.getParameter(COMPLAINT_ID) != null
				&& !(request.getParameter(COMPLAINT_ID).equals(""))) {
			int complaint = Integer.parseInt(request.getParameter(COMPLAINT_ID));			 
			MasComplaint masComplaint = new MasComplaint();
			masComplaint.setId(complaint);
			visit.setComplaint(masComplaint);
		}
		/*
		 * if(!(request.getParameter(COMPLAINT_ID).equals("0"))){ int
		 * complaintId = Integer.parseInt(request.getParameter(COMPLAINT_ID));
		 * MasComplaint masComplaint = new MasComplaint();
		 * masComplaint.setId(complaintId); visit.setComplaint(masComplaint); }
		 */
		if (!(request.getParameter(CASE_TYPE_ID).equals("0"))) {
			int caseTypeId = Integer.parseInt(request
					.getParameter(CASE_TYPE_ID));
			MasCaseType masCaseType = new MasCaseType();
			masCaseType.setId(caseTypeId);
			visit.setCaseType(masCaseType);
		}

		if (request.getParameter(DIAGNOSIS_ID) != null
				&& !(request.getParameter(DIAGNOSIS_ID).equals(""))) {
			int diagnosis = Integer.parseInt(request.getParameter(DIAGNOSIS_ID));
			MasDiagnosisConclusion diagnosiObj = new MasDiagnosisConclusion();
			diagnosiObj.setId(diagnosis);
			visit.setDiagnosis(diagnosiObj);
		}

		/*
		 * if(!(request.getParameter(DIAGNOSIS_ID).equals("0"))){ int
		 * diagnosisId = Integer.parseInt(request.getParameter(DIAGNOSIS_ID));
		 * MasDiagnosisConclusion masDiagnosisConclusion = new
		 * MasDiagnosisConclusion(); masDiagnosisConclusion.setId(diagnosisId);
		 * visit.setDiagnosis(masDiagnosisConclusion); }
		 */if (request.getParameter(DISPOSAL_ID) != null
				&& !(request.getParameter(DISPOSAL_ID).equals("0"))) {
			int disposalId = Integer
					.parseInt(request.getParameter(DISPOSAL_ID));
			MasDisposal masDisposal = new MasDisposal();
			masDisposal.setId(disposalId);
			visit.setDisposal(masDisposal);
		}
		if (request.getParameter(VISIT_DATE) != null) {
			visit.setVisitDate(HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(VISIT_DATE)));
		}
		if (request.getParameter(VISIT_TIME) != null) {
			visit.setVisitTime(request.getParameter(VISIT_TIME));
		}
		if (request.getParameter(TOKEN_NO) != null) {
			visit.setTokenNo(Integer.parseInt(request.getParameter(TOKEN_NO)));
		}
		if (request.getParameter(HOSPITAL_STAFF) != null) {
			visit.setHospitalStaff("y");
		} else {
			visit.setHospitalStaff("n");
		}
		if (request.getParameter(WEIGHT) != null
				&& !(request.getParameter(WEIGHT).equals(""))) {
			visit.setWeight(Integer.parseInt(request.getParameter(WEIGHT)));
		}
		visit.setVisitNo(Integer.parseInt(request.getParameter(VISIT_NUMBER)));
		visit.setAge(request.getParameter(AGE));

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		visit.setAddEditBy(userObj);

		if (request.getParameter(CHANGED_DATE) != null) {
			Date addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			visit.setAddEditDate(addEditDate);
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			String addEditTime = request.getParameter(CHANGED_TIME);
			visit.setAddEditTime(addEditTime);
		}
		visit.setStatus("y");
		// ----------commented by anamika======
		// visit.setEdStatus("n");
		// visit.setVisitStatus("w");
		visit.setAppointmentType("D");
		int currenVisitNo = Integer
				.parseInt(request.getParameter(VISIT_NUMBER));

		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("visit", visit);
		mapForDs.put("currenVisitNo", currenVisitNo);
		mapForDs.put("hinId", hinId);

		boolean successfullyAdded = false;
		// successfullyAdded =
		// registrationHandlerService.saveVisitInformation(mapForDs);
		map = registrationHandlerService.saveVisitInformation(mapForDs);

		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		String message = "";

		if (successfullyAdded) {
			message = " Visit information saved Successfully.";

		} else {
			message = "Some problem Occured! Try Again.";
		}
		mapForDs.put("users", user);
		Map<String, Object> newMap = commonMasterHandlerService
				.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList = (List<UserButtonRights>) newMap
				.get("userRightsList");

		map.put("userRightsList", userRightsList);
		String backUrl = "";
		boolean flagForVisitSearch = true;
		backUrl = "/hms/hms/registration?method=showPatientVisitJsp";
		map.put("backUrl", backUrl);
		map.put("flagForVisitSearch", flagForVisitSearch);
		String jsp = MSG_FOR_REG;
		jsp += ".jsp";
		map.put("hinNo", hinNo);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * ----------------------------------- Update Patient
	 * Registration----------------------------
	 */

	public ModelAndView showUpdateSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		if (request.getParameter("jsp").equals("registration")) {
			jsp = SEARCH_REGISTRATION_JSP;
		} else if (request.getParameter("jsp").equals("visit")) {
			jsp = SEARCH_VISIT_JSP;
		}
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUpdateRegistrationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> patientDetailsMap = new HashMap<String, Object>();

		String hinNo = "";
		String patientName = "";

		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			parameterMap.put("hinNo", hinNo);
		} else if (request.getParameter(PATIENT_NAME) != null) {
			patientName = request.getParameter(PATIENT_NAME);
			parameterMap.put("patientName", patientName);
		}
		/*
		 * String uploadURL = getServletContext().getRealPath("/photo/"); File
		 * urlName = new File(getServletContext().getRealPath("/photo/"));
		 * String getPathName = urlName.getPath();
		 */
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome.substring(0,
				userHome.lastIndexOf(fileSeparator))
				+ fileSeparator
				+ "HMSDocumentFolder"
				+ fileSeparator
				+ "photo"
				+ fileSeparator + hinNo + ".jpg";
		String destUploadUrl = getServletContext().getRealPath(
				fileSeparator + "photo")
				+ fileSeparator + hinNo + ".jpg";
		try {
			File fileUploadURL = new File(uploadURL);
			if (fileUploadURL.exists()) {
				HMSUtil.copyfile(new File(uploadURL), new File(destUploadUrl));
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		parameterMap.put("uploadURL", uploadURL);
		try {
			patientDetailsMap = registrationHandlerService
					.getPatientDetailsForUpdate(parameterMap);
			map = registrationHandlerService.getUpdateRegistrationDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * try { patientDetailsMap = registrationHandlerService
		 * .getPatientDetailsForUpdate(parameterMap); map =
		 * registrationHandlerService.getUpdateRegistrationDetails(); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
		/*
		 * try { File folder = new File(getServletContext().getRealPath(
		 * "/patientPhoto/")); File[] listOfFiles = folder.listFiles(); String
		 * fullFileName = ""; String fileName = ""; String fileExtn = ""; String
		 * fileUrl = "";
		 * 
		 * for (int i = 0; i < listOfFiles.length; i++) { if
		 * (listOfFiles[i].isFile()) { fullFileName = listOfFiles[i].getName();
		 * StringTokenizer str = new StringTokenizer(fullFileName, "."); while
		 * (str.hasMoreTokens()) { fileName = str.nextToken(); fileExtn =
		 * str.nextToken(); } if (fileName.equals(hinNo)) { String realPath =
		 * ""; realPath = getServletContext().getRealPath( "/patientPhoto/");
		 * fileUrl = realPath.concat("\\").concat(fileName)
		 * .concat(".").concat(fileExtn); map.put("fileUrl", fileUrl); } } } }
		 * catch (Exception e) { e.printStackTrace(); }
		 */
		StringBuffer jsp = new StringBuffer(UPDATE_REGISTRATION_JSP);
		jsp.append(".jsp");
		map.put("contentJsp", jsp);
		map.put("patientDetailsMap", patientDetailsMap);
		map.put("uploadURL", uploadURL);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView updatePatientInformation(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); HttpSession session = request.getSession();
	 * 
	 * int hinId = 0; Map<String, Object> valuesMap = new HashMap<String,
	 * Object>();
	 * 
	 * if (request.getParameter(HIN_ID) != null) { hinId =
	 * Integer.parseInt(request.getParameter(HIN_ID)); valuesMap.put("hinId",
	 * hinId); } if (request.getParameter(TITLE) != null &&
	 * !request.getParameter(TITLE).equals("0")) { int titleId =
	 * Integer.parseInt(request.getParameter(TITLE)); valuesMap.put("titleId",
	 * titleId); }
	 * 
	 * if (request.getParameter(RANK_ID) != null &&
	 * !request.getParameter(RANK_ID).equals("0")) { int rankId =
	 * Integer.parseInt(request.getParameter(RANK_ID)); valuesMap.put("rankId",
	 * rankId); }
	 * 
	 * if (request.getParameter(TRADE_ID) != null &&
	 * !request.getParameter(TRADE_ID).equals("0")) { int tradeId =
	 * Integer.parseInt(request.getParameter(TRADE_ID));
	 * valuesMap.put("tradeId", tradeId); }
	 * 
	 * if (request.getParameter(UNIT_ID) != null) { if
	 * (!request.getParameter(UNIT_ID).equals("0")) { if
	 * (!request.getParameter(UNIT_ID).equals("Other")) { int unitId = Integer
	 * .parseInt(request.getParameter(UNIT_ID)); MasUnit masUnit = new
	 * MasUnit(); masUnit.setId(unitId); valuesMap.put("unitId", unitId); } else
	 * if (request.getParameter(UNIT_ID).equals("Other")) { MasUnit masUnitObj =
	 * new MasUnit(); if (request.getParameter(UNIT_NAME) != null) {
	 * 
	 * StringBuffer output_str1 = new StringBuffer(); StringTokenizer s1 = new
	 * StringTokenizer(request .getParameter(UNIT_NAME) + "", "\'");
	 * 
	 * while (s1.hasMoreTokens()) { output_str1.append(s1.nextToken()); if
	 * (s1.hasMoreTokens()) { output_str1.append(" "); } }
	 * 
	 * StringBuffer output_str2 = new StringBuffer(); StringTokenizer s2 = new
	 * StringTokenizer(output_str1 + "", "\"");
	 * 
	 * while (s2.hasMoreTokens()) { output_str2.append(s2.nextToken()); if
	 * (s2.hasMoreTokens()) { output_str2.append(" "); } }
	 * 
	 * masUnitObj.setUnitName("" + output_str2); } if
	 * (request.getParameter(UNIT_ADDRESS) != null) {
	 * 
	 * StringBuffer output_str3 = new StringBuffer(); StringTokenizer s3 = new
	 * StringTokenizer(request .getParameter(UNIT_ADDRESS) + "", "\'");
	 * 
	 * while (s3.hasMoreTokens()) { output_str3.append(s3.nextToken()); if
	 * (s3.hasMoreTokens()) { output_str3.append(" "); } }
	 * 
	 * StringBuffer output_str4 = new StringBuffer(); StringTokenizer s4 = new
	 * StringTokenizer(output_str3 + "", "\"");
	 * 
	 * while (s4.hasMoreTokens()) { output_str4.append(s4.nextToken()); if
	 * (s4.hasMoreTokens()) { output_str4.append(" "); } }
	 * masUnitObj.setUnitAddress("" + output_str4); } if
	 * (request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))) {
	 * masUnitObj.setLastChgBy(request .getParameter(CHANGED_BY)); } if
	 * (request.getParameter(LOCAL_UNIT) != null) {
	 * masUnitObj.setLocalUnit("y"); } else { masUnitObj.setLocalUnit("n"); }
	 * Date changedDate = HMSUtil .convertStringTypeDateToDateType(request
	 * .getParameter(CHANGED_DATE)); masUnitObj.setLastChgDate(changedDate);
	 * masUnitObj.setLastChgTime(request .getParameter(CHANGED_TIME));
	 * masUnitObj.setStatus("t"); valuesMap.put("masUnitObj", masUnitObj); } } }
	 * 
	 * if (request.getParameter(S_FIRST_NAME) != null) { String sFirstName =
	 * request.getParameter(S_FIRST_NAME); valuesMap.put("sFirstName",
	 * sFirstName); } if (request.getParameter(S_MIDDLE_NAME) != null) { String
	 * sMiddleName = request.getParameter(S_MIDDLE_NAME);
	 * valuesMap.put("sMiddleName", sMiddleName); }
	 * 
	 * if (request.getParameter(S_LAST_NAME) != null) { String sLastName =
	 * request.getParameter(S_LAST_NAME); valuesMap.put("sLastName", sLastName);
	 * }
	 * 
	 * String pFirstName = request.getParameter(P_FIRST_NAME);
	 * valuesMap.put("pFirstName", pFirstName);
	 * 
	 * if (request.getParameter(P_MIDDLE_NAME) != null) { String pMiddleName =
	 * request.getParameter(P_MIDDLE_NAME); valuesMap.put("pMiddleName",
	 * pMiddleName); } if (request.getParameter(P_LAST_NAME) != null) { String
	 * pLastName = request.getParameter(P_LAST_NAME); valuesMap.put("pLastName",
	 * pLastName); } if (request.getParameter(GENDER) != null &&
	 * !request.getParameter(GENDER).equals("0")) { int genderId =
	 * Integer.parseInt(request.getParameter(GENDER)); valuesMap.put("genderId",
	 * genderId); }
	 * 
	 * if (request.getParameter(DATE_OF_BIRTH) != null &&
	 * !(request.getParameter(DATE_OF_BIRTH).equals(""))) { Date dateOfBirth =
	 * HMSUtil.dateFormatterDDMMYYYY(request .getParameter(DATE_OF_BIRTH));
	 * valuesMap.put("dateOfBirth", dateOfBirth); } if
	 * (request.getParameter("ageLabel") != null &&
	 * !(request.getParameter("ageLabel").equals(""))) { String age =
	 * request.getParameter("ageLabel"); valuesMap.put("age", age); }
	 * 
	 * if (request.getParameter(RELIGION) != null &&
	 * !request.getParameter(RELIGION).equals("0")) { int religionId =
	 * Integer.parseInt(request.getParameter(RELIGION));
	 * valuesMap.put("religionId", religionId); } if
	 * (request.getParameter(MARITAL_STATUS_ID) != null &&
	 * !request.getParameter(MARITAL_STATUS_ID).equals("0")) { int
	 * maritalStatusId = Integer.parseInt(request
	 * .getParameter(MARITAL_STATUS_ID)); valuesMap.put("maritalStatusId",
	 * maritalStatusId); } if (request.getParameter(OCCUPATION_ID) != null &&
	 * !request.getParameter(OCCUPATION_ID).equals("0")) { int occupationId =
	 * Integer.parseInt(request .getParameter(OCCUPATION_ID));
	 * valuesMap.put("occupationId", occupationId); } if
	 * (request.getParameter(BLOOD_GROUP_ID) != null &&
	 * !request.getParameter(BLOOD_GROUP_ID).equals("0")) { int bloodGroupId =
	 * Integer.parseInt(request .getParameter(BLOOD_GROUP_ID));
	 * valuesMap.put("bloodGroupId", bloodGroupId); }
	 * 
	 * if (request.getParameter(DISTRICT) != null &&
	 * !request.getParameter(DISTRICT).equals("0")) { int districtId =
	 * Integer.parseInt(request.getParameter(DISTRICT));
	 * valuesMap.put("districtId", districtId); } if
	 * (request.getParameter(ADDRESS) != null) { String address =
	 * request.getParameter(ADDRESS); valuesMap.put("address", address); } if
	 * (request.getParameter(PATIENT_DISTRICT) != null) { String patientDistrict
	 * = request.getParameter(PATIENT_DISTRICT);
	 * valuesMap.put("patientDistrict", patientDistrict); }
	 * 
	 * if (request.getParameter(BLOCK) != null &&
	 * !request.getParameter(BLOCK).equals("0")) { int blockId =
	 * Integer.parseInt(request.getParameter(BLOCK)); valuesMap.put("blockId",
	 * blockId); } if (request.getParameter(PINCODE) != null) { String pinCode =
	 * request.getParameter(PINCODE); valuesMap.put("pinCode", pinCode); }
	 * 
	 * if (request.getParameter(POST_OFFICE) != null) { String postOffice =
	 * request.getParameter(POST_OFFICE); valuesMap.put("postOffice",
	 * postOffice); }
	 * 
	 * int countryId = Integer.parseInt(request.getParameter(NATIONALITY));
	 * valuesMap.put("countryId", countryId);
	 * 
	 * int stateId = Integer.parseInt(request.getParameter(STATE));
	 * valuesMap.put("stateId", stateId);
	 * 
	 * if (request.getParameter(PHONE) != null) { String phoneNumber =
	 * request.getParameter(PHONE); valuesMap.put("phoneNumber", phoneNumber); }
	 * if (request.getParameter(MOBILE) != null) { String mobileNo =
	 * request.getParameter(MOBILE); valuesMap.put("mobileNo", mobileNo); } if
	 * (request.getParameter(EMAIL_ID) != null) { String email =
	 * request.getParameter(EMAIL_ID); valuesMap.put("email", email); } if
	 * (request.getParameter(DIAGNOSIS_ID) != null &&
	 * !request.getParameter(DIAGNOSIS_ID).equals("")) { String diagnosis =
	 * (String) request.getParameter(DIAGNOSIS_ID); valuesMap.put("diagnosisId",
	 * diagnosis); }
	 * 
	 * if (request.getParameter(DISPOSAL_ID) != null &&
	 * !request.getParameter(DISPOSAL_ID).equals("0")) { int disposalId =
	 * Integer .parseInt(request.getParameter(DISPOSAL_ID));
	 * valuesMap.put("disposalId", disposalId); }
	 * 
	 * if (request.getParameter(RELATIVE_NAME) != null) { String relativeName =
	 * request.getParameter(RELATIVE_NAME); valuesMap.put("relativeName",
	 * relativeName); } if (request.getParameter(RELATION_ID) != null &&
	 * !request.getParameter(RELATION_ID).equals("0")) { int relationId =
	 * Integer .parseInt(request.getParameter(RELATION_ID));
	 * valuesMap.put("nokRelationId", relationId); } if
	 * (request.getParameter(EMERGENCY_ADDRESS) != null) { String nokAddress =
	 * request.getParameter(EMERGENCY_ADDRESS); valuesMap.put("nokAddress",
	 * nokAddress); }
	 * 
	 * if (request.getParameter(EMERGENCY_PHONE) != null) { String nokPhone =
	 * request.getParameter(EMERGENCY_PHONE); valuesMap.put("nokPhone",
	 * nokPhone); }
	 * 
	 * if (request.getParameter(RECORD_OFFICE_ADDRESS_ID) != null &&
	 * !request.getParameter(RECORD_OFFICE_ADDRESS_ID).equals("0")) { int
	 * recordOfficeAddId = Integer.parseInt(request
	 * .getParameter(RECORD_OFFICE_ADDRESS_ID));
	 * valuesMap.put("recordOfficeAddId", recordOfficeAddId); }
	 * 
	 * if (request.getParameter(FORMATION_ID) != null) { String formation =
	 * request.getParameter(FORMATION_ID); valuesMap.put("formation",
	 * formation); }
	 * 
	 * if (request.getParameter(TOTAL_SERVICE) != null &&
	 * !request.getParameter(TOTAL_SERVICE).equals("")) { String totalService =
	 * request.getParameter(TOTAL_SERVICE); valuesMap.put("totalService",
	 * totalService); } if (request.getParameter(STATION) != null) { String
	 * station = request.getParameter(STATION); valuesMap.put("station",
	 * station); }
	 * 
	 * if (request.getParameter(CDA_ACCOUNT_NO) != null) { String cdAccNo =
	 * request.getParameter(CDA_ACCOUNT_NO); valuesMap.put("cdAccNo", cdAccNo);
	 * } if (request.getParameter(REFERENCE) != null &&
	 * !request.getParameter(REFERENCE).equals("0")) { int referenceId =
	 * Integer.parseInt(request.getParameter(REFERENCE));
	 * valuesMap.put("referenceId", referenceId); } if
	 * (request.getParameter(REMARKS) != null) { String remarks =
	 * request.getParameter(REMARKS); valuesMap.put("remarks", remarks); }
	 * 
	 * if (request.getParameter(CHANGED_DATE) != null) { Date addEditDate =
	 * HMSUtil.convertStringTypeDateToDateType(request
	 * .getParameter(CHANGED_DATE)); valuesMap.put("addEditDate", addEditDate);
	 * } if (request.getParameter(CHANGED_TIME) != null) { String addEditTime =
	 * request.getParameter(CHANGED_TIME); valuesMap.put("addEditTime",
	 * addEditTime); }
	 * 
	 * if (request.getParameter(POLICE_STATION) != null) { String policeStation
	 * = request.getParameter(POLICE_STATION); valuesMap.put("policeStation",
	 * policeStation); } if (request.getParameter(I_CARD_VALIDITY_DATE) != null
	 * && !(request.getParameter(I_CARD_VALIDITY_DATE).equals(""))) { Date
	 * cardDate = HMSUtil.convertStringTypeDateToDateType(request
	 * .getParameter(I_CARD_VALIDITY_DATE)); valuesMap.put("ICardDate",
	 * cardDate); } if (request.getParameter(DEPENDENT_CARD_ISSUE_DATE) != null
	 * && !(request.getParameter(DEPENDENT_CARD_ISSUE_DATE).equals(""))) { Date
	 * dCardDate = HMSUtil.convertStringTypeDateToDateType(request
	 * .getParameter(DEPENDENT_CARD_ISSUE_DATE)); valuesMap.put("DCardDate",
	 * dCardDate);
	 * 
	 * } if (request.getParameter(I_CARD_VERIFIED) != null) { String iCardVar =
	 * request.getParameter(I_CARD_VERIFIED); valuesMap.put("ICardVer",
	 * iCardVar); } else { valuesMap.put("ICardVer", "n"); }
	 * 
	 * Users user = (Users) session.getAttribute("users"); int userId =
	 * user.getId(); valuesMap.put("userId", userId);
	 * 
	 * boolean successfullyUpdated = false; String message = "";
	 * successfullyUpdated = registrationHandlerService
	 * .updateRegistrationInformation(valuesMap); if (successfullyUpdated) {
	 * message = " Registration Information Updated Successfully.";
	 * 
	 * } else { message = "Some problem Occured! Try Again."; } String jsp =
	 * MESSAGE_FOR_ADT_JSP; jsp += ".jsp"; map.put("contentJsp", jsp);
	 * map.put("message", message); return new ModelAndView("index", "map",
	 * map); }
	 */
	// -----------------------commented by Vishal---new code come from Noida and
	// place it below
	public ModelAndView updatePatientInformation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int hinId = 0;
		int serTypeId = 0;

		Map<String, Object> valuesMap = new HashMap<String, Object>();

		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			valuesMap.put("hinId", hinId);
		}
		if (request.getParameter(TITLE) != null
				&& !request.getParameter(TITLE).equals("0")) {
			int titleId = Integer.parseInt(request.getParameter(TITLE));
			valuesMap.put("titleId", titleId);
		}

		if (request.getParameter(RANK_ID) != null
				&& !request.getParameter(RANK_ID).equals("0")) {
			int rankId = Integer.parseInt(request.getParameter(RANK_ID));
			valuesMap.put("rankId", rankId);
		}
		Float totalService = null;
		String servicePeriod = "";
		if (request.getParameter(TOTAL_SERVICE) != null
				&& !request.getParameter(TOTAL_SERVICE).equals("")) {
			totalService = Float
					.parseFloat(request.getParameter(TOTAL_SERVICE));
			valuesMap.put("totalService", totalService);
		}
		if (request.getParameter(TOTAL_SERVICE_PERIOD) != null
				&& !request.getParameter(TOTAL_SERVICE_PERIOD).equals("")) {
			servicePeriod = request.getParameter(TOTAL_SERVICE_PERIOD);
			valuesMap.put("servicePeriod", servicePeriod);
		}
		// =========================Code by
		// Pankaj=============================================
		/*
		 * if (request.getParameter(TRADE_ID) != null &&
		 * !request.getParameter(TRADE_ID).equals("0")) { int tradeId =
		 * Integer.parseInt(request.getParameter(TRADE_ID));
		 * valuesMap.put("tradeId", tradeId); }
		 * 
		 * if (request.getParameter(TRADE_ID) != null
		 * &&!request.getParameter(TRADE_ID).equals("0")) {
		 * 
		 * Patient patient = new Patient(); int tradeId =
		 * Integer.parseInt(request.getParameter(TRADE_ID));
		 * valuesMap.put("tradeId", tradeId); MasTrade mtrade = new MasTrade();
		 * 
		 * if (tradeId == 31) { if (request.getParameter(TRADE_NAME) != null &&
		 * !request.getParameter(TRADE_ID).equals("0")) {
		 * 
		 * MasServiceType masServiceType = new MasServiceType(); serTypeId =
		 * Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
		 * masServiceType
		 * .setId(Integer.parseInt(request.getParameter(SERVICE_TYPE_ID)));
		 * patient.setServiceType(masServiceType);
		 * patient.setTradeName(request.getParameter(TRADE_NAME)); String
		 * tradeName = request.getParameter(TRADE_NAME);
		 * mtrade.setTradeName(tradeName);
		 * mtrade.setServiceType(masServiceType); mtrade.setStatus("n");
		 * mtrade.setLastChgBy("admin");
		 * registrationHandlerService.addTrade(mtrade, tradeName);
		 * 
		 * } } }
		 */

		// ==========================End Here
		// =================================================

		if (request.getParameter(UNIT_ID) != null) {
			if (!request.getParameter(UNIT_ID).equals("0")) {
				if (!request.getParameter(UNIT_ID).equals("Other")) {
					int unitId = Integer
							.parseInt(request.getParameter(UNIT_ID));
					MasUnit masUnit = new MasUnit();
					masUnit.setId(unitId);
					valuesMap.put("unitId", unitId);
				} else if (request.getParameter(UNIT_ID).equals("Other")) {
					MasUnit masUnitObj = new MasUnit();
					if (request.getParameter(UNIT_NAME) != null) {

						StringBuffer output_str1 = new StringBuffer();
						StringTokenizer s1 = new StringTokenizer(
								request.getParameter(UNIT_NAME) + "", "\'");

						while (s1.hasMoreTokens()) {
							output_str1.append(s1.nextToken());
							if (s1.hasMoreTokens()) {
								output_str1.append(" ");
							}
						}

						StringBuffer output_str2 = new StringBuffer();
						StringTokenizer s2 = new StringTokenizer(output_str1
								+ "", "\"");

						while (s2.hasMoreTokens()) {
							output_str2.append(s2.nextToken());
							if (s2.hasMoreTokens()) {
								output_str2.append(" ");
							}
						}

						masUnitObj.setUnitName("" + output_str2);
					}
					if (request.getParameter(UNIT_ADDRESS) != null) {

						StringBuffer output_str3 = new StringBuffer();
						StringTokenizer s3 = new StringTokenizer(
								request.getParameter(UNIT_ADDRESS) + "", "\'");

						while (s3.hasMoreTokens()) {
							output_str3.append(s3.nextToken());
							if (s3.hasMoreTokens()) {
								output_str3.append(" ");
							}
						}

						StringBuffer output_str4 = new StringBuffer();
						StringTokenizer s4 = new StringTokenizer(output_str3
								+ "", "\"");

						while (s4.hasMoreTokens()) {
							output_str4.append(s4.nextToken());
							if (s4.hasMoreTokens()) {
								output_str4.append(" ");
							}
						}
						masUnitObj.setUnitAddress("" + output_str4);
					}
					if (request.getParameter(CHANGED_BY) != null
							&& !(request.getParameter(CHANGED_BY).equals(""))) {
						masUnitObj.setLastChgBy(request
								.getParameter(CHANGED_BY));
					}
					if (request.getParameter(LOCAL_UNIT) != null) {
						masUnitObj.setLocalUnit("y");
					} else {
						masUnitObj.setLocalUnit("n");
					}
					Date changedDate = HMSUtil
							.convertStringTypeDateToDateType(request
									.getParameter(CHANGED_DATE));
					masUnitObj.setLastChgDate(changedDate);
					masUnitObj.setLastChgTime(request
							.getParameter(CHANGED_TIME));
					masUnitObj.setStatus("t");
					valuesMap.put("masUnitObj", masUnitObj);
				}
			}
		}
		if (!request.getParameter(TRADE_ID).equals("0")) {
			if (!request.getParameter(TRADE_ID).equals("31")) {
				int tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
				MasTrade masTrade = new MasTrade();
				masTrade.setId(tradeId);
				valuesMap.put("tradeId", tradeId);
			} else if (request.getParameter(TRADE_ID).equals("31")) {
				MasTrade masTradeObj = new MasTrade();
				if (request.getParameter(TRADE_NAME) != null) {

					StringBuffer output_str1 = new StringBuffer();
					StringTokenizer s1 = new StringTokenizer(
							request.getParameter(TRADE_NAME) + "", "\'");

					while (s1.hasMoreTokens()) {
						output_str1.append(s1.nextToken());
						if (s1.hasMoreTokens()) {
							output_str1.append(" ");
						}
					}

					StringBuffer output_str2 = new StringBuffer();
					StringTokenizer s2 = new StringTokenizer(output_str1 + "",
							"\"");

					while (s2.hasMoreTokens()) {
						output_str2.append(s2.nextToken());
						if (s2.hasMoreTokens()) {
							output_str2.append(" ");
						}
					}

					masTradeObj.setTradeName("" + output_str2);
				}

				if (request.getParameter(CHANGED_BY) != null
						&& !(request.getParameter(CHANGED_BY).equals(""))) {
					masTradeObj.setLastChgBy(request.getParameter(CHANGED_BY));
				}
				/*
				 * if (request.getParameter(LOCAL_TRADE) != null) { masTradeObj
				 * .setLocalUnit("y"); } else { masTradeObj .setLocalUnit("n");
				 * }
				 */
				Date changedDate = HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(CHANGED_DATE));
				masTradeObj.setLastChgDate(changedDate);
				masTradeObj.setLastChgTime(request.getParameter(CHANGED_TIME));
				masTradeObj.setStatus("n");
				valuesMap.put("masTradeObj", masTradeObj);
			}
		}
		if (request.getParameter(S_FIRST_NAME) != null) {
			String sFirstName = request.getParameter(S_FIRST_NAME);
			valuesMap.put("sFirstName", sFirstName);
		}
		if (request.getParameter(S_MIDDLE_NAME) != null) {
			String sMiddleName = request.getParameter(S_MIDDLE_NAME);
			valuesMap.put("sMiddleName", sMiddleName);
		}

		if (request.getParameter(S_LAST_NAME) != null) {
			String sLastName = request.getParameter(S_LAST_NAME);
			valuesMap.put("sLastName", sLastName);
		}

		String pFirstName = request.getParameter(P_FIRST_NAME);
		valuesMap.put("pFirstName", pFirstName);

		if (request.getParameter(P_MIDDLE_NAME) != null) {
			String pMiddleName = request.getParameter(P_MIDDLE_NAME);
			valuesMap.put("pMiddleName", pMiddleName);
		}
		if (request.getParameter(P_LAST_NAME) != null) {
			String pLastName = request.getParameter(P_LAST_NAME);
			valuesMap.put("pLastName", pLastName);
		}
		if (request.getParameter(GENDER) != null
				&& !request.getParameter(GENDER).equals("0")) {
			int genderId = Integer.parseInt(request.getParameter(GENDER));
			valuesMap.put("genderId", genderId);
		}

		if (request.getParameter(DATE_OF_BIRTH) != null
				&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
			Date dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_BIRTH));
			valuesMap.put("dateOfBirth", dateOfBirth);
		}
		if (request.getParameter("ageLabel") != null
				&& !(request.getParameter("ageLabel").equals(""))) {
			String age = request.getParameter("ageLabel");
			valuesMap.put("age", age);
		}

		if (request.getParameter(RELIGION) != null
				&& !request.getParameter(RELIGION).equals("0")) {
			int religionId = Integer.parseInt(request.getParameter(RELIGION));
			valuesMap.put("religionId", religionId);
		}
		if (request.getParameter(MARITAL_STATUS_ID) != null
				&& !request.getParameter(MARITAL_STATUS_ID).equals("0")) {
			int maritalStatusId = Integer.parseInt(request
					.getParameter(MARITAL_STATUS_ID));
			valuesMap.put("maritalStatusId", maritalStatusId);
		}
		if (request.getParameter(OCCUPATION_ID) != null
				&& !request.getParameter(OCCUPATION_ID).equals("0")) {
			int occupationId = Integer.parseInt(request
					.getParameter(OCCUPATION_ID));
			valuesMap.put("occupationId", occupationId);
		}
		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !request.getParameter(BLOOD_GROUP_ID).equals("0")) {
			int bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
			valuesMap.put("bloodGroupId", bloodGroupId);
		}

		if (request.getParameter(DISTRICT) != null
				&& !request.getParameter(DISTRICT).equals("0")) {
			int districtId = Integer.parseInt(request.getParameter(DISTRICT));
			valuesMap.put("districtId", districtId);
		}
		if (request.getParameter(ADDRESS) != null) {
			String address = request.getParameter(ADDRESS);
			valuesMap.put("address", address);
		}
		if (request.getParameter(PATIENT_DISTRICT) != null) {
			String patientDistrict = request.getParameter(PATIENT_DISTRICT);
			valuesMap.put("patientDistrict", patientDistrict);
		}

		if (request.getParameter(BLOCK) != null
				&& !request.getParameter(BLOCK).equals("0")) {
			int blockId = Integer.parseInt(request.getParameter(BLOCK));
			valuesMap.put("blockId", blockId);
		}
		if (request.getParameter(PINCODE) != null) {
			String pinCode = request.getParameter(PINCODE);
			valuesMap.put("pinCode", pinCode);
		}

		if (request.getParameter(POST_OFFICE) != null) {
			String postOffice = request.getParameter(POST_OFFICE);
			valuesMap.put("postOffice", postOffice);
		}

		int countryId = Integer.parseInt(request.getParameter(NATIONALITY));
		valuesMap.put("countryId", countryId);

		int stateId = Integer.parseInt(request.getParameter(STATE));
		valuesMap.put("stateId", stateId);

		if (request.getParameter(PHONE) != null) {
			String phoneNumber = request.getParameter(PHONE);
			valuesMap.put("phoneNumber", phoneNumber);
		}
		if (request.getParameter(MOBILE) != null) {
			String mobileNo = request.getParameter(MOBILE);
			valuesMap.put("mobileNo", mobileNo);
		}
		if (request.getParameter(EMAIL_ID) != null) {
			String email = request.getParameter(EMAIL_ID);
			valuesMap.put("email", email);
		}
		if (request.getParameter(DIAGNOSIS_ID) != null
				&& !request.getParameter(DIAGNOSIS_ID).equals("")) {
			String diagnosis = (String) request.getParameter(DIAGNOSIS_ID);
			valuesMap.put("diagnosisId", diagnosis);
		}

		if (request.getParameter(DISPOSAL_ID) != null
				&& !request.getParameter(DISPOSAL_ID).equals("0")) {
			int disposalId = Integer
					.parseInt(request.getParameter(DISPOSAL_ID));
			valuesMap.put("disposalId", disposalId);
		}

		if (request.getParameter(RELATIVE_NAME) != null) {
			String relativeName = request.getParameter(RELATIVE_NAME);
			valuesMap.put("relativeName", relativeName);
		}
		if (request.getParameter(RELATION_ID) != null
				&& !request.getParameter(RELATION_ID).equals("0")) {
			int relationId = Integer
					.parseInt(request.getParameter(RELATION_ID));
			valuesMap.put("nokRelationId", relationId);
		}
		if (request.getParameter(EMERGENCY_ADDRESS) != null) {
			String nokAddress = request.getParameter(EMERGENCY_ADDRESS);
			valuesMap.put("nokAddress", nokAddress);
		}

		if (request.getParameter(EMERGENCY_PHONE) != null) {
			String nokPhone = request.getParameter(EMERGENCY_PHONE);
			valuesMap.put("nokPhone", nokPhone);
		}

		if (request.getParameter(RECORD_OFFICE_ADDRESS_ID) != null
				&& !request.getParameter(RECORD_OFFICE_ADDRESS_ID).equals("0")) {
			int recordOfficeAddId = Integer.parseInt(request
					.getParameter(RECORD_OFFICE_ADDRESS_ID));
			valuesMap.put("recordOfficeAddId", recordOfficeAddId);
		}

		if (request.getParameter(FORMATION_ID) != null) {
			String formation = request.getParameter(FORMATION_ID);
			valuesMap.put("formation", formation);
		}

		if (request.getParameter(STATION) != null) {
			String station = request.getParameter(STATION);
			valuesMap.put("station", station);
		}

		if (request.getParameter(CDA_ACCOUNT_NO) != null) {
			String cdAccNo = request.getParameter(CDA_ACCOUNT_NO);
			valuesMap.put("cdAccNo", cdAccNo);
		}
		if (request.getParameter(REFERENCE) != null
				&& !request.getParameter(REFERENCE).equals("0")) {
			int referenceId = Integer.parseInt(request.getParameter(REFERENCE));
			valuesMap.put("referenceId", referenceId);
		}
		if (request.getParameter(REMARKS) != null) {
			String remarks = request.getParameter(REMARKS);
			valuesMap.put("remarks", remarks);
		}

		if (request.getParameter(CHANGED_DATE) != null) {
			Date addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			valuesMap.put("addEditDate", addEditDate);
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			String addEditTime = request.getParameter(CHANGED_TIME);
			valuesMap.put("addEditTime", addEditTime);
		}

		if (request.getParameter(POLICE_STATION) != null) {
			String policeStation = request.getParameter(POLICE_STATION);
			valuesMap.put("policeStation", policeStation);
		}
		if (request.getParameter(I_CARD_VALIDITY_DATE) != null
				&& !(request.getParameter(I_CARD_VALIDITY_DATE).equals(""))) {
			Date cardDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(I_CARD_VALIDITY_DATE));
			valuesMap.put("ICardDate", cardDate);
		}
		if (request.getParameter(DEPENDENT_CARD_ISSUE_DATE) != null
				&& !(request.getParameter(DEPENDENT_CARD_ISSUE_DATE).equals(""))) {
			Date dCardDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DEPENDENT_CARD_ISSUE_DATE));
			valuesMap.put("DCardDate", dCardDate);

		}
		if (request.getParameter(I_CARD_VERIFIED) != null) {
			String iCardVar = request.getParameter(I_CARD_VERIFIED);
			valuesMap.put("ICardVer", iCardVar);
		} else {
			valuesMap.put("ICardVer", "n");
		}

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		valuesMap.put("userId", userId);

		boolean successfullyUpdated = false;
		String message = "";
		successfullyUpdated = registrationHandlerService
				.updateRegistrationInformation(valuesMap);
		if (successfullyUpdated) {
			message = " Registration Information Updated Successfully.";

		} else {
			message = "Some problem Occured! Try Again.";
		}
		String jsp = MESSAGE_FOR_ADT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ============================================================================================

	/**
	 * ----------------------------------- Upadate Patient Visit
	 * ----------------------------
	 */

	public ModelAndView showUpdateVisitJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> patientVisitMap = new HashMap<String, Object>();

		int visitNo = 0;
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			parameterMap.put("hinNo", hinNo);
		}
		if (request.getParameter(VISIT_NUMBER) != null
				&& !request.getParameter(VISIT_NUMBER).equals("")) {
			visitNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
			parameterMap.put("visitNo", visitNo);
		}
		patientVisitMap = registrationHandlerService
				.getPatientVisitDetailsForUpdate(parameterMap);
		map = registrationHandlerService.getVisitDetails();

		String jsp = UPDATE_PATIENT_VISIT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientVisitMap", patientVisitMap);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateVisitInformation(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int tokenNo = 0;
		int visitId = 0;
		if (request.getParameter(VISIT_ID) != null) {
			visitId = Integer.parseInt(request.getParameter(VISIT_ID));
			parameterMap.put("visitId", visitId);
		}

		if (request.getParameter(COMPLAINT_ID) != null
				&& !(request.getParameter(COMPLAINT_ID).equals(""))) {
			String complaint = (String) request.getParameter(COMPLAINT_ID);
			parameterMap.put("complaintId", complaint);

		}
		if (!(request.getParameter(CASE_TYPE_ID).equals("0"))) {
			int caseTypeId = Integer.parseInt(request
					.getParameter(CASE_TYPE_ID));
			parameterMap.put("caseTypeId", caseTypeId);

		}
		if (request.getParameter(DIAGNOSIS_ID) != null
				&& !(request.getParameter(DIAGNOSIS_ID).equals(""))) {
			String diagnosis = (String) request.getParameter(DIAGNOSIS_ID);
			parameterMap.put("diagnosisId", diagnosis);

		}
		if (request.getParameter(DISPOSAL_ID) != null
				&& !(request.getParameter(DISPOSAL_ID).equals("0"))) {
			int disposalId = Integer
					.parseInt(request.getParameter(DISPOSAL_ID));
			parameterMap.put("disposalId", disposalId);

		}

		if (request.getParameter(HOSPITAL_STAFF) != null) {
			parameterMap.put("hospitalStaff",
					request.getParameter(HOSPITAL_STAFF));
		}
		if (request.getParameter(CONSULTING_DOCTOR) != null) {
			parameterMap.put("consultingDoctor",
					request.getParameter(CONSULTING_DOCTOR));
		}
		if (request.getParameter(TOKEN_NO) != null
				&& request.getParameter(TOKEN_NO) != "") {
			tokenNo = Integer.parseInt(request.getParameter(TOKEN_NO));
			parameterMap.put("tokenNo", tokenNo);
		}

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		parameterMap.put("userId", userId);

		if (request.getParameter(CHANGED_DATE) != null) {
			Date addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			parameterMap.put("addEditDate", addEditDate);
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			String addEditTime = request.getParameter(CHANGED_TIME);
			parameterMap.put("addEditTime", addEditTime);

		}

		boolean successfullyUpdated = false;
		Map<String, Object> infoMap = new HashMap<String, Object>();
		infoMap = registrationHandlerService.updateVisitDetails(parameterMap);
		successfullyUpdated = (Boolean) infoMap.get("updatedSuccessfully");
		List<Visit> visitList = (List<Visit>) infoMap.get("visitList");
		map.put("visitList", visitList);
		String message = "";
		String hinNo = (visitList.get(0).getHin().getHinNo());
		map.put("hinNo", hinNo);
		if (successfullyUpdated) {
			message = " Patient Visit Information Updated Successfully.";

		} else {
			message = "Some problem Occured! Try Again.";
		}
		String jsp = MSG_FOR_REG;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * ----------------------------------- Methods For Ajax Response
	 * ----------------------------
	 */
	public void calculateAgeInAjax(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);

		try {
			Date dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(box
					.get("dateOfBirth"));
			// get todays date
			Calendar now = Calendar.getInstance();
			// get a calendar representing their birth date

			Calendar cal = Calendar.getInstance();
			cal.setTime(dateOfBirth);

			// calculate age as the difference in years.
			@SuppressWarnings("unused")
			int calculatedDays, calculatedMonth, calculatedYear;
			int currentDays = now.get(Calendar.DATE);
			int birthDays = cal.get(Calendar.DATE);
			int currentMonth = now.get(Calendar.MONTH);
			int birthMonth = cal.get(Calendar.MONTH);
			int currentYear = now.get(Calendar.YEAR);
			int birthYear = cal.get(Calendar.YEAR);

			// if(currentDays<birthDays)
			// {
			// currentDays=currentDays+30;
			// calculatedDays=currentDays-birthDays;
			// currentMonth=currentMonth-1;
			// }
			// else{
			// calculatedDays=currentDays-birthDays;
			// }
			//
			// if(currentMonth<birthMonth)
			// {
			// currentMonth=currentMonth+12;
			// calculatedMonth=currentMonth-birthMonth;
			// currentYear=currentYear-1;
			// }
			// else{
			// calculatedMonth=currentMonth-birthMonth;
			// }

			calculatedMonth = currentMonth - birthMonth;
			if (calculatedMonth == 1) {
				calculatedDays = currentDays + (31 - birthDays);
			} else {
				calculatedDays = currentDays - birthDays;
			}

			calculatedYear = currentYear - birthYear;
			int age = 0;
			if (calculatedMonth < -5)
				age = calculatedYear - 1;
			else
				age = calculatedYear;
			String period = "";

			if (calculatedYear == 0 && calculatedMonth != 0
					&& calculatedDays != 0) {
				if (calculatedMonth == 1 && calculatedDays < 30) {
					age = calculatedDays;
					period = "Days";
				} else {
					age = calculatedMonth;
					period = "Months";
				}

			} else if (age == 0 && calculatedMonth == 0 && calculatedDays != 0) {
				age = calculatedDays;
				period = "Days";
			} else if (age == 0 && calculatedMonth == 0 && calculatedDays == 0) {
				age = 0;
				period = "Days";
			} else {

				period = "Years";
			}
			// ------------Response------------------

			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<age>" + age + "</age>");
			sb.append("<period>" + period + "</period>");
			sb.append("</item>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public ModelAndView calculateAge(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
				.getParameter("dateOfBirth"));
		String age = HMSUtil.calculateAge(dateOfBirth);
		String jsp = "responseForAge";
		map.put("age", age);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getHinNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		int serviceTypeId = 0;
		if (request.getParameter("serviceTypeId") != null) {
			serviceTypeId = Integer.parseInt(request
					.getParameter("serviceTypeId"));
		}
		int relationId = 0;
		if (request.getParameter("relationId") != null
				&& !(request.getParameter("relationId").equals("0"))) {
			relationId = Integer.parseInt(request.getParameter("relationId"));
		} else {
			relationId = 8;
		}
		int serviceStatusId = Integer.parseInt(request
				.getParameter("serviceStatus"));
		if (serviceTypeId == 7) {
			String serviceNoTemp = "no";
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String currentTime = (String) utilMap.get("currentTime");

			try {

				serviceNoTemp = currentDate.substring(0,
						currentDate.indexOf("/"))
						+ currentDate.substring(currentDate.indexOf("/") + 1,
								currentDate.lastIndexOf("/"))
						+ currentDate.substring(
								currentDate.lastIndexOf("/") + 3,
								currentDate.length())
						+ currentTime.substring(0, currentTime.indexOf(":"))
						/*
						 * + currentTime.substring(currentTime.indexOf(":") +
						 * 1,currentTime.lastIndexOf(":"))
						 */
						+ currentTime.substring(
								currentTime.lastIndexOf(":") + 1,
								currentTime.length());
				serviceNo = serviceNoTemp;
				System.out.println("serviceNo=" + serviceNo);
			} catch (Exception e) {
				System.out.println("e=" + e);
				e.printStackTrace();
			}
		}
		Map<String, Object> serviceAndRelationMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("serviceTypeId", serviceTypeId);
		parameterMap.put("relationId", relationId);
		parameterMap.put("serviceStatusId", serviceStatusId);

		serviceAndRelationMap = registrationHandlerService
				.getServiceTypeAndRelation(parameterMap);
		String relationCode = (String) serviceAndRelationMap
				.get("relationCode");
		String serviceTypeCode = (String) serviceAndRelationMap
				.get("serviceTypeCode");
		String serviceStatusCode = (String) serviceAndRelationMap
				.get("serviceStatusCode");
		String maxSequenceNo = "";
		maxSequenceNo = registrationHandlerService.getHinId(serviceNo,
				serviceTypeId);
		Integer i;
		if (!maxSequenceNo.equals("")) {
			i = Integer.parseInt(maxSequenceNo) + 1;
		} else {
			i = 01;
		}
		String seqNo = "";
		if (i <= 9) {
			seqNo = "0" + i.toString();
		} else {
			seqNo = i.toString();
		}
		if (!serviceNo.equals("0")) {
			hinNo = serviceTypeCode.concat(serviceStatusCode).concat(serviceNo)
					.concat(relationCode)/* .concat(seqNo.toString()) */;
		} else {
			hinNo = serviceTypeCode.concat(seqNo.toString());
		}

		String jsp = AJAX_MESSAGE_JSP;

		String message = hinNo;
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getHinNoHAL(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map serviceAndRelationMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String patientCode = "";
		String relationCode = "";
		
		String patientTypeNameForHAL="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			patientTypeNameForHAL=properties.getProperty("patientTypeNameForHAL");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		String patientTypeCode = "";
		serviceAndRelationMap = registrationHandlerService
				.getPatientTypeCodeAndRelationCode(request);

		if (serviceAndRelationMap.get("relationCode") != null) {
			relationCode = (String) serviceAndRelationMap.get("relationCode");
		}
		if (serviceAndRelationMap.get("patientCode") != null) {
			patientCode = (String) serviceAndRelationMap.get("patientCode");
		}
		if (request.getParameter("patientTypeName") != null
				&& request.getParameter("patientTypeName").equals(patientTypeNameForHAL)) {
			hinNo = patientCode.concat(serviceNo).concat(relationCode);
		} else {
			String maxSequenceNo = "";
			maxSequenceNo = registrationHandlerService.getHinIdHAL(patientCode, request);
			Integer i;
			if (!maxSequenceNo.equals("")) {
				i = Integer.parseInt(maxSequenceNo) + 1;

			} else {
				i = 01;
			}
			String seqNo = "";
			if (i <= 9) {
				seqNo = "0" + i.toString();
			} else {
				seqNo = i.toString();
			}
			hinNo = patientCode.concat(seqNo.toString());
		}

		String jsp = AJAX_MESSAGE_JSP;
		System.out.println("hinNO" + hinNo);
		String message = hinNo;
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}
	
	public String getHinNoHALDynamic(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map serviceAndRelationMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String patientCode = "";
		String relationCode = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		String patientTypeCode = "";
		serviceAndRelationMap = registrationHandlerService
				.getPatientTypeCodeAndRelationCode(request);

		if (serviceAndRelationMap.get("relationCode") != null) {
			relationCode = (String) serviceAndRelationMap.get("relationCode");
		}
		if (serviceAndRelationMap.get("patientCode") != null) {
			patientCode = (String) serviceAndRelationMap.get("patientCode");
		}
		if (request.getParameter("patientTypeName") != null
				&& request.getParameter("patientTypeName").equals("HAL")) {
			hinNo = patientCode.concat(serviceNo).concat(relationCode);
		} else {
			String maxSequenceNo = "";
			maxSequenceNo = registrationHandlerService.getHinIdHAL(patientCode, request);
			Integer i;
			if (!maxSequenceNo.equals("")) {
				i = Integer.parseInt(maxSequenceNo) + 1;

			} else {
				i = 01;
			}
			String seqNo = "";
			if (i <= 9) {
				seqNo = "0" + i.toString();
			} else {
				seqNo = i.toString();
			}
			hinNo = patientCode.concat(seqNo.toString());
		}

		return hinNo;
	}

	public ModelAndView getMothersName(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		String motherHinNo = "";
		if (request.getParameter("motherHinNo") != null) {
			motherHinNo = request.getParameter("motherHinNo");
		}
		String motherName = "";
		motherName = registrationHandlerService.getMothersName(motherHinNo);
		if (motherName.equals("")) {
			motherName = "No Records Matched !";
		}
		String jsp = AJAX_MESSAGE_JSP;
		String message = motherName;
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getTokenNoForDepartmentMultiVisit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int doctorId = 0;
		int sessionId = 0;
		
		int deptId = 0;
		String tokenMsg = "";
		String msg = "Available";
		int row = Integer.parseInt(request.getParameter("row"));

		if (!request.getParameter("consultingDoctor"+row).equals("0") && !request.getParameter(SESSION_ID+row).equals("0") && !request.getParameter(DEPARTMENT_ID+row).equals("0")) {
			tokenMsg = "";
			doctorId = 0;
			sessionId = 0;			
			deptId = 0;
			doctorId = Integer
					.parseInt(request.getParameter("consultingDoctor"+row));
			sessionId = Integer
					.parseInt(request.getParameter(SESSION_ID+row));
			deptId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID+row));
			 
			tokenMsg = registrationHandlerService
					.getTokenNoForDepartment(doctorId, sessionId, deptId, request);
			map.put("tokenMsg", tokenMsg);	
			
		} 
	 
		String jsp = "responseForTokenNoMultiVisit";
		map.put("row", row);
			
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getTokenNoForDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int doctorId = 0;
		int sessionId = 0;
		int tokenNo = 0;
		int deptId = 0;
		String tokenMsg = "";
		String msg = "Available";
		if (!request.getParameter(EMPLOYEE_ID).equals("0") && !request.getParameter(SESSION_ID).equals("0") && !request.getParameter(DEPARTMENT_ID).equals("0")) {
			doctorId = Integer
					.parseInt(request.getParameter(EMPLOYEE_ID));
			sessionId = Integer
					.parseInt(request.getParameter(SESSION_ID));
			deptId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
			int maxTokenNo = 0;
			tokenMsg = registrationHandlerService
					.getTokenNoForDepartment(doctorId, sessionId, deptId, request);
			System.out.println(tokenMsg+" jj");
			
		} 
		String jsp = "responseForTokenNo";
		map.put("tokenMsg", tokenMsg);		
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getTokenNoForDepartmentReferral(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int doctorId = 0;
		int sessionId = 0;
		int tokenNo = 0;
		int deptId = 0;
		String tokenMsg = "";
		String msg = "Available";
		if (!request.getParameter(EMPLOYEE_ID).equals("0") && !request.getParameter(SESSION_ID).equals("0") && !request.getParameter(DEPARTMENT_ID).equals("0")) {
			doctorId = Integer
					.parseInt(request.getParameter(EMPLOYEE_ID));
			sessionId = Integer
					.parseInt(request.getParameter(SESSION_ID));
			deptId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
			int maxTokenNo = 0;
			tokenMsg = registrationHandlerService
					.getTokenNoForDepartment(doctorId, sessionId, deptId, request);
			System.out.println(tokenMsg+" jj");
			
		} 
		String jsp = "responseForTokenNoReferral";
		map.put("tokenMsg", tokenMsg);		
		map.put("tokenNoDisplayflag", "n");		
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getTokenNoForTransferPatient(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int doctorId = 0;
		int sessionId = 0;
		//int tokenNo = 0;
		int deptId = 0;
		String tokenMsg = "";
		String tokenNoDisplayflag ="n";//patient transfer
		String msg = "Available";
		request.setAttribute("tokenNoDisplayflag", tokenNoDisplayflag);
		if (!request.getParameter("refereddoctor").equals("0") && !request.getParameter("referredsesId").equals("0") && !request.getParameter("referdepartment").equals("0")) {
			doctorId = Integer
					.parseInt(request.getParameter("refereddoctor"));
			sessionId = Integer
					.parseInt(request.getParameter("referredsesId"));
			deptId = Integer
					.parseInt(request.getParameter("referdepartment"));
			int maxTokenNo = 0;
			tokenMsg = registrationHandlerService
					.getTokenNoForDepartment(doctorId, sessionId, deptId, request);
		/*	if(tokenMsg!=null)
			{
				String digitOnly = "[0-9]+";
				if(tokenMsg.matches(digitOnly))
				{
					tokenMsg="";
				}
				
			}*/
			
		} 
		String jsp = "responseForTokenNo";
		map.put("tokenMsg", tokenMsg);
		map.put("tokenNoDisplayflag", tokenNoDisplayflag);
		
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView checkPatientRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String patientName = "";
		int serviceTypeId = 0;
		int relationId = 0;
		int serviceStatusId = 0;
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<Patient> patientListForInfo = new ArrayList<Patient>();
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
			parameterMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter("serviceTypeId") != null) {
			serviceTypeId = Integer.parseInt(request
					.getParameter("serviceTypeId"));
			parameterMap.put("serviceTypeId", serviceTypeId);
		}
		if (request.getParameter("relationId") != null) {
			relationId = Integer.parseInt(request.getParameter("relationId"));
			parameterMap.put("relationId", relationId);
		}
		if (request.getParameter("serviceStatus") != null) {
			serviceStatusId = Integer.parseInt(request
					.getParameter("serviceStatus"));
			parameterMap.put("serviceStatusId", serviceStatusId);
		}

		if (request.getParameter("patientName") != null) {
			patientName = request.getParameter("patientName");
			parameterMap.put("patientName", patientName);

		}
		Map<String, Object> detailMap = new HashMap<String, Object>();
		detailMap.get("patientList");
		List<Patient> patientList = new ArrayList<Patient>();
		detailMap = registrationHandlerService
				.getPatientListForName(parameterMap);
		patientList = (List<Patient>) detailMap.get("patientList");
		patientListForInfo = (List<Patient>) detailMap
				.get("patientListForInfo");
		String jsp = "responsePatient";
		map.put("patientList", patientList);
		map.put("patientListForInfo", patientListForInfo);
		map.put("serviceTypeId", serviceTypeId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView checkPatientRegistrationHAL(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String patientName = "";
		int serviceTypeId = 0;
		int relationId = 0;
		int serviceStatusId = 0;
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<Patient> patientListForInfo = new ArrayList<Patient>();
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
			parameterMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter("serviceTypeId") != null) {
			serviceTypeId = Integer.parseInt(request
					.getParameter("serviceTypeId"));
			parameterMap.put("serviceTypeId", serviceTypeId);
		}
		if (request.getParameter("relationId") != null) {
			relationId = Integer.parseInt(request.getParameter("relationId"));
			parameterMap.put("relationId", relationId);
		}
		if (request.getParameter("serviceStatus") != null) {
			serviceStatusId = Integer.parseInt(request
					.getParameter("serviceStatus"));
			parameterMap.put("serviceStatusId", serviceStatusId);
		}

		if (request.getParameter("patientName") != null) {
			patientName = request.getParameter("patientName");
			parameterMap.put("patientName", patientName);

		}
		Map<String, Object> detailMap = new HashMap<String, Object>();
		detailMap.get("patientList");
		List<Patient> patientList = new ArrayList<Patient>();
		detailMap = registrationHandlerService
				.getPatientListForNameHAL(parameterMap);
		patientList = (List<Patient>) detailMap.get("patientList");
		patientListForInfo = (List<Patient>) detailMap
				.get("patientListForInfo");
		String jsp = "responsePatient";
		map.put("patientList", patientList);
		map.put("patientListForInfo", patientListForInfo);
		map.put("serviceTypeId", serviceTypeId);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * public ModelAndView getHinNoForUpdateAdt(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); Map<String, Object> detailsMap = new
	 * HashMap<String, Object>(); String serviceNo = ""; String hinNo = "";
	 * String flag = ""; if (request.getParameter(SERVICE_NO) != null &&
	 * !(request.getParameter(SERVICE_NO).equals(""))) { serviceNo =
	 * request.getParameter(SERVICE_NO); detailsMap.put("serviceNo", serviceNo);
	 * } if (request.getParameter(HIN_NO) != null &&
	 * !(request.getParameter(HIN_NO).equals(""))) { hinNo =
	 * request.getParameter(HIN_NO); detailsMap.put("hinNo", hinNo); } if
	 * (request.getParameter("flag") != null &&
	 * !(request.getParameter("flag").equals(""))) { flag =
	 * request.getParameter("flag"); map.put("flag", flag); }
	 * 
	 * List<Object> hinNoList = new ArrayList<Object>(); hinNoList =
	 * registrationHandlerService.getHinNoList(serviceNo); map.put("hinNoList",
	 * hinNoList); String jsp = "populateHinNoForUpdate"; return new
	 * ModelAndView(jsp, "map", map); }
	 */

	public ModelAndView getPatientName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		String patientName = "";
		patientName = registrationHandlerService.getMothersName(hinNo);

		String jsp = "populatePatientNameForUpdate";
		map.put("name", patientName);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getVisitNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		List<Visit> visitNoList = new ArrayList<Visit>();
		visitNoList = registrationHandlerService.getVisitNo(hinNo);

		String jsp = "populateVisitNoForUpdate";
		map.put("visitNoList", visitNoList);
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * LDAP Properties
	 */
	public static List<Map<String, Object>> listLDAPData = new ArrayList<Map<String, Object>>();
	public static String INITCTX = "com.sun.jndi.ldap.LdapCtxFactory"; // driver
	/*
	 * public static String MY_HOST = "ldap://192.168.10.11:389"; // server and
	 * port public static String MY_FILTER =
	 * "(&(sAMAccountName=ritu.sahu)(!(objectclass=computer)))"; //filter
	 */public static String MY_ATTRS[] = { "cn", "sn", "givenName",
			"distinguishedName", "instanceType", "whenCreated", "displayName",
			"uSNCreated", "uSNChanged", "name", "userAccountControl",
			"badPwdCount", "codePage", "countryCode", "badPasswordTime",
			"lastLogoff", "lastLogon", "pwdLastSet", "primaryGroupID",
			"accountExpires", "logonCount", "sAMAccountName", "sAMAccountType",
			"objectCategory", "dSCorePropagationData", "objectGUID",
			"objectSid", "apptMain", "bloodgroup", "branch", "department",
			"dob", "initials", "mail", "objectClass", "rank" };
	public static String MY_SEARCHBASE = "dc=iaf,dc=in"; // base DC

	// public static String MY_SEARCHBASE = "dc=noida,dc=jkt,dc=in"; // base DC

	/**
	 * End
	 */

	public ModelAndView getServicePersonName(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		HttpSession session = request.getSession();
		int serviceTypeId = 0;
		if (request.getParameter(SERVICE_NO) != null) {
			// serviceNo = request.getParameter(SERVICE_NO);
			serviceNo = HMSUtil.restrictMetaChar(request
					.getParameter(SERVICE_NO));
		}

		if (request.getParameter(SERVICE_TYPE_ID) != null
				&& !request.getParameter(SERVICE_TYPE_ID).equals("0")) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}
		/*
		 * String type = ""; if(request.getParameter("type") != null){ type =
		 * request.getParameter("type"); }
		 */
		map = registrationHandlerService.getServicePersonName(serviceNo,
				serviceTypeId);
		List<Patient> list = new ArrayList<Patient>();
		if (map.get("list") != null) {
			list = (List<Patient>) map.get("list");
		}
		List<MasEmployee> srEmployeeList = new ArrayList<MasEmployee>();
		if (map.get("srEmployeeList") != null) {
			srEmployeeList = (List<MasEmployee>) map.get("srEmployeeList");
		}

		if (list.size() == 0 && srEmployeeList.size() == 0) {
			String my_filter_name = "(&(sAMAccountName=" + serviceNo
					+ ")(!(objectclass=computer)))"; // filter
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("ldap.properties");

			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String my_host_name = properties.getProperty("ldapHostForSearch");
			List<Map<String, Object>> listLDAPDataTemp = new ArrayList<Map<String, Object>>();
			try {
				String loginName = (String) session.getAttribute("loginName");
				String loginNameDN = "iaf\\" + loginName;
				String password = (String) session.getAttribute("password");
				listLDAPDataTemp = LDAPAuthAndSearch.searchFromLdap(loginName,
						loginNameDN, password, my_filter_name, MY_ATTRS,
						MY_SEARCHBASE, INITCTX, my_host_name);
				map.put("listLDAPDataTemp", listLDAPDataTemp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter(SERVICE_STATUS_ID) != null)
			map.put("serviceStatusId",
					Integer.parseInt(request.getParameter(SERVICE_STATUS_ID)));
		if (request.getParameter("prefix") != null)
			map.put("prefix",
					HMSUtil.restrictMetaChar(request.getParameter("prefix")));
		if (request.getParameter("suffix") != null)
			map.put("suffix",
					HMSUtil.restrictMetaChar(request.getParameter("suffix")));

		map.put("serviceNo", serviceNo);
		map.put("serviceTypeId", serviceTypeId);
		if (request.getParameter("echs") != null) {
			map.put("echs",
					HMSUtil.restrictMetaChar(request.getParameter("echs")));
		}
		String jsp = "";
		jsp = "responseForServPersonName";
		/*
		 * if(type.equalsIgnoreCase("registration")){ }else
		 * if(type.equalsIgnoreCase("medicalExam")){ jsp =
		 * "responseForSPNameMedExam"; }
		 */
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getServicePersonNameHAL(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		HttpSession session = request.getSession();
		int serviceTypeId = 0;
		if (request.getParameter(SERVICE_NO) != null) {
			// serviceNo = request.getParameter(SERVICE_NO);
			serviceNo = HMSUtil.restrictMetaChar(request
					.getParameter(SERVICE_NO));
		}

		// if (request.getParameter(SERVICE_TYPE_ID)!= null &&
		// !request.getParameter(SERVICE_TYPE_ID).equals("0")) {
		// serviceTypeId = Integer.parseInt(request
		// .getParameter(SERVICE_TYPE_ID));
		// }
		/*
		 * String type = ""; if(request.getParameter("type") != null){ type =
		 * request.getParameter("type"); }
		 */
		map = registrationHandlerService.getServicePersonNameHAL(serviceNo,
				serviceTypeId);
		List<Patient> list = new ArrayList<Patient>();
		if (map.get("list") != null) {
			list = (List<Patient>) map.get("list");
		}
		List<MasEmployee> srEmployeeList = new ArrayList<MasEmployee>();
		if (map.get("srEmployeeList") != null) {
			srEmployeeList = (List<MasEmployee>) map.get("srEmployeeList");
		}

		/*if (list.size() == 0 && srEmployeeList.size() == 0) {
			String my_filter_name = "(&(sAMAccountName=" + serviceNo
					+ ")(!(objectclass=computer)))"; // filter
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("ldap.properties");

			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String my_host_name = properties.getProperty("ldapHostForSearch");
			List<Map<String, Object>> listLDAPDataTemp = new ArrayList<Map<String, Object>>();
			try {
				String loginName = (String) session.getAttribute("loginName");
				String loginNameDN = "iaf\\" + loginName;
				String password = (String) session.getAttribute("password");
				listLDAPDataTemp = LDAPAuthAndSearch.searchFromLdap(loginName,
						loginNameDN, password, my_filter_name, MY_ATTRS,
						MY_SEARCHBASE, INITCTX, my_host_name);
				map.put("listLDAPDataTemp", listLDAPDataTemp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/

		if (request.getParameter(SERVICE_STATUS_ID) != null)
			map.put("serviceStatusId",
					Integer.parseInt(request.getParameter(SERVICE_STATUS_ID)));
		if (request.getParameter("prefix") != null)
			map.put("prefix",
					HMSUtil.restrictMetaChar(request.getParameter("prefix")));
		if (request.getParameter("suffix") != null)
			map.put("suffix",
					HMSUtil.restrictMetaChar(request.getParameter("suffix")));

		map.put("serviceNo", serviceNo);
		map.put("serviceTypeId", serviceTypeId);
		if (request.getParameter("echs") != null) {
			map.put("echs",
					HMSUtil.restrictMetaChar(request.getParameter("echs")));
		}
		String jsp = "";
		jsp = "responseForServPersonNameHAL";
		/*
		 * if(type.equalsIgnoreCase("registration")){ }else
		 * if(type.equalsIgnoreCase("medicalExam")){ jsp =
		 * "responseForSPNameMedExam"; }
		 */
		return new ModelAndView(jsp, "map", map);

	}
	
	public ModelAndView getServicePersonNameForOtherVisit(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		HttpSession session = request.getSession();
		int serviceTypeId = 0;
		if (request.getParameter(SERVICE_NO) != null) {
			// serviceNo = request.getParameter(SERVICE_NO);
			serviceNo = HMSUtil.restrictMetaChar(request
					.getParameter(SERVICE_NO));
		}

		// if (request.getParameter(SERVICE_TYPE_ID)!= null &&
		// !request.getParameter(SERVICE_TYPE_ID).equals("0")) {
		// serviceTypeId = Integer.parseInt(request
		// .getParameter(SERVICE_TYPE_ID));
		// }
		/*
		 * String type = ""; if(request.getParameter("type") != null){ type =
		 * request.getParameter("type"); }
		 */
		map = registrationHandlerService.getServicePersonNameHAL(serviceNo,
				serviceTypeId);
		List<Patient> list = new ArrayList<Patient>();
		if (map.get("list") != null) {
			list = (List<Patient>) map.get("list");
		}
		List<MasEmployee> srEmployeeList = new ArrayList<MasEmployee>();
		if (map.get("srEmployeeList") != null) {
			srEmployeeList = (List<MasEmployee>) map.get("srEmployeeList");
		}

		if (list.size() == 0 && srEmployeeList.size() == 0) {
			String my_filter_name = "(&(sAMAccountName=" + serviceNo
					+ ")(!(objectclass=computer)))"; // filter
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("ldap.properties");

			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String my_host_name = properties.getProperty("ldapHostForSearch");
			List<Map<String, Object>> listLDAPDataTemp = new ArrayList<Map<String, Object>>();
			try {
				String loginName = (String) session.getAttribute("loginName");
				String loginNameDN = "iaf\\" + loginName;
				String password = (String) session.getAttribute("password");
				listLDAPDataTemp = LDAPAuthAndSearch.searchFromLdap(loginName,
						loginNameDN, password, my_filter_name, MY_ATTRS,
						MY_SEARCHBASE, INITCTX, my_host_name);
				map.put("listLDAPDataTemp", listLDAPDataTemp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter(SERVICE_STATUS_ID) != null)
			map.put("serviceStatusId",
					Integer.parseInt(request.getParameter(SERVICE_STATUS_ID)));
		if (request.getParameter("prefix") != null)
			map.put("prefix",
					HMSUtil.restrictMetaChar(request.getParameter("prefix")));
		if (request.getParameter("suffix") != null)
			map.put("suffix",
					HMSUtil.restrictMetaChar(request.getParameter("suffix")));

		map.put("serviceNo", serviceNo);
		map.put("serviceTypeId", serviceTypeId);
		if (request.getParameter("echs") != null) {
			map.put("echs",
					HMSUtil.restrictMetaChar(request.getParameter("echs")));
		}
		String jsp = "";
		jsp = "responseForServPersonNameForOtherVisit";
		/*
		 * if(type.equalsIgnoreCase("registration")){ }else
		 * if(type.equalsIgnoreCase("medicalExam")){ jsp =
		 * "responseForSPNameMedExam"; }
		 */
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView responseForVisitOfHALEmployees(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		HttpSession session = request.getSession();
		int serviceTypeId = 0;
		if (request.getParameter(SERVICE_NO) != null) {
			// serviceNo = request.getParameter(SERVICE_NO);
			serviceNo = request
					.getParameter(SERVICE_NO);
		}
		System.out.println("ServiceNoInController="+serviceNo);
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		/*
		 * if (request.getParameter(SERVICE_TYPE_ID) != null &&
		 * !request.getParameter(SERVICE_TYPE_ID).equals("0")) { serviceTypeId =
		 * Integer.parseInt(request .getParameter(SERVICE_TYPE_ID)); }
		 */
		/*
		 * String type = ""; if(request.getParameter("type") != null){ type =
		 * request.getParameter("type"); }
		 */
		map = registrationHandlerService.responseForVisitOfHALEmployees(
				serviceNo, serviceTypeId, hospitalId);
		List<Patient> list = new ArrayList<Patient>();
		if (map.get("list") != null) {
			list = (List<Patient>) map.get("list");
		}
		List<MasEmployee> srEmployeeList = new ArrayList<MasEmployee>();
		if (map.get("srEmployeeList") != null) {
			srEmployeeList = (List<MasEmployee>) map.get("srEmployeeList");
		}

		/*if (list.size() == 0 && srEmployeeList.size() == 0) {
			String my_filter_name = "(&(sAMAccountName=" + serviceNo
					+ ")(!(objectclass=computer)))"; // filter
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("ldap.properties");

			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String my_host_name = properties.getProperty("ldapHostForSearch");
			List<Map<String, Object>> listLDAPDataTemp = new ArrayList<Map<String, Object>>();
			try {
				String loginName = (String) session.getAttribute("loginName");
				String loginNameDN = "iaf\\" + loginName;
				String password = (String) session.getAttribute("password");
				listLDAPDataTemp = LDAPAuthAndSearch.searchFromLdap(loginName,
						loginNameDN, password, my_filter_name, MY_ATTRS,
						MY_SEARCHBASE, INITCTX, my_host_name);
				map.put("listLDAPDataTemp", listLDAPDataTemp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/

		if (request.getParameter(SERVICE_STATUS_ID) != null)
			map.put("serviceStatusId",
					Integer.parseInt(request.getParameter(SERVICE_STATUS_ID)));
		if (request.getParameter("prefix") != null)
			map.put("prefix",
					HMSUtil.restrictMetaChar(request.getParameter("prefix")));
		if (request.getParameter("suffix") != null)
			map.put("suffix",
					HMSUtil.restrictMetaChar(request.getParameter("suffix")));

		map.put("serviceNo", serviceNo);
		map.put("serviceTypeId", serviceTypeId);
		if (request.getParameter("echs") != null) {
			map.put("echs",
					HMSUtil.restrictMetaChar(request.getParameter("echs")));
		}
		String jsp = "";
		System.out.println("---------=========================-----------------------");
		jsp = "responseForVisitOfHALEmployees";
		/*
		 * if(type.equalsIgnoreCase("registration")){ }else
		 * if(type.equalsIgnoreCase("medicalExam")){ jsp =
		 * "responseForSPNameMedExam"; }
		 */
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showRegistrationCardReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = REGISTRATION_CARD_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showSickReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = registrationHandlerService.getDetailsForReport(hospitalId);
		String jsp = SICK_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showSickReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date date = null;
		if (request.getParameter(DATE) != null) {
			date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE));
		}
		if (request.getParameter(UNIT_ID) != null
				&& !request.getParameter(UNIT_ID).equals("")) {
			parameters.put("unitId",
					Integer.parseInt(request.getParameter(UNIT_ID)));
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !request.getParameter(SERVICE_NO).equals("")) {
			parameters.put("serviceNo",
					" and service_no ='" + request.getParameter(SERVICE_NO)
							+ "'");
		}
		detailsMap = registrationHandlerService.getConnectionForReport();
		parameters.put("date", date);
		// try {
		// byte bytes[] = null;
		// try
		// {
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("sick_report"),parameters,(Connection)detailsMap.get("conn"));
		// HMSUtil.generateReport("sick_report", parameters,
		// (Connection)detailsMap.get("conn"), response, getServletContext());
		// }
		// catch(JRException e)
		// {
		// e.printStackTrace();
		// }
		//
		// //response.setHeader("Content-Disposition",
		// "attachment; filename=RegistrationCard.pdf");
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		// // HMSUtil.generateReport("RegistrationCard", parameters,
		// (Connection)detailsMap.get("conn"), response, getServletContext());
		// } catch (IllegalStateException e) {
		// e.printStackTrace();
		// }
		HMSUtil.generateReport("sick_report", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showOPDRegisterReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (request.getParameter("hospitalId") != null
				&& !request.getParameter("hospitalId").equals("0")) {
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		} else {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		map = registrationHandlerService.getDetailsForReport(hospitalId);
		jsp = OPD_REGISTER_REPORT_JSP + ".jsp";
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOPDRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		Box box = null;
		if (session.getAttribute("box") != null) {
			box = (Box) session.getAttribute("box");
		} else {
			box = HMSUtil.getBox(request);
		}

		String qry = "";
		if (request.getParameter("cmdId") != null
				&& !request.getParameter("cmdId").equals("")
				&& !request.getParameter("cmdId").equals("0")
				&& request.getParameter("hospitalId") != null
				&& request.getParameter("hospitalId").equals("0")
				&& request.getParameter("hospitalId").equals("")) {

			qry += "  and hospital.command_id="
					+ Integer.parseInt(request.getParameter("cmdId"));
		} else {
			if (request.getParameter("hospitalId") != null
					&& !request.getParameter("hospitalId").equals("")
					&& !request.getParameter("hospitalId").equals("0")) {
				hospitalId = Integer.parseInt(request
						.getParameter("hospitalId"));
			} else {
				hospitalId = (Integer) session.getAttribute("hospitalId");
			}
			qry += "  and visit.hospital_id=" + hospitalId;
		}
		if (!box.getString(FROM_DATE).equals("")) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(box
					.getString(FROM_DATE));
		}

		if (!box.getString(TO_DATE).equals("")) {
			toDate = HMSUtil.convertStringTypeDateToDateType(box
					.getString(TO_DATE));
		}
/*
		if (box.getInt(SERVICE_TYPE_ID) != 0) {
			qry += " and patient.service_type_id = "
					+ box.getInt(SERVICE_TYPE_ID) + "";
		}
		if (box.getInt(SERVICE_STATUS_ID) != 0) {
			qry += " and patient.service_status_id = "
					+ box.getInt(SERVICE_STATUS_ID) + "";
		}*/
		/*if (box.getInt("fromRankId") != 0 && box.getInt("toRankId") != 0) {
			qry += " and patient.rank_id between " + box.getInt("fromRankId")
					+ " and " + box.getInt("toRankId");
		}*/
		if (box.getInt(DEPARTMENT_ID) != 0) {
			qry += " and dep.department_id = "
					+ box.getInt(DEPARTMENT_ID) + "";
		}
		if (box.getInt("divisionId") != 0) {
			qry += " and d.division_id = " + box.getInt("divisionId") + "";
		}
		if (box.getInt(UNIT_ID) != 0) {
			qry += " and patient.unit_id = " + box.getInt(UNIT_ID) + "";
		}
		if (box.getInt(SECTION_ID) != 0) {
			qry += " and patient.section_id = " + box.getInt(SECTION_ID) + "";
		}
	/*	if (box.getInt(MARITAL_STATUS_ID) != 0) {
			qry += " and patient.marital_status_id = "
					+ box.getInt(MARITAL_STATUS_ID) + "";
		}*/
		if (box.getInt(SEX_ID) != 0) {
			qry += " and patient.sex_id = " + box.getInt(SEX_ID) + "";
		}
		if (!box.getString(RELATION_ID).equals("")) {
			qry += " and mas_relation.relation_code = '" + box.getString(RELATION_ID) + "'";
		}
		if (!(box.getString(SERVICE_NO).equals(""))) {
			qry += " and patient.service_no='"
					+ HMSUtil.restrictMetaChar(box.getString(SERVICE_NO)) + "'";
		}
		if (!(box.getString("fromAge").equals(""))
				&& !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals(""))
				&& !(box.getString("toAgeUnit").equals(""))) {
			String fromAge = box.getString("fromAge");
			String toAge = box.getString("toAge");
			qry += " and substr(patient.age,0,INSTR(patient.age,' ')) >="
					+ fromAge
					+ " "
					+ " and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"
					+ box.getString("fromAgeUnit")
					+ "'"
					+ " and substr(patient.age,0,INSTR(patient.age,' ')) <="
					+ toAge
					+ " "
					+ " and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"
					+ box.getString("toAgeUnit") + "'";

		}
		/*if (!(box.getString("fromServ").equals(""))
				&& !(box.getString("fromServUnit").equals(""))
				&& !(box.getString("toServ").equals(""))
				&& !(box.getString("toServUnit").equals(""))) {
			String fromServ = box.getString("fromServ");
			String toServ = box.getString("toServ");
			qry += " and patient.service_years >=" + fromServ + " "
					+ " and  total_service_period='"
					+ box.getString("fromServUnit") + "'"
					+ " and patient.service_years <=" + toServ + " "
					+ " and  total_service_period='"
					+ box.getString("toServUnit") + "'";

		}
*/		if (box.getInt(CONSULTING_DOCTOR) != 0) {
			qry += " and visit.doctor_id = " + box.getInt(CONSULTING_DOCTOR)
					+ "";
		}
		if (!(box.getString("icd").equals(""))) {
			String icd = box.getString("icd");
			int index1 = icd.lastIndexOf("[");
			int index2 = icd.lastIndexOf("]");
			index1++;
			int icdCode = Integer.parseInt("" + icd.substring(index1, index2));
			qry += " and icd.icd_id=" + icdCode + "";
		}
		if ((box.getInt("icdId") != 0)) {
			qry += " and icd.icd_id=" + box.getInt("icdId") + "";
		}

/*		if (!(box.getString("disposal").equals(""))) {
			qry += " and opd.disposal = '"
					+ HMSUtil.restrictMetaChar(box.getString("disposal")) + "'";
		}
*/		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        parameters.put("path", imagePath);
        
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		parameters.put("hospitalId", hospitalId);
		HMSUtil.generateReport("OPD_STATISTICS", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showOPDRegisterOnScreen(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (request.getParameter("hospitalId") != null
				&& !request.getParameter("hospitalId").equals("0")) {
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		} else {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.getOPDRegisterData(box);
		String jsp = "opdRegister.jsp";
		map.put("contentJsp", jsp);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------------------- Common Method For iReport
	 * ----------------------------
	 */

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	/**
	 * --------------------------------------------------------------
	 */

	public RegistrationHandlerService getRegistrationHandlerService() {
		return registrationHandlerService;
	}

	public void setRegistrationHandlerService(
			RegistrationHandlerService registrationHandlerService) {
		this.registrationHandlerService = registrationHandlerService;
	}

	// -------------At Bangalore-------------

	public ModelAndView getEchsNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = ECHS_NO_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public void populatePatientDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Box box = HMSUtil.getBox(request);
		int serviceTypeId = 0;
		String serviceNo = "";

		@SuppressWarnings("unused")
		String address = "";

		serviceTypeId = box.getInt("serviceTypeId");
		serviceNo = box.get("serviceNo");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("serviceTypeId", serviceTypeId);
		dataMap.put("serviceNo", serviceNo);
		detailsMap = registrationHandlerService.populatePatientDetails(dataMap);
		List<Patient> patientList = new ArrayList<Patient>();
		patientList = (List<Patient>) detailsMap.get("patientList");

		// ------------Response------------------

		StringBuffer sb = new StringBuffer();

		for (Patient patient : patientList) {
			sb.append("<item>");
			if (patient.getAddress() != null
					&& !patient.getAddress().equals("")) {
				sb.append("<address>" + patient.getAddress() + "</address>");
			} else {
				sb.append("<address>" + "" + "</address>");
			}
			if (patient.getBlock() != null)
				sb.append("<blockId>" + patient.getBlock().getId()
						+ "</blockId>");
			else
				sb.append("<blockId>" + "0" + "</blockId>");
			if (patient.getState() != null) {
				sb.append("<stateId>" + patient.getState().getId()
						+ "</stateId>");
			} else {
				sb.append("<stateId>" + "0" + "</stateId>");
			}
			if (patient.getDistrict() != null) {
				sb.append("<cityId>" + patient.getDistrict().getId()
						+ "</cityId>");
			} else {
				sb.append("<cityId>" + "0" + "</cityId>");
			}
			if (patient.getCountry() != null) {
				sb.append("<countryId>" + patient.getCountry().getId()
						+ "</countryId>");
			} else {
				sb.append("<countryId>" + "0" + "</countryId>");
			}
			if (patient.getReligion() != null) {
				sb.append("<religionId>" + patient.getReligion().getId()
						+ "</religionId>");
			} else {
				sb.append("<religionId>" + "0" + "</religionId>");
			}
			if (patient.getPinCode() != null
					&& !patient.getPinCode().equals("")) {
				sb.append("<pinCode>" + patient.getPinCode() + "</pinCode>");
			} else {
				sb.append("<pinCode>" + "0" + "</pinCode>");
			}
			sb.append("<patientDistrict>" + patient.getPatientDistrict()
					+ "</patientDistrict>");

			if (patient.getPostOffice() != null
					&& !patient.getPostOffice().equals("")) {
				sb.append("<postOff>" + patient.getPostOffice() + "</postOff>");
			} else {
				sb.append("<postOff>" + "" + "</postOff>");
			}
			if (patient.getPoliceStation() != null
					&& !patient.getPoliceStation().equals("")) {
				sb.append("<policeStation>" + patient.getPoliceStation()
						+ "</policeStation>");
			} else {
				sb.append("<policeStation>" + "" + "</policeStation>");
			}
			if (patient.getPhoneNumber() != null
					&& !patient.getPhoneNumber().equals("")) {
				sb.append("<phoneNo>" + patient.getPhoneNumber() + "</phoneNo>");
			} else {
				sb.append("<phoneNo>" + "" + "</phoneNo>");
			}
			if (patient.getMobileNumber() != null
					&& !patient.getMobileNumber().equals("")) {
				sb.append("<mobileNo>" + patient.getMobileNumber()
						+ "</mobileNo>");
			} else {
				sb.append("<mobileNo>" + "" + "</mobileNo>");
			}
			sb.append("</item>");
		}

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	public void populatePatientDetailsHAL(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Box box = HMSUtil.getBox(request);
		int serviceTypeId = 0;
		String serviceNo = "";

		@SuppressWarnings("unused")
		String address = "";

		serviceTypeId = box.getInt("serviceTypeId");
		serviceNo = box.get("serviceNo");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("serviceTypeId", serviceTypeId);
		dataMap.put("serviceNo", serviceNo);
		detailsMap = registrationHandlerService
				.populatePatientDetailsHAL(dataMap);
		List<Patient> patientList = new ArrayList<Patient>();
		patientList = (List<Patient>) detailsMap.get("patientList");

		// ------------Response------------------

		StringBuffer sb = new StringBuffer();

		for (Patient patient : patientList) {
			sb.append("<item>");
			if (patient.getAddress() != null
					&& !patient.getAddress().equals("")) {
				sb.append("<address>" + patient.getAddress() + "</address>");
			} else {
				sb.append("<address>" + "" + "</address>");
			}
			if (patient.getBlock() != null)
				sb.append("<blockId>" + patient.getBlock().getId()
						+ "</blockId>");
			else
				sb.append("<blockId>" + "0" + "</blockId>");
			if (patient.getState() != null) {
				sb.append("<stateId>" + patient.getState().getId()
						+ "</stateId>");
			} else {
				sb.append("<stateId>" + "0" + "</stateId>");
			}
			if (patient.getDistrict() != null) {
				sb.append("<cityId>" + patient.getDistrict().getId()
						+ "</cityId>");
			} else {
				sb.append("<cityId>" + "0" + "</cityId>");
			}
			if (patient.getCountry() != null) {
				sb.append("<countryId>" + patient.getCountry().getId()
						+ "</countryId>");
			} else {
				sb.append("<countryId>" + "0" + "</countryId>");
			}
			if (patient.getReligion() != null) {
				sb.append("<religionId>" + patient.getReligion().getId()
						+ "</religionId>");
			} else {
				sb.append("<religionId>" + "0" + "</religionId>");
			}
			if (patient.getPinCode() != null
					&& !patient.getPinCode().equals("")) {
				sb.append("<pinCode>" + patient.getPinCode() + "</pinCode>");
			} else {
				sb.append("<pinCode>" + "0" + "</pinCode>");
			}
			sb.append("<patientDistrict>" + patient.getPatientDistrict()
					+ "</patientDistrict>");

			if (patient.getPostOffice() != null
					&& !patient.getPostOffice().equals("")) {
				sb.append("<postOff>" + patient.getPostOffice() + "</postOff>");
			} else {
				sb.append("<postOff>" + "" + "</postOff>");
			}
			if (patient.getPoliceStation() != null
					&& !patient.getPoliceStation().equals("")) {
				sb.append("<policeStation>" + patient.getPoliceStation()
						+ "</policeStation>");
			} else {
				sb.append("<policeStation>" + "" + "</policeStation>");
			}
			if (patient.getPhoneNumber() != null
					&& !patient.getPhoneNumber().equals("")) {
				sb.append("<phoneNo>" + patient.getPhoneNumber() + "</phoneNo>");
			} else {
				sb.append("<phoneNo>" + "" + "</phoneNo>");
			}
			if (patient.getMobileNumber() != null
					&& !patient.getMobileNumber().equals("")) {
				sb.append("<mobileNo>" + patient.getMobileNumber()
						+ "</mobileNo>");
			} else {
				sb.append("<mobileNo>" + "" + "</mobileNo>");
			}
			sb.append("</item>");
		}

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	public ModelAndView getAdmissionNoList(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";

		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}

		List<Object> inpatientList = new ArrayList<Object>();
		map = registrationHandlerService.getAdmissionNoList(detailsMap);
		if (map.get("inpatientList") != null) {
			inpatientList = (List<Object>) map.get("inpatientList");
		}
		map.put("inpatientList", inpatientList);
		String jsp = "responseForUpdateAdmin";
		return new ModelAndView(jsp, "map", map);

	}

	public synchronized void generateServiveNo(HttpServletRequest request,
			HttpServletResponse response) {
		String serviceNo = "no";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String currentTime = (String) utilMap.get("currentTimeWithoutSc");

		try {

			serviceNo = currentDate.substring(0, currentDate.indexOf("/"))
					+ currentDate.substring(currentDate.indexOf("/") + 1,
							currentDate.lastIndexOf("/"))
					+ currentDate.substring(currentDate.lastIndexOf("/") + 3,
							currentDate.length())
					+ currentTime.substring(0, currentTime.indexOf(":"))
					+ currentTime.substring(currentTime.indexOf(":") + 1,
							currentTime.lastIndexOf(":"))
					+ currentTime.substring(currentTime.lastIndexOf(":") + 1,
							currentTime.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<serviceNo>" + serviceNo + "</serviceNo>");
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

	}

	public ModelAndView checkPatientVisit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> patientVisitList = new ArrayList<Visit>();

		Box box = HMSUtil.getBox(request);

		patientVisitList = registrationHandlerService.checkPatientVisit(box);

		String jsp = "responsePatientVisit";
		map.put("patientVisitList", patientVisitList);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getConsulationRoom(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String consultationRoom = "";
		int consultingDoctor = 0;
		if (request.getParameter(CONSULTING_DOCTOR) != null
				&& !(request.getParameter(CONSULTING_DOCTOR).equals(""))) {
			consultingDoctor = Integer.parseInt(request
					.getParameter(CONSULTING_DOCTOR));
		}

		consultationRoom = registrationHandlerService
				.getConsulationRoom(consultingDoctor);

		String jsp = "responseConsultationRoom";
		map.put("consultationRoom", consultationRoom);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getAppointmentTypeNoneList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		map = registrationHandlerService.getAppointmentTypeNoneList(mapForDs);

		String jsp = "appointmentTypeNoneList";
		return new ModelAndView(jsp, "map", map);
	}

	// ------------------------------Consent Report by Vishal
	// --------------------------
	public ModelAndView showConsentReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = CONSENT_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printConsentReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String hinNo = "";

		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}

		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		Map<String, Object> map = new HashMap<String, Object>();
		dataMap.put("hinNo", hinNo);
		parameters.put("hinNo", hinNo);

		HMSUtil.generateReport("consentForm", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return new ModelAndView("index");
	}

	// ----Merge by dipali 1/jul/2010--

	public ModelAndView displayRegisPhoto(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		String serviceNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		map = registrationHandlerService.displayRegisPhoto(hinNo);
		String jsp = REG_PHOTO_POPUP_JSP;
		map.put("serviceNo", serviceNo);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addPhotoFile(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;
		HttpSession session = request.getSession();

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String fileExtension = null;
		// String uploadURL = getServletContext().getRealPath("/photo/");
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		// String uploadURL =
		// userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"HMS"+fileSeparator+"photo"+fileSeparator;
		String uploadURL = userHome.substring(0,
				userHome.lastIndexOf(fileSeparator))
				+ fileSeparator + "photo" + fileSeparator;
		String filename = "";
		String hinNo = "";
		int hospitalId = 0;
		int hinId = 0;
		String userName = "";
		String age = "";
		String gender = "";
		String addrress = "";
		String serviceNo = "";
		List fileUploadedList = null;

		if (request.getParameter("filename") != null) {
			filename = request.getParameter("filename");
		}
		if (mrequest.getParameter(HIN_NO) != null) {
			hinNo = mrequest.getParameter(HIN_NO);
			generalMap.put("hinNo", hinNo);
		}
		if (mrequest.getParameter("serviceNo") != null) {
			serviceNo = mrequest.getParameter("serviceNo");
			generalMap.put("serviceNo", serviceNo);
		}
		if (mrequest.getParameter("age") != null) {
			age = mrequest.getParameter("age");
			generalMap.put("age", age);
		}
		if (mrequest.getParameter("addrress") != null) {
			age = mrequest.getParameter("addrress");
			generalMap.put("addrress", addrress);
		}
		if (mrequest.getParameter("gender") != null) {
			gender = mrequest.getParameter("gender");
			generalMap.put("gender", gender);
		}
		if (mrequest.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(mrequest.getParameter(HIN_ID));
			generalMap.put("hinId", hinId);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			generalMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			generalMap.put("userName", userName);
		}

		StringTokenizer strToken = new StringTokenizer(filename, ".");
		filename = strToken.nextToken();
		fileExtension = strToken.nextToken();

		String whiteList = "*." + fileExtension;
		filename = hinNo + "." + fileExtension;
		// filename = serviceNo+"."+fileExtension;

		generalMap.put("filename", filename);
		try {
			fileUploadedList = HMSUtil.uploadTicketFile(mrequest, uploadURL,
					whiteList, filename);
		} catch (Exception e) {
			e.printStackTrace();
		}

		generalMap.put("uploadURL", uploadURL);
		boolean fileUploaded = false;
		if (fileUploadedList != null && fileUploadedList.size() != 0) {
			fileUploaded = (Boolean) fileUploadedList.get(0);
		}
		generalMap.put("extension", fileExtension);
		// map = registrationHandlerService.addPhotoFile(generalMap);
		map = registrationHandlerService.updatePatientImage(generalMap);
		String jsp = REG_PHOTO_POPUP_JSP;
		// jsp += ".jsp";
		map.put("filename", filename);
		map.put("hinNo", hinNo);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * public ModelAndView getHinNoForUpdateVisit(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); Map<String, Object> detailsMap = new
	 * HashMap<String, Object>(); String serviceNo = ""; String hinNo = "";
	 * String flag = ""; if (request.getParameter(SERVICE_NO) != null &&
	 * !(request.getParameter(SERVICE_NO).equals(""))) { serviceNo =
	 * request.getParameter(SERVICE_NO); detailsMap.put("serviceNo", serviceNo);
	 * } if (request.getParameter(HIN_NO) != null &&
	 * !(request.getParameter(HIN_NO).equals(""))) { hinNo =
	 * request.getParameter(HIN_NO); detailsMap.put("hinNo", hinNo); } if
	 * (request.getParameter("flag") != null &&
	 * !(request.getParameter("flag").equals(""))) { flag =
	 * request.getParameter("flag"); map.put("flag", flag); }
	 * 
	 * List<Object> hinNoList = new ArrayList<Object>(); hinNoList =
	 * registrationHandlerService.getHinNoList(serviceNo); map.put("hinNoList",
	 * hinNoList); String jsp = "populateHinNoForOpd"; return new
	 * ModelAndView(jsp, "map", map); }
	 */

	/**
	 * Added By Ritu on 15 Feb 2011
	 */

	public ModelAndView showAircraftEmergencyJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = registrationHandlerService.showAircraftEmergencyJsp(hospitalId);
		String jsp = "aircraftEmergency.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showRegistrationJspHAL(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.showRegistrationJspOtherPatient(hospitalId);
		String jsp = "registrationHAL.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView updateOtherPatientInformationJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.showRegistrationJspOtherPatient(hospitalId);
		String jsp = "updateOtherPatientInformationJsp.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEmployeeVisitJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.showRegistrationJsp(hospitalId);
		String jsp = "visitOfHALEmployees.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showEmployeeVisitJspByAdmin(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.showRegistrationJsp(hospitalId);
		String jsp = "visitOfHALEmployeesByAdmin.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOtherVisitJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.showOtherVisitJsp(hospitalId);
		String jsp = "visitOfOtherPatients.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOnlineVisitJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.showRegistrationJsp(hospitalId);
		String jsp = "visitOfOnlineEmployees.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveAirCraftEmergencyDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}

		int hdb = 0;
		if (request.getParameter("hdb") != null) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		List<String> serviceNoList = new ArrayList<String>();
		List<Integer> rankList = new ArrayList<Integer>();
		List<Integer> hinList = new ArrayList<Integer>();
		List<String> nameList = new ArrayList<String>();
		List<String> ageList = new ArrayList<String>();
		List<Integer> pilotList = new ArrayList<Integer>();

		int j = 1;
		for (int i = 0; i < hdb; i++) {
			String serviceNo = "";
			if (request.getParameter("serviceNo" + j) != null
					&& !request.getParameter("serviceNo" + j).equals("")) {
				serviceNo = request.getParameter("serviceNo" + j);
				serviceNoList.add(serviceNo);
			}
			int rankId = 0;
			if (request.getParameter("rankId" + j) != null
					&& !request.getParameter("rankId" + j).equals("0")) {
				rankId = Integer.parseInt(request.getParameter("rankId" + j));
				rankList.add(rankId);
			} else {
				rankList.add(0);
			}
			int pilotId = 0;

			if (request.getParameter("pilotId" + j) != null
					&& !request.getParameter("pilotId" + j).equals("0")) {

				pilotId = Integer.parseInt(request.getParameter("pilotId" + j));
				pilotList.add(pilotId);

			} else {
				pilotList.add(0);

			}
			int hinId = 0;

			if (request.getParameter("hinId" + j) != null
					&& !request.getParameter("hinId" + j).equals("0")) {
				hinId = Integer.parseInt(request.getParameter("hinId" + j));
				hinList.add(hinId);
			} else {
				hinList.add(0);
			}

			if (request.getParameter("age" + j) != null
					&& !request.getParameter("age" + j).equals("")) {
				ageList.add(request.getParameter("age" + j));
			} else {
				ageList.add("");
			}

			String name = "";
			if (request.getParameter("sName" + j) != null
					&& !request.getParameter("sName" + j).equals("")) {
				name = request.getParameter("sName" + j);
				nameList.add(name);
			} else {
				nameList.add("");
			}
			j++;
		}
		infoMap.put("nameList", nameList);
		infoMap.put("hinList", hinList);
		infoMap.put("pilotList", pilotList);
		infoMap.put("rankList", rankList);
		infoMap.put("nameList", nameList);
		infoMap.put("serviceNoList", serviceNoList);
		infoMap.put("ageList", ageList);

		map = registrationHandlerService.saveAirCraftEmergencyDetails(box,
				infoMap);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully.";
		} else {
			message = "Try Again.";
		}
		map.put("message", message);
		String jsp = "aircraftEmergency.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEmergencyPerformaJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = registrationHandlerService.showAircraftEmergencyJsp(hospitalId);
		String jsp = "emergencyPerforma.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveEmergencyPerformaDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = registrationHandlerService.saveEmergencyPerformaDetails(box);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully.";
		} else {
			message = "Try Again.";
		}
		map.put("message", message);
		String jsp = "emergencyPerforma.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showMHReferralRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showMHReferralRegisterJsp(box);
		String jsp = "mhReferral.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPatientDetailsForServiceNo(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.showPatientDetailsForServiceNo(box);
		String jsp = "mhReferralPatientPopup";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView saveMHReferralRegisterDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = registrationHandlerService.saveMHReferralRegisterDetails(box);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully.";
		} else {
			message = "Try Again.";
		}
		map.put("message", message);
		String jsp = "mhReferral.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getMhReferralDetailsForEdit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		map = registrationHandlerService.getMhReferralDetailsForEdit(box);

		return new ModelAndView("responseForMhReferral", "map", map);
	}

	public ModelAndView updateMHReferralRegisterDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = registrationHandlerService.updateMHReferralRegisterDetails(box);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Updated Successfully.";
		} else {
			message = "Try Again.";
		}
		map.put("message", message);
		String jsp = "mhReferral.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getServiceNoDetailsForReg(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.getServiceNoDetailsForReg(box);

		return new ModelAndView("responseForSrNoDetails", "map", map);
	}
	
	public ModelAndView getServiceNoDetailsForRegHAL(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		map = registrationHandlerService.getServiceNoDetailsForRegHAL(box);

		return new ModelAndView("responseForSrNoDetailsHAL", "map", map);
	}

	
	public ModelAndView getServiceNoDetailsForFAC(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		map = registrationHandlerService.getServiceNoDetailsForRegHAL(box);

		return new ModelAndView("responseForSrNoDetailsHALForFAC", "map", map);
	}
	
	public void getPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.getServPersonPatientDetails(box);
		List<Integer> relationIdList = new ArrayList<Integer>();

		String message = "";
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		int hinId = 0;
		if (map.get("hinId") != null) {
			hinId = (Integer) map.get("hinId");
		}
		if (map.get("relationIdList") != null) {
			relationIdList = (List<Integer>) map.get("relationIdList");
		}
		StringBuffer sb = new StringBuffer();
		int cnt = box.getInt("cnt");

		sb.append("<item>");
		sb.append("<depname>" + box.getString("depnName" + cnt) + "</depname>");
		sb.append("<dob>" + box.getString("depDob" + cnt) + "</dob>");
		if (relationIdList.size() > 0) {
			sb.append("<relation>" + (Integer) relationIdList.get(0)
					+ "</relation>");

		} else {
			sb.append("<relation>" + "" + "</relation>");
		}
		sb.append("<gender>" + box.getInt("depSex" + cnt) + "</gender>");
		sb.append("<depAge>" + box.getInt("depage" + cnt) + "</depAge>");
		sb.append("<authority>" + box.getString("authority" + cnt)
				+ "</authority>");
		sb.append("<depDate>" + box.getString("dependencyDate" + cnt)
				+ "</depDate>");
		sb.append("<occupation>" + box.getString("occupation" + cnt)
				+ "</occupation>");
		sb.append("<income>" + box.getString("income" + cnt) + "</income>");
		if (!message.equals("")) {
			sb.append("<message>" + message + "</message>");
		}
		if (hinId != 0) {
			sb.append("<hinId>" + hinId + "</hinId>");
		}
		sb.append("</item>");

		// if(detailsList.size() > 0){
		// for (MasEmployeeDependent empDependent : detailsList) {
		/*
		 * sb.append("<item>"); if (empDependent.getEmployeeDependentName() !=
		 * null) { sb.append("<depname>" +
		 * empDependent.getEmployeeDependentName() + "</depname>"); } else {
		 * sb.append("<depname>" + "" + "</depname>"); } if
		 * (empDependent.getDateOfBirth() != null) sb.append("<dob>"
		 * +HMSUtil.convertDateToStringWithoutTime
		 * (empDependent.getDateOfBirth())+ "</dob>"); else sb.append("<dob>" +
		 * "" + "</dob>");
		 * 
		 * sb.append("<empFName>" +empDependent.getEmployee().getFirstName() +
		 * "</empFName>"); if(empDependent.getEmployee().getMiddleName() !=
		 * null) sb.append("<empMName>" +
		 * empDependent.getEmployee().getMiddleName() + "</empMName>"); else
		 * sb.append("<empMName>" + "" + "</empMName>");
		 * 
		 * if(empDependent.getEmployee().getLastName() != null)
		 * sb.append("<empLName>" + empDependent.getEmployee().getLastName() +
		 * "</empLName>"); else sb.append("<empLName>" + "" + "</empLName>");
		 * 
		 * if(empDependent.getRelation() != null) sb.append("<relation>" +
		 * empDependent.getRelation().getId() + "</relation>"); else
		 * sb.append("<relation>" + "0" + "</relation>");
		 * 
		 * if(empDependent.getEmployee().getRank() != null) sb.append("<rank>" +
		 * empDependent.getEmployee().getRank().getId() + "</rank>"); else
		 * sb.append("<rank>" + "0" + "</rank>");
		 * 
		 * if(empDependent.getEmployee().getUnit() != null) sb.append("<unit>" +
		 * empDependent.getEmployee().getUnit().getId() + "</unit>"); else
		 * sb.append("<unit>" + "0" + "</getUnit>");
		 * 
		 * if(empDependent.getAddress() != null) sb.append("<address>" +
		 * empDependent.getAddress() + "</address>"); else sb.append("<address>"
		 * + "" + "</address>"); if(empDependent.getGender() != null)
		 * sb.append("<gender>" + empDependent.getGender() + "</gender>"); else
		 * sb.append("<gender>" + "0" + "</gender>");
		 * 
		 * if(!message.equals("")){ sb.append("<message>" + message +
		 * "</message>"); } if(hinId != 0){ sb.append("<hinId>" + hinId +
		 * "</hinId>"); } sb.append("</item>");
		 */

		// }
		// }
		/*
		 * else if(!message.equals("")){ sb.append("<item>");
		 * sb.append("<message>" + message + "</message>");
		 * sb.append("</item>"); }
		 */
		try {
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ModelAndView displaySrPhoto(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.getSrPhoto(box);

		return new ModelAndView("responseForSrPhoto", "map", map);
	}

	public void displayPatientInfo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.getPatientInfoForVisit(box);
		List<Patient> patientList = new ArrayList<Patient>();

		if (map.get("patientList") != null) {
			patientList = (List<Patient>) map.get("patientList");
		}
		StringBuffer sb = new StringBuffer();
		if (patientList.size() > 0) {
			for (Patient patient : patientList) {
				Set<MasMedicalExamFamilyHis> familyHisSet = new HashSet<MasMedicalExamFamilyHis>();
				sb.append("<item>");
				if (patient.getTitle() != null) {
					sb.append("<title>" + patient.getTitle().getId()
							+ "</title>");
				} else {
					sb.append("<title>" + "0" + "</title>");
				}
				sb.append("<fName>" + patient.getPFirstName() + "</fName>");
				if (patient.getPMiddleName() != null) {
					sb.append("<mName>" + patient.getPMiddleName() + "</mName>");
				} else {
					sb.append("<mName>" + "" + "</mName>");
				}
				if (patient.getPLastName() != null) {
					sb.append("<lastName>" + patient.getPLastName()
							+ "</lastName>");
				} else {
					sb.append("<lastName>" + "" + "</lastName>");
				}
				if (patient.getSex() != null) {
					sb.append("<sex>" + patient.getSex().getId() + "</sex>");
				} else {
					sb.append("<sex>" + "0" + "</sex>");
				}
				if (patient.getDateOfBirth() != null) {
					sb.append("<dob>"
							+ HMSUtil.convertDateToStringWithoutTime(patient
									.getDateOfBirth()) + "</dob>");
				} else {
					sb.append("<dob>" + "" + "</dob>");
				}
				if (patient.getAge() != null) {
					String age = patient.getAge().substring(0,
							patient.getAge().indexOf(" "));
					String ageunit = patient.getAge().substring(
							patient.getAge().indexOf(" ") + 1);
					sb.append("<age>" + age + "</age>");
					sb.append("<ageunit>" + ageunit + "</ageunit>");
				} else {
					sb.append("<age>" + "" + "</age>");
					sb.append("<ageunit>" + "" + "</ageunit>");
				}
				if (patient.getOccupation() != null) {
					sb.append("<occu>" + patient.getOccupation().getId()
							+ "</occu>");
				} else {
					sb.append("<occu>" + "0" + "</occu>");
				}
				if (patient.getMaritalStatus() != null) {
					sb.append("<mrstatus>" + patient.getMaritalStatus().getId()
							+ "</mrstatus>");
				} else {
					sb.append("<mrstatus>" + "0" + "</mrstatus>");
				}
				if (patient.getRelation() != null) {
					sb.append("<relation>" + patient.getRelation().getId()
							+ "</relation>");
				} else {
					sb.append("<relation>" + "0" + "</relation>");
				}
				if (patient.getBloodGroup() != null) {
					sb.append("<bldGrp>" + patient.getBloodGroup().getId()
							+ "</bldGrp>");
				} else {
					sb.append("<bldGrp>" + "0" + "</bldGrp>");
				}
				if (patient.getAddress() != null) {
					sb.append("<add>" + patient.getAddress() + "</add>");
				} else {
					sb.append("<add>" + "" + "</add>");
				}
				if (patient.getDistrict() != null) {
					sb.append("<district>" + patient.getDistrict().getId()
							+ "</district>");
				} else {
					sb.append("<district>" + "0" + "</district>");
				}
				if (patient.getState() != null) {
					sb.append("<state>" + patient.getState().getId()
							+ "</state>");
				} else {
					sb.append("<state>" + "0" + "</state>");
				}
				if (patient.getContactNo() != null) {
					sb.append("<contactNo>" + patient.getContactNo()
							+ "</contactNo>");
				} else {
					sb.append("<contactNo>" + "" + "</contactNo>");
				}
				if (patient.getMobileNumber() != null) {
					sb.append("<mobileNo>" + patient.getMobileNumber()
							+ "</mobileNo>");
				} else {
					sb.append("<mobileNo>" + "" + "</mobileNo>");
				}
				if (patient.getIncome() != null) {
					sb.append("<income>" + patient.getIncome() + "</income>");
				} else {
					sb.append("<income>" + "" + "</income>");
				}
				if (patient.getDependencyDate() != null) {
					sb.append("<depDate>"
							+ HMSUtil.convertDateToStringWithoutTime(patient
									.getDependencyDate()) + "</depDate>");
				} else {
					sb.append("<depDate>" + "" + "</depDate>");
				}
				if (patient.getAuthority() != null) {
					sb.append("<authority>" + patient.getAuthority()
							+ "</authority>");
				} else {
					sb.append("<authority>" + "" + "</authority>");
				}
				if (patient.getDependencyRemovalDate() != null) {
					sb.append("<depRemovalDate>"
							+ HMSUtil.convertDateToStringWithoutTime(patient
									.getDependencyRemovalDate())
							+ "</depRemovalDate>");
				} else {
					sb.append("<depRemovalDate>" + "" + "</depRemovalDate>");
				}
				if (patient.getPoliceStation() != null) {
					sb.append("<policeStation>" + patient.getPoliceStation()
							+ "</policeStation>");
				} else {
					sb.append("<policeStation>" + "" + "</policeStation>");
				}
				if (patient.getPinCode() != null) {
					sb.append("<pincode>" + patient.getPinCode() + "</pincode>");
				} else {
					sb.append("<pincode>" + "" + "</pincode>");
				}
				if (patient.getAlcohol() != null) {
					sb.append("<alcohol>" + patient.getAlcohol() + "</alcohol>");
				} else {
					sb.append("<alcohol>" + "" + "</alcohol>");
				}
				if (patient.getSmokerLess10() != null) {
					sb.append("<smokerLess10>" + patient.getSmokerLess10()
							+ "</smokerLess10>");
				} else {
					sb.append("<smokerLess10>" + "n" + "</smokerLess10>");
				}
				if (patient.getSmokerMore10() != null) {
					sb.append("<smokerMore10>" + patient.getSmokerMore10()
							+ "</smokerMore10>");
				} else {
					sb.append("<smokerMore10>" + "n" + "</smokerMore10>");
				}
				if (patient.getDrugAllergies() != null) {
					String str = patient.getDrugAllergies()
							.replace("\r\n", " ").replace("\n", " ");
					sb.append("<allergy>" + str + "</allergy>");
				} else {
					sb.append("<allergy>" + "" + "</allergy>");
				}
				int visitNo = 0;
				int lastVisitNo = 0;
				if (patient.getCurrentVisitNo() != null) {
					lastVisitNo = patient.getCurrentVisitNo();
				}
				visitNo = lastVisitNo + 1;
				sb.append("<visitNo>" + visitNo + "</visitNo>");
				sb.append("<hinNo>" + patient.getHinNo() + "</hinNo>");

				if (patient.getMasMedicalExamFamilyHis() != null) {
					familyHisSet = patient.getMasMedicalExamFamilyHis();
				}
				String famHisIds = "";
				int i = 0;
				for (MasMedicalExamFamilyHis meExamFamilyHis : familyHisSet) {
					if (i != 0) {
						famHisIds += ",";
					}
					famHisIds += meExamFamilyHis.getPatientFamilyHistory()
							.getId();
					i++;
				}
				sb.append("<famHisIds>" + famHisIds + "</famHisIds>");
				sb.append("<marriageDate>"
						+ (patient.getDepMarriageDate() != null ? HMSUtil
								.convertDateToStringWithoutTime(patient
										.getDepMarriageDate()) : "")
						+ "</marriageDate>");
				sb.append("<idMark1>"
						+ (patient.getDepIdentificationMark1() != null ? patient
								.getDepIdentificationMark1() : "")
						+ "</idMark1>");
				sb.append("<idMark2>"
						+ (patient.getDepIdentificationMark2() != null ? patient
								.getDepIdentificationMark2() : "")
						+ "</idMark2>");
				sb.append("<patientStatus>"
						+ (patient.getPatientStatus() != null ? patient
								.getPatientStatus() : "") + "</patientStatus>");

				sb.append("<nok1Name>"
						+ (patient.getNextOfKinName() != null ? patient
								.getNextOfKinName() : "") + "</nok1Name>");
				sb.append("<nok1Relation>"
						+ (patient.getNextOfKinRelation() != null ? patient
								.getNextOfKinRelation().getId() : "")
						+ "</nok1Relation>");
				sb.append("<nok1Contact>"
						+ (patient.getNextOfKinPhoneNumber() != null ? patient
								.getNextOfKinPhoneNumber() : "")
						+ "</nok1Contact>");
				sb.append("<nok1Address>"
						+ (patient.getNextOfKinAddress() != null ? patient
								.getNextOfKinAddress() : "") + "</nok1Address>");
				sb.append("<nok1PoliceStn>"
						+ (patient.getNok1PoliceStation() != null ? patient
								.getNok1PoliceStation() : "")
						+ "</nok1PoliceStn>");
				sb.append("<nok1PinCode>"
						+ (patient.getNok1PinCode() != null ? patient
								.getNok1PinCode() : "") + "</nok1PinCode>");
				sb.append("<nok2Name>"
						+ (patient.getNok2Name() != null ? patient
								.getNok2Name() : "") + "</nok2Name>");
				sb.append("<nok2Relation>"
						+ (patient.getNok2Relation() != null ? patient
								.getNok2Relation().getId() : "")
						+ "</nok2Relation>");
				sb.append("<nok2Contact>"
						+ (patient.getNok2ContactNo() != null ? patient
								.getNok2ContactNo() : "") + "</nok2Contact>");
				sb.append("<nok2Address>"
						+ (patient.getNok2Address() != null ? patient
								.getNok2Address() : "") + "</nok2Address>");
				sb.append("<nok2PoliceStn>"
						+ (patient.getNok2PoliceStation() != null ? patient
								.getNok2PoliceStation() : "")
						+ "</nok2PoliceStn>");
				sb.append("<nok2PinCode>"
						+ (patient.getNok2PinCode() != null ? patient
								.getNok2PinCode() : "") + "</nok2PinCode>");
				sb.append("</item>");
			}
		}
		try {
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void displayPatientInfoHAL(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		map = registrationHandlerService.getPatientInfoForVisitHAL(box);
		List<Patient> patientList = new ArrayList<Patient>();

		if (map.get("patientList") != null) {
			patientList = (List<Patient>) map.get("patientList");
		}
		StringBuffer sb = new StringBuffer();
		if (patientList.size() > 0) {
			for (Patient patient : patientList) {
				Set<MasMedicalExamFamilyHis> familyHisSet = new HashSet<MasMedicalExamFamilyHis>();
				sb.append("<item>");
				if (patient.getTitle() != null) {
					sb.append("<title>" + patient.getTitle().getId()
							+ "</title>");
				} else {
					sb.append("<title>" + "0" + "</title>");
				}
				sb.append("<fName>" + patient.getPFirstName() + "</fName>");
				if (patient.getPMiddleName() != null) {
					sb.append("<mName>" + patient.getPMiddleName() + "</mName>");
				} else {
					sb.append("<mName>" + "" + "</mName>");
				}
				if (patient.getPLastName() != null) {
					sb.append("<lastName>" + patient.getPLastName()
							+ "</lastName>");
				} else {
					sb.append("<lastName>" + "" + "</lastName>");
				}
				if (patient.getSex() != null) {
					sb.append("<sex>" + patient.getSex().getId() + "</sex>");
				} else {
					sb.append("<sex>" + "0" + "</sex>");
				}
				if (patient.getDateOfBirth() != null) {
					sb.append("<dob>"
							+ HMSUtil.convertDateToStringWithoutTime(patient
									.getDateOfBirth()) + "</dob>");
				} else {
					sb.append("<dob>" + "" + "</dob>");
				}
				if (patient.getAge() != null) {
					String age = patient.getAge().substring(0,
							patient.getAge().indexOf(" "));
					String ageunit = patient.getAge().substring(
							patient.getAge().indexOf(" ") + 1);
					sb.append("<age>" + age + "</age>");
					sb.append("<ageunit>" + ageunit + "</ageunit>");
				} else {
					sb.append("<age>" + "" + "</age>");
					sb.append("<ageunit>" + "" + "</ageunit>");
				}
				if (patient.getOccupation() != null) {
					sb.append("<occu>" + patient.getOccupation().getId()
							+ "</occu>");
				} else {
					sb.append("<occu>" + "0" + "</occu>");
				}
				if (patient.getMaritalStatus() != null) {
					sb.append("<mrstatus>" + patient.getMaritalStatus().getId()
							+ "</mrstatus>");
				} else {
					sb.append("<mrstatus>" + "0" + "</mrstatus>");
				}
				if (patient.getRelation() != null) {
					sb.append("<relation>" + patient.getRelation().getId()
							+ "</relation>");
				} else {
					sb.append("<relation>" + "0" + "</relation>");
				}
				if (patient.getBloodGroup() != null) {
					sb.append("<bldGrp>" + patient.getBloodGroup().getId()
							+ "</bldGrp>");
				} else {
					sb.append("<bldGrp>" + "0" + "</bldGrp>");
				}
				if (patient.getAddress() != null) {
					try {
						sb.append("<add>" + URLEncoder.encode(patient.getAddress(), "UTF-8") + "</add>");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					sb.append("<add>" + "" + "</add>");
				}
				if (patient.getDistrict() != null) {
					sb.append("<district>" + patient.getDistrict().getId()
							+ "</district>");
				} else {
					sb.append("<district>" + "0" + "</district>");
				}
				if (patient.getState() != null) {
					sb.append("<state>" + patient.getState().getId()
							+ "</state>");
				} else {
					sb.append("<state>" + "0" + "</state>");
				}
				if (patient.getContactNo() != null) {
					sb.append("<contactNo>" + patient.getContactNo()
							+ "</contactNo>");
				} else {
					sb.append("<contactNo>" + "" + "</contactNo>");
				}
				if (patient.getMobileNumber() != null) {
					sb.append("<mobileNo>" + patient.getMobileNumber()
							+ "</mobileNo>");
				} else {
					sb.append("<mobileNo>" + "" + "</mobileNo>");
				}
				if (patient.getIncome() != null) {
					sb.append("<income>" + patient.getIncome() + "</income>");
				} else {
					sb.append("<income>" + "" + "</income>");
				}
				if (patient.getDependencyDate() != null) {
					sb.append("<depDate>"
							+ HMSUtil.convertDateToStringWithoutTime(patient
									.getDependencyDate()) + "</depDate>");
				} else {
					sb.append("<depDate>" + "" + "</depDate>");
				}
				if (patient.getAuthority() != null) {
					sb.append("<authority>" + patient.getAuthority()
							+ "</authority>");
				} else {
					sb.append("<authority>" + "" + "</authority>");
				}
				if (patient.getDependencyRemovalDate() != null) {
					sb.append("<depRemovalDate>"
							+ HMSUtil.convertDateToStringWithoutTime(patient
									.getDependencyRemovalDate())
							+ "</depRemovalDate>");
				} else {
					sb.append("<depRemovalDate>" + "" + "</depRemovalDate>");
				}
				if (patient.getPoliceStation() != null) {
					sb.append("<policeStation>" + patient.getPoliceStation()
							+ "</policeStation>");
				} else {
					sb.append("<policeStation>" + "" + "</policeStation>");
				}
				if (patient.getPinCode() != null) {
					sb.append("<pincode>" + patient.getPinCode() + "</pincode>");
				} else {
					sb.append("<pincode>" + "" + "</pincode>");
				}
				if (patient.getAlcohol() != null) {
					sb.append("<alcohol>" + patient.getAlcohol() + "</alcohol>");
				} else {
					sb.append("<alcohol>" + "" + "</alcohol>");
				}
				if (patient.getSmokerLess10() != null) {
					sb.append("<smokerLess10>" + patient.getSmokerLess10()
							+ "</smokerLess10>");
				} else {
					sb.append("<smokerLess10>" + "n" + "</smokerLess10>");
				}
				if (patient.getSmokerMore10() != null) {
					sb.append("<smokerMore10>" + patient.getSmokerMore10()
							+ "</smokerMore10>");
				} else {
					sb.append("<smokerMore10>" + "n" + "</smokerMore10>");
				}
				if (patient.getDrugAllergies() != null) {
					String str = patient.getDrugAllergies()
							.replace("\r\n", " ").replace("\n", " ");
					sb.append("<allergy>" + str + "</allergy>");
				} else {
					sb.append("<allergy>" + "" + "</allergy>");
				}
				int visitNo = 0;
				int lastVisitNo = 0;
				if (patient.getCurrentVisitNo() != null) {
					lastVisitNo = patient.getCurrentVisitNo();
				}
				visitNo = lastVisitNo + 1;
				sb.append("<visitNo>" + visitNo + "</visitNo>");
				sb.append("<hinNo>" + patient.getHinNo() + "</hinNo>");

				if (patient.getMasMedicalExamFamilyHis() != null) {
					familyHisSet = patient.getMasMedicalExamFamilyHis();
				}
				String famHisIds = "";
				int i = 0;
				for (MasMedicalExamFamilyHis meExamFamilyHis : familyHisSet) {
					if (i != 0) {
						famHisIds += ",";
					}
					famHisIds += meExamFamilyHis.getPatientFamilyHistory()
							.getId();
					i++;
				}
				sb.append("<famHisIds>" + famHisIds + "</famHisIds>");
				sb.append("<marriageDate>"
						+ (patient.getDepMarriageDate() != null ? HMSUtil
								.convertDateToStringWithoutTime(patient
										.getDepMarriageDate()) : "")
						+ "</marriageDate>");
				sb.append("<idMark1>"
						+ (patient.getDepIdentificationMark1() != null ? patient
								.getDepIdentificationMark1() : "")
						+ "</idMark1>");
				sb.append("<idMark2>"
						+ (patient.getDepIdentificationMark2() != null ? patient
								.getDepIdentificationMark2() : "")
						+ "</idMark2>");
				sb.append("<patientStatus>"
						+ (patient.getPatientStatus() != null ? patient
								.getPatientStatus() : "") + "</patientStatus>");

				sb.append("<nok1Name>"
						+ (patient.getNextOfKinName() != null ? patient
								.getNextOfKinName() : "") + "</nok1Name>");
				sb.append("<nok1Relation>"
						+ (patient.getNextOfKinRelation() != null ? patient
								.getNextOfKinRelation().getId() : "")
						+ "</nok1Relation>");
				sb.append("<nok1Contact>"
						+ (patient.getNextOfKinPhoneNumber() != null ? patient
								.getNextOfKinPhoneNumber() : "")
						+ "</nok1Contact>");
				try {
					sb.append("<nok1Address>"
							+ (patient.getNextOfKinAddress() != null ? URLEncoder.encode(patient
									.getNextOfKinAddress(), "UTF-8") : "") + "</nok1Address>");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sb.append("<nok1PoliceStn>"
						+ (patient.getNok1PoliceStation() != null ? patient
								.getNok1PoliceStation() : "")
						+ "</nok1PoliceStn>");
				sb.append("<nok1PinCode>"
						+ (patient.getNok1PinCode() != null ? patient
								.getNok1PinCode() : "") + "</nok1PinCode>");
				sb.append("<nok2Name>"
						+ (patient.getNok2Name() != null ? patient
								.getNok2Name() : "") + "</nok2Name>");
				sb.append("<nok2Relation>"
						+ (patient.getNok2Relation() != null ? patient
								.getNok2Relation().getId() : "")
						+ "</nok2Relation>");
				sb.append("<nok2Contact>"
						+ (patient.getNok2ContactNo() != null ? patient
								.getNok2ContactNo() : "") + "</nok2Contact>");
				try {
					sb.append("<nok2Address>"
							+ (patient.getNok2Address() != null ? URLEncoder.encode(patient
									.getNok2Address(), "UTF-8") : "") + "</nok2Address>");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sb.append("<nok2PoliceStn>"
						+ (patient.getNok2PoliceStation() != null ? patient
								.getNok2PoliceStation() : "")
						+ "</nok2PoliceStn>");
				sb.append("<nok2PinCode>"
						+ (patient.getNok2PinCode() != null ? patient
								.getNok2PinCode() : "") + "</nok2PinCode>");
				sb.append("<bloodGroupId>"
						+ (patient.getBloodGroup() != null ? patient
								.getBloodGroup().getId() : "") + "</bloodGroupId>");
				sb.append("</item>");

			}
		}
		try {
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ModelAndView showDMOCallRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = registrationHandlerService
				.getDetailsForDMOCallRegister(hospitalId);
		String jsp = "dmoCallRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getOutPatientHinNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.getOutPatientHinNo(box);

		return new ModelAndView("responseHinForDMO", "map", map);
	}

	public void getPatientDetailsForDMO(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.getPatientInfoForVisit(box);
		List<Patient> patientList = new ArrayList<Patient>();
		List<Visit> maxVisitList = new ArrayList<Visit>();
		if (map.get("patientList") != null) {
			patientList = (List<Patient>) map.get("patientList");
		}
		int visitId = 0;
		if (map.get("maxVisitList") != null) {
			maxVisitList = (List<Visit>) map.get("maxVisitList");
			if (maxVisitList.size() > 0) {
				visitId = maxVisitList.get(0).getId();
			}
		}
		StringBuffer sb = new StringBuffer();
		if (patientList.size() > 0) {
			for (Patient patient : patientList) {
				sb.append("<item>");
				sb.append("<hinId>" + patient.getId() + "</hinId>");
				sb.append("<servType>"
						+ patient.getServiceType().getServiceTypeName()
						+ "</servType>");
				sb.append("<servStatus>"
						+ (patient.getServiceStatus() != null ? patient
								.getServiceStatus().getServiceStatusName() : "")
						+ "</servStatus>");
				sb.append("<rank>" + patient.getRank().getRankName()
						+ "</rank>");
				sb.append("<rankId>" + patient.getRank().getId() + "</rankId>");
				sb.append("<fName>" + patient.getPFirstName() + "</fName>");
				if (patient.getPMiddleName() != null) {
					sb.append("<mName>" + patient.getPMiddleName() + "</mName>");
				} else {
					sb.append("<mName>" + "" + "</mName>");
				}
				if (patient.getPLastName() != null) {
					sb.append("<lastName>" + patient.getPLastName()
							+ "</lastName>");
				} else {
					sb.append("<lastName>" + "" + "</lastName>");
				}
				String serPersName = "";
				serPersName = patient.getSFirstName();
				if (patient.getSMiddleName() != null) {
					serPersName += " " + patient.getSMiddleName();
				}
				if (patient.getSLastName() != null) {
					serPersName += " " + patient.getSLastName();
				}
				sb.append("<serPersName>" + serPersName + "</serPersName>");

				if (box.getString("flag").equals("ambulance")) {
					sb.append("<sex>" + patient.getSex().getId() + "</sex>");
				} else {
					sb.append("<sex>"
							+ patient.getSex().getAdministrativeSexName()
							+ "</sex>");
				}
				if (patient.getDateOfBirth() != null) {
					sb.append("<dob>"
							+ HMSUtil.convertDateToStringWithoutTime(patient
									.getDateOfBirth()) + "</dob>");
				} else {
					sb.append("<dob>" + "" + "</dob>");
				}
				if (patient.getAge() != null) {
					String age = patient.getAge();
					sb.append("<age>" + age + "</age>");

				} else {
					sb.append("<age>" + "" + "</age>");
				}
				if (patient.getCommand() != null) {
					sb.append("<command>"
							+ patient.getCommand().getCommandName()
							+ "</command>");
				} else {
					sb.append("<command>" + "" + "</command>");
				}
				if (patient.getStation() != null) {
					String station = patient.getStation();
					String stationStr = "";
					if (station.contains("&apos;") || station.contains("&amp;")
							|| station.contains("&quot;")
							|| station.contains("&gt;")
							|| station.contains("&lt;")) {
						stationStr = station;
					} else {
						stationStr = station.replaceAll("&", " &amp; ");
					}

					sb.append("<station>" + stationStr + "</station>");
				} else {
					sb.append("<station>" + "" + "</station>");
				}
				if (patient.getUnit() != null) {
					String unitStr = patient.getUnit().getUnitName();
					String unitStr1 = "";
					if (unitStr.contains("&apos;") || unitStr.contains("&amp;")
							|| unitStr.contains("&quot;")
							|| unitStr.contains("&gt;")
							|| unitStr.contains("&lt;")) {
						unitStr1 = unitStr;
					} else {
						unitStr1 = unitStr.replaceAll("&", " &amp; ");
					}

					sb.append("<unit>" + unitStr1 + "</unit>");
					sb.append("<unitId>" + patient.getUnit().getId()
							+ "</unitId>");
				} else {
					sb.append("<unit>" + "" + "</unit>");
					sb.append("<unitId>" + "0" + "</unitId>");
				}
				if (patient.getSection() != null) {
					sb.append("<section>"
							+ patient.getSection().getSectionName()
							+ "</section>");
				} else {
					sb.append("<section>" + "" + "</section>");
				}
				if (patient.getTrade() != null) {
					String tradeStr = patient.getTrade().getTradeName();
					String tradeStr1 = "";
					if (tradeStr.contains("&apos;")
							|| tradeStr.contains("&amp;")
							|| tradeStr.contains("&quot;")
							|| tradeStr.contains("&gt;")
							|| tradeStr.contains("&lt;")) {
						tradeStr1 = tradeStr;
					} else {
						tradeStr1 = tradeStr.replaceAll("&", " &amp; ");
					}
					sb.append("<trade>" + tradeStr1 + "</trade>");
				} else {
					sb.append("<trade>" + "" + "</trade>");
				}
				if (patient.getServiceYears() != null
						&& patient.getTotalServicePeriod() != null) {
					sb.append("<service>" + patient.getServiceYears() + " "
							+ patient.getTotalServicePeriod() + "</service>");
				} else {
					sb.append("<service>" + "" + "</service>");
				}
				if (patient.getBloodGroup() != null) {
					sb.append("<bldGrp>"
							+ patient.getBloodGroup().getBloodGroupName()
							+ "</bldGrp>");
				} else {
					sb.append("<bldGrp>" + "" + "</bldGrp>");
				}
				if (patient.getPhoneNumber() != null) {
					sb.append("<phoneNo>" + patient.getPhoneNumber()
							+ "</phoneNo>");
				} else {
					sb.append("<phoneNo>" + "" + "</phoneNo>");
				}
				if (patient.getMobileNumber() != null) {
					sb.append("<contactNo>" + patient.getMobileNumber()
							+ "</contactNo>");
				} else {
					sb.append("<contactNo>" + "" + "</contactNo>");
				}
				if (patient.getMaritalStatus() != null) {
					sb.append("<mrstatus>"
							+ patient.getMaritalStatus().getMaritalStatusName()
							+ "</mrstatus>");
				} else {
					sb.append("<mrstatus>" + "" + "</mrstatus>");
				}
				if (patient.getRelation() != null) {
					sb.append("<relation>"
							+ patient.getRelation().getRelationName()
							+ "</relation>");
					sb.append("<relationId>" + patient.getRelation().getId()
							+ "</relationId>");
				} else {
					sb.append("<relation>" + "" + "</relation>");
					sb.append("<relationId>" + "0" + "</relationId>");
				}
				sb.append("<visitId>" + visitId + "</visitId>");

				sb.append("</item>");
			}
		}
		try {
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ModelAndView saveDMOCallRegisterDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = registrationHandlerService.saveDMOCallRegisterDetails(box);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully.";
		} else {
			message = "Try Again.";
		}
		map.put("message", message);
		String jsp = "dmoCallRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAmbulanceRunRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = registrationHandlerService.showAmbulanceRunRegister();
		String jsp = "ambulanceRunRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveAmbulanceRunRegisterDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = registrationHandlerService.saveAmbulanceRunRegisterDetails(box);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully.";
		} else {
			message = "Try Again.";
		}
		map.put("message", message);
		String jsp = "ambulanceRunRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDMARegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			dataMap.put("hospitalId", hospitalId);
		}
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			dataMap.put("deptId", deptId);
		}

		Box box = HMSUtil.getBox(request);
		Map<String, Object> patientMap = registrationHandlerService
				.getPatientInfoForVisit(box);
		map = registrationHandlerService.showDMARegister(dataMap);
		if (patientMap.get("patientList") != null)
			map.put("patientList", patientMap.get("patientList"));
		String jsp = "DMARegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updatePatientImage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			mapDetails.put("hinNo", hinNo);
		}
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		// String uploadURL =
		// userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"HMS"+fileSeparator+"photo"+fileSeparator;
		String uploadURL = userHome + fileSeparator + "photo" + fileSeparator;
		// String uploadURL =
		// request.getSession().getServletContext().getRealPath(fileSeparator+"photo"+fileSeparator);
		mapDetails.put("uploadURL", uploadURL);
		mapDetails.put("extension", "jpg");
		map = registrationHandlerService.updatePatientImage(mapDetails);
		String jsp = "";
		jsp = "";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showAircraftEmergencyRegisterJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (request.getParameter("hospitalId") != null
				&& !request.getParameter("hospitalId").equals("0")) {
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		} else {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		map = registrationHandlerService.showAircraftEmergencyJsp(hospitalId);
		String jsp = "AircraftEmergencyRegister.jsp";
		map.put("contentJsp", jsp);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPrintAircraftEmergencyRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (request.getParameter("hospitalId") != null
				&& !request.getParameter("hospitalId").equals("0")) {
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		} else {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService
				.showPrintAircraftEmergencyRegisterReport(box);
		String jsp = "ShowPrintAircraftEmergencyRegisterReport.jsp";
		map.put("contentJsp", jsp);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}

	public void printAircraftEmergencyRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		String qry = "";
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (request.getParameter("cmdId") != null
				&& !request.getParameter("cmdId").equals("")
				&& !request.getParameter("cmdId").equals("0")
				&& request.getParameter("hospitalId") != null
				&& request.getParameter("hospitalId").equals("0")
				&& request.getParameter("hospitalId").equals("")) {

			qry += "  and mas_hospital.command_id="
					+ Integer.parseInt(request.getParameter("cmdId"));
		} else {
			if (request.getParameter("hospitalId") != null
					&& !request.getParameter("hospitalId").equals("")
					&& !request.getParameter("hospitalId").equals("0")) {
				hospitalId = Integer.parseInt(request
						.getParameter("hospitalId"));
			} else {
				hospitalId = (Integer) session.getAttribute("hospitalId");
			}
			qry += "  and air_craft_emergency.hospital_id=" + hospitalId;
		}

		if (request.getParameter(CALL_RCD_TIME) != null
				&& !request.getParameter(CALL_RCD_TIME).equals("")) {
			qry += " and air_craft_emergency.call_rcd_time='"
					+ request.getParameter(CALL_RCD_TIME) + "'";
		}
		if (request.getParameter(SOURCE_FROM) != null
				&& !request.getParameter(SOURCE_FROM).equals("")) {
			qry += " and air_craft_emergency.source_from='"
					+ request.getParameter(SOURCE_FROM) + "'";
		}
		if (request.getParameter(AIRCRAFT_TYPE_ID) != null
				&& !request.getParameter(AIRCRAFT_TYPE_ID).equals("0")) {
			qry += " and air_craft_emergency.aircraft_type_id="
					+ Integer.parseInt(request.getParameter(AIRCRAFT_TYPE_ID));
		}
		if (request.getParameter(EMERGENCY_TYPE) != null
				&& !request.getParameter(EMERGENCY_TYPE).equals("")) {
			qry += " and air_craft_emergency.emergency_type='"
					+ request.getParameter(EMERGENCY_TYPE) + "'";
		}
		if (request.getParameter(LOCATION) != null
				&& !request.getParameter(LOCATION).equals("")) {
			qry += " and air_craft_emergency.location='"
					+ request.getParameter(LOCATION) + "'";
		}
		if (request.getParameter(UNIT_ID) != null
				&& !request.getParameter(UNIT_ID).equals("0")) {
			qry += " and air_craft_emergency.unit_id="
					+ Integer.parseInt(request.getParameter(UNIT_ID));
		}
		if (request.getParameter(MEDICAL_OFFICER_ID) != null
				&& !request.getParameter(MEDICAL_OFFICER_ID).equals("0")) {
			qry += " and air_craft_emergency.medical_officer="
					+ Integer
							.parseInt(request.getParameter(MEDICAL_OFFICER_ID));
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("hospitalId", hospitalId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);

		HMSUtil.generateReport("AircraftEmergencyRegisterReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}

	public ModelAndView showEmergencyPerformaRegisterJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = registrationHandlerService.showAircraftEmergencyJsp(hospitalId);
		String jsp = "EmergencyPerformaRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void printEmergencyPerformaRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		Box box = HMSUtil.getBox(request);
		String qryStr = "";
		if (!box.getString(CALL_RCD_TIME).equals("")) {
			qryStr += " and emergency_performa.call_rcd_time='"
					+ box.getString(CALL_RCD_TIME) + "'";
		}
		if (!box.getString(SOURCE_FROM).equals("")) {
			qryStr += " and emergency_performa.source_from='"
					+ box.getString(SOURCE_FROM) + "'";
		}
		if (!box.getString(EMERGENCY_TYPE).equals("")) {
			qryStr += " and emergency_performa.emergency_type='"
					+ box.getString(EMERGENCY_TYPE) + "'";
		}
		if (!box.getString(LOCATION).equals("")) {
			qryStr += " and emergency_performa.location='"
					+ box.getString(LOCATION) + "'";
		}

		if (box.getInt(MEDICAL_OFFICER_ID) != 0) {
			qryStr += " and emergency_performa.medical_officer_id="
					+ box.getInt(MEDICAL_OFFICER_ID);
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		parameters.put("hospitalId",
				(Integer) session.getAttribute("hospitalId"));

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		HMSUtil.generateReport("EmergencyPerformaRegisterReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}

	public ModelAndView showMHReferralRegisterReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = registrationHandlerService
				.showMHReferralRegisterReportJsp(hospitalId);
		String jsp = "MHReferralRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void printMHReferralRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		String qry = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		if (request.getParameter(REFERRAL_DATE) != null
				&& !(request.getParameter(REFERRAL_DATE).equals(""))) {
			qry += " and mh_referral.referral_date = '"
					+ sdf.format(HMSUtil
							.convertStringTypeDateToDateType(request
									.getParameter(REFERRAL_DATE))) + "'";
		}
		if (request.getParameter(REFER_TO) != null
				&& !(request.getParameter(REFER_TO).equals(""))) {
			qry += " and mh_referral.refer_to = '"
					+ HMSUtil.restrictMetaChar(request.getParameter(REFER_TO))
					+ "'";
		}

		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			qry += " and mh_referral.rank_id = "
					+ Integer.parseInt(request.getParameter(RANK_ID)) + "";
		}
		if (request.getParameter(REFERRED_BY) != null
				&& !(request.getParameter(REFERRED_BY).equals("0"))) {
			qry += " and mh_referral.referred_id = "
					+ Integer.parseInt(request.getParameter(REFERRED_BY)) + "";
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		parameters.put("hospitalId",
				(Integer) session.getAttribute("hospitalId"));

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);

		HMSUtil.generateReport("MHReferralRegister", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}

	public ModelAndView getHinNoForDMA(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.getHinNoForDMA(box);

		return new ModelAndView("responseHinForDMO", "map", map);
	}

	public ModelAndView getItemId(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = registrationHandlerService.getItemId(box);
		map.put("counter", box.getInt("counter"));
		String jsp = "responseForBatchNo";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemBatch(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		map = registrationHandlerService.getItemId(box);
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		if (map.get("itemList") != null) {
			itemList = (List<MasStoreItem>) map.get("itemList");
		}
		box.put("itemId", itemList.get(0).getId());
		map = registrationHandlerService.getItemBatch(box);
		map.put("counter", box.getInt("counter"));
		map.put("flag", box.getString("flag"));
		String jsp = "responseForBatchNo";
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * public ModelAndView submitDMAStockDetails(HttpServletRequest
	 * request,HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); Box box = HMSUtil.getBox(request); HttpSession
	 * session= request.getSession(); int hospitalId = 0; int deptId =0;
	 * Map<String, Object> dataMap = new HashMap<String, Object>(); if
	 * (session.getAttribute(HOSPITAL_ID) != null) { hospitalId = (Integer)
	 * session.getAttribute(HOSPITAL_ID); box.put("hospitalId", hospitalId);
	 * dataMap.put("hospitalId", hospitalId); } if
	 * (session.getAttribute("users") != null) { Users user = (Users)
	 * session.getAttribute("users"); box.put("userId", user.getId());
	 * box.put("userName", user.getUserName()); } if
	 * (session.getAttribute("deptId") != null) deptId = Integer.parseInt("" +
	 * session.getAttribute("deptId")); box.put("deptId", deptId); map =
	 * registrationHandlerService.submitDMAStockDetails(box); boolean flag =
	 * (Boolean)map.get("flag"); String message = ""; if(flag){ message =
	 * "Record Saved Successfully."; }else{ message = "Try Again."; } // map =
	 * registrationHandlerService.showDMARegister(dataMap); map.put("message",
	 * message); String jsp="dmaStockDetails"; return new
	 * ModelAndView(jsp,"map",map); }
	 */
	public ModelAndView saveDmaRegisterDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
			dataMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
			box.put("userName", user.getUserName());
		}
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
			dataMap.put("deptId", deptId);
		}
		map = registrationHandlerService.saveDmaRegisterDetails(box);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully.";
		} else {
			message = "Try Again.";
		}
		map = registrationHandlerService.showDMARegister(dataMap);
		map.put("message", message);
		String jsp = "DMARegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDMOCallRegisterReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "DMOCallRegisterReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void printDMOCallRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		HMSUtil.generateReport("DMOCallRegisterReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}

	public ModelAndView showAmbulanceRegisterReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService
				.showAmbulanceRegisterReportJsp(hospitalId);
		String jsp = "ambulanceRegisterReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void printAmbulanceRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		String qry = "";
		if (!(request.getParameter("fromTime").equals(""))
				&& !(request.getParameter("toTime").equals(""))) {
			qry += " and ambulance_run_register.ambulance_run_time between '"
					+ request.getParameter("fromTime") + "' and '"
					+ request.getParameter("toTime") + "'";
		}
		if (request.getParameter(UNIT_ID) != null
				&& !(request.getParameter(UNIT_ID).equals("0"))) {
			qry += " and ambulance_run_register.unit_id = "
					+ Integer.parseInt(request.getParameter(UNIT_ID)) + "";
		}

		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			qry += " and ambulance_run_register.rank_id = "
					+ Integer.parseInt(request.getParameter(RANK_ID)) + "";
		}
		if (request.getParameter(TRADE_ID) != null
				&& !(request.getParameter(TRADE_ID).equals("0"))) {
			qry += " and patient.trade_id = "
					+ Integer.parseInt(request.getParameter(TRADE_ID)) + "";
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		parameters.put("hospitalId",
				(Integer) session.getAttribute("hospitalId"));

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		HMSUtil.generateReport("AmbulanceRunRegisterReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}

	public ModelAndView showDMARegisterReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.getDetailsForReport(hospitalId);
		String jsp = "dmaRegisterReport.jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void printDMARegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		String qry = "";

		if (!(request.getParameter("rankId").equals("0"))) {
			qry += " and patient.rank_id = "
					+ Integer.parseInt(request.getParameter("rankId"));
		}
		if (request.getParameter(TRADE_ID) != null
				&& !(request.getParameter(TRADE_ID).equals("0"))) {
			qry += " and patient.trade_id = "
					+ Integer.parseInt(request.getParameter(TRADE_ID)) + "";
		}
		if (request.getParameter(UNIT_ID) != null
				&& !(request.getParameter(UNIT_ID).equals("0"))) {
			qry += " and patient.unit_id = "
					+ Integer.parseInt(request.getParameter(UNIT_ID)) + "";
		}
		if (request.getParameter("complaint") != null
				&& !(request.getParameter("complaint").equals(""))) {
			qry += " and dma_register_header.complaints='"
					+ HMSUtil
							.restrictMetaChar(request.getParameter(SERVICE_NO))
					+ "'";
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			qry += " and patient.service_no='"
					+ HMSUtil
							.restrictMetaChar(request.getParameter(SERVICE_NO))
					+ "'";
		}
		if (!(request.getParameter("fromAge").equals(""))
				&& !(request.getParameter("fromAgeUnit").equals(""))
				&& !(request.getParameter("toAge").equals(""))
				&& !(request.getParameter("toAgeUnit").equals(""))) {
			String fromAge = request.getParameter("fromAge");
			String toAge = request.getParameter("toAge");
			// qry +=
			// " and patient.age>='"+fromAge+"' and patient.age<='"+toAge+"'";
			qry += " and substr(patient.age,0,INSTR(patient.age,' ')) >="
					+ fromAge
					+ " "
					+ " and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"
					+ request.getParameter("fromAgeUnit")
					+ "'"
					+ " and substr(patient.age,0,INSTR(patient.age,' ')) <="
					+ toAge
					+ " "
					+ " and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"
					+ request.getParameter("toAgeUnit") + "'";

		}
		if (request.getParameter(CONSULTING_DOCTOR) != null
				&& !(request.getParameter(CONSULTING_DOCTOR).equals("0"))) {
			qry += " and dma_register_header.dmo_id = "
					+ Integer.parseInt(request.getParameter(CONSULTING_DOCTOR))
					+ "";
		}
		String dmo = "";
		String treatment = "";
		String procedure = "";
		String injection = "";
		String detention = "";
		if (request.getParameter("dmoCalled") != null) {
			dmo = request.getParameter("dmoCalled");
		}
		if (request.getParameter("treatment") != null) {
			treatment = request.getParameter("treatment");
		}
		if (request.getParameter("procedure") != null) {
			procedure = request.getParameter("procedure");
		}
		if (request.getParameter("injection") != null) {
			injection = request.getParameter("injection");
		}
		if (request.getParameter("detention") != null) {
			detention = request.getParameter("detention");
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		parameters.put("hospitalId",
				(Integer) session.getAttribute("hospitalId"));

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		parameters.put("dmo", dmo);
		parameters.put("treatment", treatment);
		parameters.put("procedure", procedure);
		parameters.put("injection", injection);
		parameters.put("detention", detention);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/reports/"));
		HMSUtil.generateReport("DMARegisterReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}

	public ModelAndView getHinNoForMinorSurgery(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.getHinNoForMinorSurgery(box);

		return new ModelAndView("responseHinForMinorSurgery", "map", map);
	}

	public void getPatientDetailsForMinorSurgery(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.getPatientDetailsForMinorSurgery(box);
		/*
		 * List<Visit> visitList = new ArrayList<Visit>();
		 * if(map.get("visitList") != null){ visitList = (List<Visit>)
		 * map.get("visitList"); }
		 */
		List<Patient> patientList = new ArrayList<Patient>();
		if (map.get("patientList") != null) {
			patientList = (List<Patient>) map.get("patientList");
		}
		/* Visit visit = new Visit(); */
		Patient patient = new Patient();
		if (patientList.size() > 0) {
			patient = patientList.get(0);
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<hinId>" + patient.getId() + "</hinId>");
		sb.append("<servType>" + patient.getServiceType().getServiceTypeName()
				+ "</servType>");
		sb.append("<servStatus>"
				+ patient.getServiceStatus().getServiceStatusName()
				+ "</servStatus>");
		sb.append("<rank>" + patient.getRank().getRankName() + "</rank>");

		String patientName = patient.getPFirstName();
		if (patient.getPMiddleName() != null) {
			patientName += " " + patient.getPMiddleName();
		}
		if (patient.getPLastName() != null) {
			patientName += " " + patient.getPLastName();
		}
		sb.append("<pName>" + patientName + "</pName>");

		String servPerName = patient.getSFirstName();
		if (patient.getSMiddleName() != null) {
			servPerName += " " + patient.getSMiddleName();
		}
		if (patient.getSLastName() != null) {
			servPerName += " " + patient.getSLastName();
		}
		sb.append("<servPerName>" + servPerName + "</servPerName>");
		if (patient.getAge() != null) {
			String age = patient.getAge();
			sb.append("<age>" + age + "</age>");

		} else {
			sb.append("<age>" + "" + "</age>");
		}
		if (patient.getUnit() != null) {
			sb.append("<unit>" + patient.getUnit().getUnitName() + "</unit>");
		} else {
			sb.append("<unit>" + "" + "</unit>");
		}
		if (patient.getTrade() != null) {
			sb.append("<trade>" + patient.getTrade().getTradeName()
					+ "</trade>");
		} else {
			sb.append("<trade>" + "" + "</trade>");
		}
		if (patient.getRelation() != null) {
			sb.append("<relation>" + patient.getRelation().getRelationName()
					+ "</relation>");
		} else {
			sb.append("<relation>" + "" + "</relation>");
		}

		/*
		 * sb.append("<visitNo>" + visit.getVisitNo() + "</visitNo>");
		 * sb.append("<visitId>" + visit.getId() + "</visitId>");
		 * if(visit.getDoctor()!= null){ String docName =
		 * visit.getDoctor().getFirstName();
		 * if(visit.getDoctor().getMiddleName() != null){ docName +=
		 * " "+visit.getDoctor().getMiddleName() ; }
		 * if(visit.getDoctor().getLastName() != null){ docName +=
		 * " "+visit.getDoctor().getLastName() ; } sb.append("<doctor>" +
		 * docName + "</doctor>"); }else{ sb.append("<doctor>" + " " +
		 * "</doctor>"); } if(visit.getDiagnosis() != null){ sb.append("<diag>"
		 * + visit.getDiagnosis() + "</diag>"); }else{ sb.append("<diag>" +" " +
		 * "</diag>"); }
		 */

		sb.append("</item>");
		try {
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ModelAndView getVisitNoForMinorSurgery(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hinId = 0;
		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		List<Visit> visitNoList = new ArrayList<Visit>();
		visitNoList = registrationHandlerService
				.getVisitNoForMinorSurgery(hinId);

		String jsp = "responseVisitNoForMnrSrgry";
		map.put("visitNoList", visitNoList);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showECGRecordJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.showECGRecordJsp(hospitalId);
		String jsp = "ECGRecordRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveECGRecordDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = registrationHandlerService.saveECGRecordDetails(box);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully.";
		} else {
			message = "Try Again.";
		}
		map.put("message", message);
		String jsp = "ECGRecordRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getServiceNoDetailsFromHIC(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> hicDtmap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		hicDtmap = registrationHandlerService.getServiceNoDetailsFromHIC(box);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.showRegistrationJsp(hospitalId);
		map.put("hicDtmap", hicDtmap);
		String jsp = "registration.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showMedExamForHICUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = registrationHandlerService.getMedExamForHICUpdate();
		return new ModelAndView("Hin_Status", "map", map);
	}

	public ModelAndView getProcedureForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			
			if (request.getParameter("procedureType") != null && !request.getParameter("procedureType").isEmpty()) {
				map.put("procedureType", request.getParameter("procedureType"));
			}
			System.out.println(request.getParameter("procedureType") +" request.getParameter");
			map.put("autoHint", autoHint);
			map = registrationHandlerService.getProcedureForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "responseProcedureList";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showProcedureWaitListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.getDetailsForProcWaitList(hospitalId);
		String jsp = "procedureWaitingList.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPendingProcedureList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.getPendingProcedureList(box);
		String jsp = "procedureWaitingList.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPendingProcedureDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.getPendingProcedureDetails(box);
		String jsp = "procedureRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveProcedureDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = registrationHandlerService.saveMinorSurgeryDetails(box);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully.";
		} else {
			message = "Try Again.";
		}
		map = registrationHandlerService.getDetailsForProcWaitList(hospitalId);
		String jsp = "procedureWaitingList.jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDetentionWaitListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.getDoctorList(hospitalId);
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		doctorList = (List<MasEmployee>) map.get("doctorList");
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.getPendingDetentionList(box);
		map.put("doctorList", doctorList);
		String jsp = "patientDetentionWaitList.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPendingDetentionList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.getPendingDetentionList(box);
		String jsp = "patientDetentionWaitList.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPendingDetentionDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.getPendingDetentionDetails(box);
		String jsp = "patientDetentionRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView savePatientDetentionDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = registrationHandlerService.savePatientDetentionDetails(box);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully.";
		} else {
			message = "Try Again.";
		}
		map = registrationHandlerService.getDoctorList(hospitalId);
		String jsp = "patientDetentionWaitList.jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showProcedureRegisterReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dtmap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		dtmap = registrationHandlerService
				.showAmbulanceRegisterReportJsp(hospitalId);
		map = registrationHandlerService.getDetailsForProcWaitList(hospitalId);
		map.put("tradeList", dtmap.get("tradeList"));
		map.put("unitList", dtmap.get("unitList"));
		map.put("rankList", dtmap.get("rankList"));
		String jsp = "procedureRegisterReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void printProcedureRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		String qry = "";
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			qry += " and p.rank_id = "
					+ Integer.parseInt(request.getParameter(RANK_ID)) + "";
		}
		if (request.getParameter(UNIT_ID) != null
				&& !(request.getParameter(UNIT_ID).equals("0"))) {
			qry += " and p.unit_id = "
					+ Integer.parseInt(request.getParameter(UNIT_ID)) + "";
		}
		if (request.getParameter(TRADE_ID) != null
				&& !(request.getParameter(TRADE_ID).equals("0"))) {
			qry += " and p.trade_id = "
					+ Integer.parseInt(request.getParameter(TRADE_ID)) + "";
		}
		if (request.getParameter(MEDICAL_OFFICER_ID) != null
				&& !request.getParameter(MEDICAL_OFFICER_ID).equals("0")) {
			qry += " and ph.medical_officer_id="
					+ Integer
							.parseInt(request.getParameter(MEDICAL_OFFICER_ID));
		}
		if (request.getParameter("procedure") != null
				&& !request.getParameter("procedure").equals("0")) {
			qry += " and pd.procedure_id="
					+ Integer.parseInt(request.getParameter("procedure"));
		}
		if (!(request.getParameter("fromAge").equals(""))
				&& !(request.getParameter("fromAgeUnit").equals(""))
				&& !(request.getParameter("toAge").equals(""))
				&& !(request.getParameter("toAgeUnit").equals(""))) {
			String fromAge = request.getParameter("fromAge");
			String toAge = request.getParameter("toAge");
			qry += " and substr(p.age,0,INSTR(p.age,' ')) >=" + fromAge + " "
					+ " and  substr(p.age,INSTR(p.age,' ')+1,length(p.age))='"
					+ request.getParameter("fromAgeUnit") + "'"
					+ " and substr(p.age,0,INSTR(p.age,' ')) <=" + toAge + " "
					+ " and  substr(p.age,INSTR(p.age,' ')+1,length(p.age))='"
					+ request.getParameter("toAgeUnit") + "'";
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		parameters.put("hospitalId",
				(Integer) session.getAttribute("hospitalId"));

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		HMSUtil.generateReport("procedureRegister", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}

	public ModelAndView showDetentionReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dtmap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		dtmap = registrationHandlerService
				.showAmbulanceRegisterReportJsp(hospitalId);
		map = registrationHandlerService.getDoctorList(hospitalId);
		map.put("tradeList", dtmap.get("tradeList"));
		map.put("unitList", dtmap.get("unitList"));
		map.put("rankList", dtmap.get("rankList"));
		String jsp = "patientDetentionRegisterReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void printDetentionRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		String qry = "";
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			qry += " and p.rank_id = "
					+ Integer.parseInt(request.getParameter(RANK_ID)) + "";
		}
		if (request.getParameter(UNIT_ID) != null
				&& !(request.getParameter(UNIT_ID).equals("0"))) {
			qry += " and p.unit_id = "
					+ Integer.parseInt(request.getParameter(UNIT_ID)) + "";
		}
		if (request.getParameter(TRADE_ID) != null
				&& !(request.getParameter(TRADE_ID).equals("0"))) {
			qry += " and p.trade_id = "
					+ Integer.parseInt(request.getParameter(TRADE_ID)) + "";
		}
		if (request.getParameter(MEDICAL_OFFICER_ID) != null
				&& !request.getParameter(MEDICAL_OFFICER_ID).equals("0")) {
			qry += " and ph.medical_officer_id="
					+ Integer
							.parseInt(request.getParameter(MEDICAL_OFFICER_ID));
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		parameters.put("hospitalId",
				(Integer) session.getAttribute("hospitalId"));

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		HMSUtil.generateReport("PatientDetentionReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}

	public ModelAndView showOtherEmeregencyReportOnScreen(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showOtherEmeregencyReportOnScreen(box);
		String jsp = "OtherEmeregencyReportOnScreen.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPrintMHReferralRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showPrintMHReferralRegisterReport(box);
		String jsp = "MHReferralRegisterReportOnScreen.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPrintAmbulanceRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showPrintAmbulanceRegisterReport(box);
		String jsp = "AmbulanceRegisterReportOnScreen.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPrintProcedureRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showPrintProcedureRegisterReport(box);
		String jsp = "ProcedureRegisterReportOnScreen.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showprintDetentionRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showprintDetentionRegisterReport(box);
		String jsp = "PrintDetentionRegisterReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOPDStatisticsGraph(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (request.getParameter("hospitalId") != null
				&& !request.getParameter("hospitalId").equals("0")) {
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		} else {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Box box = null;
		if (session.getAttribute("box") != null) {
			box = (Box) session.getAttribute("box");
		} else {
			box = HMSUtil.getBox(request);
		}
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showOPDStatisticsGraph(box);
		List<Object[]> opdRegisterList = new ArrayList<Object[]>();
		opdRegisterList = (List<Object[]>) map.get("opdRegisterList");
		String ENCODING = "ISO-8859-1";
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_opd_data.xml")));

			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>");
			out.write("<chart>");
			int i = 0;
			out.write("<series>");
			for (Object[] object : opdRegisterList) {
				out.write("<value xid='"
						+ i
						+ "'>"
						+ HMSUtil
								.convertDateToStringWithoutTime((Date) object[0])
						+ "</value>");
				i++;
			}
			out.write("</series>");
			out.write("<graphs>");
			int j = 1;

			for (int k = 0; k < 5; k++) {

				out.write("<graph gid='" + k + "'>");
				int l = 0;
				for (Object[] objVal : opdRegisterList) {

					if (objVal[j] != null)
						out.write("<value xid='" + l + "' >" + objVal[j]
								+ "</value>");
					else
						out.write("<value xid='" + l + "' >0</value>");
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
		String jsp = "opdStatisticsGraph";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showMHReferralGraph(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showMHReferralGraph(box);
		List<Object[]> mhRegisterList = new ArrayList<Object[]>();
		mhRegisterList = (List<Object[]>) map.get("mhRegisterList");
		String ENCODING = "ISO-8859-1";
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_mh_data.xml")));

			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>");
			out.write("<chart>");
			int i = 0;
			out.write("<series>");
			for (Object[] object : mhRegisterList) {
				out.write("<value xid='"
						+ i
						+ "'>"
						+ HMSUtil
								.convertDateToStringWithoutTime((Date) object[0])
						+ "</value>");
				i++;
			}
			out.write("</series>");
			out.write("<graphs>");
			int j = 1;

			for (int k = 0; k < 5; k++) {

				out.write("<graph gid='" + k + "'>");
				int l = 0;
				for (Object[] objVal : mhRegisterList) {

					if (objVal[j] != null)
						out.write("<value xid='" + l + "' >" + objVal[j]
								+ "</value>");
					else
						out.write("<value xid='" + l + "' >0</value>");
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
		String jsp = "mhReferralGraph";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showProcedureGraph(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showProcedureGraph(box);
		List<Object[]> procedureList = new ArrayList<Object[]>();
		procedureList = (List<Object[]>) map.get("procedureList");
		String ENCODING = "ISO-8859-1";
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_procedure_data.xml")));

			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>");
			out.write("<chart>");
			int i = 0;
			out.write("<series>");
			for (Object[] object : procedureList) {
				out.write("<value xid='"
						+ i
						+ "'>"
						+ HMSUtil
								.convertDateToStringWithoutTime((Date) object[0])
						+ "</value>");
				i++;
			}
			out.write("</series>");
			out.write("<graphs>");
			int j = 1;

			for (int k = 0; k < 5; k++) {

				out.write("<graph gid='" + k + "'>");
				int l = 0;
				for (Object[] objVal : procedureList) {

					if (objVal[j] != null)
						out.write("<value xid='" + l + "' >" + objVal[j]
								+ "</value>");
					else
						out.write("<value xid='" + l + "' >0</value>");
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
		String jsp = "procedureRegisterGraph";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showAmbulanceRegisterGraph(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showAmbulanceRegisterGraph(box);
		List<Object[]> ambulanceRegisterList = new ArrayList<Object[]>();
		ambulanceRegisterList = (List<Object[]>) map
				.get("ambulanceRegisterList");
		String ENCODING = "ISO-8859-1";
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_ambulance_data.xml")));

			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>");
			out.write("<chart>");
			int i = 0;
			out.write("<series>");
			for (Object[] object : ambulanceRegisterList) {
				out.write("<value xid='"
						+ i
						+ "'>"
						+ HMSUtil
								.convertDateToStringWithoutTime((Date) object[0])
						+ "</value>");
				i++;
			}
			out.write("</series>");
			out.write("<graphs>");
			int j = 1;

			for (int k = 0; k < 5; k++) {

				out.write("<graph gid='" + k + "'>");
				int l = 0;
				for (Object[] objVal : ambulanceRegisterList) {

					if (objVal[j] != null)
						out.write("<value xid='" + l + "' >" + objVal[j]
								+ "</value>");
					else
						out.write("<value xid='" + l + "' >0</value>");
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
		String jsp = "ambulanceRegisterGraph";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showAircraftRegisterGraph(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (request.getParameter("hospitalId") != null
				&& !request.getParameter("hospitalId").equals("0")) {
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		} else {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showAircraftRegisterGraph(box);
		List<Object[]> aircraftRegisterList = new ArrayList<Object[]>();
		aircraftRegisterList = (List<Object[]>) map.get("aircraftRegisterList");
		String ENCODING = "ISO-8859-1";
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_aircraft_data.xml")));

			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>");
			out.write("<chart>");
			int i = 0;
			out.write("<series>");
			for (Object[] object : aircraftRegisterList) {
				out.write("<value xid='"
						+ i
						+ "'>"
						+ HMSUtil
								.convertDateToStringWithoutTime((Date) object[0])
						+ "</value>");
				i++;
			}
			out.write("</series>");
			out.write("<graphs>");

			out.write("<graph gid='0'>");
			int l = 0;
			for (Object[] objVal : aircraftRegisterList) {

				if (objVal[1] != null)
					out.write("<value xid='" + l + "' >" + objVal[1]
							+ "</value>");
				else
					out.write("<value xid='" + l + "' >0</value>");
				l++;

			}

			out.write("</graph>");

			out.write("</graphs>");

			out.write("</chart>");
			out.close();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "aircraftRegisterGraph";

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showUnwillingnessCertificateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "unwillingnessCertificate.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveUnwillingnessCertificate(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		box.put("userId", userId);
		map = registrationHandlerService.saveUnwillingnessCertificate(box);
		boolean flag = (Boolean) map.get("saved");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully.Do you want to print?";
			map.put("printUrl",
					"/hms/hms/registration?method=printUnwillingnessCertificate&hinId="
							+ box.getInt(HIN_ID));
		} else {
			message = "Try Again.";
		}

		String jsp = "messageForADT.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public void printUnwillingnessCertificate(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int hinId = 0;

		if (request.getParameter("hinId") != null
				&& !(request.getParameter("hinId").equals("0"))) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}

		detailsMap = registrationHandlerService.getConnectionForReport();
		parameters.put("hinId", hinId);
		parameters.put("date", new Date());
		HMSUtil.generateReport("UnwillingnessCertificate", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}

	public ModelAndView showOtherEmergencyGraph(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showOtherEmergencyGraph(box);
		List<Object[]> otherEmergencyList = new ArrayList<Object[]>();
		otherEmergencyList = (List<Object[]>) map.get("otherEmergencyList");
		String ENCODING = "ISO-8859-1";
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_other_emr_data.xml")));

			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>");
			out.write("<chart>");
			int i = 0;
			out.write("<series>");
			for (Object[] object : otherEmergencyList) {
				out.write("<value xid='"
						+ i
						+ "'>"
						+ HMSUtil
								.convertDateToStringWithoutTime((Date) object[0])
						+ "</value>");
				i++;
			}
			out.write("</series>");
			out.write("<graphs>");

			out.write("<graph gid='0'>");
			int l = 0;
			for (Object[] objVal : otherEmergencyList) {

				if (objVal[1] != null)
					out.write("<value xid='" + l + "' >" + objVal[1]
							+ "</value>");
				else
					out.write("<value xid='" + l + "' >0</value>");
				l++;

			}

			out.write("</graph>");

			out.write("</graphs>");

			out.write("</chart>");
			out.close();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "otherEmergencyGraph";

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showDetentionRegisterGraph(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showDetentionRegisterGraph(box);
		List<Object[]> detentionRegisterList = new ArrayList<Object[]>();
		detentionRegisterList = (List<Object[]>) map
				.get("detentionRegisterList");
		String ENCODING = "ISO-8859-1";
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_detention_data.xml")));

			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>");
			out.write("<chart>");
			int i = 0;
			out.write("<series>");
			for (Object[] object : detentionRegisterList) {
				out.write("<value xid='"
						+ i
						+ "'>"
						+ HMSUtil
								.convertDateToStringWithoutTime((Date) object[0])
						+ "</value>");
				i++;
			}
			out.write("</series>");
			out.write("<graphs>");
			int j = 1;

			for (int k = 0; k < 5; k++) {

				out.write("<graph gid='" + k + "'>");
				int l = 0;
				for (Object[] objVal : detentionRegisterList) {

					if (objVal[j] != null)
						out.write("<value xid='" + l + "' >" + objVal[j]
								+ "</value>");
					else
						out.write("<value xid='" + l + "' >0</value>");
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
		String jsp = "detentionRegisterGraph";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showInjectionRegisterReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dtmap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		dtmap = registrationHandlerService
				.showAmbulanceRegisterReportJsp(hospitalId);
		map = registrationHandlerService.getDetailsForProcWaitList(hospitalId);
		map.put("tradeList", dtmap.get("tradeList"));
		map.put("unitList", dtmap.get("unitList"));
		map.put("rankList", dtmap.get("rankList"));
		String jsp = "injectionAdministrationReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void printInjectionRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		String qry = "";
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			qry += " and p.rank_id = "
					+ Integer.parseInt(request.getParameter(RANK_ID)) + "";
		}
		if (request.getParameter(UNIT_ID) != null
				&& !(request.getParameter(UNIT_ID).equals("0"))) {
			qry += " and p.unit_id = "
					+ Integer.parseInt(request.getParameter(UNIT_ID)) + "";
		}
		if (request.getParameter(TRADE_ID) != null
				&& !(request.getParameter(TRADE_ID).equals("0"))) {
			qry += " and p.trade_id = "
					+ Integer.parseInt(request.getParameter(TRADE_ID)) + "";
		}
		if (request.getParameter(MEDICAL_OFFICER_ID) != null
				&& !request.getParameter(MEDICAL_OFFICER_ID).equals("0")) {
			qry += " and ph.medical_officer_id="
					+ Integer
							.parseInt(request.getParameter(MEDICAL_OFFICER_ID));
		}
		/*
		 * if(request.getParameter("procedure")!=null &&
		 * !request.getParameter("procedure").equals("0")){ qry +=
		 * " and pd.procedure_id="
		 * +Integer.parseInt(request.getParameter("procedure")); }
		 */
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		parameters.put("hospitalId",
				(Integer) session.getAttribute("hospitalId"));

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		HMSUtil.generateReport("injectionRegister", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}

	public ModelAndView showInjectionRegisterGraph(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showInjectionRegisterGraph(box);
		List<Object[]> injectionRegisterList = new ArrayList<Object[]>();
		injectionRegisterList = (List<Object[]>) map
				.get("injectionRegisterList");
		String ENCODING = "ISO-8859-1";
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_injection_data.xml")));

			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>");
			out.write("<chart>");
			int i = 0;
			out.write("<series>");
			for (Object[] object : injectionRegisterList) {
				out.write("<value xid='"
						+ i
						+ "'>"
						+ HMSUtil
								.convertDateToStringWithoutTime((Date) object[0])
						+ "</value>");
				i++;
			}
			out.write("</series>");
			out.write("<graphs>");
			int j = 1;

			for (int k = 0; k < 5; k++) {

				out.write("<graph gid='" + k + "'>");
				int l = 0;
				for (Object[] objVal : injectionRegisterList) {

					if (objVal[j] != null)
						out.write("<value xid='" + l + "' >" + objVal[j]
								+ "</value>");
					else
						out.write("<value xid='" + l + "' >0</value>");
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
		String jsp = "injectionRegisterGraph";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showPrintInjectionRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showPrintInjectionRegisterReport(box);
		String jsp = "injectionRegisterReportOnScreen.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView openPopupForImmunization(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hinId = box.getInt("hinId");
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		map = registrationHandlerService.getPatientImmunizationDetails(hinId);
		String jsp = "immunizationPopup";
		map.put("flag", flag);
		map.put("contentJsp", jsp);
		map.put("hinId", hinId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getImmunizationForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			map.put("autoHint", autoHint);
			map = registrationHandlerService
					.getImmunizationForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "immunizationResponseInGrid";

		return new ModelAndView(jsp, "map", map);
	}

	public void getImmunizationId(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.getImmunizationId(box);
		try {
			List<MasImmunization> immunizationList = new ArrayList<MasImmunization>();
			if (map.get("immunizationList") != null) {
				immunizationList = (List<MasImmunization>) map
						.get("immunizationList");
			}
			StringBuffer sb = new StringBuffer();
			if (immunizationList.size() > 0) {
				for (MasImmunization immunization : immunizationList) {
					sb.append("<item>");
					sb.append("<immunizationId>" + immunization.getId()
							+ "</immunizationId>");
					sb.append("</item>");

				}
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().write(
						"<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<items>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showInjectionWaitListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = registrationHandlerService.getDoctorList(hospitalId);
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		doctorList = (List<MasEmployee>) map.get("doctorList");
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.getPendingInjectionList(box);
		map.put("doctorList", doctorList);
		String jsp = "injectionWaitingList.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPendingInjectionList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.getPendingInjectionList(box);
		String jsp = "injectionWaitingList.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getInjectionDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.getInjectionDetails(box);
		String jsp = "injectionRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveInjectionRegisterDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = registrationHandlerService.saveInjectionRegisterDetails(box);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully. Do you want to give injection appointment?";
		} else {
			message = "Try Again.";
		}
		// map = registrationHandlerService.getDoctorList(hospitalId);
		map.put("message", message);
		map.put("appointmentHeaderId", box.getInt("appointmentHeaderId"));
		String jsp = "injectionMessage.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getInjectionListForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) (session.getAttribute("deptId"));
			}
			map.put("deptId", deptId);
			map.put("autoHint", autoHint);
			map = registrationHandlerService
					.getInjectionListForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "opd_responseInGrid";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showInjectionAppointment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.getInjectionDetailsForAppointment(box);
		String jsp = "injectionAppointment.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveInjectionAppointment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = registrationHandlerService.saveInjectionAppointment(box);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully.";
		} else {
			message = "Try Again.";
		}
		// map = registrationHandlerService.getDoctorList(hospitalId);
		map.put("message", message);
		String jsp = "injectionWaitingList.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getInjectionAppointmentDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.getInjectionAppointmentDetails(box);

		return new ModelAndView("responseForInjAppointment", "map", map);
	}

	public ModelAndView openPopupForAllergies(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hinId = box.getInt("hinId");
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		map = registrationHandlerService.getPatientAllergyDetails(hinId);
		String jsp = "allergiesPopup";
		map.put("contentJsp", jsp);
		map.put("hinId", hinId);
		map.put("flag", flag);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView inactivatePatientAllergies(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.inactivatePatientAllergies(box);
		boolean saved = false;
		saved = (Boolean) map.get("saved");
		String jsp = "";
		if (box.getString("flag").equals("registration")) {
			jsp = "allergiesPopup";
			map.put("contentJsp", jsp);

		} else if (box.getString("flag").equals("opd")) {
			map = opdHandlerService.showAllergyDetailsJsp(box);
			jsp = "index";
			map.put("contentJsp", "allergy_details.jsp");
			map.put("hospitalId", (Integer) session.getAttribute("hospitalId"));
		}
		if (saved) {
			map.put("message", "Record Inactivated Successfully.");
		} else {
			map.put("message", "Some Problem Occured.Try Again.");
		}
		return new ModelAndView(jsp, "map", map);
	}

	// -------------------------------Dinesh --------start here
	// ------------------------------------------
	public ModelAndView saveImmunizationDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> objectMap = new HashMap<String, Object>();
		List<Integer> immuDtIdList = new ArrayList<Integer>();
		List<Integer> immuIdList = new ArrayList<Integer>();
		List<Integer> storeOpIssueTIdList = new ArrayList<Integer>();
		List<String> dateList = new ArrayList<String>();
		List<String> doseList = new ArrayList<String>();
		List<String> routeList = new ArrayList<String>();
		List<String> batchNoList = new ArrayList<String>();
		List<String> domList = new ArrayList<String>();
		List<String> doeList = new ArrayList<String>();
		List<String> immuNameList = new ArrayList<String>();
		int count = 0;
		int hinId = 0;
		String deleteVal = "";
		if (request.getParameter("deleteVal") != null
				&& (!request.getParameter("deleteVal").equals(""))) {
			deleteVal = request.getParameter("deleteVal");
		}

		if (request.getParameter("count") != null) {
			count = Integer.parseInt(request.getParameter("count").toString());
		}
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt(request.getParameter("hinId").toString());
		}
		for (int j = 1; j <= count; j++) {
			/*
			 * if(request.getParameter("immunizationDetailsId"+j)!=null &&
			 * !request.getParameter("immunizationDetailsId"+j).equals("")){
			 * immuDtIdList
			 * .add(Integer.parseInt(request.getParameter("immunizationDetailsId"
			 * +j))); }else{ immuDtIdList.add(0); }
			 */
			if (request.getParameter("immunId" + j) != null
					&& !request.getParameter("immunId" + j).equals("")) {
				immuDtIdList.add(Integer.parseInt(request
						.getParameter("immunId" + j)));
			} else {
				immuDtIdList.add(0);
			}
			if (request.getParameter("storeOpIssueTId" + j) != null
					&& !request.getParameter("storeOpIssueTId" + j).equals("")) {
				storeOpIssueTIdList.add(Integer.parseInt(request
						.getParameter("storeOpIssueTId" + j)));
			} else {
				storeOpIssueTIdList.add(0);
			}
			if (request.getParameter("immunizationName" + j) != null) {
				// String
				// immunizationName=request.getParameter("immunizationName"+j);
				// int lastIndex=immunizationName.lastIndexOf("[");
				// String finalImmunizationName=immunizationName.substring(0,3);
				immuNameList.add(request.getParameter("immunizationName" + j));
			}
			/*
			 * if(request.getParameter("immunizationId"+j)!=null){
			 * immuIdList.add
			 * (Integer.parseInt(request.getParameter("immunizationId"+j))); }
			 */
			if (request.getParameter("date" + j) != null) {
				dateList.add(request.getParameter("date" + j));
			}
			if (request.getParameter("dose" + j) != null) {
				doseList.add(request.getParameter("dose" + j));
			}
			if (request.getParameter("route" + j) != null) {
				routeList.add(request.getParameter("route" + j));
			}
			if (request.getParameter("batchNo" + j) != null) {
				batchNoList.add(request.getParameter("batchNo" + j));
			}
			if (request.getParameter("dom" + j) != null) {
				domList.add(request.getParameter("dom" + j));
			}
			if (request.getParameter("doe" + j) != null) {
				doeList.add(request.getParameter("doe" + j));
			}

		}
		objectMap.put("immuDtIdList", immuDtIdList);
		objectMap.put("storeOpIssueTIdList", storeOpIssueTIdList);
		objectMap.put("immuIdList", immuIdList);
		objectMap.put("dateList", dateList);
		objectMap.put("doseList", doseList);
		objectMap.put("routeList", routeList);
		objectMap.put("batchNoList", batchNoList);
		objectMap.put("domList", domList);
		objectMap.put("doeList", doeList);
		objectMap.put("hospitalId", hospitalId);
		objectMap.put("hinId", hinId);
		objectMap.put("immuNameList", immuNameList);
		objectMap.put("deleteVal", deleteVal);
		boolean status = false;
		status = registrationHandlerService.saveImmunizationDetails(objectMap);
		map = registrationHandlerService.getPatientImmunizationDetails(hinId);

		if (status) {
			map.put("message", "Record Added Successfully.");
		} else {
			map.put("message", "Some Problem Occured.Try Again.");
		}
		String jsp = "immunizationPopup";
		map.put("flag", "medicalExam");
		map.put("hinId", hinId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView saveAllergiesDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> objectMap = new HashMap<String, Object>();
		int allergyCount = 0;
		if (request.getParameter("allergyCount") != null) {
			allergyCount = Integer.parseInt(request
					.getParameter("allergyCount"));
		}
		int hinId = 0;
		boolean status = false;
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt(request.getParameter("hinId").toString());
		}
		String deleteVal = "";
		if (request.getParameter("deleteVal") != null
				&& (!request.getParameter("deleteVal").equals(""))) {
			deleteVal = request.getParameter("deleteVal");
		}
		List<Integer> allergyDetailsIdList = new ArrayList<Integer>();
		List<Integer> allergyTypeIdList = new ArrayList<Integer>();
		List<String> descList = new ArrayList<String>();
		List<String> severityList = new ArrayList<String>();
		List<String> sinceList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();

		for (int j = 1; j <= allergyCount; j++) {
			if (request.getParameter("allergyDetailsId" + j) != null
					&& !request.getParameter("allergyDetailsId" + j).equals("")) {
				allergyDetailsIdList.add(Integer.parseInt(request
						.getParameter("allergyDetailsId" + j)));
			} else {
				allergyDetailsIdList.add(0);
			}
			if (request.getParameter("allergyId" + j) != null
					&& !request.getParameter("allergyId" + j).equals("")) {
				allergyTypeIdList.add(Integer.parseInt(request
						.getParameter("allergyId" + j)));
			}
			if (request.getParameter("description" + j) != null) {
				descList.add(request.getParameter("description" + j));
			}
			if (request.getParameter("severity" + j) != null) {
				severityList.add(request.getParameter("severity" + j));
			}
			if (request.getParameter("since" + j) != null) {
				sinceList.add(request.getParameter("since" + j));
			}
			if (request.getParameter("remarks" + j) != null) {
				remarksList.add(request.getParameter("remarks" + j));
			}

		}
		objectMap.put("allergyDetailsIdList", allergyDetailsIdList);
		objectMap.put("allergyTypeIdList", allergyTypeIdList);
		objectMap.put("descList", descList);
		objectMap.put("severityList", severityList);
		objectMap.put("sinceList", sinceList);
		objectMap.put("remarksList", remarksList);
		objectMap.put("hospitalId", hospitalId);
		objectMap.put("hinId", hinId);
		objectMap.put("deleteVal", deleteVal);

		status = registrationHandlerService.saveAllergiesDetails(objectMap);
		map = registrationHandlerService.getPatientAllergyDetails(hinId);

		if (status) {
			map.put("message", "Record Added Successfully.");
		} else {
			map.put("message", "Some Problem Occured.Try Again.");
		}
		String jsp = "allergiesPopup";
		map.put("flag", "medicalExam");
		map.put("hinId", hinId);
		return new ModelAndView(jsp, "map", map);
	}

	// -----------------------------------------------Dinesh -----------end
	// here-------------------------
	public ModelAndView getOpIpHinNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String serviceNo = box.getString(SERVICE_NO);
		List<Object[]> patientList = new ArrayList<Object[]>();
		patientList = registrationHandlerService.getHinNoList(serviceNo);
		map.put("hinNoList", patientList);
		return new ModelAndView("responseHinForDMO", "map", map);
	}

	// ------------------------code by anamika for Registration
	// Staticts----------------------//
	public ModelAndView showRegistrationStatistics(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = registrationHandlerService.getDetailsForReport(hospitalId);
		jsp = "registration_statistics_report" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showRegistrationStatisticsOnScreen(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.getOPDRegisterData(box);
		String jsp = "registration_statistics.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printRegistrationRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		Box box = null;
		if (session.getAttribute("box") != null) {
			box = (Box) session.getAttribute("box");
		} else {
			box = HMSUtil.getBox(request);
		}

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (!box.getString(FROM_DATE).equals("")) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(box
					.getString(FROM_DATE));
		}

		if (!box.getString(TO_DATE).equals("")) {
			toDate = HMSUtil.convertStringTypeDateToDateType(box
					.getString(TO_DATE));
		}
		String qry = "";
		if (box.getInt(SERVICE_TYPE_ID) != 0) {
			qry += " and patient.service_type_id = "
					+ box.getInt(SERVICE_TYPE_ID) + "";
		}
		if (box.getInt(SERVICE_STATUS_ID) != 0) {
			qry += " and patient.service_status_id = "
					+ box.getInt(SERVICE_STATUS_ID) + "";
		}
		if (box.getInt("fromRankId") != 0 && box.getInt("toRankId") != 0) {
			qry += " and patient.rank_id between " + box.getInt("fromRankId")
					+ " and " + box.getInt("toRankId");
		}
		if (box.getInt(RANK_CATEGORY_ID) != 0) {
			qry += " and mas_rank.rank_category_id = "
					+ box.getInt(RANK_CATEGORY_ID) + "";
		}
		if (box.getInt(TRADE_ID) != 0) {
			qry += " and patient.trade_id = " + box.getInt(TRADE_ID) + "";
		}
		if (box.getInt(UNIT_ID) != 0) {
			qry += " and patient.unit_id = " + box.getInt(UNIT_ID) + "";
		}
		if (box.getInt(SECTION_ID) != 0) {
			qry += " and patient.section_id = " + box.getInt(SECTION_ID) + "";
		}
		if (box.getInt(MARITAL_STATUS_ID) != 0) {
			qry += " and patient.marital_status_id = "
					+ box.getInt(MARITAL_STATUS_ID) + "";
		}
		if (box.getInt(SEX_ID) != 0) {
			qry += " and patient.sex_id = " + box.getInt(SEX_ID) + "";
		}
		if (!(box.getString(SERVICE_NO).equals(""))) {
			qry += " and patient.service_no='" + box.getString(SERVICE_NO)
					+ "'";
		}
		if (!(box.getString("fromAge").equals(""))
				&& !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals(""))
				&& !(box.getString("toAgeUnit").equals(""))) {
			String fromAge = box.getString("fromAge");
			String toAge = box.getString("toAge");
			qry += " and substr(patient.age,0,INSTR(patient.age,' ')) >="
					+ fromAge
					+ " "
					+ " and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"
					+ box.getString("fromAgeUnit")
					+ "'"
					+ " and substr(patient.age,0,INSTR(patient.age,' ')) <="
					+ toAge
					+ " "
					+ " and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"
					+ box.getString("toAgeUnit") + "'";

		}
		if (!(box.getString("fromServ").equals(""))
				&& !(box.getString("fromServUnit").equals(""))
				&& !(box.getString("toServ").equals(""))
				&& !(box.getString("toServUnit").equals(""))) {
			String fromServ = box.getString("fromServ");
			String toServ = box.getString("toServ");
			qry += " and patient.service_years >=" + fromServ + " "
					+ " and  total_service_period='"
					+ box.getString("fromServUnit") + "'"
					+ " and patient.service_years <=" + toServ + " "
					+ " and  total_service_period='"
					+ box.getString("toServUnit") + "'";

		}
		if (box.getInt(CONSULTING_DOCTOR) != 0) {
			qry += " and visit.doctor_id = " + box.getInt(CONSULTING_DOCTOR)
					+ "";
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		parameters.put("hospitalId", hospitalId);
		HMSUtil.generateReport("registrationStatistics", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showRegistrationStatisticsGraph(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = null;
		if (session.getAttribute("box") != null) {
			box = (Box) session.getAttribute("box");
		} else {
			box = HMSUtil.getBox(request);
		}
		box.put("hospitalId", hospitalId);
		map = registrationHandlerService.showOPDStatisticsGraph(box);
		List<Object[]> opdRegisterList = new ArrayList<Object[]>();
		opdRegisterList = (List<Object[]>) map.get("opdRegisterList");
		String ENCODING = "ISO-8859-1";
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_opd_data.xml")));

			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>");
			out.write("<chart>");
			int i = 0;
			out.write("<series>");
			for (Object[] object : opdRegisterList) {
				out.write("<value xid='"
						+ i
						+ "'>"
						+ HMSUtil
								.convertDateToStringWithoutTime((Date) object[0])
						+ "</value>");
				i++;
			}
			out.write("</series>");
			out.write("<graphs>");
			int j = 1;

			for (int k = 0; k < 5; k++) {

				out.write("<graph gid='" + k + "'>");
				int l = 0;
				for (Object[] objVal : opdRegisterList) {

					if (objVal[j] != null)
						out.write("<value xid='" + l + "' >" + objVal[j]
								+ "</value>");
					else
						out.write("<value xid='" + l + "' >0</value>");
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
		String jsp = "registrationStatisticsGraph";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView openPopupForInjectionIssue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		box.put("hospitalId", hospitalId);

		map = registrationHandlerService.getItemBatch(box);
		map.put("counter", box.getInt("counter"));
		map.put("flag", box.getString("flag"));

		String jsp = "issueInjectionPopup";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView issueInjectionFromReception(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int deptId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
			dataMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
			box.put("userName", user.getLoginName());
		}
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = registrationHandlerService.issueInjectionFromReception(box);
		boolean flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record Saved Successfully.";
		} else {
			message = "Try Again.";
		}
		// map = registrationHandlerService.showDMARegister(dataMap);
		map.put("message", message);
		String jsp = "issueInjectionPopup";
		return new ModelAndView(jsp, "map", map);
	}

	public void showReceptionHelp(HttpServletRequest request,
			HttpServletResponse response) {

		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome + fileSeparator + "help" + fileSeparator;

		try {

			response.setContentType("application/pdf");

			response.setHeader("Content-Disposition", "attachment;filename="
					+ java.net.URLEncoder.encode("Reception.pdf") + "");

			File f = new File(uploadURL + "/Reception.pdf");
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

	// ----By Kiran (Lifestyle Habits)

	public ModelAndView showLifestyleJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hinId = box.getInt("hinId");
		String hinNo = HMSUtil.restrictMetaChar(box.getString("hinNo"));
		int gender = box.getInt("gender");

		map = registrationHandlerService.showLifestyleJsp(box);
		String jsp = "lifeStyle";
		jsp += ".jsp"; // added by javed khan for CSRF on 10-03-2014
		map.put("contentJsp", jsp);
		map.put("hinId", hinId);
		map.put("hinNo", hinNo);
		map.put("gender", gender);
		// return new ModelAndView("indexPop","map",map); // added by javed khan
		// for CSRF on 10-03-2014
		return new ModelAndView("lifeStyle", "map", map); // added by javed khan
															// for CSRF on
															// 10-03-2014
	}

	public ModelAndView saveLifeStyleFactors(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.saveLifeStyleFactors(box);
		boolean flag = false;
		flag = (Boolean) map.get("flag");
		String message = "";
		if (flag) {
			message = "Record saved successfully.";
		} else {
			message = "Try Again.";
		}
		map.put("message", message);
		String jsp = "lifeStyle";
		return new ModelAndView(jsp, "map", map);
	}

	// ----------- By Mansi on 11 March 2013

	public void fillAVPilotRegServiceDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<AvPilotRegistrationDt> avPilotRegistrationDtList = new ArrayList<AvPilotRegistrationDt>();
		String serviceNo = "";

		try {
			if (request.getParameter("serviceNo") != null) {
				serviceNo = request.getParameter("serviceNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("serviceNo", serviceNo);
		map = registrationHandlerService.fillAVPilotRegServiceDetail(dataMap);

		if (map.get("avPilotRegistrationDtList") != null) {
			avPilotRegistrationDtList = (List) map
					.get("avPilotRegistrationDtList");
		}
		if (map.get("patientList") != null) {
			patientList = (List) map.get("patientList");
		}

		StringBuffer sb = new StringBuffer();
		try {

			if (avPilotRegistrationDtList.size() > 0) {
				sb.append("<items>");
				for (AvPilotRegistrationDt avPilotRegistrationDt : avPilotRegistrationDtList) {
					sb.append("<item>");
					if (avPilotRegistrationDt.getRank() != null) {
						sb.append("<rankId>"
								+ avPilotRegistrationDt.getRank().getId()
								+ "</rankId>");
					} else {

						sb.append("<rankId>-</rankId>");
					}
					String name = "";
					if (avPilotRegistrationDt.getFullName() != null) {
						name = avPilotRegistrationDt.getFullName();
					}
					sb.append("<sName>" + name + "</sName>");
					int hinId = 0;
					if (avPilotRegistrationDt.getId() != null
							&& avPilotRegistrationDt.getId() != 0) {
						hinId = avPilotRegistrationDt.getId();
					}
					sb.append("<pilotId>" + hinId + "</pilotId>");

					sb.append("<hinId>" + 0 + "</hinId>");

					String age = "";

					if (avPilotRegistrationDt.getAge() != null) {
						age = avPilotRegistrationDt.getAge();
					}
					sb.append("<age>" + age + "</age>");

					sb.append("</item>");
					break;
				}
				sb.append("</items>");

			} else {
				sb.append("<items>");
				for (Patient patient : patientList) {
					sb.append("<item>");
					if (patient.getRank() != null) {

						sb.append("<rankId>" + patient.getRank().getId()
								+ "</rankId>");
					} else {

						sb.append("<rankId>-</rankId>");
					}
					String name = "";
					name = patient.getPFirstName();
					if (patient.getPLastName() != null) {
						name = name + " " + patient.getPLastName();
					}
					sb.append("<sName>" + name + "</sName>");
					int hinId = 0;
					if (patient.getId() != null && patient.getId() != 0) {
						hinId = patient.getId();
					}
					sb.append("<hinId>" + hinId + "</hinId>");

					sb.append("<pilotId>" + 0 + "</pilotId>");

					String age = "";

					if (patient.getAge() != null) {
						age = patient.getAge();
					}
					sb.append("<age>" + age + "</age>");

					sb.append("</item>");
					break;
				}
				sb.append("</items>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void openLogs(HttpServletRequest request,
			HttpServletResponse response) {
		String fileSeparator = System.getProperty("file.separator");
		String userHome = getServletContext().getRealPath("")
				.substring(
						0,
						(getServletContext().getRealPath("")
								.lastIndexOf(fileSeparator)));
		String fileName = userHome.substring(0, 47) + "logs" + fileSeparator
				+ "server1" + fileSeparator + "SystemErr.log";
		// String fileName =
		// userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"logs"+fileSeparator+"localhost_access_log.2013-05-21.txt";
		FileInputStream stream = null;
		try {
			// Get the directory and iterate them to get file by file...
			File file = null;
			file = new File(fileName);
			System.out.println("filename--- " + file.getName());

			if (file.exists()) {
				response.setContentType("text/plain");
				response.setHeader("Content-Disposition", "attachment"
						+ "filename=" + file.getName());

				InputStream in = new FileInputStream(file);
				response.getOutputStream().flush();
				ServletOutputStream outs = response.getOutputStream();

				long length = file.length();

				// Create the byte array to hold the data
				byte[] bytes = new byte[(int) length];

				int offset = 0;
				int numRead = 0;
				while (offset < bytes.length
						&& (numRead = in.read(bytes, offset, bytes.length
								- offset)) >= 0) {
					offset += numRead;
				}

				if (offset < bytes.length) {
				}
				outs.write(bytes);
				in.close();

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void getIcdId(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> icdIdList = new ArrayList<Integer>();
		String icdNo = "";

		try {
			if (request.getParameter("icdNo") != null) {
				icdNo = request.getParameter("icdNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = registrationHandlerService.getIcdId(icdNo);
		if (map.get("icdIdList") != null) {
			icdIdList = (List<Integer>) map.get("icdIdList");
		}
		StringBuffer sb = new StringBuffer();
		try {

			sb.append("<items>");
			if (icdIdList.size() > 0) {
				sb.append("<item>");
				sb.append("<icdId>" + (Integer) icdIdList.get(0) + "</icdId>");
				sb.append("</item>");

			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ModelAndView showOPDRegisterFwcReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		Box box = null;
		if (session.getAttribute("box") != null) {
			box = (Box) session.getAttribute("box");
		} else {
			box = HMSUtil.getBox(request);
		}
		String qry = "";
		if (request.getParameter("cmdId") != null
				&& !request.getParameter("cmdId").equals("")
				&& !request.getParameter("cmdId").equals("0")
				&& request.getParameter("hospitalId") != null
				&& request.getParameter("hospitalId").equals("0")
				&& request.getParameter("hospitalId").equals("")) {

			qry += "  and hospital.command_id="
					+ Integer.parseInt(request.getParameter("cmdId"));
		} else {
			if (request.getParameter("hospitalId") != null
					&& !request.getParameter("hospitalId").equals("")
					&& !request.getParameter("hospitalId").equals("0")) {
				hospitalId = Integer.parseInt(request
						.getParameter("hospitalId"));
			} else {
				hospitalId = (Integer) session.getAttribute("hospitalId");
			}
			qry += "  and visit.hospital_id=" + hospitalId;
		}
		if (!box.getString(FROM_DATE).equals("")) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(box
					.getString(FROM_DATE));
		}

		if (!box.getString(TO_DATE).equals("")) {
			toDate = HMSUtil.convertStringTypeDateToDateType(box
					.getString(TO_DATE));
		}

		if (box.getInt(SERVICE_TYPE_ID) != 0) {
			qry += " and patient.service_type_id = "
					+ box.getInt(SERVICE_TYPE_ID) + "";
		}
		if (box.getInt(SERVICE_STATUS_ID) != 0) {
			qry += " and patient.service_status_id = "
					+ box.getInt(SERVICE_STATUS_ID) + "";
		}
		if (box.getInt("fromRankId") != 0 && box.getInt("toRankId") != 0) {
			qry += " and patient.rank_id between " + box.getInt("fromRankId")
					+ " and " + box.getInt("toRankId");
		}
		if (box.getInt(RANK_CATEGORY_ID) != 0) {
			qry += " and mas_rank.rank_category_id = "
					+ box.getInt(RANK_CATEGORY_ID) + "";
		}
		if (box.getInt(TRADE_ID) != 0) {
			qry += " and patient.trade_id = " + box.getInt(TRADE_ID) + "";
		}
		if (box.getInt(UNIT_ID) != 0) {
			qry += " and patient.unit_id = " + box.getInt(UNIT_ID) + "";
		}
		if (box.getInt(SECTION_ID) != 0) {
			qry += " and patient.section_id = " + box.getInt(SECTION_ID) + "";
		}
		if (box.getInt(MARITAL_STATUS_ID) != 0) {
			qry += " and patient.marital_status_id = "
					+ box.getInt(MARITAL_STATUS_ID) + "";
		}
		if (box.getInt(SEX_ID) != 0) {
			qry += " and patient.sex_id = " + box.getInt(SEX_ID) + "";
		}
		if (box.getInt(RELATION_ID) != 0) {
			qry += " and patient.relation_id = " + box.getInt(RELATION_ID) + "";
		}
		if (!(box.getString(SERVICE_NO).equals(""))) {
			qry += " and patient.service_no='"
					+ HMSUtil.restrictMetaChar(box.getString(SERVICE_NO)) + "'";
		}
		if (!(box.getString("fromAge").equals(""))
				&& !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals(""))
				&& !(box.getString("toAgeUnit").equals(""))) {
			String fromAge = box.getString("fromAge");
			String toAge = box.getString("toAge");
			qry += " and substr(patient.age,0,INSTR(patient.age,' ')) >="
					+ fromAge
					+ " "
					+ " and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"
					+ box.getString("fromAgeUnit")
					+ "'"
					+ " and substr(patient.age,0,INSTR(patient.age,' ')) <="
					+ toAge
					+ " "
					+ " and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"
					+ box.getString("toAgeUnit") + "'";

		}
		if (!(box.getString("fromServ").equals(""))
				&& !(box.getString("fromServUnit").equals(""))
				&& !(box.getString("toServ").equals(""))
				&& !(box.getString("toServUnit").equals(""))) {
			String fromServ = box.getString("fromServ");
			String toServ = box.getString("toServ");
			qry += " and patient.service_years >=" + fromServ + " "
					+ " and  total_service_period='"
					+ box.getString("fromServUnit") + "'"
					+ " and patient.service_years <=" + toServ + " "
					+ " and  total_service_period='"
					+ box.getString("toServUnit") + "'";

		}
		if (box.getInt(CONSULTING_DOCTOR) != 0) {
			qry += " and visit.doctor_id = " + box.getInt(CONSULTING_DOCTOR)
					+ "";
		}
		if (!(box.getString("icd").equals(""))) {
			String icd = box.getString("icd");
			int index1 = icd.lastIndexOf("[");
			int index2 = icd.lastIndexOf("]");
			index1++;
			int icdCode = Integer.parseInt("" + icd.substring(index1, index2));
			qry += " and icd.icd_id=" + icdCode + "";
		}
		if ((box.getInt("icdId") != 0)) {
			qry += " and icd.icd_id=" + box.getInt("icdId") + "";
		}

		if (!(box.getString("disposal").equals(""))) {
			qry += " and opd.disposal = '"
					+ HMSUtil.restrictMetaChar(box.getString("disposal")) + "'";
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		parameters.put("hospitalId", hospitalId);
		HMSUtil.generateReport("OPD STATISTICS_FWC", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public void checkPopUpForReg(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String patientName = "";
		int serviceTypeId = 0;
		int relationId = 0;
		int serviceStatusId = 0;
		String newHinNo = "";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<Patient> patientListForInfo = new ArrayList<Patient>();
		List<Patient> patientListForInfoHIS = new ArrayList<Patient>();
		if (request.getParameter("serviceNoId") != null) {
			serviceNo = request.getParameter("serviceNoId");
			parameterMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter("newHinNo") != null) {
			newHinNo = request.getParameter("newHinNo");
		}
		if (request.getParameter("serviceTypeId") != null) {
			serviceTypeId = Integer.parseInt(request
					.getParameter("serviceTypeId"));
			parameterMap.put("serviceTypeId", serviceTypeId);
		}

		if (request.getParameter("serviceStatusId") != null) {
			serviceStatusId = Integer.parseInt(request
					.getParameter("serviceStatusId"));
			parameterMap.put("serviceStatusId", serviceStatusId);
		}
		if (request.getParameter("relationId") != null) {
			relationId = Integer.parseInt(request.getParameter("relationId"));
			parameterMap.put("relationId", relationId);
		}
		Map<String, Object> detailMap = new HashMap<String, Object>();

		detailMap = registrationHandlerService.checkPopUpForReg(parameterMap);

		patientListForInfo = (List<Patient>) detailMap
				.get("patientListForInfo");
		patientListForInfoHIS = (List<Patient>) detailMap
				.get("patientListForInfoHIS");
		String popUP = "";
		if (patientListForInfo.size() > 0 || patientListForInfoHIS.size() > 0) {
			popUP = "yes";
		} else {
			popUP = "No";
		}

		StringBuffer sb = new StringBuffer();

		sb.append("<item>");
		sb.append("<popUP>" + popUP + "</popUP>");
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

	}

	public void checkPopUpForRegHAL(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String patientName = "";
		int serviceTypeId = 0;
		int relationId = 0;
		int serviceStatusId = 0;
		String newHinNo = "";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<Patient> patientListForInfo = new ArrayList<Patient>();
		List<Patient> patientListForInfoHIS = new ArrayList<Patient>();
		if (request.getParameter("serviceNoId") != null) {
			serviceNo = request.getParameter("serviceNoId");
			parameterMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter("newHinNo") != null) {
			newHinNo = request.getParameter("newHinNo");
		}
		if (request.getParameter("serviceTypeId") != null) {
			serviceTypeId = Integer.parseInt(request
					.getParameter("serviceTypeId"));
			parameterMap.put("serviceTypeId", serviceTypeId);
		}

		if (request.getParameter("serviceStatusId") != null) {
			serviceStatusId = Integer.parseInt(request
					.getParameter("serviceStatusId"));
			parameterMap.put("serviceStatusId", serviceStatusId);
		}
		if (request.getParameter("relationId") != null) {
			relationId = Integer.parseInt(request.getParameter("relationId"));
			parameterMap.put("relationId", relationId);
		}
		Map<String, Object> detailMap = new HashMap<String, Object>();

		detailMap = registrationHandlerService
				.checkPopUpForRegHAL(parameterMap);

		patientListForInfo = (List<Patient>) detailMap
				.get("patientListForInfo");
		patientListForInfoHIS = (List<Patient>) detailMap
				.get("patientListForInfoHIS");
		String popUP = "";
		if (patientListForInfo.size() > 0 || patientListForInfoHIS.size() > 0) {
			popUP = "yes";
		} else {
			popUP = "No";
		}

		StringBuffer sb = new StringBuffer();

		sb.append("<item>");
		sb.append("<popUP>" + popUP + "</popUP>");
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

	}

	public ModelAndView getServiceNORelationsPopUp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String patientName = "";
		int serviceTypeId = 0;
		int relationId = 0;
		int serviceStatusId = 0;
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<Patient> patientListForInfo = new ArrayList<Patient>();
		// List<Patient> patientListForInfoHIS = new ArrayList<Patient>();
		List<Object[]> patientListForInfoHIS = new ArrayList<Object[]>();
		List<MasRelation> masRelationList = new ArrayList<MasRelation>();
		if (request.getParameter("serviceNoId") != null) {
			serviceNo = request.getParameter("serviceNoId");
			parameterMap.put("serviceNo", serviceNo);
		}

		if (request.getParameter("serviceTypeId") != null) {
			serviceTypeId = Integer.parseInt(request
					.getParameter("serviceTypeId"));
			parameterMap.put("serviceTypeId", serviceTypeId);
		}

		if (request.getParameter("serviceStatusId") != null) {
			serviceStatusId = Integer.parseInt(request
					.getParameter("serviceStatusId"));
			parameterMap.put("serviceStatusId", serviceStatusId);
		}
		if (request.getParameter("relationId") != null) {
			relationId = Integer.parseInt(request.getParameter("relationId"));
			parameterMap.put("relationId", relationId);
		}
		Map<String, Object> detailMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		detailMap = registrationHandlerService
				.getRelationListForServiceNo(parameterMap);
		/* patientList = (List<Patient>) detailMap.get("patientList"); */
		patientListForInfo = (List<Patient>) detailMap
				.get("patientListForInfo");
		patientListForInfoHIS = (List<Object[]>) detailMap
				.get("patientListForInfoHIS");
		masRelationList = (List<MasRelation>) detailMap.get("masRelationList");
		// String jsp = "relationpopup";
		String jsp = "relationPopUpNew";
		map.put("patientList", patientList);
		map.put("masRelationList", masRelationList);
		map.put("patientListForInfo", patientListForInfo);
		map.put("patientListForInfoHIS", patientListForInfoHIS);
		map.put("serviceTypeId", serviceTypeId);
		map.put("relationIdForUpdate", relationId);
		map.put("serviceStatusId", serviceStatusId);
		map.put("serviceNo", serviceNo);
		return new ModelAndView(jsp, "map", map);
	}

	public void updateHinNo(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		String syncHMS = "no";
		String syncHIS = "no";
		String newHinNo = "";
		int relationIdForUpdate = 0;
		int serviceTypeId = 0;
		int serviceStatusId = 0;
		String serviceNo = "";

		HttpSession session = request.getSession(true);

		Box box = HMSUtil.getBox(request);

		if (box.getInt("relationIdForUpdate") != 0) {
			relationIdForUpdate = box.getInt("relationIdForUpdate");
		}
		if (box.getInt("serviceTypeId") != 0) {
			serviceTypeId = box.getInt("serviceTypeId");
		}
		if (box.getInt("serviceStatusId") != 0) {
			serviceStatusId = box.getInt("serviceStatusId");
		}
		if (box.getString("serviceNoForUpdate") != null
				&& !box.getString("serviceNoForUpdate").equals("")) {
			serviceNo = box.getString("serviceNoForUpdate");
		}
		// code for new hin Generation----->
		Map<String, Object> serviceAndRelationMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		parameterMap.put("serviceTypeId", serviceTypeId);
		parameterMap.put("relationId", relationIdForUpdate);
		parameterMap.put("serviceStatusId", serviceStatusId);

		serviceAndRelationMap = registrationHandlerService
				.getServiceTypeAndRelation(parameterMap);
		String relationCode = (String) serviceAndRelationMap
				.get("relationCode");
		String serviceTypeCode = (String) serviceAndRelationMap
				.get("serviceTypeCode");
		String serviceStatusCode = (String) serviceAndRelationMap
				.get("serviceStatusCode");

		if (!serviceNo.equals("0")) {
			newHinNo = serviceTypeCode.concat(serviceStatusCode)
					.concat(serviceNo).concat(relationCode)/*
															 * .concat(seqNo.
															 * toString())
															 */;
		}
		// end code for new hin generation---->
		dataMap.put("box", box);
		dataMap.put("newHinNo", newHinNo);

		map = registrationHandlerService.updateHinNo(dataMap);
		if (map.get("syncHMS") != null && !map.get("syncHMS").equals("")) {
			syncHMS = "" + map.get("syncHMS");
		}
		if (map.get("syncHIS") != null && !map.get("syncHMS").equals("")) {
			syncHIS = "" + map.get("syncHIS");
		}
		if (map.get("newHinNo") != null && !map.get("newHinNo").equals("")) {
			newHinNo = "" + map.get("newHinNo");
		}

		System.out.println("syncHMS=" + syncHMS);
		System.out.println("syncHIS=" + syncHIS);

		StringBuffer sb = new StringBuffer();

		sb.append("<item>");
		sb.append("<syncHMS>" + syncHMS + "</syncHMS>");
		sb.append("<syncHIS>" + syncHIS + "</syncHIS>");
		sb.append("<newHinNo>" + newHinNo + "</newHinNo>");
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

	}

	public ModelAndView showPendingForApprovalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String jsp = "";
		System.out.println("call method");
		jsp = "showPendingForApprovalJsp.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPatientVisitReferralJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String jsp = "";
		map = registrationHandlerService.getDepartmentList(hospitalId);
		System.out.println("call method");
		jsp = "showPatientVisitReferralJsp.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getListOfPendingForApproval(HttpServletRequest request,
			HttpServletResponse response)

	{

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<Patient> patientList = new ArrayList<Patient>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);

		map = registrationHandlerService.getListOfPendingForApproval(box);

		if (map.get("patientList") != null) {
			patientList = (ArrayList) map.get("patientList");
		}

		int totalRecords = 0;
		if (map.get("totalRecords") != null) {
			totalRecords = (Integer) map.get("totalRecords");
		}

		try {
			PrintWriter pw = response.getWriter();

			pw.write("[");
			int counter = 1;
			int i = 0;

			for (Patient list : patientList) {

				if (counter != patientList.size()) {
					String servicepatientName = "";
					if (list.getPFirstName() != null) {
						servicepatientName = list.getPFirstName();
					}

					if (list.getPMiddleName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPMiddleName();
					}
					if (list.getPLastName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPLastName();
					}

					pw.write("{\"Id\": \""
							+ list.getId()
							+ "\",\"registrationDate\": \""
							+ (list.getRegDate() != null ? HMSUtil
									.changeDateToddMMyyyy(list.getRegDate())
									: "")
							+ "\",\"age\": \""
							+ (list.getAge() != null ? list.getAge() : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSrSex() != null ? list.getSrSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"maritalStatus\": \""
							+ (list.getMaritalStatus() != null ? list
									.getMaritalStatus().getMaritalStatusName()
									: "-")
							+ "\",\"contactNo\":\""
							+ (list.getMobileNumber() != null ? list
									.getMobileNumber() : "")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"},");

				} else {
					String servicepatientName = "";
					if (list.getPFirstName() != null) {
						servicepatientName = list.getPFirstName();
					}

					if (list.getPMiddleName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPMiddleName();
					}
					if (list.getPLastName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPLastName();
					}

					pw.write("{\"Id\": \""
							+ list.getId()
							+ "\",\"registrationDate\": \""
							+ (list.getRegDate() != null ? HMSUtil
									.changeDateToddMMyyyy(list.getRegDate())
									: "")
							+ "\",\"age\": \""
							+ (list.getAge() != null ? list.getAge() : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSrSex() != null ? list.getSrSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"maritalStatus\": \""
							+ (list.getMaritalStatus() != null ? list
									.getMaritalStatus().getMaritalStatusName()
									: "-")
							+ "\",\"contactNo\":\""
							+ (list.getMobileNumber() != null ? list
									.getMobileNumber() : "")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");

				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			patientList.clear();

			e.printStackTrace();
		}
		patientList.clear();
		return null;

	}
	
	public ModelAndView getListOfPatientVisitReferral(HttpServletRequest request,
			HttpServletResponse response)

	{

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Patient list = new Patient();
		List<OpdPatientDetails> opdPatientDetailsList = new ArrayList<OpdPatientDetails>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);

		map = registrationHandlerService.getListOfPatientVisitReferral(box);

		if (map.get("opdPatientDetailsList") != null) {
			opdPatientDetailsList = (ArrayList) map.get("opdPatientDetailsList");
		}

		int totalRecords = 0;
		if (map.get("totalRecords") != null) {
			totalRecords = (Integer) map.get("totalRecords");
		}

		try {
			PrintWriter pw = response.getWriter();

			pw.write("[");
			int counter = 1;
			int i = 0;

			for (OpdPatientDetails opdPatientDetails : opdPatientDetailsList) {

				if (counter != opdPatientDetailsList.size()) {
					list = opdPatientDetails.getVisit().getHin();
					String servicepatientName = "";
					String referredByName = "";
					String referredToName = "";
					if (list.getPFirstName() != null) {
						servicepatientName = list.getPFirstName();
					}

					if (list.getPMiddleName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPMiddleName();
					}
					if (list.getPLastName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPLastName();
					}
					if (opdPatientDetails.getVisit().getDoctor().getFirstName() != null) {
						referredByName = opdPatientDetails.getVisit().getDoctor().getFirstName();
					}

					if (opdPatientDetails.getVisit().getDoctor().getMiddleName() != null) {
						referredByName = referredByName + " "
								+ opdPatientDetails.getVisit().getDoctor().getMiddleName();
					}
					if (opdPatientDetails.getVisit().getDoctor().getLastName() != null) {
						referredByName = referredByName + " "
								+ opdPatientDetails.getVisit().getDoctor().getLastName();
					}
					if (opdPatientDetails.getReferredDoctorInt().getFirstName() != null) {
						referredToName = opdPatientDetails.getReferredDoctorInt().getFirstName();
					}

					if (opdPatientDetails.getReferredDoctorInt().getMiddleName() != null) {
						referredToName = referredToName + " "
								+ opdPatientDetails.getReferredDoctorInt().getMiddleName();
					}
					if (opdPatientDetails.getReferredDoctorInt().getLastName() != null) {
						referredToName = referredToName + " "
								+ opdPatientDetails.getReferredDoctorInt().getLastName();
					}

					pw.write("{\"Id\": \""
							+ opdPatientDetails.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referralPriority\": \""
							+ (opdPatientDetails.getReferralPriority() != null ? opdPatientDetails.getReferralPriority(): "")
							+ "\",\"registrationDate\": \""
							+ (list.getRegDate() != null ? HMSUtil
									.changeDateToddMMyyyy(list.getRegDate())
									: "")		
							+ "\",\"age\": \""
							+ (list.getAge() != null ? list.getAge() : "")
							+ "\",\"refferedFromDept\": \""
							+ (opdPatientDetails.getVisit().getDepartment() != null ? opdPatientDetails.getVisit().getDepartment().getDepartmentName() : "")
							+ "\",\"refferedToDept\": \""
							+ (opdPatientDetails.getReferredDeptInt() != null ? opdPatientDetails.getReferredDeptInt().getDepartmentName() : "")
							+ "\",\"referredToDeptId\": \""
							+ (opdPatientDetails.getReferredDeptInt() != null ? opdPatientDetails.getReferredDeptInt().getId() : "")
							+ "\",\"referredToId\": \""
							+ (opdPatientDetails.getReferredDoctorInt() != null ? opdPatientDetails.getReferredDoctorInt().getId() : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSrSex() != null ? list.getSrSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"referredByName\": \""
							+ referredByName
							+ "\",\"referredToName\": \""
							+ referredToName
							+ "\",\"maritalStatus\": \""
							+ (list.getMaritalStatus() != null ? list
									.getMaritalStatus().getMaritalStatusName()
									: "-")
							+ "\",\"contactNo\":\""
							+ (list.getMobileNumber() != null ? list
									.getMobileNumber() : "")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"},");

				} else {
					list = opdPatientDetails.getVisit().getHin();
					String servicepatientName = "";
					String referredByName = "";
					String referredToName = "";
					if (list.getPFirstName() != null) {
						servicepatientName = list.getPFirstName();
					}

					if (list.getPMiddleName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPMiddleName();
					}
					if (list.getPLastName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPLastName();
					}
					if (opdPatientDetails.getVisit().getDoctor().getFirstName() != null) {
						referredByName = opdPatientDetails.getVisit().getDoctor().getFirstName();
					}

					if (opdPatientDetails.getVisit().getDoctor().getMiddleName() != null) {
						referredByName = referredByName + " "
								+ opdPatientDetails.getVisit().getDoctor().getMiddleName();
					}
					if (opdPatientDetails.getVisit().getDoctor().getLastName() != null) {
						referredByName = referredByName + " "
								+ opdPatientDetails.getVisit().getDoctor().getLastName();
					}
					if (opdPatientDetails.getReferredDoctorInt().getFirstName() != null) {
						referredToName = opdPatientDetails.getReferredDoctorInt().getFirstName();
					}

					if (opdPatientDetails.getReferredDoctorInt().getMiddleName() != null) {
						referredToName = referredToName + " "
								+ opdPatientDetails.getReferredDoctorInt().getMiddleName();
					}
					if (opdPatientDetails.getReferredDoctorInt().getLastName() != null) {
						referredToName = referredToName + " "
								+ opdPatientDetails.getReferredDoctorInt().getLastName();
					}

					pw.write("{\"Id\": \""
							+ opdPatientDetails.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referralPriority\": \""
							+ (opdPatientDetails.getReferralPriority() != null ? opdPatientDetails.getReferralPriority(): "")		
							+ "\",\"registrationDate\": \""
							+ (list.getRegDate() != null ? HMSUtil
									.changeDateToddMMyyyy(list.getRegDate())
									: "")		
							+ "\",\"age\": \""
							+ (list.getAge() != null ? list.getAge() : "")
							+ "\",\"refferedFromDept\": \""
							+ (opdPatientDetails.getVisit().getDepartment() != null ? opdPatientDetails.getVisit().getDepartment().getDepartmentName() : "")
							+ "\",\"refferedToDept\": \""
							+ (opdPatientDetails.getReferredDeptInt() != null ? opdPatientDetails.getReferredDeptInt().getDepartmentName() : "")
							+ "\",\"referredToDeptId\": \""
							+ (opdPatientDetails.getReferredDeptInt() != null ? opdPatientDetails.getReferredDeptInt().getId() : "")
							+ "\",\"referredToId\": \""
							+ (opdPatientDetails.getReferredDoctorInt() != null ? opdPatientDetails.getReferredDoctorInt().getId() : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSrSex() != null ? list.getSrSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"referredByName\": \""
							+ referredByName
							+ "\",\"referredToName\": \""
							+ referredToName
							+ "\",\"maritalStatus\": \""
							+ (list.getMaritalStatus() != null ? list
									.getMaritalStatus().getMaritalStatusName()
									: "-")
							+ "\",\"contactNo\":\""
							+ (list.getMobileNumber() != null ? list
									.getMobileNumber() : "")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");

				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			opdPatientDetailsList.clear();

			e.printStackTrace();
		}
		opdPatientDetailsList.clear();
		return null;

	}
	
	
	public ModelAndView showPendingOtherVisitJsp(HttpServletRequest request,
			HttpServletResponse response)

	{

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<Patient> patientList = new ArrayList<Patient>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);

		map = registrationHandlerService.showPendingOtherVisitJsp(box);

		if (map.get("patientList") != null) {
			patientList = (ArrayList) map.get("patientList");
		}

		int totalRecords = 0;
		if (map.get("totalRecords") != null) {
			totalRecords = (Integer) map.get("totalRecords");
		}

		try {
			PrintWriter pw = response.getWriter();

			pw.write("[");
			int counter = 1;
			int i = 0;

			for (Patient list : patientList) {

				if (counter != patientList.size()) {
					String servicepatientName = "";
					if (list.getPFirstName() != null) {
						servicepatientName = list.getPFirstName();
					}

					if (list.getPMiddleName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPMiddleName();
					}
					if (list.getPLastName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPLastName();
					}

					pw.write("{\"Id\": \""
							+ list.getId()
							+ "\",\"registrationDate\": \""
							+ (list.getRegDate() != null ? HMSUtil
									.changeDateToddMMyyyy(list.getRegDate())
									: "")
							+ "\",\"age\": \""
							+ (list.getAge() != null ? list.getAge() : "")
							+ "\",\"nok1Name\": \""
							+ (list.getNextOfKinName() != null ? list.getNextOfKinName() : "")
							+ "\",\"nok2Name\": \""
							+ (list.getNok2Name() != null ? list.getNok2Name() : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSrSex() != null ? list.getSrSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"maritalStatus\": \""
							+ (list.getMaritalStatus() != null ? list
									.getMaritalStatus().getMaritalStatusName()
									: "-")
							+ "\",\"contactNo\":\""
							+ (list.getMobileNumber() != null ? list
									.getMobileNumber() : "")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"},");

				} else {
					String servicepatientName = "";
					if (list.getPFirstName() != null) {
						servicepatientName = list.getPFirstName();
					}

					if (list.getPMiddleName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPMiddleName();
					}
					if (list.getPLastName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPLastName();
					}

					pw.write("{\"Id\": \""
							+ list.getId()
							+ "\",\"registrationDate\": \""
							+ (list.getRegDate() != null ? HMSUtil
									.changeDateToddMMyyyy(list.getRegDate())
									: "")
							+ "\",\"age\": \""
							+ (list.getAge() != null ? list.getAge() : "")
							+ "\",\"nok1Name\": \""
							+ (list.getNextOfKinName() != null ? list.getNextOfKinName() : "")
							+ "\",\"nok2Name\": \""
							+ (list.getNok2Name() != null ? list.getNok2Name() : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSrSex() != null ? list.getSrSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"maritalStatus\": \""
							+ (list.getMaritalStatus() != null ? list
									.getMaritalStatus().getMaritalStatusName()
									: "-")
							+ "\",\"contactNo\":\""
							+ (list.getMobileNumber() != null ? list
									.getMobileNumber() : "")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");

				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			patientList.clear();

			e.printStackTrace();
		}
		patientList.clear();
		return null;

	}
	public ModelAndView getListOnlinePatients(HttpServletRequest request,
			HttpServletResponse response)

	{

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		List<AppPatientAppointments> aPAppointmentList = new ArrayList<AppPatientAppointments>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);

		map = registrationHandlerService.getListOnlinePatients(box);

		if (map.get("aPAppointmentList") != null) {
			aPAppointmentList = (ArrayList) map.get("aPAppointmentList");
		}

		int totalRecords = 0;
		if (map.get("totalRecords") != null) {
			totalRecords = (Integer) map.get("totalRecords");
		}
		String src = "";

		try {
			PrintWriter pw = response.getWriter();

			pw.write("[");
			int counter = 1;
			int i = 0;

			for (AppPatientAppointments aPAppointment : aPAppointmentList) {
                 Patient list = aPAppointment.getHin();
                 if(list.getRelation().getRelationName().equalsIgnoreCase(map.get("selfRelationName").toString()))
                 {
                	 src = "/hms/hms/personnel?method=displayImageCommon&amp;employeeId="+list.getEmployee().getId();
                 }
                 else
                 {
                	 src = "/hms/hms/personnel?method=displayImageCommon&amp;employeeId="+list.getEmployee().getId()+"&relationId="+list.getRelation().getId();
                 }
				if (counter != aPAppointmentList.size()) {
					String servicepatientName = "";
					String doctorName = "";
					if (list.getPFirstName() != null) {
						servicepatientName = list.getPFirstName();
					}

					if (list.getPMiddleName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPMiddleName();
					}
					if (list.getPLastName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPLastName();
					}
					if (aPAppointment.getEmployee().getFirstName() != null) {
						doctorName = aPAppointment.getEmployee().getFirstName();
					}

					if (aPAppointment.getEmployee().getMiddleName() != null) {
						doctorName = doctorName + " "
								+ aPAppointment.getEmployee().getMiddleName();
					}
					if (aPAppointment.getEmployee().getLastName() != null) {
						doctorName = doctorName + " "
								+ aPAppointment.getEmployee().getLastName();
					}

					pw.write("{\"aPAId\": \""
							+ aPAppointment.getId()
							+ "\",\"registrationDate\": \""
							+ (list.getRegDate() != null ? HMSUtil
									.changeDateToddMMyyyy(list.getRegDate())
									: "")
							+ "\",\"appointmentDate\": \""
							+ (aPAppointment.getAppointmentDate() != null ? HMSUtil
									.changeDateToddMMyyyy(aPAppointment.getAppointmentDate())
									: "")		
							+ "\",\"appDepartment\": \""
							+ (aPAppointment.getDepartment() != null ? aPAppointment.getDepartment().getDepartmentName() : "")
							+ "\",\"appointmentSlot\": \""
							+ (aPAppointment.getFromTimeSlot() != null ? aPAppointment.getFromTimeSlot() : "") + " to " + (aPAppointment.getToTimeSlot() != null ? aPAppointment.getToTimeSlot() : "")
							+ "\",\"doctorName\": \""
							+ (doctorName)
							+ "\",\"src\": \""
							+ (src)
							+ "\",\"appSession\": \""
							+ (aPAppointment.getAppSession() != null ? aPAppointment.getAppSession().getSessionName() : "")							
							+ "\",\"appDepartmentId\": \""
							+ (aPAppointment.getDepartment() != null ? aPAppointment.getDepartment().getId() : "")
							+ "\",\"doctorId\": \""
							+ (aPAppointment.getEmployee() != null ? aPAppointment.getEmployee().getId() : "")
							+ "\",\"appSessionId\": \""
							+ (aPAppointment.getAppSession() != null ? aPAppointment.getAppSession().getId() : "")
							+ "\",\"tokenNo\": \""
							+ (aPAppointment.getServicePersonName() != null ? aPAppointment.getServicePersonName() : "")  //inserted queue preority value in service_person_name column temporarly becaue queue priority type is int and it can't store string message
							+ "\",\"newRelation\": \""
							+ (list.getRelation() != null ? list.getRelation().getNewRelationName() : "")
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getAge() != null ? list.getAge() : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"TokenNo\": \""
							+ (aPAppointment.getQueuePriority() != null ? aPAppointment.getQueuePriority() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"maritalStatus\": \""
							+ (list.getMaritalStatus() != null ? list
									.getMaritalStatus().getMaritalStatusName()
									: "-")
							+ "\",\"contactNo\":\""
							+ (list.getMobileNumber() != null ? list
									.getMobileNumber() : "")
							+ "\",\"relationId\":\""
							+ (list.getRelation() != null ? list
									.getRelation().getId() : "")	
							+ "\",\"serviceNo\":\""
							+ (list.getServiceNo() != null ? list
									.getServiceNo() : "")		
							+ "\",\"totalRecords\":\"" + totalRecords + "\"},");

				} else {
					String servicepatientName = "";
					String doctorName = "";
					if (list.getPFirstName() != null) {
						servicepatientName = list.getPFirstName();
					}

					if (list.getPMiddleName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPMiddleName();
					}
					if (list.getPLastName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPLastName();
					}
					if (aPAppointment.getEmployee().getFirstName() != null) {
						doctorName = aPAppointment.getEmployee().getFirstName();
					}

					if (aPAppointment.getEmployee().getMiddleName() != null) {
						doctorName = doctorName + " "
								+ aPAppointment.getEmployee().getMiddleName();
					}
					if (aPAppointment.getEmployee().getLastName() != null) {
						doctorName = doctorName + " "
								+ aPAppointment.getEmployee().getLastName();
					}

					pw.write("{\"aPAId\": \""
							+ aPAppointment.getId()
							+ "\",\"registrationDate\": \""
							+ (list.getRegDate() != null ? HMSUtil
									.changeDateToddMMyyyy(list.getRegDate())
									: "")
							+ "\",\"appointmentDate\": \""
							+ (aPAppointment.getAppointmentDate() != null ? HMSUtil
									.changeDateToddMMyyyy(aPAppointment.getAppointmentDate())
									: "")		
							+ "\",\"appDepartment\": \""
							+ (aPAppointment.getDepartment() != null ? aPAppointment.getDepartment().getDepartmentName() : "")
							+ "\",\"appointmentSlot\": \""
							+ (aPAppointment.getFromTimeSlot() != null ? aPAppointment.getFromTimeSlot() : "") + " to " + (aPAppointment.getToTimeSlot() != null ? aPAppointment.getToTimeSlot() : "")
							+ "\",\"doctorName\": \""
							+ (doctorName)
							+ "\",\"src\": \""
							+ (src)
							+ "\",\"appSession\": \""
							+ (aPAppointment.getAppSession() != null ? aPAppointment.getAppSession().getSessionName() : "")							
							+ "\",\"appDepartmentId\": \""
							+ (aPAppointment.getDepartment() != null ? aPAppointment.getDepartment().getId() : "")
							+ "\",\"doctorId\": \""
							+ (aPAppointment.getEmployee() != null ? aPAppointment.getEmployee().getId() : "")
							+ "\",\"appSessionId\": \""
							+ (aPAppointment.getAppSession() != null ? aPAppointment.getAppSession().getId() : "")
							+ "\",\"tokenNo\": \""
							+ (aPAppointment.getServicePersonName() != null ? aPAppointment.getServicePersonName() : "") //inserted queue preority value in service_person_name column temporarly becaue queue priority type is int and it can't store string message
							+ "\",\"newRelation\": \""
							+ (list.getRelation() != null ? list.getRelation().getNewRelationName() : "")
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getAge() != null ? list.getAge() : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"TokenNo\": \""
							+ (aPAppointment.getQueuePriority() != null ? aPAppointment.getQueuePriority() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"maritalStatus\": \""
							+ (list.getMaritalStatus() != null ? list
									.getMaritalStatus().getMaritalStatusName()
									: "-")
							+ "\",\"contactNo\":\""
							+ (list.getMobileNumber() != null ? list
									.getMobileNumber() : "")
							+ "\",\"relationId\":\""
							+ (list.getRelation() != null ? list
									.getRelation().getId() : "")	
							+ "\",\"serviceNo\":\""
							+ (list.getServiceNo() != null ? list
									.getServiceNo() : "")		
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			aPAppointmentList.clear();

			e.printStackTrace();
		}
		aPAppointmentList.clear();
		return null;

	}
	

	public ModelAndView submitPendingForApproval(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String jsp = "";
		map = registrationHandlerService.submitPendingForApproval(request);
		boolean successfullyupdated = false;
		if (map.get("successfullyupdated") != null) {
			successfullyupdated = (Boolean) map.get("successfullyupdated");
		}
		String message;
		if (successfullyupdated == true) {

			message = "Patient Information Updated Successfully.";
		} else {
			message = "Some problem Occured! Try Again.";
		}
		map.put("message", message);
		jsp = "showPendingForApprovalJsp.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitReferral(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String jsp = "";
		String message = "";
		map = registrationHandlerService.submitReferral(request);
		boolean succesfullyAdded = false;
		if (map.get("succesfullyAdded") != null) {
			succesfullyAdded = (Boolean) map.get("succesfullyAdded");
		}
		
		if (succesfullyAdded == true) {

			message = "Patient Referred Successfully.";
		} else {
			message = (String)map.get("msg");
			if(!message.trim().equals(""))
			{
				message  = message;
			}
			else
			{
				message = "Some problem Occured! Try Again.";
			}
			
		}		
		map.putAll(registrationHandlerService.getDepartmentList(hospitalId));
		map.put("message", message);
		jsp = "msgForReferralOfHALEmployees.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showVisitList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> datamap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=0;
		Box box = HMSUtil.getBox(request);
		//int departmentId=box.getInt(DEPARTMENT_ID);

		HttpSession session = request.getSession();
		if (box.getInt(DEPARTMENT_ID) == 0) {
			box.put(DEPARTMENT_ID, (Integer) session.getAttribute("deptId"));
		}

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		
		
		datamap = registrationHandlerService.getDepartmentList(hospitalId);
		if(datamap.get("departmentList") != null)
		{
			map.put("departmentList", datamap.get("departmentList"));
		}
		
		if(datamap.get("sessionList") != null)
		{
			map.put("sessionList", datamap.get("sessionList"));
		}
		String jsp="";
		
		
		jsp = "visitListforReception";
		jsp += ".jsp";
		
		map.put("contentJsp", jsp);	
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView getOPDVisitList(HttpServletRequest request,HttpServletResponse response)
	{

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int deptId = (Integer) session.getAttribute("deptId");
		
		List<Visit> visitList = new ArrayList<Visit>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);
	//	box.put("deptId", deptId);


		map = registrationHandlerService.getOPDVisitList(box);

		if (map.get("visitList") != null) {
			visitList = (List<Visit>) map.get("visitList");
		}

		int totalRecords = visitList.size();
		if (map.get("totalRecords") != null) {
			totalRecords = (Integer) map.get("totalRecords");
		}

		try {
			PrintWriter pw = response.getWriter();

			pw.write("[");
			int counter = 1;
			int i = 0;

			for (Visit list : visitList) {

				if (counter != visitList.size()) {
					

					pw.write("{\"Id\": \""
							+ list.getId()
							+"\",\"HinNo\": \""
							+ (list.getHin().getHinNo() != null ? list.getHin().getHinNo() : "")
							+ "\",\"EmployeeNo\": \""
							+ (list.getHin().getServiceNo() != null ? list.getHin().getServiceNo() : "")
							+ "\",\"PatientName\": \""
							+ (list.getHin().getPFirstName() != null ? list.getHin().getPFirstName() : "")
							+ "\",\"Relation\": \""
							+ (list.getHin().getRelation()!= null ? list.getHin().getRelation().getRelationName() : "")
							+ "\",\"Gender\": \""
							+ (list.getHin().getSex()!= null ? list.getHin().getSex().getAdministrativeSexName() : "")
							+ "\",\"Department\": \""
							+ (list.getDepartment() != null ? list.getDepartment().getDepartmentName() : "")
							+ "\",\"IntDoctor\": \""
							+ (list.getIntDoctor() != null ? list.getIntDoctor().getFirstName() : "")
							+ "\",\"Doctor\": \""
							+ (list.getDoctor() != null ? list.getDoctor().getFirstName() : "")
							+ "\",\"Session\": \""
							+ (list.getSession() != null ? list.getSession().getSessionName() : "")
							+ "\",\"Token\": \""
							+ (list.getTokenNo() != null ? list.getTokenNo() : "")
							+ "\",\"totalRecords\": \""
							+ totalRecords
							+ "\",\"Status\": \""
							+ (list.getVisitStatus() != null ? list.getVisitStatus() : "")							
							+ "\"},");

				} else {
					pw.write("{\"Id\": \""
							+ list.getId()
							+"\",\"HinNo\": \""
							+ (list.getHin().getHinNo() != null ? list.getHin().getHinNo() : "")
							+ "\",\"EmployeeNo\": \""
							+ (list.getHin().getServiceNo() != null ? list.getHin().getServiceNo() : "")
							+ "\",\"PatientName\": \""
							+ (list.getHin().getPFirstName() != null ? list.getHin().getPFirstName() : "")
							+ "\",\"Relation\": \""
							+ (list.getHin().getRelation()!= null ? list.getHin().getRelation().getRelationName() : "")
							+ "\",\"Gender\": \""
							+ (list.getHin().getSex()!= null ? list.getHin().getSex().getAdministrativeSexName() : "")
							+ "\",\"Department\": \""
							+ (list.getDepartment() != null ? list.getDepartment().getDepartmentName() : "")
							+ "\",\"IntDoctor\": \""
							+ (list.getIntDoctor() != null ? list.getIntDoctor().getFirstName() : "")
							+ "\",\"Doctor\": \""
							+ (list.getDoctor() != null ? list.getDoctor().getFirstName() : "")
							+ "\",\"Session\": \""
							+ (list.getSession() != null ? list.getSession().getSessionName() : "")
							+ "\",\"Token\": \""
							+ (list.getTokenNo() != null ? list.getTokenNo() : "")
							+ "\",\"totalRecords\": \""
							+ totalRecords
							+ "\",\"Status\": \""
							+ (list.getVisitStatus() != null ? list.getVisitStatus() : "")							
							+ "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			visitList.clear();

			e.printStackTrace();
		}
		visitList.clear();
		return null;

	}
	
	public synchronized ModelAndView TransferPatientVisitList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> datamap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=0;
		Box box = HMSUtil.getBox(request);
		int departmentId=box.getInt(DEPARTMENT_ID);
System.out.println("here");
		HttpSession session = request.getSession();
	/*	if (box.getInt(DEPARTMENT_ID) == 0) {
			map.put(DEPARTMENT_ID, (Integer) session.getAttribute("deptId"));
		}*/

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			map.put("hospitalId", hospitalId);
		}
		map.put("request", request);
		System.out.println("request request"+request);
		map.put("box", box);
		String msg= null;
		datamap = registrationHandlerService.transferPatientVisitList(map);
		if(datamap.get("msg")!=null)
			msg = (String)datamap.get("msg");
		datamap = registrationHandlerService.getDepartmentList(hospitalId);
		if(datamap.get("departmentList") != null)
		{
			map.put("departmentList", datamap.get("departmentList"));
		}
		if(datamap.get("sessionList") != null)
		{
			map.put("sessionList", datamap.get("sessionList"));
		}
		String jsp="";
		
		
		jsp = "visitListforReception";
		jsp += ".jsp";
		
		map.put("contentJsp", jsp);	
		map.put("msg", msg);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView showPatientAppointmentList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> datamap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=0;
		Box box = HMSUtil.getBox(request);
		int departmentId=box.getInt(DEPARTMENT_ID);

		HttpSession session = request.getSession();
		if (box.getInt(DEPARTMENT_ID) == 0) {
			box.put(DEPARTMENT_ID, (Integer) session.getAttribute("deptId"));
		}

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		
		
		/*datamap = registrationHandlerService.getDepartmentList(hospitalId);
		if(datamap.get("departmentList") != null)
		{
			map.put("departmentList", datamap.get("departmentList"));
		}*/
		String jsp="";
		
		
		jsp = "patientAppointmentList";
		jsp += ".jsp";
		
		map.put("contentJsp", jsp);	
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView getPatientAppointmentList(HttpServletRequest request,HttpServletResponse response)
	{

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int deptId = (Integer) session.getAttribute("deptId");
		int empId = (Integer) session.getAttribute("empId");
		
		List<AppPatientAppointments> patientList = new ArrayList<AppPatientAppointments>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		box.put("empId", empId);


		map = registrationHandlerService.getPatientAppointmentList(box);

		if (map.get("patientList") != null) {
			patientList = (List<AppPatientAppointments>) map.get("patientList");
		}

		int totalRecords = 0;
		if (map.get("totalRecords") != null) {
			totalRecords = (Integer) map.get("totalRecords");
		}

		try {
			PrintWriter pw = response.getWriter();

			pw.write("[");
			int counter = 1;
			int i = 0;

			for (AppPatientAppointments list : patientList) {

				if (counter != patientList.size()) {
					

					pw.write("{\"Id\": \""
							+ list.getId()
							+ "\",\"EmployeeNo\": \""
							+ (list.getHin().getServiceNo() != null ? list.getHin().getServiceNo() : "")
							+ "\",\"PatientName\": \""
							+ (list.getHin().getPFirstName() != null ? list.getHin().getPFirstName() : "")
							+ "\",\"Relation\": \""
							+ (list.getHin().getRelation()!= null ? list.getHin().getRelation().getRelationName() : "")
							+ "\",\"Gender\": \""
							+ (list.getHin().getSex()!= null ? list.getHin().getSex().getAdministrativeSexName() : "")
							+ "\",\"Department\": \""
							+ (list.getDepartment() != null ? list.getDepartment().getDepartmentName() : "")
							+ "\",\"AppointmentDate\": \""
							+ (list.getAppointmentDate() != null ? HMSUtil.changeDateToddMMyyyy(list.getAppointmentDate()) : "")
							+ "\",\"Session\": \""
							+ (list.getAppSession() != null ? list.getAppSession().getSessionName() : "")
							+ "\",\"Token\": \""
							+ (list.getQueuePriority() != null ? list.getQueuePriority() : "")
							+ "\",\"totalRecords\": \""
							+ totalRecords
							+ "\",\"From Time\": \""
							+ (list.getFromTimeSlot() != null ? list.getFromTimeSlot() : "")							
							+ "\"},");

				} else {
					pw.write("{\"Id\": \""
							+ list.getId()
							+ "\",\"EmployeeNo\": \""
							+ (list.getHin().getServiceNo() != null ? list.getHin().getServiceNo() : "")
							+ "\",\"PatientName\": \""
							+ (list.getHin().getPFirstName() != null ? list.getHin().getPFirstName() : "")
							+ "\",\"Relation\": \""
							+ (list.getHin().getRelation()!= null ? list.getHin().getRelation().getRelationName() : "")
							+ "\",\"Gender\": \""
							+ (list.getHin().getSex()!= null ? list.getHin().getSex().getAdministrativeSexName() : "")
							+ "\",\"Department\": \""
							+ (list.getDepartment() != null ? list.getDepartment().getDepartmentName() : "")
							+ "\",\"AppointmentDate\": \""
							+ (list.getAppointmentDate() != null ? HMSUtil.changeDateToddMMyyyy(list.getAppointmentDate()) : "")
							+ "\",\"Session\": \""
							+ (list.getAppSession() != null ? list.getAppSession().getSessionName() : "")
							+ "\",\"Token\": \""
							+ (list.getQueuePriority() != null ? list.getQueuePriority() : "")
							+ "\",\"totalRecords\": \""
							+ totalRecords
							+ "\",\"From Time\": \""
							+ (list.getFromTimeSlot() != null ? list.getFromTimeSlot() : "")							
							+ "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			patientList.clear();

			e.printStackTrace();
		}
		patientList.clear();
		return null;

	}


}
