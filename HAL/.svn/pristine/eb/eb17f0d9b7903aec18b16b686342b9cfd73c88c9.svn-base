<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.AviCa34"%><script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<AviCa34> medExamWaitingList = new ArrayList<AviCa34>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(patientMap.get("medExamWaitingList") != null){
			medExamWaitingList= (List<AviCa34>)patientMap.get("medExamWaitingList");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		Map<String, Object> dtmap = new HashMap<String, Object>();
		String message = "";
		if(map.get("message")!= null){
			message = (String)map.get("message");
		}
		Box box = HMSUtil.getBox(request);
	%> 
	<div id="searchTableDiv"  >

<input type="hidden" name="add" class="buttonAdd" value="" onclick="generateRow('appTable');">
<div class="Clear"></div>
<%if(medExamWaitingList !=null && medExamWaitingList.size()>0){ %>
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="appTable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Renewal Due Date</th>
		<th scope="col">Name</th>
		<th scope="col">Age/Gender</th>
		<th scope="col">Licence No.</th>
		<th scope="col">Licence Type</th>
	</tr>
<%
	int i=0;
		for(AviCa34 aviCa34:medExamWaitingList){
		%>
	<tr>
<td>
<input type="checkbox" name="checkedAppoint" id="checkedAppoint<%=i %>" value="" onblur="chekedAppointvalue('<%=i %>');"/>
<input type="hidden" name="checkedAppointvalue" id="checkedAppointvalue<%=i %>"  value="" />	</td>
<td><input type="text" name="<%=DATE %>" id="<%=DATE %><%=i %>"  readonly="readonly"
	value="<%=HMSUtil.changeDateToddMMyyyy(aviCa34.getRenewalDueDate()) %>"/></td>
	<%
	int aviCa34Id=0;
	String serName="";
	String age="";
	String licenseNo="";
	String licenseType="";
	serName=aviCa34.getFirstName();
	aviCa34Id=aviCa34.getId();
	if(aviCa34.getLastName() !=null){
		serName=serName+" "+aviCa34.getLastName();
	}
	if(aviCa34.getAge() !=null){
		age=aviCa34.getAge();
	}
	if(aviCa34.getLicenceNo() !=null){
		licenseNo=aviCa34.getLicenceNo();
	}
	if(aviCa34.getTypeOfLicenceApplied() !=null){
		if(aviCa34.getTypeOfLicenceApplied().getCaLicenceName() !=null){
			licenseType=aviCa34.getTypeOfLicenceApplied().getCaLicenceName();
		}
	}
	
	%>
<td>
<input type="text" name="<%=NAME %>" value="<%=serName%>" readonly="readonly" />
<input type="hidden" value="<%=aviCa34Id %>" name="aviCa34Id" readonly="readonly"/></td>
<td><input type="text" name="<%=AGE %>" value="<%=age %>" readonly="readonly"/></td>
<td><input type="text" name="<%=LICENCE_NO %>" value="<%=licenseNo %>" readonly="readonly"/></td>
<td><input type="text" name="<%=TYPE_OF_LICENCE %>" value="<%=licenseType %>" readonly="readonly"/></td>
	</tr>
<%i++;
} 
%>
	</table>
<input type="hidden" id="cnt" name="cnt" value="<%=i %>"/>

<div class="Clear"></div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Appointment Date<span>*</span></label>
<input type="text" name="appointmentDate" value="<%=currentDate %>" MAXLENGTH="20" class="date"	id="toAppDate" validate="A Date,frdate,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.appointmentForMedExam.<%=APPOINTMENT_DATE %>,event)" />
</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<input type="button" name="save" value="Submit" class="button" accesskey="a" 
onClick="submitForm('appointmentForMedExam','aviationMedicine?method=submitCheckedAppointment');"/>
<input type="button" name="cancel" value="Cancel Appointment" class="buttonBig" 
onClick="submitForm('appointmentForMedExam','aviationMedicine?method=submitCancelAppointment');"/>
<%}else{ %>
<h4>No Reocrd Found !</h4>
<%} %>
</div>

