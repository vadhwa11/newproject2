
<%@page import="jkt.hms.masters.business.AviCa34"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/divideprototype.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
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
		List<AviCa34> medExamPMRList = new ArrayList<AviCa34>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("medExamPMRList") != null){
			medExamPMRList = (List<AviCa34>)map.get("medExamPMRList");
		}
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if(map.get("employeeList") !=null){
			employeeList=(List<MasEmployee>)map.get("employeeList");
		}
		System.out.println("<<medExam JSP  PMRList>>>"+medExamPMRList.size());
		%>
		
<%@page import="jkt.hms.masters.business.MasEmployee"%><div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="appTable" >
	<tr>
		<th scope="col">Licence No.</th>
		<th scope="col">Name</th>
		<th scope="col">Appointment Date</th>
		<th scope="col">PMR Received Date</th>
		<th scope="col">Received By</th>
		<th scope="col">Exam Date</th>
		<th scope="col">PMR Dispatch Date</th>
		<th scope="col">Dispatch By</th>
		<th scope="col">Remarks</th>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
	</tr>
	<%int i=1;	%>
	
<%

if(medExamPMRList.size() >0){
for(AviCa34 avCa34:medExamPMRList){ %>
<tr>


<td><input type="text" name="<%=LICENCE_NO %>>" id="licenceNo<%=i %>" value="<%=avCa34.getLicenceNo() %>"
		readonly="readonly" validate="Licence No.,metachar,no"/>
<input name="avic34Id" id="avic34Id<%=i %>" type="hidden"  value="<%=avCa34.getId() %>"/></td>
<td>
<%String lastName=""; 
if(avCa34.getLastName() !=null){
	lastName=avCa34.getLastName();}%>
<input type="text" name="<%=NAME %>"  id="<%=NAME %><%=i %>"  readonly="readonly"
value=<%=avCa34.getFirstName()+" "+lastName %>/></td>
<td>
<%if(avCa34.getAppointmentDate() !=null){ %>
<input type="text" name="<%=APPOINTMENT_DATE %>" id="appointmentDate<%=i %>"  value="<%=HMSUtil.changeDateToddMMyyyy(avCa34.getAppointmentDate()) %>" 
class="date" readonly="readonly" />
<%}else{ %>
<input type="text" name="<%=APPOINTMENT_DATE %>" id="appointmentDate<%=i %>"  value="" 
class="date" readonly="readonly" />
<%} %>
</td>
<td>
<%if(avCa34.getPmrReceivedDate() !=null){ %>
<input type="text" size="11" name="<%=RECEIVED_DATE %>" id="<%=DATE %>" value="<%=HMSUtil.changeDateToddMMyyyy(avCa34.getPmrReceivedDate()) %>" MAXLENGTH="20" class="date"	 validate="To Date,date,yes" />
<%}else{%>
<input type="text" size="11" name="<%=RECEIVED_DATE %>" id="<%=DATE %>" value="" MAXLENGTH="20" class="date"	 validate="Received Date,date,yes" />
<%} %>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.pmrFileTracking.<%=DATE %>,event)" /></td>
<td>
<select  name="<%=RECEIVED_BY %>" id="<%=RECEIVED_BY %><%=i %>">
<option value="0">Select</option>
<%for(MasEmployee masEmployee:employeeList){
	String lastName2="";
	if(masEmployee.getLastName() !=null){
		lastName2=masEmployee.getLastName();
	}
	if(avCa34.getPmrReceiveBy() !=null){
	if(avCa34.getPmrReceiveBy().getId().equals(masEmployee.getId())){
%>
<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getFirstName()+" "+lastName2 %></option>
<%}else{ %>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+lastName2 %></option>
<%} }else{%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+lastName2 %></option>
<%} }%>
</select>
<%
int i1=0;
for (MasEmployee recEmployee : employeeList) {
     			 %> <script>
     			receivArray[<%=i1%>]= new Array();
     			receivArray[<%=i1%>][0] = "<%=recEmployee.getId()%>";
     			receivArray[<%=i1%>][1] = "<%=recEmployee.getFirstName()%>";
            </script> <%
++i1;
}%>
</td>
<td>
<%if(avCa34.getMedExamDate() !=null){ %>
<input type="text" name="<%=EXAMINATION_DATE %>" id="<%=EXAMINATION_DATE %>" value="<%=HMSUtil.changeDateToddMMyyyy(avCa34.getMedExamDate()) %>" 
MAXLENGTH="20"	class="date" validate="Exam Date,date,no" readonly="readonly"/>
		<%}else{ %>
		<input type="text" name="<%=EXAMINATION_DATE %>" id="<%=EXAMINATION_DATE %>" value="" MAXLENGTH="20" 
		class="date" validate="Exam Date,date,no" readonly="readonly"/><%} %>
</td>

<td>
<%if(avCa34.getPmrDispatchDate() !=null){ %>
<input type="text" size="11" name="<%=DISPATCH_DATE %>" id="<%=DISPATCH_DATE %>" value="<%=HMSUtil.changeDateToddMMyyyy(avCa34.getPmrDispatchDate()) %>" 
MAXLENGTH="20" size="11" class="date" validate="Dispatch Date,date,no" /><%}else{ %>
<input type="text" name="<%=DISPATCH_DATE %>" id="<%=DISPATCH_DATE %>" value="" MAXLENGTH="20" class="date"
 validate="Dispatch Date,date,no" /><%} %>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.pmrFileTracking.<%=DISPATCH_DATE %>,event)" /></td>
<td><select name="<%=DISPATCHED_BY%>" id="<%=DISPATCHED_BY %><%=i %>" >
	<option value="0">Select</option>
