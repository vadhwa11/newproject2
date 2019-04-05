
package jkt.hms.masters.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasBloodBankStatus;
import jkt.hms.masters.business.MasBloodDonationType;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.handler.BloodBankMasterHandlerService;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;
import static jkt.hms.util.RequestConstants.*;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BloodBankMasterController extends MultiActionController{

	BloodBankMasterHandlerService bloodBankMasterHandlerService;
	CommonMasterHandlerService commonMasterHandlerService;
	String jsp = "";
	String title = "";
	String message = "";
	String url = "";
	String code = "";
	String name = "";
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String currentDate = "";
	String currentTime = "";
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	HttpSession session = null;
	String userName = "";

	//	---------------------------------------------For Blood Bank Status---------------------------------------------
	
	@SuppressWarnings("unchecked")
	 public ModelAndView showBloodBankStatusJsp(HttpServletRequest request,HttpServletResponse response)
	 {
	  session = request.getSession();
	  map = (Map<String, Object>) bloodBankMasterHandlerService.showBloodBankStatusJsp();
	  @SuppressWarnings("unused")
	  ArrayList  searchBloodBankStatusList = (ArrayList)map.get("searchBloodBankStatusList");
	  jsp = BLOOD_BANK_STATUS_JSP;
	  jsp += ".jsp";
	  title = "BloodBankStatus";
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  return new ModelAndView("indexB", "map", map);
	 }

	public ModelAndView searchBloodBankStatus(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	 {
	  Map<String, Object> map= new HashMap<String, Object>();  
	  String bloodBankStatusCode  = null;
	  String bloodBankStatusName = null;
	  String searchField= null;
	  if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
		  bloodBankStatusCode = request.getParameter(CODE);
	  }
	  if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		  bloodBankStatusName = request.getParameter(SEARCH_NAME);
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
		  bloodBankStatusCode=searchField;
		  bloodBankStatusName=null;
	   
	  }else{
		  bloodBankStatusCode=null;
		  bloodBankStatusName=searchField;
	  }
	  map = bloodBankMasterHandlerService.searchBloodBankStatus(bloodBankStatusCode, bloodBankStatusName);
	  jsp=BLOOD_BANK_STATUS_JSP;
	  jsp += ".jsp";
	  map.put("search","search");
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  map.put("bloodBankStatusCode",bloodBankStatusCode);
	  map.put("bloodBankStatusName",bloodBankStatusName);
	  return new ModelAndView("indexB", "map", map);
	 }
	

	 @SuppressWarnings("unchecked")
	 public ModelAndView addBloodBankStatus(HttpServletRequest request, HttpServletResponse response) 
	 {

	  Map<String,Object> map=new HashMap<String,Object>();
	  MasBloodBankStatus masBloodBankStatus=new MasBloodBankStatus();
	  String changedBy = "";
	  Map<String,Object> listMap=new HashMap<String,Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();
	  Date currentDate = new Date();

	  if (request.getParameter(CODE) != null) {
	   code = request.getParameter(CODE);
	  }
	  if (request.getParameter(SEARCH_NAME) != null) {
	   name = request.getParameter(SEARCH_NAME);
	  }
	  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
	   changedBy = request.getParameter(CHANGED_BY);
	  }
	  if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
	   currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
	  }
	  if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
	   currentTime = request.getParameter(CHANGED_TIME);
	  }
	  if(request.getParameter("title") != null){
	   title = request.getParameter("title"); 
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
	  
	  List bloodBankStatusCodeList = new ArrayList();
	  List bloodBankStatusNameList = new  ArrayList();

	  if(listMap.get("duplicateGeneralCodeList") != null){
		  bloodBankStatusCodeList = (List)listMap.get("duplicateGeneralCodeList");
	  }
	  if(listMap.get("duplicateGeneralNameList") != null){
		  bloodBankStatusNameList = (List)listMap.get("duplicateGeneralNameList");
	  }
	  boolean successfullyAdded = false;

	  if((bloodBankStatusCodeList.size() == 0 || bloodBankStatusCodeList == null) && (bloodBankStatusNameList.size() == 0 || bloodBankStatusNameList == null))
	  {
	   masBloodBankStatus.setBloodBankStatusCode(code);
	   masBloodBankStatus.setBloodBankStatusName(name);
	   masBloodBankStatus.setStatus("y");
	   masBloodBankStatus.setLastChgBy(changedBy);
	   masBloodBankStatus.setLastChgDate(currentDate);
	   masBloodBankStatus.setLastChgTime(currentTime);
	   successfullyAdded = bloodBankMasterHandlerService.addBloodBankStatus(masBloodBankStatus);  

	  if(successfullyAdded)
	   {
	     message="Record Added Successfully !!";
	   }
	   else
	   {
	      message="Try Again !!";

	   }
	 }

	  else if((bloodBankStatusCodeList.size() != 0 || bloodBankStatusCodeList != null) || (bloodBankStatusNameList.size() != 0) || bloodBankStatusNameList != null){
	   if((bloodBankStatusCodeList.size() != 0 || bloodBankStatusCodeList != null) && (bloodBankStatusNameList.size() == 0 || bloodBankStatusNameList == null)){
	    message = "Blood Bank Status Code  already exists.";
	   }
	   else if((bloodBankStatusNameList.size() != 0 || bloodBankStatusNameList != null) && (bloodBankStatusCodeList.size() == 0 || bloodBankStatusCodeList == null) ){
	    message = "Blood Bank Status Name already exists.";
	   }
	   else if((bloodBankStatusCodeList.size() != 0 || bloodBankStatusCodeList != null) && (bloodBankStatusNameList.size() != 0 || bloodBankStatusNameList != null)){
	    message = "Blood Bank Status Code and Blood Bank Status Name already exist.";
	   }	   
	  }
	  url = "/hms/hms/bloodBank?method=showBloodBankStatusJsp";
	  try{
		   map = bloodBankMasterHandlerService.showBloodBankStatusJsp();
		    }catch (Exception e) {
		     e.printStackTrace();
		    }
		    jsp=BLOOD_BANK_STATUS_JSP;
		    title="Add Blood Bank Status";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	 }

	 public ModelAndView editBloodBankStatus(HttpServletRequest request, HttpServletResponse response) 
	 {

	  Map<String, Object> map = new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();

	  session=request.getSession();
	  String bloodBankStatusCode="";
	  String bloodBankStatusName="";
	  int bloodBankStatusId=0;
	  String changedBy = "";
	  @SuppressWarnings("unused")
	  Date changedDate = null;
	  @SuppressWarnings("unused")
	  String changedTime = "";
	  Date currentDate = null;

	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		  bloodBankStatusId =Integer.parseInt( request.getParameter(COMMON_ID));
	  }
	  if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
		  bloodBankStatusCode = request.getParameter(CODE);
	  }
	  if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		  bloodBankStatusName = request.getParameter(SEARCH_NAME);
	  }
	  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
	   changedBy = request.getParameter(CHANGED_BY);
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
	  if(request.getParameter("title") != null){
	   title = request.getParameter("title"); 
	  }
	  changedDate = new Date();
	  changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

	  generalMap.put("id", bloodBankStatusId);
	  generalMap.put("bloodBankStatusCode", bloodBankStatusCode);
	  generalMap.put("name", bloodBankStatusName);
	  generalMap.put("changedBy", changedBy);
	  generalMap.put("currentDate", changedDate);
	  generalMap.put("currentTime", changedTime);
	  Map<String, Object> listMap = new HashMap<String, Object>();
	  generalMap.put("pojoPropertyName", pojoPropertyName);
	  generalMap.put("pojoName", pojoName);
  	  generalMap.put("flag", true);
	  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
	  List existingBloodBankStatusNameList = (List)listMap.get("duplicateMastersList");
	  boolean dataUpdated=false;
	  if(existingBloodBankStatusNameList.size() == 0)
	  {
		  dataUpdated=bloodBankMasterHandlerService.editBloodBankStatusToDatabase(generalMap);

	if(dataUpdated==true){
		message="Data updated Successfully !!";
	}
	else{
		message="Data Cant Be Updated !!";
	}
	}
	  else if(existingBloodBankStatusNameList.size() > 0){
		   message = "Name already exists.";
		  }
	  url = "/hms/hms/bloodBank?method=showBloodBankStatusJsp";
	  try{
		   map = bloodBankMasterHandlerService.showBloodBankStatusJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=BLOOD_BANK_STATUS_JSP;
		    title="Update Blood Bank Status";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	 }

	 public ModelAndView deleteBloodBankStatus(HttpServletRequest request, HttpServletResponse response) {
	  Map<String, Object> map = new HashMap<String, Object>();
	  int bloodBankStatusId=0;
	  String message=null;
	  String changedBy = "";
      String changedTime = "";
	  Date changedDate = null;
	  String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		  bloodBankStatusId =Integer.parseInt( request.getParameter(COMMON_ID));
	  }
	  if(request.getParameter("title") != null){
	   title = request.getParameter("title"); 
	  }
	  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
	  boolean dataDeleted=false;
	  dataDeleted=bloodBankMasterHandlerService.deleteBloodBankStatus(bloodBankStatusId,generalMap);
	  if (dataDeleted==true)
	  {
	   message="Record is InActivated successfully !!";
	  }

	  else{
	   message="Record is Activated successfully !!";
	  }
	  url = "/hms/hms/bloodBank?method=showBloodBankStatusJsp";
	  try{
		   map = bloodBankMasterHandlerService.showBloodBankStatusJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=BLOOD_BANK_STATUS_JSP;
		    title="Delete Blood Bank Status";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	  	 }

