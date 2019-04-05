<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_employeePayElementsjsp  
 * Purpose of the JSP -  This is for Employee Pay Elements.
 * @author  Rajat  
 * Create Date: 9th Feb,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.10
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="jkt.hms.masters.business.*" %>
<%@ page import="jkt.hms.util.*" %>
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
<script type="text/javascript">

function checkMedicalAmount(){
	var element = document.getElementById('payElementId').value;
	var medicalPayElementAmount = document.getElementById('payAmountId').value;
	if(element == 5){
		if(medicalPayElementAmount > 1250){
			alert("Medical Allowance can not be higher than the limit i.e. 1250.");			
			return false; 
		}
	}
	return true;
}

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
	
	List<HrEmployeePayElements> searchEmployeePayElementsList = new ArrayList<HrEmployeePayElements>(); 
	if(mapEmployee.get("searchEmployeePayElementsList") != null){
		searchEmployeePayElementsList = (List)mapEmployee.get("searchEmployeePayElementsList");
		session.setAttribute("mapEmployeePayElement",mapEmployee);
	}
	System.out.println("searchEmployeePayElementsList=====in jsp ="+searchEmployeePayElementsList.size());
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>(); 
	if(mapEmployee.get("employeeList") != null){
		employeeList = (List)mapEmployee.get("employeeList");
	}
	
	List<MasEmployee> employeeListForSearch = new ArrayList<MasEmployee>(); 
	if(mapEmployee.get("employeeListForSearch") != null){
		employeeListForSearch = (List)mapEmployee.get("employeeListForSearch");
	}
	
	List<HrMasPayElement> payElementsList = new ArrayList<HrMasPayElement>();
	if(mapEmployee.get("payElementsList") != null){
		payElementsList = (List)mapEmployee.get("payElementsList");
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(mapEmployee.get("message") != null){
		message = (String)mapEmployee.get("message");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
%>

<div class="titleBg"><h2>Employee Pay Elements</h2></div>
<h4><%=message%></h4>
<div class="clear"></div>
<div class="Block">

	  <div id="searcharea">
	  
		  <div id="searchbar">
		  
			  <form name="search" method="post" action="">
			    <label>Employee Name</label>
				<select name="<%=EMPLOYEE_CODE %>" id='searchField'>
				<option value="">
					Select
				</option>
				<% for(MasEmployee employee: employeeListForSearch){%>
				
				<option value="<%=employee.getId() %>">
					<%=employee.getFirstName()+" " + (employee.getLastName() != null ? employee.getLastName() :"") %>
				</option>
				<%} %>
				</select>
						
					
									
					 <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','/hms/hms/personnel?method=searchEmployeePayElement','checkSearch')" tabindex=1  />
		            
		             
		            <!--  <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','personnel?method=generateReportForEmployeePayElement');" accesskey="g" tabindex=1/> -->
                     
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_employee">

		     </form>
		 </div>
 </div>
<div class="clear"></div>
 </div>
	
	<script type="text/javascript">
	
	formFields = [
	[0, "<%= COMMON_ID%>", "id"], [1,"<%= PAY_ELEMENT_CODE%>"],  [2,"<%=PAY_ELEMENT_DESC%>"],[3,"<%= PAY_AMOUNT %>"],[4,"<%= PAY_ELEMENT_TYPE %>"],[5,"<%= PAY_ELEMENT_START_DATE%>"],[6,"<%= EMPLOYEE_ID %>"],[7,"<%= STATUS %>"]];
	 statusTd = 7;
	</script>
	
	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	<form name="ancher" method="post">
</form>
	
	<div id="searchresults"></div>
	<div id="searchtable" ></div>
	<div class="division"></div>
	<% try{
		if(searchEmployeePayElementsList.size()>0 )
		 {
			String strForCode = (String)mapEmployee.get("employeeCode");
			String strForCodeFirstDescriptions = (String)mapEmployee.get("firstName");
			String strForCodeLastDescriptions = (String)mapEmployee.get("lastName");
			if(strForCode!= null && strForCode!= "" || strForCodeFirstDescriptions!= null && strForCodeFirstDescriptions!= "" || strForCodeLastDescriptions!=null && strForCodeLastDescriptions!="")
			{
	%> 
  
    <!-- <a href="personnel?method=showEmployeePayElementJsp">Show All Records</a> -->
    <a href="javascript:void(0)" onclick="submitForm('ancher','personnel?method=showEmployeePayElementJsp');">Show All Records</a>
    
	<%
			}
		 }
		}
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	 if(searchEmployeePayElementsList.size()==0 && map.get("search") != null)
	  {
	 %>
				<!-- <a href="personnel?method=showEmployeePayElementJsp">Show All Records</a> -->
				<a href="javascript:void(0)" onclick="submitForm('ancher','personnel?method=showEmployeePayElementJsp');">Show All Records</a>
				

	 <%
      }
 	%>

  
  <div class="clear"></div>
  
  <form name="employeePayElements" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasEmployee">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="FirstName">
  <input type="hidden" name="title" value = "Employee">
  <input type="hidden" name="<%=JSP_NAME %>" value = "employee">
  <input type="hidden" name="pojoPropertyCode" value = "EmployeeCode">
  <input type="hidden" id="dclick" value = "yes">
  <input type="hidden" id="rowid" value = "">
  
	  	
  
  <div class="clear"></div>
		<div class="Block" id="title1">
			<label>Employee Name <span>* </span></label>
			<select name="<%=EMPLOYEE_ID %>" id="<%=EMPLOYEE_ID %>" validate="Employee Code,string,yes" onchange="populateEmployeeBasicPay(this)" class="mediumm">
				<option value="">
					Select
				</option>
				<% for(MasEmployee employee : employeeList){%>
				
				<option value="<%=employee.getId() %>">
					<%=employee.getFirstName()+" "+(employee.getLastName() != null ? employee.getLastName() :"")%>
				</option>
				<%} %>
			</select>
			
			
			
  	  	   	<label>Pay Element Code <span>* </span></label>
		    <select name="<%=PAY_ELEMENT_CODE %>" id="payElementId" validate="Pay Element Code,string,yes" onchange="populateElementType(this)" class="mediumm">
				<option value="">
					Select
				</option>
				<%for(HrMasPayElement payElement : payElementsList){ %>
				<option value="<%= payElement.getId()%>" >
					<%=payElement.getPayElementCode() + "--" + payElement.getPayElementDesc()%>
				</option>
				<%} %>
			</select>
			 
			 
			<label>Pay Amount</label>
			<input type="text" id = "payAmountId" name="<%=PAY_AMOUNT %>" validate="Pay Amount,float,yes" />	
			
			
			<div class="clear"></div>
			
			<label>Start Date <span>* </span></label>
			<input type="text" name="<%=PAY_ELEMENT_START_DATE %>" class="calDate" validate="Start Date,date,yes" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');" validate="To Date ,date,yes"   MAXLENGTH="10"/>
			<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employeePayElements.<%=PAY_ELEMENT_START_DATE%>,'event')" validate="Pick a date" class="calender" /> --%>
						
			<label>Pay Element Type <span>* </span></label>
			<input type="text" id="<%=PAY_ELEMENT_TYPE%>" name="<%=PAY_ELEMENT_TYPE%>" value="" validate="Pay Element Type,string,no"  class="readOnly" readonly="readonly" MAXLENGTH="30" />
			
			<div class="clear"></div>
	   		
	   		
	   </div>	
	    	<div class="division"></div>
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
			
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('employeePayElements','personnel?method=addEmployeePayElement','checkMedicalAmount');" accesskey="a" />
			<input type="button" name="edit" id="editbutton" value="Update" style="display:none;" class="button" onClick="submitForm('employeePayElements','personnel?method=addEmployeePayElement','checkMedicalAmount')" accesskey="u"  />
			<input type="button" name="Delete" id="deletebutton" value="Activate" style="display:none;" class="button" onClick="submitForm('employeePayElements','personnel?method=deleteEmployeePayElement&flag='+this.value,'removeMandatory')" accesskey="d" />		
			
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onClick="submitForm('employeePayElements','personnel?method=showEmployeePayElementJsp');" accesskey="r" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="0" />
			
			<input type="hidden" name="<%= HOSPITAL_ID%>" value="" />
  	</form>
  <script type="text/javascript">

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Payment Element Code."
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%= PAY_ELEMENT_CODE %>"

data_header[1] = new Array;
data_header[1][0] = "Pay Element Desc"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%= PAY_ELEMENT_DESC %>";

data_header[2] = new Array;
data_header[2][0] = "Pay Amount"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%=PAY_AMOUNT%>"

data_header[3] = new Array;
data_header[3][0] = "Pay Element Type"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= PAY_ELEMENT_TYPE %>"

data_header[4] = new Array;
data_header[4][0] = "Start Date "
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= PAY_ELEMENT_START_DATE%>"

data_header[5] = new Array;
data_header[5][0] = "Employee"
data_header[5][1] = "data";
data_header[5][2] = 0;
data_header[5][3] = "<%= EMPLOYEE_ID %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = 0;
data_header[6][3] = "<%=STATUS%>"

data_arr = new Array();

<%
	int  counter=0;
	for (HrEmployeePayElements masEmp : searchEmployeePayElementsList) {
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%=masEmp.getId()%>



<% if(masEmp.getPayElement() != null){
	for(HrMasPayElement payElement : payElementsList)
	{
		 if((payElement.getId().equals(masEmp.getPayElement().getId())) && (masEmp.getPayElement().getStatus().equals("y") )){%>
		 			data_arr[<%= counter%>][1] = "<%=payElement.getPayElementCode() +"--"+payElement.getPayElementDesc()%>"
<%}}}else{%>
data_arr[<%= counter%>][1] = "";

<%}%>

<%if(masEmp.getPayElement().getPayElementDesc()!=null){%>
data_arr[<%= counter%>][2] = "<%=masEmp.getPayElement().getPayElementDesc()%>"
<%}else {%>
data_arr[<%= counter%>][2] = ""
<%} if(masEmp.getPayAmount() != null){
	
%>
data_arr[<%= counter%>][3] = "<%=masEmp.getPayAmount()%>"
<%}else{%>
data_arr[<%= counter%>][3] = "0.0"
<%}%>
<%if(masEmp.getPayElementType() != null){%>
data_arr[<%= counter%>][4] = "<%= masEmp.getPayElementType()%>"
<%} else {%>
data_arr[<%= counter%>][4] = ""
<%} if(masEmp.getStartDate() != null){%>
data_arr[<%= counter%>][5] = "<%= new SimpleDateFormat("dd/MM/yyyy").format(masEmp.getStartDate())%>"
<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>

<%if(masEmp.getEmployee() != null){
	for(MasEmployee employee :employeeListForSearch)
	{
	 if(employee.getId().equals(masEmp.getEmployee().getId()) && masEmp.getEmployee().getStatus().equals("y") ){
		 %>
	     data_arr[<%= counter%>][6] = "<%=employee.getFirstName()+" "+employee.getLastName()%>"
	<%}else if(employee.getId().equals(masEmp.getEmployee().getId()) && masEmp.getEmployee().getStatus().equals("n")){%>
	data_arr[<%= counter%>][6] = "<span>* </span>Parent InActivated--<%=employee.getFirstName()+" "+employee.getLastName()%>"
	<%}%>
<%}}else{%>
data_arr[<%= counter%>][6] = "";
<%}%>



<%if(masEmp.getStatus().equals("y")){%>
data_arr[<%= counter%>][7] = "Active";
<%}else{%>
data_arr[<%= counter%>][7] = "Inactive";
<%}%>
 
<%
		     counter++;
}
		
%>
formName = "employeePayElements"


 
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	
	
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');

</script>

<script type="text/javascript">


function populateEmployeeBasicPay(obj)
{
		selectedEmployeeId = obj.value;
	
	<%MasEmployee selectedEmployee = null;
	  for(MasEmployee employee :employeeList){%>
		if(<%=employee.getId()%> == selectedEmployeeId)
		{
		<%
	    Set payStructureSet = null;
		if(employee!=null){
		 payStructureSet = employee.getPayStructure();
		}
		List payStructureList =null;
		HrEmployeePayStructure employeePayStructure = null;
		Float basicPay = 0.0f;
		if(payStructureSet!=null)
		{
			payStructureList = new ArrayList(payStructureSet);
		}
		if(payStructureList!=null && !payStructureList.isEmpty())
		{
		 employeePayStructure =(HrEmployeePayStructure) payStructureList.get(0);
		 
		 if(employeePayStructure !=null)
		 	basicPay = employeePayStructure.getBasicPay().floatValue();
		}%>		
		basicPayValue = '<%=basicPay%>';
		
		}	
	<%}%>
	
	document.employeePayElements.<%=PAY_ELEMENT_CODE%>.value = '';
	document.employeePayElements.<%=PAY_ELEMENT_TYPE%>.value= '';
	document.employeePayElements.<%=PAY_AMOUNT%>.value = '';
	//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("class","");
	//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("readonly","");
	//document.getElementById('basicDependantDiv').innerHTML = '';
	//document.getElementById('basicDependantDiv').style.display  = 'none';
}


function populateElementType(obj)
{
		payElementId = obj.value;
		<%for(HrMasPayElement payElement : payElementsList){ %>
		
		if(<%=payElement.getId()%> == payElementId){
		document.employeePayElements.<%=PAY_ELEMENT_TYPE%>.value = '<%=payElement.getPayElementType()%>';
		
		if("<%=payElement.getBasicDependent()%>" == "y")
		{
		
		document.employeePayElements.<%=PAY_AMOUNT%>.value = (parseFloat('<%=payElement.getBasicMultiplier()%>')* basicPayValue)/100;
		document.employeePayElements.<%=PAY_AMOUNT%>.value = formatNumber(document.employeePayElements.<%=PAY_AMOUNT%>.value ,0);
		//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("class","readOnly");
		//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("readonly","readonly");
		//document.getElementById('basicDependantDiv').innerHTML = 'Basic Dependant ('+<%=payElement.getBasicMultiplier()%> +'% of Basic)';
		//document.getElementById('basicDependantDiv').style.display = 'block';
		}
		else
		{
		document.employeePayElements.<%=PAY_AMOUNT%>.value = '';
		//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("class","");
		//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("readonly","");
		document.getElementById('basicDependantDiv').innerHTML = '';
		document.getElementById('basicDependantDiv').style.display  = 'none';
		}
		
		}
		<%}%>
		
}
function removeMandatory()
	{
	document.getElementById('<%=EMPLOYEE_ID%>').setAttribute('validate','Employee Name,string,no');
	return true;
	}

</script>	

<script language="javascript">

function formatNumber(myNum, numOfDec)
{
var decimal = 1
for(i=1; i<=numOfDec;i++)
decimal = decimal *10

var myFormattedNum = (Math.round(myNum * decimal)/decimal).toFixed(numOfDec)
return(myFormattedNum)
}
</script>