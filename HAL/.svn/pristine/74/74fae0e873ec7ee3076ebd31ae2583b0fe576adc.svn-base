<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@page import="jkt.hms.masters.business.HrMasFinancialYear"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HrMasItaxSecInvestment"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.masters.business.HrEmployeeInvestment"%>
<%@page import="java.math.BigDecimal"%>

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
<%
Map map = new HashMap();
List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
List<HrMasItaxSecInvestment> hrMasItaxSecInvestmentList = new ArrayList<HrMasItaxSecInvestment>();
List<MasStoreFinancial> hrMasFinancialYearList = new ArrayList<MasStoreFinancial>();
List<HrEmployeeInvestment> existingList = new ArrayList<HrEmployeeInvestment>();
MasEmployee emp = new MasEmployee();
MasStoreFinancial finYear = new MasStoreFinancial();
if(request.getAttribute("map")!=null)
{
	map= (Map)request.getAttribute("map");
}
if(map.get("emp")!=null)
{
	emp= (MasEmployee)map.get("emp");
}
if(map.get("finYear")!=null)
{
	finYear= (MasStoreFinancial)map.get("finYear");
}
if(map.get("masEmployeeList")!= null){
	masEmployeeList = (List)map.get("masEmployeeList");
}
if(map.get("hrMasItaxSecInvestmentList")!= null){
	hrMasItaxSecInvestmentList = (List)map.get("hrMasItaxSecInvestmentList");
}
if(map.get("existingList")!= null){
	existingList = (List)map.get("existingList");
}
if(map.get("hrMasFinancialYearList")!= null){
	hrMasFinancialYearList = (List<MasStoreFinancial>)map.get("hrMasFinancialYearList");
}
String userName = "";
if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
}
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String sdate = (String) utilMap.get("currentDate");
String time = (String)  utilMap.get("currentTime");

String message="";
	if (map.get("msg") != null) {
		 message = (String) map.get("msg");
		//out.println(message);
	}
%>
<%if(!message.equals("")){%>

<h4><%=message %></h4>


<%}%>
<div class="titleBg"><h2>Employee Investment</h2></div>

<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<form name="employeeInvestment" method="post"  >
		
 </tbody>
		  
