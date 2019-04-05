<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration.jsp  
 * Purpose of the JSP -  This is for Registration.
 * @author  Ritu
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.36
--%>
<spring:htmlEscape defaultHtmlEscape="true" />
<%@ page import="java.util.Calendar"%>

<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_STATUS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.RANK_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.TRADE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.UNIT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SECTION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.SEX_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_FIRST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_MIDDLE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_LAST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.S_FIRST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.S_MIDDLE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.S_LAST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.PREFIX"%>
<%@ page import="static jkt.hms.util.RequestConstants.SUFFIX"%>
<%@ page import="static jkt.hms.util.RequestConstants.TRADE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_YEARS"%>
<%@ page import="static jkt.hms.util.RequestConstants.TOTAL_SERVICE"%>
<%@ page import="static jkt.hms.util.RequestConstants.TOTAL_SERVICE_PERIOD"%>
<%@ page import="static jkt.hms.util.RequestConstants.UNIT_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.UNIT_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.STATION"%>
<%@ page import="static jkt.hms.util.RequestConstants.COMMAND"%>
<%@ page import="static jkt.hms.util.RequestConstants.RECORD_OFFICE_ADDRESS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_AGE"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_SEX"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_AGE_UNIT"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_DOB"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELIGION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.TELEPHONE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.MOBILE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.DISTRICT"%>
<%@ page import="static jkt.hms.util.RequestConstants.ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.PERMANENT_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.STATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_RELATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_PHONE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.REG_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.REG_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.TITLE"%>
<%@ page import="static jkt.hms.util.RequestConstants.GENDER"%>
<%@ page import="static jkt.hms.util.RequestConstants.AGE"%>
<%@ page import="static jkt.hms.util.RequestConstants.OCCUPATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.DATE_OF_BIRTH"%>
<%@ page import="static jkt.hms.util.RequestConstants.AGE_UNIT"%>
<%@ page import="static jkt.hms.util.RequestConstants.CONTACT_NUMBER"%>
<%@ page import="static jkt.hms.util.RequestConstants.BLOOD_GROUP_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR"%>
<%@ page import="static jkt.hms.util.RequestConstants.VISIT_NUMBER"%>
<%@ page import="static jkt.hms.util.RequestConstants.TOKEN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.DEPARTMENT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_BLOOD_GROUP_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_RELATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_PHONE_NO"%>

<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasTitle"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasReligion"%>
<%@ page import="jkt.hms.masters.business.MasOccupation"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hms.masters.business.MasBlock"%>
<%@ page import="jkt.hms.masters.business.MasServiceType"%>
<%@ page import="jkt.hms.masters.business.MasRank"%>
<%@ page import="jkt.hms.masters.business.MasUnit"%>
<%@ page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="jkt.hms.masters.business.MasTrade"%>
<%@ page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@ page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@ page import="jkt.hms.masters.business.MasReference"%>
<%@ page import="jkt.hms.masters.business.MasComplaint"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasCaseType"%>
<%@ page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="jkt.hms.masters.business.MasDisposal"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.Visit"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>

<%@page import="jkt.hms.masters.business.MasStation"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasReporting"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>

<%@page import="jkt.hms.masters.business.Category"%>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
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
<object id="objReadfingerprint"
	classid="5974956E-9411-4d1f-869A-004159999C0B"
	type="application/x-oleobject" codebase="../HICCARDUPDATE.cab"
	VIEWASTEXT></object>

<script type="text/javascript">

function checkoutToHic(){
var url = "http://localhost/HIC/Default.aspx";
window.open(url,'windowRef','left=0,top=0,width=600,height=400,scrollbars = yes');
}

    function ReadFingerPrint()
       {
          var obj = new ActiveXObject('Fingerprintreadclass.fingerprint');
        var ReaderStatus=obj.WriteReaderName('OMNIKEY CardMan 5x21-CL 0');
          var serviceno=obj.ReadServiceNo();
       //  var serviceno=document.getElementById('serviceNoId').value
           document.getElementById('Hidden3').value=serviceno;
         var fpinitial=obj.UltraSanInisalize(); 
        var fpstatus = obj.CheckFingerPrint();

      //     var fpstatus="true";
           document.getElementById('Hidden4').value = fpstatus;
           document.registration.action="/hms/hms/registration?method=getServiceNoDetailsFromHIC";
           document.registration.submit();
         }
       
       function UpdateCardInfo()
       {
          var hid1=document.getElementById('Hidden1');
          var hid2=document.getElementById('Hidden2');
          var CardUpdateInfo=hid1.value; 
          var RequestType=hid2.value;
          var obj = new ActiveXObject('Fingerprintreadclass.fingerprint');
          var CardStatus=obj.UpdateCard(CardUpdateInfo,RequestType);
          alert("Card Updated Success fully");
         
          hid1.value='';
          hid2.value='';  
       }

</script>

<form name="registration" method="post" action="">
       <%
       Properties properties = new Properties();
       URL resourcePathHIC = Thread.currentThread().getContextClassLoader().getResource("hicDetails.properties");
       try {
       	properties.load(resourcePathHIC.openStream());
       } catch (Exception e) {
       	e.printStackTrace();
       }
       String urlForImportFromHIC = properties.getProperty("urlForImportFromHIC");

       %>
<%	
	Box box  = HMSUtil.getBox(request);
int hinId = box.getInt("hinId");
int serviceTypeId = box.getInt("serviceTypeId");
int serviceNo = box.getInt("serviceNo");

			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String time = (String)utilMap.get("currentTimeWithoutSc");
	 
	 		Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
	
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			
			List<Object[]> serviceTypeList =null;
			List<Object[]> relationList = null;
			List<Object[]> rankList = null;
			List<Object[]> unitList = null;
			List<Object[]> titleList = null;
			List<Object[]> maritalStatusList = null;
			List<Object[]> tradeList = null;
			List<Object[]> religionList = null;
			List<Object[]> stateList = null;
			List<Object[]> districtList = null;
			List<MasRecordOfficeAddress> recordOfficeAddressList =null;
			List<Object[]> bloodGroupList = null;
			List<Object[]> occupationList = null;
			List<Object[]> doctorList = null;
			List<Object[]> sexList = null;
			List<Object[]> serviceStatusList = null;
			List<Object[]> stationList = null;
			List<Object[]> sectionList = null;
			List<Object[]> commandList = null;
			List<Object[]> familyHistoryList = null;
			if(map.get("serviceTypeList") != null){
				serviceTypeList= (List<Object[]>)map.get("serviceTypeList");
			}
			if(map.get("rankList") != null){
				rankList= (List<Object[]>)map.get("rankList");
			}
			if(map.get("unitList") != null){
				unitList= (List<Object[]>)map.get("unitList");
			}
			if(map.get("titleList") != null){
				titleList = (List<Object[]>)map.get("titleList");
			}
			if(map.get("maritalStatusList") != null){
				maritalStatusList = (List<Object[]>)map.get("maritalStatusList");
			}
			if(map.get("tradeList") != null){
				tradeList = (List<Object[]>)map.get("tradeList");
			}
			
			if(map.get("stateList") != null)	{
				stateList = (List<Object[]>)map.get("stateList");
			}
			if(map.get("districtList") != null){
				districtList =(List<Object[]>)map.get("districtList");
			}
			if(map.get("relationList") != null){
				relationList = (List<Object[]>)map.get("relationList");
			}
			if(map.get("bloodGroupList") != null){
				bloodGroupList = (List<Object[]>)map.get("bloodGroupList");
			}
			if(map.get("occupationList") != null){
				occupationList = (List<Object[]>)map.get("occupationList");
			}
			if(map.get("employeeList") != null){
				doctorList = (List<Object[]>)map.get("employeeList");
			}
			if(map.get("recordOfficeAddressList") != null){
				recordOfficeAddressList = (List<MasRecordOfficeAddress>)map.get("recordOfficeAddressList");
			}
			if(map.get("religionList") != null){
				religionList = (List<Object[]>)map.get("religionList");
			}
			if(map.get("sexList") != null){
				sexList = (List<Object[]>)map.get("sexList");
			}
			
			if(map.get("serviceStatusList") != null){
				serviceStatusList = (List<Object[]>)map.get("serviceStatusList");
			}
			if(map.get("stationList") != null){
				stationList = (List<Object[]>)map.get("stationList");
			}
			if(map.get("sectionList") != null){
				sectionList = (List<Object[]>)map.get("sectionList");
			}
			
			if(map.get("commandList") != null){
				commandList = (List<Object[]>)map.get("commandList");
			}
			if(map.get("familyHistoryList") != null){
			familyHistoryList = (List<Object[]>)map.get("familyHistoryList");
			}
			List<Object[]> categoryList= new ArrayList<Object[]>();
			if(map.get("categoryList") != null){
				categoryList=(List<Object[]>)map.get("categoryList");
			}
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String selectedTitleForReg = properties.getProperty("selectedTitleForReg");
			String administrativeSexMaleCode = properties.getProperty("administrativeSexMaleCode");
			String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
			
			ResultSet rs = null;
			ResultSet rsEmp = null;
			Map<String, Object> hicDtmap = new HashMap<String, Object>();
			if(map.get("hicDtmap")!= null){
				hicDtmap = (Map<String, Object>)map.get("hicDtmap");
			}
			
			if(hicDtmap.get("rsEmp")!= null){
				rsEmp = (ResultSet)hicDtmap.get("rsEmp");
			}
			%>  
