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
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%><script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
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
	}
}
 function resetResult(){
	var flag = document.getElementById('singleValuePresentFlag').value;
 		if(flag == 'y'){
	   		document.getElementById('resultSingleValue').value="";
	   		document.getElementById('additionalRemarksSingleValue').value="";
		}
 }
 function goBack(){
 	window.location.href='/hms/hms/investigation?method=searchPatientByBackButtonLab';
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
	List<String> resultSeqNoList = new ArrayList<String>();
	
	List<Patient> patientList = new ArrayList<Patient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTimeWithoutSc");
	Box box = HMSUtil.getBox(request);
	String userName = "";
	String CombinedIds = "";
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
	String message = "";
	if(map.get("message") != null){
		    message = (String)map.get("message");
	}
	if(map.get("CombinedIds") != null){
		CombinedIds = (String)map.get("CombinedIds");
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
	if(map.get("resultSeqNoList") != null){
		resultSeqNoList = (List<String>)map.get("resultSeqNoList");
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
	    MasDepartment masDepartment=new MasDepartment();
		DgSampleCollectionDetails dgsampleDetails=new DgSampleCollectionDetails();
%>

<script>
function inputResult(){
	var result;
	var flag = document.getElementById('singleValuePresentFlag').value;
	if(flag == 'y'){
		result = document.getElementsByName('resultSingleValue').value;
		if(result == ""){;
	  		alert("Please Enter The Result. ")
	 	}else{
					return true;
		}
	}else{
		return true;
	}
}
function submitFormToViewHistory(investigationId){
	var resultEnteredBy = document.getElementById('resultEnteredById');
	resultEnteredBy.setAttribute("validate","Result Entered By,string,no");
	if(validateMetaCharacters(investigationId)){
	submitForm('sampleCollection','/hms/hms/investigation?method=showPatientHistory&investigationIdSingleValueSingleTest='+investigationId);
	}
}  
function openTemplatePopUp(c,diagNo){
	//alert("in method");
	//window.open('appointment?method=showExistingPatients&serviceNo='+document.getElementById("serviceNo"+inc).value+'&counter='+inc,'mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=960,height=300');
	
	//var resultEnteredBy = document.getElementById('resultEnteredById').value;
	//if(resultEnteredBy != ''){
		var resultNoTemplate =document.getElementById('resultNoTemplate'+c).value;	
		var dgSampleDetailIdForTemplate =document.getElementById('dgSampleDetailIdForTemplate'+c).value;
		var CombinedIds = document.getElementById('CombinedIds').value;	
		
		
		if(validatePvms(resultNoTemplate)){
			//if(validateMetaCharacters(c)){	
				if(true){	
		submitForm('sampleCollection','investigation?method=searchForTemplateDetailsLab&resultNoTemplate='+resultNoTemplate+'&dgSampleDetailIdForTemplate='+dgSampleDetailIdForTemplate+'&CombinedIds='+CombinedIds+'&diagNo='+diagNo);
		}
			//}
		}
		//window.open('investigation?method=searchForTemplateDetailsLab&resultNoTemplate='+resultNoTemplate+'&resultEnteredBy='+resultEnteredBy+'&dgSampleDetailIdForTemplate='+dgSampleDetailIdForTemplate+'&CombinedIds='+CombinedIds+'','mywindow','location=1,status=1,scrollbars=1,top=40,left=30,width=960,height=550');
	//}else{
	//	alert('Result Entered By can not be blank.');
	//	return false;
	//}
} 
function openSensitivePopUp(c){
		var resultNoSensitive =document.getElementById('resultNoSensitive'+c).value;	
		
		var testOrderNoSensitive =document.getElementById('<%=TEST_ORDER_NO_SENSITIVE_VALUE %>'+c).value;			
		
		var dgSampleDetailIdForSensitive =document.getElementById('dgSampleDetailIdForSensitive'+c).value;
		var CombinedIds = document.getElementById('CombinedIds').value;	
		if(validateMetaCharacters(c)){
		submitForm('sampleCollection','investigation?method=searchForSensitiveDetailsLab&resultNoSensitive='+resultNoSensitive+'&dgSampleDetailIdForSensitive='+dgSampleDetailIdForSensitive+'&CombinedIds='+CombinedIds+'');
		}
} 

</script>
<!--main content placeholder starts here-->
<form name="sampleCollection" method="post" action="">
<h4><%=message %></h4>
<div class="Clear"></div>
<div class="titleBg"><h2>Result Entry</h2></div>
<%
String subDept = "";
String dept="";
int SubChargeId=0;
int mainChargeId=0;

String hinNo = "";
	for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
		if(dgCollection.getInvestigation()!= null ){
			subDept = dgCollection.getInvestigation().getSubChargecode().getSubChargecodeName();
			dept = dgCollection.getInvestigation().getMainChargecode().getMainChargecodeName();
			SubChargeId=dgCollection.getInvestigation().getSubChargecode().getId();
			mainChargeId=dgCollection.getInvestigation().getMainChargecode().getId();
			hinNo = dgCollection.getSampleCollectionHeader().getHin().getHinNo();
			%> <%
		}
	}%>

<input name="<%= DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID %>"	type="hidden" value="<%= dgDetails.getSampleCollectionHeader().getOrderByDepartment().getId() %>" />
<!--<label>Modality</label>
<label class="value" name="<%=SUB_CHARGECODE_NAME %>"><%=subDept%></label>
--><input name="<%= SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID %>"	type="hidden" value="<%= SubChargeId %>" />
<input	name="<%= MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID %>"	type="hidden" value="<%= mainChargeId %>" />

<div class="Clear"></div>
<div class="Block">
<label>Collection Date</label>
<%if(dgDetails.getSampleCollectionHeader().getDiagnosisDate() != null){ %>
<label	class="value"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getDiagnosisDate())%></label>
<%}else{%>
<label class="value">-</label> 
<%}%>
</div>
<div class="Clear"></div>

<input type="hidden" name="OrderNo"	id="<%= SAMPLE_COLLECTION_ID%>"	value="<%=dgDetails.getSampleCollectionHeader().getOrder().getOrderNo()%>" />
<input type="hidden" name="<%=SAMPLE_COLLECTION_ID %>"	id="<%= SAMPLE_COLLECTION_ID%>"	value="<%=dgDetails.getSampleCollectionHeader().getId() %>" />
<!--Block Two Starts-->
<div class="Clear"></div>
<h4>Patient Details </h4>
<div class="Block">
<label>Employee No.</label>
<%if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){%>
<label class="value"><%= patient.getServiceNo()%></label> 
<%}else{ %>
<label class="value">-</label> 
<%}%>

 <%					String middleName = "";
					String lastName = "";
					if(patient.getPMiddleName() != null){
						middleName = patient.getPMiddleName();
					}
					if(patient.getPLastName() != null){
						lastName = patient.getPLastName();
					}
					
