
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.AvFlyingIncident"%>
<%@page import="jkt.hms.masters.business.Patient"%>
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
Map<String, Object> utilMap = new HashMap<String, Object>();
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
		Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<MasAircraftType> aircraftList = new ArrayList<MasAircraftType>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<AvFlyingIncident> flyingIncidentList = new ArrayList<AvFlyingIncident>();
	List<MasAircraftType> airCraftList = new ArrayList<MasAircraftType>();
	if(map.get("unitList") != null){
		unitList =(List<MasUnit>)map.get("unitList");
	}
	if(map.get("rankList") != null)	{
		rankList = (List<MasRank>)map.get("rankList");
	}
	if(map.get("sexList") != null)	{
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	}
	if(map.get("flyingIncidentList") != null)	{
		flyingIncidentList = (List<AvFlyingIncident>)map.get("flyingIncidentList");
	}
	if(map.get("patientList") != null)	{
		patientList = (List<Patient>)map.get("patientList");
	}
	if(map.get("airCraftList") != null)	{
		airCraftList = (List<MasAircraftType>)map.get("airCraftList");
	}
%>

<%    if(false){ 
	for(AvFlyingIncident flyingIncident : flyingIncidentList){ %>
	<%if(flyingIncident.getHin() !=null){  %>
<input type="hidden" value="<%=flyingIncident.getHin().getId() %>" name="hinId"><%}else{ %>
<input type="hidden" value="" name="hinId">
<%} %>
<%if(flyingIncident.getId() !=null){ %>
<input type="hidden" name="avAccidentId" value="<%=flyingIncident.getId() %>"><%}else{ %>
<input type="hidden" value="" name="avAccidentId"><%} %>

<input class="transparent" size="8" />

<label>Date</label>
<%if(flyingIncident.getFlyingDate() !=null){ %>
<input type="text" name="<%=DATE %>" value="<%=HMSUtil.changeDateToddMMyyyy(flyingIncident.getFlyingDate()) %>" MAXLENGTH="20" class="date" id="toAppDate" validate="Date,date,yes" tabindex="1"/>
<%}else{ %>
<input type="text" name="<%=DATE %>" value="<%=currentDate %>" MAXLENGTH="11" class="date" id="toAppDate" validate="Date,date,yes" tabindex="1"/>
<%} %>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.incidentAccident.<%=DATE %>,event)" tabindex="1"/>

<label>Time</label>
<%if(flyingIncident.getFlyingTime() !=null){ %>
<input type="text"  name="<%=TIME %>" value="<%=flyingIncident.getFlyingTime()%>"onKeyUp="mask(this.value,this,'2',':');" maxlength="5" tabindex="1"
 onBlur="checkTime('incidentAccident','<%=TIME%>');" />
<%}else{ %>
<input type="text" name="<%=TIME %>" value="<%=time%>"  tabindex="1"
onKeyUp="mask(this.value,this,'2',':');" maxlength="5"
 onBlur="checkTime('incidentAccident','<%=TIME%>');" /><%} %>

<div class="clear"></div>
<Label>Rank</Label>
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	
	<%for(MasRank masRank : rankList){
	if(flyingIncident.getRank().getId().equals(masRank.getId())){ %>	
	<option value="<%=flyingIncident.getRank().getId()%>" selected="selected"><%=flyingIncident.getRank().getRankName()%></option>
	<%}else{ %>	
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}
			}
				%>
</select>

<label>Name</label>
<%if(flyingIncident.getFlyingName() !=null){ %>
<input type="text" maxlength="30"  name="fullName" value="<%=flyingIncident.getFlyingName()%>"tabindex="1"/><%}else{ %>
<input type="text" maxlength="30"  name="fullName" tabindex="1"/><%} %>

<label>Age</label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age,string,no" tabindex="1" class="small"tabindex="1">
	<% 
String ageYears="";
String age="";
if(flyingIncident.getAge()!=null){
	ageYears=flyingIncident.getAge();
	age = ageYears.substring(0,2);
}
	for(int age1 = 16;age1<=100;age1++){
%>
<option value="<%=age1%>"><%= age1%></option>
<%}%>
</select> 
<script>
document.getElementById('srAgeId').value='<%=age%>';
</script>
<input type="text" class="readOnlySmall"  id="ageUnit" name="<%=SR_AGE_UNIT %>" value="Years" readonly="readonly"/>
</div>
<input class="transparent" size="8" />
<input type="text" readonly="readonly" value="Years" name="srAgeUnit" id="srAgeUnitId" class="readOnlySmall"> 

<div class="clear"></div>

<label>Gender</label>
	<select	id="<%=SEX_ID %>" name="<%=SEX_ID %>"	validate="Gender,metachar,no" tabindex="1">
	
		<option value="0">Select</option>
	
<%for(MasAdministrativeSex masSex : sexList){
	if(flyingIncident.getSex() !=null){
	if(flyingIncident.getSex().getId().equals(masSex.getId())){ %>	
	<option value="<%=flyingIncident.getSex().getId()%>" selected="selected"><%=flyingIncident.getSex().getAdministrativeSexName()%></option>
	<%}else{ %>	
	<option value="<%=masSex.getId() %>"><%=masSex.getAdministrativeSexName() %></option>
	<%}}else{ %>	
	<option value="<%=masSex.getId() %>"><%=masSex.getAdministrativeSexName() %></option>

	<%}
			}%>
				
</select>

<label>Unit</label> 
<select	id="<%=UNIT_ID %>" name="<%=UNIT_ID %>"	validate="Unit,metachar,no" tabindex="1">
	
		<option value="0">Select</option>
	
<%for(MasUnit masUnit : unitList){
	if(flyingIncident.getUnit().getId().equals(masUnit.getId())){ %>	
	<option value="<%=flyingIncident.getUnit().getId()%>" selected="selected"><%=flyingIncident.getUnit().getUnitName()%></option>
	<%}else{ %>	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>

	<%}
			}%>
				
</select>

<label>Aircraft Type</label>
<select	id="<%=AIRCRAFT_TYPE_ID %>" name="<%=AIRCRAFT_TYPE_ID %>"	validate="Aircraft Type,metachar,no" tabindex="1">
<option value="0">Select</option>
	
<%for(MasAircraftType aircraftType : airCraftList){
	if(flyingIncident.getAircraftType() !=null){
	if(flyingIncident.getAircraftType().getId().equals(aircraftType.getId())){ %>	
	<option value="<%=flyingIncident.getAircraftType().getId()%>" selected="selected"><%=flyingIncident.getAircraftType().getAircraftTypeName()%></option>
	<%}else{ %>	
	<option value="<%=aircraftType.getId() %>"><%=aircraftType.getAircraftTypeName() %></option>
<%}}else{ %>	
	<option value="<%=aircraftType.getId() %>"><%=aircraftType.getAircraftTypeName() %></option>
	<%}
			}%>
				
</select>

<div class="clear"></div>

<label>Nature of Incident</label>
<%if(flyingIncident.getNatureIncident() !=null){ %>
<input type="text" maxlength="30"  name="incidentNature" value="<%=flyingIncident.getNatureIncident()%>" tabindex="1"/>
<%}else{ %>
<input type="text" maxlength="30"  name="incidentNature" tabindex="1"/><%} %>

<label>Outcome</label>
<%if(flyingIncident.getOutcome() !=null){ %>
<input type="text" maxlength="30" name="outcome" value="<%=flyingIncident.getOutcome()%>" tabindex="1"/>
<%}else{ %>
<input type="text" maxlength="30"  name="outcome" tabindex="1"/><%} %>

<label>Remarks</label>
<%if(flyingIncident.getFlyingRemarks() !=null){ %>
<textarea name="incidentRemarks" onkeyup="chkLength(this,100);" tabindex="1"><%=flyingIncident.getFlyingRemarks()%> </textarea>
<%}else{ %>
<textarea name="incidentRemarks" onkeyup="chkLength(this,100);" tabindex="1"></textarea><%} %>

<div class="clear"></div>
<%} 
	} 
	//else if(flyingIncidentList.size()==0 && patientList.size() >0){
		else if(true){
	//for(Patient patient : patientList){ 
	Patient patient = patientList.get(0);%>
<input type="hidden" value="<%=patient.getId()%>" name="hinId">
<input type="hidden" value="" name="avAccidentId">
<input class="transparent" size="8" />
<label>Date</label>
<input type="text" name="<%=DATE %>" value="<%=currentDate %>" MAXLENGTH="20" class="date" id="toAppDate" validate="Date,date,yes" tabindex="1"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.incidentAccident.<%=DATE %>,event)" />