<script type="text/javascript">
		<%
			int counter1 = 0;
			for (Object[] masState : stateList)
			{
				for (Object[] masDistrict : districtList) 
				{
					if(masDistrict[2] != null){
						if(masState[0].equals(masDistrict[2] )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masState[0]%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict[0]%>;									
									districtArray[<%=counter1%>][2] = "<%=(String)masDistrict[1]%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
</script> 
<script>
function hideMedExam(val){
	if(val=='dependent'){
	document.getElementById('med').style.display='none';
	}else{
		document.getElementById('med').style.display='inline';
	}
}
</script>
<div class="titleBg">
<h2>Patient Registration</h2>
</div>
<div class="clear"></div>
<ul id="countrytabsIn" class="shadetabsIn">
	<label><a href="#" rel="country1" class="selected" ><span  onclick="javascript:hideMedExam('self');">Service Personnel Details</span></a></label>
	<label><a href="#" rel="country2"><span onclick="javascript:hideMedExam('dependent');"> Dependent Details </span></a></label>
	
	<div id="srPhoto" class="photo">
	<div class="clear"></div>
	<img src="/hms/jsp/images/na.jpg" name="img1" width="105" height="80" id="img1" />
	<span style="color:#ddd">Date/ Time</span>
	</div>
</ul>

<div class="tabcontainerIn">
<div id="country1" class="tabcontentIn">
<h4>Service Details</h4>
<div class="clear"></div>

<input type="hidden" name="<%=REG_DATE %>" value="<%=currentDate %>" validate="Registration Date,frdate,no" readonly="readonly"	class="calDate" /> 
<input type="hidden" name="<%=REG_TIME %>" value="<%=time %>" validate="Registration Time,string,no" maxlength="20"	readonly="readonly" class="calDate" />
<div id="sNameDiv">
<div class="Block">
<!--<label>HIN</label>
--><label id="defaulthinno" class="value" style="display: none;">&nbsp;</label>
<label id="hinNoDivId" class="value" style="display: none;"></label>
<input id="hinNoId" type="hidden" name="<%=HIN_NO %>" value=""  validate="HIN,metachar,no"/>
<div class="clear"></div>
<div id="srNoDiv" style="display: block;">
<label>Service No.<span>*</span></label>
<input 	id="prefix" name="<%=PREFIX%>" type="text" maxlength="3" class="auto" size="1"	tabindex="1" validate="Prefix,metachar,no" /> 
<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1" validate="Service No.,metachar,yes" maxlength="20"  onKeyPress="return isNumber(event)"
onblur="if(validateMetaCharacters(this.value)){validateServiceNo(this.value,'registration');submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getServiceNoDetailsForReg&serviceNo='+this.value,'depenedentDiv');}" />

<select id="suffixId" name="<%=SUFFIX%>" validate="Suffix,metachar,no"	tabindex="1" class="smallest2" >
	<option value="">Select</option>
	<%
			for(char i='A'; i<='Z'; i++){
			
		%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>

</select> 
<label> Service Status <span>*</span></label> 
<select	id="serviceStatusId" name="<%=SERVICE_STATUS_ID %>"
	validate="Service Status,string,yes" tabindex="1"
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
<div id="exServiceId"></div>
</div>


<div class="clear"></div>
<label>HIN</label>
<select id="regHinId" name="regHinId" tabindex="1"  onchange="if(validateMetaCharacters(this.value) && this.value!='0'){displayPatientInfo(this.value)}else{getHin();}"> 
<option value="0">Select</option>
</select>
<input type="hidden" name="printHinNo" id="printHinNo" value="" validate="HIN No.,metachar,no"	>
<label>Service Type <span>*</span></label> 
<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>"	validate="Service Type,metachar,yes" tabindex="1"
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
<div id="rankDivId">
<label> Rank <span>*</span></label> 
<select	id="rankId" name="<%=RANK_ID%>" validate="Rank,metachar,yes" tabindex="1" onchange="">
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


<div class="clear"></div>
<label>First Name <span>*</span></label> 
<input id="sFNameId" type="text" name="<%=S_FIRST_NAME %>" value="" tabindex="1"	title="First Name of Service Person"	validate="First Name of Service Person,regName,yes" MAXLENGTH="15"	onblur="fillPatientName(this);" /> 

<label>Middle Name</label> 
<input	id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value=""	tabindex="1" validate="Middle Name of Service Person,regName,no"	MAXLENGTH="15" onchange="fillPatientName(this);" />

<label>Last Name</label> 
<input id="sLNameId" type="text"	name="<%=S_LAST_NAME %>" value="" tabindex="1"	validate="Last Name of Service Person,regName,no" MAXLENGTH="15"	onchange="fillPatientName(this);" />

<div id="srPrDtDiv">
<div class="clear"></div>

<label> Trade/Branch</label> 
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,metachar,no" tabindex="1"	onchange="displayOtherTrade(this.value);">
	<option value="0">Select</option>
	<%for(Object[] trade :tradeList){ %>
	<option value=<%=trade[0]%>><%=trade[1] %></option>
	<%} %>
	<!--<option value="other">Other</option>-->
</select>


<div id="addTradeDiv" style="display: none;">
<label> Trade/Branch Name <span>*</span></label> 
<input id="newTradeId" type="text"	name="<%=TRADE_NAME%>" value="" tabindex="1"	validate="Trade Name,metachar,no" maxlength="30" tabindex="1" /> 
</div>

<label> DOE/DOC</label> 
<input type="text"	id="commissionDateId" name="commissionDate" tabindex="1" value=""	validate="commission Date,frdate,no" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');"	class="calDate" onblur="validateExpDate(this,'commissionDateId');calculateTotalService(this.value);" /> 
<!-- <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.registration.commissionDate,event)" />  -->
<input	type="hidden" id="idForComEnrlDate" value="" validate="DOE,frdate,no"	/> 

<label>Total Service </label> 
<input id="totalServYrs" type="hidden" name="" value=""	validate="Total Service,float,no" maxlength="6" tabindex="1" />

<div id="totalService" style="display: block;">
<select	id="totalServ" name="<%=TOTAL_SERVICE%>"	validate="Total Service year,metachar,no" tabindex="1" class="small"	onchange="checkAgeAndService();" >
	<%
				for(int age1=0;age1<=45;age1++){
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
<div id="addSecDiv" style="display: none;">
<label>Section Name <span>*</span></label> 
<input type="text" id="addSec" name="sectionName" tabindex="1"	value="" maxlength="30" validate="Section Name,metachar,no"/>
</div>

<label>Unit <span>*</span></label> 
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,metachar,yes" onchange="displayOtherUnit(this.value);populateStationForUnit(this.value);">
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

<label>Station</label> 
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
<input type="text" id="addStn" name="stationName" tabindex="1"	value="" maxlength="30"  validate="Station Name,metachar,no" />
</div>
<div class="clear"></div>
<label> Command</label> 
<select id="commandId" name="<%=COMMAND %>"	validate="Command,metachar,no" tabindex="1"	onchange="displayOtherCmd(this.value);">
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
<label>Command Name <span>*</span></label> 
<input type="text" id="addCmd" name="commandName" value=""	tabindex="1" maxlength="30"  validate="Command Name,metachar,no" />
</div>
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
<select id="recordOffId" name="<%=RECORD_OFFICE_ADDRESS_ID %>" validate="RecordOff Addrs,metachar,no" class="med"  tabindex="1">
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

</div><!-- End Block 1-->
<div class="clear"></div>
<h4>Personal Details</h4>
<div class="clear"></div>
<div class="Block">


<label> Gender <span>*</span></label>
<select name="<%=SR_SEX %>" id="srSexId" validate="Service Person Gender,metachar,yes" tabindex="1"	onchange="fillPatientName(this);">
	<%
		   	 		for(Object[] masAdministrativeSex : sexList){
		   	 			if(masAdministrativeSex[2].equals(administrativeSexMaleCode)){
			%>
	<option value="<%=masAdministrativeSex[0]%>" selected="selected"><%=masAdministrativeSex[1] %></option>
	<%		}else{ %>
	<option value="<%=masAdministrativeSex[0] %>"><%=masAdministrativeSex[1] %></option>
	<%
					}
		   	 	} %>
</select> 

<label>DOB</label> 
<input type="text" id="srdobId" name="<%=SR_DOB %>"	tabindex="1" value="" validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"		onblur="validateExpDate(this,'srdobId');calculateSRAgeInAjax();fillPatientName(this);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.registration.<%=SR_DOB%>,event)" />


<label>Age <span>*</span></label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId"	name="<%=SR_AGE%>" validate="Age of Service Person,metachar,yes"	tabindex="1" class="small"	onchange="fillPatientName(this);">
	<option value="">Select</option>
	<%
				for(int age1 = 16;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly"/>
</div>
<input type="hidden" id="idForSrAge" value="" validate="Age,metachar,no"	/>

<div class="clear"></div>
<label>Marital Status</label> 
<select name="srMaritalStatus" id="srmrstatus"	validate="Marital Status of service Person,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(Object[] masMaritalStatus : maritalStatusList){
	%>
	<option value="<%=masMaritalStatus[0]%>"><%=masMaritalStatus[1]%></option>
	<%}%>
</select> 


<label>Marriage Date</label> 
<input type="text" id="srMarriageDateId"	name="srMarriageDate" tabindex="1" value=""	onkeyup="mask(this.value,this,'2,5','/');"		onblur="validateExpDate(this,'srMarriageDateId'); " validate="Marriage Date,date,no" MAXLENGTH="30" class="calDate" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.registration.srMarriageDate,event)" />


<label > Religion</label>
<select id="religionId" name="<%=RELIGION_ID %>" validate="Religion,metachar,no"  tabindex="1">
<option value="0">Select</option>
<%
for (Object[] masReligion : religionList) 
{
%>
<option value="<%= masReligion[0] %>"><%= masReligion[1] %></option>
<%} %>
</select>
<div class="clear"></div>
<div id="afDiv">
<label>AFNET No.</label> 
<input id="afnetNo" name="afnetNo" type="text" tabindex="1"	maxlength="15"  validate="AFNET No.,metachar,no" />
</div>


<label>Telephone No.(Off.)</label> 
<input id="phoneNo" name="<%=TELEPHONE_NO %>" type="text" tabindex="1" maxlength="11" onblur="fillPatientName(this)"  validate="Telephone No.(Off.),metachar,no" /> 
<label>Mobile No.</label> 
<input id="mobileNo" name="<%=MOBILE_NO %>" type="text" tabindex="1"	maxlength="11" onblur="fillPatientName(this)"  validate="Mobile No.,metachar,no" />
<div class="clear"></div>

<label>Telephone No.(Res.)</label> 
<input id="phoneNoRes" name="phoneNoRes" type="text" tabindex="1" maxlength="11"  validate="Telephone No.(Res.),metachar,no"/> 

<label>Other Contact No.</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="60"validate="Other Contact No.,metachar,no" name="otherContactNo" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" ></textarea>
<div class="clear"></div>
<label>Local Address</label> 
<textarea name="<%=ADDRESS %>" id="sraddr"	cols="20" rows="2" tabindex="1" validate="Address,metachar,no" maxlength="200"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" onblur="fillPatientName(this)" ></textarea>
	
<label>City</label> 
<select name="<%=DISTRICT%>" validate="City,string,no" id="srcityId" tabindex="1" onblur="fillPatientName(this)">
	<option value="0">Select</option>
	<%
		for(Object[] masDistrict : districtList){
	%>
	<option value="<%=masDistrict[0]%>"><%=masDistrict[1] %></option>
	<%		
		}%>
</select> 

<label>State</label> 
<select id="srstateId" name="<%=STATE%>"	validate="State,metachar,no" tabindex="1"	onChange="populateDistrict(this.value,'registration','srcityId')">
	<option value="0">Select</option>
	<%

		for(Object[] masState : stateList){
	
	%>
	
	<option value="<%=masState[0] %>"><%=masState[1] %></option>
	<%		
		}%>
</select>
<div class="clear"></div>

<label>Permanent Address</label> 
<textarea name="<%=PERMANENT_ADDRESS %>" id="peraddr"	cols="20" rows="2" tabindex="1" validate="Address,metachar,no" maxlength="250"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
	
<label>City</label> 
<select name="permCityId" validate="City,string,no" id="perCityId" tabindex="1" onchange="populateStateForCity(this.value);">
	<option value="0">Select</option>
	<%
		for(Object[] masDistrict : districtList){
	%>
	<option value="<%=masDistrict[0]%>"><%=masDistrict[1]%></option>
	<%		
		}%>
</select> 

<label>State</label> 
<select id="permStateId" name="permStateId"	validate="State,string,no" tabindex="1"	onChange="populateDistrict(this.value,'registration','perCityId')">
	<option value="0">Select</option>
	<%

		for(Object[] masState : stateList){
	
	%>
	
	<option value="<%=masState[0] %>"><%=masState[1] %></option>
	<%		
		}%>
</select>
<div class="clear"></div>
<script>
<%
int i = 0;
for (Object[] masState : stateList)
{
	for (Object[] masDistrict : districtList) 
	{
		if(masDistrict[2] != null){
			if(masState[0].equals(masDistrict[2] )){
					%>
						districtArray[<%=i%>] = new Array();
						districtArray[<%=i%>][0]=<%=masState[0]%>;
						districtArray[<%=i%>][1] = <%=masDistrict[0]%>;									
						districtArray[<%=i%>][2] = "<%=masDistrict[1]%>";

					<%
					i++;
			}
		}
	}
}

%>
</script>
<label>Telephone No.</label> 
<input id="telephoneNoPerm" name="telephoneNoPerm" type="text" tabindex="1" maxlength="11" validate="Telephone No.,metachar,no"/> 
<label>Police Station</label> 
<input id="policeStation" name="policeStation" type="text" tabindex="1" maxlength="15" validate="Police Station,metachar,no"/> 
<label>Pin Code</label> 
<input id="pinCode" name="pinCode" type="text" tabindex="1" maxlength="8" validate="Pin Code,metachar,no"/> 
<div class="clear"></div>
<label>Identification Mark 1</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="50" validate="Identification Mark 1,metachar,no" name="identificationMark1" id="identificationMark1" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<label>Identification Mark 2</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="50"validate="Identification Mark 2,metachar,no" name="identificationMark2" id="identificationMark2" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<div class="clear"></div>

</div><!-- End Block 2-->
<div class="clear"></div>
<h4>NOK Details</h4>
<div class="clear"></div>
<div class="Block">
<h4> NOK 1</h4>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="<%=SR_NEXT_OF_KIN_NAME%>" value=""	validate="NOK1 Name,fullName,no" id="srnokNameId" maxlength="30"/>
	
<label>  Relation</label> 
<select	name="<%=SR_NEXT_OF_KIN_RELATION_ID %>" validate="NOK1 Relation,String,no"	id="srrelId">
	<option value="0">Select</option>

	<% 
	for (Object[]  obj : relationList){
	%>
	<option value="<%=obj[0]%>"><%=obj[1]%></option>
	<% 				
	}%>
</select>
<label> Contact No.</label> 
<input	type="text" name="<%=SR_NEXT_OF_KIN_PHONE_NO%>" value="" id="srnok1Phone"	validate="NOK1 Phone No,phone,no" maxlength="16" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="<%=SR_NEXT_OF_KIN_ADDRESS %>" id="srnextOfKinAdd"	cols="20" rows="2" tabindex="1" validate="Nok1 Address,metachar,no"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<label>Police Station</label> 
<input id="srnok1PoliceStation" name="srnok1PoliceStation" type="text" tabindex="1" maxlength="15" /> 
<label>Pin Code</label> 
<input id="srnok1PinCode" name="srnok1PinCode" type="text" tabindex="1" maxlength="8" /> 
<div class="clear"></div>
	
<h4> NOK 2</h4>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="srnok2Name" value=""	validate="NOK2 Name,fullName,no" id="srnok2NameId" maxlength="30"/>
	
<label>  Relation</label> 
<select	name="srnok2RelationId" validate="NOK2 Relation,String,no"	id="srnok2RelId">
	<option value="0">Select</option>

	<% 
	for (Object[]  obj : relationList){
	%>
	<option value="<%=obj[0]%>"><%=obj[1]%></option>
	<% 				
	}%>
</select>
<label> Contact No.</label> 
<input	type="text" name="srnok2ContactNo" value="" id="srnok2Contact"	validate="NOK2 Contact No,phone,no" maxlength="16" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="srnok2Address" id="srnok2Add"	cols="20" rows="2" tabindex="1" validate="Nok2 Address,metachar,no"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<label>Police Station</label> 
<input id="srnok2PoliceStation" name="srnok2PoliceStation" type="text" tabindex="1" maxlength="15" validate="Police Station,metachar,no"/> 
<label>Pin Code</label> 
<input id="srnok2PinCode" name="srnok2PinCode" type="text" tabindex="1" maxlength="8" validate="Pin Code,metachar,no"/> 
<div class="clear"></div>
</div><!-- End Block 3-->
<div class="clear"></div>
<h4>Medical Details</h4>
<div class="clear"></div>
<div class="Block">

<label>Blood Group</label> 
<select name="<%=SR_BLOOD_GROUP_ID %>"	id="srBldGrp" validate="Blood Group,string,no" tabindex="1">	
<option value="0">Select</option>
	<%
	 for(Object[]  masBloodGroup : bloodGroupList){
	%>
	<option value="<%=masBloodGroup[0]%>"><%=masBloodGroup[1]%></option>
	<%}%>
</select>
<label>Family History</label> 
<select name="srfamilyHistory" id="srfamilyHistory" tabindex="1" multiple="multiple" class="list" onblur="openOtherField(this.value,this.id);">
 <option value="0">Select</option>
<%
	if(familyHistoryList.size() > 0){
		for(Object[] familyHistory : familyHistoryList){
		%>
		<option value="<%=familyHistory[0] %>"><%=familyHistory[1]%></option>
	<%}
	}
%>
</select>
<div id="otherSrFamilyHistoryDiv" style="display: none;">
<label>Other</label>
<input type="text" name="otherSrFamilyHistory" id="otherSrFamilyHistory" value="" validate="Other,metachar,no" maxlength="50"  onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)">
</div>
<label> Allergy</label> 
<textarea name="srAllergies" id="srAllergies" value=""	validate="Allergy,metachar,no" maxlength="100" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)">
</textarea>

<div class="clear"></div>
<div id="medCatDiv">
<label>Present Med Cat  </label> 
 <select 	name="presentMedCat" id="presentMedCat" validate="Present Med Cat,string,no" tabindex=1>
 <option value="0">Select</option>
 <%
 for (Object[] category : categoryList) {
		%>
	<option value="<%=category[0]%>" ><%=category[1]%> </option>
	<%	}
				
 %>
 </select>
 <label>Duration  </label> 
 <input type="text" name="medCatPeriod" id="medCatPeriod" value="" maxlength="5" class="small" onblur="validateDuration(this.value,'medCatPeriod');"/>
 <select name="medCatDuration" id="medCatDuration" class="small">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select>
  <label>Date  </label> 
 <input type="text" name="medCatDate" id="medCatDate" value="" maxlength="10"  class="calDate" onkeyup="mask(this.value,this,'2,5','/');"	validate="Date,frdate,no"	onblur="validateExpDate(this,'medCatDate'); "/>
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.registration.medCatDate,event)" /> 
	</div>
	<div class="clear"></div>
