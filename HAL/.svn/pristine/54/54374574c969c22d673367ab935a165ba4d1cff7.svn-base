package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hms.itax.pojo.ItaxDetailsYearly;
import jkt.hms.itax.pojo.ItaxPayElementsPojo;
import jkt.hms.masters.business.HrEmployeeInvestment;
import jkt.hms.masters.business.HrEmployeeOtherEarning;
import jkt.hms.masters.business.HrEmployeePayElements;
import jkt.hms.masters.business.HrEmployeePayStructure;
import jkt.hms.masters.business.HrItaxDetails;
import jkt.hms.masters.business.HrItaxHeader;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.HrMasInvestmentType;
import jkt.hms.masters.business.HrMasItaxCheckCode;
import jkt.hms.masters.business.HrMasItaxExemption;
import jkt.hms.masters.business.HrMasItaxIncomeCode;
import jkt.hms.masters.business.HrMasItaxSecInvestment;
import jkt.hms.masters.business.HrMasItaxSlab;
import jkt.hms.masters.business.HrMasItaxSurcharge;
import jkt.hms.masters.business.HrMasSurcharge;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.IncomeTaxMasHandlerService;
import jkt.hms.util.IncomeTaxUtil;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;



public class IncomeTaxMasController extends MultiActionController {
 private IncomeTaxMasHandlerService incomeTaxMasHandlerService= null;
 private CommonMasterHandlerService commonMasterHandlerService = null;
 
 
public CommonMasterHandlerService getCommonMasterHandlerService() {
	return commonMasterHandlerService;
}

public void setCommonMasterHandlerService(
		CommonMasterHandlerService commonMasterHandlerService) {
	this.commonMasterHandlerService = commonMasterHandlerService;
}

public IncomeTaxMasHandlerService getIncomeTaxMasHandlerService() 
{
	return incomeTaxMasHandlerService;
}

public void setIncomeTaxMasHandlerService(IncomeTaxMasHandlerService incomeTaxMasHandlerService) {
	this.incomeTaxMasHandlerService = incomeTaxMasHandlerService;
}
 



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


//=================================Surcharge========================================
@SuppressWarnings("unchecked")
public ModelAndView showSurchargeJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map =new HashMap<String, Object>();
	map = incomeTaxMasHandlerService.showSurchargeJsp();
	String jsp="hr_surcharge";
	jsp += ".jsp";
	title = "Surcharge";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
}

@SuppressWarnings("unchecked")
public ModelAndView addSurcharge(HttpServletRequest request, HttpServletResponse response) 
{
	
	Map<String,Object> map=new HashMap<String,Object>();
	HrMasSurcharge  hrMasSurcharge=new HrMasSurcharge();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	String code = "";
	String name = "";
	if (request.getParameter(CODE) != null) {
		code = (request.getParameter(CODE));
	}
	if (request.getParameter(SEARCH_NAME) != null) {
		name = (request.getParameter(SEARCH_NAME));
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

	List surchargeCodeList = new ArrayList();
	List surchargeNameList = new  ArrayList();

	if(listMap.get("duplicateGeneralCodeList") != null){
		surchargeCodeList = (List)listMap.get("duplicateGeneralCodeList");
	}
	if(listMap.get("duplicateGeneralNameList") != null){
		surchargeNameList = (List)listMap.get("duplicateGeneralNameList");
	}
	boolean successfullyAdded = false;

	if((surchargeCodeList.size() == 0 || surchargeCodeList == null) && (surchargeNameList.size() == 0 || surchargeNameList == null))
	{
		hrMasSurcharge.setSurchargeCode(code);
		hrMasSurcharge.setSurchargeDescription(name);
		hrMasSurcharge.setStatus("y");
		hrMasSurcharge.setLastChgBy(changedBy);
		hrMasSurcharge.setLastChgDate(currentDate);
		hrMasSurcharge.setLastChgTime(currentTime);
		
		successfullyAdded = incomeTaxMasHandlerService.addSurcharge(hrMasSurcharge);		

		if(successfullyAdded)
		{
			message="Record Added Successfully !!";
		}
		else
		{
			message="Try Again !!";
		}
	}

	else if((surchargeCodeList.size() != 0 || surchargeCodeList != null) || (surchargeNameList.size() != 0) || surchargeNameList != null){

		if((surchargeCodeList.size() != 0 || surchargeCodeList != null) && (surchargeNameList.size() == 0 || surchargeNameList == null)){

			message = "Surcharge Description already exists.";
		}
		else if((surchargeNameList.size() != 0 || surchargeNameList != null) && (surchargeCodeList.size() == 0 || surchargeCodeList == null) ){

			message = "Surcharge Code already exists.";
		}
		else if((surchargeCodeList.size() != 0 || surchargeCodeList != null) && (surchargeNameList.size() != 0 || surchargeNameList != null)){

			message = "surcharge Description and Surcharge code already exist.";
		}
	}
	url = "/hms/hrms/incomeTaxMaster?method=showSurchargeJsp";

	try{
		map = incomeTaxMasHandlerService.showSurchargeJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	  jsp="hr_surcharge";
	  title="Add Surcharge";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
  }

@SuppressWarnings("unchecked")
public ModelAndView editSurcharge(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();
	HrMasSurcharge hrMasSurcharge=new HrMasSurcharge();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	String code=null;
	String name=null;
	int surchargeId=0;
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		surchargeId =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	
	if (request.getParameter(CODE) != null) {
		code = (request.getParameter(CODE));
	}
	if (request.getParameter(SEARCH_NAME) != null) {
		name = (request.getParameter(SEARCH_NAME));
	
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
		System.out.println("title:"+title);
	}
	if(request.getParameter("pojoName") != null){
		pojoName = request.getParameter("pojoName"); 
		System.out.println("pojoName:"+pojoName);
	}
	if(request.getParameter("pojoPropertyName") != null){
		pojoPropertyName = request.getParameter("pojoPropertyName"); 
		System.out.println("pojoPropertyName:"+pojoPropertyName);
	}
	
	if(request.getParameter("pojoPropertyCode") != null){
		pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		System.out.println("pojoPropertyCode:"+pojoPropertyCode);
	}
	

	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);

	generalMap.put("id", surchargeId);
	generalMap.put("code", code);
	generalMap.put("name", name);
	
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);
	

	generalMap.put("flag", true);
	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
    List existingSurchargeList = (List)listMap.get("duplicateGeneralCodeList");
	boolean dataUpdated=false;
	if(existingSurchargeList.size() == 0)
	{
	dataUpdated=incomeTaxMasHandlerService.editSurcharge(generalMap);
	if(dataUpdated==true){
		message="Data updated Successfully !!";
	}
	else{
		message="Data Cant be updated !!";
	}
	} 
	else if(existingSurchargeList.size() > 0){
		message = "Name already exists.";
	}
	url = "/hms/hrms/incomeTaxMaster?method=showSurchargeJsp";

	try{
		map = incomeTaxMasHandlerService.showSurchargeJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	  jsp="hr_surcharge";
	  title="Add Edit Surcharge";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}



@SuppressWarnings("unchecked")
public ModelAndView searchSurcharge(HttpServletRequest request,HttpServletResponse response)
{
	String code="";
	String name="";
	String searchField="";
	int searchId =1;
	Map<String, Object> map=new HashMap<String, Object>();
	
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		code =request.getParameter(CODE);
	}
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		name =request.getParameter(SEARCH_NAME);
	}
	
	try {
		if(request.getParameter(SEARCH_FIELD) !=null && !(request.getParameter(SEARCH_FIELD).equals(""))) {
			searchField =request.getParameter(SEARCH_FIELD);
		}
		if(request.getParameter(SELECTED_RADIO) !=null && !(request.getParameter(SELECTED_RADIO).equals(""))) {
			searchId =Integer.parseInt(request.getParameter(SELECTED_RADIO));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	if(searchId ==1) {
		code =searchField;
		name =null;
	}else {
		code = null;
		name =searchField;
		
	}
	
	map =incomeTaxMasHandlerService.searchSurcharge(code, name);
	
	String jsp="hr_surcharge";
	jsp += ".jsp";
	title ="Surcharge Master";
	map.put("name", name);
	map.put("code", code);
	
	map.put("search", "search");
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);

}


public ModelAndView deleteSurcharge(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	int surchargeId=0;
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
		surchargeId =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	if(request.getParameter("title") != null){
		title = request.getParameter("title"); 
	}
	if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
		changedBy = request.getParameter(CHANGED_BY);
	}
	if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
	}
	if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		currentTime = request.getParameter(CHANGED_TIME);
	}
	changedDate= new Date();
	changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
	
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);
	boolean dataDeleted=false;
	dataDeleted=incomeTaxMasHandlerService.deleteSurcharge(surchargeId,generalMap);
	if (dataDeleted==true)
	{
		message="Record is InActivated successfully !!";
	}
	else{
		message="Record is Activated successfully !!";
	}
	
	try{
		map = incomeTaxMasHandlerService.showSurchargeJsp();
	   
	  }catch (Exception e) {
	   e.printStackTrace();
	  }
	  jsp="hr_surcharge";
	  title="Delete Surcharge Master";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}


//=================================Other Income Code========================================

@SuppressWarnings("unchecked")
public ModelAndView showOtherIncomeCodeJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map =new HashMap<String, Object>();
	map = incomeTaxMasHandlerService.showOtherIncomeCodeJsp();
	String jsp="hr_other_income_code";
	jsp += ".jsp";
	title = "Other Income Code";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
}
@SuppressWarnings("unchecked")
public ModelAndView searchOtherIncomeCode(HttpServletRequest request,HttpServletResponse response)
{
	
	String code="";
	String name="";
	String searchField="";
	int searchId =1;
	Map<String, Object> map=new HashMap<String, Object>();
	
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		code =request.getParameter(CODE);
	}
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		name =request.getParameter(SEARCH_NAME);
	}
	
	try {
		if(request.getParameter(SEARCH_FIELD) !=null && !(request.getParameter(SEARCH_FIELD).equals(""))) {
			searchField =request.getParameter(SEARCH_FIELD);
		}
		if(request.getParameter(SELECTED_RADIO) !=null && !(request.getParameter(SELECTED_RADIO).equals(""))) {
			searchId =Integer.parseInt(request.getParameter(SELECTED_RADIO));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	if(searchId ==1) {
		code =searchField;
		name =null;
	}else {
		code = null;
		name =searchField;
		
	}
	
	map =incomeTaxMasHandlerService.searchOtherIncomeCode(code, name);
	
	String jsp="hr_other_income_code";
	jsp += ".jsp";
	title ="Other Income Code Master";
	map.put("name", name);
	map.put("code", code);
	
	map.put("search", "search");
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);

}
@SuppressWarnings("unchecked")
public ModelAndView addOtherIncomeCode(HttpServletRequest request, HttpServletResponse response) 
{
	
	Map<String,Object> map=new HashMap<String,Object>();
	HrMasItaxIncomeCode  hrMasItaxIncomeCode=new HrMasItaxIncomeCode();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	String code = "";
	String name = "";
	if (request.getParameter(CODE) != null) {
		code = (request.getParameter(CODE));
	}
	if (request.getParameter(SEARCH_NAME) != null) {
		name = (request.getParameter(SEARCH_NAME));
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

	List otherIncomeCodeList = new ArrayList();
	List otherIncomeNameList = new  ArrayList();

	if(listMap.get("duplicateGeneralCodeList") != null){
		otherIncomeCodeList = (List)listMap.get("duplicateGeneralCodeList");
	}
	if(listMap.get("duplicateGeneralNameList") != null){
		otherIncomeNameList = (List)listMap.get("duplicateGeneralNameList");
	}
	boolean successfullyAdded = false;

	if((otherIncomeCodeList.size() == 0 || otherIncomeCodeList == null) && (otherIncomeNameList.size() == 0 || otherIncomeNameList == null))
	{
		hrMasItaxIncomeCode.setIncomeCode(code);
		hrMasItaxIncomeCode.setIncomeDesc(name);
		hrMasItaxIncomeCode.setStatus("y");
		hrMasItaxIncomeCode.setLastChgBy(changedBy);
		hrMasItaxIncomeCode.setLastChgDate(currentDate);
		hrMasItaxIncomeCode.setLastChgTime(currentTime);
		
		successfullyAdded = incomeTaxMasHandlerService.addOtherIncomeCode(hrMasItaxIncomeCode);		

		if(successfullyAdded)
		{
			message="Record Added Successfully !!";
		}
		else
		{
			message="Try Again !!";
		}
	}

	else if((otherIncomeCodeList.size() != 0 || otherIncomeCodeList != null) || (otherIncomeNameList.size() != 0) || otherIncomeNameList != null){

		if((otherIncomeCodeList.size() != 0 || otherIncomeCodeList != null) && (otherIncomeNameList.size() == 0 || otherIncomeNameList == null)){

			message = "Other Income Description already exists.";
		}
		else if((otherIncomeNameList.size() != 0 || otherIncomeNameList != null) && (otherIncomeCodeList.size() == 0 || otherIncomeCodeList == null) ){

			message = "Other Income Code already exists.";
		}
		else if((otherIncomeCodeList.size() != 0 || otherIncomeCodeList != null) && (otherIncomeNameList.size() != 0 || otherIncomeNameList != null)){

			message = "Other Income Description and Other Income code already exist.";
		}
	}
	url = "/hms/hrms/incomeTaxMaster?method=showOtherIncomeCodeJsp";

	try{
		map = incomeTaxMasHandlerService.showOtherIncomeCodeJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	  jsp="hr_other_income_code";
	  title="Add Other Income Code";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}
@SuppressWarnings("unchecked")
public ModelAndView editOtherIncomeCode(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();
	HrMasItaxIncomeCode hrMasIncomeCode=new HrMasItaxIncomeCode();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	String code=null;
	String name=null;
	int otherIncomeCodeId=0;
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		otherIncomeCodeId =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	
	if (request.getParameter(CODE) != null) {
		code = (request.getParameter(CODE));
	}
	if (request.getParameter(SEARCH_NAME) != null) {
		name = (request.getParameter(SEARCH_NAME));
	
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

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);
	generalMap.put("id", otherIncomeCodeId);
	generalMap.put("code", code);
	generalMap.put("name", name);
	generalMap.put("changedBy", changedBy);
	
	
	

	generalMap.put("flag", true);
	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
  List existingSurchargeList = (List)listMap.get("duplicateGeneralCodeList");
	boolean dataUpdated=false;
	if(existingSurchargeList.size() == 0)
	{
	dataUpdated=incomeTaxMasHandlerService.editOtherIncomeCode(generalMap);
	if(dataUpdated==true){
		message="Data updated Successfully !!";
	}
	else{
		message="Data Cant be updated !!";
	}
	} 
	else if(existingSurchargeList.size() > 0){
		message = "Name already exists.";
	}
	url = "/hms/hms/incomeTaxMaster?method=showOtherIncomeCodeJsp";

	try{
		map = incomeTaxMasHandlerService.showOtherIncomeCodeJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	  jsp="hr_other_income_code";
	  title="Edit Other Income Code";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}
public ModelAndView deleteOtherIncomeCode(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	int otehrIncomeCodeId=0;
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
		otehrIncomeCodeId =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	if(request.getParameter("title") != null){
		title = request.getParameter("title"); 
	}
	if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
		changedBy = request.getParameter(CHANGED_BY);
	}

	changedDate= new Date();
	if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		currentTime = request.getParameter(CHANGED_TIME);
	}
	changedDate= new Date();
	changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
	
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);
	boolean dataDeleted=false;
	dataDeleted=incomeTaxMasHandlerService.deleteOtherIncomeCode(otehrIncomeCodeId,generalMap);
	if (dataDeleted==true)
	{
		message="Record is InActivated successfully !!";
	}
	else{
		message="Record is Activated successfully !!";
	}
	
	try{
		map = incomeTaxMasHandlerService.showOtherIncomeCodeJsp();
	   
	  }catch (Exception e) {
	   e.printStackTrace();
	  }
	  jsp="hr_other_income_code";
	  title="Delete Other Income Code Master";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}




public ModelAndView showEmployeeOtherEarningJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map =new HashMap<String, Object>();
	Map<String, Object> detailMap =new HashMap<String, Object>();
	HttpSession session = request.getSession();
	int centreId=0;
	if(session.getAttribute("hospitalId") != null){
		centreId = (Integer)session.getAttribute("hospitalId");
		
	}
	detailMap.put("centreId", centreId);
	map = incomeTaxMasHandlerService.showEmployeeOtherEarningJsp(detailMap);
	String jsp="hr_employeeOtherEarnings";
	jsp += ".jsp";
	title = "Employee Other Earning/Deduction";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
	
}
@SuppressWarnings("unchecked")
public ModelAndView addEmployeeOtherEarning(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();
	HttpSession session = request.getSession();
	Users changedBy = null;
	Map<String, Object> detailMap =new HashMap<String, Object>();

	int centreId=0;
	if(session.getAttribute("hospitalId") != null){
		centreId = (Integer)session.getAttribute("hospitalId");
		
	}
	detailMap.put("centreId", centreId);
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	Date fromDate=null;
	Date toDate=null;
	String checkCode="";
	int financialYear=0;
	String incomeAmount="";
	Date incomeDate=null;
	String empId="";
	
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		code =request.getParameter(CODE);
	}
	
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		empId =request.getParameter(SEARCH_NAME);
	}
	
	if(request.getParameter("checkCode") !=null && !(request.getParameter("checkCode").equals(""))) {
		checkCode =request.getParameter("checkCode");
	}
	
	if(request.getParameter("financialYear") !=null && !(request.getParameter("financialYear").equals("0"))) {
		financialYear =Integer.parseInt(request.getParameter("financialYear"));
	}
	
	if(request.getParameter("incomeAmount") !=null && !(request.getParameter("incomeAmount").equals(""))) {
		incomeAmount =request.getParameter("incomeAmount");
	}
	
	if(request.getParameter("incomeDate") !=null && !(request.getParameter("incomeDate").equals(""))) {
		incomeDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("incomeDate"));
	}
	
	
	if(session.getAttribute("users") != null){
		changedBy = (Users)session.getAttribute("users");
		
	}
	
	if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		
	}
	if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		currentTime = request.getParameter(CHANGED_TIME);
		
	}
	if(request.getParameter("title") != null){
		title = request.getParameter("title"); 
		System.out.println("title:"+title);
	}
	if(request.getParameter("pojoName") != null){
		pojoName = request.getParameter("pojoName"); 
		System.out.println("pojoName:"+pojoName);
	}
	if(request.getParameter("pojoPropertyName") != null){
		pojoPropertyName = request.getParameter("pojoPropertyName"); 
		System.out.println("pojoPropertyName:"+pojoPropertyName);
	}
	
	if(request.getParameter("pojoPropertyCode") != null){
		pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		System.out.println("pojoPropertyCode:"+pojoPropertyCode);
	}
	generalMap.put("code", code);
	generalMap.put("name", name);

	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);

	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);

	List surChargeTypeCodeList = new ArrayList();
	List surChargeTypeNameList = new  ArrayList();

	if(listMap.get("duplicateGeneralCodeList") != null){
		surChargeTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
	}
	if(listMap.get("duplicateGeneralNameList") != null){
		surChargeTypeNameList = (List)listMap.get("duplicateGeneralNameList");
	}
	boolean successfullyAdded = false;

	if((surChargeTypeCodeList.size() == 0 || surChargeTypeCodeList == null) && (surChargeTypeNameList.size() == 0 || surChargeTypeNameList == null))
	{
		HrEmployeeOtherEarning hrEmployeeOtherEarning = new HrEmployeeOtherEarning();
		hrEmployeeOtherEarning.setId(new Integer(code));
		
			
		MasStoreFinancial hrMasFinancialYear = new MasStoreFinancial();
		hrMasFinancialYear.setId(financialYear);
		hrEmployeeOtherEarning.setFinancialYear(hrMasFinancialYear);
		
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(new Integer(empId));
		hrEmployeeOtherEarning.setEmp(masEmployee);
		
		HrMasItaxIncomeCode hrMasIncomeCode = new HrMasItaxIncomeCode();
		hrMasIncomeCode.setId(new Integer(code));
		hrEmployeeOtherEarning.setIncomeCode(hrMasIncomeCode);
		
	
		MasHospital mh = new MasHospital();
		mh.setId(centreId);
		hrEmployeeOtherEarning.setHospital(mh);
		
		hrEmployeeOtherEarning.setIncomeAmount(new BigDecimal(incomeAmount));
		hrEmployeeOtherEarning.setIncomeDate(incomeDate);
		hrEmployeeOtherEarning.setStatus("y");
		hrEmployeeOtherEarning.setLastChgBy(changedBy);
		hrEmployeeOtherEarning.setLastChgDate(currentDate);
		hrEmployeeOtherEarning.setLastChgTime(currentTime);
		
		successfullyAdded = incomeTaxMasHandlerService.addEmployeeOtherEarning(hrEmployeeOtherEarning);		

		if(successfullyAdded)
		{
			message="Record Added Successfully !!";
		}
		else
		{
			message="Try Again !!";
		}
	}

	else if((surChargeTypeCodeList.size() != 0 || surChargeTypeCodeList != null) || (surChargeTypeNameList.size() != 0) || surChargeTypeNameList != null){

		if((surChargeTypeCodeList.size() != 0 || surChargeTypeCodeList != null) && (surChargeTypeNameList.size() == 0 || surChargeTypeNameList == null)){

			message = "Year Description already exists.";
		}
		else if((surChargeTypeNameList.size() != 0 || surChargeTypeNameList != null) && (surChargeTypeCodeList.size() == 0 || surChargeTypeCodeList == null) ){

			message = "Financial year already exists.";
		}
		else if((surChargeTypeCodeList.size() != 0 || surChargeTypeCodeList != null) && (surChargeTypeNameList.size() != 0 || surChargeTypeNameList != null)){

			message = "Year Description and Financial year already exist.";
		}
	}
	url = "/hms/hms/incomeTaxMaster?method=showEmployeeOtherEarningJsp";

	try{
		map = incomeTaxMasHandlerService.showEmployeeOtherEarningJsp(detailMap);
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	  jsp="hr_employeeOtherEarnings";
	  title="Employee Other Earnings";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);

}
@SuppressWarnings("unchecked")
public ModelAndView editEmployeeOtherEarning(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();
	Map<String, Object> detailMap =new HashMap<String, Object>();
	HttpSession session = request.getSession();

	Users changedBy = null;
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	Date fromDate=null;
	Date toDate=null;
	String checkCode="";
	int financialYear=0;
	String incomeAmount="";
	Date incomeDate=null;
	String empId="";
	

	int centreId=0;
	if(session.getAttribute("hospitalId") != null){
		centreId = (Integer)session.getAttribute("hospitalId");
		
	}
	detailMap.put("centreId", centreId);
	
	int id=0;
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		id =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		code =request.getParameter(CODE);
	}
	
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		empId =request.getParameter(SEARCH_NAME);
	}
	
	
	if(request.getParameter("checkCode") !=null && !(request.getParameter("checkCode").equals(""))) {
		checkCode =request.getParameter("checkCode");
	}

	if(request.getParameter("financialYear") !=null && !(request.getParameter("financialYear").equals("0"))) {
		financialYear =Integer.parseInt(request.getParameter("financialYear"));
	}
	
	if(request.getParameter("incomeAmount") !=null && !(request.getParameter("incomeAmount").equals(""))) {
		incomeAmount =request.getParameter("incomeAmount");
	}
	
	if(request.getParameter("incomeDate") !=null && !(request.getParameter("incomeDate").equals(""))) {
		incomeDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("incomeDate"));
	}
	
	
	
	if(session.getAttribute("users") != null){
		changedBy = (Users)session.getAttribute("users");
		
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
	
	generalMap.put("id",id);
	generalMap.put("empId", empId);
	generalMap.put("checkCode", checkCode);
	generalMap.put("incomeAmount", incomeAmount);
	generalMap.put("code", code);
	generalMap.put("incomeDate", incomeDate);
	generalMap.put("financialYear",financialYear);

	
	generalMap.put("currentTime", currentTime);
	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);
	
	generalMap.put("flag", true);
	boolean dataUpdated=false;
	dataUpdated=incomeTaxMasHandlerService.editEmployeeOtherEarning(generalMap);
	System.out.println("dataUpdated==in ds===="+dataUpdated);
	if(dataUpdated==true){
		message="Data updated Successfully !!";
	}
	else{
		message="Data Cant be updated !!";
	}
	url = "/hms/hms/incomeTaxMaster?method=showIncomeTaxSurchargeJsp";

	try{
		map = incomeTaxMasHandlerService.showEmployeeOtherEarningJsp(detailMap);
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	   jsp="hr_employeeOtherEarnings";
	   title="Employee Other Earnings";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}
@SuppressWarnings("unchecked")
public ModelAndView deleteEmployeeOtherEarning(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();

	
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Map<String, Object> detailMap =new HashMap<String, Object>();
	String message=null;
	Users changedBy = null;
	String changedTime = "";
	Date changedDate = null;
	String flag =""; 
	int id=0;
	String checkCode="";
	String financialYear="";
	String incomeAmount="";
	Date incomeDate=null;
	String empId="";

	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		id =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	if(request.getParameter("title") != null){
		title = request.getParameter("title"); 
	}
	
	if(session.getAttribute("users") != null){
		changedBy = (Users)session.getAttribute("users");
		
	}
	if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
	}
	if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		currentTime = request.getParameter(CHANGED_TIME);
	}
	changedDate= new Date();
	changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
	generalMap.put("id", id);
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);
	boolean dataDeleted=false;
	dataDeleted=incomeTaxMasHandlerService.deleteEmployeeOtherEarning(generalMap);
	if (dataDeleted==true)
	{
		message="Record is InActivated successfully !!";
	}
	else{
		message="Record is Activated successfully !!";
	}
	
	
	try{
		int centreId=0;
		if(session.getAttribute("hospitalId") != null){
			centreId = (Integer)session.getAttribute("hospitalId");
			
		}
		detailMap.put("centreId", centreId);
		map = incomeTaxMasHandlerService.showEmployeeOtherEarningJsp(detailMap);
	   
	  }catch (Exception e) {
	   e.printStackTrace();
	  }
	  jsp="hr_employeeOtherEarnings";
	  title="Employee Other Earning/Deduction";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}



@SuppressWarnings("unchecked")
public ModelAndView showEmpIndividualInvestJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> detailMap =new HashMap<String, Object>();
	Map<String, Object> map =new HashMap<String, Object>();
	int centreId=0;
	Users user = null;
	MasEmployee employee = null;
	HttpSession session = request.getSession();
	if(session.getAttribute("users")!=null)
	{
		user = (Users)session.getAttribute("users");
		employee = user.getEmployee();
	}
	List<MasStoreFinancial> financialYearList = incomeTaxMasHandlerService.getFinancialYearList();
	
	

	if(session.getAttribute("hospitalId") != null){
		centreId = (Integer)session.getAttribute("hospitalId");	
	}
	detailMap.put("centreId", centreId);
	map = incomeTaxMasHandlerService.showEmployeeInvestmentJsp(detailMap);
	String jsp="hr_empIndividualInvest";
	jsp += ".jsp";
	title = "My Investments";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("employee", employee);
	map.put("financialYearList", financialYearList);
	return new ModelAndView("index","map",map);
}



