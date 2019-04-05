<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>

<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.AirCraftEmergency"%>
<%@page import="jkt.hms.masters.business.MhReferral"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
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
	List<MhReferral> mhReferralList = new ArrayList<MhReferral>();

	List<Object[]> unitList = new ArrayList<Object[]>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");

		
	if(map.get("mhReferralList") != null){
		mhReferralList=(List<MhReferral>)map.get("mhReferralList");
	}
	
	
	%>
<form name="mhRun" method="post" action="">
<div class="titleBg">
<h2>MH Run Register</h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">Run Date </th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
		<th scope="col">Age/Gender</th>		
		<th scope="col">Diagnosis</th>		
		<th scope="col">Referred To</th>
		<th scope="col">Referred By</th>
		<th scope="col">Referred Date</th>		
		<th scope="col">Mobile No</th>		
	</tr>
		<tr>
	<%
	int i=1;
	for(MhReferral mhReferral : mhReferralList){
		%>
		<td><%=i %></td>
		<%if(mhReferral.getRunDate()!=null) {%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(mhReferral.getRunDate()) %></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(mhReferral.getServiceNo()!=null){ %>
		<td><%=mhReferral.getServiceNo() %></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(mhReferral.getPatientName()!=null){ %>
		<td><%=mhReferral.getPatientName()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(mhReferral.getRelation()!=null){ %>
		<td><%=mhReferral.getRelation().getRelationName()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%
		if(mhReferral.getServicePersonName()!=null){
		 %>
		<td><%=mhReferral.getServicePersonName()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(mhReferral.getHin()!=null){ %>		
		<td><%=mhReferral.getHin().getUnit().getUnitName()%></td>	
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(mhReferral.getHin().getAge()!=null && mhReferral.getHin().getSex()!=null){ %>
		<td><%=mhReferral.getHin().getAge().concat("/").concat(mhReferral.getHin().getSex().getAdministrativeSexName())%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(mhReferral.getDiagnosis()!=null ){ %>
		<td><%=mhReferral.getDiagnosis()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if( mhReferral.getReferTo()!=null){ %>
		<td><%=mhReferral.getReferTo()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>	
		<%if( mhReferral.getReferredBy()!=null){ %>
		<td><%=mhReferral.getReferredBy().getRank().getRankName()+" "+ mhReferral.getReferredBy().getFirstName().concat(" ").concat(mhReferral.getReferredBy().getLastName())%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>	
		<%if( mhReferral.getReferralDate()!=null){ %>
		<td><%=HMSUtil.convertDateToStringWithoutTime(mhReferral.getReferralDate())%></td>
		<%}else{ %>
		<td>-</td>
		<%} 
		
		if( mhReferral.getMobileNo()!=null){ %>
		<td><%=mhReferral.getMobileNo() %></td>
		<%}else{ %>
		<td>-</td>
		<%}%>	
	</tr>
	<% i++;}%>
	</table>
	</div>
	<div class="Clear"></div>
	<div class="division"></div>
	<div class="Clear"></div>
<input type="button" name="Back" value="Back" class="button" onclick="submitForm('mhRun','/hms/hms/registration?method=showMHReferralRegisterReportJsp')" accesskey="r" />
	<div class="Clear"></div>
	<div class="division"></div>
	<div class="Clear"></div>
</form>
