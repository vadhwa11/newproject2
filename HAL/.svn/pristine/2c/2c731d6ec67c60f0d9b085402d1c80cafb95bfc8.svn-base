<%@page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();	
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<MasStoreFinancial> hrMasFinancialYearList = new ArrayList<MasStoreFinancial>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				
				if(map.get("hrMasFinancialYearList")!=null)
				{
					hrMasFinancialYearList =(List<MasStoreFinancial>)map.get("hrMasFinancialYearList");
				}
	%>


<%@page import="jkt.hms.masters.business.MasDepartment"%>
<form name="monthlyBankAdvice" method="post" action="" >
<div class="titleBg"> <h2>Monthly Bank Advice</h2></div>
<div class="clear"></div>
<div class="Block">

<label><span>*</span>Department</label>
		<select name="department" validate="Department,string,no" onChange="populateEmployee2(this.value,'monthlyBankAdvice')"  >
		<option value="0">Select</option>
		<%
			for (MasDepartment masDepartment : departmentList) {
		%>
		<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
					
		<%
						}
					%>
		</select>
<label><span>*</span>From Employee</label>
<select name="fromEmpCode" id="fromEmployeeId" validate="Employee Code,string,no"  >
<option value="0">All</option>
<%
	for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " " +masEmployee.getLastName()%></option>
			
<%
	}
%>
</select>

 
		
		<script>   
		var empArr1 = new Array();
		var empArr2 = new Array();
    	 <%
int counter=0;
for (MasDepartment masDepartment :departmentList) 
{
for (MasEmployee masEmployee :employeeList) 
{
	if(masEmployee.getDepartment() != null){
		if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
%>
empArr1[<%=counter%>] = new Array();
empArr1[<%=counter%>][0] = <%=masDepartment.getId()%>;
empArr1[<%=counter%>][1] = <%=masEmployee.getId()%>;									
empArr1[<%=counter%>][2] = "<%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%>";
<%
counter++;
}
}
}
}
%>
</script> 
    	 <label><span>*</span>To Employee</label>
    	<select name="toEmpCode" id="toEmployeeId" validate = "Employee string,no">
    	<option value="0">All</option>
    	<%
			for(MasEmployee masEmployee:employeeList)
			{				
		%>
		<option value="<%= masEmployee.getId() %>"><%=masEmployee.getFirstName()%> <%=masEmployee.getLastName()%></option>
		
		<%} %>
    	</select>
    	
<script>    	 
    	 <%
 counter=0;
for (MasDepartment masDepartment :departmentList) 
{
for (MasEmployee masEmployee :employeeList) 
{
	if(masEmployee.getDepartment() != null){
		if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
%>
empArr2[<%=counter%>] = new Array();
empArr2[<%=counter%>][0] = <%=masDepartment.getId()%>;
empArr2[<%=counter%>][1] = <%=masEmployee.getId()%>;									
empArr2[<%=counter%>][2] = "<%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%>";
<%
counter++;
}
}
}
}
%>
</script>     	

<div class="clear"></div>
<label><span>*</span> Month</label>
<select  name="<%=MONTH %>" validate="Month,string,yes" ">
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

<label><span>*</span>Year</label>
<select  name="<%=YEAR %>" validate="Year,string,yes" ">
<option value="">Select</option>
			<%if(hrMasFinancialYearList != null)
			{
				for(MasStoreFinancial hrMasFinancial : hrMasFinancialYearList)	
				{%>
					<option value="<%=hrMasFinancial.getYearDescription()%>" ><%=hrMasFinancial.getFinancialYear() %></option>
				<% }
			}
			%>			    
</select>	


<div class="clear"></div>

<input name="Ok" type="button" class="button" value="View" onclick="submitForm('monthlyBankAdvice','payroll?method=printMonthlyBankAdvice');"/>

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
</div>

<script type="text/javascript">

function populateEmployee2(val,formName){
    obj1 = eval('document.'+formName+'.fromEmployeeId');
	obj2 = eval('document.'+formName+'.toEmployeeId');
	obj1.length = 1;
	obj2.length = 1;
	
	for(i=0;i<empArr1.length;i++){
		if(empArr1[i][0]==val){
			obj1.length++;
			obj1.options[obj1.length-1].value=empArr1[i][1];
			obj1.options[obj1.length-1].text=empArr1[i][2];			
		}
	}
	for(j=0;j<empArr2.length;j++){
		if(empArr2[j][0]==val){
			obj2.length++;
			obj2.options[obj2.length-1].value=empArr2[j][1];
			obj2.options[obj2.length-1].text=empArr2[j][2];			
		}
	}
}

</script>

</form>