</table>

  	<label>Investment Year</label>
		<select id="invYear" name="invYear11"> 
		<option id="0" value="0">Select</option>
		<%
		      for(MasStoreFinancial hrMasFinancialYear : hrMasFinancialYearList)
			 
		{%>
		<option id="<%=hrMasFinancialYear.getId()%>" value="<%=hrMasFinancialYear.getId() %>"><%=hrMasFinancialYear.getFinancialYear() %></option>
		<%} %>
	</select>
		 
	<label >Employee <span>*</span></label>
			<select name="empid1" id="empid1" validate="Employee,int,yes" tabindex=1 onchange="submitForm('employeeInvestment','/hms/hms/incomeTaxMaster?method=checkEmployeeInvestment')">
			<option value="0">Select</option>
			  <% 
				for (MasEmployee  masEmployee : masEmployeeList){
					String Empname=masEmployee.getFirstName()+" ";
					if(masEmployee.getLastName() != null){
						Empname += masEmployee.getLastName();
					}
			  %>
		    
			  <option value="<%=masEmployee.getId()%>"><%=Empname%></option>
			  		  
			  <%}%>
	</select>
	<div class="clear"></div>
	<%if(finYear!=null)
	{if(finYear.getYearDescription()!=null){ %>
	 	<label name="yrName"><%=finYear.getYearDescription() %></label>
		  <label name="empName"><%=(emp.getFirstName()+" "+emp.getLastName()) %></label>
		  <%}}else{ %>
		  <label name="yrName"></label>
		  <label name="empName"></label>
		  <%} %> 
		  <input type="hidden" name="empid" id="empid" value="<%=emp.getId()%>" >
		  <input type="hidden" name="invYear" id="invYear" value="<%=finYear.getId()%>" >
	<div class="clear"></div>
	<table id="secInvestList" width="100%" >
 	 <tr>
 	 	<th>Section</th>	
 	 	<th>Investment</th> 	
 	 	<th>Amount</th>
 	 	<th>Investment Date</th>
 	 	<th>Max. Amount</th>
 	 	<th>Proofs</th></tr>		
		<tbody id = "tableData12">
			<%int i=1;
			if(hrMasItaxSecInvestmentList!=null && hrMasItaxSecInvestmentList.size()>0)
			{
				%>
				<input type="hidden" name="listLen" id="listLen" value="<%=hrMasItaxSecInvestmentList.size()%>" >
				<%
				
				
		      for(HrMasItaxSecInvestment obj : hrMasItaxSecInvestmentList){
		    	  BigDecimal amt = new BigDecimal("0");
		    	Date invDate = new Date(); 
		    	MasStoreFinancial finYear2 = null; 
		    	List<String> docs = new ArrayList();
		    	HrEmployeeInvestment employeeInvestment = null;
		    	  for(HrEmployeeInvestment invObj : existingList)
		    	  {
		    		  
		    		  
		    	  	if(invObj.getSecInvest().getId().equals(obj.getId()))
		    	 	 {
		    	  	  docs = (List)map.get(invObj.getSecInvest().getInvestmentType().getInvestmentDescription());
		    	  	  amt=invObj.getInvAmount();
		    		  invDate = invObj.getInvDate();
		    		  finYear2 = invObj.getInvYear();
		    		  employeeInvestment = invObj;
		    	  	}
		      	}
			  if(i%2==0)
		   		{%>
					<tr class="odd"  onclick="">		  
				<%}else{%>
		  			<tr class="even" onclick="">		  				  		
				<%} %>
				
				<input type="hidden"  name="invSec<%=i %>" id="invSec<%=i %>" value="<%=obj.getId() %>" >
				<td  width="20%" id="td1<%=i %>"><%=obj.getHrMasItaxExemption().getSectionCode() %></td>
				<td  width="40%" id="td2<%=i %>"><%=obj.getInvestmentType().getInvestmentDescription()%></td>
				<td  width="10%" id="td3<%=i %>"><div align="center"> <input type="text" name="amount<%=i %>" id="amount<%=i %>" value="<%=amt %>" validation='Amount,int,yes'  onblur="setDateOfEntry(this.value,'<%=i %>')"></div></td>
				<td  width="20%" id="td4<%=i %>">
				<input type="text" id="date<%=i %>" name="date<%=i %>" value="<%=HMSUtil.convertDateToStringWithoutTime(invDate) %>" class="calDate" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');" validate="Date,date,no"  MAXLENGTH="30" />
				<%-- <img src="/erp/jsp/images/cal.gif" onClick="javascript:setdate('',document.getElementById('date<%=i %>'),event)" width="16" height="16" border="0" validate="Pick a date" class="calender" /> --%> 
			
				</td>
				<td  width="10%" id="td5<%=i %>"><%=obj.getMaxAmount() %></td>
				<td>
				<%
				int j = 1;
				for(String file : docs) {
				 
				%>
				<h4><a target="_blank" href="<%="../uploads/docITproofs/"+ finYear2.getFinancialYear() + "/" +emp.getEmployeeCode()+"/"+ employeeInvestment.getSecInvest().getInvestmentType().getInvestmentDescription()+"/"+file%>">Doc<%=j%></a></h4>
				<%
				j++;
				} %>
				</td>
				</tr>
			  <%i++;}}%>
					
	
	   </tbody>
		  
</table>
		
	 <div class="paddingTop40"></div>
	 <div>
	<!--   <input type="button" name="update" value="Update" class="button">  -->
	<!-- <input type="button" name="Submit" value="Submit" class="button" onclick="removeValidation();submitForm('employeeInvestment','/erp/erp/incomeTaxMaster?method=saveEmployeeInvestment')"> -->
	<!--  <input type="button" name="cancel" value="Cancel" class="button"> -->
	<!--  <input type="reset" name ="Reset" id="reset" value ="Reset" class="button" />  -->
	 
	</div>
	
	 <div class="paddingTop15"></div>
    	<div class="clear"></div>
    	
    	<div class="bottom">
        <label>Changed By</label>   
		<label class="value"><%=userName%></label>
		<label>Changed Date</label>   
		<label class="value"><%=sdate%></label>
		<label>Changed Time</label>   
		<label class="value"><%=time%></label>
		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=sdate%>"  />
		<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
		</div>
		<div class="clear"></div>
   		<div class="paddingTop40"></div>
 </form>

</div>
<script>
		var pager = new Pager('tableData12',10); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
</script>
<script type="text/javascript">
		function populateEmpInfo(eid,empCode,Fname,Lname)
		{
			//document.getElementById("empid").value=eid;
						document.getElementById('labelsDiv').style.display="block";
			document.getElementById('Ecode').innerHTML=empCode;
			document.getElementById('Ename').innerHTML=Fname+" "+Lname;
			//document.getElementById('year').innerHTML=2009;
		}

		function setDateOfEntry(val,index)
		{
			if(val==="")
			{
			document.getElementById("date"+index).value='';
			}
			else{
			document.getElementById("date"+index).value='<%= HMSUtil.convertDateToStringWithoutTime(new Date())%>';
			}
		}
		function chkIfEmpSelected(field)
		{
			if(document.getElementById('labelsDiv').style.display==="none")
			{
				alert("Please Select Employee First !");
				field.value="";
				document.getElementById("employeeList").focus();
			}
		}
		function removeValidation()
		{
			document.getElementById("empid1").setAttribute("validate","");
		}
		
</script>