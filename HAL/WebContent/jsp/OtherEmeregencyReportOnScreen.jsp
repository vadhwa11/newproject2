<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.EmergencyPerforma"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"language="javascript">
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
	List<EmergencyPerforma> emergencyPerformaList = new ArrayList<EmergencyPerforma>();
	List<Object[]> unitList = new ArrayList<Object[]>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	if(map.get("emergencyPerformaList") != null){
		emergencyPerformaList= (List<EmergencyPerforma>)map.get("emergencyPerformaList");
	}
	
	
	%>
<form name="aiercraftEmergencyRegister"  method="post" action="">
<div class="titleBg">
<h2>Other Emergency Register</h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Call Date </th>
		<th scope="col">Call Time</th>
		<th scope="col">Call From</th>
		<th scope="col">Reported By</th>
		<th scope="col">Site</th>
		<th scope="col">Type of Emergency</th>
		<th scope="col">Attended Time</th>		
		<th scope="col">Medical Officer</th>	
		<th scope="col">Action Taken</th>	
		<th scope="col">Casualties</th>		
		<th scope="col">Remarks</th>			
	</tr>
		<tr>
	<%
	int i=1;
	for(EmergencyPerforma emergencyPerforma:emergencyPerformaList){
		%>
		<%if(emergencyPerforma.getCallRcdDate()!=null) {%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(emergencyPerforma.getCallRcdDate()) %></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(emergencyPerforma.getCallRcdTime()!=null){ %>
		<td><%=emergencyPerforma.getCallRcdTime() %></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(emergencyPerforma.getSourceFrom()!=null){ %>
		<td><%=emergencyPerforma.getSourceFrom()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(emergencyPerforma.getReportedBy()!=null){ %>
		<td><%=emergencyPerforma.getReportedBy()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%
		if(emergencyPerforma.getLocation()!=null){
		 %>
		<td><%=emergencyPerforma.getLocation()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(emergencyPerforma.getEmergencyType()!=null){ %>		
		<td><%=emergencyPerforma.getEmergencyType()%></td>	
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(emergencyPerforma.getAttendedTime()!=null){ %>
		<td><%=emergencyPerforma.getAttendedTime()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(emergencyPerforma.getMedicalOfficer()!=null ){ %>
		<td><%=emergencyPerforma.getMedicalOfficer().getRank().getRankName()+" "+emergencyPerforma.getMedicalOfficer().getFirstName()+" "+(emergencyPerforma.getMedicalOfficer().getMiddleName()!=null?emergencyPerforma.getMedicalOfficer().getMiddleName():"")+" "+(emergencyPerforma.getMedicalOfficer().getLastName()!=null?emergencyPerforma.getMedicalOfficer().getLastName():"")%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if( emergencyPerforma.getActionTaken()!=null){ %>
		<td><%=emergencyPerforma.getActionTaken()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>	
		<%if( emergencyPerforma.getCasualties()!=null){ %>
		<td><%=emergencyPerforma.getCasualties()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>	
		<%if( emergencyPerforma.getRemarks()!=null){ %>
		<td><%=emergencyPerforma.getRemarks()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>	
		

	
	</tr>
	<%i++; } %>
	</table>
	</div>
	<div class="Clear"></div>
	<div class="division"></div>
	<div class="Clear"></div>
<input type="button" name="Back" value="Back" class="button" onclick="submitForm('aiercraftEmergencyRegister','/hms/hms/registration?method=showEmergencyPerformaRegisterJsp')" accesskey="r" />
	<div class="Clear"></div>
	<div class="division"></div>
	<div class="Clear"></div>
</form>
