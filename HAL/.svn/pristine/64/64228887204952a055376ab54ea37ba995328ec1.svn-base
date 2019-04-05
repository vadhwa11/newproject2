<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgMasCollection"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgTemplate"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>
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
<style>
#html,body {
	overflow: visible;
}
</style>

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
  function resetResult(){
 
	   document.getElementById('abc').value="";
	   document.getElementById('additionalRemarks').value="";
	   
   }
function see()
{
sampleCollection.method="post";
  
				  var hinNo=document.getElementById("hinNo").value;
				  var inpatientId=document.getElementById("inpatientId").value;
				 var sampleCollectionDetailId = document.getElementById("<%=DG_SAMPLE_DETAIL_ID%>").value;
				 var departmentId=document.getElementById("departmentId").value;
			fName=document.getElementById("upload").value;
				var extension =fName.substring(fName.length-4);
			if(fName !=""){
	if( extension != '.txt' && extension != '.TXT' && extension !='.rtf')
	{	
		//alert("Uploaded Document can only be in .txt or .TXT format\n");
	//return false;
	}
	var updatedtemplate= sampleCollection.test2.value;
 	sampleCollection.browse.value="browse";

	var combinedIds = document.getElementById('CombinedIds').value;
	var RESULT_ENTERED_BY=document.getElementById("<%=RESULT_ENTERED_BY%>").value;
	var SAMPLE_COLLECTION_ID=document.getElementById("<%=SAMPLE_COLLECTION_ID%>").value;
	var RESULT_NO=document.getElementById("<%=RESULT_NO%>").value;
	var DG_SAMPLE_DETAIL_ID=document.getElementById("<%=DG_SAMPLE_DETAIL_ID%>").value;
	

//window.location.href ='investigation?method=getFileName&sampleCollectionDetailId='+sampleCollectionDetailId+'&hinNo='+hinNo+'&inpatientId='+inpatientId+'&parameterName=fromResultEntry&formName=sampleCollection&test2='+updatedtemplate+'';
  //reportPreparedByObj = document.getElementById('<%= RESULT_ENTERED_BY  %>');
  //reportPreparedByObj.setAttribute("validate","Report Prepared By,string,no");
  
submitForm('sampleCollection','investigation?method=getFileNameForLab&resultNoTemplate='+RESULT_NO+'&resultEnteredBy='+RESULT_ENTERED_BY+'&dgSampleDetailIdForTemplate='+DG_SAMPLE_DETAIL_ID+'&&CombinedIds='+combinedIds+'&parameterName=fromResultEntry&formName=sampleCollection&browseInResultEntry=browse&test2='+updatedtemplate+''); 
}
return true;
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
</script>
<%
int pageNo=1;
Map map = new HashMap();
Map detailsMap = new HashMap();
String resultSeqNo = "";
int resultEnteredBy = 0;
Map<String,Object> utilMap = new HashMap<String,Object>();
String CombinedIds = "";
List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
List<Patient> patientList = new ArrayList<Patient>();
List<DgResultEntryDetail> dgResultEntryDetailListForResult = new ArrayList<DgResultEntryDetail>();

utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTimeWithoutSc");
String appendedHtml = "";

List inPatientDetailList = new ArrayList();
Box box = HMSUtil.getBox(request);

String userName = "";
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	
}
if(map.get("appendedHtml")!=null){
	appendedHtml=(String)map.get("appendedHtml");
}
if(map.get("pageNo") != null)
{
pageNo=(Integer)map.get("pageNo");
}
if(map.get("detailsMap") != null)
{
	detailsMap=(Map)map.get("detailsMap");
}

if(detailsMap.get("resultEnteredBy") != null)
{
	resultEnteredBy = (Integer)detailsMap.get("resultEnteredBy");
}
if(detailsMap.get("resultSeqNo") != null)
{
	resultSeqNo = (String)detailsMap.get("resultSeqNo");
}
if(detailsMap.get("CombinedIds") != null)
{
	CombinedIds = (String)detailsMap.get("CombinedIds");
}


if(map.get("pageNo") != null)
{
	detailsMap=(Map)map.get("detailsMap");
}

