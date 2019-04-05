<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_exitInterview.jsp  
 * Purpose of the JSP -  for  Generating Income Tax Computation Sheet.
 * @author  Rajat
 * Create Date: 1st April,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>

<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>



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
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");	

	Map<String,Object> map = null;
	if(request.getAttribute("map")!=null)
	{
		map = (Map)request.getAttribute("map");
	}
	
	
	List<MasEmployee> employeeList =  new ArrayList<MasEmployee>();
	if(map!=null && map.get("employeeList")!=null)
	{
		employeeList = (List)map.get("employeeList");
	}
	//List<HrMasFinancialYear> financialYearList =  new ArrayList<HrMasFinancialYear>();
	List<MasStoreFinancial> financialYearList =  new ArrayList<MasStoreFinancial>();
	if(map!=null && map.get("financialYearList")!=null)
	{
		financialYearList = (List)map.get("financialYearList");
	}
	String message = ""; 
	if(map.get("message")!=null)
	{
		message = (String)map.get("message");
	}
	Users user = null; 
	if(map.get("user")!=null)
	{
		user = (Users)map.get("user");
	}
	%>

<div class="titleBg"><h2>Income Tax Computation</h2></div>
<div class="clear"></div>

<h4><%=message %></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<form name="employeeExitInterview" method="post" action="">
 
 	<input type="hidden" name="title" value="Income Tax Computation">
  		
	<label>Employee Name</label>
	<select name="<%=EMPLOYEE_ID %>">
	<option value="0">All</option>
	<%for(MasEmployee employee:employeeList) {%>
		<option value=<%=employee.getId()%>>
		 <%=employee.getFirstName() + " " + (employee.getLastName()!= null ? employee.getLastName() :"")  %>
		</option>
	<%} %>
	</select>
	
	
	<label>Financial Year <span>* </span></label>
	<select name="<%=FINANCIAL_YEAR %>" validate="Financial Year,int,yes">
		<option value="0">Select</option>
		<%for(MasStoreFinancial finYr : financialYearList){ %>
		<option value="<%=finYr.getId() %>"><%=finYr.getFinancialYear() %></option>
		<%} %>
	</select>

<div class="clear"></div>
</div>

<div id="edited"></div>
<input type="button" name="add"     id="addbutton"	value="Compute" class="button"	onClick="submitForm('employeeExitInterview','incomeTaxMaster?method=computeIncomeTaxMonthly');" 	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" style="display:none;" class="button"	onClick="submitForm('employeePerformanceReview','personnel?method=addOrUpdateEmployeePerformaceReview');" 	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="InActivate" style="display:none;" class="button"	onClick="submitForm('employeePerformanceReview','personnel?method=deleteEmployeePerformanceReview')" accesskey="d" tabindex=1 /> 
<input type="reset" name ="Reset"   id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS%>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" /> 

	
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="division"></div>
</form>

