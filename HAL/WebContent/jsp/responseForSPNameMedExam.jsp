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
	int serviceTypeId = 0;
	
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


<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasReporting"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasStation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%><div id="rankDivId">
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
<input id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>"	value="<%=servPersonMName %>"	validate="Middle Name of Service Person,name,no" MAXLENGTH="15"	readonly="readonly" />
<div class="clear"></div>
<label>Last Name</label>
<input id="sLNameId" type="text" name="<%=S_LAST_NAME %>"	value="<%=servPersonLName %>"	validate="Last Name of Service Person,name,no" MAXLENGTH="15"	readonly="readonly" />

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
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age of Service Person,string,yes" tabindex="1" class="smallest" onchange="checkForSRDOB();fillPatientName(this);">
          <option value="">Select</option>
          <%
				for(int age1 = 16;age1<=100;age1++){
				%>
          <option value="<%=age1%>"><%= age1%></option>
          <%}%>
</select>
   
<select id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" validate="AgeUnit,string,no" tabindex="1" class="small" onchange="checkForSRDOB();fillPatientName(this);">
          <option selected="selected" value="Years">Years</option>
          <option value="Months">Months</option>
          <option value="Days">Days</option>
</select>
  <input type="hidden" id="idForSrAge" value="">  
</div>


<%} %>

 <label> Marital Status</label> 
 <%
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
    <%} %>
<%
	if(patient.getCommand() != null){
%>
<label >Command</label>
<label	class="value"><%= patient.getCommand().getCommandName()%></label>
<input	type="hidden" name="<%=COMMAND %>"	value="<%=patient.getCommand().getId() %>">
<%}else{ %>
<label ><span>*</span> Command</label>
<select id="commandId" name="<%=COMMAND %>"  validate="Command,stirng,yes" tabindex="1" onchange="populateStation('registration')" >
		<option value="">Select</option>
		<%
			if(commandList.size() > 0){
				for(MasCommand command : commandList){
		%>
		<option value="<%= command.getId() %>"><%=command.getCommandName() %></option>
		<%
				}
				} %>
</select>
<%} %>
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
<select id="stationId" name="<%=STATION %>" tabindex="1"  onchange="populateUnit('registration')">
	<option value="">Select</option>
 <%
	 for(MasStation masStation : stationList){
		
	 %>
		<option value="<%=masStation.getStationName()%>"><%=masStation.getStationName()%></option>
	 
	<%}
	%>


</select> 
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
</select>
<%} %>

	
	<label>Section</label>
<%
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
	</select>
<%} %>
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
</select> <%} %>

<label>Commission/Enrollment Date </label>	

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
<select id="totalServ"	name="<%=TOTAL_SERVICE%>" validate="Total Service ,string,no" tabindex="1"	class="small">
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
	validate="Service Period,string,no" tabindex="1" class="smallest">
	<option value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select>
<%}else{ %>
<select id="totalServ" name="<%=TOTAL_SERVICE%>" validate="Total Service,float,no" 
	tabindex="1" class="small">
	<option value="0">Select</option>
	<%
						for(int age1=1;age1<=100;age1++){
						%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select>

<select id="totalServUnit" name="<%=TOTAL_SERVICE_PERIOD %>"
	validate="Service Period,string,no" tabindex="1" class="smallest">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select>
<%} %>

<div class="clear"></div>
<label >Blood Group</label>
<%
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
    <%} %>

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
<div class="clear"></div>
<label> Reporting For</label>
<select id="reportinForId" name="<%=REPORTING_FOR %>"  validate="Reporting For,string,yes" tabindex="1"   onchange="displayCategotries(this.value);"   >
      <option value="0">Select</option>
    	<%
	 for(MasReporting masReporting : reportingList){
			if(masReporting.getReportingName().equals("Medical Board") || masReporting.getReportingName().equals("Medical Exam") ){
	 %>
		<option value="<%=masReporting.getId()%>"><%=masReporting.getReportingName()%></option>
	 
	<%}
	 }
	%>
 </select>
 <div id="medExamCategoryDiv" style="display: none;">
 <label><span>*</span> Exam Category</label>
