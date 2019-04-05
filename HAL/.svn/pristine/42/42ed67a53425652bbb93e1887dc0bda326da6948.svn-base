<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Users"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgTemplate"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
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
  
				// alert(updatedtemplate);
				  var hinNo=document.getElementById("hinNo").value;
				  var inpatientId=document.getElementById("inpatientId").value;
				 var sampleCollectionDetailId= document.getElementById("sampleCollectionDetailId").value;
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

//window.location.href ='investigation?method=getFileName&sampleCollectionDetailId='+sampleCollectionDetailId+'&hinNo='+hinNo+'&inpatientId='+inpatientId+'&parameterName=fromResultEntry&formName=sampleCollection&test2='+updatedtemplate+'';
  reportPreparedByObj = document.getElementById('<%= RESULT_ENTERED_BY  %>');
  reportPreparedByObj.setAttribute("validate","Report Prepared By,string,no");
submitForm('sampleCollection','investigation?method=getFileName&sampleCollectionDetailId='+sampleCollectionDetailId+'&hinNo='+hinNo+'&inpatientId='+inpatientId+'&parameterName=fromResultEntry&formName=sampleCollection&browseInResultEntry=browse&test2='+updatedtemplate+''); 
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
Map<String,Object> utilMap = new HashMap<String,Object>();

List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
List<Patient> patientList = new ArrayList<Patient>();
List<DgResultEntryDetail> dgResultEntryDetailListForResult = new ArrayList<DgResultEntryDetail>();

utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String appendedHtml = "";
System.out.println("appendede html in jsp"+appendedHtml);

List inPatientDetailList = new ArrayList();
Box box = HMSUtil.getBox(request);

String userName = "";
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	
}
if(map.get("appendedHtml")!=null){
	appendedHtml=(String)map.get("appendedHtml");
	//System.out.println("appendede html in jsp"+appendedHtml);
}
if(map.get("pageNo") != null)
{
pageNo=(Integer)map.get("pageNo");
}
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
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
if(map.get("dgResultEntryDetailListForResult") != null){
	dgResultEntryDetailListForResult = (List)map.get("dgResultEntryDetailListForResult");
}

Map detailsMap = new HashMap();
if(map.get("detailsMap") !=null){
detailsMap=(Map<String, Object>)map.get("detailsMap");
}

String deptName="";
if(session.getAttribute("deptName") != null){
	deptName = (String)session.getAttribute("deptName");
}
int deptId =0;
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}
String deptType="";
if(session.getAttribute("deptType") != null){
	deptType = (String)session.getAttribute("deptType");
}

try{
if(map.get("sampleCollectionList") != null){
sampleCollectionList=(List)map.get("sampleCollectionList");

}
}catch(Exception e){
e.printStackTrace();
}


int hospitalId = 0;
MasRelation masRelation = new MasRelation();
DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
Patient patient = new Patient();
MasRank masRank = new MasRank();
String admissionNumber = "";
int departmentId =0;
int inpatientId =0;
int hinId = 0;
Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
if(sampleCollectionList != null)
{
dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
inpatientSet=patient.getInpatients();
masRank = (MasRank) patient.getRank();

}
MasDepartment masDepartment=new MasDepartment();
Patient pat = new Patient();
DgSampleCollectionDetails dgsampleDetails=new DgSampleCollectionDetails();

if(sampleCollectionList != null){
dgsampleDetails = (DgSampleCollectionDetails) sampleCollectionList.get(0);

}
Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
try {
	properties.load(resourcePath.openStream());
	} catch (Exception e) {
	e.printStackTrace();
}
String empCategoryCodeForParaMedical = properties.getProperty("empCategoryCodeForParaMedical");
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
%>
<script type="text/javascript">
   history.forward();
</script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="sampleCollection" method="post"
	enctype="multipart/form-data" action="">
