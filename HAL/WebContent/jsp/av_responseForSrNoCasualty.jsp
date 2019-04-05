<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.AviFlyingClothingInspection"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.AviCasualtyAirEvacuation"%>
<%@page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@page import="jkt.hms.masters.business.MasEcgType"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script>
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
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");

	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map=(Map<String, Object>)request.getAttribute("map");
	}

String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}

List<MasAircraftType> aircraftTypeList = new ArrayList<MasAircraftType>();
List<AviCasualtyAirEvacuation> aviCasualtyAirEvacuationList = new ArrayList<AviCasualtyAirEvacuation>();
List<MasUnit> unitList = new ArrayList<MasUnit>();
List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
List<MasTrade> tradeList = new ArrayList<MasTrade>();

List<MasRecordOfficeAddress> recordOffList = new ArrayList<MasRecordOfficeAddress>();
List<MasRank> rankList = new ArrayList<MasRank>();
List<Patient> patientList = new ArrayList<Patient>();

if(map.get("aircraftTypeList") != null){
	aircraftTypeList = (List<MasAircraftType>)map.get("aircraftTypeList");
}
String currentTime = (String)utilMap.get("currentTimeWithoutSc");
if(map.get("patientList") != null){
	patientList = (List<Patient>)map.get("patientList");
}
if(map.get("aviCasualtyAirEvacuationList") != null){
	aviCasualtyAirEvacuationList = (List<AviCasualtyAirEvacuation>)map.get("aviCasualtyAirEvacuationList");
}
	if(map.get("genderList") != null){
		genderList =(List<MasAdministrativeSex>)map.get("genderList");
	}
	if(map.get("unitList") != null){
		unitList =(List<MasUnit>)map.get("unitList");
	}
	if(map.get("rankList") != null)	{
		rankList = (List<MasRank>)map.get("rankList");
	}
	if(map.get("tradeList") != null){
		tradeList =(List<MasTrade>)map.get("tradeList");
	}
	/*
	List<MasServiceStatus> serviceStatusList = new ArrayList<MasServiceStatus>();
List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
	List<MasCommand>  commandList = new ArrayList<MasCommand>();
List<MasSection> sectionList = new ArrayList<MasSection>();
List<MasStation> stationList = new ArrayList<MasStation>();
	if(map.get("serviceStatusList") != null){
		serviceStatusList =(List<MasServiceStatus>)map.get("serviceStatusList");
	}
	if(map.get("serviceTypeList") != null){
		serviceTypeList =(List<MasServiceType>)map.get("serviceTypeList");
	}
	if(map.get("sectionList") != null){
		sectionList =(List<MasSection>)map.get("sectionList");
	}
	if(map.get("stationList") != null){
		stationList =(List<MasStation>)map.get("stationList");
	}
	if(map.get("recordOffList") != null){
		recordOffList =(List<MasRecordOfficeAddress>)map.get("recordOffList");}*/
	
	
	
	if(aviCasualtyAirEvacuationList.size() > 0){
		for(AviCasualtyAirEvacuation casualtyAirEvacuat: aviCasualtyAirEvacuationList){ %>

<div class="clear paddingTop15"></div>
<div class="Block">
<%if(casualtyAirEvacuat.getHin() !=null){  %>
<input type="hidden" value="<%=casualtyAirEvacuat.getHin().getId() %>" name="hinId"><%}else{ %>
<input type="hidden" value="" name="hinId">
<%} %>
<%if(casualtyAirEvacuat.getId() !=null){ %>
<input type="hidden" name="avAccidentId" value="<%=casualtyAirEvacuat.getId() %>" /><%}else{ %>
<input type="hidden" value="" name="avAccidentId" /><%} %>
<label>Date</label> 
<input type="text" id="<%=DATE %>" name="<%=DATE %>"	tabindex="1" value="<%=currentDate %>" readonly="readonly"	validate="Date,date,no" MAXLENGTH="7" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.casualtyAirEvacuation.<%=DATE%>,event)" />

<label>Time</label>
<input  name="<%=TIME %>" id="<%=TIME %>" type="text" tabindex="1" value="<%=time %>"  class="calDate"	
onKeyUp="mask(this.value,this,'2',':');" maxlength="5"
onBlur="checkTime('casualtyAirEvacuation','<%=TIME%>');"/> 
<label class="unit2">Hrs.</label>


<div class="clear"></div>
<label> First Name <span>*</span></label> 
<%if(casualtyAirEvacuat.getFirstName() !=null){ %>
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="<%=casualtyAirEvacuat.getFirstName() %>" tabindex="1"	validate="First Name,name,yes" MAXLENGTH="30" />
<%}else{ %>
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"	validate="First Name,name,yes" MAXLENGTH="30" /><%} %>

<label>Middle Name</label> 
<%if(casualtyAirEvacuat.getMiddleName() !=null){ %>
<input type="text"	id="pFirstNameId" name="<%=P_MIDDLE_NAME %>" value="<%=casualtyAirEvacuat.getMiddleName()%>" tabindex="1"	validate="Middle Name,name,no" MAXLENGTH="30" />
<%}else{ %>
<input type="text"	id="pFirstNameId" name="<%=P_MIDDLE_NAME %>" value="" tabindex="1"	validate="Middle Name,name,no" MAXLENGTH="30" /><%} %>

<label>Last Name</label> 
<%if(casualtyAirEvacuat.getLastName() !=null){ %>
<input type="text"	id="pFirstNameId" name="<%=P_LAST_NAME %>" value="<%=casualtyAirEvacuat.getLastName()  %>" tabindex="1"	validate="Last Name,name,yes" MAXLENGTH="30" />
<%}else{ %>
<input type="text"	id="pFirstNameId" name="<%=P_LAST_NAME %>" value="" tabindex="1"	validate="Last Name,name,yes" MAXLENGTH="30" /><%} %>

<div class="clear"></div>
<label> Rank</label> 
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="Rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	
	<%for(MasRank masRank : rankList){
		if(casualtyAirEvacuat.getRank() !=null){
	if(casualtyAirEvacuat.getRank().getId().equals(masRank.getId())){ %>	
	<option value="<%=casualtyAirEvacuat.getRank().getId()%>" selected="selected"><%=casualtyAirEvacuat.getRank().getRankName()%></option>
	<%}else{ %>	
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}}else{ %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}
			}
				%>
</select>
<label>Unit</label> 
<select	id="<%=UNIT_ID %>" name="<%=UNIT_ID %>"	validate="Unit,metachar,no" tabindex="1">
	
		<option value="0">Select</option>
	
<%for(MasUnit masUnit : unitList){
	if(casualtyAirEvacuat.getUnit()  !=null){
	if(casualtyAirEvacuat.getUnit().getId().equals(masUnit.getId())){ %>	
	<option value="<%=casualtyAirEvacuat.getUnit().getId()%>" selected="selected"><%=casualtyAirEvacuat.getUnit().getUnitName()%></option>
	<%}else{ %>	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option><%}}else{ %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%}
			}%>
				
</select>

<label>Branch/Trade</label> 

<select name="<%=TRADE_ID %>"  id="<%=TRADE_ID %>">
	
		<option value="0">Select</option>
	
<%for(MasTrade masTrade : tradeList){
	if(casualtyAirEvacuat.getTrade() !=null){
	if(casualtyAirEvacuat.getTrade().getId().equals(masTrade.getId())){ %>	
	<option value="<%=casualtyAirEvacuat.getTrade().getId()%>" selected="selected"><%=casualtyAirEvacuat.getTrade().getTradeName()%></option>
	<%}else{ %>	
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>
	<%}}else{ %>
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>

	<%}
			}%>
				
</select>
<div class="clear"></div>
<label>Total Service</label>

<input  name="<%=TOTAL_SERVICE %>" id="<%=TOTAL_SERVICE %>" type="text" tabindex="1" maxlength="22" class="auto" size="10"/>
<label class="unit">yrs.</label> 
<input class="transparent" size="4">
<label>Age <span>*</span></label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age,string,no"	tabindex="1" class="small">
	<option value="">Select</option>
	<% 
String ageYears="";
String age="";
if(casualtyAirEvacuat.getAge()!=null){
	ageYears=casualtyAirEvacuat.getAge();
	age = ageYears.substring(0,2);
}
	for(int age1 = 16;age1<=100;age1++){
%>
<option value="<%=age1%>"><%= age1%></option>
<%}%>
</select> 
<script>
document.getElementById('srAgeId').value='<%=age%>';
</script></div>
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly"/>
<label>Gender</label>
	<select	id="<%=SEX_ID %>" name="<%=SEX_ID %>"	validate="Gender,metachar,no" tabindex="1">
	
		<option value="0">Select</option>
	
<%for(MasAdministrativeSex masSex : genderList){
	if(casualtyAirEvacuat.getGender() !=null){
	if(casualtyAirEvacuat.getGender().getId().equals(masSex.getId())){ %>	
	<option value="<%=casualtyAirEvacuat.getGender().getId()%>" selected="selected"><%=casualtyAirEvacuat.getGender().getAdministrativeSexName()%></option>
	<%}else{ %>	
	<option value="<%=masSex.getId() %>"><%=masSex.getAdministrativeSexName() %></option>
	<%}}else{ %>
	<option value="<%=masSex.getId() %>"><%=masSex.getAdministrativeSexName() %></option>

	<%}
			}%>
				
</select>

</div>
<%--
<label> Service Status <span>*</span></label> 
<select	id="serviceStatusId" name="<%=SERVICE_STATUS_ID %>"
	validate="Service Status,string,yes" tabindex="1"	>
	<option value="0">Select</option>
	<% 
			for(MasServiceStatus masServiceStatus : serviceStatusList){
				if(casualtyAirEvacuat.getServiceStatus() !=null){
					if(casualtyAirEvacuat.getServiceStatus().getId().equals(masServiceStatus.getId())){
		%>
<option value="<%=casualtyAirEvacuat.getServiceStatus().getId()%>" selected="selected"><%=casualtyAirEvacuat.getServiceStatus().getServiceStatusName() %></option>
<%}else{ %>
	<option value="<%=masServiceStatus.getId()%>"><%=masServiceStatus.getServiceStatusName()%></option>
	
	<%}}else{%>
	<option value="<%=masServiceStatus.getId()%>"><%=masServiceStatus.getServiceStatusName()%></option>

	<%}
			}
				%>
</select>
<div id="exServiceId"></div>
<label>HIN</label>
<input type="text" value="" id="regHinId" name="regHinId"/>
<label>Service Type <span>*</span></label> 
<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>"	validate="Service Type,string,yes" tabindex="1"
	>
	<option value="0">Select</option>

	<% 
			for(MasServiceType masServiceType : serviceTypeList){
				if(casualtyAirEvacuat.getServiceType() !=null){
					if(casualtyAirEvacuat.getServiceType().getId().equals(masServiceType.getId())){
		%>
<option value="<%=casualtyAirEvacuat.getServiceType().getId()%>" selected="selected"><%=casualtyAirEvacuat.getServiceType().getServiceTypeName()%></option>
<%}else{ %>
	<option value="<%=masServiceType.getId()%>"><%=masServiceType.getServiceTypeName()%></option>
	
	<%}}else{%>
	<option value="<%=masServiceType.getId()%>"><%=masServiceType.getServiceTypeName()%></option>

	<%}
			}
				%>
</select>
<div class="clear"></div>
<div id="rankDivId">
<label> Rank <span>*</span></label> 
<select	id="rankId" name="<%=RANK_ID%>" validate="Rank,string,yes" tabindex="1" onchange="">
	<option value="0">Select</option>

	<% 
			for(MasRank masRank : rankList){
				if(casualtyAirEvacuat.getRank() !=null){
					if(casualtyAirEvacuat.getRank().getId().equals(masRank.getId())){
		%>
<option value="<%=casualtyAirEvacuat.getRank().getId()%>" selected="selected"><%=casualtyAirEvacuat.getRank().getRankName()%></option>
<%}else{ %>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	
	<%}}else{%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>

	<%}
			}
				%>
</select>
</div> <!-- End Of rankDivId-->


<div class="clear"></div>
<label>First Name <span>*</span></label> 
<input id="sFNameId" type="text" name="<%=S_FIRST_NAME %>" value="<%=casualtyAirEvacuat.getFirstName() %>"
 tabindex="1"	title="First Name of Service Person"	validate="First Name,alphaspace,yes" MAXLENGTH="15"	onblur="fillPatientName(this);" /> 

<label>Middle Name</label>
<%if(casualtyAirEvacuat.getMiddleName() !=null){ %> 
<input	id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value="<%=casualtyAirEvacuat.getMiddleName() %>"	tabindex="1" validate="Middle Name of Service Person,alphaspace,no"	MAXLENGTH="15" onchange="fillPatientName(this);" />
<%}else{ %>
<input	id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value=""	tabindex="1" validate="Middle Name,alphaspace,no"	MAXLENGTH="15" />
<%} %>
<div class="clear"></div>
<label>Last Name</label> 
<%if(casualtyAirEvacuat.getLastName() !=null){ %>
<input id="sLNameId" type="text"	name="<%=S_LAST_NAME %>" value="<%=casualtyAirEvacuat.getLastName() %>" tabindex="1"	validate="Last Name,alphaspace,no" MAXLENGTH="15"	 />
<%}else{ %>
<input id="sLNameId" type="text"	name="<%=S_LAST_NAME %>" value="" tabindex="1"	validate="Last Name,alphaspace,no" MAXLENGTH="15"	 />
<%} %>
<div id="srPrDtDiv">


<label> Trade/Branch</label> 
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,string,no" tabindex="1"	onchange="displayOtherTrade(this.value);">
	<option value="0">Select</option>

	<% 
			for(MasTrade masTrade : tradeList){
				if(casualtyAirEvacuat.getTrade() !=null){
					if(casualtyAirEvacuat.getTrade().getId().equals(masTrade.getId())){
		%>
<option value="<%=casualtyAirEvacuat.getTrade().getId()%>" selected="selected"><%=casualtyAirEvacuat.getTrade().getTradeName()%></option>
<%}else{ %>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	
	<%}}else{%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>

	<%}
			}
				%>
</select>


<label> DOE/DOC</label> 
<input type="text"	id="commissionDateId" name="commissionDate" tabindex="1" value=""	validate="commission Date,date,no" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');"	class="calDate" onblur="calculateTotalService(this.value);" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.registration.commissionDate,event)" /> 
<input	type="hidden" id="idForComEnrlDate" value=""/> 
<div class="clear"></div>
<label>Total Service </label> 
<input id="totalServYrs" type="hidden" name="" value=""	validate="Total Service,float,no" maxlength="6" tabindex="1" />

<div id="totalService" style="display: block;">
<select	id="totalServ" name="<%=TOTAL_SERVICE%>"	validate="Total Service year,string,no" tabindex="1" class="small"	onchange="checkAgeAndService();">
	<%
				for(int age1=0;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="totalServUnit" name="<%=TOTAL_SERVICE_PERIOD %>" tabindex="1" class="smallest" >
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select>
</div>

<div class="clear"></div>
<label>Section</label> 
<select id="sectionId" name="<%=SECTION_ID%>"	validate="Section,string,no" tabindex="1"	onblur="displayOtherSec(this.value)">
	<option value="0">Select</option>
<% 
			for(MasSection masSection : sectionList){
				if(casualtyAirEvacuat.getSection() !=null){
					if(casualtyAirEvacuat.getSection().getId().equals(masSection.getId())){
		%>
<option value="<%=casualtyAirEvacuat.getSection().getId()%>" selected="selected"><%=casualtyAirEvacuat.getSection().getSectionName()%></option>
<%}else{ %>
	<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>
	
	<%}}else{%>
	<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>

	<%}
			}
				%>

</select>

<label>Unit <span>*</span></label> 
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,string,yes" onchange="displayOtherUnit(this.value);populateStationForUnit(this.value);">
	<option value="0">Select</option>
	<% 
			for(MasUnit masUnit : unitList){
				if(casualtyAirEvacuat.getUnit() !=null){
					if(casualtyAirEvacuat.getUnit().getId().equals(masUnit.getId())){
		%>
<option value="<%=casualtyAirEvacuat.getUnit().getId()%>" selected="selected"><%=casualtyAirEvacuat.getUnit().getUnitName()%></option>
<%}else{ %>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	
	<%}}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>

	<%}
			}
				%>
</select>
<div class="clear"></div>
<label>Station</label> 
<%if(casualtyAirEvacuat.getStation()  !=null){ %>
<input type="text" id="stationId" name="<%=STATION %>" value="<%=casualtyAirEvacuat.getStation()  %>"/>
<%}else{ %>
<input type="text" id="stationId" name="<%=STATION %>" value=""/>
<%} %>

<label> Command</label> 
<select id="commandId" name="<%=COMMAND %>"	validate="Command,string,no" tabindex="1"	onchange="displayOtherCmd(this.value);">
	<option value="0">Select</option>
	<% 
			for(MasCommand masCommand : commandList){
				if(casualtyAirEvacuat.getCommand() !=null){
					if(casualtyAirEvacuat.getCommand().getId().equals(masCommand.getId())){
		%>
<option value="<%=casualtyAirEvacuat.getCommand().getId()%>" selected="selected"><%=casualtyAirEvacuat.getCommand().getCommandName()%></option>
<%}else{ %>
	<option value="<%=masCommand.getId()%>"><%=masCommand.getCommandName()%></option>
	
	<%}}else{%>
	<option value="<%=masCommand.getId()%>"><%=masCommand.getCommandName()%></option>

	<%}
			}
				%>
</select>
<label > Record Office</label>
<select id="recordOffId" name="<%=RECORD_OFFICE_ADDRESS_ID %>" validate="RecordOff Addrs,string,no"  tabindex="1">
<option value="0">Select</option>
<% 
			for(MasRecordOfficeAddress recordOfficeAddress : recordOffList){
				if(casualtyAirEvacuat.getRecordOffice() !=null){
					if(casualtyAirEvacuat.getRecordOffice().getId().equals(recordOfficeAddress.getId())){
		%>
<option value="<%=casualtyAirEvacuat.getRecordOffice().getId()%>" selected="selected"><%=casualtyAirEvacuat.getRecordOffice().getAddress()%></option>
<%}else{ %>
	<option value="<%=recordOfficeAddress.getId()%>"><%=recordOfficeAddress.getAddress()%></option>
	
	<%}}else{%>
	<option value="<%=recordOfficeAddress.getId()%>"><%=recordOfficeAddress.getAddress()%></option>

	<%}
			}
				%>
</select>
</div>--%><!-- End srPrDtDiv-->
<div class="clear"></div>

<h4>CASUALTY DETAILS</h4>
<div class="Block">	

<label>Date of Arrival</label> 
<%if(casualtyAirEvacuat.getDateCasualtyArrival()!=null){ %>
<input type="text" id="<%=DATE_CASUALTY_ARRIVAL %>" value="<%=HMSUtil.changeDateToddMMyyyy(casualtyAirEvacuat.getDateCasualtyArrival())%>" name="<%=DATE_CASUALTY_ARRIVAL %>"	tabindex="1" value="" readonly="readonly"	validate="Date of Arrival,date,no" MAXLENGTH="30" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE_CASUALTY_ARRIVAL%>,event)" />
<%}else{
%>
<input type="text" id="<%=DATE_CASUALTY_ARRIVAL %>"  name="<%=DATE_CASUALTY_ARRIVAL %>"	tabindex="1" value="" readonly="readonly"	validate="Date of Arrival,date,no" MAXLENGTH="30" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE_CASUALTY_ARRIVAL%>,event)" />

<%} %>
<label>Time of Arrival</label>
<%if(casualtyAirEvacuat.getDateCasualtyArrival()!=null){ %>
<input  name="<%=TIME_CASUALTY_ARRIVAL %>" value="<%=casualtyAirEvacuat.getCasualtyAirEvacuationTime() %>" id="<%=TIME_CASUALTY_ARRIVAL %>" type="text" tabindex="1" maxlength="5" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTimeForSetup1(this.value,this.id);" /> 

<%}else{ %>
<input  name="<%=TIME_CASUALTY_ARRIVAL %>"  id="<%=TIME_CASUALTY_ARRIVAL %>" type="text" tabindex="1" maxlength="5" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTimeForSetup1(this.value,this.id);" /> 

<%} %>
<div class="clear"></div>

