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
	classid="5974956E-9411-4d1f-869A-004159970"
	type="application/x-oleobject" codebase="../HICCARDUPDATE.cab"
	VIEWASTEXT></object>

<script type="text/javascript">

function checkoutToHic(){
var url = "http://localhost/HIC/Default.aspx";
window.open(url,'windowRef','width=600,height=400,scrollbars = yes');
}

    function ReadFingerPrint()
       {
         // var obj = new ActiveXObject('Fingerprintreadclass.fingerprint');
     //    var ReaderStatus=obj.WriteReaderName('OMNIKEY CardMan 5x21-CL 0');
     //     var serviceno=obj.ReadServiceNo();
         var serviceno=document.getElementById('serviceNoId').value
           document.getElementById('Hidden3').value=serviceno;
     //    var fpinitial=obj.UltraSanInisalize(); 
     //    var fpstatus = obj.CheckFingerPrint();

           var fpstatus="true";
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
			String time = (String)utilMap.get("currentTime");
	 
	 		Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
	
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			
			List<MasServiceType> serviceTypeList =null;
			List<MasRelation> relationList = null;
			List<MasRank> rankList = null;
			List<Object[]> unitList = null;
			List<MasTitle> titleList = null;
			List<MasMaritalStatus> maritalStatusList = null;
			List<MasTrade> tradeList = null;
			List<MasReligion> religionList = null;
			List<MasCountry> countryList = null;
			List<MasState> stateList = null;
			List<MasDistrict> districtList = null;
			List<MasRecordOfficeAddress> recordOfficeAddressList =null;
			List<MasBloodGroup> bloodGroupList = null;
			List<MasOccupation> occupationList = null;
			List<MasEmployee> doctorList = null;
			List<MasAdministrativeSex> sexList = null;
			List<MasDepartment> departmentList = null;
			List<MasServiceStatus> serviceStatusList = null;
			List<MasStation> stationList = null;
			List<MasSection> sectionList = null;
			List<MasReporting> reportingList = null;
			List<MasCommand> commandList = null;
			List<PatientFamilyHistory> familyHistoryList = null;
			if(map.get("serviceTypeList") != null){
				serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
			}
			if(map.get("rankList") != null){
				rankList= (List<MasRank>)map.get("rankList");
			}
			if(map.get("unitList") != null){
				unitList= (List<Object[]>)map.get("unitList");
			}
			if(map.get("titleList") != null){
				titleList = (List<MasTitle>)map.get("titleList");
			}
			if(map.get("maritalStatusList") != null){
				maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
			}
			if(map.get("tradeList") != null){
				tradeList = (List<MasTrade>)map.get("tradeList");
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
			if(map.get("relationList") != null){
				relationList = (List<MasRelation>)map.get("relationList");
			}
			if(map.get("bloodGroupList") != null){
				bloodGroupList = (List<MasBloodGroup>)map.get("bloodGroupList");
			}
			if(map.get("occupationList") != null){
				occupationList = (List<MasOccupation>)map.get("occupationList");
			}
			if(map.get("employeeList") != null){
				doctorList = (List<MasEmployee>)map.get("employeeList");
			}
			if(map.get("recordOfficeAddressList") != null){
				recordOfficeAddressList = (List<MasRecordOfficeAddress>)map.get("recordOfficeAddressList");
			}
			if(map.get("religionList") != null){
				religionList = (List<MasReligion>)map.get("religionList");
			}
			if(map.get("sexList") != null){
				sexList = (List<MasAdministrativeSex>)map.get("sexList");
			}
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>)map.get("departmentList");
			}
			if(map.get("serviceStatusList") != null){
				serviceStatusList = (List<MasServiceStatus>)map.get("serviceStatusList");
			}
			if(map.get("stationList") != null){
				stationList = (List<MasStation>)map.get("stationList");
			}
			if(map.get("sectionList") != null){
				sectionList = (List<MasSection>)map.get("sectionList");
			}
			
			if(map.get("commandList") != null){
				commandList = (List<MasCommand>)map.get("commandList");
			}
			if(map.get("familyHistoryList") != null){
				familyHistoryList = (List<PatientFamilyHistory>)map.get("familyHistoryList");
			}
			List<Category> categoryList= new ArrayList<Category>();
			if(map.get("categoryList") != null){
				categoryList=(List)map.get("categoryList");
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
	<label><a href="#" rel="country1" class="selected" ><span>Service Personnel Details</span></a></label>
	<label style="display: none"><a href="#" rel="country2"><span onclick="javascript:hideMedExam('dependent');"> Dependent Details </span></a></label>
	
	<div id="srPhoto" class="photo">
	<img src="/hms/jsp/images/na.jpg" name="img1" width="105" height="105" id="img1" />
	</div>
</ul>

<div class="tabcontainerIn">
<div id="country1" class="tabcontentIn">
<h4>Service Details</h4>
<div class="clear"></div>

<input type="hidden" name="<%=REG_DATE %>" value="<%=currentDate %>" validate="Registration Date,String,no" readonly="readonly"	class="calDate" /> 
<input type="hidden" name="<%=REG_TIME %>" value="<%=time %>" validate="Registration Time,string,no" maxlength="20"	readonly="readonly" class="calDate" />
<div id="sNameDiv">
<div class="Block">
<!--<label>HIN</label>
--><label id="defaulthinno" class="value" style="display: none;">&nbsp;</label>
<label id="hinNoDivId" class="value" style="display: none;"></label>
<input id="hinNoId" type="hidden" name="<%=HIN_NO %>" value="" />
<div class="clear"></div>

<div id="srNoDiv" style="display: block;">
<label>Service No.<span>*</span></label>

<input 	id="prefix" name="<%=PREFIX%>" type="text" maxlength="3" class="auto" size="1"	tabindex="1" validate="Prefix,alphanumaric,no" /> 
<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1" validate="Service No,alphanumeric,yes" maxlength="20"
	onblur="validateServiceNo(this.value,'registration');submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=displaySrPhoto','srPhoto');submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getServiceNoDetailsForReg&serviceNo='+this.value,'depenedentDiv');"/>

<select id="suffixId" name="<%=SUFFIX%>" validate="Suffix,string,no"	tabindex="1" class="smallest2">
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
	onchange="populateRank('registration');getHin();">
	<option value="0">Select</option>
	<% 
			for(MasServiceStatus masServiceStatus : serviceStatusList){
				if(masServiceStatus.getId() == 1){
		%>
	<option value="<%=masServiceStatus.getId() %>" selected="selected"><%=masServiceStatus.getServiceStatusName() %></option>
	<%}else{%>
	<option value="<%=masServiceStatus.getId() %>"><%=masServiceStatus.getServiceStatusName() %></option>

	<%}
			}
				%>
</select>
</div>
<div class="clear"></div>
<label>HIN</label>
<select id="regHinId" name="regHinId" tabindex="1"  onchange="if(this.value!='0'){displayPatientInfo(this.value)}else{getHin();}"> 
<option value="0">Select</option>
</select>
<input type="hidden" name="printHinNo" id="printHinNo" value="">
<label>Service Type <span>*</span></label> 
<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>"	validate="Service Type,string,yes" tabindex="1"
	onchange="callFunctions(this.value)">
	<option value="0">Select</option>

	<% 
			for(MasServiceType masServiceType : serviceTypeList){
				if(masServiceType.getId() ==2){
		%>
	<option value="<%=masServiceType.getId() %>" selected="selected"><%=masServiceType.getServiceTypeName() %></option>
	<%}else{ %>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
	<%}
				}%>
</select>
<div id="rankDivId">
<label> Rank <span>*</span></label> 
<select	id="rankId" name="<%=RANK_ID%>" validate="Rank,string,yes" tabindex="1" onchange="">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		if(masRank.getServiceType().getId() == 2  && masRank.getServiceStatus().getId() == 1){
			%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}}%>
