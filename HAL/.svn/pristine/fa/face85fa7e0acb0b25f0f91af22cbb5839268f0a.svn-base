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

import jkt.hms.masters.business.DgCollectionCenter;
import jkt.hms.masters.business.DgMasCollection;
import jkt.hms.masters.business.DgMasOrganism;
import jkt.hms.masters.business.DgMasOrganismGroup;
import jkt.hms.masters.business.DgOrgDtl;
import jkt.hms.masters.business.DgOrgGrpDtl;
import jkt.hms.masters.business.DgUom;
import jkt.hms.masters.business.MasAntibioticLab;
import jkt.hms.masters.business.MasBiopsyLab;
import jkt.hms.masters.business.MasDiagnosisConclusion;
import jkt.hms.masters.business.DgMasOrganismGroup;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasParameter;
import jkt.hms.masters.business.MasSample;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.LaboratoryMasterHandlerService;
import jkt.hms.util.HMSUtil;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class LaboratoryMasterController extends MultiActionController{
	
	LaboratoryMasterHandlerService laboratoryMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
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
	String currentTime="";		
	
//-----------------------------------Diagnosis------------------------------------------
	public ModelAndView searchDiagnosisConclusion(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String diagnosisConclusionCode  = null;
		String diagnosisConclusionName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			diagnosisConclusionCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			diagnosisConclusionName = request.getParameter(SEARCH_NAME);
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
			diagnosisConclusionCode=searchField;
			diagnosisConclusionName=null;			
		}else{
			diagnosisConclusionCode=null;
			diagnosisConclusionName=searchField;
		}		
		map = laboratoryMasterHandlerService.searchDiagnosisConclusion(diagnosisConclusionCode, diagnosisConclusionName);
		jsp=DIAGNOSIS_CONCLUSION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("diagnosisConclusionCode",diagnosisConclusionCode);
		map.put("diagnosisConclusionName",diagnosisConclusionName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDiagnosisConclusionJsp(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showDiagnosisConclusionJsp();
		@SuppressWarnings("unused")
		ArrayList  searchDiagnosisConclusionList = (ArrayList)map.get("searchDiagnosisConclusionList");
		jsp = DIAGNOSIS_CONCLUSION_JSP;
		jsp += ".jsp";
		title = "Diagnosis Conclusion";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDiagnosisConclusion(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasDiagnosisConclusion masDiagnosisConclusion=new MasDiagnosisConclusion();
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

		List diagnosisConclusionCodeList = new ArrayList();
		List diagnosisConclusionNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			diagnosisConclusionCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			diagnosisConclusionNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((diagnosisConclusionCodeList.size() == 0 || diagnosisConclusionCodeList == null) && (diagnosisConclusionNameList.size() == 0 || diagnosisConclusionNameList == null))
		{
			masDiagnosisConclusion.setDiagnosisConclusionCode(code);
			masDiagnosisConclusion.setDiagnosisConclusionName(name);
			masDiagnosisConclusion.setStatus("y");
			masDiagnosisConclusion.setLastChgby(changedBy);
			masDiagnosisConclusion.setLastchgdate(currentDate);
			masDiagnosisConclusion.setLastchgtime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService.addDiagnosisConclusion(masDiagnosisConclusion);		

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}

		else if((diagnosisConclusionCodeList.size() != 0 || diagnosisConclusionCodeList != null) || (diagnosisConclusionNameList.size() != 0) || diagnosisConclusionNameList != null){

			if((diagnosisConclusionCodeList.size() != 0 || diagnosisConclusionCodeList != null) && (diagnosisConclusionNameList.size() == 0 || diagnosisConclusionNameList == null)){
				message = "DC Code  already exists.";
			}
			else if((diagnosisConclusionNameList.size() != 0 || diagnosisConclusionNameList != null) && (diagnosisConclusionCodeList.size() == 0 || diagnosisConclusionCodeList == null) ){

				message = "DC Name already exists.";
			}
			else if((diagnosisConclusionCodeList.size() != 0 || diagnosisConclusionCodeList != null) && (diagnosisConclusionNameList.size() != 0 || diagnosisConclusionNameList != null)){

				message = "DC Code and DC Name already exist.";
			}
		}

		url = "/hms/hms/laboratory?method=showDiagnosisConclusionJsp";
		try{
			map = laboratoryMasterHandlerService.showDiagnosisConclusionJsp();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=DIAGNOSIS_CONCLUSION_JSP;
		  title="Add Diagnosis Conclusion";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editDiagnosisConclusion(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String diagnosisConclusionCode="";
		String diagnosisConclusionName="";
		int diagnosisConclusionId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			diagnosisConclusionId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			diagnosisConclusionCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			diagnosisConclusionName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", diagnosisConclusionId);
		generalMap.put("diagnosisConclusionCode", diagnosisConclusionCode);
		generalMap.put("name", diagnosisConclusionName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingDiagnosisConclusionNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingDiagnosisConclusionNameList.size() == 0)
		{
		dataUpdated=laboratoryMasterHandlerService.editDiagnosisConclusionToDatabase(generalMap);
		if(dataUpdated){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated!!";
		}}
		else if(existingDiagnosisConclusionNameList.size() > 0){

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showDiagnosisConclusionJsp";
	  try{
		  map = laboratoryMasterHandlerService.showDiagnosisConclusionJsp();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=DIAGNOSIS_CONCLUSION_JSP;
		  title="Edit Diagnosis Conclusion";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteDiagnosisConclusion(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int diagnosisConclusionId=0;
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
			diagnosisConclusionId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=laboratoryMasterHandlerService.deleteDiagnosisConclusion(diagnosisConclusionId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showDiagnosisConclusionJsp";		
		try{
			map = laboratoryMasterHandlerService.showDiagnosisConclusionJsp();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=DIAGNOSIS_CONCLUSION_JSP;
		  title="Delete Diagnosis Conclusion";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}
	
	
	// ------------------------------------------ BiopsyLab Type-------------------------------------------
	

	public ModelAndView searchBiopsyLab(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String biopsyLabCode  = null;
		String biopsyLabName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			biopsyLabCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			biopsyLabName = request.getParameter(SEARCH_NAME);
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
			biopsyLabCode=searchField;
			biopsyLabName=null;
			
		}else{
			biopsyLabCode=null;
			biopsyLabName=searchField;
		}
		
		map = laboratoryMasterHandlerService.searchBiopsyLab(biopsyLabCode, biopsyLabName);
		jsp=BIOPSY_LAB_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);

		map.put("biopsyLabCode",biopsyLabCode);
		map.put("biopsyLabName",biopsyLabName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showBiopsyLabJsp(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showBiopsyLabJsp();
		@SuppressWarnings("unused")
		ArrayList  searchBiopsyLabList = (ArrayList)map.get("searchBiopsyLabList");
		jsp = BIOPSY_LAB_JSP;
		jsp += ".jsp";
		title = "BiopsyLab";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBiopsyLab(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasBiopsyLab masBiopsyLab=new MasBiopsyLab();
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
		List biopsyLabCodeList = new ArrayList();
		List biopsyLabNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			biopsyLabCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			biopsyLabNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((biopsyLabCodeList.size() == 0 || biopsyLabCodeList == null) && (biopsyLabNameList.size() == 0 || biopsyLabNameList == null))
		{
			masBiopsyLab.setBiopsyLabCode(code);
			masBiopsyLab.setBiopsyLabName(name);
			masBiopsyLab.setStatus("y");
			masBiopsyLab.setLastChgBy(changedBy);
			masBiopsyLab.setLastChgDate(currentDate);
			masBiopsyLab.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService.addBiopsyLab(masBiopsyLab);			
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}

		else if((biopsyLabCodeList.size() != 0 || biopsyLabCodeList != null) || (biopsyLabNameList.size() != 0) || biopsyLabNameList != null){

			if((biopsyLabCodeList.size() != 0 || biopsyLabCodeList != null) && (biopsyLabNameList.size() == 0 || biopsyLabNameList == null)){
				message = "BiopsyLab Code  already exists.";
			}
			else if((biopsyLabNameList.size() != 0 || biopsyLabNameList != null) && (biopsyLabCodeList.size() == 0 || biopsyLabCodeList == null) ){

				message = "BiopsyLab Name already exists.";
			}
			else if((biopsyLabCodeList.size() != 0 || biopsyLabCodeList != null) && (biopsyLabNameList.size() != 0 || biopsyLabNameList != null)){
				message = "BiopsyLab Code and BiopsyLab Name already exist.";
			}
		}

		url = "/hms/hms/laboratory?method=showBiopsyLabJsp";	
		try{
			map = laboratoryMasterHandlerService.showBiopsyLabJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		  }
		  jsp=BIOPSY_LAB_JSP;
		  title="Add Biopsy Lab";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editBiopsyLab(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		String biopsyLabCode="";
		String biopsyLabName="";
		int biopsyLabId=0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			biopsyLabId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			biopsyLabCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			biopsyLabName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", biopsyLabId);
		generalMap.put("biopsyLabCode", biopsyLabCode);
		generalMap.put("name", biopsyLabName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingBiopsyLabNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingBiopsyLabNameList.size() == 0)
		{
			dataUpdated=laboratoryMasterHandlerService.editBiopsyLabToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
		} 
		else if(existingBiopsyLabNameList.size() > 0){

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showBiopsyLabJsp";
		try{
			map = laboratoryMasterHandlerService.showBiopsyLabJsp();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=BIOPSY_LAB_JSP;
		  title="Edit Biopsy Lab";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteBiopsyLab(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int biopsyLabId=0;
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
			biopsyLabId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=laboratoryMasterHandlerService.deleteBiopsyLab(biopsyLabId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showBiopsyLabJsp";
		try{
			map = laboratoryMasterHandlerService.showBiopsyLabJsp();
		     }catch (Exception e) {
		    	 	e.printStackTrace();
		  }
		  jsp=BIOPSY_LAB_JSP;
		  title="Delete Biopsy Lab";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}
//----------------------------------Sample Master-------------------------------------
	public ModelAndView searchSample(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String sampleCode  = null;
		String sampleName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			sampleCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			sampleName = request.getParameter(SEARCH_NAME);
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
			sampleCode=searchField;
			sampleName=null;
		}else{
			sampleCode=null;
			sampleName=searchField;
		}
		
		map = laboratoryMasterHandlerService.searchSample(sampleCode, sampleName);

		jsp=SAMPLE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("sampleCode",sampleCode);
		map.put("sampleName",sampleName);
		return new ModelAndView("indexB", "map", map);
	}
//-------------------------Sample Master------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showSampleJsp(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showSampleJsp();
		jsp = SAMPLE_JSP;
		jsp += ".jsp";
		title = "Sample";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		}

	@SuppressWarnings("unchecked")
	public ModelAndView addSample(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasSample masSample=new MasSample();
		String changedBy = "";
		int collectionId=0;
		int uomId=0;
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (!request.getParameter(SAMPLE_COLLECTION_ID).equals("0")) {
			 collectionId = Integer.parseInt(request.getParameter(SAMPLE_COLLECTION_ID));
		}
		 if (!request.getParameter(DG_UOM_ID).equals("0")) {
			 uomId = Integer.parseInt(request.getParameter(DG_UOM_ID));
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
		List sampleCodeList = new ArrayList();
		List sampleNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			sampleCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			sampleNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((sampleCodeList.size() == 0 || sampleCodeList == null) && (sampleNameList.size() == 0 || sampleNameList == null))
		{
			masSample.setSampleCode(code);
			masSample.setSampleDescription(name);
			
			if(collectionId != 0){
			 DgMasCollection dgMasCollection = new DgMasCollection();
			 dgMasCollection.setId(collectionId);
			 masSample.setCollection(dgMasCollection);
			}
			
			if(uomId != 0){
			 DgUom dgUom = new DgUom();
			 dgUom.setId(uomId);
			 masSample.setUom(dgUom);
			}
			masSample.setStatus("y");
			masSample.setLastChgBy(changedBy);
			masSample.setLastChgDate(currentDate);
			masSample.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService.addSample(masSample);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}

		}
		else if((sampleCodeList.size() != 0 || sampleCodeList != null) || (sampleNameList.size() != 0) || sampleNameList != null){

			if((sampleCodeList.size() != 0 || sampleCodeList != null) && (sampleNameList.size() == 0 || sampleNameList == null)){
				message = "Sample Code  already exists.";
			}
			else if((sampleNameList.size() != 0 || sampleNameList != null) && (sampleCodeList.size() == 0 || sampleCodeList == null) ){
				message = "Sample Name already exists.";
			}
			else if((sampleCodeList.size() != 0 || sampleCodeList != null) && (sampleNameList.size() != 0 || sampleNameList != null)){
				message = "Sample Code and Sample Name already exist.";
			}
		}
		url = "/hms/hms/laboratory?method=showSampleJsp";
		
		try{
			map = laboratoryMasterHandlerService.showSampleJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		  }
		  jsp=SAMPLE_JSP;
		  title="Add Sample";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editSample(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String sampleCode="";
		String sampleName="";
		int sampleId=0;
		int collectionId=0;
		int uomId=0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			sampleId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			sampleCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			sampleName = request.getParameter(SEARCH_NAME);
		}
		if (!request.getParameter(SAMPLE_COLLECTION_ID).equals("0")) {
			collectionId = Integer.parseInt(request.getParameter(SAMPLE_COLLECTION_ID));
		}
		if (!request.getParameter(DG_UOM_ID).equals("0")) {
			uomId = Integer.parseInt(request.getParameter(DG_UOM_ID));
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", sampleId);
		generalMap.put("sampleCode", sampleCode);
		generalMap.put("name", sampleName);
		generalMap.put("collectionId",collectionId);
		generalMap.put("uomId",uomId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingSampleNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingSampleNameList.size() == 0)
		{
		dataUpdated=laboratoryMasterHandlerService.editSampleToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
		} 
		else if(existingSampleNameList.size() > 0){

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showSampleJsp";
		try{
			map = laboratoryMasterHandlerService.showSampleJsp();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=SAMPLE_JSP;
		  title="Edit Sample";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteSample(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int sampleId=0;
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
			sampleId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=laboratoryMasterHandlerService.deleteSample(sampleId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showSampleJsp";
		try{
			map = laboratoryMasterHandlerService.showSampleJsp();
		   }catch (Exception e) {
			   e.printStackTrace();
		  }
		  jsp=SAMPLE_JSP;
		  title="Delete Sample";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}
//----------------------------Sample Collection Master--------------------------------------------
	
	@SuppressWarnings("unchecked")
	public ModelAndView showSampleCollectionJsp(HttpServletRequest request,HttpServletResponse response)
	{
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showSampleCollectionJsp();
		jsp = SAMPLE_COLLECTION_MASTER;
		jsp += ".jsp";
		title = "sampleCollectionJsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchSampleCollection(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String collectionCode  = null;
		String collectionName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			collectionCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			collectionName = request.getParameter(SEARCH_NAME);
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
			collectionCode=searchField;
			collectionName=null;
		}else{
			collectionCode=null;
			collectionName=searchField;
		}
		
		map = laboratoryMasterHandlerService.searchSampleCollection(collectionCode, collectionName);

		jsp=SAMPLE_COLLECTION_MASTER;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("collectionCode",collectionCode);
		map.put("collectionName",collectionName);
		return new ModelAndView("indexB", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addSampleCollection(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		DgMasCollection dgMasCollection=new DgMasCollection();
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
		List collectionCodeList = new ArrayList();
		List collectionNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			collectionCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			collectionNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((collectionCodeList.size() == 0 || collectionCodeList == null) && (collectionNameList.size() == 0 || collectionNameList == null))
		{
			dgMasCollection.setCollectionCode(code);
			dgMasCollection.setCollectionName(name);
			dgMasCollection.setStatus("y");
			dgMasCollection.setLastChgBy(changedBy);
			dgMasCollection.setLastChgDate(currentDate);
			dgMasCollection.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService.addSampleCollection(dgMasCollection);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((collectionCodeList.size() != 0 || collectionCodeList != null) || (collectionNameList.size() != 0) || collectionNameList != null){

			if((collectionCodeList.size() != 0 || collectionCodeList != null) && (collectionNameList.size() == 0 || collectionNameList == null)){
				message = "Collection Code  already exists.";
			}
			else if((collectionNameList.size() != 0 || collectionNameList != null) && (collectionCodeList.size() == 0 || collectionCodeList == null) ){
				message = "Collection Name already exists.";
			}
			else if((collectionCodeList.size() != 0 || collectionCodeList != null) && (collectionNameList.size() != 0 || collectionNameList != null)){
				message = "Collection Code and Collection Name already exist.";
			}
		}
		url = "/hms/hms/laboratory?method=showSampleCollectionJsp";
		
		try{
			map = laboratoryMasterHandlerService.showSampleCollectionJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		  }
		  jsp=SAMPLE_COLLECTION_MASTER;
		  title="Add SampleCollection";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editSampleCollection(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String collectionCode="";
		String collectionName="";
		int collectionId=0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			collectionId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			collectionCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			collectionName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", collectionId);
		generalMap.put("sampleCode", collectionCode);
		generalMap.put("name", collectionName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingCollectionNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingCollectionNameList.size() == 0)
		{
		dataUpdated=laboratoryMasterHandlerService.editSampleCollectionToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
		} 
		else if(existingCollectionNameList.size() > 0){

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showSampleCollectionJsp";
		try{
			map = laboratoryMasterHandlerService.showSampleCollectionJsp();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=SAMPLE_COLLECTION_MASTER;
		  title="Edit SampleCollection";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteSampleCollection(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int collectionId=0;
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
			collectionId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=laboratoryMasterHandlerService.deleteSampleCollection(collectionId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showSampleCollectionJsp";
		try{
			map = laboratoryMasterHandlerService.showSampleCollectionJsp();
		   }catch (Exception e) {
			   e.printStackTrace();
		  }
		  jsp=SAMPLE_COLLECTION_MASTER;
		  title="Delete SampleCollection";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}
//----------------------------Investigation UOM Master--------------------------------------------
	
	@SuppressWarnings("unchecked")
	public ModelAndView showInvestigationUomJsp(HttpServletRequest request,HttpServletResponse response)
	{
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showInvestigationUomJsp();
		jsp = DG_UOM_JSP;
		jsp += ".jsp";
		title = "dgUOM";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchInvestigationUom(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String uomCode  = null;
		String uomName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			uomCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			uomName = request.getParameter(SEARCH_NAME);
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
			uomCode=searchField;
			uomName=null;
		}else{
			uomCode=null;
			uomName=searchField;
		}
		
		map = laboratoryMasterHandlerService.searchInvestigationUom(uomCode,uomName);

		jsp=DG_UOM_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("uomCode",uomCode);
		map.put("uomName",uomName);
		return new ModelAndView("indexB", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addInvestigationUom(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		DgUom dgUom=new DgUom();
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
		List uomCodeList = new ArrayList();
		List uomNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			uomCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			uomNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((uomCodeList.size() == 0 || uomCodeList == null) && (uomNameList.size() == 0 || uomNameList == null))
		{
			dgUom.setUomCode(code);
			dgUom.setUomName(name);
			dgUom.setStatus("y");
			dgUom.setLastChgBy(changedBy);
			dgUom.setLastChgDate(currentDate);
			dgUom.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService.addInvestigationUom(dgUom);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((uomCodeList.size() != 0 || uomCodeList != null) || (uomNameList.size() != 0) || uomNameList != null){

			if((uomCodeList.size() != 0 || uomCodeList != null) && (uomNameList.size() == 0 || uomNameList == null)){
				message = "UOM Code  already exists.";
			}
			else if((uomNameList.size() != 0 || uomNameList != null) && (uomCodeList.size() == 0 || uomCodeList == null) ){
				message = "UOM Name already exists.";
			}
			else if((uomCodeList.size() != 0 || uomCodeList != null) && (uomNameList.size() != 0 || uomNameList != null)){
				message = "UOM Code and UOM Name already exist.";
			}
		}
		url = "/hms/hms/laboratory?method=showInvestigationUomJsp";
		
		try{
			map = laboratoryMasterHandlerService.showInvestigationUomJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		  }
		  jsp=DG_UOM_JSP;
		  title="Add InvestigationUom";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editInvestigationUom(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String uomCode="";
		String uomName="";
		int uomId=0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			uomId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			uomCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			uomName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", uomId);
		generalMap.put("uomCode", uomCode);
		generalMap.put("name", uomName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingUomNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingUomNameList.size() == 0)
		{
		dataUpdated=laboratoryMasterHandlerService.editInvestigationUomToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
		} 
		else if(existingUomNameList.size() > 0){

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showInvestigationUomJsp";
		try{
			map = laboratoryMasterHandlerService.showInvestigationUomJsp();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=DG_UOM_JSP;
		  title="Edit InvestigationUom";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteInvestigationUom(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int uomId=0;
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
			uomId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=laboratoryMasterHandlerService.deleteInvestigationUom(uomId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showInvestigationUomJsp";
		try{
			map = laboratoryMasterHandlerService.showInvestigationUomJsp();
		   }catch (Exception e) {
			   e.printStackTrace();
		  }
		  jsp=DG_UOM_JSP;
		  title="Delete InvestigationUom";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}
//----------------------------------Dg Collection Center----------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showCollectionCenterJsp(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showCollectionCenterJsp();
		@SuppressWarnings("unused")
		ArrayList  searchCollectionCenterList = (ArrayList)map.get("searchCollectionCenterList");
		jsp = DG_COLLECTION_CENTER;
		jsp += ".jsp";
		title = "CollectionCenter";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchCollectionCenter(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String collectionCenterCode  = null;
		String collectionCenterName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			collectionCenterCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			collectionCenterName = request.getParameter(SEARCH_NAME);
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
			collectionCenterCode=searchField;
			collectionCenterName=null;
			
		}else{
			collectionCenterCode=null;
			collectionCenterName=searchField;
		}
		
		map = laboratoryMasterHandlerService.searchCollectionCenter(collectionCenterCode, collectionCenterName);
		jsp=DG_COLLECTION_CENTER;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);

		map.put("collectionCenterCode",collectionCenterCode);
		map.put("collectionCenterName",collectionCenterName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCollectionCenter(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		DgCollectionCenter dgCollectionCenter=new DgCollectionCenter();
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
		List collectionCenterCodeList = new ArrayList();
		List collectionCenterNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			collectionCenterCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			collectionCenterNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((collectionCenterCodeList.size() == 0 || collectionCenterCodeList == null) && (collectionCenterNameList.size() == 0 || collectionCenterNameList == null))
		{
			dgCollectionCenter.setCollectionCenterCode(code);
			dgCollectionCenter.setCollectionCenterName(name);
			dgCollectionCenter.setStatus("y");
			dgCollectionCenter.setLastChgBy(changedBy);
			dgCollectionCenter.setLastChgDate(currentDate);
			dgCollectionCenter.setLastChgTime(currentTime);
			
			MasHospital hospital= new MasHospital();
			hospital.setId(hospitalId);
			dgCollectionCenter.setHospital(hospital);
			
			successfullyAdded = laboratoryMasterHandlerService.addCollectionCenter(dgCollectionCenter);			
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}

		else if((collectionCenterCodeList.size() != 0 || collectionCenterCodeList != null) || (collectionCenterNameList.size() != 0) || collectionCenterNameList != null){

			if((collectionCenterCodeList.size() != 0 || collectionCenterCodeList != null) && (collectionCenterNameList.size() == 0 || collectionCenterNameList == null)){
				message = "CollectionCenter Code  already exists.";
			}
			else if((collectionCenterNameList.size() != 0 || collectionCenterNameList != null) && (collectionCenterCodeList.size() == 0 || collectionCenterCodeList == null) ){

				message = "CollectionCenter Name already exists.";
			}
			else if((collectionCenterCodeList.size() != 0 || collectionCenterCodeList != null) && (collectionCenterNameList.size() != 0 || collectionCenterNameList != null)){
				message = "CollectionCenter Code and CollectionCenter Name already exist.";
			}
		}

		url = "/hms/hms/laboratory?method=showCollectionCenterJsp";	
		try{
			map = laboratoryMasterHandlerService.showCollectionCenterJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		  }
		  jsp=DG_COLLECTION_CENTER;
		  title="Add CollectionCenter";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editCollectionCenter(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		String collectionCenterCode="";
		String collectionCenterName="";
		int collectionCenterId=0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			collectionCenterId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			collectionCenterCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			collectionCenterName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", collectionCenterId);
		generalMap.put("collectionCenterCode", collectionCenterCode);
		generalMap.put("name", collectionCenterName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingCollectionCenterNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingCollectionCenterNameList.size() == 0)
		{
			dataUpdated=laboratoryMasterHandlerService.editCollectionCenterToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
		} 
		else if(existingCollectionCenterNameList.size() > 0){

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showCollectionCenterJsp";
		try{
			map = laboratoryMasterHandlerService.showCollectionCenterJsp();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=DG_COLLECTION_CENTER;
		  title="Edit CollectionCenter";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteCollectionCenter(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int collectionCenterId=0;
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
			collectionCenterId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=laboratoryMasterHandlerService.deleteCollectionCenter(collectionCenterId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showCollectionCenterJsp";
		try{
			map = laboratoryMasterHandlerService.showCollectionCenterJsp();
		     }catch (Exception e) {
		    	 	e.printStackTrace();
		  }
		  jsp=DG_COLLECTION_CENTER;
		  title="Delete CollectionCenter";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}
	
	
	// ********************************--start-- Organism Master **********************************	

	@SuppressWarnings("unchecked")
	public ModelAndView showOrganismGroupJsp(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showOrganismGroupJsp();
		
		jsp = ORGANISM_GROUP_JSP;
		jsp += ".jsp";
		title = "OrganismGroup";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchOrganismGroup(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		
		Map<String, Object> map= new HashMap<String, Object>();		
		String organismGroupCode = null;
		String organismGroupName = null;
		String searchField  = null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			organismGroupCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			organismGroupName = request.getParameter(SEARCH_NAME);
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
			organismGroupCode=searchField;
			organismGroupName=null;
			
		}else{
			organismGroupCode=null;
			organismGroupName=searchField;
		}
		
		map = laboratoryMasterHandlerService.searchOrganismGroup(organismGroupCode, organismGroupName);
		jsp=ORGANISM_GROUP_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("organismGroupCode",organismGroupCode);
		map.put("organismGroupName",organismGroupName);
		return new ModelAndView("indexB", "map", map);
	}

	

	@SuppressWarnings("unchecked")
	public ModelAndView addOrganismGroup(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		DgMasOrganismGroup dgMasOrganismGroup=new DgMasOrganismGroup();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int organismId=0;

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(ORGANISM_GROUP_ID) != null) {
			organismId = Integer.parseInt(request.getParameter(ORGANISM_GROUP_ID));
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
		List organismGroupCodeList = new ArrayList();
		List organismGroupNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			organismGroupCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			organismGroupNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((organismGroupCodeList.size() == 0 || organismGroupCodeList == null) && (organismGroupNameList.size() == 0 || organismGroupNameList == null))
		{
			dgMasOrganismGroup.setOrganismGroupCode(code);
			dgMasOrganismGroup.setOrganismGroupName(name);
			dgMasOrganismGroup.setStatus("y");
			dgMasOrganismGroup.setLastChgBy(changedBy);
			dgMasOrganismGroup.setLastChgDate(currentDate);
			dgMasOrganismGroup.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService.addOrganismGroup(dgMasOrganismGroup);			
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}

		else if((organismGroupCodeList.size() != 0 || organismGroupCodeList != null) || (organismGroupNameList.size() != 0) || organismGroupNameList != null){

			if((organismGroupCodeList.size() != 0 || organismGroupCodeList != null) && (organismGroupNameList.size() == 0 || organismGroupNameList == null)){
				message = "OrganismGroup Code  already exists.";
			}
			else if((organismGroupNameList.size() != 0 || organismGroupNameList != null) && (organismGroupCodeList.size() == 0 || organismGroupCodeList == null) ){

				message = "OrganismGroup Name already exists.";
			}
			else if((organismGroupCodeList.size() != 0 || organismGroupCodeList != null) && (organismGroupNameList.size() != 0 || organismGroupNameList != null)){
				message = "OrganismGroup Code and OrganismGroup Name already exist.";
			}
		}

		url = "/hms/hms/laboratory?method=showOrganismGroupJsp";	
		try{
			map = laboratoryMasterHandlerService.showOrganismGroupJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		  }
		  jsp=ORGANISM_GROUP_JSP;
		  title="Add Organism Group";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editOrganismGroupToDatabase(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		String organismGroupCode="";
		String organismGroupName="";
		int organismGroupId=0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			organismGroupId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			organismGroupCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			organismGroupName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", organismGroupId);
		generalMap.put("organismGroupCode", organismGroupCode);
		generalMap.put("name", organismGroupName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingOrganismGroupNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingOrganismGroupNameList.size() == 0)
		{
			dataUpdated=laboratoryMasterHandlerService.editOrganismGroupToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
		} 
		else if(existingOrganismGroupNameList.size() > 0){

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showOrganismGroupJsp";
		try{
			map = laboratoryMasterHandlerService.showOrganismGroupJsp();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=ORGANISM_GROUP_JSP;
		  title="Edit Oragnism Group";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteOrganismGroup(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int organismGroupId=0;
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
			organismGroupId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=laboratoryMasterHandlerService.deleteOrganismGroup(organismGroupId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showOrganismGroupJsp";
		try{
			map = laboratoryMasterHandlerService.showOrganismGroupJsp();
		     }catch (Exception e) {
		    	 	e.printStackTrace();
		  }
		  jsp=ORGANISM_GROUP_JSP;
		  title="Delete Organism Group";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}
	
	
// ********************************--start-- Organism Group Master by Vishal Jain--**********************************	

	public ModelAndView searchOrganism(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		
		Map<String, Object> map= new HashMap<String, Object>();		
		String organismCode = null;
		String organismName = null;
		String searchField  = null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			organismCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			organismName = request.getParameter(SEARCH_NAME);
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
			organismCode=searchField;
			organismName=null;
			
		}else{
			organismCode=null;
			organismName=searchField;
		}
		
		map = laboratoryMasterHandlerService.searchOrganism(organismCode, organismName);
		jsp=ORGANISM_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);

		map.put("organismCode",organismCode);
		map.put("organismName",organismName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showOrganismJsp(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showOrganismJsp();
		jsp = ORGANISM_JSP;
		jsp += ".jsp";
		title = "Organism";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOrganism(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		DgMasOrganism dgMasOrganism=new DgMasOrganism();
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
		List organismCodeList = new ArrayList();
		List organismNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			organismCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			organismNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((organismCodeList.size() == 0 || organismCodeList == null) && (organismNameList.size() == 0 || organismNameList == null))
		{
			dgMasOrganism.setOrganismCode(code);
			dgMasOrganism.setOrganismName(name);
			dgMasOrganism.setStatus("y");
			dgMasOrganism.setLastChgBy(changedBy);
			dgMasOrganism.setLastChgDate(currentDate);
			dgMasOrganism.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService.addOrganism(dgMasOrganism);			
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}

		else if((organismCodeList.size() != 0 || organismCodeList != null) || (organismNameList.size() != 0) || organismNameList != null){

			if((organismCodeList.size() != 0 || organismCodeList != null) && (organismNameList.size() == 0 || organismNameList == null)){
				message = "Organism Code  already exists.";
			}
			else if((organismNameList.size() != 0 || organismNameList != null) && (organismCodeList.size() == 0 || organismCodeList == null) ){

				message = "Organism Name already exists.";
			}
			else if((organismCodeList.size() != 0 || organismCodeList != null) && (organismNameList.size() != 0 || organismNameList != null)){
				message = "Organism Code and Organism Name already exist.";
			}
		}

		url = "/hms/hms/laboratory?method=showOrganismJsp";	
		try{
			map = laboratoryMasterHandlerService.showOrganismJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		  }
		  jsp=ORGANISM_JSP;
		  title="Add Organism";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editOrganism(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		String organismCode="";
		String organismName="";
		int organismId=0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			organismId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			organismCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			organismName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", organismId);
		generalMap.put("organismCode", organismCode);
		generalMap.put("name", organismName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingOrganismNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingOrganismNameList.size() == 0)
		{
			dataUpdated=laboratoryMasterHandlerService.editOrganism(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
		} 
		else if(existingOrganismNameList.size() > 0){

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showOrganismJsp";
		try{
			map = laboratoryMasterHandlerService.showOrganismJsp();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=ORGANISM_JSP;
		  title="Edit Organism";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteOrganism(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int organismId=0;
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
			organismId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=laboratoryMasterHandlerService.deleteOrganism(organismId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showOrganismJsp";
		try{
			map = laboratoryMasterHandlerService.showOrganismJsp();
		     }catch (Exception e) {
		    	 	e.printStackTrace();
		  }
		  jsp=ORGANISM_JSP;
		  title="Delete Organism";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView generateReportForLabOrganism(HttpServletRequest request, HttpServletResponse response)
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
		parameters = laboratoryMasterHandlerService.getConnection();
		HMSUtil.generateReport(jasper, parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("index", "map", map);
	}
	
// ********************************--End-- Organism Group Master by Vishal Jain**********************************	
	
	
	
	public ModelAndView generateReportForLabOrganismDesc(HttpServletRequest request, HttpServletResponse response)
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
		parameters = laboratoryMasterHandlerService.getConnection();
		HMSUtil.generateReport(jasper, parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("index", "map", map);
	}
	
// ********************************--End-- Organism Master by Vishal Jain**********************************	

	// ********************************--start--Antibiotic Master by Vishal Jain--**********************************	

	public ModelAndView searchAntibioticLab(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		
		Map<String, Object> map= new HashMap<String, Object>();		
		String antibioticCode = null;
		String antibioticName = null;
		String searchField  = null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			antibioticCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			antibioticName = request.getParameter(SEARCH_NAME);
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
			antibioticCode=searchField;
			antibioticName=null;
			
		}else{
			antibioticCode=null;
			antibioticName=searchField;
		}
		
		map = laboratoryMasterHandlerService.searchAntibioticLab(antibioticCode, antibioticName);
		jsp=ANTIBIOTIC_LAB_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);

		map.put("antibioticCode",antibioticCode);
		map.put("antibioticName",antibioticName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showAntibioticLabJsp(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showAntibioticLabJsp();
		
	//	@SuppressWarnings("unused") 
		ArrayList  searchAntibioticList = (ArrayList)map.get("searchAntibioticList");
		jsp = ANTIBIOTIC_LAB_JSP;
		jsp += ".jsp";
		title = "AntibioticLab";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAntibioticLab(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasAntibioticLab masAntibioticLab = new MasAntibioticLab();
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
		List antibioticLabCodeList = new ArrayList();
		List antibioticLabNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			antibioticLabCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			antibioticLabNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((antibioticLabCodeList.size() == 0 || antibioticLabCodeList == null) && (antibioticLabNameList.size() == 0 || antibioticLabNameList == null))
		{
			masAntibioticLab.setAntibioticLabCode(code);
			masAntibioticLab.setAntibioticLabName(name);
			masAntibioticLab.setStatus("y");
			masAntibioticLab.setLastChgBy(changedBy);
			masAntibioticLab.setLastChgDate(currentDate);
			masAntibioticLab.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService.addAntibioticLab(masAntibioticLab);			
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}

		else if((antibioticLabCodeList.size() != 0 || antibioticLabCodeList != null) || (antibioticLabNameList.size() != 0) || antibioticLabNameList != null){

			if((antibioticLabCodeList.size() != 0 || antibioticLabCodeList != null) && (antibioticLabNameList.size() == 0 || antibioticLabNameList == null)){
				message = "Antibiotic Lab Code  already exists.";
			}
			else if((antibioticLabNameList.size() != 0 || antibioticLabNameList != null) && (antibioticLabCodeList.size() == 0 || antibioticLabCodeList == null) ){

				message = "Antibiotic Lab Name already exists.";
			}
			else if((antibioticLabCodeList.size() != 0 || antibioticLabCodeList != null) && (antibioticLabNameList.size() != 0 || antibioticLabNameList != null)){
				message = "Antibiotic Lab Code and Antibiotic Lab Name already exist.";
			}
		}

		url = "/hms/hms/laboratory?method=showOrganismLabJsp";	
		try{
			map = laboratoryMasterHandlerService.showAntibioticLabJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		  }
		  jsp=ANTIBIOTIC_LAB_JSP;
		  title="Add Antibiotic Lab";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editAntibioticLab(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		String antibioticLabCode="";
		String antiobioticLabName="";
		int antibioticLabId=0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			antibioticLabId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			antibioticLabCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			antiobioticLabName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", antibioticLabId);
		generalMap.put("biopsyLabCode", antibioticLabCode);
		generalMap.put("name", antiobioticLabName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingAntibioticLabNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingAntibioticLabNameList.size() == 0)
		{
			dataUpdated=laboratoryMasterHandlerService.editAntibioticLabToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
		} 
		else if(existingAntibioticLabNameList.size() > 0){

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showAntibioticLabJsp";
		try{
			map = laboratoryMasterHandlerService.showAntibioticLabJsp();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=ANTIBIOTIC_LAB_JSP;
		  title="Edit Antibiotic Lab";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteAntibioticLab(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int antibioticLabId=0;
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
			antibioticLabId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=laboratoryMasterHandlerService.deleteAntibioticLab(antibioticLabId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showAntibioticLabJsp";
		try{
			map = laboratoryMasterHandlerService.showAntibioticLabJsp();
		     }catch (Exception e) {
		    	 	e.printStackTrace();
		  }
		  jsp=ANTIBIOTIC_LAB_JSP;
		  title="Delete Antibiotic Lab";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView generateReportForLabAntibiotic(HttpServletRequest request, HttpServletResponse response)
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
		parameters = laboratoryMasterHandlerService.getConnection();
		HMSUtil.generateReport(jasper, parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("index", "map", map);
	}
	
//----------------------Parameter Master-----------------
	
	public ModelAndView showParameterJsp(HttpServletRequest request,HttpServletResponse response)
	{
		map = laboratoryMasterHandlerService.showParameterJsp();
		jsp = MAS_PARAMETER;
		jsp += ".jsp";
		title = "Parameter";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		}
	
	public ModelAndView addParameterMaster(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasParameter masParameter=new MasParameter();
		String changedBy = "";
		int subChargeId=0;
		int serviceStatusId=0;
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (!request.getParameter(SUB_CHARGECODE_ID).equals("0")) {
			subChargeId = Integer.parseInt(request.getParameter(SUB_CHARGECODE_ID));
		}
		 if (!request.getParameter(SERVICE_STATUS_ID).equals("0")) {
			 serviceStatusId = Integer.parseInt(request.getParameter(SERVICE_STATUS_ID));
		}
		if(request.getParameter(MONTHLY) != null){
			masParameter.setMonthly("y");
		}else{
			masParameter.setMonthly("n");
		}
		if(request.getParameter(YEARLY) != null){
			masParameter.setYearly("y");
		}else{
			masParameter.setYearly("n");
		}
		if(request.getParameter(CONTINUOUS) != null){
			masParameter.setContinuous("y");
		}else{
			masParameter.setContinuous("n");
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

		boolean successfullyAdded = false;

			if(subChargeId != 0){
			 MasSubChargecode masSubChargecode = new MasSubChargecode();
			 masSubChargecode.setId(subChargeId);
			 masParameter.setSubCharge(masSubChargecode);
			}
			
			if(serviceStatusId != 0){
			 MasServiceStatus masServiceStatus = new MasServiceStatus();
			 masServiceStatus.setId(serviceStatusId);
			 masParameter.setServiceStatus(masServiceStatus);
			}
			masParameter.setStatus("y");
			masParameter.setLastChgBy(changedBy);
			masParameter.setLastChgDate(currentDate);
			masParameter.setLastChgTime(currentTime);
			
			MasHospital hospital= new MasHospital();
			hospital.setId(hospitalId);
			masParameter.setHospital(hospital);
			
			successfullyAdded = laboratoryMasterHandlerService.addParameterMaster(masParameter);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		
		try{
			map = laboratoryMasterHandlerService.showParameterJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		  }
		  jsp=MAS_PARAMETER;
		  title="Add Parameter";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView editParameterMaster(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		MasParameter masParameter = new MasParameter();
		int parameterId=0;
		int subChargeId = 0;
		int serviceStatusId = 0;
		String monthly="";
		String yearly = "";
		String continuous= "";
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			parameterId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargeId = Integer.parseInt(request.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(SERVICE_STATUS_ID) != null) {
			serviceStatusId = Integer.parseInt(request.getParameter(SERVICE_STATUS_ID));
		}
		if(request.getParameter(MONTHLY) != null){
			monthly = "y";
		}else{
			monthly = "n";
		}
		if(request.getParameter(YEARLY) != null){
			yearly = "y";
		}else{
			yearly = "n";
		}
		if(request.getParameter(CONTINUOUS) != null){
			continuous = "y";
		}else{
			continuous = "n";
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", parameterId);
		generalMap.put("subChargeId",subChargeId);
		generalMap.put("serviceStatusId", serviceStatusId);
		generalMap.put("monthly",monthly);
		generalMap.put("yearly", yearly);
		generalMap.put("continuous",continuous);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		boolean dataUpdated=false;
		dataUpdated=laboratoryMasterHandlerService.editParametermaster(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
		
		try{
			map = laboratoryMasterHandlerService.showParameterJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=MAS_PARAMETER;
		title="update Parameter";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView deleteParameterMaster(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		int parameterId=0;
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
			parameterId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=laboratoryMasterHandlerService.deleteParameterMaster(parameterId,generalMap);

		if (dataDeleted==true){
			message="Record is InActivated successfully !!";
		}else{
			message="Record is Activated successfully !!";
		}
		try{
			map = laboratoryMasterHandlerService.showParameterJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=MAS_PARAMETER;
		title="Delete Parameter";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	public ModelAndView showOrganismGroupDetailJsp(HttpServletRequest request,HttpServletResponse response)
	{
		map = laboratoryMasterHandlerService.showOrganismGroupDetailJsp();
		jsp = ORG_GRP_DETAIL;
		jsp += ".jsp";
		title = "OrganismGroupDetail";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOrganismGroupDetail(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map = new HashMap<String,Object>();
	
        int organismGroupId=0;
        String[] organismId = null;

        String changedBy = "";
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		
		if (request.getParameter(ORGANISM_GROUP_ID) != null) {
			organismGroupId = Integer.parseInt(request.getParameter(ORGANISM_GROUP_ID));
		}
		if (request.getParameter(ORGANISM_ID) != null) {
			organismId = request.getParameterValues(ORGANISM_ID);
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
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoName", pojoName);

		boolean successfullyAdded = false;
		for(int i=0;i<organismId.length;i++){
			DgOrgGrpDtl dgOrgGrpDtl = new DgOrgGrpDtl();
			DgMasOrganismGroup dgMasOrganismGroup = new DgMasOrganismGroup();
			dgMasOrganismGroup.setId(organismGroupId);
			dgOrgGrpDtl.setOrganismGroup(dgMasOrganismGroup);
		
			DgMasOrganism dgMasOrganism = new DgMasOrganism();
			dgMasOrganism.setId(Integer.parseInt(organismId[i]));
			dgOrgGrpDtl.setOrganism(dgMasOrganism);
			
			dgOrgGrpDtl.setStatus("y");
			dgOrgGrpDtl.setLastChgBy(changedBy);
			dgOrgGrpDtl.setLastChgDate(currentDate);
			dgOrgGrpDtl.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService.addOrganismGroupDetail(dgOrgGrpDtl);
		}
			if(successfullyAdded){
				message="Record Added Successfully !!";
			}else{
				message="Try Again !!";
			}
		
		try{
			map = laboratoryMasterHandlerService.showOrganismGroupDetailJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=ORG_GRP_DETAIL;
		title="Add OrganismGroupDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editOrganismGroupDetail(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object>	map = new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int groupDetailId = 0;
		int organismGroupId=0;
		int totalRowsCount=0;
		int organismId=0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		List<Integer> organismIds = new ArrayList<Integer>();
		if (request.getParameter("totalRowsCount") != null) {
			totalRowsCount = Integer.parseInt(request.getParameter("totalRowsCount"));
		}
		if (request.getParameter(ORGANISM_GROUP_ID) != null) {
			organismGroupId = Integer.parseInt(request.getParameter(ORGANISM_GROUP_ID));
		}

		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		for(int i =1 ;i <= totalRowsCount; i++){
			 if(request.getParameter(ORGANISM_NAME+i) != null
					 && !request.getParameter(ORGANISM_NAME+i).equals("")){
					
				 int index1 = ((String)request.getParameter(ORGANISM_NAME+i)).lastIndexOf("[");
				 int index2 = ((String)request.getParameter(ORGANISM_NAME+i)).lastIndexOf("]");
				 index1++;
				 String organismIdString = ((String)request.getParameter(ORGANISM_NAME+i)).substring(index1,index2);
				 organismIds.add(Integer.parseInt(organismIdString));
			 }
		}
		
		generalMap.put("organismGroupId",organismGroupId);
		generalMap.put("organismIds",organismIds);
		generalMap.put("totalRowsCount",totalRowsCount);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("flag", true);
		boolean dataUpdated=false;
		
		dataUpdated=laboratoryMasterHandlerService.editOrganismGroupDetail(generalMap);
		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant be updated !!";
		}
		try{
			map = laboratoryMasterHandlerService.showOrganismGroupDetailJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=ORG_GRP_DETAIL;
		title="Edit OrganismGroupDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteOrganismGroupDetail(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		int groupDetailId=0;
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
			groupDetailId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=laboratoryMasterHandlerService.deleteOrganismGroupDetail(groupDetailId,generalMap);

		if (dataDeleted==true){
			message="Record is InActivated successfully !!";
		}else{
			message="Record is Activated successfully !!";
		}
		try{
			map = laboratoryMasterHandlerService.showOrganismGroupDetailJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=ORG_GRP_DETAIL;
		title="Delete OrganismGroupDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchOrganismGroupDetail(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String organismGroupId  = "";
		if(request.getParameter(ORGANISM_GROUP_ID) != null && !(request.getParameter(ORGANISM_GROUP_ID).equals(""))){
			organismGroupId = request.getParameter(ORGANISM_GROUP_ID);
		}
			
		map = laboratoryMasterHandlerService.searchOrganismGroupDetail(organismGroupId);

		jsp=ORG_GRP_DETAIL;
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("organismGroupId",organismGroupId);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView searchOrganismGroupDetailAjax(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String organismGroupId  = "";
		if(request.getParameter(ORGANISM_GROUP_ID) != null && !(request.getParameter(ORGANISM_GROUP_ID).equals(""))){
			organismGroupId = request.getParameter(ORGANISM_GROUP_ID);
		}
			
		map = laboratoryMasterHandlerService.searchOrganismGroupDetail(organismGroupId);

		jsp="orgResponseList";
		//jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("organismGroupId",organismGroupId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchOrganismDetail(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();	
		Map<String, Object> mapForDs= new HashMap<String, Object>();		
		String organismId  = "";
		if(request.getParameter(ORGANISM_ID) != null && !(request.getParameter(ORGANISM_ID).equals(""))){
			organismId = request.getParameter(ORGANISM_ID);
			mapForDs.put("organismId", organismId);
		}
			
		map = laboratoryMasterHandlerService.searchOrganismDetail(mapForDs);

		jsp=ORG_DETAIL;
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("organismId",organismId);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchOrganismDetailAjax(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();	
		Map<String, Object> mapForDs= new HashMap<String, Object>();		
		String organismId  = "";
		if(request.getParameter(ORGANISM_ID) != null && !(request.getParameter(ORGANISM_ID).equals(""))){
			organismId = request.getParameter(ORGANISM_ID);
			mapForDs.put("organismId", organismId);
		}
			
		map = laboratoryMasterHandlerService.searchOrganismDetail(mapForDs);

		jsp = ORG_GRP_FOR_SELECTED_ORG;
		//jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("organismId",organismId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchSensitivityDetailAjax(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();
		Map<String, Object> mapForDs= new HashMap<String, Object>();
		String organismId  = "";
		String organismGroupId  = "";
		
		if(request.getParameter(ORGANISM_ID) != null && !(request.getParameter(ORGANISM_ID).equals(""))){
			organismId = request.getParameter(ORGANISM_ID);
			mapForDs.put("organismId", organismId);
		}
		if(request.getParameter(ORGANISM_GROUP_ID) != null && !(request.getParameter(ORGANISM_GROUP_ID).equals(""))){
			organismGroupId = request.getParameter(ORGANISM_GROUP_ID);
			mapForDs.put("organismGroupId", organismGroupId);
		}

		map = laboratoryMasterHandlerService.searchOrganismDetail(mapForDs);
		jsp = SENSITIVITY_FOR_SELECTED_ORG;
		//jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("organismId",organismId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showOrganismDetailJsp(HttpServletRequest request,HttpServletResponse response)
	{
		map = laboratoryMasterHandlerService.showOrganismDetailJsp();
		jsp = ORG_DETAIL;
		jsp += ".jsp";
		title = "OrganismDetail";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView addOrganismDetail(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map = new HashMap<String,Object>();
		
        String[] antiId= null;
        int organismId=0;
		String changedBy = "";
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		
		if (request.getParameter(ANTIBIOTIC_ID) != null) {
			antiId = request.getParameterValues(ANTIBIOTIC_ID);
		}
		if (request.getParameter(ORGANISM_ID) != null) {
			organismId = Integer.parseInt(request.getParameter(ORGANISM_ID));
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
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoName", pojoName);

		boolean successfullyAdded = false;
		for(int i=0;i<antiId.length;i++){	
			DgOrgDtl dgOrgDtl = new DgOrgDtl();
			MasAntibioticLab masAntibioticLab = new MasAntibioticLab();
			masAntibioticLab.setId(Integer.parseInt(antiId[i]));
			dgOrgDtl.setAntibioticLab(masAntibioticLab);
		
			DgMasOrganism dgMasOrganism = new DgMasOrganism();
			dgMasOrganism.setId(organismId);
			dgOrgDtl.setOrganism(dgMasOrganism);
			
			dgOrgDtl.setStatus("y");
			dgOrgDtl.setLastChgBy(changedBy);
			dgOrgDtl.setLastChgDate(currentDate);
			dgOrgDtl.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService.addOrganismDetail(dgOrgDtl);
		}
			if(successfullyAdded){
				message="Record Added Successfully !!";
			}else{
				message="Try Again !!";
			}
		
		try{
			map = laboratoryMasterHandlerService.showOrganismDetailJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=ORG_DETAIL;
		title="Add OrganismDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editOrganismDetail(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object>	map = new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int totalRowsCount = 0;
		int organismId=0;
		int organismGroupId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		List<Integer> antibiaticIds = new ArrayList<Integer>();
		
		if (request.getParameter(ORGANISM_ID) != null 
				&& !request.getParameter(ORGANISM_ID).equals("")) {
			organismId = Integer.parseInt(request.getParameter(ORGANISM_ID));
		}
		if (request.getParameter(ORGANISM_GROUP_ID) != null
				&& !request.getParameter(ORGANISM_GROUP_ID).equals("")) {
			organismGroupId = Integer.parseInt(request.getParameter(ORGANISM_GROUP_ID));
		}

		if (request.getParameter("totalRowsCount") != null) {
			totalRowsCount = Integer.parseInt(request.getParameter("totalRowsCount"));
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		for(int i =1 ;i <= totalRowsCount; i++){
			 if(request.getParameter(ANTIBIOTIC_NAME+i) != null
					 && !request.getParameter(ANTIBIOTIC_NAME+i).equals("")){
					
				 int index1 = ((String)request.getParameter(ANTIBIOTIC_NAME+i)).lastIndexOf("[");
				 int index2 = ((String)request.getParameter(ANTIBIOTIC_NAME+i)).lastIndexOf("]");
				 index1++;
				 String organismIdString = ((String)request.getParameter(ANTIBIOTIC_NAME+i)).substring(index1,index2);
				 antibiaticIds.add(Integer.parseInt(organismIdString));
			 }
		}
		

		
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("organismId", organismId);
		generalMap.put("organismGroupId", organismGroupId);
		generalMap.put("antibiaticIds", antibiaticIds);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("flag", true);
		boolean dataUpdated=false;
		dataUpdated=laboratoryMasterHandlerService.editOrganismDetail(generalMap);
		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant be updated !!";
		}
		try{
			map = laboratoryMasterHandlerService.showOrganismDetailJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=ORG_DETAIL;
		title="Edit OrganismDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteOrganismDetail(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		int detailId=0;
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
			detailId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=laboratoryMasterHandlerService.deleteOrganismDetail(detailId,generalMap);

		if (dataDeleted==true){
			message="Record is InActivated successfully !!";
		}else{
			message="Record is Activated successfully !!";
		}
		try{
			map = laboratoryMasterHandlerService.showOrganismDetailJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=ORG_DETAIL;
		title="Delete OrganismDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showFilmSizeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		map = laboratoryMasterHandlerService.showOrganismDetailJsp();
		jsp = FILM_SIZE_DETAILS;
		jsp += ".jsp";
		title = "OrganismDetail";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getOrganismListAutoComplete(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String nameField = "";
		String autoHint = "";
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}

		parameterMap.put("autoHint", autoHint);
		
		map = laboratoryMasterHandlerService.getOrganismListAutoComplete(parameterMap);
		String jsp = "";
		jsp = "responseForOrganismGrid";
		return new ModelAndView(jsp,"map",map);
	}
	
	public ModelAndView getSensitivityListAutoComplete(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String nameField = "";
		String autoHint = "";
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}

		parameterMap.put("autoHint", autoHint);
		
		map = laboratoryMasterHandlerService.getSensitivityListAutoComplete(parameterMap);
		String jsp = "";
		jsp = "responseForSensitivityGrid";
		return new ModelAndView(jsp,"map",map);
	}

	public LaboratoryMasterHandlerService getLaboratoryMasterHandlerService() {
		return laboratoryMasterHandlerService;
	}

	public void setLaboratoryMasterHandlerService(
			LaboratoryMasterHandlerService laboratoryMasterHandlerService) {
		this.laboratoryMasterHandlerService = laboratoryMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
