package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.*;

import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import jkt.hms.util.HMSUtil;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.business.MasAnesthesia;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasInstruction;
import jkt.hms.masters.business.MasOpInstruction;
import jkt.hms.masters.business.MasOt;
import jkt.hms.masters.business.MasOtDistribution;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.OpdTemplateInvestigation;
import jkt.hms.masters.business.OtMasChargeDetails;
import jkt.hms.masters.business.UserGroups;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.OTMasterHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

	public class OTMasterController extends MultiActionController {
		OTMasterHandlerService otMasterHandlerService= null;
		CommonMasterHandlerService commonMasterHandlerService=null;
			String code = "";
			String name = "";
			String jspName = "";
			String pojoPropertyCode = "";
			String jsp = "";
			String title = "";
			String message= " ";
			String url = "";
			String viewPage = "";
			String pojoName= "";
			String pojoPropertyName = "";
			String currentDate = "";
			String currentTime = "";
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = null;
			String userName = "";
	
//--------------------------------------Anesthesia-----------------------------------------			
		@SuppressWarnings("unchecked")
		 public ModelAndView showAnesthesiaJsp(HttpServletRequest request,HttpServletResponse response)
		 {
		  session = request.getSession();
		  map = (Map<String, Object>) otMasterHandlerService.showAnesthesiaJsp();
	      jsp = ANESTHESIA_JSP;
		  jsp += ".jsp";
		  title = "Anesthesia";
		  map.put("contentJsp",jsp);
		  map.put("title", title);
		  return new ModelAndView("indexB", "map", map);
		 }

	public ModelAndView searchAnesthesia(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
	  Map<String, Object> map= new HashMap<String, Object>();  
	  String anesthesiaCode  = null;
	  String anesthesiaName = null;
	  String searchField= null;

	  if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
		  anesthesiaCode = request.getParameter(CODE);
	  }
	  if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		  anesthesiaName = request.getParameter(SEARCH_NAME);
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
		  anesthesiaCode=searchField;
		  anesthesiaName=null;
	   
	  }else{
		  anesthesiaCode=null;
		  anesthesiaName=searchField;
	  }	  
	  map = otMasterHandlerService.searchAnesthesia(anesthesiaCode, anesthesiaName);
	  jsp=ANESTHESIA_JSP;
	  jsp += ".jsp";
	  map.put("search","search");
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  map.put("anesthesiaCode",anesthesiaCode);
	  map.put("anesthesiaName",anesthesiaName);
	  return new ModelAndView("indexB", "map", map);
	 }	 

	 @SuppressWarnings("unchecked")
	 public ModelAndView addAnesthesia(HttpServletRequest request, HttpServletResponse response) 
	 {
	  Map<String,Object> map=new HashMap<String,Object>();
	  MasAnesthesia masAnesthesia=new MasAnesthesia();
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
	  List anesthesiaCodeList = new ArrayList();
	  List anesthesiaNameList = new  ArrayList();

	  if(listMap.get("duplicateGeneralCodeList") != null){
		  anesthesiaCodeList = (List)listMap.get("duplicateGeneralCodeList");
	  }
	  if(listMap.get("duplicateGeneralNameList") != null){
		  anesthesiaNameList = (List)listMap.get("duplicateGeneralNameList");
	  }
	  boolean successfullyAdded = false;
	  if((anesthesiaCodeList.size() == 0 || anesthesiaCodeList == null) && (anesthesiaNameList.size() == 0 || anesthesiaNameList == null))
	  {
	   masAnesthesia.setAnesthesiaCode(code);
	   masAnesthesia.setAnesthesiaName(name);
	   masAnesthesia.setStatus("y");
	   masAnesthesia.setLastChgBy(changedBy);
	   masAnesthesia.setLastChgDate(currentDate);
	   masAnesthesia.setLastChgTime(currentTime);
	   successfullyAdded = otMasterHandlerService.addAnesthesia(masAnesthesia);  
	   if(successfullyAdded)	   {
	    message="Record Added Successfully !!";
	   }
	   else
	   {
	    message="Try Again !!";
	   }
	  }

	  else if((anesthesiaCodeList.size() != 0 || anesthesiaCodeList != null) || (anesthesiaNameList.size() != 0) || anesthesiaNameList != null){		  
	   if((anesthesiaCodeList.size() != 0 || anesthesiaCodeList != null) && (anesthesiaNameList.size() == 0 || anesthesiaNameList == null)){
		   message = "Anesthesia Code  already exists.";
	   }
	   else if((anesthesiaNameList.size() != 0 || anesthesiaNameList != null) && (anesthesiaCodeList.size() == 0 || anesthesiaCodeList == null) ){
	    message = "Anesthesia Name already exists.";
	   }
	   else if((anesthesiaCodeList.size() != 0 || anesthesiaCodeList != null) && (anesthesiaNameList.size() != 0 || anesthesiaNameList != null)){
	    message = "Anesthesia Code and Anesthesia Name already exist.";
	   }
	  }
	  url = "/hms/hms/otMaster?method=showAnesthesiaJsp";
	  try{
		   map = otMasterHandlerService.showAnesthesiaJsp();
		    }catch (Exception e) {
		     e.printStackTrace();
		    }
		    jsp= ANESTHESIA_JSP;
		    title="Add Anesthesia";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	 }

	 public ModelAndView editAnesthesia(HttpServletRequest request, HttpServletResponse response) 
	 {
	  Map<String, Object> map = new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();
	  Map<String, Object> listMap = new HashMap<String, Object>();
	  
	  String anesthesiaCode="";
	  String anesthesiaName="";
	  int anesthesiaId=0;
	  String changedBy = "";
	  @SuppressWarnings("unused")
	  Date changedDate = null;
	  @SuppressWarnings("unused")
	  String changedTime = "";
	  Date currentDate = null;
	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		  anesthesiaId =Integer.parseInt( request.getParameter(COMMON_ID));
	  }
	  if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
		  anesthesiaCode = request.getParameter(CODE);
	  }
	  if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		  anesthesiaName = request.getParameter(SEARCH_NAME);
	  }
	  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
	   changedBy = request.getParameter(CHANGED_BY);
	  }
	  if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
	   currentTime = request.getParameter(CHANGED_TIME);
	  }
	  if(request.getParameter("title") != null){
	   title = request.getParameter("title"); 
	  }
	  if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
	  changedDate = new Date();
	  changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

	  generalMap.put("id", anesthesiaId);
	  generalMap.put("anesthesiaCode", anesthesiaCode);
	  generalMap.put("name", anesthesiaName);
	  generalMap.put("changedBy", changedBy);
	  generalMap.put("currentDate", changedDate);
	  generalMap.put("currentTime", changedTime);
	  generalMap.put("pojoPropertyName", pojoPropertyName);
	  generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingAnesthesiaNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingAnesthesiaNameList.size() == 0)
		{
	  dataUpdated=otMasterHandlerService.editAnesthesiaToDatabase(generalMap);
	  if(dataUpdated==true){
	   message="Data Updated Successfully !!";
	  }
	  else{
	   message="Data Cant Be Updated !!";
	  }
		} 
		else if(existingAnesthesiaNameList.size() > 0){

			message = "Name already exists.";
		}
	  url = "/hms/hms/otMaster?method=showAnesthesiaJsp";
	  try{
		   map = otMasterHandlerService.showAnesthesiaJsp();
		    }catch (Exception e) {
		     //System.out.println("Exception in showAnesthesiaJsp "+e);
		    }
		    jsp= ANESTHESIA_JSP;
		    title="update Anesthesia";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	  }

	 public ModelAndView deleteAnesthesia(HttpServletRequest request, HttpServletResponse response) {
	  Map<String, Object> map = new HashMap<String, Object>();
	  int anesthesiaId=0;
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
		  anesthesiaId =Integer.parseInt( request.getParameter(COMMON_ID));
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
	  dataDeleted=otMasterHandlerService.deleteAnesthesia(anesthesiaId,generalMap);
	  if (dataDeleted == true)
	  {
	   message="Record is InActivated successfully !!";
	   }
	  else{
	   message="Record is Activated successfully !!";
	  }
	  url = "/hms/hms/otMaster?method=showAnesthesiaJsp";
	  try{
		   map = otMasterHandlerService.showAnesthesiaJsp();
		    }catch (Exception e) {
		     //System.out.println("Exception in showAnesthesiaJsp "+e);
		    }
		    jsp= ANESTHESIA_JSP;
		    title="delete Anesthesia";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	 }
	//****************************************** Start Of OT Master by Mansi ****************************//


		
		public ModelAndView searchOt(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();		
			String otCode  = null;
			String otName = null;
			String searchField= null;

			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				otCode = request.getParameter(CODE);
			}

			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				otName = request.getParameter(SEARCH_NAME);
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
				otCode=searchField;
				otName=null;

			}else{
				otCode=null;
				otName=searchField;
			}
			map = otMasterHandlerService.searchOt(otCode, otName);

			jsp=OT_JSP;

			jsp += ".jsp";
			
			map.put("search", "search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("otCode",otCode);
			map.put("otName",otName);
			return new ModelAndView("indexB", "map", map);
		}
		
		
		@SuppressWarnings("unchecked")
		public ModelAndView showOtJsp(HttpServletRequest request,HttpServletResponse response)
		{

			Map<String, Object> map = new HashMap<String, Object>();
			map = otMasterHandlerService.showOtJsp();
			String jsp=OT_JSP;
			jsp += ".jsp";
			title = "Ot";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB","map",map);
		}
		@SuppressWarnings("unchecked")
		public ModelAndView addOt(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			MasOt ot=new MasOt();
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
			int hospitalId=0;
			if(request.getParameter(HOSPITAL_ID) != null && !(request.getParameter(HOSPITAL_ID).equals(""))){
				hospitalId =Integer.parseInt(request.getParameter(HOSPITAL_ID)) ;
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
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);

			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);

			List otCodeList = new ArrayList();
			List otNameList = new  ArrayList();

			if(listMap.get("duplicateGeneralCodeList") != null){
				otCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				otNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if((otCodeList.size() == 0 || otCodeList == null) && (otNameList.size() == 0 || otNameList == null))
			{
				ot.setOtCode(code);
				ot.setOtName(name);
					
				ot.setStatus("y");
				ot.setLastChgBy(changedBy);
				ot.setLastChgDate(currentDate);
				ot.setLastChgTime(currentTime);
				
				MasHospital hospital= new MasHospital();
				hospital.setId(hospitalId);
				ot.setHospital(hospital);
				
				successfullyAdded = otMasterHandlerService.addOt(ot);		

				if(successfullyAdded){
					message="Record Added Successfully !!";
				}
				else{
					message="Try Again !!";
				}
			}

			else if((otCodeList.size() != 0 || otCodeList != null) || (otNameList.size() != 0) || otNameList != null)
			{
				if((otCodeList.size() != 0 || otCodeList != null) && (otNameList.size() == 0 || otNameList == null)){

					message = "Ot Code  already exists.";
				}
				else if((otNameList.size() != 0 || otNameList != null) && (otCodeList.size() == 0 || otCodeList == null) ){

					message = "Ot Name already exists.";
				}
				else if((otCodeList.size() != 0 || otCodeList != null) && (otNameList.size() != 0 || otNameList != null)){

					message = "Ot Code and Ot Name already exist.";
				}
			}
			
			try{
				map = otMasterHandlerService.showOtJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OT_JSP;
			title="Add OPD Ot";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView editOt(HttpServletRequest request, HttpServletResponse response) 
		{

			Map<String, Object>	map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			session=request.getSession(true);
			String otCode="";
			String otName="";
			int otId=0;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;

			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				otId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				otCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				otName = request.getParameter(SEARCH_NAME);
			}
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				changedBy = request.getParameter(CHANGED_BY);
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

			generalMap.put("id", otId);
			generalMap.put("otCode", otCode);
			generalMap.put("name", otName);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	generalMap.put("flag", true);
			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			List existingOtNameList = (List)listMap.get("duplicateMastersList");
			  boolean dataUpdated=false;
			  if(existingOtNameList.size() == 0)
			  {
				  dataUpdated=otMasterHandlerService.editOtToDatabase(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(existingOtNameList.size() > 0){
				   message = "Name already exists.";
				  }
			url = "/hms/hms/opdMaster?method=showOtJsp";
			
			try{
				map = otMasterHandlerService.showOtJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OT_JSP;
			title="update OPD Ot";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);

		}

		public ModelAndView deleteOt(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			int otId=0;
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
				otId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=otMasterHandlerService.deleteOt(otId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}

			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/opdMaster?method=showOtJsp";
			
			try{
				map = otMasterHandlerService.showOtJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OT_JSP;
			title="delete OPD Ot";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		

		@SuppressWarnings("unchecked")
		public ModelAndView showOtDistributionJsp(HttpServletRequest request,HttpServletResponse response)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map = otMasterHandlerService.showOtDistributionJsp();
			String jsp=OT_DISTRIBUTION_JSP;
			jsp += ".jsp";
			title = "Ot Distribution";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB","map",map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addOtDistribution(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			MasOtDistribution masOtDistribution=new MasOtDistribution();
			
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			String changedBy = "";
			int departmentId =0;
			int otId =0;
			String days="";
			Date validityStartDate = new Date();
			Map<String, Object> listMap=new HashMap<String, Object>();
			if (request.getParameter(DEPARTMENT_ID) != null) {
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			}
			if (request.getParameter(OT_ID) != null) {
				otId = Integer.parseInt(request.getParameter(OT_ID));
			}
			if (request.getParameter(DAYS) != null) {
				days = request.getParameter(DAYS);
			}
		
			if(request.getParameter(START_DATE) != null && !(request.getParameter(START_DATE).equals(""))){
				validityStartDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(START_DATE));
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
			int hospitalId=0;
			if(request.getParameter(HOSPITAL_ID) != null && !(request.getParameter(HOSPITAL_ID).equals(""))){
				hospitalId =Integer.parseInt(request.getParameter(HOSPITAL_ID)) ;
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
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("otId", otId);
			generalMap.put("days", days);
			generalMap.put("departmentId", departmentId);
			generalMap.put("hospitalId", hospitalId);
			//System.out.println("validityStartDate-->"+validityStartDate);
			generalMap.put("validityStartDate", validityStartDate);
			listMap = otMasterHandlerService.checkForExistingDaysOt(generalMap);
			List duplicateDaysOtList = new ArrayList();
			
			if(listMap.get("duplicateDaysOtList") != null){
				duplicateDaysOtList = (List)listMap.get("duplicateDaysOtList");
			}
			
			boolean successfullyAdded = false;
			if((duplicateDaysOtList.size() == 0 || duplicateDaysOtList == null))
				
			{
			//System.out.println("otId>>>>>>>>>>>>>>>>>>>>>>>>>"+otId);
			masOtDistribution.setDays(days);
			
			masOtDistribution.setValidityStartDate(validityStartDate);
				
						
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			masOtDistribution.setDepartment(masDepartment);
				
					
			MasOt masOt= new MasOt();
			masOt.setId(otId);
			masOtDistribution.setOt(masOt);
				
			masOtDistribution.setStatus("y");
			masOtDistribution.setLastChgBy(changedBy);
			masOtDistribution.setLastChgDate(currentDate);
			masOtDistribution.setLastChgTime(currentTime);
			
			MasHospital hospital= new MasHospital();
			hospital.setId(hospitalId);
			masOtDistribution.setHospital(hospital);
			
			successfullyAdded = otMasterHandlerService.addOtDistribution(masOtDistribution);	
					
				if(successfullyAdded){
					message="Record Added Successfully !!";
				}else{
					message="Try Again !!";
				}
			}
			else if(duplicateDaysOtList.size() != 0 ){


					message = "Ot Name , Days and Department Name already exist.";
			}

			try{
				map = otMasterHandlerService.showOtDistributionJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			jsp=OT_DISTRIBUTION_JSP;
			title="Add Ot Distribution";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		public ModelAndView editOtDistribution(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object>	map = new HashMap<String,Object>();
			session=request.getSession(true);
			Map<String, Object> generalMap = new HashMap<String, Object>();
			String changedBy = "";
			Date changedDate = null;
			String changedTime = "";
			int departmentId =0;
			int otId =0;
			String days="";
			int otDistributionId=0;	
			Date validityStartDate = new Date();

			if (request.getParameter(COMMON_ID) != null) {
				otDistributionId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(DEPARTMENT_ID) != null) {
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			}
			if (request.getParameter(OT_ID) != null) {
				otId = Integer.parseInt(request.getParameter(OT_ID));
			}
			if (request.getParameter(DAYS) != null) {
				days = request.getParameter(DAYS);
			}
		
			if(request.getParameter(START_DATE) != null && !(request.getParameter(START_DATE).equals(""))){
				
				validityStartDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(START_DATE));
			}
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				changedBy = request.getParameter(CHANGED_BY);
			}
			
			changedDate = new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

			generalMap.put("id", otDistributionId);
			generalMap.put("days",days);
			generalMap.put("otId", otId);
			generalMap.put("validityStartDate", validityStartDate);
			generalMap.put("departmentId", departmentId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("flag", true);

			Map<String, Object> listMap = new HashMap<String, Object>();
			listMap = otMasterHandlerService.checkForExistingDaysOt(generalMap);
			List duplicateDaysOtList = new ArrayList();
			
			if(listMap.get("duplicateDaysOtList") != null){
				duplicateDaysOtList = (List)listMap.get("duplicateDaysOtList");
			}
			
			boolean dataUpdated=false;
			if((duplicateDaysOtList.size() == 0 || duplicateDaysOtList == null))
			{
			dataUpdated=otMasterHandlerService.editOtDistribution(generalMap);
			if(dataUpdated==true){
				message="Record Updated Successfully !!";
			}
			else{
				message="Record Cant be updated !!";
			}
			}
			else if(duplicateDaysOtList.size() != 0 ){


				message = "Ot Name , Days and  Department Name already exist.";
			}

			try{
				map = otMasterHandlerService.showOtDistributionJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OT_DISTRIBUTION_JSP;
			title="Edit Ot Distribution";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView deleteOtDistribution(HttpServletRequest request, HttpServletResponse response) {
			Map<String,Object> map = new HashMap<String,Object>();
			int otDistributionId=0;
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
				otDistributionId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=otMasterHandlerService.deleteOtDistribution(otDistributionId,generalMap);

			if (dataDeleted==true){
				message="Record is InActivated successfully !!";
			}else{
				message="Record is Activated successfully !!";
			}
			try{
				map = otMasterHandlerService.showOtDistributionJsp();
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OT_DISTRIBUTION_JSP;
			title="Delete Ot Distribution";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		public ModelAndView searchOtDistribution(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();		
			String oTName  = "";
			String days  = "";
			String searchField= null;
			
			if(request.getParameter(OT_NAME) != null && !(request.getParameter(OT_NAME).equals(""))){
				oTName = request.getParameter(OT_NAME);
			}
			if(request.getParameter(DAYS) != null && !(request.getParameter(DAYS).equals(""))){
				days = request.getParameter(DAYS);
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
				oTName=searchField;
				days=null;
			}else{
				oTName=null;
				days=searchField;
			}	
			map = otMasterHandlerService.searchOtDistribution(oTName,days);

			jsp=OT_DISTRIBUTION_JSP;
			jsp += ".jsp";
			map.put("search","search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("oTName",oTName);
			map.put("days",days);
			return new ModelAndView("indexB", "map", map);
		}
		
		//---------------------------------------  Master OT Charge Details -------------------------
		
		@SuppressWarnings("unchecked")
		public ModelAndView showOtMasChargeDetailsJsp(HttpServletRequest request,HttpServletResponse response)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map = otMasterHandlerService.showOtMasChargeDetailsJsp();
			String jsp=OT_CHANGE_DETAILS;
			jsp += ".jsp";
			title = "Ot Charge Details";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB","map",map);
		}
		@SuppressWarnings("unchecked")
		public ModelAndView addOtMasChargeDetails(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			OtMasChargeDetails masChargeDetails=new OtMasChargeDetails();
			
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			String changedBy = "";
			int chargeCodeId =0;
			String otChargeType ="";
			String approxDuration="";
			if (request.getParameter(CHARGE_CODE_ID) != null) {
				chargeCodeId = Integer.parseInt(request.getParameter(CHARGE_CODE_ID));
			}
			
			if (request.getParameter(TYPE_OF_REG) != null) {
				otChargeType = request.getParameter(TYPE_OF_REG);
			}
		
			if (request.getParameter(TIME) != null) {
				approxDuration = request.getParameter(TIME);
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
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("chargeCodeId", chargeCodeId);
			generalMap.put("otChargeType", otChargeType);
			
			Map<String, Object> listMap = new HashMap<String, Object>();
			listMap = otMasterHandlerService.checkForExistingChargeCodeId(generalMap);
			List duplicateChargeCodeIdList = new ArrayList();
			
			if(listMap.get("duplicateChargeCodeIdList") != null){
				duplicateChargeCodeIdList = (List)listMap.get("duplicateChargeCodeIdList");
			}if((duplicateChargeCodeIdList.size() == 0 || duplicateChargeCodeIdList == null))
				
			{
			boolean successfullyAdded = false;
			
			masChargeDetails.setOtChargeType(otChargeType);
			
			MasChargeCode masChargeCode = new MasChargeCode();
			masChargeCode.setId(chargeCodeId);
			masChargeDetails.setChargeCode(masChargeCode);
				
			masChargeDetails.setApproxDuration(approxDuration);		
			
			masChargeDetails.setStatus("y");
			masChargeDetails.setLastChgBy(changedBy);
			masChargeDetails.setLastChgDate(currentDate);
			masChargeDetails.setLastChgTime(currentTime);
			successfullyAdded = otMasterHandlerService.addOtMasChargeDetails(masChargeDetails);	
					
				if(successfullyAdded){
					message="Record Added Successfully !!";
				}else{
					message="Try Again !!";
				}
			
			}else if(duplicateChargeCodeIdList.size() != 0 ){


					message = "Charge Code Name is exist.";
			}

			try{
				map = otMasterHandlerService.showOtMasChargeDetailsJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			jsp=OT_CHANGE_DETAILS;
			title="Add Ot Master Charge Details";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		public ModelAndView editOtMasChargeDetails(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object>	map = new HashMap<String,Object>();
			session=request.getSession(true);
			Map<String, Object> generalMap = new HashMap<String, Object>();
			String changedBy = "";
			Date changedDate = null;
			String changedTime = "";
			int otMasChargeDetailsId=0;	
			String chargeCodeName ="";
			String otChargeType ="";
			String approxDuration="";
			if (request.getParameter(CHARGE_CODE_NAME) != null) {
				chargeCodeName = request.getParameter(CHARGE_CODE_NAME);
			}
			
			if (request.getParameter(TYPE_OF_REG) != null) {
				otChargeType = request.getParameter(TYPE_OF_REG);
			}
		
			if (request.getParameter(TIME) != null) {
				approxDuration = request.getParameter(TIME);
			}
			

			if (request.getParameter(COMMON_ID) != null) {
				otMasChargeDetailsId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				changedBy = request.getParameter(CHANGED_BY);
			}
			
			changedDate = new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

			generalMap.put("id", otMasChargeDetailsId);
			generalMap.put("approxDuration",approxDuration);
			generalMap.put("otChargeType", otChargeType);
		
			
			generalMap.put("chargeCodeName", chargeCodeName);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("flag", true);

			Map<String, Object> listMap = new HashMap<String, Object>();
			listMap = otMasterHandlerService.checkForExistingChargeCodeName(generalMap);
			
			List duplicateChargeCodeNameList = (List)listMap.get("duplicateChargeCodeNameList");
			  boolean dataUpdated=false;
			  if(duplicateChargeCodeNameList.size() == 0)
			  {
				  dataUpdated=otMasterHandlerService.editOtMasChargeDetails(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(duplicateChargeCodeNameList.size() > 0){
							message = "Charge Code Name, OT Charge Type and Approx. Duration exist.";
			}

			try{
				map = otMasterHandlerService.showOtMasChargeDetailsJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OT_CHANGE_DETAILS;
			title="Edit Ot Charge Details";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView deleteOtMasChargeDetails(HttpServletRequest request, HttpServletResponse response) {
			Map<String,Object> map = new HashMap<String,Object>();
			int otMasChargeDetailsId=0;
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
				otMasChargeDetailsId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=otMasterHandlerService.deleteOtMasChargeDetails(otMasChargeDetailsId,generalMap);

			if (dataDeleted==true){
				message="Record is InActivated successfully !!";
			}else{
				message="Record is Activated successfully !!";
			}
			try{
				map = otMasterHandlerService.showOtMasChargeDetailsJsp();
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OT_CHANGE_DETAILS;
			title="Delete Ot Charge Details";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		public ModelAndView searchOtMasChargeDetails(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();		
			String chargeCodeName  = "";
				
			try{
				if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
					chargeCodeName = request.getParameter(SEARCH_FIELD);
				}
				//System.out.println("chargeCodeName"+chargeCodeName);
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		
			map = otMasterHandlerService.searchOtMasChargeDetails(chargeCodeName);

			jsp=OT_CHANGE_DETAILS;
			jsp += ".jsp";
			map.put("search","search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("chargeCodeName",chargeCodeName);
			return new ModelAndView("indexB", "map", map);
		}
		public ModelAndView getChageCodeByAutocomplete(HttpServletRequest request, HttpServletResponse response) {
		// --------------------------------------------------------------------------------
			String chargeCodeNameField = "";
			String autoHint = "";
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("requiredField") != null) {
				chargeCodeNameField = (request.getParameter("requiredField"));
				//System.out.println("chargeCodeNameField   "+chargeCodeNameField);
			}
			if (request.getParameter(chargeCodeNameField) != null) {
				autoHint = (request.getParameter(chargeCodeNameField));
				//System.out.println("autoHint   "+autoHint );
			}
			dataMap.put("autoHint", autoHint);
			map = otMasterHandlerService.getChageCodeByAutocomplete(dataMap);
			jsp = "resultOtChargeCodeName";
			return new ModelAndView(jsp, "map", map);
		}
		@SuppressWarnings("unchecked")
		public void fillChargeCodeNameInGrid(HttpServletRequest request,HttpServletResponse response) {

			int deptId = 0;
			int hospitalId = 0;
			String userName = "";
			HttpSession session = request.getSession();
			if (session.getAttribute("userName") != null)
				userName = (String) session.getAttribute("userName");
			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));

			Map<String, Object> dataMap = new HashMap<String, Object>();
			List<MasChargeCode> masChargeCodeList= new ArrayList<MasChargeCode>();

			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			map = otMasterHandlerService.fillChargeCodeNameInGrid(dataMap);
			if (map.get("masChargeCodeList") != null) {
				masChargeCodeList = (List) map.get("masChargeCodeList");
			}
			StringBuffer sb = new StringBuffer();
			try {
				for (MasChargeCode masChargeCode : masChargeCodeList) {
					sb.append("<item>");
					sb.append("<id>" + masChargeCode.getId() + "</id>");
					sb.append("</item>");
				}
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		public ModelAndView showOpInstructionJsp(HttpServletRequest request,HttpServletResponse response)
		{
			session = request.getSession();
			map = otMasterHandlerService.showOpInstructionJsp();
			jsp = "opInstruction";
			jsp += ".jsp";
			title = "Ward Impanneled ";
			map.put("contentJsp",jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);
		}


		@SuppressWarnings("unchecked")
		public ModelAndView addOpInstructionJsp(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			MasOpInstruction  masOpInstruction=new MasOpInstruction();
			HttpSession session = request.getSession();
			String message = "";
			int instruction=0;
			Map<String,Object> listMap=new HashMap<String,Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();

			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
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
			if(request.getParameter("instruction") != null && !(request.getParameter("instruction").equals("0"))){
				instruction = Integer.parseInt(request.getParameter("instruction"));
			}
			
		
			generalMap.put("name", name);
			generalMap.put("instruction", instruction);
			

			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);

			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);

			listMap = otMasterHandlerService.checkForExistingOpInstruction(generalMap);

			List opInstructionList = new  ArrayList();

			if(listMap.get("opInstructionList") != null){
				opInstructionList = (List)listMap.get("opInstructionList");
			}
		
			boolean successfullyAdded = false;

			if((opInstructionList.size() == 0 || opInstructionList == null))
			{
				masOpInstruction.setInstruction(name);
				
				MasInstruction mih = new MasInstruction();
				mih.setId(instruction);
				masOpInstruction.setOp(mih);
				
				masOpInstruction.setStatus("y");
				
				Users user = (Users)session.getAttribute("users");
				masOpInstruction.setLastChgBy(user);
				
				masOpInstruction.setLastChgDate(currentDate);
				masOpInstruction.setLastChgTime(currentTime);
				successfullyAdded = otMasterHandlerService.addOpInstructionJsp(masOpInstruction);		

				if(successfullyAdded)
				{
					message="Record Added Successfully !!";

				}
				else
				{
					message="Try Again  !!";
				}
			}

			else if((opInstructionList.size() != 0 || opInstructionList != null)){ 
					message = "Instruction Name and OP Instruction already exists.";
				}
				

			url = "/hms/hms/generalMaster?method=showOpInstructionJsp";
			
			try{
				map = otMasterHandlerService.showOpInstructionJsp();
				
			}catch (Exception e) {
				//System.out.println("Exception in showUnitOfMeasurementJsp "+e);
			}
			jsp="opInstruction";
			title="Add opInstruction";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView editOpInstruction(HttpServletRequest request, HttpServletResponse response) 
		{

			Map<String, Object>	map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			String opInstructionName="";
			int instruction=0;
			int opInstructionId=0;
			String message = "";
			Date changedDate = null;
			@SuppressWarnings("unused")
			String changedTime = "";
			HttpSession session = request.getSession();
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				opInstructionId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				opInstructionName = request.getParameter(SEARCH_NAME);
			}
		
			if(request.getParameter("instruction") != null && !(request.getParameter("instruction").equals("0"))){
				instruction =Integer.parseInt( request.getParameter("instruction"));
			}
			Users user = (Users)session.getAttribute("users");
		
			changedDate = new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

			generalMap.put("id", opInstructionId);
			generalMap.put("name", opInstructionName);
			generalMap.put("instruction", instruction);
			generalMap.put("changedBy", user);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			
	    	 generalMap.put("flag", true);
			
	    	 listMap = otMasterHandlerService.checkForExistingOpInstruction(generalMap);
			 
	    	 List opInstructionList = (List)listMap.get("opInstructionList");
			  boolean dataUpdated=false;
			  if(opInstructionList.size() == 0)
			  {
				  dataUpdated=otMasterHandlerService.editOpInstruction(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(opInstructionList.size() > 0){
				  message = "Instruction Name and OP Instruction already exists.";
				  }
			url = "/hms/hms/otMaster?method=showOpInstructionJsp";
			
			try{
				map = otMasterHandlerService.showOpInstructionJsp();
				
			}catch (Exception e) {
				//System.out.println("Exception in showUnitOfMeasurementJsp "+e);
			}
			jsp="opInstruction";
			title="Update Of Ward Impanneled ";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView deleteOpInstruction(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int opInstructionId=0;
		
			String message = "";
			String changedTime = "";
			Date changedDate = null;
			String flag =""; 
			HttpSession session = request.getSession();
			Users user = (Users)session.getAttribute("users");
			
			if(request.getParameter("flag") != null){
				flag = request.getParameter("flag"); 
				generalMap.put("flag", flag);
			}
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				opInstructionId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter("title") != null){
				title = request.getParameter("title"); 
			}
		
			changedDate= new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

			generalMap.put("changedBy", user);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted=false;
			dataDeleted=otMasterHandlerService.deleteOpInstruction(opInstructionId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}

			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/generalMaster?method=showOpInstructionJsp";
			
			try{
				map = otMasterHandlerService.showOpInstructionJsp();
				
			}catch (Exception e) {
				e.printStackTrace();;
			}
			jsp="opInstruction";
			title="Delete Ward Impanneled ";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		public ModelAndView searchOpInstruction(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();		
			int  instructionSearch  = 0;

			if(request.getParameter("instructionSearch") != null && !(request.getParameter("instructionSearch").equals("0"))){
				instructionSearch = Integer.parseInt(request.getParameter("instructionSearch"));
			}


			
			map = otMasterHandlerService.searchOpInstruction(instructionSearch);

			jsp="opInstruction";

			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("instructionSearch",instructionSearch);
			return new ModelAndView("indexB", "map", map);
		}

		

//---------------------------------------------------------------------------------------------------------
	public OTMasterHandlerService getOtMasterHandlerService() {
		return otMasterHandlerService;
	}

	public void setOtMasterHandlerService(
			OTMasterHandlerService otMasterHandlerService) {
		this.otMasterHandlerService = otMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
 


}