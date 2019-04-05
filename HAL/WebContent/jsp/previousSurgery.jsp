<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/opd.js"></script>
	

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>


<!--<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
-->
<!--</script>
-->
<!--<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
-->
<!--  By Vishnu -->
<%



Map map = new HashMap();
//String includedJsp = null;
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

}

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");	 
String currentTime = (String)utilMap.get("currentTime");

List<OtBookingDt> previousSurgeryList  = null;
if(map.get("previousSurgeryList") != null){
	previousSurgeryList=(List<OtBookingDt>)map.get("previousSurgeryList");
}

String allSurgeryType ="n";

if(map.get("allSurgeryType") != null){
	allSurgeryType=(String)map.get("allSurgeryType");
}
String majSur = HMSUtil.getProperties("adt.properties", "subChargeCodeForMajorSurgery");
String minSur = HMSUtil.getProperties("adt.properties", "subChargeCodeForMinorSurgery");

%>

<div class="popupbg">
<div class="clear"></div>
<div class="clear"></div>
<form name="search"  method="post" action=""></form>
<div class="Block" style="width:978px;">
<%if(previousSurgeryList.size()>0){ int c=0; %>	
<h4>Previous Minor Surgery List</h4> 
	 <table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header">


	<thead>
		<tr>
			  			<th>S.No</th>
			  			 <th>Relation</th>
			            <th>Surgery Name</th>
			            <th>Surgery Type</th>
			            <th>Surgery Date</th>
			            <th>Surgery Status</th>
			            <th>Surgery Notes</th>
			            <th>Report</th>
			            
			            
			<!-- <th>DICOM View</th> -->
		</tr>
	</thead>
	<tbody>
	<%
	String status="";
	for(OtBookingDt srDt:previousSurgeryList){ status=""; %>
	  
	 
	  <tr>
	  <td><%= ++c%></td>
	  <td><%if(srDt.getOtBookingHd().getVisit()!=null && srDt.getOtBookingHd().getVisit().getHin().getRelation()!= null){ %>
			<%=srDt.getOtBookingHd().getVisit().getHin().getRelation().getNewRelationName() %>
			<%}%></td>
			
	  <td><%= srDt.getOtPreAnesthesiaDetail()!=null?srDt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getChargeCode().getChargeCodeName():""%></td>
	  <td>
		<%if(majSur.equalsIgnoreCase(srDt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getChargeCode().getSubChargecode().getSubChargecodeCode())) {%>
		Major
		<%}
		else if(minSur.equalsIgnoreCase(srDt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getChargeCode().getSubChargecode().getSubChargecodeCode())) {%>
		Minor
		<%}%>
	  </td>
	  <td><%= srDt.getOtBookingHd().getSurgeryDate()!=null?HMSUtil.convertDateTypeToStringWithoutTime(srDt.getOtBookingHd().getSurgeryDate()):""%></td>
	  <td><% if(srDt.getStatus().equalsIgnoreCase("y") || srDt.getStatus().equalsIgnoreCase("d"))
		       status = "Completed";
			 else if(srDt.getStatus().equalsIgnoreCase("n"))
			       status = "Pending";
			 else if(srDt.getStatus().equalsIgnoreCase("c"))
			       status = "Cancelled";
			 
	  %>
	  <%=status%> <%=srDt.getStatus().equalsIgnoreCase("c")?"<br/><hr>"+srDt.getOtBookingHd().getCancelRemarks():""%>
	  </td>
	 <td><%=srDt.getOtBookingHd().getAdditionalNotes()!=null?srDt.getOtBookingHd().getAdditionalNotes():""%></td>
	 <td>
	 <%if(status.equals("Completed")){%>
	 <input name="yes" value="Print" class="button" onclick="submitForm('search','/hms/hms/ot?method=generateOperativeNotesReport&amp;bookingId=<%=srDt.getOtBookingHd().getId()%>');" type="button"></td>
	 <%} %>
	  </tr>
	<%} %>
	
	</tbody>
	</table>
	 <%}else{ %>
	<h4> No record.</h4>
	 <%} %>
	 <%if(allSurgeryType.equals("n")){ %>
	 <input name="add" class="button" value="Close" onclick="window.close();" type="button">
	 <%} %>
	</div>
	</div>	
