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

String userName = "";
if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
}
int hospitalId=0;
if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");	 
String currentTime = (String)utilMap.get("currentTime");

List<TherapyHeader> therapyList  = null;
if(map.get("therapyList") != null){
	therapyList=(List<TherapyHeader>)map.get("therapyList");
}
 
%>

<div class="popupbg">
<div class="clear"></div>
<div class="clear"></div>
<div>

<%if(therapyList.size()>0){ %>	
<label>Previous Session List</label> 
	 <table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header">


	<thead>
		<tr>
			<!--   			<td width="5%" class="gridheaderlabel">Test Code</td> -->
			<!--   			<td width="10%" class="gridheaderlabel">Main Test Name</td> -->
			  			<th>Prescribed Date/Time</th>
			            <th>Department</th>
			            <th>Doctor</th>
			            <th>Session</th>
			            
			            
			<!-- <th>DICOM View</th> -->
		</tr>
	</thead>
	<tbody>
	<%for(TherapyHeader thPHd:therapyList){ %>
	  
	  <tr>
	  <td><%= thPHd.getProcedureDate()!=null?HMSUtil.convertDateTypeToStringWithoutTime(thPHd.getProcedureDate())+" ("+thPHd.getProcedureTime()+")":""%></td>
	  <td><%=thPHd.getVisit().getDepartment().getDepartmentName()%></td>
	 <td><%=thPHd.getVisit().getDoctor().getFirstName()%></td>
	 <td><input type="button"  id="issue" name="issue" value="History" class="button" onclick="openWindow('/hms/hms/opd?method=getTherapyHistory&therapuHdId=<%=thPHd.getId()%>')" /></td>
	  </tr>
	<%} %>
	
	</tbody>
	</table>
	 <%}else{ %>
	<h4> No record.</h4>
	 <%} %>
	</div>
	
	
	</div>	