<%--
<label>Smoker</label>
<label class="auto"><10</label>
<input type="checkbox" name="srsmokerLess10" id="srsmokerLess10" class="radioAuto2" tabindex="1"/>
<label class="auto">>10</label>
<input type="checkbox" name="srsmokerMore10" id="srsmokerMore10" class="radioAuto2" tabindex="1"/>
<label>Alcohol</label>
<select name="sralcohol" id="sralcohol" tabindex="1">
<option value="">Select</option>
<option value="Non-drinker">Non-drinker</option>
<option value="Occasional">Occasional</option>
<option value="Moderate">Moderate</option>
<option value="Heavy">Heavy</option>
</select> --%>
<div class="clear"></div>
</div><!-- End Block 4-->
</div><!-- End sNameDiv-->
<div class="clear"></div>


</div> <!-- End of country1 -->

<div class="clear"></div>
<div id="country2" class="tabcontentIn">

<div class="clear paddingTop15"></div>
<div class="Block">

<label>Relation </label> 
<select	id="relationId" name="<%=RELATION_ID %>"	validate="Relation,string,no" tabindex="1"
	onchange="checkForCheckUP(); if(checkForFirstRow()){checkPatientRegistration(); setMaritalStatus();}">
	<option value="0">Select</option>

	<%
	for(Object[] relation : relationList){
	//	if(relation.getRelationName().equalsIgnoreCase("Self")){
%>
<%--<option value="<%=relation.getId() %>" selected="selected"><%=relation.getRelationName() %></option> --%>	
	<%//}else{ %>
	<option value="<%=relation[0] %>"><%=relation[1] %></option>
	<%//}
		}%>

</select> 

<label> Title</label> 
<select id="titleId" name="<%=TITLE%>"	validate="Title,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
	
	 	for (Object[] masTitle : titleList) 
		{ 
		if(masTitle[2] != null && masTitle[0] != null){
	 		if(masTitle[2].equals(selectedTitleForReg)){

			%>
	<option value="<%=masTitle[0] %>" selected="selected"><%=masTitle[1] %></option>
	<%		}else{ %>
	<option value="<%=masTitle[0]%>"><%=masTitle[1]%></option>
	<%
					}
		}
		}%>
