/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * BillingController.java –
 * Purpose of the class - This is for OP Billing.
 * @author  Vishal Jain
 * Create Date: 6th Feb,2009
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/
package jkt.hms.account.controller;

import static jkt.hms.util.RequestConstants.ACCOUNT_GROUP_ID;
import static jkt.hms.util.RequestConstants.ACCOUNT_ID;
import static jkt.hms.util.RequestConstants.ACCOUNT_SUB_GROUP_ID;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DISTRICT_ID;
import static jkt.hms.util.RequestConstants.FA_ACCOUNT_GROUP_JSP;
import static jkt.hms.util.RequestConstants.FA_BANK_RECONCILIATION_JSP;
import static jkt.hms.util.RequestConstants.FA_BANK_VOUCHER_REPORT_JSP;
import static jkt.hms.util.RequestConstants.FA_CASH_VOUCHER;
import static jkt.hms.util.RequestConstants.FA_JOURNAL_VOUCHER_JSP;
import static jkt.hms.util.RequestConstants.FA_VOUCHER_REPORT_JSP;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.JASPER_FILE_NAME;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SUB_LEDGER_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.VOUCHER_DATE;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.account.handler.AccountHandlerService;
import jkt.hms.masters.business.HrInsuranceDetails;
import jkt.hms.masters.business.HrMasFinancialYear;
import jkt.hms.masters.business.HrMasInsurance;

import jkt.hms.masters.business.AccountMainTransac;
import jkt.hms.masters.business.AccountSubLedTransac;
/*import jkt.hms.masters.business.BlDispensingHeader;
import jkt.hms.masters.business.BlServiceCharges;
import jkt.hms.masters.business.DgSeedQualityInspection;*/
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasAccountGroup;
import jkt.hms.masters.business.FaMasAccountSubGroup;
import jkt.hms.masters.business.FaMasNarration;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.FaVoucherDetails;
import jkt.hms.masters.business.FaVoucherHeader;
import jkt.hms.masters.business.MasApprovalStatus;
import jkt.hms.masters.business.MasBankMaster;
/*import jkt.hms.masters.business.MasGrower;*/
import jkt.hms.masters.business.MasHospital;
/*import jkt.hms.masters.business.MasRsk;*/
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreSupplier;
/*import jkt.hms.masters.business.MktBudgetAdditionalDetails;
import jkt.hms.masters.business.MktBudgetHeader;
import jkt.hms.masters.business.ProdGrowerPayment;*/
import jkt.hms.masters.business.Users;
/*import jkt.hms.masters.business.ViewData;*/
import jkt.hms.masters.handler.MastersHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AccountController extends MultiActionController {
	AccountHandlerService accountHandlerService = null;
	MastersHandlerService mastersHandlerService=null;
/*	MarketingHandlerService marketingHandlerService = null;
	public MarketingHandlerService getMarketingHandlerService() {
		return marketingHandlerService;
	}

	public void setMarketingHandlerService(
			MarketingHandlerService marketingHandlerService) {
		this.marketingHandlerService = marketingHandlerService;
	}*/
	public MastersHandlerService getMastersHandlerService() {
		return mastersHandlerService;
	}

	public void setMastersHandlerService(MastersHandlerService mastersHandlerService) {
		this.mastersHandlerService = mastersHandlerService;
	}

	public AccountHandlerService getAccountHandlerService() {
		return accountHandlerService;
	}

	public void setAccountHandlerService(
			AccountHandlerService accountHandlerService) {
		this.accountHandlerService = accountHandlerService;
	}

	
	

	public ModelAndView searchAccountGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.searchAccountGroup(box);
		String jsp = FA_ACCOUNT_GROUP_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	
	public void getAccCodeForAccSubGrp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = accountHandlerService.getAccCodeForAccSubGrp(box);
		Integer accCode = 0;
		if (map.get("accCode") != null) {
			accCode = (Integer) map.get("accCode");
		}
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<accCode>" + accCode + "</accCode>");
			sb.append("</item>");
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

	public ModelAndView addAccountMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		FaMasAccount faMasAccount = new FaMasAccount();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Integer accountCode = 0;
		if (request.getParameter(CODE) != null) {
			accountCode = Integer.parseInt(request.getParameter(CODE));
			faMasAccount.setAccCode(accountCode);
		}
		String accountName = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			accountName = request.getParameter(SEARCH_NAME);
			faMasAccount.setAccDesc(accountName);
		}

		int fYear = 1;
		MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
		masStoreFinancial.setId(fYear);
		faMasAccount.setFYear(masStoreFinancial);
		generalMap.put("fYear", fYear);
		if (request.getParameter("parentStatus") != null) {
			faMasAccount.setParentStatus("y");
		} else {
			faMasAccount.setParentStatus("n");
		}
		if (request.getParameter("subLedgerStatus") != null) {
			faMasAccount.setSubLedger("y");
		} else {
			faMasAccount.setSubLedger("n");
		}
		if (request.getParameter("bankId") != null
				&& !(request.getParameter("bankId").equals("0"))) {
			int bankId = Integer.parseInt(request.getParameter("bankId"));
			MasBankMaster masBankMaster = new MasBankMaster();
			masBankMaster.setId(bankId);
			faMasAccount.setBank(masBankMaster);
		}
		int accountgroupId = 0;
		if (request.getParameter(DISTRICT_ID) != null
				&& !(request.getParameter(DISTRICT_ID).equals("0"))) {
			accountgroupId = Integer.parseInt(request
					.getParameter(DISTRICT_ID));
			generalMap.put("accountgroupId", accountgroupId);
		}
		int accountSubGroupId = 0;
		if (request.getParameter("subGroupName") != null
				&& !(request.getParameter("subGroupName").equals("0"))) {
			accountSubGroupId = Integer.parseInt(request
					.getParameter("subGroupName"));
			FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
			faMasAccountSubGroup.setId(accountSubGroupId);
			faMasAccount.setAccountSubGroup(faMasAccountSubGroup);
			generalMap.put("accountSubGroupId", accountSubGroupId);

		}
		String accountRight="";
		
		if (request.getParameter("accountRight") != null
				&& !(request.getParameter("accountRight").equals(""))) {
			accountRight = request
					.getParameter("accountRight");
			faMasAccount.setAccountRight(accountRight);
			generalMap.put("accountRight", accountRight);
			
		}
		int accountId = 0;
		if (request.getParameter(ACCOUNT_ID) != null
				&& !(request.getParameter(ACCOUNT_ID).equals("0"))) {
			accountId = Integer.parseInt(request.getParameter(ACCOUNT_ID));
			FaMasAccount famasAccount2 = new FaMasAccount();
			famasAccount2.setId(accountId);
			faMasAccount.setParent(famasAccount2);

		}
		String accountTypeA = "";
		if (request.getParameter("accountTypeA") != null
				&& !request.getParameter("accountTypeA").equals("")) {
			accountTypeA = request.getParameter("accountTypeA");
		}

		

		int changedBy = 0;
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			changedBy = users.getId();
			Users user = new Users();
			user.setId(changedBy);
			faMasAccount.setLastChgBy(user);
		}

		Date currentDate = new Date();
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			faMasAccount.setLastChgDate(currentDate);
		}
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			faMasAccount.setLastChgTime(currentTime);
		}
		if (request.getParameter("schedule") != null
				&& !request.getParameter("schedule").equals("0")) {
			faMasAccount.setSchedule(Integer.parseInt(request
					.getParameter("schedule")));
		}
		faMasAccount.setStatus("y");
		faMasAccount.setOpBalanceCr(new BigDecimal(0));
		faMasAccount.setOpBalanceDr(new BigDecimal(0));
		faMasAccount.setYtdAmountCr(new BigDecimal(0));
		faMasAccount.setYtdAmountDr(new BigDecimal(0));
		faMasAccount.setClBalanceCr(new BigDecimal(0));
		faMasAccount.setClBalanceDr(new BigDecimal(0));
		generalMap.put("faMasAccount", faMasAccount);
		generalMap.put("box", box);
		map = accountHandlerService.addAccountMaster(generalMap);
		/*map = accountHandlerService.showAccountMasterNew(generalMap);*/
		List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		if(map.get("faMasAccountSubGroupList")!=null){
			faMasAccountSubGroupList=(List<FaMasAccountSubGroup>)map.get("faMasAccountSubGroupList");
		}
		List<FaMasAccountSubGroup>gridMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();
		if(map.get("gridMasAccountSubGroupList")!=null){
		gridMasAccountSubGroupList = (ArrayList)map.get("gridMasAccountSubGroupList");
		}
		String jsp = "accountMaster";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountSubGroupList",gridMasAccountSubGroupList);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAccountMaster(HttpServletRequest request,
			HttpServletResponse response) {
		  Map<String, Object> map = new HashMap<String, Object>();
		  Map<String, Object> generalMap = new HashMap<String, Object>();
		  int faMasAccountId=0;
		  Integer accountCode = 0;
		  String parentStatus="";
		  String subLedgerStatus="";
		  String title = "";
			String message = "";
			String url = "";
			String jsp="";
		  HttpSession session = request.getSession();
			String name = "";
			if (request.getParameter(CODE) != null) {
				accountCode = Integer.parseInt(request.getParameter(CODE));
			}
			String accountName = "";
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			 if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				 faMasAccountId =Integer.parseInt( request.getParameter(COMMON_ID));
			   }
			int fYear = 1;
			
			
			if (request.getParameter("parentStatus") != null) {
				parentStatus="y";
			} else {
				parentStatus="n";
			}
			if (request.getParameter("subLedgerStatus") != null) {
				subLedgerStatus="y";
			} else {
				subLedgerStatus="n";
			}
			int bankId=0;
			if (request.getParameter("bankId") != null
					&& !(request.getParameter("bankId").equals("0"))) {
				 bankId = Integer.parseInt(request.getParameter("bankId"));
				
			}
			int accountgroupId = 0;
			if (request.getParameter(DISTRICT_ID) != null
					&& !(request.getParameter(DISTRICT_ID).equals("0"))) {
				accountgroupId = Integer.parseInt(request
						.getParameter(DISTRICT_ID));
				
			}
			int accountSubGroupId = 0;
			if (request.getParameter("subGroupName") != null
					&& !(request.getParameter("subGroupName").equals("0"))) {
				accountSubGroupId = Integer.parseInt(request
						.getParameter("subGroupName"));
			
				

			}
			String accountRight="";
			
			if (request.getParameter("accountRight") != null
					&& !(request.getParameter("accountRight").equals(""))) {
				accountRight = request
						.getParameter("accountRight");
				generalMap.put("accountRight", accountRight);
				
			}
			int accountId = 0;
			if (request.getParameter(ACCOUNT_ID) != null
					&& !(request.getParameter(ACCOUNT_ID).equals("0"))) {
				accountId = Integer.parseInt(request.getParameter(ACCOUNT_ID));
			

			}
		
			int changedBy = 0;
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				changedBy = users.getId();
			
			}

			Date currentDate = new Date();
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				currentDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
			
			}
			String currentTime = "";
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
			
			}
			int schedule=0;
			if (request.getParameter("schedule") != null
					&& !request.getParameter("schedule").equals("0")) {
				schedule=Integer.parseInt(request
						.getParameter("schedule"));
			}
			
		
	System.out.println("schedule::::" + schedule);
			
		   generalMap.put("id", faMasAccountId);
		   generalMap.put("accountCode", accountCode);
		   generalMap.put("name", name);
		   generalMap.put("parentStatus",parentStatus);
		   generalMap.put("accountgroupId", accountgroupId);
		   generalMap.put("subLedgerStatus",subLedgerStatus);
		   generalMap.put("accountId",accountId);
		   generalMap.put("accountRight", accountRight);
		   generalMap.put("userId", changedBy);
		   generalMap.put("fYear", fYear);
		   generalMap.put("bankId", bankId);
		   generalMap.put("currentDate", currentDate);
		   generalMap.put("currentTime", currentTime);
		   generalMap.put("accountSubGroupId", accountSubGroupId);
		   generalMap.put("schedule", schedule);
		
		  boolean dataUpdated=false;
		  try{
		   dataUpdated=accountHandlerService.editAccountMaster(generalMap);
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  if(dataUpdated==true){
		   message="Record Updated Successfully !!";

		  }
		  else{
		   message="Record Cant be updated !!";
		  }

		  map = accountHandlerService.showAccountMasterNew(generalMap);
		  List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
			if(map.get("faMasAccountSubGroupList")!=null){
				faMasAccountSubGroupList=(List<FaMasAccountSubGroup>)map.get("faMasAccountSubGroupList");
			}
			List<FaMasAccountSubGroup>gridMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();
			if(map.get("gridMasAccountSubGroupList")!=null){
			gridMasAccountSubGroupList = (ArrayList)map.get("gridMasAccountSubGroupList");
			}
			  List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
				if(map.get("faMasAccountGroupList")!=null){
					faMasAccountGroupList=(List<FaMasAccountGroup>)map.get("faMasAccountGroupList");
				}
			
		  	 jsp="accountMaster";
			title="Edit Account";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
			map.put("gridMasAccountSubGroupList",gridMasAccountSubGroupList);
			map.put("faMasAccountGroupList",faMasAccountGroupList);
			return new ModelAndView("index", "map", map);
		 }

	public ModelAndView updateAccountMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}

		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.updateAccountMaster(box);
		String jsp = "accountMaster";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAccountMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.searchAccountMaster(box);
		
		  List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
			if(map.get("faMasAccountSubGroupList")!=null){
				faMasAccountSubGroupList=(List<FaMasAccountSubGroup>)map.get("faMasAccountSubGroupList");
			}
			List<FaMasAccountSubGroup> gridMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();
			if(map.get("gridMasAccountSubGroupList")!=null){
			gridMasAccountSubGroupList = (ArrayList)map.get("gridMasAccountSubGroupList");
			}
		
		String jsp = "accountMaster";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountSubGroupList",gridMasAccountSubGroupList);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCashVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		/*int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		*/
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
	/*	String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}*/
		map = accountHandlerService.showCashVoucherJsp(box);

		String jsp = FA_CASH_VOUCHER;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getAccountCodeForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		/*
		 * int financialYearId = 0; if(request.getParameter("financialYearId")!=
		 * null){ financialYearId
		 * =Integer.parseInt(request.getParameter("financialYearId")); }
		 * parameterMap.put("financialYearId", financialYearId);
		 */
		HttpSession session=request.getSession();
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			parameterMap.put("locationId", locationId);
		}
		
		String fieldName = "";
		String accountNameStr = "";
		if (request.getParameter("requiredField") != null) {
			fieldName = request.getParameter("requiredField");
		}
		if (request.getParameter(fieldName) != null) {
			accountNameStr = request.getParameter(fieldName);
		}
		if (request.getParameter("amtType") != null) {
			String amtType = request.getParameter("amtType");
			parameterMap.put("amtType", amtType);
		}

		if (request.getParameter("salesVoucherType") != null) {
			String salesVoucherType = request.getParameter("salesVoucherType");
			parameterMap.put("salesVoucherType", salesVoucherType);
		}
		parameterMap.put("accountNameStr", accountNameStr);
		map = accountHandlerService.getAccountCodeForAutoComplete(parameterMap);
		String jsp = "";
		jsp = "responseForCashVoucher";
		// map.put("financialYearId", financialYearId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSubLedgerForAccount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		
		parameterMap.put("fYear", msf.getId());
		int locationId=0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
		}
		parameterMap.put("locationId", locationId);
		
		
		String accName = "";
		if (request.getParameter("accName") != null) {
			accName = request.getParameter("accName");
		}

		String flag="";
		if(request.getParameter("flagValueOP")!=null && !request.getParameter("flagValueOP").isEmpty()){
			flag= request.getParameter("flagValueOP");
			parameterMap.put("flag", flag);
		}
		
		String chkHo="";
		if(request.getParameter("transferHo")!=null && !request.getParameter("transferHo").isEmpty()){
			chkHo=request.getParameter("transferHo");
			parameterMap.put("chkHo", chkHo);
		}
		
		
		Integer index1 = 0;
		index1 = accName.lastIndexOf("[") + 1;

		int index2 = accName.lastIndexOf("]");
		String accountName = accName.substring(index1, index2);

		parameterMap.put("accountName", accountName);
		map = accountHandlerService.getSubLedgerForAccount(parameterMap);
		map.put("rowVal", request.getParameter("rowVal"));
	
		String jsp = "";
		jsp = "responseForSubLedger";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getNarrationForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		String fieldName = "";
		String narrationStr = "";
		if (request.getParameter("requiredField") != null) {
			fieldName = request.getParameter("requiredField");
		}
		if (request.getParameter(fieldName) != null) {
			narrationStr = request.getParameter(fieldName);
		}

		parameterMap.put("narrationStr", narrationStr);
		map = accountHandlerService.getNarrationForAutoComplete(parameterMap);
		String jsp = "";
		jsp = "responseForVoucherNarration";

		return new ModelAndView(jsp, "map", map);
	}

	public void addVoucherNarration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		FaMasNarration faMasNarration = new FaMasNarration();
		String narration = "";
		String message = "";

		if (request.getParameter("voucherNarration") != null) {
			narration = request.getParameter("voucherNarration");
			faMasNarration.setNarrationDesc(narration);
		}
		faMasNarration.setFlag("V");
		map = accountHandlerService.addVoucherNarration(faMasNarration);
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		try {
			// ------------Response------------------

			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<message>" + message + "</message>");
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

	public void showAccountBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

	
		
		HttpSession session = request.getSession();
		Box box= HMSUtil.getBox(request);
		
		int fyear = 0;
		if (session.getAttribute("financialYear") != null) {
			fyear = (Integer) session.getAttribute("financialYear");
			box.put("fyear", fyear);
		}
		
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		
		int accountId = 0;
		if (request.getParameter("accountId") != null) {
			accountId = Integer.parseInt(request.getParameter("accountId"));
			box.put("accountId", accountId);
		}

		map = accountHandlerService.showAccountBalance(box);
		List<AccountMainTransac> accountList = new ArrayList<AccountMainTransac>();
		if (map.get("accountList") != null) {
			accountList = (List) map.get("accountList");
		}
		BigDecimal closingBalanceDr = new BigDecimal(0.0);
		BigDecimal closingBalanceCr = new BigDecimal(0.0);
		int groupId = 0;
		int subGroupId = 0;
		if (accountList.size() > 0) {
			for (AccountMainTransac faMasAccount : accountList) {
				if (faMasAccount.getClBalanceDr() != null
						&& faMasAccount.getClBalanceDr().compareTo(
								new BigDecimal(0)) != 0) {
					closingBalanceDr = faMasAccount.getClBalanceDr();
				} else if (faMasAccount.getClBalanceCr() != null
						&& faMasAccount.getClBalanceCr().compareTo(
								new BigDecimal(0)) != 0) {
					closingBalanceCr = faMasAccount.getClBalanceCr();
				}
				groupId = 0;
				subGroupId = 0;
			}
		}

		try {
			// ------------Response------------------

			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			if (closingBalanceDr.compareTo(new BigDecimal(0)) > 0) {
				sb.append("<balance>" + closingBalanceDr + " Dr </balance>");
			} else if (closingBalanceCr.compareTo(new BigDecimal(0)) > 0) {
				sb.append("<balance>" + closingBalanceCr + " Cr </balance>");
			} else {
				sb.append("<balance>" + 0 + "  </balance>");
			}
			sb.append("<groupId>" + groupId + " </groupId>");
			sb.append("<subGroupId>" + subGroupId + " </subGroupId>");
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

	public void showAccountNarration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		FaMasNarration faMasNarration = new FaMasNarration();
		String accountNarration = "";
		String message = "";

		if (request.getParameter("accountNarration") != null) {
			accountNarration = request.getParameter("accountNarration");
			faMasNarration.setNarrationDesc(accountNarration);
		}
		faMasNarration.setFlag("A");
		map = accountHandlerService.addVoucherNarration(faMasNarration);
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		try {
			// ------------Response------------------

			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<message>" + message + "</message>");
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

	public ModelAndView getAccountNarrationForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		String fieldName = "";
		String accountNarration = "";
		if (request.getParameter("requiredField") != null) {
			fieldName = request.getParameter("requiredField");
		}
		if (request.getParameter(fieldName) != null) {
			accountNarration = request.getParameter(fieldName);
		}

		parameterMap.put("accountNarration", accountNarration);
		map = accountHandlerService
				.getAccountNarrationForAutoComplete(parameterMap);
		String jsp = "";
		jsp = "responseForAccountNarration";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitReceiptVoucher(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		
		int accountId = 0;
		if (request.getParameter(ACCOUNT_ID) != null) {
			accountId = Integer.parseInt(request.getParameter(ACCOUNT_ID));
		}
	
		
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}

		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.submitReceiptVoucher(box);
		String voucherNo="";
		if(map.get("voucherNo1")!=null){
			voucherNo=(String)map.get("voucherNo1");
		}
		String voucherType="";
		if(map.get("voucherType")!=null){
			voucherType=(String)map.get("voucherType");
		}
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		String voucherType1 = "RV";
		if (saved) {
			message = "Reciept Voucher Saved Successfully and Pending for Approval with voucher No="+voucherNo+".";
		} else {
			message = "Try Again!";
		}
		// map = accountHandlerService.showCashVoucherJsp(box);
		map.put("message", message);
		map.put("accountId", accountId);
		
		map.put("voucherType1", voucherType1);
		if (map.get("voucherNo") != null) {
			map.put("voucherNo", map.get("voucherNo"));
		}
		map.put("voucherDate", box.getString(VOUCHER_DATE));
		map.put("fyear", msf.getId());
		String url = "hms/hms/account?method=showCashVoucherJsp";
		map.put("url", url);
		String jsp = "fa_msgForVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	

	@SuppressWarnings("unchecked")
	public void showAccountCrBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		Box box= HMSUtil.getBox(request);
		String flag="";
		/*int fyear = 0;
		if (session.getAttribute("financialYear") != null) {
			fyear = (Integer) session.getAttribute("financialYear");
			box.put("fyear", fyear);
		}
		*/
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fyear", msf.getId());
		
		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		
		int accountId = 0;
		if (request.getParameter("accountId") != null) {
			accountId = Integer.parseInt(request.getParameter("accountId"));
			box.put("accountId", accountId);
		}

		int subledId = 0;
		if (request.getParameter("subledId") != null) {
			subledId = Integer.parseInt(request.getParameter("subledId"));
			box.put("subledId", subledId);
		}
		map = accountHandlerService.showAccountBalance(box);
		List<AccountMainTransac> accountList = new ArrayList<AccountMainTransac>();
		List<AccountSubLedTransac> accountListSubLed = new ArrayList<AccountSubLedTransac>();
		
		if (map.get("accountList") != null) {
			accountList = (List) map.get("accountList");
		}
		
		if (map.get("accountListSubLed") != null) {
			accountListSubLed = (List) map.get("accountListSubLed");
		}
		
		if (map.get("flag") != null) {
			flag = (String) map.get("flag");
		}
		BigDecimal closingBalanceCr = new BigDecimal(0);
		BigDecimal closingBalanceDr = new BigDecimal(0);
		int groupId = 0;
		int subGroupId = 0;
		
		if (accountList.size() > 0) {
			if(flag.equalsIgnoreCase("accMain")){
				for (AccountMainTransac faMasAccount : accountList) {
					if (faMasAccount.getClBalanceCr() != null
							&& faMasAccount.getClBalanceCr().compareTo(
									new BigDecimal(0)) != 0) {
						closingBalanceCr = faMasAccount.getClBalanceCr();
					} else {
						closingBalanceDr = faMasAccount.getClBalanceDr();
					}
					groupId = faMasAccount.getAccount().getAccountSubGroup().getAccountGroup()
							.getId();
					subGroupId = faMasAccount.getAccount().getAccountSubGroup().getId();
				}	
			}
			}
		if(accountListSubLed.size()>0){
		 if(flag.equalsIgnoreCase("subLed")){
				for (AccountSubLedTransac faMasAccountSub : accountListSubLed) {
					if (faMasAccountSub.getClBalanceCr() != null
							&& faMasAccountSub.getClBalanceCr().compareTo(
									new BigDecimal(0)) != 0) {
						closingBalanceCr = faMasAccountSub.getClBalanceCr();
					} else {
						closingBalanceDr = faMasAccountSub.getClBalanceDr();
					}
					groupId = faMasAccountSub.getSubLed().getAccount().getAccountSubGroup().getAccountGroup()
							.getId();
					subGroupId = faMasAccountSub.getSubLed().getAccount().getAccountSubGroup().getId();
				}	
			}
		
		}
		try {
			// ------------Response------------------

			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			if (closingBalanceDr.compareTo(new BigDecimal(0)) > 0) {
				sb.append("<balance>" + closingBalanceDr + " Dr </balance>");
			} else {
				sb.append("<balance>" + closingBalanceCr + " Cr </balance>");
			}
			sb.append("<groupId>" + groupId + " </groupId>");
			sb.append("<subGroupId>" + subGroupId + " </subGroupId>");
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

	


	
	public ModelAndView showAccountOpeningJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int branchId = 0;
		if (session.getAttribute("branchId") != null) {
			branchId = (Integer) session.getAttribute("branchId");
			// map.put("branchId", branchId);
		}
		map = accountHandlerService.showAccountOpeningJsp(branchId);
		String jsp = "fa_accountOpening.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveAccountOpening(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		/*
		 * int branchId = 0; if(session.getAttribute("branchId") != null){
		 * branchId = (Integer) session.getAttribute("branchId"); }
		 */
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		box.put("locationId", locationId);
		map = accountHandlerService.saveAccountOpening(box);
		String jsp = "fa_accountOpening.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateAccountOpening(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int branchId = 0;
		if (session.getAttribute("branchId") != null) {
			branchId = (Integer) session.getAttribute("branchId");
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		box.put("branchId", branchId);
		box.put("hospitalId", hospitalId);
		map = accountHandlerService.updateAccountOpening(box);
		String jsp = "fa_accountOpening.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAccountOpening(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			box.put("flag", flag);
		}
		int branchId = 0;
		if (session.getAttribute("branchId") != null) {
			branchId = (Integer) session.getAttribute("branchId");
			box.put("branchId", branchId);
		}
		map = accountHandlerService.deleteAccountOpening(box);

		String jsp = "fa_accountOpening.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Show Account Sub Group
	 * 
	 * @param request
	 * @param response
	 * @author ritu
	 */

	public ModelAndView showViewAccountSubGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		/*
		 * int branchId = 0; if(session.getAttribute("branchId") != null){
		 * branchId = (Integer) session.getAttribute("branchId"); }
		 */
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
		}
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
		}
		int accountGroupId = 0;
		if (request.getParameter("accountId") != null) {
			accountGroupId = Integer
					.parseInt(request.getParameter("accountId"));
		}
		generalMap.put("accountGroupId", accountGroupId);
		generalMap.put("fYear", fYear);
		generalMap.put("locationId", locationId);
		// generalMap.put("branchId", branchId);

		map = accountHandlerService.showAccountSubGroup(generalMap);
		String jsp = "fa_viewAccountSubGroup.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}


	public ModelAndView addAccountSubGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
		HttpSession session = request.getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		int fYear = 0;
		/*if (session.getAttribute("financialYear") != null) {*/
			/*fYear = (Integer) session.getAttribute("financialYear");*/
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(1);
			faMasAccountSubGroup.setFYear(masStoreFinancial);
			generalMap.put("fYear", fYear);
		/*}*/
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(locationId);
			faMasAccountSubGroup.setHospital(masHospital);
			generalMap.put("locationId", locationId);
		}
		int accountSubGroupCode = 0;
		if (request.getParameter("subGroupCode") != null) {
			accountSubGroupCode = Integer.parseInt(request
					.getParameter("subGroupCode"));
			faMasAccountSubGroup.setAccountSubGroupCode(accountSubGroupCode);
			generalMap.put("accountSubGroupCode", accountSubGroupCode);
		}
		String accounSubGroupName = "";
		if (request.getParameter("subGroupName") != null) {
			accounSubGroupName = request.getParameter("subGroupName");
			faMasAccountSubGroup.setAccountSubGroupName(accounSubGroupName);
			generalMap.put("accounSubGroupName", accounSubGroupName);
		}

		int accountgroupId = 0;
		if (request.getParameter("accountGroupId") != null
				&& !(request.getParameter("accountGroupId").equals("0"))) {
			accountgroupId = Integer.parseInt(request
					.getParameter("accountGroupId"));
			FaMasAccountGroup faMasAccountGroup = new FaMasAccountGroup();
			faMasAccountGroup.setId(accountgroupId);
			faMasAccountSubGroup.setAccountGroup(faMasAccountGroup);
		}

		int changedBy = 0;
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			changedBy = users.getId();
			Users user = new Users();
			user.setId(changedBy);
			faMasAccountSubGroup.setLastChgBy(user);
		}

		faMasAccountSubGroup.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		faMasAccountSubGroup.setLastChgTime(time);

		faMasAccountSubGroup.setStatus("y");

		generalMap.put("faMasAccountSubGroup", faMasAccountSubGroup);
		map = accountHandlerService.addAccountSubGroup(generalMap);
		String jsp = "fa_accountSubGroup.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAccountSubGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			generalMap.put("fYear", fYear);
		}
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			generalMap.put("locationId", locationId);
		}
		int accountSubGroupId = 0;
		if (request.getParameter("accountSubGroupId") != null) {
			accountSubGroupId = Integer.parseInt(request
					.getParameter("accountSubGroupId"));
			generalMap.put("accountSubGroupId", accountSubGroupId);
		}
		map = accountHandlerService.editAccountSubGroup(generalMap);
		String jsp = "fa_accountSubGroup.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateAccountSubGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			generalMap.put("fYear", fYear);
		}
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			generalMap.put("locationId", locationId);
		}
		int subGroupId = 0;
		if (request.getParameter("subGroupId") != null) {
			subGroupId = Integer.parseInt(request.getParameter("subGroupId"));
			generalMap.put("subGroupId", subGroupId);
		}
		int accountSubGroupCode = 0;
		if (request.getParameter("subGroupCode") != null) {
			accountSubGroupCode = Integer.parseInt(request
					.getParameter("subGroupCode"));
			generalMap.put("accountSubGroupCode", accountSubGroupCode);
		}
		String accounSubGroupName = "";
		if (request.getParameter("subGroupName") != null) {
			accounSubGroupName = request.getParameter("subGroupName");
			generalMap.put("accounSubGroupName", accounSubGroupName);
		}
		int accountgroupId = 0;
		if (request.getParameter("accountGroupId") != null
				&& !(request.getParameter("accountGroupId").equals("0"))) {
			accountgroupId = Integer.parseInt(request
					.getParameter("accountGroupId"));
			generalMap.put("accountgroupId", accountgroupId);
		}
		int changedBy = 0;
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			changedBy = users.getId();
			generalMap.put("changedBy", changedBy);
		}
		map = accountHandlerService.updateAccountSubGroup(generalMap);
		String jsp = "fa_accountSubGroup.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAccountSubGroupBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int branchId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("branchId") != null) {
			branchId = (Integer) session.getAttribute("branchId");
		}
		generalMap.put("branchId", branchId);
		map = accountHandlerService.showAccountSubGroupBalance(generalMap);
		String jsp = "fa_accountSubGroupBalance.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	
	@SuppressWarnings("unchecked")	
	public ModelAndView addAccountSubLedger(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		FaMasSubLed faMasSubLed = new FaMasSubLed();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		String subLedgerCode = "";
		if (request.getParameter("subLedgerType") != null && !request.getParameter("subLedgerType").equals("")) {
			faMasSubLed.setSubLedType(request.getParameter("subLedgerType"));
			if (request.getParameter("centreName") != null && !request.getParameter("centreName").equals("0")) {
				MasHospital masHospital=new MasHospital();
				masHospital.setId(Integer.parseInt(request.getParameter("centreName")));
				faMasSubLed.setCentre(masHospital);
			}
			
		}

		
		int locationId=0;
		   if (session.getAttribute("hospitalId") != null)
			   locationId = (Integer) session.getAttribute("hospitalId");
		   
		   System.out.println("locationId" +locationId);
		   
		   MasHospital l=new MasHospital();
			l.setId(locationId);
			faMasSubLed.setHospital(l);
			generalMap.put("locationId", locationId);
			
		/*   if(locationId==1)
		   {
				int centreHId=0;
				if (request.getParameter("centreHId") != null &&  !request.getParameter("centreHId").equals("0")) {
					   centreHId = Integer.parseInt(request.getParameter("centreHId"));
					   }
		   if(centreHId !=0){
				MasHospital l=new MasHospital();
				l.setId(centreHId);
				faMasSubLed.setHospital(l);
				generalMap.put("locationId", centreHId);
				}
		   }
		   else{
			   MasHospital l=new MasHospital();
				l.setId(locationId);
				faMasSubLed.setHospital(l);
				generalMap.put("locationId", locationId);
		   }*/
		
		if (request.getParameter(CODE) != null) {
			subLedgerCode = request.getParameter(CODE);
			faMasSubLed.setSubLedCode(subLedgerCode);
		}
		
		String subLedgerName = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			subLedgerName = request.getParameter(SEARCH_NAME);
			faMasSubLed.setSubLedDesc(subLedgerName);
		}
		
		int growerId = 0;
		if (request.getParameter("ddlGrower") != null) {
			growerId = Integer.parseInt(request.getParameter("ddlGrower"));
			System.out.println("growerId="+growerId);
		/*	if(growerId !=0)
			{
				System.out.println("inside if");
			MasGrower grower = new MasGrower();
			grower.setId(growerId);
			faMasSubLed.setGrower(grower);
			}*/
		}
		int accountgroupId = 0;
		if (request.getParameter(ACCOUNT_GROUP_ID) != null
				&& !(request.getParameter(ACCOUNT_GROUP_ID).equals("0"))) {
			accountgroupId = Integer.parseInt(request
					.getParameter(ACCOUNT_GROUP_ID));
			generalMap.put("accountgroupId", accountgroupId);
		}
		int accountSubGroupId = 0;
		if (request.getParameter(ACCOUNT_SUB_GROUP_ID) != null
				&& !(request.getParameter(ACCOUNT_SUB_GROUP_ID).equals("0"))) {
			accountSubGroupId = Integer.parseInt(request
					.getParameter(ACCOUNT_SUB_GROUP_ID));
			generalMap.put("accountSubGroupId", accountSubGroupId);

		}
		int accountMasterId = 0;
		if (request.getParameter(ACCOUNT_ID) != null
				&& !(request.getParameter(ACCOUNT_ID).equals("0"))) {
			accountMasterId = Integer
					.parseInt(request.getParameter(ACCOUNT_ID));
			FaMasAccount faMasAccount = new FaMasAccount();
			faMasAccount.setId(accountMasterId);
			faMasSubLed.setAccount(faMasAccount);
			generalMap.put("accountMasterId", accountMasterId);
		}
		System.out.println("request.getParameter"+request.getParameter("rskId"));
	/*	if (request.getParameter("rskId") != null	&& !request.getParameter("rskId").equals("0"))
		{
				MasRsk masRsk=new MasRsk();
				masRsk.setId(Integer.parseInt(request.getParameter("rskId")));				
				faMasSubLed.setRsk(masRsk);
				}*/

		
		
		
			MasStoreFinancial msf = new MasStoreFinancial();
			
			msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
			
		

			faMasSubLed.setFYear(msf);
			generalMap.put("fYear", msf.getId());
		
		String accountTypeA = "";
		if (request.getParameter("accountTypeA") != null
				&& !request.getParameter("accountTypeA").equals("")) {
			accountTypeA = request.getParameter("accountTypeA");
		}

		if (accountTypeA.equals("Dr")) {
			BigDecimal opDrBalance = new BigDecimal("0");
			if (request.getParameter("openingBalance") != null
					&& !request.getParameter("openingBalance").equals("")) {
				opDrBalance = new BigDecimal(
						request.getParameter("openingBalance"));
				faMasSubLed.setOpBalanceDr(opDrBalance);
				faMasSubLed.setClBalanceDr(opDrBalance);
				generalMap.put("opDrBalance", opDrBalance);
			}
		} else if (accountTypeA.equals("Cr")) {
			BigDecimal opCrBalance = new BigDecimal("0");
			if (request.getParameter("openingBalance") != null
					&& !request.getParameter("openingBalance").equals("")) {
				opCrBalance = new BigDecimal(
						request.getParameter("openingBalance"));
				faMasSubLed.setOpBalanceCr(opCrBalance);
				faMasSubLed.setClBalanceCr(opCrBalance);
				generalMap.put("opCrBalance", opCrBalance);
			}

		}

		int changedBy = 0;
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			changedBy = users.getId();
			Users users2 = new Users();
			users2.setId(changedBy);
			faMasSubLed.setLastChgBy(users2);
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		faMasSubLed.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		faMasSubLed.setLastChgTime(time);

		faMasSubLed.setStatus("y");
		generalMap.put("faMasSubLed", faMasSubLed);
		generalMap.put("box", box);
		map = accountHandlerService.addAccountSubLedger(generalMap);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
	
		detailsMap.put("fYear", msf.getId());
		detailsMap.put("locationId", locationId);
		
		String jsp="";
		
		if(request.getParameter("flag") != null)
		{
			detailsMap.put("flag", request.getParameter("flag").toString());
		}
		if(request.getParameter("flag") != null && request.getParameter("flag").toString().equals("grower")){
			 jsp="fa_GrowerSubLedgerNew.jsp";
		}
		else if(request.getParameter("flag") != null && request.getParameter("flag").toString().equals("rsk")){
			 jsp="fa_RSKSubLedgerNew.jsp";
		}
		else
		{
		 jsp = "fa_accountSubLedgerNew.jsp";
		}
		map = accountHandlerService.showAccountSubLedgerJsp(detailsMap);
		
	
		
		 
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAccountSubLedger(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.searchAccountSubLedger(box);
		String searchField="";
		if(map.get("searchField")!=null){
			searchField=(String)map.get("searchField");
		}
		//String jsp = "fa_accountSubLedger.jsp";
		String jsp = "";
		if(request.getParameter("flag") != null && request.getParameter("flag").toString().equals("grower")){
			 jsp="fa_GrowerSubLedgerNew.jsp";
		}
		else if(request.getParameter("flag") != null && request.getParameter("flag").toString().equals("rsk")){
			 jsp="fa_RSKSubLedgerNew.jsp";
		}
		else
		{
		 jsp = "fa_accountSubLedgerNew.jsp";
		}
		map.put("contentJsp", jsp);
		map.put("searchField", searchField);
		map.put("search","search");
		return new ModelAndView("index", "map", map);
	}
	
	

	
	public ModelAndView editAccountSubLedger(HttpServletRequest request,
			HttpServletResponse response) {
		  Map<String, Object> map = new HashMap<String, Object>();
		  Map<String, Object> generalMap = new HashMap<String, Object>();
		  Map<String, Object> generalMapNew = new HashMap<String, Object>();
		  int subLedgerId=0;
		  String subLedgerCode=""; 
		  Integer accountCode = 0;
		  String title = "";
			String message = "";
			String url = "";
			String jsp="";
		  HttpSession session = request.getSession();
			String name = "";
			if (request.getParameter(CODE) != null) {
				subLedgerCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			 if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
				 subLedgerId =Integer.parseInt( request.getParameter(COMMON_ID));
			   }
		
			int accountId = 0;
			if (request.getParameter(ACCOUNT_ID) != null
					&& !(request.getParameter(ACCOUNT_ID).equals("0"))) {
				accountId = Integer.parseInt(request.getParameter(ACCOUNT_ID));
			

			}
		
			int changedBy = 0;
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				changedBy = users.getId();
			
			}

			Date currentDate = new Date();
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				currentDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
			
			}
			String currentTime = "";
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
			
			}
			
			
			
			int locationId=0;
			   if (session.getAttribute("hospitalId") != null)
				   locationId = (Integer) session.getAttribute("hospitalId");
			   generalMap.put("locationId", locationId);
			   
			
			   int rskId = 0;
			   if (request.getParameter("rskId") != null &&  !request.getParameter("rskId").equals("0")) {
				   rskId = Integer.parseInt(request.getParameter("rskId"));
				   }
			   
			   generalMap.put("rskId", rskId);
			   
		   generalMap.put("id", subLedgerId);
		   generalMap.put("subLedgerCode", subLedgerCode);
		   generalMap.put("name", name);
		   generalMap.put("accountId",accountId);
		   generalMap.put("userId", changedBy);
		   generalMap.put("currentDate", currentDate);
		   generalMap.put("currentTime", currentTime);
		   
		  boolean dataUpdated=false;
		  try{
		   dataUpdated=accountHandlerService.editAccountSubLedger(generalMap);
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  if(dataUpdated==true){
		   message="Record Updated Successfully !!";

		  }
		  else{
		   message="Record Cant be updated !!";
		  }
		
			int fYear = 0;
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
			}  
		   if (session.getAttribute("hospitalId") != null)
				   locationId = (Integer) session.getAttribute("hospitalId");
			   
			
		  generalMapNew.put("fYear", fYear);
		  generalMapNew.put("locationId", locationId);
		  
		  if(request.getParameter("flag") != null)
		  {
			  
			  generalMapNew.put("flag", request.getParameter("flag").toString());
			  
		  }
		  
		  
	       if(request.getParameter("flag") != null && request.getParameter("flag").toString().trim().equals("grower")){
				
				jsp="fa_GrowerSubLedgerNew";
				
			}
			else if(request.getParameter("flag") != null && request.getParameter("flag").toString().trim().equals("rsk")){
				jsp="fa_RSKSubLedgerNew";
				generalMapNew.put("fYear", fYear);
			}
			else
			{
				jsp="fa_accountSubLedgerNew";
			}
	
			map = accountHandlerService.showAccountSubLedgerJsp(generalMapNew);

		
			
			title="Edit Account";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		 }

	public ModelAndView updateAccountSubLedger(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.updateAccountSubLedger(box);
		String jsp = "fa_accountSubLedger.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	

	/**
	 * Code By Ritu for Bank Reconciliation
	 */

	public ModelAndView showBankReconciliationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int fYear = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
		}
		map = accountHandlerService.showBankReconciliationJsp(fYear);
		String jsp = FA_BANK_RECONCILIATION_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getBankAccountDetailsForReconciliation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int fYear = 0;
		int locationId=0;
		HttpSession session = request.getSession();
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
		}
		box.put("fYear", fYear);
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
		}
		box.put("locationId", locationId);
		map = accountHandlerService.getBankAccountDetailsForReconciliation(box);
		String jsp = "responseForBankReconciliationDetails";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView saveBankReconciliationDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int fYear = 0;
		int locationId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
		}
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		box.put("fYear", fYear);
		box.put("locationId", locationId);
		boolean saved = false;
		saved = accountHandlerService.saveBankReconciliationDetails(box);
		String message = "";
		if (saved) {
			message = "Reconciliation Details Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map = accountHandlerService.showBankReconciliationJsp(fYear);
		map.put("message", message);
		String jsp = FA_BANK_RECONCILIATION_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	
	public ModelAndView showVoucherMappingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.showVoucherMappingJsp(box);
		String jsp = "fa_accountsVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getBillingAmountForAccounts(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = accountHandlerService.getBillingAmountForAccounts();
		String jsp = "fa_accountsVoucherMapping";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBranchBalancePopupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = accountHandlerService.showBranchBalancePopupJsp();

		String jsp = "fa_branchBalancePopup";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showBranchSubLedBalancePopupJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = accountHandlerService.showBranchSubLedBalancePopupJsp();
		String jsp = "fa_branchSubledBalancePopUp";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView dispalySalesBillingAmount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.dispalySalesBillingAmount(box);
		String jsp = "fa_accountsVoucherMapping.jsp";
		map.put("fromMDateReturn",request.getParameter(FROM_DATE));
		map.put("toDateReturn",request.getParameter(TO_DATE));
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}




	public ModelAndView postSalesVoucherMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postSalesVoucherMapping(box);
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Data Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "fa_accountsVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIpSalesVoucherMappingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.showIpSalesVoucherMappingJsp(box);

		String jsp = "fa_ip_sales_voucher.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView dispalyIpSalesBillingAmount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.dispalyIpSalesBillingAmount(box);
		String jsp = "fa_ip_sales_voucher.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView postSalesIpVoucherMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postSalesIpVoucherMapping(box);
		String jsp = "fa_accountsVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showRefundVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "fa_refundVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView dispalyRefundBillingAmount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.dispalyRefundBillingAmount(box);
		String jsp = "fa_refundVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView postRefundVoucherMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postRefundVoucherMapping(box);
		String jsp = "fa_accountsVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAdvanceVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = "fa_advanceVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayAdvanceVoucherBillingAmount(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.displayAdvanceVoucherBillingAmount(box);
		String jsp = "fa_advanceVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView postAdvanceVoucherMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postAdvanceVoucherMapping(box);
		String jsp = "fa_advanceVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showFinalSettlementVoucherJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "fa_finalSettlementVoucher.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView dispalyFinalSettlementVoucherAmount(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.dispalyFinalSettlementVoucherAmount(box);
		String jsp = "fa_finalSettlementVoucher.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView postFinalSettlementVoucherMapping(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postFinalSettlementVoucherMapping(box);
		String jsp = "fa_finalSettlementVoucher.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showClosingFinancialYearJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "fa_closing_financialYear.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView closingFinancialYear(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("finYear") != null) {
			String finYear = (String) session.getAttribute("finYear");
			box.put("finYear", finYear);
		}
		int rb = 0;
		if (request.getParameter("rb") != null) {
			rb = Integer.parseInt(request.getParameter("rb"));
		}
		if (rb == 1) {
			map = accountHandlerService.closingFinancialYear(box);
		} else {
			// map = accountHandlerService.closingFinancialYear(box);
		}
		String jsp = "fa_closing_financialYear.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ======================================================Nilay's Code================================================================
	// --------------------------------------------Trial Balance Report--------------------------------
	public ModelAndView showTrialBalanceReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = accountHandlerService.showTrialBalanceReportJsp();
		String jsp = "fa_trial_balance_report" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printTrialBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospital_id = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospital_id = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int branchId = 0;
		if (session.getAttribute("branchId") != null) {
			branchId = (Integer) session.getAttribute("branchId");
		}
		Date from_date = null;
		if (request.getParameter(FROM_DATE) != null) {
			from_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));

		}
		Date to_date = null;
		if (request.getParameter(TO_DATE) != null) {
			to_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));

		}

		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospital_id);
		parameters.put("branchId", branchId);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);

		HMSUtil.generateReport("trialBalance", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	/*** Reports * @param request * @param response * @author Mansi ***/

	// --------------------------------------------Bank Voucher Report By Mansi-----------------------------------

	public ModelAndView showBankVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		map = accountHandlerService.showBankRegisterJsp();
		String jsp = "";
		String title = "";
		jsp += "fa_bankBook";
		jsp += ".jsp";
		title = "Bank Voucher Report";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayBankBook(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
	
		
		/*if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}*/
		/*int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}*/
		
		/*if (request.getParameter("centreHSearchId") != null && Integer.parseInt(request.getParameter("centreHSearchId")) != 0) {
			locationId = Integer.parseInt(request.getParameter("centreHSearchId"));
			box.put("locationId", locationId);
		}
		else{
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		}*/
		
		int fYear = 0;
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		
		map = accountHandlerService.displayBankBook(box);
		String jsp = "fa_bankVoucherReport.jsp";
		map.put("contentJsp", jsp);
		map.put("mainAccountId", box.getInt(ACCOUNT_ID));
		map.put("accountName", box.getString("accountName"));
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printBankVoucherReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> mapForVoucher = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		Date from_date = null;
		Date to_date = null;
		int hospital_id = 0;
		int accountId = 0;

		HttpSession session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospital_id = (Integer) session.getAttribute("hospitalId");
		}
		String from_date1 = "";
		if (request.getParameter(FROM_DATE) != null) {
			from_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			from_date1 = request.getParameter(FROM_DATE);
			generalMap.put("from_date", from_date);
		}
		if (request.getParameter(TO_DATE) != null) {
			to_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
			generalMap.put("to_date", to_date);
		}
		if (request.getParameter(ACCOUNT_ID) != null) {
			accountId = Integer.parseInt(request.getParameter(ACCOUNT_ID));
		}
		int branchId = 0;
		if (session.getAttribute("branchId") != null) {
			branchId = (Integer) session.getAttribute("branchId");
		}

		int financialYearId = accountHandlerService
				.getFinancialYearList(generalMap);

		

		String prevdate = "";
		prevdate = HMSUtil.getPrevDate(from_date1, 1);

		detailsMap = accountHandlerService.getConnectionForReport();
		generalMap.put("to_date", to_date);
		generalMap.put("prevdate", prevdate);
		generalMap.put("accountId", accountId);
		generalMap.put("financialYearId", financialYearId);
		generalMap.put("from_date", from_date);
		generalMap.put("branchId", branchId);

		map = accountHandlerService
				.getOpeningBalanceFromOpeningEntry(generalMap);

		

		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);
		parameters.put("hospital_id", hospital_id);
		parameters.put("accountId", accountId);
		
		parameters.put("branchId", branchId);

		mapForVoucher = accountHandlerService.getVoucherList(generalMap);
		

		if (financialYearId != 0) {
			HMSUtil.generateReport("Bank_register_acc_to_rajah", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
			
		} else {
			map = accountHandlerService.showBankRegisterJsp();
			map.put("message", "Please select Correct Financial Year");

		}

		String jsp = "";
		String title = "";
		jsp += FA_BANK_VOUCHER_REPORT_JSP;
		jsp += ".jsp";
		title = "Bank Voucher Report";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	// --------------------- -----------------------Sub Led Report By Mansi---------------------------------------

	public ModelAndView showSubLedJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = accountHandlerService.showSubLedJsp();
		String jsp = "fa_subLedReport" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printSubLed(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int accountId = 0;
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String financialYear = "";
		if (request.getParameter("fYear") != null) {
			financialYear = request.getParameter("fYear");
		}
		if (request.getParameter("accountId") != null) {
			accountId = Integer.parseInt(request.getParameter("accountId"));
		}
		String firstYear = financialYear.substring(0, 4);
		String lastYear = financialYear.substring(2, 4);
		String previousyear = Integer.parseInt(firstYear) - (1) + " - "
				+ lastYear;

		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("account_id", accountId);
		parameters.put("hospitalId", hospitalId);
		parameters.put("fin_year", financialYear);
		parameters.put("prev_fin_year", previousyear);

		HMSUtil.generateReport("sub_led_1", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	// --------------------------------------------GL Wise Sub Led Report by Mansi--------------------------------

	public ModelAndView showGLWiseSubLedReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = accountHandlerService.showTrialBalanceReportJsp();
		String jsp = "fa_gl_wise_sub_leg_report" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printGLWiseSubLedReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String financialYear = "";
		if (request.getParameter("fYear") != null) {
			financialYear = request.getParameter("fYear");
		}
		String firstYear = financialYear.substring(0, 4);
		String lastYear = financialYear.substring(2, 4);
		String previousyear = Integer.parseInt(firstYear) - (1) + " - "
				+ lastYear;

		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospitalId", hospitalId);
		parameters.put("fin_year", financialYear);
		parameters.put("prev_fin_year", previousyear);

		HMSUtil.generateReport("newTrial", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showCashRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.showCashRegisterJsp(box);

		String jsp = "fa_cas_register" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayCashBook(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		int locationId = 0;
		
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		
		map = accountHandlerService.displayCashBook(box);
		String jsp = "fa_cashBook.jsp";
		map.put("contentJsp", jsp);
		map.put("mainAccountId", box.getInt(ACCOUNT_ID));
		map.put("accountName", box.getString("accountName"));
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printCashRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForVoucher = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
		}
		int accountId = 0;
		if (request.getParameter(ACCOUNT_ID) != null) {
			accountId = Integer.parseInt(request.getParameter(ACCOUNT_ID));
		}

		Date from_date = null;
		String from_date1 = "";
		if (request.getParameter("from_date") != null) {
			from_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("from_date"));
			from_date1 = request.getParameter("from_date");
		}

		Date to_date = null;
		if (request.getParameter("to_date") != null) {
			to_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("to_date"));
		}
		/*
		 * int branchId = 0; if(session.getAttribute("branchId") != null){
		 * branchId = (Integer) session.getAttribute("branchId"); }
		 */

		/*
		 * String finFromDate = ""; Date fDate = new Date();
		 * if(financialYearList.size()>0){ HrMasFinancialYear masFinancialYear =
		 * financialYearList.get(0); finFromDate =
		 * HMSUtil.convertDateToStringTypeDate
		 * (masFinancialYear.getYearFromDate()); fDate =
		 * masFinancialYear.getYearFromDate(); }
		 */

		String prevdate = "";
		prevdate = HMSUtil.getPrevDate(from_date1, 1);
		// Date prevdate1 = HMSUtil.convertStringTypeDateToDateType(prevdate);
		generalMap.put("from_date", from_date);
		// generalMap.put("fDate", fDate);
		generalMap.put("to_date", to_date);
		generalMap.put("prevdate", prevdate);
		generalMap.put("accountId", accountId);
		// generalMap.put("branchId", branchId);
		// generalMap.put("finFromDate", finFromDate);
		int financialYearId = accountHandlerService
				.getFinancialYearList(generalMap);
		generalMap.put("financialYearId", financialYearId);
		map = accountHandlerService
				.getOpeningBalanceFromOpeningEntry(generalMap);

		// map = accountHandlerService.getOpeningBalance(generalMap);

		mapForVoucher = accountHandlerService.getVoucherList(generalMap);

		/*
		 * BigDecimal crAccountClBalance = new BigDecimal(0.00); BigDecimal
		 * drAccountClBalance = new BigDecimal(0.00);
		 */
		/*
		 * if(map.get("crAccountClBalance")!= null){ crAccountClBalance =
		 * ((BigDecimal)map.get("crAccountClBalance")); }
		 * if(map.get("drAccountClBalance")!= null){ drAccountClBalance =
		 * ((BigDecimal)map.get("drAccountClBalance")); }
		 */
		/*
		 * if(mapForVoucher.get("voucherDetailList")!= null){ voucherDetailList
		 * = (List<FaVoucherDetails>)mapForVoucher.get("voucherDetailList"); }
		 */
		parameters.put("locationId", locationId);
		parameters.put("accountId", accountId);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);
		/*
		 * parameters.put("crAccountClBalance", crAccountClBalance);
		 * parameters.put("drAccountClBalance", drAccountClBalance);
		 */
		// parameters.put("branchId", branchId);
		// parameters.put("SUBREPORT_DIR",
		// getServletContext().getRealPath("/Reports/"));

		detailsMap = accountHandlerService.getConnectionForReport();
		if (financialYearId != 0) {
			/* if(voucherDetailList.size()>0){ */
			HMSUtil.generateReport("cashRegister", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
			/*
			 * }else{ HMSUtil.generateReport("Cash_register_for_no_records",
			 * parameters, (Connection) detailsMap.get("conn"), response,
			 * getServletContext()); }
			 */
		} else {
			// map = accountHandlerService.showCashRegisterJsp();
			map.put("message", "Please select Correct Financial Year");

		}
		String jsp = "fa_cas_register" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------ledger Book
	// Report-------------------------------//

	public ModelAndView showLedgerBookJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = accountHandlerService.showLedgerBookJsp();

		String jsp = "fa_ledRegister" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printLedgerBookReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForVoucher = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		HttpSession session = request.getSession();

		int hospital_id = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospital_id = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int accountId = 0;
		if (request.getParameter(ACCOUNT_ID) != null) {
			accountId = Integer.parseInt(request.getParameter(ACCOUNT_ID));
		}
		String querySql = "";
		int subLedgerId = 0;
		if (request.getParameter(SUB_LEDGER_ID) != null
				&& !request.getParameter(SUB_LEDGER_ID).equals("0")) {
			subLedgerId = Integer.parseInt(request.getParameter(SUB_LEDGER_ID));
			querySql = querySql + " and d.sub_led_id = " + subLedgerId;
		}
		Date from_date = null;
		String from_date1 = "";
		if (request.getParameter("from_date") != null) {
			from_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("from_date"));
			from_date1 = request.getParameter("from_date");
		}

		Date to_date = null;
		if (request.getParameter("to_date") != null) {
			to_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("to_date"));
		}
		int branchId = 0;
		if (session.getAttribute("branchId") != null) {
			branchId = (Integer) session.getAttribute("branchId");
		}

		/*
		 * String finFromDate = ""; Date fDate = new Date();
		 * if(financialYearList.size()>0){ HrMasFinancialYear masFinancialYear =
		 * financialYearList.get(0); finFromDate =
		 * HMSUtil.convertDateToStringTypeDate
		 * (masFinancialYear.getYearFromDate()); fDate =
		 * masFinancialYear.getYearFromDate(); }
		 */

		String prevdate = "";
		prevdate = HMSUtil.getPrevDate(from_date1, 1);
		Date prevdate1 = HMSUtil.convertStringTypeDateToDateType(prevdate);
		generalMap.put("from_date", from_date);
		generalMap.put("branchId", branchId);
		generalMap.put("to_date", to_date);
		generalMap.put("prevdate", prevdate);
		generalMap.put("subLedgerId", subLedgerId);
		generalMap.put("accountId", accountId);
		generalMap.put("querySql", querySql);
		// generalMap.put("finFromDate", finFromDate);
		int financialYearId = accountHandlerService
				.getFinancialYearList(generalMap);
		generalMap.put("financialYearId", financialYearId);
		map = accountHandlerService
				.getOpeningBalanceFromOpeningEntry(generalMap);

		// map = accountHandlerService.getOpeningBalance(generalMap);

		mapForVoucher = accountHandlerService.getVoucherList(generalMap);

		/*
		 * BigDecimal crAccountClBalance = new BigDecimal(0.00); BigDecimal
		 * drAccountClBalance = new BigDecimal(0.00);
		 */
		/*
		 * if(map.get("crAccountClBalance")!= null){ crAccountClBalance =
		 * ((BigDecimal)map.get("crAccountClBalance")); }
		 * if(map.get("drAccountClBalance")!= null){ drAccountClBalance =
		 * ((BigDecimal)map.get("drAccountClBalance")); }
		 */
		/*
		 * if(mapForVoucher.get("voucherDetailList")!= null){ voucherDetailList
		 * = (List<FaVoucherDetails>)mapForVoucher.get("voucherDetailList"); }
		 */
		parameters.put("hospital_id", hospital_id);
		parameters.put("accountId", accountId);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);
		/*
		 * parameters.put("crAccountClBalance", crAccountClBalance);
		 * parameters.put("drAccountClBalance", drAccountClBalance);
		 */
		parameters.put("branchId", branchId);
		parameters.put("querySql", querySql);
		// parameters.put("SUBREPORT_DIR",
		// getServletContext().getRealPath("/Reports/"));

		detailsMap = accountHandlerService.getConnectionForReport();

		if (financialYearId != 0) {
			// if(voucherDetailList.size()>0){
			HMSUtil.generateReport("ledgerBook", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
			// }else{
			/*
			 * HMSUtil.generateReport("Cash_register_for_no_records",
			 * parameters, (Connection) detailsMap.get("conn"), response,
			 * getServletContext());
			 */
			// }
		} else {
			map = accountHandlerService.showLedgerBookJsp();
			map.put("message", "Please select Correct Financial Year");

		}
		String jsp = "fa_ledRegister" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDayBookReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "fa_day_book_report" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printDayBookReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospital_id = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospital_id = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Date from_date = null;
		if (request.getParameter("from_date") != null) {
			from_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("from_date"));
			generalMap.put("from_date", from_date);
		}
		Date to_date = null;
		if (request.getParameter("to_date") != null) {
			to_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("to_date"));
			generalMap.put("to_date", to_date);
		}
		int branchId = 0;
		if (session.getAttribute("branchId") != null) {
			branchId = (Integer) session.getAttribute("branchId");
		}

		int financialYearId = accountHandlerService
				.getFinancialYearList(generalMap);
		parameters.put("hospital_id", hospital_id);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);
		// parameters.put("crAccountClBalance", crAccountClBalance);
		// parameters.put("drAccountClBalance", drAccountClBalance);
		parameters.put("branchId", branchId);
		// parameters.put("SUBREPORT_DIR",
		// getServletContext().getRealPath("/Reports/"));

		detailsMap = accountHandlerService.getConnectionForReport();

		if (financialYearId != 0) {
			HMSUtil.generateReport("dayBookReport", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		} else {
			map = accountHandlerService.showLedgerBookJsp();
			map.put("message", "Please select Correct Financial Year");

		}
		String jsp = "fa_day_book_report" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------favoucherJsp
	// By:Ujjwal----------------------------------------------
	public ModelAndView showfavoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int fYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			fYearId = (Integer) session.getAttribute("financialYear");
		}
		map = accountHandlerService.showfavoucherJsp(fYearId);

		String jsp = "fa_voucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printfavoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int from_voucher_no = 0;
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int fYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			fYearId = (Integer) session.getAttribute("financialYear");
		}
		List<HrMasFinancialYear> financialYearList = accountHandlerService
				.getFinancialYearDate(fYearId);
		String financialYear = "";
		// Date fDate = new Date();
		if (financialYearList.size() > 0) {
			HrMasFinancialYear masFinancialYear = financialYearList.get(0);
			financialYear = masFinancialYear.getFinancialYear();
			// fDate = masFinancialYear.getYearFromDate();
		}

		if (request.getParameter("from_voucher_no") != null) {
			from_voucher_no = Integer.parseInt(request
					.getParameter("from_voucher_no"));
		}
		// int to_voucher_no=0;
		if (request.getParameter("to_voucher_no") != null) {
			from_voucher_no = Integer.parseInt(request
					.getParameter("to_voucher_no"));
		}

		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("from_voucher_no", from_voucher_no);
		parameters.put("hospitalId", hospitalId);
		parameters.put("fin_year", financialYear);

		detailsMap = accountHandlerService.getConnectionForReport();
		HMSUtil.generateReport("voucher_to_rajah", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	// ******************

	// -------------------------------------Journal Book by
	// Nilay---------------------------------

	public ModelAndView showJournalBookJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = "journal_book" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printJournalBookReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int hospital_id = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospital_id = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		Date from_date = null;
		if (request.getParameter("from_date") != null) {
			from_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("from_date"));
		}

		Date to_date = null;
		if (request.getParameter("to_date") != null) {
			to_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("to_date"));
		}

		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospital_id);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);

		HMSUtil.generateReport("journal_book2222__acc_to_rajah", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	// ---------------------------------Day wise
	// report-----------------------------------

	public ModelAndView showDayWiseReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = "day_wise" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printDayWiseReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		Date select_date = null;
		if (request.getParameter("select_date") != null) {
			select_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("select_date"));
		}

		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospitalId", hospitalId);
		parameters.put("select_date", select_date);

		HMSUtil.generateReport("Day_wise_report", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showLedgerAnalysisJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		// int fYearId = 0;

		map = accountHandlerService.showLedgerAnalysisJsp();
		String jsp = "ledger_analysis.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------------for profit and
	// Loss--------------------------
	public ModelAndView showProfitAndLossJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// HttpSession session = request.getSession();
		/*
		 * int fYearId = 0; if(session.getAttribute("financialYear") != null){
		 * fYearId = (Integer) session.getAttribute("financialYear"); }
		 */
		// map = accountHandlerService.showBankRegisterJsp();
		String jsp = "profitAndLossReportJsp.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateReportForGrowerPayment(HttpServletRequest request,
			HttpServletResponse response)
	{
		int seedQualityId=0;
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		

		if(request.getParameter("seedQualityId")!=null)
		{
			 seedQualityId = Integer.parseInt(request.getParameter("seedQualityId"));
			 requestParameters.put("seed_quality_id",seedQualityId);
		}
		try {
			
			String userHome = getServletContext().getRealPath("");
			System.out.println("userHome1="+userHome);
			String imagePath = userHome+"/jsp/images/logo.jpg";
			requestParameters.put("path", imagePath);
			requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath("reports/"));
		
			Map<String, Object> connectionMap = accountHandlerService.getConnection();
				HMSUtil.generateReport("grower_payment_details", requestParameters,(Connection) connectionMap.get("conn"), response,	getServletContext());
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
		
	}
	
	public ModelAndView printProfitAndLossReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String detail = "";
		if (request.getParameter("detail") != null) {
			detail = request.getParameter("detail");
		}
		int hospital_id = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospital_id = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		Date from_date = null;
		if (request.getParameter("from_date") != null) {
			from_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("from_date"));
		}

		Date to_date = null;
		if (request.getParameter("to_date") != null) {
			to_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("to_date"));
		}

		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospital_id);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);

		if (detail.equals("y")) {
			HMSUtil.generateReport("IncAndExp-detail", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else {
			HMSUtil.generateReport("IncAndExp-summary", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}
		return null;
	}

	// -------------------------------------for BalanceSheet-----------------------------------

	public ModelAndView showBalanceSheetJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int fYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			fYearId = (Integer) session.getAttribute("financialYear");
		}
		// map = accountHandlerService.showBankRegisterJsp();
		String jsp = "balanceSheet.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printBalanceSheetReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String detail = "";
		if (request.getParameter("detail") != null) {
			detail = request.getParameter("detail");
		}
		int hospital_id = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospital_id = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		Date sel_date = null;
		if (request.getParameter("select_date") != null) {
			sel_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("select_date"));
		}

		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospital_id);
		parameters.put("sel_date", sel_date);
		// parameters.put("to_date", to_date);

		if (detail.equals("y")) {
			HMSUtil.generateReport("BalanceSheet-detail", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else {
			HMSUtil.generateReport("BalanceSheet-summary", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}
		return null;

	}

	public ModelAndView showStatementProfitAndLossAcJsp(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> datamap = new HashMap<String, Object>();
	
	HttpSession session = request.getSession();
	int fYearId = 0;
    int locationId=0;
    /*if (session.getAttribute("financialYear") != null) {
		fYearId = (Integer) session.getAttribute("financialYear");
	}*/
	
	MasStoreFinancial msf = new MasStoreFinancial();	
	msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
	fYearId = msf.getId();
	
	
	if (session.getAttribute("hospitalId") != null) {
		locationId = (Integer) session.getAttribute("hospitalId");
	}
	
	datamap.put("fYearId",fYearId);
	datamap.put("locationId", locationId);
	map = accountHandlerService.showStatementProfitAndLossAcJsp(datamap);
	map.put("fYearId",fYearId);
	String jsp = "fa_statementPLAc.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
	public ModelAndView showStatementPLACJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int yearId=0;
		int locationId=0;
		/*if (request.getParameter("yearId") != null) {
			yearId = Integer.parseInt(request.getParameter("yearId"));
		}*/
		
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		yearId = msf.getId();
		
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
		}
		generalMap.put("yearId", yearId);
		generalMap.put("locationId", locationId);
		map = accountHandlerService.showStatementPLACJsp(generalMap);
		String jsp = "repsonsePL";
		map.put("pl", request.getParameter("pl"));
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showVoucherReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// HttpSession session = request.getSession();
		map = accountHandlerService.showVoucherReportJsp();
		String jsp = "";
		String title = "";
		jsp += FA_VOUCHER_REPORT_JSP;
		jsp += ".jsp";
		title = "Voucher Reports";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printVoucherReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String voucherType = "";
		if (request.getParameter("voucherType") != null) {
			voucherType = request.getParameter("voucherType");
		}
		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
		}
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		
		Date voucherDate = new Date();
		if (request.getParameter("voucherDate") != null) {
			voucherDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("voucherDate"));
		}
		int vhId = 0;
		if (request.getParameter("vhId") != null) {
			vhId = Integer.parseInt(request.getParameter("vhId"));
		}
		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("voucherType", voucherType);
		parameters.put("hospital_id", locationId);
		parameters.put("fYearId", msf.getId());
		parameters.put("voucherDate", voucherDate);
		parameters.put("vhId", vhId);
		
		
		
		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        parameters.put("path", imagePath);

		
		if (voucherType.equalsIgnoreCase("JV")) {
			HMSUtil.generateReport("journalVoucherId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} 
		else if (voucherType.equalsIgnoreCase("OP")) {
			HMSUtil.generateReport("opBalanceVoucher", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}
		else if (voucherType.equalsIgnoreCase("PRV")) {
			HMSUtil.generateReport("purchaseVoucherId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} 
		else if (voucherType.equalsIgnoreCase("RV")) {

			int accountId = 0;
			if (request.getParameter("accountId") != null) {
				accountId = Integer.parseInt(request.getParameter("accountId"));
			}
			parameters.put("accId", accountId);
			HMSUtil.generateReport("receiptVoucherReportId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (voucherType.equalsIgnoreCase("SV")) {
			HMSUtil.generateReport("salesVoucherId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (voucherType.equalsIgnoreCase("SR")) {
			HMSUtil.generateReport("salesReturnVoucherId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (voucherType.equalsIgnoreCase("PV")) {
			int accountId = 0;
			if (request.getParameter("accountId") != null) {
				accountId = Integer.parseInt(request.getParameter("accountId"));
			}
			parameters.put("accId", accountId);
			HMSUtil.generateReport("paymentVoucherId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (voucherType.equalsIgnoreCase("PR")) {
			HMSUtil.generateReport("purchaseReturnId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}

		return null;

	}

	public ModelAndView showAccountParameterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int fYear = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
		}
		map = accountHandlerService.showAccountParameterJsp(fYear);
		String jsp = "fa_account_parameter.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitAccountsParameter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int fYear = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = accountHandlerService.submitAccountsParameter(box);
		String jsp = "fa_account_parameter.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void showAccountBal(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> remap = new HashMap<String, Object>();
		List<FaMasAccount> accountL = new ArrayList<FaMasAccount>();
		HttpSession session = request.getSession();
		int resrate = 0;
		int accountId = 0;
		String accountNameId = "";
		String accountNameId1 = "";
		String accountCode = "";
		int financialId = 0;
		int branchId = 0;
		if (session.getAttribute("branchId") != null) {
			branchId = (Integer) session.getAttribute("branchId");
			remap.put("branchId", branchId);
		}
		if (request.getParameter("accountNameId") != null) {
			accountNameId = request.getParameter("accountNameId").trim();
			Integer index1 = accountNameId.lastIndexOf("[");
			Integer index2 = accountNameId.lastIndexOf("]");
			if (index1.intValue() > 0 && index2.intValue() > 0) {
				accountNameId1 = accountNameId.substring(0, index1).trim();
				accountCode = accountNameId.substring(index1 + 1, index2)
						.trim();
			}
			if (request.getParameter("resrate") != null) {
				resrate = Integer.parseInt(request.getParameter("resrate"));
				remap.put("resrate", resrate);
			}
			remap.put("accountNameId1", accountNameId1);
			remap.put("accountCode", accountCode);
		}
		map = accountHandlerService.getAccountId(remap);

		if (map.get("accountL") != null) {
			accountL = (List) map.get("accountL");
		}
		for (FaMasAccount accountLista : accountL) {
			accountId = accountLista.getId();
			remap.put("accountId", accountId);
		}
		Date voucherDate = new Date();
		if (request.getParameter("voucherDate") != null) {
			voucherDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("voucherDate"));
			remap.put("voucherDate", voucherDate);
		}
		financialId = accountHandlerService.getFinancialYearId(voucherDate);
		remap.put("financialId", financialId);
		map = accountHandlerService.showAccountBalanceall(remap);
		/*List<ViewData> accountList = new ArrayList<ViewData>();*/
		/*if (map.get("accountList") != null) {
			accountList = (List) map.get("accountList");
		}*/

		BigDecimal totalCr = null;
		BigDecimal totalDr = null;
		BigDecimal totalCr1 = new BigDecimal(0);
		BigDecimal totalDr1 = new BigDecimal(0);
		BigDecimal totalCr2 = null;
		BigDecimal totalDr2 = null;
		int groupId = 0;
		int subGroupId = 0;

		/*if (accountList.size() > 0) {
			if (resrate > 0) {
				for (ViewData faMasAccount1 : accountList) {
					if (faMasAccount1.getCrBalance() != null
							&& faMasAccount1.getCrBalance().intValueExact() > 0.0) {
						totalCr1 = faMasAccount1.getCrBalance();
					}
					if (faMasAccount1.getDrBalance() != null) {
						totalDr1 = faMasAccount1.getDrBalance();
					}
					
					  groupId = faMasAccount.getAccountSubGroup().getAccountGroup().getId(); subGroupId =* faMasAccount.getAccountSubGroup().getId();
					 
				}
				if (totalCr1.subtract(totalDr1).intValueExact() > 0) {
					totalCr2 = new BigDecimal(0);
					totalCr2 = totalCr1.subtract(totalDr1);
				}
				if (totalDr1.subtract(totalCr1).intValueExact() > 0) {
					totalDr2 = new BigDecimal(0);
					totalDr2 = totalDr1.subtract(totalCr1);
				}
			} else {
				if (accountList.size() > 0) {
					for (ViewData faMasAccount1 : accountList) {
						if (faMasAccount1.getCrBalance() != null
								&& faMasAccount1.getCrBalance().intValueExact() > 0.0) {
							totalCr = new BigDecimal(0);
							totalCr = faMasAccount1.getCrBalance();
							totalCr1 = totalCr1.add(totalCr);
						}
						if (faMasAccount1.getDrBalance() != null) {
							totalDr = new BigDecimal(0);
							totalDr = faMasAccount1.getDrBalance();
							totalDr1 = totalDr1.add(totalDr);
						}
						
						 * groupId =
						 * faMasAccount.getAccountSubGroup().getAccountGroup
						 * ().getId(); subGroupId =
						 * faMasAccount.getAccountSubGroup().getId();
						 
					}
					if (totalCr1.subtract(totalDr1).intValueExact() > 0) {
						totalCr2 = new BigDecimal(0);
						totalCr2 = totalCr1.subtract(totalDr1);
					}
					if (totalDr1.subtract(totalCr1).intValueExact() > 0) {
						totalDr2 = new BigDecimal(0);
						totalDr2 = totalDr1.subtract(totalCr1);
					}
				}
			}
		}*/
		try {
			// ------------Response------------------
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			if (totalDr2 != null && totalDr2.intValueExact() > 0) {
				sb.append("<balance>" + totalDr2 + " Dr </balance>");
			}
			if (totalCr2 != null && totalCr2.intValueExact() > 0) {
				sb.append("<balance>" + totalCr2 + " Cr </balance>");
			}
			if (totalCr2 == null && totalDr2 == null) {
				sb.append("<balance> 00 Cr </balance>");
			}
			sb.append("<groupId>" + groupId + " </groupId>");
			sb.append("<subGroupId>" + subGroupId + " </subGroupId>");
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

	// -------------------------------Ledger-------------------------------------------------------//
	public ModelAndView showLedgerJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		List<Object[]> centreList = new ArrayList<Object[]>();	
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		 centreList = marketingHandlerService.getCentreList();
		map = accountHandlerService.showLedgerJsp(box);
		String jsp = "ledgerBook.jsp";
		map.put("contentJsp", jsp);
		map.put("centreList", centreList);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView displayLedgerBook(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		
		String unitType="";
		  if(session.getAttribute("unitType") != null)
		  {
			  unitType = (String)session.getAttribute("unitType");
		  }
		  
		  int locationId = 0;
		  if(unitType.equalsIgnoreCase("HO"))
		  {
			  if(request.getParameter("ddlLocation") !=  null)
			  {
				  locationId = Integer.parseInt(request.getParameter("ddlLocation"));
					box.put("locationId", locationId);
			  }
		  }
		  else
		  {
			  if (session.getAttribute("locationId") != null) {
					locationId = (Integer) session.getAttribute("locationId");
					box.put("locationId", locationId);
				}
		  }
		  
		  
		
		
		map = accountHandlerService.displayLedgerBook(box);
		String jsp = "ledger.jsp";
		map.put("contentJsp", jsp);
		map.put("mainAccountId", box.getInt(ACCOUNT_ID));
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		map.put("accountName", box.getString("accountName"));
		map.put("locationName", box.getString("locationName"));
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView displayLedgerBookFromBalanceSheet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		String unitType="";
		  if(session.getAttribute("unitType") != null)
		  {
			  unitType = (String)session.getAttribute("unitType");
		  }
		 
		  int locationId = 0;
		/*  if(unitType.equalsIgnoreCase("HO"))
		  {
			  if(request.getParameter("locationIdParameter") !=  null)
			  {
				  locationId = Integer.parseInt(request.getParameter("locationIdParameter"));
					box.put("locationId", locationId);
				
			  }
		  }
		  else
		  {
			  if (session.getAttribute("locationId") != null) {
					locationId = (Integer) session.getAttribute("locationId");
					box.put("locationId", locationId);
				}
		  }*/
		  
		  if (session.getAttribute("hospitalId") != null) {
				locationId = (Integer) session.getAttribute("hospitalId");
				box.put("locationId", locationId);
			}
		  
		
		String locationName = accountHandlerService.getLocationName(locationId);
		
		map = accountHandlerService.displayLedgerBook(box);
		String jsp = "ledgerFromBalanceSheet.jsp";
		map.put("contentJsp", jsp);
		map.put("mainAccountId", box.getInt(ACCOUNT_ID));
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		map.put("accountName", box.getString("accountName"));
		map.put("locationName", locationName);
		map.put("locationId", String.valueOf(locationId));
		map.put("schedule", box.getString("schedule"));
		map.put("currentYearDesc", box.getString("currentYearDesc"));
		map.put("lastYearDesc", box.getString("lastYearDesc"));
		map.put("particular", box.getString("particular"));
		map.put("pageType", box.getString("pageType"));
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView displayLedgerBookForPnLStatement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		int locationId = 0;
		/*if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		*/
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		String unitType="";
		  if(session.getAttribute("unitType") != null)
		  {
			  unitType = (String)session.getAttribute("unitType");
		  }
		 
		  if (session.getAttribute("hospitalId") != null) {
				locationId = (Integer) session.getAttribute("hospitalId");
				box.put("locationId", locationId);
			}
		
		String locationName = accountHandlerService.getLocationName(locationId);
		
		map = accountHandlerService.displayLedgerBook(box);
		String jsp = "ledgerFromBalanceSheet.jsp";
		map.put("contentJsp", jsp);
		map.put("mainAccountId", box.getInt(ACCOUNT_ID));
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		map.put("accountName", box.getString("accountName"));
		map.put("locationName", locationName);
		map.put("locationId", String.valueOf(locationId));
		map.put("schedule", box.getString("schedule"));
		map.put("currentYearDesc", box.getString("currentYearDesc"));
		map.put("lastYearDesc", box.getString("lastYearDesc"));
		map.put("particular", box.getString("particular"));
		map.put("pageType", box.getString("pageType"));
		return new ModelAndView("index", "map", map);
	}

	
	

	public ModelAndView showSubLedgerPopupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		if (request.getParameter("accountId") != null) {
			generalMap.put("accountId",
					Integer.parseInt(request.getParameter("accountId")));
		}
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			generalMap.put("locationId", locationId);
		}
		map = accountHandlerService.showSubLedgerPopupJsp(generalMap);
		String jsp = "subLedDetailPopUp";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showTrialBalanceJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * Box box = HMSUtil.getBox(request); HttpSession session =
		 * request.getSession(); int fYear = 0; //int locationId = 0;
		 * if(session.getAttribute("financialYear") != null){ fYear =
		 * (Integer)session.getAttribute("financialYear"); box.put("fYear",
		 * fYear); }
		 */
		// map = accountHandlerService.showTrialBalanceJsp(box);
		String jsp = "trialBalance.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getTrialBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		int locationId = 0;
		String accountType = "";
		if (request.getParameter("accountTypeId") != null) {
			accountType = request.getParameter("accountTypeId");
			box.put("accountType", accountType);
		}
		/*if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}*/
		
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.getTrialBalance(box);
		String jsp = "";
		jsp = "viewTrialBalance.jsp";
		map.put("contentJsp", jsp);
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		map.put("accountType", box.getString("accountType"));
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getSubGroupWiseTrialBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		int locationId = 0;
		if (request.getParameter("groupId") != null) {
			int groupId = Integer.parseInt(request.getParameter("groupId"));
			box.put("groupId", groupId);
		}
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.getSubGroupWiseTrialBalance(box);
		// String jsp = "responseForSubGroupWiseTrialBalane";
		String jsp = "subGroupWiseTrialBalance.jsp";
		map.put("contentJsp", jsp);
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getAccountWiseWiseTrialBalance(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		int locationId = 0;
		if (request.getParameter("subGroupId") != null) {
			int subGroupId = Integer.parseInt(request
					.getParameter("subGroupId"));
			box.put("subGroupId", subGroupId);
		}
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.getAccountWiseTrialBalance(box);
		String jsp = "accountWiseTrialBalance.jsp";
		map.put("contentJsp", jsp);
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getVoucherWiseWiseTrialBalance(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		int locationId = 0;
		if (request.getParameter("accountId") != null) {
			int accountId = Integer.parseInt(request.getParameter("accountId"));
			box.put("accountId", accountId);
		}
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.getVoucherWiseWiseTrialBalance(box);
		String jsp = "voucherWiseTrialBalance.jsp";
		map.put("contentJsp", jsp);
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDayBookJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		map = accountHandlerService.showDayBookJsp(box);
		String jsp = "dayBook.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView displayDayBook(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.displayDayBook(box);
		String jsp = "fa_day.jsp";
		map.put("contentJsp", jsp);
		map.put("mainAccountId", box.getInt(ACCOUNT_ID));
		map.put("accountName", box.getString("accountName"));
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showChequeDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.showChequeDetailJsp(box);
		String jsp = "fa_chequeDetail.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitChequeDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
		}

		map = accountHandlerService.submitChequeDetail(box);
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Cheque Book Detail Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "fa_chequeDetail.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showChequePrintingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.showChequePrintingJsp(box);
		String jsp = "fa_chequePrinting.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView cancelCheque(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
		}

		map = accountHandlerService.cancelCheque(box);
		/*
		 * boolean saved = false; String message = ""; if(map.get("saved") !=
		 * null){ saved = (Boolean)map.get("saved"); } if(saved){ message =
		 * "Cheque Detail Saved Successfully."; }else{ message = "Try Again!"; }
		 * map.put("message", message);
		 */
		String jsp = "fa_chequePrinting.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getChequeDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		map = accountHandlerService.getChequeDetail(box);
		String jsp = "";
		jsp = "responseForChequePrinting";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printCheque(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
		}
		String payee = "";
		if (request.getParameter("payee") != null) {
			payee = request.getParameter("payee");
		}
		String amtInWords = "";
		if (request.getParameter("amtInWords") != null) {
			amtInWords = request.getParameter("amtInWords");
		}
		BigDecimal amount = new BigDecimal(0.0);
		if (request.getParameter("amount") != null) {
			amount = new BigDecimal(request.getParameter("amount"));
		}

		parameters.put("payee", payee);
		parameters.put("amtInWords", amtInWords);
		parameters.put("amount", amount);

		detailsMap = accountHandlerService.getConnectionForReport();

		HMSUtil.generateReport("accounts_cheque_format", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showFixedDepositRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.showFixedDepositRegisterJsp(box);
		String jsp = "fixedDepositRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitFixedDepositRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
		}
		map = accountHandlerService.submitFixedDepositRegister(box);
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Data Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "fixedDepositRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editFixedDepositRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int fdRegisterId = 0;
		if (request.getParameter("fdRegisterId") != null) {
			fdRegisterId = Integer.parseInt(request
					.getParameter("fdRegisterId"));
			box.put("fdRegisterId", fdRegisterId);
		}
		map = accountHandlerService.editFixedDepositRegister(box);
		String jsp = "fixedDepositRegisterResponse";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView updateFixedDepositRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.updateFixedDepositRegister(box);
		String jsp = "fixedDepositRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	
	
	public ModelAndView showProfitAndLossAccountJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> centreList = new ArrayList<Object[]>();	
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}
		
	     String BalanceSheetType= "";
	     if(request.getParameter("Type") != null)
	     {
		 BalanceSheetType = request.getParameter("Type");
		 box.put("BalanceSheetType", BalanceSheetType);
	     }
			String unitType="";
			  if(session.getAttribute("unitType") != null)
			  {
				  unitType = (String)session.getAttribute("unitType");
			  }
			  
			  int locationId = 0;
			  if(unitType.equalsIgnoreCase("HO"))
			  {
				  if(request.getParameter("ddlLocation") !=  null)
				  {
					  locationId = Integer.parseInt(request.getParameter("ddlLocation"));
						box.put("locationId", locationId);
						box.put("BalanceSheetType", "FILTER");
				  }
			  }
			  else
			  {
				  if (session.getAttribute("locationId") != null) {
						locationId = (Integer) session.getAttribute("locationId");
						box.put("locationId", locationId);
						box.put("BalanceSheetType", "FILTER");
					}
			  }
			 centreList = marketingHandlerService.getCentreList();
			map = accountHandlerService.showProfitAndLossAccountJsp(box);
			String jsp = "profitAndLossAccount.jsp";
			map.put("contentJsp", jsp);
			 map.put("centreList", centreList);
			return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayScheduleDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		/*int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}*/
		
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		String pageType="NA";
		
		if(request.getParameter("pageType") != null)
		{
			pageType = request.getParameter("pageType");
		}
		
				
		String BalanceSheetType= "";
	     if(request.getParameter("BalanceSheetType") != null)
	     {
	    	 BalanceSheetType = request.getParameter("BalanceSheetType");
	    	 box.put("BalanceSheetType", BalanceSheetType);
	     }
	       
			String unitType="";
			  if(session.getAttribute("unitType") != null)
			  {
				  unitType = (String)session.getAttribute("unitType");
			  }
			  
			  int locationId = 0;
			 /* if(unitType.equalsIgnoreCase("HO"))
			  {
				  
				  if(request.getParameter("ddlLocation") !=  null)
				  {
					  locationId = Integer.parseInt(request.getParameter("ddlLocation"));
						box.put("locationId", locationId);
						box.put("BalanceSheetType", "FILTER");
						
				  }else{
					  box.put("BalanceSheetType", "ALL");
				  }
				 
			  }
			  else
			  {
				  if (session.getAttribute("locationId") != null) {
						locationId = (Integer) session.getAttribute("locationId");
						box.put("locationId", locationId);
						box.put("BalanceSheetType", "FILTER");
					
						
					}
			  }	*/
			  if (session.getAttribute("hospitalId") != null) {
					locationId = (Integer) session.getAttribute("hospitalId");
					box.put("locationId", locationId);
					box.put("BalanceSheetType", "ALL");
				}
			  
			  
		map = accountHandlerService.displayScheduleDetail(box);

		String jsp = "schedule.jsp";
		map.put("contentJsp", jsp);
		map.put("currentYearDesc", box.getString("currentYearDesc"));
		map.put("lastYearDesc", box.getString("lastYearDesc"));
		map.put("particular", box.getString("particular"));
		map.put("schedule", box.getInt("schedule"));
		//map.put("BalanceSheetType", "FILTER");
		map.put("pageType", pageType);
		map.put("locationId", String.valueOf(locationId));

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBalanceSheet(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> centreList = new ArrayList<Object[]>();	
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
     String BalanceSheetType= "";
     if(request.getParameter("Type") != null)
     {
    	 BalanceSheetType = request.getParameter("Type");
    	 box.put("BalanceSheetType", BalanceSheetType);
     }
		String unitType="";
		  if(session.getAttribute("unitType") != null)
		  {
			  unitType = (String)session.getAttribute("unitType");
		  }
		  
		  int locationId = 0;
		  
		  if (session.getAttribute("hospitalId") != null) {
				locationId = (Integer) session.getAttribute("hospitalId");
				box.put("locationId", locationId);
				box.put("BalanceSheetType", "FILTER");
			}
		  
	/*	  if(unitType.equalsIgnoreCase("HO"))
		  {
			  if(request.getParameter("ddlLocation") !=  null)
			  {
				  locationId = Integer.parseInt(request.getParameter("ddlLocation"));
					box.put("locationId", locationId);
					box.put("BalanceSheetType", "FILTER");
			  }
			  else{
				  box.put("BalanceSheetType", "ALL");
				  
			  }
			  
		  }
		  else
		  {
			  if (session.getAttribute("locationId") != null) {
					locationId = (Integer) session.getAttribute("locationId");
					box.put("locationId", locationId);
					box.put("BalanceSheetType", "FILTER");
				}
		  }*/
		/*centreList = marketingHandlerService.getCentreAndHOList();*/
		map = accountHandlerService.showBalanceSheet(box);
		String jsp = "fa_balanceSheet.jsp";
		map.put("contentJsp", jsp);
		 map.put("centreList", centreList);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEMDRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		/*int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}*/
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.showEMDRegisterJsp(box);
		String jsp = "fa_emdRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/*public ModelAndView submitEMDRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
		}
		map = accountHandlerService.submitEMDRegister(box);
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "EMD Register Saved Successfully.Do you want to print ?";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		map.put("saved", saved);
		String jsp = "fa_emdRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}*/
	
	
	public ModelAndView submitEMDRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
		}
		map = accountHandlerService.submitEMDRegister(box);
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "EMD Register Saved Successfully.Do you want to print ?";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		map.put("saved", saved);
		String jsp = "fa_emdRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editEMDRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int emdRegisterId = 0;
		if (request.getParameter("emdRegisterId") != null) {
			emdRegisterId = Integer.parseInt(request
					.getParameter("emdRegisterId"));
			box.put("emdRegisterId", emdRegisterId);
		}
		map = accountHandlerService.editEMDRegister(box);
		String jsp = "fa_emdRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateEmdDepositRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		int emdRegisterId = 0;
		
		if (request.getParameter("emdRegisterId") != null) {
			emdRegisterId = Integer.parseInt(request.getParameter("emdRegisterId"));
			box.put("emdRegisterId", emdRegisterId);
		}
		
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		/*if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}*/
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.updateEmdDepositRegister(box);
		String jsp = "fa_emdRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAgingAnalysisJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.showAgingAnalysisJsp(box);
		String jsp = "fa_agingAnalysis.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayAgingAnalysis(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.displayAgingAnalysis(box);
		String jsp = "fa_aging.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView printAgingAnalysis(HttpServletRequest
	 * request,HttpServletResponse response) { Map<String, Object> detailsMap =
	 * new HashMap<String, Object>(); Map<String, Object> parameters = new
	 * HashMap<String, Object>(); HttpSession session = request.getSession();
	 * int hospital_id = 0; String qry="";
	 * if(session.getAttribute(HOSPITAL_ID)!= null){ hospital_id =
	 * (Integer)session.getAttribute(HOSPITAL_ID); }
	 * 
	 * int center=0; if(request.getParameter("center")!=null){
	 * center=Integer.parseInt(request.getParameter("center"));
	 * qry="and h.location_id="+center; } parameters.put("hospital_id",
	 * hospital_id); parameters.put("qry", qry);
	 * 
	 * detailsMap = accountHandlerService.getConnectionForReport();
	 * 
	 * HMSUtil.generateReport("fa_aging_analysis", parameters, (Connection)
	 * detailsMap.get("conn"), response, getServletContext());
	 * 
	 * return null; }
	 */

	public void getCenterList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		map = accountHandlerService.getCenterList(box);
		if (map.get("hospitalList") != null) {
			hospitalList = (List<MasHospital>) map.get("hospitalList");
		}
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<customer>");
			for (MasHospital masHospital : hospitalList) {
				sb.append("<cu>");
				sb.append("<centerId>" + masHospital.getId() + "</centerId>");
				sb.append("<centerName>" + masHospital.getHospitalName()
						+ "</centerName>");
				sb.append("</cu>");
			}

			sb.append("</customer>");
			sb.append("</item>");
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

	public ModelAndView showInvoiceMappingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		// map = accountHandlerService.showIpSalesVoucherMappingJsp(box);

		String jsp = "fa_invoice_voucher.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView dispalyInvoiceBillingAmount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.dispalyInvoiceBillingAmount(box);
		String jsp = "fa_invoice_voucher.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView postInvoiceVoucherMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postInvoiceVoucherMapping(box);
		boolean saved = false;
		String message = "";
		String jsp="";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Data Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		
		if(map.get("dispensingId")!=null){
			jsp = "fa_invoice_voucher.jsp";
			
		}else if(map.get("rskPaymentId")!=null){
			jsp = "rsk_payment_voucher.jsp";
			
		}else if(map.get("rskSalesReturnId")!=null){
			jsp = "fa_invoice_settlement.jsp";
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showInvoiceSettlementJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		// map = accountHandlerService.showIpSalesVoucherMappingJsp(box);

		String jsp = "fa_invoice_settlement.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayInvoiceSettlement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.displayInvoiceSettlement(box);
		String jsp = "fa_invoice_settlement.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView postInvoiceSettlementVoucherMapping(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postInvoiceSettlementVoucherMapping(box);
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Data Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "fa_invoice_settlement.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCashSettlementJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		// map = accountHandlerService.showIpSalesVoucherMappingJsp(box);

		String jsp = "fa_cash_settlement.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayCashSettlement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.displayCashSettlement(box);

		String jsp = "fa_cash_settlement.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView postCashSettlementVoucherMapping(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postCashSettlementVoucherMapping(box);
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Data Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "fa_cash_settlement.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSRNMappingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		// map = accountHandlerService.showIpSalesVoucherMappingJsp(box);

		String jsp = "fa_srn_mapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displaySRNMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.displaySRNMapping(box);

		String jsp = "fa_srn_mapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView postSrnMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postSrnMapping(box);
		String jsp = "fa_srn_mapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPayrollMappingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.showPayrollMappingJsp(box);
		String jsp = "fa_payroll_mapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayPayrollMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.displayPayrollMapping(box);

		String jsp = "fa_payroll_mapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEmployeePayrollPopupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.showEmployeePayrollPopupJsp(box);
		String jsp = "fa_employeePayrollPopup";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showLegalApplicationMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		// map = accountHandlerService.showLegalApplicationMapping(box);
		String jsp = "fa_legalApplication_mapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayLegalApplicationMapping(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.displayLegalApplicationMapping(box);

		String jsp = "fa_legalApplication_mapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView postLegalApplicationMapping(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postLegalApplicationMapping(box);
		String jsp = "fa_legalApplication_mapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateReportForGeneralMasters(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		int storeId = 0;
		String hospitalName = "";
		String qry = "";
		if (session.getAttribute("hospitalId") != null) {
			storeId = (Integer) session.getAttribute("hospitalId");
			mapForDs.put("storeId", storeId);
			mapResponse = accountHandlerService.getHospitalName(mapForDs);
		}
		if (mapResponse.get("masHospitaList") != null) {
			masHospitaList = (List) mapResponse.get("masHospitaList");
			hospitalName = masHospitaList.get(0).getHospitalName();
		}

		String jasper = null;
		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		
	if(request.getParameter("flag") != null && request.getParameter("flag").equals("grower")){
			
			qry = " where fa_mas_sub_led.grower_id is not null ";
		}
		
		else if(request.getParameter("flag") != null && request.getParameter("flag").equals("rsk")){
        	
			qry = " where fa_mas_sub_led.rsk_id is not null ";
		
		}
		else if(request.getParameter("flag") == null)
		{
			qry = " where fa_mas_sub_led.grower_id is null and fa_mas_sub_led.rsk_id is null ";
		}
	
	    System.out.println("qry"+qry);
		parameters.put("query", qry);
		parameters.put("hospitalName", hospitalName);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/reports/"));

		Map<String, Object> connectionMap = accountHandlerService
				.getConnection();

		HMSUtil.generateReport(jasper, parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());

		return null;
	}

	// -------------------- Ledger Report
	/*
	 * public ModelAndView printLedgerReport(HttpServletRequest
	 * request,HttpServletResponse response) { Map<String, Object> detailsMap =
	 * new HashMap<String, Object>(); Map<String, Object> generalMap = new
	 * HashMap<String, Object>(); Map<String, Object> parameters = new
	 * HashMap<String, Object>(); HttpSession session = request.getSession();
	 * int hospital_id = 0; if (session.getAttribute(HOSPITAL_ID) != null) {
	 * hospital_id = (Integer) session.getAttribute(HOSPITAL_ID); } int
	 * accountId = 0; if(request.getParameter(ACCOUNT_ID)!=null){ accountId =
	 * Integer.parseInt(request.getParameter(ACCOUNT_ID)); } Date
	 * from_date=null; String from_date1="";
	 * if(request.getParameter("from_date")!= null){ from_date =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter("from_date"));
	 * from_date1 =request.getParameter("from_date"); }
	 * 
	 * Date to_date=null; if(request.getParameter("to_date")!= null){ to_date =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter("to_date")); }
	 * 
	 * String prevdate=""; prevdate=HMSUtil.getPrevDate(from_date1,1); Date
	 * prevdate1 = HMSUtil.convertStringTypeDateToDateType(prevdate);
	 * 
	 * generalMap.put("from_date", from_date); generalMap.put("to_date",
	 * to_date); // generalMap.put("prevdate", prevdate);
	 * 
	 * generalMap.put("accountId", accountId);
	 * 
	 * int financialYearId =
	 * accountHandlerService.getFinancialYearList(generalMap);
	 * 
	 * generalMap.put("financialYearId", financialYearId);
	 * 
	 * 
	 * parameters.put("hospital_id", hospital_id); parameters.put("accountId",
	 * accountId); parameters.put("from_date", from_date);
	 * parameters.put("to_date", to_date);
	 * 
	 * detailsMap = accountHandlerService.getConnectionForReport();
	 * 
	 * if(financialYearId != 0 ){
	 * 
	 * HMSUtil.generateReport("ledger", parameters, (Connection)
	 * detailsMap.get("conn"), response, getServletContext()); }
	 * 
	 * return null; }
	 */

	public ModelAndView printLedgerReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospital_id = 0;
		if (session.getAttribute("locationId") != null) {
			hospital_id = (Integer) session.getAttribute("locationId");
		}
		int accountId = 0;
		if (request.getParameter("accId") != null) {
			accountId = Integer.parseInt(request.getParameter("accId"));
		}
		Date from_date = null;
		if (request.getParameter(FROM_DATE) != null) {
			from_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));

		}
		Date to_date = null;
		if (request.getParameter(TO_DATE) != null) {
			to_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));

		}
		
		String userHome = getServletContext().getRealPath("");
		System.out.println("userHome="+userHome);
		String imagePath = userHome+"/jsp/images/logo.jpg";
		parameters.put("path", imagePath);
		
		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospital_id);
		parameters.put("accountId", accountId);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);

		HMSUtil.generateReport("ledger", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView printCashReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		/*int hospital_id = 0;
		if (session.getAttribute("locationId") != null) {
			hospital_id = (Integer) session.getAttribute("locationId");
		}*/
		
	/*	int hospital_id = 0;
		if (request.getParameter("centreHSearchId") != null) {
			hospital_id = Integer.parseInt(request.getParameter("centreHSearchId"));
		}
		else{
		if (session.getAttribute("locationId") != null) {
			hospital_id = (Integer) session.getAttribute("locationId");
			}
		}*/
		int hospital_id = 0;
		
		if (session.getAttribute("hospitalId") != null) {
			hospital_id = (Integer) session.getAttribute("hospitalId");
			}
		
		int accountId = 0;
		if (request.getParameter("accId") != null) {
			accountId = Integer.parseInt(request.getParameter("accId"));
		}
		Date from_date = null;
		if (request.getParameter(FROM_DATE) != null) {
			from_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));

		}
		Date to_date = null;
		if (request.getParameter(TO_DATE) != null) {
			to_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));

		}
		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospital_id);
		parameters.put("accountId", accountId);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);

		HMSUtil.generateReport("Cash", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;

	}

	public ModelAndView printBankBookReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		/*int hospital_id = 0;
		if (session.getAttribute("locationId") != null) {
			hospital_id = (Integer) session.getAttribute("locationId");
		}*/
		
		
	/*	if (request.getParameter("centreHSearchId") != null) {
			hospital_id = Integer.parseInt(request.getParameter("centreHSearchId"));
		}
		else{
		if (session.getAttribute("locationId") != null) {
			hospital_id = (Integer) session.getAttribute("locationId");
		}
		}*/
		
		int hospital_id = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospital_id = (Integer) session.getAttribute("hospitalId");
		}
		
		int accountId = 0;
		if (request.getParameter("accId") != null) {
			accountId = Integer.parseInt(request.getParameter("accId"));
		}
		Date from_date = null;
		if (request.getParameter(FROM_DATE) != null) {
			from_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));

		}
		Date to_date = null;
		if (request.getParameter(TO_DATE) != null) {
			to_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));

		}
		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospital_id);
		parameters.put("accountId", accountId);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);

		HMSUtil.generateReport("bankBook", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;

	}

	public ModelAndView printDayReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospital_id = 0;
		if (session.getAttribute("locationId") != null) {
			hospital_id = (Integer) session.getAttribute("locationId");
		}
		int accountId = 0;
		if (request.getParameter("accId") != null) {
			accountId = Integer.parseInt(request.getParameter("accId"));
		}
		Date from_date = null;
		if (request.getParameter(FROM_DATE) != null) {
			from_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));

		}
		Date to_date = null;
		if (request.getParameter(TO_DATE) != null) {
			to_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));

		}
		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospital_id);
		parameters.put("accountId", accountId);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);

		HMSUtil.generateReport("dayBook", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;

	}

	public ModelAndView printTrialReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospital_id = 0;
		int fYear=0;
		if (session.getAttribute("hospitalId") != null) {
			hospital_id = (Integer) session.getAttribute("hospitalId");
		}
		String accountType = "";
		if (request.getParameter("accountType") != null) {
			accountType = (request.getParameter("accountType"));
		}
		Date from_date = null;
		if (request.getParameter(FROM_DATE) != null) {
			from_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));

		}
		Date to_date = null;
		if (request.getParameter(TO_DATE) != null) {
			to_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));

		}
		/*if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			
		}*/
		
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		fYear =  msf.getId();
		
System.out.println(hospital_id);
System.out.println(from_date);
System.out.println(to_date);
System.out.println(fYear);
		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospital_id);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);
		parameters.put("year_id", fYear);

		if (accountType.equals("group")) {
			HMSUtil.generateReport("trialGroup", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (accountType.equals("subgroup")) {
			HMSUtil.generateReport("trailSubGroup", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (accountType.equals("account")) {
			HMSUtil.generateReport("trailAccount", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}
		return null;
	}

	/*public ModelAndView printEmdRegId(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospital_id = 0;
		if (session.getAttribute("locationId") != null) {
			hospital_id = (Integer) session.getAttribute("locationId");
		}
		int emdRegId = 0;
		if (request.getParameter("emdRegId") != null) {
			emdRegId = Integer.parseInt(request.getParameter("emdRegId"));
		}

		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospital_id);
		parameters.put("emdRegId", emdRegId);

		HMSUtil.generateReport("BG_EMD_Register_Id", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}*/

	public ModelAndView printEmdRegId(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		HttpSession session = request.getSession();
		
		
		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";        
		parameters.put("path", imagePath);
		
		int hospital_id = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospital_id = (Integer) session.getAttribute("hospitalId");
			mapForDs.put("storeId", hospital_id);
			mapResponse = accountHandlerService.getHospitalName(mapForDs);
		}
		
		String hospitalName="";
		if (mapResponse.get("masHospitaList") != null) {
			masHospitaList = (List) mapResponse.get("masHospitaList");
			hospitalName = masHospitaList.get(0).getHospitalName();
			parameters.put("hospitalName", hospitalName);
		}
		
		int emdRegId = 0;
		if (request.getParameter("emdRegId") != null) {
			emdRegId = Integer.parseInt(request.getParameter("emdRegId"));
		}

		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospital_id);
		parameters.put("emdRegId", emdRegId);

		HMSUtil.generateReport("BG_EMD_Register_Id", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}
	
	public ModelAndView printEmdRegRpt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		jsp = "emdRegRpt";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateEmdRegRpt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int storeId = 0;
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		Date fromDate = null;
		Date toDate = null;
		String hospitalName = "";
		try {
			int hospital_id = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
				mapForDs.put("storeId", hospital_id);
				mapResponse = accountHandlerService.getHospitalName(mapForDs);
			}
			if (mapResponse.get("masHospitaList") != null) {
				masHospitaList = (List) mapResponse.get("masHospitaList");
				hospitalName = masHospitaList.get(0).getHospitalName();
				requestParameters.put("hospitalName", hospitalName);
			}

			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType((request
						.getParameter(FROM_DATE)));

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType((request
						.getParameter(TO_DATE)));

			}

			requestParameters.put("fromDate", fromDate);

			requestParameters.put("fromDate", fromDate);
			requestParameters.put("toDate", toDate);

			Map<String, Object> conMap = accountHandlerService.getConnection();

			HMSUtil.generateReport("BG_EMD_Register", requestParameters,
					(Connection) conMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public ModelAndView postPayrollVoucherMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postPayrollVoucherMapping(box);
		String jsp = "fa_payroll_mapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------- Insurance Details

	public ModelAndView showHrInsuranceDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			generalMap.put("locationId", locationId);
		}
		map = accountHandlerService.showHrInsuranceDetailsJsp(generalMap);
		String jsp = "hrInsuranceDetails";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchHrInsuranceDetailsJsp(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String insuranceDetailsName = null;

		if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
			insuranceDetailsName = request.getParameter(SEARCH_FIELD);
		}
		map = accountHandlerService.searchHrInsuranceDetailsJsp(insuranceDetailsName);
		String jsp="hrInsuranceDetails";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("insuranceDetailsName",insuranceDetailsName);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addInsuranceDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		HrInsuranceDetails hrInsuranceDetails=new HrInsuranceDetails();
		String name = "";
		String discription = "";
		String cover = "";
		Date detailsDate=null;
		Date nextPremiumDate=null;
		int userId = 0;
		int insuranceTypeId = 0;
		BigDecimal amount = new BigDecimal(0.0);
		BigDecimal premium = new BigDecimal(0.0);
		HttpSession session = request.getSession();
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		
		String title = "";
		String message = "";
		String currentTime = "";
		String pojoPropertyName = "";
		String pojoName = "";
		
		if (request.getParameter("discription") != null) {
			discription = request.getParameter("discription");
		}
		System.out.println(request.getParameter(SEARCH_NAME));
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter("cover") != null && !(request.getParameter("cover").equals(""))){
			cover = request.getParameter("cover");
		}
		if(request.getParameter("detailsDate") != null && !(request.getParameter("detailsDate").equals(""))){
			detailsDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("detailsDate"));
		}
		if(request.getParameter("nextPremiumDate") != null && !(request.getParameter("nextPremiumDate").equals(""))){
			nextPremiumDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("nextPremiumDate"));
		}
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}
		if (request.getParameter("insuranceTypeId") != null && !request.getParameter("insuranceTypeId").equals("0")) {
			insuranceTypeId = Integer.parseInt(request.getParameter("insuranceTypeId"));
		}
		
		if (request.getParameter("amount") != null) {
			amount = new BigDecimal(request.getParameter("amount"));
		}
		if (request.getParameter("premium") != null) {
			premium = new BigDecimal(request.getParameter("premium"));
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
		
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		System.out.println(name);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = mastersHandlerService.checkForExistingMasters(generalMap);
		List insuranceDetailsNameList = new  ArrayList();
		if(listMap.get("duplicateGeneralNameList") != null){
			insuranceDetailsNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		System.out.println("insuranceDetailsNameList------>"+insuranceDetailsNameList.size());
		if((insuranceDetailsNameList.size() == 0 || insuranceDetailsNameList == null) && (insuranceDetailsNameList.size() == 0 || insuranceDetailsNameList == null))
		{
				
			hrInsuranceDetails.setInsuranceName(name);
			hrInsuranceDetails.setDiscription(discription);
			hrInsuranceDetails.setCover(cover);
			hrInsuranceDetails.setDate(detailsDate);
			hrInsuranceDetails.setNextPremiumDate(nextPremiumDate);
			hrInsuranceDetails.setAmount(amount);
			hrInsuranceDetails.setPremium(premium);
			Users user = new Users();
			user.setId(userId);
			
			HrMasInsurance insuranceType = new HrMasInsurance();
			insuranceType.setId(insuranceTypeId);
			hrInsuranceDetails.setInsuranceType(insuranceType);
			int locationId = 0;
			if (session.getAttribute("hospitalId") != null) {
				 locationId = (Integer) session.getAttribute("hospitalId");
			//	generalMap.put("locationId", locationId);
			}
			MasHospital mh=new MasHospital();
			mh.setId(locationId);
			hrInsuranceDetails.setLocation(mh);
			
			hrInsuranceDetails.setLastChgBy(user);
			hrInsuranceDetails.setLastChgDate(currentDate);
			hrInsuranceDetails.setStatus("y");
			successfullyAdded = accountHandlerService.addHrInsuranceDetails(hrInsuranceDetails);		

			if(successfullyAdded){
				message="Record Added Successfully !!";
			}
			else{
				message="Try Again !!";
			}
		}
		else if((insuranceDetailsNameList.size() != 0) || insuranceDetailsNameList != null)
		{
			if((insuranceDetailsNameList.size() != 0 || insuranceDetailsNameList != null) ){
				message = "Insurance Name already exists.";
			}
		}
		try{
			Map<String, Object> gg = new HashMap<String, Object>();
			if (session.getAttribute("locationId") != null) {
				int locationId = (Integer) session.getAttribute("locationId");
				gg.put("locationId", locationId);
			}
			map = accountHandlerService.showHrInsuranceDetailsJsp(gg);
		}catch (Exception e) {
			e.printStackTrace();
		}
		String jsp="hrInsuranceDetails";
		title="Add Insurance";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editInsuranceDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		String insuranceDetailsName = "";
		String discription = "";
		String cover = "";
		Date detailsDate=null;
		Date nextPremiumDate=null;
		int userId = 0;
		BigDecimal amount = new BigDecimal(0.0);
		BigDecimal premium = new BigDecimal(0.0);
		int insuranceDetailsId = 0;
		
		Date changedDate = null;
		String changedTime = "";
		int insuranceTypeId=0;
		String title = "";
		String message = "";
		String url = "";
		String pojoPropertyName = "";
		String pojoName = "";
		HttpSession session = request.getSession();
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			insuranceDetailsId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			insuranceDetailsName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("discription") != null) {
			discription = request.getParameter("discription");
		}
		if (!request.getParameter("insuranceTypeId").equals("0") && request.getParameter("insuranceTypeId") != null) {
			insuranceTypeId = Integer.parseInt(request.getParameter("insuranceTypeId"));
		}
		if(request.getParameter("cover") != null && !(request.getParameter("cover").equals(""))){
			cover = request.getParameter("cover");
		}
		if(request.getParameter("detailsDate") != null && !(request.getParameter("detailsDate").equals(""))){
			detailsDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("detailsDate"));
		}
		if(request.getParameter("nextPremiumDate") != null && !(request.getParameter("nextPremiumDate").equals(""))){
			nextPremiumDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("nextPremiumDate"));
		}
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}
		if (request.getParameter("amount") != null) {
			amount = new BigDecimal(request.getParameter("amount"));
		}
		if (request.getParameter("premium") != null) {
			premium = new BigDecimal(request.getParameter("premium"));
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

		generalMap.put("id", insuranceDetailsId);
		generalMap.put("discription", discription);
		generalMap.put("name", insuranceDetailsName);
		generalMap.put("cover", cover);
		generalMap.put("detailsDate", detailsDate);
		generalMap.put("nextPremiumDate", nextPremiumDate);
		generalMap.put("userId", userId);
		generalMap.put("amount", amount);
		generalMap.put("premium", premium);
		generalMap.put("insuranceTypeId", insuranceTypeId);		
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = mastersHandlerService.checkForExistingMasters(generalMap);
		List existingInsuranceDetailsNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingInsuranceDetailsNameList.size() == 0)
		{
		dataUpdated=accountHandlerService.editHrInsuranceDetailsToDatabase(generalMap);

		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant be updated !!";
		}
		} 
		else if(existingInsuranceDetailsNameList.size() > 0){
			message = "Name already exists.";
		}
		url = "/hms/hms/account?method=showHrInsuranceDetailsJsp";
		
		try{
			Map<String, Object> gg = new HashMap<String, Object>();
			if (session.getAttribute("locationId") != null) {
				int locationId = (Integer) session.getAttribute("locationId");
				gg.put("locationId", locationId);
			}
			map = accountHandlerService.showHrInsuranceDetailsJsp(gg);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		String jsp="hrInsuranceDetails";
		title="update Unit";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteInsuranceDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int insuranceDetailsId=0;
		String message=null;
		String changedTime = "";
		int userId=0;
		HttpSession session = request.getSession();
		Date changedDate = null;
		String flag ="";
		String title="";
		String url="";
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			insuranceDetailsId =Integer.parseInt( request.getParameter(COMMON_ID));
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
		dataDeleted=accountHandlerService.deleteHrInsuranceDetails(insuranceDetailsId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/account?method=showHrInsuranceDetailsJsp";
		
		try{
			Map<String, Object> gg = new HashMap<String, Object>();
			if (session.getAttribute("locationId") != null) {
				int locationId = (Integer) session.getAttribute("locationId");
				gg.put("locationId", locationId);
			}
			map = accountHandlerService.showHrInsuranceDetailsJsp(gg);
		}catch (Exception e) {
			e.printStackTrace();
		}
		String jsp="hrInsuranceDetails";
		title="delete Insurance Details";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showProductionJournalVoucher(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		//map = accountHandlerService.showProductionJournalVoucher(box);
		String jsp = "fa_production_journal_voucher.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView displayProductionJournalVoucherMapping(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.displayProductionJournalVoucherMapping(box);

		String jsp = "fa_production_journal_voucher.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView postProductionMapping(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		
		/*String crSubLedId="";
		if (request.getParameter("crSubLedId") != null && !request.getParameter("crSubLedId").isEmpty() && (Integer.parseInt(request.getParameter("crSubLedId")))!=0) {
			crSubLedId= request.getParameter("crSubLedId");
			box.put("crSubLedId", crSubLedId);
		}*/
		
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postProductionMapping(box);
		String jsp = "fa_production_journal_voucher.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showMarketingMappingJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		String jsp = "fa_marketing_mapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView displayMarketingMapping(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.displayMarketingMapping(box);

		String jsp = "fa_marketing_mapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showMarketingSubLedgerPopupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		if(request.getParameter("fromDate")!= null){
			fromDate =  HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromDate"));
			generalMap.put("fromDate", fromDate);
		}
		if(request.getParameter("toDate")!= null){
			toDate =  HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate"));
		}
		
		generalMap.put("toDate", toDate);
		map = accountHandlerService.showMarketingSubLedgerPopupJsp(generalMap);
		String jsp = "marketingSubLedgerPopup";
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView postMarketingMapping(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postMarketingMapping(box);
		String jsp = "fa_marketing_mapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
		
	/* public ModelAndView generateExcelProfitAndLossAccountJsp(HttpServletRequest request,
				HttpServletResponse response) {
			List<AccountMainTransac> currentFinancialYearAccountList = new ArrayList<AccountMainTransac>();
			List<AccountMainTransac> lastFinancialYearAccountList = new ArrayList<AccountMainTransac>();
			List<Object[]> centreList = new ArrayList<Object[]>();
			int lastYearDesc = 0;
			int currentYearDesc = 0;
			Map<String, Object> mapResponse = new HashMap<String, Object>();
			Map<String, Object> mapForDs = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
			Box box = HMSUtil.getBox(request);
			int financialYearId = 0;
			String hospitalName = "";
			if (session.getAttribute("financialYear") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear");
				box.put("fYear", financialYearId);
			}
			
			 String BalanceSheetType= "";
		     if(request.getParameter("Type") != null)
		     {
		    	 BalanceSheetType = request.getParameter("Type");
		    	 box.put("BalanceSheetType", BalanceSheetType);
		     }
				String unitType="";
				  if(session.getAttribute("unitType") != null)
				  {
					  unitType = (String)session.getAttribute("unitType");
				  }
				  
				  int locationId = 0;
				  if(unitType.equalsIgnoreCase("HO"))
				  {
					  if(request.getParameter("ddlLocation") !=  null)
					  {
						  locationId = Integer.parseInt(request.getParameter("ddlLocation"));
							box.put("locationId", locationId);
							box.put("BalanceSheetType", "FILTER");
							mapForDs.put("storeId", locationId);
							mapResponse = accountHandlerService.getHospitalName(mapForDs);
					  }
				  }
				  else
				  {
					  if (session.getAttribute("locationId") != null) {
							locationId = (Integer) session.getAttribute("locationId");
							box.put("locationId", locationId);
							box.put("BalanceSheetType", "FILTER");
							mapForDs.put("storeId", locationId);
							mapResponse = accountHandlerService.getHospitalName(mapForDs);
						}
				  }

			
		
		if(locationId != 0)
		{
			if (mapResponse.get("masHospitaList") != null) {
				masHospitaList = (List) mapResponse.get("masHospitaList");
				hospitalName = masHospitaList.get(0).getHospitalName();
				
			}
		}
		
		BigDecimal currentCrBalance18 = new BigDecimal(0.00);
		BigDecimal currentDrBalance18 = new BigDecimal(0.00);
		BigDecimal currentCrBalance19 = new BigDecimal(0.00);
		BigDecimal currentDrBalance19 = new BigDecimal(0.00);
		BigDecimal currentCrBalance20 = new BigDecimal(0.00);
		BigDecimal currentDrBalance20 = new BigDecimal(0.00);
		BigDecimal currentCrBalance21 = new BigDecimal(0.00);
		BigDecimal currentDrBalance21 = new BigDecimal(0.00);
		BigDecimal currentCrBalance22 = new BigDecimal(0.00);
		BigDecimal currentDrBalance22 = new BigDecimal(0.00);
		BigDecimal currentCrBalance23 = new BigDecimal(0.00);
		BigDecimal currentDrBalance23 = new BigDecimal(0.00);
		BigDecimal currentCrBalance24 = new BigDecimal(0.00);
		BigDecimal currentDrBalance24 = new BigDecimal(0.00);
		BigDecimal currentCrBalance25 = new BigDecimal(0.00);
		BigDecimal currentDrBalance25 = new BigDecimal(0.00);
		BigDecimal currentCrBalance26 = new BigDecimal(0.00);
		BigDecimal currentDrBalance26 = new BigDecimal(0.00);
		BigDecimal currentSchedule18Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule19Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule20Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule21Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule22Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule23Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule24Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule25Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule26Amt = new BigDecimal(0.00);

		
		BigDecimal lastCrBalance18 = new BigDecimal(0.00);
		BigDecimal lastDrBalance18 = new BigDecimal(0.00);
		BigDecimal lastCrBalance19 = new BigDecimal(0.00);
		BigDecimal lastDrBalance19 = new BigDecimal(0.00);
		BigDecimal lastCrBalance20 = new BigDecimal(0.00);
		BigDecimal lastDrBalance20 = new BigDecimal(0.00);
		BigDecimal lastCrBalance21 = new BigDecimal(0.00);
		BigDecimal lastDrBalance21 = new BigDecimal(0.00);
		BigDecimal lastCrBalance22 = new BigDecimal(0.00);
		BigDecimal lastDrBalance22 = new BigDecimal(0.00);
		BigDecimal lastCrBalance23 = new BigDecimal(0.00);
		BigDecimal lastDrBalance23 = new BigDecimal(0.00);
		BigDecimal lastCrBalance24 = new BigDecimal(0.00);
		BigDecimal lastDrBalance24 = new BigDecimal(0.00);
		BigDecimal lastCrBalance25 = new BigDecimal(0.00);
		BigDecimal lastDrBalance25 = new BigDecimal(0.00);
		BigDecimal lastCrBalance26 = new BigDecimal(0.00);
		BigDecimal lastDrBalance26 = new BigDecimal(0.00);
		BigDecimal lastSchedule18Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule19Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule20Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule21Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule22Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule23Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule24Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule25Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule26Amt = new BigDecimal(0.00);


		map = accountHandlerService.generateExcelProfitAndLossAccountJsp(box);
			String jsp="";
			
			
			if(map.get("sucFlag") != null && (Boolean)map.get("sucFlag"))
				{
				currentFinancialYearAccountList = (List) map.get("currentFinancialYearAccountList");
				lastFinancialYearAccountList = (List) map.get("lastFinancialYearAccountList");
				currentYearDesc = (Integer) map.get("currentYearDesc");
				lastYearDesc = (Integer) map.get("lastYearDesc");
					try
					{
						response.setContentType("application/vnd.ms-excel");
						response.setHeader("Content-Disposition","attachment; filename=profit_and_loss.xls");
						
						WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
						WritableSheet ws = wb.createSheet("Profit And Loss", 0);
						
						WritableFont wf = new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
						wf.setUnderlineStyle(UnderlineStyle.SINGLE);
						WritableCellFormat wcf = new WritableCellFormat(wf);
						wcf.setAlignment(Alignment.CENTRE);
						
						WritableFont wf2 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
						WritableCellFormat wcf2 = new WritableCellFormat(wf2);
						wcf2.setWrap(true);
						wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
						wcf2.setVerticalAlignment(VerticalAlignment.TOP);
						
						
						WritableFont wf222 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
						WritableCellFormat wcf222 = new WritableCellFormat(wf222);
						wcf222.setWrap(true);
						wcf222.setBorder(Border.ALL, BorderLineStyle.THIN);
						wcf222.setVerticalAlignment(VerticalAlignment.TOP);
						
						WritableFont wf3 = new WritableFont(WritableFont.ARIAL,8);
						WritableCellFormat wcf3 = new WritableCellFormat(wf3);
						wcf3.setWrap(true);
						wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
						wcf3.setVerticalAlignment(VerticalAlignment.TOP);
						
						WritableFont wf4 = new WritableFont(WritableFont.ARIAL,8,WritableFont.BOLD);
						WritableCellFormat wcf4 = new WritableCellFormat(wf4);
						wcf4.setWrap(true);
						wcf4.setVerticalAlignment(VerticalAlignment.TOP);
						
						WritableFont wf22 = new WritableFont(WritableFont.ARIAL,8,WritableFont.NO_BOLD);
						WritableCellFormat wcf22 = new WritableCellFormat(wf22);
						wcf22.setWrap(true);
						wcf22.setBorder(Border.ALL, BorderLineStyle.THIN);
						wcf22.setVerticalAlignment(VerticalAlignment.TOP);
						
						ws.mergeCells(0,0,3,0);
						Label label = new Label(0,0,hospitalName,wcf);
						ws.addCell(label);

						ws.mergeCells(0,1,3,1);
						label = new Label(0,1,"Profit And Loss",wcf);
						ws.addCell(label);
						
			
						label = new Label(3,2,"Date :"+new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
						ws.addCell(label);
						ws.mergeCells(3,2,10,2);
						label = new Label(3,2,new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
						ws.addCell(label);
						
						label = new Label(0,4,"Particulars",wcf2);
						ws.addCell(label);
						label = new Label(1,4,"Note No.",wcf2);
						ws.addCell(label);
						label = new Label(2,4,"For the Year ended 31st March"+ currentYearDesc+"(in Rs.)",wcf2);
						ws.addCell(label);
						label = new Label(3,4,"For the Year ended 31st March"+ lastYearDesc+"(in Rs.)",wcf2);
						ws.addCell(label);
						
						
						label = new Label(0,5,"Revenue",wcf222);
						ws.addCell(label);
						
						label = new Label(0,6,"Revenue from operations",wcf22);
						ws.addCell(label);
						
						label = new Label(0,7,"Other Income",wcf22);
						ws.addCell(label);
						
						label = new Label(0,8,"",wcf22);
						ws.addCell(label);
						
						label = new Label(0,9,"Expenses",wcf222);
						ws.addCell(label);
						
						label = new Label(0,10,"Purchases of Stock-in-Trade",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,11,"Changes in inventories of Stock in trade",wcf22);
						ws.addCell(label);
						
						label = new Label(0,12,"Employee benefits expense",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,13,"Finance Costs",wcf22);
						ws.addCell(label);
						
						label = new Label(0,14,"Depriciation and amortization expense",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,15,"Other expenses",wcf22);
						ws.addCell(label);
						
						label = new Label(0,16,"",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,17,"Profit before prior period items,Exceptional Items tax",wcf22);
						ws.addCell(label);
						
						label = new Label(0,18,"Prior period items(net)",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,19,"Exceptional items",wcf22);
						ws.addCell(label);
						
						label = new Label(0,20,"Profit on Sale of Fixed Asset",wcf22);
						ws.addCell(label);
						

						label = new Label(0,21,"",wcf22);
						ws.addCell(label);
						
						label = new Label(0,22,"Profit before tax",wcf22);
						ws.addCell(label);
						
						label = new Label(0,23,"Less: Tax expense",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,24,"Current tax",wcf22);
						ws.addCell(label);
						
						label = new Label(0,25,"Current tax expense relating to prior years",wcf22);
						ws.addCell(label);
						
						label = new Label(0,26,"Deferred tax",wcf22);
						ws.addCell(label);
						
						label = new Label(0,27,"",wcf22);
						ws.addCell(label);
						
						label = new Label(0,28,"",wcf22);
						ws.addCell(label);
						
						label = new Label(0,29,"Profit for the year",wcf22);
						ws.addCell(label);
						
						label = new Label(0,30,"Earnings per equity share",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,31,"Current tax",wcf22);
						ws.addCell(label);
						
						label = new Label(0,32,"Diluted",wcf22);
						ws.addCell(label);
						
					
						if(currentFinancialYearAccountList.size()>0){
							for(AccountMainTransac masAccount : currentFinancialYearAccountList){
								if(masAccount.getAccount().getSchedule()==18){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance18 =currentCrBalance18.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentDrBalance18 =currentDrBalance18.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance18.compareTo(currentDrBalance18)>0){
										currentSchedule18Amt = currentCrBalance18.subtract(currentDrBalance18);
									}else if(currentDrBalance18.compareTo(currentCrBalance18)>0){
										currentSchedule18Amt = currentDrBalance18.subtract(currentCrBalance18);
									}else if(currentDrBalance18.compareTo(currentCrBalance18)==0){
										currentSchedule18Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getSchedule()==19){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance19 =currentCrBalance19.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentDrBalance19 =currentDrBalance19.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance19.compareTo(currentDrBalance19)>0){
										currentSchedule19Amt = currentCrBalance19.subtract(currentDrBalance19);
									}else if(currentDrBalance19.compareTo(currentCrBalance19)>0){
										currentSchedule19Amt = currentDrBalance19.subtract(currentCrBalance19);
									}else if(currentDrBalance19.compareTo(currentCrBalance19)==0){
										currentSchedule19Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getSchedule()==20){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance20 =currentCrBalance20.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentCrBalance20 =currentCrBalance20.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance20.compareTo(currentDrBalance20)>0){
										currentSchedule20Amt = currentCrBalance20.subtract(currentDrBalance20);
									}else if(currentDrBalance20.compareTo(currentCrBalance20)>0){
										currentSchedule20Amt = currentDrBalance20.subtract(currentCrBalance20);
									}else if(currentDrBalance20.compareTo(currentCrBalance20)==0){
										currentSchedule20Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getSchedule()==21){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance21 =currentCrBalance21.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentDrBalance21 =currentDrBalance21.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance21.compareTo(currentDrBalance21)>0){
										currentSchedule21Amt = currentCrBalance21.subtract(currentDrBalance21);
									}else if(currentDrBalance21.compareTo(currentCrBalance21)>0){
										currentSchedule21Amt = currentDrBalance21.subtract(currentCrBalance21);
									}else if(currentDrBalance21.compareTo(currentCrBalance21)==0){
										currentSchedule21Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getSchedule()==22){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance22 =currentCrBalance22.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentDrBalance22 =currentDrBalance22.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance22.compareTo(currentDrBalance22)>0){
										currentSchedule22Amt = currentCrBalance22.subtract(currentDrBalance22);
									}else if(currentDrBalance22.compareTo(currentCrBalance22)>0){
										currentSchedule22Amt = currentDrBalance22.subtract(currentCrBalance22);
									}else if(currentDrBalance22.compareTo(currentCrBalance22)==0){
										currentSchedule22Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getSchedule()==23){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance23 =currentCrBalance23.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentDrBalance23 =currentDrBalance23.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance23.compareTo(currentDrBalance23)>0){
										currentSchedule23Amt = currentCrBalance23.subtract(currentDrBalance23);
									}else if(currentDrBalance23.compareTo(currentCrBalance23)>0){
										currentSchedule23Amt = currentDrBalance23.subtract(currentCrBalance23);
									}else if(currentDrBalance23.compareTo(currentCrBalance23)==0){
										currentSchedule23Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getSchedule()==24){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance24 =currentCrBalance24.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentDrBalance24 =currentDrBalance24.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance24.compareTo(currentDrBalance24)>0){
										currentSchedule24Amt = currentCrBalance24.subtract(currentDrBalance24);
									}else if(currentDrBalance24.compareTo(currentCrBalance24)>0){
										currentSchedule24Amt = currentDrBalance24.subtract(currentCrBalance24);
									}else if(currentDrBalance24.compareTo(currentCrBalance24)==0){
										currentSchedule24Amt =new BigDecimal(0.00);
									}
								}
								
							if(masAccount.getAccount().getSchedule()==25){
								if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
									currentCrBalance25 =currentCrBalance25.add(masAccount.getClBalanceCr());
								}
								if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
									currentDrBalance25 =currentDrBalance25.add(masAccount.getClBalanceDr());
								}
								if(currentCrBalance25.compareTo(currentDrBalance25)>0){
									currentSchedule25Amt = currentCrBalance25.subtract(currentDrBalance25);
								}else if(currentDrBalance25.compareTo(currentCrBalance25)>0){
									currentSchedule25Amt = currentDrBalance25.subtract(currentCrBalance25);
								}else if(currentDrBalance25.compareTo(currentCrBalance25)==0){
									currentSchedule25Amt =new BigDecimal(0.00);
								}
							}
							if(masAccount.getAccount().getSchedule()==26){
								if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
									currentCrBalance26 =currentCrBalance26.add(masAccount.getClBalanceCr());
								}
								if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
									currentDrBalance26 =currentDrBalance26.add(masAccount.getClBalanceDr());
								}
								if(currentCrBalance26.compareTo(currentDrBalance26)>0){
									currentSchedule26Amt = currentCrBalance26.subtract(currentDrBalance26);
								}else if(currentDrBalance26.compareTo(currentCrBalance26)>0){
									currentSchedule26Amt = currentDrBalance26.subtract(currentCrBalance26);
								}else if(currentDrBalance26.compareTo(currentCrBalance26)==0){
									currentSchedule26Amt =new BigDecimal(0.00);
								}
							}
							
							}
						}
						
						//------------------------for last Year balance----------------------------------//

						if(currentFinancialYearAccountList.size()>0){
							for(AccountMainTransac masAccount : lastFinancialYearAccountList){
								if(masAccount.getAccount().getSchedule()==18){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										lastCrBalance18 =lastCrBalance18.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										lastDrBalance18 =lastDrBalance18.add(masAccount.getClBalanceDr());
									}
									if(lastCrBalance18.compareTo(lastDrBalance18)>0){
										lastSchedule18Amt = lastCrBalance18.subtract(lastDrBalance18);
									}else if(lastDrBalance18.compareTo(lastCrBalance18)>0){
										lastSchedule18Amt = lastDrBalance18.subtract(lastCrBalance18);
									}else if(lastDrBalance18.compareTo(lastCrBalance18)==0){
										lastSchedule18Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getSchedule()==19){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										lastCrBalance19 =lastCrBalance19.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										lastDrBalance19 =lastDrBalance19.add(masAccount.getClBalanceDr());
									}
									if(lastCrBalance19.compareTo(lastDrBalance19)>0){
										lastSchedule19Amt = lastCrBalance19.subtract(lastDrBalance19);
									}else if(lastDrBalance19.compareTo(lastCrBalance19)>0){
										lastSchedule19Amt = lastDrBalance19.subtract(lastCrBalance19);
									}else if(lastDrBalance19.compareTo(lastCrBalance19)==0){
										lastSchedule19Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getSchedule()==20){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										lastCrBalance20 =lastCrBalance20.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										lastCrBalance20 =lastCrBalance20.add(masAccount.getClBalanceDr());
									}
									if(lastCrBalance20.compareTo(lastDrBalance20)>0){
										lastSchedule20Amt = lastCrBalance20.subtract(lastDrBalance20);
									}else if(lastDrBalance20.compareTo(lastCrBalance19)>0){
										lastSchedule20Amt = lastDrBalance20.subtract(lastCrBalance20);
									}else if(lastDrBalance20.compareTo(lastCrBalance20)==0){
										lastSchedule20Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getSchedule()==21){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										lastCrBalance21 =lastCrBalance21.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										lastDrBalance21 =lastDrBalance21.add(masAccount.getClBalanceDr());
									}
									if(lastCrBalance21.compareTo(lastDrBalance21)>0){
										lastSchedule21Amt = lastCrBalance21.subtract(lastDrBalance21);
									}else if(lastDrBalance21.compareTo(lastCrBalance21)>0){
										lastSchedule21Amt = lastDrBalance21.subtract(lastCrBalance21);
									}else if(lastDrBalance21.compareTo(lastCrBalance21)==0){
										lastSchedule21Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getSchedule()==22){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										lastCrBalance22 =lastCrBalance22.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										lastDrBalance22 =lastDrBalance22.add(masAccount.getClBalanceDr());
									}
									if(lastCrBalance22.compareTo(lastDrBalance22)>0){
										lastSchedule22Amt = lastCrBalance22.subtract(lastDrBalance22);
									}else if(lastDrBalance22.compareTo(lastCrBalance22)>0){
										lastSchedule22Amt = lastDrBalance22.subtract(lastCrBalance22);
									}else if(lastDrBalance22.compareTo(lastCrBalance22)==0){
										lastSchedule22Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getSchedule()==23){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										lastCrBalance23 =lastCrBalance23.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										lastDrBalance23 =lastDrBalance23.add(masAccount.getClBalanceDr());
									}
									if(lastCrBalance23.compareTo(lastDrBalance23)>0){
										lastSchedule23Amt = lastCrBalance23.subtract(lastDrBalance23);
									}else if(lastDrBalance23.compareTo(lastCrBalance23)>0){
										lastSchedule23Amt = lastDrBalance23.subtract(lastCrBalance23);
									}else if(lastDrBalance23.compareTo(lastCrBalance23)==0){
										lastSchedule23Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getSchedule()==24){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										lastCrBalance24 =lastCrBalance24.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										lastDrBalance24 =lastDrBalance24.add(masAccount.getClBalanceDr());
									}
									if(lastCrBalance24.compareTo(lastDrBalance24)>0){
										lastSchedule24Amt = lastCrBalance24.subtract(lastDrBalance24);
									}else if(lastDrBalance24.compareTo(lastCrBalance24)>0){
										lastSchedule24Amt = lastDrBalance24.subtract(lastCrBalance24);
									}else if(lastDrBalance24.compareTo(lastCrBalance24)==0){
										lastSchedule24Amt =new BigDecimal(0.00);
									}
								}
								
							if(masAccount.getAccount().getSchedule()==25){
								if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
									lastCrBalance25 =lastCrBalance25.add(masAccount.getClBalanceCr());
								}
								if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
									lastDrBalance25 =lastDrBalance25.add(masAccount.getClBalanceDr());
								}
								if(lastCrBalance25.compareTo(lastDrBalance25)>0){
									lastSchedule25Amt = lastCrBalance25.subtract(lastDrBalance25);
								}else if(lastDrBalance25.compareTo(lastCrBalance25)>0){
									lastSchedule25Amt = lastDrBalance25.subtract(lastCrBalance25);
								}else if(lastDrBalance25.compareTo(lastCrBalance25)==0){
									lastSchedule25Amt =new BigDecimal(0.00);
								}
							}
							if(masAccount.getAccount().getSchedule()==26){
								if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
									lastCrBalance26 =lastCrBalance26.add(masAccount.getClBalanceCr());
								}
								if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
									lastDrBalance26 =lastDrBalance26.add(masAccount.getClBalanceDr());
								}
								if(lastCrBalance26.compareTo(lastDrBalance26)>0){
									lastSchedule26Amt = lastCrBalance26.subtract(lastDrBalance26);
								}else if(lastDrBalance26.compareTo(lastCrBalance26)>0){
									lastSchedule26Amt = lastDrBalance26.subtract(lastCrBalance26);
								}else if(lastDrBalance26.compareTo(lastCrBalance26)==0){
									lastSchedule26Amt =new BigDecimal(0.00);
								}
							}
							
							}
						}
						
						
							BigDecimal totalRevenue = currentSchedule18Amt.add(currentSchedule19Amt);
							BigDecimal totalExpenses =currentCrBalance20.add(currentCrBalance21).add(currentCrBalance22).add(currentCrBalance23).add(currentCrBalance24).add(currentDrBalance25) ;
							
							label = new Label(1,6,"18",wcf3);
							ws.addCell(label);
							label = new Label(2,6,currentSchedule18Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,6,lastSchedule18Amt.toString(),wcf3);
							ws.addCell(label);
							
							
							label = new Label(1,7,"19",wcf3);
							ws.addCell(label);
							label = new Label(2,7,currentSchedule19Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,7,lastSchedule19Amt.toString(),wcf3);
							ws.addCell(label);
							
							label = new Label(2,8,totalRevenue.toString(),wcf3);
							ws.addCell(label);
							
							
							
							label = new Label(1,10,"20",wcf3);
							ws.addCell(label);
							label = new Label(2,10,currentSchedule20Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,10,lastSchedule20Amt.toString(),wcf3);
							ws.addCell(label);
							
							
							label = new Label(1,11,"21",wcf3);
							ws.addCell(label);
							label = new Label(2,11,currentSchedule21Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,11,lastSchedule21Amt.toString(),wcf3);
							ws.addCell(label);
							
												
							
							label = new Label(1,12,"22",wcf3);
							ws.addCell(label);
							label = new Label(2,12,currentSchedule22Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,12,lastSchedule22Amt.toString(),wcf3);
							ws.addCell(label);
							
							
							label = new Label(1,13,"23",wcf3);
							ws.addCell(label);
							label = new Label(2,13,currentSchedule23Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,13,lastSchedule23Amt.toString(),wcf3);
							ws.addCell(label);

							label = new Label(1,14,"24",wcf3);
							ws.addCell(label);
							label = new Label(2,14,currentSchedule24Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,14,lastSchedule24Amt.toString(),wcf3);
							ws.addCell(label);
							
							label = new Label(1,15,"25",wcf3);
							ws.addCell(label);
							label = new Label(2,15,currentSchedule25Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,15,lastSchedule25Amt.toString(),wcf3);
							ws.addCell(label);
							
							
							
							
							label = new Label(2,16,totalExpenses.toString(),wcf3);
							ws.addCell(label);
							
							label = new Label(3,16,lastCrBalance20.add(lastCrBalance21).add(lastCrBalance22).add(lastCrBalance23).add(lastCrBalance24).add(lastDrBalance25).toString(),wcf3);
							ws.addCell(label);
							
							
							label = new Label(2,17,totalRevenue.subtract(totalExpenses).toString(),wcf3);
							ws.addCell(label);
							
							
							label = new Label(1,18,"26",wcf3);
							ws.addCell(label);
							label = new Label(2,18,currentSchedule26Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,18,lastSchedule26Amt.toString(),wcf3);
							ws.addCell(label);
						
						
						CellView cell = new CellView();
					    cell.setSize(8000);
					    ws.setColumnView(0, cell);
					    
					    cell.setSize(6000);
					    ws.setColumnView(2, cell);
					    
					    cell.setSize(6000);
					    ws.setColumnView(3, cell);
					    
					    cell.setSize(600);
					    ws.setColumnView(5, cell);
					    
					    cell.setSize(3000);
					    ws.setColumnView(7, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(10, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(10, cell);
					    
					    cell.setSize(2000);
					    ws.setColumnView(11, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(12, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(13, cell);
					    
					    cell.setSize(2000);
					    ws.setColumnView(14, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(15, cell);
					
						wb.write();
						wb.close();
						return null;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						jsp = "profitAndLossAccount";
						jsp += ".jsp";
						String title = "Profit And Loss";
						map.put("contentJsp", jsp);
						map.put("title", title);
						map.put("message","Some Error Occured");
						return new ModelAndView("index", "map", map);
					}
				}
				else
				{
					centreList = marketingHandlerService.getCentreList();
					 map.put("centreList", centreList);
					jsp = "profitAndLossAccount";
					jsp += ".jsp";
					String title = "Profit And Loss";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message","No Data Found");
					return new ModelAndView("index", "map", map);
				}
							
	 }*/
	 
	 public ModelAndView generateProfitAndLossAccountStatement(HttpServletRequest request,
				HttpServletResponse response) { 
		 try{
				int fYearId = 0;
				int locationId =0;
				String hospitalName = "";
			 
			 Map<String, Object> requestParameters = new HashMap<String, Object>();
			 List<MasHospital> masHospitaList = new ArrayList<MasHospital>();	
			 Map<String, Object> mapResponse = new HashMap<String, Object>();
			 Map<String, Object> mapForDs = new HashMap<String, Object>();
			 
			 HttpSession session = request.getSession();
				
				
			/*	
				if (request.getParameter("fYearId") != null) {
					fYearId = Integer.parseInt(request.getParameter("fYearId"));
					requestParameters.put("fYearId", fYearId);
					
				}*/
				
				MasStoreFinancial msf = new MasStoreFinancial();	
				msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
				requestParameters.put("fYearId", msf.getId());
				 
				if (session.getAttribute("hospitalId") != null) { 
					locationId = Integer.parseInt(session.getAttribute("hospitalId").toString());
					mapForDs.put("storeId", locationId);
					mapResponse = accountHandlerService.getHospitalName(mapForDs);
					if (mapResponse.get("masHospitaList") != null) {
						masHospitaList = (List) mapResponse.get("masHospitaList");
						hospitalName = masHospitaList.get(0).getHospitalName();
						requestParameters.put("hospitalName", hospitalName);
						
					}
					
					requestParameters.put("locationId", locationId);
				}
			
			Map<String, Object> connectionMap = accountHandlerService.getConnection();
			HMSUtil.generateReportExl("profitAndLossStatement", requestParameters,(Connection) connectionMap.get("conn"), response,	getServletContext());
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		 return null;
	 }
	 
	 
	 
	 
	 
	 
	public ModelAndView generateBalanceSheetJsp(HttpServletRequest request,
			HttpServletResponse response) {
		List<AccountMainTransac> currentFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		List<AccountMainTransac> lastFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		int lastYearDesc = 0;
		int currentYearDesc = 0;
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		List<Object[]> centreList = new ArrayList<Object[]>();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		String hospitalName = "";
		/*if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}
*/
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		
		String BalanceSheetType = "";
		if (request.getParameter("Type") != null) {
			BalanceSheetType = request.getParameter("Type");
			box.put("BalanceSheetType", BalanceSheetType);
		}
		String unitType = "";
		if (session.getAttribute("unitType") != null) {
			unitType = (String) session.getAttribute("unitType");
		}

		int locationId = 0;
		if (unitType.equalsIgnoreCase("HO")) {
			if (request.getParameter("ddlLocation") != null) {
				locationId = Integer.parseInt(request
						.getParameter("ddlLocation"));
				box.put("locationId", locationId);
				box.put("BalanceSheetType", "FILTER");
				mapForDs.put("storeId", locationId);
				mapResponse = accountHandlerService.getHospitalName(mapForDs);
			}
		} else {
			if (session.getAttribute("hospitalId") != null) {
				locationId = (Integer) session.getAttribute("hospitalId");
				box.put("locationId", locationId);
				box.put("BalanceSheetType", "FILTER");
				mapForDs.put("storeId", locationId);
				mapResponse = accountHandlerService.getHospitalName(mapForDs);
			}
		}

		if (locationId != 0) {
			if (mapResponse.get("masHospitaList") != null) {
				masHospitaList = (List) mapResponse.get("masHospitaList");
				hospitalName = masHospitaList.get(0).getHospitalName();

			}
		}
/*-------------------------------for current year----------------------------------*/
		
		BigDecimal currentCrBalance3 = new BigDecimal(0.00);
		BigDecimal currentDrBalance3 = new BigDecimal(0.00);
		BigDecimal currentCrBalance4 = new BigDecimal(0.00);
		BigDecimal currentDrBalance4 = new BigDecimal(0.00);
		BigDecimal currentCrBalance5 = new BigDecimal(0.00);
		BigDecimal currentDrBalance5 = new BigDecimal(0.00);
		BigDecimal currentCrBalance6 = new BigDecimal(0.00);
		BigDecimal currentDrBalance6 = new BigDecimal(0.00);
		BigDecimal currentCrBalance7 = new BigDecimal(0.00);
		BigDecimal currentDrBalance7 = new BigDecimal(0.00);
		BigDecimal currentCrBalance8 = new BigDecimal(0.00);
		BigDecimal currentDrBalance8 = new BigDecimal(0.00);
		BigDecimal currentCrBalance9 = new BigDecimal(0.00);
		BigDecimal currentDrBalance9 = new BigDecimal(0.00);
		BigDecimal currentCrBalance10 = new BigDecimal(0.00);
		BigDecimal currentDrBalance10 = new BigDecimal(0.00);
		BigDecimal currentCrBalance11 = new BigDecimal(0.00);
		BigDecimal currentDrBalance11 = new BigDecimal(0.00);
		BigDecimal currentCrBalance12 = new BigDecimal(0.00);
		BigDecimal currentDrBalance12 = new BigDecimal(0.00);
		BigDecimal currentCrBalance13 = new BigDecimal(0.00);
		BigDecimal currentDrBalance13 = new BigDecimal(0.00);
		BigDecimal currentCrBalance14 = new BigDecimal(0.00);
		BigDecimal currentDrBalance14 = new BigDecimal(0.00);
		BigDecimal currentCrBalance15 = new BigDecimal(0.00);
		BigDecimal currentDrBalance15 = new BigDecimal(0.00);
		BigDecimal currentCrBalance16 = new BigDecimal(0.00);
		BigDecimal currentDrBalance16 = new BigDecimal(0.00);
		BigDecimal currentCrBalance17 = new BigDecimal(0.00);
		BigDecimal currentDrBalance17 = new BigDecimal(0.00);
		BigDecimal currentCrBalance18 = new BigDecimal(0.00);
		BigDecimal currentDrBalance18 = new BigDecimal(0.00);
		BigDecimal currentSchedule3Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule4Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule5Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule6Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule7Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule8Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule9Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule10Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule11Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule12Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule13Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule14Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule15Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule16Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule17Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule18Amt = new BigDecimal(0.00);

		
		/*-------------------------------------for last year--------------------------------*/
		
		BigDecimal lastCrBalance3 = new BigDecimal(0.00);
		BigDecimal lastDrBalance3 = new BigDecimal(0.00);
		BigDecimal lastCrBalance4 = new BigDecimal(0.00);
		BigDecimal lastDrBalance4 = new BigDecimal(0.00);
		BigDecimal lastCrBalance5 = new BigDecimal(0.00);
		BigDecimal lastDrBalance5 = new BigDecimal(0.00);
		BigDecimal lastCrBalance6 = new BigDecimal(0.00);
		BigDecimal lastDrBalance6 = new BigDecimal(0.00);
		BigDecimal lastCrBalance7 = new BigDecimal(0.00);
		BigDecimal lastDrBalance7 = new BigDecimal(0.00);
		BigDecimal lastCrBalance8 = new BigDecimal(0.00);
		BigDecimal lastDrBalance8 = new BigDecimal(0.00);
		BigDecimal lastCrBalance9 = new BigDecimal(0.00);
		BigDecimal lastDrBalance9 = new BigDecimal(0.00);
		BigDecimal lastCrBalance10 = new BigDecimal(0.00);
		BigDecimal lastDrBalance10 = new BigDecimal(0.00);
		BigDecimal lastCrBalance11 = new BigDecimal(0.00);
		BigDecimal lastDrBalance11 = new BigDecimal(0.00);
		BigDecimal lastCrBalance12 = new BigDecimal(0.00);
		BigDecimal lastDrBalance12 = new BigDecimal(0.00);
		BigDecimal lastCrBalance13 = new BigDecimal(0.00);
		BigDecimal lastDrBalance13 = new BigDecimal(0.00);
		BigDecimal lastCrBalance14 = new BigDecimal(0.00);
		BigDecimal lastDrBalance14 = new BigDecimal(0.00);
		BigDecimal lastCrBalance15 = new BigDecimal(0.00);
		BigDecimal lastDrBalance15 = new BigDecimal(0.00);
		BigDecimal lastCrBalance16 = new BigDecimal(0.00);
		BigDecimal lastDrBalance16 = new BigDecimal(0.00);
		BigDecimal lastCrBalance17 = new BigDecimal(0.00);
		BigDecimal lastDrBalance17 = new BigDecimal(0.00);
		BigDecimal lastCrBalance18 = new BigDecimal(0.00);
		BigDecimal lastDrBalance18 = new BigDecimal(0.00);
		BigDecimal lastSchedule3Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule4Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule5Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule6Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule7Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule8Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule9Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule10Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule11Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule12Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule13Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule14Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule15Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule16Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule17Amt = new BigDecimal(0.00);
		BigDecimal lastSchedule18Amt = new BigDecimal(0.00);
		
		
		
		
		map = accountHandlerService.generateBalanceSheetJsp(box);
		String jsp = "";

		if (map.get("sucFlag") != null && (Boolean) map.get("sucFlag")) {
			currentFinancialYearAccountList = (List) map.get("currentFinancialYearAccountList");
			lastFinancialYearAccountList = (List) map.get("lastFinancialYearAccountList");
			
			currentYearDesc = (Integer) map.get("currentYearDesc");
			lastYearDesc = (Integer) map.get("lastYearDesc");
			try {
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition",
						"attachment; filename=balance_sheet.xls");

				WritableWorkbook wb = Workbook.createWorkbook(response
						.getOutputStream());
				WritableSheet ws = wb.createSheet("Balance Sheet", 0);

				WritableFont wf = new WritableFont(WritableFont.ARIAL, 15,
						WritableFont.BOLD);
				wf.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcf = new WritableCellFormat(wf);
				wcf.setAlignment(Alignment.CENTRE);

				WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 11,
						WritableFont.BOLD);
				WritableCellFormat wcf2 = new WritableCellFormat(wf2);
				wcf2.setWrap(true);
				wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf2.setVerticalAlignment(VerticalAlignment.TOP);

				WritableFont wf222 = new WritableFont(WritableFont.ARIAL, 10,
						WritableFont.BOLD);
				WritableCellFormat wcf222 = new WritableCellFormat(wf222);
				wcf222.setWrap(true);
				wcf222.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf222.setVerticalAlignment(VerticalAlignment.TOP);

				WritableFont wf3 = new WritableFont(WritableFont.ARIAL, 8);
				WritableCellFormat wcf3 = new WritableCellFormat(wf3);
				wcf3.setWrap(true);
				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf3.setVerticalAlignment(VerticalAlignment.TOP);

				WritableFont wf4 = new WritableFont(WritableFont.ARIAL, 8,
						WritableFont.BOLD);
				WritableCellFormat wcf4 = new WritableCellFormat(wf4);
				wcf4.setWrap(true);
				wcf4.setVerticalAlignment(VerticalAlignment.TOP);

				WritableFont wf22 = new WritableFont(WritableFont.ARIAL, 8,
						WritableFont.NO_BOLD);
				WritableCellFormat wcf22 = new WritableCellFormat(wf22);
				wcf22.setWrap(true);
				wcf22.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf22.setVerticalAlignment(VerticalAlignment.TOP);

				ws.mergeCells(0, 0, 3, 0);
				Label label = new Label(0, 0, hospitalName, wcf);
				ws.addCell(label);
				ws.mergeCells(0, 1, 3, 1);
				label = new Label(0, 1, "Balance Sheet", wcf);
				ws.addCell(label);

				label = new Label(3, 2,
						"Date :"
								+ new SimpleDateFormat("dd/MM/yyyy")
										.format(new Date()), wcf4);
				ws.addCell(label);
				/*
				 * ws.mergeCells(3,2,10,2); label = new Label(3,2,new
				 * SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
				 * ws.addCell(label);
				 */

				label = new Label(0, 4, "Particulars", wcf2);
				ws.addCell(label);
				label = new Label(1, 4, "Note No.", wcf2);
				ws.addCell(label);
				label = new Label(2, 4, "For the Year ended 31st March"
						+ currentYearDesc + "(in Rs.)", wcf2);
				ws.addCell(label);
				label = new Label(3, 4, "For the Year ended 31st March"
						+ lastYearDesc + "(in Rs.)", wcf2);
				ws.addCell(label);

				label = new Label(0, 5, "I. EQUITY AND LIABILITIES", wcf22);
				ws.addCell(label);

				label = new Label(0, 6, " 1)Shareholder's funds", wcf22);
				ws.addCell(label);

				label = new Label(0, 7, " (a) Share Capital", wcf22);
				ws.addCell(label);

				label = new Label(0, 8, " (b) Reserves and surplus", wcf22);
				ws.addCell(label);

				label = new Label(0, 9,
						" (c) Money received against share warrants", wcf22);
				ws.addCell(label);

				label = new Label(0, 10,
						" 2)Share application money pending allotment", wcf22);
				ws.addCell(label);

				label = new Label(0, 11, " 3)Non-current liabilities", wcf22);
				ws.addCell(label);

				label = new Label(0, 12, " (a) Long-term borrowings", wcf22);
				ws.addCell(label);

				label = new Label(0, 13, " (b) Deferred tax liabilities", wcf22);
				ws.addCell(label);

				label = new Label(0, 14, " (c) Other Long term liabilities",
						wcf22);
				ws.addCell(label);

				label = new Label(0, 15, " (d) Long-term provisions", wcf22);
				ws.addCell(label);

				label = new Label(0, 16, " 4)Current liabilities", wcf22);
				ws.addCell(label);

				label = new Label(0, 17, " (a) Short-term borrowings", wcf22);
				ws.addCell(label);

				label = new Label(0, 18, " (b) Trade payables", wcf22);
				ws.addCell(label);

				label = new Label(0, 19, " (c) Other Current liabilities",
						wcf22);
				ws.addCell(label);

				label = new Label(0, 20, " (d) Short-term provisions", wcf22);
				ws.addCell(label);

				label = new Label(0, 21, "TOTAL", wcf222);
				ws.addCell(label);

				label = new Label(0, 22, "II. ASSETS", wcf22);
				ws.addCell(label);

				label = new Label(0, 23, " 1)Non-current assets", wcf22);
				ws.addCell(label);

				label = new Label(0, 24, " (a) Fixed assets", wcf22);
				ws.addCell(label);

				label = new Label(0, 25, " (i)Tangible assets", wcf22);
				ws.addCell(label);

				label = new Label(0, 26, " (ii)Intangible assets", wcf22);
				ws.addCell(label);

				label = new Label(0, 27, " (iii)Capital work-in-progress",
						wcf22);
				ws.addCell(label);

				label = new Label(0, 28,
						" (iv)Intangible assets under development", wcf22);
				ws.addCell(label);

				label = new Label(0, 29, " (b) Non-current Investments", wcf22);
				ws.addCell(label);

				label = new Label(0, 30, " (c) Deferred tax assets(net)", wcf22);
				ws.addCell(label);

				label = new Label(0, 31, " (d) Long-term loans and advances",
						wcf22);
				ws.addCell(label);

				label = new Label(0, 32, " 2)Current assets", wcf22);
				ws.addCell(label);

				label = new Label(0, 33, " (a) Current investments", wcf22);
				ws.addCell(label);

				label = new Label(0, 34, " (b) Inventories", wcf22);
				ws.addCell(label);

				label = new Label(0, 35, " (c) Trade receivables", wcf22);
				ws.addCell(label);

				label = new Label(0, 36, " (d) Cash and bank balances", wcf22);
				ws.addCell(label);

				label = new Label(0, 37, " (e) Short-term loans and advances",
						wcf22);
				ws.addCell(label);

				label = new Label(0, 38, " (f) Other current assets", wcf22);
				ws.addCell(label);

				label = new Label(0, 39, "Total", wcf222);
				ws.addCell(label);

				if (currentFinancialYearAccountList.size() > 0) {
					for (AccountMainTransac masAccount : currentFinancialYearAccountList) {
						if (masAccount.getAccount().getSchedule() != null) {
							if (masAccount.getAccount().getSchedule() == 3) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance3 = currentCrBalance3
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance3 = currentDrBalance3
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance3
										.compareTo(currentDrBalance3) > 0) {
									currentSchedule3Amt = currentCrBalance3
											.subtract(currentDrBalance3);
								} else if (currentDrBalance3
										.compareTo(currentCrBalance3) > 0) {
									currentSchedule3Amt = currentDrBalance3
											.subtract(currentCrBalance3);
								} else if (currentDrBalance3
										.compareTo(currentCrBalance3) == 0) {
									currentSchedule3Amt = new BigDecimal(0.00);
								}
							}
							if (masAccount.getAccount().getSchedule() == 4) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance4 = currentCrBalance4
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance4 = currentDrBalance4
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance4
										.compareTo(currentDrBalance4) > 0) {
									currentSchedule4Amt = currentCrBalance4
											.subtract(currentDrBalance4);
								} else if (currentDrBalance4
										.compareTo(currentCrBalance4) > 0) {
									currentSchedule4Amt = currentDrBalance4
											.subtract(currentCrBalance4);
								} else if (currentDrBalance4
										.compareTo(currentCrBalance4) == 0) {
									currentSchedule4Amt = new BigDecimal(0.00);
								}
							}
							if (masAccount.getAccount().getSchedule() == 5) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance5 = currentCrBalance5
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentCrBalance5 = currentCrBalance5
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance5
										.compareTo(currentDrBalance5) > 0) {
									currentSchedule5Amt = currentCrBalance5
											.subtract(currentDrBalance5);
								} else if (currentDrBalance5
										.compareTo(currentCrBalance4) > 0) {
									currentSchedule5Amt = currentDrBalance5
											.subtract(currentCrBalance5);
								} else if (currentDrBalance5
										.compareTo(currentCrBalance5) == 0) {
									currentSchedule5Amt = new BigDecimal(0.00);
								}
							}
							if (masAccount.getAccount().getSchedule() == 6) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance6 = currentCrBalance6
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance6 = currentDrBalance6
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance6
										.compareTo(currentDrBalance6) > 0) {
									currentSchedule6Amt = currentCrBalance6
											.subtract(currentDrBalance6);
								} else if (currentDrBalance6
										.compareTo(currentCrBalance6) > 0) {
									currentSchedule6Amt = currentDrBalance6
											.subtract(currentCrBalance6);
								} else if (currentDrBalance6
										.compareTo(currentCrBalance6) == 0) {
									currentSchedule6Amt = new BigDecimal(0.00);
								}
							}
							if (masAccount.getAccount().getSchedule() == 7) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance7 = currentCrBalance7
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance7 = currentDrBalance7
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance7
										.compareTo(currentDrBalance7) > 0) {
									currentSchedule7Amt = currentCrBalance7
											.subtract(currentDrBalance7);
								} else if (currentDrBalance7
										.compareTo(currentCrBalance7) > 0) {
									currentSchedule7Amt = currentDrBalance7
											.subtract(currentCrBalance7);
								} else if (currentDrBalance7
										.compareTo(currentCrBalance7) == 0) {
									currentSchedule7Amt = new BigDecimal(0.00);
								}
							}
							if (masAccount.getAccount().getSchedule() == 8) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance8 = currentCrBalance8
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance8 = currentDrBalance8
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance8
										.compareTo(currentDrBalance8) > 0) {
									currentSchedule8Amt = currentCrBalance8
											.subtract(currentDrBalance8);
								} else if (currentDrBalance8
										.compareTo(currentCrBalance8) > 0) {
									currentSchedule8Amt = currentDrBalance8
											.subtract(currentCrBalance8);
								} else if (currentDrBalance8
										.compareTo(currentCrBalance8) == 0) {
									currentSchedule8Amt = new BigDecimal(0.00);
								}
							}
							if (masAccount.getAccount().getSchedule() == 9) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance9 = currentCrBalance9
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance9 = currentDrBalance9
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance9
										.compareTo(currentDrBalance9) > 0) {
									currentSchedule9Amt = currentCrBalance9
											.subtract(currentDrBalance9);
								} else if (currentDrBalance9
										.compareTo(currentCrBalance9) > 0) {
									currentSchedule9Amt = currentDrBalance9
											.subtract(currentCrBalance9);
								} else if (currentDrBalance9
										.compareTo(currentCrBalance9) == 0) {
									currentSchedule9Amt = new BigDecimal(0.00);
								}
							}

							if (masAccount.getAccount().getSchedule() == 10) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance10 = currentCrBalance10
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance10 = currentDrBalance10
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance10
										.compareTo(currentDrBalance10) > 0) {
									currentSchedule10Amt = currentCrBalance10
											.subtract(currentDrBalance10);
								} else if (currentDrBalance10
										.compareTo(currentCrBalance10) > 0) {
									currentSchedule10Amt = currentDrBalance10
											.subtract(currentCrBalance10);
								} else if (currentDrBalance10
										.compareTo(currentCrBalance10) == 0) {
									currentSchedule10Amt = new BigDecimal(0.00);
								}
							}
							if (masAccount.getAccount().getSchedule() == 11) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance11 = currentCrBalance11
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance11 = currentDrBalance11
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance11
										.compareTo(currentDrBalance11) > 0) {
									currentSchedule11Amt = currentCrBalance11
											.subtract(currentDrBalance11);
								} else if (currentDrBalance11
										.compareTo(currentCrBalance11) > 0) {
									currentSchedule11Amt = currentDrBalance11
											.subtract(currentCrBalance11);
								} else if (currentDrBalance11
										.compareTo(currentCrBalance11) == 0) {
									currentSchedule11Amt = new BigDecimal(0.00);
								}
							}

							if (masAccount.getAccount().getSchedule() == 12) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance12 = currentCrBalance12
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance12 = currentDrBalance12
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance12
										.compareTo(currentDrBalance12) > 0) {
									currentSchedule12Amt = currentCrBalance12
											.subtract(currentDrBalance12);
								} else if (currentDrBalance12
										.compareTo(currentCrBalance12) > 0) {
									currentSchedule12Amt = currentDrBalance12
											.subtract(currentCrBalance12);
								} else if (currentDrBalance12
										.compareTo(currentCrBalance12) == 0) {
									currentSchedule12Amt = new BigDecimal(0.00);
								}
							}

							if (masAccount.getAccount().getSchedule() == 13) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance13 = currentCrBalance13
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance13 = currentDrBalance13
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance13
										.compareTo(currentDrBalance13) > 0) {
									currentSchedule13Amt = currentCrBalance13
											.subtract(currentDrBalance13);
								} else if (currentDrBalance13
										.compareTo(currentCrBalance13) > 0) {
									currentSchedule13Amt = currentDrBalance13
											.subtract(currentCrBalance13);
								} else if (currentDrBalance13
										.compareTo(currentCrBalance13) == 0) {
									currentSchedule13Amt = new BigDecimal(0.00);
								}
							}

							if (masAccount.getAccount().getSchedule() == 14) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance14 = currentCrBalance14
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance14 = currentDrBalance14
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance14
										.compareTo(currentDrBalance14) > 0) {
									currentSchedule14Amt = currentCrBalance14
											.subtract(currentDrBalance14);
								} else if (currentDrBalance14
										.compareTo(currentCrBalance14) > 0) {
									currentSchedule14Amt = currentDrBalance14
											.subtract(currentCrBalance14);
								} else if (currentDrBalance14
										.compareTo(currentCrBalance14) == 0) {
									currentSchedule14Amt = new BigDecimal(0.00);
								}
							}
							if (masAccount.getAccount().getSchedule() == 15) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance15 = currentCrBalance15
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance15 = currentDrBalance15
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance15
										.compareTo(currentDrBalance15) > 0) {
									currentSchedule15Amt = currentCrBalance15
											.subtract(currentDrBalance15);
								} else if (currentDrBalance15
										.compareTo(currentCrBalance15) > 0) {
									currentSchedule15Amt = currentDrBalance15
											.subtract(currentCrBalance15);
								} else if (currentDrBalance15
										.compareTo(currentCrBalance15) == 0) {
									currentSchedule15Amt = new BigDecimal(0.00);
								}
							}

							if (masAccount.getAccount().getSchedule() == 16) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance16 = currentCrBalance16
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance16 = currentDrBalance16
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance16
										.compareTo(currentDrBalance16) > 0) {
									currentSchedule16Amt = currentCrBalance16
											.subtract(currentDrBalance16);
								} else if (currentDrBalance16
										.compareTo(currentCrBalance16) > 0) {
									currentSchedule16Amt = currentDrBalance16
											.subtract(currentCrBalance16);
								} else if (currentDrBalance16
										.compareTo(currentCrBalance16) == 0) {
									currentSchedule16Amt = new BigDecimal(0.00);
								}
							}

							if (masAccount.getAccount().getSchedule() == 17) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance17 = currentCrBalance17
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance17 = currentDrBalance17
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance17
										.compareTo(currentDrBalance17) > 0) {
									currentSchedule17Amt = currentCrBalance17
											.subtract(currentDrBalance17);
								} else if (currentDrBalance17
										.compareTo(currentCrBalance17) > 0) {
									currentSchedule17Amt = currentDrBalance17
											.subtract(currentCrBalance17);
								} else if (currentDrBalance17
										.compareTo(currentCrBalance17) == 0) {
									currentSchedule17Amt = new BigDecimal(0.00);
								}
							}

							if (masAccount.getAccount().getSchedule() == 18) {
								if (masAccount.getClBalanceCr() != null
										&& masAccount.getClBalanceCr() != new BigDecimal(
												0.00)) {
									currentCrBalance18 = currentCrBalance18
											.add(masAccount.getClBalanceCr());
								}
								if (masAccount.getClBalanceDr() != null
										&& masAccount.getClBalanceDr() != new BigDecimal(
												0.00)) {
									currentDrBalance18 = currentDrBalance18
											.add(masAccount.getClBalanceDr());
								}
								if (currentCrBalance18
										.compareTo(currentDrBalance18) > 0) {
									currentSchedule18Amt = currentCrBalance18
											.subtract(currentDrBalance18);
								} else if (currentDrBalance18
										.compareTo(currentCrBalance18) > 0) {
									currentSchedule18Amt = currentDrBalance18
											.subtract(currentCrBalance18);
								} else if (currentDrBalance18
										.compareTo(currentCrBalance18) == 0) {
									currentSchedule18Amt = new BigDecimal(0.00);
								}
							}

						}
					}
				}
				
				
				if(lastFinancialYearAccountList.size()>0){
					for(AccountMainTransac masAccount : lastFinancialYearAccountList){
						if(masAccount.getAccount().getSchedule() != 0){
						if(masAccount.getAccount().getSchedule()==3){
							if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
								lastCrBalance3 =lastCrBalance3.add(masAccount.getClBalanceCr());
							}
							if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
								lastDrBalance3 =lastDrBalance3.add(masAccount.getClBalanceDr());
							}
							if(lastCrBalance3.compareTo(lastDrBalance3)>0){
								lastSchedule3Amt = lastCrBalance3.subtract(lastDrBalance3);
							}else if(lastDrBalance3.compareTo(lastCrBalance3)>0){
								lastSchedule3Amt = lastDrBalance3.subtract(lastCrBalance3);
							}else if(lastDrBalance3.compareTo(lastCrBalance3)==0){
								lastSchedule3Amt =new BigDecimal(0.00);
							}
						}
						if(masAccount.getAccount().getSchedule()==4){
							if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
								lastCrBalance4 =lastCrBalance4.add(masAccount.getClBalanceCr());
							}
							if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
								lastDrBalance4 =lastDrBalance4.add(masAccount.getClBalanceDr());
							}
							if(lastCrBalance4.compareTo(lastDrBalance4)>0){
								lastSchedule4Amt = lastCrBalance4.subtract(lastDrBalance4);
							}else if(lastDrBalance4.compareTo(lastCrBalance4)>0){
								lastSchedule4Amt = lastDrBalance4.subtract(lastCrBalance4);
							}else if(lastDrBalance4.compareTo(lastCrBalance4)==0){
								lastSchedule4Amt =new BigDecimal(0.00);
							}
						}
						if(masAccount.getAccount().getSchedule()==5){
							if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
								lastCrBalance5 =lastCrBalance5.add(masAccount.getClBalanceCr());
							}
							if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
								lastCrBalance5 =lastCrBalance5.add(masAccount.getClBalanceDr());
							}
							if(lastCrBalance5.compareTo(lastDrBalance5)>0){
								lastSchedule5Amt = lastCrBalance5.subtract(lastDrBalance5);
							}else if(lastDrBalance5.compareTo(lastCrBalance5)>0){
								lastSchedule5Amt = lastDrBalance5.subtract(lastCrBalance5);
							}else if(lastDrBalance5.compareTo(lastCrBalance5)==0){
								lastSchedule5Amt =new BigDecimal(0.00);
							}
						}
						if(masAccount.getAccount().getSchedule()==6){
							if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
								lastCrBalance6 =lastCrBalance6.add(masAccount.getClBalanceCr());
							}
							if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
								lastDrBalance6 =lastDrBalance6.add(masAccount.getClBalanceDr());
							}
							if(lastCrBalance6.compareTo(lastDrBalance6)>0){
								lastSchedule6Amt = lastCrBalance6.subtract(lastDrBalance6);
							}else if(lastDrBalance6.compareTo(lastCrBalance6)>0){
								lastSchedule6Amt = lastDrBalance6.subtract(lastCrBalance6);
							}else if(lastDrBalance6.compareTo(lastCrBalance6)==0){
								lastSchedule6Amt =new BigDecimal(0.00);
							}
						}
						if(masAccount.getAccount().getSchedule()==7){
							if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
								lastCrBalance7 =lastCrBalance7.add(masAccount.getClBalanceCr());
							}
							if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
								lastDrBalance7 =lastDrBalance7.add(masAccount.getClBalanceDr());
							}
							if(lastCrBalance7.compareTo(lastDrBalance7)>0){
								lastSchedule7Amt = lastCrBalance7.subtract(lastDrBalance7);
							}else if(lastDrBalance7.compareTo(lastCrBalance7)>0){
								lastSchedule7Amt = lastDrBalance7.subtract(lastCrBalance7);
							}else if(lastDrBalance7.compareTo(lastCrBalance7)==0){
								lastSchedule7Amt =new BigDecimal(0.00);
							}
						}
						if(masAccount.getAccount().getSchedule()==8){
							if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
								lastCrBalance8 =lastCrBalance8.add(masAccount.getClBalanceCr());
							}
							if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
								lastDrBalance8 =lastDrBalance8.add(masAccount.getClBalanceDr());
							}
							if(lastCrBalance8.compareTo(lastDrBalance8)>0){
								lastSchedule8Amt = lastCrBalance8.subtract(lastDrBalance8);
							}else if(lastDrBalance8.compareTo(lastCrBalance8)>0){
								lastSchedule8Amt = lastDrBalance8.subtract(lastCrBalance8);
							}else if(lastDrBalance8.compareTo(lastCrBalance8)==0){
								lastSchedule8Amt =new BigDecimal(0.00);
							}
						}
						if(masAccount.getAccount().getSchedule()==9){
							if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
								lastCrBalance9 =lastCrBalance9.add(masAccount.getClBalanceCr());
							}
							if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
								lastDrBalance9 =lastDrBalance9.add(masAccount.getClBalanceDr());
							}
							if(lastCrBalance9.compareTo(lastDrBalance9)>0){
								lastSchedule9Amt = lastCrBalance9.subtract(lastDrBalance9);
							}else if(lastDrBalance9.compareTo(lastCrBalance9)>0){
								lastSchedule9Amt = lastDrBalance9.subtract(lastCrBalance9);
							}else if(lastDrBalance9.compareTo(lastCrBalance9)==0){
								lastSchedule9Amt =new BigDecimal(0.00);
							}
						}
						
					if(masAccount.getAccount().getSchedule()==10){
						if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
							lastCrBalance10 =lastCrBalance10.add(masAccount.getClBalanceCr());
						}
						if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
							lastDrBalance10 =lastDrBalance10.add(masAccount.getClBalanceDr());
						}
						if(lastCrBalance10.compareTo(lastDrBalance10)>0){
							lastSchedule10Amt = lastCrBalance10.subtract(lastDrBalance10);
						}else if(lastDrBalance10.compareTo(lastCrBalance10)>0){
							lastSchedule10Amt = lastDrBalance10.subtract(lastCrBalance10);
						}else if(lastDrBalance10.compareTo(lastCrBalance10)==0){
							lastSchedule10Amt =new BigDecimal(0.00);
						}
					}
					if(masAccount.getAccount().getSchedule()==11){
						if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
							lastCrBalance11 =lastCrBalance11.add(masAccount.getClBalanceCr());
						}
						if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
							lastDrBalance11 =lastDrBalance11.add(masAccount.getClBalanceDr());
						}
						if(lastCrBalance11.compareTo(lastDrBalance11)>0){
							lastSchedule11Amt = lastCrBalance11.subtract(lastDrBalance11);
						}else if(lastDrBalance11.compareTo(lastCrBalance11)>0){
							lastSchedule11Amt = lastDrBalance11.subtract(lastCrBalance11);
						}else if(lastDrBalance11.compareTo(lastCrBalance11)==0){
							lastSchedule11Amt =new BigDecimal(0.00);
						}
					}
					
					if(masAccount.getAccount().getSchedule()==12){
						if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
							lastCrBalance12 =lastCrBalance12.add(masAccount.getClBalanceCr());
						}
						if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
							lastDrBalance12 =lastDrBalance12.add(masAccount.getClBalanceDr());
						}
						if(lastCrBalance12.compareTo(lastDrBalance12)>0){
							lastSchedule12Amt = lastCrBalance12.subtract(lastDrBalance12);
						}else if(lastDrBalance12.compareTo(lastCrBalance12)>0){
							lastSchedule12Amt = lastDrBalance12.subtract(lastCrBalance12);
						}else if(lastDrBalance12.compareTo(lastCrBalance12)==0){
							lastSchedule12Amt =new BigDecimal(0.00);
						}
					}
					
					if(masAccount.getAccount().getSchedule()==13){
						if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
							lastCrBalance13 =lastCrBalance13.add(masAccount.getClBalanceCr());
						}
						if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
							lastDrBalance13 =lastDrBalance13.add(masAccount.getClBalanceDr());
						}
						if(lastCrBalance13.compareTo(lastDrBalance13)>0){
							lastSchedule13Amt = lastCrBalance13.subtract(lastDrBalance13);
						}else if(lastDrBalance13.compareTo(lastCrBalance13)>0){
							lastSchedule13Amt = lastDrBalance13.subtract(lastCrBalance13);
						}else if(lastDrBalance13.compareTo(lastCrBalance13)==0){
							lastSchedule13Amt =new BigDecimal(0.00);
						}
					}
					
					if(masAccount.getAccount().getSchedule()==14){
						if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
							lastCrBalance14 =lastCrBalance14.add(masAccount.getClBalanceCr());
						}
						if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
							lastDrBalance14 =lastDrBalance14.add(masAccount.getClBalanceDr());
						}
						if(lastCrBalance14.compareTo(lastDrBalance14)>0){
							lastSchedule14Amt = lastCrBalance14.subtract(lastDrBalance14);
						}else if(lastDrBalance14.compareTo(lastCrBalance14)>0){
							lastSchedule14Amt = lastDrBalance14.subtract(lastCrBalance14);
						}else if(lastDrBalance14.compareTo(lastCrBalance14)==0){
							lastSchedule14Amt =new BigDecimal(0.00);
						}
					}
					if(masAccount.getAccount().getSchedule()==15){
						if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
							lastCrBalance15 =lastCrBalance15.add(masAccount.getClBalanceCr());
						}
						if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
							lastDrBalance15 =lastDrBalance15.add(masAccount.getClBalanceDr());
						}
						if(lastCrBalance15.compareTo(lastDrBalance15)>0){
							lastSchedule15Amt = lastCrBalance15.subtract(lastDrBalance15);
						}else if(lastDrBalance15.compareTo(lastCrBalance15)>0){
							lastSchedule15Amt = lastDrBalance15.subtract(lastCrBalance15);
						}else if(lastDrBalance15.compareTo(lastCrBalance15)==0){
							lastSchedule15Amt =new BigDecimal(0.00);
						}
					}
					
					if(masAccount.getAccount().getSchedule()==16){
						if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
							lastCrBalance16 =lastCrBalance16.add(masAccount.getClBalanceCr());
						}
						if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
							lastDrBalance16 =lastDrBalance16.add(masAccount.getClBalanceDr());
						}
						if(lastCrBalance16.compareTo(lastDrBalance16)>0){
							lastSchedule16Amt = lastCrBalance16.subtract(lastDrBalance16);
						}else if(lastDrBalance16.compareTo(lastCrBalance16)>0){
							lastSchedule16Amt = lastDrBalance16.subtract(lastCrBalance16);
						}else if(lastDrBalance16.compareTo(lastCrBalance16)==0){
							lastSchedule16Amt =new BigDecimal(0.00);
						}
					}
					
					if(masAccount.getAccount().getSchedule()==17){
						if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
							lastCrBalance17 =lastCrBalance17.add(masAccount.getClBalanceCr());
						}
						if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
							lastDrBalance17 =lastDrBalance17.add(masAccount.getClBalanceDr());
						}
						if(lastCrBalance17.compareTo(lastDrBalance17)>0){
							lastSchedule17Amt = lastCrBalance17.subtract(lastDrBalance17);
						}else if(lastDrBalance17.compareTo(lastCrBalance17)>0){
							lastSchedule17Amt = lastDrBalance17.subtract(lastCrBalance17);
						}else if(lastDrBalance17.compareTo(lastCrBalance17)==0){
							lastSchedule17Amt =new BigDecimal(0.00);
						}
					}
					
					if(masAccount.getAccount().getSchedule()==18){
						if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
							lastCrBalance18 =lastCrBalance18.add(masAccount.getClBalanceCr());
						}
						if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
							lastDrBalance18 =lastDrBalance18.add(masAccount.getClBalanceDr());
						}
						if(lastCrBalance18.compareTo(lastDrBalance18)>0){
							lastSchedule18Amt = lastCrBalance18.subtract(lastDrBalance18);
						}else if(lastDrBalance18.compareTo(lastCrBalance18)>0){
							lastSchedule18Amt = lastDrBalance18.subtract(lastCrBalance18);
						}else if(lastDrBalance18.compareTo(lastCrBalance18)==0){
							lastSchedule18Amt =new BigDecimal(0.00);
						}
					}
					
					
					}
				}
			}

				BigDecimal currentshareHoldersAmt = currentSchedule3Amt
						.add(currentSchedule4Amt);
				BigDecimal nonCurrentLiabilities = currentSchedule5Amt.add(
						currentSchedule6Amt).add(currentSchedule7Amt);
				BigDecimal currentLiabilities = currentSchedule8Amt
						.add(currentSchedule9Amt).add(currentSchedule10Amt)
						.add(currentSchedule11Amt);
				BigDecimal currentAssets = currentSchedule13Amt
						.add(currentSchedule14Amt).add(currentSchedule15Amt)
						.add(currentSchedule16Amt).add(currentSchedule17Amt);
				
			
				
				BigDecimal lastYearCurrentshareHoldersAmt = lastSchedule3Amt
						.add(lastSchedule4Amt);
				BigDecimal lastYearNonCurrentLiabilities = lastSchedule5Amt.add(
						lastSchedule6Amt).add(lastSchedule7Amt);
				BigDecimal lastYearCurrentLiabilities = lastSchedule8Amt
						.add(lastSchedule9Amt).add(lastSchedule10Amt)
						.add(lastSchedule11Amt);
				BigDecimal lastYearCurrentAssets = lastSchedule13Amt
						.add(lastSchedule14Amt).add(lastSchedule15Amt)
						.add(lastSchedule16Amt).add(lastSchedule17Amt);
				
				
				
				
				label = new Label(1, 7, "3", wcf3);
				ws.addCell(label);
				label = new Label(2, 7, currentSchedule3Amt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 7, lastSchedule3Amt.toString(), wcf3);
				ws.addCell(label);

				label = new Label(1, 8, "4", wcf3);
				ws.addCell(label);
				label = new Label(2, 8, currentSchedule4Amt + "-------------- "
						+ currentshareHoldersAmt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 8, lastSchedule4Amt + "-------------- "
						+ lastYearCurrentshareHoldersAmt.toString(), wcf3);
				ws.addCell(label);

				label = new Label(1, 9, "", wcf3);
				ws.addCell(label);
				label = new Label(2, 9, "", wcf3);
				ws.addCell(label);
				label = new Label(3, 9, "", wcf3);
				ws.addCell(label);

				label = new Label(1, 10, "", wcf3);
				ws.addCell(label);
				label = new Label(2, 10, "", wcf3);
				ws.addCell(label);
				label = new Label(3, 10, "", wcf3);
				ws.addCell(label);

				label = new Label(1, 11, "", wcf3);
				ws.addCell(label);
				label = new Label(2, 11, "", wcf3);
				ws.addCell(label);
				label = new Label(3, 11, "", wcf3);
				ws.addCell(label);

				label = new Label(1, 12, "", wcf3);
				ws.addCell(label);
				label = new Label(2, 12, "", wcf3);
				ws.addCell(label);
				label = new Label(3, 12, "", wcf3);
				ws.addCell(label);

				label = new Label(1, 13, "5", wcf3);
				ws.addCell(label);
				label = new Label(2, 13, currentSchedule5Amt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 13,  lastSchedule5Amt.toString(), wcf3);
				ws.addCell(label);


				label = new Label(1, 14, "6", wcf3);
				ws.addCell(label);
				label = new Label(2, 14, currentSchedule6Amt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 14, lastSchedule6Amt.toString(), wcf3);
				ws.addCell(label);

				label = new Label(1, 15, "7", wcf3);
				ws.addCell(label);
				label = new Label(2, 15, currentSchedule7Amt
						+ "-------------- " + nonCurrentLiabilities.toString(),
						wcf3);
				ws.addCell(label);
				label = new Label(3, 15, lastSchedule7Amt
						+ "-------------- " + lastYearNonCurrentLiabilities.toString(), wcf3);
				ws.addCell(label);
				
				label = new Label(1, 16, "", wcf3);
				ws.addCell(label);
				label = new Label(2, 16, "", wcf3);
				ws.addCell(label);
				label = new Label(3, 16, "", wcf3);
				ws.addCell(label);
				label = new Label(1, 17, "8", wcf3);
				ws.addCell(label);
				label = new Label(2, 17, currentSchedule8Amt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 17, lastSchedule8Amt.toString(), wcf3);
				ws.addCell(label);
				
				label = new Label(1, 18, "9", wcf3);
				ws.addCell(label);
				label = new Label(2, 18, currentSchedule9Amt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 18, lastSchedule9Amt.toString(), wcf3);
				ws.addCell(label);

				label = new Label(1, 19, "10", wcf3);
				ws.addCell(label);
				label = new Label(2, 19, currentSchedule10Amt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 19, lastSchedule10Amt.toString(), wcf3);
				ws.addCell(label);

				label = new Label(1, 20, "11", wcf3);
				ws.addCell(label);
				label = new Label(2, 20, currentSchedule11Amt
						+ "--------------" + currentLiabilities.toString(),
						wcf3);
				ws.addCell(label);
				label = new Label(3, 20, lastSchedule11Amt
						+ "--------------" + lastYearCurrentLiabilities.toString(), wcf3);
				ws.addCell(label);

				label = new Label(2, 21, currentshareHoldersAmt
						.add(nonCurrentLiabilities).add(currentLiabilities)
						.toString(), wcf3);
				ws.addCell(label);

				label = new Label(3, 21, lastYearCurrentshareHoldersAmt
						.add(lastYearNonCurrentLiabilities).add(lastYearCurrentLiabilities)
						.toString(), wcf3);
				ws.addCell(label);

				label = new Label(1, 22, "", wcf3);
				ws.addCell(label);
				label = new Label(2, 22, "", wcf3);
				ws.addCell(label);
				label = new Label(3, 22, "", wcf3);
				ws.addCell(label);

				label = new Label(1, 23, "", wcf3);
				ws.addCell(label);
				label = new Label(2, 23, "", wcf3);
				ws.addCell(label);
				label = new Label(3, 23, "", wcf3);
				ws.addCell(label);

				label = new Label(1, 24, "12", wcf3);
				ws.addCell(label);
				label = new Label(2, 24, currentSchedule12Amt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 24, lastSchedule12Amt.toString(), wcf3);
				ws.addCell(label);

				label = new Label(1, 31, "13", wcf3);
				ws.addCell(label);
				label = new Label(2, 31, currentSchedule13Amt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 31, lastSchedule13Amt.toString(), wcf3);
				ws.addCell(label);

				label = new Label(1, 34, "14", wcf3);
				ws.addCell(label);
				label = new Label(2, 34, currentSchedule14Amt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 34, lastSchedule14Amt.toString(), wcf3);
				ws.addCell(label);

				label = new Label(1, 35, "15", wcf3);
				ws.addCell(label);
				label = new Label(2, 35, currentSchedule15Amt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 35, lastSchedule15Amt.toString(), wcf3);
				ws.addCell(label);

				label = new Label(1, 36, "16", wcf3);
				ws.addCell(label);
				label = new Label(2, 36, currentSchedule16Amt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 36, lastSchedule16Amt.toString(), wcf3);
				ws.addCell(label);

				label = new Label(1, 37, "17", wcf3);
				ws.addCell(label);
				label = new Label(2, 37, currentSchedule17Amt.toString(), wcf3);
				ws.addCell(label);
				label = new Label(3, 37, lastSchedule17Amt.toString(), wcf3);
				ws.addCell(label);

				label = new Label(1, 38, "18", wcf3);
				ws.addCell(label);
				label = new Label(2, 38, currentSchedule18Amt
						+ " ------------------- " + currentAssets.toString(),
						wcf3);
				ws.addCell(label);
				label = new Label(3, 38,lastSchedule18Amt
						+ " ------------------- " + lastYearCurrentAssets.toString(), wcf3);
				ws.addCell(label);

				label = new Label(2, 39, currentSchedule12Amt
						.add(currentAssets).toString(), wcf3);
				ws.addCell(label);

				label = new Label(3, 39, lastSchedule12Amt
						.add(lastYearCurrentAssets).toString(), wcf3);
				ws.addCell(label);
				
				CellView cell = new CellView();
				cell.setSize(8000);
				ws.setColumnView(0, cell);

				cell.setSize(6000);
				ws.setColumnView(2, cell);

				cell.setSize(6000);
				ws.setColumnView(3, cell);

				cell.setSize(600);
				ws.setColumnView(5, cell);

				cell.setSize(3000);
				ws.setColumnView(7, cell);

				cell.setSize(1500);
				ws.setColumnView(10, cell);

				cell.setSize(1500);
				ws.setColumnView(10, cell);

				cell.setSize(2000);
				ws.setColumnView(11, cell);

				cell.setSize(1500);
				ws.setColumnView(12, cell);

				cell.setSize(1500);
				ws.setColumnView(13, cell);

				cell.setSize(2000);
				ws.setColumnView(14, cell);

				cell.setSize(1500);
				ws.setColumnView(15, cell);

				wb.write();
				wb.close();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				jsp = "fa_balanceSheet";
				jsp += ".jsp";
				String title = "Profit And Loss";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", "Some Error Occured");
				return new ModelAndView("index", "map", map);
			}
		} else {
			/*centreList = marketingHandlerService.getCentreList();*/
			map.put("centreList", centreList);
			jsp = "fa_balanceSheet";
			jsp += ".jsp";
			String title = "Profit And Loss";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", "No Data Found");
			return new ModelAndView("index", "map", map);
		}
	}
	
			public ModelAndView printVoucherRpt(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				String jsp = "";
				String title = "";
				jsp = "voucher";
				jsp = jsp + ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);

				return new ModelAndView("index", "map", map);
			}

		/*	public ModelAndView generateVoucherRpt(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				int storeId = 0;
				Map<String, Object> mapResponse = new HashMap<String, Object>();
				Map<String, Object> mapForDs = new HashMap<String, Object>();
				List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
				Date fromDate = null;
				Date toDate = null;
				String hospitalName = "";
				try {
					
					String userHome = getServletContext().getRealPath("");
					System.out.println("userHome="+userHome);
					String imagePath = userHome+"/jsp/images/logo-hal.jpg";
					requestParameters.put("path", imagePath);
					
					String userHome = getServletContext().getRealPath("");	         
			        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
			        requestParameters.put("path", imagePath);
					
					int hospital_id = 0;
					if (session.getAttribute("hospitalId") != null) {
						hospital_id = (Integer) session.getAttribute("hospitalId");
						mapForDs.put("storeId", hospital_id);
						requestParameters.put("hospital_id", hospital_id);
						mapResponse = accountHandlerService.getHospitalName(mapForDs);
					}
					if (mapResponse.get("masHospitaList") != null) {
						masHospitaList = (List) mapResponse.get("masHospitaList");
						hospitalName = masHospitaList.get(0).getHospitalName();
						requestParameters.put("hospitalName", hospitalName);
					}

					if (request.getParameter(FROM_DATE) != null
							&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = HMSUtil.convertStringTypeDateToDateType((request
								.getParameter(FROM_DATE)));

					}
					if (request.getParameter(TO_DATE) != null
							&& !(request.getParameter(TO_DATE).equals(""))) {
						toDate = HMSUtil.convertStringTypeDateToDateType((request
								.getParameter(TO_DATE)));

					}
					Map<String, Object> conMap = accountHandlerService.getConnection();
					String voucherType = "";
					if (request.getParameter("voucherType") != null) {
						voucherType = request.getParameter("voucherType");
					}
					requestParameters.put("voucherType", voucherType);
					requestParameters.put("fromDate", fromDate);
					requestParameters.put("toDate", toDate);
					
					
					if (voucherType.equalsIgnoreCase("JV")) {
						HMSUtil.generateReport("journalVoucher", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					} 
					else if (voucherType.equalsIgnoreCase("PRV")) {
						HMSUtil.generateReport("purchaseVoucher", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					} 
					else if (voucherType.equalsIgnoreCase("RV")) {

						int accountId = 0;
						if (request.getParameter("accountId") != null) {
							accountId = Integer.parseInt(request.getParameter("accountId"));
						}
						requestParameters.put("accId", accountId);
						HMSUtil.generateReport("receiptVoucher", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					} else if (voucherType.equalsIgnoreCase("SV")) {
						HMSUtil.generateReport("salesVoucher", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					} else if (voucherType.equalsIgnoreCase("SR")) {
						HMSUtil.generateReport("salesReturnVoucher", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					} else if (voucherType.equalsIgnoreCase("PV")) {
						int accountId = 0;
						if (request.getParameter("accountId") != null) {
							accountId = Integer.parseInt(request.getParameter("accountId"));
						}
						requestParameters.put("accId", accountId);
						HMSUtil.generateReport("paymentVoucherId", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					} else if (voucherType.equalsIgnoreCase("PR")) {
						HMSUtil.generateReport("purchaseReturn", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					}

			

					


				} catch (Exception e) {
					e.printStackTrace();
				}

				return null;

							
	 }*/
			
			
			public ModelAndView generateVoucherRpt(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				int storeId = 0;
				Map<String, Object> mapResponse = new HashMap<String, Object>();
				Map<String, Object> mapForDs = new HashMap<String, Object>();
				List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
				Date fromDate = null;
				Date toDate = null;
				String hospitalName = "";
				String qry="";
				try {
					
					String userHome = getServletContext().getRealPath("");	         
			        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
			        requestParameters.put("path", imagePath);
					
					int approvalId = Integer.parseInt(HMSUtil.getProperties("adt.properties","approvedId"));
					int locationId = 0;
					
					if (session.getAttribute("hospitalId") != null && !session.getAttribute("hospitalId").equals("0")) {
						locationId = Integer.parseInt(session.getAttribute("hospitalId").toString()) ;					
						mapForDs.put("storeId", locationId);
						mapResponse = accountHandlerService.getHospitalName(mapForDs);
						qry +=" and h.hospital_id ="+locationId;
					}
					
					qry +=" and h.approval_status="+approvalId;
					
					if (mapResponse.get("masHospitaList") != null) {
						masHospitaList = (List) mapResponse.get("masHospitaList");
						hospitalName = masHospitaList.get(0).getHospitalName();
						requestParameters.put("hospitalName", hospitalName);
					}else{
						hospitalName = "ALL";
						requestParameters.put("hospitalName", hospitalName);
					}

					if (request.getParameter(FROM_DATE) != null
							&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = HMSUtil.convertStringTypeDateToDateType((request
								.getParameter(FROM_DATE)));

					}
					if (request.getParameter(TO_DATE) != null
							&& !(request.getParameter(TO_DATE).equals(""))) {
						toDate = HMSUtil.convertStringTypeDateToDateType((request
								.getParameter(TO_DATE)));

					}
					requestParameters.put("qry", qry);
					Map<String, Object> conMap = accountHandlerService.getConnection();
					String voucherType = "";
					if (request.getParameter("voucherType") != null) {
						voucherType = request.getParameter("voucherType");
					}
					requestParameters.put("voucherType", voucherType);
					requestParameters.put("fromDate", fromDate);
					requestParameters.put("toDate", toDate);
					
					
					if (voucherType.equalsIgnoreCase("JV")) {
						HMSUtil.generateReport("journalVoucher", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					} 
					else if (voucherType.equalsIgnoreCase("PRV")) {
						HMSUtil.generateReport("purchaseVoucher", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					} 
					else if (voucherType.equalsIgnoreCase("RV")) {

						int accountId = 0;
						if (request.getParameter("accountId") != null) {
							accountId = Integer.parseInt(request.getParameter("accountId"));
						}
						requestParameters.put("accId", accountId);
						HMSUtil.generateReport("receiptVoucherReport", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					} else if (voucherType.equalsIgnoreCase("SV")) {
						HMSUtil.generateReport("salesVoucher", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					} else if (voucherType.equalsIgnoreCase("SR")) {
						HMSUtil.generateReport("salesReturnVoucher", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					} else if (voucherType.equalsIgnoreCase("PV")) {
						int accountId = 0;
						if (request.getParameter("accountId") != null) {
							accountId = Integer.parseInt(request.getParameter("accountId"));
						}
						requestParameters.put("accId", accountId);
						HMSUtil.generateReport("paymentVoucher", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					} else if (voucherType.equalsIgnoreCase("PR")) {
						HMSUtil.generateReport("purchaseReturn", requestParameters,
								(Connection) conMap.get("conn"), response,
								getServletContext());
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				return null;

							
	 }
			
			public ModelAndView printSalesRegister(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				HttpSession session = request.getSession();
			
				Date fromDate = null;
				Date toDate = null;
				String UnitType= "";
				try {
					
					String userHome = getServletContext().getRealPath("");
					System.out.println("userHome="+userHome);
					String imagePath = userHome+"/jsp/images/logo.jpg";
					requestParameters.put("path", imagePath);
					
					int locationId = 0;
					
					if(session.getAttribute("unitType") != null) {
						UnitType =  (String)session.getAttribute("unitType");
					}
					
					if(UnitType.equalsIgnoreCase("HO"))
					{
						if(request.getParameter("ddlLocation") != null)
						{
							locationId = Integer.parseInt(request.getParameter("ddlLocation"));
							requestParameters.put("locationId", locationId);
						}
					}
					else
					{
						if (session.getAttribute("locationId") != null) {
							locationId = (Integer) session.getAttribute("locationId");
							
							requestParameters.put("locationId", locationId);
							
						}
					}
					
					

					if (request.getParameter(FROM_DATE) != null
							&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = HMSUtil.convertStringTypeDateToDateType((request
								.getParameter(FROM_DATE)));

					}
					if (request.getParameter(TO_DATE) != null
							&& !(request.getParameter(TO_DATE).equals(""))) {
						toDate = HMSUtil.convertStringTypeDateToDateType((request
								.getParameter(TO_DATE)));

					}
					Map<String, Object> connectionMap = accountHandlerService.getConnection();
					
					HMSUtil.generateReport("sales_register", requestParameters,(Connection) connectionMap.get("conn"), response,	getServletContext());
					
			

					


				} catch (Exception e) {
					e.printStackTrace();
				}

				return null;

							
	 }
			
			public ModelAndView printPurchaseAdvanceRegister(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				HttpSession session = request.getSession();
			
				Date fromDate = null;
				Date toDate = null;
				String UnitType= "";
				try {
					
					String userHome = getServletContext().getRealPath("");
					System.out.println("userHome="+userHome);
					String imagePath = userHome+"/jsp/images/logo.jpg";
					requestParameters.put("path", imagePath);
					
					int locationId = 0;
					
					if(session.getAttribute("unitType") != null) {
						UnitType =  (String)session.getAttribute("unitType");
					}
					
					if(UnitType.equalsIgnoreCase("HO"))
					{
						if(request.getParameter("ddlLocation") != null)
						{
							locationId = Integer.parseInt(request.getParameter("ddlLocation"));
							requestParameters.put("locationId", locationId);
						}
					}
					else
					{
						if (session.getAttribute("locationId") != null) {
							locationId = (Integer) session.getAttribute("locationId");
							
							requestParameters.put("locationId", locationId);
							
						}
					}
					
					
                    // Assign accountId HardCode update later
					int fYear =0;
					int accountId =76;
					requestParameters.put("accountId", accountId);
					                       
					if (session.getAttribute("financialYear") != null) {
						fYear = (Integer) session.getAttribute("financialYear");						
					}
					
					requestParameters.put("fYear", fYear);
					
					
					Map<String, Object> connectionMap = accountHandlerService.getConnection();
					
					HMSUtil.generateReport("pur_advance_ledger", requestParameters,(Connection) connectionMap.get("conn"), response,	getServletContext());
					
			

					


				} catch (Exception e) {
					e.printStackTrace();
				}

				return null;

							
	 }
			
			public ModelAndView printGrowerLedgerAccount(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				List<FaMasSubLed> subledDetails = new ArrayList<FaMasSubLed>();
				HttpSession session = request.getSession();
				Box box = HMSUtil.getBox(request);
			
				Date fromDate = null;
				Date toDate = null;
				String UnitType= "";
				int fYear =0;
				int sub_led_id =0;
				int rskId=0;
				int growerId=0;
				try {
					
					String userHome = getServletContext().getRealPath("");
					System.out.println("userHome="+userHome);
					String imagePath = userHome+"/jsp/images/logo.jpg";
					requestParameters.put("path", imagePath);
					
					int locationId = 0;
					
					if(session.getAttribute("unitType") != null) {
						UnitType =  (String)session.getAttribute("unitType");
					}
					
						if(request.getParameter("locationId") != null)
						{
							locationId = Integer.parseInt(request.getParameter("locationId"));
							requestParameters.put("locationId", locationId);
							box.put("locationId", locationId);
						}
				
					if(request.getParameter("Id") != null)
					{
						sub_led_id= Integer.parseInt(request.getParameter("Id"));
						requestParameters.put("sub_led_id", sub_led_id);
						box.put("subledId", sub_led_id);
					}
					if (session.getAttribute("financialYear") != null) {
						fYear = (Integer) session.getAttribute("financialYear");	
						requestParameters.put("fYear", fYear);
					}
					
					subledDetails = accountHandlerService.getSubledgerDetails(box);
					/*if(subledDetails.size()>0){
						for(FaMasSubLed subled : subledDetails){
							if(subled.getRsk()!=null){
								rskId= subled.getRsk().getId();
							}else if(subled.getGrower()!=null){
								growerId = subled.getGrower().getId();
							}
						}
					}*/
					
					Map<String, Object> connectionMap = accountHandlerService.getConnection();
					
					if(rskId!=0){
						HMSUtil.generateReport("Rsk_Subledger", requestParameters,(Connection) connectionMap.get("conn"), response,	getServletContext());
					}else if(growerId !=0){
						HMSUtil.generateReport("grower_advance_ledger", requestParameters,(Connection) connectionMap.get("conn"), response,	getServletContext());
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				return null;

							
	 }
	public ModelAndView showLegalAllotmentJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		// map = accountHandlerService.showLegalApplicationMapping(box);
		String jsp = "fa_share_allotment.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView displayShareAllotmentMapping(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.displayShareAllotmentMapping(box);

		String jsp = "fa_share_allotment.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showShareAllotmentAdjustmentJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		// map = accountHandlerService.showLegalApplicationMapping(box);
		String jsp = "fa_share_allotment_adjustment.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView displayShareAllotmentAdjustment(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.displayShareAllotmentAdjustment(box);

		String jsp = "fa_share_allotment_adjustment.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showShareAllotmentReceiptMoney(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		// map = accountHandlerService.showLegalApplicationMapping(box);
		String jsp = "fa_allotment_receipt_money.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showShareCallJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		// map = accountHandlerService.showLegalApplicationMapping(box);
		String jsp = "fa_shareCall.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView displayAllotmentReceiptVoucher(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.displayAllotmentReceiptVoucher(box);
		
		String jsp = "fa_share_call.jsp";
		//String jsp = "fa_allotment_receipt_money.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView postShareAllotmentMapping(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postShareAllotmentMapping(box);
		String jsp = "fa_share_allotment.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView displayShareCallMapping(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.displayShareCallMapping(box);

		String jsp = "fa_share_call.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView postShareCallMapping(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postShareCallMapping(box);
		String jsp = "fa_share_allotment.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showCashFlowStatementJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.showCashFlowStatementJsp(box);
		String jsp = "fa_cashFlowStatement.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showGrowerPaymentJsp(HttpServletRequest request,HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap();
		  List<Object[]> seedCategoryList = new ArrayList<Object[]>();
		  List<Object[]> financialYearList = new ArrayList<Object[]>();
		  List<Object[]> cropList = new ArrayList<Object[]>();
		  List<Object[]> varietyList = new ArrayList<Object[]>();
		  
		  
		  seedCategoryList = marketingHandlerService.getSeedCategoryList();
		  financialYearList = marketingHandlerService.getFinancialYearList();
		  cropList = marketingHandlerService.getCropList();
		  varietyList = marketingHandlerService.getVarietyList();
		  
		  
		  String jsp = "pendingLisForGrowerPayment";
		  jsp += ".jsp";
		 String  title = "Awaiting for Advance/Final Payment To Grower";
		  
		  map.put("financialYearList", financialYearList);
		  map.put("seedCategoryList", seedCategoryList);
		  map.put("cropList", cropList);
		  map.put("varietyList", varietyList);		
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  
		  return new ModelAndView("index", "map", map);
		
	}
	/*public ModelAndView getGetGrowerPayemntList(HttpServletRequest request,HttpServletResponse response) {
		 Map<String, Object> map = new HashMap();
		  List<DgSeedQualityInspection> pendingListForGrowerPayment = new ArrayList<DgSeedQualityInspection>();
		  
		  Box box = HMSUtil.getBox(request);
		  

		  map = accountHandlerService.getPendingPaymentList(box);
		  if (map.get("pendingListForGrowerPayment") != null) {
			  pendingListForGrowerPayment = (List)map.get("pendingListForGrowerPayment");
		  }
		  int totalRecords = 0;
		  if (map.get("totalRecords") != null) {
			    totalRecords = ((Integer)map.get("totalRecords")).intValue();
			  }
		  try
		  {
		    PrintWriter pw = response.getWriter();
		    
		    pw.write("[");
		    int counter = 1;
		    for (DgSeedQualityInspection list : pendingListForGrowerPayment)
		    {
		      if (counter != pendingListForGrowerPayment.size()) {
		        pw.write("{\"Id\": \"" + list.getId() + "\",\"Year\": \"" + (list.getProdYear() != null ? list.getProdYear().getFinancialYear() : "") + "\",\"GrowerName\": \"" + (list.getGrower() != null ? list.getGrower().getGrower().getGrowerName() : "") + "\",\"Class\": \"" + (list.getSeedClass() != null ? list.getSeedClass().getItemClassName() : "") + "\",\"Crop\": \"" + (list.getCrop() != null ? list.getCrop().getNomenclature() : "") + "\",\"Variety\": \"" + (list.getSeedVariety() != null ? list.getSeedVariety().getItemVarietyName() : "") + "\",\"PreparedBy\":\"" + (list.getLastChgBy() != null ? list.getLastChgBy().getFirstName() + " " + list.getLastChgBy().getLastName() : "") + "\",\"TempLotNo\":\"" + list.getTempLotNo() + "\",\"PaymentStatus\":\"" + list.getPaymentStatus() + "\",\"totalRecords\":\"" + totalRecords + "\"},");
		      } else {
		    	  pw.write("{\"Id\": \"" + list.getId() + "\",\"Year\": \"" + (list.getProdYear() != null ? list.getProdYear().getFinancialYear() : "") + "\",\"GrowerName\": \"" + (list.getGrower() != null ? list.getGrower().getGrower().getGrowerName() : "") + "\",\"Class\": \"" + (list.getSeedClass() != null ? list.getSeedClass().getItemClassName() : "") + "\",\"Crop\": \"" + (list.getCrop() != null ? list.getCrop().getNomenclature() : "") + "\",\"Variety\": \"" + (list.getSeedVariety() != null ? list.getSeedVariety().getItemVarietyName() : "") + "\",\"PreparedBy\":\"" + (list.getLastChgBy() != null ? list.getLastChgBy().getFirstName() + " " + list.getLastChgBy().getLastName() : "") + "\",\"TempLotNo\":\"" + list.getTempLotNo() + "\",\"PaymentStatus\":\"" + list.getPaymentStatus() + "\",\"totalRecords\":\"" + totalRecords + "\"}");
		      }
		      counter++;
		    }
		    pw.write("]");
		  }
		  catch (Exception e)
		  {
			  pendingListForGrowerPayment.clear();
		    e.printStackTrace();
		  }
		  pendingListForGrowerPayment.clear();
		  
		  return null;
	}*/
	public ModelAndView ProductionPaymentJsp(HttpServletRequest request,HttpServletResponse response) {
		
		
		
		Map<String, Object> datamap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		/*List<ProdGrowerPayment> pastHistoryOfPayment  = new ArrayList<ProdGrowerPayment>();
		List<DgSeedQualityInspection> growerDetails = new ArrayList<DgSeedQualityInspection>();		*/
		
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);	
		String jsp ="";
		
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		
		datamap = accountHandlerService.displayProductionPaymentJsp(box);
		if(datamap.get("growerDetails") != null)
		{
			map.put("purchase_rate", datamap.get("purchase_rate"));
			map.put("growerDetails", datamap.get("growerDetails"));
			map.put("pastHistoryOfPayment", datamap.get("pastHistoryOfPayment"));
			map.put("growerDeductionDetails", datamap.get("growerDeductionDetails"));
			map.put("SupervisionCharges", datamap.get("SupervisionCharges"));
		}
		
		  jsp = "production_payment";
		  jsp += ".jsp";
		  String title = "Advance/Final Payment To Grower";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  
		  return new ModelAndView("index", "map", map);
		
		
	}
	public ModelAndView submitProductionPaymentJsp(HttpServletRequest request,HttpServletResponse response) {
		
		
		Map<String, Object> datamap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	/*	List<ProdGrowerPayment> pastHistoryOfPayment  = new ArrayList<ProdGrowerPayment>();
		List<DgSeedQualityInspection> growerDetails = new ArrayList<DgSeedQualityInspection>();	*/	
		
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);	
		
		
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		
			
		
		map = accountHandlerService.submitProductionPaymentJsp(box);
		
		datamap = accountHandlerService.displayProductionPaymentJsp(box);
		if(datamap.get("growerDetails") != null)
		{
			
			map.put("purchase_rate", datamap.get("purchase_rate"));
			map.put("growerDetails", datamap.get("growerDetails"));
			map.put("pastHistoryOfPayment", datamap.get("pastHistoryOfPayment"));
			map.put("growerDeductionDetails", datamap.get("growerDeductionDetails"));
			map.put("SupervisionCharges", datamap.get("SupervisionCharges"));
		}
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Submit Successfully.";
		} else {
			message = "Try Again!";
		}
		// map = accountHandlerService.showCashVoucherJsp(box);
		 map.put("message", message);
		 map.put("saved", saved);
		  String jsp = "production_payment";
		  jsp += ".jsp";
		  String title = "Advance/Final Payment To Grower";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  
		  return new ModelAndView("index", "map", map);
	}
	/*
	 * By Ujjwal Kashyap @ Bangalore for New Account Group Master
	 */
	public ModelAndView showAccountsGroupMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		/*if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			generalMap.put("locationId", locationId);
		}*/
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			generalMap.put("fYear", fYear);
		}
		
		map = accountHandlerService.showAccountsGroupMasterJsp(generalMap);
		String jsp = "accountGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView addAccountGroupNew(HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object>map=new HashMap<String,Object>();
		Map<String,Object>generalMap=new HashMap<String,Object>();
		int groupCode=0;
		HttpSession session=request.getSession();
		
		
		
		if(request.getParameter(SEARCH_NAME)!=null && !request.getParameter(SEARCH_NAME).equals("")){
			groupCode= Integer.parseInt(request.getParameter(SEARCH_NAME));
		}
		String groupDescription="";
		if(request.getParameter("discription")!=null && !request.getParameter("discription").equals("")){
			groupDescription=request.getParameter("discription");
		}
		MasStoreFinancial msf = new MasStoreFinancial();
	
			msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
			
		

		FaMasAccountGroup fag=new FaMasAccountGroup();
		fag.setAccountGroupCode(groupCode);
		fag.setAccountGroupDesc(groupDescription);
		fag.setClBalanceCr(new BigDecimal(0));
		fag.setClBalanceDr(new BigDecimal(0));
	
		fag.setFYear(msf);
		
		
		Users users = new Users();
		int changedBy =0;
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			 changedBy = users.getId();
		}
		Users user=new Users();
		user.setId(changedBy);
		fag.setLastChgBy(user);
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		fag.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		fag.setLastChgTime(time);
		
		fag.setOpBalanceDr(new BigDecimal(0));
		fag.setOpBalanceCr(new BigDecimal(0));
		fag.setStatus("y");
		fag.setYtdAmountCr(new BigDecimal(0));
		fag.setYtdAmountDr(new BigDecimal(0));
		
		generalMap.put("fag", fag);
		generalMap.put("fYear", msf.getId());
		map = accountHandlerService.addAccountGroupNew(generalMap);
		String jsp="accountGroupNew";
		jsp+= ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView updateAccountGroupNew(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}
		

		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.updateAccountGroupNew(box);
		String jsp = "accountGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView deleteAccountGroupNew(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}
		

		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.deleteAccountGroupNew(box);
		String jsp = "accountGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showAccountSubGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		/*if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			generalMap.put("locationId", locationId);
		}*/
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			generalMap.put("fYear", fYear);
		}
		
		map = accountHandlerService.showAccountSubGroupNew(generalMap);
		String jsp = "accountSubGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addAccountSubGroupNew(HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object > map=new HashMap<String,Object>();
		Map<String,Object>generalMap=new HashMap<String,Object>();
		int subGroupCode=0;
		HttpSession session=request.getSession();
		
		if(request.getParameter(CODE)!=null && !request.getParameter(CODE).equals("")){
			subGroupCode= Integer.parseInt(request.getParameter(CODE));
		}
		
		String subgroupName="";
		if(request.getParameter(SEARCH_NAME)!=null && !request.getParameter(SEARCH_NAME).equals("")){
			subgroupName=request.getParameter(SEARCH_NAME);
		}
		MasStoreFinancial msf = new MasStoreFinancial();
		
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		int accountGroupId=0;
		if(request.getParameter(DISTRICT_ID)!=null){
			accountGroupId=Integer.parseInt(request.getParameter(DISTRICT_ID));
		}
		FaMasAccountSubGroup fasg=new FaMasAccountSubGroup();
		
		FaMasAccountGroup fag=new FaMasAccountGroup();
		fag.setId(accountGroupId);
		fasg.setAccountGroup(fag);
		
		fasg.setAccountSubGroupCode(subGroupCode);
		fasg.setAccountSubGroupName(subgroupName);
		fasg.setClBalanceCr(new BigDecimal(0));
		fasg.setClBalanceDr(new BigDecimal(0));
	
		
		fasg.setFYear(msf);
		
		
		Users users = new Users();
		int changedBy =0;
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			 changedBy = users.getId();
		}
		Users user=new Users();
		user.setId(changedBy);
		fasg.setLastChgBy(user);
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		fasg.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		fasg.setLastChgTime(time);
		
		fasg.setOpBalanceDr(new BigDecimal(0));
		fasg.setOpBalanceCr(new BigDecimal(0));
		fasg.setStatus("y");
		fasg.setYtdAmountCr(new BigDecimal(0));
		fasg.setYtdAmountDr(new BigDecimal(0));
		
		generalMap.put("fasg", fasg);
		generalMap.put("fYear", msf.getId());
		map = accountHandlerService.addAccountSubGroupNew(generalMap);
		
		String jsp = "accountSubGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView updateAccountSubGroupNew(HttpServletRequest request, HttpServletResponse response) 
	 {
	  Map<String, Object> map = new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();

	  String accountSubGroupCode="";
	  String name="";
	  int accountGroupId=0;
	  int accountSubGroupId=0;
	  String changedBy="";
	  String title="";
	  Date changedDate = null;
	  String changedTime = "";
	  int userId=0;
	  String message="";
	  String jsp="";
	  String url="";
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
	  try{
		  if(request.getParameter(DISTRICT_ID) != null && !(request.getParameter(DISTRICT_ID).equals(""))){
			  accountGroupId =Integer.parseInt(request.getParameter(DISTRICT_ID));
			}
	   if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		   accountSubGroupId =Integer.parseInt( request.getParameter(COMMON_ID));
	   }
	   if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
		   accountSubGroupCode = request.getParameter(CODE);
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

	   generalMap.put("id", accountSubGroupId);
	   generalMap.put("blockCode", accountSubGroupCode);
	   generalMap.put("name", name);
	   generalMap.put("districtId",accountGroupId);
	   generalMap.put("userId", userId);
	   generalMap.put("currentDate", changedDate);
	   generalMap.put("currentTime", changedTime);
	  }catch (Exception e) {
		  e.printStackTrace();
	  }

	  boolean dataUpdated=false;
	  try{
	   dataUpdated=accountHandlerService.updateAccountSubGroupNew(generalMap);
	  }catch (Exception e) {
		  e.printStackTrace();
	  }
	  if(dataUpdated==true){
	   message="Record Updated Successfully !!";

	  }
	  else{
	   message="Record Cant be updated !!";
	  }

	  try{
		  int fYear = 0;
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
				generalMap.put("fYear", fYear);
			}
			
			map = accountHandlerService.showAccountSubGroupNew(generalMap);
	   
	  }catch (Exception e) {
		  e.printStackTrace();}
	  	 jsp="accountSubGroupNew";
		title="Edit Block";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	 }
	 public ModelAndView deleteAccountSubGroupNew(HttpServletRequest request, HttpServletResponse response) {
		  Map<String, Object> map = new HashMap<String, Object>();
		  Map<String, Object> generalMap = new HashMap<String, Object>();
		  String accountSubGroupCode="";
		  String name="";
		  int accountGroupId=0;
		  int accountSubGroupId=0;
		  String changedBy="";
		  String title="";
		  Date changedDate = null;
		  String changedTime = "";
		  int userId=0;
		  String message="";
		  String jsp="";
		  String url="";
		  
			HttpSession session = request.getSession();
			if (session.getAttribute("userId") != null)
				userId = (Integer) session.getAttribute("userId");
			
			String flag =""; 
			if(request.getParameter("flag") != null){
				flag = request.getParameter("flag"); 
				generalMap.put("flag", flag);
			}
		  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			  accountSubGroupId =Integer.parseInt( request.getParameter(COMMON_ID));
		  }
		  if(request.getParameter("title") != null){
		   title = request.getParameter("title"); 
		  }
		  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				changedBy = request.getParameter(CHANGED_BY);
			}
			changedDate= new Date();
			changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted=false;
		  dataDeleted=accountHandlerService.deleteAccountSubGroupNew(accountSubGroupId,generalMap);
		  if (dataDeleted==true)
		  {
		   message="Record is InActivated successfully !!";
		  }

		  else{
		   message="Record is Activated successfully !!";
		  }
		  url = "/hms/hms/generalMaster?method=showBlockJsp";
		  
		  try{
			  int fYear = 0;
				if (session.getAttribute("financialYear") != null) {
					fYear = (Integer) session.getAttribute("financialYear");
					generalMap.put("fYear", fYear);
				}
				
				map = accountHandlerService.showAccountSubGroupNew(generalMap);
		   
		  }catch (Exception e) {
			  e.printStackTrace();}
		  	 jsp="accountSubGroupNew";
			title="Edit Block";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		 }
	 
	 public ModelAndView searchAccountGroupNew(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			/*if (session.getAttribute("locationId") != null) {
				int locationId = (Integer) session.getAttribute("locationId");
				generalMap.put("locationId", locationId);
			}*/
			int fYear = 0;
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
				generalMap.put("fYear", fYear);
			}
			String accountGroupName="";
			if(request.getParameter(SEARCH_FIELD)!=null && !request.getParameter(SEARCH_FIELD).equals("")){
				accountGroupName=request.getParameter(SEARCH_FIELD);
				generalMap.put("accountGroupName", accountGroupName);
			}
				
			map = accountHandlerService.searchAccountGroupNew(generalMap);
			String jsp = "accountGroupNew";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("accountGroupName", accountGroupName);
			map.put("search", "search");
			return new ModelAndView("index", "map", map);
		}
	 public ModelAndView searchAccountSubGroup(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			/*if (session.getAttribute("locationId") != null) {
				int locationId = (Integer) session.getAttribute("locationId");
				generalMap.put("locationId", locationId);
			}*/
			int fYear = 0;
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
				generalMap.put("fYear", fYear);
			}
			String accountGroupName="";
			if(request.getParameter(SEARCH_FIELD)!=null && !request.getParameter(SEARCH_FIELD).equals("")){
				accountGroupName=request.getParameter(SEARCH_FIELD);
				generalMap.put("accountGroupName", accountGroupName);
			}
			int radioValue=0;
			
			if(request.getParameter(SELECTED_RADIO)!=null && !request.getParameter(SELECTED_RADIO).equals("")){
				radioValue=Integer.parseInt(request.getParameter(SELECTED_RADIO));
				generalMap.put("radioValue", radioValue);
			}
			System.out.println("generalMap controller===>"+generalMap);	
			map = accountHandlerService.searchAccountSubGroup(generalMap);
			String jsp = "accountSubGroupNew";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("accountGroupName",accountGroupName);
			return new ModelAndView("index", "map", map);
		}
	 public ModelAndView showAccountMasterJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			int fYear = 0;
			HttpSession session = request.getSession();
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
				generalMap.put("fYear", fYear);
			}
			if (session.getAttribute("locationId") != null) {
				int locationId = (Integer) session.getAttribute("locationId");
				generalMap.put("locationId", locationId);
			}
			int accountSubGroupId = 0;
			if (request.getParameter("accountSubGroupId") != null) {
				accountSubGroupId = Integer.parseInt(request
						.getParameter("accountSubGroupId"));
				generalMap.put("accountSubGroupId", accountSubGroupId);
				
						}
			
			map = accountHandlerService.showAccountMasterNew(generalMap);
			String jsp = "accountMaster";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
	 public ModelAndView showAccountSubLedgerJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			List<Object[]> growerList = new ArrayList<Object[]>();
			HttpSession session = request.getSession();
			
			MasStoreFinancial msf = new MasStoreFinancial();			
			msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
			
			int locationId = 0;
			if (session.getAttribute("hospitalId") != null) {
				locationId = (Integer) session.getAttribute("hospitalId");
			}
			Box box = HMSUtil.getBox(request);	
			
			box.put("locationId", locationId);
			/*growerList = marketingHandlerService.getGrowerList(box);*/
			detailsMap.put("fYear", msf.getId());
			detailsMap.put("locationId", locationId);
			map = accountHandlerService.showAccountSubLedgerJsp(detailsMap);
			String jsp = "fa_accountSubLedgerNew.jsp";
			map.put("contentJsp", jsp);
			map.put("growerList", growerList);
			return new ModelAndView("index", "map", map);
		}
	 
	 public ModelAndView showGrowerSubLedgerJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			List<Object[]> growerList = new ArrayList<Object[]>();
			HttpSession session = request.getSession();
			int fYear = 0;
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
			}
			int locationId = 0;
			if (session.getAttribute("locationId") != null) {
				locationId = (Integer) session.getAttribute("locationId");
			}
			Box box = HMSUtil.getBox(request);	
			
			box.put("locationId", locationId);
			growerList = marketingHandlerService.getGrowerList(box);
			detailsMap.put("fYear", fYear);
			detailsMap.put("locationId", locationId);
			detailsMap.put("flag", "grower");
			map = accountHandlerService.showAccountSubLedgerJsp(detailsMap);
			String jsp = "fa_GrowerSubLedgerNew.jsp";
			map.put("contentJsp", jsp);
			map.put("growerList", growerList);
			return new ModelAndView("index", "map", map);
		}
	 
	 
	 public ModelAndView showRSKSubLedgerJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			List<Object[]> growerList = new ArrayList<Object[]>();
			HttpSession session = request.getSession();
			int fYear = 0;
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
			}
			int locationId = 0;
			if (session.getAttribute("locationId") != null) {
				locationId = (Integer) session.getAttribute("locationId");
			}
			Box box = HMSUtil.getBox(request);	
			
			box.put("locationId", locationId);
			growerList = marketingHandlerService.getGrowerList(box);
			detailsMap.put("fYear", fYear);
			detailsMap.put("locationId", locationId);
			detailsMap.put("flag", "rsk");
			map = accountHandlerService.showAccountSubLedgerJsp(detailsMap);
			String jsp = "fa_RSKSubLedgerNew.jsp";
			map.put("contentJsp", jsp);
			map.put("growerList", growerList);
			return new ModelAndView("index", "map", map);
		}
	 
	 
	 


public ModelAndView showAccountOpeningBalance(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	String fYearDesc = "";
	if (session.getAttribute("fYearDesc") != null) {
		fYearDesc = (String) session.getAttribute("fYearDesc");
		box.put("fYearDesc", fYearDesc);
	}
	if (session.getAttribute("hospitalId") != null) {
		int locationId = (Integer) session.getAttribute("hospitalId");
		box.put("locationId", locationId);
	}
	map = accountHandlerService.showJournalVoucherJsp(box);
	String jsp = "fa_AcountOpeningBalance" + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView submitOpeningBalance(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	if (session.getAttribute("hospitalId") != null) {
		int locationId = (Integer) session.getAttribute("hospitalId");
		box.put("locationId", locationId);
	}
	if (session.getAttribute("users") != null) {
		Users users = (Users) session.getAttribute("users");
		int changedBy = users.getId();
		box.put("changedBy", changedBy);
	}
	MasStoreFinancial msf = new MasStoreFinancial();	
	msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
	box.put("fYear", msf.getId());
	
	
	String fYearDesc = "";
	if (session.getAttribute("fYearDesc") != null) {
		fYearDesc = (String) session.getAttribute("fYearDesc");
		box.put("fYearDesc", fYearDesc);
	}
	map = accountHandlerService.submitOpeningBalance(box);
	String voucherNo="";
	if(map.get("voucherNo1")!=null){
		voucherNo=(String)map.get("voucherNo1");
	}
	boolean saved = false;
	String message = "";
	if (map.get("saved") != null) {
		saved = (Boolean) map.get("saved");
	}
	if (saved) {
		message = "Opening Balanace Saved Successfully with Voucher No="+voucherNo+".Do You want to  Print Report?";
	} else {
		message = "Try Again!";
	}
	map.put("message", message);
	String voucherType = "OP";
	map.put("voucherType1", voucherType);
	if (map.get("voucherNo") != null) {
		map.put("voucherNo", map.get("voucherNo"));
	}
	map.put("fyear", msf.getId());
	map.put("voucherDate", box.getString(VOUCHER_DATE));
	String url = "/hms/hms/account?method=showAccountOpeningBalance";
	map.put("url", url);
	String jsp = "fa_msgForVoucher" + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView getAccountCodeForAutoCompleteOP(
		HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> parameterMap = new HashMap<String, Object>();
	/*
	 * int financialYearId = 0; if(request.getParameter("financialYearId")!=
	 * null){ financialYearId
	 * =Integer.parseInt(request.getParameter("financialYearId")); }
	 * parameterMap.put("financialYearId", financialYearId);
	 */
	HttpSession session=request.getSession();
	int locationId = 0;
	if (session.getAttribute("locationId") != null) {
		locationId = (Integer) session.getAttribute("locationId");
		parameterMap.put("locationId", locationId);
	}
	
	String fieldName = "";
	String accountNameStr = "";
	if (request.getParameter("requiredField") != null) {
		fieldName = request.getParameter("requiredField");
	}
	if (request.getParameter(fieldName) != null) {
		accountNameStr = request.getParameter(fieldName);
	}
	if (request.getParameter("amtType") != null) {
		String amtType = request.getParameter("amtType");
		parameterMap.put("amtType", amtType);
	}

	if (request.getParameter("salesVoucherType") != null) {
		String salesVoucherType = request.getParameter("salesVoucherType");
		parameterMap.put("salesVoucherType", salesVoucherType);
	}
	parameterMap.put("accountNameStr", accountNameStr);
	map = accountHandlerService.getAccountCodeForAutoComplete(parameterMap);
	String jsp = "";
	jsp = "responseForCashVoucherOP";
	// map.put("financialYearId", financialYearId);
	return new ModelAndView(jsp, "map", map);
}
public ModelAndView getSubLedgerForAccountOP(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> parameterMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	MasStoreFinancial msf = new MasStoreFinancial();	
	msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
	parameterMap.put("fYear", msf.getId());
	int locationId=0;
	if (session.getAttribute("hospitalId") != null) {
		locationId = (Integer) session.getAttribute("hospitalId");
	}
	parameterMap.put("locationId", locationId);
	
	
	// -----------commented by anamika on 20th august----------
	/*
	 * String flagForSL = ""; if(request.getParameter("flagForSL11")!=
	 * null){ flagForSL = request.getParameter("flagForSL11"); }
	 */
	String accName = "";
	if (request.getParameter("accName") != null) {
		accName = request.getParameter("accName");
	}

	String flag="";
	if(request.getParameter("flagValueOP")!=null && !request.getParameter("flagValueOP").isEmpty()){
		flag= request.getParameter("flagValueOP");
		parameterMap.put("flag", flag);
	}
	
	Integer index1 = 0;
	index1 = accName.lastIndexOf("[") + 1;

	int index2 = accName.lastIndexOf("]");
	String accountName = accName.substring(index1, index2);

	parameterMap.put("accountName", accountName);
	map = accountHandlerService.getSubLedgerForAccount(parameterMap);
	map.put("rowVal", request.getParameter("rowVal"));
	// map.put("flagForSL", flagForSL);
	// map.put("financialYearId", financialYearId);
	String jsp = "";
	jsp = "responseForSubLedgerOP";

	return new ModelAndView(jsp, "map", map);
}


					
public ModelAndView showAccountTransactionDetails(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> accountList = new ArrayList<Object[]>();
	List<Object[]> subledgerList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();
	List<Object[]> centreList = new ArrayList<Object[]>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	String fYearDesc = "";
	if (session.getAttribute("fYearDesc") != null) {
		fYearDesc = (String) session.getAttribute("fYearDesc");
		box.put("fYearDesc", fYearDesc);
	}
	
	if (session.getAttribute("hospitalId") != null) {
		int locationId = (Integer) session.getAttribute("hospitalId");
		box.put("locationId", locationId);
	}
	
	/*centreList = marketingHandlerService.getCentreAndHOList();*/
	accountList = accountHandlerService.getAccountList(box);
	/*subledgerList = accountHandlerService.getSubledgerList(box);*/
	map.put("accountList", accountList);
	map.put("subledgerList", subledgerList);
	map.put("financialYearList", financialYearList);
	map.put("centreList", centreList);
	String jsp = "fa_account_transaction_details" + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
					
public ModelAndView getConsolidatedTransactionDetails(HttpServletRequest request,HttpServletResponse response)

{
	
	Map<String,Object> map = new HashMap<String,Object>();
	List<AccountMainTransac> accountList = new ArrayList<AccountMainTransac>();
	List<AccountSubLedTransac> subledgerList = new ArrayList<AccountSubLedTransac>();
	
	Box box = HMSUtil.getBox(request);	
	
	String TransactionType = "";
	TransactionType = box.getString("TransactionType");
	
	HttpSession session = request.getSession();
	int locationId = 0;
	if (session.getAttribute("locationId") != null) {
		locationId =  (Integer)session.getAttribute("locationId");
	}
	map = accountHandlerService.getConsolidatedTransactionDetails(box);
	
	if(map.get("accountList")!= null)
	{
		accountList =(ArrayList) map.get("accountList");
	}
	
	if(map.get("subledgerList")!= null)
	{
		subledgerList =(ArrayList) map.get("subledgerList");
	}
	
	int totalRecords = 0;
	if(map.get("totalRecords")!= null)
	{
		totalRecords = (Integer) map.get("totalRecords");
	}
	
	if(TransactionType.equalsIgnoreCase("Account"))
	{
			try
			{
				PrintWriter pw = response.getWriter();	
				
				pw.write("[");
				int counter=1;
				
				for(AccountMainTransac list : accountList)
				{
					
					
				    if(counter != accountList.size())
				    {
				    	
				    		pw.write("{\"Id\": \""+list.getAccount().getId()+"\",\"LastChangedDate\": \""+(list.getTransactionDate() != null? HMSUtil.changeDateToddMMyyyy(list.getTransactionDate()):"")+"\",\"Name\": \""+(list.getAccount()!=null?list.getAccount().getAccDesc():"")+"\",\"ytd_dr\": \""+list.getYtdAmountDr()+"\",\"ytd_cr\": \""+list.getYtdAmountCr()+"\",\"opening_dr\": \""+list.getOpBalanceDr()+"\",\"opening_cr\": \""+list.getOpBalanceCr()+"\",\"closing_dr\": \""+list.getClBalanceDr()+"\",\"closing_cr\": \""+list.getClBalanceCr()+"\",\"totalRecords\":\""+totalRecords+"\"},");
				    	
				    }
				    else
				    {		    	
				    	pw.write("{\"Id\": \""+list.getAccount().getId()+"\",\"LastChangedDate\": \""+(list.getTransactionDate() != null? HMSUtil.changeDateToddMMyyyy(list.getTransactionDate()):"")+"\",\"Name\": \""+(list.getAccount()!=null?list.getAccount().getAccDesc():"")+"\",\"ytd_dr\": \""+list.getYtdAmountDr()+"\",\"ytd_cr\": \""+list.getYtdAmountCr()+"\",\"opening_dr\": \""+list.getOpBalanceDr()+"\",\"opening_cr\": \""+list.getOpBalanceCr()+"\",\"closing_dr\": \""+list.getClBalanceDr()+"\",\"closing_cr\": \""+list.getClBalanceCr()+"\",\"totalRecords\":\""+totalRecords+"\"}");
				    	
				    }
				
				    counter++;		
				}
				
				
				pw.write("]");
				
				
			}
			
			catch(Exception e)
			{
				accountList.clear();
				e.printStackTrace();
			}	
	}
	
	if(TransactionType.equalsIgnoreCase("Subledger"))
	{
			try
			{
				PrintWriter pw = response.getWriter();	
				
				pw.write("[");
				int counter=1;
				
				for(AccountSubLedTransac list : subledgerList)
				{
					
					
				    if(counter != subledgerList.size())
				    {
				    	
				    	pw.write("{\"Id\": \""+list.getSubLed().getId()+"\",\"LastChangedDate\": \""+(list.getTransactionDate() != null? HMSUtil.changeDateToddMMyyyy(list.getTransactionDate()):"")+"\",\"Name\": \""+(list.getSubLed()!=null?list.getSubLed().getSubLedDesc():"")+"\",\"ytd_dr\": \""+list.getYtdAmountDr()+"\",\"ytd_cr\": \""+list.getYtdAmountCr()+"\",\"opening_dr\": \""+list.getOpBalanceDr()+"\",\"opening_cr\": \""+list.getOpBalanceCr()+"\",\"closing_dr\": \""+list.getClBalanceDr()+"\",\"closing_cr\": \""+list.getClBalanceCr()+"\",\"totalRecords\":\""+totalRecords+"\"},");
				    	
				    }
				    else
				    {		    	
				    	pw.write("{\"Id\": \""+list.getSubLed().getId()+"\",\"LastChangedDate\": \""+(list.getTransactionDate() != null? HMSUtil.changeDateToddMMyyyy(list.getTransactionDate()):"")+"\",\"Name\": \""+(list.getSubLed()!=null?list.getSubLed().getSubLedDesc():"")+"\",\"ytd_dr\": \""+list.getYtdAmountDr()+"\",\"ytd_cr\": \""+list.getYtdAmountCr()+"\",\"opening_dr\": \""+list.getOpBalanceDr()+"\",\"opening_cr\": \""+list.getOpBalanceCr()+"\",\"closing_dr\": \""+list.getClBalanceDr()+"\",\"closing_cr\": \""+list.getClBalanceCr()+"\",\"totalRecords\":\""+totalRecords+"\"}");
				    	
				    }
				
				    counter++;		
				}
				
				
				pw.write("]");
				
				
			}
			
			catch(Exception e)
			{
				subledgerList.clear();
				e.printStackTrace();
			}	
	}
	accountList.clear();
	subledgerList.clear();
	return null;		
	

}

public ModelAndView popUpOfViewTransactionHistory(HttpServletRequest request, HttpServletResponse response)
{
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> parameterMap = new HashMap<String,Object>();
	List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
	
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	int accountId = 0;
	String accountCode ="";
	if(request.getParameter("Id") != null)
	{
		accountId  = Integer.parseInt(request.getParameter("Id"));
	}
	int locationId = box.getInt("locationId");
	subLedList = accountHandlerService.getSubLedListForAccountId(accountId,locationId);
	map.put("subLedList",subLedList);
	return new ModelAndView("popUpOfTransactionHistory", "map", map);
}

public ModelAndView getTransactionHistory(HttpServletRequest request,HttpServletResponse response)
{	
	Map<String,Object> map = new HashMap<String,Object>();
	List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();
	
	Box box = HMSUtil.getBox(request);
	String TransactionType="";
	TransactionType = box.getString("TransactionType");
	
	map = accountHandlerService.getTransactionHistory(box);
	
	if(map.get("voucherDetails")!= null)
	{
		voucherDetails =(ArrayList) map.get("voucherDetails");
	}
	
	int totalRecords = 0;
	if(map.get("totalRecords")!= null)
	{
		totalRecords = (Integer) map.get("totalRecords");
	}
	
	if(TransactionType.equalsIgnoreCase("S"))
	{
		try
		{
			PrintWriter pw = response.getWriter();			
			pw.write("[");
			int counter=1;
			
			for(FaVoucherDetails list : voucherDetails)
			{	
				
			    if(counter != voucherDetails.size())
			    {
			    	pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+HMSUtil.convertDateToStringWithoutTime(list.getVoucherHeader().getVoucherDate())+"\",\"Name\": \""+(list.getSubLed()!=null?list.getSubLed().getSubLedDesc():"")+"\",\"DrAmount\": \""+(list.getDrAmount()!=null?list.getDrAmount().doubleValue():"0")+"\",\"CrAmount\": \""+(list.getCrAmount()!=null?list.getCrAmount().doubleValue():"0")+"\",\"Narration\": \""+(list.getVoucherHeader().getNarration()!=null?list.getVoucherHeader().getNarration():"")+"\",\"LastChgBy\":\""+(list.getVoucherHeader().getLastChgBy()!=null?list.getVoucherHeader().getLastChgBy().getFirstName():"")+"\",\"totalRecords\":\""+totalRecords+"\"},");
			    }
			    else
			    {
			    	pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+HMSUtil.convertDateToStringWithoutTime(list.getVoucherHeader().getVoucherDate())+"\",\"Name\": \""+(list.getSubLed()!=null?list.getSubLed().getSubLedDesc():"")+"\",\"DrAmount\": \""+(list.getDrAmount()!=null?list.getDrAmount().doubleValue():"0")+"\",\"CrAmount\": \""+(list.getCrAmount()!=null?list.getCrAmount().doubleValue():"0")+"\",\"Narration\": \""+(list.getVoucherHeader().getNarration()!=null?list.getVoucherHeader().getNarration():"")+"\",\"LastChgBy\":\""+(list.getVoucherHeader().getLastChgBy()!=null?list.getVoucherHeader().getLastChgBy().getFirstName():"")+"\",\"totalRecords\":\""+totalRecords+"\"}");
			    }
			
			    counter++;		
			}		
			
			pw.write("]");		
			
		}
		
		catch(Exception e)
		{
			voucherDetails.clear();
			e.printStackTrace();
		}	
	}
	
	
	if(TransactionType.equalsIgnoreCase("A"))
	{
		try
		{
			PrintWriter pw = response.getWriter();			
			pw.write("[");
			int counter=1;
			
			for(FaVoucherDetails list : voucherDetails)
			{	
				
			    if(counter != voucherDetails.size())
			    {
			    	pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+HMSUtil.convertDateToStringWithoutTime(list.getVoucherHeader().getVoucherDate())+"\",\"Name\": \""+(list.getAccount()!=null?list.getAccount().getAccDesc():"")+"\",\"Subledname\": \""+(list.getSubLed()!=null?list.getSubLed().getSubLedDesc():"")+"\",\"DrAmount\": \""+(list.getDrAmount()!=null?list.getDrAmount().doubleValue():"0")+"\",\"CrAmount\": \""+(list.getCrAmount()!=null?list.getCrAmount().doubleValue():"0")+"\",\"Narration\": \""+(list.getVoucherHeader().getNarration()!=null?list.getVoucherHeader().getNarration():"")+"\",\"LastChgBy\":\""+(list.getVoucherHeader().getLastChgBy()!=null?list.getVoucherHeader().getLastChgBy().getFirstName():"")+"\",\"totalRecords\":\""+totalRecords+"\"},");
			    }
			    else
			    {
			    	pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+HMSUtil.convertDateToStringWithoutTime(list.getVoucherHeader().getVoucherDate())+"\",\"Name\": \""+(list.getAccount()!=null?list.getAccount().getAccDesc():"")+"\",\"Subledname\": \""+(list.getSubLed()!=null?list.getSubLed().getSubLedDesc():"")+"\",\"DrAmount\": \""+(list.getDrAmount()!=null?list.getDrAmount().doubleValue():"0")+"\",\"CrAmount\": \""+(list.getCrAmount()!=null?list.getCrAmount().doubleValue():"0")+"\",\"Narration\": \""+(list.getVoucherHeader().getNarration()!=null?list.getVoucherHeader().getNarration():"")+"\",\"LastChgBy\":\""+(list.getVoucherHeader().getLastChgBy()!=null?list.getVoucherHeader().getLastChgBy().getFirstName():"")+"\",\"totalRecords\":\""+totalRecords+"\"}");
			    }
			
			    counter++;		
			}		
			
			pw.write("]");		
			
		}
		
		catch(Exception e)
		{
			voucherDetails.clear();
			e.printStackTrace();
		}	
	}
	voucherDetails.clear();
	return null;

}




public ModelAndView getSubledgerTransactionDetails(HttpServletRequest request,HttpServletResponse response)
{	
	Map<String,Object> map = new HashMap<String,Object>();
	List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();
	
	Box box = HMSUtil.getBox(request);
	String TransactionType="";
	TransactionType = box.getString("TransactionType");
	
	map = accountHandlerService.getSubledgerTransactionDetails(box);
	
	int totalRecords = 0;
	if(map.get("totalRecords")!= null)
	{
		totalRecords = (Integer) map.get("totalRecords");
	}
	
	if(map.get("voucherDetails")!= null)
	{
		voucherDetails = (List) map.get("voucherDetails");
	}
	
	if(TransactionType.equalsIgnoreCase("S"))
	{
		try
		{
			PrintWriter pw = response.getWriter();			
			pw.write("[");
			int counter=1;
			
			for(FaVoucherDetails list : voucherDetails)
			{	
				
			    if(counter != voucherDetails.size())
			    {
			    	pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+HMSUtil.convertDateToStringWithoutTime(list.getVoucherHeader().getVoucherDate())+"\",\"Name\": \""+(list.getAccount()!=null?list.getAccount().getAccDesc():"")+"\",\"Subledname\": \""+(list.getSubLed()!=null?list.getSubLed().getSubLedDesc():"")+"\",\"DrAmount\": \""+(list.getDrAmount()!=null?list.getDrAmount().doubleValue():"0")+"\",\"CrAmount\": \""+(list.getCrAmount()!=null?list.getCrAmount().doubleValue():"0")+"\",\"Narration\": \""+(list.getVoucherHeader().getNarration()!=null?list.getVoucherHeader().getNarration():"")+"\",\"LastChgBy\":\""+(list.getVoucherHeader().getLastChgBy()!=null?list.getVoucherHeader().getLastChgBy().getFirstName():"")+"\",\"totalRecords\":\""+totalRecords+"\"},");
			    }
			    else
			    {
			    	pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+HMSUtil.convertDateToStringWithoutTime(list.getVoucherHeader().getVoucherDate())+"\",\"Name\": \""+(list.getAccount()!=null?list.getAccount().getAccDesc():"")+"\",\"Subledname\": \""+(list.getSubLed()!=null?list.getSubLed().getSubLedDesc():"")+"\",\"DrAmount\": \""+(list.getDrAmount()!=null?list.getDrAmount().doubleValue():"0")+"\",\"CrAmount\": \""+(list.getCrAmount()!=null?list.getCrAmount().doubleValue():"0")+"\",\"Narration\": \""+(list.getVoucherHeader().getNarration()!=null?list.getVoucherHeader().getNarration():"")+"\",\"LastChgBy\":\""+(list.getVoucherHeader().getLastChgBy()!=null?list.getVoucherHeader().getLastChgBy().getFirstName():"")+"\",\"totalRecords\":\""+totalRecords+"\"}");
			    }
			
			    counter++;		
			}		
			
			pw.write("]");		
			
		}
		
		catch(Exception e)
		{
			voucherDetails.clear();
			e.printStackTrace();
		}	
	}

	voucherDetails.clear();
	return null;

}



public ModelAndView makeFinalBudget(HttpServletRequest request,HttpServletResponse response)
{
	
	Map<String,Object>map = new HashMap<String,Object>();
	List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();	
	
	
	HttpSession session = request.getSession();
	int locationId = 0;
	if (session.getAttribute("locationId") != null) {
		locationId =  (Integer)session.getAttribute("locationId");
	}
	
	seedCategoryList = marketingHandlerService.getSeedCategoryList();		
	financialYearList = marketingHandlerService.getFinancialYearList();
	
	
		
	String jsp = "makeFinalBudget";
	
	jsp += ".jsp";
	
	String title = "Prepare Final Budget- Accounts";
	
	
	
	map.put("financialYearList", financialYearList);
	
	map.put("seedCategoryList", seedCategoryList);
	
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView getConsolidatedBudgetOfDivision(HttpServletRequest request,HttpServletResponse response)
{
	
	List<Object[]> consolidateBudgetAmountForDivision = new ArrayList<Object[]>();
	Map<String,Object> datamap = new HashMap<String,Object>();
	
	Box box = HMSUtil.getBox(request);
	
	boolean bHOConsolidatedBudgetExist = false;
	
	datamap = accountHandlerService.getConsolidatedBudgetOfDivision(box);
	if(datamap.get("consolidateBudgetAmountForDivision") != null)
	{
		consolidateBudgetAmountForDivision = (List<Object[]>) datamap.get("consolidateBudgetAmountForDivision");
		
	}
	
	
	try
	{
		PrintWriter pw = response.getWriter();	
		
		pw.write("[");
		int counter=1;
		
		if(consolidateBudgetAmountForDivision.size()>0)
		{
			for(Object[] amount: consolidateBudgetAmountForDivision)
			{
				if(counter != consolidateBudgetAmountForDivision.size())
			    {
			    	pw.write("{\"Id\": \""+counter+"\",\"deptId\": \""+amount[0]+"\",\"Name\": \""+amount[1]+"\",\"Amount\": \""+amount[2]+"\",\"totalRecords\":\""+consolidateBudgetAmountForDivision.size()+"\"},");
			    }
			    else
			    {
			    	pw.write("{\"Id\": \""+counter+"\",\"deptId\": \""+amount[0]+"\",\"Name\": \""+amount[1]+"\",\"Amount\": \""+amount[2]+"\",\"totalRecords\":\""+consolidateBudgetAmountForDivision.size()+"\"}");
			    }
			
			    counter++;	
			}
		}		
			
		pw.write("]");	
		
	}
	
	catch(Exception e)
	{
		consolidateBudgetAmountForDivision.clear();
		e.printStackTrace();
	}
	consolidateBudgetAmountForDivision.clear();
	return null;
}

public ModelAndView popUpOfViewAndUpdateFinalBudgetAmountCentreWise(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map = new HashMap<String,Object>();
	
	List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();	
	
	seedCategoryList = marketingHandlerService.getSeedCategoryList();		
	financialYearList = marketingHandlerService.getFinancialYearList();
	
	
	map.put("financialYearList", financialYearList);
	map.put("seedCategoryList", seedCategoryList);
	
	return new ModelAndView("popUpOfViewAndUpdateFinalBudgetAmountCentreWise", "map", map);
}

public ModelAndView GetBudgetAmountForEachCentre(HttpServletRequest request, HttpServletResponse response)
{
	List<Object[]> budgetAmount = new ArrayList<Object[]>();
	
	Box box = HMSUtil.getBox(request);
	budgetAmount = accountHandlerService.GetBudgetAmountForEachCentre(box);
	try
	{
		PrintWriter pw = response.getWriter();	
		
		pw.write("[");
		int counter=1;
		
		if(budgetAmount.size()>0)
		{
			for(Object[] amount: budgetAmount)
			{
				if(counter != budgetAmount.size())
			    {
			    	pw.write("{\"Id\": \""+amount[0]+"\",\"Dept\": \""+amount[1]+"\",\"Name\": \""+amount[2]+"\",\"Amount\": \""+amount[3]+"\",\"totalRecords\":\""+budgetAmount.size()+"\"},");
			    }
			    else
			    {
			    	pw.write("{\"Id\": \""+amount[0]+"\",\"Dept\": \""+amount[1]+"\",\"Name\": \""+amount[2]+"\",\"Amount\": \""+amount[3]+"\",\"totalRecords\":\""+budgetAmount.size()+"\"}");
			    }
			
			    counter++;	
			}
			
			   
		}		
			
		pw.write("]");	
		
	}
	
	catch(Exception e)
	{
		budgetAmount.clear();
		e.printStackTrace();
	}
	budgetAmount.clear();
	return null;
}



public ModelAndView popUpOfViewUpdateBudgetComponentAmount(HttpServletRequest request, HttpServletResponse response)
{
	Map<String,Object> map = new HashMap<String,Object>();
	List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();
	List<Object[]> departmentList = new ArrayList<Object[]>();
	List<Object[]> centreList = new ArrayList<Object[]>();
	
	seedCategoryList = marketingHandlerService.getSeedCategoryList();		
	financialYearList = marketingHandlerService.getFinancialYearList();	
	centreList = marketingHandlerService.getCentreList();
	departmentList = marketingHandlerService.getDepartmentList();
	
	map.put("financialYearList", financialYearList);
	map.put("seedCategoryList", seedCategoryList);
	map.put("centreList", centreList);
	map.put("departmentList", departmentList);
	
	return new ModelAndView("popUpOfViewUpdateBudgetComponentAmountFinalStage", "map", map);
}

public ModelAndView GetBudgetComponentAmount(HttpServletRequest request, HttpServletResponse response)
{
	List<Object[]> componentAmount = new ArrayList<Object[]>();
	Map<String,Object> datamap = new HashMap<String,Object>();
	
	Box box = HMSUtil.getBox(request);
	datamap = accountHandlerService.GetBudgetComponentAmount(box);
	if(datamap.get("componentAmount") != null)
	{
		componentAmount = (List<Object[]>) datamap.get("componentAmount");
	}
	
	try
	{
		PrintWriter pw = response.getWriter();	
		
		pw.write("[");
		int counter=1;
		
		if(componentAmount.size()>0)
		{
			for(Object[] amount: componentAmount)
			{
				if(counter != componentAmount.size())
			    {
			    	pw.write("{\"SNo\": \""+counter+"\",\"Id\": \""+amount[0]+"\",\"ComponentName\": \""+amount[1]+"\",\"Amount\": \""+amount[2]+"\",\"totalRecords\":\""+componentAmount.size()+"\"},");
			    }
			    else
			    {
			    	pw.write("{\"SNo\": \""+counter+"\",\"Id\": \""+amount[0]+"\",\"ComponentName\": \""+amount[1]+"\",\"Amount\": \""+amount[2]+"\",\"totalRecords\":\""+componentAmount.size()+"\"}");
			    }
			
			    counter++;	
			}
			
			   
		}		
			
		pw.write("]");	
		
	}
	
	catch(Exception e)
	{
		componentAmount.clear();
		e.printStackTrace();
	}
	componentAmount.clear();
	return null;
}



public ModelAndView updateBudgetComponentAmount(HttpServletRequest request, HttpServletResponse response)
{
	
	Map<String,Object> datamap = new HashMap<String,Object>();
	
	Box box = HMSUtil.getBox(request);
	boolean bUpdate = false;
	datamap = accountHandlerService.updateBudgetComponentAmount(box);
	if(datamap.get("bUpdate") != null)
	{
		bUpdate = (Boolean) datamap.get("bUpdate");
	}
	
	
		try
	{
		PrintWriter pw = response.getWriter();	
		if(bUpdate)
		pw.write("success~~"+bUpdate);
		else
			pw.write("failure~~"+bUpdate);
			
		
	}
	
	catch(Exception e)
	{		
		e.printStackTrace();
	}
	return null;
}

public ModelAndView submitFinalBudget(HttpServletRequest request, HttpServletResponse response)
{
	Map<String,Object>datamap = new HashMap<String,Object>();	
	Map<String,Object>map = new HashMap<String,Object>();
	List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();	
	
	HttpSession session = request.getSession();
	int locationId = 0;
	if (session.getAttribute("locationId") != null) {
		locationId =  (Integer)session.getAttribute("locationId");
	}
	
	Box box = HMSUtil.getBox(request);
	datamap = accountHandlerService.submitFinalBudget(box);
	
	seedCategoryList = marketingHandlerService.getSeedCategoryList();		
	financialYearList = marketingHandlerService.getFinancialYearList();
	
	
	boolean bSuccessfullyAdded = false;
	if(datamap.get("bSuccessfullyAdded")!= null)
	{
		bSuccessfullyAdded = (Boolean)datamap.get("bSuccessfullyAdded");
		map.put("bSuccessfullyAdded", datamap.get("bSuccessfullyAdded"));
		map.put("BudgetSystemGeneratedHeaderId", datamap.get("BudgetSystemGeneratedHeaderId"));
		map.put("message", datamap.get("message"));
	}	
	
		
	String jsp = "makeFinalBudget";
	
	jsp += ".jsp";
	
	String title = "Prepare Final Budget- Accounts";
	
	
	
	map.put("financialYearList", financialYearList);	
	map.put("seedCategoryList", seedCategoryList);	
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView awatingforMDApprovalAccountBudget(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object>map = new HashMap<String,Object>();
	String jsp = "awaitingFinalBudgetForMDApproval";
	jsp += ".jsp";
	
	int deptId = 0;
	HttpSession session = request.getSession();
	if (session.getAttribute("departmentId") != null) {
		deptId =  (Integer)session.getAttribute("departmentId");
	}
	String title = "Awaiting for MD Approval- Accounts Budget";	
	
	map.put("contentJsp", jsp);
	map.put("title", title);
	
	return new ModelAndView("index", "map", map);
}


public ModelAndView verifyingFinalAccountsBudget(HttpServletRequest request,HttpServletResponse response)
{
	
	Map<String,Object>map = new HashMap<String,Object>();
	List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();	
	
	
	HttpSession session = request.getSession();
	int locationId = 0;
	if (session.getAttribute("locationId") != null) {
		locationId =  (Integer)session.getAttribute("locationId");
	}
	
	seedCategoryList = marketingHandlerService.getSeedCategoryList();		
	financialYearList = marketingHandlerService.getFinancialYearList();
	
	
		
	String jsp = "verifyingFinalAccountsBudget";
	
	jsp += ".jsp";
	
	String title = "MD Approval- Accounts Budget";
	
	
	
	map.put("financialYearList", financialYearList);
	
	map.put("seedCategoryList", seedCategoryList);
	
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView approveFinalAccountsBudget(HttpServletRequest request, HttpServletResponse response)
{
	Map<String,Object>map = new HashMap<String,Object>();
/*	List<MktBudgetAdditionalDetails> additionalBudgetDetails = new ArrayList<MktBudgetAdditionalDetails>();
	List<MktBudgetHeader> HOBudgetHeader = new ArrayList<MktBudgetHeader>();*/
	List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();	
	List<Object[]> budgetComponent = new ArrayList<Object[]>();	
	boolean bSuccessfullyAdded = false;
	HttpSession session = request.getSession();	
	
	Box box = HMSUtil.getBox(request);	
	int budgetHOId = 0;
	if(box.getInt("Id") != 0)
	{
		budgetHOId = box.getInt("Id");
	}

	String ddlApprovalStatus = box.getString("ddlApprovalStatus");
	String message = "";

	bSuccessfullyAdded = accountHandlerService.approveFinalAccountsBudget(box);
	if(bSuccessfullyAdded)
	{
		if(ddlApprovalStatus.equalsIgnoreCase("1"))
		{
			message = "Accounts Budget Approved Successfully";
		}
		if(ddlApprovalStatus.equalsIgnoreCase("2"))
		{
			message = "Accounts Budget Rejected Successfully";
		}
	}

	
	seedCategoryList = marketingHandlerService.getSeedCategoryList();		
	financialYearList = marketingHandlerService.getFinancialYearList();
	
	
		
	String jsp = "verifyingFinalAccountsBudget";
	
	jsp += ".jsp";
	
	String title = "MD Approval- Accounts Budget";
	
	
	map.put("message", message);
	map.put("bSuccessfullyAdded", bSuccessfullyAdded);
	map.put("financialYearList", financialYearList);	
	map.put("seedCategoryList", seedCategoryList);	
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView searchFinalBudgetList(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object>map = new HashMap<String,Object>();
	
	 List<Object[]> statusList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();
	String jsp = "searchFinalBudgetList";
	jsp += ".jsp";
	
	int deptId = 0;
	HttpSession session = request.getSession();
	if (session.getAttribute("departmentId") != null) {
		deptId =  (Integer)session.getAttribute("departmentId");
	}
	String title = "Accounts Final Budget List";	
	
	statusList = marketingHandlerService.getStatusList();	
	financialYearList = marketingHandlerService.getFinancialYearList();
	
	map.put("financialYearList", financialYearList);	
	map.put("statusList", statusList);	
	map.put("contentJsp", jsp);
	map.put("title", title);
	
	return new ModelAndView("index", "map", map);
}

public ModelAndView viewFinalAccountsBudget(HttpServletRequest request,HttpServletResponse response)
{
	
	Map<String,Object>map = new HashMap<String,Object>();
	List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();	
	
	
	HttpSession session = request.getSession();
	int locationId = 0;
	if (session.getAttribute("locationId") != null) {
		locationId =  (Integer)session.getAttribute("locationId");
	}
	
	seedCategoryList = marketingHandlerService.getSeedCategoryList();		
	financialYearList = marketingHandlerService.getFinancialYearList();
	
	
		
	String jsp = "viewFinalAccountsBudget";
	
	jsp += ".jsp";
	
	String title = "View Final Accounts Budget";
	map.put("financialYearList", financialYearList);
	map.put("seedCategoryList", seedCategoryList);
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView checkForAccountType(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object>map=new HashMap<String,Object>();
	Map<String, Object> parameterMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	int accountId=0;
	if(request.getParameter(ACCOUNT_ID)!=null){
		accountId=Integer.parseInt(request.getParameter(ACCOUNT_ID));
	}
	String accountName = "";
	accountName= accountHandlerService.getAccountCode(accountId);
	parameterMap.put("accountName", accountName);
	
	
	
	MasStoreFinancial msf = new MasStoreFinancial();	
	msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
	parameterMap.put("fYear", msf.getId());
	
	int locationId=0;
	if (session.getAttribute("hospitalId") != null) {
		locationId = (Integer) session.getAttribute("hospitalId");
		parameterMap.put("locationId", locationId);
	}
	if(locationId==1){
		String flag="flagOP";
		parameterMap.put("flag", flag);	
	}
	
	
	map = accountHandlerService.getSubLedgerForAccount(parameterMap);
	
	int accountSubGroupId=0;
	accountSubGroupId=accountHandlerService.getAccountSubGroup(accountId);
	map.put("accountSubGroupId",accountSubGroupId);
	
	return new ModelAndView("responseForAccountSubGroupDetails", "map", map);
}

public ModelAndView showPurchaseFromGrower(HttpServletRequest request,HttpServletResponse response) {
	
	Map<String, Object> map = new HashMap();
	  List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	  List<Object[]> financialYearList = new ArrayList<Object[]>();
	  List<Object[]> cropList = new ArrayList<Object[]>();
	  List<Object[]> varietyList = new ArrayList<Object[]>();
	  List<Object[]> centreList = new ArrayList<Object[]>();	
	  
	  
	  seedCategoryList = marketingHandlerService.getSeedCategoryList();
	  financialYearList = marketingHandlerService.getFinancialYearList();
	  cropList = marketingHandlerService.getCropList();
	  varietyList = marketingHandlerService.getVarietyList();
	  centreList = marketingHandlerService.getCentreList();
	  
	  
	  String jsp = "purchaseFromGrower";
	  jsp += ".jsp";
	 String  title = "Details of purchase from Grower";
	  
	  map.put("financialYearList", financialYearList);
	  map.put("seedCategoryList", seedCategoryList);
	  map.put("cropList", cropList);
	  map.put("varietyList", varietyList);
	  map.put("centreList", centreList);
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  
	  return new ModelAndView("index", "map", map);
	
}
/*public ModelAndView getGrowerPurchasePaymentHistory(HttpServletRequest request,HttpServletResponse response) {
	 Map<String, Object> map = new HashMap();
	  List<ProdGrowerPayment> growerPurchasePaymentHistory = new ArrayList<ProdGrowerPayment>();
	  List<FaMasSubLed> masSubLedger = new ArrayList<FaMasSubLed>();
	  
	  Box box = HMSUtil.getBox(request);
	  
	  String purchaseType="Grower";
	  box.put("purchaseType", purchaseType);
	  map = accountHandlerService.getGrowerPurchasePaymentHistory(box);
	  if (map.get("growerPurchasePaymentHistory") != null) {
		  growerPurchasePaymentHistory = (List)map.get("growerPurchasePaymentHistory");
	  }
	  if (map.get("masSubLedger") != null) {
		  masSubLedger = (List)map.get("masSubLedger");
	  }
	  System.out.println("masSubLedger="+masSubLedger.size());
	  int totalRecords = 0;
	  if (map.get("totalRecords") != null) {
		    totalRecords = ((Integer)map.get("totalRecords")).intValue();
		  }
	  try
	  {
	    PrintWriter pw = response.getWriter();
	    
	    pw.write("[");
	    int counter = 1;
	    int SubLedgerId =0;
	    for (ProdGrowerPayment list : growerPurchasePaymentHistory)
	    {
	    	for(FaMasSubLed listA : masSubLedger)
	    	{
	    		if(list.getSeedQuality().getGrower().getGrower().getId() == listA.getGrower().getId())
	    		{
	    			SubLedgerId = listA.getId();
	    		}
	    	}
	    	System.out.println("SubLedgerId="+SubLedgerId);
	      if (counter != growerPurchasePaymentHistory.size()) {
	        pw.write("{\"Id\": \"" + list.getId() + "\",\"SubLedId\": \"" + SubLedgerId + "\",\"Year\": \"" + (list.getSeedQuality().getProdYear() != null ? list.getSeedQuality().getProdYear().getFinancialYear() : "") + "\",\"GrowerName\": \"" + (list.getSeedQuality().getGrower() != null ? list.getSeedQuality().getGrower().getGrower().getGrowerName() : "") + "\",\"Class\": \"" + (list.getSeedQuality().getSeedClass() != null ? list.getSeedQuality().getSeedClass().getItemClassName() : "") + "\",\"Crop\": \"" + (list.getSeedQuality().getCrop() != null ? list.getSeedQuality().getCrop().getNomenclature() : "") + "\",\"Variety\": \"" + (list.getSeedQuality().getSeedVariety() != null ? list.getSeedQuality().getSeedVariety().getItemVarietyName() : "") + "\",\"PreparedBy\":\"" + (list.getLastChgBy() != null ? list.getLastChgBy().getFirstName() + " " + list.getLastChgBy().getLastName() : "") + "\",\"Amount\":\"" + list.getAmount().doubleValue() + "\",\"PaymentType\":\"" + (list.getVoucherNo() !=null?list.getVoucherNo().getPaymentType():"") + "\",\"RefNo\":\"" + (list.getVoucherNo() !=null?list.getVoucherNo().getChequeNo():"") + "\",\"VoucherNo\":\"" + (list.getVoucherNo() !=null?list.getVoucherNo().getVoucherNo():"") + "\",\"totalRecords\":\"" + totalRecords + "\"},");
	      } else {
	    	  pw.write("{\"Id\": \"" + list.getId() + "\",\"SubLedId\": \"" + SubLedgerId + "\",\"Year\": \"" + (list.getSeedQuality().getProdYear() != null ? list.getSeedQuality().getProdYear().getFinancialYear() : "") + "\",\"GrowerName\": \"" + (list.getSeedQuality().getGrower() != null ? list.getSeedQuality().getGrower().getGrower().getGrowerName() : "") + "\",\"Class\": \"" + (list.getSeedQuality().getSeedClass() != null ? list.getSeedQuality().getSeedClass().getItemClassName() : "") + "\",\"Crop\": \"" + (list.getSeedQuality().getCrop() != null ? list.getSeedQuality().getCrop().getNomenclature() : "") + "\",\"Variety\": \"" + (list.getSeedQuality().getSeedVariety() != null ? list.getSeedQuality().getSeedVariety().getItemVarietyName() : "") + "\",\"PreparedBy\":\"" + (list.getLastChgBy() != null ? list.getLastChgBy().getFirstName() + " " + list.getLastChgBy().getLastName() : "") + "\",\"Amount\":\"" + list.getAmount().doubleValue() + "\",\"PaymentType\":\"" + (list.getVoucherNo() !=null?list.getVoucherNo().getPaymentType():"") + "\",\"RefNo\":\"" + (list.getVoucherNo() !=null?list.getVoucherNo().getChequeNo():"") + "\",\"VoucherNo\":\"" + (list.getVoucherNo() !=null?list.getVoucherNo().getVoucherNo():"") + "\",\"totalRecords\":\"" + totalRecords + "\"}");
	      }
	      counter++;
	    }
	    pw.write("]");
	  }
	  catch (Exception e)
	  {
		  growerPurchasePaymentHistory.clear();
	    e.printStackTrace();
	  }
	  growerPurchasePaymentHistory.clear();
	  
	  return null;
}*/


public ModelAndView showPurchaseFromVendor(HttpServletRequest request,HttpServletResponse response) {
	
	Map<String, Object> map = new HashMap();
	  List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	  List<Object[]> financialYearList = new ArrayList<Object[]>();
	  List<Object[]> cropList = new ArrayList<Object[]>();
	  List<Object[]> varietyList = new ArrayList<Object[]>();
	  List<Object[]> centreList = new ArrayList<Object[]>();	
	  
	  
	  seedCategoryList = marketingHandlerService.getSeedCategoryList();
	  financialYearList = marketingHandlerService.getFinancialYearList();
	  cropList = marketingHandlerService.getCropList();
	  varietyList = marketingHandlerService.getVarietyList();
	  centreList = marketingHandlerService.getCentreList();
	  
	  
	  String jsp = "purchaseFromVendor";
	  jsp += ".jsp";
	 String  title = "Details of purchase from Vendor";
	  
	  map.put("financialYearList", financialYearList);
	  map.put("seedCategoryList", seedCategoryList);
	  map.put("cropList", cropList);
	  map.put("varietyList", varietyList);
	  map.put("centreList", centreList);
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  
	  return new ModelAndView("index", "map", map);
	
}


public ModelAndView getVendorPurchasePaymentHistory(HttpServletRequest request,HttpServletResponse response) {
	 Map<String, Object> map = new HashMap();
	  List<FaVoucherHeader> vendorPurchasePaymentHistory = new ArrayList<FaVoucherHeader>();
	  
	  Box box = HMSUtil.getBox(request);
	  
	  String purchaseType="Vendor";
	  box.put("purchaseType", purchaseType);
	  map = accountHandlerService.getGrowerPurchasePaymentHistory(box);
	  if (map.get("vendorPurchasePaymentHistory") != null) {
		  vendorPurchasePaymentHistory = (List)map.get("vendorPurchasePaymentHistory");
	  }
	  int totalRecords = 0;
	  if (map.get("totalRecords") != null) {
		    totalRecords = ((Integer)map.get("totalRecords")).intValue();
		  }
	  try
	  {
	    PrintWriter pw = response.getWriter();
	    
	    pw.write("[");
	    int counter = 1;
	    for (FaVoucherHeader list : vendorPurchasePaymentHistory)
	    {
	      if (counter != vendorPurchasePaymentHistory.size()) {
	        pw.write("{\"Id\": \"" + list.getId() + "\",\"Year\": \"" + (list.getFYear() != null ? list.getFYear().getFinancialYear() : "") + "\",\"Name\": \"" + (list.getSupplier() != null ? list.getSupplier().getSupplierName() : "") + "\",\"PONO\": \"" + (list.getPoNo() != null ? list.getPoNo() : "") + "\",\"POAmt\": \"" + (list.getPoAmount() != null ? list.getPoAmount() : "") + "\",\"PODate\": \"" + (list.getPoDate()!= null ? HMSUtil.convertDateToStringWithoutTime(list.getPoDate()) : "") + "\",\"InvoiceNO\": \"" + (list.getInvoiceNo() != null ? list.getInvoiceNo() : "") + "\",\"InvoiceAmt\": \"" + (list.getInvoiceAmount() != null ? list.getPoAmount() : "") + "\",\"InvoiceDate\": \"" + (list.getInvoiceDate()!= null ? HMSUtil.convertDateToStringWithoutTime(list.getInvoiceDate()) : "") + "\",\"PreparedBy\":\"" + (list.getLastChgBy() != null ? list.getLastChgBy().getFirstName() + " " + list.getLastChgBy().getLastName() : "") + "\",\"VoucherNo\":\"" + (list.getVoucherNo() !=null?list.getVoucherNo():"") + "\",\"totalRecords\":\"" + totalRecords + "\"},");
	      } else {
	    	  pw.write("{\"Id\": \"" + list.getId() + "\",\"Year\": \"" + (list.getFYear() != null ? list.getFYear().getFinancialYear() : "") + "\",\"Name\": \"" + (list.getSupplier() != null ? list.getSupplier().getSupplierName() : "") + "\",\"PONO\": \"" + (list.getPoNo() != null ? list.getPoNo() : "") + "\",\"POAmt\": \"" + (list.getPoAmount() != null ? list.getPoAmount() : "") + "\",\"PODate\": \"" + (list.getPoDate()!= null ? HMSUtil.convertDateToStringWithoutTime(list.getPoDate()) : "") + "\",\"InvoiceNO\": \"" + (list.getInvoiceNo() != null ? list.getInvoiceNo() : "") + "\",\"InvoiceAmt\": \"" + (list.getInvoiceAmount() != null ? list.getPoAmount() : "") + "\",\"InvoiceDate\": \"" + (list.getInvoiceDate()!= null ? HMSUtil.convertDateToStringWithoutTime(list.getInvoiceDate()) : "") + "\",\"PreparedBy\":\"" + (list.getLastChgBy() != null ? list.getLastChgBy().getFirstName() + " " + list.getLastChgBy().getLastName() : "") + "\",\"VoucherNo\":\"" + (list.getVoucherNo() !=null?list.getVoucherNo():"") + "\",\"totalRecords\":\"" + totalRecords + "\"}");
	      }
	      counter++;
	    }
	    pw.write("]");
	  }
	  catch (Exception e)
	  {
		  vendorPurchasePaymentHistory.clear();
	    e.printStackTrace();
	  }
	  vendorPurchasePaymentHistory.clear();
	  
	  return null;
}

public ModelAndView popUpOfViewBillingTransactionHistory(HttpServletRequest request, HttpServletResponse response)
{
	Map<String,Object> map = new HashMap<String,Object>();
	
	
	return new ModelAndView("popUpOfViewBillingTransactionHistory", "map", map);
}

/*public ModelAndView getBilingTransactionHistory(HttpServletRequest request,HttpServletResponse response)
{	
	Map<String,Object> map = new HashMap<String,Object>();
	List<BlDispensingHeader> billDetails = new ArrayList<BlDispensingHeader>();
	
	Box box = HMSUtil.getBox(request);
	String TransactionType="";
	TransactionType = "Billing";
	box.put("TransactionType", TransactionType);
	
	map = accountHandlerService.getBilingTransactionHistory(box);
	
	if(map.get("billDetails")!= null)
	{
		billDetails =(List<BlDispensingHeader>) map.get("billDetails");
	}
	
	int totalRecords = 0;
	if(map.get("totalRecords")!= null)
	{
		totalRecords = (Integer) map.get("totalRecords");
	}
	
	
		try
		{
			PrintWriter pw = response.getWriter();			
			pw.write("[");
			int counter=1;
			
			for(BlDispensingHeader list : billDetails)
			{	
				double ImprestAccount = 0.0;
				if(list.getPlanGrowerDetails() !=null)
				{
					for(BlServiceCharges bl : list.getBlServiceCharges())
					{
						ImprestAccount = bl.getGrandTotal().doubleValue();	
					}
				}
				
			System.out.println("ImprestAccount="+ImprestAccount);
				 
				   
			    if(counter != billDetails.size())
			    {
			   
			    	pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+HMSUtil.convertDateToStringWithoutTime(list.getBillInvoiceDate())+"\",\"BillingType\": \""+(list.getBillingType()!=null?list.getBillingType():"")+"\",\"Name\": \""+(list.getCustomerName()!=null?list.getCustomerName():"")+"\",\"TotalAmount\": \""+(list.getBillAmt()!=null?list.getBillAmt().doubleValue():"0")+"\",\"CashAmount\": \""+(list.getNetAmt()!=null?list.getNetAmt().doubleValue():"0")+"\",\"SubsidyAmount\": \""+(list.getTotalSubsidyAmt()!=null?list.getTotalSubsidyAmt().doubleValue():"0")+"\",\"ImprestAmount\": \""+(ImprestAccount)+"\",\"ProductionBillingFlag\": \""+(list.getPlanGrowerDetails()!=null?"Y":"N")+"\",\"LastChgBy\":\""+(list.getLastChgBy()!=null?list.getLastChgBy().getFirstName():"")+"\",\"totalRecords\":\""+totalRecords+"\"},");
			    }
			    else
			    {
			    	pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+HMSUtil.convertDateToStringWithoutTime(list.getBillInvoiceDate())+"\",\"BillingType\": \""+(list.getBillingType()!=null?list.getBillingType():"")+"\",\"Name\": \""+(list.getCustomerName()!=null?list.getCustomerName():"")+"\",\"TotalAmount\": \""+(list.getBillAmt()!=null?list.getBillAmt().doubleValue():"0")+"\",\"CashAmount\": \""+(list.getNetAmt()!=null?list.getNetAmt().doubleValue():"0")+"\",\"SubsidyAmount\": \""+(list.getTotalSubsidyAmt()!=null?list.getTotalSubsidyAmt().doubleValue():"0")+"\",\"ImprestAmount\": \""+(ImprestAccount)+"\",\"ProductionBillingFlag\": \""+(list.getPlanGrowerDetails()!=null?"Y":"N")+"\",\"LastChgBy\":\""+(list.getLastChgBy()!=null?list.getLastChgBy().getFirstName():"")+"\",\"totalRecords\":\""+totalRecords+"\"}");
			    }
			
			    counter++;		
			}		
			
			pw.write("]");		
			
		}
		
		catch(Exception e)
		{
			billDetails.clear();
			e.printStackTrace();
		}	
	
	
	
	
	billDetails.clear();
	return null;

}
*/

public ModelAndView listofSalesTransaction(HttpServletRequest request,HttpServletResponse response) {
	
	Map<String, Object> map = new HashMap();
	  List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	  List<Object[]> financialYearList = new ArrayList<Object[]>();
	  List<Object[]> cropList = new ArrayList<Object[]>();
	  List<Object[]> varietyList = new ArrayList<Object[]>();
	  List<Object[]> centreList = new ArrayList<Object[]>();	
	  
	  
	  seedCategoryList = marketingHandlerService.getSeedCategoryList();
	  financialYearList = marketingHandlerService.getFinancialYearList();
	 // cropList = marketingHandlerService.getCropList();
	 // varietyList = marketingHandlerService.getVarietyList();
	  centreList = marketingHandlerService.getCentreList();
	  
	  
	  String jsp = "salesTransaction";
	  jsp += ".jsp";
	 String  title = "Details of Sales Transaction";
	  
	  map.put("financialYearList", financialYearList);
	  map.put("seedCategoryList", seedCategoryList);
	  map.put("cropList", cropList);
	  map.put("varietyList", varietyList);
	  map.put("centreList", centreList);
	  map.put("contentJsp", jsp);
	  map.put("title", title);
	  
	  return new ModelAndView("index", "map", map);
	
}

public ModelAndView getSalesTransactionHistory(HttpServletRequest request,HttpServletResponse response) {
	 Map<String, Object> map = new HashMap();
	  List<Object[]> salesTransaction = new ArrayList<Object[]>();
	  
	  Box box = HMSUtil.getBox(request);
	  
	 
	  map = accountHandlerService.getSalesTransactionHistory(box);
	  if (map.get("salesTransaction") != null) {
		  salesTransaction = (List<Object[]>)map.get("salesTransaction");
	  }
	  int totalRecords = 0;
	  if (map.get("totalRecords") != null) {
		    totalRecords = ((Integer)map.get("totalRecords")).intValue();
		  }
	  try
	  {
	    PrintWriter pw = response.getWriter();
	    
	    pw.write("[");
	    int counter = 1;
	    for (Object[] list : salesTransaction)
	    {
	      if (counter != salesTransaction.size()) {
	        pw.write("{\"SalesType\": \"" + list[0] + "\",\"Centre\": \"" + list[1] + "\",\"Crop\": \"" + list[2]+ "\",\"Variety\": \"" + list[3]+ "\",\"Qty\": \"" + list[4]+ "\",\"Rate\": \"" + list[5]+ "\",\"Amount\":\"" + list[6] + "\",\"SeedClass\":\"" + list[7] + "\",\"totalRecords\":\"" + totalRecords + "\"},");
	      } else {
	    	  pw.write("{\"SalesType\": \"" + list[0] + "\",\"Centre\": \"" + list[1] + "\",\"Crop\": \"" + list[2]+ "\",\"Variety\": \"" + list[3]+ "\",\"Qty\": \"" + list[4]+ "\",\"Rate\": \"" + list[5]+ "\",\"Amount\":\"" + list[6] + "\",\"SeedClass\":\"" + list[7] + "\",\"totalRecords\":\"" + totalRecords + "\"}");
	      }
	      counter++;
	    }
	    pw.write("]");
	  }
	  catch (Exception e)
	  {
		  salesTransaction.clear();
	    e.printStackTrace();
	  }
	  salesTransaction.clear();
	  
	  return null;
}
public ModelAndView deleteAccount(HttpServletRequest request, HttpServletResponse response) {
	  Map<String, Object> map = new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();
	  int accountId=0;
	  String changedBy="";
	  String title="";
	  Date changedDate = null;
	  String changedTime = "";
	  int userId=0;
	  String message="";
	  String jsp="";
	  String url="";
	  
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		  accountId =Integer.parseInt( request.getParameter(COMMON_ID));
	  }
	  if(request.getParameter("title") != null){
	   title = request.getParameter("title"); 
	  }
	  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
	  dataDeleted=accountHandlerService.deleteAccount(accountId,generalMap);
	  if (dataDeleted==true)
	  {
	   message="Record is InActivated successfully !!";
	  }

	  else{
	   message="Record is Activated successfully !!";
	  }
	  url = "/hms/hms/account?method=showAccountMasterJsp";
	  
	  try{
		  int fYear = 0;
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
				generalMap.put("fYear", fYear);
			}
			if (session.getAttribute("locationId") != null) {
				int locationId = (Integer) session.getAttribute("locationId");
				generalMap.put("locationId", locationId);
			}
			
			map = accountHandlerService.showAccountMasterNew(generalMap);
	   
	  }catch (Exception e) {
		  e.printStackTrace();}
	  	 jsp="accountMaster";
		title="Edit Account";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	 }
public ModelAndView searchScheduleMaster(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	int fYear = 0;
	if (session.getAttribute("financialYear") != null) {
		fYear = (Integer) session.getAttribute("financialYear");
		box.put("fYear", fYear);
	}
	if (session.getAttribute("locationId") != null) {
		int locationId = (Integer) session.getAttribute("locationId");
		box.put("locationId", locationId);
	}
	map = accountHandlerService.searchScheduleMaster(box);
	String searchField="";
	if(map.get("searchField")!=null){
		searchField=(String)map.get("searchField");
	}
	map.put("searchField", request.getParameter("searchField"));
	map.put("search","search");
	String jsp = "scheduleMaster";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}

	public ModelAndView showScheduleMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			generalMap.put("fYear", fYear);
		}
		
		/*int accountSubGroupId = 0;
		if (request.getParameter("accountSubGroupId") != null) {
			accountSubGroupId = Integer.parseInt(request.getParameter("accountSubGroupId"));
			generalMap.put("accountSubGroupId", accountSubGroupId);
		}*/
		
		map = accountHandlerService.showScheduleMasterJsp(generalMap);
		String jsp = "scheduleMaster";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("searchField", request.getParameter("searchField"));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addScheduleMaster(HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object>map=new HashMap<String,Object>();
		Map<String,Object>generalMap=new HashMap<String,Object>();
		
		int scheduleCode=0;
		if(request.getParameter(SEARCH_NAME)!=null && !request.getParameter(SEARCH_NAME).equals("")){
			scheduleCode= Integer.parseInt(request.getParameter(SEARCH_NAME));
			generalMap.put("scheduleCode", scheduleCode);
			
		}

		String scheduleDescription="";
		if(request.getParameter("description")!=null && !request.getParameter("description").equals("")){
			scheduleDescription=request.getParameter("description");
			generalMap.put("scheduleDescription", scheduleDescription);
			
		}
		
		int accountgroupId = 0;
		if (request.getParameter(DISTRICT_ID) != null && !(request.getParameter(DISTRICT_ID).equals("0"))) {
			accountgroupId = Integer.parseInt(request.getParameter(DISTRICT_ID));
			generalMap.put("accountgroupId", accountgroupId);
			
		}
		
		map = accountHandlerService.addScheduleMaster(generalMap);
		String jsp="scheduleMaster";
		jsp+= ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView updateScheduleMaster(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object>generalMap=new HashMap<String,Object>();
		HttpSession session = request.getSession();
		
		int scheduleCode=0;
		if(request.getParameter(SEARCH_NAME)!=null && !request.getParameter(SEARCH_NAME).equals("")){
			scheduleCode= Integer.parseInt(request.getParameter(SEARCH_NAME));
			generalMap.put("scheduleCode", scheduleCode);
			
		}
		
		String scheduleDescription="";
		if(request.getParameter("description")!=null && !request.getParameter("description").equals("")){
			scheduleDescription=request.getParameter("description");
			generalMap.put("scheduleDescription", scheduleDescription);
			
		}
		
		int accountgroupId = 0;
		if (request.getParameter(DISTRICT_ID) != null && !(request.getParameter(DISTRICT_ID).equals("0"))) {
			accountgroupId = Integer.parseInt(request.getParameter(DISTRICT_ID));
			generalMap.put("accountgroupId", accountgroupId);
			
		}
		
		map = accountHandlerService.updateScheduleMaster(generalMap);
		String jsp = "scheduleMaster";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	 public ModelAndView getScheduleList(HttpServletRequest request, HttpServletResponse response) {
		 	Map<String, Object> map = new HashMap<String, Object>();
		 	String jsp ="";
			int accountGroup = 0;
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("accountGroup") != null) {
					accountGroup = Integer.parseInt(request.getParameter("accountGroup"));
				}
				dataMap.put("accountGroup", accountGroup);
				map = accountHandlerService.getScheduleList(dataMap);
				jsp = "responseSchedule";
				map.put("accountMaster", request.getParameter("accountMaster"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
		}
	 
	public ModelAndView deleteScheduleMaster(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		
		int scheduleCode=0;
		if(request.getParameter(SEARCH_NAME)!=null && !request.getParameter(SEARCH_NAME).equals("")){
			scheduleCode= Integer.parseInt(request.getParameter(SEARCH_NAME));
			generalMap.put("scheduleCode", scheduleCode);
			
		}
		map = accountHandlerService.deleteScheduleMaster(generalMap);
		String jsp = "scheduleMaster";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	 public ModelAndView getSubGroupList(HttpServletRequest request, HttpServletResponse response) {
		 	Map<String, Object> map = new HashMap<String, Object>();
		 	String jsp ="";
			int accountGroup = 0;
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("accountGroup") != null) {
					accountGroup = Integer.parseInt(request.getParameter("accountGroup"));
				}
				dataMap.put("accountGroup", accountGroup);
				map = accountHandlerService.getSubGroupList(dataMap);
				jsp = "responseSubGroup";
				map.put("accountMaster", request.getParameter("accountMaster"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
		}
	 
	 public ModelAndView displayScheduleDetailForProfitAndLoss(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			int financialYearId = 0;
			int yearDesc=0;
			int scheduleCode=0;
			String pageType="NA";
			int locationId=0;
			
			if(request.getParameter("currentYearDesc")!=null){
				yearDesc = Integer.parseInt(request.getParameter("currentYearDesc"));
				box.put("yearDesc", yearDesc);
			}
			
			if(request.getParameter("schedule")!=null){
				scheduleCode = Integer.parseInt(request.getParameter("schedule"));
				box.put("scheduleCode", scheduleCode);
			}
			
			
			MasStoreFinancial msf = new MasStoreFinancial();	
			msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
			box.put("fYear", msf.getId());
			
		/*	if (request.getParameter("financialYear") != null) {
				financialYearId = Integer.parseInt(request.getParameter("financialYear"));
				box.put("fYear", financialYearId);
			}*/
			
			
			if(request.getParameter("pageType") != null)
			{
				pageType = request.getParameter("pageType");
			}
			if (session.getAttribute("hospitalId") != null) {
				locationId = (Integer) session.getAttribute("hospitalId");
				map.put("locationId", locationId);
				box.put("locationId", locationId);
			}
			System.out.println("locationId :123: " + locationId);
			map = accountHandlerService.displayScheduleDetailForProfitAndLoss(box);

			String jsp = "schedulePnL.jsp";
			map.put("contentJsp", jsp);
			map.put("particular", box.getString("particular"));
			map.put("schedule", box.getInt("schedule"));
			map.put("pageType", pageType);
			//map.put("BalanceSheetType", "FILTER");
			return new ModelAndView("index", "map", map);
		}

	 @SuppressWarnings("unchecked")
		public ModelAndView showBankJsp(HttpServletRequest request,
				HttpServletResponse response) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 HttpSession session = request.getSession();
		 map = accountHandlerService.showBankJsp();
			
			ArrayList searchBankList = (ArrayList) map.get("searchBankList");
			String jsp = "bank";
			jsp += ".jsp";
			String title = "Bank";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
	 
	 
	 public ModelAndView searchBank(HttpServletRequest request,
				HttpServletResponse response)  {
			Map<String, Object> map = new HashMap<String, Object>();
			String bankCode = null;
			String bankName = null;
			String searchField = null;

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				bankCode = request.getParameter(CODE);
			}

			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				bankName = request.getParameter(SEARCH_NAME);
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
				bankCode = searchField;
				bankName = null;
			} else {
				bankCode = null;
				bankName = searchField;
			}
			map = accountHandlerService.searchBank(bankCode, bankName);
			String jsp = "bank";
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("bankCode", bankCode);
			map.put("bankName", bankName);
			return new ModelAndView("index", "map", map);
		}

	 @SuppressWarnings("unchecked")
		public ModelAndView addBank(HttpServletRequest request,
				HttpServletResponse response) {
		 	HttpSession session = request.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			MasBankMaster masBank = new MasBankMaster();
			
			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();

			String code="";
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			String name="";
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			
			String bankAddress="";
			if (request.getParameter("bankAddress") != null) {
				bankAddress = request.getParameter("bankAddress");
			}
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				currentDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
			}
			String currentTime="";
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
			}
			String title="";
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}
			String pojoName="";
			if (request.getParameter("pojoName") != null) {
				pojoName = request.getParameter("pojoName");
			}
			String pojoPropertyName="";
			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}

			String pojoPropertyCode="";
			if (request.getParameter("pojoPropertyCode") != null) {
				pojoPropertyCode = request.getParameter("pojoPropertyCode");
			}
			
			int userId=0;
			if (session.getAttribute("userId") != null){
				userId = (Integer) session.getAttribute("userId");
			}
			
			generalMap.put("code", code);
			generalMap.put("name", name);

			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);

			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);

			listMap = mastersHandlerService.checkForExistingMasters(generalMap);

			List bankCodeList = new ArrayList();
			List bankNameList = new ArrayList();

			if (listMap.get("duplicateGeneralCodeList") != null) {
				bankCodeList = (List) listMap.get("duplicateGeneralCodeList");
			}
			if (listMap.get("duplicateGeneralNameList") != null) {
				bankNameList = (List) listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			String message ="";
			if ((bankCodeList.size() == 0 || bankCodeList == null)
					&& (bankNameList.size() == 0 || bankNameList == null)) {
				masBank.setBankCode(code);
				masBank.setBankName(name);
				masBank.setStatus("y");
				masBank.setBankAddress(bankAddress);
				Users users=new Users();
				users.setId(userId);
				/*masBank.setLastChgBy(users);*/
				masBank.setLastChgDate(currentDate);
				masBank.setLastChgTime(currentTime);
				successfullyAdded = accountHandlerService.addBank(masBank);

				if (successfullyAdded) {
					message  = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			} else if ((bankCodeList.size() != 0 || bankCodeList != null)
					|| (bankNameList.size() != 0) || bankNameList != null) {

				if ((bankCodeList.size() != 0 || bankCodeList != null)
						&& (bankNameList.size() == 0 || bankNameList == null)) {

					message = "Bank Code  already exists.";
				} else if ((bankNameList.size() != 0 || bankNameList != null)
						&& (bankCodeList.size() == 0 || bankCodeList == null)) {

					message = "Bank Name already exists.";
				} else if ((bankCodeList.size() != 0 || bankCodeList != null)
						&& (bankNameList.size() != 0 || bankNameList != null)) {

					message = "Bank Code and Bank Name already exist.";
				}
			}

			try {
				map = accountHandlerService.showBankJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			String jsp = "bank";
			title = "Add Bank";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		} 
	 
	 @SuppressWarnings("unchecked")
		public ModelAndView editBank(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> listMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			String bankCode = "";
			String bankName = "";
			String bankAddress = "";
			int bankId = 0;
			String changedTime = "";
			Date changedDate = null;

			bankCode = (String) session.getAttribute("bankCode");
			bankName = (String) session.getAttribute("bankName");
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				bankId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				bankCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				bankName = request.getParameter(SEARCH_NAME);
			}

			if (request.getParameter("bankAddress") != null
					&& !(request.getParameter("bankAddress").equals(""))) {
				bankAddress = request.getParameter("bankAddress");
			}
			int userId=0;
			if (session.getAttribute("userId") != null){
				userId = (Integer) session.getAttribute("userId");
			}
			String title ="";
			if (request.getParameter("title") != null) {
				title  = request.getParameter("title");
			}
			
			String pojoPropertyName="";
			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}
			String pojoName="";
			if (request.getParameter("pojoName") != null) {
				pojoName = request.getParameter("pojoName");
			}
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			
			
			generalMap.put("id", bankId);
			generalMap.put("bankCode", bankCode);
			generalMap.put("name", bankName);
			generalMap.put("bankAddress", bankAddress);
			generalMap.put("changedBy", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);

			generalMap.put("flag", true);

			listMap = mastersHandlerService
					.checkForExistingMasters(generalMap);
			List existingBankNameList = (List) listMap.get("duplicateMastersList");

			boolean dataUpdated = false;
			String message ="";
			if (existingBankNameList.size() == 0) {
				dataUpdated = accountHandlerService.editBankToDatabase(generalMap);
				
				
				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant be updated !!";
				}
			} else if (existingBankNameList.size() > 0) {

				message = "Name already exists.";

			}

			try {
				map = accountHandlerService.showBankJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String jsp = "bank";
			title = "Edit Bank";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}

		public ModelAndView deleteBank(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int bankId = 0;
			String message = null;
			String changedTime = null;
			Date changedDate = null;
			String flag = "";
			String title = "";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				bankId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}
			
			
			int userId=0;
			if (session.getAttribute("userId") != null){
				userId = (Integer) session.getAttribute("userId");
			}
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("changedBy", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted = false;
			dataDeleted = accountHandlerService.deleteBank(bankId, generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			} else {
				message = "Record is Activated successfully !!";
			}

			try {
				map = accountHandlerService.showBankJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			String jsp = "bank";
			title = "Delete Bank";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}
	 
public ModelAndView deleteAccountSubLedger(HttpServletRequest request, HttpServletResponse response) {
	  Map<String, Object> map = new HashMap<String, Object>();
	  Map<String, Object> generalMap = new HashMap<String, Object>();
	  int subLedgerId=0;
	  String changedBy="";
	  String title="";
	  Date changedDate = null;
	  String changedTime = "";
	  int userId=0;
	  String message="";
	  String jsp="";
	  String url="";
	  
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		  subLedgerId =Integer.parseInt( request.getParameter(COMMON_ID));
	  }
	  if(request.getParameter("title") != null){
	   title = request.getParameter("title"); 
	  }
	  if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
	  dataDeleted=accountHandlerService.deleteAccountSubLedger(subLedgerId,generalMap);
	  if (dataDeleted==true)
	  {
	   message="Record is InActivated successfully !!";
	  }

	  else{
	   message="Record is Activated successfully !!";
	  }
	  url = "/hms/hms/account?method=showAccountSubLedgerJsp";
	  
	  try{
		  int fYear = 0;
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
				generalMap.put("fYear", fYear);
			}
			if (session.getAttribute("locationId") != null) {
				int locationId = (Integer) session.getAttribute("locationId");
				generalMap.put("locationId", locationId);
			}
			
			  if(request.getParameter("masterFlag") != null)
			  {
				  
				  generalMap.put("flag", request.getParameter("masterFlag").toString());
				  
			  }
			  
			  
		       if(request.getParameter("masterFlag") != null && request.getParameter("masterFlag").toString().trim().equals("grower")){
					
					jsp="fa_GrowerSubLedgerNew";
					
				}
				else if(request.getParameter("masterFlag") != null && request.getParameter("masterFlag").toString().trim().equals("rsk")){
					jsp="fa_RSKSubLedgerNew";
					
				}
				else
				{
					jsp="fa_accountSubLedgerNew";
				}
		       
			map = accountHandlerService.showAccountSubLedgerJsp(generalMap);
	   
	  }catch (Exception e) {
		  e.printStackTrace();}
	  	 jsp="fa_accountSubLedgerNew";
		title="Delete Sub Ledger";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	 }


public ModelAndView showRskPaymentMappingJsp(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	if (session.getAttribute("financialYear") != null) {
		int fyear = (Integer) session.getAttribute("financialYear");
		box.put("fYear", fyear);
	}

	String jsp = "rsk_payment_voucher.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}

public ModelAndView displayRskPaymentVoucher(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	if (session.getAttribute("financialYear") != null) {
		int fyear = (Integer) session.getAttribute("financialYear");
		box.put("fYear", fyear);
	}
	
	if (session.getAttribute("locationId") != null) {
		int locationId = (Integer) session.getAttribute("locationId");
		box.put("locationId", locationId);
	}
	map = accountHandlerService.displayRskPaymentVoucherDetails(box);
	String jsp = "rsk_payment_voucher.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}









// Start voucher posting and approval Rahul Srivastava

// --------------------------------------------Journal Voucher-----------------------------------------//
public ModelAndView showJournalVoucher(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	String fYearDesc = "";
	if (session.getAttribute("fYearDesc") != null) {
		fYearDesc = (String) session.getAttribute("fYearDesc");
		box.put("fYearDesc", fYearDesc);
	}
	if (session.getAttribute("locationId") != null) {
		int locationId = (Integer) session.getAttribute("locationId");
		box.put("locationId", locationId);
	}
	map = accountHandlerService.showJournalVoucherJsp(box);
	String jsp = FA_JOURNAL_VOUCHER_JSP + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}

public ModelAndView submitJournalVoucher(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	if (session.getAttribute("hospitalId") != null) {
		int locationId = (Integer) session.getAttribute("hospitalId");
		box.put("locationId", locationId);
	}
	if (session.getAttribute("users") != null) {
		Users users = (Users) session.getAttribute("users");
		int changedBy = users.getId();
		box.put("changedBy", changedBy);
	}
/*	int fyear = 0;
	if (session.getAttribute("financialYear") != null) {
		fyear = (Integer) session.getAttribute("financialYear");
		box.put("fYear", fyear);
	}*/
	
	MasStoreFinancial msf = new MasStoreFinancial();	
	msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
	box.put("fYear", msf.getId());
	
	String fYearDesc = "";
	if (session.getAttribute("fYearDesc") != null) {
		fYearDesc = (String) session.getAttribute("fYearDesc");
		box.put("fYearDesc", fYearDesc);
	}
	map = accountHandlerService.submitJournalVoucher(box);
	String voucherNo="";
	if(map.get("voucherNo1")!=null){
		voucherNo=(String)map.get("voucherNo1");
	}
	String voucherType="";
	if(map.get("voucherType")!=null){
		voucherType=(String)map.get("voucherType");
	}

	boolean saved = false;
	String message = "";
	if (map.get("saved") != null) {
		saved = (Boolean) map.get("saved");
	}
	String voucherType1 = "JV";
	if (saved) {
		message = "Journal Voucher Saved Successfully and Pending for Approval with Voucher No="+voucherNo+".";
	} else {
		message = "Try Again!";
	}
	map.put("message", message);
	map.put("voucherType1", voucherType1);
	if (map.get("voucherNo") != null) {
		map.put("voucherNo", map.get("voucherNo"));
	}
	map.put("fyear", msf.getId());
	map.put("voucherDate", box.getString(VOUCHER_DATE));
	String url = "/hms/hms/account?method=showJournalVoucher";
	map.put("url", url);
	String jsp = "fa_msgForVoucher" + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}



public ModelAndView submitJournalVoucherApproval(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	
	
	map = accountHandlerService.submitJournalVoucherApproval(box);
	String voucherNo="";
	if(map.get("voucherNo")!=null){
		voucherNo=(String)map.get("voucherNo");
	}
	
	String approvalStatus="";
	if(map.get("approvalStatus")!=null){
		approvalStatus=(String)map.get("approvalStatus");
	}

	boolean saved = false;
	String message = "";
	if (map.get("saved") != null) {
		saved = (Boolean) map.get("saved");
	}
	
	if (saved) {
		message = "Journal Voucher with voucher No="+voucherNo+ " is "+approvalStatus;
	} else {
		message = "Try Again!";
	}
	map.put("message", message);
	String jsp = "msgForVoucherApproval" + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}

// --------------------------------------------Payment Voucher-----------------------------------------//
	public ModelAndView showPaymentVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> centreList = new ArrayList<Object[]>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		/*centreList = marketingHandlerService.getCentreAndHOList();*/
		map = accountHandlerService.showPaymentVoucherJsp(box);
		String jsp = "fa_payment_voucher" + ".jsp";
		map.put("centreList", centreList);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitPaymentVoucher(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		int accountId = 0;
		if (request.getParameter("accountId") != null) {
			accountId = Integer.parseInt(request.getParameter("accountId"));
		}
		
		int subLedId = 0;
		if (request.getParameter("subLedId") != null) {
			subLedId = Integer.parseInt(request.getParameter("subLedId"));
			box.put("subLedId",subLedId);
		}
		String transferHo = "";
		if (request.getParameter("transferHo") != null && !request.getParameter("transferHo").isEmpty()) {
			transferHo = request.getParameter("transferHo");
			box.put("transferHo",transferHo);
		}
		
		
		MasStoreFinancial msf = new MasStoreFinancial();	
		msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
		box.put("fYear", msf.getId());
		System.out.println("box.getInt()"+msf.getId());
		
	/*	int fyear = 0;
		if (session.getAttribute("financialYear") != null) {
			fyear = (Integer) session.getAttribute("financialYear");
			box.put("fyear", fyear);
		}*/
	/*	String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}*/
		
		map = accountHandlerService.submitPaymentVoucher(box);
		String voucherNo="";
		if(map.get("voucherNo1")!=null){
			voucherNo=(String)map.get("voucherNo1");
		}
		String voucherType="";
		if(map.get("voucherType")!=null){
			voucherType=(String)map.get("voucherType");
		}

		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		String voucherType1 = "PV";
		if (saved) {
			message = "Payment Voucher Saved Successfully and Pending for Approval with voucher No="+voucherNo+".";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		map.put("voucherType1", voucherType1);
		if (map.get("voucherNo") != null) {
			map.put("voucherNo", map.get("voucherNo"));
		}
		map.put("voucherDate", box.getString(VOUCHER_DATE));
		map.put("fyear", msf.getId());
		map.put("accountId", accountId);
		String url = "/hms/hms/account?method=showPaymentVoucherJsp";
		map.put("url", url);
		String jsp = "fa_msgForVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	

	public ModelAndView submitPaymentVoucherApproval(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		
		map = accountHandlerService.submitPaymentVoucherApproval(box);
		String voucherNo="";
		if(map.get("voucherNo")!=null){
			voucherNo=(String)map.get("voucherNo");
		}
		
		String approvalStatus="";
		if(map.get("approvalStatus")!=null){
			approvalStatus=(String)map.get("approvalStatus");
		}

		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		
		if (saved) {
			message = "Payment Voucher with voucher No="+voucherNo+ " is "+approvalStatus;
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "msgForVoucherApproval" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// --------------------------------------------Sales Voucher-----------------------------------------//	
	
	
	public ModelAndView showSalesVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			generalMap.put("locationId", locationId);
		}
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			generalMap.put("fYearDesc", fYearDesc);
		}
		String unitType="";
		if (session.getAttribute("unitType") != null) {
			unitType = (String) session.getAttribute("unitType");
			generalMap.put("unitType", unitType);
		}
		map = accountHandlerService.showSalesVoucherJsp(generalMap);
		String jsp = "fa_salesVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitSalesVoucher(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		int fyear = 0;
		if (session.getAttribute("financialYear") != null) {
			fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		map = accountHandlerService.submitSalesVoucher(box);
		String voucherNo="";
		if(map.get("voucherNo1")!=null){
			voucherNo=(String)map.get("voucherNo1");
		}
		String voucherType="";
		if(map.get("voucherType")!=null){
			voucherType=(String)map.get("voucherType");
		}

		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		String voucherType1 = "SV";
		if (saved) {
			message = "Sales Voucher Saved Successfully with Voucher No="+voucherType1+"/"+voucherNo+".";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		map.put("voucherType1", voucherType1);
		if (map.get("voucherNo") != null) {
			map.put("voucherNo", map.get("voucherNo"));
		}
		map.put("fyear", fyear);
		map.put("voucherDate", box.getString(VOUCHER_DATE));
		String url = "/erp/erp/account?method=showSalesVoucherJsp";
		map.put("url", url);
		String jsp = "fa_msgForVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitSalesVoucherApproval(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		
		
		map = accountHandlerService.submitSalesVoucherApproval(box);
		String voucherNo="";
		if(map.get("voucherNo")!=null){
			voucherNo=(String)map.get("voucherNo");
		}
		
		String approvalStatus="";
		if(map.get("approvalStatus")!=null){
			approvalStatus=(String)map.get("approvalStatus");
		}

		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		
		if (saved) {
			message = "Sales Voucher with voucher No="+voucherNo+ " is "+approvalStatus;
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "msgForVoucherApproval" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	//check 
	
	// --------------------------------------------------------Sales Return Voucher--------------------------------------------------//
		public ModelAndView showSalesReturnVoucherJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			String fYearDesc = "";
			if (session.getAttribute("fYearDesc") != null) {
				fYearDesc = (String) session.getAttribute("fYearDesc");
				generalMap.put("fYearDesc", fYearDesc);
			}
			if (session.getAttribute("locationId") != null) {
				int locationId = (Integer) session.getAttribute("locationId");
				generalMap.put("locationId", locationId);
			}
			String unitType="";
			if (session.getAttribute("unitType") != null) {
				unitType = (String) session.getAttribute("unitType");
				generalMap.put("unitType", unitType);
			}
			map = accountHandlerService.showSalesReturnVoucherJsp(generalMap);
			String jsp = "fa_sales_return_voucher" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView submitSalesReturnVoucher(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("locationId") != null) {
				int locationId = (Integer) session.getAttribute("locationId");
				box.put("locationId", locationId);
			}
			if (session.getAttribute("users") != null) {
				Users users = (Users) session.getAttribute("users");
				int changedBy = users.getId();
				box.put("changedBy", changedBy);
			}
			int fyear = 0;
			if (session.getAttribute("financialYear") != null) {
				fyear = (Integer) session.getAttribute("financialYear");
				box.put("fYear", fyear);
			}
			String fYearDesc = "";
			if (session.getAttribute("fYearDesc") != null) {
				fYearDesc = (String) session.getAttribute("fYearDesc");
				box.put("fYearDesc", fYearDesc);
			}
			map = accountHandlerService.submitSalesReturnVoucher(box);
			String voucherNo="";
			if(map.get("voucherNo1")!=null){
				voucherNo=(String)map.get("voucherNo1");
			}
			String voucherType="";
			if(map.get("voucherType")!=null){
				voucherType=(String)map.get("voucherType");
			}

			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			String voucherType1 = "SR";
			if (saved) {
				message = "Sales return Voucher Saved Successfully with Voucher No="+voucherType1+"/"+voucherNo+".";
			} else {
				message = "Try Again!";
			}
			map.put("message", message);
			map.put("voucherType1", voucherType1);
			if (map.get("voucherNo") != null) {
				map.put("voucherNo", map.get("voucherNo"));
			}
			map.put("fyear", fyear);
			map.put("voucherDate", box.getString(VOUCHER_DATE));
			String url = "/erp/erp/account?method=showSalesReturnVoucherJsp";
			map.put("url", url);
			String jsp = "fa_msgForVoucher" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}

		// =========================================Purchase Voucher============================================================//
		public ModelAndView showPurchaseVoucherJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
		
			MasStoreFinancial msf = new MasStoreFinancial();	
			msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
			generalMap.put("fYear", msf.getId());
			
			if (session.getAttribute("hospitalId") != null) {
				int locationId = (Integer) session.getAttribute("hospitalId");
				generalMap.put("locationId", locationId);
			}
			String fYearDesc = "";
			if (session.getAttribute("fYearDesc") != null) {
				fYearDesc = (String) session.getAttribute("fYearDesc");
				generalMap.put("fYearDesc", fYearDesc);
			}
			
			String unitType="";
			if (session.getAttribute("unitType") != null) {
				unitType = (String) session.getAttribute("unitType");
				generalMap.put("unitType", unitType);
			}
			map = accountHandlerService.showPurchaseVoucherJsp(generalMap);
			String jsp = "fa_purchase_voucher" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView submitPurchaseVoucher(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("hospitalId") != null) {
				int locationId = (Integer) session.getAttribute("hospitalId");
				box.put("locationId", locationId);
			}
			if (session.getAttribute("users") != null) {
				Users users = (Users) session.getAttribute("users");
				int changedBy = users.getId();
				box.put("changedBy", changedBy);
			}
			MasStoreFinancial msf = new MasStoreFinancial();	
			msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
			box.put("fYear", msf.getId());
			/*String fYearDesc = "";
			if (session.getAttribute("fYearDesc") != null) {
				fYearDesc = (String) session.getAttribute("fYearDesc");
				box.put("fYearDesc", fYearDesc);
			}*/
			map = accountHandlerService.submitPurchaseVoucher(box);
			String voucherNo="";
			if(map.get("voucherNo1")!=null){
				voucherNo=(String)map.get("voucherNo1");
			}
			String voucherType="";
			if(map.get("voucherType")!=null){
				voucherType=(String)map.get("voucherType");
			}
			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			String voucherType1 = "PRV";
			if (saved) {
				message = "Purchase Voucher Saved Successfully with Voucher No="+voucherNo+".";
			} else {
				message = "Try Again!";
			}
			map.put("message", message);
			map.put("voucherType1", voucherType1);
			if (map.get("voucherNo") != null) {
				map.put("voucherNo", map.get("voucherNo"));
			}
			map.put("fyear", msf.getId());
			map.put("voucherDate", box.getString(VOUCHER_DATE));
			String url = "/hms/hms/account?method=showPurchaseVoucherJsp";
			map.put("url", url);
			String jsp = "fa_msgForVoucher" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView showPurchaseReturnVoucherJsp(
				HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
		/*	int fYear = 0;
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
				generalMap.put("fYear", fYear);
			}*/
			
			MasStoreFinancial msf = new MasStoreFinancial();	
			msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
			generalMap.put("fYear", msf.getId());
			
			if (session.getAttribute("hospitalId") != null) {
				int locationId = (Integer) session.getAttribute("hospitalId");
				generalMap.put("locationId", locationId);
			}
			/*String fYearDesc = "";
			if (session.getAttribute("fYearDesc") != null) {
				fYearDesc = (String) session.getAttribute("fYearDesc");
				generalMap.put("fYearDesc", fYearDesc);
			}*/
			
			String unitType="";
			if (session.getAttribute("unitType") != null) {
				unitType = (String) session.getAttribute("unitType");
				generalMap.put("unitType", unitType);
			}
			map = accountHandlerService.showPurchaseReturnVoucherJsp(generalMap);
			String jsp = "fa_purchase_return_voucher" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView submitPurchaseReturnVoucher(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("hospitalId") != null) {
				int locationId = (Integer) session.getAttribute("hospitalId");
				box.put("locationId", locationId);
			}
			if (session.getAttribute("users") != null) {
				Users users = (Users) session.getAttribute("users");
				int changedBy = users.getId();
				box.put("changedBy", changedBy);
			}
		/*	int fyear = 0;
			if (session.getAttribute("financialYear") != null) {
				fyear = (Integer) session.getAttribute("financialYear");
				box.put("fYear", fyear);
			}*/
			MasStoreFinancial msf = new MasStoreFinancial();	
			msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
			box.put("fYear", msf.getId());
			
			String fYearDesc = "";
			if (session.getAttribute("fYearDesc") != null) {
				fYearDesc = (String) session.getAttribute("fYearDesc");
				box.put("fYearDesc", fYearDesc);
			}
			map = accountHandlerService.submitPurchaseReturnVoucher(box);
			String voucherNo="";
			if(map.get("voucherNo1")!=null){
				voucherNo=(String)map.get("voucherNo1");
			}
			String voucherType="";
			if(map.get("voucherType")!=null){
				voucherType=(String)map.get("voucherType");
			}
			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			String voucherType1 = "PR";
			if (saved) {
				message = "Purchase return Voucher Saved Successfully with Voucher No="+voucherNo+".";
			} else {
				message = "Try Again!";
			}
			map.put("message", message);
			map.put("voucherType1", voucherType1);
			if (map.get("voucherNo") != null) {
				map.put("voucherNo", map.get("voucherNo"));
			}
			map.put("fyear", msf.getId());
			map.put("voucherDate", box.getString(VOUCHER_DATE));
			String url = "/account?method=showPurchaseReturnVoucherJsp";
			map.put("url", url);
			String jsp = "fa_msgForVoucher" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView submitPurchaseReturnVoucherApproval(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			
			
			map = accountHandlerService.submitPurchaseReturnVoucherApproval(box);
			String voucherNo="";
			if(map.get("voucherNo")!=null){
				voucherNo=(String)map.get("voucherNo");
			}
			
			String approvalStatus="";
			if(map.get("approvalStatus")!=null){
				approvalStatus=(String)map.get("approvalStatus");
			}

			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			
			if (saved) {
				message = "Purchase Return Voucher with voucher No="+voucherNo+ " is "+approvalStatus;
			} else {
				message = "Try Again!";
			}
			map.put("message", message);
			String jsp = "msgForVoucherApproval" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView submitReceiptVoucherApproval(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			
			
			map = accountHandlerService.submitReceiptVoucherApproval(box);
			String voucherNo="";
			if(map.get("voucherNo")!=null){
				voucherNo=(String)map.get("voucherNo");
			}
			
			String approvalStatus="";
			if(map.get("approvalStatus")!=null){
				approvalStatus=(String)map.get("approvalStatus");
			}

			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			
			if (saved) {
				message = "Receipt Voucher with voucher No="+voucherNo+ " is "+approvalStatus;
			} else {
				message = "Try Again!";
			}
			map.put("message", message);
			String jsp = "msgForVoucherApproval" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}

		
		//check end
	
	
	//End voucher posting and approval Rahul Srivastava	

	
	
	//start coding for pending list of voucher approval
	public ModelAndView showPendingListForVoucherApproval(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp ="pendingListOfVoucherApproval";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		
	}
	

public ModelAndView pendingListForVoucherApproval(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaVoucherHeader> faVoucherheaderList = new ArrayList<FaVoucherHeader>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	int fYear = 0;
/*	if (session.getAttribute("financialYear") != null) {
		fYear = (Integer) session.getAttribute("financialYear");
		box.put("fYear", fYear);
	}*/
	
	MasStoreFinancial msf = new MasStoreFinancial();	
	msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
	box.put("fYear", msf.getId());
	
	if (session.getAttribute("hospitalId") != null) {
		int locationId = (Integer) session.getAttribute("hospitalId");
		box.put("locationId", locationId);
	}
	
	if (request.getParameter("voucherType") != null && !request.getParameter("voucherType").isEmpty()) {
		String voucherType = request.getParameter("voucherType");
		box.put("voucherType", voucherType);
	}
	map = accountHandlerService.pendingListForVoucherApproval(box);
	
	if(map.get("headerList")!= null)
	{
		faVoucherheaderList =(ArrayList<FaVoucherHeader>) map.get("headerList");
	}
	int totalRecords = 0;
	if(map.get("totalRecords") != null)
	{
		totalRecords = (Integer) map.get("totalRecords");
	}
	try
	{
		PrintWriter pw = response.getWriter();
		if(faVoucherheaderList.size() == 0){
		}
		pw.write("[");
		int counter=1;

		for(FaVoucherHeader list : faVoucherheaderList)
		{
			if(counter != faVoucherheaderList.size())
			{
				pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+list.getVoucherDate()+"\",\"VoucherNo\": \""+list.getVoucherNo()+"\",\"VoucherType\":\""+list.getVoucherType()+"\",\"Amount\":\""+list.getCrAmount()+"\",\"Narration\":\""+list.getNarration()+"\",\"totalRecords\":\""+totalRecords+"\"},");
			}
			else
			{
				pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+list.getVoucherDate()+"\",\"VoucherNo\": \""+list.getVoucherNo()+"\",\"VoucherType\":\""+list.getVoucherType()+"\",\"Amount\":\""+list.getCrAmount()+"\",\"Narration\":\""+list.getNarration()+"\",\"totalRecords\":\""+totalRecords+"\"}");
			}
			counter++;
		}
		pw.write("]");
	}
	catch(Exception e)
	{
		faVoucherheaderList.clear();
		e.printStackTrace();
	}
	faVoucherheaderList.clear();
	return null;
}

public ModelAndView showApprovalJspForVoucher(
		HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasApprovalStatus> approvalStatusList = new ArrayList<MasApprovalStatus>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	HttpSession session = request.getSession();
	int headerId = 0;
	if (Integer.parseInt(request.getParameter("headerId"))!= 0)
		headerId =Integer.parseInt(request.getParameter("headerId")) ;
	
	generalMap.put("headerId", headerId);
	map = accountHandlerService.getDataForVoucherApproval(generalMap);
	
	approvalStatusList = accountHandlerService.getApprovalStatus();
	map.put("approvalStatusList", approvalStatusList);
	
	String unitType="";
	if (session.getAttribute("unitType") != null) {
		unitType = (String) session.getAttribute("unitType");
	}
	
	int locationId=0;
	if (session.getAttribute("locationId") != null) {
		 locationId = (Integer) session.getAttribute("locationId");
	}
	supplierList = accountHandlerService.getsupplierList(unitType,locationId);
	map.put("supplierList", supplierList);
	
	String voucherType="";
	String jsp="";
	if(map.get("voucherType")!=null){
		voucherType = (String) map.get("voucherType");
	}
	if(voucherType.equalsIgnoreCase("PV")){
		
		jsp = "paymentVoucherApproval";
	}
	else if(voucherType.equalsIgnoreCase("SV")|| voucherType.equalsIgnoreCase("SR")){
		jsp = "salesVoucherApproval";
	}
	else if(voucherType.equalsIgnoreCase("JV")){
		jsp = "journalVoucherApproval";
	}
	else if(voucherType.equalsIgnoreCase("RV")){
		jsp = "receiptVoucherApproval";
	}
	
	else if(voucherType.equalsIgnoreCase("PRV")){
		jsp = "purchaseVoucherApproval";
	}
	else if(voucherType.equalsIgnoreCase("PR")){
		jsp = "purchaseVoucherReturnApproval";
	}
	
	jsp = jsp + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}


public ModelAndView showPendingListForReceiptVoucher(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();

	String jsp ="pendingListOfReceiptVoucher";
	jsp = jsp + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
	
}

public ModelAndView pendingListForReceiptVoucherAcceptance(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaVoucherHeader> faVoucherheaderList = new ArrayList<FaVoucherHeader>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	int fYear = 0;
	int locationId=0;
	/*if (session.getAttribute("financialYear") != null) {
		fYear = (Integer) session.getAttribute("financialYear");
		box.put("fYear", fYear);
	}*/
	MasStoreFinancial msf = new MasStoreFinancial();	
	msf = (MasStoreFinancial) accountHandlerService.getFinancialYear();
	box.put("fYear", msf.getId());
	
	
	if (session.getAttribute("hospitalId") != null) {
		locationId = (Integer) session.getAttribute("hospitalId");
		box.put("locationId", locationId);
	}
	if(locationId == 1){
		String unitType = "HO";
		box.put("unitType", unitType);
	}
	map = accountHandlerService.getpendingListForReceiptVoucherAcceptance(box);
	
	if(map.get("headerList")!= null)
	{
		faVoucherheaderList =(ArrayList<FaVoucherHeader>) map.get("headerList");
	}
	int totalRecords = 0;
	if(map.get("totalRecords") != null)
	{
		totalRecords = (Integer) map.get("totalRecords");
	}
	try
	{
		PrintWriter pw = response.getWriter();
		if(faVoucherheaderList.size() == 0){
		}
		pw.write("[");
		int counter=1;

		for(FaVoucherHeader list : faVoucherheaderList)
		{
			if(counter != faVoucherheaderList.size())
			{
				pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+list.getVoucherDate()+"\",\"VoucherNo\": \""+list.getVoucherNo()+"\",\"VoucherType\":\""+list.getVoucherType()+"\",\"Amount\":\""+list.getCrAmount()+"\",\"Narration\":\""+list.getNarration()+"\",\"totalRecords\":\""+totalRecords+"\"},");
			}
			else
			{
				pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+list.getVoucherDate()+"\",\"VoucherNo\": \""+list.getVoucherNo()+"\",\"VoucherType\":\""+list.getVoucherType()+"\",\"Amount\":\""+list.getCrAmount()+"\",\"Narration\":\""+list.getNarration()+"\",\"totalRecords\":\""+totalRecords+"\"}");
			}
			counter++;
		}
		pw.write("]");
	}
	catch(Exception e)
	{
		faVoucherheaderList.clear();
		e.printStackTrace();
	}
	faVoucherheaderList.clear();
	return null;
}


public ModelAndView showApprovalJspForForReceiptVoucherAcceptance(
		HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	int headerId = 0;
	if (Integer.parseInt(request.getParameter("headerId"))!= 0)
		headerId =Integer.parseInt(request.getParameter("headerId")) ;
	
	generalMap.put("headerId", headerId);
	map = accountHandlerService.getDataForReceiptVoucherAcceptance(generalMap);
	
	String jsp = "receiptVoucherAcceptance";
	jsp = jsp + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}

public ModelAndView submitReceiptVoucherAcceptance(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	
	
	map = accountHandlerService.submitReceiptVoucherAcceptance(box);
	String voucherNo="";
	if(map.get("voucherNo")!=null){
		voucherNo=(String)map.get("voucherNo");
	}
	
	String approvalStatus="";
	if(map.get("approvalStatus")!=null){
		approvalStatus=(String)map.get("approvalStatus");
	}

	boolean saved = false;
	String message = "";
	if (map.get("saved") != null) {
		saved = (Boolean) map.get("saved");
	}
	
	if (saved) {
		message = "Receipt Voucher with voucher No="+voucherNo+ " is "+approvalStatus;
	} else {
		message = "Try Again!";
	}
	map.put("message", message);
	String jsp = "msgForVoucherApproval" + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}

	
	
	//End coding for pending list of voucher approval
	
//********************************** Below code is commented************************************************
	
/*public ModelAndView showPendingListForJVApproval(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();

	String jsp ="pendingListOfJournalVoucher";
	jsp = jsp + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
	
}

public ModelAndView showPendingListForSVApproval(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();

	String jsp ="pendingListOfsalesVoucher";
	jsp = jsp + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
	
}

public ModelAndView showPendingListForPVApproval(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();

	String jsp ="pendingListOfPurchaseVoucher";
	jsp = jsp + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
	
}
*/

}