<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%@page import="jkt.hms.masters.business.AccomRegistration"%>
<script>
function chkLength(field,maxLimit)
{
	if(field.value.length > maxLimit)
	{
	 alert('you crossed the maximum limit of '+maxLimit+' characters');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}

function resetValueForRelegation(){
for(var i=1;i<5;i++)
{
document.getElementById('relegationType'+i).value= "";
document.getElementById('relegationCompleted'+i).checked = false;
document.getElementById('remarks'+i).value = "";
}
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
</script>
<script>
function checkSubmit(){
var inc=0;
for(var i = 0; i < document.getElementsByName('<%=RELEAGTION_COMPLETED%>').length; i++){
var msg="";

	if(document.getElementsByName('<%=RELEAGTION_COMPLETED%>')[i].checked == false){
	  	msg =" Please check Relegation Complete before submitting records ";
	  	}else{
	  		break;
	  	}
} 	
	
 if(msg !=""){
	 alert(msg)
	 return false;
 }else{
	 return true;
	}
}
</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
}
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String userName="";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
int deptId =0;
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}
int hospitalId =0;
if(session.getAttribute("hospitalId") != null){
	hospitalId = (Integer)session.getAttribute("hospitalId");
}

List<AccomRegistration> relegationDetailList = new ArrayList<AccomRegistration>();
AccomRegistration accomRegistration = new AccomRegistration();
try{
	if(map.get("relegationDetailList") != null){
		relegationDetailList=(List<AccomRegistration>)map.get("relegationDetailList");
	}
}catch(Exception e){
	e.printStackTrace();
}
System.out.println("relegationDetailList in jsp : "+relegationDetailList.size());
int vacationId=0;
 if(relegationDetailList != null){
	 accomRegistration = (AccomRegistration)relegationDetailList.get(0);
 }
 vacationId = accomRegistration.getId();
 String relegationNo="";
 if(map.get("relegationNo")!= null){
	 relegationNo= (String)map.get("relegationNo");
 }
 %>
<% 
 String message ="";
 if (map.get("message") != null) {
 	message = (String) map.get("message");
  }
 if(!message.equalsIgnoreCase("")){
 %>
<h2><%=message %></h2>
<%} %>


