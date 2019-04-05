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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<%@page import="java.net.URL"%>

<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>
	<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<form name="sensitivityValidation" method="post" action=""><script
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
	String resultIdStringForTemplate = "";
	Integer resultEnteredByForTemplate = 0;	
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
	if(map.get("resultEnteredByForTemplate") != null){
		resultEnteredByForTemplate = (Integer)map.get("resultEnteredByForTemplate");
	}
	if(map.get("resultIdStringForTemplate") != null){
		   resultIdStringForTemplate = (String)map.get("resultIdStringForTemplate");
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
 	//}%> <input name="<%=SUB_CHARGECODE_ID %>"
	id="<%= SUB_CHARGECODE_ID%>" type="hidden" value="<%=SubChargeId %>" />
<input name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" /> <input type="hidden"
	name="<%=RESULT_ID %>" id="<%= RESULT_ID%>"
	value="<%=dgresultHeader.getId() %>" /> <!--Block One Starts--> <!--Block Two Starts-->
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
	value="<%=dgResultEntryHeader.getPatient().getHinNo() %>" /> <%if(dgresultHeader.getEmployee() != null) {%>
<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>"
	value="<%=dgresultHeader.getEmployee().getFirstName() %>" /> <%}else { %>
<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>" value="" /> <%} %> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_DATE%>" value="<%=date%>" /> <input
	type="hidden" name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" />
<input type="hidden" name="<%=RESULT_NO %>"
	value="<%=dgResultEntryHeader.getResultNo() %>" /> <input
	type="hidden" id="<%=RESULT_VALIDATED_BY %>"
	name="<%= RESULT_VALIDATED_BY %>"
	value="<%=resultEnteredByForTemplate%>"
	validate="Validated By,string,yes" tabindex=1>


<div class="Clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <script>
function inputValidate(){
	obj = document.getElementById('checkId');
	if(!obj.checked){;
  		alert("Please Validate The Result. ");
  		return false;
 	}else{
		return true;
	}
}

 function submitSensitivityData(){
 	if(inputValidate() && checkForCheckBox()){
 		submitForm('sensitivityValidation','investigation?method=submitResultValidationForSensitivity')
 	}
 }
 function checkForCheckBox(){
	 
	 	if(document.getElementById('growthOption').value =='g') {
		 	if(document.getElementById("noOfOrg") != null){
			 	var noOfOrg = document.getElementById("noOfOrg").value;
			 	if(noOfOrg != 0){
			 		if(document.getElementById("noOfSensitivity") != null){
				 		var noOfSensitivity=document.getElementById("noOfSensitivity").value;
				 		if(noOfSensitivity != 0){
					 		for (var i=1; i<=noOfSensitivity;i++) {
								if (document.getElementById(("chkBoxSensitive"+i)).checked) {
									return true;
								}
							}
							alert('Select atleast one sensitivity.');
							return false;
				 		}else{
				 			alert('Select organism that having sensitivity.');
				 			return false;
				 		}
			 		}else{
			 			alert('Select any organism.');
			 			return false;
			 		}
			 	}else{
			 		alert('Select organism group that having organism.');
			 		return false;
			 	}
		 	}else{
		 		alert('Select any organism group.');
		 		return false;
		 	}
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

<!--  -->
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
				readonly /> <input name="<%=SAMPLE_COLLECTION_DETAIL_ID%>"
				type="hidden" size="5"
				value="<%=dgResultEntryDetailSenList.get(0).getSampleCollection().getId() %>"
				readonly /> <label name="chargeCode" type="text" size="10"><%=dgResultEntryDetailSenList.get(0).getSampleCollection().getInvestigation().getInvestigationName()%></label>
			<%}else { %> <label name="chargeCode" type="text" size="10"></label> <%} %>
			</td>
			<td width="4%">
			<% //if(dgResultEntryDetailSenList.get(0).getSampleCollection().getValidated() != null) {%>
			<input id="checkId" name="<%=VALIDATED %>" type="checkbox"
				class="check" /> <%//}else{ %> <%//} %>
			</td>
		</tr>
</table>
</div>
<div class="Clear"></div>
<!-- start --> <%if(dgResultEntryDetailSenList.get(0).getGrowthOption().equalsIgnoreCase("g")){ %>

<jsp:include page="sensitivityListJsp.jsp"></jsp:include> <%}else{%>
<div id="otherDiv" style="display: inline;">
<div class="Clear"></div>
<div
	style="width: 450px; height: 140px; float: left; border: 1px solid #3C8AD7;">
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Result 1</th>
	</tr>
	<tr>
		<td><textarea name="result1" id="result1"
			onkeyup="chkLength(this,45);"><%= dgResultEntryDetailSenList.get(0).getResult()%></textarea>
		</td>
	</tr>
</table>
</div>
</div>




<script type="text/javascript">
function chkLength(field,maxLimit)
{
	if(field.value.length > maxLimit)
	{
	 alert('you crossed the maximum limit of '+maxLimit+' characters');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	 //alert(field.value);
	}
}
</script>
<div
	style="width: 450px; height: 140px; float: left; border: 1px solid #3C8AD7; margin-left: 20px; display: inline; overflow: auto;">

<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Result 2</th>
	</tr>
	<tr>
		<td>
		<%if(dgResultEntryDetailSenList.get(0).getResultOther() != null) { %> <textarea
			name="result2" onkeyup="chkLength(this,45);"><%=dgResultEntryDetailSenList.get(0).getResultOther() %></textarea>
		<% }else { %> <textarea name="result2" onkeyup="chkLength(this,45);"></textarea>
		<% } %>
		</td>
	</tr>
</table>
</div>
</div>

</div>

<%}%> <!--  -->

<div class="Clear"></div>
<div class="division"></div>
<input name="growthOption" id="growthOption" type="hidden"
	value="<%=dgResultEntryDetailSenList.get(0).getGrowthOption()%>" />
<div
	style="width: 320px; height: 140px; float: left; border: 1px solid #3C8AD7;">


<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Remarks</th>
	</tr>
	<tr>
		<td><textarea name="remarks" onkeyup="chkLength(this,100);"><%=dgResultEntryHeader.getRemarks()%></textarea>

		</td>
	</tr>
</table>
</div>
</div>

<div
	style="width: 320px; height: 54px; float: left; border: 1px solid #3C8AD7; margin-left: 20px;">
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>

		<th scope="col" colspan="2">NOSOCOMIAL</th>

	</tr>
	<tr>
		<td><label class="valueNoWidth">Yes</label> <%if(dgResultEntryDetailSenList.get(0).getNosocomial().equalsIgnoreCase("y")){ %>
		<input type="radio" class="small" name="NOSOCOMIAL" value="Y"
			checked="checked"> <%}else{ %> <input type="radio"
			class="small" name="NOSOCOMIAL" value="Y"> <%} %>
		</td>
		<td><label class="valueNoWidth">No</label> <%if(dgResultEntryDetailSenList.get(0).getNosocomial().equalsIgnoreCase("n")){ %>
		<input type="radio" class="small" name="NOSOCOMIAL" value="N"
			checked="checked"> <%}else{ %> <input type="radio"
			class="small" name="NOSOCOMIAL" value="N"> <%} %>
		</td>
	</tr>
</table>
</div>
</div>



<br />
<br />
<br />

<input type="hidden" name="resultIdStringForTemplate"
	id="resultIdStringForTemplate" value="<%=resultIdStringForTemplate%>" />





<!-- end -->

<div class="Clear"></div>

<div class="Clear"></div>


<!-- Table Ends --> <!--Bottom labels starts-->
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>

<input type="button" class="button" value="Submit"
	onclick="submitSensitivityData();" align="right" /> <input
	name="Button" type="button" class="button" value="Reset"
	onclick="resetResult();" /></div>
</div>
<!--Bottom labels starts--> <!--main content placeholder ends here-->

</div>
</form>