@SuppressWarnings("unchecked")
public ModelAndView saveEmpIndividualInvestment(HttpServletRequest request,HttpServletResponse response)
{
	Users user = null;
	MasEmployee employee = null;
	Map<String,Object> map=new HashMap<String,Object>();
	Map<String,Object> detailMap=new HashMap<String,Object>();
	int centreId= 0;
	HttpSession session = request.getSession();
	if(session.getAttribute("users")!=null)
	{
		user = (Users)session.getAttribute("users");
		employee = user.getEmployee();
	}
	
	
	if(session.getAttribute("hospitalId") != null){
		centreId = (Integer)session.getAttribute("hospitalId");	
	}
	detailMap.put("centreId", centreId);
	map.put("centreId", centreId);
	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	
	Date toDate=null;
	
	Date incomeDate=null;
	Integer invSec=null;
	int invYear=0;
	int listLen=0;
	int empid=0;
	MultipartFormDataRequest mrequest = null;
	if (MultipartFormDataRequest.isMultipartFormData(request)) {
		try {
			mrequest = new MultipartFormDataRequest(request);
		} catch (UploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	if(mrequest.getParameter("listLen") !=null && !(mrequest.getParameter("listLen").equals(""))) {
		listLen =new Integer(mrequest.getParameter("listLen"));
	}
	MasEmployee emp = new MasEmployee();
	if(mrequest.getParameter("empid") !=null && !(mrequest.getParameter("empid").equals(""))) {
		empid =new Integer(mrequest.getParameter("empid"));
		emp.setId(empid);
	}
	MasStoreFinancial year = new MasStoreFinancial();
	if(mrequest.getParameter("invYear") != null && !(mrequest.getParameter("invYear").equals(""))){
		invYear = new Integer(mrequest.getParameter("invYear"));
		
	}
	year.setId(invYear);
	if(mrequest.getParameter(CHANGED_BY) != null && !(mrequest.getParameter(CHANGED_BY).equals(""))){
		changedBy = mrequest.getParameter(CHANGED_BY);
		
	}
	if(mrequest.getParameter(CHANGED_DATE) != null && !(mrequest.getParameter(CHANGED_DATE).equals(""))){
		currentDate = HMSUtil.dateFormatterDDMMYYYY(mrequest.getParameter(CHANGED_DATE));
		
	}
	if(mrequest.getParameter(CHANGED_TIME) != null && !(mrequest.getParameter(CHANGED_TIME).equals(""))){
		currentTime = mrequest.getParameter(CHANGED_TIME);
		
	}
	System.out.println("listLen>>>"+listLen);
	if(listLen>0)
	{
		List<HrEmployeeInvestment> empInvList = new ArrayList<HrEmployeeInvestment>();
		for(int ilop=1;ilop<=listLen;ilop++)
		{
			BigDecimal amount=null;
			Date invDate=null;
			
			if(mrequest.getParameter("amount"+ilop) !=null && !(mrequest.getParameter("amount"+ilop).equals(""))) {
				amount =new BigDecimal(mrequest.getParameter("amount"+ilop));
			}
			if(mrequest.getParameter("date"+ilop) != null && !(mrequest.getParameter("date"+ilop).equals(""))){
				invDate = HMSUtil.dateFormatterDDMMYYYY(mrequest.getParameter("date"+ilop));
				
			}
			if(mrequest.getParameter("invSec"+ilop) !=null && !(mrequest.getParameter("invSec"+ilop).equals(""))) {
				invSec =new Integer(mrequest.getParameter("invSec"+ilop));
			}
			if(amount != null && invDate != null){
				HrEmployeeInvestment hrEmployeeInvestment = new HrEmployeeInvestment();
				
				
				hrEmployeeInvestment.setEmp(emp);
				hrEmployeeInvestment.setInvYear(year);
				hrEmployeeInvestment.setInvAmount(amount);
				hrEmployeeInvestment.setInvDate(invDate);
				if( invSec!=null && invSec >0){
					HrMasItaxSecInvestment hrMasItaxSecInvestment= new HrMasItaxSecInvestment();
					hrMasItaxSecInvestment.setId(invSec);
					hrEmployeeInvestment.setSecInvest(hrMasItaxSecInvestment);
				}
				
				hrEmployeeInvestment.setLastChgBy(changedBy);
				hrEmployeeInvestment.setLastChgTime(currentTime);
				hrEmployeeInvestment.setLastChgDate(currentDate);
				
				//upload proofs
				MasEmployee employee2 = (MasEmployee)incomeTaxMasHandlerService.loadObject(MasEmployee.class, emp.getId());
				HrMasItaxSecInvestment secInvestment = (HrMasItaxSecInvestment)incomeTaxMasHandlerService.loadObject(HrMasItaxSecInvestment.class, invSec);
				MasStoreFinancial financialYear = (MasStoreFinancial)incomeTaxMasHandlerService.loadObject(MasStoreFinancial.class, invYear);
				String firstName = employee2.getFirstName();
				String uploadURL="";
				uploadURL = getServletContext().getRealPath("/uploads/docITproofs/"+financialYear.getFinancialYear()+"/"+employee2.getEmployeeCode()+"/"+secInvestment.getInvestmentType().getInvestmentDescription()); //properties.getProperty("uploadResume");
				
				System.out.println(uploadURL);
				String whiteList = "*.doc,*.txt,*.rtf,*.DOC,*.TXT,*.RTF,*.jpeg,*.zip,*.rar,*.pdf,*.JPEG,*.ZIP,*.RAR,*.PDF,*.jpg,*.png";
				Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
				

				int id = emp.getId()+ 1;
				String fileNameToBeAssigned = financialYear.getFinancialYear()+"_" +secInvestment.getInvestmentType().getInvestmentDescription()+ "_"+ employee2.getFirstName() +"."+ employee2.getLastName();
				
				List fileUploadedList = null;
				Connection connection = incomeTaxMasHandlerService.getDBConnection();
				fileUploadedList = HMSUtil.uploadDocProof(mrequest, uploadURL, whiteList, fileSizeLimit, fileNameToBeAssigned, connection,RequestConstants.UPLOAD+secInvestment.getInvestmentType().getInvestmentDescription());
				Boolean fileUploaded=false;
				if(fileUploadedList != null && fileUploadedList.size()!=0){
					fileUploaded = (Boolean) fileUploadedList.get(0);
				}
				if(fileUploaded)
				{
					hrEmployeeInvestment.setDocumentSubmitted("y");
				}
				else
				{
					hrEmployeeInvestment.setDocumentSubmitted("n");
				}
				empInvList.add(hrEmployeeInvestment);
				map.put("empid", empid);
				map.put("invYear", invYear);
				map.put("empInvList", empInvList);
				map.put("hrEmployeeInvestment"+ilop, hrEmployeeInvestment);
			}
		
			}

	}
	}

	map = incomeTaxMasHandlerService.saveEmployeeInvestment(map);
	String flag =""+map.get("flag");
	
	String msg="";
	if(flag.equals("true") ){
		msg="Data updated Successfully.";
	}else{
		msg="Data Cant be updated.";
		
	}
	Map map1 = incomeTaxMasHandlerService.showEmployeeInvestmentJsp(detailMap);
	map.putAll(map1);
	List<MasStoreFinancial> financialYearList = incomeTaxMasHandlerService.getFinancialYearList();
	String jsp="hr_empIndividualInvest";
	jsp += ".jsp";
	title = "Employee Investments";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("employee", employee);
	map.put("msg", msg);
	map.put("financialYearList", financialYearList);
	return new ModelAndView("index","map",map);
}
public ModelAndView showEmployeeInvestmentJsp(HttpServletRequest request,HttpServletResponse response)
{
	
	Map<String, Object> map =new HashMap<String, Object>();
	Map<String, Object> detailMap =new HashMap<String, Object>();
	int centreId=0;
	HttpSession session = request.getSession();
	if(session.getAttribute("hospitalId") != null){
		centreId = (Integer)session.getAttribute("hospitalId");
		
	}
	detailMap.put("centreId", centreId);
	map = incomeTaxMasHandlerService.showEmployeeInvestmentJsp(detailMap);
	String jsp="hr_employeeInvestment";
	jsp += ".jsp";
	title = "Employee Investments";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
}

@SuppressWarnings("unchecked")
public ModelAndView checkEmployeeInvestment(HttpServletRequest request,HttpServletResponse response)
{  
	Map<String,Object> map=new HashMap<String,Object>();
	int invYear=0;
	int empid=0;
	int centreId=0;
	HttpSession session = request.getSession();
	if(session.getAttribute("locationId") != null){
		centreId = (Integer)session.getAttribute("locationId");
		
	}
	
	if(request.getParameter("empid1") !=null && !(request.getParameter("empid1").equals(""))) {
		empid =new Integer(request.getParameter("empid1"));
	}
	
	if(request.getParameter("invYear11") != null && !(request.getParameter("invYear11").equals(""))){
		invYear = new Integer(request.getParameter("invYear11"));
	}
	
	map.put("empid", empid);
	map.put("invYear", invYear);
	map.put("centreId", centreId);
	
	map = incomeTaxMasHandlerService.checkEmployeeInvestment(map);
	
	List<HrEmployeeInvestment> existingList = (List)map.get("existingList");
	for(HrEmployeeInvestment empInvestment:existingList){
		String uploadUrl = getServletContext().getRealPath("/uploads/docITproofs/"+ empInvestment.getInvYear().getFinancialYear()+"/"+empInvestment.getEmp().getEmployeeCode()+"/"+empInvestment.getSecInvest().getInvestmentType().getInvestmentDescription());
		List listOfUploadedDocs = getAllUploadedDocs(empInvestment.getSecInvest().getInvestmentType().getInvestmentDescription(),uploadUrl);
		map.put(empInvestment.getSecInvest().getInvestmentType().getInvestmentDescription(), listOfUploadedDocs);
	}
	String jsp="hr_employeeInvestment";
	jsp += ".jsp";
	title = "Employee Investments";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
}

public ModelAndView showITComputationJsp(HttpServletRequest request,HttpServletResponse response)
{  
	Map<String, Object> map =new HashMap<String, Object>();
	Map<String, Object> detailMap =new HashMap<String, Object>();
	int centreId=0;
	HttpSession session = request.getSession();
	if(session.getAttribute("hospitalId") != null){
		centreId = (Integer)session.getAttribute("hospitalId");
		
	}
	detailMap.put("centreId", centreId);
	map = incomeTaxMasHandlerService.showITComputationJsp(detailMap);
	//System.out.println(getServletContext().getRealPath("/Reports/"));
	String jsp="hr_computeIncometTaxJsp";
	jsp += ".jsp";
	title = "Income Tax Computation";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
}

public ModelAndView computeIncomeTaxMonthly(HttpServletRequest request,HttpServletResponse response)
{
	Map parameterMap = new HashMap();
	Integer empId = 0;
	Integer finYrId = 0;
	int centreId=0;
	HttpSession session = request.getSession();
	if(session.getAttribute("hospitalId") != null){
		centreId = (Integer)session.getAttribute("hospitalId");
		
	}
	
	if(request.getParameter(EMPLOYEE_ID)!=null && !request.getParameter(EMPLOYEE_ID).equals(""))
	{
		empId = new Integer(request.getParameter(EMPLOYEE_ID));
		
	}
	if(request.getParameter(RequestConstants.FINANCIAL_YEAR)!=null && !request.getParameter(RequestConstants.FINANCIAL_YEAR).equals(""))
	{
		finYrId = new Integer(request.getParameter(RequestConstants.FINANCIAL_YEAR));
	}
	MasStoreFinancial finyr = (MasStoreFinancial)incomeTaxMasHandlerService.loadObject(MasStoreFinancial.class,finYrId);
	
	parameterMap.put("empId", empId);
	parameterMap.put("finYrId", finYrId);
	parameterMap.put("centreId", centreId);
	List<HrItaxHeader> iTaxHeaderList = incomeTaxMasHandlerService.getITaxHeaderList(parameterMap);
	List<Integer> processedMonths = new ArrayList<Integer>();
	List<Integer> unProcessedMonths = new ArrayList<Integer>();
	
	for(int i=0;i<12;i++)
	{
		unProcessedMonths.add(i);
	}
	Integer lastMonthProcessed = 0;
	HrItaxHeader lastprocessedItaxHeader = null;
	MasEmployee employee = (MasEmployee)incomeTaxMasHandlerService.loadObject(MasEmployee.class, empId);
	for(HrItaxHeader itaxHeader:iTaxHeaderList)
	{
		unProcessedMonths.remove(itaxHeader.getFMonth());
		processedMonths.add(itaxHeader.getFMonth());
	}
	if(processedMonths.size()!=0)
	{
		lastMonthProcessed = Collections.max(processedMonths);
	}
	else
	{
		map = incomeTaxMasHandlerService.showITComputationJsp(parameterMap);
		String jsp="hr_computeIncometTaxJsp"; 
		jsp += ".jsp";
		title = "Income Tax Computation";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "Payroll has not been processed for "+employee.getFirstName()+" "+(employee.getLastName() != null ? employee.getLastName() : "")+" for the financial year "+finyr.getFinancialYear());
		return new ModelAndView("index","map",map);
	}
	BigDecimal taxAlreadyPaid = new BigDecimal(0.0);
	for(HrItaxHeader itaxHeader:iTaxHeaderList)
	{
		taxAlreadyPaid = taxAlreadyPaid.add(itaxHeader.getItax());
		if(itaxHeader.getFMonth().equals(lastMonthProcessed))
		{
			lastprocessedItaxHeader = itaxHeader;
		}
	}
	
	HrEmployeePayStructure payStructure = incomeTaxMasHandlerService.getEmployeePayStructure(empId);
	List<HrEmployeePayElements> employeePayElements = incomeTaxMasHandlerService.getEmployeePayElements(empId);
	List payElementsAmountSum = incomeTaxMasHandlerService.getPayElementsAmountSumList(iTaxHeaderList);
	BigDecimal processedEarnings = new BigDecimal(0.0);
	BigDecimal processeddeductions = new BigDecimal(0.0);
	BigDecimal processedTotalInvestments = new BigDecimal(0.0);
	BigDecimal processedTotalOtherEarnings = new BigDecimal(0.0);
	List<ItaxPayElementsPojo> deductionsList = new ArrayList<ItaxPayElementsPojo>();
	List<ItaxPayElementsPojo> earningsList = new ArrayList<ItaxPayElementsPojo>();
	for(int i=0;i<payElementsAmountSum.size();i++)
	{
		Object[] ar =(Object[]) payElementsAmountSum.get(i);
		
		    BigDecimal totalPayelementAmountForYear = new BigDecimal(0.0);
			BigDecimal monthlyPayelemntAmount = new BigDecimal(0.0);
		    BigDecimal payelemetSum = (BigDecimal)ar[0];
			String payElement = (String)ar[1];
			String elementtype = (String)ar[2];
			String section = (String)ar[3];
			
			System.out.println("payElement" + payElement);
			System.out.println("Amount + " + payelemetSum);
			System.out.println("Element type = " +elementtype);
			System.out.println("Section = " + section);
			
			
			
			for(HrEmployeePayElements payElements:employeePayElements)
			{
				if(payElements.getPayAmount()!=null && payElements.getStatus().equals("y") && payElements.getPayElement().getTaxableElement().equals("y"))
				{
				if(payElements.getPayElement().getPayElementType().equals("Addition") || payElements.getPayElement().getPayElementType().equals("Reimb"))
				{
				   if(payElements.getPayElement().getPayElementDesc().equals(payElement))
				   {
					   monthlyPayelemntAmount = monthlyPayelemntAmount.add(payElements.getPayAmount());
						  
						 
				   }
				   
				}
				if(payElements.getPayElement().getPayElementType().equals("Deduction"))
				{
					 if(payElements.getPayElement().getPayElementDesc().equals(payElement))
					   {
						 monthlyPayelemntAmount = monthlyPayelemntAmount.add(payElements.getPayAmount());
						  
						  
					   }
				}
				}
				
			}
			if(payStructure != null){
			BigDecimal monthlyBasic = payStructure.getBasicPay();
			if(payElement.equals("Basic"))
			{
				System.out.println("payelemt sum basic= " + payelemetSum);
				System.out.println("total = "+monthlyBasic.multiply(new BigDecimal(unProcessedMonths.size())));
				totalPayelementAmountForYear = payelemetSum.add(monthlyBasic.multiply(new BigDecimal(unProcessedMonths.size())));
			}
			else
			{
				totalPayelementAmountForYear = payelemetSum.add(monthlyPayelemntAmount.multiply(new BigDecimal(unProcessedMonths.size())));
			}
			ItaxPayElementsPojo  itaxPayElementsPojo = new ItaxPayElementsPojo();
			itaxPayElementsPojo.setPayElement(payElement);
			
			itaxPayElementsPojo.setAmount(totalPayelementAmountForYear);
			if(elementtype.equals("A") || elementtype.equals("R") || elementtype.equals("0"))
			{
				 processedEarnings = processedEarnings.add(payelemetSum);
				 earningsList.add(itaxPayElementsPojo);
 
			}
			else if(elementtype.equals("D") || elementtype.equals("I") )
			{
				processeddeductions = processeddeductions.add(payelemetSum);
				itaxPayElementsPojo.setSection(section);
				deductionsList.add(itaxPayElementsPojo);
			}
			}	
			
	}
	
	
	for(HrItaxDetails itaxDetails : lastprocessedItaxHeader.getITaxDetailsSet())
	{
		if(itaxDetails.getElementType().equals("I"))
		{
			processedTotalInvestments = processedTotalInvestments.add(itaxDetails.getAmount());
			
		}
		else if(itaxDetails.getElementType().equals("O"))
		{
			processedTotalOtherEarnings = processedTotalOtherEarnings.add(itaxDetails.getAmount());
		}
	}
	System.out.println("processedEarnings" + processedEarnings);
	System.out.println("proDed = " + processeddeductions );
	System.out.println("invest="+processedTotalInvestments);
	System.out.println("processedTotalOtherEarnings="+processedTotalOtherEarnings);
	
	BigDecimal earningsForRemMonths = new BigDecimal(0.0);
	BigDecimal dedForRemmonths = new BigDecimal(0.0);
	
	
	
	BigDecimal monthlyTotalEarning = new BigDecimal(0.0);
	BigDecimal monthlyTotalDed = new BigDecimal(0.0);
	for(HrEmployeePayElements payElements:employeePayElements)
	{
		if(payElements.getPayAmount()!=null && payElements.getStatus().equals("y") && payElements.getPayElement().getTaxableElement().equals("y"))
		{
		if(payElements.getPayElement().getPayElementType().equals("Addition") || payElements.getPayElement().getPayElementType().equals("Reimb"))
		{
			monthlyTotalEarning = monthlyTotalEarning.add(payElements.getPayAmount());
		}
		if(payElements.getPayElement().getPayElementType().equals("Deduction"))
		{
			monthlyTotalDed = monthlyTotalDed.add(payElements.getPayAmount()); 
		}
		}
		
	}
	if(payStructure != null){
	monthlyTotalEarning = monthlyTotalEarning.add(payStructure.getBasicPay());
	}else{
		monthlyTotalEarning = monthlyTotalEarning.add(new BigDecimal("0"));
	}
	earningsForRemMonths = monthlyTotalEarning.multiply(new BigDecimal(unProcessedMonths.size()));
	dedForRemmonths = monthlyTotalDed.multiply(new BigDecimal(unProcessedMonths.size()));
	
	BigDecimal totalYearEarings = processedEarnings.add(earningsForRemMonths);
	BigDecimal totalYearDed     = processeddeductions.add(dedForRemmonths); 

	System.out.println("------------yearly earnings pay elemnt wise---------------------------------");
	for(ItaxPayElementsPojo o:earningsList)
	{
		System.out.println(o.getPayElement() + "=" + o.getAmount());
	}
	System.out.println("--------------------yearly deductions pay elemnt wise-------------------------------");
	for(ItaxPayElementsPojo o:deductionsList)
	{
		System.out.println(o.getPayElement() + "=" + o.getAmount() + "  - " +o.getSection());
	}
	
	System.out.println("--------------------------------------------------");
	System.out.println("total Yearly earnings = " + totalYearEarings);
	System.out.println("total yearly ded = " + totalYearDed );
	System.out.println("invest="+processedTotalInvestments);
	System.out.println("TotalOtherEarnings="+processedTotalOtherEarnings);
	
	Map<String,Object> incometaxMap = new HashMap();
	incometaxMap.put("totalYearEarings", totalYearEarings);
	incometaxMap.put("totalYearDed", totalYearDed);
	incometaxMap.put("processedTotalInvestments", processedTotalInvestments);
	incometaxMap.put("processedTotalOtherEarnings", processedTotalOtherEarnings);
	incometaxMap.put("financialYear", finyr);
	incometaxMap.put("employee",employee);
	incometaxMap.put("incomeTaxMasHandlerService", incomeTaxMasHandlerService);
	
	Map returnMap = IncomeTaxUtil.calculateIncomeTax(incometaxMap);
	
	BigDecimal taxableSalary = (BigDecimal)returnMap.get("taxableSalary");
	BigDecimal incomeTaxTotal = (BigDecimal)returnMap.get("taxOnTotalIncome");
	BigDecimal surcharge = (BigDecimal)returnMap.get("surcharge");
	BigDecimal eduCess   = (BigDecimal)returnMap.get("eduCess");
	
		
	ItaxDetailsYearly itaxDetailsYearly = new ItaxDetailsYearly();
	JRBeanCollectionDataSource deductionsDataSource = new JRBeanCollectionDataSource(deductionsList);
	JRBeanCollectionDataSource earningdataSource = new JRBeanCollectionDataSource(earningsList);
	itaxDetailsYearly.setDeductionsDataSource(deductionsDataSource);
	itaxDetailsYearly.setEarningsDataSource(earningdataSource);
	itaxDetailsYearly.setEmployee(employee);
	itaxDetailsYearly.setFinancialYear(finyr);
	itaxDetailsYearly.setTaxableSalary(taxableSalary);
	itaxDetailsYearly.setTotalTax(incomeTaxTotal);
	itaxDetailsYearly.setSurcharge(surcharge);
	itaxDetailsYearly.setEduCess(eduCess);
	itaxDetailsYearly.setTaxAlreadyPaid(taxAlreadyPaid);
	itaxDetailsYearly.setRemainingPeriod(unProcessedMonths.size());
	if(lastMonthProcessed>3)
	itaxDetailsYearly.setLastProcessedMonth(IncomeTaxUtil.months[lastMonthProcessed]+", "+finyr.getFinancialYear().substring(0,4));
	else
		itaxDetailsYearly.setLastProcessedMonth(IncomeTaxUtil.months[lastMonthProcessed]+", "+finyr.getFinancialYear().substring(5,9));	
	List<ItaxDetailsYearly> listForReport = new ArrayList<ItaxDetailsYearly>();
	listForReport.add(itaxDetailsYearly);
	
	
	
	Map parameters = new HashMap();
	
	parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
	
	String userHome = getServletContext().getRealPath("");             
    String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
    parameters.put("path", imagePath);
	
	byte[] bytes = null; 
	
	try
	{
		JasperReport jasperReport = HMSUtil.getCompiledReport(getServletContext(),"ITComputation");
		JRBeanCollectionDataSource dsForReport = new JRBeanCollectionDataSource(listForReport);
		bytes = JasperRunManager.runReportToPdf(jasperReport,parameters,dsForReport);
		
	}
	catch(Exception e)
	{
		e.printStackTrace(); 
	}
	

	response.setContentType("application/pdf");
	response.setHeader("Content-Disposition","attachment;filename="+"ITCompSheet_"+employee.getFirstName());

	int b = bytes.length;
	response.setContentLength(b);
	try
	{
		ServletOutputStream  outputStream = response.getOutputStream();
		
		outputStream.write(bytes, 0, bytes.length);
		outputStream.flush();
		outputStream.close();
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	
	map = incomeTaxMasHandlerService.showITComputationJsp(parameterMap);
	String jsp="hr_computeIncometTaxJsp"; 
	jsp += ".jsp";
	title = "Income Tax Computation";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
	
}





@SuppressWarnings("unchecked")
public ModelAndView showIncomeTaxSlabJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map =new HashMap<String, Object>();
	map = incomeTaxMasHandlerService.showIncomeTaxSlabJsp();
	String jsp="hr_incomeTaxSlab";
	jsp += ".jsp";
	title = "Income Tax Slab";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
}
@SuppressWarnings("unchecked")
public ModelAndView searchItaxSlabMaster(HttpServletRequest request,HttpServletResponse response)
{
	Float taxRate=null;
	String financialYear="";
	String searchField="";
	String searchField2="";
	int searchId =1;
	Map<String, Object> map=new HashMap<String, Object>();
	
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		taxRate =(new Float(request.getParameter(CODE)));
	}
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		financialYear =request.getParameter(SEARCH_NAME);
	}
	
	try {
		if(request.getParameter(SEARCH_FIELD) !=null && !(request.getParameter(SEARCH_FIELD).equals(""))) {
			searchField =request.getParameter(SEARCH_FIELD);
		}
		if(request.getParameter(RequestConstants.SEARCH_FIELD_NEXT) !=null && !(request.getParameter(RequestConstants.SEARCH_FIELD_NEXT).equals(""))) {
			searchField2 =request.getParameter(RequestConstants.SEARCH_FIELD_NEXT);
		}
		if(request.getParameter(SELECTED_RADIO) !=null && !(request.getParameter(SELECTED_RADIO).equals(""))) {
			searchId =Integer.parseInt(request.getParameter(SELECTED_RADIO));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	if(searchId ==1) {
		financialYear =searchField2;
		taxRate =null;
	}else {
		try{
		taxRate =new Float(searchField);
		}catch (NumberFormatException e) {
			taxRate=100f;
		}
		financialYear =null;
		
	}
	
	
	map =incomeTaxMasHandlerService.searchItaxSlabMaster(taxRate, financialYear);
	
	String jsp="hr_incomeTaxSlab";
	jsp += ".jsp";
	title ="Income Tax Slab Master";
	map.put("financialYear", financialYear);
	map.put("taxRate", taxRate);
	
	map.put("search", "search");
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
	
}
@SuppressWarnings("unchecked")
public ModelAndView addIncomeTaxSlabMaster(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();
	HrMasItaxSlab hrMasItaxSlab=new HrMasItaxSlab();

	String changedBy = "";
	String lowerLimit="";
	String upperLimit = "";
	String citizen="";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		code =request.getParameter(CODE);
	}
	
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		name =request.getParameter(SEARCH_NAME);
	}
	if(request.getParameter(LOWER_LIMIT) !=null && !(request.getParameter(LOWER_LIMIT).equals(""))) {
		lowerLimit =request.getParameter(LOWER_LIMIT);
	}
	
	if(request.getParameter(UPPER_LIMIT) !=null && !(request.getParameter(UPPER_LIMIT).equals(""))) {
		upperLimit =request.getParameter(UPPER_LIMIT);
	}
	
	if(request.getParameter("citizen") !=null && !(request.getParameter("citizen").equals(""))) {
		citizen =request.getParameter("citizen");
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
		System.out.println("title:"+title);
	}
	if(request.getParameter("pojoName") != null){
		pojoName = request.getParameter("pojoName"); 
		System.out.println("pojoName:"+pojoName);
	}
	if(request.getParameter("pojoPropertyName") != null){
		pojoPropertyName = request.getParameter("pojoPropertyName"); 
		System.out.println("pojoPropertyName:"+pojoPropertyName);
	}
	
	if(request.getParameter("pojoPropertyCode") != null){
		pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		System.out.println("pojoPropertyCode:"+pojoPropertyCode);
	}
	generalMap.put("code", code);
	generalMap.put("name", name);

	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);

	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);

	List iTaxSlabTypeCodeList = new ArrayList();
	List iTaxSlabTypeNameList = new  ArrayList();

	if(listMap.get("duplicateGeneralCodeList") != null){
		iTaxSlabTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
	}
	if(listMap.get("duplicateGeneralNameList") != null){
		iTaxSlabTypeNameList = (List)listMap.get("duplicateGeneralNameList");
	}
	boolean successfullyAdded = false;
	
	MasStoreFinancial hrMasFinancialYearTemp = new MasStoreFinancial();
	hrMasFinancialYearTemp.setId(new Integer(name));
	hrMasItaxSlab.setFinancialYear(hrMasFinancialYearTemp);
	hrMasItaxSlab.setTaxRate(new BigDecimal(code));
	hrMasItaxSlab.setStatus("y");
	hrMasItaxSlab.setLastChgBy(changedBy);
	hrMasItaxSlab.setLastChgDate(currentDate);
	hrMasItaxSlab.setLastChgTime(currentTime);
	hrMasItaxSlab.setLowerLimit(new BigDecimal(lowerLimit));
	hrMasItaxSlab.setUpperLimit(new BigDecimal(upperLimit));
	hrMasItaxSlab.setCitizen(citizen);
	
	successfullyAdded = incomeTaxMasHandlerService.addIncomeTaxSlabMaster(hrMasItaxSlab);		

	if(successfullyAdded)
	{
		message="Record Added Successfully !!";
	}
	else
	{
		message="Try Again !!";
	}

	

	try{
		map = incomeTaxMasHandlerService.showIncomeTaxSlabJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	   String jsp="hr_incomeTaxSlab";
		jsp += ".jsp";
		title ="Income Tax Slab Master";	  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("url", url);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);

}
public ModelAndView editIncomeTaxSlabMaster(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();
	HrMasItaxSlab hrMasItaxSlab=new HrMasItaxSlab();

	String changedBy = "";
	String lowerLimit="";
	String upperLimit = "";
	String citizen="";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	int slabId=0;
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		slabId =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		code =request.getParameter(CODE);
	}
	
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		name =request.getParameter(SEARCH_NAME);
	}
	if(request.getParameter(LOWER_LIMIT) !=null && !(request.getParameter(LOWER_LIMIT).equals(""))) {
		lowerLimit =request.getParameter(LOWER_LIMIT);
	}
	
	if(request.getParameter(UPPER_LIMIT) !=null && !(request.getParameter(UPPER_LIMIT).equals(""))) {
		upperLimit =request.getParameter(UPPER_LIMIT);
	}
	
	if(request.getParameter("citizen") !=null && !(request.getParameter("citizen").equals(""))) {
		citizen =request.getParameter("citizen");
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
		System.out.println("title:"+title);
	}
	if(request.getParameter("pojoName") != null){
		pojoName = request.getParameter("pojoName"); 
		System.out.println("pojoName:"+pojoName);
	}
	if(request.getParameter("pojoPropertyName") != null){
		pojoPropertyName = request.getParameter("pojoPropertyName"); 
		System.out.println("pojoPropertyName:"+pojoPropertyName);
	}
	
	if(request.getParameter("pojoPropertyCode") != null){
		pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		System.out.println("pojoPropertyCode:"+pojoPropertyCode);
	}
	
	System.out.println("yest"+code);
	generalMap.put("id", slabId);
	generalMap.put("code", code);
	generalMap.put("name", name);
	generalMap.put("lowerLimit", lowerLimit);
	generalMap.put("upperLimit", upperLimit);
	generalMap.put("citizen", citizen);
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);
	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoName", pojoName);

	generalMap.put("flag", true);
	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
    List existingSlabMasterList = (List)listMap.get("duplicateGeneralCodeList");
	boolean dataUpdated=false;
	if(existingSlabMasterList.size() == 0)
	{
	dataUpdated=incomeTaxMasHandlerService.editIncomeTaxSlabMaster(generalMap);
	if(dataUpdated==true){
		message="Data updated Successfully !!";
	}
	else{
		message="Data Cant be updated !!";
	}
	} 
	else if(existingSlabMasterList.size() > 0){
		message = "Name already exists.";
	}
	
	try{
		map = incomeTaxMasHandlerService.showIncomeTaxSlabJsp();
	   
	  }catch (Exception e) {
		  e.printStackTrace();
	  }
	  jsp="hr_incomeTaxSlab";
	  title="Income Tax Slab";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);

}
public ModelAndView deleteIncomeTaxSlabMaster(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	int slabId=0;
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
		slabId =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	if(request.getParameter("title") != null){
		title = request.getParameter("title"); 
	}
	if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
		changedBy = request.getParameter(CHANGED_BY);
	}
	if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
	}
	if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		currentTime = request.getParameter(CHANGED_TIME);
	}
	changedDate= new Date();
	changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
	
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);
	boolean dataDeleted=false;
	dataDeleted=incomeTaxMasHandlerService.deleteIncomeTaxSlabMaster(slabId,generalMap);
	if (dataDeleted==true)
	{
		message="Record is InActivated successfully !!";
	}
	else{
		message="Record is Activated successfully !!";
	}
	
	try{
		map = incomeTaxMasHandlerService.showIncomeTaxSlabJsp();
	   
	  }catch (Exception e) {
	   e.printStackTrace();
	  }
	  jsp="hr_incomeTaxSlab";
	  title="Delete Slab Master";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}


