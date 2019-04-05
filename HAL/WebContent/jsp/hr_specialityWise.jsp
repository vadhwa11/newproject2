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

<div id="contentHolder">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		List<HrSpecialistMaster> specialistList = new ArrayList<HrSpecialistMaster>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("specialistList") != null){
			specialistList= (List<HrSpecialistMaster>)map.get("specialistList");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
		 }
	%>

<h6>Establishment strength return</h6>

<form name="specialityWiseReport" target="_blank" method="post"
	action="">
<div id="divId" class="blockFrame">
<div class="Clear"></div>
<label><span>*</span> Speciality</label> <select name="specialityId"
	id="specialityId">
	<option value="0">Select Unit</option>
	<% for(HrSpecialistMaster hrSpecialistMaster : specialistList)
			{
			%>
	<option value="<%=hrSpecialistMaster.getId()%>"><%=hrSpecialistMaster.getSpecialistName()%></option>
	<%
			}
			%>
</select></div>

<input type="button" name="OK" value="OK" class="cmnButton"
	onClick="if(specialityWiseReport.specialityId.value!=0){submitForm('specialityWiseReport','hrRelated?method=generateSpecialityWiseReport');}else{alert('Select Speciality');}" />
<input type="reset" name="Reset" value="Cancel" class="cmnButton"
	onclick="location.reload();" accesskey="r" /></form>
</div>




