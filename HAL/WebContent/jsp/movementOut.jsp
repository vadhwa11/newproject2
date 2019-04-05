
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<div id="contentHolder">
<form name="movementOutEntry" method="post" action=""><script
	type="text/javascript">


function jsClose()
	{
		    alert(" js close ");	
		 
	  window.opener.location.href = "hrOrderly?method=searchRecordsForMovementOut";
	    	alert(" js end close ");
	  if (window.opener.progressWindow)
		 {
	    	window.opener.progressWindow.close()
	  	 } 
	    
	  window.close();
	 
	}
function submitMovementOutApplication(formName){
    obj = eval('document.'+formName)
    var url;
	  url = "/hms/hms/hrOrderly?method=searchMovementOut&appId=A589";
    obj.action = url;
    obj.submit();
	
}

<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
 %>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script> <SCRIPT LANGUAGE="JavaScript">

function checkTime(formName,timeFieldName){
  
 objTime = eval('document.'+formName+'.'+timeFieldName);
 name=objTime.name;
   var chtime=objTime.value;
 if(chtime=="" && name!="toTime" ){
 alert('Time can not be blank')
 objTime.value="";
 objTime.focus();
  return false
 }
  if(name=="fromTime" ||(name=="toTime" && chtime!="")){
 try{
   var indx = chtime.indexOf(':');
   
   if (indx != -1) {
   var pairs2 = chtime.substring(0,chtime.length).split(':');
   }
      
   if (pairs2.length!=2) { 
    alert("Invalid Time Format.It should be HH:MM")
    objTime.value=""
   return false;
   }
   
   if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
      alert("Invalid Time Format.It should be HH:MM")
      objTime.value=""
      return false;
    }
   
      val2=eval(pairs2[0]);
     
        if (val2<0 || val2>23) {
         alert("Hours should 00-23")
         objTime.value=""
         return false;}
         
         val3=eval(pairs2[1]);
     
         if (val3<0 || val3>59) {
         alert("Min should 00-59")
         objTime.value=""
         return false;}
       
     
 }catch(e2)
 { alert("Invalid Time")
 objTime.value=""
  return false;
 }
 }
 
return true;
}
function openPopupWindowForUnit()
	{
	 var url="/hms/hms/adt?method=showUnitSearchJsp";
	 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	}
	function jsSetUnitData(unitId,unitAddress)
	{
	 for(var i=0;i<document.getElementById("<%=UNIT_TO%>").length;i++)
	 {
		 if (document.getElementById("<%=UNIT_TO%>").options[i].value==unitId)
		 {
		 	document.getElementById("<%=UNIT_TO%>").selectedIndex = i;
		 }
	 }
	
	}	
</script> <%
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String userName = "";
if(session.getAttribute("userName") != null)
{
	userName = (String)session.getAttribute("userName");
}
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
	}

int id = 0;
String employeecode="";
if(map.get("Id") != null)
{
	id = (Integer)map.get("Id");
}
if(map.get("employeecode") != null)
{
	employeecode = (String)map.get("employeecode");
}
List<MasUnit> unitList = new ArrayList<MasUnit>();
if(map.get("unitList") != null){
	unitList = (List<MasUnit>)map.get("unitList");
	}

String message="";
%>

<div class="Clear"></div>
<%if(map.get("message") != null){
 	message = (String)map.get("message");
%>

<h2><%=message %></h2>

<%} %>
<div class="Clear"></div>
<h6>Movement Out Entry</h6>
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span>Movement Type</label>
<select name="<%=MOVEMENT_TYPE %>" validate="Movement Type,string,yes"
	tabindex="1">
	<option value="">Select</option>
	<option value="TD(Hosp Staff)">TD To Other
	Unit(Hosp Staff)</option>
	<option value="Back To PU">Back To Parent Unit</option>
	<option value="AWL">Absent Without Leave</option>
</select> <label><span>*</span>To Unit:</label> <select id="<%=UNIT_TO %>"
	name="<%=UNIT_TO%>" tabindex="1" validate="Unit to,string,yes">
	<option value="0">Select</option>
	<%
			for(MasUnit masUnit : unitList){
			%>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName()%></option>
	<%}%>
</select> <img class="newUnitId" SRC="/hms/jsp/images/s_search.gif" WIDTH="26"
	HEIGHT="26" style="cursor: pointer;"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Posted From">

<div class="clear"></div>

<label><span>*</span>From Date</label> <input type="text"
	class="calDate" id="fromDate" name="<%=FROM_DATE %>" value="<%=date %>"
	readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a from date"
	onClick="setdate('<%=date %>',document.movementOutEntry.<%=FROM_DATE%>,event)" />

<label><span>*</span> Time: </label> <input type="text"
	name="<%=FROM_TIME %>" id="time"
	onblur="checkTime('movementOutEntry','time');" value="" MAXLENGTH="8"
	tabindex=1 validate="From Time,string,yes" />

<div class="clear"></div>

<label>To Date</label> <input type="text" class="calDate" id="date"
	name="<%=TO_DATE %>" value="" readonly="readonly" MAXLENGTH="30"
	tabindex="1" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0"
	onClick="setdate('<%=date %>',document.movementOutEntry.<%=TO_DATE%>,event)" />

<label>Time:</label> <input type="text" name="<%= TO_TIME %>" value=""
	id="time1" onblur="checkTime('movementOutEntry','time1');"
	MAXLENGTH="17" tabindex=1>

<div class="clear"></div>


<label>Remarks:</label> <input id="remarks" type="text"
	name="<%=REMARKS %>" value="" maxlength="50" tabindex=1></div>
<div class="clear"></div>

<label class="bodytextB">Last Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Last Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Last Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="id" value="<%=id %>"> <input type="hidden"
	name="employeecode" value="<%=employeecode %>">

<div id="edited"></div>
<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Submit" class="button"
	onClick="submitForm('movementOutEntry','hrOrderly?method=addMovementOutEntry');"
	accesskey="a" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="button" onclick="resetCheck();"
	accesskey="r" tabindex=1 /> <input type="button" name="back" id="back"
	value="Close" class="button" onclick="javascript:history.back();"
	accesskey="b" tabindex=1 /> <input type="hidden" name="<%=STATUS %>"
	value="" /> <input type="hidden" name="<%= COMMON_ID%>" value="" /></div>
</form>
</div>

