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
<%@page import="jkt.hms.masters.business.Patient"%><script
	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
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

<script>
		function displayOtherTrade(tradeId){
			if(tradeId==31){
				document.getElementById('tradeDiv').style.display = 'inline';
			}else{
				document.getElementById('tradeDiv').style.display = 'none';
			}
			}
	</script>
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
//var cnt = document.getElementById('medExam').value;
//var medExamId = document.getElementById('medExamId'+cnt).value;
//var srNo = document.getElementById('serviceNo'+cnt).value;

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
   

function checkForNok(){
var errorMessage="";
	formName="registration"
	obj = eval('document.'+formName)
	if(document.getElementById('nokNameId').value == "")
		errorMessage=errorMessage+"Please Fill NOK name \n";
	if(document.getElementById('relId').value == 0)
		errorMessage=errorMessage+"Please Select Relation \n";
	if(document.getElementById('addr').value == "")
		errorMessage=errorMessage+"Please Fill Address \n";
	
	if(errorMessage !=""){
	alert(errorMessage)
	return false;
	}else{
	return true
	}
	
	
}
function displayImage()
{
	var url = document.getElementById('fileId').value;
	document.getElementById('img1').style.display = 'inline';
	//document['pat'].src = 'file://'+url; 
	document.getElementById('img1').src=url;
	document.getElementById('photoUrlId').value =url;
}


function setAgeForPatient(){
	alert("setAgeForPatient")
}
   function copyMobileNo(mobileNo){
   document.getElementById('nokMobileNo').value=mobileNo
   
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
	 	document.getElementById('unitAddressId').value =unitAddress
	 }
 }
 var check = document.getElementById("unitId").value;
     if(check != "Other"){
      document.getElementById('addUnitDiv').style.display = 'none';
      document.getElementById('unitAddId').style.display = 'inline';
     }
}   
   
  function checkvisible(){
   if(document.getElementById('srNoNotAvail').checked || document.getElementById('serviceTypeId').value == "7"){
	//   document.getElementById('save').style.display = 'none'
	//   document.getElementById('saveAdmission').style.display = 'inline'
	   generateServiveNo();
	   populateRank('registration');
	   getHin();
	   //getServicePersonName('registration','registration?method=getServicePersonName');
	   
   }else{
	 //  document.getElementById('save').style.display = 'inline'
	//   document.getElementById('saveAdmission').style.display = 'none'
   }
  
  }
  
  function getServicePersonName1(formName,action){
  		var serviceTypeId = document.getElementById('serviceTypeId').value;
  		var serviceNo = document.getElementById('serviceNoId').value;
  		
  		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		     	obj.action = action;
		     	if(document.getElementById('srNoNotAvail').checked){
		     	if(serviceTypeId != 0 && serviceNo != ''){
	    	   	 var url=action+"&serviceNo="+serviceNo+"&serviceTypeId="+serviceTypeId;
	        	
	        	new Ajax.Updater('sNameDiv',url,
				   {asynchronous:true, evalScripts:true }); 
				   }
				return true;
				 }  
  } 
   
