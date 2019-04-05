<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * updateRegistration.jsp  
 * Purpose of the JSP -  This is for Update Registration.
 * @author  Ritu
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.36
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*" %>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/phaseII.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasTitle"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasReligion"%>
<%@ page import="jkt.hms.masters.business.MasOccupation"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hms.masters.business.MasBlock"%>
<%@ page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@ page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@ page import="jkt.hms.masters.business.MasReference"%>
<%@ page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="jkt.hms.masters.business.MasDisposal"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>



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


<div id="contentHolder">
<h6>Update Patient Registration</h6>
<div class="Clear"></div>
<form name="updateRegistration" method="post" action="">
<%  	
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String time = (String)utilMap.get("currentTime");
	 
	 		Map<String, Object> map = new HashMap<String, Object>();
	 		Map<String, Object> patientDetailsMap = new HashMap<String, Object>();
	 		List<Patient> patientList = null;
	 		List<Visit> visitList = null;
	 		List<MasRank> rankList = null;
	 		
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
			if(map.get("patientDetailsMap")!= null){
				patientDetailsMap = (Map<String, Object>)map.get("patientDetailsMap");
			}
			if(patientDetailsMap.get("patientList") != null){
				patientList = (List<Patient>)patientDetailsMap.get("patientList");
			}
			if(patientDetailsMap.get("visitList") != null){
				visitList = (List<Visit>)patientDetailsMap.get("visitList");
			}
			
			if(patientDetailsMap.get("rankList") != null){
				rankList = (List<MasRank>)patientDetailsMap.get("rankList");
			}
			List<UploadDocuments>documentList=new ArrayList<UploadDocuments>();
			if(patientDetailsMap.get("documentList") != null){
				documentList = (List<UploadDocuments>)patientDetailsMap.get("documentList");
			}
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			List<MasUnit> unitList = new ArrayList<MasUnit>();
			if(map.get("unitList") != null){
				unitList= (List<MasUnit>)map.get("unitList");
			}
			String uploadURL ="";
			if(map.get("uploadURL") != null){
				uploadURL= (String)map.get("uploadURL");
			}
			
			List<MasReligion> religionList = null;
			List<MasTitle> titleList = null;
			List<MasOccupation> occupationList = null;
			List<MasMaritalStatus> maritalStatusList = null;
			List<MasRelation> relationList = null;
			List<MasReference> referenceList = null;
			List<MasCountry> countryList = null;
			List<MasState> stateList = null;
			List<MasDistrict> districtList = null;
			List<MasBlock> blockList = null;
			List<MasRecordOfficeAddress> recordOfficeAddressList = null;
			List<MasBloodGroup> bloodGroupList = null;
			List<MasDiagnosisConclusion> diagnosisList = null;
			List<MasDisposal> disposalList = null;
			List<MasAdministrativeSex> sexList = null;
			List<MasTrade> tradeList = null;
			
			if(map.get("titleList") != null){
				titleList = (List<MasTitle>)map.get("titleList");
			}
			
			if(map.get("maritalStatusList") != null){
				maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
			}
			if(map.get("religionList") != null){
				religionList = (List<MasReligion>)map.get("religionList");
			}
			if(map.get("countryList") != null){
				countryList =(List<MasCountry>)map.get("countryList");
			}
			if(map.get("stateList") != null)	{
				stateList = (List<MasState>)map.get("stateList");
			}
			if(map.get("districtList") != null){
				districtList =(List<MasDistrict>)map.get("districtList");
			}
			if(map.get("blockList") != null){
				blockList = (List<MasBlock>)map.get("blockList");
			}
			if(map.get("relationList") != null){
				relationList = (List<MasRelation>)map.get("relationList");
			}
			if(map.get("referenceList") != null){
				referenceList = (List<MasReference>)map.get("referenceList");
			}
			if(map.get("bloodGroupList") != null){
				bloodGroupList = (List<MasBloodGroup>)map.get("bloodGroupList");
			}
			if(map.get("occupationList") != null){
				occupationList = (List<MasOccupation>)map.get("occupationList");
			}
			if(map.get("recordOfficeAddressList") != null){
				recordOfficeAddressList = (List<MasRecordOfficeAddress>)map.get("recordOfficeAddressList");
			}
			if(map.get("diagnosisList") != null){
				diagnosisList = (List<MasDiagnosisConclusion>)map.get("diagnosisList");
			}
			if(map.get("disposalList") != null){
				disposalList = (List<MasDisposal>)map.get("disposalList");
			}
			if(map.get("sexList") != null){
				sexList = (List<MasAdministrativeSex>)map.get("sexList");
			}
			
			if(map.get("tradeList") != null){
				tradeList = (List<MasTrade>)map.get("tradeList");
			}
			
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String serviceNameForCivilian = properties.getProperty("serviceNameForCivilian");
			String bangaloreDistrictCode = properties.getProperty("bangaloreDistrictCode");
			%> 
			<script type="text/javascript">

			function displayAddress(){
				var unit = document.getElementById('unitId').value;
				document.getElementById('unitAddId').style.display = 'inline';
				if(unit != 0){
				if(unit != 'Other'){
				document.getElementById('addUnitDiv').style.display = 'none';
				<%
					 for(MasUnit masUnit : unitList){
				%>
						var unit1 = '<%=masUnit.getId()%>';
						if(unit == unit1){
						
							document.updateRegistration.unitAdd.value = '<%=masUnit.getUnitAddress()%>'
						 }
			<%}%>}else if(unit == 'Other'){
						document.getElementById('addUnitDiv').style.display = 'inline';
						document.getElementById('unitAddId').style.display = 'none';
					}
				}else if(unit == 0){
					document.updateRegistration.<%=UNIT_ADDRESS%>.value = '';
				}
			}
			
 function openPopupWindowForUnit()
 {
  var url="/hms/hms/adt?method=showUnitSearchJsp";
  newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
 }
 
 function jsSetUnitData(unitId,unitAddress)
{
 for(var i=0;i<document.getElementById("unitId").length;i++)
 {
	 if (document.getElementById("unitId").options[i].value==unitId)
	 {
	 	document.getElementById("unitId").selectedIndex = i;
	 }
	 if(unitAddress != "" && unitAddress != null){
	  document.getElementById('unitAddress').value =unitAddress
	 }
 }	
 var check = document.getElementById("unitId").value;
     if(check != "Other"){
      document.getElementById('addUnitDiv').style.display = 'none';
      document.getElementById('unitAddId').style.display = 'inline';
     }
 }	
 
 function fillPatientName(obj){
	var objValue = obj.value;
	var relation = document.getElementById('relationId').value;
	if(relation == '8'){
		if(obj.id == 'sFirstNameId'){
			document.getElementById('pFirstNameId').value = objValue;
			}
		if(obj.id == 'sMiddleNameId')
			document.getElementById('pMiddleNameId').value = objValue;
		if(obj.id == 'sLastNameId')
			document.getElementById('pLastNameId').value = objValue;
	}
	
	if(relation != '8'){
		var sfName = "";
		var smName ="";
		var slName = "";
		if(document.getElementById('sFirstNameId').value != ""){
			sfName=document.getElementById('sFirstNameId').value;
		}
		if(document.getElementById('sMiddleNameId').value != ""){
			smName=document.getElementById('sMiddleNameId').value;
		}
		if(document.getElementById('sLastNameId').value != ""){
			slName=document.getElementById('sLastNameId').value;
		}
		//if(sfName != "" || smName != "" || slName != ""){
		//	document.getElementById('nokNameId').value = sfName+" "+smName+" "+slName;
		//	}
	}
}
function displayAddressForTrade(){
				var trade = document.getElementById('tradeId').value;
				if(trade != 0){
				if(trade !=31 ){
				document.getElementById('addTradeDiv').style.display = 'none';
				}else if(trade == 31){
				  document.getElementById('addTradeDiv').style.display = 'inline';
					
				}
				}
			}
		
		</script> 
		<script type="text/javascript">
		<%
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : districtList) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;									
									districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
			<%
			int count = 0;
			for (MasDistrict masDistrict : districtList) 
			{
				for (MasBlock masBlock  : blockList) 
				{
					if(masBlock.getDistrict() != null){
						if(masDistrict.getId().equals(masBlock.getDistrict().getId())){
								%>
									blockArray[<%=count%>] = new Array();
									blockArray[<%=count%>][0] = <%=masDistrict.getId()%>;
									blockArray[<%=count%>][1] = <%=masBlock.getId()%>;									
									blockArray[<%=count%>][2] = "<%=masBlock.getBlockName()%>";

								<%
								count++;
						}
					}
				}
			}
			%>
			
		</script> <%
	if(patientList.size() >0){
		for(Patient patient : patientList){

%>
<div class="blockTitle">SERVICE PERSONNEL DETAILS</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="header">
<label>HIN No:</label> <!--  <div id="hinNoDivId"> <%= patient.getHinNo() %></div>-->
<label id="hinNoDivId" class="value"><%= patient.getHinNo() %></label> 
<input id="hinNoId" type="hidden" name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>" /> 
<label>Reg Date:</label> 
<input type="text" name="<%=REG_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(patient.getRegDate())%>" validate="Registration Date,String,no" readonly="readonly" class="calDate" /> 
<label>Reg Time:</label> <% if(patient.getRegTime() != null){%>
<input type="text" name="<%=REG_TIME %>"
	value="<%=patient.getRegTime() %>"
	validate="Registration Time,string,no" maxlength="20"
	readonly="readonly" class="calDate" /> <%} else{ %> <input type="text"
	name="<%=REG_TIME %>" value="" validate="Registration Time,string,no"
	maxlength="20" readonly="readonly" /> <%} %>

<div class="Clear"></div>
</div>

<div class="Clear"></div>

<label>Serv Type:</label> <label class="value"><%= patient.getServiceType().getServiceTypeName()%></label>
<%
		if(!patient.getServiceType().getServiceTypeName().equals(serviceNameForCivilian)){
	%> <label>Serv Status:</label> <label class="value"><%= patient.getServiceStatus().getServiceStatusName()%></label>

<label>Service No:</label> <label class="value"><%= patient.getServiceNo()%></label>

<div class="Clear"></div>

<label>Relation:</label> <label class="value"><%= patient.getRelation().getRelationName()%></label>
<input type="hidden" id="relationId"
	value="<%=patient.getRelation().getId() %>" />

<div id="sCardDetailId"><label>I-Card Valid:</label> <%if(patient.getServiceCardStatus().equals("y")){ %>
<label class="small">Yes</label> <input type="radio" id="sCardIdY"
	name="<%=I_CARD_VERIFIED%>" value="y" checked
	onclick="upCheckServiceCardStatus(this.value);" class="radio"
	validate="I-Card Verif,string,no" tabindex="1" /> <label class="small">No</label>
<input type="radio" id="sCardIdN" name="<%=I_CARD_VERIFIED%>" value="n"
	onclick="upCheckServiceCardStatus(this.value);" class="radio"
	validate="I-Card Verif,string,no" tabindex="1" /> <%}else{ %> <label
	class="small">Yes</label> <input type="radio" id="sCardIdY"
	name="<%=I_CARD_VERIFIED%>" value="y"
	onclick="upCheckServiceCardStatus(this.value);" class="radio"
	validate="I-Card Verif,string,no" tabindex="1"> <label
	class="small">No</label> <input type="radio" id="sCardIdN"
	name="<%=I_CARD_VERIFIED%>" value="n" checked
	onclick="upCheckServiceCardStatus(this.value);" class="radio"
	validate="I-Card Verif,string,no" tabindex="1"> <%} %> <label>D_O_I
/ DCard:</label> <input type="text" id="depIssueDateId"
	name="<%=DEPENDENT_CARD_ISSUE_DATE %>"
	value="<%=patient.getDependentCardIssueDate()==null?"":HMSUtil.convertDateToStringWithoutTime(patient.getDependentCardIssueDate()) %>"
	readonly="readonly" validate="D_O_I Dep Card,date,no" class="calDate" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="setdate('',document.updateRegistration.<%=DEPENDENT_CARD_ISSUE_DATE%>,event)" />

<label>D-Card Valid</label> <input type="text" id="cardValidityId"
	name="<%=I_CARD_VALIDITY_DATE %>"
	value="<%=patient.getServiceCardValidityDate()==null?"":HMSUtil.convertDateToStringWithoutTime(patient.getServiceCardValidityDate()) %>"
	readonly="readonly" validate="I-Card Valid,date,no" class="calDate" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="setdate('',document.updateRegistration.<%=I_CARD_VALIDITY_DATE%>,event)" />

</div>
<!-- End of sCardDetailId --> <input type="hidden" id="serviceStatusId"
	name="<%=SERVICE_STATUS_ID %>"
	value="<%=patient.getServiceStatus().getId()%>"> <script
	type="text/javascript">
	<%
	if(patient.getServiceCardStatus().equals("n")){
	%>
	        document.getElementById('cardValidityId').value = "";
			document.getElementById('depIssueDateId').value = "";
			document.getElementById('cardValidityId').disabled = true;
			document.getElementById('depIssueDateId').disabled = true;
	<%}%>
</script> <%
			if(patient.getRank() != null){
			%> <label>Rank:</label> <select id="rankId" name="<%=RANK_ID%>"
	validate="Rank,string,yes" tabindex="1">
	<option value="0">Select</option>
	<% 		for(MasRank rank : rankList){
		                if(patient.getRank().getId() == rank.getId()){
		          	 %>
	<option value="<%=rank.getId()%>" selected="selected"><%=rank.getRankName()%></option>
	<%}else{ %>
	<option value="<%=rank.getId()%>"><%=rank.getRankName()%></option>
	<%}		
			}
			%>
</select> <%}else{ %> <label>Rank:</label> <select id="rankId" name="<%=RANK_ID%>"
	validate="Rank,string,yes" tabindex="1">
	<% for(MasRank rank : rankList){ %>
	<option value="<%=rank.getId()%>"><%=rank.getRankName()%></option>
	<%}} %>
</select> <label>First Name:</label> <input type="text" id="sFirstNameId"
	name="<%=S_FIRST_NAME %>" value="<%=patient.getSFirstName() %>"
	onchange="fillPatientName(this);" validate="First Name,name,yes"
	onchange=";" MAXLENGTH="15" /> <label>Middle Name:</label> <%if( patient.getSMiddleName() != null && !(patient.getSMiddleName().equals(""))){%>
<input type="text" id="sMiddleNameId" name="<%=S_MIDDLE_NAME%>"
	value="<%=patient.getSMiddleName()%>" onchange="fillPatientName(this);"
	validate="Middle Name,name,no" MAXLENGTH="15" /> <%}else{ %> <input
	type="text" id="sMiddleNameId" name="<%=S_MIDDLE_NAME%>" value=""
	onchange="fillPatientName(this);" validate="Middle Name,name,no"
	MAXLENGTH="15" /> <%} %> <label>Last Name:</label> <%if( patient.getSLastName() != null && !(patient.getSLastName().equals(""))){%>
<input type="text" id="sLastNameId" name="<%=S_LAST_NAME %>"
	value="<%=patient.getSLastName() %>" onchange="fillPatientName(this);"
	validate="Last Name,name,no" MAXLENGTH="15" /> <%}else{ %> <input
	type="text" id="sLastNameId" name="<%=S_LAST_NAME %>" value=""
	onchange="fillPatientName(this);" validate="Last Name,name,no"
	MAXLENGTH="15" /> <%} %> 
	<label> <span>*</span> Trade:</label> 
	<%if(patient.getTrade() != null){%> 
	<select id="tradeId" name="<%=TRADE_ID%>" validate="trade,string,yes" tabindex="1" onblur="displayAddressForTrade();">
	<option value="0">Select</option>
	<% for(MasTrade trade : tradeList){ 
		   if(patient.getTrade().getId() == trade.getId()){
		    %>
	<option value="<%=trade.getId()%>" selected="selected"><%=trade.getTradeName()%></option>
	<%}else{ %>
	<option value="<%=trade.getId()%>"><%=trade.getTradeName()%></option>

	<%}}} else {%>
	<select id="tradeId" name="<%=TRADE_ID%>" validate="trade,string,yes" tabindex="1" onblur="displayAddressForTrade();">
		<option value="0">Select</option>
		<% for(MasTrade trade : tradeList){ 
		    %>
		<option value="<%=trade.getId()%>"><%=trade.getTradeName()%></option>
		<%}
		} %>
	</select>

	<div class="Clear"></div>

	<label>Unit:</label>
	<select id="unitId" name="<%=UNIT_ID %>" onchange="displayAddress()"
		tabindex="1" validate="Unit,string,yes">
		<option value="0">Select</option>
		<% for(MasUnit masUnit : unitList){
						 if(masUnit.getLocalUnit() != null){
						 if(true){
							 if(patient.getUnit().getId() ==masUnit.getId()){
					 %>
		<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
		<%}else{ %>
		<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
		<%}}}}%>
		<option value="Other">Other</option>
	</select>

	<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
		style="cursor: pointer;"
		onClick="javascript:openPopupWindowForUnit();"
		title="Click here to Search Unit">

	<div id="addUnitDiv" style="display: none;"><label> Unit
	Name:</label> <input id="newUnitId" type="text" name="<%=UNIT_NAME%>" value=""
		style="border: 1px solid #7f9db7; width: 130px;"
		validate="Unit Address,string,no" maxlength="30" tabindex="1" /> <label>
	Unit Address:</label> <input id="newUnitAddressId" type="text"
		name="<%=UNIT_ADDRESS %>" value=""
		style="border: 1px solid #7f9db7; width: 130px;"
		validate="Unit Address,string,no" maxlength="50" tabindex="1" /> <label>Is
	Local Unit:</label> <input type="checkbox" id="localUnit"
		name="<%=LOCAL_UNIT %>" value="y" style="width: 25px;" tabindex="1" />
	</div>
	<!-- addUnitDiv ends here  -->
	<div id="unitAddId"><label> Unit Address:</label> <%if(patient.getUnit() != null){%>
	<input id="<%=UNIT_ADDRESS %>" type="text" name="unitAdd"
		value="<%= patient.getUnit().getUnitAddress()%>"
		validate="Unit Address,string,no" maxlength="50" readonly="readonly" />
	<%}else{ %> <input id="<%=UNIT_ADDRESS %>" type="text" name="unitAdd"
		value="" validate="Unit Address,string,no" maxlength="50"
		readonly="readonly" validate="Unit Address,string,no" /> <% }%>
	</div>
<div id="addTradeDiv" style="display: none;">
<label >Trade Name:</label>

<%if(patient.getTrade()!=null){
if(patient.getTrade().getStatus().equals("t")){  %>
<input id="newTradeId" type="text" name="<%=TRADE_NAME%>" value="<%=patient.getTrade().getTradeName() %>"   validate="Trade Name,string,no" maxlength="30" tabindex="1"/>
<%}else if(patient.getTradeName()!=null && !patient.getTradeName().equals("")){ %>
<input id="newTradeId" type="text" name="<%=TRADE_NAME%>" value="<%=patient.getTradeName()%>"   validate="Trade Name,string,no" maxlength="30" tabindex="1"/>
<%}else{ %>
<input id="newTradeId" type="text" name="<%=TRADE_NAME%>" value=""   validate="Trade Name,string,no" maxlength="30" tabindex="1"/>
<%}}else { %>
<input id="newTradeId" type="text" name="<%=TRADE_NAME%>" value=""   validate="Trade Name,string,no" maxlength="30" tabindex="1"/>
<%} %>
</div>
	<%} %>
</div>
<!-- blockFrame Ends here -->

<div class="Clear"></div>


<!-- Patient details  section Starts-->

<div class="blockTitle">PATIENT DETAILS</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame"><label>Title:</label> <select
	id="titleId" name="<%=TITLE%>" validate="Title,string,no">
	<option value="0">Select</option>
	<%
			 	for (MasTitle masTitle : titleList) { 
			 	%>
	<option value="<%=masTitle.getId()%>"><%=masTitle.getTitleName()%></option>
	<%
				}%>

</select> <script type="text/javascript">
         	 <%  if(patient.getTitle() != null){
			 			int titleId = patient.getTitle().getId() ;
					%>
					document.updateRegistration.<%=TITLE%>.value = '<%=titleId %>';
               <%		
			 		}%>
</script>

<div class="Clear"></div>

<label><span>*</span>First Name:</label> <input type="text"
	id="pFirstNameId" name="<%=P_FIRST_NAME %>"
	value="<%=patient.getPFirstName() %>" validate="First Name,name,yes"
	onchange="checkPatientRegistration();" MAXLENGTH="15" /> <label>Middle
Name:</label> <%if(patient.getPMiddleName() != null && !(patient.getPMiddleName().equals(""))){
%> <input type="text" id="pMiddleNameId" name="<%=P_MIDDLE_NAME%>"
	value="<%= patient.getPMiddleName()%>" validate="Middle Name,name,no"
	MAXLENGTH="15" /> <%}else{
            %> <input type="text" id="pMiddleNameId"
	name="<%=P_MIDDLE_NAME%>" value="" validate="Middle Name,name,no"
	MAXLENGTH="15" /> <%} %> <label>Last Name:</label> <% 
           	if( patient.getPLastName() != null && !(patient.getPLastName().equals(""))){
           	%> <input type="text" id="pLastNameId"
	name="<%=P_LAST_NAME %>" value="<%=patient.getPLastName() %>"
	validate="Last Name,name,no" MAXLENGTH="15" /> <%}else{ %> <input
	type="text" id="pLastNameId" name="<%=P_LAST_NAME %>" value=""
	validate="Last Name,name,no" MAXLENGTH="15" /> <%} %>

<div class="Clear"></div>

<label><span>*</span> Gender:</label>
<td><select name="<%=GENDER %>" validate="Gender,string,yes">
	<%
  		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
				%>
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%
  		   	 	} %>
</select> <script type="text/javascript">
          	<%  if(patient.getSex() != null){
			 			int sexId = patient.getSex().getId() ;
					%>
					document.updateRegistration.<%=GENDER%>.value = '<%=sexId %>';
               <%		
			 		}%>
</script> <label>DOB</label> <%if(patient.getDateOfBirth() != null){ %> <input
	type="text" id="dobId" name="<%=DATE_OF_BIRTH %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(patient.getDateOfBirth()) %>"
	readonly="readonly" validate="Date of Birth,date,no" MAXLENGTH="30"
	class="calDate" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('',document.updateRegistration.<%=DATE_OF_BIRTH%>,event)" />

<%}else{ %> <label class="value">-<label> <%} %> <label>Age:</label>

<%
if(patient.getAge() != null){
	String age = "";
	String currentAge = "";
	age = patient.getAge();
	currentAge = HMSUtil.calculateAge(age, patient.getRegDate(),patient.getDateOfBirth());
	patient.setAge(currentAge);
%> <label class="value"><%= patient.getAge()%></label> <%} %>
<div class="Clear"></div>

<label><span>*</span> Religion:</label> <select name="<%=RELIGION %>"
	validate="Religion,string,yes">
	<option value="0">Select</option>
	<%
			 for(MasReligion masReligion : religionList){
			%>
	<option value="<%=masReligion.getId()%>"><%=masReligion.getReligionName()%></option>
	<%
			}%>
</select> <script type="text/javascript">
          	<%  if(patient.getReligion()  != null){
			 			int religionId = patient.getReligion() .getId() ;
					%>
					document.updateRegistration.<%=RELIGION%>.value = '<%=religionId %>';
               <%		
			 		}%>
</script> <label>Address:</label> <%
            	if(patient.getAddress() != null){
            %> <textarea name="<%=ADDRESS %>" cols="20" rows="2"
	validate="Address,string,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=patient.getAddress() %></textarea>
<%}else{ %> <textarea name="<%=ADDRESS %>" cols="20" rows="2"
	validate="Address,string,no" class="txtarea"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<%} %> <label>Block:</label> <select name="<%=BLOCK%>"
	validate="Block,string,no"
	onChange="populatePincode(this.value,'registration')">
	<option value="0">Select</option>
	<%
		    	for(MasBlock masBlock : blockList){
		    		if(masBlock.getDistrict() != null){
		    			if(masBlock.getDistrict().getDistrictCode().equals(bangaloreDistrictCode)){
		    		%>
	<option value="<%=masBlock.getId() %>"><%=masBlock.getBlockName() %></option>
	<%}
		    		}
		    	} 
		    	%>
</select> <script type="text/javascript">
          		<%  if(patient.getBlock()  != null){
			 			int blockId = patient.getBlock().getId() ;
					%>
					document.updateRegistration.<%=BLOCK%>.value = '<%=blockId %>';
               <%		
			 		}%>
</script>

<div class="Clear"></div>

<label><span>*</span> City/District:</label> <select
	name="<%=DISTRICT%>" validate="District,string,yes"
	onChange="populateBlock(this.value,'updateRegistration')">
	<option value="0">Select</option>
	<%
				for(MasDistrict masDistrict : districtList){
				%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%								
				}%>
</select> <script type="text/javascript">
	          	<%  if(patient.getDistrict()  != null){
				 			int districtId = patient.getDistrict().getId() ;
						%>
						document.updateRegistration.<%=DISTRICT%>.value = '<%=districtId %>';
	               <%		
				 		}%>
</script> <label><span>*</span> State:</label> <select name="<%=STATE%>"
	validate="State,string,yes"
	onChange="populateDistrict(this.value,'updateRegistration')">
	<option value="0">Select</option>
	<%
				for(MasState masState : stateList){
					 %>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%				
				}%>
</select> <script type="text/javascript">
	          	<%  if(patient.getState()  != null){
				 			int stateId = patient.getState() .getId() ;
						%>
						document.updateRegistration.<%=STATE%>.value = '<%=stateId %>';
	               <%		
				 		}%>
</script> <script type="text/javascript">
			
			<%
			int counter=0;
			for (MasCountry masCountry : countryList) 
			{
				for (MasState masState : stateList) 
				{
					if(masState.getCountry() != null){
						if(masCountry.getId().equals(masState.getCountry().getId())){
								%>
									stateArr[<%=counter%>] = new Array();
									stateArr[<%=counter%>][0] = <%=masCountry.getId()%>;
									stateArr[<%=counter%>][1] = <%=masState.getId()%>;									
									stateArr[<%=counter%>][2] = "<%=masState.getStateName()%>";
								<%
								counter++;
						}
					}
				}
			}
		%>
</script> <label><span>*</span> Country:</label> <select
	name="<%= NATIONALITY %>" validate="Nationality,string,yes"
	onChange="populateState(this.value,'updateRegistration')">
	<option value="0">Select</option>
	<%
			 for(MasCountry cntMaster : countryList)
			 {
				 %>
	<option value="<%=cntMaster.getId()%>"><%=cntMaster.getCountryName()%></option>
	<%
			}%>
</select> <script type="text/javascript">
	          	<%  if(patient.getCountry()  != null){
				 			int countryId = patient.getCountry().getId() ;
						%>
						document.updateRegistration.<%=NATIONALITY%>.value = '<%=countryId %>';
	               <%		
				 		}%>
</script>

<div class="Clear"></div>

<label>Pincode:</label> <%
            if(patient.getPinCode() != null){
            %> <input type="text" name="<%=PINCODE %>"
	value="<%=patient.getPinCode() %>" validate="Pincode,int,no"
	maxlength="8" /> <%}else{ %> <input type="text" name="<%=PINCODE %>"
	value="" validate="Pincode,int,no" maxlength="8" /> <%} %> <label>Patient
Dist:</label> <select name="<%=PATIENT_DISTRICT%>"
	validate="Patient District,string,yes" tabindex="1">
	<option value="">Select</option>
	<%
			for(MasDistrict masDistrict : districtList){
				
				%>

	<option value="<%=masDistrict.getDistrictName()%>"><%=masDistrict.getDistrictName() %></option>
	<%				
				}%>
</select> <script type="text/javascript">
	          	<%  if(patient.getPatientDistrict()  != null){
				 			String patientDistrict = patient.getPatientDistrict();
						%>
						document.updateRegistration.<%=PATIENT_DISTRICT%>.value = '<%=patientDistrict %>';
	               <%		
				 		}%>
</script> <label>Post Office:</label> <%
            if(patient.getPostOffice() != null){
            %> <input type="text" name="<%=POST_OFFICE %>"
	value="<%=patient.getPostOffice() %>"
	validate="Post Office,alphaspace,no" MAXLENGTH="30" /> <%}else{ %> <input
	type="text" name="<%=POST_OFFICE %>" value=""
	validate="Post Office,alphaspace,no" MAXLENGTH="30" /> <%} %>

<div class="Clear"></div>

<label>Police Stat:</label> <%
            if(patient.getPoliceStation() != null){
            %> <input type="text" name="<%=POLICE_STATION %>"
	value="<%=patient.getPoliceStation() %>"
	validate="Police Station,alphaspace,no" MAXLENGTH="30" /> <%}else{ %> <input
	type="text" name="<%=POLICE_STATION %>" value=""
	validate="Police Station,alphaspace,no" MAXLENGTH="30" /> <%} %> <label>Phone:</label>
<%
            if(patient.getPhoneNumber() != null){
            %> <input type="text" name="<%=PHONE %>"
	value="<%=patient.getPhoneNumber() %>" validate="Phone,phone,no"
	MAXLENGTH="16" /> <%}else{ %> <input type="text" name="<%=PHONE %>"
	value="" validate="Phone,phone,no" MAXLENGTH="16" /> <%} %> <label>Mobile:</label>
<%
            if(patient.getMobileNumber() != null){
            %> <input type="text" name="<%=MOBILE %>"
	value="<%=patient.getMobileNumber() %>"
	validate="Mobile Number,phone,no" MAXLENGTH="12" /> <%}else{ %> <input
	type="text" name="<%=MOBILE %>" value=""
	validate="Mobile Number,phone,no" MAXLENGTH="12" /> <%} %>

<div class="Clear"></div>

<label>Email Id:</label> <%
            if(patient.getEmailId() != null){
            %> <input type="text" name="<%=EMAIL_ID %>"
	value="<%= patient.getEmailId()%>" validate="Email Id,email,no"
	MAXLENGTH="40" /> <%}else{ %> <input type="text" name="<%=EMAIL_ID %>"
	value="" validate="Email Id,email,no" MAXLENGTH="40" /> <%} %> <label>Occupation:</label>
<select name="<%=OCCUPATION_ID %>" validate="Occupation,string,no">
	<option value="0">Select</option>
	<%
			 for(MasOccupation masOccupation : occupationList){
				 %>
	<option value="<%=masOccupation.getId()%>"><%=masOccupation.getOccupationName()%></option>
	<%
                }%>
</select> <script type="text/javascript">
	          	<%  if(patient.getOccupation()  != null){
				 			int occupationId = patient.getOccupation() .getId() ;
						%>
						document.updateRegistration.<%=OCCUPATION_ID%>.value = '<%=occupationId %>';
	               <%		
				 		}%>
	            </script> <label>Marital Status:</label> <select
	name="<%=MARITAL_STATUS_ID %>" validate="Marital Status,string,no">
	<option value="0">Select</option>
	<%
			 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
				 %>
	<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
	<%
                }%>