</select> 
</div> <!-- End Of rankDivId-->
<script type="text/javascript">
		
		<%
			int k=0;
			for (MasServiceType masServiceType : serviceTypeList) 
			{
				for (MasRank masRank : rankList) 
				{
					if(masRank.getServiceType() != null){
						if(masServiceType.getId().equals(masRank.getServiceType().getId())){
								%>
									rankArr[<%=k%>] = new Array();
									rankArr[<%=k%>][0] = <%=masRank.getServiceType().getId()%>;
									rankArr[<%=k%>][1] = <%=masRank.getId()%>;									
									rankArr[<%=k%>][2] = "<%=masRank.getRankName()%>";
									rankArr[<%=k%>][3] = "<%=masRank.getServiceStatus().getId()%>";
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
<input id="sFNameId" type="text" name="<%=S_FIRST_NAME %>" value="" tabindex="1"	title="First Name of Service Person"	validate="First Name of Service Person,alphaspace,yes" MAXLENGTH="15"	onblur="fillPatientName(this);" /> 

<label>Middle Name</label> 
<input	id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value=""	tabindex="1" validate="Middle Name of Service Person,alphaspace,no"	MAXLENGTH="15" onchange="fillPatientName(this);" />

<label>Last Name</label> 
<input id="sLNameId" type="text"	name="<%=S_LAST_NAME %>" value="" tabindex="1"	validate="Last Name of Service Person,alphaspace,no" MAXLENGTH="15"	onchange="fillPatientName(this);" />

<div id="srPrDtDiv">
<div class="clear"></div>

<label> Trade/Branch</label> 
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,string,no" tabindex="1"	onchange="displayOtherTrade(this.value);">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
	<option value="other">Other</option>
</select>


<div id="addTradeDiv" style="display: none;">
<label> Trade/Branch Name <span>*</span></label> 
<input id="newTradeId" type="text"	name="<%=TRADE_NAME%>" value="" tabindex="1"	validate="Trade Name,string,no" maxlength="30" tabindex="1" /> 
</div>

<label> DOE/DOC</label> 
<input type="text"	id="commissionDateId" name="commissionDate" tabindex="1" value=""	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.registration.commissionDate,event)" /> 
<input	type="hidden" id="idForComEnrlDate" value=""/> 

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
		
	 %>
	<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>

	<%}
	%>
	<option value="other">Other</option>

</select>
<div id="addSecDiv" style="display: none;">
<label>Section Name <span>*</span></label> 
<input type="text" id="addSec" name="sectionName" tabindex="1"	value="" maxlength="30" />
</div>

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

<div id="addUnitDiv" style="display: none;">
<label>Unit Name <span>*</span></label> 
<input id="newUnitId" type="text" name="<%=UNIT_NAME%>"	value="" tabindex="1" validate="Unit Name,string,no" maxlength="30"	tabindex="1" /> 
<label> Unit Address</label> 
<input	id="newUnitAddressId" type="text" name="<%=UNIT_ADDRESS %>" value=""	validate="Unit Address,string,no" maxlength="50" tabindex="1" /> 
</div>

<label>Station</label> 
<select	id="stationId" name="<%=STATION %>"	onchange="populateCommandForStation(this.value);displayOtherStn(this.value)"	tabindex="1">
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
<label>Station Name <span>*</span></label> 
<input type="text" id="addStn" name="stationName" tabindex="1"	value="" maxlength="30" />
</div>
<div class="clear"></div>
<label> Command</label> 
<select id="commandId" name="<%=COMMAND %>"	validate="Command,string,no" tabindex="1"	onchange="displayOtherCmd(this.value);">
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
<label>Command Name <span>*</span></label> 
<input type="text" id="addCmd" name="commandName" value=""	tabindex="1" maxlength="30" />
</div>
<script type="text/javascript">
		
		<%
			int n=0;
			for (MasCommand masCommand : commandList) 
			{
				for (MasStation masStation : stationList) 
				{
					if(masStation.getCommand() != null){
						if(masCommand.getId().equals(masStation.getCommand().getId())){
								%>
									stnArr[<%=n%>] = new Array();
									stnArr[<%=n%>][0] = <%=masCommand.getId()%>;
									stnArr[<%=n%>][1] = <%=masStation.getCommand().getId()%>;
									stnArr[<%=n%>][2] = "<%=masStation.getStationName()%>";									
									stnArr[<%=n%>][3] = "<%=masStation.getStationName()%>";
								<%
								n++;
						}
					}
				}
			}
		%>
		
		<%
			int m=0;
			for (MasStation stn : stationList) 
			{
				for (Object[] unit : unitList) 
				{
					if(unit[2]!= null){
						if(stn.getStationName().equals(unit[2])){
								%>
									unitArr[<%=m%>] = new Array();
									unitArr[<%=m%>][0] = <%=stn.getId()%>;
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
<option value="<%= masRecordOfficeAddress.getId() %>"><%= masRecordOfficeAddress.getAddress() %></option>
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
<select name="<%=SR_SEX %>" id="srSexId" validate="Service Person Gender,string,yes" tabindex="1"	onchange="fillPatientName(this);">
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

<label>DOB</label> 
<input type="text" id="srdobId" name="<%=SR_DOB %>"	tabindex="1" value="" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate"	onblur="calculateSRAgeInAjax();fillPatientName(this);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.registration.<%=SR_DOB%>,event)" />


<label>Age <span>*</span></label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId"	name="<%=SR_AGE%>" validate="Age of Service Person,string,yes"	tabindex="1" class="small"	onchange="fillPatientName(this);">
	<option value="">Select</option>
	<%
				for(int age1 = 16;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly"/>
</div>
<input type="hidden" id="idForSrAge" value=""/>

<div class="clear"></div>
<label>Marital Status</label> 
<select name="srMaritalStatus" id="srmrstatus"	validate="Marital Status of service Person,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
	%>
	<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
	<%}%>
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
<div id="afDiv">
<label>AFNET No.</label> 
<input id="afnetNo" name="afnetNo" type="text" tabindex="1"	maxlength="15" />
</div>
<div class="clear"></div>

<label>Telephone No.(Off.)</label> 
<input id="phoneNo" name="<%=TELEPHONE_NO %>" type="text" tabindex="1" maxlength="11" /> 
<label>Mobile No.</label> 
<input id="mobileNo" name="<%=MOBILE_NO %>" type="text" tabindex="1"	maxlength="11" />

<label>Telephone No.(Res.)</label> 
<input id="phoneNoRes" name="phoneNoRes" type="text" tabindex="1" maxlength="11" /> 
<div class="clear"></div>

<label>Other Contact No.</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="60" name="otherContactNo"></textarea>
<label>Local Address</label> 
<textarea name="<%=ADDRESS %>" id="addr"	cols="20" rows="2" tabindex="1" validate="Address,string,no"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
	
<label>City</label> 
<select name="<%=DISTRICT%>" validate="City,string,no" id="cityId" tabindex="1">
	<option value="0">Select</option>
	<%
		for(MasDistrict masDistrict : districtList){
	%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%		
		}%>
</select> 

<div class="clear"></div>

<label>Permanent Address</label> 
<textarea name="<%=PERMANENT_ADDRESS %>" id="peraddr"	cols="20" rows="2" tabindex="1" validate="Address,string,no"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
	
<label>City</label> 
<select name="permCityId" validate="City,string,no" id="perCityId" tabindex="1" onchange="populateStateForCity(this.value);">
	<option value="0">Select</option>
	<%
		for(MasDistrict masDistrict : districtList){
	%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%		
		}%>
</select> 
<input type="hidden" name="<%=STATE %>" id="state" value="0" />
<script>
<%
int i = 0;
for (MasState masState : stateList)
{
	for (MasDistrict masDistrict : districtList) 
	{
		if(masDistrict.getState() != null){
			if(masState.getId().equals(masDistrict.getState().getId() )){
					%>
						districtArray[<%=i%>] = new Array();
						districtArray[<%=i%>][0]=<%=masState.getId()%>;
						districtArray[<%=i%>][1] = <%=masDistrict.getId()%>;									
						districtArray[<%=i%>][2] = "<%=masDistrict.getDistrictName()%>";

					<%
					i++;
			}
		}
	}
}

%>
</script>
<label>Telephone No.</label> 
<input id="telephoneNoPerm" name="telephoneNoPerm" type="text" tabindex="1" maxlength="11" /> 
<div class="clear"></div>
<label>Police Station</label> 
<input id="policeStation" name="policeStation" type="text" tabindex="1" maxlength="15" /> 
<label>Pin Code</label> 
<input id="pinCode" name="pinCode" type="text" tabindex="1" maxlength="8" /> 

</div><!-- End Block 2-->
<div class="clear"></div>
<h4>NOK Details</h4>
<div class="clear"></div>
<div class="Block">
<h4> NOK1</h43>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="<%=NEXT_OF_KIN_NAME%>" value=""	validate="NOK1 Name,fullName,no" id="nokNameId" maxlength="30"/>
	
<label>  Relation</label> 
<select	name="<%=NEXT_OF_KIN_RELATION_ID %>" validate="NOK1 Relation,String,no"	id="relId">
	<option value="0">Select</option>

	<% 
	for (MasRelation  obj : relationList){
	%>
	<option value="<%=obj.getId()%>"><%=obj.getRelationName()%></option>
	<% 				
	}%>
</select>
<label> Contact No.</label> 
<input	type="text" name="<%=NEXT_OF_KIN_PHONE_NO%>" value=""	validate="NOK1 Phone No,phone,no" maxlength="16" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="<%=NEXT_OF_KIN_ADDRESS %>" id="nextOfKinAdd"	cols="20" rows="2" tabindex="1" validate="Nok1 Address,string,no"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<label>Police Station</label> 
<input id="nok1PoliceStation" name="nok1PoliceStation" type="text" tabindex="1" maxlength="15" /> 
<label>Pin Code</label> 
<input id="nok1PinCode" name="nok1PinCode" type="text" tabindex="1" maxlength="8" /> 
<div class="clear"></div>
	
<h3> NOK2</h3>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="nok2Name" value=""	validate="NOK2 Name,fullName,no" id="nok2NameId" maxlength="30"/>
	
<label>  Relation</label> 
<select	name="nok2RelationId" validate="NOK2 Relation,String,no"	id="nok2RelId">
	<option value="0">Select</option>

	<% 
	for (MasRelation  obj : relationList){
	%>
	<option value="<%=obj.getId()%>"><%=obj.getRelationName()%></option>
	<% 				
	}%>
</select>
<label> Contact No.</label> 
<input	type="text" name="nok2ContactNo" value=""	validate="NOK2 Contact No,phone,no" maxlength="16" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="nok2Address" id="nok2Add"	cols="20" rows="2" tabindex="1" validate="Nok2 Address,string,no"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<label>Police Station</label> 
<input id="nok2PoliceStation" name="nok2PoliceStation" type="text" tabindex="1" maxlength="15" /> 
<label>Pin Code</label> 
<input id="nok2PinCode" name="nok2PinCode" type="text" tabindex="1" maxlength="8" /> 
<div class="clear"></div>
</div><!-- End Block 3-->
</div><!-- End sNameDiv-->
<div class="clear"></div>


</div> <!-- End of country1 -->

<div clear="clear"></div>
<div id="country2" class="tabcontentIn">
<div class="Block">

<label>Relation <span>*</span> </label> 
<select	id="relationId" name="<%=RELATION_ID %>"	validate="Relation,string,yes" tabindex="1"
	onchange="if(checkForFirstRow()){checkPatientRegistration(); setMaritalStatus();}">
	<option value="0">Select</option>

	<%
	for(MasRelation relation : relationList){
		if(relation.getRelationName().equalsIgnoreCase("Self")){
%>
	<option value="<%=relation.getId() %>" selected="selected"><%=relation.getRelationName() %></option>
	<%}else{ %>
	<option value="<%=relation.getId() %>"><%=relation.getRelationName() %></option>
	<%}
		}%>

</select> 

<label> Title</label> 
<select id="titleId" name="<%=TITLE%>"	validate="Title,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
	 	for (MasTitle masTitle : titleList) 

		{ 
	 		if(masTitle.getTitleCode().equals(selectedTitleForReg)){

			%>
	<option value="<%=masTitle.getId() %>" selected="selected"><%=masTitle.getTitleName() %></option>
	<%		}else{ %>
	<option value="<%=masTitle.getId()%>"><%=masTitle.getTitleName()%></option>
	<%
					}
		}%>
</select> 
<div class="clear"></div>
<label> First Name <span>*</span></label> 
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"	title="First Name of the Patient"	validate="Patient First Name,alphaspace,yes" MAXLENGTH="15" />

<label>Middle Name</label> 
<input type="text" id="pMiddleNameId"	name="<%=P_MIDDLE_NAME%>" value="" tabindex="1"	validate="Patient Middle Name,name,no" MAXLENGTH="15" /> 

<label>Last Name</label> 
<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"	value="" validate="Patient Last Name,name,no" MAXLENGTH="15"	tabindex="1" /> 

<div class="clear"></div>

<label> Gender<span>*</span></label> 
<select	name="<%=GENDER %>" id="gender" validate="Gender,string,yes"	tabindex="1">
<%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
		   	 			if(masAdministrativeSex.getAdministrativeSexCode().equals(administrativeSexMaleCode)){
			%>
	<option value="<%=masAdministrativeSex.getId() %>" selected="selected"><%=masAdministrativeSex.getAdministrativeSexName().trim() %></option>
	<%		}else{ %>
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName().trim() %></option>
	<%
					}
		   	 	} %>
</select>


<label>DOB</label> 
<input type="text" id="dobId"	name="<%=DATE_OF_BIRTH %>" tabindex="1" value=""	onblur="calculateAgeInAjax();" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.registration.<%=DATE_OF_BIRTH%>,event)" />


<label> Age<span>*</span></label>
<div id="ageDiv" style="display: block;">
<select id="ageId"	name="<%=AGE%>" validate="Age of Patient,string,yes" tabindex="1"	class="smallest" >
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
<input type="hidden" id="idForAge" value=""/>
</div>

<div class="clear"></div>


<label> Marital Status</label>
<select name="<%=MARITAL_STATUS_ID %>"	id="mrstatus" validate="Marital Status,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
	
	%>
	<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
	<%}%>
</select> 

<label> Occupation</label> 
<select	id="occupation" name="<%=OCCUPATION_ID %>"	validate="Occupation,string,no" tabindex="1">
	<option value="0">Select</option>
	<%if(occupationList!=null && occupationList.size() >0){
	 for(MasOccupation masOccupation : occupationList){
	
	%>
	<option value="<%=masOccupation.getId()%>"><%=masOccupation.getOccupationName()%></option>
	<%}
	}%>
</select>

<label>Income</label>
<input type="text" name="income" id="income" value="" maxlength=""/>
<div class="clear"></div>

<label>Dependency Date</label>
<input type="text" id="depDate" name="dependencyDate" value="" readonly="readonly" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.registration.dependencyDate,event)" />
	
<label>Authority</label>
<input type="text" name="authority" id="authority" value="" maxlength=""/>

<label>Dependency Removal</label>
<input type="text" id="depRemovalDate" name="dependencyRemovalDate" value="" readonly="readonly" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.registration.dependencyRemovalDate,event)" />
	

