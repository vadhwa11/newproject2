<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.AirCraftEmergency"%>
<%@page import="jkt.hms.masters.business.MhReferral"%>
<%@page import="jkt.hms.masters.business.AmbulanceRunRegister"%>
<%@page import="jkt.hms.masters.business.PatientDetentionRegister"%>
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
	List<PatientDetentionRegister> patientDetentionRegisterList = new ArrayList<PatientDetentionRegister>();

	List<Object[]> unitList = new ArrayList<Object[]>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");

		
	if(map.get("patientDetentionRegisterList") != null){
		patientDetentionRegisterList=(List<PatientDetentionRegister>)map.get("patientDetentionRegisterList");
		
	}
	
	
	%>
<form name="aiercraftEmergencyRegister"  method="post" action="">
<div class="titleBg">
<h2>Patient Detention Register Report</h2></div>
<div class="Clear"></div>
<div class="cmntableWithHeight">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col"> Date </th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
		<th scope="col">Trade</th>
		<th scope="col">Age/Gender</th>		
		<!--<th scope="col">Diagnosis</th>		
		--><th scope="col">MO/MA</th>
		<th scope="col">Detained From Date</th>		
		<th scope="col">Detained To Date</th>
		<th scope="col">Treatment</th>

	
	</tr>
		<tr>
	<%
	int i=1;
	for(PatientDetentionRegister patientDetentionRegister : patientDetentionRegisterList){
		%>
		<td><%=i %></td>
		<%if(patientDetentionRegister.getDetentionRegisterDate()!=null) { %>
		<td><%=HMSUtil.convertDateToStringWithoutTime(patientDetentionRegister.getDetentionRegisterDate()) %></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(patientDetentionRegister.getHin()!=null){ %>
		<td><%=patientDetentionRegister.getHin().getServiceNo()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(patientDetentionRegister.getHin()!=null){ 
		
		%>
		<td><%=patientDetentionRegister.getHin().getPFirstName()+" "+(patientDetentionRegister.getHin().getPMiddleName()!=null?patientDetentionRegister.getHin().getPMiddleName():"")+" "+(patientDetentionRegister.getHin().getPLastName()!=null?patientDetentionRegister.getHin().getPLastName():"")%></td>
		<% }else{ %>
		<td>-</td>
		<%} %>
		<%if(patientDetentionRegister.getHin()!=null){ %>
		<td><%=patientDetentionRegister.getHin().getRelation().getRelationName()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%
		if(patientDetentionRegister.getHin()!=null){
		 %>
		<td><%=patientDetentionRegister.getHin().getRank().getRankName()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%
			if(patientDetentionRegister.getHin()!=null && patientDetentionRegister.getHin().getSFirstName()!=null){
			
		 %>
		<td><%=patientDetentionRegister.getHin().getSFirstName()+" "+(patientDetentionRegister.getHin().getSMiddleName()!=null?patientDetentionRegister.getHin().getSMiddleName():"")+" "+(patientDetentionRegister.getHin().getSLastName()!=null?patientDetentionRegister.getHin().getSLastName():"")%></td>
		<% }else{ %>
		<td>-</td>
		<%} %>
		
		<%if(patientDetentionRegister.getHin()!=null){ %>		
		<td><%=patientDetentionRegister.getHin().getUnit().getUnitName()%></td>	
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(patientDetentionRegister.getHin()!=null && patientDetentionRegister.getHin().getTrade()!=null){ %>		
		<td><%=patientDetentionRegister.getHin().getTrade().getTradeName()%></td>	
		<%}else{ %>
		<td>-</td>
		<%} %>
		
		<%if(patientDetentionRegister.getHin()!=null){ %>		
		<td><%=patientDetentionRegister.getHin().getAge().concat("/").concat(patientDetentionRegister.getHin().getSex().getAdministrativeSexName())%></td>	
		<%}else{ %>
		<td>-</td>
		<%} %>
		
		<%--<%if(patientDetentionRegister.getHin().getDrugAllergies()!=null){ %>
		<td><%=patientDetentionRegister.getHin().getDrugAllergies()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %> --%>
		
		<%
		if(patientDetentionRegister.getMedicalOfficer()!=null){ %>
		<td><%=patientDetentionRegister.getMedicalOfficer().getRank().getRankName()+" " +patientDetentionRegister.getMedicalOfficer().getFirstName()+" "+(patientDetentionRegister.getMedicalOfficer().getMiddleName()!=null?patientDetentionRegister.getMedicalOfficer().getMiddleName():"")+" "+(patientDetentionRegister.getMedicalOfficer().getLastName()!=null?patientDetentionRegister.getMedicalOfficer().getLastName():"")%></td>
		<%}else{ %>
		<td>-</td>
		<% }%>
		<%if(patientDetentionRegister.getDetainedFrom()!=null && !(patientDetentionRegister.getDetainedFrom().equals(""))){ %>
		<td><%=HMSUtil.convertDateToStringWithoutTime(patientDetentionRegister.getDetainedFrom())%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%
		if( patientDetentionRegister.getDetainedTo()!=null && !(patientDetentionRegister.getDetainedTo().equals(""))){ %>
		<td><%=HMSUtil.convertDateToStringWithoutTime(patientDetentionRegister.getDetainedTo())%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>	
		<%if( patientDetentionRegister.getTreatment()!=null){ %>
		<td><%=patientDetentionRegister.getTreatment()%></td>
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
<input type="button" name="Back" value="Back" class="button" onclick="javascript:history.back()" accesskey="r" />
	<div class="Clear"></div>
	<div class="division"></div>
	<div class="Clear"></div>
</form>