%> 
<label>Patient Name</label>
<label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>

<label>Relation</label> 
<%if(patient.getRelation() != null){%>
<label	class="value"><%= patient.getRelation().getRelationName()%></label>
<%}else{ %>
<label class="value">-</label> 
<% }%>
<div class="Clear"></div>
<label>Designation</label> 
<%if(patient.getRank() != null){%>
<label	class="value"><%= patient.getRank().getRankName()%></label> 
<%} else{ %>
<label class="value">-</label> 
<% }%>
<label>Employee Name</label>
 <%if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
			%> 
<label class="value"><%= patient.getSFirstName()+" "+(patient.getSMiddleName()!= null?patient.getSMiddleName():"")+" "+(patient.getSLastName() != null?patient.getSLastName():"")%></label>
<%}else{ %>
<label class="value">-</label> 
<% }%>

 
<%
		
	    
	    
	       int PatientAge=0;
					
			if(patient.getDateOfBirth() != null)
			{
				Date date_of_birth= patient.getDateOfBirth();		
				
				PatientAge = HMSUtil.calculateAgeInYears(date_of_birth);
			}
		%>
<label>Age</label> 
<%if(PatientAge == 1){ %> 
<label class="value"><%=PatientAge%> Year</label>
<%}else if(PatientAge == 0) { %> 
<label class="value">-</label> 
<% }
else
{
	%> 
	<label class="value"><%=PatientAge%> Years</label> 
	<% 
}%>
<div class="Clear"></div>


