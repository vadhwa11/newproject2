<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="jkt.hms.masters.business.HrLeaveDetails"%>
<%@page import="jkt.hms.util.LeaveManagementUtil"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="java.util.Date"%>
<%@page import="java.util.StringTokenizer"%>
<script>


var urlForSubmit = '';
	
function setUrl(idvalue){

		if(idvalue == "hold" ){
	    	urlForSubmit = 'leave?method=sendSuggestion';
		}
		if(idvalue == "approve" ){
	    	urlForSubmit = 'leave?method=approveLeaves';
		}
		
		if(idvalue == "disapprove" ){
	    	urlForSubmit = 'leave?method=disapproveLeaves';
		}
		
		if(idvalue == "" ){
	    	urlForSubmit = "";
	    	//document.getElementById('leaveId').value = '';
	    	//document.getElementById('balanceId').value = '';
		}
}

function submitThisForm(){
	submitForm('<%=WAITING_LEAVES%>',urlForSubmit,'selectBeforeOperation');
}

function selectBeforeOperation(){
  flag = true;
  if(document.<%=WAITING_LEAVES%>.checkbox.checked != undefined)	
		{
			if(document.<%=WAITING_LEAVES%>.checkbox.checked)
			{
				flag = false;					
			}
		}
  else{
	for(i=0;i<document.<%=WAITING_LEAVES%>.checkbox.length;i++){
		if(document.<%=WAITING_LEAVES%>.checkbox[i].checked)
		  flag=false;
	}
 }
	if(flag){
		alert("Select a record to perform any operation.")
		document.<%=WAITING_LEAVES%>.approve.disabled=false;
		document.<%=WAITING_LEAVES%>.back.disabled=false;
		document.<%=WAITING_LEAVES%>.disapprove.disabled=false;
		document.<%=WAITING_LEAVES%>.sendSuggestion.disabled=false;
	    return false;
	}
	return true;
}

function unSelected(){
  flag = true;
  if(document.<%=WAITING_LEAVES%>.checkbox.checked != undefined)	
		{
			if(document.<%=WAITING_LEAVES%>.checkbox.checked)
			{
				flag = false;					
			}
		}
  else{
	for(i=0;i<document.<%=WAITING_LEAVES%>.checkbox.length;i++){
		if(document.<%=WAITING_LEAVES%>.checkbox[i].checked)
		  flag=false;
	}
 }
	if(flag){
		location.href='leave?method=showWaitingLeaves';
	}
	return true;
	}
	
function suggestionMandatory(){
    if(document.<%=WAITING_LEAVES%>.suggestion.value==""){
		alert("Suggestion text cannot be blank.");	
	 	return false;
	} 
	return true;
}

function remarksMandatory(){
    if(document.<%=WAITING_LEAVES%>.disapproveMessage.value==""){
		alert("Remarks text cannot be blank.");	
	 	return false;
	} 
	return true;
}

function disableOthers(val){
	document.<%=WAITING_LEAVES%>.approve.disabled=true;
	document.<%=WAITING_LEAVES%>.back.disabled=true;
	val.disabled=false;
	if(val=="sendSuggestion")
		document.<%=WAITING_LEAVES%>.disapprove.disabled=true;
	if(val=="disapprove")
		document.<%=WAITING_LEAVES%>.sendSuggestion.disabled=true;
}

function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}	
var state = 'none';
function openTextarea(layer_ref)
{
	
	if(selectBeforeOperation()){
	if (state == 'block') {
		state = 'none';
	}
	else {
		state = 'block';
	}
	if (document.all) { //IS IE 4 or 5 (or 6 beta)
		eval( "document.all." + layer_ref + ".style.display = state");
	}
	if (document.layers) { //IS NETSCAPE 4 or below
		document.layers[layer_ref].display = state;
	}
	if (document.getElementById && !document.all) {
		maxwell_smart = document.getElementById(layer_ref);
		maxwell_smart.style.display = state;
	}
	}
}
 function chkForPL(field,leaveStatus,joinDate,empFName,empLName)
    {
    if(field.checked)
    {
    if(leaveStatus==6)
    {
    	//alert(empFName+' '+empLName+' wants to cancel approved leave');
    }
    }
    	if(joinDate!=''){
		joinDate=new Date(joinDate.substring(0,4),(joinDate.substring(5,7)-1),joinDate.substring(8,10));
		dayOfToDate=joinDate.getDate();
		monthOfToDate=joinDate.getMonth();
		yearOfToDate=joinDate.getFullYear();
		var jdate=new Date(yearOfToDate, monthOfToDate, dayOfToDate)
		var one_day=1000*60*60*24;
		
    	today = new Date();
    	
    	var gap=Math.ceil((today.getTime()-jdate.getTime())/(one_day));
    	//if(gap<=183)
    	//{
    		//alert(empFName+' '+empLName+' has not completed 6 month after joining');
    	//}
    	}
    }
</script>


<form name="<%=WAITING_LEAVES%>" method="post" >
	<div class="titleBg"><h2>Approve Leave Cancel  </h2></div>
	<div class="clear"></div>
