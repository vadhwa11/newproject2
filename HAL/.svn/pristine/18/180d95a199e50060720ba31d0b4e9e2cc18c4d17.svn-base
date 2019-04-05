<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.HrPayrollProcessHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String,Object> utilMap = new HashMap<String,Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();	
				List<HrPayrollProcessHeader> prePayrollProcessList = new ArrayList<HrPayrollProcessHeader>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<HrPayrollProcessHeader> singlePrePayrollProcessList = new ArrayList<HrPayrollProcessHeader>();
				List<HrEmployeePayElements> payElementsList = new ArrayList<HrEmployeePayElements>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("singlePrePayrollProcessList")!= null){
					singlePrePayrollProcessList = (List)map.get("singlePrePayrollProcessList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				if(map.get("prePayrollProcessList")!= null){
					prePayrollProcessList = (List)map.get("prePayrollProcessList");
				}
				if(map.get("payElementsList")!= null){
					payElementsList = (List)map.get("payElementsList");
				}
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
				
				String userName = "";
				if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
				}
				if(map.get("message") != null){
				String message = (String)map.get("message");
				out.println(message);
				}
				int employeeId = 0;
				int prePayrollProcessId = 0;
				int departmentId = 0;
				int payrollYear = 0;
				int payrollMonth = 0;
				int lwp = 0;
				int totalDays = 0;
				int totalMonthDays = 0;
				int salaryDays = 0;
				String employeeName = "";
				String departmentName = "";
				
				BigDecimal basic = new BigDecimal("0");
				BigDecimal loanMonthlyInstallment = new BigDecimal("0");
				BigDecimal advanceMonthlyInstallment = new BigDecimal("0");
				BigDecimal bonusAmount = new BigDecimal("0");
				BigDecimal arrearPayElementAmt = new BigDecimal("0");
				BigDecimal arrearSal = new BigDecimal("0");
				//BigDecimal totalEarning = new BigDecimal("0");
				//BigDecimal totalDeduction = new BigDecimal("0");
				Set<HrPayrollProcessDetail> detailSet = new HashSet();
				if(singlePrePayrollProcessList.size()>0){
					
					for(HrPayrollProcessHeader payrollProcessHeader : singlePrePayrollProcessList){
					prePayrollProcessId = payrollProcessHeader.getId();	
					if(payrollProcessHeader.getEmployee().getId()!= null){
						detailSet = payrollProcessHeader.getHrPayrollProcessDetails();
						employeeId = (Integer)payrollProcessHeader.getEmployee().getId();
						employeeName = payrollProcessHeader.getEmployee().getFirstName()+" "+payrollProcessHeader.getEmployee().getLastName();
						departmentId = (Integer)payrollProcessHeader.getDepartment().getId();
						payrollYear = (Integer)payrollProcessHeader.getYear();
						payrollMonth = (Integer)payrollProcessHeader.getMonth();
						lwp = payrollProcessHeader.getLwpDays();
						totalDays = payrollProcessHeader.getTotalDays();
						salaryDays = payrollProcessHeader.getSalDays();
						loanMonthlyInstallment = payrollProcessHeader.getLoanInstallment();
						advanceMonthlyInstallment = payrollProcessHeader.getAdvanceInstallment();
						bonusAmount = payrollProcessHeader.getBonusAmount();
						departmentName = payrollProcessHeader.getDepartment().getDepartmentName();
						basic = payrollProcessHeader.getBasic();
						totalMonthDays = payrollProcessHeader.getTotalMonthDays();
						arrearPayElementAmt= payrollProcessHeader.getArrearPayelementAmt();
						arrearSal = payrollProcessHeader.getArrearSalaryAmt();
					}
					
					}
					
				}
						
				
	%>


<%@page import="jkt.hms.masters.business.HrEmployeePayElements"%>
<%@page import="jkt.hms.masters.business.HrPayrollProcessDetail"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript">

<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
		
		 function calculateSalaryDays()
	   {
	
		   var totalDays = <%=totalDays%>;
		   var lwp = document.updatePrePayrollProcess.<%=LWP%>.value;
		   if(totalDays != "" && lwp!="")
		{
			var tDays =parseInt(totalDays);
			var noOfLWP = parseInt(lwp);
		
			var salaryDays = totalDays - lwp;
			document.updatePrePayrollProcess.<%=SALARY_DAYS%>.value=salaryDays;
		}
	  }

</script>

<form name="updatePrePayrollProcess" method="post" action="" >
<div class="titleBg"> <h2>update Pre Payroll Process </h2></div>
<div class="clear"></div>
<div class="Block">
<label> Employee Name:</label>
<label class="value"> <%=employeeName %></label>


<label> Month:</label>
<label class="value"> <%=HMSUtil.convertMonth(payrollMonth) %></label>

<label>Year</label>
<label class="value"><%=payrollYear %></label>


