<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="jkt.hms.masters.business.HrLeaveDetails"%>
<%@page import="jkt.hms.util.LeaveManagementUtil"%>
<%@page import="jkt.hms.masters.business.HrEncashmentDetails"%>
<%@page import="java.text.DecimalFormat"%>
<script>


var urlForSubmit = '';
	
function setUrl(idvalue){

		if(idvalue == "hold" ){
	    	urlForSubmit = 'leave?method=onHoldEncashment';
		}
		if(idvalue == "approve" ){
	    	urlForSubmit = 'leave?method=approveLeavesEncashment';
		}
		
		if(idvalue == "disapprove" ){
	    	urlForSubmit = 'leave?method=disapproveLeavesEncashment';
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
</script>

<form name="<%=WAITING_LEAVES%>" method="post" >
	<div class="titleBg"><h2>Leaves Waiting for Encashment Approval  </h2></div>
	<div class="clear"></div>
<%
	Map<String,Object> map=(Map)request.getAttribute("map");;	
	List<HrEncashmentDetails> waitingLeaveList=(List)map.get("waitingLeavesList");
	//System.out.print(waitingLeaveList.size()+"hhhhhhh");
	if(waitingLeaveList.size()>0 && waitingLeaveList!=null){
%>
	<div class="Block">
	<div id="pageNavPosition"></div>
	<div class="clear"></div>
<table id="waitingLeavelist" >

		<tr>
			<th >Select</th>
			<th>Days To Encash</th>
			<th>Type</th>
			<th>Emp Name</th>
			<th>Current Balance</th>
		</tr>
	<tbody id="tableData">

		<%
				Iterator iterator = waitingLeaveList.iterator();
				for (int i = 1; iterator.hasNext(); i++) {
					HrEncashmentDetails waitingLeaves = (HrEncashmentDetails) iterator.next();
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
			<td align="center"><input type="checkbox" name="checkbox" value="<%=waitingLeaves.getId() %>" class="small_check" ></td>

			<td align="center" onclick="<%-- location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%> --%>'"><%=waitingLeaves.getLeaveToEncash()%></td>
			<td align="left" onclick="<%-- location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%> --%>'"><%=waitingLeaves.getLeaveType().getLeaveType().getLeaveType().getDescription()%></td>
			<td align="center" onclick="<%-- location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%> --%>'"><%=waitingLeaves.getEmp().getFirstName()%> <%=waitingLeaves.getEmp().getLastName() %></td>
			<%
	    		//double allowedDays = Float.valueOf(waitingLeaves.getLeaveType().getLeaveType().getAllowedDays());
    			//double leaveTaken = Float.valueOf(waitingLeaves.getEmpIdBal().getTaken());
    			//double leaveAdjusted = Float.valueOf(waitingLeaves.getEmpIdBal().getBalanceAdjustedBy());
    			//double balance = 0;
    			//balance = allowedDays - leaveTaken + leaveAdjusted;
    			//String leaveBalance1 = new DecimalFormat("0.##").format((double)balance);
			%>
			<td align="center" onclick="<%-- location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%> --%>'"><%=waitingLeaves.getEmpIdBal().getClosingBalance()%></td>
		</tr>
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

<label> Leave Status <span>*</span></label> 
<select id="leaveAppStatus" name="<%=TYPE%>"  class="mediumm" readonly validate="Leave Status,string,yes" onkeyup="setUrl(this.value);" onchange="setUrl(this.value);">
		
		<option value="">Select</option>
		<!-- <option value="hold">On Hold</option> -->
		<option value="approve">Approve</option>
		<option value="disapprove">Disapprove</option>

</select>
	    

<div class="clear"></div>

<label>Remarks </label>
 	<textarea name="remarks" rows="6" maxlength="250" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" ></textarea><br>
<div class="clear"></div>	


<input name="send" type="button" value="Send" class="button" onclick="submitThisForm();">

<input name="reset" type="button" value="Reset" class="button"	onclick="location.href='leave?method=showLeaveStatus'">
<%
		} else {%>
			
			<h4>No leaves waiting for Encashment approval</h4>
			<div class="clear"></div>
		<%
	}
%> 

<input type="button" name="back" value="Back" class="button" onclick="submitFormForButton('waitingLeaves','leave?method=showLeaveStatus');">  

<div class="clear"></div>
	<font face="bold" color="blue" > <div id="message"> </div></font>	<br/>
<div class="clear"></div>	

</div>
</form>