</select> <script type="text/javascript">
	          	<%  if(patient.getMaritalStatus()  != null){
				 			int maritalStatusId = patient.getMaritalStatus().getId() ;
						%>
						document.updateRegistration.<%=MARITAL_STATUS_ID%>.value = '<%=maritalStatusId %>';
	               <%		
				 		}%>
</script>

<div class="Clear"></div>

<label>Blood Group:</label> <select name="<%=BLOOD_GROUP_ID %>"
	validate="Blood Group,string,no">
	<option value="0">Select</option>
	<%
			 for(MasBloodGroup masBloodGroup : bloodGroupList){
				%>
	<option value="<%=masBloodGroup.getId()%>"><%=masBloodGroup.getBloodGroupName()%></option>
	<%
                }%>
</select> <script type="text/javascript">
	          	<%  if(patient.getBloodGroup()  != null){
				 			int bloodGroupId = patient.getBloodGroup() .getId() ;
						%>
						document.updateRegistration.<%=BLOOD_GROUP_ID%>.value = '<%=bloodGroupId %>';
	               <%		
				 		}%>
</script>

<div class="Clear"></div>

<label>Mother Hin No.:</label> <%if(patient.getMotherHinNo() != null){
					if(!patient.getMotherHinNo().equals("0")){%> <input
	id="motherHinId" type="text" name="<%=MOTHER_HIN_NO %>"
	value="<%=patient.getMotherHinNo() %>"
	validate="Mother's Hin,string,no" MAXLENGTH="50"
	onBlur="getMotherName();" /> <%}else{%> <input id="motherHinId"
	type="text" name="<%=MOTHER_HIN_NO %>" value=""
	validate="Mother's Hin,string,no" MAXLENGTH="50"
	onBlur="getMotherName();" /> <%}}else{ %> <input id="motherHinId"
	type="text" name="<%=MOTHER_HIN_NO %>" value=""
	validate="Mother's Hin,string,no" MAXLENGTH="50"
	onBlur="getMotherName();" /></td>
<%} %>

