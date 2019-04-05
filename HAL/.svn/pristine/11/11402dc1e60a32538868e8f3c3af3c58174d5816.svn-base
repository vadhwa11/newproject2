<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasAgendaPointForWorkServices"%>
<%@page import="jkt.hms.masters.business.MomAgendaSummary"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<%

	Map map = new HashMap();
	if (request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
		int Id=0;
	if(map.get("Id")!=null){
		Id=(Integer)map.get("Id");
	}
	String AGENDADATE="";
	String MOMDATE="";
	String userName = "";
	String momNo = "";
	if (session.getAttribute("userName") != null) 
		{
			userName = (String) session.getAttribute("userName");
		}
	

	List<MasAgendaPointForWorkServices> momWorkDetailList = new ArrayList<MasAgendaPointForWorkServices>();
	if (map.get("momAgendaDetailList") != null) 
		{
			momWorkDetailList = (List) map.get("momAgendaDetailList");
		} 
	
	
	
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	if (map.get("departmentList") != null) 
		{
			departmentList = (List) map.get("departmentList");
		}
	
	List<MomAgendaSummary> momAgendaSummaryList = new ArrayList<MomAgendaSummary>();
	if(map.get("momAgendaSummaryList") != null)
	{
		momAgendaSummaryList  = (List)map.get("momAgendaSummaryList");
	}
	if(map.get("momNo") != null)
	{
		momNo  = (String)map.get("momNo");
	}
	if(momWorkDetailList.get(0)!=null)
	{
		if(momWorkDetailList.get(0).getAgendaDate()!=null){
	 AGENDADATE=HMSUtil.convertDateToStringWithoutTime(momWorkDetailList.get(0).getAgendaDate());
		}else{
			AGENDADATE="";
		}
		if(momWorkDetailList.get(0).getMomDate()!=null)
		{
	 MOMDATE=HMSUtil.convertDateToStringWithoutTime(momWorkDetailList.get(0).getMomDate());
		}
		else
		{
			MOMDATE="";
		}
	}
%>

<script type="text/javascript">
function IsValidTimeForSetup1(timeStr,fieldId) {
	// Checks if time is in HH:MM:SS format.
	// The seconds are optional.
	
	var obj = document.getElementById(fieldId)
	//alert(obj.value)
	var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;
	
	var matchArray = timeStr.match(timePat);
	if (obj.value!="" && matchArray == null) {
		alert("Time should be in HH:MM format.");
		obj.value = "";
		obj.focus();
		return false;
	}
	
	hour = matchArray[1];
	minute = matchArray[2];
	second = matchArray[4];
	ampm = matchArray[6];
	
	if (second=="") { second = null; }
	if (ampm=="") { ampm = null }
	
	if (hour < 0  || hour > 23) {
		alert("Hour must be between 0 and 23.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (minute<0 || minute > 59) {
		alert ("Minute must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (second != null && (second < 0 || second > 59)) {
		alert ("Second must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	return false;
}


function compareTime11()
{
var startedTime = document.getElementById("startedTime").value;
var endindingTime= document.getElementById("endingTime").value;

if(endindingTime <startedTime)
{
alert("Actual Ended Time should be less from Actual Started Time");
document.momDetailAgainstAgenda.<%= MOM__ACTUAL_STARTED_TIME%>.focus()
return false;
}
else
{
return true;
}
}
function checkTimeAgendaPoints(formName,timeFieldName){
   var currentTimeI;
   if(typeof timeFieldName.value=="undefined")
   {
   currentTimeI= "";
   }else
   {
   currentTimeI = timeFieldName.value;
   }   
   objTime = eval('document.'+formName+'.'+timeFieldName);
   var chtime=objTime.value;
         
   try{
       var indx = chtime.indexOf(':');
       
       if (indx != -1) {
       var pairs2 = chtime.substring(0,chtime.length).split(':');
       }
             
       if (pairs2.length!=2) { 
          alert("Invalid Time Format.It should be HH:MM")
          objTime.value=currentTimeI
         return false;
         }
       
       if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
              alert("Invalid Time Format.It should be HH:MM")
              objTime.value=currentTimeI
              return false;
            }
       
             val2=eval(pairs2[0]);
            
                    if (val2<0 || val2>23) {
                       alert("Hours should 00-23")
                       objTime.value=currentTimeI
                      return false;}
                      
                      val3=eval(pairs2[1]);
            
                       if (val3<0 || val3>59) {
                       alert("Min should 00-59")
                       objTime.value=currentTimeI
                      return false;}
                  
           
   }catch(e2)
   {  alert("Invalid Time")
   objTime.value=currentTimeI
      return false;
   }   
return true;
}
function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
}

function compareTimeAgendaPoints()
{


if(!document.getElementById('startingTime').value=="" && !document.getElementById('endingTime').value=="")
{
   if(document.getElementById('startingTime').value >= document.getElementById('endingTime').value)
   {
      alert("Starting time should be less than Ending time");
      return false;
   }
   else
   return true;       
}
 else
   return true
}

</script>



<% 
String message ="";
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<DIV class="Clear"></DIV>
<div id="contentHolder">
<h6>MOM Details Against Agenda</h6>
<div class="Clear"></div>

<form name="momDetailAgainstAgenda" action="" method="post">
<div class="blockTitle">MOM Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<label>Agenda No.</label> <%if(momWorkDetailList.get(0).getAgendaNo()!=null){ %>
<label class="value"><%=momWorkDetailList.get(0).getAgendaNo()%></label>
<%}%> <label>Agenda Date </label> <label class="value"><%=AGENDADATE%></label>

<label>Agenda Time</label> <%if(momWorkDetailList.get(0).getAgendaTime()!=null) {%>
<label class="value"><%=momWorkDetailList.get(0).getAgendaTime()%></label>
<%}else{ %> <% %> <%} %>


<div class="Clear"></div>


<label>Agenda Place</label> <%if(momWorkDetailList.get(0).getAgendaPlace()!=null){ %>
<label class="value"><%=momWorkDetailList.get(0).getAgendaPlace()%></label>
<%}else{ %> <% %> <%} %> <label>Department</label> <label class="value">
<%if(momWorkDetailList.get(0).getDepartmentName() != null){%>
<option value="<%=momWorkDetailList.get(0).getDepartmentName()%>"</option>
<%} %> <%
		for (MasAgendaPointForWorkServices masAgendaPointForWorkServices : momWorkDetailList) {
	%>

<option value=<%=masAgendaPointForWorkServices.getDepartmentName()%>>
<%=masAgendaPointForWorkServices.getDepartmentName()%></option>

<%
		}
	%>
</label> <label>MOM No.</label> <input value="<%=momNo%>" name="<%=MOM__NO%>"
	readonly="true" />


<div class="Clear"></div>



<label>MOM Date</label> <input value="<%=currentDate%>"
	name="<%=MOM__DATE %>" /> <label>Actual Started Time</label> <%if(momWorkDetailList.get(0).getActualStartedTime()!=null){ %>
<input id="startedTime"
	value="<%=momWorkDetailList.get(0).getActualStartedTime()%>"
	name="<%=MOM__ACTUAL_STARTED_TIME %>" maxlength="5"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="IsValidTimeForSetup1(this.value,this.id);"
	onchange="checkTimeAgendaPoints('momDetailAgainstAgenda','startedTime')" />
<%}else{ %> <input id="startedTime" value=""
	name="<%=MOM__ACTUAL_STARTED_TIME %>" maxlength="5"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="IsValidTimeForSetup1(this.value,this.id);"
	onchange="checkTimeAgendaPoints('momDetailAgainstAgenda','startedTime')" />
<%} %> <label>Actual Ended Time</label> <%if(momWorkDetailList.get(0).getActualEndedTime()!=null){ %>
<input id="endingTime" option
	value="<%=momWorkDetailList.get(0).getActualEndedTime()%>"
	name="<%=MOM__ACTUAL_ENDING_TIME %>" maxlength="5"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="IsValidTimeForSetup1(this.value,this.id);"
	onchange="compareTimeAgendaPoints();" /> <%}else{ %> <input
	id="endingTime" value="" name="<%=MOM__ACTUAL_ENDING_TIME %>"
	maxlength="5" onKeyUp="mask(this.value,this,'2',':');"
	onBlur="IsValidTimeForSetup1(this.value,this.id);"
	onchange="compareTimeAgendaPoints();" /> <%} %>


<div class="Clear"></div>


<label>Attendees</label> <%if(momWorkDetailList.get(0).getAttendees()!=null){ %>
<textarea class="large" onkeyup="chkLength(this,500);"
	name="<%= MOM__ATTENDEES %>"><%=momWorkDetailList.get(0).getAttendees()%></textarea>
<%}else{ %> <textarea class="large" onkeyup="chkLength(this,500);"
	name="<%= MOM__ATTENDEES %>"></textarea> <%} %>


<div class="Clear"></div>


<label>Absentees</label> <%if(momWorkDetailList.get(0).getAbsentees()!=null){ %>
<textarea class="large" onkeyup="chkLength(this,500);"
	name="<%= MOM__ABSENTEES %>"><%=momWorkDetailList.get(0).getAbsentees()%></textarea>
<%}else{ %> <textarea class="large" onkeyup="chkLength(this,500);"
	name="<%= MOM__ABSENTEES %>"></textarea> <%} %>


<div class="Clear"></div>


<label>Chaired By</label> <%if(momWorkDetailList.get(0).getChairedBy()!=null){ %>
<input maxlength="45"
	value="<%=momWorkDetailList.get(0).getChairedBy() %>"
	name="<%=MOM__CHAIRED_BY %>"> <%}else{ %> <input maxlength="45"
	value="" name="<%=MOM__CHAIRED_BY %>"> <%} %> <label>Mints
By</label> <%if(momWorkDetailList.get(0).getMintsBy()!=null){ %> <input
	maxlength="45" value="<%=momWorkDetailList.get(0).getMintsBy() %>"
	name="<%=MOM__MINTS_BY %>"> <%}else{ %> <input maxlength="45"
	value="" name="<%=MOM__MINTS_BY %>"> <%} %> <input type="hidden"
	name="Id" value="<%=Id %>">
<div class="Clear"></div>
<label>Agenda Summary</label> <%if(momWorkDetailList.get(0).getAgendaSummary()!=null){ %>
<textarea class="large" onkeyup="chkLength(this,400);"
	name="<%= AGENDA_SUMMARY %>"><%=momWorkDetailList.get(0).getAgendaSummary()%></textarea>
<%}else{ %> <textarea class="large" onkeyup="chkLength(this,400);"
	name="<%= AGENDA_SUMMARY %>"></textarea> <%} %>
</div>
<div class="division"></div>
<div class="blockTitle">Summary of Discussion</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><input type="button" name="add"
	value="Add" class="cmnButton"
	onclick="generateRow('agendaSummaryPoints');" />
<table width="100%" border="0" id="agendaSummaryPoints" cellspacing="0"
	cellpadding="0">
	<tr>
		<td><input type="text" maxlength="45"
			name="<%=SUMMARY_OF_DISCUSSION %>" size=8 value="" /></td>
	</tr>
</table>

</div>
<div class="division"></div>
<div class="bottom"><INPUT class=button id=save accessKey=s
	type=button name=Save
	onclick="submitForm('momDetailAgainstAgenda','momDetailAgainstAgenda?method=addMomDetailAgainstAgenda','compareTime11');"
	value="Save" /> <INPUT class=button id=reset accessKey=r
	onclick=resetCheck(); type=reset value=Reset name=Reset>

<div class="division"></div>
<!--Bottom labels starts--> <LABEL>Changed By</LABEL> <label
	class="value"><%=userName%></label> <LABEL>Changed Date</LABEL> <label
	class="value"><%=currentDate%></label> <LABEL>Changed Time</LABEL> <label
	class="value"><%=currentTime%></label> <INPUT type=hidden
	value="<%=userName%>" name="<%=CHANGED_BY%>"> <INPUT
	type=hidden value="<%=currentDate%>" name="<%=CHANGED_DATE %>">
<INPUT type=hidden value="<%=currentTime%>" name="<%=CHANGED_TIME %>">

</div>
</form>
</div>