</script>

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
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!-- Script for tab content -->
<form name="registration" method="post" action="">
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
			
			List<MasServiceType> serviceTypeList =null;
			List<MasRelation> relationList = null;
			List<MasRank> rankList = null;
		//	List<MasUnit> unitList = null;
			List<Object[]> unitList = null;
			List<MasTitle> titleList = null;
			List<MasMaritalStatus> maritalStatusList = null;
			List<MasTrade> tradeList = null;
			List<MasReligion> religionList = null;
			List<MasCountry> countryList = null;
			List<MasState> stateList = null;
			List<MasDistrict> districtList = null;
	//		List<MasBlock> blockList = null;
			List<MasRecordOfficeAddress> recordOfficeAddressList =null;
			List<MasBloodGroup> bloodGroupList = null;
			List<MasOccupation> occupationList = null;
	//		List<MasReference> referenceList = null;
	//		List<MasComplaint> complaintList = null;
			List<MasEmployee> doctorList = null;
	//		List<MasCaseType> caseTypeList = null;
	//		List<MasDiagnosisConclusion> diagnosisList = null;
	//		List<MasDisposal> disposalList = null;
			List<MasAdministrativeSex> sexList = null;
			List<MasDepartment> departmentList = null;
			List<MasServiceStatus> serviceStatusList = null;
			List<MasStation> stationList = null;
			List<MasSection> sectionList = null;
			List<MasReporting> reportingList = null;
			List<MasCommand> commandList = null;
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
			/*		if(map.get("blockList") != null){
				blockList = (List<MasBlock>)map.get("blockList");
		    }
			if(map.get("referenceList") != null){
				referenceList = (List<MasReference>)map.get("referenceList");
			}
			if(map.get("complaintList") != null){
				complaintList = (List<MasComplaint>)map.get("complaintList");
			}
			if(map.get("caseTypeList") != null){
				caseTypeList = (List<MasCaseType>)map.get("caseTypeList");
			}
			if(map.get("diagnosisList") != null){
				diagnosisList = (List<MasDiagnosisConclusion>)map.get("diagnosisList");
			}
			if(map.get("disposalList") != null){
				disposalList = (List<MasDisposal>)map.get("disposalList");
			}*/
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
			if(map.get("reportingList") != null){
				reportingList = (List<MasReporting>)map.get("reportingList");
			}
			if(map.get("commandList") != null){
				commandList = (List<MasCommand>)map.get("commandList");
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
			%> <script type="text/javascript">
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
	<%--		<%
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
		--%></script> <!--Patient Photo Place holder-->
<div class="titleBg">
<h2>Patient Registration</h2>
</div>
<div class="clear"></div>

<!-- 
<label >Patient Photo</label>
<input type="file" id="fileId" name="image"  onchange="displayImage();" onblur="displayImage();" tabindex="1" />
<input type="hidden" id="photoUrlId" name="photoUrl" value="" >
<img src="" name="img1" width="67" class="photo" height="60" id="img1" />

<input type="button" name="Submit" 	value="Appointment" tabindex="1" class="buttonbig" onClick="window.open('registration?method=getAppointmentTypeNoneList','mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=960,height=300');" /> -->
<div class="clear"></div>
<!--Patient Photo Place holder Ends-->
<ul id="countrytabsIn" class="shadetabsIn">
	<label><a href="#" rel="country1" class="selected"><span>
	Service Personnel Details</span> </a></label>
	<label><a href="#" rel="country2"><span> Dependent
	Details </span></a></label>
	<!--<label><a href="#" rel="country3"> <span>Visit Details  </span></a></label>
-->
	<div id="srPhoto" class="photo">
	<img src="/hms/jsp/images/na.jpg" name="img1" width="105" height="105" id="img1" />
	</div>
</ul>

<div class="tabcontainerIn">
<div id="country1" class="tabcontentIn">
<div class="Block"><label>HIN No.</label> <!--  <div id="defaulthinno" style="float:left; width: 130px;"></div>-->
<label id="defaulthinno" class="value">&nbsp;</label> <!--<div id="hinNoDivId" style="display: none; float:left; width:130px; padding-left: 5px; font-size: 13px; background-image:url(/hms/jsp/images/tablehead.gif);font-weight: bold; text-align:left; color: #000000; "></div>-->
<label id="hinNoDivId" class="value" style="display: none;"></label> <input
	id="hinNoId" type="hidden" name="<%=HIN_NO %>" value="" /> <!--<label>Sr No. not available</label>
<input type="checkbox" name="<%=REG_NOT_AVAILABL%>" value="y" id="srNoNotAvail" class="radio" onclick="checkvisible();" onblur="getHin();"/>

-->
<div class="clear"></div>

<!--  <label>Registration Date</label>--> <input type="hidden"
	name="<%=REG_DATE %>" value="<%=currentDate %>"
	validate="Registration Date,String,no" readonly="readonly"
	class="calDate" /> <!--<label>Registration Time</label>
--><input type="hidden" name="<%=REG_TIME %>" value="<%=time %>"
	validate="Registration Time,string,no" maxlength="20"
	readonly="readonly" class="calDate" />


<div class="clear"></div>

<label><span>*</span> Service Type</label> 
<!--<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>" validate="Service Type,string,yes"  tabindex="1" onchange="populateRank('registration');populateRecordOfficeAddress(this.value,'registration');getServicePersonName('registration','registration?method=getServicePersonName');checkServiceType(this.value);getHin();">
		--> <select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>"
	validate="Service Type,string,yes" tabindex="1"
	onchange="getServicePersonName('registration','registration?method=getServicePersonName&type=registration');populateRank('registration');checkServiceType(this.value);getHin();">
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

<div id="tempDiv"><label><span>*</span> Service Status</label> 
<select	id="serviceStatusId" name="<%=SERVICE_STATUS_ID %>"
	validate="Service Status,string,yes" tabindex="1"
	onchange="populateRank('registration');getHin();setUnit();">
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

<div id="tempDiv2"><label><span>*</span> Service No.</label></div>
<!-- End of tempDiv2 --> <!--  <label >Prefix</label>--> <input
	id="prefix" name="<%=PREFIX%>" maxlength="3" class="auto" size="3"
	tabindex="1" validate="Prefix,alphanumaric,no" /> <input
	id="serviceNoId" class="auto" size="7" type="text"
	name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1"
	validate="Service No,alphanumeric,yes" maxlength="20"
	onblur="validateServiceNo(this.value,'registration');submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=displaySrPhoto','srPhoto');submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getServiceNoDetailsForReg&serviceNo='+this.value,'depenedentDiv');">
</div>
<!-- End of tempDiv -->

<div id="serRelId"><!--  <label ><span>*</span>  Suffix</label>-->
<select id="suffixId" name="<%=SUFFIX%>" validate="Suffix,string,no"
	tabindex="1" class="smallest">
	<option value="">Select</option>
	<%
			for(char i='A'; i<='Z'; i++){
		%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>
	<option value="-">-</option>
</select> <!-- <label ><span>*</span>  Relation</label>
<select id="relationId" name="<%=SERVICE_PERSONNEL_RELATION_ID%>" validate="Relation to Service Personnel,string,yes" tabindex="1"  onchange="if(checkForFirstRow()){checkPatientRegistration(); setUnit();}" onblur="if(checkForFirstRow()){checkPatientRegistration(); setUnit();}">
			<option value="0">Select</option>
			<%
			 	for (MasRelation masRelation : relationList) 
				{
			%>
			<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
			<%}%>
</select> --></div>
<!-- End of serRelId -->

<div class="clear"></div>
<div id="sNameDiv">
<div id="rankDivId"><label><span>*</span> Rank</label> <select
	id="rankId" name="<%=RANK_ID%>" validate="Rank,string,yes" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		if(masRank.getServiceType().getId() == 2 && masRank.getServiceStatus().getId() == 1){
			%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}}%>
</select> 
<script type="text/javascript">
		
		<%
			int k=0;
			for (MasServiceStatus masServiceStatus : serviceStatusList) 
			{
				for (MasRank masRank : rankList) 
				{
					if(masRank.getServiceStatus() != null){
						if(masServiceStatus.getId().equals(masRank.getServiceStatus().getId())){
								%>
									rankArr[<%=k%>] = new Array();
									rankArr[<%=k%>][0] = <%=masServiceStatus.getId()%>;
									rankArr[<%=k%>][1] = <%=masRank.getServiceType().getId()%>;
									rankArr[<%=k%>][2] = <%=masRank.getId()%>;									
									rankArr[<%=k%>][3] = "<%=masRank.getRankName()%>";
								<%
								k++;
						}
					}
				}
			}
		%>
</script></div>
<!-- End of rankDivId --> <script type="text/javascript">
		
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
</script> <script type="text/javascript">
		
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
</script> <label><span>*</span> First Name</label> <input id="sFNameId"
	type="text" name="<%=S_FIRST_NAME %>" value="" tabindex="1"
	title="First Name of Service Person"
	validate="First Name of Service Person,alphaspace,yes" MAXLENGTH="15"
	onblur="fillPatientName(this);" /> <label>Middle Name</label> <input
	id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value=""
	tabindex="1" validate="Middle Name of Service Person,alphaspace,no"
	MAXLENGTH="15" onchange="fillPatientName(this);" />

<div class="clear"></div>
<label>Last Name</label> <input id="sLNameId" type="text"
	name="<%=S_LAST_NAME %>" value="" tabindex="1"
	validate="Last Name of Service Person,alphaspace,no" MAXLENGTH="15"
	onchange="fillPatientName(this);" /> <label><span>*</span> Sex</label>
<select name="<%=SR_SEX %>" id="srSexId" validate="" tabindex="1"
	onchange="fillPatientName(this);">
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
</select> <label>DOB</label> <input type="text" id="srdobId" name="<%=SR_DOB %>"
	tabindex="1" value="" readonly="readonly"
	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate"
	onblur="calculateSRAgeInAjax();fillPatientName(this);" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.registration.<%=SR_DOB%>,event)" />
<div class="clear"></div>

<label><span>*</span> Age</label>
<div id="srAgeDiv" style="display: block;">
<!--<select id="srAgeId"
	name="<%=SR_AGE%>" validate="Age of Service Person,string,yes"
	tabindex="1" class="smallest"
	onchange="checkForSRDOB();fillPatientName(this);">
	-->
	<select id="srAgeId"
	name="<%=SR_AGE%>" validate="Age of Service Person,string,yes"
	tabindex="1" class="small"
	onchange="fillPatientName(this);">
	<option value="">Select</option>
	<%
				for(int age1 = 16;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly">
<!--<select id="srAgeUnitId" name="<%=SR_AGE_UNIT%>"
	validate="AgeUnit,string,no" tabindex="1" class="small"
	onchange="checkForSRDOB();fillPatientName(this);">
	<option selected="selected" value="Years">Years</option>
	
          <option value="Months">Months</option>
          <option value="Days">Days</option>

</select>-->
</div>


<input type="hidden" id="idForSrAge" value=""> <label>
Marital Status</label> <select name="srMaritalStatus" id="srmrstatus"
	validate="Marital Status of service Person,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
	
	%>
	<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
	<%}%>
