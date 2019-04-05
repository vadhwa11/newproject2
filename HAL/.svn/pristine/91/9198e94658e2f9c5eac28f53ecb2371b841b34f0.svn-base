<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>
<!--
Code for Logout after session Expired
Code By Mukesh Narayan Singh
Date 19 Aug 2010
 -->


<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<form name="hic" method="post" action="">
<script>
function disableKey(event){

  if (!event) event = window.event;

  if (!event) return;


  var keyCode = event.keyCode ? event.keyCode : event.charCode;


  //window.status = keyCode;

  // keyCode for F% on Opera is 57349 ?!



  if (keyCode == 116) {

   window.status = "F5 key detected! Attempting to disabling default response.";

   window.setTimeout("window.status='';", 2000);

   // Standard DOM (Mozilla):

   if (event.preventDefault) event.preventDefault();

   //IE (exclude Opera with !event.preventDefault):

   if (document.all && window.event && !event.preventDefault) {

     event.cancelBubble = true;

     event.returnValue = false;

     event.keyCode = 0;

   }

   return false;

  }

}



document.onkeydown = disableKey; // register listener function

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>



<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;


	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}

  	Map map = new HashMap();
  
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
	}


	List<MasMedicalExaminationReportOnEntry> medExamList  = new ArrayList<MasMedicalExaminationReportOnEntry>();
	if (map.get("medExamList")!=null)
	{
		medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
	}
	



%>
<div class="titleBg"><h2>Medical Exam Details</h2></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="clear"></div>
<%
	if(medExamList.size() > 0){
%>
<table width="100%" colspan="7" border="00" cellpadding="0"	cellspacing="0">
	<tr>
		<th></th>
		<th>Service No</th>
		<th>Name</th>
		<th>Rank</th>
		<th>Unit</th>
		<th>Exam Type</th>
		<th>Exam Date</th>
		
	</tr>
<%
int i=1;
	for(MasMedicalExaminationReportOnEntry medExam : medExamList){

	
%>
<tr>
<td><input type="radio" id name="medExam" value="<%= i %>"/>
<td><%=medExam.getServiceNo() %></td>
<td><%=medExam.getNameInFull() %></td>
<td><%=medExam.getRank().getRankName() %></td>
<td><%=medExam.getUnit().getUnitName() %></td>
<td><%=medExam.getMedicalExamType() %></td>
<%
if(medExam.getDateMedicalBoardExam()!=null){
%>
<td><%=HMSUtil.convertDateToStringWithoutTime(medExam.getDateMedicalBoardExam()) %></td>
<%}else{ %>
<td>&nbsp;</td>
<%} %>
<input type="hidden" name="medExamId<%=i %>" value="<%= medExam.getId() %>"/>
<input type="hidden" name="serviceNo<%=i %>" value="<%= medExam.getServiceNo() %>"/>
</td>

</tr>

<%i++;} %>
</table>
<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="ok" value="Ok" onclick="checkoutToHic();" class="button"/>
<input type="button" name="close" value="Close" onclick="window.close();" class="button"/>

<script>

function checkoutToHic(){
//var cnt = document.getElementById('medExam').value;
//var medExamId = document.getElementById('medExamId'+cnt).value;
//var srNo = document.getElementById('serviceNo'+cnt).value;

var url = "http://192.168.0.2/fingerprintclient/Default.aspx?serviceno=242982&requesttype=FORM3B&regsysid=745";
document.hic.action=url;
document.hic.submit();
}
</script>
</form>