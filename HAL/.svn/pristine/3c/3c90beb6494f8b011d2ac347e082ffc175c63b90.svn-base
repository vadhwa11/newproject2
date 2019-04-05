
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.AirCraftEmergency"%>
<%@page import="jkt.hms.masters.business.MhReferral"%>
<%@page import="jkt.hms.masters.business.AmbulanceRunRegister"%>
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
	List<AmbulanceRunRegister> ambulanceRunRegisterList = new ArrayList<AmbulanceRunRegister>();

	List<Object[]> unitList = new ArrayList<Object[]>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");

		
	if(map.get("ambulanceRunRegisterList") != null){
		ambulanceRunRegisterList=(List<AmbulanceRunRegister>)map.get("ambulanceRunRegisterList");
	}
	

	%>
<form name="ambulanceEmergencyRegister"  method="post" action="">
<div class="titleBg">
<h2>Ambulance Run Register </h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">Run Date </th>
		<th scope="col">Run Time </th>
		<th scope="col">Run From </th>
		<th scope="col">Run To </th>
		<th scope="col">Patient Name</th>
		<th scope="col">Service No.</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
		<th scope="col">Age/Gender</th>		
		<th scope="col">Remarks</th>		
		<th scope="col">Charges (If Any )</th>
	</tr>
		<tr>
	<%
	int i=1;
	for(AmbulanceRunRegister ambulanceRunRegister : ambulanceRunRegisterList){
		%>
		<td><%=i %></td>
		<%if(ambulanceRunRegister.getAmbulanceRunDate()!=null) {%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(ambulanceRunRegister.getAmbulanceRunDate()) %></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(ambulanceRunRegister.getAmbulanceRunTime()!=null){ %>
		<td><%=ambulanceRunRegister.getAmbulanceRunTime() %></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(ambulanceRunRegister.getFromSmc()!=null){ %>
		<td><%=ambulanceRunRegister.getFromSmc()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(ambulanceRunRegister.getToDestination()!=null){ %>
		<td><%=ambulanceRunRegister.getToDestination()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%
		if(ambulanceRunRegister.getPatientName()!=null){
		 %>
		<td><%=ambulanceRunRegister.getPatientName()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%
		if(ambulanceRunRegister.getServiceNo()!=null){
		 %>
		<td><%=ambulanceRunRegister.getServiceNo()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		
		<%if(ambulanceRunRegister.getRelation()!=null){ %>		
		<td><%=ambulanceRunRegister.getRelation().getRelationName()%></td>	
		<%}else{ %>
		<td>-</td>
		<%} %>
		
		<%if(ambulanceRunRegister.getRank()!=null){ %>		
		<td><%=ambulanceRunRegister.getRank().getRankName()%></td>	
		<%}else{ %>
		<td>-</td>
		<%} %>
		
		<%if(ambulanceRunRegister.getServicePersonName()!=null){ %>
		<td><%=ambulanceRunRegister.getServicePersonName()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		
		<%if(ambulanceRunRegister.getUnit()!=null){ %>
		<td><%=ambulanceRunRegister.getUnit().getUnitName()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(ambulanceRunRegister.getAge()!=null && ambulanceRunRegister.getSex()!=null ){ %>
		<td><%=ambulanceRunRegister.getAge().concat("/").concat(ambulanceRunRegister.getSex().getAdministrativeSexName())%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if( ambulanceRunRegister.getRemarks()!=null){ %>
		<td><%=ambulanceRunRegister.getRemarks()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>	
		<%if( ambulanceRunRegister.getCharge()!=null){ %>
		<td><%=ambulanceRunRegister.getCharge()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>	
			
	</tr>
	<%i++;} %>
	</table>
	</div>
		<div class="Clear"></div>
	<div class="division"></div>
	<div class="Clear"></div>
<input type="button" name="Back" value="Back" class="button" onclick="submitForm('ambulanceEmergencyRegister','/hms/hms/registration?method=showAmbulanceRegisterReportJsp')" accesskey="r" />
	<div class="Clear"></div>
	<div class="division"></div>
	<div class="Clear"></div>

	

</form>