<%if(deptId == 49){ %>
<h6>Report Entry</h6>
<%}else{ %>
<h6>Result Entry</h6>
<%} %> <%
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
}%> <label class="common">Department</label> <label
	name="<%=MAIN_CHARGECODE_NAME %>" class="valueNoWidth"><%=deptName%>
</label> <input name="<%= DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID %>"
	type="hidden" value="<%=(Integer)session.getAttribute("deptId")%>" /> <input
	name="<%= SAMPLE_COLLECTION_DETAIL_ID %>"
	id="<%= SAMPLE_COLLECTION_DETAIL_ID %>" type="hidden"
	value="<%=box.getInt( SAMPLE_COLLECTION_DETAIL_ID) %>" /> <label
	class="common">Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="valueNoWidth"><%=subDept%></label>
<input name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" /> <input type="hidden"
	id="browse" name="browse" value="">
<div class="Clear"></div>
<div class="header">
<div class="paddLeft25"><label class="noWidth">Order Date</label></div>
<%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="noWidth">Order
Time</label> <%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%= dgDetails.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%}%> <label class="noWidth">Order
No.</label> <%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%= dgDetails.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="noWidth">Order
By</label> <%if(dgDetails.getSampleCollectionHeader().getOrder().getDepartment() != null){ %>
<label class="value"><%=dgDetails.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
</div>
<div class="Clear"></div>
<input type="hidden" name="<%=SAMPLE_COLLECTION_ID %>"
	id="<%= SAMPLE_COLLECTION_ID%>"
	value="<%=dgDetails.getSampleCollectionHeader().getId() %>" /> <!--Block One Starts-->
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service Type</label> <%
if(patient.getServiceType() != null){
%> <label class="valuemedium"><%= patient.getServiceType().getServiceTypeName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Service No</label> <%
if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
%> <label class="valuemedium"><%= patient.getServiceNo()%></label> <%}else{ %>
<label class="valuemedium">-</label> <%}%> <label class="medium">Service
Status</label> <%if(patient.getServiceStatus() != null){
%> <label class="valuemedium"><%= patient.getServiceStatus().getServiceStatusName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Relation</label> <%
if(patient.getRelation() != null){
%> <label class="valuemedium"><%= patient.getRelation().getRelationName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%>
<div class="Clear"></div>
<label>Ser. Per. Name</label> <%
if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

String sMiddleName = "";
String sLastName = "";
if(patient.getSMiddleName() != null){
sMiddleName = patient.getSMiddleName();
}
if(patient.getSLastName() != null){
sLastName = patient.getSLastName();
}
%> <label class="valueNoWidth"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> <label class="valueNoWidth">-</label> <% }%> <label
	class="medium">Rank</label> <%
if(patient.getRank() != null){
%> <label class="valueNoWidth"><%= patient.getRank().getRankName()%></label>
<%} else{ %> <label class="valueNoWidth">-</label> <% }%> <label
	class="medium">Unit</label> <%
if(patient.getUnit() != null){
%> <label class="valuemedium"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> <label class="valuemedium">-</label> <% }%> <label>Trade</label>
<%
if(patient.getTrade() != null){
%> <label class="valuemedium"><%= patient.getTrade().getTradeName()%></label>
<%} else{ %> <label class="valuemedium">-</label> <% }%>
<div class="Clear"></div>

</div>
<!--Block one Ends--> <!--Block Two Starts-->
<div class="Clear"></div>
<div style="width: 0px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<div onClick="togPlus('visit-details-box1',expand_bca1);"
	class="collapsetag" style="float: left;"><IMG id=expand_bca1
	alt=Expand src="/hms/jsp/images/plus1.gif" ; align=left /> <font
	class="boxtitle">Patient Details </font></div>


</div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />
<div class="Clear"></div>
<div class=box-content id=visit-details-box1 style="display: none;">
<div class=clearfix>

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 30px; background-color: #f4f9fe;">
<div style="height: auto; width: auto;"><label class="NoWidth"
	style="padding-left: 10px;">HIN No.</label> <label class="value"><%=patient.getHinNo() %></label>

<%
String middleName = "";
String lastName = "";
if(patient.getPMiddleName() != null){
middleName = patient.getPMiddleName();
}
if(patient.getPLastName() != null){
lastName = patient.getPLastName();
}

%> <label class="NoWidth">Patient Name</label> <label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>

<label class="NoWidth">Sex</label> <label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>

<%
String age = "";
String currentAge = "";
age = patient.getAge();
currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
%> <label class="NoWidth">Age</label> <label class="value"><%=currentAge%></label>




<div class="Clear"></div>

<div><input type="hidden" name="<%=DEPARTMENT_ID %>"
	id="<%=DEPARTMENT_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getDepartment().getId() %>" />
<input type="hidden" name="<%=HIN_ID %>" id="<%=HIN_ID %>"
	value="<%=patient.getId() %>" /> <input type="hidden"
	name="<%=HIN_NO %>" id="<%=HIN_NO %>" value="<%=patient.getHinNo() %>" />
</div>
<%if(dgDetails.getSampleCollectionHeader().getInpatient() != null){ %> <input
	type="hidden" name="<%=INPATIENT_ID %>" id="<%=INPATIENT_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getInpatient().getId()%>" />
<%}else{ %> <input type="hidden" name="<%=INPATIENT_ID %>"
	id="<%=INPATIENT_ID %>" value="" /> <%} %>
</div>
</div>
</div>
</div>


<!--Block Two Ends--> <!-- Block Three Starts -->
<div class="Clear"></div>
<div class="Clear"></div>
<div class="blockTitle">Report Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="noWidth">&nbsp;&nbsp;Report Date</label> <label
	class="valueNoWidth"><%=date%></label> <label class="noWidth">Report
Time</label> <label class="valueNoWidth"><%=time%></label> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_DATE%>" id="<%=SAMPLE_COLLECTION_DATE %>"
	value="<%=date%>" /> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_TIME %>" id="<%=SAMPLE_COLLECTION_TIME %>"
	value="<%=time%>" /> <%
String resultSeqNo="";
if(map.get("resultSeqNo") != null){
resultSeqNo = (String)map.get("resultSeqNo");
}
%> <input type=hidden name="<%=RESULT_NO %>" id="<%=RESULT_NO %>"
	value="<%=resultSeqNo %>" /> <label><span>*</span>Report
Prepared By</label> <select name="<%= RESULT_ENTERED_BY  %>"
	id="<%= RESULT_ENTERED_BY  %>" validate="Report Prepared By,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					if((masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForParaMedical)) || (masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)) ){
						System.out.println("user Id :"+userId);
						System.out.println("emp Id e:"+masEmployeecode.getId());
						if (userId.equals(masEmployeecode.getId())) {
							
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{%>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}}	}}	%>
</select> <script type="text/javascript">
		<% if(dgResultEntryDetailListForResult.size() > 0){ 
			DgResultEntryDetail dgResultEntryDetail = dgResultEntryDetailListForResult.get(0);
			int preparedById = dgResultEntryDetail.getResultEntry().getEmployee().getId();
		%>
			document.getElementById("<%= RESULT_ENTERED_BY  %>").value='<%=preparedById%>';
		<% } %>
		
	</script>
