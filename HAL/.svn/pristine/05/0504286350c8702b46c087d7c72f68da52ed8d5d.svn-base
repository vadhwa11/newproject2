package jkt.hms.masters.controller;
import static jkt.hms.util.RequestConstants.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;







import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemClass;
import jkt.hms.masters.business.MasItemClassification;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasBudgetCode;
import jkt.hms.masters.business.MasSalesType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStoreAirForceDepot;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStoreBudgetT;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreItemGeneric;
import jkt.hms.masters.business.MasStoreMeScale;
import jkt.hms.masters.business.MasStorePharmaIndex;
import jkt.hms.masters.business.MasStorePoDeliveryTerms;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasStoreSupplierType;
import jkt.hms.masters.business.MasStoreUnit;
import jkt.hms.masters.business.MasStoreVendorWiseManufacturer;
import jkt.hms.masters.business.MasRepairStation;
import jkt.hms.masters.business.MprPriority;
import jkt.hms.masters.business.StoreSetup;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.PharmacyMasterHandlerService;
import jkt.hms.stores.handler.StoresHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public class PharmacyMasterController extends MultiActionController{
	PharmacyMasterHandlerService pharmacyMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
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
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	Date encodedDate = new Date();
	String encodedTime = "";
	HttpSession session = null;
	

//	------------------------------Item Type---------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showItemTypeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showItemTypeJsp();
		jsp = ITEM_TYPE_JSP;
		jsp+= ".jsp" ;
		title = "ItemType";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}

	public ModelAndView searchItemType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();  
		String itemTypeCode  = null;
		String itemTypeName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			itemTypeCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			itemTypeName = request.getParameter(SEARCH_NAME);
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
			itemTypeCode=searchField;
			itemTypeName=null;
		}else{
			itemTypeCode=null;
			itemTypeName=searchField;
		}
		map = pharmacyMasterHandlerService.searchItemType(itemTypeCode, itemTypeName);
		jsp=ITEM_TYPE_JSP;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("search", "search");
		map.put("itemTypeCode",itemTypeCode);
		map.put("itemTypeName",itemTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addItemType(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasItemType masStoreItemType=new MasItemType();
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
		int itemGroupId = 0;
		System.out.println("item Group=="+Integer.parseInt(request.getParameter("itemGroupId")));
		if (request.getParameter("itemGroupId") != null && !request.getParameter("itemGroupId").equals("0")) {
			itemGroupId =Integer.parseInt(request.getParameter("itemGroupId"));
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
		List itemTypeCodeList = new ArrayList();
		List itemTypeNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			itemTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			itemTypeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if((itemTypeCodeList.size() == 0 || itemTypeCodeList == null) && (itemTypeNameList.size() == 0 || itemTypeNameList == null))
		{
			masStoreItemType.setItemTypeCode(code);
			masStoreItemType.setItemTypeName(name);
			masStoreItemType.setStatus("y");
			MasStoreGroup masStoreGroup = new MasStoreGroup();
			masStoreGroup.setId(itemGroupId);
			masStoreItemType.setGroup(masStoreGroup);
			masStoreItemType.setLastChgBy(changedBy);
			masStoreItemType.setLastChgDate(currentDate);
			masStoreItemType.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService.addItemType(masStoreItemType);  

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}		
		}

		else if((itemTypeCodeList.size() != 0 || itemTypeCodeList != null) || (itemTypeNameList.size() != 0) || itemTypeNameList != null)
		{
			if((itemTypeCodeList.size() != 0 || itemTypeCodeList != null) && (itemTypeNameList.size() == 0 || itemTypeNameList == null)){
				message = "Item Type Code  already exists.";
			}
			else if((itemTypeNameList.size() != 0 || itemTypeNameList != null) && (itemTypeCodeList.size() == 0 || itemTypeCodeList == null) ){
				message = "Item Type Name already exists.";	   }
			else if((itemTypeCodeList.size() != 0 || itemTypeCodeList != null) && (itemTypeNameList.size() != 0 || itemTypeNameList != null)){
				message = "Item Type Code and Item Type Name already exist.";
			}
		}
		url = "/hms/hms/pharmacy?method=showItemTypeJsp";
		 try{
		   map = pharmacyMasterHandlerService.showItemTypeJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=ITEM_TYPE_JSP;
		    title="Add Item Type";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editItemType(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		int itemTypeId=0;
		Date changedDate = null;
		String changedTime = "";
		String changedBy = null;
		int itemGroupId = 0;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			itemTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if (request.getParameter("itemGroupId") != null && !request.getParameter("itemGroupId").equals("0")) {
			itemGroupId =Integer.parseInt(request.getParameter("itemGroupId"));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			code = request.getParameter(CODE);
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

		generalMap.put("id", itemTypeId);
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("itemGroupId", itemGroupId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	generalMap.put("flag", true);

		  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		  List existingItemTypeNameList = (List)listMap.get("duplicateMastersList");
		 
		  boolean dataUpdated=false;
		  if(existingItemTypeNameList.size() == 0)
		  {
		  
		dataUpdated=pharmacyMasterHandlerService.editItemTypeToDatabase(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant Be Updated !!";
		}}
		  else if(existingItemTypeNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/pharmacy?method=showItemTypeJsp";
		try{
			   map = pharmacyMasterHandlerService.showItemTypeJsp();
			    }catch (Exception e) {
			    	e.printStackTrace();
			    }
			    jsp=ITEM_TYPE_JSP;
			    title="Update Item Type ";
			    jsp += ".jsp";			    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView deleteItemType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int itemTypeId=0;
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
			itemTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deleteItemType(itemTypeId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated Successfully !!";
		}

		else{
			message="Record is Activated Successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showItemTypeJsp";
		try{
			map = pharmacyMasterHandlerService.showItemTypeJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=ITEM_TYPE_JSP;
		title="Delete Item Type";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}



	//--------------------------------------Item Class---------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showItemCategoryJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = pharmacyMasterHandlerService.showItemCategoryJsp();
		jsp = ITEM_CATEGORY_JSP;
		jsp += ".jsp";
		title = "itemCategory";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}	
	@SuppressWarnings("unchecked")
	public ModelAndView searchItemCategory(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();  
		String itemCategoryCode  = null;
		String itemCategoryName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			itemCategoryCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			itemCategoryName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){

			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(searchRadio==1){
			itemCategoryCode=searchField;
			itemCategoryName=null;
		}else{
			itemCategoryCode=null;
			itemCategoryName=searchField;
		}

		map = pharmacyMasterHandlerService.searchItemCategory(itemCategoryCode, itemCategoryName);

		jsp=ITEM_CATEGORY_JSP;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("search", "search");
		map.put("itemCategoryCode",itemCategoryCode);
		map.put("itemCategoryName",itemCategoryName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addItemCategory(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasItemCategory masStoreItemCategory=new MasItemCategory();
		int sectionId = 0;
		
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
		if (request.getParameter(SECTION_ID) != null) {
			sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
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

		List itemCategoryCodeList = new ArrayList();
		List itemCategoryNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			itemCategoryCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			itemCategoryNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((itemCategoryCodeList.size() == 0 || itemCategoryCodeList == null) && (itemCategoryNameList.size() == 0 || itemCategoryNameList == null))
		{
			masStoreItemCategory.setItemCategoryCode(code);
			masStoreItemCategory.setItemCategoryName(name);
			
			MasStoreSection masStoreSection= new MasStoreSection();
			masStoreSection.setId(sectionId);
			masStoreItemCategory.setSection(masStoreSection);

			masStoreItemCategory.setStatus("y");
			masStoreItemCategory.setLastChgBy(changedBy);
			masStoreItemCategory.setLastChgDate(currentDate);
			masStoreItemCategory.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService.addItemCategory(masStoreItemCategory);		

			if(successfullyAdded)
			{	message="Record Added Successfully !!";
			}
			else
			{		message="Try Again !!";

			}
		}

		else if((itemCategoryCodeList.size() != 0 || itemCategoryCodeList != null) || (itemCategoryNameList.size() != 0) || itemCategoryNameList != null){

			if((itemCategoryCodeList.size() != 0 || itemCategoryCodeList != null) && (itemCategoryNameList.size() == 0 || itemCategoryNameList == null)){
				message = "Item Category Code  already exists.";
			}
			else if((itemCategoryNameList.size() != 0 || itemCategoryNameList != null) && (itemCategoryCodeList.size() == 0	|| itemCategoryCodeList == null) ){
				message = "Item Category Name  already exists.";
			}
			else if((itemCategoryCodeList.size() != 0 || itemCategoryCodeList != null) && (itemCategoryNameList.size() != 0 || itemCategoryNameList != null)){
				message = "Item Category Code and Item Category Name already exist.";
			}
		}
		url = "/hms/hms/pharmacy?method=showItemCategoryJsp";
		try{
			map = pharmacyMasterHandlerService.showItemCategoryJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=ITEM_CATEGORY_JSP;
		title="Add Item Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	
public ModelAndView editItemCategory(HttpServletRequest request, HttpServletResponse response) 
	{
	Map<String, Object>	map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	session=request.getSession();
	String itemCategoryCode="";
	String itemCategoryName="";
	int sectionId = 0;
	int itemCategoryId=0;
	String changedBy = "";
	Date changedDate = null;
	String changedTime = "";
	if(request.getParameter(SECTION_ID) != null &&	!(request.getParameter(SECTION_ID).equals(""))){
		sectionId =Integer.parseInt( request.getParameter(SECTION_ID));
	}
	
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		itemCategoryId =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	if(request.getParameter(CODE) != null &&!(request.getParameter(CODE).equals(""))){
		itemCategoryCode = request.getParameter(CODE);
	}
	if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		itemCategoryName = request.getParameter(SEARCH_NAME);
	}
	if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
		changedBy = request.getParameter(CHANGED_BY);
	}

	if(request.getParameter("title") != null){
		title = request.getParameter("title"); 
	}
	changedDate = new Date();
	changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

	generalMap.put("id", itemCategoryId);
	generalMap.put("itemClassCode", itemCategoryCode);
	generalMap.put("name", itemCategoryName);
	generalMap.put("sectionId",sectionId);
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);

	boolean dataUpdated=false;

	dataUpdated=pharmacyMasterHandlerService.editItemCategoryToDatabase(generalMap);

	if(dataUpdated==true){
		message="Record Updated Successfully !!";

	}
	else{
		message="Record Cant be updated !!";
	}
	url = "/hms/hms/pharmacy?method=showItemCategoryJsp";
	try{
		map = pharmacyMasterHandlerService.showItemCategoryJsp();
	}catch (Exception e) {
		e.printStackTrace();
	}
	jsp=ITEM_CATEGORY_JSP;
	title="Edit Item Category";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteItemCategory(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int ItemCategoryId=0;
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
				ItemCategoryId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=pharmacyMasterHandlerService.deleteItemCategory(ItemCategoryId,generalMap);
			if (dataDeleted==true)
			{				
				message="Record is InActivated successfully !!";
			}
			
			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/pharmacy?method=showItemCategoryJsp";
			 try{
				   map = pharmacyMasterHandlerService.showItemCategoryJsp();
				    }catch (Exception e) {
				    	e.printStackTrace();
				    }
				    jsp=ITEM_CATEGORY_JSP;
				    title="delete Item Category";
				    jsp += ".jsp";		    
				    map.put("contentJsp", jsp);
				    map.put("title", title);
				    map.put("message", message);
				    return new ModelAndView("indexB", "map", map);
	}


	
/*//--------------------------------------Item Class---------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showItemClassJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = pharmacyMasterHandlerService.showItemClassJsp();
		jsp = ITEM_CLASS_JSP;
		jsp += ".jsp";
		title = "itemClass";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView searchItemClass(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();  
		String itemClassCode  = null;
		String itemClassName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			itemClassCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			itemClassName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){

			}
		}catch (Exception e) {
			//System.out.println("eeeeeeeeee  "+e);
		}
		if(searchRadio==1){
			itemClassCode=searchField;
			itemClassName=null;
		}else{
			itemClassCode=null;
			itemClassName=searchField;
		}

		map = pharmacyMasterHandlerService.searchItemClass(itemClassCode, itemClassName);

		jsp=ITEM_CLASS_JSP;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("itemClassCode",itemClassCode);
		map.put("itemClassName",itemClassName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addItemClass(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasItemClass masStoreItemClass=new MasItemClass();
		int itemTypeId=0;
		
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
		if (request.getParameter(ITEM_TYPE_ID) != null) {
			itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
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

		List itemClassCodeList = new ArrayList();
		List itemClassNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			itemClassCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			itemClassNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((itemClassCodeList.size() == 0 || itemClassCodeList == null) && (itemClassNameList.size() == 0 || itemClassNameList == null))
		{
			masStoreItemClass.setItemClassCode(code);
			masStoreItemClass.setItemClassName(name);
			
			MasItemType masStoreItemType= new MasItemType();
			masStoreItemType.setId(itemTypeId);
			masStoreItemClass.setItemType(masStoreItemType);

			masStoreItemClass.setStatus("y");
			masStoreItemClass.setLastChgBy(changedBy);
			masStoreItemClass.setLastChgDate(currentDate);
			masStoreItemClass.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService.addItemClass(masStoreItemClass);		

			if(successfullyAdded)
			{	message="Record Added Successfully !!";
			}
			else
			{		message="Try Again !!";

			}
		}

		else if((itemClassCodeList.size() != 0 || itemClassCodeList != null) || (itemClassNameList.size() != 0) || itemClassNameList != null){

			if((itemClassCodeList.size() != 0 || itemClassCodeList != null) && (itemClassNameList.size() == 0 || itemClassNameList == null)){
				message = "Item Class Code  already exists.";
			}
			else if((itemClassNameList.size() != 0 || itemClassNameList != null) && (itemClassCodeList.size() == 0	|| itemClassCodeList == null) ){
				message = "Item Class Name  already exists.";
			}
			else if((itemClassCodeList.size() != 0 || itemClassCodeList != null) && (itemClassNameList.size() != 0 || itemClassNameList != null)){
				message = "Item Class Code and Item Class Name already exist.";
			}
		}
		url = "/hms/hms/pharmacy?method=showItemClassJsp";
		try{
			map = pharmacyMasterHandlerService.showItemClassJsp();
		}catch (Exception e) {
			//System.out.println("Exception in  showItemClassJsp "+e);
		}
		jsp=ITEM_CLASS_JSP;
		title="Add Item Class";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	
public ModelAndView editItemClass(HttpServletRequest request, HttpServletResponse response) 
	{
	Map<String, Object>	map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	session=request.getSession();
	String itemClassCode="";
	String itemClassName="";
	int itemTypeId=0;
	int itemClassId=0;
	String changedBy = "";
	Date changedDate = null;
	String changedTime = "";

	itemClassCode=(String )session.getAttribute("itemClassCode");
	itemClassName=(String )session.getAttribute("itemClassName");

	if(request.getParameter(ITEM_TYPE_ID) != null &&	!(request.getParameter(ITEM_TYPE_ID).equals(""))){
		itemTypeId =Integer.parseInt( request.getParameter(ITEM_TYPE_ID));
	}
	
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		itemClassId =Integer.parseInt( request.getParameter(COMMON_ID));
	}
	if(request.getParameter(CODE) != null &&!(request.getParameter(CODE).equals(""))){
		itemClassCode = request.getParameter(CODE);
	}
	if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		itemClassName = request.getParameter(SEARCH_NAME);
	}
	if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
		changedBy = request.getParameter(CHANGED_BY);
	}

	if(request.getParameter("title") != null){
		title = request.getParameter("title"); 
	}
	changedDate = new Date();
	changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

	generalMap.put("id", itemClassId);
	generalMap.put("itemClassCode", itemClassCode);
	generalMap.put("name", itemClassName);
	generalMap.put("itemTypeId",itemTypeId);
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);

	boolean dataUpdated=false;

	dataUpdated=pharmacyMasterHandlerService.editItemClassToDatabase(generalMap);

	if(dataUpdated==true){
		message="Record Updated Successfully !!";

	}
	else{
		message="Record Cant be updated !!";
	}
	url = "/hms/hms/pharmacy?method=showItemClassJsp";
	try{
		map = pharmacyMasterHandlerService.showItemClassJsp();
	}catch (Exception e) {
		//System.out.println("Exception in  showRankJsp "+e);
	}
	jsp=ITEM_CLASS_JSP;
	title="Edit Item Class";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteItemClass(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int ItemClassId=0;
			String message=null;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;			
			
			if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				ItemClassId =Integer.parseInt( request.getParameter(COMMON_ID));
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
			dataDeleted=pharmacyMasterHandlerService.deleteItemClass(ItemClassId,generalMap);
			if (dataDeleted==true)
			{				
				message="Record is InActivated successfully !!";
			}
			
			else{
				message="Record is Activated successfully !!";
			}
			url = "/hms/hms/pharmacy?method=showItemClassJsp";
			 try{
				   map = pharmacyMasterHandlerService.showItemClassJsp();
				    }catch (Exception e) {
				     //System.out.println("Exception in showItemClassJsp "+e);
				    }
				    jsp=ITEM_CLASS_JSP;
				    title="delete Item Class";
				    jsp += ".jsp";		    
				    map.put("contentJsp", jsp);
				    map.put("title", title);
				    map.put("message", message);
				    return new ModelAndView("index", "map", map);
	}*/
//	--------------------Sales Type Report-------------------------------------------------------
	

	public ModelAndView reportSalesType(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> parameters  = new HashMap<String, Object>();
		Map<String, Object> map  = new HashMap<String, Object>();
		parameters=pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Sales_Type", parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);	
			 
	}
//	-------------------------------------Sales Type------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showSalesTypeJsp(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showSalesTypeJsp();
		jsp = SALES_TYPE_JSP;
		jsp+= ".jsp" ;
		title = "alesType";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView searchSalesType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();  
		String salesTypeCode  = null;
		String salesTypeName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			salesTypeCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			salesTypeName = request.getParameter(SEARCH_NAME);
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
			salesTypeCode=searchField;
			salesTypeName=null;

		}else{
			salesTypeCode=null;
			salesTypeName=searchField;
		}
		map = pharmacyMasterHandlerService.searchSalesType(salesTypeCode, salesTypeName);

		jsp=SALES_TYPE_JSP;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("search", "search");
		map.put("salesTypeCode",salesTypeCode);
		map.put("salesTypeName",salesTypeName);
		return new ModelAndView("indexB", "map", map);		
	}
	@SuppressWarnings("unchecked")
	public ModelAndView addSalesType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> listMap=new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String,Object> map = new HashMap<String,Object>();
		MasSalesType masSalesType = new MasSalesType();
		String code="";
		String name="";
		int salesTypeValue=0;
		String changedBy = "";	
		Date currentDate = new Date();		
		try{
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);						
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);				
		}		
		if (request.getParameter(SALES_TYPE_VALUE) != null) {
			salesTypeValue = Integer.parseInt(request.getParameter(SALES_TYPE_VALUE));
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
    	}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate =  HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));			
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
		List salesTypeCodeList = new ArrayList();
		List salesTypeNameList = new  ArrayList();
		
		if(listMap.get("duplicateGeneralCodeList") != null){
			salesTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");			
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			salesTypeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
	
		if((salesTypeCodeList.size() == 0 || salesTypeCodeList == null) && (salesTypeNameList.size() == 0 || salesTypeNameList == null)){
		
			masSalesType.setSalesTypeCode(code);
			masSalesType.setSalesTypeName(name);
			masSalesType.setSalesTypeValue(salesTypeValue);
			masSalesType.setStatus("y");
			masSalesType.setLastChgBy(changedBy);
			masSalesType.setLastChgDate(currentDate);
			masSalesType.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService.addSalesType(masSalesType);		
			if(successfullyAdded){
				message="Record Added Successfully !!";
			}else{
				message="Try Again !!";
			}
		
		}else if((salesTypeCodeList.size() != 0 || salesTypeCodeList != null) || (salesTypeNameList.size() != 0) || salesTypeNameList != null){
			if((salesTypeCodeList.size() != 0 || salesTypeCodeList != null) && (salesTypeNameList.size() == 0 || salesTypeNameList == null)){
				message = "Sales Type Code already exists.";
			}
			else if((salesTypeNameList.size() != 0 || salesTypeNameList != null) && (salesTypeCodeList.size() == 0 || salesTypeCodeList == null) ){
				message = "Sales Type Name already exists.";
			}
			else if((salesTypeCodeList.size() != 0 || salesTypeCodeList != null) && (salesTypeNameList.size() != 0 || salesTypeNameList != null)){
				message = "Sales Type Code and Sales Type exist.";
			}
		}
		
		url = "/hms/hms/pharmacy?method=showSalesTypeJsp";
		 try{
		   map = pharmacyMasterHandlerService.showSalesTypeJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=SALES_TYPE_JSP;
		    title="Add Sales Type";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
		
		}
	
	public ModelAndView deleteSalesType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int salesTypeId=0;
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
			salesTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deleteSalesType(salesTypeId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		
		else{
			message="Record is Activated successfully !!";
		}
		
		url = "/hms/hms/pharmacy?method=showSalesType";
		 try{
		   map = pharmacyMasterHandlerService.showSalesTypeJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=SALES_TYPE_JSP;
		    title="Delete Sales Type";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
		
	}
	public ModelAndView editSalesType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		
		session=request.getSession();
		String salesTypeCode="";
		String salesTypeName="";
		int salesTypeValue=0;
		int salesTypeId=0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";		
		
		try{
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			salesTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(SALES_TYPE_VALUE) != null && !(request.getParameter(SALES_TYPE_VALUE).equals(""))){
			salesTypeValue =Integer.parseInt( request.getParameter(SALES_TYPE_VALUE));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			salesTypeCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			salesTypeName = request.getParameter(SEARCH_NAME);
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
		}

		changedDate = new Date();
		try{
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		
		generalMap.put("id", salesTypeId);
		generalMap.put("salesTypeCode",salesTypeCode);
		generalMap.put("name", salesTypeName);
		generalMap.put("salesTypeValue",salesTypeValue);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		}catch (Exception e) {
			e.printStackTrace();
		}		
		try{
			@SuppressWarnings("unused")
			MasSalesType masSalesType= new MasSalesType();
		}catch (Exception e) {
			e.printStackTrace();
		}
		boolean dataUpdated=false;
		try{
		dataUpdated=pharmacyMasterHandlerService.editSalesType(generalMap);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(dataUpdated==true){
			message="Record Updated Successfully !!";			
		}
		else{
			message="Record Cant be updated !!";
		}
		
		url = "/hms/hms/pharmacy?method=showSalesType";
		 try{
		   map = pharmacyMasterHandlerService.showSalesTypeJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=SALES_TYPE_JSP;
		    title="Edit Sales Type";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
		
	}
	
	
//	--------------------Store Section Report-------------------------------------------------------
	

		public ModelAndView reportStoreSection(HttpServletRequest request,HttpServletResponse response) 
		{
			Map<String, Object> parameters  = new HashMap<String, Object>();
			Map<String, Object> map  = new HashMap<String, Object>();
			parameters=pharmacyMasterHandlerService.getConnection();
			HMSUtil.generateReport("Mas_Store_Section", parameters, (Connection)parameters.get("conn"), response, getServletContext());
			return new ModelAndView("indexB", "map", map);	
				 
		}
//--------------------------------------Store Section-------------------------------------------

	public ModelAndView searchStoreSection(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String sectionCode  = null;
		String sectionName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			sectionCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			sectionName = request.getParameter(SEARCH_NAME);
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
			sectionCode=searchField;
			sectionName=null;
		}else{
			sectionCode=null;
			sectionName=searchField;
		}

		map = pharmacyMasterHandlerService.searchStoreSection(sectionCode, sectionName);
		jsp=STORE_SECTION_JSP;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("search", "search");
		map.put("title", title);
		map.put("sectionCode",sectionCode);
		map.put("sectionName",sectionName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showStoreSectionJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = pharmacyMasterHandlerService.showStoreSectionJsp();
		@SuppressWarnings("unused")
		ArrayList  searchStoreSectionList = (ArrayList)map.get("searchStoreSectionList");
		jsp = STORE_SECTION_JSP;
		jsp += ".jsp";
		title = "StoreSection";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addStoreSection(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasStoreSection masStoreSection=new MasStoreSection();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int itemTypeId = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("itemTypeId") != null) {
			itemTypeId = Integer.parseInt(request.getParameter("itemTypeId"));
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
		List sectionCodeList = new ArrayList();
		List sectionNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			sectionCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			sectionNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((sectionCodeList.size() == 0 || sectionCodeList == null) && (sectionNameList.size() == 0 || sectionNameList == null))
		{
			masStoreSection.setSectionCode(code);
			masStoreSection.setSectionName(name);
			masStoreSection.setStatus("y");
			MasItemType masItemType = new MasItemType();
			masItemType.setId(itemTypeId);
			masStoreSection.setItemType(masItemType);
			masStoreSection.setLastChgBy(changedBy);
			masStoreSection.setLastChgDate(currentDate);
			masStoreSection.setLastChgTime(currentTime);
			successfullyAdded =	pharmacyMasterHandlerService.addStoreSection(masStoreSection);		

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}

		else if((sectionCodeList.size() != 0 || sectionCodeList != null) || (sectionNameList.size() != 0) || sectionNameList != null){

			if((sectionCodeList.size() != 0 || sectionCodeList != null) && (sectionNameList.size() == 0 || sectionNameList == null)){

				message = "Section Code  already exists.";
			}
			else if((sectionNameList.size() != 0 || sectionNameList != null) && (sectionCodeList.size() == 0 || sectionCodeList == null) ){

				message = "Section Name already exists.";
			}
			else if((sectionCodeList.size() != 0 || sectionCodeList != null) && (sectionNameList.size() != 0 || sectionNameList != null)){

				message = "Section Code and Section Name already exist.";
			}
		}

		url = "/hms/hms/pharmacy?method=showStoreSectionJsp";
		
		try{
			map = pharmacyMasterHandlerService.showStoreSectionJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=STORE_SECTION_JSP;
		title="Add StoreSection";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView editStoreSection(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session=request.getSession();
		String sectionCode="";
		String sectionName="";
		int sectionId=0;
		String changedBy = "";
		int itemTypeId = 0;
		Date changedDate = null;
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			sectionId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			sectionCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			sectionName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("itemTypeId") != null) {
			itemTypeId = Integer.parseInt(request.getParameter("itemTypeId"));
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

		generalMap.put("id", sectionId);
		generalMap.put("sectionCode", sectionCode);
		generalMap.put("name", sectionName);
		generalMap.put("itemTypeId", itemTypeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	 generalMap.put("flag", true);

		  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		  List existingStoreSectionNameList = (List)listMap.get("duplicateMastersList");
		 
		  boolean dataUpdated=false;
		  if(existingStoreSectionNameList.size() == 0)
		  {
		dataUpdated=pharmacyMasterHandlerService.editStoreSectionToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}}
		  else if(existingStoreSectionNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/pharmacy?method=showStoreSectionJsp";
		
		try{
			map = pharmacyMasterHandlerService.showStoreSectionJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=STORE_SECTION_JSP;
		title="edit StoreSection";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteStoreSection(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int sectionId=0;
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
			sectionId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deleteStoreSection(sectionId,generalMap);
		if (dataDeleted==true)
		{

			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showStoreSectionJsp";
		
		try{
			map = pharmacyMasterHandlerService.showStoreSectionJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=STORE_SECTION_JSP;
		title="delete StoreSection";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

//	--------------------Store Supplier Type Report-------------------------------------------------------
	

	public ModelAndView reportStoreSupplierType(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> parameters  = new HashMap<String, Object>();
		Map<String, Object> map  = new HashMap<String, Object>();
		parameters=pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Supplier_Type", parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);	
			 
	}
// ---------------------------------- Store Supplier Type-----------------------

	
	@SuppressWarnings("unchecked")
	public ModelAndView showStoreSupplierTypeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = pharmacyMasterHandlerService.showStoreSupplierTypeJsp();
		jsp = STORE_SUPPLIER_TYPE_JSP;
		jsp += ".jsp";
		title = "StoreSupplierType";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchStoreSupplierType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String storeSupplierTypeCode  = null;
		String storeSupplierTypeName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			storeSupplierTypeCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			storeSupplierTypeName = request.getParameter(SEARCH_NAME);
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
			storeSupplierTypeCode=searchField;
			storeSupplierTypeName=null;

		}else{
			storeSupplierTypeCode=null;
			storeSupplierTypeName=searchField;
		}

		map = pharmacyMasterHandlerService.searchStoreSupplierType(storeSupplierTypeCode, storeSupplierTypeName);
		jsp=STORE_SUPPLIER_TYPE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("storeSupplierTypeCode",storeSupplierTypeCode);
		map.put("storeSupplierTypeName",storeSupplierTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	
	@SuppressWarnings("unchecked")
	public ModelAndView addStoreSupplierType(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasStoreSupplierType masStoreSupplierType=new MasStoreSupplierType();
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

		List storeSupplierTypeCodeList = new ArrayList();
		List storeSupplierTypeNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			storeSupplierTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			storeSupplierTypeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((storeSupplierTypeCodeList.size() == 0 || storeSupplierTypeCodeList == null) && (storeSupplierTypeNameList.size() == 0 || storeSupplierTypeNameList == null))
		{
			masStoreSupplierType.setSupplierTypeCode(code);
			masStoreSupplierType.setSupplierTypeName(name);
			masStoreSupplierType.setStatus("y");
			masStoreSupplierType.setLastChgBy(changedBy);
			masStoreSupplierType.setLastChgDate(currentDate);
			masStoreSupplierType.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService.addStoreSupplierType(masStoreSupplierType);		
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((storeSupplierTypeCodeList.size() != 0 || storeSupplierTypeCodeList != null) || (storeSupplierTypeNameList.size() != 0) || storeSupplierTypeNameList != null){
			if((storeSupplierTypeCodeList.size() != 0 || storeSupplierTypeCodeList != null) && (storeSupplierTypeNameList.size() == 0 || storeSupplierTypeNameList == null)){

				message = "SST Code  already exists.";
			}
			else if((storeSupplierTypeNameList.size() != 0 || storeSupplierTypeNameList != null) && (storeSupplierTypeCodeList.size() == 0 || storeSupplierTypeCodeList == null) ){

				message = "SST Name already exists.";
			}
			else if((storeSupplierTypeCodeList.size() != 0 || storeSupplierTypeCodeList != null) && (storeSupplierTypeNameList.size() != 0 || storeSupplierTypeNameList != null)){

				message = "SST Code and SST Name already exist.";
			}
		}

		url = "/hms/hms/pharmacy?method=showStoreSupplierTypeJsp";
		try{
			map = pharmacyMasterHandlerService.showStoreSupplierTypeJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=STORE_SUPPLIER_TYPE_JSP;
		title="Add StoreSupplierType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editStoreSupplierType(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		int storeSupplierTypeId=0;
		Date changedDate = null;
		String changedTime = "";
		String changedBy = null;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			storeSupplierTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			code = request.getParameter(CODE);
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

		generalMap.put("id", storeSupplierTypeId);
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	 generalMap.put("flag", true);

		  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		  List existingStoreSupplierTypeNameList = (List)listMap.get("duplicateMastersList");
		 
		  boolean dataUpdated=false;
		  if(existingStoreSupplierTypeNameList.size() == 0)
		  {
		  
		dataUpdated=pharmacyMasterHandlerService.editStoreSupplierTypeToDatabase(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant Be Updated !!";
		}}
		  else if(existingStoreSupplierTypeNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/pharmacy?method=showStoreSupplierTypeJsp";
		try{
			   map = pharmacyMasterHandlerService.showStoreSupplierTypeJsp();
			    }catch (Exception e) {
			    	e.printStackTrace();
			    }
			    jsp=STORE_SUPPLIER_TYPE_JSP;
			    title="Update Store Supplier Type ";
			    jsp += ".jsp";			    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteStoreSupplierType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int storeSupplierTypeId=0;
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
			storeSupplierTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deleteStoreSupplierType(storeSupplierTypeId,generalMap);
		if (dataDeleted==true)
		{

			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showStoreSupplierTypeJsp";
		try{
			map = pharmacyMasterHandlerService.showStoreSupplierTypeJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=STORE_SUPPLIER_TYPE_JSP;
		title="delete StoreSupplierType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}
//	--------------------Manufacturer Report-------------------------------------------------------
	

	public ModelAndView reportManufacturer(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> parameters  = new HashMap<String, Object>();
		Map<String, Object> map  = new HashMap<String, Object>();
		parameters=pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Manufacturer", parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);	
			 
	}

//	----------------------------------------------Manufacturer----------------------------------------------	

	@SuppressWarnings("unchecked")
	public ModelAndView showManufacturerJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		session = request.getSession();
		int itemIdFromBrandPopup = 0;
		int brandIdFromBrandPopup = 0;
		if(request.getParameter("itemIdFromBrandPopup") != null
				&& !request.getParameter("itemIdFromBrandPopup").equals("") ){
			itemIdFromBrandPopup = Integer.parseInt(request.getParameter("itemIdFromBrandPopup"));
			parameterMap.put("itemIdFromBrandPopup", itemIdFromBrandPopup);
			
			if(request.getParameter(COMMON_ID) != null
					&& !request.getParameter(COMMON_ID).equals("")){
				brandIdFromBrandPopup = Integer.parseInt(request.getParameter(COMMON_ID));
				parameterMap.put("brandIdFromBrandPopup", brandIdFromBrandPopup);
			}

		}
		map = pharmacyMasterHandlerService.showManufacturerJsp();
		
		jsp = MANUFACTURER_JSP;
		title = "Manufacturer";
		map.put("title", title);
		map.put("parameterMap", parameterMap);
		if(itemIdFromBrandPopup != 0){
			
			return new ModelAndView(jsp, "map", map);
		}else{
			jsp+= ".jsp" ;
			map.put("contentJsp",jsp);
			return new ModelAndView("indexB", "map", map);	
		}
	}
    
	public ModelAndView showMatchedBrandList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		//String manufacturerCode  = null;
		//String manufacturerName = null;
		//String searchField= null;
		int itemId = 0;
		
		if(request.getParameter("itemId") != null && !(request.getParameter("itemId").equals(""))){
			itemId = Integer.parseInt(request.getParameter("itemId"));
			parameterMap.put("itemId", itemId);
		}

			boolean hinNoExist=true;
			String message=null;
			//Box box=HMSUtil.getBox(request);
			//String hinNo=box.getString("hinNo");
			map=pharmacyMasterHandlerService.showMatchedBrandList(parameterMap);
			
			jsp = "brandListForItem";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView(jsp, "map", map);

	}
	public ModelAndView searchManufacturer(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();  
		String manufacturerCode  = null;
		String manufacturerName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			manufacturerCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			manufacturerName = request.getParameter(SEARCH_NAME);
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
			manufacturerCode=searchField;
			manufacturerName=null;

		}else{
			manufacturerCode=null;
			manufacturerName=searchField;
		}
		map = pharmacyMasterHandlerService.searchManufacturer(manufacturerCode, manufacturerName);
		jsp=MANUFACTURER_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("manufacturerCode",manufacturerCode);
		map.put("manufacturerName",manufacturerName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addManufacturer(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map = new HashMap<String,Object>();
		MasManufacturer masManufacturer = new MasManufacturer();
		String changedBy = "";
		String contactPerson = "";
		String address1="";
		String address2="";
		int cityId=0;
		int stateId=0;
		String phoneNo="";
		String mobileNo="";
		String emailId="";
		String faxNo="";
		String url="";
		String licenceNo="";
		String salesTaxNo="";
		
		String cfDistributorName = "";
		String cfDistributorAddress1 = "";
		String cfDistributorAddress2 = "";
		
		int pinCode=0;
		int itemIdFromBrandPopup = 0;
		int brandIdFromBrandPopup = 0;
		Map<String, Object> listMap=new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> generalMapForBrandUpdate = new HashMap<String, Object>();
		Date currentDate = new Date();

		
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}		
			if (request.getParameter(CONTACT_PERSON) != null) {
				contactPerson = request.getParameter(CONTACT_PERSON);
			}
			if (request.getParameter(CF_DISTRIBUTOR_NAME) != null) {
				cfDistributorName = request.getParameter(CF_DISTRIBUTOR_NAME);
			}
			if (request.getParameter(CF_DISTRIBUTOR_ADDRESS1) != null) {
				cfDistributorAddress1 = request.getParameter(CF_DISTRIBUTOR_ADDRESS1);
			}
			if (request.getParameter(CF_DISTRIBUTOR_ADDRESS2) != null) {
				cfDistributorAddress2 = request.getParameter(CF_DISTRIBUTOR_ADDRESS2);
			}
			if (request.getParameter(ADDRESS1) != null) {
				address1 = request.getParameter(ADDRESS1);
			}
			if (request.getParameter(ADDRESS2) != null) {
				address2 = request.getParameter(ADDRESS2);
			}
			if (request.getParameter(DISTRICT) != null  && !request.getParameter(DISTRICT).equals("0")) {
				cityId = Integer.parseInt(request.getParameter(DISTRICT));
			}
			if (request.getParameter("itemIdFromBrandPopup") != null 
					&& !request.getParameter("itemIdFromBrandPopup").equals("0")) {
				itemIdFromBrandPopup = Integer.parseInt(request.getParameter("itemIdFromBrandPopup"));
			}
			if (request.getParameter("brandIdFromBrandPopup") != null 
					&& !request.getParameter("brandIdFromBrandPopup").equals("0")) {
				brandIdFromBrandPopup = Integer.parseInt(request.getParameter("brandIdFromBrandPopup"));
			}

			if (request.getParameter(STATE) != null  && !request.getParameter(STATE).equals("0")) {
				stateId = Integer.parseInt(request.getParameter(STATE));
			}
			if (!request.getParameter(PINCODE).equals("0") && !request.getParameter(PINCODE).equals("")) {
				pinCode = Integer.parseInt(request.getParameter(PINCODE));
			}
			if (request.getParameter(LICENCE_NO) != null) {
				licenceNo = request.getParameter(LICENCE_NO);
			}
			if (request.getParameter(SALES_TAX_NO) != null) {
				salesTaxNo = request.getParameter(SALES_TAX_NO);
			}
			
			if (request.getParameter(PHONE_NO) != null) {
				phoneNo = request.getParameter(PHONE_NO);
			}
			if (request.getParameter(MOBILE_NO) != null) {
				mobileNo = request.getParameter(MOBILE_NO);
			}
			if (request.getParameter(EMAIL_ID) != null) {
				emailId = request.getParameter(EMAIL_ID);
			}
			if (request.getParameter(FAX_NO) != null) {
				faxNo = request.getParameter(FAX_NO);
			}
			if (request.getParameter(URL) != null) {
				url = request.getParameter(URL);
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
		
		List manufacturerCodeList = new ArrayList();
		List manufacturerNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			manufacturerCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			manufacturerNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((manufacturerCodeList.size() == 0 || manufacturerCodeList == null) && (manufacturerNameList.size() == 0 || manufacturerNameList == null)){
			try{
				masManufacturer.setManufacturerCode(code);
				masManufacturer.setManufacturerName(name);
				masManufacturer.setContactPerson(contactPerson);				
				masManufacturer.setAddress1(address1);
				masManufacturer.setAddress2(address2);
				masManufacturer.setCfLocalDistributorName(cfDistributorName);
				masManufacturer.setCfLocalDistributorAddress1(cfDistributorAddress1);
				masManufacturer.setCfLocalDistributorAddress2(cfDistributorAddress2);
				
				if(cityId!=0){
				MasDistrict masDistrict= new MasDistrict();
				masDistrict.setId(cityId);
				masManufacturer.setCity(masDistrict);
				}
				if(stateId!=0){
				MasState masState= new MasState();
				masState.setId(stateId);
				masManufacturer.setState(masState);
				}
				masManufacturer.setLicenceNo(licenceNo);
				masManufacturer.setSalesTaxNo(salesTaxNo);
				if(pinCode!=0){
				masManufacturer.setPinCode(pinCode);
				}
				masManufacturer.setFaxNumber(faxNo);
				masManufacturer.setPhoneno(phoneNo);
				masManufacturer.setMobileno(mobileNo);
				masManufacturer.setEmailId(emailId);
				masManufacturer.setUrl(url);

				masManufacturer.setStatus("y");
				masManufacturer.setLastChgBy(changedBy);
				masManufacturer.setLastChgDate(currentDate);
				masManufacturer.setLastChgTime(currentTime);
				successfullyAdded = pharmacyMasterHandlerService.addManufacturer(masManufacturer);		
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(successfullyAdded){
				message="Record Added Successfully !!";
			}else{
				message="Try Again !!";
			}

		}else if((manufacturerCodeList.size() != 0 || manufacturerCodeList != null) || (manufacturerNameList.size() != 0) || manufacturerNameList != null){
			if((manufacturerCodeList.size() != 0 || manufacturerCodeList != null) && (manufacturerNameList.size() == 0 || manufacturerNameList == null)){
				message = "Manufacturer Code already exists.";
			}
			else if((manufacturerNameList.size() != 0 || manufacturerNameList != null) && (manufacturerCodeList.size() == 0 || manufacturerCodeList == null) ){
				message = "Manufacturer Name already exists.";
			}
			else if((manufacturerCodeList.size() != 0 || manufacturerCodeList != null) && (manufacturerNameList.size() != 0 || manufacturerNameList != null)){
				message = "Manufacturer Code and Manufacturer exist.";
			}
		}
		try{
			if(itemIdFromBrandPopup != 0){
				Map<String, Object> detailMapForBrandPopup = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				if(brandIdFromBrandPopup != 0){
					  

					if(successfullyAdded){
						generalMapForBrandUpdate.put("id", brandIdFromBrandPopup);
						generalMapForBrandUpdate.put("manufacturerId", masManufacturer.getId());
						generalMapForBrandUpdate.put("itemId", itemIdFromBrandPopup);
						detailMapForBrandPopup = pharmacyMasterHandlerService.editBrandToDatabase(generalMapForBrandUpdate);
						
					}
				}
				detailMapForBrandPopup.put("manufacturerId", masManufacturer.getId());
				map = pharmacyMasterHandlerService.showBrandJsp(box);
				jsp= "brand_popup";
				title="Add Manufacturer ";
				map.put("contentJsp", jsp);
				map.put("detailMapForBrandPopup", detailMapForBrandPopup);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView(jsp, "map", map);
			}else{
				map = pharmacyMasterHandlerService.showManufacturerJsp();
				jsp= MANUFACTURER_JSP;
				title="Add Manufacturer ";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("indexB", "map", map);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(itemIdFromBrandPopup != 0){
			return new ModelAndView(jsp, "map", map);
		}else{
			return new ModelAndView("indexB", "map", map);
		}
	}

	public ModelAndView editManufacturer(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		int manufacturerId = 0;
		String manufacturerCode="";
		String manufacturerName="";
		String contactPerson = "";
		String address1="";
		String address2="";
		int cityId=0;
		int stateId=0;
		String licenceNo="";
		String salesTaxNo="";
		int pinCode=0;
		String phoneNo="";
		String mobileNo="";
		String emailId="";
		String faxNo="";
		String url="";
		Date changedDate = null;
		String changedTime = "";
		String changedBy = null;

			if (request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))) {
				manufacturerId =Integer.parseInt( request.getParameter(COMMON_ID));
			}		
			if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
				manufacturerCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))) {
				manufacturerName = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter(CONTACT_PERSON) != null && !(request.getParameter(CONTACT_PERSON).equals(""))){
				contactPerson = request.getParameter(CONTACT_PERSON);
			}
			if (request.getParameter(ADDRESS1) != null && !(request.getParameter(ADDRESS1).equals(""))){
				address1 = request.getParameter(ADDRESS1);
			}
			if (request.getParameter(ADDRESS2)!= null && !(request.getParameter(ADDRESS2).equals(""))){
				address2 = request.getParameter(ADDRESS2);
			}
			if (!request.getParameter(DISTRICT).equals("0")) {
				cityId = Integer.parseInt(request.getParameter(DISTRICT));
			}
			if (!request.getParameter(STATE).equals("0")) {
				stateId = Integer.parseInt(request.getParameter(STATE));
			}
			if (!request.getParameter(PINCODE).equals("0")&& !request.getParameter(PINCODE).equals("")) {
				pinCode = Integer.parseInt(request.getParameter(PINCODE));
			}
			if (request.getParameter(LICENCE_NO) != null) {
				licenceNo = request.getParameter(LICENCE_NO);
			}
			if (request.getParameter(SALES_TAX_NO) != null) {
				salesTaxNo = request.getParameter(SALES_TAX_NO);
			}
			if (request.getParameter(PHONE_NO) != null && !(request.getParameter(PHONE_NO).equals(""))) {
				phoneNo = request.getParameter(PHONE_NO);
			}
			if (request.getParameter(MOBILE_NO) != null && !(request.getParameter(MOBILE_NO).equals(""))){
				mobileNo = request.getParameter(MOBILE_NO);
			}
			if (request.getParameter(EMAIL_ID) != null && !(request.getParameter(EMAIL_ID).equals(""))) {
				emailId = request.getParameter(EMAIL_ID);
			}
			if (request.getParameter(FAX_NO) != null && !(request.getParameter(FAX_NO).equals(""))) {
				faxNo = request.getParameter(FAX_NO);
			}
			if (request.getParameter(URL) != null && !(request.getParameter(URL).equals(""))){
				url = request.getParameter(URL);
			}
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				changedBy = request.getParameter(CHANGED_BY);
			}
			if(request.getParameter("title") != null){
				title = request.getParameter("title"); 		
			}
			
			
			
			
			
			try {			
			changedDate = new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		
			generalMap.put("id",manufacturerId);
			generalMap.put("manufacturerCode",manufacturerCode);
			generalMap.put("name",manufacturerName);
			generalMap.put("contactPerson",contactPerson);
			generalMap.put("address1",address1);
			generalMap.put("address2",address2);
			generalMap.put("cityId",cityId);
			generalMap.put("stateId",stateId);
			generalMap.put("pinCode",pinCode);
			generalMap.put("licenceNo",licenceNo);
			generalMap.put("salesTaxNo",salesTaxNo);
			generalMap.put("phoneNo",phoneNo);
			generalMap.put("mobileNo",mobileNo);
			generalMap.put("emailId",emailId);
			generalMap.put("faxNo",faxNo);
			generalMap.put("url",url);
			generalMap.put("changedBy",changedBy);
			generalMap.put("currentDate",changedDate);
			generalMap.put("currentTime",changedTime);
		}catch (Exception e) {
			e.printStackTrace();
		}
			boolean dataUpdated=false;

			dataUpdated=pharmacyMasterHandlerService.editManufacturerToDatabase(generalMap);

			if(dataUpdated==true){
				message="Record Updated Successfully !!";
			}
			else{
				message="Record Cant be Updated !!";
			}
			url = "/hms/hms/pharmacy?method=showManufacturerJsp";
			try{
				   map = pharmacyMasterHandlerService.showManufacturerJsp();
				    }catch (Exception e) {
				    	e.printStackTrace();
				    }
				    jsp=MANUFACTURER_JSP;
				    title="Update Manufacturer";
				    jsp += ".jsp";			    
				    map.put("contentJsp", jsp);
				    map.put("title", title);
				    map.put("message", message);
				    return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView deleteManufacturer(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int manufacturerId=0;
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
			manufacturerId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deleteManufacturer(manufacturerId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showManufacturerJsp";
		try{
			   map = pharmacyMasterHandlerService.showManufacturerJsp();
			    }catch (Exception e) {
			    	e.printStackTrace();
			    }
			    jsp=MANUFACTURER_JSP;
			    title="Delete manufacturer";
			    jsp += ".jsp";			    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
		}



//	--------------------Store Supplier  Report-------------------------------------------------------
	

	public ModelAndView reportStoreSupplier(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> parameters  = new HashMap<String, Object>();
		Map<String, Object> map  = new HashMap<String, Object>();
		parameters=pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Item_Supplier", parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);	
			 
	}
// ---------------------------For Store Supplier Master-------------------------------------

	 @SuppressWarnings("unchecked")
	 public ModelAndView showStoreSupplierJsp(HttpServletRequest request, HttpServletResponse response) {

	  session = request.getSession();
	  Map<String, Object> map = new HashMap<String, Object>();
	  Map<String, Object> dataMap = new HashMap<String, Object>();
	  int hospitalId=0;
	  int deptId=0;
	  
	if (session.getAttribute("hospitalId") != null)
		hospitalId = Integer.parseInt(""
				+ session.getAttribute("hospitalId"));
	if (session.getAttribute("deptId") != null)
		deptId = Integer.parseInt("" + session.getAttribute("deptId"));
	
	dataMap.put("hospitalId",hospitalId);
	dataMap.put("deptId",deptId);
	
	  map = pharmacyMasterHandlerService.showStoreSupplierJsp(dataMap);
	  jsp = STORE_SUPPLIER_JSP;
	  jsp += ".jsp";
	  title = " Supplier";
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  return new ModelAndView("indexB", "map", map);
	 }

	 public ModelAndView showStoreSupplierJspForCRV(HttpServletRequest request, HttpServletResponse response) {

		  session = request.getSession();
		  Map<String, Object> map = new HashMap<String, Object>();
		  Map<String, Object> dataMap = new HashMap<String, Object>();
		  int hospitalId=0;
		  int deptId=0;
		  
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		
		dataMap.put("hospitalId",hospitalId);
		dataMap.put("deptId",deptId);
		
		  map = pharmacyMasterHandlerService.showStoreSupplierJsp(dataMap);
		  
		  jsp = STORE_SUPPLIER_JSP;
		  //jsp += ".jsp";
		  title = " Supplier";
		  map.put("contentJsp",jsp);
		  map.put("title", title);
		  return new ModelAndView(jsp, "map", map);
		 }
	 
	 @SuppressWarnings("unchecked")
	 public ModelAndView addStoreSupplier(HttpServletRequest request, HttpServletResponse response) 
	 {
	  Map<String,Object> map = new HashMap<String,Object>();
	  MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
	  MasManufacturer masManufacturer = new MasManufacturer();

	  int storeSupplierTypeId=0;
	  String changedBy = "";
	  
	  String pinNo="";
	  String tinNo="";
	  String licenceNo="";
	  String salesTaxNo="";
	  String typeOfReg="";
	    
	  String address1="";
	  String address2="";
	  int city=0;
	  int state=0;
	  String phoneNo="";
	  String mobileNo="";
	  int pinCode=0;
	  String emailId="";
	  String faxNo="";
	  String url="";
	  int groupId = 0;
	  
	  String localAddress1="";
	  String localAddress2="";
	  int localCity=0;
	  String localPhoneNo="";
	  int localPinCode=0;
	  int localState=0;
	  
	  String fdrReceiptAttached="";
	  
	  String cfDistributorName = "";
	  String cfDistributorAddress1 = "";
	  String cfDistributorAddress2 = "";
	  
	  String[] manufacturerIdArray = null;
	  String[] groupIdArray = null; 
	  
	  StringBuffer manufacturerStr = new StringBuffer();
	  StringBuffer groupStr = new StringBuffer();
	  
	  
	  Map<String, Object> listMap=new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();
	  Date currentDate = new Date();

	  Map<String, Object> dataMap = new HashMap<String, Object>();
	  int hospitalId=0;
	  int deptId=0;
	  
	if (session.getAttribute("hospitalId") != null)
		hospitalId = Integer.parseInt(""
				+ session.getAttribute("hospitalId"));
	if (session.getAttribute("deptId") != null)
		deptId = Integer.parseInt("" + session.getAttribute("deptId"));
	
	   if (request.getParameter(CODE) != null) {
	    code = request.getParameter(CODE);
	   }
	   if (request.getParameter(SEARCH_NAME) != null) {
	    name = request.getParameter(SEARCH_NAME);
	   }  
	   if (request.getParameter(STORE_SUPPLIER_TYPE_ID) != null) {
		   storeSupplierTypeId = Integer.parseInt(request.getParameter(STORE_SUPPLIER_TYPE_ID));
	   }
	   if (request.getParameter(PIN_NUMBER) != null) {
		    pinNo = request.getParameter(PIN_NUMBER);
	   }
	   if (request.getParameter(TIN_NUMBER) != null) {
		    tinNo = request.getParameter(TIN_NUMBER);
	   }
	   if (request.getParameter(ADDRESS1) != null) {
	    address1 = request.getParameter(ADDRESS1);
	   }
	   if (request.getParameter(ADDRESS2) != null) {
	    address2 = request.getParameter(ADDRESS2);
	   }
	   if (request.getParameter(LOCAL_ADDRESS1) != null) {
		    localAddress1 = request.getParameter(LOCAL_ADDRESS1);
		   }
	   if (request.getParameter(LOCAL_ADDRESS2) != null) {
			   localAddress2 = request.getParameter(LOCAL_ADDRESS2);
		   }
	   if (!request.getParameter(DISTRICT).equals("0")) {
	    city = Integer.parseInt(request.getParameter(DISTRICT));
	   }
	   if (!request.getParameter(STATE).equals("0")) {
		    state = Integer.parseInt(request.getParameter(STATE));
		   }
	   if (request.getParameter(LOCAL_CITY) != null && !request.getParameter(LOCAL_CITY).equals("0")) {
		    localCity = Integer.parseInt(request.getParameter(LOCAL_CITY));
		   }
	   if (request.getParameter(PHONE_NO) != null && !request.getParameter(LOCAL_STATE).equals("0")) {
		    localState = Integer.parseInt(request.getParameter(LOCAL_STATE));
		   }
	   if ( request.getParameter(PHONE_NO) != null) {
	    phoneNo = request.getParameter(PHONE_NO);
	   }
	   if (request.getParameter(LOCAL_PHONE_NO) != null) {
		    localPhoneNo = request.getParameter(LOCAL_PHONE_NO);
		   }
	   if (request.getParameter(MOBILE_NO) != null) {
	    mobileNo = request.getParameter(MOBILE_NO);
	   }
	   if (!request.getParameter(PINCODE).equals("0")&& !request.getParameter(PINCODE).equals("")) {
			pinCode = Integer.parseInt(request.getParameter(PINCODE));
		}
	   if (!request.getParameter(LOCAL_PINCODE).equals("0") && !request.getParameter(LOCAL_PINCODE).equals("")) {
			localPinCode = Integer.parseInt(request.getParameter(LOCAL_PINCODE));
		}
	   
	   if (request.getParameter(TYPE_OF_REG) != null) {
		    typeOfReg = request.getParameter(TYPE_OF_REG);
	   }
	   if (request.getParameterValues(MANUFACTURER_ID) != null && !request.getParameterValues(MANUFACTURER_ID).equals("0")) {
			manufacturerIdArray = (String[])(request.getParameterValues(MANUFACTURER_ID));
			for (int i = 0; i < manufacturerIdArray.length; i++) {
				manufacturerStr.append(manufacturerIdArray[i]);
				manufacturerStr.append(",");
			}
			 manufacturerStr.deleteCharAt(manufacturerStr.length()-1);
			 generalMap.put("manufacturerStr", manufacturerStr.toString());
	   }
		if (request.getParameterValues(GROUP_ID) != null && !request.getParameterValues(GROUP_ID).equals("0")) {
			groupIdArray = (String[])(request.getParameterValues(GROUP_ID));
			for (int i = 0; i < groupIdArray.length; i++) {
				groupStr.append(groupIdArray[i]);
				groupStr.append(",");
			}
			 groupStr.deleteCharAt(groupStr.length()-1);
			 generalMap.put("groupStr", groupStr.toString());
		}
		    
	    if (request.getParameter(LICENCE_NO) != LICENCE_NO) {
			licenceNo = request.getParameter(LICENCE_NO);
		}
		if (request.getParameter(SALES_TAX_NO) != null) {
			salesTaxNo = request.getParameter(SALES_TAX_NO);
		}
	   if (request.getParameter(EMAIL_ID) != null) {
	    emailId = request.getParameter(EMAIL_ID);
	   }
	   if (request.getParameter(FAX_NO) != null) {
	    faxNo = request.getParameter(FAX_NO);
	   }
	   if (request.getParameter(URL) != null) {
	    url = request.getParameter(URL);
	   }
	   
	   if (request.getParameter(CF_DISTRIBUTOR_NAME) != null) {
			cfDistributorName = request.getParameter(CF_DISTRIBUTOR_NAME);
		}
		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS1) != null) {
			cfDistributorAddress1 = request.getParameter(CF_DISTRIBUTOR_ADDRESS1);
		}
		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS2) != null) {
			cfDistributorAddress2 = request.getParameter(CF_DISTRIBUTOR_ADDRESS2);
		}
		
		if (request.getParameter("FDR") != null) {
			fdrReceiptAttached = request.getParameter("FDR");
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
	   
	 

	  try{

	   listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
	  }catch (Exception e) {
		  e.printStackTrace();
	  }

	  List supplierCodeList = new ArrayList();
	  List supplierNameList = new  ArrayList();

	  if(listMap.get("duplicateGeneralCodeList") != null){
	   supplierCodeList = (List)listMap.get("duplicateGeneralCodeList");

	  }
	  if(listMap.get("duplicateGeneralNameList") != null){
	   supplierNameList = (List)listMap.get("duplicateGeneralNameList");

	  }
	  boolean successfullyAdded = false;

	  if((supplierCodeList == null || supplierCodeList.size() == 0) && (supplierNameList == null || supplierNameList.size() == 0)){
	   
	    masStoreSupplier.setSupplierCode(code);
	    masStoreSupplier.setSupplierName(name);
	    
	    MasHospital masHospital=new MasHospital();
	    masHospital.setId(hospitalId);
	    MasStoreSupplierType masStoreSupplierType = new MasStoreSupplierType();
	    masStoreSupplierType.setId(storeSupplierTypeId);
	    masStoreSupplier.setSupplierType(masStoreSupplierType);
	    
	    masStoreSupplier.setTinNo(tinNo);
	    masStoreSupplier.setHospital(masHospital);
	    
	    masStoreSupplier.setSalesTaxNo(salesTaxNo);
	   
	    masStoreSupplier.setTypeOfReg(typeOfReg);
	    masStoreSupplier.setLicenceNo(licenceNo);
	   
	    masStoreSupplier.setPinNo(pinNo);
	    
	    masStoreSupplier.setAddress1(address1);
	    masStoreSupplier.setAddress2(address2);
	    
	    masStoreSupplier.setCfLocalDistributorName(cfDistributorName);
	    masStoreSupplier.setCfLocalDistributorAddress1(cfDistributorAddress1);
	    masStoreSupplier.setCfLocalDistributorAddress2(cfDistributorAddress2);
	    masStoreSupplier.setFdrReceiptAttached(fdrReceiptAttached);

	    if (city !=0)
	    {
		MasDistrict masDistrict= new MasDistrict();
		masDistrict.setId(city);
		masStoreSupplier.setCity(masDistrict);
	    }
	    else
	    {
	    masStoreSupplier.setCity(null);
	    }
		
	    if (state != 0)
	    {
		MasState masState= new MasState();
		masState.setId(state);
		masStoreSupplier.setState(masState);
	    }
	    else
	    {
	    masStoreSupplier.setState(null);
	    }
	    
	    masStoreSupplier.setFaxNumber(faxNo);
	    
	    masStoreSupplier.setPhoneNo(phoneNo);
	    
	    
	    masStoreSupplier.setMobileNo(mobileNo);
	    
	    masStoreSupplier.setPinCode(pinCode);
	    
	    masStoreSupplier.setEmailId(emailId);
	    
	    masStoreSupplier.setUrl(url);
	    masStoreSupplier.setLocalAddress1(localAddress1);
	    masStoreSupplier.setLocalAddress2(localAddress2);
	    
	    if (localCity!=0)
	    {
	    MasDistrict masDistrictLocal= new MasDistrict();
	    masDistrictLocal.setId(localCity);
		masStoreSupplier.setLocalCity(masDistrictLocal);
	    }
	    else
	    {
	    masStoreSupplier.setLocalCity(null);
	    }
		
		if (localState!=0)
		{
	    MasState masStateLocal= new MasState();
		masStateLocal.setId(localState);
		masStoreSupplier.setLocalState(masStateLocal);
		}
		else
		{
		masStoreSupplier.setLocalState(null);			
		}
	    
	    masStoreSupplier.setLocalPinCode(localPinCode);
	    masStoreSupplier.setLocalPhoneNo(localPhoneNo);
	  	    
	    masStoreSupplier.setStatus("y");
	    masStoreSupplier.setLastChgBy(changedBy);
	    masStoreSupplier.setLastChgDate(currentDate);
	    masStoreSupplier.setLastChgTime(currentTime);
	    
	    generalMap.put("changedBy", changedBy);
	    generalMap.put("currentDate", currentDate);
	    generalMap.put("currentTime", currentTime);
	    
	    
	    /*
	     *  If supplier type is Manufacturer, then the same record will be stored in Mas Manufacturer table
	     *  also apart from mas_store_Supplier. 
	     */
	    if (storeSupplierTypeId==2) 
	    {
	    	
	    	masManufacturer.setManufacturerCode(code);
	    	masManufacturer.setManufacturerName(name);
	    	masManufacturer.setStatus("y");
	    	masManufacturer.setSalesTaxNo(salesTaxNo);
	    	masManufacturer.setLicenceNo(licenceNo);
	    	masManufacturer.setAddress1(address1);
	    	masManufacturer.setAddress2(address2);
    	    masManufacturer.setCfLocalDistributorName(cfDistributorName);
  		    masManufacturer.setCfLocalDistributorAddress1(cfDistributorAddress1);
   		    masManufacturer.setCfLocalDistributorAddress2(cfDistributorAddress2);

   		    if (city !=0)
	    	{
	    			MasDistrict masDistrict= new MasDistrict();
	    			masDistrict.setId(city);
	    			masStoreSupplier.setCity(masDistrict);
	    			masManufacturer.setCity(masDistrict);
	    	 }
	    	 else
	    	 {
	    		 	masStoreSupplier.setCity(null);
	    		 	masManufacturer.setCity(null);
	    	 }


		    if (state != 0)
		    {
			MasState masState= new MasState();
			masState.setId(state);
			masStoreSupplier.setState(masState);
			masManufacturer.setState(masState);
		    }
		    else
		    {
		    masStoreSupplier.setState(null);
		    masManufacturer.setState(null);
		    }


		    masManufacturer.setFaxNumber(faxNo);

		    masManufacturer.setPhoneno(phoneNo);

	    	masManufacturer.setMobileno(mobileNo);
  		    masManufacturer.setPinCode(pinCode);
  		    masManufacturer.setEmailId(emailId);
    	    masManufacturer.setUrl(url);
    	    masManufacturer.setLastChgBy(changedBy);
   		    masManufacturer.setLastChgDate(currentDate);
   		    masManufacturer.setLastChgTime(currentTime);
   		    generalMap.put("masManufacturer", masManufacturer);
	    }
	    
	    successfullyAdded = pharmacyMasterHandlerService.addStoreSupplier(masStoreSupplier, generalMap);  
	   
	   if(successfullyAdded){
	    message="Record Added Successfully";
	   }else{
	    message="Try Again !";
	   }

	  }else if((supplierCodeList.size() != 0 || supplierCodeList != null) || (supplierNameList.size() != 0) || supplierNameList != null){
	   if((supplierCodeList.size() != 0 || supplierCodeList != null) && (supplierNameList.size() == 0 || supplierNameList == null)){
	    message = "Supplier Code already exists.";
	   }
	   else if((supplierNameList.size() != 0 || supplierNameList != null) && (supplierCodeList.size() == 0 || supplierCodeList == null) ){
	    message = "Supplier Name already exists.";
	   }
	   else if((supplierCodeList.size() != 0 || supplierCodeList != null) && (supplierNameList.size() != 0 || supplierNameList != null)){
	    message = "Supplier Code and Supplier exist.";
	   }
	  }

	  try{
		  
		  
		
		dataMap.put("hospitalId",hospitalId);
		dataMap.put("deptId",deptId);
		
		  map = pharmacyMasterHandlerService.showStoreSupplierJsp(dataMap);
	  
	   
	  }catch (Exception e) {
		  e.printStackTrace();
	  }
	  jsp= STORE_SUPPLIER_JSP;
	  title="Add Store Supplier ";
	  jsp += ".jsp";

	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("indexB", "map", map);

	 }

	 @SuppressWarnings("unchecked")
	public ModelAndView editStoreSupplier(HttpServletRequest request, HttpServletResponse response) 
	 {
	  Map<String, Object> map = new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();
	  Map<String, Object> listMap = new HashMap<String, Object>();
	  session=request.getSession();
	  int  storeSupplierId=0;
	  int  storeSupplierTypeId=0;
	  String pinNo="";
	  String tinNo="";
	  String licenceNo="";
	  String salesTaxNo="";
	  String typeOfReg="";
	    
	  String address1="";
	  String address2="";
	  int city=0;
	  int state=0;
	  String phoneNo="";
	  String mobileNo="";
	  int pinCode=0;
	  String emailId="";
	  String faxNo="";
	  String url="";
	  String storeSupplierCode="";
	  String storeSupplierName="";
	  String localAddress1="";
	  String localAddress2="";
	  int localCity=0;
	  String localPhoneNo="";
	  int localPinCode=0;
	  int manuFacturerId=0;
	  int localState=0;
	  int groupId = 0;

	  String cfDistributorName = "";
	  String cfDistributorAddress1 = "";
	  String cfDistributorAddress2 = "";
	  String fdrReceiptAttached = "";
	  
	  String changedTime = "";
	  Date changedDate = null;
	  String changedBy = null;
	  
	  String[] manufacturerIdArray = null;
	  String[] groupIdArray = null; 
	  StringBuffer manufacturerStr = new StringBuffer();
	  StringBuffer groupStr = new StringBuffer();

	  storeSupplierCode=(String )session.getAttribute("storeSupplierCode");
	  storeSupplierName=(String )session.getAttribute("storeSupplierName");
	  
	   if (!request.getParameter(COMMON_ID).equals("0")) {
		    storeSupplierId = Integer.parseInt(request.getParameter(COMMON_ID));
	   }
	   if (request.getParameter(CODE) != null) {
		   storeSupplierCode = request.getParameter(CODE);
	   }
	   if (request.getParameter(SEARCH_NAME) != null) {
		   storeSupplierName = request.getParameter(SEARCH_NAME);
	   }
	   if (!request.getParameter(STORE_SUPPLIER_TYPE_ID).equals("0")) {
	       storeSupplierTypeId = Integer.parseInt(request.getParameter(STORE_SUPPLIER_TYPE_ID));
	   }
	   if (request.getParameter(PIN_NUMBER) != null) {
		    pinNo = request.getParameter(PIN_NUMBER);
	   }
	   if (request.getParameter(TIN_NUMBER) != null) {
		    tinNo = request.getParameter(TIN_NUMBER);
	   }
	   if (request.getParameter(ADDRESS1) != null) {
	    address1 = request.getParameter(ADDRESS1);
	   }
	   if (request.getParameter(ADDRESS2) != null) {
	    address2 = request.getParameter(ADDRESS2);
	   }
	   if (request.getParameter(LOCAL_ADDRESS1) != null) {
		    localAddress1 = request.getParameter(LOCAL_ADDRESS1);
		   }
	   if (request.getParameter(LOCAL_ADDRESS2) != null) {
			   localAddress2 = request.getParameter(LOCAL_ADDRESS2);
		   }
	   if (!request.getParameter(DISTRICT).equals("0")) {
		    city = Integer.parseInt(request.getParameter(DISTRICT));
		   }
	   if (!request.getParameter(STATE).equals("0")) {
		    state = Integer.parseInt(request.getParameter(STATE));
		   }
	   if (request.getParameter(LOCAL_CITY) != null && !request.getParameter(LOCAL_CITY).equals("0")) {
		    localCity = Integer.parseInt(request.getParameter(LOCAL_CITY));
		   }
	   if (request.getParameter(LOCAL_STATE) != null &&  !request.getParameter(LOCAL_STATE).equals("0")) {
		    localState = Integer.parseInt(request.getParameter(LOCAL_STATE));
		   }
	   if (request.getParameter(PHONE_NO) != null) {
	    phoneNo = request.getParameter(PHONE_NO);
	   }
	   if (request.getParameter(LOCAL_PHONE_NO) != null) {
		    localPhoneNo = request.getParameter(LOCAL_PHONE_NO);
		   }
	   if (request.getParameter(MOBILE_NO) != null) {
	    mobileNo = request.getParameter(MOBILE_NO);
	   }
	   
	   if (!request.getParameter(PINCODE).equals("0")&& !request.getParameter(PINCODE).equals("")) {
			pinCode = Integer.parseInt(request.getParameter(PINCODE));
		}
	   if (!request.getParameter(LOCAL_PINCODE).equals("0") && !request.getParameter(LOCAL_PINCODE).equals("")) {
		   localPinCode = Integer.parseInt(request.getParameter(LOCAL_PINCODE));
		}
	   /*if (!request.getParameter(PINCODE).equals("0")) {
		    pinCode = Integer.parseInt(request.getParameter(PINCODE));
		   }
	   if (!request.getParameter(LOCAL_PINCODE).equals("0")) {
		    localPinCode = Integer.parseInt(request.getParameter(LOCAL_PINCODE));
		   }*/
	   if (request.getParameter(TYPE_OF_REG) != null) {
		    typeOfReg = request.getParameter(TYPE_OF_REG);
		   }
	   
	   if (request.getParameter(MANUFACTURER_ID) != null && !request.getParameter(MANUFACTURER_ID).equals("")) {
		    manuFacturerId = Integer.parseInt(request.getParameter(MANUFACTURER_ID));
		   }
	   if (request.getParameter(LICENCE_NO) != null) {
			licenceNo = request.getParameter(LICENCE_NO);
		}
		if (request.getParameter(SALES_TAX_NO) != null) {
			salesTaxNo = request.getParameter(SALES_TAX_NO);
		}
	   if (request.getParameter(EMAIL_ID) != null) {
	    emailId = request.getParameter(EMAIL_ID);
	   }
	   if (request.getParameter(FAX_NO) != null) {
	    faxNo = request.getParameter(FAX_NO);
	   }
	   if (request.getParameter(URL) != null) {
	    url = request.getParameter(URL);
	   }

	   if (request.getParameter(CF_DISTRIBUTOR_NAME) != null) 
	   {
		   cfDistributorName = request.getParameter(CF_DISTRIBUTOR_NAME);
	   }
	   
	   if (request.getParameter(CF_DISTRIBUTOR_ADDRESS1) != null) 
	   {
		   cfDistributorAddress1 = request.getParameter(CF_DISTRIBUTOR_ADDRESS1);
	   }
		
		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS2) != null) {
			cfDistributorAddress2 = request.getParameter(CF_DISTRIBUTOR_ADDRESS2);
		}
		
		if (request.getParameter("FDR") != null) {
				fdrReceiptAttached = request.getParameter("FDR");
		}
		
		if (request.getParameter(GROUP_ID) != null) {
			   groupId = Integer.parseInt(request.getParameter(GROUP_ID));
		}
		
		if (request.getParameterValues(MANUFACTURER_ID)!=null && request.getParameterValues(MANUFACTURER_ID).length > 0) {
			manufacturerIdArray = (String[])(request.getParameterValues(MANUFACTURER_ID));
		
			for (int i = 0; i < manufacturerIdArray.length; i++) {
				manufacturerStr.append(manufacturerIdArray[i]);
				manufacturerStr.append(",");
			}
			manufacturerStr.deleteCharAt(manufacturerStr.length()-1);
		}
		
		if (request.getParameterValues(GROUP_ID)!=null && request.getParameterValues(GROUP_ID).length > 0) {
			groupIdArray = (String[])(request.getParameterValues(GROUP_ID));
		
			for (int i = 0; i < groupIdArray.length; i++) {
				groupStr.append(groupIdArray[i]);
				groupStr.append(",");
			}
			groupStr.deleteCharAt(groupStr.length()-1);
		}
		
	   if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
	      changedBy = request.getParameter(CHANGED_BY);
	   }
	   if(request.getParameter("pojoPropertyName") != null){
	      pojoPropertyName = request.getParameter("pojoPropertyName"); 
	   }
	   if(request.getParameter("pojoName") != null){
	      pojoName = request.getParameter("pojoName"); 
	   }
	   
	   
	  
	   changedDate = new Date();
	   changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	    
	   generalMap.put("manufacturerStr", manufacturerStr.toString());
	   generalMap.put("groupStr", groupStr.toString());
	  
	   generalMap.put("id",storeSupplierId);
	   generalMap.put("code",storeSupplierCode);
	   generalMap.put("name",storeSupplierName);
	   generalMap.put("storeSupplierTypeId",storeSupplierTypeId);
	   generalMap.put("tinNo",tinNo);
	   generalMap.put("pinNo",pinNo);
	   generalMap.put("salesTaxNo",salesTaxNo);
	   generalMap.put("typeOfReg",typeOfReg);
	   generalMap.put("licenceNo",licenceNo);
	   generalMap.put("address1",address1);
	   generalMap.put("address2",address2);
	   generalMap.put("city",city);
	   generalMap.put("state",state);
	   generalMap.put("phoneNo",phoneNo);
	   generalMap.put("mobileNo",mobileNo);
	   generalMap.put("pinCode",pinCode);
	   generalMap.put("emailId",emailId);
	   generalMap.put("faxNo",faxNo);
	   generalMap.put("url",url);
	   generalMap.put("localAddress1",localAddress1);
	   generalMap.put("localAddress2",localAddress2);
	   generalMap.put("localCity",localCity);
	   generalMap.put("localState",localState);
	   generalMap.put("localPhoneNo",localPhoneNo);
	   generalMap.put("manuFacturerId",manuFacturerId);
	   generalMap.put("localPinCode",localPinCode);
	   
	   generalMap.put("cfDistributorName",cfDistributorName);
	   generalMap.put("cfDistributorAddress1",cfDistributorAddress1);
	   generalMap.put("cfDistributorAddress2",cfDistributorAddress2);
	   generalMap.put("fdrReceiptAttached",fdrReceiptAttached);
	   
	   generalMap.put("groupId", groupId);
	   
	   generalMap.put("changedBy", changedBy);
	   generalMap.put("currentDate", changedDate);
	   generalMap.put("currentTime", changedTime);
	   generalMap.put("pojoPropertyName", pojoPropertyName);
	   generalMap.put("pojoName", pojoName);

	   generalMap.put("flag", true);

	   listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
	   List existingSupplierNameList = (List)listMap.get("duplicateMastersList");
	  
	   boolean dataUpdated=false;
	   if(existingSupplierNameList == null || existingSupplierNameList.size() == 0)
	   {
		   dataUpdated=pharmacyMasterHandlerService.editStoreSupplierToDatabase(generalMap);
	   	   if(dataUpdated==true)
	   	   {
			 message="Record updated Successfully !!";
		   }
		   else
		   {
			 message="Record Cant be updated !!";
		   }
	   } 
	   else if(existingSupplierNameList.size() > 0){

	    message = "Name already exists.";
	    

	   }
	   Map<String, Object> dataMap = new HashMap<String, Object>();
		  int hospitalId=0;
		  int deptId=0;
		  
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		
		dataMap.put("hospitalId",hospitalId);
		dataMap.put("deptId",deptId);
		
		  map = pharmacyMasterHandlerService.showStoreSupplierJsp(dataMap);
	 
	   
	  jsp= STORE_SUPPLIER_JSP;
	  title="Edit Store Supplier ";
	  jsp += ".jsp";

	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("indexB", "map", map);

	 }


	 @SuppressWarnings("unchecked")
	 public ModelAndView searchStoreSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException{
	  Map<String, Object> map= new HashMap<String, Object>();  
	  String searchField  = null;
	  String storeSupplierCode= null;
	  String storeSupplierName= null; 
	  session=request.getSession();
	  int hospitalId=0;
	  int deptId=0;
	  if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		
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
	   storeSupplierCode=searchField;
	   storeSupplierName=null;

	  }else{
	   storeSupplierCode=null;
	   storeSupplierName=searchField;
	  }
	  map = pharmacyMasterHandlerService.searchStoreSupplier(storeSupplierCode, storeSupplierName,hospitalId,deptId);
	  jsp=STORE_SUPPLIER_JSP;

	  jsp += ".jsp";
	  map.put("contentJsp",jsp);
	  map.put("title", title);
	  map.put("search", "search");
	  map.put("storeSupplierCode",storeSupplierCode);
	  map.put("storeSupplierName",storeSupplierName);
	  map.put("vendor_code",request.getParameter("vendor_code"));
	  System.out.println("request.getParameter()"+request.getParameter("code"));


	  return new ModelAndView("indexB", "map", map);
	 }

	 public ModelAndView deleteStoreSupplier(HttpServletRequest request, HttpServletResponse response) {
	  Map<String, Object> map = new HashMap<String, Object>();
	  int storeSuppliedId=0;
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
	   storeSuppliedId =Integer.parseInt( request.getParameter(COMMON_ID));
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
	  dataDeleted=pharmacyMasterHandlerService.deleteStoreSupplier(storeSuppliedId,generalMap);
	  if (dataDeleted==true)
	  {

	   message="Record is InActivated successfully";
	  }

	  else{
	   message="Record is Activated successfully";
	  }
	  try{
		  
		  Map<String, Object> dataMap = new HashMap<String, Object>();
		  int hospitalId=0;
		  int deptId=0;
		  
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		
		dataMap.put("hospitalId",hospitalId);
		dataMap.put("deptId",deptId);
		
		  map = pharmacyMasterHandlerService.showStoreSupplierJsp(dataMap);
	   
	   
	  }catch (Exception e) {
		  e.printStackTrace();
	  }
	  jsp= STORE_SUPPLIER_JSP;
	  title="Delete Store Supplier ";
	  jsp += ".jsp";

	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("indexB", "map", map);


	 }
/*//		--------------------Item Wise Supplier Report-------------------------------------------------------
		

		public ModelAndView reportItemWiseSupplier(HttpServletRequest request,HttpServletResponse response) 
		{
			Map<String, Object> parameters  = new HashMap<String, Object>();
			Map<String, Object> map  = new HashMap<String, Object>();
			parameters=pharmacyMasterHandlerService.getConnection();
			HMSUtil.generateReport("Mas_Item_Wise_Supplier", parameters, (Connection)parameters.get("conn"), response, getServletContext());
			return new ModelAndView("index", "map", map);	
				 
		}
	// ---------------------------For Item Wise Supplier-----------------------------------End-----
	 @SuppressWarnings("unchecked")
	 public ModelAndView showItemWiseSupplier(HttpServletRequest request, HttpServletResponse response){
	  //System.out.println("This is showSupplierJsp");
	  String jsp=ITEM_WISE_SUPPLIER_JSP;
	  Map<String,Object> map = new HashMap<String,Object>();
	  try{  
	   map=(Map)pharmacyMasterHandlerService.getItemWiseSupplier();

	  }catch (Exception e) {
	   //System.out.println("Exception in getItemWiseSupplier------"+e);
	  }
	  jsp += ".jsp";
	  title = "Item Wise Suppiler";  
	  map.put("contentJsp", jsp);
	  map.put("title", title);

	  return new ModelAndView("index","map",map);
	 }
	 
	 @SuppressWarnings("unchecked")
	 public ModelAndView addItemWiseSupplier(HttpServletRequest request, HttpServletResponse response){
	  int itemId=0;
	  int supplierId=0;
	  String changedBy="";
	  Date currentDate=new Date();
	  Map<String,Object> map=new HashMap<String,Object>();
	  try{
	   if(request.getParameter(ITEM_ID) != null && !(request.getParameter(ITEM_ID).equals(""))){
	    itemId =Integer.parseInt( request.getParameter(ITEM_ID));
	   }
	   if(request.getParameter(STORE_SUPPLIER_ID) != null && !(request.getParameter(STORE_SUPPLIER_ID).equals(""))){
	    supplierId =Integer.parseInt( request.getParameter(STORE_SUPPLIER_ID));
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
	   }catch (Exception e) {
	   //System.out.println("eeeeeeeeeee   "+e);
	  }
	  boolean flag=pharmacyMasterHandlerService.checkItem(itemId);
	  boolean saved=false;

	  if(flag)
	  {
	   message="Item Already Exists";
	  }else{
	   MasItemWiseSupplier masStoreItemWiseSupplier=new MasItemWiseSupplier();
	   try{

		   MasStoreItem masStoreItem=new MasStoreItem();
	    masStoreItem.setId(itemId);
	    masStoreItemWiseSupplier.setItem(masStoreItem);

	    MasStoreSupplier masStoreSupplier=new MasStoreSupplier();
	    masStoreSupplier.setId(supplierId);
	    masStoreItemWiseSupplier.setSupplier(masStoreSupplier);
	    
	    masStoreItemWiseSupplier.setStatus("y");
	    masStoreItemWiseSupplier.setLastChgBy(changedBy);
	    masStoreItemWiseSupplier.setLastChgDate(currentDate);
	    masStoreItemWiseSupplier.setLastChgTime(currentTime);
	   }catch (Exception e) {
	    //System.out.println("wwwwwwwwww  "+e);
	   }

	   saved=pharmacyMasterHandlerService.addItemWiseSupplier(masStoreItemWiseSupplier);
	   if(saved){
	    message="Record Added Successfully !!";
	   }else {
	    message="Try Again !!";
	   }
	  }
	  try{
	   map = pharmacyMasterHandlerService.getItemWiseSupplier();
	   
	  }catch (Exception e) {
	   //System.out.println("Exception in getItemWiseSupplier "+e);
	  }
	  jsp= ITEM_WISE_SUPPLIER_JSP;
	  title="Add Item Wise Supplier";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
	 }
	 public ModelAndView deleteItemWiseSupplier(HttpServletRequest request, HttpServletResponse response){
	  Map<String, Object> map = new HashMap<String, Object>();
	  int itemWiseSupplierId=0;
	  String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
	   itemWiseSupplierId =Integer.parseInt( request.getParameter(COMMON_ID));
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
	  dataDeleted=pharmacyMasterHandlerService.deleteItemWiseSupplier(itemWiseSupplierId,generalMap);
	  if (dataDeleted==true)
	  {

	   message="Record is InActivated successfully !!";
	  }

	  else{
	   message="Record is Activated successfully !!";
	  }
	  try{
	   map = pharmacyMasterHandlerService.getItemWiseSupplier();
	   
	  }catch (Exception e) {
	   //System.out.println("Exception in getItemWiseSupplier "+e);
	  }
	  jsp= ITEM_WISE_SUPPLIER_JSP;
	  title="Delete Item Wise Supplier";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
	 }

	 public ModelAndView editItemWiseSupplier(HttpServletRequest request, HttpServletResponse response){
	  Map<String, Object> map = new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();
	  int itemWiseId=0;
	  int itemId=0;
	  int supplierId=0;
	  String changedBy="";
	  Date currentDate=new Date();

	  try{
	   if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
	    itemWiseId =Integer.parseInt( request.getParameter(COMMON_ID));
	   }
	   if(request.getParameter(ITEM_ID) != null && !(request.getParameter(ITEM_ID).equals(""))){
	    itemId =Integer.parseInt( request.getParameter(ITEM_ID));
	   }
	   if(request.getParameter(STORE_SUPPLIER_ID) != null && !(request.getParameter(STORE_SUPPLIER_ID).equals(""))){
	    supplierId =Integer.parseInt( request.getParameter(STORE_SUPPLIER_ID));
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
	  
	  }catch (Exception e) {
	   //System.out.println("eeeeeeeeeee   "+e);
	  }
	   generalMap.put("id",itemWiseId);
	   generalMap.put("itemId",itemId);
	   generalMap.put("supplierId",supplierId);
	   generalMap.put("changedBy",changedBy);
	   generalMap.put("currentDate",currentDate);
	   generalMap.put("currentTime",currentTime);
	   boolean dataUpdated=false;
	  try{
	   dataUpdated=pharmacyMasterHandlerService.editItemWiseSupplier(generalMap);
	  }catch (Exception e) {
	   //System.out.println("this  "+e);
	  }
	  if(dataUpdated==true){
	   message="Record updated Successfully !!";
	  }
	  else{
	   message="Record Cant be updated !!";
	  }
	  try{
	   map = pharmacyMasterHandlerService.getItemWiseSupplier();
	   
	  }catch (Exception e) {
	   //System.out.println("Exception in getItemWiseSupplier "+e);
	  }
	  jsp= ITEM_WISE_SUPPLIER_JSP;
	  title="Edit Item Wise Supplier";
	  jsp += ".jsp";

	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  map.put("message", message);
	  return new ModelAndView("index", "map", map);
	 }*/
	
//		--------------------Item Generic Report-------------------------------------------------------
		

		public ModelAndView reportItemGeneric(HttpServletRequest request,HttpServletResponse response) 
		{
			Map<String, Object> parameters  = new HashMap<String, Object>();
			Map<String, Object> map  = new HashMap<String, Object>();
			parameters=pharmacyMasterHandlerService.getConnection();
			HMSUtil.generateReport("Mas_Store_Item_Generic", parameters, (Connection)parameters.get("conn"), response, getServletContext());
			return new ModelAndView("indexB", "map", map);	
				 
		}
//	--------------------------------------------Item Generic-----------------------------------------------------
	public ModelAndView showItemGenericJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = pharmacyMasterHandlerService.showItemGenericJsp();
		jsp = ITEM_GENERIC_JSP;
		jsp += ".jsp";
		title = "ItemGeneric";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addItemGeneric(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map = new HashMap<String,Object>();
		MasStoreItemGeneric masStoreItemGeneric = new MasStoreItemGeneric();
        String itemGenericName = "";
		int pharmaIndexId=0;
		 String contraIndication = "";
		 String dosageCalculation = "";
		 String drugInteraction = "";
		 String specialPrecaution = "";
		 String sideEffects = "";
		String changedBy = "";
		Map<String, Object> listMap=new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		
		if (request.getParameter(PHARMA_INDEX_ID) != null) {
			pharmaIndexId = Integer.parseInt(request.getParameter(PHARMA_INDEX_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			itemGenericName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CONTRA_INDICATION) != null) {
			contraIndication = request.getParameter(CONTRA_INDICATION);
		}
		if (request.getParameter(DOSAGE_CALCULATION) != null) {
			dosageCalculation = request.getParameter(DOSAGE_CALCULATION);
		}
		if (request.getParameter(DRUG_INTERACTIONS) != null) {
			drugInteraction = request.getParameter(DRUG_INTERACTIONS);
		}
		if (request.getParameter(SPECIAL_PRECAUTION) != null) {
			specialPrecaution = request.getParameter(SPECIAL_PRECAUTION);
		}
		if (request.getParameter(SIDE_EFFECTS) != null) {
			sideEffects = request.getParameter(SIDE_EFFECTS);
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
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List itemGenericNameList = new  ArrayList();
		if(listMap.get("duplicateGeneralNameList") != null){
			itemGenericNameList= (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((itemGenericNameList.size() == 0 || itemGenericNameList == null)){
			
			masStoreItemGeneric.setGenericName(itemGenericName);
			
			MasStorePharmaIndex masStorePharmaIndex = new MasStorePharmaIndex();
			masStorePharmaIndex.setId(pharmaIndexId);
			masStoreItemGeneric.setPharmaIndex(masStorePharmaIndex);
			
			masStoreItemGeneric.setContraIndication(contraIndication);
			masStoreItemGeneric.setDosageCalculation(dosageCalculation);
			masStoreItemGeneric.setDrugInteraction(drugInteraction);
			masStoreItemGeneric.setSpecialPrecaution(specialPrecaution);
			masStoreItemGeneric.setSideEffects(sideEffects);
			
			masStoreItemGeneric.setStatus("y");
			masStoreItemGeneric.setLastChgBy(changedBy);
			masStoreItemGeneric.setLastChgDate(currentDate);
			masStoreItemGeneric.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService.addItemGeneric(masStoreItemGeneric);		
			if(successfullyAdded){
				message="Record Added Successfully !!";
			}else{
				message="Try Again !!";
			}
		}else if((itemGenericNameList.size() != 0 || itemGenericNameList != null)  ){
				message = "Item Generic Name already exists.";
			}

	
		try{
			map = pharmacyMasterHandlerService.showItemGenericJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=ITEM_GENERIC_JSP;
		title="Add Item Generic";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editItemGeneric(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object>	map = new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		String itemGenericName = "";
		int itemGenericId = 0;
		int pharmaIndexId=0;
		 String contraIndication = "";
		 String dosageCalculation = "";
		 String drugInteraction = "";
		 String specialPrecaution = "";
		 String sideEffects = "";
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null) {
			itemGenericId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(PHARMA_INDEX_ID) != null) {
			pharmaIndexId = Integer.parseInt(request.getParameter(PHARMA_INDEX_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			itemGenericName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CONTRA_INDICATION) != null) {
			contraIndication = request.getParameter(CONTRA_INDICATION);
		}
		if (request.getParameter(DOSAGE_CALCULATION) != null) {
			dosageCalculation = request.getParameter(DOSAGE_CALCULATION);
		}
		if (request.getParameter(DRUG_INTERACTIONS) != null) {
			drugInteraction = request.getParameter(DRUG_INTERACTIONS);
		}
		if (request.getParameter(SPECIAL_PRECAUTION) != null) {
			specialPrecaution = request.getParameter(SPECIAL_PRECAUTION);
		}
		if (request.getParameter(SIDE_EFFECTS) != null) {
			sideEffects = request.getParameter(SIDE_EFFECTS);
		}
		
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", itemGenericId);
		generalMap.put("itemGenericName", itemGenericName);
		generalMap.put("pharmaIndexId",pharmaIndexId);
		generalMap.put("contraIndication", contraIndication);
		generalMap.put("dosageCalculation", dosageCalculation);
		generalMap.put("drugInteraction", drugInteraction);
		generalMap.put("specialPrecaution", specialPrecaution);
		generalMap.put("sideEffects", sideEffects);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		boolean dataUpdated=false;

		dataUpdated=pharmacyMasterHandlerService.editItemGeneric(generalMap);
		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant be updated !!";
		}
		try{
			map = pharmacyMasterHandlerService.showItemGenericJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=ITEM_GENERIC_JSP;
		title="Edit Item Generic";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView deleteItemGeneric(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		int itemGenericId=0;
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
			itemGenericId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deleteItemGeneric(itemGenericId,generalMap);

		if (dataDeleted==true){
			message="Record is InActivated successfully !!";
		}else{
			message="Record is Activated successfully !!";
		}
		try{
			map = pharmacyMasterHandlerService.showItemGenericJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=ITEM_GENERIC_JSP;
		title="Delete Item Generic";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchItemGeneric(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException{

		Map<String, Object> map= new HashMap<String, Object>();		
		String itemGenericName  = null;

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			itemGenericName = request.getParameter(SEARCH_NAME);
		}

		map = pharmacyMasterHandlerService.searchItemGeneric(itemGenericName);
		jsp=ITEM_GENERIC_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("itemGenericName",itemGenericName);
		return new ModelAndView("indexB", "map", map);
	}
//	--------------------Item Report-------------------------------------------------------
	

	public ModelAndView reportItem(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> parameters  = new HashMap<String, Object>();
		Map<String, Object> map  = new HashMap<String, Object>();
		parameters=pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Item", parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);	
			 
	}

//	---------------------------ITEM MASTER----------------------------------------------
	public ModelAndView showItemJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
		deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = pharmacyMasterHandlerService.showItemJsp(deptId,hospitalId);
		jsp = ITEM_JSP;
		jsp += ".jsp";
		title = "Item";
		map.put("contentJsp",jsp);
		map.put("fromShowItem", "fromShowItem");
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showItemJspForCRV(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = pharmacyMasterHandlerService.showItemJsp(deptId,hospitalId);
		jsp = ITEM_JSP;
		//jsp += ".jsp";
		title = "Item";
		map.put("contentJsp",jsp);
		map.put("fromShowItem", "fromShowItem");
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	
	public ModelAndView searchItem(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String pvmsNo  = null;
		String nomenclature = null;
		String sectionCode = null;
		String searchField= null;
		int ItemType=0;
		int hospitalId=0;
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));

		
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			pvmsNo = request.getParameter(CODE);
		}
	
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			nomenclature = request.getParameter(SEARCH_NAME);
			}

		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);
			}
			//if(request.getParameter("sectionCode") != null && !(request.getParameter("sectionCode").equals("0"))){
			//	sectionCode = request.getParameter("sectionCode");
			//}
			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(searchRadio==1){
			pvmsNo=searchField.trim();
			nomenclature=null;
		}else if(searchRadio==2){
			pvmsNo=null;
			nomenclature=searchField.trim();
		}else{
			pvmsNo=null;
			nomenclature=null;
			sectionCode = sectionCode.trim();
		}
		
		if(request.getParameter("itemType")!=null){
			ItemType=Integer.parseInt(request.getParameter("itemType").toString());
		}
		map = pharmacyMasterHandlerService.searchItem(pvmsNo, nomenclature, deptId,sectionCode,hospitalId,ItemType);

		jsp=ITEM_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("pvmsNo",pvmsNo);
		map.put("nomenclature",nomenclature);
		return new ModelAndView("indexB", "map", map);		
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addItem(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasStoreItem masStoreItem=new MasStoreItem();
		
		int sectionId = 0;
		int itemTypeId = 0;
		int itemCategoryId = 0;
		int itemConversionId = 0;
		int groupId = 0;
		String pvms = "";
		String commonName = "";
		Date changedDate = null;
		String changedTime = "";
		String expiry = "";
		String tempreture = "";
		Float minTempreture = null;
		Float maxTempreture = null;
		BigDecimal uomQty  = null;
		int itemClassId=0;
		String changedBy = "";
		String insulin="";
		String IssueFrom="";
		String prescribedFrom="";
		Map listMap = new HashMap();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		int deptId = 0;

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		map.put("deptId", deptId);
		
		int hospitalId=0;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		map.put("hospitalId", hospitalId);
		
		String brandedGeneric="";
		if (request.getParameter(BRAND_GENERIC) != null) {
			brandedGeneric = request.getParameter(BRAND_GENERIC);
		}
		
		int itemGenericId=0;
		
		if (!request.getParameter(GROUP_ID).equals("0")) {
			
			groupId = Integer.parseInt(request.getParameter(GROUP_ID));
		}
		if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
			
			itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
			
		}
		if (!request.getParameter(SECTION_ID).equals("0")) {
			sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
		}
		if (request.getParameter(CODE) != null) {
			pvms = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("commonName") != null) {
			commonName = request.getParameter("commonName");
		}
		if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
			
			itemConversionId = Integer.parseInt(request
					.getParameter(STORE_ITEM_CONVERSION_ID));
		}
if (!request.getParameter(EXPIRY).equals("")) {
			
			expiry = request.getParameter(EXPIRY);
		}
		if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
			
			itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
		}
		if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
			
			itemCategoryId = Integer.parseInt(request
					.getParameter(ITEM_CATEGORY_ID));
		}
		if (request.getParameter(HIGH_VALUE_DRUG) != null) {
			masStoreItem.setHighValueDrug(request.getParameter(HIGH_VALUE_DRUG));
		} else {
			masStoreItem.setHighValueDrug("n");
		}
		String dispensingUnit = "";
		if (request.getParameter("dispensingUnit") != null && !request.getParameter("dispensingUnit").equals("")) {
			dispensingUnit = request.getParameter("dispensingUnit");
		}
		if (request.getParameter("uomQty") != null
				&& !request.getParameter("uomQty").equals("")) {
			uomQty =  new BigDecimal(request
					.getParameter("uomQty"));
		}
		if (request.getParameter(BRAND_GENERIC) != null) {
			brandedGeneric = request.getParameter(BRAND_GENERIC);
		}
		if (request.getParameter(TEMPERATURE) != null
				&& !request.getParameter(TEMPERATURE).equals("")) {
			tempreture = (request.getParameter(TEMPERATURE));
		}
		if (request.getParameter("insulin") != null
				&& !request.getParameter("insulin").equals("")) {
			insulin = (request.getParameter("insulin"));
		}
		
		if (request.getParameter("IssueFrom") != null
				&& !request.getParameter("IssueFrom").equals("")) {
			IssueFrom = (request.getParameter("IssueFrom"));
		}
		
		if (request.getParameter("prescribedFrom") != null
				&& !request.getParameter("prescribedFrom").equals("")) {
			prescribedFrom = (request.getParameter("prescribedFrom"));
		}
		
		if (request.getParameter("minTemperature") != null
				&& !request.getParameter("minTemperature").equals("")) {
			minTempreture =  Float.parseFloat(request
					.getParameter("minTemperature"));
		}
		if (request.getParameter("maxTemperature") != null
				&& !request.getParameter("minTemperature").equals("")) {
			maxTempreture =  Float.parseFloat(request
					.getParameter("maxTemperature"));
		}
		
		if(request.getParameter(CHANGED_BY) !=null){
			changedBy = request.getParameter(CHANGED_BY);
		}
	
		if (request.getParameter(CHANGED_DATE) != null) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
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
		
		
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		Users user = new Users();
		user.setId(userId);
		generalMap.put("name", name);
		generalMap.put("code", code);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List nomenclatureList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			nomenclatureList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((nomenclatureList.size() == 0 || nomenclatureList == null)) {
			try {
				masStoreItem.setNomenclature(name);
				masStoreItem.setPvmsNo(pvms);
				masStoreItem.setCommonName(commonName);
				

				if (sectionId != 0) {
					MasStoreSection masStoreSection = new MasStoreSection();
					masStoreSection.setId(sectionId);
					masStoreItem.setSection(masStoreSection);
				}

				


				if (itemTypeId != 0) {
					 MasItemType masStoreItemType = new MasItemType();
					 masStoreItemType.setId(itemTypeId);
					 masStoreItem.setItemType(masStoreItemType);
				}

				if (itemCategoryId != 0) {
					MasItemCategory masStoreItemCategory = new MasItemCategory();
					masStoreItemCategory.setId(itemCategoryId);
					masStoreItem.setItemCategory(masStoreItemCategory);
				}

				if (itemConversionId != 0) {
					MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
					masStoreItemConversion.setId(itemConversionId);
					masStoreItem.setItemConversion(masStoreItemConversion);
				}

				if (groupId != 0) {
					MasStoreGroup masStoreGroup = new MasStoreGroup();
					masStoreGroup.setId(groupId);
					masStoreItem.setGroup(masStoreGroup);
				}
				
				if (itemClassId != 0) {
					 MasItemClass masItemClass = new MasItemClass();
					 masItemClass.setId(itemClassId);
					 masStoreItem.setItemClass(masItemClass);
				}

				 MasItemClassification c = new MasItemClassification();
				 c.setId(1);
				 masStoreItem.setItemClassification(c);
			
				
			
				if (!tempreture.equals("")) {
					masStoreItem.setTemperature(tempreture);
				}
				if (!insulin.equals("")) {
					masStoreItem.setInsulinInjection(insulin);
				}
				
				if (!IssueFrom.equals("")) {
					masStoreItem.setIssueFrom(IssueFrom);
				}
				else
				{
					masStoreItem.setIssueFrom("d");
				}
				if (!prescribedFrom.equals("")) {
					masStoreItem.setPrescribedFrom(prescribedFrom);
				}
				/*else
				{
					masStoreItem.setIssueFrom("d");
				}*/
				
	
				
				masStoreItem.setMaxStock(maxTempreture);
				masStoreItem.setMinStock(minTempreture);
				masStoreItem.setADispQty(uomQty);
				
				
				
				if (!dispensingUnit.equals("")) {		
				masStoreItem.setDispUnit(dispensingUnit);
				}
				masStoreItem.setBrandedGeneric(brandedGeneric);
				
				masStoreItem.setExpiry(expiry);
				masStoreItem.setStatus("y");
		
				masStoreItem.setLastChgBy(user);
				masStoreItem.setLastChgDate(changedDate);
				masStoreItem.setLastChgTime(changedTime);
			} catch (Exception e) {
				e.printStackTrace();
			}

			successfullyAdded = pharmacyMasterHandlerService.addItem(masStoreItem);
			if (successfullyAdded == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if (nomenclatureList.size() != 0) {
			message = "Item Name already exists.";
		}
		try {
			map = pharmacyMasterHandlerService.showItemJsp(deptId, hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	            
				
		jsp= ITEM_JSP;
		title="Add Item ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editItem(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int itemId = 0;
		
		String pvms = "";
		
		String nomenclature = "";
		int sectionId = 0;
		int itemTypeId = 0;
		int itemCategoryId = 0;
		int itemConversionId = 0;
		int groupId = 0;
		String commonName = "";
		
		Date changedDate = null;
		String changedBy = "";
		String changedTime = "";
		String highValueDrug = "n";
		
		String expiry = "";
		String tempreture = "";
		Float minTempreture  = null;
		Float maxTempreture  = null;
		BigDecimal uomQty  = null;
	String insulin="";
	String IssueFrom="";
	String prescribedFrom ="";
		int itemClassId=0;
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		String brandedGeneric="";
		
		if (request.getParameter(BRAND_GENERIC) != null) {
			brandedGeneric = request.getParameter(BRAND_GENERIC);
		}
		session = request.getSession();
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			nomenclature = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CODE) != null) {
			pvms = request.getParameter(CODE);
		}
		if (request.getParameter(GROUP_ID) != null  && !request.getParameter(GROUP_ID).equals("0")) {
			
			groupId = Integer.parseInt(request.getParameter(GROUP_ID));
		}
		if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
			
			itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
			
		}
		if (!request.getParameter(SECTION_ID).equals("0")) {
			sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
		}
		
	
		if (request.getParameter("commonName") != null) {
			commonName = request.getParameter("commonName");
		}
		if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
			
			itemConversionId = Integer.parseInt(request
					.getParameter(STORE_ITEM_CONVERSION_ID));
		}
		
		if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
			
			itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
		}
		if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
			
			itemCategoryId = Integer.parseInt(request
					.getParameter(ITEM_CATEGORY_ID));
		}
		
		if (request.getParameter(HIGH_VALUE_DRUG) != null) {
			highValueDrug =request.getParameter(HIGH_VALUE_DRUG);
		} else {
			highValueDrug ="n";
		}
		
		String dispensingUnit = "";
		if (request.getParameter("dispensingUnit") != null && !request.getParameter("dispensingUnit").equals("")) {
			dispensingUnit = request.getParameter("dispensingUnit");
		}

		if (request.getParameter(EXPIRY) != null && !request.getParameter(EXPIRY).equals("")) {
			expiry = request.getParameter(EXPIRY);
		}

		
		if (request.getParameter(TEMPERATURE) != null
				&& !request.getParameter(TEMPERATURE).equals("")) {
			tempreture = (request.getParameter(TEMPERATURE));
		}
		
		if (request.getParameter("insulin") != null
		&& !request.getParameter("insulin").equals("")) {
			insulin = (request.getParameter("insulin"));
}
		if (request.getParameter("minTemperature") != null && !request.getParameter("minTemperature").equals("")) {
			minTempreture =  Float.parseFloat(request
					.getParameter("minTemperature"));
		}
		if (request.getParameter("uomQty") != null && !request.getParameter("uomQty").equals("")) {
			uomQty =  new BigDecimal(request.getParameter("uomQty"));
		}
		
		if (request.getParameter("maxTemperature") != null
				&& !request.getParameter("maxTemperature").equals("")) {
			maxTempreture =  Float.parseFloat(request
					.getParameter("maxTemperature"));
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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
		
		if (request.getParameter("IssueFrom") != null
				&& !request.getParameter("IssueFrom").equals("")) {
			IssueFrom = (request.getParameter("IssueFrom"));
		}
		if (request.getParameter("prescribedFrom") != null
				&& !request.getParameter("prescribedFrom").equals("")) {
			prescribedFrom  = (request.getParameter("prescribedFrom"));
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		
		int userId = 0;
		int hospitalId=0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		generalMap.put("tempreture", tempreture);
		generalMap.put("insulin", insulin);
		generalMap.put("itemClassId", itemClassId);
		generalMap.put("id", itemId);
		generalMap.put("name", nomenclature);
		generalMap.put("sectionId", sectionId);
		generalMap.put("commonName", commonName);
		generalMap.put("pvms", pvms);
		generalMap.put("itemTypeId", itemTypeId);
		generalMap.put("itemCategoryId", itemCategoryId);
		generalMap.put("itemConversionId", itemConversionId);
		generalMap.put("minTempreture", minTempreture);
		generalMap.put("uomQty", uomQty);
		generalMap.put("maxTempreture", maxTempreture);
		
		generalMap.put("highValueDrug", highValueDrug);
		generalMap.put("dispensingUnit", dispensingUnit);
		generalMap.put("groupId", groupId);
		generalMap.put("expiry", expiry);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("userId", userId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("brandedGeneric", brandedGeneric);
		
		if (!IssueFrom.equals("")) {
			generalMap.put("IssueFrom", IssueFrom);
		}
		else
		{
			generalMap.put("d", IssueFrom);
		}
		System.out.println("prescribedFrom"+prescribedFrom);
		if (!prescribedFrom.equals("")) {
			generalMap.put("prescribedFrom", prescribedFrom);
		}
		/*else
		{
			generalMap.put("d", IssueFrom);
		}*/
		generalMap.put("brandedGeneric", brandedGeneric);
		
		
		boolean dataUpdated = false;
		dataUpdated = pharmacyMasterHandlerService.editItem(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant be updated !!";
		}
		try {
			map = pharmacyMasterHandlerService.showItemJsp(deptId, hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp= ITEM_JSP;
		title="Edit Item ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView deleteItem(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int itemId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		session = request.getSession();
		int deptId = 0;
		int hospitalId=0;
		int userId=0;

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			itemId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		generalMap.put("userId",userId);
		boolean dataDeleted=false;
		dataDeleted=pharmacyMasterHandlerService.deleteItem(itemId,generalMap);

		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showItemJsp";
		try{
			map = pharmacyMasterHandlerService.showItemJsp(deptId,hospitalId);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp= ITEM_JSP;
		title="Delete Item ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView checkForExistingPvmsNo(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		String pvmsNo = "";
		String message = "";
		if(request.getParameter("pvmsNo") != null){
			pvmsNo = request.getParameter("pvmsNo");
		}
		List<MasStoreItem> existingPvmsNoList = pharmacyMasterHandlerService.checkForExistingPvmsNo(pvmsNo.trim());
		
		if(existingPvmsNoList != null && existingPvmsNoList.size() > 0){
			message = "PVMS No. Already Exists. \n Check ExpendableStores / NonExpendableStores \n Please enter another no.";
			map.put("message", message);
		}
		jsp= AJAX_MESSAGE_JSP;
		
		return new ModelAndView(jsp, "map", map);
	}
	public void checkForExistingPvmsNo1(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		String pvmsNo = "";
		String message = "";
		if(request.getParameter("pvmsNo") != null){
			pvmsNo = request.getParameter("pvmsNo");
		}
		List<MasStoreItem> existingPvmsNoList = pharmacyMasterHandlerService.checkForExistingPvmsNo(pvmsNo.trim());
		StringBuffer sb = new StringBuffer("<items><item>");
		
		if(existingPvmsNoList != null && existingPvmsNoList.size() > 0){
			sb.append("<found>true</found>");
			
		}else{
			sb.append("<found>false</found>");
		}
		sb.append("</item></items>");
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try{
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
	    response.getWriter().write(sb.toString());	
		}catch(Exception e )
		{
			e.printStackTrace();
		}
			
	}
//	--------------------Store Vendor Wise Manufacturer  Report-------------------------------------------------------
	

	public ModelAndView reportStoreVendorWiseManufacturer(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> parameters  = new HashMap<String, Object>();
		Map<String, Object> map  = new HashMap<String, Object>();
		parameters=pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Vendor_Wise_Manufacturer", parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);	
			 
	}

//	-------------------------------------- StoreVendorWiseManufacturer--------------------------------



	@SuppressWarnings("unchecked")
	public ModelAndView showStoreVendorWiseManufacturerJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = pharmacyMasterHandlerService.showStoreVendorWiseManufacturerJsp();
		jsp = STORE_VENDOR_WISE_MANUFACTURE_JSP;
		jsp += ".jsp";
		title = "StoreVendorWiseManufacturer";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView addStoreVendorWiseManufacturer(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer=new MasStoreVendorWiseManufacturer();

		int manufacturerId=0;
		Date changedDate = null;
		String changedBy = "";		
		String changedTime = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(MANUFACTURER_ID) != null) {
			manufacturerId =  Integer.valueOf(request.getParameter(MANUFACTURER_ID));
		}
		if(request.getParameter(CHANGED_BY) !=null){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null){
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		/*if(request.getParameter("pojoPropertyCode") != null){
			pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		}*/
		generalMap.put("code", code);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		//generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List storeVendorWiseManufacturerCodeList = new ArrayList();
		if(listMap.get("duplicateGeneralCodeList") != null){
			storeVendorWiseManufacturerCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		
		boolean successfullyAdded = false;

		if((storeVendorWiseManufacturerCodeList.size() == 0 || storeVendorWiseManufacturerCodeList == null))
		{
			//masStoreVendorWiseManufacturer.setVendorCode(code);
			
			MasManufacturer masManufacturer = new MasManufacturer();
			masManufacturer.setId(manufacturerId);
			masStoreVendorWiseManufacturer.setManufacturer(masManufacturer);
			
			masStoreVendorWiseManufacturer.setManufacturer(masManufacturer);
			masStoreVendorWiseManufacturer.setStatus("y");
			masStoreVendorWiseManufacturer.setLastChgBy(changedBy);
			masStoreVendorWiseManufacturer.setLastChgDate(changedDate);
			masStoreVendorWiseManufacturer.setLastChgTime(changedTime);
			successfullyAdded = pharmacyMasterHandlerService.addStoreVendorWiseManufacturer(masStoreVendorWiseManufacturer);		
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((storeVendorWiseManufacturerCodeList.size() != 0 || storeVendorWiseManufacturerCodeList != null)){

			if((storeVendorWiseManufacturerCodeList.size() != 0 || storeVendorWiseManufacturerCodeList != null)){

				message = "Vendor Code  already exists.";
			}
		}

		url = "/hms/hms/pharmacy?method=showStoreVendorWiseManufacturerJsp";
		try{
			map = pharmacyMasterHandlerService.showStoreVendorWiseManufacturerJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=STORE_VENDOR_WISE_MANUFACTURE_JSP;
		title="add StoreVendorWiseManufacturer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView searchStoreVendorWiseManufacturer(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String storeVendorWiseManufacturerCode  = null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			storeVendorWiseManufacturerCode = request.getParameter(CODE);
		}

		map = pharmacyMasterHandlerService.searchStoreVendorWiseManufacturer(storeVendorWiseManufacturerCode);
		jsp=STORE_VENDOR_WISE_MANUFACTURE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("storeVendorWiseManufacturerCode",storeVendorWiseManufacturerCode);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editStoreVendorWiseManufacturer(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		String storeVendorWiseManufacturerCode="";
		int manufacturerId=0;
		int storeVendorWiseManufacturerId=0;
		String changedBy = "";		
		String changedTime="";
		Date changedDate = new Date();	
		if(request.getParameter(MANUFACTURER_ID) != null && 	!(request.getParameter(MANUFACTURER_ID).equals(""))){
			manufacturerId =Integer.parseInt( request.getParameter(MANUFACTURER_ID));
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			storeVendorWiseManufacturerId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			storeVendorWiseManufacturerCode = request.getParameter(CODE);
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
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		encodedDate = new Date();
		encodedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		generalMap.put("id", storeVendorWiseManufacturerId);
		generalMap.put("storeVendorWiseManufacturerCode", storeVendorWiseManufacturerCode);
		generalMap.put("manufacturerId",manufacturerId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataUpdated=false;
		dataUpdated=pharmacyMasterHandlerService.editStoreVendorWiseManufacturerToDatabase(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant be updated !!";
		}
		url = "/hms/hms/pharmacy?method=showStoreVendorWiseManufacturerJsp";
		try{
			map = pharmacyMasterHandlerService.showStoreVendorWiseManufacturerJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=STORE_VENDOR_WISE_MANUFACTURE_JSP;
		title="edit StoreVendorWiseManufacturer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteStoreVendorWiseManufacturer(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int storeVendorWiseManufacturerId=0;
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
			storeVendorWiseManufacturerId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deleteStoreVendorWiseManufacturer(storeVendorWiseManufacturerId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showStoreVendorWiseManufacturerJsp";
		try{
			map = pharmacyMasterHandlerService.showStoreVendorWiseManufacturerJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=STORE_VENDOR_WISE_MANUFACTURE_JSP;
		title="delete StoreVendorWiseManufacturer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}		
	
//	--------------------Financial Report-------------------------------------------------------
	

	public ModelAndView reportFinancial(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> parameters  = new HashMap<String, Object>();
		Map<String, Object> map  = new HashMap<String, Object>();
		parameters=pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Financial", parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);	
			 
	}
//----------------------------Financial Master---------------------------------	
	@SuppressWarnings("unchecked")
	public ModelAndView showFinancialJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showFinancialJsp();
		jsp = FINANCIAL_JSP;
		jsp+= ".jsp" ;
		title = "Financial";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}
/*	
	public ModelAndView searchFinancial(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();  
		Date startDate = new Date();;
		Date endDate = new Date();
		String searchField= null;

		if(request.getParameter(START_DATE) != null && !(request.getParameter(START_DATE).equals(""))){
			startDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(START_DATE));
		}
		if(request.getParameter(END_DATE) != null && !(request.getParameter(END_DATE).equals(""))){
			endDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(END_DATE));
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
			//System.out.println("eeeeeeeeee  "+e);
		}
		if(searchRadio==1){
			startDate=searchField;
			endDate=null;
		}else{
			startDate=null;
			endDate=searchField;
		}
		map = pharmacyMasterHandlerService.searchFinancial(startDate, endDate);
		jsp=FINANCIAL_JSP;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")*/
	@SuppressWarnings("unchecked")
	public ModelAndView addFinancial(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasStoreFinancial masStoreFinancial=new MasStoreFinancial();
		String changedBy = "";
		Date startDate = new Date();
		Date endDate = new Date();
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
String financialYear="";
		if(request.getParameter(START_DATE) != null && !(request.getParameter(START_DATE).equals(""))){
			startDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(START_DATE));
		}
		if(request.getParameter(END_DATE) != null && !(request.getParameter(END_DATE).equals(""))){
			endDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(END_DATE));
		}
		if(request.getParameter("financialYear") != null && !(request.getParameter("financialYear").equals(""))){
			financialYear = request.getParameter("financialYear");
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
		
		generalMap.put("startDate", startDate);
		generalMap.put("endDate", endDate);
		generalMap.put("financialYear", financialYear);
		
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List startDateList = new ArrayList();
		List endDateList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			startDateList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			endDateList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if((startDateList.size() == 0 || startDateList == null) && (endDateList.size() == 0 || endDateList == null))
		{
			masStoreFinancial.setStartDate(startDate);
			masStoreFinancial.setEndDate(endDate);
			masStoreFinancial.setStatus("y");
			masStoreFinancial.setLastChgBy(changedBy);
			masStoreFinancial.setLastChgDate(currentDate);
			masStoreFinancial.setLastChgTime(currentTime);
			masStoreFinancial.setFinancialYear(financialYear);
			successfullyAdded = pharmacyMasterHandlerService.addFinancial(masStoreFinancial);  

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}		
		}

		else if((startDateList.size() != 0 || startDateList != null) || (endDateList.size() != 0) || endDateList != null)
		{
			if((startDateList.size() != 0 || startDateList != null) && (endDateList.size() == 0 || endDateList == null)){
				message = "Start Date  already exists.";
			}
			else if((endDateList.size() != 0 || endDateList != null) && (startDateList.size() == 0 || startDateList == null) ){
				message = "End Date already exists.";	   }
			else if((startDateList.size() != 0 || startDateList != null) && (endDateList.size() != 0 || endDateList != null)){
				message = "Start Date and End Date already exist.";
			}
		}
		url = "/hms/hms/pharmacy?method=showFinancialJsp";
		 try{
		   map = pharmacyMasterHandlerService.showFinancialJsp();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp=FINANCIAL_JSP;
		    title="Add Financial";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	}
	
	@SuppressWarnings("unused")
	public ModelAndView editFinancialToDatabase(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		int financialId=0;
		Date startDate = null;
		Date endDate = null;
		String changedBy = "";
		String financialYear="";
		Date changedDate = null;
		String changedTime = "";
		
		if(request.getParameter(START_DATE) != null && !(request.getParameter(START_DATE).equals(""))){
			startDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(START_DATE));
		}
		if(request.getParameter(END_DATE) != null && !(request.getParameter(END_DATE).equals(""))){
			endDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(END_DATE));
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			financialId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter("financialYear") != null && !(request.getParameter("financialYear").equals(""))){
			financialYear = request.getParameter("financialYear");
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 	 }
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		generalMap.put("id", financialId);
		generalMap.put("startDate", startDate);
		generalMap.put("endDate",endDate);
		generalMap.put("financialYear",financialYear);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		
		boolean dataUpdated=false;

		dataUpdated=pharmacyMasterHandlerService.editFinancialToDatabase(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showFinancialJsp";
		try{
			map = pharmacyMasterHandlerService.showFinancialJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=FINANCIAL_JSP;
		title="Update Financial";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView deleteFinancial(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int financialId=0;
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
			financialId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deleteFinancial(financialId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated Successfully !!";
		}
		else{
			message="Record is Activated Successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showFinancialJsp";
		try{
			map = pharmacyMasterHandlerService.showFinancialJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=FINANCIAL_JSP;
		title="Delete Fianancial";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView searchFinancial(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();  
		Date startDate = new Date();;
		Date endDate = new Date();
		String searchField= null;

		if(request.getParameter(START_DATE) != null && !(request.getParameter(START_DATE).equals(""))){
			startDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(START_DATE));
		}
		if(request.getParameter(END_DATE) != null && !(request.getParameter(END_DATE).equals(""))){
			endDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(END_DATE));
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
		}
		if(searchRadio==1){
			//startDate=searchField;
			endDate=null;
		}else{
			startDate=null;
			//endDate=searchField;
		}
		map = pharmacyMasterHandlerService.searchFinancial(startDate, endDate);
		jsp=FINANCIAL_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		return new ModelAndView("indexB", "map", map);
	}
	
//	--------------------Pharma Index Report-------------------------------------------------------
	

	public ModelAndView reportPharmaIndex(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> parameters  = new HashMap<String, Object>();
		Map<String, Object> map  = new HashMap<String, Object>();
		parameters=pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Pharma_Index", parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);	
			 
	}
//------------------Pharma Index---------------------
	
	@SuppressWarnings("unchecked")
	public ModelAndView showPharmaIndexJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showPharmaIndexJsp();
		jsp = PHARMA_INDEX_JSP;
		jsp+= ".jsp" ;
		title = "Pharma Index";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}

	public ModelAndView searchPharmaIndex(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String pharmaIndexName  = null;
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			pharmaIndexName = request.getParameter(SEARCH_NAME);
		}
		map = pharmacyMasterHandlerService.searchPharmaIndex(pharmaIndexName);
		jsp=PHARMA_INDEX_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("pharmaIndexName",pharmaIndexName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPharmaIndex(HttpServletRequest request, HttpServletResponse response) 
	{
		String pharmaIndexName = "";
		Map<String,Object> map=new HashMap<String,Object>();
		MasStorePharmaIndex masStorePharmaIndex=new MasStorePharmaIndex();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

	    if (request.getParameter(SEARCH_NAME) != null) {
			pharmaIndexName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List pharmaIndexNameList = new  ArrayList();

		
		if(listMap.get("duplicateGeneralNameList") != null){
			pharmaIndexNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if( (pharmaIndexNameList.size() == 0 || pharmaIndexNameList == null))
		{
			masStorePharmaIndex.setPharmaIndexName(pharmaIndexName);
			masStorePharmaIndex.setStatus("y");
			masStorePharmaIndex.setLastChgBy(changedBy);
			masStorePharmaIndex.setLastChgDate(currentDate);
			masStorePharmaIndex.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService.addPharmaIndex(masStorePharmaIndex);  

			if(successfullyAdded == true){
				message="Record Added Successfully !!";
			}else{
				message = "Try Again !!";
			}
				
		}else if(pharmaIndexNameList.size() != 0){
			message = "Pharma Index Name already exists.";
		}
		 try{
			   map = pharmacyMasterHandlerService.showPharmaIndexJsp();
			    }catch (Exception e) {
			    	e.printStackTrace();
			    }
			    jsp=PHARMA_INDEX_JSP;
			    title="Add Pharma Index";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView editPharmaIndex(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		String pharmaIndexName="";
		int pharmaIndexId=0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			pharmaIndexId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			pharmaIndexName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 	 }
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		
		generalMap.put("id", pharmaIndexId);
		generalMap.put("pharmaIndexName", pharmaIndexName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		
		boolean dataUpdated=false;

		dataUpdated=pharmacyMasterHandlerService.editPharmaIndexToDatabase(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showPharmaIndexJsp";
		try{
			map = pharmacyMasterHandlerService.showPharmaIndexJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=PHARMA_INDEX_JSP;
		title="Update Pharma Index";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView deletePharmaIndex(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int pharmaIndexId=0;
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
			pharmaIndexId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deletePharmaIndex(pharmaIndexId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated Successfully !!";
		}
		else{
			message="Record is Activated Successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showPharmaIndexJsp";
		try{
			map = pharmacyMasterHandlerService.showPharmaIndexJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=PHARMA_INDEX_JSP;
		title="Delete Pharma Index";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
//	--------------------Item Unit Report-------------------------------------------------------
	

	public ModelAndView reportItemUnit(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> parameters  = new HashMap<String, Object>();
		Map<String, Object> map  = new HashMap<String, Object>();
		parameters=pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Unit", parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);	
			 
	}
//-------------------------Store Unit----------------------------------------------
	

	@SuppressWarnings("unchecked")
	public ModelAndView showItemUnitJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showItemUnitJsp();
		jsp = STORE_ITEM_UNIT_JSP;
		jsp+= ".jsp" ;
		title = "Item Unit";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}

	public ModelAndView searchItemUnit(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String unitName  = null;
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			unitName = request.getParameter(SEARCH_NAME);
		}
		map = pharmacyMasterHandlerService.searchItemUnit(unitName);
		jsp= STORE_ITEM_UNIT_JSP;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("search", "search");
		map.put("title", title);
		map.put("unitName",unitName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addItemUnit(HttpServletRequest request, HttpServletResponse response) 
	{
		String unitName = "";
		Map<String,Object> map=new HashMap<String,Object>();
		MasStoreUnit masStoreItemUnit=new MasStoreUnit();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

	    if (request.getParameter(SEARCH_NAME) != null) {
			unitName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("unitName", unitName);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List unitNameList = new  ArrayList();

		
		if(listMap.get("duplicateGeneralNameList") != null){
			unitNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if( (unitNameList.size() == 0 || unitNameList == null))
		{
			masStoreItemUnit.setUnitName(unitName);
			masStoreItemUnit.setStatus("y");
			masStoreItemUnit.setLastChgBy(changedBy);
			masStoreItemUnit.setLastChgDate(currentDate);
			masStoreItemUnit.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService.addItemUnit(masStoreItemUnit);  

			if(successfullyAdded == true){
				message="Record Added Successfully !!";
			}else{
				message = "Try Again !!";
			}
				
		}else if(unitNameList.size() != 0){
			message = "Unit Name already exists.";
		}
		 try{
			   map = pharmacyMasterHandlerService.showItemUnitJsp();
			    }catch (Exception e) {
			    	e.printStackTrace();
			    }
			    jsp= STORE_ITEM_UNIT_JSP;
			    title="Add Item Unit";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView editItemUnit(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		String unitName="";
		int itemUnitId=0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			itemUnitId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			unitName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 	 }
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		generalMap.put("id",itemUnitId);
		generalMap.put("unitName", unitName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		
		boolean dataUpdated=false;

		dataUpdated=pharmacyMasterHandlerService.editItemUnitToDatabase(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showItemUnitJsp";
		try{
			map = pharmacyMasterHandlerService.showItemUnitJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp= STORE_ITEM_UNIT_JSP;
		title="Update Item Unit";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView deleteItemUnit(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int itemUnitId=0;
		String message=null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			itemUnitId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		boolean dataDeleted=false;
		dataDeleted=pharmacyMasterHandlerService.deleteItemUnit(itemUnitId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated Successfully !!";
		}
		else{
			message="Record is Activated Successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showItemUnitJsp";
		try{
			map = pharmacyMasterHandlerService.showItemUnitJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp= STORE_ITEM_UNIT_JSP;
		title="Delete Item Unit";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
//------------------------Item Conversion-----------------------------------------------
/*	
	public ModelAndView showItemConversionJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showItemConversionJsp();
		jsp = STORE_ITEM_CONVERSION_JSP;
		jsp += ".jsp";
		title = "Item Conversion";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchItemConversion(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{

	Map<String, Object> map= new HashMap<String, Object>();		
	String itemUnitName  = null;

	if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		itemUnitName = request.getParameter(SEARCH_NAME);
	}

	map = pharmacyMasterHandlerService.searchItemConversion(itemUnitName);
	jsp=STORE_ITEM_CONVERSION_JSP;
	jsp += ".jsp";
	map.put("contentJsp",jsp);
	map.put("title", title);
	map.put("itemUnitName",itemUnitName);
	return new ModelAndView("index", "map", map);
}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addItemConversion(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();	
		MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
		String itemUnitName = "";
		int purchaseUnitId= 0;
		int intermediateUnitId= 0;
		int issueUnitId= 0;
		String conversionFactor = "";
		String conversionFactor2 = "";
		Date changedDate = null;
		String changedBy = "";		
		String changedTime = "";

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			itemUnitName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(PURCHASE_UNIT_ID) != null) {
			purchaseUnitId = Integer.parseInt(request.getParameter(PURCHASE_UNIT_ID));
		}
		if (request.getParameter(INTERMEDIATE_UNIT_ID) != null) {
			intermediateUnitId = Integer.parseInt(request.getParameter(INTERMEDIATE_UNIT_ID));
		}
		if(request.getParameter(ISSUE_UNIT_ID) != null) {
			issueUnitId = Integer.parseInt(request.getParameter(ISSUE_UNIT_ID));
		}
		if(request.getParameter(CONVERSION_FACTOR) != null) {
			conversionFactor = request.getParameter(CONVERSION_FACTOR);
		}
		if(request.getParameter(CONVERSION_FACTOR2) != null) {
			conversionFactor2 = request.getParameter(CONVERSION_FACTOR2);
		}
		if(request.getParameter(CHANGED_BY) !=null){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null){
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		if(request.getParameter("jspName") != null){
			jspName = request.getParameter("jspName"); 
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 		}

		generalMap.put("name", itemUnitName);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
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
			masStoreItemConversion.setItemUnitName(itemUnitName);
			
			MasStoreUnit purchaseUnitObj = new MasStoreUnit();
			purchaseUnitObj.setId(purchaseUnitId);
			purchaseUnitObj.set

			MasRoom roomObj = new MasRoom();
			roomObj.setId(roomId);
			masStoreItemConversion.setRoom(roomObj);

			MasBedStatus bedStatusObj = new MasBedStatus();
			bedStatusObj.setId(bedStatusId);
			masStoreItemConversion.setBedStatus(bedStatusObj);

			masStoreItemConversion.setAdNo(conversionFactor);
			masStoreItemConversion.setDietType(conversionFactor2);
			masStoreItemConversion.setStatus("y");
			masStoreItemConversion.setLastChgBy(changedBy);
			masStoreItemConversion.setLastChgDate(changedDate);
			masStoreItemConversion.setLastChgTime(changedTime);
			successfullyAdded = pharmacyMasterHandlerService.addItemConversion(masStoreItemConversion);
			if(successfullyAdded == true){
				message="Bed Information Added Successfully !!";
			}else{
				message = "Try Again !!";
			}
				
		}else if((titleCodeList.size() != 0 || titleCodeList != null) || (titleNameList.size() != 0) || titleNameList != null){
			if((titleCodeList.size() != 0 || titleCodeList != null) && (titleNameList.size() == 0 || titleNameList == null)){
				message = "Title Code  already exists.";	   }
			else if((titleNameList.size() != 0 || titleNameList != null) && (titleCodeList.size() == 0 || titleCodeList == null) ){
				message = "Title Name already exists.";	   }
			else if((titleCodeList.size() != 0 || titleCodeList != null) && (titleNameList.size() != 0 || titleNameList != null)){
				message = "Title Code and Title Name already exist.";
			}	  }

		url = "/hms/hms/pharmacy?method=showItemConversionJsp";
		try{
			map = pharmacyMasterHandlerService.showItemConversionJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
			    jsp=BED_JSP;
			    title="Add Bed";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("index", "map", map);
	}
	*/

	
//--------------------PO Delivery terms Reports-------------------------------------------------------
	public ModelAndView reportPoDeliveryTerms(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> parameters  = new HashMap<String, Object>();
		Map<String, Object> map  = new HashMap<String, Object>();
		parameters=pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Po_Delivery_Terms", parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);	
	}
//	--------------------PO Delivery terms-------------------------------------------------------
	
	@SuppressWarnings("unchecked")
	public ModelAndView showPoDeliveryTermsJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showPoDeliveryTermsJsp();
		jsp = PO_DELIVERY_JSP;
		jsp+= ".jsp" ;
		title = "PoDelivery";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}
	
	public ModelAndView searchPoDeliveryTerms(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
	Map<String, Object> map= new HashMap<String, Object>();		
	String poDeliveryType  = null;
	if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		poDeliveryType = request.getParameter(SEARCH_NAME);
	}
	map = pharmacyMasterHandlerService.searchPoDeliveryTerms(poDeliveryType);
	jsp=PO_DELIVERY_JSP;
	jsp += ".jsp";
	map.put("contentJsp",jsp);
	map.put("title", title);
	map.put("search", "search");
	map.put("poDeliveryTerms",poDeliveryType);
	return new ModelAndView("indexB", "map", map);
   }
	@SuppressWarnings("unchecked")
	public ModelAndView addPoDeliveryTerms(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasStorePoDeliveryTerms masStorePoDeliveryTerms=new MasStorePoDeliveryTerms();
		String changedBy = "";
		String poType = "";
		String description = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date changedDate = null;
		String changedTime = "";
		
		if (request.getParameter(SEARCH_NAME) != null) {
			poType = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter(DESCRIPTION) != null) {
			description = request.getParameter(DESCRIPTION);
		}
		
		if(request.getParameter(CHANGED_BY) !=null){
			changedBy = request.getParameter(CHANGED_BY);
		}
		
		if(request.getParameter(CHANGED_DATE) != null){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null){
			changedTime = request.getParameter(CHANGED_TIME);
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
		if(request.getParameter("jspName") != null){
			jspName = request.getParameter("jspName"); 
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 		}

		generalMap.put("name", poType);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		boolean successfullyAdded = false;
		masStorePoDeliveryTerms.setPoDeliveryTermsName(poType);
		masStorePoDeliveryTerms.setPoDeliveryTermsDescription(description);
		masStorePoDeliveryTerms.setStatus("y");
		masStorePoDeliveryTerms.setLastChgBy(changedBy);
		masStorePoDeliveryTerms.setLastChgDate(changedDate);
		masStorePoDeliveryTerms.setLastChgTime(changedTime);
		successfullyAdded = pharmacyMasterHandlerService.addPoDeliveryTerms(masStorePoDeliveryTerms);
		
		if(successfullyAdded == true)
		{
			message="Record Added Successfully !!";
		}else
		{
			message = "Try Again !!";
		}

		 try{
			   map = pharmacyMasterHandlerService.showPoDeliveryTermsJsp();
			    }catch (Exception e) {
			    	e.printStackTrace();
			    }
			    jsp=PO_DELIVERY_JSP;
			    title="Add Supplier Order Delivery/Payment Terms";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editPoDeliveryTerms(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		String poType="";
		String description="";
		int poDeliveryTermsId=0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			poDeliveryTermsId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			poType = request.getParameter(SEARCH_NAME);
		}
		
		if(request.getParameter(DESCRIPTION) != null && !(request.getParameter(DESCRIPTION).equals(""))){
			description = request.getParameter(DESCRIPTION);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 	 }
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		generalMap.put("id", poDeliveryTermsId);
		generalMap.put("poType", poType);
		generalMap.put("description", description);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		
		boolean dataUpdated=false;

		dataUpdated=pharmacyMasterHandlerService.editPoDeliveryTermsToDatabase(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showPoDeliveryTermsJsp";
		try{
			map = pharmacyMasterHandlerService.showPoDeliveryTermsJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=PO_DELIVERY_JSP;
		title="Update poDelivery";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView deletePoDeliveryTerms(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int poDeliveryTermsId=0;
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
			poDeliveryTermsId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deletePoDeliveryTerms(poDeliveryTermsId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated Successfully !!";
		}

		else{
			message="Record is Activated Successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showPoDeliveryTermsJsp";
		try{
			map = pharmacyMasterHandlerService.showPoDeliveryTermsJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=PO_DELIVERY_JSP;
		title="Delete poDelivery";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	
	
//	---------------------Budget Report-------------------------------------------------------
	

	public ModelAndView reportBudget(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> parameters  = new HashMap<String, Object>();
		Map<String, Object> map  = new HashMap<String, Object>();
		parameters=pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Budget", parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);	
			 
	}

//------------------------------Budget Master-------------------------------------
	
	@SuppressWarnings("unchecked")
	public ModelAndView showBudgetJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreSetup> storeSetupList = new ArrayList<StoreSetup>();
		Box box = HMSUtil.getBox(request);
		int financialId = box.getInt("financialId");
		String budgetCode = box.getString("budgetCode");
		session = request.getSession();
		int hospitalId=0;
		int deptId=0;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		
		map = pharmacyMasterHandlerService.showBudgetJsp(deptId,hospitalId);
		storeSetupList = (List) map.get("storeSetupList");
		if (storeSetupList != null && storeSetupList.size() > 0)
		{
			map.put("ExpStoreCode", storeSetupList.get(0).getStoreExpendable().getId());	
		}
		map.put("financialId", financialId);
		map.put("budgetCode", budgetCode);
		
		jsp = BUDGET_ENTRY_JSP;
		jsp+= ".jsp" ;
		title = "Budget Entry";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}
	
	
	/*@SuppressWarnings("deprecation")
	public ModelAndView addBudgetEntry(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> infoMap=new HashMap<String,Object>();
		MasStoreBudget masStoreBudget = new MasStoreBudget();
		int financialId= 0;
		String budgetCode="";
		Float totalAllocatedAmount = null;
		Float crvComittedAmount = null;
		Float poCommitedAmount = null;
		Float utilizedAmount = null;
		Date changedDate = null;
		String changedBy = "";		
		String changedTime = "";
		int pageNo=1;
		int noOfRecords=1;
		@SuppressWarnings("unused")
		int rows=0;
		int budgetId=0;
		if (request.getParameter("pageNo") != null) {
			pageNo= Integer.parseInt(request.getParameter("pageNo"));

		}
		if (request.getParameter(NO_OF_ROWS) != null) {
			noOfRecords= Integer.parseInt(request.getParameter(NO_OF_ROWS));
		}
		if (request.getParameter(NO_OF_ROWS) != null) {
			rows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
		}
		if(request.getParameter(BUDGET_CODE) != null && !(request.getParameter(BUDGET_CODE).equals(""))){
			budgetCode = request.getParameter(BUDGET_CODE);
		}
		if(!request.getParameter(FINANCIAL_ID).equals("0")){
		  financialId = Integer.parseInt(request.getParameter(FINANCIAL_ID));
		}
		if(request.getParameter(TOTAL_ALLOCATED_AMOUNT) != null && !(request.getParameter(TOTAL_ALLOCATED_AMOUNT).equals(""))){
			totalAllocatedAmount = Float.parseFloat(request.getParameter(TOTAL_ALLOCATED_AMOUNT));
		}
		if (request.getParameter(BUDGET_ID) != null) {
			budgetId= Integer.parseInt(request.getParameter(BUDGET_ID));
		}
		if(pageNo!=1)
		{
			budgetId=pharmacyMasterHandlerService.getMasStoreBudgetId(Integer.parseInt(budgetCode));
		}
		if(request.getParameter(CRV_COMMITTED_AMOUNT) != null && !(request.getParameter(CRV_COMMITTED_AMOUNT).equals(""))){
			crvComittedAmount =  Float.parseFloat(request.getParameter(CRV_COMMITTED_AMOUNT));
		}
		if(request.getParameter(PO_COMMITTED_AMOUNT) != null && !(request.getParameter(PO_COMMITTED_AMOUNT).equals(""))){
			poCommitedAmount =  Float.parseFloat(request.getParameter(PO_COMMITTED_AMOUNT));
		}
		if(request.getParameter(UTILIZED_AMOUNT) != null && !(request.getParameter(UTILIZED_AMOUNT).equals(""))){
			utilizedAmount =  Float.parseFloat(request.getParameter(UTILIZED_AMOUNT));
		}
		if(request.getParameter(CHANGED_BY) !=null){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null){
			changedTime = request.getParameter(CHANGED_TIME);
		}
		
		String headerStored="no";

		if(pageNo==1){
			try{
			masStoreBudget.setBudgetCode(budgetCode);
			
			MasStoreFinancial financialObj = new MasStoreFinancial();
			financialObj.setId(financialId);
			masStoreBudget.setFinancial(financialObj);
			
			masStoreBudget.setTotalAllocatedAmount(totalAllocatedAmount);
			masStoreBudget.setCrvComittedAmount(crvComittedAmount);
			masStoreBudget.setPoComittedAmount(poCommitedAmount);
			masStoreBudget.setUtilizedAmount(utilizedAmount);
			masStoreBudget.setStatus("y");
			masStoreBudget.setLastChgBy(changedBy);
			masStoreBudget.setLastChgDate(changedDate);
			masStoreBudget.setLastChgTime(changedTime);
			
			}catch (Exception e) {
			}	
		}else{
			headerStored="yes";
			infoMap.put("headerStored", headerStored);
		}
		int length=0;
		List<MasStoreBudgetT> masStoreBudgetTList  = new ArrayList<MasStoreBudgetT>();
		BigDecimal[] projectAmountArray=new BigDecimal[10];
		BigDecimal[] budgetedAmountArray=new BigDecimal[10];
		BigDecimal[] additionalAmountArray=new BigDecimal[10];
		
		try{	

			int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,SR_NO);
			String[] authorityLetterNo = JKTRequestUtils.getRequiredStringParameters(request,AUTHORITY_LETTER_NO);
			String xx[]=JKTRequestUtils.getRequiredStringParameters(request, PROJECT_AMOUNT);
			int xxLegnt=xx.length;
			for(int i=0;i<xxLegnt;i++)
			{
				BigDecimal val1 = new BigDecimal(xx[i]);
				projectAmountArray[i]=val1;
			}
			String yy[]=JKTRequestUtils.getRequiredStringParameters(request, BUDGETED_AMOUNT);
			int yyLegnt=yy.length;
			for(int i=0;i<yyLegnt;i++)
			{
				BigDecimal val2 = new BigDecimal(yy[i]);
				budgetedAmountArray[i]=val2;
			}
			String zz[]=JKTRequestUtils.getRequiredStringParameters(request, ADDITIONAL_ALLOCATED_AMOUNT);
			int zzLegnt=zz.length;
			for(int i=0;i<zzLegnt;i++)
			{
				BigDecimal val3 = new BigDecimal(zz[i]);
				additionalAmountArray[i]=val3;
			}
			
			length = noOfRecords;
			for(int i = 0 ; i<length ; i++){

					MasStoreBudgetT masStoreBudgetTObj=new MasStoreBudgetT();
					
					masStoreBudgetTObj.setSrNo(srNo[i]);

					masStoreBudgetTObj.setAuthorityLetterNo(authorityLetterNo[i]);
					
					masStoreBudgetTObj.setProjectAmount(projectAmountArray[i]);
					
					masStoreBudgetTObj.setBudgetedAmount(budgetedAmountArray[i]);
					
					masStoreBudgetTObj.setAdditionalAmount(additionalAmountArray[i]);

					masStoreBudgetTList.add(masStoreBudgetTObj);
				}


		}catch (Exception e) {
			e.printStackTrace();
		}


		infoMap.put("pageNo",pageNo);
		infoMap.put("budgetCode",budgetCode);
		infoMap.put("budgetId",budgetId);
		boolean flag=false;
		try{
			flag=pharmacyMasterHandlerService.addBudgetEntry(masStoreBudget, masStoreBudgetTList,infoMap);

		}catch (Exception e) {
			e.printStackTrace();
		}
		String messageTOBeVisibleToTheUser="";

		if(flag){

			pageNo++;
			messageTOBeVisibleToTheUser="Transaction Completed Successfully";
		}else {
			messageTOBeVisibleToTheUser="Not Transaction Completed Successfully";
		}

		jsp="messageBudgetEntry";
		jsp += ".jsp";
		
		map.put("budgetCode",budgetCode);
		map.put("pageNo",pageNo);
		map.put("contentJsp",jsp);
		map.put("messageTOBeVisibleToTheUser",messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);


		
	}
	@SuppressWarnings("unchecked")
	public ModelAndView searchBudgetEntry(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		String fromDate="";
		String toDate="";
		int financialId=0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		Map<String, Object>searchFieldMap= new HashMap<String, Object>();
		List<MasStoreBudget> searchBudgetList= new ArrayList<MasStoreBudget>();
		try{
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter(TO_DATE) != null) {
			}
			if(!request.getParameter(SEARCH_FINANCIAL_ID).equals("0"))
			{
				  financialId = Integer.parseInt(request.getParameter(SEARCH_FINANCIAL_ID));
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		searchFieldMap.put("fromDate",fromDate);
		searchFieldMap.put("toDate",toDate);
		searchFieldMap.put("financialId",financialId);
		tempMap=pharmacyMasterHandlerService.showBudgetJsp();
		if(tempMap.get("searchBudgetList")!=null)
			
			searchBudgetList=(List)tempMap.get("searchBudgetList");
		
		map=pharmacyMasterHandlerService.searchMasStoreBudget(searchFieldMap);
		map.put("searchBudgetList",searchBudgetList);
		
		jsp = SEARCH_BUDGET_ENTRY_JSP;
		jsp += ".jsp";
		title = "Budget Entry";
		map.put("contentJsp",jsp);
		map.put("title", title);

		return new ModelAndView("index","map", map);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView modifyBudgetEntry(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		jsp = BUDGET_ENTRY_MODIFY;
		jsp += ".jsp";
		int radio_str=0;
		if (request.getParameter("parent") != null) {
			radio_str =Integer.parseInt( request.getParameter("parent"));
			map=(Map)pharmacyMasterHandlerService.getBudgetEntryModifyMap(radio_str);
		}
		List<MasStoreBudget> searchBudgetList= new ArrayList<MasStoreBudget>();
		List<MasStoreFinancial> finanacialList= new ArrayList<MasStoreFinancial>();
		map2=pharmacyMasterHandlerService.showBudgetJsp();
		searchBudgetList=(List) map2.get("searchBudgetList");
		finanacialList=(List) map2.get("finanacialList");
		map.put("searchBudgetList", searchBudgetList);
		map.put("finanacialList", finanacialList);

		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("radio_str",radio_str);



		return new ModelAndView("index","map", map);


	}
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public ModelAndView updateNextBudgetEntry(HttpServletRequest request, HttpServletResponse response){

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> infoMap=new HashMap<String,Object>();
		MasStoreBudget masStoreBudget = new MasStoreBudget();
		int financialId= 0;
		String budgetCode="";
		Float totalAllocatedAmount = null;
		Float crvComittedAmount = null;
		Float poCommitedAmount = null;
		Float utilizedAmount = null;
		Date changedDate = null;
		String changedBy = "";		
		String changedTime = "";
		int noOfRecords=0;
		int rows=0;
		int budgetId=0;
		int totalRecords=0;
		int pageNo=1;
		try{
			if (request.getParameter("pageNo") != null) {
				pageNo= Integer.parseInt(request.getParameter("pageNo"));
			}
			if (request.getParameter("totalRecords") != null) {
				totalRecords= Integer.parseInt(request.getParameter("totalRecords"));
			}
			if(request.getParameter(BUDGET_CODE) != null && !(request.getParameter(BUDGET_CODE).equals(""))){
				budgetCode = request.getParameter(BUDGET_CODE);
			}
			if(!request.getParameter(FINANCIAL_ID).equals("0")){
			  financialId = Integer.parseInt(request.getParameter(FINANCIAL_ID));
			}
			if(request.getParameter(TOTAL_ALLOCATED_AMOUNT) != null && !(request.getParameter(TOTAL_ALLOCATED_AMOUNT).equals(""))){
				totalAllocatedAmount = Float.parseFloat(request.getParameter(TOTAL_ALLOCATED_AMOUNT));
			}
			if (request.getParameter(BUDGET_ID) != null) {
				budgetId= Integer.parseInt(request.getParameter(BUDGET_ID));
			}
			if(pageNo!=1)
			{
				budgetId=pharmacyMasterHandlerService.getMasStoreBudgetId(Integer.parseInt(budgetCode));
			}
			if(request.getParameter(CRV_COMMITTED_AMOUNT) != null && !(request.getParameter(CRV_COMMITTED_AMOUNT).equals(""))){
				crvComittedAmount =  Float.parseFloat(request.getParameter(CRV_COMMITTED_AMOUNT));
			}
			if(request.getParameter(PO_COMMITTED_AMOUNT) != null && !(request.getParameter(PO_COMMITTED_AMOUNT).equals(""))){
				poCommitedAmount =  Float.parseFloat(request.getParameter(PO_COMMITTED_AMOUNT));
			}
			if(request.getParameter(UTILIZED_AMOUNT) != null && !(request.getParameter(UTILIZED_AMOUNT).equals(""))){
				utilizedAmount =  Float.parseFloat(request.getParameter(UTILIZED_AMOUNT));
			}
			if(request.getParameter(CHANGED_BY) !=null){
				changedBy = request.getParameter(CHANGED_BY);
			}
			if(request.getParameter(CHANGED_DATE) != null){
				changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			}
			if(request.getParameter(CHANGED_TIME) != null){
				changedTime = request.getParameter(CHANGED_TIME);
			}
			if (request.getParameter(NO_OF_ROWS) != null) {
				noOfRecords= Integer.parseInt(request.getParameter(NO_OF_ROWS));
			}
			
			
		if (request.getParameter(NO_OF_ROWS) != null) {

			rows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
		}
		}catch (Exception e) {
		}	
		String headerStored="no";

		if(pageNo==1){
			try{
				masStoreBudget.setId(budgetId);
				masStoreBudget.setBudgetCode(budgetCode);
				
				MasStoreFinancial financialObj = new MasStoreFinancial();
				financialObj.setId(financialId);
				masStoreBudget.setFinancial(financialObj);
				
				masStoreBudget.setTotalAllocatedAmount(totalAllocatedAmount);
				masStoreBudget.setCrvComittedAmount(crvComittedAmount);
				masStoreBudget.setPoComittedAmount(poCommitedAmount);
				masStoreBudget.setUtilizedAmount(utilizedAmount);
				masStoreBudget.setStatus("y");
				masStoreBudget.setLastChgBy(changedBy);
				masStoreBudget.setLastChgDate(changedDate);
				masStoreBudget.setLastChgTime(changedTime);


				
			}catch (Exception e) {
			}	
		}else{
			headerStored="yes";
			infoMap.put("headerStored", headerStored);
		}
		int length=0;
		List<MasStoreBudgetT> masStoreBudgetTList  = new ArrayList<MasStoreBudgetT>();
		BigDecimal[] projectAmountArray=new BigDecimal[10];
		BigDecimal[] budgetedAmountArray=new BigDecimal[10];
		BigDecimal[] additionalAmountArray=new BigDecimal[10];
		
		try{	
			int idArray[] = JKTRequestUtils.getRequiredIntParameters(request,BUDGET_T_ID);
			int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,SR_NO);
			String[] authorityLetterNo = JKTRequestUtils.getRequiredStringParameters(request,AUTHORITY_LETTER_NO);
			String xx[]=JKTRequestUtils.getRequiredStringParameters(request, PROJECT_AMOUNT);
			int xxLegnt=xx.length;
			for(int i=0;i<xxLegnt;i++)
			{
				BigDecimal val1 = new BigDecimal(xx[i]);
				projectAmountArray[i]=val1;
			}
			String yy[]=JKTRequestUtils.getRequiredStringParameters(request, BUDGETED_AMOUNT);
			int yyLegnt=yy.length;
			for(int i=0;i<yyLegnt;i++)
			{
				BigDecimal val2 = new BigDecimal(yy[i]);
				budgetedAmountArray[i]=val2;
			}
			String zz[]=JKTRequestUtils.getRequiredStringParameters(request, ADDITIONAL_ALLOCATED_AMOUNT);
			int zzLegnt=zz.length;
			for(int i=0;i<zzLegnt;i++)
			{
				BigDecimal val3 = new BigDecimal(zz[i]);
				additionalAmountArray[i]=val3;
			}
			
			
			
			//System.out.println("srNo[]   "+srNo.length);
			length = noOfRecords;
			for(int i = 0 ; i<length ; i++){

					MasStoreBudgetT masStoreBudgetTObj=new MasStoreBudgetT();
					
					masStoreBudgetTObj.setId(idArray[i]);
					
					MasStoreBudget masStoreBudget1 = new MasStoreBudget();
					masStoreBudget1.setId(budgetId);
					masStoreBudgetTObj.setBudget(masStoreBudget1);
					
					masStoreBudgetTObj.setSrNo(srNo[i]);

					masStoreBudgetTObj.setAuthorityLetterNo(authorityLetterNo[i]);
					
					masStoreBudgetTObj.setProjectAmount(projectAmountArray[i]);
					
					masStoreBudgetTObj.setBudgetedAmount(budgetedAmountArray[i]);
					
					masStoreBudgetTObj.setAdditionalAmount(additionalAmountArray[i]);

					masStoreBudgetTList.add(masStoreBudgetTObj);
				}


		}catch (Exception e) {
			e.printStackTrace();
		}

		boolean flag= pharmacyMasterHandlerService.updateBudgetEntry(masStoreBudget,masStoreBudgetTList);

		infoMap.put("pageNo",pageNo);
		infoMap.put("budgetId", budgetId);
		String messageTOBeVisibleToTheUser="";


		if(flag){
			if((totalRecords>pageNo*10)){
				jsp="updateBudgetEntry";
			}else{
				jsp="messageBudgetEntry";
				messageTOBeVisibleToTheUser="Updated Successfully";
			}

			pageNo++;
			//
		}else {
			messageTOBeVisibleToTheUser="Not Updated";
		}

		jsp += ".jsp";
		
		Map<String,Object> map2=new HashMap<String,Object>();
		map2=(Map)pharmacyMasterHandlerService.showBudgetJsp();
		map=(Map)pharmacyMasterHandlerService.getBudgetAndTUpdate(budgetId);
		map.put("searchBudgetList",(List)map2.get("searchBudgetList"));

		map.put("budgetId", budgetId);
		map.put("pageNo",pageNo);
		map.put("contentJsp",jsp);
		map.put("messageTOBeVisibleToTheUser",messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	
	
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public ModelAndView nextBudgetEntry(HttpServletRequest request, HttpServletResponse response){

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> infoMap=new HashMap<String,Object>();
		MasStoreBudget masStoreBudget = new MasStoreBudget();
		int financialId= 0;
		String budgetCode="";
		Float totalAllocatedAmount = null;
		Float crvComittedAmount = null;
		Float poCommitedAmount = null;
		Float utilizedAmount = null;
		Date changedDate = null;
		String changedBy = "";		
		String changedTime = "";
		int noOfRecords=0;
		int rows=0;
		int budgetId=0;
		int totalRecords=0;
		int pageNo=1;

		try{if (request.getParameter("pageNo") != null) {
			pageNo= Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("totalRecords") != null) {
			totalRecords= Integer.parseInt(request.getParameter("totalRecords"));
		}
		if(request.getParameter(BUDGET_CODE) != null && !(request.getParameter(BUDGET_CODE).equals(""))){
			budgetCode = request.getParameter(BUDGET_CODE);
		}
		if(!request.getParameter(FINANCIAL_ID).equals("0")){
		  financialId = Integer.parseInt(request.getParameter(FINANCIAL_ID));
		}
		if(request.getParameter(TOTAL_ALLOCATED_AMOUNT) != null && !(request.getParameter(TOTAL_ALLOCATED_AMOUNT).equals(""))){
			totalAllocatedAmount = Float.parseFloat(request.getParameter(TOTAL_ALLOCATED_AMOUNT));
		}
		if (request.getParameter(BUDGET_ID) != null) {
			budgetId= Integer.parseInt(request.getParameter(BUDGET_ID));
		}
		if(pageNo!=1)
		{
			budgetId=pharmacyMasterHandlerService.getMasStoreBudgetId(Integer.parseInt(budgetCode));
		}
		if(request.getParameter(CRV_COMMITTED_AMOUNT) != null && !(request.getParameter(CRV_COMMITTED_AMOUNT).equals(""))){
			crvComittedAmount =  Float.parseFloat(request.getParameter(CRV_COMMITTED_AMOUNT));
		}
		if(request.getParameter(PO_COMMITTED_AMOUNT) != null && !(request.getParameter(PO_COMMITTED_AMOUNT).equals(""))){
			poCommitedAmount =  Float.parseFloat(request.getParameter(PO_COMMITTED_AMOUNT));
		}
		if(request.getParameter(UTILIZED_AMOUNT) != null && !(request.getParameter(UTILIZED_AMOUNT).equals(""))){
			utilizedAmount =  Float.parseFloat(request.getParameter(UTILIZED_AMOUNT));
		}
		if(request.getParameter(CHANGED_BY) !=null){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null){
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(NO_OF_ROWS) != null) {
			noOfRecords= Integer.parseInt(request.getParameter(NO_OF_ROWS));
		}
		
		
	if (request.getParameter(NO_OF_ROWS) != null) {

		rows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
	}
	}catch (Exception e) {
	}	

		String headerStored="no";

		if(pageNo==1){
			try{
				masStoreBudget.setBudgetCode(budgetCode);
				
				MasStoreFinancial financialObj = new MasStoreFinancial();
				financialObj.setId(financialId);
				masStoreBudget.setFinancial(financialObj);
				
				masStoreBudget.setTotalAllocatedAmount(totalAllocatedAmount);
				masStoreBudget.setCrvComittedAmount(crvComittedAmount);
				masStoreBudget.setPoComittedAmount(poCommitedAmount);
				masStoreBudget.setUtilizedAmount(utilizedAmount);
				masStoreBudget.setStatus("y");
				masStoreBudget.setLastChgBy(changedBy);
				masStoreBudget.setLastChgDate(changedDate);
				masStoreBudget.setLastChgTime(changedTime);


			}catch (Exception e) {
			}	
		}else{
			headerStored="yes";
			infoMap.put("headerStored", headerStored);
		}

		int length=0;
		List<MasStoreBudgetT> masStoreBudgetTList  = new ArrayList<MasStoreBudgetT>();
		BigDecimal[] projectAmountArray=new BigDecimal[10];
		BigDecimal[] budgetedAmountArray=new BigDecimal[10];
		BigDecimal[] additionalAmountArray=new BigDecimal[10];
		
		try{	
			int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,SR_NO);
			String[] authorityLetterNo = JKTRequestUtils.getRequiredStringParameters(request,AUTHORITY_LETTER_NO);
			String xx[]=JKTRequestUtils.getRequiredStringParameters(request, PROJECT_AMOUNT);
			int xxLegnt=xx.length;
			for(int i=0;i<xxLegnt;i++)
			{
				BigDecimal val1 = new BigDecimal(xx[i]);
				projectAmountArray[i]=val1;
			}
			String yy[]=JKTRequestUtils.getRequiredStringParameters(request, BUDGETED_AMOUNT);
			int yyLegnt=yy.length;
			for(int i=0;i<yyLegnt;i++)
			{
				BigDecimal val2 = new BigDecimal(yy[i]);
				budgetedAmountArray[i]=val2;
			}
			String zz[]=JKTRequestUtils.getRequiredStringParameters(request, ADDITIONAL_ALLOCATED_AMOUNT);
			int zzLegnt=zz.length;
			for(int i=0;i<zzLegnt;i++)
			{
				BigDecimal val3 = new BigDecimal(zz[i]);
				additionalAmountArray[i]=val3;
			}
			
			
			
			length = noOfRecords;
			for(int i = 0 ; i<length ; i++){

					MasStoreBudgetT masStoreBudgetTObj=new MasStoreBudgetT();
					
					masStoreBudgetTObj.setSrNo(srNo[i]);

					masStoreBudgetTObj.setAuthorityLetterNo(authorityLetterNo[i]);
					
					masStoreBudgetTObj.setProjectAmount(projectAmountArray[i]);
					
					masStoreBudgetTObj.setBudgetedAmount(budgetedAmountArray[i]);
					
					masStoreBudgetTObj.setAdditionalAmount(additionalAmountArray[i]);

					masStoreBudgetTList.add(masStoreBudgetTObj);
				}


		}catch (Exception e) {
			e.printStackTrace();
		}



		map=(Map)pharmacyMasterHandlerService.showBudgetJsp();

		jsp = "message";

		infoMap.put("pageNo",pageNo);
		infoMap.put("budgetId", budgetId);
		boolean flag=false;
		try{
			flag=pharmacyMasterHandlerService.addBudgetEntry(masStoreBudget, masStoreBudgetTList, infoMap);
			budgetId=pharmacyMasterHandlerService.getMasStoreBudgetId(Integer.parseInt(budgetCode));
		}catch (Exception e) {
		}
		String messageTOBeVisibleToTheUser="";
		if(flag){
			jsp="budgetEntry";
			pageNo++;
			messageTOBeVisibleToTheUser="Added";
		}else {
			messageTOBeVisibleToTheUser="Not Added";
		}

		jsp += ".jsp";
		
		map.put("budgetId", budgetId);
		map.put("pageNo",pageNo);
		map.put("contentJsp",jsp);
		map.put("messageTOBeVisibleToTheUser",messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}*/
	
	public ModelAndView addBudgetDetails(HttpServletRequest request, HttpServletResponse response){
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int hospitalId=0;
		
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		int deptId=box.getInt("deptId");
		Map<String, Object> map= new HashMap<String, Object>();
		Map<String, Object> budgetMap= new HashMap<String, Object>();	
		Map<String, Object> utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		List<MasStoreBudget> financialYearList = new ArrayList<MasStoreBudget>();
		Map<String, Object> generalMap= new HashMap<String, Object>();
		
		MasStoreBudgetT masStoreBudgetT = new MasStoreBudgetT();
		MasStoreBudget masStoreBudgetObj = new MasStoreBudget();
	
		int budgetId = 0;
		int financialId = 0;
		BigDecimal crvAmount = null;
		BigDecimal totalAmount = new BigDecimal(0);
		BigDecimal poAmount = new BigDecimal(0);
		BigDecimal spendAmount = new BigDecimal(0);
		String authorityLetterNo = "";
		BigDecimal projectAmount = new BigDecimal(0);
		BigDecimal budgetedAmount = new BigDecimal(0);
		BigDecimal additionalAllocatedAmount = new BigDecimal(0);
		
		BigDecimal prevSpendAmount = new BigDecimal(0);
		BigDecimal currentSpendAmount = new BigDecimal(0);
		BigDecimal balanceAmount = new BigDecimal(0);
		
		String currentDate = "";
		String currentTime = "";
		String budget_code = "";
		String changedBy = "";
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("deptId",deptId);
		if(!request.getParameter(FINANCIAL_ID).equals("0")){
			financialId = Integer.parseInt(request.getParameter(FINANCIAL_ID));
			generalMap.put("financialId", financialId);
		}
		
		if(request.getParameter("budgetCode")!=null)
		{
			budget_code = request.getParameter("budgetCode").toString();
			generalMap.put("budget_code", budget_code);
		}
		
		if(request.getParameter(CHANGED_BY)!=null)
		{
			changedBy = request.getParameter(CHANGED_BY).toString();
		}
		
		
		//List<MasStoreBudget> financialYearList = pharmacyMasterHandlerService.getFinancialYearDetails(financialId);
		map = pharmacyMasterHandlerService.getFinancialYearDetails(generalMap);
		
		if(map.get("financialYearList") != null){
			financialYearList = (List<MasStoreBudget>)map.get("financialYearList");
		}
		
		if (financialYearList!=null && financialYearList.size()>0)
		{
			for (MasStoreBudget masStoreBudget : financialYearList) 
			{
				budgetId = masStoreBudget.getId();
				crvAmount = masStoreBudget.getCrvComittedAmount();
				totalAmount = masStoreBudget.getTotalAllocatedAmount();
				poAmount = masStoreBudget.getPoComittedAmount();
				spendAmount = masStoreBudget.getSpendAmount();
			}
		}
		else //Add a Record in Mas_Store_Budget
		{
			currentDate = (String)utilMap.get("currentDate");	 
			currentTime = (String)utilMap.get("currentTime");
			MasStoreBudget masStoreBudget = new MasStoreBudget();
			masStoreBudget.setBudgetCode(budget_code);
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial(financialId);
			masStoreBudget.setFinancial(masStoreFinancial);
			masStoreBudget.setLastChgBy(changedBy);
			masStoreBudget.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			masStoreBudget.setLastChgTime(currentTime);
			masStoreBudget.setTotalAllocatedAmount(new BigDecimal(0));
			masStoreBudget.setStatus("y");
			masStoreBudget.setBalanceAmount(new BigDecimal(0));
			masStoreBudget.setCrvComittedAmount(new BigDecimal(0));
			masStoreBudget.setPoComittedAmount(new BigDecimal(0));
			masStoreBudget.setSpendAmount(new BigDecimal(0));
			masStoreBudget.setDepartment(new MasDepartment(box.getInt("deptId")));
			masStoreBudget.setHospital(new MasHospital(hospitalId));
			Map<String,Object> budgetMasterMap = new HashMap<String,Object>();
			budgetMasterMap.put("masStoreBudget", masStoreBudget); 
			budgetId = pharmacyMasterHandlerService.addBudgetMaster(budgetMasterMap);
			crvAmount = new BigDecimal(0);
			totalAmount = new BigDecimal(box.getFloat(BUDGETED_AMOUNT)).add(new BigDecimal(box.getFloat(ADDITIONAL_ALLOCATED_AMOUNT)));
			poAmount = new BigDecimal(0);
			spendAmount = new BigDecimal(0);
			
		}
		
		//MasStoreBudget details from budgetEntry.jsp
		if(request.getParameter(PREVIOUS_SPEND_AMOUNT) != null && !request.getParameter(PREVIOUS_SPEND_AMOUNT).equals("")){
			
			try
			{
				prevSpendAmount = new BigDecimal(box.getString(PREVIOUS_SPEND_AMOUNT));
			}
			catch(Exception e)
			{
				prevSpendAmount =new BigDecimal(0);
			}
			
			
			budgetMap.put("prevSpendAmount", prevSpendAmount);
		}
		
		if(request.getParameter(SPEND_AMOUNT) != null && !request.getParameter(SPEND_AMOUNT).equals(""))
		{
			try
			{
				currentSpendAmount = new BigDecimal(box.getString(SPEND_AMOUNT));
			}
			catch(Exception e)
			{
				currentSpendAmount  = new BigDecimal(0);
			}
		
			budgetMap.put("currentSpendAmount", currentSpendAmount);
		}
		/*if(request.getParameter(BALANCE_AMOUNT) != null && !request.getParameter(BALANCE_AMOUNT).equals("")){
			try
			{
				balanceAmount = Float.parseFloat(request.getParameter(BALANCE_AMOUNT));
			}
			catch(Exception e)
			{
				balanceAmount  = 0f;
			}


			budgetMap.put("balanceAmount", balanceAmount);
		}
*/		
		currentDate = (String)utilMap.get("currentDate");	 
		currentTime = (String)utilMap.get("currentTime");
		budgetMap.put("currentDate", currentDate);
		budgetMap.put("currentTime", currentTime);
		
		// MasStoreBudgetT details from budgetEntry.jsp
		if(request.getParameter(AUTHORITY_LETTER_NO) != null)
		{
			authorityLetterNo = request.getParameter(AUTHORITY_LETTER_NO);
			masStoreBudgetT.setAuthorityLetterNo(authorityLetterNo);
		}
		
		if(request.getParameter(PROJECT_AMOUNT) != null)
		{
			try
			{
			projectAmount = new BigDecimal(box.get(PROJECT_AMOUNT));
			}
			catch(Exception e)
			{
			projectAmount=new BigDecimal(0);
			}
			
			BigDecimal projectAmt = new BigDecimal(0);
			projectAmt = projectAmount;
			masStoreBudgetT.setProjectAmount(projectAmt);
		}

		if(request.getParameter(BUDGETED_AMOUNT) != null)
		{
			try
			{
				budgetedAmount = new BigDecimal(box.get(BUDGETED_AMOUNT));
			}
			catch(Exception e)
			{
				budgetedAmount =new BigDecimal(0);
			}
		
			BigDecimal budgetedAmt = new BigDecimal(0);
			budgetedAmt  = budgetedAmount;
			masStoreBudgetT.setBudgetedAmount(budgetedAmt);
		}
		
		if(request.getParameter(ADDITIONAL_ALLOCATED_AMOUNT) != null && !request.getParameter(ADDITIONAL_ALLOCATED_AMOUNT).equals("")){
			
			try
			{
				additionalAllocatedAmount = new BigDecimal(box.get(ADDITIONAL_ALLOCATED_AMOUNT));
			}
			catch(Exception e)
			{
				additionalAllocatedAmount = new BigDecimal(0);
			}

			BigDecimal additionalAllocatedAmt = new BigDecimal(0);
			additionalAllocatedAmt = new BigDecimal(0);
			masStoreBudgetT.setAdditionalAmount(additionalAllocatedAmount);
		}
		//int srNo = 1;

		MasStoreBudget masStoreBudget = new MasStoreBudget(budgetId);
		masStoreBudgetT.setBudget(masStoreBudget);
		//masStoreBudgetT.setSrNo(srNo++);
		
		budgetMap.put("masStoreBudgetT", masStoreBudgetT);
		budgetMap.put("masStoreBudgetObj", masStoreBudgetObj);
		budgetMap.put("budgetId", budgetId);
		
		boolean flag = pharmacyMasterHandlerService.addBudgetDetails(budgetMap);
		String messageTOBeVisibleToTheUser = "";
		
		if(flag){
			messageTOBeVisibleToTheUser = "Budget Details has been added successfully.";
		}else{
			messageTOBeVisibleToTheUser = "Budget Details has not been added successfully.";
		}
		
		map.put("crvAmount", crvAmount);
		map.put("totalAmount", totalAmount);
		map.put("poAmount", poAmount);
		map.put("spendAmount", spendAmount);
		/*url = "/hms/hms/pharmacy?method=showBudgetJsp";
		//jsp = MESSAGE_JSP;
		jsp = BUDGET_ENTRY_JSP;
		jsp += ".jsp";
		map.put("url", url);
		map.put("contentJsp",jsp);
		map.put("messageTOBeVisibleToTheUser",messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);*/
		return showBudgetJsp(request,response);
	}
	
	public ModelAndView getFinancialYearDetails(HttpServletRequest request, HttpServletResponse response){
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map= new HashMap<String, Object>();		
		List<MasStoreBudget> financialYearList = new ArrayList<MasStoreBudget>();
		List<MasStoreBudget> budgetDetailsList = new ArrayList<MasStoreBudget>();
		
		
		int financialId = 0;
		BigDecimal crvAmount = null;
		BigDecimal totalAmount = new BigDecimal(0);
		BigDecimal poAmount = new BigDecimal(0);
		BigDecimal spendAmount = new BigDecimal(0);
		BigDecimal balanceAmount = new BigDecimal(0);
		
		String budget_code = "";
		int hospitalId=0;
		int deptId=0;
		
		session = request.getSession();
	
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		
		generalMap.put("hospitalId",hospitalId);
		generalMap.put("deptId",deptId);
		if(!request.getParameter(FINANCIAL_ID).equals("0")){
			financialId = Integer.parseInt(request.getParameter(FINANCIAL_ID));
			generalMap.put("financialId", financialId);
		}
		if(request.getParameter("budgetCode")!=null)
		{
			budget_code = request.getParameter("budgetCode").toString();
			generalMap.put("budget_code", budget_code);
		}
		
		//List<MasStoreBudget> financialYearList = pharmacyMasterHandlerService.getFinancialYearDetails(financialId);
		map = pharmacyMasterHandlerService.getFinancialYearDetails(generalMap);
	
		
		if(map.get("financialYearList") != null){
			financialYearList = (List<MasStoreBudget>)map.get("financialYearList");
		}
		if(map.get("budgetDetailsList") != null){
			budgetDetailsList = (List<MasStoreBudget>)map.get("budgetDetailsList");
		}
		for (MasStoreBudget masStoreBudget : financialYearList) {
			crvAmount = masStoreBudget.getCrvComittedAmount();
			totalAmount = masStoreBudget.getTotalAllocatedAmount();
			poAmount = masStoreBudget.getPoComittedAmount();
			spendAmount = masStoreBudget.getSpendAmount();
			balanceAmount = masStoreBudget.getBalanceAmount();
			
		}
		map.put("crvAmount", crvAmount);
		map.put("totalAmount", totalAmount);
		map.put("poAmount", poAmount);
		map.put("spendAmount", spendAmount);
		map.put("balanceAmount", balanceAmount);
		
		map.put("budgetDetailsList", budgetDetailsList);
		
		jsp = BUDGET_DETAILS_JSP;
		return new ModelAndView(jsp, "map", map);
	}
	
/*	
 * 
 * public ModelAndView searchBudget(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{

		Map<String, Object> map= new HashMap<String, Object>();		
		String budgetCode  = "";
	
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			budgetCode = request.getParameter(CODE);
		}
	
		map = pharmacyMasterHandlerService.searchBudget(budgetCode);
		jsp=BUDGET_ENTRY_JSP;
		jsp += ".jsp";
		map.put("budgetCode", budgetCode);
		map.put("contentJsp",jsp);
		map.put("title", title);
		
	return new ModelAndView("index", "map", map);
}
	public ModelAndView addBudget(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();	
		MasStoreBudget masStoreBudget = new MasStoreBudget();
		int financialId= 0;
		String budgetCode="";
		Float totalAllocatedAmount = null;
		Float crvComittedAmount = null;
		Float poCommitedAmount = null;
		Float utilizedAmount = null;
		Date changedDate = null;
		String changedBy = "";		
		String changedTime = "";

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			budgetCode = request.getParameter(CODE);
		}
		if(!request.getParameter(FINANCIAL_ID).equals("0")){
		  financialId = Integer.parseInt(request.getParameter(FINANCIAL_ID));
		}
		if(request.getParameter(TOTAL_ALLOCATED_AMOUNT) != null && !(request.getParameter(TOTAL_ALLOCATED_AMOUNT).equals(""))){
			totalAllocatedAmount = Float.parseFloat(request.getParameter(TOTAL_ALLOCATED_AMOUNT));
		}
		if(request.getParameter(CRV_COMMITTED_AMOUNT) != null && !(request.getParameter(CRV_COMMITTED_AMOUNT).equals(""))){
			crvComittedAmount =  Float.parseFloat(request.getParameter(CRV_COMMITTED_AMOUNT));
		}
		if(request.getParameter(PO_COMMITTED_AMOUNT) != null && !(request.getParameter(PO_COMMITTED_AMOUNT).equals(""))){
			poCommitedAmount =  Float.parseFloat(request.getParameter(PO_COMMITTED_AMOUNT));
		}
		if(request.getParameter(UTILIZED_AMOUNT) != null && !(request.getParameter(UTILIZED_AMOUNT).equals(""))){
			utilizedAmount =  Float.parseFloat(request.getParameter(UTILIZED_AMOUNT));
		}
		if(request.getParameter(CHANGED_BY) !=null){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null){
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		if(request.getParameter("pojoPropertyCode") != null){
			pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		if(request.getParameter("jspName") != null){
			jspName = request.getParameter("jspName"); 
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 		}

		generalMap.put("code", budgetCode);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List<MasStoreBudget> budgetCodeList = new ArrayList<MasStoreBudget>();

		if(listMap.get("duplicateGeneralCodeList") != null){
			budgetCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}

		boolean successfullyAdded = false;
		if(budgetCodeList.size() == 0)
		{
			masStoreBudget.setBudgetCode(budgetCode);
			
			MasStoreFinancial financialObj = new MasStoreFinancial();
			financialObj.setId(financialId);
			masStoreBudget.setFinancial(financialObj);
			
			masStoreBudget.setTotalAllocatedAmount(totalAllocatedAmount);
			masStoreBudget.setCrvComittedAmount(crvComittedAmount);
			masStoreBudget.setPoComittedAmount(poCommitedAmount);
			masStoreBudget.setUtilizedAmount(utilizedAmount);
			masStoreBudget.setStatus("y");
			masStoreBudget.setLastChgBy(changedBy);
			masStoreBudget.setLastChgDate(changedDate);
			masStoreBudget.setLastChgTime(changedTime);
			successfullyAdded = pharmacyMasterHandlerService.addBudget(masStoreBudget);
			if(successfullyAdded == true){
				message="Record Added Successfully !!";
			}else{
				message = "Try Again !!";
			}
				
		}else if(budgetCodeList.size() != 0){
			message = "Budget Code already exists.";
		}
		 try{
			   map = pharmacyMasterHandlerService.showBudgetJsp();
			    }catch (Exception e) {
			    }
			    jsp=BUDGET_JSP;
			    title="Add Budget";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("index", "map", map);
	}
	public ModelAndView editBudget(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int budgetId=0;
		int financialId= 0;
		Float totalAllocatedAmount = null;
		Float crvComittedAmount = null;
		Float poCommitedAmount = null;
		Float utilizedAmount = null;
		String changedBy = "";		
		String changedTime="";
		Date changedDate = new Date();	
		session = request.getSession();
		
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			budgetId =Integer.parseInt( request.getParameter(COMMON_ID));	
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			code = request.getParameter(CODE);
		}
		if(!request.getParameter(FINANCIAL_ID).equals("0")){
		  financialId = Integer.parseInt(request.getParameter(FINANCIAL_ID));
		}
		if(request.getParameter(TOTAL_ALLOCATED_AMOUNT) != null && !(request.getParameter(TOTAL_ALLOCATED_AMOUNT).equals(""))){
			totalAllocatedAmount = Float.parseFloat(request.getParameter(TOTAL_ALLOCATED_AMOUNT));
		}
		if(request.getParameter(CRV_COMMITTED_AMOUNT) != null && !(request.getParameter(CRV_COMMITTED_AMOUNT).equals(""))){
			crvComittedAmount =  Float.parseFloat(request.getParameter(CRV_COMMITTED_AMOUNT));
		}
		if(request.getParameter(PO_COMMITTED_AMOUNT) != null && !(request.getParameter(PO_COMMITTED_AMOUNT).equals(""))){
			poCommitedAmount =  Float.parseFloat(request.getParameter(PO_COMMITTED_AMOUNT));
		}
		if(request.getParameter(UTILIZED_AMOUNT) != null && !(request.getParameter(UTILIZED_AMOUNT).equals(""))){
			utilizedAmount =  Float.parseFloat(request.getParameter(UTILIZED_AMOUNT));
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
		 if(request.getParameter("pojoName") != null){
			   pojoName = request.getParameter("pojoName"); 
		  }
		  if(request.getParameter("pojoPropertyCode") != null){
			   pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		  }
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}

		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		generalMap.put("id", budgetId);
		generalMap.put("code", code);
		generalMap.put("financialId", financialId);
		generalMap.put("totalAllocatedAmount", totalAllocatedAmount);
		generalMap.put("crvComittedAmount", crvComittedAmount);
		generalMap.put("poCommitedAmount", poCommitedAmount);
		generalMap.put("utlizedAmount", utilizedAmount);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataUpdated=false;
		dataUpdated=pharmacyMasterHandlerService.editBudgetToDatabase(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showBudgetJsp";
		 try{
			   map = pharmacyMasterHandlerService.showBudgetJsp();
			    }catch (Exception e) {
			    }
			    jsp=BUDGET_ENTRY_JSP;
			    title="Add Budget";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("index", "map", map);
	}

	public ModelAndView deletebudget(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int budgetId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			budgetId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		boolean dataDeleted=false;
		dataDeleted=pharmacyMasterHandlerService.deleteBudget(budgetId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showBudgetJsp";
		try{
			map = pharmacyMasterHandlerService.showBudgetJsp();
		}catch (Exception e) {
		}
		jsp=BUDGET_ENTRY_JSP;
		title="delete Budget";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	*/
//-----------------------Me Scale----------------------------------------	
	
	public ModelAndView showMeScaleJsp(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showMeScaleJsp();
		jsp = ME_SCALE_JSP;
		jsp += ".jsp";
		title = "MeScale";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchMeScale(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		Map<String, Object> dataMap=new HashMap<String, Object>();	
		String meScaleNumber  = "";
		String meScaleDescription  = "";
		String pvmsNo  = "";

	if(request.getParameter(ME_SCALE_NUMBER) != null && !(request.getParameter(ME_SCALE_NUMBER).equals(""))){
		meScaleNumber =request.getParameter(ME_SCALE_NUMBER);
	}
	
	if(request.getParameter(ME_SCALE_DESCRIPTION) != null && !(request.getParameter(ME_SCALE_DESCRIPTION).equals(""))){
		meScaleDescription =request.getParameter(ME_SCALE_DESCRIPTION);
	}

	
	if(request.getParameter(ITEM_CODE) != null && !(request.getParameter(ITEM_CODE).equals(""))){
		pvmsNo =request.getParameter(ITEM_CODE);
	}

	dataMap.put("meScaleNumber",meScaleNumber);
	dataMap.put("meScaleDescription",meScaleDescription);
	dataMap.put("pvmsNo",pvmsNo);
	map = pharmacyMasterHandlerService.searchMeScale1(dataMap);
	jsp=UPDATE_ME_SCALE_JSP;
	jsp += ".jsp";
	map.put("search", "search");
	map.put("contentJsp",jsp);
	map.put("title", title);
	map.put("meScaleNumber",meScaleNumber);
	return new ModelAndView("indexB", "map", map);
}

	@SuppressWarnings("unchecked")
	public ModelAndView saveMeScale(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();	
		
		Box box = HMSUtil.getBox(request);
		String meScaleNumber = "";
		int deptId=0;
		int hospitalId=0;
		String meScaleDescription = "";
		Date changedDate = null;
		String changedBy = "";		
		String changedTime = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		
		
		if(request.getParameter(ME_SCALE_NUMBER) != null && !(request.getParameter(ME_SCALE_NUMBER).equals(""))){
			meScaleNumber = request.getParameter(ME_SCALE_NUMBER);
		}
		if(request.getParameter(ME_SCALE_DESCRIPTION) != null && !(request.getParameter(ME_SCALE_DESCRIPTION).equals(""))){
			meScaleDescription = request.getParameter(ME_SCALE_DESCRIPTION);
		}
		if(request.getParameter(CHANGED_BY) !=null){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null){
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
		if(request.getParameter("jspName") != null){
			jspName = request.getParameter("jspName"); 
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 		}

		generalMap.put("meScaleNumber", meScaleNumber);
		generalMap.put("meScaleDescription", meScaleDescription);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		
		
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List meScaleNumberList = new ArrayList();

		if(listMap.get("duplicateGeneralNameList") != null){
			meScaleNumberList = (List)listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;
		if(meScaleNumberList.size() == 0)
		{
			
			successfullyAdded = pharmacyMasterHandlerService.saveMeScale(box);
			if(successfullyAdded == true){
				message="Record Added Successfully !!";
			}else{
				message = "Try Again !!";
			}
				
			
			
			
		}else if(meScaleNumberList.size() != 0){
			message = "MeScale Number already exists.";
		}
		 try{
			   map = pharmacyMasterHandlerService.showMeScaleJsp();
			    }catch (Exception e) {
			    	e.printStackTrace();
			    }
			    jsp=ME_SCALE_JSP;
			    title="Add MeScale";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView updateMeScale(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();	
		
		Box box = HMSUtil.getBox(request);
		String meScaleNumber = "";
		int deptId=0;
		int hospitalId=0;
		String meScaleDescription = "";
		Date changedDate = null;
		String changedBy = "";		
		String changedTime = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
	
	
		if(request.getParameter(ME_SCALE_NUMBER) != null && !(request.getParameter(ME_SCALE_NUMBER).equals(""))){
			meScaleNumber =request.getParameter(ME_SCALE_NUMBER);
		}
		if(request.getParameter(ME_SCALE_DESCRIPTION) != null && !(request.getParameter(ME_SCALE_DESCRIPTION).equals(""))) {
			meScaleDescription = request.getParameter(ME_SCALE_DESCRIPTION);
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
		generalMap.put("meScaleNumber", meScaleNumber);
		generalMap.put("meScaleDescription", meScaleDescription);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		boolean dataUpdated=false;
		dataUpdated=pharmacyMasterHandlerService.updateMeScale(box);
		
		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showMeScaleJsp";
		 try{
			 map = pharmacyMasterHandlerService.searchMeScale1(generalMap);
			    }catch (Exception e) {

			    	e.printStackTrace();}
			    jsp=UPDATE_ME_SCALE_JSP;
			    title="Edit MeScale";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteMeScale(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int meScaleId=0;
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
			meScaleId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deleteMeScale(meScaleId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showMeScaleJsp";
		try{
			map = pharmacyMasterHandlerService.showMeScaleJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=ME_SCALE_JSP;
		title="delete MeScale";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	
//	--------------------AirForce Unit Depot Report-------------------------------------------------------
	

		public ModelAndView reportAirForceUnitDepot(HttpServletRequest request,HttpServletResponse response) 
		{
			Map<String, Object> parameters  = new HashMap<String, Object>();
			Map<String, Object> map  = new HashMap<String, Object>();
			parameters=pharmacyMasterHandlerService.getConnection();
			HMSUtil.generateReport("Mas_Air_Force_Depot", parameters, (Connection)parameters.get("conn"), response, getServletContext());
			return new ModelAndView("indexB", "map", map);	
				 
		}
//--------------------------AirForce Unit Depot-------------------------------------
	public ModelAndView showAirForceUnitDepotJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showAirForceUnitDepotJsp();
		jsp = AIR_FORCE_UNIT_DEPOT_JSP;
		jsp += ".jsp";
		title = "airForceUnitDepot";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchAirForceUnitDepot(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{

	Map<String, Object> map= new HashMap<String, Object>();		
	String airForceDepotName  = null;

	if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
		airForceDepotName = request.getParameter(SEARCH_NAME);
	}

	map = pharmacyMasterHandlerService.searchAirForceUnitDepot(airForceDepotName);
	jsp=AIR_FORCE_UNIT_DEPOT_JSP;
	jsp += ".jsp";
	map.put("search", "search");
	map.put("contentJsp",jsp);
	map.put("title", title);
	map.put("airForceDepotName",airForceDepotName);
	return new ModelAndView("indexB", "map", map);
}

	@SuppressWarnings("unchecked")
	public ModelAndView addAirForceUnitDepot(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();	
		MasStoreAirForceDepot masStoreAirForceDepot = new MasStoreAirForceDepot();
		String airForceDepotName = "";
		String type = "";
		Date changedDate = null;
		String changedBy = "";		
		String changedTime = "";

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			airForceDepotName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(AIR_FORCE_UNIT_DEPOT_TYPE) != null) {
			type = request.getParameter(AIR_FORCE_UNIT_DEPOT_TYPE);
		}
		if(request.getParameter(CHANGED_BY) !=null){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null){
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null){
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		if(request.getParameter("jspName") != null){
			jspName = request.getParameter("jspName"); 
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 		}

		generalMap.put("name", airForceDepotName);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", changedTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List airForceDepotNameList = new ArrayList();

		if(listMap.get("duplicateGeneralNameList") != null){
			airForceDepotNameList = (List)listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;
		if(airForceDepotNameList.size() == 0)
		{
			masStoreAirForceDepot.setAirForceDepotName(airForceDepotName);
			masStoreAirForceDepot.setAirForceDepotType(type);
			masStoreAirForceDepot.setStatus("y");
			masStoreAirForceDepot.setLastChgBy(changedBy);
			masStoreAirForceDepot.setLastChgDate(changedDate);
			masStoreAirForceDepot.setLastChgTime(changedTime);
			successfullyAdded = pharmacyMasterHandlerService.addAirForceUnitDepot(masStoreAirForceDepot);
			if(successfullyAdded == true){
				message="Record Added Successfully !!";
			}else{
				message = "Try Again !!";
			}
				
		}else if(airForceDepotNameList.size() != 0){
			message = "AF Unit Depot Name already exists.";
		}
		 try{
			   map = pharmacyMasterHandlerService.showAirForceUnitDepotJsp();
			    }catch (Exception e) {
			    	e.printStackTrace();
			    }
			    jsp=AIR_FORCE_UNIT_DEPOT_JSP;
			    title="Add AirForceUnitDepot";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView editAirForceUnitDepot(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
	//	MasStoreAirForceDepot masStoreAirForceDepot = new MasStoreAirForceDepot();
		String airForceDepotName = "";
		int airForceDepotId=0;
		String type = "";
		String changedBy = "";		
		String changedTime="";
		Date changedDate = new Date();	
		session = request.getSession();
		
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			airForceDepotId =Integer.parseInt( request.getParameter(COMMON_ID));	
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			airForceDepotName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(AIR_FORCE_UNIT_DEPOT_TYPE) != null) {
			type = request.getParameter(AIR_FORCE_UNIT_DEPOT_TYPE);
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
		generalMap.put("id", airForceDepotId);
		generalMap.put("airForceDepotName", airForceDepotName);
		generalMap.put("type", type);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataUpdated=false;
		dataUpdated=pharmacyMasterHandlerService.editAirForceUnitDepotToDatabase(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showAirForceUnitDepotJsp";
		 try{
			   map = pharmacyMasterHandlerService.showAirForceUnitDepotJsp();
			    }catch (Exception e) {
			    	e.printStackTrace();
			    }
			    jsp=AIR_FORCE_UNIT_DEPOT_JSP;
			    title="edit AirForceUnitDepot";
			    jsp += ".jsp";		    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteAirForceUnitDepot(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int airForceDepotId=0;
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
			airForceDepotId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deleteAirForceUnitDepot(airForceDepotId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showAirForceUnitDepotJsp";
		try{
			map = pharmacyMasterHandlerService.showAirForceUnitDepotJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=AIR_FORCE_UNIT_DEPOT_JSP;
		title="delete AirForceUnitDepot";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
//	--------------------Item Conversion Report-------------------------------------------------------
	

	public ModelAndView reportItemConversion(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> parameters  = new HashMap<String, Object>();
		Map<String, Object> map  = new HashMap<String, Object>();
		parameters=pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Item_Conversion", parameters, (Connection)parameters.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);	
			 
	}
//-----------------------Item Conversion--------------------------------------

	public ModelAndView searchItemConversion(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String itemUnitName = "";
		if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
			itemUnitName = request.getParameter(SEARCH_FIELD);
		}
		map = pharmacyMasterHandlerService.searchItemConversion(itemUnitName);

		jsp=STORE_ITEM_CONVERSION_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("itemUnitName",itemUnitName);
		return new ModelAndView("indexB", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView showItemConversionJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showItemConversionJsp();
		jsp = STORE_ITEM_CONVERSION_JSP;
		jsp+= ".jsp" ;
		title = "ItemConversion";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addItemConversion(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MasStoreItemConversion masStoreItemConversion=new MasStoreItemConversion();

		int purchaseUnitId=0;
		int intermediateUnitid=0;
		int issueUnitId=0;
		String changedBy = "";
		int conversionFactor1 = 0;
		int conversionFactor2 = 0;
		String formula= null;
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (!request.getParameter(PURCHASE_UNIT_ID).equals("0")) {
			purchaseUnitId = Integer.parseInt(request.getParameter(PURCHASE_UNIT_ID));

		}
		if (!request.getParameter(INTERMEDIATE_UNIT_ID) .equals("0")) {
			intermediateUnitid = Integer.parseInt(request.getParameter(INTERMEDIATE_UNIT_ID));
		}
		if (!request.getParameter(ISSUE_UNIT_ID).equals("0")) {
			issueUnitId = Integer.parseInt(request.getParameter(ISSUE_UNIT_ID));
		}
		if (!request.getParameter(CONVERSION_FACTOR).equals("0")) {
			try
			{
				conversionFactor1  = Integer.parseInt(request.getParameter(CONVERSION_FACTOR).trim());
			}
			catch(Exception e)
			{
				conversionFactor1  = 0;
			}
		}
		if (!request.getParameter(CONVERSION_FACTOR2).equals("0")) {
			try
			{
			conversionFactor2 = Integer.parseInt(request.getParameter(CONVERSION_FACTOR2).trim());
			}
			catch(Exception e)
			{
				conversionFactor2 = 0;
			}
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
		
		if(request.getParameter(FORMULA) != null){
			formula = request.getParameter(FORMULA); 
		}
		
		
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List itemUnitNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralNameList") != null){
			itemUnitNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((itemUnitNameList.size() == 0 || itemUnitNameList == null))
		
		{
			masStoreItemConversion.setItemUnitName(name);
			
			MasStoreUnit masStoreUnitPurchase= new MasStoreUnit();
			masStoreUnitPurchase.setId(purchaseUnitId);
			masStoreItemConversion.setPurchaseUnit(masStoreUnitPurchase);

			MasStoreUnit masStoreUnitIntermediate= new MasStoreUnit();
			masStoreUnitIntermediate.setId(intermediateUnitid);
			masStoreItemConversion.setIntermediateUnit(masStoreUnitIntermediate);

			MasStoreUnit masStoreUnitIssue= new MasStoreUnit();
			masStoreUnitIssue.setId(issueUnitId);
			masStoreItemConversion.setIssueUnit(masStoreUnitIssue);
			
			masStoreItemConversion.setConversionFactor1(conversionFactor1);
			masStoreItemConversion.setConversionFactor2(conversionFactor2);

			masStoreItemConversion.setStatus("y");
			masStoreItemConversion.setLastChgBy(changedBy);
			masStoreItemConversion.setLastChgDate(currentDate);
			masStoreItemConversion.setLastChgTime(currentTime);
			masStoreItemConversion.setFormula(formula);
			successfullyAdded = pharmacyMasterHandlerService.addItemConversion(masStoreItemConversion);		
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{				message="Try Again !!";

			}
		}
		else if((itemUnitNameList.size() != 0) || itemUnitNameList != null){
				message = "Item Unit Name  already exists.";
		}

		url = "/hms/hms/pharmacy?method=showCountryJsp";
		
		try{
			map = pharmacyMasterHandlerService.showItemConversionJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=STORE_ITEM_CONVERSION_JSP;
		title="Add Item Conversion";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editItemConversion(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		//MasStoreItemConversion masStoreItemConversion=new MasStoreItemConversion();
		int itemConversionId=0;
		int purchaseUnitId=0;
		int intermediateUnitid=0;
		int issueUnitId=0;
		String changedBy = "";
		int conversionFactor1 = 0;
		int conversionFactor2 = 0;
		Date changedDate = null;
		String changedTime = "";
		String formula = null;
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
	//	Date currentDate = new Date();

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			itemConversionId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(PURCHASE_UNIT_ID) != null) {
			purchaseUnitId = Integer.parseInt(request.getParameter(PURCHASE_UNIT_ID));

		}
		if (request.getParameter(INTERMEDIATE_UNIT_ID) != null) {
			intermediateUnitid = Integer.parseInt(request.getParameter(INTERMEDIATE_UNIT_ID));

		}
		if (request.getParameter(ISSUE_UNIT_ID) != null) {
			issueUnitId = Integer.parseInt(request.getParameter(ISSUE_UNIT_ID));

		}
		if (request.getParameter(CONVERSION_FACTOR) != null) {
			conversionFactor1  = Integer.parseInt(request.getParameter(CONVERSION_FACTOR));
		}

		if (request.getParameter(CONVERSION_FACTOR2) != null && request.getParameter(CONVERSION_FACTOR2).trim() != "") {
			conversionFactor2 = Integer.parseInt(request.getParameter(CONVERSION_FACTOR2));
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
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		if(request.getParameter(FORMULA) != null){
			formula = request.getParameter(FORMULA); 
		}
		
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		generalMap.put("id", itemConversionId);
		generalMap.put("name", name);
		generalMap.put("purchaseUnitId", purchaseUnitId);
		generalMap.put("intermediateUnitid", intermediateUnitid);
		generalMap.put("issueUnitId", issueUnitId);
		generalMap.put("conversionFactor1", conversionFactor1);
		generalMap.put("conversionFactor2", conversionFactor2);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("formula", formula);
		 generalMap.put("flag", true);

		 listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		  List existingItemConversionNameList = (List)listMap.get("duplicateMastersList");
		 
		  boolean dataUpdated=false;
		  if(existingItemConversionNameList.size() == 0)
		  {
		  
		dataUpdated=pharmacyMasterHandlerService.editItemConversionToDatabase(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant Be Updated !!";
		}}
		  else if(existingItemConversionNameList.size() > 0){
			   message = "Name already exists.";
			  }
		url = "/hms/hms/pharmacy?method=showItemConversionJsp";
		try{
			   map = pharmacyMasterHandlerService.showItemConversionJsp();
			    }catch (Exception e) {
			    	e.printStackTrace();
			    }
			    jsp=STORE_ITEM_CONVERSION_JSP;
			    title="Update Item Conversion ";
			    jsp += ".jsp";			    
			    map.put("contentJsp", jsp);
			    map.put("title", title);
			    map.put("message", message);
			    return new ModelAndView("indexB", "map", map);
	}
	
	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteItemConversion(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int itemConversionId=0;
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
			itemConversionId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deleteItemConversion(itemConversionId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showItemConversionJsp";
		try{
			map = pharmacyMasterHandlerService.showItemConversionJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=STORE_ITEM_CONVERSION_JSP;
		title="delete Item Conversion";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
//	---------------------------Mas Store Group---------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showStoreGroupJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		map = pharmacyMasterHandlerService.showStoreGroupJsp();
		jsp = STORE_GROUP_JSP;
		jsp += ".jsp";
		title = "PVMS/NIV Groups Master";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchStoreGroup(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();  
		String groupCode  = null;
		String groupName = null;
		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			groupCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			groupName = request.getParameter(SEARCH_NAME);
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
			groupCode=searchField;
			groupName=null;

		}else{
			groupCode=null;
			groupName=searchField;
		}
		map = pharmacyMasterHandlerService.searchStoreGroup(groupCode, groupName);
		jsp = STORE_GROUP_JSP;
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("groupCode",groupCode);
		map.put("groupName",groupName);
		return new ModelAndView("indexB", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addStoreGroup(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map = new HashMap<String,Object>();
		MasStoreGroup masStoreGroup = new MasStoreGroup();
		String changedBy = "";
		Map<String,Object> listMap = new HashMap<String,Object>();
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

		List groupCodeList = new ArrayList();
		List groupNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			groupCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			groupNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((groupCodeList.size() == 0 || groupCodeList == null) && (groupNameList.size() == 0 || groupNameList == null))
		{
			masStoreGroup.setGroupCode(code);
			masStoreGroup.setGroupName(name);
			masStoreGroup.setStatus("y");
			masStoreGroup.setLastChgBy(changedBy);
			masStoreGroup.setLastChgDate(currentDate);
			masStoreGroup.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService.addStoreGroup(masStoreGroup);  	 
			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((groupCodeList.size() != 0 || groupCodeList != null) || (groupNameList.size() != 0) || groupNameList != null){
			if((groupCodeList.size() != 0 || groupCodeList != null) && (groupNameList.size() == 0 || groupNameList == null)){
				message = "Group Code already exists.";	  }
			else if((groupNameList.size() != 0 || groupNameList != null) && (groupCodeList.size() == 0 || groupCodeList == null) ){
				message = "Group Name already exists.";	  }
			else if((groupCodeList.size() != 0 || groupCodeList != null) && (groupNameList.size() != 0 || groupNameList != null)){
				message = "Group Code and Relation Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showStoreGroupJsp";
		try{
			map = pharmacyMasterHandlerService.showStoreGroupJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_GROUP_JSP;
		title="Add PVMS/NIV Group";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editStoreGroup(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		String groupCode="";
		String groupName="";
		int groupId=0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			groupId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			groupCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			groupName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", groupId);
		generalMap.put("groupCode", groupCode);
		generalMap.put("name", groupName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
    	 generalMap.put("flag", true);

		  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		  List existingGroupNameList = (List)listMap.get("duplicateMastersList");
		 
		  boolean dataUpdated=false;
		  if(existingGroupNameList.size() == 0)
		  {
		  
		dataUpdated = pharmacyMasterHandlerService.editGroupToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant Be Updated !!";
		}}
		  else if(existingGroupNameList.size() > 0){

			   message = "Name already exists.";
			  }
		url = "/hms/hms/generalMaster?method=showStoreGroupJsp";
		try{
			map = pharmacyMasterHandlerService.showStoreGroupJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_GROUP_JSP;
		title="Update PVMS/NIV Groups";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteStoreGroup(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int groupId = 0;
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
			groupId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted = pharmacyMasterHandlerService.deleteStoreGroup(groupId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated Successfully !!";
		}
		else{
			message="Record is Activated Successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showStoreGroupJsp";
		try{
			map = pharmacyMasterHandlerService.showStoreGroupJsp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_GROUP_JSP;
		title="Delete PVMS/NIV Groups";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	//----------NIV Master by Dipali---
	public ModelAndView showItemNIVJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int deptId = 0;

		if (session.getAttribute("deptId") != null)
		deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
			map = pharmacyMasterHandlerService.showItemJsp(deptId,hospitalId);

		jsp = ITEM_NIV;
		jsp += ".jsp";
		title = "itemNiv";
		map.put("contentJsp",jsp);
		map.put("hospitalId", hospitalId);
		map.put("fromShowItem", "fromShowItem");
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchItemNIV(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String pvmsNo  = null;
		String nomenclature = null;
		String sectionCode = null;
		String searchField= null;
		int ItemType=0;	
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			pvmsNo = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			nomenclature = request.getParameter(SEARCH_NAME);
			}

		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);
			}
			//if(request.getParameter("sectionCode") != null && !(request.getParameter("sectionCode").equals("0"))){
			//	sectionCode = request.getParameter("sectionCode");
			//}
			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(searchRadio==1){
			pvmsNo=searchField.trim();
			nomenclature=null;
		}else if(searchRadio==2){
			pvmsNo=null;
			nomenclature=searchField.trim();
		}else{
			pvmsNo=null;
			nomenclature=null;
			sectionCode = sectionCode.trim();
		}

		if(request.getParameter("itemType")!=null){
				ItemType=Integer.parseInt(request.getParameter("itemType").toString());
			}
		map = pharmacyMasterHandlerService.searchItem(pvmsNo, nomenclature, deptId,sectionCode,hospitalId,ItemType);

		jsp=ITEM_NIV;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("pvmsNo",pvmsNo);
		map.put("hospitalId", hospitalId);
		map.put("nomenclature",nomenclature);
		return new ModelAndView("indexB", "map", map);
		
			
	}
	
	public ModelAndView addItemNIV(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		MasStoreItem masStoreItem=new MasStoreItem();
		
		int sectionId=0;
		int itemGenericId=0;
		int itemTypeId=0;
		int itemCategoryId=0;
		int itemConversionId=0;
		int groupId=0;
		int departmentId=0;
		int companyId=0;
		/*int slowMovingDays = 0;
		int fastMovingDays = 0;
		int nonMovingDays = 0;*/
		int hospitalId=0;
		
		String message = null;
		String[] brandIdArray = null;
		String sourceOfSupply="";
		String pvms="";
		String oldNivNo="";
		String pac="";
		String costPrice="";
		String rol="";
		String shelfLife="";
		String location="";
		String specification="";
		String changedBy = "";		
		String changedTime = "";
		String strength = "";
		String remarks = "";
		String brandedGeneric = "";
		Float minStock=null;
		Float maxStock=null;
		Date changedDate = null;	
		//String leadTime="";
		//	Float salesTax= null;
		//	String expiry = "";
		//String sophisticatedItem=""; 
		//	String pppItem="";
		//String allergy = "";
		//String commonName = "";
		
		Map listMap=new HashMap();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		int deptId = 0;

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		
		
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		
		/*if (request.getParameter(COMMON_NAME) != null) {
			commonName = request.getParameter(COMMON_NAME);
		}*/
		if (request.getParameter(CODE) != null) {
			pvms = request.getParameter(CODE);
		}
		if (request.getParameter(OLD_NIV_NO) != null) {
			oldNivNo = request.getParameter(OLD_NIV_NO);
		}
		if (!request.getParameter(SECTION_ID).equals("0")) {
			sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
		}
		
		if (!request.getParameter(ITEM_GENERIC_ID).equals("")) {
			itemGenericId = Integer.parseInt(request.getParameter(ITEM_GENERIC_ID));
		}
		
		StringBuffer brandStr = new StringBuffer();
		
		brandIdArray = (String[])(request.getParameterValues(BRAND_ID));
		if (brandIdArray != null && brandIdArray.length > 0)
		{
		for (int i = 0; i < brandIdArray.length; i++) 
		{
				brandStr.append(brandIdArray[i]);
				brandStr.append(",");
		}
		brandStr.deleteCharAt(brandStr.length()-1);
		}

			if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
			itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
		}
		if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
			itemCategoryId = Integer.parseInt(request.getParameter(ITEM_CATEGORY_ID));
		}
		if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
			itemConversionId = Integer.parseInt(request.getParameter(STORE_ITEM_CONVERSION_ID));
		}
		if (!request.getParameter(GROUP_ID).equals("0")) {
			groupId = Integer.parseInt(request.getParameter(GROUP_ID));
		}
	
		if (!request.getParameter(COMPANY_ID).equals("0")) {
			companyId = Integer.parseInt(request.getParameter(COMPANY_ID));
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		if (request.getParameter(BRAND_GENERIC) != null) {
			brandedGeneric = request.getParameter(BRAND_GENERIC);
		}
		String abc="";
		String ved="";
		String group123="";
		if (request.getParameter(ABC) != null ) {
			abc = request.getParameter(ABC);
		}
		if (request.getParameter(VED) != null) {
			ved = request.getParameter(VED);
		}
		if (request.getParameter(GROUP_123) != null) {
			group123 = request.getParameter(GROUP_123);
		}
		/*
		if (!request.getParameter(SUPPLIER_ID).equals("0")) {
			supplierId = Integer.parseInt(request.getParameter(SUPPLIER_ID));
		}*/
		/*if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			//System.out.println(" Inside DEPARTMENT_ID");
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}*/
		if (deptId==25) {
			departmentId=25;
	}
		else{
		 departmentId=24;
	}
		if (request.getParameter(COST_PRICE) != null) {
			costPrice = request.getParameter(COST_PRICE);
		}
		if(request.getParameter(DANGEROUS_DRUG) != null){
			masStoreItem.setDangerousDrug(request.getParameter(DANGEROUS_DRUG));
		}else{
			masStoreItem.setDangerousDrug("n");
		}
		/*if(request.getParameter(HIGH_RISK_MEDICNE) != null){
			masStoreItem.setHighRiskMedicne(request.getParameter(HIGH_RISK_MEDICNE));
		}else{
			masStoreItem.setHighRiskMedicne("n");
		}
		
		if(request.getParameter(CONTROLLED_DRUG) != null){
			masStoreItem.setControlledDrug(request.getParameter(CONTROLLED_DRUG));
		}else{
			masStoreItem.setControlledDrug("n");
		}
		if(request.getParameter(HIGH_VALUE_DRUG) != null){
			masStoreItem.setHighValueDrug(request.getParameter(HIGH_VALUE_DRUG));
		}else{
			masStoreItem.setHighValueDrug("n");
		}
		if(request.getParameter(RATE_CONTRACT_ITEM) != null){
			masStoreItem.setRateContractItem(request.getParameter(RATE_CONTRACT_ITEM));
		}else{
			masStoreItem.setRateContractItem("n");
		}
		if(request.getParameter(SALES_TAX) != null && !(request.getParameter(SALES_TAX).equals(""))){
			salesTax =  Float.parseFloat(request.getParameter(SALES_TAX));
		}*/
		if(request.getParameter(MAX_STOCK) != null && !(request.getParameter(MAX_STOCK).equals(""))){
			maxStock =  Float.parseFloat(request.getParameter(MAX_STOCK));
		}
		if(request.getParameter(MIN_STOCK) != null && !(request.getParameter(MIN_STOCK).equals(""))){
			minStock =  Float.parseFloat(request.getParameter(MIN_STOCK));
		}
		
	/*	if (request.getParameter(PAC_NON_PAC) != null) {
			pac = request.getParameter(PAC_NON_PAC);
		}*/
		if (request.getParameter(SOURCE_OF_SUPPLY) != null) {
			sourceOfSupply = request.getParameter(SOURCE_OF_SUPPLY);
		}
		if (request.getParameter(ROL) != null) {
			rol = request.getParameter(ROL);
		}
		if (request.getParameter(SHELF_LIFE) != null) {
			shelfLife = request.getParameter(SHELF_LIFE);
		}
		if (request.getParameter(LOCATION) != null) {
			location = request.getParameter(LOCATION);
		}
		if (request.getParameter(SPECIFICATION) != null) {
			specification = request.getParameter(SPECIFICATION);
		}
		
		/*if (!request.getParameter(SLOW_MOVING_DAYS).equals("")) {
			slowMovingDays = Integer.valueOf(request.getParameter(SLOW_MOVING_DAYS));
		}
		
		if (!request.getParameter(FAST_MOVING_DAYS).equals("")) {
			fastMovingDays = Integer.parseInt(request.getParameter(FAST_MOVING_DAYS));
		}
		
		if (!request.getParameter(NON_MOVING_DAYS).equals("")) {
			nonMovingDays = Integer.parseInt(request.getParameter(NON_MOVING_DAYS));
		}
		
		if (request.getParameter(EXPIRY) != null) {
			expiry = request.getParameter(EXPIRY);
		}
		
		if (request.getParameter(SOPHISTICATED_ITEM) != null) {
			sophisticatedItem = request.getParameter(SOPHISTICATED_ITEM);
		}

		if (request.getParameter("ppp_item") != null) {
			pppItem = request.getParameter("ppp_item");
		}
		
		if (request.getParameter(ALLERGY) != null) {
			allergy = request.getParameter(ALLERGY);
		}*/
		session=request.getSession();
		changedBy=(String)session.getAttribute("userName");
		int userId = (Integer)session.getAttribute("userId");
		Users user = new Users();
		user.setId(userId);
		changedDate=HMSUtil.dateFormatterDDMMYYYY((String)HMSUtil.getCurrentDateAndTime().get("currentDate"));
		changedTime=(String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		
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
			pojoPropertyCode= request.getParameter("pojoPropertyCode"); 
		}
		generalMap.put("name", name);
		generalMap.put("code", pvms);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", "");
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", null);
            
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List nomenclatureList = new  ArrayList();
		List toCheckNiv=new ArrayList();
		List toCheckNomeclature=new ArrayList();
		
		Map<String, Object> testMap = new HashMap<String, Object>();
		
		testMap.put("hospitalId", hospitalId);
		testMap.put("name",name);
		testMap.put("pvms",pvms);
		
		toCheckNiv = pharmacyMasterHandlerService.checkNivNo(testMap);
		toCheckNomeclature = pharmacyMasterHandlerService.checkNomenclature(testMap);	
		
		
		
		
		
        if(toCheckNiv.size()>0 && toCheckNomeclature.size()>0){
	    	
	    	message="NIV code and nomenclature already exists.";
	    }
	    else if(toCheckNomeclature.size()>0){
	    	message="NIV nomenclature already exists.";
	    }else if(toCheckNiv.size()>0){
	    	message="NIV code already exists.";
	    }
		
		if(listMap.get("duplicateGeneralNameList") != null){
			nomenclatureList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if((nomenclatureList == null || nomenclatureList.size() == 0))
		{
			if((toCheckNiv==null || toCheckNiv.size()==0)&& (toCheckNomeclature==null || toCheckNomeclature.size()==0) )
			{
			try{
				masStoreItem.setNomenclature(name);
			//	masStoreItem.setCommonName(commonName);
				masStoreItem.setPvmsNo(pvms);
				masStoreItem.setOldNivNo(oldNivNo);
				masStoreItem.setStrength(strength);
				masStoreItem.setAbc(abc);
				masStoreItem.setVed(ved);
				masStoreItem.setGroup123(group123);
				
			    MasHospital masHospital=new MasHospital();
				masHospital.setId(hospitalId);
				masStoreItem.setHospital(masHospital);
				
				if(sectionId != 0){
				MasStoreSection masStoreSection = new MasStoreSection();
				masStoreSection.setId(sectionId);
				masStoreItem.setSection(masStoreSection);
				}
				
				if(itemGenericId != 0){
					MasStoreItemGeneric masStoreItemGeneric = new MasStoreItemGeneric();
					masStoreItemGeneric.setId(itemGenericId);
					masStoreItem.setItemGeneric(masStoreItemGeneric);
				}
				if(companyId != 0){
					MasCompany masCompany = new MasCompany();
					masCompany.setId(companyId);
					masStoreItem.setCompany(masCompany);
				}
				//MasStoreBrand masStoreBrand = new MasStoreBrand();
				//masStoreBrand.setId(brandId);
				masStoreItem.setBrand(null);
				
				if(itemTypeId != 0){
				MasItemType masStoreItemType = new MasItemType();
				masStoreItemType.setId(itemTypeId);
				masStoreItem.setItemType(masStoreItemType);
				}
				
				if(itemCategoryId != 0){
				MasItemCategory masStoreItemCategory = new MasItemCategory();
				masStoreItemCategory.setId(itemCategoryId);
				masStoreItem.setItemCategory(masStoreItemCategory);
				}
				
				if(itemConversionId != 0){
				MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
				masStoreItemConversion.setId(itemConversionId);
				masStoreItem.setItemConversion(masStoreItemConversion);
				}
				
				if(groupId != 0){
				MasStoreGroup masStoreGroup = new MasStoreGroup();
				masStoreGroup.setId(groupId);
				masStoreItem.setGroup(masStoreGroup);
				}
				
				/*
				MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
				masStoreSupplier.setId(supplierId);
				masStoreItem.setSupplier(masStoreSupplier);
				*/
				if(departmentId != 0){
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				masStoreItem.setDepartment(masDepartment);
				}
				masStoreItem.setBrandedGeneric(brandedGeneric);
				masStoreItem.setRemarks(remarks);
				masStoreItem.setCostPrice(costPrice);
				
				masStoreItem.setRol(rol);
				masStoreItem.setSelfLife(shelfLife);
			
				masStoreItem.setSourceOfSupply(sourceOfSupply);
				masStoreItem.setMinStock(minStock);
				masStoreItem.setMaxStock(maxStock);
				masStoreItem.setPac(pac);
				/*masStoreItem.setSalesTax(salesTax);
				masStoreItem.setLeadTime(leadTime);
				masStoreItem.setSlowMovingDays(slowMovingDays);
				masStoreItem.setFastMovingDays(fastMovingDays);
				masStoreItem.setNonMovingDays(nonMovingDays);
				masStoreItem.setExpiry(expiry);*/
				masStoreItem.setLocation(location);
				masStoreItem.setSpecification(specification);
				
				/*masStoreItem.setAllergy(allergy);
				masStoreItem.setSophisticatedItem(sophisticatedItem);
				masStoreItem.setPppItem(pppItem);*/
				masStoreItem.setStatus("y");
				masStoreItem.setLastChgBy(user);
				masStoreItem.setLastChgDate(changedDate);
				masStoreItem.setLastChgTime(changedTime);
			}catch (Exception e) {
				e.printStackTrace();
			}
			successfullyAdded = pharmacyMasterHandlerService.addItem(masStoreItem);
			if(successfullyAdded == true){
				message="Record Added Successfully !!";
			}else{
				message = "Try Again !!";
			}
				
		}else{
			message =message;
		}
		}else if(nomenclatureList.size() != 0){
			message = "NIV already exists.";
		}
		try{
			map = pharmacyMasterHandlerService.showItemJsp(deptId,hospitalId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp= ITEM_NIV;
		title="Add Item ";
		jsp += ".jsp";
		map.put("pvms",pvms);
		map.put("nomenclature", name);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView editItemNIV(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session=request.getSession();
		
		Date changedDate = null;
		int itemId=0;
		int sectionId=0;
		int itemGenericId=0;
		int itemTypeId=0;
		int itemCategoryId=0;
		int itemConversionId=0;
		int departmentId=0;
		int brandId=0;
		int groupId=0;
		int slowMovingDays = 0;
		int fastMovingDays = 0;
		int nonMovingDays = 0;
		int hospitalId = 0;
		
		Float minStock=null;
		Float maxStock=null;
		Float salesTax= null;
		
		String pvms="";
		String oldNivNo="";
		String pac="";
		String sourceOfSupply="";
		String costPrice="";
		String dangerousDrug="n";
		String highRiskMedicne="n";
		String controlledDrug="n";
		String highValueDrug="n";
		String rateContractItem="n";
		String rol="";
		String shelfLife="";
		String leadTime="";
		String location="";
		String specification="";
		String changedBy = "";
		String changedTime = "";
		String nomenclature="";
		String expiry = "";
		String sophisticatedItem="";
		String pppItem="";
		String allergy = "";
		String commonName = "";
		
		session = request.getSession();
		int deptId = 0;

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		String abc="";
		String ved="";
		String group123="";
		if (request.getParameter(ABC) != null ) {
			abc = request.getParameter(ABC);
		}
		if (request.getParameter(VED) != null) {
			ved = request.getParameter(VED);
		}
		if (request.getParameter(GROUP_123) != null) {
			group123 = request.getParameter(GROUP_123);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			itemId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			nomenclature = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter(COMMON_NAME) != null) {
			commonName = request.getParameter(COMMON_NAME);
		}
		if (request.getParameter(CODE) != null) {
			pvms = request.getParameter(CODE);
		}
		if (request.getParameter(OLD_NIV_NO) != null) {
			oldNivNo = request.getParameter(OLD_NIV_NO);
		}
		if (!request.getParameter(SECTION_ID).equals("0")) {
			sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
		}
		if (!"".equals(request.getParameter(ITEM_GENERIC_ID))&& request.getParameter(ITEM_GENERIC_ID)!=null) {
			itemGenericId = Integer.parseInt(request.getParameter(ITEM_GENERIC_ID));
		}
		if (request.getParameter(BRAND_ID)!=null && !request.getParameter(BRAND_ID).equals("0")) {
			//brandId = Integer.parseInt(request.getParameter(BRAND_ID));
			brandId = 0;
		}
		
		if (!request.getParameter(GROUP_ID).equals("0")) {
			groupId = Integer.parseInt(request.getParameter(GROUP_ID));
		}
		if (!request.getParameter(HOSPITAL_ID).equals("0")) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}
		
		if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
			itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
		}
		if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
			itemCategoryId = Integer.parseInt(request.getParameter(ITEM_CATEGORY_ID));
		}
		if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
			itemConversionId = Integer.parseInt(request.getParameter(STORE_ITEM_CONVERSION_ID));
		}
		/*if (!request.getParameter(MANUFACTURER_ID).equals("0")) {
			manufacturerId = Integer.parseInt(request.getParameter(MANUFACTURER_ID));
		}*/
		/*if (!request.getParameter(SUPPLIER_ID).equals("0")) {
			supplierId = Integer.parseInt(request.getParameter(SUPPLIER_ID));
		}*/
		if(deptId==25)
			departmentId = 25;
		else 	departmentId = 24;
		
		if (request.getParameter(COST_PRICE) != null) {
			costPrice = request.getParameter(COST_PRICE);
		}
		if(request.getParameter(DANGEROUS_DRUG) != null){
			dangerousDrug = (request.getParameter(DANGEROUS_DRUG));
		}
		else
		{
			dangerousDrug = "n";
		}
		if(request.getParameter(HIGH_RISK_MEDICNE) != null){
			highRiskMedicne = (request.getParameter(HIGH_RISK_MEDICNE));
		}
		else
		{
			highRiskMedicne = "n";
		}
		
		if (request.getParameter(CONTROLLED_DRUG) != null){
			controlledDrug = request.getParameter(CONTROLLED_DRUG);
		}else{
			controlledDrug = "n";
		}
		if (request.getParameter(HIGH_VALUE_DRUG) != null){
			highValueDrug = request.getParameter(HIGH_VALUE_DRUG);
		}else{
			highValueDrug = "n";
		}
		if (request.getParameter(RATE_CONTRACT_ITEM) != null){
			rateContractItem = request.getParameter(RATE_CONTRACT_ITEM);
		}else{
			rateContractItem = "n";
		}
		if(request.getParameter(SALES_TAX) != null && !(request.getParameter(SALES_TAX).equals(""))){
			salesTax =  Float.parseFloat(request.getParameter(SALES_TAX));
		}
		if(request.getParameter(MAX_STOCK) != null && !(request.getParameter(MAX_STOCK).equals(""))){
			maxStock =  Float.parseFloat(request.getParameter(MAX_STOCK));
		}
		if(request.getParameter(MIN_STOCK) != null && !(request.getParameter(MIN_STOCK).equals(""))){
			minStock =  Float.parseFloat(request.getParameter(MIN_STOCK));
		}
		if (request.getParameter(SOURCE_OF_SUPPLY) != null) {
			sourceOfSupply = request.getParameter(SOURCE_OF_SUPPLY);
		}
		if (request.getParameter(LEAD_TIME) != null) {
			leadTime = request.getParameter(LEAD_TIME);
		}
		if (request.getParameter(PAC) != null) {
			pac = request.getParameter(PAC);
		}
		if (request.getParameter(ROL) != null) {
			rol = request.getParameter(ROL);
		}
		if (request.getParameter(SHELF_LIFE) != null) {
			shelfLife = request.getParameter(SHELF_LIFE);
		}
		if (request.getParameter(LEAD_TIME) != null) {
			leadTime = request.getParameter(LEAD_TIME);
		}
		if (request.getParameter(LOCATION) != null) {
			location = request.getParameter(LOCATION);
		}
		if (request.getParameter(SPECIFICATION) != null) {
			specification = request.getParameter(SPECIFICATION);
		}
		if (request.getParameter(SLOW_MOVING_DAYS) != null  && !request.getParameter(SLOW_MOVING_DAYS).equals("")) {
			slowMovingDays = Integer.valueOf(request.getParameter(SLOW_MOVING_DAYS));
		}
		if (request.getParameter(FAST_MOVING_DAYS) != null  && !request.getParameter(FAST_MOVING_DAYS).equals("")) {
			fastMovingDays = Integer.parseInt(request.getParameter(FAST_MOVING_DAYS));
		}
		if (request.getParameter(NON_MOVING_DAYS) != null && !request.getParameter(NON_MOVING_DAYS).equals("")) {
			nonMovingDays = Integer.parseInt(request.getParameter(NON_MOVING_DAYS));
		}
		if (request.getParameter(EXPIRY) != null) {
			expiry = request.getParameter(EXPIRY);
		}
		/*if (request.getParameter(ALLERGY) != null) {
			allergy = request.getParameter(ALLERGY);
		}
		
		if (request.getParameter(SOPHISTICATED_ITEM) != null) {
			sophisticatedItem = request.getParameter(SOPHISTICATED_ITEM);
		}
		
		if (request.getParameter("ppp_item") != null) {
			pppItem = request.getParameter("ppp_item");
		}*/
			session=request.getSession();
			
			if(session.getAttribute("userName")!=null){
				changedBy=(String)session.getAttribute("userName");
			}

		
//		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
//			changedBy = request.getParameter(CHANGED_BY);
//		}
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

		generalMap.put("id", itemId);
		generalMap.put("abc", abc);
		generalMap.put("ved", ved);
		generalMap.put("group123", group123);
		generalMap.put("name", nomenclature);
		generalMap.put("sectionId", sectionId);
		generalMap.put("oldNivNo",oldNivNo);
		generalMap.put("pvms",pvms);
		generalMap.put("itemGenericId",itemGenericId);
		generalMap.put("brandId",brandId);
		generalMap.put("itemTypeId",itemTypeId);
		generalMap.put("itemCategoryId",itemCategoryId);
		generalMap.put("itemConversionId",itemConversionId);
		/*generalMap.put("manufacturerId",manufacturerId);
		generalMap.put("supplierId",supplierId);*/
		generalMap.put("departmentId",departmentId);
		generalMap.put("maxStock",maxStock);
		generalMap.put("minStock",minStock);
		generalMap.put("pac",pac);
		generalMap.put("costPrice",costPrice);
		generalMap.put("dangerousDrug",dangerousDrug);
		generalMap.put("highRiskMedicne", highRiskMedicne);
		generalMap.put("controlledDrug",controlledDrug);
		generalMap.put("highValueDrug",highValueDrug);
		generalMap.put("rateContractItem",rateContractItem);
		generalMap.put("salesTax",salesTax);
		generalMap.put("rol",rol);
		generalMap.put("shelfLife",shelfLife);
		generalMap.put("sourceOfSupply",sourceOfSupply);
		generalMap.put("leadTime",leadTime);
		generalMap.put("location",location);
		generalMap.put("specification",specification);
		generalMap.put("groupId", groupId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("expiry", expiry);
		generalMap.put("allergy", allergy);
		generalMap.put("sophisticatedItem",sophisticatedItem);
		generalMap.put("pppItem",pppItem);
		generalMap.put("slowMovingDays", slowMovingDays);
		generalMap.put("fastMovingDays", fastMovingDays);
		generalMap.put("nonMovingDays", nonMovingDays);
		
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("commonName", commonName);

		boolean dataUpdated=false;

		dataUpdated=pharmacyMasterHandlerService.editItem(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";

		}
		else{
			message="Record Cant be updated !!";
		}
		try{
			map = pharmacyMasterHandlerService.showItemJsp(deptId,hospitalId);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp= ITEM_NIV;
		title="Edit Item ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}
	
	public ModelAndView deleteItemNIV(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int itemId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		session = request.getSession();
		int deptId = 0;
		int hospitalId=0;

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		
		
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		
		
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			itemId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=pharmacyMasterHandlerService.deleteItem(itemId,generalMap);

		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showItemNIVJsp";
		try{
			map = pharmacyMasterHandlerService.showItemJsp(deptId,hospitalId);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp= ITEM_NIV;
		title="Delete Item ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	public ModelAndView generateMedicineMasterReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		session = request.getSession();

		int hospitalId = 0;
		String hospitalName = "";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = pharmacyMasterHandlerService.getHospitalName(hospitalId);
			parameters.put("HOSP_NAME", hospitalName);
		}
		detailsMap = pharmacyMasterHandlerService.getConnectionForReport();
				HMSUtil.generateReport("Picons_Item_master", parameters,
						(Connection) detailsMap.get("con"), response,
						getServletContext());
		return null;

	}
	public ModelAndView generateMedicineMasterCIVReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		session = request.getSession();

		int hospitalId = 0;
		String hospitalName = "";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = pharmacyMasterHandlerService.getHospitalName(hospitalId);
			parameters.put("HOSP_NAME", hospitalName);
			parameters.put("hospitalId",hospitalId);
		}
		detailsMap = pharmacyMasterHandlerService.getConnectionForReport();
				HMSUtil.generateReport("Picons_Item_civ_master", parameters,
						(Connection) detailsMap.get("con"), response,
						getServletContext());
		return null;

	}
	public ModelAndView generatePVMSExcel(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		int deptId = 0;
		String hospitalName = "";
		String deptName = "";

		session = request.getSession();
		try {

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				hospitalName = pharmacyMasterHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				requestParameters.put("hospitalId", hospitalId);
			}

			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
				requestParameters.put("deptId", deptId);
			}

			if (session.getAttribute("deptName") != null) {
				deptName = session.getAttribute("deptName").toString();
				requestParameters.put("deptName", deptName);
			}

			String userHome = getServletContext().getRealPath("");	         
	        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
	        requestParameters.put("path", imagePath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		HSSFWorkbook wb = new HSSFWorkbook();
		HttpSession session = request.getSession(true);

		try {
			map = pharmacyMasterHandlerService.generatePVMSExcel(requestParameters);
			
			
			if(map.get("wb") != null){
			wb = (HSSFWorkbook) map.get("wb");
			String file = "pvmsMaster.xls";
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename="
					+ file);
			wb.write(response.getOutputStream());
			}	
		} catch (IOException ioe) {
			ioe.printStackTrace();

		}
		return null;
	}
//--------------------------------------------------------------------
	
//	---------------------------Ashutosh MASTER----------------------------------------------
	public ModelAndView showSubSectionJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int deptId = 0;
		int hospitalId=0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		map = pharmacyMasterHandlerService.showItemJsp(deptId,hospitalId);
		jsp = SUB_SECTION_JSP;
		jsp += ".jsp";
		title = "Sub Item";
		map.put("contentJsp",jsp);
		map.put("fromShowItem", "fromShowItem");
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	  }	
	
	//----------------------------Financial Master---------------------------------	
	@SuppressWarnings("unchecked")
	public ModelAndView showRepairStationJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		
		int hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		dataMap.put("hospitalId", hospitalId);
		map = pharmacyMasterHandlerService.showRepairStationJsp(dataMap);
		jsp = "repairStation";
		jsp+= ".jsp" ;
		title = "Repair Station";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}
	
/************************** For Add Repair Station **********************************/
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView addRepairStation(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> dataMap=new HashMap<String,Object>();
		MasRepairStation masRepairStation=new MasRepairStation();
		String changedBy = "";
		String repairStationName = "";
		String repairStationCode = "";
		String pojoName="";
		int hospitalId=0;
		session = request.getSession();
		
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));

		if(request.getParameter(NAME) != null && !(request.getParameter(NAME).equals(""))){
			repairStationName = request.getParameter(NAME);
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			repairStationCode = request.getParameter(CODE);
		}
		
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		dataMap.put("hospitalId", hospitalId);
		generalMap.put("repairStationName", repairStationName);
		generalMap.put("repairStationCode", repairStationCode);

		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List startDateList = new ArrayList();
		List endDateList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			startDateList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			endDateList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if((startDateList.size() == 0 || startDateList == null) && (endDateList.size() == 0 || endDateList == null))
		{
			masRepairStation.setStationCode(repairStationCode);
			masRepairStation.setStationName(repairStationName);
			masRepairStation.setStatus("y");
			MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			masRepairStation.setHospital(masHospital);
			successfullyAdded = pharmacyMasterHandlerService.addRepairStation(masRepairStation);  

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}		
		}

		else if((startDateList.size() != 0 || startDateList != null) || (endDateList.size() != 0) || endDateList != null)
		{
			if((startDateList.size() != 0 || startDateList != null) && (endDateList.size() == 0 || endDateList == null)){
				message = "Start Date  already exists.";
			}
			else if((endDateList.size() != 0 || endDateList != null) && (startDateList.size() == 0 || startDateList == null) ){
				message = "End Date already exists.";	   }
			else if((startDateList.size() != 0 || startDateList != null) && (endDateList.size() != 0 || endDateList != null)){
				message = "Start Date and End Date already exist.";
			}
		}
		url = "/hms/hms/pharmacy?method=showFinancialJsp";
		 try{
				map = pharmacyMasterHandlerService.showRepairStationJsp(dataMap);
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    jsp="repairStation";
		    title="Add Financial";
		    jsp += ".jsp";		    
		    map.put("contentJsp", jsp);
		    map.put("title", title);
		    map.put("message", message);
		    return new ModelAndView("indexB", "map", map);
	}
	
	
	
	
	
	@SuppressWarnings("unused")
	public ModelAndView editRepairStation(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session=request.getSession();
		int financialId=0;
		String repairStationName = "";
		String repairStationCode = "";
		String pojoName="";
		int hospitalId=0;
		session = request.getSession();
		String changedBy = "";
		
		Date changedDate = null;
		String changedTime = "";
		
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));

		if(request.getParameter(NAME) != null && !(request.getParameter(NAME).equals(""))){
			repairStationName = request.getParameter(NAME);
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			repairStationCode = request.getParameter(CODE);
		}
		
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			financialId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 	 }
		dataMap.put("hospitalId", hospitalId);
		generalMap.put("id", financialId);
		generalMap.put("repairStationCode", repairStationCode);
		generalMap.put("repairStationName",repairStationName);
		
		
		
		boolean dataUpdated=false;

		dataUpdated=pharmacyMasterHandlerService.editRepairStation(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showFinancialJsp";
		try{
			map = pharmacyMasterHandlerService.showRepairStationJsp(dataMap);
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="repairStation";
		title="Update Financial";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	public ModelAndView deleteRepairStation(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session=request.getSession();
		int financialId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		int hospitalId=0;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			financialId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
		dataMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=pharmacyMasterHandlerService.deleteRepairStation(financialId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated Successfully !!";
		}
		else{
			message="Record is Activated Successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showFinancialJsp";
		try{
			map = pharmacyMasterHandlerService.showRepairStationJsp(dataMap);
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=FINANCIAL_JSP;
		title="Delete Fianancial";
		jsp += ".jsp";		    
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	
	//---------------------------Budget Code----------------------------
		 @SuppressWarnings("unchecked")
			public ModelAndView showBudgetCodeJsp(HttpServletRequest request,HttpServletResponse response)
			{
				Map<String, Object> map = new HashMap<String, Object>();
				session = request.getSession();
				map = pharmacyMasterHandlerService.showBudgetCodeJsp();
			/*	List<MasBudgetCode> searchBudgetCodeList = new ArrayList<MasBudgetCode>();
				if(map.get("searchBudgetCodeList")!=null)
					searchBudgetCodeList = (ArrayList)map.get("searchBudgetCodeList");*/
				jsp = "budgetCode";
			    jsp+= ".jsp" ;
				title = "budgetCode";
				map.put("contentJsp",jsp);
				map.put("title", title);
				return new ModelAndView("indexB", "map", map);		 
			}

			public ModelAndView searchBudgetCode(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
			{
				Map<String, Object> map= new HashMap<String, Object>();  
				String budgetCodeCode  = null;
				String budgetCodeName = null;
				String searchField= null;

				if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
					budgetCodeCode = request.getParameter(CODE);
				}
				if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
					budgetCodeName = request.getParameter(SEARCH_NAME);
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
					budgetCodeCode=searchField;
					budgetCodeName=null;
				}else{
					budgetCodeCode=null;
					budgetCodeName=searchField;
				}
				map = pharmacyMasterHandlerService.searchBudgetCode(budgetCodeCode, budgetCodeName);
				jsp="budgetCode";
				jsp += ".jsp";
				map.put("search", "search");
				map.put("contentJsp",jsp);
				map.put("title", title);
				map.put("budgetCodeCode",budgetCodeCode);
				map.put("budgetCodeName",budgetCodeName);
				return new ModelAndView("indexB", "map", map);
			}

			
			@SuppressWarnings("unchecked")
			public ModelAndView addBudgetCode(HttpServletRequest request, HttpServletResponse response) 
			{
				Map<String,Object> map=new HashMap<String,Object>();
				MasBudgetCode masBudgetCode=new MasBudgetCode();
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
				List budgetCodeCodeList = new ArrayList();
				List budgetCodeNameList = new  ArrayList();

				if(listMap.get("duplicateGeneralCodeList") != null){
					budgetCodeCodeList = (List)listMap.get("duplicateGeneralCodeList");
				}
				if(listMap.get("duplicateGeneralNameList") != null){
					budgetCodeNameList = (List)listMap.get("duplicateGeneralNameList");
				}
				boolean successfullyAdded = false;
				if((budgetCodeCodeList.size() == 0 || budgetCodeCodeList == null) && (budgetCodeNameList.size() == 0 || budgetCodeNameList == null))
				{
					masBudgetCode.setBudgetCodeCode(code);
					masBudgetCode.setBudgetCodeName(name);
					masBudgetCode.setStatus("y");
					masBudgetCode.setLastChangeBy(changedBy);
					masBudgetCode.setLastChangeDate(currentDate);
					masBudgetCode.setLastChangeTime(currentTime);
					successfullyAdded = pharmacyMasterHandlerService.addBudgetCode(masBudgetCode); 
					
					if(successfullyAdded)
					{
						message="Record Added Successfully !!";
					}
					else
					{
						message="Try Again !!";
					}
				}
				else if((budgetCodeCodeList.size() != 0 || budgetCodeCodeList != null) || (budgetCodeNameList.size() != 0) || budgetCodeNameList != null)
				{
					if((budgetCodeCodeList.size() != 0 || budgetCodeCodeList != null) && (budgetCodeNameList.size() == 0 || budgetCodeNameList == null))
					{
						message = "Budget Code  already exists.";
					}
					else if((budgetCodeNameList.size() != 0 || budgetCodeNameList != null) && (budgetCodeCodeList.size() == 0 || budgetCodeCodeList == null) ){
						message = "Budget Code name already exists.";
					}
					else if((budgetCodeCodeList.size() != 0 || budgetCodeCodeList != null) && (budgetCodeNameList.size() != 0 || budgetCodeNameList != null)){
						message = "Budget Code and Budget code name already exist.";
					}
				
				}
				url = "/hms/hms/personnel?method=showBudgetCodeJsp";
				try{
					   map = pharmacyMasterHandlerService.showBudgetCodeJsp();
					    }catch (Exception e) {
					     e.printStackTrace();
					    }
					    jsp="budgetCode";
					    title="Add Rank Category";
					    jsp += ".jsp";			    
					    map.put("contentJsp", jsp);
					    map.put("title", title);
					    map.put("message", message);
					    return new ModelAndView("indexB", "map", map);
			}

			public ModelAndView editBudgetCode(HttpServletRequest request, HttpServletResponse response) 
			{

				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();

				session=request.getSession();
				String budgetCodeCode="";
				String budgetCodeName="";
				int budgetCodeId=0;
				String changedBy = "";
				Date changedDate = null;
				String changedTime = "";
				budgetCodeCode=(String )session.getAttribute("budgetCodeCode");
				
				budgetCodeName=(String )session.getAttribute("budgetCodeName");
				if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
					budgetCodeId =Integer.parseInt( request.getParameter(COMMON_ID));
				}
				if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
					budgetCodeCode = request.getParameter(CODE);
				}
				if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
					budgetCodeName = request.getParameter(SEARCH_NAME);
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

				generalMap.put("id", budgetCodeId);
				generalMap.put("budgetCodeCode", budgetCodeCode);
				generalMap.put("name", budgetCodeName);
				generalMap.put("changedBy", changedBy);
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
				Map<String, Object> listMap = new HashMap<String, Object>();
				generalMap.put("pojoPropertyName", pojoPropertyName);
				generalMap.put("pojoName", pojoName);
		    	 generalMap.put("flag", true);

				  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
				  List existingBudgetCodeNameList = (List)listMap.get("duplicateMastersList");
				 
				  boolean dataUpdated=false;
				  if(existingBudgetCodeNameList.size() == 0)
				  {
				  
				dataUpdated=pharmacyMasterHandlerService.editBudgetCodeToDatabase(generalMap);

				if(dataUpdated==true){
					message="Data updated Successfully !!";
				}
				else{
					message="Data Cant Be Updated !!";
				}}
				  else if(existingBudgetCodeNameList.size() > 0){
					   message = "Name already exists.";
					  }
				url = "/hms/hms/personnel?method=showBudgetCodeJsp";
				try{
					map = pharmacyMasterHandlerService.showBudgetCodeJsp();
				}catch (Exception e) {
					e.printStackTrace();
				}
				jsp="budgetCode";
				title="update BudgetCode";
				jsp += ".jsp";		    
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("indexB", "map", map);
				 
			}

			public ModelAndView deleteBudgetCode(HttpServletRequest request, HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				int budgetCodeId=0;
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
					budgetCodeId =Integer.parseInt( request.getParameter(COMMON_ID));
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
				dataDeleted=pharmacyMasterHandlerService.deleteBudgetCode(budgetCodeId,generalMap);
				if (dataDeleted==true)
				{
					message="Record is InActivated Successfully !!";
				}
				else{
					message="Record is Activated Successfully !!";
				}
				url = "/hms/hms/personnel?method=showBudgetCodeJsp";
				try{
					   map = pharmacyMasterHandlerService.showBudgetCodeJsp();
					    }catch (Exception e) {
					    e.printStackTrace();
					    }
					    jsp="budgetCode";
					    title="Delete Rank Category";
					    jsp += ".jsp";		    
					    map.put("contentJsp", jsp);
					    map.put("title", title);
					    map.put("message", message);
					    return new ModelAndView("indexB", "map", map);
			}

			
			public ModelAndView getItemTypeGLList(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				int group = 0;
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("group") != null) {
					group = Integer.parseInt(request.getParameter("group"));
				}
				dataMap.put("group", group);
				map = pharmacyMasterHandlerService.getItemTypeGLList(dataMap);

				jsp = "responseItemTypeGL";


				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView(jsp, "map", map);
			}

			 
			 public ModelAndView getSectionGLList(HttpServletRequest request, HttpServletResponse response) {
				 	Map<String, Object> map = new HashMap<String, Object>();
					int itemType = 0;
					try {
						Map<String, Object> dataMap = new HashMap<String, Object>();
						if (request.getParameter("itemType") != null) {
							itemType = Integer.parseInt(request.getParameter("itemType"));
						}
						dataMap.put("itemType", itemType);
						map = pharmacyMasterHandlerService.getSectionGLList(dataMap);
						jsp = "responseSectionGL";
					} catch (Exception e) {
						e.printStackTrace();
					}
					map.put("contentJsp", jsp);
					return new ModelAndView(jsp, "map", map);
				}
			 public ModelAndView getCategoryList(HttpServletRequest request,
						HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					int section = 0;
					try {
						Box box = HMSUtil.getBox(request);
						if (request.getParameter("section") != null) {
							section = Integer.parseInt(request.getParameter("section"));
						}
						box.put("section", section);
					map =pharmacyMasterHandlerService.getCategoryList(box);
						jsp = "responseForCategoryGL";
					} catch (Exception e) {
						e.printStackTrace();
					}
					map.put("contentJsp", jsp);
					return new ModelAndView(jsp, "map", map);
				}
			 

			 //--------------------------------------Item Class-------------------
				@SuppressWarnings("unchecked")
			   public ModelAndView showItemClassJsp(HttpServletRequest request,HttpServletResponse response) { 
					session = request.getSession();
					map = pharmacyMasterHandlerService.showItemClassJsp();
					jsp =ITEM_CLASS_JSP; 
					jsp += ".jsp"; 
					title = "itemClass";
				  map.put("contentJsp",jsp); 
				  map.put("title", title); 
				  return new ModelAndView("index", "map", map);
				  }

			  
			  public ModelAndView searchItemClass(HttpServletRequest request,
						HttpServletResponse response) throws ServletRequestBindingException {
					Map<String, Object> map = new HashMap<String, Object>();
					String itemClassCode = null;
				    String itemClassName = null; 
					String searchField = null;

					if (request.getParameter(CODE) != null
							&& !(request.getParameter(CODE).equals(""))) {
						itemClassCode = request.getParameter(CODE);
					}
					if (request.getParameter(SEARCH_NAME) != null
							&& !(request.getParameter(SEARCH_NAME).equals(""))) {
						itemClassName = request.getParameter(SEARCH_NAME);
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
						itemClassCode = searchField;
						itemClassName = null;
					} else {
						itemClassCode = null;
						itemClassName = searchField;
					}
					map = pharmacyMasterHandlerService.searchItemClass(itemClassCode,
							itemClassName);
					jsp = ITEM_CLASS_JSP;
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("search", "search");
					map.put("itemClassCode", itemClassCode);
					map.put("itemClassName", itemClassName);
					return new ModelAndView("index", "map", map);
				}
			 
			 
			  public ModelAndView addItemClass(HttpServletRequest request,
						HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					MasItemClass masStoreItemClass=new MasItemClass();
					String changedBy = "";
					Map<String, Object> listMap = new HashMap<String, Object>();
					Map<String, Object> generalMap = new HashMap<String, Object>();
					Date currentDate = new Date();
					int userId = 0;
					int sectionId = 0;
					HttpSession session = request.getSession();
					if (session.getAttribute("userId") != null){
						userId = Integer.parseInt(session.getAttribute("userId").toString());
						System.out.println("userId------"+userId);
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
					generalMap.put("currentDate", currentDate);
					generalMap.put("currentTime", currentTime);
					generalMap.put("pojoPropertyName", pojoPropertyName);
					generalMap.put("pojoPropertyCode", pojoPropertyCode);
					generalMap.put("pojoName", pojoName);

					listMap = commonMasterHandlerService
							.checkForExistingMasters(generalMap);

					  List itemClassCodeList = new ArrayList();
					  List itemClassNameList = new ArrayList();
					if (listMap.get("duplicateGeneralCodeList") != null) {
						itemClassCodeList = (List) listMap.get("duplicateGeneralCodeList");
					}
					if (listMap.get("duplicateGeneralNameList") != null) {
						itemClassNameList = (List) listMap.get("duplicateGeneralNameList");
					}
					boolean successfullyAdded = false;

					 if((itemClassCodeList.size() == 0 || itemClassCodeList == null) &&
							  (itemClassNameList.size() == 0 || itemClassNameList == null)) {
							  masStoreItemClass.setItemClassCode(code);
							  masStoreItemClass.setItemClassName(name);
							  
							  Users users = new Users();
							  users.setId(userId);
							  masStoreItemClass.setLastChgBy(users);
							  
							  masStoreItemClass.setStatus("y");
							  masStoreItemClass.setLastChgDate(currentDate);
							  MasStoreSection masStoreSection = new MasStoreSection();
							  masStoreSection.setId(sectionId);
							  masStoreItemClass.setSection(masStoreSection);
							  masStoreItemClass.setLastChgTime(currentTime); 
							  successfullyAdded =  pharmacyMasterHandlerService.addItemClass(masStoreItemClass);
						if (successfullyAdded) {
							message = "Record Added Successfully !!";
						} else {
							message = "Try Again !!";
						}
					} else if ((itemClassCodeList.size() != 0 || itemClassCodeList != null)
							|| (itemClassNameList.size() != 0) || itemClassNameList != null) {
						if ((itemClassCodeList.size() != 0 || itemClassCodeList != null)
								&& (itemClassNameList.size() == 0 || itemClassNameList == null)) {
							message = "Item Class Code already exists.";
						} else if ((itemClassNameList.size() != 0 || itemClassNameList != null)
								&& (itemClassCodeList.size() == 0 || itemClassCodeList == null)) {
							message = "Item Class Name already exists.";
						} else if ((itemClassCodeList.size() != 0 || itemClassCodeList != null)
								&& (itemClassNameList.size() != 0 || itemClassNameList != null)) {
							message = "Item Class Code and Item Class Name already exist.";
						}
					}
					url = "/hms/hms/pharmacy?method=showItemClassJsp";
					try {
						map = pharmacyMasterHandlerService.showItemClassJsp();
					} catch (Exception e) {
						e.printStackTrace();
					}
					jsp = ITEM_CLASS_JSP;
					title = "Add Item Class";
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message", message);
					return new ModelAndView("index", "map", map);
				}
			  
			  public ModelAndView editItemClass(HttpServletRequest request,
						HttpServletResponse response) {

					Map<String, Object> map = new HashMap<String, Object>();
					Map<String, Object> generalMap = new HashMap<String, Object>();
					HttpSession session = request.getSession();
				
					String itemClassCode="";
					String itemClassName="";
					int itemClassId=0;
					int userId = 0;
					Date changedDate = null;
					String changedTime = "";
					if (session.getAttribute("userId") != null){
						userId = Integer.parseInt(session.getAttribute("userId").toString());
					}
					 int sectionId = 0;
					  itemClassCode=(String )session.getAttribute("itemClassCode");
					  itemClassName=(String )session.getAttribute("itemClassName");

					if (request.getParameter(COMMON_ID) != null
							&& !(request.getParameter(COMMON_ID).equals(""))) {
						itemClassId = Integer.parseInt(request.getParameter(COMMON_ID));
					}
					if (request.getParameter(SECTION_ID) != null
							&& !request.getParameter(SECTION_ID).equals("")) {
						sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
					}
					if (request.getParameter(CODE) != null
							&& !(request.getParameter(CODE).equals(""))) {
						itemClassCode = request.getParameter(CODE);
					}
					if (request.getParameter(SEARCH_NAME) != null
							&& !(request.getParameter(SEARCH_NAME).equals(""))) {
						itemClassName = request.getParameter(SEARCH_NAME);
					}

				/*	if (request.getParameter(CHANGED_BY) != null
							&& !(request.getParameter(CHANGED_BY).equals(""))) {
						changedBy = request.getParameter(CHANGED_BY);
					}*/
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
					generalMap.put("id", itemClassId);
					generalMap.put("sectionId", sectionId);
					generalMap.put("groupCode", itemClassCode);
					generalMap.put("name", itemClassName);
					generalMap.put("changedBy", userId);
					generalMap.put("currentDate", changedDate);
					generalMap.put("currentTime", changedTime);
					Map<String, Object> listMap = new HashMap<String, Object>();
					generalMap.put("pojoPropertyName", pojoPropertyName);
					generalMap.put("pojoName", pojoName);
					generalMap.put("flag", true);

					listMap = commonMasterHandlerService
							.checkForExistingMasters(generalMap);
					List existingItemClassNameList = (List) listMap.get("duplicateMastersList");

					boolean dataUpdated = false;
					if (existingItemClassNameList.size() == 0) {

						dataUpdated = pharmacyMasterHandlerService
								.editItemClassToDatabase(generalMap);

						if (dataUpdated == true) {
							message = "Record updated Successfully !!";
						} else {
							message = "Record Cant Be Updated !!";
						}
					} else if (existingItemClassNameList.size() > 0) {

						message = "Name already exists.";
					}
					url = "/hms/hms/generalMaster?method=showItemClassJsp";
					try {
						map = pharmacyMasterHandlerService.showItemClassJsp();
					} catch (Exception e) {
						e.printStackTrace();
					}
					jsp=ITEM_CLASS_JSP;
				    title="Edit Item Class";
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message", message);
					return new ModelAndView("index", "map", map);

				}
			 
			  public ModelAndView deleteItemClass(HttpServletRequest request, HttpServletResponse response) {
				 Map<String, Object> map = new HashMap<String, Object>();
				 int ItemClassId=0;
				 String message=null;
				 int userId = 0;
				 String changedTime = "";
				 Date changedDate = null;
				 HttpSession session = request.getSession();
				 if (session.getAttribute("userId") != null){
						userId = Integer.parseInt(session.getAttribute("userId").toString());
					}
			  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				  ItemClassId = Integer.parseInt( request.getParameter(COMMON_ID));
				  }
			  if(request.getParameter("title") != null){
				  title = request.getParameter("title");
				  } 
			 /* if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				  changedBy = request.getParameter(CHANGED_BY); 
				  } */
			  	changedDate= new Date();
				  changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			 
				  generalMap.put("changedBy", userId);
				  generalMap.put("currentDate",changedDate); 
				  generalMap.put("currentTime", changedTime);
				  boolean dataDeleted=false;
			   dataDeleted=pharmacyMasterHandlerService.deleteItemClass(ItemClassId,generalMap);
			   if (dataDeleted==true) {
				   message="Record is InActivated successfully !!";
				   }else{ message="Record is Activated successfully !!";
				   } 
			   url = "/hms/hms/pharmacy?method=showItemClassJsp";
			   try{
				   map = pharmacyMasterHandlerService.showItemClassJsp();
				   }catch (Exception e) {
			   }
				   jsp=ITEM_CLASS_JSP;
				   title="delete Item Class";
				   jsp += ".jsp";
				   map.put("contentJsp", jsp);
				   map.put("title", title);
				   map.put("message", message);
				   return new ModelAndView("index", "map", map); }


//				---------------------------ITEM MASTER----------------------------------------------
				public ModelAndView showItemNIPJsp(HttpServletRequest request,HttpServletResponse response)
				{
					Map<String, Object> map = new HashMap<String, Object>();
					session = request.getSession();
					int deptId = 0;
					if (session.getAttribute("deptId") != null)
					deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					map = pharmacyMasterHandlerService.showItemNIPJsp(deptId,hospitalId);
					jsp = "itemNIP";
					jsp += ".jsp";
					title = "Item";
					map.put("contentJsp",jsp);
					map.put("fromShowItem", "fromShowItem");
					map.put("title", title);
					return new ModelAndView("indexB", "map", map);
				}
				public ModelAndView showItemNIPJspForCRV(HttpServletRequest request,HttpServletResponse response)
				{
					Map<String, Object> map = new HashMap<String, Object>();
					session = request.getSession();
					int deptId = 0;
					if (session.getAttribute("deptId") != null)
						deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					map = pharmacyMasterHandlerService.showItemNIPJsp(deptId,hospitalId);
					jsp = "itemNIP";
					//jsp += ".jsp";
					title = "Item";
					map.put("contentJsp",jsp);
					map.put("fromShowItem", "fromShowItem");
					map.put("title", title);
					return new ModelAndView(jsp, "map", map);
				}

				
				public ModelAndView searchItemNIP(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
				{
					Map<String, Object> map= new HashMap<String, Object>();		
					String pvmsNo  = null;
					String nomenclature = null;
					String sectionCode = null;
					String searchField= null;
					int ItemType=0;
					int hospitalId=0;
					int deptId = 0;
					if (session.getAttribute("deptId") != null)
						deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					if (session.getAttribute("hospitalId") != null)
						hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));

					
					if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
						pvmsNo = request.getParameter(CODE);
					}
				
					if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
						nomenclature = request.getParameter(SEARCH_NAME);
						}

					int searchRadio=1;
					try{
						if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
							searchField = request.getParameter(SEARCH_FIELD);
						}
						//if(request.getParameter("sectionCode") != null && !(request.getParameter("sectionCode").equals("0"))){
						//	sectionCode = request.getParameter("sectionCode");
						//}
						if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
							searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
					if(searchRadio==1){
						pvmsNo=searchField.trim();
						nomenclature=null;
					}else if(searchRadio==2){
						pvmsNo=null;
						nomenclature=searchField.trim();
					}else{
						pvmsNo=null;
						nomenclature=null;
						sectionCode = sectionCode.trim();
					}
					
					if(request.getParameter("itemType")!=null){
						ItemType=Integer.parseInt(request.getParameter("itemType").toString());
					}
					map = pharmacyMasterHandlerService.searchItemNIP(pvmsNo, nomenclature, deptId,sectionCode,hospitalId,ItemType);

					jsp="itemNIP";

					jsp += ".jsp";
					map.put("search", "search");
					map.put("contentJsp",jsp);
					map.put("title", title);
					map.put("pvmsNo",pvmsNo);
					map.put("nomenclature",nomenclature);
					return new ModelAndView("indexB", "map", map);		
				}

				@SuppressWarnings("unchecked")
				public ModelAndView addItemNIP(HttpServletRequest request, HttpServletResponse response) 
				{
					Map<String,Object> map=new HashMap<String,Object>();
					MasStoreItem masStoreItem=new MasStoreItem();
					
					int sectionId = 0;
					int itemTypeId = 0;
					int itemCategoryId = 0;
					int itemConversionId = 0;
					int groupId = 0;
					String pvms = "";
					String commonName = "";
					Date changedDate = null;
					String changedTime = "";
					String expiry = "";
					String tempreture = "";
					Float minTempreture = null;
					Float maxTempreture = null;
					BigDecimal uomQty  = null;
					int itemClassId=0;
					String changedBy = "";
					String insulin="";
					Map listMap = new HashMap();
					Map<String, Object> generalMap = new HashMap<String, Object>();
					session = request.getSession();
					int deptId = 0;

					if (session.getAttribute("deptId") != null) {
						deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					}
					map.put("deptId", deptId);
					
					int hospitalId=0;
					if (session.getAttribute("hospitalId") != null)
						hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
					map.put("hospitalId", hospitalId);
					
					String brandedGeneric="";
					if (request.getParameter(BRAND_GENERIC) != null) {
						brandedGeneric = request.getParameter(BRAND_GENERIC);
					}
					
					int itemGenericId=0;
					
					if (!request.getParameter(GROUP_ID).equals("0")) {
						
						groupId = Integer.parseInt(request.getParameter(GROUP_ID));
					}
					if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
						
						itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
						
					}
					if (!request.getParameter(SECTION_ID).equals("0")) {
						sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
					}
					if (request.getParameter(CODE) != null) {
						pvms = request.getParameter(CODE);
					}
					if (request.getParameter(SEARCH_NAME) != null) {
						name = request.getParameter(SEARCH_NAME);
					}
					if (request.getParameter("commonName") != null) {
						commonName = request.getParameter("commonName");
					}
					if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
						
						itemConversionId = Integer.parseInt(request
								.getParameter(STORE_ITEM_CONVERSION_ID));
					}
			if (!request.getParameter(EXPIRY).equals("")) {
						
						expiry = request.getParameter(EXPIRY);
					}
					if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
						
						itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
					}
					if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
						
						itemCategoryId = Integer.parseInt(request
								.getParameter(ITEM_CATEGORY_ID));
					}
					if (request.getParameter(HIGH_VALUE_DRUG) != null) {
						masStoreItem.setHighValueDrug(request.getParameter(HIGH_VALUE_DRUG));
					} else {
						masStoreItem.setHighValueDrug("n");
					}
					String dispensingUnit = "";
					if (request.getParameter("dispensingUnit") != null && !request.getParameter("dispensingUnit").equals("")) {
						dispensingUnit = request.getParameter("dispensingUnit");
					}
					if (request.getParameter("uomQty") != null
							&& !request.getParameter("uomQty").equals("")) {
						uomQty =  new BigDecimal(request
								.getParameter("uomQty"));
					}
					if (request.getParameter(BRAND_GENERIC) != null) {
						brandedGeneric = request.getParameter(BRAND_GENERIC);
					}
					if (request.getParameter(TEMPERATURE) != null
							&& !request.getParameter(TEMPERATURE).equals("")) {
						tempreture = (request.getParameter(TEMPERATURE));
					}
					if (request.getParameter("insulin") != null
							&& !request.getParameter("insulin").equals("")) {
						insulin = (request.getParameter("insulin"));
					}
					
					if (request.getParameter("minTemperature") != null
							&& !request.getParameter("minTemperature").equals("")) {
						minTempreture =  Float.parseFloat(request
								.getParameter("minTemperature"));
					}
					if (request.getParameter("maxTemperature") != null
							&& !request.getParameter("minTemperature").equals("")) {
						maxTempreture =  Float.parseFloat(request
								.getParameter("maxTemperature"));
					}
					
					if(request.getParameter(CHANGED_BY) !=null){
						changedBy = request.getParameter(CHANGED_BY);
					}
				
					if (request.getParameter(CHANGED_DATE) != null) {
						changedDate = HMSUtil.dateFormatterDDMMYYYY(request
								.getParameter(CHANGED_DATE));
					}
					if (request.getParameter(CHANGED_TIME) != null) {
						changedTime = request.getParameter(CHANGED_TIME);
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
					
					
					int userId = 0;
					session = request.getSession();
					if (session.getAttribute("userId") != null)
						userId = Integer.parseInt("" + session.getAttribute("userId"));
					Users user = new Users();
					user.setId(userId);
					generalMap.put("name", name);
					generalMap.put("code", code);
					generalMap.put("currentDate", currentDate);
					generalMap.put("currentTime", currentTime);
					generalMap.put("pojoPropertyName", pojoPropertyName);
					generalMap.put("pojoPropertyCode", pojoPropertyCode);
					generalMap.put("pojoName", pojoName);

					listMap = commonMasterHandlerService
							.checkForExistingMasters(generalMap);
					List nomenclatureList = new ArrayList();

					if (listMap.get("duplicateGeneralNameList") != null) {
						nomenclatureList = (List) listMap.get("duplicateGeneralNameList");
					}
					boolean successfullyAdded = false;

					if ((nomenclatureList.size() == 0 || nomenclatureList == null)) {
						try {
							masStoreItem.setNomenclature(name);
							masStoreItem.setPvmsNo(pvms);
							masStoreItem.setCommonName(commonName);
							

							if (sectionId != 0) {
								MasStoreSection masStoreSection = new MasStoreSection();
								masStoreSection.setId(sectionId);
								masStoreItem.setSection(masStoreSection);
							}

							
								 MasItemClassification c = new MasItemClassification();
								 c.setId(2);
								 masStoreItem.setItemClassification(c);
							


							if (itemTypeId != 0) {
								 MasItemType masStoreItemType = new MasItemType();
								 masStoreItemType.setId(itemTypeId);
								 masStoreItem.setItemType(masStoreItemType);
							}

							if (itemCategoryId != 0) {
								MasItemCategory masStoreItemCategory = new MasItemCategory();
								masStoreItemCategory.setId(itemCategoryId);
								masStoreItem.setItemCategory(masStoreItemCategory);
							}

							if (itemConversionId != 0) {
								MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
								masStoreItemConversion.setId(itemConversionId);
								masStoreItem.setItemConversion(masStoreItemConversion);
							}

							if (groupId != 0) {
								MasStoreGroup masStoreGroup = new MasStoreGroup();
								masStoreGroup.setId(groupId);
								masStoreItem.setGroup(masStoreGroup);
							}
							
							if (itemClassId != 0) {
								 MasItemClass masItemClass = new MasItemClass();
								 masItemClass.setId(itemClassId);
								 masStoreItem.setItemClass(masItemClass);
							}

							
							
						
							if (!tempreture.equals("")) {
								masStoreItem.setTemperature(tempreture);
							}
							if (!insulin.equals("")) {
								masStoreItem.setInsulinInjection(insulin);
							}
				
							
							masStoreItem.setMaxStock(maxTempreture);
							masStoreItem.setMinStock(minTempreture);
							masStoreItem.setADispQty(uomQty);
							
							
							
									if(!dispensingUnit.equals("")){
							masStoreItem.setDispUnit(dispensingUnit);
							}
							masStoreItem.setBrandedGeneric(brandedGeneric);
							
							masStoreItem.setExpiry(expiry);
							masStoreItem.setStatus("y");
							
							masStoreItem.setLastChgBy(user);
							masStoreItem.setLastChgDate(changedDate);
							masStoreItem.setLastChgTime(changedTime);
						} catch (Exception e) {
							e.printStackTrace();
						}

						successfullyAdded = pharmacyMasterHandlerService.addItemNIP(masStoreItem);
						if (successfullyAdded == true) {
							message = "Record Added Successfully !!";
						} else {
							message = "Try Again !!";
						}

					} else if (nomenclatureList.size() != 0) {
						message = "Item Name already exists.";
					}
					try {
						map = pharmacyMasterHandlerService.showItemNIPJsp(deptId, hospitalId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				            
							
					jsp= "itemNIP";
					title="Add Item ";
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message", message);
					return new ModelAndView("indexB", "map", map);
				}

				public ModelAndView editItemNIP(HttpServletRequest request, HttpServletResponse response) 
				{
					Map<String, Object>	map = new HashMap<String, Object>();
					Map<String, Object> generalMap = new HashMap<String, Object>();
					int itemId = 0;
					
					String pvms = "";
					
					String nomenclature = "";
					int sectionId = 0;
					int itemTypeId = 0;
					int itemCategoryId = 0;
					int itemConversionId = 0;
					int groupId = 0;
					String commonName = "";
					
					Date changedDate = null;
					String changedBy = "";
					String changedTime = "";
					String highValueDrug = "n";
					
					String expiry = "";
					String tempreture = "";
					Float minTempreture  = null;
					Float maxTempreture  = null;
					BigDecimal uomQty  = null;
				String insulin="";
					int itemClassId=0;
					int deptId = 0;
					if (session.getAttribute("deptId") != null) {
						deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					}
					String brandedGeneric="";
					
					if (request.getParameter(BRAND_GENERIC) != null) {
						brandedGeneric = request.getParameter(BRAND_GENERIC);
					}
					session = request.getSession();
					if (request.getParameter(COMMON_ID) != null
							&& !(request.getParameter(COMMON_ID).equals(""))) {
						itemId = Integer.parseInt(request.getParameter(COMMON_ID));
					}
					if (request.getParameter(SEARCH_NAME) != null) {
						nomenclature = request.getParameter(SEARCH_NAME);
					}
					if (request.getParameter(CODE) != null) {
						pvms = request.getParameter(CODE);
					}
					if (request.getParameter(GROUP_ID) != null  && !request.getParameter(GROUP_ID).equals("0")) {
						
						groupId = Integer.parseInt(request.getParameter(GROUP_ID));
					}
					if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
						
						itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
						
					}
					if (!request.getParameter(SECTION_ID).equals("0")) {
						sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
					}
					
				
					if (request.getParameter("commonName") != null) {
						commonName = request.getParameter("commonName");
					}
					if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
						
						itemConversionId = Integer.parseInt(request
								.getParameter(STORE_ITEM_CONVERSION_ID));
					}
					
					if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
						
						itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
					}
					if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
						
						itemCategoryId = Integer.parseInt(request
								.getParameter(ITEM_CATEGORY_ID));
					}
					
					if (request.getParameter(HIGH_VALUE_DRUG) != null) {
						highValueDrug =request.getParameter(HIGH_VALUE_DRUG);
					} else {
						highValueDrug ="n";
					}
					
					String dispensingUnit = "";
					if (request.getParameter("dispensingUnit") != null && !request.getParameter("dispensingUnit").equals("")) {
						dispensingUnit = request.getParameter("dispensingUnit");
					}

					if (request.getParameter(EXPIRY) != null && !request.getParameter(EXPIRY).equals("")) {
						expiry = request.getParameter(EXPIRY);
					}

					
					if (request.getParameter(TEMPERATURE) != null
							&& !request.getParameter(TEMPERATURE).equals("")) {
						tempreture = (request.getParameter(TEMPERATURE));
					}
					
					if (request.getParameter("insulin") != null
					&& !request.getParameter("insulin").equals("")) {
						insulin = (request.getParameter("insulin"));
			}
					if (request.getParameter("minTemperature") != null && !request.getParameter("minTemperature").equals("")) {
						minTempreture =  Float.parseFloat(request
								.getParameter("minTemperature"));
					}
					if (request.getParameter("uomQty") != null && !request.getParameter("uomQty").equals("")) {
						uomQty =  new BigDecimal(request.getParameter("uomQty"));
					}
					
					if (request.getParameter("maxTemperature") != null
							&& !request.getParameter("maxTemperature").equals("")) {
						maxTempreture =  Float.parseFloat(request
								.getParameter("maxTemperature"));
					}

					if (request.getParameter(CHANGED_BY) != null
							&& !(request.getParameter(CHANGED_BY).equals(""))) {
						changedBy = request.getParameter(CHANGED_BY);
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
					changedTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
					
					int userId = 0;
					int hospitalId=0;
					session = request.getSession();
					if (session.getAttribute("userId") != null)
						userId = Integer.parseInt("" + session.getAttribute("userId"));
					if (session.getAttribute("hospitalId") != null) {
						hospitalId = Integer.parseInt(""
								+ session.getAttribute("hospitalId"));
					}
					generalMap.put("tempreture", tempreture);
					generalMap.put("insulin", insulin);
					generalMap.put("itemClassId", itemClassId);
					generalMap.put("id", itemId);
					generalMap.put("name", nomenclature);
					generalMap.put("sectionId", sectionId);
					generalMap.put("commonName", commonName);
					generalMap.put("pvms", pvms);
					generalMap.put("itemTypeId", itemTypeId);
					generalMap.put("itemCategoryId", itemCategoryId);
					generalMap.put("itemConversionId", itemConversionId);
					generalMap.put("minTempreture", minTempreture);
					generalMap.put("uomQty", uomQty);
					generalMap.put("maxTempreture", maxTempreture);
					
					generalMap.put("highValueDrug", highValueDrug);
					generalMap.put("dispensingUnit", dispensingUnit);
					generalMap.put("groupId", groupId);
					generalMap.put("expiry", expiry);
					generalMap.put("changedBy", changedBy);
					generalMap.put("changedDate", changedDate);
					generalMap.put("currentTime", changedTime);
					generalMap.put("userId", userId);
					generalMap.put("hospitalId", hospitalId);
					generalMap.put("brandedGeneric", brandedGeneric);
					
					
					boolean dataUpdated = false;
					dataUpdated = pharmacyMasterHandlerService.editItemNIP(generalMap);
					if (dataUpdated == true) {
						message = "Record Updated Successfully !!";
					} else {
						message = "Record Cant be updated !!";
					}
					try {
						map = pharmacyMasterHandlerService.showItemNIPJsp(deptId, hospitalId);

					} catch (Exception e) {
						e.printStackTrace();
					}
					jsp= "itemNIP";
					title="Edit Item ";
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message", message);
					return new ModelAndView("indexB", "map", map);

				}
				public ModelAndView deleteItemNIP(HttpServletRequest request, HttpServletResponse response) {

					Map<String, Object> map = new HashMap<String, Object>();
					int itemId=0;
					String message=null;
					int userId = 0;
					String changedTime = "";
					Date changedDate = null;
					String flag =""; 
					session = request.getSession();
					int deptId = 0;
					int hospitalId=0;

					if (session.getAttribute("deptId") != null)
						deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					if (session.getAttribute("hospitalId") != null)
						hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
					if (session.getAttribute("userId") != null)
						userId = Integer.parseInt("" + session.getAttribute("userId"));
					
					if(request.getParameter("flag") != null){
						flag = request.getParameter("flag"); 
						generalMap.put("flag", flag);
					}
					
					if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
						itemId =Integer.parseInt( request.getParameter(COMMON_ID));
					}
					if(request.getParameter("title") != null){
						title = request.getParameter("title"); 
					}
					
					changedDate= new Date();
					changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
					generalMap.put("userId", userId);
					generalMap.put("currentDate", changedDate);
					generalMap.put("currentTime", changedTime);
					boolean dataDeleted=false;
					dataDeleted=pharmacyMasterHandlerService.deleteItemNIP(itemId,generalMap);

					if (dataDeleted==true)
					{
						message="Record is InActivated successfully !!";
					}

					else{
						message="Record is Activated successfully !!";
					}
					url = "/hms/hms/pharmacy?method=showItemNIPJsp";
					try{
						map = pharmacyMasterHandlerService.showItemNIPJsp(deptId,hospitalId);
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					jsp= "itemNIP";
					title="Delete Item ";
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message", message);
					return new ModelAndView("indexB", "map", map);
				}
				

				public ModelAndView checkForExistingPvmsNoNIP(HttpServletRequest request, HttpServletResponse response) {

					Map<String, Object> map = new HashMap<String, Object>();
					
					String pvmsNo = "";
					String message = "";
					if(request.getParameter("pvmsNo") != null){
						pvmsNo = request.getParameter("pvmsNo");
					}
					List<MasStoreItem> existingPvmsNoList = pharmacyMasterHandlerService.checkForExistingPvmsNoNIP(pvmsNo.trim());
					
					if(existingPvmsNoList != null && existingPvmsNoList.size() > 0){
						message = "PVMS No. Already Exists. \n Check ExpendableStores / NonExpendableStores \n Please enter another no.";
						map.put("message", message);
					}
					jsp= AJAX_MESSAGE_JSP;
					
					return new ModelAndView(jsp, "map", map);
				}
				public void checkForExistingPvmsNo1NIP(HttpServletRequest request, HttpServletResponse response) {

					Map<String, Object> map = new HashMap<String, Object>();
					
					String pvmsNo = "";
					String message = "";
					if(request.getParameter("pvmsNo") != null){
						pvmsNo = request.getParameter("pvmsNo");
					}
					List<MasStoreItem> existingPvmsNoList = pharmacyMasterHandlerService.checkForExistingPvmsNoNIP(pvmsNo.trim());
					StringBuffer sb = new StringBuffer("<items><item>");
					
					if(existingPvmsNoList != null && existingPvmsNoList.size() > 0){
						sb.append("<found>true</found>");
						
					}else{
						sb.append("<found>false</found>");
					}
					sb.append("</item></items>");
					
					response.setContentType("text/xml");
					response.setHeader("Cache-Control", "no-cache");
					try{
					response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
				    response.getWriter().write(sb.toString());	
					}catch(Exception e )
					{
						e.printStackTrace();
					}
						
				}
				
				
				
				
				
				
//				---------------------------ITEM MASTER----------------------------------------------
				public ModelAndView showNonDrugJsp(HttpServletRequest request,HttpServletResponse response)
				{
					Map<String, Object> map = new HashMap<String, Object>();
					session = request.getSession();
					int deptId = 0;
					if (session.getAttribute("deptId") != null)
					deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					map = pharmacyMasterHandlerService.showNonDrugJsp(deptId,hospitalId);
					jsp = "nonDrug";
					jsp += ".jsp";
					title = "Item";
					map.put("contentJsp",jsp);
					map.put("fromShowItem", "fromShowItem");
					map.put("title", title);
					return new ModelAndView("indexB", "map", map);
				}
				public ModelAndView showNonDrugJspForCRV(HttpServletRequest request,HttpServletResponse response)
				{
					Map<String, Object> map = new HashMap<String, Object>();
					session = request.getSession();
					int deptId = 0;
					if (session.getAttribute("deptId") != null)
						deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					map = pharmacyMasterHandlerService.showNonDrugJsp(deptId,hospitalId);
					jsp = "NonDrug";
					//jsp += ".jsp";
					title = "Item";
					map.put("contentJsp",jsp);
					map.put("fromShowItem", "fromShowItem");
					map.put("title", title);
					return new ModelAndView(jsp, "map", map);
				}

				
				public ModelAndView searchNonDrug(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
				{
					Map<String, Object> map= new HashMap<String, Object>();		
					String pvmsNo  = null;
					String nomenclature = null;
					String sectionCode = null;
					String searchField= null;
					int ItemType=0;
					int hospitalId=0;
					int deptId = 0;
					if (session.getAttribute("deptId") != null)
						deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					if (session.getAttribute("hospitalId") != null)
						hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));

					
					if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
						pvmsNo = request.getParameter(CODE);
					}
				
					if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
						nomenclature = request.getParameter(SEARCH_NAME);
						}

					int searchRadio=1;
					try{
						if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
							searchField = request.getParameter(SEARCH_FIELD);
						}
						//if(request.getParameter("sectionCode") != null && !(request.getParameter("sectionCode").equals("0"))){
						//	sectionCode = request.getParameter("sectionCode");
						//}
						if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
							searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
					if(searchRadio==1){
						pvmsNo=searchField.trim();
						nomenclature=null;
					}else if(searchRadio==2){
						pvmsNo=null;
						nomenclature=searchField.trim();
					}else{
						pvmsNo=null;
						nomenclature=null;
						sectionCode = sectionCode.trim();
					}
					
					if(request.getParameter("itemType")!=null){
						ItemType=Integer.parseInt(request.getParameter("itemType").toString());
					}
					map = pharmacyMasterHandlerService.searchNonDrug(pvmsNo, nomenclature, deptId,sectionCode,hospitalId,ItemType);

					jsp="nonDrug";

					jsp += ".jsp";
					map.put("search", "search");
					map.put("contentJsp",jsp);
					map.put("title", title);
					map.put("pvmsNo",pvmsNo);
					map.put("nomenclature",nomenclature);
					return new ModelAndView("indexB", "map", map);		
				}

				@SuppressWarnings("unchecked")
				public ModelAndView addNonDrug(HttpServletRequest request, HttpServletResponse response) 
				{
					Map<String,Object> map=new HashMap<String,Object>();
					MasStoreItem masStoreItem=new MasStoreItem();
					
					int sectionId = 0;
					int itemTypeId = 0;
					int itemCategoryId = 0;
					int itemConversionId = 0;
					int groupId = 0;
					String pvms = "";
					String commonName = "";
					Date changedDate = null;
					String changedTime = "";
					/*String expiry = "";
					String tempreture = "";
					Float minTempreture = null;
					Float maxTempreture = null;*/
					BigDecimal uomQty  = null;
					int itemClassId=0;
					String changedBy = "";
					//String insulin="";
					/*String IssueFrom="";
					String prescribedFrom="";*/
					Map listMap = new HashMap();
					Map<String, Object> generalMap = new HashMap<String, Object>();
					session = request.getSession();
					int deptId = 0;

					if (session.getAttribute("deptId") != null) {
						deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					}
					map.put("deptId", deptId);
					
					int hospitalId=0;
					if (session.getAttribute("hospitalId") != null)
						hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
					map.put("hospitalId", hospitalId);
					
					String brandedGeneric="";
					if (request.getParameter(BRAND_GENERIC) != null) {
						brandedGeneric = request.getParameter(BRAND_GENERIC);
					}
					
					int itemGenericId=0;
					
					if (!request.getParameter(GROUP_ID).equals("0")) {
						
						groupId = Integer.parseInt(request.getParameter(GROUP_ID));
					}
					if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
						
						itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
						
					}
					if (!request.getParameter(SECTION_ID).equals("0")) {
						sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
					}
					if (request.getParameter(CODE) != null) {
						pvms = request.getParameter(CODE);
					}
					if (request.getParameter(SEARCH_NAME) != null) {
						name = request.getParameter(SEARCH_NAME);
					}
					if (request.getParameter("commonName") != null) {
						commonName = request.getParameter("commonName");
					}
					if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
						
						itemConversionId = Integer.parseInt(request
								.getParameter(STORE_ITEM_CONVERSION_ID));
					}
		/*	if (!request.getParameter(EXPIRY).equals("")) {
						
						expiry = request.getParameter(EXPIRY);
					}*/
					if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
						
						itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
					}
					if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
						
						itemCategoryId = Integer.parseInt(request
								.getParameter(ITEM_CATEGORY_ID));
					}
				/*	if (request.getParameter(HIGH_VALUE_DRUG) != null) {
						masStoreItem.setHighValueDrug(request.getParameter(HIGH_VALUE_DRUG));
					} else {
						masStoreItem.setHighValueDrug("n");
					}*/
					String dispensingUnit = "";
					if (request.getParameter("dispensingUnit") != null && !request.getParameter("dispensingUnit").equals("")) {
						dispensingUnit = request.getParameter("dispensingUnit");
					}
					if (request.getParameter("uomQty") != null
							&& !request.getParameter("uomQty").equals("")) {
						uomQty =  new BigDecimal(request
								.getParameter("uomQty"));
					}
					if (request.getParameter(BRAND_GENERIC) != null) {
						brandedGeneric = request.getParameter(BRAND_GENERIC);
					}
					/*if (request.getParameter(TEMPERATURE) != null
							&& !request.getParameter(TEMPERATURE).equals("")) {
						tempreture = (request.getParameter(TEMPERATURE));
					}*/
				/*	if (request.getParameter("insulin") != null
							&& !request.getParameter("insulin").equals("")) {
						insulin = (request.getParameter("insulin"));
					}*/
					
					/*if (request.getParameter("IssueFrom") != null
							&& !request.getParameter("IssueFrom").equals("")) {
						IssueFrom = (request.getParameter("IssueFrom"));
					}
					
					if (request.getParameter("prescribedFrom") != null
							&& !request.getParameter("prescribedFrom").equals("")) {
						prescribedFrom = (request.getParameter("prescribedFrom"));
					}*/
					
					/*if (request.getParameter("minTemperature") != null
							&& !request.getParameter("minTemperature").equals("")) {
						minTempreture =  Float.parseFloat(request
								.getParameter("minTemperature"));
					}
					if (request.getParameter("maxTemperature") != null
							&& !request.getParameter("minTemperature").equals("")) {
						maxTempreture =  Float.parseFloat(request
								.getParameter("maxTemperature"));
					}*/
					
					if(request.getParameter(CHANGED_BY) !=null){
						changedBy = request.getParameter(CHANGED_BY);
					}
				
					if (request.getParameter(CHANGED_DATE) != null) {
						changedDate = HMSUtil.dateFormatterDDMMYYYY(request
								.getParameter(CHANGED_DATE));
					}
					if (request.getParameter(CHANGED_TIME) != null) {
						changedTime = request.getParameter(CHANGED_TIME);
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
					
					
					int userId = 0;
					session = request.getSession();
					if (session.getAttribute("userId") != null)
						userId = Integer.parseInt("" + session.getAttribute("userId"));
					Users user = new Users();
				    user.setId(userId);
					generalMap.put("name", name);
					generalMap.put("code", code);
					generalMap.put("currentDate", currentDate);
					generalMap.put("currentTime", currentTime);
					generalMap.put("pojoPropertyName", pojoPropertyName);
					generalMap.put("pojoPropertyCode", pojoPropertyCode);
					generalMap.put("pojoName", pojoName);

					listMap = commonMasterHandlerService
							.checkForExistingMasters(generalMap);
					List nomenclatureList = new ArrayList();

					if (listMap.get("duplicateGeneralNameList") != null) {
						nomenclatureList = (List) listMap.get("duplicateGeneralNameList");
					}
					boolean successfullyAdded = false;

					if ((nomenclatureList.size() == 0 || nomenclatureList == null)) {
						try {
							masStoreItem.setNomenclature(name);
							masStoreItem.setPvmsNo(pvms);
							masStoreItem.setCommonName(commonName);
							

							if (sectionId != 0) {
								MasStoreSection masStoreSection = new MasStoreSection();
								masStoreSection.setId(sectionId);
								masStoreItem.setSection(masStoreSection);
							}

							


							if (itemTypeId != 0) {
								 MasItemType masStoreItemType = new MasItemType();
								 masStoreItemType.setId(itemTypeId);
								 masStoreItem.setItemType(masStoreItemType);
							}

							if (itemCategoryId != 0) {
								MasItemCategory masStoreItemCategory = new MasItemCategory();
								masStoreItemCategory.setId(itemCategoryId);
								masStoreItem.setItemCategory(masStoreItemCategory);
							}

							if (itemConversionId != 0) {
								MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
								masStoreItemConversion.setId(itemConversionId);
								masStoreItem.setItemConversion(masStoreItemConversion);
							}

							if (groupId != 0) {
								MasStoreGroup masStoreGroup = new MasStoreGroup();
								masStoreGroup.setId(groupId);
								masStoreItem.setGroup(masStoreGroup);
							}
							
							if (itemClassId != 0) {
								 MasItemClass masItemClass = new MasItemClass();
								 masItemClass.setId(itemClassId);
								 masStoreItem.setItemClass(masItemClass);
							}

							 MasItemClassification c = new MasItemClassification();
							 c.setId(1);
							 masStoreItem.setItemClassification(c);
						
							
						
						/*	if (!tempreture.equals("")) {
								masStoreItem.setTemperature(tempreture);
							}
							if (!insulin.equals("")) {
								masStoreItem.setInsulinInjection(insulin);
							}
							*/
							/*if (!IssueFrom.equals("")) {
								masStoreItem.setIssueFrom(IssueFrom);
							}
							else
							{
								masStoreItem.setIssueFrom("d");
							}
							if (!prescribedFrom.equals("")) {
								masStoreItem.setPrescribedFrom(prescribedFrom);
							}*/
							/*else
							{
								masStoreItem.setIssueFrom("d");
							}*/
							
				
							
						/*	masStoreItem.setMaxStock(maxTempreture);
							masStoreItem.setMinStock(minTempreture);*/
							masStoreItem.setADispQty(uomQty);
							
							
							
							if (!dispensingUnit.equals("")) {		
							masStoreItem.setDispUnit(dispensingUnit);
							}
							masStoreItem.setBrandedGeneric(brandedGeneric);
							
							/*masStoreItem.setExpiry(expiry);*/
							masStoreItem.setStatus("y");
					
							masStoreItem.setLastChgBy(user);
							masStoreItem.setLastChgDate(changedDate);
							masStoreItem.setLastChgTime(changedTime);
						} catch (Exception e) {
							e.printStackTrace();
						}

						successfullyAdded = pharmacyMasterHandlerService.addNonDrug(masStoreItem);
						if (successfullyAdded == true) {
							message = "Record Added Successfully !!";
						} else {
							message = "Try Again !!";
						}

					} else if (nomenclatureList.size() != 0) {
						message = "Item Name already exists.";
					}
					try {
						map = pharmacyMasterHandlerService.showNonDrugJsp(deptId, hospitalId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				            
							
					jsp= "nonDrug";
					title="Add Item ";
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message", message);
					return new ModelAndView("indexB", "map", map);
				}

				public ModelAndView editNonDrug(HttpServletRequest request, HttpServletResponse response) 
				{
					Map<String, Object>	map = new HashMap<String, Object>();
					Map<String, Object> generalMap = new HashMap<String, Object>();
					int itemId = 0;
					
					String pvms = "";
					
					String nomenclature = "";
					int sectionId = 0;
					int itemTypeId = 0;
					int itemCategoryId = 0;
					int itemConversionId = 0;
					int groupId = 0;
					String commonName = "";
					
					Date changedDate = null;
					String changedBy = "";
					String changedTime = "";
					/*String highValueDrug = "n";
					
					String expiry = "";
					String tempreture = "";
					Float minTempreture  = null;
					Float maxTempreture  = null;*/
					BigDecimal uomQty  = null;
			//	String insulin="";
				/*String IssueFrom="";
				String prescribedFrom ="";*/
					int itemClassId=0;
					int deptId = 0;
					if (session.getAttribute("deptId") != null) {
						deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					}
					String brandedGeneric="";
					
					if (request.getParameter(BRAND_GENERIC) != null) {
						brandedGeneric = request.getParameter(BRAND_GENERIC);
					}
					session = request.getSession();
					if (request.getParameter(COMMON_ID) != null
							&& !(request.getParameter(COMMON_ID).equals(""))) {
						itemId = Integer.parseInt(request.getParameter(COMMON_ID));
					}
					if (request.getParameter(SEARCH_NAME) != null) {
						nomenclature = request.getParameter(SEARCH_NAME);
					}
					if (request.getParameter(CODE) != null) {
						pvms = request.getParameter(CODE);
					}
					if (request.getParameter(GROUP_ID) != null  && !request.getParameter(GROUP_ID).equals("0")) {
						
						groupId = Integer.parseInt(request.getParameter(GROUP_ID));
					}
					if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
						
						itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
						
					}
					if (!request.getParameter(SECTION_ID).equals("0")) {
						sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
					}
					
				
					if (request.getParameter("commonName") != null) {
						commonName = request.getParameter("commonName");
					}
					if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
						
						itemConversionId = Integer.parseInt(request
								.getParameter(STORE_ITEM_CONVERSION_ID));
					}
					
					if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
						
						itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
					}
					if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
						
						itemCategoryId = Integer.parseInt(request
								.getParameter(ITEM_CATEGORY_ID));
					}
					
				/*	if (request.getParameter(HIGH_VALUE_DRUG) != null) {
						highValueDrug =request.getParameter(HIGH_VALUE_DRUG);
					} else {
						highValueDrug ="n";
					}
					*/
					String dispensingUnit = "";
					if (request.getParameter("dispensingUnit") != null && !request.getParameter("dispensingUnit").equals("")) {
						dispensingUnit = request.getParameter("dispensingUnit");
					}
/*
					if (request.getParameter(EXPIRY) != null && !request.getParameter(EXPIRY).equals("")) {
						expiry = request.getParameter(EXPIRY);
					}

					
					if (request.getParameter(TEMPERATURE) != null
							&& !request.getParameter(TEMPERATURE).equals("")) {
						tempreture = (request.getParameter(TEMPERATURE));
					}
					
					if (request.getParameter("insulin") != null
					&& !request.getParameter("insulin").equals("")) {
						insulin = (request.getParameter("insulin"));
			}
					if (request.getParameter("minTemperature") != null && !request.getParameter("minTemperature").equals("")) {
						minTempreture =  Float.parseFloat(request
								.getParameter("minTemperature"));
					}*/
					if (request.getParameter("uomQty") != null && !request.getParameter("uomQty").equals("")) {
						uomQty =  new BigDecimal(request.getParameter("uomQty"));
					}
					
					/*if (request.getParameter("maxTemperature") != null
							&& !request.getParameter("maxTemperature").equals("")) {
						maxTempreture =  Float.parseFloat(request
								.getParameter("maxTemperature"));
					}*/

					if (request.getParameter(CHANGED_BY) != null
							&& !(request.getParameter(CHANGED_BY).equals(""))) {
						changedBy = request.getParameter(CHANGED_BY);
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
					
				/*	if (request.getParameter("IssueFrom") != null
							&& !request.getParameter("IssueFrom").equals("")) {
						IssueFrom = (request.getParameter("IssueFrom"));
					}
					if (request.getParameter("prescribedFrom") != null
							&& !request.getParameter("prescribedFrom").equals("")) {
						prescribedFrom  = (request.getParameter("prescribedFrom"));
					}*/
					changedDate = new Date();
					changedTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
					
					int userId = 0;
					int hospitalId=0;
					session = request.getSession();
					if (session.getAttribute("userId") != null)
						userId = Integer.parseInt("" + session.getAttribute("userId"));
					if (session.getAttribute("hospitalId") != null) {
						hospitalId = Integer.parseInt(""
								+ session.getAttribute("hospitalId"));
					}
				//	generalMap.put("tempreture", tempreture);
				//	generalMap.put("insulin", insulin);
					generalMap.put("itemClassId", itemClassId);
					generalMap.put("id", itemId);
					generalMap.put("name", nomenclature);
					generalMap.put("sectionId", sectionId);
					generalMap.put("commonName", commonName);
					generalMap.put("pvms", pvms);
					generalMap.put("itemTypeId", itemTypeId);
					generalMap.put("itemCategoryId", itemCategoryId);
					generalMap.put("itemConversionId", itemConversionId);
				//	generalMap.put("minTempreture", minTempreture);
					generalMap.put("uomQty", uomQty);
				//	generalMap.put("maxTempreture", maxTempreture);
					
					//generalMap.put("highValueDrug", highValueDrug);
					generalMap.put("dispensingUnit", dispensingUnit);
					generalMap.put("groupId", groupId);
					//generalMap.put("expiry", expiry);
					generalMap.put("changedBy", changedBy);
					generalMap.put("changedDate", changedDate);
					generalMap.put("currentTime", changedTime);
					generalMap.put("userId", userId);
					generalMap.put("hospitalId", hospitalId);
					generalMap.put("brandedGeneric", brandedGeneric);
					
					/*if (!IssueFrom.equals("")) {
						generalMap.put("IssueFrom", IssueFrom);
					}
					else
					{
						generalMap.put("d", IssueFrom);
					}
					System.out.println("prescribedFrom"+prescribedFrom);
					if (!prescribedFrom.equals("")) {
						generalMap.put("prescribedFrom", prescribedFrom);
					}*/
					/*else
					{
						generalMap.put("d", IssueFrom);
					}*/
					generalMap.put("brandedGeneric", brandedGeneric);
					
					
					boolean dataUpdated = false;
					dataUpdated = pharmacyMasterHandlerService.editNonDrug(generalMap);
					if (dataUpdated == true) {
						message = "Record Updated Successfully !!";
					} else {
						message = "Record Cant be updated !!";
					}
					try {
						map = pharmacyMasterHandlerService.showNonDrugJsp(deptId, hospitalId);

					} catch (Exception e) {
						e.printStackTrace();
					}
					jsp= "nonDrug";
					title="Edit Item ";
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message", message);
					return new ModelAndView("indexB", "map", map);

				}
				public ModelAndView deleteNonDrug(HttpServletRequest request, HttpServletResponse response) {

					Map<String, Object> map = new HashMap<String, Object>();
					int itemId=0;
					String message=null;
					String changedBy = "";
					String changedTime = "";
					int userId = 0;
					Date changedDate = null;
					String flag =""; 
					session = request.getSession();
					int deptId = 0;
					int hospitalId=0;

					if (session.getAttribute("deptId") != null)
						deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					if (session.getAttribute("hospitalId") != null)
						hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
					
					if (session.getAttribute("userId") != null)
						userId = Integer.parseInt("" + session.getAttribute("userId"));
					
					if(request.getParameter("flag") != null){
						flag = request.getParameter("flag"); 
						generalMap.put("flag", flag);
					}
					
					if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
						itemId =Integer.parseInt( request.getParameter(COMMON_ID));
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
					generalMap.put("userId", userId);
					generalMap.put("currentDate", changedDate);
					generalMap.put("currentTime", changedTime);
					boolean dataDeleted=false;
					dataDeleted=pharmacyMasterHandlerService.deleteNonDrug(itemId,generalMap);

					if (dataDeleted==true)
					{
						message="Record is InActivated successfully !!";
					}

					else{
						message="Record is Activated successfully !!";
					}
					url = "/hms/hms/pharmacy?method=showNonDrugJsp";
					try{
						map = pharmacyMasterHandlerService.showNonDrugJsp(deptId,hospitalId);
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					jsp= "nonDrug";
					title="Delete Item ";
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message", message);
					return new ModelAndView("indexB", "map", map);
				}
				
				public ModelAndView checkForExistingPvmsNoNonDrug(HttpServletRequest request, HttpServletResponse response) {

					Map<String, Object> map = new HashMap<String, Object>();
					
					String pvmsNo = "";
					String message = "";
					if(request.getParameter("pvmsNo") != null){
						pvmsNo = request.getParameter("pvmsNo");
					}
					List<MasStoreItem> existingPvmsNoList = pharmacyMasterHandlerService.checkForExistingPvmsNoNonDrug(pvmsNo.trim());
					
					if(existingPvmsNoList != null && existingPvmsNoList.size() > 0){
						message = "PVMS No. Already Exists. \n Check ExpendableStores / NonExpendableStores \n Please enter another no.";
						map.put("message", message);
					}
					jsp= AJAX_MESSAGE_JSP;
					
					return new ModelAndView(jsp, "map", map);
				}
				public void checkForExistingPvmsNo1NonDrug(HttpServletRequest request, HttpServletResponse response) {

					Map<String, Object> map = new HashMap<String, Object>();
					
					String pvmsNo = "";
					String message = "";
					if(request.getParameter("pvmsNo") != null){
						pvmsNo = request.getParameter("pvmsNo");
					}
					List<MasStoreItem> existingPvmsNoList = pharmacyMasterHandlerService.checkForExistingPvmsNoNonDrug(pvmsNo.trim());
					StringBuffer sb = new StringBuffer("<items><item>");
					
					if(existingPvmsNoList != null && existingPvmsNoList.size() > 0){
						sb.append("<found>true</found>");
						
					}else{
						sb.append("<found>false</found>");
					}
					sb.append("</item></items>");
					
					response.setContentType("text/xml");
					response.setHeader("Cache-Control", "no-cache");
					try{
					response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
				    response.getWriter().write(sb.toString());	
					}catch(Exception e )
					{
						e.printStackTrace();
					}
						
				}
				
				
				
				

//				---------------------------Mas Store Group---------------------------------
				@SuppressWarnings("unchecked")
				public ModelAndView showMprPriorityJsp(HttpServletRequest request,HttpServletResponse response)
				{
					session = request.getSession();
					map = pharmacyMasterHandlerService.showMprPriorityJsp();
					jsp = "mprPriority";
					jsp += ".jsp";
					title = "Mpr Priority";
					map.put("contentJsp",jsp);
					map.put("title", title);
					return new ModelAndView("indexB", "map", map);
				}

				public ModelAndView searchMprPriority(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
				{
					Map<String, Object> map= new HashMap<String, Object>();  
					String mprPriorityCode  = null;
					String mprPriorityName = null;
					String searchField= null;

					if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
						mprPriorityCode = request.getParameter(CODE);
					}
					if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
						mprPriorityName = request.getParameter(SEARCH_NAME);
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
						mprPriorityCode=searchField;
						mprPriorityName=null;

					}else{
						mprPriorityCode=null;
						mprPriorityName=searchField;
					}
					map = pharmacyMasterHandlerService.searchMprPriority(mprPriorityCode, mprPriorityName);
					jsp = "mprPriority";
					jsp += ".jsp";
					map.put("search","search");
					map.put("contentJsp",jsp);
					map.put("title", title);
					map.put("mprPriorityCode",mprPriorityCode);
					map.put("mprPriorityName",mprPriorityName);
					return new ModelAndView("indexB", "map", map);
				}


				@SuppressWarnings("unchecked")
				public ModelAndView addMprPriority(HttpServletRequest request, HttpServletResponse response) 
				{
					Map<String,Object> map = new HashMap<String,Object>();
					MprPriority masMprPriority = new MprPriority();
					String changedBy = "";
					Map<String,Object> listMap = new HashMap<String,Object>();
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

					List mprPriorityCodeList = new ArrayList();
					List mprPriorityNameList = new  ArrayList();

					if(listMap.get("duplicateGeneralCodeList") != null){
						mprPriorityCodeList = (List)listMap.get("duplicateGeneralCodeList");
					}
					if(listMap.get("duplicateGeneralNameList") != null){
						mprPriorityNameList = (List)listMap.get("duplicateGeneralNameList");
					}
					int userId = 0;
					HttpSession session = null;
					session = request.getSession();
					if (session.getAttribute("userId") != null)
						userId = Integer.parseInt("" + session.getAttribute("userId"));
					
					boolean successfullyAdded = false;

					if((mprPriorityCodeList.size() == 0 || mprPriorityCodeList == null) && (mprPriorityNameList.size() == 0 || mprPriorityNameList == null))
					{
						masMprPriority.setPrCode(code);
						masMprPriority.setPrName(name);
						masMprPriority.setStatus("y");
						
		
						
						masMprPriority.setLastChyBy(userId);
						masMprPriority.setLastChgDate(currentDate);
						masMprPriority.setLastChgTime(currentTime);
						successfullyAdded = pharmacyMasterHandlerService.addMprPriority(masMprPriority);  	 
						if(successfullyAdded)
						{
							message="Record Added Successfully !!";
						}
						else
						{
							message="Try Again !!";
						}
					}
					else if((mprPriorityCodeList.size() != 0 || mprPriorityCodeList != null) || (mprPriorityNameList.size() != 0) || mprPriorityNameList != null){
						if((mprPriorityCodeList.size() != 0 || mprPriorityCodeList != null) && (mprPriorityNameList.size() == 0 || mprPriorityNameList == null)){
							message = "Group Code already exists.";	  }
						else if((mprPriorityNameList.size() != 0 || mprPriorityNameList != null) && (mprPriorityCodeList.size() == 0 || mprPriorityCodeList == null) ){
							message = "Group Name already exists.";	  }
						else if((mprPriorityCodeList.size() != 0 || mprPriorityCodeList != null) && (mprPriorityNameList.size() != 0 || mprPriorityNameList != null)){
							message = "Group Code and Relation Name already exist.";
						}
					}
					url = "/hms/hms/pharmacyMaster?method=showMprPriorityJsp";
					try{
						map = pharmacyMasterHandlerService.showMprPriorityJsp();
					}catch (Exception e) {
						e.printStackTrace();
					}
					jsp = "mprPriority";
					title="Add Mpr Priority";
					jsp += ".jsp";		    
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message", message);
					return new ModelAndView("indexB", "map", map);
				}

				public ModelAndView editMprPriority(HttpServletRequest request, HttpServletResponse response) 
				{

					Map<String, Object> map = new HashMap<String, Object>();
					Map<String, Object> generalMap = new HashMap<String, Object>();
					session=request.getSession();
					String mprPriorityCode="";
					String mprPriorityName="";
					int mprPriorityId=0;
					String changedBy = "";
					Date changedDate = null;
					String changedTime = "";
					
					int userId = 0;
					HttpSession session = null;
					session = request.getSession();
					if (session.getAttribute("userId") != null)
						userId = Integer.parseInt("" + session.getAttribute("userId"));
				
					if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
						mprPriorityId =Integer.parseInt( request.getParameter(COMMON_ID));
					}
					if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
						mprPriorityCode = request.getParameter(CODE);
					}
					if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
						mprPriorityName = request.getParameter(SEARCH_NAME);
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
					generalMap.put("id", mprPriorityId);
					generalMap.put("mprPriorityCode", mprPriorityCode);
					generalMap.put("name", mprPriorityName);
					generalMap.put("userId", userId);
					generalMap.put("currentDate", changedDate);
					generalMap.put("currentTime", changedTime);
					Map<String, Object> listMap = new HashMap<String, Object>();
					generalMap.put("pojoPropertyName", pojoPropertyName);
					generalMap.put("pojoName", pojoName);
			    	 generalMap.put("flag", true);

					  listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
					  List existingGroupNameList = (List)listMap.get("duplicateMastersList");
					 
					  boolean dataUpdated=false;
					  if(existingGroupNameList.size() == 0)
					  {
					  
					dataUpdated = pharmacyMasterHandlerService.editMprPriorityToDatabase(generalMap);

					if(dataUpdated==true){
						message="Data updated Successfully !!";
					}
					else{
						message="Data Cant Be Updated !!";
					}}
					  else if(existingGroupNameList.size() > 0){

						   message = "Name already exists.";
						  }
					url = "/hms/hms/pharmacyMaster?method=showMprPriorityJsp";
					try{
						map = pharmacyMasterHandlerService.showMprPriorityJsp();
					}catch (Exception e) {
						e.printStackTrace();
					}
					jsp = "mprPriority";
					title="Update Mpr Priority";
					jsp += ".jsp";		    
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message", message);
					return new ModelAndView("indexB", "map", map);

				}

				public ModelAndView deleteMprPriority(HttpServletRequest request, HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					int mprPriorityId = 0;
					String message=null;
					String changedTime = "";
					Date changedDate = null;
					int userId = 0;
					HttpSession session = null;
					session = request.getSession();
					if (session.getAttribute("userId") != null)
						userId = Integer.parseInt("" + session.getAttribute("userId"));
				
			
					String flag =""; 
					if(request.getParameter("flag") != null){
						flag = request.getParameter("flag"); 
						generalMap.put("flag", flag);
					}
					if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
						mprPriorityId =Integer.parseInt( request.getParameter(COMMON_ID));
					}
					if(request.getParameter("title") != null){
						title = request.getParameter("title"); 
					}
				
					changedDate= new Date();
					changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

					generalMap.put("userId", userId);
					generalMap.put("currentDate", changedDate);
					generalMap.put("currentTime", changedTime);
					boolean dataDeleted=false;
					dataDeleted = pharmacyMasterHandlerService.deleteMprPriority(mprPriorityId,generalMap);
					if (dataDeleted==true)
					{
						message="Record is InActivated Successfully !!";
					}
					else{
						message="Record is Activated Successfully !!";
					}
					url = "/hms/hms/pharmacyMaster?method=showMprPriorityJsp";
					try{
						map = pharmacyMasterHandlerService.showMprPriorityJsp();
					}catch (Exception e) {
						e.printStackTrace();
					}
					jsp = "mprPriority";
					title="Delete Mpr Priority";
					jsp += ".jsp";		    
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message", message);
					return new ModelAndView("indexB", "map", map);
				}
//	-------------------------------------------------------------------------	
public PharmacyMasterHandlerService getPharmacyMasterHandlerService() {
		return pharmacyMasterHandlerService;
	}
	public void setPharmacyMasterHandlerService(
			PharmacyMasterHandlerService pharmacyMasterHandlerService) {
		this.pharmacyMasterHandlerService = pharmacyMasterHandlerService;
	}
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}
	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
}






