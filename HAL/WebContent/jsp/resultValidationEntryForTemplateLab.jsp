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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<%@page import="java.net.URL"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>
<!-- 
Attach the editor on the textareas
-->
<script type="text/javascript">
// Use it to attach the editor to all textareas with full featured setup
//WYSIWYG.attach('all', full);

// Use it to attach the editor directly to a defined textarea

WYSIWYG.attach('abc', full); // full featured setup

// Use it to display an iframes instead of a textareas
//WYSIWYG.display('all', full);  
</script>
<form name="resultValidationEntry" method="post"
	ENCTYPE="multipart/form-data" action=""><script
	type="text/javascript">

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
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	///List<Patient> patientList = new ArrayList<Patient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
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
	int deptId= 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}

	String deptName ="";
	String appendedHtml ="";
	Integer resultEnteredByForTemplate = 0;
	 String resultIdStringForTemplate = "";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(map.get("resultIdStringForTemplate") != null){
		   resultIdStringForTemplate = (String)map.get("resultIdStringForTemplate");
	}

	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	
	if(map.get("appendedHtml") != null){
		
		appendedHtml = (String)map.get("appendedHtml");
	}
	if(map.get("resultEnteredByForTemplate") != null){
		resultEnteredByForTemplate = (Integer)map.get("resultEnteredByForTemplate");
	}
	
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	Map<String,Object> detailsMap = new HashMap<String,Object>();
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	try{
		if(map.get("resultList") != null){
			resultList=(List)map.get("resultList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	Set<DgResultEntryDetail> dgResultDtSet = new HashSet<DgResultEntryDetail>();
	for(DgResultEntryHeader dgResultHeader : resultList){
		dgResultDtSet = dgResultHeader.getDgResultEntryDetails();
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
	 session.setAttribute("dgResultDtSet",dgResultDtSet);
	 
	 Properties properties = new Properties();
	 URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	 try {
	 	properties.load(resourcePath.openStream());
	 	} catch (Exception e) {
	 	e.printStackTrace();
	 }
	 String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
%> <!--main content placeholder starts here-->
<%if(deptId == 49){ %>
<h6>Report Validation</h6>
<%}else{ %>
<h6>Result Validation</h6>
<%} %> <%
	String subDept = "";
String dept="";
int SubChargeId=0;
int mainChargeId=0;
		for(DgResultEntryDetail dgDetail :dgResultDtSet){
			if(dgDetail.getInvestigation() != null){
			subDept = dgDetail.getInvestigation().getSubChargecode().getSubChargecodeName();
			dept = dgDetail.getInvestigation().getMainChargecode().getMainChargecodeName();
			SubChargeId=dgDetail.getInvestigation().getSubChargecode().getId();
			mainChargeId=dgDetail.getInvestigation().getMainChargecode().getId();
%> <%
 	}
 	}%> <input name="<%=SUB_CHARGECODE_ID %>" id="subChargeCodeId"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="mainChargecodeId" type="hidden"
	value="<%=mainChargeId %>" />
<div id="hiddenTextArea" style="display: none"><textarea
	id="appendedHtml" name="appendedHtml"><%=appendedHtml
 %></textarea> <input type="hidden" id="browse" name="browse" value=""></div>
<div class="Clear"></div>


<input type="hidden" name="<%=RESULT_ID %>" id="resultId"
	value="<%=dgresultHeader.getId() %>" /> <!--Block One Starts--> <!--Block Two Starts-->
<div>
<%
if(dgResultEntryHeader.getInpatient() != null){
%> <input type="hidden" name="<%=INPATIENT_ID %>" id="inpatientId"
	value="<%=dgResultEntryHeader.getInpatient().getId()%>" /> <%} else{%> <input
	type="hidden" name="<%=INPATIENT_ID %>" id="inpatientId" value="" /> <%} %>
<input type="hidden" name="<%=DEPARTMENT_ID %>" id="departmentId"
	value="<%=dgResultEntryHeader.getDepartment().getId()%>" /> <input
	type="hidden" name="<%=HIN_ID %>" id="hinId"
	value="<%=dgResultEntryHeader.getPatient().getId() %>" /> <input
	type="hidden" name="<%=HIN_NO %>" id="hinNo"
	value="<%=dgResultEntryHeader.getPatient().getHinNo() %>" /> <input
	type="hidden" name="resultIdStringForTemplate"
	id="resultIdStringForTemplate" value="<%=resultIdStringForTemplate%>" />

</div>

<!--Block Two Ends--> <!-- Block Three Starts --> <%if(dgresultHeader.getEmployee() != null) {%>
<input type="hidden" id="resultEnteredBy" name="<%=RESULT_ENTERED_BY %>"
	value="<%=dgresultHeader.getEmployee().getFirstName() %>" /> <%}else { %>
<input type="hidden" id="resultEnteredBy" name="<%=RESULT_ENTERED_BY %>"
	value="" /> <%} %> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_DATE%>" id="sampleCollectionDate"
	value="<%=date%>" /> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_TIME %>" id="sampleCollectionTime"
	value="<%=time%>" /> <input type="hidden" name="<%=RESULT_NO %>"
	id="resultNo" value="<%=dgResultEntryHeader.getResultNo() %>" /> <input
	id="resultValidatedBy" name="<%= RESULT_VALIDATED_BY %>" type="hidden"
	value="<%=resultEnteredByForTemplate %>"
	validate="Report Validated By,string,yes" tabindex=1 /> </input> <input
	type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <script>
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
<!-- Table Starts -->

<div class="tableHolderAuto">
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">

	<tr>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="7%">Diag. No.</th>
		<%}else{  %>
		<th width="7%">Radio Id.</th>
		<%} %>
		<th width="7%">Investigation</th>
		<th width="4%">Validated</th>

		<% int i =0;
		String diagNo = "";
    for(DgResultEntryDetail dgDetail :dgResultDtSet){
    	diagNo = dgDetail.getSampleCollectionDetails().getDiagNo()!=null?dgDetail.getSampleCollectionDetails().getDiagNo():"";
    	
    i++;
    %>
		<tr>
			<td>
			<%if(dgDetail.getSampleCollectionDetails() != null){ %> <label
				name="<%=DIAGNOSIS_NO %>" id="diagnosisNo" /><%=dgDetail.getSampleCollectionDetails().getDiagNo()%>
			<%} else{%> <label name="<%=DIAGNOSIS_NO %>" id="diagnosisNo" /><%=dgDetail.getSampleCollectionDetails().getDiagNo()%>
			<%} %>
			</td>
			<td width="7%"><input name="resultType" id="resultType"
				type="hidden" size="10" value="<%=dgDetail.getResultType() %>"
				readonly /> <%if(dgDetail.getInvestigation() !=null){ %> <input
				name="<%=INVESTIGATION_ID %>" type="hidden" id="investigationId"
				size="5" value="<%=dgDetail.getInvestigation().getId() %>" readonly />
			<label><%=dgDetail.getInvestigation().getInvestigationName()%></label>
			<%}else { %> <label></label> <%} %>
			</td>
			<td width="4%">
			<% if(dgDetail.getValidated() != null) {
              %> <input id="checkId" name="<%=VALIDATED%>"
				type="checkbox" checked="true" class="check" /> <%}else{ 
             %> <input id="checkId"
				name="<%=VALIDATED%>" type="checkbox" class="check" /> <%} %>
			</td>
		</tr>
</table>
</div>
<div class="Clear"></div>
	<!-- For upload image,pdf,.doc files-->
	<!--  Code By Ritu  -->
	<input type="button" name="upload document" value="View Document" class="buttonBig" onclick="openPopupForUpload()" />
<!-- end -->

<!--Abha--> <label class="noWidth">Report</label>
<div class="Clear"></div>
<div id="rtf">
<!--Rich text editor--> <%if(dgDetail.getResult() != null){ 
	  String templateData= new String  (dgDetail.getResult());
    %> <textarea id="abc" name="test2" class="tableTextareaEditor"><%=templateData %></textarea>
<%}else{ %> <textarea value="" id="abc" name="test2"
	class="tableTextareaEditor">  </textarea> <%} %>

</div>
<div class="Clear"></div>
<label>Additional Remarks </label> <%if(dgDetail.getRemarks() != null){ %>
<textarea value="<%=dgDetail.getRemarks() %>" maxlength="200"
	onkeyup="return ismaxlength(this)" id="additionalRemarks"
	name="<%=ADDITIONAL_REMARKS %>"></textarea> <script>document.resultValidationEntry.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDetail.getRemarks()%>"</script>
<%}else{ %> <textarea value="" maxlength="200"
	onkeyup="return ismaxlength(this)" id="additionalRemarks"
	name="<%=ADDITIONAL_REMARKS %>"></textarea> <%} %>

<div class="Clear"></div>
<%}
    	%> <!-- Table Ends --> <!--Bottom labels starts-->
    	
    	
<div class="Clear"></div>

<input type="button" class="button" value="Submit"
	onclick="if(inputValidate()){formSubmission();};" align="right" /> <input
	name="Button" type="button" class="button" value="Reset"
	onclick="resetResult();" /> 

<div class="Clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
</div>
<div class="Clear"></div>
<script language="javascript">
function formSubmission(){
var resultNo=document.getElementById("resultNo").value;
var resultType=document.getElementById("resultType").value;
var resultId=document.getElementById("resultId").value;
var resultValidatedBy=document.getElementById("resultValidatedBy").value;
var additionalRemarks = document.getElementById("additionalRemarks").value;
var validated = document.getElementById("checkId").value;
var resultIdStringForTemplate = document.getElementById("resultIdStringForTemplate").value;

WYSIWYG.updateTextArea('abc');
submitForm('resultValidationEntry','investigation?method=submitResultValidationForTemplateLab&resultValidatedBy='+resultValidatedBy+'&resultId='+resultId+'&resultType='+resultType+'&resultNo='+resultNo+'&additionalRemarks='+additionalRemarks+'&validated='+validated+'&resultIdStringForTemplate='+resultIdStringForTemplate+'');

}



function openPopupForUpload(){
	var url = '/hms/hms/investigation?method=openPopupForUpload&hinId='+document.getElementById('hinId').value+'&diagNo=<%=diagNo%>&hinNo='+document.getElementById('hinNo').value
	 newwindow = window.open(url,'windowRef','width=1000,height=400,scrollbars = yes');
	
}
</script>
<!--Bottom labels starts--> <!--main content placeholder ends here-->
</form>
