<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	List<StoreIpIssueT> ipIssueDetailList = new ArrayList<StoreIpIssueT>();
	if (map.get("ipIssueDetailList") != null) {
		ipIssueDetailList = (List<StoreIpIssueT>) map.get("ipIssueDetailList");

	}
	if (map.get("frequencyList") != null) {
		frequencyList = (List<MasFrequency>) map.get("frequencyList");
	}
	
%>



<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueT"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<div class="Clear paddingTop15"></div>
<div class="Clear"></div>
<h4>Issue Medicine Details</h4>
<div class="Clear"></div>
<div class="Clear paddingTop15"></div>
<table>
<tr>
			<th>Nomenclature</th>
			<th>Issue Date</th>
			<th>Issue Time</th>
			<th>Dosage</th>
			<th>Frequency</th>
			<th>No. of Days</th>
			<th>Route</th>
			

</tr>
<%

if(ipIssueDetailList.size()>0){
		for(StoreIpIssueT storeIpIssueT:ipIssueDetailList){
	
			
%>

<tr>
	<%if(storeIpIssueT.getItem() != null){ %>
	<td><%=storeIpIssueT.getItem().getNomenclature() %></td>
	<%} %>
	<td><%=HMSUtil.convertDateToStringWithoutTime(storeIpIssueT.getIpIssue().getIpIssueDate()) %></td>
	<td><%=storeIpIssueT.getIpIssue().getIpIssueTime() %></td>
	<td><%=storeIpIssueT.getPrescriptionDetail().getDosage() %></td>
	<%if(storeIpIssueT.getPrescriptionDetail()!= null){
	if(storeIpIssueT.getPrescriptionDetail().getFrequency() != null){ %>
	<td><%=storeIpIssueT.getPrescriptionDetail().getFrequency().getFrequencyName() %></td>
	<%}} %>
	<%if(storeIpIssueT.getPrescriptionDetail() != null){ %>
	<td><%=storeIpIssueT.getPrescriptionDetail().getNoOfDays() %></td>
	<%} %>
	<%if(storeIpIssueT.getPrescriptionDetail() != null){ %>
	<td><%=storeIpIssueT.getPrescriptionDetail().getRoute()!=null?storeIpIssueT.getPrescriptionDetail().getRoute():" "%></td>
	<%} %>

</tr>
<%
}}else{ %>
<tr><td colspan="7">No Records Found</td></tr>
<%} %>
</table>
<div class="Clear paddingTop15"></div>
<input type="button" name="close" value="Close" class="button" onclick="window.close()"/>