<div class="clear"></div>

<label>Local Address</label> 
<textarea name="<%=ADDRESS %>" id="addr" cols="20" rows="2" tabindex="1" validate="Address,string,no"	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"	onblur="fillNokAddr();"></textarea>
	
<label>City</label> 
<select name="<%=DISTRICT%>"	validate="City,string,no" id="cityId" tabindex="1">
	<option value="0">Select</option>
	<%
		for(MasDistrict masDistrict : districtList){
	%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%		
		}%>
</select> 	
<label>Contact No.</label> 
<input type="text"	name="<%=CONTACT_NUMBER %>" id="contactNo" value=""	validate="Mobile Number,phone,no" MAXLENGTH="20" tabindex="1" />
<div class="clear"></div>
<label>Police Station</label> 
<input id="policeStation" name="policeStation" type="text" tabindex="1" maxlength="15" /> 
<label>Pin Code</label> 
<input id="pinCode" name="pinCode" type="text" tabindex="1" maxlength="8" /> 	
</div><!-- End Block 4 -->

</div> <!-- End of country2 -->
</div><!-- End of tabcontainerIn -->
<div class="clear"></div>
<h4>Medical Details</h4>
<div class="clear"></div>
<div class="Block">

<label>Blood Group</label> 
<select name="<%=BLOOD_GROUP_ID %>"	id="bldGrp" validate="Blood Group,string,no" tabindex="1">	
<option value="0">Select</option>
	<%
	 for(MasBloodGroup masBloodGroup : bloodGroupList){
	%>
	<option value="<%=masBloodGroup.getId()%>"><%=masBloodGroup.getBloodGroupName()%></option>
	<%}%>
