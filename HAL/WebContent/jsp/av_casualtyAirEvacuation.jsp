
<%@ page import="java.util.Calendar"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasUnit"%>
<%@ page import="jkt.hms.masters.business.MasTrade"%>
<%@ page import="jkt.hms.masters.business.MasRank"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.jgroups.protocols.TOTAL"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>

<%@page import="jkt.hms.masters.business.MasRecordOfficeAddress"%><script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
<!-- Script for tab content -->

/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
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
<form name="casualtyAirEvacuation" method="post" action="">
       <%
       Properties properties = new Properties();
       URL resourcePathHIC = Thread.currentThread().getContextClassLoader().getResource("hicDetails.properties");
       try {
       	properties.load(resourcePathHIC.openStream());
       } catch (Exception e) {
       	e.printStackTrace();
       }
       String urlForImportFromHIC = properties.getProperty("urlForImportFromHIC");
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
			List<MasUnit> unitHoldList = new ArrayList<MasUnit>();
			List<MasUnit> unitList = new ArrayList<MasUnit>();
			List<MasRank> rankList = new ArrayList<MasRank>();
			List<MasTrade> tradeList = new ArrayList<MasTrade>();
			List<MasAdministrativeSex> genderList=new ArrayList<MasAdministrativeSex>();
			List<MasAircraftType> aircraftTypeList=new ArrayList<MasAircraftType>();
			
			if(map.get("rankList") != null)	{
				rankList = (List<MasRank>)map.get("rankList");
			}
			if(map.get("tradeList") != null){
			tradeList =(List<MasTrade>)map.get("tradeList");
			}
			if(map.get("genderList") != null){
				genderList = (List<MasAdministrativeSex>)map.get("genderList");
			}
			if(map.get("unitList") != null){
					unitList =(List<MasUnit>)map.get("unitList");
				}
			if(map.get("unitHoldList") != null){
				unitHoldList =(List<MasUnit>)map.get("unitHoldList");
			}
			if(map.get("aircraftTypeList") != null){
				aircraftTypeList = (List<MasAircraftType>)map.get("aircraftTypeList");
			}
			
			String currentTime = (String)utilMap.get("currentTimeWithoutSc");
			
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<MasRecordOfficeAddress> recordOfficeAddressList =null;
			if(map.get("recordOfficeAddressList") != null){
				recordOfficeAddressList = (List<MasRecordOfficeAddress>)map.get("recordOfficeAddressList");
			}
			/*List<Object[]> serviceStatusList = null;
			List<Object[]> serviceTypeList =null;
			List<Object[]> rankList = null;
			List<Object[]> tradeList = null;
			List<Object[]> stationList = null;
			List<Object[]> sectionList = null;
			List<Object[]> commandList = null;
			List<Object[]> unitList = null;
			if(map.get("serviceStatusList") != null){
				serviceStatusList = (List<Object[]>)map.get("serviceStatusList");
			}
			if(map.get("serviceTypeList") != null){
				serviceTypeList= (List<Object[]>)map.get("serviceTypeList");
			}
			if(map.get("rankList") != null){
				rankList= (List<Object[]>)map.get("rankList");
			}
			if(map.get("tradeList") != null){
				tradeList= (List<Object[]>)map.get("tradeList");
			}
			if(map.get("sectionList") != null){
				sectionList= (List<Object[]>)map.get("sectionList");
			}
			if(map.get("unitList") != null){
				unitList= (List<Object[]>)map.get("unitList");
			}
			if(map.get("commandList") != null){
				commandList= (List<Object[]>)map.get("commandList");
			}
			if(map.get("stationList") != null){
				stationList= (List<Object[]>)map.get("stationList");
			}*/
			
			%>  

