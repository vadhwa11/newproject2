<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is ajax response jsp for Service person name.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasReporting"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasStation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Patient> list = new ArrayList<Patient>();
	List<MasTrade> tradeList = new ArrayList<MasTrade>();
	List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<Object[]> unitList = new ArrayList<Object[]>();
	List<MasSection> sectionList = new ArrayList<MasSection>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	List<MasReporting> reportingList = new ArrayList<MasReporting>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<MasStation> stationList = new ArrayList<MasStation>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	List<MasCommand> commandList = new ArrayList<MasCommand>();
	List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
	List<MasReligion> religionList = new ArrayList<MasReligion>();
	int serviceTypeId = 0;
	int serviceStatusId = 0;
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("list") != null){
		list = (List<Patient>)map.get("list");
	}
	if(map.get("rankList") != null){
		rankList= (List<MasRank>)map.get("rankList");
	}
	if(map.get("unitList") != null){
		unitList= (List<Object[]>)map.get("unitList");
	}
	if(map.get("tradeList") != null){
		tradeList = (List<MasTrade>)map.get("tradeList");
	}
	if(map.get("recordOfficeAddressList") != null){
		recordOfficeAddressList = (List<MasRecordOfficeAddress>)map.get("recordOfficeAddressList");
	}
	if(map.get("sectionList") != null){
		sectionList = (List<MasSection>)map.get("sectionList");
	}
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (List<MasBloodGroup>)map.get("bloodGroupList");
	}
	if(map.get("reportingList") != null){
		reportingList = (List<MasReporting>)map.get("reportingList");
	}
	if(map.get("sexList") != null){
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	}
	if(map.get("serviceTypeId") != null){
		serviceTypeId = (Integer)map.get("serviceTypeId");
	}
	if(map.get("serviceStatusId") != null){
		serviceStatusId = (Integer)map.get("serviceStatusId");
	}
	if(map.get("stationList") != null){
		stationList = (List<MasStation>)map.get("stationList");
	}
	if(map.get("employeeList") != null){
		doctorList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("commandList") != null){
		commandList = (List<MasCommand>)map.get("commandList");
	}
	if(map.get("maritalStatusList") != null){
		maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
	}
	if(map.get("religionList") != null){
		religionList = (List<MasReligion>)map.get("religionList");
	}
	String servPersonFName = "";
	String servPersonMName = "";
	String servPersonLName = "";
	
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String administrativeSexMaleCode = properties.getProperty("administrativeSexMaleCode");
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	int regHinId = 0;
	String selfHinNo = "";
	int lastVisitNo = 0;
	if(list.size() > 0){
		Patient patient = new Patient();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			patient = (Patient) iterator.next();
			if(patient.getRelation().getId() == 8){
				regHinId = patient.getId();
				selfHinNo = patient.getHinNo();
				
				if(patient.getCurrentVisitNo() != null){
					lastVisitNo = patient.getCurrentVisitNo();
				}
			}
		}

	servPersonFName = patient.getSFirstName();
	if(patient.getSMiddleName() != null)
		servPersonMName = patient.getSMiddleName();
	if(patient.getSLastName() != null)
		servPersonLName = patient.getSLastName();
	
	%>		


<div id="rankDivId">
<label><span>*</span>  Rank</label>
<label	class="value"><%= patient.getRank().getRankName()%></label>
<input	type="hidden" name="<%=RANK_ID %>"	value="<%=patient.getRank().getId() %>">
</div>
<label><span>*</span>  First Name</label>
<input id="sFNameId" type="text" name="<%=S_FIRST_NAME %>"	value="<%=servPersonFName %>" title="First Name of Service Person"	MAXLENGTH="15" readonly="readonly" />
<script type="text/javascript">
document.getElementById('pFirstNameId').value='<%=servPersonFName %>';
document.getElementById('pMiddleNameId').value='<%=servPersonMName %>';
document.getElementById('pLastNameId').value='<%=servPersonLName %>';
</script>
<label>Middle Name</label>
<input id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>"	value="<%=servPersonMName %>"	validate="Middle Name of Service Person,alphaspace,no" MAXLENGTH="15"	readonly="readonly" />
<div class="clear"></div>
<label>Last Name</label>
<input id="sLNameId" type="text" name="<%=S_LAST_NAME %>"	value="<%=servPersonLName %>"	validate="Last Name of Service Person,alphaspace,no" MAXLENGTH="15"	readonly="readonly" />

<%
if(patient.getSrSex() != null){
%>
<label >Sex</label>
<label class="value"><%=patient.getSrSex().getAdministrativeSexName() %></label>
<input 	type="hidden" name="<%=SR_SEX %>"	value="<%=patient.getSrSex().getId() %>">
<script>
document.getElementById('gender').value='<%=patient.getSrSex().getId() %>';
</script>
<%}else{ %>
<label ><span>*</span> Sex</label>
<select name="<%=SR_SEX %>" id="srSexId" validate="" tabindex="1" onchange="fillPatientName(this);">
    <%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
		   	 			if(masAdministrativeSex.getAdministrativeSexCode().equals(administrativeSexMaleCode)){
			%>
      <option value="<%=masAdministrativeSex.getId() %>" selected="selected"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
      <%		}else{ %>
      <option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
      <%
					}
		   	 	} %>