if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
String message = "";
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("employeeList") != null){
employeeList = (List<MasEmployee>)map.get("employeeList");
}

if(map.get("dgResultEntryDetailListForResult") != null){
	dgResultEntryDetailListForResult = (List)map.get("dgResultEntryDetailListForResult");
}

try{
if(map.get("sampleCollectionList") != null){
sampleCollectionList=(List)map.get("sampleCollectionList");

}
}catch(Exception e){
e.printStackTrace();
}


DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
Patient patient = new Patient();

if(sampleCollectionList != null)
{
	dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
	patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
}
String diagNo = "";
if(map.get("diagNo")!=null){
	diagNo = (String)map.get("diagNo");
}
%>
<script type="text/javascript">
   history.forward();
</script>
<!--main content placeholder starts here-->
<form name="sampleCollection" method="post"	enctype="multipart/form-data" action="">
<div class="Clear"></div>
<%=message%>
<div class="Clear"></div>
<div class="titleBg"><h2>Result Entry</h2></div>
<div class="Block">
<div class="Clear"></div>
<label> Date</label>
<label	class="value"><%=date%></label>
<label>Time</label>
<label class="value"><%=time%></label>
<label>Entered By</label>
<%

Users user = (Users)session.getAttribute("users");
Integer empId =user.getEmployee().getId();

%>
<label class="value"><%=user.getEmployee().getFirstName()%></label>

</div>
<%
String subDept = "";
String dept="";
int SubChargeId=0;
int mainChargeId=0;
String hinNo="";
for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
	if(dgCollection.getInvestigation().getChargeCode().getSubChargecode()!= null){
		subDept = dgCollection.getInvestigation().getChargeCode().getSubChargecode().getSubChargecodeName();
		dept = dgCollection.getInvestigation().getMainChargecode().getMainChargecodeName();
		SubChargeId=dgCollection.getInvestigation().getChargeCode().getSubChargecode().getId();
		mainChargeId=dgCollection.getInvestigation().getChargeCode().getSubChargecode().getMainChargecode().getId();
		hinNo = dgCollection.getSampleCollectionHeader().getHin().getHinNo();
%> <%
	}
}%> 
<input name="<%= DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID %>"	type="hidden" value="<%=(Integer)session.getAttribute("deptId")%>" /> 
<input	name="<%= SAMPLE_COLLECTION_DETAIL_ID %>"	id="<%= SAMPLE_COLLECTION_DETAIL_ID %>" type="hidden"	value="<%=box.getInt( SAMPLE_COLLECTION_DETAIL_ID) %>" /> 
<input	name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"	type="hidden" value="<%=SubChargeId %>" /> 
<input	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"	type="hidden" value="<%=mainChargeId %>" /> 
<input type="hidden"	id="browse" name="browse" value="">
<div class="Clear"></div>

<input type="hidden" name="<%=SAMPLE_COLLECTION_ID %>"	id="<%= SAMPLE_COLLECTION_ID%>"	value="<%=dgDetails.getSampleCollectionHeader().getId() %>" /> 
<input	type="hidden" name="<%=TEST_ORDER_NO_TEMPLATE_VALUE%>"	id="<%= TEST_ORDER_NO_TEMPLATE_VALUE%>"	value="<%=dgDetails.getInvestigation().getTestOrderNo()!=null?dgDetails.getInvestigation().getTestOrderNo():""%>" /> 


<input type="hidden" name="<%=DEPARTMENT_ID %>"	id="<%=DEPARTMENT_ID %>"	value="<%=dgDetails.getSampleCollectionHeader().getDepartment().getId() %>" />
<input type="hidden" name="<%=HIN_ID %>" id="<%=HIN_ID %>"	value="<%=patient.getId() %>" /> 
<input type="hidden"	name="<%=HIN_NO %>" id="<%=HIN_NO %>" value="<%=patient.getHinNo() %>" />
<input	type="hidden" name="<%=INPATIENT_ID %>" id="<%=INPATIENT_ID %>"	value="<%=(dgDetails.getSampleCollectionHeader().getInpatient() != null?dgDetails.getSampleCollectionHeader().getInpatient().getId():0)%>" />
<input	type="hidden" name="<%=VISIT_ID %>" id="<%=VISIT_ID %>"	value="<%=(dgDetails.getSampleCollectionHeader().getVisit() != null?dgDetails.getSampleCollectionHeader().getVisit().getId():0)%>" />

