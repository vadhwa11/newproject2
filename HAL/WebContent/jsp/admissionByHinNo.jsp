<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * admissionByHinNo.jsp  
 * Purpose of the JSP -  
 * @author  Deepti
 * @author  Ritu
 * Create Date: 08th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.23  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_TYPE_CODE"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.ADMISSION_TYPE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.DATE_OF_ADMISSION"%>
<%@ page import="static jkt.hms.util.RequestConstants.TIME_OF_ADMISSION"%>
<%@ page import="static jkt.hms.util.RequestConstants.PROVISIONAL_DIAG"%>
<%@ page import="static jkt.hms.util.RequestConstants.CONDITION_STATUS"%>
<%@ page import="static jkt.hms.util.RequestConstants.CONDITION"%>
<%@ page import="static jkt.hms.util.RequestConstants.LIST_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.LIST_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.SUFFIX"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIET_TYPE"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIET_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.CDA_ACCOUNT_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.AB_64_AVAILABLE"%>
<%@ page import="static jkt.hms.util.RequestConstants.DOCUMENT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.BED_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.MLC"%>
<%@ page import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_RELATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_PHONE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.AGE"%>
<%@ page import="static jkt.hms.util.RequestConstants.BLOOD_GROUP_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR"%>
<%@ page import="static jkt.hms.util.RequestConstants.DEPARTMENT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.ROOM_TYPE_ID"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasAdmissionType"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasDocument"%>
<%@page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.UserEmpGroup"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script>
<%
	List<MasUnit> unitList = new ArrayList<MasUnit>();
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
<!--

function openPopupWindow()
{
 var url="/hms/hms/adt?method=showICDSearchJsp";
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}

function jsSetIcdData(icd_no)
{
document.getElementById("icdCode").value=icd_no;
document.getElementById("icdCode").focus();
}

// -->
</script>


<%
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	int bedId = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<Patient> patientList = new ArrayList<Patient>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDiet> dietList = new ArrayList<MasDiet>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	List<MasAdmissionType> admissionTypeList = new ArrayList<MasAdmissionType>();
	List<MasBed> bedList = new ArrayList<MasBed>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	List<MasDocument> documentList = new ArrayList<MasDocument>();
	List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTimeWithoutSc");
	int visitId = 0;

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
	String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");
	String serviceNameForNonEntitledId = properties.getProperty("serviceNameForNonEntitledId");
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	
	if(patientMap.get("patientList") != null){
		patientList = (List<Patient>)patientMap.get("patientList");
	}
	if(patientMap.get("visitId") != null){
		visitId = (Integer)patientMap.get("visitId");
	}
	if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
	if(detailsMap.get("bedList") != null){
		bedList = (List<MasBed>)detailsMap.get("bedList");
	}

	for (Iterator iterator = bedList.iterator(); iterator.hasNext();) {
		MasBed masBed = (MasBed) iterator.next();
		if(masBed.getBedStatus().getId() == bedStatusUnOccupiedId){
			
			bedId = masBed.getId();
	  }
	}
	
	if(detailsMap.get("departmentList") != null){
		departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
	}
	if(detailsMap.get("employeeList") != null){
		employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
	}
	if(detailsMap.get("dietList") != null){
		dietList = (List<MasDiet>)detailsMap.get("dietList");
	}
	if(detailsMap.get("bloodGroupList") != null){
		bloodGroupList = (List<MasBloodGroup>)detailsMap.get("bloodGroupList");
	}
	
	if(detailsMap.get("admissionTypeList") != null){
		admissionTypeList = (List<MasAdmissionType>)detailsMap.get("admissionTypeList");
	}
	
	if(detailsMap.get("relationList") != null){
		relationList = (List<MasRelation>)detailsMap.get("relationList");
	}
	if(detailsMap.get("documentList") != null){
		documentList = (List<MasDocument>)detailsMap.get("documentList");
	}
	
	List<OpdPatientDetails> admissionWaitList = new ArrayList<OpdPatientDetails>();
	if(detailsMap.get("admissionWaitList")!=null ){
		admissionWaitList = (List<OpdPatientDetails>)detailsMap.get("admissionWaitList");
	}
	
	List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
	if(detailsMap.get("dischargeIcdCodeList")!=null ){
		dischargeIcdCodeList = (List<DischargeIcdCode>)detailsMap.get("dischargeIcdCodeList");
	}
	int mo = 0;
	String diagnosis=" ";
	if(map.get("mo")!=null){
		mo = (Integer)map.get("mo");
	}
	
	String admissionNotes=" ";
	if(map.get("admissionNotes")!=null){
		admissionNotes = (String)map.get("admissionNotes");
		admissionNotes = admissionNotes.replace("$", "\r");
		admissionNotes = admissionNotes.replace("^", "\n");  
	}
	String fromDepartment=" ";
	if(map.get("fromDepartment")!=null){
		fromDepartment = (String)map.get("fromDepartment");
	}
	int wardId = 0;	
	if(map.get("wardId")!=null){
		wardId = (Integer)map.get("wardId");
	}
	if(map.get("diagnosis")!=null){
		diagnosis = (String)map.get("diagnosis");
	}
	%>
	<script type="text/javascript">