<label>Clinical Status</label>
<%
String casualtyClinical="";
if(casualtyAirEvacuat.getClinical() !=null){
	casualtyClinical=casualtyAirEvacuat.getClinical();
}	%>
<textarea rows="" cols="24"	name="<%=CLINICAL %>" id="<%=CLINICAL %>" onkeyup="chkLength(this,29);">
<%=casualtyClinical%>
</textarea>
	

<label>Diagnosis</label>
<%
String casualtyDiag="";
if(casualtyAirEvacuat.getClinical() !=null){
	casualtyDiag=casualtyAirEvacuat.getDiagnosis();
}	%>
<input type="text" name="<%=DIAGNOSIS %>" id="<%=DIAGNOSIS %>"  value="<%=casualtyDiag%>" 	validate="Diagnosis,metachar,no"  maxlength="30" />
	

<div class="clear"></div>
<label>Condition <span>*</span></label> 
<select id="conditionId" name="<%=CONDITION %>" class="year" tabindex="1" validate="Condition,metachar,yes" onchange="displayStatusTest(),displayListDateTimeTest();">

		<% if(casualtyAirEvacuat.getCondition().equals("0")) {%>
<option value="" selected="selected"></option>
		<option value="Critical">Critical</option>

<% }else  {%>
		<option value="0">Select</option>
	<option value="Critical" selected="selected">Critical</option>
	
	<%}%>