/*
@SuppressWarnings("unchecked")
public ModelAndView showFinancialYearJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map =new HashMap<String, Object>();
	map = incomeTaxMasHandlerService.showFinancialJsp();
	String jsp="hr_masFinancialYearJsp";
	jsp += ".jsp";
	title = "Financial Year";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
}
@SuppressWarnings("unchecked")
public ModelAndView searchFinancialYearMaster(HttpServletRequest request,HttpServletResponse response)
{
	
	String year="";
	String financialYear="";
	String searchField="";
	int searchId =1;
	Map<String, Object> map=new HashMap<String, Object>();
	
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		year =request.getParameter(CODE);
	}
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		financialYear =request.getParameter(SEARCH_NAME);
	}
	
	try {
		if(request.getParameter(SEARCH_FIELD) !=null && !(request.getParameter(SEARCH_FIELD).equals(""))) {
			searchField =request.getParameter(SEARCH_FIELD);
		}
		if(request.getParameter(SELECTED_RADIO) !=null && !(request.getParameter(SELECTED_RADIO).equals(""))) {
			searchId =Integer.parseInt(request.getParameter(SELECTED_RADIO));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	if(searchId ==1) {
		year =searchField;
		financialYear =null;
	}else {
		year = null;
		financialYear =searchField;
		
	}
	
	map =incomeTaxMasHandlerService.searchFinancialYearMaster(year, financialYear);
	
	String jsp="hr_masFinancialYearJsp";
	jsp += ".jsp";
	title ="Financial Year Master";
	map.put("financialYear", financialYear);
	map.put("year", year);
	
	map.put("search", "search");
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);

}
@SuppressWarnings("unchecked")
public ModelAndView addFinancialYearMaster(HttpServletRequest request, HttpServletResponse response) 
{
	
	Map<String,Object> map=new HashMap<String,Object>();
	MasStoreFinancial hrMasFinancialYear=new MasStoreFinancial();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	Date fromDate=null;
	Date toDate=null;
	if (request.getParameter(FROM_DATE) != null) {
		fromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
		code = HMSUtil.convertDateToStringTypeDate(fromDate);
		StringTokenizer st = new  StringTokenizer(code,"/");
		int count = 0;
		while(st.hasMoreTokens())
		{
			if(count==2)
			{
				code=st.nextToken();
				code = code.substring(0, 4);
				Integer next = new Integer(code);
				next=next+1;
				name=code+"-"+next;
				System.out.println("Nam"+name);
			}
			else{
				st.nextToken();
			}
			count++;
		}
	}
	if (request.getParameter(TO_DATE) != null) {
		toDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
		System.out.println("toDate:"+toDate);
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
		System.out.println("title:"+title);
	}
	if(request.getParameter("pojoName") != null){
		pojoName = request.getParameter("pojoName"); 
		System.out.println("pojoName:"+pojoName);
	}
	if(request.getParameter("pojoPropertyName") != null){
		pojoPropertyName = request.getParameter("pojoPropertyName"); 
		System.out.println("pojoPropertyName:"+pojoPropertyName);
	}
	
	if(request.getParameter("pojoPropertyCode") != null){
		pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		System.out.println("pojoPropertyCode:"+pojoPropertyCode);
	}
	generalMap.put("code", code);
	generalMap.put("name", name);

	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);

	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);

	List financialYearTypeCodeList = new ArrayList();
	List financialYearTypeNameList = new  ArrayList();

	if(listMap.get("duplicateGeneralCodeList") != null){
		financialYearTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
	}
	if(listMap.get("duplicateGeneralNameList") != null){
		financialYearTypeNameList = (List)listMap.get("duplicateGeneralNameList");
	}
	boolean successfullyAdded = false;

	if((financialYearTypeCodeList.size() == 0 || financialYearTypeCodeList == null) && (financialYearTypeNameList.size() == 0 || financialYearTypeNameList == null))
	{
		hrMasFinancialYear.setYearDescription(code);
		hrMasFinancialYear.setFinancialYear(name);
		hrMasFinancialYear.setStatus("y");
		hrMasFinancialYear.setLastChgBy(changedBy);
		hrMasFinancialYear.setLastChgDate(currentDate);
		hrMasFinancialYear.setLastChgTime(currentTime);
		hrMasFinancialYear.setYearFromDate(fromDate);
		hrMasFinancialYear.setYearToDate(toDate);
		successfullyAdded = incomeTaxMasHandlerService.addFinancialYearMaster(hrMasFinancialYear);		

		if(successfullyAdded)
		{
			message="Record Added Successfully !!";
		}
		else
		{
			message="Try Again !!";
		}
	}

	else if((financialYearTypeCodeList.size() != 0 || financialYearTypeCodeList != null) || (financialYearTypeNameList.size() != 0) || financialYearTypeNameList != null){

		if((financialYearTypeCodeList.size() != 0 || financialYearTypeCodeList != null) && (financialYearTypeNameList.size() == 0 || financialYearTypeNameList == null)){

			message = "Year Description already exists.";
		}
		else if((financialYearTypeNameList.size() != 0 || financialYearTypeNameList != null) && (financialYearTypeCodeList.size() == 0 || financialYearTypeCodeList == null) ){

			message = "Financial year already exists.";
		}
		else if((financialYearTypeCodeList.size() != 0 || financialYearTypeCodeList != null) && (financialYearTypeNameList.size() != 0 || financialYearTypeNameList != null)){

			message = "Year Description and Financial year already exist.";
		}
	}
	url = "/hms/hrms/incomeTaxMaster?method=showFinancialJsp";

	try{
		map = incomeTaxMasHandlerService.showFinancialJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	  jsp="hr_masFinancialYearJsp";
	  title="Add Financial Year";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
  }
@SuppressWarnings("unchecked")
public ModelAndView editFinancialYearMaster(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();
	MasStoreFinancial hrMasFinancialYear=new MasStoreFinancial();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	Date fromDate=null;
	Date toDate=null;
	int financialYrId=0;
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		financialYrId =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	
	if (request.getParameter(FROM_DATE) != null) {
		fromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
		code = HMSUtil.convertDateToStringTypeDate(fromDate);
		StringTokenizer st = new  StringTokenizer(code,"/");
		int count = 0;
		while(st.hasMoreTokens())
		{
			if(count==2)
			{
				code=st.nextToken();
				code = code.substring(0, 4);
				Integer next = new Integer(code);
				next=next+1;
				name=code+"-"+next;
				System.out.println("Nam"+name);
			}
			else{
				st.nextToken();
			}
			count++;
		}
	}
	if (request.getParameter(TO_DATE) != null) {
		toDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
		System.out.println("toDate:"+toDate);
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
		System.out.println("title:"+title);
	}
	if(request.getParameter("pojoName") != null){
		pojoName = request.getParameter("pojoName"); 
		System.out.println("pojoName:"+pojoName);
	}
	if(request.getParameter("pojoPropertyName") != null){
		pojoPropertyName = request.getParameter("pojoPropertyName"); 
		System.out.println("pojoPropertyName:"+pojoPropertyName);
	}
	
	if(request.getParameter("pojoPropertyCode") != null){
		pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		System.out.println("pojoPropertyCode:"+pojoPropertyCode);
	}
	

	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);

	generalMap.put("id", financialYrId);
	generalMap.put("code", code);
	generalMap.put("name", name);
	
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);
	generalMap.put("fromDate", fromDate);
	generalMap.put("toDate", toDate);

	generalMap.put("flag", true);
	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
    List existingSlabMasterList = (List)listMap.get("duplicateGeneralCodeList");
	boolean dataUpdated=false;
	if(existingSlabMasterList.size() == 0)
	{
	dataUpdated=incomeTaxMasHandlerService.editFinancialYearMaster(generalMap);
	if(dataUpdated==true){
		message="Data updated Successfully !!";
	}
	else{
		message="Data Cant be updated !!";
	}
	} 
	else if(existingSlabMasterList.size() > 0){
		message = "Name already exists.";
	}
	url = "/hms/hrms/incomeTaxMaster?method=showFinancialJsp";

	try{
		map = incomeTaxMasHandlerService.showFinancialJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	  jsp="hr_masFinancialYearJsp";
	  title="Add Financial Year";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}
public ModelAndView deleteFinancialYearMaster(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	int slabId=0;
	String message=null;
	String changedBy = "";
	String changedTime = "";
	Date changedDate = null;
	String flag =""; 
	int financialYrId=0;
	if(request.getParameter("flag") != null){
		flag = request.getParameter("flag"); 
		generalMap.put("flag", flag);
	}
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		financialYrId =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	if(request.getParameter("title") != null){
		title = request.getParameter("title"); 
	}
	if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
		changedBy = request.getParameter(CHANGED_BY);
	}
	if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
	}
	if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		currentTime = request.getParameter(CHANGED_TIME);
	}
	changedDate= new Date();
	changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
	
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);
	boolean dataDeleted=false;
	dataDeleted=incomeTaxMasHandlerService.deleteFinancialYearMaster(financialYrId,generalMap);
	if (dataDeleted==true)
	{
		message="Record is InActivated successfully !!";
	}
	else{
		message="Record is Activated successfully !!";
	}
	
	
	try{
		map = incomeTaxMasHandlerService.showFinancialJsp();
	   
	  }catch (Exception e) {
	   e.printStackTrace();
	  }
	  jsp="hr_masFinancialYearJsp";
	  title="Delete Financial Year Master";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}
*/
//end end end end

