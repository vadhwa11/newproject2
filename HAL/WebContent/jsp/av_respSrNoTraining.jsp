<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.AvTrainingStatusAircrew"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.AvAircraftAccident"%>

<%@page import="jkt.hms.masters.business.AvAircrewLectureDt"%><script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
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
	List<AvTrainingStatusAircrew> trainingAircrewList = new ArrayList<AvTrainingStatusAircrew>();
	if(map.get("unitList") != null){
		unitList =(List<MasUnit>)map.get("unitList");
	}
	if(map.get("rankList") != null)	{
		rankList = (List<MasRank>)map.get("rankList");
	}
	if(map.get("sexList") != null)	{
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	}
	if(map.get("trainingAircrewList") != null)	{
		trainingAircrewList = (List<AvTrainingStatusAircrew>)map.get("trainingAircrewList");
	}
	if(map.get("patientList") != null)	{
		patientList = (List<Patient>)map.get("patientList");
	}
	List<AvAircrewLectureDt> lectureList = new ArrayList<AvAircrewLectureDt>();
	if(map.get("lectureList") != null)	{
		lectureList = (List<AvAircrewLectureDt>)map.get("lectureList");
	}
	AvAircrewLectureDt aircrewLectureDt=new AvAircrewLectureDt();
	String topic="";
	String lectureDate="";
	if(lectureList.size() >0){
	if(lectureList != null) {
		aircrewLectureDt = (AvAircrewLectureDt) lectureList.get(0);
		if(aircrewLectureDt.getAircrewHdId().getLectureSubject() !=null){
			topic =aircrewLectureDt.getAircrewHdId().getLectureSubject();
		}
		if(aircrewLectureDt.getAircrewHdId().getAircrewDate()  !=null){
			lectureDate=HMSUtil.convertDateToStringTypeDateOnly(aircrewLectureDt.getAircrewHdId().getAircrewDate());
		}
	}
	}