</select>
<!--<label> Allergies</label> 
<input	type="text" name="drugAllergies" value=""	validate="Drug Allergies,string,no" maxlength="16" />

--><label>Family History</label> 
<select name="familyHistory" id="familyHistory" tabindex="1" multiple="multiple" class="list" onclick="openOtherField(this.value);">
 <option value="0">Select</option>
<%
	if(familyHistoryList.size() > 0){
		for(PatientFamilyHistory familyHistory : familyHistoryList){
		%>
		<option value="<%=familyHistory.getId() %>"><%=familyHistory.getPatientHistoryName() %></option>
	<%}
	}
%>
</select>
<div id="otherFamilyHistoryDiv" style="display: none;">
<label>Other</label>
<input type="text" name="otherFamilyHistory" id="otherFamilyHistory" value="" >
</div>
<div class="clear"></div>
<label>Present Med Cat  </label> 
 <select 	name="presentMedCat" id="presentMedCat" validate="Present Med Cat,string,no" tabindex=1>
 <option value="0">Select</option>
 <%
 for (Category category : categoryList) {
		%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%	}
				
 %>
 </select>
 <label>Period  </label> 
 <input type="text" name="medCatPeriod" id="medCatPeriod" value="" maxlength="20"/>
  <label>Date  </label> 
 <input type="text" name="medCatDate" id="medCatDate" value="" maxlength="10"  class="calDate"/>
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.registration.medCatDate,event)" /> 
	<div class="clear"></div>
