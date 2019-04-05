
package jkt.hms.payroll.controller;

import static jkt.hms.util.RequestConstants.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hms.masters.business.HrAdvance;
import jkt.hms.masters.business.HrAdvanceDetail;
import jkt.hms.masters.business.HrArrear;
import jkt.hms.masters.business.HrArrearSalary;
import jkt.hms.masters.business.HrBonusDetail;
import jkt.hms.masters.business.HrLoanDetail;
import jkt.hms.masters.business.HrLoanHeader;
import jkt.hms.masters.business.HrMasBonus;
import jkt.hms.masters.business.HrMasLoan;
import jkt.hms.masters.business.HrMasPayElement;
import jkt.hms.masters.business.HrMasReimbersement;
import jkt.hms.masters.business.HrReimbDetail;
import jkt.hms.masters.business.HrReimbHeader;
import jkt.hms.payroll.handler.LoanHandlerService;
import jkt.hms.util.RequestConstants;

import org.apache.tools.ant.taskdefs.condition.Http;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class LoanController extends MultiActionController {
	LoanHandlerService loanHandlerService = null;

	public LoanHandlerService getLoanHandlerService() {
		return loanHandlerService;
	}

	public void setLoanHandlerService(LoanHandlerService loanHandlerService) {
		this.loanHandlerService = loanHandlerService;
	}
	
	public ModelAndView showLoanHeaderJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		HttpSession sess = request.getSession();
		int centreId=0;
		if(sess.getAttribute("locationId") != null){
			centreId =(Integer)sess.getAttribute("locationId");
			
		}
		detailMap.put("centreId", centreId);
		map = loanHandlerService.showLoanHeaderJsp(detailMap);
		String jsp = HR_LOAN_HEADER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView saveLoanHeader(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HrLoanHeader hrLoanHeader = new HrLoanHeader();
		HrLoanDetail hrLoanDetail = new HrLoanDetail();
		HttpSession session = request.getSession();
		
		if (request.getParameter(EMPLOYEE_ID)!= null) {
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			hrLoanHeader.setEmployee(masEmployee);
		}
		 
		if (request.getParameter(LOAN_ID)!= null) {
			int loanId = Integer.parseInt(request.getParameter(LOAN_ID));
			HrMasLoan hrMasLoan = new HrMasLoan();
			hrMasLoan.setId(loanId);
			hrLoanHeader.setLoan(hrMasLoan); 
		}
		if (request.getParameter(LOAN_DATE)!= null) {
			Date  loanDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(LOAN_DATE)); 
			hrLoanHeader.setLoanDate(loanDate);
		}
		if (request.getParameter(LOAN_PERIOD)!= null) {
			int loanPeriod = Integer.parseInt(request.getParameter(LOAN_PERIOD));
			hrLoanHeader.setLoanPeriod(loanPeriod);
		}
		if (request.getParameter(LOAN_P_AMOUNT)!= null) {
			BigDecimal loanPAmount = new BigDecimal(request.getParameter(LOAN_P_AMOUNT));
			hrLoanHeader.setLoanPAmount(loanPAmount);
		}
		if (request.getParameter(LOAN_INTEREST )!= null  && !(request.getParameter(LOAN_INTEREST).equals(""))) {
			Float loanInterest = Float.parseFloat(request.getParameter(LOAN_INTEREST));
			hrLoanHeader.setLoanInterest(loanInterest);
		}
		BigDecimal loanCAmount = null;
		if (request.getParameter(COMPOUND_AMOUNT)!= null) {
			 loanCAmount = new BigDecimal(request.getParameter(COMPOUND_AMOUNT));
			hrLoanHeader.setLoanCAmount(loanCAmount);
		}
		if (request.getParameter(INTEREST_DATE )!= null) {
			Date interestDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(INTEREST_DATE));
			hrLoanHeader.setLoanInterestDate(interestDate);
		}
		if (request.getParameter(MONTHLY_INSTALLMENT)!= null) {
			BigDecimal monthlyInstallment = new BigDecimal(request.getParameter(MONTHLY_INSTALLMENT));
			hrLoanHeader.setMonthlyInstall(monthlyInstallment);
		}
		if (request.getParameter(LAST_PAYMENT_DATE)!= null && !(request.getParameter(LAST_PAYMENT_DATE).equals(""))) {
			Date  lastPaymentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(LAST_PAYMENT_DATE)); 
			hrLoanHeader.setLastPaymentDate(lastPaymentDate);
		}
		if (request.getParameter(BALANCE_LOAN)!= null && !(request.getParameter(BALANCE_LOAN).equals(""))) {
			BigDecimal balanceCLoan = new BigDecimal(request.getParameter(BALANCE_LOAN));
			hrLoanHeader.setBalanceLoan(loanCAmount);
		}
		if (request.getParameter(LOAN_STATUS)!= null) {
			String loanStatus = request.getParameter(LOAN_STATUS);
			hrLoanHeader.setLoanStatus(loanStatus);
		}
		if (request.getParameter(DEDUCT_FROM)!= null) {
			String deductFrom = request.getParameter(DEDUCT_FROM);
			hrLoanHeader.setDeductFrom(deductFrom);
		}
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			hrLoanHeader.setLastChgBy(user);
		}
		
		
		Date currentDate = new Date(); 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		hrLoanHeader.setLastChgDate(currentDate);
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		hrLoanHeader.setLastChgTime(currentTime);
		hrLoanHeader.setStatus("y");		
		map = loanHandlerService.saveLoanHeader(hrLoanHeader);
		
		String jsp = HR_LOAN_HEADER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView updateLoanHeader(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (request.getParameter(COMMON_ID)!= null) {
			int loanheaderId = Integer.parseInt(request.getParameter(COMMON_ID));
			generalMap.put("loanheaderId", loanheaderId);
		}
		if (request.getParameter(EMPLOYEE_ID)!= null) {
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("employeeId", employeeId);
		}
		
		if (request.getParameter(LOAN_ID)!= null) {
			int loanId = Integer.parseInt(request.getParameter(LOAN_ID));
			generalMap.put("loanId", loanId);
		}
		if (request.getParameter(LOAN_DATE)!= null) {
			Date  loanDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(LOAN_DATE)); 
			generalMap.put("loanDate", loanDate);
		}
		if (request.getParameter(LOAN_PERIOD)!= null) {
			int loanPeriod = Integer.parseInt(request.getParameter(LOAN_PERIOD));
			generalMap.put("loanPeriod", loanPeriod);
		}
		if (request.getParameter(LOAN_P_AMOUNT)!= null) {
			BigDecimal loanPAmount = new BigDecimal(request.getParameter(LOAN_P_AMOUNT));
			generalMap.put("loanPAmount", loanPAmount);
		}
		if (request.getParameter(LOAN_INTEREST)!= null) {
			Float loanInterest = Float.parseFloat(request.getParameter(LOAN_INTEREST));
			generalMap.put("loanInterest", loanInterest);
		}
		if (request.getParameter(COMPOUND_AMOUNT)!= null) {
			BigDecimal loanCAmount = new BigDecimal(request.getParameter(COMPOUND_AMOUNT));
			generalMap.put("loanCAmount", loanCAmount);
		}
		if (request.getParameter(INTEREST_DATE )!= null) {
			Date interestDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(INTEREST_DATE));
			generalMap.put("interestDate", interestDate);
		}
		if (request.getParameter(MONTHLY_INSTALLMENT)!= null) {
			BigDecimal monthlyInstallment = new BigDecimal(request.getParameter(MONTHLY_INSTALLMENT));
			generalMap.put("monthlyInstallment", monthlyInstallment);
		}
		if (request.getParameter(LAST_PAYMENT_DATE)!= null && !(request.getParameter(LAST_PAYMENT_DATE).equals(""))) {
			Date  lastPaymentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(LAST_PAYMENT_DATE));
			generalMap.put("lastPaymentDate", lastPaymentDate);
		}
		if (request.getParameter(BALANCE_LOAN)!= null) {
			BigDecimal balanceCLoan = new BigDecimal(request.getParameter(BALANCE_LOAN));
			generalMap.put("balanceCLoan", balanceCLoan);
		}
		
		if (request.getParameter(LOAN_STATUS)!= null) {
			String loanStatus = request.getParameter(LOAN_STATUS);
			generalMap.put("loanStatus", loanStatus);
		}
		if (request.getParameter(DEDUCT_FROM)!= null) {
			String deductFrom = request.getParameter(DEDUCT_FROM);
			generalMap.put("deductFrom", deductFrom);
		}
		
				
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			generalMap.put("changedBy", user);
		}
		
		Date currentDate = new Date(); 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = loanHandlerService.updateLoanHeader(generalMap);
		String jsp = HR_LOAN_HEADER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showLoanDetailJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String ,Object> map = new HashMap<String, Object>();
		map = loanHandlerService.showLoanDetailJsp();
		String jsp = HR_LOAN_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView saveLoanDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HrLoanDetail hrLoanDetail = new HrLoanDetail();
		HttpSession session = request.getSession();
		int loanHeaderId = 0;
		if (request.getParameter(LOAN_HEADER_ID)!= null) {
			loanHeaderId	= Integer.parseInt(request.getParameter(LOAN_HEADER_ID));
			HrLoanHeader hrLoanHeader = new HrLoanHeader();
			hrLoanHeader.setId(loanHeaderId);
			hrLoanDetail.setLoanHeader(hrLoanHeader);
		}
		BigDecimal balLoan = null;
		
		if (request.getParameter(BALANCE_LOAN)!= null) {
			balLoan =new BigDecimal(request.getParameter(BALANCE_LOAN));
		}
		
		BigDecimal installAmount = null;
		if (request.getParameter(INSTALLMENT_AMOUNT)!= null) {
			installAmount =new BigDecimal(request.getParameter(INSTALLMENT_AMOUNT));
			hrLoanDetail.setInstallAmount(installAmount);
		}
		BigDecimal balanceCLoan = null;
			balanceCLoan = balLoan.subtract(installAmount);
			hrLoanDetail.setBalanceLoan(balanceCLoan);
			
		if (request.getParameter(INSTALLMENT_DATE)!= null) {
			   Date	installmentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(INSTALLMENT_DATE));
			   hrLoanDetail.setInstallDate(installmentDate);
			}
		if (request.getParameter(PRINCIPAL_PAID)!= null) {
			BigDecimal principalPaid =new BigDecimal(request.getParameter(PRINCIPAL_PAID));
			hrLoanDetail.setPPaid(principalPaid);
		}
		
		if (request.getParameter(INTEREST_PAID)!= null) {
			BigDecimal interestPaid =new BigDecimal(request.getParameter(INTEREST_PAID));
			hrLoanDetail.setInterestPaid(interestPaid);
		}
		
		if (request.getParameter(REMARK)!= null) {
			String remark = request.getParameter(REMARK);
			hrLoanDetail.setRemark(remark);
		}
	
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			hrLoanDetail.setLastChgBy(user);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 hrLoanDetail.setLastChgDate(currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 hrLoanDetail.setLastChgTime(currentTime);
		}
		hrLoanDetail.setStatus("y");
		
		map = loanHandlerService.saveLoanDetail(hrLoanDetail);
		
		String jsp = HR_LOAN_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getLoanDetailFromAjax(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int loanHeaderId = 0;
		if (request.getParameter(LOAN_HEADER_ID)!= null) {
			 loanHeaderId = Integer.parseInt(request.getParameter(LOAN_HEADER_ID));
		}
		map = loanHandlerService.getLoanDetailFromAjax(loanHeaderId);
		return new ModelAndView("responseForBalanceLoan", "map", map);
	}
	
	public ModelAndView editLoanDetail(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		if (request.getParameter(COMMON_ID)!= null) {
			int loandetailId = Integer.parseInt(request.getParameter(COMMON_ID));
			generalMap.put("loandetailId", loandetailId);
		}
		if (request.getParameter("hiddenEmp")!= null) {
			int loanHeaderId = Integer.parseInt(request.getParameter("hiddenEmp"));
			generalMap.put("loanHeaderId", loanHeaderId);
		}
		if (request.getParameter(BALANCE_LOAN)!= null) {
			BigDecimal balanceLoan = new BigDecimal(request.getParameter(BALANCE_LOAN));
			generalMap.put("balanceLoan", balanceLoan);
		}
		if (request.getParameter(INSTALLMENT_DATE)!= null) {
			Date installDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(INSTALLMENT_DATE));
			generalMap.put("installDate", installDate);
		}
		if (request.getParameter(INSTALLMENT_AMOUNT)!= null) {
			BigDecimal installAmount = new BigDecimal(request.getParameter(INSTALLMENT_AMOUNT));
			generalMap.put("installAmount", installAmount);
		}
		if (request.getParameter(INTEREST_PAID)!= null) {
			BigDecimal interestPaid = new BigDecimal(request.getParameter(INTEREST_PAID));
			generalMap.put("interestPaid", interestPaid);
		}
		if (request.getParameter(PRINCIPAL_PAID)!= null) {
			BigDecimal prinPaid = new BigDecimal(request.getParameter(PRINCIPAL_PAID));
			generalMap.put("prinPaid", prinPaid);
		}
		if (request.getParameter(REMARK)!= null) {
			String remark  = request.getParameter(REMARK);
			generalMap.put("remark", remark);
		}
		
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			generalMap.put("changedBy", user);
		}
		
		Date currentDate = new Date(); 
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}
		String currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = loanHandlerService.editLoanDetail(generalMap);
		String jsp = HR_LOAN_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showReimbHeaderJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		
		Map<String, Object> detailMap = new HashMap<String, Object>();
		HttpSession sess = request.getSession();
		int centreId=0;
		if(sess.getAttribute("locationId") != null){
			centreId =(Integer)sess.getAttribute("locationId");
			
		}
		detailMap.put("centreId", centreId);
		
		map = loanHandlerService.showReimbHeaderJsp(detailMap);
		String jsp = HR_REIMB_HEADER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView saveReimbHeader(HttpServletRequest request ,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		HrReimbHeader hrReimbHeader = new HrReimbHeader();
		
		HttpSession session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute("locationId")!= null) {
			hospitalId = (Integer)session.getAttribute("locationId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrReimbHeader.setHospital(masHospital);
			
		}
		
		if (request.getParameter(FROM_DATE)!= null) {
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			hrReimbHeader.setFromDate(fromDate);
		}
		if (request.getParameter(TO_DATE)!= null) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			hrReimbHeader.setToDate(toDate);
		}
		if (request.getParameter(EMPLOYEE_ID)!= null) {
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			hrReimbHeader.setEmployee(masEmployee);
		}
		if (request.getParameter(PAY_MODE)!= null) {
			String payMode = request.getParameter(PAY_MODE);
			hrReimbHeader.setPaymode(payMode);
		}
		if (request.getParameter(REIMBERSEMENT_ID)!= null) {
			int reimbId = Integer.parseInt(request.getParameter(REIMBERSEMENT_ID));
			HrMasReimbersement hrMasReimbersement = new HrMasReimbersement();
			hrMasReimbersement.setId(reimbId);
			hrReimbHeader.setReimb(hrMasReimbersement);
		}
		if (request.getParameter(REMARK)!= null) {
			String  remark = request.getParameter(REMARK);
			hrReimbHeader.setRemark(remark);
		}
		if (request.getParameter(MAXIMUM_AMOUNT)!= null) {
			BigDecimal maxAmount = new BigDecimal(request.getParameter(MAXIMUM_AMOUNT));
			hrReimbHeader.setMaxAmount(maxAmount);
		}
		if (request.getParameter(TOTAL_REIMB_AMOUNT)!= null) {
			BigDecimal totalReimbAmount = new BigDecimal(request.getParameter(TOTAL_REIMB_AMOUNT));
			hrReimbHeader.setTotalReimbAmt(totalReimbAmount);
		}
		if (request.getParameter(REIMB_STATUS)!= null) {
			String reimbStatus = request.getParameter(REIMB_STATUS);
			hrReimbHeader.setReimbStatus(reimbStatus);
		}
		
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			hrReimbHeader.setLastChgBy(user);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 hrReimbHeader.setLastChgDate(currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 hrReimbHeader.setLastChgTime(currentTime);
		}
		hrReimbHeader.setStatus("y");	
		map = loanHandlerService.saveReimbHeader(hrReimbHeader);
		String jsp = HR_REIMB_HEADER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateReimbHeader(HttpServletRequest request ,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (request.getParameter(REIMB_HEADER_ID)!= null) {
			int reimbHeaderId = Integer.parseInt(request.getParameter(REIMB_HEADER_ID));
			generalMap.put("reimbHeaderId", reimbHeaderId);
		}
		
		if (request.getParameter(FROM_DATE)!= null) {
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			generalMap.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE)!= null) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			generalMap.put("toDate", toDate);
		}
		if (request.getParameter(EMPLOYEE_ID)!= null) {
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("employeeId", employeeId);
		}
		if (request.getParameter(PAY_MODE)!= null) {
			String payMode = request.getParameter(PAY_MODE);
			generalMap.put("payMode", payMode);
		}
		if (request.getParameter(REIMBERSEMENT_ID)!= null) {
			int reimbId = Integer.parseInt(request.getParameter(REIMBERSEMENT_ID));
			generalMap.put("reimbId", reimbId);
		}
		if (request.getParameter(REMARK)!= null) {
			String remark = request.getParameter(REMARK);
			generalMap.put("remark", remark);
		}
		if (request.getParameter(MAXIMUM_AMOUNT)!= null) {
			BigDecimal maxAmount = new BigDecimal(request.getParameter(MAXIMUM_AMOUNT));
			generalMap.put("maxAmount", maxAmount);
		}
		if (request.getParameter(TOTAL_REIMB_AMOUNT)!= null) {
			BigDecimal totalReimbAmount = new BigDecimal(request.getParameter(TOTAL_REIMB_AMOUNT));
			generalMap.put("totalReimbAmount", totalReimbAmount);
		}
		if (request.getParameter(REIMB_STATUS)!= null) {
			String reimbStatus = request.getParameter(REIMB_STATUS);
			generalMap.put("reimbStatus", reimbStatus);
		}
		
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			generalMap.put("changedBy", user);
		}
		
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 generalMap.put("currentDate", currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 generalMap.put("currentTime", currentTime);
		}	
		map = loanHandlerService.updateReimbHeader(generalMap);
		String jsp = HR_REIMB_HEADER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showReimbDetailJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		HttpSession sess = request.getSession();
		int centreId=0;
		if(sess.getAttribute("hospitalId") != null){
			centreId =(Integer)sess.getAttribute("hospitalId");
			
		}
		detailMap.put("centreId", centreId);
		
		map = loanHandlerService.showReimbDetailJsp(detailMap);
		String jsp = HR_REIMB_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveReimbDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object>generalMap = new HashMap<String, Object>();
		HrReimbDetail hrReimbDetail = new HrReimbDetail();
		
		HttpSession session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute("hospitalId")!= null) {
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		if (request.getParameter(REIMB_HEADER_ID)!= null) {
			int reimbHeaderId = Integer.parseInt(request.getParameter(REIMB_HEADER_ID));
			HrReimbHeader hrReimbHeader = new HrReimbHeader();
			hrReimbHeader.setId(reimbHeaderId);
			hrReimbDetail.setReimbHeader(hrReimbHeader);
		}
		int reimbId =0;
		if (request.getParameter(REIMBERSEMENT_ID)!= null && !(request.getParameter(REIMBERSEMENT_ID).equals(""))) {
		    reimbId = Integer.parseInt(request.getParameter(REIMBERSEMENT_ID));
		}
		if (request.getParameter(CLAIM_DATE)!= null) {
			Date claimDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CLAIM_DATE));
			hrReimbDetail.setClaimDate(claimDate);
		}
		if (request.getParameter(CLAIM_AMOUNT)!= null) {
			BigDecimal claimAmount = new BigDecimal(request.getParameter(CLAIM_AMOUNT));
			hrReimbDetail.setClaimAmount(claimAmount);
		}
		if (request.getParameter(PAID)!= null) {
			hrReimbDetail.setPaid("y");
		}else{
			hrReimbDetail.setPaid("n");
		}
		
		if (request.getParameter(REIMB_DATE)!= null) {
			Date reimbDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(REIMB_DATE));
			hrReimbDetail.setReimbDate(reimbDate);
		}
		if (request.getParameter(REIMB_AMOUNT)!= null) {
			BigDecimal reimbAmount = new BigDecimal(request.getParameter(REIMB_AMOUNT));
			hrReimbDetail.setReimbAmount(reimbAmount);
		}
		if (request.getParameter(REMARK)!= null) {
			String remark = request.getParameter(REMARK);
			hrReimbDetail.setRemarks(remark);
		}
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			hrReimbDetail.setLastChgBy(user);
		}
		
		
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 hrReimbDetail.setLastChgDate(currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 hrReimbDetail.setLastChgTime(currentTime);
		}
		hrReimbDetail.setStatus("y");	
		generalMap.put("reimbId", reimbId);
		generalMap.put("hrReimbDetail", hrReimbDetail);
		generalMap.put("hospitalId", hospitalId);
		map = loanHandlerService.saveReimbDetail(generalMap);
		String jsp = HR_REIMB_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateReimbDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (request.getParameter(REIMB_DETAIL_ID)!= null) {
			int reimbDetailId = Integer.parseInt(request.getParameter(REIMB_DETAIL_ID));
			generalMap.put("reimbDetailId", reimbDetailId);
		}
		if (request.getParameter(REIMB_HEADER_ID)!= null) {
			int reimbHeaderId = Integer.parseInt(request.getParameter(REIMB_HEADER_ID));
			generalMap.put("reimbHeaderId", reimbHeaderId);
		}
		if (request.getParameter(CLAIM_DATE)!= null) {
			Date claimDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CLAIM_DATE));
			generalMap.put("claimDate", claimDate);
		}
		if (request.getParameter(CLAIM_AMOUNT)!= null) {
			BigDecimal claimAmount = new BigDecimal(request.getParameter(CLAIM_AMOUNT));
			generalMap.put("claimAmount", claimAmount);
		}
		
		if (request.getParameter(PAID)!= null) {
			String paid = "y";
			generalMap.put("paid", paid);
		}else{
			String paid = "n";
			generalMap.put("paid", paid);
		}
		
		if (request.getParameter(REIMB_DATE)!= null) {
			Date reimbDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(REIMB_DATE));
			generalMap.put("reimbDate", reimbDate);
		}
		if (request.getParameter(REIMB_AMOUNT)!= null) {
			BigDecimal reimbAmount = new BigDecimal(request.getParameter(REIMB_AMOUNT));
			generalMap.put("reimbAmount", reimbAmount);
		}
		if (request.getParameter(REMARK)!= null) {
			String remark = request.getParameter(REMARK);
			generalMap.put("remark", remark);
		}
		
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			generalMap.put("changedBy", user);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 generalMap.put("currentDate", currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 generalMap.put("currentTime", currentTime);
		}
		map = loanHandlerService.updateReimbDetail(generalMap);
		String jsp = HR_REIMB_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showBonusDetailJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		HttpSession sess = request.getSession();
		int centreId=0;
		if(sess.getAttribute("hospitalId") != null){
			centreId =(Integer)sess.getAttribute("hospitalId");
			
		}
		detailMap.put("centreId", centreId);
		map = loanHandlerService.showBonusDetailJsp(detailMap);
		String jsp = HR_BONUS_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveBonusDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrBonusDetail hrBonusDetail = new HrBonusDetail();
		
		HttpSession session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute("locationId")!= null) {
			hospitalId = (Integer)session.getAttribute("locationId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrBonusDetail.setHospital(masHospital);
		}
		
		if (request.getParameter(EMPLOYEE_ID)!= null) {
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			hrBonusDetail.setEmployee(masEmployee);
		}
		if (request.getParameter(BONUS_ID)!= null) {
			int bonusId = Integer.parseInt(request.getParameter(BONUS_ID));
			HrMasBonus hrMasBonus = new HrMasBonus();
			hrMasBonus.setId(bonusId);
			hrBonusDetail.setBonus(hrMasBonus);
		}
		if (request.getParameter(FROM_DATE)!= null) {
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			hrBonusDetail.setFromDate(fromDate);
		}
		if (request.getParameter(TO_DATE)!= null) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			hrBonusDetail.setToDate(toDate);
		}
		if (request.getParameter(BONUS_AMOUNT)!= null) {
			BigDecimal bonusAmuont = new BigDecimal(request.getParameter(BONUS_AMOUNT));
			hrBonusDetail.setBonusAmount(bonusAmuont);
		}
		if (request.getParameter(PAID_DATE)!= null) {
			Date paidDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(PAID_DATE));
			hrBonusDetail.setPaidDate(paidDate);
		}
		if (request.getParameter(DUE_DATE)!= null) {
			Date dueDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DUE_DATE));
			hrBonusDetail.setDueDate(dueDate);
		}
		if (request.getParameter(REMARK)!= null) {
			String remark = request.getParameter(REMARK);
			hrBonusDetail.setRemarks(remark);
		}
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			hrBonusDetail.setLastChgBy(user);
		}
		
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 hrBonusDetail.setLastChgDate(currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 hrBonusDetail.setLastChgTime(currentTime);
		}
		hrBonusDetail.setStatus("y");
		map= loanHandlerService.saveBonusDetail(hrBonusDetail);
		String jsp = HR_BONUS_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView updateBonusDetail(HttpServletRequest request ,HttpServletResponse response ) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		Map<String, Object> generalMap = new HashMap<String, Object>(); 
		 
		HttpSession session = request.getSession();
		if (request.getParameter(BONUS_DETAIL_ID)!= null) {
			int bonusDetailId = Integer.parseInt(request.getParameter(BONUS_DETAIL_ID));
			generalMap.put("bonusDetailId", bonusDetailId);
		}
		if (request.getParameter(EMPLOYEE_ID)!= null) {
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("employeeId", employeeId);
		}
		if (request.getParameter(BONUS_ID)!= null) {
			int bonusId = Integer.parseInt(request.getParameter(BONUS_ID));
			generalMap.put("bonusId", bonusId);
		}
		if (request.getParameter(FROM_DATE)!= null) {
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			generalMap.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE)!= null) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			generalMap.put("toDate", toDate);
		}
		if (request.getParameter(BONUS_AMOUNT)!= null) {
			BigDecimal bonusAmuont = new BigDecimal(request.getParameter(BONUS_AMOUNT));
			generalMap.put("bonusAmuont", bonusAmuont);
		}
		if (request.getParameter(PAID_DATE)!= null) {
			Date paidDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(PAID_DATE));
			generalMap.put("paidDate", paidDate);
		}
		if (request.getParameter(DUE_DATE)!= null) {
			Date dueDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DUE_DATE));
			generalMap.put("dueDate", dueDate);
		}
		if (request.getParameter(REMARK)!= null) {
			String remark = request.getParameter(REMARK);
			generalMap.put("remark", remark);
		}
				
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			generalMap.put("changedBy", user);
		}
		
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 generalMap.put("currentDate", currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 generalMap.put("currentTime", currentTime);
		}
		map = loanHandlerService.updateBonusDetail(generalMap);
		String jsp = HR_BONUS_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showAdvanceJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		HttpSession sess = request.getSession();
		int centreId=0;
		if(sess.getAttribute("hospitalId") != null){
			centreId =(Integer)sess.getAttribute("hospitalId");
			
		}
		detailMap.put("centreId", centreId);
		map = loanHandlerService.showAdvanceJsp(detailMap);
		String jsp = HR_ADVANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveAdvance(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		HrAdvance hrAdvance = new HrAdvance();
		HttpSession session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute("hospitalId")!= null) {
			hospitalId = (Integer)session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrAdvance.setHospital(masHospital);
		}
		if (request.getParameter(EMPLOYEE_ID)!= null) {
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			hrAdvance.setEmployee(masEmployee);
		}
		if (request.getParameter(ADVANCE_CODE)!= null) {
			String advanceCode = request.getParameter(ADVANCE_CODE);
			hrAdvance.setAdvanceCode(advanceCode);
		}
		if (request.getParameter(ADVANCE_DATE)!= null) {
			Date advanceDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(ADVANCE_DATE));
			hrAdvance.setAdvanceDate(advanceDate);
		}
		if (request.getParameter(ADVANCE_AMOUNT)!= null) {
			BigDecimal advanceAmount = new BigDecimal(request.getParameter(ADVANCE_AMOUNT));
			hrAdvance.setAdvanceAmount(advanceAmount);
		}
		if (request.getParameter(RECOVERY_MODE)!= null) {
			String recoveryMode = request.getParameter(RECOVERY_MODE);
			hrAdvance.setRecoveryMode(recoveryMode);
		}
		if (request.getParameter(RECOVERY_PERIOD)!= null) {
			Float recoveryPeriod = Float.parseFloat(request.getParameter(RECOVERY_PERIOD));
			hrAdvance.setRecoveryPeriod(recoveryPeriod);
		}
		if (request.getParameter(MONTHLY_DEDUCTION)!= null) {
			BigDecimal monthlyDeduction = new BigDecimal(request.getParameter(MONTHLY_DEDUCTION));
			hrAdvance.setMonthlyDeduction(monthlyDeduction);
		}
		if (request.getParameter(RECOVERED_AMOUNT_HEADER)!= null && !(request.getParameter(RECOVERED_AMOUNT_HEADER).equals(""))) {
			BigDecimal recoveredHeaderAmount = new BigDecimal(request.getParameter(RECOVERED_AMOUNT_HEADER));
			hrAdvance.setRecoveredAmount(recoveredHeaderAmount);
		}
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			hrAdvance.setLastChgBy(user);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 hrAdvance.setLastChgDate(currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 hrAdvance.setLastChgTime(currentTime);
		}
		hrAdvance.setStatus("y");
		detailMap.put("hrAdvance", hrAdvance);
		detailMap.put("centreId", hospitalId);
		map = loanHandlerService.saveAdvance(detailMap);
		String jsp = HR_ADVANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateAdvance(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (request.getParameter(COMMON_ID)!= null) {
			int advanceId = Integer.parseInt(request.getParameter(COMMON_ID));
			generalMap.put("advanceId", advanceId);
		}
		if (request.getParameter("hiddenEmp") != null && !(request.getParameter("hiddenEmp").equals("")) ) {
			int employeeId = Integer.parseInt(request.getParameter("hiddenEmp"));
			generalMap.put("employeeId", employeeId);
		}
		if (request.getParameter(ADVANCE_CODE)!= null) {
			String advanceCode = request.getParameter(ADVANCE_CODE);
			generalMap.put("advanceCode", advanceCode);
		}
		if (request.getParameter(ADVANCE_DATE)!= null) {
			Date advanceDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(ADVANCE_DATE));
			generalMap.put("advanceDate", advanceDate);
		}
		if (request.getParameter(ADVANCE_AMOUNT)!= null) {
			BigDecimal advanceAmount = new BigDecimal(request.getParameter(ADVANCE_AMOUNT));
			generalMap.put("advanceAmount", advanceAmount);
		}
		if (request.getParameter(RECOVERY_MODE)!= null) {
			String recoveryMode = request.getParameter(RECOVERY_MODE);
			generalMap.put("recoveryMode", recoveryMode);
		}
		if (request.getParameter(MONTHLY_DEDUCTION)!= null) {
			BigDecimal monthlyDeduction = new BigDecimal(request.getParameter(MONTHLY_DEDUCTION));
			generalMap.put("monthlyDeduction", monthlyDeduction);
		}
		if (request.getParameter(RECOVERY_PERIOD)!= null) {
			Float recoveryPeriod = Float.parseFloat(request.getParameter(RECOVERY_PERIOD));
			generalMap.put("recoveryPeriod",recoveryPeriod);
		}
		if (request.getParameter(RECOVERED_AMOUNT_HEADER)!= null) {
			BigDecimal recoveredHeaderAmount = new BigDecimal(request.getParameter(RECOVERED_AMOUNT_HEADER));
			generalMap.put("recoveredHeaderAmount", recoveredHeaderAmount);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String	changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 generalMap.put("currentDate", currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 generalMap.put("currentTime", currentTime);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			 String	currentTime = request.getParameter(CHANGED_TIME);
			 generalMap.put("currentTime", currentTime);
			}
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			 generalMap.put("user", user);
		}
		map = loanHandlerService.updateAdvance(generalMap);
		String jsp = HR_ADVANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showAdvanceDetailJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		map = loanHandlerService.showAdvanceDetailJsp();
		String jsp = HR_ADVANCE_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveAdvanceDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		HrAdvanceDetail hrAdvanceDetail = new HrAdvanceDetail();
		HttpSession session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute("hospitalId")!= null) {
			hospitalId = (Integer)session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrAdvanceDetail.setHospital(masHospital);
		}
		if (request.getParameter(ADVANCE_ID)!= null) {
			int advanceId = Integer.parseInt(request.getParameter(ADVANCE_ID));
			HrAdvance hrAdvance = new HrAdvance();
			hrAdvance.setId(advanceId);
			hrAdvanceDetail.setAdvance(hrAdvance);
		}
		if (request.getParameter(RECOVERED_AMOUNT_DETAIL)!= null) {
			BigDecimal recoveredDetailAmount = new BigDecimal(request.getParameter(RECOVERED_AMOUNT_DETAIL));
			hrAdvanceDetail.setRecoveredAmount(recoveredDetailAmount);
		}
		if (request.getParameter(RECOVERY_DATE)!= null) {
			Date recoveryDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(RECOVERY_DATE));
			hrAdvanceDetail.setRecoveryDate(recoveryDate);
		}
		if (request.getParameter(REMARK)!= null) {
			String remark = request.getParameter(REMARK);
			hrAdvanceDetail.setRemark(remark);
		}
	
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			hrAdvanceDetail.setLastChgBy(user);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 hrAdvanceDetail.setLastChgDate(currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 hrAdvanceDetail.setLastChgTime(currentTime);
		}
		hrAdvanceDetail.setStatus("y");
		map = loanHandlerService.saveAdvanceDetail(hrAdvanceDetail); 
		String jsp = HR_ADVANCE_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView updateAdvanceDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (request.getParameter(COMMON_ID)!= null) {
			int advanceDetailId = Integer.parseInt(request.getParameter(COMMON_ID));
			generalMap.put("advanceDetailId", advanceDetailId);
		}
		if (request.getParameter(ADVANCE_ID)!= null) {
			int advanceId = Integer.parseInt(request.getParameter(ADVANCE_ID));
			generalMap.put("advanceId", advanceId);
		}
		if (request.getParameter(RECOVERED_AMOUNT_DETAIL)!= null) {
			BigDecimal recoveredDetailAmount = new BigDecimal(request.getParameter(RECOVERED_AMOUNT_DETAIL));
			generalMap.put("recoveredDetailAmount", recoveredDetailAmount);
		}
		if (request.getParameter(RECOVERY_DATE)!= null) {
			Date recoveryDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(RECOVERY_DATE));
			generalMap.put("recoveryDate", recoveryDate);
		}
		if (request.getParameter(REMARK)!= null) {
			String remark = request.getParameter(REMARK);
			generalMap.put("remark", remark);
		}
		
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			generalMap.put("changedBy", user);
		}
		
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 generalMap.put("currentDate", currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 generalMap.put("currentTime", currentTime);
		}
		map = loanHandlerService.updateAdvanceDetail(generalMap);
		String jsp = HR_ADVANCE_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	//Start 
	public ModelAndView showArrearJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = loanHandlerService.showArrearJsp();
		String jsp = HR_ARREAR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveArrear(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrArrear hrArrear = new HrArrear();
		HttpSession session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute("locationId")!= null) {
			hospitalId = (Integer)session.getAttribute("locationId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrArrear.setHospital(masHospital);
		}
		if (request.getParameter(EMPLOYEE_ID)!= null) {
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			hrArrear.setEmployee(masEmployee);
		}
		if (request.getParameter(PAY_ELEMENT_ID)!= null) {
			int payElementId = Integer.parseInt(request.getParameter(PAY_ELEMENT_ID));
			HrMasPayElement hrMasPayElement = new HrMasPayElement();
			hrMasPayElement.setId(payElementId);
			hrArrear.setPayElement(hrMasPayElement);
		}
		if (request.getParameter(FROM_DATE)!= null) {
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			hrArrear.setFromDate(fromDate);
		}
		if (request.getParameter(TO_DATE)!= null) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			hrArrear.setToDate(toDate);
		}
		if (request.getParameter(ARREAR_AMOUNT)!= null) {
			BigDecimal arrearAmount = new BigDecimal(request.getParameter(ARREAR_AMOUNT));
			hrArrear.setArrearAmount(arrearAmount);
		}
		if (request.getParameter(PF)!= null) {
			hrArrear.setPf("y");
		}else{
			hrArrear.setPf("n");
		}
		if (request.getParameter(ARREAR_DATE)!= null && !(request.getParameter(ARREAR_DATE).equals(""))) {
			Date arrearDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(ARREAR_DATE));
			hrArrear.setArrearDate(arrearDate);
		}
		if (request.getParameter(PAID_DATE)!= null  && !(request.getParameter(PAID_DATE).equals(""))) {
			Date paidDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PAID_DATE));
			hrArrear.setPaidDate(paidDate);
			hrArrear.setArrearDate(paidDate);
		}
		if (request.getParameter(ARREAR_STATUS)!= null) {
			String arrearStatus = request.getParameter(ARREAR_STATUS);
			hrArrear.setArrearStatus(arrearStatus);
		}
		if (request.getParameter(REMARK)!= null) {
			String remark = request.getParameter(REMARK);
			hrArrear.setRemark(remark);
		}
		
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			hrArrear.setLastChgBy(user);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 hrArrear.setLastChgDate(currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 hrArrear.setLastChgTime(currentTime);
		}
		hrArrear.setStatus("y");
		map = loanHandlerService.saveArrear(hrArrear);
		String jsp = HR_ARREAR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateArrear(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (request.getParameter(ARREAR_ID)!= null) {
			int arrearId = Integer.parseInt(request.getParameter(ARREAR_ID));
			generalMap.put("arrearId", arrearId);
		}
		if (request.getParameter("hiddenEmp")!= null) {
			int employeeId = Integer.parseInt(request.getParameter("hiddenEmp"));
			generalMap.put("employeeId", employeeId);
		}
		if (request.getParameter(PAY_ELEMENT_ID)!= null) {
			int payElementId = Integer.parseInt(request.getParameter(PAY_ELEMENT_ID));
			generalMap.put("payElementId", payElementId);
		}
		if (request.getParameter(FROM_DATE)!= null) {
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			generalMap.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE)!= null) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			generalMap.put("toDate", toDate);
		}
		if (request.getParameter(ARREAR_AMOUNT)!= null) {
			BigDecimal arrearAmount = new BigDecimal(request.getParameter(ARREAR_AMOUNT));
			generalMap.put("arrearAmount", arrearAmount);
		}
		if (request.getParameter(PF)!= null) {
			String pf = "y";
			generalMap.put("pf", pf);
		}else{
			String pf = "n";
			generalMap.put("pf", pf);
		}
		if (request.getParameter(ARREAR_DATE)!= null && !(request.getParameter(ARREAR_DATE).equals("")) ) {
			Date arrearDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(ARREAR_DATE));
			generalMap.put("arrearDate", arrearDate);
		}
		if (request.getParameter(PAID_DATE)!= null && !(request.getParameter(PAID_DATE).equals(""))) {
			Date paidDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PAID_DATE));
			generalMap.put("paidDate", paidDate);
		}
		if (request.getParameter(ARREAR_STATUS)!= null) {
			String arrearStatus = request.getParameter(ARREAR_STATUS);
			generalMap.put("arrearStatus", arrearStatus);
		}
		if (request.getParameter(REMARK)!= null) {
			String remark = request.getParameter(REMARK);
			generalMap.put("remark", remark);
		}
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");
			generalMap.put("changedBy", user);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 generalMap.put("currentDate", currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 generalMap.put("currentTime", currentTime);
		}
		map = loanHandlerService.updateArrear(generalMap);
		String jsp = HR_ARREAR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showArrearSalaryJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		map = loanHandlerService.showArrearSalaryJsp();
		String jsp = HR_ARREAR_SALARY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveArrearSalary(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		HrArrearSalary hrArrearSalary = new HrArrearSalary();
		HttpSession session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute("hospitalId")!= null) {
			hospitalId = (Integer)session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrArrearSalary.setHospital(masHospital);
		}
		if (request.getParameter(EMPLOYEE_ID)!= null) {
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			hrArrearSalary.setEmployee(masEmployee);
		}
		if (request.getParameter(FROM_DATE)!= null) {
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			hrArrearSalary.setFromDate(fromDate);
		}
		if (request.getParameter(TO_DATE)!= null) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			hrArrearSalary.setToDate(toDate);
		}
		if (request.getParameter(ARREAR_DAYS)!= null) {
			Float arrearDays = Float.parseFloat(request.getParameter(ARREAR_DAYS));
			hrArrearSalary.setArrearDays(arrearDays);
		}
		if (request.getParameter(PAYMENT_DATE)!= null) {
			Date paymentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(PAYMENT_DATE));
			hrArrearSalary.setPaymentDate(paymentDate);
		}
		if (request.getParameter(REMARK)!= null) {
			String remark = request.getParameter(REMARK);
			hrArrearSalary.setRemark(remark);
		}
		
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");			
			hrArrearSalary.setLastChgBy(user);
		}
		
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 hrArrearSalary.setLastChgDate(currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 hrArrearSalary.setLastChgTime(currentTime);
		}
		hrArrearSalary.setStatus("y");
		map = loanHandlerService.saveArrearSalary(hrArrearSalary);
		String jsp = HR_ARREAR_SALARY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateArrearSalary(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int arrearSalaryId =0;
		if (request.getParameter(ARREAR_SALARY_ID)!= null) {
			arrearSalaryId= Integer.parseInt(request.getParameter(ARREAR_SALARY_ID));
			generalMap.put("arrearSalaryId", arrearSalaryId);
		}
		if (request.getParameter(EMPLOYEE_ID)!= null) {
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("employeeId", employeeId);
		}
		if (request.getParameter(FROM_DATE)!= null) {
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			generalMap.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE)!= null) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			generalMap.put("toDate", toDate);
		}
		if (request.getParameter(PAYMENT_DATE)!= null) {
			Date paymentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(PAYMENT_DATE));
			generalMap.put("paymentDate", paymentDate);
		}
		if (request.getParameter(ARREAR_DAYS)!= null) {
			Float arrearDays = Float.parseFloat(request.getParameter(ARREAR_DAYS));
			generalMap.put("arrearDays", arrearDays);
		}
		if (request.getParameter(REMARK)!= null) {
			String remark = request.getParameter(REMARK);
			generalMap.put("remark", remark);
		}
		
		if (session.getAttribute("users")!= null) {
			Users user = (Users)session.getAttribute("users");			
			generalMap.put("changedBy", user);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		 generalMap.put("currentDate", currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
		 String	currentTime = request.getParameter(CHANGED_TIME);
		 generalMap.put("currentTime", currentTime);
		}
		map = loanHandlerService.updateArrearSalary(generalMap);
		String jsp = HR_ARREAR_SALARY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showAdvanceStatementJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = loanHandlerService.showAdvanceStatementJsp();
		String jsp = HR_ADVANCE_STATEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printAdvanceStatementReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int fromEmpCode =0;
		int department =0;
		int hospital_id =0;
		
		String query = " ";
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospital_id = (Integer)session.getAttribute(HOSPITAL_ID);
			query = "where mas_employee.hospital_id = "+hospital_id;   
		}
				
		if ((request.getParameter("employeeId")!= null) && ((Integer.parseInt((request.getParameter("employeeId")))!= 0))) {
			fromEmpCode = Integer.parseInt(request.getParameter("employeeId"));
			query = query + " and  mas_employee.employee_id = "+fromEmpCode;  
			
		}
		System.out.println("fromEmpCode-----"+fromEmpCode);
		
		if ((request.getParameter("department")!= null)&& !(request.getParameter("department").equals("0"))) {
			department = Integer.parseInt(request.getParameter("department"));
			query = query +" and mas_employee.department_id = "+ department;
		}
		
		System.out.println("department-----------"+department);
		System.out.println("main query---"+query);
		
		detailsMap = loanHandlerService.getConnectionForReport();
		parameters.put("query",query);
		
		HMSUtil.generateReport("advanceStatement", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
			return null;
		}
	
	public ModelAndView showloanstatement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = loanHandlerService.showloanstatement();
		String jsp = HR_LOAN_STATEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}
	
	public ModelAndView printloanstatement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int fromEmpCode = 0;
		int departmentId = 0;
		String querySql = "";
		if(! request.getParameter("department").equals("0")){
			departmentId = Integer.parseInt(request.getParameter("department"));
			querySql = querySql + " WHERE mas_department.department_id = "+ departmentId;
		}
		if (!request.getParameter("fromempcode").equals("0")) {
			fromEmpCode = Integer.parseInt(request.getParameter("fromempcode"));
			querySql = querySql + " AND   mas_employee.employee_id = "+fromEmpCode;
		}
		detailsMap = loanHandlerService.getConnectionForReport();
		System.out.println("querySql --> "+querySql);
		parameters.put("querySql", querySql);

		HMSUtil.generateReport("loanstatment", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

}