</select> <label> Command</label> <select id="commandId" name="<%=COMMAND %>"
	validate="Command,string,no" tabindex="1"
	onchange="populateStation('registration');displayOtherCmd(this.value);">
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
<div id="addCmdDiv" style="display: none;"><label><span>*</span>
Command Name</label> <input type="text" id="addCmd" name="commandName" value=""
	tabindex="1" maxlength="30" /></div>
<div class="clear"></div>
<div id="tradeDivId"><label>Station</label> <select
	id="stationId" name="<%=STATION %>"
	onchange="populateUnit('registration');displayOtherStn(this.value)"
	tabindex="1">
	<option value="">Select</option>
	<%
	 for(MasStation masStation : stationList){
		
	 %>
	<option value="<%=masStation.getStationName()%>"><%=masStation.getStationName()%></option>

	<%}
	%>
	<option value="other">Other</option>
</select>
<div id="addStnDiv" style="display: none;"><label>Station
Name</label> <input type="text" id="addStn" name="stationName" tabindex="1"
	value="" maxlength="30" /></div>
<label><span>*</span> Unit</label> <!--<select id="unitId" name="<%=UNIT_ID %>" onchange="displayAddress()" tabindex="1" validate="Unit,string,yes"  >
--> <select id="unitId" name="<%=UNIT_ID %>" tabindex="1"
	validate="Unit,string,yes" onchange="displayOtherUnit(this.value)">
	<option value="0">Select</option>
	<%
					 for(Object[] masUnit : unitList){
					
					 %>
	<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>

	<%
					 }%>
	<option value="other">Other</option>
</select>
<div id="unitAddId"><!--  <label  > Unit Address</label>
			<input id="unitAddressId" type="text" name="unitAdd" value=""    validate="Unit Address,string,no" maxlength="50" readonly="readonly"/>
			--></div>
<!-- End of unitAddId -->

<div id="addUnitDiv" style="display: none;"><label><span>*</span>
Unit Name</label> <input id="newUnitId" type="text" name="<%=UNIT_NAME%>"
	value="" tabindex="1" validate="Unit Name,string,no" maxlength="30"
	tabindex="1" /> <label> Unit Address</label> <input
	id="newUnitAddressId" type="text" name="<%=UNIT_ADDRESS %>" value=""
	validate="Unit Address,string,no" maxlength="50" tabindex="1" /> <!--<label >Is Local Unit</label>	
<input type="checkbox" id="localUnit" name="<%=LOCAL_UNIT %>" value="y" class="radio" tabindex="1" />
			
--></div>
<label>Section</label> <select id="sectionId" name="<%=SECTION_ID%>"
	validate="Section,string,no" tabindex="1"
	onblur="displayOtherSec(this.value)">
	<option value="0">Select</option>
	<%
	 for(MasSection masSection : sectionList){
		
	 %>
	<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>

	<%}
	%>
	<option value="other">Other</option>

</select>
<div id="addSecDiv" style="display: none;"><label>Section
Name</label> <input type="text" id="addSec" name="sectionName" tabindex="1"
	value="" maxlength="30" /></div>
<div class="clear"></div>
<label> Trade/Branch</label> <select id="tradeId" name="<%=TRADE_ID%>"
	validate="Trade,string,no" tabindex="1"
	onchange="displayOtherTrade(this.value);">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
	<option value="other">Other</option>
</select>


<div id="addTradeDiv" style="display: none;"><label>
Trade/Branch Name</label> <input id="newTradeId" type="text"
	name="<%=TRADE_NAME%>" value="" tabindex="1"
	validate="Trade Name,string,no" maxlength="30" tabindex="1" /> <!--<label >Is Local Trade</label>	
<input type="checkbox" id="localTrade" name="<%=LOCAL_TRADE %>" value="y" class="radio" tabindex="1" />

-->
<div class="clear"></div>
</div>


<script type="text/javascript">
		
		<%
			int tradeCount=0;
			for (MasServiceType masServiceType : serviceTypeList) 
			{
				for (MasTrade masTrade : tradeList) 
				{
					if(masTrade.getServiceType() != null){
						if(masServiceType.getId().equals(masTrade.getServiceType().getId())){
								%>
									tradeArr[<%=tradeCount%>] = new Array();
									tradeArr[<%=tradeCount%>][0] = <%=masServiceType.getId()%>;
									tradeArr[<%=tradeCount%>][1] = <%=masTrade.getId()%>;									
									tradeArr[<%=tradeCount%>][2] = "<%=masTrade.getTradeName()%>";
								<%
								tradeCount++;
						}
					}
				}
			}
		%>
</script> <script type="text/javascript">
			function displayAddressForTrade(){
				var unit = document.getElementById('tradeId').value;
				//document.getElementById('tradeAddId').style.display = 'inline';
				if(unit != 0){
				if(unit != 'Other'){
				document.getElementById('addTradeDiv').style.display = 'none';
				<%
					 for(MasTrade masTrade : tradeList){
				%>
						var unit1 = '<%=masTrade.getId()%>';
						if(unit == unit1){
						
							//document.registration.unitAdd.value = ''
						 }
			<%}%>}else if(unit == 'Other'){
						document.getElementById('addTradeDiv').style.display = 'inline';
					//	document.getElementById('tradeAddId').style.display = 'none';
					}
				}
			}
</script> 
 
 <script type="text/javascript"><%--
					
				<%
					int count2 = 0;
					for (MasServiceType masServiceType : serviceTypeList) 
					{
						for (MasRecordOfficeAddress masRecordOfficeAddress : recordOfficeAddressList) 
						{
							if(masRecordOfficeAddress.getServiceType() != null){
								if(masServiceType.getId().equals(masRecordOfficeAddress.getServiceType().getId())){
										%>
											officeAddArr[<%=count2%>] = new Array();
											officeAddArr[<%=count2%>][0] = <%=masServiceType.getId()%>;
											officeAddArr[<%=count2%>][1] = <%=masRecordOfficeAddress.getId()%>;									
											officeAddArr[<%=count2%>][2] = "<%=masRecordOfficeAddress.getAddress()%>";
										<%
										count2++;
								}
							}
						}
					}
				%>
--%></script> <!--  <label >Formation</label>			
<input id="formation" type="text" name="<%=FORMATION_ID %>"   value="" validate="Formation,alphaspace,no" maxlength="30" tabindex="1">			
--> <label> DOE/DOC</label> <input type="text"
	id="commissionDateId" name="commissionDate" tabindex="1" value=""
	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"
	class="calDate" onblur="calculateTotalService(this.value);" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.registration.commissionDate,event)" /> <input
	type="hidden" id="idForComEnrlDate" value=""> 
	<label>Total Service </label> 
	<input id="totalServYrs" type="hidden" name="" value=""
	validate="Total Service,float,no" maxlength="6" tabindex="1" />

