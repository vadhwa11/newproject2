<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>



<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.util.Box"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<div id="contentHolder"><script type="text/javascript"
	language="javascript">
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
	</script> <%
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		 	Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			List<Object[]> physiotheraphyAppointmentList = new ArrayList<Object[]>();
					
			if(map.get("physiotheraphyAppointmentList")!=null){
				physiotheraphyAppointmentList = (List<Object[]>)map.get("physiotheraphyAppointmentList");
			}
			Box box = HMSUtil.getBox(request);
			session.setAttribute("box",box);
	%>

<div class="titleBg">
<h2>Physiotherapy Appointment Register</h2>
</div>
<div class="Clear"></div>
<form name="physioAppointmentRegister" method="post" action="">
<% if(physiotheraphyAppointmentList.size() >0){ %>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl.No.</th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
		<th scope="col">Medical Officer</th>
		<th scope="col">Therapy</th>
		<th scope="col">App.Date</th>
		<th scope="col">App.Time</th>
		<th scope="col">No.of Days</th>
		<th scope="col">Duration</th>
	</tr>
		<tbody id="tableData">
<%
	int i=1;
	for(Object[] physioAppointment : physiotheraphyAppointmentList){
		%>
		<tr>
		<td><%= i %></td>
		<%if(physioAppointment[0] != null){ %>
		<td><%= physioAppointment[0] %></td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		<%if(physioAppointment[1] != null){ %>
		<td><%= physioAppointment[1] %></td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		<%if(physioAppointment[10] != null){ %>
		<td><%= physioAppointment[10] %></td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		<%if(physioAppointment[9] != null){ %>
		<td><%= physioAppointment[9] %></td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		<%if(physioAppointment[8] != null){ %>
		<td><%= physioAppointment[8] %></td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		<%if(physioAppointment[11] != null){ %>
		<td><%= physioAppointment[11] %></td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		<%if(physioAppointment[12] != null){ %>
		<td><%= physioAppointment[12] %></td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		<%if(physioAppointment[2] != null){ %>
		<td><%= physioAppointment[2] %></td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		<%if(physioAppointment[4] != null){ %>
		<td><%=HMSUtil.convertDateToStringWithoutTime((Date)physioAppointment[4])%></td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		<%if(physioAppointment[5] != null){ %>
		<td><%=physioAppointment[5] %></td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		<%if(physioAppointment[6] != null){ %>
		<td><%= physioAppointment[6] %></td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		<%if(physioAppointment[7] != null){ %>
		<td><%= physioAppointment[7]+" "+"min" %></td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		
		</tr>
	<%i++;}
%>
</tbody>
</table>
<script>
		var pager = new Pager('tableData',20);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
	<%} %>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="Print" value="Print" class="button" onClick="submitForm('physioAppointmentRegister','/hms/hms/physiotherapy?method=printPhyAppintmentRegisterReport')" />


<div class="Clear"></div>
<script>
function openGraph(){
	var url = "physiotherapy?method=showPhysioTherapyTreatmentRegiterGraph&"+getNameAndData('phyTreatmentRegister');
	window.open(url,'windowRef','width=600,height=400,scrollbars = yes');
}
function datevalidation(){
	
	
	var fdate = document.getElementById('FromDateId');
	var tdate = document.getElementById('ToDateId');
	
	frdate  = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2));
	todate  = new Date(tdate.value.substring(6),(tdate.value.substring(3,5) - 1) ,tdate.value.substring(0,2));
	
	
	if(fdate.value != "" && todate.value != ""){
	 if(frdate > todate){
	  alert("To Date should be greater than or equal to the From Date.");
	   return false;
	  }
	}else{
	 return false;
	}
	return true;	
		
		}
</script>