%>
<%if(trainingAircrewList.size() >0){
	for(AvTrainingStatusAircrew trainingStatusAircrew:trainingAircrewList){ 
	%>
	<div class="Block">
	<%if(trainingStatusAircrew.getHin() !=null){ %>
<input type="hidden" value="<%=trainingStatusAircrew.getHin().getId() %>" name="hinId"><%}else{ %>
<input type="hidden" value="0" name="hinId">
<%} %>
<%if(trainingStatusAircrew.getId() !=null){ %>
<input type="hidden" name="avAccidentId" value="<%=trainingStatusAircrew.getId() %>"><%}else{ %>
<input type="hidden" value="" name="avAccidentId"><%} %>

<Label>Rank</Label>
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	
	<%for(MasRank masRank : rankList){
		if(trainingStatusAircrew.getRank() !=null){
	if(trainingStatusAircrew.getRank().getId().equals(masRank.getId())){ %>	
	<option value="<%=trainingStatusAircrew.getRank().getId()%>" selected="selected"><%=trainingStatusAircrew.getRank().getRankName()%></option>
	<%}else{ %>	
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%} }else{ %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}
			}
				%>
</select>

<label>Name</label>
<%if(trainingStatusAircrew.getAircrewName() !=null){ %>
<input type="text" maxlength="50" name="fullName" value="<%=trainingStatusAircrew.getAircrewName()%>" tabindex="1"/>
<%}else{ %>
<input type="text" maxlength="50" name="fullName" tabindex="1"/><%} %>

<label>Age</label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age,string,no"	tabindex="1" class="small"tabindex="1">
	<% 
String ageYears="";
String age="";
if(trainingStatusAircrew.getAge()!=null){
	ageYears=trainingStatusAircrew.getAge();
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
<input type="text" class="auto" size="4"  id="ageUnit" name="<%=SR_AGE_UNIT %>" value="Years" readonly="readonly"/>
</div>
<%--<input class="transparent" size="8" />
<input type="text" readonly="readonly" value="Years" name="srAgeUnit" id="srAgeUnitId" class="readOnlySmall">--%> 
<div class="clear"></div>
<label>Gender</label>
<select	id="<%=SEX_ID %>" name="<%=SEX_ID %>"	validate="Gender,metachar,no" tabindex="1">
	<option value="0">Select</option>
	
<%for(MasAdministrativeSex masSex : sexList){
	if(trainingStatusAircrew.getSex().getId().equals(masSex.getId())){ %>	
	<option value="<%=trainingStatusAircrew.getSex().getId()%>" selected="selected"><%=trainingStatusAircrew.getSex().getAdministrativeSexName()%></option>
	<%}else{ %>	
	<option value="<%=masSex.getId() %>"><%=masSex.getAdministrativeSexName() %></option>
	<%}
			}%>			
</select>

<label>Unit</label> 
<select	id="<%=UNIT_ID %>" name="<%=UNIT_ID %>"	validate="Unit,metachar,no" tabindex="1">
<option value="0">Select</option>
	
<%for(MasUnit masUnit : unitList){
	if(trainingStatusAircrew.getUnit() !=null){
	if(trainingStatusAircrew.getUnit().getId().equals(masUnit.getId())){ %>	
	<option value="<%=trainingStatusAircrew.getUnit().getId()%>" selected="selected"><%=trainingStatusAircrew.getUnit().getUnitName()%></option>
	<%}else{ %>	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%}}else{ %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>

	<%}
			}%>				
</select>
</div>
<div class="clear paddingTop15"></div>
<h4>Flying Experience</h4>
<div class="clear"></div>
<div class="Block">
<label>Total Flying Experience</label>
<%if(trainingStatusAircrew.getFlyingExp() !=null){ %>
<input type="text" maxlength="30" name=flyingExp class="" size="" tabindex="1" value="<%=trainingStatusAircrew.getFlyingExp()%>"
validate="Total Flying Exp,int,no" />
<%}else{ %>
<input type="text" maxlength="30" name=flyingExp class="" size="" value="" tabindex="1" validate="Total Flying Exp,int,no"/><%}%>


<label>Aircraft Flown</label>
<%if(trainingStatusAircrew.getAircraftFlown() !=null){ %>
<input type="text" maxlength="10" name="aircraftFlown" tabindex="1" value="<%=trainingStatusAircrew.getAircraftFlown()%>"
validate="Aircraft Flown,metachar,no"/><%}else{ %>
<input type="text" maxlength="10" name="aircraftFlown" tabindex="1" validate="Aircraft Flown,metachar,no"/><%} %>

<label>Current on Type</label>
<%if(trainingStatusAircrew.getCurrentOnType() !=null){ %>
<input type="text" maxlength="30" name="currentType" tabindex="1" value="<%=trainingStatusAircrew.getCurrentOnType()%>"validate="Current Type,metachar,no"/>
<%}else{ %>
<input type="text" maxlength="30" name="currentType" tabindex="1" validate="Current Type,metachar,no"/><%} %>

<div class="clear"></div>

<label>Experience on Type</label>
<%if(trainingStatusAircrew.getExpOnType() !=null){ %>
<input type="text" maxlength="30" name="expType" tabindex="1" value="<%=trainingStatusAircrew.getExpOnType()%>"
validate="Experience on Type,metachar,no"/><%}else{ %>
<input type="text" maxlength="30" name="expType" tabindex="1" validate="Experience on Type,metachar,no"/><%} %>

<label>Current Rating</label>
<%if(trainingStatusAircrew.getCurrentRating() !=null){ %>
<input type="text" maxlength="30" name="currentRating" tabindex="1" value="<%=trainingStatusAircrew.getCurrentRating()%>"
	validate="Current Rating,metachar,no"/><%}else{ %>
<input type="text" maxlength="30" name="currentRating" tabindex="1" validate="Current Rating,metachar,no"/><%} %>
</div>
<div class="clear paddingTop10"></div>

<h4>Courses</h4>
<div class="Block">

<label>Basic Indoctrination</label>
<%if(trainingStatusAircrew.getBasicIntroduction().equalsIgnoreCase("y")){ %>
<input type="checkbox" name="basicIntro" class="" checked="checked"tabindex="1"/>
<%}else{ %>
<input type="checkbox" name="basicIntro" class="" tabindex="1"/>
<%} %>

<label>Ejection Trainer</label>
<%if(trainingStatusAircrew.getEjectionTrainer().equalsIgnoreCase("y")){ %>
<input type="checkbox" name="ejectionTrainer" class="" checked="checked" tabindex="1"/>
<%}else{ %><input type="checkbox" name="ejectionTrainer" class="" tabindex="1"/><%} %>

<label>DISO</label>
<%if(trainingStatusAircrew.getDiso().equalsIgnoreCase("y")){ %>
<input type="checkbox" name="diso" class="" checked="checked" tabindex="1"/><%}else{ %>
<input type="checkbox" name="diso" class="" tabindex="1"/><%} %>

<div class="clear"></div>

<label>OPTRAM</label>
<%if(trainingStatusAircrew.getOptram().equalsIgnoreCase("y")){ %>
<input type="checkbox" name="optram" class="" checked="checked" tabindex="1"/><%}else{ %>
<input type="checkbox" name="optram" class="" tabindex="1"/><%} %>

<label>NVG</label>
<%if(trainingStatusAircrew.getNvg().equalsIgnoreCase("y")){ %>
<input type="checkbox" name="nvg" class="" checked="checked" tabindex="1"/><%}else{ %>
<input type="checkbox" name="nvg" class="" tabindex="1"/><%} %>

</div>
<div class="clear paddingTop15"></div>
<h4>Local Lecture</h4>
<div class="Block">
<label>Date</label>
<input type="text" name="localLectureDate" id="localLectureDate" value="<%=lectureDate %>" readonly="readonly" tabindex="1"/>
<label>Content/ Topic</label>
<input type="text" id="topic" name="content" readonly="readonly" value="<%=topic %>" tabindex="1"/>
</div>

<div class="clear paddingTop15"></div>
<%if(trainingStatusAircrew.getLocalLecture().equalsIgnoreCase("y")){ %>
<div style="display: inline;">
<div class="Block">
<label>Date</label>
<%if(trainingStatusAircrew.getTrainingDate() !=null){ %>
<input type="text" name="localLecDate" value="<%=HMSUtil.changeDateToddMMyyyy(trainingStatusAircrew.getTrainingDate()) %>" 
maxlength="20" class="date"	id="toAppDate" validate="Date,date,no" tabindex="1"/>
<%}else{ %>
<input type="text" name="localLecDate" value="<%=currentDate %>" maxlength="20" class="date"
 id="toAppDate" validate="Appointment Date,date,no" tabindex="1"/>
<%} %>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.appointmentForMedExam.localLecDate,event)" />

<label>Content</label>
<%if(trainingStatusAircrew.getContent() !=null){ %>
<textarea name="content" onkeyup="chkLength(this,500);" tabindex="1"><%=trainingStatusAircrew.getContent()%></textarea><%}else{ %>
<textarea name="content" onkeyup="chkLength(this,500);" tabindex="1"></textarea><%} %>
</div></div><%}else{%>
<%} %>

<%} }else if(trainingAircrewList.size()==0 && patientList.size() >0){
	//for(Patient patient : patientList){
		Patient patient= patientList.get(0);%>
	<div class="Block">
	<input type="hidden" value="<%=patient.getId()%>" name="hinId">
	<input type="hidden" value="" name="avAccidentId">

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

	<label>Name</label>
	<%if(patient.getPFirstName() !=null){
		String name="";
		name=patient.getPFirstName();
		if(patient.getPLastName() !=null){
			name=name+" "+patient.getPLastName();
		}

		%>
	<input type="text" maxlength="50" name="fullName" value="<%=name%>" tabindex="1"/><%}else{ %>
	<input type="text" maxlength="50" name="fullName" tabindex="1"/><%} %>

	<label>Age</label>
	<div id="srAgeDiv" style="display: block;">
	<select id="srAgeId" name="<%=SR_AGE%>" validate="Age,string,no"	tabindex="1" class="small">
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
<input type="text" class="auto" size="4"  id="ageUnit" name="<%=SR_AGE_UNIT %>" value="Years" readonly="readonly"/>
	</div>
	<%--<input class="transparent" size="8" />
	<input type="text" readonly="readonly" value="Years" name="srAgeUnit" id="srAgeUnitId" class="readOnlySmall">--%> 
<!--<input type="text" class="transparent" disabled="disabled" size="3" tabindex="1"/>--> 
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
		<%} } else{ %>
		<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>

		<%}
				}%>
					
	</select>
