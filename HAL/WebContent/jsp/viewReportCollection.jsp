<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
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
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List inPatientDetailList = new ArrayList();
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
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	int userId =0;
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
	}
	List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
	if(map.get("dgResultdetailList") != null){
		dgResultdetailList = (List<DgResultEntryDetail>)map.get("dgResultdetailList");
	}
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	Map detailsMap = new HashMap();
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
	List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
	try{
		if(map.get("fixedValList") != null){
			fixedValList=(List)map.get("fixedValList");
		}
		}catch(Exception e){
		e.printStackTrace();
		}
	Set<DgResultEntryDetail> dgResultDtSet = new TreeSet<DgResultEntryDetail>();
	for(DgResultEntryHeader dgResultHeader : resultList){
		dgResultDtSet = dgResultHeader.getDgResultEntryDetails();
	}
	int hospitalId = 0;
	MasRelation masRelation = new MasRelation();
	 DgResultEntryHeader dgResultEntryHeader= new DgResultEntryHeader();
	MasRank masRank = new MasRank();
	int departmentId =0;
	int inpatientId =0;
	int hinId = 0;
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	String number="";int resultId=0;
	 if(resultList != null && resultList.size()>0)
	   {
		   dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
			hinId =dgResultEntryHeader.getPatient().getId();
			inpatientSet=dgResultEntryHeader.getPatient().getInpatients();
		}
	 
	
%> <!-- main content placeholder starts here -->
<div id="contentHolder">
<% if (deptType.equalsIgnoreCase("RADIO")){ %>
<h6>Report Delivery</h6>
<%}else{ %>
<h6>View Report</h6>
<%} %> <%
String subDept = "";
String dept="";
int SubChargeId=0;
int mainChargeId=0;

		for(DgResultEntryDetail dgDetail :dgResultDtSet){
			if(dgDetail.getInvestigation()!= null){
			subDept = dgDetail.getInvestigation().getSubChargecode().getSubChargecodeName();
			dept=dgDetail.getInvestigation().getMainChargecode().getMainChargecodeName();
			SubChargeId=dgDetail.getInvestigation().getSubChargecode().getId();
			mainChargeId=dgDetail.getInvestigation().getMainChargecode().getId();
			 }
 	}%> <label class="common"> Department</label> <label
	class="valueNoWidth" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label>