<div class="clear"></div>
<label> Department Name</label>
<label class="value"><%=departmentName %></label>
<label> Basic</label>
<label class="value"><%=basic %></label>
<label> Total Days</label>
<label class="value"><%=totalMonthDays %></label>
<div class="clear"></div>
<label>No.Of.LWP</label>
<input  type="text" name="<%=LWP%>" value=""  onblur="calculateSalaryDays()"    validate="Remark,String,no" MAXLENGTH="40" tabindex=1 />
<script type="text/javascript">
          		  document.updatePrePayrollProcess.<%=LWP%>.value='<%=lwp%>';
            </script>
  
<label>Salary days</label>
<input  type="text" name="<%= SALARY_DAYS%>" value=""    validate="Remark,String,no" MAXLENGTH="40" tabindex=1 />
<script type="text/javascript">
          		  document.updatePrePayrollProcess.<%=SALARY_DAYS%>.value='<%=salaryDays%>';
            </script>
        
 <label>Loan Install.</label>
<input  type="text" name="<%= MONTHLY_INSTALLMENT%>" value=""   validate="Remark,String,no" MAXLENGTH="40" tabindex=1 />
<script type="text/javascript">
          		  document.updatePrePayrollProcess.<%=MONTHLY_INSTALLMENT%>.value='<%=loanMonthlyInstallment %>';
            </script>
 <div class="clear"></div> 
 <label>Advance Install</label>
<input  type="text" name="<%= ADVANCE_AMOUNT%>" value=""   validate="Remark,String,no" MAXLENGTH="40" tabindex=1 />
<script type="text/javascript">
          		  document.updatePrePayrollProcess.<%=ADVANCE_AMOUNT%>.value='<%=advanceMonthlyInstallment%>';
            </script>
 
<label>Bonus</label>
<input  type="text" name="<%= BONUS_AMOUNT%>" value=""   validate="Bonus,String,no" MAXLENGTH="8" tabindex=1 />
  <script type="text/javascript">
          		  document.updatePrePayrollProcess.<%=BONUS_AMOUNT%>.value='<%=bonusAmount%>';
            </script>     
            
            <label>Arrear Pay Element</label>
<input  type="text" name="arrearPayElement" value=""   validate="Arrear Pay Element,String,no" MAXLENGTH="8" tabindex=1 />
  <script type="text/javascript">
          		  document.updatePrePayrollProcess.<%="arrearPayElement"%>.value='<%=arrearPayElementAmt%>';
            </script> 
              <div class="clear"></div> 
             <label>Arrear Salary</label>
<input  type="text" name="arrearSalary" value=""   validate="Arrear Salary,String,no" MAXLENGTH="8" tabindex=1 />
  <script type="text/javascript">
          		  document.updatePrePayrollProcess.<%="arrearSalary"%>.value='<%=arrearSal%>';
            </script>       

 <div class="clear"></div>
</div>
<table>
<tr>
	<th scope="col">Sr No.</th>
    <th scope="col">Pay Element Type </th>
    <th scope="col">Amount </th>
    <th scope="col">Element Type </th>
    
</tr>
<%
	int i = 0;
	for(HrPayrollProcessDetail payrollProcessDetail : detailSet){
%>
<tr>
	<td><input type="checkbox" name="<%=PAY_ELEMENT_ID %><%=i%>" value="<%=payrollProcessDetail.getId()%>"></td>
	<td><input type="text" name="<%=PAY_ELEMENT_CODE %><%=i%>" value="<%=payrollProcessDetail.getEmpPayElement().getPayElement().getPayElementDesc()%>"></td>
	<%if(payrollProcessDetail.getPayelementAmount()!= null){ %>
	<td><input type="text" name="<%=PAY_ELEMENT_AMOUNT %><%=i%>" value="<%=payrollProcessDetail.getPayelementAmount()%>"></td>
	<%}else{ %>
		<td><input type="text" name="<%=PAY_ELEMENT_AMOUNT %><%=i%>" value=""></td>
	
	<%} %>
	<td><input type="text" name="<%=PAY_ELEMENT_TYPE%><%=i%>" value="<%=payrollProcessDetail.getElementType()%>"></td>

</tr>
<% i++;
} %>

</table>

<input type="hidden"  name="<%=MONTH %>" value="<%=payrollMonth%>">
<input type="hidden"  name="<%=YEAR %>" value="<%=payrollYear%>">
<input type="hidden"  name="<%=EMPLOYEE_ID %>" value="<%=employeeId%>">
<input type="hidden"  name="<%=DEPARTMENT_ID %>" value="<%=departmentId%>">
 <input type="hidden" id="countId" name="counter" value="<%=i%>">
<input type="hidden" name="<%=PRE_PAYROLL_PROCESS_ID %>" value="<%=prePayrollProcessId%>">
<input name="save" type="button" class="button" value="Update" onClick="submitForm('updatePrePayrollProcess','payroll?method=updateProcessPrePayrollDetail');" />
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>

</form>

