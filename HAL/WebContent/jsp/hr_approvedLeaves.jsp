<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="jkt.hms.masters.business.HrLeaveDetails"%>
<%@page import="jkt.hms.util.LeaveManagementUtil"%>

<%@page import="jkt.hms.masters.business.HrEncashmentDetails"%>
<form name="<%=APPROVED_LEAVES%>" method="post">
	<div class="titleBg"><h2>Approved Leaves </h2></div>
	<div class="clear"></div>
		<div class="Block">
<%
	Map<String,Object> map=(Map)request.getAttribute("map");;	
	List approvedLeavesList=(List)map.get("approvedLeavesList");
	List<HrEncashmentDetails> approvedLeavesEncashment = (List)map.get("approvedLeavesEncashment");
	//System.out.println("encashment list size :"+approvedLeavesEncashment.size());
	
	if((approvedLeavesList.size()>0 && approvedLeavesList!=null) ||(approvedLeavesEncashment.size()>0 && approvedLeavesEncashment!=null)){
%>
	<div id="pageNavPosition"></div>
	<div class="clear"></div>
<table id="waitingLeavelist" width="575">
 	 		<tr>
		    	<th>From Date</th>
				<th>To Date</th>
				<th>No of Working Days</th>
				<th>Leave Type</th>
				<th>Reason</th>
				<th>Employee Name</th>
			</tr>		
	
		<tbody id="tableData">
		<%		
			
			Iterator iterator=approvedLeavesList.iterator();
			int i=1;
			for(;iterator.hasNext();i++)
			{
				HrLeaveDetails approvedLeaves=(HrLeaveDetails)iterator.next();
				if(i%2==0)
				{
						
		%>
		  		<tr class="odd" onclick="location.href='leave?method=contactDetails&leaveId=<%=approvedLeaves.getId()%>'">
		<%
		  		}
		  		else
		  		{
		%>
		  		<tr class="even" onclick="location.href='leave?method=contactDetails&leaveId=<%=approvedLeaves.getId()%>'">		  		
		<%
		  		}
		%>
			<%if(approvedLeaves.getFromDate()!=null) {%>
		    		<td align="center"><%=LeaveManagementUtil.convertDateToStringWithoutTime(approvedLeaves.getFromDate())%></td>
					<td align="center"><%=LeaveManagementUtil.convertDateToStringWithoutTime(approvedLeaves.getToDate())%></td>
					<%}
					  else{
					%>
					<td align="center">---</td>
					<td align="center">---</td>
					<%} %>
					
					<td align="center"><%=approvedLeaves.getNoOfWorkingDays()%></td>
					<td align="center"><%=approvedLeaves.getLeaveType().getLeaveType().getLeaveType().getDescription()%></td>
					<td align="left"><%=approvedLeaves.getReason()%></td>
					<td align="center"><%=approvedLeaves.getEmpId().getFirstName() %> <%=approvedLeaves.getEmpId().getLastName() %></td>
				</tr>
		<%	}
			
			for(HrEncashmentDetails encashmentDetails:approvedLeavesEncashment){
				if(i%2==0)
				{
						
		%>
		  		<tr class="odd" onclick="location.href='leave?method=contactDetailsEncashment&leaveId=<%=encashmentDetails.getId()%>'">
		<%
		  		}
		  		else
		  		{
		%>
		  		<tr class="even" onclick="location.href='leave?method=contactDetailsEncashment&leaveId=<%=encashmentDetails.getId()%>'">		  		
		<%
		  		}
		%>
				<td align="center">Encashed Leave</td>
				<td align="center">Encashed Leave</td>
		
				<td align="center"><%=encashmentDetails.getLeaveToEncash()%></td>
				<td align="center"><%=encashmentDetails.getLeaveType().getLeaveType().getLeaveType().getDescription()%></td>
				<td align="left"><%=encashmentDetails.getReason()%></td>
				<td align="center"><%=encashmentDetails.getEmp().getFirstName() %> <%=encashmentDetails.getEmp().getLastName() %></td>
			</tr>
		<% i++;
		     }
	
			}
			else
			{
				out.println("<font size=\"2\"><h4>No leaves approved</h4></font>");
				%>
				<br />
				<%
			}
		%>
		</tbody>
	</table>
		
<script>
	var pager = new Pager('tableData',15); 
	pager.init(); 
	pager.showPageNav('pager', 'pageNavPosition'); 
	pager.showPage(1);
</script>
		
<div class="clear"></div>
		<input align="left" type="button" name="back" value="Back" class="button" onclick="javascript:history.back();"/><br /><br />
</div>		
</form>
