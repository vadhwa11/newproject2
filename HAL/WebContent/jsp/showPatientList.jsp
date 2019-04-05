<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="java.text.SimpleDateFormat"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.UserButtonRights"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>


<%@page import="jkt.hms.util.PatientCaseSheetDetails"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/balloontip.js">
/***********************************************
* Rich HTML Balloon Tooltip- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>









<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<%
	Map map = new HashMap();
	int waitingCount = 0;
	int referCount = 0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	List<Inpatient> inPatientSet = new ArrayList<Inpatient>();
	List<Transfer> transferList = new ArrayList<Transfer>();
	try {
			if(map.get("inPatientSet")!=null)
			{
			  inPatientSet=(List<Inpatient>)map.get("inPatientSet");

			}
			
			if(map.get("transferList")!=null)
			{
				transferList=(List<Transfer>)map.get("transferList");

			}
			
	} catch (Exception exp) {
			exp.printStackTrace();
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId=0;

	if (map.get("deptId") != null) {
		deptId = (Integer) map.get("deptId");
	}
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	if (map.get("waitingCount") != null) {
		waitingCount = Integer.parseInt(""+map.get("waitingCount")) ;
	}

	if (map.get("referCount") != null) {
		referCount = Integer.parseInt(""+map.get("referCount")) ;
	}
	List<MasBed> bedNoList = new ArrayList<MasBed>();
	if(map.get("bedNoList")!=null){
		bedNoList = (List<MasBed>)map.get("bedNoList");
	}
	List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
	if(map.get("opdDetailsList")!=null){
		opdDetailsList = (List<OpdPatientDetails>)map.get("opdDetailsList");
	}
	List<PatientCaseSheetDetails> caseSheetDetails = new ArrayList<PatientCaseSheetDetails>();

	if(map.get("caseSheetDetails")!=null){
		caseSheetDetails = (List<PatientCaseSheetDetails>)map.get("caseSheetDetails");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));

%>


<div class="titleBg"><h2>Ward Management</h2></div>
<div class="clear"></div>
<!--<h4><%=deptName %></h4>
--><!--  <div style="float: left; padding-left: 500px;"><h4 align="left" class="style1"><%//deptName%></h4></div>  -->
<div class="clear"></div>
<!-- thread search menu -->

    <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");

      %>
    <h4><%=message %></h4>
		<% }
		%>

<div class="clear"></div>

<form name="patientList" method="post" action="">

<div class="clear"></div>
<input type="button" class="buttonBig" value="Case Sheet" onclick="submitForm('patientList','ipd?method=showCaseSheetJsp','validatePatientForCaseSheet');" />
<input type="button" class="buttonBig" value="Linen Management" onclick="submitForm('patientList','ipd?method=showPatientKitIssueJsp','validatePatient');" />
<input type="button" class="buttonBig" value="Medicine Issue" onclick="submitForm('patientList','ipd?method=medicineIssuePage','validatePatientForCaseSheet');" />
<input type="button" class="buttonBig" value="Nursing Care Setup" onclick="submitForm('patientList','ipd?method=showNursingCareJsp','validatePatient');" />
<input type="button" class="buttonBig" value="Nursing Entry" onClick="submitForm('patientList','ipd?method=showNewNursingCareEntryDetailsJsp','validatePatient');"	/>
<input type="button" class="buttonBig" value="Diet Entry" onClick="submitForm('patientList','ipd?method=showDietEntryDetailsJsp','validatePatient');"	/>
<input type="button" class="buttonBig" value="Clinical Entry" onClick="submitForm('patientList','ipd?method=showNewNursingClinicalChartJsp','validatePatient');"	/>
<input type="button" class="buttonBig" value="Intake Output" onClick="submitForm('patientList','ipd?method=showIntakeOutputJsp','validatePatient');"	/>
<!-- <input type="button" class="buttonBig" value="Medicine Issue" onClick="submitForm('patientList','ipd?method=showMedicineIssueDetailJsp','validatePatient');" /> -->
<input type="button" class="buttonBig" value="Bed/Care Transfer" onClick="submitForm('patientList','/hms/hms/adt?method=getTransferScreen','validatePatient');" />
<input type="button" class="buttonBig" value="SIL/DIL " onClick="submitForm('patientList','ipd?method=showSilDilJsp','validatePatient');" />
<!-- <input type="button" class="buttonBig" value="MLC"  onClick="submitForm('patientList','/hms/hms/adt?method=showMlcJsp','validatePatient');" /> -->
<input type="button" class="buttonBig" value="Discharge Slip" onClick="if(checkPatientForDischarge()){submitForm('patientList','discharge?method=showDischargeInputJsp');}"	/>
<!-- <input type="button" class="buttonBig" value="Upload Documents"  onClick="submitForm('patientList','/hms/hms/opd?method=showUploadingDocumentsJsp','validatePatient');" /> -->
<!-- <input type="button" class="buttonBig" value="Diet Setup"  onClick="submitForm('patientList','/hms/hms/ipd?method=showDietSetupJsp')" /> -->
<input type="button" class="buttonBig" value="Requisition Status"  onClick="submitForm('patientList','/hms/hms/lab?method=getOrderNoListForOrderStatus','validatePatient')" />
<!-- <input type="button" class="buttonBig" value="Specialist Opinion" onclick="submitForm('patientList','/hms/hms/ipd?method=showSpecialistOpinionJsp','validatePatient')" > -->
<input type="button" class="buttonBig" value="Accept"  onClick="if(checkPatient()){submitForm('patientList','/hms/hms/ipd?method=acceptPatientToWard');}" />
<!-- <input type="button" class="buttonBig" value="Care Transfer" onclick="submitForm('patientList','ipd?method=showHandTakeJsp','validatePatient');" /> -->
<!-- <input type="button" class="buttonBig" value="Care Transfer Acceptance" onclick="submitForm('patientList','ipd?method=showCareTransferAccepJsp');" /> -->
<input type="button" class="buttonBig" value="Surgery Requisition" onclick="submitForm('patientList','ipd?method=showSurgeryRequisitionJspFromPatientList','validateSurgeryRequisition');" />
<input type="button" class="buttonBig" value="Transfer To Labor Room" onClick="if(confirm('Are you sure you want to transfer to labor?')){if(validatePatient()){submitForm('patientList','/hms/hms/ipd?method=transferPatientToLaborRoom', 'checkGender');}}" />
<input type="button" class="buttonBig" value="Transfer To OT" onClick="if(confirm('Are you sure you want to transfer to OT?')){if(validatePatient()){submitForm('patientList','/hms/hms/ipd?method=transferPatientToOT', 'validateSurgeryRequisition');}}" />
<div class="clear paddingTop15"></div>
<%if(referCount>0){ %>
<div style="color: red;"><a style="color: red;" href="/hms/hms/ipd?method=getReferedPatientList"><%=referCount%>  New Referals are Waiting</a></div>
<%}%>

<div class="clear"></div>

<%
String adNo ="";
int j=1;
	int i=0;
	if(bedNoList.size()>0){
		for(MasBed bed : bedNoList){
		 if(bed.getBedStatus().getId() == bedStatusUnOccupiedId){

%>
<div class="green" onclick="setInpatientId('','')"> &nbsp;<div class="bedNo"><%=bed.getBedNo() %>
</div></div>
<%
	 }else{
		 
		if(inPatientSet.size()>0){
			System.out.println("inPatientSet"+inPatientSet.size());
			boolean flag = false;
		 	for(Inpatient inpatient : inPatientSet){
		 		/* System.out.println("bed.getId()="+bed.getId()+"0");
		 		System.out.println("inpatient.getBed().getId()="+inpatient.getBed().getId()+"0");
		 		System.out.println(inpatient.getBed().getId() == bed.getId());  */
		 		if(inpatient.getBed()!=null && inpatient.getBed().getId().compareTo(bed.getId()) == 0){
		 			
		 		String patientName = "";
		 		String doctorName = "";
		 		String from ="";
		 		/* if(inpatient.getHin().getRelation().getId()==8){
		 			patientName += inpatient.getHin().getRank()!=null?inpatient.getHin().getRank().getRankName():" "+" ";
		 		} */
		 		patientName += inpatient.getHin().getPFirstName()+" "+(inpatient.getHin().getPMiddleName()!=null?inpatient.getHin().getPMiddleName():"")+" "+(inpatient.getHin().getPLastName()!=null?inpatient.getHin().getPLastName():"") ;
	 	 		adNo =inpatient.getAdNo();
		 		String admDate = HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission());
		 		String condition = inpatient.getConditionStatus()!=null?inpatient.getConditionStatus():"";
		 		if(inpatient.getDoctor()!=null)
		 		{
		 			doctorName =  inpatient.getDoctor().getFirstName()+" ";
		 			doctorName+= inpatient.getDoctor().getMiddleName()!=null?inpatient.getDoctor().getMiddleName()+" ":"";
		 			doctorName+= inpatient.getDoctor().getLastName()!=null?inpatient.getDoctor().getLastName():"";
		 		}
		 		
				System.out.println("inpatient.getAdStatus()="+inpatient.getAdStatus());
				flag = false;
				System.out.println("transferList"+transferList.size());
				for(Transfer transfer: transferList)
				{
					
					if(inpatient.getId() == transfer.getInpatient().getId())
					{
						from = "From: ";
						flag = true;
						if(transfer.getFromDoctor()!=null)
				 		{
							from +=  transfer.getFromDoctor().getFirstName();
							/* from+= transfer.getFromDoctor().getMiddleName()!=null?" "+transfer.getFromDoctor().getMiddleName():""; */
							from+= transfer.getFromDoctor().getLastName()!=null?" "+transfer.getFromDoctor().getLastName():"";
				 		}
						
						if(transfer.getFromWard()!=null)
				 		{
							from+="/";
							from+=  transfer.getFromWard().getDepartmentName();
							
				 		}
						
						
						if(transfer.getFromBed()!=null)
				 		{
							from+="/";
							from+=  transfer.getFromBed().getBedNo();
							
				 		}
					
						
					}
				}
				System.out.println("flag"+flag+"status"+inpatient.getAdStatus());
				if(inpatient.getAdStatus().equalsIgnoreCase("L"))
				{System.out.println("inflag"+flag+"status"+inpatient.getAdStatus());%>
				<div class="pink" id="admitted<%=i %>" onclick="setInpatientId('<%=inpatient.getId() %>','<%=inpatient.getAdStatus().trim().toUpperCase() %>','<%=inpatient.getHin().getId() %>','<%=inpatient.getAdNo() %>', '<%=inpatient.getHin().getSex().getAdministrativeSexName()%>');setBorder('<%=i %>');" rel="balloon<%=i %>" >
				<div class="bedNo"><%=bed.getBedNo() %>
				</div>
				<%=patientName%>
				<div class="clear"></div>
				<%=adNo %>
				<div class="clear"></div>
				<%=admDate %>
				<div class="clear"></div>
				<%=doctorName %>
				<div class="clear"></div>
				 <%=from %>
				<!-- <div class="clear"></div> -->
				<%-- <%
					if(!condition.equals("") && inpatient.getPatientCondition()!=null && !inpatient.getPatientCondition().equalsIgnoreCase("Normal")){
				%>
				<div class="condition"><%=condition %></div>
				<%} %> --%>
				</div>
				<%	}	
				else if(inpatient.getAdStatus().equalsIgnoreCase("O"))
				{%>
				<div class="skyblue" id="admitted<%=i %>" onclick="setInpatientId('<%=inpatient.getId() %>','<%=inpatient.getAdStatus() %>','<%=inpatient.getHin().getId() %>','<%=inpatient.getAdNo() %>', '<%=inpatient.getHin().getSex().getAdministrativeSexName()%>');setBorder('<%=i %>');" rel="balloon<%=i %>" >
				<div class="bedNo"><%=bed.getBedNo() %>
				</div>
				<%=patientName%>
				<div class="clear"></div>
				<%=adNo %>
				<div class="clear"></div>
				<%=admDate %>
				<div class="clear"></div>
				<%=doctorName %>
				<div class="clear"></div>
				<%=from %>
				<!-- <div class="clear"></div> -->
				<%-- <%
					if(!condition.equals("") && inpatient.getPatientCondition()!=null && !inpatient.getPatientCondition().equalsIgnoreCase("Normal")){
				%>
				<div class="condition"><%=condition %></div>
				<%} %> --%>
				</div>
				<%	}	
				else if(inpatient.getAdStatus().equalsIgnoreCase("R"))
				{%>
				<div class="yellow" id="admitted<%=i %>" onclick="setInpatientId('<%=inpatient.getId() %>','<%=inpatient.getAdStatus() %>','<%=inpatient.getHin().getId() %>','<%=inpatient.getAdNo() %>', '<%=inpatient.getHin().getSex().getAdministrativeSexName()%>');setBorder('<%=i %>');" rel="balloon<%=i %>" >
				<div class="bedNo"><%=bed.getBedNo() %>
				</div>
				<%=patientName%>
				<div class="clear"></div>
				<%=adNo %>
				<div class="clear"></div>
				<%=admDate %>
				<div class="clear"></div>
				<%=doctorName %>
				<div class="clear"></div>
				<%=from %>
				<!-- <div class="clear"></div> -->
				<%-- <%
					if(!condition.equals("") && inpatient.getPatientCondition()!=null && !inpatient.getPatientCondition().equalsIgnoreCase("Normal")){
				%>
				<div class="condition"><%=condition %></div>
				<%} %> --%>
				</div>
				<%	}				
				else if(flag)
				{%>
				<div class="orange" id="admitted<%=i %>" onclick="setInpatientId('<%=inpatient.getId() %>','<%=inpatient.getAdStatus() %>','<%=inpatient.getHin().getId() %>','<%=inpatient.getAdNo() %>', '<%=inpatient.getHin().getSex().getAdministrativeSexName()%>');setBorder('<%=i %>');" rel="balloon<%=i %>" >
				<div class="bedNo"><%=bed.getBedNo() %>
				</div>
				<%=patientName%>
				<div class="clear"></div>
				<%=adNo %>
				<div class="clear"></div>
				<%=admDate %>
				<div class="clear"></div>
				<%=doctorName %>
				<div class="clear"></div>
				<%=from %>
				<!-- <div class="clear"></div> -->
				<%-- <%
					if(!condition.equals("") && inpatient.getPatientCondition()!=null && !inpatient.getPatientCondition().equalsIgnoreCase("Normal")){
				%>
				<div class="condition"><%=condition %></div>
				<%} %> --%>
				</div>
				<%
					
				}else if(inpatient.getAdStatus().equalsIgnoreCase("A")){
%>
<div class="blue" id="admitted<%=i %>" onclick="setInpatientId('<%=inpatient.getId() %>','<%=inpatient.getAdStatus() %>','<%=inpatient.getHin().getId() %>','<%=inpatient.getAdNo() %>', '<%=inpatient.getHin().getSex().getAdministrativeSexName()%>');setBorder('<%=i %>');" rel="balloon<%=i %>" >
<div class="bedNo"><%=bed.getBedNo() %>
</div>
<%=patientName%>
<div class="clear"></div>
<%=adNo %>
<div class="clear"></div>
<%=admDate %>
<div class="clear"></div>
<%=doctorName %>
<!-- <div class="clear"></div> -->
<%-- <%
	if(!condition.equals("") && inpatient.getPatientCondition()!=null && !inpatient.getPatientCondition().equalsIgnoreCase("Normal")){
%>
<div class="condition"><%=condition %></div>
<%} %> --%>
</div>
<%}else if(inpatient.getAdStatus().equalsIgnoreCase("W")){ %>
<div class="red" id="admitted<%=i %>" onclick="setInpatientId('<%=inpatient.getId() %>','<%=inpatient.getAdStatus() %>','<%=inpatient.getHin().getId() %>','<%=inpatient.getAdNo() %>', '<%=inpatient.getHin().getSex().getAdministrativeSexName()%>');setBorder('<%=i %>');" rel="balloon<%=i %>">
<div class="bedNo"><%=bed.getBedNo() %>
</div>
<%=patientName%>
<div class="clear"></div>
<%=adNo %>
<div class="clear"></div>
<%=admDate %>
<div class="clear"></div>
<%=doctorName %>
<!-- <div class="clear"></div> -->
<%-- <%
	if(!condition.equals("") && inpatient.getPatientCondition()!=null && !inpatient.getPatientCondition().equalsIgnoreCase("Normal")){
%>
<div class="condition"><%=condition %></div>
<%} %> --%>
</div>

<% 	}
%>
	<%
	String serviceNo = "";
	String treatment = "";
	String procedure = "";
	String physioTherapy = "";
	String diagnosis = "";
	String nursingCare = "";
	if(caseSheetDetails.size()>0){
		for(PatientCaseSheetDetails patientCaseSheetDetails : caseSheetDetails){
			if(inpatient.getHin().getId().equals(patientCaseSheetDetails.getHinId())){
				serviceNo= inpatient.getHin().getServiceNo();
				treatment = patientCaseSheetDetails.getTreatmentDetails();
				procedure = patientCaseSheetDetails.getProcedureDetails();
				physioTherapy = patientCaseSheetDetails.getPhysiotherapyDetails();
				diagnosis = patientCaseSheetDetails.getDiagnosisDetails();
				nursingCare = patientCaseSheetDetails.getNursingCareDetails();
				break;
			}
		}
	}
	

