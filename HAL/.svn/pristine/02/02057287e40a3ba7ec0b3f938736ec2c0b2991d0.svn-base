<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.PhysiotherapyDetails"%>
<%
Map map = new HashMap();
if (request.getAttribute("map") != null) {
map = (Map) request.getAttribute("map");

}

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentTimeWithoutSecond();
String date = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
List<PhysiotherapyDetails> patientList = new ArrayList<PhysiotherapyDetails>();

if(map.get("patientList") != null){
	patientList = (List<PhysiotherapyDetails>)map.get("patientList");
}
%>


<div class="Clear"></div>
<table width="90%" colspan="7" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
		<th>Visit No</th>
		<th>Date</th>
		<th>Time Begin</th>
		<th>Time Completed</th>
		<th>Total Sitting Time</th>
		<th>Next Appt. Date</th>
		<th>Next Appt. Time</th>
		<th>Remarks</th>
		</tr>
	</thead>
	
	<%
	int i=1;
	if(patientList.size() > 0){
		for(PhysiotherapyDetails phyDetails : patientList){
	%>
	<tr>
	<td><%= phyDetails.getPhyVisitNo() %></td>
	<td><%= HMSUtil.convertDateToStringWithoutTime(phyDetails.getPhyVisitDate() )%></td>
	<td><%= phyDetails.getTimeBegin() %></td>
	<td><%= phyDetails.getTimeComplete() %></td>
	<td><%= phyDetails.getSittingTime() %></td>
	<%
		if(phyDetails.getNextAppointmentDate()!=null){
	%>
	<td><%= HMSUtil.convertDateToStringWithoutTime(phyDetails.getNextAppointmentDate()) %></td>
	<%}else{ %>
	<td>&nbsp;</td>
	<%} %>
	<td><%= phyDetails.getNextAppointmentTime() %></td>
	<%
		if(phyDetails.getRemarks()!=null){
	%>
	<td><%= phyDetails.getRemarks() %></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
	</tr>
	
	<%i++;} %>
	<%
	}%>
	<tr>
	<td><input type="text" name="visitNo" value="<%= i %>" size="4" maxlength="3"/></td>
	<td><input type="text" name="visitDate" value="<%= date %>" size="10" readonly="readonly"/>
	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
	class="calender"	onClick="setdate('<%=date %>',document.physiotherapyMain.visitDate,event)" /> 
	</td>
	<td><input type="text" id="timeBegin" name="timeBegin" maxlength="5" value="<%= time %>" size="10" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" /></td>
	<td><input type="text" id="timeCompleted" name="timeCompleted" maxlength="5"  value="<%= time %>" size="10"onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" /></td>
	<td><input type="text" id="sittingTime" name="sittingTime" maxlength="5" value="" size="10" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" /></td>
	<td><input type="text" id="nextApptDate" name="nextApptDate" value="" size="10" readonly="readonly"/>
	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
		class="calender"	onClick="setdate('<%=date %>',document.physiotherapyMain.nextApptDate,event)" /> 
	</td>
	<td><input type="text" id="nextApptTime" name="nextApptTime" maxlength="5"  value="" size="10" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" /></td>
	<td><input type="text" name="<%=REMARKS %>" value="" validate="Remarks,String,no" maxlength="100"/></td>
		
	
	
	</tr>
	
</table>

<div class="clear"></div>
<div class="division"></div>
<label class="auto">Physiotherapy Completed</label>
<input type="checkbox" name="phyCompleted" value="y">