</div>
<div class="clear paddingTop15"></div>
<h4>Flying Experience</h4>
<div class="clear"></div>
<div class="Block">
<label>Total Flying Experience</label>
<input type="text" maxlength="30" name=flyingExp class="" size="" tabindex="1" validate="Total Flying Exp,int,no"/>

<label>Aircraft Flown</label>
<input type="text" maxlength="10" name="aircraftFlown" tabindex="1" validate="Aircraft Flown,metachar,no"/>

<label>Current on Type</label>
<input type="text" maxlength="30" name="currentType" tabindex="1" validate="Current on Type,metachar,no"/>

<div class="clear"></div>

<label>Exp. on Type</label>
<input type="text" maxlength="30" name="expType" tabindex="1"validate="Exp. on Type,metachar,no"/>

<label>Current Rating</label>
<input type="text" maxlength="30" name="currentRating" tabindex="1" validate="Current Rating,metachar,no,metachar,no"/>
</div>

<div class="clear paddingTop10"></div>

<h4>Courses</h4>
<div class="Block">


<label>Basic Indoctrination</label>
<input type="checkbox" name="basicIntro" class="" tabindex="1"/>

<label>Ejection Trainer</label>
<input type="checkbox" name="ejectionTrainer" class="" tabindex="1"/>