%>

<div id="balloon<%=i %>" class="wardstyle">
Emp No: <%= serviceNo%>
<div class='clear'></div>
Diagnosis: <%= diagnosis%>
<div class='clear'></div>
 Treatment: <%= treatment%>
 <div class='clear'></div>
 Procedure: <%= procedure%>
 <div class='clear'></div>
 Physiotherapy: <%= physioTherapy%>
<div class='clear'></div>
  Nursing Care: <%= nursingCare%>
<div class='clear'></div>
 </div>

 		<% i++;} %>


<%				}
			}
		 }
		 if(j%6==0){
				%>
				<!-- <div class="clear"></div> -->

				<%}
		j++;}
	}%>
<input type="hidden" name="adNo"	value="" id="adNo" />
<input type="hidden" name="hinId"	value="" id="hinId" />
<input type="hidden" name="parent"	value="" id="parent" />
<input type="hidden" name="patientStatus"	value="" id="patientStatus" />
<input type="hidden" name="gender"	value="" id="gender" />
<input type="hidden" name="counter" id="counter" value="<%=i %>" />
<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" />
<input type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
<div class="clear paddingTop15"></div>
<div class="clear"></div>
 <%if(waitingCount !=0){ %>
<div class="monitor"> Waiting Patients: <span><%=waitingCount%></span></div>
 <%} %>