<label>Smoker</label>
<label class="auto"><10</label>
<input type="checkbox" name="smokerLess10" class="radioAuto2"/>
<label class="auto">>10</label>
<input type="checkbox" name="smokerMore10" class="radioAuto2"/>
<label>Alcohol</label>
<select name="alcohol">
<option value="">Select</option>
<option value="Non-drinker">Non-drinker</option>
<option value="Occasional">Occasional</option>
<option value="Moderate">Moderate</option>
<option value="Heavy">Heavy</option>
</select>
<div class="clear"></div>
<label>Allergy</label>

<input name="allergies" type="text" tabindex="1" class="auto"  maxlength="60" id="allergies" size="92"  />


</div>
<%-- <a href="javascript:openPopupForImmunization()">Immunization</a>--%>

<!--<input type="button" class="button" value="Immunization" onclick="openPopupForImmunization();">
--><!--<select name="immunization">
<option value="">Select</option>

</select>
-->
<div class="clear"></div>
<div class="Block">
<input type="hidden" name="<%=DEPARTMENT_ID %>" id="deptId" value="0"/>
<%--
<label> Priority</label>
<select name="priority" id="priority" class="small">
<option value="1">1</option>
<option value="2">2</option>
<option value="3" selected="selected">3</option>
</select>
 --%>
