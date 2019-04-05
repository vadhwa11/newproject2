<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PendingHroProposal" %>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<SCRIPT language=javascript src="/hms/jsp/js/common.js" type=text/javascript></SCRIPT>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<SCRIPT language=javascript src="/hms/jsp/js/hms.js" type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/calendar.js" type=text/javascript></SCRIPT>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>
<script type="text/javascript">
// Use it to attach the editor to all textareas with full featured setup
//WYSIWYG.attach('all', full);

// Use it to attach the editor directly to a defined textarea

WYSIWYG.attach('myTextarea', full); // full featured setup

// Use it to display an iframes instead of a textareas
//WYSIWYG.display('all', full);  
</script>

<script type="text/javascript">
function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}

</script>
<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
			
	%>
		serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>
	
	
<%	String 	userName="";
	String 	departmentName="";
	String entryNo = "";
	String serialNo="";
	String TEXT_CONTENT1="";
	List<PendingHroProposal> pendingHroProposalList=new ArrayList<PendingHroProposal>();
	Map<String,Object> map = new HashMap<String,Object>();
	List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	if(session.getAttribute("userName")!=null){
		userName=(String)session.getAttribute("userName");
	}
	if(session.getAttribute("departmentName")!=null){
		departmentName=(String)session.getAttribute("departmentName");
	}
	Map<String, Object> diagMap = new HashMap<String, Object>();
	if(map.get("diagMap")!=null){
		diagMap=(Map)map.get("diagMap");
	}
	if(map.get("entryNo") != null){
		entryNo = (String)map.get("entryNo");
		}
	if(map.get("serialNo")!=null){
		serialNo=(String) map.get("serialNo");
	}
	if(map.get("masEmployeeList")!=null && ((List<MasEmployee>)map.get("masEmployeeList")).size()!=0)
	{
		masEmployeeList=(List<MasEmployee>)map.get("masEmployeeList");
	}
	if(diagMap.get("pendingHroProposalList")!=null)
	{
		pendingHroProposalList=(List<PendingHroProposal>)diagMap.get("pendingHroProposalList");
		
	}
	int i =0;
	for(PendingHroProposal pendingHroProposal :pendingHroProposalList){
		i++;
		TEXT_CONTENT1=TEXT_CONTENT1+"<H3><U>"+pendingHroProposal.getProposalHroEntryId().getSubject().toUpperCase()
		+"</U></H3><BR /> ("+i+").";
		TEXT_CONTENT1=TEXT_CONTENT1+pendingHroProposal.getProposalHroEntryId().getTextContent();
		TEXT_CONTENT1=TEXT_CONTENT1+"<BR />";
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	//String Session=(String) utilMap.get("session");
	String time = (String) utilMap.get("currentTime");	
	%>
<script type="text/javascript">  

function checkHroDate(){
	
	var date1 = document.getElementById("inputDate").value;
	
	var inputDate=new Date(date1.substring(6),(date1.substring(3,5) - 1) ,date1.substring(0,2));
	var currentDate=new Date();
	if((inputDate > currentDate))
	{
		
		return true;
	}
	else
	{
	alert(" Date should be greater than current date!!");
	document.getElementsId("inputDate").focus();
	return false;
	}
	
}


</script>

<div id=contentHolder>
<% if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  } %>
<h6>HRO Details</h6> 
<DIV class="floatLeft"></DIV>

<form name="hroEntry"  method="post" action="">
<DIV class=Clear></DIV>
<div class="blockTitle">HRO Details</div>
<DIV class="blockTitleCurve"></DIV><br />
<DIV class="blockFrame">
<DIV class=Clear></DIV>
<Label style="padding-left:10px;">Entry No<font id="error">*</font></Label>
<label class="value" ><%=entryNo %></label>
<input type="hidden" name="entryNo" value="<%=entryNo %>" /> 

<Label style="padding-left:5px;">Serial No<font id="error">*</font></Label>
<input type="text" maxlength="25" name=<%=SERIAL_NO %> validate="Serial No,string,yes" value="<%=serialNo %>" readonly="readonly"/>
<Label class="bodytextB1">Date<font id="error">*</font></Label>
<input type="text" id="inputDate"  name="<%=ENTRY_DATE%>" value="<%=date %>"  readonly="readonly"  MAXLENGTH="30" validate="Pick a date,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"onClick="setdate('<%=date %>',document.hroEntry.<%=ENTRY_DATE%>,event)" />
<div class="clear"></div>

