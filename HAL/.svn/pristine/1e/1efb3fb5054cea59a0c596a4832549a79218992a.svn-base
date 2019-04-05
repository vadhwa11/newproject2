
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MovementInOtherPerson"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<form name="movementInEntry" method="post" action=""><script
	type="text/javascript">

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
 var name= objTime.name;
   var chtime=objTime.value;
 if(chtime=="" && name!='toTime'){
 alert('Time can not be blank')
 objTime.value="";
 objTime.focus();
  return false
 }
  if(name=='fromTime' || (name=='toTime' && objTime.value!="")){
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
</script> <%
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
List<MasEmployee> employeeList=null;
List<MovementInOtherPerson> personList =null;
int Id=0;
String employeecode=null;
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
if(map.get("employeeList")!=null)
{
	employeeList=(List<MasEmployee>)map.get("employeeList");
}
if(map.get("personList")!=null)
{
	personList=(List<MovementInOtherPerson>)map.get("personList");
}
if(map.get("Id")!=null)
{
	Id=(Integer)map.get("Id");
}
if(map.get("employeecode")!=null)
{
	employeecode=(String)map.get("employeecode");
}
String message="";
List<MasUnit> unitList = new ArrayList<MasUnit>();
if(map.get("unitList") != null){
	unitList = (List<MasUnit>)map.get("unitList");
	}

%>


<div class="Clear"></div>
<div id="contentHolder">
<%if(map.get("message") != null){
 	message = (String)map.get("message");
 	System.out.println("messgae"+message);
%>
<h2><%=message %></h2>

<%} %>
<div class="Clear"></div>
<h6>Movement In Entry</h6>
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span>Movement Type</label>
<select name="<%=MOVEMENT_TYPE %>" validate="Movement Type,string,yes"
	tabindex="1">
	<option value="">Select</option>
	<option value="Back From TD">Back From TD</option>
	<option value="TD From Other Unit">TD From Other Unit</option>
	<option value="Back From Leave">Back From Leave</option>
</select> <label><span>*</span>From Unit</label> <select id="<%=FROM_UNIT%>"
	name="<%=FROM_UNIT%>" disabled="disabled" tabindex="1"
	validate="From Unit,string,yes">
	<option value="0">Select</option>
	<%if(employeeList!=null){
				System.out.println(":::employeeList::jsp"+employeeList.size());
				MasEmployee masemployee = employeeList.get(0);	
				for(MasUnit masUnit : unitList){
				if(masemployee.getUnit().getId().equals(masUnit.getId())){
			%>
	<option value="<%=masUnit.getId() %>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName()%></option>
	<%}}}else if(personList!=null){ 
				MovementInOtherPerson masemployee = personList.get(0);	
				for(MasUnit masUnit : unitList){
				if(masemployee.getPresentUnit().getId().equals(masUnit.getId())){
			%>
	<option value="<%=masUnit.getId() %>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName()%></option>
	<%}}} %>
</select> <%if(employeeList!=null){%> <input type="hidden" id="fromUnitId"
	name="fromUnitId" value="<%=employeeList.get(0).getUnit().getId() %>" />
<%}else if(personList!=null){ %> <input type="hidden" id="fromUnitId"
	name="fromUnitId"
	value="<%=personList.get(0).getPresentUnit().getId() %>" /> <%} %>
<div class="clear"></div>

<label> <span>*</span>From Date</label> <input type="text"
	class="calDate" id="fromDate" name="<%=FROM_DATE %>" value="<%=date %>"
	readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a from date"
	onClick="setdate('<%=date %>',document.movementInEntry.<%=FROM_DATE%>,event)" />

<label class="bodytextB_blue"><span>*</span> Time: </label> <input
	type="text" id="time1" name="<%=FROM_TIME %>" value=""
	onblur="checkTime('movementInEntry','time1');" class="textbox_size20"
	tabindex=1 validate="From Time,string,yes" />

<div class="clear"></div>

<label>To Date</label> <input type="text" class="calDate" id="date"
	name="<%=TO_DATE %>" value="" readonly="readonly" MAXLENGTH="30"
	tabindex="1" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0"
	onClick="setdate('<%=date %>',document.movementInEntry.<%=TO_DATE%>,event)" />

<label class="bodytextB_blue">Time:</label> <input id="time" type="text"
	name="<%= TO_TIME %>" value=""
	onblur="checkTime('movementInEntry','time');" class="textbox_size20"
	tabindex=1>

<div class="clear"></div>


<label class="bodytextB_blue">Remarks:</label> <input id="maxLimit"
	type="text" name="<%=REMARKS %>" value="" class="textbox_size20"
	MAXLENGTH="50" tabindex=1></div>

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
	type="hidden" name="id" value="<%=Id %>"> <input type="hidden"
	name="employeecode" value="<%=employeecode%>">

<div id="edited"></div>
<label>&nbsp;</label>
<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Submit" class="button"
	onClick="submitForm('movementInEntry','hrOrderly?method=addMovementInEntry');"
	accesskey="a" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="button" onclick="resetCheck();"
	accesskey="r" /> <input type="button" name="back" id="back"
	value="Close" class="button" onclick="javascript:history.back()"
	accesskey="b" tabindex=1 /> <input type="hidden" name="<%=STATUS %>"
	value="" /> <input type="hidden" name="<%= COMMON_ID%>" value="" /></div>
</div>
</form>


