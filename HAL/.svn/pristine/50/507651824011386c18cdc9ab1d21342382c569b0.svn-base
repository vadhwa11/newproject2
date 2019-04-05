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
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasEcgType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>

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

<%
		Map<String, Object> map = new HashMap<String, Object>();
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
	
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
		
		List<MasEcgType> ecgTypeList = new ArrayList<MasEcgType>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		if(map.get("ecgTypeList") != null){
			ecgTypeList = (List<MasEcgType>)map.get("ecgTypeList");
		}
		if(map.get("doctorList") != null){
			doctorList = (List<MasEmployee>)map.get("doctorList");
		}
	%>
	<h4><%=message %></h4>
<h2>ECG Record Register</h2>
<div class="clear"></div>
<form name="minorSurgery" action="" method="post">
<div class="Block">
<label><span>*</span> Service No.</label>
<input type="text" name="<%=SERVICE_NO %>" validate="Service No,string,yes" value="" onblur="if(this.value != ''){submitProtoAjax('minorSurgery','/hms/hms/registration?method=getHinNoForMinorSurgery');}" MAXLENGTH="30" />
<label><span>*</span> HIN No.</label>
<div id="testDiv">
<input type="text" name="<%=HIN_NO %>" id="hinNo" value="" readonly="readonly" validate="Hin No,string,yes" MAXLENGTH="90"/> 
</div>
<label><span>*</span> Visit No.</label> 
<div id="visitDiv">
<input type="text" name="<%=VISIT_NUMBER %>" id="visitNo" readonly="readonly" value="" validate="First Name,string,no" MAXLENGTH="90"/>
</div>
 <div class="Clear"></div>
<label><span>*</span>   Date</label> 
<input	type="text" name="<%=DATE %>" value="<%= currentDate %>" MAXLENGTH="30" id="referralDate" validate="Date,string,yes" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.minorSurgery.referralDate,event)" /> 
<label>Patient Name</label> 
<input type="text" name="<%=PATIENT_NAME %>" id="patientName" readonly="readonly" value="" validate="First Name,string,no" MAXLENGTH="90"/>

<label>Relation</label> 
<input	type="text" name="<%=RELATION_NAME%>" id="relation" readonly="readonly" validate="Relation,string,no" value="" MAXLENGTH="50"  />

<div class="Clear"></div>
<label>Rank</label> 
<input type="text" name="<%=RANK_NAME %>" id="rank" value="" readonly="readonly" validate="Rank,string,no" MAXLENGTH="90"/> 
<label>Service Person Name</label> 
<input type="text" 	name="<%=SERVICE_PERSON_NAME %>" id="sNameId" readonly="readonly" value="" validate="Middle Name,string,no" MAXLENGTH="50" /> 
 
<label>Unit</label> 
<input	type="text" name="<%=UNIT%>" id="unit" validate="Sex,string,no" readonly="readonly" value="" MAXLENGTH="50"  />

<div class="Clear"></div>
<label> Branch/Trade</label> 
<input	type="text" name="<%=TRADE%>" id="trade" validate="Age,string,no" readonly="readonly" value="" MAXLENGTH="50"  />

<label> Age</label> 
<input	type="text" name="<%=AGE%>" id="age" validate="Age,string,no" readonly="readonly" value="" MAXLENGTH="50"  />

<label><span>*</span>   Diagnosis</label> 
<input	type="text" name="<%=DIAGNOSIS%>" id="diag" validate="Diagnosis,string,yes" value="" MAXLENGTH="70"  />

<div class="Clear"></div>
<label>Doctor</label> 
<input	type="text" name="<%=DOCTOR_NAME%>" id="doctor" validate="Doctor,string,no" readonly="readonly" value="" MAXLENGTH="70"  />


<label><span>*</span> Type Of ECG</label> 
<select name="typeOfEcg" validate="Type Of ECG,string,yes">
<option value="0">Select </option>
<%
	if(ecgTypeList.size() > 0){
		for(MasEcgType ecgType : ecgTypeList){
		%>
		<option value="<%= ecgType.getId() %>"> <%=ecgType.getEcgTypeName() %></option>
	<%}
	}
%>
</select>
<div class="Clear"></div>
<label><span>*</span> ECG Done On</label> 
<input	type="text" name="ecgDate" id="ecg_date" validate="ECG Done On,string,yes" value="" class="date" readonly="readonly" MAXLENGTH="50"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.minorSurgery.ecgDate,event)" /> 

<label><span>*</span> At</label> 
<input	type="text" name="ecgTime" id="ecg_time" validate="ECG Done At,string,yes" value="" MAXLENGTH="8" onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);" />


<label> Report Remarks</label> 
<input	type="text" name="<%=REMARKS%>" id="remarks" validate="Report Remarks,string,no" value="" MAXLENGTH="50"  />

<div class="Clear"></div>
<label><span>*</span>  Validate By Doctor</label> 
<select name="validateByDoctor" validate="Validate By Doctor,string,yes">
<option value="0">Select </option>
<%
	if(doctorList.size() > 0){
		for(MasEmployee employee : doctorList){
			String dName = employee.getFirstName();
			if(employee.getMiddleName() != null){
				dName +=" "+employee.getMiddleName();
			}
			if(employee.getLastName() != null){
				dName +=" "+employee.getLastName();
			}
		%>
		<option value="<%= employee.getId() %>"> <%=dName %></option>
	<%}
	}
%>
</select>
</div>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('minorSurgery','/hms/hms/registration?method=saveECGRecordDetails');"
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

