<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : dmoCallRegister.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 17.03.2011    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasStation"%>

<%@page import="jkt.hms.masters.business.MasLocation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script>
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
<form name="dmoCallRegister" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
 
 		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("doctorList") != null){
			doctorList= (List<MasEmployee>)map.get("doctorList");
		}
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
	%>
	<h4><%=message %></h4>
<div class="titleBg"><h2>DMO Call Register</h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="Block">
<label><span>*</span> Service No.</label> 
<input type="text" name="<%= SERVICE_NO %>" value="" onblur="submitProtoAjax('dmoCallRegister','/hms/hms/registration?method=getOutPatientHinNo&flag=dmo');" validate="Service No,stirng,yes">
<label><span>*</span> HIN No.</label> 
<div id="testDiv">
<input type="text" name="<%= HIN_NO %>" value="" />
</div>
<label>Service Type</label>
<input type="text" id="servType" name="<%= SERVICE_TYPE_NAME %>" value="" readonly="readonly">

<div class="Clear"></div>
<label>Service Status</label>
<input type="text" id="servStatus" name="" value="" readonly="readonly">
 
 
<label>Rank</label> 
<input type="text" id="rank" name="" value="" readonly="readonly">

<label>First Name</label> 
<input type="text" id="fName" name="" value="" readonly="readonly">

 <div class="Clear"></div>
<label>Middle Name</label> 
<input type="text" id="mName" name="" value="" readonly="readonly">

<label>Last Name</label> 
<input type="text" id="lName" name="" value="" readonly="readonly">

<label>Sex</label> 
<input type="text" id="sex" name="" value="" readonly="readonly">

<div class="Clear"></div>
<label>DOB</label> 
<input type="text" id="dob" name="" value="" readonly="readonly">

<label>Age</label> 
<input type="text" id="age" name="" value="" readonly="readonly">

<label>Command</label> 
<input type="text" id="command" name="" value="" readonly="readonly">

<div class="Clear"></div>
<label>Station</label> 
<input type="text" id="station" name="" value="" readonly="readonly">

<label>Unit</label> 
<input type="text" id="unit" name="" value="" readonly="readonly">

<label>Section</label> 
<input type="text" id="section" name="" value="" readonly="readonly">

<div class="Clear"></div>

<label>Trade/Branch</label> 
<input type="text" id="trade" name="" value="" readonly="readonly">

<label>Serving Time</label>
<input type="text" id="service" name="" value="" readonly="readonly">
 
<label>Blood Group</label> 
<input type="text" id="bldGrp" name="" value="" readonly="readonly">

<div class="Clear"></div>
<label>Telephone No.</label> 
<input type="text" id="phoneNo" name="" value="" readonly="readonly">

<label>Mobile No.</label> 
<input type="text" id="mobileNo" name="" value="" readonly="readonly">

<label><span>*</span> Patient Reported Date</label> 
<input	type="text" name="<%=REPORTED_DATE %>" value="<%= currentDate %>" MAXLENGTH="30" id="reportedDate" validate="Patient Reported Date,string,yes" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.dmoCallRegister.<%=REPORTED_DATE %>,event)" /> 


<div class="Clear"></div>
<label><span>*</span> Patient Reported Time</label> 
<input type="text" id="" name="<%= REPORTED_TIME %>" value="<%= time %>" onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);" validate="Patient Reported Time,string,yes" maxlength="8">

<label><span>*</span> Call Sent Date</label> 
<input	type="text" name="<%=CALL_SENT_DATE %>" value="<%= currentDate %>" MAXLENGTH="30" id="callSentDate" validate="Call Sent Date,string,yes" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.dmoCallRegister.<%=CALL_SENT_DATE %>,event)" /> 


<label><span>*</span> Call Sent Time</label> 
<input type="text" id="" name="<%=CALL_SENT_TIME %>" value="<%= time %>"  maxlength="8" validate="Call Sent Time,string,yes" onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);">

<div class="Clear"></div>

<label><span>*</span> Duty Medical Officer</label> 
<select name="<%=MEDICAL_OFFICER_ID %>" validate="Medical Officer,string,yes">
	<option value="0">Select</option>
	<% 
			for(MasEmployee employee : doctorList)
			{
			%>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()+" "+employee.getLastName() %></option>
	<%
			}
			%>
</select> 

<label><span>*</span> DMO Attended Date</label> 
<input	type="text" name="<%=DMO_ATTND_DATE %>" value="<%= currentDate %>" MAXLENGTH="30" id="dmoAttndDate" validate="DMO Attended Date,string,yes" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.dmoCallRegister.<%=DMO_ATTND_DATE %>,event)" /> 


<label><span>*</span> Call Attended Time</label> 
<input type="text" id="callAttndTime" name="<%=CALL_ATTND_TIME %>" maxlength="8" validate="Call Attended Time,string,yes"  value="<%= time %>" onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);">

<div class="Clear"></div>
<label><span>*</span> Disposal to Patient</label> 
<input type="text" id="" name="<%=DISPOSAL %>" value="" validate="disposal,string,yes"  maxlength="100">
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('dmoCallRegister','/hms/hms/registration?method=saveDMOCallRegisterDetails');"
	value="Submit" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />

<div class="Clear"></div>
<div class="division"></div>
 <div class="bottom">
<label>Changed By:</label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date:</label>   
<label class="value"><%=currentDate%></label>
 
<label>Changed Time:</label>   
<label class="value"><%=time%></label>
 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>"  />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>"  value="<%=time%>" />
<div class="Clear"></div>

</div>
</form>