<div id="testDiv" style="display: none">
<input type="text"	name="<%=TOKEN_NO %>" value="" validate="Token no.,int,no"	maxlength="3" readonly="readonly"/>
</div>

<input type="hidden" name="<%=VISIT_NUMBER%>" value="" id="visitNo"/>
<!--<input type="button" class="button"  value="Med Exam">
--><label>Med Exam</label>
<input type="checkbox" name="reportingFor"  class="radioAuto" value="MedExam" onclick="displayMedExam(this);"/>
<div id="med">
<!--<input type="button" class="button" value="Med Board">
--><label>Med Board</label>
<input type="checkbox" name="reportingFor" class="radioAuto" value="MedBoard" onclick="displayMedBoard(this);"/>
</div>

<div id="medExamCategoryDiv" style="display: none;">
<label>Exam Category <span>*</span></label> 
<select id="medExamCategory" name="medExamCategory"	tabindex="1" class="large">
	<option value="">Select</option>
	<option value="Annual Medical Exam(AFMSF-3B)">Annual Medical Exam(AFMSF-3B)</option>
	<option value="Med. Exam On Release/Discharge(AFMSF-18)">Med. Exam On Release/Discharge(AFMSF-18)</option>
	<option value="Primary/Extension Med. Exam(AFMSF-2A)">Primary/Extension	Med. Exam(AFMSF-2A)</option>
	<option value="Prior To Proceedings Abroad Med. Exam(AFMSF-3B)">Prior To Proceedings Abroad Med. Exam(AFMSF-3B)</option>
	<option value="High Altitude Med. Exam(AFMSF-3B)">High Altitude Med. Exam(AFMSF-3B)</option>