</select> 
<label>Status <span>*</span></label>

<% if(casualtyAirEvacuat.getConditionStatus().equalsIgnoreCase("DIL")) { %>
<div id="status1" style="display: none;">
<select name="<%=CONDITION_STATUS %>" class="" tabindex="1" >
<option value="" selected="selected"></option>
	<option value="SIL">SIL</option>
	<option value="DIL">DIL</option>
	</select>
	<div class="clear"></div>
<label>List Date</label> 

<input id="listdateId" type="text" value=""	 name="<%=LIST_DATE %>" value="" tabindex="1" 	validate="List Date,date,no" readonly="readonly">

<label>List Time</label> 
<input id="listtimeId" type="text" value=""	name="<%=LIST_TIME %>" value="" tabindex="1"  validate="List Time,string,no"	readonly="readonly">
	
</div>

<% }else if(casualtyAirEvacuat.getConditionStatus().equalsIgnoreCase("SIL")) { %>
	<select name="<%=CONDITION_STATUS %>" class="" tabindex="1" >
	<option value="SIL" selected="selected">SIL</option>
	<option value="DIL">DIL</option>
	</select>
	<div class="clear"></div>
	<label>List Date</label> 
<%if(casualtyAirEvacuat.getDateCondition()!=null){ %>
<input id="listdateId" type="text" value="<%=HMSUtil.changeDateToddMMyyyy(casualtyAirEvacuat.getDateCondition())%>"	 name="<%=LIST_DATE %>" value="" tabindex="1" 	validate="List Date,date,no" readonly="readonly"> 
<%}else{ %>
<input id="listdateId" type="text" value=""	 name="<%=LIST_DATE %>" value="" tabindex="1" 	validate="List Date,String,no" readonly="readonly">
<%} %>	
<label>List Time</label> 
<input id="listtimeId" type="text" value="<%=casualtyAirEvacuat.getTimeCondition() %>"	name="<%=LIST_TIME %>" value="" tabindex="1"  validate="List Time,string,no"	readonly="readonly">
	
	<%}else{ %>
	<select name="<%=CONDITION_STATUS %>" class="" tabindex="1" >
	<option value="SIL">SIL</option>
	<option value="DIL" selected="selected">DIL</option>
	</select>
	<div class="clear"></div>
	<label>List Date</label> 
<%if(casualtyAirEvacuat.getDateCondition()!=null){ %>
<input id="listdateId" type="text" value="<%=HMSUtil.changeDateToddMMyyyy(casualtyAirEvacuat.getDateCondition())%>"	 name="<%=LIST_DATE %>" value="" tabindex="1" 	validate="List Date,date,no" readonly="readonly"> 
<%}else{ %>
<input id="listdateId" type="text" value=""	 name="<%=LIST_DATE %>" value="" tabindex="1" 	validate="List Date,String,no" readonly="readonly">
<%} %>	
<label>List Time</label> 
<input id="listtimeId" type="text" value="<%=casualtyAirEvacuat.getTimeCondition() %>"	name="<%=LIST_TIME %>" value="" tabindex="1"  validate="List Time,string,no"	readonly="readonly">
	
	<%}%>
