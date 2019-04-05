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
package jkt.hms.payroll.controller;

import static jkt.hms.util.RequestConstants.ARREAR_ELEMENT;
import static jkt.hms.util.RequestConstants.BASIC_DEPENDENT;
import static jkt.hms.util.RequestConstants.BASIC_MULTIPLIER;
import static jkt.hms.util.RequestConstants.BONUS_RATE;
import static jkt.hms.util.RequestConstants.BONUS_TYPE;
import static jkt.hms.util.RequestConstants.CARRY_FORWARD;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.CTC_HEADING;
import static jkt.hms.util.RequestConstants.DUE_DATE;
import static jkt.hms.util.RequestConstants.EFFECTIVE_DATE;
import static jkt.hms.util.RequestConstants.FIXED_AMOUNT;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.GRADE_ID;
import static jkt.hms.util.RequestConstants.HR_BONUS_JSP;
import static jkt.hms.util.RequestConstants.HR_LOAN_JSP;
import static jkt.hms.util.RequestConstants.HR_PAYELEMENT_JSP;
import static jkt.hms.util.RequestConstants.HR_PAYROLL_JSP;
import static jkt.hms.util.RequestConstants.HR_REIMBERSEMENT_JSP;
import static jkt.hms.util.RequestConstants.INTEREST_PERCENT;
import static jkt.hms.util.RequestConstants.MAXIMUM_AMOUNT;
import static jkt.hms.util.RequestConstants.MAX_BASIC;
import static jkt.hms.util.RequestConstants.MAX_TAX_EXEMPTION;
import static jkt.hms.util.RequestConstants.OT_CALCULATION;
import static jkt.hms.util.RequestConstants.PAYMENT_FREQUENCY;
import static jkt.hms.util.RequestConstants.PAY_ELEMENT_STATUS;
import static jkt.hms.util.RequestConstants.PAY_ELEMENT_TYPE;
import static jkt.hms.util.RequestConstants.PF_DEPENDENT;
import static jkt.hms.util.RequestConstants.REIMB_ELEMENT;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SEC_DESC;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SHOW_IN_PAYSLIP;
import static jkt.hms.util.RequestConstants.STATUS_DATE;
import static jkt.hms.util.RequestConstants.TAXABLE;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.HrMasBonus;
import jkt.hms.masters.business.HrMasItaxExemption;
import jkt.hms.masters.business.HrMasItaxSurcharge;
import jkt.hms.masters.business.HrMasLoan;
import jkt.hms.masters.business.HrMasPayElement;
import jkt.hms.masters.business.HrMasPayroll;
import jkt.hms.masters.business.HrMasReimbersement;
import jkt.hms.masters.business.HrMasSurcharge;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.Users;
import jkt.hms.payroll.handler.PayrollMastersHandlerService;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PayrollMastersController extends MultiActionController {
	
	PayrollMastersHandlerService payrollMastersHandlerService = null;

	public PayrollMastersHandlerService getPayrollMastersHandlerService() {
		return payrollMastersHandlerService;
	}

	public void setPayrollMastersHandlerService(
			PayrollMastersHandlerService payrollMastersHandlerService) {
		this.payrollMastersHandlerService = payrollMastersHandlerService;
	}
	
	


	String jsp = "";
	Map<String, Object> map = null;
	String title = "";
	String message = "";
	String url = "";
	String code = "";
	String name = "";
	String currentDate = "";
	String currentTime = "";
	String changedBy = "";
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	HttpSession session = null;
	
	

	// Staring point 
	
	public ModelAndView showPayElementJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollMastersHandlerService.showPayElementJsp();
		String jsp = HR_PAYELEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView savePayElement(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		HrMasPayElement hrMasPayElement = new HrMasPayElement();
		HttpSession session = request.getSession();
		
		String payElementCode = "";
		if (request.getParameter(CODE) != null) {
			payElementCode = request.getParameter(CODE);
		}
		hrMasPayElement.setPayElementCode(payElementCode);
		String payElementDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			payElementDescription = request.getParameter(SEARCH_NAME);
		}
		hrMasPayElement.setPayElementDesc(payElementDescription);
		Date effectiveDate =new Date();
		if(request.getParameter(EFFECTIVE_DATE) != null && !(request.getParameter(EFFECTIVE_DATE).equals(""))){
			effectiveDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(EFFECTIVE_DATE));
		}
		hrMasPayElement.setEffectiveDate(effectiveDate);
		String payElementType = "";
		if (request.getParameter(PAY_ELEMENT_TYPE)!= null) {
			payElementType = request.getParameter(PAY_ELEMENT_TYPE);
		}
		hrMasPayElement.setPayElementType(payElementType);
		if (request.getParameter(TAXABLE)!= null) {
			hrMasPayElement.setTaxableElement("y");
		}else {
			hrMasPayElement.setTaxableElement("n");
		}
		
		if (request.getParameter(OT_CALCULATION)!= null) {
			hrMasPayElement.setOtCalculation("y");
		}else {
			hrMasPayElement.setOtCalculation("n");
		}
		
		Float basicMultiplier = 0.0f;
		if (request.getParameter(BASIC_MULTIPLIER)!= null && !(request.getParameter(BASIC_MULTIPLIER).equals(""))  ) {
			basicMultiplier = Float.parseFloat(request.getParameter(BASIC_MULTIPLIER));
		}
		hrMasPayElement.setBasicMultiplier(basicMultiplier);
		
		Float prevailingPercentage = 0.0f;
		if (request.getParameter("percentageAmt")!= null && !(request.getParameter("percentageAmt").equals(""))  ) {
			prevailingPercentage = Float.parseFloat(request.getParameter("percentageAmt"));
		}
		hrMasPayElement.setPercentage(prevailingPercentage);
		
		if (request.getParameter(ARREAR_ELEMENT)!= null) {
			hrMasPayElement.setArrearElement("y");
		}else {
			hrMasPayElement.setArrearElement("n");
		}
		
		if (request.getParameter(REIMB_ELEMENT)!= null) {
			hrMasPayElement.setReimbElement("y");
		}else {
			hrMasPayElement.setReimbElement("n");
		}
		
		if (request.getParameter(BASIC_DEPENDENT)!= null) {
			hrMasPayElement.setBasicDependent("y");
		}else {
			hrMasPayElement.setBasicDependent("n");
		}
		
		if (request.getParameter("lblPrePercentage")!= null) {
			hrMasPayElement.setPrevailingPercentage("y");
		}else {
			hrMasPayElement.setPrevailingPercentage("n");
		}
		
		if (request.getParameter(PF_DEPENDENT)!= null) {
			hrMasPayElement.setPfDependent("y");
		}else {
			hrMasPayElement.setPfDependent("n");
		}
		if (request.getParameter(SHOW_IN_PAYSLIP)!= null) {
			hrMasPayElement.setShowInPayslip("y");
		}else {
			hrMasPayElement.setShowInPayslip("n");
		}
		BigDecimal maxAmount = null;
		
		if (request.getParameter(MAXIMUM_AMOUNT)!= null && !request.getParameter(MAXIMUM_AMOUNT).equals("")) {
			maxAmount = new BigDecimal(request.getParameter(MAXIMUM_AMOUNT));
			hrMasPayElement.setMaxAmount(maxAmount);
		}
		String ctcHeading = "";
		if (request.getParameter(CTC_HEADING)!= null) {
			ctcHeading = request.getParameter(CTC_HEADING);
		}
		hrMasPayElement.setCtcHeading(ctcHeading);
		
		String payElementStatus = "";
		if (request.getParameter(PAY_ELEMENT_STATUS)!= null) {
			payElementStatus = request.getParameter(PAY_ELEMENT_STATUS);
		}
		hrMasPayElement.setPayElementStatus(payElementStatus);
		Date statusDate =new Date();
		if(request.getParameter(STATUS_DATE) != null && !(request.getParameter(STATUS_DATE).equals(""))){
			statusDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(STATUS_DATE));
		}
		hrMasPayElement.setStatusDate(statusDate);
		int userId=0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasPayElement.setLastChgBy(users);
			}
		Date currentDate = null; 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		
		hrMasPayElement.setLastChgDate(currentDate);
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		
		hrMasPayElement.setLastChgTime(currentTime);
		hrMasPayElement.setStatus("y");
		
		int locationId=0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer)session.getAttribute("hospitalId");
			MasHospital ms =  new MasHospital();
			ms.setId(locationId);
			hrMasPayElement.setHospital(ms);
			generalMap.put("locationId", locationId);
		}
		
		generalMap.put("code", payElementCode);
		generalMap.put("name", payElementDescription);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
	

		listMap = payrollMastersHandlerService.duplicatePayElement(generalMap);

		List duplicatePayElementList = new ArrayList();
	
		if (listMap.get("duplicatePayElementList") != null) {
			duplicatePayElementList = (List) listMap.get("duplicatePayElementList");
		}
			
		if ((duplicatePayElementList.size() == 0 || duplicatePayElementList == null)) {
		
			map = payrollMastersHandlerService.savePayElement(hrMasPayElement);
			message = "Record Added Successfully !!";
		
		}
		else if (duplicatePayElementList.size() != 0 || duplicatePayElementList != null) 
		{
			message = "Reacord already exist.";
			
		}
		try {
			map = payrollMastersHandlerService.showPayElementJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		String jsp = HR_PAYELEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editPayElement(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		int payElementId = 0;
		if(request.getParameter(CODE) != null && !(request.getParameter(COMMON_ID).equals(""))){
			payElementId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		generalMap.put("payElementId", payElementId);
		String payElementCode = "";
		if (request.getParameter(CODE) != null) {
			payElementCode = request.getParameter(CODE);
		}
		generalMap.put("payElementCode", payElementCode);
		String payElementDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			payElementDescription = request.getParameter(SEARCH_NAME);
		}
		generalMap.put("payElementDescription", payElementDescription);
		
		Date effectiveDate =new Date();
		if(request.getParameter(EFFECTIVE_DATE) != null && !(request.getParameter(EFFECTIVE_DATE).equals(""))){
			effectiveDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(EFFECTIVE_DATE));
		}
		generalMap.put("effectiveDate", effectiveDate);
		String payElementType = "";
		if (request.getParameter(PAY_ELEMENT_TYPE)!= null) {
			payElementType = request.getParameter(PAY_ELEMENT_TYPE);
		}
		generalMap.put("payElementType", payElementType);
		String taxableElement = "";
		if (request.getParameter(TAXABLE)!= null) {
			taxableElement = "y";
		}else {
			taxableElement = "n";
		}
		generalMap.put("taxableElement", taxableElement);
		
		String otCalculation = "";
		if (request.getParameter(OT_CALCULATION)!= null) {
			otCalculation= "y";
		}else {
			otCalculation= "n";
		}
		generalMap.put("otCalculation", otCalculation);
		
		Float basicMultiplier =0.0f;
		if (request.getParameter(BASIC_MULTIPLIER)!= null  && !request.getParameter(BASIC_MULTIPLIER).equals("")) {
			basicMultiplier = Float.parseFloat(request.getParameter(BASIC_MULTIPLIER));
		}
		generalMap.put("basicMultiplier", basicMultiplier);
		
		Float prevailingPercentage = 0.0f;
		if (request.getParameter("percentageAmt")!= null && !(request.getParameter("percentageAmt").equals(""))  ) {
			prevailingPercentage = Float.parseFloat(request.getParameter("percentageAmt"));
		}
		generalMap.put("prevailingPercentage", prevailingPercentage);
		
		
		String arrearElement = "";
		if (request.getParameter(ARREAR_ELEMENT)!= null) {
			arrearElement = "y";
		}else {
			arrearElement = "n";
		}
		generalMap.put("arrearElement", arrearElement);
		
		String reimbElement = "";
		if (request.getParameter(REIMB_ELEMENT)!= null) {
			reimbElement = "y";
		}else {
			reimbElement = "n";;
		}
		generalMap.put("reimbElement", reimbElement);
		
		String basicDependent = "";
		if (request.getParameter(BASIC_DEPENDENT)!= null) {
			basicDependent = "y";
		}else {
			basicDependent = "n";;
		}
		generalMap.put("basicDependent", basicDependent);
		
		String lblPrePercentage = "";
		if (request.getParameter("lblPrePercentage")!= null) {
			lblPrePercentage = "y";
		}else {
			lblPrePercentage = "n";;
		}
		generalMap.put("lblPrePercentage", lblPrePercentage);
		
		
		String showInPayslip = "";
		if (request.getParameter(SHOW_IN_PAYSLIP)!= null) {
			showInPayslip = "y";
		}else {
			showInPayslip = "n";;
		}
		generalMap.put("showInPayslip", showInPayslip);
		String pfDependent = "";
		if (request.getParameter(PF_DEPENDENT)!= null) {
			pfDependent = "y";
		}else {
			pfDependent = "n";
		}
		generalMap.put("pfDependent", pfDependent);
		
		BigDecimal maxAmount = null;
		if (request.getParameter(MAXIMUM_AMOUNT)!= null && !request.getParameter(MAXIMUM_AMOUNT).equals("")) {
			maxAmount = new BigDecimal(request.getParameter(MAXIMUM_AMOUNT));
			
		}
		generalMap.put("maxAmount", maxAmount);
		
		String ctcHeading = "";
		if (request.getParameter(CTC_HEADING)!= null) {
			ctcHeading = request.getParameter(CTC_HEADING);
		}
		generalMap.put(CTC_HEADING, ctcHeading);
		
		String payElementStatus = "";
		if (request.getParameter(PAY_ELEMENT_STATUS)!= null) {
			payElementStatus = request.getParameter(PAY_ELEMENT_STATUS);
		}
		generalMap.put("payElementStatus", payElementStatus);
		Date statusDate =new Date();
		if(request.getParameter(STATUS_DATE) != null && !(request.getParameter(STATUS_DATE).equals(""))){
			statusDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(STATUS_DATE));
		}
		generalMap.put("statusDate", statusDate);
		generalMap.put("userId", userId);
		Date currentDate = null; 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		generalMap.put("currentDate", currentDate);
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("currentTime", currentTime);
		
		int locationId=0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer)session.getAttribute("hospitalId");
			generalMap.put("locationId", locationId);
		}
		generalMap.put("code", payElementCode);
		generalMap.put("name", payElementDescription);
		generalMap.put("locationId", locationId);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
	
		
			map = payrollMastersHandlerService.editPayElement(generalMap);
			message = "Record Updated Successfully !!";
		
		
		try {
			map = payrollMastersHandlerService.showPayElementJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String jsp = HR_PAYELEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView deletePayElement(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		String message="";
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		int payElementId=0;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			payElementId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		String changedBy = "";
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		Date currentDate = new Date(); 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		System.out.println("in delete currentTime----------"+currentTime);
		generalMap.put("payElementId", payElementId);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		
		map = payrollMastersHandlerService.deletePayElement(generalMap);
		
		String jsp = HR_PAYELEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchPayElement(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String payElementCode = "";
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			payElementCode = request.getParameter(CODE);
		}
		String payElementDescription = "";
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			payElementDescription = request.getParameter(SEARCH_NAME);
		}
		int searchRadio=1;
		String searchField= "";
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;	
				}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(searchRadio==1){
			payElementCode=searchField;
			payElementDescription=null;

		}else{
			payElementCode=null;
			payElementDescription=searchField;
		}
		map = payrollMastersHandlerService.searchPayElement(payElementCode,payElementDescription);
		String jsp = HR_PAYELEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search","search");
		return new ModelAndView("index", "map", map);
	}
	// Above Complete
	
	public ModelAndView showPayrollJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollMastersHandlerService.showPayrollJsp();
		String jsp = HR_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView savePayroll(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		HrMasPayroll hrMasPayroll = new HrMasPayroll();
		HttpSession session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute("hospitalId")!= null) {
			hospitalId = (Integer)session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasPayroll.setHospital(masHospital);
		}
		String payrollCode = "";
		if (request.getParameter(CODE) != null) {
			payrollCode = request.getParameter(CODE);
		}
		hrMasPayroll.setPayrollCode(payrollCode);
		String payrollDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			payrollDescription = request.getParameter(SEARCH_NAME);
		}
		hrMasPayroll.setPayrollDescription(payrollDescription);
		Date fromDate =new Date();
		if(request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))){
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
		}
		hrMasPayroll.setFromDate(fromDate);
		Date toDate =new Date();
		if(request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))){
			toDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
		}
		hrMasPayroll.setToDate(toDate);
		String frequency = "";
		if (request.getParameter(PAYMENT_FREQUENCY) != null) {
			frequency = request.getParameter(PAYMENT_FREQUENCY);
		}
		hrMasPayroll.setFrequency(frequency);
		int userId=0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasPayroll.setLastChgBy(users);
			}
		Date currentDate = null; 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		hrMasPayroll.setLastChgDate(currentDate);
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		hrMasPayroll.setLastChgTime(currentTime);
		hrMasPayroll.setStatus("y");

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
		generalMap.put("code",payrollCode);
		generalMap.put("name",payrollDescription);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = payrollMastersHandlerService.checkForExistingMasters(generalMap);

		List codeList = new ArrayList();
		List nameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			codeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			nameList = (List) listMap.get("duplicateGeneralNameList");
		}
		
		if ((codeList.size() == 0 || codeList == null)&& (nameList.size() == 0 || nameList == null)) {
		

			map = payrollMastersHandlerService.savePayroll(hrMasPayroll);
			message = "Record Added Successfully !!";
		
		}
		else if ((codeList.size() != 0 || codeList != null)	|| (nameList.size() != 0)|| nameList != null) 
		{
			if ((codeList.size() != 0 || codeList != null)&& nameList.size() == 0 || nameList == null) 
			{
				message = "Payroll Code  already exists.";
			} 
			else if ((nameList.size() != 0 || nameList != null)	&& (codeList.size() == 0 || codeList == null))
			{
				message = "Payroll Description already exists.";
			}
			else if ((codeList.size() != 0 || codeList != null)	&& (nameList.size() != 0 || nameList != null)) 
			{

				message = "Payroll Code and Payroll Description already exist.";
			}
		}
		try {
			map = payrollMastersHandlerService.showPayrollJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String jsp = HR_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView editPayroll(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		int payrollId = 0;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			payrollId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		generalMap.put("payrollId", payrollId);
		String payrollCode = "";
		if (request.getParameter(CODE) != null) {
			payrollCode = request.getParameter(CODE);
		}
		generalMap.put("payrollCode", payrollCode);
		String payrollDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			payrollDescription = request.getParameter(SEARCH_NAME);
		}
		generalMap.put("payrollDescription", payrollDescription);
		Date fromDate =new Date();
		if(request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))){
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
		}
		generalMap.put("fromDate", fromDate);
		Date toDate =new Date();
		if(request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))){
			toDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
		}
		generalMap.put("toDate", toDate);
		String frequency = "";
		if (request.getParameter(PAYMENT_FREQUENCY) != null) {
			frequency = request.getParameter(PAYMENT_FREQUENCY);
		}
		generalMap.put("frequency", frequency);
		generalMap.put("userId", userId);
		Date currentDate = null; 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		generalMap.put("currentDate", currentDate);
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("currentTime", currentTime);
		
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		

			map = payrollMastersHandlerService.editPayroll(generalMap);
			message = "Record Updated Successfully !!";
		
		try {
			map = payrollMastersHandlerService.showPayrollJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
		String jsp = HR_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView deletePayroll(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		int payrollId=0;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			payrollId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		Date currentDate = new Date(); 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("payrollId", payrollId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("userId", userId);
		map = payrollMastersHandlerService.deletePayroll(generalMap);
		String jsp = HR_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchPayroll(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String payrollCode = "";
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			payrollCode = request.getParameter(CODE);
		}
		String payrollDescription = "";
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			payrollDescription = request.getParameter(SEARCH_NAME);
		}
		int searchRadio=1;
		String searchField= "";
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;	
				}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(searchRadio==1){
			payrollCode=searchField;
			payrollDescription=null;

		}else{
			payrollCode=null;
			payrollDescription=searchField;
		}
		map = payrollMastersHandlerService.searchPayroll(payrollCode,payrollDescription);
		String jsp = HR_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showLoanJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollMastersHandlerService.showLoanJsp();
		String jsp = HR_LOAN_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView saveLoan(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		HrMasLoan hrMasLoan = new HrMasLoan();
		HttpSession session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute("hospitalId")!= null) {
			hospitalId = (Integer)session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasLoan.setHospital(masHospital);
		}
		String loanCode = "";
		if (request.getParameter(CODE) != null) {
			loanCode = request.getParameter(CODE);
		}
		hrMasLoan.setLoanCode(loanCode);
		String loanDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			loanDescription = request.getParameter(SEARCH_NAME);
		}
		hrMasLoan.setLoanDescription(loanDescription);
		
		
		BigDecimal maxAmount = null;
		if (request.getParameter(MAXIMUM_AMOUNT)!= null && !request.getParameter(MAXIMUM_AMOUNT).equals("")) {
			maxAmount = new BigDecimal(request.getParameter(MAXIMUM_AMOUNT));
		}
		hrMasLoan.setMaxAmount(maxAmount);
		Float interestPercent = null;
		if (request.getParameter(INTEREST_PERCENT)!= null && !request.getParameter(INTEREST_PERCENT).equals("")) {
			interestPercent = Float.parseFloat(request.getParameter(INTEREST_PERCENT));
		}
		hrMasLoan.setInterestPercent(interestPercent);
		int userId=0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasLoan.setLastChgBy(users);
			}
		
		Date currentDate = null; 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		hrMasLoan.setLastChgDate(currentDate);
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		hrMasLoan.setLastChgTime(currentTime);
		hrMasLoan.setStatus("y");

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
		generalMap.put("code",loanCode);
		generalMap.put("name",loanDescription);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = payrollMastersHandlerService.checkForExistingMasters(generalMap);

		List codeList = new ArrayList();
		List nameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			codeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			nameList = (List) listMap.get("duplicateGeneralNameList");
		}
		
		if ((codeList.size() == 0 || codeList == null)&& (nameList.size() == 0 || nameList == null)) {
		

			map = payrollMastersHandlerService.saveLoan(hrMasLoan);
			
			message = "Record Added Successfully !!";
		
		}
		else if ((codeList.size() != 0 || codeList != null)	|| (nameList.size() != 0)|| nameList != null) 
		{
			if ((codeList.size() != 0 || codeList != null)&& nameList.size() == 0 || nameList == null) 
			{
				message = "Loan Code  already exists.";
			} 
			else if ((nameList.size() != 0 || nameList != null)	&& (codeList.size() == 0 || codeList == null))
			{
				message = "Loan Description already exists.";
			}
			else if ((codeList.size() != 0 || codeList != null)	&& (nameList.size() != 0 || nameList != null)) 
			{

				message = "Loan Code and Loan Description already exist.";
			}
		}
		try {
			map = payrollMastersHandlerService.showLoanJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String jsp = HR_LOAN_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editLoan(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		int loanId = 0;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			loanId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		generalMap.put("loanId", loanId);
		String loanCode = "";
		if (request.getParameter(CODE) != null) {
			loanCode = request.getParameter(CODE);
		}
		generalMap.put("loanCode", loanCode);
		String loanDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			loanDescription = request.getParameter(SEARCH_NAME);
		}
		generalMap.put("loanDescription", loanDescription);
		
		BigDecimal maxAmount = null;
		if (request.getParameter(MAXIMUM_AMOUNT)!= null) {
			maxAmount = new BigDecimal(request.getParameter(MAXIMUM_AMOUNT));
		}
		generalMap.put("maxAmount", maxAmount);
		Float interestPercent = null;
		if (request.getParameter(INTEREST_PERCENT)!= null && !request.getParameter(INTEREST_PERCENT).equals("")) {
			interestPercent = Float.parseFloat(request.getParameter(INTEREST_PERCENT));
		}
		generalMap.put("interestPercent", interestPercent);
		generalMap.put("userId", userId);
		Date currentDate = null; 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		generalMap.put("currentDate", currentDate);
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("currentTime", currentTime);
		
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
	
			map = payrollMastersHandlerService.editLoan(generalMap);
			message = "Record Updated Successfully !!";
		
	
		try {
			map = payrollMastersHandlerService.showLoanJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String jsp = HR_LOAN_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView deleteLoan(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		int loanId=0;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			loanId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		Date currentDate = new Date(); 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("loanId", loanId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("userId", userId);
		map = payrollMastersHandlerService.deleteLoan(generalMap);
		String jsp = HR_LOAN_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchLoan(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String loanCode = "";
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			loanCode = request.getParameter(CODE);
		}
		String loanDescription = "";
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			loanDescription = request.getParameter(SEARCH_NAME);
		}
		System.out.println("loanDescription---- "+loanDescription);
		int searchRadio=1;
		String searchField= "";
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;	
				}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(searchRadio==1){
			loanCode=searchField;
			loanDescription=null;

		}else{
			loanCode=null;
			loanDescription=searchField;
		}
		map = payrollMastersHandlerService.searchLoan(loanCode,loanDescription);
		String jsp = HR_LOAN_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search","search");
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showReimbersementJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = payrollMastersHandlerService.showReimbersementJsp();
		String jsp = HR_REIMBERSEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveReimbersement(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasReimbersement hrMasReimbersement = new HrMasReimbersement();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId =0;
		String	reimbCode="";
		String reimbDescription="";
		if (session.getAttribute("hospitalId")!= null) {
			hospitalId = (Integer)session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasReimbersement.setHospital(masHospital);
		}
		if (request.getParameter(CODE) != null) {
			reimbCode = request.getParameter(CODE);
		 hrMasReimbersement.setReimbCode(reimbCode);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			reimbDescription = request.getParameter(SEARCH_NAME);
			hrMasReimbersement.setReimbDesc(reimbDescription);
		}
		if (request.getParameter(MAXIMUM_AMOUNT)!= null && !request.getParameter(MAXIMUM_AMOUNT).equals("")) {
		 BigDecimal maxAmount = new BigDecimal(request.getParameter(MAXIMUM_AMOUNT));
		 hrMasReimbersement.setMaxAmount(maxAmount);
		}
		if (request.getParameter(TAXABLE)!= null) {
			hrMasReimbersement.setTaxable("y");
		}else {
			hrMasReimbersement.setTaxable("n");
		}
		if (request.getParameter(MAX_TAX_EXEMPTION)!= null  && !request.getParameter(MAX_TAX_EXEMPTION).equals("")) {
			 BigDecimal maxTaxExemption = new BigDecimal(request.getParameter(MAX_TAX_EXEMPTION));
			 hrMasReimbersement.setMaxTaxExemption(maxTaxExemption);
		}
		if (request.getParameter(CARRY_FORWARD)!= null) {
			hrMasReimbersement.setCarryForward("y");
		}else {
			hrMasReimbersement.setCarryForward("n");
		}
		int userId=0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
	
			}
		
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 hrMasReimbersement.setLastChgDate(currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			hrMasReimbersement.setLastChgTime(currentTime);
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
		generalMap.put("code", reimbCode);
		generalMap.put("name", reimbDescription);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = payrollMastersHandlerService.checkForExistingMasters(generalMap);

		List codeList = new ArrayList();
		List nameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			codeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			nameList = (List) listMap.get("duplicateGeneralNameList");
		}
		System.out.println("codeList"+codeList.size());
		System.out.println("nameList"+nameList.size());
		if ((codeList.size() == 0 || codeList == null)&& (nameList.size() == 0 || nameList == null)) {
		
		hrMasReimbersement.setStatus("y");
		map = payrollMastersHandlerService.saveReimbersement(hrMasReimbersement);
		message = "Record Added Successfully !!";
		
		}
		else if ((codeList.size() != 0 || codeList != null)	|| (nameList.size() != 0)|| nameList != null) 
		{
			if ((codeList.size() != 0 || codeList != null)&& nameList.size() == 0 || nameList == null) 
			{
				message = "Reimbersement Code  already exists.";
			} 
			else if ((nameList.size() != 0 || nameList != null)	&& (codeList.size() == 0 || codeList == null))
			{
				message = "Reimbersement Description already exists.";
			}
			else if ((codeList.size() != 0 || codeList != null)	&& (nameList.size() != 0 || nameList != null)) 
			{

				message = "Reimbersement Code and Reimbersement Description already exist.";
			}
		}
		try {
			map = payrollMastersHandlerService.showReimbersementJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = HR_REIMBERSEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView editReimbersement(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		int userId=0;
		String	reimbCode ="";
		String	reimbDescription ="";
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		int	reimbId =Integer.parseInt( request.getParameter(COMMON_ID));
			generalMap.put("reimbId", reimbId);
		}
		if (request.getParameter(CODE) != null) {
				reimbCode = request.getParameter(CODE);
			 generalMap.put("reimbCode", reimbCode);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
					reimbDescription = request.getParameter(SEARCH_NAME);
				 generalMap.put("reimbDescription", reimbDescription);
			}
			if (request.getParameter(MAXIMUM_AMOUNT)!= null) {
			 BigDecimal maxAmount = new BigDecimal(request.getParameter(MAXIMUM_AMOUNT));
			  generalMap.put("maxAmount", maxAmount);
			}
			if (request.getParameter(TAXABLE)!= null) {
			     String taxable	= "y";
			     generalMap.put("taxable", taxable);
			}else {
				String taxable	= "n";
			     generalMap.put("taxable", taxable);
			}
			
			if (request.getParameter(MAX_TAX_EXEMPTION)!= null && !request.getParameter(MAX_TAX_EXEMPTION).equals("")) {
				 BigDecimal maxTaxExemption = new BigDecimal(request.getParameter(MAX_TAX_EXEMPTION));
				 generalMap.put("maxTaxExemption", maxTaxExemption);
			}
			if (request.getParameter(CARRY_FORWARD)!= null) {
				String carryForward = "y";
				generalMap.put("carryForward", carryForward);
			}else {
				String carryForward = "y";
				generalMap.put("carryForward", carryForward);
			}
	
			 generalMap.put("userId", userId);
			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			 generalMap.put("currentDate", currentDate);
			}
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				String	currentTime = request.getParameter(CHANGED_TIME);
				 generalMap.put("currentTime", currentTime);
			}
		
			map = payrollMastersHandlerService.editReimbersement(generalMap);
			message = "Record Updated Successfully !!";
			
			try {
				map = payrollMastersHandlerService.showReimbersementJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
		String jsp = HR_REIMBERSEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView deleteReimbersement(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		String message="";
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		int reimbId=0;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			reimbId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		String changedBy = "";
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		Date currentDate = new Date(); 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("reimbId", reimbId);
		//generalMap.put("changedBy", changedBy);
		
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("userId", userId);
		map = payrollMastersHandlerService.deleteReimbersement(generalMap);
		String jsp = HR_REIMBERSEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchReimbersement(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String	reimbCode = "";
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
		   reimbCode = request.getParameter(CODE);
		}
		String	reimbDescription = "";
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			reimbDescription = request.getParameter(SEARCH_NAME);
		}
		int searchRadio=1;
		String searchField= "";
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;	
				}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(searchRadio==1){
			reimbCode=searchField;
			reimbDescription=null;

		}else{
			reimbCode=null;
			reimbDescription=searchField;
		}
		map = payrollMastersHandlerService.searchReimbersement(reimbCode,reimbDescription);
		String jsp = HR_REIMBERSEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search","search");
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showBonusJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollMastersHandlerService.showBonusJsp();
		String jsp = HR_BONUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView saveBonus(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		HrMasBonus hrMasBonus = new HrMasBonus();
		HttpSession session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute("hospitalId")!= null) {
			hospitalId = (Integer)session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasBonus.setHospital(masHospital);
		}
		String bonusCode = "";
		if (request.getParameter(CODE) != null) {
			bonusCode = request.getParameter(CODE);
		}
		hrMasBonus.setBonusCode(bonusCode);
		String bonusDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			bonusDescription = request.getParameter(SEARCH_NAME);
		}
		hrMasBonus.setDescription(bonusDescription);
		Date fromDate =new Date();
		if(request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))){
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
		}
		hrMasBonus.setFromDate(fromDate);
		Date toDate =new Date();
		if(request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))){
			toDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
		}
		hrMasBonus.setToDate(toDate);
		Date dueDate =new Date();
		if(request.getParameter(DUE_DATE) != null && !(request.getParameter(DUE_DATE).equals(""))){
			dueDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(DUE_DATE));
		}
		hrMasBonus.setDueDate(dueDate);
		
		String bonusType = "";
		if (request.getParameter(BONUS_TYPE) != null) {
			bonusType = request.getParameter(BONUS_TYPE);
			hrMasBonus.setBonusType(bonusType);
		}
		String paymentFrequency = "";
		if (request.getParameter(PAYMENT_FREQUENCY) != null) {
			paymentFrequency = request.getParameter(PAYMENT_FREQUENCY);
		}
		hrMasBonus.setPaymentFrequency(paymentFrequency);
		Float bonusRate =null;
		if (request.getParameter(BONUS_RATE)!= null && !request.getParameter(BONUS_RATE).equals("")) {
			bonusRate = Float.parseFloat(request.getParameter(BONUS_RATE));
			hrMasBonus.setBonusRate(bonusRate);
		}
		if (request.getParameter(FIXED_AMOUNT)!= null && !request.getParameter(FIXED_AMOUNT).equals("")) {
			BigDecimal fixedAmount = new BigDecimal(request.getParameter(FIXED_AMOUNT));
			hrMasBonus.setFixedAmount(fixedAmount);
		}
		if (request.getParameter(MAX_BASIC)!= null && !request.getParameter(MAX_BASIC).equals("")) {
			BigDecimal maxBasic = new BigDecimal(request.getParameter(MAX_BASIC));
			hrMasBonus.setMaxBasic(maxBasic);
		}
		if (request.getParameter(TAXABLE)!= null) {
			hrMasBonus.setTaxable("y");
		}else {
			hrMasBonus.setTaxable("n");
		}
			
		if(request.getParameter(GRADE_ID) != null && !(request.getParameter(GRADE_ID).equals("0"))) {
			int gradeId =Integer.parseInt(request.getParameter(GRADE_ID));
			MasGrade masGrade = new MasGrade();
			masGrade.setId(gradeId);
			hrMasBonus.setGrade(masGrade);
		}
			
		int userId=0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		if(userId !=0){
			Users users=new Users();
			users.setId(userId);
			hrMasBonus.setLastChgBy(users);
			}
		
		Date currentDate = null; 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		hrMasBonus.setLastChgDate(currentDate);
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		hrMasBonus.setStatus("y");
		hrMasBonus.setLastChgTime(currentTime);
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
		generalMap.put("code",bonusCode);
		generalMap.put("name",bonusDescription);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = payrollMastersHandlerService.checkForExistingMasters(generalMap);

		List codeList = new ArrayList();
		List nameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			codeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			nameList = (List) listMap.get("duplicateGeneralNameList");
		}
		
		if ((codeList.size() == 0 || codeList == null)&& (nameList.size() == 0 || nameList == null)) {
		

			map = payrollMastersHandlerService.saveBonus(hrMasBonus);
			message = "Record Added Successfully !!";
		
		}
		else if ((codeList.size() != 0 || codeList != null)	|| (nameList.size() != 0)|| nameList != null) 
		{
			if ((codeList.size() != 0 || codeList != null)&& nameList.size() == 0 || nameList == null) 
			{
				message = "Bonus Code  already exists.";
			} 
			else if ((nameList.size() != 0 || nameList != null)	&& (codeList.size() == 0 || codeList == null))
			{
				message = "Bonus Description already exists.";
			}
			else if ((codeList.size() != 0 || codeList != null)	&& (nameList.size() != 0 || nameList != null)) 
			{

				message = "Bonus Code and Bonus Description already exist.";
			}
		}
		try {
			map = payrollMastersHandlerService.showBonusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		String jsp = HR_BONUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView editBonus(HttpServletRequest request ,HttpServletResponse response) {
		Map<String,Object> map =new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		int bonusId = 0;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			bonusId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		String bonusCode = "";
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			bonusCode = request.getParameter(CODE);
		}
		String bonusDescription = "";
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			bonusDescription = request.getParameter(SEARCH_NAME);
		}
		Date fromDate =new Date();
		if(request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))){
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
		}
		
		Date toDate =new Date();
		if(request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))){
			toDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
		}
		
		Date dueDate =new Date();
		if(request.getParameter(DUE_DATE) != null && !(request.getParameter(DUE_DATE).equals(""))){
			dueDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(DUE_DATE));
		}
		String bonusType = "";
		if (request.getParameter(BONUS_TYPE)!= null) {
			bonusType = request.getParameter(BONUS_TYPE);
		}
		String paymentFrequency = "";
		if (request.getParameter(PAYMENT_FREQUENCY) != null) {
			paymentFrequency = request.getParameter(PAYMENT_FREQUENCY);
		}
		Float bonusRate =null;
		if (request.getParameter(BONUS_RATE)!= null && !request.getParameter(BONUS_RATE).equals("")) {
			bonusRate = Float.parseFloat(request.getParameter(BONUS_RATE));
		}
		
		BigDecimal fixedAmount = null;
		if (request.getParameter(FIXED_AMOUNT)!= null && !request.getParameter(FIXED_AMOUNT).equals("")) {
			fixedAmount = new BigDecimal(request.getParameter(FIXED_AMOUNT));
		}
		BigDecimal maxBasic = null;
		if (request.getParameter(MAX_BASIC)!= null && !request.getParameter(MAX_BASIC).equals("")) {
			maxBasic = new BigDecimal(request.getParameter(MAX_BASIC));
		}
		String taxable = "";
		if (request.getParameter(TAXABLE)!= null) {
			taxable = "y";
		}else {
			taxable = "n";
		}
		int gradeId = 0;
		
		if (request.getParameter(GRADE_ID)!= null && !request.getParameter(GRADE_ID).equals("0")) {
			gradeId = Integer.parseInt(request.getParameter(GRADE_ID));
	 	}
		String changedBy ="";
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		Date currentDate = null; 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("bonusId", bonusId);
		generalMap.put("bonusCode", bonusCode);
		generalMap.put("bonusDescription", bonusDescription);
		generalMap.put("fromDate", fromDate);
		generalMap.put("toDate", toDate);
		generalMap.put("dueDate", dueDate);
		generalMap.put("bonusType", bonusType);
		generalMap.put("paymentFrequency", paymentFrequency);
		generalMap.put("bonusRate", bonusRate);
		generalMap.put("fixedAmount", fixedAmount);
		generalMap.put("gradeId", gradeId);
		generalMap.put("maxBasic", maxBasic);
		generalMap.put("taxable", taxable);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("userId", userId);
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		
		map = payrollMastersHandlerService.editBonus(generalMap);
		message = "Record Updated Successfully !!";

		try {
			map = payrollMastersHandlerService.showBonusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String jsp = HR_BONUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView deleteBonus(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");

		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		int bonusId=0;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			bonusId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		Date currentDate = new Date(); 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("bonusId", bonusId);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		map = payrollMastersHandlerService.deleteBonus(generalMap);
		String jsp = HR_BONUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchBonus(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String bonusCode = "";
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			bonusCode = request.getParameter(CODE);
		}
		String bonusDescription = "";
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			bonusDescription = request.getParameter(SEARCH_NAME);
		}
		int searchRadio=1;
		String searchField= "";
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;	
				}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(searchRadio==1){
			bonusCode=searchField;
			bonusDescription=null;

		}else{
			bonusCode=null;
			bonusDescription=searchField;
		}
		map = payrollMastersHandlerService.searchBonus(bonusCode,bonusDescription);
		String jsp = HR_BONUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search","search");
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showIncomeTaxExemptJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map =new HashMap<String, Object>();
		map = payrollMastersHandlerService.showIncomeTaxExemptJsp();
		String jsp="hr_incomeTaxExemption";
		jsp += ".jsp";
		String title = "Income Tax Exemption";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView searchIncomeTaxExemptJsp(HttpServletRequest request,HttpServletResponse response)
	{
		String searchField="";
		
		try {
			if(request.getParameter(SEARCH_FIELD) !=null && !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField =request.getParameter(SEARCH_FIELD);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> map1= payrollMastersHandlerService.showIncomeTaxExemptJsp();
		
		
		map =payrollMastersHandlerService.searchIncomeTaxExemptMaster(searchField);
		map1.putAll(map);
		String jsp="hr_incomeTaxExemption";
		jsp += ".jsp";
		title ="Income Tax Exemption";
		map.put("financialYear", searchField);
		
		
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

		map =payrollMastersHandlerService.copyIncomeTaxExemptMaster(copyFromYear, copyToYear);
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
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String minAmt="";
		String maxAmt="";
		String exemptionBase="";
		String exemptionPercent="";
		String maxExemption="";
		String secDesc="";
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
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
			exemptionPercent =request.getParameter("exemptionPercent").trim();
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
	
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);



		listMap = payrollMastersHandlerService.existingIncomeTaxExemptJsp(generalMap);
		
		
		List incomeTaxExempTypeList = new ArrayList();
		

		if(listMap.get("incomeTaxExempTypeList") != null){
			incomeTaxExempTypeList = (List)listMap.get("incomeTaxExempTypeList");
		}
	
		boolean successfullyAdded = false;

		if(incomeTaxExempTypeList.size() == 0 || incomeTaxExempTypeList == null)
		{
			hrMasItaxExemption.setSectionCode(code);
			MasStoreFinancial financialYear = new MasStoreFinancial();
			financialYear.setId(new Integer(name));
			hrMasItaxExemption.setFinancialYear(financialYear);
			hrMasItaxExemption.setMinimumAmt((new BigDecimal(minAmt)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
			hrMasItaxExemption.setMaximumAmt((new BigDecimal(maxAmt)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
			hrMasItaxExemption.setExemptionBase(exemptionBase);
			hrMasItaxExemption.setExemptionPercentage((new BigDecimal(exemptionPercent)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
			hrMasItaxExemption.setMaxExemption((new BigDecimal(maxExemption)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
			hrMasItaxExemption.setStatus("y");
			/*System.out.println("(new BigDecimal(minAmt)).setScale(2, BigDecimal.ROUND_HALF_EVEN)"+(new BigDecimal(minAmt)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
			System.out.println("(new BigDecimal(maxAmt)).setScale(2, BigDecimal.ROUND_HALF_EVEN)"+(new BigDecimal(maxAmt)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
			System.out.println("(new BigDecimal(exemptionPercent)).setScale(2, BigDecimal.ROUND_HALF_EVEN)"+(new BigDecimal(exemptionPercent)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
			System.out.println("(new BigDecimal(maxExemption)).setScale(2, BigDecimal.ROUND_HALF_EVEN)"+(new BigDecimal(maxExemption)).setScale(2, BigDecimal.ROUND_HALF_EVEN));*/
			
			
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				hrMasItaxExemption.setLastChgBy(users);
				}
			
			hrMasItaxExemption.setLastChgDate(currentDate);
			hrMasItaxExemption.setLastChgTime(currentTime);
			hrMasItaxExemption.setSectionDesc(secDesc);
			successfullyAdded = payrollMastersHandlerService.addIncomeTaxExemptMaster(hrMasItaxExemption);		

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}else{
			message = "Section Code and Financial year already exist.";
		}

		try{
			map = payrollMastersHandlerService.showIncomeTaxExemptJsp();
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
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		
		String minAmt="";
		String maxAmt="";
		String exemptionBase="";
		String exemptionPercent="";
		String maxExemption="";
		String secDesc="";
		int id=0;
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
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
	
		
		generalMap.put("id",id);
		generalMap.put("code", code);
		generalMap.put("secDesc", secDesc);
		generalMap.put("name", name);
		generalMap.put("minAmt", minAmt);
		generalMap.put("maxAmt", maxAmt);
		generalMap.put("userId", userId);
		generalMap.put("exemptionBase", exemptionBase);
		generalMap.put("exemptionPercent", exemptionPercent);
		generalMap.put("maxExemption", maxExemption);
		generalMap.put("currentTime", currentTime);
		generalMap.put("currentDate", currentDate);
		generalMap.put("flag", true);
		boolean dataUpdated=false;
	
		
		dataUpdated=payrollMastersHandlerService.editIncomeTaxExemptMaster(generalMap);
		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
		
		try{
			map = payrollMastersHandlerService.showIncomeTaxExemptJsp();
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
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		int id=0;
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
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
		
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=payrollMastersHandlerService.deleteIncomeTaxExemptMaster(id,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		try{
			map = payrollMastersHandlerService.showIncomeTaxExemptJsp();
		   
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
	public ModelAndView showIncomeTaxSurchargeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map =new HashMap<String, Object>();
		map = payrollMastersHandlerService.showIncomeTaxSurchargeJsp();
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
		map =payrollMastersHandlerService.copyIncomeTaxSurchargeJsp(copyFromYear, copyToYear);
		String jsp="hr_incomeTaxSurcharge";
		jsp += ".jsp";
		title = "Section Investment";
		
		
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

		Map<String, Object> map1= payrollMastersHandlerService.showIncomeTaxSurchargeJsp();
		
		
		map =payrollMastersHandlerService.searchIncomeTaxSurchargeJsp(searchField);
		map1.putAll(map);
		String jsp="hr_incomeTaxSurcharge";
		jsp += ".jsp";
		title ="Income Tax Surcharge";
		map.put("financialYear", searchField);
		
		
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

		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date fromDate=null;
		Date toDate=null;
		String surchargeCode="";
		String lowerLimit="";
		String upperLimit="";
		BigDecimal minTaxableSal = null;
		BigDecimal perOne= null;
		BigDecimal perTwo= null;
		String surchargeBase="";
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
	
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
			perOne =new BigDecimal(request.getParameter("perOne"));
		}
		if(request.getParameter("perTwo") !=null && !(request.getParameter("perTwo").equals(""))) {
			perTwo =new BigDecimal(request.getParameter("perTwo"));
		}
		
		if(request.getParameter("surchargeBase") !=null && !(request.getParameter("surchargeBase").equals(""))) {
			surchargeBase =request.getParameter("surchargeBase");
		}
		
		
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
			
		}
	
		generalMap.put("code", surchargeCode);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		listMap = payrollMastersHandlerService.exitistingIncomeTaxSurchargeJsp(generalMap);

		List financialsurChargeTypeCodeList = new ArrayList();
	

		if(listMap.get("financialsurChargeTypeCodeList")!= null){
			financialsurChargeTypeCodeList = (List)listMap.get("financialsurChargeTypeCodeList");
		}
		boolean successfullyAdded = false;
		System.out.println(name);
		System.out.println(surchargeCode);
		System.out.println(financialsurChargeTypeCodeList.size());
		if(financialsurChargeTypeCodeList.size()==0)
		{
			HrMasSurcharge hrMasSurcharge = new HrMasSurcharge();
			hrMasSurcharge.setId(new Integer(surchargeCode));
			hrMasItaxSurcharge.setHrMasSurcharge(hrMasSurcharge);
			
				
			MasStoreFinancial financialYear = new MasStoreFinancial();
			financialYear.setId(new Integer(name));
			hrMasItaxSurcharge.setFinancialYear(financialYear);
			hrMasItaxSurcharge.setLowerLimit(new BigDecimal(lowerLimit));
			hrMasItaxSurcharge.setUpperLimit(new BigDecimal(upperLimit));
			hrMasItaxSurcharge.setMinTaxSal(minTaxableSal);
			hrMasItaxSurcharge.setPercentOne(perOne);
			hrMasItaxSurcharge.setPercentTwo(perTwo);
			hrMasItaxSurcharge.setSurchargeBase(surchargeBase);
			hrMasItaxSurcharge.setStatus("y");
			
			if(userId !=0){
				Users users=new Users();
				users.setId(userId);
				hrMasItaxSurcharge.setLastChgBy(users);
				}
			hrMasItaxSurcharge.setLastChgDate(currentDate);
			hrMasItaxSurcharge.setLastChgTime(currentTime);
			
			successfullyAdded = payrollMastersHandlerService.addIncomeTaxSurchargeJsp(hrMasItaxSurcharge);		

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}else{
			message = "Sub Charge Type and Financial year already exist.";
		}
	
		try{
			map = payrollMastersHandlerService.showIncomeTaxSurchargeJsp();
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

		//String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date fromDate=null;
		Date toDate=null;
		String surchargeCode="";
		String lowerLimit="";
		String upperLimit="";
		BigDecimal minTaxSal = new BigDecimal(0);
		BigDecimal perOne = new BigDecimal(0);
		BigDecimal perTwo = new BigDecimal(0);
		String surchargeBase="";
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		int id=0;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			id =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		
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
		if(request.getParameter("minTaxSal") !=null && !(request.getParameter("minTaxSal").equals("")) ) {
			minTaxSal =new BigDecimal(request.getParameter("minTaxSal"));
		}
		if(request.getParameter("perOne") !=null && !(request.getParameter("perOne").equals("")) ) {
			perOne =new BigDecimal(request.getParameter("perOne"));
		}
		if(request.getParameter("perTwo") !=null && !(request.getParameter("perTwo").equals("")) ) {
			perTwo =new BigDecimal(request.getParameter("perTwo"));
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
		
		System.out.println("yest"+name);
		generalMap.put("id",id);
		generalMap.put("code", surchargeCode);
		generalMap.put("name", name);
		generalMap.put("lowerLimit", lowerLimit);
		generalMap.put("upperLimit", upperLimit);
		generalMap.put("perOne", perOne);
		generalMap.put("perTwo", perTwo);
		generalMap.put("surchargeBase", surchargeBase);
		generalMap.put("minTaxSal", minTaxSal);
		generalMap.put("userId", userId);
		generalMap.put("currentTime", currentTime);
		generalMap.put("currentDate", currentDate);
		generalMap.put("flag", true);
		
		listMap = payrollMastersHandlerService.exitistingIncomeTaxSurchargeJsp(generalMap);
		boolean dataUpdated=false;
		
		dataUpdated=payrollMastersHandlerService.editIncomeTaxSurchargeJsp(generalMap);
		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
		
		try{
			map = payrollMastersHandlerService.showIncomeTaxSurchargeJsp();
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
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		int id=0;
		int userId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
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
		
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
		
		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("userId", userId);
		boolean dataDeleted=false;
		dataDeleted=payrollMastersHandlerService.deleteIncomeTaxSurchargeJsp(id,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		
		try{
			map = payrollMastersHandlerService.showIncomeTaxSurchargeJsp();
		   
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
}