</select> 
<div class="clear"></div>
<label> First Name <span>*</span></label> 
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"	title="First Name of the Patient"	validate="Patient First Name,regName,yes" MAXLENGTH="15" />

<label>Middle Name</label> 
<input type="text" id="pMiddleNameId"	name="<%=P_MIDDLE_NAME%>" value="" tabindex="1"	validate="Patient Middle Name,name,no" MAXLENGTH="15" /> 

<label>Last Name</label> 
<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"	value="" validate="Patient Last Name,name,no" MAXLENGTH="15"	tabindex="1" /> 

<div class="clear"></div>

<label> Gender<span>*</span></label> 
<select	name="<%=GENDER %>" id="gender" validate="Gender,string,yes"	tabindex="1">
<%
		   	 		for(Object[] masAdministrativeSex : sexList){
		   	 			if(masAdministrativeSex[2].equals(administrativeSexMaleCode)){
			%>
	<option value="<%=masAdministrativeSex[0] %>" selected="selected"><%=masAdministrativeSex[1].toString().trim() %></option>
	<%		}else{ %>
	<option value="<%=masAdministrativeSex[0] %>"><%=masAdministrativeSex[1].toString().trim() %></option>
	<%
					}
		   	 	} %>
</select>


<label>DOB</label> 
<input type="text" id="dobId"	name="<%=DATE_OF_BIRTH %>" tabindex="1" value=""	onkeyup="mask(this.value,this,'2,5','/');"		onblur="if(this.value!=''){validateExpDate(this,'dobId'); calculateAgeInAjax();}" validate="Date of Birth,date,no" MAXLENGTH="10" class="calDate" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.registration.<%=DATE_OF_BIRTH%>,event)" />


<label> Age <span>*</span></label>
<div id="ageDiv" style="display: block;">
<select id="ageId"	name="<%=AGE%>" validate="Age of Patient,metachar,yes" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="ageUnitId" name="<%=AGE_UNIT %>"	validate="AgeUnit,string,no" tabindex="1" class="small">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<input type="hidden" id="idForAge" value="" validate="Age,metachar,no"	/>
</div>

<div class="clear"></div>


<label> Marital Status</label>
<select name="<%=MARITAL_STATUS_ID %>"	id="mrstatus" validate="Marital Status,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(Object[]  masMaritalStatus : maritalStatusList){
	
	%>
	<option value="<%=masMaritalStatus[0]%>"><%=masMaritalStatus[1]%></option>
	<%}%>
</select> 


<label>Marriage Date</label> 
<input type="text" id="depMarriageDateId"	name="depMarriageDate" tabindex="1" value=""	onkeyup="mask(this.value,this,'2,5','/');"		onblur="validateExpDate(this,'depMarriageDateId'); " validate="Marriage Date,frdate,no" MAXLENGTH="10" class="calDate" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.registration.depMarriageDate,event)" />


<label> Occupation</label> 
<select	id="occupation" name="<%=OCCUPATION_ID %>"	validate="Occupation,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(Object[] masOccupation : occupationList){
	
	%>
	<option value="<%=masOccupation[0]%>"><%=masOccupation[1]%></option>
	<%}%>
</select>
<div class="clear"></div>

<label>Income(Per Month)</label>
<input type="text" name="income" id="income" value="" tabindex="1" maxlength="10" validate="Income(Per Month),int,no"/>

<label>Dependency Date</label>
<input type="text" id="depDate" name="dependencyDate" value="" class="date" maxlength="10" onkeyup="mask(this.value,this,'2,5','/');"	validate="Dependency Date,frdate,no"	onblur="validateExpDate(this,'depDate'); checkDependencyDate(this.value);"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" tabindex="1"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.registration.dependencyDate,event)" />
	
<label>Authority</label>
<input type="text" name="authority" id="authority" value="" maxlength="50" tabindex="1" validate="Authority,metachar,no"/>
<div class="clear"></div>

<label>Dependency Removal</label>
<input type="text" id="depRemovalDate" name="dependencyRemovalDate" value="" readonly="readonly" class="date" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" tabindex="1"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.registration.dependencyRemovalDate,event)" />
	


<label>Local Address</label> 
<textarea name="<%=ADDRESS %>" id="addr" cols="20" rows="2" tabindex="1" validate="Address,metachar,no"	onpaste="return checkOnPaste(this)"
 maxlength="200"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"	  onblur="fillPatientName(this)"></textarea>
	
<label>City</label> 
<select name="<%=DISTRICT%>"	validate="City,string,no" id="cityId" tabindex="1" onblur="populateStateForCity(this.value,'stateId');fillPatientName(this)">
	<option value="0">Select</option>
	<%
		for(Object[] masDistrict : districtList){
	%>
	<option value="<%=masDistrict[0]%>"><%=masDistrict[1] %></option>
	<%		
		}%>
</select> 	

<div class="clear"></div>
<label>State</label> 
<select id="stateId" name="<%=STATE%>"	validate="State,string,no" tabindex="1"	onChange="populateDistrict(this.value,'registration','cityId'),fillPatientName(this)" onblur="fillPatientName(this)">
	<option value="0">Select</option>
	<%

		for(Object[] masState : stateList){
	
	%>
	
	<option value="<%=masState[0] %>"><%=masState[1] %></option>
	<%		
		}%>
</select>
<label>Contact No.</label> 
<input type="text"	name="<%=CONTACT_NUMBER %>" id="contactNo" value=""	validate="Contact No.,phone,no" MAXLENGTH="20" tabindex="1" onblur="fillPatientName(this)" />
<label>Mobile No.</label> 
<input id="depmobileNo" name="<%=MOBILE_NO %>" type="text" tabindex="1"	maxlength="11" onblur="fillPatientName(this)" validate="Mobile No.,phone,no"/>
<div class="clear"></div>
<label>Police Station</label> 
<input id="deppoliceStation" name="policeStation" type="text" tabindex="1" maxlength="15" onblur="fillPatientName(this)" validate="Police Station,metachar,no"/> 
<label>Pin Code</label> 
<input id="deppinCode" name="pinCode" type="text" tabindex="1" maxlength="8" validate="Pin Code,int,no"/> 


<div class="clear"></div>
<label>Identification Mark 1</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="50" name="depIdentificationMark1" validate="Identification Mark 1,metachar,no" id="depIdentificationMark1" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<label>Identification Mark 2</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="50" name="depIdentificationMark2" validate="Identification Mark 2,metachar,no" id="depIdentificationMark2" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>	
<div class="clear"></div>
</div><!-- End Block 4 -->
<div class="clear"></div>
<h4>NOK Details</h4>
<div class="clear"></div>
<div class="Block">
<h4> NOK 1</h4>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="<%=NEXT_OF_KIN_NAME%>" value=""	validate="NOK1 Name,fullName,no" id="nokNameId" maxlength="30"/>
	
<label>  Relation</label> 
<select	name="<%=NEXT_OF_KIN_RELATION_ID %>" validate="NOK1 Relation,String,no"	id="relId">
	<option value="0">Select</option>

	<% 
	for (Object[]  obj : relationList){
	%>
	<option value="<%=obj[0]%>"><%=obj[1]%></option>
	<% 				
	}%>
</select>
<label> Contact No.</label> 
<input	type="text" name="<%=NEXT_OF_KIN_PHONE_NO%>" value="" id="nok1Phone"	validate="NOK1 Phone No,phone,no" maxlength="16" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="<%=NEXT_OF_KIN_ADDRESS %>" id="nextOfKinAdd"	cols="20" rows="2" tabindex="1" validate="Nok1 Address,metachar,no" maxlength="200"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<label>Police Station</label> 
<input id="nok1PoliceStation" name="nok1PoliceStation" type="text" tabindex="1" maxlength="15" validate="Police Station,metachar,no"/> 
<label>Pin Code</label> 
<input id="nok1PinCode" name="nok1PinCode" type="text" tabindex="1" maxlength="8" validate="Pin Code,int,no"/> 
<div class="clear"></div>
	
<h4> NOK 2</h4>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="nok2Name" value=""	validate="NOK2 Name,fullName,no" id="nok2NameId" maxlength="30"/>
	
<label>  Relation</label> 
<select	name="nok2RelationId" validate="NOK2 Relation,String,no"	id="nok2RelId">
	<option value="0">Select</option>

	<% 
	for (Object[]  obj : relationList){
	%>
	<option value="<%=obj[0]%>"><%=obj[1]%></option>
	<% 				
	}%>
</select>
<label> Contact No.</label> 
<input	type="text" name="nok2ContactNo" value="" id="nok2Contact"	validate="NOK2 Contact No,phone,no" maxlength="16" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="nok2Address" id="nok2Add"	cols="20" rows="2" tabindex="1" validate="Nok2 Address,metachar,no" maxlength="200"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<label>Police Station</label> 
<input id="nok2PoliceStation" name="nok2PoliceStation" type="text" tabindex="1" maxlength="15" validate="Police Station,metachar,no"/> 
<label>Pin Code</label> 
<input id="nok2PinCode" name="nok2PinCode" type="text" tabindex="1" maxlength="8" validate="Pin Code,int,no"/> 
<div class="clear"></div>
</div><!-- End Block 3-->

<div class="clear"></div>
<h4>Medical Details</h4>
<div class="clear"></div>
<div class="Block">

<label>Blood Group</label> 
<select name="<%=BLOOD_GROUP_ID %>"	id="bldGrp" validate="Blood Group,string,no" tabindex="1">	
<option value="0">Select</option>
	<%
	 for(Object[]  masBloodGroup : bloodGroupList){
	%>
	<option value="<%=masBloodGroup[0]%>"><%=masBloodGroup[1]%></option>
	<%}%>
</select>
<label>Family History</label> 
<select name="familyHistory" id="familyHistory" tabindex="1" multiple="multiple" class="list" onblur="openOtherField(this.value,this.id);">
 <option value="0">Select</option>
<%
	if(familyHistoryList.size() > 0){
		for(Object[] familyHistory : familyHistoryList){
		%>
		<option value="<%=familyHistory[0] %>"><%=familyHistory[1]%></option>
	<%}
	}
%>
</select>
<div id="otherFamilyHistoryDiv" style="display: none;">
<label>Other</label>
<input type="text" name="otherFamilyHistory" id="otherFamilyHistory" value="" maxlength="50"  validate="Other,metachar,no"  onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" >
</div>
<label> Allergy</label> 
<textarea name="allergies" id="allergies" value=""	validate="Allergy,metachar,no" maxlength="100" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)">
</textarea>