</select>
</div>
<div class="clear"></div>
<div id="medBoardCategoryDiv" style="display: none;">
<label>Board Category <span>*</span></label> 
<select id="medBoardCategory" name="medBoardCategory"	tabindex="1" class="large">
	<option value="">Select</option>
	<option value="Initial Medical Board AFMSF 15">Initial Medical Board AFMSF 15</option>
	<option value="Medical Board Review AFMSF 15">Medical Board	Review AFMSF 15</option>
	<option value="Medical Board AFMSF 16">Medical Board AFMSF 16</option>
</select>
</div>

<input type="button" class="button" value="Immunization" onclick="openPopupForImmunization();" tabindex="1">
<div class="clear"></div>
<!--<input type="button" class="button" value="Allergies" onclick="openPopupForAllergies();" tabindex="1">
-->
</div>

<div class="clear"></div>

<table id="allergyGrid" style="display: none;"></table>
<input type="hidden" name="allergyCount" value="0" id="allergyCount"/>
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>
 <input id="Hidden1" type="hidden" runat="server" /> 
 <input	id="Hidden2" type="hidden" runat="server" /> 
 <input id="Hidden3" name="hicSrNo" type="hidden" runat="server" /> 
 <input id="Hidden4" name="flag" type="hidden" runat="server" /> 
 <input type="button" name="Submit11" value="Send" tabindex="1" class="button"	onClick="if(checkNameSpaces() && displayWarning()){submitForm('registration','/hms/hms/registration?method=submitPatientInformation&flag=registration&AdPro=NO','checkTargetForNo');}" />
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onClick="{clearHin();}" accesskey="r" />
<input type="button" name="preVisit" value="Previous Visit" class="button" onclick="if(checkHinId()){submitFormForButton('registration','/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&flag=registration&hinId='+document.getElementById('regHinId').value,'checkTargetForNo');}"/>
<input type="button" name="appointment" value="Appointment" class="button" onclick="submitFormForButton('registration','/hms/hms/adt?method=showPatientAppointmentJsp','checkTargetForNo')"/>
<input type="button" name="trackPt" value="Patient Track" class="button" onclick="submitFormForButton('registration','/hms/hms/adt?method=showPatientTrackJsp','checkTargetForNo')"/>
<input type="button" name="import hic" value="Import HIC"	class="button" tabindex="1" onclick="javascript:ReadFingerPrint() ;"/>
 <input	type="button" name="Checkout" value="update hic" class="button"	tabindex="1" onclick="checkoutToHic();" />
<input type="button" class="button" name="search" value="Search" onclick="submitFormForButton('registration','/hms/hms/adt?method=showAdmissionJsp','checkTargetForNo')">
<input type="button" name="regCard" value="Print Reg Card" class="button" onclick="if(checkHinId()){submitFormForButton('registration','/hms/hms/registration?method=printRegistrationCard&hinNo='+document.getElementById('printHinNo').value+'&priscriptionSlip=o','checkTargetForYes');}"/>

<div id="saveAdmission" style="display: none;">
<input	type="button" name="Submit" value="Save & Admission" tabindex="1"	class="buttonbig"
	onClick="if(displayWarning()){submitForm('registration','/hms/hms/registration?method=submitPatientInformation&AdPro=YES');}" />
<input type="reset" name="Reset" value="Reset" class="button" 	tabindex="1" onClick="{clearHin();}" accesskey="r" />
</div>

<script>
function checkHinId(){
	if(document.getElementById('regHinId').value==0){
		alert("Please select HIN.");
		return false;
	}
	return true;
}
function displayWarning(){
	 for(var i = 0; i < document.getElementsByName('reportingFor').length; i++){
		if(document.getElementsByName('reportingFor')[i].checked == true)
        {
			return true;
	    }		
	 }
	alert("Please select reporting option.")
	return false;
	
}


</script>
<div class="clear"></div>
<div class="division"></div>


<div id="statusMessage" class="messagelabel">
</div>
<table id="immuGrid" style="display: none;"></table>
<input type="hidden" name="immCount" value="0" id="immCount"/> 
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
		document.getElementById('newUnitId').setAttribute('validate','Station Name,string,yes');
	}else{
		document.getElementById('addUnitDiv').style.display='none';
		document.getElementById('newUnitId').setAttribute('validate','Station Name,string,no');
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
	if(trd=='other'){
		document.getElementById('addTradeDiv').style.display='inline';
		document.getElementById('newTradeId').setAttribute('validate','Trade Name,string,yes');
	}else{
		document.getElementById('addTradeDiv').style.display='none';
		document.getElementById('newTradeId').setAttribute('validate','Trade Name,string,no');
	}
}


function openJspForCheckout(){

	 window2 = window.open('/hms/hms/registration?method=showMedExamForHICUpdate','windowRef','width=1000,height=400,scrollbars = yes');
}