<div class="clear paddingTop15"></div>
<input type="text" class="signPriority3" readonly="readonly" >
<label class="valueAutoPriority">Vacant</label>

<input type="text" class="signPriority1" readonly="readonly" >
<label class="valueAutoPriority">NRW: Not Reported to Ward</label>

<input type="text" class="signPriority4" readonly="readonly" >
<label class="valueAutoPriority">RW: Reported to Ward</label>

<input type="text" class="signPriority5" readonly="readonly" >
<label class="valueAutoPriority">TP: Transfered Patient</label>

<input type="text" class="signPriority6" readonly="readonly" >
<label class="valueAutoPriority">OT: In Operation Theater</label>

<input type="text" class="signPriority7" readonly="readonly" >
<label class="valueAutoPriority">LR: In Labor Room</label>

<div class='clear'></div>
<input type="text" class="signPriority2" readonly="readonly" >
<label class="valueAutoPriority">RD: Ready for Discharge</label>


<script	type="text/javascript">



function setInpatientId(val,patientStatus,hinId,adNo, gender){
	document.getElementById('parent').value = val;
	document.getElementById('patientStatus').value = patientStatus;
	document.getElementById('hinId').value = hinId;
	document.getElementById('adNo').value = adNo;
	document.getElementById('gender').value = gender;
}
/* setting border for show selected patient from list  */
function setBorder(inc){
	var count = '<%=j%>';

	for(var i=0;i<count;i++){
		if(i == inc){
			if(document.getElementById('admitted'+i)){
				document.getElementById('admitted'+i).style.border = '1px solid blue';
			document.getElementById('admitted'+i).style.fontWeight  = 'bold';
			document.getElementById('admitted'+i).style.color  = '#AC1400';
			}
		}else{
			if(document.getElementById('admitted'+i)){
				document.getElementById('admitted'+i).style.border = '1px solid #000'
				document.getElementById('admitted'+i).style.fontWeight  = 'normal';
				document.getElementById('admitted'+i).style.color  = '#000';
			}
		}

	}
}

