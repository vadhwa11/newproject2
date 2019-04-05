package jkt.hms.payroll.controller;


import static jkt.hms.util.RequestConstants.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.HrPayrollProcessHeader;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.payroll.handler.PayrollHandlerService;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PayrollController extends MultiActionController {
	
	PayrollHandlerService payrollHandlerService = null;

	public PayrollHandlerService getPayrollHandlerService() {
		return payrollHandlerService;
	}

	public void setPayrollHandlerService(PayrollHandlerService payrollHandlerService) {
		this.payrollHandlerService = payrollHandlerService;
	}
	
	public ModelAndView showPrePayrollProcessJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int centreId =0;
		if (session.getAttribute("hospitalId")!= null) {
			centreId = (Integer)session.getAttribute("hospitalId");
			map.put("hospitalId",centreId );
		}
		detailsMap.put("centreId",centreId );
		map = payrollHandlerService.showPrePayrollProcessJsp();
		String jsp = HR_PRE_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	

	public ModelAndView processPrePayrollDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> generalMap1 = new HashMap<String, Object>();
		HrPayrollProcessHeader hrPayrollProcessHeader = new HrPayrollProcessHeader();
		HttpSession session = request.getSession();
		List<HrPayrollProcessHeader> hrPayRollProcessHeaderList = new ArrayList<HrPayrollProcessHeader>();
		int count=0;
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		int departmentId = 0;
		int employeeId = 0;
		int locationId = 0;
		if(request.getParameter(DEPARTMENT_ID)!= null && Integer.parseInt(request.getParameter(DEPARTMENT_ID))!=0 ){
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			generalMap1.put("departmentId", departmentId);
		}
		if(request.getParameter(EMPLOYEE_ID) !=null){
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if(request.getParameter("locationId") !=null){
			locationId = Integer.parseInt(request.getParameter("locationId"));
			generalMap1.put("locationId", locationId);
		}
		
	//below not needed 	
		
		if(departmentId == 0 && employeeId == 0 && locationId == 0){
			employeeList = payrollHandlerService.getAllEmployeeList();
			
		}else if(departmentId != 0 && employeeId == 0 && locationId == 0){
			MasDepartment department = payrollHandlerService.getDepartment(departmentId);
			List<MasEmployee> employeeSet =(List<MasEmployee>) payrollHandlerService.getEmployee(generalMap1);
			
			if(employeeSet!=null && employeeSet.size()>0){
				for(MasEmployee employee : employeeSet){
					if(employee.getEmployeeStatus() != null){
					if(employee.getEmployeeStatus().getId() == 1){
						employeeList.add(employee);
						}
					}
				}
			}
		}
		// till here not needed 	
		
		else if(departmentId != 0 && employeeId == 0 && locationId != 0){
			List<MasEmployee> employeeSet =(List<MasEmployee>) payrollHandlerService.getEmployee(generalMap1);
			
			if(employeeSet!=null && employeeSet.size()>0){
				for(MasEmployee employee : employeeSet){
					if(employee.getEmployeeStatus() != null){
					if(employee.getEmployeeStatus().getId() == 1){
						employeeList.add(employee);
						}
					}
				}
			}
		}
		else if(locationId != 0 && departmentId == 0 && employeeId == 0 ){
			
			List<MasHospital> hospitalList  = payrollHandlerService.getHospital(locationId);
			Set<MasEmployee> employeeSet = new HashSet<MasEmployee>();
			for(MasHospital masHospital :hospitalList){
				employeeSet = masHospital.getMasEmployees();
			if(employeeSet!=null && employeeSet.size()>0){
				for(MasEmployee employee : employeeSet){
					if(employee.getEmployeeStatus() != null){
					if(employee.getEmployeeStatus().getId() == 1){
						employeeList.add(employee);
					}
					}
				}
			}
			}
			
		}else if((departmentId != 0 && employeeId != 0 && locationId !=0 ) || (departmentId == 0 && locationId==0 && employeeId != 0 )){
			 count++;
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			hrPayrollProcessHeader.setEmployee(masEmployee);
		}
		
	
		int month = 0;
		if (request.getParameter(MONTH)!= null) {
			 month =Integer.parseInt(request.getParameter(MONTH));
			hrPayrollProcessHeader.setMonth(month);
		}
		int year = 0;
		if (request.getParameter(YEAR)!= null) {
			 year =Integer.parseInt(request.getParameter(YEAR));
			hrPayrollProcessHeader.setYear(year);
		}
		
		String	changedBy = "";
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		hrPayrollProcessHeader.setLastChgBy(changedBy);
		}
		
		Date currentDate = new Date();
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
		 currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		hrPayrollProcessHeader.setLastChgDate(currentDate);
		}
		int hospitalId =0;
		if (session.getAttribute("locationId")!= null) {
			hospitalId = (Integer)session.getAttribute("locationId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrPayrollProcessHeader.setHospital(masHospital);
			
		}
		System.out.println("hospitalId====="+hospitalId);
		String	currentTime = "";
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		hrPayrollProcessHeader.setLastChgTime(currentTime);
		}
		System.out.println("employeeList=111=="+employeeList.size());
		if(employeeList != null && employeeList.size() > 0)
		{
			for(MasEmployee employee : employeeList)
			{
				HrPayrollProcessHeader hrPayrollProcessHeader1 = new HrPayrollProcessHeader();
				hrPayrollProcessHeader1.setEmployee(employee);
				hrPayrollProcessHeader1.setDepartment(employee.getDepartment());
				hrPayrollProcessHeader1.setMonth(month);
				hrPayrollProcessHeader1.setYear(year);
				hrPayrollProcessHeader1.setLastChgBy(changedBy);
				hrPayrollProcessHeader1.setLastChgDate(currentDate);
				hrPayrollProcessHeader1.setLastChgTime(currentTime);
				hrPayRollProcessHeaderList.add(hrPayrollProcessHeader1);
				count++;
			}
			
		}
		else
		{
			hrPayRollProcessHeaderList.add(hrPayrollProcessHeader);
		}
		String message = "<b>Salary processed for :</b><br/>";	
		List<HrPayrollProcessHeader> processedPayrollList = new ArrayList();
		List<HrPayrollProcessHeader> unprocessedPayrollList = new ArrayList();
		try{
			System.out.println("hrPayRollProcessHeaderList=="+hrPayRollProcessHeaderList.size());
			if(hrPayRollProcessHeaderList.size() >0){
		for(HrPayrollProcessHeader hrPayrollProcessHeader2 : hrPayRollProcessHeaderList){
			generalMap.put("hrPayrollProcessHeader", hrPayrollProcessHeader2);
			map = payrollHandlerService.processPrePayrollDetail(generalMap);
			message = message + (String)map.get("message");
			
			if(map.get("processed")!=null)
			{
				processedPayrollList.add((HrPayrollProcessHeader)map.get("processed"));
			}
			if(map.get("unprocessed")!=null)
			{
			unprocessedPayrollList.add((HrPayrollProcessHeader)map.get("unprocessed"));
			}
		}
		message = message + "<br /><br /><b> Total no. of employees for which salary processed is " + count + "</b>";
		}else{
			message = message + "<br /><br /><b> Total no. of employees for which salary processed is " + count + "</b>";
		}
		
		}
		catch(Exception e)
		{
			message = message + "\n\n Problem Occured!!";
			e.printStackTrace();
		}
		
		map.put("message", message);
		String jsp = HR_PRE_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("year", year);
		map.put("month", month);
		map.put("processedPayrollList", processedPayrollList);
		map.put("unprocessedPayrollList", unprocessedPayrollList);
		
		System.out.println("End of the method processPrePayrollDetail:");
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showSearchPrePayrollProcessJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showSearchPrePayrollProcessJsp();
		String jsp = HR_SEARCH_PRE_PAYROLL_PROCESS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchPrePayrollDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if (request.getParameter(EMPLOYEE_ID)!= null) {
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("employeeId", employeeId);
		}
		if (request.getParameter(DEPARTMENT_ID)!= null) {
			int departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			generalMap.put("departmentId", departmentId);
		}
		if (request.getParameter(MONTH)!= null) {
			int month =Integer.parseInt(request.getParameter(MONTH));
			generalMap.put("month", month);
		}
		if (request.getParameter(YEAR)!= null) {
			int year =Integer.parseInt(request.getParameter(YEAR));
			generalMap.put("year", year);
		}
		map = payrollHandlerService.searchPrePayrollDetail(generalMap);
		String jsp = HR_SEARCH_PRE_PAYROLL_PROCESS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editPrePayrollDetail(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String message = "";
		int prePayrollProcessId = 0;
		if (request.getParameter(PRE_PAYROLL_PROCESS_ID)!= null) {
			prePayrollProcessId = Integer.parseInt(request.getParameter(PRE_PAYROLL_PROCESS_ID));
		}
		String salaryStatus = "";
		if (request.getParameter(FLAG)!= null) {
			salaryStatus = request.getParameter(FLAG);
		}
		String jsp = "";
		
		if(salaryStatus.equals("C")){
			message = "Data can't be updated Salary Fixed .";
			map.put("message", message);
			jsp = HR_SEARCH_PRE_PAYROLL_PROCESS_JSP;
			jsp += ".jsp";
		}else if(salaryStatus.equals("P")){
			map = payrollHandlerService.editPrePayrollDetail(prePayrollProcessId);
			 jsp = HR_UPDATE_PRE_PAYROLL_PROCESS_JSP;
			 jsp += ".jsp";
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView updateProcessPrePayrollDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List payElementIdList =new ArrayList();
		List payElementCodeList =new ArrayList();
		List payElementAmountList =new ArrayList();
		List payElementTypeList =new ArrayList();
		if (request.getParameter(PRE_PAYROLL_PROCESS_ID)!= null) {
			int prePayrollProcessId = Integer.parseInt(request.getParameter(PRE_PAYROLL_PROCESS_ID));
			generalMap.put("prePayrollProcessId", prePayrollProcessId);
		}
		if (request.getParameter(EMPLOYEE_ID)!= null) {
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("employeeId", employeeId);
		}
		System.out.println("employeeId in controller====="+Integer.parseInt(request.getParameter(EMPLOYEE_ID)));
		if (request.getParameter(DEPARTMENT_ID)!= null) {
			int departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			generalMap.put("departmentId", departmentId);
		}
		if (request.getParameter(MONTH)!= null) {
			int month = Integer.parseInt(request.getParameter(MONTH));
			generalMap.put("month", month);
		}
		if (request.getParameter(YEAR)!= null) {
			int year = Integer.parseInt(request.getParameter(YEAR));
			generalMap.put("year", year);
		}
		if (request.getParameter(LWP)!= null) {
			int lwp = Integer.parseInt(request.getParameter(LWP));
			generalMap.put("lwp", lwp);
		}
		if (request.getParameter(TOTAL_DAYS)!= null) {
			int totalDays = Integer.parseInt(request.getParameter(TOTAL_DAYS));
			generalMap.put("totalDays", totalDays);
		}
		if (request.getParameter(SALARY_DAYS)!= null) {
			int salaryDays = Integer.parseInt(request.getParameter(SALARY_DAYS));
			generalMap.put("salaryDays", salaryDays);
		}
		if (request.getParameter(MONTHLY_INSTALLMENT)!= null) {
			BigDecimal loanMonthlyInstallment = new BigDecimal(request.getParameter(MONTHLY_INSTALLMENT));
			generalMap.put("loanMonthlyInstallment", loanMonthlyInstallment);
		}
		if (request.getParameter(ADVANCE_AMOUNT)!= null) {
			BigDecimal advanceAmount = new BigDecimal(request.getParameter(ADVANCE_AMOUNT));
			generalMap.put("advanceAmount", advanceAmount);
		}
		if (request.getParameter(BONUS_AMOUNT)!= null) {
			BigDecimal bonusAmount = new BigDecimal(request.getParameter(BONUS_AMOUNT));
			generalMap.put("bonusAmount", bonusAmount);
		}
		int noOfPayElement = 0;
		if (request.getParameter("counter")!= null) {
			noOfPayElement = Integer.parseInt(request.getParameter("counter"));
		}
		for(int j=0;j<noOfPayElement;j++)
		{
			if (request.getParameter(PAY_ELEMENT_ID+j)!= null) {
				payElementIdList.add(Integer.parseInt(request.getParameter(PAY_ELEMENT_ID+j)));
				System.out.println("pay elem id-------------"+request.getParameter(PAY_ELEMENT_ID+j));
				if (request.getParameter(PAY_ELEMENT_CODE+j)!= null) {
				  payElementCodeList.add(request.getParameter(PAY_ELEMENT_CODE+j));
				}
				if (request.getParameter(PAY_ELEMENT_AMOUNT+j)!= null) {
					 payElementAmountList.add(new BigDecimal(request.getParameter(PAY_ELEMENT_AMOUNT+j)));
				}
				System.out.println("payElementAmount-------- "+request.getParameter(PAY_ELEMENT_AMOUNT+j));
				if (request.getParameter(PAY_ELEMENT_TYPE+j)!= null) {
					payElementTypeList.add(request.getParameter(PAY_ELEMENT_TYPE+j));
				}
			}
			System.out.println("payElementType------ "+request.getParameter(PAY_ELEMENT_TYPE+j));
		 }
	
			generalMap.put("payElementIdList", payElementIdList);
			generalMap.put("payElementCodeList", payElementCodeList);
			generalMap.put("payElementAmountList", payElementAmountList);
			generalMap.put("payElementTypeList", payElementTypeList);
		
		map = payrollHandlerService.updateProcessPrePayrollDetail(generalMap);
		
		String	jsp = HR_SEARCH_PRE_PAYROLL_PROCESS_JSP;
		
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPostPayrollProcessJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showPostPayrollProcessJsp();
		String jsp = HR_POST_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView processPostPayrollDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		
		if (request.getParameter(DEPARTMENT_ID)!= null) {
			int departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			generalMap.put("departmentId", departmentId);
		}
		if (request.getParameter(MONTH)!= null) {
			int month =Integer.parseInt(request.getParameter(MONTH));
			generalMap.put("month", month);
		}
		if (request.getParameter(YEAR)!= null) {
			int year =Integer.parseInt(request.getParameter(YEAR));
			generalMap.put("year", year);
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
				
		
		map = payrollHandlerService.processPostPayrollDetail(generalMap);
		String jsp = HR_POST_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPaySlipJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map= payrollHandlerService.showPaySlipJsp();
		String jsp = HR_PAY_SLIP_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView printPaySlipReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		int employee_id = 0;
		int month = 0;
		int year  = 0;
		String monthInString = "";
		try
		{ 
				if (request.getParameter("fromEmpId")!= null) {
					employee_id =Integer.parseInt(request.getParameter("fromEmpId"));
				}
				
				if (request.getParameter(MONTH)!= null) {
					 month = Integer.parseInt(request.getParameter(MONTH));
				}
											
				if (request.getParameter("monthString")!= null) {
					monthInString =request.getParameter("monthString");
				}
								
				if (request.getParameter(YEAR)!= null) {
					 year =Integer.parseInt(request.getParameter(YEAR));
				}
			
				
				detailsMap = payrollHandlerService.getConnectionForReport();

				parameters.put("month", month);
				parameters.put("year", year);
				parameters.put("monthInString", monthInString);
				parameters.put("employee_id",employee_id);
				parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
				
				
				String userHome = getServletContext().getRealPath("");             
                String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
                parameters.put("path", imagePath);

				
				HMSUtil.generateReport("new_pay_slip", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
				}
				catch(Exception e)
				{
					e.printStackTrace(); 
				}
				return null;
}
	public ModelAndView showMonthlyBankAdviceReportJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map= payrollHandlerService.showMonthlyBankAdviceReportJsp();
		String jsp = HR_MONTHLY_BANK_ADVICE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView printMonthlyBankAdvice(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int departmentId = 0;
		int fromEmpCode =0;
		int toEmpCode = 0;
		String querySql = "";
		
		int month =0;
		if (request.getParameter(MONTH)!= null) {
			 month =Integer.parseInt(request.getParameter(MONTH));
			 querySql = "Where hr_payroll_process_header.month = "+month;
		}
		String monthName = "";
		if(month == 1){
			monthName = "January";
		} else if(month == 2){
			monthName = "February";
		} else if(month == 3){
			monthName = "March";
		} else if(month == 4){
			monthName = "April";
		} else if(month == 5){
			monthName = "May";
		} else if(month == 6){
			monthName = "June";
		} else if(month == 7){
			monthName = "July";
		} else if(month == 8){
			monthName = "August";
		} else if(month == 9){
			monthName = "September";
		} else if(month == 10){
			monthName = "October";
		} else if(month == 11){
			monthName = "November";
		} else if(month == 12){
			monthName = "December";
		} 

		int year = 0;
		if (request.getParameter(YEAR)!= null) {
			 year =Integer.parseInt(request.getParameter(YEAR));
			 querySql = querySql + " and hr_payroll_process_header.year = "+year;
		}
		System.out.println("year----"+year);
		
		if (!request.getParameter("department").equals("0")) {
			departmentId = Integer.parseInt(request.getParameter("department"));
			querySql = querySql + " and hr_payroll_process_header.department_id = " +departmentId;
		}
		if (!request.getParameter("fromEmpCode").equals("0")) {
			fromEmpCode = Integer.parseInt(request.getParameter("fromEmpCode"));
			
		}
		if (!request.getParameter("toEmpCode").equals("0")) {
			toEmpCode = Integer.parseInt(request.getParameter("toEmpCode"));
			querySql = querySql + " and mas_employee.employee_id between "+fromEmpCode+" and "+toEmpCode;
		}
		
		
		detailsMap = payrollHandlerService.getConnectionForReport();
		parameters.put("monthName", monthName);
		parameters.put("querySql", querySql);
		
		HMSUtil.generateReport("monthly_bank_advice", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
			return null;
	}
	
	public ModelAndView showEarningAndDeductionJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map= payrollHandlerService.showEarningAndDeductionJsp();
		String jsp = HR_EARNING_DEDUCTION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView printEarningAndDeductionReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query ="where mas_employee.status = 'y'";
			
		int empId = 0;
		if (request.getParameter(EMPLOYEE_ID)!= null &&!request.getParameter(EMPLOYEE_ID).equals("0")) {
			empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID) );
			query = query + " and mas_employee.employee_id = "+empId;
		}
		
		int month =0;
		if (request.getParameter(MONTH)!= null) {
			 month =Integer.parseInt(request.getParameter(MONTH));
		}
		
		String monthInString = "";
		if (request.getParameter("monthString")!= null) {
			monthInString =request.getParameter("monthString");
		}
		String categoryInString = "";
		if (request.getParameter("categoryString")!= null) {
			categoryInString =request.getParameter("categoryString");
		}
		
		int year = 0;
		if (request.getParameter(YEAR)!= null) {
			 year =Integer.parseInt(request.getParameter(YEAR));
		}
		detailsMap = payrollHandlerService.getConnectionForReport();
	
		parameters.put("query", query);
		parameters.put("month", month);
		parameters.put("year", year);
		parameters.put("monthInString", monthInString);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		
		HMSUtil.generateReport("earningAndDeduction", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
		}
	
	public ModelAndView showIncomeTaxSheet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showIncomeTaxSheet();
		String jsp = "incomeTaxSheet.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printIncomeTaxSheet(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreFinancial> hrMasFinancialYearList = new ArrayList<MasStoreFinancial>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String querySql = "";
		int year = 0;
		int emp_id = 0;
		Date fDate = null; 
		Date tDate = null;
		try {
			
			if (!request.getParameter("invYear").equals("0") 
					&& request.getParameter("invYear") != null) {
				year = Integer.parseInt(request.getParameter("invYear"));
				map = payrollHandlerService.getFinancialYearDate(year);
				if(map.get("hrMasFinancialYearList") != null){
					hrMasFinancialYearList = (List)map.get("hrMasFinancialYearList");
				}
				
				if(hrMasFinancialYearList.size() > 0){
					fDate = hrMasFinancialYearList.get(0).getStartDate();
					tDate = hrMasFinancialYearList.get(0).getEndDate();
				
				}
			}

			if (!request.getParameter("empcode").equals("0")
					&& request.getParameter("empcode") != null) {
				emp_id = Integer.parseInt(request.getParameter("empcode"));
			
			}

			parameters.put("tDate", tDate);
			parameters.put("fDate", fDate);
			parameters.put("emp_id", emp_id);
			parameters.put("year", year);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

			detailsMap = payrollHandlerService.getConnectionForReport();
			HMSUtil.generateReport("ITSheet", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