<select id="medExamCategory" name="medExamCategory" >
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
<select id="medBoardCategory" name="medBoardCategory" >
<option  value="">Select</option>
<option value="InitialMedicalBoardAFMSF15">InitialMedicalBoardAFMSF15</option>
<option value="Medical Board Review AFMSF 15">Medical Board Review AFMSF 15</option>
<option value="Medical Board Rel/Invalidment AFMSF 16">Medical Board Rel/Invalidment AFMSF 16</option>
</select>
</div>

 <!-- 

 
 <label class="highlight"><span>*</span> Doctor</label>
--><select id="srconsultingDocId" name="srConsultingDoc" style="display: none;"  validate="Doctor,string,no" onchange="fillPatientName(this);submitProtoAjax('registration','registration?method=getTokenNoForDepartment');setDepartmentValue(this.value);" tabindex="1" >
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
<select
	id="rankId" name="<%=RANK_ID%>" validate="Rank,string,yes" tabindex="1">
	<option value="0">Select</option>
	<%
				for (MasRank masRank : rankList) 
				{
					if(serviceTypeId == masRank.getServiceType().getId()){
				%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}
					}%>
</select> 

<script type="text/javascript">
		
		<%
			int k=0;
			for (MasRank masRank : rankList) 
				{
					if(masRank.getServiceStatus() != null){
						if(serviceTypeId == masRank.getServiceStatus().getId()){
								%>
									rankArr[<%=k%>] = new Array();
									rankArr[<%=k%>][0] = <%=serviceTypeId%>;
									rankArr[<%=k%>][1] = <%=masRank.getServiceType().getId()%>;
									rankArr[<%=k%>][2] = <%=masRank.getId()%>;									
									rankArr[<%=k%>][3] = "<%=masRank.getRankName()%>";
								<%
								k++;
						}
					}
				}
			
		%>
		</script></div>
<label><span>*</span>  First Name</label>
<input id="sFNameId" type="text" name="<%=S_FIRST_NAME %>" value=""
	title="First Name of Service Person"
	validate="First Name of Service Person,name,Yes" tabindex="1"
	MAXLENGTH="15" onblur="fillPatientName(this);" />

<label>Middle Name</label>
<input id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value=""
	validate="Middle Name of Service Person,name,no" MAXLENGTH="15"
	tabindex="1" onchange="fillPatientName(this);" />
<div class="clear"></div>
<label>Last Name</label>
<input id="sLNameId" type="text" name="<%=S_LAST_NAME %>" value=""
	validate="Last Name of Service Person,name,no" MAXLENGTH="15"
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
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age of Service Person,string,yes" tabindex="1" class="smallest" onchange="checkForSRDOB();fillPatientName(this);">
          <option value="">Select</option>
          <%
				for(int age1 = 16;age1<=100;age1++){
				%>
          <option value="<%=age1%>"><%= age1%></option>
          <%}%>
</select>
   
<select id="srAgeUnitId" name="<%=SR_AGE_UNIT %>" validate="AgeUnit,string,no" tabindex="1" class="small" onchange="checkForSRDOB();fillPatientName(this);">
          <option selected="selected" value="Years">Years</option>
          <option value="Months">Months</option>
          <option value="Days">Days</option>
</select>
       <input type="hidden" id="idForSrAge" value="">   
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

<label><span>*</span> Command</label>
<select id="commandId" name="<%=COMMAND %>"  validate="Command,string,yes" tabindex="1" onchange="populateStation('registration')" >
	<option value="0">Select</option>
	<%
			if(commandList.size() > 0){
				for(MasCommand command : commandList){
		%>
		<option value="<%= command.getId() %>"><%=command.getCommandName() %></option>
		<%
				}
				} %>
</select>

<div class="clear"></div>
<div id="tradeDivId">

		
	<label>Station</label> 
	<select id="stationId" name="<%=STATION %>" onchange="populateUnit('registration')" tabindex="1">
	<option value="">Select</option>
 <%
	 for(MasStation masStation : stationList){
		
	 %>
		<option value="<%=masStation.getStationName()%>"><%=masStation.getStationName()%></option>
	 
	<%}
	%>