<label>Gender</label>
<label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>
<label>Clinical Notes</label> <%if(dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="value"><%=dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %>
<label class="valueLarge">-</label> <%} %> 
<input type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=dgDetails.getSampleCollectionHeader().getDepartment().getId() %>" />
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" />
<input type="hidden" name="<%=HIN_NO %>"	value="<%=patient.getHinNo() %>" />
	</div>

<%if(dgDetails.getSampleCollectionHeader().getInpatient() != null){ %> 
<input	type="hidden" name="<%=INPATIENT_ID %>"	value="<%=dgDetails.getSampleCollectionHeader().getInpatient().getId()%>" />
<%}else{ %> 
<input type="hidden" name="<%=INPATIENT_ID %>" value="" /> 
<%} %>
<div class="Clear"></div>

<!--Block Two Ends--> <!-- Block Three Starts -->
<h4>Result Entry Details</h4>
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

<label class="value"><%=user.getEmployee().getFirstName() %></label>

	<input	type="hidden" name="<%=EMPLOYEE_ID %>" value="<%=empId%>" />
<input type="hidden"	name="<%=SAMPLE_COLLECTION_DATE%>" value="<%=date%>" />
<input	type="hidden" name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" />

<%
	 String resultSeqNo="";
		if(map.get("resultSeqNo") != null){
			resultSeqNo = (String)map.get("resultSeqNo");
		}
	%>
<input type=hidden name="<%=RESULT_NO %>" value="<%=resultSeqNo %>"	title="Result No." />


<div class="Clear"></div>