<input type="hidden" name="<%=SAMPLE_COLLECTION_DATE%>"	id="<%=SAMPLE_COLLECTION_DATE %>" value="<%=date%>" /> 
<input	type="hidden" name="<%=SAMPLE_COLLECTION_TIME %>"	id="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" /> 
<input	type="hidden" name="<%=RESULT_NO %>" id="<%=RESULT_NO %>"	value="<%=resultSeqNo %>" /> 
<input type="hidden" name="<%= RESULT_ENTERED_BY %>" id="<%= RESULT_ENTERED_BY %>"	value="<%=resultEnteredBy%>" />
<input type="hidden" name="uploadDocumentId" id="uploadDocumentId" value="0" />
<div class="Clear"></div>

<input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"	value="<%=dgDetails.getSampleCollectionHeader().getValidatedBy() != null?dgDetails.getSampleCollectionHeader().getValidatedBy().getId():0 %>" />
<div class="Clear"></div>

<div class="Clear"></div>
<input type="hidden" value="0" name="pagecounter2" /> 
<input	type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /> 
<input	type="hidden" name="CombinedIds" id="CombinedIds"	value="<%=CombinedIds%>" />
<div class="Clear"></div>
<%

Set<DgMasInvestigation> masSet= new HashSet<DgMasInvestigation>();
Set<DgTemplate> templateSet= new HashSet<DgTemplate>();
DgMasInvestigation masInv = new DgMasInvestigation();
String normalValue="";
String charge="";
int chargeId=0;
int investigationId=0;
String resultType="";
String result=null;
int i =0;
for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
	masInv = dgCollection.getInvestigation();
	templateSet = masInv.getDgTemplates();

	if(dgCollection.getInvestigation().getChargeCode()!= null)
	{
		charge=dgCollection.getInvestigation().getChargeCode().getChargeCodeName();
		chargeId=dgCollection.getInvestigation().getChargeCode().getId();
		investigationId =dgCollection.getInvestigation().getId();
		resultType = dgCollection.getInvestigation().getInvestigationType();
	}
 	i++;

%> <input name="<%=RESULT_TYPE %>" id="<%=RESULT_TYPE %>" value="t"
	type="hidden"> <input name="<%=INVESTIGATION_ID %>"
	id="<%=INVESTIGATION_ID %>" value=<%= investigationId%> type="hidden">
<input name="<%=CHARGE_CODE_ID %>" id="<%=CHARGE_CODE_ID %>"
	value=<%= chargeId%> type="hidden"> 
	
<input name="<%=DG_SAMPLE_DETAIL_ID %>" id="<%=DG_SAMPLE_DETAIL_ID %>"
	value=<%= dgCollection.getId()%> type="hidden"> <!--Abha-->
<div class="Block">
 <label
	class="noWidth">Result1</label> <input type="file" id="upload"
	name="<%=UPLOAD_FILENAME%>" class="Browse" size="50"  />
	
	
	<!-- For upload image,pdf,.doc files-->
	<!--  Code By Ritu  -->
	<input type="button" name="upload document" value="Upload/ View Document" class="buttonBig" onclick="openPopupForUpload()" />
<!-- end -->

<div class="clear"></div>
</div>	
<h3 style="margin: 10px 0px 10px 0px;"><a
	href="lab?method=showTemplateHelpJsp" title="Help For Template Upload"
	style="font-size: 16px;">Help</a></h3>
<div id="hiddenTextArea" style="display: none"><textarea
	id="appendedHtml" name="appendedHtml"><%=appendedHtml
 %></textarea></div>