</select> 
	
	
	<label><span>*</span> Unit</label>
	<select id="unitId" name="<%=UNIT_ID %>" tabindex="1" validate="Unit,string,yes"  >
<option value="0">Select</option>
			 <%
					 for(Object[] masUnit : unitList){
					 %>
						<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
					 
					<%
						
					}%>	
<option value="Other">Other</option>
</select>

		<label>Section</label>
<select id="sectionId" name="<%=SECTION_ID%>"  validate="Section,string,no" tabindex="1"  >
			<option value="0">Select</option>
			<%
	 for(MasSection masSection : sectionList){
		
	 %>
		<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>
	 
	<%}
	%>
		
	</select>
	<div class="clear"></div>
	<label>Trade/Branch</label> <select id="tradeId" name="<%=TRADE_ID%>"
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
</select> 
	
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
	

<label>Commission/Enrollment Date </label>	
<input type="text" id="commissionDateId" name="commissionDate" tabindex="1" value="" readonly="readonly" validate="commission Date,date,no"  MAXLENGTH="30" class="calDate" onblur="if(this.value!=''){calculateTotalService(this.value);}"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender" onClick="setdate('',document.registration.commissionDate,event)" />

<label>Total Service</label>
<input id="totalServYrs"	type="hidden" name="" value="" validate="Total Service,float,no"	maxlength="6" tabindex="1" />
<select id="totalServ" name="<%=TOTAL_SERVICE%>"	tabindex="1" class="small">
	<option value="">Select</option>
	<%
						for(int age1=1;age1<=100;age1++){
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
<label >Blood Group</label>
<select id="serBldGroupId" name="<%=SERV_BLD_GROUP %>"  validate="Blood Group,string,no" tabindex="1"   onchange="fillPatientName(this);" >
      <option value="0">Select</option>
      <%
	 for(MasBloodGroup masBloodGroup : bloodGroupList){
	
	%>
      <option value="<%=masBloodGroup.getId()%>"><%=masBloodGroup.getBloodGroupName()%></option>
      <%}%>
 </select> 
 

<label >Telephone No.</label>
<input id="phoneNo" name="<%=TELEPHONE_NO %>" type="text" />
	
<label >Mobile No.</label>
<input id="mobileNo" name="<%=MOBILE_NO %>" type="text" />
<div class="clear"></div>
<label > Reporting For</label>
<select id="reportinForId" name="<%=REPORTING_FOR %>"  validate="Reporting For,string,yes" tabindex="1"   onchange="displayCategotries(this.value);" >
      <option value="0">Select</option>
    	<%
	 for(MasReporting masReporting : reportingList){
			if(masReporting.getReportingName().equals("Medical Board") || masReporting.getReportingName().equals("Medical Exam") ){
	 %>
		<option value="<%=masReporting.getId()%>"><%=masReporting.getReportingName()%></option>
	 
	<%}
	 }
	%>
 </select> 
<div id="medExamCategoryDiv" style="display: none;">
 <label><span>*</span> Exam Category</label>
<select id="medExamCategory" name="medExamCategory" >
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
<select id="medBoardCategory" name="medBoardCategory" >
<option  value="">Select</option>
<option value="InitialMedicalBoardAFMSF15">InitialMedicalBoardAFMSF15</option>
<option value="Medical Board Review AFMSF 15">Medical Board Review AFMSF 15</option>
<option value="Medical Board Rel/Invalidment AFMSF 16">Medical Board Rel/Invalidment AFMSF 16</option>
</select>
</div>
<!--<label class="highlight"><span>*</span> Doctor</label>
--><select id="srconsultingDocId" name="srConsultingDoc" style="display: none;"  validate="Doctor,string,no" onchange="fillPatientName(this);submitProtoAjax('registration','registration?method=getTokenNoForDepartment');setDepartmentValue(this.value);" tabindex="1" >
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


</div>
<script type="text/javascript">
//document.getElementById('UnitHideDiv').style.display = 'inline';
document.getElementById('unitId').setAttribute('validate','Unit,string,yes');

</script>
<%} %>
<script>
document.getElementById("visitNo").value='<%=lastVisitNo+1%>';

</script>