<div class="Clear"></div>

<label>Mother's Name</label> <!-- <div id="motherNameId" style="display: none;"></div> -->
<label id="motherNameId" style="display: none;" class="value">&nbsp;</label>


<%
        String fileSeparator = System.getProperty("file.separator");
    	if(documentList!=null && documentList.size()>0){ 
    		for(int i=0;i<documentList.size();i++){
    			
    		String imgfile = uploadURL+documentList.get(0).getFileName()+"."+documentList.get(0).getFileExtension() ;
       %>
       <label>Patient Photo:</label>
       
       <img id="img1" src="<%="/hms/photo/"+documentList.get(0).getFileName()%>.<%=documentList.get(0).getFileExtension()%>"
			 width="100px" height="100px" />
 <%}
    		}%> 
    		
<div class="Clear"></div>
</div>
<!-- blockframe Ends here --> <!-- Patient details  section Ends-->

<div class="Clear"></div>

<!-- Visit details  section Starts-->

<div class="blockTitle">Visit Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<%
                  	if(visitList.size() > 0){
                  		for(Visit visitObj :visitList){
                  %> <label>Complaint:</label> <%
                  	if(visitObj.getComplaintString() != null){
                  	%> <label class="value"><%= visitObj.getComplaintString()%></label>
<%} %> <label> Department:</label> <%
                  	if(visitObj.getDepartment() != null){
                  	%> <label class="value"><%= visitObj.getDepartment().getDepartmentName()%></label>
<%} %> <label>Consulting Doc.</label> <%
                  	if(visitObj.getDoctor() != null){
                  	%> <label class="value"><%= visitObj.getDoctor().getFirstName()%>
<%=  visitObj.getDoctor().getLastName()%></label> <%} %> <label>Case Type:</label>

<%
                  	if(visitObj.getCaseType() != null){
                  	%> <label class="value"><%= visitObj.getCaseType().getCaseTypeName()%></label>
<%} %> <label>Diagnosis:</label> <%if(visitObj.getDiagnosisString()!=null){ %>
<label class="value"><%= visitObj.getDiagnosisString()%></label> <%} %> <label>Token
No.:</label> <label class="value"><%=visitObj.getTokenNo() %> </label> <%} 
			}%>

