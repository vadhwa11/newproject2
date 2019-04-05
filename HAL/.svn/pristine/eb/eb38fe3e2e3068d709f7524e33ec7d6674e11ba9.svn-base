
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.PatientDietIndoorDetail"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/controls.js?n=1"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<!-- code for patient information block starts-->


<%	List<PatientDietIndoorDetail> patientDietIndoorDetailList = new ArrayList<PatientDietIndoorDetail>();
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	String deptName="";
	
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	String caretime=(String)map.get("caretime");
	
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();

	if(map.get("patientDietIndoorDetailList") != null)
	{
		patientDietIndoorDetailList=(List<PatientDietIndoorDetail>)map.get("patientDietIndoorDetailList");
	}
	if(map.get("inpatientList") != null)
	{
		inpatientList=(List<Inpatient>)map.get("inpatientList");
	}
	List<Inpatient> inpatientSurgeryList = new ArrayList<Inpatient>();
	if(map.get("inpatientSurgeryList") != null)
	{
		inpatientSurgeryList=(List<Inpatient>)map.get("inpatientSurgeryList");
	}
	
	
	List<OpdSurgeryDetail> surgeryDetailList=new ArrayList<OpdSurgeryDetail>();
	if(map.get("surgeryDetailList")!=null)
	{
		surgeryDetailList=(List<OpdSurgeryDetail>)map.get("surgeryDetailList");
	}
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	 
	Patient patient = new Patient();
	Inpatient inpatient = new Inpatient();
	String patientName ="";
	String consultantName = "";
	String age = "";
	String currentAge = "";
	int inpatientId=0;
	int wardId=0;
	if(inpatientList.size() >0){
		patient = inpatientList.get(0).getHin();
		inpatient = inpatientList.get(0);
		inpatientId = inpatientList.get(0).getId();
        wardId = inpatient.getDepartment().getId();
		if(patient.getPFirstName() != null)
		   {
	       patientName=patient.getPFirstName();
		   }
		if(patient.getPMiddleName() != null)
			   {
			   patientName +=patient.getPMiddleName();
			   }
		if(patient.getPLastName() != null)
			   {
			   patientName +=patient.getPLastName();
			   }
		if(inpatient.getDoctor() !=null){
			/* consultantName=inpatient.getDoctor().getRank().getRankName(); */
			if(inpatient.getDoctor().getFirstName() != null)
			{
				consultantName+=" "+inpatient.getDoctor().getFirstName();	
			}
			if(inpatient.getDoctor().getMiddleName() != null)
			{
				consultantName+= " "+inpatient.getDoctor().getMiddleName();
			}
			if(inpatient.getDoctor().getLastName() != null)
			{
				consultantName+=" "+inpatient.getDoctor().getLastName();
			}
		}
		
	    if(patient.getAge()!=null)
			age = patient.getAge();
		try{
			if(!age.equals(""))
			currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	String majSur ="";
	try
	{
		majSur = HMSUtil.getProperties("adt.properties", "subChargeCodeForMajorSurgery");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
<h4>Patient Details</h4>
<div class="Clear"></div>
<div class="Block">

<label>A&D No.</label> <%if(inpatient.getAdNo() != null){ %>
<label class="value"><%=inpatient.getAdNo() %></label> <%}else{ %>
<label class="value">-</label>
<%} %>
<label>Employee No.</label> 
<label class="value"> <%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>


<label>Ward </label> <%if(inpatient.getDepartment() != null){ %>
<label class="value"> <%=inpatient.getDepartment().getDepartmentName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>
<label>Patient Name</label>
<label	class="value"> <%= patientName %></label>

<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} else{ %> <label
	class="value">-</label> 
	<% }%> 

<label>Designation</label>
<label class="value"><%=patient.getRank()!=null?patient.getRank().getRankName():"" %></label>
<div class="Clear"></div>
<label>Employee Name</label> <%
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

<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Admitting Doctor</label>
<label class="value"><%=consultantName %></label>


<label> Diagnosis</label> 
	<%
	List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
	if(map.get("diagnosisList")!=null){
		diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
		
	}
	if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
	{
	%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName()%></label>
	<%
		}else{
		%> <label class="value"></label> <%	
		}
		%> 
		
<div class="Clear"></div>

</div>


<input type="hidden" name="careDate" value="<%=currentDate %>" readonly="readonly" />
<input type="hidden" name="time" value="<%=time.substring(0,time.lastIndexOf(":")) %>" readonly="readonly" /> 


<div class="Clear"></div>

<!-- code for patient information block ends -->






<%
	String pageTitle = "";
    String message = "";
	/* Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	} */
	/* Map<String,Object> utilMap = new HashMap<String,Object>(); */
	List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();
	
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	/* String time = (String)utilMap.get("currentTime");
	

	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName"); 
	 
	}
	
	String currentDate = (String)utilMap.get("currentDate");   */
	
	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId =  (Integer)session.getAttribute("hospitalId");
	}
	int empId = 0;
	if(session.getAttribute("empId") != null){
		empId = (Integer)session.getAttribute("empId");
	}
	
	//out.print("hospitalId="+hospitalId);
	
	
	
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId =  (Integer)session.getAttribute("deptId");
	}
%>

<form name="getReferralWaitingList" method="post" action="">
    <h4><%=message %></h4>
    
    
    <h4>Surgery List</h4>
    
    <div class="Block" style="padding-top: 20px;">
    <%
if(inpatientSurgeryList.size()>0)
{
%>

			<div class="clear"></div>
			<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col" style="width: 20px;">S.No</th>
		<th scope="col">Admission Date</th>
		<th scope="col">HIN No</th>
		<th scope="col">Patient Name</th>
		<th scope="col">A&D No.</th>
		<th scope="col">Department</th>
		<!-- <th scope="col">Unit</th> -->
		<th scope="col" style="width: 20px;" >Surgery Name</th>
		<!-- <th scope="col">Tentative Date</th> -->
		<th scope="col">PAC Status</th>
		<th scope="col">Surgery Status</th>
		<th scope="col">PACS</th>
		<th scope="col">Surgery Remarks</th>
				<th scope="col">Pre Anesthesia</th>
		<th scope="col">Post Anesthesia</th>
		

	</tr>
	<%int i=0;
	String pName="";
	if(surgeryDetailList.size()>0){	
		for(OpdSurgeryDetail surgDetail:surgeryDetailList)
		{
			i++;
			pName=surgDetail.getOpdSurgery().getInpatient().getHin().getPFirstName();
			if(surgDetail.getOpdSurgery().getInpatient().getHin().getPMiddleName()!=null)
			{
				pName +=" "+surgDetail.getOpdSurgery().getInpatient().getHin().getPMiddleName();
			}
			if(surgDetail.getOpdSurgery().getInpatient().getHin().getPLastName()!=null)
			{
				pName +=" "+surgDetail.getOpdSurgery().getInpatient().getHin().getPLastName();
			}
			//Set<OpdSurgeryDetail> opdDet=surgHeader.getOpdSurgeryDetails();
			%>
		<tr>
		<td><%=i%></td>
		<td><%=surgDetail.getOpdSurgery().getInpatient().getDateOfAddmission() %></td>
		<td><%=surgDetail.getOpdSurgery().getInpatient().getHin().getHinNo() %></td>
		<td><%=pName%></td>
		<td><%=surgDetail.getOpdSurgery().getInpatient().getAdNo() %></td>
		<td><%=surgDetail.getOpdSurgery().getInpatient().getDepartment().getDepartmentName() %></td>
		<!-- <td></td>  -->
		<td><input type="text" class="opdTextBoxSmall" value="<%=surgDetail.getChargeCode().getChargeCodeName() %>[<%=surgDetail.getChargeCode().getId()%>]" readonly="readonly" id="proscedureName<%=i%>"/>
		     <input type="hidden" id="procedureId<%=i %>"	value="<%=surgDetail.getChargeCode().getId() %>" />
		</td>
	
		<td><%-- <select name="pacstatus<%=i%>" id="pacstatus<%=i%>"> --%>
		<%-- <option value="<%=surgDetail.getOpdSurgery().getPacStatus()%>" ><%=surgDetail.getOpdSurgery().getPacStatus()%></option> --%>
		<!-- </select> -->
		<%
		String pac_status="";
		if(surgDetail.getAnestheisaPacStatus()!=null)
		{
			if(surgDetail.getAnestheisaPacStatus().equalsIgnoreCase("RC"))
			{
				pac_status="Requested for consultation";
			}else if(surgDetail.getAnestheisaPacStatus().equalsIgnoreCase("N"))
			{
				pac_status="Pending";
			}else if(surgDetail.getAnestheisaPacStatus().equalsIgnoreCase("CR"))
			{
				pac_status="Consultation received";
			}else if(surgDetail.getAnestheisaPacStatus().equalsIgnoreCase("Y"))
			{
				pac_status="Cleared";
			}
			else if(surgDetail.getAnestheisaPacStatus().equalsIgnoreCase("NC"))
			{
				pac_status="Not Cleared";
			}
		}
		
			
		%>
		<%=pac_status%>
		</td>
		
	
		<td>
			<%
		String surgery_status="";
		if(surgDetail.getSurgeryStatus()!=null)
		{
			if(surgDetail.getSurgeryStatus().equalsIgnoreCase("n"))
			{
				surgery_status="Pending";
			}else if(surgDetail.getSurgeryStatus().equalsIgnoreCase("y"))
			{
				surgery_status="Complete";
			}else if(surgDetail.getSurgeryStatus().equalsIgnoreCase("c"))
			{
				surgery_status="Cancelled";
			}
		}
		
			
		%>
		<%=surgery_status%>
		</td>
		<td>
			<%
			
			if(pac_status!="" && !pac_status.equals("Pending")){
			
			if(majSur.equalsIgnoreCase(surgDetail.getChargeCode().getSubChargecode().getSubChargecodeCode())){ %>
		 <input class="button" alt="PAC" tabindex="4" value="Click" onclick="openWindow('/hms/hms/opd?method=viewPreAnesthesiaOPD&hinId=<%=surgDetail.getOpdSurgery().getHin().getId()%>&visitId=<%=surgDetail.getOpdSurgery().getVisit().getId() %>&chargeCode=<%=surgDetail.getChargeCode()!=null?surgDetail.getChargeCode().getId():"0"%>&backFlag=OPD')" type="button" align="left">
		 <%} }
			else
				out.println("-");
		 %>
		</td>
		<td>
		<%if(surgDetail.getOtBookingDt()!=null && surgDetail.getOtBookingDt().getOtBookingHd().getSurgeryStatus()!=null && surgDetail.getOtBookingDt().getOtBookingHd().getSurgeryStatus().equalsIgnoreCase("y")){
		   if(surgDetail.getOtBookingDt().getOtBookingHd().getAdditionalNotes()!=null && !surgDetail.getOtBookingDt().getOtBookingHd().getAdditionalNotes().isEmpty())
		   {
		%>
	<%-- 	<%=surgDetail.getOtBookingDt().getAdditionalNotes()!=null?surgDetail.getOtBookingDt().getOtBookingHd().getAdditionalNotes():"-"%></td> --%>
	
	<input class="button" alt="Post Operative Notes" tabindex="4" value="Click" onclick="openWindow('/hms/hms/opd?method=viewOtPostOperative&remarks=<%=surgDetail.getOtBookingDt().getOtBookingHd().getAdditionalNotes()%>')" type="button" align="left">
	<%} 
			else{
				out.println("N/A");
			}
				  
		}
	else
		out.println("-");
	%>
	
	
	<td>
		<%if(surgDetail.getOtBookingDt()!=null && surgDetail.getOtBookingDt().getOtBookingHd().getOtPreAnesthesiaStatus()!=null && surgDetail.getOtBookingDt().getOtBookingHd().getOtPreAnesthesiaStatus().equalsIgnoreCase("y")){%>
	<input class="button" alt="Pre Operative Notes" tabindex="4" value="Click" onclick="openWindow('/hms/hms/ot?method=viewPreAnesthesiaDeials&visitId=<%=surgDetail.getOpdSurgery().getVisit().getId()%>&bookingId=<%=surgDetail.getOtBookingDt().getOtBookingHd().getId()%>&inpatientId=<%=surgDetail.getOpdSurgery().getInpatient()!=null?surgDetail.getOpdSurgery().getInpatient().getId():"0"%>')" type="button" align="left">
		<%}%></td>
	
	<td>
		<%if(surgDetail.getOtBookingDt()!=null && surgDetail.getOtBookingDt().getOtBookingHd().getOtPostAnethesiaStatus()!=null && surgDetail.getOtBookingDt().getOtBookingHd().getOtPostAnethesiaStatus().equalsIgnoreCase("y")){%>
	<input class="button" alt="Post Operative Notes" tabindex="4" value="Click" onclick="openWindow('/hms/hms/ot?method=viewPostAnesthesiaDeials&visitId=<%=surgDetail.getOpdSurgery().getVisit().getId()%>&bookingId=<%=surgDetail.getOtBookingDt().getOtBookingHd().getId()%>&inpatientId=<%=surgDetail.getOpdSurgery().getInpatient()!=null?surgDetail.getOpdSurgery().getInpatient().getId():"0"%>')" type="button" align="left">
		<%}%></td>
		
	</tr>
	
		
	<%
		}
	}
	%>
	
	   
</table>
</div>
<input type="hidden" name="procCount" value="<%=i %>" id="procCount" />
<!-- added by govind 14-10-2016 -->

<input type="hidden"  id="deptName" value="<%=deptName%>"/>
<input type="hidden"  id="inpatientId" value="<%=inpatientId%>" validate="inpatientId,int,no" />

<!-- added by govind 14-10-2016 end -->
<div class="clear"></div>
<div class="paddingTop40"></div>

<%} else{%>
<h4> No Surgery Exist</h4>
<% 
}
%>
  </div>  
    
    
    
    
    
    
    
    
    
    
    
	<h4>Medicine List</h4>

	<div class="Block" style="padding-top: 20px;">
		<div id="divSearchResult">

			<table class="tblSearchActions" cellspacing="0" cellpadding="0"
				border="0">
				<tr>
					<td class="SearchStatus" style="font-size: 13px;" align="left">Search
						Results</td>
					<td>
						<div id=resultnavigation></div>


					</td>
					<td style="width: 80px;"><input id="pageno" type="text"
						maxlength="4" name="pageno" style="width: 25px;"> <input
						class="button" type="button"
						onclick="goToPageForPatient(pageno.value)" value="Go" name="ok"
						style="width: 35px;"></td>
				</tr>
			</table>

			<table id="tblSearchResultsHeader" class="tblSearchResultsHeader"
				cellspacing="0" cellpadding="0" border="0">
				<tr>

					<th id="th1" style='width: 300px;'>Nomenclature</th>
					<th id="th1" style='width: 100px;'>Prescription Date</th>
					<th id="th1" style='width: 100px;'>Prescribed Quantity</th>
					<th id="th1" style='width: 100px;'>Remaining Quantity</th>
					<th id="th2" style='width: 100px;'>Issued Quantity</th>
					<th id="th3" style='width: 100px;'>No of Days</th>
					<th id="th4" style='width: 100px;'>Frequency</th>
					<th id="th4" style='width: 100px;'>Dosage</th>
					<th id="th5" style='width: 100px;'>Status</th>
					


				</tr>
				<tbody id="tblListOfPatient">

				</tbody>
			</table>
			<div class="clear"></div>
			<div class="clear"></div>

			
          <input type="hidden" value="<%=empId%>" name="approvedBy" /> 
		</div>
		<div id="pageNavPosition"></div>

	</div>
	<div class="clear"></div>
<div class="division"></div>	
<div class="paddingTop15"></div>
	<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js?n=1"></script>

<script language="javascript">
	var nPageNo = 1;

	var $j = jQuery.noConflict();

	$j(document).ready(function() {
		GetPatientList('ALL');

	});

	function GetPatientList(MODE) {

		var hospitalId =
<%out.print(hospitalId);%>
	;

		if (MODE == 'ALL') {
			var data = "PN=" + nPageNo + "&hospitalId=" + hospitalId;
		} else {
			var data = "PN=" + nPageNo + "&hospitalId=" + hospitalId;
		}
		var url = "ipd?method=getMedicineList&inpatientId="+<%=inpatientId%>+"&wardId="+<%=wardId%>;
		var bClickable = true;
		GetJsonData('tblListOfPatient', data, url, bClickable);
	}

	function makeTable(jsonData) {
		var htmlTable = "";
		for (i = 0; i < jsonData.length; i++) {

			htmlTable = htmlTable + "<tr id="+jsonData[i].headerId+"-"+jsonData[i].remainingQuantity+">";
			
			htmlTable = htmlTable + "<td >" + jsonData[i].nomenclature
					+ "</td>";
					htmlTable = htmlTable + "<td >" + jsonData[i].prescriptionDate + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].prescribedQuantity + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].remainingQuantity + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].issuedQuantity + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].no_of_days + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].frequency + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].dosage + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].status + "</td>";		

			htmlTable = htmlTable + "</tr>";
		}
		if (jsonData.length == 0) {
			htmlTable = htmlTable
					+ "<tr><td colspan='9'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}

		$j("#tblListOfPatient").html(htmlTable);

	}

	function executeClickEvent(Id)
	 {
		
		openPopup(Id.split("-")[0], Id.split("-")[1])
		/* window.location="referral?method=generateInvoicePageForHRDivision&opdId="+Id; */
	 }
	function openPopup(Id, remainingQty)
	{
	 var url="/hms/hms/ipd?method=getMedicineEntryPage&headerId="+Id+"&remainingQty="+remainingQty;	
	 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
		
	}
			 
