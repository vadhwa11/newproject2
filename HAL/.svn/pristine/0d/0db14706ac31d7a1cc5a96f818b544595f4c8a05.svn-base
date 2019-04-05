<%@page import="jkt.hms.masters.business.AirCraftEmergencyDt"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>

<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.AirCraftEmergency"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
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
	List<AirCraftEmergencyDt> airCraftEmergencyList1 = new ArrayList<AirCraftEmergencyDt>();

	List<Object[]> unitList = new ArrayList<Object[]>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");

		
	if(map.get("airCraftEmergencyList") != null){
		airCraftEmergencyList1= (List<AirCraftEmergencyDt>)map.get("airCraftEmergencyList");
	}
	
	int hospitalId = 0;
	if(map.get("hospitalId")!=null){
		hospitalId = (Integer)map.get("hospitalId");
	}
	%>
<form name="aiercraftEmergencyRegister" method="post" action="">
<div class="titleBg">
<h2>Aircraft Emergency Register</h2></div>
<div class="Clear"></div>
<input type="hidden" name="hospitalId" value="<%=hospitalId %>">
<div class="Clear"></div>
<div class="cmntable"> 
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Call Date </th>
		<th scope="col">Call Time</th>
		<th scope="col">Call From</th>
		<th scope="col">Reported By</th>
		<th scope="col">Site</th>
		<th scope="col">Type of Aircraft</th>
		<th scope="col">Type of Emergency</th>
		<th scope="col">Pilot(s)</th>
		<th scope="col">Unit</th>
		<th scope="col">Attended Time</th>		
		<th scope="col">Medical Officer</th>	
		<th scope="col">Action Taken</th>	
		<th scope="col">Remarks</th>			
	</tr>
		<tr>
	<%
	int i=1;
	 List<Integer> pilotName=new ArrayList<Integer>(); 
	 int airCraftEmergencyId=0;;
	 String pilotNames="";
	 for(int j=0;j<airCraftEmergencyList1.size();j++){
	//for(AirCraftEmergencyDt airCraftEmergency : airCraftEmergencyList1){
		AirCraftEmergencyDt airCraftEmergency=airCraftEmergencyList1.get(j);
		
		if((j+1)<airCraftEmergencyList1.size() && ((airCraftEmergencyId==0 && airCraftEmergency.getAirCraftEmergency().getId()==airCraftEmergencyList1.get(j+1).getAirCraftEmergency().getId()) || airCraftEmergencyId==airCraftEmergencyList1.get(j+1).getAirCraftEmergency().getId()))
		{
			airCraftEmergencyId=airCraftEmergency.getAirCraftEmergency().getId();
			pilotNames +=airCraftEmergency.getFullName() +" ,";
			continue;
		}
		else
		{
			airCraftEmergencyId=0;
			pilotNames +=airCraftEmergency.getFullName();
		}

		 if(!pilotName.contains(airCraftEmergency.getAirCraftEmergency().getId()))
			{
			 pilotName.add(airCraftEmergency.getAirCraftEmergency().getId()); 
		
		%>
		<%if(airCraftEmergency.getAirCraftEmergency().getCallRcdDate()!=null) {%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(airCraftEmergency.getAirCraftEmergency().getCallRcdDate() )%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(airCraftEmergency.getAirCraftEmergency().getCallRcdTime()!=null){ %>
		<td><%=airCraftEmergency.getAirCraftEmergency().getCallRcdTime() %></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(airCraftEmergency.getAirCraftEmergency().getSourceFrom()!=null){ %>
		<td><%=airCraftEmergency.getAirCraftEmergency().getSourceFrom()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(airCraftEmergency.getAirCraftEmergency().getReportedBy()!=null){ %>
		<td><%=airCraftEmergency.getAirCraftEmergency().getReportedBy()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%
		if(airCraftEmergency.getAirCraftEmergency().getLocation()!=null){
		%>
		<td><%=airCraftEmergency.getAirCraftEmergency().getLocation()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%
		if(airCraftEmergency.getAirCraftEmergency().getTypeOfAircraft()!=null){
		%>
		<td><%=airCraftEmergency.getAirCraftEmergency().getTypeOfAircraft().getAircraftTypeName()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(airCraftEmergency.getAirCraftEmergency().getEmergencyType()!=null){ %>		
		<td><%=airCraftEmergency.getAirCraftEmergency().getEmergencyType()%></td>	
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%-- <%if(airCraftEmergency.getFullName()!=null){ %>		 --%>
		<td><%=pilotNames %></td>	
		<%-- <%}else{ %>
		<td>-</td>
		<%} %> --%>
		<%if(airCraftEmergency.getAirCraftEmergency().getUnit()!=null){ %>		
		<td><%=airCraftEmergency.getAirCraftEmergency().getUnit().getUnitName()%></td>	
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(airCraftEmergency.getAirCraftEmergency().getAttendedTime()!=null){ %>
		<td><%=airCraftEmergency.getAirCraftEmergency().getAttendedTime()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(airCraftEmergency.getAirCraftEmergency().getMedicalOfficer()!=null ){ %>
		<td><%=airCraftEmergency.getAirCraftEmergency().getMedicalOfficer().getRank().getRankName()+" "+ airCraftEmergency.getAirCraftEmergency().getMedicalOfficer().getFirstName()+" "+( airCraftEmergency.getAirCraftEmergency().getMedicalOfficer().getMiddleName()!=null?airCraftEmergency.getAirCraftEmergency().getMedicalOfficer().getMiddleName():"")+" "+( airCraftEmergency.getAirCraftEmergency().getMedicalOfficer().getLastName()!=null?airCraftEmergency.getAirCraftEmergency().getMedicalOfficer().getLastName():"")%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if( airCraftEmergency.getAirCraftEmergency().getActionTaken()!=null){ %>
		<td><%=airCraftEmergency.getAirCraftEmergency().getActionTaken()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if( airCraftEmergency.getAirCraftEmergency().getRemarks()!=null){ %>
		<td><%=airCraftEmergency.getAirCraftEmergency().getRemarks()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>	
		

	
	</tr>
	<% 
	pilotNames=" ";
			}}%>
	</table>
	</div>
	<div class="Clear"></div>
	<div class="Clear"></div>
	<div class="division"></div>
	<div class="Clear"></div>
<input type="button" name="Back" value="Back" class="button" onclick="submitForm('aiercraftEmergencyRegister','/hms/hms/registration?method=showAircraftEmergencyRegisterJsp')" accesskey="r" />
	<div class="Clear"></div>
	<div class="division"></div>
	<div class="Clear"></div>
</form>