<input type=hidden	value=0 name=pagecounter2 />
<input type="hidden" name="pageNo"	id="pageNo" value="<%=pageNo%>" />
</div>
<div class="Clear"></div>
<%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label style="width: auto; padding-left: 10px; padding-top: 0px; color: #AC1400;">
<!-- (In Result Column: Special Characters like (,-,@ etc) are not allowed
only numeric values can be entered.)  -->
</label>
<%} %>
<div class="Clear"></div>
<table border="0" cellspacing="0" width="100%" cellpadding="0">

	<tr>

		<th width=7%>Sl No.</th>
		<th width=7%>Diag No.</th>
		<th scope="col">Investigation</th>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">Sample</th>
		<%} %>
		<th scope="col">Result</th>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">Units</th>
		<%} %>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">Normal Range</th>
		<%} %>
		<th>Remarks</th>
		<th>Reject</th>
		<!--<th>Patient History</th>
	--></tr>
	<%
			
		Set<DgMasInvestigation> masSet= new HashSet<DgMasInvestigation>();
   		 DgMasInvestigation masInv = new DgMasInvestigation();
		String normalValue="";
		String charge="";
		int chargeId=0;
		int investigationId=0;
		String resultType="";
		int srNoCounter = 0;
		int indexForMultiple = 0;
		boolean singleValuePresentFlag = false;
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
			if(resultType.equalsIgnoreCase("m")){
				System.out.println("Multiple if");
				srNoCounter++;
			%>
	<jsp:include page="viewMultipleRecordTableForMerging.jsp" flush="true">
		<jsp:param name="srNoCounter" value="<%=srNoCounter%>" />
		<jsp:param name="resultEntryIndex" value="<%=i-1%>" />
		<jsp:param name="resultEntryIndexForMultiple"
			value="<%=indexForMultiple%>" />
	</jsp:include>
	<% 
		  indexForMultiple = indexForMultiple + dgCollection.getInvestigation().getDgSubMasInvestigations().size()+1;
		  //break;  
		  }else if(resultType.equalsIgnoreCase("s")){
			  srNoCounter++;
			  singleValuePresentFlag = true;
			  %>
	<tr>
	<td>
		<input type="hidden" name="<%=RESULT_NO_SINGLE_VALUE %>" value="<%=resultSeqNoList.get(i-1) %>" title="Result No." />
		<label name="<%=SR_NO%>"><%=srNoCounter%></label></td>

	<td>
		<%if(dgCollection.getDiagNo() != null ){ %> 
		<label name=<%=DIAGNOSIS_NO_SINGLE_VALUE %> id=<%=DIAGNOSIS_NO %>><%=dgCollection.getDiagNo() %></label>
		<%}else{ %> <label name=<%=DIAGNOSIS_NO_SINGLE_VALUE%>	id=<%=DIAGNOSIS_NO %>>-</label> <%} %>
		</td> 
		<td>
		<input name="<%=RESULT_TYPE_SINGLE_VALUE %>" id="<%=RESULT_TYPE_SINGLE_VALUE %>" value="s" type="hidden">
		<input name="<%=INVESTIGATION_ID_SINGLE_VALUE %>" id="<%=INVESTIGATION_ID_SINGLE_VALUE %>"	value="<%= dgCollection.getInvestigation().getId()%>" type="hidden">
		<input name="chargeCodeCodeForPerticularTest"	id="chargeCodeCodeForPerticularTest<%=srNoCounter%>"	value="<%= dgCollection.getInvestigation().getChargeCode().getChargeCodeCode()%>"	type="hidden"> 
		<input name="resultNumericOrString"	id="resultNumericOrString<%=srNoCounter%>"	value="<%= dgCollection.getInvestigation().getNumericOrString()%>" type="hidden"> 
		<input type="hidden" name="<%=TEST_ORDER_NO_SINGLE_VALUE%>"	id="<%=TEST_ORDER_NO_SINGLE_VALUE %>" value="<%=(dgCollection.getInvestigation().getTestOrderNo()!=null?dgCollection.getInvestigation().getTestOrderNo():"")%>" /> 
		<input name="<%=CHARGE_CODE_ID_SINGLE_VALUE %>" id="<%=CHARGE_CODE_ID %>" value="<%= chargeId%>" type="hidden"> 
		<input name="<%=DG_SAMPLE_DETAIL_ID_SINGLE_VALUE %>" id="<%=DG_SAMPLE_DETAIL_ID %>" value="<%= dgCollection.getId()%>" type="hidden"> 
		<%if(dgCollection.getInvestigation().getInvestigationName() !=null  ){
            	        %> 
           <label style="font-weight: bold;"> <%=dgCollection.getInvestigation().getInvestigationName() %></label> 
		
		<input name="<%=INVESTIGATION_NAME_SINGLE_VALUE %>" type="hidden"	size="15"	value="<%=dgCollection.getInvestigation().getInvestigationName() %>"	readonly /> 
		<%}else { %> 
		<label style="font-weight: bold;"></label> 
		<input	name="<%=INVESTIGATION_NAME_SINGLE_VALUE %>" type="hidden" size="15" value="" readonly /> <%} %>
		</td>

		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<td>
		<%if(dgCollection.getInvestigation().getSample() !=null){ %> 
		<input	type="hidden" name="<%=SAMPLE_ID_SINGLE_VALUE%>"id="<%=SAMPLE_ID_SINGLE_VALUE %>"value="<%=dgCollection.getInvestigation().getSample().getId() %>" />
		<input name="<%=SAMPLE_NAME_SINGLE_VALUE %>" type="text" size="10"	value="<%=dgCollection.getInvestigation().getSample().getSampleDescription() %>"	readonly /> 
		<%}else { %> 
		<input name="<%=SAMPLE_NAME_SINGLE_VALUE %>"	type="text" size="10" value="" readonly /> 
		<%} %>
		</td>
		<%} %>
		<td>
		<%-- <input type="text" name="<%=RESULT_SINGLE_VALUE %>"	onkeyup="submitAllExceptEnter(this,event,'','<%=srNoCounter%>');" id="<%=RESULT_SINGLE_VALUE %><%=srNoCounter%>" tabindex="1" value=""maxlength="50" /> --%>
		<input type="text" name="<%=RESULT_SINGLE_VALUE %>"	id="<%=RESULT_SINGLE_VALUE %><%=srNoCounter%>" tabindex="1" value=""maxlength="50" /> 
		<script type="text/javascript">
				var chargeCodeToTest = document.getElementById('chargeCodeCodeForPerticularTest<%=srNoCounter%>').value;
				if(chargeCodeToTest == 'HA17'){
					document.getElementById('<%=RESULT_SINGLE_VALUE %><%=srNoCounter%>').value = 'Control 13 Sec,';
				}else if(chargeCodeToTest == 'HA18'){
					document.getElementById('<%=RESULT_SINGLE_VALUE %><%=srNoCounter%>').value = 'Control 28 Sec,';
				}
		</script>
		</td>

		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<td>
		<%if(dgCollection.getInvestigation().getUom() !=null){ %> 
		<input	type="hidden" name="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE%>"	id="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE %>"	value="<%=dgCollection.getInvestigation().getUom().getId() %>" /> 
		<input	name="uomName" type="text" size="8"	value="<%=dgCollection.getInvestigation().getUom().getUomName() %>"	readonly /> 
		<%}else { %> 
		<input type="hidden" name="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE%>"id="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE %>" value="" /> 
		<input	name="uomName" type="text" size="8" value="" readonly /> 
		<%} %>
		</td>
		<%} %>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<td>
		<%if(dgCollection.getInvestigation().getNormalValue() != null || dgCollection.getInvestigation().getMinNormalValue() != null || dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
		<%if(dgCollection.getInvestigation().getNormalValue() != null ){ 
				if(!dgCollection.getInvestigation().getNormalValue().equals("")){
					%> 
		<input name="normalIdSingleValue" type="hidden" size="8"value="<%=dgCollection.getInvestigation().getId()%>" readonly /> 
		<input	name="normalValueSingleValue" type="text" size="14"	value="<%=dgCollection.getInvestigation().getNormalValue()%>"	readonly /> 
			<%}else if (dgCollection.getInvestigation().getMinNormalValue()!= null && dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
		<input name="normalIdSingleValue" type="hidden" size="8"value="<%=dgCollection.getInvestigation().getId()%>" readonly /> 
		<input	name="normalValueSingleValue" type="text" size="14"value="<%=dgCollection.getInvestigation().getMinNormalValue()+" - "+dgCollection.getInvestigation().getMaxNormalValue()%>"readonly /> 
			<%}
		} 
		else if(dgCollection.getInvestigation().getMinNormalValue()!= null && dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
		<input name="normalIdSingleValue" type="hidden" size="8"	value="<%=dgCollection.getInvestigation().getId()%>" readonly /> 
		<input	name="normalValueSingleValue" type="text" size="14"	value="<%=dgCollection.getInvestigation().getMinNormalValue()+" - "+dgCollection.getInvestigation().getMaxNormalValue()%>"	readonly /> 
		<%}}else{ %> 
		<input name="normalIdSingleValue" type="hidden" size="8" value="<%=dgCollection.getInvestigation().getId()%>" readonly /> 
		<input	name="normalValueSingleValue" type="text" size="14" value="" readonly />
		<%} %>
		</td>
		<%} %>

		<td>
		<%if(dgCollection.getRemarks() != null){ %> 
		<input type="text"	value="<%=dgCollection.getRemarks() %>" maxlength="100"	onkeyup="chkLength(this,100);"	name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"></input> 
		<script>
		document.sampleCollection.<%=ADDITIONAL_REMARKS_SINGLE_VALUE%>.innerHTML = "<%=dgCollection.getRemarks()%>"
		</script>
		<%}else{ %> 
		<input type="text" value="" maxlength="100"	onkeyup="chkLength(this,100);"	name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"></input> <%} %>
		</td>
		<td>
		<input type="checkbox" name="sampleRejected<%=srNoCounter-1%>" value="y" />
		<!--<input type="button" name="patientHistoryButton"
			value="Patient History" class="button"
			onclick="submitFormToViewHistory('<%=dgCollection.getInvestigation().getId()%>');" />
		--></td>
	</tr>

	<%	}else if(resultType.equalsIgnoreCase("t")){ 
			srNoCounter++;
	%>
	<tr>
		<td><label name="<%=SR_NO%>"><%=srNoCounter%></label></td>
	<td>
		<%if(dgCollection.getDiagNo() != null){ %> <label
			name="<%=DIAGNOSIS_NO_FOR_TEMPLATE %>"
			id="<%=DIAGNOSIS_NO_FOR_TEMPLATE %>"><%=dgCollection.getDiagNo() %></label>
		<%}else{ %> <label name="<%=DIAGNOSIS_NO_FOR_TEMPLATE %>"
			id="<%=DIAGNOSIS_NO_FOR_TEMPLATE %>">-</label> <%} %>
		</td>
		<td><input name="<%=DG_SAMPLE_DETAIL_ID_TEMPLATE %>" id="<%=DG_SAMPLE_DETAIL_ID_TEMPLATE %><%=(i-1) %>"	value="<%= dgCollection.getId()%>" type="hidden"> 
		<input	type="hidden" name="<%=RESULT_NO_TEMPLATE%>" id="<%=RESULT_NO_TEMPLATE %><%=(i-1)%>" value="<%=resultSeqNoList.get(i-1) %>" title="Result No." />
		 <input	type="hidden" name="<%=TEST_ORDER_NO_TEMPLATE_VALUE%>"	id="<%=TEST_ORDER_NO_TEMPLATE_VALUE%><%=(i-1)%>" value="<%=dgCollection.getInvestigation().getTestOrderNo()%>" />
		  <label name="<%=INVESTIGATION_NAME_FOR_TEMPLATE %>" ><%=dgCollection.getInvestigation().getInvestigationName() %></label></td>

		
		</div>
<td><div id="templateButtonDiv" style="display: block; width: auto;"><input type="button" class="buttonBig2"	value="Click Here To Fill Result"	onclick="openTemplatePopUp(<%=(i-1)%>,'<%=dgCollection.getDiagNo() != null?dgCollection.getDiagNo():"" %>');" align="right" />		</td>
		<td id="resultEntryMessageDiv"	style="color: red; display: none; width: 100%;">
		<div>
		<label	style="font-weight: bold; color: red;">Result Entered Successfully</label></div>
		</td>
		<!--<td>&nbsp;</td>
		<td>&nbsp;</td>
		--><td><input type="text"	name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=i-1%>" value="<%=(dgCollection.getRemarks()!=null ?dgCollection.getRemarks():"")  %>"
		maxlength="200"></td>
		<td><input type="checkbox" name="sampleRejected<%=i-1 %>" value="y" /></td>
	</tr>
	<%	}else if(resultType.equalsIgnoreCase("v")){ 
		srNoCounter++;
		%>
	<tr>
		<td><label name="<%=SR_NO%>"><%=srNoCounter%></label></td>
		<td>
		 <%if(dgCollection.getDiagNo() != null){ %> <label
			name="<%=DIAGNOSIS_NO_FOR_SENSITIVE %>"
			id="<%=DIAGNOSIS_NO_FOR_SENSITIVE %>"><%=dgCollection.getDiagNo() %></label>
		<%}else{ %> <label name="<%=DIAGNOSIS_NO_FOR_SENSITIVE %>"
			id="<%=DIAGNOSIS_NO_FOR_SENSITIVE %>">-</label> <%} %>
		</td> 
		<td>
		<input name="<%=DG_SAMPLE_DETAIL_ID_SENSITIVE %>"	id="<%=DG_SAMPLE_DETAIL_ID_SENSITIVE %><%=(i-1) %>"	value="<%= dgCollection.getId()%>" type="hidden"> 
		<input	type="hidden" name="<%=RESULT_NO_SENSITIVE%>"	id="<%=RESULT_NO_SENSITIVE %><%=(i-1)%>"	value="<%=resultSeqNoList.get(i-1) %>" title="Result No." /> 
		<input	type="hidden" name="<%=TEST_ORDER_NO_SENSITIVE_VALUE%>"	id="<%=TEST_ORDER_NO_SENSITIVE_VALUE %><%=(i-1)%>"	value="<%=dgCollection.getInvestigation().getTestOrderNo()%>" /> 
		<label	name="<%=INVESTIGATION_NAME_FOR_SENSITIVE %>"	style="font-weight: bold;"><%=dgCollection.getInvestigation().getInvestigationName() %></label>
		</td>

		<td>
		<div id="templateButtonDiv" style="display: block; width: auto;">

		<input type="button" class="buttonBig2" value="Click Here To Fill Result"	onclick="openSensitivePopUp(<%=(i-1)%>);" align="right" /></div>
		</td>
		<td>
		<div id="resultEntryMessageDiv"	style="color: red; display: none; width: 100%;">
		<label	style="font-weight: bold; color: #ac1400;">Result Entered Successfully</label>
		</div>
		</td>
		<td>&nbsp;</td>
		<td><input type="checkbox" name="sampleRejected<%=i-1 %>" value="y" /></td>
	</tr>
	<%	}
	
		} %>

