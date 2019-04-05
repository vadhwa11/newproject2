<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<%
	Map<String, Object> map=new HashMap<String, Object>();
	StoreInternalIndentM internalIndentM =null;
	List<? extends Object> indentDetailList = null;
	if(request.getAttribute("map")!=null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("internalIndentM")!=null){
		internalIndentM = (StoreInternalIndentM)map.get("internalIndentM");
	}
	if(map.get("indentDetailList")!=null){
		indentDetailList = (List<? extends Object>)map.get("indentDetailList");
	}
%>
<div id="mainIn">
<div class="clear"></div>
<div class="titleBg">
<h2>MR Tracking Details</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
	<%if(internalIndentM!=null){ %>
	<label>	MR No.</label>
	<label class="value"><%=internalIndentM.getDemandNo() %></label>
	<label>Requested By</label>
	<label class="value"><%=internalIndentM.getRequestedBy().getFirstName()+" "+(internalIndentM.getRequestedBy().getMiddleName()!=null?internalIndentM.getRequestedBy().getMiddleName():"")+" "+internalIndentM.getRequestedBy().getLastName() %></label>
	<label>Request Date</label>
	<label class="value"><%=HMSUtil.convertDateToStringFormat(internalIndentM.getDemandDate(), "dd/MM/yyyy") %></label>
	<%} %>
</div>
<h4>Indent Items</h4>
<%int count = 1;
StoreInternalIndentT indentT = null;
StoreIssueT issueT = null;
String status = "N/A";
if(indentDetailList!=null){ %>
<table>
		<thead><tr><th>S.No.</th><th>MAT Code</th><th>Item Name</th><th>Request Qty.</th><th>Issue Qty.</th><th>Status</th></tr></thead>
		<tbody>
		<%for(Object obj:indentDetailList){
			if(obj instanceof StoreInternalIndentT){
				indentT = (StoreInternalIndentT)obj;
				if(indentT.getInternal().getStatus().equals("u")) 
					status="Not Submit.";
				if(indentT.getInternal().getStatus().equals("o")) 
					status="Waiting For Issue.";
				if(indentT.getInternal().getStatus().equals("y")  && indentT.getQtyIssued()!=null) 
					status="Waiting For Receive.";
				if(indentT.getInternal().getStatus().equals("y")  && indentT.getQtyIssued()==null) 
					status="Not Issue.";
				if(indentT.getInternal().getStatus().equals("y") && indentT.getInternal().getReceivedStatus()!=null && indentT.getQtyIssued()!=null){
					if(indentT.getInternal().getReceivedStatus().equals("y"))
						status="Received.";
				}
		%>
		<tr><td><%=count %></td><td><%=indentT.getItem().getPvmsNo() %></td><td><%=indentT.getItem().getNomenclature() %></td><td><%=indentT.getQtyRequest()%></td><td><%=indentT.getQtyIssued()!=null?indentT.getQtyIssued():"......"%></td><td><%=status %></td></tr>
		<%}/* if(obj instanceof StoreIssueT){
			issueT = (StoreIssueT)obj;
			if(issueT.getIssueM().getRequestNo().getStatus().equals("u")) 
				status="Not Submit.";
			if(issueT.getIssueM().getRequestNo().getStatus().equals("o")) 
				status="Waiting For Issue.";
			if(issueT.getIssueM().getRequestNo().getStatus().equals("y") && issueT.getIssueM().getRequestNo().getReceivedStatus()==null) 
				status="Waiting For Receive.";
			if(issueT.getIssueM().getRequestNo().getStatus().equals("y") && issueT.getIssueM().getRequestNo().getReceivedStatus()!=null){
				if(issueT.getIssueM().getRequestNo().getReceivedStatus().equals("y"))
					status="Received.";
			} */
		%>
		<%-- <tr><td><%=count %></td><td><%=issueT.getItem().getPvmsNo() %></td><td><%=issueT.getItem().getNomenclature() %></td><td><%=issueT.getQtyRequest() %></td><td><%=issueT.getQtyIssued()!=null ? issueT.getQtyIssued():"..." %></td><td><%=status %></td></tr>
		<%} %> --%>
		</tbody>
<%count++;}%>
</table>
<%}else{out.write("<span>Details Not Availble!</span>");}%>
</div>