function checkForNok(){
var errorMessage="";
	formName="registration"
	obj = eval('document.'+formName)
	//if(document.getElementById('nokNameId').value == "")
	//	errorMessage=errorMessage+"Please Fill NOK name \n";
//	if(document.getElementById('relId').value == 0)
	//	errorMessage=errorMessage+"Please Select Relation \n";
	//if(document.getElementById('nokAddr').value == "")
	//	errorMessage=errorMessage+"Please Fill Address \n";
	//	if(document.getElementById('serviceTypeId').value !=7){
	//		if(document.getElementById('unitId').value == "0")
	//		errorMessage=errorMessage+"Please Select Unit \n";
	//	}
//	if(document.getElementById('admType').value == "0")
	//	errorMessage=errorMessage+"Please Select  Admited Type \n";
		
	if(document.getElementById('old')){
	if(document.getElementById('old').checked == true){
	   if(document.getElementById('oldAdNoId').value == ""){
	     errorMessage = errorMessage+" Off line Ad No should not be blank";
	   }
	}
   }
   
	if(errorMessage !=""){
	alert(errorMessage)
	return false;
	}else{
	return true
	}
	
	
}
function fillDiagnosisCombo() {
var val =document.getElementById("icd").value
  	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	    var initDiagnosis=val.substring(0,parseInt(index1)-1);
	    if(id !=""){
		obj =document.getElementById('diagnosisId'); 
		obj.length = document.getElementById('diagnosisId').length;
		
	        	obj.length++;
				obj.options[obj.length-1].value=id
				obj.options[obj.length-1].text=val
				obj.options[obj.length-1].selected=true
				document.getElementById('icd').value =""
				}
    document.getElementById('initDiagnosis').value= initDiagnosis
  }
function chechFoAttachAdmission(){
 
	submitForm('admissionByHin','/hms/hms/adt?method=submitAdmissionInformation','checkBedNoSelect','checkCondition');
}
function checkBedNoSelect(){
	if((document.getElementById('bedId').value=='' || document.getElementById('bedId').value=='0') && document.getElementById('conditionId').value != 'Dead'){
		alert("Please select Bed No.")
		return false;
	}
return true; 
	
}
function checkDiet(age,currentTime){

age=parseInt(age)
if(age<1){
}

}

function getOldAdNo(){
if(document.getElementById('old').checked == true){
		document.getElementById('oldAdNoId').disabled = false;
		document.getElementById('admTime').disabled=false
		document.getElementById('imgId').style.display = 'inline';
		
	}else{
		document.getElementById('oldAdNoId').disabled = true;
		document.getElementById('admTime').disabled=true
		document.getElementById('imgId').style.display = 'none';
		
	}
}
</script>

<script type="text/javascript">
function displayAddressForTrade(){
				var trade = document.getElementById('tradeId').value;
				if(trade != 0){
				if(trade !=31 ){
				document.getElementById('addTradeDiv').style.display = 'none';
				}else if(trade == 31){
				  document.getElementById('addTradeDiv').style.display = 'inline';
					
				}
				}
			}
		
		
		</script>



<div class="titleBg"><h2>Patient Admission</h2></div>
<div class="clear"></div>