<label>Time</label>
<input type="text" name="<%=TIME %>"  value="<%=time%>"onKeyUp="mask(this.value,this,'2',':');" maxlength="5" tabindex="1"
 onBlur="checkTime('incidentAccident','<%=TIME%>');" />

<div class="clear"></div>
<Label>Rank</Label>
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	
	<%for(MasRank masRank : rankList){
	if(patient.getRank().getId().equals(masRank.getId())){ %>	
	<option value="<%=patient.getRank().getId()%>" selected="selected"><%=patient.getRank().getRankName()%></option>
	<%}else{ %>	
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}
			}
				%>
</select>

<label>Name</label>
<%if(patient.getPFirstName() !=null){
	String name="";
	name=patient.getPFirstName();
	if(patient.getPLastName() !=null){
		name=name+" "+patient.getPLastName();
	}

	%>
<input type="text" maxlength="30"  name="fullName" value="<%=name%>" tabindex="1"/><%}else{ %>
<input type="text" name="fullName" maxlength="30"  tabindex="1"/><%} %>

<label>Age</label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age,string,no"	tabindex="1" class="small">
	<option value="">Select</option>
	<% 
String ageYears="";
String age="";
if(patient.getAge()!=null){
	ageYears=patient.getAge();
	age = ageYears.substring(0,2);
}
	for(int age1 = 16;age1<=100;age1++){
%>
<option value="<%=age1%>"><%= age1%></option>
<%}%>
</select> 
<script>
document.getElementById('srAgeId').value='<%=age%>';
</script>
<input type="text" class="readOnlySmall"  id="ageUnit" name="<%=SR_AGE_UNIT %>" value="Years" readonly="readonly"/>
</div>

