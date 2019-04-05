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
import jkt.hms.masters.business.MasQaOptionValue;
import jkt.hms.masters.business.MasQuestionHeading;
import jkt.hms.masters.business.MasAllergyType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasPhysiotherapyTreatment;
import jkt.hms.masters.business.MasStation;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasVaccineItem;
import jkt.hms.masters.business.OpdHoliday;
import jkt.hms.masters.business.OpdInstructionTreatment;
import jkt.hms.masters.business.MasOpdFrequency;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.OpdTemplateInvestigation;
import jkt.hms.masters.business.OpdTemplateTreatment;
import jkt.hms.masters.business.OpdVaccinMst;
import jkt.hms.masters.business.AppEquipmentMaster;
import jkt.hms.masters.business.PatientFamilyHistory;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.OPDMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class OPDMasterController extends MultiActionController {
	
	OPDMasterHandlerService opdMasterHandlerService=null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	
	
	
	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp="";
	String title="";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	String message = "";
	String code = "";
	String name = "";
	String changedBy =""; 
	String jspName = "";
	String url="";
	
	
	//****************************************** Start Of OPD by Mansi ****************************//
	
	public ModelAndView searchOpdTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String templateCode  = null;
		String templateName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			templateCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			templateName = request.getParameter(SEARCH_NAME);
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
			templateCode=searchField;
			templateName=null;

		}else{
			templateCode=null;
			templateName=searchField;
		}
		map = opdMasterHandlerService.searchOpdTemplate(templateCode, templateName);

		jsp=OPD_TEMPLATE_JSP;
		jsp += ".jsp";
		
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("templateCode",templateCode);
		map.put("templateName",templateName);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView showOpdTemplateJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map map = new HashMap();
		map = opdMasterHandlerService.showOpdTemplateJsp();
		String jsp=OPD_TEMPLATE_JSP;
		jsp += ".jsp";
		title = "OPD";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView addOpdTemplate(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		OpdTemplate opdTemplate=new OpdTemplate();
		
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int departmentId =0;
		String templateType="";
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(TEMPLATE_TYPE) != null) {
			templateType = request.getParameter(TEMPLATE_TYPE);
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

		List templateCodeList = new ArrayList();
		List templateNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			templateCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			templateNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((templateCodeList.size() == 0 || templateCodeList == null) && (templateNameList.size() == 0 || templateNameList == null))
		{
			opdTemplate.setTemplateCode(code);
			opdTemplate.setTemplateName(name);
			
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			opdTemplate.setDepartment(masDepartment);
			
			opdTemplate.setTemplateType(templateType);
			opdTemplate.setStatus("y");
			opdTemplate.setLastChgBy(changedBy);
			opdTemplate.setLastChgDate(currentDate);
			opdTemplate.setLastChgTime(currentTime);
			
			MasHospital hospital= new MasHospital();
			hospital.setId(hospitalId);
			opdTemplate.setHospital(hospital);
			
			successfullyAdded = opdMasterHandlerService.addOpdTemplate(opdTemplate);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}
			else{
				message="Try Again !!";
			}
		}

		else if((templateCodeList.size() != 0 || templateCodeList != null) || (templateNameList.size() != 0) || templateNameList != null)
		{
			if((templateCodeList.size() != 0 || templateCodeList != null) && (templateNameList.size() == 0 || templateNameList == null)){

				message = "Template Code  already exists.";
			}
			else if((templateNameList.size() != 0 || templateNameList != null) && (templateCodeList.size() == 0 || templateCodeList == null) ){

				message = "Template Name already exists.";
			}
			else if((templateCodeList.size() != 0 || templateCodeList != null) && (templateNameList.size() != 0 || templateNameList != null)){

				message = "Template Code and Template Name already exist.";
			}
		}
		
		try{
			map = opdMasterHandlerService.showOpdTemplateJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=OPD_TEMPLATE_JSP;
		title="Add OPD Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editOpdTemplate(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession(true);
		String templateCode="";
		String templateName="";
		int templateId=0;
		int departmentId =0;
		String templateType = "";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			templateId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			templateCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			templateName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(TEMPLATE_TYPE) != null) {
			templateType = request.getParameter(TEMPLATE_TYPE);
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

		generalMap.put("id", templateId);
		generalMap.put("templateCode", templateCode);
		generalMap.put("name", templateName);
		generalMap.put("departmentId", departmentId);
		generalMap.put("templateType", templateType);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingTemplateNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingTemplateNameList.size() == 0)
		  {
			  dataUpdated=opdMasterHandlerService.editOpdTemplateToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingTemplateNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/opdMaster?method=showOpdTemplateJsp";
		
		try{
			map = opdMasterHandlerService.showOpdTemplateJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=OPD_TEMPLATE_JSP;
		title="update OPD Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteOpdTemplate(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int templateId=0;
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
			templateId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=opdMasterHandlerService.deleteOpdTemplate(templateId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdTemplateJsp";
		
		try{
			map = opdMasterHandlerService.showOpdTemplateJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=OPD_TEMPLATE_JSP;
		title="delete OPD Template";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	
	
	
	public ModelAndView searchOpdHoliday(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String holidayCode  = null;
		String holidayName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			holidayCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			holidayName = request.getParameter(SEARCH_NAME);
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
			holidayCode=searchField;
			holidayName=null;

		}else{
			holidayCode=null;
			holidayName=searchField;
		}
		map = opdMasterHandlerService.searchOpdHoliday(holidayCode, holidayName);

		jsp=OPD_HOLIDAY_JSP;

		jsp += ".jsp";
		
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("holidayCode",holidayCode);
		map.put("holidayName",holidayName);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView showOpdHolidayJsp(HttpServletRequest request,HttpServletResponse response)
	{

		Map<String, Object> map = new HashMap<String, Object>();
		map = opdMasterHandlerService.showOpdHolidayJsp();
		String jsp=OPD_HOLIDAY_JSP;
		jsp += ".jsp";
		title = "Holiday";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView addOpdHoliday(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		OpdHoliday opdHoliday=new OpdHoliday();
		
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date holidayDate=  new Date();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(HOLIDAY_DATE) != null && !(request.getParameter(HOLIDAY_DATE).equals(""))){
			holidayDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(HOLIDAY_DATE));
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

		List holidayCodeList = new ArrayList();
		List holidayNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			holidayCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			holidayNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((holidayCodeList.size() == 0 || holidayCodeList == null) && (holidayNameList.size() == 0 || holidayNameList == null))
		{
			opdHoliday.setHolidayCode(code);
			opdHoliday.setHolidayName(name);
				
			opdHoliday.setHolidayDate(holidayDate);
			opdHoliday.setStatus("y");
			opdHoliday.setLastChgBy(changedBy);
			opdHoliday.setLastChgDate(currentDate);
			opdHoliday.setLastChgTime(currentTime);
			
			MasHospital hospital= new MasHospital();
			hospital.setId(hospitalId);
			opdHoliday.setHospital(hospital);
			
			successfullyAdded = opdMasterHandlerService.addOpdHoliday(opdHoliday);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}
			else{
				message="Try Again !!";
			}
		}

		else if((holidayCodeList.size() != 0 || holidayCodeList != null) || (holidayNameList.size() != 0) || holidayNameList != null)
		{
			if((holidayCodeList.size() != 0 || holidayCodeList != null) && (holidayNameList.size() == 0 || holidayNameList == null)){

				message = "Holiday Code  already exists.";
			}
			else if((holidayNameList.size() != 0 || holidayNameList != null) && (holidayCodeList.size() == 0 || holidayCodeList == null) ){

				message = "Holiday Name already exists.";
			}
			else if((holidayCodeList.size() != 0 || holidayCodeList != null) && (holidayNameList.size() != 0 || holidayNameList != null)){

				message = "Holiday Code and Holiday Name already exist.";
			}
		}
		
		try{
			map = opdMasterHandlerService.showOpdHolidayJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=OPD_HOLIDAY_JSP;
		title="Add OPD Holiday";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editOpdHoliday(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession(true);
		String holidayCode="";
		String holidayName="";
		int holidayId=0;
		Date holidayDate = new Date();
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			holidayId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			holidayCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			holidayName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(HOLIDAY_DATE) != null && !(request.getParameter(HOLIDAY_DATE).equals(""))){
			holidayDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(HOLIDAY_DATE));
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

		generalMap.put("id", holidayId);
		generalMap.put("holidayCode", holidayCode);
		generalMap.put("name", holidayName);
		generalMap.put("holidayDate", holidayDate);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingHolidayNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		if(existingHolidayNameList.size() == 0)
		  {
			  dataUpdated=opdMasterHandlerService.editOpdHolidayToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingHolidayNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/opdMaster?method=showOpdHolidayJsp";
		
		try{
			map = opdMasterHandlerService.showOpdHolidayJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=OPD_HOLIDAY_JSP;
		title="update OPD Holiday";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteOpdHoliday(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int holidayId=0;
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
			holidayId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=opdMasterHandlerService.deleteOpdHoliday(holidayId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdHolidayJsp";
		
		try{
			map = opdMasterHandlerService.showOpdHolidayJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=OPD_HOLIDAY_JSP;
		title="delete OPD Holiday";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	//****************************************** End Of OPD by Mansi ****************************//


	//****************************************** Start Of OPD Treatment Template by Mansi ****************************//

	
	@SuppressWarnings("unchecked")
	public ModelAndView addOpdTemplateTreatment(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		OpdTemplateTreatment opdTemplateTreatment=new OpdTemplateTreatment();
		
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String frequencyCodeId = "";
		int departmentId =0;
		int frequencyId=0;
		int itemId=0;
		int templateId=0;
		int instructionId=0;
		int noofdays=0;
		int total=0;
		
		String dosage="";
		if (request.getParameter(DOSAGE_CALCULATION) != null) {
			dosage = (request.getParameter(DOSAGE_CALCULATION));
		}
		if (request.getParameter(INSTRUCTIONS) != null) {
			instructionId = Integer.parseInt(request.getParameter(INSTRUCTIONS));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		System.out.println("controler addOpdTemplateTreatment----");
		System.out.println("controler request.getParameter(FREQUENCY)----"+request.getParameter(FREQUENCY));
		if (request.getParameter(FREQUENCY) != null) {
			frequencyCodeId = request.getParameter(FREQUENCY);
			System.out.println("controler frequencyCodeId----"+frequencyCodeId);
			frequencyId = Integer.parseInt(frequencyCodeId.substring(0, 1));
			System.out.println("c1 frequencyId----"+frequencyId);
		}
		if (request.getParameter(TEMPLATE_ID) != null) {
			templateId = Integer.parseInt(request.getParameter(TEMPLATE_ID));
		}
		if (request.getParameter(ITEM_ID) != null) {
			itemId = Integer.parseInt(request.getParameter(ITEM_ID));
		}
		if (request.getParameter(NO_OF_DAYS) != null) {
			noofdays = Integer.parseInt(request.getParameter(NO_OF_DAYS));
		}
		if (request.getParameter(TOTAL_AMOUNT) != null) {
			total = Integer.parseInt(request.getParameter(TOTAL_AMOUNT));
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
	/*	generalMap.put("code", code);
		generalMap.put("name", name);*/
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("hospitalId", hospitalId);
/*		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);*/

	//	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);

	//	List templateCodeList = new ArrayList();
	//	List templateNameList = new  ArrayList();

	/*	if(listMap.get("duplicateGeneralCodeList") != null){
			templateCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			templateNameList = (List)listMap.get("duplicateGeneralNameList");
		}
	*/	boolean successfullyAdded = false;

	/*	if((templateCodeList.size() == 0 || templateCodeList == null) && (templateNameList.size() == 0 || templateNameList == null))
		{
	*/	
			
			opdTemplateTreatment.setDosage(dosage);
			
			opdTemplateTreatment.setNoofdays(noofdays);
			
			opdTemplateTreatment.setTotal(total);
			
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			opdTemplateTreatment.setDepartment(masDepartment);
			
			MasFrequency masFrequency= new MasFrequency();
			masFrequency.setId(frequencyId);
			opdTemplateTreatment.setFrequency(masFrequency);
			
			OpdTemplate opdTemplate= new OpdTemplate();
			opdTemplate.setId(templateId);
			opdTemplateTreatment.setTemplate(opdTemplate);
			
			MasStoreItem masStoreItem= new MasStoreItem();
			masStoreItem.setId(itemId);
			opdTemplateTreatment.setItem(masStoreItem);
			if(instructionId != 0){
				OpdInstructionTreatment opdInstructionTreatment = new OpdInstructionTreatment();
				opdInstructionTreatment.setId(instructionId);
				opdTemplateTreatment.setOpdInstructionTreatment(opdInstructionTreatment);
			}
			opdTemplateTreatment.setStatus("y");
			opdTemplateTreatment.setLastChgBy(changedBy);
			opdTemplateTreatment.setLastChgDate(currentDate);
			opdTemplateTreatment.setLastChgTime(currentTime);
			
			MasHospital hospital= new MasHospital();
			hospital.setId(hospitalId);
			opdTemplateTreatment.setHospital(hospital);
			
			successfullyAdded = opdMasterHandlerService.addOpdTemplateTreatment(opdTemplateTreatment);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}
			else{
				message="Try Again !!";
			}
			/*		}

	else if((templateCodeList.size() != 0 || templateCodeList != null) || (templateNameList.size() != 0) || templateNameList != null)
		{
			if((templateCodeList.size() != 0 || templateCodeList != null) && (templateNameList.size() == 0 || templateNameList == null)){

				message = "Template Code  already exists.";
			}
			else if((templateNameList.size() != 0 || templateNameList != null) && (templateCodeList.size() == 0 || templateCodeList == null) ){

				message = "Template Name already exists.";
			}
			else if((templateCodeList.size() != 0 || templateCodeList != null) && (templateNameList.size() != 0 || templateNameList != null)){

				message = "Template Code and Template Name already exist.";
			}
		}
		
*/		try{
			map = opdMasterHandlerService.showOpdTemplateTreatmentJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=OPD_TREATMENT_TEMPLATE_JSP;
		title="Add OPD Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView editOpdTemplateTreatment(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession(true);
		int departmentId =0;
		String frequencyCodeId="";
		int frequencyId=0;
		int itemId=0;
		int templateId=0;
		int templateTreatmentId=0;
		int instructionId=0;
		int noofdays=0;
		int total=0;
		String dosage="";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			templateTreatmentId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if (request.getParameter(DOSAGE_CALCULATION) != null) {
			dosage = (request.getParameter(DOSAGE_CALCULATION));
		}
		if (request.getParameter(INSTRUCTIONS) != null) {
			instructionId = Integer.parseInt(request.getParameter(INSTRUCTIONS));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		System.out.println("request.getParameter(FREQUENCY)---"+request.getParameter(FREQUENCY));
		if (request.getParameter(FREQUENCY) != null) {
			frequencyCodeId = request.getParameter(FREQUENCY);
			System.out.println("request.frequencyCodeId---"+frequencyCodeId);
			frequencyId = Integer.parseInt(frequencyCodeId);
			System.out.println("request.frequencyId---"+frequencyId);
		}
		if (request.getParameter(TEMPLATE_ID) != null) {
			templateId = Integer.parseInt(request.getParameter(TEMPLATE_ID));
		}
		if (request.getParameter(ITEM_ID) != null) {
			itemId = Integer.parseInt(request.getParameter(ITEM_ID));
		}
		if (request.getParameter(NO_OF_DAYS) != null) {
			noofdays = Integer.parseInt(request.getParameter(NO_OF_DAYS));
		}
		if (request.getParameter(TOTAL_AMOUNT) != null) {
			total = Integer.parseInt(request.getParameter(TOTAL_AMOUNT));
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

		generalMap.put("id", templateTreatmentId);
		generalMap.put("templateId", templateId);
		generalMap.put("frequencyId", frequencyId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("instructionId", instructionId);
		generalMap.put("total", total);
		generalMap.put("noofdays", noofdays);
		generalMap.put("dosage", dosage);
		generalMap.put("itemId", itemId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		//Map<String, Object> listMap = new HashMap<String, Object>();
/*		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);*/
    	generalMap.put("flag", true);
		/*listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingTemplateNameList = (List)listMap.get("duplicateMastersList");
		*/  boolean dataUpdated=false;
		/*  if(existingTemplateNameList.size() == 0)
		  {
		*/	  dataUpdated=opdMasterHandlerService.editOpdTemplateTreatment(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		/*}
		  else if(existingTemplateNameList.size() > 0){
			   message = "Name already exists.";
			  }
		*/url = "/hms/hms/opdMaster?method=showOpdTemplateTreatmentJsp";
		
		try{
			map = opdMasterHandlerService.showOpdTemplateTreatmentJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=OPD_TREATMENT_TEMPLATE_JSP;
		title="update OPD Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteOpdTemplateTreatment(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int templateTreatmentId=0;
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
			templateTreatmentId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=opdMasterHandlerService.deleteOpdTemplateTreatment(templateTreatmentId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdTemplateTreatmentJsp";
		
		try{
			map = opdMasterHandlerService.showOpdTemplateTreatmentJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=OPD_TREATMENT_TEMPLATE_JSP;
		title="delete OPD Template";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	
/*	public ModelAndView searchOpdTemplateTreatment(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String templateGroup  = "";
		if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
			templateGroup = request.getParameter(SEARCH_FIELD);
		}

		map = opdMasterHandlerService.searchOpdTemplateTreatment(templateGroup);

		jsp=OPD_TREATMENT_TEMPLATE_JSP;

		jsp += ".jsp";
		
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("templateGroup",templateGroup);
		return new ModelAndView("indexB", "map", map);
	}
	*/
	
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView showOpdTemplateTreatmentJsp(HttpServletRequest request,HttpServletResponse response)
	{

		Map<String,Object> map = new HashMap<String,Object>();
		map = opdMasterHandlerService.showOpdTemplateTreatmentJsp();
		
		String jsp=OPD_TREATMENT_TEMPLATE_JSP;
		jsp += ".jsp";
		
		title = "Standard Treatment Template";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	}
	
	public ModelAndView getTemplateGroup(HttpServletRequest request, HttpServletResponse response) {
		
		   Map<String ,Object> map =new HashMap<String, Object>();
		   
		   int templateId=Integer.parseInt(request.getParameter(TEMPLATE_ID));
		   int deptId=Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		 
		   map=opdMasterHandlerService.getTemplateGroup(templateId,deptId);
		   
		   String jsp=OPD_TREATMENT_TEMPLATE_DETAILS_JSP;
		 	
		   title = "Template Group Detail";
		   map.put("templateId", templateId);
		   map.put("deptId", deptId);  
		   map.put("contentJsp",jsp);
		   map.put("title", title);
		   return new ModelAndView(jsp, "map", map);
		

	
	}
	
	
	public ModelAndView getItemList(HttpServletRequest request,HttpServletResponse response) {

		
		int deptId = 0;
		HttpSession session = request.getSession();
		
		
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		
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
			map.put("deptId", deptId);
			map.put("userName", userName);
			map.put("autoHint", autoHint);
			map = opdMasterHandlerService.getItemList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGrid";
		return new ModelAndView(jsp, "map", map);
	}
	@SuppressWarnings("unchecked")
	public void fillItemsInGrid(HttpServletRequest request,HttpServletResponse response) {
		
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
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		String pvmsNo = "";
	
		try {
			if (request.getParameter("pvmsNo") != null) {
				pvmsNo = request.getParameter("pvmsNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("deptId", deptId);
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = opdMasterHandlerService.fillItemsInGrid(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {
				sb.append("<item>");
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
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
	
	
	//****************************************** End Of OPD Treatment Template by Mansi ****************************//
	
	
	//****************************************** Start Of OPD Instruction Treatment by Mansi ****************************//


	
	public ModelAndView searchOpdInstructionTreatment(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String opdInstructionTreatmentCode  = null;
		String opdInstructionTreatmentName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			opdInstructionTreatmentCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			opdInstructionTreatmentName = request.getParameter(SEARCH_NAME);
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
			opdInstructionTreatmentCode=searchField;
			opdInstructionTreatmentName=null;

		}else{
			opdInstructionTreatmentCode=null;
			opdInstructionTreatmentName=searchField;
		}
		map = opdMasterHandlerService.searchOpdInstructionTreatment(opdInstructionTreatmentCode, opdInstructionTreatmentName);

		jsp=OPD_INSTRUCTION_TREATMENT_JSP;

		jsp += ".jsp";
		
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("opdInstructionTreatmentCode",opdInstructionTreatmentCode);
		map.put("opdInstructionTreatmentName",opdInstructionTreatmentName);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView showOpdInstructionTreatmentJsp(HttpServletRequest request,HttpServletResponse response)
	{

		Map<String, Object> map = new HashMap<String, Object>();
		map = opdMasterHandlerService.showOpdInstructionTreatmentJsp();
		String jsp=OPD_INSTRUCTION_TREATMENT_JSP;
		jsp += ".jsp";
		title = "OpdInstructionTreatment";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView addOpdInstructionTreatment(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		OpdInstructionTreatment opdInstructionTreatment=new OpdInstructionTreatment();
		
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

		List opdInstructionTreatmentCodeList = new ArrayList();
		List opdInstructionTreatmentNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			opdInstructionTreatmentCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			opdInstructionTreatmentNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((opdInstructionTreatmentCodeList.size() == 0 || opdInstructionTreatmentCodeList == null) && (opdInstructionTreatmentNameList.size() == 0 || opdInstructionTreatmentNameList == null))
		{
			opdInstructionTreatment.setOpdInstructionTreatmentCode(code);
			opdInstructionTreatment.setOpdInstructionTreatmentName(name);
				
			opdInstructionTreatment.setStatus("y");
			opdInstructionTreatment.setLastChgBy(changedBy);
			opdInstructionTreatment.setLastChgDate(currentDate);
			opdInstructionTreatment.setLastChgTime(currentTime);
			
			MasHospital hospital= new MasHospital();
			hospital.setId(hospitalId);
			opdInstructionTreatment.setHospital(hospital);
			
			successfullyAdded = opdMasterHandlerService.addOpdInstructionTreatment(opdInstructionTreatment);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}
			else{
				message="Try Again !!";
			}
		}

		else if((opdInstructionTreatmentCodeList.size() != 0 || opdInstructionTreatmentCodeList != null) || (opdInstructionTreatmentNameList.size() != 0) || opdInstructionTreatmentNameList != null)
		{
			if((opdInstructionTreatmentCodeList.size() != 0 || opdInstructionTreatmentCodeList != null) && (opdInstructionTreatmentNameList.size() == 0 || opdInstructionTreatmentNameList == null)){

				message = "OpdInstructionTreatment Code  already exists.";
			}
			else if((opdInstructionTreatmentNameList.size() != 0 || opdInstructionTreatmentNameList != null) && (opdInstructionTreatmentCodeList.size() == 0 || opdInstructionTreatmentCodeList == null) ){

				message = "OpdInstructionTreatment Name already exists.";
			}
			else if((opdInstructionTreatmentCodeList.size() != 0 || opdInstructionTreatmentCodeList != null) && (opdInstructionTreatmentNameList.size() != 0 || opdInstructionTreatmentNameList != null)){

				message = "OpdInstructionTreatment Code and OpdInstructionTreatment Name already exist.";
			}
		}
		
		try{
			map = opdMasterHandlerService.showOpdInstructionTreatmentJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=OPD_INSTRUCTION_TREATMENT_JSP;
		title="Add OPD OpdInstructionTreatment";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editOpdInstructionTreatment(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession(true);
		String opdInstructionTreatmentCode="";
		String opdInstructionTreatmentName="";
		int opdInstructionTreatmentId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			opdInstructionTreatmentId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			opdInstructionTreatmentCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			opdInstructionTreatmentName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", opdInstructionTreatmentId);
		generalMap.put("opdInstructionTreatmentCode", opdInstructionTreatmentCode);
		generalMap.put("name", opdInstructionTreatmentName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingOpdInstructionTreatmentNameList = (List)listMap.get("duplicateMastersList");
		  boolean dataUpdated=false;
		  if(existingOpdInstructionTreatmentNameList.size() == 0)
		  {
			  dataUpdated=opdMasterHandlerService.editOpdInstructionTreatmentToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}
		}
		  else if(existingOpdInstructionTreatmentNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/opdMaster?method=showOpdInstructionTreatmentJsp";
		
		try{
			map = opdMasterHandlerService.showOpdInstructionTreatmentJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=OPD_INSTRUCTION_TREATMENT_JSP;
		title="update OPD OpdInstructionTreatment";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteOpdInstructionTreatment(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int opdInstructionTreatmentId=0;
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
			opdInstructionTreatmentId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=opdMasterHandlerService.deleteOpdInstructionTreatment(opdInstructionTreatmentId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdInstructionTreatmentJsp";
		
		try{
			map = opdMasterHandlerService.showOpdInstructionTreatmentJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=OPD_INSTRUCTION_TREATMENT_JSP;
		title="delete OPD OpdInstructionTreatment";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	

	
	//****************************************** Start Of OPD Template Investigation  by Mansi****************************//

		
		@SuppressWarnings("unchecked")
		public ModelAndView addOpdTemplateInvestigation(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			OpdTemplateInvestigation opdTemplateInvestigation=new OpdTemplateInvestigation();
			
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			
			int departmentId =0;
			
			int chargeCodeId=0;
			int templateId=0;
			int templateInvestigationQty=0;
			String clinicalNotes="";
			if (request.getParameter(CLINICAL_NOTE) != null) {
				clinicalNotes = (request.getParameter(CLINICAL_NOTE));
			}
			if (request.getParameter(DEPARTMENT_ID) != null) {
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			}
			if (request.getParameter(TEMPLATE_ID) != null) {
				templateId = Integer.parseInt(request.getParameter(TEMPLATE_ID));
			}
			if (request.getParameter(CHARGE_CODE_ID) != null) {
				chargeCodeId = Integer.parseInt(request.getParameter(CHARGE_CODE_ID));
			}
		
			if (request.getParameter(QTY) != null) {
				templateInvestigationQty = Integer.parseInt(request.getParameter(QTY));
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
		/*	generalMap.put("code", code);
			generalMap.put("name", name);*/
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("hospitalId", hospitalId);
	/*		generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);*/

		//	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);

		//	List templateCodeList = new ArrayList();
		//	List templateNameList = new  ArrayList();

		/*	if(listMap.get("duplicateGeneralCodeList") != null){
				templateCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				templateNameList = (List)listMap.get("duplicateGeneralNameList");
			}
		*/	boolean successfullyAdded = false;

		/*	if((templateCodeList.size() == 0 || templateCodeList == null) && (templateNameList.size() == 0 || templateNameList == null))
			{
		*/	
				
				opdTemplateInvestigation.setClinicalNotes(clinicalNotes);
				
				opdTemplateInvestigation.setTemplateInvestigationQty(templateInvestigationQty);
				
						
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				opdTemplateInvestigation.setDepartment(masDepartment);
				
					
				OpdTemplate opdTemplate= new OpdTemplate();
				opdTemplate.setId(templateId);
				opdTemplateInvestigation.setTemplate(opdTemplate);
				
				MasChargeCode masChargeCode= new MasChargeCode();
				masChargeCode.setId(chargeCodeId);
				opdTemplateInvestigation.setChargeCode(masChargeCode);
				

				opdTemplateInvestigation.setStatus("y");
				opdTemplateInvestigation.setLastChgBy(changedBy);
				opdTemplateInvestigation.setLastChgDate(currentDate);
				opdTemplateInvestigation.setLastChgTime(currentTime);
				
				MasHospital hospital= new MasHospital();
				hospital.setId(hospitalId);
				opdTemplateInvestigation.setHospital(hospital);
				
				successfullyAdded = opdMasterHandlerService.addOpdTemplateInvestigation(opdTemplateInvestigation);		

				if(successfullyAdded){
					message="Record Added Successfully !!";
				}
				else{
					message="Try Again !!";
				}
				/*		}

		else if((templateCodeList.size() != 0 || templateCodeList != null) || (templateNameList.size() != 0) || templateNameList != null)
			{
				if((templateCodeList.size() != 0 || templateCodeList != null) && (templateNameList.size() == 0 || templateNameList == null)){

					message = "Template Code  already exists.";
				}
				else if((templateNameList.size() != 0 || templateNameList != null) && (templateCodeList.size() == 0 || templateCodeList == null) ){

					message = "Template Name already exists.";
				}
				else if((templateCodeList.size() != 0 || templateCodeList != null) && (templateNameList.size() != 0 || templateNameList != null)){

					message = "Template Code and Template Name already exist.";
				}
			}
			
	*/		try{
				map = opdMasterHandlerService.showOpdTemplateInvestigationJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OPD_INVESTIGATION_TEMPLATE_JSP;
			title="Add OPD Template Investigation";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		
		
		@SuppressWarnings("unchecked")
		public ModelAndView editOpdTemplateInvestigation(HttpServletRequest request, HttpServletResponse response) 
		{

			Map<String, Object>	map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();


			session=request.getSession(true);
			int departmentId =0;
			int templateId=0;
			int chargeCodeId=0;
			int templateInvestigationQty=0;
			String clinicalNotes="";
			int templateInvestigtaionId=0;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;

			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				templateInvestigtaionId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CLINICAL_NOTE) != null) {
				clinicalNotes = (request.getParameter(CLINICAL_NOTE));
			}
			if (request.getParameter(DEPARTMENT_ID) != null) {
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			}
			if (request.getParameter(TEMPLATE_ID) != null) {
				templateId = Integer.parseInt(request.getParameter(TEMPLATE_ID));
			}
			if (request.getParameter(CHARGE_CODE_ID) != null) {
				chargeCodeId = Integer.parseInt(request.getParameter(CHARGE_CODE_ID));
			}
			if (request.getParameter(QTY) != null) {
				templateInvestigationQty = Integer.parseInt(request.getParameter(QTY));
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

			generalMap.put("id", templateInvestigtaionId);
			generalMap.put("templateId", templateId);
			generalMap.put("departmentId", departmentId);
			generalMap.put("templateInvestigationQty", templateInvestigationQty);
			generalMap.put("clinicalNotes", clinicalNotes);
			generalMap.put("chargeCodeId", chargeCodeId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
	    	generalMap.put("flag", true);
			boolean dataUpdated=false;
			dataUpdated=opdMasterHandlerService.editOpdTemplateInvestigation(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			url = "/hms/hms/opdMaster?method=showOpdTemplateInvestigationJsp";
			
			try{
				map = opdMasterHandlerService.showOpdTemplateInvestigationJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OPD_INVESTIGATION_TEMPLATE_JSP;
			title="update OPD Template";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);

		}

		
		public ModelAndView deleteOpdTemplateInvestigation(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			int templateInvestigationId=0;
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
				templateInvestigationId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=opdMasterHandlerService.deleteOpdTemplateInvestigation(templateInvestigationId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}

			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/opdMaster?method=showOpdTemplateInvestigationJsp";
			
			try{
				map = opdMasterHandlerService.showOpdTemplateInvestigationJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OPD_INVESTIGATION_TEMPLATE_JSP;
			title="delete OPD OpdInstructionTreatment";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		
		@SuppressWarnings("unchecked")
		public ModelAndView showOpdTemplateInvestigationJsp(HttpServletRequest request,HttpServletResponse response)
		{

			Map<String,Object> map = new HashMap<String,Object>();
			map = opdMasterHandlerService.showOpdTemplateInvestigationJsp();
			
			String jsp=OPD_INVESTIGATION_TEMPLATE_JSP;
			jsp += ".jsp";
			
			title = "Standard Template Investigation";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB","map",map);
		}
		
		public ModelAndView getInvestigationTemplateGroup(HttpServletRequest request, HttpServletResponse response) {
			
			   Map<String ,Object> map =new HashMap<String, Object>();
			   
			   int templateId=Integer.parseInt(request.getParameter(TEMPLATE_ID));
			   int deptId=Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			   map=opdMasterHandlerService.getInvestigationTemplateGroup(templateId,deptId);
			   
			   String jsp=OPD_INVESTIGATION_TEMPLATE_DETAILS_JSP;
			 	
			   title = "Template Group Detail";
			   map.put("templateId", templateId);
			   map.put("deptId", deptId);  
			   map.put("contentJsp",jsp);
			   map.put("title", title);
			   return new ModelAndView(jsp, "map", map);
			

		
		}
		
		
		public ModelAndView getChargeCodeList(HttpServletRequest request,HttpServletResponse response) {

			
			int deptId = 0;
			HttpSession session = request.getSession();
			
			
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			
			String chargeCodeNameField = "";
			String autoHint = "";
			
		
			Map<String, Object> map = new HashMap<String, Object>();
			try {
				if (request.getParameter("requiredField") != null) {
					chargeCodeNameField = (request.getParameter("requiredField"));
				}
				if (request.getParameter(chargeCodeNameField) != null) {
					autoHint = (request.getParameter(chargeCodeNameField));
				}
				if (request.getParameter("labradiologyCheck") != null) {
					String labradiologyCheck=request.getParameter("labradiologyCheck");
					map.put("labradiologyCheck", labradiologyCheck);
				}
				map.put("deptId", deptId);
				map.put("userName", userName);
				map.put("autoHint", autoHint);
				map = opdMasterHandlerService.getChargeCodeList(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "responseInGridChargeCode";
			return new ModelAndView(jsp, "map", map);
		}
		@SuppressWarnings("unchecked")
		public void fillChargeCodeInGrid(HttpServletRequest request,HttpServletResponse response) {
			
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
			List<MasChargeCode> chargeCodeList= new ArrayList<MasChargeCode>();
			String chargeCodeCode = "";
		
			try {
				if (request.getParameter("chargeCodeCode") != null) {
					chargeCodeCode = request.getParameter("chargeCodeCode");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			dataMap.put("deptId", deptId);
			dataMap.put("chargeCodeCode", chargeCodeCode);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			map = opdMasterHandlerService.fillChargeCodeInGrid(dataMap);
			if (map.get("chargeCodeList") != null) {
				chargeCodeList = (List) map.get("chargeCodeList");
			}
			StringBuffer sb = new StringBuffer();
			try {
				for (MasChargeCode masChargeCode : chargeCodeList) {
					sb.append("<chargeCode>");
					sb.append("<id>" + masChargeCode.getId() + "</id>");
					sb.append("<chargeCodeCode>" + masChargeCode.getChargeCodeCode() + "</chargeCodeCode>");
					sb.append("</chargeCode>");
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
				response.getWriter().write("<chargeCodes>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</chargeCodes>");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
//****************************************** End Of OPD Template Investigation  by Mansi ****************************//
//------------------------------------Methods by Vishal---------------------------------------	
//-----------------------------------Equipment Master-----------------------------		
		public ModelAndView showOpdEquipmentJsp(HttpServletRequest request,HttpServletResponse response)
		{
			map = opdMasterHandlerService.showOpdEquipmentJsp();
			String jsp = EQUIPMENT_OPD_JSP;
			jsp += ".jsp";
			title = "Equipment";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB","map",map);
		}
		
		public ModelAndView searchOpdEquipment(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			
			Map<String, Object> map= new HashMap<String, Object>();		
			String equipmentCode  = null;
			String equipmentName = null;
			String searchField= null;
			
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				equipmentCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				equipmentName = request.getParameter(SEARCH_NAME);
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
				equipmentCode=searchField;
				equipmentName=null;

			}else{
				equipmentCode=null;
				equipmentName=searchField;
			}
			map = opdMasterHandlerService.searchOpdEquipment(equipmentCode, equipmentName);
			jsp=EQUIPMENT_OPD_JSP;
			jsp += ".jsp";
			map.put("search","search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("equipmentCode",equipmentCode);
			map.put("equipmentName",equipmentName);
			return new ModelAndView("indexB", "map", map);
						
		}
		
		@SuppressWarnings("unchecked")
		
		public ModelAndView addOpdEquipment(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			AppEquipmentMaster appEquipmentMaster = new AppEquipmentMaster();
			Map<String,Object> listMap=new HashMap<String,Object>();
			Integer noOfEquipment = null;
			int departmentId = 0;
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			
			if(request.getParameter(NO_OF_EQUIPMENT) != null ){
				noOfEquipment = Integer.parseInt(request.getParameter(NO_OF_EQUIPMENT));
			}
			if(request.getParameter(DEPARTMENT_ID) != null 
					&& !request.getParameter(DEPARTMENT_ID).equals("0")){
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
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
			generalMap.put("noOfEquipment", noOfEquipment);
			generalMap.put("departmentId", departmentId);
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);

			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);

			List equipmentCodeList = new ArrayList();
			List equipmentNameList = new  ArrayList();

			if(listMap.get("duplicateGeneralCodeList") != null){
				equipmentCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				equipmentNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if((equipmentCodeList.size() == 0 || equipmentCodeList == null) && (equipmentNameList.size() == 0 || equipmentNameList == null))
			{
				appEquipmentMaster.setEquipmentCode(code);
				appEquipmentMaster.setEquipmentName(name);
				appEquipmentMaster.setNoOfEquipments(noOfEquipment);
				if(departmentId != 0){
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(departmentId);
					appEquipmentMaster.setDepartment(masDepartment);
				}
				
				appEquipmentMaster.setEquipmentStatus("y");
				appEquipmentMaster.setLastChgBy(changedBy);
				appEquipmentMaster.setLastChgDate(currentDate);
				appEquipmentMaster.setLastChgTime(currentTime);

				
				
				/*int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appEquipmentMaster.setHospitalId(masHospital); */
				successfullyAdded = opdMasterHandlerService.addOpdEquipment(appEquipmentMaster);		

				if(successfullyAdded){
					message="Record Added Successfully !!";
				}
				else{
					message="Try Again !!";
				}
			}

			else if((equipmentCodeList.size() != 0 || equipmentCodeList != null) || (equipmentNameList.size() != 0) || equipmentNameList != null)
			{
				if((equipmentCodeList.size() != 0 || equipmentCodeList != null) && (equipmentNameList.size() == 0 || equipmentNameList == null)){

					message = "Equipment Code  already exists.";
				}
				else if((equipmentNameList.size() != 0 || equipmentNameList != null) && (equipmentCodeList.size() == 0 || equipmentCodeList == null) ){

					message = "Equipment Name already exists.";
				}
				else if((equipmentCodeList.size() != 0 || equipmentCodeList != null) && (equipmentNameList.size() != 0 || equipmentNameList != null)){

					message = "Equipment Code and Equipment Name already exist.";
				}
			}
			
			try{
				map = opdMasterHandlerService.showOpdEquipmentJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=EQUIPMENT_OPD_JSP;
			title="Add OPD Equipment";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		@SuppressWarnings("unchecked")
		public ModelAndView editOpdEquipment(HttpServletRequest request, HttpServletResponse response) 
		{

			Map<String, Object>	map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			session=request.getSession(true);
			String equipmentCode="";
			
			String equipmentName="";
			int equipmentId=0;
			int departmentId = 0;
			Integer noOfEquipment = null;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;

			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				equipmentId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				equipmentCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				equipmentName = request.getParameter(SEARCH_NAME);
			}
			if(request.getParameter(NO_OF_EQUIPMENT) != null && !(request.getParameter(NO_OF_EQUIPMENT).equals(""))){
				noOfEquipment = Integer.parseInt(request.getParameter(NO_OF_EQUIPMENT));
			}
			if(request.getParameter(DEPARTMENT_ID) != null 
					&& !request.getParameter(DEPARTMENT_ID).equals("0")){
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
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

			generalMap.put("id", equipmentId);
			generalMap.put("equipmentCode", equipmentCode);
			generalMap.put("name", equipmentName);
			generalMap.put("noOfEquipment", noOfEquipment);
			generalMap.put("departmentId", departmentId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	generalMap.put("flag", true);
			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			List existingEquipmentNameList = (List)listMap.get("duplicateMastersList");
			  boolean dataUpdated=false;
			  if(existingEquipmentNameList.size() == 0)
			  {
				  dataUpdated=opdMasterHandlerService.editOpdEquipmentToDatabase(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(existingEquipmentNameList.size() > 0){
				   message = "Name already exists.";
				  }
			url = "/hms/hms/opdMaster?method=showOpdEquipmentJsp";
			
			try{
				map = opdMasterHandlerService.showOpdEquipmentJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=EQUIPMENT_OPD_JSP;
			title="Update OPD Equipment";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);

		}

		public ModelAndView deleteOpdEquipment(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			int equipmentId=0;
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
				equipmentId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=opdMasterHandlerService.deleteOpdEquipment(equipmentId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}

			else{
			   message="Record is Activated successfully !!";
			}
			url = "/hms/hms/opdMaster?method=showOpdEquipmentJsp";
			
			try{
				map = opdMasterHandlerService.showOpdEquipmentJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=EQUIPMENT_OPD_JSP;
			title="delete OPD Equipment";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		
		public ModelAndView generateReportForOpdEquipment(HttpServletRequest request, HttpServletResponse response)
		{
			String jasper = null;
			int hospitalId = 0;
			String hospitalName = null;
					
			if (request.getParameter(JASPER_FILE_NAME)!=null)
			{
				jasper = request.getParameter(JASPER_FILE_NAME);
			}
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			parameters = opdMasterHandlerService.getConnection();
			HMSUtil.generateReport(jasper, parameters, (Connection)parameters.get("conn"), response, getServletContext());
			return new ModelAndView("indexB", "map", map);
		}
		// -----------------------------Vaccine master------------------------------
		@SuppressWarnings("unchecked")
		public ModelAndView showOpdVaccinJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			map = opdMasterHandlerService.showOpdVaccinJsp();
			String jsp = OPD_VACCIN_JSP;
			jsp += ".jsp";
			title = "Vaccin";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView searchOpdVaccin(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {

			Map<String, Object> map = new HashMap<String, Object>();
			String vaccinCode = null;
			String vaccinName = null;
			String searchField = null;

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				vaccinCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				vaccinName = request.getParameter(SEARCH_NAME);
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
				vaccinCode = searchField;
				vaccinName = null;

			} else {
				vaccinCode = null;
				vaccinName = searchField;
			}
			map = opdMasterHandlerService.searchOpdVaccin(vaccinCode, vaccinName);
			jsp = OPD_VACCIN_JSP;
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("vaccinCode", vaccinCode);
			map.put("vaccinName", vaccinName);
			return new ModelAndView("index", "map", map);

		}
		@SuppressWarnings("unchecked")
		public ModelAndView addOpdVaccin(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			OpdVaccinMst opdVaccin = new OpdVaccinMst();
			Map<String, Object> listMap = new HashMap<String, Object>();
			Integer vaccinDuration = null;
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String currentTime = (String) utilMap.get("currentTime");
			String vaccineName="";
			int masStoreItemId=0;
			int userId = 0;
			int dose=0;
			int maxDays=0;
			String type = null;
			int genderId=0;
			
			Box box=HMSUtil.getBox(request);
			session = request.getSession();
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt(""+ session.getAttribute("userId"));
			}
			if (request.getParameter("genderId") != null
					&& !(request.getParameter("genderId").equals("0"))) {
				genderId = Integer.parseInt(request.getParameter("genderId"));
			}
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if(request.getParameter("maxDays")!=null){
				maxDays=Integer.parseInt(request.getParameter("maxDays"));
			}
			if (request.getParameter(SEARCH_NAME) != null ) {
				vaccineName = request.getParameter(SEARCH_NAME);
				int index=0;
				int index1=vaccineName.indexOf("[");
				int index2=vaccineName.indexOf("]");
				name=vaccineName.substring(index, index1);
				masStoreItemId=Integer.parseInt(vaccineName.substring(index1+1, index2));
				
			}
			if (request.getParameter(VACCIN_DURATION) != null) {
				vaccinDuration = Integer.parseInt(request
						.getParameter(VACCIN_DURATION));
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
			
			// added by amit das on 05-08-2016
			if (request.getParameter("vaccineType") != null) {
				type = request.getParameter("vaccineType");
			}
			
			generalMap.put("box", box);
			generalMap.put("code", code);
			generalMap.put("id", 0);
			generalMap.put("name", name);
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);
			generalMap.put("masStoreItemId", masStoreItemId); 
			generalMap.put("maxDays",maxDays);
			generalMap.put("genderId",genderId);
			listMap = opdMasterHandlerService
					.checkExistingVaccineMaster(generalMap);

			List vaccinList = new ArrayList();
			
			if (listMap.get("duplicateMastersList") != null) {
				vaccinList = (List) listMap.get("duplicateMastersList");
			}
		System.out.println(vaccinList.size()+"-------------------");
			if(box.get("vaccineDose")!=null && !"select".equalsIgnoreCase(box.get("vaccineDose"))){
				dose=box.getInt("vaccineDose");
			}
			boolean successfullyAdded = false;

			if (vaccinList.size() == 0 || vaccinList == null) {
				opdVaccin.setVaccinCode(code);
				opdVaccin.setVaccinName(name);

				opdVaccin.setVaccinDuration(vaccinDuration);
				opdVaccin.setStatus("y");
				Users users = new Users();
				users.setId(userId);
				opdVaccin.setLastChgBy(users);
				opdVaccin.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				opdVaccin.setLastChgTime(currentTime);
				MasStoreItem item=new MasStoreItem(masStoreItemId);
				opdVaccin.setMasStoreItem(item);
				opdVaccin.setDose(dose);
				opdVaccin.setVaccinToDays(maxDays);
				opdVaccin.setVaccinType(type); // added by amit das on 05-08-2016
				
				MasAdministrativeSex gender=new MasAdministrativeSex();
				gender.setId(genderId);
				opdVaccin.setGender(gender);
				successfullyAdded = opdMasterHandlerService.addOpdVaccin(opdVaccin);

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			}
			else
			{
					message = "Vaccin Code ,Vaccin Name and Gender already exist.";
				}
			

			try {
				map = opdMasterHandlerService.showOpdVaccinJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = OPD_VACCIN_JSP;
			title = "Add OPD Vaccin";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView editOpdVaccin(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			session = request.getSession(true);
			String vaccinCode = "";
			String vaccinName = "";
			int vaccinId = 0;
			Integer vaccinDuration = null;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;
			String name="";
			int masStoreItemId=0;
			int userId = 0;
			String type = null; // added by amit das on 05-08-2016
			Box box=HMSUtil.getBox(request);
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt(""+ session.getAttribute("userId"));
			}
			int genderId=0;
			if (request.getParameter("genderId") != null
					&& !(request.getParameter("genderId").equals("0"))) {
				genderId = Integer.parseInt(request.getParameter("genderId"));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				vaccinId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				vaccinCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				name = request.getParameter(SEARCH_NAME);
				int index=0;
				int index1=name.indexOf("[");
				int index2=name.indexOf("]");
				if(index1!=-1 && index2!=-1){
					vaccinName=name.substring(index, index1);
					masStoreItemId=Integer.parseInt(name.substring(index1+1, index2));
				}else{
					vaccinName=name;
				}
				
			}
			if (request.getParameter(VACCIN_DURATION) != null
					&& !(request.getParameter(VACCIN_DURATION).equals(""))) {
				vaccinDuration = Integer.parseInt(request
						.getParameter(VACCIN_DURATION));
			}
			int maxDays=0;
			if (request.getParameter("maxDays") != null
					&& !(request.getParameter("maxDays").equals(""))) {
				maxDays = Integer.parseInt(request
						.getParameter("maxDays"));
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
			
			// added by amit das on 05-08-2016
			if (request.getParameter("vaccineType") != null) {
				type = request.getParameter("vaccineType");
			}
			
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			generalMap.put("box", box);
			generalMap.put("userId", userId);
			generalMap.put("id", vaccinId);
			generalMap.put("genderId", genderId);
			generalMap.put("code", vaccinCode);
			generalMap.put("name", vaccinName);
			generalMap.put("vaccinDuration", vaccinDuration);
			generalMap.put("maxDays", maxDays);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("masStoreItemId", masStoreItemId); 
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("flag", true);
			generalMap.put("type", type); // added by amit das on 05-08-2016
			
			listMap = opdMasterHandlerService.checkExistingVaccineMaster(generalMap);
			List existingVaccinNameList = (List) listMap.get("duplicateMastersList");

			boolean dataUpdated = false;
			if (existingVaccinNameList.size() == 0) {
				dataUpdated = opdMasterHandlerService
						.editOpdVaccinToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
			} else if (existingVaccinNameList.size() > 0) {
				message = "Vaccin Code ,Vaccin Name and Gender already exist.";
			}
			url = "/hms/hms/opdMaster?method=showOpdVaccinJsp";

			try {
				map = opdMasterHandlerService.showOpdVaccinJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = OPD_VACCIN_JSP;
			title = "Update OPD Vaccin";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}

		public ModelAndView deleteOpdVaccin(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			session = request.getSession();
			int vaccinId = 0;
			String message = null;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			int userId = 0;
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt(""+ session.getAttribute("userId"));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				vaccinId = Integer.parseInt(request.getParameter(COMMON_ID));
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

			generalMap.put("userId", userId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted = false;
			dataDeleted = opdMasterHandlerService.deleteOpdVaccin(vaccinId,
					generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/opdMaster?method=showOpdVaccinJsp";

			try {
				map = opdMasterHandlerService.showOpdVaccinJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = OPD_VACCIN_JSP;
			title = "delete OPD Vaccin";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView getVaccinationList(HttpServletRequest request,
				HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				int section = 0; 
				String itemNameField = "";
				int deptId = 0;
				String autoHint = "";
				if (request.getParameter("requiredField") != null) {
					itemNameField = (request.getParameter("requiredField"));
				}
				if (request.getParameter("search_name") != null) {
					autoHint = (request.getParameter("search_name"));
				}
				System.out.println("autoHint==== "+autoHint);
				Box box = HMSUtil.getBox(request); 
				map =opdMasterHandlerService.getVaccinationList(box);  
	 			String jsp = "listOfVaccine"; 
				return new ModelAndView(jsp, "map", map);
		}

		public ModelAndView generateReportForOpdVaccin(HttpServletRequest request,
				HttpServletResponse response) {
			String jasper = null;
			int hospitalId = 0;
			String hospitalName = null;

			if (request.getParameter(JASPER_FILE_NAME) != null) {
				jasper = request.getParameter(JASPER_FILE_NAME);
			}

			Map<String, Object> parameters = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			parameters = opdMasterHandlerService.getConnection();
			HMSUtil.generateReport(jasper, parameters,
					(Connection) parameters.get("conn"), response,
					getServletContext());
			return new ModelAndView("index", "map", map);
		}
		

		
		
		// -----------------------------Vaccine new  master------------------------------
		@SuppressWarnings("unchecked")
		public ModelAndView showOpdVaccinJsp1(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			map = opdMasterHandlerService.showNewOpdVaccinJsp();
			String jsp = "opdVaccineNew";
			jsp += ".jsp";
			title = "Vaccin";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView searchOpdVaccin1(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {

			Map<String, Object> map = new HashMap<String, Object>();
			String vaccinCode = null;
			String vaccinName = null;
			String searchField = null;

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				vaccinCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				vaccinName = request.getParameter(SEARCH_NAME);
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
				vaccinCode = searchField;
				vaccinName = null;

			} else {
				vaccinCode = null;
				vaccinName = searchField;
			}
			map = opdMasterHandlerService.searchOpdVaccin(vaccinCode, vaccinName);
			jsp = OPD_VACCIN_JSP;
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("vaccinCode", vaccinCode);
			map.put("vaccinName", vaccinName);
			return new ModelAndView("index", "map", map);

		}
		@SuppressWarnings("unchecked")
		public ModelAndView addOpdVaccin1(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			MasVaccineItem opdVaccin = new MasVaccineItem();
			Map<String, Object> listMap = new HashMap<String, Object>();
			Integer vaccinDuration = null;
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String currentTime = (String) utilMap.get("currentTime");
			String vaccineName="";
			//int masStoreItemId=0;
			int userId = 0;
			//int dose=0;
			//int maxDays=0;
			//String type = null;
			//int genderId=0;
			int orderNo =0;
			
			Box box=HMSUtil.getBox(request);
			System.out.println("daf="+box);
			session = request.getSession();
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt(""+ session.getAttribute("userId"));
			}
			/*if (request.getParameter("genderId") != null
					&& !(request.getParameter("genderId").equals("0"))) {
				genderId = Integer.parseInt(request.getParameter("genderId"));
			}*/
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			
			if (request.getParameter("orderNo") != null) {
				orderNo = Integer.parseInt(request.getParameter("orderNo"));
			}
		/*	if(request.getParameter("maxDays")!=null){
				maxDays=Integer.parseInt(request.getParameter("maxDays"));
			}*/
			if (request.getParameter(SEARCH_NAME) != null ) {
				vaccineName = request.getParameter(SEARCH_NAME);
				/*int index=0;
				int index1=vaccineName.indexOf("[");
				int index2=vaccineName.indexOf("]");
				name=vaccineName.substring(index, index1);
				masStoreItemId=Integer.parseInt(vaccineName.substring(index1+1, index2));*/
				
			}
			if (request.getParameter(VACCIN_DURATION) != null) {
				vaccinDuration = Integer.parseInt(request
						.getParameter(VACCIN_DURATION));
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
			
	/*		// added by amit das on 05-08-2016
			if (request.getParameter("vaccineType") != null) {
				type = request.getParameter("vaccineType");
			}*/
			
			generalMap.put("box", box);
			generalMap.put("code", code);
			generalMap.put("id", 0);
			//generalMap.put("name", name);
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			//generalMap.put("pojoPropertyName", pojoPropertyName);
			//generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);
			////generalMap.put("masStoreItemId", masStoreItemId); 
			//generalMap.put("maxDays",maxDays);
			generalMap.put("orderNo",orderNo);
			generalMap.put("vaccineName",vaccineName);
			
			
			listMap = opdMasterHandlerService
					.checkExistingVaccineNewMaster(generalMap);

			List vaccinList = new ArrayList();
			
			if (listMap.get("duplicateMastersList") != null) {
				vaccinList = (List) listMap.get("duplicateMastersList");
			}
/*		System.out.println(vaccinList.size()+"-------------------");
			if(box.get("vaccineDose")!=null && !"select".equalsIgnoreCase(box.get("vaccineDose"))){
				dose=box.getInt("vaccineDose");
			}*/
			boolean successfullyAdded = false;

			if (vaccinList.size() == 0 || vaccinList == null) {
				//opdVaccin.setVaccinCode(code);
				opdVaccin.setVaccineName(vaccineName);
				opdVaccin.setOrderNo(orderNo);
				System.out.println("Adad "+vaccineName +" adadad"+orderNo);
				//opdVaccin.setVaccinDuration(vaccinDuration);
				opdVaccin.setStatus("y");
				Users users = new Users();
				users.setId(userId);
				opdVaccin.setLastChgBy(users);
				opdVaccin.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				opdVaccin.setLastChgTime(currentTime);
				/*MasStoreItem item=new MasStoreItem(masStoreItemId);
				opdVaccin.setMasStoreItem(item);
				opdVaccin.setDose(dose);
				opdVaccin.setVaccinToDays(maxDays);
				opdVaccin.setVaccinType(type); // added by amit das on 05-08-2016
				
				MasAdministrativeSex gender=new MasAdministrativeSex();
				gender.setId(genderId);
				opdVaccin.setGender(gender);*/
				successfullyAdded = opdMasterHandlerService.addOpdVaccinNew(opdVaccin);

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			}
			else
			{
					message = "Vaccin Code ,Vaccin Name and Gender already exist.";
				}
			

			try {
				map = opdMasterHandlerService.showNewOpdVaccinJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			//jsp = OPD_VACCIN_JSP;
			jsp="opdVaccineNew";
			title = "Add OPD Vaccin";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView editOpdVaccin1(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			session = request.getSession(true);
			String vaccinCode = "";
			String vaccinName = "";
			int vaccinId = 0;
			Integer vaccinDuration = null;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;
			String name="";
			int masStoreItemId=0;
			int userId = 0;
			int orderNo=0;
			String type = null; // added by amit das on 05-08-2016
			Box box=HMSUtil.getBox(request);
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt(""+ session.getAttribute("userId"));
			}
			int genderId=0;
			if (request.getParameter("genderId") != null
					&& !(request.getParameter("genderId").equals("0"))) {
				genderId = Integer.parseInt(request.getParameter("genderId"));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				vaccinId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				vaccinCode = request.getParameter(CODE);
			}
			if (request.getParameter("orderNo") != null
					&& !(request.getParameter("orderNo").equals(""))) {
				orderNo = Integer.parseInt(request.getParameter("orderNo"));
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				vaccinName = request.getParameter(SEARCH_NAME);
				/*int index=0;
				int index1=name.indexOf("[");
				int index2=name.indexOf("]");
				if(index1!=-1 && index2!=-1){
					vaccinName=name.substring(index, index1);
					masStoreItemId=Integer.parseInt(name.substring(index1+1, index2));
				}else{
					vaccinName=name;
				}*/
				
			}
			if (request.getParameter(VACCIN_DURATION) != null
					&& !(request.getParameter(VACCIN_DURATION).equals(""))) {
				vaccinDuration = Integer.parseInt(request
						.getParameter(VACCIN_DURATION));
			}
			int maxDays=0;
			if (request.getParameter("maxDays") != null
					&& !(request.getParameter("maxDays").equals(""))) {
				maxDays = Integer.parseInt(request
						.getParameter("maxDays"));
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
			
			// added by amit das on 05-08-2016
			if (request.getParameter("vaccineType") != null) {
				type = request.getParameter("vaccineType");
			}
			
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			generalMap.put("box", box);
			generalMap.put("userId", userId);
			generalMap.put("id", vaccinId);
			generalMap.put("genderId", genderId);
			generalMap.put("code", vaccinCode);
			generalMap.put("vaccineName", vaccinName);
			generalMap.put("orderNo", orderNo);
			generalMap.put("vaccinDuration", vaccinDuration);
			generalMap.put("maxDays", maxDays);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("masStoreItemId", masStoreItemId); 
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("flag", true);
			generalMap.put("type", type); // added by amit das on 05-08-2016
			
			listMap = opdMasterHandlerService.checkExistingVaccineNewMaster(generalMap);
			List existingVaccinNameList = (List) listMap.get("duplicateMastersList");

			boolean dataUpdated = false;
			if (existingVaccinNameList.size() == 0) {
				dataUpdated = opdMasterHandlerService
						.editNewOpdVaccinToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
			} else if (existingVaccinNameList.size() > 0) {
				message = "Vaccin Code ,Vaccin Name and Gender already exist.";
			}
			url = "/hms/hms/opdMaster?method=showOpdVaccinJsp";

			try {
				map = opdMasterHandlerService.showNewOpdVaccinJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			//jsp = OPD_VACCIN_JSP;
			jsp = "opdVaccineNew";
			title = "Update OPD Vaccin";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}
		
		
		public ModelAndView deleteOpdVaccin1(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			session = request.getSession();
			int vaccinId = 0;
			String message = null;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			int userId = 0;
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt(""+ session.getAttribute("userId"));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				vaccinId = Integer.parseInt(request.getParameter(COMMON_ID));
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

			generalMap.put("userId", userId);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted = false;
			dataDeleted = opdMasterHandlerService.deleteNewOpdVaccin(vaccinId,
					generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/opdMaster?method=showOpdVaccinJsp";

			try {
				map = opdMasterHandlerService.showNewOpdVaccinJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "opdVaccineNew";
			title = "delete OPD Vaccin";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
//--------------------------------Methods Ended By Vishal--------------------------------------	
	
	
	
	
	
	
	
	
		//****************************************** Start Of OPD Frequency by Mansi ****************************//


		
		public ModelAndView searchOpdFrequency(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();		
			String opdFrequencyCode  = null;
			String opdFrequencyName = null;
			String searchField= null;

			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				opdFrequencyCode = request.getParameter(CODE);
			}

			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				opdFrequencyName = request.getParameter(SEARCH_NAME);
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
				opdFrequencyCode=searchField;
				opdFrequencyName=null;

			}else{
				opdFrequencyCode=null;
				opdFrequencyName=searchField;
			}
			map = opdMasterHandlerService.searchOpdFrequency(opdFrequencyCode, opdFrequencyName);

			jsp=OPD_FREQUENCY_JSP;

			jsp += ".jsp";
			
			map.put("search", "search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("opdFrequencyCode",opdFrequencyCode);
			map.put("opdFrequencyName",opdFrequencyName);
			return new ModelAndView("indexB", "map", map);
		}
		
		
		@SuppressWarnings("unchecked")
		public ModelAndView showOpdFrequencyJsp(HttpServletRequest request,HttpServletResponse response)
		{

			Map<String, Object> map = new HashMap<String, Object>();
			map = opdMasterHandlerService.showOpdFrequencyJsp();
			String jsp=OPD_FREQUENCY_JSP;
			jsp += ".jsp";
			title = "OpdFrequency";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB","map",map);
		}
		@SuppressWarnings("unchecked")
		public ModelAndView addOpdFrequency(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			MasOpdFrequency opdFrequency=new MasOpdFrequency();
			
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

			List opdFrequencyCodeList = new ArrayList();
			List opdFrequencyNameList = new  ArrayList();

			if(listMap.get("duplicateGeneralCodeList") != null){
				opdFrequencyCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				opdFrequencyNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if((opdFrequencyCodeList.size() == 0 || opdFrequencyCodeList == null) && (opdFrequencyNameList.size() == 0 || opdFrequencyNameList == null))
			{
				opdFrequency.setFrequencyCode(code);
				opdFrequency.setFrequencyName(name);
					
				opdFrequency.setStatus("y");
				opdFrequency.setLastChgBy(changedBy);
				opdFrequency.setLastChgDate(currentDate);
				opdFrequency.setLastChgTime(currentTime);
				successfullyAdded = opdMasterHandlerService.addOpdFrequency(opdFrequency);		

				if(successfullyAdded){
					message="Record Added Successfully !!";
				}
				else{
					message="Try Again !!";
				}
			}

			else if((opdFrequencyCodeList.size() != 0 || opdFrequencyCodeList != null) || (opdFrequencyNameList.size() != 0) || opdFrequencyNameList != null)
			{
				if((opdFrequencyCodeList.size() != 0 || opdFrequencyCodeList != null) && (opdFrequencyNameList.size() == 0 || opdFrequencyNameList == null)){

					message = "OpdFrequency Code  already exists.";
				}
				else if((opdFrequencyNameList.size() != 0 || opdFrequencyNameList != null) && (opdFrequencyCodeList.size() == 0 || opdFrequencyCodeList == null) ){

					message = "OpdFrequency Name already exists.";
				}
				else if((opdFrequencyCodeList.size() != 0 || opdFrequencyCodeList != null) && (opdFrequencyNameList.size() != 0 || opdFrequencyNameList != null)){

					message = "OpdFrequency Code and OpdFrequency Name already exist.";
				}
			}
			
			try{
				map = opdMasterHandlerService.showOpdFrequencyJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OPD_FREQUENCY_JSP;
			title="Add OPD OpdFrequency";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView editOpdFrequency(HttpServletRequest request, HttpServletResponse response) 
		{

			Map<String, Object>	map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			session=request.getSession(true);
			String opdFrequencyCode="";
			String opdFrequencyName="";
			int opdFrequencyId=0;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;

			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				opdFrequencyId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				opdFrequencyCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				opdFrequencyName = request.getParameter(SEARCH_NAME);
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

			generalMap.put("id", opdFrequencyId);
			generalMap.put("opdFrequencyCode", opdFrequencyCode);
			generalMap.put("name", opdFrequencyName);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	generalMap.put("flag", true);
			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			List existingOpdFrequencyNameList = (List)listMap.get("duplicateMastersList");
			  boolean dataUpdated=false;
			  if(existingOpdFrequencyNameList.size() == 0)
			  {
				  dataUpdated=opdMasterHandlerService.editOpdFrequencyToDatabase(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(existingOpdFrequencyNameList.size() > 0){
				   message = "Name already exists.";
				  }
			url = "/hms/hms/opdMaster?method=showOpdFrequencyJsp";
			
			try{
				map = opdMasterHandlerService.showOpdFrequencyJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OPD_FREQUENCY_JSP;
			title="update OPD OpdFrequency";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);

		}

		public ModelAndView deleteOpdFrequency(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			int opdFrequencyId=0;
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
				opdFrequencyId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=opdMasterHandlerService.deleteOpdFrequency(opdFrequencyId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}

			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/opdMaster?method=showOpdFrequencyJsp";
			
			try{
				map = opdMasterHandlerService.showOpdFrequencyJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OPD_FREQUENCY_JSP;
			title="delete OPD OpdFrequency";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		
		public ModelAndView showOpdPhysiotherapyTreatmentJsp(HttpServletRequest request,HttpServletResponse response)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map = opdMasterHandlerService.showOpdPhysiotherapyTreatmentJsp();
			String jsp = OPD_PHYSIOTHERAPY_TREATMENT_JSP;
			jsp += ".jsp";
			title = "OPD";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB","map",map);
		}
		public ModelAndView searchOpdPhysiotherapyTreatment(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();		
			String opdTreatmentCode  = null;
			String opdTreatmentName = null;
			String searchField= null;

			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				opdTreatmentCode = request.getParameter(CODE);
			}

			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				opdTreatmentName = request.getParameter(SEARCH_NAME);
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
				opdTreatmentCode=searchField;
				opdTreatmentName=null;

			}else{
				opdTreatmentCode=null;
				opdTreatmentName=searchField;
			}
			map = opdMasterHandlerService.searchOpdPhysiotherapyTreatment(opdTreatmentCode, opdTreatmentName);

			jsp=OPD_PHYSIOTHERAPY_TREATMENT_JSP;
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("opdTreatmentCode",opdTreatmentCode);
			map.put("opdTreatmentName",opdTreatmentName);
			return new ModelAndView("indexB", "map", map);
		}
		@SuppressWarnings("unchecked")
		public ModelAndView addOpdPhysiotherapyTreatment(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			MasPhysiotherapyTreatment masPhysiotherapyTreatment = new MasPhysiotherapyTreatment();
		
 			Map<String,Object> listMap=new HashMap<String,Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			int departmentId =0;
			String treatmentType="";
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter(DEPARTMENT_ID) != null) {
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
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

			List treatmentCodeList = new ArrayList();
			List treatmentNameList = new  ArrayList();

			if(listMap.get("duplicateGeneralCodeList") != null){
				treatmentCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				treatmentNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if((treatmentCodeList.size() == 0 || treatmentCodeList == null) 
					&& (treatmentNameList.size() == 0 || treatmentNameList == null))
			{
				masPhysiotherapyTreatment.setTreatmentCode(code);
				masPhysiotherapyTreatment.setTreatmentName(name);

				masPhysiotherapyTreatment.setStatus("y");
				masPhysiotherapyTreatment.setLastChgBy(changedBy);
				masPhysiotherapyTreatment.setLastChgDate(currentDate);
				masPhysiotherapyTreatment.setLastChgTime(currentTime);
				
				MasHospital hospital= new MasHospital();
				hospital.setId(hospitalId);
				masPhysiotherapyTreatment.setHospital(hospital);
				
				successfullyAdded = opdMasterHandlerService.addOpdPhysiotherapyTreatment(masPhysiotherapyTreatment);		

				if(successfullyAdded){
					message="Record Added Successfully !!";
				}
				else{
					message="Try Again !!";
				}
			}

			else if((treatmentCodeList.size() != 0 || treatmentCodeList != null) || (treatmentNameList.size() != 0) || treatmentNameList != null)
			{
				if((treatmentCodeList.size() != 0 || treatmentCodeList != null) && (treatmentNameList.size() == 0 || treatmentNameList == null)){

					message = "Template Code  already exists.";
				}
				else if((treatmentNameList.size() != 0 || treatmentNameList != null) && (treatmentCodeList.size() == 0 || treatmentCodeList == null) ){

					message = "Template Name already exists.";
				}
				else if((treatmentCodeList.size() != 0 || treatmentCodeList != null) && (treatmentNameList.size() != 0 || treatmentNameList != null)){

					message = "Template Code and Template Name already exist.";
				}
			}
			
			try{
				map = opdMasterHandlerService.showOpdPhysiotherapyTreatmentJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OPD_PHYSIOTHERAPY_TREATMENT_JSP;
			title="Add OPD Physiotherapy Treatment";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		@SuppressWarnings("unchecked")
		public ModelAndView editOpdPhysiotherapyTreatment(HttpServletRequest request, HttpServletResponse response) 
		{

			Map<String, Object>	map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			session=request.getSession(true);
			String treatmentCode="";
			String treatmentName="";
			int treatmentId=0;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;

			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				treatmentId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				treatmentCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				treatmentName = request.getParameter(SEARCH_NAME);
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

			generalMap.put("id", treatmentId);
			generalMap.put("treatmentCode", treatmentCode);
			generalMap.put("treatmentName", treatmentName);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	generalMap.put("flag", true);
			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			List existingTreatmentNameList = (List)listMap.get("duplicateMastersList");
			boolean dataUpdated=false;
			if(existingTreatmentNameList.size() == 0) {
				  dataUpdated=opdMasterHandlerService.editOpdPhysiotherapyTreatmentToDatabase(generalMap);
				if(dataUpdated==true){
					message="Data updated Successfully !!";
				}
				else{
					message="Data Cant Be Updated !!";
				}
			}else if(existingTreatmentNameList.size() > 0){
				   message = "Name already exists.";
			}
			url = "/hms/hms/opdMaster?method=showOpdPhysiotherapyTreatmentJsp";
			
			try{
				map = opdMasterHandlerService.showOpdPhysiotherapyTreatmentJsp();
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OPD_PHYSIOTHERAPY_TREATMENT_JSP;
			title="update OPD Physiotherapy Treatment";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		public ModelAndView deleteOpdPhysiotherapyTreatment(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			int treatmentId=0;
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
				treatmentId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=opdMasterHandlerService.deleteOpdPhysiotherapyTreatment(treatmentId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}

			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/opdMaster?method=showOpdPhysiotherapyTreatmentJsp";
			
			try{
				map = opdMasterHandlerService.showOpdPhysiotherapyTreatmentJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp=OPD_PHYSIOTHERAPY_TREATMENT_JSP;
			title="delete OPD Physiotherapy Treatment";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		public ModelAndView showAllergyTypeJsp(HttpServletRequest request ,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			map = opdMasterHandlerService.showAllergyTypeJsp();
			String jsp="allergy_type";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB","map",map);
		}
		public ModelAndView addAllergyType(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String,Object> map=new HashMap<String,Object>();
			MasAllergyType masAllergyType = new MasAllergyType();
			
			Map<String,Object> listMap=new HashMap<String,Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Users user = (Users) session.getAttribute("users");
			Integer userId = user.getId();
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

			List allergyTypeCodeList = new ArrayList();
			List allergyTypeNameList = new  ArrayList();

			if(listMap.get("duplicateGeneralCodeList") != null){
				allergyTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				allergyTypeNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if((allergyTypeCodeList.size() == 0 || allergyTypeCodeList == null) && (allergyTypeNameList.size() == 0 || allergyTypeNameList == null))
			{
				masAllergyType.setAllergyTypeCode(code);
				masAllergyType.setAllergyTypeName(name);
					
				masAllergyType.setStatus("y");
				Users users = new Users();
				users.setId(userId);
				masAllergyType.setLastChgBy(users);
				masAllergyType.setLastChgDate(currentDate);
				masAllergyType.setLastChgTime(currentTime);
				
				MasHospital hospital= new MasHospital();
				hospital.setId(hospitalId);
				masAllergyType.setHospital(hospital);
				
				successfullyAdded = opdMasterHandlerService.addAllergyType(masAllergyType);		

				if(successfullyAdded){
					message="Record Added Successfully !!";
				}
				else{
					message="Try Again !!";
				}
			}

			else if((allergyTypeCodeList.size() != 0 || allergyTypeCodeList != null) || (allergyTypeNameList.size() != 0) || allergyTypeNameList != null)
			{
				if((allergyTypeCodeList.size() != 0 || allergyTypeCodeList != null) && (allergyTypeNameList.size() == 0 || allergyTypeNameList == null)){

					message = "Allery Type Code  already exists.";
				}
				else if((allergyTypeNameList.size() != 0 || allergyTypeNameList != null) && (allergyTypeCodeList.size() == 0 || allergyTypeCodeList == null) ){

					message = "Allery Type Name already exists.";
				}
				else if((allergyTypeCodeList.size() != 0 || allergyTypeCodeList != null) && (allergyTypeNameList.size() != 0 || allergyTypeNameList != null)){

					message = "Allery Type Code and HolAllery Type  Name already exist.";
				}
			}
			
			try{
				map = opdMasterHandlerService.showAllergyTypeJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			jsp="allergy_type";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		
		  
		  public ModelAndView searchAllergyType(HttpServletRequest request,
					HttpServletResponse response) throws ServletRequestBindingException {
				Map<String, Object> map = new HashMap<String, Object>();
				String allergyTypeCode = null;
			    String allergyTypeName = null; 
				String searchField = null;

				if (request.getParameter(CODE) != null
						&& !(request.getParameter(CODE).equals(""))) {
					allergyTypeCode = request.getParameter(CODE);
				}
				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					allergyTypeName = request.getParameter(SEARCH_NAME);
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
					allergyTypeCode = searchField;
					allergyTypeName = null;
				} else {
					allergyTypeCode = null;
					allergyTypeName = searchField;
				}
				map = opdMasterHandlerService.searchAllergyType(allergyTypeCode,
						allergyTypeName);
				jsp = "allergy_type";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("search", "search");
				map.put("allergyTypeCode", allergyTypeCode);
				map.put("allergyTypeName", allergyTypeName);
				return new ModelAndView("index", "map", map);
			}
		  
		  public ModelAndView editAllergyType(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();
				HttpSession session = request.getSession();
			
				String allergyTypeCode="";
				String allergyTypeName="";
				int allergyTypeId=0;
				int userId = 0;
				Date changedDate = null;
				String changedTime = "";
				if (session.getAttribute("userId") != null){
					userId = Integer.parseInt(session.getAttribute("userId").toString());
				}
			
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					allergyTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
				}
			
				if (request.getParameter(CODE) != null
						&& !(request.getParameter(CODE).equals(""))) {
					allergyTypeCode = request.getParameter(CODE);
				}
				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					allergyTypeName = request.getParameter(SEARCH_NAME);
				}


				if (request.getParameter(CHANGED_TIME) != null
						&& !(request.getParameter(CHANGED_TIME).equals(""))) {
					currentTime = request.getParameter(CHANGED_TIME);
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
				changedTime = (String) HMSUtil.getCurrentDateAndTime().get(		"currentTime");
				generalMap.put("id", allergyTypeId);
				generalMap.put("allergyTypeCode", allergyTypeCode);
				generalMap.put("name", allergyTypeName);
				generalMap.put("changedBy", userId);
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
				Map<String, Object> listMap = new HashMap<String, Object>();
				generalMap.put("pojoPropertyName", pojoPropertyName);
				generalMap.put("pojoName", pojoName);
				generalMap.put("flag", true);

				listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
				List existingFamilyHistoryNameList = (List) listMap.get("duplicateMastersList");

				boolean dataUpdated = false;
				if (existingFamilyHistoryNameList.size() == 0) {

					dataUpdated = opdMasterHandlerService.editAllergyTypeToDatabase(generalMap);
System.out.println(dataUpdated+"dataUpdateddataUpdated");
					if (dataUpdated == true) {
						message = "Data updated Successfully !!";
					} else {
						message = "Data Cant Be Updated !!";
					}
				} else if (existingFamilyHistoryNameList.size() > 0) {

					message = "Name already exists.";
				}
				url = "/hms/hms/opdMaster?method=showAllergyTypeJsp";
				try {
					map = opdMasterHandlerService.showAllergyTypeJsp();
				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp="allergy_type";
			    title="Edit Family History";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("index", "map", map);

			}
		  
		  public ModelAndView deleteAllergyType(HttpServletRequest request, HttpServletResponse response) {
				 Map<String, Object> map = new HashMap<String, Object>();
				 Map<String, Object> generalMap = new HashMap<String, Object>();
				 int allergyTypeId=0;
				 String message=null;
				 int userId = 0;
				 String changedTime = "";
				 Date changedDate = null;
				 HttpSession session = request.getSession();
				 if (session.getAttribute("userId") != null){
						userId = Integer.parseInt(session.getAttribute("userId").toString());
					}
			  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				  allergyTypeId = Integer.parseInt( request.getParameter(COMMON_ID));
				  }
			  if(request.getParameter("title") != null){
				  title = request.getParameter("title");
				  } 
			
			  	changedDate= new Date();
				  changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			 
				  generalMap.put("changedBy", userId);
				  generalMap.put("currentDate",changedDate); 
				  generalMap.put("currentTime", changedTime);
				  boolean dataDeleted=false;
				  dataDeleted=opdMasterHandlerService.deleteAllergyType(allergyTypeId,generalMap);
				  if (dataDeleted==true) {
				   message="Record is InActivated successfully !!";
				   }else{ message="Record is Activated successfully !!";
				   } 
			   url = "/hms/hms/opdMaster?method=showAllergyTypeJsp";
			   try{
				   map = opdMasterHandlerService.showAllergyTypeJsp();
				   }catch (Exception e) {
			   }
				   jsp="allergy_type";
				   title="delete Allergy Type";
				   jsp += ".jsp";
				   map.put("contentJsp", jsp);
				   map.put("title", title);
				   map.put("message", message);
				   return new ModelAndView("index", "map", map); }
		public ModelAndView OpdDifferentialDisease(HttpServletRequest request, HttpServletResponse response){
			
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			parameterMap.put("date", date);
					
			jsp = "opdDifferentialDisease.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("indexB", "map", map);
			
		}
			
		public ModelAndView submitDifferentialDisease(HttpServletRequest request, HttpServletResponse response){
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
			boolean differentialDiseaseFlag = opdMasterHandlerService.submitDifferentialDisease(box);
			String message = "";
			if(differentialDiseaseFlag == true){
				message = " OPD Differential Disease has been added successfully.";
			
			}else{
				message = "Some Error Occurred. ";

			}
			jsp = "opdDifferentialDisease.jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			return new ModelAndView("indexB", "map", map);
			
		}		
		
		 //--------------------------------------Family History-------------------
		@SuppressWarnings("unchecked")
	   public ModelAndView showFamilyHistoryJsp(HttpServletRequest request,HttpServletResponse response) { 
			session = request.getSession();
			map = opdMasterHandlerService.showFamilyHistoryJsp();
			jsp ="familyHistory"; 
			jsp += ".jsp"; 
			title = "familyHistory";
		  map.put("contentJsp",jsp); 
		  map.put("title", title); 
		  return new ModelAndView("index", "map", map);
		  }

	  
	  public ModelAndView searchFamilyHistory(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String familyHistoryCode = null;
		    String familyHistoryName = null; 
			String searchField = null;

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				familyHistoryCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				familyHistoryName = request.getParameter(SEARCH_NAME);
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
				familyHistoryCode = searchField;
				familyHistoryName = null;
			} else {
				familyHistoryCode = null;
				familyHistoryName = searchField;
			}
			map = opdMasterHandlerService.searchFamilyHistory(familyHistoryCode,
					familyHistoryName);
			jsp = "familyHistory";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("search", "search");
			map.put("familyHistoryCode", familyHistoryCode);
			map.put("familyHistoryName", familyHistoryName);
			return new ModelAndView("index", "map", map);
		}
	 
	 
	  public ModelAndView addFamilyHistory(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			PatientFamilyHistory patientFamilyHistory=new PatientFamilyHistory();
			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			int userId = 0;
			int sectionId = 0;
			HttpSession session = request.getSession();
			if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}	
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			
			if (request.getParameter(SECTION_ID) != null
					&& !request.getParameter(SECTION_ID).equals("")) {
				sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
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
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);

			  List familyHistoryCodeList = new ArrayList();
			  List familyHistoryNameList = new ArrayList();
			if (listMap.get("duplicateGeneralCodeList") != null) {
				familyHistoryCodeList = (List) listMap.get("duplicateGeneralCodeList");
			}
			if (listMap.get("duplicateGeneralNameList") != null) {
				familyHistoryNameList = (List) listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			 if((familyHistoryCodeList.size() == 0 || familyHistoryCodeList == null) &&
					  (familyHistoryNameList.size() == 0 || familyHistoryNameList == null)) {
				 patientFamilyHistory.setPatientHistoryCode(code);
				 patientFamilyHistory.setPatientHistoryName(name);
					  Users users = new Users();
					  users.setId(userId);
					  patientFamilyHistory.setLastChgBy(users);
					  patientFamilyHistory.setStatus("y");
					  patientFamilyHistory.setLastChgDate(currentDate);
					  patientFamilyHistory.setTemplateCode("FH");
					  patientFamilyHistory.setLastChgTime(currentTime); 
					  successfullyAdded =  opdMasterHandlerService.addFamilyHistory(patientFamilyHistory);
				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			} else if ((familyHistoryCodeList.size() != 0 || familyHistoryCodeList != null)
					|| (familyHistoryNameList.size() != 0) || familyHistoryNameList != null) {
				if ((familyHistoryCodeList.size() != 0 || familyHistoryCodeList != null)
						&& (familyHistoryNameList.size() == 0 || familyHistoryNameList == null)) {
					message = "Family History Code already exists.";
				} else if ((familyHistoryNameList.size() != 0 || familyHistoryNameList != null)
						&& (familyHistoryCodeList.size() == 0 || familyHistoryCodeList == null)) {
					message = "Family History Name already exists.";
				} else if ((familyHistoryCodeList.size() != 0 || familyHistoryCodeList != null)
						&& (familyHistoryNameList.size() != 0 || familyHistoryNameList != null)) {
					message = "Family History Code and Family History Name already exist.";
				}
			}
			url = "/hms/hms/opdMaster?method=showFamilyHistoryJsp";
			try {
				map = opdMasterHandlerService.showFamilyHistoryJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "familyHistory";
			title = "Add Family History";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
	  
	  public ModelAndView editFamilyHistory(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
		
			String familyHistoryCode="";
			String familyHistoryName="";
			int familyHistoryId=0;
			int userId = 0;
			Date changedDate = null;
			String changedTime = "";
			if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
			 int sectionId = 0;
			  familyHistoryCode=(String )session.getAttribute("familyHistoryCode");
			  familyHistoryName=(String )session.getAttribute("familyHistoryName");

			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				familyHistoryId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
		
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				familyHistoryCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				familyHistoryName = request.getParameter(SEARCH_NAME);
			}


			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
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
			generalMap.put("id", familyHistoryId);
			generalMap.put("familyHistoryCode", familyHistoryCode);
			generalMap.put("name", familyHistoryName);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("flag", true);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingFamilyHistoryNameList = (List) listMap.get("duplicateMastersList");

			boolean dataUpdated = false;
			if (existingFamilyHistoryNameList.size() == 0) {

				dataUpdated = opdMasterHandlerService.editFamilyHistoryToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
			} else if (existingFamilyHistoryNameList.size() > 0) {

				message = "Name already exists.";
			}
			url = "/hms/hms/opdMaster?method=showFamilyHistoryJsp";
			try {
				map = opdMasterHandlerService.showFamilyHistoryJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp="familyHistory";
		    title="Edit Family History";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}
	 
	  public ModelAndView deleteFamilyHistory(HttpServletRequest request, HttpServletResponse response) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 Map<String, Object> generalMap = new HashMap<String, Object>();
		 int FamilyHistoryId=0;
		 String message=null;
		 int userId = 0;
		 String changedTime = "";
		 Date changedDate = null;
		 HttpSession session = request.getSession();
		 if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		  FamilyHistoryId = Integer.parseInt( request.getParameter(COMMON_ID));
		  }
	  if(request.getParameter("title") != null){
		  title = request.getParameter("title");
		  } 
	
	  	changedDate= new Date();
		  changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	 
		  generalMap.put("changedBy", userId);
		  generalMap.put("currentDate",changedDate); 
		  generalMap.put("currentTime", changedTime);
		  boolean dataDeleted=false;
		  dataDeleted=opdMasterHandlerService.deleteFamilyHistory(FamilyHistoryId,generalMap);
		  if (dataDeleted==true) {
		   message="Record is InActivated successfully !!";
		   }else{ message="Record is Activated successfully !!";
		   } 
	   url = "/hms/hms/opdMaster?method=showFamilyHistoryJsp";
	   try{
		   map = opdMasterHandlerService.showFamilyHistoryJsp();
		   }catch (Exception e) {
	   }
		   jsp="familyHistory";
		   title="delete Family History";
		   jsp += ".jsp";
		   map.put("contentJsp", jsp);
		   map.put("title", title);
		   map.put("message", message);
		   return new ModelAndView("index", "map", map); }
	  
	  //-----------
	// ------------------------------------------Unit
		// ----------------------------------

		public ModelAndView searchPresentComplaint(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String patientPresentComplaintName = null;

			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				patientPresentComplaintName = request.getParameter(SEARCH_FIELD);
			}
			map = opdMasterHandlerService.searchPresentComplaint(patientPresentComplaintName);
			jsp = "presentComplaint";
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("patientPresentComplaintName", patientPresentComplaintName);
			return new ModelAndView("indexB", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView showPresentComplaintJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map map = new HashMap();
			map = opdMasterHandlerService.showPresentComplaintJsp();
			// System.out.println("map  "+map.size());
			String jsp = "presentComplaint";
			jsp += ".jsp";
			title = "PresentComplaint";
			map.put("contentJsp", jsp);
			map.put("title", title);

			return new ModelAndView("indexB", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addPresentComplaint(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			PatientFamilyHistory patientFamilyHistory = new PatientFamilyHistory();
			
			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();

			int userId = 0;
			int deptId = 0;
			int departmentId = 0;
			 HttpSession session = request.getSession();
			 if (session.getAttribute("userId") != null){
					userId = Integer.parseInt(session.getAttribute("userId").toString());
				}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter("departmentId") != null) {
				deptId = Integer.parseInt(request.getParameter("departmentId"));
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
			if (request.getParameter("departmentId") != null) {
				departmentId = Integer.parseInt(request.getParameter("departmentId"));

			}
			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}

			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}

			generalMap.put("name", name);

			generalMap.put("currentDate", currentDate);
			generalMap.put("departmentId", departmentId);
			generalMap.put("currentTime", currentTime);

			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);

			/*listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);*/
			List unitNameList = new ArrayList();
		/*	if (listMap.get("duplicateGeneralNameList") != null) {
				unitNameList = (List) listMap.get("duplicateGeneralNameList");
			}*/
			boolean successfullyAdded = false;

			if ((unitNameList.size() == 0 || unitNameList == null)
					&& (unitNameList.size() == 0 || unitNameList == null)) {
				
				patientFamilyHistory.setPatientPresentComplaintName(name);

				patientFamilyHistory.setTemplateCode("CH");

				patientFamilyHistory.setStatus("y");
				  Users users = new Users();
				  users.setId(userId);
				  patientFamilyHistory.setDepartmentId(new MasDepartment(deptId));
				  patientFamilyHistory.setLastChgBy(users);
				patientFamilyHistory.setLastChgDate(currentDate);
				patientFamilyHistory.setLastChgTime(currentTime);
				successfullyAdded = opdMasterHandlerService.addPresentComplaint(patientFamilyHistory);

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			} else if ((unitNameList.size() != 0) || unitNameList != null) {
				if ((unitNameList.size() != 0 || unitNameList != null)) {
					message = "PresentComplaint Name already exists.";
				}
			}
			try {
				map = opdMasterHandlerService.showPresentComplaintJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "presentComplaint";
			title = "Add PresentComplaint";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView editPresentComplaint(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> listMap = new HashMap<String, Object>();
			PatientFamilyHistory patientFamilyHistory = new PatientFamilyHistory();
			session = request.getSession();
			String patientPresentComplaintName = "";
			int patientFamilyHistoryId = 0;
			Date changedDate = null;
			String changedTime = "";
			int deptId=0;
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				patientFamilyHistoryId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			
			if (request.getParameter("departmentId") != null) {
				deptId = Integer.parseInt(request.getParameter("departmentId"));
			}
		
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				patientPresentComplaintName = request.getParameter(SEARCH_NAME);
			}
			
			int userId = 0;
			 HttpSession session = request.getSession();
			 if (session.getAttribute("userId") != null){
					userId = Integer.parseInt(session.getAttribute("userId").toString());
				}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}
			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}
			if (request.getParameter("pojoName") != null) {
				pojoName = request.getParameter("pojoName");
			}
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("id", patientFamilyHistoryId);
			generalMap.put("name", patientPresentComplaintName);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("deptId", deptId);
			generalMap.put("departmentId", deptId);
			generalMap.put("flag", true);
System.out.println("unit "+deptId);
			/*listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingOccupationNameList = (List) listMap
					.get("duplicateMastersList");*/
List existingOccupationNameList = new ArrayList();
			boolean dataUpdated = false;
			if (existingOccupationNameList.size() == 0) {
				dataUpdated = opdMasterHandlerService.editPresentComplaintToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant be updated !!";
				}
			} else if (existingOccupationNameList.size() > 0) {
				message = "Name already exists.";
			}
			url = "/hms/hms/opdMater?method=showPresentComplaintJsp";

			try {
				map = opdMasterHandlerService.showPresentComplaintJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "presentComplaint";
			title = "update PresentComplaint";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView deletePresentComplaint(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			int patientFamilyHistoryId = 0;
			String message = null;
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			int userId = 0;
			 HttpSession session = request.getSession();
			 if (session.getAttribute("userId") != null){
					userId = Integer.parseInt(session.getAttribute("userId").toString());
				}
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				patientFamilyHistoryId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}
		
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted = false;
			dataDeleted = opdMasterHandlerService.deletePresentComplaint(patientFamilyHistoryId,
					generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/opdMaster?method=showPresentComplaintJsp";

			try {
				map = opdMasterHandlerService.showPresentComplaintJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "presentComplaint";
			title = "delete PresentComplaint";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		
		@SuppressWarnings("unchecked")
		public ModelAndView showOpdQuestionnaireJsp(HttpServletRequest request,HttpServletResponse response)
		{

			Map<String,Object> map = new HashMap<String,Object>();
			map = opdMasterHandlerService.showOpdQuestionnaireJsp();
			
			String jsp="opdQuestionnaire";
			jsp += ".jsp";
			
			title = "Opd Questionnaire";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB","map",map);
		}
		
		public ModelAndView addOpdQuestionnaire(HttpServletRequest request, HttpServletResponse response) {
			

			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			Date changedDate = null;
			String changedTime = "";
			int userId=0;
			int optionValue=0;
			int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
			if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
			box.put("userId",userId);
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				changedDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
				box.put("changedDate", changedDate);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				changedTime = request.getParameter(CHANGED_TIME);
				box.put("changedTime", changedTime);
			}
			if (request.getParameter("optionValue") != null
					&& !(request.getParameter("optionValue").equals("0"))) {
				optionValue =Integer.parseInt( request.getParameter("optionValue"));
				box.put("optionValue", optionValue);
			}
			map = opdMasterHandlerService.addOpdQuestionnaire(box);
			
		
			String message = "";
			if (map.get("message") != null) {
				message = (String) map.get("message");
			}

			map = opdMasterHandlerService.showOpdQuestionnaireJsp();
			map.put("message", message);
			map.put("search", "NA");
			String jsp = "opdQuestionnaire";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("indexB","map",map);
						

		
		}
		
		public ModelAndView updateOpdQuestionnaire(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			Date changedDate = null;
			String changedTime = "";
			int userId=0;
			int optionValue=0;
			int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
			if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
			box.put("userId",userId);
			
			if (request.getParameter("optionValue") != null
					&& !(request.getParameter("optionValue").equals("0"))) {
				optionValue =Integer.parseInt( request.getParameter("optionValue"));
				box.put("optionValue", optionValue);
			}
			System.out.println(optionValue);
			
			
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				changedDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
				box.put("changedDate", changedDate);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				changedTime = request.getParameter(CHANGED_TIME);
				box.put("changedTime", changedTime);
			}
			
			map = opdMasterHandlerService.updateOpdQuestionnaire(box);
			
		
			String message = "";
			if (map.get("message") != null) {
				message = (String) map.get("message");
			}

			map = opdMasterHandlerService.showOpdQuestionnaireJsp();
			map.put("message", message);
			map.put("search", "NA");
			String jsp = "opdQuestionnaire";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("indexB","map",map);
						

		
		}
		public ModelAndView deleteOpdQuestionnaire(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int opdQuestionId=0;
			String message=null;
			String changedTime = "";
			Date changedDate = null;
			String flag ="";
					int userId=0; 
			if(request.getParameter("flag") != null){
				flag = request.getParameter("flag"); 
				generalMap.put("flag", flag);
			}
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				opdQuestionId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
			generalMap.put("userId",userId);

			changedDate= new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted=false;
			dataDeleted=opdMasterHandlerService.deleteOpdQuestionnaire(opdQuestionId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}

			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/opdMaster?method=showOpdQuestionnaireJsp";
			
			try{
				map = opdMasterHandlerService.showOpdQuestionnaireJsp();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			String jsp = "opdQuestionnaire";
			title="delete OPD Questionnaire";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("search", "NA");
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		public ModelAndView searchOpdQuestionnaire(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();		
			int questionIdSearch   = 0;
			String searchField= null;

			if(request.getParameter("questionIdSearch") != null && !(request.getParameter("questionIdSearch").equals("0"))){
				questionIdSearch = Integer.parseInt(request.getParameter("questionIdSearch"));
			}

			map = opdMasterHandlerService.searchOpdQuestionnaire(questionIdSearch);

			String jsp = "opdQuestionnaire.jsp";
		
			
			map.put("search", "search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);
		}
		

//		----------------------------- Question Heading----------------------------------------
		@SuppressWarnings("unchecked")
		public ModelAndView showQuestionHeadingJsp(HttpServletRequest request,HttpServletResponse response)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			map = opdMasterHandlerService.showQuestionHeadingJsp();
			jsp = "questionHeading";
			jsp+= ".jsp" ;
			title = "QuestionHeading";
			map.put("contentJsp",jsp);
			map.put("title", title);

			return new ModelAndView("indexB", "map", map);		 
		}

		public ModelAndView searchQuestionHeading(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();  
			String questionHeadingCode  = null;
			String questionHeadingName = null;
			String searchField= null;

			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				questionHeadingCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				questionHeadingName = request.getParameter(SEARCH_NAME);
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
				questionHeadingCode=searchField;
				questionHeadingName=null;

			}else{
				questionHeadingCode=null;
				questionHeadingName=searchField;
			}

			map = opdMasterHandlerService.searchQuestionHeading(questionHeadingCode, questionHeadingName);

			jsp="questionHeading";
			jsp += ".jsp";
			map.put("search","search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("questionHeadingCode",questionHeadingCode);
			map.put("questionHeadingName",questionHeadingName);
			return new ModelAndView("indexB", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addQuestionHeading(HttpServletRequest request, HttpServletResponse response) 
		{

			Map<String,Object> map=new HashMap<String,Object>();
			MasQuestionHeading masQuestionHeading=new MasQuestionHeading();
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
			List questionHeadingCodeList = new ArrayList();
			List questionHeadingNameList = new  ArrayList();

			if(listMap.get("duplicateGeneralCodeList") != null){
				questionHeadingCodeList = (List)listMap.get("duplicateGeneralCodeList");
			}
			if(listMap.get("duplicateGeneralNameList") != null){
				questionHeadingNameList = (List)listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;
			if((questionHeadingCodeList.size() == 0 || questionHeadingCodeList == null) && (questionHeadingNameList.size() == 0 || questionHeadingNameList == null))
			{
				masQuestionHeading.setQuestionHeadingCode(code);
				masQuestionHeading.setQuestionHeadingName(name);
				masQuestionHeading.setStatus("y");
				masQuestionHeading.setLastChgBy(changedBy);
				masQuestionHeading.setLastChgDate(currentDate);
				masQuestionHeading.setLastChgTime(currentTime);
				successfullyAdded = opdMasterHandlerService.addQuestionHeading(masQuestionHeading);  

				if(successfullyAdded)
				{
					message="Record Added Successfully !!";
				}
				else
				{
					message="Try Again !!";
				}		
			}

			else if((questionHeadingCodeList.size() != 0 || questionHeadingCodeList != null) || (questionHeadingNameList.size() != 0) || questionHeadingNameList != null)
			{
				if((questionHeadingCodeList.size() != 0 || questionHeadingCodeList != null) && (questionHeadingNameList.size() == 0 || questionHeadingNameList == null)){
					message = "Question Heading Code  already exists.";
				}
				else if((questionHeadingNameList.size() != 0 || questionHeadingNameList != null) && (questionHeadingCodeList.size() == 0 || questionHeadingCodeList == null) ){
					message = "Question Heading Name already exists.";	   }
				else if((questionHeadingCodeList.size() != 0 || questionHeadingCodeList != null) && (questionHeadingNameList.size() != 0 || questionHeadingNameList != null)){
					message = "Question Heading Code and Question Heading Name already exist.";
				}
			}

			url = "/hms/hms/opdMaster?method=showQuestionHeadingJsp";
			 try{
			   map = opdMasterHandlerService.showQuestionHeadingJsp();
			    }catch (Exception e) {
			     //System.out.println("Exception in showQuestionHeadingJsp "+e);
			    }
			    jsp="questionHeading";
			    title="Add Question Heading";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView editQuestionHeading(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			session=request.getSession();
			String questionHeadingCode="";
			String questionHeadingName="";
			int questionHeadingId=0;
			String changedBy = "";
			Date changedDate = null;
			Date currentDate = null;
			String changedTime = "";

			
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				questionHeadingId =Integer.parseInt( request.getParameter(COMMON_ID));
			}
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				questionHeadingCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				questionHeadingName = request.getParameter(SEARCH_NAME);
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

			generalMap.put("id", questionHeadingId);
			generalMap.put("questionHeadingCode", questionHeadingCode);
			generalMap.put("name", questionHeadingName);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	    	generalMap.put("flag", true);
			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			List existingQuestionHeadingNameList = (List)listMap.get("duplicateMastersList");
			  boolean dataUpdated=false;
			  if(existingQuestionHeadingNameList.size() == 0)
			  {
				  dataUpdated=opdMasterHandlerService.editQuestionHeadingToDatabase(generalMap);

			if(dataUpdated==true){
				message="Data updated Successfully !!";
			}
			else{
				message="Data Cant Be Updated !!";
			}
			}
			  else if(existingQuestionHeadingNameList.size() > 0){
				   message = "Name already exists.";
				  }
			url = "/hms/hms/opdMaster?method=showQuestionHeadingJsp";
			try{
				   map = opdMasterHandlerService.showQuestionHeadingJsp();
				    }catch (Exception e) {
				     //System.out.println("Exception in showQuestionHeadingJsp "+e);
				    }
				    jsp="questionHeading";
				    title="Update Question Heading";
				    jsp += ".jsp";			    
				    map.put("contentJsp", jsp);
				    map.put("title", title);
				    map.put("message", message);
				    return new ModelAndView("indexB", "map", map);
		}
		
		public ModelAndView deleteQuestionHeading(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			int questionHeadingId=0;
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
				questionHeadingId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=opdMasterHandlerService.deleteQuestionHeading(questionHeadingId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}
			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/opdMaster?method=showQuestionHeadingJsp";
			try{
				   map = opdMasterHandlerService.showQuestionHeadingJsp();
				    }catch (Exception e) {
				     //System.out.println("Exception in showQuestionHeadingJsp "+e);
				    }
				    jsp="questionHeading";
				    title="Delete Question Heading";
				    jsp += ".jsp";			    
				    map.put("contentJsp", jsp);
				    map.put("title", title);
				    map.put("message", message);
				    return new ModelAndView("indexB", "map", map);
			}
		

//		----------------------------- Admission Type----------------------------------------
		
		@SuppressWarnings("unchecked")
		public ModelAndView showQaOptionValueJsp(HttpServletRequest request,HttpServletResponse response)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			map = opdMasterHandlerService.showQaOptionValueJsp();
			jsp = "qaOptionValue";
			jsp+= ".jsp" ;
			title = "QaOptionValue";
			map.put("contentJsp",jsp);
			map.put("title", title);

			return new ModelAndView("indexB", "map", map);		 
		}


		
		public ModelAndView addQaOptionValue(HttpServletRequest request, HttpServletResponse response) {
			

			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			Date changedDate = null;
			String changedTime = "";
			int userId=0;
			int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
			if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
			box.put("userId",userId);
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				changedDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
				box.put("changedDate", changedDate);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				changedTime = request.getParameter(CHANGED_TIME);
				box.put("changedTime", changedTime);
			}
		
			map = opdMasterHandlerService.addQaOptionValue(box);
			
		
			String message = "";
			if (map.get("message") != null) {
				message = (String) map.get("message");
			}

			map = opdMasterHandlerService.showQaOptionValueJsp();
			map.put("message", message);
			map.put("search", "NA");
			String jsp = "qaOptionValue";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("indexB","map",map);
						

		
		}
		
		public ModelAndView editQaOptionValue(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			Date changedDate = null;
			String changedTime = "";
			int userId=0;
		
			int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
			if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
			box.put("userId",userId);
	
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				changedDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
				box.put("changedDate", changedDate);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				changedTime = request.getParameter(CHANGED_TIME);
				box.put("changedTime", changedTime);
			}
			
			map = opdMasterHandlerService.editQaOptionValueToDatabase(box);
			
		
			String message = "";
			if (map.get("message") != null) {
				message = (String) map.get("message");
			}

			map = opdMasterHandlerService.showQaOptionValueJsp();
			map.put("message", message);
			map.put("search", "NA");
			String jsp = "qaOptionValue";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("indexB","map",map);
						

		
		}
	

		public ModelAndView searchQaOptionValue(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
		{
			Map<String, Object> map= new HashMap<String, Object>();  
			Box box = HMSUtil.getBox(request);
			String qaOptionValueCode  = null;
			String qaOptionValueName = null;
			String searchField= null;

			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				qaOptionValueCode = request.getParameter(CODE);
			}
			if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
				qaOptionValueName = request.getParameter(SEARCH_NAME);
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
				qaOptionValueCode=searchField;
				qaOptionValueName=null;

			}else{
				qaOptionValueCode=null;
				qaOptionValueName=searchField;
			}
			map = opdMasterHandlerService.showQaOptionValueJsp();
			/*map.putAll(opdMasterHandlerService.searchQaOptionValue(qaOptionValueCode, qaOptionValueName));*/
			map.putAll(opdMasterHandlerService.searchQaOptions(box));
			 

			jsp="qaOptionValue";
			jsp += ".jsp";
			map.put("search","search");
			map.put("contentJsp",jsp);
			map.put("title", title);
			map.put("qaOptionValueCode",qaOptionValueCode);
			map.put("qaOptionValueName",qaOptionValueName);
			return new ModelAndView("indexB", "map", map);
		}

		
		public ModelAndView deleteQaOptionValue(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();	
			int qaOptionValueId=0;
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
				qaOptionValueId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=opdMasterHandlerService.deleteQaOptionValue(qaOptionValueId,generalMap);
			if (dataDeleted==true)
			{
				message="Record is InActivated successfully !!";
			}
			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/opdMaster?method=showQaOptionValueJsp";
			try{
				   map = opdMasterHandlerService.showQaOptionValueJsp();
				    }catch (Exception e) {
				     //System.out.println("Exception in showQaOptionValueJsp "+e);
				    }
				    jsp="qaOptionValue";
				    title="Delete Admission Type";
				    jsp += ".jsp";			    
				    map.put("contentJsp", jsp);
				    map.put("title", title);
				    map.put("message", message);
				    return new ModelAndView("indexB", "map", map);
			}
		
		
		public ModelAndView generateReportForOpdQuestionnaire(HttpServletRequest request,
				HttpServletResponse response) {
			String jasper = null;
			int hospitalId = 0;
			String hospitalName = null;
			String qry="";
			int questionIdSearch=0;

			if (request.getParameter(JASPER_FILE_NAME) != null) {
				jasper = request.getParameter(JASPER_FILE_NAME);
			}
			if(request.getParameter("questionIdSearch") != null && !(request.getParameter("questionIdSearch").equals("0"))){
				questionIdSearch = Integer.parseInt(request.getParameter("questionIdSearch"));
				qry="where qm.question_heading_id= "+questionIdSearch;
			}

			Map<String, Object> parameters = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			parameters = opdMasterHandlerService.getConnection();
			String userHome = getServletContext().getRealPath("");
			String imagePath = userHome + "/jsp/images/logonew-hal.jpg";
			parameters.put("path", imagePath);


			parameters.put("qry", qry);
			HMSUtil.generateReport(jasper, parameters,
					(Connection) parameters.get("conn"), response,
					getServletContext());
			return new ModelAndView("index", "map", map);
		}
		

		 //--------------------------------------Family History-------------------
		@SuppressWarnings("unchecked")
	   public ModelAndView showTreatmentAdviceJsp(HttpServletRequest request,HttpServletResponse response) { 
			session = request.getSession();
			map = opdMasterHandlerService.showTreatmentAdviceJsp();
			jsp ="treatmentAdvice"; 
			jsp += ".jsp"; 
			title = "treatmentAdvice";
		  map.put("contentJsp",jsp); 
		  map.put("title", title); 
		  return new ModelAndView("index", "map", map);
		  }

	  
	  public ModelAndView searchTreatmentAdvice(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String patientPresentComplaintName = null;

			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				patientPresentComplaintName = request.getParameter(SEARCH_FIELD);
			}
			map = opdMasterHandlerService.searchTreatmentAdvice(patientPresentComplaintName);
			jsp = "treatmentAdvice";
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("patientPresentComplaintName", patientPresentComplaintName);
			return new ModelAndView("indexB", "map", map);
		}
	 
	 
	  public ModelAndView addTreatmentAdvice(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			PatientFamilyHistory patientFamilyHistory = new PatientFamilyHistory();
			
			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();

			int userId = 0;
			int deptId = 0;
			int departmentId = 0;
			 HttpSession session = request.getSession();
			 if (session.getAttribute("userId") != null){
					userId = Integer.parseInt(session.getAttribute("userId").toString());
				}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter("departmentId") != null) {
				deptId = Integer.parseInt(request.getParameter("departmentId"));
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
			if (request.getParameter("departmentId") != null) {
				departmentId = Integer.parseInt(request.getParameter("departmentId"));

			}
			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}

			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}

			generalMap.put("name", name);

			generalMap.put("currentDate", currentDate);
			generalMap.put("departmentId", departmentId);
			generalMap.put("currentTime", currentTime);

			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);

			/*listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);*/
			List unitNameList = new ArrayList();
		/*	if (listMap.get("duplicateGeneralNameList") != null) {
				unitNameList = (List) listMap.get("duplicateGeneralNameList");
			}*/
			boolean successfullyAdded = false;

			if ((unitNameList.size() == 0 || unitNameList == null)
					&& (unitNameList.size() == 0 || unitNameList == null)) {
				
				patientFamilyHistory.setPatientPresentComplaintName(name);

				patientFamilyHistory.setTemplateCode("TA");

				patientFamilyHistory.setStatus("y");
				  Users users = new Users();
				  users.setId(userId);
				  patientFamilyHistory.setDepartmentId(new MasDepartment(deptId));
				  patientFamilyHistory.setLastChgBy(users);
				patientFamilyHistory.setLastChgDate(currentDate);
				patientFamilyHistory.setLastChgTime(currentTime);
				successfullyAdded = opdMasterHandlerService.addTreatmentAdvice(patientFamilyHistory);

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			} else if ((unitNameList.size() != 0) || unitNameList != null) {
				if ((unitNameList.size() != 0 || unitNameList != null)) {
					message = "PresentComplaint Name already exists.";
				}
			}
			try {
				map = opdMasterHandlerService.showTreatmentAdviceJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "treatmentAdvice";
			title = "Add PresentComplaint";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
	  
	  public ModelAndView editTreatmentAdvice(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> listMap = new HashMap<String, Object>();
			PatientFamilyHistory patientFamilyHistory = new PatientFamilyHistory();
			session = request.getSession();
			String patientPresentComplaintName = "";
			int patientFamilyHistoryId = 0;
			Date changedDate = null;
			String changedTime = "";
			int deptId=0;
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				patientFamilyHistoryId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			
			if (request.getParameter("departmentId") != null) {
				deptId = Integer.parseInt(request.getParameter("departmentId"));
			}
		
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				patientPresentComplaintName = request.getParameter(SEARCH_NAME);
			}
			
			int userId = 0;
			 HttpSession session = request.getSession();
			 if (session.getAttribute("userId") != null){
					userId = Integer.parseInt(session.getAttribute("userId").toString());
				}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}
			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}
			if (request.getParameter("pojoName") != null) {
				pojoName = request.getParameter("pojoName");
			}
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("id", patientFamilyHistoryId);
			generalMap.put("name", patientPresentComplaintName);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("deptId", deptId);
			generalMap.put("departmentId", deptId);
			generalMap.put("flag", true);
System.out.println("unit "+deptId);
			/*listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingOccupationNameList = (List) listMap
					.get("duplicateMastersList");*/
List existingOccupationNameList = new ArrayList();
			boolean dataUpdated = false;
			if (existingOccupationNameList.size() == 0) {
				dataUpdated = opdMasterHandlerService.editTreatmentAdviceToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant be updated !!";
				}
			} else if (existingOccupationNameList.size() > 0) {
				message = "Name already exists.";
			}
			url = "/hms/hms/opdMater?method=showTreatmentAdviceJsp";

			try {
				map = opdMasterHandlerService.showTreatmentAdviceJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "treatmentAdvice";
			title = "update PresentComplaint";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
	 
	  public ModelAndView deleteTreatmentAdvice(HttpServletRequest request, HttpServletResponse response) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 Map<String, Object> generalMap = new HashMap<String, Object>();
		 int TreatmentAdviceId=0;
		 String message=null;
		 int userId = 0;
		 String changedTime = "";
		 Date changedDate = null;
		 HttpSession session = request.getSession();
		 if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		  TreatmentAdviceId = Integer.parseInt( request.getParameter(COMMON_ID));
		  }
	  if(request.getParameter("title") != null){
		  title = request.getParameter("title");
		  } 

	  	changedDate= new Date();
		  changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	 
		  generalMap.put("changedBy", userId);
		  generalMap.put("currentDate",changedDate); 
		  generalMap.put("currentTime", changedTime);
		  boolean dataDeleted=false;
		  dataDeleted=opdMasterHandlerService.deleteTreatmentAdvice(TreatmentAdviceId,generalMap);
		  if (dataDeleted==true) {
		   message="Record is InActivated successfully !!";
		   }else{ message="Record is Activated successfully !!";
		   } 
	   url = "/hms/hms/opdMaster?method=showTreatmentAdviceJsp";
	   try{
		   map = opdMasterHandlerService.showTreatmentAdviceJsp();
		   }catch (Exception e) {
	   }
		   jsp="treatmentAdvice";
		   title="delete Treatment Advice";
		   jsp += ".jsp";
		   map.put("contentJsp", jsp);
		   map.put("title", title);
		   map.put("message", message);
		   return new ModelAndView("index", "map", map); }		
	  
	  
	  
	public OPDMasterHandlerService getOpdMasterHandlerService() {
		return opdMasterHandlerService;
	}
	public void setOpdMasterHandlerService(
			OPDMasterHandlerService opdMasterHandlerService) {
		this.opdMasterHandlerService = opdMasterHandlerService;
	}
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}
	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	
	
}
