<%@ page import="static jkt.hms.util.RequestConstants.*" %>


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
    	alert(empFName+' '+empLName+' wants to cancel approved leave');
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
    	if(gap<=183)
    	{
    		//alert(empFName+' '+empLName+' has not completed 6 month after joining');
    	}
    	}
    }
</script>
<form name="<%=WAITING_LEAVES%>" id="waitingLeaves" method="post" >
	<div class="titleBg"><h2>Leaves Waiting for Approval  </h2></div>
	<div class="clear"></div>
<%
	Map<String,Object> map=(Map)request.getAttribute("map");

String msg="";
if(map.get("msg") != null){
	msg = ""+map.get("msg");
}%>
<%if(!msg.equals("")){%>
<h4><%=msg %></h4>
	
<%}%>
<%
	List waitingLeaveList=(List)map.get("waitingLeavesList");
	if(waitingLeaveList.size()>0 && waitingLeaveList!=null ){
	%>





	<div class="Block">
	<div id="pageNavPosition"></div>
	<div class="clear"></div>
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
				Iterator iterator = waitingLeaveList.iterator();
				for (int i = 1; iterator.hasNext(); i++) {
					HrLeaveDetails waitingLeaves = (HrLeaveDetails) iterator.next();
					if (i % 2 == 0) {
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
					 <td align="left"  onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=waitingLeaves.getLeaveType().getId()%></td>
					
					<td align="center" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=waitingLeaves.getEmpId().getFirstName()%> <%=waitingLeaves.getEmpId().getLastName()%></td>
					<td align="center" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=waitingLeaves.getReason()%></td>
					
			<%
			
				if((waitingLeaves.getLeaveType().getLeaveType().getLeaveType().getId()!=0) && (waitingLeaves.getLeaveType().getLeaveType().getLeaveType().getId()!=null)){
			%>		
			
			<td align="center" onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=waitingLeaves.getEmpIdBal()!=null?waitingLeaves.getEmpIdBal().getClosingBalance():0%></td>
			
			<%}else {%>
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

<label><span>*</span> Leave Status</label> 
<select id="leaveAppStatus" name="<%=TYPE%>"  readonly validate="Leave Status,string,yes" onkeyup="setUrl(this.value);" onchange="setUrl(this.value);">
		
		<option value="">Select</option>
		<!-- <option value="hold">On Hold</option> -->
		<option value="approve">Approve</option>
		<option value="disapprove">Disapprove</option>

</select>
	    

<div class="clear"></div>
<div class="division"></div>
<label>Remarks </label>
 	<textarea name="remarks" rows="6" maxlength="200" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" ></textarea><br>
<div class="clear"></div>	


<input name="send" type="button" value="Send" class="button" onclick="submitThisForm();">

<input name="reset" type="button" value="Reset" class="button"	onclick="submitFormForButton('waitingLeaves','leave?method=showLeaveStatus');">

<%
		} else if(waitingLeaveList.size() == 0 && msg.equals("")) { %>
			 <h4>No leaves waiting for approval</h4>	 
				<div class="clear"></div>
		<%
	}
%>

 <input type="button" name="back" value="Back"  onclick="submitFormForButton('waitingLeaves','leave?method=showLeaveStatus');" />
 
																
 <div class="clear"></div>
	<font face="bold" color="blue" > 
	<div id="message"></div>
	</font>	<br/>
<div class="clear"></div>	
</div>
</form>