<script type="text/javascript">

function displayStatusTest(){
	var condition = document.casualtyAirEvacuation.<%=CONDITION %>.value;
	if(condition == "Critical"){
		document.getElementById('status1').style.display = "inline";

	}else{
		document.getElementById('status1').style.display = "none";

	}
}

	function displayListDateTimeTest(){
	var cond = document.getElementById('conditionId').value;
	date = '<%=currentDate%>';
	time = '<%=currentTime%>';
	if(cond == "Critical"){
		document.getElementById('listdateId').value = date;
		document.getElementById('listtimeId').value = time;
	}else{
		document.getElementById('listdateId').value = "";
		document.getElementById('listtimeId').value = "";
	}
	
}
	function populateListDateTimeTest(){
	document.getElementById('listdateId').value = date;
		document.getElementById('listtimeId').value = time;
	}		
</script>
<div class="clear"></div>

<label> Casualty </label> 
<select name="<%=CASUALTY %>"  id="casualty">
<%if(casualtyAirEvacuat.getCasualty().equalsIgnoreCase("Uncloading")){ %>
<option value="Unloading" selected="selected">Unloading</option>
<option value="Loading">Loading</option>

<%}else{ %>

<option value="Unloading">Unloading</option>
<option value="Loading"  selected="selected">Loading</option>
<%} %>
</select>
<label>Date</label> 
<%if(casualtyAirEvacuat.getDateCasualty()!=null){ %>
<input type="text" id="<%=DATE_CASUALTY %>" value="<%=HMSUtil.changeDateToddMMyyyy(casualtyAirEvacuat.getDateCasualty()) %>" name="<%=DATE_CASUALTY %>"	tabindex="1" value="" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE_CASUALTY%>,event)" />

