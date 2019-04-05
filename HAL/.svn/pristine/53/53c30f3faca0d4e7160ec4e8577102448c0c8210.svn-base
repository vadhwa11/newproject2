<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.HrEmployeeBalanceNew"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


<%@page import="java.util.Date"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<h4 style="float:left;">Leave Balance Details</h4>
<% 
Map map=(Map)request.getAttribute("map");
List<HrEmployeeBalanceNew> leaveBalance=(List)map.get("leaveBalance");	
List<Integer> empDependents = new ArrayList<Integer>();

String sex ="";
String maritalStatusCode = "";
Users loggedUser =(Users)session.getAttribute(USERS);
/*
if(loggedUser.getEmployee().getPersonalDetails() != null){
	 sex = loggedUser.getEmployee().getPersonalDetails().getGender().getAdministrativeSexName();
	maritalStatusCode = loggedUser.getEmployee().getPersonalDetails().getMaritalStatus().getMaritalStatusCode(); 
}
*/
if(map.get("empDependents")!=null){
	empDependents = (List)map.get("empDependents");
}
Calendar calendar=Calendar.getInstance();
int currentYear = calendar.get(Calendar.YEAR);

int childrenCount = empDependents.get(0);
if(leaveBalance!=null && leaveBalance.size() > 0){
%>
<div style="float: right; width: 349px;">

	<label >Date of Joining </label>
	<label style="background:#dddddd;" class="value"><%=HMSUtil.convertDateToStringWithoutTime(loggedUser.getEmployee().getJoinDate())%></label>
</div>
<table id="leaveTypeList" >
 	 		<tr>
 		    	<th>Leave Type</th>
				<th>Annual Entitlement </th> 		    	
				<th>Carried Balance</th>				
				<th>Leaves Taken</th>
				<th>Balance</th>
				
			</tr>		
		<tbody id = "tableData2">
		<%	
			int i=1;
			for(HrEmployeeBalanceNew hrEmployeeBalanceNew : leaveBalance) { 
				
				
				if(hrEmployeeBalanceNew.getLeaveType().getLeaveType().getStatus().equalsIgnoreCase("y")
						&& !hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(8)
						&& !hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(20)){ 
					String allowedDays = hrEmployeeBalanceNew.getLeaveType().getLeaveType().getAllowedDays(); 
					MasEmployee employee = hrEmployeeBalanceNew.getEmp();
					if(employee.getJoinDate() != null){
						Date empJoiningDate = employee.getJoinDate();
						Calendar cal = Calendar.getInstance();
						cal.setTime(empJoiningDate);
						int yearOfJoining = cal.get(Calendar.YEAR);
						if(currentYear == yearOfJoining){ 
							double entitlementAccJoinDate = 0;
						%>
	    			<%if(maritalStatusCode.equalsIgnoreCase("M") 
	    					&& sex.equalsIgnoreCase("male") && hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(4)){ 
					   if(i%2==0) { %>
			  			<tr class="odd">
					<%} else { %>
			  			<tr class="even">		  		
					<%}%>
						<td><%=hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getDescription() %></td>
						<td><%=allowedDays%></td>						
						<%-- <td><%=allowedDays%></td> --%>
						<td><%=hrEmployeeBalanceNew.getOpeningBalanceYearly()%></td>								
	    			<%	if(childrenCount >= 2 ){%>
							<td>This leave is not applicable for more than 2 children. </td>
							<td>0</td>

							<td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td>
	    				<%}else if(hrEmployeeBalanceNew.getAlreadyAvailedPatMat().equals("y")){%>
							<td>You have already availed this leave.</td>
							<td>0</td>
							<%-- <td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td>  --%>
	    				<%}else{ 
				    		double totalTaken = Float.valueOf(allowedDays) - Float.valueOf(hrEmployeeBalanceNew.getClosingBalance());
	    				%>
							<td><%=new DecimalFormat("0.##").format(totalTaken)%></td>
							<td><%=hrEmployeeBalanceNew.getClosingBalance()%></td>
							<%--<td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td>  --%>
	    				<%} %>
	    			<%i++; } else if(maritalStatusCode.equalsIgnoreCase("M") 
	    						&& sex.equalsIgnoreCase("female") &&  hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(3)){
						   if(i%2==0) { %>
				  			<tr class="odd">
						<%} else { %>
				  			<tr class="even">		  		
						<%}%>
							<td><%=hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getDescription() %></td>
							<td><%=allowedDays%></td>
							<%-- <td><%=allowedDays%></td> --%>
							<td><%=hrEmployeeBalanceNew.getOpeningBalanceYearly()%></td>									
							<%
	    				if(childrenCount >= 2 ){%>
							<td>This leave is not applicable for more than 2 children. </td>
							<td>0</td>
							<%--<td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td>  --%>
	    				<%}else if(hrEmployeeBalanceNew.getAlreadyAvailedPatMat().equals("y")){%>
							<td>You have already availed this leave.</td>
							<td>0</td>
							<%--<td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td>--%>
	    				<%}else{ 
				    		double totalTaken = Float.valueOf(allowedDays) - Float.valueOf(hrEmployeeBalanceNew.getClosingBalance());
	    				%>
							<td><%=new DecimalFormat("0.##").format(totalTaken)%></td>
							<td><%=hrEmployeeBalanceNew.getClosingBalance()%></td>
							<%-- <td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td> --%>
	    				<%} %>
	    			<%i++; } else { 
	    				if(!hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(4) && hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getStatus().equalsIgnoreCase("y")
	    					&&  !hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(3) &&  !hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(23) &&  !hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(10)
	    					&&  !hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(22)){ 
					   if(i%2==0) { %>
			  			<tr class="odd">
					<%} else { %>
			  			<tr class="even">		  		
					<%}%>
						<td><%=hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getDescription() %></td>
						<%
							int monthOfJoining = cal.get(Calendar.MONTH)+1;
							int day = cal.get(Calendar.DATE);
							double leaveDayInJoiningMonth = 0.0;
							double allowedDaysFloat =Float.valueOf(allowedDays)/12.0;
							entitlementAccJoinDate = (12-monthOfJoining)*(Float.valueOf(new DecimalFormat("0.##").format(allowedDaysFloat)));
							if(day <= 15){
								leaveDayInJoiningMonth = Float.valueOf(allowedDays)/12.0;
							}else{
								leaveDayInJoiningMonth = 0.0;
							}
							entitlementAccJoinDate = entitlementAccJoinDate + leaveDayInJoiningMonth;
							//double accruedMonthly = Float.valueOf(allowedDays)/12.0;
							//String accruedToString = new DecimalFormat("0.##").format(accruedMonthly);
				    	    //double accrued =  Float.valueOf(accruedToString)*(currentMonth- monthOfJoining)+leaveDayInJoiningMonth;
				    	    
				    		//double totalTaken = accrued - Float.valueOf(hrEmployeeBalanceNew.getClosingBalance());
				    		//String accruedToShow = new DecimalFormat("0.##").format(accrued);
				    	    //String totalTakenToShow = hrEmployeeBalanceNew.getTotalLeaveTaken();
				    	    String entitlementAccJoinDateToShow = new DecimalFormat("0.##").format(entitlementAccJoinDate);
				    	    %>
							<td><%=allowedDays%></td>							
							<%-- <td><%=entitlementAccJoinDateToShow%></td>	 --%>	
							<td><%=hrEmployeeBalanceNew.getOpeningBalanceYearly()%></td>
							<td><%=hrEmployeeBalanceNew.getTotalLeaveTaken()%></td>
							<td><%=hrEmployeeBalanceNew.getClosingBalance()%></td>
						<%-- <td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td> --%>
	    				<%i++; }%>
					<%} %> 
					</tr>							
				<%} else { %>
	    			<%if(maritalStatusCode.equalsIgnoreCase("M") 
	    					&& sex.equalsIgnoreCase("male") && hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(4)){ 
					   if(i%2==0) { %>
			  			<tr class="odd">
					<%} else { %>
			  			<tr class="even">		  		
					<%}%>
						<td><%=hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getDescription() %></td>
						<td><%=allowedDays%></td>
					<%--	<td><%=allowedDays%></td> --%>
						<td><%=hrEmployeeBalanceNew.getOpeningBalanceYearly()%></td>								
	    			<%	if(childrenCount >= 2 ){%>
							<td>This leave is not applicable for more than 2 children. </td>
							<td>0</td>
							<%--<td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td>--%>
	    				<%}else if(hrEmployeeBalanceNew.getAlreadyAvailedPatMat().equals("y")){%>
							<td>You have already availed this leave.</td>
							<td>0</td>
							<%--<td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td>--%>
	    				<%}else{ 
				    		double totalTaken = Float.valueOf(allowedDays) - Float.valueOf(hrEmployeeBalanceNew.getClosingBalance());
	    				%>
							<td><%=new DecimalFormat("0.##").format(totalTaken)%></td>
							<td><%=hrEmployeeBalanceNew.getClosingBalance()%></td>
							<%-- <td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td> --%>
	    				<%} %>
	    			<%i++; } else if(maritalStatusCode.equalsIgnoreCase("M") 
	    					&& sex.equalsIgnoreCase("female") &&  hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(3)){
						   if(i%2==0) { %>
				  			<tr class="odd">
						<%} else { %>
				  			<tr class="even">		  		
						<%}%>
							<td><%=hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getDescription() %></td>
							<td><%=allowedDays%></td>
							<%-- <td><%=allowedDays%></td>		 --%>
							<td><%=hrEmployeeBalanceNew.getOpeningBalanceYearly()%></td>							
							<%
	    				if(childrenCount >= 2 ){%>
							<td>This leave is not applicable for more than 2 children. </td>
							<td>0</td>
							 <%--<td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td> --%>
	    				<%}else if(hrEmployeeBalanceNew.getAlreadyAvailedPatMat().equals("y")){%>
							<td>You have already availed this leave.</td>
							<td>0</td>
							 <%-- <td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td> --%>
	    				<%}else{ 
				    		double totalTaken = Float.valueOf(allowedDays) - Float.valueOf(hrEmployeeBalanceNew.getClosingBalance());
	    				%>
							<td><%=new DecimalFormat("0.##").format(totalTaken)%></td>
							<td><%=hrEmployeeBalanceNew.getClosingBalance()%></td>
							<%-- <td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()--%></td> --%>
	    				<%} %>
	    			<%i++; } else { 
	    				if(!hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(4) && hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getStatus().equalsIgnoreCase("y")
	    					&&  !hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(3) &&  !hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(23)
	    					&&  !hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(22) &&  !hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId().equals(10)){ 
					   if(i%2==0) { %>
			  			<tr class="odd">
					<%} else { %>
			  			<tr class="even">		  		
					<%}%>
						<td><%=hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getDescription() %></td>
						<td><%=allowedDays%></td>
						<%--<td><%=allowedDays%></td> --%>
						<!-- Changes done from here Rahul -->
						<td><%=hrEmployeeBalanceNew.getOpeningBalanceYearly()%></td>
						<%
							//int month1 = calendar.get(Calendar.MONTH)+1;
				    	    //double accrued =  (Float.valueOf(allowedDays)/12.0)*month1;
				    	    //double accruedMonthly = Float.valueOf(allowedDays)/12.0;
				    	    //String accruedToString = new DecimalFormat("0.##").format(accruedMonthly);
				    	    //double accrued = Float.valueOf(accruedToString)*month1;
				    		//double totalTaken = accrued - Float.valueOf(hrEmployeeBalanceNew.getClosingBalance());
				    	    //String accruedToShow = new DecimalFormat("0.##").format(accrued);
				    	    //String totalTakenToShow = hrEmployeeBalanceNew.getTotalLeaveTaken();%>
							<td><%=hrEmployeeBalanceNew.getTotalLeaveTaken()%></td>
							<td><%=hrEmployeeBalanceNew.getClosingBalance()%></td>
							<%--<td><%=hrEmployeeBalanceNew.getBalanceAdjustedBy()%></td> --%>
							<!-- Changes done till here Rahul -->
	    				<%i++; }%>
					<%} %> 
					</tr>
						<%}
					}
					%>
		<%   }	
		   }
		}%>
		  </tbody>
		</table>
		<div class="clear"></div>
		<br>