function setMaritalStatus(){
	var rel = document.getElementById('relationId').value;
	if(rel == '10' || rel == '11'){
		document.getElementById('mrstatus').value = '2'; 
	}else{
		document.getElementById('mrstatus').value = '0'; 
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
	for(MasRank rank : rankList){
		if(rank.getHicCode()!= null && rank.getHicCode().equalsIgnoreCase(rsEmp.getString(4))){
			rankId = rank.getId();
		}
	}
	%>
	document.getElementById('rankId').value = '<%=rankId%>'
		<%
		int unitId =0;
		for(Object[] unit : unitList){
			if((String)unit[3] != null && rsEmp.getString(5) != null && ((String)unit[3]).equalsIgnoreCase(rsEmp.getString(5))){
				unitId = (Integer)unit[0];
			}
		}
		%>
	document.getElementById('unitId').value = '<%=unitId%>'
	document.getElementById('serviceNoId').value = '<%=rsEmp.getString(6)%>'
	<%
		int sexId = 0;
		for(MasAdministrativeSex sex: sexList){
		if(sex.getHicCode() != null && rsEmp.getString(7) != null && sex.getHicCode().trim().equalsIgnoreCase(rsEmp.getString(7).trim())){
			sexId = sex.getId();
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
		for(MasBloodGroup bld : bloodGroupList){
			if(bld.getHicCode() != null && bld.getHicCode().equalsIgnoreCase(rsEmp.getString(9))){
				bldgrpId = bld.getId();
			}
		}
	%>
	document.getElementById('serBldGroupId').value = '<%=bldgrpId%>'
	<%}%>
	<%
	if(rsEmp.getDate(10)!= null){
	%>
	document.getElementById('commissionDateId').value = '<%=HMSUtil.convertDateToStringWithoutTime(rsEmp.getDate(10))%>'

<%}%>

		<%
		int trdId = 0;
		for(MasTrade trd : tradeList){
		if(trd.getTradeName() != null && trd.getTradeName().equalsIgnoreCase(rsEmp.getString(12))){
			trdId = trd.getId();
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
	for(MasReligion religion : religionList){
		if(religion.getHicCode()!=null){
			String smcCode = religion.getHicCode().substring(0,1);
			if(smcCode.equalsIgnoreCase(hicCode)){
			religionId = religion.getId();
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
for(MasMaritalStatus maritalStatus : maritalStatusList){
	System.out.println(rsEmp.getString(16));
	System.out.println(maritalStatus.getHicCode());
if(maritalStatus.getHicCode() != null && rsEmp.getString(16)!= null  && maritalStatus.getHicCode().equalsIgnoreCase(rsEmp.getString(16))){
	mrId = maritalStatus.getId();
	
}
}
%>
document.getElementById('srmrstatus').value = '<%=mrId%>'
	document.getElementById('mrstatus').value = '<%=mrId%>'


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
		errorMsg =errorMsg+"Service person first name can not be blank or spaces ...! \n"
	}
	}
	if(document.getElementById('pFirstNameId').value =="" || trimAll(document.getElementById('pFirstNameId').value) ==""){
		errorMsg =errorMsg+"First name can not be blank or spaces ..!\n"
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
	
	<%
		for(MasEmployee emp : doctorList){
	%>			
		dcId = '<%=emp.getId()%>';
		if(doctorId == dcId){
			<%
				if(emp.getDepartment()!= null){
			%>
			deptId = '<%=emp.getDepartment().getId()%>';
			<%}%>
		}	
	<%}%>
	
	document.getElementById('deptId').value=deptId;
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

function callFunctions(val){
	getServicePersonName('registration','registration?method=getServicePersonName&type=registration');
	setTimeout("checkServiceType("+val+")", 700);
	

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
getServicePersonName('registration','registration?method=getServicePersonName&type=registration&serviceNo=<%=serviceNo%>&serviceTypeId=<%=serviceTypeId%>&hinId=<%=hinId%>');
setTimeout('displayPatientInfo(<%=hinId%>)',5000)
}else{getHin();}



function openPopupForImmunization(){
	 newwindow = window.open('/hms/hms/registration?method=openPopupForImmunization&hinId='+document.getElementById('regHinId').value,'windowRef','width=1000,height=400,scrollbars = yes');
}

function openPopupForAllergies(){
	 newwindow = window.open('/hms/hms/registration?method=openPopupForAllergies&hinId='+document.getElementById('regHinId').value,'allergy','width=1000,height=400,scrollbars = yes');
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

function populateStateForCity(city){
	var state = 0;
	for(i=0;i<districtArray.length;i++){
		if(districtArray[i][1] == city){
			state = districtArray[i][0];
			break;		
			}
		}
	document.getElementById('state').value = state;
	
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
function openOtherField(familyHistoryId){
	if(familyHistoryId == '8'){
		document.getElementById('otherFamilyHistoryDiv').style.display = 'block';
	}else{
	//	document.getElementById('familyHistoryId').style.display = 'none';
	}
	
}
</script>