</select>

<%} %>

<label >DOB</label>
<%
	if(patient.getSrDob() != null){
%>
<label	class="value"><%= HMSUtil.convertDateToStringWithoutTime(patient.getSrDob())%></label>
<input id="srdobId" type="hidden" name="<%=SR_DOB %>"	value="<%=HMSUtil.convertDateToStringWithoutTime(patient.getSrDob()) %>">
<script>
document.getElementById('dobId').value='<%=HMSUtil.convertDateToStringWithoutTime(patient.getSrDob()) %>';
</script>
<%}else{ %>
<input type="text" id="srdobId" name="<%=SR_DOB %>" tabindex="1" value=""  readonly="readonly" validate="Date of Birth,date,no"  MAXLENGTH="30" class="calDate" onblur="calculateSRAgeInAjax();fillPatientName(this);"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender"onClick="setdate('',document.registration.<%=SR_DOB%>,event)" />

<%} %>
<div class="clear"></div>
<label ><span>*</span> Age</label>
<%
	if(patient.getSrAge() != null){
		String age=patient.getSrAge().substring(0,patient.getSrAge().indexOf(" "));
		String ageunit = patient.getSrAge().substring(patient.getSrAge().indexOf(" ")+1);
%>
<label	class="value"><%= patient.getSrAge()%></label>
<input	id="srAgeId" type="hidden" name="<%=SR_AGE %>"	value="<%=age %>">
<input	id="srAgeUnitId" type="hidden" name="<%=SR_AGE_UNIT %>"	value="<%=ageunit %>">
<script>
document.getElementById('ageId').value='<%=age %>';
document.getElementById('ageUnitId').value='<%=ageunit %>';
</script>
<%}else{ %>
<div id="srAgeDiv" style="display: block;"> 
<!--<select id="srAgeId" name="<%=SR_AGE%>" validate="Age of Service Person,string,yes" tabindex="1" class="smallest" onchange="checkForSRDOB();fillPatientName(this);">
          -->
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age of Service Person,string,yes" tabindex="1" class="small" onchange="fillPatientName(this);">
          <option value="">Select</option>
          <%
				for(int age1 = 16;age1<=100;age1++){
				%>
          <option value="<%=age1%>"><%= age1%></option>
          <%}%>
</select>
  
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly">
<!--<select id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" validate="AgeUnit,string,no" tabindex="1" class="small" onchange="checkForSRDOB();fillPatientName(this);">
          <option selected="selected" value="Years">Years</option>
          <option value="Months">Months</option>
          <option value="Days">Days</option>
</select>
  --><input type="hidden" id="idForSrAge" value="">  
</div>


<%} %>

 <label> Marital Status</label> 
 <select name="srMaritalStatus" id="srmrstatus" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
	
	%>
      <option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
      <%}%>
    </select> 
   <script>
   <%
   if(patient.getSrMaritalStatus() != null){
   %>
document.getElementById('srmrstatus').value='<%=patient.getSrMaritalStatus().getId()%>';
   <%}%>
   </script>
 <%--
	if(patient.getSrMaritalStatus() != null){
%>
<label	class="value"><%= patient.getSrMaritalStatus().getMaritalStatusName()%></label>
<input	type="hidden" name="srMaritalStatus"	value="<%=patient.getSrMaritalStatus().getId() %>">
<%}else{ %>
<select name="srMaritalStatus" id="srmrstatus" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
	
	%>
      <option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
      <%}%>
    </select> 
    <%} --%>