<div class="Clear"></div>
</div>
<!-- blockFrame Ends here --> <!-- Visit details  section Ends-->

<div class="Clear"></div>

<!-- Next of KIN details  section  starts-->

<div class="blockTitle collapsetag"
	onClick="togPlus('suggestion-box1',expand_bca);">Next Of Kin
Details <IMG id=expand_bca alt=Expand src="/hms/jsp/images/plus1.gif"
	; align=left /></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id=suggestion-box1 style="display: none;">
<div class=blockFrame><label>NOK Name:</label> <%
                    	if(patient.getNextOfKinName() != null){
                    %> <input type="text" name="<%=RELATIVE_NAME %>"
	value="<%=patient.getNextOfKinName() %>"
	validate="Kin Name,fullName,no" maxlength="30" /> <%}else{ %> <input
	type="text" name="<%=RELATIVE_NAME %>" value=""
	validate="Kin Name,fullName,no" maxlength="30" /> <%} %>
	<label>NOK Relation</label>
	 <select name="<%=RELATION_ID%>" validate="Kin Relation,string,no">
	<% 		for(MasRelation relation : relationList){
		if(patient.getNextOfKinRelation()!=null){
		                if(patient.getNextOfKinRelation().getId() == relation.getId()){
		          	 %>
	<option value="<%=relation.getId()%>" selected="selected"><%=relation.getRelationName()%></option>
	<%}
		else{ %>
	<option value="<%=relation.getId()%>"><%=relation.getRelationName()%></option>
	<%}		
		}
			}
			%>
