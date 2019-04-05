<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
		}
		List<StoreInternalIndentM> internalIndentMs=new ArrayList<StoreInternalIndentM>();
		if(map.get("internalIndentMs")!=null){
			internalIndentMs = (List<StoreInternalIndentM>)map.get("internalIndentMs");
		}
		String currentDate =(String)HMSUtil.getCurrentTimeWithoutSecond().get("currentDate");
		String fromDate = currentDate;
		String toDate = currentDate;
		if(map.get("fromDate")!=null)
			fromDate = (String)map.get("fromDate");
		if(map.get("toDate")!=null) 
			toDate = (String)map.get("toDate");
		String msg = "";
		if(map.get("msg")!=null){
			msg = (String)map.get("msg");
		}
	%>
<script type="text/javascript">
serverdate = '<%=currentDate%>'
</script>
<div class="clear"></div>
<%if(msg!=""){if(msg=="Try Again!"){out.write("<div class='alertDiv'>"+msg+"</div>");}else{out.write("<div class='successDiv'>"+msg+"</div>");}} %>
<div class="clear"></div>
<div class="titleBg">
<h2>MR Tracking</h2>
</div>
<div class="clear"></div>

<form name="search" id="facPriscription" method="post" action="">
<input type="hidden" name="employeeId" value="" />
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>From Date</label>
<input id="fromDate" class="calDate" name="fromDate" readonly="readonly" value="<%=fromDate %>" tabindex="1" maxlength="30" type="text">
<img id="calendar" class="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" onclick="setdate('<%=fromDate %>',document.search.fromDate, event)" width="16" border="0" height="16">
<label>To Date</label>
<input id="toDate" class="calDate" name="toDate" readonly="readonly" value="<%=toDate %>" tabindex="1" maxlength="30" type="text">
<img id="calendar" class="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" onclick="setdate('<%=toDate %>',document.search.toDate, event)" width="16" border="0" height="16">
</div>
<div class="clear"></div>
<input class="buttonSm" name="Button2" value="Search" onclick="submitForm('search','/hms/hms/stores?method=showIndentHistoryJsp');" type="button" />
</form>
<div class="clear"></div>
<%if(internalIndentMs.size()>0){ %>
<h4>MR  List</h4>
<table>
		<thead><tr><th>S.No.</th><th>MR No.</th><th>Requested By</th><th>MR Date</th><th>Status</th><th>Details</th>
		<th></th>
		</tr></thead>
		<tbody>
		<%int count = 1;
		String status="N/A";
		for(StoreInternalIndentM indentM:internalIndentMs){ 
			if(indentM.getStatus().equals("u")) 
				status="Not Submit.";
			if(indentM.getStatus().equals("o")) 
				status="Waiting For Issue.";
			if(indentM.getStatus().equals("y") && indentM.getReceivedStatus()==null) 
				status="Waiting For Receive.";
			if(indentM.getStatus().equals("y") && indentM.getReceivedStatus()!=null){
				if(indentM.getReceivedStatus().equals("y"))
					status="Received.";
			}
		%>
			<tr>
			<td><%=count %></td>
			<td><%=indentM.getDemandNo() %></td>
			<td><%=indentM.getRequestedBy().getFirstName()+" "+(indentM.getRequestedBy().getMiddleName()!=null?indentM.getRequestedBy().getMiddleName():"")+" "+indentM.getRequestedBy().getLastName()  %></td>
			<td><%=HMSUtil.convertDateToStringFormat(indentM.getDemandDate(), "dd/MM/yyyy") %></td>
			<td><%=status %></td>
			<td><a href="#" onclick="openPopupWindow(<%=indentM.getId()%>)">details</a></td>
			<td>
			<%if(indentM.getStatus().equals("o")){ %>
			<input type="button" value="Print" class="button" onClick="submitForm('search','/hms/hms/stores?method=printDispensaryToStoreJsp&mrId=<%=indentM.getId()%>');" />
			<%}	if(indentM.getStatus().equals("y") && indentM.getReceivedStatus()==null){ %>
			
			<%-- <input type="button" value="Print" class="button" onClick="submitForm('search','/hms/hms/stores?method=printDispensaryToStoreRJsp&flags=wr&demandNo=<%=indentM.getDemandNo()%>);" /> --%>
			<% }if(indentM.getStatus().equals("y") && indentM.getReceivedStatus()!=null){ %>
			
			<%-- <input type="button" value="Print" class="button" onClick="submitForm('search','/hms/hms/stores?method=printDispensaryToStoreRJsp&flags=r&demandNo=<%=indentM.getId()%>');" /> --%>
			<% }%>
			</td>
			
			
			</tr>
		<%count++;} %>
		</tbody>
</table>
<%}else{out.write("<span>MR Not Available!</span>");} %>
<div class="clear"></div>

<script type="text/javascript">
function openPopupWindow(id)
{
	var url="/hms/hms/stores?method=indentTrackingHistoryJsp&indentId="+id;
	newwindow=window.open(url,'name','top=0, left=5, height=650,width=1010,status=1,scrollbars=yes');
}
</script>
