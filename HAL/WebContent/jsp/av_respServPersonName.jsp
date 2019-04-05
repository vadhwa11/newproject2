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

<%@ page import="static jkt.hms.util.RequestConstants.*"%>;
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
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.AviCasualtyAirEvacuation"%><div class="Block">
<%
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String time = (String)utilMap.get("currentTimeWithoutSc");
	Map<String, Object> map = new HashMap<String, Object>();
	List<Patient> list = new ArrayList<Patient>();
	List<Object[]> tradeList = new ArrayList<Object[]>();
	List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
	List<AviCasualtyAirEvacuation> aviCasualtyAirEvacuationList = new ArrayList<AviCasualtyAirEvacuation>();
	List<MasUnit> unitHoldList = new ArrayList<MasUnit>();
	List<MasAircraftType> aircraftTypeList = null;
	List<Object[]> rankList = new ArrayList<Object[]>();
	List<Object[]> unitList = new ArrayList<Object[]>();
	List<Object[]> sectionList = new ArrayList<Object[]>();
	List<Object[]> bloodGroupList = new ArrayList<Object[]>();
	List<Object[]> sexList = new ArrayList<Object[]>();
	List<Object[]> stationList = new ArrayList<Object[]>();
	List<Object[]> doctorList = new ArrayList<Object[]>();
	List<Object[]> commandList = new ArrayList<Object[]>();
	List<Object[]> maritalStatusList = new ArrayList<Object[]>();
	List<Object[]> religionList = new ArrayList<Object[]>();
	List<Object[]> serviceTypeList =null;
	List<Object[]> relationList = null;
	List<Object[]> districtList = null;
	List<Object[]> serviceStatusList = null;
	List<Object[]> stateList = null;
	int serviceTypeId = 0;
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("list") != null){
		list = (List<Patient>)map.get("list");
	}
	if(map.get("rankList") != null){
		rankList= (List<Object[]>)map.get("rankList");
	}
	if(map.get("unitList") != null){
		unitList= (List<Object[]>)map.get("unitList");
	}
	if(map.get("tradeList") != null){
		tradeList = (List<Object[]>)map.get("tradeList");
	}
	if(map.get("recordOfficeAddressList") != null){
		recordOfficeAddressList = (List<MasRecordOfficeAddress>)map.get("recordOfficeAddressList");
	}
	if(map.get("sectionList") != null){
		sectionList = (List<Object[]>)map.get("sectionList");
	}
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (List<Object[]>)map.get("bloodGroupList");
	}
	
	if(map.get("sexList") != null){
		sexList = (List<Object[]>)map.get("sexList");
	}
	if(map.get("serviceTypeId") != null){
		serviceTypeId = (Integer)map.get("serviceTypeId");
	}
	if(map.get("stationList") != null){
		stationList = (List<Object[]>)map.get("stationList");
	}
	if(map.get("employeeList") != null){
		doctorList = (List<Object[]>)map.get("employeeList");
	}
	if(map.get("commandList") != null){
		commandList = (List<Object[]>)map.get("commandList");
	}
	if(map.get("maritalStatusList") != null){
		maritalStatusList = (List<Object[]>)map.get("maritalStatusList");
	}
	if(map.get("religionList") != null){
		religionList = (List<Object[]>)map.get("religionList");
	}
	if(map.get("serviceTypeList") != null){
		serviceTypeList= (List<Object[]>)map.get("serviceTypeList");
	}
	if(map.get("relationList") != null){
		relationList = (List<Object[]>)map.get("relationList");
	}
	if(map.get("districtList") != null){
		districtList =(List<Object[]>)map.get("districtList");
	}
	if(map.get("serviceStatusList") != null){
		serviceStatusList = (List<Object[]>)map.get("serviceStatusList");
	}
	if(map.get("stateList") != null)	{
		stateList = (List<Object[]>)map.get("stateList");
	}
	if(map.get("aircraftTypeList") != null){
		aircraftTypeList = (List<MasAircraftType>)map.get("aircraftTypeList");
	}
	if(map.get("aviCasualtyAirEvacuationList") != null){
		aviCasualtyAirEvacuationList = (List<AviCasualtyAirEvacuation>)map.get("aviCasualtyAirEvacuationList");
	}
	String serviceNo = "";
	if(map.get("serviceNo")!=null){
		serviceNo = (String)map.get("serviceNo");
	}
	int serviceStatusId = 0;
	if(map.get("serviceStatusId")!=null){
		serviceStatusId = (Integer)map.get("serviceStatusId");
	}
	String echs = "";
	if(map.get("echs")!=null){
		echs = (String)map.get("echs");
	}
	String prefix = "";
	if(map.get("prefix")!=null){
		prefix= (String)map.get("prefix");
	}
	String suffix = "";
	if(map.get("suffix")!=null){
		suffix = (String)map.get("suffix");
	}
	String servPersonFName = "";
	String servPersonMName = "";
	String servPersonLName = "";
	
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
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
	String patientStatus = "";
	if(list.size() > 0){
		Patient patient = new Patient();
		Set<MasMedicalExamFamilyHis> familyHisSet = new HashSet<MasMedicalExamFamilyHis>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			patient = (Patient) iterator.next();
			if(patient.getRelation().getId() == 8){
				regHinId = patient.getId();
				selfHinNo = patient.getHinNo();
				patientStatus = patient.getPatientStatus();
				if(patient.getCurrentVisitNo() != null){
					lastVisitNo = patient.getCurrentVisitNo();
				}
				if(patient.getMasMedicalExamFamilyHis() !=null){
					familyHisSet  = patient.getMasMedicalExamFamilyHis() ;
				}
			}
		}

	servPersonFName = patient.getSFirstName();
	if(patient.getSMiddleName() != null)
		servPersonMName = patient.getSMiddleName();
	if(patient.getSLastName() != null)
		servPersonLName = patient.getSLastName();
	
	
	Box box= HMSUtil.getBox(request);
	int hinId = 0;
	if(box.getInt("hinId")!=0){
	 hinId = box.getInt("hinId");
	}else if(regHinId!=0){
		hinId = regHinId;
	}
	
	%>		