public ModelAndView showIncomeTaxExemptJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map =new HashMap<String, Object>();
	map = incomeTaxMasHandlerService.showIncomeTaxExemptJsp();
	String jsp="hr_incomeTaxExemption";
	jsp += ".jsp";
	title = "Income Tax Exemption";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
}
@SuppressWarnings("unchecked")
public ModelAndView searchIncomeTaxExemptJsp(HttpServletRequest request,HttpServletResponse response)
{
	String sectionCode="";
	String financialYear="";
	String searchField="";
	int searchId =1;
	
	
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		sectionCode =request.getParameter(CODE);
	}
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		financialYear =request.getParameter(SEARCH_NAME);
	}
	
	try {
		if(request.getParameter(SEARCH_FIELD) !=null && !(request.getParameter(SEARCH_FIELD).equals(""))) {
			searchField =request.getParameter(SEARCH_FIELD);
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}

	Map<String, Object> map1= incomeTaxMasHandlerService.showIncomeTaxExemptJsp();
	
	
	map =incomeTaxMasHandlerService.searchIncomeTaxExemptMaster(searchField);
	map1.putAll(map);
	String jsp="hr_incomeTaxExemption";
	jsp += ".jsp";
	title ="Income Tax Exemption";
	map.put("financialYear", financialYear);
	
	
	map.put("search", "search");
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);

}
public ModelAndView copyIncomeTaxExemptJsp(HttpServletRequest request,HttpServletResponse response)
{
	int copyFromYear = 0;
	int copyToYear = 0;
	
	try {
			if(request.getParameter("copyFromYear") !=null && !(request.getParameter("copyFromYear").equals("0"))) {
				copyFromYear = Integer.parseInt(request.getParameter("copyFromYear"));
			}
			if(request.getParameter("copyToYear") !=null && !(request.getParameter("copyToYear").equals("0"))) {
				copyToYear =Integer.parseInt(request.getParameter("copyToYear"));
			}
	
	
		
	}catch(Exception e) {
		e.printStackTrace();
	}

	
	
	map =incomeTaxMasHandlerService.copyIncomeTaxExemptMaster(copyFromYear, copyToYear);
	String jsp="hr_incomeTaxExemption";
	jsp += ".jsp";
	title ="Income Tax Exemption";
	
	
	map.put("search", "search");
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);

}



