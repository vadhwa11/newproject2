<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration.jsp  
 * Purpose of the JSP -  This is for Registration.
 * @author  Ritu
 * Create Date: 13th Feb,2008 
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
<%@ page
	import="static jkt.hms.util.RequestConstants.TOTAL_SERVICE_PERIOD"%>
<%@ page import="static jkt.hms.util.RequestConstants.UNIT_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.UNIT_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.STATION"%>
<%@ page import="static jkt.hms.util.RequestConstants.COMMAND"%>
<%@ page
	import="static jkt.hms.util.RequestConstants.RECORD_OFFICE_ADDRESS_ID"%>
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
<%@ page
	import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_RELATION_ID"%>
<%@ page
	import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_ADDRESS"%>
<%@ page
	import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_PHONE_NO"%>
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
<%@ page
	import="static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_NAME"%>
<%@ page
	import="static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_RELATION_ID"%>
<%@ page
	import="static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_ADDRESS"%>
<%@ page
	import="static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_PHONE_NO"%>

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
<%@page import="java.io.InputStream"%>




<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>

<%@page import="jkt.hms.masters.business.Category"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/controls.js?n=1"></script>
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
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js?n=1"></script>
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
			
			String patientTypeNameForOther="";
			Properties propadt = new Properties();
			URL resourcePathadt = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");

			try {
				propadt.load(resourcePathadt.openStream());			 
				patientTypeNameForOther=propadt.getProperty("patientTypeNameForOther");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
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
			String departmentNameToRestrictMalePatient = properties.getProperty("departmentNameToRestrictMalePatient");
			
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

	<!-- code start for waiting list -->

	<%
	String pageTitle = "";
    String message = "";
	

	
	if(map.get("message") != null){
		message = (String)map.get("message");
	}	
	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId =  (Integer)session.getAttribute("hospitalId");
	}
	int empId = 0;
	if(session.getAttribute("empId") != null){
		empId = (Integer)session.getAttribute("empId");
	}
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();	
	
	
	if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map.get("departmentList");
 		
 	}
	//out.print("hospitalId="+hospitalId);
	
	
	
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId =  (Integer)session.getAttribute("deptId");
	}
%>

	<!-- code end for waiting list -->
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
		<h2>Visit of other patient</h2>
	</div>
	<div class="clear"></div>
	<ul id="countrytabsIn" class="shadetabsIn">
		<label><a href="#" rel="waitingList" class="selected"><span>Waiting
					List</span></a></label>
		<label><a href="#" id="tab" rel="patientDetails"><span>
					Patient Details </span></a></label>

		<div id="srPhoto" class="photo">
			<div class="clear"></div>
			<img src="/hms/jsp/images/na.jpg" name="img1" width="105" height="80"
				id="img1" /> <span style="color: #ddd">Date/ Time</span>
		</div>
	</ul>
	<div id="waitingList" class="tabcontentIn">




		<h4><%=message %></h4>
		<h2>Other Patients Waiting List</h2>
		<!-- <div class="page_title">Medical Exam waiting List</div> -->

		<!-- <div class="Block">

		<label>HIN.</label> <input name="ServiceNo" id="ServiceNo" type="text">
		<input type="button" name="reset" id="resetbutton" value="Search"
			class="button" onClick="GetPatientList('FILTER');" accesskey="r"
			tabindex=1 /> <input type="button" name="reset" id="resetbutton"
			value="Show all" class="button" onClick="ShowAllList('1');"
			accesskey="r" tabindex=1 />
	</div> -->
		<div class="Block" style="padding-top: 20px;">
			<div id="divSearchResult">

				<table class="tblSearchActions" cellspacing="0" cellpadding="0"
					border="0">
					<tr>
						<td class="SearchStatus" style="font-size: 13px;" align="left">Search
							Results</td>
						<td>
							<div id=resultnavigation></div>

						</td>
						<td style="width: 80px;"><input id="pageno" type="text"
							maxlength="4" name="pageno" style="width: 25px;"> <input
							class="button" type="button"
							onclick="goToPageForPatient(pageno.value)" value="Go" name="ok"
							style="width: 35px;"></td>
					</tr>
				</table>

				<table id="tblSearchResultsHeader" class="tblSearchResultsHeader"
					cellspacing="0" cellpadding="0" border="0">
					<tr>

						<!-- <th id="th1" style='width: 10px;'>Select</th> -->
						<th id="th1" style='width: 100px;'>Registration Date</th>
						<th id="th2" style='width: 100px;'>Reg. No</th>
						<th id="th3" style='width: 120px;'>Name</th>
						<th id="th4" style='width: 120px;'>Age</th>
						<th id="th5" style='width: 150px;'>Gender</th>
						<th id="th6" style='width: 100px;'>Contact No</th>
						<th id="th6" style='width: 100px;'>NOK1</th>
						<th id="th6" style='width: 100px;'>NOK2</th>


					</tr>
					<tbody id="tblListOfPatient">

					</tbody>
				</table>
				<div class="clear"></div>
				<div class="clear"></div>


				<!-- 	<input type="button" name="nonBillable"
				id="nonBillable" value="Non Billable" class="button"
				onClick="if(validateRadio()){submitForm('searchPendingForApproval','/hms/hms/registration?method=submitPendingForApproval&flag=n')};"
				accesskey="r" tabindex=1 /> -->
				<input type="hidden" value="<%=empId%>" name="approvedBy" />
			</div>
			<div id="pageNavPosition"></div>

		</div>






	</div>
	<div id="patientDetails" class="tabcontentIn">


		<h4>Personal Details</h4>
		<div class="clear"></div>

		<input type="hidden" name="<%=REG_DATE %>" value="<%=currentDate %>"
			validate="Registration Date,frdate,no" readonly="readonly"
			class="calDate" /> <input type="hidden" name="<%=REG_TIME %>"
			value="<%=time %>" validate="Registration Time,string,no"
			maxlength="20" readonly="readonly" class="calDate" />
		<div id="sNameDiv">
			<div class="Block">
				<!--<label>HIN</label>
