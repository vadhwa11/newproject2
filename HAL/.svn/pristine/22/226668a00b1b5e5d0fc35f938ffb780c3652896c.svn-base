package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAdmissionType;
import jkt.hms.masters.business.MasBlock;
import jkt.hms.masters.business.MasCaste;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasDivision;
import jkt.hms.masters.business.MasDocument;
import jkt.hms.masters.business.MasEmployeeType;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasImmunization;
import jkt.hms.masters.business.MasImpanneledHospital;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasUnitOfMeasurement;
import jkt.hms.masters.business.MasWardImpanneledHospital;
import jkt.hms.masters.business.MasZonal;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.MasProposedMPR;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.GeneralMasterHandlerService;
import jkt.hms.util.HMSUtil;

import org.hibernate.dialect.IngresDialect;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class GeneralMasterController extends MultiActionController{

	GeneralMasterHandlerService generalMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	MasUnitOfMeasurement masUnitOfMeasurement = new MasUnitOfMeasurement(); 
	MasPatientType masPatientType = new MasPatientType();

	String code = "";
	String name = "";
	String currentDate = "";
	String currentTime = "";
	String jspName = "";
	String jsp = "";
	String title = "";
	String message= " ";
	String url = "";
	String viewPage = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String status ="";
	int id = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	HttpSession session = null;
	String userName = "";


//	-----------------------------------------Title------------------------------------------------

	public ModelAndView searchTitle(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String titleCode  = null;
		String titleName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			titleCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			titleName = request.getParameter(SEARCH_NAME);
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
			titleCode=searchField;
			titleName=null;

		}else{
			titleCode=null;
			titleName=searchField;
		}
		map = generalMasterHandlerService.searchTitle(titleCode, titleName);

		jsp=TITLE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("titleCode",titleCode);
		map.put("titleName",titleName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showTitleJsp(HttpServletRequest request,HttpServletResponse response)
	{

		Map map = new HashMap();
		map = generalMasterHandlerService.showTitleJsp();
		//System.out.println("map  "+map.size());
		String jsp=TITLE_JSP;
		jsp += ".jsp";
		title = "Title";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addTitle(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MasTitle masTitle=new MasTitle();
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


		List titleCodeList = new ArrayList();
		List titleNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			titleCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			titleNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((titleCodeList.size() == 0 || titleCodeList == null) && (titleNameList.size() == 0 || titleNameList == null))
		{
			masTitle.setTitleCode(code);
			masTitle.setTitleName(name);
			masTitle.setStatus("y");
			masTitle.setLastChgBy(changedBy);
			masTitle.setLastChgDate(currentDate);
			masTitle.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addTitle(masTitle);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}
			else{
				message="Try Again !!";
			}
		}

		else if((titleCodeList.size() != 0 || titleCodeList != null) || (titleNameList.size() != 0) || titleNameList != null)
		{
			if((titleCodeList.size() != 0 || titleCodeList != null) && (titleNameList.size() == 0 || titleNameList == null)){

				message = "Title Code  already exists.";
			}
			else if((titleNameList.size() != 0 || titleNameList != null) && (titleCodeList.size() == 0 || titleCodeList == null) ){

				message = "Title Name already exists.";
			}
			else if((titleCodeList.size() != 0 || titleCodeList != null) && (titleNameList.size() != 0 || titleNameList != null)){

				message = "Title Code and Title Name already exist.";
			}
		}
		
		try{
			map = generalMasterHandlerService.showTitleJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=TITLE_JSP;
		title="Add Title";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editTitle(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String titleCode="";
		String titleName="";
		int titleId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			titleId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			titleCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			titleName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", titleId);
		generalMap.put("titleCode", titleCode);
		generalMap.put("name", titleName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingTitleNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingTitleNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editTitleToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingTitleNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showTitleJsp";
		
		try{
			map = generalMasterHandlerService.showTitleJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=TITLE_JSP;
		title="update Title";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteTitle(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int titleId=0;
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
			titleId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteTitle(titleId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showTitleJsp";
		
		try{
			map = generalMasterHandlerService.showTitleJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=TITLE_JSP;
		title="delete Title";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
//	-----------------------------------------------------Relation--------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showRelationJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = generalMasterHandlerService.showRelationJsp();
		jsp = RELATION_JSP;
		jsp += ".jsp";
		title = "Relation";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchRelation(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();  
		String relationCode  = null;
		String relationName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			relationCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			relationName = request.getParameter(SEARCH_NAME);
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
			relationCode=searchField;
			relationName=null;

		}else{
			relationCode=null;
			relationName=searchField;
		}
		map = generalMasterHandlerService.searchRelation(relationCode, relationName);
		jsp=RELATION_JSP;
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("relationCode",relationCode);
		map.put("relationName",relationName);
		return new ModelAndView("indexB", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addRelation(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasRelation masRelation=new MasRelation();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

String codeRelation="";
String codeNewRelation="";

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		
		
		if (request.getParameter("codeRelation") != null) {
			codeRelation = request.getParameter("codeRelation");
		}
		if (request.getParameter("codeNewRelation") != null) {
			codeNewRelation = request.getParameter("codeNewRelation");
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

		List relationCodeList = new ArrayList();
		List relationNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			relationCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			relationNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((relationCodeList.size() == 0 || relationCodeList == null) && (relationNameList.size() == 0 || relationNameList == null))
		{
	
			
			masRelation.setRelationName(code);
			masRelation.setNewRelationName(name);
			masRelation.setRelationCode(codeRelation);
			masRelation.setNewRelationCode(codeNewRelation);
			
			masRelation.setStatus("y");
			masRelation.setLastChgBy(changedBy);
			masRelation.setLastChgDate(currentDate);
			masRelation.setLastChgTime(currentTime);
			
			
			successfullyAdded = generalMasterHandlerService.addRelation(masRelation);  	 
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((relationCodeList.size() != 0 || relationCodeList != null) || (relationNameList.size() != 0) || relationNameList != null){
			if((relationCodeList.size() != 0 || relationCodeList != null) && (relationNameList.size() == 0 || relationNameList == null)){
				message = "Relation Name  already exists.";	  }
			else if((relationNameList.size() != 0 || relationNameList != null) && (relationCodeList.size() == 0 || relationCodeList == null) ){
				message = "New Relation Name already exists.";	  }
			else if((relationCodeList.size() != 0 || relationCodeList != null) && (relationNameList.size() != 0 || relationNameList != null)){
				message = "Relation Name and New Relation Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster/generalMaster?method=showRelationJsp";
		try{
			map = generalMasterHandlerService.showRelationJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=RELATION_JSP;
		title="Add Relation";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView editRelation(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		String relationCode="";
		String relationName="";
		int relationId=0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		String codeRelation="";
		String codeNewRelation="";

		if (request.getParameter("codeRelation") != null) {
			codeRelation = request.getParameter("codeRelation");
		}
		if (request.getParameter("codeNewRelation") != null) {
			codeNewRelation = request.getParameter("codeNewRelation");
		}

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			relationId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			relationCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			relationName = request.getParameter(SEARCH_NAME);
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
			title = request.getParameter("title"); 	 }
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		generalMap.put("id", relationId);
		generalMap.put("relationCode", relationCode);
		generalMap.put("name", relationName);
		
		generalMap.put("codeRelation", codeRelation);
		
		generalMap.put("codeNewRelation", codeNewRelation);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	 generalMap.put("flag", true);

		  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		  List existingRelationNameList = (List)listMap.get("duplicateMastersList");
		 
		  boolean dataUpdated=false;
		  if(existingRelationNameList.size() == 0)
		  {
		  
		dataUpdated=generalMasterHandlerService.editRelationToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}}
		  else if(existingRelationNameList.size() > 0){

			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showRelationJsp";
		try{
			map = generalMasterHandlerService.showRelationJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=RELATION_JSP;
		title="Update Relation";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteRelation(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int relationId=0;
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
			relationId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteRelation(relationId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated Successfully !!";
		}
		else{
			message="Record is Activated Successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showRelationJsp";
		try{
			map = generalMasterHandlerService.showRelationJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=RELATION_JSP;
		title="Delete Relation";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	//---------------------------------------------Disposal-------------------------------------------
	 @SuppressWarnings("unchecked")
	 public ModelAndView showDisposalJsp(HttpServletRequest request,HttpServletResponse response)
	 {
	  session = request.getSession();
	  map = (Map<String, Object>) generalMasterHandlerService.showDisposalJsp();
	  jsp = DISPOSAL_JSP;
	  jsp += ".jsp";
	  title = "Disposal";
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  return new ModelAndView("indexB", "map", map);
	 }
	public ModelAndView searchDisposal(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	 {
	  Map<String, Object> map= new HashMap<String, Object>();  
	  String disposalCode  = null;
	  String disposalName = null;
	  String searchField= null;

	  if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
		  disposalCode = request.getParameter(CODE);
	  }

	  if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		  disposalName = request.getParameter(SEARCH_NAME);
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
		  disposalCode=searchField;
		  disposalName=null;
	   
	  }else{
		  disposalCode=null;
		  disposalName=searchField;
	  }	  
	  map = generalMasterHandlerService.searchDisposal(disposalCode, disposalName);

	  jsp=DISPOSAL_JSP;
	  jsp += ".jsp";
	  map.put("search","search");
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  map.put("disposalCode",disposalCode);
	  map.put("disposalName",disposalName);
	  return new ModelAndView("indexB", "map", map);
	 }
	
	 @SuppressWarnings("unchecked")
	 public ModelAndView addDisposal(HttpServletRequest request, HttpServletResponse response) 
	 {
	  Map<String,Object> map=new HashMap<String,Object>();
	  MasDisposal masDisposal=new MasDisposal();
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
	  List disposalCodeList = new ArrayList();
	  List disposalNameList = new  ArrayList();

	  if(listMap.get("duplicateGeneralCodeList") != null){
		  disposalCodeList = (List)listMap.get("duplicateGeneralCodeList");

	  }
	  if(listMap.get("duplicateGeneralNameList") != null){
		  disposalNameList = (List)listMap.get("duplicateGeneralNameList");
	  }
	  boolean successfullyAdded = false;

	  if((disposalCodeList.size() == 0 || disposalCodeList == null) && (disposalNameList.size() == 0 || disposalNameList == null))
	  {
	   masDisposal.setDisposalCode(code);
	   masDisposal.setDisposalName(name);
	   masDisposal.setStatus("y");
	   masDisposal.setLastChgBy(changedBy);
	   masDisposal.setLastChgDate(currentDate);
	   masDisposal.setLastChgTime(currentTime);
	   successfullyAdded = generalMasterHandlerService.addDisposal(masDisposal);  

	   if(successfullyAdded)
	   {
	    message="Record Added Successfully !!";
	   }
	   else
	   {
	    message="Try Again !!";
	   }
	   }

	  else if((disposalCodeList.size() != 0 || disposalCodeList != null) || (disposalNameList.size() != 0) || disposalNameList != null){
	   if((disposalCodeList.size() != 0 || disposalCodeList != null) && (disposalNameList.size() == 0 || disposalNameList == null)){
	    message = "Disposal Code  already exists.";
	   }
	   else if((disposalNameList.size() != 0 || disposalNameList != null) && (disposalCodeList.size() == 0 || disposalCodeList == null) ){
	    message = "Disposal Name already exists.";	   }
	   else if((disposalCodeList.size() != 0 || disposalCodeList != null) && (disposalNameList.size() != 0 || disposalNameList != null)){
	    message = "Disposal Code and Disposal Name already exist.";
	   }
	  }
	  url = "/hms/hms/generalMaster?method=showDisposalJsp";
	  try{
		   map = generalMasterHandlerService.showDisposalJsp();
		    }catch (Exception e) {
		     //System.out.println("Exception in showDisposalJsp "+e);
		    }
		    jsp=DISPOSAL_JSP;
		    title="Add Disposal";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	 }

	 public ModelAndView editDisposal(HttpServletRequest request, HttpServletResponse response) 
	 {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			session=request.getSession();
			String disposalCode="";
			String disposalName="";
			int disposalId=0;
			String changedBy = "";
			@SuppressWarnings("unused")
			Date changedDate = null;
			@SuppressWarnings("unused")
			String changedTime = "";

			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				disposalId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				disposalCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				disposalName = request.getParameter(SEARCH_NAME);
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

			generalMap.put("id", disposalId);
			generalMap.put("disposalCode", disposalCode);
			generalMap.put("name", disposalName);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	 generalMap.put("flag", true);
			  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			  List existingDisposalNameList = (List)listMap.get("duplicateMastersList");
			  boolean dataUpdated=false;
			  if(existingDisposalNameList.size() == 0)
			  {
				  dataUpdated=generalMasterHandlerService.editDisposalToDatabase(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(existingDisposalNameList.size() > 0){
				   message = "Name already exists.";
				  }
			url = "/hms/hms/generalMaster?method=showDisposalJsp";
			try{
				map = generalMasterHandlerService.showDisposalJsp();
			}catch (Exception e) {
				//System.out.println("Exception in showDisposalJsp "+e);
			}
			jsp=DISPOSAL_JSP;
			title="update Disposal";
			jsp += ".jsp";		    
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

	 public ModelAndView deleteDisposal(HttpServletRequest request, HttpServletResponse response) {
	  Map<String, Object> map = new HashMap<String, Object>();
	  int disposalId=0;
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
		  disposalId =Integer.parseInt( request.getParameter(COMMON_ID));
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
	  dataDeleted=generalMasterHandlerService.deleteDisposal(disposalId,generalMap);
	  if (dataDeleted==true)
	  {

	   message="Record is InActivated Successfully !!";
	  }
	  else{
	   message="Record is Activated Successfully !!";
	  }
	  url = "/hms/hms/generalMaster?method=showDisposalJsp";
	  try{
		   map = generalMasterHandlerService.showDisposalJsp();
		    }catch (Exception e) {
		     //System.out.println("Exception in showDisposalJsp "+e);
		    }
		    jsp=DISPOSAL_JSP;
		    title="delete Disposal";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	 }

//	------------------------------------------- Marital Status ----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showMaritalStatusJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = generalMasterHandlerService.showMaritalStatusJsp();
		jsp = MARITAL_STATUS_JSP;
		jsp += ".jsp";
		title = "MaritalStatus";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchMaritalStatus(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();  
		String maritalStatusCode  = null;
		String maritalStatusName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			maritalStatusCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			maritalStatusName = request.getParameter(SEARCH_NAME);
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
			maritalStatusCode=searchField;
			maritalStatusName=null;

		}else{
			maritalStatusCode=null;
			maritalStatusName=searchField;
		}

		map = generalMasterHandlerService.searchMaritalStatus(maritalStatusCode, maritalStatusName);

		jsp=MARITAL_STATUS_JSP;		
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);	
		map.put("maritalStatusCode",maritalStatusCode);
		map.put("maritalStatusName",maritalStatusName);		
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMaritalStatus(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasMaritalStatus masMaritalStatus=new MasMaritalStatus();
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

		List maritalStatusCodeList = new ArrayList();
		List maritalStatusNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			maritalStatusCodeList = (List)listMap.get("duplicateGeneralCodeList");

		}
		if(listMap.get("duplicateGeneralNameList") != null){
			maritalStatusNameList = (List)listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if((maritalStatusCodeList.size() == 0 || maritalStatusCodeList == null) && (maritalStatusNameList.size() == 0 || maritalStatusNameList == null))
		{
			masMaritalStatus.setMaritalStatusCode(code);
			masMaritalStatus.setMaritalStatusName(name);
			masMaritalStatus.setStatus("y");
			masMaritalStatus.setLastChgBy(changedBy);
			masMaritalStatus.setLastChgDate(currentDate);
			masMaritalStatus.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addMaritalStatus(masMaritalStatus);  

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((maritalStatusCodeList.size() != 0 || maritalStatusCodeList != null) || (maritalStatusNameList.size() != 0) || maritalStatusNameList != null){
			if((maritalStatusCodeList.size() != 0 || maritalStatusCodeList != null) && (maritalStatusNameList.size() == 0 || maritalStatusNameList == null)){
				message = "Marital Status Code  already exists.";	   }
			else if((maritalStatusNameList.size() != 0 || maritalStatusNameList != null) && (maritalStatusCodeList.size() == 0 || maritalStatusCodeList == null) ){
				message = "Marital Status Name already exists.";	   }
			else if((maritalStatusCodeList.size() != 0 || maritalStatusCodeList != null) && (maritalStatusNameList.size() != 0 || maritalStatusNameList != null)){
				message = "Marital Status Code and Marital Status Name already exist.";
			}	  }

		url = "/hms/hms/generalMaster?method=showMaritalStatusJsp";
		try{
			map = generalMasterHandlerService.showMaritalStatusJsp();
		}catch (Exception e) {
			//System.out.println("Exception in showMaritalStatusJsp "+e);
		}
		jsp=MARITAL_STATUS_JSP;
		title="Add Marital Status";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editMaritalStatus(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String maritalStatusCode="";
		String maritalStatusName="";
		int maritalStatusId=0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			maritalStatusId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			maritalStatusCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			maritalStatusName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", maritalStatusId);
		generalMap.put("maritalStatusCode", maritalStatusCode);
		generalMap.put("name", maritalStatusName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	 generalMap.put("flag", true);
		  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		  List existingMaritalStatusNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingMaritalStatusNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editMaritalStatusToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingMaritalStatusNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showMaritalStatusJsp";
		try{
			map = generalMasterHandlerService.showMaritalStatusJsp();
		}catch (Exception e) {
			//System.out.println("Exception in showMaritalStatusJsp "+e);
		}
		jsp=MARITAL_STATUS_JSP;
		title="Update marital Status";
		jsp += ".jsp";			    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteMaritalStatus(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int maritalStatusId=0;
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
			maritalStatusId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteMaritalStatus(maritalStatusId,generalMap);
		if (dataDeleted==true)
		{		
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showMaritalStatusJsp";
		try{
			map = generalMasterHandlerService.showMaritalStatusJsp();
		}catch (Exception e) {
			//System.out.println("Exception in showMaritalStatusJsp "+e);
		}
		jsp=MARITAL_STATUS_JSP;
		title="Delete Marital Status";
		jsp += ".jsp";			    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

//	-------------------------------Religion--------------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showReligionJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = generalMasterHandlerService.showReligionJsp();
		jsp = RELIGION_JSP;
		jsp += ".jsp";
		title = "Religion";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchReligion(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();  
		String religionCode  = null;
		String religionName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			religionCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			religionName = request.getParameter(SEARCH_NAME);
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
			religionCode=searchField;
			religionName=null;
		}else{
			religionCode=null;
			religionName=searchField;
		}	  
		map = generalMasterHandlerService.searchReligion(religionCode, religionName);
		jsp=RELIGION_JSP;
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("religionCode",religionCode);
		map.put("religionName",religionName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addReligion(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasReligion masReligion=new MasReligion();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
String currentTime="";
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
		List religionCodeList = new ArrayList();
		List religionNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			religionCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			religionNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((religionCodeList.size() == 0 || religionCodeList == null) && (religionNameList.size() == 0 || religionNameList == null))
		{
			masReligion.setReligionCode(code);
			masReligion.setReligionName(name);
			masReligion.setStatus("y");
			masReligion.setLastChgBy(changedBy);
			masReligion.setLastChgDate(currentDate);
			masReligion.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addReligion(masReligion);  
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else {
				message="Try Again !!";
			}
		}

		else if((religionCodeList.size() != 0 || religionCodeList != null) || (religionNameList.size() != 0) || religionNameList != null){
			if((religionCodeList.size() != 0 || religionCodeList != null) && (religionNameList.size() == 0 || religionNameList == null)){
				message = "Religion Code  already exists.";	   }
			else if((religionNameList.size() != 0 || religionNameList != null) && (religionCodeList.size() == 0 || religionCodeList == null) ){
				message = "Religion Name already exists.";
			}
			else if((religionCodeList.size() != 0 || religionCodeList != null) && (religionNameList.size() != 0 || religionNameList != null)){
				message = "Religion Code and Religion Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showReligionJsp";
		try{
			map = generalMasterHandlerService.showReligionJsp();
		}catch (Exception e) {
			//System.out.println("Exception in showReligionJsp "+e);
		}
		jsp=RELIGION_JSP;
		title="Add Religion";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editReligion(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String religionCode="";
		String religionName="";
		int religionId=0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
	
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			religionId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			religionCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			religionName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
	
		generalMap.put("id", religionId);
		generalMap.put("religionCode", religionCode);
		generalMap.put("name", religionName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingReligionNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingReligionNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editReligionToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingReligionNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showReligionJsp";
		try{
			map = generalMasterHandlerService.showReligionJsp();
		}catch (Exception e) {
			//System.out.println("Exception in showReligionJsp "+e);
		}
		jsp=RELIGION_JSP;
		title="update Religion";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
		
	}

	public ModelAndView deleteReligion(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int religionId=0;
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
			religionId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteReligion(religionId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showReligionJsp";
		try{
			map = generalMasterHandlerService.showReligionJsp();
		}catch (Exception e) {
			//System.out.println("Exception in showReligionJsp "+e);
		}
		jsp=RELIGION_JSP;
		title="Delete religion";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}		

//		----------------------------- Admission Type----------------------------------------
		@SuppressWarnings("unchecked")
		public ModelAndView showAdmissionTypeJsp(HttpServletRequest request,HttpServletResponse response)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			map = generalMasterHandlerService.showAdmissionTypeJsp();
			jsp = ADMISSION_TYPE_JSP;
			jsp+= ".jsp" ;
			title = "AdmissionType";
			map.put("contentJsp",jsp);
			map.put("title", title);

			return new ModelAndView("indexB", "map", map);		 
		}

		public ModelAndView searchAdmissionType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();  
			String admissionTypeCode  = null;
			String admissionTypeName = null;
			String searchField= null;

			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				admissionTypeCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				admissionTypeName = request.getParameter(SEARCH_NAME);
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
				admissionTypeCode=searchField;
				admissionTypeName=null;

			}else{
				admissionTypeCode=null;
				admissionTypeName=searchField;
			}

			map = generalMasterHandlerService.searchAdmissionType(admissionTypeCode, admissionTypeName);

			jsp=ADMISSION_TYPE_JSP;
			jsp += ".jsp";
			map.put("search","search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("admissionTypeCode",admissionTypeCode);
			map.put("admissionTypeName",admissionTypeName);
			return new ModelAndView("indexB", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addAdmissionType(HttpServletRequest request, HttpServletResponse response) 
		{

			Map<String,Object> map=new HashMap<String,Object>();
			MasAdmissionType masAdmissionType=new MasAdmissionType();
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
			List admissionTypeCodeList = new ArrayList();
			List admissionTypeNameList = new  ArrayList();

			if(listMap.get("duplicateGeneralCodeList") != null){
				admissionTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				admissionTypeNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;
			if((admissionTypeCodeList.size() == 0 || admissionTypeCodeList == null) && (admissionTypeNameList.size() == 0 || admissionTypeNameList == null))
			{
				masAdmissionType.setAdmissionTypeCode(code);
				masAdmissionType.setAdmissionTypeName(name);
				masAdmissionType.setStatus("y");
				masAdmissionType.setLastChgBy(changedBy);
				masAdmissionType.setLastChgDate(currentDate);
				masAdmissionType.setLastChgTime(currentTime);
				successfullyAdded = generalMasterHandlerService.addAdmissionType(masAdmissionType);  

				if(successfullyAdded)
				{
					message="Record Added Successfully !!";
				}
				else
				{
					message="Try Again !!";
				}		
			}

			else if((admissionTypeCodeList.size() != 0 || admissionTypeCodeList != null) || (admissionTypeNameList.size() != 0) || admissionTypeNameList != null)
			{
				if((admissionTypeCodeList.size() != 0 || admissionTypeCodeList != null) && (admissionTypeNameList.size() == 0 || admissionTypeNameList == null)){
					message = "Admission Type Code  already exists.";
				}
				else if((admissionTypeNameList.size() != 0 || admissionTypeNameList != null) && (admissionTypeCodeList.size() == 0 || admissionTypeCodeList == null) ){
					message = "Admission Type Name already exists.";	   }
				else if((admissionTypeCodeList.size() != 0 || admissionTypeCodeList != null) && (admissionTypeNameList.size() != 0 || admissionTypeNameList != null)){
					message = "Admission Type Code and Admission Type Name already exist.";
				}
			}

			url = "/hms/hms/generalMaster?method=showAdmissionTypeJsp";
			 try{
			   map = generalMasterHandlerService.showAdmissionTypeJsp();
			    }catch (Exception e) {
			     //System.out.println("Exception in showAdmissionTypeJsp "+e);
			    }
			    jsp=ADMISSION_TYPE_JSP;
			    title="Add Admission Type";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView editAdmissionType(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			session=request.getSession();
			String admissionTypeCode="";
			String admissionTypeName="";
			int admissionTypeId=0;
			String changedBy = "";
			Date changedDate = null;
			Date currentDate = null;
			String changedTime = "";

			
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				admissionTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				admissionTypeCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				admissionTypeName = request.getParameter(SEARCH_NAME);
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
				title = request.getParameter("title"); 		}
			
			changedDate = new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

			generalMap.put("id", admissionTypeId);
			generalMap.put("admissionTypeCode", admissionTypeCode);
			generalMap.put("name", admissionTypeName);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	generalMap.put("flag", true);
			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			List existingAdmissionTypeNameList = (List)listMap.get("duplicateMastersList");
			  boolean dataUpdated=false;
			  if(existingAdmissionTypeNameList.size() == 0)
			  {
				  dataUpdated=generalMasterHandlerService.editAdmissionTypeToDatabase(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(existingAdmissionTypeNameList.size() > 0){
				   message = "Name already exists.";
				  }
			url = "/hms/hms/generalMaster?method=showAdmissionTypeJsp";
			try{
				   map = generalMasterHandlerService.showAdmissionTypeJsp();
				    }catch (Exception e) {
				     //System.out.println("Exception in showAdmissionTypeJsp "+e);
				    }
				    jsp=ADMISSION_TYPE_JSP;
				    title="Update Admission Type";
				    jsp += ".jsp";			    
				    map.put("contentJsp", jsp);
				    map.put("title", title);
				    map.put("message", message);
				    return new ModelAndView("indexB", "map", map);
		}
		
		public ModelAndView deleteAdmissionType(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int admissionTypeId=0;
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
				admissionTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=generalMasterHandlerService.deleteAdmissionType(admissionTypeId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}
			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/generalMaster?method=showAdmissionTypeJsp";
			try{
				   map = generalMasterHandlerService.showAdmissionTypeJsp();
				    }catch (Exception e) {
				     //System.out.println("Exception in showAdmissionTypeJsp "+e);
				    }
				    jsp=ADMISSION_TYPE_JSP;
				    title="Delete Admission Type";
				    jsp += ".jsp";			    
				    map.put("contentJsp", jsp);
				    map.put("title", title);
				    map.put("message", message);
				    return new ModelAndView("indexB", "map", map);
			}
		
//		----------------------------- Administrative Sex----------------------------------------
		@SuppressWarnings("unchecked")
		public ModelAndView showAdministrativeSexJsp(HttpServletRequest request,HttpServletResponse response)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			map = generalMasterHandlerService.showAdministrativeSexJsp();
			jsp = ADMINISTRATIVE_SEX_JSP;
			jsp+= ".jsp" ;
			title = "AdministrativeSex";
			map.put("contentJsp",jsp);
			map.put("title", title);

			return new ModelAndView("indexB", "map", map);		 
		}

		public ModelAndView searchAdministrativeSex(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();  
			String administrativeSexCode  = null;
			String administrativeSexName = null;
			String searchField= null;

			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				administrativeSexCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				administrativeSexName = request.getParameter(SEARCH_NAME);
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
				administrativeSexCode=searchField;
				administrativeSexName=null;

			}else{
				administrativeSexCode=null;
				administrativeSexName=searchField;
			}

			map = generalMasterHandlerService.searchAdministrativeSex(administrativeSexCode, administrativeSexName);

			jsp=ADMINISTRATIVE_SEX_JSP;
			jsp += ".jsp";
			map.put("search","search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("administrativeSexCode",administrativeSexCode);
			map.put("administrativeSexName",administrativeSexName);
			return new ModelAndView("indexB", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addAdministrativeSex(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			MasAdministrativeSex masAdministrativeSex=new MasAdministrativeSex();
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
			List administrativeSexCodeList = new ArrayList();
			List administrativeSexNameList = new  ArrayList();

			if(listMap.get("duplicateGeneralCodeList") != null){
				administrativeSexCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				administrativeSexNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;
			if((administrativeSexCodeList.size() == 0 || administrativeSexCodeList == null) && (administrativeSexNameList.size() == 0 || administrativeSexNameList == null))
			{
				masAdministrativeSex.setAdministrativeSexCode(code);
				masAdministrativeSex.setAdministrativeSexName(name);
				masAdministrativeSex.setStatus("y");
				masAdministrativeSex.setLastChgBy(changedBy);
				masAdministrativeSex.setLastChgDate(currentDate);
				masAdministrativeSex.setLastChgTime(currentTime);
				successfullyAdded = generalMasterHandlerService.addAdministrativeSex(masAdministrativeSex);  

				if(successfullyAdded)
				{
					message="Record Added Successfully !!";
				}
				else
				{
					message="Try Again !!";
				}		
			}

			else if((administrativeSexCodeList.size() != 0 || administrativeSexCodeList != null) || (administrativeSexNameList.size() != 0) || administrativeSexNameList != null)
			{
				if((administrativeSexCodeList.size() != 0 || administrativeSexCodeList != null) && (administrativeSexNameList.size() == 0 || administrativeSexNameList == null)){
					message = "AS Code  already exists.";
				}
				else if((administrativeSexNameList.size() != 0 || administrativeSexNameList != null) && (administrativeSexCodeList.size() == 0 || administrativeSexCodeList == null) ){
					message = "AS Name already exists.";	   }
				else if((administrativeSexCodeList.size() != 0 || administrativeSexCodeList != null) && (administrativeSexNameList.size() != 0 || administrativeSexNameList != null)){
					message = "AS Code and AS Name already exist.";
				}
			}

			url = "/hms/hms/generalMaster?method=showAdministrativeSexJsp";
			 try{
			   map = generalMasterHandlerService.showAdministrativeSexJsp();
			    }catch (Exception e) {
			     //System.out.println("Exception in showAdministrativeSexJsp "+e);
			    }
			    jsp=ADMINISTRATIVE_SEX_JSP;
			    title="Add Administrative Sex";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView editAdministrativeSex(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			session=request.getSession();
			String administrativeSexCode="";
			String administrativeSexName="";
			int administrativeSexId=0;
			String changedBy = "";
			Date changedDate = null;
			Date currentDate = null;
			String changedTime = "";

			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				administrativeSexId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				administrativeSexCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				administrativeSexName = request.getParameter(SEARCH_NAME);
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
				title = request.getParameter("title"); 		}
			
			changedDate = new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

			generalMap.put("id", administrativeSexId);
			generalMap.put("administrativeSexCode", administrativeSexCode);
			generalMap.put("name", administrativeSexName);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	generalMap.put("flag", true);
			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			List existingAdministrativeSexNameList = (List)listMap.get("duplicateMastersList");
			  boolean dataUpdated=false;
			  if(existingAdministrativeSexNameList.size() == 0)
			  {
				  dataUpdated=generalMasterHandlerService.editAdministrativeSexToDatabase(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(existingAdministrativeSexNameList.size() > 0){
				   message = "Name already exists.";
				  }
			url = "/hms/hms/generalMaster?method=showAdministrativeSexJsp";
			try{
				   map = generalMasterHandlerService.showAdministrativeSexJsp();
				    }catch (Exception e) {
				     //System.out.println("Exception in showAdministrativeSexJsp "+e);
				    }
				    jsp=ADMINISTRATIVE_SEX_JSP;
				    title="Update Administrative Sex";
				    jsp += ".jsp";			    
				    map.put("contentJsp", jsp);
				    map.put("title", title);
				    map.put("message", message);
				    return new ModelAndView("indexB", "map", map);
		}
		
		public ModelAndView deleteAdministrativeSex(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int administrativeSexId=0;
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
				administrativeSexId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=generalMasterHandlerService.deleteAdministrativeSex(administrativeSexId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}
			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/generalMaster?method=showAdministrativeSexJsp";
			try{
				   map = generalMasterHandlerService.showAdministrativeSexJsp();
				    }catch (Exception e) {
				     //System.out.println("Exception in showAdministrativeSexJsp "+e);
				    }
				    jsp=ADMINISTRATIVE_SEX_JSP;
				    title="Delete Administrative Sex";
				    jsp += ".jsp";			    
				    map.put("contentJsp", jsp);
				    map.put("title", title);
				    map.put("message", message);
				    return new ModelAndView("indexB", "map", map);
			}

//		------------------------------------------Document --------------------------

		public ModelAndView searchDocument(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();		
			String documentCode  = null;
			String documentName = null;
			String searchField= null;

			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				documentCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				documentName = request.getParameter(SEARCH_NAME);
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
				documentCode=searchField;
				documentName=null;

			}else{
				documentCode=null;
				documentName=searchField;
			}
			map = generalMasterHandlerService.searchDocument(documentCode, documentName);

			jsp=DOCUMENT_JSP;

			jsp += ".jsp";
			map.put("search","search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("documentCode",documentCode);
			map.put("documentName",documentName);
			return new ModelAndView("indexB", "map", map);
		}
		@SuppressWarnings("unchecked")
		public ModelAndView showDocumentJsp(HttpServletRequest request,HttpServletResponse response)
		{

			Map map = new HashMap();
			map = generalMasterHandlerService.showDocumentJsp();
			//System.out.println("map  "+map.size());
			String jsp=DOCUMENT_JSP;
			jsp += ".jsp";
			title = "Document";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB","map",map);
		}
		@SuppressWarnings("unchecked")
		public ModelAndView addDocument(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			MasDocument masDocument=new MasDocument();

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

			List documentCodeList = new ArrayList();
			List documentNameList = new  ArrayList();

			if(listMap.get("duplicateGeneralCodeList") != null){
				documentCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				documentNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if((documentCodeList.size() == 0 || documentCodeList == null) && (documentNameList.size() == 0 || documentNameList == null))
			{
				masDocument.setDocumentCode(code);
				masDocument.setDocumentName(name);
				masDocument.setStatus("y");
				masDocument.setLastChgBy(changedBy);
				masDocument.setLastChgDate(currentDate);
				masDocument.setLastChgTime(currentTime);
				successfullyAdded = generalMasterHandlerService.addDocument(masDocument);		

				if(successfullyAdded){
					message="Record Added Successfully !!";
				}
				else{
					message="Try Again !!";
				}
			}

			else if((documentCodeList.size() != 0 || documentCodeList != null) || (documentNameList.size() != 0) || documentNameList != null)
			{
				if((documentCodeList.size() != 0 || documentCodeList != null) && (documentNameList.size() == 0 || documentNameList == null)){

					message = "Document Code  already exists.";
				}
				else if((documentNameList.size() != 0 || documentNameList != null) && (documentCodeList.size() == 0 || documentCodeList == null) ){

					message = "Document Name already exists.";
				}
				else if((documentCodeList.size() != 0 || documentCodeList != null) && (documentNameList.size() != 0 || documentNameList != null)){

					message = "Document Code and Document Name already exist.";
				}
			}
			
			try{
				map = generalMasterHandlerService.showDocumentJsp();
				
			}catch (Exception e) {
				//System.out.println("Exception in showDocumentJsp "+e);
			}
			jsp=DOCUMENT_JSP;
			title="Add Document";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView editDocument(HttpServletRequest request, HttpServletResponse response) 
		{

			Map<String, Object>	map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			session=request.getSession();
			String documentCode="";
			String documentName="";
			int documentId=0;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;


			
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				documentId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				documentCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				documentName = request.getParameter(SEARCH_NAME);
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

			generalMap.put("id", documentId);
			generalMap.put("documentCode", documentCode);
			generalMap.put("name", documentName);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	generalMap.put("flag", true);
			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			List existingDocumentNameList = (List)listMap.get("duplicateMastersList");
			  boolean dataUpdated=false;
			  if(existingDocumentNameList.size() == 0)
			  {
				  dataUpdated=generalMasterHandlerService.editDocumentToDatabase(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(existingDocumentNameList.size() > 0){
				   message = "Name already exists.";
				  }
			url = "/hms/hms/generalMaster?method=showDocumentJsp";
			
			try{
				map = generalMasterHandlerService.showDocumentJsp();
				
			}catch (Exception e) {
				//System.out.println("Exception in showDocumentJsp "+e);
			}
			jsp=DOCUMENT_JSP;
			title="update Document";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);

		}

		public ModelAndView deleteDocument(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int documentId=0;
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
				documentId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=generalMasterHandlerService.deleteDocument(documentId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}

			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/generalMaster?method=showDocumentJsp";
			
			try{
				map = generalMasterHandlerService.showDocumentJsp();
				
			}catch (Exception e) {
				//System.out.println("Exception in showDocumentJsp "+e);
			}
			jsp=DOCUMENT_JSP;
			title="delete Document";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

//		------------------------------------------Occupation --------------------------

		public ModelAndView searchOccupation(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();		
			String occupationCode  = null;
			String occupationName = null;
			String searchField= null;

			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				occupationCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				occupationName = request.getParameter(SEARCH_NAME);
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
				occupationCode=searchField;
				occupationName=null;
			}else{
				occupationCode=null;
				occupationName=searchField;
			}
			map = generalMasterHandlerService.searchOccupation(occupationCode, occupationName);

			jsp=OCCUPATION_JSP;

			jsp += ".jsp";
			map.put("search","search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("occupationCode",occupationCode);
			map.put("occupationName",occupationName);
			return new ModelAndView("indexB", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView showOccupationJsp(HttpServletRequest request,HttpServletResponse response)
		{
			Map map = new HashMap();
			map = generalMasterHandlerService.showOccupationJsp();
			String jsp=OCCUPATION_JSP;
			jsp += ".jsp";
			title = "Occupation";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB","map",map);
		}


		@SuppressWarnings("unchecked")
		public ModelAndView addOccupation(HttpServletRequest request, HttpServletResponse response) 
		{

			Map<String,Object> map=new HashMap<String,Object>();
			MasOccupation masOccupation=new MasOccupation();
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
			List occupationCodeList = new ArrayList();
			List occupationNameList = new  ArrayList();

			if(listMap.get("duplicateGeneralCodeList") != null){
				occupationCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				occupationNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if((occupationCodeList.size() == 0 || occupationCodeList == null) && (occupationNameList.size() == 0 || occupationNameList == null))
			{
				masOccupation.setOccupationCode(code);
				masOccupation.setOccupationName(name);
				masOccupation.setStatus("y");
				masOccupation.setLastChgBy(changedBy);
				masOccupation.setLastChgDate(currentDate);
				masOccupation.setLastChgTime(currentTime);
				successfullyAdded = generalMasterHandlerService.addOccupation(masOccupation);		

				if(successfullyAdded){
					message="Record Added Successfully !!";
				}
				else{
					message="Try Again !!";
				}
			}
			else if((occupationCodeList.size() != 0 || occupationCodeList != null) || (occupationNameList.size() != 0) || occupationNameList != null)
			{
				if((occupationCodeList.size() != 0 || occupationCodeList != null) && (occupationNameList.size() == 0 || occupationNameList == null)){
					message = "Occupation Code  already exists.";
				}
				else if((occupationNameList.size() != 0 || occupationNameList != null) && (occupationCodeList.size() == 0 || occupationCodeList == null) ){
					message = "Occupation Name already exists.";
				}
				else if((occupationCodeList.size() != 0 || occupationCodeList != null) && (occupationNameList.size() != 0 || occupationNameList != null)){
					message = "Occupation Code and Occupation Name already exist.";
				}
			}
			
			try{
				map = generalMasterHandlerService.showOccupationJsp();
				
			}catch (Exception e) {
				//System.out.println("Exception in showOccupationJsp "+e);
			}
			jsp=OCCUPATION_JSP;
			title="Add Occupation";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView editOccupation(HttpServletRequest request, HttpServletResponse response) 
		{

			Map<String, Object>	map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			session=request.getSession();
			String occupationCode="";
			String occupationName="";
			int occupationId=0;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;
			
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				occupationId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				occupationCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				occupationName = request.getParameter(SEARCH_NAME);
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

			generalMap.put("id", occupationId);
			generalMap.put("occupationCode", occupationCode);
			generalMap.put("name", occupationName);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	generalMap.put("flag", true);
			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			List existingOccupationNameList = (List)listMap.get("duplicateMastersList");
			  boolean dataUpdated=false;
			  if(existingOccupationNameList.size() == 0)
			  {
				  dataUpdated=generalMasterHandlerService.editOccupationToDatabase(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(existingOccupationNameList.size() > 0){
				   message = "Name already exists.";
				  }
			url = "/hms/hms/generalMaster?method=showOccupationJsp";
			
			try{
				map = generalMasterHandlerService.showOccupationJsp();
				
			}catch (Exception e) {
				//System.out.println("Exception in showOccupationJsp "+e);
			}
			jsp=OCCUPATION_JSP;
			title="update Occupation";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);

		}

		public ModelAndView deleteOccupation(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int occupationId=0;
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
				occupationId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=generalMasterHandlerService.deleteOccupation(occupationId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}

			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/generalMaster?method=showOccupationJsp";
			
			try{
				map = generalMasterHandlerService.showOccupationJsp();
				
			}catch (Exception e) {
				//System.out.println("Exception in showOccupationJsp "+e);
			}
			jsp=OCCUPATION_JSP;
			title="delete Occupation";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		
	// ---------------------------------- Caste---------------------------------------

	public ModelAndView searchCaste(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String casteCode  = null;
		String casteName = null;
		String searchField= null;
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			casteCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			casteName = request.getParameter(SEARCH_NAME);
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
			casteCode=searchField;
			casteName=null;

		}else{
			casteCode=null;
			casteName=searchField;
		}
		map = generalMasterHandlerService.searchCaste(casteCode, casteName);
		jsp=CASTE_JSP;
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("casteCode",casteCode);
		map.put("casteName",casteName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showCasteJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = generalMasterHandlerService.showCasteJsp();
		@SuppressWarnings("unused")
		ArrayList  searchCasteList = (ArrayList)map.get("searchCasteList");
		jsp = CASTE_JSP;
		jsp += ".jsp";
		title = "Caste";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCaste(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasCaste masCaste=new MasCaste();

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
		List casteCodeList = new ArrayList();
		List casteNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			casteCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			casteNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((casteCodeList.size() == 0 || casteCodeList == null) && (casteNameList.size() == 0 || casteNameList == null))
		{
			masCaste.setCasteCode(code);
			masCaste.setCasteName(name);
			masCaste.setStatus("y");
			masCaste.setLastChgBy(changedBy);
			masCaste.setLastChgDate(currentDate);
			masCaste.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addCaste(masCaste);		
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}

		else if((casteCodeList.size() != 0 || casteCodeList != null) || (casteNameList.size() != 0) || casteNameList != null){

			if((casteCodeList.size() != 0 || casteCodeList != null) && (casteNameList.size() == 0 || casteNameList == null)){
				message = "Caste Code  already exists.";
			}
			else if((casteNameList.size() != 0 || casteNameList != null) && (casteCodeList.size() == 0 || casteCodeList == null) ){
				message = "Caste Name already exists.";
			}
			else if((casteCodeList.size() != 0 || casteCodeList != null) && (casteNameList.size() != 0 || casteNameList != null)){
				message = "Caste Code and Caste Name already exist.";
			}
		}

		url = "/hms/hms/generalMaster?method=showCasteJsp";
		
		try{
			map = generalMasterHandlerService.showCasteJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in showCasteJsp "+e);
		}
		jsp=CASTE_JSP;
		title="Add Caste";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editCaste(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		String casteCode="";
		String casteName="";
		int casteId=0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";


		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			casteId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			casteCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			casteName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", casteId);
		generalMap.put("casteCode", casteCode);
		generalMap.put("name", casteName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingCasteNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingCasteNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editCasteToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingCasteNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showCasteJsp";
		
		try{
			map = generalMasterHandlerService.showCasteJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in showCasteJsp "+e);
		}
		jsp=CASTE_JSP;
		title="update Caste";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteCaste(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int casteId=0;
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
			casteId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteCaste(casteId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCasteJsp";
		try{
			map = generalMasterHandlerService.showCasteJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in showCasteJsp "+e);
		}
		jsp=CASTE_JSP;
		title="delete Caste";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}



//	---------------------------------- -Unit Of Measurement-------------------------------------------------------


	public ModelAndView searchUnitOfMeasurement(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String unitOfMeasurementCode  = null;

		String unitOfMeasurementName = null;

		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			unitOfMeasurementCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			unitOfMeasurementName = request.getParameter(SEARCH_NAME);
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
			unitOfMeasurementCode=searchField;
			unitOfMeasurementName=null;

		}else{
			unitOfMeasurementCode=null;
			unitOfMeasurementName=searchField;
		}

		map = generalMasterHandlerService.searchUnitOfMeasurement(unitOfMeasurementCode, unitOfMeasurementName);

		jsp=UNIT_OF_MEASUREMENT_JSP;

		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("unitOfMeasurementCode",unitOfMeasurementCode);
		map.put("unitOfMeasurementName",unitOfMeasurementName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showUnitOfMeasurementJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = generalMasterHandlerService.showUnitOfMeasurementJsp();
		jsp = UNIT_OF_MEASUREMENT_JSP;
		jsp += ".jsp";
		title = "Unit Of Measurement";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addUnitOfMeasurement(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasUnitOfMeasurement masUnitOfMeasurement=new MasUnitOfMeasurement();

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

		List unitOfMeasurementCodeList = new ArrayList();
		List unitOfMeasurementNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			unitOfMeasurementCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			unitOfMeasurementNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((unitOfMeasurementCodeList.size() == 0 || unitOfMeasurementCodeList == null) && (unitOfMeasurementNameList.size() == 0 || unitOfMeasurementNameList == null))
		{
			masUnitOfMeasurement.setUnitOfMeasurementCode(code);
			masUnitOfMeasurement.setUnitOfMeasurementName(name);
			masUnitOfMeasurement.setStatus("y");
			masUnitOfMeasurement.setLastChgBy(changedBy);
			masUnitOfMeasurement.setLastChgDate(currentDate);
			masUnitOfMeasurement.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addUnitOfMeasurement(masUnitOfMeasurement);		

			String message = null;
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";

			}
			else
			{
				message="Try Again  !!";
			}
		}

		else if((unitOfMeasurementCodeList.size() != 0 || unitOfMeasurementCodeList != null) || (unitOfMeasurementNameList.size() != 0) || unitOfMeasurementNameList != null){

			if((unitOfMeasurementCodeList.size() != 0 || unitOfMeasurementCodeList != null) && (unitOfMeasurementNameList.size() == 0 || unitOfMeasurementNameList == null)){

				message = "UOM Code  already exists.";
			}
			else if((unitOfMeasurementNameList.size() != 0 || unitOfMeasurementNameList != null) && (unitOfMeasurementCodeList.size() == 0 || unitOfMeasurementCodeList == null) ){

				message = "UOM Name already exists.";
			}
			else if((unitOfMeasurementCodeList.size() != 0 || unitOfMeasurementCodeList != null) && (unitOfMeasurementNameList.size() != 0 || unitOfMeasurementNameList != null)){

				message = "UOM Code and UOM already exist.";
			}

		}

		url = "/hms/hms/generalMaster?method=showUnitOfMeasurementJsp";
		
		try{
			map = generalMasterHandlerService.showUnitOfMeasurementJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in showUnitOfMeasurementJsp "+e);
		}
		jsp=UNIT_OF_MEASUREMENT_JSP;
		title="Add Unit Of Measurement";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editUnitOfMeasurement(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String unitOfMeasurementCode="";
		String unitOfMeasurementName="";
		int unitOfMeasurementId=0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			unitOfMeasurementId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			unitOfMeasurementCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			unitOfMeasurementName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", unitOfMeasurementId);
		generalMap.put("unitOfMeasurementCode", unitOfMeasurementCode);
		generalMap.put("name", unitOfMeasurementName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	 generalMap.put("flag", true);
		  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		  List existingUnitOfMeasurementNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingUnitOfMeasurementNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editUnitOfMeasurementToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingUnitOfMeasurementNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showUnitOfMeasurementJsp";
		
		try{
			map = generalMasterHandlerService.showUnitOfMeasurementJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in showUnitOfMeasurementJsp "+e);
		}
		jsp=UNIT_OF_MEASUREMENT_JSP;
		title="Update Of Measurement";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteUnitOfMeasurement(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int unitOfMeasurementId=0;
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
			unitOfMeasurementId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteUnitOfMeasurement(unitOfMeasurementId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showUnitOfMeasurementJsp";
		
		try{
			map = generalMasterHandlerService.showUnitOfMeasurementJsp();
			
		}catch (Exception e) {
			e.printStackTrace();;
		}
		jsp=UNIT_OF_MEASUREMENT_JSP;
		title="Delete Unit Of Measurement";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	//---------------------------------------  District----------------------------------------------

	 @SuppressWarnings("unchecked")
	 public ModelAndView showDistrictJsp(HttpServletRequest request, HttpServletResponse response) {
	  Map<String, Object> map = new HashMap<String, Object>();
	  map=(Map)generalMasterHandlerService.showDistrict();
	  String jsp=DISTRICT_JSP;
	  jsp += ".jsp";
	  title = "District";  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  return new ModelAndView("indexB","map",map);

	 }

	 @SuppressWarnings("unchecked")
	 public ModelAndView addDistrict(HttpServletRequest request, HttpServletResponse response) 
	 {
	  Map<String,Object> map = new HashMap<String,Object>();
	  MasDistrict masDistrict = new MasDistrict();
	  int stateId=0;
	  String changedBy = "";
	  Map<String, Object> listMap=new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();
	  Date currentDate = new Date();

	  try{
	   if (request.getParameter(CODE) != null) {
	    code = request.getParameter(CODE);
	   }
	   if (request.getParameter(SEARCH_NAME) != null) {
	    name = request.getParameter(SEARCH_NAME);
	   }

	   if (!request.getParameter(STATE_ID).equals("0")) {
		   stateId = Integer.parseInt(request.getParameter(STATE_ID));
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
	   
	  }catch (Exception e) {
		  e.printStackTrace();
	  }

	  try{

	   listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
	  }catch (Exception e) {
		  e.printStackTrace();
	  }

	  List districtCodeList = new ArrayList();
	  List districtNameList = new  ArrayList();

	  if(listMap.get("duplicateGeneralCodeList") != null){
	   districtCodeList = (List)listMap.get("duplicateGeneralCodeList");

	  }
	  if(listMap.get("duplicateGeneralNameList") != null){
	   districtNameList = (List)listMap.get("duplicateGeneralNameList");

	  }
	  boolean successfullyAdded = false;

	  if((districtCodeList.size() == 0 || districtCodeList == null) && (districtNameList.size() == 0 || districtNameList == null)){
	   masDistrict.setDistrictCode(code);
	   masDistrict.setDistrictName(name);
	   if(stateId != 0){
	   MasState masState = new MasState();
	   masState.setId(stateId);
	   masDistrict.setState(masState);
	   }
	   masDistrict.setStatus("y");
	   masDistrict.setLastChgBy(changedBy);
	   masDistrict.setLastChgDate(currentDate);
	   masDistrict.setLastChgTime(currentTime);
	   successfullyAdded = generalMasterHandlerService.addDistrict(masDistrict);  

	   if(successfullyAdded){
	    message="Record Added Successfully";
	   }else{
	    message="Try Again !";
	   }

	  }else if((districtCodeList.size() != 0 || districtCodeList != null) || (districtNameList.size() != 0) || districtNameList != null){
	   if((districtCodeList.size() != 0 || districtCodeList != null) && (districtNameList.size() == 0 || districtNameList == null)){
	    message = "District Code already exists.";
	   }
	   else if((districtNameList.size() != 0 || districtNameList != null) && (districtCodeList.size() == 0 || districtCodeList == null) ){
	    message = "District Name already exists.";
	   }
	   else if((districtCodeList.size() != 0 || districtCodeList != null) && (districtNameList.size() != 0 || districtNameList != null)){
	    message = "District Code and District exist.";
	   }
	  }

	  
	  try{
	   map = generalMasterHandlerService.showDistrict();
	   
	  }catch (Exception e) {
		  e.printStackTrace();
	  }
	  jsp=DISTRICT_JSP;
	  title="Add District";
	  jsp += ".jsp";

	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("url", url);
	  map.put("message", message);
	  return new ModelAndView("indexB", "map", map);

	 }

	 public ModelAndView editDistrict(HttpServletRequest request, HttpServletResponse response) 
	 {
	  Map<String, Object> map = new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();

	  session=request.getSession();
	  String districtCode="";
	  int stateId=0;
	  int districtId=0;
	  String changedBy = "";
	  Date changedDate = null;
	  @SuppressWarnings("unused")
	  String changedTime = "";

	  try{
		  if(request.getParameter(STATE_ID) != null && !(request.getParameter(STATE_ID).equals(""))){
				stateId =Integer.parseInt(request.getParameter(STATE_ID));
			}
	   if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
	    districtId =Integer.parseInt( request.getParameter(COMMON_ID));
	   }
	   if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
	    districtCode = request.getParameter(CODE);
	   }
	   if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
	    name = request.getParameter(SEARCH_NAME);
	   }
	   if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
	    changedBy = request.getParameter(CHANGED_BY);
	   }
	   if(request.getParameter("title") != null){
	    title = request.getParameter("title"); 
	   }
	  }catch (Exception e) {
	   e.printStackTrace();
	  }
	  changedDate = new Date();
	  try{
	   changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

	   generalMap.put("id", districtId);
	   generalMap.put("districtCode", districtCode);
	   generalMap.put("name", name);
	   generalMap.put("stateId",stateId);
	   generalMap.put("changedBy", changedBy);
	   generalMap.put("currentDate", changedDate);
	   generalMap.put("currentTime", changedTime);
	  }catch (Exception e) {
		  e.printStackTrace();
	  }

	  boolean dataUpdated=false;
	  try{
	   dataUpdated=generalMasterHandlerService.editDistrict(generalMap);
	  }catch (Exception e) {
		  e.printStackTrace();
	  }
	  if(dataUpdated==true){
	   message="Data updated Successfully !!";

	  }
	  else{
	   message="Data Cant be updated !!";
	  }

	  try{
	   map = generalMasterHandlerService.showDistrict();
	   
	  }catch (Exception e) {
		  e.printStackTrace();}
	  	jsp=DISTRICT_JSP;
		title="Edit District";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	 }


	 public ModelAndView searchDistrict(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException{
	  Map<String, Object> map= new HashMap<String, Object>();  
	  String searchField  = null;
	  String districtCode= null;
	  String districtName= null; 
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
	   districtCode=searchField;
	   districtName=null;

	  }else{
	   districtCode=null;
	   districtName=searchField;
	  }
	  map = generalMasterHandlerService.searchDistrict(districtCode, districtName);

	  jsp=DISTRICT_JSP;
	  jsp += ".jsp";
	  map.put("search","search");
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  map.put("districtCode",districtCode);
	  map.put("districtName",districtName);
	  return new ModelAndView("indexB", "map", map);
	 }

	 public ModelAndView deleteDistrict(HttpServletRequest request, HttpServletResponse response) {
	  Map<String, Object> map = new HashMap<String, Object>();
	  int districtId=0;
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
	   districtId =Integer.parseInt( request.getParameter(COMMON_ID));
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
	  dataDeleted=generalMasterHandlerService.deleteDistrict(districtId,generalMap);
	  if (dataDeleted==true)
	  {
	   message="Record is InActivated successfully !!";
	  }

	  else{
	   message="Record is Activated successfully !!";
	  }
	  url = "/hms/hms/generalMaster?method=showDistrictJsp";
	  
	  try{
	   map = generalMasterHandlerService.showDistrict();
	   
	  }catch (Exception e) {
	   //System.out.println("Exception in showPatientTypeJsp "+e);
	  }
	  jsp=DISTRICT_JSP;
	  title="delete District";
	  jsp += ".jsp";

	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("url", url);
	  map.put("message", message);
	  return new ModelAndView("indexB", "map", map);

	 }


//-------------------------------- Block ------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showBlockJsp(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map=(Map)generalMasterHandlerService.showBlock();
		String jsp=BLOCK;
		jsp += ".jsp";
		title = "Block";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addBlock(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map = new HashMap<String,Object>();
		MasBlock masBlock = new MasBlock();
		int majorCategoryId=0;
		String changedBy = "";
		Map<String, Object> listMap=new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		try{
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}

			if (request.getParameter(DISTRICT_ID) != null) {
				majorCategoryId = Integer.valueOf(request.getParameter(DISTRICT_ID));
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
		}catch (Exception e) {
			//System.out.println("Exception in ret"+e);
		}

		try{
			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		}catch (Exception e) {
			//System.out.println("Exception  MID "+e);
		}
		List blockCodeList = new ArrayList();
		List blockNameList = new  ArrayList();
		if(listMap.get("duplicateGeneralCodeList") != null){
			blockCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			blockNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((blockCodeList.size() == 0 || blockCodeList == null) && (blockNameList.size() == 0 || blockNameList == null)){
			masBlock.setBlockCode(code);
			masBlock.setBlockName(name);
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(majorCategoryId);
			masBlock.setDistrict(masDistrict);
			masBlock.setStatus("y");
			masBlock.setLastChgBy(changedBy);
			masBlock.setLastChgDate(currentDate);
			masBlock.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addBlock(masBlock);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}else{
				message="Try Again !!";
			}

		}else if((blockCodeList.size() != 0 || blockCodeList != null) || (blockNameList.size() != 0) || blockNameList != null){
			if((blockCodeList.size() != 0 || blockCodeList != null) && (blockNameList.size() == 0 || blockNameList == null)){
				message = "Block Code already exists.";
			}
			else if((blockNameList.size() != 0 || blockNameList != null) && (blockCodeList.size() == 0 || blockCodeList == null) ){
				message = "Block Name already exists.";
			}
			else if((blockCodeList.size() != 0 || blockCodeList != null) && (blockNameList.size() != 0 || blockNameList != null)){
				message = "Block Code and Block exist.";
			}
		}
		try{
			map = generalMasterHandlerService.showBlock();
			
		}catch (Exception e) {
			//System.out.println("Exception in show Block "+e);
		}
		jsp=BLOCK_JSP;
		title="Add Block";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editBlock(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String blockCode="";
		String blockName="";
		int districtId=0;
		int blockId=0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		try{
			if(request.getParameter(DISTRICT_ID) != null && !(request.getParameter(DISTRICT_ID).equals(""))){
				districtId =Integer.parseInt( request.getParameter(DISTRICT_ID));
			}
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				blockId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				blockCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				blockName = request.getParameter(SEARCH_NAME);
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

		}catch (Exception e) {
			//System.out.println("e1 "+e);
		}

		changedDate = new Date();
		try{
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

			generalMap.put("id", blockId);
			generalMap.put("blockCode", blockCode);
			generalMap.put("name", blockName);
			generalMap.put("districtId",districtId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	 generalMap.put("flag", true);
			 listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			  List existingBlockNameList = (List)listMap.get("duplicateMastersList");
			  boolean dataUpdated=false;
			  if(existingBlockNameList.size() == 0)
			  {
				  dataUpdated=generalMasterHandlerService.editBlock(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(existingBlockNameList.size() > 0){
				   message = "Name already exists.";
			}
		}catch (Exception e) {
			//System.out.println("e2 "+e);
		}
		try{
			map = generalMasterHandlerService.showBlock();
			
		}catch (Exception e) {
			//System.out.println("Exception in show Block "+e);
		}
		jsp=BLOCK_JSP;
		title="Edit Block";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView searchBlock(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException{
		Map<String, Object> map= new HashMap<String, Object>();		
		String searchField  = null;
		String blockCode= null;
		String blockName= null;	
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
			blockCode=searchField;
			blockName=null;

		}else{
			blockCode=null;
			blockName=searchField;
		}
		map = generalMasterHandlerService.searchBlock(blockCode, blockName);

		jsp=BLOCK;

		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("blockCode",blockCode);
		map.put("blockName",blockName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteBlock(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int blockId=0;
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
			blockId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteBlock(blockId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showBlockJsp";
		try{
			map = generalMasterHandlerService.showBlock();
			
		}catch (Exception e) {
			//System.out.println("Exception in show Block "+e);
		}
		jsp=BLOCK_JSP;
		title="delete Block";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	 @SuppressWarnings("unchecked")
	 public ModelAndView showPostCodeJsp(HttpServletRequest request, HttpServletResponse response) {

	  //System.out.println("this is Post Code");
	  Map<String, Object> map = new HashMap<String, Object>();

	  map=(Map)generalMasterHandlerService.showPostCodeJsp();
	  //System.out.println("map  "+map.size());
	  String jsp=POSTCODE_JSP;
	  jsp += ".jsp";
	  title = "Post Code";  
	  map.put("contentJsp", jsp);
	  map.put("title", title);

	  return new ModelAndView("indexB","map",map);

	 }

	 @SuppressWarnings("unchecked")
	 public ModelAndView addPostCode(HttpServletRequest request, HttpServletResponse response) 
	 {
	  Map<String,Object> map = new HashMap<String,Object>();
	  MasPostCode masPostCode = new MasPostCode();

	  int majorCategoryId=0;
	  String changedBy = "";
	  Map<String, Object> listMap=new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();
	  Date currentDate = new Date();

	  try{
	   if (request.getParameter(CODE) != null) {
	    code = request.getParameter(CODE);
	       }
	   if (request.getParameter(SEARCH_NAME) != null) {
	    name = request.getParameter(SEARCH_NAME);
	   }
	   if (request.getParameter(BLOCK_ID) != null) {
	    majorCategoryId = Integer.valueOf(request.getParameter(BLOCK_ID));
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
	   
	  }catch (Exception e) {
	   //System.out.println("Exception in ret"+e);
	  }
	  try{
	   listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
	  }catch (Exception e) {
	   //System.out.println("Exception  MID "+e);
	  }

	  List postCodeCodeList = new ArrayList();
	  List postCodeNameList = new  ArrayList();

	  if(listMap.get("duplicateGeneralCodeList") != null){
	   postCodeCodeList = (List)listMap.get("duplicateGeneralCodeList");

	  }
	  if(listMap.get("duplicateGeneralNameList") != null){
	   postCodeNameList = (List)listMap.get("duplicateGeneralNameList");

	  }
	  boolean successfullyAdded = false;

	  if((postCodeCodeList.size() == 0 || postCodeCodeList == null) && (postCodeNameList.size() == 0 || postCodeNameList == null)){
	   masPostCode.setPostCode(code);
	   masPostCode.setPostCodeName(name);
	   MasBlock masBlock = new MasBlock();
	   masBlock.setId(majorCategoryId);
	   masPostCode.setBlock(masBlock);
	   masPostCode.setStatus("y");
	   masPostCode.setLastChgBy(changedBy);
	   masPostCode.setLastChgDate(currentDate);
	   masPostCode.setLastChgTime(currentTime);
	   successfullyAdded = generalMasterHandlerService.addPostCode(masPostCode);  

	   if(successfullyAdded){
	    message="Record Added Successfully !!";
	   }else{
	    message="Try Again !!";
	   }

	  }else if((postCodeCodeList.size() != 0 || postCodeCodeList != null) || (postCodeNameList.size() != 0) || postCodeNameList != null){
	   if((postCodeCodeList.size() != 0 || postCodeCodeList != null) && (postCodeNameList.size() == 0 || postCodeNameList == null)){
	    message = "PostCode  already exists.";
	   }
	   else if((postCodeNameList.size() != 0 || postCodeNameList != null) && (postCodeCodeList.size() == 0 || postCodeCodeList == null) ){
	    message = "PostCode Name already exists.";
	   }
	   else if((postCodeCodeList.size() != 0 || postCodeCodeList != null) && (postCodeNameList.size() != 0 || postCodeNameList != null)){
	    message = "PostCode and PostCode Name exist.";
	   }
	  }

	  
	  try{
	   map = generalMasterHandlerService.showPostCodeJsp();
	   
	  }catch (Exception e) {
	   //System.out.println("Exception in  showPostCodeJsp "+e);
	  }
	  jsp=POSTCODE_JSP;
	  title="Add Post Code";
	  jsp += ".jsp";

	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("url", url);
	  map.put("message", message);
	  return new ModelAndView("indexB", "map", map);

	 }

	 public ModelAndView editPostCode(HttpServletRequest request, HttpServletResponse response) 
	 {
	  Map<String, Object> map = new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();

	  session=request.getSession();
	  String postCodeCode="";
	  int blockId=0;
	  int postCodeId=0;
	  String changedBy = "";

	  Date changedDate = null;
	  @SuppressWarnings("unused")
	  String changedTime = "";


	  try{
	   if(request.getParameter(BLOCK_ID) != null && !(request.getParameter(BLOCK_ID).equals(""))){
	    blockId =Integer.parseInt( request.getParameter(BLOCK_ID));
	   }
	   if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
	    postCodeId =Integer.parseInt( request.getParameter(COMMON_ID));
	   }
	   if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
	    postCodeCode = request.getParameter(CODE);
	   }
	   if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
	    name = request.getParameter(SEARCH_NAME);
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

	  }catch (Exception e) {
	   //System.out.println("e1 "+e);
	  }

	  changedDate = new Date();
	  try{
	   changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

	   generalMap.put("id", postCodeId);
	   generalMap.put("postCode", postCodeCode);
	   generalMap.put("name", name);
	   generalMap.put("blockId",blockId);
	   generalMap.put("changedBy", changedBy);
	   generalMap.put("currentDate", changedDate);
	   generalMap.put("currentTime", currentTime);
	  }catch (Exception e) {
	   //System.out.println("e2 "+e);
	  }

	  boolean dataUpdated=false;
	  try{
	   dataUpdated=generalMasterHandlerService.editPostCode(generalMap);
	  }catch (Exception e) {
	   //System.out.println("this  "+e);
	  }
	  if(dataUpdated==true){
	   message="Data updated Successfully !!";

	  }
	  else{
	   message="Data Cant be updated !!";
	  }
	  try{
	   map = generalMasterHandlerService.showPostCodeJsp();
	   
	  }catch (Exception e) {
	   //System.out.println("Exception in  showPostCodeJsp "+e);
	  }
	  jsp=POSTCODE_JSP;
	  title="Edit Post Code";
	  jsp += ".jsp";

	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("url", url);
	  map.put("message", message);
	  return new ModelAndView("indexB", "map", map);

	 }


	 public ModelAndView searchPostCode(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException{
	  Map<String, Object> map= new HashMap<String, Object>();  
	  String searchField  = null;
	  String postCodeCode= null;
	  String postCodeName= null; 
	  int searchRadio=1;
	  try{
	   if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
	    searchField = request.getParameter(SEARCH_FIELD);
	   }

	   if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
	    searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;  

	   }
	  }catch (Exception e) {
	   //System.out.println("Exception---->  "+e);
	  }

	  if(searchRadio==1){
	   postCodeCode=searchField;
	   postCodeName=null;

	  }else{
	   postCodeCode=null;
	   postCodeName=searchField;
	  }
	  map = generalMasterHandlerService.searchPostCode(postCodeCode, postCodeName);

	  jsp=POSTCODE_JSP;

	  jsp += ".jsp";
	  map.put("search","search");
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  map.put("postCode",postCodeCode);
	  map.put("postCodeName",postCodeName);

	  return new ModelAndView("indexB", "map", map);
	 }

	 public ModelAndView deletePostCode(HttpServletRequest request, HttpServletResponse response) {
	  Map<String, Object> map = new HashMap<String, Object>();
	  int postCodeId=0;
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
	   postCodeId =Integer.parseInt( request.getParameter(COMMON_ID));
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
	  dataDeleted=generalMasterHandlerService.deletePostCode(postCodeId,generalMap);
	  if (dataDeleted==true)
	  {

	   message="Record is InActivated successfully !!";
	  }

	  else{
	   message="Record is Activated successfully !!";
	  }
	  url = "/hms/hms/generalMaster?method=showPostCodeJsp";
	  
	  try{
	   map = generalMasterHandlerService.showPostCodeJsp();
	   
	  }catch (Exception e) {
	   //System.out.println("Exception in  showPostCodeJsp "+e);
	  }
	  jsp=POSTCODE_JSP;
	  title="Delete Post Code";
	  jsp += ".jsp";

	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("url", url);
	  map.put("message", message);
	  return new ModelAndView("indexB", "map", map);
	 }
	//	----------------------------- State -----------------------


	@SuppressWarnings("unchecked")
	public ModelAndView showStateJsp(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map=(Map)generalMasterHandlerService.showStateJsp();
		String jsp=STATE_JSP;
		jsp += ".jsp";
		title = "State";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addState(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map = new HashMap<String,Object>();
		MasState masState = new MasState();

		int countryId=0;
		String changedBy = "";
		Map<String, Object> listMap=new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		try{
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}

			if (request.getParameter(COUNTRY_ID) != null && !(request.getParameter(COUNTRY_ID).equals("0"))){
				countryId = Integer.valueOf(request.getParameter(COUNTRY_ID));
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
			}catch (Exception e) {
			//System.out.println("Exception in ret"+e);
		}

		try{

			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		}catch (Exception e) {
			//System.out.println("Exception  MID "+e);
		}

		List stateCodeList = new ArrayList();
		List stateNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			stateCodeList = (List)listMap.get("duplicateGeneralCodeList");

		}
		if(listMap.get("duplicateGeneralNameList") != null){
			stateNameList = (List)listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if((stateCodeList.size() == 0 || stateCodeList == null) && (stateNameList.size() == 0 || stateNameList == null)){
			masState.setStateCode(code);
			masState.setStateName(name);
			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			masState.setCountry(masCountry);
			masState.setStatus("y");
			masState.setLastChgBy(changedBy);
			masState.setLastChgDate(currentDate);
			masState.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addState(masState);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}else{
				message="Try Again !!";
			}

		}else if((stateCodeList.size() != 0 || stateCodeList != null) || (stateNameList.size() != 0) || stateNameList != null){
			if((stateCodeList.size() != 0 || stateCodeList != null) && (stateNameList.size() == 0 || stateNameList == null)){
				message = "State Code already exists.";
			}
			else if((stateNameList.size() != 0 || stateNameList != null) && (stateCodeList.size() == 0 || stateCodeList == null) ){
				message = "State Name already exists.";
			}
			else if((stateCodeList.size() != 0 || stateCodeList != null) && (stateNameList.size() != 0 || stateNameList != null)){
				message = "State Code and State exist.";
			}
		}

		
		try{
			map = generalMasterHandlerService.showStateJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showSatte "+e);
		}
		jsp=STATE_JSP;
		title="Add State";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView editState(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		String stateCode="";
		String stateName="";
		int countryId=0;
		int stateId=0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		try{
			if(request.getParameter(COUNTRY_ID) != null && !(request.getParameter(COUNTRY_ID).equals("0"))){
				countryId =Integer.parseInt( request.getParameter(COUNTRY_ID));
			}
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				stateId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				stateCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				stateName = request.getParameter(SEARCH_NAME);
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
			if(request.getParameter("pojoName") != null){
				pojoName = request.getParameter("pojoName"); 
			}
			if(request.getParameter("pojoPropertyName") != null){
				pojoPropertyName = request.getParameter("pojoPropertyName"); 
			}
			if(request.getParameter("title") != null){
				title = request.getParameter("title"); 
			}

		}catch (Exception e) {
			//System.out.println("e1 "+e);
		}

		changedDate = new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

			generalMap.put("id", stateId);
			generalMap.put("stateCode", stateCode);
			generalMap.put("name", stateName);
			generalMap.put("countryId",countryId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	 generalMap.put("flag", true);
			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			  List existingStateNameList = (List)listMap.get("duplicateMastersList");
			  boolean dataUpdated=false;
			  if(existingStateNameList.size() == 0)
			  {
				  dataUpdated=generalMasterHandlerService.editState(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(existingStateNameList.size() > 0){
				   message = "Name already exists.";
				  }
		try{
			map = generalMasterHandlerService.showStateJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showSatte "+e);
		}
		jsp=STATE_JSP;
		title="Edit State";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView searchState(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException{
		Map<String, Object> map= new HashMap<String, Object>();		
		String searchField  = null;
		String stateCode= null;
		String stateName= null;	
		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(searchRadio==1){
			stateCode=searchField;
			stateName=null;

		}else{
			stateCode=null;
			stateName=searchField;
		}
		map = generalMasterHandlerService.searchState(stateCode, stateName);
		jsp = STATE_JSP;	
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("stateCode",stateCode);
		map.put("stateName",stateName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteState(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int stateId=0;
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
			stateId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteState(stateId,generalMap);
		if (dataDeleted==true)
		{

			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}

		url = "/hms/hms/generalMaster?method=showStateJsp";
		
		try{
			map = generalMasterHandlerService.showStateJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showSatte "+e);
		}
		jsp=STATE_JSP;
		title="delete State";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}
//	-------------------------currency ------------------------------------------------

	public ModelAndView searchCurrency(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String currencyCode  = null;
		String currencyName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			currencyCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			currencyName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(searchRadio==1){
			currencyCode=searchField;
			currencyName=null;

		}else{
			currencyCode=null;
			currencyName=searchField;
		}
		map = generalMasterHandlerService.searchCurrency(currencyCode, currencyName);

		jsp=CURRENCY_JSP;
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("currencyCode",currencyCode);
		map.put("currencyName",currencyName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showCurrencyJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = generalMasterHandlerService.showCurrencyJsp();
		@SuppressWarnings("unused")
		ArrayList  searchCurrencyList = (ArrayList)map.get("searchCurrencyList");
		jsp = CURRENCY_JSP;
		jsp += ".jsp";
		title = "Currency";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCurrency(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MasCurrency masCurrency=new MasCurrency();

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

		List currencyCodeList = new ArrayList();
		List currencyNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			currencyCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			currencyNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((currencyCodeList.size() == 0 || currencyCodeList == null) && (currencyNameList.size() == 0 || currencyNameList == null))
		{
			masCurrency.setCurrencyCode(code);
			masCurrency.setCurrencyName(name);
			masCurrency.setStatus("y");
			masCurrency.setLastChgBy(changedBy);
			masCurrency.setLastChgDate(currentDate);
			masCurrency.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addCurrency(masCurrency);		

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((currencyCodeList.size() != 0 || currencyCodeList != null) || (currencyNameList.size() != 0) || currencyNameList != null){

			if((currencyCodeList.size() != 0 || currencyCodeList != null) && (currencyNameList.size() == 0 || currencyNameList == null)){
				message = "Currency Code  already exists.";
			}
			else if((currencyNameList.size() != 0 || currencyNameList != null) && (currencyCodeList.size() == 0 || currencyCodeList == null) ){
				message = "Currency Name already exists.";
			}
			else if((currencyCodeList.size() != 0 || currencyCodeList != null) && (currencyNameList.size() != 0 || currencyNameList != null)){
				message = "Currency Code and Currency Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showCurrencyJsp";
		
		try{
			map = generalMasterHandlerService.showCurrencyJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showCurrencyJsp "+e);
		}
		jsp=CURRENCY_JSP;
		title="Add currency";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView editCurrency(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String currencyCode="";
		String currencyName="";
		int currencyId=0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			currencyId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			currencyCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			currencyName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", currencyId);
		generalMap.put("currencyCode", currencyCode);
		generalMap.put("name", currencyName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	 generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		  List existingCurrencyNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingCurrencyNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editCurrencyToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingCurrencyNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showCurrencyJsp";
		try{
			map = generalMasterHandlerService.showCurrencyJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showCurrencyJsp "+e);
		}
		jsp=CURRENCY_JSP;
		title="Update currency";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteCurrency(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int currencyId=0;
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
			currencyId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteCurrency(currencyId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCurrencyJsp";
		try{
			map = generalMasterHandlerService.showCurrencyJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showCurrencyJsp "+e);
		}
		jsp=CURRENCY_JSP;
		title="Delete currency";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}
	//-----------------------------------country -----------------------------


	@SuppressWarnings("unchecked")
	public ModelAndView showCountryJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = generalMasterHandlerService.showCountryJsp();
		@SuppressWarnings("unused")
		ArrayList  searchCountryList = (ArrayList)map.get("searchCountryList");
		jsp = COUNTRY_JSP;
		jsp += ".jsp";
		title = "Country";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addCountry(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MasCountry masCountry=new MasCountry();

		int currencyId=0;
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

		if (request.getParameter(CURRENCY_ID) != null) {
			currencyId = Integer.valueOf(request.getParameter(CURRENCY_ID));

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
		List countryCodeList = new ArrayList();
		List countryNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			countryCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			countryNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((countryCodeList.size() == 0 || countryCodeList == null) && (countryNameList.size() == 0 || countryNameList == null))
		
		{
			masCountry.setCountryCode(code);
			masCountry.setCountryName(name);
			MasCurrency masCurrency= new MasCurrency();
			masCurrency.setId(currencyId);
			masCountry.setCurrency(masCurrency);

			masCountry.setStatus("y");
			masCountry.setLastChgBy(changedBy);
			masCountry.setLastChgDate(currentDate);
			masCountry.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addCountry(masCountry);		

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{				message="Try Again !!";

			}
		}
		else if((countryCodeList.size() != 0 || countryCodeList != null) || (countryNameList.size() != 0) || countryNameList != null){

			if((countryCodeList.size() != 0 || countryCodeList != null) && (countryNameList.size() == 0 || countryNameList == null)){

				message = "Country Code  already exists.";
			}
			else if((countryNameList.size() != 0 || countryNameList != null) && (countryCodeList.size() == 0 || countryCodeList == null) ){

				message = "Country Name  already exists.";
			}
			else if((countryCodeList.size() != 0 || countryCodeList != null) && (countryNameList.size() != 0 || countryNameList != null)){

				message = "Country Code and Country Name already exist.";
			}		}

		url = "/hms/hms/generalMaster?method=showCountryJsp";
		
		try{
			map = generalMasterHandlerService.showCountryJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showCountryJsp "+e);
		}
		jsp=COUNTRY_JSP;
		title="Add Country";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView searchCountry(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String countryCode  = null;
		String countryName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			countryCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			countryName = request.getParameter(SEARCH_NAME);
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
			countryCode=searchField;
			countryName=null;
		}else{
			countryCode=null;
			countryName=searchField;
		}
		map = generalMasterHandlerService.searchCountry(countryCode, countryName);

		jsp=COUNTRY_JSP;

		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("countryCode",countryCode);
		map.put("countryName",countryName);
		return new ModelAndView("indexB", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView editCountry(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String countryCode="";
		String countryName="";
		int currencyId=0;
		int countryId=0;
		String changedBy = "";
		
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if(request.getParameter(CURRENCY_ID) != null && !(request.getParameter(CURRENCY_ID).equals(""))){
			currencyId =Integer.parseInt(request.getParameter(CURRENCY_ID));
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			countryId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			countryCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			countryName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", countryId);
		generalMap.put("countryCode", countryCode);
		generalMap.put("name", countryName);
		generalMap.put("currencyId",currencyId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	 generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		  List existingCountryNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingCountryNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editCountryToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingCountryNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showCountryJsp";
		
		try{
			map = generalMasterHandlerService.showCountryJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=COUNTRY_JSP;
		title="Edit Country";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteCountry(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int countryId=0;
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
			countryId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteCountry(countryId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCountryJsp";
		try{
			map = generalMasterHandlerService.showCountryJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showCountryJsp "+e);
		}
		jsp=COUNTRY_JSP;
		title="delete Country";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
//	-------------------------------------------------- Reference ---------------------------------------

	public ModelAndView searchReference(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String referenceCode  = null;
		String referenceName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			referenceCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			referenceName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(searchRadio==1){
			referenceCode=searchField;
			referenceName=null;

		}else{
			referenceCode=null;
			referenceName=searchField;
		}
		map = generalMasterHandlerService.searchReference(referenceCode, referenceName);
		jsp= REFERENCE_JSP;
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("referenceCode",referenceCode);
		map.put("referenceName",referenceName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showReferenceJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = generalMasterHandlerService.showReferenceJsp();
		@SuppressWarnings("unused")
		ArrayList  searchReferenceList = (ArrayList)map.get("searchReferenceList");
		jsp =  REFERENCE_JSP;
		jsp += ".jsp";
		title = "Reference";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addReference(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MasReference masReference=new MasReference();

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

		List referenceCodeList = new ArrayList();
		List referenceNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			referenceCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			referenceNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((referenceCodeList.size() == 0 || referenceCodeList == null) && (referenceNameList.size() == 0 || referenceNameList == null))
		{
			masReference.setReferenceCode(code);
			masReference.setReferenceName(name);
			masReference.setStatus("y");
			masReference.setLastChgBy(changedBy);
			masReference.setLastChgDate(currentDate);
			masReference.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addReference(masReference);		

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
			}

		else if((referenceCodeList.size() != 0 || referenceCodeList != null) || (referenceNameList.size() != 0) || referenceNameList != null){

			if((referenceCodeList.size() != 0 || referenceCodeList != null) && (referenceNameList.size() == 0 || referenceNameList == null)){
				message = "Reference Code  already exists.";
			}
			else if((referenceNameList.size() != 0 || referenceNameList != null) && (referenceCodeList.size() == 0 || referenceCodeList == null) ){
				message = "Reference Name already exists.";
			}
			else if((referenceCodeList.size() != 0 || referenceCodeList != null) && (referenceNameList.size() != 0 || referenceNameList != null)){

				message = "Reference Code and Reference Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showReferenceJsp";
		
		try{
			map = generalMasterHandlerService.showReferenceJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showReferenceJsp "+e);
		}
		jsp=REFERENCE_JSP;
		title="Add Reference";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}


	public ModelAndView editReference(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String referenceCode="";
		String referenceName="";
		int referenceId=0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
	

		referenceCode=(String )session.getAttribute("referenceCode");
		referenceName=(String )session.getAttribute("referenceName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			referenceId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			referenceCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			referenceName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", referenceId);
		generalMap.put("referenceCode", referenceCode);
		generalMap.put("name", referenceName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	 generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		  List existingReferenceNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingReferenceNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editReferenceToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingReferenceNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showReferenceJsp";
		
		try{
			map = generalMasterHandlerService.showReferenceJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showReferenceJsp "+e);
		}
		jsp=REFERENCE_JSP;
		title="edit Reference";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteReference(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int referenceId=0;
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
			referenceId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteReference(referenceId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully!!";
		}
		url = "/hms/hms/generalMaster?method=showReferenceJsp";
		
		try{
			map = generalMasterHandlerService.showReferenceJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showReferenceJsp "+e);
		}
		jsp=REFERENCE_JSP;
		title="delete Reference";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
//-----------------------------------------------------------------------------------
	
	
	public ModelAndView generateReportForGeneralMasters(HttpServletRequest request, HttpServletResponse response)
	{	String hospitalName="";
		String jasper = "";
		if (request.getParameter(JASPER_FILE_NAME)!=null)
		{
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		System.out.println("jasper------------------"+jasper);
		int hospitalId=0;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = generalMasterHandlerService.getHospitalName(hospitalId);
			parameters.put("HOSP_NAME", hospitalName);
			parameters.put("hospitalId", hospitalId);
		}
		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        Map<String, Object> connectionMap  = generalMasterHandlerService.getConnection();
		parameters.put("path", imagePath);
		parameters.put("hospitalName", hospitalName);
		HMSUtil.generateReport(jasper, parameters, (Connection)connectionMap.get("conn"), response, getServletContext());
		return null;
	}

	public ModelAndView showImmunizationJsp(HttpServletRequest request,HttpServletResponse response)
	{

		Map<String, Object> map = new HashMap<String, Object>();
		map = generalMasterHandlerService.showImmunizationJsp();
		String jsp="immunization";
		jsp += ".jsp";
		title = "immunization";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}

	public ModelAndView addImmunization(HttpServletRequest request, HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		MasImmunization masImmunization=new MasImmunization();
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
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


		List immunizationCodeList = new ArrayList();
		List immunizationNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			immunizationCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			immunizationNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((immunizationCodeList.size() == 0 || immunizationCodeList == null) && (immunizationNameList.size() == 0 || immunizationNameList == null))
		{
			masImmunization.setImmunizationCode(code);
			masImmunization.setImmunizationName(name);
			masImmunization.setStatus("y");
			Users user = (Users)session.getAttribute("users");
			masImmunization.setLastChgBy(user);
			masImmunization.setLastChgDate(currentDate);
			masImmunization.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addImmunization(masImmunization);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}
			else{
				message="Try Again !!";
			}
		}

		else if((immunizationCodeList.size() != 0 || immunizationCodeList != null) || (immunizationNameList.size() != 0) || immunizationNameList != null)
		{
			if((immunizationCodeList.size() != 0 || immunizationCodeList != null) && (immunizationNameList.size() == 0 || immunizationNameList == null)){

				message = "Immunization Code  already exists.";
			}
			else if((immunizationNameList.size() != 0 || immunizationNameList != null) && (immunizationCodeList.size() == 0 || immunizationCodeList == null) ){

				message = "Immunization Name already exists.";
			}
			else if((immunizationCodeList.size() != 0 || immunizationCodeList != null) && (immunizationNameList.size() != 0 || immunizationNameList != null)){

				message = "Immunization Code and Immunization Name already exist.";
			}
		}
		
		try{
			map = generalMasterHandlerService.showImmunizationJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="immunization";
		title="Add Title";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editImmunization(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String immunizationCode="";
		String immunizationName="";
		int immunizationId=0;
		String changedTime = "";
		Date changedDate = null;

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			immunizationId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			immunizationCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			immunizationName = request.getParameter(SEARCH_NAME);
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
		Users user = (Users)session.getAttribute("users");
		generalMap.put("id", immunizationId);
		generalMap.put("immunizationCode", immunizationCode);
		generalMap.put("name", immunizationName);
		generalMap.put("changedBy", user);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingImmunizationNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingImmunizationNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editImmunizationToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingImmunizationNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showImmunizationJsp";
		
		try{
			map = generalMasterHandlerService.showImmunizationJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="immunization";
		title="update Immunization";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView deleteImmunization(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int immunizationId=0;
		String message=null;
		
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			immunizationId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
		Users user = (Users)session.getAttribute("users");
		generalMap.put("changedBy", user);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=generalMasterHandlerService.deleteImmunization(immunizationId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showImmunizationJsp";
		
		try{
			map = generalMasterHandlerService.showImmunizationJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="immunization";
		title="delete Immunization";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView searchImmunization(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String immunizationCode  = null;
		String immunizationName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			immunizationCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			immunizationName = request.getParameter(SEARCH_NAME);
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
			immunizationCode=searchField;
			immunizationName=null;

		}else{
			immunizationCode=null;
			immunizationName=searchField;
		}
		map = generalMasterHandlerService.searchImmunization(immunizationCode, immunizationName);

		jsp="immunization";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("immunizationCode",immunizationCode);
		map.put("immunizationName",immunizationName);
		return new ModelAndView("indexB", "map", map);
	}
	
	

	@SuppressWarnings("unchecked")
	public ModelAndView showDivisionJsp(HttpServletRequest request,HttpServletResponse response)
	{

		Map map = new HashMap();
		map = generalMasterHandlerService.showDivisionJsp();
		String jsp="division";
		jsp += ".jsp";
		title = "Division";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addDivision(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MasDivision masDivision=new MasDivision();
		String changedBy = "";
		String cla="";
		String dla="";
		String dlh="";
		String dila="";
		String dela="";
		String nsaa="";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("cla") != null) {
			cla = request.getParameter("cla");
		}
		
		if (request.getParameter("dla") != null) {
			dla = request.getParameter("dla");
		}
		if (request.getParameter("dlh") != null) {
			dlh = request.getParameter("dlh");
		}
		if (request.getParameter("dila") != null) {
			dila = request.getParameter("dila");
		}
		if (request.getParameter("dela") != null) {
			dela = request.getParameter("dela");
		}
		if (request.getParameter("nsaa") != null) {
			nsaa = request.getParameter("nsaa");
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


		List divisionCodeList = new ArrayList();
		List divisionNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			divisionCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			divisionNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((divisionCodeList.size() == 0 || divisionCodeList == null) && (divisionNameList.size() == 0 || divisionNameList == null))
		{
			masDivision.setDivisionCode(code);
			masDivision.setDivisionName(name);
			masDivision.setStatus("y");
		//	masDivision.setLastChgBy(changedBy);
			masDivision.setLastChgDate(currentDate);
			masDivision.setLastChgTime(currentTime);
			masDivision.setCoveringLetterAuthority(cla);
			masDivision.setDispatchLetterAuthority(dla);
			masDivision.setDispatchLetterHeader(dlh);
			masDivision.setDivisionalLetterAuthority(dila);
			masDivision.setDietLetterAuthority(dela);
			masDivision.setNoteSheetSignatureAuthority(nsaa);
			
			successfullyAdded = generalMasterHandlerService.addDivision(masDivision);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}
			else{
				message="Try Again !!";
			}
		}

		else if((divisionCodeList.size() != 0 || divisionCodeList != null) || (divisionNameList.size() != 0) || divisionNameList != null)
		{
			if((divisionCodeList.size() != 0 || divisionCodeList != null) && (divisionNameList.size() == 0 || divisionNameList == null)){

				message = "Division Code  already exists.";
			}
			else if((divisionNameList.size() != 0 || divisionNameList != null) && (divisionCodeList.size() == 0 || divisionCodeList == null) ){

				message = "Division Name already exists.";
			}
			else if((divisionCodeList.size() != 0 || divisionCodeList != null) && (divisionNameList.size() != 0 || divisionNameList != null)){

				message = "Division Code and Division Name already exist.";
			}
		}
		
		try{
			map = generalMasterHandlerService.showDivisionJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="division";
		title="Add Division";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editDivision(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String divisionCode="";
		String divisionName="";
		int divisionId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String cla="";
		String dla="";
		String dlh="";
		String dila="";
		String dela="";
		String nsaa="";
		if (request.getParameter("cla") != null) {
			cla = request.getParameter("cla");
		}
		if (request.getParameter("dla") != null) {
			dla = request.getParameter("dla");
		}
		if (request.getParameter("dlh") != null) {
			dlh = request.getParameter("dlh");
		}
		if (request.getParameter("dila") != null) {
			dila = request.getParameter("dila");
		}
		if (request.getParameter("nsaa") != null) {
			nsaa = request.getParameter("nsaa");
		}
		if (request.getParameter("dela") != null) {
			dela = request.getParameter("dela");
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			divisionId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			divisionCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			divisionName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", divisionId);
		generalMap.put("divisionCode", divisionCode);
		generalMap.put("name", divisionName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("dila", dila);
		generalMap.put("cla", cla);
		generalMap.put("dla", dla);
		generalMap.put("dlh", dlh);
		generalMap.put("dela", dela);
		generalMap.put("nsaa", nsaa);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingDivisionNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingDivisionNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editDivisionToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingDivisionNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showDivisionJsp";
		
		try{
			map = generalMasterHandlerService.showDivisionJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="division";
		title="update Division";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteDivision(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int divisionId=0;
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
			divisionId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteDivision(divisionId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showDivisionJsp";
		
		try{
			map = generalMasterHandlerService.showDivisionJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="division";
		title="delete Division";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView searchDivision(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String divisionCode  = null;
		String divisionName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			divisionCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			divisionName = request.getParameter(SEARCH_NAME);
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
			divisionCode=searchField;
			divisionName=null;

		}else{
			divisionCode=null;
			divisionName=searchField;
		}
		map = generalMasterHandlerService.searchDivision(divisionCode, divisionName);

		jsp="division";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("divisionCode",divisionCode);
		map.put("divisionName",divisionName);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	
//	----------------------------- Grade -----------------------


	@SuppressWarnings("unchecked")
	public ModelAndView showGradeJsp(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map=(Map)generalMasterHandlerService.showGradeJsp();
		String jsp="grade";
		jsp += ".jsp";
		title = "Grade";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addGrade(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map = new HashMap<String,Object>();
		MasGrade masGrade = new MasGrade();

		int majorCategoryId=0;
		String changedBy = "";
		Map<String, Object> listMap=new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		try{
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}

			if (request.getParameter(RANK_CATEGORY_ID) != null) {
				majorCategoryId = Integer.valueOf(request.getParameter(RANK_CATEGORY_ID));
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
			}catch (Exception e) {
			//System.out.println("Exception in ret"+e);
		}

		try{

			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		}catch (Exception e) {
			//System.out.println("Exception  MID "+e);
		}

		List gradeCodeList = new ArrayList();
		List gradeNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			gradeCodeList = (List)listMap.get("duplicateGeneralCodeList");

		}
		if(listMap.get("duplicateGeneralNameList") != null){
			gradeNameList = (List)listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if((gradeCodeList.size() == 0 || gradeCodeList == null) && (gradeNameList.size() == 0 || gradeNameList == null)){
			masGrade.setGradeCode(code);
			masGrade.setGradeName(name);
			MasRankCategory masRankCategory = new MasRankCategory();
			masRankCategory.setId(majorCategoryId);
			masGrade.setRankCategory(masRankCategory);
			masGrade.setStatus("y");
			masGrade.setLastChgBy(changedBy);
			masGrade.setLastChgDate(currentDate);
			masGrade.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addGrade(masGrade);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}else{
				message="Try Again !!";
			}

		}else if((gradeCodeList.size() != 0 || gradeCodeList != null) || (gradeNameList.size() != 0) || gradeNameList != null){
			if((gradeCodeList.size() != 0 || gradeCodeList != null) && (gradeNameList.size() == 0 || gradeNameList == null)){
				message = "Grade Code already exists.";
			}
			else if((gradeNameList.size() != 0 || gradeNameList != null) && (gradeCodeList.size() == 0 || gradeCodeList == null) ){
				message = "Grade Name already exists.";
			}
			else if((gradeCodeList.size() != 0 || gradeCodeList != null) && (gradeNameList.size() != 0 || gradeNameList != null)){
				message = "Grade Code and Grade exist.";
			}
		}

		
		try{
			map = generalMasterHandlerService.showGradeJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showSatte "+e);
		}
		jsp="grade";
		title="Add Grade";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView editGrade(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		String gradeCode="";
		String gradeName="";
		int rankCategoryId=0;
		int gradeId=0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		try{
			if(request.getParameter(RANK_CATEGORY_ID) != null && !(request.getParameter(RANK_CATEGORY_ID).equals(""))){
				rankCategoryId =Integer.parseInt( request.getParameter(RANK_CATEGORY_ID));
			}
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				gradeId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				gradeCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				gradeName = request.getParameter(SEARCH_NAME);
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
			if(request.getParameter("pojoName") != null){
				pojoName = request.getParameter("pojoName"); 
			}
			if(request.getParameter("pojoPropertyName") != null){
				pojoPropertyName = request.getParameter("pojoPropertyName"); 
			}
			if(request.getParameter("title") != null){
				title = request.getParameter("title"); 
			}

		}catch (Exception e) {
			//System.out.println("e1 "+e);
		}

		changedDate = new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

			generalMap.put("id", gradeId);
			generalMap.put("gradeCode", gradeCode);
			generalMap.put("name", gradeName);
			generalMap.put("rankCategoryId",rankCategoryId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	 generalMap.put("flag", true);
			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			  List existingGradeNameList = (List)listMap.get("duplicateMastersList");
			  boolean dataUpdated=false;
			  if(existingGradeNameList.size() == 0)
			  {
				  dataUpdated=generalMasterHandlerService.editGrade(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(existingGradeNameList.size() > 0){
				   message = "Name already exists.";
				  }
		try{
			map = generalMasterHandlerService.showGradeJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showSatte "+e);
		}
		jsp="grade";
		title="Edit Grade";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView searchGrade(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException{
		Map<String, Object> map= new HashMap<String, Object>();		
		String searchField  = null;
		String gradeCode= null;
		String gradeName= null;	
		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(searchRadio==1){
			gradeCode=searchField;
			gradeName=null;

		}else{
			gradeCode=null;
			gradeName=searchField;
		}
		map = generalMasterHandlerService.searchGrade(gradeCode, gradeName);
		jsp = "grade";	
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("gradeCode",gradeCode);
		map.put("gradeName",gradeName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteGrade(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int gradeId=0;
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
			gradeId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteGrade(gradeId,generalMap);
		if (dataDeleted==true)
		{

			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}

		url = "/hms/hms/generalMaster?method=showGradeJsp";
		
		try{
			map = generalMasterHandlerService.showGradeJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showSatte "+e);
		}
		jsp="grade";
		title="delete Grade";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}
	
//	-------------------------employeeType ------------------------------------------------

	public ModelAndView searchEmployeeType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String employeeTypeCode  = null;
		String employeeTypeName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			employeeTypeCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			employeeTypeName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(searchRadio==1){
			employeeTypeCode=searchField;
			employeeTypeName=null;

		}else{
			employeeTypeCode=null;
			employeeTypeName=searchField;
		}
		map = generalMasterHandlerService.searchEmployeeType(employeeTypeCode, employeeTypeName);

		jsp="employeeType";
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("employeeTypeCode",employeeTypeCode);
		map.put("employeeTypeName",employeeTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showEmployeeTypeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = generalMasterHandlerService.showEmployeeTypeJsp();
		@SuppressWarnings("unused")
		ArrayList  searchEmployeeTypeList = (ArrayList)map.get("searchEmployeeTypeList");
		jsp = "employeeType";
		jsp += ".jsp";
		title = "EmployeeType";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addEmployeeType(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MasEmployeeType masEmployeeType=new MasEmployeeType();

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

		List employeeTypeCodeList = new ArrayList();
		List employeeTypeNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			employeeTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			employeeTypeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((employeeTypeCodeList.size() == 0 || employeeTypeCodeList == null) && (employeeTypeNameList.size() == 0 || employeeTypeNameList == null))
		{
			masEmployeeType.setEmployeeTypeCode(code);
			masEmployeeType.setEmployeeTypeName(name);
			masEmployeeType.setStatus("y");
			//masEmployeeType.setLastChgBy(changedBy);
			masEmployeeType.setLastChgDate(currentDate);
			masEmployeeType.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addEmployeeType(masEmployeeType);		

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((employeeTypeCodeList.size() != 0 || employeeTypeCodeList != null) || (employeeTypeNameList.size() != 0) || employeeTypeNameList != null){

			if((employeeTypeCodeList.size() != 0 || employeeTypeCodeList != null) && (employeeTypeNameList.size() == 0 || employeeTypeNameList == null)){
				message = "EmployeeType Code  already exists.";
			}
			else if((employeeTypeNameList.size() != 0 || employeeTypeNameList != null) && (employeeTypeCodeList.size() == 0 || employeeTypeCodeList == null) ){
				message = "EmployeeType Name already exists.";
			}
			else if((employeeTypeCodeList.size() != 0 || employeeTypeCodeList != null) && (employeeTypeNameList.size() != 0 || employeeTypeNameList != null)){
				message = "EmployeeType Code and EmployeeType Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showEmployeeTypeJsp";
		
		try{
			map = generalMasterHandlerService.showEmployeeTypeJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showEmployeeTypeJsp "+e);
		}
		jsp="employeeType";
		title="Add employeeType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView editEmployeeType(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String employeeTypeCode="";
		String employeeTypeName="";
		int employeeTypeId=0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			employeeTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			employeeTypeCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			employeeTypeName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", employeeTypeId);
		generalMap.put("employeeTypeCode", employeeTypeCode);
		generalMap.put("name", employeeTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	 generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		  List existingEmployeeTypeNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingEmployeeTypeNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editEmployeeTypeToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingEmployeeTypeNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showEmployeeTypeJsp";
		try{
			map = generalMasterHandlerService.showEmployeeTypeJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showEmployeeTypeJsp "+e);
		}
		jsp="employeeType";
		title="Update employeeType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteEmployeeType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeeTypeId=0;
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
			employeeTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteEmployeeType(employeeTypeId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showEmployeeTypeJsp";
		try{
			map = generalMasterHandlerService.showEmployeeTypeJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in  showEmployeeTypeJsp "+e);
		}
		jsp="employeeType";
		title="Delete employeeType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}
	

	@SuppressWarnings("unchecked")
	public ModelAndView showImpanneledHospitalJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = generalMasterHandlerService.showImpanneledHospitalJsp();
		String jsp = "impanneledHospital";
		jsp += ".jsp";
		title = "ImpanneledHospital";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addImpanneledHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasImpanneledHospital masImpanneledHospital = new MasImpanneledHospital();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String changedBy = "";
		String impanneledHospitalAddress = "";
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(ADDRESS) != null) {
			impanneledHospitalAddress = request.getParameter(ADDRESS);
		}
		 
	
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("impanneledHospitalAddress", impanneledHospitalAddress);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
         
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);

		List impanneledHospitalCodeList = new ArrayList();
		List impanneledHospitalNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			impanneledHospitalCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			impanneledHospitalNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		
		boolean successfullyAdded = false;

		if ((impanneledHospitalCodeList.size() == 0 || impanneledHospitalCodeList == null)
				&& (impanneledHospitalNameList.size() == 0 || impanneledHospitalNameList == null)) {
			masImpanneledHospital.setImpanneledHospitalCode(code);
			masImpanneledHospital.setImpanneledHospitalName(name);
			masImpanneledHospital.setAddress(impanneledHospitalAddress);
			
			masImpanneledHospital.setStatus("y");
			masImpanneledHospital.setLastChgBy(changedBy);
			masImpanneledHospital.setLastChgDate(currentDate);
			masImpanneledHospital.setLastChgTime(currentTime);
			
			
			successfullyAdded = generalMasterHandlerService.addImpanneledHospital(masImpanneledHospital);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}else if ((impanneledHospitalCodeList.size() != 0 || impanneledHospitalCodeList != null)
				|| (impanneledHospitalNameList.size() != 0) || impanneledHospitalNameList != null) {
			if ((impanneledHospitalCodeList.size() != 0 || impanneledHospitalCodeList != null)
					&& (impanneledHospitalNameList.size() == 0 || impanneledHospitalNameList == null)) {

				message = "Impanneled Hospital Code  already exists.";
			} else if ((impanneledHospitalNameList.size() != 0 || impanneledHospitalNameList != null)
					&& (impanneledHospitalCodeList.size() == 0 || impanneledHospitalCodeList == null)) {

				message = "Impanneled Hospital Name already exists.";
			} else if ((impanneledHospitalCodeList.size() != 0 || impanneledHospitalCodeList != null)
					&& (impanneledHospitalNameList.size() != 0 || impanneledHospitalNameList != null)) {

				message = "Impanneled Hospital Code and ImpanneledHospital Name already exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showImpanneledHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "impanneledHospital";
		title = "Add ImpanneledHospital";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editImpanneledHospital(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String impanneledHospitalCode = "";
		String impanneledHospitalName = "";
		int userGroupsId = 0;
		String impanneledHospitalAddress = "";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			impanneledHospitalCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			impanneledHospitalName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(ADDRESS) != null) {
			impanneledHospitalAddress = request.getParameter(ADDRESS);
		}
		
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
	
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", userGroupsId);
		generalMap.put("userGroupsCode", impanneledHospitalCode);
		generalMap.put("name", impanneledHospitalName);
		generalMap.put("impanneledHospitalAddress", impanneledHospitalAddress);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingImpanneledHospitalNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingImpanneledHospitalNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editImpanneledHospitalToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingImpanneledHospitalNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/user?method=showImpanneledHospitalJsp";

		try {
			map = generalMasterHandlerService.showImpanneledHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "impanneledHospital";
		title = "update ImpanneledHospital";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteImpanneledHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int impanneledHospitalId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			impanneledHospitalId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteImpanneledHospital(impanneledHospitalId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/user?method=showImpanneledHospitalJsp";

		try {
			map = generalMasterHandlerService.showImpanneledHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "impanneledHospital";
		title = "delete ImpanneledHospital";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView searchImpanneledHospital(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String impanneledHospitalCode = null;
		String impanneledHospitalName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			impanneledHospitalCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			impanneledHospitalName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			impanneledHospitalCode = searchField;
			impanneledHospitalName = null;

		} else {
			impanneledHospitalCode = null;
			impanneledHospitalName = searchField;
		}
		map = generalMasterHandlerService.searchImpanneledHospital(impanneledHospitalCode,
				impanneledHospitalName);

		jsp = "impanneledHospital";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("impanneledHospitalCode", impanneledHospitalCode);
		map.put("impanneledHospitalName", impanneledHospitalName);
		return new ModelAndView("indexB", "map", map);
	}
	public GeneralMasterHandlerService getGeneralMasterHandlerService() {
		return generalMasterHandlerService;
	}

	public void setGeneralMasterHandlerService(GeneralMasterHandlerService generalMasterHandlerService) {
		this.generalMasterHandlerService = generalMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showZonalJsp(HttpServletRequest request,HttpServletResponse response)
	{

		Map map = new HashMap();
		map = generalMasterHandlerService.showZonalJsp();
		String jsp="zonal";
		jsp += ".jsp";
		title = "Zonal";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addZonal(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MasZonal masZonal=new MasZonal();
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String changedBy="";
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
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


		List zonalCodeList = new ArrayList();
		List zonalNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			zonalCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			zonalNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((zonalCodeList.size() == 0 || zonalCodeList == null) && (zonalNameList.size() == 0 || zonalNameList == null))
		{
			masZonal.setZonalCode(code);
			masZonal.setZonalName(name);
			masZonal.setStatus("y");
			masZonal.setLastChgBy(changedBy);
			masZonal.setLastChgDate(currentDate);
			masZonal.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addZonal(masZonal);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}
			else{
				message="Try Again !!";
			}
		}

		else if((zonalCodeList.size() != 0 || zonalCodeList != null) || (zonalNameList.size() != 0) || zonalNameList != null)
		{
			if((zonalCodeList.size() != 0 || zonalCodeList != null) && (zonalNameList.size() == 0 || zonalNameList == null)){

				message = "Zonal Code  already exists.";
			}
			else if((zonalNameList.size() != 0 || zonalNameList != null) && (zonalCodeList.size() == 0 || zonalCodeList == null) ){

				message = "Zonal Name already exists.";
			}
			else if((zonalCodeList.size() != 0 || zonalCodeList != null) && (zonalNameList.size() != 0 || zonalNameList != null)){

				message = "Zonal Code and Zonal Name already exist.";
			}
		}
		
		try{
			map = generalMasterHandlerService.showZonalJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="zonal";
		title="Add Zonal";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editZonal(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String zonalCode="";
		String zonalName="";
		int zonalId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			zonalId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			zonalCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			zonalName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", zonalId);
		generalMap.put("zonalCode", zonalCode);
		generalMap.put("name", zonalName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingZonalNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingZonalNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editZonalToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingZonalNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showZonalJsp";
		
		try{
			map = generalMasterHandlerService.showZonalJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="zonal";
		title="update Zonal";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteZonal(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int zonalId=0;
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
			zonalId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteZonal(zonalId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showZonalJsp";
		
		try{
			map = generalMasterHandlerService.showZonalJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="zonal";
		title="delete Zonal";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView searchZonal(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String zonalCode  = null;
		String zonalName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			zonalCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			zonalName = request.getParameter(SEARCH_NAME);
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
			zonalCode=searchField;
			zonalName=null;

		}else{
			zonalCode=null;
			zonalName=searchField;
		}
		map = generalMasterHandlerService.searchZonal(zonalCode, zonalName);

		jsp="zonal";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("zonalCode",zonalCode);
		map.put("zonalName",zonalName);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView showWardImpanneledHospitalJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = generalMasterHandlerService.showWardImpanneledHospitalJsp();
		jsp = "wardImpanneledHospital";
		jsp += ".jsp";
		title = "Ward Impanneled Hospital";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addWardImpanneledHospitalJsp(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasWardImpanneledHospital  masWardImpanneledHospital=new MasWardImpanneledHospital();

		String changedBy = "";
		int impanneledHospital=0;
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

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
		if(request.getParameter("impanneledHospital") != null && !(request.getParameter("impanneledHospital").equals("0"))){
			impanneledHospital = Integer.parseInt(request.getParameter("impanneledHospital"));
		}
		
	
		generalMap.put("name", name);
		generalMap.put("impanneledHospital", impanneledHospital);
		

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = generalMasterHandlerService.checkForExistingWardImpanneledHospital(generalMap);

		List wardImpanneledHospitalList = new  ArrayList();

		if(listMap.get("wardImpanneledHospitalList") != null){
			wardImpanneledHospitalList = (List)listMap.get("wardImpanneledHospitalList");
		}
	
		boolean successfullyAdded = false;

		if((wardImpanneledHospitalList.size() == 0 || wardImpanneledHospitalList == null))
		{
			masWardImpanneledHospital.setWardName(name);
			MasImpanneledHospital mih = new MasImpanneledHospital();
			mih.setId(impanneledHospital);
			masWardImpanneledHospital.setImpanneledHospital(mih);
			
			masWardImpanneledHospital.setStatus("y");
			masWardImpanneledHospital.setLastChgBy(changedBy);
			masWardImpanneledHospital.setLastChgDate(currentDate);
			masWardImpanneledHospital.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addWardImpanneledHospitalJsp(masWardImpanneledHospital);		

			String message = null;
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";

			}
			else
			{
				message="Try Again  !!";
			}
		}

		else if((wardImpanneledHospitalList.size() != 0 || wardImpanneledHospitalList != null)){ 
				message = "Ward Name and Impanneled Hospital already exists.";
			}
			

		url = "/hms/hms/generalMaster?method=showWardImpanneledHospitalJsp";
		
		try{
			map = generalMasterHandlerService.showWardImpanneledHospitalJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in showUnitOfMeasurementJsp "+e);
		}
		jsp="wardImpanneledHospital";
		title="Add wardImpanneledHospital";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editWardImpanneledHospital(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String wardName="";
		int impanneledHospital=0;
		int wardImpanneledHospitalId=0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			wardImpanneledHospitalId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			wardName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		
		if(request.getParameter("impanneledHospital") != null && !(request.getParameter("impanneledHospital").equals("0"))){
			impanneledHospital =Integer.parseInt( request.getParameter("impanneledHospital"));
		}
		
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", wardImpanneledHospitalId);
		generalMap.put("name", wardName);
		generalMap.put("impanneledHospital", impanneledHospital);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		
    	 generalMap.put("flag", true);
		
    	 listMap = generalMasterHandlerService.checkForExistingWardImpanneledHospital(generalMap);
		 
    	 List wardImpanneledHospitalList = (List)listMap.get("wardImpanneledHospitalList");
		  boolean dataUpdated=false;
		  if(wardImpanneledHospitalList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editWardImpanneledHospital(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(wardImpanneledHospitalList.size() > 0){
			  message = "Ward Name and Impanneled Hospital already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showWardImpanneledHospitalJsp";
		
		try{
			map = generalMasterHandlerService.showWardImpanneledHospitalJsp();
			
		}catch (Exception e) {
			//System.out.println("Exception in showUnitOfMeasurementJsp "+e);
		}
		jsp="wardImpanneledHospital";
		title="Update Of Ward Impanneled Hospital";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteWardImpanneledHospital(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int wardImpanneledHospitalId=0;
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
			wardImpanneledHospitalId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteWardImpanneledHospital(wardImpanneledHospitalId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showWardImpanneledHospitalJsp";
		
		try{
			map = generalMasterHandlerService.showWardImpanneledHospitalJsp();
			
		}catch (Exception e) {
			e.printStackTrace();;
		}
		jsp="wardImpanneledHospital";
		title="Delete Ward Impanneled Hospital";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchWardImpanneledHospital(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		int  impanneledHospitalSearch  = 0;

		if(request.getParameter("impanneledHospitalSearch") != null && !(request.getParameter("impanneledHospitalSearch").equals("0"))){
			impanneledHospitalSearch = Integer.parseInt(request.getParameter("impanneledHospitalSearch"));
		}


		
		map = generalMasterHandlerService.searchWardImpanneledHospital(impanneledHospitalSearch);

		jsp="wardImpanneledHospital";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("impanneledHospitalSearch",impanneledHospitalSearch);
		return new ModelAndView("indexB", "map", map);
	}

	

	
	
	@SuppressWarnings("unchecked")
	public ModelAndView showProposedMPRJsp(HttpServletRequest request,HttpServletResponse response)
	{

		Map map = new HashMap();
		map = generalMasterHandlerService.showProposedMPRJsp();
		String jsp="proposedMPR";
		jsp += ".jsp";
		title = "ProposedMPR";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addProposedMPR(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MasProposedMPR masProposedMPR=new MasProposedMPR();
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String changedBy="";
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
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


		List proposedMPRCodeList = new ArrayList();
		List proposedMPRNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			proposedMPRCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			proposedMPRNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((proposedMPRCodeList.size() == 0 || proposedMPRCodeList == null) && (proposedMPRNameList.size() == 0 || proposedMPRNameList == null))
		{
			masProposedMPR.setProposedMPRCode(code);
			masProposedMPR.setProposedMPRName(name);
			masProposedMPR.setStatus("y");
			masProposedMPR.setLastChgBy(changedBy);
			masProposedMPR.setLastChgDate(currentDate);
			masProposedMPR.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addProposedMPR(masProposedMPR);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}
			else{
				message="Try Again !!";
			}
		}

		else if((proposedMPRCodeList.size() != 0 || proposedMPRCodeList != null) || (proposedMPRNameList.size() != 0) || proposedMPRNameList != null)
		{
			if((proposedMPRCodeList.size() != 0 || proposedMPRCodeList != null) && (proposedMPRNameList.size() == 0 || proposedMPRNameList == null)){

				message = "ProposedMPR Code  already exists.";
			}
			else if((proposedMPRNameList.size() != 0 || proposedMPRNameList != null) && (proposedMPRCodeList.size() == 0 || proposedMPRCodeList == null) ){

				message = "ProposedMPR Name already exists.";
			}
			else if((proposedMPRCodeList.size() != 0 || proposedMPRCodeList != null) && (proposedMPRNameList.size() != 0 || proposedMPRNameList != null)){

				message = "ProposedMPR Code and ProposedMPR Name already exist.";
			}
		}
		
		try{
			map = generalMasterHandlerService.showProposedMPRJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="proposedMPR";
		title="Add ProposedMPR";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editProposedMPR(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String proposedMPRCode="";
		String proposedMPRName="";
		int proposedMPRId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			proposedMPRId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			proposedMPRCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			proposedMPRName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", proposedMPRId);
		generalMap.put("proposedMPRCode", proposedMPRCode);
		generalMap.put("name", proposedMPRName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingProposedMPRNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingProposedMPRNameList.size() == 0)
		  {
			  dataUpdated=generalMasterHandlerService.editProposedMPRToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingProposedMPRNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showProposedMPRJsp";
		
		try{
			map = generalMasterHandlerService.showProposedMPRJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="proposedMPR";
		title="update ProposedMPR";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteProposedMPR(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int proposedMPRId=0;
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
			proposedMPRId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=generalMasterHandlerService.deleteProposedMPR(proposedMPRId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showProposedMPRJsp";
		
		try{
			map = generalMasterHandlerService.showProposedMPRJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="proposedMPR";
		title="delete ProposedMPR";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView searchProposedMPR(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String proposedMPRCode  = null;
		String proposedMPRName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			proposedMPRCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			proposedMPRName = request.getParameter(SEARCH_NAME);
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
			proposedMPRCode=searchField;
			proposedMPRName=null;

		}else{
			proposedMPRCode=null;
			proposedMPRName=searchField;
		}
		map = generalMasterHandlerService.searchProposedMPR(proposedMPRCode, proposedMPRName);

		jsp="proposedMPR";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("proposedMPRCode",proposedMPRCode);
		map.put("proposedMPRName",proposedMPRName);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView generateReportForDepartment(HttpServletRequest request, HttpServletResponse response)
	{	String hospitalName="";
		String jasper = "";
		if (request.getParameter(JASPER_FILE_NAME)!=null)
		{
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		System.out.println("jasper------------------"+jasper);
		int hospitalId=0;
		String departmentCode = null;
		String departmentName = null;
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = generalMasterHandlerService.getHospitalName(hospitalId);
			parameters.put("HOSP_NAME", hospitalName);
			parameters.put("hospitalId", hospitalId);
		}
		int divisionId=0;
		int divisionIdSearch=0;
		String searchField = null;
String qry="";
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			departmentCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			departmentName = request.getParameter(SEARCH_NAME);
		}	
		if (request.getParameter("divisionIdSearch") != null 	&& !(request.getParameter("divisionIdSearch").equals("0"))) {
			divisionId = Integer.parseInt(request.getParameter("divisionIdSearch"));
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(searchRadio);
		if (searchRadio == 1) {
			departmentCode = searchField;
			departmentName = null;
			divisionIdSearch=0;
			qry=" and  mas_department.department_code like '"+departmentCode+"'";
			
		} 
		 if (searchRadio == 2) {
			departmentCode = null;
			departmentName = searchField;
			divisionIdSearch=0;
			qry=" and  mas_department.department_name like'"+departmentName+"'";
		}
		
		 if (searchRadio == 3) {
			departmentCode = null;
			departmentName = null;
			divisionIdSearch=divisionId;
			qry=" and   mas_department.division_id ="+divisionIdSearch;
		}
		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        Map<String, Object> connectionMap  = generalMasterHandlerService.getConnection();
		parameters.put("path", imagePath);
		parameters.put("hospitalName", hospitalName);
		parameters.put("qry", qry);
		HMSUtil.generateReport(jasper, parameters, (Connection)connectionMap.get("conn"), response, getServletContext());
		return null;
	}

	
	
	
	
	
}