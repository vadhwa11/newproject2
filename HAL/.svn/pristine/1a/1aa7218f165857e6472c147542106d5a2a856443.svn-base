<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.HrPayrollProcessDetail"%>
<%@page import="jkt.hms.masters.business.HrPayrollProcessHeader"%>
<%@page import="jkt.hms.masters.business.HrEmployeePayStructure"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String,Object> utilMap = new HashMap<String,Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<HrPayrollProcessHeader> prePayrollProcessList = new ArrayList<HrPayrollProcessHeader>();
				List<HrEmployeePayStructure> employeePayStructureList = new ArrayList<HrEmployeePayStructure>();
				List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
				 employeeList = (List)map.get("employeeList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				if(map.get("prePayrollProcessList")!= null){
					prePayrollProcessList = (List<HrPayrollProcessHeader>)map.get("prePayrollProcessList");
				}
				if(map.get("employeePayStructureList")!= null){
					employeePayStructureList = (List)map.get("employeePayStructureList");
				}
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
				
				String userName = "";
				if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
				}
				String message="";
				if(map.get("message") != null){
				 message = (String)map.get("message");
				//out.println(message);
				}
				if(map.get("financialList")!= null){
					financialList = (List<MasStoreFinancial>)map.get("financialList");
				}
	%>


<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.HrLoanHeader"%>
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

</script>

<% if(!message.equals("")){%>
<h4><%=message%></h4>
<%}%>

<form name="searchPrePayrollProcess" method="post" action="" >
<div class="titleBg"> <h2>Search Pre Payroll Process </h2></div>
<div class="clear"></div>
<div class="Block">

<label> Month <span>*</span></label>
<select  name="<%=MONTH %>" validate="month,string,yes" >
<option value="0">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6">June</option>
<option value="7">July</option>
<option value="8">August</option>
<option value="9">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
</select>
<label>Year <span>*</span></label>
<select  name="<%=YEAR %>" validate="Year,string,yes" >
<option value="0">Select</option>
<%for(MasStoreFinancial msf : financialList){ %>
<option value="<%=msf.getYearDescription()%>"><%=msf.getYearDescription()%></option>
<%} %>
</select>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<label> Department Name</label>
<select id="<%=DEPARTMENT_ID %>" name="<%=DEPARTMENT_ID %>" validate="Department,string,no" onchange="getEmployeeList(this)">
<option value="0">Select</option>
<%
		for(MasDepartment masDepartment :departmentList){
%>
<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
<%} %>
</select>

<label> Employee Name</label>
<select id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>" validate="Employee,string,no" ">
<option value="0">Select</option>
<%
		for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+(masEmployee.getLastName()!= null ? masEmployee.getLastName() :"") %></option>
<%} %>
</select>

<div class="clear"></div>
 

</div>

<input name="save" type="button" class="button" value="Search" onClick="submitForm('searchPrePayrollProcess','payroll?method=searchPrePayrollDetail');" />

