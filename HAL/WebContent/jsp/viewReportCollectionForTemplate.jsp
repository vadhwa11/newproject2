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
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgMasCollection"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<form name="sampleCollection" method="post" action=""><script
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
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	String deptName ="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
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
	Map<String,Object> detailsMap = new HashMap<String,Object>();
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	if(map.get("relationList") != null){
		relationList=(List)map.get("relationList");
	}
	List<MasEmployee> prescribedByList = new ArrayList<MasEmployee>();
	if(map.get("prescribedByList") != null){
		prescribedByList=(List)map.get("prescribedByList");
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
			//masDepartment = (MasDepartment) dgresultHeader.getDepartment();
	 }
%> <% 

%> <!--main content placeholder starts here-->
<div id="contentHolder">
<% if (deptType.equalsIgnoreCase("RADIO")){ %>
<h6>Report Delivery</h6>
<%}else{ %>
<h6>View Report</h6>
<%} %> <%
	String subDept = "";
int SubChargeId=0;
int mainChargeId=0;
String dept="";
		for(DgResultEntryDetail dgDetail :dgResultDtSet){
			if(dgDetail.getInvestigation() != null){
			subDept = dgDetail.getInvestigation().getSubChargecode().getSubChargecodeName();
			dept=dgDetail.getInvestigation().getMainChargecode().getMainChargecodeName();
			SubChargeId=dgDetail.getInvestigation().getSubChargecode().getId();
			mainChargeId=dgDetail.getInvestigation().getMainChargecode().getId();
%> <%
 	}
 	}%> <label class="common"> Department</label> <label
	class="valueNoWidth" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label>
<label class="noWidth">Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="valueNoWidth"><%=subDept%></label>

<input name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" />
<div class="Clear"></div>
<div class="header"><label class="noWidth">Order Date</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="noWidth">Order
Time</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="noWidth">Order
No.</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="noWidth">Order
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
<%}else{ %> <label class="valuemedium">-</label> <% }%>

<div class="Clear"></div>

