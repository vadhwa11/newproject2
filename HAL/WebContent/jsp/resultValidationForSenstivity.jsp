<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.DgCollectionCenter"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="jkt.hms.masters.business.DgMasOrganismGroup"%>
<%@page import="jkt.hms.masters.business.DgMasOrganism"%>
<%@page import="jkt.hms.masters.business.MasAntibioticLab"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<%@page import="java.net.URL"%>

<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>
<form name="sampleCollection" method="post" action=""><script
	type="text/javascript">
<%
     Map map = new HashMap();
     int resultId=0;
 	if(request.getAttribute("map") != null){
 		map = (Map) request.getAttribute("map");
 	}
 	if(map.get("resultId") != null)
 	{
 		resultId=(Integer)map.get("resultId");
 	}
     %>
function fillOrganism(){
  var orGroupId ="";
   var x=document.getElementById("organismId")
	for (var i=0; i<x.options.length-1;i++) {
	if (x.options[i].selected) {
	orGroupId=orGroupId+x.options[i].value+"."
	
	}
}
	 //----------------------AJAX PART------------Start------
  
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
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
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById("organismDiv").innerHTML='<font id="error">Loading...</font>'
      document.getElementById("sensitivityDiv").innerHTML=""
    }else
      if(xmlHttp.readyState==4){
         document.getElementById("organismDiv").innerHTML = xmlHttp.responseText;
      }
    }
     
    xmlHttp.open("GET","/hms/hms/investigation?method=getResultOrganismList&resultId="+<%=resultId%>,true);
    
    xmlHttp.send(null);
//----------------------AJAX PART------------End------

}

function fillSensitivity(val){
var noOfOrg=document.getElementById("noOfOrg").value
 var x=document.getElementById("organismId")
 var orIds="";
for (var i=1; i<=noOfOrg;i++) {
	if (document.getElementById(("chkBox"+i)).checked) {
	orIds=orIds+document.getElementById(("chkBox"+i)).value+"."
	}}
 //----------------------AJAX PART------------Start------
  
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
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
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById("sensitivityDiv").innerHTML='<font id="error">Loading...</font>'
    }else
      if(xmlHttp.readyState==4){
         document.getElementById("sensitivityDiv").innerHTML = xmlHttp.responseText;
      }
    }
     
    xmlHttp.open("GET","/hms/hms/investigation?method=getResultSensitivityList&resultId="+<%=resultId%>,true);
    
    xmlHttp.send(null);
//----------------------AJAX PART------------End------
}
  function resetResult(){
 
	   document.getElementById('abc').value="";
	   document.getElementById('additionalRemarks').value="";
	   
   }