<div class="titleBg">
<h2>CASUALTY AIR EVACUATION</h2>
</div>
<div class="clear paddingTop15"></div>
<h4>Service Personnel Details</h4>
<div class="clear"></div>
<%---
<input type="hidden" name="<%=REG_DATE %>" value="<%=currentDate %>" validate="Registration Date,String,no" readonly="readonly"	class="calDate" /> 
<input type="hidden" name="<%=REG_TIME %>" value="<%=time %>" validate="Registration Time,string,no" maxlength="20"	readonly="readonly" class="calDate" />
<div class="Block">
<!--<label>HIN</label>
--><label id="defaulthinno" class="value" style="display: none;">&nbsp;</label>
<label id="hinNoDivId" class="value" style="display: none;"></label>
<input id="hinNoId" type="hidden" name="<%=HIN_NO %>" value="" />
<div class="clear"></div>

<label>Service No.<span>*</span></label>

<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1" validate="Service No,alphanumeric,yes" maxlength="20"
	onblur="submitProtoAjaxWithDivName('casualtyAirEvacuation','/hms/hms/aviationMedicine?method=getServiceNoDetailsForRegCasualty&serviceNo='+this.value,'patientDiv');"/>
<input 	id="prefix" name="<%=PREFIX%>" type="text" maxlength="3" class="auto" size="1"	tabindex="1" validate="Prefix,alphanumaric,no" /> 

<div id="patientDiv">
<div class="clear"></div>
<label> Service Status <span>*</span></label> 
<select	id="serviceStatusId" name="<%=SERVICE_STATUS_ID %>"
	validate="Service Status,string,yes" tabindex="1"
	onchange="getEchsNo();populateRank('casualtyAirEvacuation');getHin();">
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
<div id="exServiceId"></div>

<label>HIN</label>
<input type="text" value="" id="regHinId" name="regHinId"/>
<label>Service Type <span>*</span></label> 
<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>"	validate="Service Type,string,yes" tabindex="1"
	onchange="callFunctions(this.value)">
	<option value="0">Select</option>

	<% 
			for(Object[] masServiceType : serviceTypeList){
				if(masServiceType[0].equals(2)){
		%>
	<option value="<%=masServiceType[0] %>" selected="selected"><%=masServiceType[1] %></option>
	<%}else{ %>
	<option value="<%=masServiceType[0] %>"><%=masServiceType[1] %></option>
	<%}
				}%>
</select>
<div class="clear"></div>
<div id="rankDivId">
<label> Rank <span>*</span></label> 
<select	id="rankId" name="<%=RANK_ID%>" validate="Rank,string,yes" tabindex="1" onchange="">
	<option value="0">Select</option>
	<%
			 	for (Object[] masRank : rankList) 
				{
			 		if(masRank[2].equals(2)  && masRank[3].equals(1)){
			%>
	<option value="<%=masRank[0]%>"><%=masRank[1]%></option>
	<%
			 		}}%>
</select> 
</div> <!-- End Of rankDivId-->
<script type="text/javascript">
		
		<%
		int k=0;
		for (Object[] masServiceStatus : serviceStatusList) 
		{
			for (Object[] masRank : rankList) 
			{
				if(masRank[3] != null){
					if(masServiceStatus[0].equals(masRank[3])){
							%>
								rankArr[<%=k%>] = new Array();
								rankArr[<%=k%>][0] = <%=masServiceStatus[0]%>;
								rankArr[<%=k%>][1] = <%=masRank[2]%>;
								rankArr[<%=k%>][2] = <%=masRank[0]%>;									
								rankArr[<%=k%>][3] = "<%=masRank[1]%>";
							<%
							k++;
					}
				}
			}
		}
		%>
</script>

<label>First Name <span>*</span></label> 
<input id="sFNameId" type="text" name="<%=S_FIRST_NAME %>" value="" tabindex="1"	title="First Name of Service Person"	validate="First Name of Service Person,alphaspace,yes" MAXLENGTH="15"	onblur="fillPatientName(this);" /> 