</select> 
 <script type="text/javascript">
		          	<%  if(patient.getNextOfKinRelation()  != null){
					 			int nokRelationId = patient.getNextOfKinRelation() .getId() ;
							%>
							document.updateRegistration.<%=RELATION_ID%>.value = '<%=nokRelationId %>';
		               <%		
					 		}%>
</script> <label>NOK Address:</label> <%
                    	if(patient.getNextOfKinAddress() != null){
                    %> <textarea name="<%=EMERGENCY_ADDRESS %>"
	validate="Kin Address,string,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="50" />
					<%= patient.getNextOfKinAddress() %></textarea> <%}else{ %> <textarea
	name="<%=EMERGENCY_ADDRESS %>" validate="Kin Address,string,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="50" />
</textarea> <%} %> 



<label>NOK Phone:</label> <%
                    	if(patient.getNextOfKinPhoneNumber() != null){
                    %> <input type="text" name="<%=EMERGENCY_PHONE %>"
	value="<%= patient.getNextOfKinPhoneNumber()%>"
	validate="Kin Phone,phone,no" maxlength="16" /> <%}else{ %> <input
	type="text" name="<%=EMERGENCY_PHONE %>" value=""
	validate="Kin Phone,phone,no" maxlength="16" /> <%} %>
<div class="Clear"></div>
</div>
<!-- blockFrame Ends here --></div>
<!-- suggestion-box1 ends here --> <!-- Next of KIN details  section  ends-->