<%if(bedId >0 ){ %>
<%
if(admissionWaitList.size() > 0){
	int inc=1;
%>
<form name="waitingAdm" method="post">
<h4>Patient List For Admission</h4>
<div id="reg">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="admissionGrid">
	<tr>
		<th scope="col">Date</th>
		<th scope="col">Employee No.</th>
		<!-- <th scope="col">HIN</th> -->
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Designation</th>
		<!-- <th scope="col">Name</th> -->
		<th scope="col">Age</th>
		<th scope="col">Doctor</th>
		<!-- <th scope="col">Working Diagnosis</th> -->
		<th scope="col">Diagnosis</th>
		<th scope="col">From</th>
		<th scope="col">Ward</th>		
		<th scope="col">Action</th>
		
	</tr>
<%
	for(OpdPatientDetails opdPatientDetails : admissionWaitList){
		String icdDiagnosis = "";
		if(dischargeIcdCodeList.size() > 0){
			
			for(DischargeIcdCode dischargeIcdCode : dischargeIcdCodeList){

				if(opdPatientDetails.getId() == dischargeIcdCode.getOpdPatientDetails().getId())
				{
					
					if(!icdDiagnosis.equals("")){
						icdDiagnosis += ",";
					}
					if(!dischargeIcdCode.getIcd().getIcdName().equals("NOT AVAILABLE IN ICD"))
					{
						icdDiagnosis += dischargeIcdCode.getIcd().getIcdName()+",";
					}
					
				}
			
			}
			icdDiagnosis +=opdPatientDetails.getInitialDiagnosis()!=null?opdPatientDetails.getInitialDiagnosis():"" +",";
			if(icdDiagnosis.length()>2)
			{
				icdDiagnosis = icdDiagnosis.substring(0,(icdDiagnosis.length()-2));
			}
			
		}
		
%>
<tr id="row<%=inc%>" onclick="submitForm('waitingAdm','/hms/hms/adt?method=searchPatientDetailsForAdmission&visitId=<%=opdPatientDetails.getVisit().getId() %>&hinId=<%=opdPatientDetails.getVisit().getHin().getId() %>&mo=<%=opdPatientDetails.getEmployee().getId() %>&admissionNotes=<%=opdPatientDetails.getAdmissionNotes().replace("\r", "$").replace("\n", "^")%>&fromDepartment=<%=opdPatientDetails.getDepartment().getDepartmentName()%>&wardId=<%=opdPatientDetails.getAdmissionWard().getId()%>&diagnosis=<%=icdDiagnosis%>');">
	<td><%=HMSUtil.convertDateToStringWithoutTime(opdPatientDetails.getOpdDate()) %></td>
	<td><%=opdPatientDetails.getVisit().getHin().getServiceNo()!=null?opdPatientDetails.getVisit().getHin().getServiceNo():""%></td>
	<%
		String pName = opdPatientDetails.getVisit().getHin().getPFirstName();
		if(opdPatientDetails.getVisit().getHin().getPMiddleName()!=null)
			pName += " "+opdPatientDetails.getVisit().getHin().getPMiddleName();
		
		if(opdPatientDetails.getVisit().getHin().getPLastName()!=null)
			pName += " "+opdPatientDetails.getVisit().getHin().getPLastName();
				
		
		
	%>
	<%-- <td><%=(opdPatientDetails.getVisit().getHin().getHinNo()!=null?opdPatientDetails.getVisit().getHin().getHinNo():"") %></td> --%>
	<td><%=pName%></td>
	<td><%=opdPatientDetails.getVisit().getHin().getRelation().getRelationName() %></td>
	<td><%=opdPatientDetails.getVisit().getHin().getRank()!=null?opdPatientDetails.getVisit().getHin().getRank().getRankName():"" %></td>
	<%-- <%
		String sName = opdPatientDetails.getVisit().getHin().getSFirstName()!=null?opdPatientDetails.getVisit().getHin().getSFirstName():"";
		if(opdPatientDetails.getVisit().getHin().getSMiddleName()!=null)
			sName += " " +opdPatientDetails.getVisit().getHin().getSMiddleName();
		
		if(opdPatientDetails.getVisit().getHin().getSLastName()!=null)
			sName += " "+opdPatientDetails.getVisit().getHin().getSLastName();
		
		
	%>
	<td><%=sName %></td> --%>
	<td><%=opdPatientDetails.getVisit().getHin().getAge() %></td>
	<td><%=opdPatientDetails.getEmployee().getFirstName()+" "+(opdPatientDetails.getEmployee().getMiddleName()!=null?opdPatientDetails.getEmployee().getMiddleName():"")+" "+(opdPatientDetails.getEmployee().getLastName()!=null?opdPatientDetails.getEmployee().getLastName():"") %></td>

<td><%=icdDiagnosis%></td>
<td><%=opdPatientDetails.getDepartment()!=null?opdPatientDetails.getDepartment().getDepartmentName():" "%></td>
<td><%=opdPatientDetails.getAdmissionWard()!=null?opdPatientDetails.getAdmissionWard().getDepartmentName():" "%></td>
	
<td onclick="event.cancelBubble=true;cancelIPAdmission(<%=opdPatientDetails.getId()%>,<%=inc%>);"><input name="Button" class="buttonAuto" value="Cancel" tabindex="1"  type="button"></td>	
</tr>

<%inc++;} %>
</table>
</div>
</form>
<div class="paddingTop15"></div>
<%} %>
<form name="admissionByHin" method="post">
<div class="clear"></div>
<div id="testDiv">
<div class="Block">


	<%int ageForDiet = 0;
	Patient patient = new Patient();
	if(patientList.size() > 0){
		patient = patientList.get(0);
		String age = "";
		String currentAge = "";
		age = patient.getAge();
//		currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
		ageForDiet = Integer.parseInt(""+HMSUtil.calculateAgeForADT2(age, patient.getRegDate())) ;
		Float serviceYears = new Float(0);
		String currentServiceYears = "";
		if(patient.getServiceYears()!= null){
			serviceYears = patient.getServiceYears();
		 currentServiceYears = HMSUtil.calculateTotalYearsForADT(serviceYears,patient.getTotalServicePeriod(), patient.getRegDate());
		}
		
		
%>

<%
		String middleName = "";
		String lastName = "";
		if(patient.getPMiddleName() != null){
			middleName = patient.getPMiddleName();
		}
		if(patient.getPLastName() != null){
			lastName = patient.getPLastName();
		}
		
		%>

<%-- <input type="text" name="<%=SERVICE_NO %>" id="serviceNo"  value="<%=patient.getServiceNo()!=null?patient.getServiceNo():"" %>" validate="Employee No.,metachar,yes" onblur="if(this.value!=''){submitProtoAjaxWithDivName('admissionByHin','/hms/hms/adt?method=getHinNoForAdm','hinDiv');}"/> --%>
<%if(patient.getServiceNo()!= null && patient.getServiceNo().trim()!="") 
{
%> 
<label>Employee No. <span>*</span></label>
<input type="text" name="<%=SERVICE_NO %>" id="serviceNo" readOnly="true" value="<%=patient.getServiceNo()!=null?patient.getServiceNo():"" %>" validate="Employee No.,metachar,yes" />
<input type="hidden" name="visitId" id="visitId" readOnly="true" value="<%=visitId%>"/>
<%
}
else
{
%>
<label>Employee No. <span></span></label>
<input type="text" name="<%=SERVICE_NO %>" id="serviceNo"  readOnly = "true" validate="Employee No.,metachar,no" />
<input type="hidden" name="visitId" id="visitId" readOnly="true" value="<%=visitId%>"/>
<%

}
%>

<label>HIN <span>*</span></label>
<div id="hinDiv">
<input type="text" name="<%=HIN_ID %>" id="hinId" readOnly="true" value="<%=patient.getHinNo() %>" /> 
</div>
<label>Patient Name</label> 
<label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>
<div class="clear"></div>
<label>Relation</label> 
<%
	if(patient.getRelation() != null){
	%> 
	<label class="value"><%= patient.getRelation().getRelationName()%></label>
<input type="hidden" name="relationId" id="relationId"	value="<%=patient.getRelation()%>"> 
<%} else{ %> 
<label	class="value">-</label> 
<% }%> 


<%
		if(patient.getRank()!=null){
	%>
<label>Designation</label>
<label class="value"><%=patient.getRank()!=null?patient.getRank().getRankName():"" %></label>

<label>Name</label>
 <%
		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
	 %>
<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> 
<% }%>


	 <%} %>
<div class="clear"></div>


<label>Age</label> 
<label class="value"><%=currentAge%></label> 

<label>Gender</label>
<%
	if(patient.getSex() != null){
	%>  
	<label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>
<%} %> 
<label> Blood Group</label> 
<select name="<%=BLOOD_GROUP_ID %>"	validate="Blood Group,String,no">
	<option value="0">Select</option>
	<% 
	for (MasBloodGroup  obj : bloodGroupList){
			if(patient.getBloodGroup() != null){
			if(patient.getBloodGroup().getId().equals(obj.getId())){
	%>
	<option value="<%=obj.getId ()%>" selected><%=obj.getBloodGroupName()%></option>
	<%		}else{
	%>	
	<option value="<%=obj.getId ()%>"><%=obj.getBloodGroupName()%></option>
	<%}
		}else{%>
	<option value="<%=obj.getId ()%>"><%=obj.getBloodGroupName()%></option>
	<% 		
		}
	}%>
</select>
<div class="clear"></div>

<input type="hidden" name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>"> 
<input type="hidden" name="patientHinId" value="<%=patient.getId() %>"> 
<input type="hidden" name="<%=AGE %>" value="<%=currentAge %>"> 
<%-- <input type="hidden" name="<%=SERVICE_TYPE_CODE %>"	value="<%=patient.getServiceType().getServiceNameShortDesc() %>">
<input type="hidden" name="<%=SERVICE_TYPE_ID %>" value="<%=patient.getServiceType().getId() %>" id="serviceTypeId"> --%>
<% 

	}else{ %>
<label>Employee No. <span>*</span></label>
<%-- <input type="text" name="<%=SERVICE_NO %>" id="serviceNo" value="" validate="Employee No.,metachar,yes" onblur="if(this.value!=''){submitProtoAjaxWithDivName('admissionByHin','/hms/hms/adt?method=getHinNoForAdm','hinDiv');}"/> --%> 
<input type="text" name="<%=SERVICE_NO %>" id="serviceNo" value="" readOnly="true" validate="Employee No.,metachar,yes" />
<input type="hidden" name="visitId" id="visitId" readOnly="true" value="<%=visitId%>"/>
<script>
document.getElementById('serviceNo').focus();
</script>
<label>HIN <span>*</span></label>
<div id="hinDiv">
<input type="text" name="<%=HIN_ID %>" id="hinId" readOnly="true" value="" /> 
</div>
<label>Patient Name</label> 
<label	class="value">&nbsp;</label> 
<div class="clear"></div>
<label>Relation</label>
<label class="value">&nbsp;</label>

<label>Designation</label>
<label class="value">&nbsp;</label>

<label>Name</label> 
<label class="value">&nbsp;</label> 

<div class="clear"></div>
<label>Age</label> 
<label class="value">&nbsp;</label> 
<label>Gender</label> 
<label class="value">&nbsp;</label>
<label> Blood Group</label> 
<label class="value">&nbsp;</label>
<div class="clear"></div>

<%} %>

