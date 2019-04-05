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
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.Users"%>
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
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
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
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	String deptName ="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
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
		
		}
	    MasDepartment masDepartment=new MasDepartment();
		DgResultEntryHeader dgresultHeader=new DgResultEntryHeader();
		DgResultEntryDetail dgresultDetails=new DgResultEntryDetail();
		
	 if(resultList != null){
		 dgresultHeader = (DgResultEntryHeader) resultList.get(0);
			//masDepartment = (MasDepartment) dgresultHeader.getDepartment();
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
%>

<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="sampleCollection" method="post" action="">
<h6>Result Validation</h6>
<%
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
 	}%> <label> Department</label> <label
	class="valueNoWidth" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label>
<label>Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="valueNoWidth"><%=subDept%></label>
<input name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" />
<div class="Clear"></div>
<div class="Height10"></div>
<div class="header">
<div class="paddLeft25"><label class="NoWidth">Order Date</label></div>
<%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
Time</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
No.</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
By</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
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
<label class="medium">Service Type</label> <%
				if(dgResultEntryHeader.getPatient().getServiceType() != null){
			%> <label class="valuemedium"><%=dgResultEntryHeader.getPatient().getServiceType().getServiceTypeName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Service No.</label> <%
				if(dgResultEntryHeader.getPatient().getServiceNo() != null && !(dgResultEntryHeader.getPatient().getServiceNo().equals(""))){
			%> <label class="valuemedium"><%=dgResultEntryHeader.getPatient().getServiceNo()%></label>
<%}else{ %> <label class="valuemedium">-</label> <%}%> <label class="medium">Service
Status</label> <%if(dgResultEntryHeader.getPatient().getServiceStatus() != null){
			%> <label class="valuemedium"><%= dgResultEntryHeader.getPatient().getServiceStatus().getServiceStatusName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Relation</label> <%
				if(dgResultEntryHeader.getPatient().getRelation() != null){
			%> <label class="valuemedium"><%=dgResultEntryHeader.getPatient().getRelation().getRelationName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%>
<div class="Clear"></div>
<label>Ser. Per. Name</label> <%
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
	class="medium">Rank</label> <%
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
<!--Block one Ends--> <!--Block Two Starts-->
<div class="Clear"></div>
<div style="width: 15px; height: 20px; float: left;"></div>
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
	class="value"><%=dgResultEntryHeader.getPatient().getHinNo() %></label>

<%
					String middleName = "";
					String lastName = "";
					if(dgResultEntryHeader.getPatient().getPMiddleName() != null){
						middleName = dgResultEntryHeader.getPatient().getPMiddleName();
					}
					if(dgResultEntryHeader.getPatient().getPLastName() != null){
						lastName = dgResultEntryHeader.getPatient().getPLastName();
					}
					
					%> <label>Patient Name</label> <label class="valueNoWidth"><%=dgResultEntryHeader.getPatient().getPFirstName()+" "+middleName+" "+lastName%></label>

<label class="noWidth">Sex</label> <label class="valueNoWidth"><%= dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName()%></label>
<div class="Clear"></div>
<%
		String age = "";
		String currentAge = "";
		age = dgResultEntryHeader.getPatient().getAge();
	    currentAge = HMSUtil.calculateAgeForADT(age, dgResultEntryHeader.getPatient().getRegDate());
		%> <label>Age</label> <label class="value"><%=currentAge%></label> <label>Marital
Status</label> <%
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
</div>
</div>
</div>
<div class="Clear"></div>
<!--Block Two Ends--> <script>
function inputValidate(){

obj = document.getElementById('checkId');

if(!obj.checked){;
  alert("Please Validate The Result. ")
 	}else{
			return true;
			}
				}
   
</script> <script>

function resetResult(){
	  document.getElementById('result').value="";
	   document.getElementById('additionalRemarks').value="";
	   
   }
</script>
<div class="division"></div>
<!-- Block Three Starts -->
<div class="blockTitle">Result Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="Block">
<div class="Clear"></div>
<label class="noWidth">&nbsp;&nbsp;Result Date</label> <%if(dgresultHeader.getResultDate() != null){ %>
<label class="valueNoWidth"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getResultDate()) %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <label
	class="noWidth">Result Time</label> <label class="valueNoWidth"><%=dgresultHeader.getResultTime() %></label>

<label class="noWidth">Result Prepared By:</label> <%if(dgresultHeader.getEmployee() != null) {%>
<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>"
	value="<%=dgresultHeader.getEmployee().getFirstName() %>" /> <label
	class="valueNoWidth"> <%=dgresultHeader.getEmployee().getFirstName()+" "+ dgResultEntryHeader.getEmployee().getMiddleName()+" "+ dgresultHeader.getEmployee().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="valueNoWidth">
-</label> <%} %>


<div class="Clear"></div>
<input type="hidden" name="<%=RESULT_NO %>"
	value="<%=dgResultEntryHeader.getResultNo() %>" /> <label
	class="noWidth">Result Validated Date</label> <label class="value"><%=date%></label>


<label class="noWidth">Result Validated Time</label> <label
	class="value"><%=time%></label> <label><span>*</span>Result
Validated By</label> <select id="<%=RESULT_VALIDATED_BY %>"
	name="<%= RESULT_VALIDATED_BY %>"
	validate="Result Validated By,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					if( masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
				if (userId .equals(masEmployeecode.getId())) {
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}}	}}	%>
</select>
<div class="Clear"></div>
<label>Brief Clinical Notes</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueNoWidth"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<!-- Block Three Ends -->
<div class="Clear"></div>
<!-- Table Starts -->