<%
	if(patient.getCommand() != null){
%>
<label >Command</label>
<label	class="value"><%= patient.getCommand().getCommandName()%></label>
<input	type="hidden" name="<%=COMMAND %>"	value="<%=patient.getCommand().getId() %>">
<%}else{ %>
<label > Command</label>
<select id="commandId" name="<%=COMMAND %>"  validate="Command,stirng,no" tabindex="1" onchange="populateStation('registration')" >
		<option value="0">Select</option>
		<%
			if(commandList.size() > 0){
				for(MasCommand command : commandList){
		%>
		<option value="<%= command.getId() %>"><%=command.getCommandName() %></option>
		<%
				}
				} %>
				<option value="other">Other</option>
</select>
<div id="addCmdDiv" style="display: none;">
<label><span>*</span> Command Name</label>
<input type="text" id="addCmd" name="commandName" value="" tabindex="1" maxlength="30"/>
</div><%} %>
<div class="clear"></div>
<div id="tradeDivId">
<label>Station</label>
<%
		if(patient.getStation() != null  && !(patient.getStation().equals(""))){
		%>
<label class="value"><%= patient.getStation()%></label>
<input type="hidden" name="<%=STATION %>"
	value="<%=patient.getStation() %>">
<%}else{ %>
<select id="stationId" name="<%=STATION %>" tabindex="1"  onchange="populateUnit('registration');displayOtherStn(this.value)">
	<option value="">Select</option>
 <%
	 for(MasStation masStation : stationList){
		
	 %>
		<option value="<%=masStation.getStationName()%>"><%=masStation.getStationName()%></option>
	 
	<%}
	%>
	<option value="other">Other</option>

</select> 
<div id="addStnDiv" style="display: none;">
<label >Station Name</label>
<input type="text"  id="addStn" name="stationName"  tabindex="1" value="" maxlength="30"/>
</div>
<%} %>
	

 <%
		if(patient.getUnit() != null){
		%> 
		<label>Unit</label>
		<label class="value"><%= patient.getUnit().getUnitName()%></label>
<input type="hidden" name="<%=UNIT_ID %>" 	value="<%=patient.getUnit().getId() %>">
<%--	<label> Unit Address</label>
	<%if(patient.getUnit().getUnitAddress() != null){ %>
	<label class="value"><%= patient.getUnit().getUnitAddress()%></label>
	<%} %> --%>
<%}else{ %>
<label><span>*</span>  Unit</label>
	<select id="unitId" name="<%=UNIT_ID %>" tabindex="1" validate="Unit,string,yes"  >
<option value="0">Select</option>
	 <%
					 for(Object[] masUnit : unitList){
					 %>
						<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
					 
					<%
						
					}%>	
<option value="other">Other</option>
</select>
<div id="addUnitDiv" style="display: none;">
<label ><span>*</span> Unit Name</label>
<input id="newUnitId" type="text" name="<%=UNIT_NAME%>" value=""   tabindex="1" validate="Unit Name,string,no" maxlength="30" tabindex="1"/>
<label > Unit Address</label>
<input id="newUnitAddressId" type="text" name="<%=UNIT_ADDRESS %>" value=""   validate="Unit Address,string,no" maxlength="50" tabindex="1"/>
<!--<label >Is Local Unit</label>	
<input type="checkbox" id="localUnit" name="<%=LOCAL_UNIT %>" value="y" class="radio" tabindex="1" />
			
--></div>
<%} %>

<script type="text/javascript">
//document.getElementById('UnitHideDiv').style.display = 'none';
//document.getElementById('unitId').setAttribute('validate','Unit,string,no');
</script>
	
<label>Section</label>
<select id="sectionId" name="<%=SECTION_ID%>"  validate="Section,string,no" tabindex="1"  >
			<option value="0">Select</option>
	<%
	 for(MasSection masSection : sectionList){
		
	 %>
		<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>
	 
	<%}
	%>
		<option value="other">Other</option>
</select>
 <script>
   <%
   if(patient.getSection() != null){
   %>
document.getElementById('sectionId').value='<%=patient.getSection().getId()%>';
   <%}%>
   </script>
<%--
	if(patient.getSection() != null){
%>
<label	class="value"><%= patient.getSection().getSectionName()%></label>
<input	type="hidden" name="<%=SECTION_ID %>"	value="<%=patient.getSection().getId() %>" />
<%}else{ %>
<select id="sectionId" name="<%=SECTION_ID%>"  validate="Section,string,no" tabindex="1"  >
			<option value="0">Select</option>
	<%
	 for(MasSection masSection : sectionList){
		
	 %>
		<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>
	 
	<%}
	%>
		<option value="other">Other</option>
	</select>
<%} 
--%>

<div id="addSecDiv" style="display: none;">
<label>Section Name</label>
<input type="text"  id="addSec" name="sectionName"  style="display: none;" tabindex="1" value="" maxlength="30"/>
</div>	
<div class="clear"></div>	
	<label>Trade/Branch</label>
	<%
			if(patient.getTrade() != null){
		%> <label class="value"><%= patient.getTrade().getTradeName()%></label>
<input type="hidden" name="<%=TRADE_ID %>"
	value="<%=patient.getTrade().getId() %>"> <%
			}else{
		%> <select id="tradeId" name="<%=TRADE_ID%>"
	validate="Trade,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasTrade masTrade : tradeList) 
				{
			 	
			%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%
			}%>
		<option value="other">Other</option>
</select> 
<div id="addTradeDiv" style="display: none;">
<label>Trade/Branch Name</label>
<input id="newTradeId" type="text" name="<%=TRADE_NAME%>" value=""  tabindex="1"  validate="Trade Name,string,no" maxlength="30" tabindex="1"/>
<div class="clear"></div>
</div>	
<%} %>
<!--  
<div class="Clear"></div>
<label>Formation</label> <%
		if(patient.getFormation() != null && !(patient.getFormation().equals(""))){
		%> <label class="value"><%= patient.getFormation()%></label> <input
	type="hidden" name="<%=FORMATION_ID %>"
	value="<%=patient.getFormation() %>"> <%}else{ %> <input
	id="formation" type="text" name="<%=FORMATION_ID %>" value=""
	validate="Formation,alphaspace,no" maxlength="30" tabindex="1">
<%} %>

-->
	
<label> DOE/DOC</label>	

