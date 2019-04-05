<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="jkt.hms.masters.business.HrLeaveDetails"%>
<%@page import="jkt.hms.util.LeaveManagementUtil"%>

<%@page import="jkt.hms.masters.business.HrEncashmentDetails"%>
<form name="<%=DISAPPROVED_LEAVES%>" method="post">
	<div class="titleBg"><h2>Disapproved Leaves </h2></div>
	<div class="clear"></div>
	<div class="Block">

<%
	Map<String,Object> map=(Map)request.getAttribute("map");;	
	List disapprovedLeavesList=(List)map.get("disapprovedLeavesList");
	List<HrEncashmentDetails> disapprovedLeavesEncashment=(List)map.get("disapprovedLeavesEncashment");
	
	if((disapprovedLeavesList.size()>0 && disapprovedLeavesList!=null)||(disapprovedLeavesEncashment.size()>0 && disapprovedLeavesEncashment!=null)){
%>
	<div id="pageNavPosition"></div>
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
			
			Iterator iterator=disapprovedLeavesList.iterator();
			int i=1;
			for(;iterator.hasNext();i++)
			{
				HrLeaveDetails disapprovedLeaves=(HrLeaveDetails)iterator.next();
				if(i%2==0)
				{
						
		%>
		  		<tr class="odd" onclick="location.href='leave?method=contactDetails&leaveId=<%=disapprovedLeaves.getId()%>'">
		<%
		  		}
		  		else
		  		{
		%>
		  		<tr class="even" onclick="location.href='leave?method=contactDetails&leaveId=<%=disapprovedLeaves.getId()%>'">		  		
		<%
		  		}
		%>
		<%if(disapprovedLeaves.getFromDate()!=null) {%>
		    		<td align="center"><%=LeaveManagementUtil.convertDateToStringWithoutTime(disapprovedLeaves.getFromDate())%></td>
					<td align="center"><%=LeaveManagementUtil.convertDateToStringWithoutTime(disapprovedLeaves.getToDate())%></td>
					<%}
					  else{
					%>
					<td align="center"></td>
					<td align="center"></td>
					<%} %>
					
					<td align="center"><%=disapprovedLeaves.getNoOfWorkingDays()%></td>
					<td align="center"><%=disapprovedLeaves.getLeaveType().getLeaveType().getLeaveType().getDescription()%></td>
					<td align="left"><%=disapprovedLeaves.getReason()%></td>
					<td align="center"><%=disapprovedLeaves.getEmpId().getFirstName()%> <%=disapprovedLeaves.getEmpId().getLastName()%></td>
				</tr>
		<%	}
			
			for(HrEncashmentDetails encashmentDetails:disapprovedLeavesEncashment){
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
				<td align="center">---------</td>
				<td align="center">---------</td>
		
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
				%>
				<h4>No leaves disapproved</h4>
				
				<%
			}
		%>
		</tbody>
		</table>
				
<script>
	var pager = new Pager('tableData',2); 
	pager.init(); 
	pager.showPageNav('pager', 'pageNavPosition'); 
	pager.showPage(1);
</script>
			<div class="clear"></div>

<input align="left" type="button" name="back" value="Back" class="button" onclick="javascript:history.back();"/><br /><br />
	<div class="clear"></div>
</div>		
</form>
