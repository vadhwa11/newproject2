<%@ page import="static jkt.hms.util.RequestConstants.*" %>	

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.HrLeaveDetails"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.LeaveManagementUtil"%>

<script>
<%
		Calendar calendar=Calendar.getInstance();
	
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
		
%>

serverdate = '<%=date+"/"+month+"/"+year%>';
</script>
<%
	Map<String,Object> map=(Map)request.getAttribute("map");
	if(map.get("detailsMap")!=null && ((Map)map.get("detailsMap")).size()>0 ){
	Map detailsMap=(Map)map.get("detailsMap");
	HrLeaveDetails leaveDetails = (HrLeaveDetails)detailsMap.get("leaveDetails");
	List userList= (List)detailsMap.get("userList");
	MasEmployee user = (MasEmployee)userList.get(0);
%>

<form name="<%=LEAVE_CONTACT_DETAILS%>" method="post">
	<div class="titleBg"><h2>Details  </h2></div>
	<div class="clear"></div>
	<div class="Block">

	<input type="hidden" name="<%=EMP_NAME %>" value="<%=leaveDetails.getEmpId().getId() %>">
	<input type="hidden" name="memberId" value="<%=leaveDetails.getEmpId().getId()%>">
	
	<label>Employee Code:</label>
	<label class="value"><%=leaveDetails.getEmpId().getEmployeeCode()  %></label>
	
	<label>Employee Name:</label>
	<label class="value"><%=leaveDetails.getEmpId().getFirstName()  %> <%=leaveDetails.getEmpId().getLastName()  %></label>
	
	<label>Contact Phone:</label>
	<label class="value"><%=leaveDetails.getContactPhone()  %></label>
	
	<div class="clear"></div>	

	<% if(leaveDetails.getContactAddress()!=null && !(leaveDetails.getContactAddress().equals(""))){%>
	<label>Contact Address:</label>
	<label class="value"><%=leaveDetails.getContactAddress()  %></label><%} %>

	<% if(leaveDetails.getAlternateEmailId()!=null && !(leaveDetails.getAlternateEmailId().equals(""))){%>
	<label>Alternate Email Id:</label>
	<label class="value"><%=leaveDetails.getAlternateEmailId() %></label><% }%>


	<label>Reason:</label>
	<label class="value"><%=leaveDetails.getReason() %></label>


	<% if(leaveDetails.getLeaveStatus().getId()== 2){ %>
	
	<label>Approved By:</label>
	<%}else if(leaveDetails.getLeaveStatus().getId()== 3){ %>
	<label>To be Approved By:</label>
	<%}else if(leaveDetails.getLeaveStatus().getId()== 4){ %>
	<label>Disapproved By:</label>
	<%} else{%>
	<label>Suggestion By:</label>
	<%} %>
	<label class="value"><%=user.getFirstName() %> <%=user.getLastName() %></label>

	<% if(leaveDetails.getApprovedOn()!=null && !(leaveDetails.getApprovedOn().equals(""))){%>
	<% if(leaveDetails.getLeaveStatus().getId()== 2){ %>
	<label>Approved On:</label>
	<%}else if(leaveDetails.getLeaveStatus().getId()== 4){ %>
		
	<label>Disapproved On:</label>
	<%} else{%>
	<label>Suggestion On:</label>
	<%} %>
			
	<label class="value"><%=LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getApprovedOn())%></label><%}%>

	<% if((leaveDetails.getLeaveStatus().getId()== 2 || leaveDetails.getLeaveStatus().getId()== 3) && leaveDetails.getJoiningDate()!=null && !(leaveDetails.getJoiningDate().equals(""))){ %>

<div class="clear"></div>	
	<label>Applied on:</label>
	<label class="value"><%=LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getAppliedOn()) %></label>
	
	<label>Leave From Date:</label>
	<label class="value"><%=LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getFromDate()) %></label>
	
	<label>Leave To Date:</label>
	<label class="value"><%=LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getToDate()) %></label>
	<div class="clear"></div>	
	<label>Joining Back On:</label>
	<label class="value"><%=LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getJoiningDate())%></label><%}%>
	
	<% if(leaveDetails.getLeaveStatus().getId()== 4){ %>

	<label>Disapproving Reason:</label>
	<label class="value"><%=leaveDetails.getDisapproveReason()%></label>
	<div class="clear"></div>	
	<%} %>

	<% if(leaveDetails.getLeaveStatus().getId()== 5){ %>
		<div class="clear"></div>
	<label>Deleting Reason:</label>
	<label class="value"><%=leaveDetails.getDeleteReason()%></label>
	<div class="clear"></div>	
	<%} %>
	
	
	<label>Remarks/Suggestion:</label>
	<label class="value"><%=(leaveDetails.getSuggestion())!=null?leaveDetails.getSuggestion():" - "%></label>
	
	<label>Dis Approved Remarks:</label>
	<label class="value"><%=(leaveDetails.getDisapproveReason())!=null?leaveDetails.getDisapproveReason():" - "%></label>
	
	
	

	

<%}
	else{
		   if( ((Map)map.get("detailsMap")).size()==0 ){%>
				<h4>Its Encashment Leave Thats Why No Contact Details</h4>
		   <%} else{%>
		   		<h4>No Contact Details</h4>
		   <%} %>
		
	<%} %>
	
   <div class="clear"></div> 
	
<input type="button" name="back" value="Back" class="button" onclick="history.back();"/><br /><br />
		<div class="clear"></div>	
</div>
</form>