</table>
<div class="Clear"></div>
<div class="paddingTop5"></div>
<div class="Clear"></div>

<%-- <div class="Block">
<label>Upload Result</label><%	String uploadFrom ="OPD"; %>
<input type="file" name="uploadresult" id="uploadresultId"  class="browse"/>
<input type="hidden" name="flag" id="flag" value="n">
  <input type="hidden" name="hinId" id="hinId" value="<%out.print(hinId);%>">
 <input type="hidden" name="visitId" id="visitId" value="<%dgDetails.getOrderdt().get%>">
  <input type="hidden" name="inpatientId" id="inpatientId" value="<%out.print(inpatientId);%>">
  <input type="hidden" name="uploadFrom" id="uploadFrom" value="<%out.print(uploadFrom);%>"> 
</div>
 --%>
<div class="Clear"></div>
<div class="paddingTop5"></div>
<div class="Clear"></div>
<!-- Table Ends --> <!--Bottom labels starts-->

<input type="hidden" name="CombinedIds"	id="CombinedIds" value="<%=CombinedIds%>" /> <%if(singleValuePresentFlag) { %>
<input type="hidden" name="singleValuePresentFlag"	id="singleValuePresentFlag" value="y" /> <% }else{ %>
<input	type="hidden" name="singleValuePresentFlag" id="singleValuePresentFlag"	value="n" /> <% } %>
<div class="Clear">
</div>