<%
	if(patient.getCommissionDate() != null){
%>
<label	class="value"><%= HMSUtil.convertDateToStringWithoutTime(patient.getCommissionDate())%></label>
<input id="commissionDate" type="hidden" name="commissionDate"	value="<%=HMSUtil.convertDateToStringWithoutTime(patient.getCommissionDate()) %>">

<%}else{ %>
<input type="text" id="commissionDateId" name="commissionDate" tabindex="1" value="" readonly="readonly" validate="commission Date,date,no"  MAXLENGTH="30" class="calDate" onblur="if(this.value!=''){calculateTotalService(this.value);}"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender" onClick="setdate('',document.registration.commissionDate,event)" />

	<%} %>
 <label>Total Service</label> <%
		if(patient.getServiceYears() != null  && !(patient.getServiceYears().equals(""))){
		%>
<input id="totalServYrs" type="hidden" name="" value=""	validate="Total Service,float,no" maxlength="6" tabindex="1"  />
<input	type="hidden" name="<%=SERVICE_YEARS %>"	value="<%=patient.getServiceYears() %>">
<!--<select id="totalServ"	name="<%=TOTAL_SERVICE%>" validate="Total Service ,string,no" tabindex="1"	class="small" onchange="checkForDateForCommEnrl();checkAgeAndService();">
	-->
	<select id="totalServ"	name="<%=TOTAL_SERVICE%>" validate="Total Service ,string,no" tabindex="1"	class="small" onchange="checkAgeAndService();">
	<option value="0">Select</option>
	<%
						for(int age1=1;age1<=100;age1++){
							
							if(patient.getServiceYears()==age1){
						%>
	<option value="<%=age1%>" selected="selected"><%= age1%></option>
	<%}else{%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}}%>
</select>

<select id="totalServUnit" name="<%=TOTAL_SERVICE_PERIOD %>" 
	validate="Service Period,string,no" tabindex="1" class="smallest" >
	<option value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select>
<%}else{ %>
<select id="totalServ" name="<%=TOTAL_SERVICE%>" validate="Total Service,float,no"  onchange="checkAgeAndService();"
	tabindex="1" class="small">
	<option value="0">Select</option>
	<%
						for(int age1=1;age1<=100;age1++){
						%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select>

<select id="totalServUnit" name="<%=TOTAL_SERVICE_PERIOD %>"
	validate="Service Period,string,no" tabindex="1" class="smallest" >
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select>
<%} %>

<div class="clear"></div>
<label > Rcrd Off Add</label>
<%
	if(patient.getRecordOfficeAddress()!= null){
%>
<label class="value"><%= patient.getRecordOfficeAddress().getAddress() %></label>
<input type="hidden" id="recordOffId" name="<%=RECORD_OFFICE_ADDRESS_ID %>" value="<%= patient.getRecordOfficeAddress().getId() %>"/>
<%}else{ %>
<select id="recordOffId" name="<%=RECORD_OFFICE_ADDRESS_ID %>" validate="RecordOff Addrs,string,no"  tabindex="1">
<option value="0">Select</option>
<%
for (MasRecordOfficeAddress masRecordOfficeAddress : recordOfficeAddressList) 
{
%>
<option value="<%= masRecordOfficeAddress.getId() %>"><%= masRecordOfficeAddress.getAddress() %></option>
<%} %>
</select>
<%} %>
<label > Religion</label>
<%
	if(patient.getReligion()!= null){
%>
<label class="value"><%= patient.getReligion().getReligionName() %></label>
<input type="hidden" id="religionId" name="<%=RELIGION_ID %>" value="<%= patient.getReligion().getId() %>"/>

<%}else{ %>
<select id="religionId" name="<%=RELIGION_ID %>" validate="Religion,string,no"  tabindex="1">
<option value="0">Select</option>
<%
for (MasReligion masReligion : religionList) 
{
%>
<option value="<%= masReligion.getId() %>"><%= masReligion.getReligionName() %></option>
<%} %>
</select>
<%} %>
<label >Blood Group</label>
<select id="serBldGroupId" name="<%=SERV_BLD_GROUP %>"  validate="Blood Group,string,no" tabindex="1"   onchange="fillPatientName(this);" >
      <option value="0">Select</option>
      <%
	 for(MasBloodGroup masBloodGroup : bloodGroupList){
	
	%>
      <option value="<%=masBloodGroup.getId()%>"><%=masBloodGroup.getBloodGroupName()%></option>
      <%}%>
</select> 
<div class="clear"></div>
 <script>
   <%
   if(patient.getSrBloodGroup() != null){
   %>
document.getElementById('serBldGroupId').value='<%=patient.getSrBloodGroup().getId()%>';
   <%}%>
   </script>
<%--
	if(patient.getSrBloodGroup() != null){
%>
<label class="value"><%=patient.getSrBloodGroup().getBloodGroupName() %></label>
<input	type="hidden" name="<%=SERV_BLD_GROUP %>"	value="<%=patient.getSrBloodGroup().getId() %>">
<%}else{ %>
<select id="serBldGroupId" name="<%=SERV_BLD_GROUP %>"  validate="Blood Group,string,no" tabindex="1"   onchange="fillPatientName(this);" >
      <option value="0">Select</option>
      <%
	 for(MasBloodGroup masBloodGroup : bloodGroupList){
	
	%>
      <option value="<%=masBloodGroup.getId()%>"><%=masBloodGroup.getBloodGroupName()%></option>
      <%}%>
 </select> 
    <%} --%>
    
   <div id="exServiceId"></div>

<label >Telephone No.</label>
<%
	if(patient.getPhoneNumber() != null){
%>
<input id="phoneNo" name="<%=TELEPHONE_NO %>" type="text" value="<%= patient.getPhoneNumber() %>" tabindex="1" />
<%}else{ %>
<input id="mobileNo" name="<%=TELEPHONE_NO %>" type="text" value="" tabindex="1" />
<%} %>

<label >Mobile No.</label>
<%
if(patient.getMobileNumber() != null){
%>
<input id="" name="<%=MOBILE_NO %>" type="text" value="<%= patient.getMobileNumber() %>" tabindex="1" />
<%}else{ %>
<input id="" name="<%=MOBILE_NO %>" type="text" value="" tabindex="1" />
<%} %>
<label>AFNET No.</label> 
<%
if(patient.getAfnetNo()!= null){
%>
<input id="afnetNo" name="afnetNo" type="text" value="<%= patient.getAfnetNo() %>" tabindex="1" maxlength="15" />
<%}else{ %>
<input id="afnetNo" name="afnetNo" type="text" tabindex="1" maxlength="15" />
<%} %>
<div class="clear"></div>
<label> Reporting For</label>
<select id="reportinForId" name="<%=REPORTING_FOR %>"  validate="Reporting For,string,yes" tabindex="1"   onchange="displayCategotries(this.value);" >
      <option value="0">Select</option>
    	<%
	 for(MasReporting masReporting : reportingList){
		
	 %>
		<option value="<%=masReporting.getId()%>"><%=masReporting.getReportingName()%></option>
	 
	<%}
	%>
 </select> 

 <div id="medExamCategoryDiv" style="display: none;">
 <label><span>*</span> Exam Category</label>
<select id="medExamCategory" name="medExamCategory"  tabindex="1">
<option  value="">Select</option>
<option value="Annual Medical Exam(AFMSF-3B)">Annual Medical Exam(AFMSF-3B)</option>
<option value="Med. Exam On Release/Discharge(AFMSF-18)">Med. Exam On Release/Discharge(AFMSF-18)</option>
<option value="Primary/Extension Med. Exam(AFMSF-2A)">Primary/Extension Med. Exam(AFMSF-2A)</option>
<option value="Prior To Proceedings Abroad Med. Exam(AFMSF-3B)">Prior To Proceedings Abroad Med. Exam(AFMSF-3B)</option>
<option value="High Altitude Med. Exam(AFMSF-3B)">High Altitude Med. Exam(AFMSF-3B)</option>
</select>
</div>

<div id="medBoardCategoryDiv" style="display: none;">
 <label><span>*</span> Board Category</label>
<select id="medBoardCategory" name="medBoardCategory"  tabindex="1">
<option  value="">Select</option>
<option value="Initial Medical Board AFMSF 15">Initial Medical Board AFMSF 15</option>
<option value="Medical Board Review AFMSF 15">Medical Board Review AFMSF 15</option>
<option value="Medical Board Rel/Invalidment AFMSF 16">Medical Board Rel/Invalidment AFMSF 16</option>
</select>
</div>

 <label class="highlight"><span>*</span> Doctor</label>
<select id="srconsultingDocId" name="srConsultingDoc"  validate="Doctor,string,no" onchange="fillPatientName(this);submitProtoAjax('registration','registration?method=getTokenNoForDepartment');setDepartmentValue(this.value);" tabindex="1" >
      <option value="0">Select</option>
     <%
int doctorId=0;
for(MasEmployee masEmployee : doctorList){
	doctorId = masEmployee.getId();
	if(masEmployee.getEmpCategory() != null){
		if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
<%				}
	}
} %>
 </select> 