<label>Middle Name</label> 
<input	id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value=""	tabindex="1" validate="Middle Name of Service Person,alphaspace,no"	MAXLENGTH="15" onchange="fillPatientName(this);" />
<div class="clear"></div>
<label>Last Name</label> 
<input id="sLNameId" type="text"	name="<%=S_LAST_NAME %>" value="" tabindex="1"	validate="Last Name of Service Person,alphaspace,no" MAXLENGTH="15"	onchange="fillPatientName(this);" />

<div id="srPrDtDiv">
<label> Trade/Branch</label> 
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,string,no" tabindex="1"	onchange="displayOtherTrade(this.value);">
	<option value="0">Select</option>
	<%for(Object[] trade :tradeList){ %>
	<option value=<%=trade[0]%>><%=trade[1] %></option>
	<%} %>
	<option value="other">Other</option>
</select>

<label> DOE/DOC</label> 
<input type="text"	id="commissionDateId" name="commissionDate" tabindex="1" value=""	validate="commission Date,date,no" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');"	class="calDate" onblur="validateExpDate(this,'commissionDateId');calculateTotalService(this.value);" /> 
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


<label>Section</label> 
<select id="sectionId" name="<%=SECTION_ID%>"	validate="Section,string,no" tabindex="1"	onblur="displayOtherSec(this.value)">
	<option value="0">Select</option>
	<%
	 for(Object[] masSection : sectionList){
		
	 %>
	<option value="<%=masSection[0]%>"><%=masSection[1]%></option>

	<%}
	%>
	<option value="other">Other</option>

</select>

<label>Unit <span>*</span></label> 
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,string,yes" onchange="displayOtherUnit(this.value);populateStationForUnit(this.value);">
	<option value="0">Select</option>
	<%
		 for(Object[] masUnit : unitList){
		 %>
	<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
	<%
	 }%>
	<option value="other">Other</option>
</select>
<div class="clear"></div>
<label>Station</label> 
<input type="text" id="stationId" name="<%=STATION %>" value=""/>
<label> Command</label> 
<select id="commandId" name="<%=COMMAND %>"	validate="Command,string,no" tabindex="1"	onchange="displayOtherCmd(this.value);">
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
<script type="text/javascript">
		
		<%
			int n=0;
			for (Object[] masCommand : commandList) 
			{
				for (Object[] masStation : stationList) 
				{
					if(masStation[2] != null){
						if(masCommand[0].equals(masStation[2])){
								%>
									stnArr[<%=n%>] = new Array();
									stnArr[<%=n%>][0] = <%=masCommand[0]%>;
									stnArr[<%=n%>][1] = <%=masStation[2]%>;
									stnArr[<%=n%>][2] = "<%=masStation[1]%>";									
									stnArr[<%=n%>][3] = "<%=masStation[1]%>";
								<%
								n++;
						}
					}
				}
			}
		%>
		
		<%
			int m=0;
			for (Object[] stn : stationList) 
			{
				for (Object[] unit : unitList) 
				{
					if(unit[2]!= null){
						if(stn[1].equals(unit[2])){
								%>
									unitArr[<%=m%>] = new Array();
									unitArr[<%=m%>][0] = <%=stn[0]%>;
									unitArr[<%=m%>][1] = "<%=unit[2]%>";
									unitArr[<%=m%>][2] = <%=unit[0]%>;									
									unitArr[<%=m%>][3] = "<%=unit[1]%>";
								<%
								m++;
						}
					}
				}
			}
			
		%>
</script>
<label > Record Office</label>
<select id="recordOffId" name="<%=RECORD_OFFICE_ADDRESS_ID %>" validate="RecordOff Addrs,string,no"  tabindex="1">
<option value="0">Select</option>
<%
for (MasRecordOfficeAddress masRecordOfficeAddress : recordOfficeAddressList) 
{
%>
<option value="<%= masRecordOfficeAddress.getId() %>"><%= masRecordOfficeAddress.getAddress()%></option>
<%} %>
</select>
</div><!-- End srPrDtDiv-->
<div class="clear"></div>