<input type="button" name="submitForDisable" id="submitForDisable"	tabindex="1" class="button" value="Submit"	onclick="submitFormToDisableSubmit('sampleCollection','investigation?method=submitResultEntryForAllInvestigationType');"	align="right" />
<input name="Button" type="button" class="button"	value="Reset" onclick="resetResult();" />
<input name="Button"	type="button" class="button" value="Back" onclick="goBack();" />

<div class="Clear"></div>


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
<div class="paddingTop40"></div>
<!--Bottom labels starts--></form>
<!--main content placeholder ends here-->
<script type="text/javascript">
function checkForNumericResult(obj,inc)
{
	if(obj.value != ''){
		var flag = validateNumeric(obj.value);
		if(flag == false){
			alert('\''+obj.value + '\' is not Accepted in Result Column at row ' + inc + '.\nOnly numeric value is allowed in Result.');
			return false;
		}
	}
	return true;
}
function submitAllExceptEnter(myfield,e,url,inc)
{
	var keycode;
	if (window.event)
		 keycode = window.event.keyCode;
	else if (e) 
		keycode = e.which;
	else 
		return true;
	if (keycode != 13) {
		var resultNumericOrString = document.getElementById('resultNumericOrString'+inc).value;
		if(resultNumericOrString != 'S'){
			if(checkForNumericResult(myfield,inc)){
				return true;
			}else{
				document.getElementById('<%=RESULT_SINGLE_VALUE %>'+inc).value = '';
				return false;
			}
		}
	}
}
function checkForNumericResultMultiple(obj,inc,mainCount,subCount)
{
	if(obj.value != ''){
		var flag = validateNumeric(obj.value);
		if(flag == false){
			alert('\''+obj.value + '\' is not Accepted in Result Column at row ' + mainCount + '.' + subCount+ '.\n Only numeric value is allowed in Result.');
			return false;
		}
	}
	return true;
}