-->
				<label id="defaulthinno" class="value" style="display: none;">&nbsp;</label>
				<label id="hinNoDivId" class="value" style="display: none;"></label>
				<input id="hinNoId" type="hidden" name="<%=HIN_NO %>" value=""
					validate="HIN,metachar,no" />
				<div class="clear"></div>
				<div id="srNoDiv" style="display: block;">
					<label>Reg. No<span>*</span></label>
					<%-- <input 	id="prefix" name="<%=PREFIX%>" type="text" maxlength="3" class="auto" size="1"	tabindex="1" validate="Prefix,metachar,no" />  --%>
					<input id="serviceNoId" class="auto" size="8" type="text"
						name="<%=SERVICE_NO %>" value="" title="Enter Service No"
						tabindex="1" validate="Reg. No ,metachar,yes" maxlength="20"
						readOnly="true" onKeyPress="return isNumber(event)" onblur="" />

					<!--created because we need serviceType in old code hence we don't need to change old however i have commented some HTML and javascript code in this jsp for serviceType-->
					<input type="hidden" value="" id="serviceTypeId"
						name="serviceTypeId" /> <input type="hidden" value=""
						id="regHinId" name="regHinId" /> <input type="hidden"
						value="<%=patientTypeNameForOther%>" id="patientTypeName"
						name="patientTypeName" />

				</div>




				<div class="clear"></div>
				<label>First Name <span>*</span></label> <input id="sFNameId"
					type="text" name="<%=S_FIRST_NAME %>" value="" tabindex="1"
					title="First Name"
					validate="First Name,string,yes" MAXLENGTH="150"
					onblur=";" /> <label>Middle Name</label> <input
					id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value=""
					tabindex="1" validate="Middle Name,string,no"
					MAXLENGTH="30" onchange=";" /> <label>Last
					Name</label> <input id="sLNameId" type="text" name="<%=S_LAST_NAME %>"
					value="" tabindex="1"
					validate="Last Name,string,no" MAXLENGTH="30"
					onchange=";" />


				<div class="clear"></div>




				<label> Gender <span>*</span></label> <select name="<%=SR_SEX %>"
					id="srSexId" validate="Service Person Gender,metachar,yes"
					tabindex="1" onchange=";">
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
				</select> <label>DOB<span>*</span></label> <input type="text" id="srdobId"
					name="<%=SR_DOB %>" tabindex="1" value=""
					validate="Date of Birth,date,yes" MAXLENGTH="30" class="calDate"
					onkeyup="mask(this.value,this,'2,5','/');"
					onblur="if(validateExpDateHAL(this,'srdobId')){if(setAge(this.value, 'srAgeId')){setAge(this.value, 'ageId');;}}" />
				<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
					height="16" border="0" validate="Pick a date" class="calender"
					onClick="setdate('',document.registration.<%=SR_DOB%>,event)" /> <label>Age		
				</label>
				<div id="srAgeDiv" style="display: block;">
					<select id="srAgeId" name="<%=SR_AGE%>"
						validate="Age of Patient,metachar,no" tabindex="1" class="small"
						onchange=";">
						<option value="">Select</option>
						<%
				for(int age1 = 1;age1<=100;age1++){
				%>
						<option value="<%=age1%>"><%= age1%></option>
						<%}%>
					</select> <input type="text" class="readOnlySmall" id="srAgeUnitId"
						name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly" />
				</div>
				<input type="hidden" id="idForSrAge" value=""
					validate="Age,metachar,no" />

				<div class="clear"></div>
				<label>Marital Status</label> <select name="srMaritalStatus"
					id="srmrstatus"
					validate="Marital Status of service Person,metachar,no"
					tabindex="1">
					<option value="0">Select</option>
					<%
	 for(Object[] masMaritalStatus : maritalStatusList){
	%>
					<option value="<%=masMaritalStatus[0]%>"><%=masMaritalStatus[1]%></option>
					<%}%>
				</select> <label>Marriage Date</label> <input type="text"
					id="srMarriageDateId" name="srMarriageDate" tabindex="1" value=""
					onkeyup="mask(this.value,this,'2,5','/');"
					onblur="validateExpDate(this,'srMarriageDateId'); "
					validate="Marriage Date,date,no" MAXLENGTH="30" class="calDate" />
				<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
					height="16" border="0" validate="Pick a date" class="calender"
					onClick="setdate('<%=currentDate %>',document.registration.srMarriageDate,event)" />


				<label> Religion</label> <select id="religionId"
					name="<%=RELIGION_ID %>" validate="Religion,metachar,no"
					tabindex="1">
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
					<!-- <label>AFNET No.</label> 