<!-- End Block 1--> --%>
<div class="Block">
<label>Service No.<span>*</span></label>

<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1" validate="Service No,metachar,yes" maxlength="20"
	onblur="submitProtoAjaxWithDivName('casualtyAirEvacuation','/hms/hms/aviationMedicine?method=getServiceNoDetailsForRegCasualty&serviceNo='+this.value,'patientDiv');"/>

<input 	id="prefix" name="<%=PREFIX%>" type="text" maxlength="3" class="auto" size="1"	tabindex="1" validate="Prefix,metachar,no" /> 
</div>
<div id="patientDiv">

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Date</label> 
<input type="text" id="<%=DATE %>" name="<%=DATE %>"	tabindex="1" value="" readonly="readonly"	validate="Date,date,no" MAXLENGTH="7" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE%>,event)" />

<label>Time</label>
<input  name="<%=TIME %>" id="<%=TIME %>" type="text" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" maxlength="5" class="calDate"
onBlur="checkTime('casualtyAirEvacuation','<%=TIME%>');"/> 
<label class="unit2">Hrs.</label>

<div class="clear"></div>
<label> First Name <span>*</span></label> 
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"	title="First Name of the Patient"	validate="Patient First Name,name,yes" MAXLENGTH="30" />

<label>Middle Name</label> 
<input type="text" id="pMiddleNameId"	name="<%=P_MIDDLE_NAME%>" value="" tabindex="1"	validate="Patient Middle Name,name,no" MAXLENGTH="30" /> 

<label>Last Name</label> 
<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"	value="" validate="Patient Last Name,name,no" MAXLENGTH="30"	tabindex="1" /> 

<div class="clear"></div>
<label>Rank</label>
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1" >
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

<div class="clear paddingTop15"></div>
<h4>CASUALTY DETAILS</h4>
<div class="Block">	

<label>Date of Arrival</label> 
<input type="text" id="<%=DATE_CASUALTY_ARRIVAL %>" name="<%=DATE_CASUALTY_ARRIVAL %>"	tabindex="1" value="" readonly="readonly"	validate="Date of Arrival,date,no" MAXLENGTH="7" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE_CASUALTY_ARRIVAL%>,event)" />

<label>Time of Arrival</label>
<input  name="<%=TIME_CASUALTY_ARRIVAL %>" id="<%=TIME_CASUALTY_ARRIVAL %>" type="text" tabindex="1" maxlength="8"  class="calDate"/> 

<div class="clear"></div>

<label>Clinical Status</label>
<textarea rows="" cols="24"	name="<%=CLINICAL %>" id="<%=CLINICAL %>"  onkeyup="chkLength(this,30);"></textarea>
	
<label>Diagnosis</label>
<input type="text" name="<%=DIAGNOSIS %>" id="<%=DIAGNOSIS %>"  value="" 	validate="Diagnosis,metachar,no"  maxlength="30" readonly="readonly"/>
	
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
<select name="<%=CASUALTY %>"  id="casualty" class="">
<option value="Unloading">Unloading</option>
<option value="Loading">Loading</option>
</select>

<label>Date</label> 
<input type="text" id="<%=DATE_CASUALTY %>" name="<%=DATE_CASUALTY %>"	tabindex="1" value="" readonly="readonly"	validate="Date,date,no" MAXLENGTH="7" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.casualtyAirEvacuation.<%=DATE_CASUALTY%>,event)" />

<label>Time</label>
<input  name="<%=TIME_CASUALTY %>" id="<%=TIME_CASUALTY %>" type="text" tabindex="1" maxlength="11" /> 

<div class="clear"></div>

<label class="large">Diffculties Experienced during flight and emplaning</label>
<textarea rows="" cols="115" name="<%=DIFFCULTIES %>" id="<%=DIFFCULTIES %>" class="auto" onkeyup="chkLength(this,50);"></textarea>
	