<label style="padding-left:1px;width:140px">Name Of Commandant <font id="error">*</font></label>
<select name="commandantName" id="commandantName" validate="Commandant Name,string,yes"/>
<option value="">Select</option>
<%if(masEmployeeList!=null && masEmployeeList.size()>0){
	String name="";
	for(MasEmployee masEmployee :masEmployeeList){
		name="";
		if(!masEmployee.getFirstName().equals(""))
		{
			name=name +masEmployee.getFirstName()+" ";
		}
		if(!masEmployee.getMiddleName().equals(""))
		{
			name=name +masEmployee.getMiddleName()+" ";
		}
		if(!masEmployee.getLastName().equals(""))
		{
			name=name +masEmployee.getLastName()+" ";
		}
		%>
		<option value="<%=masEmployee.getId() %>"><%=name %></option>
<%}}%>

</select>
<label>Designation<font id="error">*</font></label>
<input  type="text" name="designation" id="designation" value="COMMANDANT" validate="Designation,string,yes"/>

<div class="clear"></div>

<label style="padding-left:10px;">Name Of Adjudant<font id="error">*</font></label>
<select name="adjudantName" id="adjudantName" validate="Adjudant Name,string,yes"/>
<option value="">Select</option>
<%if(masEmployeeList!=null && masEmployeeList.size()>0){
	String name="";
	for(MasEmployee masEmployee :masEmployeeList){
		name="";
		if(!masEmployee.getFirstName().equals(""))
		{
			name=name +masEmployee.getFirstName()+" ";
		}
		if(!masEmployee.getMiddleName().equals(""))
		{
			name=name +masEmployee.getMiddleName()+" ";
		}
		if(!masEmployee.getLastName().equals(""))
		{
			name=name +masEmployee.getLastName()+" ";
		}
		%>
		<option value="<%=masEmployee.getId() %>"><%=name %></option>
<%}}%>

</select>
<input class="cmnButton" type="button" style="display:none"  value="Import All Proposal" onclick="submitProtoAjaxWithDivName('hroEntry','hrOrderly?method=getPendingProposalList','testDiv')" />
</DIV>
 <div id="testDiv">

 </div>
<div id="ListPendingProposal">
<div class="clear"></div>
<DIV class="blockTitle">HRO Entry</DIV>
<DIV class="blockTitleCurve"></DIV><br>
<DIV class="blockFrame">
<DIV class=Clear></DIV>


<script type="text/javascript">
function printVal(){
  WYSIWYG.updateTextArea("myTextarea");
return true;
}
</script>

<textarea id="myTextarea" name="<%=TEXT_CONTENT%>"  class="tableTextareaEditor"  >
<%=TEXT_CONTENT1 %>
</textarea>


 
 </div>
 </div>
<DIV class="Clear"></DIV>
<div class="bottom">
<input class="button"  type="button" onClick="if(printVal()){submitForm('hroEntry','/hms/hms/hrOrderly?method=addHroEntry', checkHroDate());}"  value="Submit" /> 
<!-- <INPUT class=button id=back accessKey=b type=button value=Print name=print onClick="submitForm('hroEntry','/hms/hms/hrOrderly?method=printHroEntry');" />

<INPUT class=button id=reset accessKey=r type=button value=Search name=search onClick="window.open('hrOrderly?method=showHroSearchJsp')" />--> 
<INPUT class=button id=back accessKey=b type=button value=Close name=close onClick="javascript:history.back();"/> 

</div>

<DIV class="Clear"></DIV>
<LABEL class=bodytextB>Last Changed By:</LABEL> 
<DIV class="changebydt"><%=userName%></DIV>
<LABEL class=bodytextB>Last Changed Date:</LABEL> 
<DIV class="changebydt"><%=date%></DIV>
<LABEL class=bodytextB>Last Changed Time:</LABEL> 
<DIV class=changebydt><%=time%></DIV>
<INPUT type=hidden value="<%=userName%>" name="<%=CHANGED_BY%>" />
<INPUT type=hidden value="<%=date%>" name="<%=CHANGED_DATE %>">
<INPUT type=hidden value="<%=time%>" name="<%=CHANGED_TIME %>" /> 
<DIV class=Clear></DIV>
<DIV class=Clear></DIV>
				
			<div id="edited"></div>
			<label>&nbsp;</label>
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			
	  
 <DIV id=edited></DIV>
<LABEL>&nbsp;</LABEL>
</form> 
</div>	

	
	