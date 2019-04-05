<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
List<DgOrderhd> investigationList = new ArrayList<DgOrderhd>();
List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
if(map.get("investigationList") != null)
{
	investigationList=(List<DgOrderhd>)map.get("investigationList");
}
if(map.get("dgSampleCollectionDetailsList") != null)
{
	dgSampleCollectionDetailsList=(List<DgSampleCollectionDetails>)map.get("dgSampleCollectionDetailsList");
}
if(investigationList.size() >0){
	for(DgOrderhd dgHeader : investigationList){
		String str = "";
		if(dgHeader.getVisit()!=null){
			str = (dgHeader.getDepartment()!=null?dgHeader.getDepartment().getDepartmentName():"");
		}
		
		else if(dgHeader.getInpatient()!=null){
			str = (dgHeader.getDepartment()!=null?dgHeader.getDepartment().getDepartmentName():"");
		}
		
		else if(dgHeader.getSurgery()!=null){
			str = "(OT)";
		}
%>
<h6><%= HMSUtil.convertDateToStringWithoutTime(dgHeader.getOrderDate())+" "+(dgHeader.getOrderTime())+" "+str%></h6>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="opdinvestigationGrid">
	<tr>
		<th scope="col" style="width:50%;">Investigation</th>
		<th style="width:25%;">Status</th>
		<th style="width:25%;">Result</th>
	
	</tr>
	<%
	Set<DgOrderdt> dgDetailsSet =dgHeader.getDgOrderdts();
	String orderNo=dgHeader.getOrderNo();
	boolean flag = true;
	for(DgOrderdt dgDetails : dgDetailsSet){
		flag = true;
		Set<DgSampleCollectionHeader>dgSampleCollectionHeaderSet=dgDetails.getOrderhd().getDgSampleCollectionHeaders();
		String url="/hms/hms/lab?method=investigationResult&orderNo="+orderNo+"&chargeCodeId="+dgDetails.getChargeCode().getId();
	%>
	<tr>
	<td><%=dgDetails.getChargeCode().getChargeCodeName() %></td>
	
	
			
			<%
			
				for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList){
				if(dgSampleCollectionDetails.getOrderdt().getId()==dgDetails.getId())
				{
					flag = false;
			if( dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("P")){
				if(dgSampleCollectionDetails.getRejected() != null &&
						dgSampleCollectionDetails.getRejected().equalsIgnoreCase("y") ){	 %>
				<td>Sample is Rejected <span
					style="color: highlightred; font-weight: bold; font-style: i">(Reason
				: <% if(dgSampleCollectionDetails.getReason() != null){ %> <%=dgSampleCollectionDetails.getReason() %>
				<% } %> ) </span></td>
				<% }else{ %>
				<td>Pending For Sample Validation</td>
				<% } %>

				<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("E")){%>
				<td>Result Entered</td>
				<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("A")){%>
				<td>Sample Pending For Result Entry</td>
				<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("X")){%>
				<td>Test Cancelled</td>
				<%}}} %>
				
				<%if(flag)
				{
					if(dgDetails.getOrderStatus().equalsIgnoreCase("P")){ %>
			<td>Pending</td>
			
			<%
			}else if(dgDetails.getOrderStatus().equalsIgnoreCase("C")){%>
			<td>Sample Collected</td>
			
			<%
			
			}else if(dgDetails.getOrderStatus().equalsIgnoreCase("A")){%>
			<td>Sample Accepted</td>
			
			<%
			
			}else if(dgDetails.getOrderStatus().equalsIgnoreCase("X")){%>
			<td>Test Cancelled</td>
			
			<%
			
			} }%>
	<td><input type="button" accesskey="a" class="button" value="Result" 
			 onclick="javascript:popwindowresult('<%=url%>');" id="print" name="print"></td>
	</tr>
	<%} %>
</table>
</div>
<div class="paddingTop15"></div>
<%}
}
	%>
	
	
	
	
	

	