<label>DISO</label>
<input type="checkbox" name="diso" class="" tabindex="1"/>

<div class="clear"></div>

<label>OPTRAM</label>
<input type="checkbox" name="optram" class="" tabindex="1"/>

<label>NVG</label>
<input type="checkbox" name="nvg" class="" tabindex="1"/>
</div>
<div class="clear paddingTop15"></div>
<h4>Local Lecture</h4>
<div class="Block">
<label>Date</label>
<input type="text" name="localLectureDate" id="localLectureDate" value="<%=lectureDate %>" readonly="readonly" tabindex="1"/>
<label>Content/ Topic</label>
<input type="text" id="topic" name="content" readonly="readonly" value="<%=topic %>" tabindex="1" />
</div>

<%//}
	}else if(trainingAircrewList.size()==0 && patientList.size() ==0){ %>
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
<input type="text" maxlength="50" name="fullName" maxlength="30"/>
<div class="clear"></div>
<label>Age</label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age,string,no"	tabindex="1" class="small">
	<option value="">Select</option>
	<%	for(int age1 = 16;age1<=100;age1++){%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 
<input type="text" class="auto" size="4"  id="ageUnit" name="<%=SR_AGE_UNIT %>" value="Years" readonly="readonly" tabindex="1"/>
</div>
<%--<input class="transparent" size="8" />
<input type="text" readonly="readonly" value="Years" name="srAgeUnit" id="srAgeUnitId" class="readOnlySmall">--%> 
<input type="text" class="transparent" disabled="disabled" size="3" /> 
<label>Gender</label>
<select name="<%=SEX_ID %>" id="sexId" validate="Gender,metachar,no" tabindex="1">
	<%
		 for(MasAdministrativeSex masAdministrativeSex : sexList){	%>
	<option value="<%=masAdministrativeSex.getId()%>" selected="selected"><%=masAdministrativeSex.getAdministrativeSexName()%></option>
	<%} %>
</select> 

<label>Unit</label>
<select name="<%=UNIT_ID %>"  id="<%=UNIT_ID %>" tabindex="1">
<option value="0">Select</option>
	<%
		for(MasUnit masUnit : unitList){	%>
	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		
		}%>
</select>
</div>
<div class="clear paddingTop15"></div>
<h4>Flying Experience</h4>
<div class="clear"></div>
<div class="Block">
<label>Total Flying Experience</label>
<input type="text" name="flyingExp" maxlength="30" class="" size="" 
tabindex="1"validate="Total Flying Exp,int,no"/>

<label>Aircraft Flown</label>
<input type="text" maxlength="10" name="aircraftFlown" tabindex="1"validate="Aircraft Flown,metachar,no"/>

<label>Current on Type</label>
<input type="text" maxlength="30" name="currentType" tabindex="1" validate="CurrentType,metachar,no"/>

<div class="clear"></div>

<label>Exp. on Type</label>
<input type="text"  maxlength="30" name="expType" validate="Exp. on Type,metachar,no"/>

<label>Current Rating</label>
<input type="text" maxlength="30" name="currentRating" validate="Current Rating,metachar,no"/>
</div>
<div class="clear paddingTop10"></div>

<h4>Courses</h4>
<div class="Block">


<label>Basic Indoctrination</label>
<input type="checkbox" name="basicIntro" class="" tabindex="1"/>

<label>Ejection Trainer</label>
<input type="checkbox" name="ejectionTrainer" class="" tabindex="1"/>

<label>DISO</label>
<input type="checkbox" name="diso" class="" tabindex="1"/>

<div class="clear"></div>

<label>OPTRAM</label>
<input type="checkbox" name="optram" class="" tabindex="1"/>

<label>NVG</label>
<input type="checkbox" name="nvg" class="" tabindex="1"/>
</div>
<div class="clear paddingTop15"></div>
<h4>Local Lecture</h4>
<div class="Block">
<label>Date</label>
<input type="text" name="localLectureDate" id="localLectureDate" value="<%=lectureDate %>" readonly="readonly" value="" tabindex="1">
<label>Content/ Topic</label>
<input type="text" id="topic" name="content" readonly="readonly" value="<%=topic %>" tabindex="1"/>
</div><%}%>

<script>
function checkLocalLecture(){
	if(document.getElementById('localLecture').checked == true){
		document.getElementById('localLecturId').style.display = "inline";
		}
	else{
		document.getElementById('localLecturId').style.display = "none";
		}
}
</script>