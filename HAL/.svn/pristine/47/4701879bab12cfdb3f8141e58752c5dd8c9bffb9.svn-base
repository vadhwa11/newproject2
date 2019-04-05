<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_employeePayStructure.jsp  
 * Purpose of the JSP -  This is for Employee Pay Structure.
 * @author  Rajat  
 * Create Date: 9th Feb,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.10
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.masters.business.*" %>
<%@ page import="jkt.hms.masters.business.*" %>
<%@ page import="jkt.hms.util.*" %>
<%@page import="java.text.SimpleDateFormat"%>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>
<script language="javascript">
var $j = jQuery.noConflict();
</script>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<%	
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	}

	Map<String,Object> mapEmployee = new HashMap<String,Object>();
	
	if(request.getAttribute("map") != null){
	mapEmployee = (Map<String,Object>) request.getAttribute("map");
	}
	
	List<MasEmployee> employeeListForSearch = new ArrayList<MasEmployee>(); 
	if(mapEmployee.get("employeeListForSearch") != null){
		employeeListForSearch = (List)mapEmployee.get("employeeListForSearch");
	}
	List<HrEmployeePayStructure> searchEmployeePayStructureList = new ArrayList<HrEmployeePayStructure>(); 
	if(mapEmployee.get("searchEmployeePayStructureList") != null){
		searchEmployeePayStructureList = (List)mapEmployee.get("searchEmployeePayStructureList");
		session.setAttribute("mapEmployeePayStructure",mapEmployee);
	}
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>(); 
	if(mapEmployee.get("employeeList") != null){
		employeeList = (List)mapEmployee.get("employeeList");
	}
	
	List<HrMasPayroll> payRollList = new ArrayList<HrMasPayroll>(); 
	if(mapEmployee.get("payRollList") != null){
		payRollList = (List)mapEmployee.get("payRollList");
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	String message = "";
	if(map.get("message")!=null)
	{
		message = (String)map.get("message");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
%>

<div class="titleBg"><h2>Employee Pay Structure</h2></div>
<div class="clear"></div>
<h4><%=message %></h4>
<div class="clear"></div>
<div class="Block">

	  <div id="searcharea">
	  
		  <div id="searchbar">
		  
			  <form name="search" method="post" action="">
			    <label>Employee </label>
			<%-- <select name="<%=EMPLOYEE_CODE %>" id='searchField'> --%>
				<select name="employeeCodeSearch" id='searchField'>
				<option value="">
					Select
				</option>
				<% for(MasEmployee employee: employeeListForSearch){%>
				
				<option value="<%=employee.getId() %>">
					<%=employee.getFirstName()+" " +(employee.getLastName() != null ? employee.getLastName() :"")%>
				</option>
				<%} %>
				</select>
						
		
					 <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','/hms/hms/personnel?method=searchEmployeePayStructure','checkSearch')" tabindex=1  />

		               
		           <!--   <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','personnel?method=generateReportForEmployeePayStructure');" accesskey="g" tabindex=1/> -->
                     
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_employee">

		     </form>
		 </div>
 </div>
<div class="clear"></div>
 </div>
	
	
	<div class="clear"></div>
	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	<div id="searchresults" >
	<div class="clear"></div>
	<form name="ancher" method="post">
</form>
	
	<div id="searchtable" ></div>
	<div class="division"></div>
	<% try{
		if(searchEmployeePayStructureList.size()>0 )
		 {
			String strForCode = (String)mapEmployee.get("employeeCode");
			/* String strForCodeFirstDescriptions = (String)mapEmployee.get("firstName");
			String strForCodeLastDescriptions = (String)mapEmployee.get("lastName"); */
			if(strForCode!= null && strForCode!= "")
			{
	%> 
  
    <!-- <a href="personnel?method=showEmployeeContractJsp">Show All Records</a> -->
    <a href="javascript:void(0)" onclick="submitForm('ancher','personnel?method=showEmployeePayStructureJsp');">Show All Records</a>
	<%
			}
		 }
		}
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	 if(searchEmployeePayStructureList.size()==0 && map.get("search") != null)
	  {
	 %>
				<!-- <a href="personnel?method=showEmployeePayStructureJsp">Show All Records</a> -->
				<a href="javascript:void(0)" onclick="submitForm('ancher','personnel?method=showEmployeePayStructureJsp');">Show All Records</a>

	 <%
      }
 	%>
<script type="text/javascript">
	
	formFields = [
	[0, "<%= COMMON_ID%>", "id"],[1,"<%= EMPLOYEE_ID%>"], [2,"<%= EMPLOYEE_CODE%>"],  [3,"<%= BASIC_PAY %>"],[4,"<%= PAY_STR_FROM_DATE %>"],[5,"<%= PAY_STR_TO_DATE %>"],[6,"<%= PAYMENT_MODE%>"],[7,"<%= EMPLOYEE_NAME %>"],[8,"<%=STATUS%>"],[9,"<%=PAYROLL_ID%>"]];
	 statusTd = 8;
	</script>
	</div>
  
  <div class="clear"></div>
 
      <form name="employeeContract" method="post" action="">
      <input type="hidden" name="<%= POJO_NAME %>" value = "MasEmployee" />
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="FirstName" /> 
  <input type="hidden" name="title" value = "Employee" />
  <input type="hidden" name="<%=JSP_NAME %>" value = "employee" />
  <input type="hidden" name="pojoPropertyCode" value = "EmployeeCode" />
  <input type="hidden" id="dclick" value = "yes" />
  <input type="hidden" id="rowid" value = "" />	
  <div class="clear"></div>
		<div class="Block" id="title1">
			<label>Employee <span>* </span></label>
			<select id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>" validate="Employee,string,yes" class="mediumm">
				<option value="">
					Select
				</option>
				<% for(MasEmployee employee : employeeList){%>
				   
				<option value="<%=employee.getId() %>">
					<%=employee.getFirstName()+" " +(employee.getLastName() != null ? employee.getLastName() :"") %>
				</option>
				<%} %>
			</select>
			
			
			
  	  	   	<label>Payroll Code <span>* </span></label>
		    <select name="<%=PAYROLL_ID %>" validate="Pay Roll,string,yes" class="mediumm">
				<option value="">
					Select
				</option>
				<%for(HrMasPayroll payroll : payRollList) {%>
				<option value="<%=payroll.getId() %>">
					<%=payroll.getPayrollCode()%>
				</option>
				<%} %>
			</select>
			 
			 
			<label>Basic Pay <span>* </span></label>
			<input type="text" name="<%=BASIC_PAY %>" validate="Basic Pay,float,yes" maxlength="8"/>	
			
			<div class="clear"></div>
			
			<label>Payment Mode <span>* </span></label>
			<select name="<%=PAYMENT_MODE %>" validate="Payment Mode,string,yes" class="mediumm">
				<option value="">
					Select
				</option>
				<option value="Cheque">
					Cheque
				</option>
				<option value="Cash">
					Cash
				</option>
				<option value="Salary">
					Salary
				</option>
				<option value="DD">
					DD
				</option>
				<option value="Account Transfer">
					Account Transfer
				</option>
			</select>
			<label id="Label1">From Date <span>* </span></label>
			<input type="text"  name="<%=PAY_STR_FROM_DATE%>" id="fromDate"    value="" class="calDate"  onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');"  validate="From Date ,date,yes"  MAXLENGTH="10" onChange="startEndDateValidation()"/>
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employeeContract.<%=PAY_STR_FROM_DATE%>,event)" validate="Pick a date" /> --%>
			
			<label id="Label2">To Date <span>* </span></label>
			<input type="text"  name="<%=PAY_STR_TO_DATE%>" id="toDate"  value="" class="calDate"  onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');" validate="To Date ,date,yes"   MAXLENGTH="10" onChange="startEndDateValidation()" />
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employeeContract.<%=PAY_STR_TO_DATE%>,event)" validate="Pick a date"  /> --%>
	   		
	   		<div class="clear"></div>
	   		
	   		
	   </div>	
	    	
			<div class="clear"></div>
		
			<div class="bottom">
			
			<label >Changed By</label>   
			<label class="value" ><%=userName%></label>
			        
			<label>Changed Date</label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
			
		</div> 	
		<div class="clear"></div>
   		<div class="division"></div>
				
			<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('employeeContract','personnel?method=addEmployeePayStructure');" accesskey="a" />
			<input type="button" name="edit" id="editbutton" value="Update" style="display:none;" class="button" onClick="submitForm('employeeContract','personnel?method=addEmployeePayStructure')" accesskey="u"  />
			<input type="button" name="Delete" id="deletebutton" value="Activate" style="display:none;" class="button" onClick="submitForm('employeeContract','personnel?method=deleteEmployeePayStructure&flag='+this.value,'removeMandatory')" accesskey="d" />		
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			
			<input type="hidden" name="<%= HOSPITAL_ID%>" value="" />
  	</form>
  <script type="text/javascript">

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Employee Id."
data_header[0][1] = "hide";
data_header[0][2] = 0;
data_header[0][3] = "<%= EMPLOYEE_ID %>"

