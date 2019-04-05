
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.Users"%>

<%@page import="jkt.hms.masters.business.AvAircrewLectureDt"%>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
			
	</script>
<%
String userName="";
if(session.getAttribute("userName")!=null)
 userName=(String)session.getAttribute("userName");
	Users users =null;
	if(session.getAttribute("users")!=null){
		users=(Users)session.getAttribute("users");
	}
	int loginEmpId=0;
	if(users!=null){
		if(users.getEmployee()!=null){
			loginEmpId=users.getEmployee().getId();
		}
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<MasAircraftType> aircraftList = new ArrayList<MasAircraftType>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	
	if(map.get("unitList") != null){
		unitList =(List<MasUnit>)map.get("unitList");
	}
	if(map.get("rankList") != null)	{
		rankList = (List<MasRank>)map.get("rankList");
	}
	if(map.get("aircraftList") != null)	{
		aircraftList = (List<MasAircraftType>)map.get("aircraftList");
	}
	if(map.get("sexList") != null)	{
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	}
%>
<form name="trainingAirCrew" method="post" action=""><br />
<div class="titleBg">
<h2>Aeronautical Status of Aircrew</h2>
</div>

<div class="clear"></div>
<div class="Block">
<label>Service No.</label>
<input type="text" class="auto" size="17" name="<%=SERVICE_NO %>" 
onblur="submitProtoAjaxWithDivName('trainingAirCrew','/hms/hms/aviationMedicine?method=getSerNoDetailForTraining&serviceNo='+this.value,'patientDiv');" validate="Service No.,metachar,no" />
<input 	id="prefix" name="<%=PREFIX%>" type="text" maxlength="3" class="auto" size="3"	tabindex="1" validate="Prefix,metachar,no" />
</div><div class="clear"></div>
<div id="patientDiv">
<div class="Block">

<input type="hidden" value="0" name="hinId">
<input type="hidden" value="" name="avAccidentId">
<label>Rank</label>
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="Rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	}%>
</select>

<label>Name</label>
<input type="text" name="fullName" />

<label>Age</label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age,string,no"	tabindex="1" class="smallest">
	<option value="">Select</option>
	<%	for(int age1 = 16;age1<=100;age1++){%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 
<input type="text" class="auto" size="4"  id="ageUnit" name="<%=SR_AGE_UNIT %>" value="Years" readonly="readonly"/>
</div>
<%--<input class="transparent" size="8" />
<input type="text" readonly="readonly" value="Years" name="srAgeUnit" id="srAgeUnitId" class="readOnlySmall">--%> 

<input type="text" class="transparent" disabled="disabled" size="6" /> 
<label>Gender</label>
<select name="<%=SEX_ID %>" id="sexId" validate="Gender,metachar,no" tabindex="1">
<option value="0">Select</option>
	<%
		 for(MasAdministrativeSex masAdministrativeSex : sexList){	%>
	<option value="<%=masAdministrativeSex.getId()%>" ><%=masAdministrativeSex.getAdministrativeSexName()%></option>
	<%	 	} %>
</select> 

<label>Unit</label>
<select name="<%=UNIT_ID %>"  id="<%=UNIT_ID %>">
<option value="0">Select</option>
	<%for(MasUnit masUnit : unitList){	%>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		
		}%>
</select></div>
<div class="clear paddingTop15"></div>
<h4>Flying Experience</h4>
<div class="clear"></div>
<div class="Block">

<label>Total Flying Experience</label>
<input type="text" name=flyingExp class="" size="" />
<%--<label class="unit">Hrs.</label> --%>

<label>Aircraft Flown</label>
<input type="text" name="aircraftFlown" />

<label>Current on Type</label>
<input type="text" name="currentType" />

<div class="clear"></div>

<label>Experience on Type</label>
<input type="text" name="expType" />

<label>Current Rating</label>
<input type="text" name="currentRating" />
</div>

<div class="clear paddingTop15"></div>

<h4>Courses</h4>
<div class="Block">

<label>Basic Indoctrination</label>
<input type="checkbox" name="basicIntro" class="" />

<label>Ejection Trainer</label>
<input type="checkbox" name="ejectionTrainer" class="" />

<label>DISO</label>
<input type="checkbox" name="diso" class="" />

<div class="clear"></div>

<label>OPTRAM</label>
<input type="checkbox" name="optram" class="" />

<label>NVG</label>
<input type="checkbox" name="nvg" class="" />

</div>

<%---
<div style="display: none" id="localLecturId">
<div class="Block">
<label>Date</label>
<input type="text" name="localLecDate" value="<%=currentDate %>" MAXLENGTH="20" class="date"	id="toAppDate" validate="Appointment Date,string,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.trainingAirCrew.localLecDate,event)" />

<label>Content</label>
<textarea name="content"></textarea>
</div> 
</div>--%>
<div class="clear paddingTop15"></div>
<h4>Local Lecture</h4>
<div class="Block">
<label>Date</label>
<input type="text" name="localLectureDate" id="localLectureDate" readonly="readonly"/>
<label>Content/ Topic</label>
<input type="text" id="topic" name="content" readonly="readonly" />
</div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="button" class="button" name="Submit11" value="SUBMIT" 
onclick="submitForm('trainingAirCrew','/hms/hms/aviationMedicine?method=submitTrainingStatusAirCrew&flag=trainStatus');" />
<input tabindex="1" name=Reset type=reset value=Reset class=button id=reset accessKey=r onclick=resetCheck(); />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<script>
function checkLocalLecture(){
	if(document.getElementById('localLecture').checked == true){
		document.getElementById('localLecturId').style.display = "inline";
		}
	else{
		document.getElementById('localLecturId').style.display = "none";
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
</script>