<div id="totalService" style="display: block;">
<!--<select
	id="totalServ" name="<%=TOTAL_SERVICE%>"
	validate="Total Service year,string,no" tabindex="1" class="small"
	onchange="checkForDateForCommEnrl();checkAgeAndService();">

	-->
	<select
	id="totalServ" name="<%=TOTAL_SERVICE%>"
	validate="Total Service year,string,no" tabindex="1" class="small"
	onchange="checkAgeAndService();">
	
	<%
				for(int age1=0;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> <select id="totalServUnit" name="<%=TOTAL_SERVICE_PERIOD %>"
	tabindex="1" class="smallest" >
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select></div>
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
<label>Blood Group</label> <select id="serBldGroupId"
	name="<%=SERV_BLD_GROUP %>" validate="Blood Group,string,no"
	tabindex="1" onchange="fillPatientName(this);">
	<option value="0">Select</option>
	<%
	 for(MasBloodGroup masBloodGroup : bloodGroupList){
	
	%>
	<option value="<%=masBloodGroup.getId()%>"><%=masBloodGroup.getBloodGroupName()%></option>
	<%}%>
</select>
<div class="clear"></div>
 <!-- End of addUnitDiv --></div>
<!-- End of tradeDivId -->

<div id="UnitHideDiv"><!--  <label >Local Unit</label>	
<input type="checkbox" name="checkLocalUnit" id="checkLocalUnit" value="y" tabindex="1" checked="checked" onclick="displayUnit();" class="radio" />
	--> <%--
<script type="text/javascript">
			function displayUnit(){
				var lUnit = document.getElementById('localUnit');
				var unit1 = document.registration.<%=UNIT_ID %>;
				
				if(lUnit.checked == false){
					unit1.length = 1;
					<%
					// for(Object[] unit : unitList){
					%>
					unit1.length++;
					if(unit1.options){
						unit1.options[unit1.length-1].value=<%=unit[0]%>;
						unit1.options[unit1.length-1].text='<%=unit[1]%>';	
					}	
				    
				<%//}%>
				}else{
					unit1.length = 1;
					<%
					// for(Object[] unit : unitList){
					//	 if(unit.getLocalUnit() != null){
					//	 if(unit.getLocalUnit().equals("y")){
					%>
					unit1.length++;
					if(unit1.options){
						unit1.options[unit1.length-1].value=<%=unit[0]%>;
						unit1.options[unit1.length-1].text='<%=unit[1]%>';	
					}	
					<%//}
						// }
					//}%>
				}
				unit1.length++;
				if(unit1.options){
					unit1.options[unit1.length-1].value='Other';
					unit1.options[unit1.length-1].text='Other';		
				}
			}
		
</script> --%> <%--
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
						
							document.registration.unitAdd.value = '<%=masUnit.getUnitAddress()%>'
						 }
			<%}%>}else if(unit == 'Other'){
						document.getElementById('addUnitDiv').style.display = 'inline';
						document.getElementById('unitAddId').style.display = 'none';
					}
				}else if(unit == 0){
					document.registration.<%=UNIT_ADDRESS%>.value = '';
				}
			}
</script> --%></div>
<!-- removal of rank div id and sname --> <input type=hidden value=0
	name=pagecounter2 />

<div id="exServiceId"></div>

<label>Telephone No.</label> <input id="phoneNo"
	name="<%=TELEPHONE_NO %>" type="text" tabindex="1" maxlength="11" /> <label>Mobile
No.</label> <input id="mobileNo" name="<%=MOBILE_NO %>" type="text" tabindex="1"
	maxlength="11" />
	
	<label>AFNET No.</label> 
	<input id="afnetNo" name="afnetNo" type="text" tabindex="1"
	maxlength="15" />
<div class="clear"></div>
<label> Reporting For</label> <select id="reportinForId"
	name="<%=REPORTING_FOR %>" validate="Reporting For,string,yes"
	tabindex="1" onchange="displayCategotries(this.value);">
	<option value="0">Select</option>
	<%
	 for(MasReporting masReporting : reportingList){
		
	 %>
	<option value="<%=masReporting.getId()%>"><%=masReporting.getReportingName()%></option>

	<%}
	%>
</select>
<div id="medExamCategoryDiv" style="display: none;"><label><span>*</span>
Exam Category</label> <select id="medExamCategory" name="medExamCategory"
	tabindex="1">
	<option value="">Select</option>
	<option value="Annual Medical Exam(AFMSF-3B)">Annual Medical
	Exam(AFMSF-3B)</option>
	<option value="Med. Exam On Release/Discharge(AFMSF-18)">Med.
	Exam On Release/Discharge(AFMSF-18)</option>
	<option value="Primary/Extension Med. Exam(AFMSF-2A)">Primary/Extension
	Med. Exam(AFMSF-2A)</option>
	<option value="Prior To Proceedings Abroad Med. Exam(AFMSF-3B)">Prior
	To Proceedings Abroad Med. Exam(AFMSF-3B)</option>
	<option value="High Altitude Med. Exam(AFMSF-3B)">High
	Altitude Med. Exam(AFMSF-3B)</option>
</select></div>

<div id="medBoardCategoryDiv" style="display: none;"><label><span>*</span>
Board Category</label> <select id="medBoardCategory" name="medBoardCategory"
	tabindex="1">
	<option value="">Select</option>
	<option value="Initial Medical Board AFMSF 15">Initial Medical
	Board AFMSF 15</option>
	<option value="Medical Board Review AFMSF 15">Medical Board
	Review AFMSF 15</option>
	<option value="Medical Board Rel/Invalidment AFMSF 16">Medical
	Board Rel/Invalidment AFMSF 16</option>
</select></div>
<label class="highlight"><span>*</span> Doctor</label> <select
	id="srconsultingDocId" name="srConsultingDoc"
	validate="Doctor,string,no"
	onchange="fillPatientName(this);submitProtoAjax('registration','registration?method=getTokenNoForDepartment');setDepartmentValue(this.value);"
	tabindex="1">
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
</select> <input type="hidden" name="regHinId" id="regHinId" value="0"></div>
<!-- End of sNameDiv -->
<div class="clear"></div>
</div>
</div> <!-- End of country1 -->

<div clear="clear"></div>
<div id="country2" class="tabcontentIn">
<div class="Block"><label><span>*</span> Relation</label> <select
	id="relationId" name="<%=RELATION_ID %>"
	validate="Relation to Service Personnel,string,yes" tabindex="1"
	onchange="if(checkForFirstRow()){checkPatientRegistration(); setUnit();setMaritalStatus();}">
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

</select> <label> Title</label> <select id="titleId" name="<%=TITLE%>"
	validate="Title,string,no" tabindex="1">
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
</select> <label><span>*</span> First Name</label> <input type="text"
	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"
	title="First Name of the Patient"
	validate="Patient First Name,alphaspace,yes" MAXLENGTH="15" />
<div class="clear"></div>