<label class="large">Disposal of Casualty Belongings</label>
<textarea rows="" class="auto" cols="115" name="disposal"></textarea>

<%--<input type="text" name="<%=DISPOSAL %>" id="<%=DISPOSAL %>"  value="" 	validate="Diagnosis,string,no"  maxlength="30" class="auto" size="60"/> --%>
	
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
	<%	for(MasAircraftType masAircraftType : aircraftTypeList){%>
		<option value="<%=masAircraftType.getId() %>"><%=masAircraftType.getAircraftTypeName() %></option>
	<%	 	} %>
</select> 

<label> Case Sitting </label> 
<input type="radio" name="<%=RADIO_FOR_TABLE %>" id="<%=RADIO_FOR_TABLE %>"  value="s"/>
	
<label> Case Lying </label> 
<input type="radio" name="<%=RADIO_FOR_TABLE %>" id="<%=RADIO_FOR_TABLE %>"  value="l"  />
	
<div class="clear"></div>
	
<label>Total Duration including Station</label>
<input type="text" name="<%=TOTAL_DURATION %>" id="<%=TOTAL_DURATION%>"  value="" 	validate="Total duration By,int,no"  maxlength="22" readonly="readonly"/>

<label>Duration Holding</label>
<input type="text" name="<%=DURATION_HOLDING %>" id="<%=DURATION_HOLDING %>"  value="" 	validate="Inspected By,int,no"  maxlength="22" readonly="readonly"/>

<label>Enroute Holding Unit</label>

<select name="<%=ENROUTE_HOLDING_UNIT %>" id="<%=ENROUTE_HOLDING_UNIT %>"  tabindex="1"	>
<option value="0">Select</option>

	<%	for(MasUnit enrouteHoldingUnit : unitHoldList){	%>
		<option value="<%=enrouteHoldingUnit.getId() %>"><%=enrouteHoldingUnit.getUnitName() %></option>
	<% 	} %>
</select> 
	 </div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>
<input type="button" class="button" name="Submit11" value="SUBMIT" 
onclick="submitForm('casualtyAirEvacuation','/hms/hms/aviationMedicine?method=submitCasualtyAirEvacuationJsp&flag=casual');" />
<input type="reset" name="Reset" value="Reset" class="button"	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>"  	validate="changed_time,metachar,no"/>
</div>
<script type="text/javascript">
function callFunctions(val){
	setTimeout("checkServiceType("+val+")", 800);
}
function displayOtherTrade(trd){
	if(trd=='other'){
		document.getElementById('addTradeDiv').style.display='inline';
		document.getElementById('newTradeId').setAttribute('validate','Trade Name,string,yes');
	}else{
		document.getElementById('addTradeDiv').style.display='none';
		document.getElementById('newTradeId').setAttribute('validate','Trade Name,string,no');
	}
}
function displayOtherUnit(unit){
	if(unit=='other'){
		document.getElementById('addUnitDiv').style.display='inline';
		document.getElementById('newUnitId').setAttribute('validate','Station Name,string,yes');
	}else{
		document.getElementById('addUnitDiv').style.display='none';
		document.getElementById('newUnitId').setAttribute('validate','Station Name,string,no');
	}
}
function populateStationForUnit(unit){
	var stn = 0;
	for(i=0;i<unitArr.length;i++){
		
		if(unitArr[i][2] == unit){
			stn = unitArr[i][1];
		break;		
			}
		}
	document.getElementById('stationId').value = stn;
	populateCommandForStation(stn);
}
function populateCommandForStation(stn){
	var cmd = 0;
	for(i=0;i<stnArr.length;i++){
		if(stnArr[i][2] == stn){
			cmd = stnArr[i][0];
		break;		
			}
		}
	document.getElementById('commandId').value = cmd;
}
</script>
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
</form>