<div class="Clear"></div>
<%if(deptType.equalsIgnoreCase("DIAG")){ %> <label class="noWidth">Sample
Validated Date</label> <%}else{ %> <label class="noWidth">Report
Collection Date</label> <%}%> <%if(dgDetails.getSampleCollectionHeader().getSampleValidationDate() != null){ %>
<label class="valueNoWidth"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getSampleValidationDate()) %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label class="noWidth">Sample Validated Time</label> <%}else{ %> <label
	class="noWidth">Report Collection Time</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getSampleValidationTime() != null){ %>
<label class="valueNoWidth"><%=dgDetails.getSampleCollectionHeader().getSampleValidationTime() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label class="noWidth">Sample Validated By</label> <%}else{ %> <label
	class="noWidth">Report Collected By</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getValidatedBy() != null) {
%> <input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getValidatedBy().getId() %>" />
<label class="value"> <%=dgDetails.getSampleCollectionHeader().getValidatedBy().getFirstName()+" "+ dgDetails.getSampleCollectionHeader().getValidatedBy().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=EMPLOYEE_ID %>"
	name="<%=EMPLOYEE_ID %>" value="" /> <label class="value">-</label> <%} %>
<div class="Clear"></div>
<label class="common">Brief Clinical Notes</label> <%if(dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueNoWidth"><%=dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>

<div class="Clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<!-- Block Three Ends -->
<div class="Clear"></div>
<!-- Table Starts -->

<div class="tableHolderAuto">
<table border="0" cellspacing="0" width="100%" cellpadding="0">

	<tr>
		<th width=7%>Sr No.</th>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">Diag.No.</th>
		<%}else{ %>
		<th scope="col">Radio Id.</th>
		<%} %>
		<th scope="col">Service</th>

		<%