<label>Middle Name</label> <input type="text" id="pMiddleNameId"
	name="<%=P_MIDDLE_NAME%>" value="" tabindex="1"
	validate="Patient Middle Name,name,no" MAXLENGTH="15" /> <label>Last
Name</label> <input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"
	value="" validate="Patient Last Name,name,no" MAXLENGTH="15"
	tabindex="1" /> <label><span>*</span> Sex</label> <select
	name="<%=GENDER %>" id="gender" validate="Gender,string,yes"
	tabindex="1"><!--
	<option value="0">Select</option>
	--><%
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
<div class="clear"></div>

<label>DOB</label> <input type="text" id="dobId"
	name="<%=DATE_OF_BIRTH %>" tabindex="1" value=""
	onblur="calculateAgeInAjax();" readonly="readonly"
	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.registration.<%=DATE_OF_BIRTH%>,event)" />


<label><span>*</span> Age</label>
<div id="ageDiv" style="display: block;">
<!--<select id="ageId"
	name="<%=AGE%>" validate="Age of Patient,string,yes" tabindex="1"
	class="smallest" onchange="checkForDOB();">
--><select id="ageId"
	name="<%=AGE%>" validate="Age of Patient,string,yes" tabindex="1"
	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 
<!--<select id="ageUnitId" name="<%=AGE_UNIT %>"
	validate="AgeUnit,string,no" tabindex="1" class="small"
	onchange="checkForDOB();">
	-->
<select id="ageUnitId" name="<%=AGE_UNIT %>"
	validate="AgeUnit,string,no" tabindex="1" class="small">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<input type="hidden" id="idForAge" value=""></div>
<!-- End of ageDiv --> <label> Occupation</label> <select
	id="occupation" name="<%=OCCUPATION_ID %>"
	validate="Occupation,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasOccupation masOccupation : occupationList){
	
	%>
	<option value="<%=masOccupation.getId()%>"><%=masOccupation.getOccupationName()%></option>
	<%}%>
</select>

<div class="clear"></div>


<label> Marital Status</label> <select name="<%=MARITAL_STATUS_ID %>"
	id="mrstatus" validate="Marital Status,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
	
	%>
	<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
	<%}%>
</select> <label> Blood Group</label> <select name="<%=BLOOD_GROUP_ID %>"
	id="bldGrp" validate="Blood Group,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasBloodGroup masBloodGroup : bloodGroupList){
	
	%>
	<option value="<%=masBloodGroup.getId()%>"><%=masBloodGroup.getBloodGroupName()%></option>
	<%}%>
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
	
<div class="clear paddingTop15"></div>
<h4>Contact Details</h4>


<label>State</label> <select id="stateId" name="<%=STATE%>"
	validate="State,string,no" tabindex="1"
	onChange="populateDistrict(this.value,'registration')">
	<option value="0">Select</option>
	<%

		for(MasState masState : stateList){
		//	if(masState.getCountry() != null){
			//	if(masState.getCountry().getCountryCode().equals(indiaCode))
			//	{
			//		if(masState.getStateCode().equals(karnatakaStateCode))
			//		{
	%>
	<!--<option value="<%=masState.getId() %>" selected="selected"><%=masState.getStateName() %></option>
      -->
	<%			//	}else{ %>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%			//	}
			//	}
		//	}
		}%>
</select> <label>City</label> <select name="<%=DISTRICT%>"
	validate="City,string,no" id="cityId" tabindex="1"
	onChange="if(fillNokAddr()&&selectPatientDistrict(this.value)){populateBlock(this.value,'registration')}">
	<option value="0">Select</option>
	<%
		for(MasDistrict masDistrict : districtList){
			//if(masDistrict.getState() != null){
			//	if(masDistrict.getState().getStateCode().equals(karnatakaStateCode))
			//	{
				//	if(masDistrict.getDistrictCode().equals(bangaloreDistrictCode))
				//	{
	%><!--
      <option value="<%=masDistrict.getId()%>" selected="selected"><%=masDistrict.getDistrictName()%></option>
      -->
	<%		//		}else{ %>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%			//	}
			//	}
		//	}
		}%>
</select> <label>Local Address</label> <textarea name="<%=ADDRESS %>" id="addr"
	cols="20" rows="2" tabindex="1" validate="Address,string,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	onblur="fillNokAddr();"></textarea> <%--  <label class="medium">Block</label> 
<select name="<%=BLOCK%>" validate="Block,string,no" tabindex="1" class="small"  id="blockId">
      <option value="0">Select</option>
      <%
    	for(MasBlock masBlock : blockList){
    		if(masBlock.getDistrict() != null){
    			if(masBlock.getDistrict().getDistrictCode().equals(bangaloreDistrictCode)){
    			
    %>
      <option value="<%=masBlock.getId() %>"><%=masBlock.getBlockName() %></option>
      <%		}
    		}
    	} 
    	%>
</select> --%> <script type="text/javascript">
	
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
</script> <%--  <label class="medium"><span>*</span>   Country</label>
<select name="<%= NATIONALITY %>" validate="Nationality,string,yes" tabindex="1" onChange="populateState(this.value,'registration')"  id="countryId">
      <option value="0">Select</option>
      <%
	 for(MasCountry cntMaster : countryList)
	 {
		 if(cntMaster.getCountryCode().equals(indiaCode)){
	%>
      <option value="<%=cntMaster.getId() %>" selected="selected"><%=cntMaster.getCountryName() %></option>
      <%		}else{ %>
      <option value="<%=cntMaster.getId()%>"><%=cntMaster.getCountryName()%></option>
      <%
			}
	}%>
</select> --%> <!--<label class="medium">Pincode</label>
<input type="text" class="auto" size="15" name="<%=PINCODE %>" value=""   validate="Pincode,int,no" maxlength="8" tabindex="1" id="pinCodeId" onblur="fillNokAddr();" />
<label class="medium"><span>*</span>  District</label>
<select name="<%=PATIENT_DISTRICT%>" validate="Patient District,string,yes"  tabindex="1" id="patientDistId">
      <option value="">Select</option>
      <%
		for(MasDistrict masDistrict : districtList){
			%>
      	<option value="<%=masDistrict.getDistrictName()%>"><%=masDistrict.getDistrictName() %></option>
      <%				
		}%>
</select> --> <!--<label class="medium"> P Station</label>
<input type="text" name="<%=POLICE_STATION %>" value=""  validate="Police Station,alphaspace,no"  MAXLENGTH="30" tabindex="1" id="policeStation"/>
--> <!--<label class="medium">Phone</label> 
<input type="text" name="<%=PHONE %>" value=""   validate="Phone,phone,no" MAXLENGTH="20" tabindex="1" id="phoneNo"/>	
-->

<div class="clear"></div>

<label>Contact No.</label> <input type="text"
	name="<%=CONTACT_NUMBER %>" id="contactNo" value=""
	validate="Mobile Number,phone,no" MAXLENGTH="20" tabindex="1" /> <!--
