<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
List<PhysioRequisitionHeader> therapyList = new ArrayList<PhysioRequisitionHeader>();

if(map.get("therapyList") != null)
{
	therapyList=(List<PhysioRequisitionHeader>)map.get("therapyList");
}
if(therapyList.size() >0){
	for(PhysioRequisitionHeader phyHeader : therapyList){
		String str = "";
		if(phyHeader.getVisit()!=null){
			str = "(OPD)";
		}
%>

<%@page import="jkt.hms.masters.business.PhysioRequisitionHeader"%>


<%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%>
<h6><%= HMSUtil.convertDateToStringWithoutTime(phyHeader.getReqDate())+" "+(phyHeader.getReqTime())+" "+str%></h6>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="opdinvestigationGrid">
	<tr>
		<th scope="col">Therapy Name</th>
		<th colspan="2">Duration</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
	</tr>
	<%
	Set<PhysioRequisitionDetail> phyDetailsSet = phyHeader.getPhysioRequisitionDetails();
	for(PhysioRequisitionDetail phyDetails : phyDetailsSet){
	%>
	<tr>
	<td><%=phyDetails.getTharaphy().getTherapyTypeName() %></td>
	<td><%=phyDetails.getDuration()!=null?phyDetails.getDuration():""%></td><td>min</td>
	<td><%=phyDetails.getFrequency()!=null?phyDetails.getFrequency().getFrequencyName():""%></td>
	<td><%=phyDetails.getNoOfDays()!=null?phyDetails.getNoOfDays():""%></td>
	</tr>
	<%} %>
</table>
</div>
<div class="paddingTop15"></div>
<%}
}
%>