Set<DgMasInvestigation> masSet= new HashSet<DgMasInvestigation>();
Set<DgTemplate> templateSet= new HashSet<DgTemplate>();
DgMasInvestigation masInv = new DgMasInvestigation();
String normalValue="";
String charge="";
int chargeId=0;
int investigationId=0;
String resultType="";
byte result[]=null;
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

%>

		<tr>

			<td><label style="margin-left: 50%" name="<%=SR_NO%>"><%=i%></label></td>

			<td>
			<%if(dgCollection.getDiagNo() != null){	%> <label
				style="margin-left: 41%" name=<%=DIAGNOSIS_NO %>
				id=<%=DIAGNOSIS_NO %>><%=dgCollection.getDiagNo()%></label> <%}else{ %>
			<label style="margin-left: 41%" name=<%=DIAGNOSIS_NO %>
				id=<%=DIAGNOSIS_NO %>>-</label> <%} %>
			</td>

			<td><input name="<%=RESULT_TYPE %>" id="<%=RESULT_TYPE %>"
				value="t" type="hidden"> <input
				name="<%=INVESTIGATION_ID %>" id="<%=INVESTIGATION_ID %>"
				value=<%= investigationId%> type="hidden"> <input
				name="<%=CHARGE_CODE_ID %>" id="<%=CHARGE_CODE_ID %>"
				value=<%= chargeId%> type="hidden"> <%System.out.println("DG_SAMPLE_DETAIL_ID"+dgCollection.getId()); %>
			<input name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %>" value=<%= dgCollection.getId()%>
				type="hidden"> <%if(dgCollection.getInvestigation().getInvestigationName() !=null){%>
			<label style="margin-left: 41%" name="<%=INVESTIGATION_NAME %>" /><%=dgCollection.getInvestigation().getInvestigationName() %></label>
			<%}else { %> <label style="margin-left: 41%"
				name="<%=INVESTIGATION_NAME %>" /></label> <%} %>
			</td>
		</tr>
</table>
</div>

<!--Abha--> <label class="noWidth">Result</label> <input type="file"
	id="upload" name="<%=UPLOAD_FILENAME%>" class="Browse" size="50"
	onchange="see()" />

<h3><a href="#" onclick="submitFormForButton('sampleCollection','/hms/hms/lab?method=showTemplateHelpJsp')"
	title="Help For Template Upload">Help</a></h3>
<div id="hiddenTextArea" style="display: none"><textarea
	id="appendedHtml" name="appendedHtml"><%=appendedHtml
 %></textarea></div>
<%System.out.println("template Set Size :" +templateSet.size()); %> <%System.out.println("Result Entry  Size :" +dgResultEntryDetailListForResult.size()); %>