//	------------------------------------------BloodDonationType------------------------------------------------------
	 @SuppressWarnings("unchecked")
	 public ModelAndView showBloodDonationTypeJsp(HttpServletRequest request,HttpServletResponse response)
	 {
	  session = request.getSession();
	  map = (Map<String, Object>) bloodBankMasterHandlerService.showBloodDonationTypeJsp();
	  
	  jsp = BLOOD_DONATION_TYPE_JSP;
	  jsp += ".jsp";
	  title = "BloodDonationType";
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  return new ModelAndView("indexB", "map", map);
	 }
	 public ModelAndView searchBloodDonationType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	 {
	  Map<String, Object> map= new HashMap<String, Object>();  
	  String bloodDonationTypeCode  = null;
	  String bloodDonationTypeName = null;
	  String searchField= null;

	  if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
		  bloodDonationTypeCode = request.getParameter(CODE);
	  }
	  if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		  bloodDonationTypeName = request.getParameter(SEARCH_NAME);
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
		  bloodDonationTypeCode=searchField;
		  bloodDonationTypeName=null;
	   
	  }else{
		  bloodDonationTypeCode=null;
		  bloodDonationTypeName=searchField;
	  }
	  map = bloodBankMasterHandlerService.searchBloodDonationType(bloodDonationTypeCode, bloodDonationTypeName);
	  jsp=BLOOD_DONATION_TYPE_JSP;

	  jsp += ".jsp";
	  map.put("search","search");
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  map.put("bloodDonationTypeCode",bloodDonationTypeCode);
	  map.put("bloodDonationTypeName",bloodDonationTypeName);
	  return new ModelAndView("indexB", "map", map);
	 }

	 
	 @SuppressWarnings("unchecked")
	 public ModelAndView addBloodDonationType(HttpServletRequest request, HttpServletResponse response) 
	 {
	  Map<String,Object> map=new HashMap<String,Object>();
	  MasBloodDonationType masBloodDonationType=new MasBloodDonationType();

	  String changedBy = "";
	  Map<String,Object> listMap=new HashMap<String,Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();
	  Date currentDate = new Date();


	  if (request.getParameter(CODE) != null) {
	   code = request.getParameter(CODE);

	  }
	  if (request.getParameter(SEARCH_NAME) != null) {
	   name = request.getParameter(SEARCH_NAME);

	  }
	  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
	   changedBy = request.getParameter(CHANGED_BY);
	  }
	  if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
	   currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
	  }
	  if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
	   currentTime = request.getParameter(CHANGED_TIME);
	  }
	  if(request.getParameter("title") != null){
	   title = request.getParameter("title"); 
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

	  List bloodDonationTypeCodeList = new ArrayList();
	  List bloodDonationTypeNameList = new  ArrayList();

	  if(listMap.get("duplicateGeneralCodeList") != null){
		  bloodDonationTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
	  }
	  if(listMap.get("duplicateGeneralNameList") != null){
		  bloodDonationTypeNameList = (List)listMap.get("duplicateGeneralNameList");
	  }
	  boolean successfullyAdded = false;

	  if((bloodDonationTypeCodeList.size() == 0 || bloodDonationTypeCodeList == null) && (bloodDonationTypeNameList.size() == 0 || bloodDonationTypeNameList == null))
	  {
	   masBloodDonationType.setBloodDonationTypeCode(code);
	   masBloodDonationType.setBloodDonationTypeName(name);
	   masBloodDonationType.setStatus("y");
	   masBloodDonationType.setLastChgBy(changedBy);
	   masBloodDonationType.setLastChgDate(currentDate);
	   masBloodDonationType.setLastChgTime(currentTime);
	   successfullyAdded = bloodBankMasterHandlerService.addBloodDonationType(masBloodDonationType);  

	   if(successfullyAdded)
	   {
	    message="Record Added Successfully !!";
	   }
	   else
	   {
	    message="Try Again !!";

	   }
	  }

	  else if((bloodDonationTypeCodeList.size() != 0 || bloodDonationTypeCodeList != null) || (bloodDonationTypeNameList.size() != 0) || bloodDonationTypeNameList != null){
	   if((bloodDonationTypeCodeList.size() != 0 || bloodDonationTypeCodeList != null) && (bloodDonationTypeNameList.size() == 0 || bloodDonationTypeNameList == null)){
	    message = "BloodDonationType Code  already exists.";
	   }
	   else if((bloodDonationTypeNameList.size() != 0 || bloodDonationTypeNameList != null) && (bloodDonationTypeCodeList.size() == 0 || bloodDonationTypeCodeList == null) ){
	    message = "BloodDonationType Name already exists.";
	   }
	   else if((bloodDonationTypeCodeList.size() != 0 || bloodDonationTypeCodeList != null) && (bloodDonationTypeNameList.size() != 0 || bloodDonationTypeNameList != null)){
	    message = "BloodDonationType Code and BloodDonationType Name already exist.";
	   }
	  }

	  url = "/hms/hms/bloodBank?method=showBloodDonationTypeJsp";
	  try{
		   map = bloodBankMasterHandlerService.showBloodDonationTypeJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=BLOOD_DONATION_TYPE_JSP;
		    title="Add BloodDonationType";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	 }

	 public ModelAndView editBloodDonationType(HttpServletRequest request, HttpServletResponse response) 
	 {

	  Map<String, Object> map = new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();

	  session=request.getSession();
	  String bloodDonationTypeCode="";
	  String bloodDonationTypeName="";
	  int bloodDonationTypeId=0;
	  String changedBy = "";
	  @SuppressWarnings("unused")
	  Date changedDate = null;
	  @SuppressWarnings("unused")
	  String changedTime = "";
	  Date currentDate = null;

	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		  bloodDonationTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
	  }
	  if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
		  bloodDonationTypeCode = request.getParameter(CODE);
	  }
	  if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		  bloodDonationTypeName = request.getParameter(SEARCH_NAME);
		  //System.out.println("bloodDonationTypeName-in Controller->"+bloodDonationTypeName);
	  }
	  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
	   changedBy = request.getParameter(CHANGED_BY);
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
	  if(request.getParameter("title") != null){
	   title = request.getParameter("title"); 
	  }
	  changedDate = new Date();
	  changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

	  generalMap.put("id", bloodDonationTypeId);
	  generalMap.put("bloodDonationTypeCode", bloodDonationTypeCode);
	  generalMap.put("name", bloodDonationTypeName);
	  generalMap.put("changedBy", changedBy);
	  generalMap.put("currentDate", changedDate);
	  generalMap.put("currentTime", changedTime);
	  Map<String, Object> listMap = new HashMap<String, Object>();
	  generalMap.put("pojoPropertyName", pojoPropertyName);
	  generalMap.put("pojoName", pojoName);
  	  generalMap.put("flag", true);
	  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
	  List existingBloodDonationTypeNameList = (List)listMap.get("duplicateMastersList");
	  boolean dataUpdated=false;
	  if(existingBloodDonationTypeNameList.size() == 0)
	  {
		  dataUpdated=bloodBankMasterHandlerService.editBloodDonationTypeToDatabase(generalMap);
			//System.out.println("bloodDonationTypeName in after COntoller "+bloodDonationTypeName);
	if(dataUpdated==true){
		message="Data updated Successfully !!";
	}
	else{
		message="Data Cant Be Updated !!";
	}
	}
	  else if(existingBloodDonationTypeNameList.size() > 0){
		   message = "Name already exists.";
		  }
	  url = "/hms/hms/bloodBank?method=showBloodDonationTypeJsp";
	  try{
		   map = bloodBankMasterHandlerService.showBloodDonationTypeJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=BLOOD_DONATION_TYPE_JSP;
		    title="Update BloodDonationType";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);

	 }

	 public ModelAndView deleteBloodDonationType(HttpServletRequest request, HttpServletResponse response) {
	  Map<String, Object> map = new HashMap<String, Object>();
	  int bloodDonationTypeId=0;
	  String message=null;
	  String changedBy = "";
      String changedTime = "";
	  Date changedDate = null;
	
	  String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		  bloodDonationTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
	  }
	  if(request.getParameter("title") != null){
	   title = request.getParameter("title"); 
	  }
	  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
	  boolean dataDeleted=false;
	  dataDeleted=bloodBankMasterHandlerService.deleteBloodDonationType(bloodDonationTypeId,generalMap);
	  if (dataDeleted==true)
	  {
	   message="Record is InActivated Successfully !!";
	  }
	  else{
	   message="Record is Activated Successfully !!";
	  }
	  url = "/hms/hms/bloodBank?method=showBloodDonationTypeJsp";
	  try{
		   map = bloodBankMasterHandlerService.showBloodDonationTypeJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=BLOOD_DONATION_TYPE_JSP;
		    title="Delete BloodDonationType";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	 }


