package jkt.hms.physiotherapy.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID;
import static jkt.hms.util.RequestConstants.RANK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SECTION_ID;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_STATUS_ID;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEX_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.UNIT_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;

import jkt.hms.adt.handler.RegistrationHandlerService;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasTherapyType;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.physiotherapy.handler.PhysiotherapyHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PhysiotherapyController extends MultiActionController {
	
	PhysiotherapyHandlerService physiotherapyHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	RegistrationHandlerService registrationHandlerService = null;


	public ModelAndView showTherapyTypeJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = physiotherapyHandlerService.showTherapyTypeJsp();
		String jsp="therapyType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView searchTherapyType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String therapyTypeCode  = null;
		String therapyTypeName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			therapyTypeCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			therapyTypeName = request.getParameter(SEARCH_NAME);
		}

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
			therapyTypeCode=searchField;
			therapyTypeName=null;

		}else{
			therapyTypeCode=null;
			therapyTypeName=searchField;
		}
		map = physiotherapyHandlerService.searchTherapyType(therapyTypeCode, therapyTypeName);

		String jsp="therapyType";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("therapyTypeCode",therapyTypeCode);
		map.put("therapyTypeName",therapyTypeName);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addTherapyType(HttpServletRequest request, HttpServletResponse response) 
	{
		
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String code ="";
		String name = "";
		String currentTime = "";
		String pojoName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		
		HttpSession session = request.getSession();
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		
		if(request.getParameter("pojoPropertyCode") != null){
			pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);


		List therapyTypeCodeList = new ArrayList();
		List therapyTypeNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			therapyTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			therapyTypeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		String message = "";
		if((therapyTypeCodeList.size() == 0 || therapyTypeCodeList == null) && (therapyTypeNameList.size() == 0 || therapyTypeNameList == null))
		{
			MasTherapyType therapyType = new MasTherapyType();
			therapyType.setTherapyTypeCode(code.trim());
			therapyType.setTherapyTypeName(name.trim());
			therapyType.setStatus("y");
			Users chgBy = new Users();
			Users user = (Users)session.getAttribute("users");
			chgBy.setId(user.getId());
			therapyType.setLastChgBy(chgBy);
			therapyType.setLastChgDate(currentDate);
			therapyType.setLastChgTime(currentTime);
			successfullyAdded = physiotherapyHandlerService.addTherapyType(therapyType);		
			
			if(successfullyAdded){
				message="Record Added Successfully !!";
			}
			else{
				message="Try Again !!";
			}
		}

		else if((therapyTypeCodeList.size() != 0 || therapyTypeCodeList != null) || (therapyTypeNameList.size() != 0) || therapyTypeNameList != null)
		{
			if((therapyTypeCodeList.size() != 0 || therapyTypeCodeList != null) && (therapyTypeNameList.size() == 0 || therapyTypeNameList == null)){

				message = "Therapy Type Code  already exists.";
			}
			else if((therapyTypeNameList.size() != 0 || therapyTypeNameList != null) && (therapyTypeCodeList.size() == 0 || therapyTypeCodeList == null) ){

				message = "Therapy Type Name already exists.";
			}
			else if((therapyTypeCodeList.size() != 0 || therapyTypeCodeList != null) && (therapyTypeNameList.size() != 0 || therapyTypeNameList != null)){

				message = "Therapy Type Code and Therapy Type Name already exist.";
			}
		}
		
		try{
			map = physiotherapyHandlerService.showTherapyTypeJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		String jsp="therapyType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView editTherapyType(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String therapyTypeCode="";
		String therapyTypeName="";
		int therapyTypeId	=0;
		String changedTime = "";
		String pojoName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		
		HttpSession session = request.getSession();
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			therapyTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null) {
			therapyTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			therapyTypeName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		
		if(request.getParameter("pojoPropertyCode") != null){
			pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		}
		Users user = (Users)session.getAttribute("users");

		generalMap.put("id", therapyTypeId);
		generalMap.put("code", therapyTypeCode);
		generalMap.put("name", therapyTypeName);
		generalMap.put("userId", user.getId());
		generalMap.put("currentDate", currentDate);
		generalMap.put("changedTime", changedTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
    	generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingTitleNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  String message = "";
		  if(existingTitleNameList.size() == 0)
		  {
			  dataUpdated=physiotherapyHandlerService.editTherapyType(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
		}else if(existingTitleNameList.size() > 0){
			   message = "Name already exists.";
		}
		map = physiotherapyHandlerService.showTherapyTypeJsp();
		String jsp="therapyType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteTherapyType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int therapyTypeId=0;
		String message="";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		HttpSession session = request.getSession();
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			therapyTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
		Users user = (Users)session.getAttribute("users");
		generalMap.put("userId", user.getId());
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=physiotherapyHandlerService.deleteTherapyType(therapyTypeId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		map = physiotherapyHandlerService.showTherapyTypeJsp();
		String jsp="therapyType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView showPhysiotherapyWaitingList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		mapForDS.put("currentDate", currentDate);
		mapForDS.put("hospitalId", hospitalId);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		
		map = physiotherapyHandlerService.getPhyWaitingList(mapForDS);
		map1 = physiotherapyHandlerService.getDetailsForPhysiotherapy(box);
	    List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		doctorList = (List<MasEmployee>)map1.get("doctorList");
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = (List<MasDepartment>)map1.get("searchMasDepartmentList");
		List<MasTherapyType> therapyTypeList = new ArrayList<MasTherapyType>();
		therapyTypeList = (List<MasTherapyType>)map1.get("therapyTypeList");
		map.put("therapyTypeList",therapyTypeList);
		map.put("departmentList",departmentList);
		map.put("doctorList", doctorList);
		String jsp = "phy_waitingList";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchPhyWaitingListJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = physiotherapyHandlerService.searchPhyWaitingListJsp(box);
		String jsp = "phy_waitingList";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPhysiotherapyVisitAppointmentJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = physiotherapyHandlerService.getDetailsForPhysiotherapyVisitForAppointement(box);
		
		String jsp = "physiotherapyVisitEntryForAppointment";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showPhysiotherapyJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = physiotherapyHandlerService.getDetailsForPhysiotherapy(box);
		
		String jsp = "physiotherapyVisitEntry";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showDirectTherapyVisitEntryJps(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> visitMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = physiotherapyHandlerService.showDirectTherapyVisitEntryJps(box);
		visitMap = physiotherapyHandlerService.showPhysiotherapyVisitWaitingList(hospitalId);
		map.put("visitMap", visitMap);
		String jsp = "therapyVisitEntryDirect";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getPatientDetailsFordirectVisitEntry(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String serviceNo = box.getString("serviceNo");
		map = physiotherapyHandlerService.getPatientDetailsFordirectVisitEntry(serviceNo);
		
		String jsp = "responseForTherapyHinNo";
		//String jsp = "responseForDirectVisitEntry";
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getPatientData(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hinId = 0;
		 hinId = box.getInt("hinId");
		box.put("hinId", hinId);
		map = physiotherapyHandlerService.getPatientDetails(box);
		
		String jsp = "responseForDirectVisitEntry";
		return new ModelAndView(jsp, "map", map);
	}
	
	

	public ModelAndView getTherapyTypeListForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String therapyNameField = "";
		String jsp = "";
		int deptId = 0;
		String autoHint = "";

		try {
			if (request.getParameter("requiredField") != null) {
				therapyNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(therapyNameField) != null) {
				autoHint = (request.getParameter(therapyNameField));
			}
			
			generalMap.put("autoHint", autoHint);
			map = physiotherapyHandlerService.getTherapyTypeListForAutoComplete(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseForPhysiotherapyDetails";

		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView savePhysiotherapyDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		Users user = (Users)session.getAttribute("users");
		box.put("userId", user.getId());
		int physioRequisitionHeaderId = 0;
		String jsp = "";
		int hinId = 0;
		if(box.getInt("hinId") != 0){
			hinId = box.getInt("hinId");
		}
		box.put("hinId", hinId);
		
		map = physiotherapyHandlerService.savePhysiotherapyDetails(box);
		boolean saved = false;
		boolean appointmentFlag = false;
		if(map.get("saved")!=null){
			saved = (Boolean)map.get("saved");
		}
		
		System.out.println("saved-------cntrl--->>"+saved);
		if(map.get("appointmentFlag")!=null){
			appointmentFlag = (Boolean)map.get("appointmentFlag");
		}
		
		String message="";
		if(saved==true){
			if(appointmentFlag){
				message = "Record Saved Successfully. Do you want to give appointment?";
			}else{
			message = "Record Saved Successfully.!";
			}
		}else{
			message = "Some Problem Occurred";
		}
		
		 jsp = "therapyMessage";
		map.put("message", message);
		map.put("physioRequisitionHeaderId", box.getInt("physioRequisitionHeaderId"));
		map.put("appointmentFlag", appointmentFlag);
		map.put("hinId", hinId);
		map.put("flag", box.getString("flag"));
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveVisitEntryForAppointmentDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		Users user = (Users)session.getAttribute("users");
		box.put("userId", user.getId());
		map = physiotherapyHandlerService.saveVisitEntryForAppointmentDetails(box);
		boolean flag = false;
		if(map.get("flag")!=null){
			flag = (Boolean)map.get("flag");
		}
		String message="";
		if(flag){
			message = "Record Saved Successfully!!";
		}else{
			message = "Some Problem Occurred";
		}
		map.put("messageTOBeVisibleToTheUser", message);
		String jsp = "message";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView cancelPhysioTheraphyAppointment(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "phy_waitingList.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}	
	
	

	public ModelAndView showPhyTreatmentRegisterJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = physiotherapyHandlerService.showPhyTreatmentRegisterJsp(hospitalId);
		String jsp = "PhysiotherapyTreatmentRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public void printPhyTreatmentRegisterReport(HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();
		int hospitalId = 0;
		String joinQry = "";
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		String qry = "";
		if(request.getParameter(SERVICE_TYPE_ID)!=null && !(request.getParameter(SERVICE_TYPE_ID).equals("0"))){
			qry += " and patient.service_type_id = "+Integer.parseInt(request.getParameter(SERVICE_TYPE_ID))+"";
		}
		if(request.getParameter(SERVICE_STATUS_ID)!=null && !(request.getParameter(SERVICE_STATUS_ID).equals("0"))){
			qry += " and patient.service_status_id = "+Integer.parseInt(request.getParameter(SERVICE_STATUS_ID))+"";
		}
		if(!(request.getParameter("fromRankId").equals("0")) && !(request.getParameter("toRankId").equals("0"))){
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
		if (!(request.getParameter("fromAge").equals("")) && !(request.getParameter("fromAgeUnit").equals(""))
				&& !(request.getParameter("toAge").equals("")) && !(request.getParameter("toAgeUnit").equals(""))) {
			String fromAge = request.getParameter("fromAge");
			String toAge = request.getParameter("toAge");
			qry +=" and substr(patient.age,0,INSTR(patient.age,' ')) >="+fromAge+" " +
					" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"+request.getParameter("fromAgeUnit")+"'" +
					" and substr(patient.age,0,INSTR(patient.age,' ')) <="+toAge+" " +
					" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"+request.getParameter("toAgeUnit")+"'";
			
		}
		if (!(request.getParameter("fromServ").equals("")) && !(request.getParameter("fromServUnit").equals(""))
				&& !(request.getParameter("toServ").equals("")) && !(request.getParameter("toServUnit").equals(""))) {
			String fromServ = request.getParameter("fromServ");
			String toServ = request.getParameter("toServ");
			qry +=" and patient.service_years >="+fromServ+" " +
					" and  total_service_period='"+request.getParameter("fromServUnit")+"'" +
					" and patient.service_years <="+toServ+" " +
					" and  total_service_period='"+request.getParameter("toServUnit")+"'";
			
		}
		if(request.getParameter(CONSULTING_DOCTOR)!=null && !(request.getParameter(CONSULTING_DOCTOR).equals("0"))){
			qry += " and visit.doctor_id = "+Integer.parseInt(request.getParameter(CONSULTING_DOCTOR))+"";
		}
		if (request.getParameter("icd") != null && !(request.getParameter("icd").equals(""))) {
			String icd = request.getParameter("icd");
			 int index1=icd.lastIndexOf("[");
			  int index2=icd.lastIndexOf("]");
			   index1++;
			   String icdCode =""+icd.substring(index1, index2);
			   
			   joinQry += " left join discharge_icd_code dic on PHYSIO_VISIT_ENTRY_HEADER.visitid=dic.visit_id" +
				" left outer join mas_icd icd on dic.icd_id=icd.icd_id";
			qry += " and icd.icd_code='"+icdCode+"'";
		}
		if (request.getParameter("icdNo") != null && !(request.getParameter("icdNo").equals(""))) {
			joinQry += " left join discharge_icd_code dic on PHYSIO_VISIT_ENTRY_HEADER.visitid=dic.visit_id" +
					" left outer join mas_icd icd on dic.icd_id=icd.icd_id";
			qry += " and icd.icd_code='"+request.getParameter("icdNo")+"'";
		}
		if(request.getParameter("therapyId")!=null && !(request.getParameter("therapyId").equals(""))){
			qry += " and MAS_THERAPY_TYPE.THERAPY_TYPE_ID = '"+request.getParameter("therapyId")+"'";
			
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = physiotherapyHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("joinQry", joinQry);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		parameters.put("hospitalId", hospitalId);
	
		HMSUtil.generateReport("PhysiotherapyTreatmentRegister", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}
	public void printPhyAppintmentRegisterReport(HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();
		int hospitalId = 0;
		Box box = null;
		HttpSession session = request.getSession();
		if(session.getAttribute("box")!=null){
			box = (Box)session.getAttribute("box");
		}else{
			box = HMSUtil.getBox(request);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (!box.getString(FROM_DATE).equals("")) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
		}
		if (!box.getString(TO_DATE).equals("")) {
			toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
		}
		String qry = "";
		
		if(box.getInt("fromRankId")!=0){
			//qry += " and patient.rank_id between "+Integer.parseInt(request.getParameter("fromRankId"))+" and "+Integer.parseInt(request.getParameter("toRankId"));
			qry += " and patient.rank_id = "+(box.getInt("fromRankId"))+"";
		}
		
		if(box.getInt(TRADE_ID)!=0){
			qry += " and patient.trade_id = "+box.getInt(TRADE_ID)+"";
		}
		if(box.getInt(UNIT_ID)!=0){
			qry += " and patient.unit_id = "+box.getInt(UNIT_ID)+"";
		}
		if(box.getInt(SECTION_ID)!=0){
			qry += " and patient.section_id = "+box.getInt(SECTION_ID)+"";
		}
		if(box.getInt(SEX_ID)!=0){
			qry += " and patient.sex_id = "+box.getInt(SEX_ID)+"";
		}
		if (!(box.getString(SERVICE_NO).equals(""))) {
			qry += " and patient.service_no='"+HMSUtil.restrictMetaChar(box.getString(SERVICE_NO))+"'";
		}
		
		if(box.getInt(CONSULTING_DOCTOR)!=0){
			qry += " and visit.doctor_id = "+box.getInt(CONSULTING_DOCTOR)+"";
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = physiotherapyHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("hospitalId", hospitalId);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
	
		HMSUtil.generateReport("PhysiotherapyAppointmentRegister", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}
	public ModelAndView showPhyAppointmentRegisterReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = physiotherapyHandlerService.showPhyAppointmentRegisterReport(box);
		String jsp = "physioAppointmentReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showPhysioTherapyTreatmentRegiterGraph(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId =0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		
		map = physiotherapyHandlerService.showPhysioTherapyTreatmentRegiterGraph(box);
		List<Object[]> treatmentRegister = new ArrayList<Object[]>();
		treatmentRegister = (List<Object[]>)map.get("treatmentRegister");
		String ENCODING = "ISO-8859-1";
		try {
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_therapy_data.xml")));
		
			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING
					+ "\"?>");
			out.write("<chart>");
			int i =0;
				out.write("<series>");
				for(Object[] object : treatmentRegister){
					out.write("<value xid='"+i+"'>"+object[0]+"</value>");
					i++;
				}
				out.write("</series>");
				out.write("<graphs>");
				int j=1;
				
				for(int k=0;k<5;k++){
					
					out.write("<graph gid='"+k+"'>");
					int l=0;
					for(Object[] objVal : treatmentRegister){
						
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
		String jsp = "physioTherapyTreatmentGraph";
		
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showPhysiotherapyAppointmentRegister(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = physiotherapyHandlerService.showPhysiotherapyAppointmentRegister(hospitalId);
		String jsp = "PhysiotherapyAppointmentRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	
	public ModelAndView getPhysiotherapyDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box= HMSUtil.getBox(request);
		map = physiotherapyHandlerService.getPhysiotherapyVisitDetails(box);
		String jsp = "responseForPhysiotherapy";
		return new ModelAndView(jsp,"map",map);
	}
	
	public ModelAndView showPhysiotherapyMainJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box= HMSUtil.getBox(request);
		
		String jsp = "physiotherapyMain.jsp";
		map.put("visitId", box.getInt("visitId"));
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	public ModelAndView showPhysiotherapyAppointmentJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box= HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		map = physiotherapyHandlerService.showPhysiotherapyAppointmentJsp(box);
		String jsp = "physiotherapyAppointment.jsp";
		
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView getPhysioAppointmentDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		int hinId = 0;
		if(box.getInt("hinId") != 0){
			hinId = box.getInt("hinId");
		}
		box.put("hinId", hinId);
		map = physiotherapyHandlerService.getPhysioAppointmentDetails(box);
		return new ModelAndView("responseForPhysiotherapyAppointment","map",map);
	}
	public ModelAndView savePhysioTheraphyAppointment(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		String buttonName = "";
		if(request.getParameter("buttonName") != null){
			buttonName = request.getParameter("buttonName");
		}
		map = physiotherapyHandlerService.savePhysioTheraphyAppointment(box);
		boolean flag = (Boolean)map.get("flag");
		String message = ""; 
		if(flag){
			message = "Record Saved Successfully.";
		}else{
			message = "Try Again.";
		}
		map = physiotherapyHandlerService.searchPhyWaitingListJsp(box);
		map.put("message", message);
		System.out.println("buttonName==="+buttonName);
		if(buttonName.equalsIgnoreCase("save")){
			System.out.println("condition=="+buttonName.equalsIgnoreCase("save"));
			jsp = "physiotherapyAppointment.jsp";
			map = physiotherapyHandlerService.showPhysiotherapyAppointmentJsp(box);
		}else{
			 jsp = "phy_waitingList.jsp";
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public void getHinNoForAppointment(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		map = physiotherapyHandlerService.getHinNoForAppointment(box);
		List<Object[]> hinNoList = new ArrayList<Object[]>();
		hinNoList = (List<Object[]>)map.get("hinNoList");
		StringBuffer sb = new StringBuffer();
		
		try {
			if(hinNoList.size() > 0){
				for(Object[] obj : hinNoList){
				sb.append("<item>");
				sb.append("<hinNo>" + obj[0] + "</hinNo>");
				sb.append("<hinId>" + obj[1] + "</hinId>");
				sb.append("</item>");
				}
			}
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		}catch (Exception e) {
			e.printStackTrace();
		}
		try{
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getDetailsForHinNo(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		map = physiotherapyHandlerService.getDetailsForHinNo(box);
		List<Patient> patientList = new ArrayList<Patient>();
		patientList = (List<Patient>)map.get("patientList");
		StringBuffer sb = new StringBuffer();
		
		try {
			if(patientList.size() > 0){
				for(Patient patient : patientList){
				sb.append("<item>");
				String name = patient.getPFirstName();
				if(patient.getPMiddleName()!=null){
					name += " "+patient.getPMiddleName();
				}
				if(patient.getPLastName()!=null){
					name +=" "+patient.getPLastName();
				}
				sb.append("<name>" + name + "</name>");
				if(patient.getContactNo()!= null){
					sb.append("<contactNo>" + patient.getContactNo() + "</contactNo>");
				}else{
					sb.append("<contactNo>" + "" + "</contactNo>");
				}
				sb.append("<age>" + patient.getAge() + "</age>");
				sb.append("<sex>" + patient.getSex().getAdministrativeSexName() + "</sex>");
				sb.append("</item>");
				}
			}
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		}catch (Exception e) {
			e.printStackTrace();
		}
		try{
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ModelAndView savePhysiotherapyAppointment(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		Users user = (Users)session.getAttribute("users");
		box.put("userId", user.getId());
		map = physiotherapyHandlerService.savePhysiotherapyAppointment(box);
		boolean flag = false;
		if(map.get("flag")!=null){
			flag = (Boolean)map.get("flag");
		}
		String message="";
		if(flag){
			message = "Record Saved Successfully!!";
		}else{
			message = "Some Problem Occurred";
		}
		map.put("messageTOBeVisibleToTheUser", message);
		String jsp = "message";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	public void showPhysiotherapyHelpFile(HttpServletRequest request,HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		String filename = null;
		String fileExtension = null;
		MultipartFormDataRequest mrequest = null;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Map<String, Object> uploadFileMap = new HashMap<String, Object>();

	//	String uploadURL = getServletContext().getRealPath("/upload/");
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome
				+ fileSeparator
				+ "help"
				+ fileSeparator;
				
		
		// String whiteList = "*.zip";
		// String whiteList = "*.jpg";

		// Long fileSizeLimit = 2097152l;

		/*
		 * List fileUploadedList = null; fileUploadedList =
		 * HMSUtil.uploadFile(mrequest,uploadURL, whiteList,
		 * box.getString("filename"));
		 * //System.out.println("fileUploadedList="+fileUploadedList.size());
		 * Boolean fileUploaded=false; if(fileUploadedList != null &&
		 * fileUploadedList.size()!=0) { fileUploaded = (Boolean)
		 * fileUploadedList.get(0); }
		 */
		
		try {
			
			response.setContentType("application/pdf");
			
			response.setHeader("Content-Disposition", "attachment;filename="
					+ java.net.URLEncoder.encode("Physiotherapy.pdf")
					+ "");

			// System.out.println("box.getString(filename)==" + filename + "."+
			// fileExtension);
			// response.setContentType("image/"+fileExtension);
			// response.setHeader("Content-Disposition", "attachment;
			// filename="+filename+"."+fileExtension);

			File f = new File(uploadURL + "/Physiotherapy.pdf");
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
	
	
	
	public PhysiotherapyHandlerService getPhysiotherapyHandlerService() {
		return physiotherapyHandlerService;
	}

	public void setPhysiotherapyHandlerService(
			PhysiotherapyHandlerService physiotherapyHandlerService) {
		this.physiotherapyHandlerService = physiotherapyHandlerService;
	}
	
	
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