<%if(dgResultEntryDetailListForResult.size() > 0){ %> <%if(session.getAttribute("browseInResultEntry")!=null){ 
  session.removeAttribute("browseInResultEntry"); %> <textarea value=""
	id="abc" name="test2" class="tableTextareaEditor"><%@include
	file="/temp/temp.html"%>  </textarea> <%}else if(dgResultEntryDetailListForResult.get(0).getResult() != null){
  String templateData= new String  (dgResultEntryDetailListForResult.get(0).getResult());
System.out.println("in result");
%> <textarea id="abc" name="test2" class="tableTextareaEditor"><%=templateData %></textarea>

<%}else{ System.out.println("in else if");
  %> <textarea value="" id="abc" name="test2"
	class="tableTextareaEditor"><%@include
	file="/temp/temp.html"%>  </textarea> <%} %> <% }else if(templateSet.size()>0){ 
  for(DgTemplate dgTemp : templateSet){
	result = dgTemp.getResult();
	
 %> <%if(session.getAttribute("browseInResultEntry")!=null){ 
  session.removeAttribute("browseInResultEntry"); %> <textarea value=""
	id="abc" name="test2" class="tableTextareaEditor"><%@include
	file="/temp/temp.html"%>  </textarea> <%}else if(dgTemp.getResult() != null){
  String templateData= new String  (dgTemp.getResult());
System.out.println("in result");
%> <textarea id="abc" name="test2" class="tableTextareaEditor"><%=templateData %></textarea>

<%}else{ System.out.println("in else if");
  %> <textarea value="" id="abc" name="test2"
	class="tableTextareaEditor"><%@include
	file="/temp/temp.html"%>  </textarea> <%} %> <%} 
}else {%> <textarea value="" id="abc" name="test2"
	class="tableTextareaEditor"><%@include
	file="/temp/temp.html"%>  </textarea> <% }%> <input
	type="button" id="clearButton" name="clearButton" class="cmnButton"
	value="Clear Template" onclick="clearTemplateData();"> </input>

<div class="Clear"></div>

<label class="common">Put up for validation:</label> <input
	type="checkbox" name="reportEnteredFinally" id="reportEnteredFinally"
	value="y" class="checkbox" tabindex="1" />


<div class="Clear"></div>
<label class="common">Additional Remarks</label> <%if(dgResultEntryDetailListForResult.size() > 0){ %>
<%if(dgResultEntryDetailListForResult.get(0).getRemarks() != null){ %> <textarea
	id="<%=ADDITIONAL_REMARKS%>"
	value="<%=dgResultEntryDetailListForResult.get(0).getRemarks()==null?"":dgResultEntryDetailListForResult.get(0).getRemarks()%>"
	onkeyup="chkLength(this,100);" name="<%=ADDITIONAL_REMARKS %>"></textarea>
<script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgResultEntryDetailListForResult.get(0).getRemarks()%>"</script>
<%}else{ %> <textarea value="" onkeyup="chkLength(this,100);"
	id="<%=ADDITIONAL_REMARKS %>" name="<%=ADDITIONAL_REMARKS %>"></textarea>
<%} %> <% }else{ %> <%if(dgCollection.getRemarks() != null){ %> <textarea
	id="<%=ADDITIONAL_REMARKS%>"
	value="<%=dgCollection.getRemarks()==null?"":dgCollection.getRemarks()%>"
	onkeyup="chkLength(this,100);" name="<%=ADDITIONAL_REMARKS %>"></textarea>
<script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgCollection.getRemarks()%>"</script>
<%}else{ %> <textarea value="" onkeyup="chkLength(this,100);"
	id="<%=ADDITIONAL_REMARKS %>" name="<%=ADDITIONAL_REMARKS %>"></textarea>
<%} %> <% } %> <%} %> <script type="text/javascript">

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
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>

<input type="button" class="button" value="Submit" id="addbutton"
	onclick="formSubmission();" align="right" /> <input name="Reset"
	type="button" id="reset" class="button" value="Reset"
	onclick="resetResult();" /></div>