data_header[1] = new Array;
data_header[1][0] = "Employee Name"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%= EMPLOYEE_CODE %>";

data_header[2] = new Array;
data_header[2][0] = "Basic Pay"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%=BASIC_PAY%>"

data_header[3] = new Array;
data_header[3][0] = "From Date"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%= PAY_STR_FROM_DATE %>"

data_header[4] = new Array;
data_header[4][0] = "To Date"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= PAY_STR_TO_DATE%>"

data_header[5] = new Array;
data_header[5][0] = "Payment Mode"
data_header[5][1] = "data";
data_header[5][2] = 0;
data_header[5][3] = "<%= PAYMENT_MODE %>"

data_header[6] = new Array;
data_header[6][0] = "Employee Name"
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= EMPLOYEE_NAME %>"

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = 0;
data_header[7][3] = "<%= STATUS %>"

data_header[8] = new Array;
data_header[8][0] = "PayRoll Code"
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%= PAYROLL_ID %>"

data_arr = new Array();

<%
	int  counter=0;
	for (HrEmployeePayStructure masEmp : searchEmployeePayStructureList) {
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%=masEmp.getId()%>


<%if(masEmp.getId()!= null){%>
data_arr[<%= counter%>][1] = "<%=masEmp.getEmployee().getId()%>"
<%}else {%>
data_arr[<%= counter%>][1] = ""
<%} 

if(masEmp.getEmployee().getId() != null){
	Iterator itrTitleList= employeeListForSearch.iterator();
	 while(itrTitleList.hasNext())
        {
         MasEmployee  masEmployee = (MasEmployee)itrTitleList.next(); 
		 if(masEmp.getEmployee().getId().equals(masEmployee.getId()) && masEmployee.getStatus().equals("y")){%>
			data_arr[<%= counter%>][2] = "<%=masEmp.getEmployee().getFirstName()%> "
		<%}else if(masEmp.getEmployee().getId().equals(masEmployee.getId()) && masEmployee.getStatus().equals("n")){%>
			data_arr[<%= counter%>][2] = "<span>* </span>Parent InActivated--<%=masEmployee.getServiceNo()%>";
			
		<%}
}%>
<%}else {%>
data_arr[<%= counter%>][2] = "";

<%} if(masEmp.getBasicPay() != null){%>
data_arr[<%= counter%>][3] = "<%=masEmp.getBasicPay()%>"
<%}else{%>
data_arr[<%= counter%>][3] = ""
<%}%>
<%if(masEmp.getFromDate() != null){%>
data_arr[<%= counter%>][4] = "<%=new SimpleDateFormat("dd/MM/yyyy").format( masEmp.getFromDate())%>"
<%} else {%>
data_arr[<%= counter%>][4] = ""
<%} if(masEmp.getToDate() != null){%>
data_arr[<%= counter%>][5] = "<%= new SimpleDateFormat("dd/MM/yyyy").format(masEmp.getToDate())%>"
<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>
<% if(masEmp.getPaymentMode() != null){%>
data_arr[<%= counter%>][6] = "<%=masEmp.getPaymentMode()%>"
<%}else{%>
data_arr[<%= counter%>][6] = ""
<%}%>
<% if(masEmp.getEmployee().getFirstName() != null){%>
data_arr[<%= counter%>][7] = "<%=masEmp.getEmployee().getFirstName()%>"
<%}else{%>
data_arr[<%= counter%>][7] =""
<%}%>
<% if(masEmp.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}
if(masEmp.getPayroll() != null){
	Iterator itrPayRollList= payRollList.iterator();
	 while(itrPayRollList.hasNext())
        {
         HrMasPayroll  masPayRoll = (HrMasPayroll)itrPayRollList.next(); 
		 if(masEmp.getPayroll().getId().equals(masPayRoll.getId()) && masPayRoll.getStatus().equals("y")){%>
			data_arr[<%= counter%>][9] = "<%=masPayRoll.getPayrollCode()%>"
		<%}else if(masEmp.getPayroll().getId().equals(masPayRoll.getId()) && masPayRoll.getStatus().equals("n")){%>
			data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=masPayRoll.getPayrollCode()%>";
			
		<%}
        }
}else {%>
data_arr[<%= counter%>][9] = "";
<%}%>

<%
		     counter++;
}
		
%>
formName = "employeeContract"

nonEditable = ['<%= EMPLOYEE_ID%>']
 
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	
	
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>

<script>
function check(){
	var SDate = document.employeeContract.<%= PAY_STR_FROM_DATE%>.value;
	var EDate = document.employeeContract.<%= PAY_STR_TO_DATE %>.value;


	var	endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
	var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

	if(startDate > endDate)
	{
		alert("Please ensure that the To Date is greater than or equal to the From Date.");
		// document.calldate.next_day.focus();
		return false;
	}
}
function removeMandatory()
	{
	document.getElementById('<%=EMPLOYEE_ID%>').setAttribute('validate','Employee Name,string,no');
	return true;
	}
</script>	