<label class="medium">Email Id</label> 
<input type="text" name="<%=EMAIL_ID %>" value=""   validate="Email Id,email,no" MAXLENGTH="40" tabindex="1"/>	
--> <!--  <div id="sCardDetailId"> 
<label class="medium"><span>*</span>  I-Card Verify</label>
<input type="radio" id="sCardIdY" name="<%=I_CARD_VERIFIED%>" value="y" onclick="checkServiceCardStatus(this.value);"  class="radioAuto" validate="I-Card Verif,string,no" tabindex="1" />
<label class="smallAuto">Yes</label>
<input type="radio" id="sCardIdN" name="<%=I_CARD_VERIFIED%>" value="n" onclick="checkServiceCardStatus(this.value);"   class="radioAuto" validate="I-Card Verif,string,no" tabindex="1" />
<label class="small">No </label>
	
<label class="medium">D_O_I / DCard</label>
    
<input type="text" id="depIssueDateId" name="<%=DEPENDENT_CARD_ISSUE_DATE %>" value="" readonly="readonly" validate="D_O_I Dep Card,date,no" class="calDate"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender"onClick="setdate('',document.registration.<%=DEPENDENT_CARD_ISSUE_DATE%>,event)" />

<div class="clear"></div>	

<label class="medium">D-Card Valid</label>
<input type="text" id="cardValidityId" name="<%=I_CARD_VALIDITY_DATE %>" value=""    readonly="readonly" validate="I-Card Valid,date,no" class="auto" size="15" />

</div>--><!-- End of sCardDetailId --> <!-- <label class="medium">Mother Hin No.</label> 
<input id="motherHinId" type="text" name="<%=MOTHER_HIN_NO %>" value=""  class="auto" size="14"  validate="Mother's Hin,string,no" MAXLENGTH="50" onBlur="getMotherName();" tabindex="1"/>	

<label>Mothers Name</label>
<label class="value" id="motherNameId" style="display: none;">    </label>
 --> <label class="highlight"><span>*</span> Doctor</label> <select
	id="consultingDocId" name="<%=CONSULTING_DOCTOR %>"
	validate="Doctor,string,yes"
	onchange="submitProtoAjax('registration','registration?method=getTokenNoForDepartment');setDepartmentValue(this.value);"
	tabindex="1">
	<option value="0">Select</option>
	<%
//int doctorId=0;
for(MasEmployee masEmployee : doctorList){
	//doctorId = masEmployee.getId();
	if(masEmployee.getEmpCategory() != null){
		if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%				}
	}
} %>
</select> <input type="hidden" name="<%=DEPARTMENT_ID %>" id="deptId">
<div class="clear"></div>
</div>


<div id="testDiv" style="display: none"><input type="text"
	name="<%=TOKEN_NO %>" value="" validate="Token no.,int,no"
	maxlength="3" readonly="readonly"></div>

</div>

<input type="hidden" name="<%=VISIT_NUMBER%>" value="" id="visitNo">

<!-- 2nd blockFrame Ends here --> <%--
<div id="country3" class="tabcontentIn">
<div class="Block">
<label>Complaint</label>
<input type="text" name="<%=COMPLAINT_ID%>"  value="" validate="Complaint,string,no" maxlength="100" />
<!--                     <select name="<%=COMPLAINT_ID%>" validate="Complaint,string,no"  tabindex="1">
                    <option value="0">Select</option> 
                    <%
	 			//for(MasComplaint masComplaint : complaintList){
	 		%>

                    <%//} %>
                  </select>   -->
             
<label><span>*</span>  Department</label>
<select id="deptId" name="<%=PATIENT_DEPARTMENT %>"  tabindex="40" onchange="checkDepartment();populateDoctorName(this.value,'registration')" >
<option value="0">Select</option>
<%
int departmentId = 0;
for(MasDepartment masDepartment : departmentList){
if(masDepartment.getDepartmentType() != null){
if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForCR)){
%>
<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
<%	}
}
} %>
</select>

<label><span>*</span>  Consulting Doc.</label>
<select name="<%=CONSULTING_DOCTOR %>" id="consultingDocId"  tabindex="41" onchange="submitProtoAjax('registration','registration?method=getTokenNoForDepartment')">
<option value="0">Select</option>
<%
int doctorId=0;
for(MasEmployee masEmployee : doctorList){
	doctorId = masEmployee.getId();
if(masEmployee.getEmpCategory() != null){
if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
//if(departmentId == masEmployee.getDepartment().getId())
//{
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
<%				}
//}
}
} %>
</select>

<script type="text/javascript">
<%
int i = 0;
for(MasDepartment masDepartment : departmentList){
for (MasEmployee masEmployee : doctorList) 
{
if(masEmployee.getDepartment() != null){
if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
%>
doctorArr[<%=i%>] = new Array();
doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;									
doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%>";

<%
i++;
}
}
}
}
}
%>
</script>	



<div class="clear"></div>	
					
<label>Case Type</label>
<select name="<%=CASE_TYPE_ID %>" validate="Case Type,string,no"  tabindex="1">
	<option value="0">Select</option>
	<%
 			for(MasCaseType masCaseType : caseTypeList){
 		%>
 		<option value="<%=masCaseType.getId() %>"><%=masCaseType.getCaseTypeName() %></option>
 		<%} %>
	</select>   
                
<label>Diagnosis</label>
                  
<input type="text" name="<%=DIAGNOSIS_ID%>" value=""  validate="Diagnosis,string,no" maxlength="100" />
<!--                     <select name="<%=DIAGNOSIS_ID %>" validate="Diagnosis,string,no"  tabindex="1">
                    <option value="0">Select</option>
                    <%
			//for(MasDiagnosisConclusion masDiagnosisConclusion : diagnosisList){
		%>

                    <%//} %>
                  </select> -->
                  
                  <!-- <div align="right"><label>Disposed As</label></div></td> -->
                  
                  
<!--                     <select name="<%=DISPOSAL_ID %>" validate="Disposal,string,no"  tabindex="1">
                    <option value="0">Select</option>
                    <%
			//for(MasDisposal masDisposal : disposalList){
		%>

                    <%//} %>
                  </select> -->                    
                  
                  
	
<label>Token No.</label>
			  
			  
		 <% 
		Integer tokenNo = 0;
		List<Integer> list = new ArrayList<Integer>();
		List<Visit> currentDateVisitList = new ArrayList<Visit>();
		if(map.get("currentDateVisitList") != null){
			currentDateVisitList = (List<Visit>)map.get("currentDateVisitList");
		}
		
		if(currentDateVisitList.size() > 0){
		for (Visit visit : currentDateVisitList) 
		{
			if(visit.getDepartment() != null){
				if(departmentId == visit.getDepartment().getId()){
						list.add(visit.getTokenNo());
				}
			}
		}
	}
		if(list.size() > 0){
			String maxTokenNo = Collections.max(list).toString();
			tokenNo = Integer.parseInt(maxTokenNo)+1;
		}else{
			tokenNo = 1;
		}
	%>
		   
<div id="testDiv">
<input type="text" name="<%=TOKEN_NO %>" value=""  validate="Token no.,int,no" maxlength="3" readonly="readonly">
 </div>
 