<%
	Map<String,Object> map=(Map)request.getAttribute("map");;	
	List approvedLeavesCancelList=(List)map.get("approvedLeavesCancelList");
	String msg="";
	if(map.get("msg") != null){
		msg = ""+map.get("msg");
	}
	%>
	
	<%if(!msg.equals("")){%>
<h4><%=msg %></h4>
	
<%}%>
	
	<%
	if(approvedLeavesCancelList.size()>0 && approvedLeavesCancelList!=null){	
%>

	<div class="Block">
	<div id="pageNavPosition"></div>
	<div class="clear"></div>
<table id="waitingLeavelist" >

		<tr>
			<th>Select</th>
			<th>From Date</th>
			<th>To Date</th>
			<th>Working Days</th>
			<th>Leave Type</th>
			<th>Employee Name</th>
			<th>Reason</th>
			<th>Current Balance</th>
		</tr>
	<tbody id="tableData">

		<%
				Iterator iterator = approvedLeavesCancelList.iterator();
				for (int i = 1; iterator.hasNext(); i++) {
					HrLeaveDetails waitingLeaves = (HrLeaveDetails) iterator.next();
					if (i % 2 == 0) {
						System.out.println(waitingLeaves.getId());
		%>
		<tr class="odd" >
			<%
			} else {
			%>
		
		<tr class="even" >
			<%
			}
			%>
			<td align="center"><input type="checkbox" name="checkbox" value="<%=waitingLeaves.getId() %>" class="radioCheck" onclick="chkForPL(this,'<%=waitingLeaves.getLeaveStatus().getId() %>','<%=waitingLeaves.getEmpId().getJoinDate()%>','<%=waitingLeaves.getEmpId().getFirstName() %>','<%=waitingLeaves.getEmpId().getLastName()%>')" ></td>
			<%if(waitingLeaves.getFromDate()!=null) {%>
		    		<td align="center" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=LeaveManagementUtil.convertDateToStringWithoutTime(waitingLeaves.getFromDate())%></td>
					<td align="center" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=LeaveManagementUtil.convertDateToStringWithoutTime(waitingLeaves.getToDate())%></td>
					<%}
					  else{
					%>
					<td align="center" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"></td>
					<td align="center" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"></td>
					<%} %>  
			<td align="center" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=waitingLeaves.getNoOfWorkingDays()%></td>
			<td align="left" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=waitingLeaves.getLeaveType().getLeaveType().getLeaveType().getDescription()%></td>
			<td align="center" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=waitingLeaves.getEmpId().getFirstName()%> <%=waitingLeaves.getEmpId().getLastName()%></td>
			<td align="center" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=waitingLeaves.getReason()%></td>
			<%  
				//double allowedDays =  Float.valueOf(waitingLeaves.getLeaveType().getLeaveType().getAllowedDays());
				//double taken = Float.valueOf(waitingLeaves.getEmpIdBal().getTaken());
				//double leaveAdjusted = Float.valueOf(waitingLeaves.getEmpIdBal().getBalanceAdjustedBy());
				
				//double balance = 0;
				//balance = allowedDays - taken + leaveAdjusted; 
				//String balanceToShow = new DecimalFormat("0.##").format((double)balance);
			%>
			<%
				if(waitingLeaves.getLeaveType().getLeaveType().getLeaveType().getId()!=8){
			%>		
			<td align="center" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=waitingLeaves.getEmpIdBal().getClosingBalanceYearly()%></td>
			
			<%}else {				%>
				<td align="center" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'">---------</td>
			<%} %>
			
		</tr>
		<%
		}
		%>
	</tbody>
</table>

<script>
	var pager = new Pager('tableData',5); 
	pager.init(); 
	pager.showPageNav('pager', 'pageNavPosition'); 
	pager.showPage(1);
</script>

	<div class="clear"></div>


<div class="division"></div>
<label>Remarks </label>
 	<textarea name="remarks" rows="6" maxlength="250" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" ></textarea><br>
<div class="clear"></div>	


<input type="button" name="Cancel" value="Cancel" class="button" onclick="if(check()){submitForm('<%=WAITING_LEAVES%>','leave?method=cancelLeaveAfterApprove');}"/>

<input type=reset value=Reset class="button" >

<%
		} else if( approvedLeavesCancelList.size() == 0 && msg.equals("")) { %>
			 <h4>No Approve leaves  for cancellation </h4>	 
			<div class="clear"></div>
		<%
	}
%>

<input type="button" name="back" value="Back" class="button"  onclick="submitFormForButton('waitingLeaves','leave?method=showLeaveStatus');"> 
<div class="clear"></div>
	<font face="bold" color="green" > <div id="message"> </div></font>	<br/>
<div class="clear"></div>	

</div>
<script type="text/javascript">
function check(){
	var canVal = confirm("Do you want to Cancel Leave.");
	   if( canVal == true ){
		  return true;
	   }else{
		  return false;
	   }
}

</script>
</form>