<div class="Clear"></div>

<!-- OTHER DETAILS  section  starts-->
<div class="blockTitle collapsetag"
	onClick="togPlus('suggestion-box',expand_bca1);">Other Details <IMG
	id=expand_bca1 alt=Expand src="/hms/jsp/images/plus1.gif" ; align=left />
</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id=suggestion-box style="display: none;">
<div class=blockFrame><label>RecordOff Add:</label> <select
	name="<%=RECORD_OFFICE_ADDRESS_ID %>"
	validate="RecordOff Addrs,string,no" style="width: 140px;">
	<option value="0">Select</option>
	<%
					for(MasRecordOfficeAddress masRecordOfficeAddress : recordOfficeAddressList){
						%>
	<option value="<%=masRecordOfficeAddress.getId() %>"><%=masRecordOfficeAddress.getAddress() %></option>
	<% 		
					
				}%>
</select> <script type="text/javascript">
		          	<%  if(patient.getRecordOfficeAddress()  != null){
					 			int roAddId = patient.getRecordOfficeAddress() .getId() ;
							%>
							document.updateRegistration.<%=RECORD_OFFICE_ADDRESS_ID%>.value = '<%=roAddId %>';
		               <%		
					 		}%>
</script> <label>Formation:</label> <%
                if(patient.getFormation() != null){
                %> <input id="formation" type="text"
	name="<%=FORMATION_ID %>" value="<%=patient.getFormation() %>"
	validate="Formation,alphaspace,no" maxlength="30"> <%}else{ %> <input
	id="formation" type="text" name="<%=FORMATION_ID %>" value=""
	validate="Formation,alphaspace,no" maxlength="30"> <%} %>
	<label ><span>*</span>Total Service :</label>			
	<input id="totalServYrs" type="hidden" name="" value=""/>

	<div id="totalService" style="display: block;"> 
	<select id="" name="<%=TOTAL_SERVICE%>" validate="Total Service ,string,no" tabindex="1" class="date">
		
	<%
	for(int age1=0;age1<=100;age1++){
		
		                if(patient.getServiceYears()!=null && patient.getServiceYears().intValue() == age1){  %>
	<option value="<%=age1%>" selected="selected"><%=patient.getServiceYears().intValue() %></option>
	<%}else{ %>
	<option value="<%=age1%>"><%=age1%></option>
	<%}}		
			%>
        </select>