//---------------------------------------------Blood Group-------------------------------------------
	 @SuppressWarnings("unchecked")
	 public ModelAndView showBloodGroupJsp(HttpServletRequest request,HttpServletResponse response)
	 {
	  session = request.getSession();
	  map = (Map<String, Object>) bloodBankMasterHandlerService.showBloodGroupJsp();
	  @SuppressWarnings("unused")
	  ArrayList  searchBloodGroupList = (ArrayList)map.get("searchBloodGroupList");
	  jsp = BLOOD_GROUP_JSP;
	  jsp += ".jsp";
	  title = "BloodGroup";
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  return new ModelAndView("indexB", "map", map);
	 }
	public ModelAndView searchBloodGroup(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	 {
	  Map<String, Object> map= new HashMap<String, Object>();  
	  String bloodGroupCode  = null;
	  String bloodGroupName = null;
	  String searchField= null;

	  if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
		  bloodGroupCode = request.getParameter(CODE);
	  }

	  if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		  bloodGroupName = request.getParameter(SEARCH_NAME);
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
		  bloodGroupCode=searchField;
		  bloodGroupName=null;
	  }else{
		  bloodGroupCode=null;
		  bloodGroupName=searchField;
	  }	  
	  map = bloodBankMasterHandlerService.searchBloodGroup(bloodGroupCode, bloodGroupName);

	  jsp=BLOOD_GROUP_JSP;
	  jsp += ".jsp";
	  map.put("search","search");
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  map.put("bloodGroupCode",bloodGroupCode);
	  map.put("bloodGroupName",bloodGroupName);
	  return new ModelAndView("indexB", "map", map);
	 }
	
	 @SuppressWarnings("unchecked")
	 public ModelAndView addBloodGroup(HttpServletRequest request, HttpServletResponse response) 
	 {

	  Map<String,Object> map=new HashMap<String,Object>();
	  MasBloodGroup masBloodGroup=new MasBloodGroup();
	  String changedBy = "";
	  Map<String,Object> listMap=new HashMap<String,Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();
	  Date currentDate = new Date();

	  if (request.getParameter(CODE) != null) {
	   code = request.getParameter(CODE);
	  }
	  if (request.getParameter(SEARCH_NAME) != null) {
	   name = request.getParameter(SEARCH_NAME);
	  }
	  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
	   changedBy = request.getParameter(CHANGED_BY);
	  }
	  if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
	   currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
	  }
	  if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
	   currentTime = request.getParameter(CHANGED_TIME);
	  }
	  if(request.getParameter("title") != null){
	   title = request.getParameter("title"); 
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
	  List bloodGroupCodeList = new ArrayList();
	  List bloodGroupNameList = new  ArrayList();

	  if(listMap.get("duplicateGeneralCodeList") != null){
		  bloodGroupCodeList = (List)listMap.get("duplicateGeneralCodeList");
	  }
	  if(listMap.get("duplicateGeneralNameList") != null){
		  bloodGroupNameList = (List)listMap.get("duplicateGeneralNameList");
	  }
	  boolean successfullyAdded = false;

	  if((bloodGroupCodeList.size() == 0 || bloodGroupCodeList == null) && (bloodGroupNameList.size() == 0 || bloodGroupNameList == null))
	  {
	   masBloodGroup.setBloodGroupCode(code);
	   masBloodGroup.setBloodGroupName(name);
	   masBloodGroup.setStatus("y");
	   masBloodGroup.setLastChgBy(changedBy);
	   masBloodGroup.setLastChgDate(currentDate);
	   masBloodGroup.setLastChgTime(currentTime);
	   successfullyAdded = bloodBankMasterHandlerService.addBloodGroup(masBloodGroup);  

	   if(successfullyAdded)
	   {
	    message="Record Added Successfully !!";
	   }
	   else
	   {
	    message="Try Again !!";
	   }
	   }

	  else if((bloodGroupCodeList.size() != 0 || bloodGroupCodeList != null) || (bloodGroupNameList.size() != 0) || bloodGroupNameList != null){
	   if((bloodGroupCodeList.size() != 0 || bloodGroupCodeList != null) && (bloodGroupNameList.size() == 0 || bloodGroupNameList == null)){
	    message = "Blood Group Code  already exists.";
	   }
	   else if((bloodGroupNameList.size() != 0 || bloodGroupNameList != null) && (bloodGroupCodeList.size() == 0 || bloodGroupCodeList == null) ){
	    message = "Blood Group Name already exists.";	   }
	   else if((bloodGroupCodeList.size() != 0 || bloodGroupCodeList != null) && (bloodGroupNameList.size() != 0 || bloodGroupNameList != null)){
	    message = "Blood Group Code and Blood Group Name already exist.";
	   }
	  }
	  url = "/hms/hms/bloodBank?method=showBloodGroupJsp";
	  try{
		   map = bloodBankMasterHandlerService.showBloodGroupJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=BLOOD_GROUP_JSP;
		    title="Add Blood group";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	 }

	 public ModelAndView editBloodGroup(HttpServletRequest request, HttpServletResponse response) 
	 {

	  Map<String, Object> map = new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();
	  session=request.getSession();
	  String bloodGroupCode="";
	  String bloodGroupName="";
	  int bloodGroupId=0;
	  String changedBy = "";
	  @SuppressWarnings("unused")
	  Date changedDate = null;
	  @SuppressWarnings("unused")
	  String changedTime = "";
	  Date currentDate = null;

	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		  bloodGroupId =Integer.parseInt( request.getParameter(COMMON_ID));
	  }
	  if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
		  bloodGroupCode = request.getParameter(CODE);
	  }
	  if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		  bloodGroupName = request.getParameter(SEARCH_NAME);
	  }
	  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
	   changedBy = request.getParameter(CHANGED_BY);
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
	  if(request.getParameter("title") != null){
	   title = request.getParameter("title"); 
	  }
	  changedDate = new Date();
	  changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

	  generalMap.put("id", bloodGroupId);
	  generalMap.put("bloodGroupCode", bloodGroupCode);
	  generalMap.put("name", bloodGroupName);
	  generalMap.put("changedBy", changedBy);
	  generalMap.put("currentDate", changedDate);
	  generalMap.put("currentTime", changedTime);
	  Map<String, Object> listMap = new HashMap<String, Object>();
	  generalMap.put("pojoPropertyName", pojoPropertyName);
	  generalMap.put("pojoName", pojoName);
  	  generalMap.put("flag", true);
	  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
	  List existingBloodGroupNameList = (List)listMap.get("duplicateMastersList");
	  boolean dataUpdated=false;
	  if(existingBloodGroupNameList.size() == 0)
	  {
		  dataUpdated=bloodBankMasterHandlerService.editBloodGroupToDatabase(generalMap);

	if(dataUpdated==true){
		message="Data updated Successfully !!";
	}
	else{
		message="Data Cant Be Updated !!";
	}
	}
	  else if(existingBloodGroupNameList.size() > 0){
		   message = "Name already exists.";
		  }
	  url = "/hms/hms/bloodBank?method=showBloodGroupJsp";
	  try{
		   map = bloodBankMasterHandlerService.showBloodGroupJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=BLOOD_GROUP_JSP;
		    title="Update Blood group";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	 }

	 public ModelAndView deleteBloodGroup(HttpServletRequest request, HttpServletResponse response) {
	  Map<String, Object> map = new HashMap<String, Object>();
	  int bloodGroupId=0;
	  String message=null;
	  String changedBy = "";
      String changedTime = "";
	  Date changedDate = null;
	  String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		  bloodGroupId =Integer.parseInt( request.getParameter(COMMON_ID));
	  }
	  if(request.getParameter("title") != null){
	   title = request.getParameter("title"); 
	  }
	  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
	  boolean dataDeleted=false;
	  dataDeleted=bloodBankMasterHandlerService.deleteBloodGroup(bloodGroupId,generalMap);
	  if (dataDeleted==true)
	  {
	   message="Record is InActivated Successfully !!";
	  }

	  else{
	   message="Record is Activated Successfully !!";
	  }
	  url = "/hms/hms/bloodBank?method=showBloodGroupJsp";
	  try{
		   map = bloodBankMasterHandlerService.showBloodGroupJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=BLOOD_GROUP_JSP;
		    title="delete Blood Group";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	 }

//---------------------------------------------------------------------------------------------------
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}
	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
	public BloodBankMasterHandlerService getBloodBankMasterHandlerService() {
		return bloodBankMasterHandlerService;
	}
	public void setBloodBankMasterHandlerService(
			BloodBankMasterHandlerService bloodBankMasterHandlerService) {
		this.bloodBankMasterHandlerService = bloodBankMasterHandlerService;
	}

	
}