function validatePatient(){
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='W'){
		alert("Patient has not been reported to ward.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='R'){
		alert("Patient is ready to dischage.");
		return false;
	}
	
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='L'){
		alert("Patient is in labor room.");
		return false;
	}
	
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='O'){
		alert("Patient is in operation theater.");
		return false;
	}
	return true;

}

function checkGender(){
	if(document.getElementById('gender').value.trim().toLowerCase()=='male'){
		alert("Male can't be transferred to labor room.");
		return false;
	}

	return true;

}

function validatePatientForCaseSheet(){
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='W'){
		alert("Patient has not been reported to ward.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='L'){
		alert("Patient is in labor room.");
		return false;
	}
	
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='O'){
		alert("Patient is in operation theater.");
		return false;
	}
	return true;

}

function validateSurgeryRequisition(){
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='W'){
		alert("Patient has not been reported to ward.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='L'){
		alert("Patient is in labor room.");
		return false;
	}
	
/* 	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='O'){
		alert("Patient is in operation theater.");
		return false;
	} */
	return true;

}
function checkPatient()
{
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!=''){
		if(document.getElementById('patientStatus').value=='W'){
			if(confirm("Has the patient physically reported to ward ?"))
				return true;
			else
				return false;
		}else{
			alert("Patient already reported to ward.")
		}
	}
}

function checkPatientForDischarge()
{
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!=''){
		if(document.getElementById('patientStatus').value=='R'){
				return true;
		}else{
			alert("Patient is not ready to discharge.")
			return false;
		}
	}
}
</script>


</form>