<div class="clear"></div>
<%--
<label>Smoker</label>
<label class="auto"><10</label>
<input type="checkbox" name="smokerLess10" id="smokerLess10" class="radioAuto2" tabindex="1"/>
<label class="auto">>10</label>
<input type="checkbox" name="smokerMore10" id="smokerMore10" class="radioAuto2" tabindex="1"/>
<label>Alcohol</label>
<select name="alcohol" id="alcohol" tabindex="1">
<option value="">Select</option>
<option value="Non-drinker">Non-drinker</option>
<option value="Occasional">Occasional</option>
<option value="Moderate">Moderate</option>
<option value="Heavy">Heavy</option>
</select>
<div class="clear"></div> --%>
</div><!-- End Block 4-->
</div> <!-- End of country2 -->

</div><!-- End of tabcontainerIn -->
<div class="clear"></div>
<div class="Block">
<!--<input type="button" class="button" value="OPD">
--><label class="medium">OPD</label>
<input type="checkbox" name="reportingFor" value="OPD" class="radioAuto" tabindex="1"/>
<label class="medium">Follow Up</label>

<!--<input type="button" class="button" value="FollowUp" >
-->
<input type="checkbox" id="followupid" name="reportingFor" tabindex="1" value="FollowUp" class="radioAuto" onclick="displayDepartment(this);"/>
<div id="followUpDiv" style="display: none;">
<label  class="auto">Department </label> 
<select name="followUpDepartment" id="followUpDepartment" tabindex="1" class="small">
<option value="">Select</option>
<option value="OPD">OPD</option>
<option value="Physiotherapy">Physiotherapy</option>
<option value="FamilyWC">FamilyWC</option>
<option value="Dental">Dental</option>
</select>
</div>
<label  class="auto">Medical Officer </label> 
<select	id="consultingDocId" name="<%=CONSULTING_DOCTOR %>"	validate="Doctor,string,no"  class="auto"
	onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('registration','registration?method=getTokenNoForDepartment');setDepartmentValue(this.value);}"	tabindex="1">
	<option value="0">Select</option>
	<%

for(Object[]  masEmployee : doctorList){
	if(masEmployee[4] != null){
		if(masEmployee[4].toString().equals(empCategoryCodeForDoctor)){
%>
	<option value="<%=masEmployee[0] %>"><%=masEmployee[5]+" "+ masEmployee[1]+" "+(masEmployee[2]!=null?masEmployee[2]:"")+" "+(masEmployee[3]!=null?masEmployee[3]:"") %></option>
	<%				}
	}
} %>
</select> 
<input type="hidden" name="<%=DEPARTMENT_ID %>" id="deptId" value="0" validate="Deptartment Id,int,no"	/>
<label  class="medium">Room No.</label>
<input type="text" name="roomNo" id="roomNoId" value="" maxlength="4" class="smallest" validate="Room No.,int,no"	/>
<!--<select id="roomNoId"	name="roomNo" validate="Room No,string,no" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int r=1;r<=500;r++){
				%>
	<option value="<%=r%>"><%= r%></option>
	<%}%>
</select> 

--><label  class="medium"> Priority</label>
<select name="priority" id="priority" class="smallest" tabindex="1">
<option value="1">1</option>
<option value="2">2</option>
<option value="3" selected="selected">3</option>
</select>
<div id="testDiv" style="display: none">
<input type="text"	name="<%=TOKEN_NO %>" value="" validate="Token no.,int,no"	maxlength="3" readonly="readonly"/>
</div>

<input type="hidden" name="<%=VISIT_NUMBER%>" value="" id="visitNo" validate="Visit no.,int,no"	/>


<div class="clear"></div>
<!--<input type="button" class="button"  value="Med Exam">
--><label class="medium">Med Exam</label>
<input type="checkbox" name="reportingFor" tabindex="1" class="radioAuto" value="MedExam" onclick="displayMedExam(this);" validate="MedExam,metachar,no"/>
<div id="med">
<!--<input type="button" class="button" value="Med Board">
--><label class="medium">Med Board</label>
<input type="checkbox" name="reportingFor" tabindex="1" class="radioAuto" value="MedBoard" onclick="displayMedBoard(this);"validate="MedBoard,metachar,no"/>
</div>
<!--<input type="button" class="button" value="Physio">
--><label class="medium">Physio</label>
<input type="checkbox" name="reportingFor" tabindex="1"value="Physiotherapy" class="radioAuto" validate="Physio,metachar,no"/>
<!--<input type="button" class="button" value="Treatment Rm">
--><label class="auto">Treatment Rm</label>
<input type="checkbox" name="reportingFor" tabindex="1" value="TreatmentRoom" class="radioAuto" validate="Treatment Rm,metachar,no"/>
<!--<input type="button" class="button" value="F W C">
--><label class="medium">FWC</label>
<input type="checkbox" name="reportingFor" tabindex="1" value="FamilyWC" class="radioAuto" onclick="displayFWC(this);" validate="FWC,metachar,no"/>
<!--<input type="button" class="button" value="Dental">
--><label class="medium">Dental</label>
<input type="checkbox" name="reportingFor" tabindex="1"value="Dental" class="radioAuto" validate="Dental,metachar,no"/>
<!--<input type="button" class="button" value="Radiology">
--><label class="medium">Radiology</label>
<input type="checkbox" name="reportingFor" tabindex="1"value="Radiology" class="radioAuto" validate="Radiology,metachar,no"/>
<label class="medium">Lab</label>
<input type="checkbox" name="reportingFor" tabindex="1"value="Lab" class="radioAuto" validate="Lab,metachar,no"/>

<div class="clear"></div>
<div id="medExamCategoryDiv" style="display: none;">
<label>Exam Category <span>*</span></label> 
<select id="medExamCategory" name="medExamCategory"	tabindex="1" class="auto" onchange="if(validateMetaCharacters(this.value)){displayForm44(this.value);}">
	<option value="">Select</option>
	<option value="Annual Medical Exam(AFMSF-3B)">Annual Medical Exam(AFMSF-3B)</option>
	<option value="Med. Exam On Release/Discharge(AFMSF-18)">Med. Exam On Release/Discharge(AFMSF-18)</option>
	<option value="Primary/Extension Med. Exam(AFMSF-2A)">Primary/Extension	Med. Exam(AFMSF-2A)</option>
	<option value="Prior To Proceedings Abroad Med. Exam(AFMSF-3B)">Prior To Proceedings Abroad Med. Exam(AFMSF-3B)</option>
	<option value="High Altitude Med. Exam(AFMSF-3B)">High Altitude Med. Exam(AFMSF-3B)</option>
	<option value="Form-44">Form-44</option>
	<option value="AFMSF-7A">AFMSF-7A</option>
</select>
</div>
<div class="clear"></div>
<div id="medBoardCategoryDiv" style="display: none;">
<label>Board Category <span>*</span></label> 
<select id="medBoardCategory" name="medBoardCategory" class="auto"	tabindex="1" onchange="if(validateMetaCharacters(this.value)){displayForm44(this.value)}">
	<option value="">Select</option>
	<option value="Initial Medical Board AFMSF 15">Initial Medical Board AFMSF 15</option>
	<option value="Medical Board Review AFMSF 15">Medical Board	Review AFMSF 15</option>
	<option value="Medical Board AFMSF 16">Medical Board AFMSF 16</option>
	<option value="Form - 10">Form - 10</option>
	<option value="Primary/Extension Med. Exam(AFMSF-2A)">Primary/Extension	Med. Exam(AFMSF-2A)</option>
	<option value="Annual Medical Exam(AFMSF-3B)">Annual Medical Exam(AFMSF-3B)</option>
	<option value="High Altitude Med. Exam(AFMSF-3B)">High Altitude Med. Exam(AFMSF-3B)</option>
	<option value="Prior To Proceedings Abroad Med. Exam(AFMSF-3B)">Prior To Proceedings Abroad Med. Exam(AFMSF-3B)</option>
	<option value="Form-44">Form-44</option>
	<option value="Form-44 (Interim Category)">Form-44 (Interim Category)</option>
</select>
</div>
<div id="fwcCategoryDiv" style="display: none;">
<label>FWC Category <span>*</span></label> 
<select id="fwcCategory" name="fwcCategory"	tabindex="1" onchange="if(validateMetaCharacters(this.value)){checkGenderForFemale(this.value);checkGenderForFP(this.value);}">
	<option value="">Select</option>
	<option value="ANC">ANC Initial</option>
	<option value="ANC FOLLOW UP">ANC Follow Up</option>
	<option value="PNC">PNC (Well Women &amp; Children)</option>
	<option value="WELL BABY">Well Baby(5 Yrs) </option>
	<option value="IMMUNIZATION">Immunization </option>
	<option value="FAMILY PLANNING">Family Planning </option>
</select>
</div>
<div id="form44" style="display: none;">
<input type="button" name="Form44" value="Form44" class="button" onclick="submitForm('registration','/hms/hms/medicalExam?method=showForm44Report&serviceNo='+document.getElementById('serviceNoId').value+'&unitId='+document.getElementById('unitId').value+'&rank='+document.getElementById('rankId').value+'&name='+document.getElementById('sFNameId').value+'&trade='+document.getElementById('tradeId').value+'&age='+document.getElementById('ageId').value+'&totalServYrs='+document.getElementById('totalServ').value+'&lastName='+document.getElementById('sLNameId').value);"/>
</div>
<div id="AFMSF7A" style="display: none;">
<input type="button" name="AFMSF7A" value="AFMSF-7A" class="button" onclick="submitForm('registration','/hms/hms/medicalExam?method=AFMSF7AReport&serviceNo='+document.getElementById('serviceNoId').value+'&unitId='+document.getElementById('unitId').value+'&rank='+document.getElementById('rankId').value+'&name='+document.getElementById('sFNameId').value+'&trade='+document.getElementById('tradeId').value+'&age='+document.getElementById('ageId').value+'&totalServYrs='+document.getElementById('totalServ').value+'&lastName='+document.getElementById('sLNameId').value);"/>
</div>

<div class="clear"></div>
</div>

<div class="clear"></div>