<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String dateCal=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(dateCal.length()<2){
dateCal="0"+dateCal;
}
%>
serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script> <%
    int pageNo=1;
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	///List<Patient> patientList = new ArrayList<Patient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	String deptName ="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	Map<String,Object> detailsMap = new HashMap<String,Object>();
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	
	List<DgResultEntryDetailSen> dgResultEntryDetailSenList =new ArrayList<DgResultEntryDetailSen>();
	
	if(map.get("dgResultEntryDetailSenList") !=null){
		dgResultEntryDetailSenList=(List<DgResultEntryDetailSen>)map.get("dgResultEntryDetailSenList");
	
	}
	List<DgMasOrganismGroup> dgMasOrganismGroupList =new ArrayList<DgMasOrganismGroup>();
	
	if(map.get("dgMasOrganismGroupList") !=null)
	{
		dgMasOrganismGroupList=(List<DgMasOrganismGroup>)map.get("dgMasOrganismGroupList");
	}
	List<DgMasOrganism> dgMasOrganismList =new ArrayList<DgMasOrganism>();
	
	if(map.get("dgMasOrganismList") !=null)
	{
		dgMasOrganismList=(List<DgMasOrganism>)map.get("dgMasOrganismList");
	}
	List<MasAntibioticLab> masAntibioticLabList =new ArrayList<MasAntibioticLab>();
	
	if(map.get("masAntibioticLabList") !=null)
	{
		masAntibioticLabList=(List<MasAntibioticLab>)map.get("masAntibioticLabList");
	}
	//System.out.println(dgResultEntryDetailSenList.size()+"jfkdfkdldldl;d;d;s;s;s;s");
	try{
		if(map.get("resultList") != null){
			resultList=(List)map.get("resultList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	//Set<DgResultEntryDetailSen> dgResultDtSenSet = new HashSet<DgResultEntryDetailSen>();
	for(DgResultEntryHeader dgResultHeader : resultList){
		//dgResultDtSenSet = dgResultHeader.;
	}
	int hospitalId = 0;
	MasRelation masRelation = new MasRelation();
	 DgResultEntryHeader dgResultEntryHeader= new DgResultEntryHeader();
	MasRank masRank = new MasRank();
	String admissionNumber = "";
	int departmentId =0;
	int inpatientId =0;
	int hinId = 0;
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	String number="";
	 if(resultList != null)
	   {
		   
		 		dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
				hinId =dgResultEntryHeader.getPatient().getId();
				inpatientSet=dgResultEntryHeader.getPatient().getInpatients();
				
			    
	   }
	    MasDepartment masDepartment=new MasDepartment();
		DgResultEntryHeader dgresultHeader=new DgResultEntryHeader();
		DgResultEntryDetail dgresultDetails=new DgResultEntryDetail();
		
	 if(resultList != null){
		 dgresultHeader = (DgResultEntryHeader) resultList.get(0);
	 }
	 session.setAttribute("dgResultEntryHeader",dgResultEntryHeader);
	 //session.setAttribute("dgResultDtSet",dgResultDtSet);
	 
	 Properties properties = new Properties();
	 URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	 try {
	 	properties.load(resourcePath.openStream());
	 	} catch (Exception e) {
	 	e.printStackTrace();
	 }
	 String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
%> <!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Result Validation</h6>
<%
	String subDept = "";String dept="";
int SubChargeId=0;
int mainChargeId=0;
		//for(DgResultEntryDetail dgDetail :dgResultDtSet){
			if(dgresultHeader != null){
			subDept = dgresultHeader.getSubChargecode().getSubChargecodeName();
			dept = dgresultHeader.getMainChargecode().getMainChargecodeName();
			SubChargeId=dgresultHeader.getSubChargecode().getId();
			mainChargeId=dgresultHeader.getMainChargecode().getId();
%> <%
 	}
 	//}%> <label class="common"> Department</label> <label
	class="valueNoWidth" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label>
<label class="noWidth">Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="valueNoWidth"><%=subDept%></label>

<input name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" />
<div class="Clear"></div>

<div class="Height10"></div>
<div class="header">
<div class="paddLeft25"><label class="NoWidth">Order Date</label></div>
<%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
Time</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
No.</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
By</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
</div>
<div class="Clear"></div>
<input type="hidden" name="<%=RESULT_ID %>" id="<%= RESULT_ID%>"
	value="<%=dgresultHeader.getId() %>" /> <!--Block One Starts-->
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service Type:</label> <%
				if(dgResultEntryHeader.getPatient().getServiceType() != null){
			%> <label class="valuemedium"><%=dgResultEntryHeader.getPatient().getServiceType().getServiceTypeName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Service No:</label> <%
				if(dgResultEntryHeader.getPatient().getServiceNo() != null && !(dgResultEntryHeader.getPatient().getServiceNo().equals(""))){
			%> <label class="valuemedium"><%=dgResultEntryHeader.getPatient().getServiceNo()%></label>
<%}else{ %> <label class="valuemedium">-</label> <%}%> <label class="medium">Service
Status:</label> <%if(dgResultEntryHeader.getPatient().getServiceStatus() != null){
			%> <label class="valuemedium"><%= dgResultEntryHeader.getPatient().getServiceStatus().getServiceStatusName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Relation:</label> <%
				if(dgResultEntryHeader.getPatient().getRelation() != null){
			%> <label class="valuemedium"><%=dgResultEntryHeader.getPatient().getRelation().getRelationName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%>
<div class="Clear"></div>
<label>Ser. Per. Name:</label> <%
				if(dgResultEntryHeader.getPatient().getSFirstName() != null  && !(dgResultEntryHeader.getPatient().getSFirstName().equals(""))){
				
					String sMiddleName = "";
					String sLastName = "";
					if(dgResultEntryHeader.getPatient().getSMiddleName() != null){
						sMiddleName = dgResultEntryHeader.getPatient().getSMiddleName();
					}
					if(dgResultEntryHeader.getPatient().getSLastName() != null){
						sLastName = dgResultEntryHeader.getPatient().getSLastName();
					}
			 %> <label class="valueNoWidth"><%=dgResultEntryHeader.getPatient().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> <label class="valueNoWidth">-</label> <% }%> <label
	class="medium">Rank:</label> <%
			if(dgResultEntryHeader.getPatient().getRank() != null){
			%> <label class="valuemedium"><%=dgResultEntryHeader.getPatient().getRank().getRankName()%></label>
<%} else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Unit</label> <%
if(dgResultEntryHeader.getPatient().getUnit() != null){
%> <label class="valuemedium"><%= dgResultEntryHeader.getPatient().getUnit().getUnitName()%></label>
<%} else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Trade</label> <%
if(dgResultEntryHeader.getPatient().getTrade() != null){
%> <label class="valuemedium"><%=  dgResultEntryHeader.getPatient().getTrade().getTradeName()%></label>
<%} else{ %> <label class="valuemedium">-</label> <% }%>
<div class="Clear"></div>

</div>
<!--Block one Ends-->
<div class="division"></div>
<!--Block Two Starts-->
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label>HIN No.:</label> <label class="value"><%=dgResultEntryHeader.getPatient().getHinNo() %></label>

<%
					String middleName = "";
					String lastName = "";
					if(dgResultEntryHeader.getPatient().getPMiddleName() != null){
						middleName = dgResultEntryHeader.getPatient().getPMiddleName();
					}
					if(dgResultEntryHeader.getPatient().getPLastName() != null){
						lastName = dgResultEntryHeader.getPatient().getPLastName();
					}
					
					%> <label>Patient Name:</label> <label class="valueNoWidth"><%=dgResultEntryHeader.getPatient().getPFirstName()+" "+middleName+" "+lastName%></label>

<label class="noWidth">Sex:</label> <label class="valueNoWidth"><%=dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName() %></label>
<div class="Clear"></div>
<%
		String age = "";
		String currentAge = "";
		age = dgResultEntryHeader.getPatient().getAge();
	    currentAge = HMSUtil.calculateAgeForADT(age, dgResultEntryHeader.getPatient().getRegDate());
		%> <label>Age:</label> <label class="value"><%=currentAge%></label> <label>Marital
Status:</label> <%
					String maritalStatus = "";
				if(dgResultEntryHeader.getPatient().getMaritalStatus() != null){
					maritalStatus =dgResultEntryHeader.getPatient().getMaritalStatus().getMaritalStatusName();
				
				%> <label class="value"><%=maritalStatus%></label> <%}else{ %> <label
	class="value">-</label> <% }%>

<div class="Clear"></div>

<div>
<%
if(dgResultEntryHeader.getInpatient() != null){
%> <input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=dgResultEntryHeader.getInpatient().getId()%>" /> <%} else{%> <input
	type="hidden" name="<%=INPATIENT_ID %>" value="" /> <%} %> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=dgResultEntryHeader.getDepartment().getId()%>" /> <input
	type="hidden" name="<%=HIN_ID %>"
	value="<%=dgResultEntryHeader.getPatient().getId() %>" /> <input
	type="hidden" name="<%=HIN_NO %>"
	value="<%=dgResultEntryHeader.getPatient().getHinNo() %>" /></div>
</div>
<!--Block Two Ends-->
<div class="division"></div>
<!-- Block Three Starts -->
<div class="blockTitle">Report Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="noWidth">&nbsp;&nbsp;Report Date</label> <%if(dgresultHeader.getResultDate() != null){ %>
<label class="valueNoWidth"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getResultDate()) %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <label
	class="noWidth">Report Time</label> <%if(dgresultHeader.getResultTime()!= null){ %>
<label class="valuenoWidth"><%=dgresultHeader.getResultTime() %></label>
<%}else{ %> <label class="valuenoWidth">-</label> <%} %> <label
	class="noWidth">Report Prepared By:</label> <%if(dgresultHeader.getEmployee() != null) {%>
<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>"
	value="<%=dgresultHeader.getEmployee().getFirstName() %>" /> <label
	class="valueNoWidth"> <%=dgresultHeader.getEmployee().getFirstName()+" "+dgresultHeader.getEmployee().getMiddleName()+" "+dgresultHeader.getEmployee().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="valueNoWidth">
-</label> <%} %> <input type="hidden" name="<%=SAMPLE_COLLECTION_DATE%>"
	value="<%=date%>" /> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="<%=RESULT_NO %>"
	value="<%=dgResultEntryHeader.getResultNo() %>" />


<div class="Clear"></div>
<label class="noWidth">&nbsp;&nbsp;Report Validated Date</label> <label
	class="valuemedium"><%=date%></label> <label class="noWidth">&nbsp;&nbsp;Report
Validated Time</label> <label class="value"><%=time%></label> <label
	class="noWidth">Report Validated By</label> <select
	id="<%=RESULT_VALIDATED_BY %>" name="<%= RESULT_VALIDATED_BY %>"
	validate="Validated By,string,no" tabindex=1>
	<option value="">Select</option>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					if( masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
				if (userId .equals(masEmployeecode.getId())) {
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}	}	}}%>
</select>


<div class="Clear"></div>
<label class="noWidth">Brief Clinical Notes</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueNoWidth"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<script>
function inputValidate(){

obj = document.getElementById('checkId');

if(!obj.checked){;
  alert("Please Validate The Report ")
 	}else{
			return true;
			}
				}
   
</script> <script>

function resetResult(){
	document.getElementById('additionalRemarks').value="";
	document.getElementById('abc').value = "";
	}
</script> <!-- Block Three Ends -->
<div class="Clear"></div>
<div class="blockFrame">
<div align="center"><label class="valueNoWidth">Growth</label> <input
	type="radio" class="small" name="screenSens" checked="checked"
	onclick="showDiv();" "/> <label class="valueNoWidth">Other</label> <input
	type="radio" class="small" name="screenSens" onclick="showDiv();" "/>
</div>
</div>
<script type="text/javascript">
		function showDiv()
		{
		if(document.sensitivity.screenSens[0].checked)
		{
		
			if(document.getElementById("growthDiv").style.display=="none")
				{
					document.getElementById("otherDiv").style.display="none";
					document.getElementById("growthDiv").style.display="block";
					
				}
		}
		if(document.sensitivity.screenSens[1].checked)
		{
	
			if(document.getElementById("otherDiv").style.display=="none")
				{
					
					document.getElementById("growthDiv").style.display="none";
					document.getElementById("otherDiv").style.display="block";
					
				}
		}
		
		}
		</script> <!--  -->
<div class="Clear"></div>
<div class="division"></div>
<!-- Table Starts -->

<div class="tableHolderAuto">
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">

	<tr>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="7%">Diag. No.</th>
		<%}else{  %>
		<th width="7%">Radio Id.</th>
		<%} %>
		<th width="7%">Service</th>
		<th width="4%">Validated</th>

		<% int i =0;
  
    //System.out.println(dgResultEntryDetailSen.getSampleCollection().getDiagNo()+"Disoskdkd");
    %>
		<tr>
			<td>
			<%if(dgResultEntryDetailSenList.get(0).getSampleCollection() != null){ %>
			<label name="<%=DIAGNOSIS_NO %>" id=<%=DIAGNOSIS_NO %> /><%=dgResultEntryDetailSenList.get(0).getSampleCollection().getDiagNo()%>
			<%} else{%> <label name="<%=DIAGNOSIS_NO %>" id=<%=DIAGNOSIS_NO %> /><%=dgResultEntryDetailSenList.get(0).getSampleCollection().getDiagNo()%>
			<%} %>
			</td>
			<td width="7%"><input name="resultType" type="hidden" size="10"
				value="" readonly /> <%if(dgResultEntryDetailSenList.get(0).getSampleCollection().getInvestigation() !=null){  %>
			<input name="<%=INVESTIGATION_ID %>" type="hidden" size="5"
				value="<%=dgResultEntryDetailSenList.get(0).getSampleCollection().getInvestigation().getId() %>"
				readonly /> <label name="chargeCode" type="text" size="10"><%=dgResultEntryDetailSenList.get(0).getSampleCollection().getInvestigation().getInvestigationName()%></label>
			<%}else { %> <label name="chargeCode" type="text" size="10"></label> <%} %>
			</td>
			<td width="4%">
			<% if(dgResultEntryDetailSenList.get(0).getSampleCollection().getValidated() != null) {%>
			<input id="checkId" name="<%=VALIDATED %>" type="checkbox"
				checked="true" class="check" /> <%}else{ %> <input id="checkId"
				name="<%=VALIDATED %>" type="checkbox" class="check" /> <%} %>
			</td>
		</tr>
</table>
</div>
<div class="Clear"></div>
<!-- start --> <!--  -->
<div id="growthDiv" style="display: block;">
<div class="Clear"></div>
<div
	style="width: 320px; height: 150px; float: left; border: 1px solid #3C8AD7;">
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Organism Group</th>
	</tr>
	<tr>
		<td><select name="organism" id="organismId" class="list"
			multiple="multiple" size="10" validate="Result Entered By,string,no"
			tabindex=1 onfocus="fillOrganism();"
			onchange="fillOrganism();fillSensitivity();">
			<%for(DgMasOrganismGroup dgMasOrganismGroup : dgMasOrganismGroupList ){ %>
			<option value="<%=dgMasOrganismGroup.getId() %>"><%=dgMasOrganismGroup.getOrganismGroupName() %></option>
			<%} %>
		</select></td>
	</tr>
</table>
</div>
</div>

<!--Start of Organism Div-->
<div id="organismDiv">
<div
	style="width: 585px; border: 1px solid #3C8AD7; height: 150px; float: left; margin-left: 20px; display: inline; overflow: auto;">
<div class="auto">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th width="8%" scope="col">&nbsp;</th>
		<th colspan="2" scope="col">Organism</th>
	</tr>

	<tr>
		<td>&nbsp;</td>
		<td width="9%">&nbsp;</td>
		<td width="71%">&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

</table>

</div>
</div>
</div>
<!--End of Organism Div-->
<div class="Clear"></div>
<div class="division"></div>

<div
	style="width: 585px; border: 1px solid #3C8AD7; height: 150px; float: left; margin-right: 20px; display: inline; overflow: auto;">
<div class="auto"><!--Start of Sensitivity Div-->
<div id="sensitivityDiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th width="7%" scope="col">&nbsp;</th>
		<th colspan="2" scope="col">Sensitivity</th>
		<th width="12%" scope="col">&nbsp;</th>
	</tr>

	<tr>
		<td>&nbsp;</td>
		<td width="9%">&nbsp;</td>
		<td width="72%">&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</div>
<!--End of Organism Div--></div>



</div>
</div>
<!--  -->



<div
	style="width: 320px; height: 140px; float: left; border: 1px solid #3C8AD7;">
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Remarks</th>
	</tr>
	<tr>
		<td><textarea name="remarks"></textarea></td>
	</tr>
</table>
</div>
</div>
<div class="Clear"></div>
<div class="division"></div>

<div
	style="width: 320px; height: 54px; float: left; border: 1px solid #3C8AD7;">
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>

		<th scope="col" colspan="2">NOSOCOMIAL</th>

	</tr>
	<tr>
		<td><label class="valueNoWidth">Yes</label> <input type="radio"
			class="small" name="NOSOCOMIAL" value="Y" checked="checked">
		</td>
		<td><label class="valueNoWidth">No</label> <input type="radio"
			class="small" name="NOSOCOMIAL" value="N"></td>
	</tr>
</table>
</div>
</div>



<br />
<br />
<br />





<!-- end -->

<div class="Clear"></div>

<div class="Clear"></div>


<!-- Table Ends --> <!--Bottom labels starts-->
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>

<input type="button" class="button" value="Submit"
	onclick="if(inputValidate()){submitForm('sampleCollection','investigation?method=submitResultValidationForTemplate')};"
	align="right" /> <input name="Button" type="button" class="button"
	value="Reset" onclick="resetResult();" /> <!--Bottom labels starts-->
<!--main content placeholder ends here--></div>
</form>