<!--<label>HIN</label>
--><!--<label id="defaulthinno" class="value" style="display: none;">&nbsp;</label>
--><label id="hinNoDivId" class="value" style="display: none;"></label>
<input id="hinNoId" type="hidden" name="<%=HIN_NO %>" value="" />
<div class="clear"></div>
<div id="srNoDiv" style="display: block;">
<label>Service No.<span>*</span></label>

<input 	id="prefix" name="<%=PREFIX%>" maxlength="3" class="auto" size="1" value="<%= patient.getPrefix()!=null?patient.getPrefix():"" %>"	tabindex="1" validate="Prefix,metachar,no" /> 
<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>" value="<%= serviceNo %>" title="Enter Service No" tabindex="1" validate="Service No,metachar,yes" maxlength="20"
	onblur="validateServiceNo(this.value,'registration');submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=displaySrPhoto','srPhoto');submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getServiceNoDetailsForReg&serviceNo='+this.value,'depenedentDiv');">
<select id="suffixId" name="<%=SUFFIX%>" validate="Suffix,metachar,no"	tabindex="1" class="smallest2">
	<option value="">Select</option>
	<%
			for(char i='A'; i<='Z'; i++){
		%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>

</select> 
<script>document.getElementById("suffixId").value='<%=((patient.getSuffix()!=null && !patient.getSuffix().equals("null"))?patient.getSuffix():"")%>';</script>

<label> Service Status <span>*</span></label> 
<select	id="serviceStatusId" name="<%=SERVICE_STATUS_ID %>"
	validate="Service Status,metachar,yes" tabindex="1"
	onchange="getEchsNo();populateRank('registration');getHin();">
	<option value="0">Select</option>
		<% 
			for(Object[] masServiceStatus : serviceStatusList){
				if(masServiceStatus[0].equals(1)){
		%>
	<option value="<%=masServiceStatus[0] %>" selected="selected"><%=masServiceStatus[1] %></option>
	<%}else{%>
	<option value="<%=masServiceStatus[0] %>"><%=masServiceStatus[1] %></option>

	<%}
			}
				%>
</select>
<div id="exServiceId">
<%
	if(patient.getEchsNo()!=null){
%>
<label> ECHS No. <span>*</span></label>
<input type="text" name="echs" validate="ECHS No,metachar,no"
	maxlength="12" value="<%=patient.getEchsNo() %>" id="echs">
<%} %>
</div>
<script>document.getElementById('serviceStatusId').value='<%=patient.getServiceStatus().getId()%>';</script>
</div>
<div class="clear"></div>
<label>HIN</label>
<select id="regHinId" name="regHinId" tabindex="1"  onchange="if(this.value!='0'){displayPatientInfo(this.value);submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=displaySrPhoto&photoHinId='+this.value,'srPhoto');}else{getHin();}"> 
<option value="0">Select</option>
<%String printHinNo = "";
if(list.size() > 0){

	for(Patient hin:list){
		//if(hin.getPatientStatus().equalsIgnoreCase("Out Patient")){
String pMidName = "";
String pLastName = "";
		if(hin.getPMiddleName() != null){
			pMidName = hin.getPMiddleName() ;
		}
		if(hin.getPLastName() != null){
			pLastName = hin.getPLastName() ;
		}
		
		if(hinId == hin.getId()){
			printHinNo = hin.getHinNo();
%>
<option value="<%=hin.getId()%>" selected="selected"><%=hin.getHinNo()+"-"+hin.getPFirstName()+" "+pMidName+" "+pLastName+" ("+hin.getRelation().getRelationName()+")" %></option>
<%}else{ %>
<option value="<%=hin.getId()%>"><%=hin.getHinNo()+"-"+hin.getPFirstName()+" "+pMidName+" "+pLastName+" ("+hin.getRelation().getRelationName()+")" %></option>
<%} 
//	}
	}
}%>
</select>
<input type="hidden" name="printHinNo" id="printHinNo" value="<%= printHinNo%>">
<label>Service Type <span>*</span></label> 
<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>"	validate="Service Type,metachar,yes" tabindex="1"
	onchange="callFunctions(this.value)">
	<option value="0">Select</option>

	<% 
			for(Object[] masServiceType : serviceTypeList){
 %>
	<option value="<%=masServiceType[0] %>"><%=masServiceType[1] %></option>
	<%
				}%>
</select>
<script>document.getElementById('serviceTypeId').value='<%=patient.getServiceType().getId()%>';</script>
<div id="rankDivId">
<label> Rank</label> 
<label	class="value"><%= patient.getRank().getRankName()%></label>
<input id="rankId"	type="hidden" name="<%=RANK_ID %>"	value="<%=patient.getRank().getId() %>">
<script>
//	document.getElementById('serviceStatusId').value='<%=patient.getRank().getServiceStatus().getId()%>'
</script>
</div> <!-- End Of rankDivId-->
<div class="clear"></div>
<label>First Name</label> 
<input id="sFNameId" type="text" name="<%=S_FIRST_NAME %>" value="<%=servPersonFName %>" tabindex="1"	title="First Name of Service Person"	validate="First Name of Service Person,name,yes" MAXLENGTH="15"	onblur="fillPatientName(this);" /> 

<label>Middle Name</label> 
<input	id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value="<%=servPersonMName %>"	tabindex="1" validate="Middle Name of Service Person,name,no"	MAXLENGTH="15" onchange="fillPatientName(this);" />

<label>Last Name</label> 
<input id="sLNameId" type="text"	name="<%=S_LAST_NAME %>" value="<%=servPersonLName %>" tabindex="1"	validate="Last Name of Service Person,name,no" MAXLENGTH="15"	onchange="fillPatientName(this);" />
<script>
document.getElementById('pFirstNameId').value = '<%=servPersonFName%>'
document.getElementById('pMiddleNameId').value = '<%=servPersonMName%>'
document.getElementById('pLastNameId').value = '<%=servPersonLName%>'
</script>
<div id="srPrDtDiv">
<div class="clear"></div>

<label> Trade/Branch</label> 
<%
	if(patient.getTrade() != null){
%> 
<label class="value"><%= patient.getTrade().getTradeName()%></label>
<input type="hidden" name="<%=TRADE_ID %>"	value="<%=patient.getTrade().getId() %>"> <%
	}else{
%> 
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,metachar,no" tabindex="1"	onchange="displayOtherTrade(this.value);">
	<option value="0">Select</option>
		<%for(Object[] trade :tradeList){ %>
	<option value=<%=trade[0]%>><%=trade[1] %></option>
	<%} %>
	<option value="other">Other</option>
</select>

<div id="addTradeDiv" style="display: none;">
<label> Trade/Branch Name <span>*</span></label> 
<input id="newTradeId" type="text"	name="<%=TRADE_NAME%>" value="" tabindex="1"	validate="Trade Name,metachar,no" maxlength="30" tabindex="1" /> 
</div>
<%} %>

<label> DOE/DOC</label> 
<%
	if(patient.getCommissionDate() != null){
%>
<label	class="value"><%= HMSUtil.convertDateToStringWithoutTime(patient.getCommissionDate())%></label>
<input id="commissionDate" type="hidden" name="commissionDate"	value="<%=HMSUtil.convertDateToStringWithoutTime(patient.getCommissionDate()) %>">

<%}else{ %>
<input type="text" id="commissionDateId" name="commissionDate" tabindex="1" value="" validate="commission Date,date,no"  MAXLENGTH="30" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"	onblur="if(this.value!=''){validateExpDate(this,'commissionDateId');calculateTotalService(this.value);}"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender" onClick="setdate('',document.registration.commissionDate,event)" />

	<%} %>
<label>Total Service </label> 
<%
		if(patient.getServiceYears() != null  && !(patient.getServiceYears().equals(""))){
	%>
<input id="totalServYrs" type="hidden" name="" value=""	validate="Total Service,float,no" maxlength="6" tabindex="1"  />
<input	type="hidden" name="<%=SERVICE_YEARS %>"	value="<%=patient.getServiceYears() %>">

	<select id="totalServ"	name="<%=TOTAL_SERVICE%>" validate="Total Service ,float,no" tabindex="1"	class="small" onchange="checkAgeAndService();">
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
	validate="Service Period,metachar,no" tabindex="1" class="smallest" >
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
	validate="Service Period,metachar,no" tabindex="1" class="smallest" >
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select>
<%} %>

<div class="clear"></div>
<label>Section</label> 
<select id="sectionId" name="<%=SECTION_ID%>"	validate="Section,metachar,no" tabindex="1"	onblur="displayOtherSec(this.value)">
	<option value="0">Select</option>
		<%
	 for(Object[] masSection : sectionList){
		
	 %>
	<option value="<%=masSection[0]%>"><%=masSection[1]%></option>

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
<div id="addSecDiv" style="display: none;">
<label>Section Name <span>*</span></label> 
<input type="text" id="addSec" name="sectionName" tabindex="1"	value="" maxlength="30" />
</div>
 <%
		if(patient.getUnit() != null){
	%> 
<label>Unit</label>
<label class="value"><%= patient.getUnit().getUnitName()%></label>
<input type="hidden" name="<%=UNIT_ID %>"  id="unitId" value="<%= patient.getUnit().getId()%>">
<%}else{ %>
<label> Unit <span>*</span></label>
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1" validate="Unit,metachar,yes"  onchange="populateStationForUnit(this.value);">
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
<div class="clear"></div>
<label>Unit Name <span>*</span></label> 
<input id="newUnitId" type="text" name="<%=UNIT_NAME%>"	value="" tabindex="1" validate="Unit Name,metachar,no" maxlength="30"	tabindex="1" /> 
<label> Unit Address</label> 
<input	id="newUnitAddressId" type="text" name="<%=UNIT_ADDRESS %>" value=""	validate="Unit Address,metachar,no" maxlength="50" tabindex="1" /> 
<div class="clear"></div>
</div>
<%} %>
<label>Station</label> 
<%
if(patient.getStation() != null  && !(patient.getStation().equals(""))){
%>
<label class="value"><%= patient.getStation()%></label>
<input type="hidden" name="<%=STATION %>"	value="<%=patient.getStation() %>">
<%}else{ %>
<select	id="stationId" name="<%=STATION %>"	onchange="populateCommandForStation(this.value);displayOtherStn(this.value)"	tabindex="1">
	<option value="">Select</option>
	<%
	 for(Object[] masStation : stationList){
		
	 %>
	<option value="<%=masStation[1]%>"><%=masStation[1]%></option>

	<%}
	%>
	<option value="other">Other</option>
</select>
<div id="addStnDiv" style="display: none;">
<label>Station Name <span>*</span></label> 
<input type="text" id="addStn" name="stationName" tabindex="1"	value="" maxlength="30" />
</div>
<%} %>
<div class="clear"></div>
<%
	if(patient.getCommand() != null){
%>
<label >Command</label>
<label	class="value"><%= patient.getCommand().getCommandName()%></label>
<input	type="hidden" name="<%=COMMAND %>"	value="<%=patient.getCommand().getId() %>">
<%}else{ %>
<label > Command</label>
<select id="commandId" name="<%=COMMAND %>"  validate="Command,metachar,no" tabindex="1" onchange="populateStation('registration')" >
		<option value="0">Select</option>
		<%
			if(commandList.size() > 0){
				for(Object[] command : commandList){
					%>
				<option value="<%= command[0] %>"><%=command[1] %></option>
		<%
				}
				} %>
				<option value="other">Other</option>
</select>
<div id="addCmdDiv" style="display: none;">
<label><span>*</span> Command Name</label>
<input type="text" id="addCmd" name="commandName" value="" tabindex="1" maxlength="30"/>
</div><%} %>

<label > Record Office</label>
<select id="recordOffId" name="<%=RECORD_OFFICE_ADDRESS_ID %>" validate="RecordOff Addrs,metachar,no"  tabindex="1">
<option value="0">Select</option>
<%
for (MasRecordOfficeAddress masRecordOfficeAddress : recordOfficeAddressList) 
{
%>
<option value="<%= masRecordOfficeAddress.getId() %>"><%= masRecordOfficeAddress.getAddress() %></option>
<%} %>
</select>
<script>
<%
if(patient.getRecordOfficeAddress()!= null){
%>
document.getElementById('recordOffId').value = '<%=patient.getRecordOfficeAddress().getId()%>'
<%} %></script>
</div><!-- End srPrDtDiv-->
<div class="clear"></div>
</div><!-- End Block 1-->
<div class="clear"></div>
<script type="text/javascript">
document.getElementById('unitId').setAttribute('validate','Unit,metachar,yes');
setTimeout('getHin()',5000);
</script>

<div class="clear"></div>
<%} %>

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
	time = '<%=time%>';
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