<!--Bottom labels starts--> <script language="Javascript">
function formSubmission(){
var DG_SAMPLE_DETAIL_ID=document.getElementById("<%=DG_SAMPLE_DETAIL_ID%>").value;
var RESULT_NO=document.getElementById("<%=RESULT_NO%>").value;
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
var EMPLOYEE_ID=document.getElementById("<%=EMPLOYEE_ID%>").value;
var RESULT_ENTERED_BY=document.getElementById("<%=RESULT_ENTERED_BY%>").value;var SAMPLE_COLLECTION_ID=document.getElementById("<%=SAMPLE_COLLECTION_ID%>").value;
var RESULT_TYPE=document.getElementById("<%=RESULT_TYPE%>").value;
var test2=document.getElementById("abc").value;
var ADDITIONAL_REMARKS=document.getElementById("<%=ADDITIONAL_REMARKS%>").value;
var INVESTIGATION_ID=document.getElementById("<%=INVESTIGATION_ID%>").value;
var reportEnteredFinally = document.getElementById("reportEnteredFinally").checked;

WYSIWYG.updateTextArea('abc');
//var templateData =document.getElementById("abc").value;
if(reportEnteredFinally == true){
	if(confirm("Are you sure.\nYou want to submit report for validation.")){
		submitForm("sampleCollection","investigation?method=submitResultEntryForTempelate&dgSampleDetailId="+DG_SAMPLE_DETAIL_ID+"&resultNo="+RESULT_NO+"&filmSizeUsed="+filmSizeUsed+"&filmUsed="+filmUsed+"&mainChargecodeId="+MAIN_CHARGECODE_ID+"&departmentId="+DEPARTMENT_ID+"&subChargeCodeId="+SUB_CHARGECODE_ID+"&hinId="+HIN_ID+"&inpatientId="+INPATIENT_ID+"&sampleCollectionId="+SAMPLE_COLLECTION_ID+"&employeeId="+EMPLOYEE_ID+"&resultEnteredBy="+RESULT_ENTERED_BY+"&resultType="+RESULT_TYPE+"&additionalRemarks="+ADDITIONAL_REMARKS+"&investigationId="+INVESTIGATION_ID+"&reportEnteredFinally="+reportEnteredFinally+"");	
	}else{
		return false;
	}	
}else{
	submitForm("sampleCollection","investigation?method=submitResultEntryForTempelate&dgSampleDetailId="+DG_SAMPLE_DETAIL_ID+"&resultNo="+RESULT_NO+"&filmSizeUsed="+filmSizeUsed+"&filmUsed="+filmUsed+"&mainChargecodeId="+MAIN_CHARGECODE_ID+"&departmentId="+DEPARTMENT_ID+"&subChargeCodeId="+SUB_CHARGECODE_ID+"&hinId="+HIN_ID+"&inpatientId="+INPATIENT_ID+"&sampleCollectionId="+SAMPLE_COLLECTION_ID+"&employeeId="+EMPLOYEE_ID+"&resultEnteredBy="+RESULT_ENTERED_BY+"&resultType="+RESULT_TYPE+"&additionalRemarks="+ADDITIONAL_REMARKS+"&investigationId="+INVESTIGATION_ID+"&reportEnteredFinally="+reportEnteredFinally+"");
	
}


}
function mm(){
alert('cccc');
}
	function getTemplateEditor(n) {
		return $("wysiwyg" + n);
	}

function clearTemplateData(){
	//alert(document.getElementById('abc').value);
	//document.getElementById('templateDivToShow').style.display='block';
	document.getElementById('abc').value = '';
	//$('abc').value ='';
	getTemplateEditor('abc').contentWindow.document.body.innerHTML ='';
}
function openHelpPage(){
 window.location.href='lab?method=showTemplateHelpJsp';
}
</script></form>
<!--main content placeholder ends here--></div>