<label> Admission Type <span>*</span></label> 
<select name="<%=ADMISSION_TYPE_ID %>" tabindex="1" 	validate="Admission Type,String,yes" id="admType" onchange="displayFieldsForAdmType(this.value);">
	<option value="0">Select</option>
	<% 
		for (MasAdmissionType obj : admissionTypeList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getAdmissionTypeName()%></option>
	<% }%>
</select> 

<div id="admTypeDt" style="display: none;">
<label> Hospital Name <span>*</span></label> 
<input type="text" name="prevHospitalName" value="" maxlength="50"tabindex="1" />

<div class="clear"></div>
<label>A&D No. <span>*</span></label> 
<input type="text" name="prevAdNo" value="" maxlength="30" tabindex="1" />
<label>Disposal <span>*</span></label> 
<input type="text" name="prevDisposal" value="" tabindex="1" maxlength="100"/>
<label>Diagnosis <span>*</span></label> 
<label class="value">&nbsp;</label>
<div class="clear"></div>
</div>

<label> Date <span>*</span></label> 
<input type="text"	name="<%=DATE_OF_ADMISSION%>" value="<%=currentDate %>" tabindex="1" class="calDate"	readonly="readonly" validate="Date,dateOfAdmission,yes"
	MAXLENGTH="30" id="admDate" onchange="populateListDateTime();"	onclick="populateListDateTime();" /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"
	onClick="setdate('',document.admissionByHin.<%=DATE_OF_ADMISSION%>,event)" />