<input type="button" class="buttonBig" value="Life Style Factors" onclick="openPopupForLifestyleHabit();" tabindex="1">
<input type="button" class="button" value="Immunization" onclick="openPopupForImmunization();" tabindex="1">
<!--<input type="button" class="button" value="Allergies" onclick="openPopupForAllergies();" tabindex="1">
-->
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>

 <input id="Hidden1" type="hidden" runat="server" validate=',metachar,no'/> 
 <input	id="Hidden2" type="hidden" runat="server" validate=',metachar,no'/> 
 <input id="Hidden3" name="hicSrNo" type="hidden" runat="server" validate=',metachar,no'/> 
 <input id="Hidden4" name="flag" type="hidden" runat="server" validate=',metachar,no'/> 

 <input type="button" name="Submit11" value="Submit" tabindex="1" class="button"	onClick="if(checkPatientStatus() && checkNameSpaces() ){submitRegistration()}" />
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onClick="submitFormForButton('registration','/hms/hms/registration?method=showRegistrationJsp');" accesskey="r" />
<input type="button" name="preVisit" value="Previous Visits" class="button" onclick="if(checkHinId()){showPrevVisit()}"/>
<input type="button" name="appointment" value="Appointment" class="button" onclick="submitFormForButton('registration','/hms/hms/adt?method=showPatientAppointmentJsp','checkTargetForNo')"/>
<input type="button" name="trackPt" value="Patient Track" class="button" onclick="submitFormForButton('registration','/hms/hms/adt?method=showPatientTrackJsp','checkTargetForNo')"/>
<input type="button" name="import hic" value="Import HIC"	class="button" tabindex="1" onclick="javascript:ReadFingerPrint() ;"/>
 <input	type="button" name="Checkout" value="update hic" class="button"	tabindex="1" onclick="checkoutToHic();" />
<input type="button" class="button" name="search" value="Search" onclick="submitFormForButton('registration','/hms/hms/adt?method=showAdmissionJsp','checkTargetForNo')">
<input type="button" name="regCard" value="Print Reg Card" class="button" onclick="if(checkHinId()){printRegCard()}"/>

<div id="saveAdmission" style="display: none;">
<input	type="button" name="Submit" value="Save &amp; Admission" tabindex="1"	class="buttonbig"
	onClick="if(displayWarning()){submitForm('registration','/hms/hms/registration?method=submitPatientInformation');}" />
<input type="reset" name="Reset" value="Reset" class="button" 	tabindex="1" onClick="{clearHin();}" accesskey="r" />
</div>

<script>
function displayForm44(val){
if(val == 'Form-44'){
	document.getElementById('form44').style.display='none';
}else{
	document.getElementById('form44').style.display='none';
}

}
function displayAFMSF7A(val){
	if(val == 'AFMSF-7A'){
		document.getElementById('AFMSF7A').style.display='inline';
	}else{
		document.getElementById('AFMSF7A').style.display='none';
	}

	}
function clearHin(){
	document.getElementById('hinNoDivId').innerHTML = "";
	document.getElementById('hinNoId').value='';
}

function checkHinId(){
	if(document.getElementById('regHinId').value==0){
		alert("Please select HIN.");
		return false;
	}
	return true;
}
function displayWarning(){
	if(document.getElementById('hinNoId').value==''){
		 for(var i = 0; i < document.getElementsByName('reportingFor').length; i++){
			if(document.getElementsByName('reportingFor')[i].checked == true)
	        {
				return true;
		    }		
		 }
	alert("Please select reporting option.")
	return false;
	}
	return true;
}


</script>
<div class="clear"></div>
<div class="division"></div>