<div class="clear"></div>

<label>Gender</label>
	<select	id="<%=SEX_ID %>" name="<%=SEX_ID %>"	validate="Gender,metachar,no" tabindex="1">
	
		<option value="0">Select</option>
	
<%for(MasAdministrativeSex masSex : sexList){
	if(patient.getSex() !=null){
	if(patient.getSex().getId().equals(masSex.getId())){ %>	
	<option value="<%=patient.getSex().getId()%>" selected="selected"><%=patient.getSex().getAdministrativeSexName()%></option>
	<%}else{ %>	
	<option value="<%=masSex.getId() %>"><%=masSex.getAdministrativeSexName() %></option>
	<%}}else{ %>	
	<option value="<%=masSex.getId() %>"><%=masSex.getAdministrativeSexName() %></option>
	<%}
			}%>
				
</select>

<label>Unit</label> 
<select	id="<%=UNIT_ID %>" name="<%=UNIT_ID %>"	validate="Unit,metachar,no" tabindex="1">
	
		<option value="0">Select</option>
	
<%for(MasUnit masUnit : unitList){
	if(patient.getUnit().getId().equals(masUnit.getId())){ %>	
	<option value="<%=patient.getUnit().getId()%>" selected="selected"><%=patient.getUnit().getUnitName()%></option>
	<%}else{ %>	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>

	<%}
			}%>
				