<label> Time <span>*</span></label> 
<input type="text"	name="<%=TIME_OF_ADMISSION %>" value="<%=currentTime %>"	 validate=" Time,String,yes" id="admTime"	disabled="disabled"	onblur="checkTime('admissionByHin','<%=TIME_OF_ADMISSION%>');populateListDateTime();" />

<div class="clear"></div>

<label>Doctor<span>*</span></label> 
<select	name="<%=CONSULTING_DOCTOR %>" id="moId" validate="Doctor,String,yes" tabindex="1" >
	<option value="0">Select</option>
	<% 
	System.out.println("employeeList"+employeeList.size());
	System.out.println("empCategoryCodeForDoctor"+empCategoryCodeForDoctor);
		for (MasEmployee  obj : employeeList){
			if(obj.getEmpCategory() != null){
			
				
			if(obj.getEmpCategory().getEmpCategoryCode().trim().equals(empCategoryCodeForDoctor.trim())){
			
				String doctorMiddleName = "";
				String doctorLastName = "";
				String rankName ="";
				if(obj.getMiddleName()!= null){
					doctorMiddleName = obj.getMiddleName();
				}
				if(obj.getLastName() != null){
					doctorLastName = obj.getLastName();
				}
				if(obj.getRank() != null){
					rankName = obj.getRank().getRankName();
				}
			
				
	%>
	<option value="<%=obj.getId()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%  }}
	} %>
</select>
<script>
document.getElementById('moId').value='<%=mo%>'
</script>
<label> Ward <span>*</span></label> 
<select name="<%=DEPARTMENT_ID %>"	validate="Ward,String,yes" tabindex="1" onchange="checkBed()" id="wardId">
	<option value="0">Select</option>
	<% 
		
				for(MasDepartment obj : departmentList){
		%>
	<option value="<%=obj.getId()%>"><%=obj.getDepartmentName()%></option>
	<%}%>
</select>
<script>
document.getElementById('wardId').value='<%=wardId%>'
if(document.getElementById('wardId')!=null && document.getElementById('wardId').value.trim()!='0')
	{
	
	document.getElementById('wardId').onchange();
	}

</script>
<input type="hidden"  id="bedNoTemp" value="" class="readOnly" readonly="readonly" validate="Bed No.,String,yes" />
  <input type="hidden" id="roomTypeId" name="<%=ROOM_TYPE_ID %>" value=""/>
<input type="hidden" name="bedNo" id="bedNo" value=""/>

 <label> Veg/Non-Veg</label> 
 <select	name="<%=DIET_TYPE%>" validate="Veg/Non-Veg,String,no" tabindex="1" >
	<option value="">Select</option>
	<option value="Veg">Veg</option>
	<option value="Non-Veg">Non-Veg</option>
</select>
<div class="clear"></div>
<label>Condition <span>*</span></label> 
<select id="conditionId" name="<%=CONDITION %>" class="year" tabindex="1" validate="Condition,String,yes" onchange="displayStatus(),displayListDateTime();">
	<option value="0">Select</option>
	<option value="Normal">Normal</option>
	<option value="Better">Better</option>	
	<option value="Critical">Critical</option>
	<option value="Quoma">Quoma</option>
	<option value="Dead">Dead</option>
</select> 

<label>Status <span>*</span></label>
<!--<label id="blnkSts">&nbsp;</label>
--><div id="status1">
<select name="<%=CONDITION_STATUS %>" id="conditionStatus" class=""  tabindex="1" validate="Status,String,no">
<option value="">Select</option>
	<option value="Walking">Walking</option>
	<option value="Sitting">Sitting</option>
	<option value="Lying">Lying</option>
</select>
</div>
<div id="status2" style="display: none;">
<label class="value">Dead</label>
</div>

<div id="status3" style="display: none;">
<select name="<%=CONDITION_STATUS %>" id="conditionStatusSil" class="" tabindex="1" >
	<option value="SIL">SIL</option>
	<option value="DIL">DIL</option>
</select>


<label>List Date</label> 
<input id="listdateId" type="text"	 name="<%=LIST_DATE %>" value="" tabindex="1" 	validate="List Date,String,no" readonly="readonly"> 
	
<label>List Time</label> 
<input id="listtimeId" type="text" 	name="<%=LIST_TIME %>" value="" tabindex="1"  validate="List Time,String,no"	readonly="readonly">
	
</div>

<script type="text/javascript">

	function displayStatus(){
		var condition = document.admissionByHin.<%=CONDITION %>.value;
		if(condition == "Normal"){
			document.getElementById('status1').style.display = "inline";
			document.getElementById('status2').style.display = "none";
			document.getElementById('status3').style.display = "none";
			document.getElementById('conditionStatus').setAttribute('validate','Status,string,yes');
			document.getElementById('conditionStatus').value  = "";
			document.getElementById('admType').setAttribute('validate','Admission Type,String,yes');
			document.getElementById('moId').setAttribute('validate','Doctor,String,yes');
			document.getElementById('wardId').setAttribute('validate','Ward,String,yes');
		//	document.getElementById('blnkSts').style.display = "none";
			
		}else if(condition == "Dead"){
			document.getElementById('status2').style.display = "inline";
			document.getElementById('status1').style.display = "none";
			document.getElementById('status3').style.display = "none";
			document.getElementById('conditionStatus').setAttribute('validate','Status,string,no');
			document.getElementById('admType').setAttribute('validate','Admission Type,String,no');
			document.getElementById('moId').setAttribute('validate','Doctor,String,no');
			document.getElementById('wardId').setAttribute('validate','Ward,String,no');
			document.getElementById('conditionStatus').value  = "";
		//	document.getElementById('blnkSts').style.display = "none";
		}/* else if(condition == "Critical"){
			document.getElementById('status3').style.display = "inline";
			document.getElementById('status1').style.display = "none";
			document.getElementById('status2').style.display = "none";
			document.getElementById('conditionStatus').setAttribute('validate','Status,string,no');
			document.getElementById('conditionStatus').value  = "";
			document.getElementById('admType').setAttribute('validate','Admission Type,String,yes');
			document.getElementById('moId').setAttribute('validate','Doctor,String,yes');
			document.getElementById('wardId').setAttribute('validate','Ward,String,yes');
		//	document.getElementById('blnkSts').style.display = "none";
		} */else if(condition == "0"){
			document.getElementById('status1').style.display = "none";
			document.getElementById('status2').style.display = "none";
			document.getElementById('status3').style.display = "none";
			document.getElementById('conditionStatus').setAttribute('validate','Status,string,no');
			document.getElementById('conditionStatus').value  = "";
			document.getElementById('admType').setAttribute('validate','Admission Type,String,yes');
			document.getElementById('moId').setAttribute('validate','Doctor,String,yes');
			document.getElementById('wardId').setAttribute('validate','Ward,String,yes');
		//	document.getElementById('blnkSts').style.display = "inline";
		}
	}
	
	function displayListDateTime(){
	//var list = document.getElementById('status3').value;
	var cond = document.getElementById('conditionId').value;
	date = '<%=currentDate%>';
	time = '<%=currentTime%>';
	if(cond == "Critical"){
		document.getElementById('listdateId').value = document.getElementById('admDate').value;
		document.getElementById('listtimeId').value = document.getElementById('admTime').value;
	}else{
		document.getElementById('listdateId').value = "";
		document.getElementById('listtimeId').value = "";
	}
	
}
	function populateListDateTime(){
	document.getElementById('listdateId').value = document.getElementById('admDate').value;
		document.getElementById('listtimeId').value = document.getElementById('admTime').value;
	}		
</script>
<label>Diagnosis</label> 
<label class="value"><%=diagnosis%>&nbsp;</label>

<label>From</label> 
<label class="value"><%=fromDepartment%>&nbsp;</label>

<label>Admission Notes</label> 
<textarea onkeyup="auto_grow(this)" validate="Admission Notes,string,no" maxlength="500" name ="admission_notes" id ="admission_notes" class="large" disabled="disabled" />
<%=admissionNotes%>
</textarea>

 <div class="clear"></div>



<%-- <label>Patient Diet</label> 
<select name="<%=DIET_ID %>"	validate="Diet,String,no" tabindex="1" >
	<%Integer hours =0;
	StringTokenizer s = new StringTokenizer(currentTime,":");  
	if(s.hasMoreTokens())
		hours=Integer.parseInt(""+s.nextToken()) ;
	  for (MasDiet  obj : dietList){
		if(ageForDiet <1 && obj.getDietCode().equalsIgnoreCase("B/F")){
		%>
	<option value="<%=obj.getId ()%>" selected="selected"><%=obj.getDietName()%></option>
	<%}else if(ageForDiet <=5 && obj.getDietCode().equalsIgnoreCase("N/2")){ %>
	<option value="<%=obj.getId ()%>" selected="selected"><%=obj.getDietName()%></option>
	<%}else if(ageForDiet >5 && ageForDiet <=10 && obj.getDietCode().equalsIgnoreCase("O/2") ){ %>
	<option value="<%=obj.getId ()%>" selected="selected"><%=obj.getDietName()%></option>
	<% }else if(ageForDiet >10 ){
	    		if(hours >= 18  && hours <24 && obj.getDietCode().equalsIgnoreCase("N")){
	    	
	    	%>
	<option value="<%=obj.getId ()%>" selected="selected"><%=obj.getDietName()%></option>
	<%}else if(hours >= 0  && hours <12 && obj.getDietCode().equalsIgnoreCase("O")){ %>
	<option value="<%=obj.getId ()%>" selected="selected"><%=obj.getDietName()%></option>
	<%}else if(hours >= 12  && hours <18 && obj.getDietCode().equalsIgnoreCase("S")){ %>
	<option value="<%=obj.getId ()%>" selected="selected"><%=obj.getDietName()%></option>
	<%} %>
	<% }%>
	<% }%>

</select> --%>
<%-- <label>CDA Account No.</label>
 <input type="text" name="<%=CDA_ACCOUNT_NO %>" value="" maxlength="50" tabindex="1" >
<label>AB 64 Available</label>
 <input type="checkbox" class="radio" 	name="<%=AB_64_AVAILABLE %>" value="y" tabindex="1" > --%>
<div class="clear"></div>
</div>	
<div class="clear"></div>
<h4>NOK Details</h4>
<div class="clear"></div>
<div class="Block">
<label> NOK1</label>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="<%=NEXT_OF_KIN_NAME%>" value="" tabindex="1" 	validate="NOK1 Name,fullName,no" id="nokNameId" maxlength="30"/>
	
<label>  Relation</label> 
<select	name="<%=NEXT_OF_KIN_RELATION_ID %>" tabindex="1" validate="NOK1 Relation,String,no"	id="relId">
	<option value="0">Select</option>

	<% 
	for (MasRelation  obj : relationList){
	%>
	<option value="<%=obj.getId()%>"><%=obj.getRelationName()%></option>
	<% 				
	}%>
</select>
<label> Contact No.</label> 
<input	type="text" name="<%=NEXT_OF_KIN_PHONE_NO%>" value="" tabindex="1" id="nokContactNoId"	validate="NOK1 Phone No,phone,no" maxlength="11" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="<%=NEXT_OF_KIN_ADDRESS %>" id="nextOfKinAdd"	cols="20" rows="2" tabindex="1" validate="Nok1 Address,string,no"  maxlength="200"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<div class="clear"></div>
	
<label> NOK2</label>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="nok2Name" value=""	validate="NOK2 Name,fullName,no" tabindex="1" id="nok2NameId" maxlength="30"/>
	
<label>  Relation</label> 
<select	name="nok2RelationId" validate="NOK2 Relation,String,no"	tabindex="1" id="nok2RelId">
	<option value="0">Select</option>

	<% 
	for (MasRelation  obj : relationList){
	%>
	<option value="<%=obj.getId()%>"><%=obj.getRelationName()%></option>
	<% 				
	}%>
</select>
<label> Contact No.</label> 
<input	type="text" name="nok2ContactNo" id="nok2ContactNo" value=""	tabindex="1" validate="NOK2 Contact No,phone,no" maxlength="11" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="nok2Address" id="nok2Add"	cols="20" rows="2" tabindex="1" validate="Nok2 Address,string,no" maxlength="200"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
	
<div class="clear"></div>
<script>
<%
if(patientList.size() > 0){
%>
document.getElementById('nokNameId').value = '<%=patient.getNextOfKinName()!=null?patient.getNextOfKinName():""%>';
document.getElementById('relId').value = '<%=patient.getNextOfKinRelation()!=null?patient.getNextOfKinRelation().getId():"0"%>';
document.getElementById('nokContactNoId').value = '<%=patient.getNextOfKinPhoneNumber()!=null?patient.getNextOfKinPhoneNumber():""%>';
document.getElementById('nextOfKinAdd').value = '<%=patient.getNextOfKinAddress()!=null?patient.getNextOfKinAddress():""%>';
document.getElementById('nok2NameId').value = '<%=patient.getNok2Name()!=null?patient.getNok2Name():""%>';
document.getElementById('nok2RelId').value = '<%=patient.getNok2Relation()!=null?patient.getNok2Relation().getId():"0"%>';
document.getElementById('nok2ContactNo').value = '<%=patient.getNok2ContactNo()!=null?patient.getNok2ContactNo():""%>';
document.getElementById('nok2Add').value = '<%=patient.getNok2Address()!=null?patient.getNok2Address():""%>';

<%}%>
</script>


</div><!-- End Block 3--> 
<div class="clear"></div>
<%-- <div class="Block">
 <label>Docs Received</label> 
 <select name="<%=DOCUMENT_ID%>" size="3" title="Press ctrl key to select multiple"	tabindex="1" multiple="3" validate="Document Initiated,String,no" class="list">
	<option value="0">Select</option>
	<% 
		for (MasDocument  obj : documentList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getDocumentName()%></option>
	<% }%>

</select> 


<div class="clear"></div>


<div class="clear"></div>
</div> --%>
<input type="hidden" name="<%=BED_ID %>" value="" id="bedId" validate="Bed ,string,yes">
</div>
<div class="division"></div>
<div id="edited"></div>

<input type="button" name="Submit11" value="Save" class="button"	onClick="chechFoAttachAdmission();" id="saveId" />
<!--<input	type="hidden" name="attached" value="Attached" class="button"	window.open('/hms/hms/adt?method=showAttachWindow&hinId=<%//=patient.getId()%>', 'mywindow', location=1, status=1, scrollbars=1s,	left=200, top=100, width=100, height=100');  onclick="  window.open('/hms/hms/adt?method=showAttachWindow&hinId=<%//=patient.getId()%>','new','left=200,top=100,width=750,height=550')">-->
<%-- <input type="button" name="<%=MLC %>" value="MLC" class="button" onClick="if(checkForNok()){submitForm('admissionByHin','/hms/hms/adt?method=submitAdmissionInformation&mlcFlag=1&flag=ipMlc','validateFRW');}"> --%>
<input type="reset" name="Reset" value="Reset" class="button"	accesskey="r" />
<input type="button" class="button" name="print" value="Print" onclick="submitAdm('/hms/hms/adt?method=showIPAdmissionReportJsp')">
<!-- <input type="button" class="button" name="search" value="Search" onclick="submitAdm('/hms/hms/adt?method=showAdmissionJsp')"> -->

 <%} else{

	String msg ="<h4>No bed found.Can not Admit Patient..!</h4> ";
		%>
<h4><%=msg %></h4> <%} %>
<div id="statusMessage" class="messagelabel"></div>
<div class="clear"></div>
<div class="division"></div>

<div class="bottom">
<label>Changed By:</label>
<label	class="value"><%=userName%></label>
<label>Changed Date:</label>
<label	class="value"><%=currentDate%></label>
<label>Changed Time:</label>
<label	class="value"><%=currentTime%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
</div>
<div class="clear"></div>

</form>


<script type="text/javascript">
			<%
if(patientList!=null && patientList.size()>0){
	Patient patient = (Patient)patientList.get(0);
	if(patient.getTrade() != null && patient.getTrade().getId()==31 ){
%>

document.getElementById('addTradeDiv').style.display = 'inline';
<%}}%>

	function submitAdm(action){
	obj = document.admissionByHin;
	obj.action = action;
	obj.submit();
		
	}

function displayFieldsForAdmType(admType){
	if(admType=='10')
		document.getElementById('admTypeDt').style.display='block';
	else
		document.getElementById('admTypeDt').style.display='none';
}
function jsSetBedId(bedId)
{
document.getElementById("bedId").value=bedId;
}

function cancelIPAdmission(id,inc)
{
		if(confirm("Do You want to cancel admission?")){
	new Ajax.Request(
			"adt?method=cancelAdmission"+"&id="+id,
			{
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						if(response.responseText=="s"){
							alert("Admission has been cancelled");
							 var row = document.getElementById('row'+inc);
							 row.parentElement.removeChild(row); 
						
						}
						else{
							alert("Action could not be completed");
						}
					}
				}
			});
	
	}
}
	</script>