<label class="medium">Relation:</label> <%
				if(dgResultEntryHeader.getPatient().getRelation() != null){
			%> <label class="valuemedium"><%=dgResultEntryHeader.getPatient().getRelation().getRelationName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Ser. Per. Name:</label> <%
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
<label class="valueNoWidth"><%=HMSUtil.changeDateToddMMyyyy(dgResultEntryHeader.getResultDate()) %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <label
	class="noWidth">Report Time</label> <label class="valueNoWidth"><%=dgresultHeader.getResultTime()%></label>

<label class="noWidth">Report Prepared By:</label> <%if(dgresultHeader.getEmployee() != null) {%>
<label class="valueNoWidth"> <%=dgresultHeader.getEmployee().getFirstName()+" "+ dgresultHeader.getEmployee().getMiddleName()+" "+ dgresultHeader.getEmployee().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="valueNoWidth">-</label>
<%} %> <input type="hidden" name="<%=SAMPLE_COLLECTION_DATE%>"
	value="<%=date%>" /> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
<label class="noWidth">&nbsp;&nbsp;Report Validated Date</label> <label
	class="valuemedium"><%=HMSUtil.changeDateToddMMyyyy(dgResultEntryHeader.getVerifiedOn())  %></label>

<label class="noWidth">&nbsp;&nbsp;Report Validated Time</label> <%if(dgresultHeader.getVerifiedTime() != null){ %>
<label class="value"><%=dgresultHeader.getVerifiedTime() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Report Validated By</label> <%if(dgresultHeader.getEmployee() != null) {%>
<label class="value"> <%=dgresultHeader.getEmployee().getFirstName()+" "+ dgresultHeader.getEmployee().getMiddleName()+" "+ dgresultHeader.getEmployee().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=EMPLOYEE_ID %>"
	name="<%=EMPLOYEE_ID %>" value="" /> <label class="value"> -</label> <%} %>

<div class="Clear"></div>
<label class="common">Brief Clinical Notes</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueNoWidth"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>

<!-- Block Three Ends -->
<div class="Clear"></div>
<!-- Table Starts -->

<div class="tableHolderAuto">
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">

	<tr>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="7%">Diag. No.</th>
		<%}else{  %>
		<th width="7%">Radio Id.</th>
		<%}%>
		<th width="7%">Service</th>


		<% int i =0;
    for(DgResultEntryDetail dgDetail :dgResultDtSet){
    i++;
    %>
		<tr>
			<td>
			<%if(dgDetail.getSampleCollectionDetails() != null){ %> <label
				name="<%=DIAGNOSIS_NO %>" id=<%=DIAGNOSIS_NO %> /><%=dgDetail.getSampleCollectionDetails().getDiagNo()%>
			<%} else{%> <label name="<%=DIAGNOSIS_NO %>" id=<%=DIAGNOSIS_NO %> /><%=dgDetail.getSampleCollectionDetails().getDiagNo()%>
			<%} %>
			</td>
			<td width="7%">
			<%if(dgDetail.getInvestigation() !=null){ %> <input
				name="<%=INVESTIGATION_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getInvestigation().getId() %>" readonly /> <label
				name="chargeCode" size="10" /> <%=dgDetail.getInvestigation().getInvestigationName()%>
			<%}else { %> <label name="chargeCode" size="10" /> <%} %>
			</td>

		</tr>
</table>
</div>


<div class="Clear"></div>
<label>Additional Remarks</label> <%if(dgDetail.getRemarks() != null){ %>
<textarea value="<%=dgDetail.getRemarks() %>" maxlength="200"
	onkeyup="return ismaxlength(this)" name="<%=ADDITIONAL_REMARKS %>"
	readonly="readonly"></textarea> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDetail.getRemarks()%>"</script>
<%}else{ %> <textarea value="" maxlength="200"
	onkeyup="return ismaxlength(this)" name="<%=ADDITIONAL_REMARKS %>"></textarea>
<%} %>
<div class="Clear"></div>
<%}
    	%> <!-- Table Ends --> <!--Bottom labels starts-->
<div class="blockFrame"><label class="medium"><span>*</span>Received
by</label> <%if(dgResultEntryHeader.getReceivedBy() != null){ %> <input
	type="text" name="<%= RECEIVED_FROM%>"
	value="<%=dgResultEntryHeader.getReceivedBy() %>"
	id="<%= RECEIVED_FROM%>" validate="Received By,string,yes"
	maxlength="50" tabindex=1 /> <%}else{ %> <input type="text"
	name="<%= RECEIVED_FROM%>" value="" id="<%= RECEIVED_FROM%>"
	validate="Received By,string,yes" maxlength="50" tabindex=1 /> <%} %> <label
	class="medium"><span>*</span>Relation</label> <select id="relationId"
	name="<%=RELATION_ID %>" validate="Relation,string,yes" tabindex=1>
	<option value="">Select</option>
	<%

for (MasRelation masRel : relationList){
if (dgResultEntryHeader.getRelation() != null && dgResultEntryHeader.getRelation().getId().equals(masRel.getId())) {
%>
	<option value=<%=masRel.getId()%> selected="selected"><%=masRel.getRelationName()%></option>
	<%
} else {
%>
	<option value=<%=masRel.getId()%>><%=masRel.getRelationName()%></option>
	<%
}
}
%>
</select> <label class="medium">Dispatched By</label> <select id="dispatchedBy"
	name="<%=DISPATCHED_BY %>" tabindex=1>
	<option value="0">Select</option>
	<%

for (MasEmployee masEmp : prescribedByList){
	
if (dgResultEntryHeader.getPrescribedBy() != null && dgResultEntryHeader.getPrescribedBy().getId().equals(masEmp.getId())) {

%>
	<option value=<%=masEmp.getId()%> selected="selected"><%=masEmp.getFirstName()+" "+masEmp.getMiddleName()+" "+masEmp.getLastName()%></option>
	<%
}else {
%>
	<option value=<%=masEmp.getId()%>><%=masEmp.getFirstName()+" "+masEmp.getMiddleName()+" "+masEmp.getLastName()%></option>
	<%
}
}

%>
</select>
<div class="paddLeft25"><input type="button" class="cmnButton"
	value="Add"
	onclick="submitForm('sampleCollection','investigation?method=updateReceivedDetails');"
	align="right" /></div>
<input type="button" class="cmnButton" value="Back"
	onclick="history.back();" align="right" /></div>

</div>
<div class="Clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>

</div>
<!--Bottom labels starts--> <!--main content placeholder ends here-->
</div>
</form>
