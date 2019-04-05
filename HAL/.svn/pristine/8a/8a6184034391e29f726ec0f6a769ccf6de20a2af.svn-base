<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientVisitSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>


<br />
<div id="contentHolder">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("departmentList") != null){
			departmentList= (List<MasDepartment>)map.get("departmentList");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
		 }
	%>

<h6>Department wise list of medical assistant</h6>
<div class="Clear"></div>
<form name="departmentWiseReport" target="_blank" method="post"
	action="">
<div id="divId" class="blockFrame">
<div class="Clear"></div>
<label><span>*</span> Department</label> <select
	name="<%=DEPARTMENT_ID%>" id="departmentId">
	<option value="0">Select</option>
	<% for(MasDepartment masDepartment : departmentList)
			{
			%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%
			}
			%>
</select></div>

<input type="button" name="OK" value="OK" class="cmnButton"
	onClick="if(departmentWiseReport.departmentId.value!=0){submitForm('departmentWiseReport','hrRelated?method=generateDepartmentWiseReport');}else{alert('Select Department');}" />
<input type="reset" name="Reset" value="Cancel" class="cmnButton"
	onclick="location.reload();" accesskey="r" /></form>
</div>