<%}else{ %>
<input type="text" id="<%=DATE_CASUALTY %>" name="<%=DATE_CASUALTY %>"	tabindex="1" value="" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE_CASUALTY%>,event)" />
<%} %>

<label>Time</label>
<%String timeCasualty="";
if(casualtyAirEvacuat.getTimeCasualty()  !=null){
	timeCasualty=casualtyAirEvacuat.getTimeCasualty() ;
}
%>
<input  name="<%=TIME_CASUALTY %>" id="<%=TIME_CASUALTY %>" value="<%=timeCasualty %>" type="text" tabindex="1" maxlength="5" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTimeForSetup1(this.value,this.id);" /> 

<div class="clear"></div>


<label class="large">Diffculties Experience during flight and emplaning</label>
<%String casulDifficulties="";
if(casualtyAirEvacuat.getDiffculties()  !=null){
	casulDifficulties=casualtyAirEvacuat.getDiffculties() ;
}
%>
<textarea rows="" cols="55"	name="<%=DIFFCULTIES %>" id="<%=DIFFCULTIES %>" class="auto" onkeyup="chkLength(this,50);">
<%=casulDifficulties %>
</textarea>

<div class="clear"></div>	
<label class="large">Disposal of Casualty Belongings</label>
<%String disposal="";
if(casualtyAirEvacuat.getDisposal()  !=null){
	disposal=casualtyAirEvacuat.getDisposal() ;
}
%>
<textarea rows="" class="auto" cols="57" name="disposal" onkeyup="chkLength(this,30);"><%=disposal %></textarea>

<%--<input type="text" name="<%=DISPOSAL %>" id="<%=DISPOSAL %>" value="<%=casualtyAirEvacuat.getDisposal() %>" 	validate="Diagnosis,string,no"  maxlength="30" class="auto" size="79"/> --%>
	
<div class="clear"></div>
<label  class="large">Suggestions/Remarks</label>
<%String suggestionsRemarks="";
if(casualtyAirEvacuat.getRemarks()  !=null){
	suggestionsRemarks=casualtyAirEvacuat.getRemarks() ;
}
%>
<textarea rows="" cols="55"	name="<%=REMARKS %>" id="<%=REMARKS %>" class="auto" onkeyup="chkLength(this,100);">
<%=suggestionsRemarks %>
</textarea>
</div>
<div class="clear paddingTop15"></div>

<h4>AIRCRAFT DETAILS</h4>
<div class="Block">	

<label> Aircraft Type </label> 
<select name="<%=AIRCRAFT_TYPE_ID %>" id="<%=AIRCRAFT_TYPE_ID %>"  tabindex="1"	>

<option value="0">Select</option>	
<%	for(MasAircraftType masAircraftType : aircraftTypeList){
	if(casualtyAirEvacuat.getAircraftType() !=null){
	if(casualtyAirEvacuat.getAircraftType().getId().equals(masAircraftType.getId())){ %>	
	<option value="<%=casualtyAirEvacuat.getAircraftType().getId()%>" selected="selected"><%=casualtyAirEvacuat.getAircraftType().getAircraftTypeName()%></option>
	<%}else{ %>	
	<option value="<%=masAircraftType.getId() %>"><%=masAircraftType.getAircraftTypeName() %></option>
	<%}}else{ %>
<option value="<%=masAircraftType.getId() %>"><%=masAircraftType.getAircraftTypeName() %></option>
	<%}
			}%>
				
</select> 
<%if(casualtyAirEvacuat.getRadioForTable() !=null && casualtyAirEvacuat.getRadioForTable().equals("s")){ %>
<label> Case Sitting </label>
<input type="radio" name="<%=RADIO_FOR_TABLE %>" id="<%=RADIO_FOR_TABLE %>"  value="s" checked="checked"/>
<label> Case Lying </label> 
<input type="radio" name="<%=RADIO_FOR_TABLE %>" id="<%=RADIO_FOR_TABLE %>"  value="l"/>

	<%}else if(casualtyAirEvacuat.getRadioForTable() !=null && casualtyAirEvacuat.getRadioForTable().equals("l")){ %>
<label> Case Sitting </label>
<input type="radio" name="<%=RADIO_FOR_TABLE %>" id="<%=RADIO_FOR_TABLE %>"  value="s" />
<label> Case Lying </label> 
<input type="radio" name="<%=RADIO_FOR_TABLE %>" id="<%=RADIO_FOR_TABLE %>"  value="l" checked="checked"/>
	<%}else{%>
<label> Case Sitting </label>
<input type="radio" name="<%=RADIO_FOR_TABLE %>" id="<%=RADIO_FOR_TABLE %>"  value="s" />
<label> Case Lying </label> 
<input type="radio" name="<%=RADIO_FOR_TABLE %>" id="<%=RADIO_FOR_TABLE %>"  value="l" />

	<%} %>
<div class="clear"></div>	
<label>Total Duration including Station</label>
<%int totalDuration=0;
if(casualtyAirEvacuat.getTotalDuration()  !=null){
	totalDuration=casualtyAirEvacuat.getTotalDuration() ;
}
%>
<input type="text" name="<%=TOTAL_DURATION %>" id="<%=TOTAL_DURATION%>"  value="<%=totalDuration %>" 	validate="Total Duration,int,no"  maxlength="30"/>

<label>Duration Holding</label>
<%int durationHold=0;
if(casualtyAirEvacuat.getDurationHolding()  !=null){
	durationHold=casualtyAirEvacuat.getDurationHolding() ;
}
%>
<input type="text" name="<%=DURATION_HOLDING %>" id="<%=DURATION_HOLDING %>"  value="<%=durationHold %>" 	validate="Duration Holding,int,no"  maxlength="30" />

<label>Enroute Holding Unit</label>
<select name="<%=ENROUTE_HOLDING_UNIT %>" id="<%=ENROUTE_HOLDING_UNIT %>"  tabindex="1"	>
<option value="0">Select</option>
	
<%for(MasUnit enrouteHoldingUnit : unitList){
	if(casualtyAirEvacuat.getEnrouteHoldingUnit() !=null){
	if(casualtyAirEvacuat.getEnrouteHoldingUnit().getId().equals(enrouteHoldingUnit.getId())){ %>	
	<option value="<%=casualtyAirEvacuat.getEnrouteHoldingUnit().getId()%>" selected="selected"><%=casualtyAirEvacuat.getEnrouteHoldingUnit().getUnitName()%></option>
	<%}else{ %>	
	<option value="<%=enrouteHoldingUnit.getId() %>"><%=enrouteHoldingUnit.getUnitName() %></option>
<%}}else{ %>
<option value="<%=enrouteHoldingUnit.getId() %>"><%=enrouteHoldingUnit.getUnitName() %></option>
	<%}			} %>				