<select id="servicePeriod" name="<%=TOTAL_SERVICE_PERIOD%>"  tabindex="1" class="year">
<%
if(patient.getTotalServicePeriod()!=null){
if(patient.getTotalServicePeriod().equalsIgnoreCase("Years")){ %>
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
<%}else if(patient.getTotalServicePeriod().equalsIgnoreCase("Months")){ %>
	<option selected="selected" value="Months">Months</option>
    <option value="Years">Years</option>
    <option value="Days">Days</option>
<%}else if(patient.getTotalServicePeriod().equalsIgnoreCase("Days")){ %>
	<option selected="selected" value="Days">Days</option>
 	<option value="Years">Years</option>
    <option value="Months">Months</option>
<%}}else{ %>
            <option selected="selected" value="Years">Years</option>
            <option value="Months">Months</option>
            <option value="Days">Days</option>
            <%} %>
            </select>	

<div class="Clear"></div>

<label>CDA AcntNo:</label> <%
                if(patient.getCdaAccountNo() != null){
                %> 
       <input type="text" name="<%=CDA_ACCOUNT_NO %>" value="<%= patient.getCdaAccountNo()%>" maxlength="15" />
        <%}else{ %>
      <input type="text" name="<%=CDA_ACCOUNT_NO %>" value="" maxlength="15" /> <%} %>
      
      
       <label>Station:</label>