<div class="clear"></div>
<div class="division"></div>
<div id="pageNavPosition"></div>
<%
	if(prePayrollProcessList.size()>0){
%>
<table id="searchresulttable" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  
  	
    <th scope="col">Emp.Name</th>
    <th scope="col">Year </th>
    <th scope="col">Month </th>
    <th scope="col">Department </th>
    <th scope="col">Basic</th>
    <th scope="col">Days </th>
    <th scope="col">Earning</th>
    <th scope="col">Deduction</th>
    <th scope="col">Reimb</th>
    <th scope="col">Net Salary.</th>
    
  </tr>
<tbody id="tableData">
  <%
		  	int  counter=0;
			String klass = "even";
  			for(HrPayrollProcessHeader payrollProcessHeader :prePayrollProcessList){
  				String id = "";
			 		id = "id" + counter;
			 		counter++;
			 		
			 		if(counter%2==0){
			 			klass = "even"; 
			 		}
			 		else
			 		{
			 			klass= "odd";
			 		}
  			BigDecimal basic =  new BigDecimal("0");
  			BigDecimal totalbasicAndPayElementAmt = new BigDecimal("0");
  			basic = payrollProcessHeader.getBasic();
  			Set<HrPayrollProcessDetail> detailSet = new HashSet<HrPayrollProcessDetail>();
  			detailSet = payrollProcessHeader.getHrPayrollProcessDetails();
  				BigDecimal totalAdditionPayElement = new BigDecimal("0");
  				BigDecimal totalDeductionPayElement = new BigDecimal("0");
  				BigDecimal totalReimbPayElement = new BigDecimal("0");
  				BigDecimal totalPayElement = new BigDecimal("0");
  				
  			for(HrPayrollProcessDetail payrollProcessDetail : detailSet){
  				BigDecimal payElementAmt = new BigDecimal("0");
  				if(payrollProcessDetail.getPayelementAmount() != null){
  				payElementAmt =payrollProcessDetail.getPayelementAmount();
  				}
  				//System.out.println("payElementAmt=========="+payElementAmt);
  				if(payrollProcessDetail.getElementType()!= null){
  				if(payrollProcessDetail.getElementType().equals("Addition")){
  					totalAdditionPayElement = totalAdditionPayElement.add(payElementAmt);
  				}
  				//System.out.println("totalAdditionPayElement=========="+totalAdditionPayElement);
  				if(payrollProcessDetail.getElementType().equals("Reimb")){
  					totalReimbPayElement = totalReimbPayElement.add(payElementAmt);
  				}
  				//System.out.println("totalReimbPayElement=========="+totalReimbPayElement);
  				if(payrollProcessDetail.getElementType().equals("Deduction")){
  					totalDeductionPayElement = totalDeductionPayElement.add(payElementAmt);
  				}
  				//System.out.println("in  loop totalDeductionPayElement=========="+totalDeductionPayElement);
  					totalPayElement = totalAdditionPayElement.add(totalReimbPayElement).subtract(totalDeductionPayElement);
  				}
  			}
  			//System.out.println("out of loop totalDeductionPayElement=========="+totalDeductionPayElement);
  			totalbasicAndPayElementAmt = basic.add(totalPayElement);
  			int salaryDays = payrollProcessHeader.getSalDays();
  			int totaldays = payrollProcessHeader.getTotalDays();
  			int totalMonthdays =payrollProcessHeader.getTotalMonthDays();
  			BigDecimal totalsalaryAmount =new BigDecimal(totalbasicAndPayElementAmt.intValue()*salaryDays/totalMonthdays);
  			//System.out.println("totalsalaryAmount------------"+totalsalaryAmount);
  			BigDecimal loanAmount =new BigDecimal("0");
  			BigDecimal bonusAmount =new BigDecimal("0");
  			BigDecimal advanceAmount =new BigDecimal("0");
  			BigDecimal arrearPayElementAmount =new BigDecimal("0");
  			BigDecimal arrearSalaryAmount =new BigDecimal("0");
  			BigDecimal totalSalary =new BigDecimal("0");
  			BigDecimal netSalary =new BigDecimal("0");
  			Float arrearDays =0.0f;
  			
  			if(payrollProcessHeader.getLoanInstallment()!= null){
  				loanAmount = payrollProcessHeader.getLoanInstallment();
  			}
  			if(payrollProcessHeader.getBonusAmount()!= null){
  				bonusAmount = payrollProcessHeader.getBonusAmount();
  			}
  			if(payrollProcessHeader.getAdvanceInstallment()!= null){
  				advanceAmount = payrollProcessHeader.getAdvanceInstallment();
  			}
  			if(payrollProcessHeader.getArrearPayelementAmt()!= null){
  				arrearPayElementAmount = payrollProcessHeader.getArrearPayelementAmt();
  			}
  			if(payrollProcessHeader.getArrearDays()!= null){
  				arrearSalaryAmount = payrollProcessHeader.getArrearSalaryAmt();
  			}
  			if(payrollProcessHeader.getArrearSalaryAmt()!= null){
  				arrearDays = payrollProcessHeader.getArrearDays();
  			}
  			if(payrollProcessHeader.getNetSalary()!= null){
  				totalSalary = payrollProcessHeader.getNetSalary();
  			}
  			//System.out.println("totalSalary----"+totalSalary);
  			if(salaryDays == 30 || salaryDays == 31){
  				//System.out.println("in if----");
  				netSalary = totalSalary; 
  			}else if(salaryDays < 30 && salaryDays <31){
  				netSalary =totalsalaryAmount.add(arrearSalaryAmount).add(arrearPayElementAmount).add(bonusAmount).subtract(loanAmount).subtract(advanceAmount);	
  			}
  			
  		//netsalary = (totalsalaryAmount.add(arrearSalaryAmount).add(arrearPayElementAmount).add(bonusAmount).subtract(loanAmount).subtract(advanceAmount)).intValue();
  		String url = "payroll?method=editPrePayrollDetail&"+PRE_PAYROLL_PROCESS_ID +"="+payrollProcessHeader.getId()+"&"+FLAG+"="+payrollProcessHeader.getFlag()+"";
  		//String url = "payroll?method=editPrePayrollDetail&"+PRE_PAYROLL_PROCESS_ID +"="+payrollProcessHeader.getId();
  %>
  
  <tr class=<%= klass%> id="<%=counter%>" onclick="submitFormForButton('searchPrePayrollProcess','<%=url %>')"/>
 
 <%
 		for(MasEmployee masEmployee :employeeList){
 		
 			if(masEmployee.getId().equals(payrollProcessHeader.getEmployee().getId())){	
 				//System.out.println("payroll process employee============="+masEmployee.getFirstName()+" "+masEmployee.getLastName());
 		
 %>
    <td> <a href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')" ><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></a></td>
<%
 			}
 	}
%>    
   <%if(payrollProcessHeader.getYear()!= null){ %> 
 	<td><a href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')" ><%=payrollProcessHeader.getYear() %></a></td>
 	<%}else{ %>
 	 	<td><a href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')" >--</a></td>
 	
 	<%} %>
 	<%if(payrollProcessHeader.getMonth()!= null){ %>
 	<td> <%=HMSUtil.convertMonth(payrollProcessHeader.getMonth()) %> </td>
 	<%}else{ %>
 	<td>--</td>
 	<%} %>
<%
		for(MasDepartment masDepartment :departmentList){
			if(masDepartment.getId().equals(payrollProcessHeader.getDepartment().getId())){
%>
 	<td><a href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')" ><%=masDepartment.getDepartmentName() %></a></td>
<%
		}
  	}
%>

 	<td><a href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')" ><%=basic %></a></td>

 	<td><a href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')" ><%=payrollProcessHeader.getTotalMonthDays() %></a></td>
 	<td><a href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')" ><%=totalAdditionPayElement %></a></td>
 	<td><a href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')" ><%=totalDeductionPayElement %></a></td>
 	<td><a href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')" ><%=totalReimbPayElement %></a></td>
 	<td><a href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')" ><%=netSalary %></a></td>
 	
  </tr>
<%} %>
</tbody>
</table>
<%
		
  	}else{
 %>
 <label>No Record Exists</label>
 <%} %>
<!--table ends-->
<script>
	  var pager = new Pager('tableData',15); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);

	  </script>
</form>

<script>
function getEmployeeList(obj)
{
	
	 sel = document.getElementById('<%=EMPLOYEE_ID %>');
	 removeAllOptions(sel);
		sel.options.add(new Option('All' , '0'));
	if(obj.value == '0')
	{
		removeAllOptions(sel);
		sel.options.add(new Option('All' , '0'));
		<%
		for(MasEmployee masEmployee :employeeList){
		%>
		sel.options.add(new Option('<%=masEmployee.getFirstName()+ " " +(masEmployee.getLastName()!= null ? masEmployee.getLastName() :"")%>' , '<%=masEmployee.getId()%>'));
		<%}%>
	}
	
			<%
			
			for(MasEmployee employee:employeeList){%>

			if(obj.value == <%=employee.getDepartment().getId()%> ){ 
				
				sel.options.add(new Option('<%=employee.getFirstName()+ " " + (employee.getLastName()!= null ? employee.getLastName() :"")%>' , '<%=employee.getId()%>'));
			
			} 
			<%}%>			
	
}


function removeAllOptions(selectbox)
	{
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}
</script>