</select>	
</div>

<%}}else if(aviCasualtyAirEvacuationList.size() ==0 && patientList.size() >0){
//	for(Patient patient:patientList){
	Patient patient=patientList.get(0);
%>
<div class="clear paddingTop15"></div>
<div class="Block">
<input type="hidden" value="<%=patient.getId()%>" name="hinId">
<input type="hidden" value="" name="avAccidentId">
<label>Date</label> 
<input type="text" id="<%=DATE %>" name="<%=DATE %>"	tabindex="1" value="<%=currentDate %>" readonly="readonly"	validate="Date,date,no" MAXLENGTH="7" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE%>,event)" />

<label>Time</label>
<input  name="<%=TIME %>" id="<%=TIME %>" type="text" tabindex="1" value="<%=time %>"onKeyUp="mask(this.value,this,'2',':');" maxlength="5"class="calDate"
onBlur="checkTime('casualtyAirEvacuation','<%=TIME%>');" />
<label class="unit2">Hrs.</label>

<div class="clear"></div>
<label> First Name <span>*</span></label> 
<%if(patient.getPFirstName() !=null){ %>
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="<%=patient.getPFirstName() %>" tabindex="1"	validate="First Name,name,yes" MAXLENGTH="30" />
<%}else{ %>
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"	validate="First Name,name,yes" MAXLENGTH="30" /><%} %>

<label>Middle Name</label> 
<%if(patient.getPMiddleName() !=null){ %>
<input type="text"	id="pFirstNameId" name="<%=P_MIDDLE_NAME %>" value="<%=patient.getPMiddleName() %>" tabindex="1"	validate="Middle Name,name,no" MAXLENGTH="30" />
<%}else{ %>
<input type="text"	id="pFirstNameId" name="<%=P_MIDDLE_NAME %>" value="" tabindex="1"	validate="Middle Name,name,no" MAXLENGTH="30" /><%} %>

<label>Last Name</label> 
<%if(patient.getPLastName() !=null){ %>
<input type="text"	id="pFirstNameId" name="<%=P_LAST_NAME %>" value="<%=patient.getPLastName() %>" tabindex="1"	validate="Last Name,name,yes" MAXLENGTH="30" />
<%}else{ %>
<input type="text"	id="pFirstNameId" name="<%=P_LAST_NAME %>" value="" tabindex="1"	validate="Last Name,name,yes" MAXLENGTH="30" /><%} %>

<div class="clear"></div>
<label> Rank</label> 
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

<label>Branch/Trade</label> 

<select name="<%=TRADE_ID %>"  id="<%=TRADE_ID %>">
	
		<option value="0">Select</option>
	
<%for(MasTrade masTrade : tradeList){
	if(patient.getTrade().getId().equals(masTrade.getId())){ %>	
	<option value="<%=patient.getTrade().getId()%>" selected="selected"><%=patient.getTrade().getTradeName()%></option>
	<%}else{ %>	
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>

	<%}
			}%>
				
</select>
<div class="clear"></div>
<label>Total Service</label>

<input  name="<%=TOTAL_SERVICE %>" id="<%=TOTAL_SERVICE %>" type="text" tabindex="1" maxlength="22" class="auto" size="10"/>
<label class="unit">yrs.</label> 
<input class="transparent" size="4">
<label>Age <span>*</span></label>
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
</script></div>
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly"/>
<label>Gender</label>
	<select	id="<%=SEX_ID %>" name="<%=SEX_ID %>"	validate="Gender,metachar,no" tabindex="1">
	
		<option value="0">Select</option>
	
<%for(MasAdministrativeSex masSex : genderList){
	if(patient.getSex().getId().equals(masSex.getId())){ %>	
	<option value="<%=patient.getSex().getId()%>" selected="selected"><%=patient.getSex().getAdministrativeSexName()%></option>
	<%}else{ %>	
	<option value="<%=masSex.getId() %>"><%=masSex.getAdministrativeSexName() %></option>

	<%}
			}%>
				
</select>

</div>
<div class="clear"></div>

<h4>CASUALTY DETAILS</h4>
<div class="Block">	

<label>Date of Arrival</label> 
<input type="text" id="<%=DATE_CASUALTY_ARRIVAL %>" name="<%=DATE_CASUALTY_ARRIVAL %>"	tabindex="1" value="" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE_CASUALTY_ARRIVAL%>,event)" />

<label>Time of Arrival</label>
<input  name="<%=TIME_CASUALTY_ARRIVAL %>" id="<%=TIME_CASUALTY_ARRIVAL %>" type="text" tabindex="1" maxlength="5" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTimeForSetup1(this.value,this.id);" /> 


<div class="clear"></div>

<label>Clinical Status</label>
<textarea rows="" cols="24"	name="<%=CLINICAL %>" id="<%=CLINICAL %>" onkeyup="chkLength(this,30);"></textarea>
	

<label>Diagnosis</label>
<input type="text" name="<%=DIAGNOSIS %>" id="<%=DIAGNOSIS %>"  value="" 	validate="Diagnosis,metachar,no"  maxlength="30" />
	

<div class="clear"></div>
<label>Condition <span>*</span></label> 
<select id="conditionId" name="<%=CONDITION %>" class="year" tabindex="1" validate="Condition,metachar,yes" onchange="displayStatusTest(),displayListDateTimeTest();">
	<option value="0">Select</option>
	<option value="Critical">Critical</option>
</select> 

<label>Status <span>*</span></label>

<div id="status1" style="display: none;">
<select name="<%=CONDITION_STATUS %>" class="" tabindex="1" >
	<option value="SIL">SIL</option>
	<option value="DIL">DIL</option>
</select>
<div class="clear"></div>
<label>List Date</label> 
<input id="listdateId" type="text"	 name="<%=LIST_DATE %>" value="" tabindex="1" 	validate="List Date,date,no" readonly="readonly"> 
	
<label>List Time</label> 
<input id="listtimeId" type="text" 	name="<%=LIST_TIME %>" value="" tabindex="1"  validate="List Time,string,no"	readonly="readonly">
	
</div>

<script type="text/javascript">

function displayStatusTest(){
	var condition = document.casualtyAirEvacuation.<%=CONDITION %>.value;
	if(condition == "Critical"){
		document.getElementById('status1').style.display = "inline";

	}else{
		document.getElementById('status1').style.display = "none";

	}
}
	function displayListDateTimeTest(){
	//var list = document.getElementById('status3').value;
	var cond = document.getElementById('conditionId').value;
	date = '<%=currentDate%>';
	time = '<%=currentTime%>';
	if(cond == "Critical"){
		document.getElementById('listdateId').value = date;
		document.getElementById('listtimeId').value = time;
	}else{
		document.getElementById('listdateId').value = "";
		document.getElementById('listtimeId').value = "";
	}
	
}
	function populateListDateTimeTest(){
	document.getElementById('listdateId').value = date;
		document.getElementById('listtimeId').value = time;
	}		