<div class="clear"></div>
<%
if(list.size() > 0){
%>
<label>Reg.HIN No</label>
<select id="regHinId" name="regHinId" tabindex="1"  onchange="if(this.value!='0'){displayPatientInfo(this.value)}else{getHin();}"> 
<option value="0">Select</option>
<%
	for(Patient hin:list){
String pMidName = "";
String pLastName = "";
		if(hin.getPMiddleName() != null){
			pMidName = hin.getPMiddleName() ;
		}
		if(hin.getPLastName() != null){
			pLastName = hin.getPLastName() ;
		}
		
%>
<option value="<%=hin.getId()%>"><%=hin.getHinNo()+"-"+hin.getPFirstName()+" "+pMidName+" "+pLastName+" ("+hin.getRelation().getRelationName()+")" %></option>
<%} %>
</select>

<%} %>
<input type="hidden" id="selfRegHin" name="selfRegHin" value="<%= regHinId %>"> 
<input type="hidden" id="selfHinNo" name="selfHinNo" value="<%= selfHinNo %>"> 
</div>
<script>
<%
	if(regHinId != 0){
%>	
document.getElementById('hinNoDivId').innerHTML='';
	document.getElementById('hinNoId').value="";
<%	}

if(patient.getPrefix() != null){
%>

document.getElementById("prefix").value='<%=patient.getPrefix()%>';
<%}%>
document.getElementById("suffixId").value='<%=patient.getSuffix()%>';
</script>
<%
	
	}else{
%>
<div id="rankDivId"><label><span>*</span>  Rank</label> 
<select	id="rankId" name="<%=RANK_ID%>" validate="Rank,string,yes" tabindex="1">
	<option value="0">Select</option>
	<%
				for (MasRank masRank : rankList) 
				{
					if(serviceTypeId == masRank.getServiceType().getId() && masRank.getServiceStatus().getId() == serviceStatusId){
				%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}
					}%>
</select> 

</div>
<label><span>*</span>  First Name</label>
<input id="sFNameId" type="text" name="<%=S_FIRST_NAME %>" value=""
	title="First Name of Service Person"
	validate="First Name of Service Person,alphaspace,Yes" tabindex="1"
	MAXLENGTH="15" onblur="fillPatientName(this);" />

<label>Middle Name</label>
<input id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value=""
	validate="Middle Name of Service Person,alphaspace,no" MAXLENGTH="15"
	tabindex="1" onchange="fillPatientName(this);" />
<div class="clear"></div>
<label>Last Name</label>
<input id="sLNameId" type="text" name="<%=S_LAST_NAME %>" value=""
	validate="Last Name of Service Person,alphaspace,no" MAXLENGTH="15"
	tabindex="1" onchange="fillPatientName(this);" />

<label><span>*</span> Sex</label>
<select name="<%=SR_SEX %>" id="srSexId" validate="" tabindex="1" onchange="fillPatientName(this);">
    <%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
		   	 			if(masAdministrativeSex.getAdministrativeSexCode().equals(administrativeSexMaleCode)){
			%>
      <option value="<%=masAdministrativeSex.getId() %>" selected="selected"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
      <%		}else{ %>
      <option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
      <%
					}
		   	 	} %>