/*
	 function showMedicalExamDetails(tempId)
	 {
	 //alert(tempId);
	 var array = new Array();
	 array = tempId.split("~~~");
	 var visitId = array[0];
	 var medExamType = array[1];
	
	
	 //window.location = "medicalExam?method=showAnnualMedExamJsp&visitId="+visitId+"&medExamType="+ExamType;
	
	 if(medExamType=='Primary/Extension Med. Exam(AFMSF-2A)'){
	 window.location = "medicalExam?method=showPrimaryExtMedExamJsp&visitId="+visitId+"&medExamType="+medExamType;
	 }else if((medExamType=='Annual Medical Exam(AFMSF-3B)')||(medExamType=='Prior To Proceedings Abroad Med. Exam(AFMSF-3B)')||(medExamType=='High Altitude Med. Exam(AFMSF-3B)'))
	 {   
	 if(validateMetaCharactersExam(medExamType)){
	 window.location = "medicalExam?method=showAnnualMedExamJsp&visitId="+visitId+"&medExamType="+medExamType;
	 }
	 }else if(medExamType=='Med. Exam On Release/Discharge(AFMSF-18)')
	 {
	 if(validateMetaCharactersExam(medExamType)){
	 window.location = "medicalExam?method=showReleaseDischargeJsp&visitId="+visitId+"&medExamType="+medExamType;
	 }
	 }else if(medExamType == 'Medical Case Sheet(AFMSF-7A)'){
	 window.location = "opd?method=showOPDMainJsp&visitId="+visitId;
	
	 }else if(medExamType == 'Form-44(AFMSF-44)'){
	 window.location = "opd?method=showOPDMainJsp&visitId="+visitId;
	 }	    
	 else if(medExamType=='AFMSF-7A')
	 { 
	 window.location = "medicalExam?method=showAFMSF7AJsp&visitId="+visitId+"&medExamType="+medExamType;
	 }
	 //-by kiran
	 else if(medExamType == 'Form-44')
	 {
	 window.location = "medicalExam?method=showMeForm44JSP&visitId="+visitId;
	 }
	
	
	 } */

	function showResultPage(pageNo) {

		nPageNo = pageNo;
		GetPatientList('FILTER');

	}

	function ShowAllList(pageNo) {

		$j("#pageno").val("");
		nPageNo = pageNo;
		GetPatientList('ALL');

	}

	function goToPageForPatient(pageNo) {
		if (pageNo != "") {
			if (parseInt(TotalNumberOfPages) < parseInt(pageNo)) {

				alert("Please enter correct page No.");
				return;

			}
		} else {
			alert("Please enter correct page No.");
			return;
		}

		nPageNo = pageNo;
		GetPatientList('FILTER');
	}

	function validateRadio() {

		var flag = false;

		for (var i = 0; i < document.getElementsByName("patientId").length; i++) {
			if (document.getElementsByName("patientId")[i].checked == true) {
				flag = true;
			} 
		}
		if (!flag) {
			alert("Please select at least one radio button");
		}
		return flag;

	}
</script>

