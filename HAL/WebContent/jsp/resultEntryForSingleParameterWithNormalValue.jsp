<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
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
 
	   document.getElementById('result').value="";
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
</script>
<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<Patient> patientList = new ArrayList<Patient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	Box box = HMSUtil.getBox(request);
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
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	String deptName ="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	int deptId =0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	Map detailsMap = new HashMap();
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	try{
		if(map.get("sampleCollectionList") != null){
			sampleCollectionList=(List)map.get("sampleCollectionList");
			
		}
	}catch(Exception e){
		e.printStackTrace();
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
	 if(sampleCollectionList != null && sampleCollectionList.size()>0)
	  {
		 dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
				patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
				inpatientSet=patient.getInpatients();
				masRank = (MasRank) patient.getRank();
	 }
	 //session.setAttribute("dgDetails",dgDetails);
	    MasDepartment masDepartment=new MasDepartment();
		DgSampleCollectionDetails dgsampleDetails=new DgSampleCollectionDetails();
		
	
%>

<script>
function inputResult(){
var result;
result = document.getElementById('result').value;
if(result == ""){;
  alert("Please Enter The Result. ")
 	}else{
			return true;
			}
				}
function submitFormToViewHistory(){
	var resultEnteredBy = document.getElementById('resultEnteredById');
	resultEnteredBy.setAttribute("validate","Result Entered By,string,no");
	submitForm('sampleCollection','/hms/hms/investigation?method=showPatientHistory');
}   
</script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="sampleCollection" method="post" action="">
<h6>Result Entry</h6>
<%
String subDept = "";
String dept="";
int SubChargeId=0;
int mainChargeId=0;

String hinNo = "";
for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
if(dgCollection.getInvestigation()!= null){
subDept = dgCollection.getInvestigation().getSubChargecode().getSubChargecodeName();
dept = dgCollection.getInvestigation().getMainChargecode().getMainChargecodeName();
SubChargeId=dgCollection.getInvestigation().getSubChargecode().getId();
mainChargeId=dgCollection.getInvestigation().getMainChargecode().getId();
hinNo = dgCollection.getSampleCollectionHeader().getHin().getHinNo();
%> <%
}
  }%> <label class="common"> Department</label> <label
	class="valueNoWidth" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label>
<input name="<%= DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID %>"
	type="hidden" value="<%= deptId %>" /> <label class="common">Sub
Department</label> <label class="valueNoWidth" name="<%=SUB_CHARGECODE_NAME %>"><%=subDept%></label>
<input name="<%= SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID %>"
	type="hidden" value="<%= SubChargeId %>" /> <input
	name="<%= MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID %>"
	type="hidden" value="<%= mainChargeId %>" />