</select>


<label >DOB</label>
<input type="text" id="srdobId" name="<%=SR_DOB %>" tabindex="1" value="" readonly="readonly" validate="Date of Birth,date,no"  MAXLENGTH="30" class="calDate" onblur="calculateSRAgeInAjax();fillPatientName(this);"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender"onClick="setdate('',document.registration.<%=SR_DOB%>,event)" />

<div class="clear"></div>

<label ><span>*</span> Age</label>
<div id="srAgeDiv" style="display: block;"> 
<!--<select id="srAgeId" name="<%=SR_AGE%>" validate="Age of Service Person,string,yes" tabindex="1" class="smallest" onchange="checkForSRDOB();fillPatientName(this);">
          -->
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age of Service Person,string,yes" tabindex="1" class="small" onchange="fillPatientName(this);">
          <option value="">Select</option>
          <%
				for(int age1 = 16;age1<=100;age1++){
				%>
          <option value="<%=age1%>"><%= age1%></option>
          <%}%>
</select>
  <input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly">
   
<!--<select id="srAgeUnitId" name="<%=SR_AGE_UNIT %>" validate="AgeUnit,string,no" tabindex="1" class="small" onchange="checkForSRDOB();fillPatientName(this);">
          <option selected="selected" value="Years">Years</option>
          <option value="Months">Months</option>
          <option value="Days">Days</option>
</select>
       --><input type="hidden" id="idForSrAge" value="">   
</div><!-- End of ageDiv -->


 <label> Marital Status</label> 
<select name="srMaritalStatus" id="srmrstatus" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
	
	%>
      <option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
      <%}%>
    </select> 

<label> Command</label>
<select id="commandId" name="<%=COMMAND %>"  validate="Command,string,no" tabindex="1" onchange="populateStation('registration');displayOtherCmd(this.value)" >
	<option value="0">Select</option>
	<%
			if(commandList.size() > 0){
				for(MasCommand command : commandList){
		%>
		<option value="<%= command.getId() %>"><%=command.getCommandName() %></option>
		<%
				}
				} %>
				<option value="other">Other</option>
</select>
<div id="addCmdDiv" style="display: none;">
<label><span>*</span> Command Name</label>
<input type="text" id="addCmd" name="commandName" value="" tabindex="1" maxlength="30"/>
</div>
<div class="clear"></div>
<div id="tradeDivId">

		
	<label>Station</label> 
	<select id="stationId" name="<%=STATION %>" onchange="populateUnit('registration');displayOtherStn(this.value)" tabindex="1">
	<option value="">Select</option>
 <%
	 for(MasStation masStation : stationList){
		
	 %>
		<option value="<%=masStation.getStationName()%>"><%=masStation.getStationName()%></option>
	 
	<%}
	%>
	<option value="other">Other</option>

</select> 
<div id="addStnDiv" style="display: none;">
<label >Station Name</label>
<input type="text"  id="addStn" name="stationName" tabindex="1" value="" maxlength="30"/>
</div>
	
	<label><span>*</span> Unit</label>
	<select id="unitId" name="<%=UNIT_ID %>" tabindex="1" validate="Unit,string,yes" onchange="displayOtherUnit(this.value)" >
<option value="0">Select</option>
			 <%
					 for(Object[] masUnit : unitList){
					 %>
						<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
					 
					<%
						
					}%>	
					
		<option value="other">Other</option>
</select>
<div id="addUnitDiv" style="display: none;">
<label ><span>*</span> Unit Name</label>
<input id="newUnitId" type="text" name="<%=UNIT_NAME%>" value=""  tabindex="1"  validate="Unit Name,string,no" maxlength="30" tabindex="1"/>
<label > Unit Address</label>
<input id="newUnitAddressId" type="text" name="<%=UNIT_ADDRESS %>" value=""   validate="Unit Address,string,no" maxlength="50" tabindex="1"/>
<!--<label >Is Local Unit</label>	
<input type="checkbox" id="localUnit" name="<%=LOCAL_UNIT %>" value="y" class="radio" tabindex="1" />
			