<!-- Dependent Details -->
<div id="depenedentDiv">
<%

	int cnt = 1;
	if(hicDtmap.get("rs")!= null){
		rs = (ResultSet)hicDtmap.get("rs");
	
%>

<h4>Dependent Details</h4>
<div id="reg">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Name</th>
		<th scope="col">DOB</th>
		<th scope="col">Relation</th>
		<th scope="col">Income</th>
		<th scope="col">Employment Status</th>
		<th scope="col">Age</th>
		<th scope="col">Gender</th>
		<th scope="col">Date of Dependency</th>
		<th scope="col">Authority</th>
		<th scope="col">Date of Removal From Dependency</th>

	</tr>
	<%
	while(rs.next()){
	%>
	<tr
		onclick="getPatientDetails('/hms/hms/registration?method=getPatientDetails&cnt=<%=cnt %>');calculateAgeInAjax();">
		<td><%= rs.getString(1)%>
		<input type="hidden" name="depnName<%= cnt %>" value="<%=  rs.getString(1) %>" />
		</td>
		
		<%
			if(rs.getDate(3)!= null){
		%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(rs.getDate(3)) %> 
		<input type="hidden" name="depDob<%= cnt %>"value="<%= HMSUtil.convertDateToStringWithoutTime( rs.getDate(3)) %>" />
		</td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		<td><%=rs.getString(2) %>
		<input type="hidden" name="rel<%= cnt %>" value="<%=  rs.getString(2) %>" />
		</td>
			
			<%
			if(rs.getString(9) != null){
			%>
			<td><%=rs.getString(9) %>
			<input type="hidden" name="income<%= cnt %>" value="<%=  rs.getString(9) %>" />
			</td>
			<%}else{ %>
			<td>&nbsp;</td>
			
			<%} %>
			
			<%
			if(rs.getString(7) != null){
			%>
			<td><%=rs.getString(7) %>
			<input type="hidden" name="occupation<%= cnt %>" value="<%=  rs.getString(7) %>" /></td>
			<%}else{ %>
			<td>&nbsp;</td>
			
			<%} %>
			
			<% if(rs.getString(6)!= null){ %>
			<td><%=rs.getString(6) %>
			<input type="hidden" name="depage<%= cnt %>" value="<%=  rs.getString(6) %>" />
			</td>
			<%}else{ %>
			<td>&nbsp;</td>
			<%} %>
		<%
			if(rs.getString(4)!= null){
				
				int admsexId = 0;
				String adSex = "";
				for(Object[] sex: sexList){
				if(sex[3] != null && sex[3].equals(rs.getString(4))){
					admsexId = (Integer)sex[0];
					adSex = sex[1].toString();
				}
			}
			
		%>
		<td><%=adSex %> 
		<input type="hidden" name="depSex<%= cnt %>" value="<%=  admsexId %>" />
		</td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		<%
			if(rs.getDate(5) != null){
		%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(rs.getDate(5))  %>
		<input type="hidden" name="dependencyDate<%= cnt %>" value="<%=  HMSUtil.convertDateToStringWithoutTime(rs.getDate(5)) %>" /></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
	<% if(rs.getString(8)!= null){ %>
			<td><%=rs.getString(8) %>
			<input type="hidden" name="authority<%= cnt %>" value="<%=  rs.getString(8) %>" />
			</td>
			<%}else{ %>
			<td>&nbsp;</td>
			<%} %>
			
			<td>&nbsp;</td>
			
<td>&nbsp;</td>
	</tr>
	<% cnt++;}
	rs.close();%>
</table>
</div>
<% 

}%>
<input type="hidden" name="depCount" value="<%= cnt %>" /> 
</div>
<div class="paddingTop15"></div>
<input type="hidden" name="<%=SERVICE_STATUS_ID %>" id="serviceStatusId" value="0">

<div id="statusMessage" class="messagelabel">
</div>
<table id="immuGrid" style="display: none;"></table>
<input type="hidden" name="immCount" value="0" id="immCount"/> 


<table id="allergyGrid" style="display: none;"></table>
<input type="hidden" name="allergyCount" value="0" id="allergyCount"/> 

<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>

</form>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<script type="text/javascript">
var countries=new ddtabcontent("countrytabsIn")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()


function displayOtherCmd(cmd){
	if(cmd=='other'){
		document.getElementById('addCmdDiv').style.display='inline';
		document.getElementById('addCmd').setAttribute('validate','Command Name,string,yes');
	}else{
		document.getElementById('addCmdDiv').style.display='none';
		document.getElementById('addCmd').setAttribute('validate','Command Name,string,no');
	}
}

function displayOtherStn(stn){
	if(stn=='other'){
		document.getElementById('addStnDiv').style.display='inline';
		document.getElementById('addStn').setAttribute('validate','Station Name,string,yes');
	}else{
		document.getElementById('addStnDiv').style.display='none';
		document.getElementById('addStn').setAttribute('validate','Station Name,string,no');
	}
}


function displayOtherUnit(unit){
	if(unit=='other'){
		document.getElementById('addUnitDiv').style.display='inline';
		document.getElementById('newUnitId').setAttribute('validate','Unit Name,string,yes');
	}else{
		document.getElementById('addUnitDiv').style.display='none';
		document.getElementById('newUnitId').setAttribute('validate','Unit Name,string,no');
	}
}

function displayOtherSec(sec){
	if(sec=='other'){
		document.getElementById('addSecDiv').style.display='inline';
		document.getElementById('addSec').setAttribute('validate','Section Name,string,yes');
	}else{
		document.getElementById('addSecDiv').style.display='none';
		document.getElementById('addSec').setAttribute('validate','Section Name,string,no');
	}
}

function displayOtherTrade(trd){
	if(trd=='31'){// 31 for other
		document.getElementById('addTradeDiv').style.display='inline';
		document.getElementById('newTradeId').setAttribute('validate','Trade Name,string,yes');
	}else{
		document.getElementById('addTradeDiv').style.display='none';
		document.getElementById('newTradeId').setAttribute('validate','Trade Name,string,no');
	}
}


function openJspForCheckout(){

	 window2 = window.open('/hms/hms/registration?method=showMedExamForHICUpdate','windowRef','left=0,top=0,width=1020,height=400,scrollbars = yes');
}

function setMaritalStatus(){
	var rel = document.getElementById('relationId').value;

	/*
		Setting marital status according to relation
	*/
	if(rel == '10' || rel == '11'){  // 10 for wife and 11 for husband
		document.getElementById('mrstatus').value = '2'; // married
	}else{
		document.getElementById('mrstatus').value = '0'; 
	}
	/*
	Setting gander according to relation
	*/
	if(rel == '10' || rel == '3'  || rel == '6' || rel == '12'){  // 10 for wife,3 for mother, 6 for daughter,12 for sister 
		document.getElementById('gender').value = '2'; //female
	}else{
		document.getElementById('gender').value = '3'; 
	}

	if(rel == '8'){  // only for service person(relation self)
		document.getElementById('medCatDiv').style.display='block';
	}
	else{
		document.getElementById('medCatDiv').style.display='none';
	}
}

<%
if(map.get("hicDtmap")==null){
%>

document.getElementById('serviceNoId').focus();
<%}%>
</script>


<script type="text/javascript">
<%
if(rsEmp != null){
		while(rsEmp.next()){
%>
	var fullName = '<%=rsEmp.getString(1)%>';
	var sFName ="";
	var sMName ="";
	var sLName ="";
	if((fullName).indexOf(' ') >= 0)
		sFName = (fullName).substring(0,(fullName).indexOf(' '))
	else
		sFName = (fullName);
	
	if(fullName.indexOf(' ') >= 0 && (fullName).lastIndexOf(' ') >=0)
		sMName = (fullName).substring((fullName).indexOf(' '),(fullName).lastIndexOf(' '));

	if((fullName).lastIndexOf(' ') >=0)
    	sLName = (fullName).substring((fullName).lastIndexOf(' '));

	document.getElementById('sFNameId').value = sFName;
	document.getElementById('pFirstNameId').value =sFName;

	document.getElementById('sMNameId').value = sMName;
	document.getElementById('pMiddleNameId').value = sMName;

	document.getElementById('sLNameId').value = sLName;
	document.getElementById('pLastNameId').value = sLName;

	<%
	int rankId =0;
	for(Object[] rank : rankList){
		if(rank[4]!= null && rank[4].toString().equalsIgnoreCase(rsEmp.getString(4))){
			rankId = (Integer)rank[0];
		}
	}
	%>
	document.getElementById('rankId').value = '<%=rankId%>'
		<%
		int unitId =0;
		for(Object[] unit : unitList){
			if((String)unit[3] != null ){
			if(rsEmp.getString(5) != null && ((String)unit[3]).equalsIgnoreCase(rsEmp.getString(5))){
				unitId = (Integer)unit[0];
				break;
			}
			}
		}
		%>
	document.getElementById('unitId').value = '<%=unitId%>'
	document.getElementById('serviceNoId').value = '<%=rsEmp.getString(6)%>'
	<%
		int sexId = 0;
		for(Object[] sex: sexList){
		if(sex[3] != null && rsEmp.getString(7) != null && sex[3].toString().trim().equalsIgnoreCase(rsEmp.getString(7).trim())){
			sexId = (Integer)sex[0];
		}
	}
	%>
	document.getElementById('srSexId').value = '<%=sexId%>'
	document.getElementById('gender').value = '<%=sexId%>'

	<%
		if(rsEmp.getDate(8)!= null){
	%>
	document.getElementById('srdobId').value = '<%=HMSUtil.convertDateToStringWithoutTime(rsEmp.getDate(8))%>'
	document.getElementById('dobId').value = '<%=HMSUtil.convertDateToStringWithoutTime(rsEmp.getDate(8))%>'
		<%}%>
	<%
	if(rsEmp.getString(9)!=null){
		int bldgrpId = 0;
		for(Object[] bld : bloodGroupList){
			if(bld[2] != null && bld[2].toString().equalsIgnoreCase(rsEmp.getString(9))){
				bldgrpId = (Integer)bld[0];
			}
		}
	%>
	document.getElementById('srBldGrp').value = '<%=bldgrpId%>'
	<%}%>
	<%
	if(rsEmp.getDate(10)!= null){
	%>
	document.getElementById('commissionDateId').value = '<%=HMSUtil.convertDateToStringWithoutTime(rsEmp.getDate(10))%>'

<%}%>

		<%
		int trdId = 0;
		for(Object[] trd : tradeList){
		if(trd[1] != null && trd[1].toString().equalsIgnoreCase(rsEmp.getString(12))){
			trdId = (Integer)trd[0];
		}
	}
	%>
	document.getElementById('tradeId').value = '<%=trdId%>'

<%
	if(rsEmp.getString(13) != null){
		String suffix ="";
		suffix = (rsEmp.getString(13)).substring((rsEmp.getString(13)).indexOf("-")+1);
%>
document.getElementById('suffixId').value = '<%=suffix%>'
<%}%>	
<%int religionId =0;
if(rsEmp.getString(14) != null){
	String hicCode = rsEmp.getString(14).substring(0,1);
	for(Object[] religion : religionList){
		if(religion[2]!=null){
			String smcCode = religion[2].toString().substring(0,1);
			if(smcCode.equalsIgnoreCase(hicCode)){
			religionId = (Integer)religion[0];
			}
		}
	}
%>
document.getElementById('religionId').value = '<%=religionId%>'
<%
}%>
<%
if(rsEmp.getString(15) != null){
	
%>
document.getElementById('addr').value = '<%=rsEmp.getString(15)%>'
<%}%>

	calculateSRAgeInAjax();
	calculateAgeInAjax();
	<%
	if(rsEmp.getDate(10)!= null){
	%>
	calculateTotalService(('<%=HMSUtil.convertDateToStringWithoutTime(rsEmp.getDate(10))%>'));

<%}%>

<%
int mrId = 0;
for(Object[] maritalStatus : maritalStatusList){
if(maritalStatus[2] != null && rsEmp.getString(16)!= null  && maritalStatus[2].toString().equalsIgnoreCase(rsEmp.getString(16))){
	mrId = (Integer)maritalStatus[0];
	
}
}
%>
document.getElementById('srmrstatus').value = '<%=mrId%>'
document.getElementById('mrstatus').value = '<%=mrId%>'

<%
if(rsEmp.getString("identification1")!= null){
%>
document.getElementById('identificationMark1').value = '<%=rsEmp.getString("identification1")%>'
<%}%>
<%
if(rsEmp.getString("identification2")!= null){
%>
document.getElementById('identificationMark2').value = '<%=rsEmp.getString("identification2")%>'
<%}%>
<%
if(rsEmp.getString("name")!= null){
%>
document.getElementById('srnokNameId').value = '<%=rsEmp.getString("name")%>'
<%}%>
<%
if(rsEmp.getString("address")!= null){
%>
document.getElementById('srnextOfKinAdd').value = '<%=rsEmp.getString("address")%>'
<%}%>
<%
if(rsEmp.getString("telephone")!= null){
%>
document.getElementById('srnok1Phone').value = '<%=rsEmp.getString("telephone")%>'
<%}%>
<%
if(rsEmp.getString("pin")!= null){
%>
document.getElementById('srnok1PinCode').value = '<%=rsEmp.getString("pin")%>'
<%}%>
<%}
		rsEmp.close();
} 

List<Patient> patientList = new ArrayList<Patient>();
if(hicDtmap.get("patientList") != null){
	patientList = (List<Patient>)hicDtmap.get("patientList");
}
if(patientList.size() == 0){
	%>
getHin();
	
<%}else{
	%>
	document.getElementById('regHinId').value = '<%=patientList.get(0).getId()%>'
<%}

if(hicDtmap.get("srStatus") != null){
		String srStatus = (String)hicDtmap.get("srStatus") ;
%>

alert('<%=srStatus%>');
<%} %>


function checkNameSpaces(){
var errorMsg ="";
if(document.getElementById("serviceTypeId").value != 7){
	if(document.getElementById('sFNameId').value =="" || trimAll(document.getElementById('sFNameId').value) ==""){
		errorMsg =errorMsg+"Service person first name can not be blank or spaces .! \n"
	}
	}
	if(document.getElementById('pFirstNameId').value =="" || trimAll(document.getElementById('pFirstNameId').value) ==""){
		errorMsg =errorMsg+"First name can not be blank or spaces ..!\n"
	}
			var reporting = ""; 
			 for(var i = 0; i < document.getElementsByName('reportingFor').length; i++){
					if(document.getElementsByName('reportingFor')[i].checked == true)
			        {
						if(document.getElementsByName('reportingFor')[i].value=='OPD' || document.getElementsByName('reportingFor')[i].value=='FollowUp' || document.getElementsByName('reportingFor')[i].value=="FamilyWC" || document.getElementsByName('reportingFor')[i].value=="Dental"){
							reporting = document.getElementsByName('reportingFor')[i].value;
							break;
						}
				    }		
				 }
		if(document.getElementById('consultingDocId').value=='0'){
			 	if(reporting=="OPD" || reporting=="FollowUp" || reporting=="FamilyWC" || reporting=="Dental" || reporting=="Dental" ){
			 		errorMsg += "Please select Medical Officer.\n";
			 	}
			 	if(document.getElementById('medExamCategory').value == "Medical Case Sheet(AFMSF-7A)"||document.getElementById('medExamCategory').value == "AFMSF-7A"|| document.getElementById('medExamCategory').value == "Form-44(AFMSF-44)" ){
			 		errorMsg += "Please select Medical Officer.\n";	
			 	}
		}
		if(reporting=="FollowUp" ){
			if(document.getElementById('followUpDepartment').value==''){
		 		errorMsg += "Please select Department.";
		 	}
		}
		if(document.getElementById('srnokNameId').value!='' && document.getElementById('srrelId').value=='0'){
			errorMsg +="Please select Relation of NOK1.\n";
		}
		if(document.getElementById('srnok2NameId').value!='' && document.getElementById('srnok2RelId').value=='0'){
			errorMsg +="Please select Relation of NOK2.\n";
		}
		if(document.getElementById('nokNameId').value!='' && document.getElementById('relId').value=='0'){
			errorMsg +="Please select Relation of NOK1 in dependent details.\n";
		}
		if(document.getElementById('nok2NameId').value!='' && document.getElementById('nok2RelId').value=='0'){
			errorMsg +="Please select Relation of NOK2 in dependent details.\n";
		}
		
		if(errorMsg ==""){
			return true
		}else{
			alert(errorMsg)
			return false
		}		
	
}

function setDepartmentValue(doctorId){
	var dcId;
	var deptId = 0;
	var roomNo = '';
	<%
		for(Object[] emp : doctorList){
	%>			
		dcId = '<%=emp[0]%>';
		if(doctorId == dcId){
			<%
				if(emp[6]!= null){
			%>
			deptId = '<%=(Integer)emp[6]%>';
			<%}%>
			<%
				if(emp[7]!=null){
			%>
				roomNo = '<%=(Integer)emp[7]%>';
			<%}%>
		}	
	<%}%>
	
	document.getElementById('deptId').value=deptId;
	document.getElementById('roomNoId').value=roomNo;
}

function displayMedExam(obj){
	if(obj.checked){
		if(document.getElementById('medExamCategory'))
			document.getElementById('medExamCategory').setAttribute('validate','Exam Category,string,yes');
		document.getElementById('medExamCategoryDiv').style.display='block';
		
	}else {
		if(document.getElementById('medExamCategory'))
			document.getElementById('medExamCategory').setAttribute('validate','Exam Category,string,no');
	
		document.getElementById('medExamCategoryDiv').style.display='none';
	
	}
}
function displayMedBoard(obj){
	if(obj.checked){
		if(document.getElementById('medBoardCategory'))
			document.getElementById('medBoardCategory').setAttribute('validate','Board Category,string,yes');
		document.getElementById('medBoardCategoryDiv').style.display='block';
		
	}else {
		if(document.getElementById('medBoardCategory'))
			document.getElementById('medBoardCategory').setAttribute('validate','Board Category,string,no');
		document.getElementById('medBoardCategoryDiv').style.display='none';
	
	}
}
function displayFWC(obj){
	if(obj.checked){
		if(document.getElementById('fwcCategory'))
			document.getElementById('fwcCategory').setAttribute('validate','FWC Category,string,yes');
		document.getElementById('fwcCategoryDiv').style.display='block';
		
	}else {
		if(document.getElementById('fwcCategory'))
			document.getElementById('fwcCategory').setAttribute('validate','FWC Category,string,no');
	
		document.getElementById('fwcCategoryDiv').style.display='none';
	
	}
}
function callFunctions(val){
	if(validateMetaCharacters(val) ){
		setTimeout("checkServiceType("+val+")", 800);
	}
	

}

function setServiceStatus(rankVal){
	if(rankArr.length > 0){
		for(var i=0;i<rankArr.length;i++){
			if(rankArr[i][1] == rankVal){
				document.getElementById('serviceStatusId').value=rankArr[i][3];
			break;
			}
		}
	}
}

if(<%=hinId%>!='0'){
	var srNo = '<%=serviceNo%>';
	var srType = '<%=serviceTypeId%>';
	var hinId = '<%=hinId%>';
	var type = 'registration';
	if(validateMetaCharacters(srNo) && validateMetaCharacters(srType) && validateMetaCharacters(hinId) && validateMetaCharacters(type)){
		getServicePersonName('registration','registration?method=getServicePersonName&type='+type+'&serviceNo='+srNo+'&serviceTypeId='+srType+'&hinId='+hinId);
	}
	if(validateMetaCharacters(hinId))
		setTimeout('displayPatientInfo(<%=hinId%>)',5000)
}else{getHin();}



function openPopupForImmunization(){
	var hinId = document.getElementById('regHinId').value;
	if(validateMetaCharacters(hinId))
	 newwindow = window.open('/hms/hms/registration?method=openPopupForImmunization&hinId='+hinId,'windowRef','left=0,top=0,width=1020,height=400,scrollbars = yes');
}

function openPopupForLifestyleHabit(){
	
	var gender;
	var rel = document.getElementById('relationId').value;
	if(rel=='8'){
		gender = document.getElementById('srSexId').value;
	}else{
		gender = document.getElementById('gender').value;
	}
	var hinId=document.getElementById('regHinId').value;
	var hinNo = document.getElementById('hinNoId').value;
	
	if( validateMetaCharacters(gender) && validateMetaCharacters(hinId) && validateMetaCharacters(hinNo)){
		var url = '/hms/hms/registration?method=showLifestyleJsp&hinId='+hinId+'&hinNo='+hinNo+'&gender='+gender;
	 	newwindow = window.open(url,'windowRef','left=0,top=0,width=1020,height=700,scrollbars = yes');
	}
}
/*
function openPopupForAllergies(){
	 newwindow = window.open('/hms/hms/registration?method=openPopupForAllergies&hinId='+document.getElementById('regHinId').value,'allergy','left=0,top=0,width=1020,height=400,scrollbars = yes');
}*/

function populateStationForUnit(unit){
	if(unit!='other'){
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
}
function populateCommandForStation(stn){
	if(stn!='31'){
	var cmd = 0;
	for(i=0;i<stnArr.length;i++){
		if(stnArr[i][2] == stn){
			cmd = stnArr[i][0];
		break;		
			}
		}
	document.getElementById('commandId').value = cmd;
	}
}

function populateStateForCity(city,stateFieldId){
	var state = 0;
	for(i=0;i<districtArray.length;i++){
		if(districtArray[i][1] == city){
			state = districtArray[i][0];
			break;		
			}
		}
	document.getElementById(stateFieldId).value = state;
	if(stateFieldId == 'srstateId'){
		document.getElementById('stateId').value = state;
	}
	
}
function displayDepartment(obj){
	if(obj.checked){
		document.getElementById('followUpDiv').style.display='inline';
	}else if(!obj.checked){
		document.getElementById('followUpDiv').style.display='none';
	}
	
}
function checkReporting(){
	if(document.getElementById('hinNoId').value!=""){
		document.getElementById("followupid").disabled=true;
		//document.getElementById('followUpDiv').style.display='none';
	}else{
		document.getElementById("followupid").disabled=false;
	//	document.getElementById('followUpDiv').style.display='inline';
	}
}

function openOtherField(familyHistoryId,fieldId){
	var sel = '';
	if(fieldId=='srfamilyHistory'){
		sel = document.getElementById("srfamilyHistory");
	}else if(fieldId=='familyHistory'){
		sel = document.getElementById("familyHistory");
	}
	var listLength = sel.options.length;
	var fhId="";
	
	for(var i=0;i<listLength;i++){
	   if(sel.options[i].selected){
		   fhId=sel.options[i].value;
			if(fhId=='8'){
				if(fieldId=='srfamilyHistory'){
					document.getElementById('otherSrFamilyHistoryDiv').style.display = 'block';
				}else if(fieldId=='familyHistory'){
					document.getElementById('otherFamilyHistoryDiv').style.display = 'block';
				}
			}
			
	   }
	}
	/*if(familyHistoryId == '8'){
		if(fieldId=='srfamilyHistory'){
			document.getElementById('otherSrFamilyHistoryDiv').style.display = 'block';
		}else if(fieldId=='familyHistory'){
			document.getElementById('otherFamilyHistoryDiv').style.display = 'block';
		}
	}*/
	
}
function  copyAddress(val,objId){
	if(val!=''){
		if(objId == 'nok2NameId'){
		document.getElementById('nok2Add').value = document.getElementById('sraddr').value;
		}
		if(objId == 'nokNameId'){
		document.getElementById('nextOfKinAdd').value = document.getElementById('sraddr').value;
		}
	}
	
}

function checkPatientStatus(){
	var flag = '';
	for(var i = 0; i < document.getElementsByName('reportingFor').length; i++){
		if(document.getElementsByName('reportingFor')[i].checked == true)
        {
			flag = 'visit';
			break;
        }
	}
	if(flag=='visit'){
		if(document.getElementById('patientStatus') && document.getElementById('patientStatus').value=='In Patient'){
			alert("Patient is Admitted.")
			return false;
		}
	}
	if(document.getElementById('patientStatus') && document.getElementById('patientStatus').value=='Expired'){
		alert("Patient is dead.")
		return false;
	}
	return true;
	
}

function checkGenderForFP(val){
 if(val== 'FAMILY PLANNING' && document.getElementById('gender').value != '3'){
	alert("Please check the gender.");
//	document.getElementById('fwcCategory').value = '';
	return false;
 }
 return true;
	
}
function checkGenderForFemale(val){
	 if(val == 'ANC' && val == 'ANC FOLLOW UP' && val == 'PNC'  && document.getElementById('gender').value != '2'){
		alert("Please check the gender.");
//		document.getElementById('fwcCategory').value = '';
		return false;
	 }
	 return true;
		
	}

function validateDuration(val, fieldId){
		if(val != "" || val == '0'){
			if(!validateInteger(val)){
				alert("Duration should be an integer value.");
				document.getElementById(fieldId).value = "";
				document.getElementById(fieldId).focus();
				return false;
			}
		}else if(val == "" ){
			alert("Duration  should be geater than 0.");
			document.getElementById(fieldId).value = "";
			document.getElementById(fieldId).focus();
			return false;
		}
		return true;
}
function submitRegistration(){
	var flag ='registration';
	if(validateMetaCharacters(flag))
		submitForm('registration','/hms/hms/registration?method=submitPatientInformation&flag='+flag,'checkTargetForNo');
}
function showPrevVisit(){
	var flag ='registration';
	var hinId = document.getElementById('regHinId').value;
	if(validateMetaCharacters(flag) && validateMetaCharacters(hinId))
		submitFormForButton('registration','/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&flag='+flag+'&hinId='+hinId,'checkTargetForNo');
}
function printRegCard(){
	var hinNo = document.getElementById('printHinNo').value;
	var priscriptionSlip ='o';
	if(validateMetaCharacters(hinNo) && validateMetaCharacters(priscriptionSlip))
		submitFormForButton('registration','/hms/hms/registration?method=printRegistrationCard&hinNo='+hinNo+'&priscriptionSlip='+priscriptionSlip);
}
function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31
     && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

function checkForCheckUP()
{
	alert("checkUP")
	 var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
   xmlHttp.onreadystatechange=function()
   {
     if(xmlHttp.readyState==4){
     
     	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		
     	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var exists  = item.getElementsByTagName("popUP")[0];
	     // alert("a::::;"+exists.childNodes[0].nodeValue);
	        if(exists.childNodes[0].nodeValue =="yes"){
	        	alert("popup---yes");
	        	get_serviceNO_Relations();
	        }
	   	} 
     }
   }
     
	 var url='/hms/hms/registration?method=checkPopUpForReg&serviceNoId='+document.getElementById('serviceNoId').value+'&serviceStatusId='+document.getElementById('serviceStatusId').value+'&serviceTypeId='+document.getElementById('serviceTypeId').value+'&relationId='+document.getElementById('relationId').value; 

   xmlHttp.open("POST",url,true);
   xmlHttp.setRequestHeader("Content-Type", "text/xml");
   xmlHttp.send(null); 
	
}

function get_serviceNO_Relations()
{ 
	//for ON or OFF
     var showPOPUPforSYNC=true;
     if(showPOPUPforSYNC==true)
	 {
    		
	 		 var url='/hms/hms/registration?method=getServiceNORelationsPopUp&serviceNoId='+document.getElementById('serviceNoId').value+'&serviceStatusId='+document.getElementById('serviceStatusId').value+'&serviceTypeId='+document.getElementById('serviceTypeId').value+'&relationId='+document.getElementById('relationId').value; 
	   		 window.open(url);
	   
	 }
     else
	 {
	    return true;
	 }


}
</script>