function submitAllExceptEnterForMultiple(myfield,e,url,inc,mainCount,subCount)
{
	<%-- var keycode;
	if (window.event)
		 keycode = window.event.keyCode;
	else if (e) 
		keycode = e.which;
	else 
		return true;
	if (keycode != 13) {
	
		var resultNumericOrStringForMultiple = document.getElementById('resultNumericOrStringForMultiple'+mainCount+subCount).value;
		if(resultNumericOrStringForMultiple != 'S'){
			if(checkForNumericResultMultiple(myfield,inc,mainCount,subCount)){
				return true;
			}else{
				document.getElementById('<%=RESULT%>'+inc).value = '';
				return false;
			}
		}
	} --%>
}



function jsImport()
{
	if (document.getElementById('uploadresultId').value == "")
		
	{
	alert('Please select a file to Upload');
	return;
	}
	var fname = document.getElementById('uploadresultId').value;
	var hinId= document.getElementById("hinId").value;
	var ind1 = fname.lastIndexOf("\\");
	var filename = fname.substring(ind1+1);
	document.getElementById("fileName").value=filename;
	document.getElementById("flag").value="y";
	document.attachFile.method="post";
	submitForm('attachFile','opd?method=uploadAndViewDocuments&hinId='+hinId+'&'+csrfTokenName+'='+csrfTokenValue);
	
}


</script>