--></div>
		<label>Section</label>
<select id="sectionId" name="<%=SECTION_ID%>"  validate="Section,string,no" tabindex="1" onblur="displayOtherSec(this.value)"  >
			<option value="0">Select</option>
			<%
	 for(MasSection masSection : sectionList){
		
	 %>
		<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>
	 
	<%}
	%>
	<option value="other">Other</option>		
	</select>
	
<div id="addSecDiv" style="display: none;">
<label>Section Name</label>
<input type="text"  id="addSec" name="sectionName" tabindex="1" value="" maxlength="30"/>
</div>	
	
	<div class="clear"></div>
	<label>Trade/Branch</label> 
	<select id="tradeId" name="<%=TRADE_ID%>"
	validate="Trade/Branch,string,no" tabindex="1"
	onchange="displayOtherTrade(this.value);">
	<option value="0">Select</option>
	<%
				for (MasTrade masTrade : tradeList) 
				{
				%>
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>
	<%
					}%>
		<option value="other">Other</option>
</select> 
	<div id="addTradeDiv" style="display: none;">
	<label>Trade/Branch Name</label> 
<input id="newTradeId" type="text" name="<%=TRADE_NAME%>" value=""  tabindex="1"  validate="Trade Name,string,no" maxlength="30" tabindex="1"/>
<div class="clear"></div>
</div>	
<script type="text/javascript">
		
		<%
			int tradeCount=0;
			for (MasTrade masTrade : tradeList) 
				{
					if(masTrade.getServiceType() != null){
						if(serviceTypeId == masTrade.getServiceType().getId()){
							
								%>
									tradeArr[<%=tradeCount%>] = new Array();
									tradeArr[<%=tradeCount%>][0] = <%=serviceTypeId%>;
									tradeArr[<%=tradeCount%>][1] = <%=masTrade.getId()%>;									
									tradeArr[<%=tradeCount%>][2] = "<%=masTrade.getTradeName()%>";
								<%
								tradeCount++;
						}
					}
				}
			
		%>
		</script>
		<!-- 
		<label> Rcrd Off Add</label> <select id="recordOffId"
	name="<%=RECORD_OFFICE_ADDRESS_ID %>"
	validate="RecordOff Addrs,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRecordOfficeAddress recordOfficeAddress : recordOfficeAddressList) 
				{
			 		if(serviceTypeId == recordOfficeAddress.getServiceType().getId()){
			%>
	<option value="<%=recordOfficeAddress.getId()%>"><%=recordOfficeAddress.getAddress()%></option>
	<%}
			}%>
</select> -->

<script type="text/javascript">
					
				<%
				int count2=0;
					for (MasRecordOfficeAddress masRecordOfficeAddress : recordOfficeAddressList) 
						{
							if(masRecordOfficeAddress.getServiceType() != null){
								if(serviceTypeId == masRecordOfficeAddress.getServiceType().getId()){
										%>
											officeAddArr[<%=count2%>] = new Array();
											officeAddArr[<%=count2%>][0] = <%=serviceTypeId%>;
											officeAddArr[<%=count2%>][1] = <%=masRecordOfficeAddress.getId()%>;									
											officeAddArr[<%=count2%>][2] = "<%=masRecordOfficeAddress.getAddress()%>";
										<%
										count2++;
								}
							}
						}
					
				%>
					</script>
					
					<!--  <label>Formation:</label> <%if(serviceTypeId ==2){ %> <select
	name="<%=FORMATION_ID %>" tabindex="1" id="formation">
	<option value="">Select</option>
	<option value="1">Training Command, IAF</option>
	<option value="2">C A C</option>
	<option value="3">Western Air Command, IAF</option>
	<option value="4">South Western Air Command, IAF</option>
	<option value="5">Eastern Air Command, IAF</option>
	<option value="6">Southern Air Command, IAF</option>
	<option value="7">Maintenance Command, IAF</option>
	<option value="8">Others</option>

</select> <%}else{ %> <input id="formation" type="text" name="<%=FORMATION_ID %>"
	value="" validate="Formation,alphaspace,no" maxlength="30" tabindex="1">
<%} %> -->
<label> DOE/DOC</label>	
<input type="text" id="commissionDateId" name="commissionDate" tabindex="1" value="" readonly="readonly" validate="commission Date,date,no"  MAXLENGTH="30" class="calDate" onblur="if(this.value!=''){calculateTotalService(this.value);}"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender" onClick="setdate('',document.registration.commissionDate,event)" />

<input type="hidden" id="idForComEnrlDate" value=""> 

