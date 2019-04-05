<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * appointmentListReport.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Report Day Wise.
 * @author  Vishal
 * Create Date: 12 September,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.1  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<div id="contentHolder">
<%
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			
		 	if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>) map.get("departmentList");
			}
			
			
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");

	%>

<div class="Clear"></div>
<h6>Appointment List Day Wise</h6>
<div class="blockFrame">
<form name="AppSetupDayWiseList" target="_blank" method="post" action="">
<div id="divId">
<div class="Clear"></div>
<label><span>*</span> Department</label>
<select disabled="disabled"	id="departmentId" name="<%=DEPT_ID %>" validate="Department,num,no">
	<option value="0">Select</option>
	<%for (MasDepartment masDepartment : departmentList) { %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%}%>
</select>

<label>Days</label>
<select id="day" name="<%=DAY %>"	validate="Days,string,no">
	<option value="">Select</option>
	<option value="sunday">Sunday</option>
	<option value="monday">Monday</option>
	<option value="tuesday">Tuesday</option>
	<option value="wednesday">Wednesday</option>
	<option value="thursday">Thursday</option>
	<option value="friday">Friday</option>
	<option value="saturday">Saturday</option>
</select>
<div class="Clear"></div>

<label>All Department</label>
<input type="radio" class="radio"	name="<%=SELECTED_RADIO  %>" checked="checked"	onclick="enableDisableDepart(this)" value="1" />
<label>Department Wise</label>
<input type="radio"	class="radio" name="<%=SELECTED_RADIO  %>"	onclick="enableDisableDepart(this)" value="2" />
<div class="Clear"></div>

</div>
</form>

</div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"	onClick="submitForm('AppSetupDayWiseList','appointment?method=generateAppointmentSetupDayWiseReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"	onclick="location.reload();" accesskey="r" />
</div>
<script type="text/javascript">
	function checkAsOn(){

	  if(document.getElementById('hospitalStaffId').value=='y'){
		document.getElementById('divId').style.display = 'none';
		}else{
		alert("-")
		submitForm('AppSetupDayWiseList','/hms/hms/appointment?method=showAppointmentSetupDayWiseReportJsp');
		}
		
	}
	function enableDisableDepart(obj){
		if(obj.value == "1"){
	        document.getElementById('departmentId').setAttribute("validate","Department,num,no");	
			document.getElementById('departmentId').disabled=true;
		}
		if(obj.value == "2"){
	        document.getElementById('departmentId').setAttribute("validate","Department,num,yes");	
			document.getElementById('departmentId').disabled=false;
		}
	}
	
    </script>