</script>

<div class="clear"></div>
<label> Casualty </label> 
<select name="<%=CASUALTY %>"  id="casualty" >
<option value="Uncloading">Uncloading</option>
<option value="Loading">Loading</option>
</select>
<label>Date</label> 
<input type="text" id="<%=DATE_CASUALTY %>" name="<%=DATE_CASUALTY %>"	tabindex="1" value="" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE_CASUALTY%>,event)" />

<label class="medium">Time</label>
<input  name="<%=TIME_CASUALTY %>" id="<%=TIME_CASUALTY %>" type="text" tabindex="1" maxlength="5" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTimeForSetup1(this.value,this.id);" class="calDate"/> 
<label class="unit2">Hrs.</label>
<div class="clear"></div>

<label class="large">Diffculties Experience during flight and emplaning</label>
<textarea rows="" cols="115"	name="<%=DIFFCULTIES %>" id="<%=DIFFCULTIES %>" class="auto" onkeyup="chkLength(this,50);"></textarea>

<div class="clear"></div>
	
<label class="large">Disposal of Casualty Belongings</label>
<textarea rows="" class="auto" cols="115" name="disposal" onkeyup="chkLength(this,30);"></textarea>
<%--<input type="text" name="<%=DISPOSAL %>" id="<%=DISPOSAL %>"  value="" 	validate="Diagnosis,string,no"  maxlength="30" class="auto" size="79"/> --%>
	
<div class="clear"></div>

<label class="large">Remarks</label>
<textarea rows="" cols="115"	name="<%=REMARKS %>" id="<%=REMARKS %>" class="auto" onkeyup="chkLength(this,100);"></textarea>

</div>
<div class="clear paddingTop15"></div>

<h4>AIRCRAFT DETAILS</h4>
<div class="Block">	
<label> Aircraft Type </label> 
<select name="<%=AIRCRAFT_TYPE_ID %>" id="<%=AIRCRAFT_TYPE_ID %>"  tabindex="1"	>
<option value="0">Select</option>
	<% 	 		for(MasAircraftType masAircraftType : aircraftTypeList){	
			%>
		<option value="<%=masAircraftType.getId() %>"><%=masAircraftType.getAircraftTypeName() %></option>
	<%}%>
</select>

<label> Case Sitting </label> 
<input type="radio" name="<%=RADIO_FOR_TABLE %>" id="<%=RADIO_FOR_TABLE %>"  value="s"/>
	
<label> Case Lying </label> 
<input type="radio" name="<%=RADIO_FOR_TABLE %>" id="<%=RADIO_FOR_TABLE %>"  value="l"/>
	
<div class="clear"></div>
	
<label>Total Duration including Station</label>
<input type="text" name="<%=TOTAL_DURATION %>" id="<%=TOTAL_DURATION%>"  value="" 	validate="Total Duration,int,no"  maxlength="30" />

<label>Duration Holding</label>
<input type="text" name="<%=DURATION_HOLDING %>" id="<%=DURATION_HOLDING %>"  value="" 	validate="Duration Holding,int,no"  maxlength="30" />

<label>Enroute Holding Unit</label>
<select name="<%=ENROUTE_HOLDING_UNIT %>" id="<%=ENROUTE_HOLDING_UNIT %>"  tabindex="1"	>
<option value="0">Select</option>
	<%		for(MasUnit enrouteHoldingUnit : unitList){		%>
		<option value="<%=enrouteHoldingUnit.getId() %>"><%=enrouteHoldingUnit.getUnitName() %></option>
	<% 	} %>
</select> 
</div>
<%//} 
	}else if(aviCasualtyAirEvacuationList.size() ==0 && patientList.size() ==0){ 


%>

<div class="clear paddingTop15"></div>
<div class="Block">
<input type="hidden" value="" name="hinId">
<input type="hidden" value="" name="avAccidentId">
<label>Date</label> 
<input type="text" id="<%=DATE %>" name="<%=DATE %>"	tabindex="1" value="<%=currentDate %>" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="7" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE%>,event)" />

<label>Time</label>
<input  name="<%=TIME %>" id="<%=TIME %>" type="text" tabindex="1" maxlength="11" value="<%=time %>" 
onKeyUp="mask(this.value,this,'2',':');" maxlength="5"
onBlur="checkTime('casualtyAirEvacuation','<%=TIME%>');"/> 
<label class="unit">Hrs.</label>

<div class="clear"></div>
<label> First Name <span>*</span></label> 
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"	title="First Name of the Patient"	validate="Patient First Name,name,yes" MAXLENGTH="30" />

<label>Middle Name</label> 
<input type="text" id="pMiddleNameId"	name="<%=P_MIDDLE_NAME%>" value="" tabindex="1"	validate="Patient Middle Name,name,no" MAXLENGTH="30" /> 

<label>Last Name</label> 
<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"	value="" validate="Patient Last Name,name,no" MAXLENGTH="30"	tabindex="1" /> 

<div class="clear"></div>
<label> Rank</label> 
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1"  class="auto" size="5">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	}%>
</select>
<label>Unit</label> 
<select name="<%=UNIT_ID %>"  id="<%=UNIT_ID %>">
<option value="0">Select</option>
	<%for(MasUnit masUnit : unitList){	%>
	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		
		}%>
</select>

<label>Branch/Trade</label> 

<select name="<%=TRADE_ID %>"  id="<%=TRADE_ID %>">
<option value="0">Select</option>
	<%	for(MasTrade masTrade : tradeList){%>
	
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>
	<%		
		}%>
</select>
<div class="clear"></div>
<label>Total Service</label>

<input  name="<%=TOTAL_SERVICE %>" id="<%=TOTAL_SERVICE %>" type="text" tabindex="1" maxlength="22" class="auto" size="10"/>
<label class="unit">yrs.</label> 
<input class="transparent" size="4">
<label>Age <span>*</span></label>
<select id="srAgeId"	name="<%=SR_AGE%>" validate="Age of Service Person,string,yes"	tabindex="1" class="small"	onchange="fillPatientName(this);">
	<option value="">Select</option>
	<%
				for(int age1 = 16;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly"/>
<label> Gender <span>*</span></label>
<select name="<%=SR_SEX %>" id="<%=SR_SEX %>" validate="Service Person Gender,metachar,yes" tabindex="1">
<option value="0">Select</option>
	<%
		   	 		for(MasAdministrativeSex masAdministrativeSex : genderList){
		   	 			
			%>
		<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<% 	 	} %>
</select> 

</div>
<div class="clear"></div>

<h4>CASUALTY DETAILS</h4>
<div class="Block">	

<label>Date of Arrival</label> 
<input type="text" id="<%=DATE_CASUALTY_ARRIVAL %>" name="<%=DATE_CASUALTY_ARRIVAL %>"	tabindex="1" value="" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE_CASUALTY_ARRIVAL%>,event)" />

