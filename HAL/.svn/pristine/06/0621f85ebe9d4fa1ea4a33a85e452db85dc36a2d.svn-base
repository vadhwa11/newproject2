<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientTransferSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasStation"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>


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
<form name="emergencyPerforma" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAircraftType> aircraftTypeList = new ArrayList<MasAircraftType>();
		List<MasStation> stationList = new ArrayList<MasStation>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
	
		if(map.get("doctorList") != null){
			doctorList= (List<MasEmployee>)map.get("doctorList");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTimeWithoutSc");
 
 		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
	%>
	<h4><%=message %></h4>
<div class="titleBg"><h2>Other Emergency</h2></div>
<div class="Clear"></div>
<div class="Block">
<label> Call Date <span>*</span></label> 
<input	type="text" class="date" name="<%=CALL_RCD_DATE %>" readonly="readonly" value="<%= currentDate %>" tabindex="1" MAXLENGTH="30" id="callRcdDate" validate="Call Rec.Date,string,yes"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" tabindex="1" 
class="calender"	onClick="setdate('<%=currentDate %>',document.emergencyPerforma.callRcdDate,event)" /> 
<label> Call Time <span>*</span></label>
<input type="text" name="<%=CALL_RCD_TIME %>"  id="callRecTime" tabindex="1" validate="Call Rec.Time,string,yes" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTime(this.value,this.id);" value="<%= time %>" MAXLENGTH="5" />
<label> Call From <span>*</span></label>
<input type="text" name="<%=SOURCE_FROM %>" tabindex="1" validate="From,metachar,yes" value="" MAXLENGTH="90"	/> 
 <div class="Clear"></div>
 
<label> Reported By</label> 
<input	type="text" name="<%=REPORTED_BY%>" tabindex="1" validate="Reported By,metachar,no" value="" MAXLENGTH="50"  />

<label> Site <span>*</span></label> 
<input type="text" name="<%= LOCATION %>" value="" tabindex="1" validate="Location,metachar,yes">

<label> Type of Emergency <span>*</span></label> 
<input type="text" 	name="<%=EMERGENCY_TYPE %>" value="" tabindex="1"  validate="Type Of Emergency,metachar,yes" MAXLENGTH="50" /> 

<div class="Clear"></div>
<label> Attended Time <span>*</span></label> 
<input	type="text" name="<%=ATTENDED_TIME%>" value="<%= time %>" tabindex="1" validate="Attended Time,string,yes" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTime(this.value,this.id);" MAXLENGTH="5" />
<label> Medical Officer <span>*</span></label> 
<select name="<%=MEDICAL_OFFICER_ID %>"  tabindex="1" validate="Medical Officer,string,yes">
	<option value="0">Select</option>
	<% 
			for(MasEmployee employee : doctorList)
			{
			%>
	<option value="<%=employee.getId()%>"><%=employee.getRank().getRankName()+" "+employee.getFirstName()+" "+employee.getLastName() %></option>
	<%
			}
			%>
</select> 
<div class="Clear"></div>
<label> Action Taken</label> 
<textarea name="<%=ACTION_TAKEN %>" rows="" cols=""  tabindex="1" validate="Action Taken,metachar,no" maxlength="200"onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<label> Casualties, If Any</label> 
<textarea name="casualties" rows="" cols=""  tabindex="1" validate="Casualties,metachar,no" maxlength="100" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<label>Remarks</label> 
<textarea name="<%=REMARKS %>" rows="" cols="" tabindex="1" validate="Remarks,metachar,no"  maxlength="90" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
</div>

<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton" tabindex="1" 
	onclick="submitForm('emergencyPerforma','/hms/hms/registration?method=saveEmergencyPerformaDetails')"
	value="Submit" class="button" accesskey="a" />
<input type="button" name="register" id="addbutton"
onclick="submitFormForButton('emergencyPerforma','/hms/hms/registration?method=showEmergencyPerformaRegisterJsp');"
	value="Register" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" tabindex="1" />

<div class="Clear"></div>
<div class="division"></div>
 <div class="bottom">
<label>Changed By</label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date</label>   
<label class="value"><%=currentDate%></label>
 
<label>Changed Time</label>   
<label class="value"><%=time%></label>
 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>"  />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>"  value="<%=time%>" />
<div class="Clear"></div>

</div>
</form>