<label>Total Service</label>
<input id="totalServYrs"	type="hidden" name="" value="" validate="Total Service,float,no"	maxlength="6" tabindex="1" />
<select id="totalServ" name="<%=TOTAL_SERVICE%>"	tabindex="1" class="small" onchange="checkAgeAndService();">

	<%
						for(int age1=0;age1<=100;age1++){
						%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select>
<select id="totalServUnit" name="<%=TOTAL_SERVICE_PERIOD %>" validate="Service Period,string,no" tabindex="1" class="smallest">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<div class="clear"></div>
<label > Rcrd Off Add</label>
<select id="recordOffId" name="<%=RECORD_OFFICE_ADDRESS_ID %>" validate="RecordOff Addrs,string,no"  tabindex="1">
<option value="0">Select</option>
<%
for (MasRecordOfficeAddress masRecordOfficeAddress : recordOfficeAddressList) 
{
%>
<option value="<%= masRecordOfficeAddress.getId() %>"><%= masRecordOfficeAddress.getAddress() %></option>
<%} %>
</select>

<label > Religion</label>
<select id="religionId" name="<%=RELIGION_ID %>" validate="Religion,string,no"  tabindex="1">
<option value="0">Select</option>
<%
for (MasReligion masReligion : religionList) 
{
%>
<option value="<%= masReligion.getId() %>"><%= masReligion.getReligionName() %></option>
<%} %>
</select>
<label >Blood Group</label>
<select id="serBldGroupId" name="<%=SERV_BLD_GROUP %>"  validate="Blood Group,string,no" tabindex="1"   onchange="fillPatientName(this);" >
      <option value="0">Select</option>
      <%
	 for(MasBloodGroup masBloodGroup : bloodGroupList){
	
	%>
      <option value="<%=masBloodGroup.getId()%>"><%=masBloodGroup.getBloodGroupName()%></option>
      <%}%>
 </select> 
 <div class="clear"></div>
 <div id="exServiceId"></div>

<label >Telephone No.</label>
<input id="phoneNo" name="<%=TELEPHONE_NO %>" type="text"  tabindex="1" maxlength="11"/>
	
<label >Mobile No.</label>
<input id="mobileNo" name="<%=MOBILE_NO %>" type="text"  tabindex="1" maxlength="11"/>

<label>AFNET No.</label> 
<input id="afnetNo" name="afnetNo" type="text" tabindex="1"maxlength="15" />
<div class="clear"></div>
<label > Reporting For</label>
<select id="reportinForId" name="<%=REPORTING_FOR %>"  validate="Reporting For,string,yes" tabindex="1"   onchange="displayCategotries(this.value);" >
      <option value="0">Select</option>
    	<%
	 for(MasReporting masReporting : reportingList){
		
	 %>
		<option value="<%=masReporting.getId()%>"><%=masReporting.getReportingName()%></option>
	 
	<%}
	%>
 </select> 
<div id="medExamCategoryDiv" style="display: none;">
 <label><span>*</span> Exam Category</label>
<select id="medExamCategory" name="medExamCategory"  tabindex="1">
<option  value="">Select</option>
<option value="Annual Medical Exam(AFMSF-3B)">Annual Medical Exam(AFMSF-3B)</option>
<option value="Med. Exam On Release/Discharge(AFMSF-18)">Med. Exam On Release/Discharge(AFMSF-18)</option>
<option value="Primary/Extension Med. Exam(AFMSF-2A)">Primary/Extension Med. Exam(AFMSF-2A)</option>
<option value="Prior To Proceedings Abroad Med. Exam(AFMSF-3B)">Prior To Proceedings Abroad Med. Exam(AFMSF-3B)</option>
<option value="High Altitude Med. Exam(AFMSF-3B)">High Altitude Med. Exam(AFMSF-3B)</option>
</select>
</div>

<div id="medBoardCategoryDiv" style="display: none;">
 <label><span>*</span> Board Category</label>
<select id="medBoardCategory" name="medBoardCategory"  tabindex="1">
<option  value="">Select</option>
<option value="Initial Medical Board AFMSF 15">Initial Medical Board AFMSF 15</option>
<option value="Medical Board Review AFMSF 15">Medical Board Review AFMSF 15</option>
<option value="Medical Board Rel/Invalidment AFMSF 16">Medical Board Rel/Invalidment AFMSF 16</option>
</select>
</div>
<label class="highlight"><span>*</span> Doctor</label>
<select id="srconsultingDocId" name="srConsultingDoc"  validate="Doctor,string,no" onchange="fillPatientName(this);submitProtoAjax('registration','registration?method=getTokenNoForDepartment');setDepartmentValue(this.value);" tabindex="1" >
      <option value="0">Select</option>
     <%
int doctorId=0;
for(MasEmployee masEmployee : doctorList){
	doctorId = masEmployee.getId();
	if(masEmployee.getEmpCategory() != null){
		if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
<%				}
	}
} %>
 </select> 


<%
if(list.size() > 0){
%>
<label>Reg.HIN No</label>
<select id="regHinId" name="regHinId" onchange="displayPatientInfo(this.value)"  tabindex="1"> 
<%
	for(Patient hin:list){
%>
<option value="<%=hin.getId()%>"><%=hin.getHinNo()+"-"+hin.getPFirstName()+" "+hin.getPLastName()+"("+hin.getRelation().getRelationName()+")" %></option>
<%} %>
</select>

<%} %>
</div>
<script type="text/javascript">
//document.getElementById('UnitHideDiv').style.display = 'inline';
document.getElementById('unitId').setAttribute('validate','Unit,string,yes');

</script>
<%} %>
<script>
document.getElementById("visitNo").value='<%=lastVisitNo+1%>';
</script>