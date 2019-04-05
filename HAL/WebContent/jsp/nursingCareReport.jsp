<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 *nursingCareReport.jsp  
 * Purpose of the JSP -  This is for Nursing Care Report.
 * @author  Dipali
 * Create Date: 29 March,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>

<script type="text/javascript"
	language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<div class="titleBg">
<h2>Nursing Care Report</h2>
</div>
<%
			 	String userName = "";
	 			int deptId =0;
	 			int careType =0;
	 			
	 			String hinNo ="";
	 			String serviceNo ="";
	 			int nursingCareType =0;
	 			
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			 	List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();
			 	List<Object> list = null;
			 	Date toDate  = null;
				Date fromDate=null;
			 	
				if (map.get("hinNo") != null) {
					hinNo = (String) map.get("hinNo");
			 	}
				if (map.get("serviceNo") != null) {
					serviceNo = (String)map.get("serviceNo");
			 	}
				if (map.get("nursingCareType") != null) {
					nursingCareType =Integer.parseInt(""+map.get("nursingCareType")) ;
			 	}
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");
			 	}
			 	if (map.get("nursingCareList") != null) {
			 		nursingCareList = (List<MasNursingCare>) map.get("nursingCareList");
			 	}
			 	if (map.get("toDate") != null) {
			 		toDate = (Date) map.get("toDate");
			 		session.setAttribute("toDate", toDate);
			 	}
			 	if (map.get("careType") != null) {
			 		careType = Integer.parseInt(""+map.get("careType")) ;
			 	}
			 	if (map.get("deptId") != null) {
			 		deptId = Integer.parseInt(""+map.get("deptId")) ;
			 	}
			 	if (map.get("fromDate") != null) {
			 		fromDate = (Date) map.get("fromDate");
			 		session.setAttribute("fromDate", fromDate);
			 	}
			 %>

<form name="search" target="_blank" method="post" action="">
<div class="clear"></div>
<div class="Block">
<label>Care</label>
<input type="radio" name="carePatient" value="c" id="careRad" class="radio" onclick="enableCare()">
<label>Patient</label>
<input type="radio" name="carePatient" value="p" id="patientRad" class="radio" onclick="enableCare()" checked="checked">
<div class="clear"></div>
<label>From Date </label> 
<input type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currenDate %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currenDate %>',document.search.<%=FROM_DATE%>,event)" />

<label>To Date </label> 
<input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currenDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate %>',document.search.<%=TO_DATE%>,event)" />

<!--<label>Service No.:</label> <input type="text" id="serviceNo."-->
<!--	name="<%=SERVICE_NO%>" value="<%=serviceNo%>" MAXLENGTH="20"-->
<!--	onblur="getHinNo('search','ipd?method=getHinNo&flag=ipd')" />-->

<div class="clear"></div>

<!--<div id="hinDiv"><label><span>*</span>Hin:</label> <input-->
<!--	type="text" name="<%=HIN_NO%>" value="<%=hinNo%>" MAXLENGTH="30"-->
<!--	onchange="submitProtoAjax('search','ipd?method=getPatientName')"-->
<!--	validate="Hin,,yes" /></div>-->


<label>Nursing Care Type <span>*</span> </label> 
<select
	id="nursingCareId" name="<%=NURSING_CARE_ID %>"
	 disabled="disabled">
	<option value="0">Select</option>
	<%
							for (MasNursingCare masNursingCare : nursingCareList) {
								if(nursingCareType==masNursingCare.getId()){
						%>
	<option value="<%=masNursingCare.getId() %>" selected="selected"><%=masNursingCare.getNursingName()%></option>
	<%}else{ %>
	<option value="<%=masNursingCare.getId() %>"><%=masNursingCare.getNursingName()%></option>
	<%}}%>
</select>
<label> Ward<span>*</span>  </label> 
<select id="departmentId"
	name="<%=DEPARTMENT_ID %>" validate="Ward,,yes">
	<option value="0">Select</option>
	<%
							for (MasDepartment masDepartment : departmentList) {
								if(deptId==masDepartment.getId()){
						%>
	<option value="<%=masDepartment.getId()%>"
		selected="selected"><%=masDepartment.getDepartmentName()%></option>

	<%}else{ %>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>

	<%
						}}
					%>
</select>
<div class="clear"></div>
<label>Service No. <span>*</span></label> 
<input type="text" id="serviceNo" name="serviceNo" value=""  MAXLENGTH="30" onblur="getPatientName(this.value)"/> 

<div id="hinDiv"><label> HIN <span>*</span></label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="50" id="hinId"
	onchange="getAdNo(this.value);" /></div>

<div id=adDiv>
<label>A&D No. <span>*</span></label> 
<input type="text" id="adNo" name="adNo" value="" MAXLENGTH="30" /> 
</div>
<div class="clear"></div>
<label>Output To</label>
<select name="outputTo">
<option value="0">Select</option>
<option value="p">Pdf</option>
<option value="w">Word</option>
</select>
<label>File Name</label>
<input type="text" value="" name="fileName"  id="fileName">
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="if(checkEntry()){submitForm('search','ipd?method=showNursingCareReport');}" />
	<input type="hidden" name="flagReport" value="NursingCareReport">
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>
<script>
function enableCare(){
	if(document.getElementById('careRad').checked==true){
		document.getElementById('nursingCareId').disabled=false;
		document.getElementById('serviceNo').disabled=true;
		document.getElementById('hinId').disabled=true;
		document.getElementById('adNo').disabled=true;
		document.getElementById('serviceNo').value="";
		document.getElementById('hinId').value="";
		document.getElementById('adNo').value="";
		}
	else if(document.getElementById('careRad').checked==false){
		document.getElementById('nursingCareId').disabled=true;
		document.getElementById('serviceNo').disabled=false;
		document.getElementById('hinId').disabled=false;
		document.getElementById('adNo').disabled=false;
	}
}

function checkEntry(){
	if(document.getElementById('careRad').checked==true){
		if(document.getElementById('nursingCareId').value==0){
		alert("Please Select Care Type !!");
			return false;
			}
		}
	if(document.getElementById('patientRad').checked==true){
		if(document.getElementById('serviceNo').value==""){
			alert("Please Enter Service No. !!");
				return false;
				}
		if(document.getElementById('hinId').value==""){
			alert("Please Select Hin !!");
				return false;
				}
		if(document.getElementById('adNo').value==""){
			alert("Please Select A&D No. !!");
				return false;
				}
		var fileName="";
		fileName=document.getElementById('fileName').value;
		if(trimAll(fileName) != ""){
			if(validateGoodString(fileName)==false){
				alert("Please Enter Valid Name !!");
				return false;
			}
		 }
			
	}
	return true;
}
function getPatientName(val)
{
	submitProtoAjaxWithDivName('search','/hms/hms/ipd?method=showPatientHinNo&paramName='+val+'&flag=s','hinDiv');
//	submitProtoAjaxforPatientName('cashSheet','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=s');
}

function getAdNo(val)
{
	//submitProtoAjaxforAdNo('cashSheet','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=p');
	submitProtoAjaxWithDivName('search','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=p&flag1=t','adDiv');
}

</script>