<div id="rtf">
<%if(dgResultEntryDetailListForResult.size() > 0){ %> <%if(session.getAttribute("browseInResultEntry")!=null){ 
  session.removeAttribute("browseInResultEntry"); %> <textarea value=""
	id="abc" name="test2" class="tableTextareaEditor">
	<%-- <%@include	file="/temp/temp.html"%>--%>  </textarea> <%}else if(dgResultEntryDetailListForResult.get(0).getResult() != null){
  String templateData= dgResultEntryDetailListForResult.get(0).getResult();
%> <textarea id="abc" name="test2" class="tableTextareaEditor"><%=templateData %></textarea>

<%}else{
  %> <textarea value="" id="abc" name="test2"
	class="tableTextareaEditor">
<%--	<%@include file="/temp/temp.html"%> --%>  </textarea> <%} %> <% }else if(templateSet.size()>0){ 
  for(DgTemplate dgTemp : templateSet){
	result = dgTemp.getResult();
	
 %> <%if(session.getAttribute("browseInResultEntry")!=null){ 
  session.removeAttribute("browseInResultEntry"); %> <textarea value=""
	id="abc" name="test2" class="tableTextareaEditor">
	<%--	<%@include file="/temp/temp.html"%> --%>  </textarea> <%}else if(dgTemp.getResult() != null){
  String templateData= new String  (dgTemp.getResult());
%> <textarea id="abc" name="test2" class="tableTextareaEditor"><%=templateData %></textarea>

<%}else{ 
  %> <textarea value="" id="abc" name="test2"
	class="tableTextareaEditor">
	<%--	<%@include file="/temp/temp.html"%> --%>  </textarea> <%} %> <%} 
}else {%> <%if(session.getAttribute("browseInResultEntry")!=null){ 
  session.removeAttribute("browseInResultEntry");
  }
  %> <textarea value="" id="abc" name="test2"
	class="tableTextareaEditor">
<%--	<%@include file="/temp/temp.html"%> --%>   </textarea> <% }%> 
<div class="Clear"></div>	
</div>	
<div class="Clear"></div>
<input type="button" id="clearButton" name="clearButton" class="cmnButton"	value="Clear Template" onclick="clearTemplateData();" /> 



<div class="Clear"></div>
<div style="display: none;">
<label>Put up for validation:</label> <input
	type="checkbox" name="reportEnteredFinally" id="reportEnteredFinally" checked="checked"
	value="y" class="checkbox" tabindex="1" />
</div>


<div class="Clear"></div>
<label>Additional Remarks</label> 
<textarea id="<%=ADDITIONAL_REMARKS%>"	onkeyup="chkLength(this,100);" name="<%=ADDITIONAL_REMARKS %>"><%=dgCollection.getRemarks()==null?"":dgCollection.getRemarks()%></textarea>
 <%} %> <script type="text/javascript">

</script> <!-- 
<label class="noWidth">Film Size Used</label>
		<select   name="filmSizeUsed"id="filmSizeUsed" validate="Film Size Used,string,no" tabindex=1>
		<option value="None">Select</option>
		<option value="17X14">17"*14"</option>
		<option value="15X12">15"*12"</option>
		<option value="12X10">12"*10"</option>
		<option value="10X8">10"*8"</option>
		
		</select>
				
<label class="noWidth">Film Used</label>
		<select id="filmUsed" name="filmUsed" id="filmUsed"validate="Film Used,string,no" tabindex=1>
			<option value="">Select</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
		</select>		 -->
<div class="Clear"></div>
<!-- Table Ends --> <!--Bottom labels starts-->

<div class="Clear"></div>

<input type="button" class="cmnButton" value="Submit" id="addbutton"
	onclick="formSubmission();" align="right" /> <input name="Reset"
	type="button" id="reset" class="cmnButton" value="Reset"
	onclick="resetResult();" /> <input name="Button" type="button"
	class="cmnButton" value="Back" onclick="history.back();" />