<input id="afnetNo" name="afnetNo" type="text" tabindex="1"	maxlength="15"  validate="AFNET No.,metachar,no" /> -->
				</div>


				<label>Telephone No.(Off.)</label> <input id="phoneNo"
					name="<%=TELEPHONE_NO %>" type="text" tabindex="1" maxlength="11"
					onblur=""
					validate="Telephone No.(Off.),metachar,no" /> <label>Mobile
					No.</label> <input id="mobileNo" name="<%=MOBILE_NO %>" type="text"
					tabindex="1" maxlength="11" onblur=""
					validate="Mobile No.,metachar,no" /> <label>Telephone
					No.(Res.)</label> <input id="phoneNoRes" name="phoneNoRes" type="text"
					tabindex="1" maxlength="11"
					validate="Telephone No.(Res.),metachar,no" />
				<div class="clear"></div>
				<label>Other Contact No.</label>
				<textarea cols="20" rows="2" tabindex="1" maxlength="60"
					validate="Other Contact No.,metachar,no" name="otherContactNo"
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
				<div class="clear"></div>
				<label>Local Address</label>
				<textarea name="<%=ADDRESS %>" id="sraddr" cols="20" rows="2"
					tabindex="1" validate="Address,metachar,no" maxlength="200"
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
					onblur=""></textarea>

				<label>State</label> <select id="srstateId" name="<%=STATE%>"
					validate="State,metachar,no" tabindex="1"
					onChange="populateDistrict(this.value,'registration','srcityId')">
					<option value="0">Select</option>
					<%

		for(Object[] masState : stateList){
	
	%>

					<option value="<%=masState[0] %>"><%=masState[1] %></option>
					<%		
		}%>
				</select> <label>City</label> <select name="<%=DISTRICT%>"
					validate="City,string,no" id="srcityId" tabindex="1"
					onblur="">
					<option value="0">Select</option>
					<%
		for(Object[] masDistrict : districtList){
	%>
					<option value="<%=masDistrict[0]%>"><%=masDistrict[1] %></option>
					<%		
		}%>
				</select>


				<div class="clear"></div>

				<label>Permanent Address</label>
				<textarea name="<%=PERMANENT_ADDRESS %>" id="peraddr" cols="20"
					rows="2" tabindex="1" validate="Address,metachar,no"
					maxlength="250" onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

				<label>State</label> <select id="permStateId" name="permStateId"
					validate="State,string,no" tabindex="1"
					onChange="populateDistrict(this.value,'registration','perCityId')">
					<option value="0">Select</option>
					<%

		for(Object[] masState : stateList){
	
	%>

					<option value="<%=masState[0] %>"><%=masState[1] %></option>
					<%		
		}%>
				</select> <label>City</label> <select name="permCityId"
					validate="City,string,no" id="perCityId" tabindex="1"
					onchange=";">
					<option value="0">Select</option>
					<%
		for(Object[] masDistrict : districtList){
	%>
					<option value="<%=masDistrict[0]%>"><%=masDistrict[1]%></option>
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
				<label>Telephone No.</label> <input id="telephoneNoPerm"
					name="telephoneNoPerm" type="text" tabindex="1" maxlength="11"
					validate="Telephone No.,metachar,no" /> <label>Police
					Station</label> <input id="policeStation" name="policeStation" type="text"
					tabindex="1" maxlength="15" validate="Police Station,metachar,no" />
				<label>Pin Code</label> <input id="pinCode" name="pinCode"
					type="text" tabindex="1" maxlength="8"
					validate="Pin Code,metachar,no" />
				<div class="clear"></div>
				<label>Identification Mark 1</label>
				<textarea cols="20" rows="2" tabindex="1" maxlength="50"
					validate="Identification Mark 1,metachar,no"
					name="identificationMark1" id="identificationMark1"
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

				<label>Identification Mark 2</label>
				<textarea cols="20" rows="2" tabindex="1" maxlength="50"
					validate="Identification Mark 2,metachar,no"
					name="identificationMark2" id="identificationMark2"
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

				<div class="clear"></div>

			</div>
			<!-- End Block 2-->
			<div class="clear"></div>
			<h4>NOK Details</h4>
			<div class="clear"></div>
			<div class="Block">
				<h4>NOK 1</h4>
				<div class="clear"></div>
				<label> Name</label> <input type="text"
					name="<%=SR_NEXT_OF_KIN_NAME%>" value=""
					validate="NOK1 Name,fullName,no" id="srnokNameId" maxlength="30" />

				<label> Relation</label> <select
					name="<%=SR_NEXT_OF_KIN_RELATION_ID %>"
					validate="NOK1 Relation,String,no" id="srrelId">
					<option value="0">Select</option>

					<% 
	for (Object[]  obj : relationList){
	%>
					<option value="<%=obj[0]%>"><%=obj[1]%></option>
					<% 				
	}%>
				</select> <label> Contact No.</label> <input type="text"
					name="<%=SR_NEXT_OF_KIN_PHONE_NO%>" value="" id="srnok1Phone"
					validate="NOK1 Phone No,phone,no" maxlength="11" />
				<div class="clear"></div>
				<label> Address</label>
				<textarea name="<%=SR_NEXT_OF_KIN_ADDRESS %>" id="srnextOfKinAdd"
					cols="20" rows="2" tabindex="1" validate="Nok1 Address,metachar,no"
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
				<label>Police Station</label> <input id="srnok1PoliceStation"
					name="srnok1PoliceStation" type="text" tabindex="1" maxlength="15" />
				<label>Pin Code</label> <input id="srnok1PinCode"
					name="srnok1PinCode" type="text" tabindex="1" maxlength="8" />
				<div class="clear"></div>

				<h4>NOK 2</h4>
				<div class="clear"></div>
				<label> Name</label> <input type="text" name="srnok2Name" value=""
					validate="NOK2 Name,fullName,no" id="srnok2NameId" maxlength="30" />

				<label> Relation</label> <select name="srnok2RelationId"
					validate="NOK2 Relation,String,no" id="srnok2RelId">
					<option value="0">Select</option>

					<% 
	for (Object[]  obj : relationList){
	%>
					<option value="<%=obj[0]%>"><%=obj[1]%></option>
					<% 				
	}%>
				</select> <label> Contact No.</label> <input type="text"
					name="srnok2ContactNo" value="" id="srnok2Contact"
					validate="NOK2 Contact No,phone,no" maxlength="16" />
				<div class="clear"></div>
				<label> Address</label>
				<textarea name="srnok2Address" id="srnok2Add" cols="20" rows="2"
					tabindex="1" validate="Nok2 Address,metachar,no"
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
				<label>Police Station</label> <input id="srnok2PoliceStation"
					name="srnok2PoliceStation" type="text" tabindex="1" maxlength="15"
					validate="Police Station,metachar,no" /> <label>Pin Code</label> <input
					id="srnok2PinCode" name="srnok2PinCode" type="text" tabindex="1"
					maxlength="8" validate="Pin Code,metachar,no" />
				<div class="clear"></div>
			</div>
			<!-- End Block 3-->




		</div>
		<!-- End sNameDiv-->

		<!--token Block Starts-->


		<div class="Block">
			<label>Department <span>*</span></label>

			<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" validate="Department,number,no"> --%>
			<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" onchange="getDetails(this.value);" validate="Department,number,no" > --%>
			<select id="deptId" name="<%=DEPARTMENT_ID%>"
				onchange="submitProtoAjaxWithDivName('registration','/hms/hms/appointment?method=getDoctorDetails','doctorNSessionList');">
				<option value="0">Select</option>
				<%
				
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
					
			
			%>
				<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
				<%	
					
				}
			}
			%>
			</select>


			<div id="doctorNSessionList">
				<label>Doctor List<span>*</span>
				</label> <select id="doctorId" name="consultingDoctor">
					<option value="0"></option>
				</select> <label>Session<span>*</span>
				</label> <select id="sesId" name="sessionList">
					<option value="0"></option>
				</select>

			</div>


			<!-- <input name="Print" type="button" value="Generate Report" target="_blank" class="cmnButton" onClick="showReport('appSetup');"> -->
			<input name="Print" type="button" value="Show Token" target="_blank"
				style="width: 147px;" class="button" onClick="validateTokenDiv()">
			<!-- <input name="Print" type="button" value="Show Setup" target="_blank" class="cmnButton"   onclick="if(validateDatefield()){ getDetails();}" /> -->

			<div id="displayToken"></div>
			<label  class="medium"> Priority</label>
            <select name="priority" id="priority" class="smallest" tabindex="1">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3" selected="selected">3</option>
            </select>



		</div>
		<!-- token block ends -->
		<div class="clear"></div>


		<input id="Hidden1" type="hidden" runat="server"
			validate=',metachar,no' /> <input id="Hidden2" type="hidden"
			runat="server" validate=',metachar,no' /> <input id="Hidden3"
			name="hicSrNo" type="hidden" runat="server" validate=',metachar,no' />
		<input id="Hidden4" name="flag" type="hidden" runat="server"
			validate=',metachar,no' /> <input type="button" name="Submit11"
			value="Submit" tabindex="1" class="button"
			onClick="if(fillSelfDetails()){if(checkPatientStatus() && checkNameSpaces() ){submitRegistration()}}" />
		<input type="reset" name="Reset" value="Reset" class="button"
			tabindex="1"
			onClick="submitFormForButton('registration','/hms/hms/registration?method=showOtherVisitJsp');"
			accesskey="r" />


		<div class="clear"></div>
		<div id="country2" class="tabcontentIn" style="display: none">

			<div class="clear paddingTop15"></div>
			<div class="Block">

				<label>Relation </label> <select id="relationId"
					name="<%=RELATION_ID %>" validate="Relation,string,no" tabindex="1"
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

				</select> <label> Title</label> <select id="titleId" name="<%=TITLE%>"
					validate="Title,string,no" tabindex="1">
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
				<label> First Name <span>*</span></label> <input type="text"
					id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"
					title="First Name"
					validate="First Name,string,yes" MAXLENGTH="150" /> <label>Middle
					Name</label> <input type="text" id="pMiddleNameId"
					name="<%=P_MIDDLE_NAME%>" value="" tabindex="1"
					validate="Middle Name,string,no" MAXLENGTH="30" /> <label>Last
					Name</label> <input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"
					value="" validate="Last Name,string,no" MAXLENGTH="30"
					tabindex="1" />

				<div class="clear"></div>

				<label> Gender<span>*</span></label> <select name="<%=GENDER %>"
					id="gender" validate="Gender,string,yes" tabindex="1">
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
				</select> <label>DOB<span>*</span></label> <input type="text" id="dobId"
					name="<%=DATE_OF_BIRTH %>" tabindex="1" value=""
					onkeyup="mask(this.value,this,'2,5','/');"
					onblur="if(this.value!=''){if(validateExpDateHAL(this,'dobId')){setAge(this.value, 'ageId');}}"
					validate="Date of Birth,date,no" MAXLENGTH="10" class="calDate" />
				<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
					height="16" border="0" validate="Pick a date" class="calender"
					onClick="setdate('<%=currentDate %>',document.registration.<%=DATE_OF_BIRTH%>,event)" />


				<label> Age</label>
				<div id="ageDiv" style="display: block;">
					<select id="ageId" name="<%=AGE%>"
						validate="Age of Patient,metachar,no" tabindex="1"
						class="smallest">
						<option value="">Select</option>
						<%
				for(int age1 = 0;age1<=100;age1++){
				%>
						<option value="<%=age1%>"><%= age1%></option>
						<%}%>
					</select> <select id="ageUnitId" name="<%=AGE_UNIT %>"
						validate="AgeUnit,string,no" tabindex="1" class="small">
						<option selected="selected" value="Years">Years</option>
						<option value="Months">Months</option>
						<option value="Days">Days</option>
					</select> <input type="hidden" id="idForAge" value=""
						validate="Age,metachar,no" />
				</div>

				<div class="clear"></div>


				<label> Marital Status</label> <select
					name="<%=MARITAL_STATUS_ID %>" id="mrstatus"
					validate="Marital Status,string,no" tabindex="1">
					<option value="0">Select</option>
					<%
	 for(Object[]  masMaritalStatus : maritalStatusList){
	
	%>
					<option value="<%=masMaritalStatus[0]%>"><%=masMaritalStatus[1]%></option>
					<%}%>
				</select> <label>Marriage Date</label> <input type="text"
					id="depMarriageDateId" name="depMarriageDate" tabindex="1" value=""
					onkeyup="mask(this.value,this,'2,5','/');"
					onblur="validateExpDate(this,'depMarriageDateId'); "
					validate="Marriage Date,frdate,no" MAXLENGTH="10" class="calDate" />
				<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
					height="16" border="0" validate="Pick a date" class="calender"
					onClick="setdate('<%=currentDate %>',document.registration.depMarriageDate,event)" />


				<label> Occupation</label> <select id="occupation"
					name="<%=OCCUPATION_ID %>" validate="Occupation,string,no"
					tabindex="1">
					<option value="0">Select</option>
					<%
	 for(Object[] masOccupation : occupationList){
	
	%>
					<option value="<%=masOccupation[0]%>"><%=masOccupation[1]%></option>
					<%}%>
				</select>
				<div class="clear"></div>

				<label>Income(Per Month)</label> <input type="text" name="income"
					id="income" value="" tabindex="1" maxlength="10"
					validate="Income(Per Month),int,no" /> <label>Dependency
					Date</label> <input type="text" id="depDate" name="dependencyDate" value=""
					class="date" maxlength="10"
					onkeyup="mask(this.value,this,'2,5','/');"
					validate="Dependency Date,frdate,no"
					onblur="validateExpDate(this,'depDate'); checkDependencyDate(this.value);" />
				<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
					height="16" tabindex="1" border="0" validate="Pick a date"
					class="calender"
					onClick="setdate('<%=currentDate %>',document.registration.dependencyDate,event)" />

				<label>Authority</label> <input type="text" name="authority"
					id="authority" value="" maxlength="50" tabindex="1"
					validate="Authority,metachar,no" />
				<div class="clear"></div>

				<label>Dependency Removal</label> <input type="text"
					id="depRemovalDate" name="dependencyRemovalDate" value=""
					readonly="readonly" class="date" /> <img id="calendar"
					src="/hms/jsp/images/cal.gif" width="16" height="16" tabindex="1"
					border="0" validate="Pick a date" class="calender"
					onClick="setdate('<%=currentDate %>',document.registration.dependencyRemovalDate,event)" />



				<label>Local Address</label>
				<textarea name="<%=ADDRESS %>" id="addr" cols="20" rows="2"
					tabindex="1" validate="Address,metachar,no"
					onpaste="return checkOnPaste(this)" maxlength="200"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
					onblur=""></textarea>

				<label>City</label> <select name="<%=DISTRICT%>"
					validate="City,string,no" id="cityId" tabindex="1"
					onblur="populateStateForCity(this.value,'stateId');">
					<option value="0">Select</option>
					<%
		for(Object[] masDistrict : districtList){
	%>
					<option value="<%=masDistrict[0]%>"><%=masDistrict[1] %></option>
					<%		
		}%>
				</select>

				<div class="clear"></div>
				<label>State</label> <select id="stateId" name="<%=STATE%>"
					validate="State,string,no" tabindex="1"
					onChange="populateDistrict(this.value,'registration','cityId'),"
					onblur="">
					<option value="0">Select</option>
					<%

		for(Object[] masState : stateList){
	
	%>

					<option value="<%=masState[0] %>"><%=masState[1] %></option>
					<%		
		}%>
				</select> <label>Contact No.</label> <input type="text"
					name="<%=CONTACT_NUMBER %>" id="contactNo" value=""
					validate="Contact No.,phone,no" MAXLENGTH="20" tabindex="1"
					onblur="" /> <label>Mobile No.</label> <input
					id="depmobileNo" name="<%=MOBILE_NO %>" type="text" tabindex="1"
					maxlength="11" onblur=""
					validate="Mobile No.,phone,no" />
				<div class="clear"></div>
				<label>Police Station</label> <input id="deppoliceStation"
					name="policeStation" type="text" tabindex="1" maxlength="15"
					onblur=""
					validate="Police Station,metachar,no" /> <label>Pin Code</label> <input
					id="deppinCode" name="pinCode" type="text" tabindex="1"
					maxlength="8" validate="Pin Code,int,no" />


				<div class="clear"></div>
				<label>Identification Mark 1</label>
				<textarea cols="20" rows="2" tabindex="1" maxlength="50"
					name="depIdentificationMark1"
					validate="Identification Mark 1,metachar,no"
					id="depIdentificationMark1" onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

				<label>Identification Mark 2</label>
				<textarea cols="20" rows="2" tabindex="1" maxlength="50"
					name="depIdentificationMark2"
					validate="Identification Mark 2,metachar,no"
					id="depIdentificationMark2" onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
				<div class="clear"></div>
			</div>
			<!-- End Block 4 -->
			<div class="clear"></div>
			<h4>NOK Details</h4>
			<div class="clear"></div>
			<div class="Block">
				<h4>NOK 1</h4>
				<div class="clear"></div>
				<label> Name</label> <input type="text" name="<%=NEXT_OF_KIN_NAME%>"
					value="" validate="NOK1 Name,fullName,no" id="nokNameId"
					maxlength="30" /> <label> Relation</label> <select
					name="<%=NEXT_OF_KIN_RELATION_ID %>"
					validate="NOK1 Relation,String,no" id="relId">
					<option value="0">Select</option>

					<% 
	for (Object[]  obj : relationList){
	%>
					<option value="<%=obj[0]%>"><%=obj[1]%></option>
					<% 				
	}%>
				</select> <label> Contact No.</label> <input type="text"
					name="<%=NEXT_OF_KIN_PHONE_NO%>" value="" id="nok1Phone"
					validate="NOK1 Phone No,phone,no" maxlength="16" />
				<div class="clear"></div>
				<label> Address</label>
				<textarea name="<%=NEXT_OF_KIN_ADDRESS %>" id="nextOfKinAdd"
					cols="20" rows="2" tabindex="1" validate="Nok1 Address,metachar,no"
					maxlength="200" onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
				<label>Police Station</label> <input id="nok1PoliceStation"
					name="nok1PoliceStation" type="text" tabindex="1" maxlength="15"
					validate="Police Station,metachar,no" /> <label>Pin Code</label> <input
					id="nok1PinCode" name="nok1PinCode" type="text" tabindex="1"
					maxlength="8" validate="Pin Code,int,no" />
				<div class="clear"></div>

				<h4>NOK 2</h4>
				<div class="clear"></div>
				<label> Name</label> <input type="text" name="nok2Name" value=""
					validate="NOK2 Name,fullName,no" id="nok2NameId" maxlength="30" />

				<label> Relation</label> <select name="nok2RelationId"
					validate="NOK2 Relation,String,no" id="nok2RelId">
					<option value="0">Select</option>

					<% 
	for (Object[]  obj : relationList){
	%>
					<option value="<%=obj[0]%>"><%=obj[1]%></option>
					<% 				
	}%>
				</select> <label> Contact No.</label> <input type="text" name="nok2ContactNo"
					value="" id="nok2Contact" validate="NOK2 Contact No,phone,no"
					maxlength="16" />
				<div class="clear"></div>
				<label> Address</label>
				<textarea name="nok2Address" id="nok2Add" cols="20" rows="2"
					tabindex="1" validate="Nok2 Address,metachar,no" maxlength="200"
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
				<label>Police Station</label> <input id="nok2PoliceStation"
					name="nok2PoliceStation" type="text" tabindex="1" maxlength="15"
					validate="Police Station,metachar,no" /> <label>Pin Code</label> <input
					id="nok2PinCode" name="nok2PinCode" type="text" tabindex="1"
					maxlength="8" validate="Pin Code,int,no" />
				<div class="clear"></div>
			</div>
			<!-- End Block 3-->

			<div class="clear"></div>
			<h4>Medical Details</h4>
			<div class="clear"></div>
			<div class="Block">

				<label>Blood Group</label> <select name="<%=BLOOD_GROUP_ID %>"
					id="bldGrp" validate="Blood Group,string,no" tabindex="1">
					<option value="0">Select</option>
					<%
	 for(Object[]  masBloodGroup : bloodGroupList){
	%>
					<option value="<%=masBloodGroup[0]%>"><%=masBloodGroup[1]%></option>
					<%}%>
				</select> <label>Family History</label> <select name="familyHistory"
					id="familyHistory" tabindex="1" multiple="multiple" class="list"
					onblur="openOtherField(this.value,this.id);">
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
					<label>Other</label> <input type="text" name="otherFamilyHistory"
						id="otherFamilyHistory" value="" maxlength="50"
						validate="Other,metachar,no" onpaste="return checkOnPaste(this)"
						oninput="return checkMaxLengthMoz(this)"
						onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)">
				</div>
				<label> Allergy</label>
				<textarea name="allergies" id="allergies" value=""
					validate="Allergy,metachar,no" maxlength="100"
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)">
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
			</div>
			<!-- End Block 4-->
		</div>
		<!-- End of country2 -->


	</div>
	<!-- End of patientDetails -->
	<div class="clear"></div>


	<input type="hidden" name="<%=VISIT_NUMBER%>" value="" id="visitNo"
		validate="Visit no.,int,no" />
	<div class="division"></div>
	<div id="edited"></div>



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


	<div class="paddingTop15"></div>
	<input type="hidden" name="<%=SERVICE_STATUS_ID %>"
		id="serviceStatusId" value="0">

	<div id="statusMessage" class="messagelabel"></div>
	<table id="immuGrid" style="display: none;"></table>
	<input type="hidden" name="immCount" value="0" id="immCount" />


	<table id="allergyGrid" style="display: none;"></table>
	<input type="hidden" name="allergyCount" value="0" id="allergyCount" />

	<div class="bottom">
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=currentDate%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label> <input type="hidden"
			name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
			name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
			type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
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
/* getHin() */;
getHinHAL('registration', 8);
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
/* if(document.getElementById("serviceTypeId").value != 7){
	if(document.getElementById('sFNameId').value =="" || trimAll(document.getElementById('sFNameId').value) ==""){
		errorMsg =errorMsg+"Service person first name can not be blank or spaces .! \n"
	}
	} */
	if(document.getElementById('pFirstNameId').value =="" || trimAll(document.getElementById('pFirstNameId').value) ==""){
		errorMsg =errorMsg+"First name can not be blank or spaces ..!\n"
	}
			/* var reporting = ""; 
			 for(var i = 0; i < document.getElementsByName('reportingFor').length; i++){
					if(document.getElementsByName('reportingFor')[i].checked == true)
			        {
						if(document.getElementsByName('reportingFor')[i].value=='OPD' || document.getElementsByName('reportingFor')[i].value=='FollowUp' || document.getElementsByName('reportingFor')[i].value=="FamilyWC" || document.getElementsByName('reportingFor')[i].value=="Dental"){
							reporting = document.getElementsByName('reportingFor')[i].value;
							break;
						}
				    }	
				 } */
		/* if(document.getElementById('consultingDocId').value=='0'){
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
		} */
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
}else{
	/* getHin(); */
	}



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
	{
	
	if(document.getElementById("tokenNoId") !=null)
		{
		if(isNaN(document.getElementById("tokenNoId").value))
			{
			 alert(document.getElementById("tokenNoId").value);
			}
		else
			{
			if(checksex())
				{
				submitForm('registration','/hms/hms/registration?method=submitPatientInformationOtherPatientVisit&flag='+flag,'checkTargetForNo');
				}
			
			}
		
		}
	else{
		alert("Please generate token no first");
	}
	
	}
	
		
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
     
	 var url='/hms/hms/registration?method=checkPopUpForReg&serviceNoId='+document.getElementById('serviceNoId').value+'&serviceStatusId='+document.getElementById('serviceStatusId').value+'&relationId='+document.getElementById('relationId').value; 

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
    		
	 		 var url='/hms/hms/registration?method=getServiceNORelationsPopUp&serviceNoId='+document.getElementById('serviceNoId').value+'&serviceStatusId='+document.getElementById('serviceStatusId').value+'&relationId='+document.getElementById('relationId').value; 
	   		 window.open(url);
	   
	 }
     else
	 {
	    return true;
	 }


}
</script>