<div class="clear"></div>

<label>Hospital Staff </label> 
 <input type="checkbox" id="hospitalStaffId" name="<%=HOSPITAL_STAFF %>" value="y" class="radio" tabindex="1">

 <div class="clear"></div>
    </div> 
</div> --%></div>
<!-- End tabcontainerIn -->
<div class="clear"></div>
<script type="text/javascript">
var countries=new ddtabcontent("countrytabsIn")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>

<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>

<!--<input type="button" name="Submit" value="Send" tabindex="1" class="button" onClick="if(checkNameSpaces() && displayWarning() && checkOtherUnit() ){submitForm('registration','/hms/hms/registration?method=submitPatientInformation&AdPro=NO');}" />
			
			--> <input id="Hidden1" type="hidden" runat="server" /> <input
	id="Hidden2" type="hidden" runat="server" /> <input id="Hidden3"
	name="hicSrNo" type="hidden" runat="server" /> <input id="Hidden4"
	name="flag" type="hidden" runat="server" /> <input type="button"
	name="Submit11" value="Send" tabindex="1" class="button" target="_self"
	onClick="if(checkNameSpaces()){submitForm('registration','/hms/hms/registration?method=submitPatientInformation&flag=registration&AdPro=NO');}" />
<input type="button" name="import hic" value="Authenticate From HIC"
	class="buttonBig" tabindex="1" onclick="javascript:ReadFingerPrint() ;"/>
<input type="reset" name="Reset" value="Reset" class="button"
	tabindex="1" onClick="{clearHin();}" accesskey="r" /> <input
	type="button" name="Checkout" value="Checkout" class="buttonBig"
	tabindex="1" onclick="checkoutToHic();" />

<div id="saveAdmission" style="display: none;"><input
	type="button" name="Submit" value="Save & Admission" tabindex="1"
	class="buttonbig"
	onClick="if(checkNameSpaces()&& displayWarning()){submitForm('registration','/hms/hms/registration?method=submitPatientInformation&AdPro=YES');}" />