public ModelAndView addIncomeTaxExemptJsp(HttpServletRequest request,HttpServletResponse response)
{
	
	Map<String,Object> map=new HashMap<String,Object>();
	HrMasItaxExemption hrMasItaxExemption=new HrMasItaxExemption();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String,Object> listMap2=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	Date fromDate=null;
	Date toDate=null;
	String minAmt="";
	String maxAmt="";
	String exemptionBase="";
	String exemptionPercent="";
	String maxExemption="";
	String secDesc="";
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		code =request.getParameter(CODE);
	}
	if(request.getParameter(SEC_DESC) !=null && !(request.getParameter(SEC_DESC).equals(""))) {
		secDesc =request.getParameter(SEC_DESC);
	}
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		name =request.getParameter(SEARCH_NAME);
	}
	
	if(request.getParameter("minAmt") !=null && !(request.getParameter("minAmt").equals(""))) {
		minAmt =request.getParameter("minAmt");
	}
	
	if(request.getParameter("maxAmt") !=null && !(request.getParameter("maxAmt").equals(""))) {
		maxAmt =request.getParameter("maxAmt");
	}
	
	if(request.getParameter("exemptionBase") !=null && !(request.getParameter("exemptionBase").equals(""))) {
		exemptionBase =request.getParameter("exemptionBase");
	}
	
	if(request.getParameter("exemptionPercent") !=null && !(request.getParameter("exemptionPercent").equals(""))) {
		exemptionPercent =request.getParameter("exemptionPercent");
	}
	if(request.getParameter("maxExemption") !=null && !(request.getParameter("maxExemption").equals(""))) {
		maxExemption =request.getParameter("maxExemption");
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
		System.out.println("title:"+title);
	}
	if(request.getParameter("pojoName") != null){
		pojoName = request.getParameter("pojoName"); 
		System.out.println("pojoName:"+pojoName);
	}
	if(request.getParameter("pojoPropertyName") != null){
		pojoPropertyName = request.getParameter("pojoPropertyName"); 
		System.out.println("pojoPropertyName:"+pojoPropertyName);
	}
	
	if(request.getParameter("pojoPropertyCode") != null){
		pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
	//	System.out.println("pojoPropertyCode:"+pojoPropertyCode);
	}
	System.out.println("code--- "+ code);
	System.out.println("name--- "+name);
	generalMap.put("code", code);
	generalMap.put("name", name);

	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);

	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
	
	//listMap2 = incomeTaxMasHandlerService.checkForExistingIncomeTaxExempt(generalMap);

	List incomeTaxExempTypeCodeList = new ArrayList();
	List incomeTaxExempTypeNameList = new  ArrayList();

	if(listMap.get("duplicateGeneralCodeList") != null){
		incomeTaxExempTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
	}
	if(listMap.get("duplicateGeneralNameList") != null){
		incomeTaxExempTypeNameList = (List)listMap.get("duplicateGeneralNameList");
	}
	boolean successfullyAdded = false;

	if((incomeTaxExempTypeCodeList.size() == 0 || incomeTaxExempTypeCodeList == null) && (incomeTaxExempTypeNameList.size() == 0 || incomeTaxExempTypeNameList == null))
	{
		hrMasItaxExemption.setSectionCode(code);
		
		/*HrMasFinancialYear financialYear = new HrMasFinancialYear();
		financialYear.setId(new Integer(name));*/
		
		MasStoreFinancial financialYear = new MasStoreFinancial();
		financialYear.setId(new Integer(name));
		hrMasItaxExemption.setFinancialYear(financialYear);
		hrMasItaxExemption.setMinimumAmt(new BigDecimal(minAmt));
		hrMasItaxExemption.setMaximumAmt(new BigDecimal(maxAmt));
		hrMasItaxExemption.setExemptionBase(exemptionBase);
		hrMasItaxExemption.setExemptionPercentage(new BigDecimal(exemptionPercent));
		hrMasItaxExemption.setMaxExemption(new BigDecimal(maxExemption));
		hrMasItaxExemption.setStatus("y");
		Users user=new Users();
		user.setId(Integer.parseInt(changedBy));
		hrMasItaxExemption.setLastChgBy(user);
		hrMasItaxExemption.setLastChgDate(currentDate);
		hrMasItaxExemption.setLastChgTime(currentTime);
		hrMasItaxExemption.setSectionDesc(secDesc);
		successfullyAdded = incomeTaxMasHandlerService.addIncomeTaxExemptMaster(hrMasItaxExemption);		

		if(successfullyAdded)
		{
			message="Record Added Successfully !!";
		}
		else
		{
			message="Try Again !!";
		}
	}

	else if((incomeTaxExempTypeCodeList.size() != 0 || incomeTaxExempTypeCodeList != null) || (incomeTaxExempTypeNameList.size() != 0) || incomeTaxExempTypeNameList != null){

		if((incomeTaxExempTypeCodeList.size() != 0 || incomeTaxExempTypeCodeList != null) && (incomeTaxExempTypeNameList.size() == 0 || incomeTaxExempTypeNameList == null)){

			message = "Year Description already exists.";
		}
		else if((incomeTaxExempTypeNameList.size() != 0 || incomeTaxExempTypeNameList != null) && (incomeTaxExempTypeCodeList.size() == 0 || incomeTaxExempTypeCodeList == null) ){

			message = "Financial year already exists.";
		}
		else if((incomeTaxExempTypeCodeList.size() != 0 || incomeTaxExempTypeCodeList != null) && (incomeTaxExempTypeNameList.size() != 0 || incomeTaxExempTypeNameList != null)){

			message = "Year Description and Financial year already exist.";
		}
	}
	url = "/hms/hrms/incomeTaxMaster?method=showIncomeTaxExemptJsp";

	try{
		map = incomeTaxMasHandlerService.showIncomeTaxExemptJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	  jsp="hr_incomeTaxExemption";
	  title="Income Tax Exemption";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}
public ModelAndView editIncomeTaxExemptJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();
	HrMasItaxExemption hrMasItaxExemption=new HrMasItaxExemption();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	Date fromDate=null;
	Date toDate=null;
	String minAmt="";
	String maxAmt="";
	String exemptionBase="";
	String exemptionPercent="";
	String maxExemption="";
	String secDesc="";
	int id=0;
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		id =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		code =request.getParameter(CODE);
	}
	if(request.getParameter(SEC_DESC) !=null && !(request.getParameter(SEC_DESC).equals(""))) {
		secDesc =request.getParameter(SEC_DESC);
	}
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		name =request.getParameter(SEARCH_NAME);
	}
	
	if(request.getParameter("minAmt") !=null && !(request.getParameter("minAmt").equals(""))) {
		minAmt =request.getParameter("minAmt");
	}
	
	if(request.getParameter("maxAmt") !=null && !(request.getParameter("maxAmt").equals(""))) {
		maxAmt =request.getParameter("maxAmt");
	}
	
	if(request.getParameter("exemptionBase") !=null && !(request.getParameter("exemptionBase").equals(""))) {
		exemptionBase =request.getParameter("exemptionBase");
	}
	
	if(request.getParameter("exemptionPercent") !=null && !(request.getParameter("exemptionPercent").equals(""))) {
		exemptionPercent =request.getParameter("exemptionPercent");
	}
	if(request.getParameter("maxExemption") !=null && !(request.getParameter("maxExemption").equals(""))) {
		maxExemption =request.getParameter("maxExemption");
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
		System.out.println("title:"+title);
	}
	if(request.getParameter("pojoName") != null){
		pojoName = request.getParameter("pojoName"); 
		System.out.println("pojoName:"+pojoName);
	}
	if(request.getParameter("pojoPropertyName") != null){
		pojoPropertyName = request.getParameter("pojoPropertyName"); 
		System.out.println("pojoPropertyName:"+pojoPropertyName);
	}
	
	if(request.getParameter("pojoPropertyCode") != null){
		pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		System.out.println("pojoPropertyCode:"+pojoPropertyCode);
	}
	System.out.println("yest"+name);
	generalMap.put("id",id);
	generalMap.put("code", code);
	generalMap.put("secDesc", secDesc);
	generalMap.put("name", name);
	generalMap.put("minAmt", minAmt);
	generalMap.put("maxAmt", maxAmt);
	generalMap.put("exemptionBase", exemptionBase);
	generalMap.put("exemptionPercent", exemptionPercent);
	generalMap.put("maxExemption", maxExemption);
	
	generalMap.put("currentTime", currentTime);
	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);
	
	generalMap.put("flag", true);
	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
    List existingIncomeTaxExempList = (List)listMap.get("duplicateGeneralCodeList");
	boolean dataUpdated=false;
	if(existingIncomeTaxExempList.size() == 0)
	{
	dataUpdated=incomeTaxMasHandlerService.editIncomeTaxExemptMaster(generalMap);
	if(dataUpdated==true){
		message="Data updated Successfully !!";
	}
	else{
		message="Data Cant be updated !!";
	}
	} 
	else if(existingIncomeTaxExempList.size() > 0){
		message = "Name already exists.";
	}
	url = "/hms/hrms/incomeTaxMaster?method=showIncomeTaxExemptJsp";

	try{
		map = incomeTaxMasHandlerService.showIncomeTaxExemptJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	   jsp="hr_incomeTaxExemption";
	   title="Income Tax Exemption";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}
public ModelAndView deleteIncomeTaxExemptMaster(HttpServletRequest request,HttpServletResponse response)
{

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	int slabId=0;
	String message=null;
	String changedBy = "";
	String changedTime = "";
	Date changedDate = null;
	String flag =""; 
	int id=0;
	if(request.getParameter("flag") != null){
		flag = request.getParameter("flag"); 
		generalMap.put("flag", flag);
	}
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		id =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	if(request.getParameter("title") != null){
		title = request.getParameter("title"); 
	}
	if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
		changedBy = request.getParameter(CHANGED_BY);
	}
	if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
	}
	if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		currentTime = request.getParameter(CHANGED_TIME);
	}
	changedDate= new Date();
	changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
	
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);
	boolean dataDeleted=false;
	dataDeleted=incomeTaxMasHandlerService.deleteIncomeTaxExemptMaster(id,generalMap);
	if (dataDeleted==true)
	{
		message="Record is InActivated successfully !!";
	}
	else{
		message="Record is Activated successfully !!";
	}
	url = "/hms/hrms/educationMasters?method=showIncomeTaxExemptJsp";
	
	try{
		map = incomeTaxMasHandlerService.showIncomeTaxExemptJsp();
	   
	  }catch (Exception e) {
	   e.printStackTrace();
	  }
	  jsp="hr_incomeTaxExemption";
	  title="Income Tax Exemption";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);

}

@SuppressWarnings("unchecked")
public ModelAndView searchSectionInvestmentJsp(HttpServletRequest request,HttpServletResponse response)
{
	String sectionCode="";
	String financialYear="";
	String searchField="";
	int searchId =1;
	
	
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		sectionCode =request.getParameter(CODE);
	}
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		financialYear =request.getParameter(SEARCH_NAME);
	}
	
	try {
		if(request.getParameter(SEARCH_FIELD) !=null && !(request.getParameter(SEARCH_FIELD).equals(""))) {
			searchField =request.getParameter(SEARCH_FIELD);
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}

	Map<String, Object> map1= incomeTaxMasHandlerService.showSectionInvestmentJsp();
	
	
	map =incomeTaxMasHandlerService.searchSectionInvestmentJsp(searchField);
	map1.putAll(map);
	String jsp="hr_sectionInvestmentJsp";
	jsp += ".jsp";
	title ="Section Investment";
	map.put("financialYear", financialYear);
	
	
	map.put("search", "search");
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);

}
@SuppressWarnings("unchecked")
public ModelAndView showSectionInvestmentJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map =new HashMap<String, Object>();
	map = incomeTaxMasHandlerService.showSectionInvestmentJsp();
	String jsp="hr_sectionInvestmentJsp";
	jsp += ".jsp";
	title = "Section Investment";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
	
}
public ModelAndView copySectionInvestmentJsp(HttpServletRequest request,HttpServletResponse response)
{
	int copyFromYear = 0;
	int copyToYear = 0;
	
	try {
			if(request.getParameter("copyFromYear") !=null && !(request.getParameter("copyFromYear").equals("0"))) {
				copyFromYear = Integer.parseInt(request.getParameter("copyFromYear"));
			}
			if(request.getParameter("copyToYear") !=null && !(request.getParameter("copyToYear").equals("0"))) {
				copyToYear =Integer.parseInt(request.getParameter("copyToYear"));
			}
	
	
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	map =incomeTaxMasHandlerService.copySectionInvestmentJsp(copyFromYear, copyToYear);
	//map1.putAll(map);
	String jsp="hr_sectionInvestmentJsp";
	jsp += ".jsp";
	title = "Section Investment";
	//map.put("financialYear", financialYear);
	
	
	map.put("search", "search");
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);

}
	
	
public ModelAndView addISectionInvestmentJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();
	HrMasItaxSecInvestment hrMasItaxSecInvestment=new HrMasItaxSecInvestment();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	Date fromDate=null;
	Date toDate=null;
	String sectionCode="";
	String maxAmt="";
	String investmentType="";
	String benefitPercent="";
	String basicDep="";
	String monthlyDep="";
	

	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		name =request.getParameter(SEARCH_NAME);
	}
	
	if(request.getParameter("sectionCode") !=null && !(request.getParameter("sectionCode").equals(""))) {
		sectionCode =request.getParameter("sectionCode");
	}
	
	
	if(request.getParameter("investmentType") !=null && !(request.getParameter("investmentType").equals(""))) {
		investmentType =request.getParameter("investmentType");
	}
	
	if(request.getParameter("maxAmt") !=null && !(request.getParameter("maxAmt").equals(""))) {
		maxAmt =request.getParameter("maxAmt");
	}
	
	if(request.getParameter("benefitPercent") !=null && !(request.getParameter("benefitPercent").equals(""))) {
		benefitPercent =request.getParameter("benefitPercent");
	}
	if(request.getParameter("basicDep") !=null && !(request.getParameter("basicDep").equals(""))) {
		basicDep =request.getParameter("basicDep");
	}
	
	if(request.getParameter("monthlyDep") !=null && !(request.getParameter("monthlyDep").equals(""))) {
		monthlyDep =request.getParameter("monthlyDep");
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
		System.out.println("title:"+title);
	}
	if(request.getParameter("pojoName") != null){
		pojoName = request.getParameter("pojoName"); 
		System.out.println("pojoName:"+pojoName);
	}
	if(request.getParameter("pojoPropertyName") != null){
		pojoPropertyName = request.getParameter("pojoPropertyName"); 
		System.out.println("pojoPropertyName:"+pojoPropertyName);
	}
	
	if(request.getParameter("pojoPropertyCode") != null){
		pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		System.out.println("pojoPropertyCode:"+pojoPropertyCode);
	}
	generalMap.put("code", code);
	generalMap.put("name", name);

	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);

	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);

	List sectionInvestmentTypeCodeList = new ArrayList();
	List sectionInvestmentTypeNameList = new  ArrayList();

	if(listMap.get("duplicateGeneralCodeList") != null){
		sectionInvestmentTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
	}
	if(listMap.get("duplicateGeneralNameList") != null){
		sectionInvestmentTypeNameList = (List)listMap.get("duplicateGeneralNameList");
	}
	boolean successfullyAdded = false;

	if((sectionInvestmentTypeCodeList.size() == 0 || sectionInvestmentTypeCodeList == null) && (sectionInvestmentTypeNameList.size() == 0 || sectionInvestmentTypeNameList == null))
	{
		HrMasItaxExemption hrMasItaxExemption = new HrMasItaxExemption();
		hrMasItaxExemption.setId(new Integer(sectionCode));
		hrMasItaxSecInvestment.setHrMasItaxExemption(hrMasItaxExemption);
		
		HrMasInvestmentType hrMasInvestmentType = new HrMasInvestmentType();
		hrMasInvestmentType.setId(new Integer(investmentType));
		hrMasItaxSecInvestment.setInvestmentType(hrMasInvestmentType);
		
		/*HrMasFinancialYear financialYear = new HrMasFinancialYear();
		financialYear.setId(new Integer(name));*/
		
		MasStoreFinancial financialYear = new MasStoreFinancial();
		financialYear.setId(new Integer(name));
		hrMasItaxSecInvestment.setFinancialYear(financialYear);
		hrMasItaxSecInvestment.setBenefitPercent(new BigDecimal(benefitPercent));
		hrMasItaxSecInvestment.setMaxAmount(new BigDecimal(maxAmt));
		hrMasItaxSecInvestment.setBasicDependent(basicDep);
		hrMasItaxSecInvestment.setMonthlyDependent(monthlyDep);
		
		hrMasItaxSecInvestment.setStatus("y");
		Users user=new Users();
		user.setId(Integer.parseInt(changedBy));
		hrMasItaxSecInvestment.setLastChgBy(user);
		hrMasItaxSecInvestment.setLastChgDate(currentDate);
		hrMasItaxSecInvestment.setLastChgTime(currentTime);
		
		successfullyAdded = incomeTaxMasHandlerService.addISectionInvestmentJsp(hrMasItaxSecInvestment);		

		if(successfullyAdded)
		{
			message="Record Added Successfully !!";
		}
		else
		{
			message="Try Again !!";
		}
	}

	else if((sectionInvestmentTypeCodeList.size() != 0 || sectionInvestmentTypeCodeList != null) || (sectionInvestmentTypeNameList.size() != 0) || sectionInvestmentTypeNameList != null){

		if((sectionInvestmentTypeCodeList.size() != 0 || sectionInvestmentTypeCodeList != null) && (sectionInvestmentTypeNameList.size() == 0 || sectionInvestmentTypeNameList == null)){

			message = "Year Description already exists.";
		}
		else if((sectionInvestmentTypeNameList.size() != 0 || sectionInvestmentTypeNameList != null) && (sectionInvestmentTypeCodeList.size() == 0 || sectionInvestmentTypeCodeList == null) ){

			message = "Financial year already exists.";
		}
		else if((sectionInvestmentTypeCodeList.size() != 0 || sectionInvestmentTypeCodeList != null) && (sectionInvestmentTypeNameList.size() != 0 || sectionInvestmentTypeNameList != null)){

			message = "Year Description and Financial year already exist.";
		}
	}
	url = "/hms/hrms/incomeTaxMaster?method=showSectionInvestmentJsp";

	try{
		map = incomeTaxMasHandlerService.showSectionInvestmentJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	  jsp="hr_sectionInvestmentJsp";
	  title="Section Investment";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);

}
public ModelAndView editISectionInvestmentJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();
	HrMasItaxSecInvestment hrMasItaxSecInvestment=new HrMasItaxSecInvestment();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	Date fromDate=null;
	Date toDate=null;
	String sectionCode="";
	String maxAmt="";
	String investmentType="";
	String benefitPercent="";
	String basicDep="";
	String monthlyDep="";
	
	int id=0;
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		id =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		name =request.getParameter(SEARCH_NAME);
	}
	
	if(request.getParameter("sectionCode") !=null && !(request.getParameter("sectionCode").equals(""))) {
		sectionCode =request.getParameter("sectionCode");
	}
	
	if(request.getParameter("investmentType") !=null && !(request.getParameter("investmentType").equals(""))) {
		investmentType =request.getParameter("investmentType");
	}
	
	if(request.getParameter("maxAmt") !=null && !(request.getParameter("maxAmt").equals(""))) {
		maxAmt =request.getParameter("maxAmt");
	}
	
	if(request.getParameter("benefitPercent") !=null && !(request.getParameter("benefitPercent").equals(""))) {
		benefitPercent =request.getParameter("benefitPercent");
	}
	if(request.getParameter("basicDep") !=null && !(request.getParameter("basicDep").equals(""))) {
		basicDep =request.getParameter("basicDep");
	}
	
	if(request.getParameter("monthlyDep") !=null && !(request.getParameter("monthlyDep").equals(""))) {
		monthlyDep =request.getParameter("monthlyDep");
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
		System.out.println("title:"+title);
	}
	if(request.getParameter("pojoName") != null){
		pojoName = request.getParameter("pojoName"); 
		System.out.println("pojoName:"+pojoName);
	}
	if(request.getParameter("pojoPropertyName") != null){
		pojoPropertyName = request.getParameter("pojoPropertyName"); 
		System.out.println("pojoPropertyName:"+pojoPropertyName);
	}
	
	if(request.getParameter("pojoPropertyCode") != null){
		pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		System.out.println("pojoPropertyCode:"+pojoPropertyCode);
		
	}
	System.out.println("yest"+name);
	generalMap.put("id",id);
	generalMap.put("sectionCode", sectionCode);
	generalMap.put("name", name);
	generalMap.put("investmentType", investmentType);
	generalMap.put("maxAmt", maxAmt);
	generalMap.put("benefitPercent", benefitPercent);
	generalMap.put("basicDep", basicDep);
	generalMap.put("monthlyDep", monthlyDep);
	
	generalMap.put("currentTime", currentTime);
	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);
	
	generalMap.put("flag", true);
	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
    List existingISectionInvestmentList = (List)listMap.get("duplicateGeneralCodeList");
	boolean dataUpdated=false;
	if(existingISectionInvestmentList.size() == 0)
	{
	dataUpdated=incomeTaxMasHandlerService.editISectionInvestmentJsp(generalMap);
	if(dataUpdated==true){
		message="Data updated Successfully !!";
	}
	else{
		message="Data Cant be updated !!";
	}
	} 
	else if(existingISectionInvestmentList.size() > 0){
		message = "Name already exists.";
	}
	url = "/hms/hrms/incomeTaxMaster?method=showSectionInvestmentJsp";

	try{
		map = incomeTaxMasHandlerService.showSectionInvestmentJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	   jsp="hr_sectionInvestmentJsp";
	   title="Section Investment";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}