<!-- waiting list scritp starts -->

<script language="javascript">
	var nPageNo = 1;

	var $j = jQuery.noConflict();

	$j(document).ready(function() {
		GetPatientList('ALL');

	});

	function GetPatientList(MODE) {

		var hospitalId =
<%out.print(hospitalId);%>
	;

		if (MODE == 'ALL') {
			var data = "PN=" + nPageNo + "&hospitalId=" + hospitalId;
		} else {
			var data = "PN=" + nPageNo + "&hospitalId=" + hospitalId;
		}
		var url = "registration?method=showPendingOtherVisitJsp";
		var bClickable = true;
		GetJsonData('tblListOfPatient', data, url, bClickable);
	}

	function makeTable(jsonData) {
		var htmlTable = "";
		for (i = 0; i < jsonData.length; i++) {

			htmlTable = htmlTable + "<tr id='"+jsonData[i].Id+"' onclick ='putHinNo(\""+jsonData[i].HIN+"\")'>";
			/* htmlTable = htmlTable
					+ "<td ><input type='radio' name='patientId' id='patientId' style='margin-right:0px;' value='"
					+ jsonData[i].Id + "'" + jsonData[i].registrationDate
					+ "</td>"; */
			htmlTable = htmlTable + "<td >" + jsonData[i].registrationDate
					+ "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].HIN + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].name + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].age + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].gender + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].contactNo + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].nok1Name + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].nok2Name + "</td>";

			htmlTable = htmlTable + "</tr>";
		}
		if (jsonData.length == 0) {
			htmlTable = htmlTable
					+ "<tr><td colspan='8'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}

		$j("#tblListOfPatient").html(htmlTable);

	}

	function showResultPage(pageNo) {

		nPageNo = pageNo;
		GetPatientList('FILTER');

	}

	function ShowAllList(pageNo) {

		$j("#pageno").val("");
		nPageNo = pageNo;
		GetPatientList('ALL');

	}

	function goToPageForPatient(pageNo) {
		if (pageNo != "") {
			if (parseInt(TotalNumberOfPages) < parseInt(pageNo)) {

				alert("Please enter correct page No.");
				return;

			}
		} else {
			alert("Please enter correct page No.");
			return;
		}

		nPageNo = pageNo;
		GetPatientList('FILTER');
	}

	function validateRadio() {

		var flag = false;

		for (var i = 0; i < document.getElementsByName("patientId").length; i++) {
			if (document.getElementsByName("patientId")[i].checked == true) {
				flag = true;
			} 
		}
		if (!flag) {
			alert("Please select at least one radio button");
		}
		return flag;

	}
	
	 function validateTokenDiv()
	    {
	    	var deptId = document.getElementById("deptId").value;
	    	var doctorId = document.getElementById("doctorId").value;
	    	var sesId = document.getElementById("sesId").value;
	    	if(deptId!=0 && doctorId!=0 && sesId!=0)
	    		{
	    		submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getTokenNoForDepartment','displayToken');
	    		}
	    	else
	    	{
	    		alert("Please Select Department, Doctor And Session");
	    	}
	    		
	    }
	 
	 function putHinNo(hinNo)
	 {
		
	 	document.getElementById("serviceNoId").value =hinNo;	 	
	 	if(parseInt(hinNo)!=0)
	 		
	 		{
	 		getServicePersonNameHAL('registration',
					'registration?method=getServicePersonNameForOtherVisit&type='
							+ registration);
	 		document.getElementById("tab").click();	
	 		
	 		}
	 	 	
	 	 
	 	
	 }
	 function checksex()
	 {
		 
		 var element1 = document.getElementById("srSexId");
		 var sex = element1.options[element1.selectedIndex].text.trim(); 	 	
	 	var element = document.getElementById("deptId");
	 	var text = element.options[element.selectedIndex].text.trim();
	 	if(sex == 'Male' && text == <%=departmentNameToRestrictMalePatient.trim()%>)
	 		{
	 		alert('Male patients are restricted in '+text+' department');
	 		element.value='0';
	 		document.getElementById("displayToken").innerHTML ="";
	 		return false;
	 		}
	 	
	 	return true;
	 	
	 }
</script>

<!-- waiting list scritp ends -->