<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>

<%@ page import="jkt.hms.masters.business.MasDepartment"%>

<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>
<%@page import="jkt.hms.masters.business.MasAgendaPointForWorkServices"%>

<SCRIPT>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(Calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
		
			
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	
<%	String 	userName="";
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(session.getAttribute("userName")!=null){
		userName=(String)session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	//String Session=(String) utilMap.get("session");
	String time = (String) utilMap.get("currentTime");	
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
	if(map.get("departmentList")!=null)
	{
		departmentList = (List) map.get("departmentList");
	}
	
List<MasAgendaPointForWorkServices> agendaList = new ArrayList<MasAgendaPointForWorkServices>();
	
	if(map.get("agendaList")!=null)
	{
		agendaList = (List) map.get("agendaList");
	}
	String message ="";
	%>
	</SCRIPT>


<script type="text/javascript">
function checkTimeAgendaPoints(formName,timeFieldName){

   var currentTimeI = "3";
   if(typeof timeFieldName.value=="undefined")
   {
   currentTimeI="";
   timeFieldName.value = currentTimeI;
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
   {  alert("please enter correct time");
      objTime.value=currentTimeI
      return false;
   }   
return true;
}
function compareTimeAgendaPoints()
{
if(!document.getElementById('startingTime').value=="" && !document.getElementById('endingTime').value=="")
{
   if(document.getElementById('startingTime').value > document.getElementById('endingTime').value)
   {
      alert("Starting time should be less than Ending time");
      return false;
   }
   return true;
       
}
}

function jsImport()
{
   
   var fname = updateAgendaPoints.<%=UPLOAD_FILENAME%>.value;
   var st = fname.length;

   st = st-3;
	
   if(fname!="")
   {
   if (fname.substring(st)!="doc")
   {
   alert('Only doc files are Allowed.');
   document.getElementById("filename").focus();
   return false;
   }
   else
   {
   return true;
   }
}else
{
return true;
}
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

function tValue() 
{ 

var t1=document.getElementById("txt_start").value;
var t2=document.getElementById("txt_end").value ;
if(t1>t2) 
{
alert("Start time must be less than End time"); 
return false;
}
}


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

</script>

<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<DIV class="Clear"></DIV>
<DIV id=contentHolder>
<DIV class="floatLeft"></DIV>
<DIV class="Clear"></DIV>


<FORM name="updateAgendaPoints" action="" method=post
	enctype="multipart/form-data">
<h6>Priority For Agenda Points</h6>
<div class="Clear"></div>
<Label class="common"><span>*</span>Agenda No.</Label> <Label
	class="value"><%=agendaList.get(0).getAgendaNo()%></Label>
<div class="division"></div>

<DIV class="blockTitle">Agenda Details</DIV>
<DIV class="blockTitleCurve"></DIV>
<div class="Clear"></div>
<DIV class="blockFrame">
<DIV class=Clear></DIV>

<Label><span>*</span> Agenda Date</Label> <input tabindex="1"
	type="text" class="calDate" name="<%=AGENDA_DATE%>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(agendaList.get(0).getAgendaDate()) %>"
	MAXLENGTH="12" validate="Agenda Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date%>',document.updateAgendaPoints.<%= AGENDA_DATE%>,event);"
	class="calender" /> <Label><span>*</span> Agenda Time</Label> <input
	tabindex="1" type="text" maxlength="5" name="<%=AGENDA_TIME %>"
	value="<%=agendaList.get(0).getAgendaTime() %>"
	validate="Agenda Time,string,yes"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="checkTimeAgendaPoints('updateAgendaPoints','agendaTime');">
<INPUT type=hidden value="<%=userName%>" name="<%=CHANGED_BY%>">

<Label><span>*</span> Agenda Type</Label> <input tabindex="1"
	type="text" maxlength="30" name="<%=AGENDA_TYPE %>"
	validate="Agenda Type,string,yes"
	value="<%=agendaList.get(0).getAgendaType() %>">


<div class="Clear"></div>


<label><span>*</span> Agenda Place</Label> <textarea tabindex="1"
	class="large" name="<%=AGENDA_PLACE %>" onkeyup="chkLength(this,30);"
	validate="Agenda Place,string,yes"><%=agendaList.get(0).getAgendaPlace() %></textarea>

<label>Department</label> <select name="<%= DEPARTMENT_ID %>" tabindex=1>
	<option value="<%=agendaList.get(0).getDepartmentName()%>"><%=agendaList.get(0).getDepartmentName()%></option>
	<% 
				for (MasDepartment  masDepartment : departmentList){
			  %>

	<option value="<%=masDepartment.getDepartmentName()%>"><%=masDepartment.getDepartmentName()%></option>

	<%}%>
</select>

<div class="Clear"></div>

<Label>Starting Time</Label> <input tabindex="1" type="text"
	id="startingTime" onKeyUp="mask(this.value,this,'2',':');"
	onBlur="IsValidTimeForSetup1(this.value,this.id);" maxlength="5"
	name="<%=STARTING_TIME %>"
	value="<%=agendaList.get(0).getStartingTime() %>"> <Label>Ending
Time</Label> <input tabindex="1" type="text" id="endingTime" maxlength="5"
	name="<%=ENDING_TIME %>" onKeyUp="mask(this.value,this,'2',':');"
	onBlur="IsValidTimeForSetup1(this.value,this.id);"
	onchange="compareTimeAgendaPoints();"
	value="<%=agendaList.get(0).getEndingTime() %>">

<DIV class="Clear"></DIV>

<label>Agenda Summary</Label> <textarea tabindex="1" class="large"
	onkeyup="chkLength(this,400);" name="<%=AGENDA_SUMMARY %>"><%=agendaList.get(0).getAgendaSummary() %></textarea>

<DIV class="Clear"></DIV>
<label class="large">Location of Prev Uploaded File </Label> <Label
	class="valueNoWidth"><%=agendaList.get(0).getResoursePath()%></Label>

<DIV class="Clear"></DIV>
<Label class="large">Agenda Summary Upload (Max Up to 2 MB Only)</Label>
<input tabindex="1" type="file" name="<%=UPLOAD_FILENAME %>"
	title="<%=agendaList.get(0).getResoursePath() %>" class="browse">
<DIV class="Clear"></DIV>

</div>
<div class="division"></div>
<div class="bottom"><INPUT class=button id="addbutton" accessKey=a
	onClick="submitForm('updateAgendaPoints','updateAgendaPoints?method=editUpdateAgendaPointsForWorkServices','jsImport','A');"
	tabIndex=1 type=button value="Update" name=save> <input
	tabindex="1" type="reset" name="Reset" class="button" id=reset
	accessKey=r onclick=resetCheck(); value=Reset> <input
	type="button" name="back" id="back" value="Back" class="button"
	onclick="javascript:history.back()" accesskey="b" tabindex=1 />
<div class="division"></div>
<INPUT type=hidden name="<%=STATUS %>"> <INPUT type=hidden
	name="<%= COMMON_ID%>"> <LABEL>Changed By</LABEL> <label
	class="value"><%=userName%></label> <LABEL>Changed Date</LABEL> <label
	class="value"><%=date%></label> <LABEL>Changed Time</LABEL> <label
	class="value"><%=time%></label> <INPUT type=hidden
	value="<%=userName%>" name="<%=CHANGED_BY%>"> <INPUT
	type=hidden value="<%=date%>" name="<%=CHANGED_DATE %>"> <INPUT
	type=hidden value="<%=time%>" name="<%=CHANGED_TIME %>"> <input
	type="hidden" name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" /></div>
</form>
</DIV>