<div class="Clear"></div>
<div class="header">
<div class="paddLeft25"><label class="NoWidth">Order Date</label></div>
<%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{%> <label class="value">-</label> <%}%> <label class="NoWidth">Order
Time</label> <%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%= dgDetails.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
No.</label> <%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%= dgDetails.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
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
<label class="medium">Service Type</label> <%if(patient.getServiceType() != null){%>
<label class="valuemedium"><%= patient.getServiceType().getServiceTypeName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Service No</label> <%if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){%>
<label class="valuemedium"><%= patient.getServiceNo()%></label> <%}else{ %>
<label class="valuemedium">-</label> <%}%> <label class="medium">Service
Status</label> <%if(patient.getServiceStatus() != null){%> <label
	class="valuemedium"><%= patient.getServiceStatus().getServiceStatusName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Relation</label> <%if(patient.getRelation() != null){%> <label
	class="valuemedium"><%= patient.getRelation().getRelationName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%>
<div class="Clear"></div>
<label>Ser. Per. Name</label> <%if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
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
	class="medium">Rank</label> <%if(patient.getRank() != null){%> <label
	class="valueNoWidth"><%= patient.getRank().getRankName()%></label> <%} else{ %>
<label class="valueNoWidth">-</label> <% }%> <label>Unit</label> <%
if(patient.getUnit() != null){
%> <label class="valuemedium"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Trade</label> <%
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
<div style="height: auto; width: auto;"><label>HIN No.</label> <label
	class="value"><%=patient.getHinNo() %></label> <%					String middleName = "";
					String lastName = "";
					if(patient.getPMiddleName() != null){
						middleName = patient.getPMiddleName();
					}
					if(patient.getPLastName() != null){
						lastName = patient.getPLastName();
					}
					
%> <label>Patient Name</label> <label class="valueNoWidth"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>

<label class="noWidth">Sex</label> <label class="valueNoWidth"><%=patient.getSex().getAdministrativeSexName() %></label>
<%	String age = "";
String currentAge = "";
age = patient.getAge();
 currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
%>
<div class="Clear"></div>
<label>Age</label> <label class="value"><%=currentAge%></label> <label>Marital
Status</label> <%String maritalStatus = "";
if(patient.getMaritalStatus() != null){
maritalStatus = patient.getMaritalStatus().getMaritalStatusName();
%> <label class="value"><%=maritalStatus%></label> <%}else{ %> <label
	class="value">-</label> <% }%>
<div class="Clear"></div>
<div><input type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getDepartment().getId() %>" />
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" />
<input type="hidden" name="<%=HIN_NO %>"
	value="<%=patient.getHinNo() %>" /></div>

<%if(dgDetails.getSampleCollectionHeader().getInpatient() != null){ %> <input
	type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getInpatient().getId()%>" />
<%}else{ %> <input type="hidden" name="<%=INPATIENT_ID %>" value="" /> <%} %>
</div>
</div>
</div>
</div>


<!--Block Two Ends--> <!-- Block Three Starts -->
<div class="blockTitle">Result Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="noWidth">&nbsp;&nbsp;Result Date</label> <label
	class="valueNoWidth"><%=date%></label> <label class="noWidth">Result
Time</label> <label class="valueNoWidth"><%=time%></label> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_DATE%>" value="<%=date%>" /> <input
	type="hidden" name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" />
<%
	 String resultSeqNo="";
		if(map.get("resultSeqNo") != null){
			resultSeqNo = (String)map.get("resultSeqNo");
		}
	%> <input type=hidden name="<%=RESULT_NO %>" value="<%=resultSeqNo %>"
	title="Result No." /> <label class="noWidth"><span>*</span>Result
Prepared By</label> <select name="<%= RESULT_ENTERED_BY %>"
	id="resultEnteredById" validate="Result Entered By,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					if(masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForParaMedical) || masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
				if (userId .equals(masEmployeecode.getId())) {
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}	}}}	%>
</select> <script type="text/javascript">
		var resultEnteredBy = document.getElementById('resultEnteredById');
		resultEnteredBy.setAttribute("validate","Result Prepared By,string,yes");
	</script>

<div class="Clear"></div>
<%if(deptType.equalsIgnoreCase("DIAG")){ %> <label class="noWidth">Sample
Validated Date</label> <%}else{ %> <label class="noWidth">Radio Collection
Date</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getSampleValidationDate() != null){ %>
<label class="valueNoWidth"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getSampleValidationDate()) %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label class="noWidth">Sample Validated Time</label> <%}else{ %> <label
	class="noWidth">Radio Collection Time</label> <%}%> <%if(dgDetails.getSampleCollectionHeader().getSampleValidationTime() != null){ %>
<label class="valueNoWidth"><%=dgDetails.getSampleCollectionHeader().getSampleValidationTime() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label class="noWidth">Sample Validated By</label> <%}else{ %> <label
	class="noWidth">Radio Collected By</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getValidatedBy() != null) {%>
<input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getValidatedBy().getId() %>" />
<label class="value"> <%=dgDetails.getSampleCollectionHeader().getValidatedBy().getFirstName()+" "+dgDetails.getSampleCollectionHeader().getValidatedBy().getMiddleName()+" "+ dgDetails.getSampleCollectionHeader().getValidatedBy().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=EMPLOYEE_ID %>"
	name="<%=EMPLOYEE_ID %>" value="" /> <label class="value"> -</label> <%} %>