<label>Time of Arrival</label>
<input  name="<%=TIME_CASUALTY_ARRIVAL %>" id="<%=TIME_CASUALTY_ARRIVAL %>" type="text" tabindex="1" maxlength="5" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTimeForSetup1(this.value,this.id);" /> 


<div class="clear"></div>

<label>Clinical Status</label>
<textarea rows="" cols="24"	name="<%=CLINICAL %>" id="<%=CLINICAL %>" class="auto" onkeyup="chkLength(this,30);"></textarea>
	

<label>Diagnosis</label>
<input type="text" name="<%=DIAGNOSIS %>" id="<%=DIAGNOSIS %>"  value="" 	validate="Diagnosis,metachar,no"  maxlength="30" />
	

<div class="clear"></div>
<label>Condition <span>*</span></label> 
<select id="conditionId" name="<%=CONDITION %>" class="year" tabindex="1" validate="Condition,metachar,yes" onchange="displayStatusTest(),displayListDateTimeTest();">
	<option value="0">Select</option>
	<option value="Critical">Critical</option>
</select> 

<label>Status <span>*</span></label>

<div id="status1" style="display: none;">
<select name="<%=CONDITION_STATUS %>" class="" tabindex="1" >
	<option value="SIL">SIL</option>
	<option value="DIL">DIL</option>
</select>
<div class="clear"></div>
<label>List Date</label> 
<input id="listdateId" type="text"	 name="<%=LIST_DATE %>" value="" tabindex="1" 	validate="List Date,date,no" readonly="readonly"> 
	
<label>List Time</label> 
<input id="listtimeId" type="text" 	name="<%=LIST_TIME %>" value="" tabindex="1"  validate="List Time,string,no"	readonly="readonly">
	
</div>

<script type="text/javascript">

function displayStatusTest(){
	var condition = document.casualtyAirEvacuation.<%=CONDITION %>.value;
	if(condition == "Critical"){
		document.getElementById('status1').style.display = "inline";

	}else{
		document.getElementById('status1').style.display = "none";

	}
}
	function displayListDateTimeTest(){
	//var list = document.getElementById('status3').value;
	var cond = document.getElementById('conditionId').value;
	date = '<%=currentDate%>';
	time = '<%=currentTime%>';
	if(cond == "Critical"){
		document.getElementById('listdateId').value = date;
		document.getElementById('listtimeId').value = time;
	}else{
		document.getElementById('listdateId').value = "";
		document.getElementById('listtimeId').value = "";
	}
	
}
	function populateListDateTimeTest(){
	document.getElementById('listdateId').value = date;
		document.getElementById('listtimeId').value = time;
	}		
</script>

<div class="clear"></div>
<label> Casualty </label> 
<select name="<%=CASUALTY %>"  id="casualty">
<option value="Uncloading">Uncloading</option>
<option value="Loading">Loading</option>
</select>
<label>Date</label> 
<input type="text" id="<%=DATE_CASUALTY %>" name="<%=DATE_CASUALTY %>"	tabindex="1" value="" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE_CASUALTY%>,event)" />

<label>Time</label>
<input  name="<%=TIME_CASUALTY %>" id="<%=TIME_CASUALTY %>" type="text" tabindex="1" maxlength="5" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTimeForSetup1(this.value,this.id);" /> 
<label class="unit">Hrs.</label>
<div class="clear"></div>

<label class="large">Diffculties Experience during flight and emplaning</label>
<textarea rows="" cols="55"	name="<%=DIFFCULTIES %>" id="<%=DIFFCULTIES %>" class="auto" onkeyup="chkLength(this,50);"></textarea>

<div class="clear"></div>
	
<label class="large">Disposal of Casualty Belongings</label>
<textarea rows="" class="auto" cols="57" name="disposal"onkeyup="chkLength(this,30);"></textarea>
<%--<input type="text" name="<%=DISPOSAL %>" id="<%=DISPOSAL %>"  value="" 	validate="Diagnosis,string,no"  maxlength="30" class="auto" size="79"/> --%>
	
<div class="clear"></div>

<label class="large">Remarks</label>
<textarea rows="" cols="55"	name="<%=REMARKS %>" id="<%=REMARKS %>" class="auto" onkeyup="chkLength(this,100);"></textarea>

</div>
<div class="clear paddingTop15"></div>

<h4>AIRCRAFT DETAILS</h4>
<div class="Block">	
<label> Aircraft Type </label> 
<select name="<%=AIRCRAFT_TYPE_ID %>" id="<%=AIRCRAFT_TYPE_ID %>"  tabindex="1"	>
<option value="0">Select</option>
	<% 	 		for(MasAircraftType masAircraftType : aircraftTypeList){	
			%>
		<option value="<%=masAircraftType.getId() %>"><%=masAircraftType.getAircraftTypeName() %></option>
	<%}%>
</select>

<label> Case Sitting </label> 
<input type="radio" name="<%=RADIO_FOR_TABLE %>" id="<%=RADIO_FOR_TABLE %>"  value="s"/>
	
<label> Case Lying </label> 
<input type="radio" name="<%=RADIO_FOR_TABLE %>" id="<%=RADIO_FOR_TABLE %>"  value="l"/>
	
<div class="clear"></div>
	
<label>Total Duration including Station</label>
<input type="text" name="<%=TOTAL_DURATION %>" id="<%=TOTAL_DURATION%>"  value="" 	validate="Total Duration,int,no"  maxlength="30" />

<label>Duration Holding</label>
<input type="text" name="<%=DURATION_HOLDING %>" id="<%=DURATION_HOLDING %>"  value="" 	k="Duration Holding,int,no"  maxlength="30" />

<label>Enroute Holding Unit</label>
<select name="<%=ENROUTE_HOLDING_UNIT %>" id="<%=ENROUTE_HOLDING_UNIT %>"  tabindex="1"	>
<option value="0">Select</option>
	<%		for(MasUnit enrouteHoldingUnit : unitList){		%>
		<option value="<%=enrouteHoldingUnit.getId() %>"><%=enrouteHoldingUnit.getUnitName() %></option>
	<% 	} %>
</select> 
</div>
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
}

</script>