<!--Bottom labels starts--> <script language="Javascript">
function formSubmission(){

	var filmSizeUsed='';
	//var filmSizeUsed=document.getElementById("filmSizeUsed").value;
	var filmUsed='';
	//var filmUsed=document.getElementById("filmUsed").value;
	//var REMARKS=document.getElementById("remarks").value;
	var MAIN_CHARGECODE_ID=document.getElementById("<%=MAIN_CHARGECODE_ID%>").value;
	var DEPARTMENT_ID=document.getElementById("<%=DEPARTMENT_ID%>").value;
	var SUB_CHARGECODE_ID=document.getElementById("<%=SUB_CHARGECODE_ID%>").value;
	var HIN_ID=document.getElementById("<%=HIN_ID%>").value;
	var INPATIENT_ID=document.getElementById("<%=INPATIENT_ID%>").value;
	var SAMPLE_COLLECTION_ID=document.getElementById("<%=SAMPLE_COLLECTION_ID%>").value;
	var TEST_ORDER_NO_TEMPLATE_VALUE=document.getElementById("<%=TEST_ORDER_NO_TEMPLATE_VALUE%>").value;
	
	var EMPLOYEE_ID=document.getElementById("<%=EMPLOYEE_ID%>").value;
	var RESULT_TYPE=document.getElementById("<%=RESULT_TYPE%>").value;
	var test2=document.getElementById("abc").value;
	var ADDITIONAL_REMARKS=document.getElementById("<%=ADDITIONAL_REMARKS%>").value;
	var INVESTIGATION_ID=document.getElementById("<%=INVESTIGATION_ID%>").value;
	var combinedIds = document.getElementById('CombinedIds').value;
	var RESULT_ENTERED_BY=document.getElementById("<%=RESULT_ENTERED_BY%>").value;var SAMPLE_COLLECTION_ID=document.getElementById("<%=SAMPLE_COLLECTION_ID%>").value;
	var RESULT_NO=document.getElementById("<%=RESULT_NO%>").value;
	var DG_SAMPLE_DETAIL_ID=document.getElementById("<%=DG_SAMPLE_DETAIL_ID%>").value;
		
	var reportEnteredFinally = document.getElementById("reportEnteredFinally").checked;
	var uploadDocumentId = document.getElementById('uploadDocumentId').value;
	WYSIWYG.updateTextArea('abc');
	//var templateData =document.getElementById("abc").value;
	//if(reportEnteredFinally == true){
	//	if(confirm("Are you sure.\nYou want to submit report for validation.")){
		//		submitForm("sampleCollection","investigation?method=submitResultEntryForTempelate&dgSampleDetailId="+DG_SAMPLE_DETAIL_ID+"&resultNo="+RESULT_NO+"&filmSizeUsed="+filmSizeUsed+"&filmUsed="+filmUsed+"&mainChargecodeId="+MAIN_CHARGECODE_ID+"&departmentId="+DEPARTMENT_ID+"&subChargeCodeId="+SUB_CHARGECODE_ID+"&hinId="+HIN_ID+"&inpatientId="+INPATIENT_ID+"&sampleCollectionId="+SAMPLE_COLLECTION_ID+"&employeeId="+EMPLOYEE_ID+"&resultEnteredBy="+RESULT_ENTERED_BY+"&resultType="+RESULT_TYPE+"&additionalRemarks="+ADDITIONAL_REMARKS+"&investigationId="+INVESTIGATION_ID+"");	
	//	}else{
	//		return false;
	//	}	
	//}else{progress
	if(reportEnteredFinally == true){
	//	if(confirm("Are you sure.\nYou want to submit report for validation.")){
			submitForm("sampleCollection","investigation?method=submitResultEntryForTempelateLab&dgSampleDetailId="+DG_SAMPLE_DETAIL_ID+"&resultNo="+RESULT_NO+"&filmSizeUsed="+filmSizeUsed+"&filmUsed="+filmUsed+"&mainChargecodeId="+MAIN_CHARGECODE_ID+"&departmentId="+DEPARTMENT_ID+"&subChargeCodeId="+SUB_CHARGECODE_ID+"&hinId="+HIN_ID+"&inpatientId="+INPATIENT_ID+"&sampleCollectionId="+SAMPLE_COLLECTION_ID+"&employeeId="+EMPLOYEE_ID+"&resultEnteredBy="+RESULT_ENTERED_BY+"&resultType="+RESULT_TYPE+"&additionalRemarks="+ADDITIONAL_REMARKS+"&investigationId="+INVESTIGATION_ID+"&reportEnteredFinally="+reportEnteredFinally+"&combinedIds="+combinedIds+"&testOrderNoForTemplate="+TEST_ORDER_NO_TEMPLATE_VALUE+"&uploadDocumentId="+uploadDocumentId);	
			//window.opener.document.getElementById('templateButtonDiv').style.display='none';  	  
			//window.opener.document.getElementById('resultEntryMessageDiv').style.display='block';
			//window.opener.document.getElementById('resultEntryMessageDiv').innerHTML='<label style="font-weight: bold;color: red;">Result Entered Successfully</label>';
	//	}else{
	//		return false;
	//	}	
	}else{
			submitForm("sampleCollection","investigation?method=submitResultEntryForTempelateLab&dgSampleDetailId="+DG_SAMPLE_DETAIL_ID+"&resultNo="+RESULT_NO+"&filmSizeUsed="+filmSizeUsed+"&filmUsed="+filmUsed+"&mainChargecodeId="+MAIN_CHARGECODE_ID+"&departmentId="+DEPARTMENT_ID+"&subChargeCodeId="+SUB_CHARGECODE_ID+"&hinId="+HIN_ID+"&inpatientId="+INPATIENT_ID+"&sampleCollectionId="+SAMPLE_COLLECTION_ID+"&employeeId="+EMPLOYEE_ID+"&resultEnteredBy="+RESULT_ENTERED_BY+"&resultType="+RESULT_TYPE+"&additionalRemarks="+ADDITIONAL_REMARKS+"&investigationId="+INVESTIGATION_ID+"&reportEnteredFinally="+reportEnteredFinally+"&combinedIds="+combinedIds+"&testOrderNoForTemplate="+TEST_ORDER_NO_TEMPLATE_VALUE+"");
		//window.opener.document.getElementById('templateButtonDiv').style.display='block';  	  
		//window.opener.document.getElementById('resultEntryMessageDiv').style.display='block';
		//window.opener.document.getElementById('resultEntryMessageDiv').innerHTML='<label style="font-weight: bold;color: red;"></label>';
	}
	
	//submitForm("sampleCollection","investigation?method=submitResultEntryForTempelateLab&dgSampleDetailId="+DG_SAMPLE_DETAIL_ID+"&resultNo="+RESULT_NO+"&filmSizeUsed="+filmSizeUsed+"&filmUsed="+filmUsed+"&mainChargecodeId="+MAIN_CHARGECODE_ID+"&departmentId="+DEPARTMENT_ID+"&subChargeCodeId="+SUB_CHARGECODE_ID+"&hinId="+HIN_ID+"&inpatientId="+INPATIENT_ID+"&sampleCollectionId="+SAMPLE_COLLECTION_ID+"&employeeId="+EMPLOYEE_ID+"&resultEnteredBy="+RESULT_ENTERED_BY+"&resultType="+RESULT_TYPE+"&additionalRemarks="+ADDITIONAL_REMARKS+"&investigationId="+INVESTIGATION_ID+"");
	
	
	//window.opener.location.href = '/hms/hms/investigation?method=searchPatientForLab&sampleCollectionDetailId='+combinedIds;
//	self.close();
	
	
//}
}

	function getTemplateEditor(n) {
		return $("wysiwyg" + n);
	}

function clearTemplateData(){
	document.getElementById('abc').value = '';
	getTemplateEditor('abc').contentWindow.document.body.innerHTML ='';
}
function openHelpPage(){
 window.location.href='lab?method=showTemplateHelpJsp';
}
function closePopUp(){
	self.close();
}


function openPopupForUpload(){
	var url = '/hms/hms/investigation?method=openPopupForUpload&hinId='+document.getElementById('hinId').value+'&diagNo=<%=diagNo%>&hinNo='+document.getElementById('hinNo').value
	 newwindow = window.open(url,'windowRef','width=1000,height=400,scrollbars = yes');
	
}
</script></form>
<!--main content placeholder ends here-->