public ModelAndView deleteISectionInvestmentJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	int slabId=0;
	String message=null;
	String changedBy = "";
	String changedTime = "";
	Date changedDate = null;
	String flag =""; 
	int id=0;
	if(request.getParameter("flag") != null){
		flag = request.getParameter("flag"); 
		generalMap.put("flag", flag);
	}
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		id =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	if(request.getParameter("title") != null){
		title = request.getParameter("title"); 
	}
	if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
		changedBy = request.getParameter(CHANGED_BY);
	}
	if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
	}
	if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		currentTime = request.getParameter(CHANGED_TIME);
	}
	changedDate= new Date();
	changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
	
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);
	boolean dataDeleted=false;
	dataDeleted=incomeTaxMasHandlerService.deleteISectionInvestmentJsp(id,generalMap);
	if (dataDeleted==true)
	{
		message="Record is InActivated successfully !!";
	}
	else{
		message="Record is Activated successfully !!";
	}
	url = "/hms/hrms/educationMasters?method=showSectionInvestmentJsp";
	
	try{
		map = incomeTaxMasHandlerService.showSectionInvestmentJsp();
	   
	  }catch (Exception e) {
	   e.printStackTrace();
	  }
	  jsp="hr_sectionInvestmentJsp";
	  title="Section Investment";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}



public ModelAndView showIncomeTaxSurchargeJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map =new HashMap<String, Object>();
	map = incomeTaxMasHandlerService.showIncomeTaxSurchargeJsp();
	String jsp="hr_incomeTaxSurcharge";
	jsp += ".jsp";
	title = "Income Tax Surcharge";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);
	
}
@SuppressWarnings("unchecked")
public ModelAndView copyIncomeTaxSurchargeJsp(HttpServletRequest request,HttpServletResponse response)
{
	int copyFromYear = 0;
	int copyToYear = 0;
	
	try {
			if(request.getParameter("copyFromYear") !=null && !(request.getParameter("copyFromYear").equals("0"))) {
				copyFromYear = Integer.parseInt(request.getParameter("copyFromYear"));
			}
			if(request.getParameter("copyToYear") !=null && !(request.getParameter("copyToYear").equals("0"))) {
				copyToYear =Integer.parseInt(request.getParameter("copyToYear"));
			}
	
	
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	map =incomeTaxMasHandlerService.copyIncomeTaxSurchargeJsp(copyFromYear, copyToYear);
	//map1.putAll(map);
	String jsp="hr_incomeTaxSurcharge";
	jsp += ".jsp";
	title = "Section Investment";
	//map.put("financialYear", financialYear);
	
	
	map.put("search", "search");
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);

}

public ModelAndView searchIncomeTaxSurchargeJsp(HttpServletRequest request,HttpServletResponse response)
{
	String sectionCode="";
	String financialYear="";
	String searchField="";
	int searchId =1;
	
	System.out.println("In Controller");
	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
		sectionCode =request.getParameter(CODE);
	}
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		financialYear =request.getParameter(SEARCH_NAME);
	}
	
	try {
		if(request.getParameter(SEARCH_FIELD) !=null && !(request.getParameter(SEARCH_FIELD).equals(""))) {
			searchField =request.getParameter(SEARCH_FIELD);
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}

	Map<String, Object> map1= incomeTaxMasHandlerService.showIncomeTaxSurchargeJsp();
	
	
	map =incomeTaxMasHandlerService.searchIncomeTaxSurchargeJsp(searchField);
	map1.putAll(map);
	String jsp="hr_incomeTaxSurcharge";
	jsp += ".jsp";
	title ="Income Tax Surcharge";
	map.put("financialYear", financialYear);
	
	
	map.put("search", "search");
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index","map",map);

}
@SuppressWarnings("unchecked")
public ModelAndView addIncomeTaxSurchargeJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();
	HrMasItaxSurcharge hrMasItaxSurcharge=new HrMasItaxSurcharge();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	Date fromDate=null;
	Date toDate=null;
	String surchargeCode="";
	String lowerLimit="";
	String upperLimit="";
	BigDecimal minTaxableSal = null;
	String perOne="";
	String perTwo="";
	String surchargeBase="";
//	if(request.getParameter(CODE) !=null && !(request.getParameter(CODE).equals(""))) {
//		code =request.getParameter(CODE);
//	}
//	
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		name =request.getParameter(SEARCH_NAME);
	}
	
	if(request.getParameter("surchargeCode") !=null && !(request.getParameter("surchargeCode").equals(""))) {
		surchargeCode =request.getParameter("surchargeCode");
	}
	
	if(request.getParameter("lowerLimit") !=null && !(request.getParameter("lowerLimit").equals(""))) {
		lowerLimit =request.getParameter("lowerLimit");
	}
	
	if(request.getParameter("upperLimit") !=null && !(request.getParameter("upperLimit").equals(""))) {
		upperLimit =request.getParameter("upperLimit");
	}
	if(request.getParameter("minTaxSal") !=null && !request.getParameter("minTaxSal").equals("")) {
		minTaxableSal =new BigDecimal(request.getParameter("minTaxSal"));
	}
	if(request.getParameter("perOne") !=null && !(request.getParameter("perOne").equals(""))) {
		perOne =request.getParameter("perOne");
	}
	if(request.getParameter("perTwo") !=null && !(request.getParameter("perTwo").equals(""))) {
		perTwo =request.getParameter("perTwo");
	}
	
	if(request.getParameter("surchargeBase") !=null && !(request.getParameter("surchargeBase").equals(""))) {
		surchargeBase =request.getParameter("surchargeBase");
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
		System.out.println("title:"+title);
	}
	if(request.getParameter("pojoName") != null){
		pojoName = request.getParameter("pojoName"); 
		System.out.println("pojoName:"+pojoName);
	}
	if(request.getParameter("pojoPropertyName") != null){
		pojoPropertyName = request.getParameter("pojoPropertyName"); 
		System.out.println("pojoPropertyName:"+pojoPropertyName);
	}
	
	if(request.getParameter("pojoPropertyCode") != null){
		pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		System.out.println("pojoPropertyCode:"+pojoPropertyCode);
	}
	generalMap.put("code", surchargeCode);
	generalMap.put("name", name);

	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);

	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);

	List surChargeTypeCodeList = new ArrayList();
	List surChargeTypeNameList = new  ArrayList();

	if(listMap.get("duplicateGeneralCodeList") != null){
		surChargeTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
	}
	if(listMap.get("duplicateGeneralNameList") != null){
		surChargeTypeNameList = (List)listMap.get("duplicateGeneralNameList");
	}
	boolean successfullyAdded = false;

	/*if((surChargeTypeCodeList.size() == 0 || surChargeTypeCodeList == null) && (surChargeTypeNameList.size() == 0 || surChargeTypeNameList == null))
	{*/
		HrMasSurcharge hrMasSurcharge = new HrMasSurcharge();
		hrMasSurcharge.setId(new Integer(surchargeCode));
		hrMasItaxSurcharge.setHrMasSurcharge(hrMasSurcharge);
		
			
		/*HrMasFinancialYear financialYear = new HrMasFinancialYear();
		financialYear.setId(new Integer(name));*/
		
		MasStoreFinancial financialYear = new MasStoreFinancial();
		financialYear.setId(new Integer(name));
		hrMasItaxSurcharge.setFinancialYear(financialYear);
		hrMasItaxSurcharge.setLowerLimit(new BigDecimal(lowerLimit));
		hrMasItaxSurcharge.setUpperLimit(new BigDecimal(upperLimit));
		hrMasItaxSurcharge.setMinTaxSal(minTaxableSal);
		hrMasItaxSurcharge.setPercentOne(new BigDecimal(perOne));
		hrMasItaxSurcharge.setPercentTwo(new BigDecimal(perTwo));
		hrMasItaxSurcharge.setSurchargeBase(surchargeBase);
		hrMasItaxSurcharge.setStatus("y");
		Users user=new Users();
		user.setId(Integer.parseInt(changedBy));
		hrMasItaxSurcharge.setLastChgBy(user);
		hrMasItaxSurcharge.setLastChgDate(currentDate);
		hrMasItaxSurcharge.setLastChgTime(currentTime);
		
		successfullyAdded = incomeTaxMasHandlerService.addIncomeTaxSurchargeJsp(hrMasItaxSurcharge);		

		if(successfullyAdded)
		{
			message="Record Added Successfully !!";
		}
		else
		{
			message="Try Again !!";
		}
	//}

	/*else if((surChargeTypeCodeList.size() != 0 || surChargeTypeCodeList != null) || (surChargeTypeNameList.size() != 0) || surChargeTypeNameList != null){

		if((surChargeTypeCodeList.size() != 0 || surChargeTypeCodeList != null) && (surChargeTypeNameList.size() == 0 || surChargeTypeNameList == null)){

			message = "Year Description already exists.";
		}
		else if((surChargeTypeNameList.size() != 0 || surChargeTypeNameList != null) && (surChargeTypeCodeList.size() == 0 || surChargeTypeCodeList == null) ){

			message = "Financial year already exists.";
		}
		else if((surChargeTypeCodeList.size() != 0 || surChargeTypeCodeList != null) && (surChargeTypeNameList.size() != 0 || surChargeTypeNameList != null)){

			message = "Year Description and Financial year already exist.";
		}
	}*/
	url = "/hms/hrms/incomeTaxMaster?method=showIncomeTaxSurchargeJsp";

	try{
		map = incomeTaxMasHandlerService.showIncomeTaxSurchargeJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	  jsp="hr_incomeTaxSurcharge";
	  title="Income Tax Surcharge";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}