</select>

<label>Aircraft Type</label>
<select	id="<%=AIRCRAFT_TYPE_ID %>" name="<%=AIRCRAFT_TYPE_ID %>"	validate="Aircraft Type,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(airCraftList!=null && airCraftList.size() >0){
	 for(MasAircraftType masAirCraft : airCraftList){
	%>
	<option value="<%=masAirCraft.getId()%>"><%=masAirCraft.getAircraftTypeName()%></option>
	<%}
	}%>
</select>
<div class="clear"></div>

<label>Nature of Incident</label>
<input type="text" maxlength="30"  name="incidentNature" maxlength="30" tabindex="1"/>
<label>Outcome</label>
<input type="text" maxlength="30"  name="outcome" maxlength="30" tabindex="1"/>

<label>Remarks</label>
<textarea name="incidentRemarks" onkeyup="chkLength(this,100);" tabindex="1"></textarea>

<div class="clear"></div>

<%//} 
	}else{ %>
<input type="hidden" value="" name="hinId">
<input type="hidden" value="" name="avAccidentId">
<input class="transparent" size="8" />
<label>Date</label>
<input type="text" name="<%=DATE %>" value="<%=currentDate %>" MAXLENGTH="20" class="date" id="toAppDate" validate="Date,date,yes" tabindex="1"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.incidentAccident.<%=DATE %>,event)" />

<label>Time</label>
<input type="text" name="<%=TIME %>" value="<%=time%>" tabindex="1"
	onKeyUp="mask(this.value,this,'2',':');" maxlength="5"
 onBlur="checkTime('incidentAccident','<%=TIME%>');" />

<div class="clear"></div>
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
<input type="text" name="fullName" maxlength="30" tabindex="1"/>

<label>Age</label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age,string,yes"	tabindex="1" class="small" >
	<option value="">Select</option>
	<%	for(int age1 = 16;age1<=100;age1++){%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 
<input type="text" class="readOnlySmall"  id="ageUnit" name="<%=SR_AGE_UNIT %>" value="Years" readonly="readonly"/>
</div>
<%--<input class="transparent" size="8" />
<input type="text" readonly="readonly" value="Years" name="srAgeUnit" id="srAgeUnitId" class="readOnlySmall">--%> 

<div class="clear"></div>

<label>Gender</label>
<select name="<%=SEX_ID %>" id="sexId" validate="Gender,metachar,no" tabindex="1">
	<%
		 for(MasAdministrativeSex masAdministrativeSex : sexList){	%>
	<option value="<%=masAdministrativeSex.getId()%>" ><%=masAdministrativeSex.getAdministrativeSexName()%></option>
	<%	 	} %>
</select> 

<label>Unit</label>
<select name="<%=UNIT_ID %>"  id="<%=UNIT_ID %>">
<option value="0">Select</option>
	<%
		for(MasUnit masUnit : unitList){	%>
	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		
		}%>
</select>

<label>Aircraft Type</label>
<select	id="<%=AIRCRAFT_TYPE_ID %>" name="<%=AIRCRAFT_TYPE_ID %>"	validate="Aircraft Type,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(airCraftList!=null && airCraftList.size() >0){
	 for(MasAircraftType masAirCraft : airCraftList){
	%>
	<option value="<%=masAirCraft.getId()%>"><%=masAirCraft.getAircraftTypeName()%></option>
	<%}
	}%>
</select>

<div class="clear"></div>

<label>Nature of Incident</label>
<input maxlength="30"  type="text" name="incidentNature" maxlength="30" tabindex="1"/>

<label>Outcome</label>
<input maxlength="30"  type="text" name="outcome" maxlength="30" tabindex="1"/>

<label>Remarks</label>
<textarea  name="incidentRemarks" onkeyup="chkLength(this,100);" tabindex="1"></textarea>

<%} %>


<script>
function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}</script>