<%   for(MasEmployee dispEmployee:employeeList){
		String lastName1="";
		if(dispEmployee.getLastName() !=null){
			lastName1=dispEmployee.getLastName();
		}
		if(avCa34.getPmrReceiveBy() !=null){
		if(avCa34.getPmrReceiveBy().getId().equals(dispEmployee.getId())){
		%>
	<option value="<%=dispEmployee.getId() %>" selected="selected"><%=dispEmployee.getFirstName()+" "+lastName1 %></option>
	<%}else{ %>
	<option value="<%=dispEmployee.getId() %>"><%=dispEmployee.getFirstName()+" "+lastName1 %></option>
	<% }}else{%>
	<option value="<%=dispEmployee.getId() %>"><%=dispEmployee.getFirstName()+" "+lastName1 %></option><%} %>
	<%  }%>
</select>
<%
int i2=0;
for (MasEmployee disEmployee : employeeList) {
     			 %> <script>

     			dispatchArray[<%=i2%>]= new Array();
     			dispatchArray[<%=i2%>][0] = "<%=disEmployee.getId()%>";
     			dispatchArray[<%=i2%>][1] = "<%=disEmployee.getFirstName()%>";
            </script> <%
++i2;
}%>
</td>
<td><%if(avCa34.getPmrRemarks() !=null){ %>
<input type="text" name="<%=REMARKS%>" id="<%=REMARKS %><%=i %>" maxlength="49" validate="Remarks,metachar,no"
 value="<%=avCa34.getPmrRemarks() %>"/><%}else{ %>
 <input type="text" name="<%=REMARKS%>" id="<%=REMARKS %><%=i %>" maxlength="49" validate="Remarks,metachar,no"
 value=""/><%} %></td>
 
 
<td>
		<input name="Button" type="button" class="buttonAdd" value="" onclick="generateRow('appTable');" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('appTable','cnt',this);" tabindex="1" />
</td>
</tr>
<%}}else{ %>
<tr>
<td><input type="text" name="<%=LICENCE_NO %>>"   id="licenceNo<%=i %>" onblur="checkForLicenceNo(this.value,<%=i %>);"
	validate="Licence No.,metachar,yes"/>
<input name="avic34Id" id="avic34Id<%=i %>" type="hidden"/></td>
<td><input type="text" name="<%=NAME %>"  id="<%=NAME %><%=i %>"  readonly="readonly"/></td>
<td>
<input type="text" name="<%=APPOINTMENT_DATE %>" id="appointmentDate<%=i %>"  value="" class="date"	readonly="readonly" />
</td>
<td><input type="text" size="11" name="<%=RECEIVED_DATE %>" id="<%=DATE %>" value="" MAXLENGTH="20" class="date"	 validate="To Date,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.pmrFileTracking.<%=DATE %>,event)" /></td>
<td>
<select  name="<%=RECEIVED_BY %>" id="<%=RECEIVED_BY %><%=i %>">
<option value="0">Select</option>
<%for(MasEmployee masEmployee:employeeList){
	String lastName="";
	if(masEmployee.getLastName() !=null){
		lastName=masEmployee.getLastName();
	}
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+lastName %></option>
<%} %>
</select>
<%
int i1=0;
for (MasEmployee recEmployee : employeeList) {
     			 %> <script>

     			receivArray[<%=i1%>]= new Array();
     			receivArray[<%=i1%>][0] = "<%=recEmployee.getId()%>";
     			receivArray[<%=i1%>][1] = "<%=recEmployee.getFirstName()%>";
            </script> <%
++i1;
}%>
</td>
<td><input type="text" name="<%=EXAMINATION_DATE %>" id="<%=EXAMINATION_DATE %>" value="" MAXLENGTH="20" class="date" validate="To Date,date,yes" />
</td>
<td><input type="text" size="11" name="<%=DISPATCH_DATE %>" id="<%=DISPATCH_DATE %>" value="" MAXLENGTH="20" class="date" validate="To Date,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.pmrFileTracking.<%=DISPATCH_DATE %>,event)" /></td>
<td><select name="<%=DISPATCHED_BY%>" id="<%=DISPATCHED_BY %><%=i %>" >
	<option value="0">Select</option>
<%   for(MasEmployee masEmployee:employeeList){
		String lastName="";
		if(masEmployee.getLastName() !=null){
			lastName=masEmployee.getLastName();
		}
		%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+lastName %></option>
	<%} %>
</select>
<%
int i2=0;
for (MasEmployee disEmployee : employeeList) {
     			 %> <script>

     			dispatchArray[<%=i2%>]= new Array();
     			dispatchArray[<%=i2%>][0] = "<%=disEmployee.getId()%>";
     			dispatchArray[<%=i2%>][1] = "<%=disEmployee.getFirstName()%>";
            </script> <%
++i2;
}%>
</td>
<td><input type="text" name="<%=REMARKS%>" id="<%=REMARKS %><%=i %>" maxlength="49" validate="Remarks,metachar,no"/></td>
<td>
		<input name="Button" type="button" class="buttonAdd" value="" onclick="generateRow('appTable');" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('appTable','cnt',this);" tabindex="1" />
</td>
</tr>
<%} %>	
</table>
	<input type="hidden" id="cnt" name="cnt" value="<%=i-1 %>"/>
</div>

<div class="clear paddingTop15"></div>
<input type="button" name="save" 	value="Submit" class="button" accesskey="a" 
onclick="submitForm('pmrFileTracking','/hms/hms/aviationMedicine?method=submitPMRFileTracking');"/>
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" accesskey="r" />