<label class="common">Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="valueNoWidth"><%=subDept%>
</label> <input name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" />
<div class="Clear"></div>
<div class="Height10"></div>
<div class="header">
<div class="paddLeft25"><label class="NoWidth">Order Date</label></div>
<%if(dgResultEntryHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
Time</label> <%if(dgResultEntryHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
No.</label> <%if(dgResultEntryHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
By</label> <%if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getDepartment() != null){ %>
<label class="value"><%=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="Clear"></div>
<input type="hidden" name="<%=RESULT_ID %>" id="<%= RESULT_ID%>"
	value="<%=dgResultEntryHeader.getId() %>" /></div>
<div class="Clear"></div>
<!--Block One Starts-->
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
<div class="blockTitle">Result Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="noWidth">&nbsp;&nbsp;Result Date:</label> <%if(dgResultEntryHeader.getResultDate() != null){ %>
<label class="valuemedium"><%=HMSUtil.changeDateToddMMyyyy(dgResultEntryHeader.getResultDate()) %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="noWidth">Result Time:</label> <label class="valuemedium"><%=dgResultEntryHeader.getResultTime() %></label>

<label class="noWidth">Result Prepared By:</label> <%if(dgResultEntryHeader.getEmployee() != null) {%>
<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>"
	value="<%=dgResultEntryHeader.getEmployee().getFirstName() %>" /> <label
	class="valueNoWidth"> <%=dgResultEntryHeader.getEmployee().getFirstName()+" "+ dgResultEntryHeader.getEmployee().getMiddleName()+" "+ dgResultEntryHeader.getEmployee().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="valueNoWidth">-</label>
<%} %> <input type="hidden" name="<%=SAMPLE_COLLECTION_DATE%>"
	value="<%=date%>" /> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
<label class="noWidth">Result Validated Date:</label> <label
	class="valuemedium"><%=HMSUtil.changeDateToddMMyyyy(dgResultEntryHeader.getVerifiedOn())%></label>

<label class="noWidth">Result Validated Time:</label> <%if(dgResultEntryHeader.getVerifiedTime() != null){ %>
<label class="valuemedium"><%=dgResultEntryHeader.getVerifiedTime()%></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="noWidth">Result Validated By</label> <%if(dgResultEntryHeader.getResultVerifiedBy() != null) {%>
<input type="hidden" id="<%=RESULT_VALIDATED_BY %>"
	name="<%=RESULT_VALIDATED_BY %>"
	value="<%=dgResultEntryHeader.getEmployee().getFirstName() %>" /> <label
	class="valueNowidth"> <%=dgResultEntryHeader.getResultVerifiedBy().getFirstName()+" "+dgResultEntryHeader.getResultVerifiedBy().getMiddleName()+""+ dgResultEntryHeader.getResultVerifiedBy().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=RESULT_VALIDATED_BY %>"
	name="<%=RESULT_VALIDATED_BY %>" value="" /> <label
	class="valueNowidth">-</label> <%} %>


<div class="Clear"></div>
<label class="common">Brief Clinical Notes</label> <%if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueNoWidth"><%=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<!-- Block Three Ends -->
<div class="Clear"></div>
<!-- Table Starts -->
<div class="tableHholderCmnLarge">
<table border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Sr No.</th>
		<th scope="col">Service</th>
		<% if(deptType.equals("DIAG")){%>
		<th scope="col">Sample</th>
		<%} %>

		<% if(deptType.equals("DIAG")){%>
		<th scope="col">UOM</th>
		<%} %>
		<th scope="col">Normal Range</th>
		<th scope="col">Additional Remarks</th>
		<% int i =0;
	    Set<DgNormalValue>normalSet = new HashSet<DgNormalValue>();
	    for(DgResultEntryDetail dgDetail :dgResultdetailList){
	    	i++;
	    %>
		<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition male  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
							%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition male -->

		<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition Female  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
							%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>

			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%}}
					}
					}
				} %>
		<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition female -->

		<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition None  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>

			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%}}
					}
					}
				} %>
		<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition NoNe -->

		<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition male  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>

			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition male -->

		<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition Female  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>

			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition fEmale -->

		<!--  when result type is multiple PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition none  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is Multiple PARAMETER and comaprison type NORMAL VALUE and condition none -->

		<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition male  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
							%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is TEXT AREA  and comaprison type NORMAL VALUE and condition male -->

		<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
		<!--  condition Female  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type TEXT AREA and comaprison type NORMAL VALUE and condition fEmale -->

		<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
		<!--  condition none  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>

			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is TEXT AREA and comaprison type NORMAL VALUE and condition none -->

		<!--  when result type is Range and comparison type is NORMAL VALUE  -->
		<!--  condition male  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is Range and comaprison type NORMAL VALUE and condition male -->

		<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
		<!--  condition Female  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
							%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type RANGE and comaprison type NORMAL VALUE and condition fEmale -->

		<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
		<!--  condition none  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is RANGE and comaprison type NORMAL VALUE and condition none -->

		<!--  when result type is HEADING and comparison type is NONE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>" class="heading"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
			<%}else { %> <label name="<%=SUBTEST_NAME %>" class="heading"
				id="<%=SUBTEST_NAME %><%=i %>"</label> <%} %>
			</td>
			<% if(deptType.equals("DIAG")){%>
			<td><input name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=i %>"
				type="hidden" size="5" value="" readonly /> <label>-</label></td>
			<%} %>
			<td><input name="result" id="result<%=i %>" type="hidden"
				value="" /><label>-</label></td>
			<% if(deptType.equals("DIAG")){%>
			<td><input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="" readonly /> <label>-</label></td>
			<%} %>
			<td><input name="normalId" type="hidden" id="normalId<%=i %>"
				size="5" value="" readonly /> <input name="fixedId" type="hidden"
				id="fixedId<%=i %>" size="5" value="" readonly /><label>-</label></td>

			<td><input name="<%=ADDITIONAL_REMARKS %>"
				id="<%=ADDITIONAL_REMARKS %><%=i %>" type="hidden" value="" /> <label>-</label>
			<input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!--  end when result type is HEADING and comparison type is NONE  -->
		<!--  when result type is HEADING and comparison type is FIXED VALUE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>" class="heading"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
			<%}else { %> <label name="<%=SUBTEST_NAME %>" class="heading"
				id="<%=SUBTEST_NAME %><%=i %>"</label> <%} %>
			</td>

			<% if(deptType.equals("DIAG")){%>
			<td><input name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=i %>"
				type="hidden" size="5" value="" readonly /> <label>-</label></td>
			<%} %>
			<td><input name="result" id="result<%=i %>" type="hidden"
				value="" /><label>-</label></td>
			<% if(deptType.equals("DIAG")){%>
			<td><input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="" readonly /> <label>-</label></td>
			<%} %>
			<td><input name="normalId" type="hidden" id="normalId<%=i %>"
				size="5" value="" readonly /> <input name="fixedId" type="hidden"
				id="fixedId<%=i %>" size="5" value="" readonly /><label>-</label></td>

			<td><input name="<%=ADDITIONAL_REMARKS %>"
				id="<%=ADDITIONAL_REMARKS %><%=i %>" type="hidden" value="" /> <label>-</label>
			<input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!--  end when result type is HEADING and comparison type is FIXED VALUE -->
		<!--  when result type is HEADING and comparison type is NORMAL VALUE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>" class="heading"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
			<%}else { %> <label name="<%=SUBTEST_NAME %>" class="heading"
				id="<%=SUBTEST_NAME %><%=i %>"</label> <%} %>
			</td>
			<% if(deptType.equals("DIAG")){%>
			<td><input name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=i %>"
				type="hidden" size="5" value="" readonly /> <label>-</label></td>
			<%} %>
			<td><input name="result" id="result<%=i %>" type="hidden"
				value="" /><label>-</label></td>
			<% if(deptType.equals("DIAG")){%>
			<td><input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="" readonly /> <label>-</label></td>
			<%} %>
			<td><input name="normalId" type="hidden" id="normalId<%=i %>"
				size="5" value="" readonly /> <input name="fixedId" type="hidden"
				id="fixedId<%=i %>" size="5" value="" readonly /><label>-</label></td>

			<td><input name="<%=ADDITIONAL_REMARKS %>"
				id="<%=ADDITIONAL_REMARKS %><%=i %>" type="hidden" value="" /> <label>-</label>
			<input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!--  end of when result type is HEADING and comparison type is NORMAL VALUE  -->
		<!--  when result type is SINGLE PARAMETER and COMPARISON TYPE is NONE  -->
		<%if((dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n"))){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>
			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!--  end when result type is SINGLE PARAMETER and COMAPRISON TYPE is NONE -->

		<!--  when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>
			<%} %>



			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!-- end of when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE -->
		<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
				name="<%=SUBTEST_NAME %>" type="text" size="5"
				value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
				size="2" value="" readonly /> <%} %>
			</td>
			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				name="sample" type="text"
				value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
			<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
			</td>
			<%} %>




			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
				value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
				value="" readonly /> <%} %>
			</td>
			<%} %>
			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
				readonly /> <input name="normalValue" type="text" size="8" value=""
				readonly /><label>-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE   -->
		<!--  when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f") ){ %>


		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
				name="<%=SUBTEST_NAME %>" type="text" size="5"
				value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
				size="2" value="" readonly /> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				name="sample" type="text"
				value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
			<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
			</td>
			<%} %>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
				value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
				value="" readonly /> <%} %>
			</td>
			<%} %>
			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
				readonly /> <input name="normalValue" type="text" size="8" value=""
				readonly /><label>-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!-- end when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->

		<!--  when result type is TEXT AREA and comparison type is NONE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
				name="<%=SUBTEST_NAME %>" type="text" size="5"
				value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
				size="2" value="" readonly /> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				name="sample" type="text"
				value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
			<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
			</td>
			<%} %>




			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
				value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
				value="" readonly /> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
				readonly /> <input name="normalValue" type="text" size="8" value=""
				readonly /><label>-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>

		<!-- end when result type is TEXT AREA and comparison type is NONE -->
		<!--  when result type is TEXT AREA and comparison type is FIXED VALUE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
				name="<%=SUBTEST_NAME %>" type="text" size="5"
				value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
				size="2" value="" readonly /> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				name="sample" type="text"
				value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
			<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
			</td>
			<%} %>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
				value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
				value="" readonly /> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
				readonly /> <input name="normalValue" type="text" size="8" value=""
				readonly /><label>-</label> <%}} %>
			</td>

			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!-- end  when result type is TEXT AREA and comparison type is FIXED VALUE -->
		<!--  when result type is Range and comparison type is NONE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>

		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
				name="<%=SUBTEST_NAME %>" type="text" size="5"
				value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
				size="2" value="" readonly /> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				name="sample" type="text"
				value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
			<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
			</td>
			<%} %>



			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
				value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
				value="" readonly /> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
				readonly /> <input name="normalValue" type="text" size="8" value=""
				readonly /><label>-</label> <%}} %>
			</td>


			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /> <%} %>
			</td>
		</tr>
		<%} %>

		<!-- when result type is RANGE and comparison type is FIXED VALUE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>

		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
				name="<%=SUBTEST_NAME %>" type="text" size="5"
				value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
				size="2" value="" readonly /> <%} %>
			</td>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				name="sample" type="text"
				value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
			<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
			</td>
			<%} %>


			<% if(deptType.equals("DIAG")){%>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
				value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
				value="" readonly /> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
				readonly /> <input name="normalValue" type="text" size="8" value=""
				readonly /><label>-</label> <%}} %>
			</td>



			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%> " readonly="readonly" /> <%}else { %>
			<input name="<%=ADDITIONAL_REMARKS %>" type="text" value=""
				readonly="readonly" /> <input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /> <%} %>
			</td>
		</tr>


		<%}
    	%>
		<%} %>
		<tbody>

		</tbody>
</table>
</div>
<!-- Table Ends --> <!--Bottom labels starts-->
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