<%
                if(patient.getStation() != null){
                %> <input type="text" name="<%=STATION %>"
	value="<%= patient.getStation()%>" validate="Station,alphaspace,no"
	maxlength="15" /> <%}else{ %> <input type="text" name="<%=STATION %>"
	value="" validate="Station,alphaspace,no" maxlength="15" /> <%} %> <label>Reference:</label>
<select name="<%=REFERENCE %>" validate="Reference,string,no"
	style="width: 140px;">
	<option value="0">Select</option>
	<%
					 for(MasReference masReference : referenceList){
						%>
	<option value="<%=masReference.getId()%>"><%=masReference.getReferenceName()%></option>
	<%
                  }%>
</select> <script type="text/javascript">
		          	<%  if(patient.getReference()  != null){
					 			int referenceId = patient.getReference() .getId() ;
							%>
							document.updateRegistration.<%=REFERENCE%>.value = '<%=referenceId %>';
		               <%		
					 		}%>
</script>

<div class="Clear"></div>

<label>Remarks:</label> <%
                	if(patient.getRemarks() != null){
                %> <textarea name="<%=REMARKS %>" cols="44" rows="3"
	validate="Remarks,string,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	class="large"><%=patient.getRemarks() %></textarea> <%}else{ %> <textarea
	name="<%=REMARKS %>" cols="44" rows="3" validate="Remarks,string,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	class="large"></textarea> <%} %>
<div class="Clear"></div>
</div>
<!-- blockFrame Ends Here --></div>
<!-- suggestion-box Ends here --> <!-- OTHER DETAILS  section  ends-->
</div>
<div class="Clear"></div>


<div class="bottom">
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" /> <!--<div id="searchbar"> -->
<div id="edited"></div>
<input type="button" name="Submit" value="Update" class="button" onClick="submitForm('updateRegistration','/hms/hms/registration?method=updatePatientInformation');" />
<input type="reset" name="Reset" value="Reset" class="button" 	onClick="location.reload();" accesskey="r" /> 
<%}	 }else{%> No record found!! <%} %> <!-- </div> -->
<div id="statusMessage" class="messagelabel"></div>

<div class="Clear"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<script type="text/javascript">
			<%
if(patientList!=null){
	Patient patient = (Patient)patientList.get(0);
	if(patient.getTrade()!=null){
	if(patient.getTrade().getId()==31 ){
%>

document.getElementById('addTradeDiv').style.display = 'inline';
<%}}}%>
</script>
</form>
</div>
