
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.AvAircrewRation"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.AvAircrewRationHd"%>
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
		String time = (String) utilMap.get("currentTime");
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<MasAircraftType> aircraftList = new ArrayList<MasAircraftType>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<AvAircrewRationHd> aircrewHdList = new ArrayList<AvAircrewRationHd>();
	if(map.get("unitList") != null){
		unitList =(List<MasUnit>)map.get("unitList");
	}
	if(map.get("rankList") != null)	{
		rankList = (List<MasRank>)map.get("rankList");
	}
	if(map.get("sexList") != null)	{
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	}
	if(map.get("aircrewHdList") != null)	{
		aircrewHdList = (List<AvAircrewRationHd>)map.get("aircrewHdList");
	}
	if(map.get("patientList") != null)	{
		patientList = (List<Patient>)map.get("patientList");
	}
%>

<%if(aircrewHdList.size() > 0){
	for(AvAircrewRationHd aircrewRationHd : aircrewHdList){%>
	<%if(aircrewRationHd.getHin() !=null){ %>
<input type="hidden" value="<%=aircrewRationHd.getHin().getId() %>" name="hinId"><%}else{ %>
<input type="hidden" value="" name="hinId">
<%} %>
<%if(aircrewRationHd.getId() !=null){ %>
<input type="hidden" name="avAccidentId" value="<%=aircrewRationHd.getId() %>"><%}else{ %>
<input type="hidden" value="" name="avAccidentId"><%} %>

<input class="transparent" size="8" />

<label>Date</label>
<%if(aircrewRationHd.getAircrewDate() !=null){ %>
<input type="text" name="<%=DATE %>" value="<%=HMSUtil.changeDateToddMMyyyy(aircrewRationHd.getAircrewDate()) %>" MAXLENGTH="20" class="date" id="toAppDate" validate="Date,date,yes" />
<%}else{ %>
<input type="text" name="<%=DATE %>" value="<%=currentDate %>" MAXLENGTH="20" class="date" id="toAppDate" validate="Date,date,yes" />
<%} %>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.incidentAccident.<%=DATE %>,event)" />

<label>Time</label>
<%if(aircrewRationHd.getAircrewTime() !=null){ %>
<input type="text" name="<%=TIME %>" maxlength="10" value="<%=aircrewRationHd.getAircrewTime()%>"/>
<%}else{ %>
<input type="text" name="<%=TIME %>" maxlength="10" value="<%=time%>" /><%} %>

<div class="clear"></div>
<Label>Rank</Label>
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	
	<%for(MasRank masRank : rankList){
		if(aircrewRationHd.getRank() !=null){
	if(aircrewRationHd.getRank().getId().equals(masRank.getId())){ %>	
	<option value="<%=aircrewRationHd.getRank().getId()%>" selected="selected"><%=aircrewRationHd.getRank().getRankName()%></option>
	<%}else{ %>	
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}}else{ %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}
			}
				%>
</select>

<label>Name<span>*</span></label>
<%if(aircrewRationHd.getFullName() !=null){ %>
<input type="text" maxlength="50"  name="fullName" value="<%=aircrewRationHd.getFullName()%>"/><%}else{ %>
<input type="text" maxlength="50"  name="fullName" /><%} %>

<label>Age<span>*</span></label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId" name="<%=SR_AGE%>" maxlength="10" validate="Age,string,no" tabindex="1" class="small">
	<option value="">Select</option>
			<% 
String ageYears="";
String age="";
if(aircrewRationHd.getAge()!=null){
	ageYears=aircrewRationHd.getAge();
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
<%--<input class="transparent" size="8" />
<input type="text" readonly="readonly" value="Years" name="srAgeUnit" id="srAgeUnitId" class="readOnlySmall">--%> 

<div class="clear"></div>

<label>Gender</label>
	<select	id="<%=SEX_ID %>" name="<%=SEX_ID %>"	validate="Gender,metachar,no" tabindex="1">
	
		<option value="0">Select</option>
	
<%for(MasAdministrativeSex masSex : sexList){
	if(aircrewRationHd.getSex() !=null){
	if(aircrewRationHd.getSex().getId().equals(masSex.getId())){ %>	
	<option value="<%=aircrewRationHd.getSex().getId()%>" selected="selected"><%=aircrewRationHd.getSex().getAdministrativeSexName()%></option>
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
	if(aircrewRationHd.getUnit() !=null){
	if(aircrewRationHd.getUnit().getId().equals(masUnit.getId())){ %>	
	<option value="<%=aircrewRationHd.getUnit().getId()%>" selected="selected"><%=aircrewRationHd.getUnit().getUnitName()%></option>
	<%}else{ %>	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%}}else{ %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%}
			}%>
				
</select>

<div class="clear"></div>

<%} 
	}else if(aircrewHdList.size()==0 && patientList.size() >0){
	for(Patient patient : patientList){ %>
<input type="hidden" value="<%=patient.getId()%>" name="hinId">
<input type="hidden" value="" name="avAccidentId">
<input class="transparent" size="8" />
<label>Date</label>
<input type="text" name="<%=DATE %>" value="<%=currentDate %>" MAXLENGTH="20" class="date" id="toAppDate" validate="Date,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.incidentAccident.<%=DATE %>,event)" />

<label>Time</label>
<input type="text" name="<%=TIME %>" maxlength="10"  value="<%=time%>"/>

<div class="clear"></div>
<Label>Rank</Label>
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	
	<%for(MasRank masRank : rankList){
		if(patient.getRank() !=null){
	if(patient.getRank().getId().equals(masRank.getId())){ %>	
	<option value="<%=patient.getRank().getId()%>" selected="selected"><%=patient.getRank().getRankName()%></option>
	<%}else{ %>	
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}}else{ %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}
			}
				%>
</select>

<label>Name<span>*</span></label>
<%if(patient.getPFirstName() !=null){
	String name="";
	name=patient.getPFirstName();
	if(patient.getPLastName() !=null){
		name=name+" "+patient.getPLastName();
	}

	%>
<input type="text" maxlength="50"  name="fullName" value="<%=name%>"/><%}else{ %>
<input type="text" maxlength="50" name="fullName" /><%} %>

<label>Age<span>*</span></label>
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
	if(patient.getUnit() !=null){
	if(patient.getUnit().getId().equals(masUnit.getId())){ %>	
	<option value="<%=patient.getUnit().getId()%>" selected="selected"><%=patient.getUnit().getUnitName()%></option>
	<%}else{ %>	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%}}else{ %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%}
			}%>
</select>

<div class="clear"></div>

<%} }else{%>
<input type="hidden" value="" name="hinId">
<input type="hidden" value="" name="avAccidentId">
<input class="transparent" size="8" />
<label>Date</label>
<input type="text" name="<%=DATE %>" value="<%=currentDate %>" MAXLENGTH="20" class="date" id="toAppDate" validate="Date,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.incidentAccident.<%=DATE %>,event)" />

<label>Time</label>
<input type="text" maxlength="10"  name="<%=TIME %>" value="<%=time%>"/>

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

<label>Name<span>*</span></label>
<input type="text" maxlength="50" name="fullName" />

<label>Age<span>*</span></label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age,string,yes"	tabindex="1" class="small">
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
	<option value="<%=masAdministrativeSex.getId()%>" selected="selected"><%=masAdministrativeSex.getAdministrativeSexName()%></option>
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
<%}%>