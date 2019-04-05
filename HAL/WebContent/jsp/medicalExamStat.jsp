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
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"
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
			List<MasMedicalExaminationReportOnEntry> medicalExamdetail = new ArrayList<MasMedicalExaminationReportOnEntry>();
			if(map.get("patientDetailList")!=null){
				medicalExamdetail = (List<MasMedicalExaminationReportOnEntry>)map.get("patientDetailList");
			}
			Box box = HMSUtil.getBox(request);
			session.setAttribute("box",box);
	%>

<div class="titleBg">
<h2>MedicalExam Register</h2>
</div>
<div class="Clear"></div>
<form name="medExamRegister" method="post" action="">
<% if(medicalExamdetail.size() >0){ %>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">Date</th>
		<th scope="col">Service No.</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Trade</th>
		<th scope="col">Unit</th>
		<th scope="col">Age</th>
		<th scope="col">Height</th>
		<th scope="col">ABW</th>
		<th scope="col">IBW</th>
		<th scope="col">BMI</th>
		<th scope="col">Waist</th>
		<th scope="col">Hip</th>
		<th scope="col">Whr</th>
		<th scope="col">Pulse</th>
		<th scope="col">BP</th>
		<th scope="col">Med Cat</th>
		<th scope="col">OW</th>
		<th scope="col">Sign MO</th>
	</tr>
		<tbody id="tableData">
<%
	int i=1;
	for(MasMedicalExaminationReportOnEntry masMedicalExam: medicalExamdetail){
		%>
		<tr>
		<td><%= i %></td>
		<%if(masMedicalExam.getDateOfCompletion() != null){ %>
		<td><%=HMSUtil.convertDateToStringWithoutTime((masMedicalExam.getDateOfCompletion()))%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(masMedicalExam.getServiceNo() !=  null){ %>
		<td><%=masMedicalExam.getServiceNo()%></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%if(masMedicalExam.getRank() != null){ %>
		<td><%= masMedicalExam.getRank().getRankName() %></td>
		<%}else{ %>
		<td>-</td>
		<%} %>
		<%String patientName="";
		if(masMedicalExam.getHin().getPFirstName()!= null){
		patientName=masMedicalExam.getHin().getPFirstName();
		}
		if(masMedicalExam.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+masMedicalExam.getHin().getPMiddleName();
		}
		if(masMedicalExam.getHin().getPLastName()!= null){
		patientName=patientName+" "+masMedicalExam.getHin().getPLastName();
		} %>
		<td><%=patientName%></td>
		<%if(masMedicalExam.getTrade()!= null){ %>
		<td><%=masMedicalExam.getTrade().getTradeName()%></td>
		<%}else{ %>
		<td></td>
		<%} %>
		<td><%=masMedicalExam.getUnit().getUnitName()%></td>
		<td><%=masMedicalExam.getApparentAge()%></td>
		
		<%if(masMedicalExam.getHeight()!=null){%>
		<td><%=masMedicalExam.getHeight()%></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		<%if(masMedicalExam.getActualweight() != null){ %>
		<td><%=masMedicalExam.getActualweight() %></td>
		<%}else{ %>
		<td></td>
		<%} %>
		<%if(masMedicalExam.getIdealweight()!= null ){%>
		<td><%=masMedicalExam.getIdealweight()%></td>
		<%}else{%>
		<td></td>
		<%} %>
		<%if(masMedicalExam.getBhi() != null){ %>
		<td><%=masMedicalExam.getBhi()%></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		
		<%if(masMedicalExam.getWaist() != null){ %>
		<td><%=masMedicalExam.getWaist()%></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		
		<%if(masMedicalExam.getHips() != null){ %>
		<td><%=masMedicalExam.getHips()%></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		
		<%if(masMedicalExam.getWhr() != null){ %>
		<td><%=masMedicalExam.getWhr()%></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		
		<%if(masMedicalExam.getPulseRates() != null){ %>
		<td><%=masMedicalExam.getPulseRates()%></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		
		<%if(masMedicalExam.getBp() != null){ %>
		<td><%=masMedicalExam.getBp()%></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		
		<%if(masMedicalExam.getHin().getCategory() != null){ %>
		<td><%=masMedicalExam.getHin().getCategory().getCategories()%></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		
		<%if(masMedicalExam.getOverweight() != null){ %>
		<td><%=masMedicalExam.getOverweight()%></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		
		<%if(masMedicalExam.getSignedBy()!= null){ %>
		<td><%=masMedicalExam.getSignedBy()%></td>
		<%}else{ %>
		<td>&nbsp;</td>
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
	<%}else{ %>
	<h4>No Records Found</h4>
	
	<%} %>
<div class="Clear"></div>
<div class="division"></div>
<%-- <input type="button" name="print" value="Print" class="button" onClick="submitForm('medExamRegister','registration?method=showOPDRegisterReport');" />
<input type="button" name="graph" value="Show Graph" class="button" onClick="openGraph();" />--%>
<input type="button" name="print" value="Print" class="button" onClick="submitForm('medExamRegister','medicalExam?method=showMeStaticsReport');" />
<input type="button" name="Back" value="Back" class="button" onclick="submitForm('medExamRegister','medicalExam?method=pendingMDWatingList')" accesskey="r" />

</form>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<script>
function openGraph(){
	var url = "registration?method=showOPDStatisticsGraph";
	window.open(url,'windowRef','width=600,height=400,scrollbars = yes');
	
}
</script>