<div class="tableHholderCmn">
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">

	<tr>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="7%">Diag. No.</th>
		<%}else{  %>
		<th width="7%">Radio Id.</th>
		<%} %>

		<th width="7%">Service</th>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="7%">Sample</th>
		<%} %>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="10%">UOM</th>
		<%} %>
		<th width="10%">Result</th>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="10%">Normal Range</th>
		<%} %>
		<th width="4%">Validated</th>

		<% 
    for(DgResultEntryDetail dgDetail :dgResultDtSet){
    
    %>
		<tr>
			<td>
			<%if(dgDetail.getSampleCollectionDetails() != null){ %> <label
				name="<%=DIAGNOSIS_NO %>" id=<%=DIAGNOSIS_NO %> /><%=dgDetail.getSampleCollectionDetails().getDiagNo()%>
			<%} else{%> <label name="<%=DIAGNOSIS_NO %>" id=<%=DIAGNOSIS_NO %> /><%=dgDetail.getSampleCollectionDetails().getDiagNo()%>
			<%} %>
			</td>
			<td width="7%">
			<%if(dgDetail.getInvestigation() !=null){ 
              
              %> <input name="resultType" type="hidden" size="10"
				value="<%=dgDetail.getResultType() %>" readonly /> <input
				name="<%=INVESTIGATION_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getInvestigation().getId() %>" readonly /> <label
				name="chargeCode"><%=dgDetail.getInvestigation().getInvestigationName()%></label>

			<%}else { %> <label name="chargeCode">-</label> <%} %>
			</td>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td width="7%">
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample2"><%=dgDetail.getSample().getSampleDescription() %></label>
			<%}else { %> <label name="sample">-</label> <%} %>
			</td>
			<%} %>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td width="10%">
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"><%=dgDetail.getUom().getUomName() %></label>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>">-</label> <%} %>
			</td>
			<%} %>


			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		
		if(!dgDetail.getResult().contains("-")){
			/**third if **/		
			if(dgDetail.getInvestigation().getNormalValue() != null && !dgDetail.getInvestigation().getNormalValue().equals("")){
				try{
					if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getInvestigation().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else {%> <input
				name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}
				}catch(Exception e){%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}
			}else if(dgDetail.getInvestigation().getMinNormalValue() != null && !dgDetail.getInvestigation().getMinNormalValue().equals("") || dgDetail.getInvestigation().getMaxNormalValue() != null && !dgDetail.getInvestigation().getMaxNormalValue().equals("")){
				try{
					if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getInvestigation().getMinNormalValue()) || Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}%> <%}catch(Exception e){%> <input
				name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}
			}%> <!--  else of second if --> <%}else{
			String [] minMax = dgDetail.getResult().split("-");
			try{
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getInvestigation().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%}else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%}else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getInvestigation().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%}          	}catch(Exception e){%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="<%=dgDetail.getResult() %>" /> <%}%> <!--else of frst if  -->
			<% }
		}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td width="10%">
			<%if(dgDetail.getInvestigation().getNormalValue() != null || dgDetail.getInvestigation().getMinNormalValue() != null || dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getInvestigation().getNormalValue() != null ){ 
				if(!dgDetail.getInvestigation().getNormalValue().equals("")){
			%> <input name="normalValue" type="text" size="8"
				value="<%=dgDetail.getInvestigation().getNormalValue()%>" readonly />
			<%}else if (dgDetail.getInvestigation().getMinNormalValue()!= null && dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(dgDetail.getInvestigation().getMinNormalValue()!= null && dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalValue" type="text"
				size="8" value="" readonly /><label>-</label> <%} %>
			</td>
			<%} %>
			<td width="4%">
			<% if(dgDetail.getValidated() != null) {%> <input id="checkId"
				name="<%=VALIDATED %>" type="checkbox" checked="true" class="check" />
			<%}else{ %> <input id="checkId" name="<%=VALIDATED %>" type="checkbox"
				class="check" /> <%} %>
			</td>
		</tr>
</table>
</div>

<label>Additional Remarks</label> <%if(dgDetail.getRemarks() != null){ %>
<textarea value="<%=dgDetail.getRemarks() %>"
	onkeyup="chkLength(this,100);" id="<%=ADDITIONAL_REMARKS %>"
	name="<%=ADDITIONAL_REMARKS %>"></textarea> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDetail.getRemarks()%>"</script>
<%}else{ %> <textarea value="" onkeyup="chkLength(this,100);"
	id="<%=ADDITIONAL_REMARKS %>" name="<%=ADDITIONAL_REMARKS %>"></textarea>
<%} %>
<div class="Clear"></div>
<%}
   %> <!-- Table Ends -->
<div class="Height10"></div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>

<input type="button" class="button" value="Submit"
	onclick="if(inputValidate()){submitForm('sampleCollection','investigation?method=submitResultValidationForSingleParameter')};"
	align="right" /> <input name="Button" type="button" class="button"
	value="Reset" onclick="resetResult();" /></div>
<!--Bottom labels starts--></form>
<!--main content placeholder ends here--></div>