@SuppressWarnings("unchecked")
public ModelAndView editIncomeTaxSurchargeJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map=new HashMap<String,Object>();
	HrMasItaxSurcharge hrMasItaxSurcharge=new HrMasItaxSurcharge();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	Date fromDate=null;
	Date toDate=null;
	String surchargeCode="";
	String lowerLimit="";
	String upperLimit="";
	BigDecimal minTaxSal = new BigDecimal(0);
	String perOne="";
	String perTwo="";
	String surchargeBase="";
	
	int id=0;
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		id =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	
	if(request.getParameter(SEARCH_NAME) !=null && !(request.getParameter(SEARCH_NAME).equals(""))) {
		name =request.getParameter(SEARCH_NAME);
	}
	System.out.println("name=fdfd==="+name);
	
	if(request.getParameter("surchargeCode") !=null && !(request.getParameter("surchargeCode").equals(""))) {
		surchargeCode =request.getParameter("surchargeCode");
	}
	
	if(request.getParameter("lowerLimit") !=null && !(request.getParameter("lowerLimit").equals(""))) {
		lowerLimit =request.getParameter("lowerLimit");
	}
	
	if(request.getParameter("upperLimit") !=null && !(request.getParameter("upperLimit").equals(""))) {
		upperLimit =request.getParameter("upperLimit");
	}
	if(request.getParameter("minTaxSal") !=null && !(request.getParameter("minTaxSal").equals("")) ) {
		minTaxSal =new BigDecimal(request.getParameter("minTaxSal"));
	}
	if(request.getParameter("perOne") !=null && !(request.getParameter("perOne").equals(""))) {
		perOne =request.getParameter("perOne");
	}
	if(request.getParameter("perTwo") !=null && !(request.getParameter("perTwo").equals(""))) {
		perTwo =request.getParameter("perTwo");
	}
	
	if(request.getParameter("surchargeBase") !=null && !(request.getParameter("surchargeBase").equals(""))) {
		surchargeBase =request.getParameter("surchargeBase");
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
		System.out.println("title:"+title);
	}
	if(request.getParameter("pojoName") != null){
		pojoName = request.getParameter("pojoName"); 
		System.out.println("pojoName:"+pojoName);
	}
	if(request.getParameter("pojoPropertyName") != null){
		pojoPropertyName = request.getParameter("pojoPropertyName"); 
		System.out.println("pojoPropertyName:"+pojoPropertyName);
	}
	
	if(request.getParameter("pojoPropertyCode") != null){
		pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		System.out.println("pojoPropertyCode:"+pojoPropertyCode);
		
	}
	
	System.out.println("yest"+name);
	generalMap.put("id",id);
	generalMap.put("surchargeCode", surchargeCode);
	generalMap.put("name", name);
	generalMap.put("lowerLimit", lowerLimit);
	generalMap.put("upperLimit", upperLimit);
	generalMap.put("perOne", perOne);
	generalMap.put("perTwo", perTwo);
	generalMap.put("surchargeBase", surchargeBase);
	generalMap.put("minTaxSal", minTaxSal);
	
	generalMap.put("currentTime", currentTime);
	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);

	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);
	
	generalMap.put("flag", true);
	listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
    List existingISurchargeList = (List)listMap.get("duplicateGeneralCodeList");
	boolean dataUpdated=false;
	if(existingISurchargeList.size() == 0)
	{
	dataUpdated=incomeTaxMasHandlerService.editIncomeTaxSurchargeJsp(generalMap);
	if(dataUpdated==true){
		message="Data updated Successfully !!";
	}
	else{
		message="Data Cant be updated !!";
	}
	} 
	else if(existingISurchargeList.size() > 0){
		message = "Name already exists.";
	}
	url = "/hms/hrms/incomeTaxMaster?method=showIncomeTaxSurchargeJsp";

	try{
		map = incomeTaxMasHandlerService.showIncomeTaxSurchargeJsp();
	   }catch (Exception e) {
	    e.printStackTrace();
	  }
	   jsp="hr_incomeTaxSurcharge";
	   title="Income Tax Surcharge";
	  jsp += ".jsp";		  
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}
public ModelAndView deleteIncomeTaxSurchargeJsp(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	int slabId=0;
	String message=null;
	String changedBy = "";
	String changedTime = "";
	Date changedDate = null;
	String flag =""; 
	int id=0;
	if(request.getParameter("flag") != null){
		flag = request.getParameter("flag"); 
		generalMap.put("flag", flag);
	}
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		id =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	if(request.getParameter("title") != null){
		title = request.getParameter("title"); 
	}
	if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
		changedBy = request.getParameter(CHANGED_BY);
	}
	if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
	}
	if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		currentTime = request.getParameter(CHANGED_TIME);
	}
	changedDate= new Date();
	changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
	
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);
	boolean dataDeleted=false;
	dataDeleted=incomeTaxMasHandlerService.deleteIncomeTaxSurchargeJsp(id,generalMap);
	if (dataDeleted==true)
	{
		message="Record is InActivated successfully !!";
	}
	else{
		message="Record is Activated successfully !!";
	}
	url = "/hms/hrms/educationMasters?method=showIncomeTaxSurchargeJsp";
	
	try{
		map = incomeTaxMasHandlerService.showIncomeTaxSurchargeJsp();
	   
	  }catch (Exception e) {
	   e.printStackTrace();
	  }
	  jsp="hr_incomeTaxSurcharge";
	  title="Delete Income Tax Surcharge";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
}







public ModelAndView saveEmployeeInvestment(HttpServletRequest request,HttpServletResponse response)
{
	
	Map<String,Object> map=new HashMap<String,Object>();
	//HrEmployeeOtherEarning hrEmployeeOtherEarning=new HrEmployeeOtherEarning();

	String changedBy = "";
	Map<String,Object> listMap=new HashMap<String,Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	Date invDate=null;
	Date toDate=null;
	//String incomeCode="";
	BigDecimal amount=null;
	Date incomeDate=null;
	Integer invSec=null;
	int invYear=0;
	int listLen=0;

	int centreId=0;
	HttpSession session = request.getSession();
	if(session.getAttribute("locationId") != null){
		centreId = (Integer)session.getAttribute("locationId");
		
	}

	int empid=0;
	
	if(request.getParameter("listLen") !=null && !(request.getParameter("listLen").equals(""))) {
		listLen =new Integer(request.getParameter("listLen"));
	}
	MasEmployee emp = new MasEmployee();
	if(request.getParameter("empid") !=null && !(request.getParameter("empid").equals(""))) {
		empid =new Integer(request.getParameter("empid"));
		emp.setId(empid);
	}
	
	MasStoreFinancial year = new MasStoreFinancial();
	if(request.getParameter("invYear") != null && !(request.getParameter("invYear").equals(""))){
		invYear = new Integer(request.getParameter("invYear"));
		year.setId(invYear);
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
	List<HrEmployeeInvestment> empInvList = new ArrayList<HrEmployeeInvestment>();
	if(listLen>0)
	{
		for(int ilop=1;ilop<=listLen;ilop++)
		{
			if(request.getParameter("amount"+ilop) !=null && !(request.getParameter("amount"+ilop).equals(""))) {
				amount =new BigDecimal(request.getParameter("amount"+ilop));
			}
			if(request.getParameter("date"+ilop) != null && !(request.getParameter("date"+ilop).equals(""))){
				invDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("date"+ilop));
				
			}
			if(request.getParameter("invSec"+ilop) !=null && !(request.getParameter("invSec"+ilop).equals(""))) {
				invSec =new Integer(request.getParameter("invSec"+ilop));
			}
			HrEmployeeInvestment hrEmployeeInvestment = new HrEmployeeInvestment();
			
			
			hrEmployeeInvestment.setEmp(emp);
			hrEmployeeInvestment.setInvYear(year);
			hrEmployeeInvestment.setInvAmount(amount);
			hrEmployeeInvestment.setInvDate(invDate);
			if( invSec!=null && invSec >0){
				HrMasItaxSecInvestment hrMasItaxSecInvestment= new HrMasItaxSecInvestment();
				hrMasItaxSecInvestment.setId(invSec);
				hrEmployeeInvestment.setSecInvest(hrMasItaxSecInvestment);
			}
			
			hrEmployeeInvestment.setLastChgBy(changedBy);
			hrEmployeeInvestment.setLastChgTime(currentTime);
			hrEmployeeInvestment.setLastChgDate(currentDate);
			empInvList.add(hrEmployeeInvestment);
			map.put("empid", empid);
			map.put("invYear", invYear);
//			map.put("invSec", invSec);
			map.put("empInvList", empInvList);
		}
	}
	map.put("centreId", centreId);
	
	map = incomeTaxMasHandlerService.saveEmployeeInvestment(map);
	String flag =""+map.get("flag");
	String msg="";
	if(flag.equals("true") ){
		msg="Data updated Successfully.";
	}else{
		msg="Data Cant be updated.";
		
	}
	String jsp="hr_employeeInvestment";
	jsp += ".jsp";
	title = "Employee Investments";		
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("msg", msg);
	return new ModelAndView("index","map",map);
}





public List getAllUploadedDocs(String fileName,String uploadUrl) {

	List listOfUploadedResume = new ArrayList();
	
	File myFile = new File(uploadUrl);
	if (myFile.isDirectory()) {
		String[] allFiles = myFile.list();
		for (int i = 0; i < allFiles.length; i++) {
			int strLength = fileName.length();
			allFiles[i].contains(fileName);
			if (allFiles[i].contains(fileName)) {
				listOfUploadedResume.add(allFiles[i]);
			}
		}
	} else
		System.out.println("Not a directory");

	return listOfUploadedResume;
}


// ============Print Methods Goes here by Vishal================================


public ModelAndView printItaxSlabMaster(HttpServletRequest request,
		HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int fYear = 0;
			
		if (!request.getParameter(SEARCH_FIELD_NEXT).equals("0")) {
			fYear = Integer.parseInt(request.getParameter(SEARCH_FIELD_NEXT));
			
		}
		
	//	System.out.println("fyear----" + fYear);
		
		detailsMap = incomeTaxMasHandlerService.getConnectionForReport();

		parameters.put("fYear", fYear);
				
		HMSUtil.generateReport("IncomeTaxSlabMaster", parameters, (Connection) detailsMap
				.get("con"), response, getServletContext());
		return null;
	}


public ModelAndView printFinancialYearMaster(HttpServletRequest request,
		HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		/*int fYear = 0;
			
		if (!request.getParameter(SEARCH_FIELD_NEXT).equals("0")) {
			fYear = Integer.parseInt(request.getParameter(SEARCH_FIELD_NEXT));
			
		}*/
		
	//	System.out.println("fyear----" + fYear);
		
		detailsMap = incomeTaxMasHandlerService.getConnectionForReport();

		//parameters.put("fYear", fYear);
				
		HMSUtil.generateReport("FinancialYearMaster", parameters, (Connection) detailsMap
				.get("con"), response, getServletContext());
		return null;
	}




public ModelAndView printItaxExepmtionMaster(HttpServletRequest request,
		HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int fYear = 0;
			
		if (!request.getParameter(SEARCH_FIELD).equals("0")) {
			fYear = Integer.parseInt(request.getParameter(SEARCH_FIELD));
			
		}
		
	//	System.out.println("fyear----" + fYear);
		
		detailsMap = incomeTaxMasHandlerService.getConnectionForReport();

		parameters.put("fYear", fYear);
				
		HMSUtil.generateReport("IncomeTaxExemptionMaster", parameters, (Connection) detailsMap
				.get("con"), response, getServletContext());
		return null;
	}


	public ModelAndView printSectionInvestmentMaster(HttpServletRequest request,
		HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int fYear = 0;
			
		if (!request.getParameter(SEARCH_FIELD).equals("0")) {
			fYear = Integer.parseInt(request.getParameter(SEARCH_FIELD));
			
		}
		
	//	System.out.println("fyear----" + fYear);
		
		detailsMap = incomeTaxMasHandlerService.getConnectionForReport();

		parameters.put("fYear", fYear);
				
		HMSUtil.generateReport("SectionInvestmentMaster", parameters, (Connection) detailsMap
				.get("con"), response, getServletContext());
		return null;
	}
	
	public ModelAndView printSurchargeMaster(HttpServletRequest request,
			HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();

			int fYear = 0;
				
			if (!request.getParameter(SEARCH_FIELD).equals("0")) {
				fYear = Integer.parseInt(request.getParameter(SEARCH_FIELD));
				
			}
			
		//	System.out.println("fyear----" + fYear);
			
			detailsMap = incomeTaxMasHandlerService.getConnectionForReport();

			parameters.put("fYear", fYear);
					
			HMSUtil.generateReport("IncomeTaxSurcharge_EduMaster", parameters, (Connection) detailsMap
					.get("con"), response, getServletContext());
			return null;
		}

	
	
	public ModelAndView printSurchargeMast(HttpServletRequest request,
			HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();

			//int fYear = 0;
				
			/*if (!request.getParameter(SEARCH_FIELD).equals("0")) {
				fYear = Integer.parseInt(request.getParameter(SEARCH_FIELD));
				
			}*/
			
		//	System.out.println("fyear----" + fYear);
			
			detailsMap = incomeTaxMasHandlerService.getConnectionForReport();

		//	parameters.put("fYear", fYear);
					
			HMSUtil.generateReport("surchargeMaster", parameters, (Connection) detailsMap
					.get("con"), response, getServletContext());
			return null;
		}
	
	public ModelAndView printOtherEarningIncomeCodeMaster(HttpServletRequest request,
			HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			detailsMap = incomeTaxMasHandlerService.getConnectionForReport();

		//	parameters.put("fYear", fYear);
					
			HMSUtil.generateReport("otherEarningIncomeCodeMaster", parameters, (Connection) detailsMap
					.get("con"), response, getServletContext());
			return null;
		}
	
	/*Added By Kaushal Mishra*/
	public ModelAndView showEmpIndividualInvestWithData(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> detailMap =new HashMap<String, Object>();
		int centreId=0;
		int invYear=0;
		int empid=0;
		Users user = null;
		MasEmployee employee = null;
		HttpSession session = request.getSession();
		if(session.getAttribute("locationId") != null){
			centreId = (Integer)session.getAttribute("locationId");
			
		}
		if(session.getAttribute("users")!=null)
		{
			user = (Users)session.getAttribute("users");
			employee = user.getEmployee();
		}
		/*Testing Purpose*/
		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}}
		/*Ended*/
		
		
		if(mrequest.getParameter("empid") !=null && !(mrequest.getParameter("empid").equals(""))) {
			empid =new Integer(mrequest.getParameter("empid"));
		}
		
		if(mrequest.getParameter("invYear") != null && !(mrequest.getParameter("invYear").equals(""))){
			invYear = new Integer(mrequest.getParameter("invYear"));
			
		}
		detailMap.put("empid", empid);
		detailMap.put("invYear", invYear);
		detailMap.put("centreId", centreId);
		/*}*/
		List<MasStoreFinancial> financialYearList = incomeTaxMasHandlerService.getFinancialYearList();
		Map<String, Object> map =new HashMap<String, Object>();
	
		map = incomeTaxMasHandlerService.showEmployeeInvestmentWithData(detailMap);
	/*	Added for docs*/
		List<HrEmployeeInvestment> employeeInvestmentList = (List)map.get("employeeInvestmentList");
		for(HrEmployeeInvestment empInvestment:employeeInvestmentList){
			String uploadUrl = getServletContext().getRealPath("/uploads/docITproofs/"+ empInvestment.getInvYear().getFinancialYear()+"/"+empInvestment.getEmp().getEmployeeCode()+"/"+empInvestment.getSecInvest().getInvestmentType().getInvestmentDescription());
			List listOfUploadedDocs = getAllUploadedDocs(empInvestment.getSecInvest().getInvestmentType().getInvestmentDescription(),uploadUrl);
			map.put(empInvestment.getSecInvest().getInvestmentType().getInvestmentDescription(), listOfUploadedDocs);
			System.out.println("listOfUploadedDocs size in ds "+listOfUploadedDocs.size()); 
		}
		
	/*	Ended*/
		String jsp="hr_empIndividualInvest";
		jsp += ".jsp";
		title = "My Investments";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("employee", employee);
		map.put("financialYearList", financialYearList);
		map.put("invYear",invYear);
		return new ModelAndView("index","map",map);
	}
	
	/*Ended*/
	
	
}