<div class="Clear"></div>
<label class="common">Clinical Notes</label> <%if(dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueNoWidth"><%=dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <input type=hidden
	value=0 name=pagecounter2 /> <input type="hidden" name="pageNo"
	id="pageNo" value="<%=pageNo%>" /></div>
<!-- Block Three Ends --> <input type="button" name="yes"
	value="Patient History" class="cmnButton"
	onclick="submitFormToViewHistory();" /> <!-- Table Starts -->
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
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">Sample</th>
		<%} %>
		<th scope="col">Result</th>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">UOM</th>
		<%} %>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">Normal Range</th>
		<%} %>

		<%
			
		Set<DgMasInvestigation> masSet= new HashSet<DgMasInvestigation>();
   		 DgMasInvestigation masInv = new DgMasInvestigation();
		String normalValue="";
		String charge="";
		int chargeId=0;
		int investigationId=0;
		String resultType="";
       	int i =0;
		for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
			masInv = dgCollection.getInvestigation();
			
			
			if(dgCollection.getInvestigation().getChargeCode()!= null)
			{
			charge=dgCollection.getInvestigation().getChargeCode().getChargeCodeName();
			chargeId=dgCollection.getInvestigation().getChargeCode().getId();
			
			resultType = dgCollection.getInvestigation().getInvestigationType();
			}
			i++;
	%>
		<tr>

			<td><label name="<%=SR_NO%>"><%=i%></label></td>

			<td>
			<%if(dgCollection.getDiagNo() != null){ %> <label
				name=<%=DIAGNOSIS_NO %> id=<%=DIAGNOSIS_NO %>><%=dgCollection.getDiagNo() %></label>
			<%}else{ %> <label name=<%=DIAGNOSIS_NO %> id=<%=DIAGNOSIS_NO %>>-</label>
			<%} %>
			</td>
			<td><input name="<%=RESULT_TYPE %>" id="<%=RESULT_TYPE %>"
				value="s" type="hidden"> <input
				name="<%=INVESTIGATION_ID %>" id="<%=INVESTIGATION_ID %>"
				value=<%= dgCollection.getInvestigation().getId()%> type="hidden">
			<input name="<%=CHARGE_CODE_ID %>" id="<%=CHARGE_CODE_ID %>"
				value=<%= chargeId%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>" id="<%=DG_SAMPLE_DETAIL_ID %>"
				value=<%= dgCollection.getId()%> type="hidden"> <%if(dgCollection.getInvestigation().getInvestigationName() !=null){
            	        %> <input name="<%=INVESTIGATION_NAME %>"
				type="text" size="15"
				value="<%=dgCollection.getInvestigation().getInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=INVESTIGATION_NAME %>"
				type="text" size="15" value="" readonly /> <%} %>
			</td>

			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td>
			<%if(dgCollection.getInvestigation().getSample() !=null){ %> <input
				type="hidden" name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID %>"
				value="<%=dgCollection.getInvestigation().getSample().getId() %>" />
			<input name="<%=SAMPLE_NAME %>" type="text" size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription() %>"
				readonly /> <%}else { %> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10" value="" readonly /> <%} %>
			</td>
			<%} %>
			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %>"> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %>" value="" maxlength="50">
			</td>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td>
			<%if(dgCollection.getInvestigation().getUom() !=null){ %> <input
				type="hidden" name="<%=UNIT_OF_MEASUREMENT_ID%>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>"
				value="<%=dgCollection.getInvestigation().getUom().getId() %>" /> <input
				name="uomName" type="text" size="8"
				value="<%=dgCollection.getInvestigation().getUom().getUomName() %>"
				readonly /> <%}else { %> <input name="uomName" type="text" size="8"
				value="" readonly /> <%} %>
			</td>
			<%} %>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td>
			<%if(dgCollection.getInvestigation().getNormalValue() != null || dgCollection.getInvestigation().getMinNormalValue() != null || dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
			<%if(dgCollection.getInvestigation().getNormalValue() != null ){ 
				if(!dgCollection.getInvestigation().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=dgCollection.getInvestigation().getId()%>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%=dgCollection.getInvestigation().getNormalValue()%>"
				readonly /> <%}else if (dgCollection.getInvestigation().getMinNormalValue()!= null && dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8"
				value="<%=dgCollection.getInvestigation().getId()%>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%=dgCollection.getInvestigation().getMinNormalValue()+" - "+dgCollection.getInvestigation().getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(dgCollection.getInvestigation().getMinNormalValue()!= null && dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8"
				value="<%=dgCollection.getInvestigation().getId()%>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%=dgCollection.getInvestigation().getMinNormalValue()+" - "+dgCollection.getInvestigation().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=dgCollection.getInvestigation().getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>
			<%} %>

		</tr>
</table>
</div>

<div class="Clear"></div>
<label class="common">Additional Remarks</label> <%if(dgCollection.getRemarks() != null){ %>
<textarea value="<%=dgCollection.getRemarks() %>" maxlength="200"
	onkeyup="chkLength(this,100);" name="<%=ADDITIONAL_REMARKS %>"></textarea>
<script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgCollection.getRemarks()%>"</script>
<%}else{ %> <textarea value="" maxlength="200"
	onkeyup="chkLength(this,100);" name="<%=ADDITIONAL_REMARKS %>"></textarea>
<%} %> <%} %>

<div class="Height10"></div>
<div class="division"></div>
<!-- Table Ends --> <!--Bottom labels starts-->
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>

<input type="button" class="button" value="Submit"
	onclick="if(inputResult()){submitForm('sampleCollection','investigation?method=submitResultEntryForSingleParameter');}"
	align="right" /> <input name="Button" type="button" class="button"
	value="Reset" onclick="resetResult();" /></div>
<!--Bottom labels starts--></form>
<!--main content placeholder ends here--></div>