<div id="contentHolder">
<h6>Relegation For Officers</h6>
<form name="relegationProcess" method="post" action="">
<div class="Clear"></div>
<div class="blockTitle">Marriage Accomodation Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label>Registration No.</label> <%if(accomRegistration.getRegistrationNo()!= null){ %>
<label class="value"><%=accomRegistration.getRegistrationNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Registration
Date</label> <%if(accomRegistration.getRegistrationDate()!= null){ %> <label
	class="value"><%=HMSUtil.convertDateToStringWithoutTime(accomRegistration.getRegistrationDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Registration
Time</label> <%if(accomRegistration.getRegistrationTime()!= null){ %> <label
	class="value"><%=accomRegistration.getRegistrationTime()%></label> <%}else{ %>
<label class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Service No.</label> <%if(accomRegistration.getServiceNo()!= null){ %>
<label class="value"><%=accomRegistration.getServiceNo()%></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Service Person Name</label> <%if(accomRegistration.getServicePersonName()!= null){ %>
<label class="value"><%=accomRegistration.getServicePersonName()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Service
Type</label> <%if(accomRegistration.getServiceType()!= null){ %> <label
	class="value"><%=accomRegistration.getServiceType().getServiceTypeName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Rank</label> <%if(accomRegistration.getRank() != null){ %> <label
	class="value"><%=accomRegistration.getRank().getRankName()%></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Trade</label> <%if(accomRegistration.getTrade() != null){ %>
<label class="value"><%=accomRegistration.getTrade().getTradeName()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Suffix</label> <%if(accomRegistration.getSfx()!= null){ %>
<label class="value"><%=accomRegistration.getSfx()%></label> <%}else{ %> <label
	class="value">-</label> <%} %>

<div class="Clear"></div>


</div>

<div class="blockTitle">Relegation Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<label>Relegation No.</label> <label class="valueNoWidth"><%=relegationNo %></label>

<label>Relegation Date</label> <label class="valueNoWidth"><%=date%></label>

<label>Relegation Time</label> <label class="valueNoWidth"><%=time%></label>


<label>Pool Code</label> <%if(accomRegistration.getPool()!= null){ %> <label
	class="value"><%=accomRegistration.getPool().getPoolName()%></label> <%}else{ %>
<label class="value">-</label> <%} %>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="height10"></div>

<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sr.No</th>
		<th scope="col">Relegation Type</th>
		<th scope="col">Relegation From</th>
		<th scope="col">Relegation To</th>
		<th scope="col">Relegation Completed</th>
		<th scope="col">Remarks</th>
	</tr>
	<%
   int inc =0;
  		 for(inc=1;inc<=4;inc++){
   %>
	<tr>

		<td><label id="<%=SR_NO %><%=inc%>" name="<%=SR_NO%>"><%=inc%></label>
		<input type="hidden" name="<%=SR_NO %>" id="<%=SR_NO %><%=inc %>"
			value="<%=inc %>"> <input type="hidden"
			name="<%=CHANGED_BY%>" id="<%=CHANGED_BY %><%=inc %>"
			value="<%=userName%>" /> <input type="hidden"
			name="<%=CHANGED_DATE %>" id="<%=CHANGED_DATE %><%=inc %>"
			value="<%=date%>" /> <input type="hidden" name="<%=CHANGED_TIME %>"
			id="<%=CHANGED_TIME %><%=inc %>" value="<%=time%>" /> <input
			type="hidden" name="<%=RELEAGTION_NO %>"
			id="<%=RELEAGTION_NO %><%=inc %>" value="<%=relegationNo%>" /> <input
			type="hidden" name="<%=RELEAGTION_DATE %>"
			id="<%=RELEAGTION_DATE %><%=inc %>" value="<%=date%>" /> <input
			type="hidden" name="<%=RELEAGTION_TIME %>"
			id="<%=RELEAGTION_TIME %><%=inc %>" value="<%=time%>" /> <input
			type="hidden" name="<%=DEPARTMENT_ID %>"
			id="<%=DEPARTMENT_ID %><%=inc %>" value="<%=deptId%>" /> <input
			type="hidden" name="<%=HOSPITAL_ID %>"
			id="<%=HOSPITAL_ID %><%=inc %>" value="<%=hospitalId%>" /></td>

		<td><select name="<%= RELEAGTION_TYPE%>"
			id="<%=RELEAGTION_TYPE %><%=inc %>">
			<option value="">Select</option>
			<%
  	for(int i=1; i<=4; i++){
	%>
			<option value="<%=i%>"><%=i%></option>
			<%} %>

		</select></td>

		<td><input type="text" class="calDate" size="8"
			id="<%=RELEAGTION_FROM %><%=inc%>" name="<%=RELEAGTION_FROM %>"
			value="<%=date %>" readonly="readonly" MAXLENGTH="30" tabindex="1" />
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			id="relegationFrom<%=inc %>" validate="Pick a date"
			onClick="setdate('<%=date %>',document.relegationProcess.<%=RELEAGTION_FROM%><%=inc%>,event)" />
		</td>

		<td><input type="text" class="calDate" size="8"
			id="<%=RELEAGTION_TO %><%=inc%>" name="<%=RELEAGTION_TO %>"
			value="<%=date %>" readonly="readonly" MAXLENGTH="30" tabindex="1" />
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			id="relegationTo<%=inc %>" validate="Pick a date"
			onClick="setdate('<%=date %>',document.relegationProcess.<%=RELEAGTION_TO%><%=inc%>,event)" />
		</td>

		<td><input type="checkbox" class="radio"
			name="<%=RELEAGTION_COMPLETED%>"
			id="<%=RELEAGTION_COMPLETED%><%=inc %>" value="a" /></td>

		<td><textarea value="" name="<%=REMARKS %>"
			id="<%=REMARKS %><%=inc%>" maxlength="50"
			onkeyup="chkLength(this,50);" validate="Remarks,string,no"
			tabindex="1"></textarea></td>
		<%} %>
	</tr>
</table>
</div>

<div class="Height10"></div>
<div class="division"></div>
<!-- Table Ends --> <!--Bottom labels starts-->
<div class="bottom"><input type="button" class="button"
	value="Submit"
	onclick="if(checkSubmit()){submitForm('relegationProcess','accom?method=submitRelegationDetails');}"
	align="right" tabindex="1" /> <input name="Button" type="button"
	class="button" value="Reset" onclick="resetValueForRelegation();"
	tabindex="1" /> <input name="Button" type="button" class="button"
	value="Back"
	onclick="submitFormForButton('relegationProcess','accom?method=showRelegationProcess')"
	tabindex="1" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>


<div class="Clear"></div>


</div>
</form>
</div>