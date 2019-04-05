<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * patientRemarksJsp.jsp  
 * Purpose of the JSP -  This is for daily Patient Remarks.
 * @author  Kalyan
 * Create Date: 20th Nov,2008 
 * Revision Date:      
 * Revision By:
 * @version 1.9  
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
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
function getViewDetals() {
	remarksDate = document.getElementById("remarksDate").value
	patientId = document.getElementById("inpatientId").value
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
         document.getElementById("viewDetails").innerHTML = xmlHttp.responseText;
      }
    }
    var url="/hms/hms/ipd?method=getPatientRemarksDetails&remarksDate="+remarksDate+"&patientId="+patientId
     
    xmlHttp.open("GET",url,true);
    
    xmlHttp.send(null);
  }
  function checkManda(){
  var condition  =  document.getElementById('conditionId').value;
  var remarks = document.getElementById('remarks').value;
  var treatment = document.getElementById('treatment').value;
 
  var errmsg = "" 
   if(condition == ""){
   errmsg = errmsg + "\n Please select condition!!"
   }
   if(remarks == ""){
   errmsg = errmsg + "\n Remarks should not be blank!!"
   }
   if(treatment == ""){
   errmsg = errmsg + "\n Treatment should not be blank!!"
   }
 
   if(errmsg != ""){
   alert(errmsg);
   return false;
   }
 
   return true;
  }
  
  
  </script>
<div id="contentHolder">
<form name="patientRemarks" method="post">
<%
     	Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientDetails = new HashMap<String, Object>();
		String message ="";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String currentTime = (String)utilMap.get("currentTime");
		
		
		String userName = "";
		String remarks = "";
		String treatment = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientDetails") != null){
			patientDetails = (Map<String,Object>)map.get("patientDetails");
		}
		
		
		if(patientDetails.get("inPatientList") != null){
			inpatientList = (List<Inpatient>)patientDetails.get("inPatientList");
		}
		
		if(patientDetails.get("remarks") != null){
			remarks = (String)patientDetails.get("remarks");
		}
		if(patientDetails.get("treatment") != null){
			treatment = (String)patientDetails.get("treatment");
		}
		
		
		if(map.get("message") !=null){
			message =""+map.get("message");
		}
		
	%> <%if(!message.equals("")){ %> <label class="nowidth"><span><%=message %></label></label>
<% }%>
<div class="Clear"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame">
<%
	System.out.println("inpatient size in jsp"+inpatientList.size());
	if(inpatientList != null && inpatientList.size() > 0){
		Inpatient inpatient = inpatientList.get(0);
		Patient patient = inpatient.getHin();
		int inpatientId = 0;
		String age = "";
		String currentAge = "";
		String adNo = "";
		age = patient.getAge();
		inpatientId = inpatient.getId();
		
		currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
		adNo = inpatient.getAdNo();
		%> <label>A&D No.:</label> <label class="value"><%=adNo %></label> <label>Hin
No.:</label> <label class="value"><%=patient.getHinNo() %></label> <%
		String middleName = "";
		String lastName = "";
		if(patient.getPMiddleName() != null){
			middleName = patient.getPMiddleName();
		}
		if(patient.getPLastName() != null){
			lastName = patient.getPLastName();
		}
		
		%> <label>Patient Name:</label> <label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>

<div class="Clear"></div>

<label>Sex:</label> <%
		if(patient.getSex() != null){
		%> <label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Age:</label> <label
	class="value"><%=currentAge%></label> <input type="hidden"
	name="<%=HIN_ID %>" value="<%=patient.getId() %>"> <input
	type="hidden" name="<%=AD_NO %>" value="<%=adNo %>"> <input
	type="hidden" name="<%=AD_STATUS %>"
	value="<%=inpatient.getAdStatus() %>"> <input type="hidden"
	name="inpatientId" value="<%=inpatientId %>" id="inpatientId" /> <input
	type="hidden" name="parent" value="<%=inpatientId %>" id="parent" />

<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="blockTitle">Patient Remarks</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame"><label><span>*</span> Date: </label> <input
	type="text" name="<%=DATE%>" value="" class="calDate" tabindex=1
	validate="Date,dateOfAdmission,yes" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.patientRemarks.<%=DATE%>,event)" />

<label><span>*</span> Time: </label> <input type="text"
	name="<%=TIME %>" value="<%=currentTime %>" readonly="readonly"
	tabindex=1 class="calDate" validate="Time,String,yes" id="admTime"
	onblur="checkTime('admissionByHin','<%=TIME_OF_ADMISSION%>');" /> <label><span>*</span>
Condition: </label> <select name="<%=CONDITION%>" id="conditionId" tabindex=1
	validate="Condition ,String,Yes">
	<option value="">Select</option>
	<option value="Critical">Critical</option>
	<option value="Critical But Stable">Critical But Stable</option>
	<option value="Improved">Improved</option>
	<option value="Stable">Stable</option>
</select>

<div class="Clear"></div>

<label><span>*</span> Post Op Case:</label> <label class="small">Yes</label>
<input id="frwIssuedIdY" type="radio" class="radio"
	name="<%=POST_OP_CASE %>" value="y" tabindex=1
	onclick="checkFRWIssued(this.value);"> <label class="small">No</label>
<input type="radio" checked="checked" class="radio" id="frwIssuedIdN"
	name="<%=POST_OP_CASE %>" value="n" tabindex=1
	onclick="checkFRWIssued(this.value);">
<div class="Clear"></div>
<label><span>*</span> Remarks: </label> <textarea name="<%=REMARKS %>"
	class="large" rows="3" cols="130" validate="Remarks,string,No"
	id="remarks" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" maxlength="490" tabindex="1" /><%=remarks %></textarea>
<div class="Clear"></div>
<label><span>*</span> Treatment: </label> <textarea name="treatment"
	rows="3" class="large" cols="130" validate="Treatment,string,No"
	id="treatment" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" maxlength="230" tabindex="1" /><%=treatment%></textarea>
<div class="Clear"></div>
<label>&nbsp;</label> <input id="" type="button" name="Submit"
	value="Copy latest remarks & treatment" class="cmnButton"
	onClick="copylastRT();" />
<div class="Clear"></div>
</div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
<div class="Clear"></div>

<input id="" type="button" name="Submit" value="Submit" class="button"
	onClick="if(checkManda()){submitForm('patientRemarks','/hms/hms/ipd?method=submitPatientRemarksInformation');}" />
<input type="reset" name="Reset" value="Reset" class="button"
	accesskey="r" /> <input type="button" class="button" value="Back"
	align="right" onClick="history.back();" />

<div class="Clear"></div>
<div class="blockTitle">View</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span> Date: </label> <input
	type="text" name="<%=DATE_OF_REMARKS%>" value="<%=currentDate %>"
	class="calDate" readonly="readonly" validate="" MAXLENGTH="30"
	id="remarksDate" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate %>',document.patientRemarks.<%=DATE_OF_REMARKS%>,event)" />

<input type="button" name="Back" class="cmnButton" value="View"
	onclick="getViewDetals();" />
<div class="Clear"></div>
<div
	style="overflow: auto; width: 99%; height: 180px; padding: 0px 4px 0px 4px; border: 1px solid #7E7E7E;"
	id="viewDetails"></div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>

</form>

<%}else{%> <label class="noWidth"><span>Patient is Ready To
Discharge </span></label> <%} %> <script type="text/javascript">
           function copylastRT(){
             submitForm('patientRemarks','ipd?method=copyLastRT&RT=Yes');
           }
        </script></div>