<input type="reset" name="Reset" value="Reset" class="button"
	tabindex="1" onClick="{clearHin();}" accesskey="r" /></div>
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
		<th scope="col">Sex</th>
		<th scope="col">Date Of Dependency</th>
		<th scope="col">Authority</th>
		<th scope="col">Date of Removal From Dependency</th>

	</tr>
	<%
	while(rs.next()){
	%>
	<tr
		onclick="getPatientDetails('/hms/hms/registration?method=getPatientDetails&cnt=<%=cnt %>');calculateAgeInAjax();">
		<td><%= rs.getString(1)%><input type="hidden"
			name="depnName<%= cnt %>" value="<%=  rs.getString(1) %>" /></td>
		
		<%
			if(rs.getDate(3)!= null){
		%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(rs.getDate(3)) %> <input
			type="hidden" name="depDob<%= cnt %>"
			value="<%= HMSUtil.convertDateToStringWithoutTime( rs.getDate(3)) %>" /></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		<td><%=rs.getString(2) %><input type="hidden"
			name="rel<%= cnt %>" value="<%=  rs.getString(2) %>" /></td>
			
			<%
			if(rs.getString(9) != null){
			%>
			<td><%=rs.getString(9) %><input type="hidden"
			name="income<%= cnt %>" value="<%=  rs.getString(9) %>" /></td>
			<%}else{ %>
			<td>&nbsp;</td>
			
			<%} %>
			
			<%
			if(rs.getString(7) != null){
			%>
			<td><%=rs.getString(7) %></td>
			<input type="hidden"
			name="occupation<%= cnt %>" value="<%=  rs.getString(7) %>" />
			<%}else{ %>
			<td>&nbsp;</td>
			
			<%} %>
			
			<% if(rs.getString(6)!= null){ %>
			<td><%=rs.getString(6) %><input type="hidden"
			name="depage<%= cnt %>" value="<%=  rs.getString(6) %>" /></td>
			<%}else{ %>
			<td>&nbsp;</td>
			<%} %>
		<%
			if(rs.getString(4)!= null){
				
				int admsexId = 0;
				String adSex = "";
				for(MasAdministrativeSex sex: sexList){
				if(sex.getHicCode() != null && sex.getHicCode().equals(rs.getString(4))){
					admsexId = sex.getId();
					adSex = sex.getAdministrativeSexName();
				}
			}
			
		%>
		<td><%=adSex %> <input type="hidden" name="depSex<%= cnt %>"
			value="<%=  admsexId %>" /></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		<%
			if(rs.getDate(5) != null){
		%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(rs.getDate(5))  %>
		<input type="hidden" name="dependencyDate<%= cnt %>"
			value="<%=  HMSUtil.convertDateToStringWithoutTime(rs.getDate(5)) %>" /></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
	<% if(rs.getString(8)!= null){ %>
			<td><%=rs.getString(8) %><input type="hidden"
			name="authority<%= cnt %>" value="<%=  rs.getString(8) %>" /></td>
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
</div>
<input type="hidden" name="depCount" value="<%= cnt %>" /> <script
	type="text/javascript">
function selectPatientDistrict(val){

temp = eval("document.registration.patientDistId");
for(i=0;i<districtArray.length;i++){
		if(districtArray[i][1]==val){
			id=	districtArray[i][2]	
		}
	}
	temp.value=id
}
function clearHin(){
	document.getElementById('hinNoDivId').innerHTML = "";
	document.getElementById('hinNoId').value='';
}

</script>

<div id="statusMessage" class="messagelabel"><br />
</div>

<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<script type="text/javascript">
function selectPatientDistrict(val){

temp = eval("document.registration.patientDistId");
for(i=0;i<districtArray.length;i++){
		if(districtArray[i][1]==val){
			id=	districtArray[i][2]	
		}
	}
	temp.value=id
}
function clearHin(){
	document.getElementById('hinNoDivId').innerHTML = "";
}
</script>
</form>



<script language="Javascript">
function displayWarning(){

if(confirm("Service no is : "+document.getElementById("serviceNoId").value+"\n Name is : "+document.getElementById("pFirstNameId").value+ " \Age :" + document.getElementById("ageId").value+"\nAre You Sure,You want Save ? ")){
		return true;
		}else{
			return false;
		}



}

function fillNokAddr(){
var state = "";
var city = "";
var obj = document.getElementById("stateId");
var val = obj.value;

for(i=0;i<obj.length;i++)
{
	if(obj.options[i].value == val)
	{
		state = obj.options[i].text
		break;
	}
}
var obj = document.getElementById("cityId");
var val = obj.value;
if(val !="0")
for(i=0;i<obj.length;i++)
{
	if(obj.options[i].value == val)
	{
		city = obj.options[i].text
		break;
	}
}
document.getElementById('nokAddr').value=document.getElementById('addr').value+'\n'+city+','+state+','+document.getElementById('pinCodeId').value
return true;
}

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
// This function check for unit name should not blank in case of unit selected "Others"--- Vishal Jain
function checkOtherUnit(){
   	if(document.getElementById('unitId') != null){
	  	var unit = document.getElementById('unitId').value;
	  	if(unit == 'Other'){
			if(document.getElementById('newUnitId').value == ""){
			 	alert("Unit Name Can not be blank... !");
			 	return false;
			 } 
		}
	}	
   return true;
}
function setUnit(){
	
    var serv_status = document.getElementById('serviceStatusId').value;
   	if(serv_status == 2){
   		if(document.registration.<%=UNIT_ID %> != null){
			 var unit1 = document.registration.<%=UNIT_ID %>;
		    	for(var i =0; i < unit1.options.length; i++){	
				  	if(unit1.options[i].text == "N/A"){
				  	 //unit1.options[i].selected==true;
				  	 unit1.selectedIndex = i;
				  	 return true;       
				     }
				}
		}		
	} 
   return true;
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

function checkForDOB()
{
//	if(document.getElementById("dobId").value == ""){
		if(document.getElementById("ageId").value!="" && document.getElementById("ageId").value>0)
		{
			var ageAtRegTime=document.getElementById("ageId").value;
			if(ageAtRegTime.indexOf(".")==1)
			{
				currentAge=ageAtRegTime.substring(0,ageAtRegTime.indexOf("."))+" "+document.getElementById("ageUnitId").value;
			}
			else if(ageAtRegTime.indexOf(".")==-1)
			{
				currentAge=document.getElementById("ageId").value+" "+document.getElementById("ageUnitId").value;
			}
			document.getElementById('idForAge').value=currentAge;
			var apoxAge=calculateApproxDobFromAge('idForAge');
			document.getElementById("dobId").value="";
			document.getElementById("dobId").value=apoxAge;
		}
//	}

	return true;
}
function checkForSRDOB()
{
//	if(document.getElementById("srdobId").value == ""){
		if(document.getElementById("srAgeId").value!="" && document.getElementById("srAgeId").value>0)
		{
			var ageAtRegTime=document.getElementById("srAgeId").value;
			if(ageAtRegTime.indexOf(".")==1)
			{
				currentAge=ageAtRegTime.substring(0,ageAtRegTime.indexOf("."))+" "+document.getElementById("srAgeUnitId").value;
			}
			else if(ageAtRegTime.indexOf(".")==-1)
			{
				currentAge=document.getElementById("srAgeId").value+" "+document.getElementById("srAgeUnitId").value;
			}
			document.getElementById('idForSrAge').value=currentAge;
			var apoxAge=calculateApproxDobFromAge('idForSrAge');
			
			document.getElementById("srdobId").value="";
			document.getElementById("srdobId").value=apoxAge;
		}
	//}

	return true;
}
function calculateApproxDobFromAge(fieldId){
var age =  document.getElementById(fieldId).value;
	var obj = age.split(" ");
	currentDateJ = new Date();

	unit=obj[1];
	year = 0; month = 0; day = 0;
	if(unit == 'Years'){
		year = currentDateJ.getFullYear()- obj[0];
	}
	else if(unit == 'Months'){
		month=(currentDateJ.getMonth()+1)-obj[0]
		if(month<=0){
			month = month+12
			year--;
		}
		if(month != 0)
			month = (month<10)? "0"+month : month


	}
	else if(unit == 'Days'){
		day = (currentDateJ.getDate()-obj[0])
		if(day<0){
			day = day+30
			month--;
		}
		day = (day<10)? "0"+day : day

	}

	if(year <= 0)
		year = currentDateJ.getFullYear()+year;
	if(month <= 0)
		month = (((currentDateJ.getMonth()+1)+month)<10)? "0"+((currentDateJ.getMonth()+1)+month) : ((currentDateJ.getMonth()+1)+month);
	if(day == 0)
		day = (currentDateJ.getDate()<10)? "0"+currentDateJ.getDate() : currentDateJ.getDate();

	approxDob =day + "/" + month + "/" + year;
	return approxDob;

}

function checkForDateForCommEnrl()
{
//	if(document.getElementById("srdobId").value == ""){
		if(document.getElementById("totalServ").value!="" && document.getElementById("totalServ").value>0)
		{
			var ageAtRegTime=document.getElementById("totalServ").value;
			if(ageAtRegTime.indexOf(".")==1)
			{
				currentAge=ageAtRegTime.substring(0,ageAtRegTime.indexOf("."))+" "+document.getElementById("totalServUnit").value;
			}
			else if(ageAtRegTime.indexOf(".")==-1)
			{
				currentAge=document.getElementById("totalServ").value+" "+document.getElementById("totalServUnit").value;
			}
			document.getElementById('idForComEnrlDate').value=currentAge;
			var apoxAge=calculateApproxDobFromAge('idForComEnrlDate');
			
		
			document.getElementById("commissionDateId").value=apoxAge;
		}
	//}

	return true;
}
function displayAddFields(){
	var servType = document.getElementById('serviceTypeId').value;
	if(servType != '2'){
		document.getElementById('addCmd').style.display='inline';
		document.getElementById('addStn').style.display='inline';
		document.getElementById('addUnitDiv').style.display='inline';
		document.getElementById('addSec').style.display='inline';
		document.getElementById('addTradeDiv').style.display='inline';
		document.getElementById('addCmd').setAttribute('validate','Command,string,yes');
		document.getElementById('newUnitId').setAttribute('validate','Unit,string,yes');
		
		document.getElementById('commandId').style.display='none';
		document.getElementById('stationId').style.display='none';
		document.getElementById('unitId').style.display='none';
		document.getElementById('sectionId').style.display='none';
		document.getElementById('tradeId').style.display='none';
		document.getElementById('commandId').setAttribute('validate','Command,string,no');
		document.getElementById('unitId').setAttribute('validate','Unit,string,no');
		
	}else{
		document.getElementById('addCmd').style.display='none';
		document.getElementById('addStn').style.display='none';
		document.getElementById('addUnitDiv').style.display='none';
		document.getElementById('addSec').style.display='none';
		document.getElementById('addTradeDiv').style.display='none';
		document.getElementById('addCmd').setAttribute('validate','Command,string,no');
		document.getElementById('newUnitId').setAttribute('validate','Unit,string,no');
		
		document.getElementById('commandId').style.display='inline';
		document.getElementById('stationId').style.display='inline';
		document.getElementById('unitId').style.display='inline';
		document.getElementById('sectionId').style.display='inline';
		document.getElementById('tradeId').style.display='inline';
		document.getElementById('commandId').setAttribute('validate','Command,string,yes');
		document.getElementById('unitId').setAttribute('validate','Unit,string,yes');
		
	}
}

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
	<%
//	if(rsEmp.getString(2)!=null){
	%>
	document.getElementById('sMNameId').value = sMName;
	document.getElementById('pMiddleNameId').value = sMName;
	<%//}
//	if(rsEmp.getString(3)!=null){
	%>
	document.getElementById('sLNameId').value = sLName;
	document.getElementById('pLastNameId').value = sLName;
	<%//}%>
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


</script>