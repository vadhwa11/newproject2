<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  shailesh
* Create Date: 13 march 2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script>
 var flag;
 </script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<MasEmployee>employeeList = new ArrayList<MasEmployee>();
	if(map.get("allEmployeeList")!=null){
		employeeList=(List<MasEmployee>)map.get("allEmployeeList");
	}
	
	
	%>
<div id=referredDoctarsIdDiv><label >Referred
Doctars </label> <select name="referredDoctarsId" tabindex="1" multiple="4"
	size="3" id="referredDoctarsId" class="list">
	<option value="">Select</option>
	<% for (MasEmployee masEmployee : employeeList)
	  	   { 
		String mname="";
		String lname="";
		if(masEmployee.getMiddleName()!=null)
		{
			mname=masEmployee.getMiddleName();
		}
		if(masEmployee.getLastName()!=null)
		{
			lname=masEmployee.getLastName();
		}
		%>
	<option value="<%=masEmployee.getId ()%>"><%=masEmployee.getFirstName()%>
	<%=mname %> <%=lname%></option>
	<% } %>

</select></div>
